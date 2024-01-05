package com.l24team.gameserver.network.serverpackets;

import com.l24team.gameserver.model.L2Character;

/**
 * format dd
 * @version $Revision: 1.3.2.1.2.3 $ $Date: 2005/03/27 15:29:57 $
 */
public class FinishRotation extends L2GameServerPacket
{
	private final int heading;
	private final int charObjId;
	
	public FinishRotation(final L2Character cha)
	{
		charObjId = cha.getObjectId();
		heading = cha.getHeading();
	}
	
	@Override
	protected final void writeImpl()
	{
		writeC(0x63);
		writeD(charObjId);
		writeD(heading);
	}
	
	@Override
	public String getType()
	{
		return "[S] 63 FinishRotation";
	}
}
