package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.android.vending.billing.InAppBillingService.LACK.ProgressDlg;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;

public class Progress_Dialog_Loading
{
  public static ProgressDlg dialog = null;
  FragmentActivity context = null;
  Dialog dialog2 = null;
  FragmentManager fm = null;
  String message = "";
  String title = "";
  
  public static Progress_Dialog_Loading newInstance()
  {
    return new Progress_Dialog_Loading();
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
    return (dialog != null) && (dialog.isShowing());
  }
  
  public Dialog onCreateDialog()
  {
    dialog = new ProgressDlg(listAppsFragment.frag.getContext());
    dialog.setIncrementStyle();
    if (this.title.equals("")) {
      this.title = Utils.getText(2131165423);
    }
    dialog.setTitle(this.title);
    if (this.message.equals("")) {
      this.message = Utils.getText(2131165747);
    }
    dialog.setMessage(this.message);
    dialog.setIcon(2130837555);
    dialog.setCancelable(false);
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
  
  public void setIndeterminate(boolean paramBoolean, Activity paramActivity)
  {
    if (dialog == null) {
      onCreateDialog();
    }
    if (paramBoolean) {
      dialog.setProgressNumberFormat("");
    }
    for (;;)
    {
      if (!paramBoolean) {
        dialog.setIncrementStyle();
      }
      try
      {
        for (;;)
        {
          if (!Utils.onMainThread()) {
            break label78;
          }
          if (listAppsFragment.frag != null) {
            listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
          }
          return;
          dialog.setProgressNumberFormat("%1d/%2d");
          break;
          dialog.setDefaultStyle();
        }
        label78:
        listAppsFragment.frag.runToMain(new Runnable()
        {
          public void run()
          {
            if (listAppsFragment.frag != null) {
              listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
            }
          }
        });
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public void setMax(int paramInt)
  {
    if (dialog == null) {
      onCreateDialog();
    }
    dialog.setMax(paramInt);
    try
    {
      if (Utils.onMainThread())
      {
        if (listAppsFragment.frag != null) {
          listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
        }
      }
      else
      {
        listAppsFragment.frag.runToMain(new Runnable()
        {
          public void run()
          {
            if (listAppsFragment.frag != null) {
              listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
            }
          }
        });
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
    if (dialog == null) {
      onCreateDialog();
    }
    dialog.setMessage(this.message);
    try
    {
      if (Utils.onMainThread())
      {
        if (listAppsFragment.frag != null) {
          listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
        }
      }
      else
      {
        listAppsFragment.frag.runToMain(new Runnable()
        {
          public void run()
          {
            if (listAppsFragment.frag != null) {
              listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
            }
          }
        });
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setProgress(int paramInt)
  {
    if (dialog == null) {
      onCreateDialog();
    }
    dialog.setProgress(paramInt);
    try
    {
      if (Utils.onMainThread())
      {
        if (listAppsFragment.frag != null) {
          listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
        }
      }
      else
      {
        listAppsFragment.frag.runToMain(new Runnable()
        {
          public void run()
          {
            if (listAppsFragment.frag != null) {
              listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
            }
          }
        });
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setProgressNumberFormat(String paramString)
  {
    if (dialog == null) {
      onCreateDialog();
    }
    dialog.setProgressNumberFormat(paramString);
    try
    {
      if (Utils.onMainThread())
      {
        if (listAppsFragment.frag != null) {
          listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
        }
      }
      else
      {
        listAppsFragment.frag.runToMain(new Runnable()
        {
          public void run()
          {
            if (listAppsFragment.frag != null) {
              listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
            }
          }
        });
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
    if (dialog == null) {
      onCreateDialog();
    }
    if (dialog != null)
    {
      dialog.setTitle(this.title);
      try
      {
        if (Utils.onMainThread())
        {
          if (listAppsFragment.frag != null) {
            listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
          }
        }
        else
        {
          listAppsFragment.frag.runToMain(new Runnable()
          {
            public void run()
            {
              if (listAppsFragment.frag != null) {
                listAppsFragment.frag.getChildFragmentManager().executePendingTransactions();
              }
            }
          });
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/Progress_Dialog_Loading.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */