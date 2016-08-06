package com.android.vending.billing.InAppBillingService.LACK.widgets;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AppDisablerWidgetConfigureActivity
  extends Activity
{
  private static final String PREFS_NAME = "com.android.vending.billing.InAppBillingService.LACK.widgets.AppDisablerWidget";
  private static final String PREF_PREFIX_KEY = "appwidget_";
  public Context context;
  public ListView lv = null;
  int mAppWidgetId = 0;
  EditText mAppWidgetText;
  public String[] packages = null;
  public int sizeText = 0;
  
  static void deleteRunBooleanPref(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("com.android.vending.billing.InAppBillingService.LACK.widgets.AppDisablerWidget", 4).edit();
    paramContext.remove("appwidget_" + paramInt + "_run");
    paramContext.commit();
  }
  
  static void deleteTitlePref(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("com.android.vending.billing.InAppBillingService.LACK.widgets.AppDisablerWidget", 4).edit();
    paramContext.remove("appwidget_" + paramInt);
    paramContext.commit();
  }
  
  static boolean loadRunBooleanPref(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("com.android.vending.billing.InAppBillingService.LACK.widgets.AppDisablerWidget", 4).getBoolean("appwidget_" + paramInt + "_run", false);
  }
  
  static String loadTitlePref(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("com.android.vending.billing.InAppBillingService.LACK.widgets.AppDisablerWidget", 4).getString("appwidget_" + paramInt, null);
    if (paramContext != null) {
      return paramContext;
    }
    return "NOT_SAVED_APP_DISABLER";
  }
  
  static void saveRunBooleanPref(Context paramContext, int paramInt, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("com.android.vending.billing.InAppBillingService.LACK.widgets.AppDisablerWidget", 4).edit();
    paramContext.putBoolean("appwidget_" + paramInt + "_run", paramBoolean);
    paramContext.commit();
  }
  
  static void saveTitlePref(Context paramContext, int paramInt, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("com.android.vending.billing.InAppBillingService.LACK.widgets.AppDisablerWidget", 4).edit();
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
    this.packages = listAppsFragment.getPackages();
    paramBundle = new ArrayList();
    Object localObject = this.packages;
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = localObject[i];
        if ((!str.equals("android")) || (!str.equals(this.context.getPackageName()))) {}
        try
        {
          paramBundle.add(new PkgItem(str, listAppsFragment.getPkgMng().getPackageInfo(str, 0).applicationInfo.loadLabel(listAppsFragment.getPkgMng()).toString()));
          i += 1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            localNameNotFoundException.printStackTrace();
          }
        }
      }
    }
    localObject = new PkgItem[paramBundle.size()];
    paramBundle.toArray((Object[])localObject);
    try
    {
      Arrays.sort((Object[])localObject, new byPkgName());
      this.lv = new ListView(this.context);
      listAppsFragment.adapt = new ArrayAdapter(this, 2130968622, (PkgItem[])localObject)
      {
        /* Error */
        public View getView(int paramAnonymousInt, View paramAnonymousView, android.view.ViewGroup paramAnonymousViewGroup)
        {
          // Byte code:
          //   0: aload_2
          //   1: astore 8
          //   3: aload 8
          //   5: astore_2
          //   6: aload 8
          //   8: ifnonnull +22 -> 30
          //   11: invokestatic 34	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
          //   14: ldc 36
          //   16: invokevirtual 42	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
          //   19: checkcast 44	android/view/LayoutInflater
          //   22: ldc 45
          //   24: aload_3
          //   25: iconst_0
          //   26: invokevirtual 49	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
          //   29: astore_2
          //   30: aload_2
          //   31: ldc 50
          //   33: invokevirtual 56	android/view/View:findViewById	(I)Landroid/view/View;
          //   36: checkcast 58	android/widget/TextView
          //   39: astore_3
          //   40: aload_2
          //   41: ldc 59
          //   43: invokevirtual 56	android/view/View:findViewById	(I)Landroid/view/View;
          //   46: checkcast 61	android/widget/ImageView
          //   49: astore 9
          //   51: aload 9
          //   53: aconst_null
          //   54: invokevirtual 65	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
          //   57: aload_3
          //   58: aload_0
          //   59: invokevirtual 68	com/android/vending/billing/InAppBillingService/LACK/widgets/AppDisablerWidgetConfigureActivity$1:getContext	()Landroid/content/Context;
          //   62: invokestatic 72	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getSizeText	()I
          //   65: invokevirtual 76	android/widget/TextView:setTextAppearance	(Landroid/content/Context;I)V
          //   68: aload_3
          //   69: iconst_m1
          //   70: invokevirtual 80	android/widget/TextView:setTextColor	(I)V
          //   73: aload_0
          //   74: iload_1
          //   75: invokevirtual 84	com/android/vending/billing/InAppBillingService/LACK/widgets/AppDisablerWidgetConfigureActivity$1:getItem	(I)Ljava/lang/Object;
          //   78: checkcast 86	com/android/vending/billing/InAppBillingService/LACK/widgets/PkgItem
          //   81: astore 8
          //   83: invokestatic 90	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   86: astore 10
          //   88: invokestatic 94	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getRes	()Landroid/content/res/Resources;
          //   91: invokevirtual 100	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
          //   94: getfield 106	android/util/DisplayMetrics:density	F
          //   97: fstore 4
          //   99: ldc 107
          //   101: fload 4
          //   103: fmul
          //   104: ldc 108
          //   106: fadd
          //   107: f2i
          //   108: istore_1
          //   109: aload 10
          //   111: aload 8
          //   113: getfield 112	com/android/vending/billing/InAppBillingService/LACK/widgets/PkgItem:package_name	Ljava/lang/String;
          //   116: invokevirtual 118	android/content/pm/PackageManager:getApplicationIcon	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
          //   119: checkcast 120	android/graphics/drawable/BitmapDrawable
          //   122: invokevirtual 124	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
          //   125: astore 10
          //   127: aload 10
          //   129: invokevirtual 129	android/graphics/Bitmap:getWidth	()I
          //   132: istore 6
          //   134: aload 10
          //   136: invokevirtual 132	android/graphics/Bitmap:getHeight	()I
          //   139: istore 7
          //   141: iload_1
          //   142: i2f
          //   143: iload 6
          //   145: i2f
          //   146: fdiv
          //   147: fstore 4
          //   149: iload_1
          //   150: i2f
          //   151: iload 7
          //   153: i2f
          //   154: fdiv
          //   155: fstore 5
          //   157: new 134	android/graphics/Matrix
          //   160: dup
          //   161: invokespecial 137	android/graphics/Matrix:<init>	()V
          //   164: astore 11
          //   166: aload 11
          //   168: fload 4
          //   170: fload 5
          //   172: invokevirtual 141	android/graphics/Matrix:postScale	(FF)Z
          //   175: pop
          //   176: aload 9
          //   178: new 120	android/graphics/drawable/BitmapDrawable
          //   181: dup
          //   182: aload 10
          //   184: iconst_0
          //   185: iconst_0
          //   186: iload 6
          //   188: iload 7
          //   190: aload 11
          //   192: iconst_1
          //   193: invokestatic 145	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
          //   196: invokespecial 148	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
          //   199: invokevirtual 65	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
          //   202: aload_3
          //   203: ldc -107
          //   205: invokestatic 94	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getRes	()Landroid/content/res/Resources;
          //   208: invokevirtual 100	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
          //   211: getfield 106	android/util/DisplayMetrics:density	F
          //   214: fmul
          //   215: ldc 108
          //   217: fadd
          //   218: f2i
          //   219: invokevirtual 152	android/widget/TextView:setCompoundDrawablePadding	(I)V
          //   222: aload_3
          //   223: new 154	java/lang/StringBuilder
          //   226: dup
          //   227: invokespecial 155	java/lang/StringBuilder:<init>	()V
          //   230: aload 8
          //   232: getfield 158	com/android/vending/billing/InAppBillingService/LACK/widgets/PkgItem:label	Ljava/lang/String;
          //   235: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   238: ldc -92
          //   240: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   243: aload 8
          //   245: getfield 112	com/android/vending/billing/InAppBillingService/LACK/widgets/PkgItem:package_name	Ljava/lang/String;
          //   248: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   251: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   254: invokevirtual 172	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
          //   257: aload_3
          //   258: aconst_null
          //   259: iconst_1
          //   260: invokevirtual 176	android/widget/TextView:setTypeface	(Landroid/graphics/Typeface;I)V
          //   263: aload_2
          //   264: areturn
          //   265: astore 9
          //   267: aload 9
          //   269: invokevirtual 179	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
          //   272: goto -70 -> 202
          //   275: astore 9
          //   277: aload 9
          //   279: invokevirtual 180	java/lang/OutOfMemoryError:printStackTrace	()V
          //   282: invokestatic 185	java/lang/System:gc	()V
          //   285: goto -83 -> 202
          //   288: astore 9
          //   290: aload 9
          //   292: invokevirtual 186	java/lang/Exception:printStackTrace	()V
          //   295: goto -93 -> 202
          //   298: astore 9
          //   300: aload 9
          //   302: invokevirtual 186	java/lang/Exception:printStackTrace	()V
          //   305: goto -103 -> 202
          //   308: astore 9
          //   310: goto -108 -> 202
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	313	0	this	1
          //   0	313	1	paramAnonymousInt	int
          //   0	313	2	paramAnonymousView	View
          //   0	313	3	paramAnonymousViewGroup	android.view.ViewGroup
          //   97	72	4	f1	float
          //   155	16	5	f2	float
          //   132	55	6	i	int
          //   139	50	7	j	int
          //   1	243	8	localObject1	Object
          //   49	128	9	localImageView	android.widget.ImageView
          //   265	3	9	localNameNotFoundException	PackageManager.NameNotFoundException
          //   275	3	9	localOutOfMemoryError1	OutOfMemoryError
          //   288	3	9	localException1	Exception
          //   298	3	9	localException2	Exception
          //   308	1	9	localOutOfMemoryError2	OutOfMemoryError
          //   86	97	10	localObject2	Object
          //   164	27	11	localMatrix	android.graphics.Matrix
          // Exception table:
          //   from	to	target	type
          //   109	202	265	android/content/pm/PackageManager$NameNotFoundException
          //   83	99	275	java/lang/OutOfMemoryError
          //   267	272	275	java/lang/OutOfMemoryError
          //   290	295	275	java/lang/OutOfMemoryError
          //   109	202	288	java/lang/Exception
          //   83	99	298	java/lang/Exception
          //   267	272	298	java/lang/Exception
          //   290	295	298	java/lang/Exception
          //   109	202	308	java/lang/OutOfMemoryError
        }
      };
      this.lv.setAdapter(listAppsFragment.adapt);
      this.lv.invalidateViews();
      this.lv.setBackgroundColor(-16777216);
      this.lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (PkgItem)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
          paramAnonymousView = AppDisablerWidgetConfigureActivity.this;
          AppDisablerWidgetConfigureActivity.saveTitlePref(paramAnonymousView, AppDisablerWidgetConfigureActivity.this.mAppWidgetId, paramAnonymousAdapterView.package_name);
          AppDisablerWidget.updateAppWidget(paramAnonymousView, AppWidgetManager.getInstance(paramAnonymousView), AppDisablerWidgetConfigureActivity.this.mAppWidgetId);
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("appWidgetId", AppDisablerWidgetConfigureActivity.this.mAppWidgetId);
          AppDisablerWidgetConfigureActivity.this.setResult(-1, paramAnonymousAdapterView);
          AppDisablerWidgetConfigureActivity.this.finish();
        }
      });
      paramBundle = new LinearLayout(this);
      paramBundle.setOrientation(1);
      paramBundle.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      localObject = new CheckBox(this);
      ((CheckBox)localObject).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppDisablerWidgetConfigureActivity.saveRunBooleanPref(AppDisablerWidgetConfigureActivity.this.context, AppDisablerWidgetConfigureActivity.this.mAppWidgetId, paramAnonymousBoolean);
        }
      });
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = 30;
      localLayoutParams.topMargin = 20;
      localLayoutParams.bottomMargin = 20;
      ((CheckBox)localObject).setLayoutParams(localLayoutParams);
      ((CheckBox)localObject).setTextAppearance(this, 16973892);
      ((CheckBox)localObject).setText(Utils.getText(2131165823));
      paramBundle.addView((View)localObject);
      paramBundle.addView(this.lv);
      setContentView(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  class byPkgName
    implements Comparator<PkgItem>
  {
    byPkgName() {}
    
    public int compare(PkgItem paramPkgItem1, PkgItem paramPkgItem2)
    {
      return paramPkgItem1.label.compareToIgnoreCase(paramPkgItem2.label);
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/widgets/AppDisablerWidgetConfigureActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */