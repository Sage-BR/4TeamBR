package com.l24team.gameserver.network.clientpackets;

import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.serverpackets.ActionFailed;
import com.l24team.gameserver.network.serverpackets.UserInfo;

/**
 * Appearing Packet Handler
 */
public final class Appearing extends L2GameClientPacket
{
	@Override
	protected void readImpl()
	{
	}
	
	@Override
	protected void runImpl()
	{
		final L2PcInstance activeChar = getClient().getActiveChar();
		
		if (activeChar == null || !activeChar.isOnline())
		{
			sendPacket(ActionFailed.STATIC_PACKET);
			return;
		}
		
		if (activeChar.isTeleporting())
		{
			activeChar.onTeleported();
		}
		
		sendPacket(new UserInfo(activeChar));
	}
	
	@Override
	public String getType()
	{
		return "[C] 30 Appearing";
	}
}