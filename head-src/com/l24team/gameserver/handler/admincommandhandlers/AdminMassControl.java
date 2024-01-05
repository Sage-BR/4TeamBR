package com.l24team.gameserver.handler.admincommandhandlers;

import java.util.StringTokenizer;

import com.l24team.Config;
import com.l24team.gameserver.handler.IAdminCommandHandler;
import com.l24team.gameserver.model.L2World;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;

/**
 * <b>This class handles Admin mass commands:</b><br>
 * <br>
 * @author Rayan
 */
public class AdminMassControl implements IAdminCommandHandler
{
	
	private static String[] ADMIN_COMMANDS =
	{
		"admin_masskill",
		"admin_massress"
	};
	
	@Override
	public boolean useAdminCommand(final String command, final L2PcInstance activeChar)
	{
		if (command.startsWith("admin_mass"))
		{
			try
			{
				StringTokenizer st = new StringTokenizer(command);
				st.nextToken();
				
				if (st.nextToken().equalsIgnoreCase("kill"))
				{
					int counter = 0;
					
					for (final L2PcInstance player : L2World.getInstance().getAllPlayers())
					{
						if (!player.isGM())
						{
							counter++;
							player.getStatus().setCurrentHp(0);
							player.doDie(player);
							activeChar.sendMessage("You've Killed " + counter + " players.");
						}
					}
				}
				else if (st.nextToken().equalsIgnoreCase("ress"))
				{
					int counter = 0;
					
					for (final L2PcInstance player : L2World.getInstance().getAllPlayers())
					{
						if (!player.isGM() && player.isDead())
						{
							counter++;
							player.doRevive();
							activeChar.sendMessage("You've Ressurected " + counter + " players.");
						}
					}
				}
				
				st = null;
			}
			catch (final Exception ex)
			{
				if (Config.ENABLE_ALL_EXCEPTIONS)
				{
					ex.printStackTrace();
				}
			}
		}
		
		return true;
	}
	
	@Override
	public String[] getAdminCommandList()
	{
		return ADMIN_COMMANDS;
	}
}
