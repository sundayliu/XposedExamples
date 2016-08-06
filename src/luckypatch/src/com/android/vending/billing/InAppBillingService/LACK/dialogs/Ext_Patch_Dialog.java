package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.vending.billing.InAppBillingService.LACK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

public class Ext_Patch_Dialog
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
    System.out.println("Ext Patch Dialog create.");
    if ((listAppsFragment.frag == null) || (listAppsFragment.frag.getContext() == null)) {
      dismiss();
    }
    LinearLayout localLinearLayout1 = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968613, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131558550).findViewById(2131558551);
    int i = 0;
    if (listAppsFragment.str == null) {
      listAppsFragment.str = " ";
    }
    listAppsFragment.CurentSelect = 0;
    listAppsFragment.contextext = listAppsFragment.frag.getContext();
    Object localObject1 = null;
    Object localObject2 = new String[listAppsFragment.str.split("\n").length];
    String[] arrayOfString = listAppsFragment.str.split("\n");
    int j = 1;
    int k;
    for (;;)
    {
      k = 0;
      if ((j == 0) || (i >= arrayOfString.length)) {
        break;
      }
      try
      {
        localObject2 = new JSONObject(arrayOfString[i]).getString("objects");
        localObject1 = localObject2;
        j = 0;
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        j = 1;
        i += 1;
      }
    }
    j = k;
    if (localObject1 != null) {
      j = Integer.parseInt((String)localObject1);
    }
    localObject1 = null;
    if (j != 0)
    {
      localObject3 = new String[j + 1];
      localObject1 = localObject3;
      if (i < localObject3.length)
      {
        if (i == 0) {
          localObject3[0] = "Please Select";
        }
        for (;;)
        {
          i += 1;
          break;
          localObject3[i] = ("Object N" + i);
        }
      }
    }
    Object localObject3 = Utils.getText(2131165448) + " " + j + " " + Utils.getText(2131165449);
    listAppsFragment.tvt = (TextView)localLinearLayout2.findViewById(2131558552);
    listAppsFragment.tvt.append(Utils.getColoredText((String)localObject3, -16711821, "bold"));
    localObject3 = (Spinner)localLinearLayout2.findViewById(2131558553);
    if (localObject1 != null)
    {
      listAppsFragment.CurentSelect = 0;
      ((Spinner)localObject3).setAdapter(new ArrayAdapter(listAppsFragment.frag.getContext(), 17367048, (Object[])localObject1));
      ((Spinner)localObject3).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (paramAnonymousInt != 0) {
            listAppsFragment.CurentSelect = paramAnonymousInt;
          }
          listAppsFragment.tvt.invalidate();
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
    }
    if (j == 0)
    {
      ((Spinner)localObject3).setEnabled(false);
      listAppsFragment.CurentSelect = 0;
    }
    localObject1 = Utils.getText(2131165450);
    listAppsFragment.tvt = (TextView)localLinearLayout2.findViewById(2131558558);
    listAppsFragment.tvt.append(Utils.getColoredText((String)localObject1, -990142, "bold"));
    if (!listAppsFragment.str.contains("SU Java-Code Running!"))
    {
      localObject1 = "\n" + Utils.getText(2131165567) + "\n";
      listAppsFragment.tvt = (TextView)localLinearLayout2.findViewById(2131558558);
      listAppsFragment.tvt.append(Utils.getColoredText((String)localObject1, -16711681, "bold"));
    }
    localObject1 = new AlertDlg(listAppsFragment.frag.getContext(), true).setView(localLinearLayout1).create();
    ((Dialog)localObject1).setTitle(Utils.getText(2131165186));
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/Ext_Patch_Dialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */