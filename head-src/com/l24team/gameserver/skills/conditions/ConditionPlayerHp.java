package com.l24team.gameserver.skills.conditions;

import com.l24team.gameserver.skills.Env;

/**
 * @author mr
 */
public class ConditionPlayerHp extends Condition
{
	private final int hp;
	
	public ConditionPlayerHp(final int hp)
	{
		this.hp = hp;
	}
	
	@Override
	public boolean testImpl(final Env env)
	{
		return env.player.getCurrentHp() * 100 / env.player.getMaxHp() <= hp;
	}
}
