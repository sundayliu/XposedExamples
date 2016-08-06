package com.android.vending.billing.InAppBillingService.LACK;

public class StringItem
{
  public boolean bits32 = false;
  public byte[] offset = null;
  public String str = "";
  
  public StringItem(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.offset = paramArrayOfByte;
    this.str = paramString;
    this.bits32 = paramBoolean;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/StringItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */