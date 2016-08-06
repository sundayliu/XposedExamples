package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class pinfo
{
  public static ArrayList<File> classesFiles = new ArrayList();
  public static String toolfilesdir = "";
  
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    String str1 = paramArrayOfString[0];
    toolfilesdir = paramArrayOfString[1];
    String str2 = paramArrayOfString[2];
    if ((paramArrayOfString[3] != null) && (paramArrayOfString[3].contains("recovery"))) {}
    for (;;)
    {
      try
      {
        localObject = Utils.getOdexForCreate(str1, str2);
        Utils.remount((String)localObject, "rw");
        File localFile = Utils.getFileDalvikCache(str1);
        paramArrayOfString = null;
        if (localFile != null) {
          paramArrayOfString = new File(localFile.getAbsolutePath() + "_lpbackup");
        }
        if ((paramArrayOfString == null) || (!paramArrayOfString.exists())) {
          continue;
        }
        paramArrayOfString.renameTo(localFile);
        new File((String)localObject).delete();
        if (new File((String)localObject + "_lpbackup").exists()) {
          new File((String)localObject + "_lpbackup").renameTo(new File((String)localObject));
        }
        Utils.exitFromRootJava();
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        continue;
      }
      return;
      try
      {
        Utils.create_DC_root(toolfilesdir, str1, str2, Utils.getOdexForCreate(str1, str2));
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
      }
      continue;
      unzipART(new File(toolfilesdir + "/p.apk"));
      paramArrayOfString = Utils.getOdexForCreate(str1, str2);
      Object localObject = Utils.getFileDalvikCache(str1);
      if ((localObject != null) && (((File)localObject).exists()))
      {
        ((File)localObject).renameTo(new File(((File)localObject).getAbsolutePath() + "_lpbackup"));
        Utils.dalvikvm_copyFile(toolfilesdir, ((File)localObject).getAbsolutePath() + "_lpbackup", ((File)localObject).getAbsolutePath());
        Utils.run_all_no_root(new String[] { "chmod", "777", ((File)localObject).getAbsolutePath() });
        Utils.run_all_no_root(new String[] { "chown", "0:0", ((File)localObject).getAbsolutePath() });
        Utils.run_all_no_root(new String[] { "chown", "0.0", ((File)localObject).getAbsolutePath() });
      }
      Utils.remount(paramArrayOfString, "rw");
      if (new File(paramArrayOfString).exists()) {
        new File(paramArrayOfString).renameTo(new File(paramArrayOfString + "_lpbackup"));
      }
      Utils.create_ODEX_root(toolfilesdir, classesFiles, str1, str2, paramArrayOfString);
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
          if ((((String)localObject1).startsWith("classes")) && (((String)localObject1).endsWith(".dex")) && (!((String)localObject1).contains("/")))
          {
            localObject3 = new FileOutputStream(toolfilesdir + "/" + (String)localObject1);
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
          paramFile.extractFile("classes.dex", toolfilesdir);
          classesFiles.add(new File(toolfilesdir + "/" + "classes.dex"));
          Utils.cmdParam(new String[] { "chmod", "777", toolfilesdir + "/" + "classes.dex" });
          paramFile.extractFile("AndroidManifest.xml", toolfilesdir);
          Utils.cmdParam(new String[] { "chmod", "777", toolfilesdir + "/" + "AndroidManifest.xml" });
          Utils.sendFromRoot("Exception e" + localException.toString());
          return;
          localZipInputStream.closeEntry();
          ((FileOutputStream)localObject3).close();
          classesFiles.add(new File(toolfilesdir + "/" + localException));
          Utils.cmdParam(new String[] { "chmod", "777", toolfilesdir + "/" + localException });
          if (localException.equals("AndroidManifest.xml"))
          {
            localObject2 = new FileOutputStream(toolfilesdir + "/" + "AndroidManifest.xml");
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
            Utils.cmdParam(new String[] { "chmod", "777", toolfilesdir + "/" + "AndroidManifest.xml" });
            i = 1;
            break label680;
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/pinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */