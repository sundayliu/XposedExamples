package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelpCommon
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new WebView(this);
    setContentView(paramBundle);
    paramBundle.getSettings().setDefaultFontSize(14);
    InputStream localInputStream = getResources().openRawResource(2131099659);
    byte[] arrayOfByte = new byte['Ȁ'];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      for (;;)
      {
        int i = localInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramBundle.loadData(localByteArrayOutputStream.toString(), "text/html; charset=UTF-8", null);
    }
    catch (IOException paramBundle)
    {
      paramBundle.printStackTrace();
      return;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/HelpCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */