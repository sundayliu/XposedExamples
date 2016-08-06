package com.chelpus.root.utils;

public class checkRoot
{
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc 19
    //   2: astore 10
    //   4: ldc 19
    //   6: astore 11
    //   8: ldc 21
    //   10: astore 7
    //   12: ldc 19
    //   14: astore 6
    //   16: new 6	com/chelpus/root/utils/checkRoot$1
    //   19: dup
    //   20: invokespecial 22	com/chelpus/root/utils/checkRoot$1:<init>	()V
    //   23: invokestatic 28	com/chelpus/Utils:startRootJava	(Ljava/lang/Object;)V
    //   26: ldc 19
    //   28: astore 9
    //   30: aload_0
    //   31: iconst_0
    //   32: aaload
    //   33: ifnull +8 -> 41
    //   36: aload_0
    //   37: iconst_0
    //   38: aaload
    //   39: astore 9
    //   41: aload_0
    //   42: iconst_1
    //   43: aaload
    //   44: ifnull +8 -> 52
    //   47: aload_0
    //   48: iconst_1
    //   49: aaload
    //   50: astore 10
    //   52: aload_0
    //   53: iconst_2
    //   54: aaload
    //   55: ifnull +8 -> 63
    //   58: aload_0
    //   59: iconst_2
    //   60: aaload
    //   61: astore 11
    //   63: aload_0
    //   64: iconst_3
    //   65: aaload
    //   66: ifnull +8 -> 74
    //   69: aload_0
    //   70: iconst_3
    //   71: aaload
    //   72: astore 6
    //   74: aload 6
    //   76: ldc 30
    //   78: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifne +135 -> 216
    //   84: aload 10
    //   86: invokestatic 42	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   89: invokevirtual 46	java/lang/Integer:intValue	()I
    //   92: bipush 14
    //   94: if_icmplt +122 -> 216
    //   97: new 48	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   104: aload 6
    //   106: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 55
    //   111: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore_0
    //   118: new 48	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   125: aload 6
    //   127: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 61
    //   132: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore 6
    //   140: new 63	java/io/File
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: invokevirtual 70	java/io/File:exists	()Z
    //   151: ifeq +65 -> 216
    //   154: new 63	java/io/File
    //   157: dup
    //   158: aload_0
    //   159: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: invokestatic 74	com/chelpus/Utils:read_from_file	(Ljava/io/File;)Ljava/lang/String;
    //   165: ldc 76
    //   167: invokevirtual 80	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   170: ifeq +46 -> 216
    //   173: new 63	java/io/File
    //   176: dup
    //   177: aload 6
    //   179: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   182: invokevirtual 70	java/io/File:exists	()Z
    //   185: ifeq +974 -> 1159
    //   188: new 63	java/io/File
    //   191: dup
    //   192: aload 6
    //   194: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   197: invokestatic 74	com/chelpus/Utils:read_from_file	(Ljava/io/File;)Ljava/lang/String;
    //   200: ldc 82
    //   202: invokevirtual 80	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   205: ifeq +909 -> 1114
    //   208: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   211: ldc 90
    //   213: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   216: aload 9
    //   218: putstatic 101	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
    //   221: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   224: ldc 103
    //   226: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   229: aload 7
    //   231: astore 12
    //   233: iconst_1
    //   234: anewarray 32	java/lang/String
    //   237: dup
    //   238: iconst_0
    //   239: ldc 105
    //   241: aastore
    //   242: invokestatic 109	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   245: invokevirtual 112	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   248: ldc 114
    //   250: invokevirtual 80	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   253: ifeq +43 -> 296
    //   256: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   259: ldc 116
    //   261: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   264: ldc 118
    //   266: astore 12
    //   268: new 24	com/chelpus/Utils
    //   271: dup
    //   272: ldc 19
    //   274: invokespecial 119	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   277: pop
    //   278: iconst_2
    //   279: anewarray 32	java/lang/String
    //   282: dup
    //   283: iconst_0
    //   284: ldc 121
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: ldc 123
    //   291: aastore
    //   292: invokestatic 109	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   295: pop
    //   296: new 63	java/io/File
    //   299: dup
    //   300: ldc 125
    //   302: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   305: astore 17
    //   307: new 63	java/io/File
    //   310: dup
    //   311: ldc 127
    //   313: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   316: astore 18
    //   318: aload 18
    //   320: invokevirtual 70	java/io/File:exists	()Z
    //   323: ifne +889 -> 1212
    //   326: aload 17
    //   328: invokevirtual 130	java/io/File:mkdirs	()Z
    //   331: pop
    //   332: aload 17
    //   334: invokevirtual 70	java/io/File:exists	()Z
    //   337: ifne +11 -> 348
    //   340: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   343: ldc -124
    //   345: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   348: aload 18
    //   350: invokevirtual 135	java/io/File:createNewFile	()Z
    //   353: pop
    //   354: aload 18
    //   356: new 48	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   363: aload 9
    //   365: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc -119
    //   370: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 10
    //   375: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: ldc -119
    //   380: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload 11
    //   385: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc -119
    //   390: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload 12
    //   395: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 141	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   404: pop
    //   405: iconst_3
    //   406: anewarray 32	java/lang/String
    //   409: dup
    //   410: iconst_0
    //   411: ldc -113
    //   413: aastore
    //   414: dup
    //   415: iconst_1
    //   416: ldc -111
    //   418: aastore
    //   419: dup
    //   420: iconst_2
    //   421: aload 18
    //   423: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   426: aastore
    //   427: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   430: iconst_3
    //   431: anewarray 32	java/lang/String
    //   434: dup
    //   435: iconst_0
    //   436: ldc -113
    //   438: aastore
    //   439: dup
    //   440: iconst_1
    //   441: ldc -111
    //   443: aastore
    //   444: dup
    //   445: iconst_2
    //   446: aload 17
    //   448: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   451: aastore
    //   452: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   455: invokestatic 154	com/chelpus/Utils:initXposedParam	()Z
    //   458: ifne +11 -> 469
    //   461: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   464: ldc -100
    //   466: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   469: new 63	java/io/File
    //   472: dup
    //   473: ldc -98
    //   475: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   478: invokevirtual 70	java/io/File:exists	()Z
    //   481: ifne +109 -> 590
    //   484: new 63	java/io/File
    //   487: dup
    //   488: ldc -96
    //   490: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   493: invokevirtual 70	java/io/File:exists	()Z
    //   496: ifne +94 -> 590
    //   499: new 63	java/io/File
    //   502: dup
    //   503: ldc -94
    //   505: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   508: invokevirtual 70	java/io/File:exists	()Z
    //   511: ifne +79 -> 590
    //   514: new 63	java/io/File
    //   517: dup
    //   518: ldc -92
    //   520: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   523: invokevirtual 70	java/io/File:exists	()Z
    //   526: ifne +64 -> 590
    //   529: new 63	java/io/File
    //   532: dup
    //   533: ldc -90
    //   535: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   538: invokevirtual 70	java/io/File:exists	()Z
    //   541: ifne +49 -> 590
    //   544: new 63	java/io/File
    //   547: dup
    //   548: ldc -88
    //   550: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   553: invokevirtual 70	java/io/File:exists	()Z
    //   556: ifne +34 -> 590
    //   559: new 63	java/io/File
    //   562: dup
    //   563: ldc -86
    //   565: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   568: invokevirtual 70	java/io/File:exists	()Z
    //   571: ifne +19 -> 590
    //   574: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   577: ldc -84
    //   579: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   582: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   585: ldc -82
    //   587: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   590: new 63	java/io/File
    //   593: dup
    //   594: new 48	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   601: aload 9
    //   603: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: ldc -80
    //   608: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   617: invokevirtual 70	java/io/File:exists	()Z
    //   620: ifeq +87 -> 707
    //   623: new 48	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   630: aload 9
    //   632: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: ldc -80
    //   637: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: astore_0
    //   644: iconst_3
    //   645: anewarray 32	java/lang/String
    //   648: dup
    //   649: iconst_0
    //   650: ldc -113
    //   652: aastore
    //   653: dup
    //   654: iconst_1
    //   655: ldc -111
    //   657: aastore
    //   658: dup
    //   659: iconst_2
    //   660: aload_0
    //   661: aastore
    //   662: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   665: iconst_3
    //   666: anewarray 32	java/lang/String
    //   669: dup
    //   670: iconst_0
    //   671: ldc -78
    //   673: aastore
    //   674: dup
    //   675: iconst_1
    //   676: ldc -76
    //   678: aastore
    //   679: dup
    //   680: iconst_2
    //   681: aload_0
    //   682: aastore
    //   683: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   686: iconst_3
    //   687: anewarray 32	java/lang/String
    //   690: dup
    //   691: iconst_0
    //   692: ldc -78
    //   694: aastore
    //   695: dup
    //   696: iconst_1
    //   697: ldc -74
    //   699: aastore
    //   700: dup
    //   701: iconst_2
    //   702: aload_0
    //   703: aastore
    //   704: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   707: new 63	java/io/File
    //   710: dup
    //   711: new 48	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   718: aload 9
    //   720: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: ldc -72
    //   725: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   734: invokevirtual 70	java/io/File:exists	()Z
    //   737: ifeq +87 -> 824
    //   740: new 48	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   747: aload 9
    //   749: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: ldc -72
    //   754: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: astore_0
    //   761: iconst_3
    //   762: anewarray 32	java/lang/String
    //   765: dup
    //   766: iconst_0
    //   767: ldc -113
    //   769: aastore
    //   770: dup
    //   771: iconst_1
    //   772: ldc -70
    //   774: aastore
    //   775: dup
    //   776: iconst_2
    //   777: aload_0
    //   778: aastore
    //   779: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   782: iconst_3
    //   783: anewarray 32	java/lang/String
    //   786: dup
    //   787: iconst_0
    //   788: ldc -78
    //   790: aastore
    //   791: dup
    //   792: iconst_1
    //   793: ldc -76
    //   795: aastore
    //   796: dup
    //   797: iconst_2
    //   798: aload_0
    //   799: aastore
    //   800: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   803: iconst_3
    //   804: anewarray 32	java/lang/String
    //   807: dup
    //   808: iconst_0
    //   809: ldc -78
    //   811: aastore
    //   812: dup
    //   813: iconst_1
    //   814: ldc -74
    //   816: aastore
    //   817: dup
    //   818: iconst_2
    //   819: aload_0
    //   820: aastore
    //   821: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   824: new 63	java/io/File
    //   827: dup
    //   828: new 48	java/lang/StringBuilder
    //   831: dup
    //   832: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   835: aload 9
    //   837: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: ldc -68
    //   842: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   851: invokevirtual 70	java/io/File:exists	()Z
    //   854: ifeq +87 -> 941
    //   857: new 48	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   864: aload 9
    //   866: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: ldc -68
    //   871: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: astore_0
    //   878: iconst_3
    //   879: anewarray 32	java/lang/String
    //   882: dup
    //   883: iconst_0
    //   884: ldc -113
    //   886: aastore
    //   887: dup
    //   888: iconst_1
    //   889: ldc -111
    //   891: aastore
    //   892: dup
    //   893: iconst_2
    //   894: aload_0
    //   895: aastore
    //   896: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   899: iconst_3
    //   900: anewarray 32	java/lang/String
    //   903: dup
    //   904: iconst_0
    //   905: ldc -78
    //   907: aastore
    //   908: dup
    //   909: iconst_1
    //   910: ldc -76
    //   912: aastore
    //   913: dup
    //   914: iconst_2
    //   915: aload_0
    //   916: aastore
    //   917: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   920: iconst_3
    //   921: anewarray 32	java/lang/String
    //   924: dup
    //   925: iconst_0
    //   926: ldc -78
    //   928: aastore
    //   929: dup
    //   930: iconst_1
    //   931: ldc -74
    //   933: aastore
    //   934: dup
    //   935: iconst_2
    //   936: aload_0
    //   937: aastore
    //   938: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   941: iconst_0
    //   942: istore_1
    //   943: iconst_0
    //   944: istore_3
    //   945: iconst_0
    //   946: istore 4
    //   948: iload_3
    //   949: istore_2
    //   950: new 63	java/io/File
    //   953: dup
    //   954: ldc -66
    //   956: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   959: astore_0
    //   960: iload_3
    //   961: istore_2
    //   962: aload_0
    //   963: invokevirtual 70	java/io/File:exists	()Z
    //   966: ifeq +628 -> 1594
    //   969: iload_3
    //   970: istore_2
    //   971: aload_0
    //   972: invokevirtual 194	java/io/File:listFiles	()[Ljava/io/File;
    //   975: astore_0
    //   976: iload_3
    //   977: istore_2
    //   978: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   981: ldc -60
    //   983: invokevirtual 199	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   986: iload_3
    //   987: istore_2
    //   988: aload_0
    //   989: arraylength
    //   990: istore 5
    //   992: iconst_0
    //   993: istore_3
    //   994: iload 4
    //   996: istore_1
    //   997: iload_3
    //   998: iload 5
    //   1000: if_icmpge +584 -> 1584
    //   1003: aload_0
    //   1004: iload_3
    //   1005: aaload
    //   1006: astore 6
    //   1008: iload_1
    //   1009: istore_2
    //   1010: new 63	java/io/File
    //   1013: dup
    //   1014: aload 6
    //   1016: invokevirtual 200	java/io/File:toString	()Ljava/lang/String;
    //   1019: ldc -54
    //   1021: invokestatic 206	com/chelpus/Utils:changeExtension	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1024: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   1027: astore 7
    //   1029: iload_1
    //   1030: istore 4
    //   1032: iload_1
    //   1033: istore_2
    //   1034: aload 6
    //   1036: invokevirtual 200	java/io/File:toString	()Ljava/lang/String;
    //   1039: invokevirtual 112	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1042: ldc -48
    //   1044: invokevirtual 212	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1047: ifeq +57 -> 1104
    //   1050: iload_1
    //   1051: istore 4
    //   1053: iload_1
    //   1054: istore_2
    //   1055: aload 7
    //   1057: invokevirtual 70	java/io/File:exists	()Z
    //   1060: ifne +44 -> 1104
    //   1063: iload_1
    //   1064: istore_2
    //   1065: aload 6
    //   1067: invokevirtual 215	java/io/File:delete	()Z
    //   1070: pop
    //   1071: iload_1
    //   1072: istore_2
    //   1073: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   1076: new 48	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1083: aload 6
    //   1085: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1088: ldc -36
    //   1090: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1096: invokevirtual 199	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   1099: iload_1
    //   1100: iconst_1
    //   1101: iadd
    //   1102: istore 4
    //   1104: iload_3
    //   1105: iconst_1
    //   1106: iadd
    //   1107: istore_3
    //   1108: iload 4
    //   1110: istore_1
    //   1111: goto -114 -> 997
    //   1114: new 63	java/io/File
    //   1117: dup
    //   1118: aload_0
    //   1119: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   1122: invokestatic 74	com/chelpus/Utils:read_from_file	(Ljava/io/File;)Ljava/lang/String;
    //   1125: ldc 76
    //   1127: ldc -34
    //   1129: invokevirtual 226	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1132: astore 6
    //   1134: new 63	java/io/File
    //   1137: dup
    //   1138: aload_0
    //   1139: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   1142: aload 6
    //   1144: invokestatic 141	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   1147: pop
    //   1148: goto -932 -> 216
    //   1151: astore_0
    //   1152: aload_0
    //   1153: invokevirtual 229	java/lang/Exception:printStackTrace	()V
    //   1156: goto -940 -> 216
    //   1159: new 63	java/io/File
    //   1162: dup
    //   1163: aload_0
    //   1164: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   1167: invokestatic 74	com/chelpus/Utils:read_from_file	(Ljava/io/File;)Ljava/lang/String;
    //   1170: ldc 76
    //   1172: ldc -34
    //   1174: invokevirtual 226	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1177: astore 6
    //   1179: new 63	java/io/File
    //   1182: dup
    //   1183: aload_0
    //   1184: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   1187: aload 6
    //   1189: invokestatic 141	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   1192: pop
    //   1193: goto -977 -> 216
    //   1196: astore_0
    //   1197: aload_0
    //   1198: invokevirtual 230	java/io/IOException:printStackTrace	()V
    //   1201: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   1204: ldc -24
    //   1206: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1209: goto -754 -> 455
    //   1212: ldc 19
    //   1214: astore 7
    //   1216: ldc 19
    //   1218: astore 8
    //   1220: ldc 19
    //   1222: astore 6
    //   1224: ldc 19
    //   1226: astore_0
    //   1227: aload 18
    //   1229: invokestatic 74	com/chelpus/Utils:read_from_file	(Ljava/io/File;)Ljava/lang/String;
    //   1232: ldc -119
    //   1234: invokevirtual 236	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1237: astore 19
    //   1239: aload 8
    //   1241: astore 13
    //   1243: aload 7
    //   1245: astore 14
    //   1247: aload 6
    //   1249: astore 15
    //   1251: aload_0
    //   1252: astore 16
    //   1254: aload 19
    //   1256: ifnull +122 -> 1378
    //   1259: aload 8
    //   1261: astore 13
    //   1263: aload 7
    //   1265: astore 14
    //   1267: aload 6
    //   1269: astore 15
    //   1271: aload_0
    //   1272: astore 16
    //   1274: aload 19
    //   1276: arraylength
    //   1277: ifle +101 -> 1378
    //   1280: iconst_0
    //   1281: istore_1
    //   1282: aload 8
    //   1284: astore 13
    //   1286: aload 7
    //   1288: astore 14
    //   1290: aload 6
    //   1292: astore 15
    //   1294: aload_0
    //   1295: astore 16
    //   1297: iload_1
    //   1298: aload 19
    //   1300: arraylength
    //   1301: if_icmpge +77 -> 1378
    //   1304: iload_1
    //   1305: tableswitch	default:+31->1336, 0:+38->1343, 1:+47->1352, 2:+56->1361, 3:+65->1370
    //   1336: iload_1
    //   1337: iconst_1
    //   1338: iadd
    //   1339: istore_1
    //   1340: goto -58 -> 1282
    //   1343: aload 19
    //   1345: iload_1
    //   1346: aaload
    //   1347: astore 7
    //   1349: goto -13 -> 1336
    //   1352: aload 19
    //   1354: iload_1
    //   1355: aaload
    //   1356: astore 8
    //   1358: goto -22 -> 1336
    //   1361: aload 19
    //   1363: iload_1
    //   1364: aaload
    //   1365: astore 6
    //   1367: goto -31 -> 1336
    //   1370: aload 19
    //   1372: iload_1
    //   1373: aaload
    //   1374: astore_0
    //   1375: goto -39 -> 1336
    //   1378: aload 14
    //   1380: aload 9
    //   1382: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1385: ifeq +69 -> 1454
    //   1388: aload 10
    //   1390: aload 13
    //   1392: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1395: ifeq +59 -> 1454
    //   1398: aload 11
    //   1400: aload 15
    //   1402: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1405: ifeq +49 -> 1454
    //   1408: aload 12
    //   1410: aload 16
    //   1412: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1415: ifeq +39 -> 1454
    //   1418: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   1421: ldc -18
    //   1423: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1426: iconst_3
    //   1427: anewarray 32	java/lang/String
    //   1430: dup
    //   1431: iconst_0
    //   1432: ldc -113
    //   1434: aastore
    //   1435: dup
    //   1436: iconst_1
    //   1437: ldc -111
    //   1439: aastore
    //   1440: dup
    //   1441: iconst_2
    //   1442: aload 18
    //   1444: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1447: aastore
    //   1448: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1451: goto -996 -> 455
    //   1454: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   1457: new 48	java/lang/StringBuilder
    //   1460: dup
    //   1461: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1464: ldc -16
    //   1466: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: aload 14
    //   1471: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1477: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1480: iconst_3
    //   1481: anewarray 32	java/lang/String
    //   1484: dup
    //   1485: iconst_0
    //   1486: ldc -113
    //   1488: aastore
    //   1489: dup
    //   1490: iconst_1
    //   1491: ldc -111
    //   1493: aastore
    //   1494: dup
    //   1495: iconst_2
    //   1496: aload 18
    //   1498: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1501: aastore
    //   1502: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1505: iconst_3
    //   1506: anewarray 32	java/lang/String
    //   1509: dup
    //   1510: iconst_0
    //   1511: ldc -113
    //   1513: aastore
    //   1514: dup
    //   1515: iconst_1
    //   1516: ldc -111
    //   1518: aastore
    //   1519: dup
    //   1520: iconst_2
    //   1521: aload 17
    //   1523: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1526: aastore
    //   1527: invokestatic 151	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1530: aload 18
    //   1532: new 48	java/lang/StringBuilder
    //   1535: dup
    //   1536: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1539: aload 9
    //   1541: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: ldc -119
    //   1546: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1549: aload 10
    //   1551: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: ldc -119
    //   1556: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: aload 11
    //   1561: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: ldc -119
    //   1566: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload 12
    //   1571: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1577: invokestatic 141	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   1580: pop
    //   1581: goto -1126 -> 455
    //   1584: iload_1
    //   1585: istore_2
    //   1586: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   1589: ldc -14
    //   1591: invokevirtual 199	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   1594: iload_1
    //   1595: ifle +11 -> 1606
    //   1598: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   1601: ldc -12
    //   1603: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1606: invokestatic 247	com/chelpus/Utils:exitFromRootJava	()V
    //   1609: return
    //   1610: astore_0
    //   1611: getstatic 88	java/lang/System:out	Ljava/io/PrintStream;
    //   1614: new 48	java/lang/StringBuilder
    //   1617: dup
    //   1618: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1621: ldc -7
    //   1623: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: aload_0
    //   1627: invokevirtual 250	java/lang/Exception:toString	()Ljava/lang/String;
    //   1630: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1636: invokevirtual 95	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1639: iload_2
    //   1640: istore_1
    //   1641: goto -47 -> 1594
    //   1644: astore_0
    //   1645: aload 7
    //   1647: astore 12
    //   1649: goto -1353 -> 296
    //   1652: astore_0
    //   1653: goto -1357 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1656	0	paramArrayOfString	String[]
    //   942	699	1	i	int
    //   949	691	2	j	int
    //   944	164	3	k	int
    //   946	163	4	m	int
    //   990	11	5	n	int
    //   14	1352	6	str1	String
    //   10	1636	7	localObject1	Object
    //   1218	139	8	str2	String
    //   28	1512	9	str3	String
    //   2	1548	10	str4	String
    //   6	1554	11	str5	String
    //   231	1417	12	localObject2	Object
    //   1241	150	13	str6	String
    //   1245	225	14	localObject3	Object
    //   1249	152	15	str7	String
    //   1252	159	16	arrayOfString1	String[]
    //   305	1217	17	localFile1	java.io.File
    //   316	1215	18	localFile2	java.io.File
    //   1237	134	19	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   97	216	1151	java/lang/Exception
    //   1114	1148	1151	java/lang/Exception
    //   1159	1193	1151	java/lang/Exception
    //   348	455	1196	java/io/IOException
    //   950	960	1610	java/lang/Exception
    //   962	969	1610	java/lang/Exception
    //   971	976	1610	java/lang/Exception
    //   978	986	1610	java/lang/Exception
    //   988	992	1610	java/lang/Exception
    //   1010	1029	1610	java/lang/Exception
    //   1034	1050	1610	java/lang/Exception
    //   1055	1063	1610	java/lang/Exception
    //   1065	1071	1610	java/lang/Exception
    //   1073	1099	1610	java/lang/Exception
    //   1586	1594	1610	java/lang/Exception
    //   233	264	1644	java/lang/Exception
    //   268	296	1652	java/lang/Exception
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/checkRoot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */