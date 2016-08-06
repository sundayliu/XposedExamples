package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class reworkSuperSu
{
  public static void main(String[] paramArrayOfString)
  {
    String str1 = "";
    Utils.startRootJava(new Object() {});
    if (paramArrayOfString[0] != null) {
      str1 = paramArrayOfString[0];
    }
    if (!str1.equals("none")) {}
    try
    {
      String str2 = str1 + "/files/supersu.cfg";
      paramArrayOfString = str1 + "/shared_prefs/eu.chainfire.supersu_preferences.xml";
      if (new File(str2).exists())
      {
        str1 = Utils.read_from_file(new File(str2));
        if (str1.contains("enablemountnamespaceseparation=1"))
        {
          System.out.println("Mount name space separation in SuperSu detected.");
          System.out.println("Try disable.");
          str1 = str1.replace("enablemountnamespaceseparation=1", "enablemountnamespaceseparation=0");
          Utils.save_text_to_file(new File(str2), str1);
          System.out.println("supersu.cfg fixed.");
          if (new File(paramArrayOfString).exists())
          {
            str1 = Utils.read_from_file(new File(paramArrayOfString));
            if (str1.contains("<boolean name=\"config_default_enablemountnamespaceseparation\" value=\"true\" />"))
            {
              System.out.println("Try disable to prefs.");
              str1 = str1.replace("<boolean name=\"config_default_enablemountnamespaceseparation\" value=\"true\" />", "<boolean name=\"config_default_enablemountnamespaceseparation\" value=\"false\" />");
              Utils.save_text_to_file(new File(paramArrayOfString), str1);
              System.out.println("supersu prefs fixed.");
              Utils.reboot();
            }
          }
        }
      }
      Utils.exitFromRootJava();
      return;
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/reworkSuperSu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */