package com.android.vending.billing.InAppBillingService.LACK;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.io.File;

public class FileApkListItem
{
  public File backupfile;
  public Drawable icon;
  public String name = "Bad file";
  public String pkgName;
  public int versionCode;
  public String versionName;
  
  public FileApkListItem(Context paramContext, File paramFile, boolean paramBoolean)
    throws IllegalArgumentException
  {
    this.backupfile = paramFile;
    PackageManager localPackageManager = listAppsFragment.getPkgMng();
    PackageInfo localPackageInfo = localPackageManager.getPackageArchiveInfo(paramFile.toString(), 1);
    if (localPackageInfo != null)
    {
      ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
      if (Build.VERSION.SDK_INT >= 8)
      {
        localApplicationInfo.sourceDir = paramFile.toString();
        localApplicationInfo.publicSourceDir = paramFile.toString();
      }
      this.pkgName = localPackageInfo.packageName;
      this.name = localApplicationInfo.loadLabel(localPackageManager).toString();
      int i;
      if (paramBoolean)
      {
        i = (int)(35.0F * listAppsFragment.getRes().getDisplayMetrics().density + 0.5F);
        paramContext = null;
      }
      try
      {
        paramFile = ((BitmapDrawable)localApplicationInfo.loadIcon(localPackageManager)).getBitmap();
        paramContext = paramFile;
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          int j;
          int k;
          float f1;
          float f2;
          paramFile.printStackTrace();
        }
      }
      j = paramContext.getWidth();
      k = paramContext.getHeight();
      f1 = i / j;
      f2 = i / k;
      paramFile = new Matrix();
      paramFile.postScale(f1, f2);
      this.icon = new BitmapDrawable(Bitmap.createBitmap(paramContext, 0, 0, j, k, paramFile, true));
      localApplicationInfo.loadIcon(localPackageManager);
      this.versionName = localPackageInfo.versionName;
      this.versionCode = localPackageInfo.versionCode;
      return;
    }
    throw new IllegalArgumentException("oblom");
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/FileApkListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */