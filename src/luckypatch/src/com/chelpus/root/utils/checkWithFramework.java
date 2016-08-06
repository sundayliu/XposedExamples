package com.chelpus.root.utils;

import android.util.Log;
import com.chelpus.Utils;
import java.io.PrintStream;

public class checkWithFramework
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    try
    {
      Log.d("", "");
      System.out.println("found wtchFrm");
      Utils.exitFromRootJava();
      return;
    }
    catch (UnsatisfiedLinkError paramArrayOfString)
    {
      System.out.println("withoutFramework");
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/checkWithFramework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */