package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;

public class reworkhost
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    Utils.save_text_to_file(new File("/system/etc/hosts"), "127.0.0.1       localhost\n");
    Utils.cmdParam(new String[] { "chmod", "0644", "/system/etc/hosts" });
    Utils.exitFromRootJava();
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/reworkhost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */