package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.AddFilesItem;
import com.android.vending.billing.InAppBillingService.LACK.PatchesItem;
import com.android.vending.billing.InAppBillingService.LACK.SearchItem;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public class createapkcustom
{
  static final int BUFFER = 2048;
  private static final int all = 4;
  public static String appdir;
  private static final int armeabi = 0;
  private static final int armeabiv7a = 1;
  private static final int beginTag = 0;
  public static ArrayList<File> classesFiles;
  private static final int classesTag = 1;
  public static File crkapk;
  public static String dir;
  public static String dir2;
  private static final int endTag = 4;
  private static final int fileInApkTag = 10;
  public static boolean goodResult = false;
  private static String group;
  private static final int libTagALL = 2;
  private static final int libTagARMEABI = 6;
  private static final int libTagARMEABIV7A = 7;
  private static final int libTagMIPS = 8;
  private static final int libTagx86 = 9;
  private static ArrayList<String> libs;
  public static File localFile2;
  public static boolean manualpatch = false;
  private static final int mips = 2;
  public static boolean multidex = false;
  public static boolean multilib_patch = false;
  public static String packageName;
  private static final int packageTag = 5;
  private static ArrayList<PatchesItem> pat = null;
  public static ArrayList<String> patchedLibs;
  public static boolean patchteil = false;
  private static PrintStream print;
  public static String sddir;
  private static ArrayList<Byte> search;
  private static String searchStr = "";
  private static ArrayList<SearchItem> ser = null;
  public static int tag = 0;
  public static String tooldir;
  public static boolean unpack = false;
  private static final int x86 = 3;
  
  static
  {
    search = null;
    patchteil = false;
    unpack = false;
    manualpatch = false;
    dir = "/sdcard/";
    dir2 = "/sdcard/";
    sddir = "/sdcard/";
    appdir = "/sdcard/";
    tooldir = "/sdcard/";
    packageName = "";
    libs = new ArrayList();
    patchedLibs = new ArrayList();
    group = "";
    classesFiles = new ArrayList();
    multidex = false;
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
      print.println("" + localException.toString());
    }
  }
  
  public static String extractFile(File paramFile, String paramString)
  {
    return new Decompress(paramFile.getAbsolutePath(), sddir + "/tmp/").unzip(paramString);
  }
  
  public static void extractLibs(File paramFile)
  {
    paramFile = paramFile.getAbsolutePath();
    String str = sddir + "/tmp/";
    if (!new File(sddir + "/tmp/lib/").exists()) {
      new Decompress(paramFile, str).unzip();
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
  
  public static void getClassesDex()
  {
    try
    {
      File localFile = new File(appdir);
      crkapk = new File(sddir + "/Modified/" + packageName + ".apk");
      Utils.copyFile(localFile, crkapk);
      unzip(crkapk);
      if ((classesFiles == null) || (classesFiles.size() == 0)) {
        throw new FileNotFoundException();
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      print.println("Error LP: unzip classes.dex fault!\n\n");
      return;
      if ((classesFiles != null) && (classesFiles.size() > 0))
      {
        Iterator localIterator = classesFiles.iterator();
        while (localIterator.hasNext()) {
          if (!((File)localIterator.next()).exists()) {
            throw new FileNotFoundException();
          }
        }
      }
    }
    catch (Exception localException)
    {
      print.println("Extract classes.dex error: " + localException.toString());
      return;
    }
    System.out.println("get classes.dex " + classesFiles.size());
  }
  
  public static String getFileFromApk(String paramString)
  {
    try
    {
      File localFile = new File(appdir);
      crkapk = new File(sddir + "/Modified/" + packageName + ".apk");
      if (!crkapk.exists()) {
        Utils.copyFile(localFile, crkapk);
      }
      paramString = extractFile(crkapk, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      print.println("Lib select error: " + paramString.toString());
    }
    return "";
  }
  
  /* Error */
  public static String main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 316	com/android/vending/billing/InAppBillingService/LACK/LogOutputStream
    //   3: dup
    //   4: ldc_w 318
    //   7: invokespecial 319	com/android/vending/billing/InAppBillingService/LACK/LogOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 29
    //   12: new 202	java/io/PrintStream
    //   15: dup
    //   16: aload 29
    //   18: invokespecial 322	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   21: putstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   24: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   27: ldc_w 324
    //   30: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   33: getstatic 109	com/chelpus/root/utils/createapkcustom:patchedLibs	Ljava/util/ArrayList;
    //   36: invokevirtual 327	java/util/ArrayList:clear	()V
    //   39: aload_0
    //   40: iconst_0
    //   41: aaload
    //   42: putstatic 100	com/chelpus/root/utils/createapkcustom:packageName	Ljava/lang/String;
    //   45: aload_0
    //   46: iconst_2
    //   47: aaload
    //   48: putstatic 94	com/chelpus/root/utils/createapkcustom:appdir	Ljava/lang/String;
    //   51: aload_0
    //   52: iconst_3
    //   53: aaload
    //   54: putstatic 92	com/chelpus/root/utils/createapkcustom:sddir	Ljava/lang/String;
    //   57: aload_0
    //   58: iconst_4
    //   59: aaload
    //   60: putstatic 96	com/chelpus/root/utils/createapkcustom:tooldir	Ljava/lang/String;
    //   63: invokestatic 329	com/chelpus/root/utils/createapkcustom:clearTemp	()V
    //   66: new 189	java/io/File
    //   69: dup
    //   70: new 162	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   77: getstatic 92	com/chelpus/root/utils/createapkcustom:sddir	Ljava/lang/String;
    //   80: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc -44
    //   85: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore 17
    //   96: new 267	com/chelpus/Utils
    //   99: dup
    //   100: ldc_w 331
    //   103: invokespecial 332	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   106: aload 17
    //   108: invokevirtual 335	com/chelpus/Utils:deleteFolder	(Ljava/io/File;)V
    //   111: iconst_0
    //   112: putstatic 84	com/chelpus/root/utils/createapkcustom:manualpatch	Z
    //   115: ldc 98
    //   117: astore 26
    //   119: ldc 98
    //   121: astore 24
    //   123: iconst_0
    //   124: istore_2
    //   125: iconst_0
    //   126: istore 10
    //   128: invokestatic 337	com/chelpus/root/utils/createapkcustom:getClassesDex	()V
    //   131: new 228	java/io/FileInputStream
    //   134: dup
    //   135: aload_0
    //   136: iconst_1
    //   137: aaload
    //   138: invokespecial 338	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   141: astore 30
    //   143: new 340	java/io/BufferedReader
    //   146: dup
    //   147: new 342	java/io/InputStreamReader
    //   150: dup
    //   151: aload 30
    //   153: ldc_w 344
    //   156: invokespecial 347	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   159: invokespecial 350	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   162: astore 31
    //   164: sipush 1000
    //   167: anewarray 352	java/lang/String
    //   170: astore 32
    //   172: aconst_null
    //   173: astore 23
    //   175: aconst_null
    //   176: astore 22
    //   178: iconst_1
    //   179: istore 12
    //   181: iconst_1
    //   182: istore 14
    //   184: iconst_0
    //   185: istore 6
    //   187: iconst_0
    //   188: istore 5
    //   190: iconst_0
    //   191: istore_3
    //   192: iconst_0
    //   193: istore 7
    //   195: ldc 98
    //   197: astore 19
    //   199: ldc 98
    //   201: astore 17
    //   203: ldc 98
    //   205: astore 18
    //   207: new 102	java/util/ArrayList
    //   210: dup
    //   211: invokespecial 105	java/util/ArrayList:<init>	()V
    //   214: putstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   217: new 102	java/util/ArrayList
    //   220: dup
    //   221: invokespecial 105	java/util/ArrayList:<init>	()V
    //   224: putstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   227: new 102	java/util/ArrayList
    //   230: dup
    //   231: invokespecial 105	java/util/ArrayList:<init>	()V
    //   234: putstatic 78	com/chelpus/root/utils/createapkcustom:search	Ljava/util/ArrayList;
    //   237: iconst_0
    //   238: istore 9
    //   240: aload 31
    //   242: invokevirtual 355	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   245: astore 20
    //   247: aload 20
    //   249: ifnull +5709 -> 5958
    //   252: aload 20
    //   254: astore 27
    //   256: aload 20
    //   258: ldc 98
    //   260: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifne +13 -> 276
    //   266: aload 20
    //   268: getstatic 100	com/chelpus/root/utils/createapkcustom:packageName	Ljava/lang/String;
    //   271: invokestatic 363	com/chelpus/Utils:apply_TAGS	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   274: astore 27
    //   276: aload 32
    //   278: iload 9
    //   280: aload 27
    //   282: aastore
    //   283: iload 5
    //   285: istore_1
    //   286: iload 5
    //   288: ifeq +82 -> 370
    //   291: aload 32
    //   293: iload 9
    //   295: aaload
    //   296: ldc_w 365
    //   299: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   302: ifne +34 -> 336
    //   305: aload 32
    //   307: iload 9
    //   309: aaload
    //   310: ldc_w 371
    //   313: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   316: ifne +20 -> 336
    //   319: iload 5
    //   321: istore_1
    //   322: aload 32
    //   324: iload 9
    //   326: aaload
    //   327: ldc_w 373
    //   330: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   333: ifeq +37 -> 370
    //   336: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   339: new 162	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   346: ldc 98
    //   348: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 24
    //   353: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc_w 375
    //   359: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   368: iconst_0
    //   369: istore_1
    //   370: aload 24
    //   372: astore 28
    //   374: iload_1
    //   375: ifeq +34 -> 409
    //   378: new 162	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   385: aload 24
    //   387: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: ldc_w 375
    //   393: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload 32
    //   398: iload 9
    //   400: aaload
    //   401: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: astore 28
    //   409: iload 12
    //   411: istore 15
    //   413: iload 14
    //   415: istore 13
    //   417: aload 32
    //   419: iload 9
    //   421: aaload
    //   422: ldc_w 365
    //   425: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   428: ifeq +92 -> 520
    //   431: iload 12
    //   433: istore 15
    //   435: iload 14
    //   437: istore 13
    //   439: aload 32
    //   441: iload 9
    //   443: aaload
    //   444: ldc_w 371
    //   447: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   450: ifeq +70 -> 520
    //   453: iload 12
    //   455: istore 15
    //   457: iload 14
    //   459: istore 13
    //   461: getstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   464: tableswitch	default:+5577->6041, 1:+1165->1629, 2:+1643->2107, 3:+56->520, 4:+56->520, 5:+56->520, 6:+1866->2330, 7:+2081->2545, 8:+2296->2760, 9:+2511->2975, 10:+1451->1915
    //   520: iload_1
    //   521: istore 5
    //   523: aload 32
    //   525: iload 9
    //   527: aaload
    //   528: ldc_w 379
    //   531: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   534: ifeq +10 -> 544
    //   537: iconst_0
    //   538: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   541: iconst_1
    //   542: istore 5
    //   544: aload 32
    //   546: iload 9
    //   548: aaload
    //   549: ldc_w 381
    //   552: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   555: ifne +17 -> 572
    //   558: aload 32
    //   560: iload 9
    //   562: aaload
    //   563: ldc_w 383
    //   566: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   569: ifeq +25 -> 594
    //   572: iconst_1
    //   573: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   576: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   579: ifnull +15 -> 594
    //   582: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   585: invokevirtual 276	java/util/ArrayList:size	()I
    //   588: ifne +6 -> 594
    //   591: invokestatic 337	com/chelpus/root/utils/createapkcustom:getClassesDex	()V
    //   594: aload 32
    //   596: iload 9
    //   598: aaload
    //   599: ldc_w 385
    //   602: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   605: ifeq +56 -> 661
    //   608: iconst_5
    //   609: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   612: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   615: ifnull +15 -> 630
    //   618: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   621: invokevirtual 276	java/util/ArrayList:size	()I
    //   624: ifne +6 -> 630
    //   627: invokestatic 337	com/chelpus/root/utils/createapkcustom:getClassesDex	()V
    //   630: getstatic 299	java/lang/System:out	Ljava/io/PrintStream;
    //   633: new 162	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   640: ldc_w 387
    //   643: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   649: invokevirtual 276	java/util/ArrayList:size	()I
    //   652: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   655: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   661: iload 6
    //   663: istore_1
    //   664: aload 19
    //   666: astore 20
    //   668: iload 6
    //   670: ifeq +90 -> 760
    //   673: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   676: invokevirtual 327	java/util/ArrayList:clear	()V
    //   679: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   682: invokevirtual 327	java/util/ArrayList:clear	()V
    //   685: new 389	org/json/JSONObject
    //   688: dup
    //   689: aload 32
    //   691: iload 9
    //   693: aaload
    //   694: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   697: ldc_w 392
    //   700: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   703: astore 20
    //   705: aload 20
    //   707: astore 19
    //   709: getstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   712: tableswitch	default:+5340->6052, 2:+2492->3204, 3:+5340->6052, 4:+5340->6052, 5:+5340->6052, 6:+2510->3222, 7:+2528->3240, 8:+2546->3258, 9:+2564->3276
    //   760: iload 7
    //   762: istore 4
    //   764: aload 20
    //   766: astore 19
    //   768: iload 7
    //   770: ifeq +72 -> 842
    //   773: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   776: invokevirtual 327	java/util/ArrayList:clear	()V
    //   779: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   782: invokevirtual 327	java/util/ArrayList:clear	()V
    //   785: new 389	org/json/JSONObject
    //   788: dup
    //   789: aload 32
    //   791: iload 9
    //   793: aaload
    //   794: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   797: ldc_w 392
    //   800: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   803: astore 19
    //   805: aload 19
    //   807: invokestatic 397	com/chelpus/root/utils/createapkcustom:getFileFromApk	(Ljava/lang/String;)Ljava/lang/String;
    //   810: astore 20
    //   812: new 189	java/io/File
    //   815: dup
    //   816: aload 20
    //   818: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   821: invokevirtual 196	java/io/File:exists	()Z
    //   824: ifeq +2488 -> 3312
    //   827: new 189	java/io/File
    //   830: dup
    //   831: aload 20
    //   833: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   836: putstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   839: goto +5222 -> 6061
    //   842: aload 32
    //   844: iload 9
    //   846: aaload
    //   847: ldc_w 401
    //   850: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   853: ifeq +17 -> 870
    //   856: bipush 6
    //   858: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   861: iconst_0
    //   862: putstatic 82	com/chelpus/root/utils/createapkcustom:unpack	Z
    //   865: iconst_0
    //   866: istore 4
    //   868: iconst_1
    //   869: istore_1
    //   870: aload 32
    //   872: iload 9
    //   874: aaload
    //   875: ldc_w 403
    //   878: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   881: ifeq +17 -> 898
    //   884: bipush 7
    //   886: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   889: iconst_0
    //   890: putstatic 82	com/chelpus/root/utils/createapkcustom:unpack	Z
    //   893: iconst_0
    //   894: istore 4
    //   896: iconst_1
    //   897: istore_1
    //   898: aload 32
    //   900: iload 9
    //   902: aaload
    //   903: ldc_w 405
    //   906: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   909: ifeq +17 -> 926
    //   912: bipush 8
    //   914: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   917: iconst_0
    //   918: putstatic 82	com/chelpus/root/utils/createapkcustom:unpack	Z
    //   921: iconst_0
    //   922: istore 4
    //   924: iconst_1
    //   925: istore_1
    //   926: aload 32
    //   928: iload 9
    //   930: aaload
    //   931: ldc_w 407
    //   934: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   937: ifeq +17 -> 954
    //   940: bipush 9
    //   942: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   945: iconst_0
    //   946: putstatic 82	com/chelpus/root/utils/createapkcustom:unpack	Z
    //   949: iconst_0
    //   950: istore 4
    //   952: iconst_1
    //   953: istore_1
    //   954: aload 32
    //   956: iload 9
    //   958: aaload
    //   959: ldc_w 409
    //   962: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   965: ifeq +16 -> 981
    //   968: iconst_2
    //   969: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   972: iconst_0
    //   973: putstatic 82	com/chelpus/root/utils/createapkcustom:unpack	Z
    //   976: iconst_0
    //   977: istore 4
    //   979: iconst_1
    //   980: istore_1
    //   981: iload 4
    //   983: istore 7
    //   985: iload_1
    //   986: istore 6
    //   988: aload 32
    //   990: iload 9
    //   992: aaload
    //   993: ldc_w 411
    //   996: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   999: ifeq +18 -> 1017
    //   1002: bipush 10
    //   1004: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   1007: iconst_0
    //   1008: putstatic 82	com/chelpus/root/utils/createapkcustom:unpack	Z
    //   1011: iconst_0
    //   1012: istore 6
    //   1014: iconst_1
    //   1015: istore 7
    //   1017: aload 32
    //   1019: iload 9
    //   1021: aaload
    //   1022: ldc_w 412
    //   1025: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1028: ifeq +56 -> 1084
    //   1031: aload 32
    //   1033: iload 9
    //   1035: aaload
    //   1036: ldc_w 373
    //   1039: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1042: ifeq +42 -> 1084
    //   1045: aload 32
    //   1047: iload 9
    //   1049: aaload
    //   1050: ldc_w 414
    //   1053: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1056: istore 12
    //   1058: iload 12
    //   1060: ifeq +24 -> 1084
    //   1063: new 389	org/json/JSONObject
    //   1066: dup
    //   1067: aload 32
    //   1069: iload 9
    //   1071: aaload
    //   1072: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1075: ldc_w 412
    //   1078: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1081: putstatic 111	com/chelpus/root/utils/createapkcustom:group	Ljava/lang/String;
    //   1084: aload 23
    //   1086: astore 24
    //   1088: aload 22
    //   1090: astore 25
    //   1092: iload_2
    //   1093: istore_1
    //   1094: iload_3
    //   1095: istore 8
    //   1097: iload 13
    //   1099: istore 16
    //   1101: aload 19
    //   1103: astore 20
    //   1105: aload 32
    //   1107: iload 9
    //   1109: aaload
    //   1110: ldc_w 416
    //   1113: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1116: ifeq +2315 -> 3431
    //   1119: aload 23
    //   1121: astore 24
    //   1123: aload 22
    //   1125: astore 25
    //   1127: iload_2
    //   1128: istore_1
    //   1129: iload_3
    //   1130: istore 8
    //   1132: iload 13
    //   1134: istore 16
    //   1136: aload 19
    //   1138: astore 20
    //   1140: aload 32
    //   1142: iload 9
    //   1144: aaload
    //   1145: ldc_w 373
    //   1148: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1151: ifeq +2280 -> 3431
    //   1154: aload 23
    //   1156: astore 24
    //   1158: aload 22
    //   1160: astore 25
    //   1162: iload_2
    //   1163: istore_1
    //   1164: iload_3
    //   1165: istore 8
    //   1167: iload 13
    //   1169: istore 16
    //   1171: aload 19
    //   1173: astore 20
    //   1175: aload 32
    //   1177: iload 9
    //   1179: aaload
    //   1180: ldc_w 414
    //   1183: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1186: ifeq +2245 -> 3431
    //   1189: iload_3
    //   1190: istore 4
    //   1192: iload 13
    //   1194: istore 12
    //   1196: iload_3
    //   1197: ifeq +95 -> 1292
    //   1200: getstatic 299	java/lang/System:out	Ljava/io/PrintStream;
    //   1203: new 162	java/lang/StringBuilder
    //   1206: dup
    //   1207: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1210: ldc_w 418
    //   1213: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: getstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   1219: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1222: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1225: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1228: getstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   1231: iconst_1
    //   1232: if_icmpne +2111 -> 3343
    //   1235: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   1238: invokevirtual 283	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1241: astore 20
    //   1243: iload_3
    //   1244: istore 4
    //   1246: iload 13
    //   1248: istore 12
    //   1250: aload 20
    //   1252: invokeinterface 288 1 0
    //   1257: ifeq +35 -> 1292
    //   1260: aload 20
    //   1262: invokeinterface 292 1 0
    //   1267: checkcast 189	java/io/File
    //   1270: putstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   1273: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   1276: invokestatic 422	com/chelpus/root/utils/createapkcustom:searchProcess	(Ljava/util/ArrayList;)Z
    //   1279: istore 12
    //   1281: iload 12
    //   1283: ifeq -40 -> 1243
    //   1286: iconst_1
    //   1287: istore 12
    //   1289: iconst_0
    //   1290: istore 4
    //   1292: new 389	org/json/JSONObject
    //   1295: dup
    //   1296: aload 32
    //   1298: iload 9
    //   1300: aaload
    //   1301: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1304: ldc_w 416
    //   1307: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1310: astore 20
    //   1312: aload 20
    //   1314: astore 19
    //   1316: aload 19
    //   1318: invokevirtual 425	java/lang/String:trim	()Ljava/lang/String;
    //   1321: astore 19
    //   1323: aload 19
    //   1325: ldc_w 427
    //   1328: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1331: arraylength
    //   1332: anewarray 352	java/lang/String
    //   1335: astore 20
    //   1337: aload 19
    //   1339: ldc_w 427
    //   1342: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1345: astore 23
    //   1347: aload 23
    //   1349: arraylength
    //   1350: newarray <illegal type>
    //   1352: astore 21
    //   1354: aload 23
    //   1356: arraylength
    //   1357: newarray <illegal type>
    //   1359: astore 22
    //   1361: iconst_0
    //   1362: istore 11
    //   1364: iload_2
    //   1365: istore_3
    //   1366: aload 22
    //   1368: astore 24
    //   1370: aload 21
    //   1372: astore 25
    //   1374: iload_2
    //   1375: istore_1
    //   1376: iload 4
    //   1378: istore 8
    //   1380: iload 12
    //   1382: istore 16
    //   1384: aload 19
    //   1386: astore 20
    //   1388: iload 11
    //   1390: aload 23
    //   1392: arraylength
    //   1393: if_icmpge +2038 -> 3431
    //   1396: iload_2
    //   1397: istore_1
    //   1398: iload_2
    //   1399: istore_3
    //   1400: aload 23
    //   1402: iload 11
    //   1404: aaload
    //   1405: ldc_w 433
    //   1408: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1411: ifeq +31 -> 1442
    //   1414: iload_2
    //   1415: istore_1
    //   1416: iload_2
    //   1417: istore_3
    //   1418: aload 23
    //   1420: iload 11
    //   1422: aaload
    //   1423: ldc_w 435
    //   1426: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1429: ifne +13 -> 1442
    //   1432: iconst_1
    //   1433: istore_1
    //   1434: aload 23
    //   1436: iload 11
    //   1438: ldc_w 437
    //   1441: aastore
    //   1442: iload_1
    //   1443: istore_3
    //   1444: aload 23
    //   1446: iload 11
    //   1448: aaload
    //   1449: ldc_w 435
    //   1452: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1455: ifne +4612 -> 6067
    //   1458: iload_1
    //   1459: istore_3
    //   1460: aload 23
    //   1462: iload 11
    //   1464: aaload
    //   1465: ldc_w 439
    //   1468: invokevirtual 443	java/lang/String:matches	(Ljava/lang/String;)Z
    //   1471: ifeq +1900 -> 3371
    //   1474: goto +4593 -> 6067
    //   1477: iload_1
    //   1478: istore_3
    //   1479: aload 23
    //   1481: iload 11
    //   1483: aaload
    //   1484: ldc_w 445
    //   1487: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1490: ifne +51 -> 1541
    //   1493: iload_1
    //   1494: istore_3
    //   1495: aload 23
    //   1497: iload 11
    //   1499: aaload
    //   1500: ldc_w 447
    //   1503: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1506: ifne +35 -> 1541
    //   1509: iload_1
    //   1510: istore_3
    //   1511: aload 23
    //   1513: iload 11
    //   1515: aaload
    //   1516: ldc_w 449
    //   1519: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1522: ifne +19 -> 1541
    //   1525: iload_1
    //   1526: istore_3
    //   1527: aload 23
    //   1529: iload 11
    //   1531: aaload
    //   1532: ldc_w 451
    //   1535: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1538: ifeq +50 -> 1588
    //   1541: iload_1
    //   1542: istore_3
    //   1543: aload 21
    //   1545: iload 11
    //   1547: aload 23
    //   1549: iload 11
    //   1551: aaload
    //   1552: invokevirtual 454	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1555: ldc_w 447
    //   1558: ldc 98
    //   1560: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1563: ldc_w 451
    //   1566: ldc 98
    //   1568: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1571: invokestatic 464	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1574: invokevirtual 467	java/lang/Integer:intValue	()I
    //   1577: iconst_2
    //   1578: iadd
    //   1579: iastore
    //   1580: aload 23
    //   1582: iload 11
    //   1584: ldc_w 437
    //   1587: aastore
    //   1588: iload_1
    //   1589: istore_3
    //   1590: aload 22
    //   1592: iload 11
    //   1594: aload 23
    //   1596: iload 11
    //   1598: aaload
    //   1599: bipush 16
    //   1601: invokestatic 470	java/lang/Integer:valueOf	(Ljava/lang/String;I)Ljava/lang/Integer;
    //   1604: invokevirtual 474	java/lang/Integer:byteValue	()B
    //   1607: bastore
    //   1608: iload 11
    //   1610: iconst_1
    //   1611: iadd
    //   1612: istore 11
    //   1614: iload_1
    //   1615: istore_2
    //   1616: goto -252 -> 1364
    //   1619: astore 17
    //   1621: aload 17
    //   1623: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   1626: goto -1515 -> 111
    //   1629: getstatic 299	java/lang/System:out	Ljava/io/PrintStream;
    //   1632: ldc_w 476
    //   1635: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1638: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   1641: ifnull +15 -> 1656
    //   1644: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   1647: invokevirtual 276	java/util/ArrayList:size	()I
    //   1650: ifne +6 -> 1656
    //   1653: invokestatic 337	com/chelpus/root/utils/createapkcustom:getClassesDex	()V
    //   1656: iload 12
    //   1658: istore 15
    //   1660: iload 14
    //   1662: istore 13
    //   1664: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   1667: ifnull -1147 -> 520
    //   1670: iload 12
    //   1672: istore 15
    //   1674: iload 14
    //   1676: istore 13
    //   1678: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   1681: invokevirtual 276	java/util/ArrayList:size	()I
    //   1684: ifle -1164 -> 520
    //   1687: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   1690: invokevirtual 276	java/util/ArrayList:size	()I
    //   1693: iconst_1
    //   1694: if_icmple +7 -> 1701
    //   1697: iconst_1
    //   1698: putstatic 115	com/chelpus/root/utils/createapkcustom:multidex	Z
    //   1701: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   1704: invokevirtual 283	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1707: astore 20
    //   1709: iload 14
    //   1711: istore 13
    //   1713: aload 20
    //   1715: invokeinterface 288 1 0
    //   1720: ifeq +124 -> 1844
    //   1723: aload 20
    //   1725: invokeinterface 292 1 0
    //   1730: checkcast 189	java/io/File
    //   1733: astore 21
    //   1735: aload 21
    //   1737: putstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   1740: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   1743: invokevirtual 276	java/util/ArrayList:size	()I
    //   1746: ifle -33 -> 1713
    //   1749: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1752: ldc_w 478
    //   1755: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1758: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1761: new 162	java/lang/StringBuilder
    //   1764: dup
    //   1765: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1768: ldc_w 480
    //   1771: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: aload 21
    //   1776: invokevirtual 483	java/io/File:getName	()Ljava/lang/String;
    //   1779: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1782: ldc_w 485
    //   1785: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1791: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1794: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1797: ldc_w 487
    //   1800: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1803: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   1806: ldc 98
    //   1808: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1811: ifne +12 -> 1823
    //   1814: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1817: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   1820: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1823: iload 12
    //   1825: istore 14
    //   1827: getstatic 84	com/chelpus/root/utils/createapkcustom:manualpatch	Z
    //   1830: ifne +4254 -> 6084
    //   1833: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   1836: invokestatic 490	com/chelpus/root/utils/createapkcustom:patchProcess	(Ljava/util/ArrayList;)Z
    //   1839: istore 14
    //   1841: goto +4243 -> 6084
    //   1844: iconst_0
    //   1845: putstatic 115	com/chelpus/root/utils/createapkcustom:multidex	Z
    //   1848: iconst_0
    //   1849: putstatic 117	com/chelpus/root/utils/createapkcustom:goodResult	Z
    //   1852: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   1855: invokevirtual 327	java/util/ArrayList:clear	()V
    //   1858: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   1861: invokevirtual 327	java/util/ArrayList:clear	()V
    //   1864: sipush 200
    //   1867: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   1870: ldc 98
    //   1872: putstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   1875: iload 12
    //   1877: istore 15
    //   1879: goto -1359 -> 520
    //   1882: astore_0
    //   1883: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1886: ldc_w 492
    //   1889: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1892: invokestatic 329	com/chelpus/root/utils/createapkcustom:clearTemp	()V
    //   1895: aload 29
    //   1897: getfield 495	com/android/vending/billing/InAppBillingService/LACK/LogOutputStream:allresult	Ljava/lang/String;
    //   1900: astore_0
    //   1901: getstatic 299	java/lang/System:out	Ljava/io/PrintStream;
    //   1904: aload_0
    //   1905: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1908: aload 29
    //   1910: invokevirtual 496	com/android/vending/billing/InAppBillingService/LACK/LogOutputStream:close	()V
    //   1913: aload_0
    //   1914: areturn
    //   1915: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1918: ldc_w 498
    //   1921: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1924: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1927: new 162	java/lang/StringBuilder
    //   1930: dup
    //   1931: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1934: ldc_w 500
    //   1937: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   1943: invokevirtual 503	java/io/File:getPath	()Ljava/lang/String;
    //   1946: new 162	java/lang/StringBuilder
    //   1949: dup
    //   1950: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1953: getstatic 92	com/chelpus/root/utils/createapkcustom:sddir	Ljava/lang/String;
    //   1956: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: ldc_w 505
    //   1962: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1968: ldc 98
    //   1970: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1973: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1976: ldc_w 485
    //   1979: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1982: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1985: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1988: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1991: ldc_w 507
    //   1994: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1997: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2000: ldc 98
    //   2002: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2005: ifne +12 -> 2017
    //   2008: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2011: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2014: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2017: getstatic 84	com/chelpus/root/utils/createapkcustom:manualpatch	Z
    //   2020: ifne +4083 -> 6103
    //   2023: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   2026: invokestatic 490	com/chelpus/root/utils/createapkcustom:patchProcess	(Ljava/util/ArrayList;)Z
    //   2029: istore 12
    //   2031: goto +4072 -> 6103
    //   2034: getstatic 109	com/chelpus/root/utils/createapkcustom:patchedLibs	Ljava/util/ArrayList;
    //   2037: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   2040: invokevirtual 210	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2043: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2046: pop
    //   2047: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   2050: invokevirtual 327	java/util/ArrayList:clear	()V
    //   2053: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   2056: invokevirtual 327	java/util/ArrayList:clear	()V
    //   2059: sipush 200
    //   2062: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   2065: ldc 98
    //   2067: putstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2070: iload 12
    //   2072: istore 15
    //   2074: goto -1554 -> 520
    //   2077: astore_0
    //   2078: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2081: new 162	java/lang/StringBuilder
    //   2084: dup
    //   2085: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   2088: ldc_w 512
    //   2091: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: aload_0
    //   2095: invokevirtual 515	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2098: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2101: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2104: goto -212 -> 1892
    //   2107: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   2110: invokevirtual 283	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2113: astore 20
    //   2115: iload 14
    //   2117: istore 13
    //   2119: aload 20
    //   2121: invokeinterface 288 1 0
    //   2126: ifeq +166 -> 2292
    //   2129: aload 20
    //   2131: invokeinterface 292 1 0
    //   2136: checkcast 352	java/lang/String
    //   2139: astore 21
    //   2141: new 189	java/io/File
    //   2144: dup
    //   2145: aload 21
    //   2147: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   2150: putstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   2153: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2156: ldc_w 498
    //   2159: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2162: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2165: new 162	java/lang/StringBuilder
    //   2168: dup
    //   2169: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   2172: ldc_w 517
    //   2175: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   2181: invokevirtual 503	java/io/File:getPath	()Ljava/lang/String;
    //   2184: new 162	java/lang/StringBuilder
    //   2187: dup
    //   2188: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   2191: getstatic 92	com/chelpus/root/utils/createapkcustom:sddir	Ljava/lang/String;
    //   2194: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: ldc_w 505
    //   2200: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2203: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2206: ldc 98
    //   2208: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   2211: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2214: ldc_w 485
    //   2217: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2220: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2223: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2226: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2229: ldc_w 507
    //   2232: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2235: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2238: ldc 98
    //   2240: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2243: ifne +12 -> 2255
    //   2246: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2249: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2252: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2255: getstatic 84	com/chelpus/root/utils/createapkcustom:manualpatch	Z
    //   2258: ifne +3860 -> 6118
    //   2261: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   2264: invokestatic 490	com/chelpus/root/utils/createapkcustom:patchProcess	(Ljava/util/ArrayList;)Z
    //   2267: istore 12
    //   2269: goto +3849 -> 6118
    //   2272: getstatic 109	com/chelpus/root/utils/createapkcustom:patchedLibs	Ljava/util/ArrayList;
    //   2275: aload 21
    //   2277: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2280: pop
    //   2281: goto -162 -> 2119
    //   2284: astore_0
    //   2285: aload_0
    //   2286: invokevirtual 518	java/lang/InterruptedException:printStackTrace	()V
    //   2289: goto -397 -> 1892
    //   2292: iconst_0
    //   2293: putstatic 119	com/chelpus/root/utils/createapkcustom:multilib_patch	Z
    //   2296: iconst_0
    //   2297: putstatic 117	com/chelpus/root/utils/createapkcustom:goodResult	Z
    //   2300: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   2303: invokevirtual 327	java/util/ArrayList:clear	()V
    //   2306: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   2309: invokevirtual 327	java/util/ArrayList:clear	()V
    //   2312: sipush 200
    //   2315: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   2318: ldc 98
    //   2320: putstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2323: iload 12
    //   2325: istore 15
    //   2327: goto -1807 -> 520
    //   2330: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   2333: invokevirtual 283	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2336: astore 20
    //   2338: iload 14
    //   2340: istore 13
    //   2342: aload 20
    //   2344: invokeinterface 288 1 0
    //   2349: ifeq +158 -> 2507
    //   2352: aload 20
    //   2354: invokeinterface 292 1 0
    //   2359: checkcast 352	java/lang/String
    //   2362: astore 21
    //   2364: new 189	java/io/File
    //   2367: dup
    //   2368: aload 21
    //   2370: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   2373: putstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   2376: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2379: ldc_w 520
    //   2382: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2385: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2388: new 162	java/lang/StringBuilder
    //   2391: dup
    //   2392: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   2395: ldc_w 522
    //   2398: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2401: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   2404: invokevirtual 503	java/io/File:getPath	()Ljava/lang/String;
    //   2407: new 162	java/lang/StringBuilder
    //   2410: dup
    //   2411: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   2414: getstatic 92	com/chelpus/root/utils/createapkcustom:sddir	Ljava/lang/String;
    //   2417: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2420: ldc_w 505
    //   2423: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2426: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2429: ldc 98
    //   2431: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   2434: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2437: ldc_w 485
    //   2440: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2443: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2446: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2449: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2452: ldc_w 524
    //   2455: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2458: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2461: ldc 98
    //   2463: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2466: ifne +12 -> 2478
    //   2469: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2472: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2475: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2478: getstatic 84	com/chelpus/root/utils/createapkcustom:manualpatch	Z
    //   2481: ifne +3648 -> 6129
    //   2484: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   2487: invokestatic 490	com/chelpus/root/utils/createapkcustom:patchProcess	(Ljava/util/ArrayList;)Z
    //   2490: istore 12
    //   2492: goto +3637 -> 6129
    //   2495: getstatic 109	com/chelpus/root/utils/createapkcustom:patchedLibs	Ljava/util/ArrayList;
    //   2498: aload 21
    //   2500: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2503: pop
    //   2504: goto -162 -> 2342
    //   2507: iconst_0
    //   2508: putstatic 119	com/chelpus/root/utils/createapkcustom:multilib_patch	Z
    //   2511: iconst_0
    //   2512: putstatic 117	com/chelpus/root/utils/createapkcustom:goodResult	Z
    //   2515: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   2518: invokevirtual 327	java/util/ArrayList:clear	()V
    //   2521: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   2524: invokevirtual 327	java/util/ArrayList:clear	()V
    //   2527: sipush 200
    //   2530: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   2533: ldc 98
    //   2535: putstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2538: iload 12
    //   2540: istore 15
    //   2542: goto -2022 -> 520
    //   2545: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   2548: invokevirtual 283	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2551: astore 20
    //   2553: iload 14
    //   2555: istore 13
    //   2557: aload 20
    //   2559: invokeinterface 288 1 0
    //   2564: ifeq +158 -> 2722
    //   2567: aload 20
    //   2569: invokeinterface 292 1 0
    //   2574: checkcast 352	java/lang/String
    //   2577: astore 21
    //   2579: new 189	java/io/File
    //   2582: dup
    //   2583: aload 21
    //   2585: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   2588: putstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   2591: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2594: ldc_w 526
    //   2597: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2600: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2603: new 162	java/lang/StringBuilder
    //   2606: dup
    //   2607: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   2610: ldc_w 528
    //   2613: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2616: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   2619: invokevirtual 503	java/io/File:getPath	()Ljava/lang/String;
    //   2622: new 162	java/lang/StringBuilder
    //   2625: dup
    //   2626: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   2629: getstatic 92	com/chelpus/root/utils/createapkcustom:sddir	Ljava/lang/String;
    //   2632: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2635: ldc_w 505
    //   2638: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2641: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2644: ldc 98
    //   2646: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   2649: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2652: ldc_w 485
    //   2655: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2658: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2661: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2664: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2667: ldc_w 530
    //   2670: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2673: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2676: ldc 98
    //   2678: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2681: ifne +12 -> 2693
    //   2684: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2687: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2690: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2693: getstatic 84	com/chelpus/root/utils/createapkcustom:manualpatch	Z
    //   2696: ifne +3444 -> 6140
    //   2699: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   2702: invokestatic 490	com/chelpus/root/utils/createapkcustom:patchProcess	(Ljava/util/ArrayList;)Z
    //   2705: istore 12
    //   2707: goto +3433 -> 6140
    //   2710: getstatic 109	com/chelpus/root/utils/createapkcustom:patchedLibs	Ljava/util/ArrayList;
    //   2713: aload 21
    //   2715: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2718: pop
    //   2719: goto -162 -> 2557
    //   2722: iconst_0
    //   2723: putstatic 119	com/chelpus/root/utils/createapkcustom:multilib_patch	Z
    //   2726: iconst_0
    //   2727: putstatic 117	com/chelpus/root/utils/createapkcustom:goodResult	Z
    //   2730: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   2733: invokevirtual 327	java/util/ArrayList:clear	()V
    //   2736: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   2739: invokevirtual 327	java/util/ArrayList:clear	()V
    //   2742: sipush 200
    //   2745: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   2748: ldc 98
    //   2750: putstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2753: iload 12
    //   2755: istore 15
    //   2757: goto -2237 -> 520
    //   2760: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   2763: invokevirtual 283	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2766: astore 20
    //   2768: iload 14
    //   2770: istore 13
    //   2772: aload 20
    //   2774: invokeinterface 288 1 0
    //   2779: ifeq +158 -> 2937
    //   2782: aload 20
    //   2784: invokeinterface 292 1 0
    //   2789: checkcast 352	java/lang/String
    //   2792: astore 21
    //   2794: new 189	java/io/File
    //   2797: dup
    //   2798: aload 21
    //   2800: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   2803: putstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   2806: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2809: ldc_w 498
    //   2812: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2815: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2818: new 162	java/lang/StringBuilder
    //   2821: dup
    //   2822: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   2825: ldc_w 532
    //   2828: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2831: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   2834: invokevirtual 503	java/io/File:getPath	()Ljava/lang/String;
    //   2837: new 162	java/lang/StringBuilder
    //   2840: dup
    //   2841: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   2844: getstatic 92	com/chelpus/root/utils/createapkcustom:sddir	Ljava/lang/String;
    //   2847: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2850: ldc_w 505
    //   2853: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2856: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2859: ldc 98
    //   2861: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   2864: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2867: ldc_w 485
    //   2870: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2873: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2876: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2879: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2882: ldc_w 507
    //   2885: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2888: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2891: ldc 98
    //   2893: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2896: ifne +12 -> 2908
    //   2899: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   2902: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2905: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2908: getstatic 84	com/chelpus/root/utils/createapkcustom:manualpatch	Z
    //   2911: ifne +3240 -> 6151
    //   2914: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   2917: invokestatic 490	com/chelpus/root/utils/createapkcustom:patchProcess	(Ljava/util/ArrayList;)Z
    //   2920: istore 12
    //   2922: goto +3229 -> 6151
    //   2925: getstatic 109	com/chelpus/root/utils/createapkcustom:patchedLibs	Ljava/util/ArrayList;
    //   2928: aload 21
    //   2930: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2933: pop
    //   2934: goto -162 -> 2772
    //   2937: iconst_0
    //   2938: putstatic 119	com/chelpus/root/utils/createapkcustom:multilib_patch	Z
    //   2941: iconst_0
    //   2942: putstatic 117	com/chelpus/root/utils/createapkcustom:goodResult	Z
    //   2945: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   2948: invokevirtual 327	java/util/ArrayList:clear	()V
    //   2951: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   2954: invokevirtual 327	java/util/ArrayList:clear	()V
    //   2957: sipush 200
    //   2960: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   2963: ldc 98
    //   2965: putstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   2968: iload 12
    //   2970: istore 15
    //   2972: goto -2452 -> 520
    //   2975: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   2978: invokevirtual 283	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2981: astore 20
    //   2983: iload 14
    //   2985: istore 13
    //   2987: aload 20
    //   2989: invokeinterface 288 1 0
    //   2994: ifeq +158 -> 3152
    //   2997: aload 20
    //   2999: invokeinterface 292 1 0
    //   3004: checkcast 352	java/lang/String
    //   3007: astore 21
    //   3009: new 189	java/io/File
    //   3012: dup
    //   3013: aload 21
    //   3015: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   3018: putstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   3021: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3024: ldc_w 498
    //   3027: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3030: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3033: new 162	java/lang/StringBuilder
    //   3036: dup
    //   3037: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   3040: ldc_w 534
    //   3043: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3046: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   3049: invokevirtual 503	java/io/File:getPath	()Ljava/lang/String;
    //   3052: new 162	java/lang/StringBuilder
    //   3055: dup
    //   3056: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   3059: getstatic 92	com/chelpus/root/utils/createapkcustom:sddir	Ljava/lang/String;
    //   3062: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3065: ldc_w 505
    //   3068: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3071: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3074: ldc 98
    //   3076: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   3079: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3082: ldc_w 485
    //   3085: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3088: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3091: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3094: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3097: ldc_w 507
    //   3100: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3103: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   3106: ldc 98
    //   3108: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3111: ifne +12 -> 3123
    //   3114: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3117: getstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   3120: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3123: getstatic 84	com/chelpus/root/utils/createapkcustom:manualpatch	Z
    //   3126: ifne +3036 -> 6162
    //   3129: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   3132: invokestatic 490	com/chelpus/root/utils/createapkcustom:patchProcess	(Ljava/util/ArrayList;)Z
    //   3135: istore 12
    //   3137: goto +3025 -> 6162
    //   3140: getstatic 109	com/chelpus/root/utils/createapkcustom:patchedLibs	Ljava/util/ArrayList;
    //   3143: aload 21
    //   3145: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3148: pop
    //   3149: goto -162 -> 2987
    //   3152: iconst_0
    //   3153: putstatic 119	com/chelpus/root/utils/createapkcustom:multilib_patch	Z
    //   3156: iconst_0
    //   3157: putstatic 117	com/chelpus/root/utils/createapkcustom:goodResult	Z
    //   3160: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   3163: invokevirtual 327	java/util/ArrayList:clear	()V
    //   3166: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   3169: invokevirtual 327	java/util/ArrayList:clear	()V
    //   3172: sipush 200
    //   3175: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   3178: ldc 98
    //   3180: putstatic 121	com/chelpus/root/utils/createapkcustom:searchStr	Ljava/lang/String;
    //   3183: iload 12
    //   3185: istore 15
    //   3187: goto -2667 -> 520
    //   3190: astore 20
    //   3192: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3195: ldc_w 536
    //   3198: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3201: goto -2492 -> 709
    //   3204: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   3207: invokevirtual 327	java/util/ArrayList:clear	()V
    //   3210: iconst_4
    //   3211: aload 19
    //   3213: invokestatic 540	com/chelpus/root/utils/createapkcustom:searchlib	(ILjava/lang/String;)Ljava/util/ArrayList;
    //   3216: putstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   3219: goto +2833 -> 6052
    //   3222: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   3225: invokevirtual 327	java/util/ArrayList:clear	()V
    //   3228: iconst_0
    //   3229: aload 19
    //   3231: invokestatic 540	com/chelpus/root/utils/createapkcustom:searchlib	(ILjava/lang/String;)Ljava/util/ArrayList;
    //   3234: putstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   3237: goto +2815 -> 6052
    //   3240: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   3243: invokevirtual 327	java/util/ArrayList:clear	()V
    //   3246: iconst_1
    //   3247: aload 19
    //   3249: invokestatic 540	com/chelpus/root/utils/createapkcustom:searchlib	(ILjava/lang/String;)Ljava/util/ArrayList;
    //   3252: putstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   3255: goto +2797 -> 6052
    //   3258: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   3261: invokevirtual 327	java/util/ArrayList:clear	()V
    //   3264: iconst_2
    //   3265: aload 19
    //   3267: invokestatic 540	com/chelpus/root/utils/createapkcustom:searchlib	(ILjava/lang/String;)Ljava/util/ArrayList;
    //   3270: putstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   3273: goto +2779 -> 6052
    //   3276: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   3279: invokevirtual 327	java/util/ArrayList:clear	()V
    //   3282: iconst_3
    //   3283: aload 19
    //   3285: invokestatic 540	com/chelpus/root/utils/createapkcustom:searchlib	(ILjava/lang/String;)Ljava/util/ArrayList;
    //   3288: putstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   3291: goto +2761 -> 6052
    //   3294: astore 19
    //   3296: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3299: ldc_w 542
    //   3302: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3305: aload 20
    //   3307: astore 19
    //   3309: goto -2504 -> 805
    //   3312: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3315: ldc_w 544
    //   3318: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3321: goto +2740 -> 6061
    //   3324: astore 20
    //   3326: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3329: ldc_w 546
    //   3332: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3335: ldc 98
    //   3337: putstatic 111	com/chelpus/root/utils/createapkcustom:group	Ljava/lang/String;
    //   3340: goto -2256 -> 1084
    //   3343: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   3346: invokestatic 422	com/chelpus/root/utils/createapkcustom:searchProcess	(Ljava/util/ArrayList;)Z
    //   3349: istore 12
    //   3351: iconst_0
    //   3352: istore 4
    //   3354: goto -2062 -> 1292
    //   3357: astore 20
    //   3359: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3362: ldc_w 546
    //   3365: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3368: goto -2052 -> 1316
    //   3371: aload 21
    //   3373: iload 11
    //   3375: iconst_0
    //   3376: iastore
    //   3377: goto -1900 -> 1477
    //   3380: astore 20
    //   3382: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3385: new 162	java/lang/StringBuilder
    //   3388: dup
    //   3389: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   3392: ldc_w 548
    //   3395: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3398: aload 20
    //   3400: invokevirtual 515	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3403: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3406: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3409: aload 19
    //   3411: astore 20
    //   3413: iload 12
    //   3415: istore 16
    //   3417: iload 4
    //   3419: istore 8
    //   3421: iload_3
    //   3422: istore_1
    //   3423: aload 21
    //   3425: astore 25
    //   3427: aload 22
    //   3429: astore 24
    //   3431: iload 16
    //   3433: istore 14
    //   3435: aload 18
    //   3437: astore 19
    //   3439: aload 32
    //   3441: iload 9
    //   3443: aaload
    //   3444: ldc_w 550
    //   3447: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3450: ifeq +271 -> 3721
    //   3453: iload 16
    //   3455: istore 14
    //   3457: aload 18
    //   3459: astore 19
    //   3461: aload 32
    //   3463: iload 9
    //   3465: aaload
    //   3466: ldc_w 373
    //   3469: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3472: ifeq +249 -> 3721
    //   3475: aload 32
    //   3477: iload 9
    //   3479: aaload
    //   3480: ldc_w 414
    //   3483: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3486: istore 12
    //   3488: iload 16
    //   3490: istore 14
    //   3492: aload 18
    //   3494: astore 19
    //   3496: iload 12
    //   3498: ifeq +223 -> 3721
    //   3501: new 389	org/json/JSONObject
    //   3504: dup
    //   3505: aload 32
    //   3507: iload 9
    //   3509: aaload
    //   3510: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3513: ldc_w 552
    //   3516: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3519: astore 19
    //   3521: aload 19
    //   3523: astore 18
    //   3525: new 162	java/lang/StringBuilder
    //   3528: dup
    //   3529: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   3532: ldc_w 554
    //   3535: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3538: aload_0
    //   3539: iconst_5
    //   3540: aaload
    //   3541: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3544: ldc_w 548
    //   3547: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3550: aload_0
    //   3551: bipush 6
    //   3553: aaload
    //   3554: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3557: ldc_w 556
    //   3560: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3563: aload_0
    //   3564: iconst_0
    //   3565: aaload
    //   3566: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3569: ldc_w 548
    //   3572: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3575: ldc_w 552
    //   3578: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3581: aload 18
    //   3583: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3586: ldc_w 548
    //   3589: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3592: getstatic 92	com/chelpus/root/utils/createapkcustom:sddir	Ljava/lang/String;
    //   3595: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3598: ldc_w 548
    //   3601: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3604: getstatic 96	com/chelpus/root/utils/createapkcustom:tooldir	Ljava/lang/String;
    //   3607: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3610: ldc_w 375
    //   3613: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3616: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3619: astore 19
    //   3621: invokestatic 562	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3624: aload 19
    //   3626: invokevirtual 566	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   3629: astore 19
    //   3631: aload 19
    //   3633: invokevirtual 571	java/lang/Process:waitFor	()I
    //   3636: pop
    //   3637: new 573	java/io/DataInputStream
    //   3640: dup
    //   3641: aload 19
    //   3643: invokevirtual 577	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   3646: invokespecial 580	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   3649: astore 21
    //   3651: aload 21
    //   3653: invokevirtual 581	java/io/DataInputStream:available	()I
    //   3656: newarray <illegal type>
    //   3658: astore 22
    //   3660: aload 21
    //   3662: aload 22
    //   3664: invokevirtual 582	java/io/DataInputStream:read	([B)I
    //   3667: pop
    //   3668: new 352	java/lang/String
    //   3671: dup
    //   3672: aload 22
    //   3674: invokespecial 584	java/lang/String:<init>	([B)V
    //   3677: astore 21
    //   3679: aload 19
    //   3681: invokevirtual 587	java/lang/Process:destroy	()V
    //   3684: aload 21
    //   3686: ldc_w 589
    //   3689: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3692: ifeq +399 -> 4091
    //   3695: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   3698: ldc_w 591
    //   3701: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3704: iconst_1
    //   3705: istore 14
    //   3707: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   3710: invokestatic 593	com/chelpus/root/utils/createapkcustom:fixadler	(Ljava/io/File;)V
    //   3713: iconst_1
    //   3714: putstatic 84	com/chelpus/root/utils/createapkcustom:manualpatch	Z
    //   3717: aload 18
    //   3719: astore 19
    //   3721: aload 24
    //   3723: astore 23
    //   3725: aload 25
    //   3727: astore 22
    //   3729: iload_1
    //   3730: istore_2
    //   3731: iload 8
    //   3733: istore_3
    //   3734: iload 15
    //   3736: istore 13
    //   3738: aload 19
    //   3740: astore 21
    //   3742: aload 32
    //   3744: iload 9
    //   3746: aaload
    //   3747: ldc_w 594
    //   3750: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3753: ifeq +430 -> 4183
    //   3756: aload 24
    //   3758: astore 23
    //   3760: aload 25
    //   3762: astore 22
    //   3764: iload_1
    //   3765: istore_2
    //   3766: iload 8
    //   3768: istore_3
    //   3769: iload 15
    //   3771: istore 13
    //   3773: aload 19
    //   3775: astore 21
    //   3777: aload 32
    //   3779: iload 9
    //   3781: aaload
    //   3782: ldc_w 373
    //   3785: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3788: ifeq +395 -> 4183
    //   3791: aload 32
    //   3793: iload 9
    //   3795: aaload
    //   3796: ldc_w 414
    //   3799: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3802: istore 12
    //   3804: aload 24
    //   3806: astore 23
    //   3808: aload 25
    //   3810: astore 22
    //   3812: iload_1
    //   3813: istore_2
    //   3814: iload 8
    //   3816: istore_3
    //   3817: iload 15
    //   3819: istore 13
    //   3821: aload 19
    //   3823: astore 21
    //   3825: iload 12
    //   3827: ifeq +356 -> 4183
    //   3830: new 389	org/json/JSONObject
    //   3833: dup
    //   3834: aload 32
    //   3836: iload 9
    //   3838: aaload
    //   3839: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3842: ldc_w 594
    //   3845: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3848: astore 18
    //   3850: aload 18
    //   3852: invokevirtual 425	java/lang/String:trim	()Ljava/lang/String;
    //   3855: astore 21
    //   3857: aload 21
    //   3859: ldc_w 427
    //   3862: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3865: arraylength
    //   3866: anewarray 352	java/lang/String
    //   3869: astore 18
    //   3871: aload 21
    //   3873: ldc_w 427
    //   3876: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3879: astore 18
    //   3881: aload 18
    //   3883: arraylength
    //   3884: newarray <illegal type>
    //   3886: astore 22
    //   3888: aload 18
    //   3890: arraylength
    //   3891: newarray <illegal type>
    //   3893: astore 23
    //   3895: iconst_0
    //   3896: istore 4
    //   3898: iload_1
    //   3899: istore_3
    //   3900: iload_1
    //   3901: istore_2
    //   3902: iload 4
    //   3904: aload 18
    //   3906: arraylength
    //   3907: if_icmpge +257 -> 4164
    //   3910: iload_1
    //   3911: istore_2
    //   3912: iload_1
    //   3913: istore_3
    //   3914: aload 18
    //   3916: iload 4
    //   3918: aaload
    //   3919: ldc_w 433
    //   3922: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3925: ifeq +31 -> 3956
    //   3928: iload_1
    //   3929: istore_2
    //   3930: iload_1
    //   3931: istore_3
    //   3932: aload 18
    //   3934: iload 4
    //   3936: aaload
    //   3937: ldc_w 435
    //   3940: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3943: ifne +13 -> 3956
    //   3946: iconst_1
    //   3947: istore_2
    //   3948: aload 18
    //   3950: iload 4
    //   3952: ldc_w 437
    //   3955: aastore
    //   3956: iload_2
    //   3957: istore_3
    //   3958: aload 18
    //   3960: iload 4
    //   3962: aaload
    //   3963: ldc_w 435
    //   3966: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3969: ifne +2204 -> 6173
    //   3972: iload_2
    //   3973: istore_3
    //   3974: aload 18
    //   3976: iload 4
    //   3978: aaload
    //   3979: ldc_w 439
    //   3982: invokevirtual 443	java/lang/String:matches	(Ljava/lang/String;)Z
    //   3985: ifeq +139 -> 4124
    //   3988: goto +2185 -> 6173
    //   3991: iload_2
    //   3992: istore_3
    //   3993: aload 18
    //   3995: iload 4
    //   3997: aaload
    //   3998: invokevirtual 597	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   4001: ldc_w 449
    //   4004: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4007: ifeq +39 -> 4046
    //   4010: iload_2
    //   4011: istore_3
    //   4012: aload 22
    //   4014: iload 4
    //   4016: aload 18
    //   4018: iload 4
    //   4020: aaload
    //   4021: ldc_w 449
    //   4024: ldc 98
    //   4026: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   4029: invokestatic 464	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   4032: invokevirtual 467	java/lang/Integer:intValue	()I
    //   4035: iconst_2
    //   4036: iadd
    //   4037: iastore
    //   4038: aload 18
    //   4040: iload 4
    //   4042: ldc_w 437
    //   4045: aastore
    //   4046: iload_2
    //   4047: istore_3
    //   4048: aload 23
    //   4050: iload 4
    //   4052: aload 18
    //   4054: iload 4
    //   4056: aaload
    //   4057: bipush 16
    //   4059: invokestatic 470	java/lang/Integer:valueOf	(Ljava/lang/String;I)Ljava/lang/Integer;
    //   4062: invokevirtual 474	java/lang/Integer:byteValue	()B
    //   4065: bastore
    //   4066: iload 4
    //   4068: iconst_1
    //   4069: iadd
    //   4070: istore 4
    //   4072: iload_2
    //   4073: istore_1
    //   4074: goto -176 -> 3898
    //   4077: astore 19
    //   4079: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   4082: ldc_w 599
    //   4085: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4088: goto -563 -> 3525
    //   4091: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   4094: ldc_w 601
    //   4097: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4100: iconst_0
    //   4101: istore 14
    //   4103: goto -396 -> 3707
    //   4106: astore 18
    //   4108: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   4111: ldc_w 603
    //   4114: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4117: aload 19
    //   4119: astore 18
    //   4121: goto -271 -> 3850
    //   4124: aload 22
    //   4126: iload 4
    //   4128: iconst_0
    //   4129: iastore
    //   4130: goto -139 -> 3991
    //   4133: astore 18
    //   4135: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   4138: new 162	java/lang/StringBuilder
    //   4141: dup
    //   4142: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   4145: ldc_w 605
    //   4148: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4151: aload 18
    //   4153: invokevirtual 515	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4156: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4159: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4162: iload_3
    //   4163: istore_2
    //   4164: iload_2
    //   4165: ifeq +522 -> 4687
    //   4168: iconst_0
    //   4169: istore 13
    //   4171: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   4174: ldc_w 607
    //   4177: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4180: iload 8
    //   4182: istore_3
    //   4183: iload_2
    //   4184: istore_1
    //   4185: iload 13
    //   4187: istore 12
    //   4189: aload 17
    //   4191: astore 18
    //   4193: aload 32
    //   4195: iload 9
    //   4197: aaload
    //   4198: ldc_w 609
    //   4201: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4204: ifeq +723 -> 4927
    //   4207: iload_2
    //   4208: istore_1
    //   4209: iload 13
    //   4211: istore 12
    //   4213: aload 17
    //   4215: astore 18
    //   4217: aload 32
    //   4219: iload 9
    //   4221: aaload
    //   4222: ldc_w 373
    //   4225: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4228: ifeq +699 -> 4927
    //   4231: aload 32
    //   4233: iload 9
    //   4235: aaload
    //   4236: ldc_w 414
    //   4239: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4242: istore 15
    //   4244: iload_2
    //   4245: istore_1
    //   4246: iload 13
    //   4248: istore 12
    //   4250: aload 17
    //   4252: astore 18
    //   4254: iload 15
    //   4256: ifeq +671 -> 4927
    //   4259: new 389	org/json/JSONObject
    //   4262: dup
    //   4263: aload 32
    //   4265: iload 9
    //   4267: aaload
    //   4268: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4271: ldc_w 609
    //   4274: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4277: astore 18
    //   4279: aload 18
    //   4281: astore 17
    //   4283: aload 17
    //   4285: invokevirtual 425	java/lang/String:trim	()Ljava/lang/String;
    //   4288: astore 17
    //   4290: aload 17
    //   4292: ldc_w 427
    //   4295: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4298: arraylength
    //   4299: anewarray 352	java/lang/String
    //   4302: astore 18
    //   4304: aload 17
    //   4306: ldc_w 427
    //   4309: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4312: astore 18
    //   4314: aload 18
    //   4316: arraylength
    //   4317: newarray <illegal type>
    //   4319: astore 19
    //   4321: aload 18
    //   4323: arraylength
    //   4324: newarray <illegal type>
    //   4326: astore 24
    //   4328: iconst_0
    //   4329: istore 8
    //   4331: iload_2
    //   4332: istore 4
    //   4334: iload_2
    //   4335: istore_1
    //   4336: iload 8
    //   4338: aload 18
    //   4340: arraylength
    //   4341: if_icmpge +478 -> 4819
    //   4344: iload_2
    //   4345: istore_1
    //   4346: iload_2
    //   4347: istore 4
    //   4349: aload 18
    //   4351: iload 8
    //   4353: aaload
    //   4354: ldc_w 433
    //   4357: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4360: ifeq +32 -> 4392
    //   4363: iload_2
    //   4364: istore_1
    //   4365: iload_2
    //   4366: istore 4
    //   4368: aload 18
    //   4370: iload 8
    //   4372: aaload
    //   4373: ldc_w 435
    //   4376: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4379: ifne +13 -> 4392
    //   4382: iconst_1
    //   4383: istore_1
    //   4384: aload 18
    //   4386: iload 8
    //   4388: ldc_w 437
    //   4391: aastore
    //   4392: iload_1
    //   4393: istore 4
    //   4395: aload 18
    //   4397: iload 8
    //   4399: aaload
    //   4400: ldc_w 435
    //   4403: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4406: ifne +1784 -> 6190
    //   4409: iload_1
    //   4410: istore 4
    //   4412: aload 18
    //   4414: iload 8
    //   4416: aaload
    //   4417: ldc_w 439
    //   4420: invokevirtual 443	java/lang/String:matches	(Ljava/lang/String;)Z
    //   4423: ifeq +355 -> 4778
    //   4426: goto +1764 -> 6190
    //   4429: iload_1
    //   4430: istore 4
    //   4432: aload 18
    //   4434: iload 8
    //   4436: aaload
    //   4437: invokevirtual 454	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   4440: ldc_w 611
    //   4443: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4446: ifeq +19 -> 4465
    //   4449: aload 18
    //   4451: iload 8
    //   4453: ldc_w 437
    //   4456: aastore
    //   4457: aload 19
    //   4459: iload 8
    //   4461: sipush 253
    //   4464: iastore
    //   4465: iload_1
    //   4466: istore 4
    //   4468: aload 18
    //   4470: iload 8
    //   4472: aaload
    //   4473: ldc_w 613
    //   4476: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4479: ifne +1728 -> 6207
    //   4482: iload_1
    //   4483: istore 4
    //   4485: aload 18
    //   4487: iload 8
    //   4489: aaload
    //   4490: ldc_w 615
    //   4493: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4496: ifeq +6 -> 4502
    //   4499: goto +1708 -> 6207
    //   4502: iload_1
    //   4503: istore 4
    //   4505: aload 18
    //   4507: iload 8
    //   4509: aaload
    //   4510: ldc_w 617
    //   4513: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4516: ifne +1710 -> 6226
    //   4519: iload_1
    //   4520: istore 4
    //   4522: aload 18
    //   4524: iload 8
    //   4526: aaload
    //   4527: ldc_w 619
    //   4530: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4533: ifeq +6 -> 4539
    //   4536: goto +1690 -> 6226
    //   4539: iload_1
    //   4540: istore 4
    //   4542: aload 18
    //   4544: iload 8
    //   4546: aaload
    //   4547: ldc_w 445
    //   4550: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4553: ifne +54 -> 4607
    //   4556: iload_1
    //   4557: istore 4
    //   4559: aload 18
    //   4561: iload 8
    //   4563: aaload
    //   4564: ldc_w 447
    //   4567: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4570: ifne +37 -> 4607
    //   4573: iload_1
    //   4574: istore 4
    //   4576: aload 18
    //   4578: iload 8
    //   4580: aaload
    //   4581: ldc_w 449
    //   4584: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4587: ifne +20 -> 4607
    //   4590: iload_1
    //   4591: istore 4
    //   4593: aload 18
    //   4595: iload 8
    //   4597: aaload
    //   4598: ldc_w 449
    //   4601: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4604: ifeq +51 -> 4655
    //   4607: iload_1
    //   4608: istore 4
    //   4610: aload 19
    //   4612: iload 8
    //   4614: aload 18
    //   4616: iload 8
    //   4618: aaload
    //   4619: invokevirtual 454	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   4622: ldc_w 447
    //   4625: ldc 98
    //   4627: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   4630: ldc_w 451
    //   4633: ldc 98
    //   4635: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   4638: invokestatic 464	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   4641: invokevirtual 467	java/lang/Integer:intValue	()I
    //   4644: iconst_2
    //   4645: iadd
    //   4646: iastore
    //   4647: aload 18
    //   4649: iload 8
    //   4651: ldc_w 437
    //   4654: aastore
    //   4655: iload_1
    //   4656: istore 4
    //   4658: aload 24
    //   4660: iload 8
    //   4662: aload 18
    //   4664: iload 8
    //   4666: aaload
    //   4667: bipush 16
    //   4669: invokestatic 470	java/lang/Integer:valueOf	(Ljava/lang/String;I)Ljava/lang/Integer;
    //   4672: invokevirtual 474	java/lang/Integer:byteValue	()B
    //   4675: bastore
    //   4676: iload 8
    //   4678: iconst_1
    //   4679: iadd
    //   4680: istore 8
    //   4682: iload_1
    //   4683: istore_2
    //   4684: goto -353 -> 4331
    //   4687: iconst_1
    //   4688: istore_3
    //   4689: new 621	com/android/vending/billing/InAppBillingService/LACK/SearchItem
    //   4692: dup
    //   4693: aload 23
    //   4695: aload 22
    //   4697: invokespecial 624	com/android/vending/billing/InAppBillingService/LACK/SearchItem:<init>	([B[I)V
    //   4700: astore 18
    //   4702: aload 18
    //   4704: aload 23
    //   4706: arraylength
    //   4707: newarray <illegal type>
    //   4709: putfield 628	com/android/vending/billing/InAppBillingService/LACK/SearchItem:repByte	[B
    //   4712: getstatic 76	com/chelpus/root/utils/createapkcustom:ser	Ljava/util/ArrayList;
    //   4715: aload 18
    //   4717: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4720: pop
    //   4721: iload 15
    //   4723: istore 13
    //   4725: goto -542 -> 4183
    //   4728: astore 18
    //   4730: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   4733: new 162	java/lang/StringBuilder
    //   4736: dup
    //   4737: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   4740: ldc_w 548
    //   4743: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4746: aload 18
    //   4748: invokevirtual 515	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4751: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4754: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4757: iload 15
    //   4759: istore 13
    //   4761: goto -578 -> 4183
    //   4764: astore 18
    //   4766: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   4769: ldc_w 630
    //   4772: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4775: goto -492 -> 4283
    //   4778: aload 19
    //   4780: iload 8
    //   4782: iconst_1
    //   4783: iastore
    //   4784: goto -355 -> 4429
    //   4787: astore 18
    //   4789: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   4792: new 162	java/lang/StringBuilder
    //   4795: dup
    //   4796: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   4799: ldc_w 548
    //   4802: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4805: aload 18
    //   4807: invokevirtual 515	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4810: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4813: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4816: iload 4
    //   4818: istore_1
    //   4819: aload 19
    //   4821: arraylength
    //   4822: aload 22
    //   4824: arraylength
    //   4825: if_icmpne +1420 -> 6245
    //   4828: aload 23
    //   4830: arraylength
    //   4831: aload 24
    //   4833: arraylength
    //   4834: if_icmpne +1411 -> 6245
    //   4837: aload 24
    //   4839: arraylength
    //   4840: iconst_4
    //   4841: if_icmplt +1404 -> 6245
    //   4844: iload_1
    //   4845: istore_2
    //   4846: aload 23
    //   4848: arraylength
    //   4849: iconst_4
    //   4850: if_icmpge +6 -> 4856
    //   4853: goto +1392 -> 6245
    //   4856: iload_2
    //   4857: ifeq +15 -> 4872
    //   4860: iconst_0
    //   4861: istore 13
    //   4863: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   4866: ldc_w 632
    //   4869: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4872: iload_2
    //   4873: istore_1
    //   4874: iload 13
    //   4876: istore 12
    //   4878: aload 17
    //   4880: astore 18
    //   4882: iload_2
    //   4883: ifne +44 -> 4927
    //   4886: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   4889: new 634	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   4892: dup
    //   4893: aload 23
    //   4895: aload 22
    //   4897: aload 24
    //   4899: aload 19
    //   4901: getstatic 111	com/chelpus/root/utils/createapkcustom:group	Ljava/lang/String;
    //   4904: iconst_0
    //   4905: invokespecial 637	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:<init>	([B[I[B[ILjava/lang/String;Z)V
    //   4908: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4911: pop
    //   4912: ldc 98
    //   4914: putstatic 111	com/chelpus/root/utils/createapkcustom:group	Ljava/lang/String;
    //   4917: aload 17
    //   4919: astore 18
    //   4921: iload 13
    //   4923: istore 12
    //   4925: iload_2
    //   4926: istore_1
    //   4927: iload_1
    //   4928: istore_2
    //   4929: iload 12
    //   4931: istore 13
    //   4933: aload 18
    //   4935: astore 17
    //   4937: aload 32
    //   4939: iload 9
    //   4941: aaload
    //   4942: ldc_w 639
    //   4945: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4948: ifeq +634 -> 5582
    //   4951: iload_1
    //   4952: istore_2
    //   4953: iload 12
    //   4955: istore 13
    //   4957: aload 18
    //   4959: astore 17
    //   4961: aload 32
    //   4963: iload 9
    //   4965: aaload
    //   4966: ldc_w 373
    //   4969: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4972: ifeq +610 -> 5582
    //   4975: aload 32
    //   4977: iload 9
    //   4979: aaload
    //   4980: ldc_w 414
    //   4983: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4986: istore 15
    //   4988: iload_1
    //   4989: istore_2
    //   4990: iload 12
    //   4992: istore 13
    //   4994: aload 18
    //   4996: astore 17
    //   4998: iload 15
    //   5000: ifeq +582 -> 5582
    //   5003: new 389	org/json/JSONObject
    //   5006: dup
    //   5007: aload 32
    //   5009: iload 9
    //   5011: aaload
    //   5012: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5015: ldc_w 639
    //   5018: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5021: astore 17
    //   5023: aload 17
    //   5025: invokevirtual 425	java/lang/String:trim	()Ljava/lang/String;
    //   5028: astore 18
    //   5030: aload 18
    //   5032: ldc_w 427
    //   5035: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   5038: arraylength
    //   5039: anewarray 352	java/lang/String
    //   5042: astore 17
    //   5044: aload 18
    //   5046: ldc_w 427
    //   5049: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   5052: astore 17
    //   5054: aload 17
    //   5056: arraylength
    //   5057: newarray <illegal type>
    //   5059: astore 19
    //   5061: aload 17
    //   5063: arraylength
    //   5064: newarray <illegal type>
    //   5066: astore 24
    //   5068: iconst_0
    //   5069: istore 8
    //   5071: iload_1
    //   5072: istore 4
    //   5074: iload_1
    //   5075: istore_2
    //   5076: iload 8
    //   5078: aload 17
    //   5080: arraylength
    //   5081: if_icmpge +401 -> 5482
    //   5084: iload_1
    //   5085: istore_2
    //   5086: iload_1
    //   5087: istore 4
    //   5089: aload 17
    //   5091: iload 8
    //   5093: aaload
    //   5094: ldc_w 433
    //   5097: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5100: ifeq +32 -> 5132
    //   5103: iload_1
    //   5104: istore_2
    //   5105: iload_1
    //   5106: istore 4
    //   5108: aload 17
    //   5110: iload 8
    //   5112: aaload
    //   5113: ldc_w 435
    //   5116: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5119: ifne +13 -> 5132
    //   5122: iconst_1
    //   5123: istore_2
    //   5124: aload 17
    //   5126: iload 8
    //   5128: ldc_w 437
    //   5131: aastore
    //   5132: iload_2
    //   5133: istore 4
    //   5135: aload 17
    //   5137: iload 8
    //   5139: aaload
    //   5140: ldc_w 435
    //   5143: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5146: ifne +1104 -> 6250
    //   5149: iload_2
    //   5150: istore 4
    //   5152: aload 17
    //   5154: iload 8
    //   5156: aaload
    //   5157: ldc_w 439
    //   5160: invokevirtual 443	java/lang/String:matches	(Ljava/lang/String;)Z
    //   5163: ifeq +280 -> 5443
    //   5166: goto +1084 -> 6250
    //   5169: iload_2
    //   5170: istore 4
    //   5172: aload 17
    //   5174: iload 8
    //   5176: aaload
    //   5177: invokevirtual 454	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   5180: ldc_w 611
    //   5183: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5186: ifeq +19 -> 5205
    //   5189: aload 17
    //   5191: iload 8
    //   5193: ldc_w 437
    //   5196: aastore
    //   5197: aload 19
    //   5199: iload 8
    //   5201: sipush 253
    //   5204: iastore
    //   5205: iload_2
    //   5206: istore 4
    //   5208: aload 17
    //   5210: iload 8
    //   5212: aaload
    //   5213: ldc_w 613
    //   5216: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5219: ifne +1048 -> 6267
    //   5222: iload_2
    //   5223: istore 4
    //   5225: aload 17
    //   5227: iload 8
    //   5229: aaload
    //   5230: ldc_w 615
    //   5233: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5236: ifeq +6 -> 5242
    //   5239: goto +1028 -> 6267
    //   5242: iload_2
    //   5243: istore 4
    //   5245: aload 17
    //   5247: iload 8
    //   5249: aaload
    //   5250: ldc_w 617
    //   5253: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5256: ifne +1030 -> 6286
    //   5259: iload_2
    //   5260: istore 4
    //   5262: aload 17
    //   5264: iload 8
    //   5266: aaload
    //   5267: ldc_w 619
    //   5270: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5273: ifeq +6 -> 5279
    //   5276: goto +1010 -> 6286
    //   5279: iload_2
    //   5280: istore 4
    //   5282: aload 17
    //   5284: iload 8
    //   5286: aaload
    //   5287: ldc_w 445
    //   5290: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5293: ifne +54 -> 5347
    //   5296: iload_2
    //   5297: istore 4
    //   5299: aload 17
    //   5301: iload 8
    //   5303: aaload
    //   5304: ldc_w 447
    //   5307: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5310: ifne +37 -> 5347
    //   5313: iload_2
    //   5314: istore 4
    //   5316: aload 17
    //   5318: iload 8
    //   5320: aaload
    //   5321: ldc_w 449
    //   5324: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5327: ifne +20 -> 5347
    //   5330: iload_2
    //   5331: istore 4
    //   5333: aload 17
    //   5335: iload 8
    //   5337: aaload
    //   5338: ldc_w 449
    //   5341: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5344: ifeq +51 -> 5395
    //   5347: iload_2
    //   5348: istore 4
    //   5350: aload 19
    //   5352: iload 8
    //   5354: aload 17
    //   5356: iload 8
    //   5358: aaload
    //   5359: invokevirtual 454	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   5362: ldc_w 447
    //   5365: ldc 98
    //   5367: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   5370: ldc_w 451
    //   5373: ldc 98
    //   5375: invokevirtual 458	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   5378: invokestatic 464	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   5381: invokevirtual 467	java/lang/Integer:intValue	()I
    //   5384: iconst_2
    //   5385: iadd
    //   5386: iastore
    //   5387: aload 17
    //   5389: iload 8
    //   5391: ldc_w 437
    //   5394: aastore
    //   5395: iload_2
    //   5396: istore 4
    //   5398: aload 24
    //   5400: iload 8
    //   5402: aload 17
    //   5404: iload 8
    //   5406: aaload
    //   5407: bipush 16
    //   5409: invokestatic 470	java/lang/Integer:valueOf	(Ljava/lang/String;I)Ljava/lang/Integer;
    //   5412: invokevirtual 474	java/lang/Integer:byteValue	()B
    //   5415: bastore
    //   5416: iload 8
    //   5418: iconst_1
    //   5419: iadd
    //   5420: istore 8
    //   5422: iload_2
    //   5423: istore_1
    //   5424: goto -353 -> 5071
    //   5427: astore 17
    //   5429: ldc_w 641
    //   5432: invokestatic 644	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   5435: pop
    //   5436: aload 18
    //   5438: astore 17
    //   5440: goto -417 -> 5023
    //   5443: aload 19
    //   5445: iload 8
    //   5447: iconst_1
    //   5448: iastore
    //   5449: goto -280 -> 5169
    //   5452: astore 17
    //   5454: new 162	java/lang/StringBuilder
    //   5457: dup
    //   5458: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   5461: ldc_w 548
    //   5464: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5467: aload 17
    //   5469: invokevirtual 515	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5472: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5475: invokestatic 644	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   5478: pop
    //   5479: iload 4
    //   5481: istore_2
    //   5482: aload 24
    //   5484: arraylength
    //   5485: iconst_4
    //   5486: if_icmplt +819 -> 6305
    //   5489: iload_2
    //   5490: istore_1
    //   5491: aload 23
    //   5493: arraylength
    //   5494: iconst_4
    //   5495: if_icmpge +6 -> 5501
    //   5498: goto +807 -> 6305
    //   5501: iload_1
    //   5502: ifeq +13 -> 5515
    //   5505: iconst_0
    //   5506: istore 12
    //   5508: ldc_w 646
    //   5511: invokestatic 644	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   5514: pop
    //   5515: iload_1
    //   5516: istore_2
    //   5517: iload 12
    //   5519: istore 13
    //   5521: aload 18
    //   5523: astore 17
    //   5525: iload_1
    //   5526: ifne +56 -> 5582
    //   5529: getstatic 119	com/chelpus/root/utils/createapkcustom:multilib_patch	Z
    //   5532: ifne +9 -> 5541
    //   5535: getstatic 115	com/chelpus/root/utils/createapkcustom:multidex	Z
    //   5538: ifeq +367 -> 5905
    //   5541: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   5544: new 634	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   5547: dup
    //   5548: aload 23
    //   5550: aload 22
    //   5552: aload 24
    //   5554: aload 19
    //   5556: ldc_w 648
    //   5559: iconst_1
    //   5560: invokespecial 637	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:<init>	([B[I[B[ILjava/lang/String;Z)V
    //   5563: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   5566: pop
    //   5567: ldc 98
    //   5569: putstatic 111	com/chelpus/root/utils/createapkcustom:group	Ljava/lang/String;
    //   5572: aload 18
    //   5574: astore 17
    //   5576: iload 12
    //   5578: istore 13
    //   5580: iload_1
    //   5581: istore_2
    //   5582: iload 13
    //   5584: istore 12
    //   5586: aload 17
    //   5588: astore 18
    //   5590: aload 32
    //   5592: iload 9
    //   5594: aaload
    //   5595: ldc_w 650
    //   5598: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5601: ifeq +243 -> 5844
    //   5604: iload 13
    //   5606: istore 12
    //   5608: aload 17
    //   5610: astore 18
    //   5612: aload 32
    //   5614: iload 9
    //   5616: aaload
    //   5617: ldc_w 373
    //   5620: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5623: ifeq +221 -> 5844
    //   5626: aload 32
    //   5628: iload 9
    //   5630: aaload
    //   5631: ldc_w 414
    //   5634: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5637: istore 15
    //   5639: iload 13
    //   5641: istore 12
    //   5643: aload 17
    //   5645: astore 18
    //   5647: iload 15
    //   5649: ifeq +195 -> 5844
    //   5652: new 389	org/json/JSONObject
    //   5655: dup
    //   5656: aload 32
    //   5658: iload 9
    //   5660: aaload
    //   5661: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5664: ldc_w 650
    //   5667: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5670: astore 18
    //   5672: aload 18
    //   5674: astore 17
    //   5676: aload 17
    //   5678: invokevirtual 425	java/lang/String:trim	()Ljava/lang/String;
    //   5681: astore 17
    //   5683: new 189	java/io/File
    //   5686: dup
    //   5687: new 162	java/lang/StringBuilder
    //   5690: dup
    //   5691: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   5694: new 189	java/io/File
    //   5697: dup
    //   5698: aload_0
    //   5699: iconst_1
    //   5700: aaload
    //   5701: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   5704: invokestatic 654	com/chelpus/Utils:getDirs	(Ljava/io/File;)Ljava/io/File;
    //   5707: invokevirtual 515	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5710: ldc_w 656
    //   5713: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5716: aload 17
    //   5718: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5721: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5724: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   5727: astore 18
    //   5729: aload 18
    //   5731: invokevirtual 659	java/io/File:length	()J
    //   5734: l2i
    //   5735: istore_1
    //   5736: iload_1
    //   5737: newarray <illegal type>
    //   5739: astore 19
    //   5741: new 228	java/io/FileInputStream
    //   5744: dup
    //   5745: aload 18
    //   5747: invokespecial 230	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   5750: astore 18
    //   5752: aload 18
    //   5754: aload 19
    //   5756: invokevirtual 238	java/io/FileInputStream:read	([B)I
    //   5759: istore 4
    //   5761: iload 4
    //   5763: ifgt -11 -> 5752
    //   5766: iload_1
    //   5767: newarray <illegal type>
    //   5769: astore 24
    //   5771: aload 24
    //   5773: iconst_1
    //   5774: invokestatic 665	java/util/Arrays:fill	([II)V
    //   5777: iload_2
    //   5778: ifeq +15 -> 5793
    //   5781: iconst_0
    //   5782: istore 13
    //   5784: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   5787: ldc_w 632
    //   5790: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5793: iload 13
    //   5795: istore 12
    //   5797: aload 17
    //   5799: astore 18
    //   5801: iload_2
    //   5802: ifne +42 -> 5844
    //   5805: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   5808: new 634	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   5811: dup
    //   5812: aload 23
    //   5814: aload 22
    //   5816: aload 19
    //   5818: aload 24
    //   5820: getstatic 111	com/chelpus/root/utils/createapkcustom:group	Ljava/lang/String;
    //   5823: iconst_0
    //   5824: invokespecial 637	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:<init>	([B[I[B[ILjava/lang/String;Z)V
    //   5827: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   5830: pop
    //   5831: ldc 98
    //   5833: putstatic 111	com/chelpus/root/utils/createapkcustom:group	Ljava/lang/String;
    //   5836: aload 17
    //   5838: astore 18
    //   5840: iload 13
    //   5842: istore 12
    //   5844: aload 26
    //   5846: astore 17
    //   5848: iload 10
    //   5850: ifeq +34 -> 5884
    //   5853: new 162	java/lang/StringBuilder
    //   5856: dup
    //   5857: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   5860: aload 26
    //   5862: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5865: ldc_w 375
    //   5868: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5871: aload 32
    //   5873: iload 9
    //   5875: aaload
    //   5876: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5879: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5882: astore 17
    //   5884: aload 27
    //   5886: ldc_w 667
    //   5889: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5892: ifeq +418 -> 6310
    //   5895: iconst_4
    //   5896: putstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   5899: iconst_1
    //   5900: istore 10
    //   5902: goto +408 -> 6310
    //   5905: getstatic 74	com/chelpus/root/utils/createapkcustom:pat	Ljava/util/ArrayList;
    //   5908: new 634	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   5911: dup
    //   5912: aload 23
    //   5914: aload 22
    //   5916: aload 24
    //   5918: aload 19
    //   5920: getstatic 111	com/chelpus/root/utils/createapkcustom:group	Ljava/lang/String;
    //   5923: iconst_1
    //   5924: invokespecial 637	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:<init>	([B[I[B[ILjava/lang/String;Z)V
    //   5927: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   5930: pop
    //   5931: goto -364 -> 5567
    //   5934: astore 18
    //   5936: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   5939: ldc_w 630
    //   5942: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5945: goto -269 -> 5676
    //   5948: astore 18
    //   5950: aload 18
    //   5952: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   5955: goto -189 -> 5766
    //   5958: iload 14
    //   5960: ifeq +29 -> 5989
    //   5963: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   5966: new 162	java/lang/StringBuilder
    //   5969: dup
    //   5970: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   5973: ldc 98
    //   5975: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5978: aload 26
    //   5980: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5983: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5986: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5989: iload 14
    //   5991: ifne +18 -> 6009
    //   5994: getstatic 80	com/chelpus/root/utils/createapkcustom:patchteil	Z
    //   5997: ifeq +23 -> 6020
    //   6000: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   6003: ldc_w 669
    //   6006: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   6009: invokestatic 329	com/chelpus/root/utils/createapkcustom:clearTemp	()V
    //   6012: aload 30
    //   6014: invokevirtual 245	java/io/FileInputStream:close	()V
    //   6017: goto -4125 -> 1892
    //   6020: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   6023: ldc_w 671
    //   6026: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   6029: goto -20 -> 6009
    //   6032: astore 17
    //   6034: aload 17
    //   6036: invokevirtual 672	java/io/IOException:printStackTrace	()V
    //   6039: aload_0
    //   6040: areturn
    //   6041: iload 12
    //   6043: istore 15
    //   6045: iload 14
    //   6047: istore 13
    //   6049: goto -5529 -> 520
    //   6052: iconst_0
    //   6053: istore_1
    //   6054: aload 19
    //   6056: astore 20
    //   6058: goto -5298 -> 760
    //   6061: iconst_0
    //   6062: istore 4
    //   6064: goto -5222 -> 842
    //   6067: aload 23
    //   6069: iload 11
    //   6071: ldc_w 437
    //   6074: aastore
    //   6075: aload 21
    //   6077: iload 11
    //   6079: iconst_1
    //   6080: iastore
    //   6081: goto -4604 -> 1477
    //   6084: iload 14
    //   6086: istore 12
    //   6088: iload 14
    //   6090: ifne -4377 -> 1713
    //   6093: iconst_0
    //   6094: istore 13
    //   6096: iload 14
    //   6098: istore 12
    //   6100: goto -4387 -> 1713
    //   6103: iload 14
    //   6105: istore 13
    //   6107: iload 12
    //   6109: ifne -4075 -> 2034
    //   6112: iconst_0
    //   6113: istore 13
    //   6115: goto -4081 -> 2034
    //   6118: iload 12
    //   6120: ifne -3848 -> 2272
    //   6123: iconst_0
    //   6124: istore 13
    //   6126: goto -3854 -> 2272
    //   6129: iload 12
    //   6131: ifne -3636 -> 2495
    //   6134: iconst_0
    //   6135: istore 13
    //   6137: goto -3642 -> 2495
    //   6140: iload 12
    //   6142: ifne -3432 -> 2710
    //   6145: iconst_0
    //   6146: istore 13
    //   6148: goto -3438 -> 2710
    //   6151: iload 12
    //   6153: ifne -3228 -> 2925
    //   6156: iconst_0
    //   6157: istore 13
    //   6159: goto -3234 -> 2925
    //   6162: iload 12
    //   6164: ifne -3024 -> 3140
    //   6167: iconst_0
    //   6168: istore 13
    //   6170: goto -3030 -> 3140
    //   6173: aload 18
    //   6175: iload 4
    //   6177: ldc_w 437
    //   6180: aastore
    //   6181: aload 22
    //   6183: iload 4
    //   6185: iconst_1
    //   6186: iastore
    //   6187: goto -2196 -> 3991
    //   6190: aload 18
    //   6192: iload 8
    //   6194: ldc_w 437
    //   6197: aastore
    //   6198: aload 19
    //   6200: iload 8
    //   6202: iconst_0
    //   6203: iastore
    //   6204: goto -1775 -> 4429
    //   6207: aload 18
    //   6209: iload 8
    //   6211: ldc_w 437
    //   6214: aastore
    //   6215: aload 19
    //   6217: iload 8
    //   6219: sipush 254
    //   6222: iastore
    //   6223: goto -1721 -> 4502
    //   6226: aload 18
    //   6228: iload 8
    //   6230: ldc_w 437
    //   6233: aastore
    //   6234: aload 19
    //   6236: iload 8
    //   6238: sipush 255
    //   6241: iastore
    //   6242: goto -1703 -> 4539
    //   6245: iconst_1
    //   6246: istore_2
    //   6247: goto -1391 -> 4856
    //   6250: aload 17
    //   6252: iload 8
    //   6254: ldc_w 437
    //   6257: aastore
    //   6258: aload 19
    //   6260: iload 8
    //   6262: iconst_0
    //   6263: iastore
    //   6264: goto -1095 -> 5169
    //   6267: aload 17
    //   6269: iload 8
    //   6271: ldc_w 437
    //   6274: aastore
    //   6275: aload 19
    //   6277: iload 8
    //   6279: sipush 254
    //   6282: iastore
    //   6283: goto -1041 -> 5242
    //   6286: aload 17
    //   6288: iload 8
    //   6290: ldc_w 437
    //   6293: aastore
    //   6294: aload 19
    //   6296: iload 8
    //   6298: sipush 255
    //   6301: iastore
    //   6302: goto -1023 -> 5279
    //   6305: iconst_1
    //   6306: istore_1
    //   6307: goto -806 -> 5501
    //   6310: iload 9
    //   6312: iconst_1
    //   6313: iadd
    //   6314: istore 9
    //   6316: aload 28
    //   6318: astore 24
    //   6320: aload 17
    //   6322: astore 26
    //   6324: aload 20
    //   6326: astore 19
    //   6328: aload 18
    //   6330: astore 17
    //   6332: aload 21
    //   6334: astore 18
    //   6336: goto -6096 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6339	0	paramArrayOfString	String[]
    //   285	6022	1	i	int
    //   124	6123	2	j	int
    //   191	4498	3	k	int
    //   762	5422	4	m	int
    //   188	355	5	n	int
    //   185	828	6	i1	int
    //   193	823	7	i2	int
    //   1095	5202	8	i3	int
    //   238	6077	9	i4	int
    //   126	5775	10	i5	int
    //   1362	4716	11	i6	int
    //   179	5984	12	bool1	boolean
    //   415	5754	13	bool2	boolean
    //   182	5922	14	bool3	boolean
    //   411	5633	15	bool4	boolean
    //   1099	2390	16	bool5	boolean
    //   94	108	17	localObject1	Object
    //   1619	2632	17	localException1	Exception
    //   4281	1122	17	localObject2	Object
    //   5427	1	17	localJSONException1	org.json.JSONException
    //   5438	1	17	localObject3	Object
    //   5452	16	17	localException2	Exception
    //   5523	360	17	localObject4	Object
    //   6032	289	17	localIOException	java.io.IOException
    //   6330	1	17	localObject5	Object
    //   205	3848	18	localObject6	Object
    //   4106	1	18	localJSONException2	org.json.JSONException
    //   4119	1	18	localJSONException3	org.json.JSONException
    //   4133	19	18	localException3	Exception
    //   4191	525	18	localObject7	Object
    //   4728	19	18	localException4	Exception
    //   4764	1	18	localJSONException4	org.json.JSONException
    //   4787	19	18	localException5	Exception
    //   4880	959	18	localObject8	Object
    //   5934	1	18	localJSONException5	org.json.JSONException
    //   5948	381	18	localException6	Exception
    //   6334	1	18	localObject9	Object
    //   197	3087	19	localObject10	Object
    //   3294	1	19	localJSONException6	org.json.JSONException
    //   3307	515	19	localObject11	Object
    //   4077	41	19	localJSONException7	org.json.JSONException
    //   4319	2008	19	localObject12	Object
    //   245	2753	20	localObject13	Object
    //   3190	116	20	localJSONException8	org.json.JSONException
    //   3324	1	20	localJSONException9	org.json.JSONException
    //   3357	1	20	localJSONException10	org.json.JSONException
    //   3380	19	20	localException7	Exception
    //   3411	2914	20	localObject14	Object
    //   1352	4981	21	localObject15	Object
    //   176	6006	22	localObject16	Object
    //   173	5895	23	localObject17	Object
    //   121	6198	24	localObject18	Object
    //   1090	2719	25	localObject19	Object
    //   117	6206	26	localObject20	Object
    //   254	5631	27	localObject21	Object
    //   372	5945	28	localObject22	Object
    //   10	1899	29	localLogOutputStream	com.android.vending.billing.InAppBillingService.LACK.LogOutputStream
    //   141	5872	30	localFileInputStream	FileInputStream
    //   162	79	31	localBufferedReader	java.io.BufferedReader
    //   170	5702	32	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   66	111	1619	java/lang/Exception
    //   131	172	1882	java/io/FileNotFoundException
    //   207	237	1882	java/io/FileNotFoundException
    //   240	247	1882	java/io/FileNotFoundException
    //   256	276	1882	java/io/FileNotFoundException
    //   291	319	1882	java/io/FileNotFoundException
    //   322	336	1882	java/io/FileNotFoundException
    //   336	368	1882	java/io/FileNotFoundException
    //   378	409	1882	java/io/FileNotFoundException
    //   417	431	1882	java/io/FileNotFoundException
    //   439	453	1882	java/io/FileNotFoundException
    //   461	520	1882	java/io/FileNotFoundException
    //   523	541	1882	java/io/FileNotFoundException
    //   544	572	1882	java/io/FileNotFoundException
    //   572	594	1882	java/io/FileNotFoundException
    //   594	630	1882	java/io/FileNotFoundException
    //   630	661	1882	java/io/FileNotFoundException
    //   673	685	1882	java/io/FileNotFoundException
    //   685	705	1882	java/io/FileNotFoundException
    //   709	760	1882	java/io/FileNotFoundException
    //   773	785	1882	java/io/FileNotFoundException
    //   785	805	1882	java/io/FileNotFoundException
    //   805	839	1882	java/io/FileNotFoundException
    //   842	865	1882	java/io/FileNotFoundException
    //   870	893	1882	java/io/FileNotFoundException
    //   898	921	1882	java/io/FileNotFoundException
    //   926	949	1882	java/io/FileNotFoundException
    //   954	976	1882	java/io/FileNotFoundException
    //   988	1011	1882	java/io/FileNotFoundException
    //   1017	1058	1882	java/io/FileNotFoundException
    //   1063	1084	1882	java/io/FileNotFoundException
    //   1105	1119	1882	java/io/FileNotFoundException
    //   1140	1154	1882	java/io/FileNotFoundException
    //   1175	1189	1882	java/io/FileNotFoundException
    //   1200	1243	1882	java/io/FileNotFoundException
    //   1250	1281	1882	java/io/FileNotFoundException
    //   1292	1312	1882	java/io/FileNotFoundException
    //   1316	1361	1882	java/io/FileNotFoundException
    //   1388	1396	1882	java/io/FileNotFoundException
    //   1400	1414	1882	java/io/FileNotFoundException
    //   1418	1432	1882	java/io/FileNotFoundException
    //   1444	1458	1882	java/io/FileNotFoundException
    //   1460	1474	1882	java/io/FileNotFoundException
    //   1479	1493	1882	java/io/FileNotFoundException
    //   1495	1509	1882	java/io/FileNotFoundException
    //   1511	1525	1882	java/io/FileNotFoundException
    //   1527	1541	1882	java/io/FileNotFoundException
    //   1543	1580	1882	java/io/FileNotFoundException
    //   1590	1608	1882	java/io/FileNotFoundException
    //   1629	1656	1882	java/io/FileNotFoundException
    //   1664	1670	1882	java/io/FileNotFoundException
    //   1678	1701	1882	java/io/FileNotFoundException
    //   1701	1709	1882	java/io/FileNotFoundException
    //   1713	1823	1882	java/io/FileNotFoundException
    //   1827	1841	1882	java/io/FileNotFoundException
    //   1844	1875	1882	java/io/FileNotFoundException
    //   1915	2017	1882	java/io/FileNotFoundException
    //   2017	2031	1882	java/io/FileNotFoundException
    //   2034	2070	1882	java/io/FileNotFoundException
    //   2107	2115	1882	java/io/FileNotFoundException
    //   2119	2255	1882	java/io/FileNotFoundException
    //   2255	2269	1882	java/io/FileNotFoundException
    //   2272	2281	1882	java/io/FileNotFoundException
    //   2292	2323	1882	java/io/FileNotFoundException
    //   2330	2338	1882	java/io/FileNotFoundException
    //   2342	2478	1882	java/io/FileNotFoundException
    //   2478	2492	1882	java/io/FileNotFoundException
    //   2495	2504	1882	java/io/FileNotFoundException
    //   2507	2538	1882	java/io/FileNotFoundException
    //   2545	2553	1882	java/io/FileNotFoundException
    //   2557	2693	1882	java/io/FileNotFoundException
    //   2693	2707	1882	java/io/FileNotFoundException
    //   2710	2719	1882	java/io/FileNotFoundException
    //   2722	2753	1882	java/io/FileNotFoundException
    //   2760	2768	1882	java/io/FileNotFoundException
    //   2772	2908	1882	java/io/FileNotFoundException
    //   2908	2922	1882	java/io/FileNotFoundException
    //   2925	2934	1882	java/io/FileNotFoundException
    //   2937	2968	1882	java/io/FileNotFoundException
    //   2975	2983	1882	java/io/FileNotFoundException
    //   2987	3123	1882	java/io/FileNotFoundException
    //   3123	3137	1882	java/io/FileNotFoundException
    //   3140	3149	1882	java/io/FileNotFoundException
    //   3152	3183	1882	java/io/FileNotFoundException
    //   3192	3201	1882	java/io/FileNotFoundException
    //   3204	3219	1882	java/io/FileNotFoundException
    //   3222	3237	1882	java/io/FileNotFoundException
    //   3240	3255	1882	java/io/FileNotFoundException
    //   3258	3273	1882	java/io/FileNotFoundException
    //   3276	3291	1882	java/io/FileNotFoundException
    //   3296	3305	1882	java/io/FileNotFoundException
    //   3312	3321	1882	java/io/FileNotFoundException
    //   3326	3340	1882	java/io/FileNotFoundException
    //   3343	3351	1882	java/io/FileNotFoundException
    //   3359	3368	1882	java/io/FileNotFoundException
    //   3382	3409	1882	java/io/FileNotFoundException
    //   3439	3453	1882	java/io/FileNotFoundException
    //   3461	3488	1882	java/io/FileNotFoundException
    //   3501	3521	1882	java/io/FileNotFoundException
    //   3525	3704	1882	java/io/FileNotFoundException
    //   3707	3717	1882	java/io/FileNotFoundException
    //   3742	3756	1882	java/io/FileNotFoundException
    //   3777	3804	1882	java/io/FileNotFoundException
    //   3830	3850	1882	java/io/FileNotFoundException
    //   3850	3895	1882	java/io/FileNotFoundException
    //   3902	3910	1882	java/io/FileNotFoundException
    //   3914	3928	1882	java/io/FileNotFoundException
    //   3932	3946	1882	java/io/FileNotFoundException
    //   3958	3972	1882	java/io/FileNotFoundException
    //   3974	3988	1882	java/io/FileNotFoundException
    //   3993	4010	1882	java/io/FileNotFoundException
    //   4012	4038	1882	java/io/FileNotFoundException
    //   4048	4066	1882	java/io/FileNotFoundException
    //   4079	4088	1882	java/io/FileNotFoundException
    //   4091	4100	1882	java/io/FileNotFoundException
    //   4108	4117	1882	java/io/FileNotFoundException
    //   4135	4162	1882	java/io/FileNotFoundException
    //   4171	4180	1882	java/io/FileNotFoundException
    //   4193	4207	1882	java/io/FileNotFoundException
    //   4217	4244	1882	java/io/FileNotFoundException
    //   4259	4279	1882	java/io/FileNotFoundException
    //   4283	4328	1882	java/io/FileNotFoundException
    //   4336	4344	1882	java/io/FileNotFoundException
    //   4349	4363	1882	java/io/FileNotFoundException
    //   4368	4382	1882	java/io/FileNotFoundException
    //   4395	4409	1882	java/io/FileNotFoundException
    //   4412	4426	1882	java/io/FileNotFoundException
    //   4432	4449	1882	java/io/FileNotFoundException
    //   4468	4482	1882	java/io/FileNotFoundException
    //   4485	4499	1882	java/io/FileNotFoundException
    //   4505	4519	1882	java/io/FileNotFoundException
    //   4522	4536	1882	java/io/FileNotFoundException
    //   4542	4556	1882	java/io/FileNotFoundException
    //   4559	4573	1882	java/io/FileNotFoundException
    //   4576	4590	1882	java/io/FileNotFoundException
    //   4593	4607	1882	java/io/FileNotFoundException
    //   4610	4647	1882	java/io/FileNotFoundException
    //   4658	4676	1882	java/io/FileNotFoundException
    //   4689	4721	1882	java/io/FileNotFoundException
    //   4730	4757	1882	java/io/FileNotFoundException
    //   4766	4775	1882	java/io/FileNotFoundException
    //   4789	4816	1882	java/io/FileNotFoundException
    //   4819	4844	1882	java/io/FileNotFoundException
    //   4846	4853	1882	java/io/FileNotFoundException
    //   4863	4872	1882	java/io/FileNotFoundException
    //   4886	4917	1882	java/io/FileNotFoundException
    //   4937	4951	1882	java/io/FileNotFoundException
    //   4961	4988	1882	java/io/FileNotFoundException
    //   5003	5023	1882	java/io/FileNotFoundException
    //   5023	5068	1882	java/io/FileNotFoundException
    //   5076	5084	1882	java/io/FileNotFoundException
    //   5089	5103	1882	java/io/FileNotFoundException
    //   5108	5122	1882	java/io/FileNotFoundException
    //   5135	5149	1882	java/io/FileNotFoundException
    //   5152	5166	1882	java/io/FileNotFoundException
    //   5172	5189	1882	java/io/FileNotFoundException
    //   5208	5222	1882	java/io/FileNotFoundException
    //   5225	5239	1882	java/io/FileNotFoundException
    //   5245	5259	1882	java/io/FileNotFoundException
    //   5262	5276	1882	java/io/FileNotFoundException
    //   5282	5296	1882	java/io/FileNotFoundException
    //   5299	5313	1882	java/io/FileNotFoundException
    //   5316	5330	1882	java/io/FileNotFoundException
    //   5333	5347	1882	java/io/FileNotFoundException
    //   5350	5387	1882	java/io/FileNotFoundException
    //   5398	5416	1882	java/io/FileNotFoundException
    //   5429	5436	1882	java/io/FileNotFoundException
    //   5454	5479	1882	java/io/FileNotFoundException
    //   5482	5489	1882	java/io/FileNotFoundException
    //   5491	5498	1882	java/io/FileNotFoundException
    //   5508	5515	1882	java/io/FileNotFoundException
    //   5529	5541	1882	java/io/FileNotFoundException
    //   5541	5567	1882	java/io/FileNotFoundException
    //   5567	5572	1882	java/io/FileNotFoundException
    //   5590	5604	1882	java/io/FileNotFoundException
    //   5612	5639	1882	java/io/FileNotFoundException
    //   5652	5672	1882	java/io/FileNotFoundException
    //   5676	5741	1882	java/io/FileNotFoundException
    //   5741	5752	1882	java/io/FileNotFoundException
    //   5752	5761	1882	java/io/FileNotFoundException
    //   5766	5777	1882	java/io/FileNotFoundException
    //   5784	5793	1882	java/io/FileNotFoundException
    //   5805	5836	1882	java/io/FileNotFoundException
    //   5853	5884	1882	java/io/FileNotFoundException
    //   5884	5899	1882	java/io/FileNotFoundException
    //   5905	5931	1882	java/io/FileNotFoundException
    //   5936	5945	1882	java/io/FileNotFoundException
    //   5950	5955	1882	java/io/FileNotFoundException
    //   5963	5989	1882	java/io/FileNotFoundException
    //   5994	6009	1882	java/io/FileNotFoundException
    //   6009	6017	1882	java/io/FileNotFoundException
    //   6020	6029	1882	java/io/FileNotFoundException
    //   131	172	2077	java/io/IOException
    //   207	237	2077	java/io/IOException
    //   240	247	2077	java/io/IOException
    //   256	276	2077	java/io/IOException
    //   291	319	2077	java/io/IOException
    //   322	336	2077	java/io/IOException
    //   336	368	2077	java/io/IOException
    //   378	409	2077	java/io/IOException
    //   417	431	2077	java/io/IOException
    //   439	453	2077	java/io/IOException
    //   461	520	2077	java/io/IOException
    //   523	541	2077	java/io/IOException
    //   544	572	2077	java/io/IOException
    //   572	594	2077	java/io/IOException
    //   594	630	2077	java/io/IOException
    //   630	661	2077	java/io/IOException
    //   673	685	2077	java/io/IOException
    //   685	705	2077	java/io/IOException
    //   709	760	2077	java/io/IOException
    //   773	785	2077	java/io/IOException
    //   785	805	2077	java/io/IOException
    //   805	839	2077	java/io/IOException
    //   842	865	2077	java/io/IOException
    //   870	893	2077	java/io/IOException
    //   898	921	2077	java/io/IOException
    //   926	949	2077	java/io/IOException
    //   954	976	2077	java/io/IOException
    //   988	1011	2077	java/io/IOException
    //   1017	1058	2077	java/io/IOException
    //   1063	1084	2077	java/io/IOException
    //   1105	1119	2077	java/io/IOException
    //   1140	1154	2077	java/io/IOException
    //   1175	1189	2077	java/io/IOException
    //   1200	1243	2077	java/io/IOException
    //   1250	1281	2077	java/io/IOException
    //   1292	1312	2077	java/io/IOException
    //   1316	1361	2077	java/io/IOException
    //   1388	1396	2077	java/io/IOException
    //   1400	1414	2077	java/io/IOException
    //   1418	1432	2077	java/io/IOException
    //   1444	1458	2077	java/io/IOException
    //   1460	1474	2077	java/io/IOException
    //   1479	1493	2077	java/io/IOException
    //   1495	1509	2077	java/io/IOException
    //   1511	1525	2077	java/io/IOException
    //   1527	1541	2077	java/io/IOException
    //   1543	1580	2077	java/io/IOException
    //   1590	1608	2077	java/io/IOException
    //   1629	1656	2077	java/io/IOException
    //   1664	1670	2077	java/io/IOException
    //   1678	1701	2077	java/io/IOException
    //   1701	1709	2077	java/io/IOException
    //   1713	1823	2077	java/io/IOException
    //   1827	1841	2077	java/io/IOException
    //   1844	1875	2077	java/io/IOException
    //   1915	2017	2077	java/io/IOException
    //   2017	2031	2077	java/io/IOException
    //   2034	2070	2077	java/io/IOException
    //   2107	2115	2077	java/io/IOException
    //   2119	2255	2077	java/io/IOException
    //   2255	2269	2077	java/io/IOException
    //   2272	2281	2077	java/io/IOException
    //   2292	2323	2077	java/io/IOException
    //   2330	2338	2077	java/io/IOException
    //   2342	2478	2077	java/io/IOException
    //   2478	2492	2077	java/io/IOException
    //   2495	2504	2077	java/io/IOException
    //   2507	2538	2077	java/io/IOException
    //   2545	2553	2077	java/io/IOException
    //   2557	2693	2077	java/io/IOException
    //   2693	2707	2077	java/io/IOException
    //   2710	2719	2077	java/io/IOException
    //   2722	2753	2077	java/io/IOException
    //   2760	2768	2077	java/io/IOException
    //   2772	2908	2077	java/io/IOException
    //   2908	2922	2077	java/io/IOException
    //   2925	2934	2077	java/io/IOException
    //   2937	2968	2077	java/io/IOException
    //   2975	2983	2077	java/io/IOException
    //   2987	3123	2077	java/io/IOException
    //   3123	3137	2077	java/io/IOException
    //   3140	3149	2077	java/io/IOException
    //   3152	3183	2077	java/io/IOException
    //   3192	3201	2077	java/io/IOException
    //   3204	3219	2077	java/io/IOException
    //   3222	3237	2077	java/io/IOException
    //   3240	3255	2077	java/io/IOException
    //   3258	3273	2077	java/io/IOException
    //   3276	3291	2077	java/io/IOException
    //   3296	3305	2077	java/io/IOException
    //   3312	3321	2077	java/io/IOException
    //   3326	3340	2077	java/io/IOException
    //   3343	3351	2077	java/io/IOException
    //   3359	3368	2077	java/io/IOException
    //   3382	3409	2077	java/io/IOException
    //   3439	3453	2077	java/io/IOException
    //   3461	3488	2077	java/io/IOException
    //   3501	3521	2077	java/io/IOException
    //   3525	3704	2077	java/io/IOException
    //   3707	3717	2077	java/io/IOException
    //   3742	3756	2077	java/io/IOException
    //   3777	3804	2077	java/io/IOException
    //   3830	3850	2077	java/io/IOException
    //   3850	3895	2077	java/io/IOException
    //   3902	3910	2077	java/io/IOException
    //   3914	3928	2077	java/io/IOException
    //   3932	3946	2077	java/io/IOException
    //   3958	3972	2077	java/io/IOException
    //   3974	3988	2077	java/io/IOException
    //   3993	4010	2077	java/io/IOException
    //   4012	4038	2077	java/io/IOException
    //   4048	4066	2077	java/io/IOException
    //   4079	4088	2077	java/io/IOException
    //   4091	4100	2077	java/io/IOException
    //   4108	4117	2077	java/io/IOException
    //   4135	4162	2077	java/io/IOException
    //   4171	4180	2077	java/io/IOException
    //   4193	4207	2077	java/io/IOException
    //   4217	4244	2077	java/io/IOException
    //   4259	4279	2077	java/io/IOException
    //   4283	4328	2077	java/io/IOException
    //   4336	4344	2077	java/io/IOException
    //   4349	4363	2077	java/io/IOException
    //   4368	4382	2077	java/io/IOException
    //   4395	4409	2077	java/io/IOException
    //   4412	4426	2077	java/io/IOException
    //   4432	4449	2077	java/io/IOException
    //   4468	4482	2077	java/io/IOException
    //   4485	4499	2077	java/io/IOException
    //   4505	4519	2077	java/io/IOException
    //   4522	4536	2077	java/io/IOException
    //   4542	4556	2077	java/io/IOException
    //   4559	4573	2077	java/io/IOException
    //   4576	4590	2077	java/io/IOException
    //   4593	4607	2077	java/io/IOException
    //   4610	4647	2077	java/io/IOException
    //   4658	4676	2077	java/io/IOException
    //   4689	4721	2077	java/io/IOException
    //   4730	4757	2077	java/io/IOException
    //   4766	4775	2077	java/io/IOException
    //   4789	4816	2077	java/io/IOException
    //   4819	4844	2077	java/io/IOException
    //   4846	4853	2077	java/io/IOException
    //   4863	4872	2077	java/io/IOException
    //   4886	4917	2077	java/io/IOException
    //   4937	4951	2077	java/io/IOException
    //   4961	4988	2077	java/io/IOException
    //   5003	5023	2077	java/io/IOException
    //   5023	5068	2077	java/io/IOException
    //   5076	5084	2077	java/io/IOException
    //   5089	5103	2077	java/io/IOException
    //   5108	5122	2077	java/io/IOException
    //   5135	5149	2077	java/io/IOException
    //   5152	5166	2077	java/io/IOException
    //   5172	5189	2077	java/io/IOException
    //   5208	5222	2077	java/io/IOException
    //   5225	5239	2077	java/io/IOException
    //   5245	5259	2077	java/io/IOException
    //   5262	5276	2077	java/io/IOException
    //   5282	5296	2077	java/io/IOException
    //   5299	5313	2077	java/io/IOException
    //   5316	5330	2077	java/io/IOException
    //   5333	5347	2077	java/io/IOException
    //   5350	5387	2077	java/io/IOException
    //   5398	5416	2077	java/io/IOException
    //   5429	5436	2077	java/io/IOException
    //   5454	5479	2077	java/io/IOException
    //   5482	5489	2077	java/io/IOException
    //   5491	5498	2077	java/io/IOException
    //   5508	5515	2077	java/io/IOException
    //   5529	5541	2077	java/io/IOException
    //   5541	5567	2077	java/io/IOException
    //   5567	5572	2077	java/io/IOException
    //   5590	5604	2077	java/io/IOException
    //   5612	5639	2077	java/io/IOException
    //   5652	5672	2077	java/io/IOException
    //   5676	5741	2077	java/io/IOException
    //   5741	5752	2077	java/io/IOException
    //   5752	5761	2077	java/io/IOException
    //   5766	5777	2077	java/io/IOException
    //   5784	5793	2077	java/io/IOException
    //   5805	5836	2077	java/io/IOException
    //   5853	5884	2077	java/io/IOException
    //   5884	5899	2077	java/io/IOException
    //   5905	5931	2077	java/io/IOException
    //   5936	5945	2077	java/io/IOException
    //   5950	5955	2077	java/io/IOException
    //   5963	5989	2077	java/io/IOException
    //   5994	6009	2077	java/io/IOException
    //   6009	6017	2077	java/io/IOException
    //   6020	6029	2077	java/io/IOException
    //   131	172	2284	java/lang/InterruptedException
    //   207	237	2284	java/lang/InterruptedException
    //   240	247	2284	java/lang/InterruptedException
    //   256	276	2284	java/lang/InterruptedException
    //   291	319	2284	java/lang/InterruptedException
    //   322	336	2284	java/lang/InterruptedException
    //   336	368	2284	java/lang/InterruptedException
    //   378	409	2284	java/lang/InterruptedException
    //   417	431	2284	java/lang/InterruptedException
    //   439	453	2284	java/lang/InterruptedException
    //   461	520	2284	java/lang/InterruptedException
    //   523	541	2284	java/lang/InterruptedException
    //   544	572	2284	java/lang/InterruptedException
    //   572	594	2284	java/lang/InterruptedException
    //   594	630	2284	java/lang/InterruptedException
    //   630	661	2284	java/lang/InterruptedException
    //   673	685	2284	java/lang/InterruptedException
    //   685	705	2284	java/lang/InterruptedException
    //   709	760	2284	java/lang/InterruptedException
    //   773	785	2284	java/lang/InterruptedException
    //   785	805	2284	java/lang/InterruptedException
    //   805	839	2284	java/lang/InterruptedException
    //   842	865	2284	java/lang/InterruptedException
    //   870	893	2284	java/lang/InterruptedException
    //   898	921	2284	java/lang/InterruptedException
    //   926	949	2284	java/lang/InterruptedException
    //   954	976	2284	java/lang/InterruptedException
    //   988	1011	2284	java/lang/InterruptedException
    //   1017	1058	2284	java/lang/InterruptedException
    //   1063	1084	2284	java/lang/InterruptedException
    //   1105	1119	2284	java/lang/InterruptedException
    //   1140	1154	2284	java/lang/InterruptedException
    //   1175	1189	2284	java/lang/InterruptedException
    //   1200	1243	2284	java/lang/InterruptedException
    //   1250	1281	2284	java/lang/InterruptedException
    //   1292	1312	2284	java/lang/InterruptedException
    //   1316	1361	2284	java/lang/InterruptedException
    //   1388	1396	2284	java/lang/InterruptedException
    //   1400	1414	2284	java/lang/InterruptedException
    //   1418	1432	2284	java/lang/InterruptedException
    //   1444	1458	2284	java/lang/InterruptedException
    //   1460	1474	2284	java/lang/InterruptedException
    //   1479	1493	2284	java/lang/InterruptedException
    //   1495	1509	2284	java/lang/InterruptedException
    //   1511	1525	2284	java/lang/InterruptedException
    //   1527	1541	2284	java/lang/InterruptedException
    //   1543	1580	2284	java/lang/InterruptedException
    //   1590	1608	2284	java/lang/InterruptedException
    //   1629	1656	2284	java/lang/InterruptedException
    //   1664	1670	2284	java/lang/InterruptedException
    //   1678	1701	2284	java/lang/InterruptedException
    //   1701	1709	2284	java/lang/InterruptedException
    //   1713	1823	2284	java/lang/InterruptedException
    //   1827	1841	2284	java/lang/InterruptedException
    //   1844	1875	2284	java/lang/InterruptedException
    //   1915	2017	2284	java/lang/InterruptedException
    //   2017	2031	2284	java/lang/InterruptedException
    //   2034	2070	2284	java/lang/InterruptedException
    //   2107	2115	2284	java/lang/InterruptedException
    //   2119	2255	2284	java/lang/InterruptedException
    //   2255	2269	2284	java/lang/InterruptedException
    //   2272	2281	2284	java/lang/InterruptedException
    //   2292	2323	2284	java/lang/InterruptedException
    //   2330	2338	2284	java/lang/InterruptedException
    //   2342	2478	2284	java/lang/InterruptedException
    //   2478	2492	2284	java/lang/InterruptedException
    //   2495	2504	2284	java/lang/InterruptedException
    //   2507	2538	2284	java/lang/InterruptedException
    //   2545	2553	2284	java/lang/InterruptedException
    //   2557	2693	2284	java/lang/InterruptedException
    //   2693	2707	2284	java/lang/InterruptedException
    //   2710	2719	2284	java/lang/InterruptedException
    //   2722	2753	2284	java/lang/InterruptedException
    //   2760	2768	2284	java/lang/InterruptedException
    //   2772	2908	2284	java/lang/InterruptedException
    //   2908	2922	2284	java/lang/InterruptedException
    //   2925	2934	2284	java/lang/InterruptedException
    //   2937	2968	2284	java/lang/InterruptedException
    //   2975	2983	2284	java/lang/InterruptedException
    //   2987	3123	2284	java/lang/InterruptedException
    //   3123	3137	2284	java/lang/InterruptedException
    //   3140	3149	2284	java/lang/InterruptedException
    //   3152	3183	2284	java/lang/InterruptedException
    //   3192	3201	2284	java/lang/InterruptedException
    //   3204	3219	2284	java/lang/InterruptedException
    //   3222	3237	2284	java/lang/InterruptedException
    //   3240	3255	2284	java/lang/InterruptedException
    //   3258	3273	2284	java/lang/InterruptedException
    //   3276	3291	2284	java/lang/InterruptedException
    //   3296	3305	2284	java/lang/InterruptedException
    //   3312	3321	2284	java/lang/InterruptedException
    //   3326	3340	2284	java/lang/InterruptedException
    //   3343	3351	2284	java/lang/InterruptedException
    //   3359	3368	2284	java/lang/InterruptedException
    //   3382	3409	2284	java/lang/InterruptedException
    //   3439	3453	2284	java/lang/InterruptedException
    //   3461	3488	2284	java/lang/InterruptedException
    //   3501	3521	2284	java/lang/InterruptedException
    //   3525	3704	2284	java/lang/InterruptedException
    //   3707	3717	2284	java/lang/InterruptedException
    //   3742	3756	2284	java/lang/InterruptedException
    //   3777	3804	2284	java/lang/InterruptedException
    //   3830	3850	2284	java/lang/InterruptedException
    //   3850	3895	2284	java/lang/InterruptedException
    //   3902	3910	2284	java/lang/InterruptedException
    //   3914	3928	2284	java/lang/InterruptedException
    //   3932	3946	2284	java/lang/InterruptedException
    //   3958	3972	2284	java/lang/InterruptedException
    //   3974	3988	2284	java/lang/InterruptedException
    //   3993	4010	2284	java/lang/InterruptedException
    //   4012	4038	2284	java/lang/InterruptedException
    //   4048	4066	2284	java/lang/InterruptedException
    //   4079	4088	2284	java/lang/InterruptedException
    //   4091	4100	2284	java/lang/InterruptedException
    //   4108	4117	2284	java/lang/InterruptedException
    //   4135	4162	2284	java/lang/InterruptedException
    //   4171	4180	2284	java/lang/InterruptedException
    //   4193	4207	2284	java/lang/InterruptedException
    //   4217	4244	2284	java/lang/InterruptedException
    //   4259	4279	2284	java/lang/InterruptedException
    //   4283	4328	2284	java/lang/InterruptedException
    //   4336	4344	2284	java/lang/InterruptedException
    //   4349	4363	2284	java/lang/InterruptedException
    //   4368	4382	2284	java/lang/InterruptedException
    //   4395	4409	2284	java/lang/InterruptedException
    //   4412	4426	2284	java/lang/InterruptedException
    //   4432	4449	2284	java/lang/InterruptedException
    //   4468	4482	2284	java/lang/InterruptedException
    //   4485	4499	2284	java/lang/InterruptedException
    //   4505	4519	2284	java/lang/InterruptedException
    //   4522	4536	2284	java/lang/InterruptedException
    //   4542	4556	2284	java/lang/InterruptedException
    //   4559	4573	2284	java/lang/InterruptedException
    //   4576	4590	2284	java/lang/InterruptedException
    //   4593	4607	2284	java/lang/InterruptedException
    //   4610	4647	2284	java/lang/InterruptedException
    //   4658	4676	2284	java/lang/InterruptedException
    //   4689	4721	2284	java/lang/InterruptedException
    //   4730	4757	2284	java/lang/InterruptedException
    //   4766	4775	2284	java/lang/InterruptedException
    //   4789	4816	2284	java/lang/InterruptedException
    //   4819	4844	2284	java/lang/InterruptedException
    //   4846	4853	2284	java/lang/InterruptedException
    //   4863	4872	2284	java/lang/InterruptedException
    //   4886	4917	2284	java/lang/InterruptedException
    //   4937	4951	2284	java/lang/InterruptedException
    //   4961	4988	2284	java/lang/InterruptedException
    //   5003	5023	2284	java/lang/InterruptedException
    //   5023	5068	2284	java/lang/InterruptedException
    //   5076	5084	2284	java/lang/InterruptedException
    //   5089	5103	2284	java/lang/InterruptedException
    //   5108	5122	2284	java/lang/InterruptedException
    //   5135	5149	2284	java/lang/InterruptedException
    //   5152	5166	2284	java/lang/InterruptedException
    //   5172	5189	2284	java/lang/InterruptedException
    //   5208	5222	2284	java/lang/InterruptedException
    //   5225	5239	2284	java/lang/InterruptedException
    //   5245	5259	2284	java/lang/InterruptedException
    //   5262	5276	2284	java/lang/InterruptedException
    //   5282	5296	2284	java/lang/InterruptedException
    //   5299	5313	2284	java/lang/InterruptedException
    //   5316	5330	2284	java/lang/InterruptedException
    //   5333	5347	2284	java/lang/InterruptedException
    //   5350	5387	2284	java/lang/InterruptedException
    //   5398	5416	2284	java/lang/InterruptedException
    //   5429	5436	2284	java/lang/InterruptedException
    //   5454	5479	2284	java/lang/InterruptedException
    //   5482	5489	2284	java/lang/InterruptedException
    //   5491	5498	2284	java/lang/InterruptedException
    //   5508	5515	2284	java/lang/InterruptedException
    //   5529	5541	2284	java/lang/InterruptedException
    //   5541	5567	2284	java/lang/InterruptedException
    //   5567	5572	2284	java/lang/InterruptedException
    //   5590	5604	2284	java/lang/InterruptedException
    //   5612	5639	2284	java/lang/InterruptedException
    //   5652	5672	2284	java/lang/InterruptedException
    //   5676	5741	2284	java/lang/InterruptedException
    //   5741	5752	2284	java/lang/InterruptedException
    //   5752	5761	2284	java/lang/InterruptedException
    //   5766	5777	2284	java/lang/InterruptedException
    //   5784	5793	2284	java/lang/InterruptedException
    //   5805	5836	2284	java/lang/InterruptedException
    //   5853	5884	2284	java/lang/InterruptedException
    //   5884	5899	2284	java/lang/InterruptedException
    //   5905	5931	2284	java/lang/InterruptedException
    //   5936	5945	2284	java/lang/InterruptedException
    //   5950	5955	2284	java/lang/InterruptedException
    //   5963	5989	2284	java/lang/InterruptedException
    //   5994	6009	2284	java/lang/InterruptedException
    //   6009	6017	2284	java/lang/InterruptedException
    //   6020	6029	2284	java/lang/InterruptedException
    //   685	705	3190	org/json/JSONException
    //   785	805	3294	org/json/JSONException
    //   1063	1084	3324	org/json/JSONException
    //   1292	1312	3357	org/json/JSONException
    //   1388	1396	3380	java/lang/Exception
    //   1400	1414	3380	java/lang/Exception
    //   1418	1432	3380	java/lang/Exception
    //   1444	1458	3380	java/lang/Exception
    //   1460	1474	3380	java/lang/Exception
    //   1479	1493	3380	java/lang/Exception
    //   1495	1509	3380	java/lang/Exception
    //   1511	1525	3380	java/lang/Exception
    //   1527	1541	3380	java/lang/Exception
    //   1543	1580	3380	java/lang/Exception
    //   1590	1608	3380	java/lang/Exception
    //   3501	3521	4077	org/json/JSONException
    //   3830	3850	4106	org/json/JSONException
    //   3902	3910	4133	java/lang/Exception
    //   3914	3928	4133	java/lang/Exception
    //   3932	3946	4133	java/lang/Exception
    //   3958	3972	4133	java/lang/Exception
    //   3974	3988	4133	java/lang/Exception
    //   3993	4010	4133	java/lang/Exception
    //   4012	4038	4133	java/lang/Exception
    //   4048	4066	4133	java/lang/Exception
    //   4689	4721	4728	java/lang/Exception
    //   4259	4279	4764	org/json/JSONException
    //   4336	4344	4787	java/lang/Exception
    //   4349	4363	4787	java/lang/Exception
    //   4368	4382	4787	java/lang/Exception
    //   4395	4409	4787	java/lang/Exception
    //   4412	4426	4787	java/lang/Exception
    //   4432	4449	4787	java/lang/Exception
    //   4468	4482	4787	java/lang/Exception
    //   4485	4499	4787	java/lang/Exception
    //   4505	4519	4787	java/lang/Exception
    //   4522	4536	4787	java/lang/Exception
    //   4542	4556	4787	java/lang/Exception
    //   4559	4573	4787	java/lang/Exception
    //   4576	4590	4787	java/lang/Exception
    //   4593	4607	4787	java/lang/Exception
    //   4610	4647	4787	java/lang/Exception
    //   4658	4676	4787	java/lang/Exception
    //   5003	5023	5427	org/json/JSONException
    //   5076	5084	5452	java/lang/Exception
    //   5089	5103	5452	java/lang/Exception
    //   5108	5122	5452	java/lang/Exception
    //   5135	5149	5452	java/lang/Exception
    //   5152	5166	5452	java/lang/Exception
    //   5172	5189	5452	java/lang/Exception
    //   5208	5222	5452	java/lang/Exception
    //   5225	5239	5452	java/lang/Exception
    //   5245	5259	5452	java/lang/Exception
    //   5262	5276	5452	java/lang/Exception
    //   5282	5296	5452	java/lang/Exception
    //   5299	5313	5452	java/lang/Exception
    //   5316	5330	5452	java/lang/Exception
    //   5333	5347	5452	java/lang/Exception
    //   5350	5387	5452	java/lang/Exception
    //   5398	5416	5452	java/lang/Exception
    //   5652	5672	5934	org/json/JSONException
    //   5741	5752	5948	java/lang/Exception
    //   5752	5761	5948	java/lang/Exception
    //   1908	1913	6032	java/io/IOException
  }
  
  /* Error */
  public static boolean patchProcess(ArrayList<PatchesItem> paramArrayList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ifnull +102 -> 105
    //   6: aload_0
    //   7: invokevirtual 276	java/util/ArrayList:size	()I
    //   10: ifle +95 -> 105
    //   13: aload_0
    //   14: invokevirtual 283	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   17: astore 7
    //   19: aload 7
    //   21: invokeinterface 288 1 0
    //   26: ifeq +79 -> 105
    //   29: aload 7
    //   31: invokeinterface 292 1 0
    //   36: checkcast 634	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   39: astore 8
    //   41: aload 8
    //   43: iconst_0
    //   44: putfield 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:result	Z
    //   47: getstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   50: iconst_1
    //   51: if_icmpne -32 -> 19
    //   54: getstatic 115	com/chelpus/root/utils/createapkcustom:multidex	Z
    //   57: ifeq -38 -> 19
    //   60: aload 8
    //   62: getfield 680	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   65: ldc 98
    //   67: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq -51 -> 19
    //   73: aload 8
    //   75: new 162	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 682
    //   85: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_3
    //   89: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: putfield 680	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   98: iload_3
    //   99: iconst_1
    //   100: iadd
    //   101: istore_3
    //   102: goto -83 -> 19
    //   105: new 684	java/io/RandomAccessFile
    //   108: dup
    //   109: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   112: ldc_w 686
    //   115: invokespecial 689	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   118: invokevirtual 693	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   121: astore 8
    //   123: aload 8
    //   125: getstatic 699	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   128: lconst_0
    //   129: aload 8
    //   131: invokevirtual 703	java/nio/channels/FileChannel:size	()J
    //   134: l2i
    //   135: i2l
    //   136: invokevirtual 707	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   139: astore 7
    //   141: aload_0
    //   142: invokevirtual 711	java/util/ArrayList:toArray	()[Ljava/lang/Object;
    //   145: arraylength
    //   146: anewarray 634	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   149: astore 9
    //   151: aload_0
    //   152: aload_0
    //   153: invokevirtual 276	java/util/ArrayList:size	()I
    //   156: anewarray 634	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   159: invokevirtual 714	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   162: checkcast 716	[Lcom/android/vending/billing/InAppBillingService/LACK/PatchesItem;
    //   165: checkcast 716	[Lcom/android/vending/billing/InAppBillingService/LACK/PatchesItem;
    //   168: astore 9
    //   170: iconst_m1
    //   171: istore 4
    //   173: aload 7
    //   175: invokevirtual 721	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   178: ifeq +891 -> 1069
    //   181: aload 7
    //   183: iload 4
    //   185: iconst_1
    //   186: iadd
    //   187: invokevirtual 725	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   190: pop
    //   191: aload 7
    //   193: invokevirtual 727	java/nio/MappedByteBuffer:position	()I
    //   196: istore 5
    //   198: aload 7
    //   200: invokevirtual 730	java/nio/MappedByteBuffer:get	()B
    //   203: istore_2
    //   204: iconst_0
    //   205: istore_3
    //   206: aload 7
    //   208: astore_0
    //   209: iload 5
    //   211: istore 4
    //   213: aload_0
    //   214: astore 7
    //   216: iload_3
    //   217: aload 9
    //   219: arraylength
    //   220: if_icmpge -47 -> 173
    //   223: aload_0
    //   224: iload 5
    //   226: invokevirtual 725	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   229: pop
    //   230: iload_2
    //   231: aload 9
    //   233: iload_3
    //   234: aaload
    //   235: getfield 733	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origByte	[B
    //   238: iconst_0
    //   239: baload
    //   240: if_icmpeq +62 -> 302
    //   243: aload 9
    //   245: iload_3
    //   246: aaload
    //   247: getfield 737	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   250: iconst_0
    //   251: iaload
    //   252: iconst_1
    //   253: if_icmpeq +49 -> 302
    //   256: aload_0
    //   257: astore 7
    //   259: aload 9
    //   261: iload_3
    //   262: aaload
    //   263: getfield 737	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   266: iconst_0
    //   267: iaload
    //   268: iconst_1
    //   269: if_icmple +1301 -> 1570
    //   272: aload_0
    //   273: astore 7
    //   275: iload_2
    //   276: getstatic 78	com/chelpus/root/utils/createapkcustom:search	Ljava/util/ArrayList;
    //   279: aload 9
    //   281: iload_3
    //   282: aaload
    //   283: getfield 737	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   286: iconst_0
    //   287: iaload
    //   288: iconst_2
    //   289: isub
    //   290: invokevirtual 740	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   293: checkcast 742	java/lang/Byte
    //   296: invokevirtual 743	java/lang/Byte:byteValue	()B
    //   299: if_icmpne +1271 -> 1570
    //   302: aload 9
    //   304: iload_3
    //   305: aaload
    //   306: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   309: iconst_0
    //   310: iaload
    //   311: ifne +13 -> 324
    //   314: aload 9
    //   316: iload_3
    //   317: aaload
    //   318: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   321: iconst_0
    //   322: iload_2
    //   323: bastore
    //   324: aload 9
    //   326: iload_3
    //   327: aaload
    //   328: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   331: iconst_0
    //   332: iaload
    //   333: iconst_1
    //   334: if_icmple +50 -> 384
    //   337: aload 9
    //   339: iload_3
    //   340: aaload
    //   341: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   344: iconst_0
    //   345: iaload
    //   346: sipush 253
    //   349: if_icmpge +35 -> 384
    //   352: aload 9
    //   354: iload_3
    //   355: aaload
    //   356: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   359: iconst_0
    //   360: getstatic 78	com/chelpus/root/utils/createapkcustom:search	Ljava/util/ArrayList;
    //   363: aload 9
    //   365: iload_3
    //   366: aaload
    //   367: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   370: iconst_0
    //   371: iaload
    //   372: iconst_2
    //   373: isub
    //   374: invokevirtual 740	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   377: checkcast 742	java/lang/Byte
    //   380: invokevirtual 743	java/lang/Byte:byteValue	()B
    //   383: bastore
    //   384: aload 9
    //   386: iload_3
    //   387: aaload
    //   388: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   391: iconst_0
    //   392: iaload
    //   393: sipush 253
    //   396: if_icmpne +25 -> 421
    //   399: aload 9
    //   401: iload_3
    //   402: aaload
    //   403: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   406: iconst_0
    //   407: iload_2
    //   408: bipush 15
    //   410: iand
    //   411: iload_2
    //   412: bipush 15
    //   414: iand
    //   415: bipush 16
    //   417: imul
    //   418: iadd
    //   419: i2b
    //   420: bastore
    //   421: aload 9
    //   423: iload_3
    //   424: aaload
    //   425: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   428: iconst_0
    //   429: iaload
    //   430: sipush 254
    //   433: if_icmpne +20 -> 453
    //   436: aload 9
    //   438: iload_3
    //   439: aaload
    //   440: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   443: iconst_0
    //   444: iload_2
    //   445: bipush 15
    //   447: iand
    //   448: bipush 16
    //   450: iadd
    //   451: i2b
    //   452: bastore
    //   453: aload 9
    //   455: iload_3
    //   456: aaload
    //   457: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   460: iconst_0
    //   461: iaload
    //   462: sipush 255
    //   465: if_icmpne +17 -> 482
    //   468: aload 9
    //   470: iload_3
    //   471: aaload
    //   472: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   475: iconst_0
    //   476: iload_2
    //   477: bipush 15
    //   479: iand
    //   480: i2b
    //   481: bastore
    //   482: iconst_1
    //   483: istore 4
    //   485: aload_0
    //   486: iload 5
    //   488: iconst_1
    //   489: iadd
    //   490: invokevirtual 725	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   493: pop
    //   494: aload_0
    //   495: invokevirtual 730	java/nio/MappedByteBuffer:get	()B
    //   498: istore_1
    //   499: iload_1
    //   500: aload 9
    //   502: iload_3
    //   503: aaload
    //   504: getfield 733	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origByte	[B
    //   507: iload 4
    //   509: baload
    //   510: if_icmpeq +66 -> 576
    //   513: aload 9
    //   515: iload_3
    //   516: aaload
    //   517: getfield 737	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   520: iload 4
    //   522: iaload
    //   523: iconst_1
    //   524: if_icmple +31 -> 555
    //   527: iload_1
    //   528: getstatic 78	com/chelpus/root/utils/createapkcustom:search	Ljava/util/ArrayList;
    //   531: aload 9
    //   533: iload_3
    //   534: aaload
    //   535: getfield 737	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   538: iload 4
    //   540: iaload
    //   541: iconst_2
    //   542: isub
    //   543: invokevirtual 740	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   546: checkcast 742	java/lang/Byte
    //   549: invokevirtual 743	java/lang/Byte:byteValue	()B
    //   552: if_icmpeq +24 -> 576
    //   555: aload 9
    //   557: iload_3
    //   558: aaload
    //   559: getfield 737	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   562: iload 4
    //   564: iaload
    //   565: istore 6
    //   567: aload_0
    //   568: astore 7
    //   570: iload 6
    //   572: iconst_1
    //   573: if_icmpne +997 -> 1570
    //   576: aload 9
    //   578: iload_3
    //   579: aaload
    //   580: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   583: iload 4
    //   585: iaload
    //   586: ifne +14 -> 600
    //   589: aload 9
    //   591: iload_3
    //   592: aaload
    //   593: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   596: iload 4
    //   598: iload_1
    //   599: bastore
    //   600: aload 9
    //   602: iload_3
    //   603: aaload
    //   604: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   607: iload 4
    //   609: iaload
    //   610: iconst_1
    //   611: if_icmple +57 -> 668
    //   614: aload 9
    //   616: iload_3
    //   617: aaload
    //   618: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   621: iload 4
    //   623: iaload
    //   624: sipush 253
    //   627: if_icmpge +41 -> 668
    //   630: aload 9
    //   632: iload_3
    //   633: aaload
    //   634: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   637: iload 4
    //   639: iaload
    //   640: istore 6
    //   642: aload 9
    //   644: iload_3
    //   645: aaload
    //   646: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   649: iload 4
    //   651: getstatic 78	com/chelpus/root/utils/createapkcustom:search	Ljava/util/ArrayList;
    //   654: iload 6
    //   656: iconst_2
    //   657: isub
    //   658: invokevirtual 740	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   661: checkcast 742	java/lang/Byte
    //   664: invokevirtual 743	java/lang/Byte:byteValue	()B
    //   667: bastore
    //   668: aload 9
    //   670: iload_3
    //   671: aaload
    //   672: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   675: iload 4
    //   677: iaload
    //   678: sipush 253
    //   681: if_icmpne +26 -> 707
    //   684: aload 9
    //   686: iload_3
    //   687: aaload
    //   688: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   691: iload 4
    //   693: iload_2
    //   694: bipush 15
    //   696: iand
    //   697: iload_2
    //   698: bipush 15
    //   700: iand
    //   701: bipush 16
    //   703: imul
    //   704: iadd
    //   705: i2b
    //   706: bastore
    //   707: aload 9
    //   709: iload_3
    //   710: aaload
    //   711: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   714: iload 4
    //   716: iaload
    //   717: sipush 254
    //   720: if_icmpne +21 -> 741
    //   723: aload 9
    //   725: iload_3
    //   726: aaload
    //   727: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   730: iload 4
    //   732: iload_1
    //   733: bipush 15
    //   735: iand
    //   736: bipush 16
    //   738: iadd
    //   739: i2b
    //   740: bastore
    //   741: aload 9
    //   743: iload_3
    //   744: aaload
    //   745: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   748: iload 4
    //   750: iaload
    //   751: sipush 255
    //   754: if_icmpne +18 -> 772
    //   757: aload 9
    //   759: iload_3
    //   760: aaload
    //   761: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   764: iload 4
    //   766: iload_1
    //   767: bipush 15
    //   769: iand
    //   770: i2b
    //   771: bastore
    //   772: iload 4
    //   774: iconst_1
    //   775: iadd
    //   776: istore 4
    //   778: iload 4
    //   780: aload 9
    //   782: iload_3
    //   783: aaload
    //   784: getfield 733	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origByte	[B
    //   787: arraylength
    //   788: if_icmpne +435 -> 1223
    //   791: aload_0
    //   792: astore 7
    //   794: aload 9
    //   796: iload_3
    //   797: aaload
    //   798: getfield 749	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:insert	Z
    //   801: ifeq +102 -> 903
    //   804: aload_0
    //   805: invokevirtual 727	java/nio/MappedByteBuffer:position	()I
    //   808: istore 4
    //   810: aload 8
    //   812: invokevirtual 703	java/nio/channels/FileChannel:size	()J
    //   815: l2i
    //   816: iload 4
    //   818: isub
    //   819: istore 6
    //   821: iload 6
    //   823: newarray <illegal type>
    //   825: astore 7
    //   827: aload_0
    //   828: aload 7
    //   830: iconst_0
    //   831: iload 6
    //   833: invokevirtual 752	java/nio/MappedByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   836: pop
    //   837: aload 7
    //   839: invokestatic 758	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   842: astore_0
    //   843: aload 8
    //   845: aload 9
    //   847: iload_3
    //   848: aaload
    //   849: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   852: arraylength
    //   853: aload 9
    //   855: iload_3
    //   856: aaload
    //   857: getfield 733	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origByte	[B
    //   860: arraylength
    //   861: isub
    //   862: iload 4
    //   864: iadd
    //   865: i2l
    //   866: invokevirtual 761	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   869: pop
    //   870: aload 8
    //   872: aload_0
    //   873: invokevirtual 764	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   876: pop
    //   877: aload 8
    //   879: getstatic 699	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   882: lconst_0
    //   883: aload 8
    //   885: invokevirtual 703	java/nio/channels/FileChannel:size	()J
    //   888: l2i
    //   889: i2l
    //   890: invokevirtual 707	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   893: astore 7
    //   895: aload 7
    //   897: iload 4
    //   899: invokevirtual 725	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   902: pop
    //   903: aload 8
    //   905: iload 5
    //   907: i2l
    //   908: invokevirtual 761	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   911: pop
    //   912: aload 8
    //   914: aload 9
    //   916: iload_3
    //   917: aaload
    //   918: getfield 747	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   921: invokestatic 758	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   924: invokevirtual 764	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   927: pop
    //   928: aload 7
    //   930: invokevirtual 768	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   933: pop
    //   934: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   937: new 162	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   944: ldc_w 770
    //   947: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: iload_3
    //   951: iconst_1
    //   952: iadd
    //   953: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   956: ldc_w 772
    //   959: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: iload 5
    //   964: invokestatic 776	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   967: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: ldc_w 778
    //   973: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   982: aload 9
    //   984: iload_3
    //   985: aaload
    //   986: iconst_1
    //   987: putfield 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:result	Z
    //   990: iconst_1
    //   991: putstatic 80	com/chelpus/root/utils/createapkcustom:patchteil	Z
    //   994: goto +576 -> 1570
    //   997: astore 7
    //   999: aload 9
    //   1001: iload_3
    //   1002: aaload
    //   1003: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   1006: iconst_0
    //   1007: iaload
    //   1008: iconst_2
    //   1009: isub
    //   1010: istore 4
    //   1012: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1015: new 162	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1022: ldc_w 780
    //   1025: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: iload 4
    //   1030: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1033: ldc_w 782
    //   1036: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: iload 4
    //   1041: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1044: ldc_w 784
    //   1047: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1056: goto -672 -> 384
    //   1059: astore_0
    //   1060: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1063: ldc_w 786
    //   1066: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1069: aload 8
    //   1071: invokevirtual 787	java/nio/channels/FileChannel:close	()V
    //   1074: iconst_0
    //   1075: istore_3
    //   1076: iload_3
    //   1077: aload 9
    //   1079: arraylength
    //   1080: if_icmpge +158 -> 1238
    //   1083: aload 9
    //   1085: iload_3
    //   1086: aaload
    //   1087: getfield 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:result	Z
    //   1090: ifeq +141 -> 1231
    //   1093: aload 9
    //   1095: iload_3
    //   1096: aaload
    //   1097: getfield 680	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   1100: ldc 98
    //   1102: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1105: ifne +126 -> 1231
    //   1108: aload 9
    //   1110: arraylength
    //   1111: istore 5
    //   1113: iconst_0
    //   1114: istore 4
    //   1116: iload 4
    //   1118: iload 5
    //   1120: if_icmpge +111 -> 1231
    //   1123: aload 9
    //   1125: iload 4
    //   1127: aaload
    //   1128: astore_0
    //   1129: aload_0
    //   1130: getfield 680	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   1133: aload 9
    //   1135: iload_3
    //   1136: aaload
    //   1137: getfield 680	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   1140: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1143: ifeq +8 -> 1151
    //   1146: aload_0
    //   1147: iconst_1
    //   1148: putfield 790	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:groupResult	Z
    //   1151: iload 4
    //   1153: iconst_1
    //   1154: iadd
    //   1155: istore 4
    //   1157: goto -41 -> 1116
    //   1160: astore 7
    //   1162: aload 9
    //   1164: iload_3
    //   1165: aaload
    //   1166: getfield 746	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   1169: iload 4
    //   1171: iaload
    //   1172: iconst_2
    //   1173: isub
    //   1174: istore 6
    //   1176: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1179: new 162	java/lang/StringBuilder
    //   1182: dup
    //   1183: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1186: ldc_w 780
    //   1189: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: iload 6
    //   1194: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1197: ldc_w 782
    //   1200: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: iload 6
    //   1205: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1208: ldc_w 784
    //   1211: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1220: goto -552 -> 668
    //   1223: aload_0
    //   1224: invokevirtual 730	java/nio/MappedByteBuffer:get	()B
    //   1227: istore_1
    //   1228: goto -729 -> 499
    //   1231: iload_3
    //   1232: iconst_1
    //   1233: iadd
    //   1234: istore_3
    //   1235: goto -159 -> 1076
    //   1238: iconst_0
    //   1239: istore_3
    //   1240: iload_3
    //   1241: aload 9
    //   1243: arraylength
    //   1244: if_icmpge +270 -> 1514
    //   1247: aload 9
    //   1249: iload_3
    //   1250: aaload
    //   1251: getfield 679	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:result	Z
    //   1254: ifne +330 -> 1584
    //   1257: aload 9
    //   1259: iload_3
    //   1260: aaload
    //   1261: getfield 680	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   1264: ldc 98
    //   1266: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1269: ifne +198 -> 1467
    //   1272: aload 9
    //   1274: iload_3
    //   1275: aaload
    //   1276: getfield 790	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:groupResult	Z
    //   1279: ifne +305 -> 1584
    //   1282: getstatic 115	com/chelpus/root/utils/createapkcustom:multidex	Z
    //   1285: ifeq +60 -> 1345
    //   1288: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   1291: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   1294: getstatic 113	com/chelpus/root/utils/createapkcustom:classesFiles	Ljava/util/ArrayList;
    //   1297: invokevirtual 276	java/util/ArrayList:size	()I
    //   1300: iconst_1
    //   1301: isub
    //   1302: invokevirtual 740	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1305: invokevirtual 791	java/io/File:equals	(Ljava/lang/Object;)Z
    //   1308: ifeq +37 -> 1345
    //   1311: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1314: new 162	java/lang/StringBuilder
    //   1317: dup
    //   1318: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1321: ldc_w 770
    //   1324: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: iload_3
    //   1328: iconst_1
    //   1329: iadd
    //   1330: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1333: ldc_w 793
    //   1336: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1342: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1345: getstatic 119	com/chelpus/root/utils/createapkcustom:multilib_patch	Z
    //   1348: ifeq +70 -> 1418
    //   1351: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   1354: new 189	java/io/File
    //   1357: dup
    //   1358: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   1361: getstatic 107	com/chelpus/root/utils/createapkcustom:libs	Ljava/util/ArrayList;
    //   1364: invokevirtual 276	java/util/ArrayList:size	()I
    //   1367: iconst_1
    //   1368: isub
    //   1369: invokevirtual 740	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1372: checkcast 352	java/lang/String
    //   1375: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   1378: invokevirtual 791	java/io/File:equals	(Ljava/lang/Object;)Z
    //   1381: ifeq +37 -> 1418
    //   1384: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1387: new 162	java/lang/StringBuilder
    //   1390: dup
    //   1391: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1394: ldc_w 770
    //   1397: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: iload_3
    //   1401: iconst_1
    //   1402: iadd
    //   1403: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1406: ldc_w 793
    //   1409: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1415: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1418: getstatic 115	com/chelpus/root/utils/createapkcustom:multidex	Z
    //   1421: ifne +163 -> 1584
    //   1424: getstatic 119	com/chelpus/root/utils/createapkcustom:multilib_patch	Z
    //   1427: ifne +157 -> 1584
    //   1430: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1433: new 162	java/lang/StringBuilder
    //   1436: dup
    //   1437: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1440: ldc_w 770
    //   1443: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: iload_3
    //   1447: iconst_1
    //   1448: iadd
    //   1449: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1452: ldc_w 793
    //   1455: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1461: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1464: goto +120 -> 1584
    //   1467: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1470: new 162	java/lang/StringBuilder
    //   1473: dup
    //   1474: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1477: ldc_w 770
    //   1480: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: iload_3
    //   1484: iconst_1
    //   1485: iadd
    //   1486: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1489: ldc_w 793
    //   1492: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1501: goto +83 -> 1584
    //   1504: astore_0
    //   1505: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1508: ldc_w 795
    //   1511: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1514: getstatic 377	com/chelpus/root/utils/createapkcustom:tag	I
    //   1517: iconst_1
    //   1518: if_icmpne +9 -> 1527
    //   1521: getstatic 399	com/chelpus/root/utils/createapkcustom:localFile2	Ljava/io/File;
    //   1524: invokestatic 593	com/chelpus/root/utils/createapkcustom:fixadler	(Ljava/io/File;)V
    //   1527: iconst_1
    //   1528: ireturn
    //   1529: astore_0
    //   1530: getstatic 127	com/chelpus/root/utils/createapkcustom:print	Ljava/io/PrintStream;
    //   1533: new 162	java/lang/StringBuilder
    //   1536: dup
    //   1537: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1540: ldc_w 797
    //   1543: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: aload_0
    //   1547: invokevirtual 200	java/lang/Exception:toString	()Ljava/lang/String;
    //   1550: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1556: invokevirtual 205	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1559: goto -45 -> 1514
    //   1562: astore_0
    //   1563: goto -49 -> 1514
    //   1566: astore_0
    //   1567: goto -498 -> 1069
    //   1570: iload_3
    //   1571: iconst_1
    //   1572: iadd
    //   1573: istore_3
    //   1574: aload 7
    //   1576: astore_0
    //   1577: goto -1368 -> 209
    //   1580: astore_0
    //   1581: goto -512 -> 1069
    //   1584: iload_3
    //   1585: iconst_1
    //   1586: iadd
    //   1587: istore_3
    //   1588: goto -348 -> 1240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1591	0	paramArrayList	ArrayList<PatchesItem>
    //   498	730	1	i	int
    //   203	498	2	j	int
    //   1	1587	3	k	int
    //   171	999	4	m	int
    //   196	925	5	n	int
    //   565	639	6	i1	int
    //   17	912	7	localObject1	Object
    //   997	1	7	localException1	Exception
    //   1160	415	7	localException2	Exception
    //   39	1031	8	localObject2	Object
    //   149	1124	9	arrayOfPatchesItem	PatchesItem[]
    // Exception table:
    //   from	to	target	type
    //   324	384	997	java/lang/Exception
    //   173	204	1059	java/lang/IndexOutOfBoundsException
    //   216	256	1059	java/lang/IndexOutOfBoundsException
    //   259	272	1059	java/lang/IndexOutOfBoundsException
    //   275	302	1059	java/lang/IndexOutOfBoundsException
    //   302	324	1059	java/lang/IndexOutOfBoundsException
    //   324	384	1059	java/lang/IndexOutOfBoundsException
    //   384	421	1059	java/lang/IndexOutOfBoundsException
    //   421	453	1059	java/lang/IndexOutOfBoundsException
    //   453	482	1059	java/lang/IndexOutOfBoundsException
    //   485	499	1059	java/lang/IndexOutOfBoundsException
    //   499	555	1059	java/lang/IndexOutOfBoundsException
    //   555	567	1059	java/lang/IndexOutOfBoundsException
    //   576	600	1059	java/lang/IndexOutOfBoundsException
    //   600	668	1059	java/lang/IndexOutOfBoundsException
    //   668	707	1059	java/lang/IndexOutOfBoundsException
    //   707	741	1059	java/lang/IndexOutOfBoundsException
    //   741	772	1059	java/lang/IndexOutOfBoundsException
    //   778	791	1059	java/lang/IndexOutOfBoundsException
    //   794	903	1059	java/lang/IndexOutOfBoundsException
    //   903	994	1059	java/lang/IndexOutOfBoundsException
    //   999	1056	1059	java/lang/IndexOutOfBoundsException
    //   1162	1220	1059	java/lang/IndexOutOfBoundsException
    //   1223	1228	1059	java/lang/IndexOutOfBoundsException
    //   576	600	1160	java/lang/Exception
    //   600	668	1160	java/lang/Exception
    //   105	170	1504	java/io/FileNotFoundException
    //   173	204	1504	java/io/FileNotFoundException
    //   216	256	1504	java/io/FileNotFoundException
    //   259	272	1504	java/io/FileNotFoundException
    //   275	302	1504	java/io/FileNotFoundException
    //   302	324	1504	java/io/FileNotFoundException
    //   324	384	1504	java/io/FileNotFoundException
    //   384	421	1504	java/io/FileNotFoundException
    //   421	453	1504	java/io/FileNotFoundException
    //   453	482	1504	java/io/FileNotFoundException
    //   485	499	1504	java/io/FileNotFoundException
    //   499	555	1504	java/io/FileNotFoundException
    //   555	567	1504	java/io/FileNotFoundException
    //   576	600	1504	java/io/FileNotFoundException
    //   600	668	1504	java/io/FileNotFoundException
    //   668	707	1504	java/io/FileNotFoundException
    //   707	741	1504	java/io/FileNotFoundException
    //   741	772	1504	java/io/FileNotFoundException
    //   778	791	1504	java/io/FileNotFoundException
    //   794	903	1504	java/io/FileNotFoundException
    //   903	994	1504	java/io/FileNotFoundException
    //   999	1056	1504	java/io/FileNotFoundException
    //   1060	1069	1504	java/io/FileNotFoundException
    //   1069	1074	1504	java/io/FileNotFoundException
    //   1076	1113	1504	java/io/FileNotFoundException
    //   1129	1151	1504	java/io/FileNotFoundException
    //   1162	1220	1504	java/io/FileNotFoundException
    //   1223	1228	1504	java/io/FileNotFoundException
    //   1240	1345	1504	java/io/FileNotFoundException
    //   1345	1418	1504	java/io/FileNotFoundException
    //   1418	1464	1504	java/io/FileNotFoundException
    //   1467	1501	1504	java/io/FileNotFoundException
    //   105	170	1529	java/lang/Exception
    //   1060	1069	1529	java/lang/Exception
    //   1069	1074	1529	java/lang/Exception
    //   1076	1113	1529	java/lang/Exception
    //   1129	1151	1529	java/lang/Exception
    //   1240	1345	1529	java/lang/Exception
    //   1345	1418	1529	java/lang/Exception
    //   1418	1464	1529	java/lang/Exception
    //   1467	1501	1529	java/lang/Exception
    //   105	170	1562	java/nio/BufferUnderflowException
    //   1060	1069	1562	java/nio/BufferUnderflowException
    //   1069	1074	1562	java/nio/BufferUnderflowException
    //   1076	1113	1562	java/nio/BufferUnderflowException
    //   1129	1151	1562	java/nio/BufferUnderflowException
    //   1240	1345	1562	java/nio/BufferUnderflowException
    //   1345	1418	1562	java/nio/BufferUnderflowException
    //   1418	1464	1562	java/nio/BufferUnderflowException
    //   1467	1501	1562	java/nio/BufferUnderflowException
    //   173	204	1566	java/lang/Exception
    //   216	256	1566	java/lang/Exception
    //   259	272	1566	java/lang/Exception
    //   275	302	1566	java/lang/Exception
    //   302	324	1566	java/lang/Exception
    //   384	421	1566	java/lang/Exception
    //   421	453	1566	java/lang/Exception
    //   453	482	1566	java/lang/Exception
    //   485	499	1566	java/lang/Exception
    //   499	555	1566	java/lang/Exception
    //   555	567	1566	java/lang/Exception
    //   668	707	1566	java/lang/Exception
    //   707	741	1566	java/lang/Exception
    //   741	772	1566	java/lang/Exception
    //   778	791	1566	java/lang/Exception
    //   794	903	1566	java/lang/Exception
    //   903	994	1566	java/lang/Exception
    //   999	1056	1566	java/lang/Exception
    //   1162	1220	1566	java/lang/Exception
    //   1223	1228	1566	java/lang/Exception
    //   173	204	1580	java/nio/BufferUnderflowException
    //   216	256	1580	java/nio/BufferUnderflowException
    //   259	272	1580	java/nio/BufferUnderflowException
    //   275	302	1580	java/nio/BufferUnderflowException
    //   302	324	1580	java/nio/BufferUnderflowException
    //   324	384	1580	java/nio/BufferUnderflowException
    //   384	421	1580	java/nio/BufferUnderflowException
    //   421	453	1580	java/nio/BufferUnderflowException
    //   453	482	1580	java/nio/BufferUnderflowException
    //   485	499	1580	java/nio/BufferUnderflowException
    //   499	555	1580	java/nio/BufferUnderflowException
    //   555	567	1580	java/nio/BufferUnderflowException
    //   576	600	1580	java/nio/BufferUnderflowException
    //   600	668	1580	java/nio/BufferUnderflowException
    //   668	707	1580	java/nio/BufferUnderflowException
    //   707	741	1580	java/nio/BufferUnderflowException
    //   741	772	1580	java/nio/BufferUnderflowException
    //   778	791	1580	java/nio/BufferUnderflowException
    //   794	903	1580	java/nio/BufferUnderflowException
    //   903	994	1580	java/nio/BufferUnderflowException
    //   999	1056	1580	java/nio/BufferUnderflowException
    //   1162	1220	1580	java/nio/BufferUnderflowException
    //   1223	1228	1580	java/nio/BufferUnderflowException
  }
  
  public static boolean searchProcess(ArrayList<SearchItem> paramArrayList)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool7 = true;
    boolean bool1 = true;
    searchStr = "";
    Object localObject;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SearchItem)((Iterator)localObject).next()).result = false;
      }
    }
    boolean bool2 = bool5;
    boolean bool3 = bool6;
    boolean bool4 = bool7;
    int k;
    int m;
    try
    {
      localObject = new RandomAccessFile(localFile2, "rw").getChannel();
      bool2 = bool5;
      bool3 = bool6;
      bool4 = bool7;
      MappedByteBuffer localMappedByteBuffer = ((FileChannel)localObject).map(FileChannel.MapMode.READ_WRITE, 0L, (int)((FileChannel)localObject).size());
      bool2 = bool5;
      bool3 = bool6;
      bool4 = bool7;
      SearchItem[] arrayOfSearchItem = new SearchItem[paramArrayList.toArray().length];
      bool2 = bool5;
      bool3 = bool6;
      bool4 = bool7;
      paramArrayList = (SearchItem[])paramArrayList.toArray(new SearchItem[paramArrayList.size()]);
      long l = 0L;
      for (;;)
      {
        bool2 = bool5;
        bool3 = bool6;
        try
        {
          if (localMappedByteBuffer.hasRemaining())
          {
            bool2 = bool5;
            bool3 = bool6;
            n = localMappedByteBuffer.position();
            bool2 = bool5;
            bool3 = bool6;
            int j = localMappedByteBuffer.get();
            k = 0;
            bool2 = bool5;
            bool3 = bool6;
            if (k < paramArrayList.length)
            {
              bool2 = bool5;
              bool3 = bool6;
              localMappedByteBuffer.position(n);
              bool2 = bool5;
              bool3 = bool6;
              if (paramArrayList[k].result) {
                break label1237;
              }
              bool2 = bool5;
              bool3 = bool6;
              if (j != paramArrayList[k].origByte[0])
              {
                bool2 = bool5;
                bool3 = bool6;
                if (paramArrayList[k].origMask[0] == 0) {
                  break label1237;
                }
              }
              bool2 = bool5;
              bool3 = bool6;
              if (paramArrayList[k].origMask[0] != 0)
              {
                bool2 = bool5;
                bool3 = bool6;
                paramArrayList[k].repByte[0] = j;
              }
              m = 1;
              bool2 = bool5;
              bool3 = bool6;
              localMappedByteBuffer.position(n + 1);
              bool2 = bool5;
              bool3 = bool6;
              for (i = localMappedByteBuffer.get();; i = localMappedByteBuffer.get())
              {
                bool2 = bool5;
                bool3 = bool6;
                if (!paramArrayList[k].result)
                {
                  bool2 = bool5;
                  bool3 = bool6;
                  if (i == paramArrayList[k].origByte[m]) {}
                }
                else
                {
                  bool2 = bool5;
                  bool3 = bool6;
                  if (paramArrayList[k].origMask[m] == 0) {
                    break;
                  }
                }
                bool2 = bool5;
                bool3 = bool6;
                if (paramArrayList[k].origMask[m] > 0)
                {
                  bool2 = bool5;
                  bool3 = bool6;
                  paramArrayList[k].repByte[m] = i;
                }
                m += 1;
                bool2 = bool5;
                bool3 = bool6;
                if (m == paramArrayList[k].origByte.length)
                {
                  bool2 = bool5;
                  bool3 = bool6;
                  paramArrayList[k].result = true;
                  bool2 = bool5;
                  bool3 = bool6;
                  patchteil = true;
                  break;
                }
                bool2 = bool5;
                bool3 = bool6;
              }
            }
            bool2 = bool5;
            bool3 = bool6;
            localMappedByteBuffer.position(n + 1);
            l += 1L;
          }
        }
        catch (Exception localException2)
        {
          bool2 = bool5;
          bool3 = bool6;
          bool4 = bool7;
          print.println("Search byte error: " + localException2);
          bool2 = bool5;
          bool3 = bool6;
          bool4 = bool7;
          ((FileChannel)localObject).close();
          k = 0;
        }
      }
      label636:
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      if (k >= paramArrayList.length) {
        break label1255;
      }
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      if (paramArrayList[k].result) {
        break label1244;
      }
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      searchStr = searchStr + "Bytes by serach N" + (k + 1) + ":\nError LP: Bytes not found!" + "\n";
      bool5 = false;
    }
    catch (FileNotFoundException paramArrayList)
    {
      for (;;)
      {
        int n;
        int i;
        print.println("Error LP: Program files are not found!\nMove Program to internal storage.");
        bool5 = bool2;
        return bool5;
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        searchStr += "\n";
        k += 1;
      }
    }
    catch (BufferUnderflowException paramArrayList)
    {
      print.println("Exception e" + paramArrayList.toString());
      return bool3;
    }
    catch (Exception paramArrayList)
    {
      label740:
      paramArrayList.printStackTrace();
      print.println("Exception e" + paramArrayList.toString());
      return bool4;
    }
    bool2 = bool1;
    bool5 = bool1;
    bool3 = bool1;
    bool4 = bool1;
    if (k < paramArrayList.length)
    {
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      if (!paramArrayList[k].result) {
        break label1260;
      }
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      searchStr = searchStr + "\nBytes by search N" + (k + 1) + ":" + "\n";
    }
    for (;;)
    {
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      if (m < paramArrayList[k].origMask.length)
      {
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramArrayList[k].origMask[m] > 1)
        {
          bool2 = bool1;
          bool3 = bool1;
          bool4 = bool1;
          n = paramArrayList[k].origMask[m];
          n -= 2;
          bool2 = bool1;
          bool3 = bool1;
          try
          {
            search.set(n, Byte.valueOf(paramArrayList[k].repByte[m]));
            bool2 = bool1;
            bool3 = bool1;
            bool4 = bool1;
            if (!paramArrayList[k].result) {
              break label1266;
            }
            bool2 = bool1;
            bool3 = bool1;
            bool4 = bool1;
            i = ((Byte)search.get(n)).byteValue();
            bool2 = bool1;
            bool3 = bool1;
            bool4 = bool1;
            searchStr = searchStr + "R" + n + "=" + Utils.bytesToHex(new byte[] { i }).toUpperCase() + " ";
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              search.add(n, Byte.valueOf(paramArrayList[k].repByte[m]));
            }
          }
        }
      }
      else
      {
        label1237:
        k += 1;
        break;
        label1244:
        k += 1;
        bool1 = bool5;
        break label636;
        label1255:
        k = 0;
        break label740;
        label1260:
        m = 0;
        continue;
      }
      label1266:
      m += 1;
    }
  }
  
  public static ArrayList<String> searchlib(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    do
    {
      do
      {
        try
        {
          localObject = new File(appdir);
          crkapk = new File(sddir + "/Modified/" + packageName + ".apk");
          if (!crkapk.exists()) {
            Utils.copyFile((File)localObject, crkapk);
          }
          extractLibs(crkapk);
          if (paramString.trim().equals("*"))
          {
            multilib_patch = true;
            paramString = new ArrayList();
            new Utils("").findFileEndText(new File(sddir + "/tmp/lib/"), ".so", paramString);
            if (paramString.size() > 0)
            {
              paramString = paramString.iterator();
              while (paramString.hasNext())
              {
                localObject = (File)paramString.next();
                if (((File)localObject).length() > 0L) {
                  localArrayList.add(((File)localObject).getAbsolutePath());
                }
              }
            }
          }
          throw new FileNotFoundException();
        }
        catch (FileNotFoundException paramString)
        {
          print.println("Lib not found!" + paramString.toString());
          return localArrayList;
          switch (paramInt)
          {
          default: 
            return localArrayList;
          case 0: 
            localArrayList.clear();
            localObject = sddir + "/tmp/lib/armeabi/" + paramString;
            if (new File(sddir + "/tmp/lib/armeabi/" + paramString).exists())
            {
              localArrayList.add(localObject);
              return localArrayList;
            }
            break;
          }
        }
        catch (Exception paramString)
        {
          print.println("Lib select error: " + paramString.toString());
          return localArrayList;
        }
        localArrayList.clear();
        localObject = sddir + "/tmp/lib/armeabi-v7a/" + paramString;
        if (new File(sddir + "/tmp/lib/armeabi-v7a/" + paramString).exists())
        {
          localArrayList.add(localObject);
          return localArrayList;
        }
        throw new FileNotFoundException();
        localArrayList.clear();
        localObject = sddir + "/tmp/lib/mips/" + paramString;
        if (new File(sddir + "/tmp/lib/mips/" + paramString).exists())
        {
          localArrayList.add(localObject);
          return localArrayList;
        }
        throw new FileNotFoundException();
        localArrayList.clear();
        localObject = sddir + "/tmp/lib/x86/" + paramString;
        if (!new File(sddir + "/tmp/lib/x86/" + paramString).exists()) {
          break;
        }
        localArrayList.add(localObject);
      } while (!new File(sddir + "/tmp/lib/x86_64/" + paramString).exists());
      localArrayList.add(localObject);
      return localArrayList;
      throw new FileNotFoundException();
      Object localObject = sddir + "/tmp/lib/armeabi/" + paramString;
      if (new File((String)localObject).exists()) {
        localArrayList.add(localObject);
      }
      localObject = sddir + "/tmp/lib/armeabi-v7a/" + paramString;
      if (new File((String)localObject).exists()) {
        localArrayList.add(localObject);
      }
      localObject = sddir + "/tmp/lib/mips/" + paramString;
      if (new File((String)localObject).exists()) {
        localArrayList.add(localObject);
      }
      localObject = sddir + "/tmp/lib/x86/" + paramString;
      if (new File((String)localObject).exists()) {
        localArrayList.add(localObject);
      }
      paramString = sddir + "/tmp/lib/x86_64/" + paramString;
    } while (!new File(paramString).exists());
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static void unzip(File paramFile)
  {
    classesFiles.clear();
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
          print.println("Error LP: Error classes.dex decompress! " + paramFile);
          print.println("Exception e1" + localException.toString());
          return;
        }
        catch (Exception paramFile)
        {
          print.println("Error LP: Error classes.dex decompress! " + paramFile);
          print.println("Exception e1" + localException.toString());
        }
        classesFiles.add(new File(sddir + "/Modified/" + localZipEntry.getName()));
        localZipInputStream.closeEntry();
        localFileOutputStream.close();
        continue;
        localZipInputStream.close();
        localException.close();
        return;
      }
    }
  }
  
  public static void zipLib(ArrayList<String> paramArrayList)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        System.out.println(str);
        localArrayList.add(new AddFilesItem(str, sddir + "/tmp/"));
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      print.println("Error LP: Error libs compress! " + paramArrayList);
      do
      {
        return;
        Utils.addFilesToZip(crkapk.getAbsolutePath(), crkapk.getAbsolutePath() + "checlpis.zip", localArrayList);
        crkapk.delete();
        if (!crkapk.exists()) {
          new File(crkapk.getAbsolutePath() + "checlpis.zip").renameTo(crkapk);
        }
      } while (!crkapk.exists());
      System.out.println(crkapk.getAbsolutePath());
      System.out.println(crkapk.length());
      Utils.cmdParam(new String[] { "chmod", "777", "'" + crkapk.getAbsolutePath() + "'" });
      new Utils("").setAllWritable(Utils.getDirs(crkapk));
      return;
    }
    catch (OutOfMemoryError paramArrayList)
    {
      paramArrayList.printStackTrace();
      print.println("Error LP: Error libs compress! Out of memory for operation: " + paramArrayList);
    }
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
      if (paramString.isFile()) {
        paramString.delete();
      }
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
    }
    
    public String unzip(String paramString)
    {
      Object localObject1 = paramString;
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(this._zipFile);
        localObject1 = paramString;
        ZipInputStream localZipInputStream = new ZipInputStream(localFileInputStream);
        Object localObject2 = paramString;
        ZipEntry localZipEntry;
        for (;;)
        {
          localObject1 = localObject2;
          localZipEntry = localZipInputStream.getNextEntry();
          if (localZipEntry == null) {
            break label473;
          }
          localObject1 = localObject2;
          if (!localZipEntry.isDirectory()) {
            break;
          }
          localObject1 = localObject2;
          _dirChecker(localZipEntry.getName());
        }
        try
        {
          paramString = new ZipFile(this._zipFile);
          localObject2 = paramString.getFileHeaders();
          i = 0;
          if (i < ((List)localObject2).size())
          {
            localObject3 = (FileHeader)((List)localObject2).get(i);
            if (!((FileHeader)localObject3).getFileName().equals(localObject1)) {
              break label492;
            }
            createapkcustom.print.println(((FileHeader)localObject3).getFileName());
            paramString.extractFile(((FileHeader)localObject3).getFileName(), this._location);
            paramString = this._location + ((FileHeader)localObject3).getFileName();
            return paramString;
          }
        }
        catch (ZipException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            int i;
            Object localObject3;
            paramString.printStackTrace();
            continue;
            i += 1;
            localObject2 = localObject3;
          }
        }
      }
      catch (Exception paramString)
      {
        createapkcustom.print.println("Decompressunzip " + paramString);
      }
      for (;;)
      {
        localObject1 = localObject2;
        paramString = (String)localObject2;
        if (((String)localObject2).startsWith("/"))
        {
          localObject1 = localObject2;
          paramString = ((String)localObject2).replaceFirst("/", "");
        }
        localObject2 = paramString;
        localObject1 = paramString;
        if (!localZipEntry.getName().equals(paramString)) {
          break;
        }
        localObject1 = paramString;
        String[] arrayOfString = localZipEntry.getName().split("\\/+");
        localObject2 = "";
        i = 0;
        localObject1 = paramString;
        if (i < arrayOfString.length - 1)
        {
          localObject1 = paramString;
          localObject3 = localObject2;
          if (arrayOfString[i].equals("")) {
            break label515;
          }
          localObject1 = paramString;
          localObject3 = (String)localObject2 + "/" + arrayOfString[i];
          break label515;
        }
        localObject1 = paramString;
        _dirChecker((String)localObject2);
        localObject1 = paramString;
        localObject2 = new FileOutputStream(this._location + localZipEntry.getName());
        localObject1 = paramString;
        localObject3 = new byte['Ѐ'];
        for (;;)
        {
          localObject1 = paramString;
          i = localZipInputStream.read((byte[])localObject3);
          if (i == -1) {
            break;
          }
          localObject1 = paramString;
          ((FileOutputStream)localObject2).write((byte[])localObject3, 0, i);
        }
        localObject1 = paramString;
        localZipInputStream.closeEntry();
        localObject1 = paramString;
        ((FileOutputStream)localObject2).close();
        localObject1 = paramString;
        localZipInputStream.close();
        localObject1 = paramString;
        localFileInputStream.close();
        localObject1 = paramString;
        return this._location + localZipEntry.getName();
        label473:
        localObject1 = localObject2;
        localZipInputStream.close();
        localObject1 = localObject2;
        localFileInputStream.close();
        return "";
        label492:
        i += 1;
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
            localObject1 = new ZipFile(this._zipFile);
            localObject3 = ((ZipFile)localObject1).getFileHeaders();
            i = 0;
            for (;;)
            {
              if (i < ((List)localObject3).size())
              {
                localObject4 = (FileHeader)((List)localObject3).get(i);
                if (((FileHeader)localObject4).getFileName().endsWith(".so"))
                {
                  createapkcustom.print.println(((FileHeader)localObject4).getFileName());
                  ((ZipFile)localObject1).extractFile(((FileHeader)localObject4).getFileName(), this._location);
                }
                i += 1;
                continue;
                if (!localZipEntry.getName().endsWith(".so")) {
                  break;
                }
                arrayOfString = localZipEntry.getName().split("\\/+");
                localObject1 = "";
                i = 0;
                if (i < arrayOfString.length - 1)
                {
                  localObject3 = localObject1;
                  if (arrayOfString[i].equals("")) {
                    break label351;
                  }
                  localObject3 = (String)localObject1 + "/" + arrayOfString[i];
                  break label351;
                }
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
                break;
                localZipInputStream.close();
                ((FileInputStream)localObject4).close();
              }
            }
            return;
          }
          catch (ZipException localZipException)
          {
            localZipException.printStackTrace();
            return;
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
        createapkcustom.print.println("Decompressunzip " + localException1);
      }
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        int i;
        String[] arrayOfString;
        label351:
        i += 1;
        Object localObject2 = localObject3;
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/createapkcustom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */