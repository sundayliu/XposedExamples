package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class corecopy
{
  public static String toolfilesdir = "";
  
  public static void main(String[] paramArrayOfString)
  {
    if (paramArrayOfString[3] != null) {
      toolfilesdir = paramArrayOfString[3];
    }
    Utils.startRootJava(new Object() {});
    Utils.remount("/system", "rw");
    File localFile1;
    File localFile2;
    if (paramArrayOfString[1].contains("odex"))
    {
      localFile1 = new File("/system/framework/core.patched");
      new File("/system/framework/services.patched");
      localFile2 = new File(paramArrayOfString[0]);
      new File(paramArrayOfString[2]);
      if ((0 == 0) && (!paramArrayOfString[0].contains("empty")) && (!Utils.exists("/system/framework/not.space")))
      {
        if (localFile2.length() != localFile1.length()) {
          break label405;
        }
        if (!localFile1.exists()) {
          break label394;
        }
        new File("/system/framework/not.space").delete();
      }
    }
    for (;;)
    {
      try
      {
        new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").createNewFile();
        if (new File("/system/framework/core.odex").exists())
        {
          Utils.run_all_no_root(new String[] { "rm", "/system/framework/core.odex" });
          if (new File("/system/framework/core.odex").exists()) {
            new File("/system/framework/core.odex").delete();
          }
        }
        localFile1.renameTo(new File("/system/framework/core.odex"));
        Utils.run_all_no_root(new String[] { "chmod", "644", "/system/framework/core.odex" });
        Utils.run_all_no_root(new String[] { "chown", "0.0", "/system/framework/core.odex" });
        Utils.run_all_no_root(new String[] { "chown", "0:0", "/system/framework/core.odex" });
        Utils.run_all_no_root(new String[] { "rm", localFile2.getAbsolutePath() });
        if (localFile2.exists()) {
          localFile2.delete();
        }
        System.out.println("LuckyPatcher: Core odexed!");
        if (paramArrayOfString[1].contains("delete"))
        {
          paramArrayOfString = new File("/system/framework/core.patched");
          if (paramArrayOfString.exists()) {
            paramArrayOfString.delete();
          }
        }
        Utils.exitFromRootJava();
        return;
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
        continue;
      }
      label394:
      System.out.println("LuckyPatcher: Core odexed failed!");
      continue;
      try
      {
        label405:
        new File("/system/framework/not.space").createNewFile();
        new File("/system/framework/core.patched").delete();
        new File("/system/framework/patch1.done").delete();
        new File("/system/framework/patch1.2.done").delete();
        new File("/system/framework/patch2.done").delete();
        new File("/system/framework/patch3.done").delete();
        new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").delete();
        System.out.println("LuckyPatcher: Core odexed failed 2!");
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          localIOException1.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/corecopy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */