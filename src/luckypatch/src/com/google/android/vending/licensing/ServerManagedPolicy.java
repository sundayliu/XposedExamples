package com.google.android.vending.licensing;

import android.content.Context;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class ServerManagedPolicy
  implements Policy
{
  private static final String DEFAULT_MAX_RETRIES = "0";
  private static final String DEFAULT_RETRY_COUNT = "0";
  private static final String DEFAULT_RETRY_UNTIL = "0";
  private static final String DEFAULT_VALIDITY_TIMESTAMP = "0";
  private static final long MILLIS_PER_MINUTE = 60000L;
  private static final String PREFS_FILE = "com.android.vending.licensing.ServerManagedPolicy";
  private static final String PREF_LAST_RESPONSE = "lastResponse";
  private static final String PREF_MAX_RETRIES = "maxRetries";
  private static final String PREF_RETRY_COUNT = "retryCount";
  private static final String PREF_RETRY_UNTIL = "retryUntil";
  private static final String PREF_VALIDITY_TIMESTAMP = "validityTimestamp";
  private static final String TAG = "ServerManagedPolicy";
  private int mLastResponse;
  private long mLastResponseTime = 0L;
  private long mMaxRetries;
  private PreferenceObfuscator mPreferences;
  private long mRetryCount;
  private long mRetryUntil;
  private long mValidityTimestamp;
  
  public ServerManagedPolicy(Context paramContext, Obfuscator paramObfuscator)
  {
    this.mPreferences = new PreferenceObfuscator(paramContext.getSharedPreferences("com.android.vending.licensing.ServerManagedPolicy", 0), paramObfuscator);
    this.mLastResponse = Integer.parseInt(this.mPreferences.getString("lastResponse", Integer.toString(291)));
    this.mValidityTimestamp = Long.parseLong(this.mPreferences.getString("validityTimestamp", "0"));
    this.mRetryUntil = Long.parseLong(this.mPreferences.getString("retryUntil", "0"));
    this.mMaxRetries = Long.parseLong(this.mPreferences.getString("maxRetries", "0"));
    this.mRetryCount = Long.parseLong(this.mPreferences.getString("retryCount", "0"));
  }
  
  private Map<String, String> decodeExtras(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      paramString = URLEncodedUtils.parse(new URI("?" + paramString), "UTF-8").iterator();
      while (paramString.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)paramString.next();
        localHashMap.put(localNameValuePair.getName(), localNameValuePair.getValue());
      }
      return localHashMap;
    }
    catch (URISyntaxException paramString)
    {
      Log.w("ServerManagedPolicy", "Invalid syntax error while decoding extras data from server.");
    }
  }
  
  private void setLastResponse(int paramInt)
  {
    this.mLastResponseTime = System.currentTimeMillis();
    this.mLastResponse = paramInt;
    this.mPreferences.putString("lastResponse", Integer.toString(paramInt));
  }
  
  private void setMaxRetries(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      Long localLong = Long.valueOf(l);
      str = paramString;
      paramString = localLong;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        Log.w("ServerManagedPolicy", "Licence retry count (GR) missing, grace period disabled");
        String str = "0";
        paramString = Long.valueOf(0L);
      }
    }
    this.mMaxRetries = paramString.longValue();
    this.mPreferences.putString("maxRetries", str);
  }
  
  private void setRetryCount(long paramLong)
  {
    this.mRetryCount = paramLong;
    this.mPreferences.putString("retryCount", Long.toString(paramLong));
  }
  
  private void setRetryUntil(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      Long localLong = Long.valueOf(l);
      str = paramString;
      paramString = localLong;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        Log.w("ServerManagedPolicy", "License retry timestamp (GT) missing, grace period disabled");
        String str = "0";
        paramString = Long.valueOf(0L);
      }
    }
    this.mRetryUntil = paramString.longValue();
    this.mPreferences.putString("retryUntil", str);
  }
  
  private void setValidityTimestamp(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      Long localLong = Long.valueOf(l);
      str = paramString;
      paramString = localLong;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        Log.w("ServerManagedPolicy", "License validity timestamp (VT) missing, caching for a minute");
        paramString = Long.valueOf(System.currentTimeMillis() + 60000L);
        String str = Long.toString(paramString.longValue());
      }
    }
    this.mValidityTimestamp = paramString.longValue();
    this.mPreferences.putString("validityTimestamp", str);
  }
  
  public boolean allowAccess()
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    boolean bool1;
    if (this.mLastResponse == 256)
    {
      bool1 = bool2;
      if (l <= this.mValidityTimestamp) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.mLastResponse != 291);
        bool1 = bool2;
      } while (l >= this.mLastResponseTime + 60000L);
      if (l <= this.mRetryUntil) {
        break;
      }
      bool1 = bool2;
    } while (this.mRetryCount > this.mMaxRetries);
    return true;
  }
  
  public long getMaxRetries()
  {
    return this.mMaxRetries;
  }
  
  public long getRetryCount()
  {
    return this.mRetryCount;
  }
  
  public long getRetryUntil()
  {
    return this.mRetryUntil;
  }
  
  public long getValidityTimestamp()
  {
    return this.mValidityTimestamp;
  }
  
  public void processServerResponse(int paramInt, ResponseData paramResponseData)
  {
    if (paramInt != 291)
    {
      setRetryCount(0L);
      if (paramInt != 256) {
        break label104;
      }
      paramResponseData = decodeExtras(paramResponseData.extra);
      this.mLastResponse = paramInt;
      setValidityTimestamp((String)paramResponseData.get("VT"));
      setRetryUntil((String)paramResponseData.get("GT"));
      setMaxRetries((String)paramResponseData.get("GR"));
    }
    for (;;)
    {
      setLastResponse(paramInt);
      this.mPreferences.commit();
      return;
      setRetryCount(this.mRetryCount + 1L);
      break;
      label104:
      if (paramInt == 561)
      {
        setValidityTimestamp("0");
        setRetryUntil("0");
        setMaxRetries("0");
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/vending/licensing/ServerManagedPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */