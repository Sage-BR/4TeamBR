package com.l24team.gameserver.handler;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.l24team.Config;
import com.l24team.gameserver.GameServer;
import com.l24team.gameserver.handler.itemhandlers.BeastSoulShot;
import com.l24team.gameserver.handler.itemhandlers.BeastSpice;
import com.l24team.gameserver.handler.itemhandlers.BeastSpiritShot;
import com.l24team.gameserver.handler.itemhandlers.BlessedSpiritShot;
import com.l24team.gameserver.handler.itemhandlers.Book;
import com.l24team.gameserver.handler.itemhandlers.BreakingArrow;
import com.l24team.gameserver.handler.itemhandlers.CharChangePotions;
import com.l24team.gameserver.handler.itemhandlers.ChestKey;
import com.l24team.gameserver.handler.itemhandlers.ChristmasTree;
import com.l24team.gameserver.handler.itemhandlers.CrystalCarol;
import com.l24team.gameserver.handler.itemhandlers.Crystals;
import com.l24team.gameserver.handler.itemhandlers.CustomPotions;
import com.l24team.gameserver.handler.itemhandlers.EnchantScrolls;
import com.l24team.gameserver.handler.itemhandlers.EnergyStone;
import com.l24team.gameserver.handler.itemhandlers.ExtractableItems;
import com.l24team.gameserver.handler.itemhandlers.Firework;
import com.l24team.gameserver.handler.itemhandlers.FishShots;
import com.l24team.gameserver.handler.itemhandlers.Harvester;
import com.l24team.gameserver.handler.itemhandlers.HeroCustomItem;
import com.l24team.gameserver.handler.itemhandlers.JackpotSeed;
import com.l24team.gameserver.handler.itemhandlers.MOSKey;
import com.l24team.gameserver.handler.itemhandlers.MapForestOfTheDead;
import com.l24team.gameserver.handler.itemhandlers.Maps;
import com.l24team.gameserver.handler.itemhandlers.MercTicket;
import com.l24team.gameserver.handler.itemhandlers.MysteryPotion;
import com.l24team.gameserver.handler.itemhandlers.Nectar;
import com.l24team.gameserver.handler.itemhandlers.NobleCustomItem;
import com.l24team.gameserver.handler.itemhandlers.PaganKeys;
import com.l24team.gameserver.handler.itemhandlers.Potions;
import com.l24team.gameserver.handler.itemhandlers.Recipes;
import com.l24team.gameserver.handler.itemhandlers.Remedy;
import com.l24team.gameserver.handler.itemhandlers.RollingDice;
import com.l24team.gameserver.handler.itemhandlers.ScrollOfEscape;
import com.l24team.gameserver.handler.itemhandlers.ScrollOfResurrection;
import com.l24team.gameserver.handler.itemhandlers.Scrolls;
import com.l24team.gameserver.handler.itemhandlers.Seed;
import com.l24team.gameserver.handler.itemhandlers.SevenSignsRecord;
import com.l24team.gameserver.handler.itemhandlers.SoulCrystals;
import com.l24team.gameserver.handler.itemhandlers.SoulShots;
import com.l24team.gameserver.handler.itemhandlers.SpecialXMas;
import com.l24team.gameserver.handler.itemhandlers.SpiritShot;
import com.l24team.gameserver.handler.itemhandlers.SummonItems;
import com.l24team.gameserver.handler.itemhandlers.VIPCustomItem;

/**
 * This class manages handlers of items
 * @version $Revision: 1.1.4.3 $ $Date: 2005/03/27 15:30:09 $
 */
public class ItemHandler
{
	private static final Logger LOGGER = Logger.getLogger(GameServer.class);
	
	private static ItemHandler instance;
	
	private final Map<Integer, IItemHandler> dataTable;
	
	/**
	 * Create ItemHandler if doesn't exist and returns ItemHandler
	 * @return ItemHandler
	 */
	public static ItemHandler getInstance()
	{
		if (instance == null)
		{
			instance = new ItemHandler();
		}
		
		return instance;
	}
	
	/**
	 * Returns the number of elements contained in datatable
	 * @return int : Size of the datatable
	 */
	public int size()
	{
		return dataTable.size();
	}
	
	/**
	 * Constructor of ItemHandler
	 */
	private ItemHandler()
	{
		dataTable = new TreeMap<>();
		registerItemHandler(new ScrollOfEscape());
		registerItemHandler(new ScrollOfResurrection());
		registerItemHandler(new SoulShots());
		registerItemHandler(new SpiritShot());
		registerItemHandler(new BlessedSpiritShot());
		registerItemHandler(new BeastSoulShot());
		registerItemHandler(new BeastSpiritShot());
		registerItemHandler(new ChestKey());
		registerItemHandler(new CustomPotions());
		registerItemHandler(new PaganKeys());
		registerItemHandler(new Maps());
		registerItemHandler(new MapForestOfTheDead());
		registerItemHandler(new Potions());
		registerItemHandler(new Recipes());
		registerItemHandler(new RollingDice());
		registerItemHandler(new MysteryPotion());
		registerItemHandler(new EnchantScrolls());
		registerItemHandler(new EnergyStone());
		registerItemHandler(new Book());
		registerItemHandler(new Remedy());
		registerItemHandler(new Scrolls());
		registerItemHandler(new CrystalCarol());
		registerItemHandler(new SoulCrystals());
		registerItemHandler(new SevenSignsRecord());
		registerItemHandler(new CharChangePotions());
		registerItemHandler(new Firework());
		registerItemHandler(new Seed());
		registerItemHandler(new Harvester());
		registerItemHandler(new MercTicket());
		registerItemHandler(new Nectar());
		registerItemHandler(new FishShots());
		registerItemHandler(new ExtractableItems());
		registerItemHandler(new SpecialXMas());
		registerItemHandler(new SummonItems());
		registerItemHandler(new BeastSpice());
		registerItemHandler(new JackpotSeed());
		
		if (Config.NOBLE_CUSTOM_ITEMS)
		{
			registerItemHandler(new NobleCustomItem());
		}
		
		if (Config.HERO_CUSTOM_ITEMS)
		{
			registerItemHandler(new HeroCustomItem());
		}
		
		if (Config.VIP_CUSTOM_ITEM)
		{
			registerItemHandler(new VIPCustomItem());
		}
		registerItemHandler(new MOSKey());
		registerItemHandler(new BreakingArrow());
		registerItemHandler(new ChristmasTree());
		registerItemHandler(new Crystals());
		LOGGER.info("ItemHandler: Loaded " + dataTable.size() + " handlers.");
	}
	
	/**
	 * Adds handler of item type in <I>datatable</I>.<BR>
	 * <BR>
	 * <B><I>Concept :</I></U><BR>
	 * This handler is put in <I>datatable</I> Map &lt;Integer ; IItemHandler &gt; for each ID corresponding to an item type (existing in classes of package itemhandlers) sets as key of the Map.
	 * @param handler (IItemHandler)
	 */
	public void registerItemHandler(final IItemHandler handler)
	{
		// Get all ID corresponding to the item type of the handler
		final int[] ids = handler.getItemIds();
		
		// Add handler for each ID found
		for (final int id : ids)
		{
			dataTable.put(id, handler);
		}
	}
	
	/**
	 * Returns the handler of the item
	 * @param  itemId : int designating the itemID
	 * @return        IItemHandler
	 */
	public IItemHandler getItemHandler(final int itemId)
	{
		return dataTable.get(itemId);
	}
}
