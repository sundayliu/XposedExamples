package com.google.android.vending.licensing;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class PreferenceObfuscator
{
  private static final String TAG = "PreferenceObfuscator";
  private SharedPreferences.Editor mEditor;
  private final Obfuscator mObfuscator;
  private final SharedPreferences mPreferences;
  
  public PreferenceObfuscator(SharedPreferences paramSharedPreferences, Obfuscator paramObfuscator)
  {
    this.mPreferences = paramSharedPreferences;
    this.mObfuscator = paramObfuscator;
    this.mEditor = null;
  }
  
  public void commit()
  {
    if (this.mEditor != null)
    {
      this.mEditor.commit();
      this.mEditor = null;
    }
  }
  
  public String getString(String paramString1, String paramString2)
  {
    String str = this.mPreferences.getString(paramString1, null);
    if (str != null) {
      try
      {
        str = this.mObfuscator.unobfuscate(str, paramString1);
        return str;
      }
      catch (ValidationException localValidationException)
      {
        Log.w("PreferenceObfuscator", "Validation error while reading preference: " + paramString1);
        return paramString2;
      }
    }
    return paramString2;
  }
  
  public void putString(String paramString1, String paramString2)
  {
    if (this.mEditor == null) {
      this.mEditor = this.mPreferences.edit();
    }
    paramString2 = this.mObfuscator.obfuscate(paramString2, paramString1);
    this.mEditor.putString(paramString1, paramString2);
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/vending/licensing/PreferenceObfuscator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */