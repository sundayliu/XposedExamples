package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import net.lingala.zip4j.io.ZipInputStream;

public class restoredata
{
  /* Error */
  public static void ExtractAllFilesWithInputStreams(net.lingala.zip4j.core.ZipFile paramZipFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 16
    //   3: aconst_null
    //   4: astore 17
    //   6: aconst_null
    //   7: astore 18
    //   9: aconst_null
    //   10: astore 19
    //   12: aconst_null
    //   13: astore 20
    //   15: aconst_null
    //   16: astore 4
    //   18: aconst_null
    //   19: astore 21
    //   21: aconst_null
    //   22: astore 22
    //   24: aconst_null
    //   25: astore 23
    //   27: aconst_null
    //   28: astore 24
    //   30: aconst_null
    //   31: astore 7
    //   33: aload 16
    //   35: astore 9
    //   37: aload 7
    //   39: astore 13
    //   41: aload 17
    //   43: astore 10
    //   45: aload 21
    //   47: astore 14
    //   49: aload 18
    //   51: astore 11
    //   53: aload 22
    //   55: astore 15
    //   57: aload 19
    //   59: astore 5
    //   61: aload 23
    //   63: astore 6
    //   65: aload 20
    //   67: astore 12
    //   69: aload 24
    //   71: astore 8
    //   73: aload_0
    //   74: invokevirtual 27	net/lingala/zip4j/core/ZipFile:isEncrypted	()Z
    //   77: ifeq +49 -> 126
    //   80: aload 16
    //   82: astore 9
    //   84: aload 7
    //   86: astore 13
    //   88: aload 17
    //   90: astore 10
    //   92: aload 21
    //   94: astore 14
    //   96: aload 18
    //   98: astore 11
    //   100: aload 22
    //   102: astore 15
    //   104: aload 19
    //   106: astore 5
    //   108: aload 23
    //   110: astore 6
    //   112: aload 20
    //   114: astore 12
    //   116: aload 24
    //   118: astore 8
    //   120: aload_0
    //   121: ldc 29
    //   123: invokevirtual 33	net/lingala/zip4j/core/ZipFile:setPassword	(Ljava/lang/String;)V
    //   126: aload 16
    //   128: astore 9
    //   130: aload 7
    //   132: astore 13
    //   134: aload 17
    //   136: astore 10
    //   138: aload 21
    //   140: astore 14
    //   142: aload 18
    //   144: astore 11
    //   146: aload 22
    //   148: astore 15
    //   150: aload 19
    //   152: astore 5
    //   154: aload 23
    //   156: astore 6
    //   158: aload 20
    //   160: astore 12
    //   162: aload 24
    //   164: astore 8
    //   166: aload_0
    //   167: invokevirtual 37	net/lingala/zip4j/core/ZipFile:getFileHeaders	()Ljava/util/List;
    //   170: invokeinterface 43 1 0
    //   175: astore 16
    //   177: aconst_null
    //   178: astore 5
    //   180: aload 4
    //   182: astore 6
    //   184: aload 4
    //   186: astore 11
    //   188: aload 4
    //   190: astore 8
    //   192: aload 4
    //   194: astore 9
    //   196: aload 4
    //   198: astore 10
    //   200: aload 16
    //   202: invokeinterface 48 1 0
    //   207: ifeq +1274 -> 1481
    //   210: aload 4
    //   212: astore 6
    //   214: aload 4
    //   216: astore 11
    //   218: aload 4
    //   220: astore 8
    //   222: aload 4
    //   224: astore 9
    //   226: aload 4
    //   228: astore 10
    //   230: aload 16
    //   232: invokeinterface 52 1 0
    //   237: checkcast 54	net/lingala/zip4j/model/FileHeader
    //   240: astore 17
    //   242: aload 17
    //   244: ifnull +1202 -> 1446
    //   247: aload 4
    //   249: astore 6
    //   251: aload 4
    //   253: astore 11
    //   255: aload 4
    //   257: astore 8
    //   259: aload 4
    //   261: astore 9
    //   263: aload 4
    //   265: astore 10
    //   267: new 56	java/io/File
    //   270: dup
    //   271: new 58	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   278: aload_1
    //   279: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc 65
    //   284: invokestatic 71	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   287: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 17
    //   292: invokevirtual 75	net/lingala/zip4j/model/FileHeader:getFileName	()Ljava/lang/String;
    //   295: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   304: astore 18
    //   306: aload 4
    //   308: astore 6
    //   310: aload 4
    //   312: astore 11
    //   314: aload 4
    //   316: astore 8
    //   318: aload 4
    //   320: astore 9
    //   322: aload 4
    //   324: astore 10
    //   326: aload 17
    //   328: invokevirtual 83	net/lingala/zip4j/model/FileHeader:isDirectory	()Z
    //   331: ifeq +249 -> 580
    //   334: aload 4
    //   336: astore 6
    //   338: aload 4
    //   340: astore 11
    //   342: aload 4
    //   344: astore 8
    //   346: aload 4
    //   348: astore 9
    //   350: aload 4
    //   352: astore 10
    //   354: aload 18
    //   356: invokevirtual 86	java/io/File:mkdirs	()Z
    //   359: pop
    //   360: aload 4
    //   362: astore 6
    //   364: aload 4
    //   366: astore 11
    //   368: aload 4
    //   370: astore 8
    //   372: aload 4
    //   374: astore 9
    //   376: aload 4
    //   378: astore 10
    //   380: iconst_3
    //   381: anewarray 88	java/lang/String
    //   384: dup
    //   385: iconst_0
    //   386: ldc 90
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: ldc 92
    //   393: aastore
    //   394: dup
    //   395: iconst_2
    //   396: aload 18
    //   398: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   401: aastore
    //   402: invokestatic 101	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   405: pop
    //   406: aload 4
    //   408: astore 6
    //   410: aload 4
    //   412: astore 11
    //   414: aload 4
    //   416: astore 8
    //   418: aload 4
    //   420: astore 9
    //   422: aload 4
    //   424: astore 10
    //   426: iconst_3
    //   427: anewarray 88	java/lang/String
    //   430: dup
    //   431: iconst_0
    //   432: ldc 103
    //   434: aastore
    //   435: dup
    //   436: iconst_1
    //   437: new 58	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   444: ldc 105
    //   446: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_2
    //   450: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: aastore
    //   457: dup
    //   458: iconst_2
    //   459: aload 18
    //   461: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   464: aastore
    //   465: invokestatic 101	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   468: pop
    //   469: aload 4
    //   471: astore 6
    //   473: aload 4
    //   475: astore 11
    //   477: aload 4
    //   479: astore 8
    //   481: aload 4
    //   483: astore 9
    //   485: aload 4
    //   487: astore 10
    //   489: iconst_3
    //   490: anewarray 88	java/lang/String
    //   493: dup
    //   494: iconst_0
    //   495: ldc 103
    //   497: aastore
    //   498: dup
    //   499: iconst_1
    //   500: new 58	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   507: ldc 107
    //   509: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_2
    //   513: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: aastore
    //   520: dup
    //   521: iconst_2
    //   522: aload 18
    //   524: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   527: aastore
    //   528: invokestatic 101	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   531: pop
    //   532: goto -352 -> 180
    //   535: astore_0
    //   536: aload 5
    //   538: astore 8
    //   540: aload 6
    //   542: astore 12
    //   544: aload 12
    //   546: astore 5
    //   548: aload 8
    //   550: astore 6
    //   552: aload_0
    //   553: invokevirtual 110	net/lingala/zip4j/exception/ZipException:printStackTrace	()V
    //   556: aload 12
    //   558: astore 5
    //   560: aload 8
    //   562: astore 6
    //   564: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   567: ldc 116
    //   569: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   572: aload 12
    //   574: aload 8
    //   576: invokestatic 125	com/chelpus/root/utils/restoredata:closeFileHandlers	(Lnet/lingala/zip4j/io/ZipInputStream;Ljava/io/OutputStream;)V
    //   579: return
    //   580: aload 4
    //   582: astore 6
    //   584: aload 4
    //   586: astore 11
    //   588: aload 4
    //   590: astore 8
    //   592: aload 4
    //   594: astore 9
    //   596: aload 4
    //   598: astore 10
    //   600: aload 18
    //   602: invokevirtual 129	java/io/File:getParentFile	()Ljava/io/File;
    //   605: astore 7
    //   607: aload 4
    //   609: astore 6
    //   611: aload 4
    //   613: astore 11
    //   615: aload 4
    //   617: astore 8
    //   619: aload 4
    //   621: astore 9
    //   623: aload 4
    //   625: astore 10
    //   627: aload 7
    //   629: invokevirtual 132	java/io/File:exists	()Z
    //   632: ifne +201 -> 833
    //   635: aload 4
    //   637: astore 6
    //   639: aload 4
    //   641: astore 11
    //   643: aload 4
    //   645: astore 8
    //   647: aload 4
    //   649: astore 9
    //   651: aload 4
    //   653: astore 10
    //   655: aload 7
    //   657: invokevirtual 86	java/io/File:mkdirs	()Z
    //   660: pop
    //   661: aload 4
    //   663: astore 6
    //   665: aload 4
    //   667: astore 11
    //   669: aload 4
    //   671: astore 8
    //   673: aload 4
    //   675: astore 9
    //   677: aload 4
    //   679: astore 10
    //   681: iconst_3
    //   682: anewarray 88	java/lang/String
    //   685: dup
    //   686: iconst_0
    //   687: ldc 90
    //   689: aastore
    //   690: dup
    //   691: iconst_1
    //   692: ldc 92
    //   694: aastore
    //   695: dup
    //   696: iconst_2
    //   697: aload 7
    //   699: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   702: aastore
    //   703: invokestatic 101	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   706: pop
    //   707: aload 4
    //   709: astore 6
    //   711: aload 4
    //   713: astore 11
    //   715: aload 4
    //   717: astore 8
    //   719: aload 4
    //   721: astore 9
    //   723: aload 4
    //   725: astore 10
    //   727: iconst_3
    //   728: anewarray 88	java/lang/String
    //   731: dup
    //   732: iconst_0
    //   733: ldc 103
    //   735: aastore
    //   736: dup
    //   737: iconst_1
    //   738: new 58	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   745: ldc 105
    //   747: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload_2
    //   751: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: aastore
    //   758: dup
    //   759: iconst_2
    //   760: aload 7
    //   762: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   765: aastore
    //   766: invokestatic 101	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   769: pop
    //   770: aload 4
    //   772: astore 6
    //   774: aload 4
    //   776: astore 11
    //   778: aload 4
    //   780: astore 8
    //   782: aload 4
    //   784: astore 9
    //   786: aload 4
    //   788: astore 10
    //   790: iconst_3
    //   791: anewarray 88	java/lang/String
    //   794: dup
    //   795: iconst_0
    //   796: ldc 103
    //   798: aastore
    //   799: dup
    //   800: iconst_1
    //   801: new 58	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   808: ldc 107
    //   810: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: aload_2
    //   814: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: aastore
    //   821: dup
    //   822: iconst_2
    //   823: aload 7
    //   825: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   828: aastore
    //   829: invokestatic 101	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   832: pop
    //   833: aload 4
    //   835: astore 6
    //   837: aload 4
    //   839: astore 11
    //   841: aload 4
    //   843: astore 8
    //   845: aload 4
    //   847: astore 9
    //   849: aload 4
    //   851: astore 10
    //   853: aload_0
    //   854: aload 17
    //   856: invokevirtual 136	net/lingala/zip4j/core/ZipFile:getInputStream	(Lnet/lingala/zip4j/model/FileHeader;)Lnet/lingala/zip4j/io/ZipInputStream;
    //   859: astore 4
    //   861: aload 4
    //   863: astore 6
    //   865: aload 4
    //   867: astore 11
    //   869: aload 4
    //   871: astore 8
    //   873: aload 4
    //   875: astore 9
    //   877: aload 4
    //   879: astore 10
    //   881: new 138	java/io/FileOutputStream
    //   884: dup
    //   885: aload 18
    //   887: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   890: astore 7
    //   892: aload 4
    //   894: astore 9
    //   896: aload 7
    //   898: astore 13
    //   900: aload 4
    //   902: astore 10
    //   904: aload 7
    //   906: astore 14
    //   908: aload 4
    //   910: astore 11
    //   912: aload 7
    //   914: astore 15
    //   916: aload 4
    //   918: astore 5
    //   920: aload 7
    //   922: astore 6
    //   924: aload 4
    //   926: astore 12
    //   928: aload 7
    //   930: astore 8
    //   932: sipush 4096
    //   935: newarray <illegal type>
    //   937: astore 19
    //   939: aload 4
    //   941: astore 9
    //   943: aload 7
    //   945: astore 13
    //   947: aload 4
    //   949: astore 10
    //   951: aload 7
    //   953: astore 14
    //   955: aload 4
    //   957: astore 11
    //   959: aload 7
    //   961: astore 15
    //   963: aload 4
    //   965: astore 5
    //   967: aload 7
    //   969: astore 6
    //   971: aload 4
    //   973: astore 12
    //   975: aload 7
    //   977: astore 8
    //   979: aload 4
    //   981: aload 19
    //   983: invokevirtual 147	net/lingala/zip4j/io/ZipInputStream:read	([B)I
    //   986: istore_3
    //   987: iload_3
    //   988: iconst_m1
    //   989: if_icmpeq +55 -> 1044
    //   992: aload 4
    //   994: astore 9
    //   996: aload 7
    //   998: astore 13
    //   1000: aload 4
    //   1002: astore 10
    //   1004: aload 7
    //   1006: astore 14
    //   1008: aload 4
    //   1010: astore 11
    //   1012: aload 7
    //   1014: astore 15
    //   1016: aload 4
    //   1018: astore 5
    //   1020: aload 7
    //   1022: astore 6
    //   1024: aload 4
    //   1026: astore 12
    //   1028: aload 7
    //   1030: astore 8
    //   1032: aload 7
    //   1034: aload 19
    //   1036: iconst_0
    //   1037: iload_3
    //   1038: invokevirtual 153	java/io/OutputStream:write	([BII)V
    //   1041: goto -102 -> 939
    //   1044: aload 4
    //   1046: astore 9
    //   1048: aload 7
    //   1050: astore 13
    //   1052: aload 4
    //   1054: astore 10
    //   1056: aload 7
    //   1058: astore 14
    //   1060: aload 4
    //   1062: astore 11
    //   1064: aload 7
    //   1066: astore 15
    //   1068: aload 4
    //   1070: astore 5
    //   1072: aload 7
    //   1074: astore 6
    //   1076: aload 4
    //   1078: astore 12
    //   1080: aload 7
    //   1082: astore 8
    //   1084: aload 4
    //   1086: aload 7
    //   1088: invokestatic 125	com/chelpus/root/utils/restoredata:closeFileHandlers	(Lnet/lingala/zip4j/io/ZipInputStream;Ljava/io/OutputStream;)V
    //   1091: aload 4
    //   1093: astore 9
    //   1095: aload 7
    //   1097: astore 13
    //   1099: aload 4
    //   1101: astore 10
    //   1103: aload 7
    //   1105: astore 14
    //   1107: aload 4
    //   1109: astore 11
    //   1111: aload 7
    //   1113: astore 15
    //   1115: aload 4
    //   1117: astore 5
    //   1119: aload 7
    //   1121: astore 6
    //   1123: aload 4
    //   1125: astore 12
    //   1127: aload 7
    //   1129: astore 8
    //   1131: aload 17
    //   1133: aload 18
    //   1135: invokestatic 159	net/lingala/zip4j/unzip/UnzipUtil:applyFileAttributes	(Lnet/lingala/zip4j/model/FileHeader;Ljava/io/File;)V
    //   1138: aload 4
    //   1140: astore 9
    //   1142: aload 7
    //   1144: astore 13
    //   1146: aload 4
    //   1148: astore 10
    //   1150: aload 7
    //   1152: astore 14
    //   1154: aload 4
    //   1156: astore 11
    //   1158: aload 7
    //   1160: astore 15
    //   1162: aload 4
    //   1164: astore 5
    //   1166: aload 7
    //   1168: astore 6
    //   1170: aload 4
    //   1172: astore 12
    //   1174: aload 7
    //   1176: astore 8
    //   1178: iconst_3
    //   1179: anewarray 88	java/lang/String
    //   1182: dup
    //   1183: iconst_0
    //   1184: ldc 90
    //   1186: aastore
    //   1187: dup
    //   1188: iconst_1
    //   1189: ldc 92
    //   1191: aastore
    //   1192: dup
    //   1193: iconst_2
    //   1194: aload 18
    //   1196: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1199: aastore
    //   1200: invokestatic 101	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   1203: pop
    //   1204: aload 4
    //   1206: astore 9
    //   1208: aload 7
    //   1210: astore 13
    //   1212: aload 4
    //   1214: astore 10
    //   1216: aload 7
    //   1218: astore 14
    //   1220: aload 4
    //   1222: astore 11
    //   1224: aload 7
    //   1226: astore 15
    //   1228: aload 4
    //   1230: astore 5
    //   1232: aload 7
    //   1234: astore 6
    //   1236: aload 4
    //   1238: astore 12
    //   1240: aload 7
    //   1242: astore 8
    //   1244: iconst_3
    //   1245: anewarray 88	java/lang/String
    //   1248: dup
    //   1249: iconst_0
    //   1250: ldc 103
    //   1252: aastore
    //   1253: dup
    //   1254: iconst_1
    //   1255: new 58	java/lang/StringBuilder
    //   1258: dup
    //   1259: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1262: ldc 105
    //   1264: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: aload_2
    //   1268: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1274: aastore
    //   1275: dup
    //   1276: iconst_2
    //   1277: aload 18
    //   1279: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1282: aastore
    //   1283: invokestatic 101	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   1286: pop
    //   1287: aload 4
    //   1289: astore 9
    //   1291: aload 7
    //   1293: astore 13
    //   1295: aload 4
    //   1297: astore 10
    //   1299: aload 7
    //   1301: astore 14
    //   1303: aload 4
    //   1305: astore 11
    //   1307: aload 7
    //   1309: astore 15
    //   1311: aload 4
    //   1313: astore 5
    //   1315: aload 7
    //   1317: astore 6
    //   1319: aload 4
    //   1321: astore 12
    //   1323: aload 7
    //   1325: astore 8
    //   1327: iconst_3
    //   1328: anewarray 88	java/lang/String
    //   1331: dup
    //   1332: iconst_0
    //   1333: ldc 103
    //   1335: aastore
    //   1336: dup
    //   1337: iconst_1
    //   1338: new 58	java/lang/StringBuilder
    //   1341: dup
    //   1342: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1345: ldc 107
    //   1347: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: aload_2
    //   1351: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1357: aastore
    //   1358: dup
    //   1359: iconst_2
    //   1360: aload 18
    //   1362: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1365: aastore
    //   1366: invokestatic 101	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   1369: pop
    //   1370: aload 4
    //   1372: astore 9
    //   1374: aload 7
    //   1376: astore 13
    //   1378: aload 4
    //   1380: astore 10
    //   1382: aload 7
    //   1384: astore 14
    //   1386: aload 4
    //   1388: astore 11
    //   1390: aload 7
    //   1392: astore 15
    //   1394: aload 4
    //   1396: astore 5
    //   1398: aload 7
    //   1400: astore 6
    //   1402: aload 4
    //   1404: astore 12
    //   1406: aload 7
    //   1408: astore 8
    //   1410: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   1413: new 58	java/lang/StringBuilder
    //   1416: dup
    //   1417: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1420: ldc -95
    //   1422: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: aload 17
    //   1427: invokevirtual 75	net/lingala/zip4j/model/FileHeader:getFileName	()Ljava/lang/String;
    //   1430: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1436: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1439: aload 7
    //   1441: astore 5
    //   1443: goto -1263 -> 180
    //   1446: aload 4
    //   1448: astore 6
    //   1450: aload 4
    //   1452: astore 11
    //   1454: aload 4
    //   1456: astore 8
    //   1458: aload 4
    //   1460: astore 9
    //   1462: aload 4
    //   1464: astore 10
    //   1466: getstatic 164	java/lang/System:err	Ljava/io/PrintStream;
    //   1469: ldc -90
    //   1471: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1474: aload 5
    //   1476: astore 7
    //   1478: goto -39 -> 1439
    //   1481: aload 4
    //   1483: aload 5
    //   1485: invokestatic 125	com/chelpus/root/utils/restoredata:closeFileHandlers	(Lnet/lingala/zip4j/io/ZipInputStream;Ljava/io/OutputStream;)V
    //   1488: return
    //   1489: astore_0
    //   1490: aload_0
    //   1491: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   1494: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   1497: ldc 116
    //   1499: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1502: return
    //   1503: astore_0
    //   1504: aload_0
    //   1505: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   1508: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   1511: ldc 116
    //   1513: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1516: return
    //   1517: astore_0
    //   1518: aload 9
    //   1520: astore 5
    //   1522: aload 13
    //   1524: astore 6
    //   1526: aload_0
    //   1527: invokevirtual 168	java/io/FileNotFoundException:printStackTrace	()V
    //   1530: aload 9
    //   1532: astore 5
    //   1534: aload 13
    //   1536: astore 6
    //   1538: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   1541: ldc 116
    //   1543: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1546: aload 9
    //   1548: aload 13
    //   1550: invokestatic 125	com/chelpus/root/utils/restoredata:closeFileHandlers	(Lnet/lingala/zip4j/io/ZipInputStream;Ljava/io/OutputStream;)V
    //   1553: return
    //   1554: astore_0
    //   1555: aload_0
    //   1556: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   1559: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   1562: ldc 116
    //   1564: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1567: return
    //   1568: astore_0
    //   1569: aload 10
    //   1571: astore 9
    //   1573: aload 9
    //   1575: astore 5
    //   1577: aload 14
    //   1579: astore 6
    //   1581: aload_0
    //   1582: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   1585: aload 9
    //   1587: astore 5
    //   1589: aload 14
    //   1591: astore 6
    //   1593: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   1596: ldc 116
    //   1598: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1601: aload 9
    //   1603: aload 14
    //   1605: invokestatic 125	com/chelpus/root/utils/restoredata:closeFileHandlers	(Lnet/lingala/zip4j/io/ZipInputStream;Ljava/io/OutputStream;)V
    //   1608: return
    //   1609: astore_0
    //   1610: aload_0
    //   1611: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   1614: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   1617: ldc 116
    //   1619: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1622: return
    //   1623: astore_0
    //   1624: aload 11
    //   1626: astore 8
    //   1628: aload 8
    //   1630: astore 5
    //   1632: aload 15
    //   1634: astore 6
    //   1636: aload_0
    //   1637: invokevirtual 169	java/lang/Exception:printStackTrace	()V
    //   1640: aload 8
    //   1642: astore 5
    //   1644: aload 15
    //   1646: astore 6
    //   1648: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   1651: ldc 116
    //   1653: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1656: aload 8
    //   1658: aload 15
    //   1660: invokestatic 125	com/chelpus/root/utils/restoredata:closeFileHandlers	(Lnet/lingala/zip4j/io/ZipInputStream;Ljava/io/OutputStream;)V
    //   1663: return
    //   1664: astore_0
    //   1665: aload_0
    //   1666: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   1669: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   1672: ldc 116
    //   1674: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1677: return
    //   1678: astore_0
    //   1679: aload 5
    //   1681: aload 6
    //   1683: invokestatic 125	com/chelpus/root/utils/restoredata:closeFileHandlers	(Lnet/lingala/zip4j/io/ZipInputStream;Ljava/io/OutputStream;)V
    //   1686: aload_0
    //   1687: athrow
    //   1688: astore_1
    //   1689: aload_1
    //   1690: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   1693: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   1696: ldc 116
    //   1698: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1701: goto -15 -> 1686
    //   1704: astore_0
    //   1705: aload 5
    //   1707: astore 6
    //   1709: aload 11
    //   1711: astore 5
    //   1713: goto -34 -> 1679
    //   1716: astore_0
    //   1717: aload 5
    //   1719: astore 15
    //   1721: goto -93 -> 1628
    //   1724: astore_0
    //   1725: aload 5
    //   1727: astore 14
    //   1729: goto -156 -> 1573
    //   1732: astore_0
    //   1733: aload 10
    //   1735: astore 9
    //   1737: aload 5
    //   1739: astore 13
    //   1741: goto -223 -> 1518
    //   1744: astore_0
    //   1745: goto -1201 -> 544
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1748	0	paramZipFile	net.lingala.zip4j.core.ZipFile
    //   0	1748	1	paramString1	String
    //   0	1748	2	paramString2	String
    //   986	52	3	i	int
    //   16	1466	4	localZipInputStream	ZipInputStream
    //   59	1679	5	localObject1	Object
    //   63	1645	6	localObject2	Object
    //   31	1446	7	localObject3	Object
    //   71	1586	8	localObject4	Object
    //   35	1701	9	localObject5	Object
    //   43	1691	10	localObject6	Object
    //   51	1659	11	localObject7	Object
    //   67	1338	12	localObject8	Object
    //   39	1701	13	localObject9	Object
    //   47	1681	14	localObject10	Object
    //   55	1665	15	localObject11	Object
    //   1	230	16	localIterator	java.util.Iterator
    //   4	1422	17	localFileHeader	net.lingala.zip4j.model.FileHeader
    //   7	1354	18	localFile	File
    //   10	1025	19	arrayOfByte	byte[]
    //   13	146	20	localObject12	Object
    //   19	120	21	localObject13	Object
    //   22	125	22	localObject14	Object
    //   25	130	23	localObject15	Object
    //   28	135	24	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   200	210	535	net/lingala/zip4j/exception/ZipException
    //   230	242	535	net/lingala/zip4j/exception/ZipException
    //   267	306	535	net/lingala/zip4j/exception/ZipException
    //   326	334	535	net/lingala/zip4j/exception/ZipException
    //   354	360	535	net/lingala/zip4j/exception/ZipException
    //   380	406	535	net/lingala/zip4j/exception/ZipException
    //   426	469	535	net/lingala/zip4j/exception/ZipException
    //   489	532	535	net/lingala/zip4j/exception/ZipException
    //   600	607	535	net/lingala/zip4j/exception/ZipException
    //   627	635	535	net/lingala/zip4j/exception/ZipException
    //   655	661	535	net/lingala/zip4j/exception/ZipException
    //   681	707	535	net/lingala/zip4j/exception/ZipException
    //   727	770	535	net/lingala/zip4j/exception/ZipException
    //   790	833	535	net/lingala/zip4j/exception/ZipException
    //   853	861	535	net/lingala/zip4j/exception/ZipException
    //   881	892	535	net/lingala/zip4j/exception/ZipException
    //   1466	1474	535	net/lingala/zip4j/exception/ZipException
    //   1481	1488	1489	java/io/IOException
    //   572	579	1503	java/io/IOException
    //   73	80	1517	java/io/FileNotFoundException
    //   120	126	1517	java/io/FileNotFoundException
    //   166	177	1517	java/io/FileNotFoundException
    //   932	939	1517	java/io/FileNotFoundException
    //   979	987	1517	java/io/FileNotFoundException
    //   1032	1041	1517	java/io/FileNotFoundException
    //   1084	1091	1517	java/io/FileNotFoundException
    //   1131	1138	1517	java/io/FileNotFoundException
    //   1178	1204	1517	java/io/FileNotFoundException
    //   1244	1287	1517	java/io/FileNotFoundException
    //   1327	1370	1517	java/io/FileNotFoundException
    //   1410	1439	1517	java/io/FileNotFoundException
    //   1546	1553	1554	java/io/IOException
    //   73	80	1568	java/io/IOException
    //   120	126	1568	java/io/IOException
    //   166	177	1568	java/io/IOException
    //   932	939	1568	java/io/IOException
    //   979	987	1568	java/io/IOException
    //   1032	1041	1568	java/io/IOException
    //   1084	1091	1568	java/io/IOException
    //   1131	1138	1568	java/io/IOException
    //   1178	1204	1568	java/io/IOException
    //   1244	1287	1568	java/io/IOException
    //   1327	1370	1568	java/io/IOException
    //   1410	1439	1568	java/io/IOException
    //   1601	1608	1609	java/io/IOException
    //   73	80	1623	java/lang/Exception
    //   120	126	1623	java/lang/Exception
    //   166	177	1623	java/lang/Exception
    //   932	939	1623	java/lang/Exception
    //   979	987	1623	java/lang/Exception
    //   1032	1041	1623	java/lang/Exception
    //   1084	1091	1623	java/lang/Exception
    //   1131	1138	1623	java/lang/Exception
    //   1178	1204	1623	java/lang/Exception
    //   1244	1287	1623	java/lang/Exception
    //   1327	1370	1623	java/lang/Exception
    //   1410	1439	1623	java/lang/Exception
    //   1656	1663	1664	java/io/IOException
    //   73	80	1678	finally
    //   120	126	1678	finally
    //   166	177	1678	finally
    //   552	556	1678	finally
    //   564	572	1678	finally
    //   932	939	1678	finally
    //   979	987	1678	finally
    //   1032	1041	1678	finally
    //   1084	1091	1678	finally
    //   1131	1138	1678	finally
    //   1178	1204	1678	finally
    //   1244	1287	1678	finally
    //   1327	1370	1678	finally
    //   1410	1439	1678	finally
    //   1526	1530	1678	finally
    //   1538	1546	1678	finally
    //   1581	1585	1678	finally
    //   1593	1601	1678	finally
    //   1636	1640	1678	finally
    //   1648	1656	1678	finally
    //   1679	1686	1688	java/io/IOException
    //   200	210	1704	finally
    //   230	242	1704	finally
    //   267	306	1704	finally
    //   326	334	1704	finally
    //   354	360	1704	finally
    //   380	406	1704	finally
    //   426	469	1704	finally
    //   489	532	1704	finally
    //   600	607	1704	finally
    //   627	635	1704	finally
    //   655	661	1704	finally
    //   681	707	1704	finally
    //   727	770	1704	finally
    //   790	833	1704	finally
    //   853	861	1704	finally
    //   881	892	1704	finally
    //   1466	1474	1704	finally
    //   200	210	1716	java/lang/Exception
    //   230	242	1716	java/lang/Exception
    //   267	306	1716	java/lang/Exception
    //   326	334	1716	java/lang/Exception
    //   354	360	1716	java/lang/Exception
    //   380	406	1716	java/lang/Exception
    //   426	469	1716	java/lang/Exception
    //   489	532	1716	java/lang/Exception
    //   600	607	1716	java/lang/Exception
    //   627	635	1716	java/lang/Exception
    //   655	661	1716	java/lang/Exception
    //   681	707	1716	java/lang/Exception
    //   727	770	1716	java/lang/Exception
    //   790	833	1716	java/lang/Exception
    //   853	861	1716	java/lang/Exception
    //   881	892	1716	java/lang/Exception
    //   1466	1474	1716	java/lang/Exception
    //   200	210	1724	java/io/IOException
    //   230	242	1724	java/io/IOException
    //   267	306	1724	java/io/IOException
    //   326	334	1724	java/io/IOException
    //   354	360	1724	java/io/IOException
    //   380	406	1724	java/io/IOException
    //   426	469	1724	java/io/IOException
    //   489	532	1724	java/io/IOException
    //   600	607	1724	java/io/IOException
    //   627	635	1724	java/io/IOException
    //   655	661	1724	java/io/IOException
    //   681	707	1724	java/io/IOException
    //   727	770	1724	java/io/IOException
    //   790	833	1724	java/io/IOException
    //   853	861	1724	java/io/IOException
    //   881	892	1724	java/io/IOException
    //   1466	1474	1724	java/io/IOException
    //   200	210	1732	java/io/FileNotFoundException
    //   230	242	1732	java/io/FileNotFoundException
    //   267	306	1732	java/io/FileNotFoundException
    //   326	334	1732	java/io/FileNotFoundException
    //   354	360	1732	java/io/FileNotFoundException
    //   380	406	1732	java/io/FileNotFoundException
    //   426	469	1732	java/io/FileNotFoundException
    //   489	532	1732	java/io/FileNotFoundException
    //   600	607	1732	java/io/FileNotFoundException
    //   627	635	1732	java/io/FileNotFoundException
    //   655	661	1732	java/io/FileNotFoundException
    //   681	707	1732	java/io/FileNotFoundException
    //   727	770	1732	java/io/FileNotFoundException
    //   790	833	1732	java/io/FileNotFoundException
    //   853	861	1732	java/io/FileNotFoundException
    //   881	892	1732	java/io/FileNotFoundException
    //   1466	1474	1732	java/io/FileNotFoundException
    //   73	80	1744	net/lingala/zip4j/exception/ZipException
    //   120	126	1744	net/lingala/zip4j/exception/ZipException
    //   166	177	1744	net/lingala/zip4j/exception/ZipException
    //   932	939	1744	net/lingala/zip4j/exception/ZipException
    //   979	987	1744	net/lingala/zip4j/exception/ZipException
    //   1032	1041	1744	net/lingala/zip4j/exception/ZipException
    //   1084	1091	1744	net/lingala/zip4j/exception/ZipException
    //   1131	1138	1744	net/lingala/zip4j/exception/ZipException
    //   1178	1204	1744	net/lingala/zip4j/exception/ZipException
    //   1244	1287	1744	net/lingala/zip4j/exception/ZipException
    //   1327	1370	1744	net/lingala/zip4j/exception/ZipException
    //   1410	1439	1744	net/lingala/zip4j/exception/ZipException
  }
  
  private static void closeFileHandlers(ZipInputStream paramZipInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream != null) {
      paramOutputStream.close();
    }
    if (paramZipInputStream != null) {
      paramZipInputStream.close();
    }
  }
  
  public static void copyFolder(File paramFile1, File paramFile2, String paramString)
    throws Exception
  {
    int i = 0;
    if (paramFile1.isDirectory())
    {
      if (!paramFile2.exists())
      {
        paramFile2.mkdir();
        Utils.cmdParam(new String[] { "chmod", "771", paramFile2.getAbsolutePath() });
        Utils.cmdParam(new String[] { "chown", "0:" + paramString, paramFile2.getAbsolutePath() });
        Utils.cmdParam(new String[] { "chown", "0." + paramString, paramFile2.getAbsolutePath() });
        System.out.println("Directory copied from " + paramFile1 + "  to " + paramFile2);
      }
      String[] arrayOfString = paramFile1.list();
      if (arrayOfString.length > 0)
      {
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          copyFolder(new File(paramFile1, str), new File(paramFile2, str), paramString);
          i += 1;
        }
      }
    }
    else
    {
      Utils.copyFile(paramFile1, paramFile2);
      Utils.cmdParam(new String[] { "chmod", "771", paramFile2.getAbsolutePath() });
      Utils.cmdParam(new String[] { "chown", "0:" + paramString, paramFile2.getAbsolutePath() });
      Utils.cmdParam(new String[] { "chown", "0." + paramString, paramFile2.getAbsolutePath() });
    }
  }
  
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 6	com/chelpus/root/utils/restoredata$1
    //   3: dup
    //   4: invokespecial 203	com/chelpus/root/utils/restoredata$1:<init>	()V
    //   7: invokestatic 207	com/chelpus/Utils:startRootJava	(Ljava/lang/Object;)V
    //   10: aload_0
    //   11: iconst_0
    //   12: aaload
    //   13: astore 5
    //   15: aload_0
    //   16: iconst_1
    //   17: aaload
    //   18: astore 4
    //   20: aload_0
    //   21: iconst_2
    //   22: aaload
    //   23: astore_3
    //   24: aload_0
    //   25: iconst_3
    //   26: aaload
    //   27: astore_2
    //   28: aload_0
    //   29: iconst_4
    //   30: aaload
    //   31: astore_0
    //   32: new 56	java/io/File
    //   35: dup
    //   36: new 58	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   43: aload_3
    //   44: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc -47
    //   49: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 7
    //   60: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   63: aload 7
    //   65: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   71: aload 7
    //   73: invokevirtual 132	java/io/File:exists	()Z
    //   76: ifeq +47 -> 123
    //   79: new 56	java/io/File
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore 6
    //   90: new 23	net/lingala/zip4j/core/ZipFile
    //   93: dup
    //   94: aload 7
    //   96: invokespecial 210	net/lingala/zip4j/core/ZipFile:<init>	(Ljava/io/File;)V
    //   99: astore 7
    //   101: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   104: aload 6
    //   106: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   109: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   112: aload 7
    //   114: aload 6
    //   116: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   119: aload_2
    //   120: invokestatic 212	com/chelpus/root/utils/restoredata:ExtractAllFilesWithInputStreams	(Lnet/lingala/zip4j/core/ZipFile;Ljava/lang/String;Ljava/lang/String;)V
    //   123: new 56	java/io/File
    //   126: dup
    //   127: new 58	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   134: ldc -42
    //   136: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: invokevirtual 132	java/io/File:exists	()Z
    //   153: ifeq +368 -> 521
    //   156: new 56	java/io/File
    //   159: dup
    //   160: new 58	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   167: aload_3
    //   168: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc -40
    //   173: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   182: astore 6
    //   184: aload 6
    //   186: invokevirtual 132	java/io/File:exists	()Z
    //   189: istore_1
    //   190: iload_1
    //   191: ifeq +231 -> 422
    //   194: new 23	net/lingala/zip4j/core/ZipFile
    //   197: dup
    //   198: aload 6
    //   200: invokespecial 210	net/lingala/zip4j/core/ZipFile:<init>	(Ljava/io/File;)V
    //   203: new 58	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   210: ldc -42
    //   212: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 5
    //   217: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: aload_2
    //   224: invokestatic 212	com/chelpus/root/utils/restoredata:ExtractAllFilesWithInputStreams	(Lnet/lingala/zip4j/core/ZipFile;Ljava/lang/String;Ljava/lang/String;)V
    //   227: new 56	java/io/File
    //   230: dup
    //   231: new 58	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   238: aload_0
    //   239: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc -38
    //   244: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   253: invokevirtual 86	java/io/File:mkdirs	()Z
    //   256: pop
    //   257: new 56	java/io/File
    //   260: dup
    //   261: new 58	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   268: aload_3
    //   269: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc -36
    //   274: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   283: astore_3
    //   284: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   287: aload_3
    //   288: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   291: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   294: aload_3
    //   295: invokevirtual 132	java/io/File:exists	()Z
    //   298: ifeq +40 -> 338
    //   301: new 56	java/io/File
    //   304: dup
    //   305: aload_0
    //   306: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   309: astore_0
    //   310: new 23	net/lingala/zip4j/core/ZipFile
    //   313: dup
    //   314: aload_3
    //   315: invokespecial 210	net/lingala/zip4j/core/ZipFile:<init>	(Ljava/io/File;)V
    //   318: astore_3
    //   319: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   322: aload_0
    //   323: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   326: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   329: aload_3
    //   330: aload_0
    //   331: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   334: aload_2
    //   335: invokestatic 212	com/chelpus/root/utils/restoredata:ExtractAllFilesWithInputStreams	(Lnet/lingala/zip4j/core/ZipFile;Ljava/lang/String;Ljava/lang/String;)V
    //   338: invokestatic 223	com/chelpus/Utils:exitFromRootJava	()V
    //   341: return
    //   342: astore 6
    //   344: aload 6
    //   346: invokevirtual 110	net/lingala/zip4j/exception/ZipException:printStackTrace	()V
    //   349: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   352: ldc 116
    //   354: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   357: goto -234 -> 123
    //   360: astore_0
    //   361: aload_0
    //   362: invokevirtual 169	java/lang/Exception:printStackTrace	()V
    //   365: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   368: new 58	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   375: ldc -31
    //   377: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_0
    //   381: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   384: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   393: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   396: ldc 116
    //   398: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   401: goto -63 -> 338
    //   404: astore 4
    //   406: aload 4
    //   408: invokevirtual 110	net/lingala/zip4j/exception/ZipException:printStackTrace	()V
    //   411: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   414: ldc 116
    //   416: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   419: goto -192 -> 227
    //   422: new 56	java/io/File
    //   425: dup
    //   426: new 58	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   433: aload 4
    //   435: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc -28
    //   440: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   449: invokevirtual 132	java/io/File:exists	()Z
    //   452: ifeq -225 -> 227
    //   455: new 56	java/io/File
    //   458: dup
    //   459: new 58	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   466: aload 4
    //   468: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc -28
    //   473: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   482: new 56	java/io/File
    //   485: dup
    //   486: new 58	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   493: ldc -42
    //   495: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload 5
    //   500: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc -28
    //   505: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   514: aload_2
    //   515: invokestatic 196	com/chelpus/root/utils/restoredata:copyFolder	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
    //   518: goto -291 -> 227
    //   521: new 56	java/io/File
    //   524: dup
    //   525: new 58	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   532: aload_3
    //   533: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: ldc -40
    //   538: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   547: astore 5
    //   549: aload 5
    //   551: invokevirtual 132	java/io/File:exists	()Z
    //   554: istore_1
    //   555: iload_1
    //   556: ifeq -329 -> 227
    //   559: new 23	net/lingala/zip4j/core/ZipFile
    //   562: dup
    //   563: aload 5
    //   565: invokespecial 210	net/lingala/zip4j/core/ZipFile:<init>	(Ljava/io/File;)V
    //   568: aload 4
    //   570: aload_2
    //   571: invokestatic 212	com/chelpus/root/utils/restoredata:ExtractAllFilesWithInputStreams	(Lnet/lingala/zip4j/core/ZipFile;Ljava/lang/String;Ljava/lang/String;)V
    //   574: goto -347 -> 227
    //   577: astore 4
    //   579: aload 4
    //   581: invokevirtual 110	net/lingala/zip4j/exception/ZipException:printStackTrace	()V
    //   584: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   587: ldc 116
    //   589: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   592: goto -365 -> 227
    //   595: astore_0
    //   596: aload_0
    //   597: invokevirtual 110	net/lingala/zip4j/exception/ZipException:printStackTrace	()V
    //   600: getstatic 114	java/lang/System:out	Ljava/io/PrintStream;
    //   603: ldc 116
    //   605: invokevirtual 121	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   608: goto -270 -> 338
    //   611: astore_0
    //   612: aload_0
    //   613: invokevirtual 169	java/lang/Exception:printStackTrace	()V
    //   616: goto -278 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	paramArrayOfString	String[]
    //   189	367	1	bool	boolean
    //   27	544	2	str1	String
    //   23	510	3	localObject1	Object
    //   18	66	4	str2	String
    //   404	165	4	localZipException1	net.lingala.zip4j.exception.ZipException
    //   577	3	4	localZipException2	net.lingala.zip4j.exception.ZipException
    //   13	551	5	localObject2	Object
    //   88	111	6	localFile	File
    //   342	3	6	localZipException3	net.lingala.zip4j.exception.ZipException
    //   58	55	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   90	123	342	net/lingala/zip4j/exception/ZipException
    //   32	90	360	java/lang/Exception
    //   90	123	360	java/lang/Exception
    //   123	190	360	java/lang/Exception
    //   194	227	360	java/lang/Exception
    //   227	310	360	java/lang/Exception
    //   344	357	360	java/lang/Exception
    //   406	419	360	java/lang/Exception
    //   422	518	360	java/lang/Exception
    //   521	555	360	java/lang/Exception
    //   559	574	360	java/lang/Exception
    //   579	592	360	java/lang/Exception
    //   596	608	360	java/lang/Exception
    //   612	616	360	java/lang/Exception
    //   194	227	404	net/lingala/zip4j/exception/ZipException
    //   559	574	577	net/lingala/zip4j/exception/ZipException
    //   310	338	595	net/lingala/zip4j/exception/ZipException
    //   310	338	611	java/lang/Exception
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/restoredata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */