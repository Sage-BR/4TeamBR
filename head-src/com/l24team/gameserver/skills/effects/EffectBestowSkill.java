package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.datatables.SkillTable;
import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.model.L2Skill;
import com.l24team.gameserver.skills.Env;

/**
 * @author kombat
 */
final class EffectBestowSkill extends L2Effect
{
	public EffectBestowSkill(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	/**
	 * @see com.l24team.gameserver.model.L2Effect#getEffectType()
	 */
	@Override
	public EffectType getEffectType()
	{
		return EffectType.BUFF;
	}
	
	/**
	 * @see com.l24team.gameserver.model.L2Effect#onStart()
	 */
	@Override
	public void onStart()
	{
		final L2Skill tempSkill = SkillTable.getInstance().getInfo(getSkill().getTriggeredId(), getSkill().getTriggeredLevel());
		if (tempSkill != null)
		{
			getEffected().addSkill(tempSkill);
		}
	}
	
	/**
	 * @see com.l24team.gameserver.model.L2Effect#onExit()
	 */
	@Override
	public void onExit()
	{
		getEffected().removeSkill(getSkill().getTriggeredId());
	}
	
	/**
	 * @see com.l24team.gameserver.model.L2Effect#onActionTime()
	 */
	@Override
	public boolean onActionTime()
	{
		return false;
	}
}
