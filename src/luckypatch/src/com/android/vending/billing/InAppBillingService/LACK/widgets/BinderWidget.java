package com.android.vending.billing.InAppBillingService.LACK.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.android.vending.billing.InAppBillingService.LACK.BindItem;
import com.android.vending.billing.InAppBillingService.LACK.BinderActivity;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class BinderWidget
  extends AppWidgetProvider
{
  public static String ACTION_WIDGET_RECEIVER = "ActionReceiverWidgetBinder";
  public static String ACTION_WIDGET_RECEIVER_Updater = "ActionReceiverWidgetBinderUpdate";
  public static BinderWidget widget = null;
  
  public static void pushWidgetUpdate(Context paramContext, RemoteViews paramRemoteViews)
  {
    ComponentName localComponentName = new ComponentName(paramContext, BinderWidget.class);
    AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, paramRemoteViews);
  }
  
  static void updateAppWidget(Context paramContext, AppWidgetManager paramAppWidgetManager, final int paramInt)
  {
    listAppsFragment.init();
    paramContext = new Thread(new Runnable()
    {
      public void run()
      {
        RemoteViews localRemoteViews = new RemoteViews(this.val$context.getPackageName(), 2130968589);
        Object localObject1 = new Intent(this.val$context, BinderWidget.class);
        ((Intent)localObject1).setAction(BinderWidget.ACTION_WIDGET_RECEIVER);
        ((Intent)localObject1).putExtra("appWidgetId", paramInt);
        localRemoteViews.setOnClickPendingIntent(2131558449, PendingIntent.getBroadcast(this.val$context, paramInt, (Intent)localObject1, 0));
        localRemoteViews.setInt(2131558448, "setBackgroundResource", 2130837585);
        localRemoteViews.setTextColor(2131558447, Color.parseColor("#AAAAAA"));
        localRemoteViews.setTextViewText(2131558447, "wait");
        try
        {
          AppWidgetManager.getInstance(this.val$context).updateAppWidget(paramInt, localRemoteViews);
          if (listAppsFragment.su)
          {
            localObject1 = BinderWidgetConfigureActivity.loadTitlePref(this.val$context, paramInt);
            System.out.println((String)localObject1);
            localObject1 = new BindItem(((String)localObject1).replaceAll("~chelpus_disabled~", ""));
            if ((((BindItem)localObject1).TargetDir != null) && (!((BindItem)localObject1).TargetDir.equals("")) && (((BindItem)localObject1).SourceDir != null) && (!((BindItem)localObject1).SourceDir.equals("")))
            {
              Object localObject2 = ((BindItem)localObject1).TargetDir.split("/");
              localRemoteViews.setTextViewText(2131558447, localObject2[(localObject2.length - 1)]);
              if (Utils.checkBind((BindItem)localObject1))
              {
                localRemoteViews.setTextColor(2131558447, Color.parseColor("#00FF00"));
                localRemoteViews.setInt(2131558448, "setBackgroundResource", 2130837586);
                localObject2 = BinderActivity.getBindes(this.val$context);
                i = 0;
                localObject2 = ((ArrayList)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  BindItem localBindItem = (BindItem)((Iterator)localObject2).next();
                  if ((localBindItem.SourceDir.replaceAll("~chelpus_disabled~", "").equals(((BindItem)localObject1).SourceDir.replaceAll("~chelpus_disabled~", ""))) && (localBindItem.TargetDir.replaceAll("~chelpus_disabled~", "").equals(((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", ""))))
                  {
                    localBindItem.TargetDir = localBindItem.TargetDir.replaceAll("~chelpus_disabled~", "");
                    localBindItem.SourceDir = localBindItem.SourceDir.replaceAll("~chelpus_disabled~", "");
                    i = 1;
                  }
                }
              }
            }
          }
        }
        catch (Exception localException3)
        {
          int i;
          for (;;)
          {
            localException3.printStackTrace();
            continue;
            localRemoteViews.setTextColor(2131558447, Color.parseColor("#FF0000"));
            localRemoteViews.setInt(2131558448, "setBackgroundResource", 2130837585);
          }
          if (i == 0)
          {
            if (!listAppsFragment.su) {
              break label558;
            }
            Utils.run_all("umount -f '" + localException3.TargetDir.replaceAll("~chelpus_disabled~", "") + "'");
            Utils.run_all("umount -l '" + localException3.TargetDir.replaceAll("~chelpus_disabled~", "") + "'");
          }
          for (;;)
          {
            localRemoteViews.setInt(2131558448, "setBackgroundResource", 2130837585);
            localRemoteViews.setTextColor(2131558447, Color.parseColor("#AAAAAA"));
            localRemoteViews.setTextViewText(2131558447, "unknown bind");
            try
            {
              AppWidgetManager.getInstance(this.val$context).updateAppWidget(paramInt, localRemoteViews);
              try
              {
                AppWidgetManager.getInstance(this.val$context).updateAppWidget(paramInt, localRemoteViews);
                return;
              }
              catch (Exception localException1)
              {
                label558:
                localException1.printStackTrace();
                return;
              }
              Utils.cmd(new String[] { "umount '" + localException3.TargetDir.replaceAll("~chelpus_disabled~", "") + "'" });
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                localException4.printStackTrace();
              }
            }
          }
          localException1.setInt(2131558448, "setBackgroundResource", 2130837585);
          localException1.setTextColor(2131558447, Color.parseColor("#AAAAAA"));
          localException1.setTextViewText(2131558447, "you need root access");
          try
          {
            AppWidgetManager.getInstance(this.val$context).updateAppWidget(paramInt, localException1);
            return;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
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
      BinderWidgetConfigureActivity.deleteTitlePref(paramContext, paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  public void onDisabled(Context paramContext) {}
  
  public void onEnabled(Context paramContext) {}
  
  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    String str = paramIntent.getAction();
    final Handler localHandler;
    if (ACTION_WIDGET_RECEIVER.equals(str))
    {
      listAppsFragment.init();
      if (!BinderWidgetConfigureActivity.loadTitlePref(paramContext, paramIntent.getIntExtra("appWidgetId", -1)).equals("NOT_SAVED_BIND")) {
        widget = this;
      }
      localHandler = new Handler();
    }
    try
    {
      paramIntent = new Thread(new Runnable()
      {
        public void run()
        {
          listAppsFragment.binder_process = true;
          Utils.exitRoot();
          int j = paramIntent.getIntExtra("appWidgetId", -1);
          final Object localObject1;
          Object localObject2;
          ArrayList localArrayList;
          int i;
          Iterator localIterator;
          BindItem localBindItem;
          if ((j != -1) && (!BinderWidgetConfigureActivity.loadTitlePref(paramContext, j).equals("NOT_SAVED_BIND")))
          {
            localObject1 = new BindItem(BinderWidgetConfigureActivity.loadTitlePref(paramContext, j));
            localObject2 = new RemoteViews(paramContext.getPackageName(), 2130968589);
            ((BindItem)localObject1).TargetDir = ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "");
            ((BindItem)localObject1).SourceDir = ((BindItem)localObject1).SourceDir.replaceAll("~chelpus_disabled~", "");
            if (Utils.checkBind((BindItem)localObject1)) {
              break label623;
            }
            localArrayList = BinderActivity.getBindes(paramContext);
            i = 0;
            localIterator = localArrayList.iterator();
            while (localIterator.hasNext())
            {
              localBindItem = (BindItem)localIterator.next();
              if ((localBindItem.SourceDir.replaceAll("~chelpus_disabled~", "").equals(((BindItem)localObject1).SourceDir.replaceAll("~chelpus_disabled~", ""))) && (localBindItem.TargetDir.replaceAll("~chelpus_disabled~", "").equals(((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", ""))))
              {
                localBindItem.TargetDir = localBindItem.TargetDir.replaceAll("~chelpus_disabled~", "");
                localBindItem.SourceDir = localBindItem.SourceDir.replaceAll("~chelpus_disabled~", "");
                BinderWidgetConfigureActivity.saveTitlePref(paramContext, j, localBindItem.toString());
                i = 1;
              }
            }
            if (i == 0)
            {
              if (!listAppsFragment.su) {
                break label575;
              }
              Utils.run_all("umount -f '" + ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "") + "'");
              Utils.run_all("umount -l '" + ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "") + "'");
              ((RemoteViews)localObject2).setInt(2131558448, "setBackgroundResource", 2130837585);
              ((RemoteViews)localObject2).setTextColor(2131558447, Color.parseColor("#AAAAAA"));
            }
            BinderActivity.savetoFile(localArrayList, paramContext);
            Utils.verify_bind_and_run("mount", "-o bind '" + ((BindItem)localObject1).SourceDir.replaceAll("~chelpus_disabled~", "") + "' '" + ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "") + "'", ((BindItem)localObject1).SourceDir.replaceAll("~chelpus_disabled~", ""), ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", ""));
            label456:
            if (!Utils.checkBind((BindItem)localObject1)) {
              break label1099;
            }
            ((RemoteViews)localObject2).setTextColor(2131558447, Color.parseColor("#00FF00"));
            ((RemoteViews)localObject2).setInt(2131558448, "setBackgroundResource", 2130837586);
            localHandler.post(new Runnable()
            {
              public void run()
              {
                Toast.makeText(BinderWidget.2.this.val$context, "ON " + localObject1.TargetDir.replaceAll("~chelpus_disabled~", ""), 0).show();
              }
            });
          }
          for (;;)
          {
            new ComponentName(paramContext, BinderWidget.class);
            AppWidgetManager.getInstance(paramContext).updateAppWidget(j, (RemoteViews)localObject2);
            localObject1 = AppWidgetManager.getInstance(paramContext);
            localObject2 = ((AppWidgetManager)localObject1).getAppWidgetIds(new ComponentName(paramContext, BinderWidget.class));
            BinderWidget.widget.onUpdate(paramContext, (AppWidgetManager)localObject1, (int[])localObject2);
            listAppsFragment.binder_process = false;
            return;
            label575:
            Utils.cmd(new String[] { "umount '" + ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "") + "'" });
            break;
            label623:
            ((BindItem)localObject1).TargetDir = ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "");
            ((BindItem)localObject1).SourceDir = ((BindItem)localObject1).SourceDir.replaceAll("~chelpus_disabled~", "");
            localArrayList = BinderActivity.getBindes(paramContext);
            i = 0;
            localIterator = localArrayList.iterator();
            while (localIterator.hasNext())
            {
              localBindItem = (BindItem)localIterator.next();
              if ((localBindItem.SourceDir.replaceAll("~chelpus_disabled~", "").equals(((BindItem)localObject1).SourceDir.replaceAll("~chelpus_disabled~", ""))) && (localBindItem.TargetDir.replaceAll("~chelpus_disabled~", "").equals(((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", ""))))
              {
                localBindItem.TargetDir = ("~chelpus_disabled~" + localBindItem.TargetDir.replaceAll("~chelpus_disabled~", ""));
                localBindItem.SourceDir = localBindItem.SourceDir;
                i = 1;
              }
            }
            if (i == 0)
            {
              if (listAppsFragment.su)
              {
                Utils.run_all("umount -f '" + ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "") + "'");
                Utils.run_all("umount -l '" + ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "") + "'");
              }
              for (;;)
              {
                ((RemoteViews)localObject2).setInt(2131558448, "setBackgroundResource", 2130837585);
                ((RemoteViews)localObject2).setTextColor(2131558447, Color.parseColor("#AAAAAA"));
                break;
                Utils.cmd(new String[] { "umount '" + ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "") + "'" });
              }
            }
            BinderActivity.savetoFile(localArrayList, paramContext);
            if (listAppsFragment.su)
            {
              Utils.run_all("umount -f '" + ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "") + "'");
              Utils.run_all("umount -l '" + ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "") + "'");
              break label456;
            }
            Utils.cmd(new String[] { "umount '" + ((BindItem)localObject1).TargetDir.replaceAll("~chelpus_disabled~", "") + "'" });
            break label456;
            label1099:
            ((RemoteViews)localObject2).setTextColor(2131558447, Color.parseColor("#FF0000"));
            ((RemoteViews)localObject2).setInt(2131558448, "setBackgroundResource", 2130837585);
            localHandler.post(new Runnable()
            {
              public void run()
              {
                Toast.makeText(BinderWidget.2.this.val$context, "OFF " + localObject1.TargetDir.replaceAll("~chelpus_disabled~", ""), 0).show();
              }
            });
          }
        }
      });
      paramIntent.setPriority(10);
      if (!listAppsFragment.binder_process) {
        paramIntent.start();
      }
      if (ACTION_WIDGET_RECEIVER_Updater.equals(str))
      {
        listAppsFragment.binderWidget = true;
        paramIntent = AppWidgetManager.getInstance(paramContext);
        onUpdate(paramContext, paramIntent, paramIntent.getAppWidgetIds(new ComponentName(paramContext, BinderWidget.class)));
      }
      return;
    }
    catch (NullPointerException paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/widgets/BinderWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */