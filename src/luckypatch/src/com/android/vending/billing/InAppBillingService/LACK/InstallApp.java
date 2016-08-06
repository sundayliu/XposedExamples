package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class InstallApp
  extends Activity
{
  public Context context;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getDataString();
    Toast.makeText(this, "" + paramBundle, 0).show();
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/InstallApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */