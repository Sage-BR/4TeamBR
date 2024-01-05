package com.l24team.gameserver.handler.usercommandhandlers;

import com.l24team.gameserver.handler.IUserCommandHandler;
import com.l24team.gameserver.model.L2CommandChannel;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.serverpackets.ExMultiPartyCommandChannelInfo;

/**
 * @author chris_00 when User press the "List Update" button in CCInfo window
 */
public class ChannelListUpdate implements IUserCommandHandler
{
	private static final int[] COMMAND_IDS =
	{
		97
	};
	
	@Override
	public boolean useUserCommand(final int id, final L2PcInstance activeChar)
	{
		if ((id != COMMAND_IDS[0]) || (activeChar == null) || activeChar.getParty() == null || activeChar.getParty().getCommandChannel() == null)
		{
			return false;
		}
		
		final L2CommandChannel channel = activeChar.getParty().getCommandChannel();
		
		activeChar.sendPacket(new ExMultiPartyCommandChannelInfo(channel));
		return true;
	}
	
	@Override
	public int[] getUserCommandList()
	{
		return COMMAND_IDS;
	}
}
