package com.google.android.vending.licensing;

import android.content.Context;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class APKExpansionPolicy
  implements Policy
{
  private static final String DEFAULT_MAX_RETRIES = "0";
  private static final String DEFAULT_RETRY_COUNT = "0";
  private static final String DEFAULT_RETRY_UNTIL = "0";
  private static final String DEFAULT_VALIDITY_TIMESTAMP = "0";
  public static final int MAIN_FILE_URL_INDEX = 0;
  private static final long MILLIS_PER_MINUTE = 60000L;
  public static final int PATCH_FILE_URL_INDEX = 1;
  private static final String PREFS_FILE = "com.android.vending.licensing.APKExpansionPolicy";
  private static final String PREF_LAST_RESPONSE = "lastResponse";
  private static final String PREF_MAX_RETRIES = "maxRetries";
  private static final String PREF_RETRY_COUNT = "retryCount";
  private static final String PREF_RETRY_UNTIL = "retryUntil";
  private static final String PREF_VALIDITY_TIMESTAMP = "validityTimestamp";
  private static final String TAG = "APKExpansionPolicy";
  private Vector<String> mExpansionFileNames = new Vector();
  private Vector<Long> mExpansionFileSizes = new Vector();
  private Vector<String> mExpansionURLs = new Vector();
  private int mLastResponse;
  private long mLastResponseTime = 0L;
  private long mMaxRetries;
  private PreferenceObfuscator mPreferences;
  private long mRetryCount;
  private long mRetryUntil;
  private long mValidityTimestamp;
  
  public APKExpansionPolicy(Context paramContext, Obfuscator paramObfuscator)
  {
    this.mPreferences = new PreferenceObfuscator(paramContext.getSharedPreferences("com.android.vending.licensing.APKExpansionPolicy", 0), paramObfuscator);
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
      Iterator localIterator = URLEncodedUtils.parse(new URI("?" + paramString), "UTF-8").iterator();
      while (localIterator.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
        paramString = localNameValuePair.getName();
        int i = 0;
        while (localHashMap.containsKey(paramString))
        {
          paramString = new StringBuilder().append(localNameValuePair.getName());
          i += 1;
          paramString = i;
        }
        localHashMap.put(paramString, localNameValuePair.getValue());
      }
      return localHashMap;
    }
    catch (URISyntaxException paramString)
    {
      Log.w("APKExpansionPolicy", "Invalid syntax error while decoding extras data from server.");
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
        Log.w("APKExpansionPolicy", "Licence retry count (GR) missing, grace period disabled");
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
        Log.w("APKExpansionPolicy", "License retry timestamp (GT) missing, grace period disabled");
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
        Log.w("APKExpansionPolicy", "License validity timestamp (VT) missing, caching for a minute");
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
  
  public String getExpansionFileName(int paramInt)
  {
    if (paramInt < this.mExpansionFileNames.size()) {
      return (String)this.mExpansionFileNames.elementAt(paramInt);
    }
    return null;
  }
  
  public long getExpansionFileSize(int paramInt)
  {
    if (paramInt < this.mExpansionFileSizes.size()) {
      return ((Long)this.mExpansionFileSizes.elementAt(paramInt)).longValue();
    }
    return -1L;
  }
  
  public String getExpansionURL(int paramInt)
  {
    if (paramInt < this.mExpansionURLs.size()) {
      return (String)this.mExpansionURLs.elementAt(paramInt);
    }
    return null;
  }
  
  public int getExpansionURLCount()
  {
    return this.mExpansionURLs.size();
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
    Iterator localIterator;
    if (paramInt != 291)
    {
      setRetryCount(0L);
      if (paramInt == 256)
      {
        paramResponseData = decodeExtras(paramResponseData.extra);
        this.mLastResponse = paramInt;
        setValidityTimestamp(Long.toString(System.currentTimeMillis() + 60000L));
        localIterator = paramResponseData.keySet().iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label342;
        }
        String str = (String)localIterator.next();
        if (str.equals("VT"))
        {
          setValidityTimestamp((String)paramResponseData.get(str));
          continue;
          setRetryCount(this.mRetryCount + 1L);
          break;
        }
        if (str.equals("GT")) {
          setRetryUntil((String)paramResponseData.get(str));
        } else if (str.equals("GR")) {
          setMaxRetries((String)paramResponseData.get(str));
        } else if (str.startsWith("FILE_URL")) {
          setExpansionURL(Integer.parseInt(str.substring("FILE_URL".length())) - 1, (String)paramResponseData.get(str));
        } else if (str.startsWith("FILE_NAME")) {
          setExpansionFileName(Integer.parseInt(str.substring("FILE_NAME".length())) - 1, (String)paramResponseData.get(str));
        } else if (str.startsWith("FILE_SIZE")) {
          setExpansionFileSize(Integer.parseInt(str.substring("FILE_SIZE".length())) - 1, Long.parseLong((String)paramResponseData.get(str)));
        }
      }
    }
    if (paramInt == 561)
    {
      setValidityTimestamp("0");
      setRetryUntil("0");
      setMaxRetries("0");
    }
    label342:
    setLastResponse(paramInt);
    this.mPreferences.commit();
  }
  
  public void resetPolicy()
  {
    this.mPreferences.putString("lastResponse", Integer.toString(291));
    setRetryUntil("0");
    setMaxRetries("0");
    setRetryCount(Long.parseLong("0"));
    setValidityTimestamp("0");
    this.mPreferences.commit();
  }
  
  public void setExpansionFileName(int paramInt, String paramString)
  {
    if (paramInt >= this.mExpansionFileNames.size()) {
      this.mExpansionFileNames.setSize(paramInt + 1);
    }
    this.mExpansionFileNames.set(paramInt, paramString);
  }
  
  public void setExpansionFileSize(int paramInt, long paramLong)
  {
    if (paramInt >= this.mExpansionFileSizes.size()) {
      this.mExpansionFileSizes.setSize(paramInt + 1);
    }
    this.mExpansionFileSizes.set(paramInt, Long.valueOf(paramLong));
  }
  
  public void setExpansionURL(int paramInt, String paramString)
  {
    if (paramInt >= this.mExpansionURLs.size()) {
      this.mExpansionURLs.setSize(paramInt + 1);
    }
    this.mExpansionURLs.set(paramInt, paramString);
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/vending/licensing/APKExpansionPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */