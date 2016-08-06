package com.android.vending.billing.InAppBillingService.LACK.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.google.android.finsky.billing.iab.InAppBillingService;
import com.google.android.finsky.billing.iab.MarketBillingService;

public class inapp_widget
  extends AppWidgetProvider
{
  public static String ACTION_WIDGET_RECEIVER = "ActionReceiverInAppWidget";
  public static String ACTION_WIDGET_RECEIVER_Updater = "ActionReceiverWidgetInAppUpdate";
  
  public static void pushWidgetUpdate(Context paramContext, RemoteViews paramRemoteViews)
  {
    ComponentName localComponentName = new ComponentName(paramContext, inapp_widget.class);
    AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, paramRemoteViews);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    paramIntent = paramIntent.getAction();
    Object localObject;
    if (ACTION_WIDGET_RECEIVER.equals(paramIntent))
    {
      listAppsFragment.init();
      localObject = new RemoteViews(paramContext.getPackageName(), 2130968639);
      ((RemoteViews)localObject).setTextViewText(2131558644, "");
      ((RemoteViews)localObject).setViewVisibility(2131558645, 0);
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
      localAppWidgetManager.updateAppWidget(localAppWidgetManager.getAppWidgetIds(new ComponentName(paramContext, inapp_widget.class)), (RemoteViews)localObject);
      if ((paramContext.getPackageManager().getComponentEnabledSetting(new ComponentName(paramContext, MarketBillingService.class)) != 2) && (paramContext.getPackageManager().getComponentEnabledSetting(new ComponentName(paramContext, InAppBillingService.class)) != 2)) {
        break label212;
      }
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), MarketBillingService.class), 1, 1);
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingService.class), 1, 1);
      Toast.makeText(paramContext, "InApp-ON", 0).show();
    }
    for (;;)
    {
      if (ACTION_WIDGET_RECEIVER_Updater.equals(paramIntent)) {}
      try
      {
        listAppsFragment.appDisabler = true;
        paramIntent = AppWidgetManager.getInstance(paramContext);
        onUpdate(paramContext, paramIntent, paramIntent.getAppWidgetIds(new ComponentName(paramContext, inapp_widget.class)));
        return;
      }
      catch (Exception paramContext)
      {
        label212:
        paramContext.printStackTrace();
      }
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), MarketBillingService.class), 2, 1);
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingService.class), 2, 1);
      localObject = new Intent(listAppsFragment.getInstance(), inapp_widget.class);
      ((Intent)localObject).setPackage(listAppsFragment.getInstance().getPackageName());
      ((Intent)localObject).setAction(ACTION_WIDGET_RECEIVER_Updater);
      listAppsFragment.getInstance().sendBroadcast((Intent)localObject);
      Toast.makeText(paramContext, "InApp-OFF", 0).show();
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130968639);
    Intent localIntent = new Intent(paramContext, inapp_widget.class);
    localIntent.setAction(ACTION_WIDGET_RECEIVER);
    localIntent.putExtra("msg", "Hello Habrahabr");
    localRemoteViews.setOnClickPendingIntent(2131558644, PendingIntent.getBroadcast(paramContext, 0, localIntent, 0));
    localRemoteViews.setTextViewText(2131558644, "InApp");
    localRemoteViews.setViewVisibility(2131558645, 8);
    if ((paramContext.getPackageManager().getComponentEnabledSetting(new ComponentName(paramContext, MarketBillingService.class)) == 2) || (paramContext.getPackageManager().getComponentEnabledSetting(new ComponentName(paramContext, InAppBillingService.class)) == 2)) {
      localRemoteViews.setTextColor(2131558644, Color.parseColor("#FF0000"));
    }
    for (;;)
    {
      paramAppWidgetManager.updateAppWidget(paramArrayOfInt, localRemoteViews);
      return;
      localRemoteViews.setTextColor(2131558644, Color.parseColor("#00FF00"));
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/widgets/inapp_widget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */