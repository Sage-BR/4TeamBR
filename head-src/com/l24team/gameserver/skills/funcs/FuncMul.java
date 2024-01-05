package com.l24team.gameserver.skills.funcs;

import com.l24team.gameserver.skills.Env;
import com.l24team.gameserver.skills.Stats;

public class FuncMul extends Func
{
	private final Lambda lambda;
	
	public FuncMul(final Stats pStat, final int pOrder, final Object owner, final Lambda lambda)
	{
		super(pStat, pOrder, owner);
		this.lambda = lambda;
	}
	
	@Override
	public void calc(final Env env)
	{
		if (cond == null || cond.test(env))
		{
			env.value *= lambda.calc(env);
		}
	}
}
