package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.model.L2Skill.SkillType;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.SystemMessageId;
import com.l24team.gameserver.network.serverpackets.SystemMessage;
import com.l24team.gameserver.skills.Env;

final class EffectSilentMove extends L2Effect
{
	public EffectSilentMove(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	/** Notify started */
	@Override
	public void onStart()
	{
		super.onStart();
		
		final L2Character effected = getEffected();
		if (effected instanceof L2PcInstance)
		{
			((L2PcInstance) effected).setSilentMoving(true);
		}
	}
	
	/** Notify exited */
	@Override
	public void onExit()
	{
		super.onExit();
		
		final L2Character effected = getEffected();
		if (effected instanceof L2PcInstance)
		{
			((L2PcInstance) effected).setSilentMoving(false);
		}
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.SILENT_MOVE;
	}
	
	@Override
	public boolean onActionTime()
	{
		// Only cont skills shouldn't end
		if ((getSkill().getSkillType() != SkillType.CONT) || getEffected().isDead())
		{
			return false;
		}
		
		final double manaDam = calc();
		
		if (manaDam > getEffected().getCurrentMp())
		{
			final SystemMessage sm = new SystemMessage(SystemMessageId.SKILL_REMOVED_DUE_LACK_MP);
			getEffected().sendPacket(sm);
			return false;
		}
		
		getEffected().reduceCurrentMp(manaDam);
		return true;
	}
}