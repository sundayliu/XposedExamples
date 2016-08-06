package com.android.vending.billing.InAppBillingService.LACK;

public class PatchesItemAuto
{
  public String marker = "";
  public boolean markerTrig = false;
  public byte[] origByte;
  public int[] origMask;
  public boolean pattern = false;
  public byte[] repByte;
  public int[] repMask;
  public boolean result = false;
  public String resultText = "";
  
  public PatchesItemAuto(byte[] paramArrayOfByte1, int[] paramArrayOfInt1, byte[] paramArrayOfByte2, int[] paramArrayOfInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    this.origByte = new byte[paramArrayOfByte1.length];
    this.origByte = paramArrayOfByte1;
    this.origMask = new int[paramArrayOfInt1.length];
    this.origMask = paramArrayOfInt1;
    this.repByte = new byte[paramArrayOfByte2.length];
    this.repByte = paramArrayOfByte2;
    this.repMask = new int[paramArrayOfInt2.length];
    this.repMask = paramArrayOfInt2;
    this.pattern = paramBoolean;
    this.resultText = paramString1;
    this.marker = paramString2;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/PatchesItemAuto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */