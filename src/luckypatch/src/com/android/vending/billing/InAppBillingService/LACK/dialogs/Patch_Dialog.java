package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.vending.billing.InAppBillingService.LACK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LACK.PkgListItem;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.android.vending.billing.InAppBillingService.LACK.patchActivity;
import com.chelpus.Utils;
import java.io.PrintStream;

public class Patch_Dialog
{
  Dialog dialog = null;
  
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
    System.out.println("Patch Dialog create.");
    final PkgListItem localPkgListItem = listAppsFragment.pli;
    if ((listAppsFragment.frag == null) || (listAppsFragment.frag.getContext() == null)) {
      dismiss();
    }
    LinearLayout localLinearLayout = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968626, null);
    Object localObject = (TextView)((LinearLayout)localLinearLayout.findViewById(2131558603).findViewById(2131558604)).findViewById(2131558607);
    try
    {
      listAppsFragment locallistAppsFragment = listAppsFragment.frag;
      listAppsFragment.patch_dialog_text_builder((TextView)localObject, false);
      localObject = new AlertDlg(listAppsFragment.frag.getContext());
      ((AlertDlg)localObject).setIcon(2130837548);
      ((AlertDlg)localObject).setTitle(Utils.getText(2131165186));
      ((AlertDlg)localObject).setCancelable(true).setPositiveButton(Utils.getText(2131165587), null).setNeutralButton(2131165510, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          try
          {
            Utils.kill(localPkgListItem.pkgName);
            Utils.run_all("killall " + localPkgListItem.pkgName);
            paramAnonymousDialogInterface = listAppsFragment.getPkgMng().getLaunchIntentForPackage(localPkgListItem.pkgName);
            if (listAppsFragment.su) {
              Utils.startApp(localPkgListItem.pkgName);
            }
            for (;;)
            {
              Patch_Dialog.this.dismiss();
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
              Toast.makeText(listAppsFragment.getInstance(), Utils.getText(2131165437), 1).show();
            }
          }
        }
      }).setView(localLinearLayout).create();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/Patch_Dialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */