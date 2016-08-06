package com.proxoid;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;
import com.mba.proxylight.ProxyLight;
import com.mba.proxylight.Request;
import com.mba.proxylight.RequestFilter;
import java.util.List;

public class ProxoidService
  extends Service
{
  private static int ID = 2130837551;
  private static final String TAG = "ProxoidService";
  private ProxyLight proxy = null;
  private String randomUserAgent = Long.toString(System.currentTimeMillis(), 20);
  private String useragent = null;
  
  private void doStop()
  {
    if ((this.proxy != null) && (this.proxy.isRunning()))
    {
      Log.d("ProxoidService", "stopping");
      this.proxy.stop();
      ((NotificationManager)getSystemService("notification")).cancel(ID);
      Toast.makeText(this, "Proxy stopped.", 0).show();
      SharedPreferences.Editor localEditor = getSharedPreferences().edit();
      localEditor.putBoolean("onoff", false);
      localEditor.commit();
    }
  }
  
  private SharedPreferences getSharedPreferences()
  {
    return super.getSharedPreferences("proxoidv6", 4);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    new IProxoidControl.Stub()
    {
      public boolean update()
        throws RemoteException
      {
        boolean bool = ProxoidService.this.getSharedPreferences().getBoolean("onoff", false);
        int i = Integer.parseInt("8080");
        ProxoidService.access$102(ProxoidService.this, "Don\\'t change");
        if (!bool) {
          ProxoidService.this.doStop();
        }
        for (;;)
        {
          return true;
          if (ProxoidService.this.proxy == null)
          {
            ProxoidService.access$302(ProxoidService.this, new ProxyLight()
            {
              public void debug(String paramAnonymous2String)
              {
                if (Log.isLoggable("ProxoidService", 3)) {
                  Log.d("ProxoidService", paramAnonymous2String);
                }
                Log.e("ProxoidService", paramAnonymous2String);
              }
              
              public void error(String paramAnonymous2String, Throwable paramAnonymous2Throwable)
              {
                Log.e("ProxoidService", paramAnonymous2String, paramAnonymous2Throwable);
              }
            });
            ProxoidService.this.proxy.getRequestFilters().add(new ProxoidService.UserAgentRequestFilter(ProxoidService.this, null));
            ProxoidService.this.proxy.setPort(i);
          }
          if (ProxoidService.this.proxy.getPort() != i)
          {
            ProxoidService.this.proxy.setPort(i);
            ProxoidService.this.proxy.stop();
          }
          try
          {
            ProxoidService.this.proxy.start();
            Toast.makeText(ProxoidService.this, "Service proxy restarted", 0).show();
            if (ProxoidService.this.proxy.isRunning()) {}
          }
          catch (Exception localException1)
          {
            try
            {
              ProxoidService.this.proxy.start();
              NotificationManager localNotificationManager = (NotificationManager)ProxoidService.this.getSystemService("notification");
              Notification localNotification = new Notification(2130837552, "Lucky Patcher proxy running.", System.currentTimeMillis());
              Context localContext = ProxoidService.this.getApplicationContext();
              Intent localIntent = new Intent(ProxoidService.this, Proxoid.class);
              localNotification.setLatestEventInfo(localContext, "Lucky Proxoid", "proxy running", PendingIntent.getActivity(ProxoidService.this, 0, localIntent, 0));
              localNotification.flags |= 0x2;
              localNotificationManager.notify(ProxoidService.ID, localNotification);
              Toast.makeText(ProxoidService.this, "Proxy running.", 0).show();
            }
            catch (Exception localException2)
            {
              Log.e("ProxoidService", "", localException2);
              ProxoidService.this.proxy.stop();
              ProxoidService.access$302(ProxoidService.this, null);
            }
            localException1 = localException1;
            Log.e("ProxoidService", "", localException1);
            ProxoidService.this.proxy.stop();
            ProxoidService.access$302(ProxoidService.this, null);
            return false;
          }
        }
        return false;
      }
    };
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    doStop();
    super.onDestroy();
  }
  
  private class UserAgentRequestFilter
    implements RequestFilter
  {
    private UserAgentRequestFilter() {}
    
    public boolean filter(Request paramRequest)
    {
      return false;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/proxoid/ProxoidService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */