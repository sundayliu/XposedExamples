package com.chelpus.root.utils;

public class AdsBlockON
{
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 6	com/chelpus/root/utils/AdsBlockON$1
    //   3: dup
    //   4: invokespecial 18	com/chelpus/root/utils/AdsBlockON$1:<init>	()V
    //   7: invokestatic 24	com/chelpus/Utils:startRootJava	(Ljava/lang/Object;)V
    //   10: aload_0
    //   11: iconst_0
    //   12: aaload
    //   13: astore 7
    //   15: aload_0
    //   16: iconst_1
    //   17: aaload
    //   18: astore 5
    //   20: aload_0
    //   21: iconst_2
    //   22: aaload
    //   23: astore 6
    //   25: aload_0
    //   26: iconst_3
    //   27: aaload
    //   28: astore_0
    //   29: ldc 26
    //   31: astore_0
    //   32: iconst_0
    //   33: istore_1
    //   34: aload 7
    //   36: invokestatic 30	com/chelpus/Utils:getSimulink	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 4
    //   41: aload 4
    //   43: ldc 32
    //   45: invokevirtual 38	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifne +6 -> 54
    //   51: aload 4
    //   53: astore_0
    //   54: ldc 40
    //   56: ldc 42
    //   58: invokestatic 46	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   61: pop
    //   62: iconst_3
    //   63: anewarray 34	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: ldc 48
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: ldc 50
    //   75: aastore
    //   76: dup
    //   77: iconst_2
    //   78: ldc 52
    //   80: aastore
    //   81: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   84: iconst_3
    //   85: anewarray 34	java/lang/String
    //   88: dup
    //   89: iconst_0
    //   90: ldc 57
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: ldc 59
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: ldc 52
    //   102: aastore
    //   103: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   106: iload_1
    //   107: istore_2
    //   108: new 61	java/io/File
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: invokevirtual 68	java/io/File:exists	()Z
    //   119: ifeq +86 -> 205
    //   122: iload_1
    //   123: istore_2
    //   124: new 61	java/io/File
    //   127: dup
    //   128: aload_0
    //   129: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: invokevirtual 72	java/io/File:length	()J
    //   135: new 61	java/io/File
    //   138: dup
    //   139: aload 7
    //   141: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: invokevirtual 72	java/io/File:length	()J
    //   147: lcmp
    //   148: ifne +57 -> 205
    //   151: iconst_1
    //   152: istore_2
    //   153: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   156: ldc 80
    //   158: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   161: iconst_3
    //   162: anewarray 34	java/lang/String
    //   165: dup
    //   166: iconst_0
    //   167: ldc 48
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: ldc 50
    //   174: aastore
    //   175: dup
    //   176: iconst_2
    //   177: ldc 26
    //   179: aastore
    //   180: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   183: iconst_3
    //   184: anewarray 34	java/lang/String
    //   187: dup
    //   188: iconst_0
    //   189: ldc 57
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: ldc 59
    //   196: aastore
    //   197: dup
    //   198: iconst_2
    //   199: ldc 26
    //   201: aastore
    //   202: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   205: new 61	java/io/File
    //   208: dup
    //   209: aload 7
    //   211: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   214: invokevirtual 68	java/io/File:exists	()Z
    //   217: ifne +18 -> 235
    //   220: new 61	java/io/File
    //   223: dup
    //   224: ldc 52
    //   226: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   229: ldc 87
    //   231: invokestatic 91	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   234: pop
    //   235: iload_2
    //   236: ifne +117 -> 353
    //   239: new 93	java/io/RandomAccessFile
    //   242: dup
    //   243: aload 7
    //   245: ldc 95
    //   247: invokespecial 98	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: astore 4
    //   252: aload 4
    //   254: lconst_0
    //   255: invokevirtual 102	java/io/RandomAccessFile:seek	(J)V
    //   258: new 93	java/io/RandomAccessFile
    //   261: dup
    //   262: aload 5
    //   264: ldc 42
    //   266: invokespecial 98	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: astore 8
    //   271: aload 8
    //   273: lconst_0
    //   274: invokevirtual 105	java/io/RandomAccessFile:setLength	(J)V
    //   277: aload 8
    //   279: lconst_0
    //   280: invokevirtual 102	java/io/RandomAccessFile:seek	(J)V
    //   283: iconst_1
    //   284: istore_1
    //   285: aload 4
    //   287: invokevirtual 109	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   290: astore 9
    //   292: aload 9
    //   294: ifnull +79 -> 373
    //   297: aload 9
    //   299: ldc 111
    //   301: invokevirtual 115	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   304: ifne +64 -> 368
    //   307: iload_1
    //   308: ifeq +60 -> 368
    //   311: aload 8
    //   313: new 117	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   320: aload 9
    //   322: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc 124
    //   327: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokevirtual 130	java/io/RandomAccessFile:writeBytes	(Ljava/lang/String;)V
    //   336: aload 9
    //   338: ldc -124
    //   340: invokevirtual 115	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   343: istore_3
    //   344: iload_3
    //   345: ifeq -60 -> 285
    //   348: iconst_1
    //   349: istore_1
    //   350: goto -65 -> 285
    //   353: new 93	java/io/RandomAccessFile
    //   356: dup
    //   357: aload_0
    //   358: ldc 95
    //   360: invokespecial 98	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: astore 4
    //   365: goto -113 -> 252
    //   368: iconst_0
    //   369: istore_1
    //   370: goto -34 -> 336
    //   373: aload 4
    //   375: invokevirtual 135	java/io/RandomAccessFile:close	()V
    //   378: aload 8
    //   380: invokevirtual 135	java/io/RandomAccessFile:close	()V
    //   383: new 61	java/io/File
    //   386: dup
    //   387: aload 5
    //   389: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   392: new 61	java/io/File
    //   395: dup
    //   396: aload 6
    //   398: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   401: invokestatic 139	com/chelpus/Utils:save_text_to_end_file_from_file	(Ljava/io/File;Ljava/io/File;)Z
    //   404: istore_3
    //   405: iload_3
    //   406: ifeq +1122 -> 1528
    //   409: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   412: ldc 40
    //   414: ldc 42
    //   416: invokestatic 46	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   419: invokevirtual 142	java/io/PrintStream:println	(Z)V
    //   422: iconst_3
    //   423: anewarray 34	java/lang/String
    //   426: dup
    //   427: iconst_0
    //   428: ldc 48
    //   430: aastore
    //   431: dup
    //   432: iconst_1
    //   433: ldc 50
    //   435: aastore
    //   436: dup
    //   437: iconst_2
    //   438: ldc 52
    //   440: aastore
    //   441: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   444: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   447: ldc 40
    //   449: ldc 42
    //   451: invokestatic 46	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   454: invokevirtual 142	java/io/PrintStream:println	(Z)V
    //   457: iload_2
    //   458: ifne +516 -> 974
    //   461: new 61	java/io/File
    //   464: dup
    //   465: aload 5
    //   467: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   470: new 61	java/io/File
    //   473: dup
    //   474: ldc 52
    //   476: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   479: invokestatic 146	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   482: new 61	java/io/File
    //   485: dup
    //   486: aload 5
    //   488: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   491: invokevirtual 72	java/io/File:length	()J
    //   494: new 61	java/io/File
    //   497: dup
    //   498: ldc 52
    //   500: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   503: invokevirtual 72	java/io/File:length	()J
    //   506: lcmp
    //   507: ifeq +405 -> 912
    //   510: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   513: aload 5
    //   515: invokevirtual 149	java/lang/String:length	()I
    //   518: invokevirtual 152	java/io/PrintStream:println	(I)V
    //   521: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   524: new 61	java/io/File
    //   527: dup
    //   528: ldc 52
    //   530: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   533: invokevirtual 72	java/io/File:length	()J
    //   536: invokevirtual 154	java/io/PrintStream:println	(J)V
    //   539: new 61	java/io/File
    //   542: dup
    //   543: aload 7
    //   545: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   548: invokevirtual 157	java/io/File:delete	()Z
    //   551: pop
    //   552: new 61	java/io/File
    //   555: dup
    //   556: aload 5
    //   558: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   561: new 61	java/io/File
    //   564: dup
    //   565: ldc 26
    //   567: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   570: invokestatic 146	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   573: new 61	java/io/File
    //   576: dup
    //   577: aload 5
    //   579: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   582: invokevirtual 72	java/io/File:length	()J
    //   585: new 61	java/io/File
    //   588: dup
    //   589: ldc 26
    //   591: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   594: invokevirtual 72	java/io/File:length	()J
    //   597: lcmp
    //   598: ifeq +156 -> 754
    //   601: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   604: ldc -97
    //   606: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   609: new 61	java/io/File
    //   612: dup
    //   613: aload 5
    //   615: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   618: invokevirtual 157	java/io/File:delete	()Z
    //   621: pop
    //   622: new 61	java/io/File
    //   625: dup
    //   626: aload_0
    //   627: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   630: invokevirtual 157	java/io/File:delete	()Z
    //   633: pop
    //   634: new 61	java/io/File
    //   637: dup
    //   638: ldc 52
    //   640: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   643: ldc 87
    //   645: invokestatic 91	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   648: pop
    //   649: iconst_3
    //   650: anewarray 34	java/lang/String
    //   653: dup
    //   654: iconst_0
    //   655: ldc 48
    //   657: aastore
    //   658: dup
    //   659: iconst_1
    //   660: ldc -95
    //   662: aastore
    //   663: dup
    //   664: iconst_2
    //   665: ldc 52
    //   667: aastore
    //   668: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   671: ldc 40
    //   673: ldc -93
    //   675: invokestatic 46	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   678: pop
    //   679: return
    //   680: astore_0
    //   681: aload_0
    //   682: invokevirtual 166	java/lang/Exception:printStackTrace	()V
    //   685: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   688: ldc -97
    //   690: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   693: new 61	java/io/File
    //   696: dup
    //   697: aload 5
    //   699: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   702: invokevirtual 157	java/io/File:delete	()Z
    //   705: pop
    //   706: iconst_3
    //   707: anewarray 34	java/lang/String
    //   710: dup
    //   711: iconst_0
    //   712: ldc 48
    //   714: aastore
    //   715: dup
    //   716: iconst_1
    //   717: ldc -95
    //   719: aastore
    //   720: dup
    //   721: iconst_2
    //   722: ldc 52
    //   724: aastore
    //   725: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   728: ldc 40
    //   730: ldc -93
    //   732: invokestatic 46	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   735: pop
    //   736: return
    //   737: astore_0
    //   738: aload_0
    //   739: invokevirtual 166	java/lang/Exception:printStackTrace	()V
    //   742: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   745: ldc -88
    //   747: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   750: invokestatic 171	com/chelpus/Utils:exitFromRootJava	()V
    //   753: return
    //   754: iconst_3
    //   755: anewarray 34	java/lang/String
    //   758: dup
    //   759: iconst_0
    //   760: ldc 48
    //   762: aastore
    //   763: dup
    //   764: iconst_1
    //   765: ldc -95
    //   767: aastore
    //   768: dup
    //   769: iconst_2
    //   770: ldc 26
    //   772: aastore
    //   773: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   776: iconst_3
    //   777: anewarray 34	java/lang/String
    //   780: dup
    //   781: iconst_0
    //   782: ldc 57
    //   784: aastore
    //   785: dup
    //   786: iconst_1
    //   787: ldc 59
    //   789: aastore
    //   790: dup
    //   791: iconst_2
    //   792: ldc 26
    //   794: aastore
    //   795: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   798: iconst_3
    //   799: anewarray 34	java/lang/String
    //   802: dup
    //   803: iconst_0
    //   804: ldc -83
    //   806: aastore
    //   807: dup
    //   808: iconst_1
    //   809: ldc -81
    //   811: aastore
    //   812: dup
    //   813: iconst_2
    //   814: ldc 26
    //   816: aastore
    //   817: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   820: iconst_3
    //   821: anewarray 34	java/lang/String
    //   824: dup
    //   825: iconst_0
    //   826: ldc -83
    //   828: aastore
    //   829: dup
    //   830: iconst_1
    //   831: ldc -79
    //   833: aastore
    //   834: dup
    //   835: iconst_2
    //   836: ldc 26
    //   838: aastore
    //   839: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   842: iconst_4
    //   843: anewarray 34	java/lang/String
    //   846: dup
    //   847: iconst_0
    //   848: ldc -77
    //   850: aastore
    //   851: dup
    //   852: iconst_1
    //   853: ldc -75
    //   855: aastore
    //   856: dup
    //   857: iconst_2
    //   858: ldc 26
    //   860: aastore
    //   861: dup
    //   862: iconst_3
    //   863: ldc 52
    //   865: aastore
    //   866: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   869: new 61	java/io/File
    //   872: dup
    //   873: aload 5
    //   875: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   878: invokevirtual 157	java/io/File:delete	()Z
    //   881: pop
    //   882: iconst_3
    //   883: anewarray 34	java/lang/String
    //   886: dup
    //   887: iconst_0
    //   888: ldc 48
    //   890: aastore
    //   891: dup
    //   892: iconst_1
    //   893: ldc -95
    //   895: aastore
    //   896: dup
    //   897: iconst_2
    //   898: ldc 52
    //   900: aastore
    //   901: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   904: ldc 40
    //   906: ldc -93
    //   908: invokestatic 46	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   911: pop
    //   912: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   915: ldc -73
    //   917: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   920: new 61	java/io/File
    //   923: dup
    //   924: aload 5
    //   926: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   929: invokevirtual 157	java/io/File:delete	()Z
    //   932: pop
    //   933: iconst_3
    //   934: anewarray 34	java/lang/String
    //   937: dup
    //   938: iconst_0
    //   939: ldc 48
    //   941: aastore
    //   942: dup
    //   943: iconst_1
    //   944: ldc -95
    //   946: aastore
    //   947: dup
    //   948: iconst_2
    //   949: ldc 52
    //   951: aastore
    //   952: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   955: goto -205 -> 750
    //   958: astore_0
    //   959: aload_0
    //   960: invokevirtual 184	java/lang/OutOfMemoryError:printStackTrace	()V
    //   963: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   966: ldc -70
    //   968: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   971: goto -221 -> 750
    //   974: new 61	java/io/File
    //   977: dup
    //   978: aload 7
    //   980: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   983: invokevirtual 157	java/io/File:delete	()Z
    //   986: pop
    //   987: new 61	java/io/File
    //   990: dup
    //   991: aload 5
    //   993: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   996: new 61	java/io/File
    //   999: dup
    //   1000: ldc 26
    //   1002: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1005: invokestatic 146	com/chelpus/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   1008: new 61	java/io/File
    //   1011: dup
    //   1012: aload 5
    //   1014: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1017: invokevirtual 72	java/io/File:length	()J
    //   1020: new 61	java/io/File
    //   1023: dup
    //   1024: ldc 26
    //   1026: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1029: invokevirtual 72	java/io/File:length	()J
    //   1032: lcmp
    //   1033: ifeq +159 -> 1192
    //   1036: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   1039: ldc -97
    //   1041: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1044: new 61	java/io/File
    //   1047: dup
    //   1048: aload 5
    //   1050: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1053: invokevirtual 157	java/io/File:delete	()Z
    //   1056: pop
    //   1057: new 61	java/io/File
    //   1060: dup
    //   1061: aload_0
    //   1062: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1065: invokevirtual 157	java/io/File:delete	()Z
    //   1068: pop
    //   1069: new 61	java/io/File
    //   1072: dup
    //   1073: ldc 52
    //   1075: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1078: ldc 87
    //   1080: invokestatic 91	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   1083: pop
    //   1084: iconst_3
    //   1085: anewarray 34	java/lang/String
    //   1088: dup
    //   1089: iconst_0
    //   1090: ldc 48
    //   1092: aastore
    //   1093: dup
    //   1094: iconst_1
    //   1095: ldc -95
    //   1097: aastore
    //   1098: dup
    //   1099: iconst_2
    //   1100: ldc 52
    //   1102: aastore
    //   1103: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1106: ldc 40
    //   1108: ldc -93
    //   1110: invokestatic 46	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1113: pop
    //   1114: return
    //   1115: astore_0
    //   1116: aload_0
    //   1117: invokevirtual 166	java/lang/Exception:printStackTrace	()V
    //   1120: new 61	java/io/File
    //   1123: dup
    //   1124: ldc 52
    //   1126: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1129: ldc 87
    //   1131: invokestatic 91	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   1134: pop
    //   1135: iconst_3
    //   1136: anewarray 34	java/lang/String
    //   1139: dup
    //   1140: iconst_0
    //   1141: ldc 48
    //   1143: aastore
    //   1144: dup
    //   1145: iconst_1
    //   1146: ldc 50
    //   1148: aastore
    //   1149: dup
    //   1150: iconst_2
    //   1151: ldc 52
    //   1153: aastore
    //   1154: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1157: new 61	java/io/File
    //   1160: dup
    //   1161: ldc 52
    //   1163: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1166: new 61	java/io/File
    //   1169: dup
    //   1170: aload 6
    //   1172: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1175: invokestatic 139	com/chelpus/Utils:save_text_to_end_file_from_file	(Ljava/io/File;Ljava/io/File;)Z
    //   1178: ifne -258 -> 920
    //   1181: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   1184: ldc -70
    //   1186: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1189: goto -269 -> 920
    //   1192: new 61	java/io/File
    //   1195: dup
    //   1196: aload 7
    //   1198: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1201: invokevirtual 72	java/io/File:length	()J
    //   1204: new 61	java/io/File
    //   1207: dup
    //   1208: aload_0
    //   1209: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1212: invokevirtual 72	java/io/File:length	()J
    //   1215: lcmp
    //   1216: ifeq +221 -> 1437
    //   1219: iconst_3
    //   1220: anewarray 34	java/lang/String
    //   1223: dup
    //   1224: iconst_0
    //   1225: ldc 48
    //   1227: aastore
    //   1228: dup
    //   1229: iconst_1
    //   1230: ldc -68
    //   1232: aastore
    //   1233: dup
    //   1234: iconst_2
    //   1235: ldc 52
    //   1237: aastore
    //   1238: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1241: new 61	java/io/File
    //   1244: dup
    //   1245: aload 7
    //   1247: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1250: invokevirtual 157	java/io/File:delete	()Z
    //   1253: pop
    //   1254: iconst_3
    //   1255: anewarray 34	java/lang/String
    //   1258: dup
    //   1259: iconst_0
    //   1260: ldc 48
    //   1262: aastore
    //   1263: dup
    //   1264: iconst_1
    //   1265: ldc -68
    //   1267: aastore
    //   1268: dup
    //   1269: iconst_2
    //   1270: ldc 26
    //   1272: aastore
    //   1273: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1276: iconst_3
    //   1277: anewarray 34	java/lang/String
    //   1280: dup
    //   1281: iconst_0
    //   1282: ldc 57
    //   1284: aastore
    //   1285: dup
    //   1286: iconst_1
    //   1287: ldc 59
    //   1289: aastore
    //   1290: dup
    //   1291: iconst_2
    //   1292: ldc 26
    //   1294: aastore
    //   1295: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1298: iconst_3
    //   1299: anewarray 34	java/lang/String
    //   1302: dup
    //   1303: iconst_0
    //   1304: ldc -83
    //   1306: aastore
    //   1307: dup
    //   1308: iconst_1
    //   1309: ldc -81
    //   1311: aastore
    //   1312: dup
    //   1313: iconst_2
    //   1314: ldc 26
    //   1316: aastore
    //   1317: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1320: iconst_3
    //   1321: anewarray 34	java/lang/String
    //   1324: dup
    //   1325: iconst_0
    //   1326: ldc -83
    //   1328: aastore
    //   1329: dup
    //   1330: iconst_1
    //   1331: ldc -79
    //   1333: aastore
    //   1334: dup
    //   1335: iconst_2
    //   1336: ldc 26
    //   1338: aastore
    //   1339: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1342: iconst_4
    //   1343: anewarray 34	java/lang/String
    //   1346: dup
    //   1347: iconst_0
    //   1348: ldc -77
    //   1350: aastore
    //   1351: dup
    //   1352: iconst_1
    //   1353: ldc -75
    //   1355: aastore
    //   1356: dup
    //   1357: iconst_2
    //   1358: ldc 26
    //   1360: aastore
    //   1361: dup
    //   1362: iconst_3
    //   1363: ldc 52
    //   1365: aastore
    //   1366: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1369: iconst_3
    //   1370: anewarray 34	java/lang/String
    //   1373: dup
    //   1374: iconst_0
    //   1375: ldc 48
    //   1377: aastore
    //   1378: dup
    //   1379: iconst_1
    //   1380: ldc -95
    //   1382: aastore
    //   1383: dup
    //   1384: iconst_2
    //   1385: ldc 26
    //   1387: aastore
    //   1388: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1391: new 61	java/io/File
    //   1394: dup
    //   1395: aload 5
    //   1397: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   1400: invokevirtual 157	java/io/File:delete	()Z
    //   1403: pop
    //   1404: iconst_3
    //   1405: anewarray 34	java/lang/String
    //   1408: dup
    //   1409: iconst_0
    //   1410: ldc 48
    //   1412: aastore
    //   1413: dup
    //   1414: iconst_1
    //   1415: ldc -95
    //   1417: aastore
    //   1418: dup
    //   1419: iconst_2
    //   1420: ldc 52
    //   1422: aastore
    //   1423: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1426: ldc 40
    //   1428: ldc -93
    //   1430: invokestatic 46	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1433: pop
    //   1434: goto -522 -> 912
    //   1437: iconst_3
    //   1438: anewarray 34	java/lang/String
    //   1441: dup
    //   1442: iconst_0
    //   1443: ldc 48
    //   1445: aastore
    //   1446: dup
    //   1447: iconst_1
    //   1448: ldc -95
    //   1450: aastore
    //   1451: dup
    //   1452: iconst_2
    //   1453: ldc 26
    //   1455: aastore
    //   1456: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1459: iconst_3
    //   1460: anewarray 34	java/lang/String
    //   1463: dup
    //   1464: iconst_0
    //   1465: ldc 57
    //   1467: aastore
    //   1468: dup
    //   1469: iconst_1
    //   1470: ldc 59
    //   1472: aastore
    //   1473: dup
    //   1474: iconst_2
    //   1475: ldc 26
    //   1477: aastore
    //   1478: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1481: iconst_3
    //   1482: anewarray 34	java/lang/String
    //   1485: dup
    //   1486: iconst_0
    //   1487: ldc -83
    //   1489: aastore
    //   1490: dup
    //   1491: iconst_1
    //   1492: ldc -81
    //   1494: aastore
    //   1495: dup
    //   1496: iconst_2
    //   1497: ldc 26
    //   1499: aastore
    //   1500: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1503: iconst_3
    //   1504: anewarray 34	java/lang/String
    //   1507: dup
    //   1508: iconst_0
    //   1509: ldc -83
    //   1511: aastore
    //   1512: dup
    //   1513: iconst_1
    //   1514: ldc -79
    //   1516: aastore
    //   1517: dup
    //   1518: iconst_2
    //   1519: ldc 26
    //   1521: aastore
    //   1522: invokestatic 55	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1525: goto -134 -> 1391
    //   1528: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   1531: ldc -97
    //   1533: invokevirtual 85	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1536: goto -616 -> 920
    //   1539: astore_0
    //   1540: goto -859 -> 681
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1543	0	paramArrayOfString	String[]
    //   33	337	1	i	int
    //   107	351	2	j	int
    //   343	63	3	bool	boolean
    //   39	335	4	localObject	Object
    //   18	1378	5	str1	String
    //   23	1148	6	str2	String
    //   13	1233	7	str3	String
    //   269	110	8	localRandomAccessFile	java.io.RandomAccessFile
    //   290	47	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   205	235	680	java/lang/Exception
    //   239	252	680	java/lang/Exception
    //   252	271	680	java/lang/Exception
    //   353	365	680	java/lang/Exception
    //   54	106	737	java/lang/Exception
    //   108	122	737	java/lang/Exception
    //   124	151	737	java/lang/Exception
    //   153	205	737	java/lang/Exception
    //   383	405	737	java/lang/Exception
    //   681	736	737	java/lang/Exception
    //   920	955	737	java/lang/Exception
    //   1116	1189	737	java/lang/Exception
    //   1528	1536	737	java/lang/Exception
    //   54	106	958	java/lang/OutOfMemoryError
    //   108	122	958	java/lang/OutOfMemoryError
    //   124	151	958	java/lang/OutOfMemoryError
    //   153	205	958	java/lang/OutOfMemoryError
    //   205	235	958	java/lang/OutOfMemoryError
    //   239	252	958	java/lang/OutOfMemoryError
    //   252	271	958	java/lang/OutOfMemoryError
    //   271	283	958	java/lang/OutOfMemoryError
    //   285	292	958	java/lang/OutOfMemoryError
    //   297	307	958	java/lang/OutOfMemoryError
    //   311	336	958	java/lang/OutOfMemoryError
    //   336	344	958	java/lang/OutOfMemoryError
    //   353	365	958	java/lang/OutOfMemoryError
    //   373	383	958	java/lang/OutOfMemoryError
    //   383	405	958	java/lang/OutOfMemoryError
    //   409	457	958	java/lang/OutOfMemoryError
    //   461	679	958	java/lang/OutOfMemoryError
    //   681	736	958	java/lang/OutOfMemoryError
    //   754	912	958	java/lang/OutOfMemoryError
    //   912	920	958	java/lang/OutOfMemoryError
    //   920	955	958	java/lang/OutOfMemoryError
    //   974	1114	958	java/lang/OutOfMemoryError
    //   1116	1189	958	java/lang/OutOfMemoryError
    //   1192	1391	958	java/lang/OutOfMemoryError
    //   1391	1434	958	java/lang/OutOfMemoryError
    //   1437	1525	958	java/lang/OutOfMemoryError
    //   1528	1536	958	java/lang/OutOfMemoryError
    //   409	457	1115	java/lang/Exception
    //   461	679	1115	java/lang/Exception
    //   754	912	1115	java/lang/Exception
    //   912	920	1115	java/lang/Exception
    //   974	1114	1115	java/lang/Exception
    //   1192	1391	1115	java/lang/Exception
    //   1391	1434	1115	java/lang/Exception
    //   1437	1525	1115	java/lang/Exception
    //   271	283	1539	java/lang/Exception
    //   285	292	1539	java/lang/Exception
    //   297	307	1539	java/lang/Exception
    //   311	336	1539	java/lang/Exception
    //   336	344	1539	java/lang/Exception
    //   373	383	1539	java/lang/Exception
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/AdsBlockON.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */