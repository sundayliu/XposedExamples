package com.google.android.vending.licensing;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.io.PrintStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LicenseChecker
  implements ServiceConnection
{
  private static final boolean DEBUG_LICENSE_ERROR = false;
  private static final String KEY_FACTORY_ALGORITHM = "RSA";
  private static final SecureRandom RANDOM = new SecureRandom();
  private static final String TAG = "LicenseChecker";
  private static final int TIMEOUT_MS = 10000;
  private final Set<LicenseValidator> mChecksInProgress = new HashSet();
  private final Context mContext;
  private Handler mHandler;
  private final String mPackageName;
  private final Queue<LicenseValidator> mPendingChecks = new LinkedList();
  private final Policy mPolicy;
  private PublicKey mPublicKey;
  private ILicensingService mService;
  private final String mVersionCode;
  public int responseCode;
  public String signature;
  public String signedData;
  
  public LicenseChecker(Context paramContext, Policy paramPolicy, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mPolicy = paramPolicy;
    this.mPublicKey = generatePublicKey(paramString1);
    this.mPackageName = paramString2;
    try
    {
      paramContext = "" + paramContext.getPackageManager().getPackageInfo(paramString2, 0).versionCode;
      this.mVersionCode = paramContext;
      paramContext = new HandlerThread("background thread");
      paramContext.start();
      this.mHandler = new Handler(paramContext.getLooper());
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "0";
      }
    }
  }
  
  private void cleanupService()
  {
    if (this.mService != null) {}
    try
    {
      this.mContext.unbindService(this);
      this.mService = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("LicenseChecker", "Unable to unbind from licensing service (already unbound)");
      }
    }
  }
  
  private void finishCheck(LicenseValidator paramLicenseValidator)
  {
    try
    {
      this.mChecksInProgress.remove(paramLicenseValidator);
      if (this.mChecksInProgress.isEmpty()) {
        cleanupService();
      }
      return;
    }
    finally
    {
      paramLicenseValidator = finally;
      throw paramLicenseValidator;
    }
  }
  
  private int generateNonce()
  {
    return RANDOM.nextInt();
  }
  
  private static PublicKey generatePublicKey(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString);
      paramString = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (Base64DecoderException paramString)
    {
      Log.e("LicenseChecker", "Could not decode from Base64.");
      throw new IllegalArgumentException(paramString);
    }
    catch (InvalidKeySpecException paramString)
    {
      Log.e("LicenseChecker", "Invalid key specification.");
      throw new IllegalArgumentException(paramString);
    }
  }
  
  private static String getVersionCode(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return String.valueOf(i);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.e("LicenseChecker", "Package not found. could not get version code.");
    }
    return "";
  }
  
  private void handleServiceConnectionError(LicenseValidator paramLicenseValidator)
  {
    try
    {
      this.mPolicy.processServerResponse(291, null);
      return;
    }
    finally
    {
      paramLicenseValidator = finally;
      throw paramLicenseValidator;
    }
  }
  
  private void runChecks()
  {
    for (;;)
    {
      LicenseValidator localLicenseValidator = (LicenseValidator)this.mPendingChecks.poll();
      if (localLicenseValidator == null) {
        break;
      }
      try
      {
        Log.i("LicenseChecker", "Calling checkLicense on service for " + localLicenseValidator.getPackageName());
        this.mService.checkLicense(localLicenseValidator.getNonce(), localLicenseValidator.getPackageName(), new ResultListener(localLicenseValidator));
        this.mChecksInProgress.add(localLicenseValidator);
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("LicenseChecker", "RemoteException in checkLicense call.", localRemoteException);
        handleServiceConnectionError(localLicenseValidator);
      }
    }
  }
  
  /* Error */
  public void checkAccess(LicenseCheckerCallback paramLicenseCheckerCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 260	com/google/android/vending/licensing/LicenseValidator
    //   5: dup
    //   6: aload_0
    //   7: getfield 77	com/google/android/vending/licensing/LicenseChecker:mPolicy	Lcom/google/android/vending/licensing/Policy;
    //   10: new 294	com/google/android/vending/licensing/NullDeviceLimiter
    //   13: dup
    //   14: invokespecial 295	com/google/android/vending/licensing/NullDeviceLimiter:<init>	()V
    //   17: aload_1
    //   18: aload_0
    //   19: invokespecial 297	com/google/android/vending/licensing/LicenseChecker:generateNonce	()I
    //   22: aload_0
    //   23: getfield 85	com/google/android/vending/licensing/LicenseChecker:mPackageName	Ljava/lang/String;
    //   26: aload_0
    //   27: getfield 120	com/google/android/vending/licensing/LicenseChecker:mVersionCode	Ljava/lang/String;
    //   30: invokespecial 300	com/google/android/vending/licensing/LicenseValidator:<init>	(Lcom/google/android/vending/licensing/Policy;Lcom/google/android/vending/licensing/DeviceLimiter;Lcom/google/android/vending/licensing/LicenseCheckerCallback;ILjava/lang/String;Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload_0
    //   36: getfield 167	com/google/android/vending/licensing/LicenseChecker:mService	Lcom/google/android/vending/licensing/ILicensingService;
    //   39: ifnonnull +275 -> 314
    //   42: ldc 25
    //   44: ldc_w 302
    //   47: invokestatic 268	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   50: pop
    //   51: new 304	android/content/Intent
    //   54: dup
    //   55: new 237	java/lang/String
    //   58: dup
    //   59: ldc_w 306
    //   62: invokestatic 208	com/google/android/vending/licensing/util/Base64:decode	(Ljava/lang/String;)[B
    //   65: invokespecial 307	java/lang/String:<init>	([B)V
    //   68: invokespecial 308	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   71: astore 5
    //   73: aload 5
    //   75: ldc_w 310
    //   78: invokevirtual 314	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   81: pop
    //   82: aload 5
    //   84: ldc_w 316
    //   87: ldc_w 318
    //   90: invokevirtual 322	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   93: pop
    //   94: iconst_0
    //   95: istore_3
    //   96: iconst_0
    //   97: istore_2
    //   98: invokestatic 327	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   101: aload 5
    //   103: iconst_0
    //   104: invokevirtual 331	android/content/pm/PackageManager:queryIntentServices	(Landroid/content/Intent;I)Ljava/util/List;
    //   107: invokeinterface 334 1 0
    //   112: ifne +139 -> 251
    //   115: invokestatic 327	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   118: aload 5
    //   120: iconst_0
    //   121: invokevirtual 331	android/content/pm/PackageManager:queryIntentServices	(Landroid/content/Intent;I)Ljava/util/List;
    //   124: invokeinterface 338 1 0
    //   129: astore 5
    //   131: iload_2
    //   132: istore_3
    //   133: aload 5
    //   135: invokeinterface 343 1 0
    //   140: ifeq +111 -> 251
    //   143: aload 5
    //   145: invokeinterface 346 1 0
    //   150: checkcast 348	android/content/pm/ResolveInfo
    //   153: astore 6
    //   155: aload 6
    //   157: getfield 352	android/content/pm/ResolveInfo:serviceInfo	Landroid/content/pm/ServiceInfo;
    //   160: getfield 357	android/content/pm/ServiceInfo:packageName	Ljava/lang/String;
    //   163: ifnull -32 -> 131
    //   166: aload 6
    //   168: getfield 352	android/content/pm/ResolveInfo:serviceInfo	Landroid/content/pm/ServiceInfo;
    //   171: getfield 357	android/content/pm/ServiceInfo:packageName	Ljava/lang/String;
    //   174: ldc_w 310
    //   177: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   180: ifeq -49 -> 131
    //   183: new 362	android/content/ComponentName
    //   186: dup
    //   187: aload 6
    //   189: getfield 352	android/content/pm/ResolveInfo:serviceInfo	Landroid/content/pm/ServiceInfo;
    //   192: getfield 357	android/content/pm/ServiceInfo:packageName	Ljava/lang/String;
    //   195: aload 6
    //   197: getfield 352	android/content/pm/ResolveInfo:serviceInfo	Landroid/content/pm/ServiceInfo;
    //   200: getfield 365	android/content/pm/ServiceInfo:name	Ljava/lang/String;
    //   203: invokespecial 368	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: astore 6
    //   208: new 304	android/content/Intent
    //   211: dup
    //   212: invokespecial 369	android/content/Intent:<init>	()V
    //   215: astore 7
    //   217: aload 7
    //   219: aload 6
    //   221: invokevirtual 373	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   224: pop
    //   225: aload 7
    //   227: ldc_w 316
    //   230: ldc_w 318
    //   233: invokevirtual 322	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   236: pop
    //   237: invokestatic 376	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   240: aload 7
    //   242: aload_0
    //   243: iconst_1
    //   244: invokevirtual 380	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   247: istore_2
    //   248: goto -117 -> 131
    //   251: iload_3
    //   252: ifeq +18 -> 270
    //   255: aload_0
    //   256: getfield 73	com/google/android/vending/licensing/LicenseChecker:mPendingChecks	Ljava/util/Queue;
    //   259: aload 4
    //   261: invokeinterface 383 2 0
    //   266: pop
    //   267: aload_0
    //   268: monitorexit
    //   269: return
    //   270: ldc 25
    //   272: ldc_w 385
    //   275: invokestatic 179	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   278: pop
    //   279: aload_0
    //   280: aload 4
    //   282: invokespecial 152	com/google/android/vending/licensing/LicenseChecker:handleServiceConnectionError	(Lcom/google/android/vending/licensing/LicenseValidator;)V
    //   285: goto -18 -> 267
    //   288: astore 4
    //   290: aload_1
    //   291: bipush 6
    //   293: invokeinterface 391 2 0
    //   298: goto -31 -> 267
    //   301: astore_1
    //   302: aload_0
    //   303: monitorexit
    //   304: aload_1
    //   305: athrow
    //   306: astore_1
    //   307: aload_1
    //   308: invokevirtual 392	com/google/android/vending/licensing/util/Base64DecoderException:printStackTrace	()V
    //   311: goto -44 -> 267
    //   314: aload_0
    //   315: getfield 73	com/google/android/vending/licensing/LicenseChecker:mPendingChecks	Ljava/util/Queue;
    //   318: aload 4
    //   320: invokeinterface 383 2 0
    //   325: pop
    //   326: aload_0
    //   327: invokespecial 394	com/google/android/vending/licensing/LicenseChecker:runChecks	()V
    //   330: goto -63 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	LicenseChecker
    //   0	333	1	paramLicenseCheckerCallback	LicenseCheckerCallback
    //   97	151	2	bool	boolean
    //   95	157	3	i	int
    //   33	248	4	localLicenseValidator	LicenseValidator
    //   288	31	4	localSecurityException	SecurityException
    //   71	73	5	localObject1	Object
    //   153	67	6	localObject2	Object
    //   215	26	7	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   51	94	288	java/lang/SecurityException
    //   98	131	288	java/lang/SecurityException
    //   133	248	288	java/lang/SecurityException
    //   255	267	288	java/lang/SecurityException
    //   270	285	288	java/lang/SecurityException
    //   2	51	301	finally
    //   51	94	301	finally
    //   98	131	301	finally
    //   133	248	301	finally
    //   255	267	301	finally
    //   270	285	301	finally
    //   290	298	301	finally
    //   307	311	301	finally
    //   314	330	301	finally
    //   51	94	306	com/google/android/vending/licensing/util/Base64DecoderException
    //   98	131	306	com/google/android/vending/licensing/util/Base64DecoderException
    //   133	248	306	com/google/android/vending/licensing/util/Base64DecoderException
    //   255	267	306	com/google/android/vending/licensing/util/Base64DecoderException
    //   270	285	306	com/google/android/vending/licensing/util/Base64DecoderException
  }
  
  public void onDestroy()
  {
    try
    {
      cleanupService();
      this.mHandler.getLooper().quit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.mService = ILicensingService.Stub.asInterface(paramIBinder);
      runChecks();
      return;
    }
    finally
    {
      paramComponentName = finally;
      throw paramComponentName;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      Log.w("LicenseChecker", "Service unexpectedly disconnected.");
      this.mService = null;
      return;
    }
    finally
    {
      paramComponentName = finally;
      throw paramComponentName;
    }
  }
  
  public class ResultListener
    extends ILicenseResultListener.Stub
  {
    private static final int ERROR_CONTACTING_SERVER = 257;
    private static final int ERROR_INVALID_PACKAGE_NAME = 258;
    private static final int ERROR_NON_MATCHING_UID = 259;
    private Runnable mOnTimeout;
    private final LicenseValidator mValidator;
    
    public ResultListener(LicenseValidator paramLicenseValidator)
    {
      this.mValidator = paramLicenseValidator;
      this.mOnTimeout = new Runnable()
      {
        public void run()
        {
          Log.i("LicenseChecker", "Check timed out.");
          LicenseChecker.this.handleServiceConnectionError(LicenseChecker.ResultListener.this.mValidator);
          LicenseChecker.this.finishCheck(LicenseChecker.ResultListener.this.mValidator);
        }
      };
      startTimeout();
    }
    
    private void clearTimeout()
    {
      Log.i("LicenseChecker", "Clearing timeout.");
      LicenseChecker.this.mHandler.removeCallbacks(this.mOnTimeout);
    }
    
    private void startTimeout()
    {
      Log.i("LicenseChecker", "Start monitoring timeout.");
      LicenseChecker.this.mHandler.postDelayed(this.mOnTimeout, 10000L);
    }
    
    public void verifyLicense(final int paramInt, final String paramString1, final String paramString2)
    {
      LicenseChecker.this.signedData = paramString1;
      LicenseChecker.this.signature = paramString2;
      LicenseChecker.this.responseCode = paramInt;
      LicenseChecker.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Log.i("LicenseChecker", "Received response.");
          System.out.println("Responce Code: " + paramInt);
          if (LicenseChecker.this.mChecksInProgress.contains(LicenseChecker.ResultListener.this.mValidator))
          {
            LicenseChecker.ResultListener.this.clearTimeout();
            LicenseChecker.ResultListener.this.mValidator.verify(LicenseChecker.this.mPublicKey, paramInt, paramString1, paramString2);
            LicenseChecker.this.finishCheck(LicenseChecker.ResultListener.this.mValidator);
          }
        }
      });
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/vending/licensing/LicenseChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */