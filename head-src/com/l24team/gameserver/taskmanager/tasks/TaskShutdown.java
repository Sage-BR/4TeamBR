package com.l24team.gameserver.taskmanager.tasks;

import org.apache.log4j.Logger;

import com.l24team.gameserver.Shutdown;
import com.l24team.gameserver.taskmanager.Task;
import com.l24team.gameserver.taskmanager.TaskManager.ExecutedTask;

/**
 * @author Layane
 */
public class TaskShutdown extends Task
{
	private static final Logger LOGGER = Logger.getLogger(TaskShutdown.class);
	public static final String NAME = "shutdown";
	
	@Override
	public String getName()
	{
		return NAME;
	}
	
	@Override
	public void onTimeElapsed(final ExecutedTask task)
	{
		LOGGER.info("[GlobalTask] Server Shutdown launched.");
		
		Shutdown handler = new Shutdown(Integer.valueOf(task.getParams()[2]), false, true);
		handler.start();
	}
}