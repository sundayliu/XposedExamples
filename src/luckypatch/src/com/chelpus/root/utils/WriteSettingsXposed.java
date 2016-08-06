package com.chelpus.root.utils;

import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.google.util.Base64;
import com.google.android.finsky.billing.iab.google.util.Base64DecoderException;
import java.io.File;

public class WriteSettingsXposed
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    try
    {
      Utils.save_text_to_file(new File("/data/lp/xposed"), new String(Base64.decode(paramArrayOfString[0])));
      new File("/data/lp/xposed").setLastModified(System.currentTimeMillis());
      Utils.run_all_no_root(new String[] { "chmod", "777", "/data/lp/xposed" });
      return;
    }
    catch (Base64DecoderException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/WriteSettingsXposed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */