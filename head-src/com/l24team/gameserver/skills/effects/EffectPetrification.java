
package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.skills.Env;

public class EffectPetrification extends L2Effect
{
	public EffectPetrification(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return L2Effect.EffectType.PETRIFICATION;
	}
	
	@Override
	public void onStart()
	{
		getEffected().startAbnormalEffect(L2Character.ABNORMAL_EFFECT_HOLD_2);
		// getEffected().setIsParalyzed(true);
		// getEffected().setIsInvul(true);
		getEffected().setPetrified(true);
	}
	
	@Override
	public void onExit()
	{
		getEffected().stopAbnormalEffect(L2Character.ABNORMAL_EFFECT_HOLD_2);
		// getEffected().setIsParalyzed(false);
		// getEffected().setIsInvul(false);
		getEffected().setPetrified(false);
	}
	
	@Override
	public boolean onActionTime()
	{
		return false;
	}
}
