package com.google.android.vending.licensing;

public abstract interface Obfuscator
{
  public abstract String obfuscate(String paramString1, String paramString2);
  
  public abstract String unobfuscate(String paramString1, String paramString2)
    throws ValidationException;
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/vending/licensing/Obfuscator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */