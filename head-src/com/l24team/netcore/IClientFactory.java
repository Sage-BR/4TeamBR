package com.l24team.netcore;

/**
 * @param  <T>
 * @author     KenM
 */
public interface IClientFactory<T extends MMOClient<?>>
{
	public T create(final MMOConnection<T> con);
}