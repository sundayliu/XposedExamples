package com.chelpus.root.utils;

public class ClearODEXfiles
{
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: aaload
    //   3: astore_0
    //   4: new 6	com/chelpus/root/utils/ClearODEXfiles$1
    //   7: dup
    //   8: invokespecial 16	com/chelpus/root/utils/ClearODEXfiles$1:<init>	()V
    //   11: invokestatic 22	com/chelpus/Utils:startRootJava	(Ljava/lang/Object;)V
    //   14: new 24	java/io/File
    //   17: dup
    //   18: ldc 26
    //   20: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 33	java/io/File:exists	()Z
    //   26: ifeq +191 -> 217
    //   29: new 24	java/io/File
    //   32: dup
    //   33: ldc 26
    //   35: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 37	java/io/File:listFiles	()[Ljava/io/File;
    //   41: astore_0
    //   42: aload_0
    //   43: arraylength
    //   44: istore_3
    //   45: iconst_0
    //   46: istore_1
    //   47: iload_1
    //   48: iload_3
    //   49: if_icmpge +168 -> 217
    //   52: aload_0
    //   53: iload_1
    //   54: aaload
    //   55: astore 5
    //   57: getstatic 43	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:api	I
    //   60: bipush 21
    //   62: if_icmplt +128 -> 190
    //   65: aload 5
    //   67: invokevirtual 46	java/io/File:isDirectory	()Z
    //   70: ifeq +139 -> 209
    //   73: aload 5
    //   75: invokevirtual 37	java/io/File:listFiles	()[Ljava/io/File;
    //   78: astore 5
    //   80: aload 5
    //   82: ifnull +127 -> 209
    //   85: aload 5
    //   87: arraylength
    //   88: ifle +121 -> 209
    //   91: aload 5
    //   93: arraylength
    //   94: istore 4
    //   96: iconst_0
    //   97: istore_2
    //   98: iload_2
    //   99: iload 4
    //   101: if_icmpge +108 -> 209
    //   104: aload 5
    //   106: iload_2
    //   107: aaload
    //   108: astore 6
    //   110: aload 6
    //   112: invokevirtual 49	java/io/File:isFile	()Z
    //   115: ifeq +706 -> 821
    //   118: aload 6
    //   120: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: ldc 55
    //   125: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   128: ifeq +693 -> 821
    //   131: new 24	java/io/File
    //   134: dup
    //   135: aload 6
    //   137: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   140: iconst_1
    //   141: invokestatic 65	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   144: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   147: astore 7
    //   149: aload 7
    //   151: invokevirtual 33	java/io/File:exists	()Z
    //   154: ifeq +667 -> 821
    //   157: aload 6
    //   159: invokevirtual 69	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   162: invokevirtual 72	java/io/File:toString	()Ljava/lang/String;
    //   165: ldc 55
    //   167: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   170: ifeq +651 -> 821
    //   173: aload 6
    //   175: invokestatic 76	com/chelpus/Utils:classes_test	(Ljava/io/File;)Z
    //   178: ifeq +643 -> 821
    //   181: aload 7
    //   183: invokevirtual 79	java/io/File:delete	()Z
    //   186: pop
    //   187: goto +634 -> 821
    //   190: aload 5
    //   192: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   195: ldc 81
    //   197: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   200: ifeq +9 -> 209
    //   203: aload 5
    //   205: invokevirtual 79	java/io/File:delete	()Z
    //   208: pop
    //   209: iload_1
    //   210: iconst_1
    //   211: iadd
    //   212: istore_1
    //   213: goto -166 -> 47
    //   216: astore_0
    //   217: getstatic 87	java/lang/System:out	Ljava/io/PrintStream;
    //   220: ldc 89
    //   222: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   225: ldc 96
    //   227: ldc 98
    //   229: invokestatic 102	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   232: pop
    //   233: new 24	java/io/File
    //   236: dup
    //   237: ldc 104
    //   239: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: invokevirtual 37	java/io/File:listFiles	()[Ljava/io/File;
    //   245: astore_0
    //   246: aload_0
    //   247: arraylength
    //   248: istore_3
    //   249: iconst_0
    //   250: istore_1
    //   251: iload_1
    //   252: iload_3
    //   253: if_icmpge +211 -> 464
    //   256: aload_0
    //   257: iload_1
    //   258: aaload
    //   259: astore 5
    //   261: getstatic 43	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:api	I
    //   264: bipush 21
    //   266: if_icmplt +128 -> 394
    //   269: aload 5
    //   271: invokevirtual 46	java/io/File:isDirectory	()Z
    //   274: ifeq +561 -> 835
    //   277: aload 5
    //   279: invokevirtual 37	java/io/File:listFiles	()[Ljava/io/File;
    //   282: astore 5
    //   284: aload 5
    //   286: ifnull +549 -> 835
    //   289: aload 5
    //   291: arraylength
    //   292: ifle +543 -> 835
    //   295: aload 5
    //   297: arraylength
    //   298: istore 4
    //   300: iconst_0
    //   301: istore_2
    //   302: iload_2
    //   303: iload 4
    //   305: if_icmpge +530 -> 835
    //   308: aload 5
    //   310: iload_2
    //   311: aaload
    //   312: astore 6
    //   314: aload 6
    //   316: invokevirtual 49	java/io/File:isFile	()Z
    //   319: ifeq +509 -> 828
    //   322: aload 6
    //   324: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   327: ldc 55
    //   329: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   332: ifeq +496 -> 828
    //   335: new 24	java/io/File
    //   338: dup
    //   339: aload 6
    //   341: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   344: iconst_1
    //   345: invokestatic 65	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   348: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   351: astore 7
    //   353: aload 7
    //   355: invokevirtual 33	java/io/File:exists	()Z
    //   358: ifeq +470 -> 828
    //   361: aload 6
    //   363: invokevirtual 69	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   366: invokevirtual 72	java/io/File:toString	()Ljava/lang/String;
    //   369: ldc 55
    //   371: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   374: ifeq +454 -> 828
    //   377: aload 6
    //   379: invokestatic 76	com/chelpus/Utils:classes_test	(Ljava/io/File;)Z
    //   382: ifeq +446 -> 828
    //   385: aload 7
    //   387: invokevirtual 79	java/io/File:delete	()Z
    //   390: pop
    //   391: goto +437 -> 828
    //   394: new 24	java/io/File
    //   397: dup
    //   398: aload 5
    //   400: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   403: iconst_1
    //   404: invokestatic 65	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   407: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   410: astore 6
    //   412: getstatic 87	java/lang/System:out	Ljava/io/PrintStream;
    //   415: aload 6
    //   417: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   420: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   423: aload 6
    //   425: invokevirtual 33	java/io/File:exists	()Z
    //   428: ifeq +407 -> 835
    //   431: aload 5
    //   433: invokevirtual 69	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   436: invokevirtual 72	java/io/File:toString	()Ljava/lang/String;
    //   439: ldc 55
    //   441: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   444: ifeq +391 -> 835
    //   447: aload 5
    //   449: invokestatic 76	com/chelpus/Utils:classes_test	(Ljava/io/File;)Z
    //   452: ifeq +383 -> 835
    //   455: aload 6
    //   457: invokevirtual 79	java/io/File:delete	()Z
    //   460: pop
    //   461: goto +374 -> 835
    //   464: new 24	java/io/File
    //   467: dup
    //   468: ldc 106
    //   470: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   473: invokevirtual 37	java/io/File:listFiles	()[Ljava/io/File;
    //   476: astore_0
    //   477: aload_0
    //   478: arraylength
    //   479: istore_3
    //   480: iconst_0
    //   481: istore_1
    //   482: iload_1
    //   483: iload_3
    //   484: if_icmpge +211 -> 695
    //   487: aload_0
    //   488: iload_1
    //   489: aaload
    //   490: astore 5
    //   492: getstatic 43	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:api	I
    //   495: bipush 21
    //   497: if_icmplt +128 -> 625
    //   500: aload 5
    //   502: invokevirtual 46	java/io/File:isDirectory	()Z
    //   505: ifeq +344 -> 849
    //   508: aload 5
    //   510: invokevirtual 37	java/io/File:listFiles	()[Ljava/io/File;
    //   513: astore 5
    //   515: aload 5
    //   517: ifnull +332 -> 849
    //   520: aload 5
    //   522: arraylength
    //   523: ifle +326 -> 849
    //   526: aload 5
    //   528: arraylength
    //   529: istore 4
    //   531: iconst_0
    //   532: istore_2
    //   533: iload_2
    //   534: iload 4
    //   536: if_icmpge +313 -> 849
    //   539: aload 5
    //   541: iload_2
    //   542: aaload
    //   543: astore 6
    //   545: aload 6
    //   547: invokevirtual 49	java/io/File:isFile	()Z
    //   550: ifeq +292 -> 842
    //   553: aload 6
    //   555: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   558: ldc 55
    //   560: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   563: ifeq +279 -> 842
    //   566: new 24	java/io/File
    //   569: dup
    //   570: aload 6
    //   572: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   575: iconst_1
    //   576: invokestatic 65	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   579: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   582: astore 7
    //   584: aload 7
    //   586: invokevirtual 33	java/io/File:exists	()Z
    //   589: ifeq +253 -> 842
    //   592: aload 6
    //   594: invokevirtual 69	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   597: invokevirtual 72	java/io/File:toString	()Ljava/lang/String;
    //   600: ldc 55
    //   602: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   605: ifeq +237 -> 842
    //   608: aload 6
    //   610: invokestatic 76	com/chelpus/Utils:classes_test	(Ljava/io/File;)Z
    //   613: ifeq +229 -> 842
    //   616: aload 7
    //   618: invokevirtual 79	java/io/File:delete	()Z
    //   621: pop
    //   622: goto +220 -> 842
    //   625: new 24	java/io/File
    //   628: dup
    //   629: aload 5
    //   631: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   634: iconst_1
    //   635: invokestatic 65	com/chelpus/Utils:getPlaceForOdex	(Ljava/lang/String;Z)Ljava/lang/String;
    //   638: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   641: astore 6
    //   643: getstatic 87	java/lang/System:out	Ljava/io/PrintStream;
    //   646: aload 6
    //   648: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   651: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   654: aload 6
    //   656: invokevirtual 33	java/io/File:exists	()Z
    //   659: ifeq +190 -> 849
    //   662: aload 5
    //   664: invokevirtual 69	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   667: invokevirtual 72	java/io/File:toString	()Ljava/lang/String;
    //   670: ldc 55
    //   672: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   675: ifeq +174 -> 849
    //   678: aload 5
    //   680: invokestatic 76	com/chelpus/Utils:classes_test	(Ljava/io/File;)Z
    //   683: ifeq +166 -> 849
    //   686: aload 6
    //   688: invokevirtual 79	java/io/File:delete	()Z
    //   691: pop
    //   692: goto +157 -> 849
    //   695: getstatic 87	java/lang/System:out	Ljava/io/PrintStream;
    //   698: ldc 108
    //   700: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   703: new 24	java/io/File
    //   706: dup
    //   707: ldc 110
    //   709: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   712: invokevirtual 37	java/io/File:listFiles	()[Ljava/io/File;
    //   715: astore_0
    //   716: aload_0
    //   717: arraylength
    //   718: istore_3
    //   719: iconst_0
    //   720: istore_1
    //   721: iload_1
    //   722: iload_3
    //   723: if_icmpge +90 -> 813
    //   726: aload_0
    //   727: iload_1
    //   728: aaload
    //   729: astore 5
    //   731: aload 5
    //   733: invokevirtual 46	java/io/File:isDirectory	()Z
    //   736: ifeq +69 -> 805
    //   739: aload 5
    //   741: invokevirtual 37	java/io/File:listFiles	()[Ljava/io/File;
    //   744: astore 5
    //   746: aload 5
    //   748: arraylength
    //   749: istore 4
    //   751: iconst_0
    //   752: istore_2
    //   753: iload_2
    //   754: iload 4
    //   756: if_icmpge +49 -> 805
    //   759: aload 5
    //   761: iload_2
    //   762: aaload
    //   763: astore 6
    //   765: aload 6
    //   767: invokevirtual 69	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   770: invokevirtual 72	java/io/File:toString	()Ljava/lang/String;
    //   773: ldc 81
    //   775: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   778: ifeq +20 -> 798
    //   781: aload 6
    //   783: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   786: ldc 98
    //   788: invokestatic 102	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   791: pop
    //   792: aload 6
    //   794: invokevirtual 79	java/io/File:delete	()Z
    //   797: pop
    //   798: iload_2
    //   799: iconst_1
    //   800: iadd
    //   801: istore_2
    //   802: goto -49 -> 753
    //   805: iload_1
    //   806: iconst_1
    //   807: iadd
    //   808: istore_1
    //   809: goto -88 -> 721
    //   812: astore_0
    //   813: invokestatic 113	com/chelpus/Utils:exitFromRootJava	()V
    //   816: return
    //   817: astore_0
    //   818: goto -115 -> 703
    //   821: iload_2
    //   822: iconst_1
    //   823: iadd
    //   824: istore_2
    //   825: goto -727 -> 98
    //   828: iload_2
    //   829: iconst_1
    //   830: iadd
    //   831: istore_2
    //   832: goto -530 -> 302
    //   835: iload_1
    //   836: iconst_1
    //   837: iadd
    //   838: istore_1
    //   839: goto -588 -> 251
    //   842: iload_2
    //   843: iconst_1
    //   844: iadd
    //   845: istore_2
    //   846: goto -313 -> 533
    //   849: iload_1
    //   850: iconst_1
    //   851: iadd
    //   852: istore_1
    //   853: goto -371 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	856	0	paramArrayOfString	String[]
    //   46	807	1	i	int
    //   97	749	2	j	int
    //   44	680	3	k	int
    //   94	663	4	m	int
    //   55	705	5	localObject	Object
    //   108	685	6	localFile1	java.io.File
    //   147	470	7	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   14	45	216	java/lang/Exception
    //   57	80	216	java/lang/Exception
    //   85	96	216	java/lang/Exception
    //   110	187	216	java/lang/Exception
    //   190	209	216	java/lang/Exception
    //   703	719	812	java/lang/Exception
    //   731	751	812	java/lang/Exception
    //   765	798	812	java/lang/Exception
    //   225	249	817	java/lang/Exception
    //   261	284	817	java/lang/Exception
    //   289	300	817	java/lang/Exception
    //   314	391	817	java/lang/Exception
    //   394	461	817	java/lang/Exception
    //   464	480	817	java/lang/Exception
    //   492	515	817	java/lang/Exception
    //   520	531	817	java/lang/Exception
    //   545	622	817	java/lang/Exception
    //   625	692	817	java/lang/Exception
    //   695	703	817	java/lang/Exception
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/ClearODEXfiles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */