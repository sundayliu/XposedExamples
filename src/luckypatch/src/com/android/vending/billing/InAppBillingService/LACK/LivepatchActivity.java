package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LivepatchActivity
  extends Activity
{
  private static final int DIALOG_LOAD_FILE = 3;
  private static final String SETTINGS_VIEWSIZE = "viewsize";
  private static final int SETTINGS_VIEWSIZE_SMALL = 0;
  private static final String TAG = "F_PATH";
  public static Context context;
  static InputFilter filter = new InputFilter()
  {
    private String getPattern()
    {
      new DecimalFormatSymbols();
      return "([0-9A-Fa-f*?]){2}||([0-9A-Fa-f*?]){1}";
    }
    
    public CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      try
      {
        paramAnonymousCharSequence = paramAnonymousSpanned.toString() + paramAnonymousCharSequence.toString();
        getPattern();
        if (Pattern.compile("([\\s]){2}").matcher(paramAnonymousCharSequence).find()) {
          return "";
        }
        if (Pattern.matches("([\\s]){2}", paramAnonymousCharSequence)) {
          return "";
        }
        return null;
      }
      catch (Exception paramAnonymousCharSequence) {}
      return "";
    }
  };
  static InputFilter filter2 = new InputFilter()
  {
    private String getPattern()
    {
      new DecimalFormatSymbols();
      return "([0-9A-Fa-f*?]){2}||([0-9A-Fa-f*?]){1}";
    }
    
    public CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      try
      {
        paramAnonymousCharSequence = paramAnonymousSpanned.toString() + paramAnonymousCharSequence.toString();
        getPattern();
        if (Pattern.compile("([\\s]){2}").matcher(paramAnonymousCharSequence).find()) {
          return "";
        }
        if (Pattern.matches("([\\s]){2}", paramAnonymousCharSequence)) {
          return "";
        }
        return null;
      }
      catch (Exception paramAnonymousCharSequence) {}
      return "";
    }
  };
  private static EditText orhex;
  public static String patch;
  private static EditText rephex;
  public static String selabpath;
  public static String selpath = "";
  public static String str;
  private static TextView tv;
  ListAdapter adapter;
  private String chosenFile;
  private Item[] fileList;
  private Boolean firstLvl = Boolean.valueOf(true);
  private File path = new File(Environment.getExternalStorageDirectory() + "");
  public PkgListItem pli;
  int start = 0;
  ArrayList<String> stri = new ArrayList();
  
  static
  {
    selabpath = "";
    patch = "";
  }
  
  private void loadFileList()
  {
    Object localObject = new String[1];
    localObject[0] = "empty";
    try
    {
      String[] arrayOfString = new Utils("").cmdRoot(new String[] { "cd " + this.path, "ls" }).split("\n");
      localObject = arrayOfString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localException.printStackTrace();
        continue;
        this.fileList[i] = new Item(localObject[i], Integer.valueOf(2130837547));
        if (new File(this.path, localObject[i]).isDirectory())
        {
          this.fileList[i].icon = 2130837546;
          Log.d("DIRECTORY", this.fileList[i].file);
        }
        else
        {
          Log.d("FILE", this.fileList[i].file);
        }
      }
      if (this.firstLvl.booleanValue()) {
        break label259;
      }
    }
    this.fileList = new Item[localObject.length];
    i = 0;
    for (;;)
    {
      if (i >= localObject.length) {
        break label223;
      }
      if ((!localObject[i].equals("")) || (localObject.length != 1)) {
        break;
      }
      this.fileList[i] = new Item("Up", Integer.valueOf(2130837545));
      i += 1;
    }
    label223:
    if ((this.fileList.length == 1) && (this.fileList[0].file.equals("Up"))) {}
    for (;;)
    {
      label259:
      this.adapter = new ArrayAdapter(this, 17367057, 16908308, this.fileList)
      {
        public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
        {
          LivepatchActivity.Item localItem = (LivepatchActivity.Item)getItem(paramAnonymousInt);
          paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
          paramAnonymousViewGroup = (TextView)paramAnonymousView.findViewById(16908308);
          LivepatchActivity.this.getApplicationContext().getResources();
          paramAnonymousViewGroup.setTextAppearance(getContext(), listAppsFragment.getSizeText());
          paramAnonymousViewGroup.setCompoundDrawablesWithIntrinsicBounds(LivepatchActivity.this.fileList[paramAnonymousInt].icon, 0, 0, 0);
          paramAnonymousViewGroup.setCompoundDrawablePadding((int)(5.0F * LivepatchActivity.this.getResources().getDisplayMetrics().density + 0.5F));
          paramAnonymousViewGroup.setTextColor(-1);
          paramAnonymousViewGroup.setText(localItem.file);
          paramAnonymousViewGroup.setTypeface(null, 1);
          return paramAnonymousView;
        }
      };
      return;
      localObject = new Item[this.fileList.length + 1];
      System.arraycopy(this.fileList, 0, localObject, 1, this.fileList.length);
      localObject[0] = new Item("Up", Integer.valueOf(2130837545));
      this.fileList = ((Item[])localObject);
    }
  }
  
  public void backup_click()
  {
    if (patch == "dalvik") {}
    try
    {
      Toast.makeText(getApplication().getApplicationContext(), "Backup processing... Please wait...", 0).show();
      str1 = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".live_backup " + this.pli.pkgName });
      tv.setText(Utils.getColoredText(str1, "#ff00ff73", "bold"));
      if (patch != "lib") {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.contains("/mnt/asec/")) {
            Utils.remount(getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.replace("/pkg.apk", ""), "rw");
          }
          str = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".live_backuplib " + selpath });
          if (getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.contains("/mnt/asec/")) {
            Utils.remount(getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.replace("/pkg.apk", ""), "ro");
          }
          String str1 = str;
          if (str.contains("Error")) {
            tv.setText(Utils.getColoredText(str1, "#ffff0055", "bold"));
          }
          if (!str.contains("Error")) {
            tv.setText(Utils.getColoredText(str1, "#ff00ff73", "bold"));
          }
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  public void launch_click()
  {
    try
    {
      startActivity(getPackageManager().getLaunchIntentForPackage(this.pli.pkgName));
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      Toast.makeText(getApplicationContext(), Utils.getText(2131165437), 1).show();
    }
  }
  
  public void livepatch_click()
  {
    System.out.println("run patch");
    int j = 1;
    int k = 1;
    String str1 = orhex.getText().toString();
    String str2 = rephex.getText().toString();
    int i = j;
    Object localObject;
    if (str1 != null)
    {
      i = j;
      if (str2 != null)
      {
        localObject = str1.split("\\s+");
        int m = localObject.length;
        j = 0;
        i = k;
        while (j < m)
        {
          if (!Pattern.matches("([0-9A-Fa-f*?]){2}||([0-9A-Fa-f*?]){1}", localObject[j]))
          {
            i = 0;
            Toast.makeText(getApplication().getBaseContext(), Utils.getText(2131165442), 0).show();
          }
          j += 1;
        }
        String[] arrayOfString = str2.split("\\s+");
        k = arrayOfString.length;
        j = 0;
        while (j < k)
        {
          if (!Pattern.matches("([0-9A-Fa-f*?]){2}||([0-9A-Fa-f*?]){1}", arrayOfString[j]))
          {
            i = 0;
            Toast.makeText(getApplication().getBaseContext(), Utils.getText(2131165446), 0).show();
          }
          j += 1;
        }
        if (localObject.length != arrayOfString.length)
        {
          i = 0;
          Toast.makeText(getApplication().getBaseContext(), Utils.getText(2131165438), 0).show();
        }
      }
    }
    if ((i == 0) || (patch == "dalvik")) {}
    try
    {
      Toast.makeText(getApplication().getBaseContext(), "Search bytes... Please wait...", 0).show();
      str = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".liverunpatch " + this.pli.pkgName + " " + "\"" + str1 + "\"" + " " + "\"" + str2 + "\"" });
      localObject = str;
      if (str.contains("Error")) {
        tv.setText(Utils.getColoredText((String)localObject, "#ffff0055", "bold"));
      }
      if (!str.contains("Error")) {
        tv.setText(Utils.getColoredText((String)localObject, "#ff00ff73", "bold"));
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          Toast.makeText(getApplication().getApplicationContext(), "Search bytes... Please wait...", 0).show();
          if (getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.contains("/mnt/asec/")) {
            Utils.remount(getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.replace("/pkg.apk", ""), "rw");
          }
          str = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".liverunpatchlib " + selpath + " " + "\"" + str1 + "\"" + " " + "\"" + str2 + "\"" });
          if (getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.contains("/mnt/asec/")) {
            Utils.remount(getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.replace("/pkg.apk", ""), "ro");
          }
          str1 = str;
          getApplication().getApplicationContext().getResources();
          if (str.contains("Error")) {
            tv.setText(Utils.getColoredText(str1, "#ffff0055", "bold"));
          }
          if (!str.contains("Error")) {
            tv.setText(Utils.getColoredText(str1, "#ff00ff73", "bold"));
          }
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        localException2 = localException2;
        localException2.printStackTrace();
      }
    }
    if (patch == "lib") {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    context = getApplicationContext();
    setContentView(2130968624);
    this.pli = listAppsFragment.pli;
    paramBundle = (LinearLayout)findViewById(2131558603).findViewById(2131558604);
    patch = "dalvik";
    orhex = (EditText)findViewById(2131558597);
    rephex = (EditText)findViewById(2131558598);
    orhex.setFilters(new InputFilter[] { filter });
    orhex.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        LivepatchActivity.rephex.setText(paramAnonymousCharSequence.toString().replace("\\s+", " "));
      }
    });
    tv = (TextView)paramBundle.findViewById(2131558605);
    paramBundle = getApplication().getApplicationContext().getResources();
    str = paramBundle.getString(2131165560);
    paramBundle = paramBundle.getString(2131165406) + "\n\n" + str;
    tv.setText(Utils.getColoredText(paramBundle, "#ff00ff73", "bold"));
    ((Button)findViewById(2131558599)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        System.out.println("run patch!");
        LivepatchActivity.this.livepatch_click();
      }
    });
    ((Button)findViewById(2131558602)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LivepatchActivity.this.launch_click();
      }
    });
    ((Button)findViewById(2131558600)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LivepatchActivity.this.backup_click();
      }
    });
    ((Button)findViewById(2131558601)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LivepatchActivity.this.restore_click();
      }
    });
    ((Button)findViewById(2131558606)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        System.out.println("select_target!");
        try
        {
          LivepatchActivity.access$102(LivepatchActivity.this, new File(LivepatchActivity.this.getPackageManager().getPackageInfo(LivepatchActivity.this.pli.pkgName, 0).applicationInfo.dataDir));
          if (LivepatchActivity.this.getPackageManager().getPackageInfo(LivepatchActivity.this.pli.pkgName, 0).applicationInfo.sourceDir.contains("/mnt/asec/")) {
            LivepatchActivity.access$102(LivepatchActivity.this, new File(LivepatchActivity.this.getPackageManager().getPackageInfo(LivepatchActivity.this.pli.pkgName, 0).applicationInfo.sourceDir.replace("/pkg.apk", "")));
          }
          LivepatchActivity.this.loadFileList();
          LivepatchActivity.this.removeDialog(3);
          LivepatchActivity.this.showDialog(3);
          return;
        }
        catch (PackageManager.NameNotFoundException paramAnonymousView)
        {
          paramAnonymousView.printStackTrace();
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Toast.makeText(LivepatchActivity.this.getApplicationContext(), "System not respond!", 1).show();
        }
      }
    });
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    new Dialog(this);
    ListView localListView = new ListView(this);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    if (this.fileList == null)
    {
      Log.e("F_PATH", "No files loaded");
      return localBuilder.create();
    }
    localBuilder.setTitle("Choose your file");
    if (this.adapter != null)
    {
      localListView.setAdapter(this.adapter);
      localListView.invalidateViews();
      localListView.setCacheColorHint(-16777216);
      localListView.setBackgroundColor(-16777216);
      localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          LivepatchActivity.access$302(LivepatchActivity.this, LivepatchActivity.this.fileList[paramAnonymousInt].file);
          paramAnonymousAdapterView = new File(LivepatchActivity.this.path + "/" + LivepatchActivity.this.chosenFile);
          if (paramAnonymousAdapterView.isDirectory())
          {
            LivepatchActivity.access$502(LivepatchActivity.this, Boolean.valueOf(false));
            LivepatchActivity.this.stri.add(LivepatchActivity.this.chosenFile);
            LivepatchActivity.access$402(LivepatchActivity.this, null);
            LivepatchActivity.access$102(LivepatchActivity.this, new File(paramAnonymousAdapterView + ""));
            LivepatchActivity.this.loadFileList();
            LivepatchActivity.this.removeDialog(3);
            LivepatchActivity.this.showDialog(3);
            Log.d("F_PATH", LivepatchActivity.this.path.getAbsolutePath());
            return;
          }
          if ((LivepatchActivity.this.chosenFile.equalsIgnoreCase("up")) && (!paramAnonymousAdapterView.exists())) {
            try
            {
              paramAnonymousAdapterView = (String)LivepatchActivity.this.stri.remove(LivepatchActivity.this.stri.size() - 1);
              LivepatchActivity.access$102(LivepatchActivity.this, new File(LivepatchActivity.this.path.toString().substring(0, LivepatchActivity.this.path.toString().lastIndexOf(paramAnonymousAdapterView))));
              LivepatchActivity.access$402(LivepatchActivity.this, null);
              if (LivepatchActivity.this.stri.isEmpty()) {
                LivepatchActivity.access$502(LivepatchActivity.this, Boolean.valueOf(true));
              }
              LivepatchActivity.this.loadFileList();
              LivepatchActivity.this.removeDialog(3);
              LivepatchActivity.this.showDialog(3);
              Log.d("F_PATH", LivepatchActivity.this.path.getAbsolutePath());
              return;
            }
            catch (Exception paramAnonymousAdapterView)
            {
              for (;;)
              {
                paramAnonymousAdapterView.printStackTrace();
                LivepatchActivity.this.stri.clear();
                LivepatchActivity.access$502(LivepatchActivity.this, Boolean.valueOf(true));
              }
            }
          }
          LivepatchActivity.selabpath = LivepatchActivity.this.path.getAbsolutePath();
          LivepatchActivity.selpath = LivepatchActivity.this.path.getAbsolutePath() + "/" + LivepatchActivity.this.chosenFile;
          LivepatchActivity.patch = "lib";
          LivepatchActivity.str = "Help:\n\n - Pattern for original hex (length>3):\n  AA 1F ** 01 4C\n ** - any byte;\n\n - Pattern for replacement hex(length>3):\n  EA 2F ** ** **\n ** - does not change the byte;\n\nNumber of original bytes  and modified bytes must be equal; ";
          LivepatchActivity.this.removeDialog(3);
          LivepatchActivity.this.getApplication().getApplicationContext().getResources();
          paramAnonymousAdapterView = "Target is " + LivepatchActivity.selpath + ".\n";
          LivepatchActivity.tv.setText(Utils.getColoredText(paramAnonymousAdapterView, "#ff00ff73", "bold"));
          LivepatchActivity.access$502(LivepatchActivity.this, Boolean.valueOf(true));
          LivepatchActivity.this.stri.clear();
        }
      });
      localBuilder.setView(localListView);
    }
    localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        LivepatchActivity.this.removeDialog(3);
        LivepatchActivity.access$502(LivepatchActivity.this, Boolean.valueOf(true));
      }
    }).setCancelable(true).create();
  }
  
  public void onRestart()
  {
    super.onRestart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void restore_click()
  {
    if (patch == "dalvik") {}
    try
    {
      Toast.makeText(getApplication().getApplicationContext(), "Restore processing... Please wait...", 0).show();
      str1 = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".live_restore " + this.pli.pkgName });
      tv.setText(Utils.getColoredText(str1, "#ff00ff73", "bold"));
      if (patch != "lib") {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.contains("/mnt/asec/")) {
            Utils.remount(getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.replace("/pkg.apk", ""), "rw");
          }
          str = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommand + ".live_restorelib " + selpath });
          if (getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.contains("/mnt/asec/")) {
            Utils.remount(getPackageManager().getPackageInfo(this.pli.pkgName, 0).applicationInfo.sourceDir.replace("/pkg.apk", ""), "ro");
          }
          String str1 = str;
          if (str.contains("Error")) {
            tv.setText(Utils.getColoredText(str1, "#ffff0055", "bold"));
          }
          if (!str.contains("Error")) {
            tv.setText(Utils.getColoredText(str1, "#ff00ff73", "bold"));
          }
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  private class Item
  {
    public String file;
    public int icon;
    
    public Item(String paramString, Integer paramInteger)
    {
      this.file = paramString;
      if (paramInteger != null) {
        this.icon = paramInteger.intValue();
      }
    }
    
    public String toString()
    {
      return this.file;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/LivepatchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */