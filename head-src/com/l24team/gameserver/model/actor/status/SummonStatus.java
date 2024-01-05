package com.l24team.gameserver.model.actor.status;

import com.l24team.gameserver.model.L2Summon;

public class SummonStatus extends PlayableStatus
{
	public SummonStatus(final L2Summon activeChar)
	{
		super(activeChar);
	}
	
	@Override
	public L2Summon getActiveChar()
	{
		return (L2Summon) super.getActiveChar();
	}
}
