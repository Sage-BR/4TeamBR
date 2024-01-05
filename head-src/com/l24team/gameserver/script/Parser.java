package com.l24team.gameserver.script;

import javax.script.ScriptContext;

import org.w3c.dom.Node;

/**
 * @author Luis Arias
 */
public abstract class Parser
{
	public abstract void parseScript(Node node, ScriptContext context);
}
