package com.l24team.gameserver.network.clientpackets;

import com.l24team.gameserver.network.SystemMessageId;
import com.l24team.gameserver.network.serverpackets.SystemMessage;

public final class RequestDeleteMacro extends L2GameClientPacket
{
	private int id;
	
	@Override
	protected void readImpl()
	{
		id = readD();
	}
	
	@Override
	protected void runImpl()
	{
		// Macro exploit fix
		if ((getClient().getActiveChar() == null) || !getClient().getFloodProtectors().getMacro().tryPerformAction("delete macro"))
		{
			return;
		}
		
		getClient().getActiveChar().deleteMacro(id);
		SystemMessage sm = new SystemMessage(SystemMessageId.S1_S2);
		sm.addString("Delete macro id=" + id);
		sendPacket(sm);
		sm = null;
	}
	
	@Override
	public String getType()
	{
		return "[C] C2 RequestDeleteMacro";
	}
	
}
