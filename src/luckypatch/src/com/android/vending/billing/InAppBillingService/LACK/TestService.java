package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class TestService
  extends Service
{
  private final ITestServiceInterface.Stub mBinder = new ITestServiceInterface.Stub()
  {
    public boolean checkService()
      throws RemoteException
    {
      return true;
    }
  };
  ITestServiceInterface mService;
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mBinder;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/TestService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */