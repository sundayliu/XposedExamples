package com.android.vending.billing.InAppBillingService.LACK;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.widget.Toast;
import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class OnBootLuckyPatcher
  extends BroadcastReceiver
{
  public static String[] bootlist = { "empty" };
  public static Context contextB = null;
  public static int notifyIndex = 0;
  
  private void showNotify(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (!listAppsFragment.getConfig().getBoolean("hide_notify", false))
    {
      long l = System.currentTimeMillis();
      Context localContext = listAppsFragment.getInstance();
      Object localObject = new Intent(listAppsFragment.getInstance(), patchActivity.class);
      localObject = PendingIntent.getActivity(listAppsFragment.getInstance(), 0, (Intent)localObject, 0);
      NotificationManager localNotificationManager = (NotificationManager)listAppsFragment.getInstance().getSystemService("notification");
      paramString2 = new Notification(2130837552, paramString2, l);
      paramString2.setLatestEventInfo(localContext, paramString1, paramString3, (PendingIntent)localObject);
      localNotificationManager.notify(paramInt, paramString2);
    }
  }
  
  public void onReceive(final Context paramContext, Intent paramIntent)
  {
    System.out.println("load LP");
    contextB = paramContext;
    listAppsFragment.init();
    new Thread(new Runnable()
    {
      public void run()
      {
        int i = listAppsFragment.getConfig().getInt("Install_location", 3);
        if (i != 3)
        {
          if (listAppsFragment.su)
          {
            new Utils("").cmdRoot(new String[] { "pm setInstallLocation " + i, "skipOut" });
            new Utils("").cmdRoot(new String[] { "pm set-install-location " + i, "skipOut" });
          }
        }
        else {
          return;
        }
        Utils.cmd(new String[] { "pm setInstallLocation " + i, "skipOut" });
        Utils.cmd(new String[] { "pm set-install-location " + i, "skipOut" });
      }
    }).start();
    if (listAppsFragment.su)
    {
      if ((paramIntent.getAction().equals("android.intent.action.UMS_DISCONNECTED")) || (paramIntent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")))
      {
        System.out.println("load LP");
        new Thread(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: new 32	java/io/File
            //   3: dup
            //   4: new 34	java/lang/StringBuilder
            //   7: dup
            //   8: invokespecial 35	java/lang/StringBuilder:<init>	()V
            //   11: aload_0
            //   12: getfield 21	com/android/vending/billing/InAppBillingService/LACK/OnBootLuckyPatcher$2:val$context	Landroid/content/Context;
            //   15: ldc 37
            //   17: iconst_0
            //   18: invokevirtual 43	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
            //   21: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   24: ldc 49
            //   26: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   29: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   32: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
            //   35: astore_1
            //   36: aload_1
            //   37: invokevirtual 63	java/io/File:exists	()Z
            //   40: ifeq +148 -> 188
            //   43: aload_1
            //   44: invokevirtual 67	java/io/File:length	()J
            //   47: lconst_0
            //   48: lcmp
            //   49: ifle +139 -> 188
            //   52: getstatic 73	java/lang/System:out	Ljava/io/PrintStream;
            //   55: ldc 75
            //   57: invokevirtual 80	java/io/PrintStream:println	(Ljava/lang/String;)V
            //   60: aload_1
            //   61: invokevirtual 63	java/io/File:exists	()Z
            //   64: ifne +8 -> 72
            //   67: aload_1
            //   68: invokevirtual 83	java/io/File:createNewFile	()Z
            //   71: pop
            //   72: new 85	java/io/FileInputStream
            //   75: dup
            //   76: aload_1
            //   77: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
            //   80: astore_1
            //   81: new 90	java/io/BufferedReader
            //   84: dup
            //   85: new 92	java/io/InputStreamReader
            //   88: dup
            //   89: aload_1
            //   90: ldc 94
            //   92: invokespecial 97	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
            //   95: invokespecial 100	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
            //   98: astore_2
            //   99: aload_2
            //   100: invokevirtual 103	java/io/BufferedReader:readLine	()Ljava/lang/String;
            //   103: astore_3
            //   104: aload_3
            //   105: ifnull +84 -> 189
            //   108: aload_3
            //   109: ldc 105
            //   111: invokevirtual 111	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
            //   114: astore_3
            //   115: aload_3
            //   116: arraylength
            //   117: iconst_2
            //   118: if_icmpne -19 -> 99
            //   121: ldc 113
            //   123: new 34	java/lang/StringBuilder
            //   126: dup
            //   127: invokespecial 35	java/lang/StringBuilder:<init>	()V
            //   130: ldc 115
            //   132: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   135: aload_3
            //   136: iconst_0
            //   137: aaload
            //   138: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   141: ldc 117
            //   143: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   146: aload_3
            //   147: iconst_1
            //   148: aaload
            //   149: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   152: ldc 119
            //   154: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   157: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   160: aload_3
            //   161: iconst_0
            //   162: aaload
            //   163: aload_3
            //   164: iconst_1
            //   165: aaload
            //   166: invokestatic 125	com/chelpus/Utils:verify_bind_and_run	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
            //   169: goto -70 -> 99
            //   172: astore_1
            //   173: getstatic 73	java/lang/System:out	Ljava/io/PrintStream;
            //   176: ldc 127
            //   178: invokevirtual 80	java/io/PrintStream:println	(Ljava/lang/String;)V
            //   181: iconst_0
            //   182: putstatic 133	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:patchOnBoot	Z
            //   185: invokestatic 136	com/chelpus/Utils:exit	()V
            //   188: return
            //   189: new 138	android/content/Intent
            //   192: dup
            //   193: aload_0
            //   194: getfield 21	com/android/vending/billing/InAppBillingService/LACK/OnBootLuckyPatcher$2:val$context	Landroid/content/Context;
            //   197: ldc -116
            //   199: invokespecial 143	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
            //   202: astore_2
            //   203: aload_2
            //   204: getstatic 147	com/android/vending/billing/InAppBillingService/LACK/widgets/BinderWidget:ACTION_WIDGET_RECEIVER_Updater	Ljava/lang/String;
            //   207: invokevirtual 151	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
            //   210: pop
            //   211: aload_0
            //   212: getfield 21	com/android/vending/billing/InAppBillingService/LACK/OnBootLuckyPatcher$2:val$context	Landroid/content/Context;
            //   215: aload_2
            //   216: invokevirtual 155	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
            //   219: aload_1
            //   220: invokevirtual 158	java/io/FileInputStream:close	()V
            //   223: goto -42 -> 181
            //   226: astore_1
            //   227: getstatic 73	java/lang/System:out	Ljava/io/PrintStream;
            //   230: new 34	java/lang/StringBuilder
            //   233: dup
            //   234: invokespecial 35	java/lang/StringBuilder:<init>	()V
            //   237: ldc -96
            //   239: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   242: aload_1
            //   243: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   246: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   249: invokevirtual 80	java/io/PrintStream:println	(Ljava/lang/String;)V
            //   252: goto -71 -> 181
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	255	0	this	2
            //   35	55	1	localObject1	Object
            //   172	48	1	localFileNotFoundException	java.io.FileNotFoundException
            //   226	17	1	localIOException	java.io.IOException
            //   98	118	2	localObject2	Object
            //   103	61	3	localObject3	Object
            // Exception table:
            //   from	to	target	type
            //   60	72	172	java/io/FileNotFoundException
            //   72	99	172	java/io/FileNotFoundException
            //   99	104	172	java/io/FileNotFoundException
            //   108	169	172	java/io/FileNotFoundException
            //   189	223	172	java/io/FileNotFoundException
            //   60	72	226	java/io/IOException
            //   72	99	226	java/io/IOException
            //   99	104	226	java/io/IOException
            //   108	169	226	java/io/IOException
            //   189	223	226	java/io/IOException
          }
        }).start();
        listAppsFragment.patchOnBoot = true;
      }
      if (paramIntent.getAction().equals("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE"))
      {
        System.out.println("LuckyPatcher: ACTION_EXTERNAL_APPLICATIONS_AVAILABLE");
        if (listAppsFragment.getConfig().getBoolean("OnBootService", false))
        {
          listAppsFragment.getConfig().edit().putBoolean("OnBootService", false).commit();
          listAppsFragment.patchOnBoot = true;
          localObject = new Intent(listAppsFragment.getInstance(), PatchService.class);
          listAppsFragment.getInstance().startService((Intent)localObject);
        }
      }
      final Object localObject = new Handler();
      if (paramIntent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
      {
        listAppsFragment.getConfig().edit().putBoolean("OnBootService", true).commit();
        paramIntent = (AlarmManager)paramContext.getSystemService("alarm");
        Intent localIntent = new Intent(paramContext, OnAlarmReceiver.class);
        localIntent.setAction(OnAlarmReceiver.ACTION_WIDGET_RECEIVER);
        paramIntent.set(2, 300000L, PendingIntent.getBroadcast(paramContext, 0, localIntent, 0));
        new Thread(new Runnable()
        {
          public void run()
          {
            if (Utils.exists(listAppsFragment.toolfilesdir + "/ClearDalvik.on")) {
              Utils.remount("/system", "rw");
            }
            try
            {
              Object localObject1 = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".clearDalvikCache " + OnBootLuckyPatcher.contextB.getApplicationContext().getFilesDir().getAbsolutePath() });
              System.out.println((String)localObject1);
              localObject.post(new Runnable()
              {
                public void run()
                {
                  Toast.makeText(OnBootLuckyPatcher.contextB.getApplicationContext(), "LuckyPatcher: clear dalvik-cache failed. Please clear dalvik-cache manual.", 1).show();
                }
              });
              System.out.println(OnBootLuckyPatcher.contextB.getApplicationContext().getFilesDir() + "/reboot");
              Utils.reboot();
              if (!Utils.getCurrentRuntimeValue().equals("ART"))
              {
                if (listAppsFragment.getConfig().getBoolean("trigger_for_good_android_patch_on_boot", false)) {
                  Utils.turn_off_patch_on_boot_all();
                }
                listAppsFragment.getConfig().edit().putBoolean("trigger_for_good_android_patch_on_boot", true).commit();
                String str1 = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
                Object localObject2 = "";
                if (!str1.equals(""))
                {
                  localObject1 = localObject2;
                  if (str1.contains("patch1"))
                  {
                    localObject1 = localObject2;
                    if (!Utils.checkCoreJarPatch11())
                    {
                      localObject1 = localObject2;
                      if (!Utils.checkCoreJarPatch12()) {
                        localObject1 = "" + "_patch1_";
                      }
                    }
                  }
                  localObject2 = localObject1;
                  if (str1.contains("patch2"))
                  {
                    localObject2 = localObject1;
                    if (!Utils.checkCoreJarPatch20()) {
                      localObject2 = (String)localObject1 + "_patch2_";
                    }
                  }
                  String str2;
                  if (!((String)localObject2).equals(""))
                  {
                    listAppsFragment.patchOnlyDalvikCore = true;
                    listAppsFragment.install_market_to_system = false;
                    System.out.println("patch only dalvik cache mode on boot");
                    localObject1 = Utils.getFileDalvikCache("/system/framework/core.jar").getAbsolutePath();
                    if (localObject1 == null) {
                      System.out.println("dalvik cache for core.jar not found");
                    }
                    str2 = Utils.getFileDalvikCache("/system/framework/services.jar").getAbsolutePath();
                    if (str2 == null) {
                      System.out.println("dalvik cache for services.jar not found");
                    }
                    if ((localObject1 == null) || (str2 == null) || (((String)localObject1).equals("")) || (str2.equals(""))) {
                      break label914;
                    }
                    listAppsFragment.str = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".corepatch " + (String)localObject2 + " " + (String)localObject1 + " " + str2 + " " + listAppsFragment.getInstance().getFilesDir() + " OnlyDalvik" });
                    System.out.println(listAppsFragment.str);
                    new Utils("w").waitLP(4000L);
                    if (listAppsFragment.str.contains("SU Java-Code Running!"))
                    {
                      if ((str1.contains("patch1")) && (!Utils.checkCoreJarPatch11()) && (!Utils.checkCoreJarPatch12())) {
                        Utils.turn_off_patch_on_boot("patch1");
                      }
                      if ((str1.contains("patch2")) && (!Utils.checkCoreJarPatch20())) {
                        Utils.turn_off_patch_on_boot("patch2");
                      }
                      if ((Utils.checkCoreJarPatch11()) || (Utils.checkCoreJarPatch12()) || (Utils.checkCoreJarPatch20())) {
                        OnBootLuckyPatcher.this.showNotify(254, "Lucky Patcher - " + Utils.getText(2131165578), Utils.getText(2131165578), Utils.getText(2131165785));
                      }
                    }
                  }
                  localObject2 = "";
                  localObject1 = localObject2;
                  if (str1.contains("patch3"))
                  {
                    localObject1 = localObject2;
                    if (!Utils.checkCoreJarPatch30(listAppsFragment.getPkgMng())) {
                      localObject1 = "_patch3_";
                    }
                  }
                  if (!((String)localObject1).equals(""))
                  {
                    listAppsFragment.patchOnlyDalvikCore = true;
                    listAppsFragment.install_market_to_system = false;
                    System.out.println("patch only dalvik cache mode on boot");
                    localObject2 = Utils.getFileDalvikCache("/system/framework/core.jar").getAbsolutePath();
                    if (localObject2 == null) {
                      System.out.println("dalvik cache for core.jar not found");
                    }
                    str2 = Utils.getFileDalvikCache("/system/framework/services.jar").getAbsolutePath();
                    if (str2 == null) {
                      System.out.println("dalvik cache for services.jar not found");
                    }
                    if ((localObject2 == null) || (str2 == null) || (((String)localObject2).equals("")) || (str2.equals(""))) {
                      break label971;
                    }
                    listAppsFragment.str = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".corepatch " + (String)localObject1 + " " + (String)localObject2 + " " + str2 + " " + listAppsFragment.getInstance().getFilesDir() + " OnlyDalvik" });
                    System.out.println(listAppsFragment.str);
                    if (listAppsFragment.str.contains("SU Java-Code Running!"))
                    {
                      new Utils("w").waitLP(4000L);
                      if ((!str1.contains("patch3")) || (Utils.checkCoreJarPatch30(listAppsFragment.getPkgMng()))) {
                        break label926;
                      }
                      Utils.turn_off_patch_on_boot("patch3");
                    }
                  }
                }
              }
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
                continue;
                label914:
                System.out.println("dalvik cache patch on boot skip");
              }
              label926:
              OnBootLuckyPatcher.this.showNotify(255, "Lucky Patcher - " + Utils.getText(2131165578), Utils.getText(2131165578), Utils.getText(2131165786));
              return;
            }
            label971:
            System.out.println("dalvik cache patch on boot skip");
          }
        }).start();
      }
    }
    if (!listAppsFragment.getConfig().getBoolean("OnBootService", false)) {
      Utils.exit();
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/OnBootLuckyPatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */