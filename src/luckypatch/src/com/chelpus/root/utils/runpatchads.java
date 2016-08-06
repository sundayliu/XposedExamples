package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.MappedByteBuffer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class runpatchads
{
  private static boolean ART;
  public static String AdsBlockFile = "";
  public static String appdir;
  public static ArrayList<File> classesFiles = new ArrayList();
  private static boolean copyDC;
  private static boolean createAPK = false;
  public static File crkapk;
  private static boolean dependencies;
  public static String dir;
  public static String dir2;
  public static String dirapp;
  private static boolean fileblock = true;
  public static ArrayList<File> filestopatch;
  private static boolean full_offline;
  private static boolean pattern1 = true;
  private static boolean pattern2 = true;
  private static boolean pattern3 = true;
  private static boolean pattern4 = true;
  private static boolean pattern5 = true;
  private static boolean pattern6 = true;
  public static PrintStream print;
  public static String result;
  public static String sddir;
  public static byte[][] sites;
  public static boolean system;
  public static String uid;
  
  static
  {
    dependencies = true;
    full_offline = true;
    copyDC = false;
    ART = false;
    dirapp = "/data/app/";
    system = false;
    uid = "";
    dir = "/sdcard/";
    dir2 = "/sdcard/";
    filestopatch = null;
    sddir = "/sdcard/";
    appdir = "/sdcard/";
  }
  
  public static boolean byteverify(MappedByteBuffer paramMappedByteBuffer, int paramInt, byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, String paramString, boolean paramBoolean)
  {
    if ((paramByte == paramArrayOfByte1[0]) && (paramBoolean))
    {
      if (paramArrayOfByte4[0] == 0) {
        paramArrayOfByte3[0] = paramByte;
      }
      int i = 1;
      paramMappedByteBuffer.position(paramInt + 1);
      for (paramByte = paramMappedByteBuffer.get(); (paramByte == paramArrayOfByte1[i]) || (paramArrayOfByte2[i] == 1); paramByte = paramMappedByteBuffer.get())
      {
        if (paramArrayOfByte4[i] == 0) {
          paramArrayOfByte3[i] = paramByte;
        }
        i += 1;
        if (i == paramArrayOfByte1.length)
        {
          paramMappedByteBuffer.position(paramInt);
          paramMappedByteBuffer.put(paramArrayOfByte3);
          paramMappedByteBuffer.force();
          Utils.sendFromRoot(paramString);
          return true;
        }
      }
      paramMappedByteBuffer.position(paramInt + 1);
    }
    return false;
  }
  
  private static final void calcChecksum(byte[] paramArrayOfByte, int paramInt)
  {
    Adler32 localAdler32 = new Adler32();
    localAdler32.update(paramArrayOfByte, 12, paramArrayOfByte.length - (paramInt + 12));
    int i = (int)localAdler32.getValue();
    paramArrayOfByte[(paramInt + 8)] = ((byte)i);
    paramArrayOfByte[(paramInt + 9)] = ((byte)(i >> 8));
    paramArrayOfByte[(paramInt + 10)] = ((byte)(i >> 16));
    paramArrayOfByte[(paramInt + 11)] = ((byte)(i >> 24));
  }
  
  private static final void calcSignature(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte, 32, paramArrayOfByte.length - (paramInt + 32));
      try
      {
        paramInt = localMessageDigest.digest(paramArrayOfByte, paramInt + 12, 20);
        if (paramInt != 20) {
          throw new RuntimeException("unexpected digest write:" + paramInt + "bytes");
        }
      }
      catch (DigestException paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
      return;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public static void clearTemp()
  {
    File localFile1;
    do
    {
      try
      {
        Object localObject = new File(dir + "/AndroidManifest.xml");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if ((classesFiles != null) && (classesFiles.size() > 0))
        {
          localObject = classesFiles.iterator();
          while (((Iterator)localObject).hasNext())
          {
            File localFile2 = (File)((Iterator)localObject).next();
            if (localFile2.exists()) {
              localFile2.delete();
            }
          }
        }
        localFile1 = new File(dir + "/classes.dex");
      }
      catch (Exception localException)
      {
        Utils.sendFromRoot("" + localException.toString());
        return;
      }
      if (localFile1.exists()) {
        localFile1.delete();
      }
      localFile1 = new File(dir + "/classes.dex.apk");
    } while (!localFile1.exists());
    localFile1.delete();
  }
  
  public static void clearTempSD()
  {
    try
    {
      File localFile = new File(sddir + "/Modified/classes.dex.apk");
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      Utils.sendFromRoot("" + localException.toString());
    }
  }
  
  public static void fixadler(File paramFile)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[localFileInputStream.available()];
      localFileInputStream.read(arrayOfByte);
      calcSignature(arrayOfByte, 0);
      calcChecksum(arrayOfByte, 0);
      localFileInputStream.close();
      paramFile = new FileOutputStream(paramFile);
      paramFile.write(arrayOfByte);
      paramFile.close();
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 260	com/android/vending/billing/InAppBillingService/LACK/LogOutputStream
    //   3: dup
    //   4: ldc_w 262
    //   7: invokespecial 263	com/android/vending/billing/InAppBillingService/LACK/LogOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 11
    //   12: new 265	java/io/PrintStream
    //   15: dup
    //   16: aload 11
    //   18: invokespecial 268	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   21: putstatic 270	com/chelpus/root/utils/runpatchads:print	Ljava/io/PrintStream;
    //   24: getstatic 270	com/chelpus/root/utils/runpatchads:print	Ljava/io/PrintStream;
    //   27: ldc_w 272
    //   30: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   33: new 6	com/chelpus/root/utils/runpatchads$1
    //   36: dup
    //   37: invokespecial 276	com/chelpus/root/utils/runpatchads$1:<init>	()V
    //   40: invokestatic 280	com/chelpus/Utils:startRootJava	(Ljava/lang/Object;)V
    //   43: ldc_w 272
    //   46: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   49: pop
    //   50: aload_0
    //   51: iconst_0
    //   52: aaload
    //   53: invokestatic 283	com/chelpus/Utils:kill	(Ljava/lang/String;)V
    //   56: new 91	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 94	java/util/ArrayList:<init>	()V
    //   63: astore 12
    //   65: iconst_1
    //   66: putstatic 45	com/chelpus/root/utils/runpatchads:fileblock	Z
    //   69: iconst_1
    //   70: putstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   73: iconst_1
    //   74: putstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   77: iconst_1
    //   78: putstatic 51	com/chelpus/root/utils/runpatchads:pattern3	Z
    //   81: iconst_1
    //   82: putstatic 53	com/chelpus/root/utils/runpatchads:pattern4	Z
    //   85: iconst_1
    //   86: putstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   89: iconst_1
    //   90: putstatic 57	com/chelpus/root/utils/runpatchads:pattern6	Z
    //   93: iconst_1
    //   94: putstatic 59	com/chelpus/root/utils/runpatchads:dependencies	Z
    //   97: iconst_1
    //   98: putstatic 61	com/chelpus/root/utils/runpatchads:full_offline	Z
    //   101: new 91	java/util/ArrayList
    //   104: dup
    //   105: invokespecial 94	java/util/ArrayList:<init>	()V
    //   108: putstatic 83	com/chelpus/root/utils/runpatchads:filestopatch	Ljava/util/ArrayList;
    //   111: new 186	java/io/File
    //   114: dup
    //   115: aload_0
    //   116: iconst_3
    //   117: aaload
    //   118: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 287	java/io/File:listFiles	()[Ljava/io/File;
    //   124: astore 13
    //   126: aload 13
    //   128: arraylength
    //   129: istore 4
    //   131: iconst_0
    //   132: istore_3
    //   133: iload_3
    //   134: iload 4
    //   136: if_icmpge +79 -> 215
    //   139: aload 13
    //   141: iload_3
    //   142: aaload
    //   143: astore 14
    //   145: aload 14
    //   147: invokevirtual 290	java/io/File:isFile	()Z
    //   150: ifeq +51 -> 201
    //   153: aload 14
    //   155: invokevirtual 293	java/io/File:getName	()Ljava/lang/String;
    //   158: ldc_w 295
    //   161: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifne +37 -> 201
    //   167: aload 14
    //   169: invokevirtual 293	java/io/File:getName	()Ljava/lang/String;
    //   172: ldc_w 303
    //   175: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   178: ifne +23 -> 201
    //   181: aload 14
    //   183: invokevirtual 293	java/io/File:getName	()Ljava/lang/String;
    //   186: ldc_w 305
    //   189: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: ifne +9 -> 201
    //   195: aload 14
    //   197: invokevirtual 196	java/io/File:delete	()Z
    //   200: pop
    //   201: iload_3
    //   202: iconst_1
    //   203: iadd
    //   204: istore_3
    //   205: goto -72 -> 133
    //   208: astore 13
    //   210: aload 13
    //   212: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   215: aload_0
    //   216: iconst_1
    //   217: aaload
    //   218: ldc_w 307
    //   221: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   224: ifne +7 -> 231
    //   227: iconst_0
    //   228: putstatic 45	com/chelpus/root/utils/runpatchads:fileblock	Z
    //   231: aload_0
    //   232: iconst_1
    //   233: aaload
    //   234: ldc_w 312
    //   237: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   240: ifne +7 -> 247
    //   243: iconst_0
    //   244: putstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   247: aload_0
    //   248: iconst_1
    //   249: aaload
    //   250: ldc_w 313
    //   253: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   256: ifne +7 -> 263
    //   259: iconst_0
    //   260: putstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   263: aload_0
    //   264: iconst_1
    //   265: aaload
    //   266: ldc_w 314
    //   269: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   272: ifne +7 -> 279
    //   275: iconst_0
    //   276: putstatic 51	com/chelpus/root/utils/runpatchads:pattern3	Z
    //   279: aload_0
    //   280: iconst_1
    //   281: aaload
    //   282: ldc_w 315
    //   285: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   288: ifne +7 -> 295
    //   291: iconst_0
    //   292: putstatic 53	com/chelpus/root/utils/runpatchads:pattern4	Z
    //   295: aload_0
    //   296: iconst_1
    //   297: aaload
    //   298: ldc_w 316
    //   301: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   304: ifne +7 -> 311
    //   307: iconst_0
    //   308: putstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   311: aload_0
    //   312: iconst_1
    //   313: aaload
    //   314: ldc_w 317
    //   317: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   320: ifne +7 -> 327
    //   323: iconst_0
    //   324: putstatic 57	com/chelpus/root/utils/runpatchads:pattern6	Z
    //   327: aload_0
    //   328: iconst_1
    //   329: aaload
    //   330: ldc_w 318
    //   333: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   336: ifne +7 -> 343
    //   339: iconst_0
    //   340: putstatic 59	com/chelpus/root/utils/runpatchads:dependencies	Z
    //   343: aload_0
    //   344: iconst_1
    //   345: aaload
    //   346: ldc_w 320
    //   349: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   352: ifne +7 -> 359
    //   355: iconst_0
    //   356: putstatic 61	com/chelpus/root/utils/runpatchads:full_offline	Z
    //   359: aload_0
    //   360: bipush 6
    //   362: aaload
    //   363: ifnull +20 -> 383
    //   366: aload_0
    //   367: bipush 6
    //   369: aaload
    //   370: ldc_w 321
    //   373: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   376: ifeq +7 -> 383
    //   379: iconst_1
    //   380: putstatic 43	com/chelpus/root/utils/runpatchads:createAPK	Z
    //   383: aload_0
    //   384: bipush 6
    //   386: aaload
    //   387: ifnull +20 -> 407
    //   390: aload_0
    //   391: bipush 6
    //   393: aaload
    //   394: ldc_w 322
    //   397: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   400: ifeq +7 -> 407
    //   403: iconst_1
    //   404: putstatic 65	com/chelpus/root/utils/runpatchads:ART	Z
    //   407: aload_0
    //   408: bipush 6
    //   410: aaload
    //   411: ifnull +11 -> 422
    //   414: aload_0
    //   415: bipush 6
    //   417: aaload
    //   418: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   421: pop
    //   422: aload_0
    //   423: bipush 7
    //   425: aaload
    //   426: ifnull +37 -> 463
    //   429: new 159	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 324
    //   439: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_0
    //   443: bipush 7
    //   445: aaload
    //   446: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   455: pop
    //   456: aload_0
    //   457: bipush 7
    //   459: aaload
    //   460: putstatic 89	com/chelpus/root/utils/runpatchads:AdsBlockFile	Ljava/lang/String;
    //   463: aload_0
    //   464: bipush 8
    //   466: aaload
    //   467: ifnull +3435 -> 3902
    //   470: aload_0
    //   471: bipush 8
    //   473: aaload
    //   474: putstatic 75	com/chelpus/root/utils/runpatchads:uid	Ljava/lang/String;
    //   477: aload_0
    //   478: iconst_5
    //   479: aaload
    //   480: ldc_w 325
    //   483: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   486: ifeq +7 -> 493
    //   489: iconst_1
    //   490: putstatic 63	com/chelpus/root/utils/runpatchads:copyDC	Z
    //   493: getstatic 43	com/chelpus/root/utils/runpatchads:createAPK	Z
    //   496: ifeq +10 -> 506
    //   499: iconst_0
    //   500: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   503: putstatic 337	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   506: new 91	java/util/ArrayList
    //   509: dup
    //   510: invokespecial 94	java/util/ArrayList:<init>	()V
    //   513: astore 13
    //   515: new 91	java/util/ArrayList
    //   518: dup
    //   519: invokespecial 94	java/util/ArrayList:<init>	()V
    //   522: astore 14
    //   524: new 91	java/util/ArrayList
    //   527: dup
    //   528: invokespecial 94	java/util/ArrayList:<init>	()V
    //   531: astore 15
    //   533: new 91	java/util/ArrayList
    //   536: dup
    //   537: invokespecial 94	java/util/ArrayList:<init>	()V
    //   540: astore 16
    //   542: new 91	java/util/ArrayList
    //   545: dup
    //   546: invokespecial 94	java/util/ArrayList:<init>	()V
    //   549: astore 17
    //   551: new 91	java/util/ArrayList
    //   554: dup
    //   555: invokespecial 94	java/util/ArrayList:<init>	()V
    //   558: astore 18
    //   560: new 91	java/util/ArrayList
    //   563: dup
    //   564: invokespecial 94	java/util/ArrayList:<init>	()V
    //   567: astore 19
    //   569: aload 14
    //   571: ldc_w 339
    //   574: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   577: pop
    //   578: aload 15
    //   580: ldc_w 344
    //   583: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   586: pop
    //   587: aload 16
    //   589: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   592: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   595: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   598: pop
    //   599: aload 17
    //   601: ldc_w 346
    //   604: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   607: pop
    //   608: aload 18
    //   610: ldc_w 348
    //   613: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   616: pop
    //   617: aload 19
    //   619: iconst_0
    //   620: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   623: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   626: pop
    //   627: aload 14
    //   629: ldc_w 350
    //   632: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   635: pop
    //   636: aload 15
    //   638: ldc_w 352
    //   641: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   644: pop
    //   645: aload 16
    //   647: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   650: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   653: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   656: pop
    //   657: aload 17
    //   659: ldc_w 346
    //   662: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   665: pop
    //   666: aload 18
    //   668: ldc_w 348
    //   671: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   674: pop
    //   675: aload 19
    //   677: iconst_0
    //   678: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   681: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   684: pop
    //   685: aload 14
    //   687: ldc_w 354
    //   690: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   693: pop
    //   694: aload 15
    //   696: ldc_w 356
    //   699: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   702: pop
    //   703: aload 16
    //   705: iconst_0
    //   706: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   709: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   712: pop
    //   713: aload 17
    //   715: ldc_w 358
    //   718: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   721: pop
    //   722: aload 18
    //   724: ldc_w 348
    //   727: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   730: pop
    //   731: aload 19
    //   733: iconst_0
    //   734: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   737: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   740: pop
    //   741: aload 14
    //   743: ldc_w 354
    //   746: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   749: pop
    //   750: aload 15
    //   752: ldc_w 356
    //   755: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   758: pop
    //   759: aload 16
    //   761: getstatic 61	com/chelpus/root/utils/runpatchads:full_offline	Z
    //   764: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   767: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   770: pop
    //   771: aload 17
    //   773: ldc_w 360
    //   776: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   779: pop
    //   780: aload 18
    //   782: ldc 73
    //   784: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   787: pop
    //   788: aload 19
    //   790: iconst_0
    //   791: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   794: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   797: pop
    //   798: aload 14
    //   800: ldc_w 362
    //   803: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   806: pop
    //   807: aload 15
    //   809: ldc_w 364
    //   812: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   815: pop
    //   816: aload 16
    //   818: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   821: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   824: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   827: pop
    //   828: aload 17
    //   830: ldc_w 366
    //   833: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   836: pop
    //   837: aload 18
    //   839: ldc 73
    //   841: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   844: pop
    //   845: aload 19
    //   847: iconst_1
    //   848: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   851: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   854: pop
    //   855: aload 14
    //   857: ldc_w 368
    //   860: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   863: pop
    //   864: aload 15
    //   866: ldc_w 370
    //   869: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   872: pop
    //   873: aload 16
    //   875: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   878: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   881: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   884: pop
    //   885: aload 17
    //   887: ldc_w 366
    //   890: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   893: pop
    //   894: aload 18
    //   896: ldc 73
    //   898: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   901: pop
    //   902: aload 19
    //   904: iconst_1
    //   905: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   908: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   911: pop
    //   912: aload 14
    //   914: ldc_w 372
    //   917: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   920: pop
    //   921: aload 15
    //   923: ldc_w 370
    //   926: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   929: pop
    //   930: aload 16
    //   932: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   935: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   938: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   941: pop
    //   942: aload 17
    //   944: ldc_w 366
    //   947: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   950: pop
    //   951: aload 18
    //   953: ldc 73
    //   955: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   958: pop
    //   959: aload 19
    //   961: iconst_1
    //   962: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   965: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   968: pop
    //   969: aload 14
    //   971: ldc_w 374
    //   974: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   977: pop
    //   978: aload 15
    //   980: ldc_w 370
    //   983: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   986: pop
    //   987: aload 16
    //   989: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   992: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   995: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   998: pop
    //   999: aload 17
    //   1001: ldc_w 366
    //   1004: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1007: pop
    //   1008: aload 18
    //   1010: ldc 73
    //   1012: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1015: pop
    //   1016: aload 19
    //   1018: iconst_1
    //   1019: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1022: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1025: pop
    //   1026: aload 14
    //   1028: ldc_w 376
    //   1031: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1034: pop
    //   1035: aload 15
    //   1037: ldc_w 370
    //   1040: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1043: pop
    //   1044: aload 16
    //   1046: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   1049: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1052: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1055: pop
    //   1056: aload 17
    //   1058: ldc_w 366
    //   1061: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1064: pop
    //   1065: aload 18
    //   1067: ldc 73
    //   1069: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1072: pop
    //   1073: aload 19
    //   1075: iconst_1
    //   1076: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1079: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1082: pop
    //   1083: aload 14
    //   1085: ldc_w 378
    //   1088: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1091: pop
    //   1092: aload 15
    //   1094: ldc_w 380
    //   1097: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1100: pop
    //   1101: aload 16
    //   1103: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   1106: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1109: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1112: pop
    //   1113: aload 17
    //   1115: ldc_w 366
    //   1118: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1121: pop
    //   1122: aload 18
    //   1124: ldc 73
    //   1126: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1129: pop
    //   1130: aload 19
    //   1132: iconst_1
    //   1133: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1136: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1139: pop
    //   1140: aload 14
    //   1142: ldc_w 382
    //   1145: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1148: pop
    //   1149: aload 15
    //   1151: ldc_w 370
    //   1154: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1157: pop
    //   1158: aload 16
    //   1160: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   1163: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1166: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1169: pop
    //   1170: aload 17
    //   1172: ldc_w 366
    //   1175: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1178: pop
    //   1179: aload 18
    //   1181: ldc 73
    //   1183: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1186: pop
    //   1187: aload 19
    //   1189: iconst_1
    //   1190: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1193: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1196: pop
    //   1197: aload 14
    //   1199: ldc_w 384
    //   1202: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1205: pop
    //   1206: aload 15
    //   1208: ldc_w 386
    //   1211: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1214: pop
    //   1215: aload 16
    //   1217: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   1220: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1223: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1226: pop
    //   1227: aload 17
    //   1229: ldc_w 366
    //   1232: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1235: pop
    //   1236: aload 18
    //   1238: ldc 73
    //   1240: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1243: pop
    //   1244: aload 19
    //   1246: iconst_0
    //   1247: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1250: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1253: pop
    //   1254: aload 14
    //   1256: ldc_w 388
    //   1259: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1262: pop
    //   1263: aload 15
    //   1265: ldc_w 390
    //   1268: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1271: pop
    //   1272: aload 16
    //   1274: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   1277: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1280: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1283: pop
    //   1284: aload 17
    //   1286: ldc_w 366
    //   1289: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1292: pop
    //   1293: aload 18
    //   1295: ldc 73
    //   1297: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1300: pop
    //   1301: aload 19
    //   1303: iconst_0
    //   1304: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1307: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1310: pop
    //   1311: aload 14
    //   1313: ldc_w 392
    //   1316: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1319: pop
    //   1320: aload 15
    //   1322: ldc_w 394
    //   1325: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1328: pop
    //   1329: aload 16
    //   1331: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   1334: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1337: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1340: pop
    //   1341: aload 17
    //   1343: ldc_w 366
    //   1346: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1349: pop
    //   1350: aload 18
    //   1352: ldc 73
    //   1354: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1357: pop
    //   1358: aload 19
    //   1360: iconst_0
    //   1361: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1364: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1367: pop
    //   1368: aload 14
    //   1370: ldc_w 396
    //   1373: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1376: pop
    //   1377: aload 15
    //   1379: ldc_w 398
    //   1382: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1385: pop
    //   1386: aload 16
    //   1388: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   1391: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1394: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1397: pop
    //   1398: aload 17
    //   1400: ldc_w 400
    //   1403: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1406: pop
    //   1407: aload 18
    //   1409: ldc 73
    //   1411: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1414: pop
    //   1415: aload 19
    //   1417: iconst_0
    //   1418: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1421: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1424: pop
    //   1425: aload 14
    //   1427: ldc_w 362
    //   1430: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1433: pop
    //   1434: aload 15
    //   1436: ldc_w 402
    //   1439: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1442: pop
    //   1443: aload 16
    //   1445: getstatic 47	com/chelpus/root/utils/runpatchads:pattern1	Z
    //   1448: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1451: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1454: pop
    //   1455: aload 17
    //   1457: ldc_w 366
    //   1460: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1463: pop
    //   1464: aload 18
    //   1466: ldc 73
    //   1468: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1471: pop
    //   1472: aload 19
    //   1474: iconst_1
    //   1475: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1478: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1481: pop
    //   1482: aload 14
    //   1484: ldc_w 372
    //   1487: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1490: pop
    //   1491: aload 15
    //   1493: ldc_w 404
    //   1496: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1499: pop
    //   1500: aload 16
    //   1502: getstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   1505: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1508: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1511: pop
    //   1512: aload 17
    //   1514: ldc_w 406
    //   1517: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1520: pop
    //   1521: aload 18
    //   1523: ldc 73
    //   1525: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1528: pop
    //   1529: aload 19
    //   1531: iconst_1
    //   1532: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1535: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1538: pop
    //   1539: aload 14
    //   1541: ldc_w 374
    //   1544: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1547: pop
    //   1548: aload 15
    //   1550: ldc_w 404
    //   1553: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1556: pop
    //   1557: aload 16
    //   1559: getstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   1562: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1565: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1568: pop
    //   1569: aload 17
    //   1571: ldc_w 406
    //   1574: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1577: pop
    //   1578: aload 18
    //   1580: ldc 73
    //   1582: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1585: pop
    //   1586: aload 19
    //   1588: iconst_1
    //   1589: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1592: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1595: pop
    //   1596: aload 14
    //   1598: ldc_w 376
    //   1601: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1604: pop
    //   1605: aload 15
    //   1607: ldc_w 404
    //   1610: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1613: pop
    //   1614: aload 16
    //   1616: getstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   1619: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1622: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1625: pop
    //   1626: aload 17
    //   1628: ldc_w 406
    //   1631: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1634: pop
    //   1635: aload 18
    //   1637: ldc 73
    //   1639: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1642: pop
    //   1643: aload 19
    //   1645: iconst_1
    //   1646: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1649: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1652: pop
    //   1653: aload 14
    //   1655: ldc_w 378
    //   1658: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1661: pop
    //   1662: aload 15
    //   1664: ldc_w 408
    //   1667: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1670: pop
    //   1671: aload 16
    //   1673: getstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   1676: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1679: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1682: pop
    //   1683: aload 17
    //   1685: ldc_w 406
    //   1688: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1691: pop
    //   1692: aload 18
    //   1694: ldc 73
    //   1696: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1699: pop
    //   1700: aload 19
    //   1702: iconst_1
    //   1703: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1706: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1709: pop
    //   1710: aload 14
    //   1712: ldc_w 368
    //   1715: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1718: pop
    //   1719: aload 15
    //   1721: ldc_w 404
    //   1724: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1727: pop
    //   1728: aload 16
    //   1730: getstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   1733: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1736: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1739: pop
    //   1740: aload 17
    //   1742: ldc_w 406
    //   1745: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1748: pop
    //   1749: aload 18
    //   1751: ldc 73
    //   1753: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1756: pop
    //   1757: aload 19
    //   1759: iconst_1
    //   1760: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1763: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1766: pop
    //   1767: aload 14
    //   1769: ldc_w 382
    //   1772: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1775: pop
    //   1776: aload 15
    //   1778: ldc_w 404
    //   1781: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1784: pop
    //   1785: aload 16
    //   1787: getstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   1790: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1793: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1796: pop
    //   1797: aload 17
    //   1799: ldc_w 406
    //   1802: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1805: pop
    //   1806: aload 18
    //   1808: ldc 73
    //   1810: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1813: pop
    //   1814: aload 19
    //   1816: iconst_1
    //   1817: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1820: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1823: pop
    //   1824: aload 14
    //   1826: ldc_w 384
    //   1829: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1832: pop
    //   1833: aload 15
    //   1835: ldc_w 386
    //   1838: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1841: pop
    //   1842: aload 16
    //   1844: getstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   1847: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1850: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1853: pop
    //   1854: aload 17
    //   1856: ldc_w 406
    //   1859: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1862: pop
    //   1863: aload 18
    //   1865: ldc 73
    //   1867: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1870: pop
    //   1871: aload 19
    //   1873: iconst_0
    //   1874: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1877: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1880: pop
    //   1881: aload 14
    //   1883: ldc_w 388
    //   1886: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1889: pop
    //   1890: aload 15
    //   1892: ldc_w 390
    //   1895: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1898: pop
    //   1899: aload 16
    //   1901: getstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   1904: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1907: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1910: pop
    //   1911: aload 17
    //   1913: ldc_w 406
    //   1916: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1919: pop
    //   1920: aload 18
    //   1922: ldc 73
    //   1924: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1927: pop
    //   1928: aload 19
    //   1930: iconst_0
    //   1931: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1934: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1937: pop
    //   1938: aload 14
    //   1940: ldc_w 392
    //   1943: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1946: pop
    //   1947: aload 15
    //   1949: ldc_w 394
    //   1952: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1955: pop
    //   1956: aload 16
    //   1958: getstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   1961: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1964: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1967: pop
    //   1968: aload 17
    //   1970: ldc_w 406
    //   1973: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1976: pop
    //   1977: aload 18
    //   1979: ldc 73
    //   1981: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1984: pop
    //   1985: aload 19
    //   1987: iconst_0
    //   1988: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1991: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1994: pop
    //   1995: aload 14
    //   1997: ldc_w 396
    //   2000: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2003: pop
    //   2004: aload 15
    //   2006: ldc_w 398
    //   2009: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2012: pop
    //   2013: aload 16
    //   2015: getstatic 49	com/chelpus/root/utils/runpatchads:pattern2	Z
    //   2018: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2021: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2024: pop
    //   2025: aload 17
    //   2027: ldc_w 410
    //   2030: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2033: pop
    //   2034: aload 18
    //   2036: ldc 73
    //   2038: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2041: pop
    //   2042: aload 19
    //   2044: iconst_0
    //   2045: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2048: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2051: pop
    //   2052: aload 14
    //   2054: ldc_w 412
    //   2057: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2060: pop
    //   2061: aload 15
    //   2063: ldc_w 414
    //   2066: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2069: pop
    //   2070: aload 16
    //   2072: getstatic 51	com/chelpus/root/utils/runpatchads:pattern3	Z
    //   2075: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2078: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2081: pop
    //   2082: aload 17
    //   2084: ldc_w 416
    //   2087: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2090: pop
    //   2091: aload 18
    //   2093: ldc 73
    //   2095: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2098: pop
    //   2099: aload 19
    //   2101: iconst_0
    //   2102: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2105: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2108: pop
    //   2109: aload 14
    //   2111: ldc_w 418
    //   2114: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2117: pop
    //   2118: aload 15
    //   2120: ldc_w 420
    //   2123: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2126: pop
    //   2127: aload 16
    //   2129: getstatic 51	com/chelpus/root/utils/runpatchads:pattern3	Z
    //   2132: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2135: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2138: pop
    //   2139: aload 17
    //   2141: ldc_w 416
    //   2144: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2147: pop
    //   2148: aload 18
    //   2150: ldc 73
    //   2152: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2155: pop
    //   2156: aload 19
    //   2158: iconst_0
    //   2159: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2162: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2165: pop
    //   2166: aload 14
    //   2168: ldc_w 422
    //   2171: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2174: pop
    //   2175: aload 15
    //   2177: ldc_w 424
    //   2180: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2183: pop
    //   2184: aload 16
    //   2186: getstatic 51	com/chelpus/root/utils/runpatchads:pattern3	Z
    //   2189: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2192: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2195: pop
    //   2196: aload 17
    //   2198: ldc_w 416
    //   2201: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2204: pop
    //   2205: aload 18
    //   2207: ldc 73
    //   2209: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2212: pop
    //   2213: aload 19
    //   2215: iconst_0
    //   2216: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2219: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2222: pop
    //   2223: aload 14
    //   2225: ldc_w 426
    //   2228: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2231: pop
    //   2232: aload 15
    //   2234: ldc_w 428
    //   2237: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2240: pop
    //   2241: aload 16
    //   2243: getstatic 51	com/chelpus/root/utils/runpatchads:pattern3	Z
    //   2246: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2249: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2252: pop
    //   2253: aload 17
    //   2255: ldc_w 416
    //   2258: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2261: pop
    //   2262: aload 18
    //   2264: ldc 73
    //   2266: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2269: pop
    //   2270: aload 19
    //   2272: iconst_0
    //   2273: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2276: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2279: pop
    //   2280: aload 14
    //   2282: ldc_w 430
    //   2285: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2288: pop
    //   2289: aload 15
    //   2291: ldc_w 432
    //   2294: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2297: pop
    //   2298: aload 16
    //   2300: getstatic 53	com/chelpus/root/utils/runpatchads:pattern4	Z
    //   2303: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2306: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2309: pop
    //   2310: aload 17
    //   2312: ldc_w 434
    //   2315: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2318: pop
    //   2319: aload 18
    //   2321: ldc 73
    //   2323: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2326: pop
    //   2327: aload 19
    //   2329: iconst_0
    //   2330: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2333: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2336: pop
    //   2337: aload 14
    //   2339: ldc_w 436
    //   2342: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2345: pop
    //   2346: aload 15
    //   2348: ldc_w 438
    //   2351: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2354: pop
    //   2355: aload 16
    //   2357: getstatic 53	com/chelpus/root/utils/runpatchads:pattern4	Z
    //   2360: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2363: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2366: pop
    //   2367: aload 17
    //   2369: ldc_w 434
    //   2372: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2375: pop
    //   2376: aload 18
    //   2378: ldc 73
    //   2380: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2383: pop
    //   2384: aload 19
    //   2386: iconst_0
    //   2387: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2390: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2393: pop
    //   2394: aload 14
    //   2396: ldc_w 440
    //   2399: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2402: pop
    //   2403: aload 15
    //   2405: ldc_w 442
    //   2408: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2411: pop
    //   2412: aload 16
    //   2414: getstatic 53	com/chelpus/root/utils/runpatchads:pattern4	Z
    //   2417: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2420: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2423: pop
    //   2424: aload 17
    //   2426: ldc_w 434
    //   2429: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2432: pop
    //   2433: aload 18
    //   2435: ldc 73
    //   2437: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2440: pop
    //   2441: aload 19
    //   2443: iconst_0
    //   2444: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2447: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2450: pop
    //   2451: aload 14
    //   2453: ldc_w 444
    //   2456: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2459: pop
    //   2460: aload 15
    //   2462: ldc_w 446
    //   2465: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2468: pop
    //   2469: aload 16
    //   2471: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   2474: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2477: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2480: pop
    //   2481: aload 17
    //   2483: ldc_w 448
    //   2486: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2489: pop
    //   2490: aload 18
    //   2492: ldc 73
    //   2494: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2497: pop
    //   2498: aload 19
    //   2500: iconst_0
    //   2501: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2504: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2507: pop
    //   2508: aload 14
    //   2510: ldc_w 450
    //   2513: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2516: pop
    //   2517: aload 15
    //   2519: ldc_w 452
    //   2522: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2525: pop
    //   2526: aload 16
    //   2528: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   2531: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2534: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2537: pop
    //   2538: aload 17
    //   2540: ldc_w 448
    //   2543: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2546: pop
    //   2547: aload 18
    //   2549: ldc 73
    //   2551: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2554: pop
    //   2555: aload 19
    //   2557: iconst_0
    //   2558: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2561: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2564: pop
    //   2565: aload 14
    //   2567: ldc_w 454
    //   2570: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2573: pop
    //   2574: aload 15
    //   2576: ldc_w 456
    //   2579: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2582: pop
    //   2583: aload 16
    //   2585: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   2588: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2591: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2594: pop
    //   2595: aload 17
    //   2597: ldc_w 448
    //   2600: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2603: pop
    //   2604: aload 18
    //   2606: ldc 73
    //   2608: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2611: pop
    //   2612: aload 19
    //   2614: iconst_0
    //   2615: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2618: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2621: pop
    //   2622: aload 14
    //   2624: ldc_w 458
    //   2627: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2630: pop
    //   2631: aload 15
    //   2633: ldc_w 460
    //   2636: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2639: pop
    //   2640: aload 16
    //   2642: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   2645: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2648: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2651: pop
    //   2652: aload 17
    //   2654: ldc_w 448
    //   2657: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2660: pop
    //   2661: aload 18
    //   2663: ldc 73
    //   2665: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2668: pop
    //   2669: aload 19
    //   2671: iconst_0
    //   2672: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2675: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2678: pop
    //   2679: aload 14
    //   2681: ldc_w 462
    //   2684: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2687: pop
    //   2688: aload 15
    //   2690: ldc_w 464
    //   2693: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2696: pop
    //   2697: aload 16
    //   2699: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   2702: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2705: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2708: pop
    //   2709: aload 17
    //   2711: ldc_w 448
    //   2714: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2717: pop
    //   2718: aload 18
    //   2720: ldc 73
    //   2722: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2725: pop
    //   2726: aload 19
    //   2728: iconst_0
    //   2729: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2732: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2735: pop
    //   2736: aload 14
    //   2738: ldc_w 466
    //   2741: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2744: pop
    //   2745: aload 15
    //   2747: ldc_w 468
    //   2750: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2753: pop
    //   2754: aload 16
    //   2756: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   2759: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2762: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2765: pop
    //   2766: aload 17
    //   2768: ldc_w 448
    //   2771: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2774: pop
    //   2775: aload 18
    //   2777: ldc 73
    //   2779: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2782: pop
    //   2783: aload 19
    //   2785: iconst_0
    //   2786: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2789: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2792: pop
    //   2793: aload 14
    //   2795: ldc_w 470
    //   2798: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2801: pop
    //   2802: aload 15
    //   2804: ldc_w 472
    //   2807: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2810: pop
    //   2811: aload 16
    //   2813: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   2816: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2819: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2822: pop
    //   2823: aload 17
    //   2825: ldc_w 448
    //   2828: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2831: pop
    //   2832: aload 18
    //   2834: ldc 73
    //   2836: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2839: pop
    //   2840: aload 19
    //   2842: iconst_0
    //   2843: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2846: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2849: pop
    //   2850: aload 14
    //   2852: ldc_w 474
    //   2855: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2858: pop
    //   2859: aload 15
    //   2861: ldc_w 476
    //   2864: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2867: pop
    //   2868: aload 16
    //   2870: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   2873: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2876: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2879: pop
    //   2880: aload 17
    //   2882: ldc_w 448
    //   2885: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2888: pop
    //   2889: aload 18
    //   2891: ldc 73
    //   2893: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2896: pop
    //   2897: aload 19
    //   2899: iconst_0
    //   2900: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2903: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2906: pop
    //   2907: aload 14
    //   2909: ldc_w 478
    //   2912: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2915: pop
    //   2916: aload 15
    //   2918: ldc_w 480
    //   2921: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2924: pop
    //   2925: aload 16
    //   2927: getstatic 55	com/chelpus/root/utils/runpatchads:pattern5	Z
    //   2930: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2933: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2936: pop
    //   2937: aload 17
    //   2939: ldc_w 448
    //   2942: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2945: pop
    //   2946: aload 18
    //   2948: ldc 73
    //   2950: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2953: pop
    //   2954: aload 19
    //   2956: iconst_0
    //   2957: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2960: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2963: pop
    //   2964: aload 14
    //   2966: ldc_w 482
    //   2969: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2972: pop
    //   2973: aload 15
    //   2975: ldc_w 484
    //   2978: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2981: pop
    //   2982: aload 16
    //   2984: getstatic 57	com/chelpus/root/utils/runpatchads:pattern6	Z
    //   2987: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2990: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2993: pop
    //   2994: aload 17
    //   2996: ldc_w 486
    //   2999: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3002: pop
    //   3003: aload 18
    //   3005: ldc 73
    //   3007: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3010: pop
    //   3011: aload 19
    //   3013: iconst_0
    //   3014: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3017: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3020: pop
    //   3021: aload 14
    //   3023: ldc_w 488
    //   3026: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3029: pop
    //   3030: aload 15
    //   3032: ldc_w 490
    //   3035: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3038: pop
    //   3039: aload 16
    //   3041: getstatic 57	com/chelpus/root/utils/runpatchads:pattern6	Z
    //   3044: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3047: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3050: pop
    //   3051: aload 17
    //   3053: ldc_w 492
    //   3056: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3059: pop
    //   3060: aload 18
    //   3062: ldc 73
    //   3064: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3067: pop
    //   3068: aload 19
    //   3070: iconst_0
    //   3071: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3074: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3077: pop
    //   3078: aload_0
    //   3079: iconst_0
    //   3080: aaload
    //   3081: ldc_w 494
    //   3084: invokevirtual 311	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3087: ifne +60 -> 3147
    //   3090: aload 14
    //   3092: ldc_w 496
    //   3095: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3098: pop
    //   3099: aload 15
    //   3101: ldc_w 498
    //   3104: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3107: pop
    //   3108: aload 16
    //   3110: getstatic 57	com/chelpus/root/utils/runpatchads:pattern6	Z
    //   3113: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3116: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3119: pop
    //   3120: aload 17
    //   3122: ldc_w 486
    //   3125: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3128: pop
    //   3129: aload 18
    //   3131: ldc 73
    //   3133: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3136: pop
    //   3137: aload 19
    //   3139: iconst_1
    //   3140: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3143: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3146: pop
    //   3147: aload 14
    //   3149: ldc_w 500
    //   3152: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3155: pop
    //   3156: aload 15
    //   3158: ldc_w 502
    //   3161: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3164: pop
    //   3165: aload 16
    //   3167: getstatic 57	com/chelpus/root/utils/runpatchads:pattern6	Z
    //   3170: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3173: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3176: pop
    //   3177: aload 17
    //   3179: ldc_w 486
    //   3182: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3185: pop
    //   3186: aload 18
    //   3188: ldc 73
    //   3190: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3193: pop
    //   3194: aload 19
    //   3196: iconst_1
    //   3197: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3200: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3203: pop
    //   3204: aload 14
    //   3206: ldc_w 504
    //   3209: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3212: pop
    //   3213: aload 15
    //   3215: ldc_w 506
    //   3218: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3221: pop
    //   3222: aload 16
    //   3224: getstatic 57	com/chelpus/root/utils/runpatchads:pattern6	Z
    //   3227: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3230: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3233: pop
    //   3234: aload 17
    //   3236: ldc_w 486
    //   3239: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3242: pop
    //   3243: aload 18
    //   3245: ldc 73
    //   3247: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3250: pop
    //   3251: aload 19
    //   3253: iconst_0
    //   3254: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3257: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3260: pop
    //   3261: aload 14
    //   3263: ldc_w 508
    //   3266: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3269: pop
    //   3270: aload 15
    //   3272: ldc_w 510
    //   3275: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3278: pop
    //   3279: aload 16
    //   3281: getstatic 57	com/chelpus/root/utils/runpatchads:pattern6	Z
    //   3284: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3287: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3290: pop
    //   3291: aload 17
    //   3293: ldc_w 486
    //   3296: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3299: pop
    //   3300: aload 18
    //   3302: ldc 73
    //   3304: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3307: pop
    //   3308: aload 19
    //   3310: iconst_0
    //   3311: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3314: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3317: pop
    //   3318: getstatic 65	com/chelpus/root/utils/runpatchads:ART	Z
    //   3321: ifne +596 -> 3917
    //   3324: aload 14
    //   3326: ldc_w 512
    //   3329: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3332: pop
    //   3333: aload 15
    //   3335: ldc_w 514
    //   3338: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3341: pop
    //   3342: aload 16
    //   3344: getstatic 59	com/chelpus/root/utils/runpatchads:dependencies	Z
    //   3347: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3350: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3353: pop
    //   3354: aload 17
    //   3356: ldc_w 516
    //   3359: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3362: pop
    //   3363: aload 18
    //   3365: ldc 73
    //   3367: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3370: pop
    //   3371: aload 19
    //   3373: iconst_1
    //   3374: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3377: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3380: pop
    //   3381: aload 14
    //   3383: ldc_w 518
    //   3386: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3389: pop
    //   3390: aload 15
    //   3392: ldc_w 520
    //   3395: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3398: pop
    //   3399: aload 16
    //   3401: getstatic 59	com/chelpus/root/utils/runpatchads:dependencies	Z
    //   3404: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3407: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3410: pop
    //   3411: aload 17
    //   3413: ldc_w 516
    //   3416: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3419: pop
    //   3420: aload 18
    //   3422: ldc 73
    //   3424: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3427: pop
    //   3428: aload 19
    //   3430: iconst_1
    //   3431: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3434: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3437: pop
    //   3438: aload 12
    //   3440: aload 14
    //   3442: aload 15
    //   3444: aload 16
    //   3446: aload 17
    //   3448: aload 18
    //   3450: aload 19
    //   3452: iconst_0
    //   3453: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3456: invokestatic 524	com/chelpus/Utils:convertToPatchItemAuto	(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Boolean;)V
    //   3459: getstatic 45	com/chelpus/root/utils/runpatchads:fileblock	Z
    //   3462: ifeq +227 -> 3689
    //   3465: getstatic 89	com/chelpus/root/utils/runpatchads:AdsBlockFile	Ljava/lang/String;
    //   3468: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   3471: pop
    //   3472: new 225	java/io/FileInputStream
    //   3475: dup
    //   3476: getstatic 89	com/chelpus/root/utils/runpatchads:AdsBlockFile	Ljava/lang/String;
    //   3479: invokespecial 525	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   3482: astore 14
    //   3484: new 527	java/io/BufferedReader
    //   3487: dup
    //   3488: new 529	java/io/InputStreamReader
    //   3491: dup
    //   3492: aload 14
    //   3494: invokespecial 532	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   3497: invokespecial 535	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   3500: astore 15
    //   3502: getstatic 45	com/chelpus/root/utils/runpatchads:fileblock	Z
    //   3505: ifeq +529 -> 4034
    //   3508: aload 15
    //   3510: invokevirtual 538	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   3513: astore 16
    //   3515: aload 16
    //   3517: ifnull +517 -> 4034
    //   3520: aload 16
    //   3522: invokevirtual 541	java/lang/String:trim	()Ljava/lang/String;
    //   3525: astore 16
    //   3527: aload 16
    //   3529: ldc 73
    //   3531: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3534: ifne -26 -> 3508
    //   3537: aload 13
    //   3539: aload 16
    //   3541: ldc_w 543
    //   3544: invokevirtual 547	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   3547: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3550: pop
    //   3551: goto -43 -> 3508
    //   3554: astore 14
    //   3556: aload 14
    //   3558: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   3561: new 225	java/io/FileInputStream
    //   3564: dup
    //   3565: getstatic 89	com/chelpus/root/utils/runpatchads:AdsBlockFile	Ljava/lang/String;
    //   3568: ldc_w 549
    //   3571: ldc_w 551
    //   3574: invokevirtual 555	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   3577: invokespecial 525	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   3580: astore 14
    //   3582: new 527	java/io/BufferedReader
    //   3585: dup
    //   3586: new 529	java/io/InputStreamReader
    //   3589: dup
    //   3590: aload 14
    //   3592: invokespecial 532	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   3595: invokespecial 535	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   3598: astore 15
    //   3600: aload 15
    //   3602: invokevirtual 538	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   3605: astore 16
    //   3607: aload 16
    //   3609: ifnull +433 -> 4042
    //   3612: aload 16
    //   3614: invokevirtual 541	java/lang/String:trim	()Ljava/lang/String;
    //   3617: astore 16
    //   3619: aload 16
    //   3621: ldc 73
    //   3623: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3626: ifne -26 -> 3600
    //   3629: aload 13
    //   3631: aload 16
    //   3633: ldc_w 543
    //   3636: invokevirtual 547	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   3639: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3642: pop
    //   3643: goto -43 -> 3600
    //   3646: astore 14
    //   3648: aload 14
    //   3650: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   3653: aload 13
    //   3655: invokevirtual 558	java/util/ArrayList:isEmpty	()Z
    //   3658: ifne +31 -> 3689
    //   3661: aload 13
    //   3663: invokevirtual 200	java/util/ArrayList:size	()I
    //   3666: anewarray 560	[B
    //   3669: putstatic 562	com/chelpus/root/utils/runpatchads:sites	[[B
    //   3672: aload 13
    //   3674: getstatic 562	com/chelpus/root/utils/runpatchads:sites	[[B
    //   3677: invokevirtual 566	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   3680: checkcast 567	[[B
    //   3683: checkcast 567	[[B
    //   3686: putstatic 562	com/chelpus/root/utils/runpatchads:sites	[[B
    //   3689: getstatic 337	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   3692: invokevirtual 570	java/lang/Boolean:booleanValue	()Z
    //   3695: ifeq +13 -> 3708
    //   3698: aload_0
    //   3699: iconst_2
    //   3700: aaload
    //   3701: ldc_w 572
    //   3704: invokestatic 576	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3707: pop
    //   3708: getstatic 43	com/chelpus/root/utils/runpatchads:createAPK	Z
    //   3711: ifne +783 -> 4494
    //   3714: getstatic 65	com/chelpus/root/utils/runpatchads:ART	Z
    //   3717: ifne +777 -> 4494
    //   3720: aload_0
    //   3721: iconst_3
    //   3722: aaload
    //   3723: putstatic 79	com/chelpus/root/utils/runpatchads:dir	Ljava/lang/String;
    //   3726: aload_0
    //   3727: iconst_2
    //   3728: aaload
    //   3729: putstatic 69	com/chelpus/root/utils/runpatchads:dirapp	Ljava/lang/String;
    //   3732: invokestatic 578	com/chelpus/root/utils/runpatchads:clearTemp	()V
    //   3735: aload_0
    //   3736: iconst_4
    //   3737: aaload
    //   3738: ldc_w 580
    //   3741: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3744: ifeq +7 -> 3751
    //   3747: iconst_0
    //   3748: putstatic 71	com/chelpus/root/utils/runpatchads:system	Z
    //   3751: aload_0
    //   3752: iconst_4
    //   3753: aaload
    //   3754: ldc_w 581
    //   3757: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3760: ifeq +7 -> 3767
    //   3763: iconst_1
    //   3764: putstatic 71	com/chelpus/root/utils/runpatchads:system	Z
    //   3767: getstatic 83	com/chelpus/root/utils/runpatchads:filestopatch	Ljava/util/ArrayList;
    //   3770: invokevirtual 584	java/util/ArrayList:clear	()V
    //   3773: ldc_w 586
    //   3776: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   3779: pop
    //   3780: aload_0
    //   3781: iconst_0
    //   3782: aaload
    //   3783: astore 13
    //   3785: aload_0
    //   3786: iconst_2
    //   3787: aaload
    //   3788: putstatic 87	com/chelpus/root/utils/runpatchads:appdir	Ljava/lang/String;
    //   3791: aload_0
    //   3792: iconst_3
    //   3793: aaload
    //   3794: putstatic 85	com/chelpus/root/utils/runpatchads:sddir	Ljava/lang/String;
    //   3797: invokestatic 588	com/chelpus/root/utils/runpatchads:clearTempSD	()V
    //   3800: new 186	java/io/File
    //   3803: dup
    //   3804: getstatic 87	com/chelpus/root/utils/runpatchads:appdir	Ljava/lang/String;
    //   3807: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   3810: astore 13
    //   3812: ldc_w 590
    //   3815: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   3818: pop
    //   3819: getstatic 270	com/chelpus/root/utils/runpatchads:print	Ljava/io/PrintStream;
    //   3822: ldc_w 590
    //   3825: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3828: aload 13
    //   3830: invokestatic 593	com/chelpus/root/utils/runpatchads:unzipART	(Ljava/io/File;)V
    //   3833: getstatic 96	com/chelpus/root/utils/runpatchads:classesFiles	Ljava/util/ArrayList;
    //   3836: ifnull +12 -> 3848
    //   3839: getstatic 96	com/chelpus/root/utils/runpatchads:classesFiles	Ljava/util/ArrayList;
    //   3842: invokevirtual 200	java/util/ArrayList:size	()I
    //   3845: ifne +205 -> 4050
    //   3848: new 258	java/io/FileNotFoundException
    //   3851: dup
    //   3852: invokespecial 594	java/io/FileNotFoundException:<init>	()V
    //   3855: athrow
    //   3856: astore 12
    //   3858: ldc_w 596
    //   3861: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   3864: pop
    //   3865: getstatic 83	com/chelpus/root/utils/runpatchads:filestopatch	Ljava/util/ArrayList;
    //   3868: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3871: astore 12
    //   3873: aload 12
    //   3875: invokeinterface 209 1 0
    //   3880: ifeq +2695 -> 6575
    //   3883: aload 12
    //   3885: invokeinterface 213 1 0
    //   3890: checkcast 186	java/io/File
    //   3893: invokestatic 598	com/chelpus/Utils:fixadler	(Ljava/io/File;)V
    //   3896: invokestatic 588	com/chelpus/root/utils/runpatchads:clearTempSD	()V
    //   3899: goto -26 -> 3873
    //   3902: ldc_w 600
    //   3905: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   3908: pop
    //   3909: goto -3432 -> 477
    //   3912: astore 13
    //   3914: goto -3437 -> 477
    //   3917: aload 14
    //   3919: ldc_w 512
    //   3922: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3925: pop
    //   3926: aload 15
    //   3928: ldc_w 602
    //   3931: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3934: pop
    //   3935: aload 16
    //   3937: getstatic 59	com/chelpus/root/utils/runpatchads:dependencies	Z
    //   3940: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3943: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3946: pop
    //   3947: aload 17
    //   3949: ldc_w 516
    //   3952: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3955: pop
    //   3956: aload 18
    //   3958: ldc 73
    //   3960: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3963: pop
    //   3964: aload 19
    //   3966: iconst_1
    //   3967: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3970: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3973: pop
    //   3974: aload 14
    //   3976: ldc_w 518
    //   3979: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3982: pop
    //   3983: aload 15
    //   3985: ldc_w 604
    //   3988: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3991: pop
    //   3992: aload 16
    //   3994: getstatic 59	com/chelpus/root/utils/runpatchads:dependencies	Z
    //   3997: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4000: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4003: pop
    //   4004: aload 17
    //   4006: ldc_w 516
    //   4009: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4012: pop
    //   4013: aload 18
    //   4015: ldc 73
    //   4017: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4020: pop
    //   4021: aload 19
    //   4023: iconst_1
    //   4024: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4027: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4030: pop
    //   4031: goto -593 -> 3438
    //   4034: aload 14
    //   4036: invokevirtual 241	java/io/FileInputStream:close	()V
    //   4039: goto -478 -> 3561
    //   4042: aload 14
    //   4044: invokevirtual 241	java/io/FileInputStream:close	()V
    //   4047: goto -394 -> 3653
    //   4050: getstatic 83	com/chelpus/root/utils/runpatchads:filestopatch	Ljava/util/ArrayList;
    //   4053: invokevirtual 584	java/util/ArrayList:clear	()V
    //   4056: getstatic 96	com/chelpus/root/utils/runpatchads:classesFiles	Ljava/util/ArrayList;
    //   4059: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4062: astore 13
    //   4064: aload 13
    //   4066: invokeinterface 209 1 0
    //   4071: ifeq +76 -> 4147
    //   4074: aload 13
    //   4076: invokeinterface 213 1 0
    //   4081: checkcast 186	java/io/File
    //   4084: astore 14
    //   4086: aload 14
    //   4088: invokevirtual 193	java/io/File:exists	()Z
    //   4091: ifne +44 -> 4135
    //   4094: new 258	java/io/FileNotFoundException
    //   4097: dup
    //   4098: invokespecial 594	java/io/FileNotFoundException:<init>	()V
    //   4101: athrow
    //   4102: astore 12
    //   4104: new 159	java/lang/StringBuilder
    //   4107: dup
    //   4108: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   4111: ldc_w 606
    //   4114: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4117: aload 12
    //   4119: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   4122: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4125: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4128: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   4131: pop
    //   4132: goto -267 -> 3865
    //   4135: getstatic 83	com/chelpus/root/utils/runpatchads:filestopatch	Ljava/util/ArrayList;
    //   4138: aload 14
    //   4140: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4143: pop
    //   4144: goto -80 -> 4064
    //   4147: aload_0
    //   4148: iconst_2
    //   4149: aaload
    //   4150: iconst_1
    //   4151: invokestatic 610	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   4154: astore 13
    //   4156: new 186	java/io/File
    //   4159: dup
    //   4160: aload 13
    //   4162: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   4165: astore 14
    //   4167: aload 14
    //   4169: invokevirtual 193	java/io/File:exists	()Z
    //   4172: ifeq +9 -> 4181
    //   4175: aload 14
    //   4177: invokevirtual 196	java/io/File:delete	()Z
    //   4180: pop
    //   4181: new 186	java/io/File
    //   4184: dup
    //   4185: aload 13
    //   4187: ldc_w 612
    //   4190: ldc_w 614
    //   4193: invokevirtual 555	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   4196: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   4199: astore 14
    //   4201: aload 14
    //   4203: invokevirtual 193	java/io/File:exists	()Z
    //   4206: ifeq +9 -> 4215
    //   4209: aload 14
    //   4211: invokevirtual 196	java/io/File:delete	()Z
    //   4214: pop
    //   4215: new 186	java/io/File
    //   4218: dup
    //   4219: aload 13
    //   4221: ldc_w 614
    //   4224: ldc_w 612
    //   4227: invokevirtual 555	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   4230: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   4233: astore 13
    //   4235: aload 13
    //   4237: invokevirtual 193	java/io/File:exists	()Z
    //   4240: ifeq +9 -> 4249
    //   4243: aload 13
    //   4245: invokevirtual 196	java/io/File:delete	()Z
    //   4248: pop
    //   4249: getstatic 83	com/chelpus/root/utils/runpatchads:filestopatch	Ljava/util/ArrayList;
    //   4252: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4255: astore 13
    //   4257: aload 13
    //   4259: invokeinterface 209 1 0
    //   4264: ifeq -399 -> 3865
    //   4267: aload 13
    //   4269: invokeinterface 213 1 0
    //   4274: checkcast 186	java/io/File
    //   4277: astore 14
    //   4279: ldc_w 616
    //   4282: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   4285: pop
    //   4286: new 91	java/util/ArrayList
    //   4289: dup
    //   4290: invokespecial 94	java/util/ArrayList:<init>	()V
    //   4293: astore 15
    //   4295: aload 15
    //   4297: ldc_w 618
    //   4300: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4303: pop
    //   4304: aload 15
    //   4306: ldc_w 620
    //   4309: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4312: pop
    //   4313: aload 15
    //   4315: ldc_w 622
    //   4318: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4321: pop
    //   4322: ldc_w 624
    //   4325: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   4328: pop
    //   4329: getstatic 270	com/chelpus/root/utils/runpatchads:print	Ljava/io/PrintStream;
    //   4332: ldc_w 624
    //   4335: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4338: aload 14
    //   4340: invokevirtual 627	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4343: aload 15
    //   4345: iconst_0
    //   4346: invokestatic 631	com/chelpus/Utils:getStringIds	(Ljava/lang/String;Ljava/util/ArrayList;Z)Ljava/util/ArrayList;
    //   4349: astore 16
    //   4351: iconst_0
    //   4352: istore_3
    //   4353: new 91	java/util/ArrayList
    //   4356: dup
    //   4357: invokespecial 94	java/util/ArrayList:<init>	()V
    //   4360: astore 15
    //   4362: aload 15
    //   4364: new 633	com/android/vending/billing/InAppBillingService/LACK/CommandItem
    //   4367: dup
    //   4368: ldc_w 620
    //   4371: ldc_w 622
    //   4374: invokespecial 636	com/android/vending/billing/InAppBillingService/LACK/CommandItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   4377: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4380: pop
    //   4381: aload 16
    //   4383: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4386: astore 16
    //   4388: aload 16
    //   4390: invokeinterface 209 1 0
    //   4395: ifeq +593 -> 4988
    //   4398: aload 16
    //   4400: invokeinterface 213 1 0
    //   4405: checkcast 638	com/android/vending/billing/InAppBillingService/LACK/StringItem
    //   4408: astore 17
    //   4410: aload 15
    //   4412: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4415: astore 18
    //   4417: aload 18
    //   4419: invokeinterface 209 1 0
    //   4424: ifeq +384 -> 4808
    //   4427: aload 18
    //   4429: invokeinterface 213 1 0
    //   4434: checkcast 633	com/android/vending/billing/InAppBillingService/LACK/CommandItem
    //   4437: astore 19
    //   4439: aload 19
    //   4441: getfield 641	com/android/vending/billing/InAppBillingService/LACK/CommandItem:object	Ljava/lang/String;
    //   4444: aload 17
    //   4446: getfield 644	com/android/vending/billing/InAppBillingService/LACK/StringItem:str	Ljava/lang/String;
    //   4449: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4452: ifeq +13 -> 4465
    //   4455: aload 19
    //   4457: aload 17
    //   4459: getfield 647	com/android/vending/billing/InAppBillingService/LACK/StringItem:offset	[B
    //   4462: putfield 650	com/android/vending/billing/InAppBillingService/LACK/CommandItem:Object	[B
    //   4465: aload 19
    //   4467: getfield 653	com/android/vending/billing/InAppBillingService/LACK/CommandItem:method	Ljava/lang/String;
    //   4470: aload 17
    //   4472: getfield 644	com/android/vending/billing/InAppBillingService/LACK/StringItem:str	Ljava/lang/String;
    //   4475: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4478: ifeq -61 -> 4417
    //   4481: aload 19
    //   4483: aload 17
    //   4485: getfield 647	com/android/vending/billing/InAppBillingService/LACK/StringItem:offset	[B
    //   4488: putfield 656	com/android/vending/billing/InAppBillingService/LACK/CommandItem:Method	[B
    //   4491: goto -74 -> 4417
    //   4494: getstatic 43	com/chelpus/root/utils/runpatchads:createAPK	Z
    //   4497: ifeq +178 -> 4675
    //   4500: aload_0
    //   4501: iconst_0
    //   4502: aaload
    //   4503: astore 13
    //   4505: aload_0
    //   4506: iconst_2
    //   4507: aaload
    //   4508: putstatic 87	com/chelpus/root/utils/runpatchads:appdir	Ljava/lang/String;
    //   4511: aload_0
    //   4512: iconst_5
    //   4513: aaload
    //   4514: putstatic 85	com/chelpus/root/utils/runpatchads:sddir	Ljava/lang/String;
    //   4517: invokestatic 588	com/chelpus/root/utils/runpatchads:clearTempSD	()V
    //   4520: new 186	java/io/File
    //   4523: dup
    //   4524: getstatic 87	com/chelpus/root/utils/runpatchads:appdir	Ljava/lang/String;
    //   4527: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   4530: astore 14
    //   4532: aload 14
    //   4534: invokestatic 659	com/chelpus/root/utils/runpatchads:unzipSD	(Ljava/io/File;)V
    //   4537: new 186	java/io/File
    //   4540: dup
    //   4541: new 159	java/lang/StringBuilder
    //   4544: dup
    //   4545: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   4548: getstatic 85	com/chelpus/root/utils/runpatchads:sddir	Ljava/lang/String;
    //   4551: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4554: ldc_w 661
    //   4557: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4560: aload 13
    //   4562: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4565: ldc_w 663
    //   4568: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4571: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4574: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   4577: putstatic 665	com/chelpus/root/utils/runpatchads:crkapk	Ljava/io/File;
    //   4580: aload 14
    //   4582: getstatic 665	com/chelpus/root/utils/runpatchads:crkapk	Ljava/io/File;
    //   4585: invokestatic 669	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   4588: getstatic 96	com/chelpus/root/utils/runpatchads:classesFiles	Ljava/util/ArrayList;
    //   4591: ifnull +12 -> 4603
    //   4594: getstatic 96	com/chelpus/root/utils/runpatchads:classesFiles	Ljava/util/ArrayList;
    //   4597: invokevirtual 200	java/util/ArrayList:size	()I
    //   4600: ifne +11 -> 4611
    //   4603: new 258	java/io/FileNotFoundException
    //   4606: dup
    //   4607: invokespecial 594	java/io/FileNotFoundException:<init>	()V
    //   4610: athrow
    //   4611: getstatic 83	com/chelpus/root/utils/runpatchads:filestopatch	Ljava/util/ArrayList;
    //   4614: invokevirtual 584	java/util/ArrayList:clear	()V
    //   4617: getstatic 96	com/chelpus/root/utils/runpatchads:classesFiles	Ljava/util/ArrayList;
    //   4620: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4623: astore 13
    //   4625: aload 13
    //   4627: invokeinterface 209 1 0
    //   4632: ifeq +43 -> 4675
    //   4635: aload 13
    //   4637: invokeinterface 213 1 0
    //   4642: checkcast 186	java/io/File
    //   4645: astore 14
    //   4647: aload 14
    //   4649: invokevirtual 193	java/io/File:exists	()Z
    //   4652: ifne +11 -> 4663
    //   4655: new 258	java/io/FileNotFoundException
    //   4658: dup
    //   4659: invokespecial 594	java/io/FileNotFoundException:<init>	()V
    //   4662: athrow
    //   4663: getstatic 83	com/chelpus/root/utils/runpatchads:filestopatch	Ljava/util/ArrayList;
    //   4666: aload 14
    //   4668: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4671: pop
    //   4672: goto -47 -> 4625
    //   4675: getstatic 65	com/chelpus/root/utils/runpatchads:ART	Z
    //   4678: ifeq -429 -> 4249
    //   4681: ldc_w 671
    //   4684: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   4687: pop
    //   4688: aload_0
    //   4689: iconst_0
    //   4690: aaload
    //   4691: astore 13
    //   4693: aload_0
    //   4694: iconst_2
    //   4695: aaload
    //   4696: putstatic 87	com/chelpus/root/utils/runpatchads:appdir	Ljava/lang/String;
    //   4699: aload_0
    //   4700: iconst_3
    //   4701: aaload
    //   4702: putstatic 85	com/chelpus/root/utils/runpatchads:sddir	Ljava/lang/String;
    //   4705: invokestatic 588	com/chelpus/root/utils/runpatchads:clearTempSD	()V
    //   4708: new 186	java/io/File
    //   4711: dup
    //   4712: getstatic 87	com/chelpus/root/utils/runpatchads:appdir	Ljava/lang/String;
    //   4715: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   4718: invokestatic 593	com/chelpus/root/utils/runpatchads:unzipART	(Ljava/io/File;)V
    //   4721: getstatic 96	com/chelpus/root/utils/runpatchads:classesFiles	Ljava/util/ArrayList;
    //   4724: ifnull +12 -> 4736
    //   4727: getstatic 96	com/chelpus/root/utils/runpatchads:classesFiles	Ljava/util/ArrayList;
    //   4730: invokevirtual 200	java/util/ArrayList:size	()I
    //   4733: ifne +11 -> 4744
    //   4736: new 258	java/io/FileNotFoundException
    //   4739: dup
    //   4740: invokespecial 594	java/io/FileNotFoundException:<init>	()V
    //   4743: athrow
    //   4744: getstatic 83	com/chelpus/root/utils/runpatchads:filestopatch	Ljava/util/ArrayList;
    //   4747: invokevirtual 584	java/util/ArrayList:clear	()V
    //   4750: getstatic 96	com/chelpus/root/utils/runpatchads:classesFiles	Ljava/util/ArrayList;
    //   4753: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4756: astore 13
    //   4758: aload 13
    //   4760: invokeinterface 209 1 0
    //   4765: ifeq -516 -> 4249
    //   4768: aload 13
    //   4770: invokeinterface 213 1 0
    //   4775: checkcast 186	java/io/File
    //   4778: astore 14
    //   4780: aload 14
    //   4782: invokevirtual 193	java/io/File:exists	()Z
    //   4785: ifne +11 -> 4796
    //   4788: new 258	java/io/FileNotFoundException
    //   4791: dup
    //   4792: invokespecial 594	java/io/FileNotFoundException:<init>	()V
    //   4795: athrow
    //   4796: getstatic 83	com/chelpus/root/utils/runpatchads:filestopatch	Ljava/util/ArrayList;
    //   4799: aload 14
    //   4801: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4804: pop
    //   4805: goto -47 -> 4758
    //   4808: aload 17
    //   4810: getfield 644	com/android/vending/billing/InAppBillingService/LACK/StringItem:str	Ljava/lang/String;
    //   4813: ldc_w 618
    //   4816: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4819: ifeq -431 -> 4388
    //   4822: aload 17
    //   4824: getfield 674	com/android/vending/billing/InAppBillingService/LACK/StringItem:bits32	Z
    //   4827: ifne +61 -> 4888
    //   4830: aload 12
    //   4832: iconst_0
    //   4833: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   4836: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   4839: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   4842: iconst_2
    //   4843: aload 17
    //   4845: getfield 647	com/android/vending/billing/InAppBillingService/LACK/StringItem:offset	[B
    //   4848: iconst_0
    //   4849: baload
    //   4850: bastore
    //   4851: aload 12
    //   4853: iconst_0
    //   4854: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   4857: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   4860: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   4863: iconst_3
    //   4864: aload 17
    //   4866: getfield 647	com/android/vending/billing/InAppBillingService/LACK/StringItem:offset	[B
    //   4869: iconst_1
    //   4870: baload
    //   4871: bastore
    //   4872: aload 12
    //   4874: iconst_1
    //   4875: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   4878: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   4881: iconst_0
    //   4882: putfield 685	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:pattern	Z
    //   4885: goto +1810 -> 6695
    //   4888: aload 12
    //   4890: iconst_0
    //   4891: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   4894: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   4897: iconst_0
    //   4898: putfield 685	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:pattern	Z
    //   4901: aload 12
    //   4903: iconst_1
    //   4904: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   4907: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   4910: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   4913: iconst_2
    //   4914: aload 17
    //   4916: getfield 647	com/android/vending/billing/InAppBillingService/LACK/StringItem:offset	[B
    //   4919: iconst_0
    //   4920: baload
    //   4921: bastore
    //   4922: aload 12
    //   4924: iconst_1
    //   4925: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   4928: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   4931: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   4934: iconst_3
    //   4935: aload 17
    //   4937: getfield 647	com/android/vending/billing/InAppBillingService/LACK/StringItem:offset	[B
    //   4940: iconst_1
    //   4941: baload
    //   4942: bastore
    //   4943: aload 12
    //   4945: iconst_1
    //   4946: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   4949: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   4952: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   4955: iconst_4
    //   4956: aload 17
    //   4958: getfield 647	com/android/vending/billing/InAppBillingService/LACK/StringItem:offset	[B
    //   4961: iconst_2
    //   4962: baload
    //   4963: bastore
    //   4964: aload 12
    //   4966: iconst_1
    //   4967: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   4970: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   4973: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   4976: iconst_5
    //   4977: aload 17
    //   4979: getfield 647	com/android/vending/billing/InAppBillingService/LACK/StringItem:offset	[B
    //   4982: iconst_3
    //   4983: baload
    //   4984: bastore
    //   4985: goto +1710 -> 6695
    //   4988: iload_3
    //   4989: ifne +9 -> 4998
    //   4992: getstatic 61	com/chelpus/root/utils/runpatchads:full_offline	Z
    //   4995: ifeq +297 -> 5292
    //   4998: ldc_w 687
    //   5001: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   5004: pop
    //   5005: getstatic 270	com/chelpus/root/utils/runpatchads:print	Ljava/io/PrintStream;
    //   5008: ldc_w 687
    //   5011: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5014: aload 14
    //   5016: invokevirtual 627	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5019: aload 15
    //   5021: iconst_0
    //   5022: iconst_0
    //   5023: invokestatic 691	com/chelpus/Utils:getMethodsIds	(Ljava/lang/String;Ljava/util/ArrayList;ZZ)Z
    //   5026: pop
    //   5027: getstatic 696	java/lang/System:out	Ljava/io/PrintStream;
    //   5030: aload 15
    //   5032: iconst_0
    //   5033: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5036: checkcast 633	com/android/vending/billing/InAppBillingService/LACK/CommandItem
    //   5039: getfield 699	com/android/vending/billing/InAppBillingService/LACK/CommandItem:index_command	[B
    //   5042: iconst_0
    //   5043: baload
    //   5044: invokestatic 705	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5047: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5050: getstatic 696	java/lang/System:out	Ljava/io/PrintStream;
    //   5053: aload 15
    //   5055: iconst_0
    //   5056: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5059: checkcast 633	com/android/vending/billing/InAppBillingService/LACK/CommandItem
    //   5062: getfield 699	com/android/vending/billing/InAppBillingService/LACK/CommandItem:index_command	[B
    //   5065: iconst_1
    //   5066: baload
    //   5067: invokestatic 705	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5070: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5073: aload 15
    //   5075: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   5078: astore 15
    //   5080: aload 15
    //   5082: invokeinterface 209 1 0
    //   5087: ifeq +162 -> 5249
    //   5090: aload 15
    //   5092: invokeinterface 213 1 0
    //   5097: checkcast 633	com/android/vending/billing/InAppBillingService/LACK/CommandItem
    //   5100: astore 16
    //   5102: aload 16
    //   5104: getfield 641	com/android/vending/billing/InAppBillingService/LACK/CommandItem:object	Ljava/lang/String;
    //   5107: ldc_w 620
    //   5110: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5113: ifeq -33 -> 5080
    //   5116: aload 16
    //   5118: getfield 708	com/android/vending/billing/InAppBillingService/LACK/CommandItem:found_index_command	Z
    //   5121: ifeq +99 -> 5220
    //   5124: getstatic 696	java/lang/System:out	Ljava/io/PrintStream;
    //   5127: ldc_w 710
    //   5130: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5133: aload 12
    //   5135: iconst_2
    //   5136: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5139: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5142: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   5145: iconst_2
    //   5146: aload 16
    //   5148: getfield 699	com/android/vending/billing/InAppBillingService/LACK/CommandItem:index_command	[B
    //   5151: iconst_0
    //   5152: baload
    //   5153: bastore
    //   5154: aload 12
    //   5156: iconst_2
    //   5157: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5160: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5163: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   5166: iconst_3
    //   5167: aload 16
    //   5169: getfield 699	com/android/vending/billing/InAppBillingService/LACK/CommandItem:index_command	[B
    //   5172: iconst_1
    //   5173: baload
    //   5174: bastore
    //   5175: aload 12
    //   5177: iconst_3
    //   5178: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5181: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5184: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   5187: iconst_2
    //   5188: aload 16
    //   5190: getfield 699	com/android/vending/billing/InAppBillingService/LACK/CommandItem:index_command	[B
    //   5193: iconst_0
    //   5194: baload
    //   5195: bastore
    //   5196: aload 12
    //   5198: iconst_3
    //   5199: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5202: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5205: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   5208: iconst_3
    //   5209: aload 16
    //   5211: getfield 699	com/android/vending/billing/InAppBillingService/LACK/CommandItem:index_command	[B
    //   5214: iconst_1
    //   5215: baload
    //   5216: bastore
    //   5217: goto -137 -> 5080
    //   5220: aload 12
    //   5222: iconst_2
    //   5223: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5226: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5229: iconst_0
    //   5230: putfield 685	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:pattern	Z
    //   5233: aload 12
    //   5235: iconst_3
    //   5236: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5239: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5242: iconst_0
    //   5243: putfield 685	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:pattern	Z
    //   5246: goto -166 -> 5080
    //   5249: iload_3
    //   5250: ifne +42 -> 5292
    //   5253: aload 12
    //   5255: iconst_0
    //   5256: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5259: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5262: iconst_0
    //   5263: putfield 685	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:pattern	Z
    //   5266: aload 12
    //   5268: iconst_1
    //   5269: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5272: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5275: iconst_0
    //   5276: putfield 685	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:pattern	Z
    //   5279: aload 12
    //   5281: iconst_2
    //   5282: invokevirtual 677	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5285: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5288: iconst_0
    //   5289: putfield 685	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:pattern	Z
    //   5292: aload 12
    //   5294: invokevirtual 200	java/util/ArrayList:size	()I
    //   5297: anewarray 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5300: astore 15
    //   5302: iconst_0
    //   5303: istore_3
    //   5304: aload 12
    //   5306: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   5309: astore 16
    //   5311: aload 16
    //   5313: invokeinterface 209 1 0
    //   5318: ifeq +24 -> 5342
    //   5321: aload 15
    //   5323: iload_3
    //   5324: aload 16
    //   5326: invokeinterface 213 1 0
    //   5331: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5334: aastore
    //   5335: iload_3
    //   5336: iconst_1
    //   5337: iadd
    //   5338: istore_3
    //   5339: goto -28 -> 5311
    //   5342: iconst_0
    //   5343: istore_3
    //   5344: getstatic 45	com/chelpus/root/utils/runpatchads:fileblock	Z
    //   5347: ifeq +34 -> 5381
    //   5350: ldc_w 624
    //   5353: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   5356: pop
    //   5357: getstatic 270	com/chelpus/root/utils/runpatchads:print	Ljava/io/PrintStream;
    //   5360: ldc_w 624
    //   5363: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5366: aload 14
    //   5368: invokevirtual 627	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5371: getstatic 562	com/chelpus/root/utils/runpatchads:sites	[[B
    //   5374: iconst_0
    //   5375: bipush 64
    //   5377: invokestatic 714	com/chelpus/Utils:setStringIds	(Ljava/lang/String;[[BZB)I
    //   5380: istore_3
    //   5381: iload_3
    //   5382: ifle +26 -> 5408
    //   5385: iload_3
    //   5386: iconst_1
    //   5387: isub
    //   5388: istore_3
    //   5389: ldc_w 716
    //   5392: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   5395: pop
    //   5396: getstatic 270	com/chelpus/root/utils/runpatchads:print	Ljava/io/PrintStream;
    //   5399: ldc_w 716
    //   5402: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5405: goto -24 -> 5381
    //   5408: new 159	java/lang/StringBuilder
    //   5411: dup
    //   5412: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   5415: ldc_w 718
    //   5418: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5421: aload 14
    //   5423: invokevirtual 627	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5426: iconst_1
    //   5427: anewarray 297	java/lang/String
    //   5430: dup
    //   5431: iconst_0
    //   5432: ldc_w 720
    //   5435: aastore
    //   5436: iconst_0
    //   5437: iconst_1
    //   5438: anewarray 297	java/lang/String
    //   5441: dup
    //   5442: iconst_0
    //   5443: ldc_w 722
    //   5446: aastore
    //   5447: invokestatic 726	com/chelpus/Utils:replaceStringIds	(Ljava/lang/String;[Ljava/lang/String;Z[Ljava/lang/String;)I
    //   5450: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5453: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5456: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   5459: pop
    //   5460: invokestatic 729	java/lang/System:currentTimeMillis	()J
    //   5463: lstore 9
    //   5465: new 731	java/io/RandomAccessFile
    //   5468: dup
    //   5469: aload 14
    //   5471: ldc_w 733
    //   5474: invokespecial 736	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   5477: invokevirtual 740	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   5480: astore 14
    //   5482: new 159	java/lang/StringBuilder
    //   5485: dup
    //   5486: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   5489: ldc_w 742
    //   5492: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5495: aload 14
    //   5497: invokevirtual 746	java/nio/channels/FileChannel:size	()J
    //   5500: invokevirtual 749	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5503: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5506: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   5509: pop
    //   5510: aload 14
    //   5512: getstatic 755	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   5515: lconst_0
    //   5516: aload 14
    //   5518: invokevirtual 746	java/nio/channels/FileChannel:size	()J
    //   5521: l2i
    //   5522: i2l
    //   5523: invokevirtual 759	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   5526: astore 16
    //   5528: iconst_0
    //   5529: istore_3
    //   5530: iconst_0
    //   5531: istore 5
    //   5533: aload 16
    //   5535: invokevirtual 762	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   5538: ifeq +488 -> 6026
    //   5541: iload 5
    //   5543: istore 4
    //   5545: getstatic 43	com/chelpus/root/utils/runpatchads:createAPK	Z
    //   5548: ifne +56 -> 5604
    //   5551: iload 5
    //   5553: istore 4
    //   5555: aload 16
    //   5557: invokevirtual 764	java/nio/MappedByteBuffer:position	()I
    //   5560: iload 5
    //   5562: isub
    //   5563: ldc_w 765
    //   5566: if_icmple +38 -> 5604
    //   5569: new 159	java/lang/StringBuilder
    //   5572: dup
    //   5573: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   5576: ldc_w 767
    //   5579: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5582: aload 16
    //   5584: invokevirtual 764	java/nio/MappedByteBuffer:position	()I
    //   5587: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5590: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5593: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   5596: pop
    //   5597: aload 16
    //   5599: invokevirtual 764	java/nio/MappedByteBuffer:position	()I
    //   5602: istore 4
    //   5604: aload 16
    //   5606: invokevirtual 764	java/nio/MappedByteBuffer:position	()I
    //   5609: istore 8
    //   5611: aload 16
    //   5613: invokevirtual 110	java/nio/MappedByteBuffer:get	()B
    //   5616: istore_2
    //   5617: iconst_0
    //   5618: istore 5
    //   5620: iload_3
    //   5621: istore 6
    //   5623: iload 5
    //   5625: aload 15
    //   5627: arraylength
    //   5628: if_icmpge +916 -> 6544
    //   5631: aload 15
    //   5633: iload 5
    //   5635: aaload
    //   5636: astore 17
    //   5638: aload 16
    //   5640: iload 8
    //   5642: invokevirtual 106	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   5645: pop
    //   5646: iload 6
    //   5648: istore_3
    //   5649: aload 17
    //   5651: getfield 770	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:markerTrig	Z
    //   5654: ifeq +441 -> 6095
    //   5657: iload 6
    //   5659: istore_3
    //   5660: iload 5
    //   5662: iconst_2
    //   5663: if_icmpne +432 -> 6095
    //   5666: iload 6
    //   5668: iconst_1
    //   5669: iadd
    //   5670: istore 7
    //   5672: iload 7
    //   5674: sipush 574
    //   5677: if_icmpge +770 -> 6447
    //   5680: iload 7
    //   5682: istore_3
    //   5683: iload_2
    //   5684: aload 17
    //   5686: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   5689: iconst_0
    //   5690: baload
    //   5691: if_icmpne +394 -> 6085
    //   5694: aload 17
    //   5696: getfield 774	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repMask	[I
    //   5699: iconst_0
    //   5700: iaload
    //   5701: ifne +11 -> 5712
    //   5704: aload 17
    //   5706: getfield 777	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repByte	[B
    //   5709: iconst_0
    //   5710: iload_2
    //   5711: bastore
    //   5712: iconst_1
    //   5713: istore 6
    //   5715: aload 16
    //   5717: iload 8
    //   5719: iconst_1
    //   5720: iadd
    //   5721: invokevirtual 106	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   5724: pop
    //   5725: aload 16
    //   5727: invokevirtual 110	java/nio/MappedByteBuffer:get	()B
    //   5730: istore_1
    //   5731: iload_1
    //   5732: aload 17
    //   5734: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   5737: iload 6
    //   5739: baload
    //   5740: if_icmpeq +57 -> 5797
    //   5743: aload 17
    //   5745: getfield 780	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origMask	[I
    //   5748: iload 6
    //   5750: iaload
    //   5751: iconst_1
    //   5752: if_icmpeq +45 -> 5797
    //   5755: aload 17
    //   5757: getfield 780	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origMask	[I
    //   5760: iload 6
    //   5762: iaload
    //   5763: bipush 20
    //   5765: if_icmpeq +32 -> 5797
    //   5768: aload 17
    //   5770: getfield 780	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origMask	[I
    //   5773: iload 6
    //   5775: iaload
    //   5776: bipush 21
    //   5778: if_icmpeq +19 -> 5797
    //   5781: iload 7
    //   5783: istore_3
    //   5784: aload 17
    //   5786: getfield 780	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origMask	[I
    //   5789: iload 6
    //   5791: iaload
    //   5792: bipush 23
    //   5794: if_icmpne +291 -> 6085
    //   5797: aload 17
    //   5799: getfield 774	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repMask	[I
    //   5802: iload 6
    //   5804: iaload
    //   5805: ifne +12 -> 5817
    //   5808: aload 17
    //   5810: getfield 777	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repByte	[B
    //   5813: iload 6
    //   5815: iload_1
    //   5816: bastore
    //   5817: aload 17
    //   5819: getfield 774	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repMask	[I
    //   5822: iload 6
    //   5824: iaload
    //   5825: bipush 20
    //   5827: if_icmpne +16 -> 5843
    //   5830: aload 17
    //   5832: getfield 777	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repByte	[B
    //   5835: iload 6
    //   5837: iload_1
    //   5838: bipush 15
    //   5840: iand
    //   5841: i2b
    //   5842: bastore
    //   5843: aload 17
    //   5845: getfield 774	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repMask	[I
    //   5848: iload 6
    //   5850: iaload
    //   5851: bipush 21
    //   5853: if_icmpne +19 -> 5872
    //   5856: aload 17
    //   5858: getfield 777	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repByte	[B
    //   5861: iload 6
    //   5863: iload_1
    //   5864: bipush 15
    //   5866: iand
    //   5867: bipush 16
    //   5869: iadd
    //   5870: i2b
    //   5871: bastore
    //   5872: iload 6
    //   5874: iconst_1
    //   5875: iadd
    //   5876: istore 6
    //   5878: iload 6
    //   5880: aload 17
    //   5882: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   5885: arraylength
    //   5886: if_icmpne +552 -> 6438
    //   5889: aload 16
    //   5891: iload 8
    //   5893: invokevirtual 106	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   5896: pop
    //   5897: aload 16
    //   5899: aload 17
    //   5901: getfield 777	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repByte	[B
    //   5904: invokevirtual 114	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   5907: pop
    //   5908: aload 16
    //   5910: invokevirtual 118	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   5913: pop
    //   5914: aload 17
    //   5916: getfield 783	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:resultText	Ljava/lang/String;
    //   5919: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   5922: pop
    //   5923: getstatic 270	com/chelpus/root/utils/runpatchads:print	Ljava/io/PrintStream;
    //   5926: aload 17
    //   5928: getfield 783	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:resultText	Ljava/lang/String;
    //   5931: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5934: aload 17
    //   5936: iconst_1
    //   5937: putfield 785	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:result	Z
    //   5940: aload 17
    //   5942: iconst_0
    //   5943: putfield 770	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:markerTrig	Z
    //   5946: aload 12
    //   5948: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   5951: astore 18
    //   5953: aload 18
    //   5955: invokeinterface 209 1 0
    //   5960: ifeq +113 -> 6073
    //   5963: aload 18
    //   5965: invokeinterface 213 1 0
    //   5970: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   5973: astore 19
    //   5975: aload 19
    //   5977: getfield 788	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:marker	Ljava/lang/String;
    //   5980: aload 17
    //   5982: getfield 788	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:marker	Ljava/lang/String;
    //   5985: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5988: ifeq -35 -> 5953
    //   5991: aload 19
    //   5993: iconst_0
    //   5994: putfield 770	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:markerTrig	Z
    //   5997: goto -44 -> 5953
    //   6000: astore 15
    //   6002: new 159	java/lang/StringBuilder
    //   6005: dup
    //   6006: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   6009: ldc 73
    //   6011: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6014: aload 15
    //   6016: invokevirtual 791	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6019: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6022: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   6025: pop
    //   6026: aload 14
    //   6028: invokevirtual 792	java/nio/channels/FileChannel:close	()V
    //   6031: new 159	java/lang/StringBuilder
    //   6034: dup
    //   6035: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   6038: ldc 73
    //   6040: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6043: invokestatic 729	java/lang/System:currentTimeMillis	()J
    //   6046: lload 9
    //   6048: lsub
    //   6049: ldc2_w 793
    //   6052: ldiv
    //   6053: invokevirtual 749	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6056: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6059: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   6062: pop
    //   6063: ldc_w 796
    //   6066: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   6069: pop
    //   6070: goto -1813 -> 4257
    //   6073: iconst_0
    //   6074: istore_3
    //   6075: aload 16
    //   6077: iload 8
    //   6079: iconst_1
    //   6080: iadd
    //   6081: invokevirtual 106	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   6084: pop
    //   6085: aload 16
    //   6087: iload 8
    //   6089: iconst_1
    //   6090: iadd
    //   6091: invokevirtual 106	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   6094: pop
    //   6095: aload 17
    //   6097: getfield 770	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:markerTrig	Z
    //   6100: ifne +600 -> 6700
    //   6103: iload_2
    //   6104: aload 17
    //   6106: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   6109: iconst_0
    //   6110: baload
    //   6111: if_icmpne +589 -> 6700
    //   6114: aload 17
    //   6116: getfield 685	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:pattern	Z
    //   6119: ifeq +581 -> 6700
    //   6122: aload 17
    //   6124: getfield 774	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repMask	[I
    //   6127: iconst_0
    //   6128: iaload
    //   6129: ifne +11 -> 6140
    //   6132: aload 17
    //   6134: getfield 777	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repByte	[B
    //   6137: iconst_0
    //   6138: iload_2
    //   6139: bastore
    //   6140: iconst_1
    //   6141: istore 6
    //   6143: aload 16
    //   6145: iload 8
    //   6147: iconst_1
    //   6148: iadd
    //   6149: invokevirtual 106	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   6152: pop
    //   6153: aload 16
    //   6155: invokevirtual 110	java/nio/MappedByteBuffer:get	()B
    //   6158: istore_1
    //   6159: iload_1
    //   6160: aload 17
    //   6162: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   6165: iload 6
    //   6167: baload
    //   6168: if_icmpeq +54 -> 6222
    //   6171: aload 17
    //   6173: getfield 780	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origMask	[I
    //   6176: iload 6
    //   6178: iaload
    //   6179: iconst_1
    //   6180: if_icmpeq +42 -> 6222
    //   6183: aload 17
    //   6185: getfield 780	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origMask	[I
    //   6188: iload 6
    //   6190: iaload
    //   6191: bipush 20
    //   6193: if_icmpeq +29 -> 6222
    //   6196: aload 17
    //   6198: getfield 780	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origMask	[I
    //   6201: iload 6
    //   6203: iaload
    //   6204: bipush 21
    //   6206: if_icmpeq +16 -> 6222
    //   6209: aload 17
    //   6211: getfield 780	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origMask	[I
    //   6214: iload 6
    //   6216: iaload
    //   6217: bipush 23
    //   6219: if_icmpne +312 -> 6531
    //   6222: aload 17
    //   6224: getfield 774	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repMask	[I
    //   6227: iload 6
    //   6229: iaload
    //   6230: ifne +12 -> 6242
    //   6233: aload 17
    //   6235: getfield 777	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repByte	[B
    //   6238: iload 6
    //   6240: iload_1
    //   6241: bastore
    //   6242: aload 17
    //   6244: getfield 774	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repMask	[I
    //   6247: iload 6
    //   6249: iaload
    //   6250: bipush 20
    //   6252: if_icmpne +16 -> 6268
    //   6255: aload 17
    //   6257: getfield 777	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repByte	[B
    //   6260: iload 6
    //   6262: iload_1
    //   6263: bipush 15
    //   6265: iand
    //   6266: i2b
    //   6267: bastore
    //   6268: aload 17
    //   6270: getfield 774	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repMask	[I
    //   6273: iload 6
    //   6275: iaload
    //   6276: bipush 21
    //   6278: if_icmpne +19 -> 6297
    //   6281: aload 17
    //   6283: getfield 777	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repByte	[B
    //   6286: iload 6
    //   6288: iload_1
    //   6289: bipush 15
    //   6291: iand
    //   6292: bipush 16
    //   6294: iadd
    //   6295: i2b
    //   6296: bastore
    //   6297: iload 6
    //   6299: iconst_1
    //   6300: iadd
    //   6301: istore 6
    //   6303: iload 6
    //   6305: aload 17
    //   6307: getfield 682	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:origByte	[B
    //   6310: arraylength
    //   6311: if_icmpne +211 -> 6522
    //   6314: aload 16
    //   6316: iload 8
    //   6318: invokevirtual 106	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   6321: pop
    //   6322: aload 16
    //   6324: aload 17
    //   6326: getfield 777	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:repByte	[B
    //   6329: invokevirtual 114	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   6332: pop
    //   6333: aload 16
    //   6335: invokevirtual 118	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   6338: pop
    //   6339: aload 17
    //   6341: getfield 783	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:resultText	Ljava/lang/String;
    //   6344: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   6347: pop
    //   6348: getstatic 270	com/chelpus/root/utils/runpatchads:print	Ljava/io/PrintStream;
    //   6351: aload 17
    //   6353: getfield 783	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:resultText	Ljava/lang/String;
    //   6356: invokevirtual 275	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   6359: aload 17
    //   6361: iconst_1
    //   6362: putfield 785	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:result	Z
    //   6365: aload 17
    //   6367: getfield 788	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:marker	Ljava/lang/String;
    //   6370: ldc 73
    //   6372: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6375: ifne +156 -> 6531
    //   6378: aload 17
    //   6380: iconst_1
    //   6381: putfield 770	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:markerTrig	Z
    //   6384: aload 12
    //   6386: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   6389: astore 18
    //   6391: aload 18
    //   6393: invokeinterface 209 1 0
    //   6398: ifeq +133 -> 6531
    //   6401: aload 18
    //   6403: invokeinterface 213 1 0
    //   6408: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   6411: astore 19
    //   6413: aload 19
    //   6415: getfield 788	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:marker	Ljava/lang/String;
    //   6418: aload 17
    //   6420: getfield 788	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:marker	Ljava/lang/String;
    //   6423: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6426: ifeq -35 -> 6391
    //   6429: aload 19
    //   6431: iconst_1
    //   6432: putfield 770	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:markerTrig	Z
    //   6435: goto -44 -> 6391
    //   6438: aload 16
    //   6440: invokevirtual 110	java/nio/MappedByteBuffer:get	()B
    //   6443: istore_1
    //   6444: goto -713 -> 5731
    //   6447: aload 17
    //   6449: iconst_0
    //   6450: putfield 770	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:markerTrig	Z
    //   6453: aload 12
    //   6455: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   6458: astore 18
    //   6460: aload 18
    //   6462: invokeinterface 209 1 0
    //   6467: ifeq +40 -> 6507
    //   6470: aload 18
    //   6472: invokeinterface 213 1 0
    //   6477: checkcast 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto
    //   6480: astore 19
    //   6482: aload 19
    //   6484: getfield 788	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:marker	Ljava/lang/String;
    //   6487: aload 17
    //   6489: getfield 788	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:marker	Ljava/lang/String;
    //   6492: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6495: ifeq -35 -> 6460
    //   6498: aload 19
    //   6500: iconst_0
    //   6501: putfield 770	com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto:markerTrig	Z
    //   6504: goto -44 -> 6460
    //   6507: iconst_0
    //   6508: istore_3
    //   6509: aload 16
    //   6511: iload 8
    //   6513: iconst_1
    //   6514: iadd
    //   6515: invokevirtual 106	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   6518: pop
    //   6519: goto -424 -> 6095
    //   6522: aload 16
    //   6524: invokevirtual 110	java/nio/MappedByteBuffer:get	()B
    //   6527: istore_1
    //   6528: goto -369 -> 6159
    //   6531: aload 16
    //   6533: iload 8
    //   6535: iconst_1
    //   6536: iadd
    //   6537: invokevirtual 106	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   6540: pop
    //   6541: goto +159 -> 6700
    //   6544: iload 4
    //   6546: istore 5
    //   6548: iload 6
    //   6550: istore_3
    //   6551: iconst_0
    //   6552: ifne -1019 -> 5533
    //   6555: aload 16
    //   6557: iload 8
    //   6559: iconst_1
    //   6560: iadd
    //   6561: invokevirtual 106	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   6564: pop
    //   6565: iload 4
    //   6567: istore 5
    //   6569: iload 6
    //   6571: istore_3
    //   6572: goto -1039 -> 5533
    //   6575: getstatic 43	com/chelpus/root/utils/runpatchads:createAPK	Z
    //   6578: ifne +84 -> 6662
    //   6581: aload_0
    //   6582: iconst_3
    //   6583: aaload
    //   6584: getstatic 96	com/chelpus/root/utils/runpatchads:classesFiles	Ljava/util/ArrayList;
    //   6587: aload_0
    //   6588: iconst_2
    //   6589: aaload
    //   6590: getstatic 75	com/chelpus/root/utils/runpatchads:uid	Ljava/lang/String;
    //   6593: aload_0
    //   6594: iconst_2
    //   6595: aaload
    //   6596: getstatic 75	com/chelpus/root/utils/runpatchads:uid	Ljava/lang/String;
    //   6599: invokestatic 800	com/chelpus/Utils:getOdexForCreate	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6602: invokestatic 804	com/chelpus/Utils:create_ODEX_root	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   6605: istore_3
    //   6606: new 159	java/lang/StringBuilder
    //   6609: dup
    //   6610: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   6613: ldc_w 806
    //   6616: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6619: iload_3
    //   6620: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6623: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6626: invokestatic 124	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   6629: pop
    //   6630: iload_3
    //   6631: ifne +31 -> 6662
    //   6634: getstatic 65	com/chelpus/root/utils/runpatchads:ART	Z
    //   6637: ifne +25 -> 6662
    //   6640: aload_0
    //   6641: iconst_1
    //   6642: aaload
    //   6643: aload_0
    //   6644: iconst_2
    //   6645: aaload
    //   6646: aload_0
    //   6647: iconst_2
    //   6648: aaload
    //   6649: iconst_1
    //   6650: invokestatic 610	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   6653: getstatic 75	com/chelpus/root/utils/runpatchads:uid	Ljava/lang/String;
    //   6656: aload_0
    //   6657: iconst_3
    //   6658: aaload
    //   6659: invokestatic 810	com/chelpus/Utils:afterPatch	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6662: getstatic 43	com/chelpus/root/utils/runpatchads:createAPK	Z
    //   6665: ifne +6 -> 6671
    //   6668: invokestatic 813	com/chelpus/Utils:exitFromRootJava	()V
    //   6671: aload 11
    //   6673: getfield 816	com/android/vending/billing/InAppBillingService/LACK/LogOutputStream:allresult	Ljava/lang/String;
    //   6676: putstatic 818	com/chelpus/root/utils/runpatchads:result	Ljava/lang/String;
    //   6679: return
    //   6680: astore 13
    //   6682: goto -6189 -> 493
    //   6685: astore 13
    //   6687: goto -6194 -> 493
    //   6690: astore 13
    //   6692: goto -6215 -> 477
    //   6695: iconst_1
    //   6696: istore_3
    //   6697: goto -2309 -> 4388
    //   6700: iload 5
    //   6702: iconst_1
    //   6703: iadd
    //   6704: istore 5
    //   6706: iload_3
    //   6707: istore 6
    //   6709: goto -1086 -> 5623
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6712	0	paramArrayOfString	String[]
    //   5730	798	1	i	int
    //   5616	523	2	j	int
    //   132	6575	3	k	int
    //   129	6437	4	m	int
    //   5531	1174	5	n	int
    //   5621	1087	6	i1	int
    //   5670	112	7	i2	int
    //   5609	952	8	i3	int
    //   5463	584	9	l	long
    //   10	6662	11	localLogOutputStream	com.android.vending.billing.InAppBillingService.LACK.LogOutputStream
    //   63	3376	12	localArrayList	ArrayList
    //   3856	1	12	localFileNotFoundException	java.io.FileNotFoundException
    //   3871	13	12	localIterator	Iterator
    //   4102	2352	12	localException1	Exception
    //   124	16	13	arrayOfFile	File[]
    //   208	3	13	localException2	Exception
    //   513	3316	13	localObject1	Object
    //   3912	1	13	localNullPointerException1	NullPointerException
    //   4062	707	13	localObject2	Object
    //   6680	1	13	localException3	Exception
    //   6685	1	13	localNullPointerException2	NullPointerException
    //   6690	1	13	localException4	Exception
    //   143	3350	14	localObject3	Object
    //   3554	3	14	localException5	Exception
    //   3580	11	14	localFileInputStream	FileInputStream
    //   3646	397	14	localException6	Exception
    //   4084	1943	14	localObject4	Object
    //   531	5101	15	localObject5	Object
    //   6000	15	15	localException7	Exception
    //   540	6016	16	localObject6	Object
    //   549	5939	17	localObject7	Object
    //   558	5913	18	localObject8	Object
    //   567	5932	19	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   111	131	208	java/lang/Exception
    //   145	201	208	java/lang/Exception
    //   3465	3508	3554	java/lang/Exception
    //   3508	3515	3554	java/lang/Exception
    //   3520	3551	3554	java/lang/Exception
    //   4034	4039	3554	java/lang/Exception
    //   3561	3600	3646	java/lang/Exception
    //   3600	3607	3646	java/lang/Exception
    //   3612	3643	3646	java/lang/Exception
    //   4042	4047	3646	java/lang/Exception
    //   3689	3708	3856	java/io/FileNotFoundException
    //   3708	3751	3856	java/io/FileNotFoundException
    //   3751	3767	3856	java/io/FileNotFoundException
    //   3767	3780	3856	java/io/FileNotFoundException
    //   3785	3848	3856	java/io/FileNotFoundException
    //   3848	3856	3856	java/io/FileNotFoundException
    //   4050	4064	3856	java/io/FileNotFoundException
    //   4064	4102	3856	java/io/FileNotFoundException
    //   4135	4144	3856	java/io/FileNotFoundException
    //   4147	4181	3856	java/io/FileNotFoundException
    //   4181	4215	3856	java/io/FileNotFoundException
    //   4215	4249	3856	java/io/FileNotFoundException
    //   4249	4257	3856	java/io/FileNotFoundException
    //   4257	4351	3856	java/io/FileNotFoundException
    //   4353	4388	3856	java/io/FileNotFoundException
    //   4388	4417	3856	java/io/FileNotFoundException
    //   4417	4465	3856	java/io/FileNotFoundException
    //   4465	4491	3856	java/io/FileNotFoundException
    //   4494	4500	3856	java/io/FileNotFoundException
    //   4505	4603	3856	java/io/FileNotFoundException
    //   4603	4611	3856	java/io/FileNotFoundException
    //   4611	4625	3856	java/io/FileNotFoundException
    //   4625	4663	3856	java/io/FileNotFoundException
    //   4663	4672	3856	java/io/FileNotFoundException
    //   4675	4688	3856	java/io/FileNotFoundException
    //   4693	4736	3856	java/io/FileNotFoundException
    //   4736	4744	3856	java/io/FileNotFoundException
    //   4744	4758	3856	java/io/FileNotFoundException
    //   4758	4796	3856	java/io/FileNotFoundException
    //   4796	4805	3856	java/io/FileNotFoundException
    //   4808	4885	3856	java/io/FileNotFoundException
    //   4888	4985	3856	java/io/FileNotFoundException
    //   4992	4998	3856	java/io/FileNotFoundException
    //   4998	5080	3856	java/io/FileNotFoundException
    //   5080	5217	3856	java/io/FileNotFoundException
    //   5220	5246	3856	java/io/FileNotFoundException
    //   5253	5292	3856	java/io/FileNotFoundException
    //   5292	5302	3856	java/io/FileNotFoundException
    //   5304	5311	3856	java/io/FileNotFoundException
    //   5311	5335	3856	java/io/FileNotFoundException
    //   5344	5381	3856	java/io/FileNotFoundException
    //   5389	5405	3856	java/io/FileNotFoundException
    //   5408	5528	3856	java/io/FileNotFoundException
    //   5533	5541	3856	java/io/FileNotFoundException
    //   5545	5551	3856	java/io/FileNotFoundException
    //   5555	5604	3856	java/io/FileNotFoundException
    //   5604	5617	3856	java/io/FileNotFoundException
    //   5623	5631	3856	java/io/FileNotFoundException
    //   5638	5646	3856	java/io/FileNotFoundException
    //   5649	5657	3856	java/io/FileNotFoundException
    //   5683	5712	3856	java/io/FileNotFoundException
    //   5715	5731	3856	java/io/FileNotFoundException
    //   5731	5781	3856	java/io/FileNotFoundException
    //   5784	5797	3856	java/io/FileNotFoundException
    //   5797	5817	3856	java/io/FileNotFoundException
    //   5817	5843	3856	java/io/FileNotFoundException
    //   5843	5872	3856	java/io/FileNotFoundException
    //   5878	5953	3856	java/io/FileNotFoundException
    //   5953	5997	3856	java/io/FileNotFoundException
    //   6002	6026	3856	java/io/FileNotFoundException
    //   6026	6070	3856	java/io/FileNotFoundException
    //   6075	6085	3856	java/io/FileNotFoundException
    //   6085	6095	3856	java/io/FileNotFoundException
    //   6095	6140	3856	java/io/FileNotFoundException
    //   6143	6159	3856	java/io/FileNotFoundException
    //   6159	6222	3856	java/io/FileNotFoundException
    //   6222	6242	3856	java/io/FileNotFoundException
    //   6242	6268	3856	java/io/FileNotFoundException
    //   6268	6297	3856	java/io/FileNotFoundException
    //   6303	6391	3856	java/io/FileNotFoundException
    //   6391	6435	3856	java/io/FileNotFoundException
    //   6438	6444	3856	java/io/FileNotFoundException
    //   6447	6460	3856	java/io/FileNotFoundException
    //   6460	6504	3856	java/io/FileNotFoundException
    //   6509	6519	3856	java/io/FileNotFoundException
    //   6522	6528	3856	java/io/FileNotFoundException
    //   6531	6541	3856	java/io/FileNotFoundException
    //   6555	6565	3856	java/io/FileNotFoundException
    //   215	231	3912	java/lang/NullPointerException
    //   231	247	3912	java/lang/NullPointerException
    //   247	263	3912	java/lang/NullPointerException
    //   263	279	3912	java/lang/NullPointerException
    //   279	295	3912	java/lang/NullPointerException
    //   295	311	3912	java/lang/NullPointerException
    //   311	327	3912	java/lang/NullPointerException
    //   327	343	3912	java/lang/NullPointerException
    //   343	359	3912	java/lang/NullPointerException
    //   366	383	3912	java/lang/NullPointerException
    //   390	407	3912	java/lang/NullPointerException
    //   414	422	3912	java/lang/NullPointerException
    //   429	463	3912	java/lang/NullPointerException
    //   470	477	3912	java/lang/NullPointerException
    //   3902	3909	3912	java/lang/NullPointerException
    //   3689	3708	4102	java/lang/Exception
    //   3708	3751	4102	java/lang/Exception
    //   3751	3767	4102	java/lang/Exception
    //   3767	3780	4102	java/lang/Exception
    //   3785	3848	4102	java/lang/Exception
    //   3848	3856	4102	java/lang/Exception
    //   4050	4064	4102	java/lang/Exception
    //   4064	4102	4102	java/lang/Exception
    //   4135	4144	4102	java/lang/Exception
    //   4147	4181	4102	java/lang/Exception
    //   4181	4215	4102	java/lang/Exception
    //   4215	4249	4102	java/lang/Exception
    //   4249	4257	4102	java/lang/Exception
    //   4257	4351	4102	java/lang/Exception
    //   4353	4388	4102	java/lang/Exception
    //   4388	4417	4102	java/lang/Exception
    //   4417	4465	4102	java/lang/Exception
    //   4465	4491	4102	java/lang/Exception
    //   4494	4500	4102	java/lang/Exception
    //   4505	4603	4102	java/lang/Exception
    //   4603	4611	4102	java/lang/Exception
    //   4611	4625	4102	java/lang/Exception
    //   4625	4663	4102	java/lang/Exception
    //   4663	4672	4102	java/lang/Exception
    //   4675	4688	4102	java/lang/Exception
    //   4693	4736	4102	java/lang/Exception
    //   4736	4744	4102	java/lang/Exception
    //   4744	4758	4102	java/lang/Exception
    //   4758	4796	4102	java/lang/Exception
    //   4796	4805	4102	java/lang/Exception
    //   4808	4885	4102	java/lang/Exception
    //   4888	4985	4102	java/lang/Exception
    //   4992	4998	4102	java/lang/Exception
    //   4998	5080	4102	java/lang/Exception
    //   5080	5217	4102	java/lang/Exception
    //   5220	5246	4102	java/lang/Exception
    //   5253	5292	4102	java/lang/Exception
    //   5292	5302	4102	java/lang/Exception
    //   5304	5311	4102	java/lang/Exception
    //   5311	5335	4102	java/lang/Exception
    //   5344	5381	4102	java/lang/Exception
    //   5389	5405	4102	java/lang/Exception
    //   5408	5528	4102	java/lang/Exception
    //   6002	6026	4102	java/lang/Exception
    //   6026	6070	4102	java/lang/Exception
    //   5533	5541	6000	java/lang/Exception
    //   5545	5551	6000	java/lang/Exception
    //   5555	5604	6000	java/lang/Exception
    //   5604	5617	6000	java/lang/Exception
    //   5623	5631	6000	java/lang/Exception
    //   5638	5646	6000	java/lang/Exception
    //   5649	5657	6000	java/lang/Exception
    //   5683	5712	6000	java/lang/Exception
    //   5715	5731	6000	java/lang/Exception
    //   5731	5781	6000	java/lang/Exception
    //   5784	5797	6000	java/lang/Exception
    //   5797	5817	6000	java/lang/Exception
    //   5817	5843	6000	java/lang/Exception
    //   5843	5872	6000	java/lang/Exception
    //   5878	5953	6000	java/lang/Exception
    //   5953	5997	6000	java/lang/Exception
    //   6075	6085	6000	java/lang/Exception
    //   6085	6095	6000	java/lang/Exception
    //   6095	6140	6000	java/lang/Exception
    //   6143	6159	6000	java/lang/Exception
    //   6159	6222	6000	java/lang/Exception
    //   6222	6242	6000	java/lang/Exception
    //   6242	6268	6000	java/lang/Exception
    //   6268	6297	6000	java/lang/Exception
    //   6303	6391	6000	java/lang/Exception
    //   6391	6435	6000	java/lang/Exception
    //   6438	6444	6000	java/lang/Exception
    //   6447	6460	6000	java/lang/Exception
    //   6460	6504	6000	java/lang/Exception
    //   6509	6519	6000	java/lang/Exception
    //   6522	6528	6000	java/lang/Exception
    //   6531	6541	6000	java/lang/Exception
    //   6555	6565	6000	java/lang/Exception
    //   477	493	6680	java/lang/Exception
    //   477	493	6685	java/lang/NullPointerException
    //   215	231	6690	java/lang/Exception
    //   231	247	6690	java/lang/Exception
    //   247	263	6690	java/lang/Exception
    //   263	279	6690	java/lang/Exception
    //   279	295	6690	java/lang/Exception
    //   295	311	6690	java/lang/Exception
    //   311	327	6690	java/lang/Exception
    //   327	343	6690	java/lang/Exception
    //   343	359	6690	java/lang/Exception
    //   366	383	6690	java/lang/Exception
    //   390	407	6690	java/lang/Exception
    //   414	422	6690	java/lang/Exception
    //   429	463	6690	java/lang/Exception
    //   470	477	6690	java/lang/Exception
    //   3902	3909	6690	java/lang/Exception
  }
  
  public static void unzipART(File paramFile)
  {
    i = 0;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      ZipInputStream localZipInputStream = new ZipInputStream(localFileInputStream);
      Object localObject1 = localZipInputStream.getNextEntry();
      for (;;)
      {
        Object localObject3;
        if ((localObject1 != null) && (1 != 0))
        {
          localObject1 = ((ZipEntry)localObject1).getName();
          if ((((String)localObject1).toLowerCase().startsWith("classes")) && (((String)localObject1).endsWith(".dex")) && (!((String)localObject1).contains("/")))
          {
            localObject3 = new FileOutputStream(sddir + "/" + (String)localObject1);
            byte[] arrayOfByte = new byte['ࠀ'];
            for (;;)
            {
              int j = localZipInputStream.read(arrayOfByte);
              if (j == -1) {
                break;
              }
              ((FileOutputStream)localObject3).write(arrayOfByte, 0, j);
            }
          }
        }
        try
        {
          paramFile = new ZipFile(paramFile);
          paramFile.extractFile("classes.dex", sddir);
          classesFiles.add(new File(sddir + "/" + "classes.dex"));
          Utils.cmdParam(new String[] { "chmod", "777", sddir + "/" + "classes.dex" });
          paramFile.extractFile("AndroidManifest.xml", sddir);
          Utils.cmdParam(new String[] { "chmod", "777", sddir + "/" + "AndroidManifest.xml" });
          Utils.sendFromRoot("Exception e" + localException.toString());
          return;
          localZipInputStream.closeEntry();
          ((FileOutputStream)localObject3).close();
          classesFiles.add(new File(sddir + "/" + localException));
          Utils.cmdParam(new String[] { "chmod", "777", sddir + "/" + localException });
          if (localException.equals("AndroidManifest.xml"))
          {
            localObject2 = new FileOutputStream(sddir + "/" + "AndroidManifest.xml");
            localObject3 = new byte['ࠀ'];
            for (;;)
            {
              i = localZipInputStream.read((byte[])localObject3);
              if (i == -1) {
                break;
              }
              ((FileOutputStream)localObject2).write((byte[])localObject3, 0, i);
            }
            localZipInputStream.closeEntry();
            ((FileOutputStream)localObject2).close();
            Utils.cmdParam(new String[] { "chmod", "777", sddir + "/" + "AndroidManifest.xml" });
            i = 1;
            break label715;
            localZipInputStream.close();
            localFileInputStream.close();
            return;
            localObject2 = localZipInputStream.getNextEntry();
          }
        }
        catch (ZipException paramFile)
        {
          for (;;)
          {
            Utils.sendFromRoot("Error classes.dex decompress! " + paramFile);
            Utils.sendFromRoot("Exception e1" + ((Exception)localObject2).toString());
          }
        }
        catch (Exception paramFile)
        {
          for (;;)
          {
            Object localObject2;
            Utils.sendFromRoot("Error classes.dex decompress! " + paramFile);
            Utils.sendFromRoot("Exception e1" + ((Exception)localObject2).toString());
            continue;
            if ((0 == 0) || (i == 0)) {}
          }
        }
      }
    }
    catch (Exception localException) {}
  }
  
  public static void unzipSD(File paramFile)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      localZipInputStream = new ZipInputStream(localFileInputStream);
      do
      {
        localZipEntry = localZipInputStream.getNextEntry();
        if (localZipEntry == null) {
          break;
        }
      } while ((!localZipEntry.getName().toLowerCase().startsWith("classes")) || (!localZipEntry.getName().endsWith(".dex")) || (localZipEntry.getName().contains("/")));
      localFileOutputStream = new FileOutputStream(sddir + "/Modified/" + localZipEntry.getName());
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = localZipInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          new ZipFile(paramFile).extractFile("classes.dex", sddir + "/Modified/");
          classesFiles.add(new File(sddir + "/Modified/" + "classes.dex"));
          return;
        }
        catch (ZipException paramFile)
        {
          ZipInputStream localZipInputStream;
          ZipEntry localZipEntry;
          FileOutputStream localFileOutputStream;
          Utils.sendFromRoot("Error classes.dex decompress! " + paramFile);
          Utils.sendFromRoot("Exception e1" + localException.toString());
          return;
        }
        catch (Exception paramFile)
        {
          Utils.sendFromRoot("Error classes.dex decompress! " + paramFile);
          Utils.sendFromRoot("Exception e1" + localException.toString());
        }
        localZipInputStream.closeEntry();
        localFileOutputStream.close();
        classesFiles.add(new File(sddir + "/Modified/" + localZipEntry.getName()));
        continue;
        localZipInputStream.close();
        localException.close();
        return;
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/runpatchads.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */