package com.l24team.gameserver.skills.conditions;

import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.skills.Env;

/**
 * @author eX1steam 4TeamBR
 */
public class ConditionTargetPvp extends Condition
{
	private final int pvp;
	
	public ConditionTargetPvp(final int pvp)
	{
		this.pvp = pvp;
	}
	
	@Override
	public boolean testImpl(final Env env)
	{
		final L2Character target = env.target;
		if (target instanceof L2PcInstance && ((L2PcInstance) target).getPvpFlag() != 0)
		{
			return ((L2PcInstance) target).getPvpFlag() == pvp;
		}
		return false;
	}
}
