package com.l24team.gameserver.network.clientpackets;

import com.l24team.gameserver.managers.CastleManager;
import com.l24team.gameserver.managers.FortManager;
import com.l24team.gameserver.model.entity.siege.Castle;
import com.l24team.gameserver.model.entity.siege.Fort;
import com.l24team.gameserver.network.serverpackets.FortSiegeAttackerList;
import com.l24team.gameserver.network.serverpackets.SiegeAttackerList;

/**
 * @author programmos
 */
public final class RequestSiegeAttackerList extends L2GameClientPacket
{
	private int castleId;
	
	@Override
	protected void readImpl()
	{
		castleId = readD();
	}
	
	@Override
	protected void runImpl()
	{
		if (castleId < 100)
		{
			final Castle castle = CastleManager.getInstance().getCastleById(castleId);
			
			if (castle == null)
			{
				return;
			}
			
			final SiegeAttackerList sal = new SiegeAttackerList(castle);
			sendPacket(sal);
		}
		else
		{
			final Fort fort = FortManager.getInstance().getFortById(castleId);
			
			if (fort == null)
			{
				return;
			}
			
			final FortSiegeAttackerList sal = new FortSiegeAttackerList(fort);
			sendPacket(sal);
		}
	}
	
	@Override
	public String getType()
	{
		return "[C] a2 RequestSiegeAttackerList";
	}
}
