package com.l24team.gameserver.skills.conditions;

import com.l24team.gameserver.skills.Env;
import com.l24team.util.random.Rnd;

/**
 * @author Advi
 */
public class ConditionGameChance extends Condition
{
	private final int chance;
	
	public ConditionGameChance(final int chance)
	{
		this.chance = chance;
	}
	
	@Override
	public boolean testImpl(final Env env)
	{
		return Rnd.get(100) < chance;
	}
}
