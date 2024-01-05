package com.l24team.gameserver.updaters;

import org.apache.log4j.Logger;

import com.l24team.Config;
import com.l24team.gameserver.managers.CastleManager;
import com.l24team.gameserver.model.ItemContainer;
import com.l24team.gameserver.model.L2Clan;
import com.l24team.gameserver.model.entity.siege.Castle;
import com.l24team.gameserver.thread.ThreadPoolManager;
import com.l24team.logs.Log;

/**
 * Thorgrim - 2005 Class managing periodical events with castle
 */
public class CastleUpdater implements Runnable
{
	protected static Logger LOGGER = Logger.getLogger(CastleUpdater.class);
	private final L2Clan clan;
	private int runCount = 0;
	
	public CastleUpdater(final L2Clan clan, final int runCount)
	{
		this.clan = clan;
		this.runCount = runCount;
	}
	
	@Override
	public void run()
	{
		try
		{
			// Move current castle treasury to clan warehouse every 2 hour
			ItemContainer warehouse = clan.getWarehouse();
			if (warehouse != null && clan.getCastleId() > 0)
			{
				final Castle castle = CastleManager.getInstance().getCastleById(clan.getCastleId());
				if (!Config.ALT_MANOR_SAVE_ALL_ACTIONS)
				{
					if (runCount % Config.ALT_MANOR_SAVE_PERIOD_RATE == 0)
					{
						castle.saveSeedData();
						castle.saveCropData();
						final String text = "Manor System: all data for " + castle.getName() + " saved";
						Log.add(text, "Manor_system");
					}
				}
				
				runCount++;
				final CastleUpdater cu = new CastleUpdater(clan, runCount);
				ThreadPoolManager.getInstance().scheduleGeneral(cu, 3600000);
				warehouse = null;
			}
		}
		catch (final Throwable e)
		{
			e.printStackTrace();
		}
	}
}
