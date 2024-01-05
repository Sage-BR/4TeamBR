package com.l24team.gameserver.model.actor.status;

import com.l24team.gameserver.ai.CtrlEvent;
import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.actor.instance.L2NpcInstance;
import com.l24team.gameserver.model.actor.instance.L2PetInstance;
import com.l24team.gameserver.network.SystemMessageId;
import com.l24team.gameserver.network.serverpackets.SystemMessage;

public class PetStatus extends SummonStatus
{
	private int currentFed = 0; // Current Fed of the L2PetInstance
	
	public PetStatus(final L2PetInstance activeChar)
	{
		super(activeChar);
	}
	
	@Override
	public final void reduceHp(final double value, final L2Character attacker)
	{
		reduceHp(value, attacker, true);
	}
	
	@Override
	public final void reduceHp(final double value, final L2Character attacker, final boolean awake)
	{
		if (getActiveChar().isDead())
		{
			return;
		}
		
		super.reduceHp(value, attacker, awake);
		
		if (attacker != null)
		{
			SystemMessage sm = new SystemMessage(SystemMessageId.PET_RECEIVED_S2_DAMAGE_BY_S1);
			
			if (attacker instanceof L2NpcInstance)
			{
				sm.addNpcName(((L2NpcInstance) attacker).getTemplate().idTemplate);
			}
			else
			{
				sm.addString(attacker.getName());
			}
			
			sm.addNumber((int) value);
			getActiveChar().getOwner().sendPacket(sm);
			
			getActiveChar().getAI().notifyEvent(CtrlEvent.EVT_ATTACKED, attacker);
			
			sm = null;
		}
	}
	
	@Override
	public L2PetInstance getActiveChar()
	{
		return (L2PetInstance) super.getActiveChar();
	}
	
	public int getCurrentFed()
	{
		return currentFed;
	}
	
	public void setCurrentFed(final int value)
	{
		currentFed = value;
	}
}
