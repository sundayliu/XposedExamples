package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.LogOutputStream;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class integrate_dalvik_code
{
  public static boolean ART;
  public static String apk_on_sd = "";
  public static ArrayList<File> classesFiles = new ArrayList();
  public static String dir = "/sdcard/";
  public static String dirapp;
  public static PrintStream print;
  public static String result;
  public static String sddir;
  public static boolean system;
  public static String uid = "";
  
  static
  {
    system = false;
    ART = false;
    dirapp = "/data/app/";
    sddir = "/sdcard/";
  }
  
  public static void clearTemp()
  {
    File localFile1;
    do
    {
      try
      {
        Object localObject = new File(dir + "/AndroidManifest.xml");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if ((classesFiles != null) && (classesFiles.size() > 0))
        {
          localObject = classesFiles.iterator();
          while (((Iterator)localObject).hasNext())
          {
            File localFile2 = (File)((Iterator)localObject).next();
            if (localFile2.exists()) {
              localFile2.delete();
            }
          }
        }
        localFile1 = new File(dir + "/classes.dex");
      }
      catch (Exception localException)
      {
        Utils.sendFromRoot("" + localException.toString());
        return;
      }
      if (localFile1.exists()) {
        localFile1.delete();
      }
      localFile1 = new File(dir + "/classes.dex.apk");
    } while (!localFile1.exists());
    localFile1.delete();
  }
  
  public static void clearTempSD()
  {
    try
    {
      File localFile = new File(sddir + "/Modified/classes.dex.apk");
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      Utils.sendFromRoot("" + localException.toString());
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    LogOutputStream localLogOutputStream = new LogOutputStream("System.out");
    print = new PrintStream(localLogOutputStream);
    Utils.startRootJava(new Object() {});
    Utils.kill(paramArrayOfString[0]);
    try
    {
      File[] arrayOfFile = new File(paramArrayOfString[2]).listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      File localFile;
      while (i < j)
      {
        localFile = arrayOfFile[i];
        if ((localFile.isFile()) && (!localFile.getName().equals("busybox")) && (!localFile.getName().equals("reboot")) && (!localFile.getName().equals("dalvikvm"))) {
          localFile.delete();
        }
        i += 1;
      }
      try
      {
        if (paramArrayOfString[4].contains("ART")) {
          ART = true;
        }
        if (paramArrayOfString[5] != null) {
          uid = paramArrayOfString[5];
        }
        if (paramArrayOfString[6] != null) {
          apk_on_sd = paramArrayOfString[6];
        }
        Utils.sendFromRoot(paramArrayOfString[4]);
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;) {}
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      if (paramArrayOfString[4] == null) {}
    }
    try
    {
      if (listAppsFragment.startUnderRoot.booleanValue()) {
        Utils.remount(paramArrayOfString[1], "RW");
      }
      if (!ART)
      {
        dir = paramArrayOfString[2];
        dirapp = paramArrayOfString[1];
        clearTemp();
        if (paramArrayOfString[3].equals("not_system")) {
          system = false;
        }
        if (paramArrayOfString[3].equals("system")) {
          system = true;
        }
        Utils.sendFromRoot("CLASSES mode create odex enabled.");
        Object localObject1 = paramArrayOfString[0];
        sddir = paramArrayOfString[2];
        clearTempSD();
        localObject1 = new File(apk_on_sd);
        Utils.sendFromRoot("Get classes.dex.");
        print.println("Get classes.dex.");
        unzipART((File)localObject1);
        if ((classesFiles == null) || (classesFiles.size() == 0)) {
          throw new FileNotFoundException();
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Utils.sendFromRoot("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
      localFileNotFoundException.printStackTrace();
      clearTempSD();
      i = Utils.create_ODEX_root(paramArrayOfString[2], classesFiles, paramArrayOfString[1], uid, Utils.getOdexForCreate(paramArrayOfString[1], uid));
      Utils.sendFromRoot("chelpus_return_" + i);
      Utils.exitFromRootJava();
      result = localLogOutputStream.allresult;
      return;
      Iterator localIterator = classesFiles.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((File)localIterator.next()).exists());
      throw new FileNotFoundException();
    }
    catch (Exception localException2)
    {
      do
      {
        for (;;)
        {
          Utils.sendFromRoot("Exception e" + localException2.toString());
          localException2.printStackTrace();
          localException2.printStackTrace();
          continue;
          localObject2 = Utils.getPlaceForOdex(paramArrayOfString[1], true);
          localFile = new File((String)localObject2);
          if (localFile.exists()) {
            localFile.delete();
          }
          localFile = new File(((String)localObject2).replace("-1", "-2"));
          if (localFile.exists()) {
            localFile.delete();
          }
          localObject2 = new File(((String)localObject2).replace("-2", "-1"));
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
        }
      } while (!ART);
      Object localObject2 = paramArrayOfString[0];
      sddir = paramArrayOfString[2];
      clearTempSD();
      unzipART(new File(apk_on_sd));
      if ((classesFiles == null) || (classesFiles.size() == 0)) {
        throw new FileNotFoundException();
      }
      localObject2 = classesFiles.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((File)((Iterator)localObject2).next()).exists());
      throw new FileNotFoundException();
    }
  }
  
  public static void unzipART(File paramFile)
  {
    i = 0;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      ZipInputStream localZipInputStream = new ZipInputStream(localFileInputStream);
      Object localObject1 = localZipInputStream.getNextEntry();
      for (;;)
      {
        Object localObject3;
        if ((localObject1 != null) && (1 != 0))
        {
          localObject1 = ((ZipEntry)localObject1).getName();
          if ((((String)localObject1).toLowerCase().startsWith("classes")) && (((String)localObject1).endsWith(".dex")) && (!((String)localObject1).contains("/")))
          {
            localObject3 = new FileOutputStream(sddir + "/" + (String)localObject1);
            byte[] arrayOfByte = new byte['ࠀ'];
            for (;;)
            {
              int j = localZipInputStream.read(arrayOfByte);
              if (j == -1) {
                break;
              }
              ((FileOutputStream)localObject3).write(arrayOfByte, 0, j);
            }
          }
        }
        try
        {
          paramFile = new ZipFile(paramFile);
          paramFile.extractFile("classes.dex", sddir);
          classesFiles.add(new File(sddir + "/" + "classes.dex"));
          Utils.cmdParam(new String[] { "chmod", "777", sddir + "/" + "classes.dex" });
          paramFile.extractFile("AndroidManifest.xml", sddir);
          Utils.cmdParam(new String[] { "chmod", "777", sddir + "/" + "AndroidManifest.xml" });
          Utils.sendFromRoot("Exception e" + localException.toString());
          return;
          localZipInputStream.closeEntry();
          ((FileOutputStream)localObject3).close();
          classesFiles.add(new File(sddir + "/" + localException));
          Utils.cmdParam(new String[] { "chmod", "777", sddir + "/" + localException });
          if (localException.equals("AndroidManifest.xml"))
          {
            localObject2 = new FileOutputStream(sddir + "/" + "AndroidManifest.xml");
            localObject3 = new byte['ࠀ'];
            for (;;)
            {
              i = localZipInputStream.read((byte[])localObject3);
              if (i == -1) {
                break;
              }
              ((FileOutputStream)localObject2).write((byte[])localObject3, 0, i);
            }
            localZipInputStream.closeEntry();
            ((FileOutputStream)localObject2).close();
            Utils.cmdParam(new String[] { "chmod", "777", sddir + "/" + "AndroidManifest.xml" });
            i = 1;
            break label714;
            localZipInputStream.close();
            localFileInputStream.close();
            return;
            localObject2 = localZipInputStream.getNextEntry();
          }
        }
        catch (ZipException paramFile)
        {
          for (;;)
          {
            Utils.sendFromRoot("Error classes.dex decompress! " + paramFile);
            Utils.sendFromRoot("Exception e1" + ((Exception)localObject2).toString());
          }
        }
        catch (Exception paramFile)
        {
          for (;;)
          {
            Object localObject2;
            Utils.sendFromRoot("Error classes.dex decompress! " + paramFile);
            Utils.sendFromRoot("Exception e1" + ((Exception)localObject2).toString());
            continue;
            if ((0 == 0) || (i == 0)) {}
          }
        }
      }
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/integrate_dalvik_code.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */