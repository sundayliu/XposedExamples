package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LACK.CommandItem;
import com.android.vending.billing.InAppBillingService.LACK.LogOutputStream;
import com.android.vending.billing.InAppBillingService.LACK.PatchesItemAuto;
import com.android.vending.billing.InAppBillingService.LACK.StringItem;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class odexrunpatch
{
  public static boolean ART;
  private static boolean amazon;
  public static String appdir = "/sdcard/";
  public static ArrayList<File> classesFiles = new ArrayList();
  public static boolean copyDC;
  private static boolean createAPK = false;
  public static File crkapk;
  private static boolean dependencies;
  public static String dir;
  public static String dirapp;
  public static ArrayList<File> filestopatch;
  private static boolean pattern1 = true;
  private static boolean pattern2 = true;
  private static boolean pattern3 = true;
  private static boolean pattern4 = true;
  private static boolean pattern5 = true;
  private static boolean pattern6 = true;
  public static PrintStream print;
  public static String result;
  private static boolean samsung;
  public static String sddir;
  public static boolean system;
  public static String uid;
  
  static
  {
    dependencies = true;
    amazon = true;
    samsung = true;
    dir = "/sdcard/";
    uid = "";
    filestopatch = null;
    system = false;
    copyDC = false;
    ART = false;
    dirapp = "/data/app/";
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
    ArrayList localArrayList = new ArrayList();
    pattern1 = true;
    pattern2 = true;
    pattern3 = true;
    pattern4 = true;
    pattern5 = true;
    pattern6 = true;
    dependencies = true;
    amazon = true;
    samsung = true;
    filestopatch = new ArrayList();
    try
    {
      File[] arrayOfFile = new File(paramArrayOfString[3]).listFiles();
      int i1 = arrayOfFile.length;
      int n = 0;
      Object localObject1;
      while (n < i1)
      {
        localObject1 = arrayOfFile[n];
        if ((((File)localObject1).isFile()) && (!((File)localObject1).getName().equals("busybox")) && (!((File)localObject1).getName().equals("reboot")) && (!((File)localObject1).getName().equals("dalvikvm"))) {
          ((File)localObject1).delete();
        }
        n += 1;
      }
      try
      {
        if (!paramArrayOfString[1].contains("pattern1")) {
          pattern1 = false;
        }
        if (!paramArrayOfString[1].contains("pattern2")) {
          pattern2 = false;
        }
        if (!paramArrayOfString[1].contains("pattern3")) {
          pattern3 = false;
        }
        if (!paramArrayOfString[1].contains("pattern4")) {
          pattern4 = false;
        }
        if (!paramArrayOfString[1].contains("pattern5")) {
          pattern5 = false;
        }
        if (!paramArrayOfString[1].contains("pattern6")) {
          pattern6 = false;
        }
        if (!paramArrayOfString[1].contains("dependencies")) {
          dependencies = false;
        }
        if (!paramArrayOfString[1].contains("amazon")) {
          amazon = false;
        }
        if (!paramArrayOfString[1].contains("samsung")) {
          samsung = false;
        }
        if (paramArrayOfString[6].contains("createAPK")) {
          createAPK = true;
        }
        if ((paramArrayOfString[6] != null) && (paramArrayOfString[6].contains("ART"))) {
          ART = true;
        }
        if (paramArrayOfString[7] != null) {
          uid = paramArrayOfString[7];
        }
        Utils.sendFromRoot(paramArrayOfString[6]);
      }
      catch (Exception localException4)
      {
        for (;;) {}
      }
      catch (NullPointerException localNullPointerException2)
      {
        for (;;)
        {
          byte[] arrayOfByte2;
          byte[] arrayOfByte3;
          byte[] arrayOfByte4;
          byte[] arrayOfByte5;
          byte[] arrayOfByte6;
          byte[] arrayOfByte7;
          byte[] arrayOfByte8;
          int i10;
          int i2;
          int i7;
          int i3;
          int i4;
          int i9;
          int i5;
          byte b;
          int j;
          int i8;
          continue;
          if (0 != 0) {
            if (i10 == 0)
            {
              continue;
              n = i1 + 1;
              i1 = n;
              if (n > 380)
              {
                i2 = 0;
                i1 = 0;
                continue;
                if (b != localNullPointerException2[n]) {
                  if (new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 }[n] != 0)
                  {
                    continue;
                    if ((arrayOfByte2[n] == 0) || (arrayOfByte2[n] == 2)) {
                      localObject1[n] = b;
                    }
                    if (arrayOfByte2[n] == 3)
                    {
                      i5 = n;
                      j = b;
                      continue;
                      i4 = i5;
                      i3 = n;
                      if (i5 == 0)
                      {
                        i3 = n + 1;
                        i4 = 1;
                        continue;
                        n = 0;
                        continue;
                        n = 0;
                        continue;
                        i5 = 0;
                        continue;
                        i8 += 1;
                        i5 = i4;
                        i7 = n;
                        n = i3;
                        continue;
                        if (b != arrayOfByte3[i5])
                        {
                          i4 = i9;
                          i3 = i2;
                          if (new byte[] { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 }[i5] != 1) {}
                        }
                        else if (arrayOfByte5[i5] == 0)
                        {
                          arrayOfByte4[i5] = b;
                          continue;
                          if (b != arrayOfByte6[i5])
                          {
                            i2 = i3;
                            if (new byte[] { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }[i5] != 1) {}
                          }
                          else if (arrayOfByte8[i5] == 0)
                          {
                            arrayOfByte7[i5] = b;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    try
    {
      if (paramArrayOfString[5].contains("copyDC")) {
        copyDC = true;
      }
      if (createAPK) {
        listAppsFragment.startUnderRoot = Boolean.valueOf(false);
      }
      Object localObject2 = new ArrayList();
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      Object localObject5 = new ArrayList();
      Object localObject6 = new ArrayList();
      Object localObject7 = new ArrayList();
      byte[] arrayOfByte1 = new byte[29];
      byte[] tmp486_484 = arrayOfByte1;
      tmp486_484[0] = 5;
      byte[] tmp491_486 = tmp486_484;
      tmp491_486[1] = 0;
      byte[] tmp496_491 = tmp491_486;
      tmp496_491[2] = 0;
      byte[] tmp501_496 = tmp496_491;
      tmp501_496[3] = 0;
      byte[] tmp506_501 = tmp501_496;
      tmp506_501[4] = 1;
      byte[] tmp511_506 = tmp506_501;
      tmp511_506[5] = 1;
      byte[] tmp516_511 = tmp511_506;
      tmp516_511[6] = 0;
      byte[] tmp522_516 = tmp516_511;
      tmp522_516[7] = 0;
      byte[] tmp528_522 = tmp522_516;
      tmp528_522[8] = 2;
      byte[] tmp534_528 = tmp528_522;
      tmp534_528[9] = 1;
      byte[] tmp540_534 = tmp534_528;
      tmp540_534[10] = 0;
      byte[] tmp546_540 = tmp540_534;
      tmp546_540[11] = 0;
      byte[] tmp552_546 = tmp546_540;
      tmp552_546[12] = 3;
      byte[] tmp558_552 = tmp552_546;
      tmp558_552[13] = 1;
      byte[] tmp564_558 = tmp558_552;
      tmp564_558[14] = 0;
      byte[] tmp570_564 = tmp564_558;
      tmp570_564[15] = 0;
      byte[] tmp576_570 = tmp570_564;
      tmp576_570[16] = 15;
      byte[] tmp582_576 = tmp576_570;
      tmp582_576[17] = 0;
      byte[] tmp588_582 = tmp582_576;
      tmp588_582[18] = 0;
      byte[] tmp594_588 = tmp588_582;
      tmp594_588[19] = 0;
      byte[] tmp600_594 = tmp594_588;
      tmp600_594[20] = 26;
      byte[] tmp606_600 = tmp600_594;
      tmp606_600[21] = 0;
      byte[] tmp612_606 = tmp606_600;
      tmp612_606[22] = 0;
      byte[] tmp618_612 = tmp612_606;
      tmp618_612[23] = 0;
      byte[] tmp624_618 = tmp618_612;
      tmp624_618[24] = 15;
      byte[] tmp630_624 = tmp624_618;
      tmp630_624[25] = 0;
      byte[] tmp636_630 = tmp630_624;
      tmp636_630[26] = 0;
      byte[] tmp642_636 = tmp636_630;
      tmp642_636[27] = 0;
      byte[] tmp648_642 = tmp642_636;
      tmp648_642[28] = 89;
      tmp648_642;
      localObject1 = new byte[29];
      Object tmp664_662 = localObject1;
      tmp664_662[0] = 5;
      Object tmp669_664 = tmp664_662;
      tmp669_664[1] = 0;
      Object tmp674_669 = tmp669_664;
      tmp674_669[2] = 0;
      Object tmp679_674 = tmp674_669;
      tmp679_674[3] = 0;
      Object tmp684_679 = tmp679_674;
      tmp684_679[4] = 1;
      Object tmp689_684 = tmp684_679;
      tmp689_684[5] = 1;
      Object tmp694_689 = tmp689_684;
      tmp694_689[6] = 0;
      Object tmp700_694 = tmp694_689;
      tmp700_694[7] = 0;
      Object tmp706_700 = tmp700_694;
      tmp706_700[8] = 2;
      Object tmp712_706 = tmp706_700;
      tmp712_706[9] = 1;
      Object tmp718_712 = tmp712_706;
      tmp718_712[10] = 0;
      Object tmp724_718 = tmp718_712;
      tmp724_718[11] = 0;
      Object tmp730_724 = tmp724_718;
      tmp730_724[12] = 3;
      Object tmp736_730 = tmp730_724;
      tmp736_730[13] = 1;
      Object tmp742_736 = tmp736_730;
      tmp742_736[14] = 0;
      Object tmp748_742 = tmp742_736;
      tmp748_742[15] = 0;
      Object tmp754_748 = tmp748_742;
      tmp754_748[16] = 15;
      Object tmp760_754 = tmp754_748;
      tmp760_754[17] = 0;
      Object tmp766_760 = tmp760_754;
      tmp766_760[18] = 0;
      Object tmp772_766 = tmp766_760;
      tmp772_766[19] = 0;
      Object tmp778_772 = tmp772_766;
      tmp778_772[20] = 15;
      Object tmp784_778 = tmp778_772;
      tmp784_778[21] = 0;
      Object tmp790_784 = tmp784_778;
      tmp790_784[22] = 0;
      Object tmp796_790 = tmp790_784;
      tmp796_790[23] = 0;
      Object tmp802_796 = tmp796_790;
      tmp802_796[24] = 15;
      Object tmp808_802 = tmp802_796;
      tmp808_802[25] = 0;
      Object tmp814_808 = tmp808_802;
      tmp814_808[26] = 0;
      Object tmp820_814 = tmp814_808;
      tmp820_814[27] = 0;
      Object tmp826_820 = tmp820_814;
      tmp826_820[28] = 89;
      tmp826_820;
      arrayOfByte2 = new byte[29];
      byte[] tmp842_840 = arrayOfByte2;
      tmp842_840[0] = 0;
      byte[] tmp847_842 = tmp842_840;
      tmp847_842[1] = 0;
      byte[] tmp852_847 = tmp847_842;
      tmp852_847[2] = 0;
      byte[] tmp857_852 = tmp852_847;
      tmp857_852[3] = 0;
      byte[] tmp862_857 = tmp857_852;
      tmp862_857[4] = 0;
      byte[] tmp867_862 = tmp862_857;
      tmp867_862[5] = 0;
      byte[] tmp872_867 = tmp867_862;
      tmp872_867[6] = 0;
      byte[] tmp878_872 = tmp872_867;
      tmp878_872[7] = 0;
      byte[] tmp884_878 = tmp878_872;
      tmp884_878[8] = 0;
      byte[] tmp890_884 = tmp884_878;
      tmp890_884[9] = 0;
      byte[] tmp896_890 = tmp890_884;
      tmp896_890[10] = 0;
      byte[] tmp902_896 = tmp896_890;
      tmp902_896[11] = 0;
      byte[] tmp908_902 = tmp902_896;
      tmp908_902[12] = 0;
      byte[] tmp914_908 = tmp908_902;
      tmp914_908[13] = 0;
      byte[] tmp920_914 = tmp914_908;
      tmp920_914[14] = 0;
      byte[] tmp926_920 = tmp920_914;
      tmp926_920[15] = 0;
      byte[] tmp932_926 = tmp926_920;
      tmp932_926[16] = 2;
      byte[] tmp938_932 = tmp932_926;
      tmp938_932[17] = 0;
      byte[] tmp944_938 = tmp938_932;
      tmp944_938[18] = 0;
      byte[] tmp950_944 = tmp944_938;
      tmp950_944[19] = 0;
      byte[] tmp956_950 = tmp950_944;
      tmp956_950[20] = 3;
      byte[] tmp962_956 = tmp956_950;
      tmp962_956[21] = 0;
      byte[] tmp968_962 = tmp962_956;
      tmp968_962[22] = 0;
      byte[] tmp974_968 = tmp968_962;
      tmp974_968[23] = 0;
      byte[] tmp980_974 = tmp974_968;
      tmp980_974[24] = 0;
      byte[] tmp986_980 = tmp980_974;
      tmp986_980[25] = 0;
      byte[] tmp992_986 = tmp986_980;
      tmp992_986[26] = 0;
      byte[] tmp998_992 = tmp992_986;
      tmp998_992[27] = 0;
      byte[] tmp1004_998 = tmp998_992;
      tmp1004_998[28] = 0;
      tmp1004_998;
      ((ArrayList)localObject2).add("1A ?? FF FF");
      ((ArrayList)localObject3).add("1A ?? ?? ??");
      ((ArrayList)localObject4).add(Boolean.valueOf(true));
      ((ArrayList)localObject5).add("(pak intekekt 0)");
      ((ArrayList)localObject6).add("search_pack");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("1B ?? FF FF FF FF");
      ((ArrayList)localObject3).add("1B ?? ?? ?? ?? ??");
      ((ArrayList)localObject4).add(Boolean.valueOf(true));
      ((ArrayList)localObject5).add("(pak intekekt 0)");
      ((ArrayList)localObject6).add("search_pack");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("1A ?? FF FF");
      ((ArrayList)localObject3).add("1A ?? ?? ??");
      ((ArrayList)localObject4).add(Boolean.valueOf(true));
      ((ArrayList)localObject5).add("(sha intekekt 2)");
      ((ArrayList)localObject6).add("search");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("1B ?? FF FF FF FF");
      ((ArrayList)localObject3).add("1B ?? ?? ?? ?? ??");
      ((ArrayList)localObject4).add(Boolean.valueOf(true));
      ((ArrayList)localObject5).add("(sha intekekt 2 32 bit)");
      ((ArrayList)localObject6).add("search");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("0A ?? 39 ?? ?? 00");
      ((ArrayList)localObject3).add("12 S1 39 ?? ?? 00");
      ((ArrayList)localObject4).add(Boolean.valueOf(false));
      ((ArrayList)localObject5).add("lvl patch N2!\n(sha intekekt 3)");
      ((ArrayList)localObject6).add("search");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("6E 20 FF FF ?? 00 0A ??");
      ((ArrayList)localObject3).add("6E 20 ?? ?? ?? 00 12 S1");
      ((ArrayList)localObject4).add(Boolean.valueOf(false));
      ((ArrayList)localObject5).add("support2 Fixed!\n(sha intekekt 4)");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("70 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 62 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 44 00 01 00 2B 00 ?? ?? ?? ?? 62 ?? ?? ?? 11");
      ((ArrayList)localObject3).add("70 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 62 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 12 10 00 00 2B 00 ?? ?? ?? ?? 62 ?? ?? ?? 11");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern3));
      ((ArrayList)localObject5).add("lvl patch N2!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 39 ?? ?? ?? 53 ?? ?? ?? 31");
      ((ArrayList)localObject3).add("12 S1 12 S1 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 39 ?? ?? ?? 53 ?? ?? ?? 31");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern5));
      ((ArrayList)localObject5).add("lvl patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("0a ?? 38 ?? 0e 00 1a ?? ?? ?? 1A ?? ?? ?? 71 ?? ?? ?? ?? ?? 72");
      ((ArrayList)localObject3).add("0a ?? 33 00 ?? ?? 1a ?? ?? ?? 1A ?? ?? ?? 71 ?? ?? ?? ?? ?? 72");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern2));
      ((ArrayList)localObject5).add("lvl patch N4!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("1A ?? ?? ?? 70 ?? ?? ?? ?? ?? 27 ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? 12");
      ((ArrayList)localObject3).add("1A ?? ?? ?? 70 ?? ?? ?? ?? ?? 27 ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? 12");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N5!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 5B ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? 12 ??");
      ((ArrayList)localObject3).add("22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 5B ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? 12 ??");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N5!\nparse response code");
      ((ArrayList)localObject6).add("patch5");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? 31 ?? ?? ?? 3B ?? ?? ?? 01");
      ((ArrayList)localObject3).add("12 S1 12 S1 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? 31 ?? ?? ?? 3B ?? ?? ?? 01");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern5));
      ((ArrayList)localObject5).add("lvl patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 01 ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 01 ?? 28");
      ((ArrayList)localObject3).add("2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 01 ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 01 ?? 28");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N7!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 01 ?? 28");
      ((ArrayList)localObject3).add("2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 01 ?? 28");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N7!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 28");
      ((ArrayList)localObject3).add("2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 28");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N7!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A");
      ((ArrayList)localObject3).add("2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 12");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N7!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 21 ?? 12 ?? 35 ?? ?? ?? 22 ?? ?? ?? 1A ?? ?? ?? 70 ?? ?? ?? ?? ?? 27 ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 5B ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A");
      ((ArrayList)localObject3).add("0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 21 ?? 12 ?? 35 ?? ?? ?? 22 ?? ?? ?? 1A ?? ?? ?? 70 ?? ?? ?? ?? ?? 27 ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 5B ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N5!\n");
      ((ArrayList)localObject6).add("patch5");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      arrayOfByte3 = new byte[32];
      byte[] tmp1983_1981 = arrayOfByte3;
      tmp1983_1981[0] = 26;
      byte[] tmp1988_1983 = tmp1983_1981;
      tmp1988_1983[1] = 102;
      byte[] tmp1994_1988 = tmp1988_1983;
      tmp1994_1988[2] = 102;
      byte[] tmp2000_1994 = tmp1994_1988;
      tmp2000_1994[3] = 102;
      byte[] tmp2006_2000 = tmp2000_1994;
      tmp2006_2000[4] = 113;
      byte[] tmp2012_2006 = tmp2006_2000;
      tmp2012_2006[5] = 102;
      byte[] tmp2018_2012 = tmp2012_2006;
      tmp2018_2012[6] = 102;
      byte[] tmp2025_2018 = tmp2018_2012;
      tmp2025_2018[7] = 102;
      byte[] tmp2032_2025 = tmp2025_2018;
      tmp2032_2025[8] = 102;
      byte[] tmp2039_2032 = tmp2032_2025;
      tmp2039_2032[9] = 102;
      byte[] tmp2046_2039 = tmp2039_2032;
      tmp2046_2039[10] = 12;
      byte[] tmp2053_2046 = tmp2046_2039;
      tmp2053_2046[11] = 102;
      byte[] tmp2060_2053 = tmp2053_2046;
      tmp2060_2053[12] = 113;
      byte[] tmp2067_2060 = tmp2060_2053;
      tmp2067_2060[13] = 102;
      byte[] tmp2074_2067 = tmp2067_2060;
      tmp2074_2067[14] = 102;
      byte[] tmp2081_2074 = tmp2074_2067;
      tmp2081_2074[15] = 102;
      byte[] tmp2088_2081 = tmp2081_2074;
      tmp2088_2081[16] = 102;
      byte[] tmp2095_2088 = tmp2088_2081;
      tmp2095_2088[17] = 102;
      byte[] tmp2102_2095 = tmp2095_2088;
      tmp2102_2095[18] = 12;
      byte[] tmp2109_2102 = tmp2102_2095;
      tmp2109_2102[19] = 102;
      byte[] tmp2116_2109 = tmp2109_2102;
      tmp2116_2109[20] = 33;
      byte[] tmp2123_2116 = tmp2116_2109;
      tmp2123_2116[21] = 102;
      byte[] tmp2130_2123 = tmp2123_2116;
      tmp2130_2123[22] = 102;
      byte[] tmp2137_2130 = tmp2130_2123;
      tmp2137_2130[23] = 102;
      byte[] tmp2144_2137 = tmp2137_2130;
      tmp2144_2137[24] = 53;
      byte[] tmp2151_2144 = tmp2144_2137;
      tmp2151_2144[25] = 102;
      byte[] tmp2158_2151 = tmp2151_2144;
      tmp2158_2151[26] = 102;
      byte[] tmp2165_2158 = tmp2158_2151;
      tmp2165_2158[27] = 102;
      byte[] tmp2172_2165 = tmp2165_2158;
      tmp2172_2165[28] = 34;
      byte[] tmp2179_2172 = tmp2172_2165;
      tmp2179_2172[29] = 102;
      byte[] tmp2186_2179 = tmp2179_2172;
      tmp2186_2179[30] = 102;
      byte[] tmp2193_2186 = tmp2186_2179;
      tmp2193_2186[31] = 102;
      tmp2193_2186;
      arrayOfByte4 = new byte[32];
      byte[] tmp2209_2207 = arrayOfByte4;
      tmp2209_2207[0] = 26;
      byte[] tmp2214_2209 = tmp2209_2207;
      tmp2214_2209[1] = 102;
      byte[] tmp2220_2214 = tmp2214_2209;
      tmp2220_2214[2] = 102;
      byte[] tmp2226_2220 = tmp2220_2214;
      tmp2226_2220[3] = 102;
      byte[] tmp2232_2226 = tmp2226_2220;
      tmp2232_2226[4] = 113;
      byte[] tmp2238_2232 = tmp2232_2226;
      tmp2238_2232[5] = 102;
      byte[] tmp2244_2238 = tmp2238_2232;
      tmp2244_2238[6] = 102;
      byte[] tmp2251_2244 = tmp2244_2238;
      tmp2251_2244[7] = 102;
      byte[] tmp2258_2251 = tmp2251_2244;
      tmp2258_2251[8] = 102;
      byte[] tmp2265_2258 = tmp2258_2251;
      tmp2265_2258[9] = 102;
      byte[] tmp2272_2265 = tmp2265_2258;
      tmp2272_2265[10] = 12;
      byte[] tmp2279_2272 = tmp2272_2265;
      tmp2279_2272[11] = 102;
      byte[] tmp2286_2279 = tmp2279_2272;
      tmp2286_2279[12] = 113;
      byte[] tmp2293_2286 = tmp2286_2279;
      tmp2293_2286[13] = 102;
      byte[] tmp2300_2293 = tmp2293_2286;
      tmp2300_2293[14] = 102;
      byte[] tmp2307_2300 = tmp2300_2293;
      tmp2307_2300[15] = 102;
      byte[] tmp2314_2307 = tmp2307_2300;
      tmp2314_2307[16] = 102;
      byte[] tmp2321_2314 = tmp2314_2307;
      tmp2321_2314[17] = 102;
      byte[] tmp2328_2321 = tmp2321_2314;
      tmp2328_2321[18] = 12;
      byte[] tmp2335_2328 = tmp2328_2321;
      tmp2335_2328[19] = 102;
      byte[] tmp2342_2335 = tmp2335_2328;
      tmp2342_2335[20] = 33;
      byte[] tmp2349_2342 = tmp2342_2335;
      tmp2349_2342[21] = 102;
      byte[] tmp2356_2349 = tmp2349_2342;
      tmp2356_2349[22] = 102;
      byte[] tmp2363_2356 = tmp2356_2349;
      tmp2363_2356[23] = 102;
      byte[] tmp2370_2363 = tmp2363_2356;
      tmp2370_2363[24] = 53;
      byte[] tmp2377_2370 = tmp2370_2363;
      tmp2377_2370[25] = 102;
      byte[] tmp2384_2377 = tmp2377_2370;
      tmp2384_2377[26] = 102;
      byte[] tmp2391_2384 = tmp2384_2377;
      tmp2391_2384[27] = 102;
      byte[] tmp2398_2391 = tmp2391_2384;
      tmp2398_2391[28] = 34;
      byte[] tmp2405_2398 = tmp2398_2391;
      tmp2405_2398[29] = 102;
      byte[] tmp2412_2405 = tmp2405_2398;
      tmp2412_2405[30] = 102;
      byte[] tmp2419_2412 = tmp2412_2405;
      tmp2419_2412[31] = 102;
      tmp2419_2412;
      arrayOfByte5 = new byte[32];
      byte[] tmp2435_2433 = arrayOfByte5;
      tmp2435_2433[0] = 0;
      byte[] tmp2440_2435 = tmp2435_2433;
      tmp2440_2435[1] = 0;
      byte[] tmp2445_2440 = tmp2440_2435;
      tmp2445_2440[2] = 0;
      byte[] tmp2450_2445 = tmp2445_2440;
      tmp2450_2445[3] = 0;
      byte[] tmp2455_2450 = tmp2450_2445;
      tmp2455_2450[4] = 0;
      byte[] tmp2460_2455 = tmp2455_2450;
      tmp2460_2455[5] = 0;
      byte[] tmp2465_2460 = tmp2460_2455;
      tmp2465_2460[6] = 0;
      byte[] tmp2471_2465 = tmp2465_2460;
      tmp2471_2465[7] = 0;
      byte[] tmp2477_2471 = tmp2471_2465;
      tmp2477_2471[8] = 0;
      byte[] tmp2483_2477 = tmp2477_2471;
      tmp2483_2477[9] = 0;
      byte[] tmp2489_2483 = tmp2483_2477;
      tmp2489_2483[10] = 0;
      byte[] tmp2495_2489 = tmp2489_2483;
      tmp2495_2489[11] = 0;
      byte[] tmp2501_2495 = tmp2495_2489;
      tmp2501_2495[12] = 0;
      byte[] tmp2507_2501 = tmp2501_2495;
      tmp2507_2501[13] = 0;
      byte[] tmp2513_2507 = tmp2507_2501;
      tmp2513_2507[14] = 0;
      byte[] tmp2519_2513 = tmp2513_2507;
      tmp2519_2513[15] = 0;
      byte[] tmp2525_2519 = tmp2519_2513;
      tmp2525_2519[16] = 0;
      byte[] tmp2531_2525 = tmp2525_2519;
      tmp2531_2525[17] = 0;
      byte[] tmp2537_2531 = tmp2531_2525;
      tmp2537_2531[18] = 0;
      byte[] tmp2543_2537 = tmp2537_2531;
      tmp2543_2537[19] = 0;
      byte[] tmp2549_2543 = tmp2543_2537;
      tmp2549_2543[20] = 0;
      byte[] tmp2555_2549 = tmp2549_2543;
      tmp2555_2549[21] = 0;
      byte[] tmp2561_2555 = tmp2555_2549;
      tmp2561_2555[22] = 0;
      byte[] tmp2567_2561 = tmp2561_2555;
      tmp2567_2561[23] = 0;
      byte[] tmp2573_2567 = tmp2567_2561;
      tmp2573_2567[24] = 0;
      byte[] tmp2579_2573 = tmp2573_2567;
      tmp2579_2573[25] = 0;
      byte[] tmp2585_2579 = tmp2579_2573;
      tmp2585_2579[26] = 0;
      byte[] tmp2591_2585 = tmp2585_2579;
      tmp2591_2585[27] = 0;
      byte[] tmp2597_2591 = tmp2591_2585;
      tmp2597_2591[28] = 0;
      byte[] tmp2603_2597 = tmp2597_2591;
      tmp2603_2597[29] = 0;
      byte[] tmp2609_2603 = tmp2603_2597;
      tmp2609_2603[30] = 0;
      byte[] tmp2615_2609 = tmp2609_2603;
      tmp2615_2609[31] = 0;
      tmp2615_2609;
      arrayOfByte6 = new byte[13];
      byte[] tmp2630_2628 = arrayOfByte6;
      tmp2630_2628[0] = 0;
      byte[] tmp2635_2630 = tmp2630_2628;
      tmp2635_2630[1] = 70;
      byte[] tmp2641_2635 = tmp2635_2630;
      tmp2641_2635[2] = 102;
      byte[] tmp2647_2641 = tmp2641_2635;
      tmp2647_2641[3] = 102;
      byte[] tmp2653_2647 = tmp2647_2641;
      tmp2653_2647[4] = 102;
      byte[] tmp2659_2653 = tmp2653_2647;
      tmp2659_2653[5] = 113;
      byte[] tmp2665_2659 = tmp2659_2653;
      tmp2665_2659[6] = 102;
      byte[] tmp2672_2665 = tmp2665_2659;
      tmp2672_2665[7] = 102;
      byte[] tmp2679_2672 = tmp2672_2665;
      tmp2679_2672[8] = 102;
      byte[] tmp2686_2679 = tmp2679_2672;
      tmp2686_2679[9] = 102;
      byte[] tmp2693_2686 = tmp2686_2679;
      tmp2693_2686[10] = 102;
      byte[] tmp2700_2693 = tmp2693_2686;
      tmp2700_2693[11] = 10;
      byte[] tmp2707_2700 = tmp2700_2693;
      tmp2707_2700[12] = 102;
      tmp2707_2700;
      arrayOfByte7 = new byte[13];
      byte[] tmp2723_2721 = arrayOfByte7;
      tmp2723_2721[0] = 0;
      byte[] tmp2728_2723 = tmp2723_2721;
      tmp2728_2723[1] = 70;
      byte[] tmp2734_2728 = tmp2728_2723;
      tmp2734_2728[2] = 102;
      byte[] tmp2740_2734 = tmp2734_2728;
      tmp2740_2734[3] = 102;
      byte[] tmp2746_2740 = tmp2740_2734;
      tmp2746_2740[4] = 102;
      byte[] tmp2752_2746 = tmp2746_2740;
      tmp2752_2746[5] = 113;
      byte[] tmp2758_2752 = tmp2752_2746;
      tmp2758_2752[6] = 102;
      byte[] tmp2765_2758 = tmp2758_2752;
      tmp2765_2758[7] = 102;
      byte[] tmp2772_2765 = tmp2765_2758;
      tmp2772_2765[8] = 102;
      byte[] tmp2779_2772 = tmp2772_2765;
      tmp2779_2772[9] = 102;
      byte[] tmp2786_2779 = tmp2779_2772;
      tmp2786_2779[10] = 102;
      byte[] tmp2793_2786 = tmp2786_2779;
      tmp2793_2786[11] = 18;
      byte[] tmp2800_2793 = tmp2793_2786;
      tmp2800_2793[12] = 102;
      tmp2800_2793;
      arrayOfByte8 = new byte[13];
      byte[] tmp2816_2814 = arrayOfByte8;
      tmp2816_2814[0] = 0;
      byte[] tmp2821_2816 = tmp2816_2814;
      tmp2821_2816[1] = 0;
      byte[] tmp2826_2821 = tmp2821_2816;
      tmp2826_2821[2] = 0;
      byte[] tmp2831_2826 = tmp2826_2821;
      tmp2831_2826[3] = 0;
      byte[] tmp2836_2831 = tmp2831_2826;
      tmp2836_2831[4] = 0;
      byte[] tmp2841_2836 = tmp2836_2831;
      tmp2841_2836[5] = 0;
      byte[] tmp2846_2841 = tmp2841_2836;
      tmp2846_2841[6] = 0;
      byte[] tmp2852_2846 = tmp2846_2841;
      tmp2852_2846[7] = 0;
      byte[] tmp2858_2852 = tmp2852_2846;
      tmp2858_2852[8] = 0;
      byte[] tmp2864_2858 = tmp2858_2852;
      tmp2864_2858[9] = 0;
      byte[] tmp2870_2864 = tmp2864_2858;
      tmp2870_2864[10] = 0;
      byte[] tmp2876_2870 = tmp2870_2864;
      tmp2876_2870[11] = 1;
      byte[] tmp2882_2876 = tmp2876_2870;
      tmp2882_2876[12] = 0;
      tmp2882_2876;
      ((ArrayList)localObject2).add("2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 62 ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 62 ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A");
      ((ArrayList)localObject3).add("2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 62 ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 62 ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 12");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N7!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? ?? ?? 33 ?? ?? ?? 53");
      ((ArrayList)localObject3).add("12 S1 12 S1 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? ?? ?? 33 ?? ?? ?? 53");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern5));
      ((ArrayList)localObject5).add("lvl patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("6C 61 63 6B 79 70 61 74 63 68");
      ((ArrayList)localObject3).add("6C 75 63 75 79 70 75 74 63 68");
      ((ArrayList)localObject4).add(Boolean.valueOf(true));
      ((ArrayList)localObject5).add("");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(true));
      ((ArrayList)localObject2).add("6C 75 63 6B 79 70 61 74 63 68");
      ((ArrayList)localObject3).add("6C 75 63 75 79 70 75 74 75 68");
      ((ArrayList)localObject4).add(Boolean.valueOf(true));
      ((ArrayList)localObject5).add("");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(true));
      ((ArrayList)localObject2).add("64 69 6D 6F 6E 76 69 64 65 6F 2E");
      ((ArrayList)localObject3).add("64 69 6D 69 6E 69 69 64 65 6F 2E");
      ((ArrayList)localObject4).add(Boolean.valueOf(true));
      ((ArrayList)localObject5).add("");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(true));
      ((ArrayList)localObject2).add("12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 33 ?? ?? ?? 53 ?? ?? ?? 31");
      ((ArrayList)localObject3).add("12 S1 12 S1 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 33 ?? ?? ?? 53 ?? ?? ?? 31");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern5));
      ((ArrayList)localObject5).add("lvl patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("6E 10 ?? ?? ?? ?? 0A ?? 6E 10 ?? ?? ?? ?? 0C ?? 6E 10 ?? ?? ?? ?? 0C ?? 6E 40");
      ((ArrayList)localObject3).add("6E 10 ?? ?? ?? ?? 12 ?? 6E 10 ?? ?? ?? ?? 0C ?? 6E 10 ?? ?? ?? ?? 0C ?? 6E 40");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N7!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("62 01 ?? ?? 6E 20 ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A 01 71 10 ?? ?? ?? ?? 0C 02 71 10 ?? ?? ?? ?? 6E 10 ?? ?? ?? ?? 0C 02 6E 10 ?? ?? ?? ?? 0C 03 6E 40 ?? ?? ?? ?? 28");
      ((ArrayList)localObject3).add("62 01 ?? ?? 6E 20 ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 12 01 71 10 ?? ?? ?? ?? 0C 02 71 10 ?? ?? ?? ?? 6E 10 ?? ?? ?? ?? 0C 02 6E 10 ?? ?? ?? ?? 0C 03 6E 40 ?? ?? ?? ?? 28");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N7!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 39 ?? ?? ?? 53 ?? ?? ?? 31");
      ((ArrayList)localObject3).add("12 S0 12 S0 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 39 ?? ?? ?? 53 ?? ?? ?? 31");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern6));
      ((ArrayList)localObject5).add("lvl patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 33 ?? ?? ?? 53 ?? ?? ?? 31");
      ((ArrayList)localObject3).add("12 S0 12 S0 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 33 ?? ?? ?? 53 ?? ?? ?? 31");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern6));
      ((ArrayList)localObject5).add("lvl patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? ?? ?? 33 ?? ?? ?? 53");
      ((ArrayList)localObject3).add("12 S0 12 S0 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? ?? ?? 33 ?? ?? ?? 53");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern6));
      ((ArrayList)localObject5).add("lvl patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? 31 ?? ?? ?? 3B ?? ?? ?? 01");
      ((ArrayList)localObject3).add("12 S0 12 S0 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? 31 ?? ?? ?? 3B ?? ?? ?? 01");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern6));
      ((ArrayList)localObject5).add("lvl patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("13 00 00 01 33 R0 ?? ?? 54 ?? ?? ?? 71 10 ?? ?? ?? ?? 0C 01");
      ((ArrayList)localObject3).add("13 W0 00 01 33 00 00 01 54 ?? ?? ?? 71 10 ?? ?? ?? ?? 0C 01");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("1A 05 ?? ?? 63 00 ?? ?? 38 00 09 00 62 00 ?? ?? 1A 01 ?? ?? 6E 20 ?? ?? ?? ?? 54 60 ?? ?? 1A 01 ?? ?? 6E 20 ?? ?? ?? ?? ?? ?? 38 00 0A 00 62 00");
      ((ArrayList)localObject3).add("1A 05 ?? ?? 63 00 ?? ?? 38 00 09 00 62 00 ?? ?? 1A 01 ?? ?? 6E 20 ?? ?? ?? ?? 54 60 ?? ?? 1A 01 ?? ?? 6E 20 ?? ?? ?? ?? ?? ?? 33 00 ?? ?? 62 00");
      ((ArrayList)localObject4).add(Boolean.valueOf(amazon));
      ((ArrayList)localObject5).add("amazon patch N1!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("6E 20 ?? ?? ?? ?? 0C 00 38 00 05 00 12 10 ?? ?? 0F 00 12 00 ?? ?? 0D 00 ?? ?? 27 00");
      ((ArrayList)localObject3).add("6E 20 ?? ?? ?? ?? 0C 00 33 00 ?? ?? 12 10 ?? ?? 0F 00 12 00 ?? ?? 0D 00 ?? ?? 27 00");
      ((ArrayList)localObject4).add(Boolean.valueOf(amazon));
      ((ArrayList)localObject5).add("amazon patch N1!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("13 ?? 09 00 6E ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 32 ?? ?? ?? 59 ?? ?? ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 27");
      ((ArrayList)localObject3).add("13 ?? 09 00 6E ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 32 00 ?? ?? 59 ?? ?? ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 27");
      ((ArrayList)localObject4).add(Boolean.valueOf(samsung));
      ((ArrayList)localObject5).add("samsung patch N1!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("13 ?? 09 00 13 ?? 0B 00 6E ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 32 ?? ?? ?? 59 ?? ?? ?? 22 ?? ?? ?? 12 ?? 70 ?? ?? ?? ?? ?? 27");
      ((ArrayList)localObject3).add("13 ?? 09 00 13 ?? 0B 00 6E ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 32 00 ?? ?? 59 ?? ?? ?? 22 ?? ?? ?? 12 ?? 70 ?? ?? ?? ?? ?? 27");
      ((ArrayList)localObject4).add(Boolean.valueOf(samsung));
      ((ArrayList)localObject5).add("samsung patch N1!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0A ?? 0F ?? 00 00");
      ((ArrayList)localObject3).add("54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 12 S1 0F ?? 00 00");
      ((ArrayList)localObject4).add(Boolean.valueOf(samsung));
      ((ArrayList)localObject5).add("samsung patch N2!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A ?? 0F ?? 00 00");
      ((ArrayList)localObject3).add("54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12 S1 0F ?? 00 00");
      ((ArrayList)localObject4).add(Boolean.valueOf(samsung));
      ((ArrayList)localObject5).add("samsung patch N2!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0A ?? 0F ?? 00 00");
      ((ArrayList)localObject3).add("54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 12 S1 0F ?? 00 00");
      ((ArrayList)localObject4).add(Boolean.valueOf(samsung));
      ((ArrayList)localObject5).add("samsung patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("54 ?? ?? ?? 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ??");
      ((ArrayList)localObject3).add("54 ?? ?? ?? 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A ?? 33 00 ?? ??");
      ((ArrayList)localObject4).add(Boolean.valueOf(samsung));
      ((ArrayList)localObject5).add("samsung patch N3!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("13 ?? 32 00 33 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12");
      ((ArrayList)localObject3).add("13 ?? 32 00 32 00 ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12");
      ((ArrayList)localObject4).add(Boolean.valueOf(samsung));
      ((ArrayList)localObject5).add("samsung patch N4!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("13 ?? 32 00 33 ?? ?? ?? 70 ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 54 ?? ?? ?? 59 ?? ?? ?? ?? ?? 28");
      ((ArrayList)localObject3).add("13 ?? 32 00 32 00 ?? ?? 70 ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 54 ?? ?? ?? 59 ?? ?? ?? ?? ?? 28");
      ((ArrayList)localObject4).add(Boolean.valueOf(samsung));
      ((ArrayList)localObject5).add("samsung patch N4!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      ((ArrayList)localObject2).add("38 ?? 06 00 32 ?? 04 00 33 ?? ?? ?? 1A ?? ?? ?? 71");
      ((ArrayList)localObject3).add("12 ?? 00 00 32 00 04 00 33 ?? ?? ?? ?? ?? ?? ?? ??");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N6!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(false));
      if (!paramArrayOfString[0].contains("com.buak.Link2SD"))
      {
        ((ArrayList)localObject2).add("00 05 2E 6F 64 65 78 00");
        ((ArrayList)localObject3).add("00 05 2E 6F 64 65 79 00");
        ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
        ((ArrayList)localObject5).add("lvl patch N7!\n");
        ((ArrayList)localObject6).add("");
        ((ArrayList)localObject7).add(Boolean.valueOf(true));
      }
      ((ArrayList)localObject2).add("00 04 6F 64 65 78 00");
      ((ArrayList)localObject3).add("00 04 6F 64 65 79 00");
      ((ArrayList)localObject4).add(Boolean.valueOf(pattern4));
      ((ArrayList)localObject5).add("lvl patch N7!\n");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(true));
      ((ArrayList)localObject2).add("2F 4C 75 63 6B 79 50 61 74 63 68 65 72");
      ((ArrayList)localObject3).add("2F 4C 75 63 6B 79 50 79 74 63 68 65 72");
      ((ArrayList)localObject4).add(Boolean.valueOf(true));
      ((ArrayList)localObject5).add("");
      ((ArrayList)localObject6).add("");
      ((ArrayList)localObject7).add(Boolean.valueOf(true));
      if (!ART)
      {
        ((ArrayList)localObject2).add("13 ?? 09 00 12 ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ??");
        ((ArrayList)localObject3).add("12 00 0F 00 12 ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ??");
        ((ArrayList)localObject4).add(Boolean.valueOf(dependencies));
        ((ArrayList)localObject5).add("com.android.vending dependencies removed\n");
        ((ArrayList)localObject6).add("");
        ((ArrayList)localObject7).add(Boolean.valueOf(true));
        ((ArrayList)localObject2).add("12 ?? 12 ?? 13 ?? 09 00 6E ?? ?? ?? ?? ?? 0C ??");
        ((ArrayList)localObject3).add("12 ?? 12 ?? 12 00 0F 00 6E ?? ?? ?? ?? ?? 0C ??");
        ((ArrayList)localObject4).add(Boolean.valueOf(dependencies));
        ((ArrayList)localObject5).add("com.android.vending dependencies removed\n");
        ((ArrayList)localObject6).add("");
        ((ArrayList)localObject7).add(Boolean.valueOf(true));
      }
      for (;;)
      {
        Utils.convertToPatchItemAuto(localArrayList, (ArrayList)localObject2, (ArrayList)localObject3, (ArrayList)localObject4, (ArrayList)localObject5, (ArrayList)localObject6, (ArrayList)localObject7, Boolean.valueOf(false));
        try
        {
          if (listAppsFragment.startUnderRoot.booleanValue()) {
            Utils.remount(paramArrayOfString[2], "RW");
          }
          if ((createAPK) || (ART)) {
            break label5380;
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
          localObject2 = paramArrayOfString[0];
          appdir = paramArrayOfString[2];
          sddir = paramArrayOfString[3];
          clearTempSD();
          localObject2 = new File(appdir);
          Utils.sendFromRoot("Get classes.dex.");
          print.println("Get classes.dex.");
          unzipART((File)localObject2);
          if ((classesFiles == null) || (classesFiles.size() == 0)) {
            throw new FileNotFoundException();
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          Utils.sendFromRoot("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
          localFileNotFoundException.printStackTrace();
          Iterator localIterator1 = filestopatch.iterator();
          while (localIterator1.hasNext())
          {
            Utils.fixadler((File)localIterator1.next());
            clearTempSD();
          }
          ((ArrayList)localObject2).add("13 ?? 09 00 12 ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ??");
          ((ArrayList)localObject3).add("12 S0 00 00 12 S0 12 S0 6E ?? ?? ?? ?? ?? 0C ??");
          ((ArrayList)localObject4).add(Boolean.valueOf(dependencies));
          ((ArrayList)localObject5).add("com.android.vending dependencies removed\n");
          ((ArrayList)localObject6).add("");
          ((ArrayList)localObject7).add(Boolean.valueOf(true));
          ((ArrayList)localObject2).add("12 ?? 12 ?? 13 ?? 09 00 6E ?? ?? ?? ?? ?? 0C ??");
          ((ArrayList)localObject3).add("12 S0 12 S0 12 S0 00 00 6E ?? ?? ?? ?? ?? 0C ??");
          ((ArrayList)localObject4).add(Boolean.valueOf(dependencies));
          ((ArrayList)localObject5).add("com.android.vending dependencies removed\n");
          ((ArrayList)localObject6).add("");
          ((ArrayList)localObject7).add(Boolean.valueOf(true));
          continue;
          filestopatch.clear();
          localObject2 = classesFiles.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (File)((Iterator)localObject2).next();
            if (!((File)localObject3).exists()) {
              throw new FileNotFoundException();
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Utils.sendFromRoot("Exception e" + localException1.toString());
            localException1.printStackTrace();
            localException1.printStackTrace();
            continue;
            filestopatch.add(localObject3);
          }
          localObject2 = Utils.getPlaceForOdex(paramArrayOfString[2], true);
          localObject3 = new File((String)localObject2);
          if (((File)localObject3).exists()) {
            ((File)localObject3).delete();
          }
          localObject3 = new File(((String)localObject2).replace("-1", "-2"));
          if (((File)localObject3).exists()) {
            ((File)localObject3).delete();
          }
          localObject2 = new File(((String)localObject2).replace("-2", "-1"));
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
        }
      }
      localObject2 = filestopatch.iterator();
      label5121:
      CommandItem localCommandItem;
      label5380:
      long l;
      if (((Iterator)localObject2).hasNext())
      {
        localObject4 = (File)((Iterator)localObject2).next();
        Utils.sendFromRoot("Find string id.");
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add("com.android.vending");
        ((ArrayList)localObject3).add("SHA1withRSA");
        ((ArrayList)localObject3).add("com.android.vending.billing.InAppBillingService.BIND");
        ((ArrayList)localObject3).add("Ljava/security/Signature;");
        ((ArrayList)localObject3).add("verify");
        Utils.sendFromRoot("String analysis.");
        print.println("String analysis.");
        localObject5 = Utils.getStringIds(((File)localObject4).getAbsolutePath(), (ArrayList)localObject3, false);
        i10 = 0;
        n = 0;
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(new CommandItem("Ljava/security/Signature;", "verify"));
        localObject5 = ((ArrayList)localObject5).iterator();
        for (;;)
        {
          if (!((Iterator)localObject5).hasNext()) {
            break label9002;
          }
          localObject6 = (StringItem)((Iterator)localObject5).next();
          localObject7 = ((ArrayList)localObject3).iterator();
          for (;;)
          {
            if (((Iterator)localObject7).hasNext())
            {
              localCommandItem = (CommandItem)((Iterator)localObject7).next();
              if (localCommandItem.object.equals(((StringItem)localObject6).str)) {
                localCommandItem.Object = ((StringItem)localObject6).offset;
              }
              if (localCommandItem.method.equals(((StringItem)localObject6).str))
              {
                localCommandItem.Method = ((StringItem)localObject6).offset;
                continue;
                if (createAPK)
                {
                  localObject2 = paramArrayOfString[0];
                  appdir = paramArrayOfString[2];
                  sddir = paramArrayOfString[5];
                  clearTempSD();
                  localObject3 = new File(appdir);
                  unzipSD((File)localObject3);
                  crkapk = new File(sddir + "/Modified/" + (String)localObject2 + ".apk");
                  Utils.copyFile((File)localObject3, crkapk);
                  if ((classesFiles == null) || (classesFiles.size() == 0)) {
                    throw new FileNotFoundException();
                  }
                  filestopatch.clear();
                  localObject2 = classesFiles.iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject3 = (File)((Iterator)localObject2).next();
                    if (!((File)localObject3).exists()) {
                      throw new FileNotFoundException();
                    }
                    filestopatch.add(localObject3);
                  }
                }
                if (!ART) {
                  break;
                }
                localObject2 = paramArrayOfString[0];
                appdir = paramArrayOfString[2];
                sddir = paramArrayOfString[3];
                clearTempSD();
                unzipART(new File(appdir));
                if ((classesFiles == null) || (classesFiles.size() == 0)) {
                  throw new FileNotFoundException();
                }
                filestopatch.clear();
                localObject2 = classesFiles.iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (File)((Iterator)localObject2).next();
                  if (!((File)localObject3).exists()) {
                    throw new FileNotFoundException();
                  }
                  filestopatch.add(localObject3);
                }
                break;
              }
            }
          }
          int i11 = i10;
          if (((StringItem)localObject6).str.equals("com.android.vending.billing.InAppBillingService.BIND"))
          {
            ((PatchesItemAuto)localException1.get(0)).origByte[2] = localObject6.offset[0];
            ((PatchesItemAuto)localException1.get(0)).origByte[3] = localObject6.offset[1];
            ((PatchesItemAuto)localException1.get(1)).origByte[2] = localObject6.offset[0];
            ((PatchesItemAuto)localException1.get(1)).origByte[3] = localObject6.offset[1];
            ((PatchesItemAuto)localException1.get(1)).origByte[4] = localObject6.offset[2];
            ((PatchesItemAuto)localException1.get(1)).origByte[5] = localObject6.offset[3];
            i11 = 0;
          }
          i10 = i11;
          if (((StringItem)localObject6).str.equals("SHA1withRSA"))
          {
            ((PatchesItemAuto)localException1.get(2)).origByte[2] = localObject6.offset[0];
            ((PatchesItemAuto)localException1.get(2)).origByte[3] = localObject6.offset[1];
            ((PatchesItemAuto)localException1.get(3)).origByte[2] = localObject6.offset[0];
            ((PatchesItemAuto)localException1.get(3)).origByte[3] = localObject6.offset[1];
            ((PatchesItemAuto)localException1.get(3)).origByte[4] = localObject6.offset[2];
            ((PatchesItemAuto)localException1.get(3)).origByte[5] = localObject6.offset[3];
            n = 1;
            i10 = i11;
          }
        }
        ((PatchesItemAuto)localException1.get(0)).pattern = false;
        ((PatchesItemAuto)localException1.get(1)).pattern = false;
        if (n == 0)
        {
          ((PatchesItemAuto)localException1.get(2)).pattern = false;
          ((PatchesItemAuto)localException1.get(3)).pattern = false;
          ((PatchesItemAuto)localException1.get(4)).pattern = false;
        }
        Utils.sendFromRoot("Parse data for patch.");
        print.println("Parse data for patch.");
        Utils.getMethodsIds(((File)localObject4).getAbsolutePath(), (ArrayList)localObject3, false, false);
        System.out.println(Integer.toHexString(((CommandItem)localObject3.get(0)).index_command[0]));
        System.out.println(Integer.toHexString(((CommandItem)localObject3.get(0)).index_command[1]));
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (CommandItem)((Iterator)localObject3).next();
          if ((((CommandItem)localObject5).found_index_command) && (((CommandItem)localObject5).object.equals("Ljava/security/Signature;")))
          {
            ((PatchesItemAuto)localException1.get(11)).origByte[2] = localObject5.index_command[0];
            ((PatchesItemAuto)localException1.get(11)).origByte[3] = localObject5.index_command[1];
            ((PatchesItemAuto)localException1.get(11)).pattern = true;
          }
        }
        localObject3 = new PatchesItemAuto[localException1.size()];
        n = 0;
        localObject5 = localException1.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject3[n] = ((PatchesItemAuto)((Iterator)localObject5).next());
          n += 1;
        }
        l = System.currentTimeMillis();
        localObject4 = new RandomAccessFile((File)localObject4, "rw").getChannel();
        Utils.sendFromRoot("Size file:" + ((FileChannel)localObject4).size());
        localObject5 = ((FileChannel)localObject4).map(FileChannel.MapMode.READ_WRITE, 0L, (int)((FileChannel)localObject4).size());
        i2 = 0;
        i7 = 0;
        i3 = 0;
        i1 = 0;
        i4 = 0;
      }
      for (;;)
      {
        int i6;
        int m;
        try
        {
          if (!((MappedByteBuffer)localObject5).hasRemaining()) {
            continue;
          }
          i6 = i4;
          if (!createAPK)
          {
            i6 = i4;
            if (((MappedByteBuffer)localObject5).position() - i4 > 149999)
            {
              Utils.sendFromRoot("Progress size:" + ((MappedByteBuffer)localObject5).position());
              i6 = ((MappedByteBuffer)localObject5).position();
            }
          }
          i9 = ((MappedByteBuffer)localObject5).position();
          m = ((MappedByteBuffer)localObject5).get();
          if (i2 != 0) {
            break label9014;
          }
          n = i1;
          if (0 == 0) {
            break label9020;
          }
        }
        catch (Exception localException5)
        {
          int k;
          int i;
          Utils.sendFromRoot("" + localException5);
          localException5.printStackTrace();
          ((FileChannel)localObject4).close();
          Utils.sendFromRoot("" + (System.currentTimeMillis() - l) / 1000L);
          Utils.sendFromRoot("Analise Results:");
        }
        if ((m == arrayOfByte1[0]) && (pattern1))
        {
          if (arrayOfByte2[0] == 0) {
            localObject1[0] = m;
          }
          n = 1;
          i5 = 1000;
          i4 = 1000;
          ((MappedByteBuffer)localObject5).position(i9 + 1);
          b = ((MappedByteBuffer)localObject5).get();
          k = 0;
          j = 0;
          break label9041;
          i8 = i4;
          i = k;
          if (arrayOfByte2[n] != 2) {
            break label9231;
          }
          i8 = i4;
          i = k;
          if (b != ((MappedByteBuffer)localObject5).get(((MappedByteBuffer)localObject5).position() + 7)) {
            break label9231;
          }
          i8 = n;
          i = b;
          break label9231;
          n += 1;
          if (n != arrayOfByte1.length) {
            continue;
          }
          if ((i5 < 1000) && (j != 0))
          {
            localObject1[i5] = i;
            if ((i8 + 7 < 1000) && (i != 0))
            {
              localObject1[(i8 + 8)] = j;
              ((MappedByteBuffer)localObject5).position(i9);
              ((MappedByteBuffer)localObject5).put((byte[])localObject1);
              ((MappedByteBuffer)localObject5).force();
              Utils.sendFromRoot("lvl patch N1!\n");
              print.print("lvl patch N1!\n");
            }
          }
        }
        localObject6 = new ArrayList();
        localObject7 = new ArrayList();
        i5 = 0;
        i8 = 0;
        n = i3;
        if (i8 < localObject3.length)
        {
          localCommandItem = localObject3[i8];
          ((MappedByteBuffer)localObject5).position(i9);
          i4 = i5;
          i3 = n;
          PatchesItemAuto localPatchesItemAuto;
          if (localCommandItem.markerTrig)
          {
            if ((i8 == 5) || (i8 == 6) || (i8 == 7) || (i8 == 8) || (i8 == 9)) {
              break label9272;
            }
            i4 = i5;
            i3 = n;
            if (i8 == 10)
            {
              break label9272;
              if (i3 >= 40) {
                break label7811;
              }
              n = i3;
              if (m == localCommandItem.origByte[0])
              {
                ((ArrayList)localObject6).clear();
                ((ArrayList)localObject7).clear();
                if (localCommandItem.repMask[0] == 0) {
                  localCommandItem.repByte[0] = m;
                }
                i5 = 1;
                ((MappedByteBuffer)localObject5).position(i9 + 1);
                b = ((MappedByteBuffer)localObject5).get();
                if ((b != localCommandItem.origByte[i5]) && (localCommandItem.origMask[i5] != 1) && (localCommandItem.origMask[i5] != 20) && (localCommandItem.origMask[i5] != 21))
                {
                  n = i3;
                  if (localCommandItem.origMask[i5] != 23) {}
                }
                else
                {
                  if (localCommandItem.repMask[i5] == 0) {
                    localCommandItem.repByte[i5] = b;
                  }
                  if (localCommandItem.repMask[i5] == 20) {
                    localCommandItem.repByte[i5] = ((byte)(b & 0xF));
                  }
                  if (localCommandItem.repMask[i5] == 21) {
                    localCommandItem.repByte[i5] = ((byte)((b & 0xF) + 16));
                  }
                  if (localCommandItem.origMask[i5] == 23) {
                    ((ArrayList)localObject6).add(localCommandItem.origByte[i5], Byte.valueOf(b));
                  }
                  if (localCommandItem.repMask[i5] == 23) {
                    ((ArrayList)localObject7).add(localCommandItem.repByte[i5], Integer.valueOf(i5));
                  }
                  i5 += 1;
                  if (i5 != localCommandItem.origByte.length) {
                    break label7802;
                  }
                  if (((ArrayList)localObject6).size() > 0) {
                    break label9297;
                  }
                  if (((ArrayList)localObject7).size() > 0)
                  {
                    break label9297;
                    if (n < ((ArrayList)localObject6).size())
                    {
                      localCommandItem.repByte[((Integer)localObject7.get(n)).intValue()] = ((Byte)((ArrayList)localObject6).get(n)).byteValue();
                      n += 1;
                      continue;
                      b = ((MappedByteBuffer)localObject5).get();
                      i4 = i8;
                      k = i;
                      break label9041;
                    }
                    ((ArrayList)localObject6).clear();
                    ((ArrayList)localObject7).clear();
                  }
                  ((MappedByteBuffer)localObject5).position(i9);
                  ((MappedByteBuffer)localObject5).put(localCommandItem.repByte);
                  ((MappedByteBuffer)localObject5).force();
                  Utils.sendFromRoot(localCommandItem.resultText);
                  print.println(localCommandItem.resultText);
                  localCommandItem.result = true;
                  localCommandItem.markerTrig = false;
                  localIterator2 = localException1.iterator();
                  if (localIterator2.hasNext())
                  {
                    localPatchesItemAuto = (PatchesItemAuto)localIterator2.next();
                    if (!localPatchesItemAuto.marker.equals(localCommandItem.marker)) {
                      continue;
                    }
                    localPatchesItemAuto.markerTrig = false;
                    continue;
                    break label5121;
                    break;
                  }
                  n = 0;
                  ((MappedByteBuffer)localObject5).position(i9 + 1);
                }
              }
              ((MappedByteBuffer)localObject5).position(i9 + 1);
              i3 = n;
            }
          }
          for (;;)
          {
            n = i7;
            if (!localCommandItem.markerTrig) {
              break label8031;
            }
            n = i7;
            if (i8 != 4) {
              break label8031;
            }
            i7 += 1;
            if (i7 >= 90) {
              break label8402;
            }
            n = i7;
            if (m != localCommandItem.origByte[0]) {
              break label8021;
            }
            ((ArrayList)localObject6).clear();
            ((ArrayList)localObject7).clear();
            if (localCommandItem.repMask[0] == 0) {
              localCommandItem.repByte[0] = m;
            }
            i5 = 1;
            ((MappedByteBuffer)localObject5).position(i9 + 1);
            b = ((MappedByteBuffer)localObject5).get();
            if ((b != localCommandItem.origByte[i5]) && (localCommandItem.origMask[i5] != 1) && (localCommandItem.origMask[i5] != 20) && (localCommandItem.origMask[i5] != 21))
            {
              n = i7;
              if (localCommandItem.origMask[i5] != 23) {
                break label8021;
              }
            }
            if (localCommandItem.repMask[i5] == 0) {
              localCommandItem.repByte[i5] = b;
            }
            if (localCommandItem.repMask[i5] == 20) {
              localCommandItem.repByte[i5] = ((byte)(b & 0xF));
            }
            if (localCommandItem.repMask[i5] == 21) {
              localCommandItem.repByte[i5] = ((byte)((b & 0xF) + 16));
            }
            if (localCommandItem.origMask[i5] == 23) {
              ((ArrayList)localObject6).add(localCommandItem.origByte[i5], Byte.valueOf(b));
            }
            if (localCommandItem.repMask[i5] == 23) {
              ((ArrayList)localObject7).add(localCommandItem.repByte[i5], Integer.valueOf(i5));
            }
            i5 += 1;
            if (i5 != localCommandItem.origByte.length) {
              break label8393;
            }
            if (((ArrayList)localObject6).size() > 0) {
              break label9303;
            }
            if (((ArrayList)localObject7).size() <= 0) {
              break label7897;
            }
            break label9303;
            while (n < ((ArrayList)localObject6).size())
            {
              localCommandItem.repByte[((Integer)localObject7.get(n)).intValue()] = ((Byte)((ArrayList)localObject6).get(n)).byteValue();
              n += 1;
            }
            label7802:
            b = ((MappedByteBuffer)localObject5).get();
            break;
            label7811:
            localCommandItem.markerTrig = false;
            localIterator2 = localException1.iterator();
            while (localIterator2.hasNext())
            {
              localPatchesItemAuto = (PatchesItemAuto)localIterator2.next();
              if (localPatchesItemAuto.marker.equals(localCommandItem.marker)) {
                localPatchesItemAuto.markerTrig = false;
              }
            }
            i3 = 0;
            ((MappedByteBuffer)localObject5).position(i9 + 1);
          }
          ((ArrayList)localObject6).clear();
          ((ArrayList)localObject7).clear();
          label7897:
          ((MappedByteBuffer)localObject5).position(i9);
          ((MappedByteBuffer)localObject5).put(localCommandItem.repByte);
          ((MappedByteBuffer)localObject5).force();
          Utils.sendFromRoot(localCommandItem.resultText);
          print.println(localCommandItem.resultText);
          localCommandItem.result = true;
          localCommandItem.markerTrig = false;
          Iterator localIterator2 = localException1.iterator();
          while (localIterator2.hasNext())
          {
            localPatchesItemAuto = (PatchesItemAuto)localIterator2.next();
            if (localPatchesItemAuto.marker.equals(localCommandItem.marker)) {
              localPatchesItemAuto.markerTrig = false;
            }
          }
          n = 0;
          ((MappedByteBuffer)localObject5).position(i9 + 1);
          label8021:
          ((MappedByteBuffer)localObject5).position(i9 + 1);
          label8031:
          if ((localCommandItem.markerTrig) || (m != localCommandItem.origByte[0]) || (!localCommandItem.pattern)) {
            break label9315;
          }
          ((ArrayList)localObject6).clear();
          ((ArrayList)localObject7).clear();
          if (localCommandItem.repMask[0] == 0) {
            localCommandItem.repByte[0] = m;
          }
          i5 = 1;
          ((MappedByteBuffer)localObject5).position(i9 + 1);
          for (b = ((MappedByteBuffer)localObject5).get();; b = ((MappedByteBuffer)localObject5).get())
          {
            if ((b != localCommandItem.origByte[i5]) && (localCommandItem.origMask[i5] != 1) && (localCommandItem.origMask[i5] != 20) && (localCommandItem.origMask[i5] != 21) && (localCommandItem.origMask[i5] != 23)) {
              break label8621;
            }
            if (localCommandItem.repMask[i5] == 0) {
              localCommandItem.repByte[i5] = b;
            }
            if (localCommandItem.repMask[i5] == 20) {
              localCommandItem.repByte[i5] = ((byte)(b & 0xF));
            }
            if (localCommandItem.repMask[i5] == 21) {
              localCommandItem.repByte[i5] = ((byte)((b & 0xF) + 16));
            }
            if (localCommandItem.origMask[i5] == 23) {
              ((ArrayList)localObject6).add(localCommandItem.origByte[i5], Byte.valueOf(b));
            }
            if (localCommandItem.repMask[i5] == 23) {
              ((ArrayList)localObject7).add(localCommandItem.repByte[i5], Integer.valueOf(i5));
            }
            i5 += 1;
            if (i5 == localCommandItem.origByte.length)
            {
              if (((ArrayList)localObject6).size() > 0) {
                break label9309;
              }
              if (((ArrayList)localObject7).size() > 0)
              {
                break label9309;
                for (;;)
                {
                  if (i5 < ((ArrayList)localObject6).size())
                  {
                    localCommandItem.repByte[((Integer)localObject7.get(i5)).intValue()] = ((Byte)((ArrayList)localObject6).get(i5)).byteValue();
                    i5 += 1;
                    continue;
                    label8393:
                    b = ((MappedByteBuffer)localObject5).get();
                    break;
                    label8402:
                    localCommandItem.markerTrig = false;
                    localIterator2 = localException1.iterator();
                    while (localIterator2.hasNext())
                    {
                      localPatchesItemAuto = (PatchesItemAuto)localIterator2.next();
                      if (localPatchesItemAuto.marker.equals(localCommandItem.marker)) {
                        localPatchesItemAuto.markerTrig = false;
                      }
                    }
                    n = 0;
                    ((MappedByteBuffer)localObject5).position(i9 + 1);
                    break label8031;
                  }
                }
                ((ArrayList)localObject6).clear();
                ((ArrayList)localObject7).clear();
              }
              ((MappedByteBuffer)localObject5).position(i9);
              ((MappedByteBuffer)localObject5).put(localCommandItem.repByte);
              ((MappedByteBuffer)localObject5).force();
              Utils.sendFromRoot(localCommandItem.resultText);
              print.println(localCommandItem.resultText);
              localCommandItem.result = true;
              if (localCommandItem.marker.equals("")) {
                break label8621;
              }
              localCommandItem.markerTrig = true;
              localIterator2 = localException1.iterator();
              while (localIterator2.hasNext())
              {
                localPatchesItemAuto = (PatchesItemAuto)localIterator2.next();
                if (localPatchesItemAuto.marker.equals(localCommandItem.marker)) {
                  localPatchesItemAuto.markerTrig = true;
                }
              }
            }
          }
          label8621:
          ((MappedByteBuffer)localObject5).position(i9 + 1);
          break label9315;
        }
        i4 = i9;
        i3 = i2;
        if (m == arrayOfByte3[0])
        {
          i4 = i9;
          i3 = i2;
          if (pattern4)
          {
            if (arrayOfByte5[0] == 0) {
              arrayOfByte4[0] = m;
            }
            i5 = 1;
            ((MappedByteBuffer)localObject5).position(i9 + 1);
            b = ((MappedByteBuffer)localObject5).get();
            break label9336;
            i5 += 1;
            if (i5 != arrayOfByte3.length) {
              break label8856;
            }
            i4 = ((MappedByteBuffer)localObject5).position();
            i3 = 1;
          }
        }
        i2 = i3;
        if (m < 16)
        {
          i2 = i3;
          if (i3 != 0)
          {
            i2 = i3;
            if (pattern4)
            {
              if (arrayOfByte8[0] == 0) {
                arrayOfByte7[0] = m;
              }
              i5 = 1;
              ((MappedByteBuffer)localObject5).position(i4 + 1);
              b = ((MappedByteBuffer)localObject5).get();
              break label9567;
              i5 += 1;
              if (i5 != arrayOfByte6.length) {
                break label8865;
              }
              ((MappedByteBuffer)localObject5).position(i4);
              ((MappedByteBuffer)localObject5).put(arrayOfByte7);
              ((MappedByteBuffer)localObject5).force();
              Utils.sendFromRoot("lvl patch N5!\n");
              i2 = 0;
            }
          }
        }
        ((MappedByteBuffer)localObject5).position(i4 + 1);
        i4 = i6;
        i3 = n;
      }
      label8856:
      b = ((MappedByteBuffer)localObject5).get();
      break label9336;
      label8865:
      b = ((MappedByteBuffer)localObject5).get();
      break label9567;
      if (!createAPK)
      {
        n = Utils.create_ODEX_root(paramArrayOfString[3], classesFiles, paramArrayOfString[2], uid, Utils.getOdexForCreate(paramArrayOfString[2], uid));
        Utils.sendFromRoot("chelpus_return_" + n);
        if ((n == 0) && (!ART)) {
          Utils.afterPatch(paramArrayOfString[1], paramArrayOfString[2], Utils.getPlaceForOdex(paramArrayOfString[2], true), uid, paramArrayOfString[3]);
        }
      }
      if (!createAPK) {
        Utils.exitFromRootJava();
      }
      result = localLogOutputStream.allresult;
      return;
    }
    catch (Exception localException3)
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
      localZipInputStream = new ZipInputStream(localFileInputStream);
      do
      {
        localZipEntry = localZipInputStream.getNextEntry();
        if (localZipEntry == null) {
          break;
        }
      } while ((!localZipEntry.getName().toLowerCase().startsWith("classes")) || (!localZipEntry.getName().endsWith(".dex")) || (localZipEntry.getName().contains("/")));
      localFileOutputStream = new FileOutputStream(sddir + "/Modified/" + localZipEntry.getName());
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = localZipInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          new ZipFile(paramFile).extractFile("classes.dex", sddir + "/Modified/");
          classesFiles.add(new File(sddir + "/Modified/" + "classes.dex"));
          return;
        }
        catch (ZipException paramFile)
        {
          ZipInputStream localZipInputStream;
          ZipEntry localZipEntry;
          FileOutputStream localFileOutputStream;
          Utils.sendFromRoot("Error classes.dex decompress! " + paramFile);
          Utils.sendFromRoot("Exception e1" + localException.toString());
          return;
        }
        catch (Exception paramFile)
        {
          Utils.sendFromRoot("Error classes.dex decompress! " + paramFile);
          Utils.sendFromRoot("Exception e1" + localException.toString());
        }
        localZipInputStream.closeEntry();
        localFileOutputStream.close();
        classesFiles.add(new File(sddir + "/Modified/" + localZipEntry.getName()));
        continue;
        localZipInputStream.close();
        localException.close();
        return;
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/odexrunpatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */