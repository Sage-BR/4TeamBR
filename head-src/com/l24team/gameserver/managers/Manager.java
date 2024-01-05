package com.l24team.gameserver.managers;

import com.l24team.Config;

public class Manager
{
	public static void reloadAll()
	{
		AuctionManager.getInstance().reload();
		
		if (!Config.ALT_DEV_NO_QUESTS)
		{
			QuestManager.getInstance();
			QuestManager.reload();
		}
		
	}
}
