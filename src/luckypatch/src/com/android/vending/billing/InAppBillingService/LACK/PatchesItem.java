package com.android.vending.billing.InAppBillingService.LACK;

public class PatchesItem
{
  public String group = "";
  public boolean groupResult = false;
  public boolean insert = false;
  public byte[] origByte;
  public int[] origMask;
  public byte[] repByte;
  public int[] repMask;
  public boolean result = false;
  
  public PatchesItem(byte[] paramArrayOfByte1, int[] paramArrayOfInt1, byte[] paramArrayOfByte2, int[] paramArrayOfInt2, String paramString, boolean paramBoolean)
  {
    this.origByte = new byte[paramArrayOfByte1.length];
    this.origByte = paramArrayOfByte1;
    this.origMask = new int[paramArrayOfInt1.length];
    this.origMask = paramArrayOfInt1;
    this.repByte = new byte[paramArrayOfByte2.length];
    this.repByte = paramArrayOfByte2;
    this.repMask = new int[paramArrayOfInt2.length];
    this.repMask = paramArrayOfInt2;
    this.group = paramString;
    this.insert = paramBoolean;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/PatchesItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */