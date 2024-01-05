package com.l24team.gameserver.model.zone.type;

import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.model.zone.L2ZoneType;

/**
 * Zone where store is not allowed.
 * @author StarCOM
 */
public class L2NoStoreZone extends L2ZoneType
{
	public L2NoStoreZone(final int id)
	{
		super(id);
	}
	
	@Override
	protected void onEnter(final L2Character character)
	{
		if (character instanceof L2PcInstance)
		{
			character.setInsideZone(L2Character.ZONE_NOSTORE, true);
		}
	}
	
	@Override
	protected void onExit(final L2Character character)
	{
		if (character instanceof L2PcInstance)
		{
			character.setInsideZone(L2Character.ZONE_NOSTORE, false);
		}
	}
	
	@Override
	public void onDieInside(final L2Character character)
	{
	}
	
	@Override
	public void onReviveInside(final L2Character character)
	{
	}
}