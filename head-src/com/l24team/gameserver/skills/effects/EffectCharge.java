package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.SystemMessageId;
import com.l24team.gameserver.network.serverpackets.EtcStatusUpdate;
import com.l24team.gameserver.network.serverpackets.SystemMessage;
import com.l24team.gameserver.skills.Env;

public class EffectCharge extends L2Effect
{
	public int numCharges;
	
	public EffectCharge(final Env env, final EffectTemplate template)
	{
		super(env, template);
		numCharges = 1;
		if (env.target instanceof L2PcInstance)
		{
			env.target.sendPacket(new EtcStatusUpdate((L2PcInstance) env.target));
			final SystemMessage sm = new SystemMessage(SystemMessageId.FORCE_INCREASED_TO_S1);
			sm.addNumber(numCharges);
			getEffected().sendPacket(sm);
		}
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.CHARGE;
	}
	
	@Override
	public boolean onActionTime()
	{
		// ignore
		return true;
	}
	
	@Override
	public int getLevel()
	{
		return numCharges;
	}
	
	public void addNumCharges(final int i)
	{
		numCharges = numCharges + i;
	}
}
