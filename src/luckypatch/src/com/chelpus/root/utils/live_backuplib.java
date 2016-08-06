package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class live_backuplib
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    String str = paramArrayOfString[0];
    try
    {
      Object localObject = new File(str);
      paramArrayOfString = new File(str.replace("/data/data/", "/mnt/asec/"));
      if (((File)localObject).exists()) {
        paramArrayOfString = (String[])localObject;
      }
      localObject = paramArrayOfString;
      if (!paramArrayOfString.exists()) {
        localObject = new File(str + "-1");
      }
      paramArrayOfString = (String[])localObject;
      if (!((File)localObject).exists()) {
        paramArrayOfString = new File(str.replace("-1", "-2"));
      }
      if (!paramArrayOfString.exists()) {
        throw new FileNotFoundException();
      }
    }
    catch (FileNotFoundException paramArrayOfString)
    {
      System.out.println("Error: Backup failed!\n\nMove Program to internal storage.");
      for (;;)
      {
        Utils.exitFromRootJava();
        return;
        Utils.copyFile(paramArrayOfString, new File(paramArrayOfString.getAbsolutePath() + ".backup"));
        System.out.println("Backup - done!");
      }
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        System.out.println("Exception e" + paramArrayOfString.toString());
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/live_backuplib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */