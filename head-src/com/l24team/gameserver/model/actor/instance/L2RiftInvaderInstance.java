package com.l24team.gameserver.model.actor.instance;

import com.l24team.gameserver.templates.L2NpcTemplate;

public class L2RiftInvaderInstance extends L2MonsterInstance
{
	// Not longer needed since rift monster targeting control now is handled by the room zones for any mob
	public L2RiftInvaderInstance(final int objectId, final L2NpcTemplate template)
	{
		super(objectId, template);
	}
}
