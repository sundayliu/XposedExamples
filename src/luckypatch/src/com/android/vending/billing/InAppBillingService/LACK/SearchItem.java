package com.android.vending.billing.InAppBillingService.LACK;

public class SearchItem
{
  public byte[] origByte;
  public int[] origMask;
  public byte[] repByte;
  public boolean result = false;
  
  public SearchItem(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    this.origByte = new byte[paramArrayOfByte.length];
    this.origByte = paramArrayOfByte;
    this.origMask = new int[paramArrayOfInt.length];
    this.origMask = paramArrayOfInt;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/SearchItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */