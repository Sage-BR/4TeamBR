package com.l24team.gameserver.network.serverpackets;

import com.l24team.gameserver.model.actor.instance.L2BoatInstance;

/**
 * @author Maktakien
 */
public class VehicleInfo extends L2GameServerPacket
{
	private final L2BoatInstance boat;
	
	public VehicleInfo(final L2BoatInstance boat)
	{
		this.boat = boat;
	}
	
	@Override
	protected void writeImpl()
	{
		writeC(0x59);
		writeD(boat.getObjectId());
		writeD(boat.getX());
		writeD(boat.getY());
		writeD(boat.getZ());
		writeD(boat.getPosition().getHeading());
		
	}
	
	@Override
	public String getType()
	{
		return "[S] 59 VehicleInfo";
	}
}
