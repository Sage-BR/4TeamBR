package com.l24team.gameserver.taskmanager.tasks;

import org.apache.log4j.Logger;

import com.l24team.gameserver.model.L2World;
import com.l24team.gameserver.model.actor.instance.L2PcInstance;
import com.l24team.gameserver.network.serverpackets.UserInfo;
import com.l24team.gameserver.taskmanager.Task;
import com.l24team.gameserver.taskmanager.TaskManager;
import com.l24team.gameserver.taskmanager.TaskManager.ExecutedTask;
import com.l24team.gameserver.taskmanager.TaskTypes;

/**
 * @author Layane
 */
public class TaskRecom extends Task
{
	private static final Logger LOGGER = Logger.getLogger(TaskRecom.class);
	private static final String NAME = "sp_recommendations";
	
	@Override
	public String getName()
	{
		return NAME;
	}
	
	@Override
	public void onTimeElapsed(final ExecutedTask task)
	{
		for (final L2PcInstance player : L2World.getInstance().getAllPlayers())
		{
			player.restartRecom();
			player.sendPacket(new UserInfo(player));
		}
		LOGGER.info("[GlobalTask] Restart Recommendation launched.");
	}
	
	@Override
	public void initializate()
	{
		super.initializate();
		TaskManager.addUniqueTask(NAME, TaskTypes.TYPE_GLOBAL_TASK, "1", "13:00:00", "");
	}
}