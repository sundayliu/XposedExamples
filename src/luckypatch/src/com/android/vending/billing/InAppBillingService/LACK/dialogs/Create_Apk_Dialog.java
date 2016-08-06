package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.vending.billing.InAppBillingService.LACK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LACK.PkgListItem;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.android.vending.billing.InAppBillingService.LACK.patchActivity;
import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class Create_Apk_Dialog
{
  Dialog dialog = null;
  String resultFile = "";
  
  public void dismiss()
  {
    if (this.dialog != null)
    {
      this.dialog.dismiss();
      this.dialog = null;
    }
  }
  
  public Dialog onCreateDialog()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968612, null);
    System.out.println("Create apk Dialog create.");
    if ((listAppsFragment.frag == null) || (listAppsFragment.frag.getContext() == null)) {
      dismiss();
    }
    localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131558546).findViewById(2131558547);
    TextView localTextView = (TextView)localLinearLayout2.findViewById(2131558548);
    String str = "";
    Object localObject1 = ".v.";
    try
    {
      localObject2 = ".v." + listAppsFragment.getPkgMng().getPackageInfo(listAppsFragment.pli.pkgName, 0).versionName + ".b." + listAppsFragment.getPkgMng().getPackageInfo(listAppsFragment.pli.pkgName, 0).versionCode;
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
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        dismiss();
        continue;
        listAppsFragment.str = Utils.getText(2131165390) + " " + listAppsFragment.pli.name + " " + Utils.getText(2131165395);
        ((TextView)localLinearLayout2.findViewById(2131558548)).append(Utils.getColoredText(listAppsFragment.str, -65451, "bold"));
      }
    }
    if (listAppsFragment.str == null) {
      listAppsFragment.str = " ";
    }
    if (listAppsFragment.str.contains("DependenciesMode Lucky")) {
      str = (String)localObject1 + ".crk.Dependencies";
    }
    if (listAppsFragment.str.contains("NormalMode Lucky")) {
      str = (String)localObject1 + ".crk.LVL.Auto";
    }
    if (listAppsFragment.str.contains("ExtremeMode Lucky")) {
      str = (String)localObject1 + ".crk.LVL.Extreme";
    }
    if (listAppsFragment.str.contains("InverseNormalMode Lucky")) {
      str = (String)localObject1 + ".crk.LVL.AutoInverse";
    }
    if (listAppsFragment.str.contains("PermissionRemovedMode Lucky")) {
      str = (String)localObject1 + ".Permissions";
    }
    if (listAppsFragment.str.contains("AmazonMode Lucky")) {
      str = (String)localObject1 + ".crk.Amazon";
    }
    if (listAppsFragment.str.contains("SamsungMode Lucky")) {
      str = (String)localObject1 + ".crk.SamsungApps";
    }
    if (!listAppsFragment.str.contains("PermissionRemovedMode Lucky"))
    {
      localObject1 = listAppsFragment.frag;
      listAppsFragment.patch_dialog_text_builder(localTextView, true);
    }
    if (listAppsFragment.pli != null)
    {
      this.resultFile = (listAppsFragment.basepath + "/Modified/" + listAppsFragment.pli.name.replaceAll(" ", ".").replaceAll("/", ".") + "/");
      localObject1 = new File(this.resultFile + listAppsFragment.pli.name.replaceAll(" ", ".").replaceAll("/", ".") + str + ".Removed.apk");
      localObject2 = new File(this.resultFile + listAppsFragment.pli.pkgName + str + ".Removed.apk");
      if ((((File)localObject1).exists()) || (((File)localObject2).exists()))
      {
        if ((((File)localObject1).exists()) && (listAppsFragment.getConfig().getInt("apkname", 0) == 0)) {
          listAppsFragment.str = Utils.getText(2131165390) + " " + listAppsFragment.pli.name + " " + Utils.getText(2131165392) + "\n" + this.resultFile + "\n\n" + Utils.getText(2131165396) + "\n" + listAppsFragment.pli.name.replaceAll(" ", ".").replaceAll("/", ".") + str + ".Removed.apk" + Utils.getText(2131165393);
        }
        if ((((File)localObject2).exists()) && (listAppsFragment.getConfig().getInt("apkname", 0) == 1)) {
          listAppsFragment.str = Utils.getText(2131165390) + " " + listAppsFragment.pli.name + " " + Utils.getText(2131165392) + "\n" + this.resultFile + "\n\n" + Utils.getText(2131165396) + "\n" + listAppsFragment.pli.pkgName + str + ".Removed.apk" + Utils.getText(2131165393);
        }
        ((TextView)localLinearLayout2.findViewById(2131558548)).append(Utils.getColoredText(listAppsFragment.str, -16711821, "bold"));
      }
    }
    else
    {
      new AlertDlg(listAppsFragment.frag.getContext()).setTitle(Utils.getText(2131165186)).setCancelable(true).setIcon(2130837548).setPositiveButton(Utils.getText(2131165587), null).setNeutralButton(Utils.getText(2131165476), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          listAppsFragment.patchAct.show_file_explorer(Create_Apk_Dialog.this.resultFile);
        }
      }).setView(localLinearLayout1).create();
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
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/Create_Apk_Dialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */