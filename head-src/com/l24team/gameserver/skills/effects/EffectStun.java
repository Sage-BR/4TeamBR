package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.skills.Env;

/**
 * @author mkizub
 */
final class EffectStun extends L2Effect
{
	
	public EffectStun(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.STUN;
	}
	
	/** Notify started */
	@Override
	public void onStart()
	{
		if (!getEffected().isRaid())
		{
			getEffected().startStunning();
		}
	}
	
	/** Notify exited */
	@Override
	public void onExit()
	{
		getEffected().stopStunning(this);
	}
	
	@Override
	public boolean onActionTime()
	{
		// just stop this effect
		return false;
	}
}
