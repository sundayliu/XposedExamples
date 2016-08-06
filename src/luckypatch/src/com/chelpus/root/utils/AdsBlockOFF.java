package com.chelpus.root.utils;

public class AdsBlockOFF
{
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 6	com/chelpus/root/utils/AdsBlockOFF$1
    //   3: dup
    //   4: invokespecial 18	com/chelpus/root/utils/AdsBlockOFF$1:<init>	()V
    //   7: invokestatic 24	com/chelpus/Utils:startRootJava	(Ljava/lang/Object;)V
    //   10: aload_0
    //   11: iconst_0
    //   12: aaload
    //   13: astore 7
    //   15: aload_0
    //   16: iconst_1
    //   17: aaload
    //   18: astore 6
    //   20: aload_0
    //   21: iconst_2
    //   22: aaload
    //   23: astore_0
    //   24: ldc 26
    //   26: astore_0
    //   27: iconst_0
    //   28: istore_2
    //   29: iconst_0
    //   30: istore_1
    //   31: ldc 28
    //   33: ldc 30
    //   35: invokestatic 34	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   38: pop
    //   39: iconst_3
    //   40: anewarray 36	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: ldc 38
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: ldc 40
    //   52: aastore
    //   53: dup
    //   54: iconst_2
    //   55: ldc 42
    //   57: aastore
    //   58: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   61: iconst_3
    //   62: anewarray 36	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: ldc 47
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: ldc 49
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: ldc 42
    //   79: aastore
    //   80: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   83: aload 7
    //   85: invokestatic 53	com/chelpus/Utils:getSimulink	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore 5
    //   90: aload 5
    //   92: ldc 55
    //   94: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifne +6 -> 103
    //   100: aload 5
    //   102: astore_0
    //   103: iload_2
    //   104: istore_3
    //   105: new 61	java/io/File
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 68	java/io/File:exists	()Z
    //   116: ifeq +84 -> 200
    //   119: iload_2
    //   120: istore_3
    //   121: new 61	java/io/File
    //   124: dup
    //   125: aload_0
    //   126: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: invokevirtual 72	java/io/File:length	()J
    //   132: new 61	java/io/File
    //   135: dup
    //   136: aload 7
    //   138: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: invokevirtual 72	java/io/File:length	()J
    //   144: lcmp
    //   145: ifne +55 -> 200
    //   148: iconst_1
    //   149: istore_3
    //   150: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   153: ldc 80
    //   155: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   158: iconst_3
    //   159: anewarray 36	java/lang/String
    //   162: dup
    //   163: iconst_0
    //   164: ldc 38
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: ldc 40
    //   171: aastore
    //   172: dup
    //   173: iconst_2
    //   174: aload_0
    //   175: aastore
    //   176: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   179: iconst_3
    //   180: anewarray 36	java/lang/String
    //   183: dup
    //   184: iconst_0
    //   185: ldc 47
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: ldc 49
    //   192: aastore
    //   193: dup
    //   194: iconst_2
    //   195: aload_0
    //   196: aastore
    //   197: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   200: new 61	java/io/File
    //   203: dup
    //   204: aload 7
    //   206: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: invokevirtual 68	java/io/File:exists	()Z
    //   212: ifne +18 -> 230
    //   215: new 61	java/io/File
    //   218: dup
    //   219: ldc 42
    //   221: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   224: ldc 87
    //   226: invokestatic 91	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   229: pop
    //   230: iload_3
    //   231: ifne +121 -> 352
    //   234: new 93	java/io/RandomAccessFile
    //   237: dup
    //   238: aload 7
    //   240: ldc 95
    //   242: invokespecial 98	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: astore 5
    //   247: aload 5
    //   249: lconst_0
    //   250: invokevirtual 102	java/io/RandomAccessFile:seek	(J)V
    //   253: new 93	java/io/RandomAccessFile
    //   256: dup
    //   257: aload 6
    //   259: ldc 30
    //   261: invokespecial 98	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: astore 8
    //   266: aload 8
    //   268: lconst_0
    //   269: invokevirtual 105	java/io/RandomAccessFile:setLength	(J)V
    //   272: aload 8
    //   274: lconst_0
    //   275: invokevirtual 102	java/io/RandomAccessFile:seek	(J)V
    //   278: iconst_1
    //   279: istore_2
    //   280: aload 5
    //   282: invokevirtual 109	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   285: astore 9
    //   287: aload 9
    //   289: ifnull +85 -> 374
    //   292: aload 9
    //   294: ldc 111
    //   296: invokevirtual 115	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   299: ifne +68 -> 367
    //   302: iload_2
    //   303: ifeq +64 -> 367
    //   306: aload 8
    //   308: new 117	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   315: aload 9
    //   317: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc 124
    //   322: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokevirtual 130	java/io/RandomAccessFile:writeBytes	(Ljava/lang/String;)V
    //   331: aload 9
    //   333: ldc -124
    //   335: invokevirtual 115	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   338: istore 4
    //   340: iload 4
    //   342: ifeq -62 -> 280
    //   345: iconst_1
    //   346: istore_1
    //   347: iconst_1
    //   348: istore_2
    //   349: goto -69 -> 280
    //   352: new 93	java/io/RandomAccessFile
    //   355: dup
    //   356: aload_0
    //   357: ldc 95
    //   359: invokespecial 98	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: astore 5
    //   364: goto -117 -> 247
    //   367: iconst_0
    //   368: istore_2
    //   369: iconst_1
    //   370: istore_1
    //   371: goto -40 -> 331
    //   374: aload 5
    //   376: invokevirtual 135	java/io/RandomAccessFile:close	()V
    //   379: aload 8
    //   381: invokevirtual 135	java/io/RandomAccessFile:close	()V
    //   384: iload_1
    //   385: ifeq +11 -> 396
    //   388: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   391: ldc -119
    //   393: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   396: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   399: ldc 28
    //   401: ldc 30
    //   403: invokestatic 34	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   406: invokevirtual 140	java/io/PrintStream:println	(Z)V
    //   409: iconst_3
    //   410: anewarray 36	java/lang/String
    //   413: dup
    //   414: iconst_0
    //   415: ldc 38
    //   417: aastore
    //   418: dup
    //   419: iconst_1
    //   420: ldc 40
    //   422: aastore
    //   423: dup
    //   424: iconst_2
    //   425: ldc 42
    //   427: aastore
    //   428: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   431: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   434: ldc 28
    //   436: ldc 30
    //   438: invokestatic 34	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   441: invokevirtual 140	java/io/PrintStream:println	(Z)V
    //   444: iload_3
    //   445: ifne +509 -> 954
    //   448: new 61	java/io/File
    //   451: dup
    //   452: aload 6
    //   454: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   457: new 61	java/io/File
    //   460: dup
    //   461: ldc 42
    //   463: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   466: invokestatic 144	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   469: new 61	java/io/File
    //   472: dup
    //   473: aload 6
    //   475: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   478: invokevirtual 72	java/io/File:length	()J
    //   481: new 61	java/io/File
    //   484: dup
    //   485: ldc 42
    //   487: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   490: invokevirtual 72	java/io/File:length	()J
    //   493: lcmp
    //   494: ifeq +398 -> 892
    //   497: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   500: aload 6
    //   502: invokevirtual 147	java/lang/String:length	()I
    //   505: invokevirtual 150	java/io/PrintStream:println	(I)V
    //   508: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   511: new 61	java/io/File
    //   514: dup
    //   515: ldc 42
    //   517: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   520: invokevirtual 72	java/io/File:length	()J
    //   523: invokevirtual 152	java/io/PrintStream:println	(J)V
    //   526: new 61	java/io/File
    //   529: dup
    //   530: aload 7
    //   532: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   535: invokevirtual 155	java/io/File:delete	()Z
    //   538: pop
    //   539: new 61	java/io/File
    //   542: dup
    //   543: aload 6
    //   545: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   548: new 61	java/io/File
    //   551: dup
    //   552: aload_0
    //   553: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   556: invokestatic 144	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   559: new 61	java/io/File
    //   562: dup
    //   563: aload 6
    //   565: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   568: invokevirtual 72	java/io/File:length	()J
    //   571: new 61	java/io/File
    //   574: dup
    //   575: aload_0
    //   576: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   579: invokevirtual 72	java/io/File:length	()J
    //   582: lcmp
    //   583: ifeq +156 -> 739
    //   586: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   589: ldc -99
    //   591: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   594: new 61	java/io/File
    //   597: dup
    //   598: aload 6
    //   600: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   603: invokevirtual 155	java/io/File:delete	()Z
    //   606: pop
    //   607: new 61	java/io/File
    //   610: dup
    //   611: aload_0
    //   612: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   615: invokevirtual 155	java/io/File:delete	()Z
    //   618: pop
    //   619: new 61	java/io/File
    //   622: dup
    //   623: ldc 42
    //   625: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   628: ldc 87
    //   630: invokestatic 91	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   633: pop
    //   634: iconst_3
    //   635: anewarray 36	java/lang/String
    //   638: dup
    //   639: iconst_0
    //   640: ldc 38
    //   642: aastore
    //   643: dup
    //   644: iconst_1
    //   645: ldc -97
    //   647: aastore
    //   648: dup
    //   649: iconst_2
    //   650: ldc 42
    //   652: aastore
    //   653: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   656: ldc 28
    //   658: ldc -95
    //   660: invokestatic 34	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   663: pop
    //   664: return
    //   665: astore_0
    //   666: aload_0
    //   667: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   670: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   673: ldc -99
    //   675: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   678: new 61	java/io/File
    //   681: dup
    //   682: aload 6
    //   684: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   687: invokevirtual 155	java/io/File:delete	()Z
    //   690: pop
    //   691: iconst_3
    //   692: anewarray 36	java/lang/String
    //   695: dup
    //   696: iconst_0
    //   697: ldc 38
    //   699: aastore
    //   700: dup
    //   701: iconst_1
    //   702: ldc -97
    //   704: aastore
    //   705: dup
    //   706: iconst_2
    //   707: ldc 42
    //   709: aastore
    //   710: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   713: ldc 28
    //   715: ldc -95
    //   717: invokestatic 34	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   720: pop
    //   721: return
    //   722: astore_0
    //   723: aload_0
    //   724: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   727: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   730: ldc -90
    //   732: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   735: invokestatic 169	com/chelpus/Utils:exitFromRootJava	()V
    //   738: return
    //   739: iconst_3
    //   740: anewarray 36	java/lang/String
    //   743: dup
    //   744: iconst_0
    //   745: ldc 38
    //   747: aastore
    //   748: dup
    //   749: iconst_1
    //   750: ldc -97
    //   752: aastore
    //   753: dup
    //   754: iconst_2
    //   755: aload_0
    //   756: aastore
    //   757: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   760: iconst_3
    //   761: anewarray 36	java/lang/String
    //   764: dup
    //   765: iconst_0
    //   766: ldc 47
    //   768: aastore
    //   769: dup
    //   770: iconst_1
    //   771: ldc 49
    //   773: aastore
    //   774: dup
    //   775: iconst_2
    //   776: aload_0
    //   777: aastore
    //   778: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   781: iconst_3
    //   782: anewarray 36	java/lang/String
    //   785: dup
    //   786: iconst_0
    //   787: ldc -85
    //   789: aastore
    //   790: dup
    //   791: iconst_1
    //   792: ldc -83
    //   794: aastore
    //   795: dup
    //   796: iconst_2
    //   797: aload_0
    //   798: aastore
    //   799: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   802: iconst_3
    //   803: anewarray 36	java/lang/String
    //   806: dup
    //   807: iconst_0
    //   808: ldc -85
    //   810: aastore
    //   811: dup
    //   812: iconst_1
    //   813: ldc -81
    //   815: aastore
    //   816: dup
    //   817: iconst_2
    //   818: aload_0
    //   819: aastore
    //   820: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   823: iconst_4
    //   824: anewarray 36	java/lang/String
    //   827: dup
    //   828: iconst_0
    //   829: ldc -79
    //   831: aastore
    //   832: dup
    //   833: iconst_1
    //   834: ldc -77
    //   836: aastore
    //   837: dup
    //   838: iconst_2
    //   839: aload_0
    //   840: aastore
    //   841: dup
    //   842: iconst_3
    //   843: ldc 42
    //   845: aastore
    //   846: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   849: new 61	java/io/File
    //   852: dup
    //   853: aload 6
    //   855: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   858: invokevirtual 155	java/io/File:delete	()Z
    //   861: pop
    //   862: iconst_3
    //   863: anewarray 36	java/lang/String
    //   866: dup
    //   867: iconst_0
    //   868: ldc 38
    //   870: aastore
    //   871: dup
    //   872: iconst_1
    //   873: ldc -97
    //   875: aastore
    //   876: dup
    //   877: iconst_2
    //   878: ldc 42
    //   880: aastore
    //   881: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   884: ldc 28
    //   886: ldc -95
    //   888: invokestatic 34	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   891: pop
    //   892: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   895: ldc -75
    //   897: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   900: new 61	java/io/File
    //   903: dup
    //   904: aload 6
    //   906: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   909: invokevirtual 155	java/io/File:delete	()Z
    //   912: pop
    //   913: iconst_3
    //   914: anewarray 36	java/lang/String
    //   917: dup
    //   918: iconst_0
    //   919: ldc 38
    //   921: aastore
    //   922: dup
    //   923: iconst_1
    //   924: ldc -97
    //   926: aastore
    //   927: dup
    //   928: iconst_2
    //   929: ldc 42
    //   931: aastore
    //   932: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   935: goto -200 -> 735
    //   938: astore_0
    //   939: aload_0
    //   940: invokevirtual 182	java/lang/OutOfMemoryError:printStackTrace	()V
    //   943: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   946: ldc -72
    //   948: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   951: goto -216 -> 735
    //   954: new 61	java/io/File
    //   957: dup
    //   958: aload 7
    //   960: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   963: invokevirtual 155	java/io/File:delete	()Z
    //   966: pop
    //   967: new 61	java/io/File
    //   970: dup
    //   971: aload 6
    //   973: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   976: new 61	java/io/File
    //   979: dup
    //   980: aload_0
    //   981: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   984: invokestatic 144	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   987: new 61	java/io/File
    //   990: dup
    //   991: aload 6
    //   993: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   996: invokevirtual 72	java/io/File:length	()J
    //   999: new 61	java/io/File
    //   1002: dup
    //   1003: aload_0
    //   1004: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1007: invokevirtual 72	java/io/File:length	()J
    //   1010: lcmp
    //   1011: ifeq +105 -> 1116
    //   1014: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   1017: ldc -99
    //   1019: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1022: new 61	java/io/File
    //   1025: dup
    //   1026: aload 6
    //   1028: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1031: invokevirtual 155	java/io/File:delete	()Z
    //   1034: pop
    //   1035: new 61	java/io/File
    //   1038: dup
    //   1039: aload_0
    //   1040: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1043: invokevirtual 155	java/io/File:delete	()Z
    //   1046: pop
    //   1047: new 61	java/io/File
    //   1050: dup
    //   1051: ldc 42
    //   1053: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1056: ldc 87
    //   1058: invokestatic 91	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   1061: pop
    //   1062: iconst_3
    //   1063: anewarray 36	java/lang/String
    //   1066: dup
    //   1067: iconst_0
    //   1068: ldc 38
    //   1070: aastore
    //   1071: dup
    //   1072: iconst_1
    //   1073: ldc -97
    //   1075: aastore
    //   1076: dup
    //   1077: iconst_2
    //   1078: ldc 42
    //   1080: aastore
    //   1081: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1084: ldc 28
    //   1086: ldc -95
    //   1088: invokestatic 34	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1091: pop
    //   1092: return
    //   1093: astore_0
    //   1094: aload_0
    //   1095: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   1098: new 61	java/io/File
    //   1101: dup
    //   1102: ldc 42
    //   1104: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1107: ldc 87
    //   1109: invokestatic 91	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   1112: pop
    //   1113: goto -213 -> 900
    //   1116: new 61	java/io/File
    //   1119: dup
    //   1120: aload 7
    //   1122: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1125: invokevirtual 72	java/io/File:length	()J
    //   1128: new 61	java/io/File
    //   1131: dup
    //   1132: aload_0
    //   1133: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1136: invokevirtual 72	java/io/File:length	()J
    //   1139: lcmp
    //   1140: ifeq +215 -> 1355
    //   1143: iconst_3
    //   1144: anewarray 36	java/lang/String
    //   1147: dup
    //   1148: iconst_0
    //   1149: ldc 38
    //   1151: aastore
    //   1152: dup
    //   1153: iconst_1
    //   1154: ldc -70
    //   1156: aastore
    //   1157: dup
    //   1158: iconst_2
    //   1159: ldc 42
    //   1161: aastore
    //   1162: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1165: new 61	java/io/File
    //   1168: dup
    //   1169: aload 7
    //   1171: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1174: invokevirtual 155	java/io/File:delete	()Z
    //   1177: pop
    //   1178: iconst_3
    //   1179: anewarray 36	java/lang/String
    //   1182: dup
    //   1183: iconst_0
    //   1184: ldc 38
    //   1186: aastore
    //   1187: dup
    //   1188: iconst_1
    //   1189: ldc -70
    //   1191: aastore
    //   1192: dup
    //   1193: iconst_2
    //   1194: aload_0
    //   1195: aastore
    //   1196: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1199: iconst_3
    //   1200: anewarray 36	java/lang/String
    //   1203: dup
    //   1204: iconst_0
    //   1205: ldc 47
    //   1207: aastore
    //   1208: dup
    //   1209: iconst_1
    //   1210: ldc 49
    //   1212: aastore
    //   1213: dup
    //   1214: iconst_2
    //   1215: aload_0
    //   1216: aastore
    //   1217: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1220: iconst_3
    //   1221: anewarray 36	java/lang/String
    //   1224: dup
    //   1225: iconst_0
    //   1226: ldc -85
    //   1228: aastore
    //   1229: dup
    //   1230: iconst_1
    //   1231: ldc -83
    //   1233: aastore
    //   1234: dup
    //   1235: iconst_2
    //   1236: aload_0
    //   1237: aastore
    //   1238: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1241: iconst_3
    //   1242: anewarray 36	java/lang/String
    //   1245: dup
    //   1246: iconst_0
    //   1247: ldc -85
    //   1249: aastore
    //   1250: dup
    //   1251: iconst_1
    //   1252: ldc -81
    //   1254: aastore
    //   1255: dup
    //   1256: iconst_2
    //   1257: aload_0
    //   1258: aastore
    //   1259: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1262: iconst_4
    //   1263: anewarray 36	java/lang/String
    //   1266: dup
    //   1267: iconst_0
    //   1268: ldc -79
    //   1270: aastore
    //   1271: dup
    //   1272: iconst_1
    //   1273: ldc -77
    //   1275: aastore
    //   1276: dup
    //   1277: iconst_2
    //   1278: aload_0
    //   1279: aastore
    //   1280: dup
    //   1281: iconst_3
    //   1282: ldc 42
    //   1284: aastore
    //   1285: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1288: iconst_3
    //   1289: anewarray 36	java/lang/String
    //   1292: dup
    //   1293: iconst_0
    //   1294: ldc 38
    //   1296: aastore
    //   1297: dup
    //   1298: iconst_1
    //   1299: ldc -97
    //   1301: aastore
    //   1302: dup
    //   1303: iconst_2
    //   1304: aload_0
    //   1305: aastore
    //   1306: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1309: new 61	java/io/File
    //   1312: dup
    //   1313: aload 6
    //   1315: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1318: invokevirtual 155	java/io/File:delete	()Z
    //   1321: pop
    //   1322: iconst_3
    //   1323: anewarray 36	java/lang/String
    //   1326: dup
    //   1327: iconst_0
    //   1328: ldc 38
    //   1330: aastore
    //   1331: dup
    //   1332: iconst_1
    //   1333: ldc -97
    //   1335: aastore
    //   1336: dup
    //   1337: iconst_2
    //   1338: ldc 42
    //   1340: aastore
    //   1341: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1344: ldc 28
    //   1346: ldc -95
    //   1348: invokestatic 34	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1351: pop
    //   1352: goto -460 -> 892
    //   1355: iconst_3
    //   1356: anewarray 36	java/lang/String
    //   1359: dup
    //   1360: iconst_0
    //   1361: ldc 38
    //   1363: aastore
    //   1364: dup
    //   1365: iconst_1
    //   1366: ldc -97
    //   1368: aastore
    //   1369: dup
    //   1370: iconst_2
    //   1371: aload_0
    //   1372: aastore
    //   1373: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1376: iconst_3
    //   1377: anewarray 36	java/lang/String
    //   1380: dup
    //   1381: iconst_0
    //   1382: ldc 47
    //   1384: aastore
    //   1385: dup
    //   1386: iconst_1
    //   1387: ldc 49
    //   1389: aastore
    //   1390: dup
    //   1391: iconst_2
    //   1392: aload_0
    //   1393: aastore
    //   1394: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1397: iconst_3
    //   1398: anewarray 36	java/lang/String
    //   1401: dup
    //   1402: iconst_0
    //   1403: ldc -85
    //   1405: aastore
    //   1406: dup
    //   1407: iconst_1
    //   1408: ldc -83
    //   1410: aastore
    //   1411: dup
    //   1412: iconst_2
    //   1413: aload_0
    //   1414: aastore
    //   1415: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1418: iconst_3
    //   1419: anewarray 36	java/lang/String
    //   1422: dup
    //   1423: iconst_0
    //   1424: ldc -85
    //   1426: aastore
    //   1427: dup
    //   1428: iconst_1
    //   1429: ldc -81
    //   1431: aastore
    //   1432: dup
    //   1433: iconst_2
    //   1434: aload_0
    //   1435: aastore
    //   1436: invokestatic 45	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1439: goto -130 -> 1309
    //   1442: astore_0
    //   1443: goto -777 -> 666
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1446	0	paramArrayOfString	String[]
    //   30	355	1	i	int
    //   28	341	2	j	int
    //   104	341	3	k	int
    //   338	3	4	bool	boolean
    //   88	287	5	localObject	Object
    //   18	1296	6	str1	String
    //   13	1157	7	str2	String
    //   264	116	8	localRandomAccessFile	java.io.RandomAccessFile
    //   285	47	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   200	230	665	java/lang/Exception
    //   234	247	665	java/lang/Exception
    //   247	266	665	java/lang/Exception
    //   352	364	665	java/lang/Exception
    //   31	90	722	java/lang/Exception
    //   90	100	722	java/lang/Exception
    //   105	119	722	java/lang/Exception
    //   121	148	722	java/lang/Exception
    //   150	200	722	java/lang/Exception
    //   388	396	722	java/lang/Exception
    //   666	721	722	java/lang/Exception
    //   900	935	722	java/lang/Exception
    //   1094	1113	722	java/lang/Exception
    //   31	90	938	java/lang/OutOfMemoryError
    //   90	100	938	java/lang/OutOfMemoryError
    //   105	119	938	java/lang/OutOfMemoryError
    //   121	148	938	java/lang/OutOfMemoryError
    //   150	200	938	java/lang/OutOfMemoryError
    //   200	230	938	java/lang/OutOfMemoryError
    //   234	247	938	java/lang/OutOfMemoryError
    //   247	266	938	java/lang/OutOfMemoryError
    //   266	278	938	java/lang/OutOfMemoryError
    //   280	287	938	java/lang/OutOfMemoryError
    //   292	302	938	java/lang/OutOfMemoryError
    //   306	331	938	java/lang/OutOfMemoryError
    //   331	340	938	java/lang/OutOfMemoryError
    //   352	364	938	java/lang/OutOfMemoryError
    //   374	384	938	java/lang/OutOfMemoryError
    //   388	396	938	java/lang/OutOfMemoryError
    //   396	444	938	java/lang/OutOfMemoryError
    //   448	664	938	java/lang/OutOfMemoryError
    //   666	721	938	java/lang/OutOfMemoryError
    //   739	892	938	java/lang/OutOfMemoryError
    //   892	900	938	java/lang/OutOfMemoryError
    //   900	935	938	java/lang/OutOfMemoryError
    //   954	1092	938	java/lang/OutOfMemoryError
    //   1094	1113	938	java/lang/OutOfMemoryError
    //   1116	1309	938	java/lang/OutOfMemoryError
    //   1309	1352	938	java/lang/OutOfMemoryError
    //   1355	1439	938	java/lang/OutOfMemoryError
    //   396	444	1093	java/lang/Exception
    //   448	664	1093	java/lang/Exception
    //   739	892	1093	java/lang/Exception
    //   892	900	1093	java/lang/Exception
    //   954	1092	1093	java/lang/Exception
    //   1116	1309	1093	java/lang/Exception
    //   1309	1352	1093	java/lang/Exception
    //   1355	1439	1093	java/lang/Exception
    //   266	278	1442	java/lang/Exception
    //   280	287	1442	java/lang/Exception
    //   292	302	1442	java/lang/Exception
    //   306	331	1442	java/lang/Exception
    //   331	340	1442	java/lang/Exception
    //   374	384	1442	java/lang/Exception
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/AdsBlockOFF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */