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

public class nerorunpatch
{
  private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
  private static String dalvikDexIn2 = "/cache/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
  
  public static void main(String[] paramArrayOfString)
  {
    localObject9 = null;
    localObject8 = null;
    Utils.startRootJava();
    Utils.kill(paramArrayOfString[0]);
    arrayOfByte25 = new byte[24];
    byte[] tmp23_21 = arrayOfByte25;
    tmp23_21[0] = 18;
    byte[] tmp28_23 = tmp23_21;
    tmp28_23[1] = 36;
    byte[] tmp33_28 = tmp28_23;
    tmp33_28[2] = 18;
    byte[] tmp38_33 = tmp33_28;
    tmp38_33[3] = 19;
    byte[] tmp43_38 = tmp38_33;
    tmp43_38[4] = 18;
    byte[] tmp48_43 = tmp43_38;
    tmp48_43[5] = 2;
    byte[] tmp53_48 = tmp48_43;
    tmp53_48[6] = 34;
    byte[] tmp59_53 = tmp53_48;
    tmp59_53[7] = 0;
    byte[] tmp65_59 = tmp59_53;
    tmp65_59[8] = 111;
    byte[] tmp71_65 = tmp65_59;
    tmp71_65[9] = 0;
    byte[] tmp77_71 = tmp71_65;
    tmp77_71[10] = 26;
    byte[] tmp83_77 = tmp77_71;
    tmp83_77[11] = 1;
    byte[] tmp89_83 = tmp83_77;
    tmp89_83[12] = 1;
    byte[] tmp95_89 = tmp89_83;
    tmp95_89[13] = 1;
    byte[] tmp101_95 = tmp95_89;
    tmp101_95[14] = 112;
    byte[] tmp107_101 = tmp101_95;
    tmp107_101[15] = 48;
    byte[] tmp113_107 = tmp107_101;
    tmp113_107[16] = 61;
    byte[] tmp119_113 = tmp113_107;
    tmp119_113[17] = 1;
    byte[] tmp125_119 = tmp119_113;
    tmp125_119[18] = 16;
    byte[] tmp131_125 = tmp125_119;
    tmp131_125[19] = 2;
    byte[] tmp137_131 = tmp131_125;
    tmp137_131[20] = 105;
    byte[] tmp143_137 = tmp137_131;
    tmp143_137[21] = 0;
    byte[] tmp149_143 = tmp143_137;
    tmp149_143[22] = 76;
    byte[] tmp155_149 = tmp149_143;
    tmp155_149[23] = 0;
    tmp155_149;
    arrayOfByte26 = new byte[24];
    byte[] tmp170_168 = arrayOfByte26;
    tmp170_168[0] = 0;
    byte[] tmp175_170 = tmp170_168;
    tmp175_170[1] = 1;
    byte[] tmp180_175 = tmp175_170;
    tmp180_175[2] = 0;
    byte[] tmp185_180 = tmp180_175;
    tmp185_180[3] = 1;
    byte[] tmp190_185 = tmp185_180;
    tmp190_185[4] = 0;
    byte[] tmp195_190 = tmp190_185;
    tmp195_190[5] = 1;
    byte[] tmp200_195 = tmp195_190;
    tmp200_195[6] = 1;
    byte[] tmp206_200 = tmp200_195;
    tmp206_200[7] = 1;
    byte[] tmp212_206 = tmp206_200;
    tmp212_206[8] = 1;
    byte[] tmp218_212 = tmp212_206;
    tmp218_212[9] = 1;
    byte[] tmp224_218 = tmp218_212;
    tmp224_218[10] = 0;
    byte[] tmp230_224 = tmp224_218;
    tmp230_224[11] = 1;
    byte[] tmp236_230 = tmp230_224;
    tmp236_230[12] = 1;
    byte[] tmp242_236 = tmp236_230;
    tmp242_236[13] = 1;
    byte[] tmp248_242 = tmp242_236;
    tmp248_242[14] = 0;
    byte[] tmp254_248 = tmp248_242;
    tmp254_248[15] = 0;
    byte[] tmp260_254 = tmp254_248;
    tmp260_254[16] = 1;
    byte[] tmp266_260 = tmp260_254;
    tmp266_260[17] = 1;
    byte[] tmp272_266 = tmp266_260;
    tmp272_266[18] = 1;
    byte[] tmp278_272 = tmp272_266;
    tmp278_272[19] = 1;
    byte[] tmp284_278 = tmp278_272;
    tmp284_278[20] = 0;
    byte[] tmp290_284 = tmp284_278;
    tmp290_284[21] = 0;
    byte[] tmp296_290 = tmp290_284;
    tmp296_290[22] = 5;
    byte[] tmp302_296 = tmp296_290;
    tmp302_296[23] = 5;
    tmp302_296;
    arrayOfByte1 = new byte[8];
    byte[] tmp317_315 = arrayOfByte1;
    tmp317_315[0] = 98;
    byte[] tmp322_317 = tmp317_315;
    tmp322_317[1] = 3;
    byte[] tmp327_322 = tmp322_317;
    tmp327_322[2] = -1;
    byte[] tmp332_327 = tmp327_322;
    tmp332_327[3] = -1;
    byte[] tmp337_332 = tmp332_327;
    tmp337_332[4] = 51;
    byte[] tmp342_337 = tmp337_332;
    tmp342_337[5] = -1;
    byte[] tmp347_342 = tmp342_337;
    tmp347_342[6] = -1;
    byte[] tmp353_347 = tmp347_342;
    tmp353_347[7] = -1;
    tmp353_347;
    arrayOfByte2 = new byte[8];
    byte[] tmp368_366 = arrayOfByte2;
    tmp368_366[0] = 16;
    byte[] tmp373_368 = tmp368_366;
    tmp373_368[1] = 0;
    byte[] tmp378_373 = tmp373_368;
    tmp378_373[2] = 0;
    byte[] tmp383_378 = tmp378_373;
    tmp383_378[3] = 0;
    byte[] tmp388_383 = tmp383_378;
    tmp388_383[4] = 0;
    byte[] tmp393_388 = tmp388_383;
    tmp393_388[5] = 0;
    byte[] tmp398_393 = tmp393_388;
    tmp398_393[6] = 0;
    byte[] tmp404_398 = tmp398_393;
    tmp404_398[7] = 0;
    tmp404_398;
    arrayOfByte3 = new byte[8];
    byte[] tmp419_417 = arrayOfByte3;
    tmp419_417[0] = 0;
    byte[] tmp424_419 = tmp419_417;
    tmp424_419[1] = 0;
    byte[] tmp429_424 = tmp424_419;
    tmp429_424[2] = 0;
    byte[] tmp434_429 = tmp429_424;
    tmp434_429[3] = 0;
    byte[] tmp439_434 = tmp434_429;
    tmp439_434[4] = 1;
    byte[] tmp444_439 = tmp439_434;
    tmp444_439[5] = 1;
    byte[] tmp449_444 = tmp444_439;
    tmp449_444[6] = 1;
    byte[] tmp455_449 = tmp449_444;
    tmp455_449[7] = 1;
    tmp455_449;
    arrayOfByte4 = new byte[8];
    byte[] tmp470_468 = arrayOfByte4;
    tmp470_468[0] = 98;
    byte[] tmp475_470 = tmp470_468;
    tmp475_470[1] = 3;
    byte[] tmp480_475 = tmp475_470;
    tmp480_475[2] = -1;
    byte[] tmp485_480 = tmp480_475;
    tmp485_480[3] = -1;
    byte[] tmp490_485 = tmp485_480;
    tmp490_485[4] = 51;
    byte[] tmp495_490 = tmp490_485;
    tmp495_490[5] = -1;
    byte[] tmp500_495 = tmp495_490;
    tmp500_495[6] = -1;
    byte[] tmp506_500 = tmp500_495;
    tmp506_500[7] = -1;
    tmp506_500;
    arrayOfByte5 = new byte[8];
    byte[] tmp521_519 = arrayOfByte5;
    tmp521_519[0] = 16;
    byte[] tmp526_521 = tmp521_519;
    tmp526_521[1] = 0;
    byte[] tmp531_526 = tmp526_521;
    tmp531_526[2] = 0;
    byte[] tmp536_531 = tmp531_526;
    tmp536_531[3] = 0;
    byte[] tmp541_536 = tmp536_531;
    tmp541_536[4] = 41;
    byte[] tmp546_541 = tmp541_536;
    tmp546_541[5] = 0;
    byte[] tmp551_546 = tmp546_541;
    tmp551_546[6] = 0;
    byte[] tmp557_551 = tmp551_546;
    tmp557_551[7] = 0;
    tmp557_551;
    arrayOfByte6 = new byte[8];
    byte[] tmp572_570 = arrayOfByte6;
    tmp572_570[0] = 0;
    byte[] tmp577_572 = tmp572_570;
    tmp577_572[1] = 0;
    byte[] tmp582_577 = tmp577_572;
    tmp582_577[2] = 0;
    byte[] tmp587_582 = tmp582_577;
    tmp587_582[3] = 0;
    byte[] tmp592_587 = tmp587_582;
    tmp592_587[4] = 1;
    byte[] tmp597_592 = tmp592_587;
    tmp597_592[5] = 1;
    byte[] tmp602_597 = tmp597_592;
    tmp602_597[6] = 0;
    byte[] tmp608_602 = tmp602_597;
    tmp608_602[7] = 0;
    tmp608_602;
    arrayOfByte7 = new byte[8];
    byte[] tmp623_621 = arrayOfByte7;
    tmp623_621[0] = 98;
    byte[] tmp628_623 = tmp623_621;
    tmp628_623[1] = 3;
    byte[] tmp633_628 = tmp628_623;
    tmp633_628[2] = -1;
    byte[] tmp638_633 = tmp633_628;
    tmp638_633[3] = -1;
    byte[] tmp643_638 = tmp638_633;
    tmp643_638[4] = 51;
    byte[] tmp648_643 = tmp643_638;
    tmp648_643[5] = -1;
    byte[] tmp653_648 = tmp648_643;
    tmp653_648[6] = -1;
    byte[] tmp659_653 = tmp653_648;
    tmp659_653[7] = -1;
    tmp659_653;
    arrayOfByte8 = new byte[8];
    byte[] tmp674_672 = arrayOfByte8;
    tmp674_672[0] = 16;
    byte[] tmp679_674 = tmp674_672;
    tmp679_674[1] = 0;
    byte[] tmp684_679 = tmp679_674;
    tmp684_679[2] = 0;
    byte[] tmp689_684 = tmp684_679;
    tmp689_684[3] = 0;
    byte[] tmp694_689 = tmp689_684;
    tmp694_689[4] = 41;
    byte[] tmp699_694 = tmp694_689;
    tmp699_694[5] = 0;
    byte[] tmp704_699 = tmp699_694;
    tmp704_699[6] = 0;
    byte[] tmp710_704 = tmp704_699;
    tmp710_704[7] = 0;
    tmp710_704;
    arrayOfByte9 = new byte[8];
    byte[] tmp725_723 = arrayOfByte9;
    tmp725_723[0] = 0;
    byte[] tmp730_725 = tmp725_723;
    tmp730_725[1] = 0;
    byte[] tmp735_730 = tmp730_725;
    tmp735_730[2] = 0;
    byte[] tmp740_735 = tmp735_730;
    tmp740_735[3] = 0;
    byte[] tmp745_740 = tmp740_735;
    tmp745_740[4] = 1;
    byte[] tmp750_745 = tmp745_740;
    tmp750_745[5] = 1;
    byte[] tmp755_750 = tmp750_745;
    tmp755_750[6] = 0;
    byte[] tmp761_755 = tmp755_750;
    tmp761_755[7] = 0;
    tmp761_755;
    arrayOfByte10 = new byte[8];
    byte[] tmp776_774 = arrayOfByte10;
    tmp776_774[0] = 98;
    byte[] tmp781_776 = tmp776_774;
    tmp781_776[1] = 3;
    byte[] tmp786_781 = tmp781_776;
    tmp786_781[2] = -1;
    byte[] tmp791_786 = tmp786_781;
    tmp791_786[3] = -1;
    byte[] tmp796_791 = tmp791_786;
    tmp796_791[4] = 50;
    byte[] tmp801_796 = tmp796_791;
    tmp801_796[5] = -1;
    byte[] tmp806_801 = tmp801_796;
    tmp806_801[6] = -1;
    byte[] tmp812_806 = tmp806_801;
    tmp812_806[7] = -1;
    tmp812_806;
    arrayOfByte11 = new byte[8];
    byte[] tmp827_825 = arrayOfByte11;
    tmp827_825[0] = 16;
    byte[] tmp832_827 = tmp827_825;
    tmp832_827[1] = 0;
    byte[] tmp837_832 = tmp832_827;
    tmp837_832[2] = 0;
    byte[] tmp842_837 = tmp837_832;
    tmp842_837[3] = 0;
    byte[] tmp847_842 = tmp842_837;
    tmp847_842[4] = 41;
    byte[] tmp852_847 = tmp847_842;
    tmp852_847[5] = 0;
    byte[] tmp857_852 = tmp852_847;
    tmp857_852[6] = 0;
    byte[] tmp863_857 = tmp857_852;
    tmp863_857[7] = 0;
    tmp863_857;
    arrayOfByte12 = new byte[8];
    byte[] tmp878_876 = arrayOfByte12;
    tmp878_876[0] = 0;
    byte[] tmp883_878 = tmp878_876;
    tmp883_878[1] = 0;
    byte[] tmp888_883 = tmp883_878;
    tmp888_883[2] = 0;
    byte[] tmp893_888 = tmp888_883;
    tmp893_888[3] = 0;
    byte[] tmp898_893 = tmp893_888;
    tmp898_893[4] = 1;
    byte[] tmp903_898 = tmp898_893;
    tmp903_898[5] = 1;
    byte[] tmp908_903 = tmp903_898;
    tmp908_903[6] = 0;
    byte[] tmp914_908 = tmp908_903;
    tmp914_908[7] = 0;
    tmp914_908;
    arrayOfByte13 = new byte[8];
    byte[] tmp929_927 = arrayOfByte13;
    tmp929_927[0] = 98;
    byte[] tmp934_929 = tmp929_927;
    tmp934_929[1] = 3;
    byte[] tmp939_934 = tmp934_929;
    tmp939_934[2] = -1;
    byte[] tmp944_939 = tmp939_934;
    tmp944_939[3] = -1;
    byte[] tmp949_944 = tmp944_939;
    tmp949_944[4] = 50;
    byte[] tmp954_949 = tmp949_944;
    tmp954_949[5] = -1;
    byte[] tmp959_954 = tmp954_949;
    tmp959_954[6] = -1;
    byte[] tmp965_959 = tmp959_954;
    tmp965_959[7] = -1;
    tmp965_959;
    arrayOfByte14 = new byte[8];
    byte[] tmp980_978 = arrayOfByte14;
    tmp980_978[0] = 16;
    byte[] tmp985_980 = tmp980_978;
    tmp985_980[1] = 0;
    byte[] tmp990_985 = tmp985_980;
    tmp990_985[2] = 0;
    byte[] tmp995_990 = tmp990_985;
    tmp995_990[3] = 0;
    byte[] tmp1000_995 = tmp995_990;
    tmp1000_995[4] = 0;
    byte[] tmp1005_1000 = tmp1000_995;
    tmp1005_1000[5] = 0;
    byte[] tmp1010_1005 = tmp1005_1000;
    tmp1010_1005[6] = 0;
    byte[] tmp1016_1010 = tmp1010_1005;
    tmp1016_1010[7] = 0;
    tmp1016_1010;
    arrayOfByte15 = new byte[8];
    byte[] tmp1031_1029 = arrayOfByte15;
    tmp1031_1029[0] = 0;
    byte[] tmp1036_1031 = tmp1031_1029;
    tmp1036_1031[1] = 0;
    byte[] tmp1041_1036 = tmp1036_1031;
    tmp1041_1036[2] = 0;
    byte[] tmp1046_1041 = tmp1041_1036;
    tmp1046_1041[3] = 0;
    byte[] tmp1051_1046 = tmp1046_1041;
    tmp1051_1046[4] = 1;
    byte[] tmp1056_1051 = tmp1051_1046;
    tmp1056_1051[5] = 1;
    byte[] tmp1061_1056 = tmp1056_1051;
    tmp1061_1056[6] = 1;
    byte[] tmp1067_1061 = tmp1061_1056;
    tmp1067_1061[7] = 1;
    tmp1067_1061;
    arrayOfByte16 = new byte[8];
    byte[] tmp1082_1080 = arrayOfByte16;
    tmp1082_1080[0] = 98;
    byte[] tmp1087_1082 = tmp1082_1080;
    tmp1087_1082[1] = 3;
    byte[] tmp1092_1087 = tmp1087_1082;
    tmp1092_1087[2] = -1;
    byte[] tmp1097_1092 = tmp1092_1087;
    tmp1097_1092[3] = -1;
    byte[] tmp1102_1097 = tmp1097_1092;
    tmp1102_1097[4] = 50;
    byte[] tmp1107_1102 = tmp1102_1097;
    tmp1107_1102[5] = -1;
    byte[] tmp1112_1107 = tmp1107_1102;
    tmp1112_1107[6] = -1;
    byte[] tmp1118_1112 = tmp1112_1107;
    tmp1118_1112[7] = -1;
    tmp1118_1112;
    arrayOfByte17 = new byte[8];
    byte[] tmp1133_1131 = arrayOfByte17;
    tmp1133_1131[0] = 16;
    byte[] tmp1138_1133 = tmp1133_1131;
    tmp1138_1133[1] = 0;
    byte[] tmp1143_1138 = tmp1138_1133;
    tmp1143_1138[2] = 0;
    byte[] tmp1148_1143 = tmp1143_1138;
    tmp1148_1143[3] = 0;
    byte[] tmp1153_1148 = tmp1148_1143;
    tmp1153_1148[4] = 0;
    byte[] tmp1158_1153 = tmp1153_1148;
    tmp1158_1153[5] = 0;
    byte[] tmp1163_1158 = tmp1158_1153;
    tmp1163_1158[6] = 0;
    byte[] tmp1169_1163 = tmp1163_1158;
    tmp1169_1163[7] = 0;
    tmp1169_1163;
    arrayOfByte18 = new byte[8];
    byte[] tmp1184_1182 = arrayOfByte18;
    tmp1184_1182[0] = 0;
    byte[] tmp1189_1184 = tmp1184_1182;
    tmp1189_1184[1] = 0;
    byte[] tmp1194_1189 = tmp1189_1184;
    tmp1194_1189[2] = 0;
    byte[] tmp1199_1194 = tmp1194_1189;
    tmp1199_1194[3] = 0;
    byte[] tmp1204_1199 = tmp1199_1194;
    tmp1204_1199[4] = 1;
    byte[] tmp1209_1204 = tmp1204_1199;
    tmp1209_1204[5] = 1;
    byte[] tmp1214_1209 = tmp1209_1204;
    tmp1214_1209[6] = 1;
    byte[] tmp1220_1214 = tmp1214_1209;
    tmp1220_1214[7] = 1;
    tmp1220_1214;
    arrayOfByte19 = new byte[16];
    byte[] tmp1235_1233 = arrayOfByte19;
    tmp1235_1233[0] = 98;
    byte[] tmp1240_1235 = tmp1235_1233;
    tmp1240_1235[1] = 3;
    byte[] tmp1245_1240 = tmp1240_1235;
    tmp1245_1240[2] = -1;
    byte[] tmp1250_1245 = tmp1245_1240;
    tmp1250_1245[3] = -1;
    byte[] tmp1255_1250 = tmp1250_1245;
    tmp1255_1250[4] = -1;
    byte[] tmp1260_1255 = tmp1255_1250;
    tmp1260_1255[5] = -1;
    byte[] tmp1265_1260 = tmp1260_1255;
    tmp1265_1260[6] = -1;
    byte[] tmp1271_1265 = tmp1265_1260;
    tmp1271_1265[7] = -1;
    byte[] tmp1277_1271 = tmp1271_1265;
    tmp1277_1271[8] = -1;
    byte[] tmp1283_1277 = tmp1277_1271;
    tmp1283_1277[9] = -1;
    byte[] tmp1289_1283 = tmp1283_1277;
    tmp1289_1283[10] = 10;
    byte[] tmp1295_1289 = tmp1289_1283;
    tmp1295_1289[11] = -1;
    byte[] tmp1301_1295 = tmp1295_1289;
    tmp1301_1295[12] = 56;
    byte[] tmp1307_1301 = tmp1301_1295;
    tmp1307_1301[13] = -1;
    byte[] tmp1313_1307 = tmp1307_1301;
    tmp1313_1307[14] = -1;
    byte[] tmp1319_1313 = tmp1313_1307;
    tmp1319_1313[15] = -1;
    tmp1319_1313;
    arrayOfByte20 = new byte[16];
    byte[] tmp1334_1332 = arrayOfByte20;
    tmp1334_1332[0] = 16;
    byte[] tmp1339_1334 = tmp1334_1332;
    tmp1339_1334[1] = 0;
    byte[] tmp1344_1339 = tmp1339_1334;
    tmp1344_1339[2] = 0;
    byte[] tmp1349_1344 = tmp1344_1339;
    tmp1349_1344[3] = 0;
    byte[] tmp1354_1349 = tmp1349_1344;
    tmp1354_1349[4] = 0;
    byte[] tmp1359_1354 = tmp1354_1349;
    tmp1359_1354[5] = 0;
    byte[] tmp1364_1359 = tmp1359_1354;
    tmp1364_1359[6] = 0;
    byte[] tmp1370_1364 = tmp1364_1359;
    tmp1370_1364[7] = 0;
    byte[] tmp1376_1370 = tmp1370_1364;
    tmp1376_1370[8] = 0;
    byte[] tmp1382_1376 = tmp1376_1370;
    tmp1382_1376[9] = 0;
    byte[] tmp1388_1382 = tmp1382_1376;
    tmp1388_1382[10] = 0;
    byte[] tmp1394_1388 = tmp1388_1382;
    tmp1394_1388[11] = 0;
    byte[] tmp1400_1394 = tmp1394_1388;
    tmp1400_1394[12] = 0;
    byte[] tmp1406_1400 = tmp1400_1394;
    tmp1406_1400[13] = 0;
    byte[] tmp1412_1406 = tmp1406_1400;
    tmp1412_1406[14] = 0;
    byte[] tmp1418_1412 = tmp1412_1406;
    tmp1418_1412[15] = 0;
    tmp1418_1412;
    arrayOfByte21 = new byte[16];
    byte[] tmp1433_1431 = arrayOfByte21;
    tmp1433_1431[0] = 0;
    byte[] tmp1438_1433 = tmp1433_1431;
    tmp1438_1433[1] = 0;
    byte[] tmp1443_1438 = tmp1438_1433;
    tmp1443_1438[2] = 0;
    byte[] tmp1448_1443 = tmp1443_1438;
    tmp1448_1443[3] = 0;
    byte[] tmp1453_1448 = tmp1448_1443;
    tmp1453_1448[4] = 0;
    byte[] tmp1458_1453 = tmp1453_1448;
    tmp1458_1453[5] = 0;
    byte[] tmp1463_1458 = tmp1458_1453;
    tmp1463_1458[6] = 0;
    byte[] tmp1469_1463 = tmp1463_1458;
    tmp1469_1463[7] = 0;
    byte[] tmp1475_1469 = tmp1469_1463;
    tmp1475_1469[8] = 0;
    byte[] tmp1481_1475 = tmp1475_1469;
    tmp1481_1475[9] = 0;
    byte[] tmp1487_1481 = tmp1481_1475;
    tmp1487_1481[10] = 0;
    byte[] tmp1493_1487 = tmp1487_1481;
    tmp1493_1487[11] = 0;
    byte[] tmp1499_1493 = tmp1493_1487;
    tmp1499_1493[12] = 1;
    byte[] tmp1505_1499 = tmp1499_1493;
    tmp1505_1499[13] = 1;
    byte[] tmp1511_1505 = tmp1505_1499;
    tmp1511_1505[14] = 1;
    byte[] tmp1517_1511 = tmp1511_1505;
    tmp1517_1511[15] = 1;
    tmp1517_1511;
    arrayOfByte22 = new byte[16];
    byte[] tmp1532_1530 = arrayOfByte22;
    tmp1532_1530[0] = 98;
    byte[] tmp1537_1532 = tmp1532_1530;
    tmp1537_1532[1] = 3;
    byte[] tmp1542_1537 = tmp1537_1532;
    tmp1542_1537[2] = -1;
    byte[] tmp1547_1542 = tmp1542_1537;
    tmp1547_1542[3] = -1;
    byte[] tmp1552_1547 = tmp1547_1542;
    tmp1552_1547[4] = -1;
    byte[] tmp1557_1552 = tmp1552_1547;
    tmp1557_1552[5] = -1;
    byte[] tmp1562_1557 = tmp1557_1552;
    tmp1562_1557[6] = -1;
    byte[] tmp1568_1562 = tmp1562_1557;
    tmp1568_1562[7] = -1;
    byte[] tmp1574_1568 = tmp1568_1562;
    tmp1574_1568[8] = -1;
    byte[] tmp1580_1574 = tmp1574_1568;
    tmp1580_1574[9] = -1;
    byte[] tmp1586_1580 = tmp1580_1574;
    tmp1586_1580[10] = 10;
    byte[] tmp1592_1586 = tmp1586_1580;
    tmp1592_1586[11] = -1;
    byte[] tmp1598_1592 = tmp1592_1586;
    tmp1598_1592[12] = 57;
    byte[] tmp1604_1598 = tmp1598_1592;
    tmp1604_1598[13] = -1;
    byte[] tmp1610_1604 = tmp1604_1598;
    tmp1610_1604[14] = -1;
    byte[] tmp1616_1610 = tmp1610_1604;
    tmp1616_1610[15] = -1;
    tmp1616_1610;
    arrayOfByte23 = new byte[16];
    byte[] tmp1631_1629 = arrayOfByte23;
    tmp1631_1629[0] = 16;
    byte[] tmp1636_1631 = tmp1631_1629;
    tmp1636_1631[1] = 0;
    byte[] tmp1641_1636 = tmp1636_1631;
    tmp1641_1636[2] = 0;
    byte[] tmp1646_1641 = tmp1641_1636;
    tmp1646_1641[3] = 0;
    byte[] tmp1651_1646 = tmp1646_1641;
    tmp1651_1646[4] = 0;
    byte[] tmp1656_1651 = tmp1651_1646;
    tmp1656_1651[5] = 0;
    byte[] tmp1661_1656 = tmp1656_1651;
    tmp1661_1656[6] = 0;
    byte[] tmp1667_1661 = tmp1661_1656;
    tmp1667_1661[7] = 0;
    byte[] tmp1673_1667 = tmp1667_1661;
    tmp1673_1667[8] = 0;
    byte[] tmp1679_1673 = tmp1673_1667;
    tmp1679_1673[9] = 0;
    byte[] tmp1685_1679 = tmp1679_1673;
    tmp1685_1679[10] = 0;
    byte[] tmp1691_1685 = tmp1685_1679;
    tmp1691_1685[11] = 0;
    byte[] tmp1697_1691 = tmp1691_1685;
    tmp1697_1691[12] = 41;
    byte[] tmp1703_1697 = tmp1697_1691;
    tmp1703_1697[13] = 0;
    byte[] tmp1709_1703 = tmp1703_1697;
    tmp1709_1703[14] = 0;
    byte[] tmp1715_1709 = tmp1709_1703;
    tmp1715_1709[15] = 0;
    tmp1715_1709;
    arrayOfByte24 = new byte[16];
    byte[] tmp1730_1728 = arrayOfByte24;
    tmp1730_1728[0] = 0;
    byte[] tmp1735_1730 = tmp1730_1728;
    tmp1735_1730[1] = 0;
    byte[] tmp1740_1735 = tmp1735_1730;
    tmp1740_1735[2] = 0;
    byte[] tmp1745_1740 = tmp1740_1735;
    tmp1745_1740[3] = 0;
    byte[] tmp1750_1745 = tmp1745_1740;
    tmp1750_1745[4] = 0;
    byte[] tmp1755_1750 = tmp1750_1745;
    tmp1755_1750[5] = 0;
    byte[] tmp1760_1755 = tmp1755_1750;
    tmp1760_1755[6] = 0;
    byte[] tmp1766_1760 = tmp1760_1755;
    tmp1766_1760[7] = 0;
    byte[] tmp1772_1766 = tmp1766_1760;
    tmp1772_1766[8] = 0;
    byte[] tmp1778_1772 = tmp1772_1766;
    tmp1778_1772[9] = 0;
    byte[] tmp1784_1778 = tmp1778_1772;
    tmp1784_1778[10] = 0;
    byte[] tmp1790_1784 = tmp1784_1778;
    tmp1790_1784[11] = 0;
    byte[] tmp1796_1790 = tmp1790_1784;
    tmp1796_1790[12] = 1;
    byte[] tmp1802_1796 = tmp1796_1790;
    tmp1802_1796[13] = 1;
    byte[] tmp1808_1802 = tmp1802_1796;
    tmp1808_1802[14] = 0;
    byte[] tmp1814_1808 = tmp1808_1802;
    tmp1814_1808[15] = 0;
    tmp1814_1808;
    String str = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]);
    localObject6 = localObject8;
    Object localObject1 = localObject9;
    try
    {
      localObject10 = new File(str);
      localObject7 = localObject10;
      localObject6 = localObject8;
      localObject1 = localObject9;
      if (!((File)localObject10).exists())
      {
        localObject6 = localObject8;
        localObject1 = localObject9;
        localObject7 = new File(str.replace("-1", "-2"));
      }
      localObject6 = localObject8;
      localObject1 = localObject9;
      localObject8 = new File(str.replace("-1", ""));
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      Object localObject10;
      Object localObject7;
      boolean bool;
      Object localObject2 = localObject6;
      System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
      for (;;)
      {
        System.out.println(" " + arrayOfByte1[2]);
        if (paramArrayOfString[1].contains("object")) {
          for (;;)
          {
            try
            {
              paramArrayOfString = new RandomAccessFile((File)localObject2, "rw").getChannel();
              localObject2 = paramArrayOfString.map(FileChannel.MapMode.READ_WRITE, 0L, (int)paramArrayOfString.size());
              i3 = 0;
              i2 = 0;
              i1 = 0;
              n = 0;
              m = 0;
              i13 = 0;
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
                if (!((MappedByteBuffer)localObject2).hasRemaining()) {
                  continue;
                }
                i4 = i3;
                i5 = i2;
                i6 = i1;
                i7 = n;
                k = m;
                ((MappedByteBuffer)localObject2).position(i13 + 1);
                i4 = i3;
                i5 = i2;
                i6 = i1;
                i7 = n;
                k = m;
                i14 = ((MappedByteBuffer)localObject2).position();
                i4 = i3;
                i5 = i2;
                i6 = i1;
                i7 = n;
                k = m;
                j = ((MappedByteBuffer)localObject2).get();
                i9 = i3;
                if (j != arrayOfByte1[0]) {
                  break label6429;
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
                ((MappedByteBuffer)localObject2).position(i14 + 1);
                i4 = i3;
                i5 = i2;
                i6 = i1;
                i7 = n;
                k = m;
                i = ((MappedByteBuffer)localObject2).get();
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
              ((MappedByteBuffer)localObject2).position(i14);
              i4 = i3;
              i5 = i2;
              i6 = i1;
              i7 = n;
              k = m;
              ((MappedByteBuffer)localObject2).put(arrayOfByte2);
              i4 = i3;
              i5 = i2;
              i6 = i1;
              i7 = n;
              k = m;
              ((MappedByteBuffer)localObject2).force();
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
              ((MappedByteBuffer)localObject2).position(i14 + 1);
              i9 = i8;
            }
            catch (FileNotFoundException paramArrayOfString)
            {
              int i4;
              Object localObject3;
              System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
              continue;
            }
            catch (IOException paramArrayOfString)
            {
              System.out.println("" + paramArrayOfString);
              continue;
            }
            i3 = 1;
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            i = ((MappedByteBuffer)localObject2).get();
            k = i3;
            break label6456;
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
            ((MappedByteBuffer)localObject2).position(i14);
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject2).put(arrayOfByte11);
            i4 = i9;
            i5 = i2;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject2).force();
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
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            i10 = i3;
            break label6535;
            i2 = 1;
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            i = ((MappedByteBuffer)localObject2).get();
            k = i2;
            break label6562;
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
            ((MappedByteBuffer)localObject2).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject2).put(arrayOfByte5);
            i4 = i9;
            i5 = i10;
            i6 = i1;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject2).force();
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
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            i11 = i2;
            break label6641;
            i1 = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            i = ((MappedByteBuffer)localObject2).get();
            k = i1;
            break label6668;
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
            ((MappedByteBuffer)localObject2).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject2).put(arrayOfByte8);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = n;
            k = m;
            ((MappedByteBuffer)localObject2).force();
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
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            i12 = i1;
            break label6747;
            n = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            i = ((MappedByteBuffer)localObject2).get();
            k = n;
            break label6774;
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
            ((MappedByteBuffer)localObject2).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject2).put(arrayOfByte14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject2).force();
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
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            break label6853;
            m = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            i = ((MappedByteBuffer)localObject2).get();
            k = m;
            break label6880;
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
            ((MappedByteBuffer)localObject2).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            ((MappedByteBuffer)localObject2).put(arrayOfByte20);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = n;
            ((MappedByteBuffer)localObject2).force();
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
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            break label7007;
            n = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            i = ((MappedByteBuffer)localObject2).get();
            k = n;
            break label7034;
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
            ((MappedByteBuffer)localObject2).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject2).put(arrayOfByte23);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = m;
            ((MappedByteBuffer)localObject2).force();
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
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            break label7161;
            m = 1;
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            ((MappedByteBuffer)localObject2).position(i14 + 1);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            i = ((MappedByteBuffer)localObject2).get();
            k = m;
            break label7208;
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
            ((MappedByteBuffer)localObject2).position(i14);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            ((MappedByteBuffer)localObject2).put(arrayOfByte17);
            i4 = i9;
            i5 = i10;
            i6 = i11;
            i7 = i12;
            k = i8;
            ((MappedByteBuffer)localObject2).force();
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
            ((MappedByteBuffer)localObject2).position(i14 + 1);
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
        localObject6 = localObject7;
        localObject3 = localObject7;
        if (paramArrayOfString[1].contains("object"))
        {
          localObject6 = localObject7;
          localObject3 = localObject7;
          i4 = Integer.parseInt(paramArrayOfString[1].replace("object", ""));
        }
        localObject6 = localObject7;
        localObject3 = localObject7;
        localObject8 = new RandomAccessFile((File)localObject7, "rw").getChannel();
        localObject6 = localObject7;
        localObject3 = localObject7;
        localObject9 = ((FileChannel)localObject8).map(FileChannel.MapMode.READ_WRITE, 0L, (int)((FileChannel)localObject8).size());
        for (;;)
        {
          localObject6 = localObject7;
          k = i1;
          m = n;
          i2 = i1;
          i3 = n;
          localObject3 = localObject7;
          try
          {
            if (!((MappedByteBuffer)localObject9).hasRemaining()) {
              break label5925;
            }
            i2 = i1;
            i3 = n;
            if (i1 >= i4) {
              break label5925;
            }
            i6 = 1;
            localObject6 = localObject7;
            k = i1;
            m = n;
            localObject3 = localObject7;
            ((MappedByteBuffer)localObject9).position(i5 + 1);
            localObject6 = localObject7;
            k = i1;
            m = n;
            localObject3 = localObject7;
            i7 = ((MappedByteBuffer)localObject9).position();
            localObject6 = localObject7;
            i5 = i7;
            k = i1;
            m = n;
            localObject3 = localObject7;
            if (((MappedByteBuffer)localObject9).get() == arrayOfByte25[0])
            {
              i2 = 1;
              i3 = 2;
              localObject6 = localObject7;
              k = i1;
              m = n;
              localObject3 = localObject7;
              ((MappedByteBuffer)localObject9).position(i7 + 1);
              localObject6 = localObject7;
              k = i1;
              m = n;
              localObject3 = localObject7;
              i = ((MappedByteBuffer)localObject9).get();
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
            localObject6 = localObject7;
            localObject4 = localObject7;
            ((FileChannel)localObject8).close();
            localObject6 = localObject7;
            localObject4 = localObject7;
            System.out.println("{\"objects\":\"" + i2 + "\"}");
            localObject4 = localObject7;
          }
        }
        i8 = m + 1;
        localObject6 = localObject7;
        n = i3;
        i1 = i2;
        k = i3;
        m = i2;
        localObject3 = localObject7;
        if (i8 == arrayOfByte25.length)
        {
          n = i3 + 1;
          if (i4 != 1000) {
            break label7416;
          }
          localObject6 = localObject7;
          k = n;
          m = i2;
          localObject3 = localObject7;
          System.out.println("Serach " + n + " - Done!\n" + " " + "byteOrig2[2]");
          break label7416;
        }
        localObject6 = localObject7;
        k = n;
        m = i1;
        localObject3 = localObject7;
        i = ((MappedByteBuffer)localObject9).get();
        k = i5;
        m = i8;
        i3 = n;
        i2 = i1;
        break label7283;
        arrayOfByte4[k] = i;
        arrayOfByte7[k] = i;
        arrayOfByte13[k] = i;
        arrayOfByte16[k] = i;
        break label7408;
        if (i3 == 0)
        {
          localObject6 = localObject7;
          localObject4 = localObject7;
          System.out.println("Error: Objects not Found!\n");
          localObject4 = localObject7;
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        label1941:
        System.out.println("" + localIOException1);
      }
      i4 = i3;
      i5 = i2;
      i6 = i1;
      i7 = n;
      k = m;
      i = ((MappedByteBuffer)localObject4).get();
      k = i8;
      break label6350;
      i4 = i9;
      i5 = i2;
      i6 = i1;
      i7 = n;
      k = m;
      i = ((MappedByteBuffer)localObject4).get();
      k = i3;
      break label6456;
      i4 = i9;
      i5 = i10;
      i6 = i1;
      i7 = n;
      k = m;
      i = ((MappedByteBuffer)localObject4).get();
      k = i2;
      break label6562;
      i4 = i9;
      i5 = i10;
      i6 = i11;
      i7 = n;
      k = m;
      i = ((MappedByteBuffer)localObject4).get();
      k = i1;
      break label6668;
      i4 = i9;
      i5 = i10;
      i6 = i11;
      i7 = i12;
      k = m;
      i = ((MappedByteBuffer)localObject4).get();
      k = n;
      break label6774;
      i4 = i9;
      i5 = i10;
      i6 = i11;
      i7 = i12;
      k = n;
      i = ((MappedByteBuffer)localObject4).get();
      k = m;
      break label6880;
      i4 = i9;
      i5 = i10;
      i6 = i11;
      i7 = i12;
      k = m;
      i = ((MappedByteBuffer)localObject4).get();
      k = n;
      break label7034;
      i4 = i9;
      i5 = i10;
      i6 = i11;
      i7 = i12;
      k = i8;
      i = ((MappedByteBuffer)localObject4).get();
      k = m;
    }
    try
    {
      bool = ((File)localObject7).exists();
      if (!bool) {
        break label6347;
      }
      localObject8 = localObject7;
    }
    catch (IOException localIOException2)
    {
      localObject4 = localObject8;
      break label6011;
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      Object localObject5 = localObject8;
      break label3137;
      break label1941;
      if (i == arrayOfByte1[k]) {
        break label6414;
      }
      i8 = i3;
      if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
        break label3588;
      }
      if (arrayOfByte3[k] != 0) {
        break label3447;
      }
      arrayOfByte2[k] = i;
      break label3447;
      i10 = i2;
      if (j != arrayOfByte10[0]) {
        break label6535;
      }
      if (arrayOfByte12[0] != 0) {
        break label3624;
      }
      arrayOfByte11[0] = j;
      break label3624;
      if (i == arrayOfByte10[k]) {
        break label6520;
      }
      i3 = i2;
      if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
        break label3828;
      }
      if (arrayOfByte12[k] != 0) {
        break label3687;
      }
      arrayOfByte11[k] = i;
      break label3687;
      i11 = i1;
      if (j != arrayOfByte4[0]) {
        break label6641;
      }
      if (arrayOfByte6[0] != 0) {
        break label3864;
      }
      arrayOfByte5[0] = j;
      break label3864;
      if (i == arrayOfByte4[k]) {
        break label6626;
      }
      i2 = i1;
      if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
        break label4068;
      }
      if (arrayOfByte6[k] != 0) {
        break label3927;
      }
      arrayOfByte5[k] = i;
      break label3927;
      i12 = n;
      if (j != arrayOfByte7[0]) {
        break label6747;
      }
      if (arrayOfByte9[0] != 0) {
        break label4104;
      }
      arrayOfByte8[0] = j;
      break label4104;
      if (i == arrayOfByte7[k]) {
        break label6732;
      }
      i1 = n;
      if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
        break label4308;
      }
      if (arrayOfByte9[k] != 0) {
        break label4167;
      }
      arrayOfByte8[k] = i;
      break label4167;
      n = m;
      if (j != arrayOfByte13[0]) {
        break label6853;
      }
      if (arrayOfByte15[0] != 0) {
        break label4344;
      }
      arrayOfByte14[0] = j;
      break label4344;
      if (i == arrayOfByte13[k]) {
        break label6838;
      }
      n = m;
      if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
        break label4548;
      }
      if (arrayOfByte15[k] != 0) {
        break label4407;
      }
      arrayOfByte14[k] = i;
      break label4407;
      m = n;
      if (j != arrayOfByte19[0]) {
        break label7007;
      }
      if (arrayOfByte21[0] != 0) {
        break label4580;
      }
      arrayOfByte20[0] = j;
      break label4580;
      if (i == arrayOfByte19[k]) {
        break label6992;
      }
      m = n;
      if (new byte[] { 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1 }[k] != 1) {
        break label4784;
      }
      if (arrayOfByte21[k] != 0) {
        break label4643;
      }
      arrayOfByte20[k] = i;
      break label4643;
      i8 = m;
      if (j != arrayOfByte22[0]) {
        break label7161;
      }
      if (arrayOfByte24[0] != 0) {
        break label4816;
      }
      arrayOfByte23[0] = j;
      break label4816;
      if (i == arrayOfByte22[k]) {
        break label7146;
      }
      i8 = m;
      if (new byte[] { 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1 }[k] != 1) {
        break label5020;
      }
      if (arrayOfByte24[k] != 0) {
        break label4879;
      }
      arrayOfByte23[k] = i;
      break label4879;
      i13 = i14;
      i3 = i9;
      i2 = i10;
      i1 = i11;
      n = i12;
      m = i8;
      if (j != arrayOfByte16[0]) {
        break label3233;
      }
      if (arrayOfByte18[0] != 0) {
        break label5052;
      }
      arrayOfByte17[0] = j;
      break label5052;
      if (i == arrayOfByte16[k]) {
        break label7268;
      }
      if (new byte[] { 0, 1, 0, 0, 0, 1, 1, 1 }[k] != 1) {
        break label5253;
      }
      if (arrayOfByte18[k] != 0) {
        break label5115;
      }
      arrayOfByte17[k] = i;
      break label5115;
      i5 = i7;
      i1 = i3;
      n = i2;
      if (i6 == 0) {
        break label5547;
      }
      if ((i == arrayOfByte25[m]) || (arrayOfByte26[m] == 1)) {
        break label7339;
      }
      i5 = i7;
      i1 = i3;
      n = i2;
      if (arrayOfByte26[m] != 5) {
        break label5547;
      }
      i5 = k;
      if (arrayOfByte26[m] != 5) {
        break label5744;
      }
      arrayOfByte1[k] = i;
      arrayOfByte10[k] = i;
      arrayOfByte19[k] = i;
      arrayOfByte22[k] = i;
      if (k != 2) {
        break label5893;
      }
      arrayOfByte4[k] = ((byte)(i + 1));
      arrayOfByte7[k] = ((byte)(i + 2));
      arrayOfByte13[k] = ((byte)(i + 1));
      arrayOfByte16[k] = ((byte)(i + 2));
      i5 = k + 1;
      break label5744;
      i6 = 0;
      i1 = 1;
      break label5854;
    }
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject10 = str.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject9 = new File((String)localObject10);
    localObject7 = localObject8;
    localObject6 = localObject8;
    localObject1 = localObject8;
    if (((File)localObject9).exists()) {
      localObject7 = localObject9;
    }
    localObject6 = localObject7;
    localObject1 = localObject7;
    localObject9 = new File(((String)localObject10).replace("-1", "-2"));
    localObject8 = localObject7;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (((File)localObject9).exists()) {
      localObject8 = localObject9;
    }
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject9 = new File(((String)localObject10).replace("-1", ""));
    localObject7 = localObject8;
    localObject6 = localObject8;
    localObject1 = localObject8;
    if (((File)localObject9).exists()) {
      localObject7 = localObject9;
    }
    localObject6 = localObject7;
    localObject1 = localObject7;
    localObject10 = dalvikDexIn2.replace("zamenitetodelo", paramArrayOfString[0]);
    localObject6 = localObject7;
    localObject1 = localObject7;
    localObject9 = new File((String)localObject10);
    localObject8 = localObject9;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (!((File)localObject9).exists())
    {
      localObject6 = localObject7;
      localObject1 = localObject7;
      localObject8 = new File(((String)localObject10).replace("-1", "-2"));
    }
    localObject9 = localObject8;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (!((File)localObject8).exists())
    {
      localObject6 = localObject7;
      localObject1 = localObject7;
      localObject9 = new File(((String)localObject10).replace("-1", ""));
    }
    localObject8 = localObject7;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (((File)localObject9).exists()) {
      localObject8 = localObject9;
    }
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject10 = ((String)localObject10).replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject9 = new File((String)localObject10);
    localObject7 = localObject8;
    localObject6 = localObject8;
    localObject1 = localObject8;
    if (((File)localObject9).exists()) {
      localObject7 = localObject9;
    }
    localObject6 = localObject7;
    localObject1 = localObject7;
    localObject9 = new File(((String)localObject10).replace("-1", "-2"));
    localObject8 = localObject7;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (((File)localObject9).exists()) {
      localObject8 = localObject9;
    }
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject9 = new File(((String)localObject10).replace("-1", ""));
    localObject7 = localObject8;
    localObject6 = localObject8;
    localObject1 = localObject8;
    if (((File)localObject9).exists()) {
      localObject7 = localObject9;
    }
    localObject6 = localObject7;
    localObject1 = localObject7;
    localObject10 = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]).replace("/data/", "/sd-ext/data/");
    localObject6 = localObject7;
    localObject1 = localObject7;
    localObject9 = new File((String)localObject10);
    localObject8 = localObject9;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (!((File)localObject9).exists())
    {
      localObject6 = localObject7;
      localObject1 = localObject7;
      localObject8 = new File(((String)localObject10).replace("-1", "-2"));
    }
    localObject9 = localObject8;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (!((File)localObject8).exists())
    {
      localObject6 = localObject7;
      localObject1 = localObject7;
      localObject9 = new File(((String)localObject10).replace("-1", ""));
    }
    localObject8 = localObject7;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (((File)localObject9).exists()) {
      localObject8 = localObject9;
    }
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject10 = ((String)localObject10).replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject9 = new File((String)localObject10);
    localObject7 = localObject8;
    localObject6 = localObject8;
    localObject1 = localObject8;
    if (((File)localObject9).exists()) {
      localObject7 = localObject9;
    }
    localObject6 = localObject7;
    localObject1 = localObject7;
    localObject9 = new File(((String)localObject10).replace("-1", "-2"));
    localObject8 = localObject7;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (((File)localObject9).exists()) {
      localObject8 = localObject9;
    }
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject9 = new File(((String)localObject10).replace("-1", ""));
    localObject7 = localObject8;
    localObject6 = localObject8;
    localObject1 = localObject8;
    if (((File)localObject9).exists()) {
      localObject7 = localObject9;
    }
    localObject6 = localObject7;
    localObject1 = localObject7;
    localObject10 = dalvikDexIn2.replace("zamenitetodelo", paramArrayOfString[0]).replace("/cache/", "/sd-ext/data/cache/");
    localObject6 = localObject7;
    localObject1 = localObject7;
    localObject9 = new File((String)localObject10);
    localObject8 = localObject9;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (!((File)localObject9).exists())
    {
      localObject6 = localObject7;
      localObject1 = localObject7;
      localObject8 = new File(((String)localObject10).replace("-1", "-2"));
    }
    localObject9 = localObject8;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (!((File)localObject8).exists())
    {
      localObject6 = localObject7;
      localObject1 = localObject7;
      localObject9 = new File(((String)localObject10).replace("-1", ""));
    }
    localObject8 = localObject7;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (((File)localObject9).exists()) {
      localObject8 = localObject9;
    }
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject10 = ((String)localObject10).replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject9 = new File((String)localObject10);
    localObject7 = localObject8;
    localObject6 = localObject8;
    localObject1 = localObject8;
    if (((File)localObject9).exists()) {
      localObject7 = localObject9;
    }
    localObject6 = localObject7;
    localObject1 = localObject7;
    localObject9 = new File(((String)localObject10).replace("-1", "-2"));
    localObject8 = localObject7;
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (((File)localObject9).exists()) {
      localObject8 = localObject9;
    }
    localObject6 = localObject8;
    localObject1 = localObject8;
    localObject9 = new File(((String)localObject10).replace("-1", ""));
    localObject7 = localObject8;
    localObject6 = localObject8;
    localObject1 = localObject8;
    if (((File)localObject9).exists()) {
      localObject7 = localObject9;
    }
    localObject6 = localObject7;
    localObject1 = localObject7;
    if (!((File)localObject7).exists())
    {
      localObject6 = localObject7;
      localObject1 = localObject7;
      throw new FileNotFoundException();
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/nerorunpatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */