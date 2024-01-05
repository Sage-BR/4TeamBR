package com.l24team.gameserver.handler.skillhandlers;

import org.apache.log4j.Logger;

import com.l24team.gameserver.handler.ISkillHandler;
import com.l24team.gameserver.model.L2Character;
import com.l24team.gameserver.model.L2Object;
import com.l24team.gameserver.model.L2Skill;
import com.l24team.gameserver.model.L2Skill.SkillType;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;

/**
 * @author Julian
 */
public class DeluxeKey implements ISkillHandler
{
	private static Logger LOGGER = Logger.getLogger(BeastFeed.class);
	
	private static final SkillType[] SKILL_IDS =
	{
		SkillType.DELUXE_KEY_UNLOCK
	};
	
	@Override
	public void useSkill(final L2Character activeChar, final L2Skill skill, final L2Object[] targets)
	{
		if (!(activeChar instanceof L2PcInstance))
		{
			return;
		}
		
		L2Object[] targetList = skill.getTargetList(activeChar);
		
		if (targetList == null)
		{
			return;
		}
		
		targetList = null;
		
		LOGGER.debug("Delux key casting succeded.");
		
		// This is just a dummy skill handler for the golden food and crystal food skills,
		// since the AI responce onSkillUse handles the rest.
	}
	
	@Override
	public SkillType[] getSkillIds()
	{
		return SKILL_IDS;
	}
}
