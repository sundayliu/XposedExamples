package com.mba.proxylight;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Request
{
  private static Pattern CONNECT_PATTERN = Pattern.compile("(.*):([\\d]+)");
  private static Pattern GETPOST_PATTERN = Pattern.compile("(https?)://([^:/]+)(:[\\d]+])?/.*");
  private Map<String, String> headers = new LinkedHashMap();
  private String host = null;
  private String method = null;
  private int port = -1;
  private String protocol = null;
  private String statusline = null;
  private String url = null;
  
  public void addHeader(String paramString)
  {
    int i = 1;
    while ((paramString.charAt(i) != ':') && (paramString.charAt(i) != ' ')) {
      i += 1;
    }
    String str = paramString.substring(0, i);
    int j;
    do
    {
      do
      {
        j = i + 1;
        i = j;
      } while (paramString.charAt(j) == ':');
      i = j;
    } while (paramString.charAt(j) == ' ');
    paramString = paramString.substring(j);
    this.headers.put(str, paramString);
  }
  
  public void dump() {}
  
  public Map<String, String> getHeaders()
  {
    return this.headers;
  }
  
  public String getHost()
  {
    if (this.host != null) {
      return this.host;
    }
    Matcher localMatcher;
    if (getUrl() != null)
    {
      if (!"CONNECT".equals(this.method)) {
        break label145;
      }
      localMatcher = CONNECT_PATTERN.matcher(getUrl());
      if (localMatcher.matches())
      {
        this.host = localMatcher.group(1);
        this.port = Integer.parseInt(localMatcher.group(2));
      }
      if (this.host == null)
      {
        this.host = ((String)getHeaders().get("Host"));
        int i = this.host.indexOf(':');
        if (i <= -1) {
          break label228;
        }
        this.port = Integer.parseInt(this.host.substring(i + 1));
        this.host = this.host.substring(0, i);
      }
    }
    for (;;)
    {
      return this.host;
      label145:
      localMatcher = GETPOST_PATTERN.matcher(getUrl());
      if (!localMatcher.matches()) {
        break;
      }
      this.host = localMatcher.group(2);
      if (localMatcher.group(3) != null)
      {
        Integer.parseInt(localMatcher.group(3).substring(1));
        break;
      }
      if ("http".equals(localMatcher.group(1)))
      {
        this.port = 80;
        break;
      }
      this.port = 443;
      break;
      label228:
      this.port = 80;
    }
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public int getPort()
  {
    getHost();
    return this.port;
  }
  
  public String getProtocol()
  {
    return this.protocol;
  }
  
  public String getStatusline()
  {
    return this.statusline;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
  
  public void setProtocol(String paramString)
  {
    this.protocol = paramString;
  }
  
  public void setStatusline(String paramString)
  {
    this.statusline = paramString;
    int i = paramString.indexOf(' ');
    if ((i == -1) || (i < 3)) {
      throw new IllegalArgumentException("statusline: " + paramString);
    }
    this.method = paramString.substring(0, i);
    int j;
    do
    {
      j = i + 1;
      i = j;
    } while (paramString.charAt(j) == ' ');
    i = paramString.indexOf(' ', j);
    if (i == -1) {
      throw new IllegalArgumentException("statusline: " + paramString);
    }
    this.url = paramString.substring(j, i);
    do
    {
      j = i + 1;
      i = j;
    } while (paramString.charAt(j) == ' ');
    this.protocol = paramString.substring(j);
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/mba/proxylight/Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */