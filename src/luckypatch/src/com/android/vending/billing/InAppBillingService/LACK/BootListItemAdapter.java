package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.chelpus.Utils;
import java.util.Comparator;
import java.util.List;

public class BootListItemAdapter
  extends ArrayAdapter<PkgListItem>
{
  public static final int TEXT_DEFAULT = 0;
  public static final int TEXT_LARGE = 2;
  public static final int TEXT_MEDIUM = 1;
  public static final int TEXT_SMALL = 0;
  Context context;
  List<PkgListItem> data;
  ImageView imgIcon;
  int layoutResourceId;
  int size;
  public Comparator<PkgListItem> sorter;
  TextView txtStatus;
  TextView txtTitle;
  
  public BootListItemAdapter(Context paramContext, int paramInt1, int paramInt2, List<PkgListItem> paramList)
  {
    super(paramContext, paramInt1, paramList);
    this.context = paramContext;
    this.layoutResourceId = paramInt1;
    this.size = paramInt2;
  }
  
  public BootListItemAdapter(Context paramContext, int paramInt, List<PkgListItem> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.context = paramContext;
    this.layoutResourceId = paramInt;
    this.size = 0;
    this.data = paramList;
  }
  
  public PkgListItem getItem(String paramString)
  {
    int i = 0;
    while (i < getCount())
    {
      if (((PkgListItem)getItem(i)).pkgName.contentEquals(paramString)) {
        return (PkgListItem)getItem(i);
      }
      i += 1;
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PkgListItem localPkgListItem = (PkgListItem)getItem(paramInt);
    paramViewGroup.setBackgroundColor(-16777216);
    if ((localPkgListItem.name != null) && (!localPkgListItem.boot_ads) && (!localPkgListItem.boot_custom) && (!localPkgListItem.boot_lvl) && (!localPkgListItem.boot_manual)) {
      return new View(this.context);
    }
    View localView = ((Activity)this.context).getLayoutInflater().inflate(this.layoutResourceId, paramViewGroup, false);
    localView.setBackgroundColor(-16777216);
    this.txtTitle = ((TextView)localView.findViewById(2131558483));
    this.txtStatus = ((TextView)localView.findViewById(2131558484));
    this.imgIcon = ((ImageView)localView.findViewById(2131558461));
    this.txtTitle.setText(localPkgListItem.name);
    this.imgIcon.setMaxHeight(1);
    this.imgIcon.setMaxWidth(1);
    try
    {
      this.imgIcon.setImageDrawable(listAppsFragment.getPkgMng().getApplicationIcon(localPkgListItem.pkgName));
      this.txtTitle.setTextAppearance(this.context, listAppsFragment.getSizeText());
      this.txtStatus.setTextAppearance(this.context, listAppsFragment.getSizeText());
      this.txtTitle.setTextColor(-7829368);
      paramViewGroup = "";
      Resources localResources = listAppsFragment.getRes();
      if (localPkgListItem.boot_ads)
      {
        paramViewGroup = "" + localResources.getString(2131165678) + "; ";
        this.txtTitle.setTextColor(-16711681);
      }
      paramView = paramViewGroup;
      if (localPkgListItem.boot_lvl)
      {
        paramView = paramViewGroup + localResources.getString(2131165680) + "; ";
        this.txtTitle.setTextColor(-16711936);
      }
      paramViewGroup = paramView;
      if (localPkgListItem.boot_custom)
      {
        paramViewGroup = paramView + localResources.getString(2131165679) + "; ";
        this.txtTitle.setTextColor(65280);
      }
      this.txtStatus.setText(paramViewGroup);
      if (localPkgListItem.pkgName.equals(Utils.getText(2131165754)))
      {
        this.imgIcon.setImageResource(2130837551);
        this.txtStatus.setText(Utils.getText(2131165755));
      }
      this.txtStatus.setTextAppearance(this.context, 16973894);
      this.txtStatus.setTextColor(-7829368);
      this.txtTitle.setBackgroundColor(-16777216);
      this.txtStatus.setBackgroundColor(-16777216);
      return localView;
    }
    catch (PackageManager.NameNotFoundException paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setTextSize(int paramInt)
  {
    this.size = paramInt;
    notifyDataSetChanged();
  }
  
  public void sort()
  {
    super.sort(this.sorter);
    notifyDataSetChanged();
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/BootListItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */