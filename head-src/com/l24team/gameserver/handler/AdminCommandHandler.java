package com.l24team.gameserver.handler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.l24team.Config;
import com.l24team.gameserver.datatables.sql.AdminCommandAccessRights;
import com.l24team.gameserver.handler.admincommandhandlers.AdminAdmin;
import com.l24team.gameserver.handler.admincommandhandlers.AdminAio;
import com.l24team.gameserver.handler.admincommandhandlers.AdminAnnouncements;
import com.l24team.gameserver.handler.admincommandhandlers.AdminBBS;
import com.l24team.gameserver.handler.admincommandhandlers.AdminBan;
import com.l24team.gameserver.handler.admincommandhandlers.AdminBoat;
import com.l24team.gameserver.handler.admincommandhandlers.AdminBuffs;
import com.l24team.gameserver.handler.admincommandhandlers.AdminCache;
import com.l24team.gameserver.handler.admincommandhandlers.AdminChangeAccessLevel;
import com.l24team.gameserver.handler.admincommandhandlers.AdminCharSupervision;
import com.l24team.gameserver.handler.admincommandhandlers.AdminChristmas;
import com.l24team.gameserver.handler.admincommandhandlers.AdminClanHall;
import com.l24team.gameserver.handler.admincommandhandlers.AdminCreateItem;
import com.l24team.gameserver.handler.admincommandhandlers.AdminCursedWeapons;
import com.l24team.gameserver.handler.admincommandhandlers.AdminDelete;
import com.l24team.gameserver.handler.admincommandhandlers.AdminDoorControl;
import com.l24team.gameserver.handler.admincommandhandlers.AdminEditChar;
import com.l24team.gameserver.handler.admincommandhandlers.AdminEditNpc;
import com.l24team.gameserver.handler.admincommandhandlers.AdminEffects;
import com.l24team.gameserver.handler.admincommandhandlers.AdminEnchant;
import com.l24team.gameserver.handler.admincommandhandlers.AdminEventEngine;
import com.l24team.gameserver.handler.admincommandhandlers.AdminExpSp;
import com.l24team.gameserver.handler.admincommandhandlers.AdminFightCalculator;
import com.l24team.gameserver.handler.admincommandhandlers.AdminFortSiege;
import com.l24team.gameserver.handler.admincommandhandlers.AdminGeodata;
import com.l24team.gameserver.handler.admincommandhandlers.AdminGm;
import com.l24team.gameserver.handler.admincommandhandlers.AdminGmChat;
import com.l24team.gameserver.handler.admincommandhandlers.AdminHeal;
import com.l24team.gameserver.handler.admincommandhandlers.AdminHelpPage;
import com.l24team.gameserver.handler.admincommandhandlers.AdminInvul;
import com.l24team.gameserver.handler.admincommandhandlers.AdminKick;
import com.l24team.gameserver.handler.admincommandhandlers.AdminKill;
import com.l24team.gameserver.handler.admincommandhandlers.AdminLevel;
import com.l24team.gameserver.handler.admincommandhandlers.AdminLogin;
import com.l24team.gameserver.handler.admincommandhandlers.AdminMammon;
import com.l24team.gameserver.handler.admincommandhandlers.AdminManor;
import com.l24team.gameserver.handler.admincommandhandlers.AdminMassControl;
import com.l24team.gameserver.handler.admincommandhandlers.AdminMassRecall;
import com.l24team.gameserver.handler.admincommandhandlers.AdminMenu;
import com.l24team.gameserver.handler.admincommandhandlers.AdminMobGroup;
import com.l24team.gameserver.handler.admincommandhandlers.AdminMonsterRace;
import com.l24team.gameserver.handler.admincommandhandlers.AdminNoble;
import com.l24team.gameserver.handler.admincommandhandlers.AdminPForge;
import com.l24team.gameserver.handler.admincommandhandlers.AdminPetition;
import com.l24team.gameserver.handler.admincommandhandlers.AdminPledge;
import com.l24team.gameserver.handler.admincommandhandlers.AdminPolymorph;
import com.l24team.gameserver.handler.admincommandhandlers.AdminQuest;
import com.l24team.gameserver.handler.admincommandhandlers.AdminReload;
import com.l24team.gameserver.handler.admincommandhandlers.AdminRepairChar;
import com.l24team.gameserver.handler.admincommandhandlers.AdminRes;
import com.l24team.gameserver.handler.admincommandhandlers.AdminRideWyvern;
import com.l24team.gameserver.handler.admincommandhandlers.AdminScript;
import com.l24team.gameserver.handler.admincommandhandlers.AdminShop;
import com.l24team.gameserver.handler.admincommandhandlers.AdminShutdown;
import com.l24team.gameserver.handler.admincommandhandlers.AdminSiege;
import com.l24team.gameserver.handler.admincommandhandlers.AdminSkill;
import com.l24team.gameserver.handler.admincommandhandlers.AdminSpawn;
import com.l24team.gameserver.handler.admincommandhandlers.AdminTarget;
import com.l24team.gameserver.handler.admincommandhandlers.AdminTeleport;
import com.l24team.gameserver.handler.admincommandhandlers.AdminTest;
import com.l24team.gameserver.handler.admincommandhandlers.AdminTownWar;
import com.l24team.gameserver.handler.admincommandhandlers.AdminWho;
import com.l24team.gameserver.handler.admincommandhandlers.AdminZone;

public class AdminCommandHandler
{
	protected static final Logger LOGGER = Logger.getLogger(AdminCommandHandler.class);
	private static AdminCommandHandler instance;
	private Map<String, IAdminCommandHandler> dataTable = new HashMap<>();
	
	public static AdminCommandHandler getInstance()
	{
		if (instance == null)
		{
			instance = new AdminCommandHandler();
		}
		return instance;
	}
	
	private AdminCommandHandler()
	{
		registerAdminCommandHandler(new AdminAdmin());
		registerAdminCommandHandler(new AdminAio());
		registerAdminCommandHandler(new AdminAnnouncements());
		registerAdminCommandHandler(new AdminBBS());
		registerAdminCommandHandler(new AdminBan());
		registerAdminCommandHandler(new AdminBoat());
		registerAdminCommandHandler(new AdminBuffs());
		registerAdminCommandHandler(new AdminCache());
		registerAdminCommandHandler(new AdminChangeAccessLevel());
		registerAdminCommandHandler(new AdminCharSupervision());
		registerAdminCommandHandler(new AdminChristmas());
		registerAdminCommandHandler(new AdminClanHall());
		registerAdminCommandHandler(new AdminCreateItem());
		registerAdminCommandHandler(new AdminCursedWeapons());
		registerAdminCommandHandler(new AdminDelete());
		registerAdminCommandHandler(new AdminDoorControl());
		registerAdminCommandHandler(new AdminEditChar());
		registerAdminCommandHandler(new AdminEditNpc());
		registerAdminCommandHandler(new AdminEffects());
		registerAdminCommandHandler(new AdminEnchant());
		registerAdminCommandHandler(new AdminEventEngine());
		registerAdminCommandHandler(new AdminExpSp());
		registerAdminCommandHandler(new AdminFightCalculator());
		registerAdminCommandHandler(new AdminFortSiege());
		registerAdminCommandHandler(new AdminGeodata());
		registerAdminCommandHandler(new AdminGm());
		registerAdminCommandHandler(new AdminGmChat());
		registerAdminCommandHandler(new AdminHeal());
		registerAdminCommandHandler(new AdminHelpPage());
		registerAdminCommandHandler(new AdminInvul());
		registerAdminCommandHandler(new AdminKick());
		registerAdminCommandHandler(new AdminKill());
		registerAdminCommandHandler(new AdminLevel());
		registerAdminCommandHandler(new AdminLogin());
		registerAdminCommandHandler(new AdminMammon());
		registerAdminCommandHandler(new AdminManor());
		registerAdminCommandHandler(new AdminMassControl());
		registerAdminCommandHandler(new AdminMassRecall());
		registerAdminCommandHandler(new AdminMenu());
		registerAdminCommandHandler(new AdminMobGroup());
		registerAdminCommandHandler(new AdminMonsterRace());
		registerAdminCommandHandler(new AdminNoble());
		registerAdminCommandHandler(new AdminPForge());
		registerAdminCommandHandler(new AdminPetition());
		registerAdminCommandHandler(new AdminPledge());
		registerAdminCommandHandler(new AdminPolymorph());
		registerAdminCommandHandler(new AdminQuest());
		registerAdminCommandHandler(new AdminReload());
		registerAdminCommandHandler(new AdminRepairChar());
		registerAdminCommandHandler(new AdminRes());
		registerAdminCommandHandler(new AdminRideWyvern());
		registerAdminCommandHandler(new AdminScript());
		registerAdminCommandHandler(new AdminShop());
		registerAdminCommandHandler(new AdminShutdown());
		registerAdminCommandHandler(new AdminSiege());
		registerAdminCommandHandler(new AdminSkill());
		registerAdminCommandHandler(new AdminSpawn());
		registerAdminCommandHandler(new AdminTarget());
		registerAdminCommandHandler(new AdminTeleport());
		registerAdminCommandHandler(new AdminTest());
		registerAdminCommandHandler(new AdminTownWar());
		registerAdminCommandHandler(new AdminWho());
		registerAdminCommandHandler(new AdminZone());
		// ATTENTION: adding new command handlers, you have to change the
		// sql file containing the access levels rights
		
		LOGGER.info("AdminCommandHandler: Loaded " + dataTable.size() + " handlers.");
		
		if (Config.DEBUG)
		{
			String[] commands = new String[dataTable.keySet().size()];
			
			commands = dataTable.keySet().toArray(commands);
			
			Arrays.sort(commands);
			
			for (final String command : commands)
			{
				if (AdminCommandAccessRights.getInstance().accessRightForCommand(command) < 0)
				{
					LOGGER.info("ATTENTION: admin command " + command + " has not an access right");
				}
			}
			
		}
		
	}
	
	public void registerAdminCommandHandler(IAdminCommandHandler handler)
	{
		String[] ids = handler.getAdminCommandList();
		
		for (String element : ids)
		{
			if (Config.DEBUG)
			{
				LOGGER.info("Adding handler for command " + element);
			}
			
			if (dataTable.keySet().contains(new String(element)))
			{
				LOGGER.warn("Duplicated command \"" + element + "\" definition in " + handler.getClass().getName() + ".");
			}
			else
			{
				dataTable.put(element, handler);
			}
		}
	}
	
	public IAdminCommandHandler getAdminCommandHandler(String adminCommand)
	{
		String command = adminCommand;
		
		if (adminCommand.indexOf(" ") != -1)
		{
			command = adminCommand.substring(0, adminCommand.indexOf(" "));
		}
		
		if (Config.DEBUG)
		{
			LOGGER.info("getting handler for command: " + command + " -> " + (dataTable.get(command) != null));
		}
		
		return dataTable.get(command);
	}
}