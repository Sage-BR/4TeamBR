package com.l24team.loginserver.network.gameserverpackets;

import com.l24team.loginserver.SessionKey;
import com.l24team.loginserver.network.clientpackets.ClientBasePacket;

/**
 * @author -Wooden-
 */
public class PlayerAuthRequest extends ClientBasePacket
{
	private final String account;
	private final SessionKey sessionKey;
	
	/**
	 * @param decrypt
	 */
	public PlayerAuthRequest(final byte[] decrypt)
	{
		super(decrypt);
		
		account = readS();
		
		final int playKey1 = readD();
		final int playKey2 = readD();
		final int loginKey1 = readD();
		final int loginKey2 = readD();
		
		sessionKey = new SessionKey(loginKey1, loginKey2, playKey1, playKey2);
	}
	
	/**
	 * @return Returns the account.
	 */
	public String getAccount()
	{
		return account;
	}
	
	/**
	 * @return Returns the key.
	 */
	public SessionKey getKey()
	{
		return sessionKey;
	}
	
}
