package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.skills.Env;

/**
 * @author ProGramMoS, 4TeamBR
 */
final class EffectBuff extends L2Effect
{
	
	public EffectBuff(final Env envbuff, final EffectTemplate template)
	{
		super(envbuff, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.BUFF;
	}
	
	@Override
	public boolean onActionTime()
	{
		// just stop this effect
		return false;
	}
}
