package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.android.vending.billing.InAppBillingService.LACK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.PrintStream;

public class AdvancedFilter
{
  public static final int LOADING_PROGRESS_DIALOG = 23;
  AdvancedFilter adv = null;
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
    System.out.println("Market install Dialog create.");
    if ((listAppsFragment.frag == null) || (listAppsFragment.frag.getContext() == null)) {
      dismiss();
    }
    Object localObject1 = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968579, null);
    Object localObject2 = (LinearLayout)((LinearLayout)localObject1).findViewById(2131558411).findViewById(2131558412);
    Object localObject3 = (TextView)((LinearLayout)localObject2).findViewById(2131558454);
    localObject2 = (RadioGroup)((LinearLayout)localObject2).findViewById(2131558414);
    ((RadioGroup)localObject2).getCheckedRadioButtonId();
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558415);
    ((RadioButton)localObject3).setText(Utils.getText(2131165573));
    if ((listAppsFragment.advancedFilter == 0) || (listAppsFragment.advancedFilter == 2131558415)) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558416);
    ((RadioButton)localObject3).setText(Utils.getText(2131165457));
    if (listAppsFragment.advancedFilter == 2131558416) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558417);
    ((RadioButton)localObject3).setText(Utils.getText(2131165458));
    if (listAppsFragment.advancedFilter == 2131558417) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558418);
    ((RadioButton)localObject3).setText(Utils.getText(2131165463));
    if (listAppsFragment.advancedFilter == 2131558418) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558419);
    ((RadioButton)localObject3).setText(Utils.getText(2131165460));
    if (listAppsFragment.advancedFilter == 2131558419) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558420);
    ((RadioButton)localObject3).setText(Utils.getText(2131165461));
    if (listAppsFragment.advancedFilter == 2131558420) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558421);
    ((RadioButton)localObject3).setText(Utils.getText(2131165462));
    if (listAppsFragment.advancedFilter == 2131558421) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558422);
    ((RadioButton)localObject3).setText(Utils.getText(2131165465));
    if (listAppsFragment.advancedFilter == 2131558422) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558423);
    ((RadioButton)localObject3).setText(Utils.getText(2131165466));
    if (listAppsFragment.advancedFilter == 2131558423) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558424);
    ((RadioButton)localObject3).setText(Utils.getText(2131165467));
    if (listAppsFragment.advancedFilter == 2131558424) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558426);
    ((RadioButton)localObject3).setText(Utils.getText(2131165468));
    if (listAppsFragment.advancedFilter == 2131558426) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558427);
    ((RadioButton)localObject3).setText(Utils.getText(2131165469));
    if (listAppsFragment.advancedFilter == 2131558427) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558428);
    ((RadioButton)localObject3).setText(Utils.getText(2131165470));
    if (listAppsFragment.advancedFilter == 2131558428) {
      ((RadioButton)localObject3).setChecked(true);
    }
    localObject3 = (RadioButton)((RadioGroup)localObject2).findViewById(2131558425);
    ((RadioButton)localObject3).setText(Utils.getText(2131165459));
    if (listAppsFragment.advancedFilter == 2131558425) {
      ((RadioButton)localObject3).setChecked(true);
    }
    ((RadioGroup)localObject2).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 2131558415)
        {
          listAppsFragment.advancedFilter = 0;
          return;
        }
        listAppsFragment.advancedFilter = paramAnonymousInt;
      }
    });
    ((Button)((LinearLayout)localObject1).findViewById(2131558429)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        listAppsFragment.frag.app_scanning();
        AdvancedFilter.this.adv.dismiss();
      }
    });
    ((Button)((LinearLayout)localObject1).findViewById(2131558430)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AdvancedFilter.this.adv.dismiss();
      }
    });
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext(), true).setView((View)localObject1).create();
    ((Dialog)localObject1).setCancelable(true);
    ((Dialog)localObject1).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    return (Dialog)localObject1;
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/AdvancedFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */