package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.ai.CtrlIntention;
import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.model.actor.instance.L2GrandBossInstance;
import com.l24team.gameserver.model.actor.instance.L2RaidBossInstance;
import com.l24team.gameserver.skills.Env;

/**
 * @author programmos, 4TeamBR
 */
public class EffectRemoveTarget extends L2Effect
{
	public EffectRemoveTarget(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.REMOVE_TARGET;
	}
	
	@Override
	public boolean onActionTime()
	{
		// nothing
		return false;
	}
	
	/**
	 * @see com.l24team.gameserver.model.L2Effect#onExit()
	 */
	
	@Override
	public void onExit()
	{
		try
		{
			// nothing
			super.onExit();
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @see com.l24team.gameserver.model.L2Effect#onStart()
	 */
	@Override
	public void onStart()
	{
		// RaidBoss and GrandBoss are immune to RemoveTarget effect
		if (getEffected() instanceof L2RaidBossInstance || getEffected() instanceof L2GrandBossInstance)
		{
			return;
		}
		
		try
		{
			getEffected().setTarget(null);
			getEffected().abortAttack();
			getEffected().abortCast();
			getEffected().getAI().setIntention(CtrlIntention.AI_INTENTION_IDLE, getEffector());
			super.onStart();
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
}