package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class clearDalvikCache
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    listAppsFragment.toolfilesdir = paramArrayOfString[0];
    if (new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").exists())
    {
      new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").delete();
      if (!new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").exists()) {
        break label128;
      }
      System.out.println("LuckyPatcher: (error) try delete ClearDalvik.on - fault!");
    }
    label128:
    int k;
    int i;
    Object localObject1;
    int m;
    int j;
    Object localObject2;
    for (;;)
    {
      Utils.exitFromRootJava();
      return;
      try
      {
        paramArrayOfString = new File("/mnt/asec").listFiles();
        k = paramArrayOfString.length;
        i = 0;
        while (i < k)
        {
          localObject1 = paramArrayOfString[i];
          if (((File)localObject1).isDirectory())
          {
            localObject1 = ((File)localObject1).listFiles();
            m = localObject1.length;
            j = 0;
            while (j < m)
            {
              localObject2 = localObject1[j];
              if (((File)localObject2).getAbsoluteFile().toString().endsWith(".odex"))
              {
                Utils.remount(((File)localObject2).getAbsolutePath(), "rw");
                ((File)localObject2).delete();
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
      catch (Exception paramArrayOfString)
      {
        if (listAppsFragment.api >= 23) {
          try
          {
            if (new File("/data/app").exists())
            {
              paramArrayOfString = new File("/data/app").listFiles();
              k = paramArrayOfString.length;
              i = 0;
              while (i < k)
              {
                localObject1 = paramArrayOfString[i];
                if (((File)localObject1).isDirectory())
                {
                  localObject1 = ((File)localObject1).listFiles();
                  if ((localObject1 != null) && (localObject1.length > 0))
                  {
                    m = localObject1.length;
                    j = 0;
                    while (j < m)
                    {
                      localObject2 = localObject1[j];
                      if ((((File)localObject2).isDirectory()) && (((File)localObject2).getName().equals("oat")))
                      {
                        System.out.println("delete folder:" + ((File)localObject2).getAbsolutePath());
                        new Utils("").deleteFolder((File)localObject2);
                      }
                      j += 1;
                    }
                  }
                }
                i += 1;
              }
            }
            try
            {
              if (new File("/data/dalvik-cache").exists())
              {
                paramArrayOfString = new File("/data/dalvik-cache").listFiles();
                k = paramArrayOfString.length;
                i = 0;
                while (i < k)
                {
                  localObject1 = paramArrayOfString[i];
                  if (((File)localObject1).isDirectory())
                  {
                    localObject2 = ((File)localObject1).listFiles();
                    if ((localObject2 != null) && (localObject2.length > 0))
                    {
                      m = localObject2.length;
                      j = 0;
                      if (j < m)
                      {
                        localObject3 = localObject2[j];
                        if (!((File)localObject3).isFile()) {
                          break label1083;
                        }
                        ((File)localObject3).delete();
                        break label1083;
                      }
                    }
                  }
                  if (((File)localObject1).isFile()) {
                    ((File)localObject1).delete();
                  }
                  i += 1;
                }
              }
            }
            catch (Exception paramArrayOfString)
            {
              try
              {
                if (new File("/cache/dalvik-cache").exists())
                {
                  paramArrayOfString = new File("/cache/dalvik-cache").list();
                  j = paramArrayOfString.length;
                  i = 0;
                  while (i < j)
                  {
                    localObject1 = paramArrayOfString[i];
                    new File("/cache/dalvik-cache/" + (String)localObject1).delete();
                    i += 1;
                  }
                }
              }
              catch (Exception paramArrayOfString)
              {
                try
                {
                  if (new File("/sd-ext/data/dalvik-cache").exists())
                  {
                    paramArrayOfString = new File("/sd-ext/data/dalvik-cache").list();
                    j = paramArrayOfString.length;
                    i = 0;
                    while (i < j)
                    {
                      localObject1 = paramArrayOfString[i];
                      new File("/sd-ext/data/dalvik-cache/" + (String)localObject1).delete();
                      i += 1;
                    }
                  }
                }
                catch (Exception paramArrayOfString)
                {
                  try
                  {
                    if (new File("/sd-ext/data/cache/dalvik-cache").exists())
                    {
                      paramArrayOfString = new File("/sd-ext/data/cache/dalvik-cache").list();
                      j = paramArrayOfString.length;
                      i = 0;
                      while (i < j)
                      {
                        localObject1 = paramArrayOfString[i];
                        new File("/sd-ext/data/cache/dalvik-cache/" + (String)localObject1).delete();
                        i += 1;
                      }
                    }
                  }
                  catch (Exception paramArrayOfString)
                  {
                    try
                    {
                      if (new File("/data/app").exists())
                      {
                        paramArrayOfString = new File("/data/app").list();
                        j = paramArrayOfString.length;
                        i = 0;
                        while (i < j)
                        {
                          localObject1 = paramArrayOfString[i];
                          if (((String)localObject1).endsWith(".odex")) {
                            new File("/data/app/" + (String)localObject1).delete();
                          }
                          i += 1;
                        }
                      }
                      try
                      {
                        Utils.remount("/system", "rw");
                        paramArrayOfString = new File("/system/app").listFiles();
                        j = paramArrayOfString.length;
                        i = 0;
                        if (i < j)
                        {
                          localObject1 = paramArrayOfString[i];
                          localObject2 = new File(Utils.getPlaceForOdex(((File)localObject1).getAbsolutePath(), true));
                          if ((((File)localObject2).exists()) && (((File)localObject1).getAbsoluteFile().toString().endsWith(".apk")) && (Utils.classes_test((File)localObject1))) {
                            ((File)localObject2).delete();
                          }
                        }
                        else
                        {
                          paramArrayOfString = new File("/system/priv-app").listFiles();
                          j = paramArrayOfString.length;
                          i = 0;
                          if (i < j)
                          {
                            localObject1 = paramArrayOfString[i];
                            localObject2 = new File(Utils.getPlaceForOdex(((File)localObject1).getAbsolutePath(), true));
                            if ((!((File)localObject2).exists()) || (!((File)localObject1).getAbsoluteFile().toString().endsWith(".apk")) || (!Utils.classes_test((File)localObject1))) {
                              break label1097;
                            }
                            ((File)localObject2).delete();
                            break label1097;
                          }
                          System.out.println("LuckyPatcher: System apps deodex all.");
                        }
                      }
                      catch (Exception paramArrayOfString) {}
                    }
                    catch (Exception paramArrayOfString)
                    {
                      System.out.println("LuckyPatcher: Dalvik-Cache deleted.");
                    }
                  }
                }
              }
            }
          }
          catch (Exception paramArrayOfString) {}
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      break;
      label1083:
      j += 1;
      continue;
      i += 1;
      continue;
      label1097:
      i += 1;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/clearDalvikCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */