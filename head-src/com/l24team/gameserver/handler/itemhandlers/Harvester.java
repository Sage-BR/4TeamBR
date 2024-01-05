package com.l24team.gameserver.handler.itemhandlers;

import com.l24team.gameserver.datatables.SkillTable;
import com.l24team.gameserver.handler.IItemHandler;
import com.l24team.gameserver.managers.CastleManorManager;
import com.l24team.gameserver.model.L2Skill;
import com.l24team.gameserver.model.actor.instance.L2ItemInstance;
import com.l24team.gameserver.model.actor.instance.L2MonsterInstance;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.model.actor.instance.L2PlayableInstance;
import com.l24team.gameserver.network.SystemMessageId;
import com.l24team.gameserver.network.serverpackets.ActionFailed;
import com.l24team.gameserver.network.serverpackets.SystemMessage;

/**
 * @author l3x
 */
public class Harvester implements IItemHandler
{
	
	private static final int[] ITEM_IDS =
	{
		5125
		/* Harvester */
	};
	L2PcInstance activeChar;
	L2MonsterInstance target;
	
	@Override
	public void useItem(final L2PlayableInstance playable, final L2ItemInstance item)
	{
		if (!(playable instanceof L2PcInstance) || CastleManorManager.getInstance().isDisabled())
		{
			return;
		}
		
		activeChar = (L2PcInstance) playable;
		if (activeChar.getTarget() == null || !(activeChar.getTarget() instanceof L2MonsterInstance))
		{
			activeChar.sendPacket(new SystemMessage(SystemMessageId.TARGET_IS_INCORRECT));
			activeChar.sendPacket(ActionFailed.STATIC_PACKET);
			return;
		}
		
		target = (L2MonsterInstance) activeChar.getTarget();
		if (target == null || !target.isDead())
		{
			activeChar.sendPacket(ActionFailed.STATIC_PACKET);
			return;
		}
		
		final L2Skill skill = SkillTable.getInstance().getInfo(2098, 1); // harvesting skill
		activeChar.useMagic(skill, false, false);
	}
	
	@Override
	public int[] getItemIds()
	{
		return ITEM_IDS;
	}
}
