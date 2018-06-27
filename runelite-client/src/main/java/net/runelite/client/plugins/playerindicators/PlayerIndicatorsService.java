/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.playerindicators;

import java.awt.Color;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gson.Gson;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.WorldType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@Singleton
public class PlayerIndicatorsService
{
	private final Client client;
	private final PlayerIndicatorsConfig config;

	public static final Gson GSON = new Gson();
	public String cslAPI = "http://localhost";
	public String callerListAPI = "";
	public String snipeListAPI = "";

	private String lastOpponent = null;

	@Inject
	private PlayerIndicatorsService(Client client, PlayerIndicatorsConfig config)
	{
		this.config = config;
		this.client = client;
	}

	public void forEachPlayer(final BiConsumer<Player, Color> consumer)
	{
		if (!config.highlightOwnPlayer() && !config.drawClanMemberNames()
				&& !config.highlightFriends() && !config.highlightNonClanMembers()
				&& !config.highlightCallers() && !config.highlightSnipes()
				&& !config.highlightOpponents())
		{
			return;
		}

		final Player localPlayer = client.getLocalPlayer();

		for (Player player : client.getPlayers())
		{
			if (player == null || player.getName() == null)
			{
				return;
			}

			boolean isClanMember = player.isClanMember();

			if (config.highlightCallers())
			{
				String[] callers = config.getActiveCallers().split(", ");
				if (callers == null || callers.length < 1)
				{
					return;
				}
				else
				{
					for (int i = 0; i < callers.length; i++)
					{
						if (player.getName().equalsIgnoreCase(callers[i]))
						{
							consumer.accept(player, config.getCallerColor());
						}
					}
				}
			}

			if (config.highlightSnipes())
			{
				String[] snipes = config.getTargetedSnipes().split(", ");
				if (snipes == null || snipes.length < 1)
				{
					return;
				}
				else
				{
					for (int i = 0; i < snipes.length; i++)
					{
						if (player.getName().equalsIgnoreCase(snipes[i]))
						{
							consumer.accept(player, config.getCallerColor());
						}
					}
				}
			}

			if (player == localPlayer)
			{
				if (config.highlightOwnPlayer())
				{
					consumer.accept(player, config.getOwnPlayerColor());
				}
			}
			else if (config.highlightFriends() && player.isFriend())
			{
				consumer.accept(player, config.getFriendColor());
			}
			else if (config.drawClanMemberNames() && isClanMember)
			{
				consumer.accept(player, config.getClanMemberColor());
			}
			else if (config.highlightTeamMembers() && localPlayer.getTeam() > 0 && localPlayer.getTeam() == player.getTeam())
			{
				consumer.accept(player, config.getTeamMemberColor());
			}
			else if (config.highlightNonClanMembers() && !isClanMember && !config.hideNAP())
			{
				consumer.accept(player, config.getNonClanMemberColor());
			}
			else if (config.highlightNonClanMembers() && !isClanMember && config.hideNAP())
			{
				if (canAttack(player.getCombatLevel()))
				{
					consumer.accept(player, config.getNonClanMemberColor());
				}
			}
			else if (config.highlightOpponents())
			{
				try
				{
					Actor opponent = getOpponent();

					if (opponent == null && lastOpponent == null)
					{
						continue;
					}

					if (opponent != null && opponent.getHealth() > 0)
					{
						if (opponent instanceof Player)
						{
							lastOpponent = opponent.getName();
							if (player.getName().equalsIgnoreCase(opponent.getName()))
							{
								consumer.accept(player, config.getOpponentColor());
							}
						}
					}
					else if (opponent == null && lastOpponent != null)
					{
						if (player.getName().equalsIgnoreCase(lastOpponent))
						{
							consumer.accept(player, config.getOpponentColor());
						}
					}
				}
				catch (Exception e)
				{
					continue;
				}
			}
		}
	}

	public void loadCslAPI()
	{
		callerListAPI = GSON.toJson(cslAPI + "/localhost/api/public/callers");
		snipeListAPI = GSON.toJson(cslAPI + "/localhost/api/public/snipes");
	}

	public boolean canAttack(Integer target)
	{
		if (!client.getWorldType().contains(WorldType.PVP)
				&& !client.getWorldType().contains(WorldType.PVP_HIGH_RISK)
				&& !isWidgetVisible(client.getWidget(WidgetInfo.WILDERNESS_CONTAINER)))
		{
			return false;
		}

		int combat = client.getLocalPlayer().getCombatLevel();

		if (client.getWorldType().contains(WorldType.PVP)
				|| client.getWorldType().contains(WorldType.PVP_HIGH_RISK))
		{
			int minimumP = (combat - 15);
			int maximumP = (combat + 15);
			if (target <= maximumP && target >= minimumP)
			{
				return true;
			}
		}
		else if (isWidgetVisible(client.getWidget(WidgetInfo.WILDERNESS_CONTAINER)))
		{
			int wildLvl;
			try
			{
				wildLvl = Integer.valueOf(client.getWidget(WidgetInfo.WILDERNESS_LEVEL).getText().replace("Level: ", ""));
			}
			catch (Exception e)
			{
				wildLvl = 99;
			}

			if (wildLvl != 99)
			{
				int minimumW = (combat - wildLvl) <= 3 ? 3 : combat - wildLvl;
				int maximumW = (combat + wildLvl) >= 126 ? 126 : combat + wildLvl;

				if (target <= maximumW && target >= minimumW)
				{
					return true;
				}
			}
		}

		return false;
	}

	Actor getOpponent()
	{
		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		try
		{
			return player.getInteracting();
		}
		catch (Exception e)
		{
			return null;
		}
	}

	private boolean isWidgetVisible(Widget widget)
	{
		return widget != null && !widget.isHidden();
	}
}