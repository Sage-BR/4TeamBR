
package com.l24team.gameserver.network.clientpackets;

/**
 * @author 4TeamBR
 */
public class RequestSiegeInfo extends L2GameClientPacket
{
	@Override
	protected void readImpl()
	{
		// trigger
	}
	
	@Override
	protected void runImpl()
	{
		// TODO this
	}
	
	@Override
	public String getType()
	{
		return "[C] 0x47 RequestSiegeInfo";
	}
}
