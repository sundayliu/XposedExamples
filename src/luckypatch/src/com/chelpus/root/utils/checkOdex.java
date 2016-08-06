package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class checkOdex
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    localFile = new File(Utils.getPlaceForOdex(paramArrayOfString[0], true));
    paramArrayOfString = new File(paramArrayOfString[1] + "/" + paramArrayOfString[2]);
    try
    {
      if (localFile.length() == 0L) {
        localFile.delete();
      }
      if ((!localFile.exists()) || (localFile.length() == 0L)) {
        break label102;
      }
      System.out.println("ODEX FILE FOUND!");
      Utils.exitFromRootJava();
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        try
        {
          label102:
          boolean bool;
          Utils.copyFile(paramArrayOfString, localFile);
          if (paramArrayOfString.length() != localFile.length()) {
            localFile.delete();
          }
          if (localFile.length() == 0L) {
            localFile.delete();
          }
          if ((!localFile.exists()) || (localFile.length() == 0L)) {
            continue;
          }
          System.out.println("ODEX FILE FOUND!");
          continue;
          paramArrayOfString = paramArrayOfString;
          System.out.println("Exception e" + paramArrayOfString.toString());
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localFile.delete();
          continue;
        }
        System.out.println("ODEX FILE NOT FOUND!");
      }
    }
    return;
    bool = paramArrayOfString.exists();
    if (!bool) {}
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/checkOdex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */