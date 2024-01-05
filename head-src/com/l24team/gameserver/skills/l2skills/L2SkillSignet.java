package com.l24team.gameserver.skills.l2skills;

import com.l24team.gameserver.datatables.sql.NpcTable;
import com.l24team.gameserver.idfactory.IdFactory;
import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.L2Object;
import com.l24team.gameserver.model.L2Skill;
import com.l24team.gameserver.model.L2World;
import com.l24team.gameserver.model.actor.instance.L2EffectPointInstance;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.templates.L2NpcTemplate;
import com.l24team.gameserver.templates.StatsSet;
import com.l24team.util.Point3D;

public final class L2SkillSignet extends L2Skill
{
	private final int effectNpcId;
	public int effectId;
	
	public L2SkillSignet(final StatsSet set)
	{
		super(set);
		effectNpcId = set.getInteger("effectNpcId", -1);
		effectId = set.getInteger("effectId", -1);
	}
	
	@Override
	public void useSkill(final L2Character caster, final L2Object[] targets)
	{
		if (caster.isAlikeDead())
		{
			return;
		}
		
		final L2NpcTemplate template = NpcTable.getInstance().getTemplate(effectNpcId);
		final L2EffectPointInstance effectPoint = new L2EffectPointInstance(IdFactory.getInstance().getNextId(), template, caster);
		effectPoint.getStatus().setCurrentHp(effectPoint.getMaxHp());
		effectPoint.getStatus().setCurrentMp(effectPoint.getMaxMp());
		L2World.getInstance().storeObject(effectPoint);
		
		int x = caster.getX();
		int y = caster.getY();
		int z = caster.getZ();
		
		if (caster instanceof L2PcInstance && getTargetType() == L2Skill.SkillTargetType.TARGET_GROUND)
		{
			final Point3D wordPosition = ((L2PcInstance) caster).getCurrentSkillWorldPosition();
			
			if (wordPosition != null)
			{
				x = wordPosition.getX();
				y = wordPosition.getY();
				z = wordPosition.getZ();
			}
		}
		getEffects(caster, effectPoint, false, false, false);
		
		effectPoint.setIsInvul(true);
		effectPoint.spawnMe(x, y, z);
	}
}