package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;
import com.android.vending.billing.InAppBillingService.LACK.widgets.AppDisablerWidget;
import com.android.vending.billing.InAppBillingService.LACK.widgets.BinderWidget;
import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class PatchService
  extends Service
{
  public static int notifyIndex = 50;
  public Context context = null;
  final Handler handler = new Handler();
  private Thread t;
  
  private void showNotify(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (!listAppsFragment.getConfig().getBoolean("hide_notify", false))
    {
      long l = System.currentTimeMillis();
      Context localContext = getApplicationContext();
      PendingIntent localPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, patchActivity.class), 0);
      NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
      paramString2 = new Notification(2130837552, paramString2, l);
      paramString2.setLatestEventInfo(localContext, paramString1, paramString3, localPendingIntent);
      localNotificationManager.notify(paramInt, paramString2);
    }
  }
  
  public void dexoptcopy()
  {
    File localFile = new File(listAppsFragment.toolfilesdir + "/" + "dexopt-wrapper");
    if ((!localFile.exists()) || (localFile.length() != Utils.getRawLength(2131099655))) {}
    try
    {
      Utils.getRawToFile(2131099655, new File(listAppsFragment.toolfilesdir + "/dexopt-wrapper"));
      try
      {
        Utils.chmod(new File(getApplicationContext().getFilesDir() + "/" + "dexopt-wrapper"), 777);
        Utils.run_all("chmod 777 " + new File(new StringBuilder().append(getApplicationContext().getFilesDir()).append("/").append("dexopt-wrapper").toString()));
        Utils.run_all("chown 0.0 " + new File(new StringBuilder().append(getApplicationContext().getFilesDir()).append("/").append("dexopt-wrapper").toString()));
        Utils.run_all("chmod 0:0 " + new File(new StringBuilder().append(getApplicationContext().getFilesDir()).append("/").append("dexopt-wrapper").toString()));
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          System.out.println(localException1);
          localException1.printStackTrace();
        }
      }
      Utils.run_all("chmod 777 " + new File(new StringBuilder().append(getApplicationContext().getFilesDir()).append("/").append("dexopt-wrapper").toString()));
      Utils.run_all("chown 0.0 " + new File(new StringBuilder().append(getApplicationContext().getFilesDir()).append("/").append("dexopt-wrapper").toString()));
      Utils.run_all("chmod 0:0 " + new File(new StringBuilder().append(getApplicationContext().getFilesDir()).append("/").append("dexopt-wrapper").toString()));
      return;
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    System.out.println("LuckyPatcher: Create service");
    listAppsFragment.patchOnBoot = true;
    listAppsFragment.init();
    this.context = this;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    System.out.println("Killing Service!!!!!!!!!!!!!!!!!!!!!!!");
    Utils.exit();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    listAppsFragment.patchOnBoot = true;
    this.t = new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: new 38	java/io/File
        //   3: dup
        //   4: new 40	java/lang/StringBuilder
        //   7: dup
        //   8: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   11: aload_0
        //   12: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   15: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   18: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   21: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   24: ldc 57
        //   26: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   29: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   32: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
        //   35: astore 5
        //   37: aload 5
        //   39: invokevirtual 71	java/io/File:exists	()Z
        //   42: ifeq +9 -> 51
        //   45: aload 5
        //   47: invokevirtual 74	java/io/File:delete	()Z
        //   50: pop
        //   51: new 38	java/io/File
        //   54: dup
        //   55: new 40	java/lang/StringBuilder
        //   58: dup
        //   59: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   62: aload_0
        //   63: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   66: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   69: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   72: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   75: ldc 76
        //   77: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   80: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   83: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
        //   86: astore 5
        //   88: aload 5
        //   90: invokevirtual 71	java/io/File:exists	()Z
        //   93: ifeq +9 -> 102
        //   96: aload 5
        //   98: invokevirtual 74	java/io/File:delete	()Z
        //   101: pop
        //   102: new 38	java/io/File
        //   105: dup
        //   106: new 40	java/lang/StringBuilder
        //   109: dup
        //   110: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   113: aload_0
        //   114: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   117: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   120: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   123: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   126: ldc 78
        //   128: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   131: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   134: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
        //   137: astore 6
        //   139: aload 6
        //   141: invokevirtual 71	java/io/File:exists	()Z
        //   144: ifeq +9 -> 153
        //   147: aload 6
        //   149: invokevirtual 74	java/io/File:delete	()Z
        //   152: pop
        //   153: new 40	java/lang/StringBuilder
        //   156: dup
        //   157: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   160: getstatic 84	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
        //   163: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   166: ldc 86
        //   168: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   171: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   174: invokestatic 91	com/chelpus/Utils:exists	(Ljava/lang/String;)Z
        //   177: ifeq +133 -> 310
        //   180: ldc 93
        //   182: ldc 95
        //   184: invokestatic 99	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
        //   187: pop
        //   188: new 88	com/chelpus/Utils
        //   191: dup
        //   192: ldc 101
        //   194: invokespecial 102	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
        //   197: iconst_1
        //   198: anewarray 104	java/lang/String
        //   201: dup
        //   202: iconst_0
        //   203: new 40	java/lang/StringBuilder
        //   206: dup
        //   207: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   210: getstatic 107	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:dalvikruncommand	Ljava/lang/String;
        //   213: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   216: ldc 109
        //   218: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   221: aload_0
        //   222: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   225: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   228: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   231: invokevirtual 112	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   234: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   237: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   240: aastore
        //   241: invokevirtual 116	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
        //   244: astore 5
        //   246: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   249: aload 5
        //   251: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   254: aload_0
        //   255: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   258: getfield 131	com/android/vending/billing/InAppBillingService/LACK/PatchService:handler	Landroid/os/Handler;
        //   261: new 13	com/android/vending/billing/InAppBillingService/LACK/PatchService$1$1
        //   264: dup
        //   265: aload_0
        //   266: invokespecial 134	com/android/vending/billing/InAppBillingService/LACK/PatchService$1$1:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/PatchService$1;)V
        //   269: invokevirtual 140	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   272: pop
        //   273: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   276: new 40	java/lang/StringBuilder
        //   279: dup
        //   280: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   283: aload_0
        //   284: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   287: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   290: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   293: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   296: ldc -114
        //   298: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   301: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   304: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   307: invokestatic 145	com/chelpus/Utils:reboot	()V
        //   310: aload_0
        //   311: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   314: invokevirtual 149	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
        //   317: getfield 154	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
        //   320: astore 10
        //   322: aload_0
        //   323: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   326: invokevirtual 158	com/android/vending/billing/InAppBillingService/LACK/PatchService:getPackageManager	()Landroid/content/pm/PackageManager;
        //   329: astore 11
        //   331: ldc -96
        //   333: astore 5
        //   335: aload_0
        //   336: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   339: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   342: ldc -94
        //   344: iconst_0
        //   345: invokevirtual 166	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
        //   348: invokevirtual 170	java/io/File:listFiles	()[Ljava/io/File;
        //   351: astore 12
        //   353: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   356: new 40	java/lang/StringBuilder
        //   359: dup
        //   360: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   363: ldc -84
        //   365: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   368: aload 12
        //   370: arraylength
        //   371: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   374: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   377: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   380: aload 12
        //   382: arraylength
        //   383: ifle +10 -> 393
        //   386: aload_0
        //   387: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   390: invokevirtual 178	com/android/vending/billing/InAppBillingService/LACK/PatchService:dexoptcopy	()V
        //   393: iconst_0
        //   394: istore_3
        //   395: iload_3
        //   396: aload 12
        //   398: arraylength
        //   399: if_icmpge +2613 -> 3012
        //   402: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   405: invokestatic 183	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
        //   408: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   411: aload 6
        //   413: astore 7
        //   415: aload 12
        //   417: iload_3
        //   418: aaload
        //   419: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   422: ldc -94
        //   424: invokevirtual 189	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   427: ifne +2569 -> 2996
        //   430: aload 6
        //   432: astore 7
        //   434: aload 12
        //   436: iload_3
        //   437: aaload
        //   438: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   441: ldc -65
        //   443: invokevirtual 189	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   446: ifne +2550 -> 2996
        //   449: aload 6
        //   451: astore 7
        //   453: aload 12
        //   455: iload_3
        //   456: aaload
        //   457: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   460: ldc -63
        //   462: invokevirtual 189	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   465: ifne +2531 -> 2996
        //   468: aload 6
        //   470: astore 7
        //   472: aload 12
        //   474: iload_3
        //   475: aaload
        //   476: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   479: ldc -61
        //   481: invokevirtual 189	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   484: ifne +2512 -> 2996
        //   487: aload 6
        //   489: astore 7
        //   491: aload 12
        //   493: iload_3
        //   494: aaload
        //   495: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   498: ldc -59
        //   500: invokevirtual 189	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   503: ifne +2493 -> 2996
        //   506: aload 6
        //   508: astore 7
        //   510: aload 12
        //   512: iload_3
        //   513: aaload
        //   514: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   517: invokevirtual 200	java/lang/String:toLowerCase	()Ljava/lang/String;
        //   520: ldc -54
        //   522: invokevirtual 189	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   525: ifne +2471 -> 2996
        //   528: aload 6
        //   530: astore 7
        //   532: aload 12
        //   534: iload_3
        //   535: aaload
        //   536: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   539: invokevirtual 200	java/lang/String:toLowerCase	()Ljava/lang/String;
        //   542: ldc -52
        //   544: invokevirtual 189	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   547: ifne +2449 -> 2996
        //   550: aload 6
        //   552: astore 7
        //   554: aload 12
        //   556: iload_3
        //   557: aaload
        //   558: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   561: invokevirtual 200	java/lang/String:toLowerCase	()Ljava/lang/String;
        //   564: ldc -50
        //   566: invokevirtual 189	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   569: ifne +2427 -> 2996
        //   572: aload 6
        //   574: astore 7
        //   576: new 38	java/io/File
        //   579: dup
        //   580: new 40	java/lang/StringBuilder
        //   583: dup
        //   584: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   587: aload_0
        //   588: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   591: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   594: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   597: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   600: ldc 57
        //   602: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   605: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   608: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
        //   611: astore 6
        //   613: aload 5
        //   615: astore 8
        //   617: aload 6
        //   619: astore 7
        //   621: aload 6
        //   623: invokevirtual 71	java/io/File:exists	()Z
        //   626: ifeq +17 -> 643
        //   629: aload 5
        //   631: astore 8
        //   633: aload 6
        //   635: astore 7
        //   637: aload 6
        //   639: invokevirtual 74	java/io/File:delete	()Z
        //   642: pop
        //   643: aload 5
        //   645: astore 8
        //   647: aload 6
        //   649: astore 7
        //   651: new 38	java/io/File
        //   654: dup
        //   655: new 40	java/lang/StringBuilder
        //   658: dup
        //   659: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   662: aload_0
        //   663: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   666: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   669: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   672: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   675: ldc 76
        //   677: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   680: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   683: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
        //   686: astore 6
        //   688: aload 6
        //   690: astore 7
        //   692: aload 6
        //   694: invokevirtual 71	java/io/File:exists	()Z
        //   697: ifeq +13 -> 710
        //   700: aload 6
        //   702: astore 7
        //   704: aload 6
        //   706: invokevirtual 74	java/io/File:delete	()Z
        //   709: pop
        //   710: aload 6
        //   712: astore 7
        //   714: new 38	java/io/File
        //   717: dup
        //   718: new 40	java/lang/StringBuilder
        //   721: dup
        //   722: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   725: aload_0
        //   726: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   729: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   732: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   735: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   738: ldc 78
        //   740: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   743: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   746: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
        //   749: astore 9
        //   751: aload 5
        //   753: astore 8
        //   755: aload 9
        //   757: astore 7
        //   759: aload 9
        //   761: invokevirtual 71	java/io/File:exists	()Z
        //   764: ifeq +17 -> 781
        //   767: aload 5
        //   769: astore 8
        //   771: aload 9
        //   773: astore 7
        //   775: aload 9
        //   777: invokevirtual 74	java/io/File:delete	()Z
        //   780: pop
        //   781: aload 5
        //   783: astore 8
        //   785: aload 9
        //   787: astore 7
        //   789: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   792: new 40	java/lang/StringBuilder
        //   795: dup
        //   796: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   799: ldc -48
        //   801: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   804: aload 12
        //   806: iload_3
        //   807: aaload
        //   808: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   811: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   814: ldc -46
        //   816: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   819: iload_3
        //   820: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   823: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   826: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   829: ldc -44
        //   831: astore 7
        //   833: aload 11
        //   835: aload 12
        //   837: iload_3
        //   838: aaload
        //   839: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   842: iconst_0
        //   843: invokevirtual 218	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   846: getfield 224	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
        //   849: getfield 154	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
        //   852: astore 6
        //   854: aload 6
        //   856: astore 7
        //   858: aload 5
        //   860: astore 6
        //   862: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   865: new 40	java/lang/StringBuilder
        //   868: dup
        //   869: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   872: ldc -30
        //   874: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   877: aload 7
        //   879: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   882: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   885: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   888: aload 7
        //   890: astore 8
        //   892: aload 5
        //   894: astore 6
        //   896: aload 7
        //   898: ldc -44
        //   900: invokevirtual 230	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   903: ifeq +39 -> 942
        //   906: aload 5
        //   908: astore 6
        //   910: new 40	java/lang/StringBuilder
        //   913: dup
        //   914: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   917: ldc -24
        //   919: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   922: aload 12
        //   924: iload_3
        //   925: aaload
        //   926: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   929: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   932: ldc -22
        //   934: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   937: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   940: astore 8
        //   942: aload 5
        //   944: astore 7
        //   946: aload 5
        //   948: astore 6
        //   950: aload 8
        //   952: ldc -20
        //   954: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   957: ifeq +7 -> 964
        //   960: ldc -14
        //   962: astore 7
        //   964: aload 7
        //   966: astore 5
        //   968: aload 7
        //   970: astore 6
        //   972: aload 8
        //   974: ldc -20
        //   976: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   979: ifne +7 -> 986
        //   982: ldc -96
        //   984: astore 5
        //   986: aload 5
        //   988: astore 6
        //   990: iconst_3
        //   991: anewarray 104	java/lang/String
        //   994: astore 7
        //   996: aload 7
        //   998: iconst_0
        //   999: ldc 101
        //   1001: aastore
        //   1002: aload 5
        //   1004: astore 6
        //   1006: aload 7
        //   1008: iconst_1
        //   1009: aload 12
        //   1011: iload_3
        //   1012: aaload
        //   1013: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   1016: aastore
        //   1017: aload 5
        //   1019: astore 6
        //   1021: aload 7
        //   1023: iconst_2
        //   1024: aload_0
        //   1025: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   1028: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   1031: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   1034: invokevirtual 243	java/io/File:toString	()Ljava/lang/String;
        //   1037: aastore
        //   1038: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   1041: new 40	java/lang/StringBuilder
        //   1044: dup
        //   1045: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1048: ldc -11
        //   1050: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1053: aload 7
        //   1055: iconst_1
        //   1056: aaload
        //   1057: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1060: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1063: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   1066: new 40	java/lang/StringBuilder
        //   1069: dup
        //   1070: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1073: ldc -24
        //   1075: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1078: aload 7
        //   1080: iconst_1
        //   1081: aaload
        //   1082: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1085: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1088: ldc 95
        //   1090: invokestatic 99	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
        //   1093: pop
        //   1094: new 40	java/lang/StringBuilder
        //   1097: dup
        //   1098: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1101: ldc -24
        //   1103: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1106: aload 7
        //   1108: iconst_1
        //   1109: aaload
        //   1110: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1113: ldc -9
        //   1115: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1118: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1121: ldc 95
        //   1123: invokestatic 99	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
        //   1126: pop
        //   1127: new 40	java/lang/StringBuilder
        //   1130: dup
        //   1131: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1134: ldc -24
        //   1136: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1139: aload 7
        //   1141: iconst_1
        //   1142: aaload
        //   1143: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1146: ldc -7
        //   1148: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1151: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1154: ldc 95
        //   1156: invokestatic 99	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
        //   1159: pop
        //   1160: invokestatic 252	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
        //   1163: aload 12
        //   1165: iload_3
        //   1166: aaload
        //   1167: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   1170: iconst_0
        //   1171: invokevirtual 218	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   1174: getfield 224	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
        //   1177: getfield 256	android/content/pm/ApplicationInfo:uid	I
        //   1180: invokestatic 260	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   1183: astore 13
        //   1185: getstatic 263	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:dalvikruncommandWithFramework	Ljava/lang/String;
        //   1188: astore 6
        //   1190: invokestatic 266	com/chelpus/Utils:isWithFramework	()Z
        //   1193: ifne +8 -> 1201
        //   1196: getstatic 107	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:dalvikruncommand	Ljava/lang/String;
        //   1199: astore 6
        //   1201: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   1204: new 40	java/lang/StringBuilder
        //   1207: dup
        //   1208: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1211: aload 6
        //   1213: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1216: ldc_w 268
        //   1219: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1222: aload 12
        //   1224: iload_3
        //   1225: aaload
        //   1226: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   1229: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1232: ldc_w 270
        //   1235: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1238: aload 12
        //   1240: iload_3
        //   1241: aaload
        //   1242: invokevirtual 243	java/io/File:toString	()Ljava/lang/String;
        //   1245: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1248: ldc_w 270
        //   1251: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1254: aload 8
        //   1256: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1259: ldc_w 270
        //   1262: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1265: invokestatic 273	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   1268: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   1271: ldc_w 270
        //   1274: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1277: aload_0
        //   1278: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   1281: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   1284: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   1287: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   1290: ldc_w 270
        //   1293: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1296: aload 10
        //   1298: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1301: ldc_w 270
        //   1304: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1307: aload 5
        //   1309: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1312: ldc_w 270
        //   1315: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1318: getstatic 278	android/os/Build:CPU_ABI	Ljava/lang/String;
        //   1321: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1324: ldc_w 270
        //   1327: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1330: ldc_w 280
        //   1333: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1336: ldc_w 270
        //   1339: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1342: invokestatic 283	com/chelpus/Utils:getCurrentRuntimeValue	()Ljava/lang/String;
        //   1345: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1348: ldc_w 270
        //   1351: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1354: aload 13
        //   1356: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1359: ldc_w 285
        //   1362: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1365: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1368: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   1371: new 88	com/chelpus/Utils
        //   1374: dup
        //   1375: ldc 101
        //   1377: invokespecial 102	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
        //   1380: iconst_1
        //   1381: anewarray 104	java/lang/String
        //   1384: dup
        //   1385: iconst_0
        //   1386: new 40	java/lang/StringBuilder
        //   1389: dup
        //   1390: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1393: aload 6
        //   1395: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1398: ldc_w 268
        //   1401: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1404: aload 12
        //   1406: iload_3
        //   1407: aaload
        //   1408: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
        //   1411: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1414: ldc_w 270
        //   1417: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1420: aload 12
        //   1422: iload_3
        //   1423: aaload
        //   1424: invokevirtual 243	java/io/File:toString	()Ljava/lang/String;
        //   1427: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1430: ldc_w 270
        //   1433: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1436: aload 8
        //   1438: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1441: ldc_w 270
        //   1444: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1447: invokestatic 273	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   1450: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   1453: ldc_w 270
        //   1456: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1459: aload_0
        //   1460: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   1463: invokevirtual 45	com/android/vending/billing/InAppBillingService/LACK/PatchService:getApplicationContext	()Landroid/content/Context;
        //   1466: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
        //   1469: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   1472: ldc_w 270
        //   1475: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1478: aload 10
        //   1480: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1483: ldc_w 270
        //   1486: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1489: aload 5
        //   1491: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1494: ldc_w 270
        //   1497: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1500: getstatic 278	android/os/Build:CPU_ABI	Ljava/lang/String;
        //   1503: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1506: ldc_w 270
        //   1509: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1512: ldc_w 280
        //   1515: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1518: ldc_w 270
        //   1521: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1524: invokestatic 283	com/chelpus/Utils:getCurrentRuntimeValue	()Ljava/lang/String;
        //   1527: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1530: ldc_w 270
        //   1533: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1536: aload 13
        //   1538: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1541: ldc_w 285
        //   1544: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1547: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1550: aastore
        //   1551: invokevirtual 116	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
        //   1554: astore 6
        //   1556: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   1559: new 40	java/lang/StringBuilder
        //   1562: dup
        //   1563: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1566: ldc_w 287
        //   1569: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1572: aload 6
        //   1574: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1577: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1580: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   1583: aload_0
        //   1584: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   1587: getstatic 290	com/android/vending/billing/InAppBillingService/LACK/PatchService:notifyIndex	I
        //   1590: new 40	java/lang/StringBuilder
        //   1593: dup
        //   1594: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1597: ldc_w 292
        //   1600: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1603: ldc_w 293
        //   1606: invokestatic 296	com/chelpus/Utils:getText	(I)Ljava/lang/String;
        //   1609: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1612: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1615: ldc_w 293
        //   1618: invokestatic 296	com/chelpus/Utils:getText	(I)Ljava/lang/String;
        //   1621: new 40	java/lang/StringBuilder
        //   1624: dup
        //   1625: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1628: aload 7
        //   1630: iconst_1
        //   1631: aaload
        //   1632: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1635: ldc_w 270
        //   1638: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1641: ldc_w 297
        //   1644: invokestatic 296	com/chelpus/Utils:getText	(I)Ljava/lang/String;
        //   1647: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1650: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1653: invokestatic 301	com/android/vending/billing/InAppBillingService/LACK/PatchService:access$000	(Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   1656: getstatic 290	com/android/vending/billing/InAppBillingService/LACK/PatchService:notifyIndex	I
        //   1659: iconst_1
        //   1660: iadd
        //   1661: putstatic 290	com/android/vending/billing/InAppBillingService/LACK/PatchService:notifyIndex	I
        //   1664: aload 6
        //   1666: ldc_w 285
        //   1669: invokevirtual 305	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   1672: arraylength
        //   1673: anewarray 104	java/lang/String
        //   1676: astore 7
        //   1678: aload 6
        //   1680: ldc_w 285
        //   1683: invokevirtual 305	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   1686: astore 8
        //   1688: new 307	java/io/BufferedReader
        //   1691: dup
        //   1692: new 309	java/io/InputStreamReader
        //   1695: dup
        //   1696: new 311	java/io/FileInputStream
        //   1699: dup
        //   1700: aload 12
        //   1702: iload_3
        //   1703: aaload
        //   1704: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   1707: ldc_w 316
        //   1710: invokespecial 319	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   1713: invokespecial 322	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   1716: astore 13
        //   1718: sipush 2000
        //   1721: anewarray 104	java/lang/String
        //   1724: astore 14
        //   1726: iconst_0
        //   1727: istore_1
        //   1728: aload 13
        //   1730: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   1733: astore 6
        //   1735: aload 6
        //   1737: ifnull +1270 -> 3007
        //   1740: aload 14
        //   1742: iconst_0
        //   1743: aload 6
        //   1745: aastore
        //   1746: iload_1
        //   1747: istore_2
        //   1748: aload 14
        //   1750: iconst_0
        //   1751: aaload
        //   1752: invokevirtual 328	java/lang/String:toUpperCase	()Ljava/lang/String;
        //   1755: ldc_w 330
        //   1758: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   1761: ifeq +23 -> 1784
        //   1764: iload_1
        //   1765: istore_2
        //   1766: aload 14
        //   1768: iconst_0
        //   1769: aaload
        //   1770: invokevirtual 328	java/lang/String:toUpperCase	()Ljava/lang/String;
        //   1773: ldc_w 332
        //   1776: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   1779: ifeq +5 -> 1784
        //   1782: iconst_0
        //   1783: istore_2
        //   1784: aload 14
        //   1786: iconst_0
        //   1787: aaload
        //   1788: invokevirtual 328	java/lang/String:toUpperCase	()Ljava/lang/String;
        //   1791: ldc_w 334
        //   1794: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   1797: ifeq +5 -> 1802
        //   1800: iconst_1
        //   1801: istore_2
        //   1802: iload_2
        //   1803: istore_1
        //   1804: iload_2
        //   1805: ifeq -77 -> 1728
        //   1808: ldc 101
        //   1810: astore 7
        //   1812: aload 14
        //   1814: iconst_0
        //   1815: aaload
        //   1816: ldc_w 336
        //   1819: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   1822: istore 4
        //   1824: aload 7
        //   1826: astore 6
        //   1828: iload 4
        //   1830: ifeq +91 -> 1921
        //   1833: new 338	org/json/JSONObject
        //   1836: dup
        //   1837: aload 14
        //   1839: iconst_0
        //   1840: aaload
        //   1841: invokespecial 339	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   1844: ldc_w 336
        //   1847: invokevirtual 343	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   1850: astore 6
        //   1852: aload 6
        //   1854: invokevirtual 346	java/lang/String:trim	()Ljava/lang/String;
        //   1857: astore 6
        //   1859: new 88	com/chelpus/Utils
        //   1862: dup
        //   1863: ldc 101
        //   1865: invokespecial 102	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
        //   1868: iconst_1
        //   1869: anewarray 104	java/lang/String
        //   1872: dup
        //   1873: iconst_0
        //   1874: new 40	java/lang/StringBuilder
        //   1877: dup
        //   1878: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1881: ldc_w 348
        //   1884: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1887: getstatic 352	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
        //   1890: getfield 357	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
        //   1893: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1896: ldc_w 359
        //   1899: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1902: aload 6
        //   1904: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1907: ldc_w 361
        //   1910: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1913: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1916: aastore
        //   1917: invokevirtual 116	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
        //   1920: pop
        //   1921: aload 14
        //   1923: iconst_0
        //   1924: aaload
        //   1925: ldc_w 363
        //   1928: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   1931: istore 4
        //   1933: iload_2
        //   1934: istore_1
        //   1935: iload 4
        //   1937: ifeq -209 -> 1728
        //   1940: new 338	org/json/JSONObject
        //   1943: dup
        //   1944: aload 14
        //   1946: iconst_0
        //   1947: aaload
        //   1948: invokespecial 339	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   1951: ldc_w 363
        //   1954: invokevirtual 343	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   1957: astore 7
        //   1959: aload 7
        //   1961: astore 6
        //   1963: aload 6
        //   1965: invokevirtual 346	java/lang/String:trim	()Ljava/lang/String;
        //   1968: astore 6
        //   1970: new 88	com/chelpus/Utils
        //   1973: dup
        //   1974: ldc 101
        //   1976: invokespecial 102	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
        //   1979: iconst_1
        //   1980: anewarray 104	java/lang/String
        //   1983: dup
        //   1984: iconst_0
        //   1985: new 40	java/lang/StringBuilder
        //   1988: dup
        //   1989: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   1992: ldc_w 365
        //   1995: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1998: getstatic 352	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
        //   2001: getfield 357	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
        //   2004: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2007: ldc_w 359
        //   2010: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2013: aload 6
        //   2015: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2018: ldc_w 361
        //   2021: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2024: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2027: aastore
        //   2028: invokevirtual 116	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
        //   2031: pop
        //   2032: iload_2
        //   2033: istore_1
        //   2034: goto -306 -> 1728
        //   2037: astore 6
        //   2039: aload 6
        //   2041: invokevirtual 368	java/lang/Exception:printStackTrace	()V
        //   2044: goto +963 -> 3007
        //   2047: aload 8
        //   2049: arraylength
        //   2050: istore_2
        //   2051: aload 5
        //   2053: astore 6
        //   2055: aload 9
        //   2057: astore 7
        //   2059: iload_1
        //   2060: iload_2
        //   2061: if_icmpge +97 -> 2158
        //   2064: iload_1
        //   2065: iconst_1
        //   2066: iadd
        //   2067: istore_1
        //   2068: goto -21 -> 2047
        //   2071: astore 5
        //   2073: aload 5
        //   2075: invokevirtual 368	java/lang/Exception:printStackTrace	()V
        //   2078: goto -1824 -> 254
        //   2081: astore 8
        //   2083: aload 5
        //   2085: astore 6
        //   2087: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2090: new 40	java/lang/StringBuilder
        //   2093: dup
        //   2094: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2097: ldc_w 370
        //   2100: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2103: aload 8
        //   2105: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   2108: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2111: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2114: goto -1256 -> 858
        //   2117: astore 5
        //   2119: aload 6
        //   2121: astore 8
        //   2123: aload 9
        //   2125: astore 7
        //   2127: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2130: new 40	java/lang/StringBuilder
        //   2133: dup
        //   2134: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2137: ldc_w 372
        //   2140: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2143: aload 5
        //   2145: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   2148: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2151: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2154: aload 9
        //   2156: astore 7
        //   2158: iload_3
        //   2159: iconst_1
        //   2160: iadd
        //   2161: istore_3
        //   2162: aload 6
        //   2164: astore 5
        //   2166: aload 7
        //   2168: astore 6
        //   2170: goto -1775 -> 395
        //   2173: astore 6
        //   2175: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2178: ldc_w 374
        //   2181: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2184: aload 7
        //   2186: astore 6
        //   2188: goto -336 -> 1852
        //   2191: astore 7
        //   2193: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2196: ldc_w 374
        //   2199: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2202: goto -239 -> 1963
        //   2205: astore 7
        //   2207: aload 5
        //   2209: astore 6
        //   2211: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2214: new 40	java/lang/StringBuilder
        //   2217: dup
        //   2218: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2221: ldc_w 376
        //   2224: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2227: aload 7
        //   2229: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   2232: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2235: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2238: aload 5
        //   2240: astore 6
        //   2242: aload 9
        //   2244: astore 7
        //   2246: goto -88 -> 2158
        //   2249: astore 6
        //   2251: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2254: new 40	java/lang/StringBuilder
        //   2257: dup
        //   2258: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2261: ldc_w 378
        //   2264: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2267: aload 6
        //   2269: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   2272: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2275: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2278: aload 5
        //   2280: astore 6
        //   2282: goto -124 -> 2158
        //   2285: astore 5
        //   2287: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2290: new 40	java/lang/StringBuilder
        //   2293: dup
        //   2294: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2297: ldc_w 380
        //   2300: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2303: aload 5
        //   2305: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   2308: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2311: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2314: aload 5
        //   2316: invokevirtual 368	java/lang/Exception:printStackTrace	()V
        //   2319: new 38	java/io/File
        //   2322: dup
        //   2323: new 40	java/lang/StringBuilder
        //   2326: dup
        //   2327: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2330: aload_0
        //   2331: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2334: ldc_w 382
        //   2337: iconst_0
        //   2338: invokevirtual 383	com/android/vending/billing/InAppBillingService/LACK/PatchService:getDir	(Ljava/lang/String;I)Ljava/io/File;
        //   2341: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   2344: ldc_w 385
        //   2347: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2350: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2353: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
        //   2356: astore 5
        //   2358: aload 5
        //   2360: invokevirtual 71	java/io/File:exists	()Z
        //   2363: ifeq +429 -> 2792
        //   2366: aload 5
        //   2368: invokevirtual 389	java/io/File:length	()J
        //   2371: lconst_0
        //   2372: lcmp
        //   2373: ifle +419 -> 2792
        //   2376: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2379: ldc_w 391
        //   2382: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2385: aload 5
        //   2387: invokevirtual 71	java/io/File:exists	()Z
        //   2390: ifne +9 -> 2399
        //   2393: aload 5
        //   2395: invokevirtual 394	java/io/File:createNewFile	()Z
        //   2398: pop
        //   2399: new 311	java/io/FileInputStream
        //   2402: dup
        //   2403: aload 5
        //   2405: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   2408: astore 6
        //   2410: new 307	java/io/BufferedReader
        //   2413: dup
        //   2414: new 309	java/io/InputStreamReader
        //   2417: dup
        //   2418: aload 6
        //   2420: ldc_w 316
        //   2423: invokespecial 319	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   2426: invokespecial 322	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   2429: astore 7
        //   2431: ldc 101
        //   2433: astore 5
        //   2435: aload 7
        //   2437: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   2440: astore 8
        //   2442: aload 8
        //   2444: ifnull +190 -> 2634
        //   2447: aload 8
        //   2449: ldc_w 396
        //   2452: invokevirtual 305	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   2455: astore 8
        //   2457: aload 8
        //   2459: arraylength
        //   2460: iconst_2
        //   2461: if_icmpne -26 -> 2435
        //   2464: ldc_w 398
        //   2467: new 40	java/lang/StringBuilder
        //   2470: dup
        //   2471: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2474: ldc_w 400
        //   2477: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2480: aload 8
        //   2482: iconst_0
        //   2483: aaload
        //   2484: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2487: ldc_w 402
        //   2490: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2493: aload 8
        //   2495: iconst_1
        //   2496: aaload
        //   2497: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2500: ldc_w 361
        //   2503: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2506: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2509: aload 8
        //   2511: iconst_0
        //   2512: aaload
        //   2513: aload 8
        //   2515: iconst_1
        //   2516: aaload
        //   2517: invokestatic 406	com/chelpus/Utils:verify_bind_and_run	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   2520: new 408	com/android/vending/billing/InAppBillingService/LACK/BindItem
        //   2523: dup
        //   2524: aload 8
        //   2526: iconst_0
        //   2527: aaload
        //   2528: aload 8
        //   2530: iconst_1
        //   2531: aaload
        //   2532: invokespecial 411	com/android/vending/billing/InAppBillingService/LACK/BindItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   2535: invokestatic 415	com/chelpus/Utils:checkBind	(Lcom/android/vending/billing/InAppBillingService/LACK/BindItem;)Z
        //   2538: ifeq -103 -> 2435
        //   2541: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2544: ldc_w 417
        //   2547: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2550: new 40	java/lang/StringBuilder
        //   2553: dup
        //   2554: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2557: aload 5
        //   2559: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2562: aload_0
        //   2563: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2566: ldc_w 418
        //   2569: invokevirtual 420	com/android/vending/billing/InAppBillingService/LACK/PatchService:getString	(I)Ljava/lang/String;
        //   2572: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2575: ldc_w 270
        //   2578: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2581: aload 8
        //   2583: iconst_0
        //   2584: aaload
        //   2585: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2588: ldc_w 270
        //   2591: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2594: aload_0
        //   2595: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2598: ldc_w 421
        //   2601: invokevirtual 420	com/android/vending/billing/InAppBillingService/LACK/PatchService:getString	(I)Ljava/lang/String;
        //   2604: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2607: ldc_w 270
        //   2610: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2613: aload 8
        //   2615: iconst_1
        //   2616: aaload
        //   2617: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2620: ldc_w 285
        //   2623: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2626: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2629: astore 5
        //   2631: goto -196 -> 2435
        //   2634: aload_0
        //   2635: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2638: getstatic 290	com/android/vending/billing/InAppBillingService/LACK/PatchService:notifyIndex	I
        //   2641: new 40	java/lang/StringBuilder
        //   2644: dup
        //   2645: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2648: ldc_w 292
        //   2651: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2654: aload_0
        //   2655: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2658: ldc_w 422
        //   2661: invokevirtual 420	com/android/vending/billing/InAppBillingService/LACK/PatchService:getString	(I)Ljava/lang/String;
        //   2664: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2667: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2670: aload_0
        //   2671: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2674: ldc_w 422
        //   2677: invokevirtual 420	com/android/vending/billing/InAppBillingService/LACK/PatchService:getString	(I)Ljava/lang/String;
        //   2680: aload 5
        //   2682: invokestatic 301	com/android/vending/billing/InAppBillingService/LACK/PatchService:access$000	(Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   2685: getstatic 290	com/android/vending/billing/InAppBillingService/LACK/PatchService:notifyIndex	I
        //   2688: iconst_1
        //   2689: iadd
        //   2690: putstatic 290	com/android/vending/billing/InAppBillingService/LACK/PatchService:notifyIndex	I
        //   2693: aload_0
        //   2694: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2697: getfield 426	com/android/vending/billing/InAppBillingService/LACK/PatchService:context	Landroid/content/Context;
        //   2700: invokestatic 432	android/appwidget/AppWidgetManager:getInstance	(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;
        //   2703: new 434	android/content/ComponentName
        //   2706: dup
        //   2707: aload_0
        //   2708: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2711: getfield 426	com/android/vending/billing/InAppBillingService/LACK/PatchService:context	Landroid/content/Context;
        //   2714: ldc_w 436
        //   2717: invokespecial 439	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
        //   2720: invokevirtual 443	android/appwidget/AppWidgetManager:getAppWidgetIds	(Landroid/content/ComponentName;)[I
        //   2723: astore 5
        //   2725: aload 5
        //   2727: ifnull +60 -> 2787
        //   2730: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2733: new 40	java/lang/StringBuilder
        //   2736: dup
        //   2737: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2740: ldc_w 445
        //   2743: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2746: aload 5
        //   2748: arraylength
        //   2749: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   2752: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2755: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2758: aload 5
        //   2760: arraylength
        //   2761: ifle +26 -> 2787
        //   2764: iconst_1
        //   2765: putstatic 449	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:binderWidget	Z
        //   2768: aload_0
        //   2769: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2772: getfield 131	com/android/vending/billing/InAppBillingService/LACK/PatchService:handler	Landroid/os/Handler;
        //   2775: new 15	com/android/vending/billing/InAppBillingService/LACK/PatchService$1$2
        //   2778: dup
        //   2779: aload_0
        //   2780: invokespecial 450	com/android/vending/billing/InAppBillingService/LACK/PatchService$1$2:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/PatchService$1;)V
        //   2783: invokevirtual 140	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   2786: pop
        //   2787: aload 6
        //   2789: invokevirtual 453	java/io/FileInputStream:close	()V
        //   2792: aload_0
        //   2793: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2796: getfield 426	com/android/vending/billing/InAppBillingService/LACK/PatchService:context	Landroid/content/Context;
        //   2799: invokestatic 432	android/appwidget/AppWidgetManager:getInstance	(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;
        //   2802: new 434	android/content/ComponentName
        //   2805: dup
        //   2806: aload_0
        //   2807: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2810: getfield 426	com/android/vending/billing/InAppBillingService/LACK/PatchService:context	Landroid/content/Context;
        //   2813: ldc_w 455
        //   2816: invokespecial 439	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
        //   2819: invokevirtual 443	android/appwidget/AppWidgetManager:getAppWidgetIds	(Landroid/content/ComponentName;)[I
        //   2822: astore 5
        //   2824: aload 5
        //   2826: ifnull +60 -> 2886
        //   2829: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2832: new 40	java/lang/StringBuilder
        //   2835: dup
        //   2836: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2839: ldc_w 457
        //   2842: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2845: aload 5
        //   2847: arraylength
        //   2848: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   2851: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2854: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2857: aload 5
        //   2859: arraylength
        //   2860: ifle +26 -> 2886
        //   2863: iconst_1
        //   2864: putstatic 460	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:appDisabler	Z
        //   2867: aload_0
        //   2868: getfield 23	com/android/vending/billing/InAppBillingService/LACK/PatchService$1:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PatchService;
        //   2871: getfield 131	com/android/vending/billing/InAppBillingService/LACK/PatchService:handler	Landroid/os/Handler;
        //   2874: new 17	com/android/vending/billing/InAppBillingService/LACK/PatchService$1$3
        //   2877: dup
        //   2878: aload_0
        //   2879: invokespecial 461	com/android/vending/billing/InAppBillingService/LACK/PatchService$1$3:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/PatchService$1;)V
        //   2882: invokevirtual 140	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   2885: pop
        //   2886: iconst_0
        //   2887: putstatic 464	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:patchOnBoot	Z
        //   2890: invokestatic 468	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
        //   2893: invokeinterface 474 1 0
        //   2898: ldc_w 476
        //   2901: iconst_0
        //   2902: invokeinterface 482 3 0
        //   2907: invokeinterface 485 1 0
        //   2912: pop
        //   2913: invokestatic 488	com/chelpus/Utils:exit	()V
        //   2916: return
        //   2917: astore 5
        //   2919: aload 5
        //   2921: invokevirtual 368	java/lang/Exception:printStackTrace	()V
        //   2924: goto -137 -> 2787
        //   2927: astore 5
        //   2929: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2932: ldc_w 490
        //   2935: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2938: goto -146 -> 2792
        //   2941: astore 5
        //   2943: getstatic 122	java/lang/System:out	Ljava/io/PrintStream;
        //   2946: new 40	java/lang/StringBuilder
        //   2949: dup
        //   2950: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   2953: ldc 101
        //   2955: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2958: aload 5
        //   2960: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   2963: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2966: invokevirtual 127	java/io/PrintStream:println	(Ljava/lang/String;)V
        //   2969: goto -177 -> 2792
        //   2972: astore 5
        //   2974: aload 5
        //   2976: invokevirtual 368	java/lang/Exception:printStackTrace	()V
        //   2979: goto -93 -> 2886
        //   2982: astore 5
        //   2984: goto -697 -> 2287
        //   2987: astore 6
        //   2989: aload 8
        //   2991: astore 5
        //   2993: goto -742 -> 2251
        //   2996: aload 6
        //   2998: astore 7
        //   3000: aload 5
        //   3002: astore 6
        //   3004: goto -846 -> 2158
        //   3007: iconst_0
        //   3008: istore_1
        //   3009: goto -962 -> 2047
        //   3012: goto -693 -> 2319
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	3015	0	this	1
        //   1727	1282	1	i	int
        //   1747	315	2	j	int
        //   394	1768	3	k	int
        //   1822	114	4	bool	boolean
        //   35	2017	5	localObject1	Object
        //   2071	13	5	localException1	Exception
        //   2117	27	5	localException2	Exception
        //   2164	115	5	localObject2	Object
        //   2285	30	5	localException3	Exception
        //   2356	502	5	localObject3	Object
        //   2917	3	5	localException4	Exception
        //   2927	1	5	localFileNotFoundException	java.io.FileNotFoundException
        //   2941	18	5	localIOException	java.io.IOException
        //   2972	3	5	localException5	Exception
        //   2982	1	5	localException6	Exception
        //   2991	10	5	localObject4	Object
        //   137	1877	6	localObject5	Object
        //   2037	3	6	localException7	Exception
        //   2053	116	6	localObject6	Object
        //   2173	1	6	localJSONException1	org.json.JSONException
        //   2186	55	6	localObject7	Object
        //   2249	19	6	localException8	Exception
        //   2280	508	6	localObject8	Object
        //   2987	10	6	localException9	Exception
        //   3002	1	6	localObject9	Object
        //   413	1772	7	localObject10	Object
        //   2191	1	7	localJSONException2	org.json.JSONException
        //   2205	23	7	localException10	Exception
        //   2244	755	7	localObject11	Object
        //   615	1433	8	localObject12	Object
        //   2081	23	8	localException11	Exception
        //   2121	869	8	localObject13	Object
        //   749	1494	9	localFile	File
        //   320	1159	10	str	String
        //   329	505	11	localPackageManager	android.content.pm.PackageManager
        //   351	1350	12	arrayOfFile	File[]
        //   1183	546	13	localObject14	Object
        //   1724	221	14	arrayOfString	String[]
        // Exception table:
        //   from	to	target	type
        //   1688	1726	2037	java/lang/Exception
        //   1728	1735	2037	java/lang/Exception
        //   1748	1764	2037	java/lang/Exception
        //   1766	1782	2037	java/lang/Exception
        //   1784	1800	2037	java/lang/Exception
        //   1812	1824	2037	java/lang/Exception
        //   1833	1852	2037	java/lang/Exception
        //   1852	1921	2037	java/lang/Exception
        //   1921	1933	2037	java/lang/Exception
        //   1940	1959	2037	java/lang/Exception
        //   1963	2032	2037	java/lang/Exception
        //   2175	2184	2037	java/lang/Exception
        //   2193	2202	2037	java/lang/Exception
        //   188	254	2071	java/lang/Exception
        //   833	854	2081	java/lang/Exception
        //   862	888	2117	java/lang/Exception
        //   896	906	2117	java/lang/Exception
        //   910	942	2117	java/lang/Exception
        //   950	960	2117	java/lang/Exception
        //   972	982	2117	java/lang/Exception
        //   990	996	2117	java/lang/Exception
        //   1006	1017	2117	java/lang/Exception
        //   1021	1038	2117	java/lang/Exception
        //   2087	2114	2117	java/lang/Exception
        //   2211	2238	2117	java/lang/Exception
        //   1833	1852	2173	org/json/JSONException
        //   1940	1959	2191	org/json/JSONException
        //   1038	1190	2205	java/lang/Exception
        //   1190	1201	2205	java/lang/Exception
        //   1201	1688	2205	java/lang/Exception
        //   2039	2044	2205	java/lang/Exception
        //   2047	2051	2205	java/lang/Exception
        //   415	430	2249	java/lang/Exception
        //   434	449	2249	java/lang/Exception
        //   453	468	2249	java/lang/Exception
        //   472	487	2249	java/lang/Exception
        //   491	506	2249	java/lang/Exception
        //   510	528	2249	java/lang/Exception
        //   532	550	2249	java/lang/Exception
        //   554	572	2249	java/lang/Exception
        //   576	613	2249	java/lang/Exception
        //   692	700	2249	java/lang/Exception
        //   704	710	2249	java/lang/Exception
        //   714	751	2249	java/lang/Exception
        //   335	393	2285	java/lang/Exception
        //   2251	2278	2285	java/lang/Exception
        //   2693	2725	2917	java/lang/Exception
        //   2730	2787	2917	java/lang/Exception
        //   2385	2399	2927	java/io/FileNotFoundException
        //   2399	2431	2927	java/io/FileNotFoundException
        //   2435	2442	2927	java/io/FileNotFoundException
        //   2447	2631	2927	java/io/FileNotFoundException
        //   2634	2693	2927	java/io/FileNotFoundException
        //   2693	2725	2927	java/io/FileNotFoundException
        //   2730	2787	2927	java/io/FileNotFoundException
        //   2787	2792	2927	java/io/FileNotFoundException
        //   2919	2924	2927	java/io/FileNotFoundException
        //   2385	2399	2941	java/io/IOException
        //   2399	2431	2941	java/io/IOException
        //   2435	2442	2941	java/io/IOException
        //   2447	2631	2941	java/io/IOException
        //   2634	2693	2941	java/io/IOException
        //   2693	2725	2941	java/io/IOException
        //   2730	2787	2941	java/io/IOException
        //   2787	2792	2941	java/io/IOException
        //   2919	2924	2941	java/io/IOException
        //   2792	2824	2972	java/lang/Exception
        //   2829	2886	2972	java/lang/Exception
        //   395	411	2982	java/lang/Exception
        //   621	629	2987	java/lang/Exception
        //   637	643	2987	java/lang/Exception
        //   651	688	2987	java/lang/Exception
        //   759	767	2987	java/lang/Exception
        //   775	781	2987	java/lang/Exception
        //   789	829	2987	java/lang/Exception
        //   2127	2154	2987	java/lang/Exception
      }
    });
    System.out.println("LuckyPatcher: Start thread patch!");
    this.t.setPriority(10);
    this.t.start();
    return 2;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/PatchService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */