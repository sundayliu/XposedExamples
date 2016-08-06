package com.chelpus;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class GradientTextView
  extends TextView
{
  public GradientTextView(Context paramContext)
  {
    super(paramContext, null, -1);
  }
  
  public GradientTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, -1);
  }
  
  public GradientTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      getPaint().setShader(new LinearGradient(0.0F, 0.0F, getWidth(), 0.0F, Color.parseColor("#FF6699cc"), Color.parseColor("#906699cc"), Shader.TileMode.CLAMP));
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/GradientTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */