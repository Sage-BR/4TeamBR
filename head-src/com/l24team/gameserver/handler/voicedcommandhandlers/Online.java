package com.l24team.gameserver.handler.voicedcommandhandlers;

import com.l24team.gameserver.handler.IVoicedCommandHandler;
import com.l24team.gameserver.model.L2World;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;

public class Online implements IVoicedCommandHandler
{
	private static String[] voicedCommands =
	{
		"online"
	};
	
	@Override
	public boolean useVoicedCommand(final String command, final L2PcInstance activeChar, final String target)
	{
		if (command.equalsIgnoreCase("online"))
		{
			activeChar.sendMessage("======<Players Online!>======");
			activeChar.sendMessage("There are " + L2World.getInstance().getAllPlayers().size() + " players online!.");
			activeChar.sendMessage("=======================");
		}
		return true;
	}
	
	@Override
	public String[] getVoicedCommandList()
	{
		return voicedCommands;
	}
}
