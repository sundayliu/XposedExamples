package com.android.vending.billing.InAppBillingService.LACK;

public class Components
{
  public String Name;
  public boolean Status;
  public boolean activity = false;
  public boolean header = false;
  public boolean permission = false;
  public boolean provider = false;
  public boolean reciver = false;
  public boolean service = false;
  
  public Components(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.Name = paramString;
    this.Status = paramBoolean1;
    this.permission = paramBoolean2;
    this.activity = paramBoolean3;
    this.provider = paramBoolean4;
    this.service = paramBoolean5;
    this.reciver = paramBoolean6;
    this.header = paramBoolean7;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/Components.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */