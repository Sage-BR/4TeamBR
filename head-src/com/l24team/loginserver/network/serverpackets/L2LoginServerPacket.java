package com.l24team.loginserver.network.serverpackets;

import com.l24team.loginserver.L2LoginClient;
import com.l24team.netcore.SendablePacket;

/**
 * @author programmos
 */
public abstract class L2LoginServerPacket extends SendablePacket<L2LoginClient>
{
	public abstract String getType();
}
