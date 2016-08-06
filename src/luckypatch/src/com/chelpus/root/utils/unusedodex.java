package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class unusedodex
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    int m = 0;
    int k = 0;
    int i = 0;
    int j = m;
    try
    {
      paramArrayOfString = new File("/data/app/");
      j = m;
      if (paramArrayOfString.exists())
      {
        j = m;
        paramArrayOfString = paramArrayOfString.listFiles();
        j = m;
        int n = paramArrayOfString.length;
        m = 0;
        for (;;)
        {
          k = i;
          if (m >= n) {
            break;
          }
          String str = paramArrayOfString[m];
          j = i;
          File localFile = new File(Utils.changeExtension(str.toString(), "apk"));
          k = i;
          j = i;
          if (str.toString().toLowerCase().endsWith(".odex"))
          {
            k = i;
            j = i;
            if (!localFile.exists())
            {
              j = i;
              str.delete();
              j = i;
              System.out.println(str + "|");
              k = i + 1;
            }
          }
          m += 1;
          i = k;
        }
      }
      return;
    }
    catch (Exception paramArrayOfString)
    {
      System.out.println("Exception e" + paramArrayOfString.toString());
      k = j;
      if (k > 0) {
        System.out.println("Unused ODEX in /data/app/ removed!");
      }
      Utils.exitFromRootJava();
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/unusedodex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */