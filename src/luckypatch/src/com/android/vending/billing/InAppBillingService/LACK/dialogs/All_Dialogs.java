package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.vending.billing.InAppBillingService.LACK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LACK.ArrayAdapterWithFilter;
import com.android.vending.billing.InAppBillingService.LACK.BootListItemAdapter;
import com.android.vending.billing.InAppBillingService.LACK.Components;
import com.android.vending.billing.InAppBillingService.LACK.CoreItem;
import com.android.vending.billing.InAppBillingService.LACK.FileApkListItem;
import com.android.vending.billing.InAppBillingService.LACK.LogCollector;
import com.android.vending.billing.InAppBillingService.LACK.Patterns;
import com.android.vending.billing.InAppBillingService.LACK.Perm;
import com.android.vending.billing.InAppBillingService.LACK.PkgListItem;
import com.android.vending.billing.InAppBillingService.LACK.PkgListItemAdapter;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.android.vending.billing.InAppBillingService.LACK.patchActivity;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.google.util.Base64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import org.json.JSONObject;

public class All_Dialogs
{
  public static final int ADD_BOOT = 2;
  public static final int CREATE_APK = 0;
  public static final int CUSTOM_PATCH = 1;
  public ArrayAdapter adapter = null;
  Dialog dialog = null;
  public int dialog_int = 255;
  
  public void dismiss()
  {
    if (this.dialog != null)
    {
      this.dialog.dismiss();
      this.dialog = null;
    }
  }
  
  public boolean isVisible()
  {
    if (this.dialog != null) {
      return this.dialog.isShowing();
    }
    return false;
  }
  
  public Dialog onCreateDialog()
  {
    System.out.println("Create dialog");
    this.dialog_int = listAppsFragment.dialog_int;
    final Object localObject1 = listAppsFragment.pli;
    if ((listAppsFragment.frag == null) || (listAppsFragment.frag.getContext() == null)) {
      dismiss();
    }
    try
    {
      System.out.println("All Dialog create.");
      switch (listAppsFragment.dialog_int)
      {
      case 21: 
        localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
        if (listAppsFragment.perm_adapt != null)
        {
          listAppsFragment.perm_adapt.setNotifyOnChange(true);
          ((AlertDlg)localObject1).setAdapterNotClose(true);
          ((AlertDlg)localObject1).setAdapterWithFilter(listAppsFragment.perm_adapt, new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              paramAnonymousAdapterView = (Perm)listAppsFragment.perm_adapt.getItem(paramAnonymousInt);
              if (paramAnonymousAdapterView.Status) {}
              for (paramAnonymousAdapterView.Status = false;; paramAnonymousAdapterView.Status = true)
              {
                listAppsFragment.perm_adapt.notifyDataSetChanged();
                return;
              }
            }
          });
          ((AlertDlg)localObject1).setPositiveButton(Utils.getText(2131165382), new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              paramAnonymousDialogInterface = new ArrayList();
              ArrayList localArrayList = new ArrayList();
              paramAnonymousInt = 0;
              while (paramAnonymousInt < listAppsFragment.perm_adapt.getCount())
              {
                Perm localPerm = (Perm)listAppsFragment.perm_adapt.getItem(paramAnonymousInt);
                if ((!localPerm.Status) && (!localPerm.Name.contains("chelpus_"))) {
                  paramAnonymousDialogInterface.add(localPerm.Name);
                }
                if ((localPerm.Status) && (localPerm.Name.startsWith("chelpa_per_")))
                {
                  paramAnonymousDialogInterface.add(localPerm.Name.replace("chelpa_per_", ""));
                  System.out.println(localPerm.Name.replace("chelpa_per_", ""));
                }
                if ((!localPerm.Status) && (localPerm.Name.contains("chelpus_")) && (!localPerm.Name.contains("disabled_")))
                {
                  localArrayList.add(localPerm.Name.replace("chelpus_", ""));
                  System.out.println("" + localPerm.Name.replace("chelpus_", ""));
                }
                if ((localPerm.Status) && (localPerm.Name.contains("chelpus_disabled_")))
                {
                  localArrayList.add(localPerm.Name.replace("chelpus_", ""));
                  System.out.println("" + localPerm.Name.replace("chelpus_", ""));
                }
                paramAnonymousInt += 1;
              }
              if (listAppsFragment.rebuldApk.equals(""))
              {
                listAppsFragment.frag.createapkpermissions(paramAnonymousDialogInterface, localArrayList);
                return;
              }
              listAppsFragment.frag.toolbar_createapkpermissions(paramAnonymousDialogInterface, localArrayList);
            }
          });
        }
        return ((AlertDlg)localObject1).create();
      }
    }
    catch (Exception localException1)
    {
      System.out.println("LuckyPatcher (Create Dialog): " + localException1);
      localException1.printStackTrace();
      localObject2 = new AlertDlg(listAppsFragment.frag.getContext());
      ((AlertDlg)localObject2).setTitle("Error").setMessage("Sorry...\nShow Dialog - Error...").setNegativeButton("OK", null);
      return ((AlertDlg)localObject2).create();
    }
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (listAppsFragment.perm_adapt != null)
    {
      listAppsFragment.perm_adapt.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapterNotClose(true);
      ((AlertDlg)localObject1).setAdapterWithFilter(listAppsFragment.perm_adapt, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (Perm)listAppsFragment.perm_adapt.getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView.Status) {}
          for (paramAnonymousAdapterView.Status = false;; paramAnonymousAdapterView.Status = true)
          {
            listAppsFragment.perm_adapt.notifyDataSetChanged();
            return;
          }
        }
      });
      ((AlertDlg)localObject1).setPositiveButton(Utils.getText(2131165648), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < listAppsFragment.perm_adapt.getCount())
          {
            Perm localPerm = (Perm)listAppsFragment.perm_adapt.getItem(paramAnonymousInt);
            if ((!localPerm.Status) && (!localPerm.Name.contains("chelpus_"))) {
              paramAnonymousDialogInterface.add(localPerm.Name);
            }
            if ((localPerm.Status) && (localPerm.Name.startsWith("chelpa_per_")))
            {
              paramAnonymousDialogInterface.add(localPerm.Name.replace("chelpa_per_", ""));
              System.out.println(localPerm.Name.replace("chelpa_per_", ""));
            }
            if ((!localPerm.Status) && (localPerm.Name.contains("chelpus_")) && (!localPerm.Name.contains("disabled_")))
            {
              localArrayList.add(localPerm.Name.replace("chelpus_", ""));
              System.out.println("" + localPerm.Name.replace("chelpus_", ""));
            }
            if ((localPerm.Status) && (localPerm.Name.contains("chelpus_disabled_")))
            {
              localArrayList.add(localPerm.Name.replace("chelpus_", ""));
              System.out.println("" + localPerm.Name.replace("chelpus_", ""));
            }
            paramAnonymousInt += 1;
          }
          listAppsFragment.frag.apkpermissions(listAppsFragment.pli, paramAnonymousDialogInterface, localArrayList);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    final Object localObject3 = new AlertDlg(listAppsFragment.frag.getContext());
    if (listAppsFragment.perm_adapt != null)
    {
      listAppsFragment.perm_adapt.setNotifyOnChange(true);
      ((AlertDlg)localObject3).setAdapterNotClose(true);
      ((AlertDlg)localObject3).setAdapterWithFilter(listAppsFragment.perm_adapt, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (Perm)listAppsFragment.perm_adapt.getItem(paramAnonymousInt);
          if (!paramAnonymousAdapterView.Status)
          {
            new Utils("").cmdRoot(new String[] { "pm enable '" + localObject1.pkgName + "/" + paramAnonymousAdapterView.Name + "'" });
            if (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(localObject1.pkgName, paramAnonymousAdapterView.Name)) != 2) {
              break label229;
            }
          }
          label229:
          for (paramAnonymousAdapterView.Status = false;; paramAnonymousAdapterView.Status = true)
          {
            listAppsFragment.perm_adapt.notifyDataSetChanged();
            localObject1.modified = true;
            listAppsFragment.plia.notifyDataSetChanged(listAppsFragment.pli);
            listAppsFragment.getConfig().edit().putBoolean(localObject1.pkgName, true).commit();
            return;
            new Utils("").cmdRoot(new String[] { "pm disable '" + localObject1.pkgName + "/" + paramAnonymousAdapterView.Name + "'" });
            break;
          }
        }
      });
      ((AlertDlg)localObject3).setPositiveButton(Utils.getText(2131165510), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          try
          {
            paramAnonymousDialogInterface = listAppsFragment.getPkgMng().getLaunchIntentForPackage(localObject1.pkgName);
            if (listAppsFragment.su) {
              Utils.startApp(localObject1.pkgName);
            }
            for (;;)
            {
              listAppsFragment.removeDialogLP(29);
              return;
              if (listAppsFragment.patchAct != null) {
                listAppsFragment.patchAct.startActivity(paramAnonymousDialogInterface);
              }
            }
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            for (;;)
            {
              Toast.makeText(listAppsFragment.frag.getContext(), Utils.getText(2131165437), 1).show();
            }
          }
        }
      });
    }
    return ((AlertDlg)localObject3).create();
    localObject3 = new AlertDlg(listAppsFragment.frag.getContext());
    if (listAppsFragment.component_adapt != null)
    {
      listAppsFragment.component_adapt.setNotifyOnChange(true);
      ((AlertDlg)localObject3).setAdapterNotClose(true);
      ((AlertDlg)localObject3).setAdapterWithFilter(listAppsFragment.component_adapt, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (Components)listAppsFragment.component_adapt.getItem(paramAnonymousInt);
          if (!paramAnonymousAdapterView.header)
          {
            if (paramAnonymousAdapterView.Status) {
              break label171;
            }
            new Utils("").cmdRoot(new String[] { "pm enable '" + localObject1.pkgName + "/" + paramAnonymousAdapterView.Name + "'" });
            if (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(localObject1.pkgName, paramAnonymousAdapterView.Name)) != 2) {
              break label236;
            }
          }
          label171:
          label236:
          for (paramAnonymousAdapterView.Status = false;; paramAnonymousAdapterView.Status = true)
          {
            listAppsFragment.component_adapt.notifyDataSetChanged();
            localObject1.modified = true;
            listAppsFragment.plia.notifyDataSetChanged(listAppsFragment.pli);
            listAppsFragment.getConfig().edit().putBoolean(localObject1.pkgName, true).commit();
            return;
            new Utils("").cmdRoot(new String[] { "pm disable '" + localObject1.pkgName + "/" + paramAnonymousAdapterView.Name + "'" });
            break;
          }
        }
      });
      ((AlertDlg)localObject3).setPositiveButton(Utils.getText(2131165510), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          try
          {
            paramAnonymousDialogInterface = listAppsFragment.getPkgMng().getLaunchIntentForPackage(localObject1.pkgName);
            if (listAppsFragment.su) {
              Utils.startApp(localObject1.pkgName);
            }
            for (;;)
            {
              paramAnonymousDialogInterface = listAppsFragment.frag;
              listAppsFragment.removeDialogLP(31);
              return;
              if (listAppsFragment.patchAct != null) {
                listAppsFragment.patchAct.startActivity(paramAnonymousDialogInterface);
              }
            }
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            for (;;)
            {
              Toast.makeText(listAppsFragment.frag.getContext(), Utils.getText(2131165437), 1).show();
            }
          }
        }
      });
    }
    return ((AlertDlg)localObject3).create();
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (listAppsFragment.perm_adapt != null)
    {
      listAppsFragment.perm_adapt.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapterNotClose(true);
      ((AlertDlg)localObject1).setAdapterWithFilter(listAppsFragment.perm_adapt, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (Perm)listAppsFragment.perm_adapt.getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView.Status) {}
          for (paramAnonymousAdapterView.Status = false;; paramAnonymousAdapterView.Status = true)
          {
            listAppsFragment.perm_adapt.notifyDataSetChanged();
            return;
          }
        }
      });
      ((AlertDlg)localObject1).setPositiveButton(Utils.getText(2131165648), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < listAppsFragment.perm_adapt.getCount())
          {
            Perm localPerm = (Perm)listAppsFragment.perm_adapt.getItem(paramAnonymousInt);
            if ((!localPerm.Status) && (!localPerm.Name.contains("chelpus_"))) {
              paramAnonymousDialogInterface.add(localPerm.Name);
            }
            if ((localPerm.Status) && (localPerm.Name.startsWith("chelpa_per_")))
            {
              paramAnonymousDialogInterface.add(localPerm.Name.replace("chelpa_per_", ""));
              System.out.println(localPerm.Name.replace("chelpa_per_", ""));
            }
            if ((!localPerm.Status) && (localPerm.Name.contains("chelpus_")) && (!localPerm.Name.contains("disabled_")))
            {
              localArrayList.add(localPerm.Name.replace("chelpus_", ""));
              System.out.println("" + localPerm.Name.replace("chelpus_", ""));
            }
            if ((localPerm.Status) && (localPerm.Name.contains("chelpus_disabled_")))
            {
              localArrayList.add(localPerm.Name.replace("chelpus_", ""));
              System.out.println("" + localPerm.Name.replace("chelpus_", ""));
            }
            paramAnonymousInt += 1;
          }
          listAppsFragment.frag.apkpermissions_safe(listAppsFragment.pli, paramAnonymousDialogInterface, localArrayList);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    listAppsFragment.changedPermissions = new ArrayList();
    localObject3 = new AlertDlg(listAppsFragment.frag.getContext());
    if (listAppsFragment.perm_adapt != null)
    {
      listAppsFragment.perm_adapt.setNotifyOnChange(true);
      ((AlertDlg)localObject3).setAdapterNotClose(true);
      ((AlertDlg)localObject3).setAdapterWithFilter(listAppsFragment.perm_adapt, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          listAppsFragment.frag.runWithWait(new Runnable()
          {
            public void run()
            {
              Perm localPerm = (Perm)listAppsFragment.perm_adapt.getItem(paramAnonymousInt);
              listAppsFragment.frag.disable_permission(listAppsFragment.pli, localPerm);
              listAppsFragment.frag.contextpermissions();
              listAppsFragment.frag.runToMain(new Runnable()
              {
                public void run()
                {
                  listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                  listAppsFragment.removeDialogLP(10);
                  locallistAppsFragment = listAppsFragment.frag;
                  listAppsFragment.showDialogLP(10);
                }
              });
            }
          });
        }
      });
      ((AlertDlg)localObject3).setPositiveButton(Utils.getText(2131165623), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          listAppsFragment.frag.runWithWait(new Runnable()
          {
            public void run()
            {
              localObject3 = null;
              Object localObject1 = localObject3;
              try
              {
                if (Utils.exists("/data/system/packages.xml")) {
                  localObject1 = "/data/system/packages.xml";
                }
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  System.out.println("LuckyPatcher (Get packages.xml Error): " + localException1);
                  localObject2 = localObject3;
                }
              }
              localObject3 = localObject1;
              try
              {
                if (Utils.exists("/dbdata/system/packages.xml")) {
                  localObject3 = "/dbdata/system/packages.xml";
                }
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  System.out.println("LuckyPatcher (Get packages.xml Error): " + localException3);
                  localObject4 = localObject2;
                }
              }
              localObject1 = Utils.getPermissions((String)localObject3);
              try
              {
                boolean bool = ((String)localObject1).equals("");
                if (bool) {}
              }
              catch (Exception localException2)
              {
                Object localObject2;
                Object localObject4;
                for (;;) {}
              }
              Utils.copyFile(listAppsFragment.frag.getContext().getDir("packages", 0).getAbsolutePath() + "/packages.xml", (String)localObject3, false, false);
              Utils.run_all("chmod 777 " + (String)localObject3);
              Utils.run_all("chown 1000.1000 " + (String)localObject3);
              Utils.run_all("chown 1000:1000 " + (String)localObject3);
              listAppsFragment.plia.getItem(All_Dialogs.12.this.val$pli_local.pkgName).modified = true;
              listAppsFragment.getConfig().edit().putBoolean(listAppsFragment.plia.getItem(All_Dialogs.12.this.val$pli_local.pkgName).pkgName, true).commit();
              Utils.reboot();
              Utils.run_all("killall -9 zygote");
            }
          });
        }
      });
    }
    return ((AlertDlg)localObject3).create();
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (this.adapter != null)
    {
      this.adapter.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapterNotClose(true);
      ((AlertDlg)localObject1).setAdapter(this.adapter, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
          if (paramAnonymousView.Status) {}
          for (paramAnonymousView.Status = false;; paramAnonymousView.Status = true)
          {
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 4)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(5);
                paramAnonymousAdapterView.Status = false;
              }
            }
            paramAnonymousView = paramAnonymousAdapterView;
            if (paramAnonymousInt == 5)
            {
              paramAnonymousView = paramAnonymousAdapterView;
              if (paramAnonymousAdapterView.Status)
              {
                paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(4);
                paramAnonymousView.Status = false;
              }
            }
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 6)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                ((Patterns)All_Dialogs.this.adapter.getItem(7)).Status = true;
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(8);
                paramAnonymousAdapterView.Status = false;
              }
            }
            if ((paramAnonymousInt == 8) && (paramAnonymousAdapterView.Status))
            {
              ((Patterns)All_Dialogs.this.adapter.getItem(7)).Status = true;
              ((Patterns)All_Dialogs.this.adapter.getItem(6)).Status = false;
            }
            All_Dialogs.this.adapter.notifyDataSetChanged();
            return;
          }
        }
      });
      ((AlertDlg)localObject1).setPositiveButton(Utils.getText(2131165592), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Object localObject = "1";
          int i = All_Dialogs.this.adapter.getCount();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            Patterns localPatterns = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (localPatterns.Status)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (paramAnonymousInt < 6) {
                paramAnonymousDialogInterface = (String)localObject + "pattern" + (paramAnonymousInt + 1) + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 6)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "copyDC" + "_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 7)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "backup" + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 8)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "deleteDC" + "_";
              }
            }
            paramAnonymousInt += 1;
          }
          listAppsFragment.frag.addIgnoreOdex(listAppsFragment.pli, (String)localObject);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (listAppsFragment.adapt != null)
    {
      listAppsFragment.adapt.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapter(listAppsFragment.adapt, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          switch (listAppsFragment.func)
          {
          default: 
            return;
          case 1: 
            paramAnonymousAdapterView = listAppsFragment.frag;
            listAppsFragment.removeDialogLP(16);
            listAppsFragment.customselect = (File)listAppsFragment.adapt.getItem(paramAnonymousInt);
            paramAnonymousAdapterView = listAppsFragment.frag;
            listAppsFragment.showDialogLP(15);
            return;
          case 2: 
            paramAnonymousAdapterView = listAppsFragment.frag;
            listAppsFragment.removeDialogLP(16);
            listAppsFragment.customselect = (File)listAppsFragment.adapt.getItem(paramAnonymousInt);
            listAppsFragment.frag.bootadd(listAppsFragment.pli, "custom");
            return;
          }
          paramAnonymousAdapterView = listAppsFragment.frag;
          listAppsFragment.removeDialogLP(16);
          listAppsFragment.customselect = (File)listAppsFragment.adapt.getItem(paramAnonymousInt);
          paramAnonymousAdapterView = listAppsFragment.frag;
          listAppsFragment.showDialogLP(15);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (listAppsFragment.adapt != null)
    {
      listAppsFragment.adapt.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapter(listAppsFragment.adapt, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = listAppsFragment.frag;
          listAppsFragment.removeDialogLP(26);
          paramAnonymousAdapterView = (File)listAppsFragment.adapt.getItem(paramAnonymousInt);
          listAppsFragment.frag.restore(listAppsFragment.pli, paramAnonymousAdapterView);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    if (listAppsFragment.adapt != null) {
      listAppsFragment.adapt.setNotifyOnChange(true);
    }
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext(), true);
    ((AlertDlg)localObject1).setAdapter(listAppsFragment.adapt, new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = listAppsFragment.frag;
        listAppsFragment.removeDialogLP(28);
        paramAnonymousAdapterView = (FileApkListItem)listAppsFragment.adapt.getItem(paramAnonymousInt);
        listAppsFragment.frag.toolbar_restore(paramAnonymousAdapterView, false);
      }
    });
    ((AlertDlg)localObject1).setCancelable(true);
    ((AlertDlg)localObject1).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    return ((AlertDlg)localObject1).create();
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (this.adapter != null)
    {
      this.adapter.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapterNotClose(true);
      ((AlertDlg)localObject1).setAdapter(this.adapter, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
          if (paramAnonymousView.Status) {}
          for (paramAnonymousView.Status = false;; paramAnonymousView.Status = true)
          {
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 1)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(2);
                paramAnonymousAdapterView.Status = false;
              }
            }
            paramAnonymousView = paramAnonymousAdapterView;
            if (paramAnonymousInt == 2)
            {
              paramAnonymousView = paramAnonymousAdapterView;
              if (paramAnonymousAdapterView.Status)
              {
                paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(1);
                paramAnonymousView.Status = false;
              }
            }
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 9)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                ((Patterns)All_Dialogs.this.adapter.getItem(10)).Status = true;
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(11);
                paramAnonymousAdapterView.Status = false;
              }
            }
            if ((paramAnonymousInt == 11) && (paramAnonymousAdapterView.Status))
            {
              ((Patterns)All_Dialogs.this.adapter.getItem(10)).Status = true;
              ((Patterns)All_Dialogs.this.adapter.getItem(9)).Status = false;
            }
            All_Dialogs.this.adapter.notifyDataSetChanged();
            return;
          }
        }
      });
      ((AlertDlg)localObject1).setPositiveButton(Utils.getText(2131165592), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Object localObject = "1";
          int i = All_Dialogs.this.adapter.getCount();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            Patterns localPatterns = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (localPatterns.Status)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (paramAnonymousInt < 7) {
                paramAnonymousDialogInterface = (String)localObject + "pattern" + paramAnonymousInt + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 7)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "dependencies" + "_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 8)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "fulloffline" + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 9)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "copyDC" + "_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 10)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "backup" + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 11)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "deleteDC" + "_";
              }
            }
            paramAnonymousInt += 1;
          }
          listAppsFragment.frag.ads(listAppsFragment.pli, (String)localObject);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (this.adapter != null)
    {
      this.adapter.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapterNotClose(true);
      ((AlertDlg)localObject1).setAdapter(this.adapter, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
          if (paramAnonymousView.Status) {}
          for (paramAnonymousView.Status = false;; paramAnonymousView.Status = true)
          {
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 1)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(2);
                paramAnonymousAdapterView.Status = false;
              }
            }
            if ((paramAnonymousInt == 2) && (paramAnonymousAdapterView.Status)) {
              ((Patterns)All_Dialogs.this.adapter.getItem(1)).Status = false;
            }
            All_Dialogs.this.adapter.notifyDataSetChanged();
            return;
          }
        }
      });
      ((AlertDlg)localObject1).setPositiveButton(Utils.getText(2131165382), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Object localObject = "1";
          int i = All_Dialogs.this.adapter.getCount();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            Patterns localPatterns = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (localPatterns.Status)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (paramAnonymousInt < 7) {
                paramAnonymousDialogInterface = (String)localObject + "pattern" + paramAnonymousInt + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 7)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "dependencies" + "_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 8)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "fulloffline" + "_";
              }
            }
            paramAnonymousInt += 1;
            localObject = paramAnonymousDialogInterface;
          }
          if (listAppsFragment.rebuldApk.equals(""))
          {
            listAppsFragment.frag.createapkads((String)localObject);
            return;
          }
          listAppsFragment.frag.toolbar_createapkads((String)localObject);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (this.adapter != null)
    {
      this.adapter.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapterNotClose(true);
      ((AlertDlg)localObject1).setAdapter(this.adapter, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
          if (paramAnonymousView.Status) {}
          for (paramAnonymousView.Status = false;; paramAnonymousView.Status = true)
          {
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 3)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                ((Patterns)All_Dialogs.this.adapter.getItem(4)).Status = true;
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(5);
                paramAnonymousAdapterView.Status = false;
              }
            }
            if ((paramAnonymousInt == 5) && (paramAnonymousAdapterView.Status))
            {
              ((Patterns)All_Dialogs.this.adapter.getItem(4)).Status = true;
              ((Patterns)All_Dialogs.this.adapter.getItem(3)).Status = false;
            }
            All_Dialogs.this.adapter.notifyDataSetChanged();
            return;
          }
        }
      });
      ((AlertDlg)localObject1).setPositiveButton(Utils.getText(2131165592), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Object localObject = "1";
          int i = All_Dialogs.this.adapter.getCount();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            Patterns localPatterns = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (localPatterns.Status)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (paramAnonymousInt < 3) {
                paramAnonymousDialogInterface = (String)localObject + "pattern" + paramAnonymousInt + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 3)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "copyDC" + "_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 4)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "backup" + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 5)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "deleteDC" + "_";
              }
            }
            paramAnonymousInt += 1;
          }
          listAppsFragment.frag.support(listAppsFragment.pli, (String)localObject);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (this.adapter != null)
    {
      this.adapter.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapterNotClose(true);
      ((AlertDlg)localObject1).setAdapter(this.adapter, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView.Status) {}
          for (paramAnonymousAdapterView.Status = false;; paramAnonymousAdapterView.Status = true)
          {
            All_Dialogs.this.adapter.notifyDataSetChanged();
            return;
          }
        }
      });
      ((AlertDlg)localObject1).setPositiveButton(Utils.getText(2131165382), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = "1";
          int i = All_Dialogs.this.adapter.getCount();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            Object localObject = paramAnonymousDialogInterface;
            if (((Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt)).Status)
            {
              localObject = paramAnonymousDialogInterface;
              if (paramAnonymousInt < 3) {
                localObject = paramAnonymousDialogInterface + "pattern" + paramAnonymousInt + "_";
              }
            }
            paramAnonymousInt += 1;
            paramAnonymousDialogInterface = (DialogInterface)localObject;
          }
          if (listAppsFragment.rebuldApk.equals(""))
          {
            listAppsFragment.frag.createapksupport(paramAnonymousDialogInterface);
            return;
          }
          listAppsFragment.frag.toolbar_createapksupport(paramAnonymousDialogInterface);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (this.adapter != null)
    {
      this.adapter.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapterNotClose(true);
      ((AlertDlg)localObject1).setAdapter(this.adapter, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
          if (paramAnonymousView.Status) {}
          for (paramAnonymousView.Status = false;; paramAnonymousView.Status = true)
          {
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 0)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(1);
                paramAnonymousAdapterView.Status = false;
              }
            }
            paramAnonymousView = paramAnonymousAdapterView;
            if (paramAnonymousInt == 1)
            {
              paramAnonymousView = paramAnonymousAdapterView;
              if (paramAnonymousAdapterView.Status)
              {
                paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(0);
                paramAnonymousView.Status = false;
              }
            }
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 3)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                ((Patterns)All_Dialogs.this.adapter.getItem(0)).Status = false;
                ((Patterns)All_Dialogs.this.adapter.getItem(1)).Status = false;
                ((Patterns)All_Dialogs.this.adapter.getItem(2)).Status = false;
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(4);
                paramAnonymousAdapterView.Status = false;
              }
            }
            if ((paramAnonymousInt == 4) && (paramAnonymousAdapterView.Status))
            {
              ((Patterns)All_Dialogs.this.adapter.getItem(0)).Status = false;
              ((Patterns)All_Dialogs.this.adapter.getItem(1)).Status = false;
              ((Patterns)All_Dialogs.this.adapter.getItem(2)).Status = false;
              ((Patterns)All_Dialogs.this.adapter.getItem(3)).Status = false;
            }
            All_Dialogs.this.adapter.notifyDataSetChanged();
            return;
          }
        }
      });
      ((AlertDlg)localObject1).setPositiveButton(Utils.getText(2131165382), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Object localObject = "1";
          int i = All_Dialogs.this.adapter.getCount();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            Patterns localPatterns = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 0)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = "pattern1_pattern2_pattern3_pattern5_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 1)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = "pattern1_pattern2_pattern3_pattern6_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 2)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "pattern4" + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 3)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "amazon" + "_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 4)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "samsung" + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 5)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "dependencies" + "_";
              }
            }
            paramAnonymousInt += 1;
          }
          if (listAppsFragment.rebuldApk.equals(""))
          {
            listAppsFragment.frag.createapklvl((String)localObject);
            return;
          }
          listAppsFragment.frag.toolbar_createapklvl((String)localObject);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext());
    if (this.adapter != null)
    {
      this.adapter.setNotifyOnChange(true);
      ((AlertDlg)localObject1).setAdapterNotClose(true);
      ((AlertDlg)localObject1).setAdapter(this.adapter, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
          if (paramAnonymousView.Status) {}
          for (paramAnonymousView.Status = false;; paramAnonymousView.Status = true)
          {
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 0)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(1);
                paramAnonymousAdapterView.Status = false;
              }
            }
            paramAnonymousView = paramAnonymousAdapterView;
            if (paramAnonymousInt == 1)
            {
              paramAnonymousView = paramAnonymousAdapterView;
              if (paramAnonymousAdapterView.Status)
              {
                paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(0);
                paramAnonymousView.Status = false;
              }
            }
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 3)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                ((Patterns)All_Dialogs.this.adapter.getItem(0)).Status = false;
                ((Patterns)All_Dialogs.this.adapter.getItem(1)).Status = false;
                ((Patterns)All_Dialogs.this.adapter.getItem(2)).Status = false;
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(4);
                paramAnonymousAdapterView.Status = false;
              }
            }
            paramAnonymousView = paramAnonymousAdapterView;
            if (paramAnonymousInt == 4)
            {
              paramAnonymousView = paramAnonymousAdapterView;
              if (paramAnonymousAdapterView.Status)
              {
                ((Patterns)All_Dialogs.this.adapter.getItem(0)).Status = false;
                ((Patterns)All_Dialogs.this.adapter.getItem(1)).Status = false;
                ((Patterns)All_Dialogs.this.adapter.getItem(2)).Status = false;
                paramAnonymousView = (Patterns)All_Dialogs.this.adapter.getItem(3);
                paramAnonymousView.Status = false;
              }
            }
            paramAnonymousAdapterView = paramAnonymousView;
            if (paramAnonymousInt == 6)
            {
              paramAnonymousAdapterView = paramAnonymousView;
              if (paramAnonymousView.Status)
              {
                ((Patterns)All_Dialogs.this.adapter.getItem(7)).Status = true;
                paramAnonymousAdapterView = (Patterns)All_Dialogs.this.adapter.getItem(8);
                paramAnonymousAdapterView.Status = false;
              }
            }
            if ((paramAnonymousInt == 8) && (paramAnonymousAdapterView.Status))
            {
              ((Patterns)All_Dialogs.this.adapter.getItem(7)).Status = true;
              ((Patterns)All_Dialogs.this.adapter.getItem(6)).Status = false;
            }
            All_Dialogs.this.adapter.notifyDataSetChanged();
            return;
          }
        }
      });
      ((AlertDlg)localObject1).setPositiveButton(Utils.getText(2131165592), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Object localObject = "1";
          int i = All_Dialogs.this.adapter.getCount();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            Patterns localPatterns = (Patterns)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 0)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = "pattern1_pattern2_pattern3_pattern5_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 1)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = "pattern1_pattern2_pattern3_pattern6_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 2)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "pattern4" + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 3)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "amazon" + "_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 4)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "samsung" + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 5)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "dependencies" + "_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 6)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "copyDC" + "_";
              }
            }
            localObject = paramAnonymousDialogInterface;
            if (paramAnonymousInt == 7)
            {
              localObject = paramAnonymousDialogInterface;
              if (localPatterns.Status) {
                localObject = paramAnonymousDialogInterface + "backup" + "_";
              }
            }
            paramAnonymousDialogInterface = (DialogInterface)localObject;
            if (paramAnonymousInt == 8)
            {
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (localPatterns.Status) {
                paramAnonymousDialogInterface = (String)localObject + "deleteDC" + "_";
              }
            }
            paramAnonymousInt += 1;
            localObject = paramAnonymousDialogInterface;
          }
          listAppsFragment.frag.addIgnoreOdex(listAppsFragment.pli, (String)localObject);
        }
      });
    }
    return ((AlertDlg)localObject1).create();
    localObject1 = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968608, null);
    localObject3 = (ListView)((LinearLayout)localObject1).findViewById(2131558537);
    final Object localObject4 = (CheckBox)((LinearLayout)localObject1).findViewById(2131558538);
    ((CheckBox)localObject4).setChecked(true);
    ((CheckBox)localObject4).setText(Utils.getText(2131165371));
    ((CheckBox)localObject4).setMaxLines(1);
    if ((Utils.getFileDalvikCache("/system/framework/core.jar") != null) && (!Utils.getCurrentRuntimeValue().equals("ART")))
    {
      ((CheckBox)localObject4).setChecked(true);
      listAppsFragment.patchOnlyDalvikCore = true;
    }
    for (;;)
    {
      ((CheckBox)localObject4).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          if (!Utils.getCurrentRuntimeValue().equals("ART"))
          {
            listAppsFragment.patchOnlyDalvikCore = paramAnonymousBoolean;
            return;
          }
          if ((listAppsFragment.api >= 20) && (Utils.getCurrentRuntimeValue().equals("ART")) && ((Utils.isBootOatCache()) || (Utils.isServicesCache())))
          {
            listAppsFragment.patchOnlyDalvikCore = paramAnonymousBoolean;
            return;
          }
          localObject4.setChecked(false);
          localObject4.setEnabled(false);
          listAppsFragment.patchOnlyDalvikCore = false;
        }
      });
      localObject5 = new AlertDlg(listAppsFragment.frag.getContext());
      if (this.adapter != null)
      {
        this.adapter.setNotifyOnChange(true);
        ((ListView)localObject3).setAdapter(this.adapter);
        ((ListView)localObject3).setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[] { -1715492012, -4215980, -1715492012 }));
        ((ListView)localObject3).setDividerHeight(1);
        ((ListView)localObject3).setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            paramAnonymousAdapterView = (CoreItem)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
            paramAnonymousView = (CoreItem)All_Dialogs.this.adapter.getItem(2);
            CoreItem localCoreItem1 = (CoreItem)All_Dialogs.this.adapter.getItem(3);
            CoreItem localCoreItem2 = (CoreItem)All_Dialogs.this.adapter.getItem(4);
            CoreItem localCoreItem3 = (CoreItem)All_Dialogs.this.adapter.getItem(5);
            if ((paramAnonymousAdapterView.Status) && (paramAnonymousInt != 3)) {}
            for (paramAnonymousAdapterView.Status = false;; paramAnonymousAdapterView.Status = true) {
              do
              {
                if (((paramAnonymousInt == 0) || (paramAnonymousInt == 1)) && (paramAnonymousAdapterView.Status) && ((paramAnonymousView.Status) || (localCoreItem1.Status)) && (((!Utils.exists("/system/framework/core.odex")) && (!Utils.exists("/system/framework/core-libart.odex"))) || (Utils.getCurrentRuntimeValue().contains("ART"))))
                {
                  localCoreItem1.Status = false;
                  paramAnonymousView.Status = false;
                  listAppsFragment.frag.showMessage(Utils.getText(2131165748), Utils.getText(2131165602));
                }
                if (((paramAnonymousInt == 2) || (paramAnonymousInt == 3)) && (paramAnonymousAdapterView.Status) && (((!Utils.exists("/system/framework/core.odex")) && (!Utils.exists("/system/framework/core-libart.odex"))) || ((Utils.getCurrentRuntimeValue().contains("ART")) && ((((CoreItem)All_Dialogs.this.adapter.getItem(0)).Status) || (((CoreItem)All_Dialogs.this.adapter.getItem(1)).Status)))))
                {
                  ((CoreItem)All_Dialogs.this.adapter.getItem(0)).Status = false;
                  ((CoreItem)All_Dialogs.this.adapter.getItem(1)).Status = false;
                  listAppsFragment.frag.showMessage(Utils.getText(2131165748), Utils.getText(2131165602));
                }
                if ((!localCoreItem2.Status) && (!localCoreItem3.Status) && (listAppsFragment.api >= 20) && (listAppsFragment.patchOnlyDalvikCore) && (Utils.getCurrentRuntimeValue().equals("ART")))
                {
                  if ((paramAnonymousInt == 2) && (!Utils.isServicesCache()))
                  {
                    listAppsFragment.frag.showMessage(Utils.getText(2131165748), Utils.getText(2131165811));
                    ((CoreItem)All_Dialogs.this.adapter.getItem(0)).Status = false;
                    ((CoreItem)All_Dialogs.this.adapter.getItem(1)).Status = false;
                    listAppsFragment.patchOnlyDalvikCore = false;
                    localObject4.setChecked(false);
                  }
                  if ((paramAnonymousInt == 2) && (!Utils.isBootOatCache()))
                  {
                    listAppsFragment.frag.showMessage(Utils.getText(2131165748), Utils.getText(2131165810));
                    ((CoreItem)All_Dialogs.this.adapter.getItem(2)).Status = false;
                    listAppsFragment.patchOnlyDalvikCore = false;
                    localObject4.setChecked(false);
                  }
                }
                if ((paramAnonymousInt == 4) && (paramAnonymousAdapterView.Status))
                {
                  ((CoreItem)All_Dialogs.this.adapter.getItem(0)).Status = false;
                  ((CoreItem)All_Dialogs.this.adapter.getItem(1)).Status = false;
                  ((CoreItem)All_Dialogs.this.adapter.getItem(2)).Status = false;
                  ((CoreItem)All_Dialogs.this.adapter.getItem(3)).Status = false;
                }
                if ((paramAnonymousInt == 5) && (paramAnonymousAdapterView.Status))
                {
                  ((CoreItem)All_Dialogs.this.adapter.getItem(0)).Status = false;
                  ((CoreItem)All_Dialogs.this.adapter.getItem(1)).Status = false;
                  ((CoreItem)All_Dialogs.this.adapter.getItem(2)).Status = false;
                  ((CoreItem)All_Dialogs.this.adapter.getItem(3)).Status = false;
                }
                All_Dialogs.this.adapter.notifyDataSetChanged();
                return;
              } while ((localCoreItem2.Status) || (localCoreItem3.Status) || (paramAnonymousAdapterView.disabled) || (paramAnonymousInt == 3));
            }
          }
        });
        ((AlertDlg)localObject5).setView((View)localObject1);
        ((AlertDlg)localObject5).setPositiveButton(Utils.getText(2131165592), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            Object localObject = "patch";
            int i2 = All_Dialogs.this.adapter.getCount();
            int i1 = 0;
            int j = 0;
            int i = 0;
            paramAnonymousInt = 0;
            int k = 0;
            if (k < i2)
            {
              CoreItem localCoreItem = (CoreItem)All_Dialogs.this.adapter.getItem(k);
              int m = i1;
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (k == 0)
              {
                m = i1;
                paramAnonymousDialogInterface = (DialogInterface)localObject;
                if (localCoreItem.Status)
                {
                  paramAnonymousDialogInterface = (String)localObject + "_patch1";
                  m = 1;
                }
              }
              int n = j;
              localObject = paramAnonymousDialogInterface;
              if (k == 1)
              {
                n = j;
                localObject = paramAnonymousDialogInterface;
                if (localCoreItem.Status)
                {
                  localObject = paramAnonymousDialogInterface + "_patch2";
                  n = 1;
                }
              }
              j = i;
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (k == 2)
              {
                j = i;
                paramAnonymousDialogInterface = (DialogInterface)localObject;
                if (localCoreItem.Status)
                {
                  paramAnonymousDialogInterface = (String)localObject + "_patch3";
                  j = 1;
                }
              }
              i = j;
              localObject = paramAnonymousDialogInterface;
              if (k == 3)
              {
                i = j;
                localObject = paramAnonymousDialogInterface;
                if (localCoreItem.Status)
                {
                  localObject = paramAnonymousDialogInterface + "_patch4";
                  i = 1;
                }
              }
              j = paramAnonymousInt;
              paramAnonymousDialogInterface = (DialogInterface)localObject;
              if (k == 4)
              {
                j = paramAnonymousInt;
                paramAnonymousDialogInterface = (DialogInterface)localObject;
                if (localCoreItem.Status)
                {
                  paramAnonymousDialogInterface = "restoreCore";
                  j = 1;
                }
              }
              paramAnonymousInt = j;
              localObject = paramAnonymousDialogInterface;
              if (k == 5)
              {
                paramAnonymousInt = j;
                localObject = paramAnonymousDialogInterface;
                if (localCoreItem.Status) {
                  if (!paramAnonymousDialogInterface.contains("restoreCore")) {
                    break label362;
                  }
                }
              }
              label362:
              for (localObject = paramAnonymousDialogInterface + "_restoreServices";; localObject = "restoreServices")
              {
                paramAnonymousInt = 1;
                k += 1;
                i1 = m;
                j = n;
                break;
              }
            }
            if ((i1 != 0) || (j != 0) || (i != 0) || (paramAnonymousInt != 0)) {
              listAppsFragment.frag.corepatch((String)localObject);
            }
          }
        });
      }
      return ((AlertDlg)localObject5).create();
      if ((listAppsFragment.api >= 20) && (Utils.getCurrentRuntimeValue().equals("ART")) && ((Utils.isBootOatCache()) || (Utils.isServicesCache())))
      {
        ((CheckBox)localObject4).setChecked(true);
        listAppsFragment.patchOnlyDalvikCore = true;
      }
      else
      {
        listAppsFragment.patchOnlyDalvikCore = false;
        ((CheckBox)localObject4).setChecked(false);
        ((CheckBox)localObject4).setEnabled(false);
      }
    }
    Object localObject2 = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968608, null);
    localObject3 = (CheckBox)((LinearLayout)localObject2).findViewById(2131558538);
    ((CheckBox)localObject3).setChecked(Utils.readXposedParamBoolean().getBoolean("module_on"));
    if (Utils.isXposedEnabled())
    {
      ((CheckBox)localObject3).setEnabled(true);
      ((CheckBox)localObject3).setText(Utils.getText(2131165750));
      ((CheckBox)localObject3).setMaxLines(2);
      localObject4 = new AlertDlg(listAppsFragment.frag.getContext());
      if (this.adapter != null)
      {
        this.adapter.setNotifyOnChange(true);
        localObject5 = (ListView)((LinearLayout)localObject2).findViewById(2131558537);
        ((ListView)localObject5).setAdapter(this.adapter);
        ((ListView)localObject5).setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[] { -1715492012, -4215980, -1715492012 }));
        ((ListView)localObject5).setDividerHeight(1);
        if (Utils.isXposedEnabled()) {
          ((ListView)localObject5).setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              paramAnonymousAdapterView = (CoreItem)All_Dialogs.this.adapter.getItem(paramAnonymousInt);
              System.out.println("" + paramAnonymousAdapterView.Status);
              if (paramAnonymousAdapterView.Status) {}
              for (paramAnonymousAdapterView.Status = false;; paramAnonymousAdapterView.Status = true)
              {
                System.out.println("" + ((CoreItem)All_Dialogs.this.adapter.getItem(paramAnonymousInt)).Status);
                All_Dialogs.this.adapter.notifyDataSetChanged();
                return;
              }
            }
          });
        }
        ((AlertDlg)localObject4).setView((View)localObject2);
        if (Utils.isXposedEnabled()) {
          break label2005;
        }
        ((AlertDlg)localObject4).setPositiveButton(Utils.getText(2131165587), null);
      }
    }
    for (;;)
    {
      return ((AlertDlg)localObject4).create();
      ((CheckBox)localObject3).setEnabled(false);
      ((CheckBox)localObject3).setChecked(false);
      ((CheckBox)localObject3).setText(Utils.getText(2131165752));
      break;
      label2005:
      ((AlertDlg)localObject4).setPositiveButton(Utils.getText(2131165736), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          new Thread(new Runnable()
          {
            /* Error */
            public void run()
            {
              // Byte code:
              //   0: aload_0
              //   1: getfield 19	com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35$1:this$1	Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35;
              //   4: getfield 32	com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs;
              //   7: getfield 38	com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs:adapter	Landroid/widget/ArrayAdapter;
              //   10: invokevirtual 44	android/widget/ArrayAdapter:getCount	()I
              //   13: istore_2
              //   14: new 46	org/json/JSONObject
              //   17: dup
              //   18: invokespecial 47	org/json/JSONObject:<init>	()V
              //   21: astore 7
              //   23: iconst_0
              //   24: istore_1
              //   25: iload_1
              //   26: iload_2
              //   27: if_icmpge +370 -> 397
              //   30: aload_0
              //   31: getfield 19	com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35$1:this$1	Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35;
              //   34: getfield 32	com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs;
              //   37: getfield 38	com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs:adapter	Landroid/widget/ArrayAdapter;
              //   40: iload_1
              //   41: invokevirtual 51	android/widget/ArrayAdapter:getItem	(I)Ljava/lang/Object;
              //   44: checkcast 53	com/android/vending/billing/InAppBillingService/LACK/CoreItem
              //   47: astore 8
              //   49: getstatic 59	java/lang/System:out	Ljava/io/PrintStream;
              //   52: new 61	java/lang/StringBuilder
              //   55: dup
              //   56: invokespecial 62	java/lang/StringBuilder:<init>	()V
              //   59: ldc 64
              //   61: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   64: aload 8
              //   66: getfield 72	com/android/vending/billing/InAppBillingService/LACK/CoreItem:Status	Z
              //   69: invokevirtual 75	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
              //   72: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   75: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
              //   78: iload_1
              //   79: ifne +16 -> 95
              //   82: aload 7
              //   84: ldc 87
              //   86: aload 8
              //   88: getfield 72	com/android/vending/billing/InAppBillingService/LACK/CoreItem:Status	Z
              //   91: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
              //   94: pop
              //   95: iload_1
              //   96: iconst_1
              //   97: if_icmpne +16 -> 113
              //   100: aload 7
              //   102: ldc 93
              //   104: aload 8
              //   106: getfield 72	com/android/vending/billing/InAppBillingService/LACK/CoreItem:Status	Z
              //   109: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
              //   112: pop
              //   113: iload_1
              //   114: iconst_2
              //   115: if_icmpne +16 -> 131
              //   118: aload 7
              //   120: ldc 95
              //   122: aload 8
              //   124: getfield 72	com/android/vending/billing/InAppBillingService/LACK/CoreItem:Status	Z
              //   127: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
              //   130: pop
              //   131: iload_1
              //   132: iconst_3
              //   133: if_icmpne +76 -> 209
              //   136: ldc 97
              //   138: iconst_0
              //   139: invokestatic 103	com/chelpus/Utils:getPkgInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
              //   142: astore 9
              //   144: aload 9
              //   146: ifnull +50 -> 196
              //   149: new 105	java/io/File
              //   152: dup
              //   153: aload 9
              //   155: getfield 111	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
              //   158: getfield 117	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
              //   161: iconst_0
              //   162: invokestatic 121	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
              //   165: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
              //   168: astore 10
              //   170: lconst_0
              //   171: lstore_3
              //   172: aload 10
              //   174: invokevirtual 127	java/io/File:length	()J
              //   177: lstore 5
              //   179: lload 5
              //   181: lstore_3
              //   182: lload_3
              //   183: ldc2_w 128
              //   186: lcmp
              //   187: ifgt +9 -> 196
              //   190: lload_3
              //   191: lconst_0
              //   192: lcmp
              //   193: ifne +71 -> 264
              //   196: aload 7
              //   198: ldc -125
              //   200: aload 8
              //   202: getfield 72	com/android/vending/billing/InAppBillingService/LACK/CoreItem:Status	Z
              //   205: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
              //   208: pop
              //   209: iload_1
              //   210: iconst_4
              //   211: if_icmpne +16 -> 227
              //   214: aload 7
              //   216: ldc -123
              //   218: aload 8
              //   220: getfield 72	com/android/vending/billing/InAppBillingService/LACK/CoreItem:Status	Z
              //   223: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
              //   226: pop
              //   227: iload_1
              //   228: iconst_1
              //   229: iadd
              //   230: istore_1
              //   231: goto -206 -> 25
              //   234: astore 9
              //   236: aload 9
              //   238: invokevirtual 136	org/json/JSONException:printStackTrace	()V
              //   241: goto -146 -> 95
              //   244: astore 9
              //   246: aload 9
              //   248: invokevirtual 136	org/json/JSONException:printStackTrace	()V
              //   251: goto -138 -> 113
              //   254: astore 9
              //   256: aload 9
              //   258: invokevirtual 136	org/json/JSONException:printStackTrace	()V
              //   261: goto -130 -> 131
              //   264: new 99	com/chelpus/Utils
              //   267: dup
              //   268: ldc 64
              //   270: invokespecial 137	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
              //   273: iconst_1
              //   274: anewarray 139	java/lang/String
              //   277: dup
              //   278: iconst_0
              //   279: new 61	java/lang/StringBuilder
              //   282: dup
              //   283: invokespecial 62	java/lang/StringBuilder:<init>	()V
              //   286: getstatic 144	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:dalvikruncommand	Ljava/lang/String;
              //   289: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   292: ldc -110
              //   294: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   297: aload 9
              //   299: getfield 111	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
              //   302: getfield 117	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
              //   305: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   308: ldc -108
              //   310: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   313: getstatic 151	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
              //   316: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   319: ldc -108
              //   321: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   324: aload 9
              //   326: getfield 111	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
              //   329: getfield 155	android/content/pm/ApplicationInfo:uid	I
              //   332: invokestatic 159	java/lang/String:valueOf	(I)Ljava/lang/String;
              //   335: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   338: ldc -95
              //   340: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   343: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   346: aastore
              //   347: invokevirtual 165	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
              //   350: pop
              //   351: iconst_1
              //   352: invokestatic 169	com/chelpus/Utils:market_billing_services	(Z)V
              //   355: iconst_1
              //   356: invokestatic 172	com/chelpus/Utils:market_licensing_services	(Z)V
              //   359: ldc 97
              //   361: invokestatic 175	com/chelpus/Utils:kill	(Ljava/lang/String;)V
              //   364: goto -168 -> 196
              //   367: astore 9
              //   369: aload 9
              //   371: invokevirtual 176	java/lang/Exception:printStackTrace	()V
              //   374: goto -178 -> 196
              //   377: astore 9
              //   379: aload 9
              //   381: invokevirtual 136	org/json/JSONException:printStackTrace	()V
              //   384: goto -175 -> 209
              //   387: astore 8
              //   389: aload 8
              //   391: invokevirtual 136	org/json/JSONException:printStackTrace	()V
              //   394: goto -167 -> 227
              //   397: aload 7
              //   399: ldc -78
              //   401: aload_0
              //   402: getfield 19	com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35$1:this$1	Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35;
              //   405: getfield 182	com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35:val$chk_x	Landroid/widget/CheckBox;
              //   408: invokevirtual 188	android/widget/CheckBox:isChecked	()Z
              //   411: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
              //   414: pop
              //   415: new 190	java/lang/Thread
              //   418: dup
              //   419: new 13	com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35$1$1
              //   422: dup
              //   423: aload_0
              //   424: aload 7
              //   426: invokespecial 193	com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35$1$1:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs$35$1;Lorg/json/JSONObject;)V
              //   429: invokespecial 196	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
              //   432: invokevirtual 199	java/lang/Thread:start	()V
              //   435: return
              //   436: astore 8
              //   438: aload 8
              //   440: invokevirtual 136	org/json/JSONException:printStackTrace	()V
              //   443: goto -28 -> 415
              //   446: astore 10
              //   448: goto -266 -> 182
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	451	0	this	1
              //   24	207	1	i	int
              //   13	15	2	j	int
              //   171	20	3	l1	long
              //   177	3	5	l2	long
              //   21	404	7	localJSONObject	JSONObject
              //   47	172	8	localCoreItem	CoreItem
              //   387	3	8	localJSONException1	org.json.JSONException
              //   436	3	8	localJSONException2	org.json.JSONException
              //   142	12	9	localPackageInfo	PackageInfo
              //   234	3	9	localJSONException3	org.json.JSONException
              //   244	3	9	localJSONException4	org.json.JSONException
              //   254	71	9	localJSONException5	org.json.JSONException
              //   367	3	9	localException1	Exception
              //   377	3	9	localJSONException6	org.json.JSONException
              //   168	5	10	localFile	File
              //   446	1	10	localException2	Exception
              // Exception table:
              //   from	to	target	type
              //   82	95	234	org/json/JSONException
              //   100	113	244	org/json/JSONException
              //   118	131	254	org/json/JSONException
              //   264	364	367	java/lang/Exception
              //   136	144	377	org/json/JSONException
              //   149	170	377	org/json/JSONException
              //   172	179	377	org/json/JSONException
              //   196	209	377	org/json/JSONException
              //   264	364	377	org/json/JSONException
              //   369	374	377	org/json/JSONException
              //   214	227	387	org/json/JSONException
              //   397	415	436	org/json/JSONException
              //   172	179	446	java/lang/Exception
            }
          }).start();
        }
      });
    }
    localObject3 = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968606, null);
    Object localObject5 = (TextView)((LinearLayout)localObject3).findViewById(2131558534);
    localObject4 = (CheckBox)((LinearLayout)localObject3).findViewById(2131558535);
    ((TextView)localObject5).setText(Utils.getText(2131165771));
    int i;
    int j;
    if (listAppsFragment.result_core_patch.contains("_patch1"))
    {
      i = 0;
      j = 0;
      if ((!listAppsFragment.str.contains("Core patched!")) && (!listAppsFragment.str.contains("Core 2 patched!"))) {
        break label2850;
      }
      localObject2 = Utils.getText(2131165372);
      if (listAppsFragment.str.contains("Core patched!")) {
        j = 0 + 1;
      }
      i = j;
      if (!listAppsFragment.str.contains("Core 2 patched!")) {
        break label3255;
      }
      i = j + 1;
      break label3255;
    }
    for (;;)
    {
      ((TextView)localObject5).append(Utils.getText(2131165300) + " " + i + "/2 ");
      ((TextView)localObject5).append(Utils.getColoredText((String)localObject2 + "\n", j, ""));
      if (listAppsFragment.result_core_patch.contains("_patch2"))
      {
        if (listAppsFragment.str.contains("Core unsigned install patched!"))
        {
          localObject2 = Utils.getText(2131165372);
          i = -16711936;
          label2276:
          ((TextView)localObject5).append(Utils.getText(2131165302) + " ");
          ((TextView)localObject5).append(Utils.getColoredText((String)localObject2 + "\n", i, ""));
        }
      }
      else
      {
        if (listAppsFragment.result_core_patch.contains("_patch3"))
        {
          if (!listAppsFragment.str.contains("Core4 patched!")) {
            break label2878;
          }
          localObject2 = Utils.getText(2131165372);
          i = -16711936;
          label2373:
          ((TextView)localObject5).append(Utils.getText(2131165304) + " ");
          ((TextView)localObject5).append(Utils.getColoredText((String)localObject2 + "\n", i, ""));
        }
        if (listAppsFragment.result_core_patch.contains("restore"))
        {
          ((CheckBox)localObject4).setChecked(false);
          ((CheckBox)localObject4).setEnabled(false);
          Utils.turn_off_patch_on_boot_all();
          if ((listAppsFragment.str.contains("Core restored!")) || (listAppsFragment.str.contains("Core 2 restored!")))
          {
            localObject2 = Utils.getText(2131165794);
            ((TextView)localObject5).append(Utils.getText(2131165300) + " ");
            ((TextView)localObject5).append(Utils.getColoredText((String)localObject2 + "\n", -16711936, ""));
          }
          if (listAppsFragment.str.contains("Core unsigned install restored!"))
          {
            localObject2 = Utils.getText(2131165794);
            ((TextView)localObject5).append(Utils.getText(2131165302) + " ");
            ((TextView)localObject5).append(Utils.getColoredText((String)localObject2 + "\n", -16711936, ""));
          }
          if (listAppsFragment.str.contains("Core4 restored!"))
          {
            localObject2 = Utils.getText(2131165794);
            ((TextView)localObject5).append(Utils.getText(2131165304) + " ");
            ((TextView)localObject5).append(Utils.getColoredText((String)localObject2 + "\n", -16711936, ""));
          }
        }
        ((TextView)localObject5).append("\n" + Utils.getText(2131165770));
        ((CheckBox)localObject4).setChecked(false);
        ((CheckBox)localObject4).setText(Utils.getText(2131165772));
        if (!((CheckBox)localObject4).isChecked()) {
          break label2892;
        }
        Utils.turn_on_patch_on_boot(listAppsFragment.result_core_patch);
      }
      for (;;)
      {
        ((CheckBox)localObject4).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              Utils.turn_on_patch_on_boot(listAppsFragment.result_core_patch);
              return;
            }
            Utils.turn_off_patch_on_boot(listAppsFragment.result_core_patch);
          }
        });
        localObject2 = new AlertDlg(listAppsFragment.frag.getContext());
        ((AlertDlg)localObject2).setView((View)localObject3);
        ((AlertDlg)localObject2).setPositiveButton(Utils.getText(2131165587), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            if (localObject4.isChecked())
            {
              Utils.turn_on_patch_on_boot(listAppsFragment.result_core_patch);
              return;
            }
            Utils.turn_off_patch_on_boot(listAppsFragment.result_core_patch);
          }
        }).setTitle(2131165495);
        return ((AlertDlg)localObject2).create();
        label2850:
        localObject2 = Utils.getText(2131165373);
        j = -65536;
        break;
        localObject2 = Utils.getText(2131165373);
        i = -65536;
        break label2276;
        label2878:
        localObject2 = Utils.getText(2131165372);
        i = -65536;
        break label2373;
        label2892:
        Utils.turn_off_patch_on_boot(listAppsFragment.result_core_patch);
      }
      localObject2 = new AlertDlg(listAppsFragment.frag.getContext());
      listAppsFragment.frag.refresh_boot();
      localObject3 = listAppsFragment.frag.getContext();
      localObject4 = listAppsFragment.getConfig();
      localObject5 = listAppsFragment.frag;
      listAppsFragment.adapter_boot = new BootListItemAdapter((Context)localObject3, 2130968593, ((SharedPreferences)localObject4).getInt("viewsize", 0), listAppsFragment.boot_pat);
      listAppsFragment.adapter_boot.sorter = new byPkgName();
      try
      {
        listAppsFragment.plia.notifyDataSetChanged();
        listAppsFragment.adapter_boot.notifyDataSetChanged();
        ((AlertDlg)localObject2).setTitle(Utils.getText(2131165407));
        ((AlertDlg)localObject2).setAdapter(listAppsFragment.adapter_boot, new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            paramAnonymousAdapterView = (PkgListItem)listAppsFragment.adapter_boot.getItem(paramAnonymousInt);
            if (paramAnonymousAdapterView.pkgName.equals(Utils.getText(2131165754))) {
              Utils.turn_off_patch_on_boot_all();
            }
            for (;;)
            {
              listAppsFragment.plia.notifyDataSetChanged();
              System.out.println("asd1");
              paramAnonymousAdapterView = listAppsFragment.frag;
              listAppsFragment.showDialogLP(3);
              return;
              try
              {
                listAppsFragment.getPkgMng().getPackageInfo(paramAnonymousAdapterView.pkgName, 0);
                paramAnonymousInt = 0;
                while (paramAnonymousInt < listAppsFragment.plia.data.length)
                {
                  if (listAppsFragment.plia.data[paramAnonymousInt].pkgName.equals(paramAnonymousAdapterView.pkgName))
                  {
                    listAppsFragment.plia.data[paramAnonymousInt].boot_ads = false;
                    listAppsFragment.plia.data[paramAnonymousInt].boot_lvl = false;
                    if (listAppsFragment.plia.data[paramAnonymousInt].boot_custom)
                    {
                      if (new File(listAppsFragment.frag.getContext().getDir("bootlist", 0) + "/" + listAppsFragment.plia.data[paramAnonymousInt].pkgName).exists()) {
                        new File(listAppsFragment.frag.getContext().getDir("bootlist", 0) + "/" + listAppsFragment.plia.data[paramAnonymousInt].pkgName).delete();
                      }
                      listAppsFragment.plia.data[paramAnonymousInt].boot_custom = false;
                    }
                    listAppsFragment.plia.data[paramAnonymousInt].boot_manual = false;
                    listAppsFragment.plia.notifyDataSetChanged(listAppsFragment.plia.data[paramAnonymousInt]);
                  }
                  paramAnonymousInt += 1;
                }
              }
              catch (PackageManager.NameNotFoundException paramAnonymousView)
              {
                if (new File(listAppsFragment.frag.getContext().getDir("bootlist", 0) + "/" + paramAnonymousAdapterView.pkgName).exists()) {
                  new File(listAppsFragment.frag.getContext().getDir("bootlist", 0) + "/" + paramAnonymousAdapterView.pkgName).delete();
                }
                new StringBuilder();
                paramAnonymousAdapterView = new StringBuilder();
                paramAnonymousInt = 0;
                while (paramAnonymousInt < listAppsFragment.plia.data.length)
                {
                  if ((listAppsFragment.plia.data[paramAnonymousInt].boot_ads) || (listAppsFragment.plia.data[paramAnonymousInt].boot_custom) || (listAppsFragment.plia.data[paramAnonymousInt].boot_lvl) || (listAppsFragment.plia.data[paramAnonymousInt].boot_manual))
                  {
                    paramAnonymousAdapterView.append(listAppsFragment.plia.data[paramAnonymousInt].pkgName);
                    if (listAppsFragment.plia.data[paramAnonymousInt].boot_ads) {
                      paramAnonymousAdapterView.append("%ads");
                    }
                    if (listAppsFragment.plia.data[paramAnonymousInt].boot_lvl) {
                      paramAnonymousAdapterView.append("%lvl");
                    }
                    if (listAppsFragment.plia.data[paramAnonymousInt].boot_custom) {
                      paramAnonymousAdapterView.append("%custom");
                    }
                    if (listAppsFragment.plia.data[paramAnonymousInt].boot_manual) {
                      paramAnonymousAdapterView.append("%object");
                    }
                    paramAnonymousAdapterView.append(",");
                  }
                  paramAnonymousInt += 1;
                }
                paramAnonymousAdapterView.append("\n");
                try
                {
                  paramAnonymousView = new FileOutputStream(new File(listAppsFragment.frag.getContext().getDir("bootlist", 0) + "/bootlist"));
                  paramAnonymousView.write(paramAnonymousAdapterView.toString().getBytes());
                  paramAnonymousView.close();
                }
                catch (FileNotFoundException paramAnonymousAdapterView) {}catch (Exception paramAnonymousAdapterView) {}
              }
            }
          }
        });
        System.out.println("asd2");
        return ((AlertDlg)localObject2).create();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          System.out.println("LuckyPatcher(Bootlist dialog): " + localException2);
        }
      }
      AlertDlg localAlertDlg = new AlertDlg(listAppsFragment.frag.getContext());
      if (listAppsFragment.dialog_int == 345350) {}
      for (localObject2 = Utils.getText(2131165656);; localObject2 = Utils.getText(2131165435))
      {
        localAlertDlg.setTitle(Utils.getText(2131165748)).setIcon(2130837550).setMessage((String)localObject2).setPositiveButton(Utils.getText(2131165187), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            new AsyncTask()
            {
              protected Boolean doInBackground(Void... paramAnonymous2VarArgs)
              {
                return Boolean.valueOf(listAppsFragment.mLogCollector.collect(listAppsFragment.frag.getContext(), true));
              }
              
              protected void onPostExecute(Boolean paramAnonymous2Boolean)
              {
                listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                listAppsFragment.removeDialogLP(3255);
                if (paramAnonymous2Boolean.booleanValue()) {
                  try
                  {
                    listAppsFragment.mLogCollector.sendLog(listAppsFragment.frag.getContext(), "lp.chelpus@gmail.com", "Error Log", "Lucky Patcher " + listAppsFragment.getPkgMng().getPackageInfo(listAppsFragment.frag.getContext().getPackageName(), 0).versionName);
                    return;
                  }
                  catch (PackageManager.NameNotFoundException paramAnonymous2Boolean)
                  {
                    paramAnonymous2Boolean.printStackTrace();
                    return;
                  }
                }
                paramAnonymous2Boolean = listAppsFragment.frag;
                listAppsFragment.showDialogLP(3535122);
              }
              
              protected void onPreExecute()
              {
                listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                listAppsFragment.showDialogLP(3255);
              }
            }.execute(new Void[0]);
          }
        }).setNegativeButton(Utils.getText(2131165563), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        return localAlertDlg.create();
      }
      localObject2 = new ProgressDialog(listAppsFragment.frag.getContext());
      ((ProgressDialog)localObject2).setTitle("Progress");
      ((ProgressDialog)localObject2).setMessage(Utils.getText(2131165255));
      ((ProgressDialog)localObject2).setIndeterminate(true);
      return (Dialog)localObject2;
      localObject2 = new AlertDlg(listAppsFragment.frag.getContext());
      ((AlertDlg)localObject2).setTitle("Error").setMessage(Utils.getText(2131165433)).setNegativeButton("OK", null);
      localObject2 = ((AlertDlg)localObject2).create();
      return (Dialog)localObject2;
      return null;
      label3255:
      j = -16711936;
    }
  }
  
  public void showDialog()
  {
    if (this.dialog == null) {
      this.dialog = onCreateDialog();
    }
    if (this.dialog != null) {
      this.dialog.show();
    }
  }
  
  public class byPkgName
    implements Comparator<PkgListItem>
  {
    public byPkgName() {}
    
    public int compare(PkgListItem paramPkgListItem1, PkgListItem paramPkgListItem2)
    {
      if ((paramPkgListItem1 == null) || (paramPkgListItem2 == null)) {
        throw new ClassCastException();
      }
      if ((paramPkgListItem1.stored == 0) || (paramPkgListItem2.stored == 0))
      {
        int i = Integer.valueOf(paramPkgListItem1.stored).compareTo(Integer.valueOf(paramPkgListItem2.stored));
        if (i == 0) {
          return paramPkgListItem1.toString().compareToIgnoreCase(paramPkgListItem2.toString());
        }
        return i;
      }
      return paramPkgListItem1.toString().compareToIgnoreCase(paramPkgListItem2.toString());
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/All_Dialogs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */