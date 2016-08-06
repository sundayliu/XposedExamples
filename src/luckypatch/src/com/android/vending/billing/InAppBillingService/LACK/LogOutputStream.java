package com.android.vending.billing.InAppBillingService.LACK;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LogOutputStream
  extends OutputStream
{
  public String allresult = "";
  private ByteArrayOutputStream bos = new ByteArrayOutputStream();
  private String name;
  
  public LogOutputStream(String paramString)
  {
    this.name = paramString;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    if (paramInt == 10)
    {
      String str = new String(this.bos.toByteArray());
      this.allresult = (this.allresult + str + "\n");
      this.bos = new ByteArrayOutputStream();
      return;
    }
    this.bos.write(paramInt);
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/LogOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */