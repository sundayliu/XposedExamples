package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class copyLibsFilesToSystemBackup
{
  public static String index;
  public static String libDir = "";
  public static boolean nospace = false;
  public static String pkgName = "";
  public static String sys_apk_dir;
  
  static
  {
    index = "";
    sys_apk_dir = "";
  }
  
  public static ArrayList<String> getLibs(File paramFile, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int m;
    int i;
    Object localObject1;
    int j;
    Object localObject2;
    int k;
    File localFile;
    if (!paramString.startsWith("/mnt/"))
    {
      if (listAppsFragment.api >= 21)
      {
        paramFile = Utils.getDirs(new File(paramString));
        if (paramFile.exists())
        {
          paramString = paramFile.listFiles();
          m = paramString.length;
          i = 0;
          while (i < m)
          {
            localObject1 = paramString[i];
            System.out.println("LuckyPatcher: file found in data dir - " + localObject1 + " is dir:" + ((File)localObject1).isDirectory());
            if ((((File)localObject1).isDirectory()) && (((File)localObject1).getAbsolutePath().equals(paramFile + "/" + "lib")))
            {
              localObject1 = ((File)localObject1).listFiles();
              if ((localObject1 != null) && (localObject1.length > 0))
              {
                int n = localObject1.length;
                j = 0;
                while (j < n)
                {
                  localObject2 = localObject1[j].listFiles();
                  if ((localObject2 != null) && (localObject2.length > 0))
                  {
                    int i1 = localObject2.length;
                    k = 0;
                    while (k < i1)
                    {
                      localFile = localObject2[k];
                      localArrayList.add(localFile.getAbsolutePath());
                      index = Utils.getDirs(localFile).getAbsolutePath().replace(paramFile.getAbsolutePath(), "");
                      libDir = sys_apk_dir + index + "/";
                      System.out.println("libdir" + libDir);
                      new File(libDir).mkdirs();
                      System.out.println("LuckyPatcher: found lib - " + localFile.getAbsolutePath());
                      k += 1;
                    }
                  }
                  j += 1;
                }
              }
            }
            i += 1;
          }
        }
      }
      else if (paramFile.exists())
      {
        paramString = paramFile.list();
        k = paramString.length;
        i = 0;
        while (i < k)
        {
          localObject1 = paramString[i];
          System.out.println("LuckyPatcher: file found in data dir - " + paramFile + "/" + (String)localObject1 + "id dir:" + new File(new StringBuilder().append(paramFile).append("/").append((String)localObject1).toString()).isDirectory());
          if ((new File(paramFile + "/" + (String)localObject1).isDirectory()) && ((paramFile + "/" + (String)localObject1).equals(paramFile + "/" + "lib")))
          {
            localObject2 = new File(paramFile + "/" + (String)localObject1).list();
            m = localObject2.length;
            j = 0;
            while (j < m)
            {
              localFile = localObject2[j];
              if ((new File(paramFile + "/" + (String)localObject1 + "/" + localFile).isFile()) && (!localFile.contains("libjnigraphics.so")))
              {
                localArrayList.add(paramFile + "/" + (String)localObject1 + "/" + localFile);
                System.out.println("LuckyPatcher: found lib - " + paramFile + "/" + (String)localObject1 + "/" + localFile + " is dir:" + new File(new StringBuilder().append(paramFile).append("/").append((String)localObject1).toString()).isDirectory());
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
    else
    {
      paramFile = Utils.getDirs(new File(paramString));
      Utils.remount(paramFile.getAbsolutePath(), "rw");
      if (paramFile.exists())
      {
        paramString = paramFile.list();
        k = paramString.length;
        i = 0;
        while (i < k)
        {
          localObject1 = paramString[i];
          System.out.println("LuckyPatcher: file found in data dir - " + paramFile + "/" + (String)localObject1);
          if ((new File(paramFile + "/" + (String)localObject1).isDirectory()) && ((paramFile + "/" + (String)localObject1).equals(paramFile + "/" + "lib")))
          {
            localObject2 = new File(paramFile + "/" + (String)localObject1).list();
            m = localObject2.length;
            j = 0;
            while (j < m)
            {
              localFile = localObject2[j];
              if ((new File(paramFile + "/" + (String)localObject1 + "/" + localFile).isFile()) && (!localFile.contains("libjnigraphics.so")))
              {
                localArrayList.add(paramFile + "/" + (String)localObject1 + "/" + localFile);
                System.out.println("LuckyPatcher: found lib - " + paramFile + "/" + (String)localObject1 + "/" + localFile);
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    pkgName = paramArrayOfString[0];
    Object localObject1 = paramArrayOfString[1];
    String str = paramArrayOfString[2];
    sys_apk_dir = Utils.getDirs(new File(paramArrayOfString[3])).getAbsolutePath();
    paramArrayOfString = paramArrayOfString[4];
    Object localObject2;
    if (paramArrayOfString.equals("copyLibs"))
    {
      System.out.println("copyLibs");
      libDir = "/system/lib/";
      localObject2 = getLibs(new File((String)localObject1), str);
      if (((ArrayList)localObject2).size() > 0)
      {
        Object localObject3 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          File localFile = new File((String)((Iterator)localObject3).next());
          if (!new File(libDir).exists()) {
            new File(libDir).mkdirs();
          }
          Utils.setPermissionDir(sys_apk_dir, sys_apk_dir + index, "755");
          Utils.copyFile(localFile, new File(libDir + localFile.getName() + ".chelpus"));
          run_all("chmod 0644 " + libDir + localFile.getName() + ".chelpus");
          run_all("chown 0.0 " + libDir + localFile.getName() + ".chelpus");
          run_all("chown 0:0 " + libDir + localFile.getName() + ".chelpus");
          if (localFile.length() == new File(libDir + localFile.getName() + ".chelpus").length())
          {
            System.out.println("LuckyPatcher: copy lib " + libDir + localFile.getName() + ".chelpus");
          }
          else
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = new File((String)((Iterator)localObject2).next());
              if (listAppsFragment.api < 21) {
                new File(libDir + ((File)localObject3).getName() + ".chelpus").delete();
              } else if (libDir.startsWith("/system/priv-app/")) {
                try
                {
                  new Utils("").deleteFolder(new File(libDir));
                }
                catch (IOException localIOException)
                {
                  localIOException.printStackTrace();
                }
              }
            }
            System.out.println("In /system space not found!");
            nospace = true;
          }
        }
      }
    }
    if (paramArrayOfString.equals("replaceOldLibs"))
    {
      System.out.println("replaceOldLibs");
      libDir = "/system/lib/";
      if (listAppsFragment.api >= 21)
      {
        if (new File(sys_apk_dir + "/lib/x86").exists()) {
          libDir = sys_apk_dir + "/lib/x86/";
        }
        if (new File(sys_apk_dir + "/lib/x86_64").exists()) {
          libDir = sys_apk_dir + "/lib/x86_64/";
        }
        if (new File(sys_apk_dir + "/lib/arm").exists()) {
          libDir = sys_apk_dir + "/lib/arm/";
        }
        if (new File(sys_apk_dir + "/lib/arm64").exists()) {
          libDir = sys_apk_dir + "/lib/arm64/";
        }
        if (new File(sys_apk_dir + "/lib/mips").exists()) {
          libDir = sys_apk_dir + "/lib/mips/";
        }
      }
      new ArrayList();
      localObject2 = new File(libDir).listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          Object localObject4 = localObject2[i];
          if ((((File)localObject4).isFile()) && (((File)localObject4).getName().endsWith(".chelpus")))
          {
            System.out.println("Replace system lib:" + ((File)localObject4).getAbsolutePath().replace(".chelpus", ""));
            new File(((File)localObject4).getAbsolutePath().replace(".chelpus", "")).delete();
            ((File)localObject4).renameTo(new File(((File)localObject4).getAbsolutePath().replace(".chelpus", "")));
          }
          i += 1;
        }
      }
      removeLibs(new File((String)localObject1), str);
    }
    if (paramArrayOfString.equals("deleteBigLibs"))
    {
      System.out.println("deleteBigLibs");
      libDir = "/system/lib/";
      paramArrayOfString = getLibs(new File((String)localObject1), str);
      if (paramArrayOfString.size() > 0)
      {
        paramArrayOfString = paramArrayOfString.iterator();
        while (paramArrayOfString.hasNext())
        {
          localObject1 = new File((String)paramArrayOfString.next());
          new File(libDir + ((File)localObject1).getName() + ".chelpus").delete();
        }
      }
    }
    Utils.exitFromRootJava();
  }
  
  public static void removeLibs(File paramFile, String paramString)
  {
    int i = 0;
    String str1;
    int j;
    if (listAppsFragment.api < 21)
    {
      if (!paramString.startsWith("/mnt/"))
      {
        System.out.println("remove libs in data");
        if (paramFile.exists())
        {
          paramString = paramFile.list();
          int k = paramString.length;
          i = 0;
          if (i < k)
          {
            str1 = paramString[i];
            System.out.println("LuckyPatcher: file found in data dir - " + paramFile + "/" + str1);
            if ((new File(paramFile + "/" + str1).isDirectory()) && ((paramFile + "/" + str1).equals(paramFile + "/" + "lib")))
            {
              String[] arrayOfString = new File(paramFile + "/" + str1).list();
              if ((arrayOfString != null) && (arrayOfString.length > 0))
              {
                int m = arrayOfString.length;
                j = 0;
                while (j < m)
                {
                  String str2 = arrayOfString[j];
                  if (new File(paramFile + "/" + str1 + "/" + str2).isFile())
                  {
                    new File(paramFile + "/" + str1 + "/" + str2).delete();
                    System.out.println("LuckyPatcher: remove lib - " + paramFile + "/" + str1 + "/" + str2);
                  }
                  j += 1;
                }
              }
              System.out.println("delete dir" + paramFile + "/" + str1);
              new File(paramFile + "/" + str1).delete();
            }
            for (;;)
            {
              i += 1;
              break;
              System.out.println("file not dir lib" + paramFile + "/" + str1 + " is File:" + new File(new StringBuilder().append(paramFile).append("/").append(str1).toString()).isFile());
              if ((paramFile + "/" + str1).equals(paramFile + "/" + "lib"))
              {
                System.out.println("delete file" + paramFile + "/" + str1);
                new File(paramFile + "/" + str1).delete();
              }
            }
          }
        }
      }
    }
    else
    {
      System.out.println("remove libs in data for api 21");
      paramFile = Utils.getDirs(new File(paramString));
      if (Utils.getDirs(new File(paramString)).exists())
      {
        paramString = paramFile.listFiles();
        j = paramString.length;
        for (;;)
        {
          if (i < j)
          {
            str1 = paramString[i];
            System.out.println("LuckyPatcher: file found in data dir - " + paramFile + "/" + str1);
            if ((str1.isDirectory()) && (str1.getAbsolutePath().endsWith("/lib"))) {}
            try
            {
              new Utils("").deleteFolder(str1);
              i += 1;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                localIOException.printStackTrace();
              }
            }
          }
        }
      }
    }
  }
  
  private static void run_all(String paramString)
  {
    try
    {
      Process localProcess = Runtime.getRuntime().exec(paramString + "\n");
      localProcess.waitFor();
      localProcess.destroy();
      try
      {
        localProcess = Runtime.getRuntime().exec("toolbox " + paramString + "\n");
        localProcess.waitFor();
        localProcess.destroy();
        try
        {
          localProcess = Runtime.getRuntime().exec("/system/bin/failsafe/toolbox " + paramString + "\n");
          localProcess.waitFor();
          localProcess.destroy();
          try
          {
            localProcess = Runtime.getRuntime().exec("busybox " + paramString + "\n");
            localProcess.waitFor();
            localProcess.destroy();
            try
            {
              paramString = Runtime.getRuntime().exec(listAppsFragment.toolfilesdir + "/busybox " + paramString + "\n");
              paramString.waitFor();
              paramString.destroy();
              return;
            }
            catch (Exception paramString) {}
          }
          catch (Exception localException1)
          {
            for (;;) {}
          }
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
    }
    catch (Exception localException4)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/copyLibsFilesToSystemBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */