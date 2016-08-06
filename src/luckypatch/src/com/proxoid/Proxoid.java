package com.proxoid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.os.RemoteException;

public class Proxoid
  implements ServiceConnection
{
  protected static final String KEY_ONOFF = "onoff";
  protected static final String KEY_PORT = "port";
  protected static final String KEY_PREFS = "proxoidv6";
  protected static final String KEY_USERAGENT = "useragent";
  private static final String TAG = "proxoid";
  protected static final String USERAGENT_ASIS = "asis";
  protected static final String USERAGENT_RANDOM = "random";
  protected static final String USERAGENT_REMOVE = "remove";
  protected static final String USERAGENT_REPLACE = "replace";
  public Context mContext = null;
  private IProxoidControl proxoidControl = null;
  
  public Proxoid(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext.bindService(new Intent(paramContext, ProxoidService.class), this, 1);
    getSharedPreferences().edit().putBoolean("onoff", true).commit();
  }
  
  private SharedPreferences getSharedPreferences()
  {
    return this.mContext.getSharedPreferences("proxoidv6", 4);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.proxoidControl = ((IProxoidControl)paramIBinder);
    if (this.proxoidControl != null) {}
    try
    {
      this.proxoidControl.update();
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.proxoidControl = null;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/proxoid/Proxoid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */