package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.skills.Env;

/**
 * @author mkizub
 */
final class EffectImobileBuff extends L2Effect
{
	public EffectImobileBuff(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.BUFF;
	}
	
	/** Notify started */
	@Override
	public void onStart()
	{
		getEffector().setIsImobilised(true);
	}
	
	/** Notify exited */
	@Override
	public void onExit()
	{
		getEffector().setIsImobilised(false);
	}
	
	@Override
	public boolean onActionTime()
	{
		// just stop this effect
		return false;
	}
}