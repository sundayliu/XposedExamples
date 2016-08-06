package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class odexSystemApps
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    paramArrayOfString = paramArrayOfString[0];
    paramArrayOfString = new File("/system/app").listFiles();
    int k = paramArrayOfString.length;
    int i = 0;
    Object localObject1;
    int m;
    int j;
    if (i < k)
    {
      Object localObject2 = paramArrayOfString[i];
      if (listAppsFragment.api >= 21)
      {
        if (!((File)localObject2).isDirectory()) {
          break label1076;
        }
        localObject1 = ((File)localObject2).listFiles();
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label1076;
        }
        m = localObject1.length;
        j = 0;
        label83:
        if (j >= m) {
          break label1076;
        }
        File localFile1 = localObject1[j];
        if ((localFile1.isFile()) && (localFile1.getAbsolutePath().endsWith(".apk")))
        {
          localObject2 = new File(Utils.getOdexForCreate(localFile1.getAbsolutePath(), "0"));
          localFile1 = Utils.getFileDalvikCache(localFile1.getAbsolutePath());
          if ((!((File)localObject2).exists()) && (localFile1 != null) && (localFile1.exists())) {
            try
            {
              Utils.copyFile(localFile1, (File)localObject2);
              if (localFile1.length() != ((File)localObject2).length())
              {
                ((File)localObject2).delete();
                System.out.println("Not enought space!");
              }
              else
              {
                Utils.cmdParam(new String[] { "chmod", "644", ((File)localObject2).getAbsolutePath() });
                Utils.cmdParam(new String[] { "chown", "0.0", ((File)localObject2).getAbsolutePath() });
                Utils.cmdParam(new String[] { "chown", "0:0", ((File)localObject2).getAbsolutePath() });
                localFile1.delete();
              }
            }
            catch (Exception localException3)
            {
              ((File)localObject2).delete();
              System.out.println("IO Exception!");
              localException3.printStackTrace();
            }
          }
        }
      }
      else
      {
        if ((!((File)localObject2).isFile()) || (!((File)localObject2).getAbsolutePath().endsWith(".apk"))) {
          break label1076;
        }
        localObject1 = new File(Utils.getOdexForCreate(((File)localObject2).getAbsolutePath(), "0"));
        localObject2 = Utils.getFileDalvikCache(((File)localObject2).getAbsolutePath());
        if ((((File)localObject1).exists()) || (localObject2 == null) || (!((File)localObject2).exists())) {
          break label1076;
        }
        try
        {
          Utils.copyFile((File)localObject2, (File)localObject1);
          if (((File)localObject2).length() != ((File)localObject1).length())
          {
            ((File)localObject1).delete();
            System.out.println("Not enought space!");
          }
          else
          {
            Utils.cmdParam(new String[] { "chmod", "644", ((File)localObject1).getAbsolutePath() });
            Utils.cmdParam(new String[] { "chown", "0.0", ((File)localObject1).getAbsolutePath() });
            Utils.cmdParam(new String[] { "chown", "0:0", ((File)localObject1).getAbsolutePath() });
            ((File)localObject2).delete();
          }
        }
        catch (Exception localException1)
        {
          ((File)localObject1).delete();
          System.out.println("IO Exception!");
          localException1.printStackTrace();
        }
      }
    }
    else
    {
      paramArrayOfString = new File("/system/priv-app");
      if (paramArrayOfString.exists())
      {
        paramArrayOfString = paramArrayOfString.listFiles();
        k = paramArrayOfString.length;
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject3;
      if (i < k)
      {
        localObject3 = paramArrayOfString[i];
        if (listAppsFragment.api >= 21)
        {
          if (!((File)localObject3).isDirectory()) {
            break label1090;
          }
          localObject1 = ((File)localObject3).listFiles();
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1090;
          }
          m = localObject1.length;
          j = 0;
        }
      }
      for (;;)
      {
        if (j >= m) {
          break label1090;
        }
        File localFile2 = localObject1[j];
        if ((localFile2.isFile()) && (localFile2.getAbsolutePath().endsWith(".apk")))
        {
          localObject3 = new File(Utils.getOdexForCreate(localFile2.getAbsolutePath(), "0"));
          localFile2 = Utils.getFileDalvikCache(localFile2.getAbsolutePath());
          if ((!((File)localObject3).exists()) && (localFile2 != null) && (localFile2.exists()))
          {
            try
            {
              Utils.copyFile(localFile2, (File)localObject3);
              if (localFile2.length() != ((File)localObject3).length())
              {
                ((File)localObject3).delete();
                System.out.println("Not enought space!");
              }
              else
              {
                Utils.cmdParam(new String[] { "chmod", "644", ((File)localObject3).getAbsolutePath() });
                Utils.cmdParam(new String[] { "chown", "0.0", ((File)localObject3).getAbsolutePath() });
                Utils.cmdParam(new String[] { "chown", "0:0", ((File)localObject3).getAbsolutePath() });
                localFile2.delete();
              }
            }
            catch (Exception localException4)
            {
              ((File)localObject3).delete();
              System.out.println("IO Exception!");
              localException4.printStackTrace();
            }
            if ((!((File)localObject3).isFile()) || (!((File)localObject3).getAbsolutePath().endsWith(".apk"))) {
              break label1090;
            }
            localObject1 = new File(Utils.getOdexForCreate(((File)localObject3).getAbsolutePath(), "0"));
            localObject3 = Utils.getFileDalvikCache(((File)localObject3).getAbsolutePath());
            if ((((File)localObject1).exists()) || (localObject3 == null) || (!((File)localObject3).exists())) {
              break label1090;
            }
            try
            {
              Utils.copyFile((File)localObject3, (File)localObject1);
              if (((File)localObject3).length() != ((File)localObject1).length())
              {
                ((File)localObject1).delete();
                System.out.println("Not enought space!");
              }
              else
              {
                Utils.cmdParam(new String[] { "chmod", "644", ((File)localObject1).getAbsolutePath() });
                Utils.cmdParam(new String[] { "chown", "0.0", ((File)localObject1).getAbsolutePath() });
                Utils.cmdParam(new String[] { "chown", "0:0", ((File)localObject1).getAbsolutePath() });
                ((File)localObject3).delete();
              }
            }
            catch (Exception localException2)
            {
              ((File)localObject1).delete();
              System.out.println("IO Exception!");
              localException2.printStackTrace();
            }
            Utils.exitFromRootJava();
            return;
            j += 1;
            break label83;
            label1076:
            i += 1;
            break;
          }
        }
        j += 1;
      }
      label1090:
      i += 1;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/odexSystemApps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */