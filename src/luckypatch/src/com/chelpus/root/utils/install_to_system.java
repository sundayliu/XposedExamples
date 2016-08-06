package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public class install_to_system
{
  public static String CPU_ABI = "";
  public static String CPU_ABI2 = "";
  public static String appfile = "/sdcard/app.apk";
  public static String datadir = "/data/data/";
  public static String pkgName;
  public static String toolsfiles = "";
  
  static
  {
    pkgName = "";
  }
  
  public static ArrayList<File> getLibs(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = toolsfiles + "/tmp/";
    File localFile = new File(toolsfiles + "/tmp/lib/");
    Utils localUtils;
    if (localFile.exists()) {
      localUtils = new Utils("");
    }
    try
    {
      localUtils.deleteFolder(localFile);
      if (!localFile.exists()) {
        new Decompress(paramFile.getAbsolutePath(), (String)localObject).unzip();
      }
      paramFile = new File(toolsfiles + "/tmp/lib");
      if (paramFile.exists())
      {
        paramFile = paramFile.listFiles();
        k = paramFile.length;
        i = 0;
        if (i < k)
        {
          localObject = paramFile[i];
          System.out.println("LuckyPatcher: directory in lib found - " + localObject);
          if ((((File)localObject).isDirectory()) && (((File)localObject).getName().equals(CPU_ABI)))
          {
            System.out.println("LuckyPatcher: - " + localObject + " " + ((File)localObject).getName() + " " + CPU_ABI);
            localObject = ((File)localObject).listFiles();
            m = localObject.length;
            j = 0;
            while (j < m)
            {
              localFile = localObject[j];
              if ((localFile.isFile()) && (localFile.toString().endsWith(".so")))
              {
                System.out.println(localFile);
                localArrayList.add(localFile);
                System.out.println("LuckyPatcher: found lib file - " + CPU_ABI + " " + localFile);
              }
              j += 1;
            }
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      int k;
      int i;
      int m;
      int j;
      for (;;)
      {
        localIOException.printStackTrace();
        continue;
        i += 1;
      }
      System.out.println(localArrayList.size());
      if (localArrayList.size() == 0)
      {
        k = paramFile.length;
        i = 0;
        while (i < k)
        {
          localObject = paramFile[i];
          if ((((File)localObject).isDirectory()) && (((File)localObject).getName().equals(CPU_ABI2)))
          {
            localObject = ((File)localObject).listFiles();
            m = localObject.length;
            j = 0;
            while (j < m)
            {
              localFile = localObject[j];
              if ((localFile.isFile()) && (localFile.getName().endsWith(".so")))
              {
                localArrayList.add(localFile);
                System.out.println("LuckyPatcher: found lib file - " + CPU_ABI2 + " " + localFile);
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 6	com/chelpus/root/utils/install_to_system$1
    //   5: dup
    //   6: invokespecial 160	com/chelpus/root/utils/install_to_system$1:<init>	()V
    //   9: invokestatic 163	com/chelpus/Utils:startRootJava	(Ljava/lang/Object;)V
    //   12: getstatic 99	java/lang/System:out	Ljava/io/PrintStream;
    //   15: aload_0
    //   16: iconst_1
    //   17: aaload
    //   18: invokevirtual 109	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: aaload
    //   24: putstatic 22	com/chelpus/root/utils/install_to_system:appfile	Ljava/lang/String;
    //   27: aload_0
    //   28: iconst_2
    //   29: aaload
    //   30: putstatic 26	com/chelpus/root/utils/install_to_system:datadir	Ljava/lang/String;
    //   33: aload_0
    //   34: iconst_3
    //   35: aaload
    //   36: putstatic 30	com/chelpus/root/utils/install_to_system:toolsfiles	Ljava/lang/String;
    //   39: aload_0
    //   40: iconst_0
    //   41: aaload
    //   42: putstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   45: aload_0
    //   46: iconst_4
    //   47: aaload
    //   48: putstatic 34	com/chelpus/root/utils/install_to_system:CPU_ABI	Ljava/lang/String;
    //   51: aload_0
    //   52: iconst_5
    //   53: aaload
    //   54: putstatic 36	com/chelpus/root/utils/install_to_system:CPU_ABI2	Ljava/lang/String;
    //   57: ldc -91
    //   59: astore_3
    //   60: aload_3
    //   61: astore_0
    //   62: new 62	java/io/File
    //   65: dup
    //   66: ldc -89
    //   68: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: invokevirtual 71	java/io/File:exists	()Z
    //   74: ifeq +23 -> 97
    //   77: aload_3
    //   78: astore_0
    //   79: new 62	java/io/File
    //   82: dup
    //   83: ldc -89
    //   85: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokevirtual 171	java/io/File:list	()[Ljava/lang/String;
    //   91: ifnull +6 -> 97
    //   94: ldc -83
    //   96: astore_0
    //   97: aload_0
    //   98: astore_3
    //   99: getstatic 179	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:api	I
    //   102: bipush 21
    //   104: if_icmplt +102 -> 206
    //   107: new 49	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   114: ldc -83
    //   116: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   122: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc -75
    //   127: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: astore_0
    //   134: aload_0
    //   135: astore_3
    //   136: new 62	java/io/File
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: invokevirtual 71	java/io/File:exists	()Z
    //   147: ifne +59 -> 206
    //   150: new 62	java/io/File
    //   153: dup
    //   154: aload_0
    //   155: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: invokevirtual 184	java/io/File:mkdirs	()Z
    //   161: pop
    //   162: iconst_3
    //   163: anewarray 117	java/lang/String
    //   166: dup
    //   167: iconst_0
    //   168: ldc -70
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: ldc -68
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: new 49	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   185: ldc -83
    //   187: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   193: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: aastore
    //   200: invokestatic 192	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   203: pop
    //   204: aload_0
    //   205: astore_3
    //   206: new 62	java/io/File
    //   209: dup
    //   210: getstatic 22	com/chelpus/root/utils/install_to_system:appfile	Ljava/lang/String;
    //   213: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   216: astore 5
    //   218: aload 5
    //   220: invokestatic 194	com/chelpus/root/utils/install_to_system:getLibs	(Ljava/io/File;)Ljava/util/ArrayList;
    //   223: astore 6
    //   225: ldc -60
    //   227: astore 4
    //   229: aload 4
    //   231: astore_0
    //   232: getstatic 179	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:api	I
    //   235: bipush 21
    //   237: if_icmplt +110 -> 347
    //   240: getstatic 34	com/chelpus/root/utils/install_to_system:CPU_ABI	Ljava/lang/String;
    //   243: invokevirtual 199	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   246: ldc -55
    //   248: invokevirtual 205	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   251: ifne +17 -> 268
    //   254: aload 4
    //   256: astore_0
    //   257: getstatic 36	com/chelpus/root/utils/install_to_system:CPU_ABI2	Ljava/lang/String;
    //   260: ldc -55
    //   262: invokevirtual 205	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   265: ifeq +30 -> 295
    //   268: new 49	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   275: ldc -83
    //   277: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   283: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc -49
    //   288: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: astore_0
    //   295: getstatic 34	com/chelpus/root/utils/install_to_system:CPU_ABI	Ljava/lang/String;
    //   298: invokevirtual 199	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   301: ldc -47
    //   303: invokevirtual 205	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   306: ifne +14 -> 320
    //   309: getstatic 36	com/chelpus/root/utils/install_to_system:CPU_ABI2	Ljava/lang/String;
    //   312: ldc -47
    //   314: invokevirtual 205	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   317: ifeq +30 -> 347
    //   320: new 49	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   327: ldc -83
    //   329: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   335: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc -45
    //   340: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: astore_0
    //   347: iload_2
    //   348: istore_1
    //   349: aload 6
    //   351: invokevirtual 150	java/util/ArrayList:size	()I
    //   354: ifle +457 -> 811
    //   357: aload 6
    //   359: invokevirtual 215	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   362: astore 4
    //   364: iload_2
    //   365: istore_1
    //   366: aload 4
    //   368: invokeinterface 220 1 0
    //   373: ifeq +438 -> 811
    //   376: aload 4
    //   378: invokeinterface 224 1 0
    //   383: checkcast 62	java/io/File
    //   386: astore 7
    //   388: new 62	java/io/File
    //   391: dup
    //   392: aload_0
    //   393: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   396: invokevirtual 71	java/io/File:exists	()Z
    //   399: ifne +62 -> 461
    //   402: new 62	java/io/File
    //   405: dup
    //   406: aload_0
    //   407: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   410: invokevirtual 184	java/io/File:mkdirs	()Z
    //   413: pop
    //   414: iconst_3
    //   415: anewarray 117	java/lang/String
    //   418: dup
    //   419: iconst_0
    //   420: ldc -70
    //   422: aastore
    //   423: dup
    //   424: iconst_1
    //   425: ldc -68
    //   427: aastore
    //   428: dup
    //   429: iconst_2
    //   430: new 49	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   437: ldc -83
    //   439: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   445: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: ldc -30
    //   450: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: aastore
    //   457: invokestatic 192	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   460: pop
    //   461: new 49	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   468: ldc -83
    //   470: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   476: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: aload_0
    //   483: ldc -68
    //   485: invokestatic 230	com/chelpus/Utils:setPermissionDir	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload 7
    //   490: new 62	java/io/File
    //   493: dup
    //   494: new 49	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   501: aload_0
    //   502: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload 7
    //   507: invokevirtual 115	java/io/File:getName	()Ljava/lang/String;
    //   510: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   519: invokestatic 234	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   522: new 49	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   529: ldc -20
    //   531: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_0
    //   535: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 7
    //   540: invokevirtual 115	java/io/File:getName	()Ljava/lang/String;
    //   543: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 239	com/chelpus/root/utils/install_to_system:run_all	(Ljava/lang/String;)V
    //   552: new 49	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   559: ldc -15
    //   561: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_0
    //   565: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload 7
    //   570: invokevirtual 115	java/io/File:getName	()Ljava/lang/String;
    //   573: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 239	com/chelpus/root/utils/install_to_system:run_all	(Ljava/lang/String;)V
    //   582: new 49	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   589: ldc -13
    //   591: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_0
    //   595: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload 7
    //   600: invokevirtual 115	java/io/File:getName	()Ljava/lang/String;
    //   603: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 239	com/chelpus/root/utils/install_to_system:run_all	(Ljava/lang/String;)V
    //   612: aload 7
    //   614: invokevirtual 247	java/io/File:length	()J
    //   617: new 62	java/io/File
    //   620: dup
    //   621: new 49	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   628: aload_0
    //   629: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: aload 7
    //   634: invokevirtual 115	java/io/File:getName	()Ljava/lang/String;
    //   637: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   646: invokevirtual 247	java/io/File:length	()J
    //   649: lcmp
    //   650: ifne +591 -> 1241
    //   653: getstatic 99	java/lang/System:out	Ljava/io/PrintStream;
    //   656: new 49	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   663: ldc -7
    //   665: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_0
    //   669: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload 7
    //   674: invokevirtual 115	java/io/File:getName	()Ljava/lang/String;
    //   677: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokevirtual 109	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   686: goto -322 -> 364
    //   689: astore_0
    //   690: getstatic 99	java/lang/System:out	Ljava/io/PrintStream;
    //   693: new 49	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   700: ldc -5
    //   702: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload_0
    //   706: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokevirtual 109	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   715: aload_0
    //   716: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   719: invokestatic 255	com/chelpus/Utils:exitFromRootJava	()V
    //   722: return
    //   723: astore_0
    //   724: aload_0
    //   725: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   728: aload_3
    //   729: astore_0
    //   730: goto -633 -> 97
    //   733: astore 4
    //   735: aload 6
    //   737: invokevirtual 215	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   740: astore 4
    //   742: aload 4
    //   744: invokeinterface 220 1 0
    //   749: ifeq +51 -> 800
    //   752: aload 4
    //   754: invokeinterface 224 1 0
    //   759: checkcast 62	java/io/File
    //   762: astore 7
    //   764: new 62	java/io/File
    //   767: dup
    //   768: new 49	java/lang/StringBuilder
    //   771: dup
    //   772: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   775: aload_0
    //   776: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload 7
    //   781: invokevirtual 115	java/io/File:getName	()Ljava/lang/String;
    //   784: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   793: invokevirtual 258	java/io/File:delete	()Z
    //   796: pop
    //   797: goto -55 -> 742
    //   800: getstatic 99	java/lang/System:out	Ljava/io/PrintStream;
    //   803: ldc_w 260
    //   806: invokevirtual 109	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   809: iconst_1
    //   810: istore_1
    //   811: iload_1
    //   812: ifne +675 -> 1487
    //   815: new 62	java/io/File
    //   818: dup
    //   819: new 49	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   826: aload_3
    //   827: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   833: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: ldc_w 262
    //   839: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   848: invokevirtual 71	java/io/File:exists	()Z
    //   851: ifeq +40 -> 891
    //   854: new 62	java/io/File
    //   857: dup
    //   858: new 49	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   865: aload_3
    //   866: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   872: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: ldc_w 262
    //   878: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   884: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   887: invokevirtual 258	java/io/File:delete	()Z
    //   890: pop
    //   891: new 49	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   898: aload_3
    //   899: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   905: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: ldc_w 264
    //   911: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   917: astore 4
    //   919: getstatic 22	com/chelpus/root/utils/install_to_system:appfile	Ljava/lang/String;
    //   922: astore 7
    //   924: getstatic 267	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
    //   927: aload 7
    //   929: aload 4
    //   931: invokestatic 271	com/chelpus/Utils:dalvikvm_copyFile	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   934: ifne +49 -> 983
    //   937: getstatic 99	java/lang/System:out	Ljava/io/PrintStream;
    //   940: ldc_w 260
    //   943: invokevirtual 109	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   946: new 62	java/io/File
    //   949: dup
    //   950: new 49	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   957: aload_3
    //   958: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   964: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: ldc_w 264
    //   970: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   979: invokevirtual 258	java/io/File:delete	()Z
    //   982: pop
    //   983: aload 5
    //   985: invokevirtual 247	java/io/File:length	()J
    //   988: new 62	java/io/File
    //   991: dup
    //   992: new 49	java/lang/StringBuilder
    //   995: dup
    //   996: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   999: aload_3
    //   1000: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   1006: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: ldc_w 264
    //   1012: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   1021: invokevirtual 247	java/io/File:length	()J
    //   1024: lcmp
    //   1025: ifne +351 -> 1376
    //   1028: new 49	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1035: ldc -20
    //   1037: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: aload_3
    //   1041: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   1047: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: ldc_w 264
    //   1053: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1059: invokestatic 239	com/chelpus/root/utils/install_to_system:run_all	(Ljava/lang/String;)V
    //   1062: new 49	java/lang/StringBuilder
    //   1065: dup
    //   1066: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1069: ldc -15
    //   1071: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload_3
    //   1075: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   1081: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: ldc_w 264
    //   1087: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokestatic 239	com/chelpus/root/utils/install_to_system:run_all	(Ljava/lang/String;)V
    //   1096: new 49	java/lang/StringBuilder
    //   1099: dup
    //   1100: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1103: ldc -13
    //   1105: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: aload_3
    //   1109: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   1115: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: ldc_w 264
    //   1121: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1127: invokestatic 239	com/chelpus/root/utils/install_to_system:run_all	(Ljava/lang/String;)V
    //   1130: new 62	java/io/File
    //   1133: dup
    //   1134: new 49	java/lang/StringBuilder
    //   1137: dup
    //   1138: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1141: getstatic 30	com/chelpus/root/utils/install_to_system:toolsfiles	Ljava/lang/String;
    //   1144: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: ldc_w 273
    //   1150: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   1159: astore_0
    //   1160: aload_0
    //   1161: invokevirtual 71	java/io/File:exists	()Z
    //   1164: ifeq +35 -> 1199
    //   1167: new 73	com/chelpus/Utils
    //   1170: dup
    //   1171: ldc 28
    //   1173: invokespecial 74	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   1176: astore 4
    //   1178: aload 4
    //   1180: aload_0
    //   1181: invokevirtual 78	com/chelpus/Utils:deleteFolder	(Ljava/io/File;)V
    //   1184: aload 4
    //   1186: new 62	java/io/File
    //   1189: dup
    //   1190: getstatic 26	com/chelpus/root/utils/install_to_system:datadir	Ljava/lang/String;
    //   1193: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   1196: invokevirtual 78	com/chelpus/Utils:deleteFolder	(Ljava/io/File;)V
    //   1199: new 49	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1206: aload_3
    //   1207: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   1213: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: ldc_w 264
    //   1219: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1225: invokestatic 277	com/chelpus/Utils:getFileDalvikCache	(Ljava/lang/String;)Ljava/io/File;
    //   1228: astore_0
    //   1229: aload_0
    //   1230: ifnull -511 -> 719
    //   1233: aload_0
    //   1234: invokevirtual 258	java/io/File:delete	()Z
    //   1237: pop
    //   1238: goto -519 -> 719
    //   1241: aload 6
    //   1243: invokevirtual 215	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1246: astore 4
    //   1248: aload 4
    //   1250: invokeinterface 220 1 0
    //   1255: ifeq +51 -> 1306
    //   1258: aload 4
    //   1260: invokeinterface 224 1 0
    //   1265: checkcast 62	java/io/File
    //   1268: astore 7
    //   1270: new 62	java/io/File
    //   1273: dup
    //   1274: new 49	java/lang/StringBuilder
    //   1277: dup
    //   1278: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1281: aload_0
    //   1282: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: aload 7
    //   1287: invokevirtual 115	java/io/File:getName	()Ljava/lang/String;
    //   1290: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   1299: invokevirtual 258	java/io/File:delete	()Z
    //   1302: pop
    //   1303: goto -55 -> 1248
    //   1306: getstatic 99	java/lang/System:out	Ljava/io/PrintStream;
    //   1309: ldc_w 260
    //   1312: invokevirtual 109	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1315: iconst_1
    //   1316: istore_1
    //   1317: goto -506 -> 811
    //   1320: astore 4
    //   1322: getstatic 99	java/lang/System:out	Ljava/io/PrintStream;
    //   1325: ldc_w 260
    //   1328: invokevirtual 109	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1331: new 62	java/io/File
    //   1334: dup
    //   1335: new 49	java/lang/StringBuilder
    //   1338: dup
    //   1339: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1342: aload_3
    //   1343: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   1349: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: ldc_w 264
    //   1355: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1361: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   1364: invokevirtual 258	java/io/File:delete	()Z
    //   1367: pop
    //   1368: aload 4
    //   1370: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   1373: goto -390 -> 983
    //   1376: new 62	java/io/File
    //   1379: dup
    //   1380: new 49	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1387: aload_3
    //   1388: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   1394: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: ldc_w 264
    //   1400: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   1409: invokevirtual 258	java/io/File:delete	()Z
    //   1412: pop
    //   1413: getstatic 99	java/lang/System:out	Ljava/io/PrintStream;
    //   1416: ldc_w 260
    //   1419: invokevirtual 109	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1422: aload 6
    //   1424: invokevirtual 215	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1427: astore 4
    //   1429: aload 4
    //   1431: invokeinterface 220 1 0
    //   1436: ifeq -306 -> 1130
    //   1439: aload 4
    //   1441: invokeinterface 224 1 0
    //   1446: checkcast 62	java/io/File
    //   1449: astore 5
    //   1451: new 62	java/io/File
    //   1454: dup
    //   1455: new 49	java/lang/StringBuilder
    //   1458: dup
    //   1459: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1462: aload_0
    //   1463: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: aload 5
    //   1468: invokevirtual 115	java/io/File:getName	()Ljava/lang/String;
    //   1471: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1477: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   1480: invokevirtual 258	java/io/File:delete	()Z
    //   1483: pop
    //   1484: goto -55 -> 1429
    //   1487: new 62	java/io/File
    //   1490: dup
    //   1491: new 49	java/lang/StringBuilder
    //   1494: dup
    //   1495: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1498: aload_3
    //   1499: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: getstatic 32	com/chelpus/root/utils/install_to_system:pkgName	Ljava/lang/String;
    //   1505: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: ldc_w 264
    //   1511: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1517: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   1520: invokevirtual 258	java/io/File:delete	()Z
    //   1523: pop
    //   1524: goto -394 -> 1130
    //   1527: astore_0
    //   1528: aload_0
    //   1529: invokevirtual 146	java/io/IOException:printStackTrace	()V
    //   1532: goto -333 -> 1199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1535	0	paramArrayOfString	String[]
    //   348	969	1	i	int
    //   1	364	2	j	int
    //   59	1440	3	localObject1	Object
    //   227	150	4	localObject2	Object
    //   733	1	4	localException1	Exception
    //   740	519	4	localObject3	Object
    //   1320	49	4	localException2	Exception
    //   1427	13	4	localIterator	Iterator
    //   216	1251	5	localFile	File
    //   223	1200	6	localArrayList	ArrayList
    //   386	900	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	57	689	java/lang/Exception
    //   99	134	689	java/lang/Exception
    //   136	204	689	java/lang/Exception
    //   206	225	689	java/lang/Exception
    //   232	254	689	java/lang/Exception
    //   257	268	689	java/lang/Exception
    //   268	295	689	java/lang/Exception
    //   295	309	689	java/lang/Exception
    //   309	320	689	java/lang/Exception
    //   320	347	689	java/lang/Exception
    //   349	364	689	java/lang/Exception
    //   366	388	689	java/lang/Exception
    //   522	686	689	java/lang/Exception
    //   724	728	689	java/lang/Exception
    //   735	742	689	java/lang/Exception
    //   742	797	689	java/lang/Exception
    //   800	809	689	java/lang/Exception
    //   983	1130	689	java/lang/Exception
    //   1130	1178	689	java/lang/Exception
    //   1178	1199	689	java/lang/Exception
    //   1199	1229	689	java/lang/Exception
    //   1233	1238	689	java/lang/Exception
    //   1241	1248	689	java/lang/Exception
    //   1248	1303	689	java/lang/Exception
    //   1306	1315	689	java/lang/Exception
    //   1322	1373	689	java/lang/Exception
    //   1376	1429	689	java/lang/Exception
    //   1429	1484	689	java/lang/Exception
    //   1487	1524	689	java/lang/Exception
    //   1528	1532	689	java/lang/Exception
    //   62	77	723	java/lang/Exception
    //   79	94	723	java/lang/Exception
    //   388	461	733	java/lang/Exception
    //   461	522	733	java/lang/Exception
    //   815	891	1320	java/lang/Exception
    //   891	983	1320	java/lang/Exception
    //   1178	1199	1527	java/io/IOException
  }
  
  /* Error */
  private static void run_all(String paramString)
  {
    // Byte code:
    //   0: new 117	java/lang/String
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 283	java/lang/String:getBytes	()[B
    //   8: ldc_w 285
    //   11: invokespecial 288	java/lang/String:<init>	([BLjava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: invokestatic 294	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   20: new 49	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   27: aload_0
    //   28: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 296
    //   34: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 300	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 305	java/lang/Process:waitFor	()I
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 308	java/lang/Process:destroy	()V
    //   53: invokestatic 294	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   56: new 49	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 310
    //   66: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 296
    //   76: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 300	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 305	java/lang/Process:waitFor	()I
    //   90: pop
    //   91: aload_1
    //   92: invokevirtual 308	java/lang/Process:destroy	()V
    //   95: invokestatic 294	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   98: new 49	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 312
    //   108: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 296
    //   118: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokevirtual 300	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 305	java/lang/Process:waitFor	()I
    //   132: pop
    //   133: aload_1
    //   134: invokevirtual 308	java/lang/Process:destroy	()V
    //   137: invokestatic 294	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   140: new 49	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 314
    //   150: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 296
    //   160: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokevirtual 300	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 305	java/lang/Process:waitFor	()I
    //   174: pop
    //   175: aload_1
    //   176: invokevirtual 308	java/lang/Process:destroy	()V
    //   179: invokestatic 294	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   182: new 49	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   189: getstatic 30	com/chelpus/root/utils/install_to_system:toolsfiles	Ljava/lang/String;
    //   192: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 316
    //   198: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc_w 296
    //   208: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokevirtual 300	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 305	java/lang/Process:waitFor	()I
    //   222: pop
    //   223: aload_0
    //   224: invokevirtual 308	java/lang/Process:destroy	()V
    //   227: return
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual 317	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   233: goto -216 -> 17
    //   236: astore_0
    //   237: return
    //   238: astore_1
    //   239: goto -60 -> 179
    //   242: astore_1
    //   243: goto -106 -> 137
    //   246: astore_1
    //   247: goto -152 -> 95
    //   250: astore_1
    //   251: goto -198 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramString	String
    //   14	162	1	localObject	Object
    //   228	2	1	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   238	1	1	localException1	Exception
    //   242	1	1	localException2	Exception
    //   246	1	1	localException3	Exception
    //   250	1	1	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	228	java/io/UnsupportedEncodingException
    //   179	227	236	java/lang/Exception
    //   137	179	238	java/lang/Exception
    //   95	137	242	java/lang/Exception
    //   53	95	246	java/lang/Exception
    //   17	53	250	java/lang/Exception
  }
  
  public static class Decompress
  {
    private String _location;
    private String _zipFile;
    
    public Decompress(String paramString1, String paramString2)
    {
      this._zipFile = paramString1;
      this._location = paramString2;
      _dirChecker("");
    }
    
    private void _dirChecker(String paramString)
    {
      paramString = new File(this._location + paramString);
      if (!paramString.isDirectory()) {
        paramString.mkdirs();
      }
    }
    
    public void unzip()
    {
      try
      {
        Object localObject4 = new FileInputStream(this._zipFile);
        ZipInputStream localZipInputStream = new ZipInputStream((InputStream)localObject4);
        for (;;)
        {
          ZipEntry localZipEntry = localZipInputStream.getNextEntry();
          if (localZipEntry != null) {
            if (localZipEntry.isDirectory())
            {
              _dirChecker(localZipEntry.getName());
              continue;
            }
          }
          try
          {
            localZipFile = new ZipFile(this._zipFile);
            localObject3 = localZipFile.getFileHeaders().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (FileHeader)((Iterator)localObject3).next();
              if ((((FileHeader)localObject4).getFileName().endsWith(".so")) && (!((FileHeader)localObject4).getFileName().contains("libjnigraphics.so")))
              {
                System.out.println(((FileHeader)localObject4).getFileName());
                localZipFile.extractFile(((FileHeader)localObject4).getFileName(), this._location);
              }
            }
          }
          catch (ZipException localZipException)
          {
            localZipException.printStackTrace();
            return;
            if ((localZipEntry.getName().endsWith(".so")) && (!localZipEntry.getName().contains("libjnigraphics.so")))
            {
              arrayOfString = localZipEntry.getName().split("\\/+");
              localObject1 = "";
              i = 0;
              if (i < arrayOfString.length - 1)
              {
                localObject3 = localObject1;
                if (!arrayOfString[i].equals("")) {
                  localObject3 = (String)localObject1 + "/" + arrayOfString[i];
                }
              }
              else
              {
                _dirChecker((String)localObject1);
                localObject1 = new FileOutputStream(this._location + localZipEntry.getName());
                localObject3 = new byte['Ѐ'];
                for (;;)
                {
                  i = localZipInputStream.read((byte[])localObject3);
                  if (i == -1) {
                    break;
                  }
                  ((FileOutputStream)localObject1).write((byte[])localObject3, 0, i);
                }
                localZipInputStream.closeEntry();
                ((FileOutputStream)localObject1).close();
                continue;
                localZipInputStream.close();
                ((FileInputStream)localObject4).close();
                return;
              }
            }
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            return;
          }
        }
      }
      catch (Exception localException1)
      {
        System.out.println("Decompressunzip " + localException1);
        localException1.printStackTrace();
      }
      for (;;)
      {
        ZipFile localZipFile;
        Object localObject3;
        String[] arrayOfString;
        Object localObject1;
        int i;
        i += 1;
        Object localObject2 = localObject3;
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/install_to_system.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */