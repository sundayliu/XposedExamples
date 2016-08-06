package com.google.android.finsky.billing.iab;

public class ItemsListItem
{
  public int autobuy = 0;
  public String itemID;
  public String pData;
  public String pSignature;
  public int savePurchase = 0;
  
  public ItemsListItem(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.itemID = paramString1;
    this.pData = paramString2;
    this.pSignature = paramString3;
    this.savePurchase = paramInt1;
    this.autobuy = paramInt2;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/finsky/billing/iab/ItemsListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */