package com.l24team.gameserver.skills.effects;

import com.l24team.gameserver.model.L2Effect;
import com.l24team.gameserver.model.L2Skill.SkillType;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.SystemMessageId;
import com.l24team.gameserver.network.serverpackets.SystemMessage;
import com.l24team.gameserver.skills.Env;
import com.l24team.gameserver.skills.Stats;
import com.l24team.util.random.Rnd;

final class EffectCancel extends L2Effect
{
	public EffectCancel(final Env env, final EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return EffectType.CANCEL;
	}
	
	/** Notify started */
	@Override
	public void onStart()
	{
		final int landrate = (int) getEffector().calcStat(Stats.CANCEL_VULN, 90, getEffected(), null);
		if (Rnd.get(100) < landrate)
		{
			L2Effect[] effects = getEffected().getAllEffects();
			int maxdisp = (int) getSkill().getNegatePower();
			if (maxdisp == 0)
			{
				maxdisp = 5;
			}
			for (final L2Effect e : effects)
			{
				switch (e.getEffectType())
				{
					case SIGNET_GROUND:
					case SIGNET_EFFECT:
						continue;
				}
				
				if (e.getSkill().getId() != 4082 && e.getSkill().getId() != 4215 && e.getSkill().getId() != 5182 && e.getSkill().getId() != 4515 && e.getSkill().getId() != 110 && e.getSkill().getId() != 111 && e.getSkill().getId() != 1323 && e.getSkill().getId() != 1325)
				{
					if (e.getSkill().getSkillType() == SkillType.BUFF)
					{
						// TODO Fix cancel debuffs
						if (e.getSkill().getSkillType() != SkillType.DEBUFF)
						{
							
							int rate = 100;
							final int level = e.getLevel();
							if (level > 0)
							{
								rate = Integer.valueOf(150 / (1 + level));
							}
							
							if (rate > 95)
							{
								rate = 95;
							}
							else if (rate < 5)
							{
								rate = 5;
							}
							
							if (Rnd.get(100) < rate)
							{
								e.exit(true);
								maxdisp--;
								if (maxdisp == 0)
								{
									break;
								}
							}
						}
					}
				}
			}
			effects = null;
		}
		else
		{
			if (getEffector() instanceof L2PcInstance)
			{
				SystemMessage sm = new SystemMessage(SystemMessageId.S1_WAS_UNAFFECTED_BY_S2);
				sm.addString(getEffected().getName());
				sm.addSkillName(getSkill().getDisplayId());
				getEffector().sendPacket(sm);
				sm = null;
			}
		}
	}
	
	/** Notify exited */
	@Override
	public void onExit()
	{
		// null
	}
	
	@Override
	public boolean onActionTime()
	{
		return false;
	}
}
