package com.google.android.finsky.billing.iab;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.chelpus.Utils;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

public class BuyActivity
  extends Activity
{
  public static final String BUY_INTENT = "com.google.android.finsky.billing.iab.BUY";
  public static final String EXTRA_DEV_PAYLOAD = "payload";
  public static final String EXTRA_PACKAGENAME = "packageName";
  public static final String EXTRA_PRODUCT_ID = "product";
  public static final String TAG = "BillingHack";
  Bundle bundle = null;
  public BuyActivity context = null;
  String devPayload = "";
  String packageName = "";
  String productId = "";
  String type = "";
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation == 2) {
      setRequestedOrientation(0);
    }
    for (;;)
    {
      super.onConfigurationChanged(paramConfiguration);
      return;
      setRequestedOrientation(1);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.context = this;
    if (("com.google.android.finsky.billing.iab.BUY".equals(getIntent().getAction())) || (paramBundle != null))
    {
      Log.d("BillingHack", "Buy intent!");
      System.out.println(getRequestedOrientation());
      if (paramBundle != null)
      {
        this.packageName = paramBundle.getString("packageName");
        this.productId = paramBundle.getString("product");
        this.devPayload = paramBundle.getString("payload");
        this.type = paramBundle.getString("Type");
      }
      for (;;)
      {
        System.out.println(this.type);
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("orderId", Utils.getRandom(1000000000000000000L, Long.MAX_VALUE) + Utils.getRandom(0L, 9L) + "." + Utils.getRandom(1000000000000000L, 9999999999999999L));
          paramBundle.put("packageName", this.packageName);
          paramBundle.put("productId", this.productId);
          paramBundle.put("purchaseTime", new Long(System.currentTimeMillis()));
          paramBundle.put("purchaseState", new Integer(0));
          paramBundle.put("developerPayload", this.devPayload);
          paramBundle.put("purchaseToken", Utils.getRandomStringLowerCase(24));
          str = paramBundle.toString();
          paramBundle = getIntent().getExtras().getString("autorepeat");
          if (paramBundle != null)
          {
            localObject1 = new Intent();
            localObject2 = new Bundle();
            if (paramBundle.equals("1"))
            {
              paramBundle = Utils.gen_sha1withrsa(str);
              ((Bundle)localObject2).putInt("RESPONSE_CODE", 0);
              ((Bundle)localObject2).putString("INAPP_PURCHASE_DATA", str);
              ((Bundle)localObject2).putString("INAPP_DATA_SIGNATURE", paramBundle);
              ((Intent)localObject1).putExtras((Bundle)localObject2);
              setResult(-1, (Intent)localObject1);
              finish();
            }
          }
          else
          {
            setContentView(2130968594);
            paramBundle = (Button)findViewById(2131558407);
            localObject1 = (Button)findViewById(2131558408);
            localObject2 = (CheckBox)findViewById(2131558488);
          }
        }
        catch (JSONException localJSONException)
        {
          try
          {
            for (;;)
            {
              final String str;
              Object localObject1;
              final Object localObject2;
              if ((!Utils.checkCoreJarPatch11()) && (!Utils.isRebuildedOrOdex(this.packageName, this))) {
                ((CheckBox)localObject2).setChecked(true);
              }
              final CheckBox localCheckBox1 = (CheckBox)findViewById(2131558489);
              final CheckBox localCheckBox2 = (CheckBox)findViewById(2131558490);
              TextView localTextView = (TextView)findViewById(2131558476);
              localTextView.setText(Utils.getText(2131165222));
              localTextView.append("\n" + Utils.getText(2131165223));
              localCheckBox1.setChecked(false);
              localCheckBox2.setChecked(false);
              paramBundle.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymousView)
                {
                  Intent localIntent = new Intent();
                  Bundle localBundle = new Bundle();
                  String str;
                  if (!localObject2.isChecked())
                  {
                    str = Utils.gen_sha1withrsa(str);
                    paramAnonymousView = "1";
                  }
                  for (;;)
                  {
                    if ((localCheckBox2.isChecked()) || (localCheckBox1.isChecked()))
                    {
                      int j = 0;
                      int i = 0;
                      if (localCheckBox2.isChecked()) {
                        i = 1;
                      }
                      if (localCheckBox1.isChecked()) {
                        j = 1;
                      }
                      new DbHelper(BuyActivity.this.getApplicationContext(), BuyActivity.this.packageName).saveItem(new ItemsListItem(BuyActivity.this.productId, str, paramAnonymousView, j, i));
                    }
                    localBundle.putInt("RESPONSE_CODE", 0);
                    localBundle.putString("INAPP_PURCHASE_DATA", str);
                    localBundle.putString("INAPP_DATA_SIGNATURE", str);
                    localIntent.putExtras(localBundle);
                    BuyActivity.this.setResult(-1, localIntent);
                    BuyActivity.this.finish();
                    return;
                    paramAnonymousView = "";
                    str = "";
                  }
                }
              });
              ((Button)localObject1).setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymousView)
                {
                  paramAnonymousView = new Intent();
                  Bundle localBundle = new Bundle();
                  localBundle.putInt("RESPONSE_CODE", 1);
                  paramAnonymousView.putExtras(localBundle);
                  BuyActivity.this.setResult(0, paramAnonymousView);
                  BuyActivity.this.finish();
                }
              });
              return;
              this.packageName = getIntent().getExtras().getString("packageName");
              this.productId = getIntent().getExtras().getString("product");
              this.devPayload = getIntent().getExtras().getString("payload");
              this.type = getIntent().getExtras().getString("Type");
              break;
              localJSONException = localJSONException;
              localJSONException.printStackTrace();
            }
            paramBundle = "";
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
    }
    finish();
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
    paramBundle.putString("product", this.productId);
    paramBundle.putString("payload", this.devPayload);
    paramBundle.putString("Type", this.type);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/finsky/billing/iab/BuyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */