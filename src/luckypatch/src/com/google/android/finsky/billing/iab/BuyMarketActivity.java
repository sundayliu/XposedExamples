package com.google.android.finsky.billing.iab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.PrintStream;

public class BuyMarketActivity
  extends Activity
{
  public static final String BUY_INTENT = "org.billinghack.BUY";
  public static final String EXTRA_DEV_PAYLOAD = "payload";
  public static final String EXTRA_PACKAGENAME = "packageName";
  public static final String EXTRA_PRODUCT_ID = "product";
  public static final String TAG = "BillingHack";
  CheckBox check = null;
  CheckBox check2 = null;
  CheckBox check3 = null;
  public BuyMarketActivity context = null;
  String pData;
  public String packageName = "";
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    int i = paramConfiguration.orientation;
    if (i == 2) {
      setRequestedOrientation(0);
    }
    if (i == 1) {
      setRequestedOrientation(1);
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.context = this;
    Log.d("BillingHack", "Buy intent!");
    if (paramBundle != null) {
      this.packageName = paramBundle.getString("packageName");
    }
    for (;;)
    {
      paramBundle = getIntent().getExtras().getString("autorepeat");
      Button localButton;
      if (paramBundle != null)
      {
        if (paramBundle.equals("1"))
        {
          listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", false).commit();
          paramBundle = new Intent("com.android.vending.billing.IN_APP_NOTIFY");
          paramBundle.setPackage(this.packageName);
          paramBundle.putExtra("notification_id", "" + Utils.getRandom(1000000000000000000L, Long.MAX_VALUE));
          sendBroadcast(paramBundle);
          finish();
        }
      }
      else
      {
        setContentView(2130968594);
        paramBundle = (Button)findViewById(2131558407);
        localButton = (Button)findViewById(2131558408);
        listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", false).commit();
        listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("SavePurchase", false).commit();
        this.check = ((CheckBox)findViewById(2131558488));
        this.check2 = ((CheckBox)findViewById(2131558489));
        this.check3 = ((CheckBox)findViewById(2131558490));
        TextView localTextView = (TextView)findViewById(2131558476);
        localTextView.setText(Utils.getText(2131165222));
        localTextView.append("\n" + Utils.getText(2131165223));
        this.check.setChecked(false);
        this.check2.setChecked(false);
        this.check3.setChecked(false);
      }
      try
      {
        if ((!Utils.checkCoreJarPatch11()) && (!Utils.isRebuildedOrOdex(this.packageName, this))) {
          this.check.setChecked(true);
        }
        paramBundle.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (!BuyMarketActivity.this.check.isChecked())
            {
              listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", false).commit();
              if (BuyMarketActivity.this.check2.isChecked()) {
                break label226;
              }
              listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("SavePurchase", false).commit();
              label82:
              if (BuyMarketActivity.this.check3.isChecked()) {
                break label257;
              }
              listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("AutoRepeat", false).commit();
            }
            for (;;)
            {
              paramAnonymousView = new Intent("com.android.vending.billing.IN_APP_NOTIFY");
              paramAnonymousView.setPackage(BuyMarketActivity.this.packageName);
              paramAnonymousView.putExtra("notification_id", "" + Utils.getRandom(1000000000000000000L, Long.MAX_VALUE));
              BuyMarketActivity.this.sendBroadcast(paramAnonymousView);
              BuyMarketActivity.this.finish();
              return;
              listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", true).commit();
              break;
              label226:
              listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("SavePurchase", true).commit();
              break label82;
              label257:
              listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("AutoRepeat", true).commit();
            }
          }
        });
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new Intent();
            Bundle localBundle = new Bundle();
            localBundle.putInt("RESPONSE_CODE", 1);
            paramAnonymousView.putExtras(localBundle);
            BuyMarketActivity.this.setResult(0, paramAnonymousView);
            BuyMarketActivity.this.finish();
          }
        });
        return;
        this.packageName = getIntent().getExtras().getString("packageName");
        continue;
        listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", true).commit();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    System.out.println("load instance");
    this.packageName = paramBundle.getString("packageName");
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    System.out.println("save instance");
    paramBundle.putString("packageName", this.packageName);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/finsky/billing/iab/BuyMarketActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */