package com.l24team.loginserver.network.loginserverpackets;

import com.l24team.gameserver.datatables.GameServerTable;
import com.l24team.loginserver.network.serverpackets.ServerBasePacket;

/**
 * @author -Wooden-
 */
public class AuthResponse extends ServerBasePacket
{
	/**
	 * @param serverId
	 */
	public AuthResponse(final int serverId)
	{
		writeC(0x02);
		writeC(serverId);
		writeS(GameServerTable.getInstance().getServerNameById(serverId));
	}
	
	@Override
	public byte[] getContent()
	{
		return getBytes();
	}
}
