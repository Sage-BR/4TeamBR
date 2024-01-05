package com.l24team.gameserver.handler.usercommandhandlers;

import com.l24team.gameserver.handler.IUserCommandHandler;
import com.l24team.gameserver.model.L2CommandChannel;
import com.l24team.gameserver.model.L2Party;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.SystemMessageId;
import com.l24team.gameserver.network.serverpackets.SystemMessage;

/**
 * @author Chris
 */
public class ChannelLeave implements IUserCommandHandler
{
	private static final int[] COMMAND_IDS =
	{
		96
	};
	
	@Override
	public boolean useUserCommand(final int id, final L2PcInstance activeChar)
	{
		if ((id != COMMAND_IDS[0]) || (activeChar == null))
		{
			return false;
		}
		
		if (activeChar.isInParty())
		{
			if (activeChar.getParty().isLeader(activeChar) && activeChar.getParty().isInCommandChannel())
			{
				L2CommandChannel channel = activeChar.getParty().getCommandChannel();
				L2Party party = activeChar.getParty();
				channel.removeParty(party);
				
				party.getLeader().sendPacket(new SystemMessage(SystemMessageId.LEFT_COMMAND_CHANNEL));
				channel.broadcastToChannelMembers(new SystemMessage(SystemMessageId.S1_PARTY_LEFT_COMMAND_CHANNEL).addString(party.getLeader().getName()));
				
				party = null;
				channel = null;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int[] getUserCommandList()
	{
		return COMMAND_IDS;
	}
}
