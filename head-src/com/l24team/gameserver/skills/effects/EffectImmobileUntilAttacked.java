package com.l24team.gameserver.skills.effects;

import org.apache.log4j.Logger;

import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.skills.Env;

/**
 * @author programmos
 */
public class EffectImmobileUntilAttacked extends L2Effect
{
	static final Logger LOGGER = Logger.getLogger(EffectImmobileUntilAttacked.class);
	
	public EffectImmobileUntilAttacked(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.IMMOBILEUNTILATTACKED;
	}
	
	@Override
	public boolean onActionTime()
	{
		getEffected().stopImmobileUntilAttacked(this);
		// just stop this effect
		return false;
	}
	
	/** Notify exited */
	
	@Override
	public void onExit()
	{
		super.onExit();
		getEffected().stopImmobileUntilAttacked(this);
	}
	
	/** Notify started */
	
	@Override
	public void onStart()
	{
		super.onStart();
		getEffected().startImmobileUntilAttacked();
	}
}
