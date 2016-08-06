package com.android.vending.billing.InAppBillingService.LACK;

public class BindItem
{
  public String SourceDir = "";
  public String TargetDir = "";
  
  public BindItem(String paramString)
  {
    paramString = paramString.split(";");
    if (paramString.length == 2)
    {
      this.SourceDir = paramString[0];
      this.TargetDir = paramString[1];
    }
  }
  
  public BindItem(String paramString1, String paramString2)
  {
    this.SourceDir = paramString1;
    this.TargetDir = paramString2;
  }
  
  public String toString()
  {
    return this.SourceDir + ";" + this.TargetDir;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/BindItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */