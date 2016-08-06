package com.google.android.vending.licensing;

public class StrictPolicy
  implements Policy
{
  private int mLastResponse = 291;
  
  public boolean allowAccess()
  {
    return this.mLastResponse == 256;
  }
  
  public void processServerResponse(int paramInt, ResponseData paramResponseData)
  {
    this.mLastResponse = paramInt;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/vending/licensing/StrictPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */