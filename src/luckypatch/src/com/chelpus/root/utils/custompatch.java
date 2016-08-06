package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.PatchesItem;
import com.android.vending.billing.InAppBillingService.LACK.SearchItem;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class custompatch
{
  public static boolean ART = false;
  static final int BUFFER = 2048;
  public static final byte[] MAGIC = { 100, 101, 121, 10, 48, 51, 53, 0 };
  public static boolean OdexPatch = false;
  public static int adler = 0;
  public static boolean armv7 = false;
  public static ArrayList<File> arrayFile2 = new ArrayList();
  private static final int beginTag = 0;
  public static ArrayList<File> classesFiles;
  private static final int classesTag = 1;
  public static boolean convert = false;
  private static String dataBase;
  private static boolean dataBaseExist = false;
  public static String dir;
  public static String dir2;
  public static String dirapp;
  private static final int endTag = 4;
  private static final int fileInApkTag = 14;
  public static boolean fixunpack = false;
  public static boolean goodResult = false;
  private static String group;
  private static final int libTagALL = 2;
  private static final int libTagARMEABI = 6;
  private static final int libTagARMEABIV7A = 7;
  private static final int libTagMIPS = 8;
  private static final int libTagx86 = 9;
  public static File localFile2;
  public static String log;
  public static boolean manualpatch = false;
  public static boolean multidex = false;
  public static boolean multilib_patch = false;
  public static boolean odex = false;
  private static final int odexTag = 10;
  public static boolean odexpatch = false;
  private static final int odexpatchTag = 11;
  private static final int otherfilesTag = 3;
  private static final int packageTag = 5;
  private static ArrayList<PatchesItem> pat = null;
  public static boolean patchteil = false;
  public static String pkgName;
  public static String sddir;
  private static ArrayList<Byte> search;
  private static String searchStr;
  private static ArrayList<SearchItem> ser = null;
  private static final int set_copy_file_Tag = 15;
  private static final int set_permissions_Tag = 13;
  private static final int sqlTag = 12;
  public static boolean system;
  public static int tag;
  public static String uid;
  public static boolean unpack;
  private static boolean withFramework;
  
  static
  {
    search = null;
    patchteil = false;
    unpack = false;
    fixunpack = false;
    manualpatch = false;
    odex = false;
    dir = "/sdcard/";
    dir2 = "/sdcard/";
    dirapp = "/data/app/";
    sddir = "/data/app/";
    uid = "";
    system = false;
    odexpatch = false;
    OdexPatch = false;
    armv7 = false;
    ART = false;
    convert = false;
    dataBaseExist = false;
    dataBase = "";
    searchStr = "";
    group = "";
    withFramework = true;
    pkgName = "";
    log = "";
    classesFiles = new ArrayList();
    multidex = false;
  }
  
  public static void addToLog(String paramString)
  {
    log = log + paramString + "\n";
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
            File localFile3 = (File)((Iterator)localObject).next();
            localFile3 = new File(dir + "/" + localFile3.getName());
            if (localFile3.exists()) {
              localFile3.delete();
            }
          }
        }
        localFile1 = new File(dir + "/classes.dex");
      }
      catch (Exception localException)
      {
        addToLog("" + localException.toString());
        return;
      }
      if (localFile1.exists()) {
        localFile1.delete();
      }
      localFile1 = new File(dir + "/classes1.dex");
      if (localFile1.exists()) {
        localFile1.delete();
      }
      localFile1 = new File(dir + "/classes2.dex");
      if (localFile1.exists()) {
        localFile1.delete();
      }
      localFile1 = new File(dir + "/classes3.dex");
      if (localFile1.exists()) {
        localFile1.delete();
      }
      localFile1 = new File(dir + "/classes4.dex");
      if (localFile1.exists()) {
        localFile1.delete();
      }
      localFile1 = new File(dir + "/classes5.dex");
      if (localFile1.exists()) {
        localFile1.delete();
      }
      localFile1 = new File(dir + "/classes6.dex");
      if (localFile1.exists()) {
        localFile1.delete();
      }
      localFile1 = new File(dir + "/classes.dex.apk");
      if (localFile1.exists()) {
        localFile1.delete();
      }
      localFile1 = new File(dir + "/classes.dex.dex");
    } while (!localFile1.exists());
    localFile1.delete();
  }
  
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 174	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   7: ldc -2
    //   9: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: new 6	com/chelpus/root/utils/custompatch$1
    //   15: dup
    //   16: invokespecial 255	com/chelpus/root/utils/custompatch$1:<init>	()V
    //   19: invokevirtual 259	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: invokevirtual 264	java/lang/Class:getEnclosingClass	()Ljava/lang/Class;
    //   25: invokevirtual 265	java/lang/Class:getName	()Ljava/lang/String;
    //   28: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   37: aconst_null
    //   38: invokestatic 271	com/chelpus/Utils:startRootJava	(Ljava/lang/Object;)V
    //   41: aload_0
    //   42: iconst_0
    //   43: aaload
    //   44: putstatic 158	com/chelpus/root/utils/custompatch:pkgName	Ljava/lang/String;
    //   47: getstatic 158	com/chelpus/root/utils/custompatch:pkgName	Ljava/lang/String;
    //   50: invokestatic 274	com/chelpus/Utils:kill	(Ljava/lang/String;)V
    //   53: aload_0
    //   54: iconst_2
    //   55: aaload
    //   56: ldc_w 276
    //   59: invokestatic 280	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   62: pop
    //   63: aload_0
    //   64: bipush 9
    //   66: aaload
    //   67: ifnull +20 -> 87
    //   70: aload_0
    //   71: bipush 9
    //   73: aaload
    //   74: ldc_w 281
    //   77: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   80: ifeq +7 -> 87
    //   83: iconst_1
    //   84: putstatic 144	com/chelpus/root/utils/custompatch:ART	Z
    //   87: aload_0
    //   88: bipush 10
    //   90: aaload
    //   91: ifnull +10 -> 101
    //   94: aload_0
    //   95: bipush 10
    //   97: aaload
    //   98: putstatic 134	com/chelpus/root/utils/custompatch:uid	Ljava/lang/String;
    //   101: aload_0
    //   102: bipush 11
    //   104: aaload
    //   105: ifnull +16 -> 121
    //   108: aload_0
    //   109: bipush 11
    //   111: aaload
    //   112: ldc_w 289
    //   115: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   118: putstatic 156	com/chelpus/root/utils/custompatch:withFramework	Z
    //   121: new 190	java/io/File
    //   124: dup
    //   125: aload_0
    //   126: iconst_4
    //   127: aaload
    //   128: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: invokevirtual 293	java/io/File:listFiles	()[Ljava/io/File;
    //   134: astore 19
    //   136: aload 19
    //   138: arraylength
    //   139: istore_2
    //   140: iconst_0
    //   141: istore_1
    //   142: iload_1
    //   143: iload_2
    //   144: if_icmpge +122 -> 266
    //   147: aload 19
    //   149: iload_1
    //   150: aaload
    //   151: astore 20
    //   153: aload 20
    //   155: invokevirtual 296	java/io/File:isFile	()Z
    //   158: ifeq +51 -> 209
    //   161: aload 20
    //   163: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   166: ldc_w 298
    //   169: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifne +37 -> 209
    //   175: aload 20
    //   177: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   180: ldc_w 304
    //   183: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifne +23 -> 209
    //   189: aload 20
    //   191: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   194: ldc_w 306
    //   197: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifne +9 -> 209
    //   203: aload 20
    //   205: invokevirtual 201	java/io/File:delete	()Z
    //   208: pop
    //   209: iload_1
    //   210: iconst_1
    //   211: iadd
    //   212: istore_1
    //   213: goto -71 -> 142
    //   216: astore 19
    //   218: aload 19
    //   220: invokevirtual 309	java/lang/Exception:printStackTrace	()V
    //   223: goto -160 -> 63
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 309	java/lang/Exception:printStackTrace	()V
    //   231: getstatic 160	com/chelpus/root/utils/custompatch:log	Ljava/lang/String;
    //   234: invokestatic 313	com/chelpus/Utils:sendFromRootCP	(Ljava/lang/String;)Z
    //   237: pop
    //   238: iconst_0
    //   239: invokestatic 319	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   242: putstatic 325	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   245: invokestatic 328	com/chelpus/Utils:exitFromRootJava	()V
    //   248: return
    //   249: astore 19
    //   251: aload 19
    //   253: invokevirtual 309	java/lang/Exception:printStackTrace	()V
    //   256: goto -135 -> 121
    //   259: astore 19
    //   261: aload 19
    //   263: invokevirtual 309	java/lang/Exception:printStackTrace	()V
    //   266: aload_0
    //   267: iconst_3
    //   268: aaload
    //   269: putstatic 130	com/chelpus/root/utils/custompatch:sddir	Ljava/lang/String;
    //   272: aload_0
    //   273: iconst_4
    //   274: aaload
    //   275: putstatic 122	com/chelpus/root/utils/custompatch:dir	Ljava/lang/String;
    //   278: aload_0
    //   279: iconst_4
    //   280: aaload
    //   281: putstatic 124	com/chelpus/root/utils/custompatch:dir2	Ljava/lang/String;
    //   284: aload_0
    //   285: iconst_2
    //   286: aaload
    //   287: putstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   290: invokestatic 330	com/chelpus/root/utils/custompatch:clearTemp	()V
    //   293: ldc -124
    //   295: astore 20
    //   297: ldc -124
    //   299: astore 28
    //   301: ldc -124
    //   303: astore 34
    //   305: iconst_0
    //   306: istore_2
    //   307: iconst_0
    //   308: istore 13
    //   310: iconst_0
    //   311: istore_1
    //   312: aload_0
    //   313: bipush 6
    //   315: aaload
    //   316: ldc_w 332
    //   319: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   322: ifeq +7 -> 329
    //   325: iconst_0
    //   326: putstatic 136	com/chelpus/root/utils/custompatch:system	Z
    //   329: aload_0
    //   330: bipush 6
    //   332: aaload
    //   333: ldc_w 333
    //   336: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   339: ifeq +7 -> 346
    //   342: iconst_1
    //   343: putstatic 136	com/chelpus/root/utils/custompatch:system	Z
    //   346: getstatic 136	com/chelpus/root/utils/custompatch:system	Z
    //   349: ifeq +70 -> 419
    //   352: new 190	java/io/File
    //   355: dup
    //   356: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   359: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   362: astore 19
    //   364: new 190	java/io/File
    //   367: dup
    //   368: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   371: iconst_1
    //   372: invokestatic 337	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   375: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   378: astore 21
    //   380: aload 19
    //   382: invokevirtual 198	java/io/File:exists	()Z
    //   385: ifeq +34 -> 419
    //   388: aload 21
    //   390: invokevirtual 198	java/io/File:exists	()Z
    //   393: ifeq +26 -> 419
    //   396: aload 19
    //   398: invokestatic 341	com/chelpus/Utils:classes_test	(Ljava/io/File;)Z
    //   401: ifne +18 -> 419
    //   404: iconst_1
    //   405: putstatic 138	com/chelpus/root/utils/custompatch:odexpatch	Z
    //   408: aload 21
    //   410: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   413: ldc_w 345
    //   416: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   419: iconst_0
    //   420: putstatic 140	com/chelpus/root/utils/custompatch:OdexPatch	Z
    //   423: new 347	java/io/FileInputStream
    //   426: dup
    //   427: aload_0
    //   428: iconst_1
    //   429: aaload
    //   430: invokespecial 348	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   433: astore 19
    //   435: new 350	java/io/BufferedReader
    //   438: dup
    //   439: new 352	java/io/InputStreamReader
    //   442: dup
    //   443: aload 19
    //   445: ldc_w 354
    //   448: invokespecial 357	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   451: invokespecial 360	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   454: astore 21
    //   456: aload 21
    //   458: invokevirtual 363	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   461: astore 22
    //   463: aload 22
    //   465: ifnull +3191 -> 3656
    //   468: aload 22
    //   470: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   473: ldc_w 368
    //   476: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   479: ifeq +7 -> 486
    //   482: iconst_1
    //   483: putstatic 140	com/chelpus/root/utils/custompatch:OdexPatch	Z
    //   486: aload 22
    //   488: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   491: ldc_w 370
    //   494: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   497: ifeq -41 -> 456
    //   500: iconst_1
    //   501: putstatic 142	com/chelpus/root/utils/custompatch:armv7	Z
    //   504: goto -48 -> 456
    //   507: astore 19
    //   509: aload_0
    //   510: iconst_2
    //   511: aaload
    //   512: invokestatic 373	com/chelpus/root/utils/custompatch:searchDalvik	(Ljava/lang/String;)V
    //   515: new 347	java/io/FileInputStream
    //   518: dup
    //   519: aload_0
    //   520: iconst_1
    //   521: aaload
    //   522: invokespecial 348	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   525: astore 35
    //   527: new 352	java/io/InputStreamReader
    //   530: dup
    //   531: aload 35
    //   533: ldc_w 354
    //   536: invokespecial 357	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   539: astore 36
    //   541: new 350	java/io/BufferedReader
    //   544: dup
    //   545: aload 36
    //   547: invokespecial 360	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   550: astore 37
    //   552: sipush 2000
    //   555: anewarray 283	java/lang/String
    //   558: astore 38
    //   560: aconst_null
    //   561: astore 25
    //   563: aconst_null
    //   564: astore 26
    //   566: ldc -124
    //   568: astore 19
    //   570: ldc -124
    //   572: astore 33
    //   574: ldc -124
    //   576: astore 27
    //   578: iconst_1
    //   579: istore 15
    //   581: iconst_1
    //   582: istore 16
    //   584: iconst_0
    //   585: istore 8
    //   587: iconst_0
    //   588: istore 5
    //   590: iconst_0
    //   591: istore_3
    //   592: iconst_0
    //   593: istore 7
    //   595: iconst_0
    //   596: istore 6
    //   598: iconst_0
    //   599: istore 9
    //   601: ldc -124
    //   603: astore 21
    //   605: ldc -124
    //   607: astore 23
    //   609: ldc -124
    //   611: astore 24
    //   613: new 97	java/util/ArrayList
    //   616: dup
    //   617: invokespecial 100	java/util/ArrayList:<init>	()V
    //   620: putstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   623: new 97	java/util/ArrayList
    //   626: dup
    //   627: invokespecial 100	java/util/ArrayList:<init>	()V
    //   630: putstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   633: new 97	java/util/ArrayList
    //   636: dup
    //   637: invokespecial 100	java/util/ArrayList:<init>	()V
    //   640: putstatic 108	com/chelpus/root/utils/custompatch:search	Ljava/util/ArrayList;
    //   643: iconst_0
    //   644: istore 12
    //   646: aload 37
    //   648: invokevirtual 363	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   651: astore 22
    //   653: aload 22
    //   655: ifnull +8914 -> 9569
    //   658: aload 22
    //   660: astore 29
    //   662: aload 22
    //   664: ldc -124
    //   666: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   669: ifne +13 -> 682
    //   672: aload 22
    //   674: getstatic 158	com/chelpus/root/utils/custompatch:pkgName	Ljava/lang/String;
    //   677: invokestatic 377	com/chelpus/Utils:apply_TAGS	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   680: astore 29
    //   682: aload 38
    //   684: iload 12
    //   686: aload 29
    //   688: aastore
    //   689: aload 38
    //   691: iload 12
    //   693: aaload
    //   694: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   697: ldc_w 379
    //   700: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   703: ifeq +268 -> 971
    //   706: iconst_5
    //   707: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   710: iconst_1
    //   711: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   714: new 190	java/io/File
    //   717: dup
    //   718: aload_0
    //   719: iconst_2
    //   720: aaload
    //   721: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   724: astore 30
    //   726: aload 30
    //   728: astore 22
    //   730: aload 30
    //   732: invokevirtual 198	java/io/File:exists	()Z
    //   735: ifne +55 -> 790
    //   738: new 190	java/io/File
    //   741: dup
    //   742: aload_0
    //   743: iconst_2
    //   744: aaload
    //   745: ldc_w 383
    //   748: ldc_w 385
    //   751: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   754: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   757: astore 30
    //   759: aload 30
    //   761: astore 22
    //   763: aload 30
    //   765: invokevirtual 198	java/io/File:exists	()Z
    //   768: ifeq +22 -> 790
    //   771: aload_0
    //   772: iconst_2
    //   773: aload_0
    //   774: iconst_2
    //   775: aaload
    //   776: ldc_w 383
    //   779: ldc_w 385
    //   782: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   785: aastore
    //   786: aload 30
    //   788: astore 22
    //   790: aload 22
    //   792: astore 30
    //   794: aload 22
    //   796: invokevirtual 198	java/io/File:exists	()Z
    //   799: ifne +53 -> 852
    //   802: new 190	java/io/File
    //   805: dup
    //   806: aload_0
    //   807: iconst_2
    //   808: aaload
    //   809: ldc_w 383
    //   812: ldc -36
    //   814: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   817: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   820: astore 22
    //   822: aload 22
    //   824: astore 30
    //   826: aload 22
    //   828: invokevirtual 198	java/io/File:exists	()Z
    //   831: ifeq +21 -> 852
    //   834: aload_0
    //   835: iconst_2
    //   836: aload_0
    //   837: iconst_2
    //   838: aaload
    //   839: ldc_w 383
    //   842: ldc -124
    //   844: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   847: aastore
    //   848: aload 22
    //   850: astore 30
    //   852: aload 30
    //   854: invokestatic 393	com/chelpus/root/utils/custompatch:unzip	(Ljava/io/File;)V
    //   857: getstatic 138	com/chelpus/root/utils/custompatch:odexpatch	Z
    //   860: ifne +111 -> 971
    //   863: getstatic 140	com/chelpus/root/utils/custompatch:OdexPatch	Z
    //   866: ifne +105 -> 971
    //   869: aload_0
    //   870: iconst_2
    //   871: aaload
    //   872: iconst_1
    //   873: invokestatic 337	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   876: astore 22
    //   878: new 190	java/io/File
    //   881: dup
    //   882: aload 22
    //   884: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   887: astore 30
    //   889: aload 30
    //   891: invokevirtual 198	java/io/File:exists	()Z
    //   894: ifeq +9 -> 903
    //   897: aload 30
    //   899: invokevirtual 201	java/io/File:delete	()Z
    //   902: pop
    //   903: new 190	java/io/File
    //   906: dup
    //   907: aload 22
    //   909: ldc_w 395
    //   912: ldc_w 397
    //   915: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   918: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   921: astore 30
    //   923: aload 30
    //   925: invokevirtual 198	java/io/File:exists	()Z
    //   928: ifeq +9 -> 937
    //   931: aload 30
    //   933: invokevirtual 201	java/io/File:delete	()Z
    //   936: pop
    //   937: new 190	java/io/File
    //   940: dup
    //   941: aload 22
    //   943: ldc_w 397
    //   946: ldc_w 395
    //   949: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   952: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   955: astore 22
    //   957: aload 22
    //   959: invokevirtual 198	java/io/File:exists	()Z
    //   962: ifeq +9 -> 971
    //   965: aload 22
    //   967: invokevirtual 201	java/io/File:delete	()Z
    //   970: pop
    //   971: iload 5
    //   973: istore 11
    //   975: iload 5
    //   977: ifeq +80 -> 1057
    //   980: aload 38
    //   982: iload 12
    //   984: aaload
    //   985: ldc_w 399
    //   988: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   991: ifne +35 -> 1026
    //   994: aload 38
    //   996: iload 12
    //   998: aaload
    //   999: ldc_w 401
    //   1002: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1005: ifne +21 -> 1026
    //   1008: iload 5
    //   1010: istore 11
    //   1012: aload 38
    //   1014: iload 12
    //   1016: aaload
    //   1017: ldc_w 403
    //   1020: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1023: ifeq +34 -> 1057
    //   1026: new 174	java/lang/StringBuilder
    //   1029: dup
    //   1030: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1033: ldc -124
    //   1035: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload 34
    //   1040: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: ldc -75
    //   1045: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   1054: iconst_0
    //   1055: istore 11
    //   1057: aload 34
    //   1059: astore 30
    //   1061: iload 11
    //   1063: ifeq +33 -> 1096
    //   1066: new 174	java/lang/StringBuilder
    //   1069: dup
    //   1070: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1073: aload 34
    //   1075: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: ldc -75
    //   1080: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: aload 38
    //   1085: iload 12
    //   1087: aaload
    //   1088: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1094: astore 30
    //   1096: iload 9
    //   1098: istore 10
    //   1100: iload_1
    //   1101: istore 14
    //   1103: aload 20
    //   1105: astore 31
    //   1107: iload 6
    //   1109: istore 4
    //   1111: iload 15
    //   1113: istore 18
    //   1115: iload 16
    //   1117: istore 17
    //   1119: aload 38
    //   1121: iload 12
    //   1123: aaload
    //   1124: ldc_w 399
    //   1127: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1130: ifeq +142 -> 1272
    //   1133: iload 9
    //   1135: istore 10
    //   1137: iload_1
    //   1138: istore 14
    //   1140: aload 20
    //   1142: astore 31
    //   1144: iload 6
    //   1146: istore 4
    //   1148: iload 15
    //   1150: istore 18
    //   1152: iload 16
    //   1154: istore 17
    //   1156: aload 38
    //   1158: iload 12
    //   1160: aaload
    //   1161: ldc_w 401
    //   1164: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1167: ifeq +105 -> 1272
    //   1170: iload 9
    //   1172: istore 10
    //   1174: iload_1
    //   1175: istore 14
    //   1177: aload 20
    //   1179: astore 31
    //   1181: iload 6
    //   1183: istore 4
    //   1185: iload 15
    //   1187: istore 18
    //   1189: iload 16
    //   1191: istore 17
    //   1193: getstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   1196: tableswitch	default:+8571->9767, 1:+2473->3669, 2:+3344->4540, 3:+4524->5720, 4:+76->1272, 5:+76->1272, 6:+3580->4776, 7:+3816->5012, 8:+4052->5248, 9:+4288->5484, 10:+3144->4340, 11:+4603->5799, 12:+4792->5988, 13:+4845->6041, 14:+5387->6583, 15:+4998->6194
    //   1272: iload 11
    //   1274: istore 5
    //   1276: aload 38
    //   1278: iload 12
    //   1280: aaload
    //   1281: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1284: ldc_w 405
    //   1287: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1290: ifeq +10 -> 1300
    //   1293: iconst_0
    //   1294: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   1297: iconst_1
    //   1298: istore 5
    //   1300: aload 38
    //   1302: iload 12
    //   1304: aaload
    //   1305: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1308: ldc_w 407
    //   1311: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1314: ifeq +50 -> 1364
    //   1317: iconst_1
    //   1318: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   1321: getstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   1324: ifeq +40 -> 1364
    //   1327: new 190	java/io/File
    //   1330: dup
    //   1331: new 174	java/lang/StringBuilder
    //   1334: dup
    //   1335: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1338: getstatic 122	com/chelpus/root/utils/custompatch:dir	Ljava/lang/String;
    //   1341: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: ldc -36
    //   1346: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: ldc_w 409
    //   1352: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1358: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   1361: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   1364: aload 38
    //   1366: iload 12
    //   1368: aaload
    //   1369: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1372: ldc_w 411
    //   1375: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1378: ifeq +8 -> 1386
    //   1381: bipush 10
    //   1383: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   1386: aload 38
    //   1388: iload 12
    //   1390: aaload
    //   1391: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1394: ldc_w 413
    //   1397: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1400: ifeq +8 -> 1408
    //   1403: bipush 12
    //   1405: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   1408: aload 21
    //   1410: astore 20
    //   1412: getstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   1415: bipush 12
    //   1417: if_icmpne +526 -> 1943
    //   1420: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   1423: invokevirtual 416	java/util/ArrayList:clear	()V
    //   1426: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   1429: invokevirtual 416	java/util/ArrayList:clear	()V
    //   1432: aload 38
    //   1434: iload 12
    //   1436: aaload
    //   1437: ldc_w 418
    //   1440: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1443: istore 15
    //   1445: aload 21
    //   1447: astore 22
    //   1449: iload 15
    //   1451: ifeq +352 -> 1803
    //   1454: new 420	org/json/JSONObject
    //   1457: dup
    //   1458: aload 38
    //   1460: iload 12
    //   1462: aaload
    //   1463: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1466: ldc_w 418
    //   1469: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1472: astore 22
    //   1474: aload 22
    //   1476: astore 21
    //   1478: new 190	java/io/File
    //   1481: dup
    //   1482: aload 22
    //   1484: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   1487: astore 20
    //   1489: aload 22
    //   1491: astore 21
    //   1493: iconst_3
    //   1494: anewarray 283	java/lang/String
    //   1497: dup
    //   1498: iconst_0
    //   1499: ldc_w 427
    //   1502: aastore
    //   1503: dup
    //   1504: iconst_1
    //   1505: ldc_w 429
    //   1508: aastore
    //   1509: dup
    //   1510: iconst_2
    //   1511: aload 22
    //   1513: aastore
    //   1514: invokestatic 432	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1517: aload 22
    //   1519: astore 21
    //   1521: getstatic 156	com/chelpus/root/utils/custompatch:withFramework	Z
    //   1524: ifne +48 -> 1572
    //   1527: aload 22
    //   1529: astore 21
    //   1531: aload 20
    //   1533: new 190	java/io/File
    //   1536: dup
    //   1537: new 174	java/lang/StringBuilder
    //   1540: dup
    //   1541: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1544: getstatic 122	com/chelpus/root/utils/custompatch:dir	Ljava/lang/String;
    //   1547: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: ldc -36
    //   1552: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: aload 20
    //   1557: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   1560: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1566: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   1569: invokestatic 436	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   1572: aload 22
    //   1574: astore 21
    //   1576: aload 20
    //   1578: invokevirtual 198	java/io/File:exists	()Z
    //   1581: ifne +5060 -> 6641
    //   1584: aload 22
    //   1586: astore 21
    //   1588: aconst_null
    //   1589: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   1592: aload 22
    //   1594: astore 21
    //   1596: aload_0
    //   1597: iconst_0
    //   1598: aaload
    //   1599: aload 20
    //   1601: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   1604: invokestatic 440	com/chelpus/root/utils/custompatch:searchfile	(Ljava/lang/String;Ljava/lang/String;)V
    //   1607: aload 22
    //   1609: astore 21
    //   1611: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   1614: ifnull +5019 -> 6633
    //   1617: aload 22
    //   1619: astore 21
    //   1621: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   1624: invokevirtual 198	java/io/File:exists	()Z
    //   1627: ifeq +5006 -> 6633
    //   1630: aload 22
    //   1632: astore 21
    //   1634: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   1637: astore 20
    //   1639: aload 22
    //   1641: astore 21
    //   1643: iconst_3
    //   1644: anewarray 283	java/lang/String
    //   1647: dup
    //   1648: iconst_0
    //   1649: ldc_w 427
    //   1652: aastore
    //   1653: dup
    //   1654: iconst_1
    //   1655: ldc_w 429
    //   1658: aastore
    //   1659: dup
    //   1660: iconst_2
    //   1661: aload 22
    //   1663: aastore
    //   1664: invokestatic 432	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1667: aload 22
    //   1669: astore 21
    //   1671: getstatic 156	com/chelpus/root/utils/custompatch:withFramework	Z
    //   1674: ifne +48 -> 1722
    //   1677: aload 22
    //   1679: astore 21
    //   1681: aload 20
    //   1683: new 190	java/io/File
    //   1686: dup
    //   1687: new 174	java/lang/StringBuilder
    //   1690: dup
    //   1691: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1694: getstatic 122	com/chelpus/root/utils/custompatch:dir	Ljava/lang/String;
    //   1697: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1700: ldc -36
    //   1702: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: aload 20
    //   1707: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   1710: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1716: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   1719: invokestatic 436	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   1722: aload 22
    //   1724: astore 21
    //   1726: iconst_1
    //   1727: putstatic 148	com/chelpus/root/utils/custompatch:dataBaseExist	Z
    //   1730: aload 22
    //   1732: astore 21
    //   1734: getstatic 148	com/chelpus/root/utils/custompatch:dataBaseExist	Z
    //   1737: ifeq +15 -> 1752
    //   1740: aload 22
    //   1742: astore 21
    //   1744: aload 20
    //   1746: invokevirtual 443	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1749: putstatic 150	com/chelpus/root/utils/custompatch:dataBase	Ljava/lang/String;
    //   1752: aload 22
    //   1754: astore 21
    //   1756: ldc_w 445
    //   1759: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   1762: aload 22
    //   1764: astore 21
    //   1766: new 174	java/lang/StringBuilder
    //   1769: dup
    //   1770: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1773: ldc_w 447
    //   1776: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1779: aload 20
    //   1781: invokevirtual 443	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1784: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1790: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   1793: aload 22
    //   1795: astore 21
    //   1797: ldc_w 449
    //   1800: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   1803: aload 22
    //   1805: astore 20
    //   1807: aload 38
    //   1809: iload 12
    //   1811: aaload
    //   1812: ldc_w 451
    //   1815: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1818: ifeq +125 -> 1943
    //   1821: getstatic 148	com/chelpus/root/utils/custompatch:dataBaseExist	Z
    //   1824: istore 15
    //   1826: aload 22
    //   1828: astore 20
    //   1830: iload 15
    //   1832: ifeq +111 -> 1943
    //   1835: aload 22
    //   1837: astore 20
    //   1839: new 420	org/json/JSONObject
    //   1842: dup
    //   1843: aload 38
    //   1845: iload 12
    //   1847: aaload
    //   1848: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1851: ldc_w 451
    //   1854: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1857: astore 21
    //   1859: aload 21
    //   1861: astore 20
    //   1863: new 174	java/lang/StringBuilder
    //   1866: dup
    //   1867: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1870: ldc_w 453
    //   1873: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: aload 21
    //   1878: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1884: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   1887: aload 21
    //   1889: astore 20
    //   1891: getstatic 156	com/chelpus/root/utils/custompatch:withFramework	Z
    //   1894: istore 15
    //   1896: aload 21
    //   1898: astore 20
    //   1900: iload 15
    //   1902: ifeq +41 -> 1943
    //   1905: aload 21
    //   1907: astore 20
    //   1909: getstatic 150	com/chelpus/root/utils/custompatch:dataBase	Ljava/lang/String;
    //   1912: aconst_null
    //   1913: iconst_0
    //   1914: invokestatic 459	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   1917: astore 22
    //   1919: aload 21
    //   1921: astore 20
    //   1923: aload 22
    //   1925: aload 21
    //   1927: invokevirtual 462	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   1930: aload 21
    //   1932: astore 20
    //   1934: aload 22
    //   1936: invokevirtual 465	android/database/sqlite/SQLiteDatabase:close	()V
    //   1939: aload 21
    //   1941: astore 20
    //   1943: iload 7
    //   1945: istore 11
    //   1947: aload 20
    //   1949: astore 21
    //   1951: iload 7
    //   1953: ifeq +108 -> 2061
    //   1956: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   1959: invokevirtual 416	java/util/ArrayList:clear	()V
    //   1962: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   1965: invokevirtual 416	java/util/ArrayList:clear	()V
    //   1968: new 420	org/json/JSONObject
    //   1971: dup
    //   1972: aload 38
    //   1974: iload 12
    //   1976: aaload
    //   1977: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1980: ldc_w 467
    //   1983: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1986: astore 21
    //   1988: aload 21
    //   1990: astore 20
    //   1992: ldc_w 445
    //   1995: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   1998: aload 21
    //   2000: astore 20
    //   2002: new 174	java/lang/StringBuilder
    //   2005: dup
    //   2006: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   2009: ldc_w 469
    //   2012: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: aload 21
    //   2017: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2020: ldc_w 471
    //   2023: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2029: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   2032: aload 21
    //   2034: astore 20
    //   2036: ldc_w 449
    //   2039: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   2042: aload 21
    //   2044: astore 20
    //   2046: aload_0
    //   2047: iconst_0
    //   2048: aaload
    //   2049: aload 20
    //   2051: invokestatic 440	com/chelpus/root/utils/custompatch:searchfile	(Ljava/lang/String;Ljava/lang/String;)V
    //   2054: iconst_0
    //   2055: istore 11
    //   2057: aload 20
    //   2059: astore 21
    //   2061: aload 19
    //   2063: astore 20
    //   2065: aload 33
    //   2067: astore 32
    //   2069: iload 4
    //   2071: ifeq +177 -> 2248
    //   2074: aload 38
    //   2076: iload 12
    //   2078: aaload
    //   2079: ldc_w 473
    //   2082: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2085: istore 15
    //   2087: aload 19
    //   2089: astore 22
    //   2091: iload 15
    //   2093: ifeq +39 -> 2132
    //   2096: new 420	org/json/JSONObject
    //   2099: dup
    //   2100: aload 38
    //   2102: iload 12
    //   2104: aaload
    //   2105: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2108: ldc_w 473
    //   2111: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2114: astore 20
    //   2116: aload 20
    //   2118: astore 19
    //   2120: aload_0
    //   2121: iconst_0
    //   2122: aaload
    //   2123: aload 19
    //   2125: invokestatic 440	com/chelpus/root/utils/custompatch:searchfile	(Ljava/lang/String;Ljava/lang/String;)V
    //   2128: aload 19
    //   2130: astore 22
    //   2132: aload 22
    //   2134: astore 20
    //   2136: aload 33
    //   2138: astore 32
    //   2140: aload 38
    //   2142: iload 12
    //   2144: aaload
    //   2145: ldc_w 475
    //   2148: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2151: ifeq +97 -> 2248
    //   2154: aload 22
    //   2156: astore 20
    //   2158: aload 33
    //   2160: astore 32
    //   2162: aload 38
    //   2164: iload 12
    //   2166: aaload
    //   2167: ldc_w 403
    //   2170: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2173: ifeq +75 -> 2248
    //   2176: aload 22
    //   2178: astore 20
    //   2180: aload 33
    //   2182: astore 32
    //   2184: aload 38
    //   2186: iload 12
    //   2188: aaload
    //   2189: ldc_w 399
    //   2192: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2195: ifne +53 -> 2248
    //   2198: aload 38
    //   2200: iload 12
    //   2202: aaload
    //   2203: ldc_w 401
    //   2206: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2209: istore 15
    //   2211: aload 22
    //   2213: astore 20
    //   2215: aload 33
    //   2217: astore 32
    //   2219: iload 15
    //   2221: ifne +27 -> 2248
    //   2224: new 420	org/json/JSONObject
    //   2227: dup
    //   2228: aload 38
    //   2230: iload 12
    //   2232: aaload
    //   2233: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2236: ldc_w 475
    //   2239: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2242: astore 32
    //   2244: aload 22
    //   2246: astore 20
    //   2248: aload 20
    //   2250: astore 22
    //   2252: aload 27
    //   2254: astore 33
    //   2256: iload 10
    //   2258: ifeq +161 -> 2419
    //   2261: aload 38
    //   2263: iload 12
    //   2265: aaload
    //   2266: ldc_w 473
    //   2269: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2272: istore 15
    //   2274: aload 20
    //   2276: astore 19
    //   2278: iload 15
    //   2280: ifeq +23 -> 2303
    //   2283: new 420	org/json/JSONObject
    //   2286: dup
    //   2287: aload 38
    //   2289: iload 12
    //   2291: aaload
    //   2292: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2295: ldc_w 473
    //   2298: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2301: astore 19
    //   2303: aload 19
    //   2305: astore 22
    //   2307: aload 27
    //   2309: astore 33
    //   2311: aload 38
    //   2313: iload 12
    //   2315: aaload
    //   2316: ldc_w 477
    //   2319: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2322: ifeq +97 -> 2419
    //   2325: aload 19
    //   2327: astore 22
    //   2329: aload 27
    //   2331: astore 33
    //   2333: aload 38
    //   2335: iload 12
    //   2337: aaload
    //   2338: ldc_w 403
    //   2341: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2344: ifeq +75 -> 2419
    //   2347: aload 19
    //   2349: astore 22
    //   2351: aload 27
    //   2353: astore 33
    //   2355: aload 38
    //   2357: iload 12
    //   2359: aaload
    //   2360: ldc_w 399
    //   2363: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2366: ifne +53 -> 2419
    //   2369: aload 38
    //   2371: iload 12
    //   2373: aaload
    //   2374: ldc_w 401
    //   2377: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2380: istore 15
    //   2382: aload 19
    //   2384: astore 22
    //   2386: aload 27
    //   2388: astore 33
    //   2390: iload 15
    //   2392: ifne +27 -> 2419
    //   2395: new 420	org/json/JSONObject
    //   2398: dup
    //   2399: aload 38
    //   2401: iload 12
    //   2403: aaload
    //   2404: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2407: ldc_w 479
    //   2410: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2413: astore 33
    //   2415: aload 19
    //   2417: astore 22
    //   2419: iload 8
    //   2421: istore 9
    //   2423: aload 21
    //   2425: astore 19
    //   2427: iload 8
    //   2429: ifeq +58 -> 2487
    //   2432: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   2435: invokevirtual 416	java/util/ArrayList:clear	()V
    //   2438: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   2441: invokevirtual 416	java/util/ArrayList:clear	()V
    //   2444: new 420	org/json/JSONObject
    //   2447: dup
    //   2448: aload 38
    //   2450: iload 12
    //   2452: aaload
    //   2453: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2456: ldc_w 467
    //   2459: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2462: astore 19
    //   2464: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   2467: invokevirtual 416	java/util/ArrayList:clear	()V
    //   2470: aload_0
    //   2471: iconst_0
    //   2472: aaload
    //   2473: aload 19
    //   2475: aload_0
    //   2476: iconst_2
    //   2477: aaload
    //   2478: invokestatic 483	com/chelpus/root/utils/custompatch:searchlib	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    //   2481: putstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   2484: iconst_0
    //   2485: istore 9
    //   2487: iload 10
    //   2489: istore 7
    //   2491: aload 38
    //   2493: iload 12
    //   2495: aaload
    //   2496: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2499: ldc_w 485
    //   2502: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2505: ifeq +27 -> 2532
    //   2508: iconst_2
    //   2509: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2512: iconst_1
    //   2513: istore 9
    //   2515: iconst_0
    //   2516: istore 11
    //   2518: iconst_0
    //   2519: istore 4
    //   2521: iconst_0
    //   2522: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   2525: iconst_0
    //   2526: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2529: iconst_0
    //   2530: istore 7
    //   2532: iload 7
    //   2534: istore 10
    //   2536: iload 9
    //   2538: istore 8
    //   2540: iload 11
    //   2542: istore 6
    //   2544: iload 4
    //   2546: istore_1
    //   2547: aload 38
    //   2549: iload 12
    //   2551: aaload
    //   2552: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2555: ldc_w 487
    //   2558: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2561: ifeq +65 -> 2626
    //   2564: aload_0
    //   2565: bipush 7
    //   2567: aaload
    //   2568: invokevirtual 490	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2571: ldc_w 492
    //   2574: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2577: ifne +25 -> 2602
    //   2580: aload_0
    //   2581: bipush 7
    //   2583: aaload
    //   2584: invokevirtual 490	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2587: ldc_w 494
    //   2590: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2593: ifeq +4225 -> 6818
    //   2596: getstatic 142	com/chelpus/root/utils/custompatch:armv7	Z
    //   2599: ifne +4219 -> 6818
    //   2602: bipush 6
    //   2604: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2607: iconst_1
    //   2608: istore 8
    //   2610: iconst_0
    //   2611: istore 6
    //   2613: iconst_0
    //   2614: istore_1
    //   2615: iconst_0
    //   2616: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   2619: iconst_0
    //   2620: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2623: iconst_0
    //   2624: istore 10
    //   2626: iload 10
    //   2628: istore 11
    //   2630: iload 8
    //   2632: istore 9
    //   2634: iload 6
    //   2636: istore 7
    //   2638: iload_1
    //   2639: istore 4
    //   2641: aload 38
    //   2643: iload 12
    //   2645: aaload
    //   2646: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2649: ldc_w 370
    //   2652: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2655: ifeq +44 -> 2699
    //   2658: aload_0
    //   2659: bipush 7
    //   2661: aaload
    //   2662: invokevirtual 490	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2665: ldc_w 494
    //   2668: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2671: ifeq +4171 -> 6842
    //   2674: bipush 7
    //   2676: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2679: iconst_1
    //   2680: istore 9
    //   2682: iconst_0
    //   2683: istore 7
    //   2685: iconst_0
    //   2686: istore 4
    //   2688: iconst_0
    //   2689: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   2692: iconst_0
    //   2693: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2696: iconst_0
    //   2697: istore 11
    //   2699: iload 11
    //   2701: istore 10
    //   2703: iload 9
    //   2705: istore 8
    //   2707: iload 7
    //   2709: istore 6
    //   2711: iload 4
    //   2713: istore_1
    //   2714: aload 38
    //   2716: iload 12
    //   2718: aaload
    //   2719: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2722: ldc_w 496
    //   2725: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2728: ifeq +43 -> 2771
    //   2731: aload_0
    //   2732: bipush 7
    //   2734: aaload
    //   2735: invokevirtual 490	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2738: ldc_w 498
    //   2741: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2744: ifeq +4122 -> 6866
    //   2747: bipush 8
    //   2749: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2752: iconst_1
    //   2753: istore 8
    //   2755: iconst_0
    //   2756: istore 6
    //   2758: iconst_0
    //   2759: istore_1
    //   2760: iconst_0
    //   2761: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   2764: iconst_0
    //   2765: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2768: iconst_0
    //   2769: istore 10
    //   2771: iload 10
    //   2773: istore 11
    //   2775: iload 8
    //   2777: istore 9
    //   2779: iload 6
    //   2781: istore 7
    //   2783: iload_1
    //   2784: istore 4
    //   2786: aload 38
    //   2788: iload 12
    //   2790: aaload
    //   2791: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2794: ldc_w 500
    //   2797: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2800: ifeq +44 -> 2844
    //   2803: aload_0
    //   2804: bipush 7
    //   2806: aaload
    //   2807: invokevirtual 490	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2810: ldc_w 502
    //   2813: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2816: ifeq +4074 -> 6890
    //   2819: bipush 9
    //   2821: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2824: iconst_1
    //   2825: istore 9
    //   2827: iconst_0
    //   2828: istore 7
    //   2830: iconst_0
    //   2831: istore 4
    //   2833: iconst_0
    //   2834: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   2837: iconst_0
    //   2838: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2841: iconst_0
    //   2842: istore 11
    //   2844: aload 38
    //   2846: iload 12
    //   2848: aaload
    //   2849: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2852: ldc_w 504
    //   2855: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2858: ifeq +27 -> 2885
    //   2861: iconst_3
    //   2862: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2865: iconst_0
    //   2866: istore 9
    //   2868: iconst_1
    //   2869: istore 7
    //   2871: iconst_0
    //   2872: istore 4
    //   2874: iconst_0
    //   2875: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   2878: iconst_0
    //   2879: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2882: iconst_0
    //   2883: istore 11
    //   2885: aload 38
    //   2887: iload 12
    //   2889: aaload
    //   2890: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2893: ldc_w 506
    //   2896: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2899: ifeq +28 -> 2927
    //   2902: bipush 13
    //   2904: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2907: iconst_0
    //   2908: istore 9
    //   2910: iconst_0
    //   2911: istore 7
    //   2913: iconst_1
    //   2914: istore 4
    //   2916: iconst_0
    //   2917: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   2920: iconst_0
    //   2921: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2924: iconst_0
    //   2925: istore 11
    //   2927: aload 38
    //   2929: iload 12
    //   2931: aaload
    //   2932: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2935: ldc_w 508
    //   2938: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2941: ifeq +28 -> 2969
    //   2944: bipush 15
    //   2946: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2949: iconst_0
    //   2950: istore 9
    //   2952: iconst_0
    //   2953: istore 7
    //   2955: iconst_0
    //   2956: istore 4
    //   2958: iconst_0
    //   2959: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   2962: iconst_0
    //   2963: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2966: iconst_1
    //   2967: istore 11
    //   2969: iload 9
    //   2971: istore 8
    //   2973: aload 38
    //   2975: iload 12
    //   2977: aaload
    //   2978: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2981: ldc_w 368
    //   2984: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2987: ifeq +28 -> 3015
    //   2990: bipush 11
    //   2992: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2995: iconst_0
    //   2996: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2999: iconst_0
    //   3000: istore 11
    //   3002: iconst_0
    //   3003: istore 8
    //   3005: iconst_0
    //   3006: istore 7
    //   3008: iconst_0
    //   3009: istore 4
    //   3011: iconst_1
    //   3012: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   3015: iload 11
    //   3017: istore 9
    //   3019: iload 4
    //   3021: istore 6
    //   3023: aload 38
    //   3025: iload 12
    //   3027: aaload
    //   3028: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   3031: ldc_w 510
    //   3034: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3037: ifeq +28 -> 3065
    //   3040: bipush 14
    //   3042: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   3045: iconst_0
    //   3046: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   3049: iconst_0
    //   3050: istore 8
    //   3052: iconst_0
    //   3053: istore 7
    //   3055: iconst_0
    //   3056: istore 6
    //   3058: iconst_0
    //   3059: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   3062: iconst_0
    //   3063: istore 9
    //   3065: aload 38
    //   3067: iload 12
    //   3069: aaload
    //   3070: ldc_w 511
    //   3073: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3076: ifeq +56 -> 3132
    //   3079: aload 38
    //   3081: iload 12
    //   3083: aaload
    //   3084: ldc_w 403
    //   3087: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3090: ifeq +42 -> 3132
    //   3093: aload 38
    //   3095: iload 12
    //   3097: aaload
    //   3098: ldc_w 513
    //   3101: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3104: istore 15
    //   3106: iload 15
    //   3108: ifeq +24 -> 3132
    //   3111: new 420	org/json/JSONObject
    //   3114: dup
    //   3115: aload 38
    //   3117: iload 12
    //   3119: aaload
    //   3120: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3123: ldc_w 511
    //   3126: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3129: putstatic 154	com/chelpus/root/utils/custompatch:group	Ljava/lang/String;
    //   3132: aload 25
    //   3134: astore 20
    //   3136: aload 26
    //   3138: astore 27
    //   3140: iload_2
    //   3141: istore_1
    //   3142: iload_3
    //   3143: istore 10
    //   3145: iload 17
    //   3147: istore 16
    //   3149: aload 19
    //   3151: astore 21
    //   3153: aload 38
    //   3155: iload 12
    //   3157: aaload
    //   3158: ldc_w 515
    //   3161: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3164: ifeq +3848 -> 7012
    //   3167: aload 25
    //   3169: astore 20
    //   3171: aload 26
    //   3173: astore 27
    //   3175: iload_2
    //   3176: istore_1
    //   3177: iload_3
    //   3178: istore 10
    //   3180: iload 17
    //   3182: istore 16
    //   3184: aload 19
    //   3186: astore 21
    //   3188: aload 38
    //   3190: iload 12
    //   3192: aaload
    //   3193: ldc_w 403
    //   3196: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3199: ifeq +3813 -> 7012
    //   3202: aload 25
    //   3204: astore 20
    //   3206: aload 26
    //   3208: astore 27
    //   3210: iload_2
    //   3211: istore_1
    //   3212: iload_3
    //   3213: istore 10
    //   3215: iload 17
    //   3217: istore 16
    //   3219: aload 19
    //   3221: astore 21
    //   3223: aload 38
    //   3225: iload 12
    //   3227: aaload
    //   3228: ldc_w 513
    //   3231: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3234: ifeq +3778 -> 7012
    //   3237: iload_3
    //   3238: istore 4
    //   3240: iload 17
    //   3242: istore 15
    //   3244: iload_3
    //   3245: ifeq +67 -> 3312
    //   3248: getstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   3251: iconst_1
    //   3252: if_icmpne +3678 -> 6930
    //   3255: getstatic 162	com/chelpus/root/utils/custompatch:classesFiles	Ljava/util/ArrayList;
    //   3258: invokevirtual 209	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3261: astore 20
    //   3263: iload_3
    //   3264: istore 4
    //   3266: iload 17
    //   3268: istore 15
    //   3270: aload 20
    //   3272: invokeinterface 214 1 0
    //   3277: ifeq +35 -> 3312
    //   3280: aload 20
    //   3282: invokeinterface 218 1 0
    //   3287: checkcast 190	java/io/File
    //   3290: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   3293: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   3296: invokestatic 519	com/chelpus/root/utils/custompatch:searchProcess	(Ljava/util/ArrayList;)Z
    //   3299: istore 15
    //   3301: iload 15
    //   3303: ifeq -40 -> 3263
    //   3306: iconst_1
    //   3307: istore 15
    //   3309: iconst_0
    //   3310: istore 4
    //   3312: new 420	org/json/JSONObject
    //   3315: dup
    //   3316: aload 38
    //   3318: iload 12
    //   3320: aaload
    //   3321: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3324: ldc_w 515
    //   3327: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3330: astore 20
    //   3332: aload 20
    //   3334: astore 19
    //   3336: aload 19
    //   3338: invokevirtual 522	java/lang/String:trim	()Ljava/lang/String;
    //   3341: astore 20
    //   3343: aload 20
    //   3345: astore 19
    //   3347: getstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   3350: ifeq +10 -> 3360
    //   3353: aload 20
    //   3355: invokestatic 525	com/chelpus/Utils:rework	(Ljava/lang/String;)Ljava/lang/String;
    //   3358: astore 19
    //   3360: aload 19
    //   3362: ldc_w 527
    //   3365: invokevirtual 531	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3368: arraylength
    //   3369: anewarray 283	java/lang/String
    //   3372: astore 20
    //   3374: aload 19
    //   3376: ldc_w 527
    //   3379: invokevirtual 531	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3382: astore 34
    //   3384: aload 34
    //   3386: arraylength
    //   3387: newarray <illegal type>
    //   3389: astore 25
    //   3391: aload 34
    //   3393: arraylength
    //   3394: newarray <illegal type>
    //   3396: astore 26
    //   3398: iconst_0
    //   3399: istore 11
    //   3401: iload_2
    //   3402: istore_3
    //   3403: aload 26
    //   3405: astore 20
    //   3407: aload 25
    //   3409: astore 27
    //   3411: iload_2
    //   3412: istore_1
    //   3413: iload 4
    //   3415: istore 10
    //   3417: iload 15
    //   3419: istore 16
    //   3421: aload 19
    //   3423: astore 21
    //   3425: iload 11
    //   3427: aload 34
    //   3429: arraylength
    //   3430: if_icmpge +3582 -> 7012
    //   3433: iload_2
    //   3434: istore_1
    //   3435: iload_2
    //   3436: istore_3
    //   3437: aload 34
    //   3439: iload 11
    //   3441: aaload
    //   3442: ldc_w 533
    //   3445: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3448: ifeq +31 -> 3479
    //   3451: iload_2
    //   3452: istore_1
    //   3453: iload_2
    //   3454: istore_3
    //   3455: aload 34
    //   3457: iload 11
    //   3459: aaload
    //   3460: ldc_w 535
    //   3463: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3466: ifne +13 -> 3479
    //   3469: iconst_1
    //   3470: istore_1
    //   3471: aload 34
    //   3473: iload 11
    //   3475: ldc_w 537
    //   3478: aastore
    //   3479: iload_1
    //   3480: istore_3
    //   3481: aload 34
    //   3483: iload 11
    //   3485: aaload
    //   3486: ldc_w 535
    //   3489: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3492: ifne +6301 -> 9793
    //   3495: iload_1
    //   3496: istore_3
    //   3497: aload 34
    //   3499: iload 11
    //   3501: aaload
    //   3502: ldc_w 539
    //   3505: invokevirtual 542	java/lang/String:matches	(Ljava/lang/String;)Z
    //   3508: ifeq +3447 -> 6955
    //   3511: goto +6282 -> 9793
    //   3514: iload_1
    //   3515: istore_3
    //   3516: aload 34
    //   3518: iload 11
    //   3520: aaload
    //   3521: ldc_w 544
    //   3524: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3527: ifne +51 -> 3578
    //   3530: iload_1
    //   3531: istore_3
    //   3532: aload 34
    //   3534: iload 11
    //   3536: aaload
    //   3537: ldc_w 546
    //   3540: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3543: ifne +35 -> 3578
    //   3546: iload_1
    //   3547: istore_3
    //   3548: aload 34
    //   3550: iload 11
    //   3552: aaload
    //   3553: ldc_w 548
    //   3556: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3559: ifne +19 -> 3578
    //   3562: iload_1
    //   3563: istore_3
    //   3564: aload 34
    //   3566: iload 11
    //   3568: aaload
    //   3569: ldc_w 550
    //   3572: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3575: ifeq +50 -> 3625
    //   3578: iload_1
    //   3579: istore_3
    //   3580: aload 25
    //   3582: iload 11
    //   3584: aload 34
    //   3586: iload 11
    //   3588: aaload
    //   3589: invokevirtual 490	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3592: ldc_w 546
    //   3595: ldc -124
    //   3597: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   3600: ldc_w 550
    //   3603: ldc -124
    //   3605: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   3608: invokestatic 555	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   3611: invokevirtual 558	java/lang/Integer:intValue	()I
    //   3614: iconst_2
    //   3615: iadd
    //   3616: iastore
    //   3617: aload 34
    //   3619: iload 11
    //   3621: ldc_w 537
    //   3624: aastore
    //   3625: iload_1
    //   3626: istore_3
    //   3627: aload 26
    //   3629: iload 11
    //   3631: aload 34
    //   3633: iload 11
    //   3635: aaload
    //   3636: bipush 16
    //   3638: invokestatic 561	java/lang/Integer:valueOf	(Ljava/lang/String;I)Ljava/lang/Integer;
    //   3641: invokevirtual 565	java/lang/Integer:byteValue	()B
    //   3644: bastore
    //   3645: iload 11
    //   3647: iconst_1
    //   3648: iadd
    //   3649: istore 11
    //   3651: iload_1
    //   3652: istore_2
    //   3653: goto -252 -> 3401
    //   3656: aload 21
    //   3658: invokevirtual 566	java/io/BufferedReader:close	()V
    //   3661: aload 19
    //   3663: invokevirtual 567	java/io/FileInputStream:close	()V
    //   3666: goto -3157 -> 509
    //   3669: getstatic 138	com/chelpus/root/utils/custompatch:odexpatch	Z
    //   3672: ifeq +163 -> 3835
    //   3675: new 190	java/io/File
    //   3678: dup
    //   3679: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   3682: iconst_1
    //   3683: invokestatic 337	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   3686: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   3689: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   3692: iload 9
    //   3694: istore 10
    //   3696: iload_1
    //   3697: istore 14
    //   3699: aload 20
    //   3701: astore 31
    //   3703: iload 6
    //   3705: istore 4
    //   3707: iload 15
    //   3709: istore 18
    //   3711: iload 16
    //   3713: istore 17
    //   3715: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   3718: invokevirtual 205	java/util/ArrayList:size	()I
    //   3721: ifle -2449 -> 1272
    //   3724: ldc_w 569
    //   3727: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3730: ldc_w 571
    //   3733: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3736: ldc_w 573
    //   3739: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3742: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   3745: ldc -124
    //   3747: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3750: ifne +9 -> 3759
    //   3753: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   3756: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3759: getstatic 116	com/chelpus/root/utils/custompatch:manualpatch	Z
    //   3762: ifne +6048 -> 9810
    //   3765: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   3768: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   3771: istore 15
    //   3773: goto +6037 -> 9810
    //   3776: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   3779: invokevirtual 416	java/util/ArrayList:clear	()V
    //   3782: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   3785: invokevirtual 416	java/util/ArrayList:clear	()V
    //   3788: sipush 200
    //   3791: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   3794: ldc -124
    //   3796: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   3799: iload 9
    //   3801: istore 10
    //   3803: iload_1
    //   3804: istore 14
    //   3806: aload 20
    //   3808: astore 31
    //   3810: iload 6
    //   3812: istore 4
    //   3814: iload 15
    //   3816: istore 18
    //   3818: iload 16
    //   3820: istore 17
    //   3822: goto -2550 -> 1272
    //   3825: astore_0
    //   3826: ldc_w 578
    //   3829: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3832: goto -3601 -> 231
    //   3835: getstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   3838: ifne +243 -> 4081
    //   3841: aload_0
    //   3842: iconst_2
    //   3843: aaload
    //   3844: invokestatic 373	com/chelpus/root/utils/custompatch:searchDalvik	(Ljava/lang/String;)V
    //   3847: new 190	java/io/File
    //   3850: dup
    //   3851: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   3854: iconst_1
    //   3855: invokestatic 337	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   3858: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   3861: invokevirtual 198	java/io/File:exists	()Z
    //   3864: ifeq +54 -> 3918
    //   3867: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   3870: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   3873: ldc_w 580
    //   3876: invokevirtual 583	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3879: ifne +39 -> 3918
    //   3882: new 190	java/io/File
    //   3885: dup
    //   3886: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   3889: iconst_1
    //   3890: invokestatic 337	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   3893: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   3896: invokevirtual 201	java/io/File:delete	()Z
    //   3899: pop
    //   3900: ldc_w 569
    //   3903: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3906: ldc_w 585
    //   3909: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3912: ldc_w 573
    //   3915: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3918: iload 9
    //   3920: istore 10
    //   3922: iload_1
    //   3923: istore 14
    //   3925: aload 20
    //   3927: astore 31
    //   3929: iload 6
    //   3931: istore 4
    //   3933: iload 15
    //   3935: istore 18
    //   3937: iload 16
    //   3939: istore 17
    //   3941: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   3944: invokevirtual 205	java/util/ArrayList:size	()I
    //   3947: ifle -2675 -> 1272
    //   3950: ldc_w 569
    //   3953: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3956: ldc_w 587
    //   3959: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3962: ldc_w 573
    //   3965: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3968: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   3971: ldc -124
    //   3973: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3976: ifne +9 -> 3985
    //   3979: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   3982: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   3985: getstatic 116	com/chelpus/root/utils/custompatch:manualpatch	Z
    //   3988: ifne +5833 -> 9821
    //   3991: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   3994: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   3997: istore 15
    //   3999: goto +5822 -> 9821
    //   4002: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   4005: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4008: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4011: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4014: sipush 200
    //   4017: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   4020: ldc -124
    //   4022: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4025: iload 9
    //   4027: istore 10
    //   4029: iload_1
    //   4030: istore 14
    //   4032: aload 20
    //   4034: astore 31
    //   4036: iload 6
    //   4038: istore 4
    //   4040: iload 15
    //   4042: istore 18
    //   4044: iload 16
    //   4046: istore 17
    //   4048: goto -2776 -> 1272
    //   4051: astore_0
    //   4052: aload_0
    //   4053: invokevirtual 309	java/lang/Exception:printStackTrace	()V
    //   4056: new 174	java/lang/StringBuilder
    //   4059: dup
    //   4060: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   4063: ldc -124
    //   4065: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4068: aload_0
    //   4069: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4072: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4075: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4078: goto -3847 -> 231
    //   4081: iload 9
    //   4083: istore 10
    //   4085: iload_1
    //   4086: istore 14
    //   4088: aload 20
    //   4090: astore 31
    //   4092: iload 6
    //   4094: istore 4
    //   4096: iload 15
    //   4098: istore 18
    //   4100: iload 16
    //   4102: istore 17
    //   4104: getstatic 162	com/chelpus/root/utils/custompatch:classesFiles	Ljava/util/ArrayList;
    //   4107: ifnull -2835 -> 1272
    //   4110: iload 9
    //   4112: istore 10
    //   4114: iload_1
    //   4115: istore 14
    //   4117: aload 20
    //   4119: astore 31
    //   4121: iload 6
    //   4123: istore 4
    //   4125: iload 15
    //   4127: istore 18
    //   4129: iload 16
    //   4131: istore 17
    //   4133: getstatic 162	com/chelpus/root/utils/custompatch:classesFiles	Ljava/util/ArrayList;
    //   4136: invokevirtual 205	java/util/ArrayList:size	()I
    //   4139: ifle -2867 -> 1272
    //   4142: getstatic 162	com/chelpus/root/utils/custompatch:classesFiles	Ljava/util/ArrayList;
    //   4145: invokevirtual 205	java/util/ArrayList:size	()I
    //   4148: iconst_1
    //   4149: if_icmple +7 -> 4156
    //   4152: iconst_1
    //   4153: putstatic 164	com/chelpus/root/utils/custompatch:multidex	Z
    //   4156: getstatic 162	com/chelpus/root/utils/custompatch:classesFiles	Ljava/util/ArrayList;
    //   4159: invokevirtual 209	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4162: astore 22
    //   4164: aload 22
    //   4166: invokeinterface 214 1 0
    //   4171: ifeq +112 -> 4283
    //   4174: aload 22
    //   4176: invokeinterface 218 1 0
    //   4181: checkcast 190	java/io/File
    //   4184: astore 31
    //   4186: aload 31
    //   4188: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   4191: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4194: invokevirtual 205	java/util/ArrayList:size	()I
    //   4197: ifle -33 -> 4164
    //   4200: ldc_w 569
    //   4203: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4206: new 174	java/lang/StringBuilder
    //   4209: dup
    //   4210: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   4213: ldc_w 592
    //   4216: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4219: aload 31
    //   4221: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   4224: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4227: ldc_w 471
    //   4230: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4233: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4236: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4239: ldc_w 573
    //   4242: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4245: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4248: ldc -124
    //   4250: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4253: ifne +9 -> 4262
    //   4256: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4259: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4262: iload 15
    //   4264: istore 17
    //   4266: getstatic 116	com/chelpus/root/utils/custompatch:manualpatch	Z
    //   4269: ifne +5563 -> 9832
    //   4272: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4275: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   4278: istore 17
    //   4280: goto +5552 -> 9832
    //   4283: iconst_0
    //   4284: putstatic 164	com/chelpus/root/utils/custompatch:multidex	Z
    //   4287: iconst_0
    //   4288: putstatic 166	com/chelpus/root/utils/custompatch:goodResult	Z
    //   4291: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   4294: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4297: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4300: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4303: sipush 200
    //   4306: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   4309: ldc -124
    //   4311: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4314: iload 9
    //   4316: istore 10
    //   4318: iload_1
    //   4319: istore 14
    //   4321: aload 20
    //   4323: astore 31
    //   4325: iload 6
    //   4327: istore 4
    //   4329: iload 15
    //   4331: istore 18
    //   4333: iload 16
    //   4335: istore 17
    //   4337: goto -3065 -> 1272
    //   4340: iconst_0
    //   4341: putstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   4344: iload 16
    //   4346: istore 17
    //   4348: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4351: invokevirtual 205	java/util/ArrayList:size	()I
    //   4354: ifle +66 -> 4420
    //   4357: ldc_w 569
    //   4360: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4363: ldc_w 594
    //   4366: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4369: ldc_w 573
    //   4372: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4375: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4378: ldc -124
    //   4380: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4383: ifne +9 -> 4392
    //   4386: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4389: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4392: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4395: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   4398: istore 18
    //   4400: iload 18
    //   4402: istore 15
    //   4404: iload 16
    //   4406: istore 17
    //   4408: iload 18
    //   4410: ifne +10 -> 4420
    //   4413: iconst_0
    //   4414: istore 17
    //   4416: iload 18
    //   4418: istore 15
    //   4420: ldc_w 569
    //   4423: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4426: ldc_w 596
    //   4429: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4432: ldc_w 573
    //   4435: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4438: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4441: ldc -124
    //   4443: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4446: ifne +9 -> 4455
    //   4449: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4452: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4455: getstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   4458: ifne +9 -> 4467
    //   4461: aload_0
    //   4462: iconst_2
    //   4463: aaload
    //   4464: invokestatic 373	com/chelpus/root/utils/custompatch:searchDalvik	(Ljava/lang/String;)V
    //   4467: aload_0
    //   4468: iconst_0
    //   4469: aaload
    //   4470: aload_0
    //   4471: iconst_2
    //   4472: aaload
    //   4473: invokestatic 599	com/chelpus/root/utils/custompatch:searchDalvikOdex	(Ljava/lang/String;Ljava/lang/String;)V
    //   4476: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   4479: invokevirtual 198	java/io/File:exists	()Z
    //   4482: ifeq +13 -> 4495
    //   4485: iconst_1
    //   4486: istore_1
    //   4487: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   4490: invokevirtual 443	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4493: astore 20
    //   4495: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   4498: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4501: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4504: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4507: sipush 200
    //   4510: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   4513: ldc -124
    //   4515: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4518: iload 9
    //   4520: istore 10
    //   4522: iload_1
    //   4523: istore 14
    //   4525: aload 20
    //   4527: astore 31
    //   4529: iload 6
    //   4531: istore 4
    //   4533: iload 15
    //   4535: istore 18
    //   4537: goto -3265 -> 1272
    //   4540: iconst_0
    //   4541: putstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   4544: iload 15
    //   4546: istore 18
    //   4548: iload 16
    //   4550: istore 17
    //   4552: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4555: invokevirtual 205	java/util/ArrayList:size	()I
    //   4558: ifle +177 -> 4735
    //   4561: iload 15
    //   4563: istore 18
    //   4565: iload 16
    //   4567: istore 17
    //   4569: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   4572: ifnull +163 -> 4735
    //   4575: iload 15
    //   4577: istore 18
    //   4579: iload 16
    //   4581: istore 17
    //   4583: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   4586: invokevirtual 205	java/util/ArrayList:size	()I
    //   4589: ifle +146 -> 4735
    //   4592: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   4595: invokevirtual 209	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4598: astore 22
    //   4600: aload 22
    //   4602: invokeinterface 214 1 0
    //   4607: ifeq +106 -> 4713
    //   4610: aload 22
    //   4612: invokeinterface 218 1 0
    //   4617: checkcast 190	java/io/File
    //   4620: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   4623: ldc_w 445
    //   4626: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4629: new 174	java/lang/StringBuilder
    //   4632: dup
    //   4633: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   4636: ldc_w 601
    //   4639: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4642: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   4645: invokevirtual 443	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4648: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4651: ldc_w 471
    //   4654: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4657: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4660: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4663: ldc_w 449
    //   4666: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4669: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4672: ldc -124
    //   4674: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4677: ifne +9 -> 4686
    //   4680: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4683: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4686: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4689: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   4692: istore 17
    //   4694: iload 17
    //   4696: istore 15
    //   4698: iload 17
    //   4700: ifne -100 -> 4600
    //   4703: iconst_0
    //   4704: istore 16
    //   4706: iload 17
    //   4708: istore 15
    //   4710: goto -110 -> 4600
    //   4713: iconst_0
    //   4714: putstatic 168	com/chelpus/root/utils/custompatch:multilib_patch	Z
    //   4717: iconst_0
    //   4718: putstatic 166	com/chelpus/root/utils/custompatch:goodResult	Z
    //   4721: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   4724: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4727: iload 16
    //   4729: istore 17
    //   4731: iload 15
    //   4733: istore 18
    //   4735: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   4738: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4741: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4744: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4747: sipush 200
    //   4750: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   4753: ldc -124
    //   4755: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4758: iload 9
    //   4760: istore 10
    //   4762: iload_1
    //   4763: istore 14
    //   4765: aload 20
    //   4767: astore 31
    //   4769: iload 6
    //   4771: istore 4
    //   4773: goto -3501 -> 1272
    //   4776: iconst_0
    //   4777: putstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   4780: iload 15
    //   4782: istore 18
    //   4784: iload 16
    //   4786: istore 17
    //   4788: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4791: invokevirtual 205	java/util/ArrayList:size	()I
    //   4794: ifle +177 -> 4971
    //   4797: iload 15
    //   4799: istore 18
    //   4801: iload 16
    //   4803: istore 17
    //   4805: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   4808: ifnull +163 -> 4971
    //   4811: iload 15
    //   4813: istore 18
    //   4815: iload 16
    //   4817: istore 17
    //   4819: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   4822: invokevirtual 205	java/util/ArrayList:size	()I
    //   4825: ifle +146 -> 4971
    //   4828: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   4831: invokevirtual 209	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4834: astore 22
    //   4836: aload 22
    //   4838: invokeinterface 214 1 0
    //   4843: ifeq +106 -> 4949
    //   4846: aload 22
    //   4848: invokeinterface 218 1 0
    //   4853: checkcast 190	java/io/File
    //   4856: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   4859: ldc_w 603
    //   4862: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4865: new 174	java/lang/StringBuilder
    //   4868: dup
    //   4869: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   4872: ldc_w 605
    //   4875: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4878: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   4881: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   4884: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4887: ldc_w 471
    //   4890: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4893: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4896: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4899: ldc_w 607
    //   4902: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4905: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4908: ldc -124
    //   4910: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4913: ifne +9 -> 4922
    //   4916: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4919: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   4922: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4925: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   4928: istore 17
    //   4930: iload 17
    //   4932: istore 15
    //   4934: iload 17
    //   4936: ifne -100 -> 4836
    //   4939: iconst_0
    //   4940: istore 16
    //   4942: iload 17
    //   4944: istore 15
    //   4946: goto -110 -> 4836
    //   4949: iconst_0
    //   4950: putstatic 168	com/chelpus/root/utils/custompatch:multilib_patch	Z
    //   4953: iconst_0
    //   4954: putstatic 166	com/chelpus/root/utils/custompatch:goodResult	Z
    //   4957: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   4960: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4963: iload 16
    //   4965: istore 17
    //   4967: iload 15
    //   4969: istore 18
    //   4971: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   4974: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4977: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   4980: invokevirtual 416	java/util/ArrayList:clear	()V
    //   4983: sipush 200
    //   4986: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   4989: ldc -124
    //   4991: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   4994: iload 9
    //   4996: istore 10
    //   4998: iload_1
    //   4999: istore 14
    //   5001: aload 20
    //   5003: astore 31
    //   5005: iload 6
    //   5007: istore 4
    //   5009: goto -3737 -> 1272
    //   5012: iconst_0
    //   5013: putstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   5016: iload 15
    //   5018: istore 18
    //   5020: iload 16
    //   5022: istore 17
    //   5024: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5027: invokevirtual 205	java/util/ArrayList:size	()I
    //   5030: ifle +177 -> 5207
    //   5033: iload 15
    //   5035: istore 18
    //   5037: iload 16
    //   5039: istore 17
    //   5041: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5044: ifnull +163 -> 5207
    //   5047: iload 15
    //   5049: istore 18
    //   5051: iload 16
    //   5053: istore 17
    //   5055: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5058: invokevirtual 205	java/util/ArrayList:size	()I
    //   5061: ifle +146 -> 5207
    //   5064: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5067: invokevirtual 209	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   5070: astore 22
    //   5072: aload 22
    //   5074: invokeinterface 214 1 0
    //   5079: ifeq +106 -> 5185
    //   5082: aload 22
    //   5084: invokeinterface 218 1 0
    //   5089: checkcast 190	java/io/File
    //   5092: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   5095: ldc_w 609
    //   5098: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5101: new 174	java/lang/StringBuilder
    //   5104: dup
    //   5105: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   5108: ldc_w 611
    //   5111: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5114: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   5117: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   5120: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5123: ldc_w 471
    //   5126: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5129: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5132: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5135: ldc_w 613
    //   5138: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5141: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5144: ldc -124
    //   5146: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5149: ifne +9 -> 5158
    //   5152: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5155: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5158: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5161: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   5164: istore 17
    //   5166: iload 17
    //   5168: istore 15
    //   5170: iload 17
    //   5172: ifne -100 -> 5072
    //   5175: iconst_0
    //   5176: istore 16
    //   5178: iload 17
    //   5180: istore 15
    //   5182: goto -110 -> 5072
    //   5185: iconst_0
    //   5186: putstatic 168	com/chelpus/root/utils/custompatch:multilib_patch	Z
    //   5189: iconst_0
    //   5190: putstatic 166	com/chelpus/root/utils/custompatch:goodResult	Z
    //   5193: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5196: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5199: iload 16
    //   5201: istore 17
    //   5203: iload 15
    //   5205: istore 18
    //   5207: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   5210: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5213: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5216: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5219: sipush 200
    //   5222: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   5225: ldc -124
    //   5227: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5230: iload 9
    //   5232: istore 10
    //   5234: iload_1
    //   5235: istore 14
    //   5237: aload 20
    //   5239: astore 31
    //   5241: iload 6
    //   5243: istore 4
    //   5245: goto -3973 -> 1272
    //   5248: iconst_0
    //   5249: putstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   5252: iload 15
    //   5254: istore 18
    //   5256: iload 16
    //   5258: istore 17
    //   5260: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5263: invokevirtual 205	java/util/ArrayList:size	()I
    //   5266: ifle +177 -> 5443
    //   5269: iload 15
    //   5271: istore 18
    //   5273: iload 16
    //   5275: istore 17
    //   5277: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5280: ifnull +163 -> 5443
    //   5283: iload 15
    //   5285: istore 18
    //   5287: iload 16
    //   5289: istore 17
    //   5291: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5294: invokevirtual 205	java/util/ArrayList:size	()I
    //   5297: ifle +146 -> 5443
    //   5300: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5303: invokevirtual 209	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   5306: astore 22
    //   5308: aload 22
    //   5310: invokeinterface 214 1 0
    //   5315: ifeq +106 -> 5421
    //   5318: aload 22
    //   5320: invokeinterface 218 1 0
    //   5325: checkcast 190	java/io/File
    //   5328: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   5331: ldc_w 445
    //   5334: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5337: new 174	java/lang/StringBuilder
    //   5340: dup
    //   5341: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   5344: ldc_w 615
    //   5347: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5350: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   5353: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   5356: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5359: ldc_w 471
    //   5362: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5365: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5368: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5371: ldc_w 449
    //   5374: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5377: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5380: ldc -124
    //   5382: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5385: ifne +9 -> 5394
    //   5388: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5391: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5394: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5397: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   5400: istore 17
    //   5402: iload 17
    //   5404: istore 15
    //   5406: iload 17
    //   5408: ifne -100 -> 5308
    //   5411: iconst_0
    //   5412: istore 16
    //   5414: iload 17
    //   5416: istore 15
    //   5418: goto -110 -> 5308
    //   5421: iconst_0
    //   5422: putstatic 168	com/chelpus/root/utils/custompatch:multilib_patch	Z
    //   5425: iconst_0
    //   5426: putstatic 166	com/chelpus/root/utils/custompatch:goodResult	Z
    //   5429: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5432: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5435: iload 16
    //   5437: istore 17
    //   5439: iload 15
    //   5441: istore 18
    //   5443: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   5446: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5449: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5452: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5455: sipush 200
    //   5458: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   5461: ldc -124
    //   5463: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5466: iload 9
    //   5468: istore 10
    //   5470: iload_1
    //   5471: istore 14
    //   5473: aload 20
    //   5475: astore 31
    //   5477: iload 6
    //   5479: istore 4
    //   5481: goto -4209 -> 1272
    //   5484: iconst_0
    //   5485: putstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   5488: iload 15
    //   5490: istore 18
    //   5492: iload 16
    //   5494: istore 17
    //   5496: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5499: invokevirtual 205	java/util/ArrayList:size	()I
    //   5502: ifle +177 -> 5679
    //   5505: iload 15
    //   5507: istore 18
    //   5509: iload 16
    //   5511: istore 17
    //   5513: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5516: ifnull +163 -> 5679
    //   5519: iload 15
    //   5521: istore 18
    //   5523: iload 16
    //   5525: istore 17
    //   5527: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5530: invokevirtual 205	java/util/ArrayList:size	()I
    //   5533: ifle +146 -> 5679
    //   5536: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5539: invokevirtual 209	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   5542: astore 22
    //   5544: aload 22
    //   5546: invokeinterface 214 1 0
    //   5551: ifeq +106 -> 5657
    //   5554: aload 22
    //   5556: invokeinterface 218 1 0
    //   5561: checkcast 190	java/io/File
    //   5564: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   5567: ldc_w 445
    //   5570: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5573: new 174	java/lang/StringBuilder
    //   5576: dup
    //   5577: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   5580: ldc_w 617
    //   5583: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5586: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   5589: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   5592: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5595: ldc_w 471
    //   5598: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5601: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5604: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5607: ldc_w 449
    //   5610: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5613: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5616: ldc -124
    //   5618: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5621: ifne +9 -> 5630
    //   5624: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5627: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5630: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5633: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   5636: istore 17
    //   5638: iload 17
    //   5640: istore 15
    //   5642: iload 17
    //   5644: ifne -100 -> 5544
    //   5647: iconst_0
    //   5648: istore 16
    //   5650: iload 17
    //   5652: istore 15
    //   5654: goto -110 -> 5544
    //   5657: iconst_0
    //   5658: putstatic 168	com/chelpus/root/utils/custompatch:multilib_patch	Z
    //   5661: iconst_0
    //   5662: putstatic 166	com/chelpus/root/utils/custompatch:goodResult	Z
    //   5665: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   5668: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5671: iload 16
    //   5673: istore 17
    //   5675: iload 15
    //   5677: istore 18
    //   5679: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   5682: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5685: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5688: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5691: sipush 200
    //   5694: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   5697: ldc -124
    //   5699: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5702: iload 9
    //   5704: istore 10
    //   5706: iload_1
    //   5707: istore 14
    //   5709: aload 20
    //   5711: astore 31
    //   5713: iload 6
    //   5715: istore 4
    //   5717: goto -4445 -> 1272
    //   5720: iconst_0
    //   5721: putstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   5724: iload 15
    //   5726: istore 18
    //   5728: iload 16
    //   5730: istore 17
    //   5732: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5735: invokevirtual 205	java/util/ArrayList:size	()I
    //   5738: ifle +20 -> 5758
    //   5741: getstatic 116	com/chelpus/root/utils/custompatch:manualpatch	Z
    //   5744: ifne +4107 -> 9851
    //   5747: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5750: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   5753: istore 15
    //   5755: goto +4096 -> 9851
    //   5758: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   5761: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5764: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5767: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5770: sipush 200
    //   5773: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   5776: ldc -124
    //   5778: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5781: iload 9
    //   5783: istore 10
    //   5785: iload_1
    //   5786: istore 14
    //   5788: aload 20
    //   5790: astore 31
    //   5792: iload 6
    //   5794: istore 4
    //   5796: goto -4524 -> 1272
    //   5799: iconst_0
    //   5800: putstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   5803: ldc_w 445
    //   5806: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5809: ldc_w 619
    //   5812: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5815: ldc_w 449
    //   5818: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5821: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5824: ldc -124
    //   5826: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5829: ifne +9 -> 5838
    //   5832: getstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5835: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5838: new 190	java/io/File
    //   5841: dup
    //   5842: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   5845: iconst_1
    //   5846: invokestatic 337	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   5849: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   5852: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   5855: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   5858: invokevirtual 198	java/io/File:exists	()Z
    //   5861: ifne +9 -> 5870
    //   5864: ldc_w 621
    //   5867: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5870: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   5873: invokevirtual 625	java/io/File:length	()J
    //   5876: lconst_0
    //   5877: lcmp
    //   5878: ifne +16 -> 5894
    //   5881: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   5884: invokevirtual 201	java/io/File:delete	()Z
    //   5887: pop
    //   5888: ldc_w 621
    //   5891: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   5894: iconst_0
    //   5895: putstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   5898: iconst_0
    //   5899: putstatic 118	com/chelpus/root/utils/custompatch:odex	Z
    //   5902: iload 16
    //   5904: istore 17
    //   5906: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5909: invokevirtual 205	java/util/ArrayList:size	()I
    //   5912: ifle +31 -> 5943
    //   5915: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5918: invokestatic 576	com/chelpus/root/utils/custompatch:patchProcess	(Ljava/util/ArrayList;)Z
    //   5921: istore 18
    //   5923: iload 18
    //   5925: istore 15
    //   5927: iload 16
    //   5929: istore 17
    //   5931: iload 18
    //   5933: ifne +10 -> 5943
    //   5936: iconst_0
    //   5937: istore 17
    //   5939: iload 18
    //   5941: istore 15
    //   5943: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   5946: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5949: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   5952: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5955: sipush 200
    //   5958: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   5961: ldc -124
    //   5963: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   5966: iload 9
    //   5968: istore 10
    //   5970: iload_1
    //   5971: istore 14
    //   5973: aload 20
    //   5975: astore 31
    //   5977: iload 6
    //   5979: istore 4
    //   5981: iload 15
    //   5983: istore 18
    //   5985: goto -4713 -> 1272
    //   5988: iconst_0
    //   5989: putstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   5992: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   5995: invokevirtual 416	java/util/ArrayList:clear	()V
    //   5998: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   6001: invokevirtual 416	java/util/ArrayList:clear	()V
    //   6004: sipush 200
    //   6007: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   6010: ldc -124
    //   6012: putstatic 152	com/chelpus/root/utils/custompatch:searchStr	Ljava/lang/String;
    //   6015: iload 9
    //   6017: istore 10
    //   6019: iload_1
    //   6020: istore 14
    //   6022: aload 20
    //   6024: astore 31
    //   6026: iload 6
    //   6028: istore 4
    //   6030: iload 15
    //   6032: istore 18
    //   6034: iload 16
    //   6036: istore 17
    //   6038: goto -4766 -> 1272
    //   6041: iconst_0
    //   6042: istore 5
    //   6044: iload 9
    //   6046: istore 10
    //   6048: iload_1
    //   6049: istore 14
    //   6051: aload 20
    //   6053: astore 31
    //   6055: iload 5
    //   6057: istore 4
    //   6059: iload 15
    //   6061: istore 18
    //   6063: iload 16
    //   6065: istore 17
    //   6067: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   6070: invokevirtual 198	java/io/File:exists	()Z
    //   6073: ifeq -4801 -> 1272
    //   6076: ldc_w 445
    //   6079: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6082: new 174	java/lang/StringBuilder
    //   6085: dup
    //   6086: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   6089: ldc_w 627
    //   6092: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6095: aload 33
    //   6097: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6100: ldc_w 629
    //   6103: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6106: aload 19
    //   6108: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6111: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6114: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6117: ldc_w 449
    //   6120: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6123: iconst_3
    //   6124: anewarray 283	java/lang/String
    //   6127: dup
    //   6128: iconst_0
    //   6129: ldc_w 427
    //   6132: aastore
    //   6133: dup
    //   6134: iconst_1
    //   6135: new 174	java/lang/StringBuilder
    //   6138: dup
    //   6139: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   6142: ldc -124
    //   6144: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6147: aload 33
    //   6149: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6152: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6155: aastore
    //   6156: dup
    //   6157: iconst_2
    //   6158: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   6161: invokevirtual 443	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6164: aastore
    //   6165: invokestatic 432	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   6168: iload 9
    //   6170: istore 10
    //   6172: iload_1
    //   6173: istore 14
    //   6175: aload 20
    //   6177: astore 31
    //   6179: iload 5
    //   6181: istore 4
    //   6183: iload 15
    //   6185: istore 18
    //   6187: iload 16
    //   6189: istore 17
    //   6191: goto -4919 -> 1272
    //   6194: iconst_0
    //   6195: istore 10
    //   6197: aload 19
    //   6199: ifnull +204 -> 6403
    //   6202: new 190	java/io/File
    //   6205: dup
    //   6206: aload 19
    //   6208: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   6211: invokevirtual 198	java/io/File:exists	()Z
    //   6214: ifeq +189 -> 6403
    //   6217: aload 19
    //   6219: astore 22
    //   6221: new 190	java/io/File
    //   6224: dup
    //   6225: aload 27
    //   6227: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   6230: invokestatic 633	com/chelpus/Utils:getDirs	(Ljava/io/File;)Ljava/io/File;
    //   6233: astore 31
    //   6235: aload 31
    //   6237: invokevirtual 636	java/io/File:mkdirs	()Z
    //   6240: pop
    //   6241: iconst_3
    //   6242: anewarray 283	java/lang/String
    //   6245: dup
    //   6246: iconst_0
    //   6247: ldc_w 427
    //   6250: aastore
    //   6251: dup
    //   6252: iconst_1
    //   6253: ldc_w 429
    //   6256: aastore
    //   6257: dup
    //   6258: iconst_2
    //   6259: aload 31
    //   6261: invokevirtual 443	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6264: aastore
    //   6265: invokestatic 432	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   6268: aload 31
    //   6270: invokevirtual 443	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6273: pop
    //   6274: ldc_w 445
    //   6277: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6280: new 174	java/lang/StringBuilder
    //   6283: dup
    //   6284: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   6287: ldc_w 638
    //   6290: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6293: aload 19
    //   6295: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6298: ldc_w 640
    //   6301: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6304: aload 27
    //   6306: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6309: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6312: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6315: ldc_w 449
    //   6318: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6321: new 190	java/io/File
    //   6324: dup
    //   6325: aload 22
    //   6327: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   6330: invokevirtual 198	java/io/File:exists	()Z
    //   6333: ifne +101 -> 6434
    //   6336: new 174	java/lang/StringBuilder
    //   6339: dup
    //   6340: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   6343: ldc_w 642
    //   6346: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6349: aload 19
    //   6351: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6354: ldc_w 644
    //   6357: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6360: new 190	java/io/File
    //   6363: dup
    //   6364: aload 22
    //   6366: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   6369: invokestatic 633	com/chelpus/Utils:getDirs	(Ljava/io/File;)Ljava/io/File;
    //   6372: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6375: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6378: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6381: iload_1
    //   6382: istore 14
    //   6384: aload 20
    //   6386: astore 31
    //   6388: iload 6
    //   6390: istore 4
    //   6392: iload 15
    //   6394: istore 18
    //   6396: iload 16
    //   6398: istore 17
    //   6400: goto -5128 -> 1272
    //   6403: new 174	java/lang/StringBuilder
    //   6406: dup
    //   6407: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   6410: getstatic 130	com/chelpus/root/utils/custompatch:sddir	Ljava/lang/String;
    //   6413: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6416: ldc -36
    //   6418: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6421: aload 19
    //   6423: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6426: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6429: astore 22
    //   6431: goto -210 -> 6221
    //   6434: new 190	java/io/File
    //   6437: dup
    //   6438: aload 22
    //   6440: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   6443: new 190	java/io/File
    //   6446: dup
    //   6447: aload 27
    //   6449: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   6452: invokestatic 436	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   6455: new 190	java/io/File
    //   6458: dup
    //   6459: aload 27
    //   6461: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   6464: invokevirtual 198	java/io/File:exists	()Z
    //   6467: ifeq +107 -> 6574
    //   6470: new 190	java/io/File
    //   6473: dup
    //   6474: aload 27
    //   6476: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   6479: invokevirtual 625	java/io/File:length	()J
    //   6482: new 190	java/io/File
    //   6485: dup
    //   6486: new 174	java/lang/StringBuilder
    //   6489: dup
    //   6490: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   6493: getstatic 130	com/chelpus/root/utils/custompatch:sddir	Ljava/lang/String;
    //   6496: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6499: ldc -36
    //   6501: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6504: aload 19
    //   6506: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6509: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6512: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   6515: invokevirtual 625	java/io/File:length	()J
    //   6518: lcmp
    //   6519: ifne +55 -> 6574
    //   6522: ldc_w 646
    //   6525: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6528: iconst_3
    //   6529: anewarray 283	java/lang/String
    //   6532: dup
    //   6533: iconst_0
    //   6534: ldc_w 427
    //   6537: aastore
    //   6538: dup
    //   6539: iconst_1
    //   6540: ldc_w 429
    //   6543: aastore
    //   6544: dup
    //   6545: iconst_2
    //   6546: aload 27
    //   6548: aastore
    //   6549: invokestatic 432	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   6552: iload_1
    //   6553: istore 14
    //   6555: aload 20
    //   6557: astore 31
    //   6559: iload 6
    //   6561: istore 4
    //   6563: iload 15
    //   6565: istore 18
    //   6567: iload 16
    //   6569: istore 17
    //   6571: goto -5299 -> 1272
    //   6574: ldc_w 648
    //   6577: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6580: goto -52 -> 6528
    //   6583: ldc_w 445
    //   6586: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6589: ldc_w 650
    //   6592: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6595: ldc_w 449
    //   6598: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6601: ldc_w 652
    //   6604: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6607: iload 9
    //   6609: istore 10
    //   6611: iload_1
    //   6612: istore 14
    //   6614: aload 20
    //   6616: astore 31
    //   6618: iload 6
    //   6620: istore 4
    //   6622: iload 15
    //   6624: istore 18
    //   6626: iload 16
    //   6628: istore 17
    //   6630: goto -5358 -> 1272
    //   6633: ldc_w 654
    //   6636: astore 22
    //   6638: goto -4908 -> 1730
    //   6641: aload 22
    //   6643: astore 21
    //   6645: iconst_1
    //   6646: putstatic 148	com/chelpus/root/utils/custompatch:dataBaseExist	Z
    //   6649: goto -4919 -> 1730
    //   6652: astore 20
    //   6654: ldc_w 656
    //   6657: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6660: aload 21
    //   6662: astore 22
    //   6664: goto -4861 -> 1803
    //   6667: astore 22
    //   6669: aload 21
    //   6671: astore 20
    //   6673: getstatic 662	java/lang/System:out	Ljava/io/PrintStream;
    //   6676: new 174	java/lang/StringBuilder
    //   6679: dup
    //   6680: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   6683: ldc_w 664
    //   6686: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6689: aload 22
    //   6691: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6694: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6697: invokevirtual 669	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   6700: aload 21
    //   6702: astore 20
    //   6704: goto -4761 -> 1943
    //   6707: astore 21
    //   6709: ldc_w 671
    //   6712: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6715: goto -4772 -> 1943
    //   6718: astore 21
    //   6720: ldc_w 673
    //   6723: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6726: goto -4680 -> 2046
    //   6729: astore 20
    //   6731: aload 20
    //   6733: invokevirtual 674	org/json/JSONException:printStackTrace	()V
    //   6736: ldc_w 673
    //   6739: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6742: goto -4622 -> 2120
    //   6745: astore 19
    //   6747: ldc_w 676
    //   6750: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6753: aload 22
    //   6755: astore 20
    //   6757: aload 33
    //   6759: astore 32
    //   6761: goto -4513 -> 2248
    //   6764: astore 19
    //   6766: aload 19
    //   6768: invokevirtual 674	org/json/JSONException:printStackTrace	()V
    //   6771: ldc_w 673
    //   6774: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6777: aload 20
    //   6779: astore 19
    //   6781: goto -4478 -> 2303
    //   6784: astore 20
    //   6786: ldc_w 678
    //   6789: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6792: aload 19
    //   6794: astore 22
    //   6796: aload 27
    //   6798: astore 33
    //   6800: goto -4381 -> 2419
    //   6803: astore 19
    //   6805: ldc_w 680
    //   6808: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6811: aload 21
    //   6813: astore 19
    //   6815: goto -4351 -> 2464
    //   6818: sipush 200
    //   6821: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   6824: iload 7
    //   6826: istore 10
    //   6828: iload 9
    //   6830: istore 8
    //   6832: iload 11
    //   6834: istore 6
    //   6836: iload 4
    //   6838: istore_1
    //   6839: goto -4213 -> 2626
    //   6842: sipush 200
    //   6845: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   6848: iload 10
    //   6850: istore 11
    //   6852: iload 8
    //   6854: istore 9
    //   6856: iload 6
    //   6858: istore 7
    //   6860: iload_1
    //   6861: istore 4
    //   6863: goto -4164 -> 2699
    //   6866: sipush 200
    //   6869: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   6872: iload 11
    //   6874: istore 10
    //   6876: iload 9
    //   6878: istore 8
    //   6880: iload 7
    //   6882: istore 6
    //   6884: iload 4
    //   6886: istore_1
    //   6887: goto -4116 -> 2771
    //   6890: sipush 200
    //   6893: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   6896: iload 10
    //   6898: istore 11
    //   6900: iload 8
    //   6902: istore 9
    //   6904: iload 6
    //   6906: istore 7
    //   6908: iload_1
    //   6909: istore 4
    //   6911: goto -4067 -> 2844
    //   6914: astore 20
    //   6916: ldc_w 682
    //   6919: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6922: ldc -124
    //   6924: putstatic 154	com/chelpus/root/utils/custompatch:group	Ljava/lang/String;
    //   6927: goto -3795 -> 3132
    //   6930: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   6933: invokestatic 519	com/chelpus/root/utils/custompatch:searchProcess	(Ljava/util/ArrayList;)Z
    //   6936: istore 15
    //   6938: iconst_0
    //   6939: istore 4
    //   6941: goto -3629 -> 3312
    //   6944: astore 20
    //   6946: ldc_w 682
    //   6949: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6952: goto -3616 -> 3336
    //   6955: aload 25
    //   6957: iload 11
    //   6959: iconst_0
    //   6960: iastore
    //   6961: goto -3447 -> 3514
    //   6964: astore 20
    //   6966: new 174	java/lang/StringBuilder
    //   6969: dup
    //   6970: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   6973: ldc_w 684
    //   6976: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6979: aload 20
    //   6981: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6984: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6987: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   6990: aload 19
    //   6992: astore 21
    //   6994: iload 15
    //   6996: istore 16
    //   6998: iload 4
    //   7000: istore 10
    //   7002: iload_3
    //   7003: istore_1
    //   7004: aload 25
    //   7006: astore 27
    //   7008: aload 26
    //   7010: astore 20
    //   7012: iload 16
    //   7014: istore 17
    //   7016: aload 24
    //   7018: astore 19
    //   7020: aload 38
    //   7022: iload 12
    //   7024: aaload
    //   7025: ldc_w 686
    //   7028: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7031: ifeq +229 -> 7260
    //   7034: iload 16
    //   7036: istore 17
    //   7038: aload 24
    //   7040: astore 19
    //   7042: aload 38
    //   7044: iload 12
    //   7046: aaload
    //   7047: ldc_w 403
    //   7050: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7053: ifeq +207 -> 7260
    //   7056: aload 38
    //   7058: iload 12
    //   7060: aaload
    //   7061: ldc_w 513
    //   7064: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7067: istore 15
    //   7069: iload 16
    //   7071: istore 17
    //   7073: aload 24
    //   7075: astore 19
    //   7077: iload 15
    //   7079: ifeq +181 -> 7260
    //   7082: new 420	org/json/JSONObject
    //   7085: dup
    //   7086: aload 38
    //   7088: iload 12
    //   7090: aaload
    //   7091: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7094: ldc_w 688
    //   7097: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7100: astore 19
    //   7102: new 174	java/lang/StringBuilder
    //   7105: dup
    //   7106: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   7109: ldc_w 690
    //   7112: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7115: aload_0
    //   7116: iconst_5
    //   7117: aaload
    //   7118: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7121: ldc_w 684
    //   7124: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7127: aload_0
    //   7128: bipush 8
    //   7130: aaload
    //   7131: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7134: ldc_w 692
    //   7137: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7140: aload_0
    //   7141: iconst_0
    //   7142: aaload
    //   7143: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7146: ldc_w 684
    //   7149: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7152: ldc_w 688
    //   7155: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7158: aload 19
    //   7160: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7163: ldc -75
    //   7165: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7168: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7171: astore 24
    //   7173: invokestatic 698	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   7176: aload 24
    //   7178: invokevirtual 702	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   7181: astore 24
    //   7183: aload 24
    //   7185: invokevirtual 707	java/lang/Process:waitFor	()I
    //   7188: pop
    //   7189: new 709	java/io/DataInputStream
    //   7192: dup
    //   7193: aload 24
    //   7195: invokevirtual 713	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   7198: invokespecial 716	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   7201: astore 25
    //   7203: aload 25
    //   7205: invokevirtual 719	java/io/DataInputStream:available	()I
    //   7208: newarray <illegal type>
    //   7210: astore 26
    //   7212: aload 25
    //   7214: aload 26
    //   7216: invokevirtual 723	java/io/DataInputStream:read	([B)I
    //   7219: pop
    //   7220: new 283	java/lang/String
    //   7223: dup
    //   7224: aload 26
    //   7226: invokespecial 726	java/lang/String:<init>	([B)V
    //   7229: astore 25
    //   7231: aload 24
    //   7233: invokevirtual 729	java/lang/Process:destroy	()V
    //   7236: aload 25
    //   7238: ldc_w 731
    //   7241: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7244: ifeq +408 -> 7652
    //   7247: ldc_w 733
    //   7250: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   7253: iconst_1
    //   7254: istore 17
    //   7256: iconst_1
    //   7257: putstatic 116	com/chelpus/root/utils/custompatch:manualpatch	Z
    //   7260: aload 20
    //   7262: astore 25
    //   7264: aload 27
    //   7266: astore 26
    //   7268: iload_1
    //   7269: istore_2
    //   7270: iload 10
    //   7272: istore_3
    //   7273: iload 18
    //   7275: istore 16
    //   7277: aload 19
    //   7279: astore 24
    //   7281: aload 38
    //   7283: iload 12
    //   7285: aaload
    //   7286: ldc_w 734
    //   7289: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7292: ifeq +436 -> 7728
    //   7295: aload 20
    //   7297: astore 25
    //   7299: aload 27
    //   7301: astore 26
    //   7303: iload_1
    //   7304: istore_2
    //   7305: iload 10
    //   7307: istore_3
    //   7308: iload 18
    //   7310: istore 16
    //   7312: aload 19
    //   7314: astore 24
    //   7316: aload 38
    //   7318: iload 12
    //   7320: aaload
    //   7321: ldc_w 403
    //   7324: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7327: ifeq +401 -> 7728
    //   7330: aload 38
    //   7332: iload 12
    //   7334: aaload
    //   7335: ldc_w 513
    //   7338: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7341: istore 15
    //   7343: aload 20
    //   7345: astore 25
    //   7347: aload 27
    //   7349: astore 26
    //   7351: iload_1
    //   7352: istore_2
    //   7353: iload 10
    //   7355: istore_3
    //   7356: iload 18
    //   7358: istore 16
    //   7360: aload 19
    //   7362: astore 24
    //   7364: iload 15
    //   7366: ifeq +362 -> 7728
    //   7369: new 420	org/json/JSONObject
    //   7372: dup
    //   7373: aload 38
    //   7375: iload 12
    //   7377: aaload
    //   7378: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7381: ldc_w 734
    //   7384: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7387: astore 20
    //   7389: aload 20
    //   7391: astore 19
    //   7393: aload 19
    //   7395: invokevirtual 522	java/lang/String:trim	()Ljava/lang/String;
    //   7398: astore 19
    //   7400: aload 19
    //   7402: astore 24
    //   7404: getstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   7407: ifeq +10 -> 7417
    //   7410: aload 19
    //   7412: invokestatic 525	com/chelpus/Utils:rework	(Ljava/lang/String;)Ljava/lang/String;
    //   7415: astore 24
    //   7417: aload 24
    //   7419: ldc_w 527
    //   7422: invokevirtual 531	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   7425: arraylength
    //   7426: anewarray 283	java/lang/String
    //   7429: astore 19
    //   7431: aload 24
    //   7433: ldc_w 527
    //   7436: invokevirtual 531	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   7439: astore 19
    //   7441: aload 19
    //   7443: arraylength
    //   7444: newarray <illegal type>
    //   7446: astore 26
    //   7448: aload 19
    //   7450: arraylength
    //   7451: newarray <illegal type>
    //   7453: astore 25
    //   7455: iconst_0
    //   7456: istore 4
    //   7458: iload_1
    //   7459: istore_3
    //   7460: iload_1
    //   7461: istore_2
    //   7462: iload 4
    //   7464: aload 19
    //   7466: arraylength
    //   7467: if_icmpge +245 -> 7712
    //   7470: iload_1
    //   7471: istore_2
    //   7472: iload_1
    //   7473: istore_3
    //   7474: aload 19
    //   7476: iload 4
    //   7478: aaload
    //   7479: ldc_w 533
    //   7482: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7485: ifeq +31 -> 7516
    //   7488: iload_1
    //   7489: istore_2
    //   7490: iload_1
    //   7491: istore_3
    //   7492: aload 19
    //   7494: iload 4
    //   7496: aaload
    //   7497: ldc_w 535
    //   7500: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7503: ifne +13 -> 7516
    //   7506: iconst_1
    //   7507: istore_2
    //   7508: aload 19
    //   7510: iload 4
    //   7512: ldc_w 537
    //   7515: aastore
    //   7516: iload_2
    //   7517: istore_3
    //   7518: aload 19
    //   7520: iload 4
    //   7522: aaload
    //   7523: ldc_w 535
    //   7526: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7529: ifne +2345 -> 9874
    //   7532: iload_2
    //   7533: istore_3
    //   7534: aload 19
    //   7536: iload 4
    //   7538: aaload
    //   7539: ldc_w 539
    //   7542: invokevirtual 542	java/lang/String:matches	(Ljava/lang/String;)Z
    //   7545: ifeq +130 -> 7675
    //   7548: goto +2326 -> 9874
    //   7551: iload_2
    //   7552: istore_3
    //   7553: aload 19
    //   7555: iload 4
    //   7557: aaload
    //   7558: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   7561: ldc_w 548
    //   7564: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7567: ifeq +39 -> 7606
    //   7570: iload_2
    //   7571: istore_3
    //   7572: aload 26
    //   7574: iload 4
    //   7576: aload 19
    //   7578: iload 4
    //   7580: aaload
    //   7581: ldc_w 548
    //   7584: ldc -124
    //   7586: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   7589: invokestatic 555	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   7592: invokevirtual 558	java/lang/Integer:intValue	()I
    //   7595: iconst_2
    //   7596: iadd
    //   7597: iastore
    //   7598: aload 19
    //   7600: iload 4
    //   7602: ldc_w 537
    //   7605: aastore
    //   7606: iload_2
    //   7607: istore_3
    //   7608: aload 25
    //   7610: iload 4
    //   7612: aload 19
    //   7614: iload 4
    //   7616: aaload
    //   7617: bipush 16
    //   7619: invokestatic 561	java/lang/Integer:valueOf	(Ljava/lang/String;I)Ljava/lang/Integer;
    //   7622: invokevirtual 565	java/lang/Integer:byteValue	()B
    //   7625: bastore
    //   7626: iload 4
    //   7628: iconst_1
    //   7629: iadd
    //   7630: istore 4
    //   7632: iload_2
    //   7633: istore_1
    //   7634: goto -176 -> 7458
    //   7637: astore 19
    //   7639: ldc_w 736
    //   7642: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   7645: aload 24
    //   7647: astore 19
    //   7649: goto -547 -> 7102
    //   7652: ldc_w 738
    //   7655: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   7658: iconst_0
    //   7659: istore 17
    //   7661: goto -405 -> 7256
    //   7664: astore 20
    //   7666: ldc_w 740
    //   7669: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   7672: goto -279 -> 7393
    //   7675: aload 26
    //   7677: iload 4
    //   7679: iconst_0
    //   7680: iastore
    //   7681: goto -130 -> 7551
    //   7684: astore 19
    //   7686: new 174	java/lang/StringBuilder
    //   7689: dup
    //   7690: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   7693: ldc_w 684
    //   7696: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7699: aload 19
    //   7701: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7704: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7707: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   7710: iload_3
    //   7711: istore_2
    //   7712: iload_2
    //   7713: ifeq +532 -> 8245
    //   7716: iconst_0
    //   7717: istore 16
    //   7719: ldc_w 742
    //   7722: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   7725: iload 10
    //   7727: istore_3
    //   7728: iload_2
    //   7729: istore_1
    //   7730: iload 16
    //   7732: istore 15
    //   7734: aload 23
    //   7736: astore 19
    //   7738: aload 38
    //   7740: iload 12
    //   7742: aaload
    //   7743: ldc_w 744
    //   7746: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7749: ifeq +745 -> 8494
    //   7752: iload_2
    //   7753: istore_1
    //   7754: iload 16
    //   7756: istore 15
    //   7758: aload 23
    //   7760: astore 19
    //   7762: aload 38
    //   7764: iload 12
    //   7766: aaload
    //   7767: ldc_w 403
    //   7770: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7773: ifeq +721 -> 8494
    //   7776: aload 38
    //   7778: iload 12
    //   7780: aaload
    //   7781: ldc_w 513
    //   7784: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7787: istore 18
    //   7789: iload_2
    //   7790: istore_1
    //   7791: iload 16
    //   7793: istore 15
    //   7795: aload 23
    //   7797: astore 19
    //   7799: iload 18
    //   7801: ifeq +693 -> 8494
    //   7804: new 420	org/json/JSONObject
    //   7807: dup
    //   7808: aload 38
    //   7810: iload 12
    //   7812: aaload
    //   7813: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7816: ldc_w 744
    //   7819: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7822: astore 19
    //   7824: aload 19
    //   7826: invokevirtual 522	java/lang/String:trim	()Ljava/lang/String;
    //   7829: astore 19
    //   7831: aload 19
    //   7833: astore 20
    //   7835: getstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   7838: ifeq +10 -> 7848
    //   7841: aload 19
    //   7843: invokestatic 525	com/chelpus/Utils:rework	(Ljava/lang/String;)Ljava/lang/String;
    //   7846: astore 20
    //   7848: aload 20
    //   7850: ldc_w 527
    //   7853: invokevirtual 531	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   7856: arraylength
    //   7857: anewarray 283	java/lang/String
    //   7860: astore 19
    //   7862: aload 20
    //   7864: ldc_w 527
    //   7867: invokevirtual 531	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   7870: astore 19
    //   7872: aload 19
    //   7874: arraylength
    //   7875: newarray <illegal type>
    //   7877: astore 23
    //   7879: aload 19
    //   7881: arraylength
    //   7882: newarray <illegal type>
    //   7884: astore 27
    //   7886: iconst_0
    //   7887: istore 10
    //   7889: iload_2
    //   7890: istore 4
    //   7892: iload_2
    //   7893: istore_1
    //   7894: iload 10
    //   7896: aload 19
    //   7898: arraylength
    //   7899: if_icmpge +478 -> 8377
    //   7902: iload_2
    //   7903: istore_1
    //   7904: iload_2
    //   7905: istore 4
    //   7907: aload 19
    //   7909: iload 10
    //   7911: aaload
    //   7912: ldc_w 533
    //   7915: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7918: ifeq +32 -> 7950
    //   7921: iload_2
    //   7922: istore_1
    //   7923: iload_2
    //   7924: istore 4
    //   7926: aload 19
    //   7928: iload 10
    //   7930: aaload
    //   7931: ldc_w 535
    //   7934: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7937: ifne +13 -> 7950
    //   7940: iconst_1
    //   7941: istore_1
    //   7942: aload 19
    //   7944: iload 10
    //   7946: ldc_w 537
    //   7949: aastore
    //   7950: iload_1
    //   7951: istore 4
    //   7953: aload 19
    //   7955: iload 10
    //   7957: aaload
    //   7958: ldc_w 535
    //   7961: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7964: ifne +1927 -> 9891
    //   7967: iload_1
    //   7968: istore 4
    //   7970: aload 19
    //   7972: iload 10
    //   7974: aaload
    //   7975: ldc_w 539
    //   7978: invokevirtual 542	java/lang/String:matches	(Ljava/lang/String;)Z
    //   7981: ifeq +358 -> 8339
    //   7984: goto +1907 -> 9891
    //   7987: iload_1
    //   7988: istore 4
    //   7990: aload 19
    //   7992: iload 10
    //   7994: aaload
    //   7995: invokevirtual 490	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   7998: ldc_w 746
    //   8001: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8004: ifeq +19 -> 8023
    //   8007: aload 19
    //   8009: iload 10
    //   8011: ldc_w 537
    //   8014: aastore
    //   8015: aload 23
    //   8017: iload 10
    //   8019: sipush 253
    //   8022: iastore
    //   8023: iload_1
    //   8024: istore 4
    //   8026: aload 19
    //   8028: iload 10
    //   8030: aaload
    //   8031: ldc_w 748
    //   8034: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8037: ifne +1871 -> 9908
    //   8040: iload_1
    //   8041: istore 4
    //   8043: aload 19
    //   8045: iload 10
    //   8047: aaload
    //   8048: ldc_w 750
    //   8051: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8054: ifeq +6 -> 8060
    //   8057: goto +1851 -> 9908
    //   8060: iload_1
    //   8061: istore 4
    //   8063: aload 19
    //   8065: iload 10
    //   8067: aaload
    //   8068: ldc_w 752
    //   8071: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8074: ifne +1853 -> 9927
    //   8077: iload_1
    //   8078: istore 4
    //   8080: aload 19
    //   8082: iload 10
    //   8084: aaload
    //   8085: ldc_w 754
    //   8088: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8091: ifeq +6 -> 8097
    //   8094: goto +1833 -> 9927
    //   8097: iload_1
    //   8098: istore 4
    //   8100: aload 19
    //   8102: iload 10
    //   8104: aaload
    //   8105: ldc_w 544
    //   8108: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8111: ifne +54 -> 8165
    //   8114: iload_1
    //   8115: istore 4
    //   8117: aload 19
    //   8119: iload 10
    //   8121: aaload
    //   8122: ldc_w 546
    //   8125: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8128: ifne +37 -> 8165
    //   8131: iload_1
    //   8132: istore 4
    //   8134: aload 19
    //   8136: iload 10
    //   8138: aaload
    //   8139: ldc_w 548
    //   8142: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8145: ifne +20 -> 8165
    //   8148: iload_1
    //   8149: istore 4
    //   8151: aload 19
    //   8153: iload 10
    //   8155: aaload
    //   8156: ldc_w 548
    //   8159: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8162: ifeq +51 -> 8213
    //   8165: iload_1
    //   8166: istore 4
    //   8168: aload 23
    //   8170: iload 10
    //   8172: aload 19
    //   8174: iload 10
    //   8176: aaload
    //   8177: invokevirtual 490	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   8180: ldc_w 546
    //   8183: ldc -124
    //   8185: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8188: ldc_w 550
    //   8191: ldc -124
    //   8193: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8196: invokestatic 555	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   8199: invokevirtual 558	java/lang/Integer:intValue	()I
    //   8202: iconst_2
    //   8203: iadd
    //   8204: iastore
    //   8205: aload 19
    //   8207: iload 10
    //   8209: ldc_w 537
    //   8212: aastore
    //   8213: iload_1
    //   8214: istore 4
    //   8216: aload 27
    //   8218: iload 10
    //   8220: aload 19
    //   8222: iload 10
    //   8224: aaload
    //   8225: bipush 16
    //   8227: invokestatic 561	java/lang/Integer:valueOf	(Ljava/lang/String;I)Ljava/lang/Integer;
    //   8230: invokevirtual 565	java/lang/Integer:byteValue	()B
    //   8233: bastore
    //   8234: iload 10
    //   8236: iconst_1
    //   8237: iadd
    //   8238: istore 10
    //   8240: iload_1
    //   8241: istore_2
    //   8242: goto -353 -> 7889
    //   8245: iconst_1
    //   8246: istore_3
    //   8247: new 756	com/android/vending/billing/InAppBillingService/LACK/SearchItem
    //   8250: dup
    //   8251: aload 25
    //   8253: aload 26
    //   8255: invokespecial 759	com/android/vending/billing/InAppBillingService/LACK/SearchItem:<init>	([B[I)V
    //   8258: astore 19
    //   8260: aload 19
    //   8262: aload 25
    //   8264: arraylength
    //   8265: newarray <illegal type>
    //   8267: putfield 762	com/android/vending/billing/InAppBillingService/LACK/SearchItem:repByte	[B
    //   8270: getstatic 106	com/chelpus/root/utils/custompatch:ser	Ljava/util/ArrayList;
    //   8273: aload 19
    //   8275: invokevirtual 765	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   8278: pop
    //   8279: iload 18
    //   8281: istore 16
    //   8283: goto -555 -> 7728
    //   8286: astore 19
    //   8288: aload 19
    //   8290: invokevirtual 309	java/lang/Exception:printStackTrace	()V
    //   8293: new 174	java/lang/StringBuilder
    //   8296: dup
    //   8297: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   8300: ldc_w 684
    //   8303: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8306: aload 19
    //   8308: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8311: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8314: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   8317: iload 18
    //   8319: istore 16
    //   8321: goto -593 -> 7728
    //   8324: astore 19
    //   8326: ldc_w 767
    //   8329: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   8332: aload 23
    //   8334: astore 19
    //   8336: goto -512 -> 7824
    //   8339: aload 23
    //   8341: iload 10
    //   8343: iconst_1
    //   8344: iastore
    //   8345: goto -358 -> 7987
    //   8348: astore 19
    //   8350: new 174	java/lang/StringBuilder
    //   8353: dup
    //   8354: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   8357: ldc_w 684
    //   8360: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8363: aload 19
    //   8365: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8368: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8371: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   8374: iload 4
    //   8376: istore_1
    //   8377: aload 23
    //   8379: arraylength
    //   8380: aload 26
    //   8382: arraylength
    //   8383: if_icmpne +1563 -> 9946
    //   8386: aload 25
    //   8388: arraylength
    //   8389: aload 27
    //   8391: arraylength
    //   8392: if_icmpne +1554 -> 9946
    //   8395: aload 27
    //   8397: arraylength
    //   8398: iconst_4
    //   8399: if_icmplt +1547 -> 9946
    //   8402: iload_1
    //   8403: istore_2
    //   8404: aload 25
    //   8406: arraylength
    //   8407: iconst_4
    //   8408: if_icmpge +6 -> 8414
    //   8411: goto +1535 -> 9946
    //   8414: iload_2
    //   8415: ifeq +12 -> 8427
    //   8418: iconst_0
    //   8419: istore 16
    //   8421: ldc_w 769
    //   8424: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   8427: iload_2
    //   8428: istore_1
    //   8429: iload 16
    //   8431: istore 15
    //   8433: aload 20
    //   8435: astore 19
    //   8437: iload_2
    //   8438: ifne +56 -> 8494
    //   8441: getstatic 168	com/chelpus/root/utils/custompatch:multilib_patch	Z
    //   8444: ifne +9 -> 8453
    //   8447: getstatic 164	com/chelpus/root/utils/custompatch:multidex	Z
    //   8450: ifeq +565 -> 9015
    //   8453: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   8456: new 771	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   8459: dup
    //   8460: aload 25
    //   8462: aload 26
    //   8464: aload 27
    //   8466: aload 23
    //   8468: ldc_w 773
    //   8471: iconst_0
    //   8472: invokespecial 776	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:<init>	([B[I[B[ILjava/lang/String;Z)V
    //   8475: invokevirtual 765	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   8478: pop
    //   8479: ldc -124
    //   8481: putstatic 154	com/chelpus/root/utils/custompatch:group	Ljava/lang/String;
    //   8484: aload 20
    //   8486: astore 19
    //   8488: iload 16
    //   8490: istore 15
    //   8492: iload_2
    //   8493: istore_1
    //   8494: iload_1
    //   8495: istore_2
    //   8496: iload 15
    //   8498: istore 16
    //   8500: aload 19
    //   8502: astore 20
    //   8504: aload 38
    //   8506: iload 12
    //   8508: aaload
    //   8509: ldc_w 778
    //   8512: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8515: ifeq +665 -> 9180
    //   8518: iload_1
    //   8519: istore_2
    //   8520: iload 15
    //   8522: istore 16
    //   8524: aload 19
    //   8526: astore 20
    //   8528: aload 38
    //   8530: iload 12
    //   8532: aaload
    //   8533: ldc_w 403
    //   8536: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8539: ifeq +641 -> 9180
    //   8542: aload 38
    //   8544: iload 12
    //   8546: aaload
    //   8547: ldc_w 513
    //   8550: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8553: istore 18
    //   8555: iload_1
    //   8556: istore_2
    //   8557: iload 15
    //   8559: istore 16
    //   8561: aload 19
    //   8563: astore 20
    //   8565: iload 18
    //   8567: ifeq +613 -> 9180
    //   8570: new 420	org/json/JSONObject
    //   8573: dup
    //   8574: aload 38
    //   8576: iload 12
    //   8578: aaload
    //   8579: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8582: ldc_w 778
    //   8585: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8588: astore 20
    //   8590: aload 20
    //   8592: astore 19
    //   8594: aload 19
    //   8596: invokevirtual 522	java/lang/String:trim	()Ljava/lang/String;
    //   8599: astore 20
    //   8601: aload 20
    //   8603: astore 19
    //   8605: getstatic 146	com/chelpus/root/utils/custompatch:convert	Z
    //   8608: ifeq +10 -> 8618
    //   8611: aload 20
    //   8613: invokestatic 525	com/chelpus/Utils:rework	(Ljava/lang/String;)Ljava/lang/String;
    //   8616: astore 19
    //   8618: aload 19
    //   8620: ldc_w 527
    //   8623: invokevirtual 531	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8626: arraylength
    //   8627: anewarray 283	java/lang/String
    //   8630: astore 20
    //   8632: aload 19
    //   8634: ldc_w 527
    //   8637: invokevirtual 531	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8640: astore 20
    //   8642: aload 20
    //   8644: arraylength
    //   8645: newarray <illegal type>
    //   8647: astore 23
    //   8649: aload 20
    //   8651: arraylength
    //   8652: newarray <illegal type>
    //   8654: astore 27
    //   8656: iconst_0
    //   8657: istore 10
    //   8659: iload_1
    //   8660: istore 4
    //   8662: iload_1
    //   8663: istore_2
    //   8664: iload 10
    //   8666: aload 20
    //   8668: arraylength
    //   8669: if_icmpge +424 -> 9093
    //   8672: iload_1
    //   8673: istore_2
    //   8674: iload_1
    //   8675: istore 4
    //   8677: aload 20
    //   8679: iload 10
    //   8681: aaload
    //   8682: ldc_w 533
    //   8685: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8688: ifeq +32 -> 8720
    //   8691: iload_1
    //   8692: istore_2
    //   8693: iload_1
    //   8694: istore 4
    //   8696: aload 20
    //   8698: iload 10
    //   8700: aaload
    //   8701: ldc_w 535
    //   8704: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8707: ifne +13 -> 8720
    //   8710: iconst_1
    //   8711: istore_2
    //   8712: aload 20
    //   8714: iload 10
    //   8716: ldc_w 537
    //   8719: aastore
    //   8720: iload_2
    //   8721: istore 4
    //   8723: aload 20
    //   8725: iload 10
    //   8727: aaload
    //   8728: ldc_w 535
    //   8731: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8734: ifne +1217 -> 9951
    //   8737: iload_2
    //   8738: istore 4
    //   8740: aload 20
    //   8742: iload 10
    //   8744: aaload
    //   8745: ldc_w 539
    //   8748: invokevirtual 542	java/lang/String:matches	(Ljava/lang/String;)Z
    //   8751: ifeq +304 -> 9055
    //   8754: goto +1197 -> 9951
    //   8757: iload_2
    //   8758: istore 4
    //   8760: aload 20
    //   8762: iload 10
    //   8764: aaload
    //   8765: invokevirtual 490	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   8768: ldc_w 746
    //   8771: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8774: ifeq +19 -> 8793
    //   8777: aload 20
    //   8779: iload 10
    //   8781: ldc_w 537
    //   8784: aastore
    //   8785: aload 23
    //   8787: iload 10
    //   8789: sipush 253
    //   8792: iastore
    //   8793: iload_2
    //   8794: istore 4
    //   8796: aload 20
    //   8798: iload 10
    //   8800: aaload
    //   8801: ldc_w 748
    //   8804: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8807: ifne +1161 -> 9968
    //   8810: iload_2
    //   8811: istore 4
    //   8813: aload 20
    //   8815: iload 10
    //   8817: aaload
    //   8818: ldc_w 750
    //   8821: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8824: ifeq +6 -> 8830
    //   8827: goto +1141 -> 9968
    //   8830: iload_2
    //   8831: istore 4
    //   8833: aload 20
    //   8835: iload 10
    //   8837: aaload
    //   8838: ldc_w 752
    //   8841: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8844: ifne +1143 -> 9987
    //   8847: iload_2
    //   8848: istore 4
    //   8850: aload 20
    //   8852: iload 10
    //   8854: aaload
    //   8855: ldc_w 754
    //   8858: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8861: ifeq +6 -> 8867
    //   8864: goto +1123 -> 9987
    //   8867: iload_2
    //   8868: istore 4
    //   8870: aload 20
    //   8872: iload 10
    //   8874: aaload
    //   8875: ldc_w 544
    //   8878: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8881: ifne +54 -> 8935
    //   8884: iload_2
    //   8885: istore 4
    //   8887: aload 20
    //   8889: iload 10
    //   8891: aaload
    //   8892: ldc_w 546
    //   8895: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8898: ifne +37 -> 8935
    //   8901: iload_2
    //   8902: istore 4
    //   8904: aload 20
    //   8906: iload 10
    //   8908: aaload
    //   8909: ldc_w 548
    //   8912: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8915: ifne +20 -> 8935
    //   8918: iload_2
    //   8919: istore 4
    //   8921: aload 20
    //   8923: iload 10
    //   8925: aaload
    //   8926: ldc_w 548
    //   8929: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8932: ifeq +51 -> 8983
    //   8935: iload_2
    //   8936: istore 4
    //   8938: aload 23
    //   8940: iload 10
    //   8942: aload 20
    //   8944: iload 10
    //   8946: aaload
    //   8947: invokevirtual 490	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   8950: ldc_w 546
    //   8953: ldc -124
    //   8955: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8958: ldc_w 550
    //   8961: ldc -124
    //   8963: invokevirtual 389	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8966: invokestatic 555	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   8969: invokevirtual 558	java/lang/Integer:intValue	()I
    //   8972: iconst_2
    //   8973: iadd
    //   8974: iastore
    //   8975: aload 20
    //   8977: iload 10
    //   8979: ldc_w 537
    //   8982: aastore
    //   8983: iload_2
    //   8984: istore 4
    //   8986: aload 27
    //   8988: iload 10
    //   8990: aload 20
    //   8992: iload 10
    //   8994: aaload
    //   8995: bipush 16
    //   8997: invokestatic 561	java/lang/Integer:valueOf	(Ljava/lang/String;I)Ljava/lang/Integer;
    //   9000: invokevirtual 565	java/lang/Integer:byteValue	()B
    //   9003: bastore
    //   9004: iload 10
    //   9006: iconst_1
    //   9007: iadd
    //   9008: istore 10
    //   9010: iload_2
    //   9011: istore_1
    //   9012: goto -353 -> 8659
    //   9015: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   9018: new 771	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   9021: dup
    //   9022: aload 25
    //   9024: aload 26
    //   9026: aload 27
    //   9028: aload 23
    //   9030: getstatic 154	com/chelpus/root/utils/custompatch:group	Ljava/lang/String;
    //   9033: iconst_0
    //   9034: invokespecial 776	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:<init>	([B[I[B[ILjava/lang/String;Z)V
    //   9037: invokevirtual 765	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9040: pop
    //   9041: goto -562 -> 8479
    //   9044: astore 20
    //   9046: ldc_w 780
    //   9049: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9052: goto -458 -> 8594
    //   9055: aload 23
    //   9057: iload 10
    //   9059: iconst_1
    //   9060: iastore
    //   9061: goto -304 -> 8757
    //   9064: astore 20
    //   9066: new 174	java/lang/StringBuilder
    //   9069: dup
    //   9070: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   9073: ldc_w 684
    //   9076: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9079: aload 20
    //   9081: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9084: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9087: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9090: iload 4
    //   9092: istore_2
    //   9093: aload 27
    //   9095: arraylength
    //   9096: iconst_4
    //   9097: if_icmplt +909 -> 10006
    //   9100: iload_2
    //   9101: istore_1
    //   9102: aload 25
    //   9104: arraylength
    //   9105: iconst_4
    //   9106: if_icmpge +6 -> 9112
    //   9109: goto +897 -> 10006
    //   9112: iload_1
    //   9113: ifeq +12 -> 9125
    //   9116: iconst_0
    //   9117: istore 15
    //   9119: ldc_w 782
    //   9122: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9125: iload_1
    //   9126: istore_2
    //   9127: iload 15
    //   9129: istore 16
    //   9131: aload 19
    //   9133: astore 20
    //   9135: iload_1
    //   9136: ifne +44 -> 9180
    //   9139: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   9142: new 771	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   9145: dup
    //   9146: aload 25
    //   9148: aload 26
    //   9150: aload 27
    //   9152: aload 23
    //   9154: getstatic 154	com/chelpus/root/utils/custompatch:group	Ljava/lang/String;
    //   9157: iconst_1
    //   9158: invokespecial 776	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:<init>	([B[I[B[ILjava/lang/String;Z)V
    //   9161: invokevirtual 765	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9164: pop
    //   9165: ldc -124
    //   9167: putstatic 154	com/chelpus/root/utils/custompatch:group	Ljava/lang/String;
    //   9170: aload 19
    //   9172: astore 20
    //   9174: iload 15
    //   9176: istore 16
    //   9178: iload_1
    //   9179: istore_2
    //   9180: iload 16
    //   9182: istore 15
    //   9184: aload 20
    //   9186: astore 23
    //   9188: aload 38
    //   9190: iload 12
    //   9192: aaload
    //   9193: ldc_w 784
    //   9196: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   9199: ifeq +262 -> 9461
    //   9202: iload 16
    //   9204: istore 15
    //   9206: aload 20
    //   9208: astore 23
    //   9210: aload 38
    //   9212: iload 12
    //   9214: aaload
    //   9215: ldc_w 403
    //   9218: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   9221: ifeq +240 -> 9461
    //   9224: aload 38
    //   9226: iload 12
    //   9228: aaload
    //   9229: ldc_w 513
    //   9232: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   9235: istore 18
    //   9237: iload 16
    //   9239: istore 15
    //   9241: aload 20
    //   9243: astore 23
    //   9245: iload 18
    //   9247: ifeq +214 -> 9461
    //   9250: new 420	org/json/JSONObject
    //   9253: dup
    //   9254: aload 38
    //   9256: iload 12
    //   9258: aaload
    //   9259: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9262: ldc_w 784
    //   9265: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9268: astore 19
    //   9270: aload 19
    //   9272: invokevirtual 522	java/lang/String:trim	()Ljava/lang/String;
    //   9275: astore 20
    //   9277: new 190	java/io/File
    //   9280: dup
    //   9281: new 174	java/lang/StringBuilder
    //   9284: dup
    //   9285: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   9288: new 190	java/io/File
    //   9291: dup
    //   9292: aload_0
    //   9293: iconst_1
    //   9294: aaload
    //   9295: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   9298: invokestatic 633	com/chelpus/Utils:getDirs	(Ljava/io/File;)Ljava/io/File;
    //   9301: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9304: ldc -36
    //   9306: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9309: aload 20
    //   9311: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9314: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9317: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   9320: astore 19
    //   9322: new 190	java/io/File
    //   9325: dup
    //   9326: aload 20
    //   9328: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   9331: invokevirtual 198	java/io/File:exists	()Z
    //   9334: ifeq +14 -> 9348
    //   9337: new 190	java/io/File
    //   9340: dup
    //   9341: aload 20
    //   9343: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   9346: astore 19
    //   9348: aload 19
    //   9350: invokevirtual 625	java/io/File:length	()J
    //   9353: l2i
    //   9354: istore_1
    //   9355: iload_1
    //   9356: newarray <illegal type>
    //   9358: astore 27
    //   9360: new 347	java/io/FileInputStream
    //   9363: dup
    //   9364: aload 19
    //   9366: invokespecial 786	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   9369: astore 19
    //   9371: aload 19
    //   9373: aload 27
    //   9375: invokevirtual 787	java/io/FileInputStream:read	([B)I
    //   9378: ifgt -7 -> 9371
    //   9381: aload 19
    //   9383: invokevirtual 567	java/io/FileInputStream:close	()V
    //   9386: iload_1
    //   9387: newarray <illegal type>
    //   9389: astore 19
    //   9391: aload 19
    //   9393: iconst_1
    //   9394: invokestatic 793	java/util/Arrays:fill	([II)V
    //   9397: iload_2
    //   9398: ifeq +12 -> 9410
    //   9401: iconst_0
    //   9402: istore 16
    //   9404: ldc_w 769
    //   9407: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9410: iload 16
    //   9412: istore 15
    //   9414: aload 20
    //   9416: astore 23
    //   9418: iload_2
    //   9419: ifne +42 -> 9461
    //   9422: getstatic 104	com/chelpus/root/utils/custompatch:pat	Ljava/util/ArrayList;
    //   9425: new 771	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   9428: dup
    //   9429: aload 25
    //   9431: aload 26
    //   9433: aload 27
    //   9435: aload 19
    //   9437: getstatic 154	com/chelpus/root/utils/custompatch:group	Ljava/lang/String;
    //   9440: iconst_0
    //   9441: invokespecial 776	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:<init>	([B[I[B[ILjava/lang/String;Z)V
    //   9444: invokevirtual 765	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9447: pop
    //   9448: ldc -124
    //   9450: putstatic 154	com/chelpus/root/utils/custompatch:group	Ljava/lang/String;
    //   9453: aload 20
    //   9455: astore 23
    //   9457: iload 16
    //   9459: istore 15
    //   9461: aload 38
    //   9463: iload 12
    //   9465: aaload
    //   9466: invokevirtual 366	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   9469: ldc_w 795
    //   9472: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   9475: ifeq +9 -> 9484
    //   9478: ldc_w 797
    //   9481: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9484: aload 28
    //   9486: astore 27
    //   9488: iload 13
    //   9490: ifeq +33 -> 9523
    //   9493: new 174	java/lang/StringBuilder
    //   9496: dup
    //   9497: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   9500: aload 28
    //   9502: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9505: ldc -75
    //   9507: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9510: aload 38
    //   9512: iload 12
    //   9514: aaload
    //   9515: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9518: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9521: astore 27
    //   9523: aload 29
    //   9525: ldc_w 799
    //   9528: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   9531: ifeq +480 -> 10011
    //   9534: iconst_4
    //   9535: putstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   9538: iconst_1
    //   9539: istore 13
    //   9541: goto +470 -> 10011
    //   9544: astore 19
    //   9546: ldc_w 767
    //   9549: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9552: aload 20
    //   9554: astore 19
    //   9556: goto -286 -> 9270
    //   9559: astore 19
    //   9561: aload 19
    //   9563: invokevirtual 309	java/lang/Exception:printStackTrace	()V
    //   9566: goto -180 -> 9386
    //   9569: aload 37
    //   9571: invokevirtual 566	java/io/BufferedReader:close	()V
    //   9574: iload 16
    //   9576: ifeq +26 -> 9602
    //   9579: new 174	java/lang/StringBuilder
    //   9582: dup
    //   9583: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   9586: ldc -124
    //   9588: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9591: aload 28
    //   9593: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9596: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9599: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9602: iload 16
    //   9604: ifne +15 -> 9619
    //   9607: getstatic 110	com/chelpus/root/utils/custompatch:patchteil	Z
    //   9610: ifeq +148 -> 9758
    //   9613: ldc_w 801
    //   9616: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9619: iload_1
    //   9620: ifeq +27 -> 9647
    //   9623: new 174	java/lang/StringBuilder
    //   9626: dup
    //   9627: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   9630: ldc_w 803
    //   9633: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9636: aload 20
    //   9638: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9641: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9644: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9647: getstatic 114	com/chelpus/root/utils/custompatch:fixunpack	Z
    //   9650: ifeq +95 -> 9745
    //   9653: ldc_w 805
    //   9656: invokestatic 808	com/chelpus/Utils:sendFromRoot	(Ljava/lang/String;)Z
    //   9659: pop
    //   9660: getstatic 122	com/chelpus/root/utils/custompatch:dir	Ljava/lang/String;
    //   9663: getstatic 162	com/chelpus/root/utils/custompatch:classesFiles	Ljava/util/ArrayList;
    //   9666: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   9669: getstatic 134	com/chelpus/root/utils/custompatch:uid	Ljava/lang/String;
    //   9672: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   9675: getstatic 134	com/chelpus/root/utils/custompatch:uid	Ljava/lang/String;
    //   9678: invokestatic 811	com/chelpus/Utils:getOdexForCreate	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   9681: invokestatic 815	com/chelpus/Utils:create_ODEX_root	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   9684: istore_1
    //   9685: iload_1
    //   9686: ifeq +26 -> 9712
    //   9689: new 174	java/lang/StringBuilder
    //   9692: dup
    //   9693: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   9696: ldc_w 817
    //   9699: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9702: iload_1
    //   9703: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9706: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9709: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9712: iload_1
    //   9713: ifne +32 -> 9745
    //   9716: new 174	java/lang/StringBuilder
    //   9719: dup
    //   9720: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   9723: ldc_w 822
    //   9726: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9729: aload_0
    //   9730: iconst_2
    //   9731: aaload
    //   9732: iconst_1
    //   9733: invokestatic 337	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   9736: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9739: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9742: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9745: aload 36
    //   9747: invokevirtual 823	java/io/InputStreamReader:close	()V
    //   9750: aload 35
    //   9752: invokevirtual 567	java/io/FileInputStream:close	()V
    //   9755: goto -9524 -> 231
    //   9758: ldc_w 825
    //   9761: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   9764: goto -145 -> 9619
    //   9767: iload 9
    //   9769: istore 10
    //   9771: iload_1
    //   9772: istore 14
    //   9774: aload 20
    //   9776: astore 31
    //   9778: iload 6
    //   9780: istore 4
    //   9782: iload 15
    //   9784: istore 18
    //   9786: iload 16
    //   9788: istore 17
    //   9790: goto -8518 -> 1272
    //   9793: aload 34
    //   9795: iload 11
    //   9797: ldc_w 537
    //   9800: aastore
    //   9801: aload 25
    //   9803: iload 11
    //   9805: iconst_1
    //   9806: iastore
    //   9807: goto -6293 -> 3514
    //   9810: iload 15
    //   9812: ifne -6036 -> 3776
    //   9815: iconst_0
    //   9816: istore 16
    //   9818: goto -6042 -> 3776
    //   9821: iload 15
    //   9823: ifne -5821 -> 4002
    //   9826: iconst_0
    //   9827: istore 16
    //   9829: goto -5827 -> 4002
    //   9832: iload 17
    //   9834: istore 15
    //   9836: iload 17
    //   9838: ifne -5674 -> 4164
    //   9841: iconst_0
    //   9842: istore 16
    //   9844: iload 17
    //   9846: istore 15
    //   9848: goto -5684 -> 4164
    //   9851: iload 15
    //   9853: istore 18
    //   9855: iload 16
    //   9857: istore 17
    //   9859: iload 15
    //   9861: ifne -4103 -> 5758
    //   9864: iconst_0
    //   9865: istore 17
    //   9867: iload 15
    //   9869: istore 18
    //   9871: goto -4113 -> 5758
    //   9874: aload 19
    //   9876: iload 4
    //   9878: ldc_w 537
    //   9881: aastore
    //   9882: aload 26
    //   9884: iload 4
    //   9886: iconst_1
    //   9887: iastore
    //   9888: goto -2337 -> 7551
    //   9891: aload 19
    //   9893: iload 10
    //   9895: ldc_w 537
    //   9898: aastore
    //   9899: aload 23
    //   9901: iload 10
    //   9903: iconst_0
    //   9904: iastore
    //   9905: goto -1918 -> 7987
    //   9908: aload 19
    //   9910: iload 10
    //   9912: ldc_w 537
    //   9915: aastore
    //   9916: aload 23
    //   9918: iload 10
    //   9920: sipush 254
    //   9923: iastore
    //   9924: goto -1864 -> 8060
    //   9927: aload 19
    //   9929: iload 10
    //   9931: ldc_w 537
    //   9934: aastore
    //   9935: aload 23
    //   9937: iload 10
    //   9939: sipush 255
    //   9942: iastore
    //   9943: goto -1846 -> 8097
    //   9946: iconst_1
    //   9947: istore_2
    //   9948: goto -1534 -> 8414
    //   9951: aload 20
    //   9953: iload 10
    //   9955: ldc_w 537
    //   9958: aastore
    //   9959: aload 23
    //   9961: iload 10
    //   9963: iconst_0
    //   9964: iastore
    //   9965: goto -1208 -> 8757
    //   9968: aload 20
    //   9970: iload 10
    //   9972: ldc_w 537
    //   9975: aastore
    //   9976: aload 23
    //   9978: iload 10
    //   9980: sipush 254
    //   9983: iastore
    //   9984: goto -1154 -> 8830
    //   9987: aload 20
    //   9989: iload 10
    //   9991: ldc_w 537
    //   9994: aastore
    //   9995: aload 23
    //   9997: iload 10
    //   9999: sipush 255
    //   10002: iastore
    //   10003: goto -1136 -> 8867
    //   10006: iconst_1
    //   10007: istore_1
    //   10008: goto -896 -> 9112
    //   10011: iload 12
    //   10013: iconst_1
    //   10014: iadd
    //   10015: istore 12
    //   10017: aload 30
    //   10019: astore 34
    //   10021: iload 14
    //   10023: istore_1
    //   10024: aload 31
    //   10026: astore 20
    //   10028: aload 22
    //   10030: astore 19
    //   10032: aload 27
    //   10034: astore 28
    //   10036: aload 33
    //   10038: astore 27
    //   10040: aload 32
    //   10042: astore 33
    //   10044: iload 17
    //   10046: istore 16
    //   10048: goto -9402 -> 646
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10051	0	paramArrayOfString	String[]
    //   141	9883	1	i	int
    //   139	9809	2	j	int
    //   591	7656	3	k	int
    //   1109	8776	4	m	int
    //   588	5592	5	n	int
    //   596	9183	6	i1	int
    //   593	6314	7	i2	int
    //   585	6316	8	i3	int
    //   599	9169	9	i4	int
    //   1098	8900	10	i5	int
    //   973	8831	11	i6	int
    //   644	9372	12	i7	int
    //   308	9232	13	i8	int
    //   1101	8921	14	i9	int
    //   579	9289	15	bool1	boolean
    //   582	9465	16	bool2	boolean
    //   1117	8928	17	bool3	boolean
    //   1113	8757	18	bool4	boolean
    //   134	14	19	arrayOfFile	File[]
    //   216	3	19	localException1	Exception
    //   249	3	19	localException2	Exception
    //   259	3	19	localException3	Exception
    //   362	82	19	localObject1	Object
    //   507	1	19	localIOException	java.io.IOException
    //   568	5937	19	localObject2	Object
    //   6745	1	19	localJSONException1	org.json.JSONException
    //   6764	3	19	localJSONException2	org.json.JSONException
    //   6779	14	19	localObject3	Object
    //   6803	1	19	localJSONException3	org.json.JSONException
    //   6813	800	19	localObject4	Object
    //   7637	1	19	localJSONException4	org.json.JSONException
    //   7647	1	19	localObject5	Object
    //   7684	16	19	localException4	Exception
    //   7736	538	19	localObject6	Object
    //   8286	21	19	localException5	Exception
    //   8324	1	19	localJSONException5	org.json.JSONException
    //   8334	1	19	localObject7	Object
    //   8348	16	19	localException6	Exception
    //   8435	1001	19	localObject8	Object
    //   9544	1	19	localJSONException6	org.json.JSONException
    //   9554	1	19	localObject9	Object
    //   9559	369	19	localException7	Exception
    //   10030	1	19	localObject10	Object
    //   151	6464	20	localObject11	Object
    //   6652	1	20	localJSONException7	org.json.JSONException
    //   6671	32	20	localObject12	Object
    //   6729	3	20	localJSONException8	org.json.JSONException
    //   6755	23	20	localObject13	Object
    //   6784	1	20	localJSONException9	org.json.JSONException
    //   6914	1	20	localJSONException10	org.json.JSONException
    //   6944	1	20	localJSONException11	org.json.JSONException
    //   6964	16	20	localException8	Exception
    //   7010	380	20	localObject14	Object
    //   7664	1	20	localJSONException12	org.json.JSONException
    //   7833	1158	20	localObject15	Object
    //   9044	1	20	localJSONException13	org.json.JSONException
    //   9064	16	20	localException9	Exception
    //   9133	894	20	localObject16	Object
    //   378	6323	21	localObject17	Object
    //   6707	1	21	localJSONException14	org.json.JSONException
    //   6718	94	21	localJSONException15	org.json.JSONException
    //   6992	1	21	localObject18	Object
    //   461	6202	22	localObject19	Object
    //   6667	87	22	localException10	Exception
    //   6794	3235	22	localObject20	Object
    //   607	9389	23	localObject21	Object
    //   611	7035	24	localObject22	Object
    //   561	9241	25	localObject23	Object
    //   564	9319	26	localObject24	Object
    //   576	9463	27	localObject25	Object
    //   299	9736	28	localObject26	Object
    //   660	8864	29	localObject27	Object
    //   724	9294	30	localObject28	Object
    //   1105	8920	31	localObject29	Object
    //   2067	7974	32	localObject30	Object
    //   572	9471	33	localObject31	Object
    //   303	9717	34	localObject32	Object
    //   525	9226	35	localFileInputStream	FileInputStream
    //   539	9207	36	localInputStreamReader	java.io.InputStreamReader
    //   550	9020	37	localBufferedReader	java.io.BufferedReader
    //   558	8953	38	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   47	63	216	java/lang/Exception
    //   0	47	226	java/lang/Exception
    //   218	223	226	java/lang/Exception
    //   251	256	226	java/lang/Exception
    //   261	266	226	java/lang/Exception
    //   266	293	226	java/lang/Exception
    //   312	329	226	java/lang/Exception
    //   329	346	226	java/lang/Exception
    //   346	419	226	java/lang/Exception
    //   419	423	226	java/lang/Exception
    //   423	456	226	java/lang/Exception
    //   456	463	226	java/lang/Exception
    //   468	486	226	java/lang/Exception
    //   486	504	226	java/lang/Exception
    //   509	515	226	java/lang/Exception
    //   3656	3666	226	java/lang/Exception
    //   3826	3832	226	java/lang/Exception
    //   4052	4078	226	java/lang/Exception
    //   70	87	249	java/lang/Exception
    //   94	101	249	java/lang/Exception
    //   108	121	249	java/lang/Exception
    //   121	140	259	java/lang/Exception
    //   153	209	259	java/lang/Exception
    //   423	456	507	java/io/IOException
    //   456	463	507	java/io/IOException
    //   468	486	507	java/io/IOException
    //   486	504	507	java/io/IOException
    //   3656	3666	507	java/io/IOException
    //   515	560	3825	java/io/FileNotFoundException
    //   613	643	3825	java/io/FileNotFoundException
    //   646	653	3825	java/io/FileNotFoundException
    //   662	682	3825	java/io/FileNotFoundException
    //   689	726	3825	java/io/FileNotFoundException
    //   730	759	3825	java/io/FileNotFoundException
    //   763	786	3825	java/io/FileNotFoundException
    //   794	822	3825	java/io/FileNotFoundException
    //   826	848	3825	java/io/FileNotFoundException
    //   852	903	3825	java/io/FileNotFoundException
    //   903	937	3825	java/io/FileNotFoundException
    //   937	971	3825	java/io/FileNotFoundException
    //   980	1008	3825	java/io/FileNotFoundException
    //   1012	1026	3825	java/io/FileNotFoundException
    //   1026	1054	3825	java/io/FileNotFoundException
    //   1066	1096	3825	java/io/FileNotFoundException
    //   1119	1133	3825	java/io/FileNotFoundException
    //   1156	1170	3825	java/io/FileNotFoundException
    //   1193	1272	3825	java/io/FileNotFoundException
    //   1276	1297	3825	java/io/FileNotFoundException
    //   1300	1364	3825	java/io/FileNotFoundException
    //   1364	1386	3825	java/io/FileNotFoundException
    //   1386	1408	3825	java/io/FileNotFoundException
    //   1412	1445	3825	java/io/FileNotFoundException
    //   1454	1474	3825	java/io/FileNotFoundException
    //   1478	1489	3825	java/io/FileNotFoundException
    //   1493	1517	3825	java/io/FileNotFoundException
    //   1521	1527	3825	java/io/FileNotFoundException
    //   1531	1572	3825	java/io/FileNotFoundException
    //   1576	1584	3825	java/io/FileNotFoundException
    //   1588	1592	3825	java/io/FileNotFoundException
    //   1596	1607	3825	java/io/FileNotFoundException
    //   1611	1617	3825	java/io/FileNotFoundException
    //   1621	1630	3825	java/io/FileNotFoundException
    //   1634	1639	3825	java/io/FileNotFoundException
    //   1643	1667	3825	java/io/FileNotFoundException
    //   1671	1677	3825	java/io/FileNotFoundException
    //   1681	1722	3825	java/io/FileNotFoundException
    //   1726	1730	3825	java/io/FileNotFoundException
    //   1734	1740	3825	java/io/FileNotFoundException
    //   1744	1752	3825	java/io/FileNotFoundException
    //   1756	1762	3825	java/io/FileNotFoundException
    //   1766	1793	3825	java/io/FileNotFoundException
    //   1797	1803	3825	java/io/FileNotFoundException
    //   1807	1826	3825	java/io/FileNotFoundException
    //   1839	1859	3825	java/io/FileNotFoundException
    //   1863	1887	3825	java/io/FileNotFoundException
    //   1891	1896	3825	java/io/FileNotFoundException
    //   1909	1919	3825	java/io/FileNotFoundException
    //   1923	1930	3825	java/io/FileNotFoundException
    //   1934	1939	3825	java/io/FileNotFoundException
    //   1956	1968	3825	java/io/FileNotFoundException
    //   1968	1988	3825	java/io/FileNotFoundException
    //   1992	1998	3825	java/io/FileNotFoundException
    //   2002	2032	3825	java/io/FileNotFoundException
    //   2036	2042	3825	java/io/FileNotFoundException
    //   2046	2054	3825	java/io/FileNotFoundException
    //   2074	2087	3825	java/io/FileNotFoundException
    //   2096	2116	3825	java/io/FileNotFoundException
    //   2120	2128	3825	java/io/FileNotFoundException
    //   2140	2154	3825	java/io/FileNotFoundException
    //   2162	2176	3825	java/io/FileNotFoundException
    //   2184	2211	3825	java/io/FileNotFoundException
    //   2224	2244	3825	java/io/FileNotFoundException
    //   2261	2274	3825	java/io/FileNotFoundException
    //   2283	2303	3825	java/io/FileNotFoundException
    //   2311	2325	3825	java/io/FileNotFoundException
    //   2333	2347	3825	java/io/FileNotFoundException
    //   2355	2382	3825	java/io/FileNotFoundException
    //   2395	2415	3825	java/io/FileNotFoundException
    //   2432	2444	3825	java/io/FileNotFoundException
    //   2444	2464	3825	java/io/FileNotFoundException
    //   2464	2484	3825	java/io/FileNotFoundException
    //   2491	2512	3825	java/io/FileNotFoundException
    //   2521	2529	3825	java/io/FileNotFoundException
    //   2547	2602	3825	java/io/FileNotFoundException
    //   2602	2607	3825	java/io/FileNotFoundException
    //   2615	2623	3825	java/io/FileNotFoundException
    //   2641	2679	3825	java/io/FileNotFoundException
    //   2688	2696	3825	java/io/FileNotFoundException
    //   2714	2752	3825	java/io/FileNotFoundException
    //   2760	2768	3825	java/io/FileNotFoundException
    //   2786	2824	3825	java/io/FileNotFoundException
    //   2833	2841	3825	java/io/FileNotFoundException
    //   2844	2865	3825	java/io/FileNotFoundException
    //   2874	2882	3825	java/io/FileNotFoundException
    //   2885	2907	3825	java/io/FileNotFoundException
    //   2916	2924	3825	java/io/FileNotFoundException
    //   2927	2949	3825	java/io/FileNotFoundException
    //   2958	2966	3825	java/io/FileNotFoundException
    //   2973	2999	3825	java/io/FileNotFoundException
    //   3011	3015	3825	java/io/FileNotFoundException
    //   3023	3049	3825	java/io/FileNotFoundException
    //   3058	3062	3825	java/io/FileNotFoundException
    //   3065	3106	3825	java/io/FileNotFoundException
    //   3111	3132	3825	java/io/FileNotFoundException
    //   3153	3167	3825	java/io/FileNotFoundException
    //   3188	3202	3825	java/io/FileNotFoundException
    //   3223	3237	3825	java/io/FileNotFoundException
    //   3248	3263	3825	java/io/FileNotFoundException
    //   3270	3301	3825	java/io/FileNotFoundException
    //   3312	3332	3825	java/io/FileNotFoundException
    //   3336	3343	3825	java/io/FileNotFoundException
    //   3347	3360	3825	java/io/FileNotFoundException
    //   3360	3398	3825	java/io/FileNotFoundException
    //   3425	3433	3825	java/io/FileNotFoundException
    //   3437	3451	3825	java/io/FileNotFoundException
    //   3455	3469	3825	java/io/FileNotFoundException
    //   3481	3495	3825	java/io/FileNotFoundException
    //   3497	3511	3825	java/io/FileNotFoundException
    //   3516	3530	3825	java/io/FileNotFoundException
    //   3532	3546	3825	java/io/FileNotFoundException
    //   3548	3562	3825	java/io/FileNotFoundException
    //   3564	3578	3825	java/io/FileNotFoundException
    //   3580	3617	3825	java/io/FileNotFoundException
    //   3627	3645	3825	java/io/FileNotFoundException
    //   3669	3692	3825	java/io/FileNotFoundException
    //   3715	3759	3825	java/io/FileNotFoundException
    //   3759	3773	3825	java/io/FileNotFoundException
    //   3776	3799	3825	java/io/FileNotFoundException
    //   3835	3918	3825	java/io/FileNotFoundException
    //   3941	3985	3825	java/io/FileNotFoundException
    //   3985	3999	3825	java/io/FileNotFoundException
    //   4002	4025	3825	java/io/FileNotFoundException
    //   4104	4110	3825	java/io/FileNotFoundException
    //   4133	4156	3825	java/io/FileNotFoundException
    //   4156	4164	3825	java/io/FileNotFoundException
    //   4164	4262	3825	java/io/FileNotFoundException
    //   4266	4280	3825	java/io/FileNotFoundException
    //   4283	4314	3825	java/io/FileNotFoundException
    //   4340	4344	3825	java/io/FileNotFoundException
    //   4348	4392	3825	java/io/FileNotFoundException
    //   4392	4400	3825	java/io/FileNotFoundException
    //   4420	4455	3825	java/io/FileNotFoundException
    //   4455	4467	3825	java/io/FileNotFoundException
    //   4467	4476	3825	java/io/FileNotFoundException
    //   4476	4485	3825	java/io/FileNotFoundException
    //   4487	4495	3825	java/io/FileNotFoundException
    //   4495	4518	3825	java/io/FileNotFoundException
    //   4540	4544	3825	java/io/FileNotFoundException
    //   4552	4561	3825	java/io/FileNotFoundException
    //   4569	4575	3825	java/io/FileNotFoundException
    //   4583	4600	3825	java/io/FileNotFoundException
    //   4600	4686	3825	java/io/FileNotFoundException
    //   4686	4694	3825	java/io/FileNotFoundException
    //   4713	4727	3825	java/io/FileNotFoundException
    //   4735	4758	3825	java/io/FileNotFoundException
    //   4776	4780	3825	java/io/FileNotFoundException
    //   4788	4797	3825	java/io/FileNotFoundException
    //   4805	4811	3825	java/io/FileNotFoundException
    //   4819	4836	3825	java/io/FileNotFoundException
    //   4836	4922	3825	java/io/FileNotFoundException
    //   4922	4930	3825	java/io/FileNotFoundException
    //   4949	4963	3825	java/io/FileNotFoundException
    //   4971	4994	3825	java/io/FileNotFoundException
    //   5012	5016	3825	java/io/FileNotFoundException
    //   5024	5033	3825	java/io/FileNotFoundException
    //   5041	5047	3825	java/io/FileNotFoundException
    //   5055	5072	3825	java/io/FileNotFoundException
    //   5072	5158	3825	java/io/FileNotFoundException
    //   5158	5166	3825	java/io/FileNotFoundException
    //   5185	5199	3825	java/io/FileNotFoundException
    //   5207	5230	3825	java/io/FileNotFoundException
    //   5248	5252	3825	java/io/FileNotFoundException
    //   5260	5269	3825	java/io/FileNotFoundException
    //   5277	5283	3825	java/io/FileNotFoundException
    //   5291	5308	3825	java/io/FileNotFoundException
    //   5308	5394	3825	java/io/FileNotFoundException
    //   5394	5402	3825	java/io/FileNotFoundException
    //   5421	5435	3825	java/io/FileNotFoundException
    //   5443	5466	3825	java/io/FileNotFoundException
    //   5484	5488	3825	java/io/FileNotFoundException
    //   5496	5505	3825	java/io/FileNotFoundException
    //   5513	5519	3825	java/io/FileNotFoundException
    //   5527	5544	3825	java/io/FileNotFoundException
    //   5544	5630	3825	java/io/FileNotFoundException
    //   5630	5638	3825	java/io/FileNotFoundException
    //   5657	5671	3825	java/io/FileNotFoundException
    //   5679	5702	3825	java/io/FileNotFoundException
    //   5720	5724	3825	java/io/FileNotFoundException
    //   5732	5741	3825	java/io/FileNotFoundException
    //   5741	5755	3825	java/io/FileNotFoundException
    //   5758	5781	3825	java/io/FileNotFoundException
    //   5799	5838	3825	java/io/FileNotFoundException
    //   5838	5870	3825	java/io/FileNotFoundException
    //   5870	5894	3825	java/io/FileNotFoundException
    //   5894	5902	3825	java/io/FileNotFoundException
    //   5906	5923	3825	java/io/FileNotFoundException
    //   5943	5966	3825	java/io/FileNotFoundException
    //   5988	6015	3825	java/io/FileNotFoundException
    //   6067	6168	3825	java/io/FileNotFoundException
    //   6202	6217	3825	java/io/FileNotFoundException
    //   6221	6381	3825	java/io/FileNotFoundException
    //   6403	6431	3825	java/io/FileNotFoundException
    //   6434	6528	3825	java/io/FileNotFoundException
    //   6528	6552	3825	java/io/FileNotFoundException
    //   6574	6580	3825	java/io/FileNotFoundException
    //   6583	6607	3825	java/io/FileNotFoundException
    //   6645	6649	3825	java/io/FileNotFoundException
    //   6654	6660	3825	java/io/FileNotFoundException
    //   6673	6700	3825	java/io/FileNotFoundException
    //   6709	6715	3825	java/io/FileNotFoundException
    //   6720	6726	3825	java/io/FileNotFoundException
    //   6731	6742	3825	java/io/FileNotFoundException
    //   6747	6753	3825	java/io/FileNotFoundException
    //   6766	6777	3825	java/io/FileNotFoundException
    //   6786	6792	3825	java/io/FileNotFoundException
    //   6805	6811	3825	java/io/FileNotFoundException
    //   6818	6824	3825	java/io/FileNotFoundException
    //   6842	6848	3825	java/io/FileNotFoundException
    //   6866	6872	3825	java/io/FileNotFoundException
    //   6890	6896	3825	java/io/FileNotFoundException
    //   6916	6927	3825	java/io/FileNotFoundException
    //   6930	6938	3825	java/io/FileNotFoundException
    //   6946	6952	3825	java/io/FileNotFoundException
    //   6966	6990	3825	java/io/FileNotFoundException
    //   7020	7034	3825	java/io/FileNotFoundException
    //   7042	7069	3825	java/io/FileNotFoundException
    //   7082	7102	3825	java/io/FileNotFoundException
    //   7102	7253	3825	java/io/FileNotFoundException
    //   7256	7260	3825	java/io/FileNotFoundException
    //   7281	7295	3825	java/io/FileNotFoundException
    //   7316	7343	3825	java/io/FileNotFoundException
    //   7369	7389	3825	java/io/FileNotFoundException
    //   7393	7400	3825	java/io/FileNotFoundException
    //   7404	7417	3825	java/io/FileNotFoundException
    //   7417	7455	3825	java/io/FileNotFoundException
    //   7462	7470	3825	java/io/FileNotFoundException
    //   7474	7488	3825	java/io/FileNotFoundException
    //   7492	7506	3825	java/io/FileNotFoundException
    //   7518	7532	3825	java/io/FileNotFoundException
    //   7534	7548	3825	java/io/FileNotFoundException
    //   7553	7570	3825	java/io/FileNotFoundException
    //   7572	7598	3825	java/io/FileNotFoundException
    //   7608	7626	3825	java/io/FileNotFoundException
    //   7639	7645	3825	java/io/FileNotFoundException
    //   7652	7658	3825	java/io/FileNotFoundException
    //   7666	7672	3825	java/io/FileNotFoundException
    //   7686	7710	3825	java/io/FileNotFoundException
    //   7719	7725	3825	java/io/FileNotFoundException
    //   7738	7752	3825	java/io/FileNotFoundException
    //   7762	7789	3825	java/io/FileNotFoundException
    //   7804	7824	3825	java/io/FileNotFoundException
    //   7824	7831	3825	java/io/FileNotFoundException
    //   7835	7848	3825	java/io/FileNotFoundException
    //   7848	7886	3825	java/io/FileNotFoundException
    //   7894	7902	3825	java/io/FileNotFoundException
    //   7907	7921	3825	java/io/FileNotFoundException
    //   7926	7940	3825	java/io/FileNotFoundException
    //   7953	7967	3825	java/io/FileNotFoundException
    //   7970	7984	3825	java/io/FileNotFoundException
    //   7990	8007	3825	java/io/FileNotFoundException
    //   8026	8040	3825	java/io/FileNotFoundException
    //   8043	8057	3825	java/io/FileNotFoundException
    //   8063	8077	3825	java/io/FileNotFoundException
    //   8080	8094	3825	java/io/FileNotFoundException
    //   8100	8114	3825	java/io/FileNotFoundException
    //   8117	8131	3825	java/io/FileNotFoundException
    //   8134	8148	3825	java/io/FileNotFoundException
    //   8151	8165	3825	java/io/FileNotFoundException
    //   8168	8205	3825	java/io/FileNotFoundException
    //   8216	8234	3825	java/io/FileNotFoundException
    //   8247	8279	3825	java/io/FileNotFoundException
    //   8288	8317	3825	java/io/FileNotFoundException
    //   8326	8332	3825	java/io/FileNotFoundException
    //   8350	8374	3825	java/io/FileNotFoundException
    //   8377	8402	3825	java/io/FileNotFoundException
    //   8404	8411	3825	java/io/FileNotFoundException
    //   8421	8427	3825	java/io/FileNotFoundException
    //   8441	8453	3825	java/io/FileNotFoundException
    //   8453	8479	3825	java/io/FileNotFoundException
    //   8479	8484	3825	java/io/FileNotFoundException
    //   8504	8518	3825	java/io/FileNotFoundException
    //   8528	8555	3825	java/io/FileNotFoundException
    //   8570	8590	3825	java/io/FileNotFoundException
    //   8594	8601	3825	java/io/FileNotFoundException
    //   8605	8618	3825	java/io/FileNotFoundException
    //   8618	8656	3825	java/io/FileNotFoundException
    //   8664	8672	3825	java/io/FileNotFoundException
    //   8677	8691	3825	java/io/FileNotFoundException
    //   8696	8710	3825	java/io/FileNotFoundException
    //   8723	8737	3825	java/io/FileNotFoundException
    //   8740	8754	3825	java/io/FileNotFoundException
    //   8760	8777	3825	java/io/FileNotFoundException
    //   8796	8810	3825	java/io/FileNotFoundException
    //   8813	8827	3825	java/io/FileNotFoundException
    //   8833	8847	3825	java/io/FileNotFoundException
    //   8850	8864	3825	java/io/FileNotFoundException
    //   8870	8884	3825	java/io/FileNotFoundException
    //   8887	8901	3825	java/io/FileNotFoundException
    //   8904	8918	3825	java/io/FileNotFoundException
    //   8921	8935	3825	java/io/FileNotFoundException
    //   8938	8975	3825	java/io/FileNotFoundException
    //   8986	9004	3825	java/io/FileNotFoundException
    //   9015	9041	3825	java/io/FileNotFoundException
    //   9046	9052	3825	java/io/FileNotFoundException
    //   9066	9090	3825	java/io/FileNotFoundException
    //   9093	9100	3825	java/io/FileNotFoundException
    //   9102	9109	3825	java/io/FileNotFoundException
    //   9119	9125	3825	java/io/FileNotFoundException
    //   9139	9170	3825	java/io/FileNotFoundException
    //   9188	9202	3825	java/io/FileNotFoundException
    //   9210	9237	3825	java/io/FileNotFoundException
    //   9250	9270	3825	java/io/FileNotFoundException
    //   9270	9322	3825	java/io/FileNotFoundException
    //   9322	9348	3825	java/io/FileNotFoundException
    //   9348	9360	3825	java/io/FileNotFoundException
    //   9360	9371	3825	java/io/FileNotFoundException
    //   9371	9386	3825	java/io/FileNotFoundException
    //   9386	9397	3825	java/io/FileNotFoundException
    //   9404	9410	3825	java/io/FileNotFoundException
    //   9422	9453	3825	java/io/FileNotFoundException
    //   9461	9484	3825	java/io/FileNotFoundException
    //   9493	9523	3825	java/io/FileNotFoundException
    //   9523	9538	3825	java/io/FileNotFoundException
    //   9546	9552	3825	java/io/FileNotFoundException
    //   9561	9566	3825	java/io/FileNotFoundException
    //   9569	9574	3825	java/io/FileNotFoundException
    //   9579	9602	3825	java/io/FileNotFoundException
    //   9607	9619	3825	java/io/FileNotFoundException
    //   9623	9647	3825	java/io/FileNotFoundException
    //   9647	9685	3825	java/io/FileNotFoundException
    //   9689	9712	3825	java/io/FileNotFoundException
    //   9716	9745	3825	java/io/FileNotFoundException
    //   9745	9755	3825	java/io/FileNotFoundException
    //   9758	9764	3825	java/io/FileNotFoundException
    //   515	560	4051	java/lang/Exception
    //   613	643	4051	java/lang/Exception
    //   646	653	4051	java/lang/Exception
    //   662	682	4051	java/lang/Exception
    //   689	726	4051	java/lang/Exception
    //   730	759	4051	java/lang/Exception
    //   763	786	4051	java/lang/Exception
    //   794	822	4051	java/lang/Exception
    //   826	848	4051	java/lang/Exception
    //   852	903	4051	java/lang/Exception
    //   903	937	4051	java/lang/Exception
    //   937	971	4051	java/lang/Exception
    //   980	1008	4051	java/lang/Exception
    //   1012	1026	4051	java/lang/Exception
    //   1026	1054	4051	java/lang/Exception
    //   1066	1096	4051	java/lang/Exception
    //   1119	1133	4051	java/lang/Exception
    //   1156	1170	4051	java/lang/Exception
    //   1193	1272	4051	java/lang/Exception
    //   1276	1297	4051	java/lang/Exception
    //   1300	1364	4051	java/lang/Exception
    //   1364	1386	4051	java/lang/Exception
    //   1386	1408	4051	java/lang/Exception
    //   1412	1445	4051	java/lang/Exception
    //   1454	1474	4051	java/lang/Exception
    //   1478	1489	4051	java/lang/Exception
    //   1493	1517	4051	java/lang/Exception
    //   1521	1527	4051	java/lang/Exception
    //   1531	1572	4051	java/lang/Exception
    //   1576	1584	4051	java/lang/Exception
    //   1588	1592	4051	java/lang/Exception
    //   1596	1607	4051	java/lang/Exception
    //   1611	1617	4051	java/lang/Exception
    //   1621	1630	4051	java/lang/Exception
    //   1634	1639	4051	java/lang/Exception
    //   1643	1667	4051	java/lang/Exception
    //   1671	1677	4051	java/lang/Exception
    //   1681	1722	4051	java/lang/Exception
    //   1726	1730	4051	java/lang/Exception
    //   1734	1740	4051	java/lang/Exception
    //   1744	1752	4051	java/lang/Exception
    //   1756	1762	4051	java/lang/Exception
    //   1766	1793	4051	java/lang/Exception
    //   1797	1803	4051	java/lang/Exception
    //   1807	1826	4051	java/lang/Exception
    //   1839	1859	4051	java/lang/Exception
    //   1863	1887	4051	java/lang/Exception
    //   1891	1896	4051	java/lang/Exception
    //   1956	1968	4051	java/lang/Exception
    //   1968	1988	4051	java/lang/Exception
    //   1992	1998	4051	java/lang/Exception
    //   2002	2032	4051	java/lang/Exception
    //   2036	2042	4051	java/lang/Exception
    //   2046	2054	4051	java/lang/Exception
    //   2074	2087	4051	java/lang/Exception
    //   2096	2116	4051	java/lang/Exception
    //   2120	2128	4051	java/lang/Exception
    //   2140	2154	4051	java/lang/Exception
    //   2162	2176	4051	java/lang/Exception
    //   2184	2211	4051	java/lang/Exception
    //   2224	2244	4051	java/lang/Exception
    //   2261	2274	4051	java/lang/Exception
    //   2283	2303	4051	java/lang/Exception
    //   2311	2325	4051	java/lang/Exception
    //   2333	2347	4051	java/lang/Exception
    //   2355	2382	4051	java/lang/Exception
    //   2395	2415	4051	java/lang/Exception
    //   2432	2444	4051	java/lang/Exception
    //   2444	2464	4051	java/lang/Exception
    //   2464	2484	4051	java/lang/Exception
    //   2491	2512	4051	java/lang/Exception
    //   2521	2529	4051	java/lang/Exception
    //   2547	2602	4051	java/lang/Exception
    //   2602	2607	4051	java/lang/Exception
    //   2615	2623	4051	java/lang/Exception
    //   2641	2679	4051	java/lang/Exception
    //   2688	2696	4051	java/lang/Exception
    //   2714	2752	4051	java/lang/Exception
    //   2760	2768	4051	java/lang/Exception
    //   2786	2824	4051	java/lang/Exception
    //   2833	2841	4051	java/lang/Exception
    //   2844	2865	4051	java/lang/Exception
    //   2874	2882	4051	java/lang/Exception
    //   2885	2907	4051	java/lang/Exception
    //   2916	2924	4051	java/lang/Exception
    //   2927	2949	4051	java/lang/Exception
    //   2958	2966	4051	java/lang/Exception
    //   2973	2999	4051	java/lang/Exception
    //   3011	3015	4051	java/lang/Exception
    //   3023	3049	4051	java/lang/Exception
    //   3058	3062	4051	java/lang/Exception
    //   3065	3106	4051	java/lang/Exception
    //   3111	3132	4051	java/lang/Exception
    //   3153	3167	4051	java/lang/Exception
    //   3188	3202	4051	java/lang/Exception
    //   3223	3237	4051	java/lang/Exception
    //   3248	3263	4051	java/lang/Exception
    //   3270	3301	4051	java/lang/Exception
    //   3312	3332	4051	java/lang/Exception
    //   3336	3343	4051	java/lang/Exception
    //   3347	3360	4051	java/lang/Exception
    //   3360	3398	4051	java/lang/Exception
    //   3669	3692	4051	java/lang/Exception
    //   3715	3759	4051	java/lang/Exception
    //   3759	3773	4051	java/lang/Exception
    //   3776	3799	4051	java/lang/Exception
    //   3835	3918	4051	java/lang/Exception
    //   3941	3985	4051	java/lang/Exception
    //   3985	3999	4051	java/lang/Exception
    //   4002	4025	4051	java/lang/Exception
    //   4104	4110	4051	java/lang/Exception
    //   4133	4156	4051	java/lang/Exception
    //   4156	4164	4051	java/lang/Exception
    //   4164	4262	4051	java/lang/Exception
    //   4266	4280	4051	java/lang/Exception
    //   4283	4314	4051	java/lang/Exception
    //   4340	4344	4051	java/lang/Exception
    //   4348	4392	4051	java/lang/Exception
    //   4392	4400	4051	java/lang/Exception
    //   4420	4455	4051	java/lang/Exception
    //   4455	4467	4051	java/lang/Exception
    //   4467	4476	4051	java/lang/Exception
    //   4476	4485	4051	java/lang/Exception
    //   4487	4495	4051	java/lang/Exception
    //   4495	4518	4051	java/lang/Exception
    //   4540	4544	4051	java/lang/Exception
    //   4552	4561	4051	java/lang/Exception
    //   4569	4575	4051	java/lang/Exception
    //   4583	4600	4051	java/lang/Exception
    //   4600	4686	4051	java/lang/Exception
    //   4686	4694	4051	java/lang/Exception
    //   4713	4727	4051	java/lang/Exception
    //   4735	4758	4051	java/lang/Exception
    //   4776	4780	4051	java/lang/Exception
    //   4788	4797	4051	java/lang/Exception
    //   4805	4811	4051	java/lang/Exception
    //   4819	4836	4051	java/lang/Exception
    //   4836	4922	4051	java/lang/Exception
    //   4922	4930	4051	java/lang/Exception
    //   4949	4963	4051	java/lang/Exception
    //   4971	4994	4051	java/lang/Exception
    //   5012	5016	4051	java/lang/Exception
    //   5024	5033	4051	java/lang/Exception
    //   5041	5047	4051	java/lang/Exception
    //   5055	5072	4051	java/lang/Exception
    //   5072	5158	4051	java/lang/Exception
    //   5158	5166	4051	java/lang/Exception
    //   5185	5199	4051	java/lang/Exception
    //   5207	5230	4051	java/lang/Exception
    //   5248	5252	4051	java/lang/Exception
    //   5260	5269	4051	java/lang/Exception
    //   5277	5283	4051	java/lang/Exception
    //   5291	5308	4051	java/lang/Exception
    //   5308	5394	4051	java/lang/Exception
    //   5394	5402	4051	java/lang/Exception
    //   5421	5435	4051	java/lang/Exception
    //   5443	5466	4051	java/lang/Exception
    //   5484	5488	4051	java/lang/Exception
    //   5496	5505	4051	java/lang/Exception
    //   5513	5519	4051	java/lang/Exception
    //   5527	5544	4051	java/lang/Exception
    //   5544	5630	4051	java/lang/Exception
    //   5630	5638	4051	java/lang/Exception
    //   5657	5671	4051	java/lang/Exception
    //   5679	5702	4051	java/lang/Exception
    //   5720	5724	4051	java/lang/Exception
    //   5732	5741	4051	java/lang/Exception
    //   5741	5755	4051	java/lang/Exception
    //   5758	5781	4051	java/lang/Exception
    //   5799	5838	4051	java/lang/Exception
    //   5838	5870	4051	java/lang/Exception
    //   5870	5894	4051	java/lang/Exception
    //   5894	5902	4051	java/lang/Exception
    //   5906	5923	4051	java/lang/Exception
    //   5943	5966	4051	java/lang/Exception
    //   5988	6015	4051	java/lang/Exception
    //   6067	6168	4051	java/lang/Exception
    //   6202	6217	4051	java/lang/Exception
    //   6221	6381	4051	java/lang/Exception
    //   6403	6431	4051	java/lang/Exception
    //   6434	6528	4051	java/lang/Exception
    //   6528	6552	4051	java/lang/Exception
    //   6574	6580	4051	java/lang/Exception
    //   6583	6607	4051	java/lang/Exception
    //   6645	6649	4051	java/lang/Exception
    //   6654	6660	4051	java/lang/Exception
    //   6673	6700	4051	java/lang/Exception
    //   6709	6715	4051	java/lang/Exception
    //   6720	6726	4051	java/lang/Exception
    //   6731	6742	4051	java/lang/Exception
    //   6747	6753	4051	java/lang/Exception
    //   6766	6777	4051	java/lang/Exception
    //   6786	6792	4051	java/lang/Exception
    //   6805	6811	4051	java/lang/Exception
    //   6818	6824	4051	java/lang/Exception
    //   6842	6848	4051	java/lang/Exception
    //   6866	6872	4051	java/lang/Exception
    //   6890	6896	4051	java/lang/Exception
    //   6916	6927	4051	java/lang/Exception
    //   6930	6938	4051	java/lang/Exception
    //   6946	6952	4051	java/lang/Exception
    //   6966	6990	4051	java/lang/Exception
    //   7020	7034	4051	java/lang/Exception
    //   7042	7069	4051	java/lang/Exception
    //   7082	7102	4051	java/lang/Exception
    //   7102	7253	4051	java/lang/Exception
    //   7256	7260	4051	java/lang/Exception
    //   7281	7295	4051	java/lang/Exception
    //   7316	7343	4051	java/lang/Exception
    //   7369	7389	4051	java/lang/Exception
    //   7393	7400	4051	java/lang/Exception
    //   7404	7417	4051	java/lang/Exception
    //   7417	7455	4051	java/lang/Exception
    //   7639	7645	4051	java/lang/Exception
    //   7652	7658	4051	java/lang/Exception
    //   7666	7672	4051	java/lang/Exception
    //   7686	7710	4051	java/lang/Exception
    //   7719	7725	4051	java/lang/Exception
    //   7738	7752	4051	java/lang/Exception
    //   7762	7789	4051	java/lang/Exception
    //   7804	7824	4051	java/lang/Exception
    //   7824	7831	4051	java/lang/Exception
    //   7835	7848	4051	java/lang/Exception
    //   7848	7886	4051	java/lang/Exception
    //   8288	8317	4051	java/lang/Exception
    //   8326	8332	4051	java/lang/Exception
    //   8350	8374	4051	java/lang/Exception
    //   8377	8402	4051	java/lang/Exception
    //   8404	8411	4051	java/lang/Exception
    //   8421	8427	4051	java/lang/Exception
    //   8441	8453	4051	java/lang/Exception
    //   8453	8479	4051	java/lang/Exception
    //   8479	8484	4051	java/lang/Exception
    //   8504	8518	4051	java/lang/Exception
    //   8528	8555	4051	java/lang/Exception
    //   8570	8590	4051	java/lang/Exception
    //   8594	8601	4051	java/lang/Exception
    //   8605	8618	4051	java/lang/Exception
    //   8618	8656	4051	java/lang/Exception
    //   9015	9041	4051	java/lang/Exception
    //   9046	9052	4051	java/lang/Exception
    //   9066	9090	4051	java/lang/Exception
    //   9093	9100	4051	java/lang/Exception
    //   9102	9109	4051	java/lang/Exception
    //   9119	9125	4051	java/lang/Exception
    //   9139	9170	4051	java/lang/Exception
    //   9188	9202	4051	java/lang/Exception
    //   9210	9237	4051	java/lang/Exception
    //   9250	9270	4051	java/lang/Exception
    //   9270	9322	4051	java/lang/Exception
    //   9322	9348	4051	java/lang/Exception
    //   9348	9360	4051	java/lang/Exception
    //   9386	9397	4051	java/lang/Exception
    //   9404	9410	4051	java/lang/Exception
    //   9422	9453	4051	java/lang/Exception
    //   9461	9484	4051	java/lang/Exception
    //   9493	9523	4051	java/lang/Exception
    //   9523	9538	4051	java/lang/Exception
    //   9546	9552	4051	java/lang/Exception
    //   9561	9566	4051	java/lang/Exception
    //   9569	9574	4051	java/lang/Exception
    //   9579	9602	4051	java/lang/Exception
    //   9607	9619	4051	java/lang/Exception
    //   9623	9647	4051	java/lang/Exception
    //   9647	9685	4051	java/lang/Exception
    //   9689	9712	4051	java/lang/Exception
    //   9716	9745	4051	java/lang/Exception
    //   9745	9755	4051	java/lang/Exception
    //   9758	9764	4051	java/lang/Exception
    //   1454	1474	6652	org/json/JSONException
    //   1478	1489	6652	org/json/JSONException
    //   1493	1517	6652	org/json/JSONException
    //   1521	1527	6652	org/json/JSONException
    //   1531	1572	6652	org/json/JSONException
    //   1576	1584	6652	org/json/JSONException
    //   1588	1592	6652	org/json/JSONException
    //   1596	1607	6652	org/json/JSONException
    //   1611	1617	6652	org/json/JSONException
    //   1621	1630	6652	org/json/JSONException
    //   1634	1639	6652	org/json/JSONException
    //   1643	1667	6652	org/json/JSONException
    //   1671	1677	6652	org/json/JSONException
    //   1681	1722	6652	org/json/JSONException
    //   1726	1730	6652	org/json/JSONException
    //   1734	1740	6652	org/json/JSONException
    //   1744	1752	6652	org/json/JSONException
    //   1756	1762	6652	org/json/JSONException
    //   1766	1793	6652	org/json/JSONException
    //   1797	1803	6652	org/json/JSONException
    //   6645	6649	6652	org/json/JSONException
    //   1909	1919	6667	java/lang/Exception
    //   1923	1930	6667	java/lang/Exception
    //   1934	1939	6667	java/lang/Exception
    //   1839	1859	6707	org/json/JSONException
    //   1863	1887	6707	org/json/JSONException
    //   1891	1896	6707	org/json/JSONException
    //   1909	1919	6707	org/json/JSONException
    //   1923	1930	6707	org/json/JSONException
    //   1934	1939	6707	org/json/JSONException
    //   6673	6700	6707	org/json/JSONException
    //   1968	1988	6718	org/json/JSONException
    //   1992	1998	6718	org/json/JSONException
    //   2002	2032	6718	org/json/JSONException
    //   2036	2042	6718	org/json/JSONException
    //   2096	2116	6729	org/json/JSONException
    //   2224	2244	6745	org/json/JSONException
    //   2283	2303	6764	org/json/JSONException
    //   2395	2415	6784	org/json/JSONException
    //   2444	2464	6803	org/json/JSONException
    //   3111	3132	6914	org/json/JSONException
    //   3312	3332	6944	org/json/JSONException
    //   3425	3433	6964	java/lang/Exception
    //   3437	3451	6964	java/lang/Exception
    //   3455	3469	6964	java/lang/Exception
    //   3481	3495	6964	java/lang/Exception
    //   3497	3511	6964	java/lang/Exception
    //   3516	3530	6964	java/lang/Exception
    //   3532	3546	6964	java/lang/Exception
    //   3548	3562	6964	java/lang/Exception
    //   3564	3578	6964	java/lang/Exception
    //   3580	3617	6964	java/lang/Exception
    //   3627	3645	6964	java/lang/Exception
    //   7082	7102	7637	org/json/JSONException
    //   7369	7389	7664	org/json/JSONException
    //   7462	7470	7684	java/lang/Exception
    //   7474	7488	7684	java/lang/Exception
    //   7492	7506	7684	java/lang/Exception
    //   7518	7532	7684	java/lang/Exception
    //   7534	7548	7684	java/lang/Exception
    //   7553	7570	7684	java/lang/Exception
    //   7572	7598	7684	java/lang/Exception
    //   7608	7626	7684	java/lang/Exception
    //   8247	8279	8286	java/lang/Exception
    //   7804	7824	8324	org/json/JSONException
    //   7894	7902	8348	java/lang/Exception
    //   7907	7921	8348	java/lang/Exception
    //   7926	7940	8348	java/lang/Exception
    //   7953	7967	8348	java/lang/Exception
    //   7970	7984	8348	java/lang/Exception
    //   7990	8007	8348	java/lang/Exception
    //   8026	8040	8348	java/lang/Exception
    //   8043	8057	8348	java/lang/Exception
    //   8063	8077	8348	java/lang/Exception
    //   8080	8094	8348	java/lang/Exception
    //   8100	8114	8348	java/lang/Exception
    //   8117	8131	8348	java/lang/Exception
    //   8134	8148	8348	java/lang/Exception
    //   8151	8165	8348	java/lang/Exception
    //   8168	8205	8348	java/lang/Exception
    //   8216	8234	8348	java/lang/Exception
    //   8570	8590	9044	org/json/JSONException
    //   8664	8672	9064	java/lang/Exception
    //   8677	8691	9064	java/lang/Exception
    //   8696	8710	9064	java/lang/Exception
    //   8723	8737	9064	java/lang/Exception
    //   8740	8754	9064	java/lang/Exception
    //   8760	8777	9064	java/lang/Exception
    //   8796	8810	9064	java/lang/Exception
    //   8813	8827	9064	java/lang/Exception
    //   8833	8847	9064	java/lang/Exception
    //   8850	8864	9064	java/lang/Exception
    //   8870	8884	9064	java/lang/Exception
    //   8887	8901	9064	java/lang/Exception
    //   8904	8918	9064	java/lang/Exception
    //   8921	8935	9064	java/lang/Exception
    //   8938	8975	9064	java/lang/Exception
    //   8986	9004	9064	java/lang/Exception
    //   9250	9270	9544	org/json/JSONException
    //   9360	9371	9559	java/lang/Exception
    //   9371	9386	9559	java/lang/Exception
  }
  
  /* Error */
  public static boolean patchProcess(ArrayList<PatchesItem> paramArrayList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 12
    //   3: iconst_1
    //   4: istore 16
    //   6: iconst_1
    //   7: istore 17
    //   9: iconst_1
    //   10: istore 11
    //   12: iconst_0
    //   13: istore_3
    //   14: aload_0
    //   15: ifnull +102 -> 117
    //   18: aload_0
    //   19: invokevirtual 205	java/util/ArrayList:size	()I
    //   22: ifle +95 -> 117
    //   25: aload_0
    //   26: invokevirtual 209	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   29: astore 18
    //   31: aload 18
    //   33: invokeinterface 214 1 0
    //   38: ifeq +79 -> 117
    //   41: aload 18
    //   43: invokeinterface 218 1 0
    //   48: checkcast 771	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   51: astore 19
    //   53: aload 19
    //   55: iconst_0
    //   56: putfield 832	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:result	Z
    //   59: getstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   62: iconst_1
    //   63: if_icmpne -32 -> 31
    //   66: getstatic 164	com/chelpus/root/utils/custompatch:multidex	Z
    //   69: ifeq -38 -> 31
    //   72: aload 19
    //   74: getfield 833	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   77: ldc -124
    //   79: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq -51 -> 31
    //   85: aload 19
    //   87: new 174	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 835
    //   97: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload_3
    //   101: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: putfield 833	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   110: iload_3
    //   111: iconst_1
    //   112: iadd
    //   113: istore_3
    //   114: goto -83 -> 31
    //   117: iconst_3
    //   118: anewarray 283	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: ldc_w 427
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: ldc_w 429
    //   132: aastore
    //   133: dup
    //   134: iconst_2
    //   135: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   138: invokevirtual 443	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   141: aastore
    //   142: invokestatic 432	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   145: iload 12
    //   147: istore 13
    //   149: iload 16
    //   151: istore 14
    //   153: iload 17
    //   155: istore 15
    //   157: new 837	java/io/RandomAccessFile
    //   160: dup
    //   161: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   164: ldc_w 276
    //   167: invokespecial 840	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   170: invokevirtual 844	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   173: astore 19
    //   175: iload 12
    //   177: istore 13
    //   179: iload 16
    //   181: istore 14
    //   183: iload 17
    //   185: istore 15
    //   187: new 174	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 846
    //   197: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 19
    //   202: invokevirtual 850	java/nio/channels/FileChannel:size	()J
    //   205: invokevirtual 853	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 313	com/chelpus/Utils:sendFromRootCP	(Ljava/lang/String;)Z
    //   214: pop
    //   215: iload 12
    //   217: istore 13
    //   219: iload 16
    //   221: istore 14
    //   223: iload 17
    //   225: istore 15
    //   227: aload 19
    //   229: getstatic 859	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   232: lconst_0
    //   233: aload 19
    //   235: invokevirtual 850	java/nio/channels/FileChannel:size	()J
    //   238: l2i
    //   239: i2l
    //   240: invokevirtual 863	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   243: astore 18
    //   245: iload 12
    //   247: istore 13
    //   249: iload 16
    //   251: istore 14
    //   253: iload 17
    //   255: istore 15
    //   257: aload_0
    //   258: invokevirtual 867	java/util/ArrayList:toArray	()[Ljava/lang/Object;
    //   261: arraylength
    //   262: anewarray 771	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   265: astore 20
    //   267: iload 12
    //   269: istore 13
    //   271: iload 16
    //   273: istore 14
    //   275: iload 17
    //   277: istore 15
    //   279: aload_0
    //   280: aload_0
    //   281: invokevirtual 205	java/util/ArrayList:size	()I
    //   284: anewarray 771	com/android/vending/billing/InAppBillingService/LACK/PatchesItem
    //   287: invokevirtual 870	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   290: checkcast 872	[Lcom/android/vending/billing/InAppBillingService/LACK/PatchesItem;
    //   293: checkcast 872	[Lcom/android/vending/billing/InAppBillingService/LACK/PatchesItem;
    //   296: astore 20
    //   298: iconst_m1
    //   299: istore 7
    //   301: iconst_0
    //   302: istore 8
    //   304: iconst_0
    //   305: istore 6
    //   307: iload 12
    //   309: istore 13
    //   311: aload 18
    //   313: invokevirtual 877	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   316: ifeq +1329 -> 1645
    //   319: iload 6
    //   321: ifne +1324 -> 1645
    //   324: iload 8
    //   326: istore 4
    //   328: iload 12
    //   330: istore 13
    //   332: aload 18
    //   334: invokevirtual 880	java/nio/MappedByteBuffer:position	()I
    //   337: iload 8
    //   339: isub
    //   340: ldc_w 881
    //   343: if_icmple +46 -> 389
    //   346: iload 12
    //   348: istore 13
    //   350: new 174	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   357: ldc_w 883
    //   360: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload 18
    //   365: invokevirtual 880	java/nio/MappedByteBuffer:position	()I
    //   368: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 313	com/chelpus/Utils:sendFromRootCP	(Ljava/lang/String;)Z
    //   377: pop
    //   378: iload 12
    //   380: istore 13
    //   382: aload 18
    //   384: invokevirtual 880	java/nio/MappedByteBuffer:position	()I
    //   387: istore 4
    //   389: iload 12
    //   391: istore 13
    //   393: aload 18
    //   395: iload 7
    //   397: iconst_1
    //   398: iadd
    //   399: invokevirtual 886	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   402: pop
    //   403: iload 12
    //   405: istore 13
    //   407: aload 18
    //   409: invokevirtual 880	java/nio/MappedByteBuffer:position	()I
    //   412: istore 9
    //   414: iload 12
    //   416: istore 13
    //   418: aload 18
    //   420: invokevirtual 889	java/nio/MappedByteBuffer:get	()B
    //   423: istore_2
    //   424: iconst_0
    //   425: istore 5
    //   427: aload 18
    //   429: astore_0
    //   430: iload 6
    //   432: istore_3
    //   433: iload_3
    //   434: istore 6
    //   436: iload 9
    //   438: istore 7
    //   440: aload_0
    //   441: astore 18
    //   443: iload 4
    //   445: istore 8
    //   447: iload 12
    //   449: istore 13
    //   451: iload 5
    //   453: aload 20
    //   455: arraylength
    //   456: if_icmpge -149 -> 307
    //   459: iload 12
    //   461: istore 13
    //   463: aload_0
    //   464: iload 9
    //   466: invokevirtual 886	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   469: pop
    //   470: iload 12
    //   472: istore 13
    //   474: iload_2
    //   475: aload 20
    //   477: iload 5
    //   479: aaload
    //   480: getfield 892	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origByte	[B
    //   483: iconst_0
    //   484: baload
    //   485: if_icmpeq +83 -> 568
    //   488: iload 12
    //   490: istore 13
    //   492: aload 20
    //   494: iload 5
    //   496: aaload
    //   497: getfield 896	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   500: iconst_0
    //   501: iaload
    //   502: iconst_1
    //   503: if_icmpeq +65 -> 568
    //   506: iload 12
    //   508: istore 13
    //   510: iload_3
    //   511: istore 7
    //   513: aload_0
    //   514: astore 18
    //   516: aload 20
    //   518: iload 5
    //   520: aaload
    //   521: getfield 896	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   524: iconst_0
    //   525: iaload
    //   526: iconst_1
    //   527: if_icmple +2016 -> 2543
    //   530: iload 12
    //   532: istore 13
    //   534: iload_3
    //   535: istore 7
    //   537: aload_0
    //   538: astore 18
    //   540: iload_2
    //   541: getstatic 108	com/chelpus/root/utils/custompatch:search	Ljava/util/ArrayList;
    //   544: aload 20
    //   546: iload 5
    //   548: aaload
    //   549: getfield 896	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   552: iconst_0
    //   553: iaload
    //   554: iconst_2
    //   555: isub
    //   556: invokevirtual 899	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   559: checkcast 901	java/lang/Byte
    //   562: invokevirtual 902	java/lang/Byte:byteValue	()B
    //   565: if_icmpne +1978 -> 2543
    //   568: iload 12
    //   570: istore 13
    //   572: aload 20
    //   574: iload 5
    //   576: aaload
    //   577: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   580: iconst_0
    //   581: iaload
    //   582: ifne +18 -> 600
    //   585: iload 12
    //   587: istore 13
    //   589: aload 20
    //   591: iload 5
    //   593: aaload
    //   594: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   597: iconst_0
    //   598: iload_2
    //   599: bastore
    //   600: iload 12
    //   602: istore 13
    //   604: aload 20
    //   606: iload 5
    //   608: aaload
    //   609: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   612: iconst_0
    //   613: iaload
    //   614: iconst_1
    //   615: if_icmple +61 -> 676
    //   618: iload 12
    //   620: istore 13
    //   622: aload 20
    //   624: iload 5
    //   626: aaload
    //   627: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   630: iconst_0
    //   631: iaload
    //   632: sipush 253
    //   635: if_icmpge +41 -> 676
    //   638: iload 12
    //   640: istore 13
    //   642: aload 20
    //   644: iload 5
    //   646: aaload
    //   647: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   650: iconst_0
    //   651: getstatic 108	com/chelpus/root/utils/custompatch:search	Ljava/util/ArrayList;
    //   654: aload 20
    //   656: iload 5
    //   658: aaload
    //   659: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   662: iconst_0
    //   663: iaload
    //   664: iconst_2
    //   665: isub
    //   666: invokevirtual 899	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   669: checkcast 901	java/lang/Byte
    //   672: invokevirtual 902	java/lang/Byte:byteValue	()B
    //   675: bastore
    //   676: iload 12
    //   678: istore 13
    //   680: aload 20
    //   682: iload 5
    //   684: aaload
    //   685: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   688: iconst_0
    //   689: iaload
    //   690: sipush 253
    //   693: if_icmpne +30 -> 723
    //   696: iload 12
    //   698: istore 13
    //   700: aload 20
    //   702: iload 5
    //   704: aaload
    //   705: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   708: iconst_0
    //   709: iload_2
    //   710: bipush 15
    //   712: iand
    //   713: iload_2
    //   714: bipush 15
    //   716: iand
    //   717: bipush 16
    //   719: imul
    //   720: iadd
    //   721: i2b
    //   722: bastore
    //   723: iload 12
    //   725: istore 13
    //   727: aload 20
    //   729: iload 5
    //   731: aaload
    //   732: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   735: iconst_0
    //   736: iaload
    //   737: sipush 254
    //   740: if_icmpne +25 -> 765
    //   743: iload 12
    //   745: istore 13
    //   747: aload 20
    //   749: iload 5
    //   751: aaload
    //   752: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   755: iconst_0
    //   756: iload_2
    //   757: bipush 15
    //   759: iand
    //   760: bipush 16
    //   762: iadd
    //   763: i2b
    //   764: bastore
    //   765: iload 12
    //   767: istore 13
    //   769: aload 20
    //   771: iload 5
    //   773: aaload
    //   774: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   777: iconst_0
    //   778: iaload
    //   779: sipush 255
    //   782: if_icmpne +22 -> 804
    //   785: iload 12
    //   787: istore 13
    //   789: aload 20
    //   791: iload 5
    //   793: aaload
    //   794: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   797: iconst_0
    //   798: iload_2
    //   799: bipush 15
    //   801: iand
    //   802: i2b
    //   803: bastore
    //   804: iconst_1
    //   805: istore 6
    //   807: iload 12
    //   809: istore 13
    //   811: aload_0
    //   812: iload 9
    //   814: iconst_1
    //   815: iadd
    //   816: invokevirtual 886	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   819: pop
    //   820: iload 12
    //   822: istore 13
    //   824: aload_0
    //   825: invokevirtual 889	java/nio/MappedByteBuffer:get	()B
    //   828: istore_1
    //   829: iload 12
    //   831: istore 13
    //   833: iload_1
    //   834: aload 20
    //   836: iload 5
    //   838: aaload
    //   839: getfield 892	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origByte	[B
    //   842: iload 6
    //   844: baload
    //   845: if_icmpeq +84 -> 929
    //   848: iload 12
    //   850: istore 13
    //   852: aload 20
    //   854: iload 5
    //   856: aaload
    //   857: getfield 896	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   860: iload 6
    //   862: iaload
    //   863: iconst_1
    //   864: if_icmple +36 -> 900
    //   867: iload 12
    //   869: istore 13
    //   871: iload_1
    //   872: getstatic 108	com/chelpus/root/utils/custompatch:search	Ljava/util/ArrayList;
    //   875: aload 20
    //   877: iload 5
    //   879: aaload
    //   880: getfield 896	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   883: iload 6
    //   885: iaload
    //   886: iconst_2
    //   887: isub
    //   888: invokevirtual 899	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   891: checkcast 901	java/lang/Byte
    //   894: invokevirtual 902	java/lang/Byte:byteValue	()B
    //   897: if_icmpeq +32 -> 929
    //   900: iload 12
    //   902: istore 13
    //   904: aload 20
    //   906: iload 5
    //   908: aaload
    //   909: getfield 896	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   912: iload 6
    //   914: iaload
    //   915: istore 8
    //   917: iload_3
    //   918: istore 7
    //   920: aload_0
    //   921: astore 18
    //   923: iload 8
    //   925: iconst_1
    //   926: if_icmpne +1617 -> 2543
    //   929: iload 12
    //   931: istore 13
    //   933: aload 20
    //   935: iload 5
    //   937: aaload
    //   938: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   941: iload 6
    //   943: iaload
    //   944: ifne +19 -> 963
    //   947: iload 12
    //   949: istore 13
    //   951: aload 20
    //   953: iload 5
    //   955: aaload
    //   956: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   959: iload 6
    //   961: iload_1
    //   962: bastore
    //   963: iload 12
    //   965: istore 13
    //   967: aload 20
    //   969: iload 5
    //   971: aaload
    //   972: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   975: iload 6
    //   977: iaload
    //   978: iconst_1
    //   979: if_icmple +72 -> 1051
    //   982: iload 12
    //   984: istore 13
    //   986: aload 20
    //   988: iload 5
    //   990: aaload
    //   991: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   994: iload 6
    //   996: iaload
    //   997: sipush 253
    //   1000: if_icmpge +51 -> 1051
    //   1003: iload 12
    //   1005: istore 13
    //   1007: aload 20
    //   1009: iload 5
    //   1011: aaload
    //   1012: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   1015: iload 6
    //   1017: iaload
    //   1018: istore 7
    //   1020: iload 12
    //   1022: istore 13
    //   1024: aload 20
    //   1026: iload 5
    //   1028: aaload
    //   1029: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   1032: iload 6
    //   1034: getstatic 108	com/chelpus/root/utils/custompatch:search	Ljava/util/ArrayList;
    //   1037: iload 7
    //   1039: iconst_2
    //   1040: isub
    //   1041: invokevirtual 899	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1044: checkcast 901	java/lang/Byte
    //   1047: invokevirtual 902	java/lang/Byte:byteValue	()B
    //   1050: bastore
    //   1051: iload 12
    //   1053: istore 13
    //   1055: aload 20
    //   1057: iload 5
    //   1059: aaload
    //   1060: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   1063: iload 6
    //   1065: iaload
    //   1066: sipush 253
    //   1069: if_icmpne +31 -> 1100
    //   1072: iload 12
    //   1074: istore 13
    //   1076: aload 20
    //   1078: iload 5
    //   1080: aaload
    //   1081: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   1084: iload 6
    //   1086: iload_2
    //   1087: bipush 15
    //   1089: iand
    //   1090: iload_2
    //   1091: bipush 15
    //   1093: iand
    //   1094: bipush 16
    //   1096: imul
    //   1097: iadd
    //   1098: i2b
    //   1099: bastore
    //   1100: iload 12
    //   1102: istore 13
    //   1104: aload 20
    //   1106: iload 5
    //   1108: aaload
    //   1109: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   1112: iload 6
    //   1114: iaload
    //   1115: sipush 254
    //   1118: if_icmpne +26 -> 1144
    //   1121: iload 12
    //   1123: istore 13
    //   1125: aload 20
    //   1127: iload 5
    //   1129: aaload
    //   1130: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   1133: iload 6
    //   1135: iload_1
    //   1136: bipush 15
    //   1138: iand
    //   1139: bipush 16
    //   1141: iadd
    //   1142: i2b
    //   1143: bastore
    //   1144: iload 12
    //   1146: istore 13
    //   1148: aload 20
    //   1150: iload 5
    //   1152: aaload
    //   1153: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   1156: iload 6
    //   1158: iaload
    //   1159: sipush 255
    //   1162: if_icmpne +23 -> 1185
    //   1165: iload 12
    //   1167: istore 13
    //   1169: aload 20
    //   1171: iload 5
    //   1173: aaload
    //   1174: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   1177: iload 6
    //   1179: iload_1
    //   1180: bipush 15
    //   1182: iand
    //   1183: i2b
    //   1184: bastore
    //   1185: iload 6
    //   1187: iconst_1
    //   1188: iadd
    //   1189: istore 6
    //   1191: iload 12
    //   1193: istore 13
    //   1195: iload 6
    //   1197: aload 20
    //   1199: iload 5
    //   1201: aaload
    //   1202: getfield 892	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origByte	[B
    //   1205: arraylength
    //   1206: if_icmpne +702 -> 1908
    //   1209: iconst_0
    //   1210: istore 8
    //   1212: iload 12
    //   1214: istore 13
    //   1216: aload 20
    //   1218: iload 5
    //   1220: aaload
    //   1221: getfield 896	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origMask	[I
    //   1224: astore 18
    //   1226: iload 12
    //   1228: istore 13
    //   1230: aload 18
    //   1232: arraylength
    //   1233: istore 10
    //   1235: iconst_0
    //   1236: istore 7
    //   1238: goto +1273 -> 2511
    //   1241: iload 12
    //   1243: istore 13
    //   1245: aload 20
    //   1247: iload 5
    //   1249: aaload
    //   1250: getfield 908	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:insert	Z
    //   1253: ifne +31 -> 1284
    //   1256: aload_0
    //   1257: astore 18
    //   1259: iload 12
    //   1261: istore 13
    //   1263: aload 20
    //   1265: iload 5
    //   1267: aaload
    //   1268: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   1271: arraylength
    //   1272: aload 20
    //   1274: iload 5
    //   1276: aaload
    //   1277: getfield 892	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origByte	[B
    //   1280: arraylength
    //   1281: if_icmpeq +140 -> 1421
    //   1284: iload 12
    //   1286: istore 13
    //   1288: aload_0
    //   1289: invokevirtual 880	java/nio/MappedByteBuffer:position	()I
    //   1292: istore 6
    //   1294: iload 12
    //   1296: istore 13
    //   1298: aload 19
    //   1300: invokevirtual 850	java/nio/channels/FileChannel:size	()J
    //   1303: l2i
    //   1304: iload 6
    //   1306: isub
    //   1307: istore 7
    //   1309: iload 12
    //   1311: istore 13
    //   1313: iload 7
    //   1315: newarray <illegal type>
    //   1317: astore 18
    //   1319: iload 12
    //   1321: istore 13
    //   1323: aload_0
    //   1324: aload 18
    //   1326: iconst_0
    //   1327: iload 7
    //   1329: invokevirtual 911	java/nio/MappedByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   1332: pop
    //   1333: iload 12
    //   1335: istore 13
    //   1337: aload 18
    //   1339: invokestatic 917	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1342: astore_0
    //   1343: iload 12
    //   1345: istore 13
    //   1347: aload 19
    //   1349: aload 20
    //   1351: iload 5
    //   1353: aaload
    //   1354: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   1357: arraylength
    //   1358: aload 20
    //   1360: iload 5
    //   1362: aaload
    //   1363: getfield 892	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:origByte	[B
    //   1366: arraylength
    //   1367: isub
    //   1368: iload 6
    //   1370: iadd
    //   1371: i2l
    //   1372: invokevirtual 920	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   1375: pop
    //   1376: iload 12
    //   1378: istore 13
    //   1380: aload 19
    //   1382: aload_0
    //   1383: invokevirtual 924	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   1386: pop
    //   1387: iload 12
    //   1389: istore 13
    //   1391: aload 19
    //   1393: getstatic 859	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   1396: lconst_0
    //   1397: aload 19
    //   1399: invokevirtual 850	java/nio/channels/FileChannel:size	()J
    //   1402: l2i
    //   1403: i2l
    //   1404: invokevirtual 863	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   1407: astore 18
    //   1409: iload 12
    //   1411: istore 13
    //   1413: aload 18
    //   1415: iload 6
    //   1417: invokevirtual 886	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1420: pop
    //   1421: iload 12
    //   1423: istore 13
    //   1425: aload 19
    //   1427: iload 9
    //   1429: i2l
    //   1430: invokevirtual 920	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   1433: pop
    //   1434: iload 12
    //   1436: istore 13
    //   1438: aload 19
    //   1440: aload 20
    //   1442: iload 5
    //   1444: aaload
    //   1445: getfield 906	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repByte	[B
    //   1448: invokestatic 917	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1451: invokevirtual 924	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   1454: pop
    //   1455: iload 12
    //   1457: istore 13
    //   1459: aload 18
    //   1461: invokevirtual 928	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1464: pop
    //   1465: iload 12
    //   1467: istore 13
    //   1469: new 174	java/lang/StringBuilder
    //   1472: dup
    //   1473: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1476: ldc_w 930
    //   1479: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: iload 5
    //   1484: iconst_1
    //   1485: iadd
    //   1486: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1489: ldc_w 932
    //   1492: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: iload 9
    //   1497: invokestatic 936	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1500: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: ldc_w 938
    //   1506: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1509: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1512: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   1515: iload 12
    //   1517: istore 13
    //   1519: aload 20
    //   1521: iload 5
    //   1523: aaload
    //   1524: iconst_1
    //   1525: putfield 832	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:result	Z
    //   1528: iload 12
    //   1530: istore 13
    //   1532: iconst_1
    //   1533: putstatic 110	com/chelpus/root/utils/custompatch:patchteil	Z
    //   1536: iload_3
    //   1537: istore 7
    //   1539: goto +1004 -> 2543
    //   1542: astore 18
    //   1544: iload 12
    //   1546: istore 13
    //   1548: aload 20
    //   1550: iload 5
    //   1552: aaload
    //   1553: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   1556: iconst_0
    //   1557: iaload
    //   1558: iconst_2
    //   1559: isub
    //   1560: istore 6
    //   1562: iload 12
    //   1564: istore 13
    //   1566: new 174	java/lang/StringBuilder
    //   1569: dup
    //   1570: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1573: ldc_w 940
    //   1576: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: iload 6
    //   1581: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1584: ldc_w 942
    //   1587: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: iload 6
    //   1592: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1595: ldc_w 944
    //   1598: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1604: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   1607: goto -931 -> 676
    //   1610: astore_0
    //   1611: iload 12
    //   1613: istore 13
    //   1615: iload 16
    //   1617: istore 14
    //   1619: iload 17
    //   1621: istore 15
    //   1623: aload_0
    //   1624: invokevirtual 945	java/lang/IndexOutOfBoundsException:printStackTrace	()V
    //   1627: iload 12
    //   1629: istore 13
    //   1631: iload 16
    //   1633: istore 14
    //   1635: iload 17
    //   1637: istore 15
    //   1639: ldc_w 947
    //   1642: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   1645: iload 12
    //   1647: istore 13
    //   1649: iload 16
    //   1651: istore 14
    //   1653: iload 17
    //   1655: istore 15
    //   1657: aload 19
    //   1659: invokevirtual 948	java/nio/channels/FileChannel:close	()V
    //   1662: iload 12
    //   1664: istore 13
    //   1666: iload 16
    //   1668: istore 14
    //   1670: iload 17
    //   1672: istore 15
    //   1674: ldc_w 805
    //   1677: invokestatic 313	com/chelpus/Utils:sendFromRootCP	(Ljava/lang/String;)Z
    //   1680: pop
    //   1681: iconst_0
    //   1682: istore_3
    //   1683: iload 12
    //   1685: istore 13
    //   1687: iload 16
    //   1689: istore 14
    //   1691: iload 17
    //   1693: istore 15
    //   1695: iload_3
    //   1696: aload 20
    //   1698: arraylength
    //   1699: if_icmpge +228 -> 1927
    //   1702: iload 12
    //   1704: istore 13
    //   1706: iload 16
    //   1708: istore 14
    //   1710: iload 17
    //   1712: istore 15
    //   1714: aload 20
    //   1716: iload_3
    //   1717: aaload
    //   1718: getfield 832	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:result	Z
    //   1721: ifeq +199 -> 1920
    //   1724: iload 12
    //   1726: istore 13
    //   1728: iload 16
    //   1730: istore 14
    //   1732: iload 17
    //   1734: istore 15
    //   1736: aload 20
    //   1738: iload_3
    //   1739: aaload
    //   1740: getfield 833	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   1743: ldc -124
    //   1745: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1748: ifne +172 -> 1920
    //   1751: iload 12
    //   1753: istore 13
    //   1755: iload 16
    //   1757: istore 14
    //   1759: iload 17
    //   1761: istore 15
    //   1763: aload 20
    //   1765: arraylength
    //   1766: istore 5
    //   1768: iconst_0
    //   1769: istore 4
    //   1771: iload 4
    //   1773: iload 5
    //   1775: if_icmpge +145 -> 1920
    //   1778: aload 20
    //   1780: iload 4
    //   1782: aaload
    //   1783: astore_0
    //   1784: iload 12
    //   1786: istore 13
    //   1788: iload 16
    //   1790: istore 14
    //   1792: iload 17
    //   1794: istore 15
    //   1796: aload_0
    //   1797: getfield 833	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   1800: aload 20
    //   1802: iload_3
    //   1803: aaload
    //   1804: getfield 833	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   1807: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1810: ifeq +20 -> 1830
    //   1813: iload 12
    //   1815: istore 13
    //   1817: iload 16
    //   1819: istore 14
    //   1821: iload 17
    //   1823: istore 15
    //   1825: aload_0
    //   1826: iconst_1
    //   1827: putfield 951	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:groupResult	Z
    //   1830: iload 4
    //   1832: iconst_1
    //   1833: iadd
    //   1834: istore 4
    //   1836: goto -65 -> 1771
    //   1839: astore 18
    //   1841: iload 12
    //   1843: istore 13
    //   1845: aload 20
    //   1847: iload 5
    //   1849: aaload
    //   1850: getfield 905	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:repMask	[I
    //   1853: iload 6
    //   1855: iaload
    //   1856: iconst_2
    //   1857: isub
    //   1858: istore 7
    //   1860: iload 12
    //   1862: istore 13
    //   1864: new 174	java/lang/StringBuilder
    //   1867: dup
    //   1868: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1871: ldc_w 940
    //   1874: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1877: iload 7
    //   1879: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1882: ldc_w 942
    //   1885: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1888: iload 7
    //   1890: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1893: ldc_w 944
    //   1896: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1899: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1902: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   1905: goto -854 -> 1051
    //   1908: iload 12
    //   1910: istore 13
    //   1912: aload_0
    //   1913: invokevirtual 889	java/nio/MappedByteBuffer:get	()B
    //   1916: istore_1
    //   1917: goto -1088 -> 829
    //   1920: iload_3
    //   1921: iconst_1
    //   1922: iadd
    //   1923: istore_3
    //   1924: goto -241 -> 1683
    //   1927: iconst_0
    //   1928: istore_3
    //   1929: iload 11
    //   1931: istore 13
    //   1933: iload 11
    //   1935: istore 12
    //   1937: iload 11
    //   1939: istore 14
    //   1941: iload 11
    //   1943: istore 15
    //   1945: iload_3
    //   1946: aload 20
    //   1948: arraylength
    //   1949: if_icmpge +449 -> 2398
    //   1952: iload 11
    //   1954: istore 13
    //   1956: iload 11
    //   1958: istore 14
    //   1960: iload 11
    //   1962: istore 15
    //   1964: iload 11
    //   1966: istore 12
    //   1968: aload 20
    //   1970: iload_3
    //   1971: aaload
    //   1972: getfield 832	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:result	Z
    //   1975: ifne +596 -> 2571
    //   1978: iload 11
    //   1980: istore 13
    //   1982: iload 11
    //   1984: istore 14
    //   1986: iload 11
    //   1988: istore 15
    //   1990: aload 20
    //   1992: iload_3
    //   1993: aaload
    //   1994: getfield 833	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:group	Ljava/lang/String;
    //   1997: ldc -124
    //   1999: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2002: ifne +336 -> 2338
    //   2005: iload 11
    //   2007: istore 13
    //   2009: iload 11
    //   2011: istore 14
    //   2013: iload 11
    //   2015: istore 15
    //   2017: iload 11
    //   2019: istore 12
    //   2021: aload 20
    //   2023: iload_3
    //   2024: aaload
    //   2025: getfield 951	com/android/vending/billing/InAppBillingService/LACK/PatchesItem:groupResult	Z
    //   2028: ifne +543 -> 2571
    //   2031: iload 11
    //   2033: istore 12
    //   2035: iload 11
    //   2037: istore 13
    //   2039: iload 11
    //   2041: istore 14
    //   2043: iload 11
    //   2045: istore 15
    //   2047: getstatic 164	com/chelpus/root/utils/custompatch:multidex	Z
    //   2050: ifeq +88 -> 2138
    //   2053: iload 11
    //   2055: istore 12
    //   2057: iload 11
    //   2059: istore 13
    //   2061: iload 11
    //   2063: istore 14
    //   2065: iload 11
    //   2067: istore 15
    //   2069: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   2072: getstatic 162	com/chelpus/root/utils/custompatch:classesFiles	Ljava/util/ArrayList;
    //   2075: getstatic 162	com/chelpus/root/utils/custompatch:classesFiles	Ljava/util/ArrayList;
    //   2078: invokevirtual 205	java/util/ArrayList:size	()I
    //   2081: iconst_1
    //   2082: isub
    //   2083: invokevirtual 899	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2086: invokevirtual 952	java/io/File:equals	(Ljava/lang/Object;)Z
    //   2089: ifeq +49 -> 2138
    //   2092: iload 11
    //   2094: istore 13
    //   2096: iload 11
    //   2098: istore 14
    //   2100: iload 11
    //   2102: istore 15
    //   2104: new 174	java/lang/StringBuilder
    //   2107: dup
    //   2108: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   2111: ldc_w 930
    //   2114: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2117: iload_3
    //   2118: iconst_1
    //   2119: iadd
    //   2120: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2123: ldc_w 954
    //   2126: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2132: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   2135: iconst_0
    //   2136: istore 12
    //   2138: iload 12
    //   2140: istore 11
    //   2142: iload 12
    //   2144: istore 13
    //   2146: iload 12
    //   2148: istore 14
    //   2150: iload 12
    //   2152: istore 15
    //   2154: getstatic 168	com/chelpus/root/utils/custompatch:multilib_patch	Z
    //   2157: ifeq +88 -> 2245
    //   2160: iload 12
    //   2162: istore 11
    //   2164: iload 12
    //   2166: istore 13
    //   2168: iload 12
    //   2170: istore 14
    //   2172: iload 12
    //   2174: istore 15
    //   2176: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   2179: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   2182: getstatic 102	com/chelpus/root/utils/custompatch:arrayFile2	Ljava/util/ArrayList;
    //   2185: invokevirtual 205	java/util/ArrayList:size	()I
    //   2188: iconst_1
    //   2189: isub
    //   2190: invokevirtual 899	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2193: invokevirtual 952	java/io/File:equals	(Ljava/lang/Object;)Z
    //   2196: ifeq +49 -> 2245
    //   2199: iload 12
    //   2201: istore 13
    //   2203: iload 12
    //   2205: istore 14
    //   2207: iload 12
    //   2209: istore 15
    //   2211: new 174	java/lang/StringBuilder
    //   2214: dup
    //   2215: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   2218: ldc_w 930
    //   2221: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2224: iload_3
    //   2225: iconst_1
    //   2226: iadd
    //   2227: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2230: ldc_w 954
    //   2233: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2236: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2239: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   2242: iconst_0
    //   2243: istore 11
    //   2245: iload 11
    //   2247: istore 13
    //   2249: iload 11
    //   2251: istore 14
    //   2253: iload 11
    //   2255: istore 15
    //   2257: iload 11
    //   2259: istore 12
    //   2261: getstatic 164	com/chelpus/root/utils/custompatch:multidex	Z
    //   2264: ifne +307 -> 2571
    //   2267: iload 11
    //   2269: istore 13
    //   2271: iload 11
    //   2273: istore 14
    //   2275: iload 11
    //   2277: istore 15
    //   2279: iload 11
    //   2281: istore 12
    //   2283: getstatic 168	com/chelpus/root/utils/custompatch:multilib_patch	Z
    //   2286: ifne +285 -> 2571
    //   2289: iload 11
    //   2291: istore 13
    //   2293: iload 11
    //   2295: istore 14
    //   2297: iload 11
    //   2299: istore 15
    //   2301: new 174	java/lang/StringBuilder
    //   2304: dup
    //   2305: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   2308: ldc_w 930
    //   2311: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2314: iload_3
    //   2315: iconst_1
    //   2316: iadd
    //   2317: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2320: ldc_w 954
    //   2323: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2326: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2329: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   2332: iconst_0
    //   2333: istore 12
    //   2335: goto +236 -> 2571
    //   2338: iload 11
    //   2340: istore 13
    //   2342: iload 11
    //   2344: istore 14
    //   2346: iload 11
    //   2348: istore 15
    //   2350: new 174	java/lang/StringBuilder
    //   2353: dup
    //   2354: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   2357: ldc_w 930
    //   2360: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2363: iload_3
    //   2364: iconst_1
    //   2365: iadd
    //   2366: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2369: ldc_w 954
    //   2372: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2378: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   2381: iconst_0
    //   2382: istore 12
    //   2384: goto +187 -> 2571
    //   2387: astore_0
    //   2388: ldc_w 956
    //   2391: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   2394: iload 13
    //   2396: istore 12
    //   2398: getstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2401: iconst_1
    //   2402: if_icmpne +9 -> 2411
    //   2405: getstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2408: ifeq +11 -> 2419
    //   2411: getstatic 381	com/chelpus/root/utils/custompatch:tag	I
    //   2414: bipush 10
    //   2416: if_icmpne +18 -> 2434
    //   2419: getstatic 144	com/chelpus/root/utils/custompatch:ART	Z
    //   2422: ifne +12 -> 2434
    //   2425: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   2428: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   2431: invokestatic 959	com/chelpus/Utils:fixadlerOdex	(Ljava/io/File;Ljava/lang/String;)V
    //   2434: getstatic 112	com/chelpus/root/utils/custompatch:unpack	Z
    //   2437: ifeq +25 -> 2462
    //   2440: getstatic 138	com/chelpus/root/utils/custompatch:odexpatch	Z
    //   2443: ifne +19 -> 2462
    //   2446: getstatic 140	com/chelpus/root/utils/custompatch:OdexPatch	Z
    //   2449: ifne +13 -> 2462
    //   2452: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   2455: invokestatic 962	com/chelpus/Utils:fixadler	(Ljava/io/File;)V
    //   2458: iconst_1
    //   2459: putstatic 114	com/chelpus/root/utils/custompatch:fixunpack	Z
    //   2462: iload 12
    //   2464: ireturn
    //   2465: astore_0
    //   2466: new 174	java/lang/StringBuilder
    //   2469: dup
    //   2470: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   2473: ldc_w 964
    //   2476: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2479: aload_0
    //   2480: invokevirtual 224	java/lang/Exception:toString	()Ljava/lang/String;
    //   2483: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2486: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2489: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   2492: iload 14
    //   2494: istore 12
    //   2496: goto -98 -> 2398
    //   2499: astore_0
    //   2500: iload 15
    //   2502: istore 12
    //   2504: goto -106 -> 2398
    //   2507: astore_0
    //   2508: goto -863 -> 1645
    //   2511: iload 8
    //   2513: istore 6
    //   2515: iload 7
    //   2517: iload 10
    //   2519: if_icmpge +14 -> 2533
    //   2522: aload 18
    //   2524: iload 7
    //   2526: iaload
    //   2527: ifne +35 -> 2562
    //   2530: iconst_1
    //   2531: istore 6
    //   2533: iload 6
    //   2535: ifne -1294 -> 1241
    //   2538: iconst_1
    //   2539: istore_3
    //   2540: goto -1299 -> 1241
    //   2543: iload 5
    //   2545: iconst_1
    //   2546: iadd
    //   2547: istore 5
    //   2549: iload 7
    //   2551: istore_3
    //   2552: aload 18
    //   2554: astore_0
    //   2555: goto -2122 -> 433
    //   2558: astore_0
    //   2559: goto -914 -> 1645
    //   2562: iload 7
    //   2564: iconst_1
    //   2565: iadd
    //   2566: istore 7
    //   2568: goto -57 -> 2511
    //   2571: iload_3
    //   2572: iconst_1
    //   2573: iadd
    //   2574: istore_3
    //   2575: iload 12
    //   2577: istore 11
    //   2579: goto -650 -> 1929
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2582	0	paramArrayList	ArrayList<PatchesItem>
    //   828	1089	1	i	int
    //   423	671	2	j	int
    //   13	2562	3	k	int
    //   326	1509	4	m	int
    //   425	2123	5	n	int
    //   305	2229	6	i1	int
    //   299	2268	7	i2	int
    //   302	2210	8	i3	int
    //   412	1084	9	i4	int
    //   1233	1287	10	i5	int
    //   10	2568	11	bool1	boolean
    //   1	2575	12	bool2	boolean
    //   147	2248	13	bool3	boolean
    //   151	2342	14	bool4	boolean
    //   155	2346	15	bool5	boolean
    //   4	1814	16	bool6	boolean
    //   7	1815	17	bool7	boolean
    //   29	1431	18	localObject1	Object
    //   1542	1	18	localException1	Exception
    //   1839	714	18	localException2	Exception
    //   51	1607	19	localObject2	Object
    //   265	1757	20	arrayOfPatchesItem	PatchesItem[]
    // Exception table:
    //   from	to	target	type
    //   604	618	1542	java/lang/Exception
    //   622	638	1542	java/lang/Exception
    //   642	676	1542	java/lang/Exception
    //   311	319	1610	java/lang/IndexOutOfBoundsException
    //   332	346	1610	java/lang/IndexOutOfBoundsException
    //   350	378	1610	java/lang/IndexOutOfBoundsException
    //   382	389	1610	java/lang/IndexOutOfBoundsException
    //   393	403	1610	java/lang/IndexOutOfBoundsException
    //   407	414	1610	java/lang/IndexOutOfBoundsException
    //   418	424	1610	java/lang/IndexOutOfBoundsException
    //   451	459	1610	java/lang/IndexOutOfBoundsException
    //   463	470	1610	java/lang/IndexOutOfBoundsException
    //   474	488	1610	java/lang/IndexOutOfBoundsException
    //   492	506	1610	java/lang/IndexOutOfBoundsException
    //   516	530	1610	java/lang/IndexOutOfBoundsException
    //   540	568	1610	java/lang/IndexOutOfBoundsException
    //   572	585	1610	java/lang/IndexOutOfBoundsException
    //   589	600	1610	java/lang/IndexOutOfBoundsException
    //   604	618	1610	java/lang/IndexOutOfBoundsException
    //   622	638	1610	java/lang/IndexOutOfBoundsException
    //   642	676	1610	java/lang/IndexOutOfBoundsException
    //   680	696	1610	java/lang/IndexOutOfBoundsException
    //   700	723	1610	java/lang/IndexOutOfBoundsException
    //   727	743	1610	java/lang/IndexOutOfBoundsException
    //   747	765	1610	java/lang/IndexOutOfBoundsException
    //   769	785	1610	java/lang/IndexOutOfBoundsException
    //   789	804	1610	java/lang/IndexOutOfBoundsException
    //   811	820	1610	java/lang/IndexOutOfBoundsException
    //   824	829	1610	java/lang/IndexOutOfBoundsException
    //   833	848	1610	java/lang/IndexOutOfBoundsException
    //   852	867	1610	java/lang/IndexOutOfBoundsException
    //   871	900	1610	java/lang/IndexOutOfBoundsException
    //   904	917	1610	java/lang/IndexOutOfBoundsException
    //   933	947	1610	java/lang/IndexOutOfBoundsException
    //   951	963	1610	java/lang/IndexOutOfBoundsException
    //   967	982	1610	java/lang/IndexOutOfBoundsException
    //   986	1003	1610	java/lang/IndexOutOfBoundsException
    //   1007	1020	1610	java/lang/IndexOutOfBoundsException
    //   1024	1051	1610	java/lang/IndexOutOfBoundsException
    //   1055	1072	1610	java/lang/IndexOutOfBoundsException
    //   1076	1100	1610	java/lang/IndexOutOfBoundsException
    //   1104	1121	1610	java/lang/IndexOutOfBoundsException
    //   1125	1144	1610	java/lang/IndexOutOfBoundsException
    //   1148	1165	1610	java/lang/IndexOutOfBoundsException
    //   1169	1185	1610	java/lang/IndexOutOfBoundsException
    //   1195	1209	1610	java/lang/IndexOutOfBoundsException
    //   1216	1226	1610	java/lang/IndexOutOfBoundsException
    //   1230	1235	1610	java/lang/IndexOutOfBoundsException
    //   1245	1256	1610	java/lang/IndexOutOfBoundsException
    //   1263	1284	1610	java/lang/IndexOutOfBoundsException
    //   1288	1294	1610	java/lang/IndexOutOfBoundsException
    //   1298	1309	1610	java/lang/IndexOutOfBoundsException
    //   1313	1319	1610	java/lang/IndexOutOfBoundsException
    //   1323	1333	1610	java/lang/IndexOutOfBoundsException
    //   1337	1343	1610	java/lang/IndexOutOfBoundsException
    //   1347	1376	1610	java/lang/IndexOutOfBoundsException
    //   1380	1387	1610	java/lang/IndexOutOfBoundsException
    //   1391	1409	1610	java/lang/IndexOutOfBoundsException
    //   1413	1421	1610	java/lang/IndexOutOfBoundsException
    //   1425	1434	1610	java/lang/IndexOutOfBoundsException
    //   1438	1455	1610	java/lang/IndexOutOfBoundsException
    //   1459	1465	1610	java/lang/IndexOutOfBoundsException
    //   1469	1515	1610	java/lang/IndexOutOfBoundsException
    //   1519	1528	1610	java/lang/IndexOutOfBoundsException
    //   1532	1536	1610	java/lang/IndexOutOfBoundsException
    //   1548	1562	1610	java/lang/IndexOutOfBoundsException
    //   1566	1607	1610	java/lang/IndexOutOfBoundsException
    //   1845	1860	1610	java/lang/IndexOutOfBoundsException
    //   1864	1905	1610	java/lang/IndexOutOfBoundsException
    //   1912	1917	1610	java/lang/IndexOutOfBoundsException
    //   933	947	1839	java/lang/Exception
    //   951	963	1839	java/lang/Exception
    //   967	982	1839	java/lang/Exception
    //   986	1003	1839	java/lang/Exception
    //   1007	1020	1839	java/lang/Exception
    //   1024	1051	1839	java/lang/Exception
    //   157	175	2387	java/io/FileNotFoundException
    //   187	215	2387	java/io/FileNotFoundException
    //   227	245	2387	java/io/FileNotFoundException
    //   257	267	2387	java/io/FileNotFoundException
    //   279	298	2387	java/io/FileNotFoundException
    //   311	319	2387	java/io/FileNotFoundException
    //   332	346	2387	java/io/FileNotFoundException
    //   350	378	2387	java/io/FileNotFoundException
    //   382	389	2387	java/io/FileNotFoundException
    //   393	403	2387	java/io/FileNotFoundException
    //   407	414	2387	java/io/FileNotFoundException
    //   418	424	2387	java/io/FileNotFoundException
    //   451	459	2387	java/io/FileNotFoundException
    //   463	470	2387	java/io/FileNotFoundException
    //   474	488	2387	java/io/FileNotFoundException
    //   492	506	2387	java/io/FileNotFoundException
    //   516	530	2387	java/io/FileNotFoundException
    //   540	568	2387	java/io/FileNotFoundException
    //   572	585	2387	java/io/FileNotFoundException
    //   589	600	2387	java/io/FileNotFoundException
    //   604	618	2387	java/io/FileNotFoundException
    //   622	638	2387	java/io/FileNotFoundException
    //   642	676	2387	java/io/FileNotFoundException
    //   680	696	2387	java/io/FileNotFoundException
    //   700	723	2387	java/io/FileNotFoundException
    //   727	743	2387	java/io/FileNotFoundException
    //   747	765	2387	java/io/FileNotFoundException
    //   769	785	2387	java/io/FileNotFoundException
    //   789	804	2387	java/io/FileNotFoundException
    //   811	820	2387	java/io/FileNotFoundException
    //   824	829	2387	java/io/FileNotFoundException
    //   833	848	2387	java/io/FileNotFoundException
    //   852	867	2387	java/io/FileNotFoundException
    //   871	900	2387	java/io/FileNotFoundException
    //   904	917	2387	java/io/FileNotFoundException
    //   933	947	2387	java/io/FileNotFoundException
    //   951	963	2387	java/io/FileNotFoundException
    //   967	982	2387	java/io/FileNotFoundException
    //   986	1003	2387	java/io/FileNotFoundException
    //   1007	1020	2387	java/io/FileNotFoundException
    //   1024	1051	2387	java/io/FileNotFoundException
    //   1055	1072	2387	java/io/FileNotFoundException
    //   1076	1100	2387	java/io/FileNotFoundException
    //   1104	1121	2387	java/io/FileNotFoundException
    //   1125	1144	2387	java/io/FileNotFoundException
    //   1148	1165	2387	java/io/FileNotFoundException
    //   1169	1185	2387	java/io/FileNotFoundException
    //   1195	1209	2387	java/io/FileNotFoundException
    //   1216	1226	2387	java/io/FileNotFoundException
    //   1230	1235	2387	java/io/FileNotFoundException
    //   1245	1256	2387	java/io/FileNotFoundException
    //   1263	1284	2387	java/io/FileNotFoundException
    //   1288	1294	2387	java/io/FileNotFoundException
    //   1298	1309	2387	java/io/FileNotFoundException
    //   1313	1319	2387	java/io/FileNotFoundException
    //   1323	1333	2387	java/io/FileNotFoundException
    //   1337	1343	2387	java/io/FileNotFoundException
    //   1347	1376	2387	java/io/FileNotFoundException
    //   1380	1387	2387	java/io/FileNotFoundException
    //   1391	1409	2387	java/io/FileNotFoundException
    //   1413	1421	2387	java/io/FileNotFoundException
    //   1425	1434	2387	java/io/FileNotFoundException
    //   1438	1455	2387	java/io/FileNotFoundException
    //   1459	1465	2387	java/io/FileNotFoundException
    //   1469	1515	2387	java/io/FileNotFoundException
    //   1519	1528	2387	java/io/FileNotFoundException
    //   1532	1536	2387	java/io/FileNotFoundException
    //   1548	1562	2387	java/io/FileNotFoundException
    //   1566	1607	2387	java/io/FileNotFoundException
    //   1623	1627	2387	java/io/FileNotFoundException
    //   1639	1645	2387	java/io/FileNotFoundException
    //   1657	1662	2387	java/io/FileNotFoundException
    //   1674	1681	2387	java/io/FileNotFoundException
    //   1695	1702	2387	java/io/FileNotFoundException
    //   1714	1724	2387	java/io/FileNotFoundException
    //   1736	1751	2387	java/io/FileNotFoundException
    //   1763	1768	2387	java/io/FileNotFoundException
    //   1796	1813	2387	java/io/FileNotFoundException
    //   1825	1830	2387	java/io/FileNotFoundException
    //   1845	1860	2387	java/io/FileNotFoundException
    //   1864	1905	2387	java/io/FileNotFoundException
    //   1912	1917	2387	java/io/FileNotFoundException
    //   1945	1952	2387	java/io/FileNotFoundException
    //   1968	1978	2387	java/io/FileNotFoundException
    //   1990	2005	2387	java/io/FileNotFoundException
    //   2021	2031	2387	java/io/FileNotFoundException
    //   2047	2053	2387	java/io/FileNotFoundException
    //   2069	2092	2387	java/io/FileNotFoundException
    //   2104	2135	2387	java/io/FileNotFoundException
    //   2154	2160	2387	java/io/FileNotFoundException
    //   2176	2199	2387	java/io/FileNotFoundException
    //   2211	2242	2387	java/io/FileNotFoundException
    //   2261	2267	2387	java/io/FileNotFoundException
    //   2283	2289	2387	java/io/FileNotFoundException
    //   2301	2332	2387	java/io/FileNotFoundException
    //   2350	2381	2387	java/io/FileNotFoundException
    //   157	175	2465	java/lang/Exception
    //   187	215	2465	java/lang/Exception
    //   227	245	2465	java/lang/Exception
    //   257	267	2465	java/lang/Exception
    //   279	298	2465	java/lang/Exception
    //   1623	1627	2465	java/lang/Exception
    //   1639	1645	2465	java/lang/Exception
    //   1657	1662	2465	java/lang/Exception
    //   1674	1681	2465	java/lang/Exception
    //   1695	1702	2465	java/lang/Exception
    //   1714	1724	2465	java/lang/Exception
    //   1736	1751	2465	java/lang/Exception
    //   1763	1768	2465	java/lang/Exception
    //   1796	1813	2465	java/lang/Exception
    //   1825	1830	2465	java/lang/Exception
    //   1945	1952	2465	java/lang/Exception
    //   1968	1978	2465	java/lang/Exception
    //   1990	2005	2465	java/lang/Exception
    //   2021	2031	2465	java/lang/Exception
    //   2047	2053	2465	java/lang/Exception
    //   2069	2092	2465	java/lang/Exception
    //   2104	2135	2465	java/lang/Exception
    //   2154	2160	2465	java/lang/Exception
    //   2176	2199	2465	java/lang/Exception
    //   2211	2242	2465	java/lang/Exception
    //   2261	2267	2465	java/lang/Exception
    //   2283	2289	2465	java/lang/Exception
    //   2301	2332	2465	java/lang/Exception
    //   2350	2381	2465	java/lang/Exception
    //   157	175	2499	java/nio/BufferUnderflowException
    //   187	215	2499	java/nio/BufferUnderflowException
    //   227	245	2499	java/nio/BufferUnderflowException
    //   257	267	2499	java/nio/BufferUnderflowException
    //   279	298	2499	java/nio/BufferUnderflowException
    //   1623	1627	2499	java/nio/BufferUnderflowException
    //   1639	1645	2499	java/nio/BufferUnderflowException
    //   1657	1662	2499	java/nio/BufferUnderflowException
    //   1674	1681	2499	java/nio/BufferUnderflowException
    //   1695	1702	2499	java/nio/BufferUnderflowException
    //   1714	1724	2499	java/nio/BufferUnderflowException
    //   1736	1751	2499	java/nio/BufferUnderflowException
    //   1763	1768	2499	java/nio/BufferUnderflowException
    //   1796	1813	2499	java/nio/BufferUnderflowException
    //   1825	1830	2499	java/nio/BufferUnderflowException
    //   1945	1952	2499	java/nio/BufferUnderflowException
    //   1968	1978	2499	java/nio/BufferUnderflowException
    //   1990	2005	2499	java/nio/BufferUnderflowException
    //   2021	2031	2499	java/nio/BufferUnderflowException
    //   2047	2053	2499	java/nio/BufferUnderflowException
    //   2069	2092	2499	java/nio/BufferUnderflowException
    //   2104	2135	2499	java/nio/BufferUnderflowException
    //   2154	2160	2499	java/nio/BufferUnderflowException
    //   2176	2199	2499	java/nio/BufferUnderflowException
    //   2211	2242	2499	java/nio/BufferUnderflowException
    //   2261	2267	2499	java/nio/BufferUnderflowException
    //   2283	2289	2499	java/nio/BufferUnderflowException
    //   2301	2332	2499	java/nio/BufferUnderflowException
    //   2350	2381	2499	java/nio/BufferUnderflowException
    //   311	319	2507	java/lang/Exception
    //   332	346	2507	java/lang/Exception
    //   350	378	2507	java/lang/Exception
    //   382	389	2507	java/lang/Exception
    //   393	403	2507	java/lang/Exception
    //   407	414	2507	java/lang/Exception
    //   418	424	2507	java/lang/Exception
    //   451	459	2507	java/lang/Exception
    //   463	470	2507	java/lang/Exception
    //   474	488	2507	java/lang/Exception
    //   492	506	2507	java/lang/Exception
    //   516	530	2507	java/lang/Exception
    //   540	568	2507	java/lang/Exception
    //   572	585	2507	java/lang/Exception
    //   589	600	2507	java/lang/Exception
    //   680	696	2507	java/lang/Exception
    //   700	723	2507	java/lang/Exception
    //   727	743	2507	java/lang/Exception
    //   747	765	2507	java/lang/Exception
    //   769	785	2507	java/lang/Exception
    //   789	804	2507	java/lang/Exception
    //   811	820	2507	java/lang/Exception
    //   824	829	2507	java/lang/Exception
    //   833	848	2507	java/lang/Exception
    //   852	867	2507	java/lang/Exception
    //   871	900	2507	java/lang/Exception
    //   904	917	2507	java/lang/Exception
    //   1055	1072	2507	java/lang/Exception
    //   1076	1100	2507	java/lang/Exception
    //   1104	1121	2507	java/lang/Exception
    //   1125	1144	2507	java/lang/Exception
    //   1148	1165	2507	java/lang/Exception
    //   1169	1185	2507	java/lang/Exception
    //   1195	1209	2507	java/lang/Exception
    //   1216	1226	2507	java/lang/Exception
    //   1230	1235	2507	java/lang/Exception
    //   1245	1256	2507	java/lang/Exception
    //   1263	1284	2507	java/lang/Exception
    //   1288	1294	2507	java/lang/Exception
    //   1298	1309	2507	java/lang/Exception
    //   1313	1319	2507	java/lang/Exception
    //   1323	1333	2507	java/lang/Exception
    //   1337	1343	2507	java/lang/Exception
    //   1347	1376	2507	java/lang/Exception
    //   1380	1387	2507	java/lang/Exception
    //   1391	1409	2507	java/lang/Exception
    //   1413	1421	2507	java/lang/Exception
    //   1425	1434	2507	java/lang/Exception
    //   1438	1455	2507	java/lang/Exception
    //   1459	1465	2507	java/lang/Exception
    //   1469	1515	2507	java/lang/Exception
    //   1519	1528	2507	java/lang/Exception
    //   1532	1536	2507	java/lang/Exception
    //   1548	1562	2507	java/lang/Exception
    //   1566	1607	2507	java/lang/Exception
    //   1845	1860	2507	java/lang/Exception
    //   1864	1905	2507	java/lang/Exception
    //   1912	1917	2507	java/lang/Exception
    //   311	319	2558	java/nio/BufferUnderflowException
    //   332	346	2558	java/nio/BufferUnderflowException
    //   350	378	2558	java/nio/BufferUnderflowException
    //   382	389	2558	java/nio/BufferUnderflowException
    //   393	403	2558	java/nio/BufferUnderflowException
    //   407	414	2558	java/nio/BufferUnderflowException
    //   418	424	2558	java/nio/BufferUnderflowException
    //   451	459	2558	java/nio/BufferUnderflowException
    //   463	470	2558	java/nio/BufferUnderflowException
    //   474	488	2558	java/nio/BufferUnderflowException
    //   492	506	2558	java/nio/BufferUnderflowException
    //   516	530	2558	java/nio/BufferUnderflowException
    //   540	568	2558	java/nio/BufferUnderflowException
    //   572	585	2558	java/nio/BufferUnderflowException
    //   589	600	2558	java/nio/BufferUnderflowException
    //   604	618	2558	java/nio/BufferUnderflowException
    //   622	638	2558	java/nio/BufferUnderflowException
    //   642	676	2558	java/nio/BufferUnderflowException
    //   680	696	2558	java/nio/BufferUnderflowException
    //   700	723	2558	java/nio/BufferUnderflowException
    //   727	743	2558	java/nio/BufferUnderflowException
    //   747	765	2558	java/nio/BufferUnderflowException
    //   769	785	2558	java/nio/BufferUnderflowException
    //   789	804	2558	java/nio/BufferUnderflowException
    //   811	820	2558	java/nio/BufferUnderflowException
    //   824	829	2558	java/nio/BufferUnderflowException
    //   833	848	2558	java/nio/BufferUnderflowException
    //   852	867	2558	java/nio/BufferUnderflowException
    //   871	900	2558	java/nio/BufferUnderflowException
    //   904	917	2558	java/nio/BufferUnderflowException
    //   933	947	2558	java/nio/BufferUnderflowException
    //   951	963	2558	java/nio/BufferUnderflowException
    //   967	982	2558	java/nio/BufferUnderflowException
    //   986	1003	2558	java/nio/BufferUnderflowException
    //   1007	1020	2558	java/nio/BufferUnderflowException
    //   1024	1051	2558	java/nio/BufferUnderflowException
    //   1055	1072	2558	java/nio/BufferUnderflowException
    //   1076	1100	2558	java/nio/BufferUnderflowException
    //   1104	1121	2558	java/nio/BufferUnderflowException
    //   1125	1144	2558	java/nio/BufferUnderflowException
    //   1148	1165	2558	java/nio/BufferUnderflowException
    //   1169	1185	2558	java/nio/BufferUnderflowException
    //   1195	1209	2558	java/nio/BufferUnderflowException
    //   1216	1226	2558	java/nio/BufferUnderflowException
    //   1230	1235	2558	java/nio/BufferUnderflowException
    //   1245	1256	2558	java/nio/BufferUnderflowException
    //   1263	1284	2558	java/nio/BufferUnderflowException
    //   1288	1294	2558	java/nio/BufferUnderflowException
    //   1298	1309	2558	java/nio/BufferUnderflowException
    //   1313	1319	2558	java/nio/BufferUnderflowException
    //   1323	1333	2558	java/nio/BufferUnderflowException
    //   1337	1343	2558	java/nio/BufferUnderflowException
    //   1347	1376	2558	java/nio/BufferUnderflowException
    //   1380	1387	2558	java/nio/BufferUnderflowException
    //   1391	1409	2558	java/nio/BufferUnderflowException
    //   1413	1421	2558	java/nio/BufferUnderflowException
    //   1425	1434	2558	java/nio/BufferUnderflowException
    //   1438	1455	2558	java/nio/BufferUnderflowException
    //   1459	1465	2558	java/nio/BufferUnderflowException
    //   1469	1515	2558	java/nio/BufferUnderflowException
    //   1519	1528	2558	java/nio/BufferUnderflowException
    //   1532	1536	2558	java/nio/BufferUnderflowException
    //   1548	1562	2558	java/nio/BufferUnderflowException
    //   1566	1607	2558	java/nio/BufferUnderflowException
    //   1845	1860	2558	java/nio/BufferUnderflowException
    //   1864	1905	2558	java/nio/BufferUnderflowException
    //   1912	1917	2558	java/nio/BufferUnderflowException
  }
  
  /* Error */
  public static void searchDalvik(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 970	com/chelpus/Utils:getFileDalvikCache	(Ljava/lang/String;)Ljava/io/File;
    //   4: astore_0
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_0
    //   10: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   13: getstatic 138	com/chelpus/root/utils/custompatch:odexpatch	Z
    //   16: ifeq +20 -> 36
    //   19: new 190	java/io/File
    //   22: dup
    //   23: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   26: iconst_1
    //   27: invokestatic 337	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   30: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   36: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   39: invokevirtual 198	java/io/File:exists	()Z
    //   42: ifne +20 -> 62
    //   45: new 190	java/io/File
    //   48: dup
    //   49: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   52: iconst_1
    //   53: invokestatic 337	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   56: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   62: getstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   65: invokevirtual 198	java/io/File:exists	()Z
    //   68: ifne +28 -> 96
    //   71: new 250	java/io/FileNotFoundException
    //   74: dup
    //   75: invokespecial 971	java/io/FileNotFoundException:<init>	()V
    //   78: athrow
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 972	java/io/FileNotFoundException:printStackTrace	()V
    //   84: getstatic 136	com/chelpus/root/utils/custompatch:system	Z
    //   87: ifne +9 -> 96
    //   90: ldc_w 974
    //   93: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   96: return
    //   97: astore_0
    //   98: new 190	java/io/File
    //   101: dup
    //   102: getstatic 128	com/chelpus/root/utils/custompatch:dirapp	Ljava/lang/String;
    //   105: iconst_1
    //   106: invokestatic 337	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   109: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   112: putstatic 343	com/chelpus/root/utils/custompatch:localFile2	Ljava/io/File;
    //   115: goto -53 -> 62
    //   118: astore_0
    //   119: new 174	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   126: ldc -124
    //   128: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 226	com/chelpus/root/utils/custompatch:addToLog	(Ljava/lang/String;)V
    //   141: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   9	13	79	java/io/FileNotFoundException
    //   13	36	79	java/io/FileNotFoundException
    //   36	62	79	java/io/FileNotFoundException
    //   62	79	79	java/io/FileNotFoundException
    //   98	115	79	java/io/FileNotFoundException
    //   36	62	97	java/lang/Exception
    //   9	13	118	java/lang/Exception
    //   13	36	118	java/lang/Exception
    //   62	79	118	java/lang/Exception
    //   98	115	118	java/lang/Exception
  }
  
  public static void searchDalvikOdex(String paramString1, String paramString2)
    throws FileNotFoundException
  {
    searchDalvik(paramString1);
    try
    {
      if (!odexpatch)
      {
        paramString1 = Utils.getOdexForCreate(paramString2, uid);
        paramString2 = new File(paramString1);
        if (paramString2.exists()) {
          paramString2.delete();
        }
        paramString2 = new File(paramString1.replace("-2", "-1"));
        if (paramString2.exists()) {
          paramString2.delete();
        }
        paramString2 = new File(paramString1.replace("-1", "-2"));
        if (paramString2.exists()) {
          paramString2.delete();
        }
        paramString2 = new File(paramString1.replace("-2", ""));
        if (paramString2.exists()) {
          paramString2.delete();
        }
        paramString2 = new File(paramString1.replace("-1", ""));
        if (paramString2.exists()) {
          paramString2.delete();
        }
        paramString1 = new File(paramString1);
        Utils.copyFile(localFile2, paramString1);
        if ((paramString1.exists()) && (paramString1.length() == localFile2.length()))
        {
          Utils.run_all_no_root(new String[] { "chmod", "644", paramString1.getAbsolutePath() });
          Utils.run_all_no_root(new String[] { "chown", "1000." + uid, paramString1.getAbsolutePath() });
          Utils.run_all_no_root(new String[] { "chown", "1000:" + uid, paramString1.getAbsolutePath() });
          localFile2 = paramString1;
        }
      }
      else
      {
        localFile2 = new File(Utils.getPlaceForOdex(dirapp, true));
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      addToLog("Exception e" + paramString1.toString());
    }
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
                break label1218;
              }
              bool2 = bool5;
              bool3 = bool6;
              if (j != paramArrayList[k].origByte[0])
              {
                bool2 = bool5;
                bool3 = bool6;
                if (paramArrayList[k].origMask[0] == 0) {
                  break label1218;
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
          addToLog("Search byte error: " + localException2);
          bool2 = bool5;
          bool3 = bool6;
          bool4 = bool7;
          ((FileChannel)localObject).close();
          k = 0;
        }
      }
      label633:
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      if (k >= paramArrayList.length) {
        break label1236;
      }
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      if (paramArrayList[k].result) {
        break label1225;
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
        addToLog("Error LP: Program files are not found!\nMove Program to internal storage.");
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
      addToLog("Exception e" + paramArrayList.toString());
      return bool3;
    }
    catch (Exception paramArrayList)
    {
      label736:
      addToLog("Exception e" + paramArrayList.toString());
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
        break label1241;
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
              break label1247;
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
        label1218:
        k += 1;
        break;
        label1225:
        k += 1;
        bool1 = bool5;
        break label633;
        label1236:
        k = 0;
        break label736;
        label1241:
        m = 0;
        continue;
      }
      label1247:
      m += 1;
    }
  }
  
  public static void searchfile(String paramString1, String paramString2)
  {
    do
    {
      try
      {
        if ((new File(paramString2).exists()) && (!paramString2.startsWith("/mnt/sdcard")))
        {
          localFile2 = new File(paramString2);
          return;
        }
        if ((!paramString2.startsWith("/mnt/sdcard")) && (!paramString2.startsWith("/sdcard"))) {
          break label380;
        }
        paramString1 = new ArrayList();
        paramString1.add("/mnt/sdcard/");
        paramString1.add("/storage/emulated/legacy/");
        paramString1.add("/storage/emulated/0/");
        paramString1.add("/storage/sdcard0/");
        paramString1.add("/storage/sdcard/");
        paramString1.add("/storage/sdcard1/");
        paramString1.add("/sdcard/");
        paramString1 = paramString1.iterator();
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          try
          {
            String str;
            boolean bool;
            new File(str + "test.tmp").createNewFile();
            if (new File(str + "test.tmp").exists())
            {
              new File(str + "test.tmp").delete();
              if (localFile2.exists()) {
                break;
              }
              throw new FileNotFoundException();
              paramString1 = paramString1;
              addToLog("Error LP: " + paramString2 + " are not found!\n\nRun the application file to appear in the folder with the data.!\n");
              return;
            }
            localFile2 = new File("/figjvaja_papka");
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            localFile2 = new File("/figjvaja_papka");
          }
        }
      }
      catch (Exception paramString1)
      {
        addToLog("Exception e" + paramString1.toString());
        return;
      }
      if (!paramString1.hasNext()) {
        break;
      }
      str = (String)paramString1.next();
      localFile2 = new File(paramString2.replace("/mnt/sdcard/", str));
      bool = localFile2.exists();
    } while (!bool);
    label380:
    if ((paramString2.startsWith("/data/data/" + pkgName + "/shared_prefs/")) || (paramString2.startsWith("/dbdata/databases/" + pkgName + "/shared_prefs/")) || (paramString2.startsWith("/shared_prefs/")))
    {
      paramString1 = "";
      if (paramString2.startsWith("/data/data/" + pkgName + "/shared_prefs/")) {
        paramString1 = "/data/data/" + pkgName + "/shared_prefs/";
      }
      if (paramString2.startsWith("/dbdata/databases/" + pkgName + "/shared_prefs/")) {
        paramString1 = "/dbdata/databases/" + pkgName + "/shared_prefs/";
      }
      if (paramString2.startsWith("/shared_prefs/")) {
        paramString1 = "/shared_prefs/";
      }
      localFile2 = new File(paramString2.replace(paramString1, "/data/data/" + pkgName + "/shared_prefs/"));
      if (!localFile2.exists()) {
        localFile2 = new File(paramString2.replace(paramString1, "/dbdata/databases/" + pkgName + "/shared_prefs/"));
      }
      if (!localFile2.exists()) {
        throw new FileNotFoundException();
      }
    }
    else
    {
      localFile2 = new File("/data/data/" + paramString1 + paramString2);
      if (!localFile2.exists()) {
        localFile2 = new File("/mnt/asec/" + paramString1 + "-1" + paramString2);
      }
      if (!localFile2.exists()) {
        localFile2 = new File("/mnt/asec/" + paramString1 + "-2" + paramString2);
      }
      if (!localFile2.exists()) {
        localFile2 = new File("/mnt/asec/" + paramString1 + paramString2);
      }
      if (!localFile2.exists()) {
        localFile2 = new File("/sd-ext/data/" + paramString1 + paramString2);
      }
      if (!localFile2.exists()) {
        localFile2 = new File("/data/sdext2/" + paramString1 + paramString2);
      }
      if (!localFile2.exists()) {
        localFile2 = new File("/data/sdext1/" + paramString1 + paramString2);
      }
      if (!localFile2.exists()) {
        localFile2 = new File("/data/sdext/" + paramString1 + paramString2);
      }
      if (!localFile2.exists())
      {
        paramString1 = new Utils("fgh").findFile(new File("/data/data/" + paramString1), paramString2);
        if (!paramString1.equals("")) {
          localFile2 = new File(paramString1);
        }
      }
      if (!localFile2.exists()) {
        throw new FileNotFoundException();
      }
    }
  }
  
  public static ArrayList<File> searchlib(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Object localObject2;
      int i;
      try
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add("/data/data/");
        ((ArrayList)localObject2).add("/mnt/asec/");
        ((ArrayList)localObject2).add("/sd-ext/data/");
        ((ArrayList)localObject2).add("/data/sdext2/");
        ((ArrayList)localObject2).add("/data/sdext1/");
        ((ArrayList)localObject2).add("/data/sdext/");
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(paramString1);
        ((ArrayList)localObject1).add(paramString1 + "-1");
        ((ArrayList)localObject1).add(paramString1 + "-2");
        if (!paramString2.trim().equals("*")) {
          break label793;
        }
        multilib_patch = true;
        paramString2 = new File("/data/data/" + paramString1 + "/lib/").listFiles();
        int j;
        if ((paramString2 != null) && (paramString2.length > 0))
        {
          j = paramString2.length;
          i = 0;
          if (i < j)
          {
            localObject1 = paramString2[i];
            if ((((File)localObject1).length() <= 0L) || (!((File)localObject1).getName().endsWith(".so"))) {
              break label1526;
            }
            Utils.addFileToList((File)localObject1, localArrayList);
            break label1526;
          }
        }
        paramString2 = new File(paramString3).getName().replace(paramString1, "").replace(".apk", "");
        if (new File("/data/app-lib").exists())
        {
          paramString3 = new File("/data/app-lib/" + paramString1 + paramString2 + "/").listFiles();
          if ((paramString3 != null) && (paramString3.length > 0))
          {
            j = paramString3.length;
            i = 0;
            if (i < j)
            {
              localObject1 = paramString3[i];
              if ((((File)localObject1).length() <= 0L) || (!((File)localObject1).getName().endsWith(".so"))) {
                break label1533;
              }
              Utils.addFileToList((File)localObject1, localArrayList);
              break label1533;
            }
          }
        }
        localObject1 = ((ArrayList)localObject2).iterator();
      }
      catch (FileNotFoundException paramString1)
      {
        addToLog("Error LP: " + localFile2 + " are not found!\n\nCheck the location libraries to solve problems!\n");
        paramString3 = null;
        return paramString3;
        localObject2 = new File(paramString3 + paramString1 + "/");
        if (!((File)localObject2).exists()) {
          continue;
        }
        localObject3 = new Utils("sdf");
        paramString3 = new ArrayList();
        localObject2 = ((Utils)localObject3).findFileEndText((File)localObject2, ".so", paramString3);
        if ((((String)localObject2).equals("")) || (paramString3.size() <= 0)) {
          continue;
        }
        paramString3 = paramString3.iterator();
        if (!paramString3.hasNext()) {
          continue;
        }
        Utils.addFileToList((File)paramString3.next(), localArrayList);
        addToLog("Found lib:" + (String)localObject2);
        continue;
      }
      catch (Exception paramString1)
      {
        addToLog("Exception e" + paramString1.toString());
        return null;
      }
      paramString3 = localArrayList;
      Object localObject3;
      Object localObject4;
      if (((Iterator)localObject1).hasNext())
      {
        paramString3 = (String)((Iterator)localObject1).next();
        localObject3 = new File(paramString3 + paramString1 + paramString2 + "/");
        if (!((File)localObject3).exists()) {
          continue;
        }
        localObject4 = new Utils("sdf");
        localObject2 = new ArrayList();
        localObject3 = ((Utils)localObject4).findFileEndText((File)localObject3, ".so", (ArrayList)localObject2);
        if ((((String)localObject3).equals("")) || (((ArrayList)localObject2).size() <= 0)) {
          continue;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        Utils.addFileToList((File)((Iterator)localObject2).next(), localArrayList);
        addToLog("Found lib:" + (String)localObject3);
        continue;
      }
      label793:
      localFile2 = new File("/data/data/" + paramString1 + "/lib/" + paramString2);
      if (!localFile2.exists())
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            Object localObject5 = (String)((Iterator)localObject4).next();
            localObject5 = new File((String)localObject3 + (String)localObject5);
            if (((File)localObject5).exists())
            {
              localObject5 = new Utils("sdf").findFile((File)localObject5, paramString2);
              if (!((String)localObject5).equals(""))
              {
                localFile2 = new File((String)localObject5);
                Utils.addFileToList(localFile2, localArrayList);
                addToLog("Found lib:" + (String)localObject5);
              }
            }
          }
        }
      }
      Utils.addFileToList(localFile2, localArrayList);
      Object localObject1 = Utils.getDirs(new File(paramString3));
      if (new File(((File)localObject1).getAbsoluteFile() + "/lib").exists())
      {
        localFile2 = new File(((File)localObject1).getAbsoluteFile() + "/lib/arm/" + paramString2);
        if (localFile2.exists()) {
          Utils.addFileToList(localFile2, localArrayList);
        }
        localFile2 = new File(((File)localObject1).getAbsoluteFile() + "/lib/arm64/" + paramString2);
        if (localFile2.exists()) {
          Utils.addFileToList(localFile2, localArrayList);
        }
        localFile2 = new File(((File)localObject1).getAbsoluteFile() + "/lib/x86/" + paramString2);
        if (localFile2.exists()) {
          Utils.addFileToList(localFile2, localArrayList);
        }
        localFile2 = new File(((File)localObject1).getAbsoluteFile() + "/lib/x86_64/" + paramString2);
        if (localFile2.exists()) {
          Utils.addFileToList(localFile2, localArrayList);
        }
        localFile2 = new File(((File)localObject1).getAbsoluteFile() + "/lib/mips/" + paramString2);
        if (localFile2.exists()) {
          Utils.addFileToList(localFile2, localArrayList);
        }
      }
      if (!localFile2.exists()) {
        localFile2 = new File("/system/lib/" + paramString2);
      }
      if (localArrayList.size() == 0) {
        throw new FileNotFoundException();
      }
      localObject1 = new File(paramString3).getName().replace(paramString1, "").replace(".apk", "");
      paramString3 = localArrayList;
      if (new File("/data/app-lib/" + paramString1 + (String)localObject1 + "/" + paramString2).exists())
      {
        Utils.addFileToList(new File("/data/app-lib/" + paramString1 + (String)localObject1 + "/" + paramString2), localArrayList);
        return localArrayList;
        label1526:
        i += 1;
        continue;
        label1533:
        i += 1;
      }
    }
  }
  
  public static void unzip(File paramFile)
  {
    classesFiles.clear();
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
            localObject3 = new FileOutputStream(dir + "/" + (String)localObject1);
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
          paramFile.extractFile("classes.dex", dir);
          Utils.run_all_no_root(new String[] { "chmod", "777", dir + "/" + "classes.dex" });
          classesFiles.add(new File(dir + "/" + "classes.dex"));
          paramFile.extractFile("AndroidManifest.xml", dir);
          Utils.run_all_no_root(new String[] { "chmod", "777", dir + "/" + "AndroidManifest.xml" });
          addToLog("Exception e" + localException.toString());
          return;
          localZipInputStream.closeEntry();
          ((FileOutputStream)localObject3).close();
          classesFiles.add(new File(dir + "/" + localException));
          Utils.run_all_no_root(new String[] { "chmod", "777", dir + "/" + localException });
          if (localException.equals("AndroidManifest.xml"))
          {
            localObject2 = new FileOutputStream(dir + "/" + "AndroidManifest.xml");
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
            Utils.run_all_no_root(new String[] { "chmod", "777", dir + "/" + "AndroidManifest.xml" });
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
            paramFile.printStackTrace();
            addToLog("Error LP: Error classes.dex decompress! " + paramFile);
            addToLog("Exception e1" + ((Exception)localObject2).toString());
          }
        }
        catch (Exception paramFile)
        {
          for (;;)
          {
            Object localObject2;
            paramFile.printStackTrace();
            addToLog("Error LP: Error classes.dex decompress! " + paramFile);
            addToLog("Exception e1" + ((Exception)localObject2).toString());
            continue;
            if ((0 == 0) || (i == 0)) {}
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/custompatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */