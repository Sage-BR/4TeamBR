package com.l24team.gameserver.model.zone.type;

import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;

/**
 * The Monster Derby Track Zone
 * @author durgus
 */
public class L2DerbyTrackZone extends L2PeaceZone
{
	public L2DerbyTrackZone(final int id)
	{
		super(id);
	}
	
	@Override
	protected void onEnter(final L2Character character)
	{
		if (character instanceof L2PcInstance)
		{
			character.setInsideZone(L2Character.ZONE_MONSTERTRACK, true);
		}
		super.onEnter(character);
	}
	
	@Override
	protected void onExit(final L2Character character)
	{
		if (character instanceof L2PcInstance)
		{
			character.setInsideZone(L2Character.ZONE_MONSTERTRACK, false);
		}
		super.onExit(character);
	}
	
	@Override
	protected void onDieInside(final L2Character character)
	{
	}
	
	@Override
	protected void onReviveInside(final L2Character character)
	{
	}
	
}
