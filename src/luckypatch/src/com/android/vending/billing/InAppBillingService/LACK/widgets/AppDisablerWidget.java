package com.android.vending.billing.InAppBillingService.LACK.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.os.Handler;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;

public class AppDisablerWidget
  extends AppWidgetProvider
{
  public static String ACTION_WIDGET_RECEIVER = "ActionReceiverWidgetAppDisabler";
  public static String ACTION_WIDGET_RECEIVER_Updater = "ActionReceiverWidgetAppDisablerUpdate";
  
  public static void pushWidgetUpdate(Context paramContext, RemoteViews paramRemoteViews)
  {
    ComponentName localComponentName = new ComponentName(paramContext, AppDisablerWidget.class);
    AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, paramRemoteViews);
  }
  
  static void updateAppWidget(Context paramContext, final AppWidgetManager paramAppWidgetManager, final int paramInt)
  {
    listAppsFragment.init();
    paramContext = new Thread(new Runnable()
    {
      public void run()
      {
        if (listAppsFragment.su)
        {
          String str = AppDisablerWidgetConfigureActivity.loadTitlePref(this.val$context, paramInt);
          AppDisablerWidgetConfigureActivity.loadRunBooleanPref(this.val$context, paramInt);
          for (;;)
          {
            try
            {
              Object localObject2 = this.val$context.getPackageManager();
              localObject1 = new RemoteViews(this.val$context.getPackageName(), 2130968582);
              ((RemoteViews)localObject1).setTextViewText(2131558447, ((PackageManager)localObject2).getApplicationLabel(((PackageManager)localObject2).getApplicationInfo(str, 0)));
              if (((PackageManager)localObject2).getPackageInfo(str, 0).applicationInfo.enabled)
              {
                ((RemoteViews)localObject1).setTextColor(2131558447, Color.parseColor("#00FF00"));
                ((RemoteViews)localObject1).setInt(2131558448, "setBackgroundResource", 2130837586);
                localObject2 = new Intent(this.val$context, AppDisablerWidget.class);
                ((Intent)localObject2).setAction(AppDisablerWidget.ACTION_WIDGET_RECEIVER);
                ((Intent)localObject2).putExtra("appWidgetId", paramInt);
                ((Intent)localObject2).putExtra("msg", str);
                ((RemoteViews)localObject1).setOnClickPendingIntent(2131558449, PendingIntent.getBroadcast(this.val$context, paramInt, (Intent)localObject2, 0));
              }
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException)
            {
              RemoteViews localRemoteViews1 = new RemoteViews(this.val$context.getPackageName(), 2130968582);
              localObject1 = new Intent(this.val$context, AppDisablerWidget.class);
              localRemoteViews1.setOnClickPendingIntent(2131558449, PendingIntent.getBroadcast(this.val$context, paramInt, (Intent)localObject1, 0));
              localRemoteViews1.setInt(2131558448, "setBackgroundResource", 2130837585);
              localRemoteViews1.setTextColor(2131558447, Color.parseColor("#AAAAAA"));
              localRemoteViews1.setTextViewText(2131558447, Utils.getText(2131165756));
              try
              {
                paramAppWidgetManager.updateAppWidget(paramInt, localRemoteViews1);
                return;
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
                return;
              }
            }
            try
            {
              paramAppWidgetManager.updateAppWidget(paramInt, (RemoteViews)localObject1);
              return;
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              return;
            }
            ((RemoteViews)localObject1).setTextColor(2131558447, Color.parseColor("#FF0000"));
            ((RemoteViews)localObject1).setInt(2131558448, "setBackgroundResource", 2130837585);
          }
        }
        RemoteViews localRemoteViews2 = new RemoteViews(this.val$context.getPackageName(), 2130968582);
        Object localObject1 = new Intent(this.val$context, AppDisablerWidget.class);
        localRemoteViews2.setOnClickPendingIntent(2131558449, PendingIntent.getBroadcast(this.val$context, paramInt, (Intent)localObject1, 0));
        localRemoteViews2.setInt(2131558448, "setBackgroundResource", 2130837585);
        localRemoteViews2.setTextColor(2131558447, Color.parseColor("#AAAAAA"));
        localRemoteViews2.setTextViewText(2131558447, "you need root access");
        try
        {
          AppWidgetManager.getInstance(this.val$context).updateAppWidget(paramInt, localRemoteViews2);
          return;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
        }
      }
    });
    paramContext.setPriority(10);
    paramContext.start();
  }
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      AppDisablerWidgetConfigureActivity.deleteTitlePref(paramContext, paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  public void onDisabled(Context paramContext) {}
  
  public void onEnabled(Context paramContext) {}
  
  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (ACTION_WIDGET_RECEIVER.equals(localObject))
    {
      listAppsFragment.init();
      Thread localThread = new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            PackageManager localPackageManager = paramContext.getPackageManager();
            int i = paramIntent.getIntExtra("appWidgetId", -1);
            if ((i != -1) && (!AppDisablerWidgetConfigureActivity.loadTitlePref(paramContext, i).equals("NOT_SAVED_APP_DISABLER")))
            {
              final String str = AppDisablerWidgetConfigureActivity.loadTitlePref(paramContext, i);
              boolean bool = AppDisablerWidgetConfigureActivity.loadRunBooleanPref(paramContext, i);
              RemoteViews localRemoteViews2 = new RemoteViews(paramContext.getPackageName(), 2130968582);
              if (localPackageManager.getPackageInfo(str, 0).applicationInfo.enabled)
              {
                new Utils("").cmdRoot(new String[] { "pm disable " + str });
                localRemoteViews2.setInt(2131558448, "setBackgroundResource", 2130837585);
                localRemoteViews2.setTextColor(2131558447, Color.parseColor("#FF0000"));
                this.val$handler.post(new Runnable()
                {
                  public void run()
                  {
                    Toast.makeText(AppDisablerWidget.2.this.val$context, "OFF " + str, 0).show();
                    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(AppDisablerWidget.2.this.val$context);
                    int[] arrayOfInt = localAppWidgetManager.getAppWidgetIds(new ComponentName(AppDisablerWidget.2.this.val$context, AppDisablerWidget.class));
                    AppDisablerWidget.this.onUpdate(AppDisablerWidget.2.this.val$context, localAppWidgetManager, arrayOfInt);
                  }
                });
                return;
              }
              new Utils("").cmdRoot(new String[] { "pm enable " + str });
              if (bool) {
                Utils.startApp(str);
              }
              localRemoteViews2.setTextColor(2131558447, Color.parseColor("#00FF00"));
              localRemoteViews2.setInt(2131558448, "setBackgroundResource", 2130837586);
              this.val$handler.post(new Runnable()
              {
                public void run()
                {
                  Toast.makeText(AppDisablerWidget.2.this.val$context, "ON " + str, 0).show();
                  AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(AppDisablerWidget.2.this.val$context);
                  int[] arrayOfInt = localAppWidgetManager.getAppWidgetIds(new ComponentName(AppDisablerWidget.2.this.val$context, AppDisablerWidget.class));
                  AppDisablerWidget.this.onUpdate(AppDisablerWidget.2.this.val$context, localAppWidgetManager, arrayOfInt);
                }
              });
              return;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            RemoteViews localRemoteViews1 = new RemoteViews(paramContext.getPackageName(), 2130968582);
            localRemoteViews1.setBoolean(2131558448, "setEnabled", false);
            localRemoteViews1.setInt(2131558448, "setBackgroundResource", 2130837585);
            localRemoteViews1.setTextColor(2131558447, Color.parseColor("#AAAAAA"));
            localRemoteViews1.setTextViewText(2131558447, Utils.getText(2131165756));
            this.val$handler.post(new Runnable()
            {
              public void run()
              {
                AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(AppDisablerWidget.2.this.val$context);
                int[] arrayOfInt = localAppWidgetManager.getAppWidgetIds(new ComponentName(AppDisablerWidget.2.this.val$context, AppDisablerWidget.class));
                AppDisablerWidget.this.onUpdate(AppDisablerWidget.2.this.val$context, localAppWidgetManager, arrayOfInt);
              }
            });
          }
        }
      });
      localThread.setPriority(10);
      localThread.start();
    }
    if (ACTION_WIDGET_RECEIVER_Updater.equals(localObject)) {}
    try
    {
      listAppsFragment.appDisabler = true;
      localObject = AppWidgetManager.getInstance(paramContext);
      onUpdate(paramContext, (AppWidgetManager)localObject, ((AppWidgetManager)localObject).getAppWidgetIds(new ComponentName(paramContext, AppDisablerWidget.class)));
      super.onReceive(paramContext, paramIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      updateAppWidget(paramContext, paramAppWidgetManager, paramArrayOfInt[i]);
      i += 1;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/widgets/AppDisablerWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */