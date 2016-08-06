package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class checkDataSize
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(null);
    paramArrayOfString = new File(paramArrayOfString[0]);
    Utils localUtils = new Utils("calculSize");
    float f1 = 0.0F;
    try
    {
      float f2 = localUtils.sizeFolder(paramArrayOfString, true);
      f1 = f2;
    }
    catch (IOException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    System.out.println(String.format("%.3f", new Object[] { Float.valueOf(f1) }));
    Utils.exitFromRootJava();
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/checkDataSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */