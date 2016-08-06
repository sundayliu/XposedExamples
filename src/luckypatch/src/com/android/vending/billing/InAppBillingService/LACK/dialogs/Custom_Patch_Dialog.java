package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
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

public class Custom_Patch_Dialog
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
    System.out.println("Custom Dialog create.");
    final PkgListItem localPkgListItem = listAppsFragment.pli_work;
    if ((listAppsFragment.frag == null) || (listAppsFragment.frag.getContext() == null)) {
      dismiss();
    }
    LinearLayout localLinearLayout = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968612, null);
    try
    {
      localObject = (LinearLayout)localLinearLayout.findViewById(2131558546).findViewById(2131558547);
      if (listAppsFragment.str == null) {
        listAppsFragment.str = " ";
      }
      if (!listAppsFragment.str.contains("SU Java-Code Running!")) {
        listAppsFragment.str = "Root not stable. Try again or update your root.";
      }
      if ((!listAppsFragment.str.contains("Error LP:")) && (!listAppsFragment.str.contains("Object not found!"))) {
        ((TextView)((LinearLayout)localObject).findViewById(2131558548)).append(Utils.getColoredText(listAppsFragment.str, "#ff00ff73", "bold"));
      }
      if ((listAppsFragment.str.contains("Error LP:")) || (listAppsFragment.str.contains("Object not found!"))) {
        ((TextView)((LinearLayout)localObject).findViewById(2131558548)).append(Utils.getColoredText(listAppsFragment.str, "#ffff0055", "bold"));
      }
      if (listAppsFragment.str.contains("Custom Patch not Found. Put info about SuperSu.")) {
        ((TextView)((LinearLayout)localObject).findViewById(2131558548)).setText(Utils.getColoredText(Utils.getText(2131165805), "#ffff0055", "bold"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        localException.printStackTrace();
        dismiss();
      }
    }
    localObject = new AlertDlg(listAppsFragment.frag.getContext());
    ((AlertDlg)localObject).setIcon(2130837548);
    ((AlertDlg)localObject).setTitle(Utils.getText(2131165186));
    ((AlertDlg)localObject).setCancelable(true);
    ((AlertDlg)localObject).setPositiveButton(Utils.getText(2131165587), null);
    if (listAppsFragment.func != 0) {
      ((AlertDlg)localObject).setNeutralButton(2131165510, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          new Thread(new Runnable()
          {
            public void run()
            {
              try
              {
                Utils.kill(Custom_Patch_Dialog.1.this.val$pli_local.pkgName);
                Utils.run_all("killall " + Custom_Patch_Dialog.1.this.val$pli_local.pkgName);
                this.val$handler.post(new Runnable()
                {
                  public void run()
                  {
                    Object localObject = listAppsFragment.getPkgMng().getLaunchIntentForPackage(Custom_Patch_Dialog.1.this.val$pli_local.pkgName);
                    if (listAppsFragment.su)
                    {
                      Utils.startApp(Custom_Patch_Dialog.1.this.val$pli_local.pkgName);
                      return;
                    }
                    try
                    {
                      listAppsFragment.patchAct.startActivity((Intent)localObject);
                      localObject = listAppsFragment.frag;
                      listAppsFragment.removeDialogLP(4);
                      return;
                    }
                    catch (Exception localException)
                    {
                      localException.printStackTrace();
                    }
                  }
                });
                return;
              }
              catch (Exception localException)
              {
                while (listAppsFragment.frag == null) {}
                listAppsFragment.frag.runToMain(new Runnable()
                {
                  public void run()
                  {
                    Toast.makeText(listAppsFragment.frag.getContext(), Utils.getText(2131165437), 1).show();
                  }
                });
              }
            }
          }).start();
        }
      });
    }
    ((AlertDlg)localObject).setView(localLinearLayout);
    return ((AlertDlg)localObject).create();
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/Custom_Patch_Dialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */