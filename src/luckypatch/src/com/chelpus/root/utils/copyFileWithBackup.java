package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class copyFileWithBackup
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    File localFile1 = new File(paramArrayOfString[0]);
    File localFile2 = new File(paramArrayOfString[1]);
    if (localFile1.equals(localFile2))
    {
      System.out.println("File copied!");
      Utils.exitFromRootJava();
      return;
    }
    paramArrayOfString = new File(paramArrayOfString[1] + ".chelpus.tmp");
    System.out.println(localFile1);
    System.out.println(localFile2);
    if (localFile1.exists()) {}
    for (;;)
    {
      try
      {
        Utils.copyFile(localFile1, paramArrayOfString);
        if ((localFile1.length() != paramArrayOfString.length()) && (localFile1.length() != 0L))
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
        localFile2.delete();
        paramArrayOfString.renameTo(localFile2);
        if ((!paramArrayOfString.exists()) && (localFile2.exists()) && (localFile1.length() == localFile2.length()))
        {
          if (new File(Utils.getPlaceForOdex(localFile2.getAbsolutePath(), true)).exists()) {
            new File(Utils.getPlaceForOdex(localFile2.getAbsolutePath(), true)).delete();
          }
          System.out.println(localFile2.length());
          System.out.println("File copied!");
          continue;
        }
        System.out.println("Backup not replace original!");
        continue;
      }
      System.out.println("Source File not Found!");
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/copyFileWithBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */