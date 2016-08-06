package com.android.vending.billing.InAppBillingService.LACK;

public class ShellOnMainThreadException
  extends RuntimeException
{
  public static final String EXCEPTION_COMMAND = "Application attempted to run a shell command from the main thread";
  public static final String EXCEPTION_NOT_IDLE = "Application attempted to wait for a non-idle shell to close on the main thread";
  public static final String EXCEPTION_WAIT_IDLE = "Application attempted to wait for a shell to become idle on the main thread";
  
  public ShellOnMainThreadException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/ShellOnMainThreadException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */