package com.l24team.gameserver.model.actor.stat;

import com.l24team.gameserver.model.L2Summon;

public class SummonStat extends PlayableStat
{
	public SummonStat(final L2Summon activeChar)
	{
		super(activeChar);
	}
	
	@Override
	public L2Summon getActiveChar()
	{
		return (L2Summon) super.getActiveChar();
	}
}
