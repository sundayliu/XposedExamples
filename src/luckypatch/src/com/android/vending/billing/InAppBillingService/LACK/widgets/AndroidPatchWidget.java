package com.android.vending.billing.InAppBillingService.LACK.widgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import com.chelpus.Utils;
import java.io.PrintStream;

public class AndroidPatchWidget
  extends AppWidgetProvider
{
  static void updateAppWidget(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt)
  {
    paramContext.getString(2131165803);
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130968581);
    int i = 0;
    int j = 0;
    int m = 0;
    int n = 0;
    if (Utils.checkCoreJarPatch11())
    {
      i = 0 + 1;
      j = 1;
    }
    int k = i;
    if (Utils.checkCoreJarPatch12())
    {
      k = i + 1;
      j = 1;
    }
    Object localObject;
    if (k > 0)
    {
      localObject = Utils.getText(2131165300) + "\n(" + k + "/2 patched)";
      if (!Utils.checkCoreJarPatch20()) {
        break label430;
      }
      localObject = (String)localObject + "\n" + Utils.getText(2131165302) + "\n(patched)";
      m = 1;
      label147:
      if (!Utils.checkCoreJarPatch30(paramContext.getPackageManager())) {
        break label468;
      }
      paramContext = (String)localObject + "\n" + Utils.getText(2131165304) + "\n(patched)";
      i = 1;
      label193:
      localObject = new SpannableString(paramContext);
      if (j == 0) {
        break label508;
      }
      j = Utils.getText(2131165300).length() + (" (" + k + "/2 patched)").length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16711936), Utils.getText(2131165300).length(), j, 0);
      label272:
      if (m == 0) {
        break label552;
      }
      k = Utils.getText(2131165302).length() + j + 1 + " (patched)".length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16711936), Utils.getText(2131165302).length() + j + 1, k, 0);
      label328:
      if (i == 0) {
        break label606;
      }
      i = Utils.getText(2131165304).length();
      j = " (patched)".length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16711936), Utils.getText(2131165304).length() + k + 1, i + k + 1 + j, 0);
    }
    for (;;)
    {
      localRemoteViews.setTextViewText(2131558447, (CharSequence)localObject);
      paramAppWidgetManager.updateAppWidget(paramInt, localRemoteViews);
      return;
      localObject = Utils.getText(2131165300) + "\n(not patched)";
      break;
      label430:
      localObject = (String)localObject + "\n" + Utils.getText(2131165302) + "\n(not patched)";
      break label147;
      label468:
      paramContext = (String)localObject + "\n" + Utils.getText(2131165304) + "\n(not patched)";
      i = n;
      break label193;
      label508:
      j = Utils.getText(2131165300).length() + " (not patched)".length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-65536), Utils.getText(2131165300).length(), j, 0);
      break label272;
      label552:
      k = Utils.getText(2131165302).length() + 1 + j + " (not patched)".length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-65536), Utils.getText(2131165302).length() + 1 + j, k, 0);
      break label328;
      label606:
      i = Utils.getText(2131165304).length();
      m = " (not patched)".length();
      System.out.println(j);
      System.out.println(k);
      System.out.println(paramContext.length());
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-65536), Utils.getText(2131165304).length() + k + 1, i + k + 1 + m, 0);
    }
  }
  
  public void onDisabled(Context paramContext) {}
  
  public void onEnabled(Context paramContext) {}
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    new RemoteViews(paramContext.getPackageName(), 2130968581);
    int i = paramArrayOfInt.length;
    int j = paramArrayOfInt.length;
    i = 0;
    while (i < j)
    {
      updateAppWidget(paramContext, paramAppWidgetManager, paramArrayOfInt[i]);
      i += 1;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/widgets/AndroidPatchWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */