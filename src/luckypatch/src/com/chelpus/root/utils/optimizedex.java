package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class optimizedex
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    String str1 = paramArrayOfString[0];
    String str2 = paramArrayOfString[1];
    paramArrayOfString = paramArrayOfString[2];
    String str3 = listAppsFragment.toolfilesdir + "/tmp";
    int i = 255;
    if (Utils.classes_test(new File(str1))) {
      i = Utils.dexopt(str1, str3, Utils.getOdexForCreate(str1, str2), str2, Boolean.valueOf(paramArrayOfString.equals("ART")));
    }
    for (;;)
    {
      if (i == 0) {
        System.out.println("chelpus_return_0");
      }
      if (i == 1) {
        System.out.println("chelpus_return_1");
      }
      if (i == 4) {
        System.out.println("chelpus_return_4");
      }
      Utils.exitFromRootJava();
      return;
      System.out.println("chelpus_return_10");
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/optimizedex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */