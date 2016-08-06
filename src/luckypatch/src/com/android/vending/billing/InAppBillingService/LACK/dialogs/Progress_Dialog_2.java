package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.android.vending.billing.InAppBillingService.LACK.ProgressDlg;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;

public class Progress_Dialog_2
{
  public static ProgressDlg dialog;
  Dialog dialog2 = null;
  FragmentManager fm = null;
  String message = "";
  String title = "";
  
  public static Progress_Dialog_2 newInstance()
  {
    return new Progress_Dialog_2();
  }
  
  public void dismiss()
  {
    if (this.dialog2 != null)
    {
      this.dialog2.dismiss();
      this.dialog2 = null;
    }
  }
  
  public boolean isShowing()
  {
    return (this.dialog2 != null) && (this.dialog2.isShowing());
  }
  
  public Dialog onCreateDialog()
  {
    dialog = new ProgressDlg(listAppsFragment.frag.getContext());
    if (this.message.equals("")) {
      this.message = "Loading...";
    }
    dialog.setMessage(this.message);
    dialog.setCancelable(true);
    dialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if (listAppsFragment.su) {
          Utils.exitRoot();
        }
      }
    });
    return dialog.create();
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    if (this.dialog2 != null) {
      this.dialog2.setCancelable(paramBoolean);
    }
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    if (dialog == null) {
      onCreateDialog();
    }
    if (!paramBoolean) {
      dialog.setIncrementStyle();
    }
    for (;;)
    {
      listAppsFragment.frag.getContext().runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (listAppsFragment.frag != null) {
            listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
          }
        }
      });
      return;
      dialog.setDefaultStyle();
    }
  }
  
  public void setMax(int paramInt)
  {
    if (dialog == null) {
      onCreateDialog();
    }
    dialog.setMax(paramInt);
    listAppsFragment.frag.getContext().runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (listAppsFragment.frag != null) {
          listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
        }
      }
    });
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
    if (dialog == null) {
      onCreateDialog();
    }
    dialog.setMessage(this.message);
    listAppsFragment.frag.getContext().runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (listAppsFragment.frag != null) {
          listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
        }
      }
    });
  }
  
  public void setProgress(int paramInt)
  {
    if (dialog == null) {
      onCreateDialog();
    }
    dialog.setProgress(paramInt);
    listAppsFragment.frag.getContext().runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (listAppsFragment.frag != null) {
          listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
        }
      }
    });
  }
  
  public void setTitle(String paramString)
  {
    if (dialog == null) {
      onCreateDialog();
    }
    this.title = paramString;
    dialog.setTitle(this.title);
    listAppsFragment.frag.getContext().runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (listAppsFragment.frag != null) {
          listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
        }
      }
    });
  }
  
  public void showDialog()
  {
    if (this.dialog2 == null) {
      this.dialog2 = onCreateDialog();
    }
    if (this.dialog2 != null) {
      this.dialog2.show();
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/Progress_Dialog_2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */