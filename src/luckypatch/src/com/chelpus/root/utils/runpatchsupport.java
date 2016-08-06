package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.AxmlExample;
import com.android.vending.billing.InAppBillingService.LACK.CommandItem;
import com.android.vending.billing.InAppBillingService.LACK.LogOutputStream;
import com.android.vending.billing.InAppBillingService.LACK.PatchesItemAuto;
import com.android.vending.billing.InAppBillingService.LACK.StringItem;
import com.android.vending.billing.InAppBillingService.LACK.TypesItem;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class runpatchsupport
{
  private static boolean ART;
  public static String appdir = "/sdcard/";
  public static ArrayList<File> classesFiles = new ArrayList();
  private static boolean copyDC;
  private static boolean createAPK = false;
  public static File crkapk;
  public static String dir;
  public static String dir2;
  public static String dirapp;
  public static ArrayList<File> filestopatch;
  private static boolean pattern1 = true;
  private static boolean pattern2 = true;
  private static boolean pattern3 = true;
  public static PrintStream print;
  public static String result;
  public static String sddir;
  public static boolean system;
  public static String uid;
  
  static
  {
    copyDC = false;
    ART = false;
    dirapp = "/data/app/";
    system = false;
    uid = "";
    dir = "/sdcard/";
    dir2 = "/sdcard/";
    filestopatch = null;
    sddir = "/sdcard/";
  }
  
  public static boolean byteverify(MappedByteBuffer paramMappedByteBuffer, int paramInt, byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, String paramString, boolean paramBoolean)
  {
    if ((paramByte == paramArrayOfByte1[0]) && (paramBoolean))
    {
      if (paramArrayOfByte4[0] == 0) {
        paramArrayOfByte3[0] = paramByte;
      }
      int i = 1;
      paramMappedByteBuffer.position(paramInt + 1);
      for (paramByte = paramMappedByteBuffer.get(); (paramByte == paramArrayOfByte1[i]) || (paramArrayOfByte2[i] == 1); paramByte = paramMappedByteBuffer.get())
      {
        if (paramArrayOfByte4[i] == 0) {
          paramArrayOfByte3[i] = paramByte;
        }
        i += 1;
        if (i == paramArrayOfByte1.length)
        {
          paramMappedByteBuffer.position(paramInt);
          paramMappedByteBuffer.put(paramArrayOfByte3);
          paramMappedByteBuffer.force();
          Utils.sendFromRoot(paramString);
          return true;
        }
      }
      paramMappedByteBuffer.position(paramInt + 1);
    }
    return false;
  }
  
  private static final void calcChecksum(byte[] paramArrayOfByte, int paramInt)
  {
    Adler32 localAdler32 = new Adler32();
    localAdler32.update(paramArrayOfByte, 12, paramArrayOfByte.length - (paramInt + 12));
    int i = (int)localAdler32.getValue();
    paramArrayOfByte[(paramInt + 8)] = ((byte)i);
    paramArrayOfByte[(paramInt + 9)] = ((byte)(i >> 8));
    paramArrayOfByte[(paramInt + 10)] = ((byte)(i >> 16));
    paramArrayOfByte[(paramInt + 11)] = ((byte)(i >> 24));
  }
  
  private static final void calcSignature(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte, 32, paramArrayOfByte.length - (paramInt + 32));
      try
      {
        paramInt = localMessageDigest.digest(paramArrayOfByte, paramInt + 12, 20);
        if (paramInt != 20) {
          throw new RuntimeException("unexpected digest write:" + paramInt + "bytes");
        }
      }
      catch (DigestException paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
      return;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
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
  
  public static void fixadler(File paramFile)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[localFileInputStream.available()];
      localFileInputStream.read(arrayOfByte);
      calcSignature(arrayOfByte, 0);
      calcChecksum(arrayOfByte, 0);
      localFileInputStream.close();
      paramFile = new FileOutputStream(paramFile);
      paramFile.write(arrayOfByte);
      paramFile.close();
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    LogOutputStream localLogOutputStream = new LogOutputStream("System.out");
    print = new PrintStream(localLogOutputStream);
    Utils.startRootJava(new Object() {});
    Utils.kill(paramArrayOfString[0]);
    print.println("Support-Code Running!");
    ArrayList localArrayList = new ArrayList();
    pattern1 = true;
    pattern2 = true;
    pattern3 = true;
    filestopatch = new ArrayList();
    try
    {
      File[] arrayOfFile = new File(paramArrayOfString[3]).listFiles();
      int m = arrayOfFile.length;
      int k = 0;
      Object localObject4;
      while (k < m)
      {
        localObject4 = arrayOfFile[k];
        if ((((File)localObject4).isFile()) && (!((File)localObject4).getName().equals("busybox")) && (!((File)localObject4).getName().equals("reboot")) && (!((File)localObject4).getName().equals("dalvikvm"))) {
          ((File)localObject4).delete();
        }
        k += 1;
      }
      try
      {
        if (!paramArrayOfString[1].contains("pattern0")) {
          pattern1 = false;
        }
        if (!paramArrayOfString[1].contains("pattern1")) {
          pattern2 = false;
        }
        if (!paramArrayOfString[1].contains("pattern2")) {
          pattern3 = false;
        }
        if ((paramArrayOfString[6] != null) && (paramArrayOfString[6].contains("createAPK"))) {
          createAPK = true;
        }
        if ((paramArrayOfString[6] != null) && (paramArrayOfString[6].contains("ART"))) {
          ART = true;
        }
        if (paramArrayOfString[6] != null) {
          Utils.sendFromRoot(paramArrayOfString[6]);
        }
        if (paramArrayOfString[7] != null) {
          uid = paramArrayOfString[7];
        }
        System.out.println("uid:" + uid);
      }
      catch (Exception localException6)
      {
        for (;;) {}
      }
      catch (NullPointerException localNullPointerException2)
      {
        for (;;)
        {
          int i4;
          int i1;
          int n;
          int i2;
          int i5;
          continue;
          if (i4 != 0) {
            if (i1 == 0)
            {
              continue;
              continue;
              k = 0;
              continue;
              m = k;
              n = i2;
              if (k == 0)
              {
                n = i2 + 1;
                m = 1;
                continue;
                i4 += 1;
                i5 = m;
                i1 = i2;
                i2 = n;
              }
            }
          }
        }
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      if (paramArrayOfString[5].contains("copyDC")) {
        copyDC = true;
      }
      if (createAPK) {
        listAppsFragment.startUnderRoot = Boolean.valueOf(false);
      }
      Object localObject1 = new ArrayList();
      localObject4 = new ArrayList();
      Object localObject5 = new ArrayList();
      Object localObject6 = new ArrayList();
      Object localObject7 = new ArrayList();
      Object localObject8 = new ArrayList();
      ((ArrayList)localObject1).add("1A ?? FF FF");
      ((ArrayList)localObject4).add("1A ?? ?? ??");
      ((ArrayList)localObject5).add(Boolean.valueOf(true));
      ((ArrayList)localObject6).add("(pak intekekt 0)");
      ((ArrayList)localObject7).add("search_pack");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("1B ?? FF FF FF FF");
      ((ArrayList)localObject4).add("1B ?? ?? ?? ?? ??");
      ((ArrayList)localObject5).add(Boolean.valueOf(true));
      ((ArrayList)localObject6).add("(pak intekekt 0)");
      ((ArrayList)localObject7).add("search_pack");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("1A ?? FF FF");
      ((ArrayList)localObject4).add("1A ?? ?? ??");
      ((ArrayList)localObject5).add(Boolean.valueOf(true));
      ((ArrayList)localObject6).add("(sha intekekt 2)");
      ((ArrayList)localObject7).add("search");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("1B ?? FF FF FF FF");
      ((ArrayList)localObject4).add("1B ?? ?? ?? ?? ??");
      ((ArrayList)localObject5).add(Boolean.valueOf(true));
      ((ArrayList)localObject6).add("(sha intekekt 2 32 bit)");
      ((ArrayList)localObject7).add("search");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("0A ?? 39 ?? ?? 00");
      ((ArrayList)localObject4).add("12 S1 39 ?? ?? 00");
      ((ArrayList)localObject5).add(Boolean.valueOf(false));
      ((ArrayList)localObject6).add("support2 Fixed!\n(sha intekekt 3)");
      ((ArrayList)localObject7).add("search");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("1A ?? FF FF");
      ((ArrayList)localObject4).add("1A ?? FF FF");
      ((ArrayList)localObject5).add(Boolean.valueOf(false));
      ((ArrayList)localObject6).add("support1 Fixed!\n(pak intekekt)");
      ((ArrayList)localObject7).add("search_pack");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("1B ?? FF FF FF FF");
      ((ArrayList)localObject4).add("1B ?? FF FF FF FF");
      ((ArrayList)localObject5).add(Boolean.valueOf(false));
      ((ArrayList)localObject6).add("support1 Fixed!\n(pak intekekt 32 bit)");
      ((ArrayList)localObject7).add("search_pack");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("6E 20 FF FF ?? 00 0A ??");
      ((ArrayList)localObject4).add("6E 20 ?? ?? ?? 00 12 S1");
      ((ArrayList)localObject5).add(Boolean.valueOf(false));
      ((ArrayList)localObject6).add("support2 Fixed!\n(sha intekekt 4)");
      ((ArrayList)localObject7).add("");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("6E 20 FF FF ?? 00");
      ((ArrayList)localObject4).add("00 00 00 00 00 00");
      ((ArrayList)localObject5).add(Boolean.valueOf(false));
      ((ArrayList)localObject6).add("support3 Fixed!\n(intent for free)");
      ((ArrayList)localObject7).add("");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("0A ?? 39 ?? ?? ??");
      ((ArrayList)localObject4).add("12 S1 39 ?? ?? ??");
      ((ArrayList)localObject5).add(Boolean.valueOf(false));
      ((ArrayList)localObject6).add("support1 Fixed!\n(ev1)");
      ((ArrayList)localObject7).add("search_sign_ver");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("0A ?? 38 ?? ?? ??");
      ((ArrayList)localObject4).add("12 S1 38 ?? ?? ??");
      ((ArrayList)localObject5).add(Boolean.valueOf(false));
      ((ArrayList)localObject6).add("support1 Fixed!\n(ev1)");
      ((ArrayList)localObject7).add("search_sign_ver");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("1C ?? FF FF");
      ((ArrayList)localObject4).add("1C ?? ?? ??");
      ((ArrayList)localObject5).add(Boolean.valueOf(false));
      ((ArrayList)localObject6).add("support1 Fixed!\n(si)");
      ((ArrayList)localObject7).add("search_sign_ver");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      ((ArrayList)localObject1).add("23 ?? ?? ?? 1C ?? ?? ?? 12 ?? 4D ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 39 ?? ?? ?? 1A ?? ?? ?? 1A");
      ((ArrayList)localObject4).add("23 ?? ?? ?? 1C ?? ?? ?? 12 ?? 4D ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 12 S1 39 ?? ?? ?? 1A ?? ?? ?? 1A");
      ((ArrayList)localObject5).add(Boolean.valueOf(true));
      ((ArrayList)localObject6).add("support3 Fixed!\n(s)");
      ((ArrayList)localObject7).add("");
      ((ArrayList)localObject8).add(Boolean.valueOf(false));
      Utils.convertToPatchItemAuto(localArrayList, (ArrayList)localObject1, (ArrayList)localObject4, (ArrayList)localObject5, (ArrayList)localObject6, (ArrayList)localObject7, (ArrayList)localObject8, Boolean.valueOf(false));
      Object localObject2;
      try
      {
        if (listAppsFragment.startUnderRoot.booleanValue()) {
          Utils.remount(paramArrayOfString[2], "RW");
        }
        if ((createAPK) || (ART)) {
          break label1928;
        }
        dir = paramArrayOfString[3];
        dirapp = paramArrayOfString[2];
        clearTemp();
        if (paramArrayOfString[4].equals("not_system")) {
          system = false;
        }
        if (paramArrayOfString[4].equals("system")) {
          system = true;
        }
        filestopatch.clear();
        Utils.sendFromRoot("CLASSES mode create odex enabled.");
        localObject1 = paramArrayOfString[0];
        appdir = paramArrayOfString[2];
        sddir = paramArrayOfString[3];
        clearTempSD();
        localObject1 = new File(appdir);
        Utils.sendFromRoot("Get classes.dex.");
        print.println("Get classes.dex.");
        unzipART((File)localObject1);
        if ((classesFiles == null) || (classesFiles.size() == 0)) {
          throw new FileNotFoundException();
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Utils.sendFromRoot("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
        Iterator localIterator = filestopatch.iterator();
        while (localIterator.hasNext())
        {
          Utils.fixadler((File)localIterator.next());
          clearTempSD();
        }
        filestopatch.clear();
        localIterator = classesFiles.iterator();
        if (localIterator.hasNext())
        {
          localObject4 = (File)localIterator.next();
          if (!((File)localObject4).exists()) {
            throw new FileNotFoundException();
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Utils.sendFromRoot("Patch Process Exception: " + localException2.toString());
          continue;
          filestopatch.add(localObject4);
        }
        localObject2 = Utils.getPlaceForOdex(paramArrayOfString[2], true);
        localObject4 = new File((String)localObject2);
        if (((File)localObject4).exists()) {
          ((File)localObject4).delete();
        }
        localObject4 = new File(((String)localObject2).replace("-1", "-2"));
        if (((File)localObject4).exists()) {
          ((File)localObject4).delete();
        }
        localObject2 = new File(((String)localObject2).replace("-2", "-1"));
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
      }
      localObject4 = filestopatch.iterator();
      label1585:
      label1739:
      Object localObject9;
      label1928:
      Object localObject3;
      int i3;
      int i6;
      long l2;
      long l1;
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (File)((Iterator)localObject4).next();
        Utils.sendFromRoot("Find string id.");
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add("com.android.vending");
        ((ArrayList)localObject2).add("SHA1withRSA");
        ((ArrayList)localObject2).add("com.android.vending.billing.InAppBillingService.BIND");
        ((ArrayList)localObject2).add("Ljava/security/Signature;");
        ((ArrayList)localObject2).add("verify");
        ((ArrayList)localObject2).add("Landroid/content/Intent;");
        ((ArrayList)localObject2).add("setPackage");
        ((ArrayList)localObject2).add("engineVerify");
        ((ArrayList)localObject2).add("Ljava/security/SignatureSpi;");
        Utils.sendFromRoot("String analysis.");
        print.println("String analysis.");
        if (!copyDC)
        {
          localObject2 = Utils.getStringIds(((File)localObject5).getAbsolutePath(), (ArrayList)localObject2, false);
          i4 = 0;
          i1 = 0;
          m = 0;
          n = 0;
          k = 0;
          localObject6 = new ArrayList();
          ((ArrayList)localObject6).add(new TypesItem("Ljava/security/Signature;"));
          ((ArrayList)localObject6).add(new TypesItem("Ljava/security/SignatureSpi;"));
          localObject7 = new ArrayList();
          ((ArrayList)localObject7).add(new CommandItem("Ljava/security/Signature;", "verify"));
          ((ArrayList)localObject7).add(new CommandItem("Landroid/content/Intent;", "setPackage"));
          localObject2 = ((ArrayList)localObject2).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label6006;
          }
          localObject8 = (StringItem)((Iterator)localObject2).next();
          localObject9 = ((ArrayList)localObject6).iterator();
          Object localObject10;
          for (;;)
          {
            if (((Iterator)localObject9).hasNext())
            {
              localObject10 = (TypesItem)((Iterator)localObject9).next();
              if (((TypesItem)localObject10).type.equals(((StringItem)localObject8).str))
              {
                ((TypesItem)localObject10).Type = ((StringItem)localObject8).offset;
                continue;
                if (createAPK)
                {
                  localObject2 = paramArrayOfString[0];
                  appdir = paramArrayOfString[2];
                  sddir = paramArrayOfString[5];
                  clearTempSD();
                  localObject4 = new File(appdir);
                  unzipSD((File)localObject4);
                  crkapk = new File(sddir + "/Modified/" + (String)localObject2 + ".apk");
                  Utils.copyFile((File)localObject4, crkapk);
                  localObject2 = new File(sddir + "/Modified/AndroidManifest.xml");
                  if (!((File)localObject2).exists()) {
                    throw new FileNotFoundException();
                  }
                  try
                  {
                    if (!new AxmlExample().changeTargetApi((File)localObject2, "19")) {
                      ((File)localObject2).delete();
                    }
                    if ((classesFiles == null) || (classesFiles.size() == 0)) {
                      throw new FileNotFoundException();
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      localException3.printStackTrace();
                    }
                    filestopatch.clear();
                    localObject3 = classesFiles.iterator();
                  }
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (File)((Iterator)localObject3).next();
                    if (!((File)localObject4).exists()) {
                      throw new FileNotFoundException();
                    }
                    filestopatch.add(localObject4);
                  }
                }
                if (!ART) {
                  break;
                }
                Utils.sendFromRoot("ART mode create dex enabled.");
                localObject3 = paramArrayOfString[0];
                appdir = paramArrayOfString[2];
                sddir = paramArrayOfString[3];
                clearTempSD();
                unzipART(new File(appdir));
                if ((classesFiles == null) || (classesFiles.size() == 0)) {
                  throw new FileNotFoundException();
                }
                filestopatch.clear();
                localObject3 = classesFiles.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (File)((Iterator)localObject3).next();
                  if (!((File)localObject4).exists()) {
                    throw new FileNotFoundException();
                  }
                  filestopatch.add(localObject4);
                }
                break;
                localObject3 = Utils.getStringIds(((File)localObject5).getAbsolutePath(), (ArrayList)localObject3, false);
                break label1739;
              }
            }
          }
          localObject9 = ((ArrayList)localObject7).iterator();
          while (((Iterator)localObject9).hasNext())
          {
            localObject10 = (CommandItem)((Iterator)localObject9).next();
            if (((CommandItem)localObject10).object.equals(((StringItem)localObject8).str)) {
              ((CommandItem)localObject10).Object = ((StringItem)localObject8).offset;
            }
            if (((CommandItem)localObject10).method.equals(((StringItem)localObject8).str)) {
              ((CommandItem)localObject10).Method = ((StringItem)localObject8).offset;
            }
          }
          i2 = i4;
          if (((StringItem)localObject8).str.equals("com.android.vending"))
          {
            ((PatchesItemAuto)localArrayList.get(5)).origByte[2] = localObject8.offset[0];
            ((PatchesItemAuto)localArrayList.get(5)).origByte[3] = localObject8.offset[1];
            ((PatchesItemAuto)localArrayList.get(6)).origByte[2] = localObject8.offset[0];
            ((PatchesItemAuto)localArrayList.get(6)).origByte[3] = localObject8.offset[1];
            ((PatchesItemAuto)localArrayList.get(6)).origByte[4] = localObject8.offset[2];
            ((PatchesItemAuto)localArrayList.get(6)).origByte[5] = localObject8.offset[3];
            i2 = 1;
          }
          i3 = i1;
          if (((StringItem)localObject8).str.equals("com.android.vending.billing.InAppBillingService.BIND"))
          {
            System.out.println("c.a.v.b.i " + ((StringItem)localObject8).bits32 + " " + localObject8.offset[0] + " " + localObject8.offset[1] + " " + localObject8.offset[2] + " " + localObject8.offset[3]);
            ((PatchesItemAuto)localArrayList.get(0)).origByte[2] = localObject8.offset[0];
            ((PatchesItemAuto)localArrayList.get(0)).origByte[3] = localObject8.offset[1];
            ((PatchesItemAuto)localArrayList.get(5)).repByte[2] = localObject8.offset[0];
            ((PatchesItemAuto)localArrayList.get(5)).repByte[3] = localObject8.offset[1];
            ((PatchesItemAuto)localArrayList.get(1)).origByte[2] = localObject8.offset[0];
            ((PatchesItemAuto)localArrayList.get(1)).origByte[3] = localObject8.offset[1];
            ((PatchesItemAuto)localArrayList.get(1)).origByte[4] = localObject8.offset[2];
            ((PatchesItemAuto)localArrayList.get(1)).origByte[5] = localObject8.offset[3];
            ((PatchesItemAuto)localArrayList.get(6)).repByte[2] = localObject8.offset[0];
            ((PatchesItemAuto)localArrayList.get(6)).repByte[3] = localObject8.offset[1];
            ((PatchesItemAuto)localArrayList.get(6)).repByte[4] = localObject8.offset[2];
            ((PatchesItemAuto)localArrayList.get(6)).repByte[5] = localObject8.offset[3];
            i3 = 1;
          }
          i5 = m;
          if (((StringItem)localObject8).str.equals("SHA1withRSA"))
          {
            ((PatchesItemAuto)localArrayList.get(2)).origByte[2] = localObject8.offset[0];
            ((PatchesItemAuto)localArrayList.get(2)).origByte[3] = localObject8.offset[1];
            ((PatchesItemAuto)localArrayList.get(3)).origByte[2] = localObject8.offset[0];
            ((PatchesItemAuto)localArrayList.get(3)).origByte[3] = localObject8.offset[1];
            ((PatchesItemAuto)localArrayList.get(3)).origByte[4] = localObject8.offset[2];
            ((PatchesItemAuto)localArrayList.get(3)).origByte[5] = localObject8.offset[3];
            i5 = 1;
          }
          i6 = n;
          if (((StringItem)localObject8).str.equals("engineVerify")) {
            i6 = 1;
          }
          n = i6;
          i4 = i2;
          i1 = i3;
          m = i5;
          if (((StringItem)localObject8).str.equals("Ljava/security/SignatureSpi;"))
          {
            k = 1;
            n = i6;
            i4 = i2;
            i1 = i3;
            m = i5;
          }
        }
        ((PatchesItemAuto)localArrayList.get(0)).pattern = false;
        ((PatchesItemAuto)localArrayList.get(1)).pattern = false;
        ((PatchesItemAuto)localArrayList.get(5)).pattern = false;
        ((PatchesItemAuto)localArrayList.get(6)).pattern = false;
        if (m == 0)
        {
          ((PatchesItemAuto)localArrayList.get(2)).pattern = false;
          ((PatchesItemAuto)localArrayList.get(3)).pattern = false;
          ((PatchesItemAuto)localArrayList.get(4)).pattern = false;
        }
        if ((i1 != 0) && (i4 != 0))
        {
          localObject3 = new StringBuilder().append("Relaced strings:");
          localObject8 = ((File)localObject5).getAbsolutePath();
          localObject9 = listAppsFragment.class.getPackage().getName();
          Utils.sendFromRoot(Utils.replaceStringIds((String)localObject8, new String[] { "com.android.vending.billing.InAppBillingService.BIND" }, false, new String[] { localObject9 }));
          Utils.sendFromRoot("Parse data for patch.");
          print.println("Parse data for patch.");
          Utils.getMethodsIds(((File)localObject5).getAbsolutePath(), (ArrayList)localObject7, false, false);
          localObject3 = ((ArrayList)localObject7).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject7 = (CommandItem)((Iterator)localObject3).next();
            if (((CommandItem)localObject7).found_index_command)
            {
              if (((CommandItem)localObject7).object.equals("Ljava/security/Signature;"))
              {
                ((PatchesItemAuto)localArrayList.get(7)).origByte[2] = localObject7.index_command[0];
                ((PatchesItemAuto)localArrayList.get(7)).origByte[3] = localObject7.index_command[1];
                ((PatchesItemAuto)localArrayList.get(7)).pattern = true;
              }
              if ((((CommandItem)localObject7).object.equals("Landroid/content/Intent;")) && (pattern3))
              {
                ((PatchesItemAuto)localArrayList.get(8)).origByte[2] = localObject7.index_command[0];
                ((PatchesItemAuto)localArrayList.get(8)).origByte[3] = localObject7.index_command[1];
                ((PatchesItemAuto)localArrayList.get(8)).pattern = true;
              }
            }
          }
          if ((n != 0) && (k != 0))
          {
            Utils.getTypesIds(((File)localObject5).getAbsolutePath(), (ArrayList)localObject6, false);
            localObject3 = ((ArrayList)localObject6).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject6 = (TypesItem)((Iterator)localObject3).next();
              if ((((TypesItem)localObject6).found_id_type) && (((TypesItem)localObject6).type.equals("Ljava/security/SignatureSpi;")))
              {
                ((PatchesItemAuto)localArrayList.get(11)).origByte[2] = localObject6.id_type[0];
                ((PatchesItemAuto)localArrayList.get(11)).origByte[3] = localObject6.id_type[1];
                ((PatchesItemAuto)localArrayList.get(11)).pattern = true;
              }
            }
          }
          localObject3 = new PatchesItemAuto[localArrayList.size()];
          k = 0;
          localObject6 = localArrayList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject3[k] = ((PatchesItemAuto)((Iterator)localObject6).next());
            k += 1;
          }
          while (k > 0)
          {
            k -= 1;
            Utils.sendFromRoot("Reworked inapp string!");
            print.println("Reworked inapp string!");
          }
          l2 = System.currentTimeMillis();
          localObject5 = new RandomAccessFile((File)localObject5, "rw").getChannel();
          Utils.sendFromRoot("Size file:" + ((FileChannel)localObject5).size());
          localObject6 = ((FileChannel)localObject5).map(FileChannel.MapMode.READ_WRITE, 0L, (int)((FileChannel)localObject5).size());
          i5 = 0;
          i2 = 0;
          i1 = 0;
          k = 0;
          l1 = 0L;
        }
      }
      else
      {
        for (;;)
        {
          int j;
          try
          {
            if (!((MappedByteBuffer)localObject6).hasRemaining()) {
              continue;
            }
            i3 = k;
            if (!createAPK)
            {
              i3 = k;
              if (((MappedByteBuffer)localObject6).position() - k > 149999)
              {
                Utils.sendFromRoot("Progress size:" + ((MappedByteBuffer)localObject6).position());
                i3 = ((MappedByteBuffer)localObject6).position();
              }
            }
            i6 = ((MappedByteBuffer)localObject6).position();
            j = ((MappedByteBuffer)localObject6).get();
            k = 0;
            i4 = 0;
            if (i4 >= localObject3.length) {
              break label5845;
            }
            localObject7 = localObject3[i4];
            ((MappedByteBuffer)localObject6).position(i6);
            m = k;
            n = i2;
            if (!((PatchesItemAuto)localObject7).markerTrig) {
              break label4424;
            }
            if (i4 == 5) {
              break label6027;
            }
            m = k;
            n = i2;
            if (i4 != 6) {
              break label4424;
            }
          }
          catch (Exception localException4)
          {
            Utils.sendFromRoot("" + localException4);
            ((FileChannel)localObject5).close();
            Utils.sendFromRoot("" + (System.currentTimeMillis() - l2) / 1000L);
            Utils.sendFromRoot("Analise Results:");
          }
          if (n < 60)
          {
            k = n;
            if (j == localObject7.origByte[0])
            {
              if (localObject7.repMask[0] == 0) {
                ((PatchesItemAuto)localObject7).repByte[0] = j;
              }
              i2 = 1;
              ((MappedByteBuffer)localObject6).position(i6 + 1);
              i = ((MappedByteBuffer)localObject6).get();
              if ((i != localObject7.origByte[i2]) && (localObject7.origMask[i2] != 1) && (localObject7.origMask[i2] != 20) && (localObject7.origMask[i2] != 21))
              {
                k = n;
                if (localObject7.origMask[i2] != 23) {}
              }
              else
              {
                if (localObject7.repMask[i2] == 0) {
                  ((PatchesItemAuto)localObject7).repByte[i2] = i;
                }
                if (localObject7.repMask[i2] == 20) {
                  ((PatchesItemAuto)localObject7).repByte[i2] = ((byte)(i & 0xF));
                }
                if (localObject7.repMask[i2] == 21) {
                  ((PatchesItemAuto)localObject7).repByte[i2] = ((byte)((i & 0xF) + 16));
                }
                i2 += 1;
                if (i2 != ((PatchesItemAuto)localObject7).origByte.length) {
                  break label4818;
                }
                ((MappedByteBuffer)localObject6).position(i6);
                ((MappedByteBuffer)localObject6).put(((PatchesItemAuto)localObject7).repByte);
                ((MappedByteBuffer)localObject6).force();
                Utils.sendFromRoot(((PatchesItemAuto)localObject7).resultText);
                print.println(((PatchesItemAuto)localObject7).resultText);
                ((PatchesItemAuto)localObject7).result = true;
                ((PatchesItemAuto)localObject7).markerTrig = false;
                localObject8 = localArrayList.iterator();
                if (((Iterator)localObject8).hasNext())
                {
                  localObject9 = (PatchesItemAuto)((Iterator)localObject8).next();
                  if (!((PatchesItemAuto)localObject9).marker.equals(((PatchesItemAuto)localObject7).marker)) {
                    continue;
                  }
                  ((PatchesItemAuto)localObject9).markerTrig = false;
                  continue;
                  break label1585;
                  break;
                }
                k = 0;
                ((MappedByteBuffer)localObject6).position(i6 + 1);
              }
            }
            ((MappedByteBuffer)localObject6).position(i6 + 1);
            n = k;
          }
          for (;;)
          {
            label4424:
            k = m;
            i2 = i1;
            if (!((PatchesItemAuto)localObject7).markerTrig) {
              break label4930;
            }
            if (i4 != 9)
            {
              k = m;
              i2 = i1;
              if (i4 != 10) {
                break label4930;
              }
            }
            print.println("search jump");
            k = m;
            i2 = i1;
            if (m == 0)
            {
              i2 = i1 + 1;
              k = 1;
            }
            if (i2 >= 90) {
              break label5296;
            }
            m = i2;
            if (j != localObject7.origByte[0]) {
              break label4916;
            }
            if (localObject7.repMask[0] == 0) {
              ((PatchesItemAuto)localObject7).repByte[0] = j;
            }
            i1 = 1;
            ((MappedByteBuffer)localObject6).position(i6 + 1);
            i = ((MappedByteBuffer)localObject6).get();
            if ((i != localObject7.origByte[i1]) && (localObject7.origMask[i1] != 1) && (localObject7.origMask[i1] != 20) && (localObject7.origMask[i1] != 21))
            {
              m = i2;
              if (localObject7.origMask[i1] != 23) {
                break label4916;
              }
            }
            if (localObject7.repMask[i1] == 0) {
              ((PatchesItemAuto)localObject7).repByte[i1] = i;
            }
            if (localObject7.repMask[i1] == 20) {
              ((PatchesItemAuto)localObject7).repByte[i1] = ((byte)(i & 0xF));
            }
            if (localObject7.repMask[i1] == 21) {
              ((PatchesItemAuto)localObject7).repByte[i1] = ((byte)((i & 0xF) + 16));
            }
            i1 += 1;
            if (i1 != ((PatchesItemAuto)localObject7).origByte.length) {
              break label5287;
            }
            ((MappedByteBuffer)localObject6).position(i6);
            ((MappedByteBuffer)localObject6).put(((PatchesItemAuto)localObject7).repByte);
            ((MappedByteBuffer)localObject6).force();
            Utils.sendFromRoot(((PatchesItemAuto)localObject7).resultText);
            print.println(((PatchesItemAuto)localObject7).resultText);
            ((PatchesItemAuto)localObject7).result = true;
            ((PatchesItemAuto)localObject7).markerTrig = false;
            localObject8 = localArrayList.iterator();
            while (((Iterator)localObject8).hasNext())
            {
              localObject9 = (PatchesItemAuto)((Iterator)localObject8).next();
              if (((PatchesItemAuto)localObject9).marker.equals(((PatchesItemAuto)localObject7).marker)) {
                ((PatchesItemAuto)localObject9).markerTrig = false;
              }
            }
            label4818:
            i = ((MappedByteBuffer)localObject6).get();
            break;
            ((PatchesItemAuto)localObject7).markerTrig = false;
            localObject8 = localArrayList.iterator();
            while (((Iterator)localObject8).hasNext())
            {
              localObject9 = (PatchesItemAuto)((Iterator)localObject8).next();
              if (((PatchesItemAuto)localObject9).marker.equals(((PatchesItemAuto)localObject7).marker)) {
                ((PatchesItemAuto)localObject9).markerTrig = false;
              }
            }
            n = 0;
            ((MappedByteBuffer)localObject6).position(i6 + 1);
          }
          m = 0;
          ((MappedByteBuffer)localObject6).position(i6 + 1);
          label4916:
          ((MappedByteBuffer)localObject6).position(i6 + 1);
          i2 = m;
          for (;;)
          {
            label4930:
            m = i5;
            if (!((PatchesItemAuto)localObject7).markerTrig) {
              break label5395;
            }
            m = i5;
            if (i4 != 4) {
              break label5395;
            }
            i5 += 1;
            if (i5 >= 90) {
              break label5747;
            }
            m = i5;
            if (j != localObject7.origByte[0]) {
              break label5385;
            }
            if (localObject7.repMask[0] == 0) {
              ((PatchesItemAuto)localObject7).repByte[0] = j;
            }
            i1 = 1;
            ((MappedByteBuffer)localObject6).position(i6 + 1);
            i = ((MappedByteBuffer)localObject6).get();
            if ((i != localObject7.origByte[i1]) && (localObject7.origMask[i1] != 1) && (localObject7.origMask[i1] != 20) && (localObject7.origMask[i1] != 21))
            {
              m = i5;
              if (localObject7.origMask[i1] != 23) {
                break label5385;
              }
            }
            if (localObject7.repMask[i1] == 0) {
              ((PatchesItemAuto)localObject7).repByte[i1] = i;
            }
            if (localObject7.repMask[i1] == 20) {
              ((PatchesItemAuto)localObject7).repByte[i1] = ((byte)(i & 0xF));
            }
            if (localObject7.repMask[i1] == 21) {
              ((PatchesItemAuto)localObject7).repByte[i1] = ((byte)((i & 0xF) + 16));
            }
            i1 += 1;
            if (i1 != ((PatchesItemAuto)localObject7).origByte.length) {
              break label5738;
            }
            ((MappedByteBuffer)localObject6).position(i6);
            ((MappedByteBuffer)localObject6).put(((PatchesItemAuto)localObject7).repByte);
            ((MappedByteBuffer)localObject6).force();
            Utils.sendFromRoot(((PatchesItemAuto)localObject7).resultText);
            print.println(((PatchesItemAuto)localObject7).resultText);
            ((PatchesItemAuto)localObject7).result = true;
            ((PatchesItemAuto)localObject7).markerTrig = false;
            localObject8 = localArrayList.iterator();
            while (((Iterator)localObject8).hasNext())
            {
              localObject9 = (PatchesItemAuto)((Iterator)localObject8).next();
              if (((PatchesItemAuto)localObject9).marker.equals(((PatchesItemAuto)localObject7).marker)) {
                ((PatchesItemAuto)localObject9).markerTrig = false;
              }
            }
            label5287:
            i = ((MappedByteBuffer)localObject6).get();
            break;
            label5296:
            ((PatchesItemAuto)localObject7).markerTrig = false;
            localObject8 = localArrayList.iterator();
            while (((Iterator)localObject8).hasNext())
            {
              localObject9 = (PatchesItemAuto)((Iterator)localObject8).next();
              if (((PatchesItemAuto)localObject9).marker.equals(((PatchesItemAuto)localObject7).marker)) {
                ((PatchesItemAuto)localObject9).markerTrig = false;
              }
            }
            i2 = 0;
            ((MappedByteBuffer)localObject6).position(i6 + 1);
          }
          m = 0;
          ((MappedByteBuffer)localObject6).position(i6 + 1);
          label5385:
          ((MappedByteBuffer)localObject6).position(i6 + 1);
          label5395:
          if ((((PatchesItemAuto)localObject7).markerTrig) || (j != localObject7.origByte[0]) || (!((PatchesItemAuto)localObject7).pattern)) {
            break label6050;
          }
          if (localObject7.repMask[0] == 0) {
            ((PatchesItemAuto)localObject7).repByte[0] = j;
          }
          i1 = 1;
          ((MappedByteBuffer)localObject6).position(i6 + 1);
          for (int i = ((MappedByteBuffer)localObject6).get();; i = ((MappedByteBuffer)localObject6).get())
          {
            if ((i != localObject7.origByte[i1]) && (localObject7.origMask[i1] != 1) && (localObject7.origMask[i1] != 20) && (localObject7.origMask[i1] != 21) && (localObject7.origMask[i1] != 23)) {
              break label5832;
            }
            if (localObject7.repMask[i1] == 0) {
              ((PatchesItemAuto)localObject7).repByte[i1] = i;
            }
            if (localObject7.repMask[i1] == 20) {
              ((PatchesItemAuto)localObject7).repByte[i1] = ((byte)(i & 0xF));
            }
            if (localObject7.repMask[i1] == 21) {
              ((PatchesItemAuto)localObject7).repByte[i1] = ((byte)((i & 0xF) + 16));
            }
            i1 += 1;
            if (i1 == ((PatchesItemAuto)localObject7).origByte.length)
            {
              ((MappedByteBuffer)localObject6).position(i6);
              ((MappedByteBuffer)localObject6).put(((PatchesItemAuto)localObject7).repByte);
              ((MappedByteBuffer)localObject6).force();
              Utils.sendFromRoot(((PatchesItemAuto)localObject7).resultText);
              print.println(((PatchesItemAuto)localObject7).resultText);
              ((PatchesItemAuto)localObject7).result = true;
              if (((PatchesItemAuto)localObject7).marker.equals("")) {
                break label5832;
              }
              ((PatchesItemAuto)localObject7).markerTrig = true;
              localObject8 = localArrayList.iterator();
              while (((Iterator)localObject8).hasNext())
              {
                localObject9 = (PatchesItemAuto)((Iterator)localObject8).next();
                if (((PatchesItemAuto)localObject9).marker.equals(((PatchesItemAuto)localObject7).marker)) {
                  ((PatchesItemAuto)localObject9).markerTrig = true;
                }
              }
              label5738:
              i = ((MappedByteBuffer)localObject6).get();
              break;
              label5747:
              ((PatchesItemAuto)localObject7).markerTrig = false;
              localObject8 = localArrayList.iterator();
              while (((Iterator)localObject8).hasNext())
              {
                localObject9 = (PatchesItemAuto)((Iterator)localObject8).next();
                if (((PatchesItemAuto)localObject9).marker.equals(((PatchesItemAuto)localObject7).marker)) {
                  ((PatchesItemAuto)localObject9).markerTrig = false;
                }
              }
              m = 0;
              ((MappedByteBuffer)localObject6).position(i6 + 1);
              break label5395;
            }
          }
          label5832:
          ((MappedByteBuffer)localObject6).position(i6 + 1);
          break label6050;
          label5845:
          ((MappedByteBuffer)localObject6).position(i6 + 1);
          l1 += 1L;
          k = i3;
        }
        if (!createAPK)
        {
          Utils.sendFromRoot("Create ODEX:");
          k = Utils.create_ODEX_root(paramArrayOfString[3], classesFiles, paramArrayOfString[2], uid, Utils.getOdexForCreate(paramArrayOfString[2], uid));
          Utils.sendFromRoot("chelpus_return_" + k);
          if ((k == 0) && (!ART)) {
            Utils.afterPatch(paramArrayOfString[1], paramArrayOfString[2], Utils.getPlaceForOdex(paramArrayOfString[2], true), uid, paramArrayOfString[3]);
          }
        }
        Utils.sendFromRoot("Optional Steps After Patch:");
        if (!createAPK) {
          Utils.exitFromRootJava();
        }
        result = localLogOutputStream.allresult;
        return;
      }
    }
    catch (Exception localException5)
    {
      for (;;) {}
    }
    catch (NullPointerException localNullPointerException1)
    {
      for (;;) {}
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
            break label715;
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
          if (((ZipEntry)localObject1).getName().toLowerCase().startsWith("classes"))
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
          j = 1;
          i = j;
          if (!createAPK)
          {
            localZipInputStream.closeEntry();
            ((FileOutputStream)localObject2).close();
            i = j;
          }
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/runpatchsupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */