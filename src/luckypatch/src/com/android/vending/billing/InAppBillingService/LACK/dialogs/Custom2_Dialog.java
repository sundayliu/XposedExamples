package com.android.vending.billing.InAppBillingService.LACK.dialogs;

import android.app.Dialog;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.vending.billing.InAppBillingService.LACK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LACK.PkgListItem;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Custom2_Dialog
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
    RelativeLayout localRelativeLayout = (RelativeLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968611, null);
    System.out.println("Custom2 Dialog create.");
    if ((listAppsFragment.frag == null) || (listAppsFragment.frag.getContext() == null)) {
      dismiss();
    }
    Object localObject1 = (RelativeLayout)localRelativeLayout.findViewById(2131558452).findViewById(2131558543);
    localRelativeLayout.findViewById(2131558451);
    try
    {
      localTextView = (TextView)((RelativeLayout)localObject1).findViewById(2131558413);
      ((RelativeLayout)localObject1).findViewById(2131558457);
      localTextView.setText(Utils.getColoredText("-----------------------------------------------\n", "", "bold"));
      localTextView.append(Utils.getColoredText(Utils.getText(2131165399) + "\n", -16711821, "bold"));
      localTextView.append(Utils.getColoredText("-----------------------------------------------\n", "", "bold"));
      if (listAppsFragment.rebuldApk.equals(""))
      {
        localTextView.append(Utils.getColoredText("\n" + listAppsFragment.pli.name, -16711821, "bold"));
        localTextView.append(Utils.getColoredText("\n" + Utils.getText(2131165698) + " ", -16711821, "bold"));
        localTextView.append(Utils.getColoredText(listAppsFragment.getPkgMng().getPackageInfo(listAppsFragment.pli.pkgName, 0).versionName, -16711821, "bold"));
        localTextView.append(Utils.getColoredText("\n" + Utils.getText(2131165685) + " ", -16711821, "bold"));
        localTextView.append(Utils.getColoredText("" + listAppsFragment.getPkgMng().getPackageInfo(listAppsFragment.pli.pkgName, 0).versionCode + "\n", -16711821, "bold"));
        localTextView.append(Utils.getColoredText("\n-----------------------------------------------\n", "", "bold"));
        localObject1 = "";
        localObject6 = listAppsFragment.customselect.toString();
        localObject4 = localObject1;
        localObject5 = localObject1;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        try
        {
          FileInputStream localFileInputStream = new FileInputStream((String)localObject6);
          localObject4 = localObject1;
          localObject5 = localObject1;
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream, "UTF-8"));
          localObject4 = localObject1;
          localObject5 = localObject1;
          String[] arrayOfString = new String['ߐ'];
          int i = 0;
          localObject4 = localObject1;
          localObject5 = localObject1;
          Object localObject6 = localBufferedReader.readLine();
          if (localObject6 != null)
          {
            arrayOfString[0] = localObject6;
            int j = i;
            if (i != 0)
            {
              localObject4 = localObject1;
              localObject5 = localObject1;
              if (!arrayOfString[0].contains("["))
              {
                localObject4 = localObject1;
                localObject5 = localObject1;
                if (!arrayOfString[0].contains("]"))
                {
                  j = i;
                  localObject4 = localObject1;
                  localObject5 = localObject1;
                  if (!arrayOfString[0].contains("{")) {
                    continue;
                  }
                }
              }
              localObject4 = localObject1;
              localObject5 = localObject1;
              System.out.println("" + (String)localObject1 + "\n");
              j = 0;
            }
            localObject6 = localObject1;
            if (j != 0)
            {
              localObject4 = localObject1;
              localObject5 = localObject1;
              localObject6 = (String)localObject1 + "\n" + arrayOfString[0];
            }
            localObject4 = localObject6;
            localObject5 = localObject6;
            boolean bool = arrayOfString[0].toUpperCase().contains("[BEGIN]");
            i = j;
            localObject1 = localObject6;
            if (!bool) {
              continue;
            }
            i = 1;
            localObject1 = localObject6;
            continue;
            localTextView.append(Utils.getColoredText("\n" + Utils.getApkLabelName(listAppsFragment.rebuldApk), -16711821, "bold"));
            localTextView.append(Utils.getColoredText("\n" + Utils.getText(2131165698) + " ", -16711821, "bold"));
            localTextView.append(Utils.getColoredText(Utils.getApkPackageInfo(listAppsFragment.rebuldApk).versionName, -16711821, "bold"));
            localTextView.append(Utils.getColoredText("\n" + Utils.getText(2131165685) + " ", -16711821, "bold"));
            localTextView.append(Utils.getColoredText("" + Utils.getApkPackageInfo(listAppsFragment.rebuldApk).versionCode + "\n", -16711821, "bold"));
            continue;
            localNullPointerException = localNullPointerException;
            return new AlertDlg(listAppsFragment.frag.getContext()).setCancelable(true).setView(localRelativeLayout).create();
          }
          localObject4 = localNullPointerException;
          localObject5 = localNullPointerException;
          localFileInputStream.close();
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          TextView localTextView;
          Object localObject4;
          System.out.println("Custom Patch not Found in\n/sdcard/LuckyPatcher/\n");
          Object localObject2 = localObject4;
          continue;
        }
        catch (IOException localIOException)
        {
          Object localObject5;
          System.out.println("" + localIOException);
          Object localObject3 = localObject5;
          continue;
        }
        localTextView.append(Utils.getColoredText(Utils.getText(2131165397) + "\n", -990142, "bold"));
        localTextView.append(Utils.getColoredText("-----------------------------------------------\n", "", "bold"));
        localTextView.append(Utils.getColoredText(localNullPointerException, -990142, "bold"));
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/dialogs/Custom2_Dialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */