package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class move_to_system
{
  public static String datadir;
  public static String dirapp = "/data/app/";
  public static String index = "";
  public static String libDir;
  public static String pkgName;
  public static String toolsfiles;
  
  static
  {
    datadir = "/data/data/";
    toolsfiles = "";
    pkgName = "";
    libDir = "";
  }
  
  public static ArrayList<String> getLibs(File paramFile, String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k;
    Object localObject1;
    int i;
    Object localObject2;
    int j;
    File localFile;
    if (!paramString.startsWith("/mnt/"))
    {
      if (paramInt >= 21)
      {
        paramFile = Utils.getDirs(new File(paramString));
        if (paramFile.exists())
        {
          paramString = paramFile.listFiles();
          k = paramString.length;
          paramInt = 0;
          while (paramInt < k)
          {
            localObject1 = paramString[paramInt];
            System.out.println("LuckyPatcher: file found in data dir - " + localObject1);
            if ((((File)localObject1).isDirectory()) && (((File)localObject1).getAbsolutePath().equals(paramFile + "/" + "lib")))
            {
              localObject1 = ((File)localObject1).listFiles();
              if ((localObject1 != null) && (localObject1.length > 0))
              {
                int m = localObject1.length;
                i = 0;
                while (i < m)
                {
                  localObject2 = localObject1[i].listFiles();
                  if ((localObject2 != null) && (localObject2.length > 0))
                  {
                    int n = localObject2.length;
                    j = 0;
                    while (j < n)
                    {
                      localFile = localObject2[j];
                      localArrayList.add(localFile.getAbsolutePath());
                      index = Utils.getDirs(localFile).getAbsolutePath().replace(paramFile.getAbsolutePath(), "");
                      libDir = "/system/priv-app/" + pkgName + index + "/";
                      System.out.println("libdir" + libDir);
                      new File(libDir).mkdirs();
                      System.out.println("LuckyPatcher: found lib - " + localFile.getAbsolutePath());
                      j += 1;
                    }
                  }
                  i += 1;
                }
              }
            }
            paramInt += 1;
          }
        }
      }
      else if (paramFile.exists())
      {
        paramString = paramFile.list();
        j = paramString.length;
        paramInt = 0;
        while (paramInt < j)
        {
          localObject1 = paramString[paramInt];
          System.out.println("LuckyPatcher: file found in data dir - " + paramFile + "/" + (String)localObject1);
          if ((new File(paramFile + "/" + (String)localObject1).isDirectory()) && ((paramFile + "/" + (String)localObject1).equals(paramFile + "/" + "lib")))
          {
            localObject2 = new File(paramFile + "/" + (String)localObject1).list();
            k = localObject2.length;
            i = 0;
            while (i < k)
            {
              localFile = localObject2[i];
              if ((new File(paramFile + "/" + (String)localObject1 + "/" + localFile).isFile()) && (!localFile.contains("libjnigraphics.so")))
              {
                localArrayList.add(paramFile + "/" + (String)localObject1 + "/" + localFile);
                System.out.println("LuckyPatcher: found lib - " + paramFile + "/" + (String)localObject1 + "/" + localFile);
              }
              i += 1;
            }
          }
          paramInt += 1;
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
        j = paramString.length;
        paramInt = 0;
        while (paramInt < j)
        {
          localObject1 = paramString[paramInt];
          System.out.println("LuckyPatcher: file found in data dir - " + paramFile + "/" + (String)localObject1);
          if ((new File(paramFile + "/" + (String)localObject1).isDirectory()) && ((paramFile + "/" + (String)localObject1).equals(paramFile + "/" + "lib")))
          {
            localObject2 = new File(paramFile + "/" + (String)localObject1).list();
            k = localObject2.length;
            i = 0;
            while (i < k)
            {
              localFile = localObject2[i];
              if ((new File(paramFile + "/" + (String)localObject1 + "/" + localFile).isFile()) && (!localFile.contains("libjnigraphics.so")))
              {
                localArrayList.add(paramFile + "/" + (String)localObject1 + "/" + localFile);
                System.out.println("LuckyPatcher: found lib - " + paramFile + "/" + (String)localObject1 + "/" + localFile);
              }
              i += 1;
            }
          }
          paramInt += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    int j = 0;
    localObject3 = "/system/app/";
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        if (new File("/system/priv-app").exists())
        {
          localObject1 = localObject3;
          if (new File("/system/priv-app").list() != null) {
            localObject1 = "/system/priv-app/";
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        Object localObject2 = localObject3;
        continue;
        Object localObject4 = paramArrayOfString.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          continue;
        }
        Object localObject5 = new File((String)((Iterator)localObject4).next());
        if (listAppsFragment.api >= 21) {
          continue;
        }
        new File(libDir + ((File)localObject5).getName()).delete();
        continue;
        if (!libDir.startsWith("/system/priv-app/")) {
          continue;
        }
        new Utils("").deleteFolder(new File(libDir));
        continue;
        System.out.println("In /system space not found!");
        int i = 1;
        if (i != 0) {
          continue;
        }
        try
        {
          if (new File((String)localObject2 + pkgName + ".odex").exists()) {
            new File((String)localObject2 + pkgName + ".odex").delete();
          }
          localObject4 = (String)localObject2 + pkgName + ".apk";
          localObject5 = dirapp;
          Utils.cmdParam(new String[] { "dd", "if=" + (String)localObject5, "of=" + (String)localObject4 });
          if ((!new File((String)localObject4).exists()) || (((File)localObject3).length() != new File((String)localObject2 + pkgName + ".apk").length())) {
            Utils.cmdParam(new String[] { "toolbox", "dd", "if=" + (String)localObject5, "of=" + (String)localObject4 });
          }
          if ((!new File((String)localObject4).exists()) || (((File)localObject3).length() != new File((String)localObject2 + pkgName + ".apk").length())) {
            Utils.cmdParam(new String[] { "busybox", "dd", "if=" + (String)localObject5, "of=" + (String)localObject4 });
          }
          if ((!new File((String)localObject4).exists()) || (((File)localObject3).length() != new File((String)localObject2 + pkgName + ".apk").length())) {
            Utils.cmdParam(new String[] { toolsfiles + "/busybox", "dd", "if=" + (String)localObject5, "of=" + (String)localObject4 });
          }
          if ((!new File((String)localObject4).exists()) || (((File)localObject3).length() != new File((String)localObject2 + pkgName + ".apk").length())) {
            Utils.cmdParam(new String[] { toolsfiles + "/busybox", "cp", "-fp", localObject5, localObject4 });
          }
          if ((!new File((String)localObject4).exists()) || (((File)localObject3).length() != new File((String)localObject2 + pkgName + ".apk").length())) {
            Utils.copyFile((File)localObject3, new File((String)localObject2 + pkgName + ".apk"));
          }
          if (((File)localObject3).length() == new File((String)localObject2 + pkgName + ".apk").length()) {
            if (!dirapp.startsWith("/mnt/")) {
              ((File)localObject3).delete();
            }
          }
        }
        catch (Exception localException2)
        {
          try
          {
            removeLibs(new File(datadir), dirapp, listAppsFragment.api);
            run_all("chmod 0644 " + (String)localObject2 + pkgName + ".apk");
            run_all("chown 0.0 " + (String)localObject2 + pkgName + ".apk");
            run_all("chown 0:0 " + (String)localObject2 + pkgName + ".apk");
            continue;
            localException2 = localException2;
            System.out.println("In /system space not found!");
            new File((String)localObject2 + pkgName + ".apk").delete();
            localException2.printStackTrace();
          }
          catch (Exception paramArrayOfString)
          {
            paramArrayOfString.printStackTrace();
            continue;
          }
          Utils.cmdParam(new String[] { "pm", "uninstall", pkgName });
          continue;
          new File((String)localObject2 + pkgName + ".apk").delete();
          System.out.println("In /system space not found!");
          paramArrayOfString = paramArrayOfString.iterator();
        }
        if (!paramArrayOfString.hasNext()) {
          continue;
        }
        localObject2 = new File((String)paramArrayOfString.next());
        new File(libDir + ((File)localObject2).getName()).delete();
        continue;
        new File((String)localObject2 + pkgName + ".apk").delete();
        continue;
      }
      try
      {
        Utils.startRootJava(new Object() {});
        dirapp = paramArrayOfString[1];
        datadir = paramArrayOfString[2];
        toolsfiles = paramArrayOfString[3];
        pkgName = paramArrayOfString[0];
        localObject3 = new File(dirapp);
        if (listAppsFragment.api >= 21)
        {
          paramArrayOfString = "/system/priv-app/" + pkgName + "/";
          localObject1 = paramArrayOfString;
          if (!new File(paramArrayOfString).exists())
          {
            new File(paramArrayOfString).mkdirs();
            Utils.cmdParam(new String[] { "chmod", "755", "/system/priv-app/" + pkgName });
            localObject1 = paramArrayOfString;
          }
        }
        libDir = "/system/lib/";
        paramArrayOfString = getLibs(new File(datadir), dirapp, listAppsFragment.api);
        i = j;
        if (paramArrayOfString.size() <= 0) {
          continue;
        }
        localObject4 = paramArrayOfString.iterator();
        i = j;
        if (!((Iterator)localObject4).hasNext()) {
          continue;
        }
        localObject5 = new File((String)((Iterator)localObject4).next());
        if (!new File(libDir).exists()) {
          new File(libDir).mkdirs();
        }
        Utils.setPermissionDir("/system/priv-app/" + pkgName, "/system/priv-app/" + pkgName + index, "755");
        Utils.copyFile((File)localObject5, new File(libDir + ((File)localObject5).getName()));
        run_all("chmod 0644 " + libDir + ((File)localObject5).getName());
        run_all("chown 0.0 " + libDir + ((File)localObject5).getName());
        run_all("chown 0:0 " + libDir + ((File)localObject5).getName());
        if (((File)localObject5).length() != new File(libDir + ((File)localObject5).getName()).length()) {
          continue;
        }
        System.out.println("LuckyPatcher: copy lib " + libDir + ((File)localObject5).getName());
        continue;
        Utils.exitFromRootJava();
      }
      catch (Exception paramArrayOfString)
      {
        System.out.println("LuckyPatcher Error move to System: " + paramArrayOfString);
        paramArrayOfString.printStackTrace();
      }
    }
  }
  
  public static void removeLibs(File paramFile, String paramString, int paramInt)
  {
    int i = 0;
    int j;
    String str1;
    if (paramInt < 21)
    {
      if ((!paramString.startsWith("/mnt/")) && (paramFile.exists()))
      {
        paramString = paramFile.list();
        j = paramString.length;
        paramInt = 0;
        while (paramInt < j)
        {
          str1 = paramString[paramInt];
          System.out.println("LuckyPatcher: file found in data dir - " + paramFile + "/" + str1);
          if ((new File(paramFile + "/" + str1).isDirectory()) && ((paramFile + "/" + str1).equals(paramFile + "/" + "lib")))
          {
            String[] arrayOfString = new File(paramFile + "/" + str1).list();
            if ((arrayOfString != null) && (arrayOfString.length > 0))
            {
              int k = arrayOfString.length;
              i = 0;
              while (i < k)
              {
                String str2 = arrayOfString[i];
                if (new File(paramFile + "/" + str1 + "/" + str2).isFile())
                {
                  new File(paramFile + "/" + str1 + "/" + str2).delete();
                  System.out.println("LuckyPatcher: remove lib - " + paramFile + "/" + str1 + "/" + str2);
                }
                i += 1;
              }
            }
            new File(paramFile + "/" + str1).delete();
          }
          paramInt += 1;
        }
      }
    }
    else
    {
      paramFile = Utils.getDirs(new File(paramString));
      if (Utils.getDirs(new File(paramString)).exists())
      {
        paramString = paramFile.listFiles();
        j = paramString.length;
        paramInt = i;
        for (;;)
        {
          if (paramInt < j)
          {
            str1 = paramString[paramInt];
            System.out.println("LuckyPatcher: file found in data dir - " + paramFile + "/" + str1);
            if ((str1.isDirectory()) && (str1.getAbsolutePath().endsWith("/lib"))) {}
            try
            {
              new Utils("").deleteFolder(str1);
              paramInt += 1;
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
              paramString = Runtime.getRuntime().exec(toolsfiles + "/busybox " + paramString + "\n");
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/move_to_system.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */