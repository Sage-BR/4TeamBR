package com.l24team.loginserver;

import java.nio.channels.SocketChannel;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.l24team.loginserver.network.serverpackets.Init;
import com.l24team.netcore.IAcceptFilter;
import com.l24team.netcore.IClientFactory;
import com.l24team.netcore.IMMOExecutor;
import com.l24team.netcore.MMOConnection;
import com.l24team.netcore.ReceivablePacket;
import com.l24team.util.IPv4Filter;

/**
 * @author ProGramMoS
 */
public class SelectorHelper implements IMMOExecutor<L2LoginClient>, IClientFactory<L2LoginClient>, IAcceptFilter
{
	private final ThreadPoolExecutor generalPacketsThreadPool;
	private final IPv4Filter ipv4filter;
	
	public SelectorHelper()
	{
		generalPacketsThreadPool = new ThreadPoolExecutor(4, 6, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		ipv4filter = new IPv4Filter();
	}
	
	@Override
	public void execute(final ReceivablePacket<L2LoginClient> packet)
	{
		generalPacketsThreadPool.execute(packet);
	}
	
	@Override
	public L2LoginClient create(final MMOConnection<L2LoginClient> con)
	{
		final L2LoginClient client = new L2LoginClient(con);
		client.sendPacket(new Init(client));
		
		return client;
	}
	
	@Override
	public boolean accept(final SocketChannel sc)
	{
		// return !LoginController.getInstance().isBannedAddress(sc.socket().getInetAddress());
		
		return ipv4filter.accept(sc) && !LoginController.getInstance().isBannedAddress(sc.socket().getInetAddress());
	}
}
