package com.l24team.gameserver.network.clientpackets;

import com.l24team.Config;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.serverpackets.ActionFailed;
import com.l24team.gameserver.network.serverpackets.StopRotation;

@SuppressWarnings("unused")
public final class FinishRotating extends L2GameClientPacket
{
	private int degree, unknown;
	
	@Override
	protected void readImpl()
	{
		degree = readD();
		unknown = readD();
	}
	
	@Override
	protected void runImpl()
	{
		final L2PcInstance player = getClient().getActiveChar();
		if (player == null)
		{
			return;
		}
		
		if (!Config.ALLOW_USE_CURSOR_FOR_WALK)
		{
			getClient().getActiveChar().sendPacket(ActionFailed.STATIC_PACKET);
			return;
		}
		
		player.broadcastPacket(new StopRotation(player, degree, 0));
	}
	
	@Override
	public String getType()
	{
		return "[C] 4B FinishRotating";
	}
}