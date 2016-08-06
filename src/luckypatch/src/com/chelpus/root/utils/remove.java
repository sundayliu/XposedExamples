package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class remove
{
  private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
  
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    byte[] arrayOfByte1 = new byte[12];
    byte[] tmp18_16 = arrayOfByte1;
    tmp18_16[0] = 10;
    byte[] tmp23_18 = tmp18_16;
    tmp23_18[1] = 1;
    byte[] tmp28_23 = tmp23_18;
    tmp28_23[2] = 56;
    byte[] tmp33_28 = tmp28_23;
    tmp33_28[3] = 1;
    byte[] tmp38_33 = tmp33_28;
    tmp38_33[4] = 14;
    byte[] tmp43_38 = tmp38_33;
    tmp43_38[5] = 0;
    byte[] tmp48_43 = tmp43_38;
    tmp48_43[6] = 26;
    byte[] tmp54_48 = tmp48_43;
    tmp54_48[7] = 0;
    byte[] tmp60_54 = tmp54_48;
    tmp60_54[8] = 12;
    byte[] tmp66_60 = tmp60_54;
    tmp66_60[9] = 2;
    byte[] tmp72_66 = tmp66_60;
    tmp72_66[10] = 26;
    byte[] tmp78_72 = tmp72_66;
    tmp78_72[11] = 1;
    tmp78_72;
    byte[] arrayOfByte2 = new byte[12];
    byte[] tmp93_91 = arrayOfByte2;
    tmp93_91[0] = 18;
    byte[] tmp98_93 = tmp93_91;
    tmp98_93[1] = 4;
    byte[] tmp103_98 = tmp98_93;
    tmp103_98[2] = 41;
    byte[] tmp108_103 = tmp103_98;
    tmp108_103[3] = 0;
    byte[] tmp113_108 = tmp108_103;
    tmp113_108[4] = 0;
    byte[] tmp118_113 = tmp113_108;
    tmp118_113[5] = 0;
    byte[] tmp123_118 = tmp118_113;
    tmp123_118[6] = 113;
    byte[] tmp129_123 = tmp123_118;
    tmp129_123[7] = 64;
    byte[] tmp135_129 = tmp129_123;
    tmp135_129[8] = 85;
    byte[] tmp141_135 = tmp135_129;
    tmp141_135[9] = 45;
    byte[] tmp147_141 = tmp141_135;
    tmp147_141[10] = 14;
    byte[] tmp153_147 = tmp147_141;
    tmp153_147[11] = 51;
    tmp153_147;
    byte[] arrayOfByte3 = new byte[12];
    byte[] tmp168_166 = arrayOfByte3;
    tmp168_166[0] = 1;
    byte[] tmp173_168 = tmp168_166;
    tmp173_168[1] = 1;
    byte[] tmp178_173 = tmp173_168;
    tmp178_173[2] = 1;
    byte[] tmp183_178 = tmp178_173;
    tmp183_178[3] = 1;
    byte[] tmp188_183 = tmp183_178;
    tmp188_183[4] = 0;
    byte[] tmp193_188 = tmp188_183;
    tmp193_188[5] = 0;
    byte[] tmp198_193 = tmp193_188;
    tmp198_193[6] = 0;
    byte[] tmp204_198 = tmp198_193;
    tmp204_198[7] = 0;
    byte[] tmp210_204 = tmp204_198;
    tmp210_204[8] = 0;
    byte[] tmp216_210 = tmp210_204;
    tmp216_210[9] = 0;
    byte[] tmp222_216 = tmp216_210;
    tmp222_216[10] = 0;
    byte[] tmp228_222 = tmp222_216;
    tmp228_222[11] = 0;
    tmp228_222;
    byte[] arrayOfByte4 = new byte[12];
    byte[] tmp243_241 = arrayOfByte4;
    tmp243_241[0] = 56;
    byte[] tmp248_243 = tmp243_241;
    tmp248_243[1] = 1;
    byte[] tmp253_248 = tmp248_243;
    tmp253_248[2] = 43;
    byte[] tmp258_253 = tmp253_248;
    tmp258_253[3] = 0;
    byte[] tmp263_258 = tmp258_253;
    tmp263_258[4] = 110;
    byte[] tmp268_263 = tmp263_258;
    tmp268_263[5] = 16;
    byte[] tmp273_268 = tmp268_263;
    tmp273_268[6] = 19;
    byte[] tmp279_273 = tmp273_268;
    tmp279_273[7] = 7;
    byte[] tmp285_279 = tmp279_273;
    tmp285_279[8] = 7;
    byte[] tmp291_285 = tmp285_279;
    tmp291_285[9] = 0;
    byte[] tmp297_291 = tmp291_285;
    tmp297_291[10] = 12;
    byte[] tmp303_297 = tmp297_291;
    tmp303_297[11] = 1;
    tmp303_297;
    byte[] arrayOfByte5 = new byte[12];
    byte[] tmp318_316 = arrayOfByte5;
    tmp318_316[0] = 0;
    byte[] tmp323_318 = tmp318_316;
    tmp323_318[1] = 0;
    byte[] tmp328_323 = tmp323_318;
    tmp328_323[2] = 0;
    byte[] tmp333_328 = tmp328_323;
    tmp333_328[3] = 0;
    byte[] tmp338_333 = tmp333_328;
    tmp338_333[4] = 110;
    byte[] tmp343_338 = tmp338_333;
    tmp343_338[5] = 16;
    byte[] tmp348_343 = tmp343_338;
    tmp348_343[6] = 19;
    byte[] tmp354_348 = tmp348_343;
    tmp354_348[7] = 7;
    byte[] tmp360_354 = tmp354_348;
    tmp360_354[8] = 7;
    byte[] tmp366_360 = tmp360_354;
    tmp366_360[9] = 0;
    byte[] tmp372_366 = tmp366_360;
    tmp372_366[10] = 12;
    byte[] tmp378_372 = tmp372_366;
    tmp378_372[11] = 1;
    tmp378_372;
    byte[] arrayOfByte6 = new byte[12];
    byte[] tmp393_391 = arrayOfByte6;
    tmp393_391[0] = 1;
    byte[] tmp398_393 = tmp393_391;
    tmp398_393[1] = 1;
    byte[] tmp403_398 = tmp398_393;
    tmp403_398[2] = 1;
    byte[] tmp408_403 = tmp403_398;
    tmp408_403[3] = 1;
    byte[] tmp413_408 = tmp408_403;
    tmp413_408[4] = 0;
    byte[] tmp418_413 = tmp413_408;
    tmp418_413[5] = 0;
    byte[] tmp423_418 = tmp418_413;
    tmp423_418[6] = 0;
    byte[] tmp429_423 = tmp423_418;
    tmp429_423[7] = 0;
    byte[] tmp435_429 = tmp429_423;
    tmp435_429[8] = 0;
    byte[] tmp441_435 = tmp435_429;
    tmp441_435[9] = 0;
    byte[] tmp447_441 = tmp441_435;
    tmp447_441[10] = 0;
    byte[] tmp453_447 = tmp447_441;
    tmp453_447[11] = 0;
    tmp453_447;
    byte[] arrayOfByte7 = new byte[14];
    byte[] tmp468_466 = arrayOfByte7;
    tmp468_466[0] = 56;
    byte[] tmp473_468 = tmp468_466;
    tmp473_468[1] = 0;
    byte[] tmp478_473 = tmp473_468;
    tmp478_473[2] = 6;
    byte[] tmp483_478 = tmp478_473;
    tmp483_478[3] = 0;
    byte[] tmp488_483 = tmp483_478;
    tmp488_483[4] = 112;
    byte[] tmp493_488 = tmp488_483;
    tmp493_488[5] = 16;
    byte[] tmp498_493 = tmp493_488;
    tmp498_493[6] = 117;
    byte[] tmp504_498 = tmp498_493;
    tmp504_498[7] = 7;
    byte[] tmp510_504 = tmp504_498;
    tmp510_504[8] = 4;
    byte[] tmp516_510 = tmp510_504;
    tmp516_510[9] = 0;
    byte[] tmp522_516 = tmp516_510;
    tmp522_516[10] = 14;
    byte[] tmp528_522 = tmp522_516;
    tmp528_522[11] = 0;
    byte[] tmp534_528 = tmp528_522;
    tmp534_528[12] = 84;
    byte[] tmp540_534 = tmp534_528;
    tmp540_534[13] = 64;
    tmp540_534;
    byte[] arrayOfByte8 = new byte[14];
    byte[] tmp555_553 = arrayOfByte8;
    tmp555_553[0] = 0;
    byte[] tmp560_555 = tmp555_553;
    tmp560_555[1] = 0;
    byte[] tmp565_560 = tmp560_555;
    tmp565_560[2] = 0;
    byte[] tmp570_565 = tmp565_560;
    tmp570_565[3] = 0;
    byte[] tmp575_570 = tmp570_565;
    tmp575_570[4] = 112;
    byte[] tmp580_575 = tmp575_570;
    tmp580_575[5] = 16;
    byte[] tmp585_580 = tmp580_575;
    tmp585_580[6] = 117;
    byte[] tmp591_585 = tmp585_580;
    tmp591_585[7] = 7;
    byte[] tmp597_591 = tmp591_585;
    tmp597_591[8] = 4;
    byte[] tmp603_597 = tmp597_591;
    tmp603_597[9] = 0;
    byte[] tmp609_603 = tmp603_597;
    tmp609_603[10] = 14;
    byte[] tmp615_609 = tmp609_603;
    tmp615_609[11] = 0;
    byte[] tmp621_615 = tmp615_609;
    tmp621_615[12] = 84;
    byte[] tmp627_621 = tmp621_615;
    tmp627_621[13] = 64;
    tmp627_621;
    byte[] arrayOfByte9 = new byte[14];
    byte[] tmp642_640 = arrayOfByte9;
    tmp642_640[0] = 1;
    byte[] tmp647_642 = tmp642_640;
    tmp647_642[1] = 1;
    byte[] tmp652_647 = tmp647_642;
    tmp652_647[2] = 1;
    byte[] tmp657_652 = tmp652_647;
    tmp657_652[3] = 1;
    byte[] tmp662_657 = tmp657_652;
    tmp662_657[4] = 0;
    byte[] tmp667_662 = tmp662_657;
    tmp667_662[5] = 0;
    byte[] tmp672_667 = tmp667_662;
    tmp672_667[6] = 0;
    byte[] tmp678_672 = tmp672_667;
    tmp678_672[7] = 0;
    byte[] tmp684_678 = tmp678_672;
    tmp684_678[8] = 0;
    byte[] tmp690_684 = tmp684_678;
    tmp690_684[9] = 0;
    byte[] tmp696_690 = tmp690_684;
    tmp696_690[10] = 0;
    byte[] tmp702_696 = tmp696_690;
    tmp702_696[11] = 0;
    byte[] tmp708_702 = tmp702_696;
    tmp708_702[12] = 0;
    byte[] tmp714_708 = tmp708_702;
    tmp714_708[13] = 0;
    tmp714_708;
    byte[] arrayOfByte10 = new byte[14];
    byte[] tmp729_727 = arrayOfByte10;
    tmp729_727[0] = 56;
    byte[] tmp734_729 = tmp729_727;
    tmp734_729[1] = 0;
    byte[] tmp739_734 = tmp734_729;
    tmp739_734[2] = 87;
    byte[] tmp744_739 = tmp739_734;
    tmp744_739[3] = 0;
    byte[] tmp749_744 = tmp744_739;
    tmp749_744[4] = 84;
    byte[] tmp754_749 = tmp749_744;
    tmp754_749[5] = 96;
    byte[] tmp759_754 = tmp754_749;
    tmp759_754[6] = 2;
    byte[] tmp765_759 = tmp759_754;
    tmp765_759[7] = 3;
    byte[] tmp771_765 = tmp765_759;
    tmp771_765[8] = 84;
    byte[] tmp777_771 = tmp771_765;
    tmp777_771[9] = 0;
    byte[] tmp783_777 = tmp777_771;
    tmp783_777[10] = 1;
    byte[] tmp789_783 = tmp783_777;
    tmp789_783[11] = 2;
    byte[] tmp795_789 = tmp789_783;
    tmp795_789[12] = 84;
    byte[] tmp801_795 = tmp795_789;
    tmp801_795[13] = 97;
    tmp801_795;
    byte[] arrayOfByte11 = new byte[14];
    byte[] tmp816_814 = arrayOfByte11;
    tmp816_814[0] = 0;
    byte[] tmp821_816 = tmp816_814;
    tmp821_816[1] = 0;
    byte[] tmp826_821 = tmp821_816;
    tmp826_821[2] = 0;
    byte[] tmp831_826 = tmp826_821;
    tmp831_826[3] = 0;
    byte[] tmp836_831 = tmp831_826;
    tmp836_831[4] = 112;
    byte[] tmp841_836 = tmp836_831;
    tmp841_836[5] = 16;
    byte[] tmp846_841 = tmp841_836;
    tmp846_841[6] = 117;
    byte[] tmp852_846 = tmp846_841;
    tmp852_846[7] = 7;
    byte[] tmp858_852 = tmp852_846;
    tmp858_852[8] = 4;
    byte[] tmp864_858 = tmp858_852;
    tmp864_858[9] = 0;
    byte[] tmp870_864 = tmp864_858;
    tmp870_864[10] = 14;
    byte[] tmp876_870 = tmp870_864;
    tmp876_870[11] = 0;
    byte[] tmp882_876 = tmp876_870;
    tmp882_876[12] = 84;
    byte[] tmp888_882 = tmp882_876;
    tmp888_882[13] = 64;
    tmp888_882;
    byte[] arrayOfByte12 = new byte[14];
    byte[] tmp903_901 = arrayOfByte12;
    tmp903_901[0] = 1;
    byte[] tmp908_903 = tmp903_901;
    tmp908_903[1] = 1;
    byte[] tmp913_908 = tmp908_903;
    tmp913_908[2] = 1;
    byte[] tmp918_913 = tmp913_908;
    tmp918_913[3] = 1;
    byte[] tmp923_918 = tmp918_913;
    tmp923_918[4] = 0;
    byte[] tmp928_923 = tmp923_918;
    tmp928_923[5] = 0;
    byte[] tmp933_928 = tmp928_923;
    tmp933_928[6] = 0;
    byte[] tmp939_933 = tmp933_928;
    tmp939_933[7] = 0;
    byte[] tmp945_939 = tmp939_933;
    tmp945_939[8] = 0;
    byte[] tmp951_945 = tmp945_939;
    tmp951_945[9] = 0;
    byte[] tmp957_951 = tmp951_945;
    tmp957_951[10] = 0;
    byte[] tmp963_957 = tmp957_951;
    tmp963_957[11] = 0;
    byte[] tmp969_963 = tmp963_957;
    tmp969_963[12] = 0;
    byte[] tmp975_969 = tmp969_963;
    tmp975_969[13] = 0;
    tmp975_969;
    String str = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]);
    try
    {
      localObject = new File(str);
      paramArrayOfString = (String[])localObject;
      if (!((File)localObject).exists()) {
        paramArrayOfString = new File(str.replace("-1", "-2"));
      }
      localObject = new File(str.replace("-1", ""));
      if (paramArrayOfString.exists()) {
        localObject = paramArrayOfString;
      }
      str = str.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
      paramArrayOfString = new File(str);
      if (paramArrayOfString.exists()) {
        localObject = paramArrayOfString;
      }
      paramArrayOfString = new File(str.replace("-1", "-2"));
      if (paramArrayOfString.exists()) {
        localObject = paramArrayOfString;
      }
      paramArrayOfString = new File(str.replace("-1", ""));
      if (paramArrayOfString.exists()) {
        localObject = paramArrayOfString;
      }
      if (!((File)localObject).exists()) {
        throw new FileNotFoundException();
      }
    }
    catch (FileNotFoundException paramArrayOfString)
    {
      Object localObject;
      System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
      for (;;)
      {
        Utils.exitFromRootJava();
        return;
        paramArrayOfString = new RandomAccessFile((File)localObject, "rw").getChannel();
        localObject = paramArrayOfString.map(FileChannel.MapMode.READ_WRITE, 0L, (int)paramArrayOfString.size());
        n = 0;
        i2 = 0;
        i1 = 0;
        i6 = 0;
        j = 0;
        long l = 0L;
        int i10;
        int i11;
        for (;;)
        {
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i6;
          i8 = n;
          i9 = i2;
          i10 = i1;
          i11 = i6;
          try
          {
            if (!((MappedByteBuffer)localObject).hasRemaining()) {
              break label2415;
            }
            i3 = n;
            i4 = i2;
            i5 = i1;
            i7 = i6;
            i10 = ((MappedByteBuffer)localObject).position();
            i3 = n;
            i4 = i2;
            i5 = i1;
            i7 = i6;
            m = ((MappedByteBuffer)localObject).get();
            i8 = i6;
            i = j;
            if (m != arrayOfByte1[0]) {
              break label2681;
            }
            i = j;
            if (arrayOfByte3[0] != 2) {
              break label2518;
            }
            i = m;
          }
          catch (Exception localException)
          {
            System.out.println("" + localException);
            i11 = i7;
            i10 = i5;
            i9 = i4;
            i8 = i3;
            paramArrayOfString.close();
            if (i9 != 0) {
              break label2432;
            }
            System.out.println("Error: License Key2 patch Failed!\nor patch is already applied?!\n");
            if (i10 != 0) {
              break label2445;
            }
            System.out.println("Error: Internet Connection patch Failed!\nor patch is already applied?!\n\n");
            if (i11 != 0) {
              break label2458;
            }
            System.out.println("Error: Check License Key patch Failed!\nor patch is already applied?!\n");
            if (0 != 0) {
              break label2470;
            }
            System.out.println("Error: Market Free patch Failed!\nor patch is already applied?!\n");
          }
          i8 = 1;
          i9 = 1000;
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i6;
          ((MappedByteBuffer)localObject).position(i10 + 1);
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i6;
          j = ((MappedByteBuffer)localObject).get();
          i4 = i9;
          i3 = i8;
          k = i;
          break label2534;
          i9 = i3 + 1;
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i6;
          if (i9 != arrayOfByte1.length) {
            break;
          }
          if (i8 < 1000) {
            arrayOfByte2[i8] = i;
          }
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i6;
          ((MappedByteBuffer)localObject).position(i10);
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i6;
          ((MappedByteBuffer)localObject).put(arrayOfByte2);
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i6;
          ((MappedByteBuffer)localObject).force();
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i6;
          System.out.println("Check License Key Fixed!\n");
          i8 = 1;
          break label2681;
          i6 = 1;
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i8;
          ((MappedByteBuffer)localObject).position(i10 + 1);
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i8;
          j = ((MappedByteBuffer)localObject).get();
          i3 = i6;
          break label2710;
          i6 = i3 + 1;
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i8;
          if (i6 != arrayOfByte4.length) {
            break label2288;
          }
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i8;
          ((MappedByteBuffer)localObject).position(i10);
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i8;
          ((MappedByteBuffer)localObject).put(arrayOfByte5);
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i8;
          ((MappedByteBuffer)localObject).force();
          i3 = n;
          i4 = i2;
          i5 = i1;
          i7 = i8;
          System.out.println("License Key Fixed2!\n");
          i6 = 1;
          i3 = n;
          i4 = i6;
          i5 = i1;
          i7 = i8;
          ((MappedByteBuffer)localObject).position(i10 + 1);
          break label2817;
          i2 = 1;
          i3 = n;
          i4 = i6;
          i5 = i1;
          i7 = i8;
          ((MappedByteBuffer)localObject).position(i10 + 1);
          i3 = n;
          i4 = i6;
          i5 = i1;
          i7 = i8;
          j = ((MappedByteBuffer)localObject).get();
          i3 = i2;
          break label2846;
          i2 = i3 + 1;
          i3 = n;
          i4 = i6;
          i5 = i1;
          i7 = i8;
          if (i2 != arrayOfByte7.length) {
            break label2317;
          }
          i3 = n;
          i4 = i6;
          i5 = i1;
          i7 = i8;
          ((MappedByteBuffer)localObject).position(i10);
          i3 = n;
          i4 = i6;
          i5 = i1;
          i7 = i8;
          ((MappedByteBuffer)localObject).put(arrayOfByte8);
          i3 = n;
          i4 = i6;
          i5 = i1;
          i7 = i8;
          ((MappedByteBuffer)localObject).force();
          i3 = n;
          i4 = i6;
          i5 = i1;
          i7 = i8;
          System.out.println("Internet Connection Fixed!\n");
          i2 = 1;
          i3 = n;
          i4 = i6;
          i5 = i2;
          i7 = i8;
          ((MappedByteBuffer)localObject).position(i10 + 1);
          i9 = i2;
          break label2965;
          i2 = 1;
          i3 = n;
          i4 = i6;
          i5 = i9;
          i7 = i8;
          ((MappedByteBuffer)localObject).position(i10 + 1);
          i3 = n;
          i4 = i6;
          i5 = i9;
          i7 = i8;
          j = ((MappedByteBuffer)localObject).get();
          break label2994;
          i2 += 1;
          i3 = n;
          i4 = i6;
          i5 = i9;
          i7 = i8;
          if (i2 != arrayOfByte10.length) {
            break label2346;
          }
          i3 = n;
          i4 = i6;
          i5 = i9;
          i7 = i8;
          ((MappedByteBuffer)localObject).position(i10);
          i3 = n;
          i4 = i6;
          i5 = i9;
          i7 = i8;
          ((MappedByteBuffer)localObject).put(arrayOfByte11);
          i3 = n;
          i4 = i6;
          i5 = i9;
          i7 = i8;
          ((MappedByteBuffer)localObject).force();
          i3 = n;
          i4 = i6;
          i5 = i9;
          i7 = i8;
          System.out.println("Cached License Key Fixed!\n");
          i1 = 1;
          i3 = i1;
          i4 = i6;
          i5 = i9;
          i7 = i8;
          ((MappedByteBuffer)localObject).position(i10 + 1);
          i3 = i1;
          i4 = i6;
          i5 = i9;
          i7 = i8;
          ((MappedByteBuffer)localObject).position(i10 + 1);
          l += 1L;
          n = i1;
          i2 = i6;
          i1 = i9;
          i6 = i8;
          j = i;
        }
        i3 = n;
        i4 = i2;
        int i5 = i1;
        int i7 = i6;
        j = ((MappedByteBuffer)localObject).get();
        i4 = i8;
        i3 = i9;
        k = i;
        break label2534;
        i3 = n;
        i4 = i2;
        i5 = i1;
        i7 = i8;
        j = ((MappedByteBuffer)localObject).get();
        i3 = i6;
        break label2710;
        i3 = n;
        i4 = i6;
        i5 = i1;
        i7 = i8;
        j = ((MappedByteBuffer)localObject).get();
        i3 = i2;
        break label2846;
        i3 = n;
        i4 = i6;
        i5 = i9;
        i7 = i8;
        j = ((MappedByteBuffer)localObject).get();
        break label2994;
        if (i8 == 0) {
          System.out.println("Error: Cached License Key patch Failed!\nor patch is already applied?!\n");
        }
      }
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        int n;
        int i2;
        int i1;
        int i6;
        int j;
        int i3;
        int i4;
        int i8;
        int i9;
        int m;
        int i;
        int k;
        label2288:
        label2317:
        label2346:
        label2415:
        label2432:
        label2445:
        label2458:
        label2470:
        System.out.println("Exception e" + paramArrayOfString.toString());
        continue;
        label2518:
        if (arrayOfByte3[0] == 0)
        {
          arrayOfByte2[0] = m;
          continue;
          label2534:
          if (j != arrayOfByte1[i3])
          {
            i8 = i6;
            i = k;
            if (new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0 }[i3] == 0) {}
          }
          else
          {
            i = k;
            if (arrayOfByte3[i3] == 2) {
              i = j;
            }
            if ((arrayOfByte3[i3] == 0) || (arrayOfByte3[i3] == 2)) {
              arrayOfByte2[i3] = j;
            }
            i8 = i4;
            if (arrayOfByte3[i3] != 3) {
              continue;
            }
            i8 = i3;
            continue;
          }
          label2681:
          i6 = i2;
          if (m == arrayOfByte4[0])
          {
            if (arrayOfByte6[0] == 0)
            {
              arrayOfByte5[0] = m;
              continue;
              label2710:
              if (j != arrayOfByte4[i3])
              {
                i6 = i2;
                if (new byte[] { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0 }[i3] != 1) {}
              }
              else if (arrayOfByte6[i3] == 0)
              {
                arrayOfByte5[i3] = j;
              }
            }
          }
          else
          {
            label2817:
            i9 = i1;
            if (m == arrayOfByte7[0])
            {
              if (arrayOfByte9[0] == 0)
              {
                arrayOfByte8[0] = m;
                continue;
                label2846:
                if (j != arrayOfByte7[i3])
                {
                  i2 = i1;
                  if (new byte[] { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1 }[i3] != 1) {}
                }
                else if (arrayOfByte9[i3] == 0)
                {
                  arrayOfByte8[i3] = j;
                }
              }
            }
            else
            {
              label2965:
              i1 = n;
              if (m == arrayOfByte10[0]) {
                if (arrayOfByte12[0] == 0)
                {
                  arrayOfByte11[0] = m;
                  continue;
                  label2994:
                  if (j != arrayOfByte10[i2])
                  {
                    i1 = n;
                    if (new byte[] { 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0 }[i2] != 1) {}
                  }
                  else if (arrayOfByte12[i2] == 0)
                  {
                    arrayOfByte11[i2] = j;
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


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/remove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */