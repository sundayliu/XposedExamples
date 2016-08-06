package com.android.vending.billing.InAppBillingService.LACK;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.ImageView;
import android.widget.TextView;
import com.chelpus.Utils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PkgListItemAdapter
  extends BaseExpandableListAdapter
{
  public static final int TEXT_DEFAULT = 0;
  public static final int TEXT_LARGE = 2;
  public static final int TEXT_MEDIUM = 1;
  public static final int TEXT_SMALL = 0;
  boolean Ready = false;
  ArrayList<PkgListItem> add;
  public int[] childMenu = null;
  public int[] childMenuNoRoot = null;
  public int[] childMenuSystem = null;
  private Context context;
  public PkgListItem[] data;
  ArrayList<PkgListItem> del;
  private Drawable disabled = listAppsFragment.getRes().getDrawable(2130837536);
  private ImageView imgIcon;
  private int layoutResourceId;
  private TextView on_top_txt;
  public PkgListItem[] orig;
  private int size;
  public Comparator<PkgListItem> sorter;
  private TextView txtStatus;
  private TextView txtTitle;
  
  public PkgListItemAdapter(Context paramContext, int paramInt1, int paramInt2, List<PkgListItem> paramList)
  {
    this.context = paramContext;
    this.layoutResourceId = paramInt1;
    this.size = paramInt2;
    this.data = ((PkgListItem[])paramList.toArray(new PkgListItem[paramList.size()]));
    listAppsFragment.plia = this;
    paramContext = this.disabled;
    paramContext.setColorFilter(Color.parseColor("#fe6c00"), PorterDuff.Mode.MULTIPLY);
    this.disabled = paramContext;
  }
  
  public PkgListItemAdapter(Context paramContext, int paramInt, List<PkgListItem> paramList)
  {
    this.context = paramContext;
    this.layoutResourceId = paramInt;
    this.size = 0;
    this.data = ((PkgListItem[])paramList.toArray(new PkgListItem[paramList.size()]));
    listAppsFragment.plia = this;
    paramContext = this.disabled;
    paramContext.setColorFilter(Color.parseColor("#fe6c00"), PorterDuff.Mode.MULTIPLY);
    this.disabled = paramContext;
  }
  
  public void add(PkgListItem paramPkgListItem)
  {
    System.out.println("add " + paramPkgListItem.pkgName);
    ArrayList localArrayList = new ArrayList(Arrays.asList(this.data));
    localArrayList.add(paramPkgListItem);
    this.data = new PkgListItem[localArrayList.size()];
    localArrayList.toArray(this.data);
    sort();
    notifyDataSetChanged();
  }
  
  public boolean checkItem(String paramString)
  {
    boolean bool2 = false;
    try
    {
      PkgListItem[] arrayOfPkgListItem = this.data;
      int j = arrayOfPkgListItem.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          bool1 = arrayOfPkgListItem[i].pkgName.contentEquals(paramString);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public Integer getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(this.childMenu[paramInt2]);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt1 * 10 + paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130968604, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131558533);
    paramView.setTextAppearance(this.context, listAppsFragment.getSizeText());
    paramView.setTextAppearance(this.context, listAppsFragment.getSizeText());
    paramView.setText(Utils.getText(getChild(paramInt1, paramInt2).intValue()));
    paramView = (ImageView)paramViewGroup.findViewById(2131558532);
    switch (getChild(paramInt1, paramInt2).intValue())
    {
    default: 
      return paramViewGroup;
    case 2131165322: 
      paramView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130837581));
      return paramViewGroup;
    case 2131165197: 
      paramView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130837567));
      return paramViewGroup;
    case 2131165288: 
      paramView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130837567));
      return paramViewGroup;
    case 2131165731: 
      paramView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130837579));
      return paramViewGroup;
    case 2131165253: 
      paramView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130837529));
      return paramViewGroup;
    case 2131165556: 
      paramView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130837569));
      return paramViewGroup;
    case 2131165554: 
      paramView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130837569));
      return paramViewGroup;
    case 2131165206: 
      paramView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130837569));
      return paramViewGroup;
    }
    paramView.setImageDrawable(listAppsFragment.getRes().getDrawable(2130837557));
    return paramViewGroup;
  }
  
  public int getChildrenCount(int paramInt)
  {
    Object localObject;
    if (getGroup(paramInt) != null) {
      localObject = null;
    }
    try
    {
      String str = listAppsFragment.getPkgMng().getPackageInfo(getGroup(paramInt).pkgName, 0).applicationInfo.sourceDir;
      localObject = str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        this.childMenu[6] = 2131165554;
      }
    }
    if ((listAppsFragment.su) && (localObject != null) && (!((String)localObject).startsWith("/system/")))
    {
      this.childMenu = new int[8];
      this.childMenu[0] = 2131165207;
      this.childMenu[1] = 2131165322;
      this.childMenu[2] = 2131165197;
      this.childMenu[3] = 2131165288;
      this.childMenu[4] = 2131165731;
      this.childMenu[5] = 2131165253;
      if (!((String)localObject).startsWith("/mnt/asec/"))
      {
        this.childMenu[6] = 2131165556;
        this.childMenu[7] = 2131165206;
      }
    }
    else
    {
      if ((listAppsFragment.su) && (localObject != null) && (((String)localObject).startsWith("/system/")))
      {
        this.childMenu = new int[7];
        this.childMenu[0] = 2131165207;
        this.childMenu[1] = 2131165322;
        this.childMenu[2] = 2131165197;
        this.childMenu[3] = 2131165288;
        this.childMenu[4] = 2131165731;
        this.childMenu[5] = 2131165253;
        this.childMenu[6] = 2131165206;
      }
      if (!listAppsFragment.su)
      {
        this.childMenu = new int[6];
        this.childMenu[0] = 2131165207;
        this.childMenu[1] = 2131165322;
        this.childMenu[2] = 2131165197;
        this.childMenu[3] = 2131165288;
        this.childMenu[4] = 2131165731;
        this.childMenu[5] = 2131165206;
      }
      if (localObject == null)
      {
        this.childMenu = new int[1];
        this.childMenu[0] = 2131165757;
      }
      if (this.childMenu != null) {
        break label364;
      }
      return 0;
    }
    label364:
    return this.childMenu.length;
  }
  
  public Filter getFilter()
  {
    new Filter()
    {
      protected Filter.FilterResults performFiltering(CharSequence paramAnonymousCharSequence)
      {
        Filter.FilterResults localFilterResults = new Filter.FilterResults();
        ArrayList localArrayList = new ArrayList();
        if (PkgListItemAdapter.this.orig == null) {
          PkgListItemAdapter.this.orig = PkgListItemAdapter.this.data;
        }
        if (paramAnonymousCharSequence != null)
        {
          if ((PkgListItemAdapter.this.orig != null) && (PkgListItemAdapter.this.orig.length > 0))
          {
            PkgListItem[] arrayOfPkgListItem = PkgListItemAdapter.this.orig;
            int j = arrayOfPkgListItem.length;
            int i = 0;
            while (i < j)
            {
              PkgListItem localPkgListItem = arrayOfPkgListItem[i];
              if ((localPkgListItem.name.toLowerCase().contains(paramAnonymousCharSequence.toString().toLowerCase())) || (localPkgListItem.pkgName.toLowerCase().contains(paramAnonymousCharSequence.toString().toLowerCase()))) {
                localArrayList.add(localPkgListItem);
              }
              i += 1;
            }
          }
          paramAnonymousCharSequence = new PkgListItem[localArrayList.size()];
          localArrayList.toArray(paramAnonymousCharSequence);
          localFilterResults.values = paramAnonymousCharSequence;
        }
        return localFilterResults;
      }
      
      protected void publishResults(CharSequence paramAnonymousCharSequence, Filter.FilterResults paramAnonymousFilterResults)
      {
        PkgListItemAdapter.this.data = ((PkgListItem[])paramAnonymousFilterResults.values);
        PkgListItemAdapter.this.notifyDataSetChanged();
      }
    };
  }
  
  public PkgListItem getGroup(int paramInt)
  {
    return this.data[paramInt];
  }
  
  public int getGroupCount()
  {
    return this.data.length;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  /* Error */
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokevirtual 277	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:getGroup	(I)Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
    //   5: astore 10
    //   7: aload 10
    //   9: ifnull +11 -> 20
    //   12: aload 10
    //   14: getfield 335	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:hidden	Z
    //   17: ifeq +15 -> 32
    //   20: new 230	android/view/View
    //   23: dup
    //   24: aload_0
    //   25: getfield 83	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:context	Landroid/content/Context;
    //   28: invokespecial 338	android/view/View:<init>	(Landroid/content/Context;)V
    //   31: areturn
    //   32: aload_3
    //   33: astore 9
    //   35: aload_3
    //   36: ifnonnull +27 -> 63
    //   39: aload_0
    //   40: getfield 83	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:context	Landroid/content/Context;
    //   43: ldc -42
    //   45: invokevirtual 220	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: checkcast 222	android/view/LayoutInflater
    //   51: aload_0
    //   52: getfield 85	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:layoutResourceId	I
    //   55: aload 4
    //   57: iconst_0
    //   58: invokevirtual 341	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   61: astore 9
    //   63: aload_0
    //   64: aload 9
    //   66: ldc_w 342
    //   69: invokevirtual 234	android/view/View:findViewById	(I)Landroid/view/View;
    //   72: checkcast 236	android/widget/TextView
    //   75: putfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   78: aload_0
    //   79: aload 9
    //   81: ldc_w 345
    //   84: invokevirtual 234	android/view/View:findViewById	(I)Landroid/view/View;
    //   87: checkcast 236	android/widget/TextView
    //   90: putfield 347	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtStatus	Landroid/widget/TextView;
    //   93: aload_0
    //   94: aload 9
    //   96: ldc_w 348
    //   99: invokevirtual 234	android/view/View:findViewById	(I)Landroid/view/View;
    //   102: checkcast 259	android/widget/ImageView
    //   105: putfield 350	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:imgIcon	Landroid/widget/ImageView;
    //   108: aload_0
    //   109: aload 9
    //   111: ldc_w 351
    //   114: invokevirtual 234	android/view/View:findViewById	(I)Landroid/view/View;
    //   117: checkcast 236	android/widget/TextView
    //   120: putfield 353	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:on_top_txt	Landroid/widget/TextView;
    //   123: aload 9
    //   125: ldc_w 354
    //   128: invokevirtual 234	android/view/View:findViewById	(I)Landroid/view/View;
    //   131: checkcast 356	android/widget/CheckBox
    //   134: astore_3
    //   135: aload 9
    //   137: ldc_w 357
    //   140: invokevirtual 234	android/view/View:findViewById	(I)Landroid/view/View;
    //   143: checkcast 356	android/widget/CheckBox
    //   146: astore 4
    //   148: aload 9
    //   150: ldc_w 358
    //   153: invokevirtual 234	android/view/View:findViewById	(I)Landroid/view/View;
    //   156: checkcast 236	android/widget/TextView
    //   159: astore 11
    //   161: aload 9
    //   163: ldc_w 359
    //   166: invokevirtual 234	android/view/View:findViewById	(I)Landroid/view/View;
    //   169: checkcast 356	android/widget/CheckBox
    //   172: astore 12
    //   174: getstatic 362	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:adapterSelect	Z
    //   177: ifeq +759 -> 936
    //   180: aload 12
    //   182: iconst_0
    //   183: invokevirtual 366	android/widget/CheckBox:setVisibility	(I)V
    //   186: aload_3
    //   187: bipush 8
    //   189: invokevirtual 366	android/widget/CheckBox:setVisibility	(I)V
    //   192: aload 4
    //   194: bipush 8
    //   196: invokevirtual 366	android/widget/CheckBox:setVisibility	(I)V
    //   199: aload 11
    //   201: bipush 8
    //   203: invokevirtual 367	android/widget/TextView:setVisibility	(I)V
    //   206: aload_0
    //   207: getfield 353	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:on_top_txt	Landroid/widget/TextView;
    //   210: bipush 8
    //   212: invokevirtual 367	android/widget/TextView:setVisibility	(I)V
    //   215: aload 12
    //   217: iload_1
    //   218: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: invokevirtual 371	android/widget/CheckBox:setTag	(Ljava/lang/Object;)V
    //   224: aload 12
    //   226: new 6	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$1
    //   229: dup
    //   230: aload_0
    //   231: invokespecial 372	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$1:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;)V
    //   234: invokevirtual 376	android/widget/CheckBox:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   237: aload 10
    //   239: getfield 379	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:selected	Z
    //   242: ifeq +750 -> 992
    //   245: aload 12
    //   247: iconst_1
    //   248: invokevirtual 383	android/widget/CheckBox:setChecked	(Z)V
    //   251: aload 4
    //   253: aload 10
    //   255: getfield 386	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
    //   258: invokevirtual 383	android/widget/CheckBox:setChecked	(Z)V
    //   261: aload 4
    //   263: iconst_0
    //   264: invokevirtual 389	android/widget/CheckBox:setClickable	(Z)V
    //   267: aload 10
    //   269: getfield 392	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
    //   272: ifne +748 -> 1020
    //   275: aload 10
    //   277: getfield 395	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:on_sd	Z
    //   280: ifeq +721 -> 1001
    //   283: aload 11
    //   285: ldc_w 397
    //   288: invokevirtual 256	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   291: aload 11
    //   293: sipush 65280
    //   296: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   299: aload 11
    //   301: iconst_0
    //   302: invokevirtual 401	android/widget/TextView:setClickable	(Z)V
    //   305: aload_3
    //   306: aload 10
    //   308: getfield 404	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
    //   311: invokevirtual 383	android/widget/CheckBox:setChecked	(Z)V
    //   314: aload_3
    //   315: iconst_0
    //   316: invokevirtual 389	android/widget/CheckBox:setClickable	(Z)V
    //   319: aload_0
    //   320: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   323: aload 10
    //   325: getfield 407	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:name	Ljava/lang/String;
    //   328: invokevirtual 256	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   331: invokestatic 411	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   334: ldc_w 413
    //   337: iconst_0
    //   338: invokeinterface 419 3 0
    //   343: ifne +168 -> 511
    //   346: getstatic 422	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:goodMemory	Z
    //   349: ifeq +876 -> 1225
    //   352: aload_0
    //   353: getfield 350	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:imgIcon	Landroid/widget/ImageView;
    //   356: aconst_null
    //   357: invokevirtual 264	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   360: aload 10
    //   362: getfield 425	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:icon	Landroid/graphics/drawable/Drawable;
    //   365: ifnonnull +127 -> 492
    //   368: invokestatic 66	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getRes	()Landroid/content/res/Resources;
    //   371: invokevirtual 429	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   374: getfield 435	android/util/DisplayMetrics:density	F
    //   377: fstore 5
    //   379: ldc_w 436
    //   382: fload 5
    //   384: fmul
    //   385: ldc_w 437
    //   388: fadd
    //   389: f2i
    //   390: istore_1
    //   391: aconst_null
    //   392: astore_3
    //   393: invokestatic 281	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   396: aload 10
    //   398: getfield 152	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   401: invokevirtual 441	android/content/pm/PackageManager:getApplicationIcon	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   404: checkcast 443	android/graphics/drawable/BitmapDrawable
    //   407: invokevirtual 447	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   410: astore 4
    //   412: aload 4
    //   414: astore_3
    //   415: aload_3
    //   416: invokevirtual 452	android/graphics/Bitmap:getWidth	()I
    //   419: istore 7
    //   421: aload_3
    //   422: invokevirtual 455	android/graphics/Bitmap:getHeight	()I
    //   425: istore 8
    //   427: iload_1
    //   428: i2f
    //   429: iload 7
    //   431: i2f
    //   432: fdiv
    //   433: fstore 5
    //   435: iload_1
    //   436: i2f
    //   437: iload 8
    //   439: i2f
    //   440: fdiv
    //   441: fstore 6
    //   443: new 457	android/graphics/Matrix
    //   446: dup
    //   447: invokespecial 458	android/graphics/Matrix:<init>	()V
    //   450: astore 4
    //   452: aload 4
    //   454: fload 5
    //   456: fload 6
    //   458: invokevirtual 462	android/graphics/Matrix:postScale	(FF)Z
    //   461: pop
    //   462: aload 10
    //   464: new 443	android/graphics/drawable/BitmapDrawable
    //   467: dup
    //   468: aload_3
    //   469: iconst_0
    //   470: iconst_0
    //   471: iload 7
    //   473: iload 8
    //   475: aload 4
    //   477: iconst_1
    //   478: invokestatic 466	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   481: invokespecial 469	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   484: putfield 425	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:icon	Landroid/graphics/drawable/Drawable;
    //   487: aload 10
    //   489: invokevirtual 472	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:saveItem	()V
    //   492: aload 10
    //   494: getfield 475	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:enable	Z
    //   497: ifne +713 -> 1210
    //   500: aload_0
    //   501: getfield 350	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:imgIcon	Landroid/widget/ImageView;
    //   504: aload_0
    //   505: getfield 75	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:disabled	Landroid/graphics/drawable/Drawable;
    //   508: invokevirtual 264	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   511: aload_0
    //   512: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   515: aload_0
    //   516: getfield 83	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:context	Landroid/content/Context;
    //   519: invokestatic 239	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getSizeText	()I
    //   522: invokevirtual 243	android/widget/TextView:setTextAppearance	(Landroid/content/Context;I)V
    //   525: aload_0
    //   526: getfield 347	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtStatus	Landroid/widget/TextView;
    //   529: aload_0
    //   530: getfield 83	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:context	Landroid/content/Context;
    //   533: invokestatic 239	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getSizeText	()I
    //   536: invokevirtual 243	android/widget/TextView:setTextAppearance	(Landroid/content/Context;I)V
    //   539: aload_0
    //   540: getfield 347	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtStatus	Landroid/widget/TextView;
    //   543: aload_0
    //   544: getfield 83	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:context	Landroid/content/Context;
    //   547: ldc_w 476
    //   550: invokevirtual 243	android/widget/TextView:setTextAppearance	(Landroid/content/Context;I)V
    //   553: ldc_w 478
    //   556: astore 4
    //   558: aload 4
    //   560: astore_3
    //   561: aload 10
    //   563: getfield 481	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   566: tableswitch	default:+1259->1825, 1:+676->1242, 2:+1277->1843, 3:+38->604, 4:+1284->1850, 5:+38->604, 6:+1291->1857
    //   604: aload_3
    //   605: astore 4
    //   607: aload 10
    //   609: getfield 481	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   612: ifne +30 -> 642
    //   615: aload_3
    //   616: astore 4
    //   618: aload 10
    //   620: getfield 484	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   623: ifne +19 -> 642
    //   626: aload_3
    //   627: astore 4
    //   629: aload 10
    //   631: getfield 487	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   634: ifne +8 -> 642
    //   637: ldc_w 489
    //   640: astore 4
    //   642: aload 4
    //   644: astore_3
    //   645: aload 10
    //   647: getfield 481	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   650: ifne +18 -> 668
    //   653: aload 4
    //   655: astore_3
    //   656: aload 10
    //   658: getfield 484	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   661: ifeq +7 -> 668
    //   664: ldc_w 491
    //   667: astore_3
    //   668: aload_3
    //   669: astore 4
    //   671: aload 10
    //   673: getfield 481	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   676: ifne +19 -> 695
    //   679: aload_3
    //   680: astore 4
    //   682: aload 10
    //   684: getfield 487	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   687: ifeq +8 -> 695
    //   690: ldc_w 493
    //   693: astore 4
    //   695: aload_0
    //   696: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   699: aload 4
    //   701: invokestatic 113	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   704: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   707: aload_0
    //   708: getfield 347	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtStatus	Landroid/widget/TextView;
    //   711: ldc_w 494
    //   714: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   717: ldc_w 496
    //   720: astore 4
    //   722: invokestatic 411	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   725: ldc_w 498
    //   728: ldc_w 500
    //   731: invokeinterface 504 3 0
    //   736: astore 11
    //   738: aload 11
    //   740: ldc_w 500
    //   743: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   746: ifeq +511 -> 1257
    //   749: invokestatic 510	android/content/res/Resources:getSystem	()Landroid/content/res/Resources;
    //   752: invokevirtual 514	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   755: getfield 520	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   758: astore_3
    //   759: invokestatic 526	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   762: invokestatic 530	java/util/Locale:setDefault	(Ljava/util/Locale;)V
    //   765: new 516	android/content/res/Configuration
    //   768: dup
    //   769: invokespecial 531	android/content/res/Configuration:<init>	()V
    //   772: astore 11
    //   774: aload 11
    //   776: aload_3
    //   777: putfield 520	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   780: invokestatic 66	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getRes	()Landroid/content/res/Resources;
    //   783: aload 11
    //   785: invokestatic 66	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getRes	()Landroid/content/res/Resources;
    //   788: invokevirtual 429	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   791: invokevirtual 535	android/content/res/Resources:updateConfiguration	(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V
    //   794: aload 10
    //   796: getfield 484	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   799: ifeq +11 -> 810
    //   802: ldc_w 536
    //   805: invokestatic 252	com/chelpus/Utils:getText	(I)Ljava/lang/String;
    //   808: astore 4
    //   810: aload 10
    //   812: getfield 487	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   815: ifne +598 -> 1413
    //   818: aload 4
    //   820: astore_3
    //   821: aload 10
    //   823: getfield 484	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   826: ifne +21 -> 847
    //   829: aload 4
    //   831: astore_3
    //   832: aload 10
    //   834: getfield 539	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   837: ifne +10 -> 847
    //   840: ldc_w 540
    //   843: invokestatic 252	com/chelpus/Utils:getText	(I)Ljava/lang/String;
    //   846: astore_3
    //   847: aload 10
    //   849: getfield 543	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   852: ifeq +10 -> 862
    //   855: ldc_w 544
    //   858: invokestatic 252	com/chelpus/Utils:getText	(I)Ljava/lang/String;
    //   861: astore_3
    //   862: aload 10
    //   864: getfield 543	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   867: ifeq +964 -> 1831
    //   870: aload_0
    //   871: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   874: sipush 65280
    //   877: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   880: goto +951 -> 1831
    //   883: iload_1
    //   884: getstatic 548	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:bootlist	[Ljava/lang/String;
    //   887: arraylength
    //   888: if_icmpge +577 -> 1465
    //   891: aload 10
    //   893: getfield 551	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_ads	Z
    //   896: ifne +27 -> 923
    //   899: aload 10
    //   901: getfield 554	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_custom	Z
    //   904: ifne +19 -> 923
    //   907: aload 10
    //   909: getfield 557	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_lvl	Z
    //   912: ifne +11 -> 923
    //   915: aload 10
    //   917: getfield 560	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_manual	Z
    //   920: ifeq +916 -> 1836
    //   923: aload_0
    //   924: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   927: ldc_w 561
    //   930: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   933: goto +903 -> 1836
    //   936: aload 12
    //   938: invokevirtual 564	android/widget/CheckBox:getVisibility	()I
    //   941: ifne -704 -> 237
    //   944: aload 12
    //   946: bipush 8
    //   948: invokevirtual 366	android/widget/CheckBox:setVisibility	(I)V
    //   951: aload_3
    //   952: iconst_0
    //   953: invokevirtual 366	android/widget/CheckBox:setVisibility	(I)V
    //   956: aload 4
    //   958: iconst_0
    //   959: invokevirtual 366	android/widget/CheckBox:setVisibility	(I)V
    //   962: aload 11
    //   964: iconst_0
    //   965: invokevirtual 367	android/widget/TextView:setVisibility	(I)V
    //   968: aload_0
    //   969: getfield 353	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:on_top_txt	Landroid/widget/TextView;
    //   972: iconst_0
    //   973: invokevirtual 367	android/widget/TextView:setVisibility	(I)V
    //   976: goto -739 -> 237
    //   979: astore_3
    //   980: new 230	android/view/View
    //   983: dup
    //   984: aload_0
    //   985: getfield 83	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:context	Landroid/content/Context;
    //   988: invokespecial 338	android/view/View:<init>	(Landroid/content/Context;)V
    //   991: areturn
    //   992: aload 12
    //   994: iconst_0
    //   995: invokevirtual 383	android/widget/CheckBox:setChecked	(Z)V
    //   998: goto -747 -> 251
    //   1001: aload 11
    //   1003: ldc_w 566
    //   1006: invokevirtual 256	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1009: aload 11
    //   1011: ldc_w 567
    //   1014: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   1017: goto -718 -> 299
    //   1020: invokestatic 281	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   1023: aload 10
    //   1025: getfield 152	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1028: iconst_0
    //   1029: invokevirtual 287	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1032: getfield 293	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   1035: getfield 298	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   1038: ldc_w 569
    //   1041: invokevirtual 306	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1044: ifeq +22 -> 1066
    //   1047: aload 11
    //   1049: ldc_w 571
    //   1052: invokevirtual 256	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1055: aload 11
    //   1057: ldc_w 561
    //   1060: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   1063: goto -764 -> 299
    //   1066: aload 11
    //   1068: ldc_w 566
    //   1071: invokevirtual 256	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1074: aload 11
    //   1076: ldc_w 567
    //   1079: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   1082: goto -783 -> 299
    //   1085: astore 4
    //   1087: aload 4
    //   1089: invokevirtual 318	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   1092: goto -677 -> 415
    //   1095: astore_3
    //   1096: aload_3
    //   1097: invokevirtual 572	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1100: invokestatic 575	java/lang/System:gc	()V
    //   1103: invokestatic 411	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
    //   1106: invokeinterface 579 1 0
    //   1111: ldc_w 413
    //   1114: iconst_1
    //   1115: invokeinterface 585 3 0
    //   1120: invokeinterface 589 1 0
    //   1125: pop
    //   1126: goto -615 -> 511
    //   1129: astore_3
    //   1130: aload_3
    //   1131: invokevirtual 572	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1134: iconst_0
    //   1135: putstatic 422	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:goodMemory	Z
    //   1138: goto -651 -> 487
    //   1141: astore_3
    //   1142: aload_3
    //   1143: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   1146: aload 10
    //   1148: getfield 407	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:name	Ljava/lang/String;
    //   1151: ifnull +17 -> 1168
    //   1154: aload 10
    //   1156: getfield 407	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:name	Ljava/lang/String;
    //   1159: ldc_w 496
    //   1162: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1165: ifeq +16 -> 1181
    //   1168: aload_0
    //   1169: aload 10
    //   1171: getfield 152	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1174: invokevirtual 592	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:remove	(Ljava/lang/String;)V
    //   1177: aload_0
    //   1178: invokevirtual 184	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:notifyDataSetChanged	()V
    //   1181: getstatic 139	java/lang/System:out	Ljava/io/PrintStream;
    //   1184: new 141	java/lang/StringBuilder
    //   1187: dup
    //   1188: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1191: ldc_w 594
    //   1194: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: aload_3
    //   1198: invokevirtual 597	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1201: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: invokevirtual 162	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1207: goto -696 -> 511
    //   1210: aload_0
    //   1211: getfield 350	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:imgIcon	Landroid/widget/ImageView;
    //   1214: aload 10
    //   1216: getfield 425	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:icon	Landroid/graphics/drawable/Drawable;
    //   1219: invokevirtual 264	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1222: goto -711 -> 511
    //   1225: aload_0
    //   1226: getfield 83	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:context	Landroid/content/Context;
    //   1229: ldc_w 599
    //   1232: iconst_0
    //   1233: invokestatic 605	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1236: invokevirtual 608	android/widget/Toast:show	()V
    //   1239: goto -728 -> 511
    //   1242: ldc_w 610
    //   1245: astore_3
    //   1246: goto -642 -> 604
    //   1249: astore_3
    //   1250: aload_3
    //   1251: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   1254: goto -460 -> 794
    //   1257: aconst_null
    //   1258: astore_3
    //   1259: aload 11
    //   1261: ldc_w 612
    //   1264: invokevirtual 616	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1267: astore 11
    //   1269: aload 11
    //   1271: arraylength
    //   1272: iconst_1
    //   1273: if_icmpne +15 -> 1288
    //   1276: new 522	java/util/Locale
    //   1279: dup
    //   1280: aload 11
    //   1282: iconst_0
    //   1283: aaload
    //   1284: invokespecial 618	java/util/Locale:<init>	(Ljava/lang/String;)V
    //   1287: astore_3
    //   1288: aload 11
    //   1290: arraylength
    //   1291: iconst_2
    //   1292: if_icmpne +50 -> 1342
    //   1295: new 522	java/util/Locale
    //   1298: dup
    //   1299: aload 11
    //   1301: iconst_0
    //   1302: aaload
    //   1303: aload 11
    //   1305: iconst_1
    //   1306: aaload
    //   1307: ldc_w 496
    //   1310: invokespecial 621	java/util/Locale:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1313: astore_3
    //   1314: aload 11
    //   1316: iconst_1
    //   1317: aaload
    //   1318: ldc_w 623
    //   1321: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1324: ifeq +18 -> 1342
    //   1327: new 522	java/util/Locale
    //   1330: dup
    //   1331: aload 11
    //   1333: iconst_0
    //   1334: aaload
    //   1335: ldc_w 625
    //   1338: invokespecial 628	java/util/Locale:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1341: astore_3
    //   1342: aload 11
    //   1344: arraylength
    //   1345: iconst_3
    //   1346: if_icmpne +23 -> 1369
    //   1349: new 522	java/util/Locale
    //   1352: dup
    //   1353: aload 11
    //   1355: iconst_0
    //   1356: aaload
    //   1357: aload 11
    //   1359: iconst_1
    //   1360: aaload
    //   1361: aload 11
    //   1363: iconst_2
    //   1364: aaload
    //   1365: invokespecial 621	java/util/Locale:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1368: astore_3
    //   1369: aload_3
    //   1370: invokestatic 530	java/util/Locale:setDefault	(Ljava/util/Locale;)V
    //   1373: new 516	android/content/res/Configuration
    //   1376: dup
    //   1377: invokespecial 531	android/content/res/Configuration:<init>	()V
    //   1380: astore 11
    //   1382: aload 11
    //   1384: aload_3
    //   1385: putfield 520	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   1388: invokestatic 66	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getRes	()Landroid/content/res/Resources;
    //   1391: aload 11
    //   1393: invokestatic 66	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getRes	()Landroid/content/res/Resources;
    //   1396: invokevirtual 429	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1399: invokevirtual 535	android/content/res/Resources:updateConfiguration	(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V
    //   1402: goto -608 -> 794
    //   1405: astore_3
    //   1406: aload_3
    //   1407: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   1410: goto -616 -> 794
    //   1413: aload 10
    //   1415: getfield 484	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
    //   1418: ifne +13 -> 1431
    //   1421: ldc_w 629
    //   1424: invokestatic 252	com/chelpus/Utils:getText	(I)Ljava/lang/String;
    //   1427: astore_3
    //   1428: goto -581 -> 847
    //   1431: new 141	java/lang/StringBuilder
    //   1434: dup
    //   1435: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1438: aload 4
    //   1440: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: ldc_w 631
    //   1446: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: ldc_w 629
    //   1452: invokestatic 252	com/chelpus/Utils:getText	(I)Ljava/lang/String;
    //   1455: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1461: astore_3
    //   1462: goto -615 -> 847
    //   1465: aload_3
    //   1466: astore 4
    //   1468: aload 10
    //   1470: getfield 539	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
    //   1473: ifeq +67 -> 1540
    //   1476: aload_3
    //   1477: ldc_w 496
    //   1480: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1483: ifeq +295 -> 1778
    //   1486: ldc_w 632
    //   1489: invokestatic 252	com/chelpus/Utils:getText	(I)Ljava/lang/String;
    //   1492: astore_3
    //   1493: aload 10
    //   1495: getfield 487	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
    //   1498: ifne +366 -> 1864
    //   1501: iconst_1
    //   1502: istore_1
    //   1503: aload 10
    //   1505: getfield 543	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
    //   1508: ifne +361 -> 1869
    //   1511: iconst_1
    //   1512: istore 7
    //   1514: aload_3
    //   1515: astore 4
    //   1517: iload 7
    //   1519: iload_1
    //   1520: iand
    //   1521: ifeq +19 -> 1540
    //   1524: aload_0
    //   1525: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   1528: ldc_w 634
    //   1531: invokestatic 113	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1534: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   1537: aload_3
    //   1538: astore 4
    //   1540: aload_0
    //   1541: getfield 347	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtStatus	Landroid/widget/TextView;
    //   1544: aload 4
    //   1546: invokevirtual 256	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1549: aload 10
    //   1551: getfield 392	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
    //   1554: ifeq +13 -> 1567
    //   1557: aload_0
    //   1558: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   1561: ldc_w 635
    //   1564: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   1567: aload_0
    //   1568: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   1571: invokevirtual 639	android/widget/TextView:getTypeface	()Landroid/graphics/Typeface;
    //   1574: astore_3
    //   1575: aload_0
    //   1576: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   1579: aload_3
    //   1580: iconst_0
    //   1581: invokevirtual 643	android/widget/TextView:setTypeface	(Landroid/graphics/Typeface;I)V
    //   1584: aload 10
    //   1586: getfield 475	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:enable	Z
    //   1589: ifne +23 -> 1612
    //   1592: aload_0
    //   1593: getfield 344	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtTitle	Landroid/widget/TextView;
    //   1596: ldc_w 494
    //   1599: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   1602: aload_0
    //   1603: getfield 347	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtStatus	Landroid/widget/TextView;
    //   1606: ldc_w 494
    //   1609: invokevirtual 400	android/widget/TextView:setTextColor	(I)V
    //   1612: aload 10
    //   1614: getfield 481	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
    //   1617: ifne +194 -> 1811
    //   1620: aload_0
    //   1621: getfield 353	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:on_top_txt	Landroid/widget/TextView;
    //   1624: iconst_0
    //   1625: invokevirtual 367	android/widget/TextView:setVisibility	(I)V
    //   1628: aload_0
    //   1629: getfield 353	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:on_top_txt	Landroid/widget/TextView;
    //   1632: ldc_w 644
    //   1635: invokestatic 252	com/chelpus/Utils:getText	(I)Ljava/lang/String;
    //   1638: invokevirtual 256	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1641: getstatic 362	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:adapterSelect	Z
    //   1644: ifeq +178 -> 1822
    //   1647: aload_0
    //   1648: getfield 353	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:on_top_txt	Landroid/widget/TextView;
    //   1651: bipush 8
    //   1653: invokevirtual 367	android/widget/TextView:setVisibility	(I)V
    //   1656: getstatic 647	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:adapterSelectType	I
    //   1659: ldc_w 648
    //   1662: if_icmpeq +12 -> 1674
    //   1665: getstatic 647	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:adapterSelectType	I
    //   1668: ldc_w 649
    //   1671: if_icmpne +151 -> 1822
    //   1674: aload_0
    //   1675: getfield 353	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:on_top_txt	Landroid/widget/TextView;
    //   1678: bipush 8
    //   1680: invokevirtual 367	android/widget/TextView:setVisibility	(I)V
    //   1683: new 651	java/io/File
    //   1686: dup
    //   1687: invokestatic 281	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   1690: aload 10
    //   1692: getfield 152	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
    //   1695: iconst_0
    //   1696: invokevirtual 287	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1699: getfield 293	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   1702: getfield 298	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   1705: invokespecial 652	java/io/File:<init>	(Ljava/lang/String;)V
    //   1708: astore_3
    //   1709: aload_0
    //   1710: getfield 347	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:txtStatus	Landroid/widget/TextView;
    //   1713: new 141	java/lang/StringBuilder
    //   1716: dup
    //   1717: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1720: ldc_w 653
    //   1723: invokestatic 252	com/chelpus/Utils:getText	(I)Ljava/lang/String;
    //   1726: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: ldc_w 655
    //   1732: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1735: ldc_w 657
    //   1738: iconst_1
    //   1739: anewarray 659	java/lang/Object
    //   1742: dup
    //   1743: iconst_0
    //   1744: aload_3
    //   1745: invokevirtual 663	java/io/File:length	()J
    //   1748: l2f
    //   1749: ldc_w 664
    //   1752: fdiv
    //   1753: invokestatic 669	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1756: aastore
    //   1757: invokestatic 673	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1760: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: ldc_w 675
    //   1766: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1772: invokevirtual 256	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1775: aload 9
    //   1777: areturn
    //   1778: new 141	java/lang/StringBuilder
    //   1781: dup
    //   1782: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1785: aload_3
    //   1786: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1789: ldc_w 631
    //   1792: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: ldc_w 632
    //   1798: invokestatic 252	com/chelpus/Utils:getText	(I)Ljava/lang/String;
    //   1801: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1804: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1807: astore_3
    //   1808: goto -315 -> 1493
    //   1811: aload_0
    //   1812: getfield 353	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:on_top_txt	Landroid/widget/TextView;
    //   1815: iconst_4
    //   1816: invokevirtual 367	android/widget/TextView:setVisibility	(I)V
    //   1819: goto -178 -> 1641
    //   1822: aload 9
    //   1824: areturn
    //   1825: aload 4
    //   1827: astore_3
    //   1828: goto -1224 -> 604
    //   1831: iconst_0
    //   1832: istore_1
    //   1833: goto -950 -> 883
    //   1836: iload_1
    //   1837: iconst_1
    //   1838: iadd
    //   1839: istore_1
    //   1840: goto -957 -> 883
    //   1843: ldc_w 493
    //   1846: astore_3
    //   1847: goto -1243 -> 604
    //   1850: ldc_w 491
    //   1853: astore_3
    //   1854: goto -1250 -> 604
    //   1857: ldc_w 489
    //   1860: astore_3
    //   1861: goto -1257 -> 604
    //   1864: iconst_0
    //   1865: istore_1
    //   1866: goto -363 -> 1503
    //   1869: iconst_0
    //   1870: istore 7
    //   1872: goto -358 -> 1514
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1875	0	this	PkgListItemAdapter
    //   0	1875	1	paramInt	int
    //   0	1875	2	paramBoolean	boolean
    //   0	1875	3	paramView	View
    //   0	1875	4	paramViewGroup	ViewGroup
    //   377	78	5	f1	float
    //   441	16	6	f2	float
    //   419	1452	7	i	int
    //   425	49	8	j	int
    //   33	1790	9	localView	View
    //   5	1686	10	localPkgListItem	PkgListItem
    //   159	1233	11	localObject	Object
    //   172	821	12	localCheckBox	android.widget.CheckBox
    // Exception table:
    //   from	to	target	type
    //   0	7	979	java/lang/Exception
    //   12	20	979	java/lang/Exception
    //   20	32	979	java/lang/Exception
    //   39	63	979	java/lang/Exception
    //   63	237	979	java/lang/Exception
    //   237	251	979	java/lang/Exception
    //   251	299	979	java/lang/Exception
    //   299	331	979	java/lang/Exception
    //   511	553	979	java/lang/Exception
    //   561	604	979	java/lang/Exception
    //   607	615	979	java/lang/Exception
    //   618	626	979	java/lang/Exception
    //   629	637	979	java/lang/Exception
    //   645	653	979	java/lang/Exception
    //   656	664	979	java/lang/Exception
    //   671	679	979	java/lang/Exception
    //   682	690	979	java/lang/Exception
    //   695	717	979	java/lang/Exception
    //   722	780	979	java/lang/Exception
    //   794	810	979	java/lang/Exception
    //   810	818	979	java/lang/Exception
    //   821	829	979	java/lang/Exception
    //   832	847	979	java/lang/Exception
    //   847	862	979	java/lang/Exception
    //   862	880	979	java/lang/Exception
    //   883	923	979	java/lang/Exception
    //   923	933	979	java/lang/Exception
    //   936	976	979	java/lang/Exception
    //   992	998	979	java/lang/Exception
    //   1001	1017	979	java/lang/Exception
    //   1020	1063	979	java/lang/Exception
    //   1066	1082	979	java/lang/Exception
    //   1096	1126	979	java/lang/Exception
    //   1142	1168	979	java/lang/Exception
    //   1168	1181	979	java/lang/Exception
    //   1181	1207	979	java/lang/Exception
    //   1250	1254	979	java/lang/Exception
    //   1259	1269	979	java/lang/Exception
    //   1269	1288	979	java/lang/Exception
    //   1288	1314	979	java/lang/Exception
    //   1314	1342	979	java/lang/Exception
    //   1342	1369	979	java/lang/Exception
    //   1369	1388	979	java/lang/Exception
    //   1406	1410	979	java/lang/Exception
    //   1413	1428	979	java/lang/Exception
    //   1431	1462	979	java/lang/Exception
    //   1468	1493	979	java/lang/Exception
    //   1493	1501	979	java/lang/Exception
    //   1503	1511	979	java/lang/Exception
    //   1524	1537	979	java/lang/Exception
    //   1540	1567	979	java/lang/Exception
    //   1567	1612	979	java/lang/Exception
    //   1612	1641	979	java/lang/Exception
    //   1641	1674	979	java/lang/Exception
    //   1674	1775	979	java/lang/Exception
    //   1778	1808	979	java/lang/Exception
    //   1811	1819	979	java/lang/Exception
    //   393	412	1085	android/content/pm/PackageManager$NameNotFoundException
    //   331	379	1095	java/lang/OutOfMemoryError
    //   393	412	1095	java/lang/OutOfMemoryError
    //   415	462	1095	java/lang/OutOfMemoryError
    //   487	492	1095	java/lang/OutOfMemoryError
    //   492	511	1095	java/lang/OutOfMemoryError
    //   1087	1092	1095	java/lang/OutOfMemoryError
    //   1130	1138	1095	java/lang/OutOfMemoryError
    //   1210	1222	1095	java/lang/OutOfMemoryError
    //   1225	1239	1095	java/lang/OutOfMemoryError
    //   462	487	1129	java/lang/OutOfMemoryError
    //   331	379	1141	java/lang/Exception
    //   393	412	1141	java/lang/Exception
    //   415	462	1141	java/lang/Exception
    //   462	487	1141	java/lang/Exception
    //   487	492	1141	java/lang/Exception
    //   492	511	1141	java/lang/Exception
    //   1087	1092	1141	java/lang/Exception
    //   1130	1138	1141	java/lang/Exception
    //   1210	1222	1141	java/lang/Exception
    //   1225	1239	1141	java/lang/Exception
    //   780	794	1249	java/lang/Exception
    //   1388	1402	1405	java/lang/Exception
  }
  
  public PkgListItem getItem(int paramInt)
  {
    return this.data[paramInt];
  }
  
  public PkgListItem getItem(String paramString)
  {
    PkgListItem[] arrayOfPkgListItem = this.data;
    int j = arrayOfPkgListItem.length;
    int i = 0;
    while (i < j)
    {
      PkgListItem localPkgListItem = arrayOfPkgListItem[i];
      if (localPkgListItem.pkgName.contentEquals(paramString)) {
        return localPkgListItem;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void notifyDataSetChanged(PkgListItem paramPkgListItem)
  {
    super.notifyDataSetChanged();
    if (listAppsFragment.database == null) {
      listAppsFragment.database = new DatabaseHelper(this.context);
    }
    listAppsFragment.database.savePackage(paramPkgListItem);
  }
  
  public void onGroupCollapsed(int paramInt)
  {
    super.onGroupCollapsed(paramInt);
  }
  
  public void onGroupCollapsedAll()
  {
    if (this.data.length > 0)
    {
      int i = 0;
      while (i < this.data.length)
      {
        listAppsFragment.pli = null;
        listAppsFragment.lv.collapseGroup(i);
        i += 1;
      }
      listAppsFragment.pli = null;
    }
  }
  
  public void onGroupExpanded(int paramInt)
  {
    if (paramInt != listAppsFragment.lastExpandedGroupPosition) {
      listAppsFragment.lv.collapseGroup(listAppsFragment.lastExpandedGroupPosition);
    }
    super.onGroupExpanded(paramInt);
    listAppsFragment.pli = getGroup(paramInt);
    listAppsFragment.lastExpandedGroupPosition = paramInt;
  }
  
  public void refreshPkgs(boolean paramBoolean)
  {
    if ((!listAppsFragment.addapps) && (listAppsFragment.refresh))
    {
      System.out.println("LuckyPatcher: start refreshPackages.");
      listAppsFragment.addapps = true;
      Thread localThread = new Thread(new Refresh_Packages());
      localThread.setPriority(1);
      localThread.start();
      return;
    }
    System.out.println("LuckyPatcher: finalize refreshPackages.");
    listAppsFragment.refresh = false;
  }
  
  public void remove(String paramString)
  {
    if (checkItem(paramString)) {
      try
      {
        PkgListItem[] arrayOfPkgListItem = new PkgListItem[this.data.length - 1];
        int j = 0;
        int i = 0;
        for (;;)
        {
          if (i < this.data.length)
          {
            if (!this.data[i].pkgName.equals(paramString))
            {
              arrayOfPkgListItem[j] = this.data[i];
              j += 1;
            }
            else
            {
              listAppsFragment.lv.collapseGroup(i);
            }
          }
          else
          {
            this.data = arrayOfPkgListItem;
            notifyDataSetChanged();
            return;
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public void setTextSize(int paramInt)
  {
    this.size = paramInt;
    notifyDataSetChanged();
  }
  
  public int size()
  {
    return this.data.length;
  }
  
  public void sort()
  {
    try
    {
      Arrays.sort(this.data, this.sorter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void updateItem(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject = this.data;
        int j = localObject.length;
        if (i >= j) {
          break;
        }
        PkgListItem localPkgListItem = localObject[i];
        if (localPkgListItem.pkgName.contentEquals(paramString))
        {
          localObject = new PkgListItem(this.context, paramString, listAppsFragment.days, false);
          if (((PkgListItem)localObject).equalsPli(localPkgListItem)) {
            break;
          }
          ((PkgListItem)localObject).saveItem();
          localPkgListItem.pkgName = ((PkgListItem)localObject).pkgName;
          localPkgListItem.name = ((PkgListItem)localObject).name;
          localPkgListItem.storepref = ((PkgListItem)localObject).storepref;
          localPkgListItem.stored = ((PkgListItem)localObject).stored;
          localPkgListItem.hidden = ((PkgListItem)localObject).hidden;
          localPkgListItem.boot_ads = ((PkgListItem)localObject).boot_ads;
          localPkgListItem.boot_lvl = ((PkgListItem)localObject).boot_lvl;
          localPkgListItem.boot_custom = ((PkgListItem)localObject).boot_custom;
          localPkgListItem.boot_manual = ((PkgListItem)localObject).boot_manual;
          localPkgListItem.custom = ((PkgListItem)localObject).custom;
          localPkgListItem.on_sd = Utils.isInstalledOnSdCard(((PkgListItem)localObject).pkgName);
          localPkgListItem.lvl = ((PkgListItem)localObject).lvl;
          localPkgListItem.ads = ((PkgListItem)localObject).ads;
          localPkgListItem.billing = ((PkgListItem)localObject).billing;
          if (listAppsFragment.getConfig().getBoolean(paramString, false)) {
            localPkgListItem.modified = true;
          }
          localPkgListItem.system = ((PkgListItem)localObject).system;
          localPkgListItem.updatetime = ((PkgListItem)localObject).updatetime;
          if (Utils.isOdex(listAppsFragment.getPkgMng().getApplicationInfo(paramString, 0).sourceDir))
          {
            localPkgListItem.odex = true;
            localPkgListItem.enable = ((PkgListItem)localObject).enable;
            return;
          }
          localPkgListItem.odex = false;
          continue;
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        System.out.println("LuckyPatcher (updateItem PkgListItemAdapter):" + paramString);
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  class Refresh_Packages
    implements Runnable
  {
    Refresh_Packages() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: putstatic 40	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:refresh	Z
      //   4: aload_0
      //   5: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   8: new 42	java/util/ArrayList
      //   11: dup
      //   12: invokespecial 43	java/util/ArrayList:<init>	()V
      //   15: putfield 47	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:add	Ljava/util/ArrayList;
      //   18: aload_0
      //   19: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   22: new 42	java/util/ArrayList
      //   25: dup
      //   26: invokespecial 43	java/util/ArrayList:<init>	()V
      //   29: putfield 50	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:del	Ljava/util/ArrayList;
      //   32: new 42	java/util/ArrayList
      //   35: dup
      //   36: invokespecial 43	java/util/ArrayList:<init>	()V
      //   39: pop
      //   40: invokestatic 54	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPackages	()[Ljava/lang/String;
      //   43: astore 9
      //   45: getstatic 58	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:database	Lcom/android/vending/billing/InAppBillingService/LACK/DatabaseHelper;
      //   48: ifnonnull +16 -> 64
      //   51: new 60	com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper
      //   54: dup
      //   55: invokestatic 64	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
      //   58: invokespecial 67	com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper:<init>	(Landroid/content/Context;)V
      //   61: putstatic 58	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:database	Lcom/android/vending/billing/InAppBillingService/LACK/DatabaseHelper;
      //   64: getstatic 58	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:database	Lcom/android/vending/billing/InAppBillingService/LACK/DatabaseHelper;
      //   67: iconst_1
      //   68: iconst_1
      //   69: invokevirtual 71	com/android/vending/billing/InAppBillingService/LACK/DatabaseHelper:getPackage	(ZZ)Ljava/util/ArrayList;
      //   72: astore 11
      //   74: invokestatic 75	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getConfig	()Landroid/content/SharedPreferences;
      //   77: ldc 77
      //   79: iconst_0
      //   80: invokeinterface 83 3 0
      //   85: pop
      //   86: aload_0
      //   87: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   90: getfield 47	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:add	Ljava/util/ArrayList;
      //   93: invokevirtual 86	java/util/ArrayList:clear	()V
      //   96: aload 11
      //   98: invokevirtual 90	java/util/ArrayList:size	()I
      //   101: anewarray 92	java/lang/String
      //   104: astore 10
      //   106: iconst_0
      //   107: istore_1
      //   108: aload 11
      //   110: invokevirtual 96	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   113: astore 11
      //   115: aload 11
      //   117: invokeinterface 102 1 0
      //   122: ifeq +27 -> 149
      //   125: aload 10
      //   127: iload_1
      //   128: aload 11
      //   130: invokeinterface 106 1 0
      //   135: checkcast 108	com/android/vending/billing/InAppBillingService/LACK/PkgListItem
      //   138: getfield 112	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
      //   141: aastore
      //   142: iload_1
      //   143: iconst_1
      //   144: iadd
      //   145: istore_1
      //   146: goto -31 -> 115
      //   149: aload 9
      //   151: arraylength
      //   152: istore 4
      //   154: iconst_0
      //   155: istore_2
      //   156: iload_2
      //   157: iload 4
      //   159: if_icmpge +260 -> 419
      //   162: aload 9
      //   164: iload_2
      //   165: aaload
      //   166: astore 11
      //   168: iconst_0
      //   169: istore_1
      //   170: aload 10
      //   172: arraylength
      //   173: istore 5
      //   175: iconst_0
      //   176: istore_3
      //   177: iload_3
      //   178: iload 5
      //   180: if_icmpge +61 -> 241
      //   183: aload 10
      //   185: iload_3
      //   186: aaload
      //   187: invokevirtual 116	java/lang/String:trim	()Ljava/lang/String;
      //   190: aload 11
      //   192: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   195: ifeq +5 -> 200
      //   198: iconst_1
      //   199: istore_1
      //   200: aload 11
      //   202: ldc 122
      //   204: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   207: ifne +25 -> 232
      //   210: aload 11
      //   212: aload_0
      //   213: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   216: invokestatic 126	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:access$000	(Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;)Landroid/content/Context;
      //   219: invokevirtual 131	android/content/Context:getPackageName	()Ljava/lang/String;
      //   222: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   225: istore 6
      //   227: iload 6
      //   229: ifeq +5 -> 234
      //   232: iconst_1
      //   233: istore_1
      //   234: iload_3
      //   235: iconst_1
      //   236: iadd
      //   237: istore_3
      //   238: goto -61 -> 177
      //   241: iload_1
      //   242: ifne +39 -> 281
      //   245: new 108	com/android/vending/billing/InAppBillingService/LACK/PkgListItem
      //   248: dup
      //   249: invokestatic 64	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
      //   252: aload 11
      //   254: getstatic 135	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:days	I
      //   257: iconst_1
      //   258: invokespecial 138	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:<init>	(Landroid/content/Context;Ljava/lang/String;IZ)V
      //   261: astore 11
      //   263: aload 11
      //   265: invokevirtual 141	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:saveItem	()V
      //   268: aload_0
      //   269: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   272: getfield 47	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:add	Ljava/util/ArrayList;
      //   275: aload 11
      //   277: invokevirtual 143	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   280: pop
      //   281: iload_2
      //   282: iconst_1
      //   283: iadd
      //   284: istore_2
      //   285: goto -129 -> 156
      //   288: astore 11
      //   290: aload 11
      //   292: invokevirtual 146	java/lang/Exception:printStackTrace	()V
      //   295: getstatic 152	java/lang/System:out	Ljava/io/PrintStream;
      //   298: new 154	java/lang/StringBuilder
      //   301: dup
      //   302: invokespecial 155	java/lang/StringBuilder:<init>	()V
      //   305: ldc -99
      //   307: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   310: aload 11
      //   312: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   315: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   318: invokevirtual 173	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   321: goto -40 -> 281
      //   324: astore 11
      //   326: getstatic 152	java/lang/System:out	Ljava/io/PrintStream;
      //   329: new 154	java/lang/StringBuilder
      //   332: dup
      //   333: invokespecial 155	java/lang/StringBuilder:<init>	()V
      //   336: ldc -81
      //   338: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   341: aload 11
      //   343: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   346: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   349: invokevirtual 173	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   352: goto -71 -> 281
      //   355: astore 9
      //   357: iconst_0
      //   358: putstatic 178	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:addapps	Z
      //   361: aload_0
      //   362: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   365: invokestatic 126	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:access$000	(Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;)Landroid/content/Context;
      //   368: checkcast 180	android/app/Activity
      //   371: new 13	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages$2
      //   374: dup
      //   375: aload_0
      //   376: invokespecial 183	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages$2:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages;)V
      //   379: invokevirtual 187	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
      //   382: return
      //   383: astore 11
      //   385: getstatic 152	java/lang/System:out	Ljava/io/PrintStream;
      //   388: new 154	java/lang/StringBuilder
      //   391: dup
      //   392: invokespecial 155	java/lang/StringBuilder:<init>	()V
      //   395: ldc -67
      //   397: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   400: aload 11
      //   402: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   405: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   408: invokevirtual 173	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   411: aload 11
      //   413: invokevirtual 146	java/lang/Exception:printStackTrace	()V
      //   416: goto -135 -> 281
      //   419: invokestatic 193	java/lang/System:currentTimeMillis	()J
      //   422: lstore 7
      //   424: aload_0
      //   425: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   428: getfield 197	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:data	[Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
      //   431: astore 10
      //   433: aload 10
      //   435: arraylength
      //   436: istore 4
      //   438: iconst_0
      //   439: istore_1
      //   440: iload_1
      //   441: iload 4
      //   443: if_icmpge +76 -> 519
      //   446: aload 10
      //   448: iload_1
      //   449: aaload
      //   450: astore 11
      //   452: iconst_0
      //   453: istore_3
      //   454: aload 9
      //   456: arraylength
      //   457: istore 5
      //   459: iconst_0
      //   460: istore_2
      //   461: iload_2
      //   462: iload 5
      //   464: if_icmpge +27 -> 491
      //   467: aload 9
      //   469: iload_2
      //   470: aaload
      //   471: astore 12
      //   473: aload 11
      //   475: getfield 112	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
      //   478: aload 12
      //   480: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   483: ifeq +500 -> 983
      //   486: iconst_1
      //   487: istore_3
      //   488: goto +495 -> 983
      //   491: iload_3
      //   492: ifne +498 -> 990
      //   495: aload_0
      //   496: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   499: getfield 50	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:del	Ljava/util/ArrayList;
      //   502: aload 11
      //   504: invokevirtual 143	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   507: pop
      //   508: getstatic 152	java/lang/System:out	Ljava/io/PrintStream;
      //   511: ldc -57
      //   513: invokevirtual 173	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   516: goto +474 -> 990
      //   519: aload_0
      //   520: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   523: getfield 47	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:add	Ljava/util/ArrayList;
      //   526: ifnonnull +39 -> 565
      //   529: aload_0
      //   530: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   533: getfield 47	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:add	Ljava/util/ArrayList;
      //   536: invokevirtual 90	java/util/ArrayList:size	()I
      //   539: ifgt +26 -> 565
      //   542: aload_0
      //   543: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   546: getfield 50	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:del	Ljava/util/ArrayList;
      //   549: ifnonnull +16 -> 565
      //   552: aload_0
      //   553: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   556: getfield 50	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:del	Ljava/util/ArrayList;
      //   559: invokevirtual 90	java/util/ArrayList:size	()I
      //   562: ifle +24 -> 586
      //   565: aload_0
      //   566: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   569: invokestatic 126	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:access$000	(Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;)Landroid/content/Context;
      //   572: checkcast 180	android/app/Activity
      //   575: new 11	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages$1
      //   578: dup
      //   579: aload_0
      //   580: invokespecial 200	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages$1:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages;)V
      //   583: invokevirtual 187	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
      //   586: iconst_1
      //   587: istore_1
      //   588: iload_1
      //   589: ifeq +356 -> 945
      //   592: aload_0
      //   593: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   596: getfield 197	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:data	[Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
      //   599: astore 9
      //   601: aload 9
      //   603: arraylength
      //   604: istore_2
      //   605: iconst_0
      //   606: istore_1
      //   607: iload_1
      //   608: iload_2
      //   609: if_icmpge +388 -> 997
      //   612: aload 9
      //   614: iload_1
      //   615: aaload
      //   616: astore 11
      //   618: new 108	com/android/vending/billing/InAppBillingService/LACK/PkgListItem
      //   621: dup
      //   622: invokestatic 64	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
      //   625: aload 11
      //   627: getfield 112	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
      //   630: getstatic 135	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:days	I
      //   633: iconst_0
      //   634: invokespecial 138	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:<init>	(Landroid/content/Context;Ljava/lang/String;IZ)V
      //   637: astore 10
      //   639: aload_0
      //   640: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   643: aload 11
      //   645: getfield 112	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
      //   648: invokevirtual 204	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:getItem	(Ljava/lang/String;)Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
      //   651: astore 11
      //   653: aload 11
      //   655: aload 10
      //   657: invokevirtual 208	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:equalsPli	(Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;)Z
      //   660: ifne +188 -> 848
      //   663: aload 11
      //   665: aload 10
      //   667: getfield 112	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
      //   670: putfield 112	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
      //   673: aload 11
      //   675: aload 10
      //   677: getfield 211	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:name	Ljava/lang/String;
      //   680: putfield 211	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:name	Ljava/lang/String;
      //   683: aload 11
      //   685: aload 10
      //   687: getfield 214	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:storepref	I
      //   690: putfield 214	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:storepref	I
      //   693: aload 11
      //   695: aload 10
      //   697: getfield 217	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
      //   700: putfield 217	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:stored	I
      //   703: aload 11
      //   705: aload 10
      //   707: getfield 220	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:hidden	Z
      //   710: putfield 220	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:hidden	Z
      //   713: aload 11
      //   715: aload 10
      //   717: getfield 223	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:statusi	Ljava/lang/String;
      //   720: putfield 223	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:statusi	Ljava/lang/String;
      //   723: aload 11
      //   725: aload 10
      //   727: getfield 226	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_ads	Z
      //   730: putfield 226	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_ads	Z
      //   733: aload 11
      //   735: aload 10
      //   737: getfield 229	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_lvl	Z
      //   740: putfield 229	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_lvl	Z
      //   743: aload 11
      //   745: aload 10
      //   747: getfield 232	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_custom	Z
      //   750: putfield 232	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_custom	Z
      //   753: aload 11
      //   755: aload 10
      //   757: getfield 235	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_manual	Z
      //   760: putfield 235	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:boot_manual	Z
      //   763: aload 11
      //   765: aload 10
      //   767: getfield 238	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
      //   770: putfield 238	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
      //   773: aload 11
      //   775: aload 10
      //   777: getfield 241	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
      //   780: putfield 241	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
      //   783: aload 11
      //   785: aload 10
      //   787: getfield 244	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
      //   790: putfield 244	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
      //   793: aload 11
      //   795: aload 10
      //   797: getfield 247	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
      //   800: putfield 247	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
      //   803: aload 11
      //   805: aload 10
      //   807: getfield 250	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
      //   810: putfield 250	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
      //   813: aload 11
      //   815: aload 10
      //   817: getfield 253	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
      //   820: putfield 253	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
      //   823: aload 11
      //   825: aload 10
      //   827: getfield 256	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
      //   830: putfield 256	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:billing	Z
      //   833: aload 11
      //   835: aload 10
      //   837: getfield 259	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:updatetime	I
      //   840: putfield 259	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:updatetime	I
      //   843: aload 10
      //   845: invokevirtual 141	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:saveItem	()V
      //   848: iload_1
      //   849: iconst_1
      //   850: iadd
      //   851: istore_1
      //   852: goto -245 -> 607
      //   855: astore 9
      //   857: getstatic 152	java/lang/System:out	Ljava/io/PrintStream;
      //   860: new 154	java/lang/StringBuilder
      //   863: dup
      //   864: invokespecial 155	java/lang/StringBuilder:<init>	()V
      //   867: ldc_w 261
      //   870: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   873: aload 9
      //   875: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   878: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   881: invokevirtual 173	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   884: aload 9
      //   886: invokevirtual 146	java/lang/Exception:printStackTrace	()V
      //   889: goto -303 -> 586
      //   892: astore 9
      //   894: iconst_1
      //   895: istore_1
      //   896: getstatic 152	java/lang/System:out	Ljava/io/PrintStream;
      //   899: ldc_w 263
      //   902: invokevirtual 173	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   905: goto -317 -> 588
      //   908: astore 9
      //   910: getstatic 152	java/lang/System:out	Ljava/io/PrintStream;
      //   913: new 154	java/lang/StringBuilder
      //   916: dup
      //   917: invokespecial 155	java/lang/StringBuilder:<init>	()V
      //   920: ldc_w 265
      //   923: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   926: aload 9
      //   928: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   931: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   934: invokevirtual 173	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   937: aload 9
      //   939: invokevirtual 146	java/lang/Exception:printStackTrace	()V
      //   942: goto +55 -> 997
      //   945: getstatic 152	java/lang/System:out	Ljava/io/PrintStream;
      //   948: invokestatic 193	java/lang/System:currentTimeMillis	()J
      //   951: lload 7
      //   953: lsub
      //   954: invokevirtual 268	java/io/PrintStream:println	(J)V
      //   957: iconst_0
      //   958: putstatic 178	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:addapps	Z
      //   961: aload_0
      //   962: getfield 21	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages:this$0	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;
      //   965: invokestatic 126	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter:access$000	(Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter;)Landroid/content/Context;
      //   968: checkcast 180	android/app/Activity
      //   971: new 15	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages$3
      //   974: dup
      //   975: aload_0
      //   976: invokespecial 269	com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages$3:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter$Refresh_Packages;)V
      //   979: invokevirtual 187	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
      //   982: return
      //   983: iload_2
      //   984: iconst_1
      //   985: iadd
      //   986: istore_2
      //   987: goto -526 -> 461
      //   990: iload_1
      //   991: iconst_1
      //   992: iadd
      //   993: istore_1
      //   994: goto -554 -> 440
      //   997: iconst_0
      //   998: istore_1
      //   999: goto -411 -> 588
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1002	0	this	Refresh_Packages
      //   107	892	1	i	int
      //   155	832	2	j	int
      //   176	316	3	k	int
      //   152	292	4	m	int
      //   173	292	5	n	int
      //   225	3	6	bool	boolean
      //   422	530	7	l	long
      //   43	120	9	arrayOfString	String[]
      //   355	113	9	localRuntimeException	RuntimeException
      //   599	14	9	arrayOfPkgListItem	PkgListItem[]
      //   855	30	9	localException1	Exception
      //   892	1	9	localConcurrentModificationException	java.util.ConcurrentModificationException
      //   908	30	9	localException2	Exception
      //   104	740	10	localObject1	Object
      //   72	204	11	localObject2	Object
      //   288	23	11	localException3	Exception
      //   324	18	11	localIllegalArgumentException	IllegalArgumentException
      //   383	29	11	localException4	Exception
      //   450	384	11	localObject3	Object
      //   471	8	12	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   245	281	288	java/lang/Exception
      //   170	175	324	java/lang/IllegalArgumentException
      //   183	198	324	java/lang/IllegalArgumentException
      //   200	227	324	java/lang/IllegalArgumentException
      //   245	281	324	java/lang/IllegalArgumentException
      //   290	321	324	java/lang/IllegalArgumentException
      //   45	64	355	java/lang/RuntimeException
      //   64	106	355	java/lang/RuntimeException
      //   108	115	355	java/lang/RuntimeException
      //   115	142	355	java/lang/RuntimeException
      //   149	154	355	java/lang/RuntimeException
      //   170	175	355	java/lang/RuntimeException
      //   183	198	355	java/lang/RuntimeException
      //   200	227	355	java/lang/RuntimeException
      //   245	281	355	java/lang/RuntimeException
      //   290	321	355	java/lang/RuntimeException
      //   326	352	355	java/lang/RuntimeException
      //   385	416	355	java/lang/RuntimeException
      //   419	424	355	java/lang/RuntimeException
      //   424	438	355	java/lang/RuntimeException
      //   454	459	355	java/lang/RuntimeException
      //   473	486	355	java/lang/RuntimeException
      //   495	516	355	java/lang/RuntimeException
      //   519	565	355	java/lang/RuntimeException
      //   565	586	355	java/lang/RuntimeException
      //   592	605	355	java/lang/RuntimeException
      //   618	848	355	java/lang/RuntimeException
      //   857	889	355	java/lang/RuntimeException
      //   896	905	355	java/lang/RuntimeException
      //   910	942	355	java/lang/RuntimeException
      //   945	957	355	java/lang/RuntimeException
      //   170	175	383	java/lang/Exception
      //   183	198	383	java/lang/Exception
      //   200	227	383	java/lang/Exception
      //   290	321	383	java/lang/Exception
      //   424	438	855	java/lang/Exception
      //   454	459	855	java/lang/Exception
      //   473	486	855	java/lang/Exception
      //   495	516	855	java/lang/Exception
      //   519	565	855	java/lang/Exception
      //   565	586	855	java/lang/Exception
      //   592	605	892	java/util/ConcurrentModificationException
      //   618	848	892	java/util/ConcurrentModificationException
      //   592	605	908	java/lang/Exception
      //   618	848	908	java/lang/Exception
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/PkgListItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */