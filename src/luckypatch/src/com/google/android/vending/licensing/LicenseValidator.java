package com.google.android.vending.licensing;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.io.PrintStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

class LicenseValidator
{
  private static final int ERROR_CONTACTING_SERVER = 257;
  private static final int ERROR_INVALID_PACKAGE_NAME = 258;
  private static final int ERROR_NON_MATCHING_UID = 259;
  private static final int ERROR_NOT_MARKET_MANAGED = 3;
  private static final int ERROR_OVER_QUOTA = 5;
  private static final int ERROR_SERVER_FAILURE = 4;
  private static final int LICENSED = 0;
  private static final int LICENSED_OLD_KEY = 2;
  private static final int NOT_LICENSED = 1;
  private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
  private static final String TAG = "LicenseValidator";
  private LicenseCheckerCallback mCallback;
  private final DeviceLimiter mDeviceLimiter;
  private final int mNonce;
  private final String mPackageName;
  private final Policy mPolicy;
  private final String mVersionCode;
  
  LicenseValidator(Policy paramPolicy, DeviceLimiter paramDeviceLimiter, LicenseCheckerCallback paramLicenseCheckerCallback, int paramInt, String paramString1, String paramString2)
  {
    this.mPolicy = paramPolicy;
    this.mDeviceLimiter = paramDeviceLimiter;
    this.mCallback = paramLicenseCheckerCallback;
    this.mNonce = paramInt;
    this.mPackageName = paramString1;
    this.mVersionCode = paramString2;
  }
  
  private void handleApplicationError(int paramInt)
  {
    this.mCallback.applicationError(paramInt);
  }
  
  private void handleInvalidResponse()
  {
    this.mCallback.dontAllow(561);
  }
  
  private void handleResponse(int paramInt, ResponseData paramResponseData)
  {
    this.mPolicy.processServerResponse(paramInt, paramResponseData);
    if (this.mPolicy.allowAccess())
    {
      this.mCallback.allow(paramInt);
      return;
    }
    this.mCallback.dontAllow(paramInt);
  }
  
  public LicenseCheckerCallback getCallback()
  {
    return this.mCallback;
  }
  
  public int getNonce()
  {
    return this.mNonce;
  }
  
  public String getPackageName()
  {
    return this.mPackageName;
  }
  
  public void verify(PublicKey paramPublicKey, int paramInt, String paramString1, String paramString2)
  {
    Object localObject3 = null;
    System.out.println("" + paramInt + " " + paramString1);
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    if ((paramInt != 0) && (paramInt != 1))
    {
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (paramInt != 2) {}
    }
    else
    {
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (paramString1 != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (paramString2 != null)
        {
          try
          {
            localObject1 = Signature.getInstance("SHA1withRSA");
            ((Signature)localObject1).initVerify(paramPublicKey);
            ((Signature)localObject1).update(paramString1.getBytes());
            if (!((Signature)localObject1).verify(Base64.decode(paramString2)))
            {
              Log.e("LicenseValidator", "Signature verification failed.");
              handleInvalidResponse();
              return;
            }
          }
          catch (NoSuchAlgorithmException paramPublicKey)
          {
            throw new RuntimeException(paramPublicKey);
          }
          catch (InvalidKeyException paramPublicKey)
          {
            handleApplicationError(5);
            return;
          }
          catch (SignatureException paramPublicKey)
          {
            throw new RuntimeException(paramPublicKey);
          }
          catch (Base64DecoderException paramPublicKey)
          {
            Log.e("LicenseValidator", "Could not Base64-decode signature.");
            handleInvalidResponse();
            return;
          }
          try
          {
            localObject1 = ResponseData.parse(paramString1);
            if (((ResponseData)localObject1).responseCode != paramInt)
            {
              Log.e("LicenseValidator", "Response codes don't match.");
              handleInvalidResponse();
              return;
            }
          }
          catch (IllegalArgumentException paramPublicKey)
          {
            Log.e("LicenseValidator", "Could not parse response.");
            handleInvalidResponse();
            return;
          }
          if (((ResponseData)localObject1).nonce != this.mNonce)
          {
            Log.e("LicenseValidator", "Nonce doesn't match.");
            handleInvalidResponse();
            return;
          }
          if (!((ResponseData)localObject1).packageName.equals(this.mPackageName))
          {
            Log.e("LicenseValidator", "Package name doesn't match.");
            handleInvalidResponse();
            return;
          }
          if (!((ResponseData)localObject1).versionCode.equals(this.mVersionCode))
          {
            Log.e("LicenseValidator", "Version codes don't match.");
            handleInvalidResponse();
            return;
          }
          paramPublicKey = ((ResponseData)localObject1).userId;
          localObject2 = paramPublicKey;
          if (TextUtils.isEmpty(paramPublicKey))
          {
            Log.e("LicenseValidator", "User identifier is empty.");
            handleInvalidResponse();
            return;
          }
        }
      }
    }
    System.out.println("response code: " + paramInt);
    switch (paramInt)
    {
    default: 
      handleResponse(561, (ResponseData)localObject1);
      return;
    case 0: 
    case 2: 
      handleResponse(this.mDeviceLimiter.isDeviceAllowed((String)localObject2), (ResponseData)localObject1);
      return;
    case 1: 
      handleResponse(561, (ResponseData)localObject1);
      return;
    case 257: 
      handleResponse(561, (ResponseData)localObject1);
      return;
    }
    handleApplicationError(3);
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/vending/licensing/LicenseValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */