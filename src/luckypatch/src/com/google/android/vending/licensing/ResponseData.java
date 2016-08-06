package com.google.android.vending.licensing;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class ResponseData
{
  public String extra;
  public int nonce;
  public String packageName;
  public int responseCode;
  public long timestamp;
  public String userId;
  public String versionCode;
  
  public static ResponseData parse(String paramString)
  {
    int i = paramString.indexOf(':');
    Object localObject1;
    if (-1 == i)
    {
      localObject2 = "";
      localObject1 = paramString;
      paramString = (String)localObject2;
      localObject1 = TextUtils.split((String)localObject1, Pattern.quote("|"));
      if (localObject1.length < 6) {
        throw new IllegalArgumentException("Wrong number of fields.");
      }
    }
    else
    {
      localObject1 = paramString.substring(0, i);
      if (i >= paramString.length()) {}
      for (paramString = "";; paramString = paramString.substring(i + 1)) {
        break;
      }
    }
    Object localObject2 = new ResponseData();
    ((ResponseData)localObject2).extra = paramString;
    ((ResponseData)localObject2).responseCode = Integer.parseInt(localObject1[0]);
    ((ResponseData)localObject2).nonce = Integer.parseInt(localObject1[1]);
    ((ResponseData)localObject2).packageName = localObject1[2];
    ((ResponseData)localObject2).versionCode = localObject1[3];
    ((ResponseData)localObject2).userId = localObject1[4];
    ((ResponseData)localObject2).timestamp = Long.parseLong(localObject1[5]);
    return (ResponseData)localObject2;
  }
  
  public String toString()
  {
    return TextUtils.join("|", new Object[] { Integer.valueOf(this.responseCode), Integer.valueOf(this.nonce), this.packageName, this.versionCode, this.userId, Long.valueOf(this.timestamp) });
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/vending/licensing/ResponseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */