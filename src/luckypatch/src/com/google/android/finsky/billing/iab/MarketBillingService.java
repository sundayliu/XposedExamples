package com.google.android.finsky.billing.iab;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import com.android.vending.billing.IMarketBillingService.Stub;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MarketBillingService
  extends Service
{
  public static final String TAG = "BillingHack";
  private static Context context;
  private static String dev_pay;
  private static String item = "";
  private static Random sRandom = new Random();
  private final IMarketBillingService.Stub mBinder = new IMarketBillingService.Stub()
  {
    long request_id = -1L;
    
    private long getNextInAppRequestId()
    {
      this.request_id = (MarketBillingService.sRandom.nextLong() & 0x7FFFFFFFFFFFFFFF);
      return this.request_id;
    }
    
    private int updateWithRequestId(Bundle paramAnonymousBundle, long paramAnonymousLong)
    {
      paramAnonymousBundle.putLong("REQUEST_ID", paramAnonymousLong);
      return 0;
    }
    
    public long confirmNotifications(String paramAnonymousString, String[] paramAnonymousArrayOfString)
    {
      return getNextInAppRequestId();
    }
    
    public long restoreTransactions(String paramAnonymousString, long paramAnonymousLong)
    {
      return getNextInAppRequestId();
    }
    
    public Bundle sendBillingRequest(Bundle paramAnonymousBundle)
    {
      Object localObject1 = paramAnonymousBundle.getString("BILLING_REQUEST");
      paramAnonymousBundle.getInt("API_VERSION", -1);
      String str2 = paramAnonymousBundle.getString("PACKAGE_NAME");
      Object localObject5 = paramAnonymousBundle.getString("DEVELOPER_PAYLOAD");
      Object localObject4 = paramAnonymousBundle.getString("ITEM_ID");
      long l = paramAnonymousBundle.getLong("NONCE");
      paramAnonymousBundle = paramAnonymousBundle.getStringArray("NOTIFY_IDS");
      if (localObject4 != null) {
        MarketBillingService.access$002((String)localObject4);
      }
      Bundle localBundle = new Bundle();
      String str1 = "";
      if ("CHECK_BILLING_SUPPORTED".equals(localObject1))
      {
        System.out.println("CHECK_BILLING_SUPPORTED");
        localBundle.putInt("RESPONSE_CODE", 0);
        return localBundle;
      }
      Object localObject2;
      if ("REQUEST_PURCHASE".equals(localObject1))
      {
        System.out.println("REQUEST_PURCHASE");
        paramAnonymousBundle = null;
        try
        {
          localObject1 = listAppsFragment.getPkgMng().getPackageInfo(str2, 0);
          paramAnonymousBundle = (Bundle)localObject1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            localNameNotFoundException.printStackTrace();
          }
          l = getNextInAppRequestId();
          localBundle.putLong("REQUEST_ID", l);
          localObject2 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject2).setClass(MarketBillingService.this, BuyMarketActivity.class);
          ((Intent)localObject2).putExtra("assetid", "inapp:" + str2 + ":" + (String)localObject4);
          ((Intent)localObject2).putExtra("asset_package", str2);
          MarketBillingService.access$002((String)localObject4);
          if (localObject5 == null) {
            break label451;
          }
        }
        localObject1 = null;
        if (paramAnonymousBundle == null)
        {
          paramAnonymousBundle = (Bundle)localObject1;
          localBundle.putParcelable("PURCHASE_INTENT", PendingIntent.getActivity(MarketBillingService.this, 0, paramAnonymousBundle, 1073741824));
          localBundle.putInt("RESPONSE_CODE", 0);
          return localBundle;
        }
        MarketBillingService.access$102((String)localObject5);
        for (;;)
        {
          ((Intent)localObject2).putExtra("asset_version_code", paramAnonymousBundle.versionCode);
          ((Intent)localObject2).putExtra("request_id", l);
          ((Intent)localObject2).putExtra("packageName", str2);
          ((Intent)localObject2).putExtra("product", (String)localObject4);
          ((Intent)localObject2).putExtra("payload", (String)localObject5);
          if (localObject5 != null) {
            ((Intent)localObject2).putExtra("developer_payload", (String)localObject5);
          }
          localObject5 = new DbHelper(listAppsFragment.getInstance(), str2).getItems();
          paramAnonymousBundle = (Bundle)localObject2;
          if (((ArrayList)localObject5).size() == 0) {
            break;
          }
          localObject5 = ((ArrayList)localObject5).iterator();
          for (;;)
          {
            paramAnonymousBundle = (Bundle)localObject2;
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            paramAnonymousBundle = (ItemsListItem)((Iterator)localObject5).next();
            if ((paramAnonymousBundle.autobuy == 1) && (paramAnonymousBundle.itemID.equals(localObject4))) {
              ((Intent)localObject2).putExtra("autorepeat", paramAnonymousBundle.pSignature);
            }
          }
          label451:
          MarketBillingService.access$102("");
        }
      }
      int i;
      if ("RESTORE_TRANSACTIONS".equals(localObject2))
      {
        System.out.println("RESTORE_TRANSACTIONS");
        ArrayList localArrayList = new DbHelper(listAppsFragment.getInstance(), str2).getItems();
        JSONObject localJSONObject;
        JSONArray localJSONArray;
        if (localArrayList.size() != 0)
        {
          localJSONObject = new JSONObject();
          localJSONArray = new JSONArray();
          paramAnonymousBundle = "";
          i = 0;
          localObject5 = str1;
          localObject4 = paramAnonymousBundle;
        }
        try
        {
          if (i < localArrayList.size())
          {
            localObject5 = str1;
            localObject4 = paramAnonymousBundle;
            localObject2 = paramAnonymousBundle;
            if (((ItemsListItem)localArrayList.get(i)).savePurchase != 1) {
              break label1657;
            }
            localObject5 = str1;
            localObject4 = paramAnonymousBundle;
            localJSONArray.put(new JSONObject(((ItemsListItem)localArrayList.get(i)).pData));
            localObject5 = str1;
            localObject4 = paramAnonymousBundle;
            if (!((ItemsListItem)localArrayList.get(i)).pSignature.equals("1")) {
              break label1667;
            }
            localObject2 = "1";
            break label1657;
          }
          localObject5 = str1;
          localObject4 = paramAnonymousBundle;
          localJSONObject.put("nonce", l);
          localObject5 = str1;
          localObject4 = paramAnonymousBundle;
          localJSONObject.put("orders", localJSONArray);
          localObject5 = str1;
          localObject4 = paramAnonymousBundle;
          str1 = localJSONObject.toString();
          localObject2 = paramAnonymousBundle;
          localObject5 = str1;
          localObject4 = paramAnonymousBundle;
          if (paramAnonymousBundle.equals("1"))
          {
            localObject5 = str1;
            localObject4 = paramAnonymousBundle;
            localObject2 = Utils.gen_sha1withrsa(str1);
          }
          localObject5 = str1;
          localObject4 = localObject2;
          System.out.println(str1);
          localObject5 = str1;
        }
        catch (JSONException paramAnonymousBundle)
        {
          try
          {
            paramAnonymousBundle.put("nonce", l);
            ((JSONObject)localObject4).put("notificationId", "" + Utils.getRandom(1000000000000000000L, Long.MAX_VALUE));
            ((JSONObject)localObject4).put("orderId", "" + Utils.getRandom(1000000000000000000L, Long.MAX_VALUE) + Utils.getRandom(0L, 9L) + "." + Utils.getRandom(1000000000000000L, 9999999999999999L));
            ((JSONObject)localObject4).put("packageName", str2);
            ((JSONObject)localObject4).put("productId", "printhand.premium");
            ((JSONObject)localObject4).put("purchaseTime", new Long(System.currentTimeMillis()));
            ((JSONObject)localObject4).put("purchaseState", new Integer(0));
            ((JSONObject)localObject4).put("developerPayload", MarketBillingService.dev_pay);
            ((JSONObject)localObject4).put("purchaseToken", Utils.getRandomStringLowerCase(24));
            ((JSONArray)localObject2).put(localObject4);
            paramAnonymousBundle.put("orders", localObject2);
            paramAnonymousBundle = paramAnonymousBundle.toString();
            localObject2 = Utils.gen_sha1withrsa(paramAnonymousBundle);
            System.out.println(paramAnonymousBundle);
            MarketBillingService.this.mNotifier.sendPurchaseStateChanged(str2, paramAnonymousBundle, (String)localObject2);
            MarketBillingService.this.mNotifier.sendResponseCode(str2, this.request_id, 0);
            localBundle.putInt("RESPONSE_CODE", updateWithRequestId(localBundle, restoreTransactions(str2, l)));
            return localBundle;
            paramAnonymousBundle = paramAnonymousBundle;
            paramAnonymousBundle.printStackTrace();
            localObject2 = localObject4;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
        MarketBillingService.this.mNotifier.sendPurchaseStateChanged(str2, (String)localObject5, (String)localObject2);
        if (str2.equals("com.dynamixsoftware.printhand"))
        {
          paramAnonymousBundle = new JSONObject();
          localObject2 = new JSONArray();
          localObject4 = new JSONObject();
        }
      }
      Object localObject3;
      if ("GET_PURCHASE_INFORMATION".equals(localJSONException))
      {
        System.out.println("GET_PURCHASE_INFORMATION");
        i = (int)Utils.getRandom(0L, 2147483647L);
        localObject3 = new JSONObject();
        localObject5 = new JSONArray();
        localObject4 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("nonce", l);
          ((JSONObject)localObject4).put("notificationId", paramAnonymousBundle[0]);
          ((JSONObject)localObject4).put("orderId", Utils.getRandom(1000000000000000000L, Long.MAX_VALUE) + Utils.getRandom(0L, 9L) + "." + Utils.getRandom(1000000000000000L, 9999999999999999L));
          ((JSONObject)localObject4).put("packageName", str2);
          ((JSONObject)localObject4).put("productId", MarketBillingService.item);
          ((JSONObject)localObject4).put("purchaseTime", new Long(System.currentTimeMillis()));
          ((JSONObject)localObject4).put("purchaseState", new Integer(0));
          ((JSONObject)localObject4).put("developerPayload", MarketBillingService.dev_pay);
          ((JSONObject)localObject4).put("purchaseToken", Utils.getRandomStringLowerCase(24));
          ((JSONArray)localObject5).put(localObject4);
          ((JSONObject)localObject3).put("orders", localObject5);
          localObject5 = ((JSONObject)localObject3).toString();
          paramAnonymousBundle = "";
          if (!listAppsFragment.getInstance().getSharedPreferences("config", 4).getBoolean("UnSign", false))
          {
            System.out.println("send sign");
            paramAnonymousBundle = Utils.gen_sha1withrsa((String)localObject5);
          }
          localObject3 = "";
          if (!paramAnonymousBundle.equals("")) {
            localObject3 = "1";
          }
          if (listAppsFragment.getInstance().getSharedPreferences("config", 4).getBoolean("AutoRepeat", false)) {
            new DbHelper(MarketBillingService.this, str2).saveItem(new ItemsListItem(MarketBillingService.item, "auto.repeat.LP", (String)localObject3, 0, 1));
          }
          if (listAppsFragment.getInstance().getSharedPreferences("config", 4).getBoolean("SavePurchase", false)) {
            new DbHelper(MarketBillingService.this, str2).saveItem(new ItemsListItem(MarketBillingService.item, ((JSONObject)localObject4).toString(), (String)localObject3, 1, 0));
          }
          MarketBillingService.this.mNotifier.sendPurchaseStateChanged(str2, (String)localObject5, paramAnonymousBundle);
          MarketBillingService.this.mNotifier.sendResponseCode(str2, this.request_id, 0);
          updateWithRequestId(localBundle, restoreTransactions(str2, l));
          localBundle.putInt("RESPONSE_CODE", 0);
          return localBundle;
        }
        catch (JSONException paramAnonymousBundle)
        {
          for (;;)
          {
            paramAnonymousBundle.printStackTrace();
          }
        }
      }
      if ("CONFIRM_NOTIFICATIONS".equals(localObject3))
      {
        System.out.println("CONFIRM_NOTIFICATIONS");
        localBundle.putInt("RESPONSE_CODE", updateWithRequestId(localBundle, confirmNotifications(str2, paramAnonymousBundle)));
        MarketBillingService.this.mNotifier.sendResponseCode(str2, this.request_id, 0);
        return localBundle;
      }
      localBundle.putInt("RESPONSE_CODE", 0);
      return localBundle;
      for (;;)
      {
        label1657:
        i += 1;
        paramAnonymousBundle = (Bundle)localObject3;
        break;
        label1667:
        localObject3 = "";
      }
    }
  };
  BillingNotifier mNotifier = new BillingNotifier(this);
  PackageManager mPackageManager;
  
  static
  {
    dev_pay = "";
    sRandom = new Random();
  }
  
  public static Intent findReceiverName(Context paramContext, String paramString, Intent paramIntent)
  {
    paramContext = listAppsFragment.getPkgMng().queryBroadcastReceivers(paramIntent, 0).listIterator();
    while (paramContext.hasNext())
    {
      Object localObject = paramContext.next();
      if ((((ResolveInfo)localObject).activityInfo != null) && (paramString.equals(((ResolveInfo)localObject).activityInfo.packageName)))
      {
        paramIntent.setClassName(paramString, ((ResolveInfo)localObject).activityInfo.name);
        paramIntent.setPackage(paramString);
        return paramIntent;
      }
    }
    System.out.println("Cannot find billing receiver in package '" + paramString + "' for action: " + paramIntent.getAction());
    return null;
  }
  
  public static boolean sendResponseCode(Context paramContext, String paramString, long paramLong, int paramInt)
  {
    paramContext = findReceiverName(listAppsFragment.getInstance(), paramString, new Intent("com.android.vending.billing.RESPONSE_CODE"));
    if (paramContext == null) {
      return false;
    }
    paramContext.putExtra("request_id", paramLong);
    paramContext.putExtra("response_code", paramInt);
    listAppsFragment.getInstance().sendBroadcast(paramContext);
    return true;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    context = this;
  }
  
  public class BillingNotifier
  {
    private MarketBillingService mService;
    
    public BillingNotifier(MarketBillingService paramMarketBillingService)
    {
      this.mService = paramMarketBillingService;
    }
    
    protected boolean sendPurchaseStateChanged(String paramString1, String paramString2, String paramString3)
    {
      paramString1 = MarketBillingService.findReceiverName(this.mService, paramString1, new Intent("com.android.vending.billing.PURCHASE_STATE_CHANGED"));
      if (paramString1 == null) {
        return false;
      }
      paramString1.putExtra("inapp_signed_data", paramString2);
      paramString1.putExtra("inapp_signature", paramString3);
      this.mService.sendBroadcast(paramString1);
      return true;
    }
    
    protected boolean sendResponseCode(String paramString, long paramLong, int paramInt)
    {
      return MarketBillingService.sendResponseCode(this.mService, paramString, paramLong, paramInt);
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/finsky/billing/iab/MarketBillingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */