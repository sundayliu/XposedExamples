package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;

public class HelpActivity
  extends Activity
{
  public Context context;
  LocalActivityManager mLocalActivityManager;
  TabHost tabHost;
  
  private static View createTabView(Context paramContext, String paramString)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130968638, null);
    ((TextView)paramContext.findViewById(2131558643)).setText(paramString);
    return paramContext;
  }
  
  private void initTabs(Bundle paramBundle)
  {
    Object localObject2 = getResources();
    this.tabHost = ((TabHost)findViewById(16908306));
    this.mLocalActivityManager = new LocalActivityManager(this, false);
    this.mLocalActivityManager.dispatchCreate(paramBundle);
    this.tabHost.setup(this.mLocalActivityManager);
    paramBundle = (TabHost)findViewById(16908306);
    paramBundle.getTabWidget().setDividerDrawable(2130837590);
    Object localObject1 = createTabView(paramBundle.getContext(), ((Resources)localObject2).getString(2131165484));
    localObject2 = createTabView(paramBundle.getContext(), ((Resources)localObject2).getString(2131165485));
    Intent localIntent = new Intent().setClass(this, HelpCommon.class);
    paramBundle.addTab(paramBundle.newTabSpec("Common").setIndicator((View)localObject1).setContent(localIntent));
    localObject1 = new Intent().setClass(this, HelpCustom.class);
    paramBundle.addTab(paramBundle.newTabSpec("Create").setIndicator((View)localObject2).setContent((Intent)localObject1));
    paramBundle.setCurrentTab(0);
    paramBundle.getTabWidget().setCurrentTab(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968621);
    initTabs(paramBundle);
  }
  
  protected void onPause()
  {
    this.mLocalActivityManager.dispatchPause(isFinishing());
    super.onPause();
  }
  
  protected void onResume()
  {
    this.mLocalActivityManager.dispatchResume();
    super.onResume();
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/HelpActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */