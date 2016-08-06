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
import com.google.android.finsky.billing.iab.InAppBillingService;
import com.google.android.finsky.billing.iab.MarketBillingService;
import java.io.File;

public class proxyGP_widget
  extends AppWidgetProvider
{
  public static String ACTION_WIDGET_RECEIVER = "ActionReceiverProxyGPWidget";
  public static String ACTION_WIDGET_RECEIVER_Updater = "ActionReceiverWidgetProxyGPUpdate";
  Context cont = null;
  
  public static void pushWidgetUpdate(Context paramContext, RemoteViews paramRemoteViews)
  {
    ComponentName localComponentName = new ComponentName(paramContext, proxyGP_widget.class);
    AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, paramRemoteViews);
  }
  
  /* Error */
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 64	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4: putstatic 70	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   7: aload_2
    //   8: invokevirtual 76	android/content/Intent:getAction	()Ljava/lang/String;
    //   11: astore 12
    //   13: getstatic 23	com/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget:ACTION_WIDGET_RECEIVER	Ljava/lang/String;
    //   16: aload 12
    //   18: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifeq +582 -> 603
    //   24: invokestatic 85	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:init	()V
    //   27: new 87	android/os/Handler
    //   30: dup
    //   31: invokespecial 88	android/os/Handler:<init>	()V
    //   34: astore 13
    //   36: new 90	android/widget/RemoteViews
    //   39: dup
    //   40: aload_1
    //   41: invokevirtual 95	android/content/Context:getPackageName	()Ljava/lang/String;
    //   44: ldc 96
    //   46: invokespecial 99	android/widget/RemoteViews:<init>	(Ljava/lang/String;I)V
    //   49: astore 9
    //   51: aload 9
    //   53: ldc 100
    //   55: ldc 102
    //   57: invokevirtual 106	android/widget/RemoteViews:setTextViewText	(ILjava/lang/CharSequence;)V
    //   60: aload 9
    //   62: ldc 107
    //   64: iconst_0
    //   65: invokevirtual 111	android/widget/RemoteViews:setViewVisibility	(II)V
    //   68: aload_1
    //   69: invokestatic 46	android/appwidget/AppWidgetManager:getInstance	(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;
    //   72: astore 14
    //   74: aload 14
    //   76: new 37	android/content/ComponentName
    //   79: dup
    //   80: aload_1
    //   81: ldc 2
    //   83: invokespecial 40	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   86: invokevirtual 115	android/appwidget/AppWidgetManager:getAppWidgetIds	(Landroid/content/ComponentName;)[I
    //   89: astore 15
    //   91: aload 14
    //   93: aload 15
    //   95: aload 9
    //   97: invokevirtual 118	android/appwidget/AppWidgetManager:updateAppWidget	([ILandroid/widget/RemoteViews;)V
    //   100: getstatic 122	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:su	Z
    //   103: ifeq +718 -> 821
    //   106: invokestatic 128	com/chelpus/Utils:checkCoreJarPatch11	()Z
    //   109: ifeq +712 -> 821
    //   112: invokestatic 131	com/chelpus/Utils:checkCoreJarPatch12	()Z
    //   115: ifeq +706 -> 821
    //   118: aconst_null
    //   119: astore 9
    //   121: aload_1
    //   122: invokevirtual 135	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   125: ldc -119
    //   127: iconst_0
    //   128: invokevirtual 143	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   131: astore 10
    //   133: aload 10
    //   135: astore 9
    //   137: aload 9
    //   139: ifnull +464 -> 603
    //   142: aload 9
    //   144: getfield 149	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   147: getfield 154	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   150: invokestatic 158	com/chelpus/Utils:getFileDalvikCache	(Ljava/lang/String;)Ljava/io/File;
    //   153: astore 16
    //   155: new 160	java/io/File
    //   158: dup
    //   159: aload 9
    //   161: getfield 149	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   164: getfield 154	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   167: iconst_1
    //   168: invokestatic 164	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   171: invokespecial 167	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: astore 17
    //   176: iconst_0
    //   177: istore_3
    //   178: invokestatic 170	com/chelpus/Utils:isXposedEnabled	()Z
    //   181: ifeq +498 -> 679
    //   184: new 172	java/util/ArrayList
    //   187: dup
    //   188: invokespecial 173	java/util/ArrayList:<init>	()V
    //   191: pop
    //   192: aconst_null
    //   193: astore 10
    //   195: invokestatic 177	com/chelpus/Utils:readXposedParamBoolean	()Lorg/json/JSONObject;
    //   198: astore 11
    //   200: aload 11
    //   202: astore 10
    //   204: iconst_0
    //   205: istore 4
    //   207: aload 10
    //   209: ifnull +13 -> 222
    //   212: aload 10
    //   214: ldc -77
    //   216: iconst_0
    //   217: invokevirtual 185	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   220: istore 4
    //   222: iload 4
    //   224: ifne +5 -> 229
    //   227: iconst_1
    //   228: istore_3
    //   229: iload_3
    //   230: ifeq +562 -> 792
    //   233: new 160	java/io/File
    //   236: dup
    //   237: new 187	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   244: aload_1
    //   245: invokevirtual 192	android/content/Context:getFilesDir	()Ljava/io/File;
    //   248: invokevirtual 195	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   251: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc -55
    //   256: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokespecial 167	java/io/File:<init>	(Ljava/lang/String;)V
    //   265: invokevirtual 207	java/io/File:exists	()Z
    //   268: ifne +262 -> 530
    //   271: new 160	java/io/File
    //   274: dup
    //   275: new 187	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   282: getstatic 210	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
    //   285: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc -44
    //   290: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc -42
    //   295: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokespecial 167	java/io/File:<init>	(Ljava/lang/String;)V
    //   304: astore 10
    //   306: ldc -41
    //   308: invokestatic 219	com/chelpus/Utils:getRawLength	(I)J
    //   311: lstore 5
    //   313: aload 10
    //   315: invokevirtual 207	java/io/File:exists	()Z
    //   318: ifeq +14 -> 332
    //   321: aload 10
    //   323: invokevirtual 223	java/io/File:length	()J
    //   326: lload 5
    //   328: lcmp
    //   329: ifeq +201 -> 530
    //   332: aload 10
    //   334: invokevirtual 223	java/io/File:length	()J
    //   337: lload 5
    //   339: lcmp
    //   340: ifeq +56 -> 396
    //   343: getstatic 229	java/lang/System:out	Ljava/io/PrintStream;
    //   346: new 187	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   353: ldc -25
    //   355: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: lload 5
    //   360: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   363: ldc -20
    //   365: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload 10
    //   370: invokevirtual 223	java/io/File:length	()J
    //   373: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   376: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokevirtual 241	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   382: aload 10
    //   384: invokevirtual 207	java/io/File:exists	()Z
    //   387: ifeq +9 -> 396
    //   390: aload 10
    //   392: invokevirtual 244	java/io/File:delete	()Z
    //   395: pop
    //   396: ldc -41
    //   398: new 160	java/io/File
    //   401: dup
    //   402: new 187	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   409: getstatic 210	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
    //   412: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc -10
    //   417: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokespecial 167	java/io/File:<init>	(Ljava/lang/String;)V
    //   426: invokestatic 250	com/chelpus/Utils:getRawToFile	(ILjava/io/File;)Z
    //   429: pop
    //   430: new 160	java/io/File
    //   433: dup
    //   434: aload 10
    //   436: invokevirtual 195	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   439: invokespecial 167	java/io/File:<init>	(Ljava/lang/String;)V
    //   442: sipush 3583
    //   445: invokestatic 254	com/chelpus/Utils:chmod	(Ljava/io/File;I)I
    //   448: pop
    //   449: new 187	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 256
    //   459: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 10
    //   464: invokevirtual 195	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   467: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 259	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   476: new 187	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 261
    //   486: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 10
    //   491: invokevirtual 195	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   494: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 259	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   503: new 187	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 263
    //   513: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload 10
    //   518: invokevirtual 195	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   521: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 259	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   530: lconst_0
    //   531: lstore 7
    //   533: aload 17
    //   535: invokevirtual 207	java/io/File:exists	()Z
    //   538: ifeq +164 -> 702
    //   541: aload 17
    //   543: invokevirtual 223	java/io/File:length	()J
    //   546: lstore 5
    //   548: lload 5
    //   550: lconst_0
    //   551: lcmp
    //   552: ifle +198 -> 750
    //   555: lload 5
    //   557: ldc2_w 264
    //   560: lcmp
    //   561: ifge +189 -> 750
    //   564: new 267	java/lang/Thread
    //   567: dup
    //   568: new 6	com/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget$1
    //   571: dup
    //   572: aload_0
    //   573: aload 9
    //   575: getfield 149	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   578: getfield 154	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   581: aload 9
    //   583: getfield 149	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   586: getfield 271	android/content/pm/ApplicationInfo:uid	I
    //   589: invokestatic 274	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   592: aload 13
    //   594: invokespecial 277	com/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget$1:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget;Ljava/lang/String;Ljava/lang/String;Landroid/os/Handler;)V
    //   597: invokespecial 280	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   600: invokevirtual 283	java/lang/Thread:start	()V
    //   603: getstatic 27	com/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget:ACTION_WIDGET_RECEIVER_Updater	Ljava/lang/String;
    //   606: aload 12
    //   608: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   611: ifeq +35 -> 646
    //   614: iconst_1
    //   615: putstatic 286	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:appDisabler	Z
    //   618: aload_1
    //   619: invokestatic 46	android/appwidget/AppWidgetManager:getInstance	(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;
    //   622: astore 9
    //   624: aload_0
    //   625: aload_1
    //   626: aload 9
    //   628: aload 9
    //   630: new 37	android/content/ComponentName
    //   633: dup
    //   634: aload_1
    //   635: ldc 2
    //   637: invokespecial 40	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   640: invokevirtual 115	android/appwidget/AppWidgetManager:getAppWidgetIds	(Landroid/content/ComponentName;)[I
    //   643: invokevirtual 290	com/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget:onUpdate	(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V
    //   646: aload_0
    //   647: aload_1
    //   648: aload_2
    //   649: invokespecial 292	android/appwidget/AppWidgetProvider:onReceive	(Landroid/content/Context;Landroid/content/Intent;)V
    //   652: return
    //   653: astore 10
    //   655: aload_1
    //   656: ldc_w 294
    //   659: iconst_0
    //   660: invokestatic 300	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   663: invokevirtual 303	android/widget/Toast:show	()V
    //   666: goto -529 -> 137
    //   669: astore 11
    //   671: aload 11
    //   673: invokevirtual 306	org/json/JSONException:printStackTrace	()V
    //   676: goto -472 -> 204
    //   679: iconst_1
    //   680: istore_3
    //   681: goto -452 -> 229
    //   684: astore 11
    //   686: getstatic 229	java/lang/System:out	Ljava/io/PrintStream;
    //   689: aload 11
    //   691: invokevirtual 309	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   694: aload 11
    //   696: invokevirtual 310	java/lang/Exception:printStackTrace	()V
    //   699: goto -250 -> 449
    //   702: aload 16
    //   704: invokevirtual 223	java/io/File:length	()J
    //   707: lstore 5
    //   709: goto -161 -> 548
    //   712: astore 10
    //   714: lload 7
    //   716: lstore 5
    //   718: aload 16
    //   720: invokevirtual 207	java/io/File:exists	()Z
    //   723: ifeq -175 -> 548
    //   726: aload 16
    //   728: invokevirtual 223	java/io/File:length	()J
    //   731: lstore 5
    //   733: goto -185 -> 548
    //   736: astore 10
    //   738: aload 10
    //   740: invokevirtual 310	java/lang/Exception:printStackTrace	()V
    //   743: lload 7
    //   745: lstore 5
    //   747: goto -199 -> 548
    //   750: new 267	java/lang/Thread
    //   753: dup
    //   754: new 10	com/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget$2
    //   757: dup
    //   758: aload_0
    //   759: aload 9
    //   761: getfield 149	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   764: getfield 154	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   767: aload 9
    //   769: getfield 149	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   772: getfield 271	android/content/pm/ApplicationInfo:uid	I
    //   775: invokestatic 274	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   778: aload 13
    //   780: invokespecial 311	com/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget$2:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget;Ljava/lang/String;Ljava/lang/String;Landroid/os/Handler;)V
    //   783: invokespecial 280	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   786: invokevirtual 283	java/lang/Thread:start	()V
    //   789: goto -186 -> 603
    //   792: aload_1
    //   793: aload_1
    //   794: ldc_w 312
    //   797: invokevirtual 316	android/content/Context:getText	(I)Ljava/lang/CharSequence;
    //   800: iconst_0
    //   801: invokestatic 300	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   804: invokevirtual 303	android/widget/Toast:show	()V
    //   807: aload_0
    //   808: invokestatic 319	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   811: aload 14
    //   813: aload 15
    //   815: invokevirtual 290	com/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget:onUpdate	(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V
    //   818: goto -215 -> 603
    //   821: aload_1
    //   822: aload_1
    //   823: ldc_w 320
    //   826: invokevirtual 316	android/content/Context:getText	(I)Ljava/lang/CharSequence;
    //   829: iconst_0
    //   830: invokestatic 300	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   833: invokevirtual 303	android/widget/Toast:show	()V
    //   836: aload_0
    //   837: invokestatic 319	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   840: aload 14
    //   842: aload 15
    //   844: invokevirtual 290	com/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget:onUpdate	(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V
    //   847: goto -244 -> 603
    //   850: astore 9
    //   852: aload 9
    //   854: invokevirtual 310	java/lang/Exception:printStackTrace	()V
    //   857: goto -211 -> 646
    //   860: astore 11
    //   862: goto -432 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	865	0	this	proxyGP_widget
    //   0	865	1	paramContext	Context
    //   0	865	2	paramIntent	Intent
    //   177	504	3	i	int
    //   205	18	4	bool	boolean
    //   311	435	5	l1	long
    //   531	213	7	l2	long
    //   49	719	9	localObject1	Object
    //   850	3	9	localException1	Exception
    //   131	386	10	localObject2	Object
    //   653	1	10	localNameNotFoundException	PackageManager.NameNotFoundException
    //   712	1	10	localException2	Exception
    //   736	3	10	localException3	Exception
    //   198	3	11	localJSONObject	org.json.JSONObject
    //   669	3	11	localJSONException	org.json.JSONException
    //   684	11	11	localException4	Exception
    //   860	1	11	localException5	Exception
    //   11	596	12	str	String
    //   34	745	13	localHandler	Handler
    //   72	769	14	localAppWidgetManager	AppWidgetManager
    //   89	754	15	arrayOfInt	int[]
    //   153	574	16	localFile1	File
    //   174	368	17	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   121	133	653	android/content/pm/PackageManager$NameNotFoundException
    //   195	200	669	org/json/JSONException
    //   430	449	684	java/lang/Exception
    //   533	548	712	java/lang/Exception
    //   702	709	712	java/lang/Exception
    //   718	733	736	java/lang/Exception
    //   614	646	850	java/lang/Exception
    //   396	430	860	java/lang/Exception
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    this.cont = paramContext;
    listAppsFragment.startUnderRoot = Boolean.valueOf(false);
    localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130968641);
    localObject = new Intent(paramContext, proxyGP_widget.class);
    ((Intent)localObject).setAction(ACTION_WIDGET_RECEIVER);
    ((Intent)localObject).putExtra("msg", "Hello Habrahabr");
    localRemoteViews.setOnClickPendingIntent(2131558648, PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 0));
    localRemoteViews.setTextViewText(2131558648, "Proxy GP");
    localRemoteViews.setViewVisibility(2131558649, 8);
    localObject = null;
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      paramContext = localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        try
        {
          if (paramContext.exists())
          {
            l1 = paramContext.length();
            if ((l1 > 0L) && (l1 < 1048576L))
            {
              localRemoteViews.setTextColor(2131558648, Color.parseColor("#00FF00"));
              paramAppWidgetManager.updateAppWidget(paramArrayOfInt, localRemoteViews);
              return;
              localNameNotFoundException = localNameNotFoundException;
              Toast.makeText(paramContext, "Google Play not installed.", 0).show();
              paramContext = (Context)localObject;
            }
          }
          else
          {
            l1 = ((File)localObject).length();
            continue;
          }
        }
        catch (Exception paramContext)
        {
          long l2;
          long l1 = l2;
          try
          {
            if (!((File)localObject).exists()) {
              continue;
            }
            l1 = ((File)localObject).length();
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
            l1 = l2;
          }
          continue;
          localRemoteViews.setTextColor(2131558648, Color.parseColor("#FF0000"));
          continue;
        }
        localRemoteViews.setTextColor(2131558648, Color.parseColor("#FF0000"));
      }
    }
    if (paramContext != null)
    {
      localObject = Utils.getFileDalvikCache(paramContext.applicationInfo.sourceDir);
      paramContext = new File(Utils.getPlaceForOdex(paramContext.applicationInfo.sourceDir, true));
      l2 = 0L;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/widgets/proxyGP_widget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */