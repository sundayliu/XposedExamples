package com.android.vending.billing.InAppBillingService.LACK;

import android.os.FileObserver;
import com.chelpus.Utils;
import java.io.PrintStream;

public class LuckyFileObserver
  extends FileObserver
{
  public String absolutePath;
  public int i = 0;
  
  public LuckyFileObserver(String paramString)
  {
    super(paramString, 4095);
    this.absolutePath = paramString;
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    System.out.println(this.absolutePath + "/" + paramString + "\n");
    if (paramString == null) {}
    do
    {
      return;
      if ((paramInt & 0x100) != 0)
      {
        Utils.copyFile("/" + paramString, "/mnt/sdcard/!Capture" + this.i + ".jar", false, true);
        this.i += 1;
        System.out.println(this.absolutePath + "/" + paramString + " is created\n");
      }
      if ((paramInt & 0x20) != 0) {
        System.out.println(paramString + " is opened\n");
      }
      if ((paramInt & 0x1) != 0) {
        System.out.println(this.absolutePath + "/" + paramString + " is accessed/read\n");
      }
      if ((paramInt & 0x2) != 0) {
        System.out.println(this.absolutePath + "/" + paramString + " is modified\n");
      }
      if ((paramInt & 0x10) != 0) {
        System.out.println(paramString + " is closed\n");
      }
      if ((paramInt & 0x8) != 0) {
        System.out.println(this.absolutePath + "/" + paramString + " is written and closed\n");
      }
      if ((paramInt & 0x200) != 0) {
        System.out.println(this.absolutePath + "/" + paramString + " is deleted\n");
      }
      if ((paramInt & 0x400) != 0) {
        System.out.println(this.absolutePath + "/" + " is deleted\n");
      }
      if ((paramInt & 0x40) != 0) {
        System.out.println(this.absolutePath + "/" + paramString + " is moved to somewhere " + "\n");
      }
      if ((paramInt & 0x80) != 0) {
        System.out.println("File is moved to " + this.absolutePath + "/" + paramString + "\n");
      }
      if ((paramInt & 0x800) != 0) {
        System.out.println(paramString + " is moved\n");
      }
    } while ((paramInt & 0x4) == 0);
    System.out.println(this.absolutePath + "/" + paramString + " is changed (permissions, owner, timestamp)\n");
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/LuckyFileObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */