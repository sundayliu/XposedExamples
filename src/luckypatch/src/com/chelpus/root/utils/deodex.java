package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class deodex
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    Utils.kill(paramArrayOfString[0]);
    Utils.remount(paramArrayOfString[1], "rw");
    try
    {
      if (Utils.getFileDalvikCache(paramArrayOfString[1]) == null) {
        throw new FileNotFoundException();
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
      Object localObject;
      if (Utils.classes_test(new File(paramArrayOfString[1])))
      {
        paramArrayOfString = Utils.getPlaceForOdex(paramArrayOfString[1], true);
        localObject = new File(paramArrayOfString);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        localObject = new File(paramArrayOfString.replace("-2", "-1"));
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        localObject = new File(paramArrayOfString.replace("-1", "-2"));
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        localObject = new File(paramArrayOfString.replace("-2", ""));
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        paramArrayOfString = new File(paramArrayOfString.replace("-1", ""));
        if (paramArrayOfString.exists()) {
          paramArrayOfString.delete();
        }
      }
      for (;;)
      {
        Utils.exitFromRootJava();
        return;
        localObject = Utils.getPlaceForOdex(paramArrayOfString[1], true);
        File localFile = new File((String)localObject);
        if (localFile.exists()) {
          localFile.delete();
        }
        localFile = new File(((String)localObject).replace("-2", "-1"));
        if (localFile.exists()) {
          localFile.delete();
        }
        localFile = new File(((String)localObject).replace("-1", "-2"));
        if (localFile.exists()) {
          localFile.delete();
        }
        localFile = new File(((String)localObject).replace("-2", ""));
        if (localFile.exists()) {
          localFile.delete();
        }
        localObject = new File(((String)localObject).replace("-1", ""));
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/deodex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */