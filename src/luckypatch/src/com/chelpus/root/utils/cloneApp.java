package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.AxmlExample;
import com.android.vending.billing.InAppBillingService.LACK.LogOutputStream;
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

public class cloneApp
{
  public static String appdir = "/sdcard/";
  public static ArrayList<File> classesFiles = new ArrayList();
  public static File crkapk;
  public static String dir;
  public static String dir2;
  public static String dirapp = "/data/app/";
  public static ArrayList<File> filestopatch;
  public static PrintStream print;
  public static String result;
  public static String sddir;
  public static boolean system = false;
  
  static
  {
    dir = "/sdcard/";
    dir2 = "/sdcard/";
    filestopatch = null;
    sddir = "/sdcard/";
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
    localLogOutputStream = new LogOutputStream("System.out");
    print = new PrintStream(localLogOutputStream);
    Utils.startRootJava(new Object() {});
    Utils.kill(paramArrayOfString[0]);
    print.println("Support-Code Running!");
    new ArrayList();
    filestopatch = new ArrayList();
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
        Utils.sendFromRoot(paramArrayOfString[6]);
        com.android.vending.billing.InAppBillingService.LACK.listAppsFragment.startUnderRoot = Boolean.valueOf(false);
        Object localObject = paramArrayOfString[0];
        for (;;)
        {
          try
          {
            appdir = paramArrayOfString[1];
            sddir = paramArrayOfString[3];
            clearTempSD();
            paramArrayOfString = new File(appdir);
            unzipSD(paramArrayOfString);
            crkapk = new File(sddir + "/Modified/" + (String)localObject + ".apk");
            Utils.copyFile(paramArrayOfString, crkapk);
            paramArrayOfString = ((String)localObject).getBytes();
            i = 0;
            if (i < paramArrayOfString.length)
            {
              if (i != paramArrayOfString.length - 1) {
                break;
              }
              if (paramArrayOfString[i] == 122) {
                paramArrayOfString[i] = 65;
              } else {
                paramArrayOfString[i] = ((byte)(paramArrayOfString[i] + 1));
              }
            }
          }
          catch (Exception paramArrayOfString)
          {
            paramArrayOfString.printStackTrace();
            Utils.sendFromRoot("Optional Steps After Patch:");
            result = localLogOutputStream.allresult;
            return;
          }
          paramArrayOfString = new String(paramArrayOfString);
          localFile = new File(sddir + "/Modified/AndroidManifest.xml");
          if (!localFile.exists()) {
            throw new FileNotFoundException();
          }
          try
          {
            if (!new AxmlExample().changePackageName(localFile, (String)localObject, paramArrayOfString)) {
              localFile.delete();
            }
            if ((classesFiles == null) || (classesFiles.size() == 0)) {
              throw new FileNotFoundException();
            }
          }
          catch (Exception paramArrayOfString)
          {
            for (;;)
            {
              paramArrayOfString.printStackTrace();
            }
            filestopatch.clear();
            paramArrayOfString = classesFiles.iterator();
            while (paramArrayOfString.hasNext())
            {
              localObject = (File)paramArrayOfString.next();
              if (!((File)localObject).exists()) {
                throw new FileNotFoundException();
              }
              filestopatch.add(localObject);
            }
            paramArrayOfString = filestopatch.iterator();
          }
          while (paramArrayOfString.hasNext())
          {
            localObject = (File)paramArrayOfString.next();
            Utils.sendFromRoot("Find string id.");
            Utils.sendFromRoot("String analysis.");
            print.println("String analysis.");
            Utils.sendFromRoot("Analise Results:");
            Utils.fixadler((File)localObject);
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          continue;
          i += 1;
        }
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      if (paramArrayOfString[6] == null) {}
    }
  }
  
  public static void unzipSD(File paramFile)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      ZipInputStream localZipInputStream = new ZipInputStream(localFileInputStream);
      int j = 0;
      for (;;)
      {
        Object localObject1 = localZipInputStream.getNextEntry();
        int i;
        Object localObject2;
        if (localObject1 != null)
        {
          i = j;
          if (((ZipEntry)localObject1).getName().startsWith("classes"))
          {
            i = j;
            if (((ZipEntry)localObject1).getName().endsWith(".dex"))
            {
              i = j;
              if (!((ZipEntry)localObject1).getName().contains("/"))
              {
                localObject2 = new FileOutputStream(sddir + "/Modified/" + ((ZipEntry)localObject1).getName());
                byte[] arrayOfByte = new byte['Ѐ'];
                for (;;)
                {
                  i = localZipInputStream.read(arrayOfByte);
                  if (i == -1) {
                    break;
                  }
                  ((FileOutputStream)localObject2).write(arrayOfByte, 0, i);
                }
              }
            }
          }
        }
        try
        {
          paramFile = new ZipFile(paramFile);
          paramFile.extractFile("classes.dex", sddir + "/Modified/");
          classesFiles.add(new File(sddir + "/Modified/" + "classes.dex"));
          paramFile.extractFile("AndroidManifest.xml", sddir + "/Modified/");
          Utils.sendFromRoot("Decompressunzip " + localException);
          return;
          classesFiles.add(new File(sddir + "/Modified/" + ((ZipEntry)localObject1).getName()));
          i = 1;
          j = i;
          if (!((ZipEntry)localObject1).getName().equals("AndroidManifest.xml")) {
            continue;
          }
          localObject1 = new FileOutputStream(sddir + "/Modified/" + "AndroidManifest.xml");
          localObject2 = new byte['Ѐ'];
          for (;;)
          {
            j = localZipInputStream.read((byte[])localObject2);
            if (j == -1) {
              break;
            }
            ((FileOutputStream)localObject1).write((byte[])localObject2, 0, j);
          }
          j = i;
          if (i == 0) {
            continue;
          }
          localZipInputStream.closeEntry();
          ((FileOutputStream)localObject1).close();
          j = i;
          continue;
          localZipInputStream.close();
          localException.close();
          return;
        }
        catch (ZipException paramFile)
        {
          for (;;)
          {
            Utils.sendFromRoot("Error classes.dex decompress! " + paramFile);
            Utils.sendFromRoot("Exception e1" + localException.toString());
          }
        }
        catch (Exception paramFile)
        {
          for (;;)
          {
            Utils.sendFromRoot("Error classes.dex decompress! " + paramFile);
            Utils.sendFromRoot("Exception e1" + localException.toString());
          }
        }
      }
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/cloneApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */