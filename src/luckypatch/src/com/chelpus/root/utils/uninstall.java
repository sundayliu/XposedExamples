package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class uninstall
{
  public static String datadir;
  public static String dirapp = "/data/app/";
  public static boolean odexpatch = false;
  public static boolean system;
  
  static
  {
    datadir = "/data/data/";
    system = false;
  }
  
  /* Error */
  public static ArrayList<String> getLibs(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 6
    //   13: new 40	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 41	java/util/ArrayList:<init>	()V
    //   20: astore 7
    //   22: new 43	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_1
    //   31: new 48	java/util/zip/ZipInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 51	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 55	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   44: astore_3
    //   45: aload_3
    //   46: ifnull +107 -> 153
    //   49: aload_3
    //   50: invokevirtual 61	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   53: ldc 63
    //   55: invokevirtual 69	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   58: ifeq +87 -> 145
    //   61: aload_3
    //   62: invokevirtual 61	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   65: ldc 71
    //   67: invokevirtual 75	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore_3
    //   71: aload_3
    //   72: aload_3
    //   73: arraylength
    //   74: iconst_1
    //   75: isub
    //   76: aaload
    //   77: astore_3
    //   78: aload 7
    //   80: invokevirtual 79	java/util/ArrayList:isEmpty	()Z
    //   83: ifeq +28 -> 111
    //   86: aload_3
    //   87: ldc 81
    //   89: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifne +19 -> 111
    //   95: aload_3
    //   96: ldc 87
    //   98: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifne +10 -> 111
    //   104: aload 7
    //   106: aload_3
    //   107: invokevirtual 94	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: aload 7
    //   113: aload_3
    //   114: invokevirtual 96	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   117: ifne +28 -> 145
    //   120: aload_3
    //   121: ldc 81
    //   123: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   126: ifne +19 -> 145
    //   129: aload_3
    //   130: ldc 87
    //   132: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   135: ifne +10 -> 145
    //   138: aload 7
    //   140: aload_3
    //   141: invokevirtual 94	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   144: pop
    //   145: aload_2
    //   146: invokevirtual 55	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   149: astore_3
    //   150: goto -105 -> 45
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 99	java/util/zip/ZipInputStream:close	()V
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 100	java/io/FileInputStream:close	()V
    //   169: aload 7
    //   171: areturn
    //   172: astore_1
    //   173: aload 6
    //   175: astore_1
    //   176: aload_1
    //   177: astore_2
    //   178: aload 4
    //   180: astore_3
    //   181: new 102	net/lingala/zip4j/core/ZipFile
    //   184: dup
    //   185: aload_0
    //   186: invokespecial 103	net/lingala/zip4j/core/ZipFile:<init>	(Ljava/io/File;)V
    //   189: invokevirtual 107	net/lingala/zip4j/core/ZipFile:getFileHeaders	()Ljava/util/List;
    //   192: invokeinterface 113 1 0
    //   197: astore_0
    //   198: aload_1
    //   199: astore_2
    //   200: aload 4
    //   202: astore_3
    //   203: aload_0
    //   204: invokeinterface 118 1 0
    //   209: ifeq +212 -> 421
    //   212: aload_1
    //   213: astore_2
    //   214: aload 4
    //   216: astore_3
    //   217: aload_0
    //   218: invokeinterface 122 1 0
    //   223: checkcast 124	net/lingala/zip4j/model/FileHeader
    //   226: astore 5
    //   228: aload_1
    //   229: astore_2
    //   230: aload 4
    //   232: astore_3
    //   233: aload 5
    //   235: invokevirtual 127	net/lingala/zip4j/model/FileHeader:getFileName	()Ljava/lang/String;
    //   238: ldc -127
    //   240: invokevirtual 132	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   243: ifeq -45 -> 198
    //   246: aload_1
    //   247: astore_2
    //   248: aload 4
    //   250: astore_3
    //   251: getstatic 138	java/lang/System:out	Ljava/io/PrintStream;
    //   254: aload 5
    //   256: invokevirtual 127	net/lingala/zip4j/model/FileHeader:getFileName	()Ljava/lang/String;
    //   259: invokevirtual 144	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   262: aload_1
    //   263: astore_2
    //   264: aload 4
    //   266: astore_3
    //   267: aload 5
    //   269: invokevirtual 127	net/lingala/zip4j/model/FileHeader:getFileName	()Ljava/lang/String;
    //   272: ldc 71
    //   274: invokevirtual 75	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   277: astore 5
    //   279: aload_1
    //   280: astore_2
    //   281: aload 4
    //   283: astore_3
    //   284: aload 5
    //   286: aload 5
    //   288: arraylength
    //   289: iconst_1
    //   290: isub
    //   291: aaload
    //   292: astore 5
    //   294: aload_1
    //   295: astore_2
    //   296: aload 4
    //   298: astore_3
    //   299: aload 7
    //   301: invokevirtual 79	java/util/ArrayList:isEmpty	()Z
    //   304: ifeq +46 -> 350
    //   307: aload_1
    //   308: astore_2
    //   309: aload 4
    //   311: astore_3
    //   312: aload 5
    //   314: ldc 81
    //   316: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   319: ifne +31 -> 350
    //   322: aload_1
    //   323: astore_2
    //   324: aload 4
    //   326: astore_3
    //   327: aload 5
    //   329: ldc 87
    //   331: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   334: ifne +16 -> 350
    //   337: aload_1
    //   338: astore_2
    //   339: aload 4
    //   341: astore_3
    //   342: aload 7
    //   344: aload 5
    //   346: invokevirtual 94	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   349: pop
    //   350: aload_1
    //   351: astore_2
    //   352: aload 4
    //   354: astore_3
    //   355: aload 7
    //   357: aload 5
    //   359: invokevirtual 96	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   362: ifne -164 -> 198
    //   365: aload_1
    //   366: astore_2
    //   367: aload 4
    //   369: astore_3
    //   370: aload 5
    //   372: ldc 81
    //   374: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   377: ifne -179 -> 198
    //   380: aload_1
    //   381: astore_2
    //   382: aload 4
    //   384: astore_3
    //   385: aload 5
    //   387: ldc 87
    //   389: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   392: ifne -194 -> 198
    //   395: aload_1
    //   396: astore_2
    //   397: aload 4
    //   399: astore_3
    //   400: aload 7
    //   402: aload 5
    //   404: invokevirtual 94	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   407: pop
    //   408: goto -210 -> 198
    //   411: astore_0
    //   412: aload_1
    //   413: astore_2
    //   414: aload 4
    //   416: astore_3
    //   417: aload_0
    //   418: invokevirtual 147	net/lingala/zip4j/exception/ZipException:printStackTrace	()V
    //   421: aload 4
    //   423: ifnull +8 -> 431
    //   426: aload 4
    //   428: invokevirtual 99	java/util/zip/ZipInputStream:close	()V
    //   431: aload_1
    //   432: ifnull +7 -> 439
    //   435: aload_1
    //   436: invokevirtual 100	java/io/FileInputStream:close	()V
    //   439: aload 7
    //   441: areturn
    //   442: astore_0
    //   443: aload_1
    //   444: astore_2
    //   445: aload 4
    //   447: astore_3
    //   448: aload_0
    //   449: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   452: goto -31 -> 421
    //   455: astore_0
    //   456: aload_3
    //   457: ifnull +7 -> 464
    //   460: aload_3
    //   461: invokevirtual 99	java/util/zip/ZipInputStream:close	()V
    //   464: aload_2
    //   465: ifnull +7 -> 472
    //   468: aload_2
    //   469: invokevirtual 100	java/io/FileInputStream:close	()V
    //   472: aload_0
    //   473: athrow
    //   474: astore_0
    //   475: goto -314 -> 161
    //   478: astore_0
    //   479: goto -310 -> 169
    //   482: astore_0
    //   483: goto -52 -> 431
    //   486: astore_0
    //   487: goto -48 -> 439
    //   490: astore_1
    //   491: goto -27 -> 464
    //   494: astore_1
    //   495: goto -23 -> 472
    //   498: astore_0
    //   499: aload_1
    //   500: astore_2
    //   501: aload 5
    //   503: astore_3
    //   504: goto -48 -> 456
    //   507: astore_0
    //   508: aload_2
    //   509: astore_3
    //   510: aload_1
    //   511: astore_2
    //   512: goto -56 -> 456
    //   515: astore_2
    //   516: goto -340 -> 176
    //   519: astore_3
    //   520: aload_2
    //   521: astore 4
    //   523: goto -347 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	paramFile	File
    //   30	136	1	localFileInputStream	java.io.FileInputStream
    //   172	1	1	localIOException1	java.io.IOException
    //   175	269	1	localObject1	Object
    //   490	1	1	localIOException2	java.io.IOException
    //   494	17	1	localIOException3	java.io.IOException
    //   9	503	2	localObject2	Object
    //   515	6	2	localIOException4	java.io.IOException
    //   1	509	3	localObject3	Object
    //   519	1	3	localIOException5	java.io.IOException
    //   6	516	4	localObject4	Object
    //   3	499	5	localObject5	Object
    //   11	163	6	localObject6	Object
    //   20	420	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   22	31	172	java/io/IOException
    //   181	198	411	net/lingala/zip4j/exception/ZipException
    //   203	212	411	net/lingala/zip4j/exception/ZipException
    //   217	228	411	net/lingala/zip4j/exception/ZipException
    //   233	246	411	net/lingala/zip4j/exception/ZipException
    //   251	262	411	net/lingala/zip4j/exception/ZipException
    //   267	279	411	net/lingala/zip4j/exception/ZipException
    //   284	294	411	net/lingala/zip4j/exception/ZipException
    //   299	307	411	net/lingala/zip4j/exception/ZipException
    //   312	322	411	net/lingala/zip4j/exception/ZipException
    //   327	337	411	net/lingala/zip4j/exception/ZipException
    //   342	350	411	net/lingala/zip4j/exception/ZipException
    //   355	365	411	net/lingala/zip4j/exception/ZipException
    //   370	380	411	net/lingala/zip4j/exception/ZipException
    //   385	395	411	net/lingala/zip4j/exception/ZipException
    //   400	408	411	net/lingala/zip4j/exception/ZipException
    //   181	198	442	java/lang/Exception
    //   203	212	442	java/lang/Exception
    //   217	228	442	java/lang/Exception
    //   233	246	442	java/lang/Exception
    //   251	262	442	java/lang/Exception
    //   267	279	442	java/lang/Exception
    //   284	294	442	java/lang/Exception
    //   299	307	442	java/lang/Exception
    //   312	322	442	java/lang/Exception
    //   327	337	442	java/lang/Exception
    //   342	350	442	java/lang/Exception
    //   355	365	442	java/lang/Exception
    //   370	380	442	java/lang/Exception
    //   385	395	442	java/lang/Exception
    //   400	408	442	java/lang/Exception
    //   22	31	455	finally
    //   181	198	455	finally
    //   203	212	455	finally
    //   217	228	455	finally
    //   233	246	455	finally
    //   251	262	455	finally
    //   267	279	455	finally
    //   284	294	455	finally
    //   299	307	455	finally
    //   312	322	455	finally
    //   327	337	455	finally
    //   342	350	455	finally
    //   355	365	455	finally
    //   370	380	455	finally
    //   385	395	455	finally
    //   400	408	455	finally
    //   417	421	455	finally
    //   448	452	455	finally
    //   157	161	474	java/io/IOException
    //   165	169	478	java/io/IOException
    //   426	431	482	java/io/IOException
    //   435	439	486	java/io/IOException
    //   460	464	490	java/io/IOException
    //   468	472	494	java/io/IOException
    //   31	40	498	finally
    //   40	45	507	finally
    //   49	111	507	finally
    //   111	145	507	finally
    //   145	150	507	finally
    //   31	40	515	java/io/IOException
    //   40	45	519	java/io/IOException
    //   49	111	519	java/io/IOException
    //   111	145	519	java/io/IOException
    //   145	150	519	java/io/IOException
  }
  
  public static void main(String[] paramArrayOfString)
  {
    Object localObject1;
    try
    {
      Utils.startRootJava(new Object() {});
      dirapp = paramArrayOfString[1];
      system = true;
      datadir = paramArrayOfString[2];
      localObject1 = new File(dirapp);
      paramArrayOfString = new File(Utils.getPlaceForOdex(dirapp, true));
      System.out.println("Start getLibs!");
      localObject1 = getLibs((File)localObject1);
      System.out.println("Start delete lib!");
      if (!((ArrayList)localObject1).isEmpty())
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = new File("/system/lib/" + (String)localObject2);
          if (((File)localObject2).exists())
          {
            ((File)localObject2).delete();
            continue;
            Utils.exitFromRootJava();
          }
        }
      }
    }
    catch (Exception paramArrayOfString)
    {
      System.out.println("LuckyPatcher Error uninstall: " + paramArrayOfString);
      paramArrayOfString.printStackTrace();
    }
    for (;;)
    {
      return;
      System.out.println("Start delete data directory!");
      localObject1 = new Utils("uninstall system");
      try
      {
        System.out.println("Start delete dir!");
        ((Utils)localObject1).deleteFolder(new File(datadir));
        ((Utils)localObject1).deleteFolder(new File(datadir.replace("/data/data/", "/dbdata/databases/")));
        System.out.println("Start delete dc!");
        try
        {
          localObject1 = Utils.getFileDalvikCache(dirapp);
          if (localObject1 == null) {
            break label409;
          }
          ((File)localObject1).delete();
          System.out.println("Dalvik-cache " + localObject1 + " deleted.");
          System.out.println("Start delete odex.");
          if (paramArrayOfString.exists()) {
            paramArrayOfString.delete();
          }
        }
        catch (Exception paramArrayOfString)
        {
          for (;;)
          {
            System.out.println("Error: Exception e" + paramArrayOfString.toString());
            paramArrayOfString.printStackTrace();
          }
        }
        System.out.println("Start delete apk!");
        paramArrayOfString = new File(dirapp);
        if (!paramArrayOfString.exists()) {
          continue;
        }
        paramArrayOfString.delete();
        System.out.println("Delete apk:" + dirapp);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          System.out.println("LuckyPatcher Error uninstall: " + localException);
          localException.printStackTrace();
          continue;
          label409:
          System.out.println("dalvik-cache not found.");
        }
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/uninstall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */