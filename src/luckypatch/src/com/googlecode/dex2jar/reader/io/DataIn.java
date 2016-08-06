package com.googlecode.dex2jar.reader.io;

public abstract interface DataIn
{
  public abstract int getCurrentPosition();
  
  public abstract void move(int paramInt);
  
  public abstract void pop();
  
  public abstract void push();
  
  public abstract void pushMove(int paramInt);
  
  public abstract int readByte();
  
  public abstract byte[] readBytes(int paramInt);
  
  public abstract int readIntx();
  
  public abstract long readLeb128();
  
  public abstract int readShortx();
  
  public abstract int readUByte();
  
  public abstract int readUIntx();
  
  public abstract long readULeb128();
  
  public abstract int readUShortx();
  
  public abstract void skip(int paramInt);
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/googlecode/dex2jar/reader/io/DataIn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */