package com.l24team.gameserver.managers;

import com.l24team.gameserver.datatables.GmListTable;
import com.l24team.gameserver.datatables.sql.AdminCommandAccessRights;
import com.l24team.gameserver.datatables.sql.ClanTable;
import com.l24team.gameserver.datatables.sql.HelperBuffTable;
import com.l24team.gameserver.datatables.xml.AugmentationData;
import com.l24team.gameserver.datatables.xml.ExperienceData;

public class DatatablesManager
{
	public static void reloadAll()
	{
		AdminCommandAccessRights.reload();
		GmListTable.reload();
		AugmentationData.reload();
		ClanTable.reload();
		HelperBuffTable.reload();
		ExperienceData.getInstance();
	}
}
