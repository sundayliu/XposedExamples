package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.PrintStream;

public class AlertDlg
{
  public ArrayAdapter adapter = null;
  public Context context = null;
  public Dialog dialog = null;
  public boolean not_close = false;
  public View root = null;
  
  public AlertDlg(Context paramContext)
  {
    this.context = paramContext;
    this.dialog = new Dialog(paramContext);
    this.dialog.requestWindowFeature(1);
    this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    this.dialog.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      int displayWidth = 0;
      int orient = 255;
      int setForSize = 0;
      
      public void onGlobalLayout()
      {
        Window localWindow = AlertDlg.this.dialog.getWindow();
        int i = localWindow.getDecorView().getWidth();
        int k = listAppsFragment.getRes().getDisplayMetrics().heightPixels;
        int j = listAppsFragment.getRes().getDisplayMetrics().widthPixels;
        WindowManager.LayoutParams localLayoutParams;
        int m;
        if (k > j)
        {
          this.orient = 0;
          if ((this.displayWidth == 0) || (this.displayWidth != j))
          {
            this.setForSize = 0;
            this.displayWidth = j;
          }
          if ((this.setForSize == 0) || (i != this.setForSize))
          {
            localWindow.setGravity(17);
            localLayoutParams = localWindow.getAttributes();
            k = (int)(j * 0.98D);
            m = (int)(j * 0.75D);
            System.out.println("wight:" + i);
            switch (this.orient)
            {
            }
          }
        }
        for (;;)
        {
          this.setForSize = localLayoutParams.width;
          localWindow.setAttributes(localLayoutParams);
          return;
          this.orient = 1;
          break;
          if (j < 900)
          {
            if (i >= m)
            {
              localLayoutParams.width = k;
              this.setForSize = k;
            }
            else
            {
              localLayoutParams.width = m;
              this.setForSize = m;
            }
          }
          else if (i >= k)
          {
            localLayoutParams.width = k;
            this.setForSize = k;
          }
          else if (i < m)
          {
            localLayoutParams.width = m;
            this.setForSize = m;
          }
          else
          {
            localLayoutParams.width = i;
            continue;
            if (j < 900)
            {
              if (i < m)
              {
                localLayoutParams.width = m;
                this.setForSize = m;
              }
            }
            else if (i < m)
            {
              localLayoutParams.width = m;
              this.setForSize = m;
            }
            else
            {
              localLayoutParams.width = i;
            }
          }
        }
      }
    });
    this.dialog.setContentView(2130968580);
    this.dialog.setCancelable(true);
  }
  
  public AlertDlg(Context paramContext, int paramInt)
  {
    this.context = paramContext;
    this.dialog = new Dialog(paramContext, paramInt);
    this.dialog.setContentView(2130968580);
    this.dialog.setCancelable(true);
  }
  
  public AlertDlg(Context paramContext, boolean paramBoolean)
  {
    this.context = paramContext;
    this.dialog = new Dialog(paramContext, 2131230725)
    {
      protected void onCreate(Bundle paramAnonymousBundle)
      {
        super.onCreate(paramAnonymousBundle);
        ((LinearLayout)findViewById(2131558431)).setBackgroundColor(Color.parseColor("#000000"));
        getWindow().setLayout(-1, -1);
      }
    };
    this.dialog.setContentView(2130968580);
    this.dialog.setCancelable(true);
  }
  
  public Dialog create()
  {
    return this.dialog;
  }
  
  public AlertDlg setAdapter(final ArrayAdapter paramArrayAdapter, final AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.adapter = paramArrayAdapter;
    ListView localListView = (ListView)this.dialog.findViewById(2131558442);
    LinearLayout localLinearLayout = (LinearLayout)this.dialog.findViewById(2131558445);
    localListView.setVisibility(0);
    localListView.setAdapter(paramArrayAdapter);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramOnItemClickListener.onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramArrayAdapter.notifyDataSetChanged();
        if (!AlertDlg.this.not_close) {
          AlertDlg.this.dialog.dismiss();
        }
      }
    });
    localListView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[] { 868199252, 868199252, 868199252 }));
    localListView.setDividerHeight(3);
    return this;
  }
  
  public void setAdapterNotClose(boolean paramBoolean)
  {
    this.not_close = paramBoolean;
  }
  
  public AlertDlg setAdapterWithFilter(final ArrayAdapterWithFilter paramArrayAdapterWithFilter, final AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.adapter = paramArrayAdapterWithFilter;
    ListView localListView = (ListView)this.dialog.findViewById(2131558442);
    final Object localObject = (EditText)this.dialog.findViewById(2131558438);
    ((Button)this.dialog.findViewById(2131558437)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          if (AlertDlg.this.adapter != null)
          {
            AlertDlg.this.adapter.getFilter().filter("");
            AlertDlg.this.adapter.notifyDataSetChanged();
          }
          localObject.setText("");
          return;
        }
        catch (Exception paramAnonymousView) {}
      }
    });
    ((EditText)localObject).addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        try
        {
          if (AlertDlg.this.adapter != null)
          {
            AlertDlg.this.adapter.getFilter().filter(paramAnonymousEditable.toString());
            AlertDlg.this.adapter.notifyDataSetChanged();
          }
          return;
        }
        catch (Exception paramAnonymousEditable) {}
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    localObject = (LinearLayout)this.dialog.findViewById(2131558445);
    localListView.setVisibility(0);
    ((LinearLayout)this.dialog.findViewById(2131558436)).setVisibility(0);
    localListView.setAdapter(paramArrayAdapterWithFilter);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramOnItemClickListener.onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramArrayAdapterWithFilter.notifyDataSetChanged();
        if (!AlertDlg.this.not_close) {
          AlertDlg.this.dialog.dismiss();
        }
      }
    });
    localListView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[] { 868199252, 868199252, 868199252 }));
    localListView.setDividerHeight(3);
    return this;
  }
  
  public AlertDlg setCancelable(boolean paramBoolean)
  {
    this.dialog.setCancelable(paramBoolean);
    return this;
  }
  
  public AlertDlg setCheckBox(SpannableString paramSpannableString, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener, boolean paramBoolean)
  {
    Object localObject = (LinearLayout)this.dialog.findViewById(2131558443);
    ((LinearLayout)localObject).setVisibility(0);
    localObject = (CheckBox)((LinearLayout)localObject).findViewById(2131558444);
    ((CheckBox)localObject).setText(paramSpannableString);
    ((CheckBox)localObject).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    ((CheckBox)localObject).setChecked(paramBoolean);
    return this;
  }
  
  public AlertDlg setCheckBox(String paramString, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener, boolean paramBoolean)
  {
    Object localObject = (LinearLayout)this.dialog.findViewById(2131558443);
    ((LinearLayout)localObject).setVisibility(0);
    localObject = (CheckBox)((LinearLayout)localObject).findViewById(2131558444);
    ((CheckBox)localObject).setText(paramString);
    ((CheckBox)localObject).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    ((CheckBox)localObject).setChecked(paramBoolean);
    return this;
  }
  
  public AlertDlg setIcon(int paramInt)
  {
    ((LinearLayout)this.dialog.findViewById(2131558432)).setVisibility(0);
    ImageView localImageView = (ImageView)this.dialog.findViewById(2131558433);
    localImageView.setVisibility(0);
    localImageView.setImageDrawable(this.context.getResources().getDrawable(paramInt));
    ((TextView)this.dialog.findViewById(2131558435)).setVisibility(0);
    return this;
  }
  
  public AlertDlg setMessage(SpannableString paramSpannableString)
  {
    TextView localTextView = (TextView)this.dialog.findViewById(2131558441);
    ((ScrollView)this.dialog.findViewById(2131558440)).setVisibility(0);
    localTextView.setMovementMethod(new ScrollingMovementMethod());
    localTextView.setText(paramSpannableString);
    return this;
  }
  
  public AlertDlg setMessage(String paramString)
  {
    TextView localTextView = (TextView)this.dialog.findViewById(2131558441);
    ((ScrollView)this.dialog.findViewById(2131558440)).setVisibility(0);
    localTextView.setMovementMethod(new ScrollingMovementMethod());
    localTextView.setText(paramString);
    return this;
  }
  
  public AlertDlg setNegativeButton(int paramInt, final DialogInterface.OnClickListener paramOnClickListener)
  {
    Button localButton = (Button)this.dialog.findViewById(2131558408);
    localButton.setVisibility(0);
    localButton.setText(paramInt);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(AlertDlg.this.dialog, -2);
        }
        AlertDlg.this.dialog.dismiss();
      }
    });
    return this;
  }
  
  public AlertDlg setNegativeButton(String paramString, final DialogInterface.OnClickListener paramOnClickListener)
  {
    Button localButton = (Button)this.dialog.findViewById(2131558408);
    localButton.setVisibility(0);
    localButton.setText(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(AlertDlg.this.dialog, -2);
        }
        AlertDlg.this.dialog.dismiss();
      }
    });
    return this;
  }
  
  public AlertDlg setNeutralButton(int paramInt, final DialogInterface.OnClickListener paramOnClickListener)
  {
    Button localButton = (Button)this.dialog.findViewById(2131558446);
    localButton.setVisibility(0);
    localButton.setText(paramInt);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(AlertDlg.this.dialog, -3);
        }
        AlertDlg.this.dialog.dismiss();
      }
    });
    return this;
  }
  
  public AlertDlg setNeutralButton(String paramString, final DialogInterface.OnClickListener paramOnClickListener)
  {
    Button localButton = (Button)this.dialog.findViewById(2131558446);
    localButton.setVisibility(0);
    localButton.setText(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(AlertDlg.this.dialog, -3);
        }
        AlertDlg.this.dialog.dismiss();
      }
    });
    return this;
  }
  
  public AlertDlg setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.dialog.setOnCancelListener(paramOnCancelListener);
    return this;
  }
  
  public AlertDlg setPositiveButton(int paramInt, final DialogInterface.OnClickListener paramOnClickListener)
  {
    Button localButton = (Button)this.dialog.findViewById(2131558407);
    localButton.setVisibility(0);
    localButton.setText(paramInt);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(AlertDlg.this.dialog, -1);
        }
        AlertDlg.this.dialog.dismiss();
      }
    });
    return this;
  }
  
  public AlertDlg setPositiveButton(String paramString, final DialogInterface.OnClickListener paramOnClickListener)
  {
    Button localButton = (Button)this.dialog.findViewById(2131558407);
    localButton.setVisibility(0);
    localButton.setText(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(AlertDlg.this.dialog, -1);
        }
        AlertDlg.this.dialog.dismiss();
      }
    });
    return this;
  }
  
  public AlertDlg setTitle(int paramInt)
  {
    ((LinearLayout)this.dialog.findViewById(2131558432)).setVisibility(0);
    ((TextView)this.dialog.findViewById(2131558434)).setText(paramInt);
    return this;
  }
  
  public AlertDlg setTitle(String paramString)
  {
    ((LinearLayout)this.dialog.findViewById(2131558432)).setVisibility(0);
    ((TextView)this.dialog.findViewById(2131558434)).setText(paramString);
    ((TextView)this.dialog.findViewById(2131558435)).setVisibility(0);
    return this;
  }
  
  public AlertDlg setView(View paramView)
  {
    LinearLayout localLinearLayout1 = (LinearLayout)this.dialog.findViewById(2131558439);
    LinearLayout localLinearLayout2 = (LinearLayout)this.dialog.findViewById(2131558445);
    localLinearLayout1.addView(paramView);
    return this;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/AlertDlg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */