/*
 * Copyright (c) 2018, Andrew EP | ElPinche256 <https://github.com/ElPinche256>
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
        package net.runelite.client.plugins.warindicators;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.http.api.hiscore.HiscoreResult;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.util.function.BiConsumer;

@Slf4j
@Singleton
public class WarIndicatorService
{
    private final Client client;
    private final WarIndicatorConfig config;
	String lastOpponent = null;

    @Inject
    private WarIndicatorService(Client client, WarIndicatorConfig config)
    {
        this.config = config;
        this.client = client;
    }


    public void forEachPlayer(final BiConsumer<Player, Color> consumer)
    {
        if (!config.highlightSnipes() && !config.highLightCallers() && !config.highlightOpponents())
        {
            return;
        }

        if (config.highlightSnipes())
        {
            for (Player player : client.getPlayers())
            {
                if (player == null || player.getName() == null)
                {
                    continue;
                }

                String[] targets = config.getTargetedSnipes().split(", ");

                if (targets == null)
                {
                    return;
                }

                for (int i = 0; i < targets.length; i++)
                {
                    if (player.getName().equalsIgnoreCase(targets[i]))
                    {
                        consumer.accept(player, config.getSnipeColor());
                    }
                }
            }
        }

        if (config.highLightCallers())
        {
            for (Player player : client.getPlayers())
            {
                if (player == null || player.getName() == null)
                {
                    continue;
                }

                String[] callers = config.getActiveCallers().split(", ");

                if (callers == null)
                {
                    return;
                }

                for (int i = 0; i < callers.length; i++)
                {
                    if (player.getName().equalsIgnoreCase(callers[i]))
                    {
                        consumer.accept(player, config.getCallerColor());
                    }
                }
            }
        }

        if (config.highlightOpponents())
        {
	        Actor opponent = getOpponent();

	        if (opponent == null && lastOpponent == null)
	        {
		        return;
	        }

	        if (opponent != null && opponent.getHealth() > 0)
	        {
		        if (opponent instanceof Player)
		        {
		        	lastOpponent = opponent.getName();
			        for (Player player : client.getPlayers()) {
				        if (player.getName().equalsIgnoreCase(opponent.getName()))
				        {
					        consumer.accept(player, config.getOpponentColor());
				        }
			        }
		        }
	        }

	        if (opponent == null && lastOpponent != null)
	        {
		        for (Player player : client.getPlayers()) {
			        if (player.getName().equalsIgnoreCase(lastOpponent))
			        {
				        consumer.accept(player, config.getOpponentColor());
			        }
		        }
	        }
        }
    }

    Actor getOpponent()
	{
		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		try {
			return player.getInteracting();
		}
		catch (Exception e)
		{
			return null;
		}
	}
}