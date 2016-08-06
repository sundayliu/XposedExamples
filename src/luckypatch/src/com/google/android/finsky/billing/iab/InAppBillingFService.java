package com.google.android.finsky.billing.iab;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppBillingFService
  extends Service
{
  public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
  public static final int BILLING_RESPONSE_RESULT_OK = 0;
  public static final String ITEM_TYPE_INAPP = "inapp";
  public static final String ITEM_TYPE_SUBS = "subs";
  public static final String TAG = "BillingHackMirror";
  static ServiceConnection mServiceConn;
  boolean googleBillingDisabled = false;
  IBinder mB = null;
  private final IInAppBillingService.Stub mBinder = new IInAppBillingService.Stub()
  {
    final ArrayList<String> productIDinapp = new ArrayList();
    final ArrayList<String> productIDsubs = new ArrayList();
    
    public int consumePurchase(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      throws RemoteException
    {
      Log.d("BillingHackMirror", "consumePurchase");
      return 0;
    }
    
    public Bundle getBuyIntent(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("RESPONSE_CODE", 0);
      Intent localIntent = new Intent();
      localIntent.setClass(InAppBillingFService.this.getApplicationContext(), BuyActivity.class);
      localIntent.setAction("com.google.android.finsky.billing.iab.BUY");
      localIntent.addFlags(3);
      localIntent.putExtra("packageName", paramAnonymousString1);
      localIntent.putExtra("product", paramAnonymousString2);
      localIntent.putExtra("payload", paramAnonymousString4);
      localIntent.putExtra("Type", paramAnonymousString3);
      paramAnonymousString1 = new DbHelper(InAppBillingFService.this.mContext, paramAnonymousString1).getItems();
      if (paramAnonymousString1.size() != 0)
      {
        paramAnonymousString1 = paramAnonymousString1.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (ItemsListItem)paramAnonymousString1.next();
          if ((paramAnonymousString3.autobuy == 1) && (paramAnonymousString3.itemID.equals(paramAnonymousString2))) {
            localIntent.putExtra("autorepeat", paramAnonymousString3.pSignature);
          }
        }
      }
      localBundle.putParcelable("BUY_INTENT", PendingIntent.getActivity(InAppBillingFService.this.getApplicationContext(), 0, localIntent, 134217728));
      return localBundle;
    }
    
    public Bundle getBuyIntentToReplaceSkus(int paramAnonymousInt, String paramAnonymousString1, List paramAnonymousList, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      throws RemoteException
    {
      System.out.println("LuckyPatcher: use api 5 getBuyIntentToReplaceSkus");
      paramAnonymousList = new Bundle();
      paramAnonymousList.putInt("RESPONSE_CODE", 0);
      Intent localIntent = new Intent();
      localIntent.setClass(InAppBillingFService.this.getApplicationContext(), BuyActivity.class);
      localIntent.setAction("com.google.android.finsky.billing.iab.BUY");
      localIntent.addFlags(3);
      localIntent.putExtra("packageName", paramAnonymousString1);
      localIntent.putExtra("product", paramAnonymousString2);
      localIntent.putExtra("payload", paramAnonymousString4);
      localIntent.putExtra("Type", paramAnonymousString3);
      paramAnonymousList.putParcelable("BUY_INTENT", PendingIntent.getActivity(InAppBillingFService.this.getApplicationContext(), 0, localIntent, 134217728));
      return paramAnonymousList;
    }
    
    public Bundle getPurchases(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      throws RemoteException
    {
      Log.d("BillingHackMirror", "getPurchases");
      Object localObject = new DbHelper(InAppBillingFService.this.mContext, paramAnonymousString1).getItems();
      paramAnonymousString1 = new ArrayList();
      paramAnonymousString2 = new ArrayList();
      paramAnonymousString3 = new ArrayList();
      if (((ArrayList)localObject).size() != 0)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ItemsListItem localItemsListItem = (ItemsListItem)((Iterator)localObject).next();
          if (localItemsListItem.savePurchase == 1)
          {
            paramAnonymousString1.add(localItemsListItem.itemID);
            paramAnonymousString2.add(localItemsListItem.pData);
            if (localItemsListItem.pSignature.equals("1")) {
              paramAnonymousString3.add(Utils.gen_sha1withrsa(localItemsListItem.pData));
            } else {
              paramAnonymousString3.add("");
            }
          }
        }
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("RESPONSE_CODE", 0);
      ((Bundle)localObject).putStringArrayList("INAPP_PURCHASE_ITEM_LIST", paramAnonymousString1);
      ((Bundle)localObject).putStringArrayList("INAPP_PURCHASE_DATA_LIST", paramAnonymousString2);
      ((Bundle)localObject).putStringArrayList("INAPP_DATA_SIGNATURE_LIST", paramAnonymousString3);
      return (Bundle)localObject;
    }
    
    public Bundle getSkuDetails(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, Bundle paramAnonymousBundle)
      throws RemoteException
    {
      Log.d("BillingHackMirror", "getSkuDetails");
      for (;;)
      {
        try
        {
          if ((!InAppBillingFService.this.mSetupDone) && (!InAppBillingFService.this.skipSetupDone)) {
            InAppBillingFService.this.connectToBilling(paramAnonymousString1);
          }
          new Bundle().putInt("RESPONSE_CODE", 0);
          if ((InAppBillingFService.this.mSetupDone) && (InAppBillingFService.this.mService != null))
          {
            boolean bool = InAppBillingFService.this.skipSetupDone;
            if (bool) {}
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          Object localObject1;
          localException2.printStackTrace();
          continue;
          if (paramAnonymousInt != 0) {
            continue;
          }
          this.productIDsubs.add(localObject4);
          if (!paramAnonymousString2.equals("inapp")) {
            continue;
          }
          paramAnonymousInt = 0;
          Object localObject5 = this.productIDinapp.iterator();
          if (!((Iterator)localObject5).hasNext()) {
            continue;
          }
          if (!((String)localObject4).equals((String)((Iterator)localObject5).next())) {
            continue;
          }
          paramAnonymousInt = 1;
          continue;
          if (paramAnonymousInt != 0) {
            continue;
          }
          this.productIDinapp.add(localObject4);
          continue;
          Object localObject4 = paramAnonymousBundle.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            continue;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          Object localObject2 = ((String)localObject5).split("\\.");
          paramAnonymousBundle = "";
          if ((localObject2 == null) || (localObject2.length == 0)) {
            continue;
          }
          if (localObject2.length < 2) {
            continue;
          }
          paramAnonymousBundle = localObject2[(localObject2.length - 2)] + " " + localObject2[(localObject2.length - 1)];
          if (localObject2.length != 1) {
            continue;
          }
          paramAnonymousBundle = localObject2[0].replaceAll("_", " ");
          long l = Utils.getRandom(0L, 99L);
          localObject2 = "0." + l;
          Object localObject6 = new DbHelper(InAppBillingFService.this.mContext, paramAnonymousString1).getItems().iterator();
          if (!((Iterator)localObject6).hasNext()) {
            continue;
          }
          ItemsListItem localItemsListItem = (ItemsListItem)((Iterator)localObject6).next();
          if ((!localItemsListItem.itemID.equals(localObject5)) || (localItemsListItem.savePurchase != 1)) {
            continue;
          }
          localObject2 = "Purchased";
          continue;
          paramAnonymousBundle = ((String)localObject5).replaceAll("_", " ");
          continue;
          if (!paramAnonymousString2.equals("subs")) {
            continue;
          }
          paramAnonymousInt = 0;
          localObject6 = this.productIDinapp.iterator();
          if (!((Iterator)localObject6).hasNext()) {
            continue;
          }
          if (!((String)((Iterator)localObject6).next()).equals(localObject5)) {
            continue;
          }
          paramAnonymousInt = 1;
          continue;
          if (paramAnonymousInt != 0) {
            continue;
          }
          localObject6 = new JSONObject();
          try
          {
            ((JSONObject)localObject6).put("productId", localObject5);
            ((JSONObject)localObject6).put("type", paramAnonymousString2);
            ((JSONObject)localObject6).put("price", localObject2);
            ((JSONObject)localObject6).put("title", paramAnonymousBundle);
            ((JSONObject)localObject6).put("description", paramAnonymousBundle);
            ((JSONObject)localObject6).put("price_amount_micros", 1000000L * l);
            ((JSONObject)localObject6).put("price_currency_code", "USD");
            ((ArrayList)localObject3).add(((JSONObject)localObject6).toString());
          }
          catch (JSONException paramAnonymousBundle)
          {
            paramAnonymousBundle.printStackTrace();
            continue;
          }
          System.out.println("skip " + (String)localObject5 + " " + paramAnonymousString2);
          continue;
          localObject6 = new JSONObject();
          try
          {
            ((JSONObject)localObject6).put("productId", localObject5);
            ((JSONObject)localObject6).put("type", paramAnonymousString2);
            ((JSONObject)localObject6).put("price", localObject2);
            ((JSONObject)localObject6).put("title", paramAnonymousBundle);
            ((JSONObject)localObject6).put("description", paramAnonymousBundle);
            ((JSONObject)localObject6).put("price_amount_micros", 1000000L * l);
            ((JSONObject)localObject6).put("price_currency_code", "USD");
            ((ArrayList)localObject3).add(((JSONObject)localObject6).toString());
          }
          catch (JSONException paramAnonymousBundle)
          {
            paramAnonymousBundle.printStackTrace();
            continue;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("RESPONSE_CODE", 0);
          ((Bundle)localObject2).putStringArrayList("DETAILS_LIST", (ArrayList)localObject3);
          return (Bundle)localObject2;
        }
        try
        {
          System.out.println("Connect to google billing");
          localObject3 = InAppBillingFService.this.mService.getSkuDetails(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2, paramAnonymousBundle);
          localObject4 = ((Bundle)localObject3).getStringArrayList("DETAILS_LIST");
          paramAnonymousBundle.getStringArrayList("ITEM_ID_LIST");
          paramAnonymousInt = ((Bundle)localObject3).getInt("RESPONSE_CODE");
          System.out.println(paramAnonymousInt);
          if (paramAnonymousInt == 0) {
            continue;
          }
          InAppBillingFService.this.skipSetupDone = true;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      paramAnonymousBundle = paramAnonymousBundle.getStringArrayList("ITEM_ID_LIST");
      localObject3 = new ArrayList();
      if ((!InAppBillingFService.this.mSetupDone) || (InAppBillingFService.this.mService == null) || (InAppBillingFService.this.skipSetupDone))
      {
        System.out.println("Dont Connect to google billing");
        localObject1 = paramAnonymousBundle.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject4 = (String)((Iterator)localObject1).next();
          if (paramAnonymousString2.equals("subs"))
          {
            paramAnonymousInt = 0;
            localObject5 = this.productIDsubs.iterator();
            while (((Iterator)localObject5).hasNext()) {
              if (((String)localObject4).equals((String)((Iterator)localObject5).next())) {
                paramAnonymousInt = 1;
              }
            }
            localObject1 = localObject3;
            if (localObject4 == null) {
              break label1146;
            }
            localObject1 = localObject3;
            if (((ArrayList)localObject4).size() == 0) {
              break label1146;
            }
            localObject4 = ((ArrayList)localObject4).iterator();
            for (;;)
            {
              localObject1 = localObject3;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject1 = new JSONObject((String)((Iterator)localObject4).next());
              if (((JSONObject)localObject1).getString("type").equals("inapp"))
              {
                paramAnonymousInt = 0;
                localObject5 = this.productIDinapp.iterator();
                while (((Iterator)localObject5).hasNext())
                {
                  localObject6 = (String)((Iterator)localObject5).next();
                  if (((JSONObject)localObject1).get("productId").equals(localObject6)) {
                    paramAnonymousInt = 1;
                  }
                }
                if (paramAnonymousInt == 0) {
                  this.productIDinapp.add(((JSONObject)localObject1).getString("productId"));
                }
              }
            }
          }
        }
      }
    }
    
    public int isBillingSupported(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      throws RemoteException
    {
      Log.d("BillingHackMirror", "isBillingSupported");
      InAppBillingFService.this.startGoogleBilling();
      return 0;
    }
    
    public int isPromoEligible(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      throws RemoteException
    {
      return 0;
    }
  };
  Context mContext;
  IInAppBillingService mService;
  boolean mSetupDone = false;
  boolean skipSetupDone = false;
  
  public void connectToBilling(final String paramString)
  {
    startGoogleBilling();
    if (this.mSetupDone) {
      throw new IllegalStateException("IAB helper is already set up.");
    }
    mServiceConn = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        System.out.println("Billing service try to connect.");
        InAppBillingFService.this.mService = IInAppBillingService.Stub.asInterface(paramAnonymousIBinder);
        try
        {
          int i = InAppBillingFService.this.mService.isBillingSupported(3, paramString, "inapp");
          if (i != 0)
          {
            System.out.println(i);
            InAppBillingFService.this.skipSetupDone = true;
            return;
          }
          if (InAppBillingFService.this.mService.isBillingSupported(3, paramString, "subs") == 0) {}
          System.out.println("Billing service connected.");
          InAppBillingFService.this.mSetupDone = true;
          return;
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          paramAnonymousComponentName.printStackTrace();
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        System.out.println("Billing service disconnected.");
        InAppBillingFService.this.mService = null;
        InAppBillingFService.this.mSetupDone = false;
      }
    };
    paramString = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    paramString.setPackage("com.android.vending");
    paramString.putExtra("xexe", "lp");
    if (listAppsFragment.getPkgMng().queryIntentServices(paramString, 0).isEmpty()) {
      new Utils("w").waitLP(2000L);
    }
    if (!listAppsFragment.getPkgMng().queryIntentServices(paramString, 0).isEmpty())
    {
      paramString = listAppsFragment.getPkgMng().queryIntentServices(paramString, 0).iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          return;
        }
        Object localObject = (ResolveInfo)paramString.next();
        if ((((ResolveInfo)localObject).serviceInfo.packageName != null) && (((ResolveInfo)localObject).serviceInfo.packageName.equals("com.android.vending")))
        {
          localObject = new ComponentName(((ResolveInfo)localObject).serviceInfo.packageName, ((ResolveInfo)localObject).serviceInfo.name);
          Intent localIntent = new Intent();
          localIntent.setComponent((ComponentName)localObject);
          localIntent.putExtra("xexe", "lp");
          if (listAppsFragment.getInstance().bindService(localIntent, mServiceConn, 1))
          {
            int i = 0;
            if ((!this.mSetupDone) && (!this.skipSetupDone))
            {
              new Utils("w").waitLP(500L);
              int j = i + 1;
              i = j;
              if (j != 30) {
                break;
              }
            }
          }
        }
      }
    }
    System.out.println("Billing service unavailable on device.");
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if ((paramIntent.getStringExtra("xexe") != null) && (paramIntent.getStringExtra("xexe").equals("lp")) && (paramIntent.getPackage() == null)) {
        break label47;
      }
      System.out.println("Connect from patch.");
    }
    for (;;)
    {
      return this.mBinder;
      label47:
      System.out.println("Connect from proxy.");
      this.mSetupDone = false;
      this.skipSetupDone = true;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    System.out.println("create bill+skip:" + this.skipSetupDone);
    this.mContext = this;
    if (listAppsFragment.su) {
      startGoogleBilling();
    }
  }
  
  public void onDestroy()
  {
    System.out.println("destroy billing");
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      if ((paramIntent.getStringExtra("xexe") != null) && (paramIntent.getStringExtra("xexe").equals("lp"))) {
        break label43;
      }
      System.out.println("Connect from app.");
    }
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      label43:
      this.skipSetupDone = true;
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    System.out.println("on Task Removed billing");
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    System.out.println("destroy billing");
    return super.onUnbind(paramIntent);
  }
  
  void startGoogleBilling()
  {
    
    if (listAppsFragment.su)
    {
      Object localObject = null;
      try
      {
        PackageInfo localPackageInfo = listAppsFragment.getPkgMng().getPackageInfo("com.android.vending", 4);
        localObject = localPackageInfo;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          int i;
          localNameNotFoundException.printStackTrace();
        }
      }
      if ((localObject != null) && (((PackageInfo)localObject).services != null) && (((PackageInfo)localObject).services.length != 0))
      {
        i = 0;
        while (i < ((PackageInfo)localObject).services.length)
        {
          try
          {
            if (((localObject.services[i].name.endsWith("InAppBillingService")) || (localObject.services[i].name.endsWith("MarketBillingService"))) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", localObject.services[i].name)) != 1))
            {
              this.googleBillingDisabled = true;
              Utils.market_billing_services(true);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/finsky/billing/iab/InAppBillingFService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */