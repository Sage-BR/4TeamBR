package com.l24team.gameserver.network.serverpackets;

/**
 * This class ...
 * @version $Revision: 1.3.2.1.2.3 $ $Date: 2005/03/27 15:29:57 $
 */
public class CharDeleteOk extends L2GameServerPacket
{
	@Override
	protected final void writeImpl()
	{
		writeC(0x23);
	}
	
	@Override
	public String getType()
	{
		return "[S] 23 CharDeleteOk";
	}
}
