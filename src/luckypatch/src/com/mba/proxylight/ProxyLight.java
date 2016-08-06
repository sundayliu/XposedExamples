package com.mba.proxylight;

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ProxyLight
{
  private List<RequestFilter> filters = new ArrayList();
  private Map<String, InetAddress> ipCache = new HashMap();
  private int port = 8080;
  private Stack<RequestProcessor> processors = new Stack();
  private String remoteProxyHost = null;
  private int remoteProxyPort = 8080;
  boolean running = false;
  private Selector selector = null;
  ServerSocketChannel server = null;
  
  public void debug(String paramString)
  {
    if (paramString != null) {
      System.err.println(paramString);
    }
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    if (paramString != null) {
      System.err.println(paramString);
    }
    if (paramThrowable != null) {}
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public String getRemoteProxyHost()
  {
    return this.remoteProxyHost;
  }
  
  public int getRemoteProxyPort()
  {
    return this.remoteProxyPort;
  }
  
  public List<RequestFilter> getRequestFilters()
  {
    return this.filters;
  }
  
  public boolean isRunning()
  {
    return this.running;
  }
  
  public void recycle(RequestProcessor paramRequestProcessor)
  {
    synchronized (this.processors)
    {
      this.processors.add(paramRequestProcessor);
      return;
    }
  }
  
  protected InetAddress resolve(String paramString)
  {
    InetAddress localInetAddress2 = (InetAddress)this.ipCache.get(paramString);
    InetAddress localInetAddress1 = localInetAddress2;
    if (localInetAddress2 == null) {
      localInetAddress1 = localInetAddress2;
    }
    try
    {
      localInetAddress2 = InetAddress.getByName(paramString);
      localInetAddress1 = localInetAddress2;
      this.ipCache.put(paramString, localInetAddress2);
      localInetAddress1 = localInetAddress2;
    }
    catch (UnknownHostException paramString)
    {
      return null;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        error("", paramString);
      }
    }
    return localInetAddress1;
  }
  
  public void setPort(int paramInt)
  {
    this.port = paramInt;
  }
  
  public void setRemoteProxy(String paramString, int paramInt)
  {
    this.remoteProxyHost = paramString;
    this.remoteProxyPort = paramInt;
  }
  
  /* Error */
  public void start()
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/mba/proxylight/ProxyLight:running	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 36	com/mba/proxylight/ProxyLight:running	Z
    //   19: new 132	java/lang/Thread
    //   22: dup
    //   23: new 6	com/mba/proxylight/ProxyLight$1
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 135	com/mba/proxylight/ProxyLight$1:<init>	(Lcom/mba/proxylight/ProxyLight;)V
    //   31: invokespecial 138	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   34: astore_2
    //   35: aload_2
    //   36: iconst_0
    //   37: invokevirtual 142	java/lang/Thread:setDaemon	(Z)V
    //   40: aload_2
    //   41: ldc -112
    //   43: invokevirtual 147	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   46: aload_2
    //   47: invokevirtual 149	java/lang/Thread:start	()V
    //   50: goto -39 -> 11
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	ProxyLight
    //   6	2	1	bool	boolean
    //   34	13	2	localThread	Thread
    //   53	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	53	finally
    //   14	50	53	finally
  }
  
  public void stop()
  {
    if (!this.running) {}
    for (;;)
    {
      return;
      try
      {
        this.server.close();
        this.server = null;
        this.selector.wakeup();
        this.selector = null;
        while (this.processors.size() > 0) {
          ((RequestProcessor)this.processors.pop()).shutdown();
        }
        return;
      }
      catch (Exception localException)
      {
        error(null, localException);
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/mba/proxylight/ProxyLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */