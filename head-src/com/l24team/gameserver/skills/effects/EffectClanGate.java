package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.L2Clan;
import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.SystemMessageId;
import com.l24team.gameserver.network.serverpackets.SystemMessage;
import com.l24team.gameserver.skills.Env;

/**
 * @author ZaKaX (Ghost @ L2D)
 */
public class EffectClanGate extends L2Effect
{
	public EffectClanGate(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public void onStart()
	{
		getEffected().startAbnormalEffect(L2Character.ABNORMAL_EFFECT_MAGIC_CIRCLE);
		if (getEffected() instanceof L2PcInstance)
		{
			final L2Clan clan = ((L2PcInstance) getEffected()).getClan();
			if (clan != null)
			{
				final SystemMessage msg = new SystemMessage(SystemMessageId.COURT_MAGICIAN_CREATED_PORTAL);
				clan.broadcastToOtherOnlineMembers(msg, ((L2PcInstance) getEffected()));
			}
		}
		
	}
	
	@Override
	public boolean onActionTime()
	{
		return false;
	}
	
	@Override
	public void onExit()
	{
		getEffected().stopAbnormalEffect(L2Character.ABNORMAL_EFFECT_MAGIC_CIRCLE);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.CLAN_GATE;
	}
}