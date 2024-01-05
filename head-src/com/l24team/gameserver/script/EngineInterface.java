package com.l24team.gameserver.script;

import com.l24team.gameserver.controllers.GameTimeController;
import com.l24team.gameserver.controllers.RecipeController;
import com.l24team.gameserver.datatables.SkillTable;
import com.l24team.gameserver.datatables.csv.MapRegionTable;
import com.l24team.gameserver.datatables.sql.CharNameTable;
import com.l24team.gameserver.datatables.sql.CharTemplateTable;
import com.l24team.gameserver.datatables.sql.ClanTable;
import com.l24team.gameserver.datatables.sql.ItemTable;
import com.l24team.gameserver.datatables.sql.LevelUpData;
import com.l24team.gameserver.datatables.sql.NpcTable;
import com.l24team.gameserver.datatables.sql.SkillTreeTable;
import com.l24team.gameserver.datatables.sql.SpawnTable;
import com.l24team.gameserver.datatables.sql.TeleportLocationTable;
import com.l24team.gameserver.idfactory.IdFactory;
import com.l24team.gameserver.model.L2World;
import com.l24team.gameserver.model.entity.Announcements;

/**
 * @author Luis Arias
 */
public interface EngineInterface
{
	// * keep the references of Singletons to prevent garbage collection
	public CharNameTable charNametable = CharNameTable.getInstance();
	
	public IdFactory idFactory = IdFactory.getInstance();
	public ItemTable itemTable = ItemTable.getInstance();
	
	public SkillTable skillTable = SkillTable.getInstance();
	
	public RecipeController recipeController = RecipeController.getInstance();
	
	public SkillTreeTable skillTreeTable = SkillTreeTable.getInstance();
	public CharTemplateTable charTemplates = CharTemplateTable.getInstance();
	public ClanTable clanTable = ClanTable.getInstance();
	
	public NpcTable npcTable = NpcTable.getInstance();
	
	public TeleportLocationTable teleTable = TeleportLocationTable.getInstance();
	public LevelUpData levelUpData = LevelUpData.getInstance();
	public L2World world = L2World.getInstance();
	public SpawnTable spawnTable = SpawnTable.getInstance();
	public GameTimeController gameTimeController = GameTimeController.getInstance();
	public Announcements announcements = Announcements.getInstance();
	public MapRegionTable mapRegions = MapRegionTable.getInstance();
	
	// public ArrayList getAllPlayers();
	// public Player getPlayer(String characterName);
	public void addQuestDrop(int npcID, int itemID, int min, int max, int chance, String questID, String[] states);
	
	public void addEventDrop(int[] items, int[] count, double chance, DateRange range);
	
	public void onPlayerLogin(String[] message, DateRange range);
	
}
