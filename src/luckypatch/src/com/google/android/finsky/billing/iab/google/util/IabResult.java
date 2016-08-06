package com.google.android.finsky.billing.iab.google.util;

public class IabResult
{
  String mMessage;
  int mResponse;
  
  public IabResult(int paramInt, String paramString)
  {
    this.mResponse = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.mMessage = IabHelper.getResponseDesc(paramInt);
      return;
    }
    this.mMessage = (paramString + " (response: " + IabHelper.getResponseDesc(paramInt) + ")");
  }
  
  public String getMessage()
  {
    return this.mMessage;
  }
  
  public int getResponse()
  {
    return this.mResponse;
  }
  
  public boolean isFailure()
  {
    return !isSuccess();
  }
  
  public boolean isSuccess()
  {
    return this.mResponse == 0;
  }
  
  public String toString()
  {
    return "IabResult: " + getMessage();
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/finsky/billing/iab/google/util/IabResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */