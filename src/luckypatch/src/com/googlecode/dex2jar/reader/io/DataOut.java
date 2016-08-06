package com.googlecode.dex2jar.reader.io;

import java.io.IOException;

public abstract interface DataOut
{
  public abstract void writeByte(int paramInt)
    throws IOException;
  
  public abstract void writeBytes(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract void writeInt(int paramInt)
    throws IOException;
  
  public abstract void writeShort(int paramInt)
    throws IOException;
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/googlecode/dex2jar/reader/io/DataOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */