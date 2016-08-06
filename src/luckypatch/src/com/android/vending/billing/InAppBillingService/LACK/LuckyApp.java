package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LuckyApp
  extends Application
{
  static String base_path = "";
  static Context instance = null;
  static String version_name = "";
  
  public static Context getInstance()
  {
    return instance;
  }
  
  public void onCreate()
  {
    super.onCreate();
    instance = getApplicationContext();
    String str = instance.getSharedPreferences("config", 4).getString("basepath", "");
    listAppsFragment.basepath = str;
    base_path = str;
    try
    {
      version_name = instance.getPackageManager().getPackageInfo(instance.getPackageName(), 0).versionName;
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
      {
        public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
        {
          System.out.println("FATAL Exception LP " + paramAnonymousThrowable.toString());
          if ((listAppsFragment.su) && (Utils.getSELinux().equals("enforce"))) {}
          try
          {
            new Utils("").cmdRoot(new String[] { "setenforce 1" });
            if (paramAnonymousThrowable.toString().contains("No space left on device")) {
              LuckyApp.this.getSharedPreferences("config", 4).edit().putString("force_close_info", "No space left on device").commit();
            }
            if (paramAnonymousThrowable.toString().contains("OutOfMemoryError")) {
              LuckyApp.this.getSharedPreferences("config", 4).edit().putString("force_close_info", "OutOfMemoryError").commit();
            }
            try
            {
              listAppsFragment.init();
              paramAnonymousThread = LuckyApp.version_name;
              if (LuckyApp.base_path.equals("")) {
                LuckyApp.base_path = LuckyApp.instance.getDir("log", 2).getAbsolutePath();
              }
              File localFile = new File(LuckyApp.base_path + "/Log/Exception." + paramAnonymousThread + ".txt");
              StringWriter localStringWriter = new StringWriter();
              paramAnonymousThrowable.printStackTrace(new PrintWriter(localStringWriter));
              Utils.save_text_to_file(localFile, "Lucky Pacther ver. " + paramAnonymousThread + "\n\n " + localStringWriter.toString());
            }
            catch (Exception paramAnonymousThread)
            {
              for (;;)
              {
                int i;
                paramAnonymousThread.printStackTrace();
              }
            }
            paramAnonymousThrowable.printStackTrace();
            i = 0;
            if (LuckyApp.this.getSharedPreferences("config", 4).getBoolean("force_close", false)) {
              i = 1;
            }
            LuckyApp.this.getSharedPreferences("config", 4).edit().putBoolean("force_close", true).commit();
            try
            {
              new LogCollector().collect(LuckyApp.instance, true);
              if (i == 0)
              {
                paramAnonymousThread = listAppsFragment.getPkgMng().getLaunchIntentForPackage(LuckyApp.this.getPackageName());
                LuckyApp.this.startActivity(paramAnonymousThread);
              }
            }
            catch (RuntimeException paramAnonymousThread)
            {
              for (;;)
              {
                paramAnonymousThread.printStackTrace();
              }
            }
            catch (Exception paramAnonymousThread)
            {
              for (;;)
              {
                System.exit(0);
                paramAnonymousThread.printStackTrace();
              }
            }
            System.exit(0);
            return;
          }
          catch (Exception paramAnonymousThread)
          {
            for (;;) {}
          }
        }
      });
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    if ((listAppsFragment.su) && (Utils.getSELinux().equals("enforce"))) {}
    try
    {
      new Utils("").cmdRoot(new String[] { "setenforce 1" });
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/LuckyApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */