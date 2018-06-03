/*
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.config;

import java.awt.Color;

@ConfigGroup(
	keyName = "textrecolor",
	name = "Chat Text Recolor",
	description = "Configuration for chat text recoloring"
)
public interface ChatColorConfig extends Config
{
	@ConfigItem(
		position = 31,
		keyName = "opaquePublicChat",
		name = "Public chat",
		description = "Color of Public chat"
	)
	Color opaquePublicChat();

	@ConfigItem(
		position = 32,
		keyName = "opaquePublicChatHighlight",
		name = "Public chat highlight",
		description = "Color of highlights in Public chat"
	)
	default Color opaquePublicChatHighlight()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 33,
		keyName = "opaquePrivateMessageSent",
		name = "Sent private messages",
		description = "Color of Private messages you've sent"
	)
	Color opaquePrivateMessageSent();

	@ConfigItem(
		position = 34,
		keyName = "opaquePrivateMessageSentHighlight",
		name = "Sent private messages highlight",
		description = "Color of highlights in Private messages you've sent"
	)
	default Color opaquePrivateMessageSentHighlight()
	{
		return Color.decode("#002783");
	}

	@ConfigItem(
		position = 35,
		keyName = "opaquePrivateMessageReceived",
		name = "Recieved private messages",
		description = "Color of Private messages you've received"
	)
	Color opaquePrivateMessageReceived();

	@ConfigItem(
		position = 36,
		keyName = "opaquePrivateMessageReceivedHighlight",
		name = "Received private messages highlight",
		description = "Color of highlights in Private messages you've received"
	)
	default Color opaquePrivateMessageReceivedHighlight()
	{
		return Color.decode("#002783");
	}

	@ConfigItem(
		position = 37,
		keyName = "opaqueClanChatInfo",
		name = "Clan chat info",
		description = "Clan Chat Information (eg. when joining a channel)"
	)
	Color opaqueClanChatInfo();

	@ConfigItem(
		position = 38,
<<<<<<< HEAD
=======
		keyName = "opaqueClanChatInfoHighlight",
		name = "Clan chat info highlight",
		description = "Clan Chat Information highlight (used for the Raids plugin)"
	)
	default Color opaqueClanChatInfoHighlight()
	{
		return Color.decode("#EF20FF");
	}

	@ConfigItem(
		position = 39,
>>>>>>> upstream/master
		keyName = "opaqueClanChatMessage",
		name = "Clan chat message",
		description = "Color of Clan Chat Messages"
	)
	Color opaqueClanChatMessage();

	@ConfigItem(
<<<<<<< HEAD
		position = 39,
=======
		position = 40,
>>>>>>> upstream/master
		keyName = "opaqueClanChatMessageHighlight",
		name = "Clan chat message highlight",
		description = "Color of highlights in Clan Chat Messages"
	)
	default Color opaqueClanChatMessageHighlight()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 40,
=======
		position = 41,
>>>>>>> upstream/master
		keyName = "opaqueAutochatMessage",
		name = "Autochat",
		description = "Color of Autochat messages"
	)
	Color opaqueAutochatMessage();

	@ConfigItem(
<<<<<<< HEAD
		position = 41,
=======
		position = 42,
>>>>>>> upstream/master
		keyName = "opaqueAutochatMessageHighlight",
		name = "Autochat highlight",
		description = "Color of highlights in Autochat messages"
	)
	Color opaqueAutochatMessageHighlight();

	@ConfigItem(
<<<<<<< HEAD
		position = 42,
=======
		position = 43,
>>>>>>> upstream/master
		keyName = "opaqueTradeChatMessage",
		name = "Trade chat",
		description = "Color of Trade Chat Messages"
	)
	Color opaqueTradeChatMessage();

	@ConfigItem(
<<<<<<< HEAD
		position = 43,
=======
		position = 44,
>>>>>>> upstream/master
		keyName = "opaqueTradeChatMessageHighlight",
		name = "Trade chat highlight",
		description = "Color of highlights in Trade Chat Messages"
	)
	Color opaqueTradeChatMessageHighlight();

	@ConfigItem(
<<<<<<< HEAD
		position = 44,
=======
		position = 45,
>>>>>>> upstream/master
		keyName = "opaqueServerMessage",
		name = "Server message",
		description = "Color of Server Messages (eg. 'Welcome to Runescape')"
	)
	Color opaqueServerMessage();

	@ConfigItem(
<<<<<<< HEAD
		position = 45,
=======
		position = 46,
>>>>>>> upstream/master
		keyName = "opaqueServerMessageHighlight",
		name = "Server message highlight",
		description = "Color of highlights in Server Messages"
	)
	Color opaqueServerMessageHighlight();

	@ConfigItem(
<<<<<<< HEAD
		position = 46,
=======
		position = 47,
>>>>>>> upstream/master
		keyName = "opaqueGameMessage",
		name = "Game message",
		description = "Color of Game Messages"
	)
	Color opaqueGameMessage();

	@ConfigItem(
<<<<<<< HEAD
		position = 47,
=======
		position = 48,
>>>>>>> upstream/master
		keyName = "opaqueGameMessageHighlight",
		name = "Game message highlight",
		description = "Color of highlights in Game Messages"
	)
<<<<<<< HEAD
	Color opaqueGameMessageHighlight();

	@ConfigItem(
		position = 48,
=======
	default Color opaqueGameMessageHighlight()
	{
		return Color.decode("#EF1020");
	}

	@ConfigItem(
		position = 49,
>>>>>>> upstream/master
		keyName = "opaqueExamine",
		name = "Examine",
		description = "Color of Examine Text"
	)
	Color opaqueExamine();

	@ConfigItem(
<<<<<<< HEAD
		position = 49,
=======
		position = 50,
>>>>>>> upstream/master
		keyName = "opaqueExamineHighlight",
		name = "Examine Highlight",
		description = "Color of highlights in Examine Text"
	)
<<<<<<< HEAD
	Color opaqueExamineHighlight();

	@ConfigItem(
		position = 50,
=======
	default Color opaqueExamineHighlight()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 51,
>>>>>>> upstream/master
		keyName = "opaqueFiltered",
		name = "Filtered",
		description = "Color of Filtered Text (messages that aren't shown when Game messages are filtered)"
	)
	Color opaqueFiltered();

	@ConfigItem(
<<<<<<< HEAD
		position = 51,
=======
		position = 52,
>>>>>>> upstream/master
		keyName = "opaqueFilteredHighlight",
		name = "Filtered Highlight",
		description = "Color of highlights in Filtered Text"
	)
	Color opaqueFilteredHighlight();

	@ConfigItem(
<<<<<<< HEAD
		position = 52,
=======
		position = 53,
>>>>>>> upstream/master
		keyName = "opaqueUsername",
		name = "Usernames",
		description = "Color of Usernames"
	)
	Color opaqueUsername();

	@ConfigItem(
<<<<<<< HEAD
		position = 53,
=======
		position = 54,
>>>>>>> upstream/master
		keyName = "opaquePrivateUsernames",
		name = "Private chat usernames",
		description = "Color of Usernames in Private Chat"
	)
	Color opaquePrivateUsernames();

	@ConfigItem(
<<<<<<< HEAD
		position = 54,
=======
		position = 55,
>>>>>>> upstream/master
		keyName = "opaqueClanChannelName",
		name = "Chan channel Name",
		description = "Color of Clan Channel Name"
	)
	Color opaqueClanChannelName();

	@ConfigItem(
<<<<<<< HEAD
		position = 55,
=======
		position = 56,
>>>>>>> upstream/master
		keyName = "opaqueClanUsernames",
		name = "Clan usernames",
		description = "Color of Usernames in Clan Chat"
	)
	Color opaqueClanUsernames();

	@ConfigItem(
		position = 61,
		keyName = "transparentPublicChat",
		name = "Public chat (transparent)",
		description = "Color of Public chat (transparent)"
	)
	Color transparentPublicChat();

	@ConfigItem(
		position = 62,
		keyName = "transparentPublicChatHighlight",
		name = "Public chat highlight (transparent)",
		description = "Color of highlights in Public chat (transparent)"
	)
	default Color transparentPublicChatHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 63,
		keyName = "transparentPrivateMessageSent",
		name = "Sent private messages (transparent)",
		description = "Color of Private messages you've sent (transparent)"
	)
	Color transparentPrivateMessageSent();

	@ConfigItem(
		position = 64,
		keyName = "transparentPrivateMessageSentHighlight",
		name = "Sent private messages highlight (transparent)",
		description = "Color of highlights in Private messages you've sent (transparent)"
	)
	default Color transparentPrivateMessageSentHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 65,
		keyName = "transparentPrivateMessageReceived",
		name = "Received private messages (transparent)",
		description = "Color of Private messages you've received (transparent)"
	)
	Color transparentPrivateMessageReceived();

	@ConfigItem(
		position = 66,
		keyName = "transparentPrivateMessageReceivedHighlight",
		name = "Received private messages highlight (transparent)",
		description = "Color of highlights in Private messages you've received (transparent)"
	)
	default Color transparentPrivateMessageReceivedHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 67,
		keyName = "transparentClanChatInfo",
		name = "Clan chat info (transparent)",
		description = "Clan Chat Information (eg. when joining a channel) (transparent)"
	)
	Color transparentClanChatInfo();

	@ConfigItem(
		position = 68,
<<<<<<< HEAD
=======
		keyName = "transparentClanChatInfoHighlight",
		name = "Clan chat info highlight (transparent)",
		description = "Clan Chat Information highlight (used for the Raids plugin) (transparent)"
	)
	default Color transparentClanChatInfoHighlight()
	{
		return Color.decode("#EF20FF");
	}

	@ConfigItem(
		position = 69,
>>>>>>> upstream/master
		keyName = "transparentClanChatMessage",
		name = "Clan chat message (transparent)",
		description = "Color of Clan Chat Messages (transparent)"
	)
	Color transparentClanChatMessage();

	@ConfigItem(
<<<<<<< HEAD
		position = 69,
=======
		position = 70,
>>>>>>> upstream/master
		keyName = "transparentClanChatMessageHighlight",
		name = "Clan chat message highlight (transparent)",
		description = "Color of highlights in Clan Chat Messages (transparent)"
	)
	default Color transparentClanChatMessageHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 70,
=======
		position = 71,
>>>>>>> upstream/master
		keyName = "transparentAutochatMessage",
		name = "Autochat (transparent)",
		description = "Color of Autochat messages (transparent)"
	)
	Color transparentAutochatMessage();

	@ConfigItem(
<<<<<<< HEAD
		position = 71,
=======
		position = 72,
>>>>>>> upstream/master
		keyName = "transparentAutochatMessageHighlight",
		name = "Autochat highlight (transparent)",
		description = "Color of highlights in Autochat messages (transparent)"
	)
	Color transparentAutochatMessageHighlight();

	@ConfigItem(
<<<<<<< HEAD
		position = 72,
=======
		position = 73,
>>>>>>> upstream/master
		keyName = "transparentTradeChatMessage",
		name = "Trade chat (transparent)",
		description = "Color of Trade Chat Messages (transparent)"
	)
	Color transparentTradeChatMessage();

	@ConfigItem(
<<<<<<< HEAD
		position = 73,
=======
		position = 74,
>>>>>>> upstream/master
		keyName = "transparentTradeChatMessageHighlight",
		name = "Trade chat highlight (transparent)",
		description = "Color of highlights in Trade Chat Messages (transparent)"
	)
	Color transparentTradeChatMessageHighlight();

	@ConfigItem(
<<<<<<< HEAD
		position = 74,
=======
		position = 75,
>>>>>>> upstream/master
		keyName = "transparentServerMessage",
		name = "Server message (transparent)",
		description = "Color of Server Messages (eg. 'Welcome to Runescape') (transparent)"
	)
	Color transparentServerMessage();

	@ConfigItem(
<<<<<<< HEAD
		position = 75,
=======
		position = 76,
>>>>>>> upstream/master
		keyName = "transparentServerMessageHighlight",
		name = "Server message highlight (transparent)",
		description = "Color of highlights in Server Messages (transparent)"
	)
	Color transparentServerMessageHighlight();

	@ConfigItem(
<<<<<<< HEAD
		position = 76,
=======
		position = 77,
>>>>>>> upstream/master
		keyName = "transparentGameMessage",
		name = "Game message (transparent)",
		description = "Color of Game Messages (transparent)"
	)
	Color transparentGameMessage();

	@ConfigItem(
<<<<<<< HEAD
		position = 77,
=======
		position = 78,
>>>>>>> upstream/master
		keyName = "transparentGameMessageHighlight",
		name = "Game message highlight (transparent)",
		description = "Color of highlights in Game Messages (transparent)"
	)
<<<<<<< HEAD
	Color transparentGameMessageHighlight();

	@ConfigItem(
		position = 78,
=======
	default Color transparentGameMessageHighlight()
	{
		return Color.decode("#EF1020");
	}

	@ConfigItem(
		position = 79,
>>>>>>> upstream/master
		keyName = "transparentExamine",
		name = "Examine (transparent)",
		description = "Color of Examine Text (transparent)"
	)
	Color transparentExamine();

	@ConfigItem(
<<<<<<< HEAD
		position = 79,
=======
		position = 80,
>>>>>>> upstream/master
		keyName = "transparentExamineHighlight",
		name = "Examine Highlight (transparent)",
		description = "Color of highlights in Examine Text (transparent)"
	)
<<<<<<< HEAD
	Color transparentExamineHighlight();

	@ConfigItem(
		position = 80,
=======
	default Color transparentExamineHighlight()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 81,
>>>>>>> upstream/master
		keyName = "transparentFiltered",
		name = "Filtered (transparent)",
		description = "Color of Filtered Text (messages that aren't shown when Game messages are filtered) (transparent)"
	)
	Color transparentFiltered();

	@ConfigItem(
<<<<<<< HEAD
		position = 81,
=======
		position = 82,
>>>>>>> upstream/master
		keyName = "transparentFilteredHighlight",
		name = "Filtered Highlight (transparent)",
		description = "Color of highlights in Filtered Text (transparent)"
	)
	Color transparentFilteredHighlight();

	@ConfigItem(
<<<<<<< HEAD
		position = 82,
=======
		position = 83,
>>>>>>> upstream/master
		keyName = "transparentUsername",
		name = "Usernames (transparent)",
		description = "Color of Usernames (transparent)"
	)
	Color transparentUsername();

	@ConfigItem(
<<<<<<< HEAD
		position = 83,
=======
		position = 84,
>>>>>>> upstream/master
		keyName = "transparentPrivateUsernames",
		name = "Private chat usernames (transparent)",
		description = "Color of Usernames in Private Chat (transparent)"
	)
	Color transparentPrivateUsernames();

	@ConfigItem(
<<<<<<< HEAD
		position = 84,
=======
		position = 85,
>>>>>>> upstream/master
		keyName = "transparentClanChannelName",
		name = "Chan channel Name (transparent)",
		description = "Color of Clan Channel Name (transparent)"
	)
	Color transparentClanChannelName();

	@ConfigItem(
<<<<<<< HEAD
		position = 85,
=======
		position = 86,
>>>>>>> upstream/master
		keyName = "transparentClanUsernames",
		name = "Clan usernames (transparent)",
		description = "Color of Usernames in Clan Chat (transparent)"
	)
	Color transparentClanUsernames();
}
