package com.android.vending.billing.InAppBillingService.LACK;

import android.content.BroadcastReceiver;
import android.content.Context;

public class BinderLuckyPatcher
  extends BroadcastReceiver
{
  public static Context contextB = null;
  
  /* Error */
  public void onReceive(final Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: getstatic 28	java/lang/System:out	Ljava/io/PrintStream;
    //   3: new 30	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   10: ldc 33
    //   12: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_2
    //   16: invokevirtual 43	android/content/Intent:toString	()Ljava/lang/String;
    //   19: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokevirtual 50	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: putstatic 12	com/android/vending/billing/InAppBillingService/LACK/BinderLuckyPatcher:contextB	Landroid/content/Context;
    //   32: invokestatic 55	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:init	()V
    //   35: getstatic 59	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:su	Z
    //   38: ifeq +249 -> 287
    //   41: aload_2
    //   42: invokevirtual 62	android/content/Intent:getAction	()Ljava/lang/String;
    //   45: ldc 64
    //   47: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifne +15 -> 65
    //   53: aload_2
    //   54: invokevirtual 62	android/content/Intent:getAction	()Ljava/lang/String;
    //   57: ldc 72
    //   59: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifeq +26 -> 88
    //   65: new 74	java/lang/Thread
    //   68: dup
    //   69: new 6	com/android/vending/billing/InAppBillingService/LACK/BinderLuckyPatcher$1
    //   72: dup
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial 77	com/android/vending/billing/InAppBillingService/LACK/BinderLuckyPatcher$1:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/BinderLuckyPatcher;Landroid/content/Context;)V
    //   78: invokespecial 80	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   81: invokevirtual 83	java/lang/Thread:start	()V
    //   84: iconst_1
    //   85: putstatic 86	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:patchOnBoot	Z
    //   88: aload_2
    //   89: invokevirtual 62	android/content/Intent:getAction	()Ljava/lang/String;
    //   92: ldc 88
    //   94: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +190 -> 287
    //   100: new 90	java/io/File
    //   103: dup
    //   104: new 30	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   111: aload_1
    //   112: ldc 92
    //   114: iconst_0
    //   115: invokevirtual 98	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   118: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: ldc 103
    //   123: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 109	java/io/File:exists	()Z
    //   137: ifeq +150 -> 287
    //   140: aload_2
    //   141: invokevirtual 113	java/io/File:length	()J
    //   144: lconst_0
    //   145: lcmp
    //   146: ifle +141 -> 287
    //   149: getstatic 28	java/lang/System:out	Ljava/io/PrintStream;
    //   152: ldc 115
    //   154: invokevirtual 50	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   157: aload_2
    //   158: invokevirtual 109	java/io/File:exists	()Z
    //   161: ifne +8 -> 169
    //   164: aload_2
    //   165: invokevirtual 118	java/io/File:createNewFile	()Z
    //   168: pop
    //   169: new 120	java/io/FileInputStream
    //   172: dup
    //   173: aload_2
    //   174: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   177: astore_2
    //   178: new 125	java/io/BufferedReader
    //   181: dup
    //   182: new 127	java/io/InputStreamReader
    //   185: dup
    //   186: aload_2
    //   187: ldc -127
    //   189: invokespecial 132	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   192: invokespecial 135	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   195: astore_3
    //   196: aload_3
    //   197: invokevirtual 138	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   200: astore 4
    //   202: aload 4
    //   204: ifnull +101 -> 305
    //   207: aload 4
    //   209: ldc -116
    //   211: invokevirtual 144	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   214: astore 4
    //   216: aload 4
    //   218: arraylength
    //   219: iconst_2
    //   220: if_icmpne -24 -> 196
    //   223: ldc -110
    //   225: new 30	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   232: ldc -108
    //   234: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 4
    //   239: iconst_0
    //   240: aaload
    //   241: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc -106
    //   246: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 4
    //   251: iconst_1
    //   252: aaload
    //   253: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc -104
    //   258: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: aload 4
    //   266: iconst_0
    //   267: aaload
    //   268: aload 4
    //   270: iconst_1
    //   271: aaload
    //   272: invokestatic 158	com/chelpus/Utils:verify_bind_and_run	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   275: goto -79 -> 196
    //   278: astore_1
    //   279: getstatic 28	java/lang/System:out	Ljava/io/PrintStream;
    //   282: ldc -96
    //   284: invokevirtual 50	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   287: invokestatic 164	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   290: ldc -90
    //   292: iconst_0
    //   293: invokeinterface 172 3 0
    //   298: ifne +6 -> 304
    //   301: invokestatic 175	com/chelpus/Utils:exit	()V
    //   304: return
    //   305: new 39	android/content/Intent
    //   308: dup
    //   309: aload_1
    //   310: ldc -79
    //   312: invokespecial 180	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   315: astore_3
    //   316: aload_3
    //   317: getstatic 184	com/android/vending/billing/InAppBillingService/LACK/widgets/BinderWidget:ACTION_WIDGET_RECEIVER_Updater	Ljava/lang/String;
    //   320: invokevirtual 188	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   323: pop
    //   324: aload_1
    //   325: aload_3
    //   326: invokevirtual 192	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   329: aload_2
    //   330: invokevirtual 195	java/io/FileInputStream:close	()V
    //   333: goto -46 -> 287
    //   336: astore_1
    //   337: getstatic 28	java/lang/System:out	Ljava/io/PrintStream;
    //   340: new 30	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   347: ldc -59
    //   349: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_1
    //   353: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokevirtual 50	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   362: goto -75 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	BinderLuckyPatcher
    //   0	365	1	paramContext	Context
    //   0	365	2	paramIntent	android.content.Intent
    //   195	131	3	localObject1	Object
    //   200	69	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   157	169	278	java/io/FileNotFoundException
    //   169	196	278	java/io/FileNotFoundException
    //   196	202	278	java/io/FileNotFoundException
    //   207	275	278	java/io/FileNotFoundException
    //   305	333	278	java/io/FileNotFoundException
    //   157	169	336	java/io/IOException
    //   169	196	336	java/io/IOException
    //   196	202	336	java/io/IOException
    //   207	275	336	java/io/IOException
    //   305	333	336	java/io/IOException
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/BinderLuckyPatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */