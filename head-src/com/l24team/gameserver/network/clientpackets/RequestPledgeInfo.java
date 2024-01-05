package com.l24team.gameserver.network.clientpackets;

import org.apache.log4j.Logger;

import com.l24team.Config;
import com.l24team.gameserver.datatables.sql.ClanTable;
import com.l24team.gameserver.model.L2Clan;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.serverpackets.PledgeInfo;

public final class RequestPledgeInfo extends L2GameClientPacket
{
	private static Logger LOGGER = Logger.getLogger(RequestPledgeInfo.class);
	
	private int clanId;
	
	@Override
	protected void readImpl()
	{
		clanId = readD();
	}
	
	@Override
	protected void runImpl()
	{
		if (Config.DEBUG)
		{
			LOGGER.debug("infos for clan " + clanId + " requested");
		}
		
		final L2PcInstance activeChar = getClient().getActiveChar();
		final L2Clan clan = ClanTable.getInstance().getClan(clanId);
		
		if (activeChar == null)
		{
			return;
		}
		
		if (clan == null)
		{
			if (Config.DEBUG && clanId > 0)
			{
				LOGGER.debug("Clan data for clanId " + clanId + " is missing for player " + activeChar.getName());
			}
			return; // we have no clan data ?!? should not happen
		}
		activeChar.sendPacket(new PledgeInfo(clan));
	}
	
	@Override
	public String getType()
	{
		return "[C] 66 RequestPledgeInfo";
	}
}
