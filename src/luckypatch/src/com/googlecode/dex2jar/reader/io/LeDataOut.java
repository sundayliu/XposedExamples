package com.googlecode.dex2jar.reader.io;

import java.io.IOException;
import java.io.OutputStream;

public class LeDataOut
  implements DataOut
{
  private OutputStream os;
  
  public LeDataOut(OutputStream paramOutputStream)
  {
    this.os = paramOutputStream;
  }
  
  public void writeByte(int paramInt)
    throws IOException
  {
    this.os.write(paramInt);
  }
  
  public void writeBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    this.os.write(paramArrayOfByte);
  }
  
  public void writeInt(int paramInt)
    throws IOException
  {
    this.os.write(paramInt);
    this.os.write(paramInt >> 8);
    this.os.write(paramInt >> 16);
    this.os.write(paramInt >>> 24);
  }
  
  public void writeShort(int paramInt)
    throws IOException
  {
    this.os.write(paramInt);
    this.os.write(paramInt >> 8);
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/googlecode/dex2jar/reader/io/LeDataOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */