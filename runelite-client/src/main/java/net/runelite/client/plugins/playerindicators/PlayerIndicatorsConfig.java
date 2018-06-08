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
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import javax.inject.Inject;

@ConfigGroup(
		keyName = "playerindicators",
		name = "Player Indicators",
		description = "Configuration for the player indicators plugin"
)
public interface PlayerIndicatorsConfig extends Config
{

	@ConfigItem(
			position = 0,
			keyName = "drawOwnName",
			name = "Highlight own player",
			description = "Configures whether or not your own player should be highlighted"
	)
	default boolean highlightOwnPlayer()
	{
		return false;
	}

	@ConfigItem(
			position = 1,
			keyName = "ownNameColor",
			name = "Own player color",
			description = "Color of your own player"
	)
	default Color getOwnPlayerColor()
	{
		return new Color(0, 184, 212);
	}

	@ConfigItem(
			position = 2,
			keyName = "drawFriendNames",
			name = "Highlight friends",
			description = "Configures whether or not friends should be highlighted"
	)
	default boolean highlightFriends()
	{
		return true;
	}

	@ConfigItem(
			position = 3,
			keyName = "friendNameColor",
			name = "Friend color",
			description = "Color of friend names"
	)
	default Color getFriendColor()
	{
		return new Color(0, 200, 83);
	}

	@ConfigItem(
			position = 4,
			keyName = "drawClanMemberNames",
			name = "Highlight clan members",
			description = "Configures whether or clan members should be highlighted"
	)
	default boolean drawClanMemberNames()
	{
		return true;
	}

	@ConfigItem(
			position = 5,
			keyName = "clanMemberColor",
			name = "Clan member color",
			description = "Color of clan members"
	)
	default Color getClanMemberColor()
	{
		return new Color(170, 0, 255);
	}

	@ConfigItem(
			position = 6,
			keyName = "drawTeamMemberNames",
			name = "Highlight team members",
			description = "Configures whether or not team members should be highlighted"
	)
	default boolean highlightTeamMembers()
	{
		return true;
	}

	@ConfigItem(
			position = 7,
			keyName = "teamMemberColor",
			name = "Team member color",
			description = "Color of team members"
	)
	default Color getTeamMemberColor()
	{
		return new Color(19, 110, 247);
	}

	@ConfigItem(
			position = 8,
			keyName = "drawNonClanMemberNames",
			name = "Highlight non-clan members",
			description = "Configures whether or not non-clan members should be highlighted"
	)
	default boolean highlightNonClanMembers()
	{
		return false;
	}

	@ConfigItem(
			position = 9,
			keyName = "nonClanMemberColor",
			name = "Non-clan member color",
			description = "Color of non-clan member names"
	)
	default Color getNonClanMemberColor()
	{
		return Color.RED;
	}

	@ConfigItem(
			position = 10,
			keyName = "hideNonAttackablePlayers",
			name = "Hide Non-Attackable Players",
			description = "Configures whether or not to highlight only players within your combat limit"
	)
	default boolean hideNAP()
	{
		return false;
	}

	@ConfigItem(
			position = 11,
			keyName = "drawPlayerTiles",
			name = "Draw tiles under players",
			description = "Configures whether or not tiles under highlighted players should be drawn"
	)
	default boolean drawTiles()
	{
		return false;
	}

	@ConfigItem(
			position = 12,
			keyName = "drawOverheadPlayerNames",
			name = "Draw names above players",
			description = "Configures whether or not player names should be drawn above players"
	)
	default boolean drawOverheadPlayerNames()
	{
		return true;
	}

	@ConfigItem(
			position = 13,
			keyName = "drawMinimapNames",
			name = "Draw names on minimap",
			description = "Configures whether or not minimap names for players with rendered names should be drawn"
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	@ConfigItem(
			position = 14,
			keyName = "colorPlayerMenu",
			name = "Colorize player menu",
			description = "Color right click menu for players"
	)
	default boolean colorPlayerMenu()
	{
		return true;
	}

	@ConfigItem(
			position = 15,
			keyName = "clanMenuIcons",
			name = "Show clan ranks",
			description = "Add clan rank to right click menu and next to player names"
	)
	default boolean showClanRanks()
	{
		return true;
	}

	@ConfigItem(
			position = 16,
			keyName = "highlightCallers",
			name = "Highlight Callers",
			description = "Highlight listed caller(s)"
	)
	default boolean highlightCallers()
	{
		return true;
	}

	@ConfigItem(
			position = 17,
			keyName = "callerColor",
			name = "Caller(s) Color",
			description = "Color to highlight caller's name"
	)
	default Color getCallerColor()
	{
		return new Color(36, 255, 237);
	}

	@ConfigItem(
			position = 18,
			keyName = "callerMinimap",
			name = "Callers on Minimap",
			description = "Show your caller(s) on the minimap"
	)
	default boolean callerMinimap()
	{
		return false;
	}


	@ConfigItem(
			position = 19,
			keyName = "callerTile",
			name = "Show Caller's Tile",
			description = "Show the tile your target is standing on"
	)
	default boolean callerTile()
	{
		return false;
	}

	@ConfigItem(
			position = 20,
			keyName = "activeCallers",
			name = "Callers",
			description = "Adds a user to your caller list. Format: (caller), (caller)"
	)
	default String getActiveCallers()
	{
		return "";
	}


	@ConfigItem(
			position = 21,
			keyName = "highlightSnipes",
			name = "Highlight Targets",
			description = "Highlight listed target(s)"
	)
	default boolean highlightSnipes()
	{
		return true;
	}

	@ConfigItem(
			position = 22,
			keyName = "snipeColor",
			name = "Target(s) Color",
			description = "Color to highlight target name"
	)
	default Color getSnipeColor()
	{
		return new Color(255, 0, 0);
	}

	@ConfigItem(
			position = 23,
			keyName = "snipeMinimap",
			name = "Targets on Minimap",
			description = "Show your target on the minimap"
	)
	default boolean snipeMinimap()
	{
		return false;
	}

	@ConfigItem(
			position = 24,
			keyName = "snipeTile",
			name = "Show Target's Tile",
			description = "Show the tile your target is standing on"
	)
	default boolean snipeTile()
	{
		return false;
	}

	@ConfigItem(
			position = 25,
			keyName = "targetedSnipes",
			name = "Targets",
			description = "Adds a user to your snipe list. Format: (target), (target)"
	)
	default String getTargetedSnipes()
	{
		return "";
	}

	@ConfigItem(
			position = 26,
			keyName = "highlightOpponents",
			name = "Highlight Opponent",
			description = "Highlight the current target you are focusing"
	)
	default boolean highlightOpponents()
	{
		return true;
	}

	@ConfigItem(
			position = 27,
			keyName = "opponentColor",
			name = "Opponents(s) Color",
			description = "Color to highlight the current target"
	)
	default Color getOpponentColor()
	{
		return new Color(0, 123, 255);
	}

	@ConfigItem(
			position = 28,
			keyName = "opponentMinimap",
			name = "Opponent on Minimap",
			description = "Show your current target on the minimap"
	)
	default boolean opponentMinimap()
	{
		return false;
	}

	@ConfigItem(
			position = 29,
			keyName = "opponentTile",
			name = "Show Opponent's Tile",
			description = "Show the tile your current opponent is standing on"
	)
	default boolean opponentTile()
	{
		return false;
	}
}