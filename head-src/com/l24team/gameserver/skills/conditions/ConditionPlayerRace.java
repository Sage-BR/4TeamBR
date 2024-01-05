package com.l24team.gameserver.skills.conditions;

import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.model.base.Race;
import com.l24team.gameserver.skills.Env;

/**
 * @author mkizub
 */
public class ConditionPlayerRace extends Condition
{
	private final Race race;
	
	public ConditionPlayerRace(final Race race)
	{
		this.race = race;
	}
	
	@Override
	public boolean testImpl(final Env env)
	{
		if (!(env.player instanceof L2PcInstance))
		{
			return false;
		}
		return ((L2PcInstance) env.player).getRace() == race;
	}
}
