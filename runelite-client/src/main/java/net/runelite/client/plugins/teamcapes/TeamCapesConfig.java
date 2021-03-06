/*
 * Copyright (c) 2018, Mathieu Bernier <https://github.com/Matsyir>
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
package net.runelite.client.plugins.teamcapes;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "teamCapes",
		name = "Team Capes",
		description = "Configuration for the team cape plugin"
)
public interface TeamCapesConfig extends Config
{

	@ConfigItem(
    position = 0,
		keyName = "minimumCapeCount",
  	name = "Minimum Cape Count",
    description = "Configures the minimum number of team capes which must be present before being displayed."
	)
	default int getMinimumCapeCount()
	{
		return 5;
	}

	@ConfigItem(
			position = 1,
			keyName = "customCapeNames",
			name = "Custom Cape Names",
			description = "Displays a custom team cape name.The format is cape#=TEAM NAME (comma seperated) Example: \"26=Intense Redemption, 30=FOE\""
	)
	default String getCustomCapeNames()
	{
		return "26=IR, 18=AAO, 38=APEX, 49=DOOM, 50=EOP, 37=FI, 47=FS, 30=FOE, 20=MF, 27=OB, 46=DeadBirds, 10=SF, 17=SUP, 39=ENVY";
	}

	@ConfigItem(
			keyName = "customCapeNames",
			name = "",
			description = ""
	)
	void setCustomCapeNames(String key);
}