package com.l24team.gameserver.handler.admincommandhandlers;

import com.l24team.gameserver.communitybbs.Manager.AdminBBSManager;
import com.l24team.gameserver.handler.IAdminCommandHandler;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;

public class AdminBBS implements IAdminCommandHandler
{
	// private static Logger LOGGER = Logger.getLogger(AdminKick.class);
	private static final String[] ADMIN_COMMANDS =
	{
		"admin_bbs"
	};
	
	@Override
	public boolean useAdminCommand(final String command, final L2PcInstance activeChar)
	{
		AdminBBSManager.getInstance().parsecmd(command, activeChar);
		return true;
	}
	
	@Override
	public String[] getAdminCommandList()
	{
		return ADMIN_COMMANDS;
	}
}
