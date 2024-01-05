package com.l24team.gameserver.handler.admincommandhandlers;

import com.l24team.gameserver.handler.IAdminCommandHandler;
import com.l24team.gameserver.model.L2World;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;

public class AdminWho implements IAdminCommandHandler
{
	private static final String[] ADMIN_COMMANDS =
	{
		"admin_who"
	};
	
	@Override
	public boolean useAdminCommand(final String command, final L2PcInstance activeChar)
	{
		if (command.equalsIgnoreCase("admin_who"))
		{
			activeChar.sendMessage("SYS: current(" + L2World.getInstance().getAllPlayers().size() + "), playing(" + L2World.getInstance().getAllPlayers().size() + ")");
		}
		return true;
	}
	
	@Override
	public String[] getAdminCommandList()
	{
		return ADMIN_COMMANDS;
	}
}