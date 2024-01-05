package com.l24team.gameserver.skills.funcs;

import com.l24team.gameserver.skills.Env;

/**
 * @author mkizub
 */
public final class LambdaConst extends Lambda
{
	private final double value;
	
	public LambdaConst(final double value)
	{
		this.value = value;
	}
	
	@Override
	public double calc(final Env env)
	{
		return value;
	}
	
}
