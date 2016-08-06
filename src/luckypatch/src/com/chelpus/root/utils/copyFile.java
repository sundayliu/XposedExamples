package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class copyFile
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    File localFile = new File(paramArrayOfString[0]);
    paramArrayOfString = new File(paramArrayOfString[1]);
    new Utils("").setAllReadable(localFile);
    if (localFile.equals(paramArrayOfString))
    {
      System.out.println(paramArrayOfString.length());
      System.out.println("File copied!");
      Utils.exitFromRootJava();
      return;
    }
    System.out.println(localFile);
    System.out.println(paramArrayOfString);
    if (localFile.exists()) {}
    for (;;)
    {
      try
      {
        Utils.copyFile(localFile, paramArrayOfString);
        if ((localFile.length() != paramArrayOfString.length()) && (localFile.length() != 0L))
        {
          paramArrayOfString.delete();
          System.out.println("Length of Files not equals. Destination deleted!");
          Utils.exitFromRootJava();
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        new Utils("").setAllWritable(paramArrayOfString);
        new Utils("").setAllReadable(paramArrayOfString);
        System.out.println(paramArrayOfString.length());
        System.out.println("File copied!");
        continue;
      }
      System.out.println("Source File not Found!");
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/copyFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */