package com.android.vending.billing.InAppBillingService.LACK;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogCollector
{
  public static final String LINE_SEPARATOR = "\n";
  private static final String LOG_TAG = LogCollector.class.getSimpleName();
  private ArrayList<String> mLastLogs;
  private String mPackageName = listAppsFragment.getInstance().getPackageName();
  private Pattern mPattern = Pattern.compile(String.format("(.*)E\\/AndroidRuntime\\(\\s*\\d+\\)\\:\\s*at\\s%s.*", new Object[] { this.mPackageName.replace(".", "\\.") }));
  private SharedPreferences mPrefs;
  
  public LogCollector()
  {
    listAppsFragment.getInstance();
    this.mPrefs = listAppsFragment.getInstance().getSharedPreferences("LogCollector", 0);
    this.mLastLogs = new ArrayList();
    this.mPrefs.edit().clear().commit();
  }
  
  private void collectLog(List<String> paramList, String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean)
  {
    paramList.clear();
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "time";
    }
    localArrayList.add("-v");
    localArrayList.add(localObject);
    if (paramString2 != null)
    {
      localArrayList.add("-b");
      localArrayList.add(paramString2);
    }
    if (paramArrayOfString != null) {
      Collections.addAll(localArrayList, paramArrayOfString);
    }
    for (;;)
    {
      try
      {
        if ((!listAppsFragment.su) || (paramBoolean))
        {
          System.out.println("Collect logs no root.");
          paramString1 = new ArrayList();
          paramString1.add("logcat");
          paramString1.add("-d");
          paramString1.addAll(localArrayList);
          paramString1 = (String[])paramString1.toArray(new String[paramString1.size()]);
          if (listAppsFragment.basepath.startsWith(listAppsFragment.patchAct.getDir("sdcard", 0).getAbsolutePath())) {
            paramString1 = new String[] { "logcat", "-d", "System.out:*", "*:S" };
          }
          paramString1 = Runtime.getRuntime().exec(paramString1);
          paramString2 = new BufferedReader(new InputStreamReader(paramString1.getInputStream()));
          paramArrayOfString = paramString2.readLine();
          if (paramArrayOfString != null)
          {
            paramList.add(paramArrayOfString);
            continue;
          }
          paramString1.destroy();
        }
      }
      catch (IOException paramString1)
      {
        try
        {
          paramString1 = Runtime.getRuntime().exec("su");
          paramString2 = new DataOutputStream(paramString1.getOutputStream());
          paramArrayOfString = new DataInputStream(paramString1.getErrorStream());
          localObject = new byte[paramArrayOfString.available()];
          paramArrayOfString.read((byte[])localObject);
          System.out.println(new String((byte[])localObject));
          paramArrayOfString = new BufferedReader(new InputStreamReader(paramString1.getInputStream()));
          if (!listAppsFragment.basepath.startsWith(listAppsFragment.patchAct.getDir("sdcard", 0).getAbsolutePath())) {
            break label914;
          }
          paramString2.writeBytes("logcat -d System.out:* *:S\n");
          paramString2.flush();
          paramString2.close();
          paramString2 = paramArrayOfString.readLine();
          if (paramString2 == null) {
            break;
          }
          paramList.add(paramString2);
          continue;
          return;
        }
        catch (IOException paramList)
        {
          paramList.printStackTrace();
        }
      }
      label394:
      label889:
      do
      {
        if (paramString2 != null) {
          paramString2.close();
        }
        if (paramList.size() == 0)
        {
          paramString1 = Runtime.getRuntime().exec("su");
          paramString2 = new DataOutputStream(paramString1.getOutputStream());
          paramArrayOfString = new DataInputStream(paramString1.getErrorStream());
          localObject = new byte[paramArrayOfString.available()];
          paramArrayOfString.read((byte[])localObject);
          System.out.println(new String((byte[])localObject));
          paramArrayOfString = new BufferedReader(new InputStreamReader(paramString1.getInputStream()));
          if (!listAppsFragment.basepath.startsWith(listAppsFragment.patchAct.getDir("sdcard", 0).getAbsolutePath())) {
            break label889;
          }
          paramString2.writeBytes("logcat -d System.out:* *:S\n");
        }
        for (;;)
        {
          paramString2.flush();
          paramString2.close();
          for (;;)
          {
            paramString2 = paramArrayOfString.readLine();
            if (paramString2 == null) {
              break;
            }
            paramList.add(paramString2);
          }
          paramString1 = Runtime.getRuntime().exec("su");
          paramString2 = new DataOutputStream(paramString1.getOutputStream());
          paramArrayOfString = new DataInputStream(paramString1.getErrorStream());
          localObject = new byte[paramArrayOfString.available()];
          paramArrayOfString.read((byte[])localObject);
          System.out.println(new String((byte[])localObject));
          paramArrayOfString = new BufferedReader(new InputStreamReader(paramString1.getInputStream()));
          if (listAppsFragment.basepath.startsWith(listAppsFragment.patchAct.getDir("sdcard", 0).getAbsolutePath())) {
            paramString2.writeBytes("logcat -d System.out:* *:S\n");
          }
          for (;;)
          {
            paramString2.flush();
            paramString2.close();
            try
            {
              for (;;)
              {
                paramString2 = paramArrayOfString.readLine();
                if (paramString2 == null) {
                  break;
                }
                paramList.add(paramString2);
              }
              paramArrayOfString = paramString2.readLine();
            }
            catch (Exception paramString2)
            {
              paramString2.printStackTrace();
              if (paramArrayOfString != null) {
                paramArrayOfString.close();
              }
              paramString1.destroy();
              System.out.println("Collect logs no root.");
              paramList.add("\n\n\n*********************************** NO ROOT *******************************************************\n\n\n");
              paramString1 = new ArrayList();
              paramString1.add("logcat");
              paramString1.add("-d");
              paramString1.addAll(localArrayList);
              paramString1 = (String[])paramString1.toArray(new String[paramString1.size()]);
              if (listAppsFragment.basepath.startsWith(listAppsFragment.patchAct.getDir("sdcard", 0).getAbsolutePath())) {
                paramString1 = new String[] { "logcat", "-d", "System.out:*", "*:S" };
              }
              paramString1 = Runtime.getRuntime().exec(paramString1);
              paramString2 = new BufferedReader(new InputStreamReader(paramString1.getInputStream()));
            }
            while (paramArrayOfString != null) {
              paramList.add(paramArrayOfString);
            }
            paramString2.writeBytes("logcat -d -v time\n");
          }
          paramString1.destroy();
          if (paramString2 == null) {
            break label394;
          }
          paramString2.close();
          break label394;
          break;
          paramString2.writeBytes("logcat -d\n");
        }
        paramString1.destroy();
      } while (paramArrayOfString == null);
      paramArrayOfString.close();
      return;
      label914:
      paramString2.writeBytes("logcat -d\n");
    }
    paramString1.destroy();
  }
  
  private String collectPhoneInfo()
  {
    return String.format("Carrier:%s\nModel:%s\nFirmware:%s\n", new Object[] { Build.BRAND, Build.MODEL, Build.VERSION.RELEASE });
  }
  
  /* Error */
  public boolean collect(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	com/android/vending/billing/InAppBillingService/LACK/LogCollector:mLastLogs	Ljava/util/ArrayList;
    //   4: astore 4
    //   6: getstatic 126	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:su	Z
    //   9: ifeq +179 -> 188
    //   12: aload_0
    //   13: aload 4
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: iconst_0
    //   19: invokespecial 296	com/android/vending/billing/InAppBillingService/LACK/LogCollector:collectLog	(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Z)V
    //   22: iload_2
    //   23: ifeq +367 -> 390
    //   26: aload 4
    //   28: invokevirtual 151	java/util/ArrayList:size	()I
    //   31: ifle +359 -> 390
    //   34: ldc_w 298
    //   37: astore_3
    //   38: aload_1
    //   39: invokevirtual 302	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   42: aload_1
    //   43: invokevirtual 42	android/content/Context:getPackageName	()Ljava/lang/String;
    //   46: iconst_0
    //   47: invokevirtual 308	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   50: getfield 313	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   53: astore_1
    //   54: new 315	java/lang/StringBuilder
    //   57: dup
    //   58: new 315	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 318
    //   68: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: ldc 8
    //   83: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: astore_3
    //   87: aload_0
    //   88: invokespecial 329	com/android/vending/billing/InAppBillingService/LACK/LogCollector:collectPhoneInfo	()Ljava/lang/String;
    //   91: astore 5
    //   93: aload_3
    //   94: ldc 8
    //   96: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload 5
    //   101: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: invokevirtual 333	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   110: astore 6
    //   112: aload 6
    //   114: invokeinterface 338 1 0
    //   119: ifeq +92 -> 211
    //   122: aload 6
    //   124: invokeinterface 342 1 0
    //   129: checkcast 52	java/lang/String
    //   132: astore 7
    //   134: aload_3
    //   135: ldc 8
    //   137: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 7
    //   142: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: goto -34 -> 112
    //   149: astore_3
    //   150: getstatic 132	java/lang/System:out	Ljava/io/PrintStream;
    //   153: ldc_w 344
    //   156: invokevirtual 140	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   159: new 315	java/lang/StringBuilder
    //   162: dup
    //   163: aload_1
    //   164: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: ldc 8
    //   169: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: astore_3
    //   173: aload_3
    //   174: ldc 8
    //   176: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 5
    //   181: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: goto -80 -> 105
    //   188: aload_0
    //   189: aload 4
    //   191: aconst_null
    //   192: aconst_null
    //   193: aconst_null
    //   194: iconst_1
    //   195: invokespecial 296	com/android/vending/billing/InAppBillingService/LACK/LogCollector:collectLog	(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Z)V
    //   198: goto -176 -> 22
    //   201: astore_1
    //   202: aload_1
    //   203: invokevirtual 345	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   206: aload_3
    //   207: astore_1
    //   208: goto -154 -> 54
    //   211: aload_3
    //   212: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: astore_1
    //   216: new 174	java/io/File
    //   219: dup
    //   220: ldc_w 347
    //   223: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   226: pop
    //   227: new 174	java/io/File
    //   230: dup
    //   231: new 315	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   238: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   241: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 350
    //   247: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   256: astore_3
    //   257: new 174	java/io/File
    //   260: dup
    //   261: new 315	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   268: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   271: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 352
    //   277: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   286: invokevirtual 355	java/io/File:mkdirs	()Z
    //   289: pop
    //   290: aload_3
    //   291: invokevirtual 358	java/io/File:exists	()Z
    //   294: ifeq +8 -> 302
    //   297: aload_3
    //   298: invokevirtual 361	java/io/File:delete	()Z
    //   301: pop
    //   302: new 174	java/io/File
    //   305: dup
    //   306: new 315	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   313: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   316: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 363
    //   322: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   331: invokevirtual 358	java/io/File:exists	()Z
    //   334: ifeq +36 -> 370
    //   337: new 174	java/io/File
    //   340: dup
    //   341: new 315	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   348: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   351: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc_w 363
    //   357: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   366: invokevirtual 361	java/io/File:delete	()Z
    //   369: pop
    //   370: aload_3
    //   371: invokevirtual 366	java/io/File:createNewFile	()Z
    //   374: pop
    //   375: new 368	java/io/FileOutputStream
    //   378: dup
    //   379: aload_3
    //   380: invokespecial 371	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   383: aload_1
    //   384: invokevirtual 375	java/lang/String:getBytes	()[B
    //   387: invokevirtual 378	java/io/FileOutputStream:write	([B)V
    //   390: aload 4
    //   392: invokevirtual 151	java/util/ArrayList:size	()I
    //   395: ifle +13 -> 408
    //   398: iconst_1
    //   399: ireturn
    //   400: astore_1
    //   401: aload_1
    //   402: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   405: goto -15 -> 390
    //   408: iconst_0
    //   409: ireturn
    //   410: astore_1
    //   411: goto -10 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	LogCollector
    //   0	414	1	paramContext	Context
    //   0	414	2	paramBoolean	boolean
    //   37	98	3	localObject1	Object
    //   149	1	3	localConcurrentModificationException	java.util.ConcurrentModificationException
    //   172	208	3	localObject2	Object
    //   4	387	4	localArrayList	ArrayList
    //   91	89	5	str1	String
    //   110	13	6	localIterator	Iterator
    //   132	9	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   105	112	149	java/util/ConcurrentModificationException
    //   112	146	149	java/util/ConcurrentModificationException
    //   38	54	201	android/content/pm/PackageManager$NameNotFoundException
    //   227	257	400	java/io/IOException
    //   257	302	410	java/io/IOException
    //   302	370	410	java/io/IOException
    //   370	390	410	java/io/IOException
  }
  
  public boolean hasForceCloseHappened()
  {
    Object localObject1 = new String[1];
    localObject1[0] = "*:E";
    Object localObject2 = new ArrayList();
    if (listAppsFragment.su) {
      collectLog((List)localObject2, "time", null, (String[])localObject1, false);
    }
    while (((ArrayList)localObject2).size() > 0)
    {
      boolean bool1 = false;
      int i = 0;
      localObject1 = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          Object localObject3 = this.mPattern.matcher((CharSequence)localObject2);
          boolean bool2 = ((Matcher)localObject3).matches();
          localObject2 = this.mPrefs;
          if (bool2)
          {
            int j = 1;
            localObject3 = ((Matcher)localObject3).group(1);
            i = j;
            if (!((SharedPreferences)localObject2).getBoolean((String)localObject3, false))
            {
              bool1 = true;
              ((SharedPreferences)localObject2).edit().putBoolean((String)localObject3, true).commit();
              i = j;
              continue;
              collectLog((List)localObject2, "time", null, (String[])localObject1, true);
              break;
            }
          }
        }
      }
      if ((!bool1) && (i == 0))
      {
        System.out.println("Clear all FC logcat prefs...");
        this.mPrefs.edit().clear().commit();
      }
      return bool1;
    }
    System.out.println("Clear all FC logcat prefs...");
    this.mPrefs.edit().clear().commit();
    return false;
  }
  
  /* Error */
  public void sendLog(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 174	java/io/File
    //   3: dup
    //   4: new 315	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   14: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 350
    //   20: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: ldc_w 412
    //   33: invokestatic 418	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   36: astore 5
    //   38: new 420	net/lingala/zip4j/core/ZipFile
    //   41: dup
    //   42: new 315	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   49: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   52: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 363
    //   58: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 421	net/lingala/zip4j/core/ZipFile:<init>	(Ljava/lang/String;)V
    //   67: astore 4
    //   69: new 423	net/lingala/zip4j/model/ZipParameters
    //   72: dup
    //   73: invokespecial 424	net/lingala/zip4j/model/ZipParameters:<init>	()V
    //   76: astore 6
    //   78: aload 6
    //   80: bipush 8
    //   82: invokevirtual 428	net/lingala/zip4j/model/ZipParameters:setCompressionMethod	(I)V
    //   85: aload 6
    //   87: iconst_5
    //   88: invokevirtual 431	net/lingala/zip4j/model/ZipParameters:setCompressionLevel	(I)V
    //   91: aload 4
    //   93: aload_1
    //   94: aload 6
    //   96: invokevirtual 435	net/lingala/zip4j/core/ZipFile:addFile	(Ljava/io/File;Lnet/lingala/zip4j/model/ZipParameters;)V
    //   99: new 315	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 412
    //   109: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   115: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc_w 363
    //   121: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 418	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   130: astore_1
    //   131: aload_1
    //   132: astore 5
    //   134: ldc_w 437
    //   137: astore_1
    //   138: ldc_w 439
    //   141: invokestatic 443	com/chelpus/Utils:exists	(Ljava/lang/String;)Z
    //   144: ifeq +7 -> 151
    //   147: ldc_w 439
    //   150: astore_1
    //   151: ldc_w 445
    //   154: invokestatic 443	com/chelpus/Utils:exists	(Ljava/lang/String;)Z
    //   157: ifeq +7 -> 164
    //   160: ldc_w 445
    //   163: astore_1
    //   164: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   167: getstatic 164	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:patchAct	Lcom/android/vending/billing/InAppBillingService/LACK/patchActivity;
    //   170: ldc -90
    //   172: iconst_0
    //   173: invokevirtual 172	com/android/vending/billing/InAppBillingService/LACK/patchActivity:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   176: invokevirtual 177	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   179: invokevirtual 181	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   182: ifeq +311 -> 493
    //   185: new 315	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 447
    //   195: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: getstatic 126	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:su	Z
    //   201: invokevirtual 450	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   204: ldc 8
    //   206: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc_w 452
    //   212: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokestatic 455	com/chelpus/Utils:getCurrentRuntimeValue	()Ljava/lang/String;
    //   218: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc 8
    //   223: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 457
    //   229: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokestatic 37	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   235: invokevirtual 461	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   238: ldc_w 463
    //   241: invokestatic 469	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   244: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc 8
    //   249: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: getstatic 472	android/os/Build:BOARD	Ljava/lang/String;
    //   255: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc 8
    //   260: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: getstatic 280	android/os/Build:BRAND	Ljava/lang/String;
    //   266: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc 8
    //   271: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: getstatic 475	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   277: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc 8
    //   282: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: getstatic 478	android/os/Build:DEVICE	Ljava/lang/String;
    //   288: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc 8
    //   293: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: getstatic 481	android/os/Build:DISPLAY	Ljava/lang/String;
    //   299: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc 8
    //   304: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: getstatic 484	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   310: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc 8
    //   315: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc_w 486
    //   321: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: getstatic 489	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:version	Ljava/lang/String;
    //   327: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc 8
    //   332: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc_w 491
    //   338: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   344: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc 8
    //   349: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 493
    //   355: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_1
    //   359: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc_w 495
    //   365: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc_w 298
    //   371: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: astore_1
    //   378: aload_1
    //   379: astore 4
    //   381: invokestatic 499	java/lang/System:getenv	()Ljava/util/Map;
    //   384: invokeinterface 505 1 0
    //   389: invokeinterface 508 1 0
    //   394: astore 7
    //   396: aload_1
    //   397: astore 4
    //   399: aload_1
    //   400: astore 6
    //   402: aload 7
    //   404: invokeinterface 338 1 0
    //   409: ifeq +283 -> 692
    //   412: aload_1
    //   413: astore 4
    //   415: aload 7
    //   417: invokeinterface 342 1 0
    //   422: checkcast 510	java/util/Map$Entry
    //   425: astore 6
    //   427: aload_1
    //   428: astore 4
    //   430: new 315	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   437: aload_1
    //   438: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: ldc 8
    //   443: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload 6
    //   448: invokeinterface 513 1 0
    //   453: checkcast 52	java/lang/String
    //   456: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc_w 515
    //   462: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload 6
    //   467: invokeinterface 518 1 0
    //   472: checkcast 52	java/lang/String
    //   475: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: astore_1
    //   482: goto -86 -> 396
    //   485: astore_1
    //   486: aload_1
    //   487: invokevirtual 519	net/lingala/zip4j/exception/ZipException:printStackTrace	()V
    //   490: goto -356 -> 134
    //   493: new 315	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   500: ldc_w 447
    //   503: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: getstatic 126	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:su	Z
    //   509: invokevirtual 450	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   512: ldc 8
    //   514: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: ldc_w 452
    //   520: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokestatic 455	com/chelpus/Utils:getCurrentRuntimeValue	()Ljava/lang/String;
    //   526: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: ldc 8
    //   531: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: ldc_w 457
    //   537: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokestatic 37	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   543: invokevirtual 461	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   546: ldc_w 463
    //   549: invokestatic 469	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   552: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: ldc 8
    //   557: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: getstatic 472	android/os/Build:BOARD	Ljava/lang/String;
    //   563: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: ldc 8
    //   568: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: getstatic 280	android/os/Build:BRAND	Ljava/lang/String;
    //   574: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc 8
    //   579: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: getstatic 475	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   585: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: ldc 8
    //   590: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: getstatic 478	android/os/Build:DEVICE	Ljava/lang/String;
    //   596: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: ldc 8
    //   601: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: getstatic 481	android/os/Build:DISPLAY	Ljava/lang/String;
    //   607: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: ldc 8
    //   612: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: getstatic 484	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   618: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: ldc 8
    //   623: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: ldc_w 486
    //   629: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: getstatic 489	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:version	Ljava/lang/String;
    //   635: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: ldc 8
    //   640: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: ldc_w 491
    //   646: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   652: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: ldc 8
    //   657: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: ldc_w 493
    //   663: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_1
    //   667: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc_w 495
    //   673: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: astore_1
    //   680: goto -302 -> 378
    //   683: astore_1
    //   684: aload_1
    //   685: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   688: aload 4
    //   690: astore 6
    //   692: new 521	android/content/Intent
    //   695: dup
    //   696: ldc_w 523
    //   699: invokespecial 524	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   702: astore_1
    //   703: aload_1
    //   704: ldc_w 526
    //   707: invokevirtual 530	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   710: pop
    //   711: aload_1
    //   712: ldc_w 532
    //   715: iconst_1
    //   716: anewarray 52	java/lang/String
    //   719: dup
    //   720: iconst_0
    //   721: aload_2
    //   722: aastore
    //   723: invokevirtual 536	android/content/Intent:putExtra	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;
    //   726: pop
    //   727: aload_1
    //   728: ldc_w 538
    //   731: aload_3
    //   732: invokevirtual 541	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   735: pop
    //   736: aload_1
    //   737: ldc_w 543
    //   740: aload 6
    //   742: invokevirtual 541	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   745: pop
    //   746: new 78	java/util/ArrayList
    //   749: dup
    //   750: invokespecial 79	java/util/ArrayList:<init>	()V
    //   753: astore_2
    //   754: aload_2
    //   755: aload 5
    //   757: invokevirtual 114	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   760: pop
    //   761: new 174	java/io/File
    //   764: dup
    //   765: new 315	java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   772: getstatic 549	com/android/vending/billing/InAppBillingService/LACK/LuckyApp:instance	Landroid/content/Context;
    //   775: ldc_w 551
    //   778: iconst_2
    //   779: invokevirtual 552	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   782: invokevirtual 177	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   785: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: ldc_w 554
    //   791: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: getstatic 489	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:version	Ljava/lang/String;
    //   797: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: ldc_w 556
    //   803: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   812: astore_3
    //   813: new 174	java/io/File
    //   816: dup
    //   817: new 315	java/lang/StringBuilder
    //   820: dup
    //   821: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   824: getstatic 160	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
    //   827: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: ldc_w 554
    //   833: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: getstatic 489	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:version	Ljava/lang/String;
    //   839: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: ldc_w 556
    //   845: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   854: astore 4
    //   856: aload_3
    //   857: invokevirtual 358	java/io/File:exists	()Z
    //   860: ifeq +14 -> 874
    //   863: aload_3
    //   864: aload 4
    //   866: invokestatic 560	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   869: aload_3
    //   870: invokevirtual 361	java/io/File:delete	()Z
    //   873: pop
    //   874: aload 4
    //   876: invokevirtual 358	java/io/File:exists	()Z
    //   879: ifeq +13 -> 892
    //   882: aload_2
    //   883: aload 4
    //   885: invokestatic 564	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   888: invokevirtual 114	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   891: pop
    //   892: aload_1
    //   893: ldc_w 566
    //   896: aload_2
    //   897: invokevirtual 570	android/content/Intent:putParcelableArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   900: pop
    //   901: getstatic 164	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:patchAct	Lcom/android/vending/billing/InAppBillingService/LACK/patchActivity;
    //   904: aload_1
    //   905: ldc_w 572
    //   908: invokestatic 576	android/content/Intent:createChooser	(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;
    //   911: invokevirtual 580	com/android/vending/billing/InAppBillingService/LACK/patchActivity:startActivity	(Landroid/content/Intent;)V
    //   914: return
    //   915: astore_1
    //   916: aload_1
    //   917: invokevirtual 581	java/lang/RuntimeException:printStackTrace	()V
    //   920: return
    //   921: astore_1
    //   922: goto -788 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	925	0	this	LogCollector
    //   0	925	1	paramContext	Context
    //   0	925	2	paramString1	String
    //   0	925	3	paramString2	String
    //   0	925	4	paramString3	String
    //   36	720	5	localObject1	Object
    //   76	665	6	localObject2	Object
    //   394	22	7	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   38	131	485	net/lingala/zip4j/exception/ZipException
    //   381	396	683	java/lang/Exception
    //   402	412	683	java/lang/Exception
    //   415	427	683	java/lang/Exception
    //   430	482	683	java/lang/Exception
    //   901	914	915	java/lang/RuntimeException
    //   38	131	921	java/lang/Exception
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/LogCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */