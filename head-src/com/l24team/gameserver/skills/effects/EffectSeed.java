package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.skills.Env;

public final class EffectSeed extends L2Effect
{
	
	private int power = 1;
	
	public EffectSeed(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.SEED;
	}
	
	@Override
	public boolean onActionTime()
	{
		// just stop this effect
		return false;
	}
	
	public int getPower()
	{
		return power;
	}
	
	public void increasePower()
	{
		power++;
	}
}
