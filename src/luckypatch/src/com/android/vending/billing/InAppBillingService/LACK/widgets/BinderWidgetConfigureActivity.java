package com.android.vending.billing.InAppBillingService.LACK.widgets;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.android.vending.billing.InAppBillingService.LACK.BindItem;
import com.android.vending.billing.InAppBillingService.LACK.BinderActivity;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BinderWidgetConfigureActivity
  extends Activity
{
  private static final String PREFS_NAME = "com.android.vending.billing.InAppBillingService.LACK.widgets.BinderWidget";
  private static final String PREF_PREFIX_KEY = "appwidget_";
  public ArrayList<BindItem> bindes = null;
  public Context context;
  public ListView lv = null;
  int mAppWidgetId = 0;
  EditText mAppWidgetText;
  public int sizeText = 0;
  
  static void deleteTitlePref(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("com.android.vending.billing.InAppBillingService.LACK.widgets.BinderWidget", 4).edit();
    paramContext.remove("appwidget_" + paramInt);
    paramContext.commit();
  }
  
  static String loadTitlePref(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("com.android.vending.billing.InAppBillingService.LACK.widgets.BinderWidget", 4).getString("appwidget_" + paramInt, null);
    if (paramContext != null) {
      return paramContext;
    }
    return "NOT_SAVED_BIND";
  }
  
  static void saveTitlePref(Context paramContext, int paramInt, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("com.android.vending.billing.InAppBillingService.LACK.widgets.BinderWidget", 4).edit();
    paramContext.putString("appwidget_" + paramInt, paramString);
    paramContext.commit();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setResult(0);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null) {
      this.mAppWidgetId = paramBundle.getInt("appWidgetId", 0);
    }
    if (this.mAppWidgetId == 0)
    {
      finish();
      return;
    }
    this.context = this;
    paramBundle = new File(getDir("binder", 0) + "/bind.txt");
    if (!paramBundle.exists()) {}
    try
    {
      paramBundle.createNewFile();
      this.bindes = BinderActivity.getBindes(this.context);
      this.lv = new ListView(this.context);
      if (this.bindes.size() == 0) {
        this.bindes.add(new BindItem("empty", "empty"));
      }
      listAppsFragment.adaptBind = new ArrayAdapter(this, 2130968605, this.bindes)
      {
        public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
        {
          paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
          paramAnonymousViewGroup = (TextView)paramAnonymousView.findViewById(2131558462);
          paramAnonymousViewGroup.setTextAppearance(getContext(), listAppsFragment.getSizeText());
          paramAnonymousViewGroup.setTextAppearance(BinderWidgetConfigureActivity.this.context, BinderWidgetConfigureActivity.this.sizeText);
          BindItem localBindItem = (BindItem)getItem(paramAnonymousInt);
          if ((localBindItem.SourceDir.equals("empty")) && (localBindItem.TargetDir.equals("empty")))
          {
            paramAnonymousViewGroup.setText(Utils.getText(2131165424) + "\n" + Utils.getText(2131165425));
            paramAnonymousView.setEnabled(false);
            paramAnonymousView.setClickable(false);
            return paramAnonymousView;
          }
          paramAnonymousViewGroup.setText(Utils.getColoredText(Utils.getText(2131165236) + "\n", "#ff00ff00", "bold"));
          paramAnonymousViewGroup.append(Utils.getColoredText(localBindItem.SourceDir, "#ffffffff", "italic"));
          paramAnonymousViewGroup.append(Utils.getColoredText("\n" + Utils.getText(2131165237) + "\n", "#ffffff00", "bold"));
          paramAnonymousViewGroup.append(Utils.getColoredText(localBindItem.TargetDir.replace("~chelpus_disabled~", ""), "#ffffffff", "italic"));
          return paramAnonymousView;
        }
      };
      this.lv.setAdapter(listAppsFragment.adaptBind);
      this.lv.invalidateViews();
      this.lv.setBackgroundColor(-16777216);
      if ((this.bindes.size() == 1) && (((BindItem)this.bindes.get(0)).TargetDir.equals("empty")) && (((BindItem)this.bindes.get(0)).SourceDir.equals("empty")))
      {
        setContentView(this.lv);
        return;
      }
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        this.lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            paramAnonymousAdapterView = (BindItem)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
            paramAnonymousView = BinderWidgetConfigureActivity.this;
            BinderWidgetConfigureActivity.saveTitlePref(paramAnonymousView, BinderWidgetConfigureActivity.this.mAppWidgetId, paramAnonymousAdapterView.toString());
            BinderWidget.updateAppWidget(paramAnonymousView, AppWidgetManager.getInstance(paramAnonymousView), BinderWidgetConfigureActivity.this.mAppWidgetId);
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("appWidgetId", BinderWidgetConfigureActivity.this.mAppWidgetId);
            BinderWidgetConfigureActivity.this.setResult(-1, paramAnonymousAdapterView);
            BinderWidgetConfigureActivity.this.finish();
          }
        });
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/widgets/BinderWidgetConfigureActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */