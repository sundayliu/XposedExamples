package com.android.vending.billing.InAppBillingService.LACK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.PrintStream;

public class OnAlarmReceiver
  extends BroadcastReceiver
{
  public static String ACTION_WIDGET_RECEIVER = "ActionOnTimeLucky";
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        System.out.println(paramIntent.getAction());
        if (paramIntent.getAction().equals(OnAlarmReceiver.ACTION_WIDGET_RECEIVER))
        {
          listAppsFragment.getConfig().edit().putBoolean("trigger_for_good_android_patch_on_boot", false).commit();
          if ((listAppsFragment.su) && (listAppsFragment.getConfig().getBoolean("OnBootService", false)))
          {
            listAppsFragment.getConfig().edit().putBoolean("OnBootService", false).commit();
            listAppsFragment.patchOnBoot = true;
            Intent localIntent = new Intent(listAppsFragment.getInstance(), PatchService.class);
            listAppsFragment.getInstance().startService(localIntent);
          }
        }
      }
    }).start();
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/OnAlarmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */