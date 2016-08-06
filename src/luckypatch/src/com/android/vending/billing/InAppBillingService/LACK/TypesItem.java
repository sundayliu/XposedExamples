package com.android.vending.billing.InAppBillingService.LACK;

public class TypesItem
{
  public byte[] Type = null;
  public boolean bits32 = false;
  public boolean found_id_type = false;
  public byte[] id_type = null;
  public String type = null;
  
  public TypesItem(String paramString)
  {
    this.type = paramString;
    this.Type = new byte[4];
    this.bits32 = false;
    this.id_type = new byte[2];
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/TypesItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */