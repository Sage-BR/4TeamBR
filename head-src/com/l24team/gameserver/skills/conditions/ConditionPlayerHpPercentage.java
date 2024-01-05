package com.l24team.gameserver.skills.conditions;

import com.l24team.gameserver.skills.Env;

public class ConditionPlayerHpPercentage extends Condition
{
	private final double percentage;
	
	public ConditionPlayerHpPercentage(final double p)
	{
		percentage = p;
	}
	
	@Override
	public boolean testImpl(final Env env)
	{
		return env.player.getCurrentHp() <= env.player.getMaxHp() * percentage;
	}
}
