package com.google.android.vending.licensing;

public class NullDeviceLimiter
  implements DeviceLimiter
{
  public int isDeviceAllowed(String paramString)
  {
    return 256;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/vending/licensing/NullDeviceLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */