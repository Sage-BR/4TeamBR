package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.skills.Env;

/**
 * @author kombat
 */
public final class EffectSpellForce extends EffectForce
{
	public EffectSpellForce(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.SPELL_FORCE;
	}
	
	@Override
	public boolean onActionTime()
	{
		return false;
	}
}
