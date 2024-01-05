package com.l24team.gameserver.skills.conditions;

import com.l24team.gameserver.skills.Env;

/**
 * @author mkizub
 */
public final class ConditionItemId extends Condition
{
	
	private final int itemId;
	
	public ConditionItemId(final int itemId)
	{
		this.itemId = itemId;
	}
	
	@Override
	public boolean testImpl(final Env env)
	{
		if (env.item == null)
		{
			return false;
		}
		return env.item.getItemId() == itemId;
	}
}
