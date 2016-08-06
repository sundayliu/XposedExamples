package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class odex
{
  private static String dalvikDexIn;
  private static String dalvikDexIn2 = "/cache/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
  public static String dirapp;
  public static boolean odexpatch = false;
  public static boolean system;
  public static String toolsfiledir = "";
  public static String uid = "";
  
  static
  {
    dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
    dirapp = "/data/app/";
    system = false;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    dirapp = paramArrayOfString[1];
    if (paramArrayOfString[2].equals("not_system")) {
      system = false;
    }
    if (paramArrayOfString[2].equals("system")) {
      system = true;
    }
    if (paramArrayOfString[3] != null) {
      toolsfiledir = paramArrayOfString[3];
    }
    if (paramArrayOfString[4] != null) {
      uid = paramArrayOfString[4];
    }
    Utils.kill(paramArrayOfString[0]);
    Utils.remount(dirapp, "RW");
    Object localObject1 = new File(dirapp);
    Object localObject2 = new File(Utils.getOdexForCreate(dirapp, uid));
    if ((system) && (((File)localObject1).exists()) && (((File)localObject2).exists()) && (!Utils.classes_test((File)localObject1)))
    {
      odexpatch = true;
      System.out.println("\nOdex Application.\nOnly ODEX patch is enabled.\n");
    }
    Object localObject3;
    if (!odexpatch) {
      localObject3 = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]);
    }
    try
    {
      localObject2 = new File((String)localObject3);
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
      str = dalvikDexIn2.replace("zamenitetodelo", paramArrayOfString[0]).replace("/cache/", "/sd-ext/data/cache/");
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
      localObject2 = localObject1;
      if (system)
      {
        localObject2 = new File(dirapp).getName();
        localObject3 = dalvikDexIn.replace("zamenitetodelo-1.apk", (CharSequence)localObject2).replace("data@app", "system@app");
        localObject2 = new File((String)localObject3);
        if (((File)localObject2).exists()) {
          localObject1 = localObject2;
        }
        localObject2 = new File(((String)localObject3).replace("/data/dalvik-cache/", "/sd-ext/data/dalvik-cache/"));
        if (((File)localObject2).exists()) {
          localObject1 = localObject2;
        }
        localObject2 = new File(((String)localObject3).replace("/data/dalvik-cache/", "/sd-ext/data/cache/dalvik-cache/"));
        if (((File)localObject2).exists()) {
          localObject1 = localObject2;
        }
        localObject2 = new File(((String)localObject3).replace("/data/dalvik-cache/", "/cache/dalvik-cache/"));
        if (((File)localObject2).exists()) {
          localObject1 = localObject2;
        }
        localObject3 = new File(((String)localObject3).replace("/data/dalvik-cache/", "/data/dalvik-cache/arm/"));
        localObject2 = localObject1;
        if (((File)localObject3).exists()) {
          localObject2 = localObject3;
        }
      }
      if (!((File)localObject2).exists()) {
        throw new FileNotFoundException();
      }
    }
    catch (FileNotFoundException paramArrayOfString)
    {
      System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
      for (;;)
      {
        Utils.exitFromRootJava();
        return;
        paramArrayOfString = Utils.getOdexForCreate(paramArrayOfString[1], uid);
        localObject1 = new File(paramArrayOfString);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        localObject1 = new File(paramArrayOfString.replace("-2", "-1"));
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        localObject1 = new File(paramArrayOfString.replace("-1", "-2"));
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        localObject1 = new File(paramArrayOfString.replace("-2", ""));
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        localObject1 = new File(paramArrayOfString.replace("-1", ""));
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        paramArrayOfString = new File(paramArrayOfString);
        Utils.copyFile((File)localObject2, paramArrayOfString);
        if (paramArrayOfString.exists())
        {
          System.out.println("Changes Fix to: " + paramArrayOfString);
          if (system) {
            break;
          }
          Utils.run_all_no_root(new String[] { "chmod", "644" + paramArrayOfString.getAbsolutePath() });
          Utils.run_all_no_root(new String[] { "chown", "1000." + uid, paramArrayOfString.getAbsolutePath() });
          Utils.run_all_no_root(new String[] { "chown", "1000:" + uid, paramArrayOfString.getAbsolutePath() });
        }
        System.out.println("Dalvik-cache fixing!");
      }
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        System.out.println("Error: Exception e" + paramArrayOfString.toString());
        continue;
        Utils.run_all_no_root(new String[] { "chmod", "644" + paramArrayOfString.getAbsolutePath() });
        Utils.run_all_no_root(new String[] { "chown", "0.0", paramArrayOfString.getAbsolutePath() });
        Utils.run_all_no_root(new String[] { "chown", "0:0", paramArrayOfString.getAbsolutePath() });
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/odex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */