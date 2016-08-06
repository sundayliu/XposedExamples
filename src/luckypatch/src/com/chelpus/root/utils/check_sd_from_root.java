package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class check_sd_from_root
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    try
    {
      if (new File(paramArrayOfString[0] + "/test.tmp").exists())
      {
        System.out.println("LuckyPatcher: Found test.tmp");
        new File(paramArrayOfString[0] + "/test.tmp").delete();
      }
      Utils.exitFromRootJava();
      return;
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/check_sd_from_root.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */