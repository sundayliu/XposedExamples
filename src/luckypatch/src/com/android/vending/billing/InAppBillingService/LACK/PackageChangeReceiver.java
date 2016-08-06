package com.android.vending.billing.InAppBillingService.LACK;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.InAppBillingService.LACK.widgets.AppDisablerWidget;
import com.android.vending.billing.InAppBillingService.LACK.widgets.inapp_widget;
import com.android.vending.billing.InAppBillingService.LACK.widgets.lvl_widget;
import com.android.vending.billing.InAppBillingService.LACK.widgets.proxyGP_widget;
import com.android.vending.licensing.ILicensingService;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.InAppBillingFService;
import com.google.android.finsky.billing.iab.InAppBillingService;
import com.google.android.finsky.billing.iab.MarketBillingService;
import com.google.android.finsky.services.LicensingService;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PackageChangeReceiver
  extends BroadcastReceiver
{
  static ServiceConnection mServiceConn;
  static ServiceConnection mServiceConnL;
  boolean hackedBilling = false;
  Handler handler = null;
  IInAppBillingService mService;
  ILicensingService mServiceL;
  boolean mSetupDone = false;
  int responseCode = 255;
  
  private void cleanupService()
  {
    if (this.mServiceL != null) {}
    try
    {
      listAppsFragment.getInstance().unbindService(mServiceConnL);
      this.mServiceL = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public String backup(String paramString)
  {
    if (testSD())
    {
      new File(listAppsFragment.basepath + "/Backup/").mkdirs();
      try
      {
        String str;
        if (listAppsFragment.getConfig().getInt("apkname", 0) != 0) {
          str = listAppsFragment.basepath + "/Backup/" + paramString + ".ver." + listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).versionName.replaceAll(" ", ".") + ".build." + listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).versionCode + ".apk";
        }
        for (;;)
        {
          if (new File(str).exists()) {
            new File(str).delete();
          }
          try
          {
            Utils.copyFile(new File(listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).applicationInfo.sourceDir), new File(str));
            if (!new File(str).exists())
            {
              new Utils("").cmdRoot(new String[] { "dd if=" + listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).applicationInfo.sourceDir + " of=" + str });
              Utils.run_all("chmod 777 " + str);
            }
            if (new File(str).exists())
            {
              this.handler.post(new Runnable()
              {
                public void run()
                {
                  Toast.makeText(listAppsFragment.getInstance(), Utils.getText(2131165217) + " " + listAppsFragment.basepath + "/Backup/", 1).show();
                }
              });
              return str;
              str = listAppsFragment.basepath + "/Backup/" + listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).applicationInfo.loadLabel(listAppsFragment.getPkgMng()).toString() + ".ver." + listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).versionName.replaceAll(" ", ".") + ".build." + listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).versionCode + ".apk";
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Utils.copyFile(listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).applicationInfo.sourceDir, str, false, false);
              localException.printStackTrace();
            }
          }
        }
        return "";
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
        return "";
        this.handler.post(new Runnable()
        {
          public void run()
          {
            Toast.makeText(listAppsFragment.getInstance(), Utils.getText(2131165748) + ":" + Utils.getText(2131165432), 1).show();
          }
        });
        return "";
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void connectToBilling()
  {
    Intent localIntent;
    if (this.mSetupDone) {
      localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    }
    try
    {
      if (mServiceConn != null) {
        listAppsFragment.getInstance().unbindService(mServiceConn);
      }
      this.mSetupDone = false;
      listAppsFragment.getInstance().bindService(localIntent, mServiceConn, 1);
      mServiceConn = new ServiceConnection()
      {
        public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
        {
          System.out.println("Billing service try to connect.");
          if (!paramAnonymousComponentName.getPackageName().equals(listAppsFragment.class.getPackage().getName()))
          {
            System.out.println("Firmware not support hacked billing");
            if (!listAppsFragment.su)
            {
              Utils.showSystemWindow(Utils.getText(2131165748), Utils.getText(2131165800), new View.OnClickListener()new View.OnClickListener
              {
                public void onClick(View paramAnonymous2View)
                {
                  Intent localIntent;
                  if (Build.VERSION.SDK_INT >= 9)
                  {
                    localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:com.android.vending"));
                    localIntent.setFlags(131072);
                    localIntent.setFlags(268435456);
                    listAppsFragment.getInstance().startActivity(localIntent);
                  }
                  for (;;)
                  {
                    ((WindowManager)listAppsFragment.getInstance().getSystemService("window")).removeView(paramAnonymous2View.getRootView());
                    return;
                    localIntent = new Intent("android.intent.action.VIEW");
                    localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                    localIntent.putExtra("com.android.settings.ApplicationPkgName", "com.android.vending");
                    localIntent.putExtra("pkg", "com.android.vending");
                    localIntent.setFlags(131072);
                    localIntent.setFlags(268435456);
                    listAppsFragment.getInstance().startActivity(localIntent);
                  }
                }
              }, new View.OnClickListener()
              {
                public void onClick(View paramAnonymous2View)
                {
                  ((WindowManager)listAppsFragment.getInstance().getSystemService("window")).removeView(paramAnonymous2View.getRootView());
                }
              });
              listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), MarketBillingService.class), 2, 1);
              listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingService.class), 2, 1);
            }
            for (;;)
            {
              paramAnonymousComponentName = new Intent(listAppsFragment.getInstance(), inapp_widget.class);
              paramAnonymousComponentName.setAction(inapp_widget.ACTION_WIDGET_RECEIVER_Updater);
              listAppsFragment.getInstance().sendBroadcast(paramAnonymousComponentName);
              try
              {
                listAppsFragment.getInstance().unbindService(PackageChangeReceiver.mServiceConn);
                return;
              }
              catch (Exception paramAnonymousComponentName)
              {
                paramAnonymousComponentName.printStackTrace();
                return;
              }
              new Thread(new Runnable()
              {
                public void run() {}
              }).start();
            }
          }
          System.out.println("Billing service connected.");
          try
          {
            listAppsFragment.getInstance().unbindService(PackageChangeReceiver.mServiceConn);
            return;
          }
          catch (Exception paramAnonymousComponentName)
          {
            paramAnonymousComponentName.printStackTrace();
          }
        }
        
        public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
        {
          System.out.println("Billing service disconnected.");
          PackageChangeReceiver.this.mSetupDone = false;
          PackageChangeReceiver.this.mService = null;
        }
      };
      localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      if (!listAppsFragment.getPkgMng().queryIntentServices(localIntent, 0).isEmpty())
      {
        listAppsFragment.getInstance().bindService(localIntent, mServiceConn, 1);
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        System.out.println("Billing service unavailable on device.");
      } while (!listAppsFragment.su);
      Utils.market_billing_services(true);
      listAppsFragment.getInstance().bindService(localIntent, mServiceConn, 1);
      localIntent = new Intent(listAppsFragment.getInstance(), inapp_widget.class);
      localIntent.setAction(inapp_widget.ACTION_WIDGET_RECEIVER_Updater);
      listAppsFragment.getInstance().sendBroadcast(localIntent);
    }
  }
  
  public void connectToLicensing()
  {
    mServiceConnL = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        System.out.println("Licensing service try to connect.");
        if (!paramAnonymousComponentName.getPackageName().equals(listAppsFragment.class.getPackage().getName()))
        {
          if (!listAppsFragment.su) {
            break label68;
          }
          new Thread(new Runnable()
          {
            public void run()
            {
              Utils.market_licensing_services(false);
            }
          }).start();
        }
        for (;;)
        {
          System.out.println("Firmware not support lvl emulation");
          try
          {
            listAppsFragment.getInstance().unbindService(PackageChangeReceiver.mServiceConnL);
            return;
          }
          catch (Exception paramAnonymousComponentName)
          {
            label68:
            paramAnonymousComponentName.printStackTrace();
          }
          Utils.showSystemWindow(Utils.getText(2131165748), Utils.getText(2131165800), new View.OnClickListener()new View.OnClickListener
          {
            public void onClick(View paramAnonymous2View)
            {
              Intent localIntent;
              if (Build.VERSION.SDK_INT >= 9)
              {
                localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:com.android.vending"));
                localIntent.setFlags(131072);
                localIntent.setFlags(268435456);
                listAppsFragment.getInstance().startActivity(localIntent);
              }
              for (;;)
              {
                ((WindowManager)listAppsFragment.getInstance().getSystemService("window")).removeView(paramAnonymous2View.getRootView());
                return;
                localIntent = new Intent("android.intent.action.VIEW");
                localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                localIntent.putExtra("com.android.settings.ApplicationPkgName", "com.android.vending");
                localIntent.putExtra("pkg", "com.android.vending");
                localIntent.setFlags(131072);
                localIntent.setFlags(268435456);
                listAppsFragment.getInstance().startActivity(localIntent);
              }
            }
          }, new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              ((WindowManager)listAppsFragment.getInstance().getSystemService("window")).removeView(paramAnonymous2View.getRootView());
            }
          });
          listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class), 2, 1);
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        System.out.println("Licensing service disconnected.");
        PackageChangeReceiver.this.mServiceL = null;
      }
    };
    if (this.mServiceL == null) {
      try
      {
        Intent localIntent = new Intent(new String(Base64.decode("Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U=")));
        if (listAppsFragment.getInstance().bindService(localIntent, mServiceConnL, 1)) {
          return;
        }
        cleanupService();
        return;
      }
      catch (SecurityException localSecurityException)
      {
        cleanupService();
        return;
      }
      catch (Base64DecoderException localBase64DecoderException)
      {
        localBase64DecoderException.printStackTrace();
        cleanupService();
      }
    }
  }
  
  String getPackageName(Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    if (paramIntent != null) {
      return paramIntent.getSchemeSpecificPart();
    }
    return null;
  }
  
  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    this.handler = new Handler();
    new Thread(new Runnable()
    {
      public void run()
      {
        System.out.println(paramIntent.getAction());
        Object localObject1;
        if (paramIntent.getAction().equals("android.intent.action.PACKAGE_CHANGED"))
        {
          localObject1 = new Intent(paramContext, AppDisablerWidget.class);
          ((Intent)localObject1).setAction(AppDisablerWidget.ACTION_WIDGET_RECEIVER_Updater);
          paramContext.sendBroadcast((Intent)localObject1);
          listAppsFragment.init();
        }
        for (;;)
        {
          Object localObject4;
          int i2;
          int j;
          int i1;
          int k;
          int m;
          int n;
          Object localObject5;
          int i3;
          int i4;
          try
          {
            System.out.println(paramIntent.getData().toString());
            if (PackageChangeReceiver.this.getPackageName(paramIntent).equals(listAppsFragment.class.getPackage().getName()))
            {
              localObject1 = paramIntent.getStringArrayExtra("android.intent.extra.changed_component_name_list");
              if ((localObject1 != null) && (localObject1.length > 0) && (listAppsFragment.frag != null))
              {
                System.out.println("update adapt " + localObject1[0]);
                boolean bool = localObject1[0].contains("com.android.vending.billing.InAppBillingService.LACK.MainActivity");
                if (bool) {
                  try
                  {
                    if (!listAppsFragment.su) {
                      continue;
                    }
                    localObject1 = new Intent("android.intent.action.MAIN");
                    ((Intent)localObject1).addCategory("android.intent.category.HOME");
                    ((Intent)localObject1).addCategory("android.intent.category.DEFAULT");
                    localObject1 = listAppsFragment.getPkgMng().queryIntentActivities((Intent)localObject1, 0).iterator();
                    if (!((Iterator)localObject1).hasNext()) {
                      continue;
                    }
                    localObject4 = (ResolveInfo)((Iterator)localObject1).next();
                    if (((ResolveInfo)localObject4).activityInfo == null) {
                      continue;
                    }
                    new Thread(new Runnable()
                    {
                      public void run()
                      {
                        Utils.kill(this.val$pn);
                        Utils.kill(this.val$pkg);
                      }
                    }).start();
                    continue;
                    if (PackageChangeReceiver.this.getPackageName(paramIntent).equals("com.android.vending")) {
                      continue;
                    }
                  }
                  catch (Exception localException1)
                  {
                    localException1.printStackTrace();
                  }
                }
              }
            }
            if (PackageChangeReceiver.this.getPackageName(paramIntent).equals("com.google.android.gms"))
            {
              localObject2 = new Intent(listAppsFragment.getInstance(), proxyGP_widget.class);
              ((Intent)localObject2).setPackage(listAppsFragment.getInstance().getPackageName());
              ((Intent)localObject2).setAction(proxyGP_widget.ACTION_WIDGET_RECEIVER_Updater);
              listAppsFragment.getInstance().sendBroadcast((Intent)localObject2);
              localObject2 = paramIntent.getStringArrayExtra("android.intent.extra.changed_component_name_list");
              if ((localObject2 != null) && (localObject2.length > 0))
              {
                if ((PackageChangeReceiver.this.getPackageName(paramIntent).equals("com.google.android.gms")) && (listAppsFragment.frag != null))
                {
                  System.out.println("update adapt " + localObject2[0]);
                  listAppsFragment.frag.runToMain(new Runnable()
                  {
                    public void run()
                    {
                      listAppsFragment.removeDialogLP(11);
                    }
                  });
                }
                if ((listAppsFragment.menu_adapt != null) && (listAppsFragment.frag != null))
                {
                  System.out.println("update adapt " + localObject2[0]);
                  listAppsFragment.frag.runToMain(new Runnable()
                  {
                    public void run()
                    {
                      listAppsFragment.removeDialogLP(11);
                      listAppsFragment.menu_adapt.notifyDataSetChanged();
                    }
                  });
                }
              }
            }
            if (!PackageChangeReceiver.this.getPackageName(paramIntent).equals(listAppsFragment.getInstance().getPackageName())) {
              break label4238;
            }
            Object localObject2 = paramIntent.getStringArrayExtra("android.intent.extra.changed_component_name_list");
            if ((localObject2 == null) || (localObject2.length <= 0)) {
              break label4238;
            }
            i2 = 0;
            j = 0;
            i1 = 0;
            k = 0;
            int i5 = localObject2.length;
            int i = 0;
            if (i >= i5) {
              break label4170;
            }
            localObject4 = localObject2[i];
            if (!((String)localObject4).equals("com.google.android.finsky.billing.iab.MarketBillingService"))
            {
              m = i2;
              n = i1;
              if (!((String)localObject4).equals("com.google.android.finsky.billing.iab.InAppBillingService")) {}
            }
            else
            {
              System.out.println((String)localObject4);
              localObject5 = new Intent(listAppsFragment.getInstance(), inapp_widget.class);
              ((Intent)localObject5).setPackage(listAppsFragment.getInstance().getPackageName());
              ((Intent)localObject5).setAction(inapp_widget.ACTION_WIDGET_RECEIVER_Updater);
              listAppsFragment.getInstance().sendBroadcast((Intent)localObject5);
              if (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingFService.class)) != 1) {
                break label4151;
              }
              m = 1;
              n = i1;
            }
            i3 = k;
            i4 = j;
            if (((String)localObject4).equals("com.licensinghack.LicensingService"))
            {
              System.out.println((String)localObject4);
              localObject4 = new Intent(listAppsFragment.getInstance(), lvl_widget.class);
              ((Intent)localObject4).setPackage(listAppsFragment.getInstance().getPackageName());
              ((Intent)localObject4).setAction(lvl_widget.ACTION_WIDGET_RECEIVER_Updater);
              listAppsFragment.getInstance().sendBroadcast((Intent)localObject4);
              i1 = listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class));
              if (i1 != 1) {
                break label4161;
              }
              i4 = 1;
              i3 = k;
            }
            label811:
            i += 1;
            i2 = m;
            i1 = n;
            k = i3;
            j = i4;
            continue;
            listAppsFragment.frag.runToMain(new Runnable()
            {
              public void run()
              {
                listAppsFragment.removeDialogLP(11);
              }
            });
            continue;
            if (!paramIntent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
              break label1631;
            }
          }
          catch (RuntimeException localRuntimeException1)
          {
            localRuntimeException1.printStackTrace();
          }
          label856:
          final Object localObject3 = new Intent(paramContext, AppDisablerWidget.class);
          ((Intent)localObject3).setAction(AppDisablerWidget.ACTION_WIDGET_RECEIVER_Updater);
          paramContext.sendBroadcast((Intent)localObject3);
          listAppsFragment.init();
          System.out.println("intent pkg " + PackageChangeReceiver.this.getPackageName(paramIntent));
          if (PackageChangeReceiver.this.getPackageName(paramIntent).equals(listAppsFragment.getInstance().getPackageName()))
          {
            System.out.println("Start updated LP.");
            localObject3 = new Intent("android.intent.action.MAIN");
            ((Intent)localObject3).setComponent(new ComponentName(listAppsFragment.getInstance().getPackageName(), patchActivity.class.getName()));
            ((Intent)localObject3).setFlags(270532608);
            ((Intent)localObject3).addCategory("android.intent.category.LAUNCHER");
            paramContext.startActivity((Intent)localObject3);
          }
          try
          {
            System.out.println(paramIntent.getData().toString());
            localObject3 = PackageChangeReceiver.this.getPackageName(paramIntent);
            listAppsFragment.getConfig().edit().putBoolean((String)localObject3, false).commit();
            if (listAppsFragment.su)
            {
              if (new File("/data/app/" + (String)localObject3 + "-1.odex").exists()) {
                Utils.run_all("rm /data/app/" + (String)localObject3 + "-1.odex");
              }
              if (new File("/data/app/" + (String)localObject3 + "-2.odex").exists()) {
                Utils.run_all("rm /data/app/" + (String)localObject3 + "-2.odex");
              }
              if (new File("/data/app/" + (String)localObject3 + ".odex").exists()) {
                Utils.run_all("rm /data/app/" + (String)localObject3 + ".odex");
              }
            }
            if ((((String)localObject3).contains("com.android.vending")) || (((String)localObject3).contains(paramContext.getPackageName())))
            {
              if (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(paramContext, LicensingService.class)) == 2)
              {
                Utils.market_licensing_services(true);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class), 2, 1);
                label1380:
                if ((listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(paramContext, MarketBillingService.class)) != 2) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(paramContext, InAppBillingService.class)) != 2)) {
                  break label4432;
                }
                Utils.market_billing_services(true);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), MarketBillingService.class), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingService.class), 2, 1);
              }
            }
            else {
              label1474:
              if (listAppsFragment.getConfig().getBoolean("manual_path", false)) {
                listAppsFragment.days = listAppsFragment.getConfig().getInt("days_on_up", 1);
              }
            }
          }
          catch (RuntimeException localRuntimeException3)
          {
            try
            {
              localObject3 = new PkgListItem(listAppsFragment.getInstance(), PackageChangeReceiver.this.getPackageName(paramIntent), listAppsFragment.days, false);
              if (listAppsFragment.database == null) {
                listAppsFragment.database = new DatabaseHelper(listAppsFragment.getInstance());
              }
              listAppsFragment.database.savePackage((PkgListItem)localObject3);
              if ((!PackageChangeReceiver.this.getPackageName(paramIntent).equals(listAppsFragment.getInstance().getPackageName())) && (listAppsFragment.desktop_launch) && (listAppsFragment.plia != null) && (listAppsFragment.frag != null) && (listAppsFragment.frag.getActivity() != null)) {
                listAppsFragment.frag.getActivity().runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    if (listAppsFragment.plia.checkItem(localObject3.pkgName)) {
                      listAppsFragment.plia.updateItem(localObject3.pkgName);
                    }
                    for (;;)
                    {
                      listAppsFragment.plia.notifyDataSetChanged();
                      listAppsFragment.plia.sort();
                      return;
                      listAppsFragment.plia.add(localObject3);
                    }
                  }
                });
              }
              label1627:
              listAppsFragment.refresh = true;
              label1631:
              if (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"))
              {
                localObject3 = new Intent(paramContext, AppDisablerWidget.class);
                ((Intent)localObject3).setAction(AppDisablerWidget.ACTION_WIDGET_RECEIVER_Updater);
                paramContext.sendBroadcast((Intent)localObject3);
                listAppsFragment.init();
              }
            }
            catch (Exception localRuntimeException3)
            {
              try
              {
                localObject5 = PackageChangeReceiver.this.getPackageName(paramIntent);
                listAppsFragment.getConfig().edit().putBoolean((String)localObject5, false).commit();
                if (listAppsFragment.getConfig().getBoolean("switch_auto_backup_apk", false))
                {
                  System.out.println("Backup app on update");
                  if (!listAppsFragment.getConfig().getBoolean("switch_auto_backup_apk_only_gp", false)) {
                    PackageChangeReceiver.this.backup((String)localObject5);
                  }
                }
                if (listAppsFragment.getConfig().getBoolean("switch_auto_backup_apk_only_gp", false)) {
                  System.out.println("Backup app on update");
                }
              }
              catch (RuntimeException localRuntimeException3)
              {
                try
                {
                  if (listAppsFragment.getInstance().getPackageManager().getInstallerPackageName((String)localObject5).equals("com.android.vending")) {
                    PackageChangeReceiver.this.backup((String)localObject5);
                  }
                  if (listAppsFragment.handlerToast == null) {
                    listAppsFragment.handlerToast = PackageChangeReceiver.this.handler;
                  }
                  listAppsFragment.days = listAppsFragment.getConfig().getInt("days_on_up", 1);
                  final PkgListItem localPkgListItem = new PkgListItem(listAppsFragment.getInstance(), PackageChangeReceiver.this.getPackageName(paramIntent), listAppsFragment.days, false);
                  localObject3 = "";
                  try
                  {
                    localObject4 = listAppsFragment.getInstance().getPackageManager().getPackageInfo(localPkgListItem.pkgName, 0).applicationInfo.sourceDir;
                    localObject3 = localObject4;
                  }
                  catch (PackageManager.NameNotFoundException localNameNotFoundException)
                  {
                    for (;;)
                    {
                      label2422:
                      label2516:
                      label2663:
                      label4151:
                      label4161:
                      label4170:
                      label4238:
                      label4432:
                      localNameNotFoundException.printStackTrace();
                    }
                  }
                  if ((localPkgListItem.system) && (((String)localObject3).startsWith("/data")) && (listAppsFragment.getConfig().getBoolean("switch_auto_integrate_update", false)) && (listAppsFragment.su))
                  {
                    System.out.println("Integrate update to system on update app");
                    localObject4 = new ArrayList();
                    ((ArrayList)localObject4).add(localPkgListItem);
                    listAppsFragment.integrate_to_system((ArrayList)localObject4, false, true);
                  }
                  if ((!localPkgListItem.system) && (((String)localObject3).startsWith("/data/")) && (listAppsFragment.getConfig().getBoolean("switch_auto_move_to_sd", false)) && (listAppsFragment.su)) {
                    new Utils("").cmdRoot(new String[] { "pm install -r -s -i com.android.vending " + (String)localObject3 });
                  }
                  if ((!localPkgListItem.system) && (((String)localObject3).startsWith("/mnt/")) && (listAppsFragment.getConfig().getBoolean("switch_auto_move_to_internal", false)) && (listAppsFragment.su)) {
                    new Utils("").cmdRoot(new String[] { "pm install -r -f -i com.android.vending " + (String)localObject3 });
                  }
                  if (listAppsFragment.su)
                  {
                    if (new File("/data/app/" + (String)localObject5 + "-1.odex").exists()) {
                      Utils.run_all("rm /data/app/" + (String)localObject5 + "-1.odex");
                    }
                    if (new File("/data/app/" + (String)localObject5 + "-2.odex").exists()) {
                      Utils.run_all("rm /data/app/" + (String)localObject5 + "-2.odex");
                    }
                    if (new File("/data/app/" + (String)localObject5 + ".odex").exists()) {
                      Utils.run_all("rm /data/app/" + (String)localObject5 + ".odex");
                    }
                  }
                  if (((String)localObject5).contains("com.android.vending"))
                  {
                    if (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(paramContext, LicensingService.class)) == 2)
                    {
                      Utils.market_licensing_services(true);
                      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class), 2, 1);
                      if ((listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(paramContext, MarketBillingService.class)) != 2) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(paramContext, InAppBillingService.class)) != 2)) {
                        break label4540;
                      }
                      Utils.market_billing_services(true);
                      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), MarketBillingService.class), 2, 1);
                      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingService.class), 2, 1);
                    }
                  }
                  else
                  {
                    if ((listAppsFragment.getConfig().getBoolean("manual_path", false)) && (!localPkgListItem.pkgName.equals(listAppsFragment.getInstance().getPackageName())))
                    {
                      listAppsFragment.days = listAppsFragment.getConfig().getInt("days_on_up", 1);
                      if (listAppsFragment.database == null) {
                        listAppsFragment.database = new DatabaseHelper(listAppsFragment.getInstance());
                      }
                      listAppsFragment.database.savePackage(localPkgListItem);
                      if ((!PackageChangeReceiver.this.getPackageName(paramIntent).equals(listAppsFragment.getInstance().getPackageName())) && (listAppsFragment.desktop_launch) && (listAppsFragment.plia != null) && (listAppsFragment.frag != null) && (listAppsFragment.frag.getActivity() != null)) {
                        listAppsFragment.frag.getActivity().runOnUiThread(new Runnable()
                        {
                          public void run()
                          {
                            if (listAppsFragment.plia.checkItem(localPkgListItem.pkgName)) {
                              listAppsFragment.plia.updateItem(localPkgListItem.pkgName);
                            }
                            for (;;)
                            {
                              listAppsFragment.plia.notifyDataSetChanged();
                              listAppsFragment.plia.sort();
                              return;
                              listAppsFragment.plia.add(localPkgListItem);
                            }
                          }
                        });
                      }
                    }
                    listAppsFragment.refresh = true;
                    if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
                    {
                      localObject3 = new Intent(paramContext, AppDisablerWidget.class);
                      ((Intent)localObject3).setAction(AppDisablerWidget.ACTION_WIDGET_RECEIVER_Updater);
                      paramContext.sendBroadcast((Intent)localObject3);
                      System.out.println("delete trigger " + paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false));
                      if (!paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                        listAppsFragment.init();
                      }
                    }
                  }
                  for (;;)
                  {
                    try
                    {
                      localObject3 = PackageChangeReceiver.this.getPackageName(paramIntent);
                      listAppsFragment.getConfig().edit().remove((String)localObject3).commit();
                      if (listAppsFragment.su)
                      {
                        if (listAppsFragment.api >= 21)
                        {
                          if (new File("/data/app/" + (String)localObject3 + "-1/arm").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-1");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-2/arm").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-2");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-3/arm").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-3");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-4/arm").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-4");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-1/x86").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-1");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-2/x86").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-2");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-3/x86").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-3");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-4/x86").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-4");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-1/x86_64").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-1");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-2/x86_64").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-2");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-3/x86_64").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-3");
                          }
                          if (new File("/data/app/" + (String)localObject3 + "-4/x86_64").exists()) {
                            Utils.run_all("rm -rf /data/app/" + (String)localObject3 + "-4");
                          }
                        }
                        if (new File("/data/app/" + (String)localObject3 + "-1.odex").exists()) {
                          Utils.run_all("rm /data/app/" + (String)localObject3 + "-1.odex");
                        }
                        if (new File("/data/app/" + (String)localObject3 + "-2.odex").exists()) {
                          Utils.run_all("rm /data/app/" + (String)localObject3 + "-2.odex");
                        }
                        if (new File("/data/app/" + (String)localObject3 + ".odex").exists()) {
                          Utils.run_all("rm /data/app/" + (String)localObject3 + ".odex");
                        }
                      }
                      if (((String)localObject3).contains("com.android.vending"))
                      {
                        if (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(paramContext, LicensingService.class)) != 2) {
                          continue;
                        }
                        Utils.market_licensing_services(true);
                        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class), 2, 1);
                        if ((listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(paramContext, MarketBillingService.class)) != 2) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(paramContext, InAppBillingService.class)) != 2)) {
                          continue;
                        }
                        Utils.market_billing_services(true);
                        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), MarketBillingService.class), 2, 1);
                        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingService.class), 2, 1);
                      }
                    }
                    catch (RuntimeException localRuntimeException4)
                    {
                      label4540:
                      localRuntimeException4.printStackTrace();
                      continue;
                      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), MarketBillingService.class), 1, 1);
                      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingService.class), 1, 1);
                      continue;
                    }
                    listAppsFragment.refresh = true;
                    localObject3 = PackageChangeReceiver.this.getPackageName(paramIntent);
                    if (listAppsFragment.database == null) {
                      listAppsFragment.database = new DatabaseHelper(listAppsFragment.getInstance());
                    }
                    listAppsFragment.database.deletePackage((String)localObject3);
                    if ((!PackageChangeReceiver.this.getPackageName(paramIntent).equals(listAppsFragment.getInstance().getPackageName())) && (listAppsFragment.desktop_launch) && (listAppsFragment.plia != null) && (listAppsFragment.frag != null) && (listAppsFragment.frag.getActivity() != null)) {
                      listAppsFragment.frag.getActivity().runOnUiThread(new Runnable()
                      {
                        public void run()
                        {
                          if (listAppsFragment.plia.checkItem(localObject3)) {
                            listAppsFragment.plia.remove(localObject3);
                          }
                          listAppsFragment.plia.notifyDataSetChanged();
                          listAppsFragment.plia.sort();
                        }
                      });
                    }
                    if ((!listAppsFragment.patchOnBoot) && (!listAppsFragment.desktop_launch)) {
                      System.out.println("LP - exit.");
                    }
                    return;
                    n = 1;
                    m = i2;
                    break;
                    i3 = 1;
                    i4 = j;
                    break label811;
                    if (i2 != 0) {
                      PackageChangeReceiver.this.connectToBilling();
                    }
                    if (j != 0) {
                      PackageChangeReceiver.this.connectToLicensing();
                    }
                    if (i1 != 0) {
                      new Thread(new Runnable()
                      {
                        public void run()
                        {
                          if (listAppsFragment.su) {
                            Utils.market_billing_services(true);
                          }
                        }
                      }).start();
                    }
                    if (k != 0) {
                      new Thread(new Runnable()
                      {
                        public void run()
                        {
                          if (listAppsFragment.su) {
                            Utils.market_licensing_services(true);
                          }
                        }
                      }).start();
                    }
                    listAppsFragment.days = listAppsFragment.getConfig().getInt("days_on_up", 1);
                    try
                    {
                      localObject3 = new PkgListItem(listAppsFragment.getInstance(), PackageChangeReceiver.this.getPackageName(paramIntent), listAppsFragment.days, false);
                      if (listAppsFragment.database == null) {
                        listAppsFragment.database = new DatabaseHelper(listAppsFragment.getInstance());
                      }
                      listAppsFragment.database.savePackage((PkgListItem)localObject3);
                      if ((PackageChangeReceiver.this.getPackageName(paramIntent).equals(listAppsFragment.getInstance().getPackageName())) || (!listAppsFragment.desktop_launch) || (listAppsFragment.plia == null) || (listAppsFragment.frag == null) || (listAppsFragment.frag.getActivity() == null)) {
                        break label856;
                      }
                      listAppsFragment.frag.getActivity().runOnUiThread(new Runnable()
                      {
                        public void run()
                        {
                          if (listAppsFragment.plia.checkItem(localObject3.pkgName))
                          {
                            listAppsFragment.plia.updateItem(localObject3.pkgName);
                            listAppsFragment.plia.sort();
                          }
                          for (;;)
                          {
                            listAppsFragment.plia.notifyDataSetChanged();
                            listAppsFragment.plia.sort();
                            return;
                            listAppsFragment.plia.add(localObject3);
                          }
                        }
                      });
                    }
                    catch (Exception localException2)
                    {
                      localException2.printStackTrace();
                      System.out.println("Item dont create. And dont add to database.");
                    }
                    break label856;
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class), 1, 1);
                    break label1380;
                    localRuntimeException2 = localRuntimeException2;
                    localRuntimeException2.printStackTrace();
                    break label1631;
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), MarketBillingService.class), 1, 1);
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingService.class), 1, 1);
                    break label1474;
                    localException3 = localException3;
                    localException3.printStackTrace();
                    System.out.println("Item dont create. And dont add to database.");
                    break label1627;
                    localRuntimeException3 = localRuntimeException3;
                    localRuntimeException3.printStackTrace();
                    break label2663;
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class), 1, 1);
                    break label2422;
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), MarketBillingService.class), 1, 1);
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingService.class), 1, 1);
                    break label2516;
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class), 1, 1);
                  }
                }
                catch (Exception localException4)
                {
                  for (;;) {}
                }
              }
            }
          }
        }
      }
    }).start();
  }
  
  public boolean testSD()
  {
    boolean bool = false;
    try
    {
      if (listAppsFragment.basepath.startsWith(listAppsFragment.getInstance().getDir("sdcard", 0).getAbsolutePath()))
      {
        System.out.println("LuckyPatcher (sdcard to internal memory): " + listAppsFragment.basepath);
        return false;
      }
      if (!new File(listAppsFragment.basepath).exists()) {
        new File(listAppsFragment.basepath).mkdirs();
      }
      if (!new File(listAppsFragment.basepath).exists())
      {
        System.out.println("LuckyPatcher (sdcard directory not found and not created): " + listAppsFragment.basepath);
        return false;
      }
      new File(listAppsFragment.basepath + "/tmp.txt").delete();
      System.out.println("LuckyPatcher (sdcard test create file): " + listAppsFragment.basepath);
      if (new File(listAppsFragment.basepath + "/tmp.txt").createNewFile())
      {
        System.out.println("LuckyPatcher (sdcard test create file true): " + listAppsFragment.basepath);
        new File(listAppsFragment.basepath + "/tmp.txt").delete();
        bool = true;
      }
      return bool;
    }
    catch (IOException localIOException) {}
    return false;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/PackageChangeReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */