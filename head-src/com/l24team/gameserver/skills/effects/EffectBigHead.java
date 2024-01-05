package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.skills.Env;

/**
 * @author 4TeamBR dev
 */
public class EffectBigHead extends L2Effect
{
	
	public EffectBigHead(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.BUFF;
	}
	
	@Override
	public boolean onActionTime()
	{
		return false;
	}
	
	@Override
	public void onExit()
	{
		getEffected().stopAbnormalEffect(0x02000);
	}
	
	@Override
	public void onStart()
	{
		getEffected().startAbnormalEffect(0x02000);
	}
}
