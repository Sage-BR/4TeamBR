package com.l24team.gameserver.network.clientpackets;

import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.serverpackets.RecipeItemMakeInfo;

public final class RequestRecipeItemMakeInfo extends L2GameClientPacket
{
	private int id;
	private L2PcInstance activeChar;
	
	@Override
	protected void readImpl()
	{
		id = readD();
		activeChar = getClient().getActiveChar();
	}
	
	@Override
	protected void runImpl()
	{
		final RecipeItemMakeInfo response = new RecipeItemMakeInfo(id, activeChar);
		sendPacket(response);
	}
	
	@Override
	public String getType()
	{
		return "[C] AE RequestRecipeItemMakeInfo";
	}
}
