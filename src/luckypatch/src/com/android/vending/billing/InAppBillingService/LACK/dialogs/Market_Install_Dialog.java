package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.android.vending.billing.InAppBillingService.LACK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Market_Install_Dialog
{
  public static final int LOADING_PROGRESS_DIALOG = 23;
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
    System.out.println("Market install Dialog create.");
    if ((listAppsFragment.frag == null) || (listAppsFragment.frag.getContext() == null)) {
      dismiss();
    }
    Object localObject1 = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968618, null);
    Object localObject2 = (LinearLayout)((LinearLayout)localObject1).findViewById(2131558572).findViewById(2131558412);
    TextView localTextView = (TextView)((LinearLayout)localObject2).findViewById(2131558587);
    localObject2 = (RadioGroup)((LinearLayout)localObject2).findViewById(2131558414);
    ((RadioGroup)localObject2).getCheckedRadioButtonId();
    listAppsFragment.verMarket = "mod.market60.apk";
    ((RadioButton)((RadioGroup)localObject2).findViewById(2131558577)).setText(Utils.getText(2131165525) + " 4.1.6 (Android 2.2 and UP)");
    ((RadioButton)((RadioGroup)localObject2).findViewById(2131558584)).setText(Utils.getText(2131165526) + " 4.1.6 (Android 2.2 and UP)");
    ((RadioButton)((RadioGroup)localObject2).findViewById(2131558576)).setText(Utils.getText(2131165525) + " 4.9.13 (Android 2.2 and UP)");
    ((RadioButton)((RadioGroup)localObject2).findViewById(2131558583)).setText(Utils.getText(2131165526) + " 4.9.13 (Android 2.2 and UP)");
    ((RadioButton)((RadioGroup)localObject2).findViewById(2131558575)).setText(Utils.getText(2131165525) + " 5.1.11 (Android 2.2 and UP)");
    ((RadioButton)((RadioGroup)localObject2).findViewById(2131558582)).setText(Utils.getText(2131165526) + " 5.1.11 (Android 2.2 and UP)");
    ((RadioButton)((RadioGroup)localObject2).findViewById(2131558574)).setText(Utils.getText(2131165525) + " 6.0.7 (Android 2.3+ and UP)");
    ((RadioButton)((RadioGroup)localObject2).findViewById(2131558581)).setText(Utils.getText(2131165526) + " 6.0.7 (Android 2.3+ and UP)");
    ((RadioButton)((RadioGroup)localObject2).findViewById(2131558573)).setText(Utils.getText(2131165525) + " 6.3.16 (Android 4+ and UP)");
    ((RadioButton)((RadioGroup)localObject2).findViewById(2131558580)).setText(Utils.getText(2131165526) + " 6.3.16 (Android 4+ and UP)");
    ((RadioGroup)localObject2).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 2131558578: 
          listAppsFragment.verMarket = "mod.market3.apk";
          return;
        case 2131558579: 
          listAppsFragment.verMarket = "mod.market2.apk";
          return;
        case 2131558585: 
          listAppsFragment.verMarket = "market3.apk";
          return;
        case 2131558586: 
          listAppsFragment.verMarket = "market2.apk";
          return;
        case 2131558577: 
          listAppsFragment.verMarket = "mod.market4.apk";
          return;
        case 2131558584: 
          listAppsFragment.verMarket = "market4.apk";
          return;
        case 2131558576: 
          listAppsFragment.verMarket = "mod.market4.4.apk";
          return;
        case 2131558583: 
          listAppsFragment.verMarket = "market4.4.apk";
          return;
        case 2131558575: 
          listAppsFragment.verMarket = "mod.market5.apk";
          return;
        case 2131558582: 
          listAppsFragment.verMarket = "market5.apk";
          return;
        case 2131558574: 
          listAppsFragment.verMarket = "mod.market60.apk";
          return;
        case 2131558581: 
          listAppsFragment.verMarket = "market60.apk";
          return;
        case 2131558573: 
          listAppsFragment.verMarket = "mod.market63.apk";
          return;
        }
        listAppsFragment.verMarket = "market63.apk";
      }
    });
    localObject2 = (Button)((LinearLayout)localObject1).findViewById(2131558589);
    CheckBox localCheckBox = (CheckBox)((LinearLayout)localObject1).findViewById(2131558588);
    listAppsFragment.asUser = false;
    listAppsFragment.asNeedUser = false;
    try
    {
      ApplicationInfo localApplicationInfo = listAppsFragment.getPkgMng().getApplicationInfo("com.android.vending", 0);
      if ((Utils.checkCoreJarPatch11()) && (Utils.checkCoreJarPatch12()) && (Utils.checkCoreJarPatch20()) && ((localApplicationInfo.flags & 0x1) != 0))
      {
        localCheckBox.setEnabled(true);
        localCheckBox.setChecked(false);
        listAppsFragment.asUser = false;
        listAppsFragment.asNeedUser = true;
      }
      for (;;)
      {
        localCheckBox.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = (CheckBox)paramAnonymousView;
            if (!listAppsFragment.asNeedUser)
            {
              listAppsFragment.frag.showMessage(Utils.getText(2131165748), Utils.getText(2131165498));
              paramAnonymousView.setChecked(false);
              listAppsFragment.asUser = false;
              return;
            }
            if (paramAnonymousView.isChecked())
            {
              listAppsFragment.asUser = true;
              return;
            }
            listAppsFragment.asUser = false;
          }
        });
        localTextView.setText(Utils.getColoredText("  " + Utils.getText(2131165505), 65280, "bold"));
        localTextView.append("\n\n" + Utils.getText(2131165519));
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            new AsyncTask()
            {
              boolean cacheFound = false;
              boolean corruptdownload = false;
              String filename = "mod.market4.apk";
              boolean internet_not_found = false;
              int numbytes = 0;
              
              protected Boolean doInBackground(String... paramAnonymous2VarArgs)
              {
                Object localObject1 = "http://chelpus.defcon5.biz/" + paramAnonymous2VarArgs[0];
                this.filename = paramAnonymous2VarArgs[0];
                try
                {
                  Object localObject2 = (HttpURLConnection)new URL((String)localObject1).openConnection();
                  ((HttpURLConnection)localObject2).setRequestMethod("HEAD");
                  ((HttpURLConnection)localObject2).setRequestProperty("Cache-Control", "no-cache");
                  ((HttpURLConnection)localObject2).connect();
                  this.numbytes = Integer.parseInt(((HttpURLConnection)localObject2).getHeaderField("Content-length"));
                  System.out.println(String.format("%s bytes found, %s Mb", new Object[] { Integer.valueOf(this.numbytes), Float.valueOf(this.numbytes / 1048576.0F) }));
                  ((HttpURLConnection)localObject2).disconnect();
                  if ((listAppsFragment.progress_loading != null) && (listAppsFragment.progress_loading.isShowing())) {
                    listAppsFragment.progress_loading.setMax(this.numbytes / 1024);
                  }
                  this.cacheFound = false;
                  if (new File(listAppsFragment.basepath + "/Download/" + paramAnonymous2VarArgs[0]).exists())
                  {
                    if (this.internet_not_found) {
                      break label651;
                    }
                    System.out.println(new File(listAppsFragment.basepath + "/Download/" + paramAnonymous2VarArgs[0]).length());
                    System.out.println(this.numbytes);
                    if ((new File(listAppsFragment.basepath + "/Download/" + paramAnonymous2VarArgs[0]).length() == this.numbytes) || (this.numbytes == 0)) {
                      this.cacheFound = true;
                    }
                  }
                  if ((!this.internet_not_found) && (!this.cacheFound))
                  {
                    try
                    {
                      localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
                      ((HttpURLConnection)localObject1).setRequestMethod("GET");
                      ((HttpURLConnection)localObject1).setUseCaches(false);
                      ((HttpURLConnection)localObject1).setRequestProperty("Cache-Control", "no-cache");
                      ((HttpURLConnection)localObject1).connect();
                      localObject2 = new File(listAppsFragment.basepath + "/Download/");
                      if (!((File)localObject2).exists()) {
                        ((File)localObject2).mkdirs();
                      }
                      localObject2 = new File((File)localObject2, paramAnonymous2VarArgs[0]);
                      if (((File)localObject2).exists()) {
                        ((File)localObject2).delete();
                      }
                      localObject2 = new FileOutputStream((File)localObject2);
                      localObject1 = ((HttpURLConnection)localObject1).getInputStream();
                      byte[] arrayOfByte = new byte[' '];
                      int i = 0;
                      for (;;)
                      {
                        int j = ((InputStream)localObject1).read(arrayOfByte);
                        if (j == -1) {
                          break;
                        }
                        i += j;
                        publishProgress(new Integer[] { Integer.valueOf(i / 1024) });
                        ((FileOutputStream)localObject2).write(arrayOfByte, 0, j);
                      }
                      if (!new File(listAppsFragment.basepath + "/Download/" + paramAnonymous2VarArgs[0]).exists()) {
                        break label621;
                      }
                    }
                    catch (IOException localIOException)
                    {
                      localIOException.printStackTrace();
                    }
                    if (new File(listAppsFragment.basepath + "/Download/" + paramAnonymous2VarArgs[0]).length() == this.numbytes)
                    {
                      this.cacheFound = true;
                      label621:
                      return Boolean.valueOf(true);
                    }
                  }
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  for (;;)
                  {
                    this.internet_not_found = true;
                  }
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    localException.printStackTrace();
                    this.internet_not_found = true;
                    continue;
                    label651:
                    this.cacheFound = true;
                    continue;
                    localException.close();
                    localIOException.close();
                    continue;
                    new File(listAppsFragment.basepath + "/Download/" + paramAnonymous2VarArgs[0]).delete();
                    this.corruptdownload = true;
                    this.cacheFound = false;
                    continue;
                    if ((new File(listAppsFragment.basepath + "/Download/" + paramAnonymous2VarArgs[0]).exists()) && (!this.cacheFound)) {
                      new File(listAppsFragment.basepath + "/Download/" + paramAnonymous2VarArgs[0]).delete();
                    }
                  }
                }
              }
              
              /* Error */
              protected void onPostExecute(Boolean paramAnonymous2Boolean)
              {
                // Byte code:
                //   0: aload_0
                //   1: aload_1
                //   2: invokespecial 231	android/os/AsyncTask:onPostExecute	(Ljava/lang/Object;)V
                //   5: getstatic 140	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:progress_loading	Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/Progress_Dialog_Loading;
                //   8: ifnull +9 -> 17
                //   11: getstatic 140	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:progress_loading	Lcom/android/vending/billing/InAppBillingService/LACK/dialogs/Progress_Dialog_Loading;
                //   14: invokevirtual 234	com/android/vending/billing/InAppBillingService/LACK/dialogs/Progress_Dialog_Loading:dismiss	()V
                //   17: aload_0
                //   18: getfield 31	com/android/vending/billing/InAppBillingService/LACK/dialogs/Market_Install_Dialog$3$1:corruptdownload	Z
                //   21: ifeq +19 -> 40
                //   24: getstatic 238	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
                //   27: ldc -17
                //   29: invokestatic 245	com/chelpus/Utils:getText	(I)Ljava/lang/String;
                //   32: ldc -10
                //   34: invokestatic 245	com/chelpus/Utils:getText	(I)Ljava/lang/String;
                //   37: invokevirtual 249	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:showMessage	(Ljava/lang/String;Ljava/lang/String;)V
                //   40: aload_0
                //   41: getfield 33	com/android/vending/billing/InAppBillingService/LACK/dialogs/Market_Install_Dialog$3$1:internet_not_found	Z
                //   44: ifeq +26 -> 70
                //   47: aload_0
                //   48: getfield 35	com/android/vending/billing/InAppBillingService/LACK/dialogs/Market_Install_Dialog$3$1:cacheFound	Z
                //   51: ifne +19 -> 70
                //   54: getstatic 238	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
                //   57: ldc -17
                //   59: invokestatic 245	com/chelpus/Utils:getText	(I)Ljava/lang/String;
                //   62: ldc -6
                //   64: invokestatic 245	com/chelpus/Utils:getText	(I)Ljava/lang/String;
                //   67: invokevirtual 249	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:showMessage	(Ljava/lang/String;Ljava/lang/String;)V
                //   70: aload_0
                //   71: getfield 35	com/android/vending/billing/InAppBillingService/LACK/dialogs/Market_Install_Dialog$3$1:cacheFound	Z
                //   74: ifeq +126 -> 200
                //   77: new 152	java/io/File
                //   80: dup
                //   81: new 50	java/lang/StringBuilder
                //   84: dup
                //   85: invokespecial 51	java/lang/StringBuilder:<init>	()V
                //   88: getstatic 155	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
                //   91: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   94: ldc -99
                //   96: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   99: aload_0
                //   100: getfield 39	com/android/vending/billing/InAppBillingService/LACK/dialogs/Market_Install_Dialog$3$1:filename	Ljava/lang/String;
                //   103: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   106: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
                //   109: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
                //   112: invokevirtual 161	java/io/File:exists	()Z
                //   115: ifeq +85 -> 200
                //   118: new 252	com/android/vending/billing/InAppBillingService/LACK/FileApkListItem
                //   121: dup
                //   122: invokestatic 256	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
                //   125: new 152	java/io/File
                //   128: dup
                //   129: new 50	java/lang/StringBuilder
                //   132: dup
                //   133: invokespecial 51	java/lang/StringBuilder:<init>	()V
                //   136: getstatic 155	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:basepath	Ljava/lang/String;
                //   139: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   142: ldc -99
                //   144: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   147: aload_0
                //   148: getfield 39	com/android/vending/billing/InAppBillingService/LACK/dialogs/Market_Install_Dialog$3$1:filename	Ljava/lang/String;
                //   151: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   154: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
                //   157: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
                //   160: iconst_0
                //   161: invokespecial 259	com/android/vending/billing/InAppBillingService/LACK/FileApkListItem:<init>	(Landroid/content/Context;Ljava/io/File;Z)V
                //   164: astore_1
                //   165: getstatic 262	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:asUser	Z
                //   168: ifne +71 -> 239
                //   171: invokestatic 256	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
                //   174: invokevirtual 267	android/content/Context:getPackageName	()Ljava/lang/String;
                //   177: invokestatic 271	com/chelpus/Utils:isInstalledOnSdCard	(Ljava/lang/String;)Z
                //   180: ifeq +29 -> 209
                //   183: getstatic 238	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
                //   186: ldc -17
                //   188: invokestatic 245	com/chelpus/Utils:getText	(I)Ljava/lang/String;
                //   191: ldc_w 272
                //   194: invokestatic 245	com/chelpus/Utils:getText	(I)Ljava/lang/String;
                //   197: invokevirtual 249	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:showMessage	(Ljava/lang/String;Ljava/lang/String;)V
                //   200: return
                //   201: astore_1
                //   202: aload_1
                //   203: invokevirtual 217	java/lang/Exception:printStackTrace	()V
                //   206: goto -189 -> 17
                //   209: getstatic 238	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
                //   212: aload_1
                //   213: invokevirtual 276	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:install_system	(Lcom/android/vending/billing/InAppBillingService/LACK/FileApkListItem;)V
                //   216: return
                //   217: astore_1
                //   218: aload_1
                //   219: invokevirtual 217	java/lang/Exception:printStackTrace	()V
                //   222: getstatic 238	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
                //   225: ldc -17
                //   227: invokestatic 245	com/chelpus/Utils:getText	(I)Ljava/lang/String;
                //   230: ldc -10
                //   232: invokestatic 245	com/chelpus/Utils:getText	(I)Ljava/lang/String;
                //   235: invokevirtual 249	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:showMessage	(Ljava/lang/String;Ljava/lang/String;)V
                //   238: return
                //   239: getstatic 238	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
                //   242: aload_1
                //   243: iconst_1
                //   244: invokevirtual 280	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolbar_restore	(Lcom/android/vending/billing/InAppBillingService/LACK/FileApkListItem;Z)V
                //   247: return
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	248	0	this	1
                //   0	248	1	paramAnonymous2Boolean	Boolean
                // Exception table:
                //   from	to	target	type
                //   5	17	201	java/lang/Exception
                //   118	200	217	java/lang/Exception
                //   209	216	217	java/lang/Exception
                //   239	247	217	java/lang/Exception
              }
              
              protected void onPreExecute()
              {
                super.onPreExecute();
                listAppsFragment locallistAppsFragment = listAppsFragment.frag;
                listAppsFragment.showDialogLP(23);
                listAppsFragment.progress_loading.setTitle(Utils.getText(2131165423));
                listAppsFragment.progress_loading.setMessage(Utils.getText(2131165747));
                listAppsFragment.progress_loading.setCancelable(true);
              }
              
              protected void onProgressUpdate(Integer... paramAnonymous2VarArgs)
              {
                super.onProgressUpdate(paramAnonymous2VarArgs);
                if ((listAppsFragment.progress_loading != null) && (listAppsFragment.progress_loading.isShowing())) {
                  listAppsFragment.progress_loading.setProgress(paramAnonymous2VarArgs[0].intValue());
                }
              }
            }.execute(new String[] { listAppsFragment.verMarket });
          }
        });
        localObject1 = new AlertDlg(listAppsFragment.frag.getContext(), true).setView((View)localObject1).create();
        ((Dialog)localObject1).setCancelable(true);
        ((Dialog)localObject1).setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        return (Dialog)localObject1;
        listAppsFragment.asUser = false;
        listAppsFragment.asNeedUser = false;
        localCheckBox.setEnabled(true);
        localCheckBox.setChecked(false);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        listAppsFragment.asUser = false;
        listAppsFragment.asNeedUser = false;
        localCheckBox.setEnabled(true);
        localCheckBox.setChecked(false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        listAppsFragment.asUser = false;
        listAppsFragment.asNeedUser = false;
        localCheckBox.setEnabled(true);
        localCheckBox.setChecked(false);
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/Market_Install_Dialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */