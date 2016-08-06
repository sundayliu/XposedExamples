package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.android.vending.billing.InAppBillingService.LACK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LACK.PkgListItem;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import java.io.PrintStream;

public class App_Dialog
{
  Dialog dialog = null;
  
  public void dismiss()
  {
    if (this.dialog != null)
    {
      this.dialog.dismiss();
      this.dialog = null;
    }
  }
  
  public Dialog onCreateDialog()
  {
    System.out.println("App Dialog create.");
    if ((listAppsFragment.frag == null) || (listAppsFragment.frag.getContext() == null)) {
      dismiss();
    }
    final Object localObject1 = new SpannableStringBuilder();
    final SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder();
    final SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder();
    LinearLayout localLinearLayout = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968584, null);
    final Object localObject2 = (LinearLayout)localLinearLayout.findViewById(2131558452).findViewById(2131558412);
    ImageView localImageView = (ImageView)((LinearLayout)localObject2).findViewById(2131558453);
    final TextView localTextView1 = (TextView)((LinearLayout)localObject2).findViewById(2131558454);
    final TextView localTextView2 = (TextView)((LinearLayout)localObject2).findViewById(2131558413);
    final TextView localTextView3 = (TextView)((LinearLayout)localObject2).findViewById(2131558457);
    final TextView localTextView4 = (TextView)((LinearLayout)localObject2).findViewById(2131558460);
    localObject2 = (ProgressBar)((LinearLayout)localObject2).findViewById(2131558456);
    try
    {
      localImageView.setImageDrawable(listAppsFragment.getPkgMng().getApplicationIcon(listAppsFragment.pli.pkgName));
      new Thread(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   3: getfield 75	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:name	Ljava/lang/String;
          //   6: ldc 77
          //   8: ldc 79
          //   10: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   13: astore 7
          //   15: getstatic 89	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:handler	Landroid/os/Handler;
          //   18: new 13	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1$1
          //   21: dup
          //   22: aload_0
          //   23: aload 7
          //   25: invokespecial 92	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1$1:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1;Landroid/text/SpannableString;)V
          //   28: invokevirtual 98	android/os/Handler:post	(Ljava/lang/Runnable;)Z
          //   31: pop
          //   32: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   35: getfield 102	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:enable	Z
          //   38: ifeq +600 -> 638
          //   41: new 104	java/lang/StringBuilder
          //   44: dup
          //   45: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   48: ldc 106
          //   50: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   53: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   56: ldc 116
          //   58: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   61: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   64: astore 7
          //   66: aload_0
          //   67: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   70: aload 7
          //   72: ldc 122
          //   74: ldc 122
          //   76: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   79: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   82: pop
          //   83: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   86: getfield 130	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
          //   89: ifeq +45 -> 134
          //   92: new 104	java/lang/StringBuilder
          //   95: dup
          //   96: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   99: ldc -125
          //   101: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   104: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   107: ldc 116
          //   109: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   112: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   115: astore 7
          //   117: aload_0
          //   118: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   121: aload 7
          //   123: ldc -124
          //   125: ldc 122
          //   127: invokestatic 135	com/chelpus/Utils:getColoredText	(Ljava/lang/String;ILjava/lang/String;)Landroid/text/SpannableString;
          //   130: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   133: pop
          //   134: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   137: getfield 138	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
          //   140: ifeq +45 -> 185
          //   143: new 104	java/lang/StringBuilder
          //   146: dup
          //   147: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   150: ldc -117
          //   152: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   155: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   158: ldc 116
          //   160: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   163: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   166: astore 7
          //   168: aload_0
          //   169: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   172: aload 7
          //   174: ldc -116
          //   176: ldc 122
          //   178: invokestatic 135	com/chelpus/Utils:getColoredText	(Ljava/lang/String;ILjava/lang/String;)Landroid/text/SpannableString;
          //   181: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   184: pop
          //   185: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   188: getfield 143	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
          //   191: ifeq +45 -> 236
          //   194: new 104	java/lang/StringBuilder
          //   197: dup
          //   198: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   201: ldc -112
          //   203: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   206: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   209: ldc 116
          //   211: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   214: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   217: astore 7
          //   219: aload_0
          //   220: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   223: aload 7
          //   225: ldc -124
          //   227: ldc 122
          //   229: invokestatic 135	com/chelpus/Utils:getColoredText	(Ljava/lang/String;ILjava/lang/String;)Landroid/text/SpannableString;
          //   232: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   235: pop
          //   236: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   239: getfield 143	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:ads	Z
          //   242: ifne +63 -> 305
          //   245: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   248: getfield 138	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:lvl	Z
          //   251: ifne +54 -> 305
          //   254: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   257: getfield 130	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:custom	Z
          //   260: ifne +45 -> 305
          //   263: new 104	java/lang/StringBuilder
          //   266: dup
          //   267: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   270: ldc -111
          //   272: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   275: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   278: ldc 116
          //   280: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   283: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   286: astore 7
          //   288: aload_0
          //   289: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   292: aload 7
          //   294: ldc -110
          //   296: ldc 122
          //   298: invokestatic 135	com/chelpus/Utils:getColoredText	(Ljava/lang/String;ILjava/lang/String;)Landroid/text/SpannableString;
          //   301: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   304: pop
          //   305: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   308: getfield 149	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:modified	Z
          //   311: ifeq +380 -> 691
          //   314: new 104	java/lang/StringBuilder
          //   317: dup
          //   318: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   321: ldc -106
          //   323: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   326: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   329: ldc 116
          //   331: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   334: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   337: astore 7
          //   339: aload_0
          //   340: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   343: aload 7
          //   345: ldc -116
          //   347: ldc 122
          //   349: invokestatic 135	com/chelpus/Utils:getColoredText	(Ljava/lang/String;ILjava/lang/String;)Landroid/text/SpannableString;
          //   352: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   355: pop
          //   356: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   359: getfield 153	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:odex	Z
          //   362: ifeq +374 -> 736
          //   365: new 104	java/lang/StringBuilder
          //   368: dup
          //   369: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   372: ldc -102
          //   374: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   377: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   380: ldc 116
          //   382: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   385: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   388: astore 7
          //   390: aload_0
          //   391: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   394: aload 7
          //   396: ldc -124
          //   398: ldc 122
          //   400: invokestatic 135	com/chelpus/Utils:getColoredText	(Ljava/lang/String;ILjava/lang/String;)Landroid/text/SpannableString;
          //   403: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   406: pop
          //   407: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   410: getfield 157	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:system	Z
          //   413: ifeq +368 -> 781
          //   416: ldc -98
          //   418: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   421: astore 7
          //   423: aload_0
          //   424: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   427: aload 7
          //   429: ldc -97
          //   431: ldc 122
          //   433: invokestatic 135	com/chelpus/Utils:getColoredText	(Ljava/lang/String;ILjava/lang/String;)Landroid/text/SpannableString;
          //   436: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   439: pop
          //   440: getstatic 89	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:handler	Landroid/os/Handler;
          //   443: new 15	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1$2
          //   446: dup
          //   447: aload_0
          //   448: invokespecial 162	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1$2:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1;)V
          //   451: invokevirtual 98	android/os/Handler:post	(Ljava/lang/Runnable;)Z
          //   454: pop
          //   455: invokestatic 166	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   458: astore 9
          //   460: aload_0
          //   461: getfield 44	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder3	Landroid/text/SpannableStringBuilder;
          //   464: invokevirtual 169	android/text/SpannableStringBuilder:clear	()V
          //   467: aload 9
          //   469: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   472: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   475: sipush 4096
          //   478: invokevirtual 178	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
          //   481: getfield 184	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
          //   484: astore 10
          //   486: aload 10
          //   488: ifnull +360 -> 848
          //   491: aload 10
          //   493: arraylength
          //   494: ifle +354 -> 848
          //   497: aload 10
          //   499: arraylength
          //   500: anewarray 186	java/lang/String
          //   503: astore 7
          //   505: iconst_0
          //   506: istore_1
          //   507: iload_1
          //   508: aload 10
          //   510: arraylength
          //   511: if_icmpge +337 -> 848
          //   514: new 104	java/lang/StringBuilder
          //   517: dup
          //   518: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   521: aload 10
          //   523: iload_1
          //   524: aaload
          //   525: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   528: ldc 116
          //   530: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   533: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   536: astore 7
          //   538: aload_0
          //   539: getfield 44	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder3	Landroid/text/SpannableStringBuilder;
          //   542: aload 7
          //   544: ldc -68
          //   546: ldc 79
          //   548: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   551: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   554: pop
          //   555: aconst_null
          //   556: astore 7
          //   558: aload 9
          //   560: aload 10
          //   562: iload_1
          //   563: aaload
          //   564: iconst_0
          //   565: invokevirtual 192	android/content/pm/PackageManager:getPermissionInfo	(Ljava/lang/String;I)Landroid/content/pm/PermissionInfo;
          //   568: aload 9
          //   570: invokevirtual 198	android/content/pm/PermissionInfo:loadDescription	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
          //   573: invokeinterface 201 1 0
          //   578: astore 8
          //   580: aload 8
          //   582: astore 7
          //   584: aload 7
          //   586: ifnonnull +230 -> 816
          //   589: new 104	java/lang/StringBuilder
          //   592: dup
          //   593: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   596: ldc -54
          //   598: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   601: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   604: ldc -52
          //   606: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   609: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   612: astore 7
          //   614: aload_0
          //   615: getfield 44	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder3	Landroid/text/SpannableStringBuilder;
          //   618: aload 7
          //   620: ldc 122
          //   622: ldc 122
          //   624: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   627: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   630: pop
          //   631: iload_1
          //   632: iconst_1
          //   633: iadd
          //   634: istore_1
          //   635: goto -128 -> 507
          //   638: new 104	java/lang/StringBuilder
          //   641: dup
          //   642: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   645: ldc -51
          //   647: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   650: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   653: ldc 116
          //   655: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   658: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   661: astore 7
          //   663: aload_0
          //   664: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   667: aload 7
          //   669: ldc 122
          //   671: ldc 122
          //   673: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   676: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   679: pop
          //   680: goto -597 -> 83
          //   683: astore 7
          //   685: aload 7
          //   687: invokevirtual 208	java/lang/NullPointerException:printStackTrace	()V
          //   690: return
          //   691: new 104	java/lang/StringBuilder
          //   694: dup
          //   695: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   698: ldc -47
          //   700: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   703: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   706: ldc 116
          //   708: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   711: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   714: astore 7
          //   716: aload_0
          //   717: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   720: aload 7
          //   722: ldc 122
          //   724: ldc 122
          //   726: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   729: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   732: pop
          //   733: goto -377 -> 356
          //   736: new 104	java/lang/StringBuilder
          //   739: dup
          //   740: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   743: ldc -46
          //   745: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   748: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   751: ldc 116
          //   753: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   756: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   759: astore 7
          //   761: aload_0
          //   762: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   765: aload 7
          //   767: ldc 122
          //   769: ldc 122
          //   771: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   774: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   777: pop
          //   778: goto -371 -> 407
          //   781: ldc -45
          //   783: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   786: astore 7
          //   788: aload_0
          //   789: getfield 42	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder	Landroid/text/SpannableStringBuilder;
          //   792: aload 7
          //   794: ldc -116
          //   796: ldc 122
          //   798: invokestatic 135	com/chelpus/Utils:getColoredText	(Ljava/lang/String;ILjava/lang/String;)Landroid/text/SpannableString;
          //   801: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   804: pop
          //   805: goto -365 -> 440
          //   808: astore 7
          //   810: aconst_null
          //   811: astore 7
          //   813: goto -229 -> 584
          //   816: new 104	java/lang/StringBuilder
          //   819: dup
          //   820: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   823: aload 7
          //   825: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   828: ldc -52
          //   830: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   833: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   836: astore 7
          //   838: goto -224 -> 614
          //   841: astore 7
          //   843: aload 7
          //   845: invokevirtual 212	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
          //   848: getstatic 89	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:handler	Landroid/os/Handler;
          //   851: new 17	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1$3
          //   854: dup
          //   855: aload_0
          //   856: invokespecial 213	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1$3:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1;)V
          //   859: invokevirtual 98	android/os/Handler:post	(Ljava/lang/Runnable;)Z
          //   862: pop
          //   863: new 104	java/lang/StringBuilder
          //   866: dup
          //   867: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   870: ldc -42
          //   872: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   875: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   878: ldc -40
          //   880: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   883: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   886: astore 7
          //   888: aload_0
          //   889: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   892: invokevirtual 169	android/text/SpannableStringBuilder:clear	()V
          //   895: aload_0
          //   896: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   899: aload 7
          //   901: ldc -68
          //   903: ldc 79
          //   905: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   908: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   911: pop
          //   912: new 104	java/lang/StringBuilder
          //   915: dup
          //   916: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   919: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   922: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   925: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   928: ldc 116
          //   930: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   933: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   936: astore 7
          //   938: aload_0
          //   939: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   942: aload 7
          //   944: ldc 122
          //   946: ldc 122
          //   948: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   951: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   954: pop
          //   955: new 104	java/lang/StringBuilder
          //   958: dup
          //   959: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   962: ldc -39
          //   964: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   967: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   970: ldc 116
          //   972: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   975: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   978: astore 7
          //   980: aload_0
          //   981: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   984: aload 7
          //   986: ldc -68
          //   988: ldc 79
          //   990: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   993: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   996: pop
          //   997: new 104	java/lang/StringBuilder
          //   1000: dup
          //   1001: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1004: invokestatic 166	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   1007: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1010: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   1013: invokevirtual 221	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
          //   1016: invokevirtual 227	android/content/Intent:getComponent	()Landroid/content/ComponentName;
          //   1019: invokevirtual 232	android/content/ComponentName:getClassName	()Ljava/lang/String;
          //   1022: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1025: ldc 116
          //   1027: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1030: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1033: astore 7
          //   1035: aload_0
          //   1036: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1039: aload 7
          //   1041: ldc 122
          //   1043: ldc 122
          //   1045: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1048: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1051: pop
          //   1052: new 104	java/lang/StringBuilder
          //   1055: dup
          //   1056: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1059: ldc -23
          //   1061: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   1064: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1067: ldc 116
          //   1069: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1072: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1075: astore 7
          //   1077: aload_0
          //   1078: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1081: aload 7
          //   1083: ldc -68
          //   1085: ldc 79
          //   1087: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1090: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1093: pop
          //   1094: invokestatic 166	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   1097: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1100: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   1103: iconst_0
          //   1104: invokevirtual 178	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
          //   1107: getfield 237	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
          //   1110: getfield 242	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
          //   1113: astore 7
          //   1115: aload_0
          //   1116: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1119: aload 7
          //   1121: ldc 122
          //   1123: ldc 122
          //   1125: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1128: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1131: pop
          //   1132: new 104	java/lang/StringBuilder
          //   1135: dup
          //   1136: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1139: ldc 116
          //   1141: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1144: ldc -13
          //   1146: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   1149: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1152: ldc 116
          //   1154: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1157: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1160: astore 7
          //   1162: aload_0
          //   1163: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1166: aload 7
          //   1168: ldc -68
          //   1170: ldc 79
          //   1172: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1175: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1178: pop
          //   1179: new 104	java/lang/StringBuilder
          //   1182: dup
          //   1183: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1186: invokestatic 166	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   1189: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1192: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   1195: iconst_0
          //   1196: invokevirtual 178	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
          //   1199: getfield 237	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
          //   1202: getfield 246	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
          //   1205: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1208: ldc -8
          //   1210: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1213: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1216: astore 7
          //   1218: aload_0
          //   1219: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1222: aload 7
          //   1224: ldc 122
          //   1226: ldc 122
          //   1228: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1231: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1234: pop
          //   1235: new 104	java/lang/StringBuilder
          //   1238: dup
          //   1239: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1242: ldc 116
          //   1244: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1247: ldc -7
          //   1249: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   1252: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1255: ldc -5
          //   1257: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1260: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1263: astore 7
          //   1265: aload_0
          //   1266: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1269: aload 7
          //   1271: ldc -68
          //   1273: ldc 79
          //   1275: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1278: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1281: pop
          //   1282: invokestatic 166	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   1285: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1288: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   1291: iconst_0
          //   1292: invokevirtual 178	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
          //   1295: getfield 254	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
          //   1298: astore 7
          //   1300: aload_0
          //   1301: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1304: aload 7
          //   1306: ldc 122
          //   1308: ldc 122
          //   1310: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1313: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1316: pop
          //   1317: new 104	java/lang/StringBuilder
          //   1320: dup
          //   1321: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1324: ldc 116
          //   1326: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1329: ldc -1
          //   1331: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   1334: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1337: ldc -5
          //   1339: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1342: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1345: astore 7
          //   1347: aload_0
          //   1348: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1351: aload 7
          //   1353: ldc -68
          //   1355: ldc 79
          //   1357: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1360: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1363: pop
          //   1364: new 104	java/lang/StringBuilder
          //   1367: dup
          //   1368: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1371: ldc 122
          //   1373: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1376: invokestatic 166	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   1379: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1382: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   1385: iconst_0
          //   1386: invokevirtual 178	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
          //   1389: getfield 259	android/content/pm/PackageInfo:versionCode	I
          //   1392: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   1395: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1398: astore 7
          //   1400: aload_0
          //   1401: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1404: aload 7
          //   1406: ldc 122
          //   1408: ldc 122
          //   1410: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1413: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1416: pop
          //   1417: new 104	java/lang/StringBuilder
          //   1420: dup
          //   1421: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1424: ldc 116
          //   1426: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1429: ldc_w 263
          //   1432: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   1435: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1438: ldc -5
          //   1440: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1443: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1446: astore 7
          //   1448: aload_0
          //   1449: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1452: aload 7
          //   1454: ldc -68
          //   1456: ldc 79
          //   1458: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1461: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1464: pop
          //   1465: new 104	java/lang/StringBuilder
          //   1468: dup
          //   1469: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1472: ldc 122
          //   1474: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1477: invokestatic 166	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   1480: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1483: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   1486: iconst_0
          //   1487: invokevirtual 178	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
          //   1490: getfield 237	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
          //   1493: getfield 266	android/content/pm/ApplicationInfo:uid	I
          //   1496: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   1499: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1502: astore 7
          //   1504: aload_0
          //   1505: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1508: aload 7
          //   1510: ldc 122
          //   1512: ldc 122
          //   1514: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1517: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1520: pop
          //   1521: new 104	java/lang/StringBuilder
          //   1524: dup
          //   1525: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1528: ldc 116
          //   1530: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1533: ldc_w 267
          //   1536: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   1539: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1542: ldc -5
          //   1544: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1547: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1550: astore 7
          //   1552: aload_0
          //   1553: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1556: aload 7
          //   1558: ldc -68
          //   1560: ldc 79
          //   1562: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1565: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1568: pop
          //   1569: new 269	java/text/SimpleDateFormat
          //   1572: dup
          //   1573: ldc_w 271
          //   1576: invokespecial 274	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
          //   1579: astore 7
          //   1581: new 104	java/lang/StringBuilder
          //   1584: dup
          //   1585: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1588: ldc 122
          //   1590: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1593: aload 7
          //   1595: new 276	java/util/Date
          //   1598: dup
          //   1599: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1602: getfield 279	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:updatetime	I
          //   1605: i2l
          //   1606: ldc2_w 280
          //   1609: lmul
          //   1610: invokespecial 284	java/util/Date:<init>	(J)V
          //   1613: invokevirtual 288	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
          //   1616: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1619: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1622: astore 7
          //   1624: getstatic 294	java/lang/System:out	Ljava/io/PrintStream;
          //   1627: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1630: getfield 279	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:updatetime	I
          //   1633: invokevirtual 300	java/io/PrintStream:println	(I)V
          //   1636: getstatic 294	java/lang/System:out	Ljava/io/PrintStream;
          //   1639: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1642: getfield 279	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:updatetime	I
          //   1645: i2l
          //   1646: ldc2_w 280
          //   1649: lmul
          //   1650: invokevirtual 302	java/io/PrintStream:println	(J)V
          //   1653: aload_0
          //   1654: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1657: aload 7
          //   1659: ldc 122
          //   1661: ldc 122
          //   1663: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1666: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1669: pop
          //   1670: new 104	java/lang/StringBuilder
          //   1673: dup
          //   1674: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1677: ldc -52
          //   1679: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1682: ldc_w 303
          //   1685: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   1688: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1691: ldc -5
          //   1693: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1696: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1699: astore 7
          //   1701: aload_0
          //   1702: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1705: aload 7
          //   1707: ldc -68
          //   1709: ldc 79
          //   1711: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1714: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1717: pop
          //   1718: new 104	java/lang/StringBuilder
          //   1721: dup
          //   1722: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1725: ldc_w 305
          //   1728: iconst_1
          //   1729: anewarray 4	java/lang/Object
          //   1732: dup
          //   1733: iconst_0
          //   1734: new 307	java/io/File
          //   1737: dup
          //   1738: invokestatic 166	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   1741: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1744: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   1747: iconst_0
          //   1748: invokevirtual 178	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
          //   1751: getfield 237	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
          //   1754: getfield 242	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
          //   1757: invokespecial 308	java/io/File:<init>	(Ljava/lang/String;)V
          //   1760: invokevirtual 312	java/io/File:length	()J
          //   1763: l2f
          //   1764: ldc_w 313
          //   1767: fdiv
          //   1768: invokestatic 319	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   1771: aastore
          //   1772: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   1775: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1778: ldc_w 324
          //   1781: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1784: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1787: astore 7
          //   1789: aload_0
          //   1790: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1793: aload 7
          //   1795: ldc 122
          //   1797: ldc 122
          //   1799: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1802: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1805: pop
          //   1806: new 104	java/lang/StringBuilder
          //   1809: dup
          //   1810: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1813: ldc 116
          //   1815: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1818: ldc_w 325
          //   1821: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   1824: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1827: ldc -5
          //   1829: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1832: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1835: astore 7
          //   1837: aload_0
          //   1838: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1841: aload 7
          //   1843: ldc -68
          //   1845: ldc 79
          //   1847: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1850: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1853: pop
          //   1854: lconst_0
          //   1855: lstore_2
          //   1856: invokestatic 166	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   1859: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   1862: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   1865: iconst_0
          //   1866: invokevirtual 178	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
          //   1869: getfield 237	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
          //   1872: getfield 242	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
          //   1875: invokestatic 329	com/chelpus/Utils:getFileDalvikCache	(Ljava/lang/String;)Ljava/io/File;
          //   1878: invokevirtual 312	java/io/File:length	()J
          //   1881: lstore 4
          //   1883: lload 4
          //   1885: lstore_2
          //   1886: new 104	java/lang/StringBuilder
          //   1889: dup
          //   1890: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1893: ldc_w 305
          //   1896: iconst_1
          //   1897: anewarray 4	java/lang/Object
          //   1900: dup
          //   1901: iconst_0
          //   1902: lload_2
          //   1903: l2f
          //   1904: ldc_w 313
          //   1907: fdiv
          //   1908: invokestatic 319	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   1911: aastore
          //   1912: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   1915: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1918: ldc_w 324
          //   1921: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1924: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1927: astore 7
          //   1929: aload_0
          //   1930: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1933: aload 7
          //   1935: ldc 122
          //   1937: ldc 122
          //   1939: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   1942: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   1945: pop
          //   1946: getstatic 332	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:su	Z
          //   1949: istore 6
          //   1951: iload 6
          //   1953: ifeq +195 -> 2148
          //   1956: new 104	java/lang/StringBuilder
          //   1959: dup
          //   1960: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   1963: ldc 116
          //   1965: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1968: ldc_w 333
          //   1971: invokestatic 110	com/chelpus/Utils:getText	(I)Ljava/lang/String;
          //   1974: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1977: ldc -5
          //   1979: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1982: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1985: astore 7
          //   1987: aload_0
          //   1988: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   1991: aload 7
          //   1993: ldc -68
          //   1995: ldc 79
          //   1997: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   2000: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   2003: pop
          //   2004: ldc 122
          //   2006: astore 7
          //   2008: new 81	com/chelpus/Utils
          //   2011: dup
          //   2012: ldc 122
          //   2014: invokespecial 334	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
          //   2017: iconst_1
          //   2018: anewarray 186	java/lang/String
          //   2021: dup
          //   2022: iconst_0
          //   2023: new 104	java/lang/StringBuilder
          //   2026: dup
          //   2027: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   2030: getstatic 337	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:dalvikruncommand	Ljava/lang/String;
          //   2033: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2036: ldc_w 339
          //   2039: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2042: invokestatic 166	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
          //   2045: getstatic 69	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:pli	Lcom/android/vending/billing/InAppBillingService/LACK/PkgListItem;
          //   2048: getfield 172	com/android/vending/billing/InAppBillingService/LACK/PkgListItem:pkgName	Ljava/lang/String;
          //   2051: iconst_0
          //   2052: invokevirtual 178	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
          //   2055: getfield 237	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
          //   2058: getfield 246	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
          //   2061: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2064: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   2067: aastore
          //   2068: invokevirtual 343	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
          //   2071: astore 8
          //   2073: aload 8
          //   2075: astore 7
          //   2077: aload 8
          //   2079: ldc_w 345
          //   2082: ldc 122
          //   2084: invokevirtual 349	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
          //   2087: astore 8
          //   2089: aload 8
          //   2091: astore 7
          //   2093: new 104	java/lang/StringBuilder
          //   2096: dup
          //   2097: invokespecial 105	java/lang/StringBuilder:<init>	()V
          //   2100: aload 7
          //   2102: ldc 116
          //   2104: ldc 122
          //   2106: invokevirtual 349	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
          //   2109: ldc_w 351
          //   2112: ldc 122
          //   2114: invokevirtual 349	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
          //   2117: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2120: ldc_w 324
          //   2123: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2126: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   2129: astore 7
          //   2131: aload_0
          //   2132: getfield 48	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1:val$builder2	Landroid/text/SpannableStringBuilder;
          //   2135: aload 7
          //   2137: ldc 122
          //   2139: ldc 122
          //   2141: invokestatic 85	com/chelpus/Utils:getColoredText	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
          //   2144: invokevirtual 127	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
          //   2147: pop
          //   2148: getstatic 89	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:handler	Landroid/os/Handler;
          //   2151: new 19	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1$4
          //   2154: dup
          //   2155: aload_0
          //   2156: invokespecial 352	com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1$4:<init>	(Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog$1;)V
          //   2159: invokevirtual 98	android/os/Handler:post	(Ljava/lang/Runnable;)Z
          //   2162: pop
          //   2163: return
          //   2164: astore 7
          //   2166: aload 7
          //   2168: invokevirtual 353	java/lang/Exception:printStackTrace	()V
          //   2171: goto -1119 -> 1052
          //   2174: astore 7
          //   2176: aload 7
          //   2178: invokevirtual 212	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
          //   2181: goto -375 -> 1806
          //   2184: astore 7
          //   2186: goto -38 -> 2148
          //   2189: astore 8
          //   2191: goto -98 -> 2093
          //   2194: astore 7
          //   2196: goto -250 -> 1946
          //   2199: astore 7
          //   2201: goto -315 -> 1886
          //   2204: astore 8
          //   2206: goto -1622 -> 584
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	2209	0	this	1
          //   506	129	1	i	int
          //   1855	48	2	l1	long
          //   1881	3	4	l2	long
          //   1949	3	6	bool	boolean
          //   13	655	7	localObject1	Object
          //   683	3	7	localNullPointerException	NullPointerException
          //   714	79	7	str1	String
          //   808	1	7	localNameNotFoundException1	PackageManager.NameNotFoundException
          //   811	26	7	str2	String
          //   841	3	7	localNameNotFoundException2	PackageManager.NameNotFoundException
          //   886	1250	7	localObject2	Object
          //   2164	3	7	localException1	Exception
          //   2174	3	7	localNameNotFoundException3	PackageManager.NameNotFoundException
          //   2184	1	7	localException2	Exception
          //   2194	1	7	localException3	Exception
          //   2199	1	7	localException4	Exception
          //   578	1512	8	str3	String
          //   2189	1	8	localException5	Exception
          //   2204	1	8	localException6	Exception
          //   458	111	9	localPackageManager	PackageManager
          //   484	77	10	arrayOfString	String[]
          // Exception table:
          //   from	to	target	type
          //   0	83	683	java/lang/NullPointerException
          //   83	134	683	java/lang/NullPointerException
          //   134	185	683	java/lang/NullPointerException
          //   185	236	683	java/lang/NullPointerException
          //   236	305	683	java/lang/NullPointerException
          //   305	356	683	java/lang/NullPointerException
          //   356	407	683	java/lang/NullPointerException
          //   407	440	683	java/lang/NullPointerException
          //   440	467	683	java/lang/NullPointerException
          //   467	486	683	java/lang/NullPointerException
          //   491	505	683	java/lang/NullPointerException
          //   507	555	683	java/lang/NullPointerException
          //   558	580	683	java/lang/NullPointerException
          //   589	614	683	java/lang/NullPointerException
          //   614	631	683	java/lang/NullPointerException
          //   638	680	683	java/lang/NullPointerException
          //   691	733	683	java/lang/NullPointerException
          //   736	778	683	java/lang/NullPointerException
          //   781	805	683	java/lang/NullPointerException
          //   816	838	683	java/lang/NullPointerException
          //   843	848	683	java/lang/NullPointerException
          //   848	997	683	java/lang/NullPointerException
          //   997	1052	683	java/lang/NullPointerException
          //   1052	1094	683	java/lang/NullPointerException
          //   1094	1806	683	java/lang/NullPointerException
          //   1806	1854	683	java/lang/NullPointerException
          //   1856	1883	683	java/lang/NullPointerException
          //   1886	1946	683	java/lang/NullPointerException
          //   1946	1951	683	java/lang/NullPointerException
          //   1956	2004	683	java/lang/NullPointerException
          //   2008	2073	683	java/lang/NullPointerException
          //   2077	2089	683	java/lang/NullPointerException
          //   2093	2148	683	java/lang/NullPointerException
          //   2148	2163	683	java/lang/NullPointerException
          //   2166	2171	683	java/lang/NullPointerException
          //   2176	2181	683	java/lang/NullPointerException
          //   558	580	808	android/content/pm/PackageManager$NameNotFoundException
          //   467	486	841	android/content/pm/PackageManager$NameNotFoundException
          //   491	505	841	android/content/pm/PackageManager$NameNotFoundException
          //   507	555	841	android/content/pm/PackageManager$NameNotFoundException
          //   589	614	841	android/content/pm/PackageManager$NameNotFoundException
          //   614	631	841	android/content/pm/PackageManager$NameNotFoundException
          //   816	838	841	android/content/pm/PackageManager$NameNotFoundException
          //   997	1052	2164	java/lang/Exception
          //   1094	1806	2174	android/content/pm/PackageManager$NameNotFoundException
          //   1956	2004	2184	java/lang/Exception
          //   2093	2148	2184	java/lang/Exception
          //   2008	2073	2189	java/lang/Exception
          //   2077	2089	2189	java/lang/Exception
          //   1806	1854	2194	java/lang/Exception
          //   1886	1946	2194	java/lang/Exception
          //   1856	1883	2199	java/lang/Exception
          //   558	580	2204	java/lang/Exception
        }
      }).start();
      localObject1 = new AlertDlg(listAppsFragment.frag.getContext(), true).setView(localLinearLayout).create();
      ((Dialog)localObject1).setCancelable(true);
      ((Dialog)localObject1).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      return (Dialog)localObject1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void showDialog()
  {
    if (this.dialog == null) {
      this.dialog = onCreateDialog();
    }
    if (this.dialog != null) {
      this.dialog.show();
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/App_Dialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */