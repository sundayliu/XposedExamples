package com.android.vending.billing.InAppBillingService.LACK;

public class CommandItem
{
  public byte[] Method = null;
  public byte[] Object = null;
  public boolean bits32 = false;
  public boolean found_id_object = false;
  public boolean found_index_command = false;
  public byte[] id_object = null;
  public byte[] index_command = null;
  public String method = null;
  public String object = null;
  
  public CommandItem(String paramString1, String paramString2)
  {
    this.object = paramString1;
    this.method = paramString2;
    this.Object = new byte[4];
    this.Method = new byte[4];
    this.bits32 = false;
    this.id_object = new byte[2];
    this.index_command = new byte[2];
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/CommandItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */