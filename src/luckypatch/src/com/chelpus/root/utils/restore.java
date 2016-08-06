package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class restore
{
  private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
  private static String dalvikDexIn2 = "/cache/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
  
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava();
    Object localObject3 = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]);
    try
    {
      Object localObject2 = new File((String)localObject3);
      localObject1 = localObject2;
      if (!((File)localObject2).exists()) {
        localObject1 = new File(((String)localObject3).replace("-1", "-2"));
      }
      localObject2 = new File(((String)localObject3).replace("-1", ""));
      if (((File)localObject1).exists()) {
        localObject2 = localObject1;
      }
      String str = ((String)localObject3).replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
      localObject1 = new File(str);
      if (((File)localObject1).exists()) {
        localObject2 = localObject1;
      }
      localObject3 = new File(str.replace("-1", "-2"));
      localObject1 = localObject2;
      if (((File)localObject3).exists()) {
        localObject1 = localObject3;
      }
      localObject2 = new File(str.replace("-1", ""));
      if (((File)localObject2).exists()) {
        localObject1 = localObject2;
      }
      str = dalvikDexIn2.replace("zamenitetodelo", paramArrayOfString[0]);
      localObject3 = new File(str);
      localObject2 = localObject3;
      if (!((File)localObject3).exists()) {
        localObject2 = new File(str.replace("-1", "-2"));
      }
      localObject3 = localObject2;
      if (!((File)localObject2).exists()) {
        localObject3 = new File(str.replace("-1", ""));
      }
      if (((File)localObject3).exists()) {
        localObject1 = localObject3;
      }
      localObject3 = str.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
      localObject2 = new File((String)localObject3);
      if (((File)localObject2).exists()) {
        localObject1 = localObject2;
      }
      localObject2 = new File(((String)localObject3).replace("-1", "-2"));
      if (((File)localObject2).exists()) {
        localObject1 = localObject2;
      }
      localObject2 = new File(((String)localObject3).replace("-1", ""));
      if (((File)localObject2).exists()) {
        localObject1 = localObject2;
      }
      str = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]).replace("/data/", "/sd-ext/data/");
      localObject3 = new File(str);
      localObject2 = localObject3;
      if (!((File)localObject3).exists()) {
        localObject2 = new File(str.replace("-1", "-2"));
      }
      localObject3 = localObject2;
      if (!((File)localObject2).exists()) {
        localObject3 = new File(str.replace("-1", ""));
      }
      if (((File)localObject3).exists()) {
        localObject1 = localObject3;
      }
      localObject3 = str.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
      localObject2 = new File((String)localObject3);
      if (((File)localObject2).exists()) {
        localObject1 = localObject2;
      }
      localObject2 = new File(((String)localObject3).replace("-1", "-2"));
      if (((File)localObject2).exists()) {
        localObject1 = localObject2;
      }
      localObject2 = new File(((String)localObject3).replace("-1", ""));
      if (((File)localObject2).exists()) {
        localObject1 = localObject2;
      }
      localObject3 = dalvikDexIn2.replace("zamenitetodelo", paramArrayOfString[0]).replace("/cache/", "/sd-ext/data/cache/");
      localObject2 = new File((String)localObject3);
      paramArrayOfString = (String[])localObject2;
      if (!((File)localObject2).exists()) {
        paramArrayOfString = new File(((String)localObject3).replace("-1", "-2"));
      }
      localObject2 = paramArrayOfString;
      if (!paramArrayOfString.exists()) {
        localObject2 = new File(((String)localObject3).replace("-1", ""));
      }
      if (((File)localObject2).exists()) {
        localObject1 = localObject2;
      }
      localObject2 = ((String)localObject3).replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
      paramArrayOfString = new File((String)localObject2);
      if (paramArrayOfString.exists()) {
        localObject1 = paramArrayOfString;
      }
      paramArrayOfString = new File(((String)localObject2).replace("-1", "-2"));
      if (paramArrayOfString.exists()) {
        localObject1 = paramArrayOfString;
      }
      paramArrayOfString = new File(((String)localObject2).replace("-1", ""));
      if (paramArrayOfString.exists()) {
        localObject1 = paramArrayOfString;
      }
      if (!((File)localObject1).exists()) {
        throw new FileNotFoundException();
      }
    }
    catch (FileNotFoundException paramArrayOfString)
    {
      System.out.println("Error: Backup files are not found!");
      Utils.exitFromRootJava();
      return;
      paramArrayOfString = new File(((File)localObject1).getAbsolutePath().replace("classes", "backup"));
      if (!paramArrayOfString.exists()) {
        throw new FileNotFoundException();
      }
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        Object localObject1;
        System.out.println("Exception e" + paramArrayOfString.toString());
        continue;
        Utils.copyFile(paramArrayOfString, (File)localObject1);
        System.out.println("Restore - done!");
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/restore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */