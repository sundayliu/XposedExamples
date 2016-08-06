package com.android.vending.billing.InAppBillingService.LACK;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.android.vending.billing.InAppBillingService.LACK.dialogs.Progress_Dialog_2;
import com.chelpus.Utils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MenuItemAdapter
  extends BaseExpandableListAdapter
{
  public static final int TEXT_DEFAULT = 0;
  public static final int TEXT_LARGE = 2;
  public static final int TEXT_MEDIUM = 1;
  public static final int TEXT_SMALL = 0;
  public Context context = null;
  public MenuItem[] groups = new MenuItem[0];
  public ArrayList<View> groupsViews = null;
  private ImageView imgIcon;
  private int size;
  public Comparator<PkgListItem> sorter;
  
  public MenuItemAdapter(Context paramContext, int paramInt, List<MenuItem> paramList)
  {
    this.context = paramContext;
    this.size = paramInt;
    this.groups = ((MenuItem[])paramList.toArray(new MenuItem[paramList.size()]));
    listAppsFragment.menu_adapter = this;
  }
  
  public MenuItemAdapter(Context paramContext, List<MenuItem> paramList)
  {
    this.context = paramContext;
    this.size = 0;
    this.groups = ((MenuItem[])paramList.toArray(new MenuItem[paramList.size()]));
    listAppsFragment.menu_adapter = this;
  }
  
  private int getColor(int paramInt)
  {
    int i = Color.parseColor("#DDDDDD");
    switch (paramInt)
    {
    default: 
      return i;
    case 2131165243: 
      return Color.parseColor("#99cccc");
    case 2131165259: 
      return Color.parseColor("#99cccc");
    case 2131165724: 
      return Color.parseColor("#c2f055");
    case 2131165636: 
      return Color.parseColor("#c2f055");
    case 2131165413: 
      return Color.parseColor("#c2f055");
    case 2131165375: 
      return Color.parseColor("#cc99cc");
    case 2131165753: 
      return Color.parseColor("#cc99cc");
    case 2131165546: 
      return Color.parseColor("#cc99cc");
    case 2131165789: 
      return Color.parseColor("#cc99cc");
    case 2131165520: 
      return Color.parseColor("#cc99cc");
    case 2131165584: 
      return Color.parseColor("#ffffbb");
    case 2131165262: 
      return Color.parseColor("#c2f055");
    case 2131165638: 
      return Color.parseColor("#c2f055");
    case 2131165630: 
      return Color.parseColor("#fe6c00");
    case 2131165658: 
      return Color.parseColor("#ffffbb");
    case 2131165252: 
      return Color.parseColor("#c2f055");
    }
    return Color.parseColor("#fe6c00");
  }
  
  public void add(ArrayList<MenuItem> paramArrayList)
  {
    this.groups = ((MenuItem[])paramArrayList.toArray(new MenuItem[paramArrayList.size()]));
    notifyDataSetChanged();
  }
  
  public void clear()
  {
    this.groups = new MenuItem[0];
    this.groupsViews = null;
    notifyDataSetChanged();
  }
  
  public Integer getChild(int paramInt1, int paramInt2)
  {
    if ((this.groups == null) || (this.groups.length == 0)) {
      return null;
    }
    return (Integer)this.groups[paramInt1].childs.get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramView = getGroup(paramInt1);
    paramInt2 = getChild(paramInt1, paramInt2).intValue();
    switch (paramInt2)
    {
    default: 
      paramViewGroup = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130968604, null);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131558533);
      localTextView.setTextAppearance(this.context, listAppsFragment.getSizeText());
      localTextView.setTextAppearance(this.context, listAppsFragment.getSizeText());
      localTextView.setText(Utils.getText(paramInt2));
      ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131558532);
      localImageView.setImageDrawable(getImage(paramView.punkt_menu));
      paramInt1 = getColor(getGroup(paramInt1).punkt_menu);
      localImageView.setColorFilter(paramInt1, PorterDuff.Mode.MULTIPLY);
      localTextView.setTextColor(paramInt1);
      return paramViewGroup;
    case 1: 
      paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130968603, null);
      paramViewGroup = (RadioGroup)paramView.findViewById(2131558528);
      switch (listAppsFragment.getConfig().getInt("viewsize", 0))
      {
      }
      for (;;)
      {
        paramViewGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
          public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
          {
            switch (paramAnonymousInt)
            {
            default: 
              return;
            case 2131558529: 
              listAppsFragment.getConfig().edit().putInt("viewsize", 0).commit();
              listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
              listAppsFragment.runResume = true;
              return;
            case 2131558530: 
              listAppsFragment.getConfig().edit().putInt("viewsize", 1).commit();
              listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
              listAppsFragment.runResume = true;
              return;
            }
            listAppsFragment.getConfig().edit().putInt("viewsize", 2).commit();
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
          }
        });
        return paramView;
        ((RadioButton)paramViewGroup.findViewById(2131558529)).setChecked(true);
        continue;
        ((RadioButton)paramViewGroup.findViewById(2131558530)).setChecked(true);
        continue;
        ((RadioButton)paramViewGroup.findViewById(2131558531)).setChecked(true);
      }
    case 2: 
      paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130968600, null);
      paramViewGroup = (RadioGroup)paramView.findViewById(2131558516);
      switch (listAppsFragment.getConfig().getInt("orientstion", 3))
      {
      }
      for (;;)
      {
        paramViewGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
          public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
          {
            switch (paramAnonymousInt)
            {
            default: 
              return;
            case 2131558518: 
              listAppsFragment.getConfig().edit().putInt("orientstion", 2).commit();
              listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
              listAppsFragment.runResume = true;
              return;
            case 2131558519: 
              listAppsFragment.getConfig().edit().putInt("orientstion", 1).commit();
              listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
              listAppsFragment.runResume = true;
              return;
            }
            listAppsFragment.getConfig().edit().putInt("orientstion", 3).commit();
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
          }
        });
        return paramView;
        ((RadioButton)paramViewGroup.findViewById(2131558517)).setChecked(true);
        continue;
        ((RadioButton)paramViewGroup.findViewById(2131558519)).setChecked(true);
        continue;
        ((RadioButton)paramViewGroup.findViewById(2131558518)).setChecked(true);
      }
    case 3: 
      paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130968602, null);
      paramViewGroup = (RadioGroup)paramView.findViewById(2131558524);
      switch (listAppsFragment.getConfig().getInt("sortby", 2))
      {
      }
      for (;;)
      {
        paramViewGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
          public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
          {
            switch (paramAnonymousInt)
            {
            default: 
              return;
            case 2131558525: 
              listAppsFragment.getConfig().edit().putInt("sortby", 1).commit();
              listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
              listAppsFragment.runResume = true;
              return;
            case 2131558526: 
              listAppsFragment.getConfig().edit().putInt("sortby", 2).commit();
              listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
              listAppsFragment.runResume = true;
              return;
            }
            listAppsFragment.getConfig().edit().putInt("sortby", 3).commit();
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
          }
        });
        return paramView;
        ((RadioButton)paramViewGroup.findViewById(2131558525)).setChecked(true);
        continue;
        ((RadioButton)paramViewGroup.findViewById(2131558526)).setChecked(true);
        continue;
        ((RadioButton)paramViewGroup.findViewById(2131558527)).setChecked(true);
      }
    case 4: 
      paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130968595, null);
      paramViewGroup = (CheckBox)paramView.findViewById(2131558495);
      paramViewGroup.setChecked(listAppsFragment.getConfig().getBoolean("lvlapp", true));
      paramViewGroup.append(Utils.getColoredText("\n" + Utils.getText(2131165517), -7829368, ""));
      paramViewGroup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          listAppsFragment.getConfig().edit().putBoolean("lvlapp", paramAnonymousBoolean).commit();
          listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
          listAppsFragment.getConfig().edit().putBoolean("lang_change", true).commit();
          listAppsFragment.runResume = true;
        }
      });
      paramViewGroup = (CheckBox)paramView.findViewById(2131558496);
      paramViewGroup.setChecked(listAppsFragment.getConfig().getBoolean("adsapp", true));
      paramViewGroup.append(Utils.getColoredText("\n" + Utils.getText(2131165195), -7829368, ""));
      paramViewGroup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          listAppsFragment.getConfig().edit().putBoolean("adsapp", paramAnonymousBoolean).commit();
          listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
          listAppsFragment.getConfig().edit().putBoolean("lang_change", true).commit();
          listAppsFragment.runResume = true;
        }
      });
      paramViewGroup = (CheckBox)paramView.findViewById(2131558497);
      paramViewGroup.setChecked(listAppsFragment.getConfig().getBoolean("customapp", true));
      paramViewGroup.append(Utils.getColoredText("\n" + Utils.getText(2131165400), -7829368, ""));
      paramViewGroup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          listAppsFragment.getConfig().edit().putBoolean("customapp", paramAnonymousBoolean).commit();
          listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
          listAppsFragment.getConfig().edit().putBoolean("lang_change", true).commit();
          listAppsFragment.runResume = true;
        }
      });
      paramViewGroup = (CheckBox)paramView.findViewById(2131558498);
      paramViewGroup.setChecked(listAppsFragment.getConfig().getBoolean("modifapp", true));
      paramViewGroup.append(Utils.getColoredText("\n" + Utils.getText(2131165551), -7829368, ""));
      paramViewGroup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          listAppsFragment.getConfig().edit().putBoolean("modifapp", paramAnonymousBoolean).commit();
          listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
          listAppsFragment.getConfig().edit().putBoolean("lang_change", true).commit();
          listAppsFragment.runResume = true;
        }
      });
      paramViewGroup = (CheckBox)paramView.findViewById(2131558499);
      paramViewGroup.setChecked(listAppsFragment.getConfig().getBoolean("fixedapp", true));
      paramViewGroup.append(Utils.getColoredText("\n" + Utils.getText(2131165474), -7829368, ""));
      paramViewGroup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          listAppsFragment.getConfig().edit().putBoolean("fixedapp", paramAnonymousBoolean).commit();
          listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
          listAppsFragment.getConfig().edit().putBoolean("lang_change", true).commit();
          listAppsFragment.runResume = true;
        }
      });
      paramViewGroup = (CheckBox)paramView.findViewById(2131558500);
      paramViewGroup.setChecked(listAppsFragment.getConfig().getBoolean("noneapp", true));
      paramViewGroup.append(Utils.getColoredText("\n" + Utils.getText(2131165574), -7829368, ""));
      paramViewGroup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          listAppsFragment.getConfig().edit().putBoolean("noneapp", paramAnonymousBoolean).commit();
          listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
          listAppsFragment.getConfig().edit().putBoolean("lang_change", true).commit();
          listAppsFragment.runResume = true;
        }
      });
      paramViewGroup = (CheckBox)paramView.findViewById(2131558501);
      paramViewGroup.setChecked(listAppsFragment.getConfig().getBoolean("systemapp", false));
      paramViewGroup.append(Utils.getColoredText("\n" + Utils.getText(2131165715), -7829368, ""));
      paramViewGroup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          listAppsFragment.getConfig().edit().putBoolean("systemapp", paramAnonymousBoolean).commit();
          listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
          listAppsFragment.getConfig().edit().putBoolean("lang_change", true).commit();
          listAppsFragment.runResume = true;
        }
      });
      return paramView;
    case 5: 
      paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130968601, null);
      paramViewGroup = (RadioGroup)paramView.findViewById(2131558520);
      switch (listAppsFragment.getConfig().getInt("root_force", 0))
      {
      }
      for (;;)
      {
        paramViewGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
          public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
          {
            switch (paramAnonymousInt)
            {
            default: 
              return;
            case 2131558521: 
              listAppsFragment.getConfig().edit().putInt("root_force", 0).commit();
              listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
              listAppsFragment.runResume = true;
              return;
            case 2131558522: 
              listAppsFragment.getConfig().edit().putInt("root_force", 1).commit();
              listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
              listAppsFragment.runResume = true;
              return;
            }
            listAppsFragment.getConfig().edit().putInt("root_force", 2).commit();
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
          }
        });
        return paramView;
        ((RadioButton)paramViewGroup.findViewById(2131558521)).setChecked(true);
        continue;
        ((RadioButton)paramViewGroup.findViewById(2131558522)).setChecked(true);
        continue;
        ((RadioButton)paramViewGroup.findViewById(2131558523)).setChecked(true);
      }
    case 6: 
      paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130968599, null);
      paramViewGroup = (RadioGroup)paramView.findViewById(2131558513);
      switch (listAppsFragment.getConfig().getInt("apkname", 1))
      {
      }
      for (;;)
      {
        paramViewGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
          public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
          {
            switch (paramAnonymousInt)
            {
            default: 
              return;
            case 2131558514: 
              listAppsFragment.getConfig().edit().putInt("apkname", 0).commit();
              listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
              listAppsFragment.runResume = true;
              return;
            }
            listAppsFragment.getConfig().edit().putInt("apkname", 1).commit();
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
          }
        });
        return paramView;
        ((RadioButton)paramViewGroup.findViewById(2131558514)).setChecked(true);
        continue;
        ((RadioButton)paramViewGroup.findViewById(2131558515)).setChecked(true);
      }
    }
    paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130968598, null);
    paramViewGroup = (RadioGroup)paramView.findViewById(2131558504);
    switch (listAppsFragment.getConfig().getInt("default_icon_for_lp", 0))
    {
    }
    for (;;)
    {
      paramViewGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 2131558505: 
            listAppsFragment.getConfig().edit().putInt("default_icon_for_lp", 0).commit();
            listAppsFragment.frag.runToMain(new Runnable()
            {
              public void run()
              {
                listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                listAppsFragment.showDialogLP(11);
                listAppsFragment.progress2.setCancelable(false);
                listAppsFragment.progress2.setMessage(Utils.getText(2131165747));
              }
            });
            Utils.setIcon(0);
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
            return;
          case 2131558506: 
            listAppsFragment.getConfig().edit().putInt("default_icon_for_lp", 1).commit();
            listAppsFragment.frag.runToMain(new Runnable()
            {
              public void run()
              {
                listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                listAppsFragment.showDialogLP(11);
                listAppsFragment.progress2.setCancelable(false);
                listAppsFragment.progress2.setMessage(Utils.getText(2131165747));
              }
            });
            Utils.setIcon(1);
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
            return;
          case 2131558507: 
            listAppsFragment.getConfig().edit().putInt("default_icon_for_lp", 2).commit();
            listAppsFragment.frag.runToMain(new Runnable()
            {
              public void run()
              {
                listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                listAppsFragment.showDialogLP(11);
                listAppsFragment.progress2.setCancelable(false);
                listAppsFragment.progress2.setMessage(Utils.getText(2131165747));
              }
            });
            Utils.setIcon(2);
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
            return;
          case 2131558508: 
            listAppsFragment.getConfig().edit().putInt("default_icon_for_lp", 3).commit();
            listAppsFragment.frag.runToMain(new Runnable()
            {
              public void run()
              {
                listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                listAppsFragment.showDialogLP(11);
                listAppsFragment.progress2.setCancelable(false);
                listAppsFragment.progress2.setMessage(Utils.getText(2131165747));
              }
            });
            Utils.setIcon(3);
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
            return;
          case 2131558509: 
            listAppsFragment.getConfig().edit().putInt("default_icon_for_lp", 4).commit();
            listAppsFragment.frag.runToMain(new Runnable()
            {
              public void run()
              {
                listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                listAppsFragment.showDialogLP(11);
                listAppsFragment.progress2.setCancelable(false);
                listAppsFragment.progress2.setMessage(Utils.getText(2131165747));
              }
            });
            Utils.setIcon(4);
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
            return;
          case 2131558510: 
            listAppsFragment.getConfig().edit().putInt("default_icon_for_lp", 5).commit();
            listAppsFragment.frag.runToMain(new Runnable()
            {
              public void run()
              {
                listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                listAppsFragment.showDialogLP(11);
                listAppsFragment.progress2.setCancelable(false);
                listAppsFragment.progress2.setMessage(Utils.getText(2131165747));
              }
            });
            Utils.setIcon(5);
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
            return;
          case 2131558511: 
            listAppsFragment.getConfig().edit().putInt("default_icon_for_lp", 5).commit();
            listAppsFragment.frag.runToMain(new Runnable()
            {
              public void run()
              {
                listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                listAppsFragment.showDialogLP(11);
                listAppsFragment.progress2.setCancelable(false);
                listAppsFragment.progress2.setMessage(Utils.getText(2131165747));
              }
            });
            Utils.setIcon(6);
            listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
            listAppsFragment.runResume = true;
            return;
          }
          listAppsFragment.getConfig().edit().putInt("default_icon_for_lp", 5).commit();
          listAppsFragment.frag.runToMain(new Runnable()
          {
            public void run()
            {
              listAppsFragment locallistAppsFragment = listAppsFragment.frag;
              listAppsFragment.showDialogLP(11);
              listAppsFragment.progress2.setCancelable(false);
              listAppsFragment.progress2.setMessage(Utils.getText(2131165747));
            }
          });
          Utils.setIcon(7);
          listAppsFragment.getConfig().edit().putBoolean("settings_change", true).commit();
          listAppsFragment.runResume = true;
        }
      });
      return paramView;
      ((RadioButton)paramViewGroup.findViewById(2131558505)).setChecked(true);
      continue;
      ((RadioButton)paramViewGroup.findViewById(2131558506)).setChecked(true);
      continue;
      ((RadioButton)paramViewGroup.findViewById(2131558507)).setChecked(true);
      continue;
      ((RadioButton)paramViewGroup.findViewById(2131558508)).setChecked(true);
      continue;
      ((RadioButton)paramViewGroup.findViewById(2131558509)).setChecked(true);
      continue;
      ((RadioButton)paramViewGroup.findViewById(2131558510)).setChecked(true);
      continue;
      ((RadioButton)paramViewGroup.findViewById(2131558511)).setChecked(true);
      continue;
      ((RadioButton)paramViewGroup.findViewById(2131558512)).setChecked(true);
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if ((this.groups == null) || (this.groups.length == 0)) {
      return 0;
    }
    return this.groups[paramInt].childs.size();
  }
  
  public MenuItem getGroup(int paramInt)
  {
    return this.groups[paramInt];
  }
  
  public int getGroupCount()
  {
    if ((this.groups == null) || (this.groups.length == 0)) {
      return 0;
    }
    return this.groups.length;
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    MenuItem localMenuItem = getGroup(paramInt);
    int j = localMenuItem.punkt_menu;
    Object localObject;
    int i;
    try
    {
      paramView = (View)this.groupsViews.get(paramInt);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramView = (LayoutInflater)this.context.getSystemService("layout_inflater");
        switch (localMenuItem.type)
        {
        default: 
          paramView = paramView.inflate(2130968620, null);
          paramViewGroup = paramView;
          if (this.groupsViews == null)
          {
            this.groupsViews = new ArrayList(this.size);
            localObject = this.groups;
            int k = localObject.length;
            i = 0;
            for (;;)
            {
              paramViewGroup = paramView;
              if (i >= k) {
                break;
              }
              paramViewGroup = localObject[i];
              this.groupsViews.add(null);
              i += 1;
            }
          }
          break;
        }
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = null;
        continue;
        paramView = paramView.inflate(2130968619, null);
      }
      paramViewGroup.setClickable(false);
      switch (localMenuItem.type)
      {
      }
    }
    if (localMenuItem.punkt_menu_descr != 0)
    {
      paramView = (TextView)paramViewGroup.findViewById(2131558593);
      paramView.setText(Utils.getText(localMenuItem.punkt_menu_descr));
      paramView.setTextColor(-3355444);
    }
    for (;;)
    {
      this.groupsViews.set(paramInt, paramViewGroup);
      return paramViewGroup;
      paramView = (TextView)paramViewGroup.findViewById(2131558592);
      paramView.setTextAppearance(this.context, listAppsFragment.getSizeText());
      paramView.setTextAppearance(this.context, listAppsFragment.getSizeText());
      paramView.setText(Utils.getText(j));
      paramView.setTypeface(paramView.getTypeface(), 1);
      localObject = (ImageView)paramViewGroup.findViewById(2131558591);
      ((ImageView)localObject).setImageDrawable(getImage(j));
      ((ImageView)localObject).setVisibility(0);
      i = getColor(j);
      paramView.setTextColor(i);
      ((ImageView)localObject).setColorFilter(i, PorterDuff.Mode.MULTIPLY);
      break;
      ((LinearLayout)paramViewGroup.findViewById(2131558595)).setPadding(10, 5, 50, 5);
      paramView = (TextView)paramViewGroup.findViewById(2131558592);
      paramView.setTextAppearance(this.context, listAppsFragment.getSizeText());
      paramView.setTextAppearance(this.context, listAppsFragment.getSizeText());
      paramView.setTextColor(Color.parseColor("#000000"));
      paramView.setTypeface(paramView.getTypeface(), 1);
      ((ImageView)paramViewGroup.findViewById(2131558591)).setVisibility(8);
      paramViewGroup.setBackgroundColor(Color.parseColor("#9F9F9F"));
      paramView.setText(Utils.getText(j));
      break;
      paramView = (TextView)paramViewGroup.findViewById(2131558592);
      paramView.setTextAppearance(this.context, listAppsFragment.getSizeText());
      paramView.setTextAppearance(this.context, listAppsFragment.getSizeText());
      paramView.setText(Utils.getText(j));
      paramView.setTypeface(paramView.getTypeface(), 1);
      paramView.setTextColor(Color.parseColor("#feeb9c"));
      paramView = (ImageView)paramViewGroup.findViewById(2131558591);
      paramView.setImageDrawable(getImage(j));
      paramView.setVisibility(0);
      break;
      paramView = (TextView)paramViewGroup.findViewById(2131558592);
      paramView.setTextAppearance(this.context, listAppsFragment.getSizeText());
      paramView.setTextAppearance(this.context, listAppsFragment.getSizeText());
      paramView.setText(Utils.getText(j));
      paramView.setTypeface(paramView.getTypeface(), 1);
      paramView.setTextColor(Color.parseColor("#feeb9c"));
      paramView = (ImageView)paramViewGroup.findViewById(2131558591);
      localObject = (CheckBox)paramViewGroup.findViewById(2131558594);
      ((CheckBox)localObject).setChecked(listAppsFragment.getConfig().getBoolean(localMenuItem.booleanPref, localMenuItem.booleanPrefDef));
      ((CheckBox)localObject).setClickable(false);
      paramView.setImageDrawable(getImage(j));
      paramView.setVisibility(0);
      break;
      ((TextView)paramViewGroup.findViewById(2131558593)).setVisibility(8);
    }
  }
  
  Drawable getImage(int paramInt)
  {
    Drawable localDrawable;
    switch (paramInt)
    {
    default: 
      return null;
    case 2131165211: 
      return listAppsFragment.getRes().getDrawable(2130837568);
    case 2131165243: 
      localDrawable = listAppsFragment.getRes().getDrawable(2130837505);
      localDrawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
      return localDrawable;
    case 2131165259: 
      return listAppsFragment.getRes().getDrawable(2130837505);
    case 2131165724: 
      return listAppsFragment.getRes().getDrawable(2130837530);
    case 2131165279: 
      return listAppsFragment.getRes().getDrawable(2130837505);
    case 2131165291: 
      return listAppsFragment.getRes().getDrawable(2130837530);
    case 2131165375: 
      localDrawable = listAppsFragment.getRes().getDrawable(2130837504);
      localDrawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
      return localDrawable;
    case 2131165753: 
      localDrawable = listAppsFragment.getRes().getDrawable(2130837504);
      localDrawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
      return localDrawable;
    case 2131165513: 
      localDrawable = listAppsFragment.getRes().getDrawable(2130837504);
      localDrawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
      return localDrawable;
    case 2131165514: 
      localDrawable = listAppsFragment.getRes().getDrawable(2130837504);
      localDrawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
      return localDrawable;
    case 2131165226: 
      localDrawable = listAppsFragment.getRes().getDrawable(2130837504);
      localDrawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
      return localDrawable;
    case 2131165227: 
      localDrawable = listAppsFragment.getRes().getDrawable(2130837504);
      localDrawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
      return localDrawable;
    case 2131165636: 
      localDrawable = listAppsFragment.getRes().getDrawable(2130837504);
      localDrawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
      return localDrawable;
    case 2131165413: 
      return listAppsFragment.getRes().getDrawable(2130837540);
    case 2131165789: 
      return listAppsFragment.getRes().getDrawable(2130837541);
    case 2131165520: 
      return listAppsFragment.getRes().getDrawable(2130837541);
    case 2131165546: 
      return listAppsFragment.getRes().getDrawable(2130837541);
    case 2131165584: 
      return listAppsFragment.getRes().getDrawable(2130837535);
    case 2131165638: 
      return listAppsFragment.getRes().getDrawable(2130837530);
    case 2131165252: 
      return listAppsFragment.getRes().getDrawable(2130837530);
    case 2131165658: 
      localDrawable = listAppsFragment.getRes().getDrawable(2130837505);
      localDrawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
      return localDrawable;
    case 2131165630: 
      return listAppsFragment.getRes().getDrawable(2130837538);
    case 2131165718: 
      return listAppsFragment.getRes().getDrawable(2130903045);
    case 2131165590: 
      return listAppsFragment.getRes().getDrawable(2130903045);
    case 2131165677: 
      return listAppsFragment.getRes().getDrawable(2130903045);
    case 2131165456: 
      return listAppsFragment.getRes().getDrawable(2130903041);
    case 2131165509: 
      return listAppsFragment.getRes().getDrawable(2130903041);
    case 2131165666: 
      return listAppsFragment.getRes().getDrawable(2130903045);
    case 2131165411: 
      return listAppsFragment.getRes().getDrawable(2130903043);
    case 2131165404: 
      return listAppsFragment.getRes().getDrawable(2130903043);
    case 2131165663: 
      return listAppsFragment.getRes().getDrawable(2130903042);
    case 2131165453: 
      return listAppsFragment.getRes().getDrawable(2130903042);
    case 2131165565: 
      return listAppsFragment.getRes().getDrawable(2130903042);
    case 2131165200: 
      return listAppsFragment.getRes().getDrawable(2130903045);
    case 2131165249: 
      return listAppsFragment.getRes().getDrawable(2130903045);
    case 2131165486: 
      return listAppsFragment.getRes().getDrawable(2130903042);
    case 2131165488: 
      return listAppsFragment.getRes().getDrawable(2130903042);
    case 2131165415: 
      return listAppsFragment.getRes().getDrawable(2130903042);
    case 2131165738: 
      return listAppsFragment.getRes().getDrawable(2130903042);
    case 2131165483: 
      return listAppsFragment.getRes().getDrawable(2130903044);
    case 2131165734: 
      return listAppsFragment.getRes().getDrawable(2130903044);
    case 2131165657: 
      return listAppsFragment.getRes().getDrawable(2130903044);
    }
    return listAppsFragment.getRes().getDrawable(2130903044);
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onGroupCollapsed(int paramInt)
  {
    super.onGroupCollapsed(paramInt);
  }
  
  public void onGroupExpanded(int paramInt)
  {
    super.onGroupExpanded(paramInt);
  }
  
  public void setTextSize(int paramInt)
  {
    this.size = paramInt;
    notifyDataSetChanged();
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/MenuItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */