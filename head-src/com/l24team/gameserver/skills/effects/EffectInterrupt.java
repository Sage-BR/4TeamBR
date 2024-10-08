package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.skills.Env;

/**
 * @author KidZor
 */

public class EffectInterrupt extends L2Effect
{
	public EffectInterrupt(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return L2Effect.EffectType.INTERRUPT;
	}
	
	@Override
	public void onStart()
	{
		getEffected().abortCast();
	}
	
	@Override
	public void onExit()
	{
		// nothing
	}
	
	@Override
	public boolean onActionTime()
	{
		// nothing
		return false;
	}
}
