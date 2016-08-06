package com.chelpus;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Build.VERSION;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.google.android.finsky.billing.iab.InAppBillingService;
import com.google.android.finsky.billing.iab.MarketBillingService;
import com.google.android.finsky.billing.iab.google.util.Base64;
import com.google.android.finsky.services.LicensingService;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.IXposedHookZygoteInit.StartupParam;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class XSupport
  implements IXposedHookZygoteInit, IXposedHookLoadPackage
{
  public static boolean enable = true;
  public static boolean hide;
  public static boolean patch1 = true;
  public static boolean patch2 = true;
  public static boolean patch3 = true;
  public static boolean patch4 = true;
  Context PMcontext = null;
  public boolean checkDuplicatedPermissions;
  public boolean checkPermissions;
  public boolean checkSignatures;
  Context ctx = null;
  public String currentPkgInApp = null;
  public boolean disableCheckSignatures;
  Boolean forHide = null;
  Boolean hideFromThisApp = null;
  public long initialize = 0L;
  public boolean installUnsignedApps;
  Context mContext = null;
  public XSharedPreferences prefs;
  boolean skip1 = false;
  boolean skip2 = false;
  boolean skip3 = false;
  boolean skipGB = false;
  public boolean verifyApps;
  
  static
  {
    hide = false;
  }
  
  public boolean checkForHide(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    int i = Binder.getCallingUid();
    paramMethodHookParam = (String)XposedHelpers.callMethod(paramMethodHookParam.thisObject, "getNameForUid", new Object[] { Integer.valueOf(i) });
    if ((paramMethodHookParam.contains(":")) || (paramMethodHookParam.contains(listAppsFragment.class.getPackage().getName())) || (paramMethodHookParam.contains("de.robv.android.xposed.installer")) || (paramMethodHookParam.contains("supersu")) || (paramMethodHookParam.contains("superuser")) || (paramMethodHookParam.contains("pro.burgerz.wsm.manager"))) {
      return false;
    }
    Object localObject1 = this.PMcontext.getPackageManager();
    Object localObject2;
    try
    {
      localObject2 = ((PackageManager)localObject1).getApplicationInfo(paramMethodHookParam, 0);
      if ((localObject2 != null) && ((((ApplicationInfo)localObject2).flags & 0x1) != 0)) {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramMethodHookParam)
    {
      paramMethodHookParam.printStackTrace();
      return false;
    }
    if (1 != 0)
    {
      localObject2 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject2).addCategory("android.intent.category.HOME");
      ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
      localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0).iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((ResolveInfo)((Iterator)localObject1).next()).activityInfo.packageName.equals(paramMethodHookParam)) {
          return false;
        }
      }
      if (1 != 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean checkForHideApp(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    int i = Binder.getCallingUid();
    paramMethodHookParam = (String)XposedHelpers.callMethod(paramMethodHookParam.thisObject, "getNameForUid", new Object[] { Integer.valueOf(i) });
    if ((paramMethodHookParam.contains(":")) || (paramMethodHookParam.contains(listAppsFragment.class.getPackage().getName())) || (paramMethodHookParam.contains("de.robv.android.xposed.installer")) || (paramMethodHookParam.contains("supersu")) || (paramMethodHookParam.contains("superuser")) || (paramMethodHookParam.contains("pro.burgerz.wsm.manager"))) {
      return false;
    }
    Object localObject1 = this.PMcontext.getPackageManager();
    Object localObject2;
    try
    {
      localObject2 = ((PackageManager)localObject1).getPackageInfo(paramMethodHookParam, 0);
      if ((localObject2 != null) && ((((PackageInfo)localObject2).applicationInfo.flags & 0x1) != 0)) {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramMethodHookParam)
    {
      paramMethodHookParam.printStackTrace();
      return false;
    }
    if (1 != 0)
    {
      localObject2 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject2).addCategory("android.intent.category.HOME");
      ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
      localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0).iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((ResolveInfo)((Iterator)localObject1).next()).activityInfo.packageName.equals(paramMethodHookParam)) {
          return false;
        }
      }
      if (1 != 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean checkIntentRework(XC_MethodHook.MethodHookParam paramMethodHookParam, Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      Context localContext2;
      try
      {
        Context localContext1 = (Context)XposedHelpers.callMethod(paramMethodHookParam.thisObject, "getBaseContext", new Object[0]);
        if (localContext1 == null) {
          break label202;
        }
        if ((paramInt1 != 0) || ((localContext1.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, InAppBillingService.class.getName())) == 2) && (localContext1.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, MarketBillingService.class.getName())) == 2))) {
          break label139;
        }
        if ((paramIntent.getStringExtra("xexe") == null) || (!paramIntent.getStringExtra("xexe").equals("lp"))) {
          return true;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;)
        {
          localContext2 = (Context)XposedHelpers.getObjectField(paramMethodHookParam.thisObject, "mBase");
        }
      }
      return false;
      label139:
      if ((paramInt1 == 1) && (localContext2.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, LicensingService.class.getName())) != 2)) {
        return (paramIntent.getStringExtra("xexe") == null) || (!paramIntent.getStringExtra("xexe").equals("lp"));
      }
    }
    label202:
    if (paramInt2 == 1)
    {
      if ((paramInt1 == 0) && ((((PackageManager)XposedHelpers.callMethod(paramMethodHookParam.thisObject, "getPackageManager", new Object[0])).getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, InAppBillingService.class.getName())) != 2) || (((PackageManager)XposedHelpers.callMethod(paramMethodHookParam.thisObject, "getPackageManager", new Object[0])).getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, MarketBillingService.class.getName())) != 2)))
      {
        try
        {
          paramMethodHookParam = paramIntent.getStringExtra("xexe");
          if ((paramMethodHookParam == null) || (!paramMethodHookParam.equals("lp"))) {
            return true;
          }
        }
        catch (Exception paramMethodHookParam)
        {
          for (;;)
          {
            System.out.println("skip inapp xposed queryIntentServices");
            paramMethodHookParam = null;
          }
        }
        return false;
      }
      if ((paramInt1 == 1) && (((PackageManager)XposedHelpers.callMethod(paramMethodHookParam.thisObject, "getPackageManager", new Object[0])).getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, LicensingService.class.getName())) != 2))
      {
        try
        {
          paramMethodHookParam = paramIntent.getStringExtra("xexe");
          if ((paramMethodHookParam == null) || (!paramMethodHookParam.equals("lp"))) {
            return true;
          }
        }
        catch (Exception paramMethodHookParam)
        {
          for (;;)
          {
            System.out.println("skip inapp xposed queryIntentServices");
            paramMethodHookParam = null;
          }
        }
        return false;
      }
    }
    if (paramInt2 == 2)
    {
      if ((paramInt1 == 0) && ((this.PMcontext.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, InAppBillingService.class.getName())) != 2) || (this.PMcontext.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, MarketBillingService.class.getName())) != 2)))
      {
        try
        {
          paramMethodHookParam = paramIntent.getStringExtra("xexe");
          if ((paramMethodHookParam == null) || (!paramMethodHookParam.equals("lp"))) {
            return true;
          }
        }
        catch (Exception paramMethodHookParam)
        {
          for (;;)
          {
            System.out.println("skip inapp xposed queryIntentServices");
            paramMethodHookParam = null;
          }
        }
        return false;
      }
      if ((paramInt1 == 1) && (this.PMcontext.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, LicensingService.class.getName())) != 2))
      {
        try
        {
          paramMethodHookParam = paramIntent.getStringExtra("xexe");
          if ((paramMethodHookParam == null) || (!paramMethodHookParam.equals("lp"))) {
            return true;
          }
        }
        catch (Exception paramMethodHookParam)
        {
          for (;;)
          {
            System.out.println("skip inapp xposed queryIntentServices");
            paramMethodHookParam = null;
          }
        }
        return false;
      }
    }
    return false;
  }
  
  public void handleLoadPackage(XC_LoadPackage.LoadPackageParam paramLoadPackageParam)
    throws Throwable
  {
    if (listAppsFragment.class.getPackage().getName().equals(paramLoadPackageParam.packageName)) {
      XposedHelpers.findAndHookMethod("com.chelpus.Utils", paramLoadPackageParam.classLoader, "isXposedEnabled", new Object[] { new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
        }
      } });
    }
    XposedHelpers.findAndHookMethod("android.content.ContextWrapper", null, "bindService", new Object[] { Intent.class, ServiceConnection.class, Integer.TYPE, new XC_MethodHook()
    {
      protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
        throws Throwable
      {
        XSupport.this.loadPrefs();
        if ((XSupport.enable) && (XSupport.patch4))
        {
          Object localObject1 = (Intent)paramAnonymousMethodHookParam.args[0];
          Object localObject2;
          if (localObject1 != null)
          {
            Intent localIntent;
            if (((((Intent)localObject1).getAction() != null) && (Utils.isMarketIntent(((Intent)localObject1).getAction()))) || ((((Intent)localObject1).getComponent() != null) && (((Intent)localObject1).getComponent().toString().contains("com.android.vending")) && (((Intent)localObject1).getComponent().toString().toLowerCase().contains("inappbillingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, (Intent)localObject1, 0, 0))))
            {
              localObject2 = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
              localIntent = new Intent();
              localIntent.setComponent((ComponentName)localObject2);
              paramAnonymousMethodHookParam.args[0] = localIntent;
            }
            if (((((Intent)localObject1).getAction() != null) && (((Intent)localObject1).getAction().toLowerCase().equals("com.android.vending.billing.marketbillingservice.bind"))) || ((((Intent)localObject1).getComponent() != null) && (((Intent)localObject1).getComponent().toString().contains("com.android.vending")) && (((Intent)localObject1).getComponent().toString().toLowerCase().contains("marketbillingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, (Intent)localObject1, 0, 0))))
            {
              localObject2 = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
              localIntent = new Intent();
              localIntent.setComponent((ComponentName)localObject2);
              paramAnonymousMethodHookParam.args[0] = localIntent;
            }
          }
          if ((localObject1 != null) && (((((Intent)localObject1).getAction() != null) && (((Intent)localObject1).getAction().toLowerCase().equals("com.android.vending.licensing.ilicensingservice"))) || ((((Intent)localObject1).getComponent() != null) && (((Intent)localObject1).getComponent().toString().contains("com.android.vending")) && (((Intent)localObject1).getComponent().toString().toLowerCase().contains("licensingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, (Intent)localObject1, 1, 0)))))
          {
            localObject1 = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
            localObject2 = new Intent();
            ((Intent)localObject2).setComponent((ComponentName)localObject1);
            paramAnonymousMethodHookParam.args[0] = localObject2;
          }
        }
      }
    } });
    XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ContextImpl", paramLoadPackageParam.classLoader), "queryIntentServices", new XC_MethodHook()
    {
      protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
        throws Throwable
      {
        XSupport.this.loadPrefs();
        Intent localIntent1;
        if ((XSupport.enable) && (XSupport.patch4))
        {
          localIntent1 = (Intent)paramAnonymousMethodHookParam.args[0];
          if (localIntent1 == null) {}
        }
        try
        {
          ComponentName localComponentName;
          Intent localIntent2;
          if (((localIntent1.getAction() != null) && (Utils.isMarketIntent(localIntent1.getAction()))) || ((localIntent1.getComponent() != null) && (localIntent1.getComponent().toString().contains("com.android.vending")) && (localIntent1.getComponent().toString().toLowerCase().contains("inappbillingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, localIntent1, 0, 1))))
          {
            localComponentName = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
            localIntent2 = new Intent();
            localIntent2.setComponent(localComponentName);
            paramAnonymousMethodHookParam.args[0] = localIntent2;
          }
          if (((localIntent1.getAction() != null) && (localIntent1.getAction().toLowerCase().equals("com.android.vending.billing.marketbillingservice.bind"))) || ((localIntent1.getComponent() != null) && (localIntent1.getComponent().toString().contains("com.android.vending")) && (localIntent1.getComponent().toString().toLowerCase().contains("marketbillingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, localIntent1, 0, 1))))
          {
            localComponentName = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
            localIntent2 = new Intent();
            localIntent2.setComponent(localComponentName);
            paramAnonymousMethodHookParam.args[0] = localIntent2;
          }
          if (((localIntent1.getAction() != null) && (localIntent1.getAction().toLowerCase().equals("com.android.vending.licensing.ilicensingservice"))) || ((localIntent1.getComponent() != null) && (localIntent1.getComponent().toString().contains("com.android.vending")) && (localIntent1.getComponent().toString().toLowerCase().contains("licensingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, localIntent1, 1, 1))))
          {
            localComponentName = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
            localIntent2 = new Intent();
            localIntent2.setComponent(localComponentName);
            paramAnonymousMethodHookParam.args[0] = localIntent2;
          }
          if ((localIntent1.getAction() != null) && (localIntent1.getAction().equals("com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface.BIND")))
          {
            localIntent1 = new Intent("com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface.BIND");
            localIntent1.setPackage(listAppsFragment.class.getPackage().getName());
            paramAnonymousMethodHookParam.args[0] = localIntent1;
          }
          return;
        }
        catch (Exception paramAnonymousMethodHookParam) {}
      }
    });
    Class localClass;
    if (("android".equals(paramLoadPackageParam.packageName)) && (paramLoadPackageParam.processName.equals("android")))
    {
      if (Build.VERSION.SDK_INT <= 10) {
        break label579;
      }
      localClass = XposedHelpers.findClass("com.android.server.pm.PackageManagerService", paramLoadPackageParam.classLoader);
      XposedBridge.hookAllConstructors(XposedHelpers.findClass("com.android.server.pm.PackageManagerService", paramLoadPackageParam.classLoader), new XC_MethodHook()
      {
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          System.out.println("SetPmContext");
          XSupport.this.PMcontext = ((Context)paramAnonymousMethodHookParam.args[0]);
        }
      });
      if (!Common.LOLLIPOP_NEWER) {
        break label535;
      }
      XposedBridge.hookAllMethods(localClass, "installPackageAsUser", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.patch3)) {
            if (!Common.JB_MR1_NEWER) {
              break label63;
            }
          }
          label63:
          for (int i = 2;; i = 1)
          {
            int j = ((Integer)paramAnonymousMethodHookParam.args[i]).intValue();
            if ((j & 0x80) == 0) {
              paramAnonymousMethodHookParam.args[i] = Integer.valueOf(j | 0x80);
            }
            return;
          }
        }
      });
      XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.pm.PackageManagerService", paramLoadPackageParam.classLoader), "queryIntentServices", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          Intent localIntent1;
          if ((XSupport.enable) && (XSupport.patch4))
          {
            localIntent1 = (Intent)paramAnonymousMethodHookParam.args[0];
            if (localIntent1 == null) {}
          }
          try
          {
            ComponentName localComponentName;
            Intent localIntent2;
            if (((localIntent1.getAction() != null) && (Utils.isMarketIntent(localIntent1.getAction()))) || ((localIntent1.getComponent() != null) && (localIntent1.getComponent().toString().contains("com.android.vending")) && (localIntent1.getComponent().toString().toLowerCase().contains("inappbillingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, localIntent1, 0, 2))))
            {
              localComponentName = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
              localIntent2 = new Intent();
              localIntent2.setComponent(localComponentName);
              paramAnonymousMethodHookParam.args[0] = localIntent2;
            }
            if (((localIntent1.getAction() != null) && (localIntent1.getAction().toLowerCase().equals("com.android.vending.billing.marketbillingservice.bind"))) || ((localIntent1.getComponent() != null) && (localIntent1.getComponent().toString().contains("com.android.vending")) && (localIntent1.getComponent().toString().toLowerCase().contains("marketbillingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, localIntent1, 0, 2))))
            {
              localComponentName = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
              localIntent2 = new Intent();
              localIntent2.setComponent(localComponentName);
              paramAnonymousMethodHookParam.args[0] = localIntent2;
            }
            if (((localIntent1.getAction() != null) && (localIntent1.getAction().toLowerCase().equals("com.android.vending.licensing.ilicensingservice"))) || ((localIntent1.getComponent() != null) && (localIntent1.getComponent().toString().contains("com.android.vending")) && (localIntent1.getComponent().toString().toLowerCase().contains("licensingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, localIntent1, 1, 2))))
            {
              localComponentName = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
              localIntent2 = new Intent();
              localIntent2.setComponent(localComponentName);
              paramAnonymousMethodHookParam.args[0] = localIntent2;
            }
            if ((localIntent1.getAction() != null) && (localIntent1.getAction().equals("com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface.BIND")))
            {
              localIntent1 = new Intent("com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface.BIND");
              localIntent1.setPackage(listAppsFragment.class.getPackage().getName());
              paramAnonymousMethodHookParam.args[0] = localIntent1;
            }
            return;
          }
          catch (Exception paramAnonymousMethodHookParam) {}
        }
      });
      if (Common.LOLLIPOP_NEWER) {
        XposedBridge.hookAllMethods(localClass, "checkUpgradeKeySetLP", new XC_MethodHook()
        {
          protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
            throws Throwable
          {
            XSupport.this.loadPrefs();
            if ((XSupport.enable) && (XSupport.patch3)) {
              paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
            }
          }
        });
      }
      XposedBridge.hookAllMethods(localClass, "verifySignaturesLP", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.patch3)) {
            paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
          }
        }
      });
      XposedBridge.hookAllMethods(localClass, "compareSignatures", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.patch3))
          {
            Object localObject;
            int k;
            int j;
            android.content.pm.Signature[] arrayOfSignature2;
            int i;
            int m;
            try
            {
              localObject = XSupport.this.PMcontext.getPackageManager().getPackageInfo("android", 64);
              if (localObject.signatures[0] == null) {
                return;
              }
              localObject = Base64.encode(localObject.signatures[0].toByteArray()).replaceAll("\n", "");
              k = 0;
              j = 0;
              android.content.pm.Signature[] arrayOfSignature1 = (android.content.pm.Signature[])paramAnonymousMethodHookParam.args[0];
              arrayOfSignature2 = (android.content.pm.Signature[])paramAnonymousMethodHookParam.args[1];
              i = k;
              if (arrayOfSignature1 != null)
              {
                i = k;
                if (arrayOfSignature1.length > 0)
                {
                  m = arrayOfSignature1.length;
                  k = 0;
                  for (;;)
                  {
                    i = j;
                    if (k >= m) {
                      break;
                    }
                    if (Base64.encode(arrayOfSignature1[k].toByteArray()).replaceAll("\n", "").equals(localObject)) {
                      j = 1;
                    }
                    k += 1;
                  }
                }
              }
              k = i;
            }
            catch (Exception paramAnonymousMethodHookParam)
            {
              paramAnonymousMethodHookParam.printStackTrace();
              return;
            }
            if (arrayOfSignature2 != null)
            {
              k = i;
              if (arrayOfSignature2.length > 0)
              {
                m = arrayOfSignature2.length;
                j = 0;
                for (;;)
                {
                  k = i;
                  if (j >= m) {
                    break;
                  }
                  if (Base64.encode(arrayOfSignature2[j].toByteArray()).replaceAll("\n", "").equals(localObject)) {
                    i = 1;
                  }
                  j += 1;
                }
              }
            }
            if (k == 0) {
              paramAnonymousMethodHookParam.setResult(Integer.valueOf(0));
            }
          }
        }
      });
      XposedBridge.hookAllMethods(localClass, "getPackageInfo", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide))
          {
            String str = (String)paramAnonymousMethodHookParam.args[0];
            if ((str != null) && (str.equals(listAppsFragment.class.getPackage().getName())) && (XSupport.this.checkForHide(paramAnonymousMethodHookParam))) {
              paramAnonymousMethodHookParam.setResult(null);
            }
          }
        }
      });
      XposedBridge.hookAllMethods(localClass, "getApplicationInfo", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide))
          {
            String str = (String)paramAnonymousMethodHookParam.args[0];
            if ((str != null) && (str.equals(listAppsFragment.class.getPackage().getName())) && (XSupport.this.checkForHideApp(paramAnonymousMethodHookParam))) {
              paramAnonymousMethodHookParam.setResult(null);
            }
          }
        }
      });
      XposedBridge.hookAllMethods(localClass, "generatePackageInfo", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          if (((XSupport.this.skip1) || (XSupport.this.skip2) || (XSupport.this.skip3)) && (((String)XposedHelpers.getObjectField(paramAnonymousMethodHookParam.args[0], "packageName")).equals(listAppsFragment.class.getPackage().getName()))) {
            paramAnonymousMethodHookParam.setResult(null);
          }
        }
      });
      XposedBridge.hookAllMethods(localClass, "getInstalledApplications", new XC_MethodHook()
      {
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.skip2 = false;
        }
        
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide) && (XSupport.this.checkForHideApp(paramAnonymousMethodHookParam))) {
            XSupport.this.skip2 = true;
          }
        }
      });
      XposedBridge.hookAllMethods(localClass, "getInstalledPackages", new XC_MethodHook()
      {
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.skip1 = false;
        }
        
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide) && (XSupport.this.checkForHideApp(paramAnonymousMethodHookParam))) {
            XSupport.this.skip1 = true;
          }
        }
      });
      XposedBridge.hookAllMethods(localClass, "getPreferredPackages", new XC_MethodHook()
      {
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.skip3 = false;
        }
        
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide) && (XSupport.this.checkForHideApp(paramAnonymousMethodHookParam))) {
            XSupport.this.skip3 = true;
          }
        }
      });
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT > 10)
      {
        XposedBridge.hookAllConstructors(XposedHelpers.findClass("android.app.ApplicationPackageManager", paramLoadPackageParam.classLoader), new XC_MethodHook()
        {
          protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
            throws Throwable
          {
            XSupport.this.ctx = ((Context)paramAnonymousMethodHookParam.args[0]);
            XSupport.this.loadPrefs();
            if ((XSupport.enable) && (XSupport.hide))
            {
              XSupport.this.forHide = Boolean.valueOf(false);
              if ((XSupport.this.ctx != null) && (!XSupport.this.ctx.getPackageName().equals(listAppsFragment.class.getPackage().getName())) && (!XSupport.this.ctx.getPackageName().equals("de.robv.android.xposed.installer")) && (!XSupport.this.ctx.getPackageName().contains("supersu")) && (!XSupport.this.ctx.getPackageName().contains("superuser")) && (!XSupport.this.ctx.getPackageName().contains("pro.burgerz.wsm.manager"))) {
                XSupport.this.forHide = Boolean.valueOf(true);
              }
            }
            label253:
            do
            {
              Object localObject;
              while (!paramAnonymousMethodHookParam.hasNext())
              {
                try
                {
                  localObject = (ApplicationInfo)XposedHelpers.callMethod(paramAnonymousMethodHookParam.thisObject, "getApplicationInfo", new Object[] { XSupport.this.ctx.getPackageName(), Integer.valueOf(0) });
                  if (localObject == null) {
                    break label253;
                  }
                  if ((((ApplicationInfo)localObject).flags & 0x1) != 0)
                  {
                    XSupport.this.forHide = Boolean.valueOf(false);
                    return;
                  }
                }
                catch (Exception paramAnonymousMethodHookParam)
                {
                  paramAnonymousMethodHookParam.printStackTrace();
                  XSupport.this.forHide = Boolean.valueOf(false);
                  return;
                }
                XSupport.this.forHide = Boolean.valueOf(true);
                localObject = new Intent("android.intent.action.MAIN");
                ((Intent)localObject).addCategory("android.intent.category.HOME");
                ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
                paramAnonymousMethodHookParam = ((List)XposedHelpers.callMethod(paramAnonymousMethodHookParam.thisObject, "queryIntentActivities", new Object[] { localObject, Integer.valueOf(0) })).iterator();
              }
            } while (!((ResolveInfo)paramAnonymousMethodHookParam.next()).activityInfo.packageName.equals(XSupport.this.ctx.getPackageName()));
            XSupport.this.forHide = Boolean.valueOf(false);
          }
        });
        XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ApplicationPackageManager", paramLoadPackageParam.classLoader), "getPackageInfo", new XC_MethodHook()
        {
          protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
            throws Throwable
          {
            XSupport.this.loadPrefs();
            if ((XSupport.this.forHide != null) && (XSupport.this.forHide.booleanValue()) && (XSupport.enable) && (XSupport.hide))
            {
              String str = (String)paramAnonymousMethodHookParam.args[0];
              if ((str != null) && (str.equals(listAppsFragment.class.getPackage().getName()))) {
                paramAnonymousMethodHookParam.setThrowable(new PackageManager.NameNotFoundException());
              }
            }
          }
        });
        XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ApplicationPackageManager", paramLoadPackageParam.classLoader), "getApplicationInfo", new XC_MethodHook()
        {
          protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
            throws Throwable
          {
            XSupport.this.loadPrefs();
            if ((XSupport.this.forHide != null) && (XSupport.this.forHide.booleanValue()) && (XSupport.enable) && (XSupport.hide))
            {
              String str = (String)paramAnonymousMethodHookParam.args[0];
              if ((str != null) && (str.equals(listAppsFragment.class.getPackage().getName()))) {
                paramAnonymousMethodHookParam.setThrowable(new PackageManager.NameNotFoundException());
              }
            }
          }
        });
        XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ApplicationPackageManager", paramLoadPackageParam.classLoader), "getInstalledApplications", new XC_MethodHook()
        {
          protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
            throws Throwable
          {
            XSupport.this.loadPrefs();
            if ((XSupport.this.forHide != null) && (XSupport.this.forHide.booleanValue()) && (XSupport.enable) && (XSupport.hide))
            {
              if (XSupport.this.ctx != null) {}
              List localList = (List)paramAnonymousMethodHookParam.getResult();
              Object localObject = null;
              Iterator localIterator = localList.iterator();
              while (localIterator.hasNext())
              {
                ApplicationInfo localApplicationInfo = (ApplicationInfo)localIterator.next();
                if (localApplicationInfo.packageName.equals(listAppsFragment.class.getPackage().getName())) {
                  localObject = localApplicationInfo;
                }
              }
              if (localObject != null)
              {
                localList.remove(localObject);
                paramAnonymousMethodHookParam.setResult(localList);
              }
            }
          }
        });
        XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ApplicationPackageManager", paramLoadPackageParam.classLoader), "getInstalledPackages", new XC_MethodHook()
        {
          protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
            throws Throwable
          {
            XSupport.this.loadPrefs();
            if ((XSupport.this.forHide != null) && (XSupport.this.forHide.booleanValue()) && (XSupport.enable) && (XSupport.hide))
            {
              if (XSupport.this.ctx != null) {}
              List localList = (List)paramAnonymousMethodHookParam.getResult();
              Object localObject = null;
              Iterator localIterator = localList.iterator();
              while (localIterator.hasNext())
              {
                PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
                if (localPackageInfo.packageName.equals(listAppsFragment.class.getPackage().getName())) {
                  localObject = localPackageInfo;
                }
              }
              if (localObject != null) {
                paramAnonymousMethodHookParam.setResult(localList);
              }
            }
          }
        });
        XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ApplicationPackageManager", paramLoadPackageParam.classLoader), "getPreferredPackages", new XC_MethodHook()
        {
          protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
            throws Throwable
          {
            XSupport.this.loadPrefs();
            if ((XSupport.this.forHide != null) && (XSupport.this.forHide.booleanValue()) && (XSupport.enable) && (XSupport.hide))
            {
              if (XSupport.this.ctx != null) {}
              List localList = (List)paramAnonymousMethodHookParam.getResult();
              Object localObject = null;
              Iterator localIterator = localList.iterator();
              while (localIterator.hasNext())
              {
                PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
                if (localPackageInfo.packageName.equals(listAppsFragment.class.getPackage().getName())) {
                  localObject = localPackageInfo;
                }
              }
              if (localObject != null)
              {
                localList.remove(localObject);
                paramAnonymousMethodHookParam.setResult(localList);
              }
            }
          }
        });
      }
      return;
      label535:
      if (Common.JB_MR1_NEWER)
      {
        XposedBridge.hookAllMethods(localClass, "installPackageWithVerificationAndEncryption", new XC_MethodHook()
        {
          protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
            throws Throwable
          {
            XSupport.this.loadPrefs();
            if ((XSupport.enable) && (XSupport.patch3)) {
              if (!Common.JB_MR1_NEWER) {
                break label63;
              }
            }
            label63:
            for (int i = 2;; i = 1)
            {
              int j = ((Integer)paramAnonymousMethodHookParam.args[i]).intValue();
              if ((j & 0x80) == 0) {
                paramAnonymousMethodHookParam.args[i] = Integer.valueOf(j | 0x80);
              }
              return;
            }
          }
        });
        break;
      }
      XposedBridge.hookAllMethods(localClass, "installPackageWithVerification", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          int i;
          if ((XSupport.enable) && (XSupport.patch3))
          {
            i = 1;
            if (Build.VERSION.SDK_INT >= 14) {
              i = 2;
            }
          }
          try
          {
            j = ((Integer)paramAnonymousMethodHookParam.args[i]).intValue();
            if ((j & 0x80) == 0) {
              paramAnonymousMethodHookParam.args[i] = Integer.valueOf(j | 0x80);
            }
            return;
          }
          catch (ClassCastException localClassCastException)
          {
            for (;;)
            {
              int j = ((Integer)paramAnonymousMethodHookParam.args[1]).intValue();
              i = 1;
            }
          }
        }
      });
      break;
      label579:
      XposedBridge.hookAllConstructors(XposedHelpers.findClass("com.android.server.PackageManagerService", paramLoadPackageParam.classLoader), new XC_MethodHook()
      {
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          System.out.println("SetPmContext");
          XSupport.this.PMcontext = ((Context)paramAnonymousMethodHookParam.args[0]);
        }
      });
      XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", paramLoadPackageParam.classLoader), "getPackageInfo", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide))
          {
            String str = (String)paramAnonymousMethodHookParam.args[0];
            if ((str != null) && (str.equals(listAppsFragment.class.getPackage().getName())) && (XSupport.this.checkForHide(paramAnonymousMethodHookParam))) {
              paramAnonymousMethodHookParam.setResult(null);
            }
          }
        }
      });
      XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", paramLoadPackageParam.classLoader), "getApplicationInfo", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide))
          {
            String str = (String)paramAnonymousMethodHookParam.args[0];
            if ((str != null) && (str.equals(listAppsFragment.class.getPackage().getName())) && (XSupport.this.checkForHideApp(paramAnonymousMethodHookParam))) {
              paramAnonymousMethodHookParam.setResult(null);
            }
          }
        }
      });
      XposedBridge.hookAllMethods(XposedHelpers.findClass("android.content.pm.PackageParser", paramLoadPackageParam.classLoader), "generatePackageInfo", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide) && (((String)XposedHelpers.getObjectField(paramAnonymousMethodHookParam.args[0], "packageName")).equals(listAppsFragment.class.getPackage().getName())) && (XSupport.this.skipGB)) {
            paramAnonymousMethodHookParam.setResult(null);
          }
        }
      });
      XposedBridge.hookAllMethods(XposedHelpers.findClass("android.content.pm.PackageParser", paramLoadPackageParam.classLoader), "generateApplicationInfo", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide) && (((String)XposedHelpers.getObjectField(paramAnonymousMethodHookParam.args[0], "packageName")).equals(listAppsFragment.class.getPackage().getName())) && (XSupport.this.skipGB)) {
            paramAnonymousMethodHookParam.setResult(null);
          }
        }
      });
      XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", paramLoadPackageParam.classLoader), "getInstalledApplications", new XC_MethodHook()
      {
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.skipGB = false;
        }
        
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide) && (XSupport.this.checkForHideApp(paramAnonymousMethodHookParam))) {
            XSupport.this.skipGB = true;
          }
        }
      });
      XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", paramLoadPackageParam.classLoader), "getInstalledPackages", new XC_MethodHook()
      {
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.skipGB = false;
        }
        
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide) && (XSupport.this.checkForHideApp(paramAnonymousMethodHookParam))) {
            XSupport.this.skipGB = true;
          }
        }
      });
      XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", paramLoadPackageParam.classLoader), "getPreferredPackages", new XC_MethodHook()
      {
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.skipGB = false;
        }
        
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.hide) && (XSupport.this.checkForHideApp(paramAnonymousMethodHookParam))) {
            XSupport.this.skipGB = true;
          }
        }
      });
      XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", paramLoadPackageParam.classLoader), "checkSignaturesLP", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.patch3)) {
            paramAnonymousMethodHookParam.setResult(Integer.valueOf(0));
          }
        }
      });
      XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", paramLoadPackageParam.classLoader), "queryIntentServices", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          XSupport.this.loadPrefs();
          Intent localIntent1;
          if ((XSupport.enable) && (XSupport.patch4))
          {
            localIntent1 = (Intent)paramAnonymousMethodHookParam.args[0];
            if (localIntent1 == null) {}
          }
          try
          {
            ComponentName localComponentName;
            Intent localIntent2;
            if (((localIntent1.getAction() != null) && (Utils.isMarketIntent(localIntent1.getAction()))) || ((localIntent1.getComponent() != null) && (localIntent1.getComponent().toString().contains("com.android.vending")) && (localIntent1.getComponent().toString().toLowerCase().contains("inappbillingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, localIntent1, 0, 2))))
            {
              localComponentName = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
              localIntent2 = new Intent();
              localIntent2.setComponent(localComponentName);
              paramAnonymousMethodHookParam.args[0] = localIntent2;
            }
            if (((localIntent1.getAction() != null) && (localIntent1.getAction().toLowerCase().equals("com.android.vending.billing.marketbillingservice.bind"))) || ((localIntent1.getComponent() != null) && (localIntent1.getComponent().toString().contains("com.android.vending")) && (localIntent1.getComponent().toString().toLowerCase().contains("marketbillingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, localIntent1, 0, 2))))
            {
              localComponentName = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
              localIntent2 = new Intent();
              localIntent2.setComponent(localComponentName);
              paramAnonymousMethodHookParam.args[0] = localIntent2;
            }
            if (((localIntent1.getAction() != null) && (localIntent1.getAction().toLowerCase().equals("com.android.vending.licensing.ilicensingservice"))) || ((localIntent1.getComponent() != null) && (localIntent1.getComponent().toString().contains("com.android.vending")) && (localIntent1.getComponent().toString().toLowerCase().contains("licensingservice")) && (XSupport.this.checkIntentRework(paramAnonymousMethodHookParam, localIntent1, 1, 2))))
            {
              localComponentName = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
              localIntent2 = new Intent();
              localIntent2.setComponent(localComponentName);
              paramAnonymousMethodHookParam.args[0] = localIntent2;
            }
            if ((localIntent1.getAction() != null) && (localIntent1.getAction().equals("com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface.BIND")))
            {
              localIntent1 = new Intent("com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface.BIND");
              localIntent1.setPackage(listAppsFragment.class.getPackage().getName());
              paramAnonymousMethodHookParam.args[0] = localIntent1;
            }
            return;
          }
          catch (Exception paramAnonymousMethodHookParam) {}
        }
      });
    }
  }
  
  public void initZygote(IXposedHookZygoteInit.StartupParam paramStartupParam)
    throws Throwable
  {
    XposedHelpers.findClass("android.content.pm.PackageParser", null);
    XposedHelpers.findClass("java.util.jar.JarVerifier$VerifierEntry", null);
    this.disableCheckSignatures = true;
    if (Build.VERSION.SDK_INT > 18) {}
    try
    {
      XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.org.conscrypt.OpenSSLSignature", null), "engineVerify", new XC_MethodHook()
      {
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
          throws Throwable
        {
          System.out.println("engineVerify");
          XSupport.this.loadPrefs();
          if ((XSupport.enable) && (XSupport.patch1)) {
            paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
          }
        }
      });
      if ((Build.VERSION.SDK_INT > 14) && (Build.VERSION.SDK_INT < 19)) {}
      try
      {
        XposedBridge.hookAllMethods(XposedHelpers.findClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSignature", null), "engineVerify", new XC_MethodHook()
        {
          protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
            throws Throwable
          {
            System.out.println("engineVerify");
            XSupport.this.loadPrefs();
            if ((XSupport.enable) && (XSupport.patch1)) {
              paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
            }
          }
        });
        if (Build.VERSION.SDK_INT == 10) {}
        try
        {
          XposedBridge.hookAllMethods(XposedHelpers.findClass("org.bouncycastle.jce.provider.JDKDigestSignature", null), "engineVerify", new XC_MethodHook()
          {
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
              throws Throwable
            {
              System.out.println("engineVerify");
              XSupport.this.loadPrefs();
              if ((XSupport.enable) && (XSupport.patch1)) {
                paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
              }
            }
          });
          XposedHelpers.findAndHookMethod("java.security.MessageDigest", null, "isEqual", new Object[] { byte[].class, byte[].class, new XC_MethodHook()
          {
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
              throws Throwable
            {
              XSupport.this.loadPrefs();
              if ((XSupport.enable) && (XSupport.patch2)) {
                paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
              }
            }
          } });
          XposedHelpers.findAndHookMethod("java.security.Signature", null, "verify", new Object[] { byte[].class, new XC_MethodHook()
          {
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
              throws Throwable
            {
              XSupport.this.loadPrefs();
              if ((XSupport.enable) && (XSupport.patch1) && ((((java.security.Signature)paramAnonymousMethodHookParam.thisObject).getAlgorithm().toLowerCase().equals("sha1withrsa")) || (((java.security.Signature)paramAnonymousMethodHookParam.thisObject).getAlgorithm().toLowerCase().equals("rsa-sha1")) || (((java.security.Signature)paramAnonymousMethodHookParam.thisObject).getAlgorithm().toLowerCase().equals("1.3.14.3.2.26with1.2.840.113549.1.1.1"))) && (Integer.valueOf(XposedHelpers.getIntField(paramAnonymousMethodHookParam.thisObject, "state")).intValue() == 3)) {
                paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
              }
            }
          } });
          XposedHelpers.findAndHookMethod("java.security.Signature", null, "verify", new Object[] { byte[].class, Integer.TYPE, Integer.TYPE, new XC_MethodHook()
          {
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
              throws Throwable
            {
              XSupport.this.loadPrefs();
              if ((XSupport.enable) && (XSupport.patch1) && ((((java.security.Signature)paramAnonymousMethodHookParam.thisObject).getAlgorithm().toLowerCase().equals("sha1withrsa")) || (((java.security.Signature)paramAnonymousMethodHookParam.thisObject).getAlgorithm().toLowerCase().equals("rsa-sha1")) || (((java.security.Signature)paramAnonymousMethodHookParam.thisObject).getAlgorithm().toLowerCase().equals("1.3.14.3.2.26with1.2.840.113549.1.1.1"))) && (Integer.valueOf(XposedHelpers.getIntField(paramAnonymousMethodHookParam.thisObject, "state")).intValue() == 3)) {
                paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
              }
            }
          } });
          return;
        }
        catch (ClassNotFoundException paramStartupParam)
        {
          for (;;) {}
        }
      }
      catch (Exception paramStartupParam)
      {
        for (;;) {}
      }
    }
    catch (Exception paramStartupParam)
    {
      for (;;) {}
    }
  }
  
  public void loadPrefs()
  {
    Object localObject;
    if ((this.initialize == 0L) || (this.initialize != new File("/data/lp/xposed").lastModified()))
    {
      if ((this.initialize != 0L) && (this.initialize != new File("/data/lp/xposed").lastModified())) {
        System.out.println("Update settings xposed");
      }
      this.initialize = new File("/data/lp/xposed").lastModified();
      new ArrayList();
      localObject = null;
    }
    try
    {
      JSONObject localJSONObject = Utils.readXposedParamBoolean();
      localObject = localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    if (localObject != null)
    {
      patch1 = ((JSONObject)localObject).optBoolean("patch1", true);
      patch2 = ((JSONObject)localObject).optBoolean("patch2", true);
      patch3 = ((JSONObject)localObject).optBoolean("patch3", true);
      patch4 = ((JSONObject)localObject).optBoolean("patch4", true);
      hide = ((JSONObject)localObject).optBoolean("hide", false);
      enable = ((JSONObject)localObject).optBoolean("module_on", true);
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/XSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */