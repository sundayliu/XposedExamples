package com.android.vending.billing.InAppBillingService.LACK;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Mount
{
  protected final File mDevice;
  protected final Set<String> mFlags;
  protected final File mMountPoint;
  protected final String mType;
  
  public Mount(File paramFile1, File paramFile2, String paramString1, String paramString2)
  {
    this.mDevice = paramFile1;
    this.mMountPoint = paramFile2;
    this.mType = paramString1;
    this.mFlags = new HashSet(Arrays.asList(paramString2.split(",")));
  }
  
  public File getDevice()
  {
    return this.mDevice;
  }
  
  public Set<String> getFlags()
  {
    return this.mFlags;
  }
  
  public File getMountPoint()
  {
    return this.mMountPoint;
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public String toString()
  {
    return String.format("%s on %s type %s %s", new Object[] { this.mDevice, this.mMountPoint, this.mType, this.mFlags });
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/Mount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */