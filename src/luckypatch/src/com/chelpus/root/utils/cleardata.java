package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class cleardata
{
  public static void main(String[] paramArrayOfString)
  {
    int j = 0;
    Utils.startRootJava(new Object() {});
    Utils localUtils = new Utils("clear data");
    String str1 = paramArrayOfString[1];
    try
    {
      localObject = new File(paramArrayOfString[0]);
      if (((File)localObject).exists())
      {
        arrayOfString = ((File)localObject).list();
        k = arrayOfString.length;
        i = 0;
        while (i < k)
        {
          str2 = arrayOfString[i];
          if ((!str2.equals("lib")) || (str1.contains("system"))) {
            localUtils.deleteFolder(new File((File)localObject, str2));
          }
          i += 1;
        }
      }
      System.out.println("ok");
      localObject = new File(paramArrayOfString[0].replace("/data/data/", "/dbdata/databases/"));
      if (!((File)localObject).exists()) {
        break label213;
      }
      arrayOfString = ((File)localObject).list();
      k = arrayOfString.length;
      i = 0;
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        Object localObject;
        String[] arrayOfString;
        int k;
        int i;
        String str2;
        label213:
        System.out.println("Exception e" + paramArrayOfString.toString());
        continue;
        i += 1;
        continue;
        i += 1;
      }
    }
    if (i < k)
    {
      str2 = arrayOfString[i];
      if ((!str2.equals("lib")) || (str1.contains("system"))) {
        localUtils.deleteFolder(new File((File)localObject, str2));
      }
    }
    else
    {
      System.out.println("ok");
      paramArrayOfString = new File(paramArrayOfString[0].replace("/data/data/", "/dbdata/data/"));
      if (paramArrayOfString.exists())
      {
        localObject = paramArrayOfString.list();
        k = localObject.length;
        i = j;
        if (i < k)
        {
          arrayOfString = localObject[i];
          if ((arrayOfString.equals("lib")) && (!str1.contains("system"))) {
            break label373;
          }
          localUtils.deleteFolder(new File(paramArrayOfString, arrayOfString));
          break label373;
        }
      }
      System.out.println("ok");
      if (str1.contains("system")) {
        paramArrayOfString.delete();
      }
      Utils.exitFromRootJava();
      return;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/cleardata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */