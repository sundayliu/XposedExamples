package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import com.android.vending.billing.InAppBillingService.LACK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import java.io.PrintStream;

public class Menu_Dialog
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
    try
    {
      System.out.println("Menu Dialog create.");
      if ((listAppsFragment.frag == null) || (listAppsFragment.frag.getContext() == null)) {
        dismiss();
      }
      Object localObject = new AlertDlg(listAppsFragment.frag.getContext());
      if (listAppsFragment.menu_adapt != null)
      {
        listAppsFragment.menu_adapt.setNotifyOnChange(true);
        ((AlertDlg)localObject).setAdapter(listAppsFragment.menu_adapt, new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            try
            {
              paramAnonymousAdapterView = listAppsFragment.frag;
              listAppsFragment.removeDialogLP(7);
              paramAnonymousInt = ((Integer)listAppsFragment.menu_adapt.getItem(paramAnonymousInt)).intValue();
              listAppsFragment.frag.runId(paramAnonymousInt);
              return;
            }
            catch (Exception paramAnonymousAdapterView)
            {
              System.out.println("LuckyPatcher (ContextMenu): Error open! " + paramAnonymousAdapterView);
              paramAnonymousAdapterView.printStackTrace();
            }
          }
        });
      }
      ((AlertDlg)localObject).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          listAppsFragment.rebuldApk = "";
          System.out.println(listAppsFragment.rebuldApk);
        }
      });
      localObject = ((AlertDlg)localObject).create();
      return (Dialog)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/Menu_Dialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */