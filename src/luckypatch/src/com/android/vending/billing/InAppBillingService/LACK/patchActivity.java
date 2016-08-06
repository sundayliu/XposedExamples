package com.android.vending.billing.InAppBillingService.LACK;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.vending.billing.InAppBillingService.LACK.dialogs.FilterFragment;
import com.android.vending.billing.InAppBillingService.LACK.dialogs.Progress_Dialog_2;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.InAppBillingFService;
import com.google.android.finsky.billing.iab.InAppBillingService;
import com.google.android.finsky.billing.iab.MarketBillingService;
import com.google.android.finsky.services.LicensingService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class patchActivity
  extends FragmentActivity
{
  public static final int APP_DIALOG = 6;
  public static final int CONTEXT_DIALOG = 7;
  public static final int CREATE_APK = 0;
  public static final int CUSTOM2_DIALOG = 15;
  public static final int CUSTOM_PATCH = 1;
  public static final int DIALOG_REPORT_FORCE_CLOSE = 3535788;
  public static final int MARKET_INSTALL_DIALOG = 30;
  public static final int PROGRESS_DIALOG2 = 11;
  public static final int RESTORE_FROM_BACKUP = 28;
  private static final int SETTINGS_ORIENT_LANDSCAPE = 1;
  private static final int SETTINGS_ORIENT_PORTRET = 2;
  public static final int SETTINGS_VIEWSIZE_DEFAULT = 0;
  private static final int SETTINGS_VIEWSIZE_SMALL = 0;
  public static listAppsFragment frag = null;
  boolean mIsRestoredToTop = false;
  
  public void apply_click(View paramView)
  {
    paramView = frag;
    listAppsFragment.removeDialogLP(15);
    if (listAppsFragment.func == 1) {
      frag.custompatch(listAppsFragment.pli);
    }
    if (listAppsFragment.func == 0) {
      frag.createapkcustom();
    }
  }
  
  public void backup_click(View paramView)
  {
    try
    {
      listAppsFragment.str = "";
      paramView = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".backup " + listAppsFragment.pli.pkgName });
      listAppsFragment.tvt.setText(Utils.getColoredText(paramView, "#ff00ff73", "bold"));
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void cancel_click(View paramView)
  {
    paramView = frag;
    listAppsFragment.removeDialogLP(15);
  }
  
  public void finish()
  {
    if (listAppsFragment.su)
    {
      System.out.println("Enf: " + Utils.getSELinux());
      if (!Utils.getSELinux().equals("enforce")) {}
    }
    try
    {
      new Utils("").cmdRoot(new String[] { "setenforce 1" });
      super.finish();
      if ((Build.VERSION.SDK_INT >= 19) && (!isTaskRoot()) && (this.mIsRestoredToTop)) {
        ((ActivityManager)getSystemService("activity")).moveTaskToFront(getTaskId(), 2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void fixobject_click(View paramView)
  {
    try
    {
      frag.odex(listAppsFragment.pli);
      paramView = "" + Utils.getText(2131165199);
      listAppsFragment.tvt.setText(Utils.getColoredText(paramView, "#ff00ff73", "bold"));
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      Toast.makeText(this, "Error while saving file", 1).show();
    }
  }
  
  public void launch_click(View paramView)
  {
    if (listAppsFragment.getConfig().getBoolean("vibration", false))
    {
      frag.vib = ((Vibrator)getSystemService("vibrator"));
      frag.vib.vibrate(50L);
    }
    paramView = frag;
    listAppsFragment.removeDialogLP(6);
    try
    {
      Utils.run_all("killall " + listAppsFragment.pli.pkgName);
      paramView = listAppsFragment.getPkgMng().getLaunchIntentForPackage(listAppsFragment.pli.pkgName);
      if (listAppsFragment.su)
      {
        Utils.startApp(listAppsFragment.pli.pkgName);
        return;
      }
      startActivity(paramView);
      return;
    }
    catch (RuntimeException paramView)
    {
      paramView.printStackTrace();
      return;
    }
    catch (Exception paramView)
    {
      Toast.makeText(this, Utils.getText(2131165437), 1).show();
    }
  }
  
  public void mod_market_check(View paramView)
  {
    listAppsFragment.frag.connectToLicensing();
  }
  
  public void onBackPressed()
  {
    try
    {
      if (listAppsFragment.menu_open)
      {
        listAppsFragment.frag.hideMenu();
        return;
      }
      if (listAppsFragment.adapterSelect)
      {
        listAppsFragment.frag.resetBatchOperation();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      super.onBackPressed();
      return;
    }
    if (listAppsFragment.getConfig().getBoolean("confirm_exit", true))
    {
      DialogInterface.OnClickListener local4 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          }
          patchActivity.this.finish();
          System.exit(0);
        }
      };
      Utils.showDialogYesNo(Utils.getText(2131165209), Utils.getText(2131165540), local4, local4, null);
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    System.out.println("LuckyPatcher: create activity");
    paramBundle = getSharedPreferences("config", 4).getString("force_close_info", "");
    if ((getSharedPreferences("config", 4).getBoolean("force_close", false)) && (paramBundle.equals("")))
    {
      System.out.println("LP FC detected!");
      try
      {
        getSharedPreferences("config", 4).edit().putBoolean("force_close", false).commit();
        listAppsFragment.mLogCollector = new LogCollector();
        listAppsFragment.init();
        paramBundle = new AlertDialog.Builder(this);
        String str = Utils.getText(2131165435);
        paramBundle.setTitle(Utils.getText(2131165748)).setIcon(17301543).setMessage(str).setPositiveButton(Utils.getText(2131165187), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            new AsyncTask()
            {
              protected Boolean doInBackground(Void... paramAnonymous2VarArgs)
              {
                return Boolean.valueOf(new File(listAppsFragment.basepath + "/Log/log.txt").exists());
              }
              
              protected void onPostExecute(Boolean paramAnonymous2Boolean)
              {
                if (paramAnonymous2Boolean.booleanValue()) {
                  try
                  {
                    listAppsFragment.mLogCollector.sendLog(patchActivity.this, "lp.chelpus@gmail.com", "Error Log", "Lucky Patcher " + patchActivity.this.getPackageManager().getPackageInfo(patchActivity.this.getPackageName(), 0).versionName);
                    patchActivity.this.finish();
                    System.exit(0);
                    return;
                  }
                  catch (PackageManager.NameNotFoundException paramAnonymous2Boolean)
                  {
                    for (;;)
                    {
                      paramAnonymous2Boolean.printStackTrace();
                    }
                  }
                }
                paramAnonymous2Boolean = new AlertDialog.Builder(patchActivity.this);
                paramAnonymous2Boolean.setTitle("Error").setMessage(Utils.getText(2131165433)).setNegativeButton("OK", new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    patchActivity.this.finish();
                    System.exit(0);
                  }
                }).setOnCancelListener(new DialogInterface.OnCancelListener()
                {
                  public void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    patchActivity.this.finish();
                    System.exit(0);
                  }
                });
                paramAnonymous2Boolean.create().show();
              }
              
              protected void onPreExecute() {}
            }.execute(new Void[0]);
          }
        }).setNegativeButton(Utils.getText(2131165563), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            patchActivity.this.finish();
            System.exit(0);
          }
        }).setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            patchActivity.this.finish();
            System.exit(0);
          }
        });
        paramBundle.create().show();
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        getSharedPreferences("config", 4).edit().putBoolean("force_close", false).commit();
        finish();
        System.exit(0);
        return;
      }
    }
    listAppsFragment.desktop_launch = true;
    listAppsFragment.patchAct = this;
    listAppsFragment.appcontext = this;
    try
    {
      if (!paramBundle.equals(""))
      {
        if (paramBundle.equals("No space left on device")) {
          Utils.showSystemWindowOk(Utils.getText(2131165748), Utils.getText(2131165817));
        }
        if (paramBundle.equals("OutOfMemoryError")) {
          Utils.showSystemWindowOk(Utils.getText(2131165748), Utils.getText(2131165818));
        }
        getSharedPreferences("config", 4).edit().putString("force_close_info", "").commit();
        getSharedPreferences("config", 4).edit().putBoolean("force_close", false).commit();
      }
    }
    catch (Exception paramBundle)
    {
      try
      {
        int i;
        if (Utils.getText(2131165244) != null) {
          break label445;
        }
        finish();
        if (listAppsFragment.getConfig().getInt("orientstion", 3) != 1) {
          break label466;
        }
        setRequestedOrientation(0);
        if (listAppsFragment.getConfig().getInt("orientstion", 3) != 2) {
          break label487;
        }
        setRequestedOrientation(1);
        if (listAppsFragment.getConfig().getInt("orientstion", 3) != 3) {
          break label508;
        }
        setRequestedOrientation(4);
        getWindow().addFlags(128);
        return;
        paramBundle = paramBundle;
        getSharedPreferences("config", 4).edit().putString("force_close_info", "").commit();
        getSharedPreferences("config", 4).edit().putBoolean("force_close", false).commit();
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          finish();
        }
      }
    }
    if (listAppsFragment.getConfig().getBoolean("hide_title", false))
    {
      i = Build.VERSION.SDK_INT;
      if ((i >= 14) && (ViewConfiguration.get(this).hasPermanentMenuKey())) {
        requestWindowFeature(1);
      }
      if (i <= 10) {
        requestWindowFeature(1);
      }
    }
    setContentView(2130968578);
  }
  
  public void onMemoryLow()
  {
    listAppsFragment.goodMemory = false;
    System.out.println("LuckyPatcher (onMemoryLow): started!");
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    System.out.println("Lucky Patcher: on new intent activity.");
    listAppsFragment.patchAct = this;
    listAppsFragment.handler = new Handler();
  }
  
  public void onPause()
  {
    try
    {
      super.onPause();
      System.out.println("Lucky Patcher: activity pause.");
      listAppsFragment.patchAct = this;
      listAppsFragment.handler = new Handler();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onResume()
  {
    try
    {
      super.onResume();
      System.out.println("Lucky Patcher: activity resume.");
      listAppsFragment.patchAct = this;
      listAppsFragment.handler = new Handler();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    System.out.println("Lucky Patcher: start activity.");
    listAppsFragment.patchAct = this;
    listAppsFragment.handler = new Handler();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    System.out.println("onWindowFocusChanged");
    listAppsFragment.patchAct = this;
    listAppsFragment.handler = new Handler();
    if ((listAppsFragment.return_from_control_panel) && (paramBoolean))
    {
      listAppsFragment.createExpandMenu();
      listAppsFragment.return_from_control_panel = false;
      if (listAppsFragment.pli != null) {
        listAppsFragment.getConfig().edit().remove(listAppsFragment.pli.pkgName).commit();
      }
      if (listAppsFragment.plia != null) {
        listAppsFragment.plia.notifyDataSetChanged();
      }
      listAppsFragment.refresh = true;
      listAppsFragment.removeDialogLP(6);
      new Thread(new Runnable()
      {
        public void run()
        {
          int i = listAppsFragment.getConfig().getInt("Install_location", 3);
          if (i != 3)
          {
            if (!listAppsFragment.su) {
              break label112;
            }
            new Utils("").cmdRoot(new String[] { "pm setInstallLocation " + i, "skipOut" });
            new Utils("").cmdRoot(new String[] { "pm set-install-location " + i, "skipOut" });
          }
          label112:
          do
          {
            return;
            if (Build.VERSION.SDK_INT < 19) {
              Utils.cmd(new String[] { "pm setInstallLocation " + i, "skipOut" });
            }
          } while (Build.VERSION.SDK_INT >= 19);
          Utils.cmd(new String[] { "pm set-install-location " + i, "skipOut" });
        }
      }).start();
    }
    if (listAppsFragment.plia != null) {
      listAppsFragment.plia.notifyDataSetChanged();
    }
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)listAppsFragment.getInstance().getSystemService("activity")).getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.availMem / 1048576L;
    System.out.println("LuckyPatcher " + listAppsFragment.version + " (FreeMemory): " + l + " lowMemory:" + localMemoryInfo.lowMemory + " TrashOld:" + localMemoryInfo.threshold / 1048576L);
    if (((listAppsFragment.firstrun == null) || (listAppsFragment.firstrun.booleanValue())) && (listAppsFragment.plia != null) && (paramBoolean))
    {
      listAppsFragment.refresh = true;
      listAppsFragment.plia.refreshPkgs(true);
      listAppsFragment.firstrun = Boolean.valueOf(false);
    }
    if ((listAppsFragment.plia != null) && (paramBoolean) && (listAppsFragment.refresh)) {
      listAppsFragment.plia.refreshPkgs(false);
    }
  }
  
  public void patch_click(View paramView)
  {
    if (listAppsFragment.CurentSelect != 0)
    {
      Utils.kill(listAppsFragment.pli.pkgName);
      listAppsFragment.str = "";
      Utils.kill(listAppsFragment.plipack);
      listAppsFragment.str = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".nerorunpatch " + listAppsFragment.plipack + " " + "object" + listAppsFragment.CurentSelect });
      if (listAppsFragment.str.contains("Done"))
      {
        paramView = "Object N" + listAppsFragment.CurentSelect + "\n" + Utils.getText(2131165451);
        listAppsFragment.tvt.setText(Utils.getColoredText(paramView, "#ff00ff73", "bold"));
      }
    }
    else
    {
      return;
    }
    paramView = "Object N" + listAppsFragment.CurentSelect + "\n" + Utils.getText(2131165452);
    listAppsFragment.tvt.setText(Utils.getColoredText(paramView, "#ffff0055", "bold"));
  }
  
  public void restore_click(View paramView)
  {
    try
    {
      listAppsFragment.str = "";
      paramView = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".restore " + listAppsFragment.pli.pkgName });
      listAppsFragment.tvt.setText(Utils.getColoredText(paramView, "#ff00ff73", "bold"));
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void saveobject_click(View paramView)
  {
    try
    {
      paramView = new File(listAppsFragment.basepath + "/" + listAppsFragment.pli.pkgName + ".txt");
      if (paramView.exists()) {
        paramView.delete();
      }
      paramView = new FileWriter(paramView);
      paramView.write("[BEGIN]\ngetActivity() Custom Patch generated by Luckypatcher the manual mode! For Object N" + listAppsFragment.CurentSelect + "...\n[CLASSES]\n{\"object\":\"" + listAppsFragment.CurentSelect + "\"}\n[ODEX]\n[END]\nApplication patched on object N" + listAppsFragment.CurentSelect + ". Please test...\nIf all works well. Make a \"Dalvik-cache Fix Apply\".");
      paramView.close();
      paramView = "Object N" + listAppsFragment.CurentSelect + " " + Utils.getText(2131165651);
      listAppsFragment.tvt.setText(Utils.getColoredText(paramView, "#ff00ff73", "bold"));
      return;
    }
    catch (IOException paramView)
    {
      paramView.printStackTrace();
      Toast.makeText(this, "Error while saving file", 1).show();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      Toast.makeText(this, "Error while saving file", 1).show();
    }
  }
  
  public void show_file_explorer(String paramString)
  {
    try
    {
      listAppsFragment.plia.onGroupCollapsedAll();
      listAppsFragment.pli = null;
      localLinearLayout = (LinearLayout)View.inflate(this, 2130968614, null);
      Dialog localDialog = new AlertDlg(this, true).setView(localLinearLayout).create();
      localDialog.setCancelable(false);
      localDialog.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          System.out.println(paramAnonymousKeyEvent);
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1)) {
            try
            {
              if (((listAppsFragment.ItemFile)patchActivity.frag.filebrowser.getAdapter().getItem(1)).file.equals("../"))
              {
                patchActivity.frag.getDir(((listAppsFragment.ItemFile)patchActivity.frag.filebrowser.getAdapter().getItem(1)).path, patchActivity.frag.filebrowser, false);
                return true;
              }
              paramAnonymousDialogInterface.dismiss();
              return true;
            }
            catch (IndexOutOfBoundsException paramAnonymousKeyEvent)
            {
              paramAnonymousDialogInterface.dismiss();
              return true;
            }
            catch (Exception paramAnonymousKeyEvent)
            {
              paramAnonymousDialogInterface.dismiss();
            }
          }
          return true;
        }
      });
      localDialog.show();
      frag.myPath = ((TextView)localDialog.findViewById(2131558469));
      frag.root = paramString;
      ((ListView)localLinearLayout.findViewById(2131558472)).setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousView = (listAppsFragment.ItemFile)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          File localFile = new File(paramAnonymousView.full);
          if (localFile.isDirectory()) {
            if ((localFile.canRead()) && (localFile.listFiles() != null))
            {
              patchActivity.frag.filebrowser = ((ListView)paramAnonymousAdapterView);
              patchActivity.frag.getDir(new File(paramAnonymousView.full).getPath(), (ListView)paramAnonymousAdapterView, false);
            }
          }
          for (;;)
          {
            return;
            Utils.showDialog(new AlertDlg(patchActivity.frag.getContext()).setIcon(17301659).setTitle("[" + localFile.getName() + "] folder can't be read!").setPositiveButton("OK", null).create());
            return;
            patchActivity.frag.current = paramAnonymousView;
            listAppsFragment.rebuldApk = patchActivity.frag.current.full;
            paramAnonymousAdapterView = new ArrayList();
            if ((paramAnonymousView.file.equals("core.jar")) || (paramAnonymousView.file.equals("core.odex")) || (paramAnonymousView.file.equals("core-libart.odex")) || (paramAnonymousView.file.equals("services.jar")) || (paramAnonymousView.file.equals("services.odex")) || (paramAnonymousView.file.equals("core-libart.jar")) || (paramAnonymousView.file.equals("boot.oat")))
            {
              if (!paramAnonymousView.file.endsWith(".jar")) {
                break label489;
              }
              if (Utils.classes_test(new File(paramAnonymousView.full))) {
                paramAnonymousAdapterView.add(Integer.valueOf(2131165768));
              }
            }
            else
            {
              label299:
              if (paramAnonymousView.file.endsWith(".apk"))
              {
                System.out.println("integrate dalvik code...");
                if (!listAppsFragment.su) {}
              }
            }
            try
            {
              if (Utils.getPkgInfo(Utils.getApkPackageInfo(paramAnonymousView.full).packageName, 0) != null) {
                paramAnonymousAdapterView.add(Integer.valueOf(2131165767));
              }
              paramAnonymousAdapterView.add(Integer.valueOf(2131165275));
              paramAnonymousAdapterView.add(Integer.valueOf(2131165280));
              if (!listAppsFragment.su) {
                paramAnonymousAdapterView.add(Integer.valueOf(2131165290));
              }
              if (listAppsFragment.su) {
                paramAnonymousAdapterView.add(Integer.valueOf(2131165276));
              }
              paramAnonymousAdapterView.add(Integer.valueOf(2131165408));
              paramAnonymousAdapterView.add(Integer.valueOf(2131165672));
              if (paramAnonymousAdapterView.size() == 0) {
                continue;
              }
              listAppsFragment.menu_adapt = new ArrayAdapter(patchActivity.frag.getContext(), 2130968605, paramAnonymousAdapterView)
              {
                public View getView(int paramAnonymous2Int, View paramAnonymous2View, ViewGroup paramAnonymous2ViewGroup)
                {
                  paramAnonymous2View = super.getView(paramAnonymous2Int, paramAnonymous2View, paramAnonymous2ViewGroup);
                  paramAnonymous2ViewGroup = (TextView)paramAnonymous2View.findViewById(2131558462);
                  paramAnonymous2ViewGroup.setTextAppearance(getContext(), listAppsFragment.getSizeText());
                  paramAnonymous2ViewGroup.setCompoundDrawablePadding((int)(5.0F * listAppsFragment.getRes().getDisplayMetrics().density + 0.5F));
                  paramAnonymous2ViewGroup.setTextColor(-1);
                  paramAnonymous2ViewGroup.setText(Utils.getText(((Integer)getItem(paramAnonymous2Int)).intValue()));
                  paramAnonymous2ViewGroup.setTypeface(null, 1);
                  return paramAnonymous2View;
                }
              };
              paramAnonymousAdapterView = patchActivity.frag;
              listAppsFragment.removeDialogLP(7);
              paramAnonymousAdapterView = patchActivity.frag;
              listAppsFragment.showDialogLP(7);
              return;
              patchActivity.frag.showMessage(Utils.getText(2131165748), Utils.getText(2131165774));
              break label299;
              label489:
              paramAnonymousAdapterView.add(Integer.valueOf(2131165768));
            }
            catch (Exception paramAnonymousView)
            {
              for (;;)
              {
                paramAnonymousView.printStackTrace();
              }
            }
          }
        }
      });
      frag.filebrowser = ((ListView)localLinearLayout.findViewById(2131558472));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          LinearLayout localLinearLayout;
          frag.getDir(frag.root, (ListView)localLinearLayout.findViewById(2131558472), false);
          return;
        }
        catch (Exception paramString)
        {
          try
          {
            frag.root = new File(listAppsFragment.basepath).getParent();
            frag.getDir(frag.root, (ListView)localException.findViewById(2131558472), false);
            return;
          }
          catch (Exception paramString)
          {
            frag.root = listAppsFragment.basepath;
            frag.getDir(frag.root, (ListView)localException.findViewById(2131558472), false);
          }
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
  }
  
  public void toolbar_backups_click(View paramView)
  {
    new File(listAppsFragment.basepath + "/Backup/").mkdirs();
    paramView = frag;
    listAppsFragment.showDialogLP(11);
    listAppsFragment.progress2.setCancelable(false);
    listAppsFragment.progress2.setMessage(Utils.getText(2131165747));
    paramView = new Thread(new Runnable()
    {
      public void run()
      {
        ArrayList localArrayList = new ArrayList();
        String[] arrayOfString = new File(listAppsFragment.basepath + "/Backup").list();
        int j;
        int i;
        if ((arrayOfString != null) && (arrayOfString.length != 0))
        {
          j = arrayOfString.length;
          i = 0;
        }
        for (;;)
        {
          String str;
          if (i < j) {
            str = arrayOfString[i];
          }
          try
          {
            localArrayList.add(new FileApkListItem(listAppsFragment.getInstance(), new File(listAppsFragment.basepath + "/Backup/" + str), true));
            i += 1;
            continue;
            if (localArrayList.size() != 0)
            {
              listAppsFragment.adapt = new ArrayAdapter(patchActivity.this, 2130968585, localArrayList)
              {
                ArrayAdapter<FileApkListItem> mAdapter = this;
                
                public View getView(int paramAnonymous2Int, View paramAnonymous2View, ViewGroup paramAnonymous2ViewGroup)
                {
                  Object localObject = paramAnonymous2View;
                  FileApkListItem localFileApkListItem = (FileApkListItem)getItem(paramAnonymous2Int);
                  paramAnonymous2View = (View)localObject;
                  if (localObject == null) {
                    paramAnonymous2View = ((LayoutInflater)listAppsFragment.getInstance().getSystemService("layout_inflater")).inflate(2130968585, paramAnonymous2ViewGroup, false);
                  }
                  paramAnonymous2ViewGroup = (TextView)paramAnonymous2View.findViewById(2131558462);
                  localObject = (ImageView)paramAnonymous2View.findViewById(2131558461);
                  Button localButton = (Button)paramAnonymous2View.findViewById(2131558463);
                  localButton.setTag(localFileApkListItem);
                  localButton.setOnClickListener(new View.OnClickListener()
                  {
                    public void onClick(final View paramAnonymous3View)
                    {
                      paramAnonymous3View = (FileApkListItem)paramAnonymous3View.getTag();
                      DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
                      {
                        public void onClick(DialogInterface paramAnonymous4DialogInterface, int paramAnonymous4Int)
                        {
                          switch (paramAnonymous4Int)
                          {
                          default: 
                            return;
                          }
                          paramAnonymous3View.backupfile.delete();
                          patchActivity.25.1.this.mAdapter.remove(paramAnonymous3View);
                          patchActivity.25.1.this.mAdapter.notifyDataSetChanged();
                        }
                      };
                      Utils.showDialog(new AlertDlg(listAppsFragment.frag.getContext()).setTitle(Utils.getText(2131165748)).setMessage(Utils.getText(2131165216) + " " + paramAnonymous3View.name + "?").setPositiveButton(Utils.getText(2131165187), local1).setNegativeButton(Utils.getText(2131165563), local1).create());
                    }
                  });
                  ((ImageView)localObject).setImageDrawable(null);
                  paramAnonymous2ViewGroup.setTextAppearance(getContext(), listAppsFragment.getSizeText());
                  paramAnonymous2ViewGroup.setCompoundDrawablePadding((int)(5.0F * listAppsFragment.getRes().getDisplayMetrics().density + 0.5F));
                  paramAnonymous2ViewGroup.setTextColor(-1);
                  paramAnonymous2ViewGroup.setText(Utils.getColoredText(localFileApkListItem.name, "#A1C2F3", "bold"));
                  paramAnonymous2ViewGroup.append(Utils.getColoredText("\n" + Utils.getText(2131165644) + ": " + localFileApkListItem.versionName + " " + Utils.getText(2131165640) + ": " + localFileApkListItem.versionCode, "#a0a0a0", ""));
                  ((ImageView)localObject).setImageDrawable(localFileApkListItem.icon);
                  return paramAnonymous2View;
                }
              };
              patchActivity.this.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  listAppsFragment.adapt.sort(new patchActivity.byNameApkFile(patchActivity.this));
                  listAppsFragment locallistAppsFragment = patchActivity.frag;
                  listAppsFragment.removeDialogLP(28);
                  locallistAppsFragment = patchActivity.frag;
                  listAppsFragment.showDialogLP(28);
                  locallistAppsFragment = patchActivity.frag;
                  listAppsFragment.removeDialogLP(11);
                }
              });
              return;
            }
            patchActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                patchActivity.frag.showMessage(Utils.getText(2131165748), Utils.getText(2131165218) + " " + listAppsFragment.basepath + "/Backup");
                listAppsFragment locallistAppsFragment = patchActivity.frag;
                listAppsFragment.removeDialogLP(11);
              }
            });
            return;
            patchActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                patchActivity.frag.showMessage(Utils.getText(2131165748), Utils.getText(2131165218) + " " + listAppsFragment.basepath + "/Backup");
                listAppsFragment locallistAppsFragment = patchActivity.frag;
                listAppsFragment.removeDialogLP(11);
              }
            });
            return;
          }
          catch (Exception localException)
          {
            for (;;) {}
          }
        }
      }
    });
    paramView.setPriority(10);
    paramView.start();
  }
  
  public void toolbar_market_install_click(View paramView)
  {
    paramView = frag;
    listAppsFragment.removeDialogLP(30);
    paramView = frag;
    listAppsFragment.showDialogLP(30);
  }
  
  public void toolbar_menu_click(View paramView)
  {
    frag.getActivity().openOptionsMenu();
  }
  
  public void toolbar_rebuild_click(View paramView)
  {
    try
    {
      listAppsFragment.plia.onGroupCollapsedAll();
      listAppsFragment.pli = null;
      localLinearLayout = (LinearLayout)View.inflate(this, 2130968614, null);
      paramView = new AlertDlg(this, true).setView(localLinearLayout).create();
      paramView.setCancelable(false);
      paramView.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          System.out.println(paramAnonymousKeyEvent);
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1)) {
            try
            {
              listAppsFragment.rebuldApk = "";
              if (((listAppsFragment.ItemFile)patchActivity.frag.filebrowser.getAdapter().getItem(1)).file.equals("../"))
              {
                patchActivity.frag.getDir(((listAppsFragment.ItemFile)patchActivity.frag.filebrowser.getAdapter().getItem(1)).path, patchActivity.frag.filebrowser, true);
                return true;
              }
              paramAnonymousDialogInterface.dismiss();
              return true;
            }
            catch (IndexOutOfBoundsException paramAnonymousKeyEvent)
            {
              paramAnonymousDialogInterface.dismiss();
              return true;
            }
            catch (Exception paramAnonymousKeyEvent)
            {
              paramAnonymousDialogInterface.dismiss();
            }
          }
          return true;
        }
      });
      paramView.show();
      frag.myPath = ((TextView)paramView.findViewById(2131558469));
      paramView = new File(listAppsFragment.extStorageDirectory).getParent();
      View localView = paramView;
      localObject = paramView;
      for (;;)
      {
        int i;
        try
        {
          if (new File(new File(paramView).getParent()).getParent() != null)
          {
            localView = paramView;
            paramView = new File(paramView).getParent();
            localView = paramView;
            System.out.println("Parent directory:" + paramView);
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          localObject = localView;
          j = 0;
          paramView = new File((String)localObject).listFiles();
          int k = paramView.length;
          i = 0;
          if (i >= k) {
            break label246;
          }
        }
        localView = paramView[i];
        System.out.println(localView.getAbsolutePath());
        if (localView.canRead()) {
          j = 1;
        }
        i += 1;
      }
    }
    catch (Exception paramView)
    {
      LinearLayout localLinearLayout;
      Object localObject;
      int j;
      for (;;)
      {
        paramView.printStackTrace();
      }
      label246:
      if (j == 0)
      {
        localObject = listAppsFragment.extStorageDirectory;
        System.out.println("t " + (String)localObject);
      }
      frag.root = ((String)localObject);
      ((ListView)localLinearLayout.findViewById(2131558472)).setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousView = (listAppsFragment.ItemFile)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          File localFile = new File(paramAnonymousView.full);
          if (localFile.isDirectory()) {
            if ((localFile.canRead()) && (localFile.listFiles() != null))
            {
              patchActivity.frag.filebrowser = ((ListView)paramAnonymousAdapterView);
              patchActivity.frag.getDir(new File(paramAnonymousView.full).getPath(), (ListView)paramAnonymousAdapterView, true);
            }
          }
          for (;;)
          {
            return;
            Utils.showDialog(new AlertDlg(patchActivity.frag.getContext()).setIcon(17301659).setTitle("[" + localFile.getName() + "] folder can't be read!").setPositiveButton("OK", null).create());
            return;
            patchActivity.frag.current = paramAnonymousView;
            listAppsFragment.rebuldApk = patchActivity.frag.current.full;
            paramAnonymousAdapterView = new ArrayList();
            if ((paramAnonymousView.file.equals("core.jar")) || (paramAnonymousView.file.equals("core.odex")) || (paramAnonymousView.file.equals("core-libart.odex")) || (paramAnonymousView.file.equals("services.jar")) || (paramAnonymousView.file.equals("services.odex")) || (paramAnonymousView.file.equals("core-libart.jar")) || (paramAnonymousView.file.equals("boot.oat")))
            {
              if (!paramAnonymousView.file.endsWith(".jar")) {
                break label489;
              }
              if (Utils.classes_test(new File(paramAnonymousView.full))) {
                paramAnonymousAdapterView.add(Integer.valueOf(2131165768));
              }
            }
            else
            {
              label299:
              if (paramAnonymousView.file.endsWith(".apk"))
              {
                System.out.println("integrate dalvik code...");
                if (!listAppsFragment.su) {}
              }
            }
            try
            {
              if (Utils.getPkgInfo(Utils.getApkPackageInfo(paramAnonymousView.full).packageName, 0) != null) {
                paramAnonymousAdapterView.add(Integer.valueOf(2131165767));
              }
              paramAnonymousAdapterView.add(Integer.valueOf(2131165275));
              paramAnonymousAdapterView.add(Integer.valueOf(2131165280));
              if (!listAppsFragment.su) {
                paramAnonymousAdapterView.add(Integer.valueOf(2131165290));
              }
              if (listAppsFragment.su) {
                paramAnonymousAdapterView.add(Integer.valueOf(2131165276));
              }
              paramAnonymousAdapterView.add(Integer.valueOf(2131165408));
              paramAnonymousAdapterView.add(Integer.valueOf(2131165672));
              if (paramAnonymousAdapterView.size() == 0) {
                continue;
              }
              listAppsFragment.menu_adapt = new ArrayAdapter(patchActivity.frag.getContext(), 2130968605, paramAnonymousAdapterView)
              {
                public View getView(int paramAnonymous2Int, View paramAnonymous2View, ViewGroup paramAnonymous2ViewGroup)
                {
                  paramAnonymous2View = super.getView(paramAnonymous2Int, paramAnonymous2View, paramAnonymous2ViewGroup);
                  paramAnonymous2ViewGroup = (TextView)paramAnonymous2View.findViewById(2131558462);
                  paramAnonymous2ViewGroup.setTextAppearance(getContext(), listAppsFragment.getSizeText());
                  paramAnonymous2ViewGroup.setCompoundDrawablePadding((int)(5.0F * listAppsFragment.getRes().getDisplayMetrics().density + 0.5F));
                  paramAnonymous2ViewGroup.setTextColor(-1);
                  paramAnonymous2ViewGroup.setText(Utils.getText(((Integer)getItem(paramAnonymous2Int)).intValue()));
                  paramAnonymous2ViewGroup.setTypeface(null, 1);
                  return paramAnonymous2View;
                }
              };
              paramAnonymousAdapterView = patchActivity.frag;
              listAppsFragment.removeDialogLP(7);
              paramAnonymousAdapterView = patchActivity.frag;
              listAppsFragment.showDialogLP(7);
              return;
              patchActivity.frag.showMessage(Utils.getText(2131165748), Utils.getText(2131165774));
              break label299;
              label489:
              paramAnonymousAdapterView.add(Integer.valueOf(2131165768));
            }
            catch (Exception paramAnonymousView)
            {
              for (;;)
              {
                paramAnonymousView.printStackTrace();
              }
            }
          }
        }
      });
      frag.filebrowser = ((ListView)localLinearLayout.findViewById(2131558472));
      try
      {
        frag.getDir(frag.root, (ListView)localLinearLayout.findViewById(2131558472), true);
        return;
      }
      catch (Exception paramView)
      {
        try
        {
          frag.root = new File(listAppsFragment.basepath).getParent();
          frag.getDir(frag.root, (ListView)localLinearLayout.findViewById(2131558472), true);
          return;
        }
        catch (Exception paramView)
        {
          frag.root = listAppsFragment.basepath;
          frag.getDir(frag.root, (ListView)localLinearLayout.findViewById(2131558472), true);
        }
      }
    }
  }
  
  public void toolbar_refresh_click(View paramView)
  {
    try
    {
      paramView = getSupportFragmentManager().beginTransaction();
      listAppsFragment locallistAppsFragment = frag;
      if (listAppsFragment.filter == null)
      {
        locallistAppsFragment = frag;
        listAppsFragment.filter = new FilterFragment();
        locallistAppsFragment = frag;
        paramView.add(2131558615, listAppsFragment.filter);
        paramView.commit();
        return;
      }
      locallistAppsFragment = frag;
      paramView.remove(listAppsFragment.filter);
      paramView.commit();
      paramView = frag;
      listAppsFragment.filter.onDestroy();
      paramView = frag;
      listAppsFragment.filter = null;
      paramView = frag;
      listAppsFragment.plia.getFilter().filter("");
      paramView = frag;
      listAppsFragment.plia.notifyDataSetChanged();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void toolbar_settings_click()
  {
    if (listAppsFragment.menu_open) {
      listAppsFragment.frag.hideMenu();
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new MenuItem(2131165211, new ArrayList(), true));
      localArrayList.add(new MenuItem(2131165743, new ArrayList(), 1, true));
      localArrayList.add(new MenuItem(2131165718, new ArrayList() {}, 2, true));
      localArrayList.add(new MenuItem(2131165590, new ArrayList() {}, 2, true));
      localArrayList.add(new MenuItem(2131165677, new ArrayList() {}, 2, true));
      localArrayList.add(new MenuItem(2131165456, 2131165471, new ArrayList() {}, 2, true));
      localArrayList.add(new MenuItem(2131165591, new ArrayList(), 1, true));
      localArrayList.add(new MenuItem(2131165509, new ArrayList(), 2, true));
      localArrayList.add(new MenuItem(2131165666, 2131165667, new ArrayList() {}, 2, true));
      localArrayList.add(new MenuItem(2131165411, 2131165412, new ArrayList(), 2, true));
      localArrayList.add(new MenuItem(2131165404, 2131165405, new ArrayList(), 2, true));
      localArrayList.add(new MenuItem(2131165663, 2131165664, new ArrayList(), 3, true, "confirm_exit", true, new Runnable()
      {
        public void run()
        {
          if (listAppsFragment.getConfig().getBoolean("confirm_exit", true)) {
            listAppsFragment.getConfig().edit().putBoolean("confirm_exit", false).commit();
          }
          for (;;)
          {
            listAppsFragment.menu_adapter.notifyDataSetChanged();
            return;
            listAppsFragment.getConfig().edit().putBoolean("confirm_exit", true).commit();
          }
        }
      }));
      localArrayList.add(new MenuItem(2131165453, 2131165454, new ArrayList(), 3, true, "fast_start", false, new Runnable()
      {
        public void run()
        {
          if (listAppsFragment.getConfig().getBoolean("fast_start", true)) {
            listAppsFragment.getConfig().edit().putBoolean("fast_start", false).commit();
          }
          for (;;)
          {
            listAppsFragment.menu_adapter.notifyDataSetChanged();
            listAppsFragment.runResume = true;
            return;
            listAppsFragment.getConfig().edit().putBoolean("fast_start", true).commit();
          }
        }
      }));
      localArrayList.add(new MenuItem(2131165565, 2131165566, new ArrayList(), 3, true, "no_icon", false, new Runnable()
      {
        public void run()
        {
          if (listAppsFragment.getConfig().getBoolean("no_icon", false)) {
            listAppsFragment.getConfig().edit().putBoolean("no_icon", false).commit();
          }
          for (;;)
          {
            listAppsFragment.menu_adapter.notifyDataSetChanged();
            listAppsFragment.runResume = true;
            return;
            listAppsFragment.getConfig().edit().putBoolean("no_icon", true).commit();
          }
        }
      }));
      localArrayList.add(new MenuItem(2131165200, 2131165203, new ArrayList() {}, 2, true));
      localArrayList.add(new MenuItem(2131165249, 2131165250, new ArrayList() {}, 2, true));
      localArrayList.add(new MenuItem(2131165486, 2131165487, new ArrayList(), 3, true, "hide_notify", false, new Runnable()
      {
        public void run()
        {
          if (listAppsFragment.getConfig().getBoolean("hide_notify", false)) {
            listAppsFragment.getConfig().edit().putBoolean("hide_notify", false).commit();
          }
          for (;;)
          {
            listAppsFragment.menu_adapter.notifyDataSetChanged();
            listAppsFragment.runResume = true;
            return;
            listAppsFragment.getConfig().edit().putBoolean("hide_notify", true).commit();
          }
        }
      }));
      localArrayList.add(new MenuItem(2131165488, 2131165489, new ArrayList(), 3, true, "hide_title", false, new Runnable()
      {
        public void run()
        {
          if (listAppsFragment.getConfig().getBoolean("hide_title", false)) {
            listAppsFragment.getConfig().edit().putBoolean("hide_title", false).commit();
          }
          for (;;)
          {
            listAppsFragment.menu_adapter.notifyDataSetChanged();
            listAppsFragment.runResume = true;
            return;
            listAppsFragment.getConfig().edit().putBoolean("hide_title", true).commit();
          }
        }
      }));
      localArrayList.add(new MenuItem(2131165415, 2131165416, new ArrayList(), 3, true, "disable_autoupdate", false, new Runnable()
      {
        public void run()
        {
          if (listAppsFragment.getConfig().getBoolean("disable_autoupdate", false)) {
            listAppsFragment.getConfig().edit().putBoolean("disable_autoupdate", false).commit();
          }
          for (;;)
          {
            listAppsFragment.menu_adapter.notifyDataSetChanged();
            listAppsFragment.runResume = true;
            return;
            listAppsFragment.getConfig().edit().putBoolean("disable_autoupdate", true).commit();
          }
        }
      }));
      localArrayList.add(new MenuItem(2131165738, 2131165739, new ArrayList(), 3, true, "vibration", false, new Runnable()
      {
        public void run()
        {
          if (listAppsFragment.getConfig().getBoolean("vibration", false)) {
            listAppsFragment.getConfig().edit().putBoolean("vibration", false).commit();
          }
          for (;;)
          {
            listAppsFragment.menu_adapter.notifyDataSetChanged();
            listAppsFragment.runResume = true;
            return;
            listAppsFragment.getConfig().edit().putBoolean("vibration", true).commit();
          }
        }
      }));
      localArrayList.add(new MenuItem(2131165483, new ArrayList(), 2, true));
      localArrayList.add(new MenuItem(2131165734, new ArrayList(), 2, true));
      localArrayList.add(new MenuItem(2131165657, new ArrayList(), 2, true));
      localArrayList.add(new MenuItem(2131165190, new ArrayList(), 2, true));
      try
      {
        if (listAppsFragment.menu_adapter != null)
        {
          listAppsFragment.menu_adapter.add(localArrayList);
          listAppsFragment.frag.showMenu();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void toolbar_switchers_click(View paramView)
  {
    paramView = new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject1 = null;
        try
        {
          localObject2 = listAppsFragment.getPkgMng().getPackageInfo("com.android.vending", 0);
          localObject1 = localObject2;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            Object localObject2;
            localNameNotFoundException.printStackTrace();
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localIllegalArgumentException.printStackTrace();
          }
          patchActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              patchActivity.frag.showMessage(Utils.getText(2131165748), Utils.getText(2131165732));
            }
          });
        }
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(Integer.valueOf(2131165511));
        if ((listAppsFragment.su) && (localObject1 != null)) {
          ((ArrayList)localObject2).add(Integer.valueOf(2131165419));
        }
        ((ArrayList)localObject2).add(Integer.valueOf(2131165224));
        ((ArrayList)localObject2).add(Integer.valueOf(2131165759));
        if ((listAppsFragment.su) && (localObject1 != null))
        {
          ((ArrayList)localObject2).add(Integer.valueOf(2131165417));
          ((ArrayList)localObject2).add(Integer.valueOf(2131165787));
        }
        ((ArrayList)localObject2).add(Integer.valueOf(2131165705));
        ((ArrayList)localObject2).add(Integer.valueOf(2131165707));
        if (listAppsFragment.su)
        {
          ((ArrayList)localObject2).add(Integer.valueOf(2131165709));
          ((ArrayList)localObject2).add(Integer.valueOf(2131165713));
          ((ArrayList)localObject2).add(Integer.valueOf(2131165711));
        }
        if (((ArrayList)localObject2).size() != 0)
        {
          listAppsFragment.menu_adapt = new ArrayAdapter(patchActivity.this, 2130968634, (List)localObject2)
          {
            ArrayAdapter<Integer> mAdapter = this;
            
            public View getView(int paramAnonymous2Int, View paramAnonymous2View, ViewGroup paramAnonymous2ViewGroup)
            {
              Object localObject = paramAnonymous2View;
              Integer localInteger = (Integer)getItem(paramAnonymous2Int);
              paramAnonymous2View = (View)localObject;
              if (localObject == null) {
                paramAnonymous2View = ((LayoutInflater)listAppsFragment.getInstance().getSystemService("layout_inflater")).inflate(2130968634, paramAnonymous2ViewGroup, false);
              }
              TextView localTextView = (TextView)paramAnonymous2View.findViewById(2131558462);
              ImageView localImageView = (ImageView)paramAnonymous2View.findViewById(2131558461);
              localImageView.setImageDrawable(null);
              localTextView.setTextAppearance(getContext(), listAppsFragment.getSizeText());
              localTextView.setCompoundDrawablePadding((int)(5.0F * listAppsFragment.getRes().getDisplayMetrics().density + 0.5F));
              localTextView.setTextColor(-1);
              switch (localInteger.intValue())
              {
              default: 
                return paramAnonymous2View;
              case 2131165787: 
                localObject = new File(Utils.getPlaceForOdex(Utils.getPkgInfo("com.android.vending", 0).applicationInfo.sourceDir, true));
                paramAnonymous2ViewGroup = Utils.getFileDalvikCache(Utils.getPkgInfo("com.android.vending", 0).applicationInfo.sourceDir);
                long l2 = 0L;
                try
                {
                  if (((File)localObject).exists()) {}
                  for (l1 = ((File)localObject).length(); (l1 > 1048576L) || (l1 == 0L); l1 = paramAnonymous2ViewGroup.length())
                  {
                    localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                    localTextView.setText(Utils.getColoredText(Utils.getText(2131165787), "#FF0000", "bold"));
                    localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165788), "#AAAAAA", ""));
                    return paramAnonymous2View;
                  }
                }
                catch (Exception localException1)
                {
                  for (;;)
                  {
                    long l1 = l2;
                    try
                    {
                      if (!paramAnonymous2ViewGroup.exists()) {
                        continue;
                      }
                      l1 = paramAnonymous2ViewGroup.length();
                    }
                    catch (Exception paramAnonymous2ViewGroup)
                    {
                      paramAnonymous2ViewGroup.printStackTrace();
                      l1 = l2;
                    }
                    continue;
                    localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                    localTextView.setText(Utils.getColoredText(Utils.getText(2131165787), "#00FF00", "bold"));
                  }
                }
              case 2131165224: 
                if ((listAppsFragment.getInstance().getPackageManager().getComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), MarketBillingService.class)) == 2) || (listAppsFragment.getInstance().getPackageManager().getComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingService.class)) == 2))
                {
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                  localTextView.setText(Utils.getColoredText(Utils.getText(2131165224), "#FF0000", "bold"));
                }
                for (;;)
                {
                  localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165225), "#AAAAAA", ""));
                  return paramAnonymous2View;
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                  localTextView.setText(Utils.getColoredText(Utils.getText(2131165224), "#00FF00", "bold"));
                }
              case 2131165759: 
                if (listAppsFragment.getInstance().getPackageManager().getComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), InAppBillingFService.class)) == 2)
                {
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                  localTextView.setText(Utils.getColoredText(Utils.getText(2131165759), "#FF0000", "bold"));
                }
                for (;;)
                {
                  localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165760), "#AAAAAA", ""));
                  return paramAnonymous2View;
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                  localTextView.setText(Utils.getColoredText(Utils.getText(2131165759), "#00FF00", "bold"));
                }
              case 2131165417: 
                paramAnonymous2ViewGroup = null;
                try
                {
                  PackageInfo localPackageInfo1 = listAppsFragment.getPkgMng().getPackageInfo("com.android.vending", 4);
                  paramAnonymous2ViewGroup = localPackageInfo1;
                }
                catch (PackageManager.NameNotFoundException localNameNotFoundException1)
                {
                  for (;;)
                  {
                    localNameNotFoundException1.printStackTrace();
                  }
                  localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165418), "#AAAAAA", ""));
                  return paramAnonymous2View;
                }
                if ((paramAnonymous2ViewGroup != null) && (paramAnonymous2ViewGroup.services != null) && (paramAnonymous2ViewGroup.services.length != 0))
                {
                  paramAnonymous2Int = 0;
                  while (paramAnonymous2Int < paramAnonymous2ViewGroup.services.length)
                  {
                    try
                    {
                      if (((paramAnonymous2ViewGroup.services[paramAnonymous2Int].name.endsWith("InAppBillingService")) || (paramAnonymous2ViewGroup.services[paramAnonymous2Int].name.endsWith("MarketBillingService"))) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", paramAnonymous2ViewGroup.services[paramAnonymous2Int].name)) != 1))
                      {
                        localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                        localTextView.setText(Utils.getColoredText(Utils.getText(2131165417), "#FF0000", "bold"));
                      }
                      if (((paramAnonymous2ViewGroup.services[paramAnonymous2Int].name.endsWith("InAppBillingService")) || (paramAnonymous2ViewGroup.services[paramAnonymous2Int].name.endsWith("MarketBillingService"))) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", paramAnonymous2ViewGroup.services[paramAnonymous2Int].name)) == 1))
                      {
                        localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                        localTextView.setText(Utils.getColoredText(Utils.getText(2131165417), "#00FF00", "bold"));
                      }
                    }
                    catch (Exception localException2)
                    {
                      for (;;)
                      {
                        localException2.printStackTrace();
                      }
                    }
                    paramAnonymous2Int += 1;
                  }
                }
              case 2131165511: 
                if (listAppsFragment.getInstance().getPackageManager().getComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), LicensingService.class)) == 2)
                {
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                  localTextView.setText(Utils.getColoredText(Utils.getText(2131165511), "#FF0000", "bold"));
                }
                for (;;)
                {
                  localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165512), "#AAAAAA", ""));
                  return paramAnonymous2View;
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                  localTextView.setText(Utils.getColoredText(Utils.getText(2131165511), "#00FF00", "bold"));
                }
              case 2131165419: 
                paramAnonymous2ViewGroup = null;
                try
                {
                  PackageInfo localPackageInfo2 = listAppsFragment.getPkgMng().getPackageInfo("com.android.vending", 4);
                  paramAnonymous2ViewGroup = localPackageInfo2;
                }
                catch (PackageManager.NameNotFoundException localNameNotFoundException2)
                {
                  for (;;)
                  {
                    localNameNotFoundException2.printStackTrace();
                  }
                  localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165420), "#AAAAAA", ""));
                  return paramAnonymous2View;
                }
                if ((paramAnonymous2ViewGroup != null) && (paramAnonymous2ViewGroup.services != null) && (paramAnonymous2ViewGroup.services.length != 0))
                {
                  paramAnonymous2Int = 0;
                  while (paramAnonymous2Int < paramAnonymous2ViewGroup.services.length)
                  {
                    try
                    {
                      if ((paramAnonymous2ViewGroup.services[paramAnonymous2Int].name.endsWith("LicensingService")) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", paramAnonymous2ViewGroup.services[paramAnonymous2Int].name)) != 1))
                      {
                        localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                        localTextView.setText(Utils.getColoredText(Utils.getText(2131165419), "#FF0000", "bold"));
                      }
                      if ((paramAnonymous2ViewGroup.services[paramAnonymous2Int].name.endsWith("LicensingService")) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", paramAnonymous2ViewGroup.services[paramAnonymous2Int].name)) == 1))
                      {
                        localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                        localTextView.setText(Utils.getColoredText(Utils.getText(2131165419), "#00FF00", "bold"));
                      }
                    }
                    catch (Exception localException3)
                    {
                      for (;;)
                      {
                        localException3.printStackTrace();
                      }
                    }
                    paramAnonymous2Int += 1;
                  }
                }
              case 2131165705: 
                if (listAppsFragment.getConfig().getBoolean("switch_auto_backup_apk", false))
                {
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                  localTextView.setText(Utils.getColoredText(Utils.getText(localInteger.intValue()), "#00FF00", "bold"));
                }
                for (;;)
                {
                  localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165706), "#AAAAAA", ""));
                  return paramAnonymous2View;
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                  localTextView.setText(Utils.getColoredText(Utils.getText(localInteger.intValue()), "#FF0000", "bold"));
                }
              case 2131165707: 
                if (listAppsFragment.getConfig().getBoolean("switch_auto_backup_apk_only_gp", false))
                {
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                  localTextView.setText(Utils.getColoredText(Utils.getText(localInteger.intValue()), "#00FF00", "bold"));
                }
                for (;;)
                {
                  localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165708), "#AAAAAA", ""));
                  return paramAnonymous2View;
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                  localTextView.setText(Utils.getColoredText(Utils.getText(localInteger.intValue()), "#FF0000", "bold"));
                }
              case 2131165709: 
                if (listAppsFragment.getConfig().getBoolean("switch_auto_integrate_update", false))
                {
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                  localTextView.setText(Utils.getColoredText(Utils.getText(localInteger.intValue()), "#00FF00", "bold"));
                }
                for (;;)
                {
                  localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165710), "#AAAAAA", ""));
                  return paramAnonymous2View;
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                  localTextView.setText(Utils.getColoredText(Utils.getText(localInteger.intValue()), "#FF0000", "bold"));
                }
              case 2131165713: 
                if (listAppsFragment.getConfig().getBoolean("switch_auto_move_to_sd", false))
                {
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                  localTextView.setText(Utils.getColoredText(Utils.getText(localInteger.intValue()), "#00FF00", "bold"));
                }
                for (;;)
                {
                  localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165714), "#AAAAAA", ""));
                  return paramAnonymous2View;
                  localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                  localTextView.setText(Utils.getColoredText(Utils.getText(localInteger.intValue()), "#FF0000", "bold"));
                }
              }
              if (listAppsFragment.getConfig().getBoolean("switch_auto_move_to_internal", false))
              {
                localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903054));
                localTextView.setText(Utils.getColoredText(Utils.getText(localInteger.intValue()), "#00FF00", "bold"));
              }
              for (;;)
              {
                localTextView.append("\n" + Utils.getColoredText(Utils.getText(2131165712), "#AAAAAA", ""));
                return paramAnonymous2View;
                localImageView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130903053));
                localTextView.setText(Utils.getColoredText(Utils.getText(localInteger.intValue()), "#FF0000", "bold"));
              }
            }
          };
          patchActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              listAppsFragment locallistAppsFragment = patchActivity.frag;
              listAppsFragment.removeDialogLP(38);
              locallistAppsFragment = patchActivity.frag;
              listAppsFragment.showDialogLP(38);
            }
          });
          return;
        }
      }
    });
    paramView.setPriority(10);
    paramView.start();
  }
  
  public void toolbar_system_utils_click(View paramView)
  {
    if (listAppsFragment.menu_open) {
      listAppsFragment.frag.hideMenu();
    }
    for (;;)
    {
      return;
      paramView = new ArrayList();
      paramView.add(new MenuItem(2131165211, new ArrayList(), true));
      if (listAppsFragment.su)
      {
        paramView.add(new MenuItem(2131165243, new ArrayList(), true));
        paramView.add(new MenuItem(2131165259, new ArrayList() {}, true));
        List localList = listAppsFragment.getPkgMng().queryIntentServices(new Intent("com.google.android.gms.ads.identifier.service.START"), 0);
        if ((localList != null) && (localList.size() > 0)) {
          paramView.add(new MenuItem(2131165724, new ArrayList() {}, true));
        }
      }
      else
      {
        paramView.add(new MenuItem(2131165636, new ArrayList(), true));
        if (listAppsFragment.su)
        {
          paramView.add(new MenuItem(2131165413, new ArrayList(), true));
          paramView.add(new MenuItem(2131165375, new ArrayList(), true));
          if (Utils.isXposedEnabled()) {
            paramView.add(new MenuItem(2131165753, new ArrayList(), true));
          }
          paramView.add(new MenuItem(2131165546, new ArrayList(), true));
        }
      }
      try
      {
        listAppsFragment.getPkgMng().getPackageInfo("com.android.vending", 0);
        paramView.add(new MenuItem(2131165520, new ArrayList(), true));
        paramView.add(new MenuItem(2131165584, new ArrayList(), true));
        paramView.add(new MenuItem(2131165638, new ArrayList(), true));
        paramView.add(new MenuItem(2131165252, new ArrayList(), true));
        if ((listAppsFragment.api < 19) || (listAppsFragment.su)) {
          paramView.add(new MenuItem(2131165658, new ArrayList() {}, true));
        }
        if (listAppsFragment.su) {
          paramView.add(new MenuItem(2131165630, new ArrayList(), true));
        }
        try
        {
          if (listAppsFragment.menu_adapter == null) {
            continue;
          }
          listAppsFragment.menu_adapter.add(paramView);
          listAppsFragment.frag.showMenu();
          return;
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
        paramView.add(new MenuItem(2131165724, new ArrayList() {}, true));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (listAppsFragment.su) {
            paramView.add(new MenuItem(2131165789, new ArrayList(), true));
          }
        }
      }
    }
  }
  
  final class byNameApkFile
    implements Comparator<FileApkListItem>
  {
    byNameApkFile() {}
    
    public int compare(FileApkListItem paramFileApkListItem1, FileApkListItem paramFileApkListItem2)
    {
      if ((paramFileApkListItem1 == null) || (paramFileApkListItem2 == null)) {
        throw new ClassCastException();
      }
      if (paramFileApkListItem1.pkgName.equals(paramFileApkListItem2.pkgName))
      {
        if (paramFileApkListItem1.versionCode > paramFileApkListItem2.versionCode) {
          return 1;
        }
        if (paramFileApkListItem1.versionCode < paramFileApkListItem2.versionCode) {
          return -1;
        }
        if (paramFileApkListItem1.versionCode == paramFileApkListItem2.versionCode) {
          return 0;
        }
      }
      return paramFileApkListItem1.name.compareToIgnoreCase(paramFileApkListItem2.name);
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/patchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */