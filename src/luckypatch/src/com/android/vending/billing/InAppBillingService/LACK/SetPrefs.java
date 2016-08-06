package com.android.vending.billing.InAppBillingService.LACK;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SetPrefs
  extends PreferenceActivity
{
  public Context context;
  Preference.OnPreferenceChangeListener numberCheckListener = new Preference.OnPreferenceChangeListener()
  {
    public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
    {
      SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 4);
      if ((paramAnonymousPreference == SetPrefs.this.findPreference("days_on_up")) && (SetPrefs.this.numberCheck(paramAnonymousObject)))
      {
        localSharedPreferences.edit().putInt("days_on_up", Integer.valueOf(paramAnonymousObject.toString()).intValue()).commit();
        paramAnonymousPreference.getEditor().putString("days_on_up", paramAnonymousObject.toString());
        localSharedPreferences.edit().putBoolean("settings_change", true).commit();
        localSharedPreferences.edit().putBoolean("lang_change", true).commit();
        return true;
      }
      return false;
    }
  };
  
  public static void copyFolder(File paramFile1, File paramFile2)
    throws IOException
  {
    if (paramFile1.isDirectory())
    {
      paramFile1.renameTo(paramFile2);
      String[] arrayOfString = paramFile1.list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          copyFolder(new File(paramFile1, str), new File(paramFile2, str));
          i += 1;
        }
      }
    }
    else
    {
      paramFile1.renameTo(paramFile2);
    }
  }
  
  private boolean numberCheck(Object paramObject)
  {
    if ((!paramObject.toString().equals("")) && (paramObject.toString().matches("\\d*"))) {
      return true;
    }
    showMessage(this, Utils.getText(2131165748), Utils.getText(2131165506));
    return false;
  }
  
  private void showMessage(final Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new Dialog(paramContext);
    paramContext.setTitle(paramString1);
    paramContext.setContentView(2130968625);
    ((TextView)paramContext.findViewById(2131558571)).setText(paramString2);
    ((Button)paramContext.findViewById(2131558569)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramContext.dismiss();
      }
    });
    paramContext.show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.context = this;
    SharedPreferences localSharedPreferences1 = listAppsFragment.getInstance().getSharedPreferences("config", 0);
    SharedPreferences localSharedPreferences2 = listAppsFragment.getInstance().getSharedPreferences("SetPrefs", 0);
    paramBundle = listAppsFragment.getInstance().getSharedPreferences("config", 0).edit();
    paramBundle.putBoolean("Update0", true);
    paramBundle.commit();
    Object localObject = localSharedPreferences1.getString("force_language", "default");
    if (((String)localObject).equals("default"))
    {
      paramBundle = Resources.getSystem().getConfiguration().locale;
      Locale.setDefault(Locale.getDefault());
      localObject = new Configuration();
      ((Configuration)localObject).locale = paramBundle;
      listAppsFragment.getRes().updateConfiguration((Configuration)localObject, listAppsFragment.getRes().getDisplayMetrics());
    }
    for (;;)
    {
      if (localSharedPreferences1.getInt("orientstion", 3) == 1) {
        setRequestedOrientation(0);
      }
      if (localSharedPreferences1.getInt("orientstion", 3) == 2) {
        setRequestedOrientation(1);
      }
      if (localSharedPreferences1.getInt("orientstion", 3) == 3) {
        setRequestedOrientation(4);
      }
      paramBundle = getPreferenceManager();
      paramBundle.setSharedPreferencesName("SetPrefs");
      paramBundle.setSharedPreferencesMode(0);
      localSharedPreferences2.edit().putString("viewsize", "" + localSharedPreferences1.getInt("viewsize", 0)).commit();
      localSharedPreferences2.edit().putString("root_force", "" + localSharedPreferences1.getInt("root_force", 0)).commit();
      localSharedPreferences2.edit().putBoolean("confirm_exit", localSharedPreferences1.getBoolean("confirm_exit", true)).commit();
      localSharedPreferences2.edit().putString("orientstion", "" + localSharedPreferences1.getInt("orientstion", 3)).commit();
      localSharedPreferences2.edit().putString("sortby", "" + localSharedPreferences1.getInt("sortby", 2)).commit();
      localSharedPreferences2.edit().putString("language", "" + localSharedPreferences1.getInt("language", 1)).commit();
      localSharedPreferences2.edit().putBoolean("systemapp", localSharedPreferences1.getBoolean("systemapp", false)).commit();
      localSharedPreferences2.edit().putString("apkname", "" + localSharedPreferences1.getInt("apkname", 0)).commit();
      localSharedPreferences2.edit().putBoolean("lvlapp", localSharedPreferences1.getBoolean("lvlapp", true)).commit();
      localSharedPreferences2.edit().putBoolean("adsapp", localSharedPreferences1.getBoolean("adsapp", true)).commit();
      localSharedPreferences2.edit().putBoolean("customapp", localSharedPreferences1.getBoolean("customapp", true)).commit();
      localSharedPreferences2.edit().putBoolean("modifapp", localSharedPreferences1.getBoolean("modifapp", true)).commit();
      localSharedPreferences2.edit().putBoolean("hide_notify", localSharedPreferences1.getBoolean("hide_notify", false)).commit();
      localSharedPreferences2.edit().putBoolean("fixedapp", localSharedPreferences1.getBoolean("fixedapp", true)).commit();
      localSharedPreferences2.edit().putBoolean("noneapp", localSharedPreferences1.getBoolean("noneapp", true)).commit();
      localSharedPreferences2.edit().putString("path", localSharedPreferences1.getString("basepath", "Noting")).commit();
      localSharedPreferences2.edit().putString("extStorageDirectory", localSharedPreferences1.getString("extStorageDirectory", "Noting")).commit();
      localSharedPreferences2.edit().putBoolean("vibration", localSharedPreferences1.getBoolean("vibration", false)).commit();
      localSharedPreferences2.edit().putBoolean("disable_autoupdate", localSharedPreferences1.getBoolean("disable_autoupdate", false)).commit();
      localSharedPreferences2.edit().putBoolean("fast_start", localSharedPreferences1.getBoolean("fast_start", false)).commit();
      localSharedPreferences2.edit().putBoolean("no_icon", localSharedPreferences1.getBoolean("no_icon", false)).commit();
      localSharedPreferences2.edit().putBoolean("hide_title", localSharedPreferences1.getBoolean("hide_title", false)).commit();
      localSharedPreferences2.edit().putString("days_on_up", "" + localSharedPreferences1.getInt("days_on_up", 1)).commit();
      addPreferencesFromResource(2131034117);
      getPreferenceScreen().findPreference("days_on_up").setOnPreferenceChangeListener(this.numberCheckListener);
      findPreference("viewsize").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("viewsize")) && (paramAnonymousObject.equals("2")))
          {
            localSharedPreferences.edit().putInt("viewsize", 2).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("viewsize")) && (paramAnonymousObject.equals("1")))
          {
            localSharedPreferences.edit().putInt("viewsize", 1).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("viewsize")) && (paramAnonymousObject.equals("0")))
          {
            localSharedPreferences.edit().putInt("viewsize", 0).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("root_force").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("root_force")) && (paramAnonymousObject.equals("2")))
          {
            listAppsFragment.su = false;
            localSharedPreferences.edit().putInt("root_force", 2).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("root_force")) && (paramAnonymousObject.equals("1")))
          {
            listAppsFragment.su = true;
            localSharedPreferences.edit().putInt("root_force", 1).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("root_force")) && (paramAnonymousObject.equals("0")))
          {
            localSharedPreferences.edit().putInt("root_force", 0).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("orientstion").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("orientstion")) && (paramAnonymousObject.equals("2")))
          {
            localSharedPreferences.edit().putInt("orientstion", 3).commit();
            SetPrefs.this.setRequestedOrientation(1);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("orientstion")) && (paramAnonymousObject.equals("1")))
          {
            localSharedPreferences.edit().putInt("orientstion", 1).commit();
            SetPrefs.this.setRequestedOrientation(0);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("orientstion")) && (paramAnonymousObject.equals("3")))
          {
            localSharedPreferences.edit().putInt("orientstion", 3).commit();
            SetPrefs.this.setRequestedOrientation(4);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("sortby").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("sortby")) && (paramAnonymousObject.equals("1")))
          {
            localSharedPreferences.edit().putInt("sortby", 1).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("sortby")) && (paramAnonymousObject.equals("3")))
          {
            localSharedPreferences.edit().putInt("sortby", 3).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("sortby")) && (paramAnonymousObject.equals("2")))
          {
            localSharedPreferences.edit().putInt("sortby", 2).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("language").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("language")) && (paramAnonymousObject.equals("1")))
          {
            paramAnonymousPreference = Resources.getSystem().getConfiguration().locale;
            Locale.setDefault(Locale.getDefault());
            paramAnonymousObject = new Configuration();
            ((Configuration)paramAnonymousObject).locale = paramAnonymousPreference;
            listAppsFragment.getRes().updateConfiguration((Configuration)paramAnonymousObject, listAppsFragment.getRes().getDisplayMetrics());
            localSharedPreferences.edit().putInt("language", 1).commit();
            paramAnonymousPreference = SetPrefs.this.getIntent();
            paramAnonymousPreference.addFlags(131072);
            SetPrefs.this.finish();
            SetPrefs.this.startActivity(paramAnonymousPreference);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("language")) && (paramAnonymousObject.equals("2")))
          {
            paramAnonymousPreference = new Locale("en");
            Locale.setDefault(paramAnonymousPreference);
            paramAnonymousObject = new Configuration();
            ((Configuration)paramAnonymousObject).locale = paramAnonymousPreference;
            listAppsFragment.getRes().updateConfiguration((Configuration)paramAnonymousObject, listAppsFragment.getRes().getDisplayMetrics());
            localSharedPreferences.edit().putInt("language", 2).commit();
            paramAnonymousPreference = SetPrefs.this.getIntent();
            paramAnonymousPreference.addFlags(131072);
            SetPrefs.this.finish();
            SetPrefs.this.startActivity(paramAnonymousPreference);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("systemapp").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("systemapp")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("systemapp", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("systemapp", true);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("systemapp")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("systemapp", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("systemapp", false);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("confirm_exit").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("confirm_exit")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("confirm_exit", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("confirm_exit", true);
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("confirm_exit")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("confirm_exit", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("confirm_exit", false);
            return true;
          }
          return false;
        }
      });
      findPreference("apkname").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("apkname")) && (paramAnonymousObject.equals("0")))
          {
            localSharedPreferences.edit().putInt("apkname", 0).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("apkname")) && (paramAnonymousObject.equals("1")))
          {
            localSharedPreferences.edit().putInt("apkname", 1).commit();
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("lvlapp").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("lvlapp")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("lvlapp", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("lvlapp", true);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("lvlapp")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("lvlapp", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("lvlapp", false);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("adsapp").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("adsapp")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("adsapp", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("adsapp", true);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("adsapp")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("adsapp", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("adsapp", false);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("customapp").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("customapp")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("customapp", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("customapp", true);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("customapp")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("customapp", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("customapp", false);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("modifapp").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("modifapp")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("modifapp", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("modifapp", true);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("modifapp")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("modifapp", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("modifapp", false);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("fixedapp").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("fixedapp")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("fixedapp", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("fixedapp", true);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("fixedapp")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("fixedapp", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("fixedapp", false);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("noneapp").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("noneapp")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("noneapp", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("noneapp", true);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("noneapp")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("noneapp", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("noneapp", false);
            localSharedPreferences.edit().putBoolean("settings_change", true).commit();
            localSharedPreferences.edit().putBoolean("lang_change", true).commit();
            return true;
          }
          return false;
        }
      });
      findPreference("hide_notify").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("hide_notify")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("hide_notify", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("hide_notify", true);
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("hide_notify")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("hide_notify", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("hide_notify", false);
            return true;
          }
          return false;
        }
      });
      findPreference("vibration").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("vibration")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("vibration", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("vibration", true);
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("vibration")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("vibration", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("vibration", false);
            return true;
          }
          return false;
        }
      });
      findPreference("disable_autoupdate").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("disable_autoupdate")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("disable_autoupdate", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("disable_autoupdate", true);
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("disable_autoupdate")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("disable_autoupdate", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("disable_autoupdate", false);
            return true;
          }
          return false;
        }
      });
      findPreference("fast_start").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("fast_start")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("fast_start", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("fast_start", true);
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("fast_start")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("fast_start", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("fast_start", false);
            return true;
          }
          return false;
        }
      });
      findPreference("no_icon").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("no_icon")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("no_icon", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("no_icon", true);
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("no_icon")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("no_icon", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("no_icon", false);
            return true;
          }
          return false;
        }
      });
      findPreference("hide_title").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("hide_title")) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("hide_title", true).commit();
            paramAnonymousPreference.getEditor().putBoolean("hide_title", true);
            return true;
          }
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("hide_title")) && (!((Boolean)paramAnonymousObject).booleanValue()))
          {
            localSharedPreferences.edit().putBoolean("hide_title", false).commit();
            paramAnonymousPreference.getEditor().putBoolean("hide_title", false);
            return true;
          }
          return false;
        }
      });
      findPreference("path").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
      {
        ProgressDialog progress = null;
        
        public boolean onPreferenceChange(final Preference paramAnonymousPreference, final Object paramAnonymousObject)
        {
          final SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
          if ((paramAnonymousPreference == SetPrefs.this.findPreference("path")) && (paramAnonymousObject.toString().contains("/")) && (!paramAnonymousObject.toString().equals("/")))
          {
            String[] arrayOfString = paramAnonymousObject.toString().trim().replaceAll("\\s+", ".").split("\\/+");
            paramAnonymousObject = "";
            int j = arrayOfString.length;
            int i = 0;
            final Object localObject;
            while (i < j)
            {
              String str = arrayOfString[i];
              localObject = paramAnonymousObject;
              if (!str.equals("")) {
                localObject = (String)paramAnonymousObject + "/" + str;
              }
              i += 1;
              paramAnonymousObject = localObject;
            }
            if (!new File((String)paramAnonymousObject).exists())
            {
              if ((SetPrefs.this.testPath(true, (String)paramAnonymousObject)) && (!((String)paramAnonymousObject).startsWith(SetPrefs.this.getDir("sdcard", 0).getAbsolutePath())))
              {
                localSharedPreferences.edit().putString("path", (String)paramAnonymousObject).commit();
                localSharedPreferences.edit().putBoolean("manual_path", true).commit();
                paramAnonymousPreference.getEditor().putString("path", (String)paramAnonymousObject).commit();
                localSharedPreferences.edit().putBoolean("path_changed", true).commit();
                paramAnonymousPreference = new File(localSharedPreferences.getString("basepath", "Noting"));
                localObject = new File((String)paramAnonymousObject);
                if (!paramAnonymousPreference.exists()) {
                  System.out.println("Directory does not exist.");
                }
                for (;;)
                {
                  return true;
                  this.progress = new ProgressDialog(SetPrefs.this);
                  this.progress.setCancelable(false);
                  this.progress.setMessage(SetPrefs.this.getString(2131165747));
                  this.progress.show();
                  new Thread(new Runnable()
                  {
                    public void handleMessage(Message paramAnonymous2Message)
                    {
                      System.out.println("LuckyPatcher: message poluchil: !" + paramAnonymous2Message);
                      try
                      {
                        if (SetPrefs.21.this.progress.isShowing()) {
                          SetPrefs.21.this.progress.dismiss();
                        }
                        if (paramAnonymous2Message.what == 0)
                        {
                          localSharedPreferences.edit().putString("basepath", paramAnonymousObject).commit();
                          listAppsFragment.basepath = paramAnonymousObject;
                          SetPrefs.this.showMessage(SetPrefs.this, Utils.getText(2131165748), Utils.getText(2131165553) + paramAnonymousObject);
                        }
                        if (paramAnonymous2Message.what == 1) {
                          SetPrefs.this.showMessage(SetPrefs.this, Utils.getText(2131165748), Utils.getText(2131165569));
                        }
                        return;
                      }
                      catch (Exception localException)
                      {
                        for (;;)
                        {
                          localException.printStackTrace();
                        }
                      }
                    }
                  }
                  {
                    public void run()
                    {
                      try
                      {
                        Utils.copyFolder(paramAnonymousPreference, localObject);
                        new Utils("").deleteFolder(paramAnonymousPreference);
                        this.val$handler.sendEmptyMessage(0);
                        return;
                      }
                      catch (Exception localException)
                      {
                        localException.printStackTrace();
                        this.val$handler.sendEmptyMessage(1);
                      }
                    }
                  }).start();
                }
              }
            }
            else {
              SetPrefs.this.showMessage(SetPrefs.this, Utils.getText(2131165748), Utils.getText(2131165445));
            }
          }
          for (;;)
          {
            return false;
            SetPrefs.this.showMessage(SetPrefs.this, Utils.getText(2131165748), Utils.getText(2131165444));
          }
        }
      });
      findPreference("help").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          paramAnonymousPreference = new Intent(SetPrefs.this.getBaseContext(), HelpActivity.class);
          SetPrefs.this.startActivity(paramAnonymousPreference);
          return true;
        }
      });
      findPreference("upd").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          if (listAppsFragment.frag != null) {
            listAppsFragment.frag.runUpdate();
          }
          SetPrefs.this.finish();
          return true;
        }
      });
      findPreference("sendlog").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          new AsyncTask()
          {
            ProgressDialog pd;
            
            protected Boolean doInBackground(Void... paramAnonymous2VarArgs)
            {
              try
              {
                if (listAppsFragment.mLogCollector == null) {
                  listAppsFragment.mLogCollector = new LogCollector();
                }
                boolean bool = listAppsFragment.mLogCollector.collect(listAppsFragment.getInstance(), true);
                return Boolean.valueOf(bool);
              }
              catch (Exception paramAnonymous2VarArgs)
              {
                paramAnonymous2VarArgs.printStackTrace();
              }
              return Boolean.valueOf(false);
            }
            
            protected void onPostExecute(Boolean paramAnonymous2Boolean)
            {
              try
              {
                if ((this.pd != null) && (this.pd.isShowing())) {
                  this.pd.dismiss();
                }
                if (!paramAnonymous2Boolean.booleanValue()) {}
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  try
                  {
                    listAppsFragment.mLogCollector.sendLog(listAppsFragment.getInstance(), "lp.chelpus@gmail.com", "Error Log", "Lucky Patcher " + listAppsFragment.getPkgMng().getPackageInfo(listAppsFragment.frag.getContext().getPackageName(), 0).versionName);
                    return;
                  }
                  catch (PackageManager.NameNotFoundException paramAnonymous2Boolean)
                  {
                    paramAnonymous2Boolean.printStackTrace();
                    return;
                  }
                  localException = localException;
                  localException.printStackTrace();
                }
              }
              paramAnonymous2Boolean = new AlertDialog.Builder(SetPrefs.this.context);
              paramAnonymous2Boolean.setTitle("Error").setMessage(Utils.getText(2131165433)).setNegativeButton("OK", null);
              paramAnonymous2Boolean.create().show();
            }
            
            protected void onPreExecute()
            {
              this.pd = new ProgressDialog(SetPrefs.this.context);
              this.pd.setTitle("Progress");
              this.pd.setMessage(Utils.getText(2131165255));
              this.pd.setIndeterminate(true);
              this.pd.show();
            }
          }.execute(new Void[0]);
          return true;
        }
      });
      findPreference("about").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          paramAnonymousPreference = (LinearLayout)View.inflate(SetPrefs.this.context, 2130968576, null);
          Object localObject = (LinearLayout)paramAnonymousPreference.findViewById(2131558401).findViewById(2131558403);
          String str = Utils.getText(2131165737) + listAppsFragment.version + "\n";
          localObject = (TextView)((LinearLayout)localObject).findViewById(2131558404);
          ((TextView)localObject).append(Utils.getColoredText(str, "#ffffffff", "bold"));
          ((TextView)localObject).append(Utils.getColoredText("----------------------------------\n\n", "#ffffffff", "bold"));
          ((TextView)localObject).append(Utils.getColoredText(Utils.getText(2131165188) + " " + listAppsFragment.basepath + "\n\n", "#ffffffff", "bold"));
          ((TextView)localObject).append(Utils.getColoredText(Utils.getText(2131165629) + "\n\n", "#ffff0000", "bold"));
          ((TextView)localObject).append(Utils.getColoredText(Utils.getText(2131165189) + "\n", "#ffffff00", "bold"));
          new AlertDialog.Builder(SetPrefs.this.context).setTitle(2131165191).setCancelable(true).setIcon(17301659).setPositiveButton(Utils.getText(2131165587), null).setNeutralButton("Changelog", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              if (new File(listAppsFragment.basepath + "/Changes/changelog.txt").exists())
              {
                SetPrefs.this.showMessage(SetPrefs.this.context, Utils.getText(2131165251), Utils.read_from_file(new File(listAppsFragment.basepath + "/Changes/changelog.txt")));
                return;
              }
              SetPrefs.this.showMessage(SetPrefs.this.context, Utils.getText(2131165251), Utils.getText(2131165577));
            }
          }).setView(paramAnonymousPreference).setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              paramAnonymous2DialogInterface.dismiss();
            }
          }).create().show();
          return true;
        }
      });
      findPreference("language").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        Dialog dialog6;
        
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          listAppsFragment.getRes();
          SetPrefs.this.getAssets().getLocales();
          paramAnonymousPreference = new ArrayList();
          paramAnonymousPreference.add("en_US");
          paramAnonymousPreference.add("ar");
          paramAnonymousPreference.add("bg");
          paramAnonymousPreference.add("cs");
          paramAnonymousPreference.add("da");
          paramAnonymousPreference.add("de");
          paramAnonymousPreference.add("el");
          paramAnonymousPreference.add("es");
          paramAnonymousPreference.add("fa");
          paramAnonymousPreference.add("fi");
          paramAnonymousPreference.add("fr");
          paramAnonymousPreference.add("he");
          paramAnonymousPreference.add("hi");
          paramAnonymousPreference.add("hu");
          paramAnonymousPreference.add("id");
          paramAnonymousPreference.add("in");
          paramAnonymousPreference.add("it");
          paramAnonymousPreference.add("iw");
          paramAnonymousPreference.add("ja");
          paramAnonymousPreference.add("km");
          paramAnonymousPreference.add("km_KH");
          paramAnonymousPreference.add("ko");
          paramAnonymousPreference.add("lt");
          paramAnonymousPreference.add("ml");
          paramAnonymousPreference.add("my");
          paramAnonymousPreference.add("nl");
          paramAnonymousPreference.add("pl");
          paramAnonymousPreference.add("pt");
          paramAnonymousPreference.add("pt_BR");
          paramAnonymousPreference.add("ro");
          paramAnonymousPreference.add("ru");
          paramAnonymousPreference.add("sk");
          paramAnonymousPreference.add("tr");
          paramAnonymousPreference.add("ug");
          paramAnonymousPreference.add("uk");
          paramAnonymousPreference.add("vi");
          paramAnonymousPreference.add("zh_CN");
          paramAnonymousPreference.add("zh_HK");
          paramAnonymousPreference.add("zh_TW");
          paramAnonymousPreference = new ArrayAdapter(SetPrefs.this.context, 2130968605, paramAnonymousPreference)
          {
            public View getView(int paramAnonymous2Int, View paramAnonymous2View, ViewGroup paramAnonymous2ViewGroup)
            {
              paramAnonymous2View = super.getView(paramAnonymous2Int, paramAnonymous2View, paramAnonymous2ViewGroup);
              paramAnonymous2ViewGroup = (TextView)paramAnonymous2View.findViewById(2131558462);
              paramAnonymous2ViewGroup.setTextColor(-1);
              String str = (String)getItem(paramAnonymous2Int);
              Locale localLocale = new Locale(str, str);
              paramAnonymous2ViewGroup.setText(localLocale.getDisplayName(localLocale));
              if (str.equals("my")) {
                paramAnonymous2ViewGroup.setText("Malay translation");
              }
              paramAnonymous2ViewGroup.setTypeface(null, 1);
              return paramAnonymous2View;
            }
          };
          ListView localListView = new ListView(SetPrefs.this.context);
          AlertDialog.Builder localBuilder = new AlertDialog.Builder(SetPrefs.this.context);
          if (paramAnonymousPreference != null)
          {
            paramAnonymousPreference.setNotifyOnChange(true);
            localListView.setAdapter(paramAnonymousPreference);
            localListView.invalidateViews();
            localListView.setCacheColorHint(-16777216);
            localListView.setBackgroundColor(-16777216);
            localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
              {
                if (SetPrefs.26.this.dialog6.isShowing()) {
                  SetPrefs.26.this.dialog6.dismiss();
                }
                SharedPreferences localSharedPreferences = listAppsFragment.getInstance().getSharedPreferences("config", 0);
                Object localObject = ((String)paramAnonymous2AdapterView.getItemAtPosition(paramAnonymous2Int)).split("_");
                paramAnonymous2View = null;
                if (localObject.length == 1) {
                  paramAnonymous2View = new Locale(localObject[0]);
                }
                if (localObject.length == 2)
                {
                  paramAnonymous2View = new Locale(localObject[0], localObject[1], "");
                  if (localObject[1].equals("rBR")) {
                    paramAnonymous2View = new Locale(localObject[0], "BR");
                  }
                }
                if (localObject.length == 3) {
                  paramAnonymous2View = new Locale(localObject[0], localObject[1], localObject[2]);
                }
                Locale.setDefault(paramAnonymous2View);
                localObject = new Configuration();
                ((Configuration)localObject).locale = paramAnonymous2View;
                listAppsFragment.getRes().updateConfiguration((Configuration)localObject, listAppsFragment.getRes().getDisplayMetrics());
                localSharedPreferences.edit().putString("force_language", (String)paramAnonymous2AdapterView.getItemAtPosition(paramAnonymous2Int)).commit();
                paramAnonymous2AdapterView = SetPrefs.this.getIntent();
                paramAnonymous2AdapterView.addFlags(131072);
                SetPrefs.this.finish();
                SetPrefs.this.startActivity(paramAnonymous2AdapterView);
                localSharedPreferences.edit().putBoolean("settings_change", true).commit();
                localSharedPreferences.edit().putBoolean("lang_change", true).commit();
              }
            });
            localBuilder.setView(localListView);
          }
          this.dialog6 = localBuilder.create();
          this.dialog6.show();
          return true;
        }
      });
      return;
      paramBundle = null;
      localObject = ((String)localObject).split("_");
      if (localObject.length == 1) {
        paramBundle = new Locale(localObject[0]);
      }
      if (localObject.length == 2)
      {
        paramBundle = new Locale(localObject[0], localObject[1], "");
        if (localObject[1].equals("rBR")) {
          paramBundle = new Locale(localObject[0], "BR");
        }
      }
      if (localObject.length == 3) {
        paramBundle = new Locale(localObject[0], localObject[1], localObject[2]);
      }
      Locale.setDefault(paramBundle);
      localObject = new Configuration();
      ((Configuration)localObject).locale = paramBundle;
      listAppsFragment.getRes().updateConfiguration((Configuration)localObject, listAppsFragment.getRes().getDisplayMetrics());
    }
  }
  
  public boolean testPath(boolean paramBoolean, String paramString)
  {
    System.out.println("test path.");
    try
    {
      if (!new File(paramString).exists()) {
        new File(paramString).mkdirs();
      }
      if (!new File(paramString).exists())
      {
        showMessage(this, Utils.getText(2131165748), Utils.getText(2131165530));
        return false;
      }
      if (new File(paramString + "/tmp.txt").createNewFile())
      {
        new File(paramString + "/tmp.txt").delete();
        return true;
      }
      if (paramBoolean)
      {
        showMessage(this, Utils.getText(2131165748), Utils.getText(2131165530));
        return false;
      }
    }
    catch (IOException paramString)
    {
      if (paramBoolean) {
        showMessage(this, Utils.getText(2131165748), Utils.getText(2131165530));
      }
    }
    return false;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/SetPrefs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */