package com.l24team.gameserver.model.actor.knownlist;

import com.l24team.gameserver.model.actor.instance.L2PlayableInstance;

public class PlayableKnownList extends CharKnownList
{
	public PlayableKnownList(final L2PlayableInstance activeChar)
	{
		super(activeChar);
	}
	
	@Override
	public L2PlayableInstance getActiveChar()
	{
		return (L2PlayableInstance) super.getActiveChar();
	}
}
