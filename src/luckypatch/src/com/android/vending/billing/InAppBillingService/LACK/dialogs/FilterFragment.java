package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import com.android.vending.billing.InAppBillingService.LACK.PkgListItemAdapter;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;

public class FilterFragment
  extends Fragment
{
  public View onCreateView(LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2130968616, paramViewGroup, false);
    paramViewGroup = (EditText)paramLayoutInflater.findViewById(2131558438);
    ((Button)paramLayoutInflater.findViewById(2131558437)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          if (listAppsFragment.plia != null)
          {
            listAppsFragment.plia.getFilter().filter("");
            listAppsFragment.plia.notifyDataSetChanged();
          }
          paramViewGroup.setText("");
          return;
        }
        catch (Exception paramAnonymousView) {}
      }
    });
    ((Button)paramLayoutInflater.findViewById(2131558563)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          new AdvancedFilter().showDialog();
          return;
        }
        catch (Exception paramAnonymousView) {}
      }
    });
    paramViewGroup.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        try
        {
          if (listAppsFragment.plia != null)
          {
            listAppsFragment.plia.getFilter().filter(paramAnonymousEditable.toString());
            listAppsFragment.plia.notifyDataSetChanged();
          }
          return;
        }
        catch (Exception paramAnonymousEditable) {}
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    return paramLayoutInflater;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/FilterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */