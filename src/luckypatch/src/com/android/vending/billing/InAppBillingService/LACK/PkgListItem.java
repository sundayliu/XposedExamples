package com.android.vending.billing.InAppBillingService.LACK;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.chelpus.Utils;
import java.io.PrintStream;

public class PkgListItem
{
  public static final int PKG_STORED_EXTERNAL = 1;
  public static final int PKG_STORED_INTERNAL = 0;
  public static final int PKG_STOREPREF_AUTO = 0;
  public static final int PKG_STOREPREF_EXT = 2;
  public static final int PKG_STOREPREF_INT = 1;
  public static final int lastIntPosition = 10;
  public static final int noneAppIntPosition = 6;
  public boolean ads = false;
  public boolean billing = false;
  public boolean boot_ads = false;
  public boolean boot_custom = false;
  public boolean boot_lvl = false;
  public boolean boot_manual = false;
  public boolean custom = false;
  public boolean enable = false;
  public boolean hidden = false;
  public Drawable icon;
  public boolean lvl = false;
  public boolean modified = false;
  public String name;
  public boolean odex = false;
  public boolean on_sd = false;
  public String pkgName;
  public boolean selected = false;
  public String statusi = "";
  public int stored;
  public int storepref;
  public boolean system = false;
  public int updatetime = 0;
  
  public PkgListItem(Context paramContext, PkgListItem paramPkgListItem)
  {
    this.pkgName = paramPkgListItem.pkgName;
    this.name = paramPkgListItem.name;
    this.storepref = paramPkgListItem.storepref;
    this.stored = paramPkgListItem.stored;
    this.hidden = paramPkgListItem.hidden;
    this.statusi = paramPkgListItem.statusi;
    this.boot_ads = paramPkgListItem.boot_ads;
    this.boot_lvl = paramPkgListItem.boot_lvl;
    this.boot_custom = paramPkgListItem.boot_custom;
    this.boot_manual = paramPkgListItem.boot_manual;
    this.custom = paramPkgListItem.custom;
    this.lvl = paramPkgListItem.lvl;
    this.ads = paramPkgListItem.ads;
    this.modified = paramPkgListItem.modified;
    this.on_sd = Utils.isInstalledOnSdCard(this.pkgName);
    this.system = paramPkgListItem.system;
    this.odex = paramPkgListItem.odex;
    this.icon = paramPkgListItem.icon;
    this.enable = paramPkgListItem.enable;
    if (!this.enable) {
      this.stored = 10;
    }
    this.updatetime = paramPkgListItem.updatetime;
  }
  
  /* Error */
  public PkgListItem(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
    throws java.lang.IllegalArgumentException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 49	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:hidden	Z
    //   9: aload_0
    //   10: ldc 51
    //   12: putfield 53	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:statusi	Ljava/lang/String;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 55	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_ads	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 57	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_lvl	Z
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 59	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_custom	Z
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 61	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_manual	Z
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 63	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 67	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 69	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 71	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 73	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 75	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 77	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:updatetime	I
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 79	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:enable	Z
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 81	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:selected	Z
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 83	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:on_sd	Z
    //   90: invokestatic 117	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   93: astore 11
    //   95: aconst_null
    //   96: astore 10
    //   98: iload 4
    //   100: ifeq +115 -> 215
    //   103: invokestatic 121	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getRes	()Landroid/content/res/Resources;
    //   106: invokevirtual 127	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   109: getfield 133	android/util/DisplayMetrics:density	F
    //   112: fstore 5
    //   114: ldc -122
    //   116: fload 5
    //   118: fmul
    //   119: ldc -121
    //   121: fadd
    //   122: f2i
    //   123: istore 7
    //   125: aload 11
    //   127: aload_2
    //   128: invokevirtual 141	android/content/pm/PackageManager:getApplicationIcon	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   131: checkcast 143	android/graphics/drawable/BitmapDrawable
    //   134: invokevirtual 147	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   137: astore 11
    //   139: aload 11
    //   141: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   144: istore 8
    //   146: aload 11
    //   148: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   151: istore 9
    //   153: iload 7
    //   155: i2f
    //   156: iload 8
    //   158: i2f
    //   159: fdiv
    //   160: fstore 5
    //   162: iload 7
    //   164: i2f
    //   165: iload 9
    //   167: i2f
    //   168: fdiv
    //   169: fstore 6
    //   171: new 158	android/graphics/Matrix
    //   174: dup
    //   175: invokespecial 159	android/graphics/Matrix:<init>	()V
    //   178: astore 12
    //   180: aload 12
    //   182: fload 5
    //   184: fload 6
    //   186: invokevirtual 163	android/graphics/Matrix:postScale	(FF)Z
    //   189: pop
    //   190: aload_0
    //   191: new 143	android/graphics/drawable/BitmapDrawable
    //   194: dup
    //   195: aload 11
    //   197: iconst_0
    //   198: iconst_0
    //   199: iload 8
    //   201: iload 9
    //   203: aload 12
    //   205: iconst_1
    //   206: invokestatic 167	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   209: invokespecial 170	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   212: putfield 99	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:icon	Landroid/graphics/drawable/Drawable;
    //   215: aload_0
    //   216: aload_2
    //   217: putfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   225: invokestatic 97	com/chelpus/Utils:isInstalledOnSdCard	(Ljava/lang/String;)Z
    //   228: putfield 83	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:on_sd	Z
    //   231: aload_0
    //   232: iconst_0
    //   233: putfield 55	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_ads	Z
    //   236: aload_0
    //   237: iconst_0
    //   238: putfield 57	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_lvl	Z
    //   241: aload_0
    //   242: iconst_0
    //   243: putfield 59	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_custom	Z
    //   246: aload_0
    //   247: iconst_0
    //   248: putfield 61	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_manual	Z
    //   251: aload_0
    //   252: iconst_0
    //   253: putfield 63	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   256: aload_0
    //   257: iconst_0
    //   258: putfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   261: aload_0
    //   262: iconst_0
    //   263: putfield 67	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   266: aload_0
    //   267: iconst_0
    //   268: putfield 71	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   271: aload_0
    //   272: iconst_0
    //   273: putfield 73	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
    //   276: aload_2
    //   277: ifnull +9 -> 286
    //   280: aload_2
    //   281: ldc 51
    //   283: if_acmpne +38 -> 321
    //   286: new 103	java/lang/IllegalArgumentException
    //   289: dup
    //   290: ldc -84
    //   292: invokespecial 175	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   295: athrow
    //   296: astore 11
    //   298: aload 11
    //   300: invokevirtual 178	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   303: goto -88 -> 215
    //   306: astore 11
    //   308: aload 11
    //   310: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   313: goto -98 -> 215
    //   316: astore 11
    //   318: goto -103 -> 215
    //   321: invokestatic 117	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   324: astore 13
    //   326: aload_0
    //   327: aload_2
    //   328: putfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   331: iconst_0
    //   332: ifne +15 -> 347
    //   335: aload 13
    //   337: aload_2
    //   338: iconst_0
    //   339: invokevirtual 183	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   342: getfield 189	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   345: astore 10
    //   347: aload_0
    //   348: aload 10
    //   350: getfield 194	android/content/pm/ApplicationInfo:enabled	Z
    //   353: putfield 79	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:enable	Z
    //   356: aload_0
    //   357: aload 13
    //   359: aload_2
    //   360: iconst_0
    //   361: invokevirtual 183	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   364: getfield 189	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   367: aload 13
    //   369: invokevirtual 198	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   372: invokeinterface 204 1 0
    //   377: putfield 87	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:name	Ljava/lang/String;
    //   380: aload 13
    //   382: aload_0
    //   383: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   386: iconst_0
    //   387: invokevirtual 208	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   390: getfield 211	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   393: astore 11
    //   395: aload_0
    //   396: aload_0
    //   397: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   400: iconst_0
    //   401: invokestatic 215	com/chelpus/Utils:getfirstInstallTime	(Ljava/lang/String;Z)J
    //   404: ldc2_w 216
    //   407: ldiv
    //   408: l2i
    //   409: putfield 77	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:updatetime	I
    //   412: aload 11
    //   414: invokestatic 220	com/chelpus/Utils:isOdex	(Ljava/lang/String;)Z
    //   417: ifeq +168 -> 585
    //   420: aload_0
    //   421: iconst_1
    //   422: putfield 75	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   425: aload_0
    //   426: iconst_2
    //   427: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   430: aload_0
    //   431: iconst_0
    //   432: putfield 89	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:storepref	I
    //   435: aload_0
    //   436: aload_0
    //   437: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   440: invokestatic 224	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   443: invokestatic 228	com/chelpus/Utils:isModified	(Ljava/lang/String;Landroid/content/Context;)Z
    //   446: putfield 71	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   449: getstatic 232	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:bootlist	[Ljava/lang/String;
    //   452: ifnull +267 -> 719
    //   455: iconst_0
    //   456: istore 7
    //   458: iload 7
    //   460: getstatic 232	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:bootlist	[Ljava/lang/String;
    //   463: arraylength
    //   464: if_icmpge +255 -> 719
    //   467: getstatic 232	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:bootlist	[Ljava/lang/String;
    //   470: iload 7
    //   472: aaload
    //   473: ldc -22
    //   475: invokevirtual 240	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   478: arraylength
    //   479: anewarray 236	java/lang/String
    //   482: astore 11
    //   484: getstatic 232	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:bootlist	[Ljava/lang/String;
    //   487: iload 7
    //   489: aaload
    //   490: ldc -22
    //   492: invokevirtual 240	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   495: astore 11
    //   497: aload 11
    //   499: iconst_0
    //   500: aaload
    //   501: aload_0
    //   502: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   505: invokevirtual 243	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   508: ifeq +202 -> 710
    //   511: iconst_1
    //   512: istore 8
    //   514: iload 8
    //   516: aload 11
    //   518: arraylength
    //   519: if_icmpge +191 -> 710
    //   522: aload 11
    //   524: iload 8
    //   526: aaload
    //   527: ldc -12
    //   529: invokevirtual 248	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   532: ifeq +8 -> 540
    //   535: aload_0
    //   536: iconst_1
    //   537: putfield 55	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_ads	Z
    //   540: aload 11
    //   542: iload 8
    //   544: aaload
    //   545: ldc -7
    //   547: invokevirtual 248	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   550: ifeq +8 -> 558
    //   553: aload_0
    //   554: iconst_1
    //   555: putfield 57	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_lvl	Z
    //   558: aload 11
    //   560: iload 8
    //   562: aaload
    //   563: ldc -6
    //   565: invokevirtual 248	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   568: ifeq +8 -> 576
    //   571: aload_0
    //   572: iconst_1
    //   573: putfield 59	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_custom	Z
    //   576: iload 8
    //   578: iconst_1
    //   579: iadd
    //   580: istore 8
    //   582: goto -68 -> 514
    //   585: aload_0
    //   586: iconst_0
    //   587: putfield 75	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   590: goto -165 -> 425
    //   593: astore 10
    //   595: getstatic 256	java/lang/System:out	Ljava/io/PrintStream;
    //   598: aload_0
    //   599: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   602: invokevirtual 261	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   605: new 103	java/lang/IllegalArgumentException
    //   608: dup
    //   609: ldc -84
    //   611: invokespecial 175	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   614: athrow
    //   615: astore 10
    //   617: aload 10
    //   619: invokevirtual 262	java/lang/NullPointerException:printStackTrace	()V
    //   622: invokestatic 121	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getRes	()Landroid/content/res/Resources;
    //   625: pop
    //   626: aconst_null
    //   627: astore 11
    //   629: aload 13
    //   631: aload_2
    //   632: sipush 4097
    //   635: invokevirtual 183	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   638: astore 12
    //   640: iconst_0
    //   641: istore 7
    //   643: aload 12
    //   645: astore 11
    //   647: aload 12
    //   649: astore 10
    //   651: iload 7
    //   653: aload 12
    //   655: getfield 266	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   658: arraylength
    //   659: if_icmpge +644 -> 1303
    //   662: aload 12
    //   664: astore 11
    //   666: aload 12
    //   668: getfield 266	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   671: iload 7
    //   673: aaload
    //   674: getfield 269	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   677: invokestatic 272	com/chelpus/Utils:isAds	(Ljava/lang/String;)Z
    //   680: ifeq +21 -> 701
    //   683: aload 12
    //   685: astore 11
    //   687: aload_0
    //   688: iconst_4
    //   689: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   692: aload 12
    //   694: astore 11
    //   696: aload_0
    //   697: iconst_1
    //   698: putfield 67	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   701: iload 7
    //   703: iconst_1
    //   704: iadd
    //   705: istore 7
    //   707: goto -64 -> 643
    //   710: iload 7
    //   712: iconst_1
    //   713: iadd
    //   714: istore 7
    //   716: goto -258 -> 458
    //   719: aload_1
    //   720: ldc_w 273
    //   723: iconst_0
    //   724: invokevirtual 279	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   727: invokevirtual 285	java/io/File:listFiles	()[Ljava/io/File;
    //   730: astore 11
    //   732: aload 11
    //   734: ifnull +62 -> 796
    //   737: aload 11
    //   739: arraylength
    //   740: istore 8
    //   742: iconst_0
    //   743: istore 7
    //   745: iload 7
    //   747: iload 8
    //   749: if_icmpge +47 -> 796
    //   752: aload 11
    //   754: iload 7
    //   756: aaload
    //   757: astore 12
    //   759: aload 12
    //   761: invokevirtual 288	java/io/File:getName	()Ljava/lang/String;
    //   764: ldc_w 273
    //   767: invokevirtual 243	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   770: ifne +867 -> 1637
    //   773: aload_0
    //   774: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   777: aload 12
    //   779: invokevirtual 288	java/io/File:getName	()Ljava/lang/String;
    //   782: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   785: ifeq +852 -> 1637
    //   788: aload_0
    //   789: iconst_1
    //   790: putfield 59	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_custom	Z
    //   793: goto +844 -> 1637
    //   796: invokestatic 121	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getRes	()Landroid/content/res/Resources;
    //   799: pop
    //   800: aload 10
    //   802: astore 11
    //   804: aload 10
    //   806: ifnonnull +15 -> 821
    //   809: aload 13
    //   811: aload_2
    //   812: iconst_0
    //   813: invokevirtual 183	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   816: getfield 189	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   819: astore 11
    //   821: aload 11
    //   823: getfield 295	android/content/pm/ApplicationInfo:flags	I
    //   826: iconst_1
    //   827: iand
    //   828: ifeq +8 -> 836
    //   831: aload_0
    //   832: iconst_1
    //   833: putfield 73	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
    //   836: aconst_null
    //   837: astore 11
    //   839: aload 13
    //   841: aload_2
    //   842: sipush 4097
    //   845: invokevirtual 183	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   848: astore 12
    //   850: iconst_0
    //   851: istore 7
    //   853: aload 12
    //   855: astore 11
    //   857: aload 12
    //   859: astore 10
    //   861: iload 7
    //   863: aload 12
    //   865: getfield 266	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   868: arraylength
    //   869: if_icmpge +89 -> 958
    //   872: aload 12
    //   874: astore 11
    //   876: aload 12
    //   878: getfield 266	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   881: iload 7
    //   883: aaload
    //   884: getfield 269	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   887: invokestatic 272	com/chelpus/Utils:isAds	(Ljava/lang/String;)Z
    //   890: ifeq +21 -> 911
    //   893: aload 12
    //   895: astore 11
    //   897: aload_0
    //   898: iconst_4
    //   899: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   902: aload 12
    //   904: astore 11
    //   906: aload_0
    //   907: iconst_1
    //   908: putfield 67	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   911: iload 7
    //   913: iconst_1
    //   914: iadd
    //   915: istore 7
    //   917: goto -64 -> 853
    //   920: astore 10
    //   922: getstatic 256	java/lang/System:out	Ljava/io/PrintStream;
    //   925: new 297	java/lang/StringBuilder
    //   928: dup
    //   929: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   932: ldc_w 300
    //   935: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload 10
    //   940: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   943: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   946: invokevirtual 261	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   949: goto -113 -> 836
    //   952: astore 10
    //   954: aload 11
    //   956: astore 10
    //   958: aload 10
    //   960: astore 11
    //   962: aload 10
    //   964: ifnonnull +15 -> 979
    //   967: invokestatic 117	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   970: aload_2
    //   971: sipush 4096
    //   974: invokevirtual 183	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   977: astore 11
    //   979: aload 11
    //   981: getfield 311	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   984: ifnull +145 -> 1129
    //   987: aload 11
    //   989: getfield 311	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   992: arraylength
    //   993: ifeq +136 -> 1129
    //   996: iconst_0
    //   997: istore 7
    //   999: iload 7
    //   1001: aload 11
    //   1003: getfield 311	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   1006: arraylength
    //   1007: if_icmpge +122 -> 1129
    //   1010: aload 11
    //   1012: getfield 311	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   1015: iload 7
    //   1017: aaload
    //   1018: invokevirtual 314	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1021: ldc_w 316
    //   1024: invokevirtual 248	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1027: ifeq +37 -> 1064
    //   1030: aload_0
    //   1031: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1034: aload_1
    //   1035: invokevirtual 319	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1038: invokevirtual 322	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1041: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1044: ifne +20 -> 1064
    //   1047: aload_0
    //   1048: iconst_1
    //   1049: putfield 69	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   1052: aload_0
    //   1053: getfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1056: ifne +8 -> 1064
    //   1059: aload_0
    //   1060: iconst_3
    //   1061: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1064: aload 11
    //   1066: getfield 311	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   1069: iload 7
    //   1071: aaload
    //   1072: ldc_w 324
    //   1075: invokevirtual 248	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1078: ifeq +568 -> 1646
    //   1081: aload_0
    //   1082: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1085: aload_1
    //   1086: invokevirtual 319	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1089: invokevirtual 322	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1092: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1095: ifne +551 -> 1646
    //   1098: aload_0
    //   1099: getfield 67	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   1102: ifne +131 -> 1233
    //   1105: aload_0
    //   1106: iconst_1
    //   1107: putfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1110: aload_0
    //   1111: iconst_2
    //   1112: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1115: aload_0
    //   1116: getfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1119: ifeq +527 -> 1646
    //   1122: aload_0
    //   1123: getfield 69	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   1126: ifeq +520 -> 1646
    //   1129: aload_0
    //   1130: getfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1133: ifne +23 -> 1156
    //   1136: aload_0
    //   1137: getfield 67	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   1140: ifne +16 -> 1156
    //   1143: aload_0
    //   1144: getfield 69	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   1147: ifne +9 -> 1156
    //   1150: aload_0
    //   1151: bipush 6
    //   1153: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1156: aload_0
    //   1157: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1160: invokestatic 327	com/chelpus/Utils:isCustomPatchesForPkg	(Ljava/lang/String;)Z
    //   1163: ifeq +13 -> 1176
    //   1166: aload_0
    //   1167: iconst_1
    //   1168: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1171: aload_0
    //   1172: iconst_1
    //   1173: putfield 63	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   1176: invokestatic 331	java/lang/System:currentTimeMillis	()J
    //   1179: ldc2_w 216
    //   1182: ldiv
    //   1183: l2i
    //   1184: aload_0
    //   1185: getfield 77	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:updatetime	I
    //   1188: isub
    //   1189: invokestatic 337	java/lang/Math:abs	(I)I
    //   1192: ldc_w 338
    //   1195: iload_3
    //   1196: imul
    //   1197: if_icmpge +8 -> 1205
    //   1200: aload_0
    //   1201: iconst_0
    //   1202: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1205: aload_0
    //   1206: getfield 79	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:enable	Z
    //   1209: ifne +9 -> 1218
    //   1212: aload_0
    //   1213: bipush 10
    //   1215: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1218: return
    //   1219: astore 11
    //   1221: aload 11
    //   1223: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   1226: aload 10
    //   1228: astore 11
    //   1230: goto -251 -> 979
    //   1233: aload_0
    //   1234: iconst_2
    //   1235: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1238: aload_0
    //   1239: iconst_1
    //   1240: putfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1243: aload_0
    //   1244: getfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1247: ifeq +399 -> 1646
    //   1250: aload_0
    //   1251: getfield 69	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   1254: ifne -125 -> 1129
    //   1257: goto +389 -> 1646
    //   1260: astore 10
    //   1262: getstatic 256	java/lang/System:out	Ljava/io/PrintStream;
    //   1265: new 297	java/lang/StringBuilder
    //   1268: dup
    //   1269: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1272: ldc_w 340
    //   1275: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: aload 10
    //   1280: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokevirtual 261	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1289: aload 10
    //   1291: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   1294: goto -89 -> 1205
    //   1297: astore 10
    //   1299: aload 11
    //   1301: astore 10
    //   1303: aload 10
    //   1305: astore 11
    //   1307: aload 10
    //   1309: ifnonnull +15 -> 1324
    //   1312: invokestatic 117	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   1315: aload_2
    //   1316: sipush 4096
    //   1319: invokevirtual 183	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1322: astore 11
    //   1324: aload 11
    //   1326: getfield 311	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   1329: ifnull +145 -> 1474
    //   1332: aload 11
    //   1334: getfield 311	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   1337: arraylength
    //   1338: ifeq +136 -> 1474
    //   1341: iconst_0
    //   1342: istore 7
    //   1344: iload 7
    //   1346: aload 11
    //   1348: getfield 311	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   1351: arraylength
    //   1352: if_icmpge +122 -> 1474
    //   1355: aload 11
    //   1357: getfield 311	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   1360: iload 7
    //   1362: aaload
    //   1363: invokevirtual 314	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1366: ldc_w 316
    //   1369: invokevirtual 248	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1372: ifeq +37 -> 1409
    //   1375: aload_0
    //   1376: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1379: aload_1
    //   1380: invokevirtual 319	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1383: invokevirtual 322	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1386: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1389: ifne +20 -> 1409
    //   1392: aload_0
    //   1393: iconst_1
    //   1394: putfield 69	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   1397: aload_0
    //   1398: getfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1401: ifne +8 -> 1409
    //   1404: aload_0
    //   1405: iconst_3
    //   1406: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1409: aload 11
    //   1411: getfield 311	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   1414: iload 7
    //   1416: aaload
    //   1417: ldc_w 324
    //   1420: invokevirtual 248	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1423: ifeq +200 -> 1623
    //   1426: aload_0
    //   1427: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1430: aload_1
    //   1431: invokevirtual 319	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1434: invokevirtual 322	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1437: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1440: ifne +183 -> 1623
    //   1443: aload_0
    //   1444: getfield 67	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   1447: ifne +152 -> 1599
    //   1450: aload_0
    //   1451: iconst_1
    //   1452: putfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1455: aload_0
    //   1456: iconst_2
    //   1457: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1460: aload_0
    //   1461: getfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1464: ifeq +159 -> 1623
    //   1467: aload_0
    //   1468: getfield 69	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   1471: ifeq +152 -> 1623
    //   1474: aload_0
    //   1475: getfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1478: ifne +23 -> 1501
    //   1481: aload_0
    //   1482: getfield 67	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   1485: ifne +16 -> 1501
    //   1488: aload_0
    //   1489: getfield 69	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   1492: ifne +9 -> 1501
    //   1495: aload_0
    //   1496: bipush 6
    //   1498: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1501: aload_0
    //   1502: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1505: invokestatic 327	com/chelpus/Utils:isCustomPatchesForPkg	(Ljava/lang/String;)Z
    //   1508: ifeq +13 -> 1521
    //   1511: aload_0
    //   1512: iconst_1
    //   1513: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1516: aload_0
    //   1517: iconst_1
    //   1518: putfield 63	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   1521: invokestatic 331	java/lang/System:currentTimeMillis	()J
    //   1524: ldc2_w 216
    //   1527: ldiv
    //   1528: l2i
    //   1529: aload_0
    //   1530: getfield 77	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:updatetime	I
    //   1533: isub
    //   1534: invokestatic 337	java/lang/Math:abs	(I)I
    //   1537: ldc_w 338
    //   1540: iload_3
    //   1541: imul
    //   1542: if_icmpge -337 -> 1205
    //   1545: aload_0
    //   1546: iconst_0
    //   1547: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1550: goto -345 -> 1205
    //   1553: astore_1
    //   1554: getstatic 256	java/lang/System:out	Ljava/io/PrintStream;
    //   1557: new 297	java/lang/StringBuilder
    //   1560: dup
    //   1561: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1564: ldc_w 340
    //   1567: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: aload_1
    //   1571: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1574: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1577: invokevirtual 261	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1580: aload_1
    //   1581: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   1584: goto -379 -> 1205
    //   1587: astore_2
    //   1588: aload_2
    //   1589: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   1592: aload 10
    //   1594: astore 11
    //   1596: goto -272 -> 1324
    //   1599: aload_0
    //   1600: iconst_2
    //   1601: putfield 91	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1604: aload_0
    //   1605: iconst_1
    //   1606: putfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1609: aload_0
    //   1610: getfield 65	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1613: ifeq +10 -> 1623
    //   1616: aload_0
    //   1617: getfield 69	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   1620: ifne -146 -> 1474
    //   1623: iload 7
    //   1625: iconst_1
    //   1626: iadd
    //   1627: istore 7
    //   1629: goto -285 -> 1344
    //   1632: astore 11
    //   1634: goto -1419 -> 215
    //   1637: iload 7
    //   1639: iconst_1
    //   1640: iadd
    //   1641: istore 7
    //   1643: goto -898 -> 745
    //   1646: iload 7
    //   1648: iconst_1
    //   1649: iadd
    //   1650: istore 7
    //   1652: goto -653 -> 999
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1655	0	this	PkgListItem
    //   0	1655	1	paramContext	Context
    //   0	1655	2	paramString	String
    //   0	1655	3	paramInt	int
    //   0	1655	4	paramBoolean	boolean
    //   112	71	5	f1	float
    //   169	16	6	f2	float
    //   123	1528	7	i	int
    //   144	606	8	j	int
    //   151	51	9	k	int
    //   96	253	10	localApplicationInfo	android.content.pm.ApplicationInfo
    //   593	1	10	localNameNotFoundException1	PackageManager.NameNotFoundException
    //   615	3	10	localNullPointerException	NullPointerException
    //   649	211	10	localObject1	Object
    //   920	19	10	localException1	Exception
    //   952	1	10	localException2	Exception
    //   956	271	10	localObject2	Object
    //   1260	30	10	localException3	Exception
    //   1297	1	10	localException4	Exception
    //   1301	292	10	localObject3	Object
    //   93	103	11	localObject4	Object
    //   296	3	11	localNameNotFoundException2	PackageManager.NameNotFoundException
    //   306	3	11	localException5	Exception
    //   316	1	11	localOutOfMemoryError	OutOfMemoryError
    //   393	672	11	localObject5	Object
    //   1219	3	11	localException6	Exception
    //   1228	367	11	localObject6	Object
    //   1632	1	11	localException7	Exception
    //   178	725	12	localObject7	Object
    //   324	516	13	localPackageManager	PackageManager
    // Exception table:
    //   from	to	target	type
    //   125	215	296	android/content/pm/PackageManager$NameNotFoundException
    //   125	215	306	java/lang/Exception
    //   125	215	316	java/lang/OutOfMemoryError
    //   335	347	593	android/content/pm/PackageManager$NameNotFoundException
    //   347	425	593	android/content/pm/PackageManager$NameNotFoundException
    //   585	590	593	android/content/pm/PackageManager$NameNotFoundException
    //   326	331	615	java/lang/NullPointerException
    //   335	347	615	java/lang/NullPointerException
    //   347	425	615	java/lang/NullPointerException
    //   425	455	615	java/lang/NullPointerException
    //   458	511	615	java/lang/NullPointerException
    //   514	540	615	java/lang/NullPointerException
    //   540	558	615	java/lang/NullPointerException
    //   558	576	615	java/lang/NullPointerException
    //   585	590	615	java/lang/NullPointerException
    //   595	615	615	java/lang/NullPointerException
    //   719	732	615	java/lang/NullPointerException
    //   737	742	615	java/lang/NullPointerException
    //   759	793	615	java/lang/NullPointerException
    //   796	800	615	java/lang/NullPointerException
    //   809	821	615	java/lang/NullPointerException
    //   821	836	615	java/lang/NullPointerException
    //   839	850	615	java/lang/NullPointerException
    //   861	872	615	java/lang/NullPointerException
    //   876	893	615	java/lang/NullPointerException
    //   897	902	615	java/lang/NullPointerException
    //   906	911	615	java/lang/NullPointerException
    //   922	949	615	java/lang/NullPointerException
    //   967	979	615	java/lang/NullPointerException
    //   979	996	615	java/lang/NullPointerException
    //   999	1064	615	java/lang/NullPointerException
    //   1064	1129	615	java/lang/NullPointerException
    //   1129	1156	615	java/lang/NullPointerException
    //   1156	1176	615	java/lang/NullPointerException
    //   1176	1205	615	java/lang/NullPointerException
    //   1221	1226	615	java/lang/NullPointerException
    //   1233	1257	615	java/lang/NullPointerException
    //   1262	1294	615	java/lang/NullPointerException
    //   809	821	920	java/lang/Exception
    //   821	836	920	java/lang/Exception
    //   839	850	952	java/lang/Exception
    //   861	872	952	java/lang/Exception
    //   876	893	952	java/lang/Exception
    //   897	902	952	java/lang/Exception
    //   906	911	952	java/lang/Exception
    //   967	979	1219	java/lang/Exception
    //   1156	1176	1260	java/lang/Exception
    //   1176	1205	1260	java/lang/Exception
    //   629	640	1297	java/lang/Exception
    //   651	662	1297	java/lang/Exception
    //   666	683	1297	java/lang/Exception
    //   687	692	1297	java/lang/Exception
    //   696	701	1297	java/lang/Exception
    //   1501	1521	1553	java/lang/Exception
    //   1521	1550	1553	java/lang/Exception
    //   1312	1324	1587	java/lang/Exception
    //   103	114	1632	java/lang/Exception
    //   298	303	1632	java/lang/Exception
    //   308	313	1632	java/lang/Exception
  }
  
  public PkgListItem(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, Bitmap paramBitmap, int paramInt14, int paramInt15, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.pkgName = paramString1;
    this.name = paramString2;
    this.storepref = paramInt2;
    this.stored = paramInt1;
    this.enable = paramBoolean1;
    if (!this.enable) {
      this.stored = 10;
    }
    if (paramInt3 == 0)
    {
      this.hidden = false;
      this.statusi = paramString3;
      if (paramInt4 != 0) {
        break label301;
      }
      this.boot_ads = false;
      label157:
      if (paramInt5 != 0) {
        break label309;
      }
      this.boot_lvl = false;
      label167:
      if (paramInt6 != 0) {
        break label317;
      }
      this.boot_custom = false;
      label177:
      if (paramInt7 != 0) {
        break label325;
      }
      this.boot_manual = false;
      label187:
      if (paramInt8 != 0) {
        break label333;
      }
      this.custom = false;
      label197:
      if (paramInt9 != 0) {
        break label341;
      }
      this.lvl = false;
      label207:
      if (paramInt10 != 0) {
        break label349;
      }
      this.ads = false;
      label217:
      if (paramInt11 != 0) {
        break label357;
      }
      this.modified = false;
      label227:
      this.on_sd = paramBoolean2;
      if (paramInt12 != 0) {
        break label365;
      }
      this.system = false;
      label243:
      if (paramInt13 != 0) {
        break label373;
      }
      this.odex = false;
      label253:
      if (paramInt15 != 0) {
        break label381;
      }
    }
    label301:
    label309:
    label317:
    label325:
    label333:
    label341:
    label349:
    label357:
    label365:
    label373:
    label381:
    for (this.billing = false;; this.billing = true)
    {
      if (!paramBoolean3)
      {
        if (paramBitmap == null) {
          break label389;
        }
        this.updatetime = paramInt14;
        this.icon = new BitmapDrawable(paramBitmap);
      }
      return;
      this.hidden = true;
      break;
      this.boot_ads = true;
      break label157;
      this.boot_lvl = true;
      break label167;
      this.boot_custom = true;
      break label177;
      this.boot_manual = true;
      break label187;
      this.custom = true;
      break label197;
      this.lvl = true;
      break label207;
      this.ads = true;
      break label217;
      this.modified = true;
      break label227;
      this.system = true;
      break label243;
      this.odex = true;
      break label253;
    }
    label389:
    paramContext = paramContext.getPackageManager();
    paramInt1 = (int)(35.0F * listAppsFragment.getRes().getDisplayMetrics().density + 0.5F);
    try
    {
      paramContext = ((BitmapDrawable)paramContext.getApplicationIcon(this.pkgName)).getBitmap();
      paramInt2 = paramContext.getWidth();
      paramInt3 = paramContext.getHeight();
      float f1 = paramInt1 / paramInt2;
      float f2 = paramInt1 / paramInt3;
      paramString1 = new Matrix();
      paramString1.postScale(f1, f2);
      this.icon = new BitmapDrawable(Bitmap.createBitmap(paramContext, 0, 0, paramInt2, paramInt3, paramString1, true));
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (OutOfMemoryError paramContext) {}
  }
  
  public boolean equalsPli(PkgListItem paramPkgListItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.pkgName.equals(paramPkgListItem.pkgName))
      {
        bool1 = bool2;
        if (this.name.equals(paramPkgListItem.name))
        {
          bool1 = bool2;
          if (this.stored == paramPkgListItem.stored)
          {
            bool1 = bool2;
            if (this.storepref == paramPkgListItem.storepref)
            {
              bool1 = bool2;
              if (this.hidden == paramPkgListItem.hidden)
              {
                bool1 = bool2;
                if (this.boot_ads == paramPkgListItem.boot_ads)
                {
                  bool1 = bool2;
                  if (this.boot_lvl == paramPkgListItem.boot_lvl)
                  {
                    bool1 = bool2;
                    if (this.boot_custom == paramPkgListItem.boot_custom)
                    {
                      bool1 = bool2;
                      if (this.boot_manual == paramPkgListItem.boot_manual)
                      {
                        bool1 = bool2;
                        if (this.custom == paramPkgListItem.custom)
                        {
                          bool1 = bool2;
                          if (this.lvl == paramPkgListItem.lvl)
                          {
                            bool1 = bool2;
                            if (this.ads == paramPkgListItem.ads)
                            {
                              bool1 = bool2;
                              if (this.modified == paramPkgListItem.modified)
                              {
                                bool1 = bool2;
                                if (this.on_sd == paramPkgListItem.on_sd)
                                {
                                  bool1 = bool2;
                                  if (this.system == paramPkgListItem.system)
                                  {
                                    bool1 = bool2;
                                    if (this.odex == paramPkgListItem.odex)
                                    {
                                      bool1 = bool2;
                                      if (this.enable == paramPkgListItem.enable)
                                      {
                                        bool1 = bool2;
                                        if (this.billing == paramPkgListItem.billing)
                                        {
                                          int i = this.updatetime;
                                          int j = paramPkgListItem.updatetime;
                                          bool1 = bool2;
                                          if (i == j) {
                                            bool1 = true;
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    catch (NullPointerException localNullPointerException)
    {
      System.out.println("LuckyPacther: " + paramPkgListItem.pkgName);
      localNullPointerException.printStackTrace();
    }
    return false;
  }
  
  public int getColor()
  {
    switch (this.stored)
    {
    default: 
      return 2131427329;
    case 0: 
      return 2131427333;
    case 1: 
      return 2131427328;
    case 2: 
      return 2131427331;
    }
    return 2131427330;
  }
  
  public void saveItem()
  {
    if (listAppsFragment.database == null) {
      listAppsFragment.database = new DatabaseHelper(listAppsFragment.getInstance());
    }
    listAppsFragment.database.savePackage(this);
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/PkgListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */