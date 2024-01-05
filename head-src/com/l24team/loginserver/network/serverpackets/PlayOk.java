package com.l24team.loginserver.network.serverpackets;

import com.l24team.loginserver.SessionKey;

/**
 * 4TeamBR
 */
public final class PlayOk extends L2LoginServerPacket
{
	private final int playOk1, playOk2;
	
	public PlayOk(final SessionKey sessionKey)
	{
		playOk1 = sessionKey.playOkID1;
		playOk2 = sessionKey.playOkID2;
	}
	
	@Override
	protected void write()
	{
		writeC(0x07);
		writeD(playOk1);
		writeD(playOk2);
	}
	
	@Override
	public String getType()
	{
		return "PlayOk";
	}
}
