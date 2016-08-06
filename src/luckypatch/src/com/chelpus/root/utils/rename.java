package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class rename
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    File localFile = new File(paramArrayOfString[0]);
    paramArrayOfString = new File(paramArrayOfString[1]);
    System.out.println(localFile);
    System.out.println(paramArrayOfString);
    localFile.renameTo(paramArrayOfString);
    System.out.println("File rename from " + localFile + " to " + paramArrayOfString);
    Utils.exitFromRootJava();
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/rename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */