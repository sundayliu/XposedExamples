package com.google.android.finsky.services;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.android.vending.licensing.ILicenseResultListener;
import com.android.vending.licensing.ILicenseResultListener.Stub;
import com.android.vending.licensing.ILicensingService;
import com.android.vending.licensing.ILicensingService.Stub;
import com.chelpus.Utils;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class LicensingService
  extends Service
{
  static ServiceConnection mServiceConn;
  private final ILicensingService.Stub mBinder = new ILicensingService.Stub()
  {
    public void checkLicense(long paramAnonymousLong, String paramAnonymousString, ILicenseResultListener paramAnonymousILicenseResultListener)
      throws RemoteException
    {
      try
      {
        PackageInfo localPackageInfo = LicensingService.this.getPackageManager().getPackageInfo(paramAnonymousString, 0);
        LicensingService.this.connectToLicensing(paramAnonymousLong, paramAnonymousString);
        if ((LicensingService.this.responseCode != 255) && (LicensingService.this.responseCode == 0))
        {
          System.out.println("Transfer license from Google Play");
          paramAnonymousILicenseResultListener.verifyLicense(LicensingService.this.responseCode, LicensingService.this.signedData, LicensingService.this.signature);
          return;
        }
        paramAnonymousString = "0|" + paramAnonymousLong + "|" + paramAnonymousString + "|" + localPackageInfo.versionCode + "|ANlOHQOShF3uJUwv3Ql+fbsgEG9FD35Hag==|" + (System.currentTimeMillis() + 31536000000L) + ":GR=10&VT=" + String.valueOf(System.currentTimeMillis() + Long.valueOf("31622400000").longValue()) + "&GT=" + String.valueOf(System.currentTimeMillis() + 31536000000L + 31536000000L);
        new Utils("w").waitLP(4000L);
        paramAnonymousILicenseResultListener.verifyLicense(0, paramAnonymousString, "hL9GqWwZL35OoLxZQN1EYmyylu3zmf8umnXW4P0EPqGjV0QcRYjD+NtiqoDEmxnnocvrqA7Z/0v+i0O4cwgOsD7/Tg3B1QI/ukA7ZUcibvFQUNoq7KjUWSg1Qn5MauaFFhAhZbuP840wnCuntxVDUkVJ6GDymDXLqhFG1LbZmNoPl6QjkschEBLVth1YtBxE4GnbVVI8Cq5LY7/F0N8d6EGLIISD6ekoD4lkhxq3nORsibX7kjmotyhLpO7THNMXvOeXeKhVp6dNSblOHp9tcL6l/NJY7sHPw/DBSxteW2hZ9y7yyaMxMAz+nTIN/V8gJXzeaRlmIXntJpQDEMz5pQ==");
        return;
      }
      catch (Exception paramAnonymousString)
      {
        try
        {
          paramAnonymousILicenseResultListener.verifyLicense(258, null, null);
          return;
        }
        catch (RemoteException paramAnonymousString) {}
      }
    }
  };
  public LicenseChecker mChecker;
  private ILicenseResultListener mListener;
  ILicensingService mService;
  boolean mSetupDone = false;
  public int responseCode = 255;
  public String signature = "";
  public String signedData = "";
  
  private void cleanupService()
  {
    if (this.mService != null) {}
    try
    {
      listAppsFragment.getInstance().unbindService(mServiceConn);
      this.mService = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public void connectToLicensing(final long paramLong, final String paramString)
  {
    mServiceConn = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        System.out.println("Licensing service try to connect.");
        LicensingService.this.mService = ILicensingService.Stub.asInterface(paramAnonymousIBinder);
        try
        {
          System.out.println("Calling checkLicense on service for " + paramString);
          LicensingService.this.mService.checkLicense(paramLong, paramString, new ILicenseResultListener.Stub()
          {
            public void verifyLicense(int paramAnonymous2Int, String paramAnonymous2String1, String paramAnonymous2String2)
              throws RemoteException
            {
              LicensingService.this.responseCode = paramAnonymous2Int;
              if (LicensingService.this.responseCode == 259) {}
              LicensingService.this.signedData = paramAnonymous2String1;
              LicensingService.this.signature = paramAnonymous2String2;
              LicensingService.this.mSetupDone = true;
            }
          });
          return;
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          paramAnonymousComponentName.printStackTrace();
          LicensingService.this.mSetupDone = true;
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        System.out.println("Licensing service disconnected.");
        LicensingService.this.mService = null;
      }
    };
    if (this.mService == null) {}
    for (;;)
    {
      int j;
      int i;
      try
      {
        paramString = new Intent(new String(Base64.decode("Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U=")));
        paramString.setPackage("com.android.vending");
        paramString.putExtra("xexe", "lp");
        j = 0;
        boolean bool = false;
        if (listAppsFragment.getPkgMng().queryIntentServices(paramString, 0).isEmpty()) {
          new Utils("w").waitLP(5000L);
        }
        if (listAppsFragment.getPkgMng().queryIntentServices(paramString, 0).isEmpty()) {
          break label306;
        }
        paramString = listAppsFragment.getPkgMng().queryIntentServices(paramString, 0).iterator();
        j = bool;
        if (!paramString.hasNext()) {
          break label306;
        }
        Object localObject = (ResolveInfo)paramString.next();
        if ((((ResolveInfo)localObject).serviceInfo.packageName == null) || (!((ResolveInfo)localObject).serviceInfo.packageName.equals("com.android.vending"))) {
          continue;
        }
        localObject = new ComponentName(((ResolveInfo)localObject).serviceInfo.packageName, ((ResolveInfo)localObject).serviceInfo.name);
        Intent localIntent = new Intent();
        localIntent.setComponent((ComponentName)localObject);
        localIntent.putExtra("xexe", "lp");
        bool = listAppsFragment.getInstance().bindService(localIntent, mServiceConn, 1);
        continue;
        if (!this.mSetupDone)
        {
          new Utils("w").waitLP(2000L);
          if (i <= 10) {
            break label318;
          }
        }
        System.out.println("Stop licensing");
        cleanupService();
        return;
      }
      catch (SecurityException paramString)
      {
        cleanupService();
        return;
      }
      catch (Base64DecoderException paramString)
      {
        paramString.printStackTrace();
        cleanupService();
        return;
      }
      cleanupService();
      return;
      label306:
      if (j != 0)
      {
        i = 0;
        continue;
        return;
        label318:
        i += 1;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mBinder;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/finsky/services/LicensingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */