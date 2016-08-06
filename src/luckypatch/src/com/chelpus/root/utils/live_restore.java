package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class live_restore
{
  private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
  
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    String str = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]);
    try
    {
      localObject = new File(str);
      paramArrayOfString = (String[])localObject;
      if (!((File)localObject).exists()) {
        paramArrayOfString = new File(str.replace("-1", "-2"));
      }
      localObject = new File(str.replace("-1", ""));
      if (paramArrayOfString.exists()) {
        localObject = paramArrayOfString;
      }
      str = str.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
      paramArrayOfString = new File(str);
      if (paramArrayOfString.exists()) {
        localObject = paramArrayOfString;
      }
      paramArrayOfString = new File(str.replace("-1", "-2"));
      if (paramArrayOfString.exists()) {
        localObject = paramArrayOfString;
      }
      paramArrayOfString = new File(str.replace("-1", ""));
      if (paramArrayOfString.exists()) {
        localObject = paramArrayOfString;
      }
      if (!((File)localObject).exists()) {
        throw new FileNotFoundException();
      }
    }
    catch (FileNotFoundException paramArrayOfString)
    {
      System.out.println("Error: Backup files are not found!");
      Utils.exitFromRootJava();
      return;
      paramArrayOfString = new File(((File)localObject).getAbsolutePath().replace("classes", "backup"));
      if (!paramArrayOfString.exists()) {
        throw new FileNotFoundException();
      }
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        Object localObject;
        System.out.println("Exception e" + paramArrayOfString.toString());
        continue;
        Utils.copyFile(paramArrayOfString, (File)localObject);
        System.out.println("Restore - done!");
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/live_restore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */