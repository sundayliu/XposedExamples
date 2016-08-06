package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class transferSettings
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    String str1 = paramArrayOfString[0];
    String str2 = paramArrayOfString[1];
    String str3 = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[3].replace(str2 + "/app_lptest", "");
    System.out.println("dt:" + paramArrayOfString);
    for (;;)
    {
      try
      {
        Utils.killAll(str1);
        new Utils("").setAllWritable(new File(paramArrayOfString + str1));
        new Utils("").setAllWritable(new File(paramArrayOfString + str2));
        Utils.copyFolder(new File(paramArrayOfString + str1), new File(paramArrayOfString + str2));
        if (!new File(paramArrayOfString + str2 + "/files/busybox").exists()) {
          continue;
        }
        System.out.println("busybox found");
        new Utils("tr").fixPermissions(new File(paramArrayOfString + str2), "775");
        new Utils("r1").fixOwners(new File(paramArrayOfString + str2), str3 + ":" + str3);
        new Utils("r2").fixOwners(new File(paramArrayOfString + str2), str3 + "." + str3);
        Utils.run_all_no_root(new String[] { "chmod", "777", paramArrayOfString + str2 + "/files/busybox" });
        Utils.run_all_no_root(new String[] { "chown", "0:0", paramArrayOfString + str2 + "/files/busybox" });
        Utils.run_all_no_root(new String[] { "chown", "0.0", paramArrayOfString + str2 + "/files/busybox" });
        Utils.run_all_no_root(new String[] { "chmod", "777", paramArrayOfString + str2 + "/files/reboot" });
        Utils.run_all_no_root(new String[] { "chown", "0:0", paramArrayOfString + str2 + "/files/reboot" });
        Utils.run_all_no_root(new String[] { "chown", "0.0", paramArrayOfString + str2 + "/files/reboot" });
        Utils.run_all_no_root(new String[] { "chmod", "777", paramArrayOfString + str2 + "/files/zipalign" });
        Utils.run_all_no_root(new String[] { "chown", "0:0", paramArrayOfString + str2 + "/files/zipalign" });
        Utils.run_all_no_root(new String[] { "chown", "0.0", paramArrayOfString + str2 + "/files/zipalign" });
        Utils.run_all_no_root(new String[] { "chmod", "777", paramArrayOfString + str2 + "/files/p.apk" });
        Utils.run_all_no_root(new String[] { "chown", "0:0", paramArrayOfString + str2 + "/files/p.apk" });
        Utils.run_all_no_root(new String[] { "chown", "0.0", paramArrayOfString + str2 + "/files/p.apk" });
        new File(paramArrayOfString + str2 + "/files/p.apk").delete();
        Utils.run_all_no_root(new String[] { "chmod", "777", paramArrayOfString + str2 + "/files/dalvikvm" });
        Utils.run_all_no_root(new String[] { "chown", "0:0", paramArrayOfString + str2 + "/files/dalvikvm" });
        Utils.run_all_no_root(new String[] { "chown", "0.0", paramArrayOfString + str2 + "/files/dalvikvm" });
        System.out.println("all data copied to new settings");
        Utils.exitFromRootJava();
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        continue;
      }
      return;
      System.out.println("busybox not found");
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/transferSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */