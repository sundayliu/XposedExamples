package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

public class backupdata
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    localObject4 = paramArrayOfString[0];
    localObject3 = paramArrayOfString[1];
    localObject1 = paramArrayOfString[2];
    localObject2 = paramArrayOfString[3];
    k = 0;
    j = 0;
    paramArrayOfString = new File((String)localObject1 + "/data.lpbkp");
    localFile1 = new File((String)localObject1 + "/data.lpbkp.tmp");
    localFile2 = new File((String)localObject1 + "/dbdata.lpbkp");
    localFile3 = new File((String)localObject1 + "/dbdata.lpbkp.tmp");
    localFile4 = new File((String)localObject1 + "/sddata.lpbkp");
    localObject1 = new File((String)localObject1 + "/sddata.lpbkp.tmp");
    for (;;)
    {
      try
      {
        if (paramArrayOfString.exists()) {
          paramArrayOfString.renameTo(localFile1);
        }
        localZipFile = new ZipFile(paramArrayOfString);
        localZipParameters = new ZipParameters();
        localZipParameters.setCompressionMethod(8);
        localZipParameters.setCompressionLevel(1);
        System.out.println((String)localObject3);
        localObject3 = new File((String)localObject3);
        System.out.println(localObject3);
        localObject3 = ((File)localObject3).listFiles();
        i = k;
        if (localObject3 == null) {
          continue;
        }
        i = k;
        if (localObject3.length == 0) {
          continue;
        }
        m = localObject3.length;
        k = 0;
        i = j;
        if (k >= m) {
          continue;
        }
        localFile5 = localObject3[k];
        if (!localFile5.isDirectory()) {
          continue;
        }
        bool = localFile5.getName().equals("lib");
        if (bool) {
          continue;
        }
      }
      catch (ZipException localZipException1)
      {
        ZipParameters localZipParameters;
        File localFile5;
        localZipException1.printStackTrace();
        i = 1;
        System.out.println("error");
        if ((i != 0) || (paramArrayOfString.exists()) || (localFile2.exists())) {
          continue;
        }
        System.out.println("empty data...");
        if ((i != 0) || (paramArrayOfString.exists())) {
          continue;
        }
        localFile1.renameTo(paramArrayOfString);
        if ((i != 0) || (localFile2.exists())) {
          continue;
        }
        localFile3.renameTo(localFile2);
        if ((i != 0) || (localFile4.exists())) {
          continue;
        }
        ((File)localObject1).renameTo(localFile2);
        Utils.exitFromRootJava();
        return;
        bool = localZipException4.isFile();
        i = j;
        if (!bool) {
          continue;
        }
        try
        {
          localZipFile.addFile(localZipException4, localZipException1);
          i = j;
        }
        catch (ZipException localZipException5)
        {
          localZipException5.printStackTrace();
          i = 1;
          System.out.println("error");
        }
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        System.out.println("Exception e" + localException.toString());
        int i = 1;
        System.out.println("error");
        continue;
        j = i;
        if (!new File("/dbdata/databases/" + (String)localObject4).exists()) {
          continue;
        }
        if (!localFile2.exists()) {
          continue;
        }
        localFile2.renameTo(localFile3);
        ZipFile localZipFile = new ZipFile(localFile2);
        localObject4 = new File("/dbdata/databases/" + (String)localObject4).listFiles();
        j = i;
        if (localObject3 == null) {
          continue;
        }
        j = i;
        if (localObject3.length == 0) {
          continue;
        }
        int m = localObject4.length;
        k = 0;
        j = i;
        if (k >= m) {
          continue;
        }
        File localFile6 = localObject4[k];
        boolean bool = localFile6.isDirectory();
        if (!bool) {
          continue;
        }
        try
        {
          localZipFile.addFolder(localFile6, localException);
          k += 1;
        }
        catch (ZipException localZipException6)
        {
          localZipException6.printStackTrace();
          i = 1;
          System.out.println("error");
          continue;
        }
        try
        {
          localZipFile.addFile(localZipException6, localException);
        }
        catch (ZipException localZipException7)
        {
          localZipException7.printStackTrace();
          i = 1;
          System.out.println("error");
        }
        continue;
        i = j;
        if (!new File((String)localObject2).exists()) {
          continue;
        }
        if (!localFile4.exists()) {
          continue;
        }
        localFile4.renameTo((File)localObject1);
        localObject4 = new ZipFile(localFile4);
        localObject2 = new File((String)localObject2).listFiles();
        i = j;
        if (localObject3 == null) {
          continue;
        }
        i = j;
        if (localObject3.length == 0) {
          continue;
        }
        m = localObject2.length;
        k = 0;
        i = j;
        if (k >= m) {
          continue;
        }
        localObject3 = localObject2[k];
        bool = ((File)localObject3).isDirectory();
        if (!bool) {
          continue;
        }
        try
        {
          ((ZipFile)localObject4).addFolder((File)localObject3, localException);
          k += 1;
        }
        catch (ZipException localZipException2)
        {
          localZipException2.printStackTrace();
          j = 1;
          System.out.println("error");
          continue;
        }
        try
        {
          ((ZipFile)localObject4).addFile(localZipException2, localException);
        }
        catch (ZipException localZipException3)
        {
          localZipException3.printStackTrace();
          j = 1;
          System.out.println("error");
        }
        continue;
        localFile1.delete();
        continue;
        localFile3.delete();
        continue;
        ((File)localObject1).delete();
        continue;
      }
      try
      {
        System.out.println(localFile5.getAbsolutePath());
        localZipFile.addFolder(localFile5, localZipParameters);
        i = j;
      }
      catch (ZipException localZipException4)
      {
        localZipException4.printStackTrace();
        i = 1;
        System.out.println("error");
        continue;
      }
      k += 1;
      j = i;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/backupdata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */