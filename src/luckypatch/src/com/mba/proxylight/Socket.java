package com.mba.proxylight;

import java.nio.channels.SocketChannel;

public class Socket
{
  public long created = System.currentTimeMillis();
  public long lastRead = this.created;
  public long lastWrite = this.created;
  public SocketChannel socket = null;
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/mba/proxylight/Socket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */