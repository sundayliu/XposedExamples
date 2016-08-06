package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class createnerorunpatch
{
  public static File classes;
  public static File crkapk;
  private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
  public static String sddir = "/sdcard/";
  public static String tooldir = "/sdcard/";
  
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    sddir = paramArrayOfString[2];
    tooldir = paramArrayOfString[3];
    byte[] arrayOfByte25 = new byte[24];
    byte[] tmp30_28 = arrayOfByte25;
    tmp30_28[0] = 18;
    byte[] tmp35_30 = tmp30_28;
    tmp35_30[1] = 36;
    byte[] tmp40_35 = tmp35_30;
    tmp40_35[2] = 18;
    byte[] tmp45_40 = tmp40_35;
    tmp45_40[3] = 19;
    byte[] tmp50_45 = tmp45_40;
    tmp50_45[4] = 18;
    byte[] tmp55_50 = tmp50_45;
    tmp55_50[5] = 2;
    byte[] tmp60_55 = tmp55_50;
    tmp60_55[6] = 34;
    byte[] tmp66_60 = tmp60_55;
    tmp66_60[7] = 0;
    byte[] tmp72_66 = tmp66_60;
    tmp72_66[8] = 111;
    byte[] tmp78_72 = tmp72_66;
    tmp78_72[9] = 0;
    byte[] tmp84_78 = tmp78_72;
    tmp84_78[10] = 26;
    byte[] tmp90_84 = tmp84_78;
    tmp90_84[11] = 1;
    byte[] tmp96_90 = tmp90_84;
    tmp96_90[12] = 1;
    byte[] tmp102_96 = tmp96_90;
    tmp102_96[13] = 1;
    byte[] tmp108_102 = tmp102_96;
    tmp108_102[14] = 112;
    byte[] tmp114_108 = tmp108_102;
    tmp114_108[15] = 48;
    byte[] tmp120_114 = tmp114_108;
    tmp120_114[16] = 61;
    byte[] tmp126_120 = tmp120_114;
    tmp126_120[17] = 1;
    byte[] tmp132_126 = tmp126_120;
    tmp132_126[18] = 16;
    byte[] tmp138_132 = tmp132_126;
    tmp138_132[19] = 2;
    byte[] tmp144_138 = tmp138_132;
    tmp144_138[20] = 105;
    byte[] tmp150_144 = tmp144_138;
    tmp150_144[21] = 0;
    byte[] tmp156_150 = tmp150_144;
    tmp156_150[22] = 76;
    byte[] tmp162_156 = tmp156_150;
    tmp162_156[23] = 0;
    tmp162_156;
    byte[] arrayOfByte26 = new byte[24];
    byte[] tmp177_175 = arrayOfByte26;
    tmp177_175[0] = 0;
    byte[] tmp182_177 = tmp177_175;
    tmp182_177[1] = 1;
    byte[] tmp187_182 = tmp182_177;
    tmp187_182[2] = 0;
    byte[] tmp192_187 = tmp187_182;
    tmp192_187[3] = 1;
    byte[] tmp197_192 = tmp192_187;
    tmp197_192[4] = 0;
    byte[] tmp202_197 = tmp197_192;
    tmp202_197[5] = 1;
    byte[] tmp207_202 = tmp202_197;
    tmp207_202[6] = 1;
    byte[] tmp213_207 = tmp207_202;
    tmp213_207[7] = 1;
    byte[] tmp219_213 = tmp213_207;
    tmp219_213[8] = 1;
    byte[] tmp225_219 = tmp219_213;
    tmp225_219[9] = 1;
    byte[] tmp231_225 = tmp225_219;
    tmp231_225[10] = 0;
    byte[] tmp237_231 = tmp231_225;
    tmp237_231[11] = 1;
    byte[] tmp243_237 = tmp237_231;
    tmp243_237[12] = 1;
    byte[] tmp249_243 = tmp243_237;
    tmp249_243[13] = 1;
    byte[] tmp255_249 = tmp249_243;
    tmp255_249[14] = 0;
    byte[] tmp261_255 = tmp255_249;
    tmp261_255[15] = 0;
    byte[] tmp267_261 = tmp261_255;
    tmp267_261[16] = 1;
    byte[] tmp273_267 = tmp267_261;
    tmp273_267[17] = 1;
    byte[] tmp279_273 = tmp273_267;
    tmp279_273[18] = 1;
    byte[] tmp285_279 = tmp279_273;
    tmp285_279[19] = 1;
    byte[] tmp291_285 = tmp285_279;
    tmp291_285[20] = 0;
    byte[] tmp297_291 = tmp291_285;
    tmp297_291[21] = 0;
    byte[] tmp303_297 = tmp297_291;
    tmp303_297[22] = 5;
    byte[] tmp309_303 = tmp303_297;
    tmp309_303[23] = 5;
    tmp309_303;
    byte[] arrayOfByte1 = new byte[8];
    byte[] tmp324_322 = arrayOfByte1;
    tmp324_322[0] = 98;
    byte[] tmp329_324 = tmp324_322;
    tmp329_324[1] = 3;
    byte[] tmp334_329 = tmp329_324;
    tmp334_329[2] = -1;
    byte[] tmp339_334 = tmp334_329;
    tmp339_334[3] = -1;
    byte[] tmp344_339 = tmp339_334;
    tmp344_339[4] = 51;
    byte[] tmp349_344 = tmp344_339;
    tmp349_344[5] = -1;
    byte[] tmp354_349 = tmp349_344;
    tmp354_349[6] = -1;
    byte[] tmp360_354 = tmp354_349;
    tmp360_354[7] = -1;
    tmp360_354;
    byte[] arrayOfByte2 = new byte[8];
    byte[] tmp375_373 = arrayOfByte2;
    tmp375_373[0] = 16;
    byte[] tmp380_375 = tmp375_373;
    tmp380_375[1] = 0;
    byte[] tmp385_380 = tmp380_375;
    tmp385_380[2] = 0;
    byte[] tmp390_385 = tmp385_380;
    tmp390_385[3] = 0;
    byte[] tmp395_390 = tmp390_385;
    tmp395_390[4] = 0;
    byte[] tmp400_395 = tmp395_390;
    tmp400_395[5] = 0;
    byte[] tmp405_400 = tmp400_395;
    tmp405_400[6] = 0;
    byte[] tmp411_405 = tmp405_400;
    tmp411_405[7] = 0;
    tmp411_405;
    byte[] arrayOfByte3 = new byte[8];
    byte[] tmp426_424 = arrayOfByte3;
    tmp426_424[0] = 0;
    byte[] tmp431_426 = tmp426_424;
    tmp431_426[1] = 0;
    byte[] tmp436_431 = tmp431_426;
    tmp436_431[2] = 0;
    byte[] tmp441_436 = tmp436_431;
    tmp441_436[3] = 0;
    byte[] tmp446_441 = tmp441_436;
    tmp446_441[4] = 1;
    byte[] tmp451_446 = tmp446_441;
    tmp451_446[5] = 1;
    byte[] tmp456_451 = tmp451_446;
    tmp456_451[6] = 1;
    byte[] tmp462_456 = tmp456_451;
    tmp462_456[7] = 1;
    tmp462_456;
    byte[] arrayOfByte4 = new byte[8];
    byte[] tmp477_475 = arrayOfByte4;
    tmp477_475[0] = 98;
    byte[] tmp482_477 = tmp477_475;
    tmp482_477[1] = 3;
    byte[] tmp487_482 = tmp482_477;
    tmp487_482[2] = -1;
    byte[] tmp492_487 = tmp487_482;
    tmp492_487[3] = -1;
    byte[] tmp497_492 = tmp492_487;
    tmp497_492[4] = 51;
    byte[] tmp502_497 = tmp497_492;
    tmp502_497[5] = -1;
    byte[] tmp507_502 = tmp502_497;
    tmp507_502[6] = -1;
    byte[] tmp513_507 = tmp507_502;
    tmp513_507[7] = -1;
    tmp513_507;
    byte[] arrayOfByte5 = new byte[8];
    byte[] tmp528_526 = arrayOfByte5;
    tmp528_526[0] = 16;
    byte[] tmp533_528 = tmp528_526;
    tmp533_528[1] = 0;
    byte[] tmp538_533 = tmp533_528;
    tmp538_533[2] = 0;
    byte[] tmp543_538 = tmp538_533;
    tmp543_538[3] = 0;
    byte[] tmp548_543 = tmp543_538;
    tmp548_543[4] = 41;
    byte[] tmp553_548 = tmp548_543;
    tmp553_548[5] = 0;
    byte[] tmp558_553 = tmp553_548;
    tmp558_553[6] = 0;
    byte[] tmp564_558 = tmp558_553;
    tmp564_558[7] = 0;
    tmp564_558;
    byte[] arrayOfByte6 = new byte[8];
    byte[] tmp579_577 = arrayOfByte6;
    tmp579_577[0] = 0;
    byte[] tmp584_579 = tmp579_577;
    tmp584_579[1] = 0;
    byte[] tmp589_584 = tmp584_579;
    tmp589_584[2] = 0;
    byte[] tmp594_589 = tmp589_584;
    tmp594_589[3] = 0;
    byte[] tmp599_594 = tmp594_589;
    tmp599_594[4] = 1;
    byte[] tmp604_599 = tmp599_594;
    tmp604_599[5] = 1;
    byte[] tmp609_604 = tmp604_599;
    tmp609_604[6] = 0;
    byte[] tmp615_609 = tmp609_604;
    tmp615_609[7] = 0;
    tmp615_609;
    byte[] arrayOfByte7 = new byte[8];
    byte[] tmp630_628 = arrayOfByte7;
    tmp630_628[0] = 98;
    byte[] tmp635_630 = tmp630_628;
    tmp635_630[1] = 3;
    byte[] tmp640_635 = tmp635_630;
    tmp640_635[2] = -1;
    byte[] tmp645_640 = tmp640_635;
    tmp645_640[3] = -1;
    byte[] tmp650_645 = tmp645_640;
    tmp650_645[4] = 51;
    byte[] tmp655_650 = tmp650_645;
    tmp655_650[5] = -1;
    byte[] tmp660_655 = tmp655_650;
    tmp660_655[6] = -1;
    byte[] tmp666_660 = tmp660_655;
    tmp666_660[7] = -1;
    tmp666_660;
    byte[] arrayOfByte8 = new byte[8];
    byte[] tmp681_679 = arrayOfByte8;
    tmp681_679[0] = 16;
    byte[] tmp686_681 = tmp681_679;
    tmp686_681[1] = 0;
    byte[] tmp691_686 = tmp686_681;
    tmp691_686[2] = 0;
    byte[] tmp696_691 = tmp691_686;
    tmp696_691[3] = 0;
    byte[] tmp701_696 = tmp696_691;
    tmp701_696[4] = 41;
    byte[] tmp706_701 = tmp701_696;
    tmp706_701[5] = 0;
    byte[] tmp711_706 = tmp706_701;
    tmp711_706[6] = 0;
    byte[] tmp717_711 = tmp711_706;
    tmp717_711[7] = 0;
    tmp717_711;
    byte[] arrayOfByte9 = new byte[8];
    byte[] tmp732_730 = arrayOfByte9;
    tmp732_730[0] = 0;
    byte[] tmp737_732 = tmp732_730;
    tmp737_732[1] = 0;
    byte[] tmp742_737 = tmp737_732;
    tmp742_737[2] = 0;
    byte[] tmp747_742 = tmp742_737;
    tmp747_742[3] = 0;
    byte[] tmp752_747 = tmp747_742;
    tmp752_747[4] = 1;
    byte[] tmp757_752 = tmp752_747;
    tmp757_752[5] = 1;
    byte[] tmp762_757 = tmp757_752;
    tmp762_757[6] = 0;
    byte[] tmp768_762 = tmp762_757;
    tmp768_762[7] = 0;
    tmp768_762;
    byte[] arrayOfByte10 = new byte[8];
    byte[] tmp783_781 = arrayOfByte10;
    tmp783_781[0] = 98;
    byte[] tmp788_783 = tmp783_781;
    tmp788_783[1] = 3;
    byte[] tmp793_788 = tmp788_783;
    tmp793_788[2] = -1;
    byte[] tmp798_793 = tmp793_788;
    tmp798_793[3] = -1;
    byte[] tmp803_798 = tmp798_793;
    tmp803_798[4] = 50;
    byte[] tmp808_803 = tmp803_798;
    tmp808_803[5] = -1;
    byte[] tmp813_808 = tmp808_803;
    tmp813_808[6] = -1;
    byte[] tmp819_813 = tmp813_808;
    tmp819_813[7] = -1;
    tmp819_813;
    byte[] arrayOfByte11 = new byte[8];
    byte[] tmp834_832 = arrayOfByte11;
    tmp834_832[0] = 16;
    byte[] tmp839_834 = tmp834_832;
    tmp839_834[1] = 0;
    byte[] tmp844_839 = tmp839_834;
    tmp844_839[2] = 0;
    byte[] tmp849_844 = tmp844_839;
    tmp849_844[3] = 0;
    byte[] tmp854_849 = tmp849_844;
    tmp854_849[4] = 41;
    byte[] tmp859_854 = tmp854_849;
    tmp859_854[5] = 0;
    byte[] tmp864_859 = tmp859_854;
    tmp864_859[6] = 0;
    byte[] tmp870_864 = tmp864_859;
    tmp870_864[7] = 0;
    tmp870_864;
    byte[] arrayOfByte12 = new byte[8];
    byte[] tmp885_883 = arrayOfByte12;
    tmp885_883[0] = 0;
    byte[] tmp890_885 = tmp885_883;
    tmp890_885[1] = 0;
    byte[] tmp895_890 = tmp890_885;
    tmp895_890[2] = 0;
    byte[] tmp900_895 = tmp895_890;
    tmp900_895[3] = 0;
    byte[] tmp905_900 = tmp900_895;
    tmp905_900[4] = 1;
    byte[] tmp910_905 = tmp905_900;
    tmp910_905[5] = 1;
    byte[] tmp915_910 = tmp910_905;
    tmp915_910[6] = 0;
    byte[] tmp921_915 = tmp915_910;
    tmp921_915[7] = 0;
    tmp921_915;
    byte[] arrayOfByte13 = new byte[8];
    byte[] tmp936_934 = arrayOfByte13;
    tmp936_934[0] = 98;
    byte[] tmp941_936 = tmp936_934;
    tmp941_936[1] = 3;
    byte[] tmp946_941 = tmp941_936;
    tmp946_941[2] = -1;
    byte[] tmp951_946 = tmp946_941;
    tmp951_946[3] = -1;
    byte[] tmp956_951 = tmp951_946;
    tmp956_951[4] = 50;
    byte[] tmp961_956 = tmp956_951;
    tmp961_956[5] = -1;
    byte[] tmp966_961 = tmp961_956;
    tmp966_961[6] = -1;
    byte[] tmp972_966 = tmp966_961;
    tmp972_966[7] = -1;
    tmp972_966;
    byte[] arrayOfByte14 = new byte[8];
    byte[] tmp987_985 = arrayOfByte14;
    tmp987_985[0] = 16;
    byte[] tmp992_987 = tmp987_985;
    tmp992_987[1] = 0;
    byte[] tmp997_992 = tmp992_987;
    tmp997_992[2] = 0;
    byte[] tmp1002_997 = tmp997_992;
    tmp1002_997[3] = 0;
    byte[] tmp1007_1002 = tmp1002_997;
    tmp1007_1002[4] = 0;
    byte[] tmp1012_1007 = tmp1007_1002;
    tmp1012_1007[5] = 0;
    byte[] tmp1017_1012 = tmp1012_1007;
    tmp1017_1012[6] = 0;
    byte[] tmp1023_1017 = tmp1017_1012;
    tmp1023_1017[7] = 0;
    tmp1023_1017;
    byte[] arrayOfByte15 = new byte[8];
    byte[] tmp1038_1036 = arrayOfByte15;
    tmp1038_1036[0] = 0;
    byte[] tmp1043_1038 = tmp1038_1036;
    tmp1043_1038[1] = 0;
    byte[] tmp1048_1043 = tmp1043_1038;
    tmp1048_1043[2] = 0;
    byte[] tmp1053_1048 = tmp1048_1043;
    tmp1053_1048[3] = 0;
    byte[] tmp1058_1053 = tmp1053_1048;
    tmp1058_1053[4] = 1;
    byte[] tmp1063_1058 = tmp1058_1053;
    tmp1063_1058[5] = 1;
    byte[] tmp1068_1063 = tmp1063_1058;
    tmp1068_1063[6] = 1;
    byte[] tmp1074_1068 = tmp1068_1063;
    tmp1074_1068[7] = 1;
    tmp1074_1068;
    byte[] arrayOfByte16 = new byte[8];
    byte[] tmp1089_1087 = arrayOfByte16;
    tmp1089_1087[0] = 98;
    byte[] tmp1094_1089 = tmp1089_1087;
    tmp1094_1089[1] = 3;
    byte[] tmp1099_1094 = tmp1094_1089;
    tmp1099_1094[2] = -1;
    byte[] tmp1104_1099 = tmp1099_1094;
    tmp1104_1099[3] = -1;
    byte[] tmp1109_1104 = tmp1104_1099;
    tmp1109_1104[4] = 50;
    byte[] tmp1114_1109 = tmp1109_1104;
    tmp1114_1109[5] = -1;
    byte[] tmp1119_1114 = tmp1114_1109;
    tmp1119_1114[6] = -1;
    byte[] tmp1125_1119 = tmp1119_1114;
    tmp1125_1119[7] = -1;
    tmp1125_1119;
    byte[] arrayOfByte17 = new byte[8];
    byte[] tmp1140_1138 = arrayOfByte17;
    tmp1140_1138[0] = 16;
    byte[] tmp1145_1140 = tmp1140_1138;
    tmp1145_1140[1] = 0;
    byte[] tmp1150_1145 = tmp1145_1140;
    tmp1150_1145[2] = 0;
    byte[] tmp1155_1150 = tmp1150_1145;
    tmp1155_1150[3] = 0;
    byte[] tmp1160_1155 = tmp1155_1150;
    tmp1160_1155[4] = 0;
    byte[] tmp1165_1160 = tmp1160_1155;
    tmp1165_1160[5] = 0;
    byte[] tmp1170_1165 = tmp1165_1160;
    tmp1170_1165[6] = 0;
    byte[] tmp1176_1170 = tmp1170_1165;
    tmp1176_1170[7] = 0;
    tmp1176_1170;
    byte[] arrayOfByte18 = new byte[8];
    byte[] tmp1191_1189 = arrayOfByte18;
    tmp1191_1189[0] = 0;
    byte[] tmp1196_1191 = tmp1191_1189;
    tmp1196_1191[1] = 0;
    byte[] tmp1201_1196 = tmp1196_1191;
    tmp1201_1196[2] = 0;
    byte[] tmp1206_1201 = tmp1201_1196;
    tmp1206_1201[3] = 0;
    byte[] tmp1211_1206 = tmp1206_1201;
    tmp1211_1206[4] = 1;
    byte[] tmp1216_1211 = tmp1211_1206;
    tmp1216_1211[5] = 1;
    byte[] tmp1221_1216 = tmp1216_1211;
    tmp1221_1216[6] = 1;
    byte[] tmp1227_1221 = tmp1221_1216;
    tmp1227_1221[7] = 1;
    tmp1227_1221;
    byte[] arrayOfByte19 = new byte[16];
    byte[] tmp1242_1240 = arrayOfByte19;
    tmp1242_1240[0] = 98;
    byte[] tmp1247_1242 = tmp1242_1240;
    tmp1247_1242[1] = 3;
    byte[] tmp1252_1247 = tmp1247_1242;
    tmp1252_1247[2] = -1;
    byte[] tmp1257_1252 = tmp1252_1247;
    tmp1257_1252[3] = -1;
    byte[] tmp1262_1257 = tmp1257_1252;
    tmp1262_1257[4] = -1;
    byte[] tmp1267_1262 = tmp1262_1257;
    tmp1267_1262[5] = -1;
    byte[] tmp1272_1267 = tmp1267_1262;
    tmp1272_1267[6] = -1;
    byte[] tmp1278_1272 = tmp1272_1267;
    tmp1278_1272[7] = -1;
    byte[] tmp1284_1278 = tmp1278_1272;
    tmp1284_1278[8] = -1;
    byte[] tmp1290_1284 = tmp1284_1278;
    tmp1290_1284[9] = -1;
    byte[] tmp1296_1290 = tmp1290_1284;
    tmp1296_1290[10] = 10;
    byte[] tmp1302_1296 = tmp1296_1290;
    tmp1302_1296[11] = -1;
    byte[] tmp1308_1302 = tmp1302_1296;
    tmp1308_1302[12] = 56;
    byte[] tmp1314_1308 = tmp1308_1302;
    tmp1314_1308[13] = -1;
    byte[] tmp1320_1314 = tmp1314_1308;
    tmp1320_1314[14] = -1;
    byte[] tmp1326_1320 = tmp1320_1314;
    tmp1326_1320[15] = -1;
    tmp1326_1320;
    byte[] arrayOfByte20 = new byte[16];
    byte[] tmp1341_1339 = arrayOfByte20;
    tmp1341_1339[0] = 16;
    byte[] tmp1346_1341 = tmp1341_1339;
    tmp1346_1341[1] = 0;
    byte[] tmp1351_1346 = tmp1346_1341;
    tmp1351_1346[2] = 0;
    byte[] tmp1356_1351 = tmp1351_1346;
    tmp1356_1351[3] = 0;
    byte[] tmp1361_1356 = tmp1356_1351;
    tmp1361_1356[4] = 0;
    byte[] tmp1366_1361 = tmp1361_1356;
    tmp1366_1361[5] = 0;
    byte[] tmp1371_1366 = tmp1366_1361;
    tmp1371_1366[6] = 0;
    byte[] tmp1377_1371 = tmp1371_1366;
    tmp1377_1371[7] = 0;
    byte[] tmp1383_1377 = tmp1377_1371;
    tmp1383_1377[8] = 0;
    byte[] tmp1389_1383 = tmp1383_1377;
    tmp1389_1383[9] = 0;
    byte[] tmp1395_1389 = tmp1389_1383;
    tmp1395_1389[10] = 0;
    byte[] tmp1401_1395 = tmp1395_1389;
    tmp1401_1395[11] = 0;
    byte[] tmp1407_1401 = tmp1401_1395;
    tmp1407_1401[12] = 0;
    byte[] tmp1413_1407 = tmp1407_1401;
    tmp1413_1407[13] = 0;
    byte[] tmp1419_1413 = tmp1413_1407;
    tmp1419_1413[14] = 0;
    byte[] tmp1425_1419 = tmp1419_1413;
    tmp1425_1419[15] = 0;
    tmp1425_1419;
    byte[] arrayOfByte21 = new byte[16];
    byte[] tmp1440_1438 = arrayOfByte21;
    tmp1440_1438[0] = 0;
    byte[] tmp1445_1440 = tmp1440_1438;
    tmp1445_1440[1] = 0;
    byte[] tmp1450_1445 = tmp1445_1440;
    tmp1450_1445[2] = 0;
    byte[] tmp1455_1450 = tmp1450_1445;
    tmp1455_1450[3] = 0;
    byte[] tmp1460_1455 = tmp1455_1450;
    tmp1460_1455[4] = 0;
    byte[] tmp1465_1460 = tmp1460_1455;
    tmp1465_1460[5] = 0;
    byte[] tmp1470_1465 = tmp1465_1460;
    tmp1470_1465[6] = 0;
    byte[] tmp1476_1470 = tmp1470_1465;
    tmp1476_1470[7] = 0;
    byte[] tmp1482_1476 = tmp1476_1470;
    tmp1482_1476[8] = 0;
    byte[] tmp1488_1482 = tmp1482_1476;
    tmp1488_1482[9] = 0;
    byte[] tmp1494_1488 = tmp1488_1482;
    tmp1494_1488[10] = 0;
    byte[] tmp1500_1494 = tmp1494_1488;
    tmp1500_1494[11] = 0;
    byte[] tmp1506_1500 = tmp1500_1494;
    tmp1506_1500[12] = 1;
    byte[] tmp1512_1506 = tmp1506_1500;
    tmp1512_1506[13] = 1;
    byte[] tmp1518_1512 = tmp1512_1506;
    tmp1518_1512[14] = 1;
    byte[] tmp1524_1518 = tmp1518_1512;
    tmp1524_1518[15] = 1;
    tmp1524_1518;
    byte[] arrayOfByte22 = new byte[16];
    byte[] tmp1539_1537 = arrayOfByte22;
    tmp1539_1537[0] = 98;
    byte[] tmp1544_1539 = tmp1539_1537;
    tmp1544_1539[1] = 3;
    byte[] tmp1549_1544 = tmp1544_1539;
    tmp1549_1544[2] = -1;
    byte[] tmp1554_1549 = tmp1549_1544;
    tmp1554_1549[3] = -1;
    byte[] tmp1559_1554 = tmp1554_1549;
    tmp1559_1554[4] = -1;
    byte[] tmp1564_1559 = tmp1559_1554;
    tmp1564_1559[5] = -1;
    byte[] tmp1569_1564 = tmp1564_1559;
    tmp1569_1564[6] = -1;
    byte[] tmp1575_1569 = tmp1569_1564;
    tmp1575_1569[7] = -1;
    byte[] tmp1581_1575 = tmp1575_1569;
    tmp1581_1575[8] = -1;
    byte[] tmp1587_1581 = tmp1581_1575;
    tmp1587_1581[9] = -1;
    byte[] tmp1593_1587 = tmp1587_1581;
    tmp1593_1587[10] = 10;
    byte[] tmp1599_1593 = tmp1593_1587;
    tmp1599_1593[11] = -1;
    byte[] tmp1605_1599 = tmp1599_1593;
    tmp1605_1599[12] = 57;
    byte[] tmp1611_1605 = tmp1605_1599;
    tmp1611_1605[13] = -1;
    byte[] tmp1617_1611 = tmp1611_1605;
    tmp1617_1611[14] = -1;
    byte[] tmp1623_1617 = tmp1617_1611;
    tmp1623_1617[15] = -1;
    tmp1623_1617;
    byte[] arrayOfByte23 = new byte[16];
    byte[] tmp1638_1636 = arrayOfByte23;
    tmp1638_1636[0] = 16;
    byte[] tmp1643_1638 = tmp1638_1636;
    tmp1643_1638[1] = 0;
    byte[] tmp1648_1643 = tmp1643_1638;
    tmp1648_1643[2] = 0;
    byte[] tmp1653_1648 = tmp1648_1643;
    tmp1653_1648[3] = 0;
    byte[] tmp1658_1653 = tmp1653_1648;
    tmp1658_1653[4] = 0;
    byte[] tmp1663_1658 = tmp1658_1653;
    tmp1663_1658[5] = 0;
    byte[] tmp1668_1663 = tmp1663_1658;
    tmp1668_1663[6] = 0;
    byte[] tmp1674_1668 = tmp1668_1663;
    tmp1674_1668[7] = 0;
    byte[] tmp1680_1674 = tmp1674_1668;
    tmp1680_1674[8] = 0;
    byte[] tmp1686_1680 = tmp1680_1674;
    tmp1686_1680[9] = 0;
    byte[] tmp1692_1686 = tmp1686_1680;
    tmp1692_1686[10] = 0;
    byte[] tmp1698_1692 = tmp1692_1686;
    tmp1698_1692[11] = 0;
    byte[] tmp1704_1698 = tmp1698_1692;
    tmp1704_1698[12] = 41;
    byte[] tmp1710_1704 = tmp1704_1698;
    tmp1710_1704[13] = 0;
    byte[] tmp1716_1710 = tmp1710_1704;
    tmp1716_1710[14] = 0;
    byte[] tmp1722_1716 = tmp1716_1710;
    tmp1722_1716[15] = 0;
    tmp1722_1716;
    byte[] arrayOfByte24 = new byte[16];
    byte[] tmp1737_1735 = arrayOfByte24;
    tmp1737_1735[0] = 0;
    byte[] tmp1742_1737 = tmp1737_1735;
    tmp1742_1737[1] = 0;
    byte[] tmp1747_1742 = tmp1742_1737;
    tmp1747_1742[2] = 0;
    byte[] tmp1752_1747 = tmp1747_1742;
    tmp1752_1747[3] = 0;
    byte[] tmp1757_1752 = tmp1752_1747;
    tmp1757_1752[4] = 0;
    byte[] tmp1762_1757 = tmp1757_1752;
    tmp1762_1757[5] = 0;
    byte[] tmp1767_1762 = tmp1762_1757;
    tmp1767_1762[6] = 0;
    byte[] tmp1773_1767 = tmp1767_1762;
    tmp1773_1767[7] = 0;
    byte[] tmp1779_1773 = tmp1773_1767;
    tmp1779_1773[8] = 0;
    byte[] tmp1785_1779 = tmp1779_1773;
    tmp1785_1779[9] = 0;
    byte[] tmp1791_1785 = tmp1785_1779;
    tmp1791_1785[10] = 0;
    byte[] tmp1797_1791 = tmp1791_1785;
    tmp1797_1791[11] = 0;
    byte[] tmp1803_1797 = tmp1797_1791;
    tmp1803_1797[12] = 1;
    byte[] tmp1809_1803 = tmp1803_1797;
    tmp1809_1803[13] = 1;
    byte[] tmp1815_1809 = tmp1809_1803;
    tmp1815_1809[14] = 0;
    byte[] tmp1821_1815 = tmp1815_1809;
    tmp1821_1815[15] = 0;
    tmp1821_1815;
    dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]);
    try
    {
      classes = new File(sddir + "/Modified/classes.dex");
      if (!classes.exists()) {
        throw new FileNotFoundException();
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
      for (;;)
      {
        System.out.println(" " + arrayOfByte1[2]);
        if (paramArrayOfString[1].contains("object")) {
          for (;;)
          {
            try
            {
              paramArrayOfString = new RandomAccessFile(classes, "rw").getChannel();
              localObject = paramArrayOfString.map(FileChannel.MapMode.READ_WRITE, 0L, (int)paramArrayOfString.size());
              i3 = 0;
              i2 = 0;
              i1 = 0;
              n = 0;
              m = 0;
              i13 = 0;
            }
            catch (FileNotFoundException paramArrayOfString)
            {
              Object localObject;
              int i4;
              MappedByteBuffer localMappedByteBuffer;
              System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
              continue;
            }
            catch (IOException paramArrayOfString)
            {
              int i9;
              int i14;
              int j;
              System.out.println("" + paramArrayOfString);
              continue;
              if (i == localException1[k]) {
                continue;
              }
              int i8 = i3;
              if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
                continue;
              }
              if (arrayOfByte3[k] != 0) {
                continue;
              }
              arrayOfByte2[k] = i;
              continue;
              int i10 = i2;
              if (j != arrayOfByte10[0]) {
                continue;
              }
              if (arrayOfByte12[0] != 0) {
                continue;
              }
              arrayOfByte11[0] = j;
              continue;
              if (i == arrayOfByte10[k]) {
                continue;
              }
              i3 = i2;
              if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
                continue;
              }
              if (arrayOfByte12[k] != 0) {
                continue;
              }
              arrayOfByte11[k] = i;
              continue;
              int i11 = i1;
              if (j != arrayOfByte4[0]) {
                continue;
              }
              if (arrayOfByte6[0] != 0) {
                continue;
              }
              arrayOfByte5[0] = j;
              continue;
              if (i == arrayOfByte4[k]) {
                continue;
              }
              i2 = i1;
              if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
                continue;
              }
              if (arrayOfByte6[k] != 0) {
                continue;
              }
              arrayOfByte5[k] = i;
              continue;
              int i12 = n;
              if (j != arrayOfByte7[0]) {
                continue;
              }
              if (arrayOfByte9[0] != 0) {
                continue;
              }
              arrayOfByte8[0] = j;
              continue;
              if (i == arrayOfByte7[k]) {
                continue;
              }
              i1 = n;
              if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
                continue;
              }
              if (arrayOfByte9[k] != 0) {
                continue;
              }
              arrayOfByte8[k] = i;
              continue;
              n = m;
              if (j != arrayOfByte13[0]) {
                continue;
              }
              if (arrayOfByte15[0] != 0) {
                continue;
              }
              arrayOfByte14[0] = j;
              continue;
              if (i == arrayOfByte13[k]) {
                continue;
              }
              n = m;
              if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
                continue;
              }
              if (arrayOfByte15[k] != 0) {
                continue;
              }
              arrayOfByte14[k] = i;
              continue;
              m = n;
              if (j != arrayOfByte19[0]) {
                continue;
              }
              if (arrayOfByte21[0] != 0) {
                continue;
              }
              arrayOfByte20[0] = j;
              continue;
              if (i == arrayOfByte19[k]) {
                continue;
              }
              m = n;
              if (new byte[] { 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1 }[k] != 1) {
                continue;
              }
              if (arrayOfByte21[k] != 0) {
                continue;
              }
              arrayOfByte20[k] = i;
              continue;
              i8 = m;
              if (j != arrayOfByte22[0]) {
                continue;
              }
              if (arrayOfByte24[0] != 0) {
                continue;
              }
              arrayOfByte23[0] = j;
              continue;
              if (i == arrayOfByte22[k]) {
                continue;
              }
              i8 = m;
              if (new byte[] { 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1 }[k] != 1) {
                continue;
              }
              if (arrayOfByte24[k] != 0) {
                continue;
              }
              arrayOfByte23[k] = i;
              continue;
              int i13 = i14;
              i3 = i9;
              i2 = i10;
              i1 = i11;
              n = i12;
              m = i8;
              if (j != arrayOfByte16[0]) {
                continue;
              }
              if (arrayOfByte18[0] != 0) {
                continue;
              }
              arrayOfByte17[0] = j;
              continue;
            }
            i4 = i3;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            i8 = i3;
            i9 = i2;
            i10 = i1;
            i11 = n;
            i12 = m;
            try
            {
              if (!((MappedByteBuffer)localObject).hasRemaining()) {
                continue;
              }
              i4 = i3;
              i5 = i2;
              i6 = i1;
              i7 = n;
              k = m;
              ((MappedByteBuffer)localObject).position(i13 + 1);
              i4 = i3;
              i5 = i2;
              i6 = i1;
              i7 = n;
              k = m;
              i14 = ((MappedByteBuffer)localObject).position();
              i4 = i3;
              i5 = i2;
              i6 = i1;
              i7 = n;
              k = m;
              j = ((MappedByteBuffer)localObject).get();
              i9 = i3;
              if (j != arrayOfByte1[0]) {
                continue;
              }
              if (arrayOfByte3[0] == 0) {
                arrayOfByte2[0] = j;
              }
              i8 = 1;
              i4 = i3;
              i5 = i2;
              i6 = i1;
              i7 = n;
              k = m;
              ((MappedByteBuffer)localObject).position(i14 + 1);
              i4 = i3;
              i5 = i2;
              i6 = i1;
              i7 = n;
              k = m;
              i = ((MappedByteBuffer)localObject).get();
              k = i8;
            }
            catch (Exception localException1)
            {
              System.out.println("" + localException1);
              i12 = k;
              i11 = i7;
              i10 = i6;
              i9 = i5;
              i8 = i4;
              paramArrayOfString.close();
              if (i8 != 0) {
                continue;
              }
              System.out.println("Error: License Key2 patch Failed!\nor patch is already applied?!\n");
              if (i9 != 0) {
                continue;
              }
              System.out.println("Error: Internet Connection patch Failed!\nor patch is already applied?!\n\n");
              if (i10 != 0) {
                continue;
              }
              System.out.println("Error: Check License Key patch Failed!\nor patch is already applied?!\n");
              if (i11 != 0) {
                continue;
              }
              System.out.println("Error: Market Free patch Failed!\nor patch is already applied?!\n");
              if (i12 != 0) {
                continue;
              }
              System.out.println("Error: Market Free patch Failed!\nor patch is already applied?!\n");
              if (0 != 0) {
                continue;
              }
              System.out.println("Error: Cached License Key patch Failed!\nor patch is already applied?!\n");
            }
            i8 = k + 1;
            i4 = i3;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            if (i8 != arrayOfByte1.length) {
              continue;
            }
            i4 = i3;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).position(i14);
            i4 = i3;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).put(arrayOfByte2);
            i4 = i3;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).force();
            i4 = i3;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            System.out.println("Done!\n");
            i8 = 1;
            i4 = i8;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i9 = i8;
            continue;
            i3 = 1;
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            i = ((MappedByteBuffer)localObject).get();
            k = i3;
            continue;
            i3 = k + 1;
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            if (i3 != arrayOfByte10.length) {
              continue;
            }
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).position(i14);
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).put(arrayOfByte11);
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).force();
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            System.out.println("Done!\n");
            i3 = 1;
            i4 = i9;
            i5 = i3;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i10 = i3;
            continue;
            i2 = 1;
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            i = ((MappedByteBuffer)localObject).get();
            k = i2;
            continue;
            i2 = k + 1;
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            if (i2 != arrayOfByte4.length) {
              continue;
            }
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).put(arrayOfByte5);
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).force();
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            System.out.println("Done!\n");
            i2 = 1;
            i4 = i9;
            i5 = i10;
            i6 = i2;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i11 = i2;
            continue;
            i1 = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            i = ((MappedByteBuffer)localObject).get();
            k = i1;
            continue;
            i1 = k + 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            if (i1 != arrayOfByte7.length) {
              continue;
            }
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).put(arrayOfByte8);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject).force();
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            System.out.println("Done!\n");
            i1 = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i1;
            k = m;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i12 = i1;
            continue;
            n = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            i = ((MappedByteBuffer)localObject).get();
            k = n;
            continue;
            n = k + 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            if (n != arrayOfByte13.length) {
              continue;
            }
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject).put(arrayOfByte14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject).force();
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            System.out.println("Done!\n");
            n = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            continue;
            m = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            i = ((MappedByteBuffer)localObject).get();
            k = m;
            continue;
            m = k + 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            if (m != arrayOfByte19.length) {
              continue;
            }
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            ((MappedByteBuffer)localObject).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            ((MappedByteBuffer)localObject).put(arrayOfByte20);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            ((MappedByteBuffer)localObject).force();
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            System.out.println("Done!\n");
            m = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            continue;
            n = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            i = ((MappedByteBuffer)localObject).get();
            k = n;
            continue;
            n = k + 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            if (n != arrayOfByte22.length) {
              continue;
            }
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject).put(arrayOfByte23);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject).force();
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            System.out.println("Done!\n");
            i8 = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            continue;
            m = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            i = ((MappedByteBuffer)localObject).get();
            k = m;
            break label5806;
            m = k + 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            if (m != arrayOfByte16.length) {
              continue;
            }
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            ((MappedByteBuffer)localObject).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            ((MappedByteBuffer)localObject).put(arrayOfByte17);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            ((MappedByteBuffer)localObject).force();
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            System.out.println("Done!\n");
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            ((MappedByteBuffer)localObject).position(i14 + 1);
            i13 = i14;
            i3 = i9;
            i2 = i10;
            i1 = i11;
            n = i12;
            m = i8;
          }
        }
        Utils.exitFromRootJava();
        return;
        n = 0;
        i5 = 0;
        i1 = 0;
        i4 = 1000;
        if (paramArrayOfString[1].contains("object")) {
          i4 = Integer.parseInt(paramArrayOfString[1].replace("object", ""));
        }
        localObject = new RandomAccessFile(classes, "rw").getChannel();
        localMappedByteBuffer = ((FileChannel)localObject).map(FileChannel.MapMode.READ_WRITE, 0L, (int)((FileChannel)localObject).size());
        for (;;)
        {
          k = i1;
          m = n;
          i2 = i1;
          i3 = n;
          try
          {
            if (!localMappedByteBuffer.hasRemaining()) {
              break label4576;
            }
            i2 = i1;
            i3 = n;
            if (i1 >= i4) {
              break label4576;
            }
            i6 = 1;
            k = i1;
            m = n;
            localMappedByteBuffer.position(i5 + 1);
            k = i1;
            m = n;
            i7 = localMappedByteBuffer.position();
            i5 = i7;
            k = i1;
            m = n;
            if (localMappedByteBuffer.get() == arrayOfByte25[0])
            {
              i2 = 1;
              i3 = 2;
              k = i1;
              m = n;
              localMappedByteBuffer.position(i7 + 1);
              k = i1;
              m = n;
              i = localMappedByteBuffer.get();
              k = i3;
              m = i2;
              i3 = i1;
              i2 = n;
            }
          }
          catch (Exception localException2)
          {
            i3 = m;
            i2 = k;
            ((FileChannel)localObject).close();
            System.out.println("{\"objects\":\"" + i2 + "\"}");
          }
        }
        i8 = m + 1;
        n = i3;
        i1 = i2;
        k = i3;
        m = i2;
        if (i8 == arrayOfByte25.length)
        {
          n = i3 + 1;
          if (i4 != 1000) {
            break label6014;
          }
          k = n;
          m = i2;
          System.out.println("Serach " + n + " - Done!\n" + " " + "byteOrig2[2]");
          break label6014;
        }
        k = n;
        m = i1;
        i = localMappedByteBuffer.get();
        k = i5;
        m = i8;
        i3 = n;
        i2 = i1;
        break label5881;
        arrayOfByte4[k] = i;
        arrayOfByte7[k] = i;
        arrayOfByte13[k] = i;
        arrayOfByte16[k] = i;
        break label6006;
        if (i3 == 0) {
          System.out.println("Error: Objects not Found!\n");
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int i3;
        int i2;
        int i1;
        int n;
        int m;
        label4576:
        System.out.println("" + localIOException);
        continue;
        i4 = i3;
        int i5 = i2;
        int i6 = i1;
        int i7 = n;
        int k = m;
        int i = localIOException.get();
        k = i8;
        break label4948;
        i4 = i9;
        i5 = i2;
        i6 = i1;
        i7 = n;
        k = m;
        i = localIOException.get();
        k = i3;
        break label5054;
        i4 = i9;
        i5 = i10;
        i6 = i1;
        i7 = n;
        k = m;
        i = localIOException.get();
        k = i2;
        break label5160;
        i4 = i9;
        i5 = i10;
        i6 = i11;
        i7 = n;
        k = m;
        i = localIOException.get();
        k = i1;
        break label5266;
        i4 = i9;
        i5 = i10;
        i6 = i11;
        i7 = i12;
        k = m;
        i = localIOException.get();
        k = n;
        break label5372;
        i4 = i9;
        i5 = i10;
        i6 = i11;
        i7 = i12;
        k = n;
        i = localIOException.get();
        k = m;
        break label5478;
        i4 = i9;
        i5 = i10;
        i6 = i11;
        i7 = i12;
        k = m;
        i = localIOException.get();
        k = n;
        break label5632;
        i4 = i9;
        i5 = i10;
        i6 = i11;
        i7 = i12;
        k = i8;
        i = localIOException.get();
        k = m;
        label4948:
        label5054:
        label5160:
        label5266:
        label5372:
        label5478:
        label5632:
        label5806:
        if (i != arrayOfByte16[k])
        {
          if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {}
        }
        else if (arrayOfByte18[k] == 0)
        {
          arrayOfByte17[k] = i;
          continue;
          label5881:
          i5 = i7;
          i1 = i3;
          n = i2;
          if (i6 != 0) {
            if ((i != localException2[m]) && (arrayOfByte26[m] != 1))
            {
              i5 = i7;
              i1 = i3;
              n = i2;
              if (arrayOfByte26[m] != 5) {}
            }
            else
            {
              i5 = k;
              if (arrayOfByte26[m] == 5)
              {
                localException1[k] = i;
                arrayOfByte10[k] = i;
                arrayOfByte19[k] = i;
                arrayOfByte22[k] = i;
                if (k == 2)
                {
                  arrayOfByte4[k] = ((byte)(i + 1));
                  arrayOfByte7[k] = ((byte)(i + 2));
                  arrayOfByte13[k] = ((byte)(i + 1));
                  arrayOfByte16[k] = ((byte)(i + 2));
                  label6006:
                  i5 = k + 1;
                  continue;
                  label6014:
                  i6 = 0;
                  i1 = 1;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/createnerorunpatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */