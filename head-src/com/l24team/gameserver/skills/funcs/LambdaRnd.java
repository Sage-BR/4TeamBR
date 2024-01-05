package com.l24team.gameserver.skills.funcs;

import com.l24team.gameserver.skills.Env;
import com.l24team.util.random.Rnd;

/**
 * @author mkizub
 */
public final class LambdaRnd extends Lambda
{
	private final Lambda max;
	private final boolean linear;
	
	public LambdaRnd(final Lambda max, final boolean linear)
	{
		this.max = max;
		this.linear = linear;
	}
	
	@Override
	public double calc(final Env env)
	{
		if (linear)
		{
			return max.calc(env) * Rnd.nextDouble();
		}
		return max.calc(env) * Rnd.nextGaussian();
	}
	
}
