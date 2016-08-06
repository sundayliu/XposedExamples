package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.PrintStream;

public class ProgressDlg
{
  public static int max = 0;
  public Context context = null;
  public Dialog dialog = null;
  public String format = "%1d/%2d";
  public boolean incrementStyle = false;
  public View root = null;
  
  public ProgressDlg(Context paramContext)
  {
    this.context = paramContext;
    this.dialog = new Dialog(paramContext);
    this.dialog.requestWindowFeature(1);
    this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    this.dialog.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      int current_width = 0;
      int displayWidth = 0;
      int orient = 255;
      int setForSize = 0;
      
      public void onGlobalLayout()
      {
        Window localWindow;
        int j;
        int i;
        WindowManager.LayoutParams localLayoutParams;
        int k;
        if (ProgressDlg.this.incrementStyle)
        {
          localWindow = ProgressDlg.this.dialog.getWindow();
          this.current_width = localWindow.getDecorView().getWidth();
          j = listAppsFragment.getRes().getDisplayMetrics().heightPixels;
          i = listAppsFragment.getRes().getDisplayMetrics().widthPixels;
          if (j <= i) {
            break label200;
          }
          this.orient = 0;
          if ((this.displayWidth == 0) || (this.displayWidth != i))
          {
            this.setForSize = 0;
            this.displayWidth = i;
          }
          if ((this.setForSize == 0) || (this.current_width != this.setForSize))
          {
            localWindow.setGravity(17);
            localLayoutParams = localWindow.getAttributes();
            j = (int)(i * 0.98D);
            k = (int)(i * 0.6D);
            System.out.println("wight:" + this.current_width);
            switch (this.orient)
            {
            }
          }
        }
        for (;;)
        {
          localWindow.setAttributes(localLayoutParams);
          return;
          label200:
          this.orient = 1;
          break;
          if (i < 900)
          {
            if (this.current_width >= k)
            {
              localLayoutParams.width = j;
              this.setForSize = j;
            }
            else
            {
              localLayoutParams.width = k;
              this.setForSize = k;
            }
          }
          else if (this.current_width >= j)
          {
            localLayoutParams.width = j;
            this.setForSize = j;
          }
          else if (this.current_width < k)
          {
            localLayoutParams.width = k;
            this.setForSize = k;
          }
          else
          {
            localLayoutParams.width = this.current_width;
            continue;
            if (i < 900)
            {
              if (this.current_width < k)
              {
                localLayoutParams.width = k;
                this.setForSize = k;
              }
            }
            else if (this.current_width < k)
            {
              localLayoutParams.width = k;
              this.setForSize = k;
            }
            else
            {
              localLayoutParams.width = this.current_width;
            }
          }
        }
      }
    });
    this.dialog.setContentView(2130968631);
    this.dialog.setCancelable(false);
    paramContext = (ProgressBar)this.dialog.findViewById(2131558628);
    paramContext.setMax(0);
    paramContext.setProgress(0);
    paramContext.setSecondaryProgress(0);
  }
  
  public Dialog create()
  {
    return this.dialog;
  }
  
  public boolean isShowing()
  {
    return this.dialog.isShowing();
  }
  
  public ProgressDlg setCancelable(boolean paramBoolean)
  {
    this.dialog.setCancelable(paramBoolean);
    return this;
  }
  
  public ProgressDlg setDefaultStyle()
  {
    this.incrementStyle = false;
    try
    {
      ((Activity)this.context).runOnUiThread(new Runnable()
      {
        public void run()
        {
          ((ProgressBar)ProgressDlg.this.dialog.findViewById(2131558628)).setVisibility(8);
          ((LinearLayout)ProgressDlg.this.dialog.findViewById(2131558629)).setVisibility(8);
        }
      });
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public ProgressDlg setIcon(final int paramInt)
  {
    try
    {
      ((Activity)this.context).runOnUiThread(new Runnable()
      {
        public void run()
        {
          ((LinearLayout)ProgressDlg.this.dialog.findViewById(2131558432)).setVisibility(0);
          ImageView localImageView = (ImageView)ProgressDlg.this.dialog.findViewById(2131558433);
          localImageView.setVisibility(0);
          localImageView.setImageDrawable(ProgressDlg.this.context.getResources().getDrawable(paramInt));
          ((TextView)ProgressDlg.this.dialog.findViewById(2131558435)).setVisibility(0);
        }
      });
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public ProgressDlg setIncrementStyle()
  {
    this.incrementStyle = true;
    try
    {
      ((Activity)this.context).runOnUiThread(new Runnable()
      {
        public void run()
        {
          ((ProgressBar)ProgressDlg.this.dialog.findViewById(2131558628)).setVisibility(0);
          ((LinearLayout)ProgressDlg.this.dialog.findViewById(2131558629)).setVisibility(0);
          TextView localTextView = (TextView)ProgressDlg.this.dialog.findViewById(2131558630);
        }
      });
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public ProgressDlg setMax(final int paramInt)
  {
    try
    {
      max = paramInt;
      ProgressBar localProgressBar = (ProgressBar)this.dialog.findViewById(2131558628);
      localProgressBar.setVisibility(0);
      localProgressBar.setMax(max);
      ((Activity)this.context).runOnUiThread(new Runnable()
      {
        public void run()
        {
          TextView localTextView = (TextView)ProgressDlg.this.dialog.findViewById(2131558630);
          ProgressBar localProgressBar = (ProgressBar)ProgressDlg.this.dialog.findViewById(2131558628);
          localTextView.setText(String.format(ProgressDlg.this.format, new Object[] { Integer.valueOf(localProgressBar.getProgress()), Integer.valueOf(paramInt) }));
        }
      });
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public ProgressDlg setMessage(final String paramString)
  {
    try
    {
      ((Activity)this.context).runOnUiThread(new Runnable()
      {
        public void run()
        {
          ((TextView)ProgressDlg.this.dialog.findViewById(2131558441)).setText(paramString);
        }
      });
      return this;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public ProgressDlg setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.dialog.setOnCancelListener(paramOnCancelListener);
    return this;
  }
  
  public ProgressDlg setProgress(final int paramInt)
  {
    try
    {
      ((Activity)this.context).runOnUiThread(new Runnable()
      {
        public void run()
        {
          ProgressBar localProgressBar = (ProgressBar)ProgressDlg.this.dialog.findViewById(2131558628);
          localProgressBar.setVisibility(0);
          localProgressBar.setProgress(paramInt);
          ((TextView)ProgressDlg.this.dialog.findViewById(2131558630)).setText(String.format(ProgressDlg.this.format, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ProgressDlg.max) }));
        }
      });
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public void setProgressNumberFormat(String paramString)
  {
    try
    {
      this.format = paramString;
      ((Activity)this.context).runOnUiThread(new Runnable()
      {
        public void run()
        {
          TextView localTextView = (TextView)ProgressDlg.this.dialog.findViewById(2131558630);
          ProgressBar localProgressBar = (ProgressBar)ProgressDlg.this.dialog.findViewById(2131558628);
          localTextView.setText(String.format(ProgressDlg.this.format, new Object[] { Integer.valueOf(localProgressBar.getProgress()), Integer.valueOf(ProgressDlg.max) }));
        }
      });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public ProgressDlg setTitle(final int paramInt)
  {
    try
    {
      ((Activity)this.context).runOnUiThread(new Runnable()
      {
        public void run()
        {
          ((LinearLayout)ProgressDlg.this.dialog.findViewById(2131558432)).setVisibility(0);
          ((TextView)ProgressDlg.this.dialog.findViewById(2131558434)).setText(paramInt);
        }
      });
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public ProgressDlg setTitle(final String paramString)
  {
    try
    {
      ((Activity)this.context).runOnUiThread(new Runnable()
      {
        public void run()
        {
          ((LinearLayout)ProgressDlg.this.dialog.findViewById(2131558432)).setVisibility(0);
          ((TextView)ProgressDlg.this.dialog.findViewById(2131558434)).setText(paramString);
          ((TextView)ProgressDlg.this.dialog.findViewById(2131558435)).setVisibility(0);
        }
      });
      return this;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/ProgressDlg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */