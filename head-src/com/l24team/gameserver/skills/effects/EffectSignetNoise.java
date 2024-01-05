package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.model.actor.instance.L2EffectPointInstance;
import com.l24team.gameserver.skills.Env;

public final class EffectSignetNoise extends L2Effect
{
	private L2EffectPointInstance actor;
	
	public EffectSignetNoise(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.SIGNET_GROUND;
	}
	
	@Override
	public void onStart()
	{
		actor = (L2EffectPointInstance) getEffected();
	}
	
	@Override
	public boolean onActionTime()
	{
		if (getCount() == getTotalCount() - 1)
		{
			return true; // do nothing first time
		}
		
		for (final L2Character target : actor.getKnownList().getKnownCharactersInRadius(getSkill().getSkillRadius()))
		{
			if (target == null)
			{
				continue;
			}
			
			final L2Effect[] effects = target.getAllEffects();
			if (effects != null)
			{
				for (final L2Effect effect : effects)
				{
					if (effect.getSkill().isDance())
					{
						effect.exit(true);
					}
				}
				// there doesn't seem to be a visible effect?
			}
		}
		return true;
	}
	
	@Override
	public void onExit()
	{
		if (actor != null)
		{
			actor.deleteMe();
		}
	}
}
