package com.android.vending.billing.InAppBillingService.LACK;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import com.chelpus.Utils;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class DatabaseHelper
  extends SQLiteOpenHelper
{
  static final String ads = "ads";
  static final String billing = "billing";
  static final String boot_ads = "boot_ads";
  static final String boot_custom = "boot_custom";
  static final String boot_lvl = "boot_lvl";
  static final String boot_manual = "boot_manual";
  public static Context contextdb = null;
  static final String custom = "custom";
  public static SQLiteDatabase db = null;
  static final String dbName = "PackagesDB";
  public static boolean getPackage = false;
  static final String hidden = "hidden";
  static final String icon = "icon";
  static final String lvl = "lvl";
  static final String modified = "modified";
  static final String odex = "odex";
  static final String packagesTable = "Packages";
  static final String pkgLabel = "pkgLabel";
  static final String pkgName = "pkgName";
  public static boolean savePackage = false;
  static final String statusi = "statusi";
  static final String stored = "stored";
  static final String storepref = "storepref";
  static final String system = "system";
  static final String updatetime = "updatetime";
  
  public DatabaseHelper(Context paramContext)
  {
    super(paramContext, "PackagesDB", null, 42);
    contextdb = paramContext;
    try
    {
      db = getWritableDatabase();
      System.out.println("SQLite base version is " + db.getVersion());
      if (db.getVersion() != 42)
      {
        System.out.println("SQL delete and recreate.");
        db.execSQL("DROP TABLE IF EXISTS Packages");
        onCreate(db);
      }
      return;
    }
    catch (SQLiteException paramContext)
    {
      do
      {
        paramContext.printStackTrace();
        System.out.println("LP: Delete bad database.");
      } while ((!paramContext.toString().contains("Could not open")) || (!listAppsFragment.su));
      new Utils("").cmdRoot(new String[] { "rm -r /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases" });
      new Utils("").cmdRoot(new String[] { "rm /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases" });
    }
  }
  
  public void deletePackage(PkgListItem paramPkgListItem)
  {
    try
    {
      db.delete("Packages", "pkgName = '" + paramPkgListItem.pkgName + "'", null);
      return;
    }
    catch (Exception paramPkgListItem)
    {
      System.out.println("LuckyPatcher-Error: deletePackage " + paramPkgListItem);
    }
  }
  
  public void deletePackage(String paramString)
  {
    try
    {
      db.delete("Packages", "pkgName = '" + paramString + "'", null);
      return;
    }
    catch (Exception paramString)
    {
      System.out.println("LuckyPatcher-Error: deletePackage " + paramString);
    }
  }
  
  /* Error */
  public java.util.ArrayList<PkgListItem> getPackage(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 199	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 200	java/util/ArrayList:<init>	()V
    //   7: astore 22
    //   9: aload 22
    //   11: invokevirtual 203	java/util/ArrayList:clear	()V
    //   14: invokestatic 207	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   17: astore 24
    //   19: iconst_1
    //   20: putstatic 65	com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper:getPackage	Z
    //   23: getstatic 63	com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper:db	Landroid/database/sqlite/SQLiteDatabase;
    //   26: ldc 42
    //   28: bipush 19
    //   30: anewarray 135	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc 46
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc 44
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: ldc 51
    //   47: aastore
    //   48: dup
    //   49: iconst_3
    //   50: ldc 53
    //   52: aastore
    //   53: dup
    //   54: iconst_4
    //   55: ldc 31
    //   57: aastore
    //   58: dup
    //   59: iconst_5
    //   60: ldc 49
    //   62: aastore
    //   63: dup
    //   64: bipush 6
    //   66: ldc 11
    //   68: aastore
    //   69: dup
    //   70: bipush 7
    //   72: ldc 15
    //   74: aastore
    //   75: dup
    //   76: bipush 8
    //   78: ldc 13
    //   80: aastore
    //   81: dup
    //   82: bipush 9
    //   84: ldc 17
    //   86: aastore
    //   87: dup
    //   88: bipush 10
    //   90: ldc 21
    //   92: aastore
    //   93: dup
    //   94: bipush 11
    //   96: ldc 35
    //   98: aastore
    //   99: dup
    //   100: bipush 12
    //   102: ldc 7
    //   104: aastore
    //   105: dup
    //   106: bipush 13
    //   108: ldc 37
    //   110: aastore
    //   111: dup
    //   112: bipush 14
    //   114: ldc 55
    //   116: aastore
    //   117: dup
    //   118: bipush 15
    //   120: ldc 39
    //   122: aastore
    //   123: dup
    //   124: bipush 16
    //   126: ldc 33
    //   128: aastore
    //   129: dup
    //   130: bipush 17
    //   132: ldc 57
    //   134: aastore
    //   135: dup
    //   136: bipush 18
    //   138: ldc 9
    //   140: aastore
    //   141: aconst_null
    //   142: aconst_null
    //   143: aconst_null
    //   144: aconst_null
    //   145: aconst_null
    //   146: invokevirtual 211	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   149: astore 23
    //   151: aload 23
    //   153: invokeinterface 217 1 0
    //   158: pop
    //   159: aload 23
    //   161: aload 23
    //   163: ldc 46
    //   165: invokeinterface 221 2 0
    //   170: invokeinterface 225 2 0
    //   175: astore 25
    //   177: aload 24
    //   179: aload 25
    //   181: iconst_0
    //   182: invokevirtual 231	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   185: getfield 237	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   188: astore 26
    //   190: aload 26
    //   192: getfield 242	android/content/pm/ApplicationInfo:enabled	Z
    //   195: istore 19
    //   197: aload 26
    //   199: getfield 246	android/content/pm/ApplicationInfo:flags	I
    //   202: ldc -9
    //   204: iand
    //   205: ldc -9
    //   207: if_icmpne +561 -> 768
    //   210: iconst_1
    //   211: istore 18
    //   213: aload 23
    //   215: aload 23
    //   217: ldc 44
    //   219: invokeinterface 250 2 0
    //   224: invokeinterface 225 2 0
    //   229: astore 27
    //   231: aload 23
    //   233: aload 23
    //   235: ldc 51
    //   237: invokeinterface 250 2 0
    //   242: invokeinterface 254 2 0
    //   247: istore_3
    //   248: aload 23
    //   250: aload 23
    //   252: ldc 53
    //   254: invokeinterface 250 2 0
    //   259: invokeinterface 254 2 0
    //   264: istore 5
    //   266: aload 23
    //   268: aload 23
    //   270: ldc 31
    //   272: invokeinterface 250 2 0
    //   277: invokeinterface 254 2 0
    //   282: istore 6
    //   284: aload 23
    //   286: aload 23
    //   288: ldc 49
    //   290: invokeinterface 250 2 0
    //   295: invokeinterface 225 2 0
    //   300: astore 28
    //   302: aload 23
    //   304: aload 23
    //   306: ldc 11
    //   308: invokeinterface 250 2 0
    //   313: invokeinterface 254 2 0
    //   318: istore 7
    //   320: aload 23
    //   322: aload 23
    //   324: ldc 15
    //   326: invokeinterface 250 2 0
    //   331: invokeinterface 254 2 0
    //   336: istore 8
    //   338: aload 23
    //   340: aload 23
    //   342: ldc 13
    //   344: invokeinterface 250 2 0
    //   349: invokeinterface 254 2 0
    //   354: istore 9
    //   356: aload 23
    //   358: aload 23
    //   360: ldc 17
    //   362: invokeinterface 250 2 0
    //   367: invokeinterface 254 2 0
    //   372: istore 10
    //   374: aload 23
    //   376: aload 23
    //   378: ldc 21
    //   380: invokeinterface 250 2 0
    //   385: invokeinterface 254 2 0
    //   390: istore 11
    //   392: aload 23
    //   394: aload 23
    //   396: ldc 35
    //   398: invokeinterface 250 2 0
    //   403: invokeinterface 254 2 0
    //   408: istore 12
    //   410: aload 23
    //   412: aload 23
    //   414: ldc 7
    //   416: invokeinterface 250 2 0
    //   421: invokeinterface 254 2 0
    //   426: istore 13
    //   428: aload 23
    //   430: aload 23
    //   432: ldc 37
    //   434: invokeinterface 250 2 0
    //   439: invokeinterface 254 2 0
    //   444: istore 14
    //   446: aload 23
    //   448: aload 23
    //   450: ldc 55
    //   452: invokeinterface 250 2 0
    //   457: invokeinterface 254 2 0
    //   462: istore 15
    //   464: aload 23
    //   466: aload 23
    //   468: ldc 39
    //   470: invokeinterface 250 2 0
    //   475: invokeinterface 254 2 0
    //   480: istore 16
    //   482: aload 23
    //   484: aload 23
    //   486: ldc 9
    //   488: invokeinterface 250 2 0
    //   493: invokeinterface 254 2 0
    //   498: istore 17
    //   500: aconst_null
    //   501: astore 21
    //   503: aload 21
    //   505: astore 20
    //   507: iload_2
    //   508: ifne +44 -> 552
    //   511: aload 23
    //   513: aload 23
    //   515: ldc 33
    //   517: invokeinterface 221 2 0
    //   522: invokeinterface 258 2 0
    //   527: astore 29
    //   529: aload 21
    //   531: astore 20
    //   533: aload 29
    //   535: ifnull +17 -> 552
    //   538: new 260	java/io/ByteArrayInputStream
    //   541: dup
    //   542: aload 29
    //   544: invokespecial 263	java/io/ByteArrayInputStream:<init>	([B)V
    //   547: invokestatic 269	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   550: astore 20
    //   552: aload 23
    //   554: aload 23
    //   556: ldc 57
    //   558: invokeinterface 250 2 0
    //   563: invokeinterface 254 2 0
    //   568: istore 4
    //   570: iload_3
    //   571: ifeq +217 -> 788
    //   574: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   577: ldc2_w 274
    //   580: ldiv
    //   581: l2i
    //   582: iload 4
    //   584: isub
    //   585: invokestatic 280	java/lang/Math:abs	(I)I
    //   588: ldc_w 281
    //   591: getstatic 284	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:days	I
    //   594: imul
    //   595: if_icmpge +37 -> 632
    //   598: iconst_0
    //   599: istore_3
    //   600: getstatic 63	com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper:db	Landroid/database/sqlite/SQLiteDatabase;
    //   603: new 87	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   610: ldc_w 286
    //   613: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 25
    //   618: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: ldc -75
    //   623: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokevirtual 121	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   632: new 177	com/android/vending/billing/InAppBillingService/LACK/PkgListItem
    //   635: dup
    //   636: invokestatic 156	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   639: aload 25
    //   641: aload 27
    //   643: iload_3
    //   644: iload 5
    //   646: iload 6
    //   648: aload 28
    //   650: iload 7
    //   652: iload 8
    //   654: iload 9
    //   656: iload 10
    //   658: iload 11
    //   660: iload 12
    //   662: iload 13
    //   664: iload 14
    //   666: iload 15
    //   668: iload 16
    //   670: aload 20
    //   672: iload 4
    //   674: iload 17
    //   676: iload 19
    //   678: iload 18
    //   680: iload_2
    //   681: invokespecial 289	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;IIIIIIIIIILandroid/graphics/Bitmap;IIZZZ)V
    //   684: astore 20
    //   686: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   689: ldc_w 295
    //   692: iconst_0
    //   693: invokeinterface 301 3 0
    //   698: istore 18
    //   700: iload_1
    //   701: ifne +679 -> 1380
    //   704: aload 25
    //   706: ldc_w 303
    //   709: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   712: ifne +19 -> 731
    //   715: aload 25
    //   717: ldc -115
    //   719: invokevirtual 312	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   722: invokevirtual 317	java/lang/Package:getName	()Ljava/lang/String;
    //   725: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   728: ifeq +168 -> 896
    //   731: new 195	java/lang/IllegalArgumentException
    //   734: dup
    //   735: ldc_w 319
    //   738: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   741: athrow
    //   742: astore 20
    //   744: aload 23
    //   746: invokeinterface 323 1 0
    //   751: ifne -592 -> 159
    //   754: aload 23
    //   756: invokeinterface 326 1 0
    //   761: iconst_0
    //   762: putstatic 65	com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper:getPackage	Z
    //   765: aload 22
    //   767: areturn
    //   768: iconst_0
    //   769: istore 18
    //   771: goto -558 -> 213
    //   774: astore 20
    //   776: aload 20
    //   778: invokevirtual 327	java/lang/Exception:printStackTrace	()V
    //   781: aload 21
    //   783: astore 20
    //   785: goto -233 -> 552
    //   788: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   791: ldc2_w 274
    //   794: ldiv
    //   795: l2i
    //   796: iload 4
    //   798: isub
    //   799: invokestatic 280	java/lang/Math:abs	(I)I
    //   802: ldc_w 281
    //   805: getstatic 284	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:days	I
    //   808: imul
    //   809: if_icmple +30 -> 839
    //   812: new 177	com/android/vending/billing/InAppBillingService/LACK/PkgListItem
    //   815: dup
    //   816: invokestatic 156	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   819: aload 25
    //   821: getstatic 284	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:days	I
    //   824: iload_2
    //   825: invokespecial 330	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:<init>	(Landroid/content/Context;Ljava/lang/String;IZ)V
    //   828: astore 20
    //   830: aload_0
    //   831: aload 20
    //   833: invokevirtual 332	com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper:savePackage	(Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;)V
    //   836: goto -150 -> 686
    //   839: new 177	com/android/vending/billing/InAppBillingService/LACK/PkgListItem
    //   842: dup
    //   843: invokestatic 156	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   846: aload 25
    //   848: aload 27
    //   850: iload_3
    //   851: iload 5
    //   853: iload 6
    //   855: aload 28
    //   857: iload 7
    //   859: iload 8
    //   861: iload 9
    //   863: iload 10
    //   865: iload 11
    //   867: iload 12
    //   869: iload 13
    //   871: iload 14
    //   873: iload 15
    //   875: iload 16
    //   877: aload 20
    //   879: iload 4
    //   881: iload 17
    //   883: iload 19
    //   885: iload 18
    //   887: iload_2
    //   888: invokespecial 289	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;IIIIIIIIIILandroid/graphics/Bitmap;IIZZZ)V
    //   891: astore 20
    //   893: goto -207 -> 686
    //   896: aload 20
    //   898: getfield 334	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
    //   901: ifeq +27 -> 928
    //   904: iload 18
    //   906: ifne +22 -> 928
    //   909: aload 20
    //   911: getfield 336	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   914: ifne +14 -> 928
    //   917: new 195	java/lang/IllegalArgumentException
    //   920: dup
    //   921: ldc_w 338
    //   924: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   927: athrow
    //   928: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   931: ldc_w 340
    //   934: iconst_1
    //   935: invokeinterface 301 3 0
    //   940: ifne +54 -> 994
    //   943: aload 20
    //   945: getfield 342	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   948: ifeq +46 -> 994
    //   951: aload 20
    //   953: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   956: ifne +38 -> 994
    //   959: aload 20
    //   961: getfield 336	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   964: ifne +30 -> 994
    //   967: aload 20
    //   969: getfield 346	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   972: ifne +22 -> 994
    //   975: aload 20
    //   977: getfield 348	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   980: ifne +14 -> 994
    //   983: new 195	java/lang/IllegalArgumentException
    //   986: dup
    //   987: ldc_w 319
    //   990: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   993: athrow
    //   994: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   997: ldc_w 350
    //   1000: iconst_1
    //   1001: invokeinterface 301 3 0
    //   1006: ifne +54 -> 1060
    //   1009: aload 20
    //   1011: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   1014: ifeq +46 -> 1060
    //   1017: aload 20
    //   1019: getfield 342	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1022: ifne +38 -> 1060
    //   1025: aload 20
    //   1027: getfield 336	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   1030: ifne +30 -> 1060
    //   1033: aload 20
    //   1035: getfield 346	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   1038: ifne +22 -> 1060
    //   1041: aload 20
    //   1043: getfield 348	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   1046: ifne +14 -> 1060
    //   1049: new 195	java/lang/IllegalArgumentException
    //   1052: dup
    //   1053: ldc_w 319
    //   1056: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1059: athrow
    //   1060: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   1063: ldc_w 340
    //   1066: iconst_1
    //   1067: invokeinterface 301 3 0
    //   1072: ifne +69 -> 1141
    //   1075: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   1078: ldc_w 350
    //   1081: iconst_1
    //   1082: invokeinterface 301 3 0
    //   1087: ifne +54 -> 1141
    //   1090: aload 20
    //   1092: getfield 342	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1095: ifeq +46 -> 1141
    //   1098: aload 20
    //   1100: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   1103: ifeq +38 -> 1141
    //   1106: aload 20
    //   1108: getfield 336	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   1111: ifne +30 -> 1141
    //   1114: aload 20
    //   1116: getfield 346	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   1119: ifne +22 -> 1141
    //   1122: aload 20
    //   1124: getfield 348	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   1127: ifne +14 -> 1141
    //   1130: new 195	java/lang/IllegalArgumentException
    //   1133: dup
    //   1134: ldc_w 319
    //   1137: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1140: athrow
    //   1141: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   1144: ldc_w 352
    //   1147: iconst_1
    //   1148: invokeinterface 301 3 0
    //   1153: ifne +36 -> 1189
    //   1156: iload_3
    //   1157: bipush 6
    //   1159: if_icmpne +30 -> 1189
    //   1162: aload 20
    //   1164: getfield 346	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   1167: ifne +22 -> 1189
    //   1170: aload 20
    //   1172: getfield 348	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   1175: ifne +14 -> 1189
    //   1178: new 195	java/lang/IllegalArgumentException
    //   1181: dup
    //   1182: ldc_w 319
    //   1185: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1188: athrow
    //   1189: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   1192: ldc_w 354
    //   1195: iconst_1
    //   1196: invokeinterface 301 3 0
    //   1201: ifne +38 -> 1239
    //   1204: aload 20
    //   1206: getfield 336	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   1209: ifeq +30 -> 1239
    //   1212: aload 20
    //   1214: getfield 346	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   1217: ifne +22 -> 1239
    //   1220: aload 20
    //   1222: getfield 348	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   1225: ifne +14 -> 1239
    //   1228: new 195	java/lang/IllegalArgumentException
    //   1231: dup
    //   1232: ldc_w 319
    //   1235: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1238: athrow
    //   1239: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   1242: ldc_w 356
    //   1245: iconst_1
    //   1246: invokeinterface 301 3 0
    //   1251: ifne +30 -> 1281
    //   1254: aload 20
    //   1256: getfield 346	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   1259: ifeq +22 -> 1281
    //   1262: aload 20
    //   1264: getfield 348	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   1267: ifne +14 -> 1281
    //   1270: new 195	java/lang/IllegalArgumentException
    //   1273: dup
    //   1274: ldc_w 319
    //   1277: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1280: athrow
    //   1281: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   1284: ldc_w 358
    //   1287: iconst_1
    //   1288: invokeinterface 301 3 0
    //   1293: ifne +30 -> 1323
    //   1296: aload 20
    //   1298: getfield 346	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   1301: ifne +22 -> 1323
    //   1304: aload 20
    //   1306: getfield 348	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   1309: ifeq +14 -> 1323
    //   1312: new 195	java/lang/IllegalArgumentException
    //   1315: dup
    //   1316: ldc_w 319
    //   1319: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1322: athrow
    //   1323: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   1326: ldc_w 356
    //   1329: iconst_1
    //   1330: invokeinterface 301 3 0
    //   1335: ifne +245 -> 1580
    //   1338: invokestatic 293	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   1341: ldc_w 358
    //   1344: iconst_1
    //   1345: invokeinterface 301 3 0
    //   1350: ifne +230 -> 1580
    //   1353: aload 20
    //   1355: getfield 346	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   1358: ifne +11 -> 1369
    //   1361: aload 20
    //   1363: getfield 348	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   1366: ifeq +214 -> 1580
    //   1369: new 195	java/lang/IllegalArgumentException
    //   1372: dup
    //   1373: ldc_w 319
    //   1376: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1379: athrow
    //   1380: aload 25
    //   1382: ldc_w 303
    //   1385: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1388: ifne +17 -> 1405
    //   1391: aload 25
    //   1393: getstatic 61	com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper:contextdb	Landroid/content/Context;
    //   1396: invokevirtual 161	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1399: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1402: ifeq +14 -> 1416
    //   1405: new 195	java/lang/IllegalArgumentException
    //   1408: dup
    //   1409: ldc_w 319
    //   1412: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1415: athrow
    //   1416: getstatic 361	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:advancedFilter	I
    //   1419: ifeq +161 -> 1580
    //   1422: getstatic 361	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:advancedFilter	I
    //   1425: lookupswitch	default:+815->2240, 1929:+368->1793, 1930:+464->1889, 1931:+483->1908, 1932:+546->1971, 2131558415:+166->1591, 2131558416:+173->1598, 2131558417:+204->1629, 2131558418:+223->1648, 2131558419:+242->1667, 2131558420:+261->1686, 2131558421:+280->1705, 2131558422:+299->1724, 2131558423:+318->1743, 2131558424:+343->1768, 2131558425:+730->2155, 2131558426:+398->1823, 2131558427:+417->1842, 2131558428:+632->2057
    //   1580: aload 22
    //   1582: aload 20
    //   1584: invokevirtual 364	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1587: pop
    //   1588: goto -844 -> 744
    //   1591: iconst_0
    //   1592: putstatic 361	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:advancedFilter	I
    //   1595: goto -15 -> 1580
    //   1598: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   1601: ldc2_w 274
    //   1604: ldiv
    //   1605: l2i
    //   1606: iload 4
    //   1608: isub
    //   1609: invokestatic 280	java/lang/Math:abs	(I)I
    //   1612: ldc_w 281
    //   1615: if_icmple -35 -> 1580
    //   1618: new 195	java/lang/IllegalArgumentException
    //   1621: dup
    //   1622: ldc_w 319
    //   1625: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1628: athrow
    //   1629: aload 20
    //   1631: getfield 342	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1634: ifne -54 -> 1580
    //   1637: new 195	java/lang/IllegalArgumentException
    //   1640: dup
    //   1641: ldc_w 319
    //   1644: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1647: athrow
    //   1648: aload 20
    //   1650: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   1653: ifne -73 -> 1580
    //   1656: new 195	java/lang/IllegalArgumentException
    //   1659: dup
    //   1660: ldc_w 319
    //   1663: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1666: athrow
    //   1667: aload 20
    //   1669: getfield 336	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   1672: ifne -92 -> 1580
    //   1675: new 195	java/lang/IllegalArgumentException
    //   1678: dup
    //   1679: ldc_w 319
    //   1682: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1685: athrow
    //   1686: aload 20
    //   1688: getfield 348	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   1691: ifne -111 -> 1580
    //   1694: new 195	java/lang/IllegalArgumentException
    //   1697: dup
    //   1698: ldc_w 319
    //   1701: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1704: athrow
    //   1705: aload 20
    //   1707: getfield 346	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   1710: ifne -130 -> 1580
    //   1713: new 195	java/lang/IllegalArgumentException
    //   1716: dup
    //   1717: ldc_w 319
    //   1720: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1723: athrow
    //   1724: aload 20
    //   1726: getfield 366	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   1729: ifne -149 -> 1580
    //   1732: new 195	java/lang/IllegalArgumentException
    //   1735: dup
    //   1736: ldc_w 319
    //   1739: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1742: athrow
    //   1743: aload 26
    //   1745: getfield 369	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   1748: ldc_w 371
    //   1751: invokevirtual 375	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1754: ifne -174 -> 1580
    //   1757: new 195	java/lang/IllegalArgumentException
    //   1760: dup
    //   1761: ldc_w 319
    //   1764: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1767: athrow
    //   1768: aload 26
    //   1770: getfield 369	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   1773: ldc_w 377
    //   1776: invokevirtual 375	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1779: ifne -199 -> 1580
    //   1782: new 195	java/lang/IllegalArgumentException
    //   1785: dup
    //   1786: ldc_w 319
    //   1789: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1792: athrow
    //   1793: aload 20
    //   1795: getfield 334	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
    //   1798: ifne +14 -> 1812
    //   1801: aload 20
    //   1803: getfield 179	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1806: invokestatic 380	com/chelpus/Utils:isInstalledOnSdCard	(Ljava/lang/String;)Z
    //   1809: ifeq -229 -> 1580
    //   1812: new 195	java/lang/IllegalArgumentException
    //   1815: dup
    //   1816: ldc_w 319
    //   1819: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1822: athrow
    //   1823: aload 20
    //   1825: getfield 334	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
    //   1828: ifne -248 -> 1580
    //   1831: new 195	java/lang/IllegalArgumentException
    //   1834: dup
    //   1835: ldc_w 319
    //   1838: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1841: athrow
    //   1842: aload 20
    //   1844: getfield 334	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
    //   1847: ifeq +31 -> 1878
    //   1850: aload 26
    //   1852: getfield 369	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   1855: ldc_w 371
    //   1858: invokevirtual 375	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1861: ifne -281 -> 1580
    //   1864: aload 26
    //   1866: getfield 369	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   1869: ldc_w 377
    //   1872: invokevirtual 375	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1875: ifne -295 -> 1580
    //   1878: new 195	java/lang/IllegalArgumentException
    //   1881: dup
    //   1882: ldc_w 319
    //   1885: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1888: athrow
    //   1889: aload 20
    //   1891: getfield 334	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
    //   1894: ifeq -314 -> 1580
    //   1897: new 195	java/lang/IllegalArgumentException
    //   1900: dup
    //   1901: ldc_w 319
    //   1904: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1907: athrow
    //   1908: aload 24
    //   1910: ldc_w 382
    //   1913: aload 20
    //   1915: getfield 179	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1918: invokevirtual 386	android/content/pm/PackageManager:checkPermission	(Ljava/lang/String;Ljava/lang/String;)I
    //   1921: iconst_m1
    //   1922: if_icmpne +14 -> 1936
    //   1925: new 195	java/lang/IllegalArgumentException
    //   1928: dup
    //   1929: ldc_w 319
    //   1932: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1935: athrow
    //   1936: aload 24
    //   1938: new 388	android/content/ComponentName
    //   1941: dup
    //   1942: aload 20
    //   1944: getfield 179	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1947: ldc_w 382
    //   1950: invokespecial 391	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1953: invokevirtual 395	android/content/pm/PackageManager:getComponentEnabledSetting	(Landroid/content/ComponentName;)I
    //   1956: iconst_2
    //   1957: if_icmpne -377 -> 1580
    //   1960: new 195	java/lang/IllegalArgumentException
    //   1963: dup
    //   1964: ldc_w 319
    //   1967: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1970: athrow
    //   1971: aload 24
    //   1973: ldc_w 382
    //   1976: aload 20
    //   1978: getfield 179	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1981: invokevirtual 386	android/content/pm/PackageManager:checkPermission	(Ljava/lang/String;Ljava/lang/String;)I
    //   1984: iconst_m1
    //   1985: if_icmpne +14 -> 1999
    //   1988: new 195	java/lang/IllegalArgumentException
    //   1991: dup
    //   1992: ldc_w 319
    //   1995: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1998: athrow
    //   1999: aload 24
    //   2001: new 388	android/content/ComponentName
    //   2004: dup
    //   2005: aload 20
    //   2007: getfield 179	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   2010: ldc_w 382
    //   2013: invokespecial 391	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   2016: invokevirtual 395	android/content/pm/PackageManager:getComponentEnabledSetting	(Landroid/content/ComponentName;)I
    //   2019: iconst_1
    //   2020: if_icmpeq +26 -> 2046
    //   2023: aload 24
    //   2025: new 388	android/content/ComponentName
    //   2028: dup
    //   2029: aload 20
    //   2031: getfield 179	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   2034: ldc_w 382
    //   2037: invokespecial 391	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   2040: invokevirtual 395	android/content/pm/PackageManager:getComponentEnabledSetting	(Landroid/content/ComponentName;)I
    //   2043: ifne -463 -> 1580
    //   2046: new 195	java/lang/IllegalArgumentException
    //   2049: dup
    //   2050: ldc_w 319
    //   2053: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   2056: athrow
    //   2057: invokestatic 207	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   2060: aload 20
    //   2062: getfield 179	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   2065: sipush 4096
    //   2068: invokevirtual 231	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   2071: getfield 399	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   2074: astore 21
    //   2076: iconst_0
    //   2077: istore 5
    //   2079: iconst_0
    //   2080: istore_3
    //   2081: aload 21
    //   2083: ifnull +56 -> 2139
    //   2086: aload 21
    //   2088: arraylength
    //   2089: istore 6
    //   2091: iconst_0
    //   2092: istore 4
    //   2094: iload_3
    //   2095: istore 5
    //   2097: iload 4
    //   2099: iload 6
    //   2101: if_icmpge +38 -> 2139
    //   2104: aload 21
    //   2106: iload 4
    //   2108: aaload
    //   2109: astore 25
    //   2111: aload 25
    //   2113: invokevirtual 402	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2116: ldc_w 404
    //   2119: invokevirtual 139	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2122: ifne +121 -> 2243
    //   2125: aload 25
    //   2127: ldc_w 406
    //   2130: invokevirtual 139	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2133: ifeq +112 -> 2245
    //   2136: goto +107 -> 2243
    //   2139: iload 5
    //   2141: ifne -561 -> 1580
    //   2144: new 195	java/lang/IllegalArgumentException
    //   2147: dup
    //   2148: ldc_w 319
    //   2151: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   2154: athrow
    //   2155: aload 20
    //   2157: getfield 409	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:enable	Z
    //   2160: ifeq -580 -> 1580
    //   2163: new 195	java/lang/IllegalArgumentException
    //   2166: dup
    //   2167: ldc_w 319
    //   2170: invokespecial 320	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   2173: athrow
    //   2174: astore 20
    //   2176: aload 23
    //   2178: invokeinterface 326 1 0
    //   2183: goto -1422 -> 761
    //   2186: astore 20
    //   2188: iconst_0
    //   2189: putstatic 65	com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper:getPackage	Z
    //   2192: getstatic 85	java/lang/System:out	Ljava/io/PrintStream;
    //   2195: new 87	java/lang/StringBuilder
    //   2198: dup
    //   2199: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   2202: ldc_w 411
    //   2205: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2208: aload 20
    //   2210: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2213: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2216: invokevirtual 114	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2219: aload 22
    //   2221: areturn
    //   2222: astore 20
    //   2224: goto -1480 -> 744
    //   2227: astore 20
    //   2229: aconst_null
    //   2230: astore 20
    //   2232: goto -1680 -> 552
    //   2235: astore 20
    //   2237: goto -1493 -> 744
    //   2240: goto -660 -> 1580
    //   2243: iconst_1
    //   2244: istore_3
    //   2245: iload 4
    //   2247: iconst_1
    //   2248: iadd
    //   2249: istore 4
    //   2251: goto -157 -> 2094
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2254	0	this	DatabaseHelper
    //   0	2254	1	paramBoolean1	boolean
    //   0	2254	2	paramBoolean2	boolean
    //   247	1998	3	i	int
    //   568	1682	4	j	int
    //   264	1876	5	k	int
    //   282	1820	6	m	int
    //   318	540	7	n	int
    //   336	524	8	i1	int
    //   354	508	9	i2	int
    //   372	492	10	i3	int
    //   390	476	11	i4	int
    //   408	460	12	i5	int
    //   426	444	13	i6	int
    //   444	428	14	i7	int
    //   462	412	15	i8	int
    //   480	396	16	i9	int
    //   498	384	17	i10	int
    //   211	694	18	bool1	boolean
    //   195	689	19	bool2	boolean
    //   505	180	20	localObject1	Object
    //   742	1	20	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   774	3	20	localException1	Exception
    //   783	1373	20	localObject2	Object
    //   2174	1	20	localException2	Exception
    //   2186	23	20	localException3	Exception
    //   2222	1	20	localIllegalArgumentException	IllegalArgumentException
    //   2227	1	20	localOutOfMemoryError	OutOfMemoryError
    //   2230	1	20	localObject3	Object
    //   2235	1	20	localException4	Exception
    //   501	1604	21	arrayOfString	String[]
    //   7	2213	22	localArrayList	java.util.ArrayList
    //   149	2028	23	localCursor	android.database.Cursor
    //   17	2007	24	localPackageManager	PackageManager
    //   175	1951	25	str1	String
    //   188	1677	26	localApplicationInfo	ApplicationInfo
    //   229	620	27	str2	String
    //   300	556	28	str3	String
    //   527	16	29	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   177	210	742	android/content/pm/PackageManager$NameNotFoundException
    //   213	500	742	android/content/pm/PackageManager$NameNotFoundException
    //   511	529	742	android/content/pm/PackageManager$NameNotFoundException
    //   538	552	742	android/content/pm/PackageManager$NameNotFoundException
    //   552	570	742	android/content/pm/PackageManager$NameNotFoundException
    //   574	598	742	android/content/pm/PackageManager$NameNotFoundException
    //   600	632	742	android/content/pm/PackageManager$NameNotFoundException
    //   632	686	742	android/content/pm/PackageManager$NameNotFoundException
    //   686	700	742	android/content/pm/PackageManager$NameNotFoundException
    //   704	731	742	android/content/pm/PackageManager$NameNotFoundException
    //   731	742	742	android/content/pm/PackageManager$NameNotFoundException
    //   776	781	742	android/content/pm/PackageManager$NameNotFoundException
    //   788	836	742	android/content/pm/PackageManager$NameNotFoundException
    //   839	893	742	android/content/pm/PackageManager$NameNotFoundException
    //   896	904	742	android/content/pm/PackageManager$NameNotFoundException
    //   909	928	742	android/content/pm/PackageManager$NameNotFoundException
    //   928	994	742	android/content/pm/PackageManager$NameNotFoundException
    //   994	1060	742	android/content/pm/PackageManager$NameNotFoundException
    //   1060	1141	742	android/content/pm/PackageManager$NameNotFoundException
    //   1141	1156	742	android/content/pm/PackageManager$NameNotFoundException
    //   1162	1189	742	android/content/pm/PackageManager$NameNotFoundException
    //   1189	1239	742	android/content/pm/PackageManager$NameNotFoundException
    //   1239	1281	742	android/content/pm/PackageManager$NameNotFoundException
    //   1281	1323	742	android/content/pm/PackageManager$NameNotFoundException
    //   1323	1369	742	android/content/pm/PackageManager$NameNotFoundException
    //   1369	1380	742	android/content/pm/PackageManager$NameNotFoundException
    //   1380	1405	742	android/content/pm/PackageManager$NameNotFoundException
    //   1405	1416	742	android/content/pm/PackageManager$NameNotFoundException
    //   1416	1580	742	android/content/pm/PackageManager$NameNotFoundException
    //   1580	1588	742	android/content/pm/PackageManager$NameNotFoundException
    //   1591	1595	742	android/content/pm/PackageManager$NameNotFoundException
    //   1598	1629	742	android/content/pm/PackageManager$NameNotFoundException
    //   1629	1648	742	android/content/pm/PackageManager$NameNotFoundException
    //   1648	1667	742	android/content/pm/PackageManager$NameNotFoundException
    //   1667	1686	742	android/content/pm/PackageManager$NameNotFoundException
    //   1686	1705	742	android/content/pm/PackageManager$NameNotFoundException
    //   1705	1724	742	android/content/pm/PackageManager$NameNotFoundException
    //   1724	1743	742	android/content/pm/PackageManager$NameNotFoundException
    //   1743	1768	742	android/content/pm/PackageManager$NameNotFoundException
    //   1768	1793	742	android/content/pm/PackageManager$NameNotFoundException
    //   1793	1812	742	android/content/pm/PackageManager$NameNotFoundException
    //   1812	1823	742	android/content/pm/PackageManager$NameNotFoundException
    //   1823	1842	742	android/content/pm/PackageManager$NameNotFoundException
    //   1842	1878	742	android/content/pm/PackageManager$NameNotFoundException
    //   1878	1889	742	android/content/pm/PackageManager$NameNotFoundException
    //   1889	1908	742	android/content/pm/PackageManager$NameNotFoundException
    //   1908	1936	742	android/content/pm/PackageManager$NameNotFoundException
    //   1936	1971	742	android/content/pm/PackageManager$NameNotFoundException
    //   1971	1999	742	android/content/pm/PackageManager$NameNotFoundException
    //   1999	2046	742	android/content/pm/PackageManager$NameNotFoundException
    //   2046	2057	742	android/content/pm/PackageManager$NameNotFoundException
    //   2057	2076	742	android/content/pm/PackageManager$NameNotFoundException
    //   2086	2091	742	android/content/pm/PackageManager$NameNotFoundException
    //   2111	2125	742	android/content/pm/PackageManager$NameNotFoundException
    //   2125	2136	742	android/content/pm/PackageManager$NameNotFoundException
    //   2144	2155	742	android/content/pm/PackageManager$NameNotFoundException
    //   2155	2174	742	android/content/pm/PackageManager$NameNotFoundException
    //   511	529	774	java/lang/Exception
    //   538	552	774	java/lang/Exception
    //   744	761	2174	java/lang/Exception
    //   23	159	2186	java/lang/Exception
    //   761	765	2186	java/lang/Exception
    //   2176	2183	2186	java/lang/Exception
    //   177	210	2222	java/lang/IllegalArgumentException
    //   213	500	2222	java/lang/IllegalArgumentException
    //   511	529	2222	java/lang/IllegalArgumentException
    //   538	552	2222	java/lang/IllegalArgumentException
    //   552	570	2222	java/lang/IllegalArgumentException
    //   574	598	2222	java/lang/IllegalArgumentException
    //   600	632	2222	java/lang/IllegalArgumentException
    //   632	686	2222	java/lang/IllegalArgumentException
    //   686	700	2222	java/lang/IllegalArgumentException
    //   704	731	2222	java/lang/IllegalArgumentException
    //   731	742	2222	java/lang/IllegalArgumentException
    //   776	781	2222	java/lang/IllegalArgumentException
    //   788	836	2222	java/lang/IllegalArgumentException
    //   839	893	2222	java/lang/IllegalArgumentException
    //   896	904	2222	java/lang/IllegalArgumentException
    //   909	928	2222	java/lang/IllegalArgumentException
    //   928	994	2222	java/lang/IllegalArgumentException
    //   994	1060	2222	java/lang/IllegalArgumentException
    //   1060	1141	2222	java/lang/IllegalArgumentException
    //   1141	1156	2222	java/lang/IllegalArgumentException
    //   1162	1189	2222	java/lang/IllegalArgumentException
    //   1189	1239	2222	java/lang/IllegalArgumentException
    //   1239	1281	2222	java/lang/IllegalArgumentException
    //   1281	1323	2222	java/lang/IllegalArgumentException
    //   1323	1369	2222	java/lang/IllegalArgumentException
    //   1369	1380	2222	java/lang/IllegalArgumentException
    //   1380	1405	2222	java/lang/IllegalArgumentException
    //   1405	1416	2222	java/lang/IllegalArgumentException
    //   1416	1580	2222	java/lang/IllegalArgumentException
    //   1580	1588	2222	java/lang/IllegalArgumentException
    //   1591	1595	2222	java/lang/IllegalArgumentException
    //   1598	1629	2222	java/lang/IllegalArgumentException
    //   1629	1648	2222	java/lang/IllegalArgumentException
    //   1648	1667	2222	java/lang/IllegalArgumentException
    //   1667	1686	2222	java/lang/IllegalArgumentException
    //   1686	1705	2222	java/lang/IllegalArgumentException
    //   1705	1724	2222	java/lang/IllegalArgumentException
    //   1724	1743	2222	java/lang/IllegalArgumentException
    //   1743	1768	2222	java/lang/IllegalArgumentException
    //   1768	1793	2222	java/lang/IllegalArgumentException
    //   1793	1812	2222	java/lang/IllegalArgumentException
    //   1812	1823	2222	java/lang/IllegalArgumentException
    //   1823	1842	2222	java/lang/IllegalArgumentException
    //   1842	1878	2222	java/lang/IllegalArgumentException
    //   1878	1889	2222	java/lang/IllegalArgumentException
    //   1889	1908	2222	java/lang/IllegalArgumentException
    //   1908	1936	2222	java/lang/IllegalArgumentException
    //   1936	1971	2222	java/lang/IllegalArgumentException
    //   1971	1999	2222	java/lang/IllegalArgumentException
    //   1999	2046	2222	java/lang/IllegalArgumentException
    //   2046	2057	2222	java/lang/IllegalArgumentException
    //   2057	2076	2222	java/lang/IllegalArgumentException
    //   2086	2091	2222	java/lang/IllegalArgumentException
    //   2111	2125	2222	java/lang/IllegalArgumentException
    //   2125	2136	2222	java/lang/IllegalArgumentException
    //   2144	2155	2222	java/lang/IllegalArgumentException
    //   2155	2174	2222	java/lang/IllegalArgumentException
    //   511	529	2227	java/lang/OutOfMemoryError
    //   538	552	2227	java/lang/OutOfMemoryError
    //   159	177	2235	java/lang/Exception
    //   177	210	2235	java/lang/Exception
    //   213	500	2235	java/lang/Exception
    //   552	570	2235	java/lang/Exception
    //   574	598	2235	java/lang/Exception
    //   600	632	2235	java/lang/Exception
    //   632	686	2235	java/lang/Exception
    //   686	700	2235	java/lang/Exception
    //   704	731	2235	java/lang/Exception
    //   731	742	2235	java/lang/Exception
    //   776	781	2235	java/lang/Exception
    //   788	836	2235	java/lang/Exception
    //   839	893	2235	java/lang/Exception
    //   896	904	2235	java/lang/Exception
    //   909	928	2235	java/lang/Exception
    //   928	994	2235	java/lang/Exception
    //   994	1060	2235	java/lang/Exception
    //   1060	1141	2235	java/lang/Exception
    //   1141	1156	2235	java/lang/Exception
    //   1162	1189	2235	java/lang/Exception
    //   1189	1239	2235	java/lang/Exception
    //   1239	1281	2235	java/lang/Exception
    //   1281	1323	2235	java/lang/Exception
    //   1323	1369	2235	java/lang/Exception
    //   1369	1380	2235	java/lang/Exception
    //   1380	1405	2235	java/lang/Exception
    //   1405	1416	2235	java/lang/Exception
    //   1416	1580	2235	java/lang/Exception
    //   1580	1588	2235	java/lang/Exception
    //   1591	1595	2235	java/lang/Exception
    //   1598	1629	2235	java/lang/Exception
    //   1629	1648	2235	java/lang/Exception
    //   1648	1667	2235	java/lang/Exception
    //   1667	1686	2235	java/lang/Exception
    //   1686	1705	2235	java/lang/Exception
    //   1705	1724	2235	java/lang/Exception
    //   1724	1743	2235	java/lang/Exception
    //   1743	1768	2235	java/lang/Exception
    //   1768	1793	2235	java/lang/Exception
    //   1793	1812	2235	java/lang/Exception
    //   1812	1823	2235	java/lang/Exception
    //   1823	1842	2235	java/lang/Exception
    //   1842	1878	2235	java/lang/Exception
    //   1878	1889	2235	java/lang/Exception
    //   1889	1908	2235	java/lang/Exception
    //   1908	1936	2235	java/lang/Exception
    //   1936	1971	2235	java/lang/Exception
    //   1971	1999	2235	java/lang/Exception
    //   1999	2046	2235	java/lang/Exception
    //   2046	2057	2235	java/lang/Exception
    //   2057	2076	2235	java/lang/Exception
    //   2086	2091	2235	java/lang/Exception
    //   2111	2125	2235	java/lang/Exception
    //   2125	2136	2235	java/lang/Exception
    //   2144	2155	2235	java/lang/Exception
    //   2155	2174	2235	java/lang/Exception
  }
  
  public boolean isOpen()
  {
    return db.isOpen();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE Packages (pkgName TEXT PRIMARY KEY, pkgLabel TEXT, stored Integer, storepref Integer, hidden Integer, statusi TEXT, boot_ads Integer, boot_lvl Integer, boot_custom Integer, boot_manual Integer, custom Integer, lvl Integer, ads Integer, modified Integer, system Integer, odex Integer, icon BLOB, updatetime Integer, billing Integer );");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS Packages");
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS Packages");
    onCreate(paramSQLiteDatabase);
  }
  
  public void savePackage(PkgListItem paramPkgListItem)
    throws SQLiteException
  {
    for (;;)
    {
      try
      {
        savePackage = true;
        localContentValues = new ContentValues();
        localContentValues.put("pkgName", paramPkgListItem.pkgName);
        localContentValues.put("pkgLabel", paramPkgListItem.name);
        localContentValues.put("stored", Integer.valueOf(paramPkgListItem.stored));
        localContentValues.put("storepref", Integer.valueOf(paramPkgListItem.storepref));
        localContentValues.put("hidden", Boolean.valueOf(paramPkgListItem.hidden));
        localContentValues.put("statusi", paramPkgListItem.statusi);
        localContentValues.put("boot_ads", Boolean.valueOf(paramPkgListItem.boot_ads));
        localContentValues.put("boot_lvl", Boolean.valueOf(paramPkgListItem.boot_lvl));
        localContentValues.put("boot_custom", Boolean.valueOf(paramPkgListItem.boot_custom));
        localContentValues.put("boot_manual", Boolean.valueOf(paramPkgListItem.boot_manual));
        localContentValues.put("custom", Boolean.valueOf(paramPkgListItem.custom));
        localContentValues.put("lvl", Boolean.valueOf(paramPkgListItem.lvl));
        localContentValues.put("ads", Boolean.valueOf(paramPkgListItem.ads));
        localContentValues.put("modified", Boolean.valueOf(paramPkgListItem.modified));
        localContentValues.put("system", Boolean.valueOf(paramPkgListItem.system));
        localContentValues.put("odex", Boolean.valueOf(paramPkgListItem.odex));
        localContentValues.put("updatetime", Integer.valueOf(paramPkgListItem.updatetime));
        localContentValues.put("billing", Boolean.valueOf(paramPkgListItem.billing));
        localObject = listAppsFragment.getPkgMng().getApplicationInfo(paramPkgListItem.pkgName, 0).sourceDir;
        localObject = null;
      }
      catch (Exception paramPkgListItem)
      {
        ContentValues localContentValues;
        Object localObject;
        savePackage = false;
        System.out.println("LuckyPatcher-Error: savePackage " + paramPkgListItem);
        return;
      }
      try
      {
        if (paramPkgListItem.icon != null) {
          localObject = ((BitmapDrawable)paramPkgListItem.icon).getBitmap();
        }
        if (localObject != null)
        {
          paramPkgListItem = new ByteArrayOutputStream();
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, paramPkgListItem);
          localContentValues.put("icon", paramPkgListItem.toByteArray());
        }
      }
      catch (OutOfMemoryError paramPkgListItem)
      {
        continue;
      }
      try
      {
        db.insertOrThrow("Packages", "pkgName", localContentValues);
        savePackage = false;
        savePackage = false;
        return;
      }
      catch (Exception paramPkgListItem)
      {
        db.replace("Packages", null, localContentValues);
      }
    }
  }
  
  public void updatePackage(List<PkgListItem> paramList) {}
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */