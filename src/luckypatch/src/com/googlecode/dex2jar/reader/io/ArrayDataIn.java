package com.googlecode.dex2jar.reader.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Stack;

public class ArrayDataIn
  extends ByteArrayInputStream
  implements DataIn
{
  private boolean isLE;
  private Stack<Integer> stack = new Stack();
  
  public ArrayDataIn(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramArrayOfByte, paramInt1, paramInt2);
    this.isLE = paramBoolean;
  }
  
  public ArrayDataIn(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    super(paramArrayOfByte);
    this.isLE = paramBoolean;
  }
  
  public static ArrayDataIn be(byte[] paramArrayOfByte)
  {
    return new ArrayDataIn(paramArrayOfByte, false);
  }
  
  public static ArrayDataIn be(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ArrayDataIn(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public static ArrayDataIn le(byte[] paramArrayOfByte)
  {
    return new ArrayDataIn(paramArrayOfByte, true);
  }
  
  public static ArrayDataIn le(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ArrayDataIn(paramArrayOfByte, paramInt1, paramInt2, true);
  }
  
  public int getCurrentPosition()
  {
    return this.pos - this.mark;
  }
  
  public void move(int paramInt)
  {
    this.pos = (this.mark + paramInt);
  }
  
  public void pop()
  {
    this.pos = ((Integer)this.stack.pop()).intValue();
  }
  
  public void push()
  {
    this.stack.push(Integer.valueOf(this.pos));
  }
  
  public void pushMove(int paramInt)
  {
    push();
    move(paramInt);
  }
  
  public int readByte()
  {
    return (byte)readUByte();
  }
  
  public byte[] readBytes(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      super.read(arrayOfByte);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public int readIntx()
  {
    return readUIntx();
  }
  
  public long readLeb128()
  {
    int i = 0;
    long l2 = 0L;
    int k;
    long l1;
    int j;
    do
    {
      k = readUByte();
      l1 = l2 | (k & 0x7F) << i;
      j = i + 7;
      i = j;
      l2 = l1;
    } while ((k & 0x80) != 0);
    l2 = l1;
    if ((1L << j - 1 & l1) != 0L) {
      l2 = l1 - (1L << j);
    }
    return l2;
  }
  
  public int readShortx()
  {
    return (short)readUShortx();
  }
  
  public int readUByte()
  {
    if (this.pos >= this.count) {
      throw new RuntimeException("EOF");
    }
    return super.read();
  }
  
  public int readUIntx()
  {
    if (this.isLE) {
      return readUByte() | readUByte() << 8 | readUByte() << 16 | readUByte() << 24;
    }
    return readUByte() << 24 | readUByte() << 16 | readUByte() << 8 | readUByte();
  }
  
  public long readULeb128()
  {
    long l = 0L;
    int j = 0;
    for (int i = readUByte(); (i & 0x80) != 0; i = readUByte())
    {
      l |= (i & 0x7F) << j;
      j += 7;
    }
    return l | (i & 0x7F) << j;
  }
  
  public int readUShortx()
  {
    if (this.isLE) {
      return readUByte() | readUByte() << 8;
    }
    return readUByte() << 8 | readUByte();
  }
  
  public void skip(int paramInt)
  {
    super.skip(paramInt);
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/googlecode/dex2jar/reader/io/ArrayDataIn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */