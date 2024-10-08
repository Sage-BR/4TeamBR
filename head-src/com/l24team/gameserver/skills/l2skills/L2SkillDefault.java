package com.l24team.gameserver.skills.l2skills;

import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.L2Object;
import com.l24team.gameserver.model.L2Skill;
import com.l24team.gameserver.network.SystemMessageId;
import com.l24team.gameserver.network.serverpackets.ActionFailed;
import com.l24team.gameserver.network.serverpackets.SystemMessage;
import com.l24team.gameserver.templates.StatsSet;

public class L2SkillDefault extends L2Skill
{
	
	public L2SkillDefault(final StatsSet set)
	{
		super(set);
	}
	
	@Override
	public void useSkill(final L2Character caster, final L2Object[] targets)
	{
		caster.sendPacket(ActionFailed.STATIC_PACKET);
		final SystemMessage sm = new SystemMessage(SystemMessageId.S1_S2);
		sm.addString("Skill not implemented.  Skill ID: " + getId() + " " + getSkillType());
		caster.sendPacket(sm);
	}
	
}
