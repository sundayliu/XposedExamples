package com.android.vending.billing.InAppBillingService.LACK.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import com.google.android.finsky.services.LicensingService;

public class lvl_widget
  extends AppWidgetProvider
{
  public static String ACTION_WIDGET_RECEIVER = "ActionReceiverLVLWidget";
  public static String ACTION_WIDGET_RECEIVER_Updater = "ActionReceiverWidgetLVLUpdate";
  
  public static void pushWidgetUpdate(Context paramContext, RemoteViews paramRemoteViews)
  {
    ComponentName localComponentName = new ComponentName(paramContext, lvl_widget.class);
    AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, paramRemoteViews);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (ACTION_WIDGET_RECEIVER.equals(localObject))
    {
      listAppsFragment.init();
      RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130968640);
      localRemoteViews.setTextViewText(2131558646, "");
      localRemoteViews.setViewVisibility(2131558647, 0);
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
      localAppWidgetManager.updateAppWidget(localAppWidgetManager.getAppWidgetIds(new ComponentName(paramContext, lvl_widget.class)), localRemoteViews);
      if (paramContext.getPackageManager().getComponentEnabledSetting(new ComponentName(paramContext, LicensingService.class)) != 2) {
        break label211;
      }
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class), 1, 1);
      if (!listAppsFragment.getConfig().getBoolean("LVL_enable", false)) {
        listAppsFragment.getConfig().edit().putBoolean("LVL_enable", true).commit();
      }
      Toast.makeText(paramContext, "LVL-ON", 0).show();
    }
    for (;;)
    {
      if (ACTION_WIDGET_RECEIVER_Updater.equals(localObject)) {}
      try
      {
        listAppsFragment.appDisabler = true;
        localObject = AppWidgetManager.getInstance(paramContext);
        onUpdate(paramContext, (AppWidgetManager)localObject, ((AppWidgetManager)localObject).getAppWidgetIds(new ComponentName(paramContext, lvl_widget.class)));
        super.onReceive(paramContext, paramIntent);
        return;
        label211:
        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class), 2, 1);
        if (listAppsFragment.su) {
          Utils.market_licensing_services(true);
        }
        Toast.makeText(paramContext, "LVL-OFF", 0).show();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130968640);
    Intent localIntent = new Intent(paramContext, lvl_widget.class);
    localIntent.setAction(ACTION_WIDGET_RECEIVER);
    localIntent.putExtra("msg", "Hello Habrahabr");
    localRemoteViews.setOnClickPendingIntent(2131558646, PendingIntent.getBroadcast(paramContext, 0, localIntent, 0));
    localRemoteViews.setTextViewText(2131558646, "LVL");
    localRemoteViews.setViewVisibility(2131558647, 8);
    if (paramContext.getPackageManager().getComponentEnabledSetting(new ComponentName(paramContext, LicensingService.class)) == 2) {
      localRemoteViews.setTextColor(2131558646, Color.parseColor("#FF0000"));
    }
    for (;;)
    {
      paramAppWidgetManager.updateAppWidget(paramArrayOfInt, localRemoteViews);
      return;
      localRemoteViews.setTextColor(2131558646, Color.parseColor("#00FF00"));
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/widgets/lvl_widget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */