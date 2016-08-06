package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.MappedByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class corepatch
{
  public static final byte[] MAGIC = { 100, 101, 121, 10, 48, 51, 53, 0 };
  public static int adler;
  public static byte[] byteOrig10;
  public static byte[] byteOrig11;
  public static byte[] byteOrig12;
  public static byte[] byteOrig13;
  public static byte[] byteOrig14;
  public static byte[] byteOrig15;
  public static byte[] byteOrig16;
  public static byte[] byteOrig17;
  public static byte[] byteOrig18;
  public static byte[] byteOrig19;
  public static byte[] byteOrig2;
  public static byte[] byteOrig20;
  public static byte[] byteOrig21;
  public static byte[] byteOrig22;
  public static byte[] byteOrig23;
  public static byte[] byteOrig3;
  public static byte[] byteOrig4;
  public static byte[] byteOrig5;
  public static byte[] byteOrig6;
  public static byte[] byteOrig7;
  public static byte[] byteOrig8;
  public static byte[] byteOrig9;
  public static byte[] byteOrigOat1;
  public static byte[] byteOrigOat2;
  public static byte[] byteOrigOat3;
  public static byte[] byteOrigOat4;
  public static byte[] byteOrigOat5;
  public static byte[] byteOrigOat6;
  public static byte[] byteOrigOat6_1;
  public static byte[] byteOrigOat6_3;
  public static byte[] byteOrigOat7;
  public static byte[] byteOrigOat7_1;
  public static byte[] byteOrigOatUpd1;
  public static byte[] byteOrigOatUpd2;
  public static byte[] byteOrigOatUpd4;
  public static byte[] byteOrigOatUpd4_1;
  public static byte[] byteOrigOatUpd5;
  public static byte[] byteOrigOatUpd5_1;
  public static byte[] byteOrigS13;
  public static byte[] byteOrigS14;
  public static byte[] byteOrigS2;
  public static byte[] byteOrigS3;
  public static byte[] byteOrigS4;
  public static byte[] byteOrigS5;
  public static byte[] byteOrigS6;
  public static byte[] byteOrigS7;
  public static byte[] byteOrigSOat1;
  public static byte[] byteOrigSOat10;
  public static byte[] byteOrigSOat10_1;
  public static byte[] byteOrigSOat11;
  public static byte[] byteOrigSOat11_1;
  public static byte[] byteOrigSOat11_2;
  public static byte[] byteOrigSOat12;
  public static byte[] byteOrigSOat12_1;
  public static byte[] byteOrigSOat2;
  public static byte[] byteOrigSOat3;
  public static byte[] byteOrigSOat6;
  public static byte[] byteOrigSOat6_1;
  public static byte[] byteOrigSOat6_2;
  public static byte[] byteOrigSOat6_3;
  public static byte[] byteOrigSOat7;
  public static byte[] byteOrigSOat7_2;
  public static byte[] byteOrigSOat8;
  public static byte[] byteOrigSOat8_1;
  public static byte[] byteOrigSOat9;
  public static byte[] byteOrigSOat9_1;
  public static byte[] byteOrigSOat9_2;
  public static byte[] byteReplace10;
  public static byte[] byteReplace11;
  public static byte[] byteReplace12;
  public static byte[] byteReplace13;
  public static byte[] byteReplace14;
  public static byte[] byteReplace15;
  public static byte[] byteReplace16;
  public static byte[] byteReplace17;
  public static byte[] byteReplace18;
  public static byte[] byteReplace19;
  public static byte[] byteReplace2;
  public static byte[] byteReplace20;
  public static byte[] byteReplace21;
  public static byte[] byteReplace22;
  public static byte[] byteReplace23 = null;
  public static byte[] byteReplace3;
  public static byte[] byteReplace4;
  public static byte[] byteReplace5;
  public static byte[] byteReplace6;
  public static byte[] byteReplace7;
  public static byte[] byteReplace8;
  public static byte[] byteReplace9;
  public static byte[] byteReplaceOat1;
  public static byte[] byteReplaceOat2;
  public static byte[] byteReplaceOat3;
  public static byte[] byteReplaceOat4;
  public static byte[] byteReplaceOat5;
  public static byte[] byteReplaceOat6;
  public static byte[] byteReplaceOat6_1;
  public static byte[] byteReplaceOat6_3;
  public static byte[] byteReplaceOat7;
  public static byte[] byteReplaceOat7_1;
  public static byte[] byteReplaceOatUpd1;
  public static byte[] byteReplaceOatUpd2;
  public static byte[] byteReplaceOatUpd4;
  public static byte[] byteReplaceOatUpd4_1;
  public static byte[] byteReplaceOatUpd5;
  public static byte[] byteReplaceOatUpd5_1;
  public static byte[] byteReplaceS13;
  public static byte[] byteReplaceS14;
  public static byte[] byteReplaceS2;
  public static byte[] byteReplaceS3;
  public static byte[] byteReplaceS4;
  public static byte[] byteReplaceS5;
  public static byte[] byteReplaceS6;
  public static byte[] byteReplaceS7;
  public static byte[] byteReplaceSOat1;
  public static byte[] byteReplaceSOat10;
  public static byte[] byteReplaceSOat10_1;
  public static byte[] byteReplaceSOat11;
  public static byte[] byteReplaceSOat11_1;
  public static byte[] byteReplaceSOat11_2;
  public static byte[] byteReplaceSOat12;
  public static byte[] byteReplaceSOat12_1;
  public static byte[] byteReplaceSOat2;
  public static byte[] byteReplaceSOat3;
  public static byte[] byteReplaceSOat6;
  public static byte[] byteReplaceSOat6_1;
  public static byte[] byteReplaceSOat6_2;
  public static byte[] byteReplaceSOat6_3;
  public static byte[] byteReplaceSOat7;
  public static byte[] byteReplaceSOat7_2;
  public static byte[] byteReplaceSOat8;
  public static byte[] byteReplaceSOat8_1;
  public static byte[] byteReplaceSOat9;
  public static byte[] byteReplaceSOat9_1;
  public static byte[] byteReplaceSOat9_2;
  public static MappedByteBuffer fileBytes;
  public static byte[] lastByteReplace;
  public static int lastPatchPosition;
  public static byte[] mask10;
  public static byte[] mask11;
  public static byte[] mask12;
  public static byte[] mask13;
  public static byte[] mask14;
  public static byte[] mask15;
  public static byte[] mask16;
  public static byte[] mask17;
  public static byte[] mask18;
  public static byte[] mask19;
  public static byte[] mask2;
  public static byte[] mask20;
  public static byte[] mask21;
  public static byte[] mask22;
  public static byte[] mask23;
  public static byte[] mask4;
  public static byte[] mask5;
  public static byte[] mask6;
  public static byte[] mask7;
  public static byte[] mask8;
  public static byte[] mask9;
  public static byte[] maskOat1;
  public static byte[] maskOat2;
  public static byte[] maskOat3;
  public static byte[] maskOat4;
  public static byte[] maskOat5;
  public static byte[] maskOat6;
  public static byte[] maskOat6_1;
  public static byte[] maskOat6_3;
  public static byte[] maskOat7;
  public static byte[] maskOat7_1;
  public static byte[] maskOatUpd1;
  public static byte[] maskOatUpd2;
  public static byte[] maskOatUpd4;
  public static byte[] maskOatUpd4_1;
  public static byte[] maskOatUpd5;
  public static byte[] maskOatUpd5_1;
  public static byte[] maskS13;
  public static byte[] maskS14;
  public static byte[] maskS2;
  public static byte[] maskS3;
  public static byte[] maskS4;
  public static byte[] maskS5;
  public static byte[] maskS6;
  public static byte[] maskS7;
  public static byte[] maskSOat1;
  public static byte[] maskSOat10;
  public static byte[] maskSOat10_1;
  public static byte[] maskSOat11;
  public static byte[] maskSOat11_1;
  public static byte[] maskSOat11_2;
  public static byte[] maskSOat12;
  public static byte[] maskSOat12_1;
  public static byte[] maskSOat2;
  public static byte[] maskSOat3;
  public static byte[] maskSOat6;
  public static byte[] maskSOat6_1;
  public static byte[] maskSOat6_2;
  public static byte[] maskSOat6_3;
  public static byte[] maskSOat7;
  public static byte[] maskSOat7_2;
  public static byte[] maskSOat8;
  public static byte[] maskSOat8_1;
  public static byte[] maskSOat9;
  public static byte[] maskSOat9_1;
  public static byte[] maskSOat9_2;
  public static boolean not_found_bytes_for_patch;
  public static boolean onlyDalvik;
  public static byte[] rep_mask10;
  public static byte[] rep_mask11;
  public static byte[] rep_mask12;
  public static byte[] rep_mask13;
  public static byte[] rep_mask14;
  public static byte[] rep_mask15;
  public static byte[] rep_mask16;
  public static byte[] rep_mask17;
  public static byte[] rep_mask18;
  public static byte[] rep_mask19;
  public static byte[] rep_mask2;
  public static byte[] rep_mask20;
  public static byte[] rep_mask21;
  public static byte[] rep_mask22;
  public static byte[] rep_mask23 = null;
  public static byte[] rep_mask4;
  public static byte[] rep_mask5;
  public static byte[] rep_mask6;
  public static byte[] rep_mask7;
  public static byte[] rep_mask8;
  public static byte[] rep_mask9;
  public static byte[] rep_maskOat1;
  public static byte[] rep_maskOat2;
  public static byte[] rep_maskOat3;
  public static byte[] rep_maskOat4;
  public static byte[] rep_maskOat5;
  public static byte[] rep_maskOat6;
  public static byte[] rep_maskOat6_1;
  public static byte[] rep_maskOat6_3;
  public static byte[] rep_maskOat7;
  public static byte[] rep_maskOat7_1;
  public static byte[] rep_maskOatUpd1;
  public static byte[] rep_maskOatUpd2;
  public static byte[] rep_maskOatUpd4;
  public static byte[] rep_maskOatUpd4_1;
  public static byte[] rep_maskOatUpd5;
  public static byte[] rep_maskOatUpd5_1;
  public static byte[] rep_maskS13;
  public static byte[] rep_maskS14;
  public static byte[] rep_maskS2;
  public static byte[] rep_maskS3;
  public static byte[] rep_maskS4;
  public static byte[] rep_maskS5;
  public static byte[] rep_maskS6;
  public static byte[] rep_maskS7;
  public static byte[] rep_maskSOat1;
  public static byte[] rep_maskSOat10;
  public static byte[] rep_maskSOat10_1;
  public static byte[] rep_maskSOat11;
  public static byte[] rep_maskSOat11_1;
  public static byte[] rep_maskSOat11_2;
  public static byte[] rep_maskSOat12;
  public static byte[] rep_maskSOat12_1;
  public static byte[] rep_maskSOat2;
  public static byte[] rep_maskSOat3;
  public static byte[] rep_maskSOat6;
  public static byte[] rep_maskSOat6_1;
  public static byte[] rep_maskSOat6_2;
  public static byte[] rep_maskSOat6_3;
  public static byte[] rep_maskSOat7;
  public static byte[] rep_maskSOat7_2;
  public static byte[] rep_maskSOat8;
  public static byte[] rep_maskSOat8_1;
  public static byte[] rep_maskSOat9;
  public static byte[] rep_maskSOat9_1;
  public static byte[] rep_maskSOat9_2;
  public static String toolfilesdir = "";
  
  static
  {
    onlyDalvik = false;
    not_found_bytes_for_patch = false;
    fileBytes = null;
    lastPatchPosition = 0;
    lastByteReplace = null;
    byteOrig2 = null;
    mask2 = null;
    byteReplace2 = null;
    rep_mask2 = null;
    byteOrigOatUpd1 = null;
    maskOatUpd1 = null;
    byteReplaceOatUpd1 = null;
    rep_maskOatUpd1 = null;
    byteOrigOatUpd2 = null;
    maskOatUpd2 = null;
    byteReplaceOatUpd2 = null;
    rep_maskOatUpd2 = null;
    byteOrigOat1 = null;
    maskOat1 = null;
    byteReplaceOat1 = null;
    rep_maskOat1 = null;
    byteOrigOat2 = null;
    maskOat2 = null;
    byteReplaceOat2 = null;
    rep_maskOat2 = null;
    byteOrigOat3 = null;
    maskOat3 = null;
    byteReplaceOat3 = null;
    rep_maskOat3 = null;
    byteOrigOat6_3 = null;
    maskOat6_3 = null;
    byteReplaceOat6_3 = null;
    rep_maskOat6_3 = null;
    byteOrigOatUpd4 = null;
    maskOatUpd4 = null;
    byteReplaceOatUpd4 = null;
    rep_maskOatUpd4 = null;
    byteOrigOatUpd4_1 = null;
    maskOatUpd4_1 = null;
    byteReplaceOatUpd4_1 = null;
    rep_maskOatUpd4_1 = null;
    byteOrigOatUpd5 = null;
    maskOatUpd5 = null;
    byteReplaceOatUpd5 = null;
    rep_maskOatUpd5 = null;
    byteOrigOatUpd5_1 = null;
    maskOatUpd5_1 = null;
    byteReplaceOatUpd5_1 = null;
    rep_maskOatUpd5_1 = null;
    byteOrigOat4 = null;
    maskOat4 = null;
    byteReplaceOat4 = null;
    rep_maskOat4 = null;
    byteOrigOat5 = null;
    maskOat5 = null;
    byteReplaceOat5 = null;
    rep_maskOat5 = null;
    byteOrigOat6 = null;
    maskOat6 = null;
    byteReplaceOat6 = null;
    rep_maskOat6 = null;
    byteOrigOat6_1 = null;
    maskOat6_1 = null;
    byteReplaceOat6_1 = null;
    rep_maskOat6_1 = null;
    byteOrigOat7 = null;
    maskOat7 = null;
    byteReplaceOat7 = null;
    rep_maskOat7 = null;
    byteOrigOat7_1 = null;
    maskOat7_1 = null;
    byteReplaceOat7_1 = null;
    rep_maskOat7_1 = null;
    byteOrigSOat1 = null;
    maskSOat1 = null;
    byteReplaceSOat1 = null;
    rep_maskSOat1 = null;
    byteOrigSOat6_1 = null;
    maskSOat6_1 = null;
    byteReplaceSOat6_1 = null;
    rep_maskSOat6_1 = null;
    byteOrigSOat2 = null;
    maskSOat2 = null;
    byteReplaceSOat2 = null;
    rep_maskSOat2 = null;
    byteOrigSOat6_2 = null;
    maskSOat6_2 = null;
    byteReplaceSOat6_2 = null;
    rep_maskSOat6_2 = null;
    byteOrigSOat6_3 = null;
    maskSOat6_3 = null;
    byteReplaceSOat6_3 = null;
    rep_maskSOat6_3 = null;
    byteOrigSOat3 = null;
    maskSOat3 = null;
    byteReplaceSOat3 = null;
    rep_maskSOat3 = null;
    byteOrigSOat6 = null;
    maskSOat6 = null;
    byteReplaceSOat6 = null;
    rep_maskSOat6 = null;
    byteOrigSOat7 = null;
    maskSOat7 = null;
    byteReplaceSOat7 = null;
    rep_maskSOat7 = null;
    byteOrigSOat7_2 = null;
    maskSOat7_2 = null;
    byteReplaceSOat7_2 = null;
    rep_maskSOat7_2 = null;
    byteOrigSOat8 = null;
    maskSOat8 = null;
    byteReplaceSOat8 = null;
    rep_maskSOat8 = null;
    byteOrigSOat8_1 = null;
    maskSOat8_1 = null;
    byteReplaceSOat8_1 = null;
    rep_maskSOat8_1 = null;
    byteOrigSOat9 = null;
    maskSOat9 = null;
    byteReplaceSOat9 = null;
    rep_maskSOat9 = null;
    byteOrigSOat9_1 = null;
    maskSOat9_1 = null;
    byteReplaceSOat9_1 = null;
    rep_maskSOat9_1 = null;
    byteOrigSOat9_2 = null;
    maskSOat9_2 = null;
    byteReplaceSOat9_2 = null;
    rep_maskSOat9_2 = null;
    byteOrigSOat10 = null;
    maskSOat10 = null;
    byteReplaceSOat10 = null;
    rep_maskSOat10 = null;
    byteOrigSOat10_1 = null;
    maskSOat10_1 = null;
    byteReplaceSOat10_1 = null;
    rep_maskSOat10_1 = null;
    byteOrigSOat11 = null;
    maskSOat11 = null;
    byteReplaceSOat11 = null;
    rep_maskSOat11 = null;
    byteOrigSOat11_1 = null;
    maskSOat11_1 = null;
    byteReplaceSOat11_1 = null;
    rep_maskSOat11_1 = null;
    byteOrigSOat11_2 = null;
    maskSOat11_2 = null;
    byteReplaceSOat11_2 = null;
    rep_maskSOat11_2 = null;
    byteOrigSOat12 = null;
    maskSOat12 = null;
    byteReplaceSOat12 = null;
    rep_maskSOat12 = null;
    byteOrigSOat12_1 = null;
    maskSOat12_1 = null;
    byteReplaceSOat12_1 = null;
    rep_maskSOat12_1 = null;
    byteOrigS2 = null;
    maskS2 = null;
    byteReplaceS2 = null;
    rep_maskS2 = null;
    byteOrigS3 = null;
    maskS3 = null;
    byteReplaceS3 = null;
    rep_maskS3 = null;
    byteOrigS4 = null;
    maskS4 = null;
    byteReplaceS4 = null;
    rep_maskS4 = null;
    byteOrigS5 = null;
    maskS5 = null;
    byteReplaceS5 = null;
    rep_maskS5 = null;
    byteOrigS6 = null;
    maskS6 = null;
    byteReplaceS6 = null;
    rep_maskS6 = null;
    byteOrigS7 = null;
    maskS7 = null;
    byteReplaceS7 = null;
    rep_maskS7 = null;
    byteOrigS13 = null;
    maskS13 = null;
    byteReplaceS13 = null;
    rep_maskS13 = null;
    byteOrigS14 = null;
    maskS14 = null;
    byteReplaceS14 = null;
    rep_maskS14 = null;
    byteOrig3 = null;
    byteReplace3 = null;
    byteOrig4 = null;
    mask4 = null;
    byteReplace4 = null;
    rep_mask4 = null;
    byteOrig5 = null;
    mask5 = null;
    byteReplace5 = null;
    rep_mask5 = null;
    byteOrig6 = null;
    mask6 = null;
    byteReplace6 = null;
    rep_mask6 = null;
    byteOrig7 = null;
    mask7 = null;
    byteReplace7 = null;
    rep_mask7 = null;
    byteOrig8 = null;
    mask8 = null;
    byteReplace8 = null;
    rep_mask8 = null;
    byteOrig9 = null;
    mask9 = null;
    byteReplace9 = null;
    rep_mask9 = null;
    byteOrig10 = null;
    mask10 = null;
    byteReplace10 = null;
    rep_mask10 = null;
    byteOrig11 = null;
    mask11 = null;
    byteReplace11 = null;
    rep_mask11 = null;
    byteOrig12 = null;
    mask12 = null;
    byteReplace12 = null;
    rep_mask12 = null;
    byteOrig13 = null;
    mask13 = null;
    byteReplace13 = null;
    rep_mask13 = null;
    byteOrig14 = null;
    mask14 = null;
    byteReplace14 = null;
    rep_mask14 = null;
    byteOrig15 = null;
    mask15 = null;
    byteReplace15 = null;
    rep_mask15 = null;
    byteOrig16 = null;
    mask16 = null;
    byteReplace16 = null;
    rep_mask16 = null;
    byteOrig17 = null;
    mask17 = null;
    byteReplace17 = null;
    rep_mask17 = null;
    byteOrig18 = null;
    mask18 = null;
    byteReplace18 = null;
    rep_mask18 = null;
    byteOrig19 = null;
    mask19 = null;
    byteReplace19 = null;
    rep_mask19 = null;
    byteOrig20 = null;
    mask20 = null;
    byteReplace20 = null;
    rep_mask20 = null;
    byteOrig21 = null;
    mask21 = null;
    byteReplace21 = null;
    rep_mask21 = null;
    byteOrig22 = null;
    mask22 = null;
    byteReplace22 = null;
    rep_mask22 = null;
    byteOrig23 = null;
    mask23 = null;
  }
  
  private static boolean applyPatch(int paramInt, byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, boolean paramBoolean)
  {
    if ((paramArrayOfByte1 != null) && (paramByte == paramArrayOfByte1[0]) && (paramBoolean))
    {
      if (paramArrayOfByte4[0] == 0) {
        paramArrayOfByte3[0] = paramByte;
      }
      int i = 1;
      fileBytes.position(paramInt + 1);
      for (paramByte = fileBytes.get(); (paramByte == paramArrayOfByte1[i]) || (paramArrayOfByte2[i] == 1); paramByte = fileBytes.get())
      {
        if (paramArrayOfByte4[i] == 0) {
          paramArrayOfByte3[i] = paramByte;
        }
        if (paramArrayOfByte4[i] == 3) {
          paramArrayOfByte3[i] = ((byte)(paramByte & 0xF));
        }
        if (paramArrayOfByte4[i] == 2) {
          paramArrayOfByte3[i] = ((byte)((paramByte & 0xF) + (paramByte & 0xF) * 16));
        }
        i += 1;
        if (i == paramArrayOfByte1.length)
        {
          fileBytes.position(paramInt);
          fileBytes.put(paramArrayOfByte3);
          fileBytes.force();
          return true;
        }
      }
      fileBytes.position(paramInt + 1);
    }
    return false;
  }
  
  private static boolean applyPatchCounter(int paramInt1, byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramArrayOfByte1 != null) && (paramByte == paramArrayOfByte1[0]) && (paramBoolean))
    {
      if (paramArrayOfByte4[0] == 0) {
        paramArrayOfByte3[0] = paramByte;
      }
      int i = 1;
      fileBytes.position(paramInt1 + 1);
      for (paramByte = fileBytes.get(); (paramByte == paramArrayOfByte1[i]) || (paramArrayOfByte2[i] == 1); paramByte = fileBytes.get())
      {
        if (paramArrayOfByte4[i] == 0) {
          paramArrayOfByte3[i] = paramByte;
        }
        if (paramArrayOfByte4[i] == 3) {
          paramArrayOfByte3[i] = ((byte)(paramByte & 0xF));
        }
        if (paramArrayOfByte4[i] == 2) {
          paramArrayOfByte3[i] = ((byte)((paramByte & 0xF) + (paramByte & 0xF) * 16));
        }
        i += 1;
        if (i == paramArrayOfByte1.length)
        {
          if (paramInt2 >= paramInt3)
          {
            lastPatchPosition = paramInt1;
            lastByteReplace = new byte[paramArrayOfByte3.length];
            System.arraycopy(paramArrayOfByte3, 0, lastByteReplace, 0, paramArrayOfByte3.length);
          }
          return true;
        }
      }
      fileBytes.position(paramInt1 + 1);
    }
    return false;
  }
  
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 6	com/chelpus/root/utils/corepatch$1
    //   3: dup
    //   4: invokespecial 884	com/chelpus/root/utils/corepatch$1:<init>	()V
    //   7: invokestatic 890	com/chelpus/Utils:startRootJava	(Ljava/lang/Object;)V
    //   10: iconst_0
    //   11: istore 26
    //   13: iconst_0
    //   14: istore 27
    //   16: iconst_0
    //   17: istore 24
    //   19: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22: aload_0
    //   23: iconst_0
    //   24: aaload
    //   25: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   28: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   31: aload_0
    //   32: iconst_1
    //   33: aaload
    //   34: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   37: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   40: aload_0
    //   41: iconst_2
    //   42: aaload
    //   43: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   46: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   49: aload_0
    //   50: iconst_3
    //   51: aaload
    //   52: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   55: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   58: aload_0
    //   59: iconst_4
    //   60: aaload
    //   61: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   64: aload_0
    //   65: iconst_4
    //   66: aaload
    //   67: ifnull +19 -> 86
    //   70: aload_0
    //   71: iconst_4
    //   72: aaload
    //   73: ldc_w 902
    //   76: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +7 -> 86
    //   82: iconst_1
    //   83: putstatic 303	com/chelpus/root/utils/corepatch:onlyDalvik	Z
    //   86: aload_0
    //   87: iconst_3
    //   88: aaload
    //   89: ifnull +9 -> 98
    //   92: aload_0
    //   93: iconst_3
    //   94: aaload
    //   95: putstatic 301	com/chelpus/root/utils/corepatch:toolfilesdir	Ljava/lang/String;
    //   98: aload_0
    //   99: iconst_4
    //   100: aaload
    //   101: ldc_w 910
    //   104: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +25 -> 132
    //   110: aload_0
    //   111: iconst_4
    //   112: aaload
    //   113: ldc_w 902
    //   116: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   119: ifne +13 -> 132
    //   122: ldc_w 912
    //   125: ldc_w 914
    //   128: invokestatic 918	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   131: pop
    //   132: aload_0
    //   133: iconst_1
    //   134: aaload
    //   135: ldc_w 920
    //   138: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   141: ifne +59 -> 200
    //   144: aload_0
    //   145: iconst_1
    //   146: aaload
    //   147: ldc_w 926
    //   150: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   153: ifne +47 -> 200
    //   156: aload_0
    //   157: iconst_1
    //   158: aaload
    //   159: ldc_w 928
    //   162: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   165: ifne +35 -> 200
    //   168: aload_0
    //   169: iconst_1
    //   170: aaload
    //   171: ldc_w 930
    //   174: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   177: ifne +23 -> 200
    //   180: iload 26
    //   182: istore 28
    //   184: iload 27
    //   186: istore 25
    //   188: aload_0
    //   189: iconst_1
    //   190: aaload
    //   191: ldc_w 932
    //   194: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   197: ifeq +42 -> 239
    //   200: iload 26
    //   202: istore 28
    //   204: iload 27
    //   206: istore 25
    //   208: aload_0
    //   209: iconst_4
    //   210: aaload
    //   211: ldc_w 910
    //   214: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifeq +22 -> 239
    //   220: iconst_1
    //   221: istore 28
    //   223: iconst_1
    //   224: istore 25
    //   226: iconst_0
    //   227: invokestatic 938	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   230: putstatic 944	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   233: aload_0
    //   234: iconst_0
    //   235: ldc_w 946
    //   238: aastore
    //   239: aload_0
    //   240: iconst_1
    //   241: aaload
    //   242: ldc_w 948
    //   245: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   248: ifne +19 -> 267
    //   251: iload 24
    //   253: istore 26
    //   255: aload_0
    //   256: iconst_1
    //   257: aaload
    //   258: ldc_w 950
    //   261: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   264: ifeq +35 -> 299
    //   267: iload 24
    //   269: istore 26
    //   271: aload_0
    //   272: iconst_4
    //   273: aaload
    //   274: ldc_w 910
    //   277: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   280: ifeq +19 -> 299
    //   283: iconst_1
    //   284: istore 26
    //   286: iconst_0
    //   287: invokestatic 938	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   290: putstatic 944	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   293: aload_0
    //   294: iconst_0
    //   295: ldc_w 946
    //   298: aastore
    //   299: iconst_0
    //   300: istore_2
    //   301: iconst_0
    //   302: istore_3
    //   303: iload 28
    //   305: istore 29
    //   307: iload 25
    //   309: istore 27
    //   311: iload 26
    //   313: istore 24
    //   315: aload_0
    //   316: iconst_0
    //   317: aaload
    //   318: ldc_w 946
    //   321: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   324: ifeq +84 -> 408
    //   327: aload_0
    //   328: iconst_0
    //   329: aaload
    //   330: ldc_w 952
    //   333: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   336: ifeq +6 -> 342
    //   339: iconst_1
    //   340: istore 28
    //   342: aload_0
    //   343: iconst_0
    //   344: aaload
    //   345: ldc_w 954
    //   348: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   351: ifeq +6 -> 357
    //   354: iconst_1
    //   355: istore 25
    //   357: iload 26
    //   359: istore 24
    //   361: aload_0
    //   362: iconst_0
    //   363: aaload
    //   364: ldc_w 956
    //   367: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   370: ifeq +6 -> 376
    //   373: iconst_1
    //   374: istore 24
    //   376: iload_3
    //   377: istore_2
    //   378: aload_0
    //   379: iconst_0
    //   380: aaload
    //   381: ldc_w 958
    //   384: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   387: ifeq +5 -> 392
    //   390: iconst_1
    //   391: istore_2
    //   392: new 960	com/chelpus/root/utils/SetCorePatch
    //   395: dup
    //   396: invokespecial 961	com/chelpus/root/utils/SetCorePatch:<init>	()V
    //   399: pop
    //   400: iload 25
    //   402: istore 27
    //   404: iload 28
    //   406: istore 29
    //   408: iload 29
    //   410: istore 28
    //   412: iload 27
    //   414: istore 26
    //   416: iload 24
    //   418: istore 25
    //   420: iload_2
    //   421: istore 22
    //   423: aload_0
    //   424: iconst_0
    //   425: aaload
    //   426: ldc_w 963
    //   429: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   432: ifeq +61 -> 493
    //   435: aload_0
    //   436: iconst_0
    //   437: aaload
    //   438: ldc_w 965
    //   441: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   444: ifeq +9 -> 453
    //   447: iconst_1
    //   448: istore 29
    //   450: iconst_1
    //   451: istore 27
    //   453: aload_0
    //   454: iconst_0
    //   455: aaload
    //   456: ldc_w 967
    //   459: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   462: ifeq +8 -> 470
    //   465: iconst_1
    //   466: istore 24
    //   468: iconst_1
    //   469: istore_2
    //   470: new 969	com/chelpus/root/utils/SetCoreRestore
    //   473: dup
    //   474: invokespecial 970	com/chelpus/root/utils/SetCoreRestore:<init>	()V
    //   477: pop
    //   478: iload_2
    //   479: istore 22
    //   481: iload 24
    //   483: istore 25
    //   485: iload 27
    //   487: istore 26
    //   489: iload 29
    //   491: istore 28
    //   493: aload_0
    //   494: iconst_0
    //   495: aaload
    //   496: ldc_w 963
    //   499: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   502: ifne +27 -> 529
    //   505: aload_0
    //   506: iconst_0
    //   507: aaload
    //   508: ldc_w 946
    //   511: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   514: ifne +15 -> 529
    //   517: aload_0
    //   518: iconst_0
    //   519: aaload
    //   520: ldc_w 972
    //   523: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   526: ifeq +20068 -> 20594
    //   529: new 974	java/util/ArrayList
    //   532: dup
    //   533: invokespecial 975	java/util/ArrayList:<init>	()V
    //   536: astore 37
    //   538: aload 37
    //   540: invokevirtual 978	java/util/ArrayList:clear	()V
    //   543: iload 28
    //   545: ifne +8 -> 553
    //   548: iload 26
    //   550: ifeq +8349 -> 8899
    //   553: new 974	java/util/ArrayList
    //   556: dup
    //   557: invokespecial 975	java/util/ArrayList:<init>	()V
    //   560: astore 32
    //   562: getstatic 303	com/chelpus/root/utils/corepatch:onlyDalvik	Z
    //   565: ifne +5449 -> 6014
    //   568: new 980	java/io/File
    //   571: dup
    //   572: ldc_w 982
    //   575: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   578: invokevirtual 988	java/io/File:exists	()Z
    //   581: ifeq +19 -> 600
    //   584: aload 32
    //   586: new 980	java/io/File
    //   589: dup
    //   590: ldc_w 982
    //   593: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   596: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   599: pop
    //   600: new 980	java/io/File
    //   603: dup
    //   604: ldc_w 993
    //   607: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   610: invokevirtual 988	java/io/File:exists	()Z
    //   613: ifeq +19 -> 632
    //   616: aload 32
    //   618: new 980	java/io/File
    //   621: dup
    //   622: ldc_w 993
    //   625: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   628: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   631: pop
    //   632: new 980	java/io/File
    //   635: dup
    //   636: ldc_w 995
    //   639: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   642: invokevirtual 988	java/io/File:exists	()Z
    //   645: ifeq +19 -> 664
    //   648: aload 32
    //   650: new 980	java/io/File
    //   653: dup
    //   654: ldc_w 995
    //   657: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   660: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   663: pop
    //   664: new 980	java/io/File
    //   667: dup
    //   668: ldc_w 997
    //   671: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   674: invokevirtual 988	java/io/File:exists	()Z
    //   677: ifeq +19 -> 696
    //   680: aload 32
    //   682: new 980	java/io/File
    //   685: dup
    //   686: ldc_w 997
    //   689: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   692: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   695: pop
    //   696: new 980	java/io/File
    //   699: dup
    //   700: ldc_w 999
    //   703: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   706: invokevirtual 988	java/io/File:exists	()Z
    //   709: ifeq +19 -> 728
    //   712: aload 32
    //   714: new 980	java/io/File
    //   717: dup
    //   718: ldc_w 999
    //   721: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   724: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   727: pop
    //   728: new 980	java/io/File
    //   731: dup
    //   732: ldc_w 1001
    //   735: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   738: invokevirtual 988	java/io/File:exists	()Z
    //   741: ifeq +19 -> 760
    //   744: aload 32
    //   746: new 980	java/io/File
    //   749: dup
    //   750: ldc_w 1001
    //   753: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   756: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   759: pop
    //   760: new 980	java/io/File
    //   763: dup
    //   764: ldc_w 1003
    //   767: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   770: invokevirtual 988	java/io/File:exists	()Z
    //   773: ifeq +19 -> 792
    //   776: aload 32
    //   778: new 980	java/io/File
    //   781: dup
    //   782: ldc_w 1003
    //   785: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   788: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   791: pop
    //   792: new 980	java/io/File
    //   795: dup
    //   796: ldc_w 1005
    //   799: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   802: invokevirtual 988	java/io/File:exists	()Z
    //   805: ifeq +19 -> 824
    //   808: aload 32
    //   810: new 980	java/io/File
    //   813: dup
    //   814: ldc_w 1005
    //   817: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   820: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   823: pop
    //   824: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   827: ldc_w 1007
    //   830: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   833: aload 32
    //   835: invokevirtual 1011	java/util/ArrayList:size	()I
    //   838: ifle +5716 -> 6554
    //   841: getstatic 1014	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:api	I
    //   844: bipush 21
    //   846: if_icmplt +5708 -> 6554
    //   849: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   852: ldc_w 1016
    //   855: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   858: iconst_0
    //   859: istore 6
    //   861: iconst_0
    //   862: istore 11
    //   864: iconst_0
    //   865: istore 8
    //   867: iconst_0
    //   868: istore 7
    //   870: aload 32
    //   872: invokevirtual 1020	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   875: astore 32
    //   877: aload 32
    //   879: invokeinterface 1025 1 0
    //   884: ifeq +5495 -> 6379
    //   887: aload 32
    //   889: invokeinterface 1029 1 0
    //   894: checkcast 980	java/io/File
    //   897: astore 33
    //   899: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   902: new 1031	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   909: ldc_w 1034
    //   912: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload 33
    //   917: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   920: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   929: iconst_0
    //   930: istore 19
    //   932: iconst_0
    //   933: istore 20
    //   935: iconst_0
    //   936: istore 21
    //   938: iconst_0
    //   939: istore 18
    //   941: iload 11
    //   943: istore_2
    //   944: iload 8
    //   946: istore 9
    //   948: iload 7
    //   950: istore_3
    //   951: iload 6
    //   953: istore 10
    //   955: new 1047	java/io/RandomAccessFile
    //   958: dup
    //   959: aload 33
    //   961: ldc_w 914
    //   964: invokespecial 1050	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   967: invokevirtual 1054	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   970: astore 33
    //   972: iload 11
    //   974: istore_2
    //   975: iload 8
    //   977: istore 9
    //   979: iload 7
    //   981: istore_3
    //   982: iload 6
    //   984: istore 10
    //   986: aload 33
    //   988: getstatic 1060	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   991: lconst_0
    //   992: aload 33
    //   994: invokevirtual 1065	java/nio/channels/FileChannel:size	()J
    //   997: l2i
    //   998: i2l
    //   999: invokevirtual 1069	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   1002: putstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   1005: iload 11
    //   1007: istore_2
    //   1008: iload 8
    //   1010: istore 9
    //   1012: iload 7
    //   1014: istore_3
    //   1015: iload 6
    //   1017: istore 10
    //   1019: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   1022: sipush 4120
    //   1025: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1028: pop
    //   1029: iload 11
    //   1031: istore_2
    //   1032: iload 8
    //   1034: istore 9
    //   1036: iload 7
    //   1038: istore_3
    //   1039: iload 6
    //   1041: istore 10
    //   1043: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   1046: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   1049: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   1052: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   1055: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   1058: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   1061: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   1064: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   1067: invokestatic 1073	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   1070: istore 4
    //   1072: iload 11
    //   1074: istore_2
    //   1075: iload 8
    //   1077: istore 9
    //   1079: iload 7
    //   1081: istore_3
    //   1082: iload 6
    //   1084: istore 10
    //   1086: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   1089: new 1031	java/lang/StringBuilder
    //   1092: dup
    //   1093: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   1096: ldc_w 1075
    //   1099: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: iload 4
    //   1104: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1107: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1110: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1113: iload 11
    //   1115: istore_2
    //   1116: iload 8
    //   1118: istore 9
    //   1120: iload 7
    //   1122: istore_3
    //   1123: iload 6
    //   1125: istore 10
    //   1127: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   1130: iload 4
    //   1132: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1135: pop
    //   1136: iload 11
    //   1138: istore 17
    //   1140: iload 8
    //   1142: istore 16
    //   1144: iload 7
    //   1146: istore 15
    //   1148: iload 6
    //   1150: istore 14
    //   1152: iload 11
    //   1154: istore_2
    //   1155: iload 8
    //   1157: istore 9
    //   1159: iload 7
    //   1161: istore_3
    //   1162: iload 6
    //   1164: istore 10
    //   1166: iload 11
    //   1168: istore 4
    //   1170: iload 8
    //   1172: istore 12
    //   1174: iload 7
    //   1176: istore 5
    //   1178: iload 6
    //   1180: istore 13
    //   1182: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   1185: invokevirtual 1081	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   1188: ifeq +4754 -> 5942
    //   1191: iload 11
    //   1193: istore_2
    //   1194: iload 8
    //   1196: istore 9
    //   1198: iload 7
    //   1200: istore_3
    //   1201: iload 6
    //   1203: istore 10
    //   1205: iload 11
    //   1207: istore 4
    //   1209: iload 8
    //   1211: istore 12
    //   1213: iload 7
    //   1215: istore 5
    //   1217: iload 6
    //   1219: istore 13
    //   1221: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   1224: invokevirtual 1083	java/nio/MappedByteBuffer:position	()I
    //   1227: istore 23
    //   1229: iload 11
    //   1231: istore_2
    //   1232: iload 8
    //   1234: istore 9
    //   1236: iload 7
    //   1238: istore_3
    //   1239: iload 6
    //   1241: istore 10
    //   1243: iload 11
    //   1245: istore 4
    //   1247: iload 8
    //   1249: istore 12
    //   1251: iload 7
    //   1253: istore 5
    //   1255: iload 6
    //   1257: istore 13
    //   1259: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   1262: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   1265: istore_1
    //   1266: iload 21
    //   1268: istore 15
    //   1270: iload 6
    //   1272: istore 14
    //   1274: iload 19
    //   1276: istore 16
    //   1278: iload 11
    //   1280: istore_2
    //   1281: iload 8
    //   1283: istore 9
    //   1285: iload 7
    //   1287: istore_3
    //   1288: iload 6
    //   1290: istore 10
    //   1292: iload 11
    //   1294: istore 4
    //   1296: iload 8
    //   1298: istore 12
    //   1300: iload 7
    //   1302: istore 5
    //   1304: iload 6
    //   1306: istore 13
    //   1308: iload 23
    //   1310: iload_1
    //   1311: getstatic 321	com/chelpus/root/utils/corepatch:byteOrigOatUpd1	[B
    //   1314: getstatic 323	com/chelpus/root/utils/corepatch:maskOatUpd1	[B
    //   1317: getstatic 325	com/chelpus/root/utils/corepatch:byteReplaceOatUpd1	[B
    //   1320: getstatic 327	com/chelpus/root/utils/corepatch:rep_maskOatUpd1	[B
    //   1323: iload 28
    //   1325: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   1328: ifeq +225 -> 1553
    //   1331: iload 11
    //   1333: istore_2
    //   1334: iload 8
    //   1336: istore 9
    //   1338: iload 7
    //   1340: istore_3
    //   1341: iload 6
    //   1343: istore 10
    //   1345: iload 11
    //   1347: istore 4
    //   1349: iload 8
    //   1351: istore 12
    //   1353: iload 7
    //   1355: istore 5
    //   1357: iload 6
    //   1359: istore 13
    //   1361: aload_0
    //   1362: iconst_0
    //   1363: aaload
    //   1364: ldc_w 946
    //   1367: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1370: ifeq +99 -> 1469
    //   1373: iload 11
    //   1375: istore_2
    //   1376: iload 8
    //   1378: istore 9
    //   1380: iload 7
    //   1382: istore_3
    //   1383: iload 6
    //   1385: istore 10
    //   1387: iload 11
    //   1389: istore 4
    //   1391: iload 8
    //   1393: istore 12
    //   1395: iload 7
    //   1397: istore 5
    //   1399: iload 6
    //   1401: istore 13
    //   1403: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   1406: new 1031	java/lang/StringBuilder
    //   1409: dup
    //   1410: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   1413: ldc_w 1087
    //   1416: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: iload 23
    //   1421: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1424: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1427: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1430: iload 11
    //   1432: istore_2
    //   1433: iload 8
    //   1435: istore 9
    //   1437: iload 7
    //   1439: istore_3
    //   1440: iload 6
    //   1442: istore 10
    //   1444: iload 11
    //   1446: istore 4
    //   1448: iload 8
    //   1450: istore 12
    //   1452: iload 7
    //   1454: istore 5
    //   1456: iload 6
    //   1458: istore 13
    //   1460: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   1463: ldc_w 1089
    //   1466: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1469: iload 11
    //   1471: istore_2
    //   1472: iload 8
    //   1474: istore 9
    //   1476: iload 7
    //   1478: istore_3
    //   1479: iload 6
    //   1481: istore 10
    //   1483: iload 11
    //   1485: istore 4
    //   1487: iload 8
    //   1489: istore 12
    //   1491: iload 7
    //   1493: istore 5
    //   1495: iload 6
    //   1497: istore 13
    //   1499: aload_0
    //   1500: iconst_0
    //   1501: aaload
    //   1502: ldc_w 963
    //   1505: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1508: ifeq +23568 -> 25076
    //   1511: iload 11
    //   1513: istore_2
    //   1514: iload 8
    //   1516: istore 9
    //   1518: iload 7
    //   1520: istore_3
    //   1521: iload 6
    //   1523: istore 10
    //   1525: iload 11
    //   1527: istore 4
    //   1529: iload 8
    //   1531: istore 12
    //   1533: iload 7
    //   1535: istore 5
    //   1537: iload 6
    //   1539: istore 13
    //   1541: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   1544: ldc_w 1091
    //   1547: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1550: goto +23526 -> 25076
    //   1553: iload 14
    //   1555: istore 6
    //   1557: iload 11
    //   1559: istore_2
    //   1560: iload 8
    //   1562: istore 9
    //   1564: iload 7
    //   1566: istore_3
    //   1567: iload 14
    //   1569: istore 10
    //   1571: iload 11
    //   1573: istore 4
    //   1575: iload 8
    //   1577: istore 12
    //   1579: iload 7
    //   1581: istore 5
    //   1583: iload 14
    //   1585: istore 13
    //   1587: iload 23
    //   1589: iload_1
    //   1590: getstatic 329	com/chelpus/root/utils/corepatch:byteOrigOatUpd2	[B
    //   1593: getstatic 331	com/chelpus/root/utils/corepatch:maskOatUpd2	[B
    //   1596: getstatic 333	com/chelpus/root/utils/corepatch:byteReplaceOatUpd2	[B
    //   1599: getstatic 335	com/chelpus/root/utils/corepatch:rep_maskOatUpd2	[B
    //   1602: iload 28
    //   1604: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   1607: ifeq +225 -> 1832
    //   1610: iload 11
    //   1612: istore_2
    //   1613: iload 8
    //   1615: istore 9
    //   1617: iload 7
    //   1619: istore_3
    //   1620: iload 14
    //   1622: istore 10
    //   1624: iload 11
    //   1626: istore 4
    //   1628: iload 8
    //   1630: istore 12
    //   1632: iload 7
    //   1634: istore 5
    //   1636: iload 14
    //   1638: istore 13
    //   1640: aload_0
    //   1641: iconst_0
    //   1642: aaload
    //   1643: ldc_w 946
    //   1646: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1649: ifeq +99 -> 1748
    //   1652: iload 11
    //   1654: istore_2
    //   1655: iload 8
    //   1657: istore 9
    //   1659: iload 7
    //   1661: istore_3
    //   1662: iload 14
    //   1664: istore 10
    //   1666: iload 11
    //   1668: istore 4
    //   1670: iload 8
    //   1672: istore 12
    //   1674: iload 7
    //   1676: istore 5
    //   1678: iload 14
    //   1680: istore 13
    //   1682: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   1685: new 1031	java/lang/StringBuilder
    //   1688: dup
    //   1689: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   1692: ldc_w 1087
    //   1695: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: iload 23
    //   1700: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1703: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1706: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1709: iload 11
    //   1711: istore_2
    //   1712: iload 8
    //   1714: istore 9
    //   1716: iload 7
    //   1718: istore_3
    //   1719: iload 14
    //   1721: istore 10
    //   1723: iload 11
    //   1725: istore 4
    //   1727: iload 8
    //   1729: istore 12
    //   1731: iload 7
    //   1733: istore 5
    //   1735: iload 14
    //   1737: istore 13
    //   1739: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   1742: ldc_w 1089
    //   1745: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1748: iload 11
    //   1750: istore_2
    //   1751: iload 8
    //   1753: istore 9
    //   1755: iload 7
    //   1757: istore_3
    //   1758: iload 14
    //   1760: istore 10
    //   1762: iload 11
    //   1764: istore 4
    //   1766: iload 8
    //   1768: istore 12
    //   1770: iload 7
    //   1772: istore 5
    //   1774: iload 14
    //   1776: istore 13
    //   1778: aload_0
    //   1779: iconst_0
    //   1780: aaload
    //   1781: ldc_w 963
    //   1784: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1787: ifeq +23304 -> 25091
    //   1790: iload 11
    //   1792: istore_2
    //   1793: iload 8
    //   1795: istore 9
    //   1797: iload 7
    //   1799: istore_3
    //   1800: iload 14
    //   1802: istore 10
    //   1804: iload 11
    //   1806: istore 4
    //   1808: iload 8
    //   1810: istore 12
    //   1812: iload 7
    //   1814: istore 5
    //   1816: iload 14
    //   1818: istore 13
    //   1820: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   1823: ldc_w 1091
    //   1826: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1829: goto +23262 -> 25091
    //   1832: iload 20
    //   1834: istore 17
    //   1836: iload 11
    //   1838: istore 14
    //   1840: iload 11
    //   1842: istore_2
    //   1843: iload 8
    //   1845: istore 9
    //   1847: iload 7
    //   1849: istore_3
    //   1850: iload 6
    //   1852: istore 10
    //   1854: iload 11
    //   1856: istore 4
    //   1858: iload 8
    //   1860: istore 12
    //   1862: iload 7
    //   1864: istore 5
    //   1866: iload 6
    //   1868: istore 13
    //   1870: iload 23
    //   1872: iload_1
    //   1873: getstatic 337	com/chelpus/root/utils/corepatch:byteOrigOat1	[B
    //   1876: getstatic 339	com/chelpus/root/utils/corepatch:maskOat1	[B
    //   1879: getstatic 341	com/chelpus/root/utils/corepatch:byteReplaceOat1	[B
    //   1882: getstatic 343	com/chelpus/root/utils/corepatch:rep_maskOat1	[B
    //   1885: iload 28
    //   1887: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   1890: ifeq +225 -> 2115
    //   1893: iload 11
    //   1895: istore_2
    //   1896: iload 8
    //   1898: istore 9
    //   1900: iload 7
    //   1902: istore_3
    //   1903: iload 6
    //   1905: istore 10
    //   1907: iload 11
    //   1909: istore 4
    //   1911: iload 8
    //   1913: istore 12
    //   1915: iload 7
    //   1917: istore 5
    //   1919: iload 6
    //   1921: istore 13
    //   1923: aload_0
    //   1924: iconst_0
    //   1925: aaload
    //   1926: ldc_w 946
    //   1929: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1932: ifeq +99 -> 2031
    //   1935: iload 11
    //   1937: istore_2
    //   1938: iload 8
    //   1940: istore 9
    //   1942: iload 7
    //   1944: istore_3
    //   1945: iload 6
    //   1947: istore 10
    //   1949: iload 11
    //   1951: istore 4
    //   1953: iload 8
    //   1955: istore 12
    //   1957: iload 7
    //   1959: istore 5
    //   1961: iload 6
    //   1963: istore 13
    //   1965: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   1968: new 1031	java/lang/StringBuilder
    //   1971: dup
    //   1972: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   1975: ldc_w 1087
    //   1978: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1981: iload 23
    //   1983: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1986: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1989: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1992: iload 11
    //   1994: istore_2
    //   1995: iload 8
    //   1997: istore 9
    //   1999: iload 7
    //   2001: istore_3
    //   2002: iload 6
    //   2004: istore 10
    //   2006: iload 11
    //   2008: istore 4
    //   2010: iload 8
    //   2012: istore 12
    //   2014: iload 7
    //   2016: istore 5
    //   2018: iload 6
    //   2020: istore 13
    //   2022: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2025: ldc_w 1093
    //   2028: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2031: iload 11
    //   2033: istore_2
    //   2034: iload 8
    //   2036: istore 9
    //   2038: iload 7
    //   2040: istore_3
    //   2041: iload 6
    //   2043: istore 10
    //   2045: iload 11
    //   2047: istore 4
    //   2049: iload 8
    //   2051: istore 12
    //   2053: iload 7
    //   2055: istore 5
    //   2057: iload 6
    //   2059: istore 13
    //   2061: aload_0
    //   2062: iconst_0
    //   2063: aaload
    //   2064: ldc_w 963
    //   2067: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2070: ifeq +23036 -> 25106
    //   2073: iload 11
    //   2075: istore_2
    //   2076: iload 8
    //   2078: istore 9
    //   2080: iload 7
    //   2082: istore_3
    //   2083: iload 6
    //   2085: istore 10
    //   2087: iload 11
    //   2089: istore 4
    //   2091: iload 8
    //   2093: istore 12
    //   2095: iload 7
    //   2097: istore 5
    //   2099: iload 6
    //   2101: istore 13
    //   2103: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2106: ldc_w 1095
    //   2109: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2112: goto +22994 -> 25106
    //   2115: iload 14
    //   2117: istore 11
    //   2119: iload 14
    //   2121: istore_2
    //   2122: iload 8
    //   2124: istore 9
    //   2126: iload 7
    //   2128: istore_3
    //   2129: iload 6
    //   2131: istore 10
    //   2133: iload 14
    //   2135: istore 4
    //   2137: iload 8
    //   2139: istore 12
    //   2141: iload 7
    //   2143: istore 5
    //   2145: iload 6
    //   2147: istore 13
    //   2149: iload 23
    //   2151: iload_1
    //   2152: getstatic 369	com/chelpus/root/utils/corepatch:byteOrigOatUpd4	[B
    //   2155: getstatic 371	com/chelpus/root/utils/corepatch:maskOatUpd4	[B
    //   2158: getstatic 373	com/chelpus/root/utils/corepatch:byteReplaceOatUpd4	[B
    //   2161: getstatic 375	com/chelpus/root/utils/corepatch:rep_maskOatUpd4	[B
    //   2164: iload 28
    //   2166: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   2169: ifeq +225 -> 2394
    //   2172: iload 14
    //   2174: istore_2
    //   2175: iload 8
    //   2177: istore 9
    //   2179: iload 7
    //   2181: istore_3
    //   2182: iload 6
    //   2184: istore 10
    //   2186: iload 14
    //   2188: istore 4
    //   2190: iload 8
    //   2192: istore 12
    //   2194: iload 7
    //   2196: istore 5
    //   2198: iload 6
    //   2200: istore 13
    //   2202: aload_0
    //   2203: iconst_0
    //   2204: aaload
    //   2205: ldc_w 946
    //   2208: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2211: ifeq +99 -> 2310
    //   2214: iload 14
    //   2216: istore_2
    //   2217: iload 8
    //   2219: istore 9
    //   2221: iload 7
    //   2223: istore_3
    //   2224: iload 6
    //   2226: istore 10
    //   2228: iload 14
    //   2230: istore 4
    //   2232: iload 8
    //   2234: istore 12
    //   2236: iload 7
    //   2238: istore 5
    //   2240: iload 6
    //   2242: istore 13
    //   2244: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2247: new 1031	java/lang/StringBuilder
    //   2250: dup
    //   2251: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   2254: ldc_w 1087
    //   2257: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2260: iload 23
    //   2262: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2265: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2268: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2271: iload 14
    //   2273: istore_2
    //   2274: iload 8
    //   2276: istore 9
    //   2278: iload 7
    //   2280: istore_3
    //   2281: iload 6
    //   2283: istore 10
    //   2285: iload 14
    //   2287: istore 4
    //   2289: iload 8
    //   2291: istore 12
    //   2293: iload 7
    //   2295: istore 5
    //   2297: iload 6
    //   2299: istore 13
    //   2301: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2304: ldc_w 1089
    //   2307: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2310: iload 14
    //   2312: istore_2
    //   2313: iload 8
    //   2315: istore 9
    //   2317: iload 7
    //   2319: istore_3
    //   2320: iload 6
    //   2322: istore 10
    //   2324: iload 14
    //   2326: istore 4
    //   2328: iload 8
    //   2330: istore 12
    //   2332: iload 7
    //   2334: istore 5
    //   2336: iload 6
    //   2338: istore 13
    //   2340: aload_0
    //   2341: iconst_0
    //   2342: aaload
    //   2343: ldc_w 963
    //   2346: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2349: ifeq +22766 -> 25115
    //   2352: iload 14
    //   2354: istore_2
    //   2355: iload 8
    //   2357: istore 9
    //   2359: iload 7
    //   2361: istore_3
    //   2362: iload 6
    //   2364: istore 10
    //   2366: iload 14
    //   2368: istore 4
    //   2370: iload 8
    //   2372: istore 12
    //   2374: iload 7
    //   2376: istore 5
    //   2378: iload 6
    //   2380: istore 13
    //   2382: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2385: ldc_w 1091
    //   2388: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2391: goto +22724 -> 25115
    //   2394: iload 11
    //   2396: istore 14
    //   2398: iload 11
    //   2400: istore_2
    //   2401: iload 8
    //   2403: istore 9
    //   2405: iload 7
    //   2407: istore_3
    //   2408: iload 6
    //   2410: istore 10
    //   2412: iload 11
    //   2414: istore 4
    //   2416: iload 8
    //   2418: istore 12
    //   2420: iload 7
    //   2422: istore 5
    //   2424: iload 6
    //   2426: istore 13
    //   2428: iload 23
    //   2430: iload_1
    //   2431: getstatic 377	com/chelpus/root/utils/corepatch:byteOrigOatUpd4_1	[B
    //   2434: getstatic 379	com/chelpus/root/utils/corepatch:maskOatUpd4_1	[B
    //   2437: getstatic 381	com/chelpus/root/utils/corepatch:byteReplaceOatUpd4_1	[B
    //   2440: getstatic 383	com/chelpus/root/utils/corepatch:rep_maskOatUpd4_1	[B
    //   2443: iload 28
    //   2445: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   2448: ifeq +225 -> 2673
    //   2451: iload 11
    //   2453: istore_2
    //   2454: iload 8
    //   2456: istore 9
    //   2458: iload 7
    //   2460: istore_3
    //   2461: iload 6
    //   2463: istore 10
    //   2465: iload 11
    //   2467: istore 4
    //   2469: iload 8
    //   2471: istore 12
    //   2473: iload 7
    //   2475: istore 5
    //   2477: iload 6
    //   2479: istore 13
    //   2481: aload_0
    //   2482: iconst_0
    //   2483: aaload
    //   2484: ldc_w 946
    //   2487: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2490: ifeq +99 -> 2589
    //   2493: iload 11
    //   2495: istore_2
    //   2496: iload 8
    //   2498: istore 9
    //   2500: iload 7
    //   2502: istore_3
    //   2503: iload 6
    //   2505: istore 10
    //   2507: iload 11
    //   2509: istore 4
    //   2511: iload 8
    //   2513: istore 12
    //   2515: iload 7
    //   2517: istore 5
    //   2519: iload 6
    //   2521: istore 13
    //   2523: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2526: new 1031	java/lang/StringBuilder
    //   2529: dup
    //   2530: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   2533: ldc_w 1087
    //   2536: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2539: iload 23
    //   2541: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2544: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2547: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2550: iload 11
    //   2552: istore_2
    //   2553: iload 8
    //   2555: istore 9
    //   2557: iload 7
    //   2559: istore_3
    //   2560: iload 6
    //   2562: istore 10
    //   2564: iload 11
    //   2566: istore 4
    //   2568: iload 8
    //   2570: istore 12
    //   2572: iload 7
    //   2574: istore 5
    //   2576: iload 6
    //   2578: istore 13
    //   2580: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2583: ldc_w 1089
    //   2586: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2589: iload 11
    //   2591: istore_2
    //   2592: iload 8
    //   2594: istore 9
    //   2596: iload 7
    //   2598: istore_3
    //   2599: iload 6
    //   2601: istore 10
    //   2603: iload 11
    //   2605: istore 4
    //   2607: iload 8
    //   2609: istore 12
    //   2611: iload 7
    //   2613: istore 5
    //   2615: iload 6
    //   2617: istore 13
    //   2619: aload_0
    //   2620: iconst_0
    //   2621: aaload
    //   2622: ldc_w 963
    //   2625: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2628: ifeq +22502 -> 25130
    //   2631: iload 11
    //   2633: istore_2
    //   2634: iload 8
    //   2636: istore 9
    //   2638: iload 7
    //   2640: istore_3
    //   2641: iload 6
    //   2643: istore 10
    //   2645: iload 11
    //   2647: istore 4
    //   2649: iload 8
    //   2651: istore 12
    //   2653: iload 7
    //   2655: istore 5
    //   2657: iload 6
    //   2659: istore 13
    //   2661: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2664: ldc_w 1091
    //   2667: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2670: goto +22460 -> 25130
    //   2673: iload 14
    //   2675: istore 11
    //   2677: iload 14
    //   2679: istore_2
    //   2680: iload 8
    //   2682: istore 9
    //   2684: iload 7
    //   2686: istore_3
    //   2687: iload 6
    //   2689: istore 10
    //   2691: iload 14
    //   2693: istore 4
    //   2695: iload 8
    //   2697: istore 12
    //   2699: iload 7
    //   2701: istore 5
    //   2703: iload 6
    //   2705: istore 13
    //   2707: iload 23
    //   2709: iload_1
    //   2710: getstatic 385	com/chelpus/root/utils/corepatch:byteOrigOatUpd5	[B
    //   2713: getstatic 387	com/chelpus/root/utils/corepatch:maskOatUpd5	[B
    //   2716: getstatic 389	com/chelpus/root/utils/corepatch:byteReplaceOatUpd5	[B
    //   2719: getstatic 391	com/chelpus/root/utils/corepatch:rep_maskOatUpd5	[B
    //   2722: iload 28
    //   2724: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   2727: ifeq +225 -> 2952
    //   2730: iload 14
    //   2732: istore_2
    //   2733: iload 8
    //   2735: istore 9
    //   2737: iload 7
    //   2739: istore_3
    //   2740: iload 6
    //   2742: istore 10
    //   2744: iload 14
    //   2746: istore 4
    //   2748: iload 8
    //   2750: istore 12
    //   2752: iload 7
    //   2754: istore 5
    //   2756: iload 6
    //   2758: istore 13
    //   2760: aload_0
    //   2761: iconst_0
    //   2762: aaload
    //   2763: ldc_w 946
    //   2766: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2769: ifeq +99 -> 2868
    //   2772: iload 14
    //   2774: istore_2
    //   2775: iload 8
    //   2777: istore 9
    //   2779: iload 7
    //   2781: istore_3
    //   2782: iload 6
    //   2784: istore 10
    //   2786: iload 14
    //   2788: istore 4
    //   2790: iload 8
    //   2792: istore 12
    //   2794: iload 7
    //   2796: istore 5
    //   2798: iload 6
    //   2800: istore 13
    //   2802: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2805: new 1031	java/lang/StringBuilder
    //   2808: dup
    //   2809: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   2812: ldc_w 1087
    //   2815: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2818: iload 23
    //   2820: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2823: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2826: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2829: iload 14
    //   2831: istore_2
    //   2832: iload 8
    //   2834: istore 9
    //   2836: iload 7
    //   2838: istore_3
    //   2839: iload 6
    //   2841: istore 10
    //   2843: iload 14
    //   2845: istore 4
    //   2847: iload 8
    //   2849: istore 12
    //   2851: iload 7
    //   2853: istore 5
    //   2855: iload 6
    //   2857: istore 13
    //   2859: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2862: ldc_w 1089
    //   2865: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2868: iload 14
    //   2870: istore_2
    //   2871: iload 8
    //   2873: istore 9
    //   2875: iload 7
    //   2877: istore_3
    //   2878: iload 6
    //   2880: istore 10
    //   2882: iload 14
    //   2884: istore 4
    //   2886: iload 8
    //   2888: istore 12
    //   2890: iload 7
    //   2892: istore 5
    //   2894: iload 6
    //   2896: istore 13
    //   2898: aload_0
    //   2899: iconst_0
    //   2900: aaload
    //   2901: ldc_w 963
    //   2904: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2907: ifeq +22238 -> 25145
    //   2910: iload 14
    //   2912: istore_2
    //   2913: iload 8
    //   2915: istore 9
    //   2917: iload 7
    //   2919: istore_3
    //   2920: iload 6
    //   2922: istore 10
    //   2924: iload 14
    //   2926: istore 4
    //   2928: iload 8
    //   2930: istore 12
    //   2932: iload 7
    //   2934: istore 5
    //   2936: iload 6
    //   2938: istore 13
    //   2940: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   2943: ldc_w 1091
    //   2946: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   2949: goto +22196 -> 25145
    //   2952: iload 11
    //   2954: istore 14
    //   2956: iload 16
    //   2958: istore 19
    //   2960: iload 11
    //   2962: istore_2
    //   2963: iload 8
    //   2965: istore 9
    //   2967: iload 7
    //   2969: istore_3
    //   2970: iload 6
    //   2972: istore 10
    //   2974: iload 11
    //   2976: istore 4
    //   2978: iload 8
    //   2980: istore 12
    //   2982: iload 7
    //   2984: istore 5
    //   2986: iload 6
    //   2988: istore 13
    //   2990: iload 23
    //   2992: iload_1
    //   2993: getstatic 393	com/chelpus/root/utils/corepatch:byteOrigOatUpd5_1	[B
    //   2996: getstatic 395	com/chelpus/root/utils/corepatch:maskOatUpd5_1	[B
    //   2999: getstatic 397	com/chelpus/root/utils/corepatch:byteReplaceOatUpd5_1	[B
    //   3002: getstatic 399	com/chelpus/root/utils/corepatch:rep_maskOatUpd5_1	[B
    //   3005: iload 28
    //   3007: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   3010: ifeq +225 -> 3235
    //   3013: iload 11
    //   3015: istore_2
    //   3016: iload 8
    //   3018: istore 9
    //   3020: iload 7
    //   3022: istore_3
    //   3023: iload 6
    //   3025: istore 10
    //   3027: iload 11
    //   3029: istore 4
    //   3031: iload 8
    //   3033: istore 12
    //   3035: iload 7
    //   3037: istore 5
    //   3039: iload 6
    //   3041: istore 13
    //   3043: aload_0
    //   3044: iconst_0
    //   3045: aaload
    //   3046: ldc_w 946
    //   3049: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3052: ifeq +99 -> 3151
    //   3055: iload 11
    //   3057: istore_2
    //   3058: iload 8
    //   3060: istore 9
    //   3062: iload 7
    //   3064: istore_3
    //   3065: iload 6
    //   3067: istore 10
    //   3069: iload 11
    //   3071: istore 4
    //   3073: iload 8
    //   3075: istore 12
    //   3077: iload 7
    //   3079: istore 5
    //   3081: iload 6
    //   3083: istore 13
    //   3085: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3088: new 1031	java/lang/StringBuilder
    //   3091: dup
    //   3092: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   3095: ldc_w 1087
    //   3098: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3101: iload 23
    //   3103: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3106: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3109: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3112: iload 11
    //   3114: istore_2
    //   3115: iload 8
    //   3117: istore 9
    //   3119: iload 7
    //   3121: istore_3
    //   3122: iload 6
    //   3124: istore 10
    //   3126: iload 11
    //   3128: istore 4
    //   3130: iload 8
    //   3132: istore 12
    //   3134: iload 7
    //   3136: istore 5
    //   3138: iload 6
    //   3140: istore 13
    //   3142: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3145: ldc_w 1089
    //   3148: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3151: iload 11
    //   3153: istore_2
    //   3154: iload 8
    //   3156: istore 9
    //   3158: iload 7
    //   3160: istore_3
    //   3161: iload 6
    //   3163: istore 10
    //   3165: iload 11
    //   3167: istore 4
    //   3169: iload 8
    //   3171: istore 12
    //   3173: iload 7
    //   3175: istore 5
    //   3177: iload 6
    //   3179: istore 13
    //   3181: aload_0
    //   3182: iconst_0
    //   3183: aaload
    //   3184: ldc_w 963
    //   3187: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3190: ifeq +21970 -> 25160
    //   3193: iload 11
    //   3195: istore_2
    //   3196: iload 8
    //   3198: istore 9
    //   3200: iload 7
    //   3202: istore_3
    //   3203: iload 6
    //   3205: istore 10
    //   3207: iload 11
    //   3209: istore 4
    //   3211: iload 8
    //   3213: istore 12
    //   3215: iload 7
    //   3217: istore 5
    //   3219: iload 6
    //   3221: istore 13
    //   3223: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3226: ldc_w 1091
    //   3229: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3232: goto +21928 -> 25160
    //   3235: iload 17
    //   3237: istore 20
    //   3239: iload 14
    //   3241: istore 11
    //   3243: iload 14
    //   3245: istore_2
    //   3246: iload 8
    //   3248: istore 9
    //   3250: iload 7
    //   3252: istore_3
    //   3253: iload 6
    //   3255: istore 10
    //   3257: iload 14
    //   3259: istore 4
    //   3261: iload 8
    //   3263: istore 12
    //   3265: iload 7
    //   3267: istore 5
    //   3269: iload 6
    //   3271: istore 13
    //   3273: iload 23
    //   3275: iload_1
    //   3276: getstatic 401	com/chelpus/root/utils/corepatch:byteOrigOat4	[B
    //   3279: getstatic 403	com/chelpus/root/utils/corepatch:maskOat4	[B
    //   3282: getstatic 405	com/chelpus/root/utils/corepatch:byteReplaceOat4	[B
    //   3285: getstatic 407	com/chelpus/root/utils/corepatch:rep_maskOat4	[B
    //   3288: iload 28
    //   3290: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   3293: ifeq +225 -> 3518
    //   3296: iload 14
    //   3298: istore_2
    //   3299: iload 8
    //   3301: istore 9
    //   3303: iload 7
    //   3305: istore_3
    //   3306: iload 6
    //   3308: istore 10
    //   3310: iload 14
    //   3312: istore 4
    //   3314: iload 8
    //   3316: istore 12
    //   3318: iload 7
    //   3320: istore 5
    //   3322: iload 6
    //   3324: istore 13
    //   3326: aload_0
    //   3327: iconst_0
    //   3328: aaload
    //   3329: ldc_w 946
    //   3332: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3335: ifeq +99 -> 3434
    //   3338: iload 14
    //   3340: istore_2
    //   3341: iload 8
    //   3343: istore 9
    //   3345: iload 7
    //   3347: istore_3
    //   3348: iload 6
    //   3350: istore 10
    //   3352: iload 14
    //   3354: istore 4
    //   3356: iload 8
    //   3358: istore 12
    //   3360: iload 7
    //   3362: istore 5
    //   3364: iload 6
    //   3366: istore 13
    //   3368: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3371: new 1031	java/lang/StringBuilder
    //   3374: dup
    //   3375: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   3378: ldc_w 1087
    //   3381: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3384: iload 23
    //   3386: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3389: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3392: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3395: iload 14
    //   3397: istore_2
    //   3398: iload 8
    //   3400: istore 9
    //   3402: iload 7
    //   3404: istore_3
    //   3405: iload 6
    //   3407: istore 10
    //   3409: iload 14
    //   3411: istore 4
    //   3413: iload 8
    //   3415: istore 12
    //   3417: iload 7
    //   3419: istore 5
    //   3421: iload 6
    //   3423: istore 13
    //   3425: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3428: ldc_w 1093
    //   3431: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3434: iload 14
    //   3436: istore_2
    //   3437: iload 8
    //   3439: istore 9
    //   3441: iload 7
    //   3443: istore_3
    //   3444: iload 6
    //   3446: istore 10
    //   3448: iload 14
    //   3450: istore 4
    //   3452: iload 8
    //   3454: istore 12
    //   3456: iload 7
    //   3458: istore 5
    //   3460: iload 6
    //   3462: istore 13
    //   3464: aload_0
    //   3465: iconst_0
    //   3466: aaload
    //   3467: ldc_w 963
    //   3470: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3473: ifeq +21702 -> 25175
    //   3476: iload 14
    //   3478: istore_2
    //   3479: iload 8
    //   3481: istore 9
    //   3483: iload 7
    //   3485: istore_3
    //   3486: iload 6
    //   3488: istore 10
    //   3490: iload 14
    //   3492: istore 4
    //   3494: iload 8
    //   3496: istore 12
    //   3498: iload 7
    //   3500: istore 5
    //   3502: iload 6
    //   3504: istore 13
    //   3506: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3509: ldc_w 1095
    //   3512: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3515: goto +21660 -> 25175
    //   3518: iload 8
    //   3520: istore 14
    //   3522: iload 11
    //   3524: istore_2
    //   3525: iload 8
    //   3527: istore 9
    //   3529: iload 7
    //   3531: istore_3
    //   3532: iload 6
    //   3534: istore 10
    //   3536: iload 11
    //   3538: istore 4
    //   3540: iload 8
    //   3542: istore 12
    //   3544: iload 7
    //   3546: istore 5
    //   3548: iload 6
    //   3550: istore 13
    //   3552: iload 23
    //   3554: iload_1
    //   3555: getstatic 345	com/chelpus/root/utils/corepatch:byteOrigOat2	[B
    //   3558: getstatic 347	com/chelpus/root/utils/corepatch:maskOat2	[B
    //   3561: getstatic 349	com/chelpus/root/utils/corepatch:byteReplaceOat2	[B
    //   3564: getstatic 351	com/chelpus/root/utils/corepatch:rep_maskOat2	[B
    //   3567: iload 28
    //   3569: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   3572: ifeq +225 -> 3797
    //   3575: iload 11
    //   3577: istore_2
    //   3578: iload 8
    //   3580: istore 9
    //   3582: iload 7
    //   3584: istore_3
    //   3585: iload 6
    //   3587: istore 10
    //   3589: iload 11
    //   3591: istore 4
    //   3593: iload 8
    //   3595: istore 12
    //   3597: iload 7
    //   3599: istore 5
    //   3601: iload 6
    //   3603: istore 13
    //   3605: aload_0
    //   3606: iconst_0
    //   3607: aaload
    //   3608: ldc_w 946
    //   3611: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3614: ifeq +99 -> 3713
    //   3617: iload 11
    //   3619: istore_2
    //   3620: iload 8
    //   3622: istore 9
    //   3624: iload 7
    //   3626: istore_3
    //   3627: iload 6
    //   3629: istore 10
    //   3631: iload 11
    //   3633: istore 4
    //   3635: iload 8
    //   3637: istore 12
    //   3639: iload 7
    //   3641: istore 5
    //   3643: iload 6
    //   3645: istore 13
    //   3647: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3650: ldc_w 1097
    //   3653: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3656: iload 11
    //   3658: istore_2
    //   3659: iload 8
    //   3661: istore 9
    //   3663: iload 7
    //   3665: istore_3
    //   3666: iload 6
    //   3668: istore 10
    //   3670: iload 11
    //   3672: istore 4
    //   3674: iload 8
    //   3676: istore 12
    //   3678: iload 7
    //   3680: istore 5
    //   3682: iload 6
    //   3684: istore 13
    //   3686: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3689: new 1031	java/lang/StringBuilder
    //   3692: dup
    //   3693: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   3696: ldc_w 1087
    //   3699: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3702: iload 23
    //   3704: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3707: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3710: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3713: iload 11
    //   3715: istore_2
    //   3716: iload 8
    //   3718: istore 9
    //   3720: iload 7
    //   3722: istore_3
    //   3723: iload 6
    //   3725: istore 10
    //   3727: iload 11
    //   3729: istore 4
    //   3731: iload 8
    //   3733: istore 12
    //   3735: iload 7
    //   3737: istore 5
    //   3739: iload 6
    //   3741: istore 13
    //   3743: aload_0
    //   3744: iconst_0
    //   3745: aaload
    //   3746: ldc_w 963
    //   3749: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3752: ifeq +21432 -> 25184
    //   3755: iload 11
    //   3757: istore_2
    //   3758: iload 8
    //   3760: istore 9
    //   3762: iload 7
    //   3764: istore_3
    //   3765: iload 6
    //   3767: istore 10
    //   3769: iload 11
    //   3771: istore 4
    //   3773: iload 8
    //   3775: istore 12
    //   3777: iload 7
    //   3779: istore 5
    //   3781: iload 6
    //   3783: istore 13
    //   3785: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3788: ldc_w 1099
    //   3791: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3794: goto +21390 -> 25184
    //   3797: iload 15
    //   3799: istore 21
    //   3801: iload 14
    //   3803: istore 8
    //   3805: iload 11
    //   3807: istore_2
    //   3808: iload 14
    //   3810: istore 9
    //   3812: iload 7
    //   3814: istore_3
    //   3815: iload 6
    //   3817: istore 10
    //   3819: iload 11
    //   3821: istore 4
    //   3823: iload 14
    //   3825: istore 12
    //   3827: iload 7
    //   3829: istore 5
    //   3831: iload 6
    //   3833: istore 13
    //   3835: iload 23
    //   3837: iload_1
    //   3838: getstatic 409	com/chelpus/root/utils/corepatch:byteOrigOat5	[B
    //   3841: getstatic 411	com/chelpus/root/utils/corepatch:maskOat5	[B
    //   3844: getstatic 413	com/chelpus/root/utils/corepatch:byteReplaceOat5	[B
    //   3847: getstatic 415	com/chelpus/root/utils/corepatch:rep_maskOat5	[B
    //   3850: iload 28
    //   3852: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   3855: ifeq +225 -> 4080
    //   3858: iload 11
    //   3860: istore_2
    //   3861: iload 14
    //   3863: istore 9
    //   3865: iload 7
    //   3867: istore_3
    //   3868: iload 6
    //   3870: istore 10
    //   3872: iload 11
    //   3874: istore 4
    //   3876: iload 14
    //   3878: istore 12
    //   3880: iload 7
    //   3882: istore 5
    //   3884: iload 6
    //   3886: istore 13
    //   3888: aload_0
    //   3889: iconst_0
    //   3890: aaload
    //   3891: ldc_w 946
    //   3894: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3897: ifeq +99 -> 3996
    //   3900: iload 11
    //   3902: istore_2
    //   3903: iload 14
    //   3905: istore 9
    //   3907: iload 7
    //   3909: istore_3
    //   3910: iload 6
    //   3912: istore 10
    //   3914: iload 11
    //   3916: istore 4
    //   3918: iload 14
    //   3920: istore 12
    //   3922: iload 7
    //   3924: istore 5
    //   3926: iload 6
    //   3928: istore 13
    //   3930: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3933: ldc_w 1097
    //   3936: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3939: iload 11
    //   3941: istore_2
    //   3942: iload 14
    //   3944: istore 9
    //   3946: iload 7
    //   3948: istore_3
    //   3949: iload 6
    //   3951: istore 10
    //   3953: iload 11
    //   3955: istore 4
    //   3957: iload 14
    //   3959: istore 12
    //   3961: iload 7
    //   3963: istore 5
    //   3965: iload 6
    //   3967: istore 13
    //   3969: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   3972: new 1031	java/lang/StringBuilder
    //   3975: dup
    //   3976: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   3979: ldc_w 1087
    //   3982: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3985: iload 23
    //   3987: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3990: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3993: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   3996: iload 11
    //   3998: istore_2
    //   3999: iload 14
    //   4001: istore 9
    //   4003: iload 7
    //   4005: istore_3
    //   4006: iload 6
    //   4008: istore 10
    //   4010: iload 11
    //   4012: istore 4
    //   4014: iload 14
    //   4016: istore 12
    //   4018: iload 7
    //   4020: istore 5
    //   4022: iload 6
    //   4024: istore 13
    //   4026: aload_0
    //   4027: iconst_0
    //   4028: aaload
    //   4029: ldc_w 963
    //   4032: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4035: ifeq +21158 -> 25193
    //   4038: iload 11
    //   4040: istore_2
    //   4041: iload 14
    //   4043: istore 9
    //   4045: iload 7
    //   4047: istore_3
    //   4048: iload 6
    //   4050: istore 10
    //   4052: iload 11
    //   4054: istore 4
    //   4056: iload 14
    //   4058: istore 12
    //   4060: iload 7
    //   4062: istore 5
    //   4064: iload 6
    //   4066: istore 13
    //   4068: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   4071: ldc_w 1099
    //   4074: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4077: goto +21116 -> 25193
    //   4080: iload 7
    //   4082: istore 14
    //   4084: iload 11
    //   4086: istore_2
    //   4087: iload 8
    //   4089: istore 9
    //   4091: iload 7
    //   4093: istore_3
    //   4094: iload 6
    //   4096: istore 10
    //   4098: iload 11
    //   4100: istore 4
    //   4102: iload 8
    //   4104: istore 12
    //   4106: iload 7
    //   4108: istore 5
    //   4110: iload 6
    //   4112: istore 13
    //   4114: iload 23
    //   4116: iload_1
    //   4117: getstatic 353	com/chelpus/root/utils/corepatch:byteOrigOat3	[B
    //   4120: getstatic 355	com/chelpus/root/utils/corepatch:maskOat3	[B
    //   4123: getstatic 357	com/chelpus/root/utils/corepatch:byteReplaceOat3	[B
    //   4126: getstatic 359	com/chelpus/root/utils/corepatch:rep_maskOat3	[B
    //   4129: iload 26
    //   4131: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   4134: ifeq +225 -> 4359
    //   4137: iload 11
    //   4139: istore_2
    //   4140: iload 8
    //   4142: istore 9
    //   4144: iload 7
    //   4146: istore_3
    //   4147: iload 6
    //   4149: istore 10
    //   4151: iload 11
    //   4153: istore 4
    //   4155: iload 8
    //   4157: istore 12
    //   4159: iload 7
    //   4161: istore 5
    //   4163: iload 6
    //   4165: istore 13
    //   4167: aload_0
    //   4168: iconst_0
    //   4169: aaload
    //   4170: ldc_w 946
    //   4173: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4176: ifeq +99 -> 4275
    //   4179: iload 11
    //   4181: istore_2
    //   4182: iload 8
    //   4184: istore 9
    //   4186: iload 7
    //   4188: istore_3
    //   4189: iload 6
    //   4191: istore 10
    //   4193: iload 11
    //   4195: istore 4
    //   4197: iload 8
    //   4199: istore 12
    //   4201: iload 7
    //   4203: istore 5
    //   4205: iload 6
    //   4207: istore 13
    //   4209: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   4212: ldc_w 1101
    //   4215: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4218: iload 11
    //   4220: istore_2
    //   4221: iload 8
    //   4223: istore 9
    //   4225: iload 7
    //   4227: istore_3
    //   4228: iload 6
    //   4230: istore 10
    //   4232: iload 11
    //   4234: istore 4
    //   4236: iload 8
    //   4238: istore 12
    //   4240: iload 7
    //   4242: istore 5
    //   4244: iload 6
    //   4246: istore 13
    //   4248: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   4251: new 1031	java/lang/StringBuilder
    //   4254: dup
    //   4255: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   4258: ldc_w 1087
    //   4261: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4264: iload 23
    //   4266: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4269: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4272: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4275: iload 11
    //   4277: istore_2
    //   4278: iload 8
    //   4280: istore 9
    //   4282: iload 7
    //   4284: istore_3
    //   4285: iload 6
    //   4287: istore 10
    //   4289: iload 11
    //   4291: istore 4
    //   4293: iload 8
    //   4295: istore 12
    //   4297: iload 7
    //   4299: istore 5
    //   4301: iload 6
    //   4303: istore 13
    //   4305: aload_0
    //   4306: iconst_0
    //   4307: aaload
    //   4308: ldc_w 963
    //   4311: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4314: ifeq +20888 -> 25202
    //   4317: iload 11
    //   4319: istore_2
    //   4320: iload 8
    //   4322: istore 9
    //   4324: iload 7
    //   4326: istore_3
    //   4327: iload 6
    //   4329: istore 10
    //   4331: iload 11
    //   4333: istore 4
    //   4335: iload 8
    //   4337: istore 12
    //   4339: iload 7
    //   4341: istore 5
    //   4343: iload 6
    //   4345: istore 13
    //   4347: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   4350: ldc_w 1103
    //   4353: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4356: goto +20846 -> 25202
    //   4359: iload 14
    //   4361: istore 7
    //   4363: iload 11
    //   4365: istore_2
    //   4366: iload 8
    //   4368: istore 9
    //   4370: iload 14
    //   4372: istore_3
    //   4373: iload 6
    //   4375: istore 10
    //   4377: iload 11
    //   4379: istore 4
    //   4381: iload 8
    //   4383: istore 12
    //   4385: iload 14
    //   4387: istore 5
    //   4389: iload 6
    //   4391: istore 13
    //   4393: iload 23
    //   4395: iload_1
    //   4396: getstatic 361	com/chelpus/root/utils/corepatch:byteOrigOat6_3	[B
    //   4399: getstatic 363	com/chelpus/root/utils/corepatch:maskOat6_3	[B
    //   4402: getstatic 365	com/chelpus/root/utils/corepatch:byteReplaceOat6_3	[B
    //   4405: getstatic 367	com/chelpus/root/utils/corepatch:rep_maskOat6_3	[B
    //   4408: iload 26
    //   4410: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   4413: ifeq +225 -> 4638
    //   4416: iload 11
    //   4418: istore_2
    //   4419: iload 8
    //   4421: istore 9
    //   4423: iload 14
    //   4425: istore_3
    //   4426: iload 6
    //   4428: istore 10
    //   4430: iload 11
    //   4432: istore 4
    //   4434: iload 8
    //   4436: istore 12
    //   4438: iload 14
    //   4440: istore 5
    //   4442: iload 6
    //   4444: istore 13
    //   4446: aload_0
    //   4447: iconst_0
    //   4448: aaload
    //   4449: ldc_w 946
    //   4452: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4455: ifeq +99 -> 4554
    //   4458: iload 11
    //   4460: istore_2
    //   4461: iload 8
    //   4463: istore 9
    //   4465: iload 14
    //   4467: istore_3
    //   4468: iload 6
    //   4470: istore 10
    //   4472: iload 11
    //   4474: istore 4
    //   4476: iload 8
    //   4478: istore 12
    //   4480: iload 14
    //   4482: istore 5
    //   4484: iload 6
    //   4486: istore 13
    //   4488: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   4491: ldc_w 1101
    //   4494: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4497: iload 11
    //   4499: istore_2
    //   4500: iload 8
    //   4502: istore 9
    //   4504: iload 14
    //   4506: istore_3
    //   4507: iload 6
    //   4509: istore 10
    //   4511: iload 11
    //   4513: istore 4
    //   4515: iload 8
    //   4517: istore 12
    //   4519: iload 14
    //   4521: istore 5
    //   4523: iload 6
    //   4525: istore 13
    //   4527: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   4530: new 1031	java/lang/StringBuilder
    //   4533: dup
    //   4534: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   4537: ldc_w 1087
    //   4540: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4543: iload 23
    //   4545: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4548: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4551: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4554: iload 11
    //   4556: istore_2
    //   4557: iload 8
    //   4559: istore 9
    //   4561: iload 14
    //   4563: istore_3
    //   4564: iload 6
    //   4566: istore 10
    //   4568: iload 11
    //   4570: istore 4
    //   4572: iload 8
    //   4574: istore 12
    //   4576: iload 14
    //   4578: istore 5
    //   4580: iload 6
    //   4582: istore 13
    //   4584: aload_0
    //   4585: iconst_0
    //   4586: aaload
    //   4587: ldc_w 963
    //   4590: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4593: ifeq +20618 -> 25211
    //   4596: iload 11
    //   4598: istore_2
    //   4599: iload 8
    //   4601: istore 9
    //   4603: iload 14
    //   4605: istore_3
    //   4606: iload 6
    //   4608: istore 10
    //   4610: iload 11
    //   4612: istore 4
    //   4614: iload 8
    //   4616: istore 12
    //   4618: iload 14
    //   4620: istore 5
    //   4622: iload 6
    //   4624: istore 13
    //   4626: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   4629: ldc_w 1103
    //   4632: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4635: goto +20576 -> 25211
    //   4638: iload 7
    //   4640: istore 14
    //   4642: iload 11
    //   4644: istore_2
    //   4645: iload 8
    //   4647: istore 9
    //   4649: iload 7
    //   4651: istore_3
    //   4652: iload 6
    //   4654: istore 10
    //   4656: iload 11
    //   4658: istore 4
    //   4660: iload 8
    //   4662: istore 12
    //   4664: iload 7
    //   4666: istore 5
    //   4668: iload 6
    //   4670: istore 13
    //   4672: iload 23
    //   4674: iload_1
    //   4675: getstatic 417	com/chelpus/root/utils/corepatch:byteOrigOat6	[B
    //   4678: getstatic 419	com/chelpus/root/utils/corepatch:maskOat6	[B
    //   4681: getstatic 421	com/chelpus/root/utils/corepatch:byteReplaceOat6	[B
    //   4684: getstatic 423	com/chelpus/root/utils/corepatch:rep_maskOat6	[B
    //   4687: iload 26
    //   4689: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   4692: ifeq +225 -> 4917
    //   4695: iload 11
    //   4697: istore_2
    //   4698: iload 8
    //   4700: istore 9
    //   4702: iload 7
    //   4704: istore_3
    //   4705: iload 6
    //   4707: istore 10
    //   4709: iload 11
    //   4711: istore 4
    //   4713: iload 8
    //   4715: istore 12
    //   4717: iload 7
    //   4719: istore 5
    //   4721: iload 6
    //   4723: istore 13
    //   4725: aload_0
    //   4726: iconst_0
    //   4727: aaload
    //   4728: ldc_w 946
    //   4731: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4734: ifeq +99 -> 4833
    //   4737: iload 11
    //   4739: istore_2
    //   4740: iload 8
    //   4742: istore 9
    //   4744: iload 7
    //   4746: istore_3
    //   4747: iload 6
    //   4749: istore 10
    //   4751: iload 11
    //   4753: istore 4
    //   4755: iload 8
    //   4757: istore 12
    //   4759: iload 7
    //   4761: istore 5
    //   4763: iload 6
    //   4765: istore 13
    //   4767: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   4770: ldc_w 1101
    //   4773: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4776: iload 11
    //   4778: istore_2
    //   4779: iload 8
    //   4781: istore 9
    //   4783: iload 7
    //   4785: istore_3
    //   4786: iload 6
    //   4788: istore 10
    //   4790: iload 11
    //   4792: istore 4
    //   4794: iload 8
    //   4796: istore 12
    //   4798: iload 7
    //   4800: istore 5
    //   4802: iload 6
    //   4804: istore 13
    //   4806: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   4809: new 1031	java/lang/StringBuilder
    //   4812: dup
    //   4813: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   4816: ldc_w 1087
    //   4819: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4822: iload 23
    //   4824: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4827: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4830: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4833: iload 11
    //   4835: istore_2
    //   4836: iload 8
    //   4838: istore 9
    //   4840: iload 7
    //   4842: istore_3
    //   4843: iload 6
    //   4845: istore 10
    //   4847: iload 11
    //   4849: istore 4
    //   4851: iload 8
    //   4853: istore 12
    //   4855: iload 7
    //   4857: istore 5
    //   4859: iload 6
    //   4861: istore 13
    //   4863: aload_0
    //   4864: iconst_0
    //   4865: aaload
    //   4866: ldc_w 963
    //   4869: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4872: ifeq +20348 -> 25220
    //   4875: iload 11
    //   4877: istore_2
    //   4878: iload 8
    //   4880: istore 9
    //   4882: iload 7
    //   4884: istore_3
    //   4885: iload 6
    //   4887: istore 10
    //   4889: iload 11
    //   4891: istore 4
    //   4893: iload 8
    //   4895: istore 12
    //   4897: iload 7
    //   4899: istore 5
    //   4901: iload 6
    //   4903: istore 13
    //   4905: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   4908: ldc_w 1103
    //   4911: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   4914: goto +20306 -> 25220
    //   4917: iload 14
    //   4919: istore 7
    //   4921: iload 11
    //   4923: istore_2
    //   4924: iload 8
    //   4926: istore 9
    //   4928: iload 14
    //   4930: istore_3
    //   4931: iload 6
    //   4933: istore 10
    //   4935: iload 11
    //   4937: istore 4
    //   4939: iload 8
    //   4941: istore 12
    //   4943: iload 14
    //   4945: istore 5
    //   4947: iload 6
    //   4949: istore 13
    //   4951: iload 23
    //   4953: iload_1
    //   4954: getstatic 425	com/chelpus/root/utils/corepatch:byteOrigOat6_1	[B
    //   4957: getstatic 427	com/chelpus/root/utils/corepatch:maskOat6_1	[B
    //   4960: getstatic 429	com/chelpus/root/utils/corepatch:byteReplaceOat6_1	[B
    //   4963: getstatic 431	com/chelpus/root/utils/corepatch:rep_maskOat6_1	[B
    //   4966: iload 26
    //   4968: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   4971: ifeq +225 -> 5196
    //   4974: iload 11
    //   4976: istore_2
    //   4977: iload 8
    //   4979: istore 9
    //   4981: iload 14
    //   4983: istore_3
    //   4984: iload 6
    //   4986: istore 10
    //   4988: iload 11
    //   4990: istore 4
    //   4992: iload 8
    //   4994: istore 12
    //   4996: iload 14
    //   4998: istore 5
    //   5000: iload 6
    //   5002: istore 13
    //   5004: aload_0
    //   5005: iconst_0
    //   5006: aaload
    //   5007: ldc_w 946
    //   5010: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5013: ifeq +99 -> 5112
    //   5016: iload 11
    //   5018: istore_2
    //   5019: iload 8
    //   5021: istore 9
    //   5023: iload 14
    //   5025: istore_3
    //   5026: iload 6
    //   5028: istore 10
    //   5030: iload 11
    //   5032: istore 4
    //   5034: iload 8
    //   5036: istore 12
    //   5038: iload 14
    //   5040: istore 5
    //   5042: iload 6
    //   5044: istore 13
    //   5046: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   5049: ldc_w 1101
    //   5052: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5055: iload 11
    //   5057: istore_2
    //   5058: iload 8
    //   5060: istore 9
    //   5062: iload 14
    //   5064: istore_3
    //   5065: iload 6
    //   5067: istore 10
    //   5069: iload 11
    //   5071: istore 4
    //   5073: iload 8
    //   5075: istore 12
    //   5077: iload 14
    //   5079: istore 5
    //   5081: iload 6
    //   5083: istore 13
    //   5085: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   5088: new 1031	java/lang/StringBuilder
    //   5091: dup
    //   5092: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   5095: ldc_w 1087
    //   5098: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5101: iload 23
    //   5103: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5106: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5109: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5112: iload 11
    //   5114: istore_2
    //   5115: iload 8
    //   5117: istore 9
    //   5119: iload 14
    //   5121: istore_3
    //   5122: iload 6
    //   5124: istore 10
    //   5126: iload 11
    //   5128: istore 4
    //   5130: iload 8
    //   5132: istore 12
    //   5134: iload 14
    //   5136: istore 5
    //   5138: iload 6
    //   5140: istore 13
    //   5142: aload_0
    //   5143: iconst_0
    //   5144: aaload
    //   5145: ldc_w 963
    //   5148: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5151: ifeq +20078 -> 25229
    //   5154: iload 11
    //   5156: istore_2
    //   5157: iload 8
    //   5159: istore 9
    //   5161: iload 14
    //   5163: istore_3
    //   5164: iload 6
    //   5166: istore 10
    //   5168: iload 11
    //   5170: istore 4
    //   5172: iload 8
    //   5174: istore 12
    //   5176: iload 14
    //   5178: istore 5
    //   5180: iload 6
    //   5182: istore 13
    //   5184: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   5187: ldc_w 1103
    //   5190: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5193: goto +20036 -> 25229
    //   5196: iload 7
    //   5198: istore 14
    //   5200: iload 11
    //   5202: istore_2
    //   5203: iload 8
    //   5205: istore 9
    //   5207: iload 7
    //   5209: istore_3
    //   5210: iload 6
    //   5212: istore 10
    //   5214: iload 11
    //   5216: istore 4
    //   5218: iload 8
    //   5220: istore 12
    //   5222: iload 7
    //   5224: istore 5
    //   5226: iload 6
    //   5228: istore 13
    //   5230: iload 23
    //   5232: iload_1
    //   5233: getstatic 433	com/chelpus/root/utils/corepatch:byteOrigOat7	[B
    //   5236: getstatic 435	com/chelpus/root/utils/corepatch:maskOat7	[B
    //   5239: getstatic 437	com/chelpus/root/utils/corepatch:byteReplaceOat7	[B
    //   5242: getstatic 439	com/chelpus/root/utils/corepatch:rep_maskOat7	[B
    //   5245: iload 26
    //   5247: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   5250: ifeq +225 -> 5475
    //   5253: iload 11
    //   5255: istore_2
    //   5256: iload 8
    //   5258: istore 9
    //   5260: iload 7
    //   5262: istore_3
    //   5263: iload 6
    //   5265: istore 10
    //   5267: iload 11
    //   5269: istore 4
    //   5271: iload 8
    //   5273: istore 12
    //   5275: iload 7
    //   5277: istore 5
    //   5279: iload 6
    //   5281: istore 13
    //   5283: aload_0
    //   5284: iconst_0
    //   5285: aaload
    //   5286: ldc_w 946
    //   5289: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5292: ifeq +99 -> 5391
    //   5295: iload 11
    //   5297: istore_2
    //   5298: iload 8
    //   5300: istore 9
    //   5302: iload 7
    //   5304: istore_3
    //   5305: iload 6
    //   5307: istore 10
    //   5309: iload 11
    //   5311: istore 4
    //   5313: iload 8
    //   5315: istore 12
    //   5317: iload 7
    //   5319: istore 5
    //   5321: iload 6
    //   5323: istore 13
    //   5325: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   5328: ldc_w 1101
    //   5331: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5334: iload 11
    //   5336: istore_2
    //   5337: iload 8
    //   5339: istore 9
    //   5341: iload 7
    //   5343: istore_3
    //   5344: iload 6
    //   5346: istore 10
    //   5348: iload 11
    //   5350: istore 4
    //   5352: iload 8
    //   5354: istore 12
    //   5356: iload 7
    //   5358: istore 5
    //   5360: iload 6
    //   5362: istore 13
    //   5364: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   5367: new 1031	java/lang/StringBuilder
    //   5370: dup
    //   5371: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   5374: ldc_w 1087
    //   5377: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5380: iload 23
    //   5382: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5385: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5388: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5391: iload 11
    //   5393: istore_2
    //   5394: iload 8
    //   5396: istore 9
    //   5398: iload 7
    //   5400: istore_3
    //   5401: iload 6
    //   5403: istore 10
    //   5405: iload 11
    //   5407: istore 4
    //   5409: iload 8
    //   5411: istore 12
    //   5413: iload 7
    //   5415: istore 5
    //   5417: iload 6
    //   5419: istore 13
    //   5421: aload_0
    //   5422: iconst_0
    //   5423: aaload
    //   5424: ldc_w 963
    //   5427: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5430: ifeq +19808 -> 25238
    //   5433: iload 11
    //   5435: istore_2
    //   5436: iload 8
    //   5438: istore 9
    //   5440: iload 7
    //   5442: istore_3
    //   5443: iload 6
    //   5445: istore 10
    //   5447: iload 11
    //   5449: istore 4
    //   5451: iload 8
    //   5453: istore 12
    //   5455: iload 7
    //   5457: istore 5
    //   5459: iload 6
    //   5461: istore 13
    //   5463: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   5466: ldc_w 1103
    //   5469: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5472: goto +19766 -> 25238
    //   5475: iload 14
    //   5477: istore 7
    //   5479: iload 11
    //   5481: istore_2
    //   5482: iload 8
    //   5484: istore 9
    //   5486: iload 14
    //   5488: istore_3
    //   5489: iload 6
    //   5491: istore 10
    //   5493: iload 11
    //   5495: istore 4
    //   5497: iload 8
    //   5499: istore 12
    //   5501: iload 14
    //   5503: istore 5
    //   5505: iload 6
    //   5507: istore 13
    //   5509: iload 23
    //   5511: iload_1
    //   5512: getstatic 441	com/chelpus/root/utils/corepatch:byteOrigOat7_1	[B
    //   5515: getstatic 443	com/chelpus/root/utils/corepatch:maskOat7_1	[B
    //   5518: getstatic 445	com/chelpus/root/utils/corepatch:byteReplaceOat7_1	[B
    //   5521: getstatic 447	com/chelpus/root/utils/corepatch:rep_maskOat7_1	[B
    //   5524: iload 26
    //   5526: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   5529: ifeq +228 -> 5757
    //   5532: iload 11
    //   5534: istore_2
    //   5535: iload 8
    //   5537: istore 9
    //   5539: iload 14
    //   5541: istore_3
    //   5542: iload 6
    //   5544: istore 10
    //   5546: iload 11
    //   5548: istore 4
    //   5550: iload 8
    //   5552: istore 12
    //   5554: iload 14
    //   5556: istore 5
    //   5558: iload 6
    //   5560: istore 13
    //   5562: aload_0
    //   5563: iconst_0
    //   5564: aaload
    //   5565: ldc_w 946
    //   5568: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5571: ifeq +99 -> 5670
    //   5574: iload 11
    //   5576: istore_2
    //   5577: iload 8
    //   5579: istore 9
    //   5581: iload 14
    //   5583: istore_3
    //   5584: iload 6
    //   5586: istore 10
    //   5588: iload 11
    //   5590: istore 4
    //   5592: iload 8
    //   5594: istore 12
    //   5596: iload 14
    //   5598: istore 5
    //   5600: iload 6
    //   5602: istore 13
    //   5604: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   5607: ldc_w 1101
    //   5610: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5613: iload 11
    //   5615: istore_2
    //   5616: iload 8
    //   5618: istore 9
    //   5620: iload 14
    //   5622: istore_3
    //   5623: iload 6
    //   5625: istore 10
    //   5627: iload 11
    //   5629: istore 4
    //   5631: iload 8
    //   5633: istore 12
    //   5635: iload 14
    //   5637: istore 5
    //   5639: iload 6
    //   5641: istore 13
    //   5643: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   5646: new 1031	java/lang/StringBuilder
    //   5649: dup
    //   5650: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   5653: ldc_w 1087
    //   5656: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5659: iload 23
    //   5661: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5664: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5667: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5670: iload 11
    //   5672: istore_2
    //   5673: iload 8
    //   5675: istore 9
    //   5677: iload 14
    //   5679: istore_3
    //   5680: iload 6
    //   5682: istore 10
    //   5684: iload 11
    //   5686: istore 4
    //   5688: iload 8
    //   5690: istore 12
    //   5692: iload 14
    //   5694: istore 5
    //   5696: iload 6
    //   5698: istore 13
    //   5700: aload_0
    //   5701: iconst_0
    //   5702: aaload
    //   5703: ldc_w 963
    //   5706: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5709: ifeq +42 -> 5751
    //   5712: iload 11
    //   5714: istore_2
    //   5715: iload 8
    //   5717: istore 9
    //   5719: iload 14
    //   5721: istore_3
    //   5722: iload 6
    //   5724: istore 10
    //   5726: iload 11
    //   5728: istore 4
    //   5730: iload 8
    //   5732: istore 12
    //   5734: iload 14
    //   5736: istore 5
    //   5738: iload 6
    //   5740: istore 13
    //   5742: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   5745: ldc_w 1103
    //   5748: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   5751: iconst_1
    //   5752: istore 7
    //   5754: iconst_1
    //   5755: istore 18
    //   5757: iload 28
    //   5759: ifeq +34 -> 5793
    //   5762: iload 26
    //   5764: ifeq +29 -> 5793
    //   5767: iload 19
    //   5769: ifeq +24 -> 5793
    //   5772: iload 11
    //   5774: istore 17
    //   5776: iload 8
    //   5778: istore 16
    //   5780: iload 7
    //   5782: istore 15
    //   5784: iload 6
    //   5786: istore 14
    //   5788: iload 18
    //   5790: ifne +152 -> 5942
    //   5793: iload 28
    //   5795: ifeq +44 -> 5839
    //   5798: iload 26
    //   5800: ifeq +39 -> 5839
    //   5803: iload 19
    //   5805: ifeq +34 -> 5839
    //   5808: iload 20
    //   5810: ifeq +29 -> 5839
    //   5813: iload 21
    //   5815: ifeq +24 -> 5839
    //   5818: iload 11
    //   5820: istore 17
    //   5822: iload 8
    //   5824: istore 16
    //   5826: iload 7
    //   5828: istore 15
    //   5830: iload 6
    //   5832: istore 14
    //   5834: iload 18
    //   5836: ifne +106 -> 5942
    //   5839: iload 28
    //   5841: ifeq +29 -> 5870
    //   5844: iload 26
    //   5846: ifne +24 -> 5870
    //   5849: iload 11
    //   5851: istore 17
    //   5853: iload 8
    //   5855: istore 16
    //   5857: iload 7
    //   5859: istore 15
    //   5861: iload 6
    //   5863: istore 14
    //   5865: iload 19
    //   5867: ifne +75 -> 5942
    //   5870: iload 28
    //   5872: ifeq +39 -> 5911
    //   5875: iload 26
    //   5877: ifne +34 -> 5911
    //   5880: iload 19
    //   5882: ifeq +29 -> 5911
    //   5885: iload 20
    //   5887: ifeq +24 -> 5911
    //   5890: iload 11
    //   5892: istore 17
    //   5894: iload 8
    //   5896: istore 16
    //   5898: iload 7
    //   5900: istore 15
    //   5902: iload 6
    //   5904: istore 14
    //   5906: iload 21
    //   5908: ifne +34 -> 5942
    //   5911: iload 28
    //   5913: ifne +360 -> 6273
    //   5916: iload 26
    //   5918: ifeq +355 -> 6273
    //   5921: iload 18
    //   5923: ifeq +350 -> 6273
    //   5926: iload 6
    //   5928: istore 14
    //   5930: iload 7
    //   5932: istore 15
    //   5934: iload 8
    //   5936: istore 16
    //   5938: iload 11
    //   5940: istore 17
    //   5942: iload 17
    //   5944: istore_2
    //   5945: iload 16
    //   5947: istore 9
    //   5949: iload 15
    //   5951: istore_3
    //   5952: iload 14
    //   5954: istore 10
    //   5956: aload 33
    //   5958: invokevirtual 1106	java/nio/channels/FileChannel:close	()V
    //   5961: iload 17
    //   5963: istore 11
    //   5965: iload 16
    //   5967: istore 8
    //   5969: iload 15
    //   5971: istore 7
    //   5973: iload 14
    //   5975: istore 6
    //   5977: goto -5100 -> 877
    //   5980: astore 33
    //   5982: aload 33
    //   5984: invokevirtual 1109	java/io/IOException:printStackTrace	()V
    //   5987: iload_2
    //   5988: istore 11
    //   5990: iload 9
    //   5992: istore 8
    //   5994: iload_3
    //   5995: istore 7
    //   5997: iload 10
    //   5999: istore 6
    //   6001: goto -5124 -> 877
    //   6004: astore 32
    //   6006: aload 32
    //   6008: invokevirtual 1110	java/lang/Exception:printStackTrace	()V
    //   6011: goto -5925 -> 86
    //   6014: new 980	java/io/File
    //   6017: dup
    //   6018: ldc_w 1112
    //   6021: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6024: invokevirtual 988	java/io/File:exists	()Z
    //   6027: ifeq +19 -> 6046
    //   6030: aload 32
    //   6032: new 980	java/io/File
    //   6035: dup
    //   6036: ldc_w 1112
    //   6039: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6042: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6045: pop
    //   6046: new 980	java/io/File
    //   6049: dup
    //   6050: ldc_w 1114
    //   6053: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6056: invokevirtual 988	java/io/File:exists	()Z
    //   6059: ifeq +19 -> 6078
    //   6062: aload 32
    //   6064: new 980	java/io/File
    //   6067: dup
    //   6068: ldc_w 1114
    //   6071: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6074: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6077: pop
    //   6078: new 980	java/io/File
    //   6081: dup
    //   6082: ldc_w 1116
    //   6085: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6088: invokevirtual 988	java/io/File:exists	()Z
    //   6091: ifeq +19 -> 6110
    //   6094: aload 32
    //   6096: new 980	java/io/File
    //   6099: dup
    //   6100: ldc_w 1116
    //   6103: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6106: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6109: pop
    //   6110: new 980	java/io/File
    //   6113: dup
    //   6114: ldc_w 1118
    //   6117: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6120: invokevirtual 988	java/io/File:exists	()Z
    //   6123: ifeq +19 -> 6142
    //   6126: aload 32
    //   6128: new 980	java/io/File
    //   6131: dup
    //   6132: ldc_w 1118
    //   6135: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6138: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6141: pop
    //   6142: new 980	java/io/File
    //   6145: dup
    //   6146: ldc_w 1120
    //   6149: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6152: invokevirtual 988	java/io/File:exists	()Z
    //   6155: ifeq +19 -> 6174
    //   6158: aload 32
    //   6160: new 980	java/io/File
    //   6163: dup
    //   6164: ldc_w 1120
    //   6167: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6170: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6173: pop
    //   6174: new 980	java/io/File
    //   6177: dup
    //   6178: ldc_w 1122
    //   6181: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6184: invokevirtual 988	java/io/File:exists	()Z
    //   6187: ifeq +19 -> 6206
    //   6190: aload 32
    //   6192: new 980	java/io/File
    //   6195: dup
    //   6196: ldc_w 1122
    //   6199: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6202: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6205: pop
    //   6206: new 980	java/io/File
    //   6209: dup
    //   6210: ldc_w 1124
    //   6213: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6216: invokevirtual 988	java/io/File:exists	()Z
    //   6219: ifeq +19 -> 6238
    //   6222: aload 32
    //   6224: new 980	java/io/File
    //   6227: dup
    //   6228: ldc_w 1124
    //   6231: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6234: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6237: pop
    //   6238: new 980	java/io/File
    //   6241: dup
    //   6242: ldc_w 1126
    //   6245: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6248: invokevirtual 988	java/io/File:exists	()Z
    //   6251: ifeq -5427 -> 824
    //   6254: aload 32
    //   6256: new 980	java/io/File
    //   6259: dup
    //   6260: ldc_w 1126
    //   6263: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6266: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6269: pop
    //   6270: goto -5446 -> 824
    //   6273: iload 11
    //   6275: istore_2
    //   6276: iload 8
    //   6278: istore 9
    //   6280: iload 7
    //   6282: istore_3
    //   6283: iload 6
    //   6285: istore 10
    //   6287: iload 11
    //   6289: istore 4
    //   6291: iload 8
    //   6293: istore 12
    //   6295: iload 7
    //   6297: istore 5
    //   6299: iload 6
    //   6301: istore 13
    //   6303: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   6306: iload 23
    //   6308: iconst_1
    //   6309: iadd
    //   6310: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   6313: pop
    //   6314: goto -5178 -> 1136
    //   6317: astore 34
    //   6319: iload 4
    //   6321: istore_2
    //   6322: iload 12
    //   6324: istore 9
    //   6326: iload 5
    //   6328: istore_3
    //   6329: iload 13
    //   6331: istore 10
    //   6333: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   6336: new 1031	java/lang/StringBuilder
    //   6339: dup
    //   6340: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   6343: ldc_w 299
    //   6346: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6349: aload 34
    //   6351: invokevirtual 1129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6354: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6357: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   6360: iload 4
    //   6362: istore 17
    //   6364: iload 12
    //   6366: istore 16
    //   6368: iload 5
    //   6370: istore 15
    //   6372: iload 13
    //   6374: istore 14
    //   6376: goto -434 -> 5942
    //   6379: iload 6
    //   6381: ifne +18 -> 6399
    //   6384: iload 11
    //   6386: ifne +13 -> 6399
    //   6389: iload 8
    //   6391: ifne +8 -> 6399
    //   6394: iload 7
    //   6396: ifeq +158 -> 6554
    //   6399: getstatic 303	com/chelpus/root/utils/corepatch:onlyDalvik	Z
    //   6402: ifne +115 -> 6517
    //   6405: new 980	java/io/File
    //   6408: dup
    //   6409: ldc_w 1118
    //   6412: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6415: invokevirtual 1132	java/io/File:delete	()Z
    //   6418: pop
    //   6419: new 980	java/io/File
    //   6422: dup
    //   6423: ldc_w 1134
    //   6426: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6429: invokevirtual 1132	java/io/File:delete	()Z
    //   6432: pop
    //   6433: new 980	java/io/File
    //   6436: dup
    //   6437: ldc_w 1116
    //   6440: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6443: invokevirtual 1132	java/io/File:delete	()Z
    //   6446: pop
    //   6447: new 980	java/io/File
    //   6450: dup
    //   6451: ldc_w 1136
    //   6454: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6457: invokevirtual 1132	java/io/File:delete	()Z
    //   6460: pop
    //   6461: new 980	java/io/File
    //   6464: dup
    //   6465: ldc_w 1112
    //   6468: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6471: invokevirtual 1132	java/io/File:delete	()Z
    //   6474: pop
    //   6475: new 980	java/io/File
    //   6478: dup
    //   6479: ldc_w 1138
    //   6482: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6485: invokevirtual 1132	java/io/File:delete	()Z
    //   6488: pop
    //   6489: new 980	java/io/File
    //   6492: dup
    //   6493: ldc_w 1114
    //   6496: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6499: invokevirtual 1132	java/io/File:delete	()Z
    //   6502: pop
    //   6503: new 980	java/io/File
    //   6506: dup
    //   6507: ldc_w 1140
    //   6510: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6513: invokevirtual 1132	java/io/File:delete	()Z
    //   6516: pop
    //   6517: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   6520: new 1031	java/lang/StringBuilder
    //   6523: dup
    //   6524: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   6527: ldc_w 1142
    //   6530: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6533: getstatic 1143	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
    //   6536: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6539: ldc_w 1145
    //   6542: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6545: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6548: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   6551: invokestatic 1148	com/chelpus/Utils:reboot	()V
    //   6554: aload_0
    //   6555: iconst_4
    //   6556: aaload
    //   6557: ldc_w 910
    //   6560: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6563: ifeq +2200 -> 8763
    //   6566: aload_0
    //   6567: iconst_1
    //   6568: aaload
    //   6569: ldc_w 926
    //   6572: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6575: ifne +15 -> 6590
    //   6578: aload_0
    //   6579: iconst_1
    //   6580: aaload
    //   6581: ldc_w 928
    //   6584: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6587: ifeq +96 -> 6683
    //   6590: new 980	java/io/File
    //   6593: dup
    //   6594: aload_0
    //   6595: iconst_1
    //   6596: aaload
    //   6597: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6600: invokestatic 1152	com/chelpus/Utils:classes_test	(Ljava/io/File;)Z
    //   6603: ifeq +80 -> 6683
    //   6606: new 980	java/io/File
    //   6609: dup
    //   6610: aload_0
    //   6611: iconst_1
    //   6612: aaload
    //   6613: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6616: astore 32
    //   6618: aload 32
    //   6620: aload 32
    //   6622: invokestatic 1156	com/chelpus/Utils:getDirs	(Ljava/io/File;)Ljava/io/File;
    //   6625: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6628: invokestatic 1159	com/chelpus/root/utils/corepatch:unzip	(Ljava/io/File;Ljava/lang/String;)V
    //   6631: new 980	java/io/File
    //   6634: dup
    //   6635: new 1031	java/lang/StringBuilder
    //   6638: dup
    //   6639: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   6642: aload 32
    //   6644: invokestatic 1156	com/chelpus/Utils:getDirs	(Ljava/io/File;)Ljava/io/File;
    //   6647: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6650: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6653: ldc_w 1161
    //   6656: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6659: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6662: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6665: astore 32
    //   6667: aload 32
    //   6669: invokevirtual 988	java/io/File:exists	()Z
    //   6672: ifeq +11 -> 6683
    //   6675: aload 37
    //   6677: aload 32
    //   6679: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6682: pop
    //   6683: aload_0
    //   6684: iconst_1
    //   6685: aaload
    //   6686: ldc_w 920
    //   6689: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6692: ifne +27 -> 6719
    //   6695: aload_0
    //   6696: iconst_1
    //   6697: aaload
    //   6698: ldc_w 932
    //   6701: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6704: ifne +15 -> 6719
    //   6707: aload_0
    //   6708: iconst_1
    //   6709: aaload
    //   6710: ldc_w 930
    //   6713: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6716: ifeq +19 -> 6735
    //   6719: aload 37
    //   6721: new 980	java/io/File
    //   6724: dup
    //   6725: aload_0
    //   6726: iconst_1
    //   6727: aaload
    //   6728: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   6731: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6734: pop
    //   6735: aload 37
    //   6737: invokevirtual 1020	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   6740: astore 32
    //   6742: aload 32
    //   6744: invokeinterface 1025 1 0
    //   6749: ifeq +2150 -> 8899
    //   6752: aload 32
    //   6754: invokeinterface 1029 1 0
    //   6759: checkcast 980	java/io/File
    //   6762: astore 33
    //   6764: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   6767: new 1031	java/lang/StringBuilder
    //   6770: dup
    //   6771: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   6774: ldc_w 1163
    //   6777: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6780: aload 33
    //   6782: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6785: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6788: ldc_w 1165
    //   6791: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6794: aload 33
    //   6796: invokevirtual 1168	java/io/File:length	()J
    //   6799: invokevirtual 1171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6802: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6805: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   6808: new 1047	java/io/RandomAccessFile
    //   6811: dup
    //   6812: aload 33
    //   6814: ldc_w 914
    //   6817: invokespecial 1050	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   6820: invokevirtual 1054	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   6823: astore 34
    //   6825: aload 34
    //   6827: getstatic 1060	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   6830: lconst_0
    //   6831: aload 34
    //   6833: invokevirtual 1065	java/nio/channels/FileChannel:size	()J
    //   6836: l2i
    //   6837: i2l
    //   6838: invokevirtual 1069	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   6841: putstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   6844: iconst_0
    //   6845: istore_3
    //   6846: iconst_0
    //   6847: istore_2
    //   6848: aload 33
    //   6850: invokevirtual 1174	java/io/File:getName	()Ljava/lang/String;
    //   6853: ldc_w 930
    //   6856: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6859: istore 24
    //   6861: iload 24
    //   6863: ifne +10129 -> 16992
    //   6866: lconst_0
    //   6867: lstore 30
    //   6869: iload_2
    //   6870: istore_3
    //   6871: iload_3
    //   6872: istore_2
    //   6873: iload_3
    //   6874: istore 4
    //   6876: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   6879: invokevirtual 1081	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   6882: ifeq +9769 -> 16651
    //   6885: iload_3
    //   6886: istore_2
    //   6887: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   6890: invokevirtual 1083	java/nio/MappedByteBuffer:position	()I
    //   6893: istore 5
    //   6895: iload_3
    //   6896: istore_2
    //   6897: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   6900: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   6903: istore_1
    //   6904: iload_3
    //   6905: istore 4
    //   6907: iload_3
    //   6908: istore_2
    //   6909: iload 5
    //   6911: iload_1
    //   6912: getstatic 313	com/chelpus/root/utils/corepatch:byteOrig2	[B
    //   6915: getstatic 315	com/chelpus/root/utils/corepatch:mask2	[B
    //   6918: getstatic 317	com/chelpus/root/utils/corepatch:byteReplace2	[B
    //   6921: getstatic 319	com/chelpus/root/utils/corepatch:rep_mask2	[B
    //   6924: iload 28
    //   6926: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   6929: ifeq +56 -> 6985
    //   6932: iload_3
    //   6933: istore_2
    //   6934: aload_0
    //   6935: iconst_0
    //   6936: aaload
    //   6937: ldc_w 946
    //   6940: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6943: ifeq +14 -> 6957
    //   6946: iload_3
    //   6947: istore_2
    //   6948: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   6951: ldc_w 1176
    //   6954: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   6957: iload_3
    //   6958: istore_2
    //   6959: aload_0
    //   6960: iconst_0
    //   6961: aaload
    //   6962: ldc_w 963
    //   6965: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6968: ifeq +18279 -> 25247
    //   6971: iload_3
    //   6972: istore_2
    //   6973: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   6976: ldc_w 1178
    //   6979: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   6982: goto +18265 -> 25247
    //   6985: iload 4
    //   6987: istore_3
    //   6988: iload 4
    //   6990: istore_2
    //   6991: iload 5
    //   6993: iload_1
    //   6994: getstatic 681	com/chelpus/root/utils/corepatch:byteOrig3	[B
    //   6997: getstatic 315	com/chelpus/root/utils/corepatch:mask2	[B
    //   7000: getstatic 683	com/chelpus/root/utils/corepatch:byteReplace3	[B
    //   7003: getstatic 319	com/chelpus/root/utils/corepatch:rep_mask2	[B
    //   7006: iload 28
    //   7008: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7011: ifeq +60 -> 7071
    //   7014: iload 4
    //   7016: istore_2
    //   7017: aload_0
    //   7018: iconst_0
    //   7019: aaload
    //   7020: ldc_w 946
    //   7023: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7026: ifeq +15 -> 7041
    //   7029: iload 4
    //   7031: istore_2
    //   7032: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7035: ldc_w 1176
    //   7038: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7041: iload 4
    //   7043: istore_2
    //   7044: aload_0
    //   7045: iconst_0
    //   7046: aaload
    //   7047: ldc_w 963
    //   7050: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7053: ifeq +18200 -> 25253
    //   7056: iload 4
    //   7058: istore_2
    //   7059: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7062: ldc_w 1178
    //   7065: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7068: goto +18185 -> 25253
    //   7071: iload_3
    //   7072: istore 4
    //   7074: iload_3
    //   7075: istore_2
    //   7076: iload 5
    //   7078: iload_1
    //   7079: getstatic 685	com/chelpus/root/utils/corepatch:byteOrig4	[B
    //   7082: getstatic 687	com/chelpus/root/utils/corepatch:mask4	[B
    //   7085: getstatic 689	com/chelpus/root/utils/corepatch:byteReplace4	[B
    //   7088: getstatic 691	com/chelpus/root/utils/corepatch:rep_mask4	[B
    //   7091: iload 26
    //   7093: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7096: ifeq +56 -> 7152
    //   7099: iload_3
    //   7100: istore_2
    //   7101: aload_0
    //   7102: iconst_0
    //   7103: aaload
    //   7104: ldc_w 946
    //   7107: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7110: ifeq +14 -> 7124
    //   7113: iload_3
    //   7114: istore_2
    //   7115: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7118: ldc_w 1180
    //   7121: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7124: iload_3
    //   7125: istore_2
    //   7126: aload_0
    //   7127: iconst_0
    //   7128: aaload
    //   7129: ldc_w 963
    //   7132: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7135: ifeq +18123 -> 25258
    //   7138: iload_3
    //   7139: istore_2
    //   7140: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7143: ldc_w 1182
    //   7146: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7149: goto +18109 -> 25258
    //   7152: iload 4
    //   7154: istore_3
    //   7155: iload 4
    //   7157: istore_2
    //   7158: iload 5
    //   7160: iload_1
    //   7161: getstatic 693	com/chelpus/root/utils/corepatch:byteOrig5	[B
    //   7164: getstatic 695	com/chelpus/root/utils/corepatch:mask5	[B
    //   7167: getstatic 697	com/chelpus/root/utils/corepatch:byteReplace5	[B
    //   7170: getstatic 699	com/chelpus/root/utils/corepatch:rep_mask5	[B
    //   7173: iload 26
    //   7175: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7178: ifeq +60 -> 7238
    //   7181: iload 4
    //   7183: istore_2
    //   7184: aload_0
    //   7185: iconst_0
    //   7186: aaload
    //   7187: ldc_w 946
    //   7190: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7193: ifeq +15 -> 7208
    //   7196: iload 4
    //   7198: istore_2
    //   7199: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7202: ldc_w 1180
    //   7205: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7208: iload 4
    //   7210: istore_2
    //   7211: aload_0
    //   7212: iconst_0
    //   7213: aaload
    //   7214: ldc_w 963
    //   7217: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7220: ifeq +18044 -> 25264
    //   7223: iload 4
    //   7225: istore_2
    //   7226: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7229: ldc_w 1182
    //   7232: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7235: goto +18029 -> 25264
    //   7238: iload_3
    //   7239: istore 4
    //   7241: iload_3
    //   7242: istore_2
    //   7243: iload 5
    //   7245: iload_1
    //   7246: getstatic 701	com/chelpus/root/utils/corepatch:byteOrig6	[B
    //   7249: getstatic 703	com/chelpus/root/utils/corepatch:mask6	[B
    //   7252: getstatic 705	com/chelpus/root/utils/corepatch:byteReplace6	[B
    //   7255: getstatic 707	com/chelpus/root/utils/corepatch:rep_mask6	[B
    //   7258: iload 28
    //   7260: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7263: ifeq +56 -> 7319
    //   7266: iload_3
    //   7267: istore_2
    //   7268: aload_0
    //   7269: iconst_0
    //   7270: aaload
    //   7271: ldc_w 946
    //   7274: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7277: ifeq +14 -> 7291
    //   7280: iload_3
    //   7281: istore_2
    //   7282: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7285: ldc_w 1176
    //   7288: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7291: iload_3
    //   7292: istore_2
    //   7293: aload_0
    //   7294: iconst_0
    //   7295: aaload
    //   7296: ldc_w 963
    //   7299: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7302: ifeq +17967 -> 25269
    //   7305: iload_3
    //   7306: istore_2
    //   7307: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7310: ldc_w 1178
    //   7313: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7316: goto +17953 -> 25269
    //   7319: iload 4
    //   7321: istore_3
    //   7322: iload 4
    //   7324: istore_2
    //   7325: iload 5
    //   7327: iload_1
    //   7328: getstatic 709	com/chelpus/root/utils/corepatch:byteOrig7	[B
    //   7331: getstatic 711	com/chelpus/root/utils/corepatch:mask7	[B
    //   7334: getstatic 713	com/chelpus/root/utils/corepatch:byteReplace7	[B
    //   7337: getstatic 715	com/chelpus/root/utils/corepatch:rep_mask7	[B
    //   7340: iload 28
    //   7342: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7345: ifeq +60 -> 7405
    //   7348: iload 4
    //   7350: istore_2
    //   7351: aload_0
    //   7352: iconst_0
    //   7353: aaload
    //   7354: ldc_w 946
    //   7357: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7360: ifeq +15 -> 7375
    //   7363: iload 4
    //   7365: istore_2
    //   7366: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7369: ldc_w 1184
    //   7372: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7375: iload 4
    //   7377: istore_2
    //   7378: aload_0
    //   7379: iconst_0
    //   7380: aaload
    //   7381: ldc_w 963
    //   7384: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7387: ifeq +17888 -> 25275
    //   7390: iload 4
    //   7392: istore_2
    //   7393: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7396: ldc_w 1186
    //   7399: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7402: goto +17873 -> 25275
    //   7405: iload_3
    //   7406: istore 4
    //   7408: iload_3
    //   7409: istore_2
    //   7410: iload 5
    //   7412: iload_1
    //   7413: getstatic 717	com/chelpus/root/utils/corepatch:byteOrig8	[B
    //   7416: getstatic 719	com/chelpus/root/utils/corepatch:mask8	[B
    //   7419: getstatic 721	com/chelpus/root/utils/corepatch:byteReplace8	[B
    //   7422: getstatic 723	com/chelpus/root/utils/corepatch:rep_mask8	[B
    //   7425: iload 28
    //   7427: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7430: ifeq +56 -> 7486
    //   7433: iload_3
    //   7434: istore_2
    //   7435: aload_0
    //   7436: iconst_0
    //   7437: aaload
    //   7438: ldc_w 946
    //   7441: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7444: ifeq +14 -> 7458
    //   7447: iload_3
    //   7448: istore_2
    //   7449: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7452: ldc_w 1184
    //   7455: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7458: iload_3
    //   7459: istore_2
    //   7460: aload_0
    //   7461: iconst_0
    //   7462: aaload
    //   7463: ldc_w 963
    //   7466: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7469: ifeq +17811 -> 25280
    //   7472: iload_3
    //   7473: istore_2
    //   7474: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7477: ldc_w 1186
    //   7480: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7483: goto +17797 -> 25280
    //   7486: iload 4
    //   7488: istore_3
    //   7489: iload 4
    //   7491: istore_2
    //   7492: iload 5
    //   7494: iload_1
    //   7495: getstatic 725	com/chelpus/root/utils/corepatch:byteOrig9	[B
    //   7498: getstatic 727	com/chelpus/root/utils/corepatch:mask9	[B
    //   7501: getstatic 729	com/chelpus/root/utils/corepatch:byteReplace9	[B
    //   7504: getstatic 731	com/chelpus/root/utils/corepatch:rep_mask9	[B
    //   7507: iload 28
    //   7509: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7512: ifeq +60 -> 7572
    //   7515: iload 4
    //   7517: istore_2
    //   7518: aload_0
    //   7519: iconst_0
    //   7520: aaload
    //   7521: ldc_w 946
    //   7524: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7527: ifeq +15 -> 7542
    //   7530: iload 4
    //   7532: istore_2
    //   7533: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7536: ldc_w 1184
    //   7539: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7542: iload 4
    //   7544: istore_2
    //   7545: aload_0
    //   7546: iconst_0
    //   7547: aaload
    //   7548: ldc_w 963
    //   7551: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7554: ifeq +17732 -> 25286
    //   7557: iload 4
    //   7559: istore_2
    //   7560: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7563: ldc_w 1186
    //   7566: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7569: goto +17717 -> 25286
    //   7572: iload_3
    //   7573: istore 4
    //   7575: iload_3
    //   7576: istore_2
    //   7577: iload 5
    //   7579: iload_1
    //   7580: getstatic 733	com/chelpus/root/utils/corepatch:byteOrig10	[B
    //   7583: getstatic 735	com/chelpus/root/utils/corepatch:mask10	[B
    //   7586: getstatic 737	com/chelpus/root/utils/corepatch:byteReplace10	[B
    //   7589: getstatic 739	com/chelpus/root/utils/corepatch:rep_mask10	[B
    //   7592: iload 28
    //   7594: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7597: ifeq +56 -> 7653
    //   7600: iload_3
    //   7601: istore_2
    //   7602: aload_0
    //   7603: iconst_0
    //   7604: aaload
    //   7605: ldc_w 946
    //   7608: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7611: ifeq +14 -> 7625
    //   7614: iload_3
    //   7615: istore_2
    //   7616: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7619: ldc_w 1176
    //   7622: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7625: iload_3
    //   7626: istore_2
    //   7627: aload_0
    //   7628: iconst_0
    //   7629: aaload
    //   7630: ldc_w 963
    //   7633: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7636: ifeq +17655 -> 25291
    //   7639: iload_3
    //   7640: istore_2
    //   7641: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7644: ldc_w 1178
    //   7647: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7650: goto +17641 -> 25291
    //   7653: iload 4
    //   7655: istore_3
    //   7656: iload 4
    //   7658: istore_2
    //   7659: iload 5
    //   7661: iload_1
    //   7662: getstatic 741	com/chelpus/root/utils/corepatch:byteOrig11	[B
    //   7665: getstatic 743	com/chelpus/root/utils/corepatch:mask11	[B
    //   7668: getstatic 745	com/chelpus/root/utils/corepatch:byteReplace11	[B
    //   7671: getstatic 747	com/chelpus/root/utils/corepatch:rep_mask11	[B
    //   7674: iload 28
    //   7676: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7679: ifeq +60 -> 7739
    //   7682: iload 4
    //   7684: istore_2
    //   7685: aload_0
    //   7686: iconst_0
    //   7687: aaload
    //   7688: ldc_w 946
    //   7691: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7694: ifeq +15 -> 7709
    //   7697: iload 4
    //   7699: istore_2
    //   7700: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7703: ldc_w 1176
    //   7706: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7709: iload 4
    //   7711: istore_2
    //   7712: aload_0
    //   7713: iconst_0
    //   7714: aaload
    //   7715: ldc_w 963
    //   7718: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7721: ifeq +17576 -> 25297
    //   7724: iload 4
    //   7726: istore_2
    //   7727: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7730: ldc_w 1178
    //   7733: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7736: goto +17561 -> 25297
    //   7739: iload_3
    //   7740: istore 4
    //   7742: iload_3
    //   7743: istore_2
    //   7744: iload 5
    //   7746: iload_1
    //   7747: getstatic 749	com/chelpus/root/utils/corepatch:byteOrig12	[B
    //   7750: getstatic 751	com/chelpus/root/utils/corepatch:mask12	[B
    //   7753: getstatic 753	com/chelpus/root/utils/corepatch:byteReplace12	[B
    //   7756: getstatic 755	com/chelpus/root/utils/corepatch:rep_mask12	[B
    //   7759: iload 26
    //   7761: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7764: ifeq +56 -> 7820
    //   7767: iload_3
    //   7768: istore_2
    //   7769: aload_0
    //   7770: iconst_0
    //   7771: aaload
    //   7772: ldc_w 946
    //   7775: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7778: ifeq +14 -> 7792
    //   7781: iload_3
    //   7782: istore_2
    //   7783: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7786: ldc_w 1180
    //   7789: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7792: iload_3
    //   7793: istore_2
    //   7794: aload_0
    //   7795: iconst_0
    //   7796: aaload
    //   7797: ldc_w 963
    //   7800: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7803: ifeq +17499 -> 25302
    //   7806: iload_3
    //   7807: istore_2
    //   7808: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7811: ldc_w 1182
    //   7814: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7817: goto +17485 -> 25302
    //   7820: iload 4
    //   7822: istore_3
    //   7823: iload 4
    //   7825: istore_2
    //   7826: iload 5
    //   7828: iload_1
    //   7829: getstatic 757	com/chelpus/root/utils/corepatch:byteOrig13	[B
    //   7832: getstatic 759	com/chelpus/root/utils/corepatch:mask13	[B
    //   7835: getstatic 761	com/chelpus/root/utils/corepatch:byteReplace13	[B
    //   7838: getstatic 763	com/chelpus/root/utils/corepatch:rep_mask13	[B
    //   7841: iload 26
    //   7843: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7846: ifeq +60 -> 7906
    //   7849: iload 4
    //   7851: istore_2
    //   7852: aload_0
    //   7853: iconst_0
    //   7854: aaload
    //   7855: ldc_w 946
    //   7858: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7861: ifeq +15 -> 7876
    //   7864: iload 4
    //   7866: istore_2
    //   7867: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7870: ldc_w 1180
    //   7873: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7876: iload 4
    //   7878: istore_2
    //   7879: aload_0
    //   7880: iconst_0
    //   7881: aaload
    //   7882: ldc_w 963
    //   7885: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7888: ifeq +17420 -> 25308
    //   7891: iload 4
    //   7893: istore_2
    //   7894: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7897: ldc_w 1182
    //   7900: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7903: goto +17405 -> 25308
    //   7906: iload_3
    //   7907: istore 4
    //   7909: iload_3
    //   7910: istore_2
    //   7911: iload 5
    //   7913: iload_1
    //   7914: getstatic 813	com/chelpus/root/utils/corepatch:byteOrig20	[B
    //   7917: getstatic 815	com/chelpus/root/utils/corepatch:mask20	[B
    //   7920: getstatic 817	com/chelpus/root/utils/corepatch:byteReplace20	[B
    //   7923: getstatic 819	com/chelpus/root/utils/corepatch:rep_mask20	[B
    //   7926: iload 26
    //   7928: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   7931: ifeq +56 -> 7987
    //   7934: iload_3
    //   7935: istore_2
    //   7936: aload_0
    //   7937: iconst_0
    //   7938: aaload
    //   7939: ldc_w 946
    //   7942: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7945: ifeq +14 -> 7959
    //   7948: iload_3
    //   7949: istore_2
    //   7950: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7953: ldc_w 1180
    //   7956: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7959: iload_3
    //   7960: istore_2
    //   7961: aload_0
    //   7962: iconst_0
    //   7963: aaload
    //   7964: ldc_w 963
    //   7967: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7970: ifeq +17343 -> 25313
    //   7973: iload_3
    //   7974: istore_2
    //   7975: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   7978: ldc_w 1182
    //   7981: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   7984: goto +17329 -> 25313
    //   7987: iload 4
    //   7989: istore_3
    //   7990: iload 4
    //   7992: istore_2
    //   7993: iload 5
    //   7995: iload_1
    //   7996: getstatic 821	com/chelpus/root/utils/corepatch:byteOrig21	[B
    //   7999: getstatic 823	com/chelpus/root/utils/corepatch:mask21	[B
    //   8002: getstatic 825	com/chelpus/root/utils/corepatch:byteReplace21	[B
    //   8005: getstatic 827	com/chelpus/root/utils/corepatch:rep_mask21	[B
    //   8008: iload 28
    //   8010: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   8013: ifeq +60 -> 8073
    //   8016: iload 4
    //   8018: istore_2
    //   8019: aload_0
    //   8020: iconst_0
    //   8021: aaload
    //   8022: ldc_w 946
    //   8025: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8028: ifeq +15 -> 8043
    //   8031: iload 4
    //   8033: istore_2
    //   8034: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8037: ldc_w 1176
    //   8040: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8043: iload 4
    //   8045: istore_2
    //   8046: aload_0
    //   8047: iconst_0
    //   8048: aaload
    //   8049: ldc_w 963
    //   8052: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8055: ifeq +17264 -> 25319
    //   8058: iload 4
    //   8060: istore_2
    //   8061: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8064: ldc_w 1178
    //   8067: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8070: goto +17249 -> 25319
    //   8073: iload_3
    //   8074: istore 4
    //   8076: iload_3
    //   8077: istore_2
    //   8078: iload 5
    //   8080: iload_1
    //   8081: getstatic 829	com/chelpus/root/utils/corepatch:byteOrig22	[B
    //   8084: getstatic 831	com/chelpus/root/utils/corepatch:mask22	[B
    //   8087: getstatic 833	com/chelpus/root/utils/corepatch:byteReplace22	[B
    //   8090: getstatic 835	com/chelpus/root/utils/corepatch:rep_mask22	[B
    //   8093: iload 28
    //   8095: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   8098: ifeq +56 -> 8154
    //   8101: iload_3
    //   8102: istore_2
    //   8103: aload_0
    //   8104: iconst_0
    //   8105: aaload
    //   8106: ldc_w 946
    //   8109: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8112: ifeq +14 -> 8126
    //   8115: iload_3
    //   8116: istore_2
    //   8117: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8120: ldc_w 1176
    //   8123: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8126: iload_3
    //   8127: istore_2
    //   8128: aload_0
    //   8129: iconst_0
    //   8130: aaload
    //   8131: ldc_w 963
    //   8134: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8137: ifeq +17187 -> 25324
    //   8140: iload_3
    //   8141: istore_2
    //   8142: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8145: ldc_w 1178
    //   8148: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8151: goto +17173 -> 25324
    //   8154: iload 4
    //   8156: istore_3
    //   8157: iload 4
    //   8159: istore_2
    //   8160: iload 5
    //   8162: iload_1
    //   8163: getstatic 765	com/chelpus/root/utils/corepatch:byteOrig14	[B
    //   8166: getstatic 767	com/chelpus/root/utils/corepatch:mask14	[B
    //   8169: getstatic 769	com/chelpus/root/utils/corepatch:byteReplace14	[B
    //   8172: getstatic 771	com/chelpus/root/utils/corepatch:rep_mask14	[B
    //   8175: iload 28
    //   8177: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   8180: ifeq +60 -> 8240
    //   8183: iload 4
    //   8185: istore_2
    //   8186: aload_0
    //   8187: iconst_0
    //   8188: aaload
    //   8189: ldc_w 946
    //   8192: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8195: ifeq +15 -> 8210
    //   8198: iload 4
    //   8200: istore_2
    //   8201: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8204: ldc_w 1176
    //   8207: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8210: iload 4
    //   8212: istore_2
    //   8213: aload_0
    //   8214: iconst_0
    //   8215: aaload
    //   8216: ldc_w 963
    //   8219: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8222: ifeq +17108 -> 25330
    //   8225: iload 4
    //   8227: istore_2
    //   8228: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8231: ldc_w 1178
    //   8234: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8237: goto +17093 -> 25330
    //   8240: iload_3
    //   8241: istore 4
    //   8243: iload_3
    //   8244: istore_2
    //   8245: iload 5
    //   8247: iload_1
    //   8248: getstatic 773	com/chelpus/root/utils/corepatch:byteOrig15	[B
    //   8251: getstatic 775	com/chelpus/root/utils/corepatch:mask15	[B
    //   8254: getstatic 777	com/chelpus/root/utils/corepatch:byteReplace15	[B
    //   8257: getstatic 779	com/chelpus/root/utils/corepatch:rep_mask15	[B
    //   8260: iload 28
    //   8262: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   8265: ifeq +56 -> 8321
    //   8268: iload_3
    //   8269: istore_2
    //   8270: aload_0
    //   8271: iconst_0
    //   8272: aaload
    //   8273: ldc_w 946
    //   8276: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8279: ifeq +14 -> 8293
    //   8282: iload_3
    //   8283: istore_2
    //   8284: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8287: ldc_w 1184
    //   8290: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8293: iload_3
    //   8294: istore_2
    //   8295: aload_0
    //   8296: iconst_0
    //   8297: aaload
    //   8298: ldc_w 963
    //   8301: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8304: ifeq +17031 -> 25335
    //   8307: iload_3
    //   8308: istore_2
    //   8309: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8312: ldc_w 1186
    //   8315: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8318: goto +17017 -> 25335
    //   8321: iload 4
    //   8323: istore_3
    //   8324: iload 4
    //   8326: istore_2
    //   8327: iload 5
    //   8329: iload_1
    //   8330: getstatic 781	com/chelpus/root/utils/corepatch:byteOrig16	[B
    //   8333: getstatic 783	com/chelpus/root/utils/corepatch:mask16	[B
    //   8336: getstatic 785	com/chelpus/root/utils/corepatch:byteReplace16	[B
    //   8339: getstatic 787	com/chelpus/root/utils/corepatch:rep_mask16	[B
    //   8342: iload 28
    //   8344: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   8347: ifeq +60 -> 8407
    //   8350: iload 4
    //   8352: istore_2
    //   8353: aload_0
    //   8354: iconst_0
    //   8355: aaload
    //   8356: ldc_w 946
    //   8359: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8362: ifeq +15 -> 8377
    //   8365: iload 4
    //   8367: istore_2
    //   8368: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8371: ldc_w 1184
    //   8374: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8377: iload 4
    //   8379: istore_2
    //   8380: aload_0
    //   8381: iconst_0
    //   8382: aaload
    //   8383: ldc_w 963
    //   8386: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8389: ifeq +16952 -> 25341
    //   8392: iload 4
    //   8394: istore_2
    //   8395: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8398: ldc_w 1186
    //   8401: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8404: goto +16937 -> 25341
    //   8407: iload_3
    //   8408: istore 4
    //   8410: iload_3
    //   8411: istore_2
    //   8412: iload 5
    //   8414: iload_1
    //   8415: getstatic 789	com/chelpus/root/utils/corepatch:byteOrig17	[B
    //   8418: getstatic 791	com/chelpus/root/utils/corepatch:mask17	[B
    //   8421: getstatic 793	com/chelpus/root/utils/corepatch:byteReplace17	[B
    //   8424: getstatic 795	com/chelpus/root/utils/corepatch:rep_mask17	[B
    //   8427: iload 28
    //   8429: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   8432: ifeq +56 -> 8488
    //   8435: iload_3
    //   8436: istore_2
    //   8437: aload_0
    //   8438: iconst_0
    //   8439: aaload
    //   8440: ldc_w 946
    //   8443: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8446: ifeq +14 -> 8460
    //   8449: iload_3
    //   8450: istore_2
    //   8451: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8454: ldc_w 1184
    //   8457: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8460: iload_3
    //   8461: istore_2
    //   8462: aload_0
    //   8463: iconst_0
    //   8464: aaload
    //   8465: ldc_w 963
    //   8468: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8471: ifeq +16875 -> 25346
    //   8474: iload_3
    //   8475: istore_2
    //   8476: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8479: ldc_w 1186
    //   8482: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8485: goto +16861 -> 25346
    //   8488: iload 4
    //   8490: istore_3
    //   8491: iload 4
    //   8493: istore_2
    //   8494: iload 5
    //   8496: iload_1
    //   8497: getstatic 797	com/chelpus/root/utils/corepatch:byteOrig18	[B
    //   8500: getstatic 799	com/chelpus/root/utils/corepatch:mask18	[B
    //   8503: getstatic 801	com/chelpus/root/utils/corepatch:byteReplace18	[B
    //   8506: getstatic 803	com/chelpus/root/utils/corepatch:rep_mask18	[B
    //   8509: iload 28
    //   8511: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   8514: ifeq +60 -> 8574
    //   8517: iload 4
    //   8519: istore_2
    //   8520: aload_0
    //   8521: iconst_0
    //   8522: aaload
    //   8523: ldc_w 946
    //   8526: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8529: ifeq +15 -> 8544
    //   8532: iload 4
    //   8534: istore_2
    //   8535: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8538: ldc_w 1184
    //   8541: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8544: iload 4
    //   8546: istore_2
    //   8547: aload_0
    //   8548: iconst_0
    //   8549: aaload
    //   8550: ldc_w 963
    //   8553: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8556: ifeq +16796 -> 25352
    //   8559: iload 4
    //   8561: istore_2
    //   8562: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8565: ldc_w 1186
    //   8568: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8571: goto +16781 -> 25352
    //   8574: iload_3
    //   8575: istore 4
    //   8577: iload_3
    //   8578: istore_2
    //   8579: iload 5
    //   8581: iload_1
    //   8582: getstatic 805	com/chelpus/root/utils/corepatch:byteOrig19	[B
    //   8585: getstatic 807	com/chelpus/root/utils/corepatch:mask19	[B
    //   8588: getstatic 809	com/chelpus/root/utils/corepatch:byteReplace19	[B
    //   8591: getstatic 811	com/chelpus/root/utils/corepatch:rep_mask19	[B
    //   8594: iload 28
    //   8596: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   8599: ifeq +56 -> 8655
    //   8602: iload_3
    //   8603: istore_2
    //   8604: aload_0
    //   8605: iconst_0
    //   8606: aaload
    //   8607: ldc_w 946
    //   8610: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8613: ifeq +14 -> 8627
    //   8616: iload_3
    //   8617: istore_2
    //   8618: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8621: ldc_w 1184
    //   8624: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8627: iload_3
    //   8628: istore_2
    //   8629: aload_0
    //   8630: iconst_0
    //   8631: aaload
    //   8632: ldc_w 963
    //   8635: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8638: ifeq +16719 -> 25357
    //   8641: iload_3
    //   8642: istore_2
    //   8643: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8646: ldc_w 1186
    //   8649: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8652: goto +16705 -> 25357
    //   8655: iload 4
    //   8657: istore_3
    //   8658: iload 4
    //   8660: istore_2
    //   8661: iload 5
    //   8663: iload_1
    //   8664: getstatic 837	com/chelpus/root/utils/corepatch:byteOrig23	[B
    //   8667: getstatic 839	com/chelpus/root/utils/corepatch:mask23	[B
    //   8670: getstatic 841	com/chelpus/root/utils/corepatch:byteReplace23	[B
    //   8673: getstatic 843	com/chelpus/root/utils/corepatch:rep_mask23	[B
    //   8676: iload 28
    //   8678: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   8681: ifeq +60 -> 8741
    //   8684: iload 4
    //   8686: istore_2
    //   8687: aload_0
    //   8688: iconst_0
    //   8689: aaload
    //   8690: ldc_w 946
    //   8693: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8696: ifeq +15 -> 8711
    //   8699: iload 4
    //   8701: istore_2
    //   8702: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8705: ldc_w 1184
    //   8708: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8711: iload 4
    //   8713: istore_2
    //   8714: aload_0
    //   8715: iconst_0
    //   8716: aaload
    //   8717: ldc_w 963
    //   8720: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8723: ifeq +16640 -> 25363
    //   8726: iload 4
    //   8728: istore_2
    //   8729: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8732: ldc_w 1186
    //   8735: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8738: goto +16625 -> 25363
    //   8741: iload_3
    //   8742: istore_2
    //   8743: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   8746: iload 5
    //   8748: iconst_1
    //   8749: iadd
    //   8750: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   8753: pop
    //   8754: lload 30
    //   8756: lconst_1
    //   8757: ladd
    //   8758: lstore 30
    //   8760: goto -1889 -> 6871
    //   8763: aload_0
    //   8764: iconst_4
    //   8765: aaload
    //   8766: ldc_w 1188
    //   8769: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8772: ifeq +7417 -> 16189
    //   8775: new 980	java/io/File
    //   8778: dup
    //   8779: ldc_w 1190
    //   8782: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   8785: invokevirtual 988	java/io/File:exists	()Z
    //   8788: ifeq +37 -> 8825
    //   8791: new 980	java/io/File
    //   8794: dup
    //   8795: ldc_w 1190
    //   8798: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   8801: invokevirtual 1168	java/io/File:length	()J
    //   8804: lconst_0
    //   8805: lcmp
    //   8806: ifeq +19 -> 8825
    //   8809: aload 37
    //   8811: new 980	java/io/File
    //   8814: dup
    //   8815: ldc_w 1190
    //   8818: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   8821: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   8824: pop
    //   8825: new 980	java/io/File
    //   8828: dup
    //   8829: ldc_w 1192
    //   8832: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   8835: invokestatic 1152	com/chelpus/Utils:classes_test	(Ljava/io/File;)Z
    //   8838: ifeq -2103 -> 6735
    //   8841: new 980	java/io/File
    //   8844: dup
    //   8845: ldc_w 1192
    //   8848: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   8851: ldc_w 1194
    //   8854: invokestatic 1159	com/chelpus/root/utils/corepatch:unzip	(Ljava/io/File;Ljava/lang/String;)V
    //   8857: new 980	java/io/File
    //   8860: dup
    //   8861: ldc_w 1196
    //   8864: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   8867: astore 32
    //   8869: aload 32
    //   8871: invokevirtual 988	java/io/File:exists	()Z
    //   8874: ifeq -2139 -> 6735
    //   8877: aload 37
    //   8879: aload 32
    //   8881: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   8884: pop
    //   8885: goto -2150 -> 6735
    //   8888: astore 32
    //   8890: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8893: ldc_w 1198
    //   8896: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8899: iload 25
    //   8901: ifne +8 -> 8909
    //   8904: iload 22
    //   8906: ifeq +11688 -> 20594
    //   8909: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   8912: ldc_w 1200
    //   8915: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   8918: ldc_w 299
    //   8921: astore 32
    //   8923: ldc_w 299
    //   8926: astore 35
    //   8928: ldc_w 299
    //   8931: astore 34
    //   8933: getstatic 303	com/chelpus/root/utils/corepatch:onlyDalvik	Z
    //   8936: ifne +10935 -> 19871
    //   8939: ldc_w 1202
    //   8942: astore 35
    //   8944: ldc_w 1204
    //   8947: astore 36
    //   8949: new 980	java/io/File
    //   8952: dup
    //   8953: ldc_w 1206
    //   8956: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   8959: invokevirtual 988	java/io/File:exists	()Z
    //   8962: ifeq +8 -> 8970
    //   8965: ldc_w 1208
    //   8968: astore 32
    //   8970: new 980	java/io/File
    //   8973: dup
    //   8974: ldc_w 1210
    //   8977: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   8980: invokevirtual 988	java/io/File:exists	()Z
    //   8983: ifeq +8 -> 8991
    //   8986: ldc_w 1212
    //   8989: astore 32
    //   8991: new 980	java/io/File
    //   8994: dup
    //   8995: ldc_w 1214
    //   8998: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9001: invokevirtual 988	java/io/File:exists	()Z
    //   9004: ifeq +8 -> 9012
    //   9007: ldc_w 1216
    //   9010: astore 32
    //   9012: new 980	java/io/File
    //   9015: dup
    //   9016: ldc_w 1218
    //   9019: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9022: invokevirtual 988	java/io/File:exists	()Z
    //   9025: ifeq +8 -> 9033
    //   9028: ldc_w 1220
    //   9031: astore 32
    //   9033: new 980	java/io/File
    //   9036: dup
    //   9037: ldc_w 1222
    //   9040: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9043: invokevirtual 988	java/io/File:exists	()Z
    //   9046: ifeq +8 -> 9054
    //   9049: ldc_w 1208
    //   9052: astore 32
    //   9054: new 980	java/io/File
    //   9057: dup
    //   9058: ldc_w 1224
    //   9061: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9064: invokevirtual 988	java/io/File:exists	()Z
    //   9067: ifeq +8 -> 9075
    //   9070: ldc_w 1212
    //   9073: astore 32
    //   9075: new 980	java/io/File
    //   9078: dup
    //   9079: ldc_w 1226
    //   9082: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9085: invokevirtual 988	java/io/File:exists	()Z
    //   9088: ifeq +8 -> 9096
    //   9091: ldc_w 1216
    //   9094: astore 32
    //   9096: new 980	java/io/File
    //   9099: dup
    //   9100: ldc_w 1228
    //   9103: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9106: invokevirtual 988	java/io/File:exists	()Z
    //   9109: ifeq +8 -> 9117
    //   9112: ldc_w 1220
    //   9115: astore 32
    //   9117: new 980	java/io/File
    //   9120: dup
    //   9121: ldc_w 1230
    //   9124: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9127: invokevirtual 988	java/io/File:exists	()Z
    //   9130: ifeq +8 -> 9138
    //   9133: ldc_w 1232
    //   9136: astore 32
    //   9138: new 980	java/io/File
    //   9141: dup
    //   9142: ldc_w 1234
    //   9145: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9148: invokevirtual 988	java/io/File:exists	()Z
    //   9151: ifeq +8 -> 9159
    //   9154: ldc_w 1236
    //   9157: astore 32
    //   9159: new 980	java/io/File
    //   9162: dup
    //   9163: ldc_w 1238
    //   9166: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9169: invokevirtual 988	java/io/File:exists	()Z
    //   9172: ifeq +8 -> 9180
    //   9175: ldc_w 1240
    //   9178: astore 32
    //   9180: new 980	java/io/File
    //   9183: dup
    //   9184: ldc_w 1242
    //   9187: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9190: invokevirtual 988	java/io/File:exists	()Z
    //   9193: ifeq +8 -> 9201
    //   9196: ldc_w 1244
    //   9199: astore 32
    //   9201: new 980	java/io/File
    //   9204: dup
    //   9205: ldc_w 1246
    //   9208: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9211: invokevirtual 988	java/io/File:exists	()Z
    //   9214: ifeq +8 -> 9222
    //   9217: ldc_w 1232
    //   9220: astore 32
    //   9222: new 980	java/io/File
    //   9225: dup
    //   9226: ldc_w 1248
    //   9229: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9232: invokevirtual 988	java/io/File:exists	()Z
    //   9235: ifeq +8 -> 9243
    //   9238: ldc_w 1236
    //   9241: astore 32
    //   9243: new 980	java/io/File
    //   9246: dup
    //   9247: ldc_w 1250
    //   9250: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9253: invokevirtual 988	java/io/File:exists	()Z
    //   9256: ifeq +8 -> 9264
    //   9259: ldc_w 1240
    //   9262: astore 32
    //   9264: aload 36
    //   9266: astore 33
    //   9268: aload 35
    //   9270: astore 34
    //   9272: new 980	java/io/File
    //   9275: dup
    //   9276: ldc_w 1252
    //   9279: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9282: invokevirtual 988	java/io/File:exists	()Z
    //   9285: ifeq +16 -> 9301
    //   9288: ldc_w 1244
    //   9291: astore 32
    //   9293: aload 35
    //   9295: astore 34
    //   9297: aload 36
    //   9299: astore 33
    //   9301: aload 32
    //   9303: ldc_w 299
    //   9306: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9309: ifne +5882 -> 15191
    //   9312: getstatic 1014	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:api	I
    //   9315: bipush 21
    //   9317: if_icmplt +5874 -> 15191
    //   9320: iconst_0
    //   9321: istore 14
    //   9323: iconst_0
    //   9324: istore 4
    //   9326: iconst_0
    //   9327: istore 11
    //   9329: iconst_0
    //   9330: istore_3
    //   9331: iconst_0
    //   9332: istore 5
    //   9334: iconst_0
    //   9335: istore 10
    //   9337: iconst_0
    //   9338: istore 7
    //   9340: iconst_0
    //   9341: istore 9
    //   9343: iconst_0
    //   9344: istore 13
    //   9346: iconst_0
    //   9347: istore 6
    //   9349: iconst_0
    //   9350: istore 12
    //   9352: iconst_0
    //   9353: istore 8
    //   9355: new 980	java/io/File
    //   9358: dup
    //   9359: new 1031	java/lang/StringBuilder
    //   9362: dup
    //   9363: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   9366: aload 34
    //   9368: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9371: aload 32
    //   9373: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9376: aload 33
    //   9378: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9381: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9384: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9387: astore 35
    //   9389: iconst_1
    //   9390: istore 15
    //   9392: iload 15
    //   9394: istore_2
    //   9395: new 980	java/io/File
    //   9398: dup
    //   9399: new 1031	java/lang/StringBuilder
    //   9402: dup
    //   9403: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   9406: aload 34
    //   9408: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9411: aload 32
    //   9413: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9416: ldc_w 1254
    //   9419: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9422: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9425: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9428: invokevirtual 988	java/io/File:exists	()Z
    //   9431: ifeq +119 -> 9550
    //   9434: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   9437: ldc_w 1256
    //   9440: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   9443: new 980	java/io/File
    //   9446: dup
    //   9447: new 1031	java/lang/StringBuilder
    //   9450: dup
    //   9451: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   9454: aload 34
    //   9456: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9459: aload 32
    //   9461: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9464: ldc_w 1254
    //   9467: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9470: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9473: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9476: new 1031	java/lang/StringBuilder
    //   9479: dup
    //   9480: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   9483: ldc_w 1202
    //   9486: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9489: aload 32
    //   9491: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9494: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9497: invokestatic 1260	com/chelpus/Utils:XZDecompress	(Ljava/io/File;Ljava/lang/String;)Z
    //   9500: ifne +10650 -> 20150
    //   9503: iconst_0
    //   9504: istore_2
    //   9505: new 980	java/io/File
    //   9508: dup
    //   9509: new 1031	java/lang/StringBuilder
    //   9512: dup
    //   9513: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   9516: aload 34
    //   9518: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9521: aload 32
    //   9523: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9526: aload 33
    //   9528: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9531: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9534: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   9537: invokevirtual 1132	java/io/File:delete	()Z
    //   9540: pop
    //   9541: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   9544: ldc_w 1262
    //   9547: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   9550: iload_2
    //   9551: ifeq +10866 -> 20417
    //   9554: iload 4
    //   9556: istore_2
    //   9557: iload 5
    //   9559: istore_3
    //   9560: iload 9
    //   9562: istore 7
    //   9564: iload 12
    //   9566: istore 6
    //   9568: new 1047	java/io/RandomAccessFile
    //   9571: dup
    //   9572: aload 35
    //   9574: ldc_w 914
    //   9577: invokespecial 1050	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   9580: invokevirtual 1054	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   9583: astore 32
    //   9585: iload 4
    //   9587: istore_2
    //   9588: iload 5
    //   9590: istore_3
    //   9591: iload 9
    //   9593: istore 7
    //   9595: iload 12
    //   9597: istore 6
    //   9599: aload 32
    //   9601: getstatic 1060	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   9604: lconst_0
    //   9605: aload 32
    //   9607: invokevirtual 1065	java/nio/channels/FileChannel:size	()J
    //   9610: l2i
    //   9611: i2l
    //   9612: invokevirtual 1069	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   9615: putstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   9618: iload 4
    //   9620: istore_2
    //   9621: iload 5
    //   9623: istore_3
    //   9624: iload 9
    //   9626: istore 7
    //   9628: iload 12
    //   9630: istore 6
    //   9632: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   9635: sipush 4120
    //   9638: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   9641: pop
    //   9642: iload 4
    //   9644: istore_2
    //   9645: iload 5
    //   9647: istore_3
    //   9648: iload 9
    //   9650: istore 7
    //   9652: iload 12
    //   9654: istore 6
    //   9656: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   9659: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   9662: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   9665: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   9668: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   9671: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   9674: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   9677: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   9680: invokestatic 1073	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   9683: istore 14
    //   9685: iload 4
    //   9687: istore_2
    //   9688: iload 5
    //   9690: istore_3
    //   9691: iload 9
    //   9693: istore 7
    //   9695: iload 12
    //   9697: istore 6
    //   9699: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   9702: new 1031	java/lang/StringBuilder
    //   9705: dup
    //   9706: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   9709: ldc_w 1075
    //   9712: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9715: iload 14
    //   9717: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9720: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9723: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   9726: iload 4
    //   9728: istore_2
    //   9729: iload 5
    //   9731: istore_3
    //   9732: iload 9
    //   9734: istore 7
    //   9736: iload 12
    //   9738: istore 6
    //   9740: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   9743: iload 14
    //   9745: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   9748: pop
    //   9749: iload 11
    //   9751: istore 12
    //   9753: iload 10
    //   9755: istore 14
    //   9757: iload 13
    //   9759: istore 15
    //   9761: iload 8
    //   9763: istore 16
    //   9765: iload 11
    //   9767: istore 4
    //   9769: iload 10
    //   9771: istore 5
    //   9773: iload 13
    //   9775: istore 17
    //   9777: iload 8
    //   9779: istore 9
    //   9781: iload 11
    //   9783: istore_2
    //   9784: iload 10
    //   9786: istore_3
    //   9787: iload 13
    //   9789: istore 7
    //   9791: iload 8
    //   9793: istore 6
    //   9795: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   9798: invokevirtual 1081	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   9801: ifeq +5210 -> 15011
    //   9804: iload 11
    //   9806: istore 4
    //   9808: iload 10
    //   9810: istore 5
    //   9812: iload 13
    //   9814: istore 17
    //   9816: iload 8
    //   9818: istore 9
    //   9820: iload 11
    //   9822: istore_2
    //   9823: iload 10
    //   9825: istore_3
    //   9826: iload 13
    //   9828: istore 7
    //   9830: iload 8
    //   9832: istore 6
    //   9834: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   9837: invokevirtual 1083	java/nio/MappedByteBuffer:position	()I
    //   9840: istore 15
    //   9842: iload 11
    //   9844: istore 4
    //   9846: iload 10
    //   9848: istore 5
    //   9850: iload 13
    //   9852: istore 17
    //   9854: iload 8
    //   9856: istore 9
    //   9858: iload 11
    //   9860: istore_2
    //   9861: iload 10
    //   9863: istore_3
    //   9864: iload 13
    //   9866: istore 7
    //   9868: iload 8
    //   9870: istore 6
    //   9872: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   9875: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   9878: istore_1
    //   9879: iload 11
    //   9881: istore 12
    //   9883: iload 11
    //   9885: istore 4
    //   9887: iload 10
    //   9889: istore 5
    //   9891: iload 13
    //   9893: istore 17
    //   9895: iload 8
    //   9897: istore 9
    //   9899: iload 11
    //   9901: istore_2
    //   9902: iload 10
    //   9904: istore_3
    //   9905: iload 13
    //   9907: istore 7
    //   9909: iload 8
    //   9911: istore 6
    //   9913: iload 15
    //   9915: iload_1
    //   9916: getstatic 449	com/chelpus/root/utils/corepatch:byteOrigSOat1	[B
    //   9919: getstatic 451	com/chelpus/root/utils/corepatch:maskSOat1	[B
    //   9922: getstatic 453	com/chelpus/root/utils/corepatch:byteReplaceSOat1	[B
    //   9925: getstatic 455	com/chelpus/root/utils/corepatch:rep_maskSOat1	[B
    //   9928: iload 25
    //   9930: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   9933: ifeq +168 -> 10101
    //   9936: iload 11
    //   9938: istore 4
    //   9940: iload 10
    //   9942: istore 5
    //   9944: iload 13
    //   9946: istore 17
    //   9948: iload 8
    //   9950: istore 9
    //   9952: iload 11
    //   9954: istore_2
    //   9955: iload 10
    //   9957: istore_3
    //   9958: iload 13
    //   9960: istore 7
    //   9962: iload 8
    //   9964: istore 6
    //   9966: aload_0
    //   9967: iconst_0
    //   9968: aaload
    //   9969: ldc_w 946
    //   9972: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   9975: ifeq +42 -> 10017
    //   9978: iload 11
    //   9980: istore 4
    //   9982: iload 10
    //   9984: istore 5
    //   9986: iload 13
    //   9988: istore 17
    //   9990: iload 8
    //   9992: istore 9
    //   9994: iload 11
    //   9996: istore_2
    //   9997: iload 10
    //   9999: istore_3
    //   10000: iload 13
    //   10002: istore 7
    //   10004: iload 8
    //   10006: istore 6
    //   10008: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   10011: ldc_w 1264
    //   10014: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   10017: iload 11
    //   10019: istore 4
    //   10021: iload 10
    //   10023: istore 5
    //   10025: iload 13
    //   10027: istore 17
    //   10029: iload 8
    //   10031: istore 9
    //   10033: iload 11
    //   10035: istore_2
    //   10036: iload 10
    //   10038: istore_3
    //   10039: iload 13
    //   10041: istore 7
    //   10043: iload 8
    //   10045: istore 6
    //   10047: aload_0
    //   10048: iconst_0
    //   10049: aaload
    //   10050: ldc_w 963
    //   10053: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10056: ifeq +15312 -> 25368
    //   10059: iload 11
    //   10061: istore 4
    //   10063: iload 10
    //   10065: istore 5
    //   10067: iload 13
    //   10069: istore 17
    //   10071: iload 8
    //   10073: istore 9
    //   10075: iload 11
    //   10077: istore_2
    //   10078: iload 10
    //   10080: istore_3
    //   10081: iload 13
    //   10083: istore 7
    //   10085: iload 8
    //   10087: istore 6
    //   10089: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   10092: ldc_w 1266
    //   10095: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   10098: goto +15270 -> 25368
    //   10101: iload 12
    //   10103: istore 11
    //   10105: iload 12
    //   10107: istore 4
    //   10109: iload 10
    //   10111: istore 5
    //   10113: iload 13
    //   10115: istore 17
    //   10117: iload 8
    //   10119: istore 9
    //   10121: iload 12
    //   10123: istore_2
    //   10124: iload 10
    //   10126: istore_3
    //   10127: iload 13
    //   10129: istore 7
    //   10131: iload 8
    //   10133: istore 6
    //   10135: iload 15
    //   10137: iload_1
    //   10138: getstatic 457	com/chelpus/root/utils/corepatch:byteOrigSOat6_1	[B
    //   10141: getstatic 459	com/chelpus/root/utils/corepatch:maskSOat6_1	[B
    //   10144: getstatic 461	com/chelpus/root/utils/corepatch:byteReplaceSOat6_1	[B
    //   10147: getstatic 463	com/chelpus/root/utils/corepatch:rep_maskSOat6_1	[B
    //   10150: iload 25
    //   10152: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   10155: ifeq +168 -> 10323
    //   10158: iload 12
    //   10160: istore 4
    //   10162: iload 10
    //   10164: istore 5
    //   10166: iload 13
    //   10168: istore 17
    //   10170: iload 8
    //   10172: istore 9
    //   10174: iload 12
    //   10176: istore_2
    //   10177: iload 10
    //   10179: istore_3
    //   10180: iload 13
    //   10182: istore 7
    //   10184: iload 8
    //   10186: istore 6
    //   10188: aload_0
    //   10189: iconst_0
    //   10190: aaload
    //   10191: ldc_w 946
    //   10194: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10197: ifeq +42 -> 10239
    //   10200: iload 12
    //   10202: istore 4
    //   10204: iload 10
    //   10206: istore 5
    //   10208: iload 13
    //   10210: istore 17
    //   10212: iload 8
    //   10214: istore 9
    //   10216: iload 12
    //   10218: istore_2
    //   10219: iload 10
    //   10221: istore_3
    //   10222: iload 13
    //   10224: istore 7
    //   10226: iload 8
    //   10228: istore 6
    //   10230: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   10233: ldc_w 1264
    //   10236: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   10239: iload 12
    //   10241: istore 4
    //   10243: iload 10
    //   10245: istore 5
    //   10247: iload 13
    //   10249: istore 17
    //   10251: iload 8
    //   10253: istore 9
    //   10255: iload 12
    //   10257: istore_2
    //   10258: iload 10
    //   10260: istore_3
    //   10261: iload 13
    //   10263: istore 7
    //   10265: iload 8
    //   10267: istore 6
    //   10269: aload_0
    //   10270: iconst_0
    //   10271: aaload
    //   10272: ldc_w 963
    //   10275: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10278: ifeq +15096 -> 25374
    //   10281: iload 12
    //   10283: istore 4
    //   10285: iload 10
    //   10287: istore 5
    //   10289: iload 13
    //   10291: istore 17
    //   10293: iload 8
    //   10295: istore 9
    //   10297: iload 12
    //   10299: istore_2
    //   10300: iload 10
    //   10302: istore_3
    //   10303: iload 13
    //   10305: istore 7
    //   10307: iload 8
    //   10309: istore 6
    //   10311: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   10314: ldc_w 1266
    //   10317: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   10320: goto +15054 -> 25374
    //   10323: iload 10
    //   10325: istore 12
    //   10327: iload 11
    //   10329: istore 4
    //   10331: iload 10
    //   10333: istore 5
    //   10335: iload 13
    //   10337: istore 17
    //   10339: iload 8
    //   10341: istore 9
    //   10343: iload 11
    //   10345: istore_2
    //   10346: iload 10
    //   10348: istore_3
    //   10349: iload 13
    //   10351: istore 7
    //   10353: iload 8
    //   10355: istore 6
    //   10357: iload 15
    //   10359: iload_1
    //   10360: getstatic 465	com/chelpus/root/utils/corepatch:byteOrigSOat2	[B
    //   10363: getstatic 467	com/chelpus/root/utils/corepatch:maskSOat2	[B
    //   10366: getstatic 469	com/chelpus/root/utils/corepatch:byteReplaceSOat2	[B
    //   10369: getstatic 471	com/chelpus/root/utils/corepatch:rep_maskSOat2	[B
    //   10372: iload 25
    //   10374: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   10377: ifeq +168 -> 10545
    //   10380: iload 11
    //   10382: istore 4
    //   10384: iload 10
    //   10386: istore 5
    //   10388: iload 13
    //   10390: istore 17
    //   10392: iload 8
    //   10394: istore 9
    //   10396: iload 11
    //   10398: istore_2
    //   10399: iload 10
    //   10401: istore_3
    //   10402: iload 13
    //   10404: istore 7
    //   10406: iload 8
    //   10408: istore 6
    //   10410: aload_0
    //   10411: iconst_0
    //   10412: aaload
    //   10413: ldc_w 946
    //   10416: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10419: ifeq +42 -> 10461
    //   10422: iload 11
    //   10424: istore 4
    //   10426: iload 10
    //   10428: istore 5
    //   10430: iload 13
    //   10432: istore 17
    //   10434: iload 8
    //   10436: istore 9
    //   10438: iload 11
    //   10440: istore_2
    //   10441: iload 10
    //   10443: istore_3
    //   10444: iload 13
    //   10446: istore 7
    //   10448: iload 8
    //   10450: istore 6
    //   10452: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   10455: ldc_w 1268
    //   10458: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   10461: iload 11
    //   10463: istore 4
    //   10465: iload 10
    //   10467: istore 5
    //   10469: iload 13
    //   10471: istore 17
    //   10473: iload 8
    //   10475: istore 9
    //   10477: iload 11
    //   10479: istore_2
    //   10480: iload 10
    //   10482: istore_3
    //   10483: iload 13
    //   10485: istore 7
    //   10487: iload 8
    //   10489: istore 6
    //   10491: aload_0
    //   10492: iconst_0
    //   10493: aaload
    //   10494: ldc_w 963
    //   10497: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10500: ifeq +14880 -> 25380
    //   10503: iload 11
    //   10505: istore 4
    //   10507: iload 10
    //   10509: istore 5
    //   10511: iload 13
    //   10513: istore 17
    //   10515: iload 8
    //   10517: istore 9
    //   10519: iload 11
    //   10521: istore_2
    //   10522: iload 10
    //   10524: istore_3
    //   10525: iload 13
    //   10527: istore 7
    //   10529: iload 8
    //   10531: istore 6
    //   10533: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   10536: ldc_w 1270
    //   10539: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   10542: goto +14838 -> 25380
    //   10545: iload 12
    //   10547: istore 14
    //   10549: iload 11
    //   10551: istore 4
    //   10553: iload 12
    //   10555: istore 5
    //   10557: iload 13
    //   10559: istore 17
    //   10561: iload 8
    //   10563: istore 9
    //   10565: iload 11
    //   10567: istore_2
    //   10568: iload 12
    //   10570: istore_3
    //   10571: iload 13
    //   10573: istore 7
    //   10575: iload 8
    //   10577: istore 6
    //   10579: iload 15
    //   10581: iload_1
    //   10582: getstatic 473	com/chelpus/root/utils/corepatch:byteOrigSOat6_2	[B
    //   10585: getstatic 475	com/chelpus/root/utils/corepatch:maskSOat6_2	[B
    //   10588: getstatic 477	com/chelpus/root/utils/corepatch:byteReplaceSOat6_2	[B
    //   10591: getstatic 479	com/chelpus/root/utils/corepatch:rep_maskSOat6_2	[B
    //   10594: iload 25
    //   10596: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   10599: ifeq +168 -> 10767
    //   10602: iload 11
    //   10604: istore 4
    //   10606: iload 12
    //   10608: istore 5
    //   10610: iload 13
    //   10612: istore 17
    //   10614: iload 8
    //   10616: istore 9
    //   10618: iload 11
    //   10620: istore_2
    //   10621: iload 12
    //   10623: istore_3
    //   10624: iload 13
    //   10626: istore 7
    //   10628: iload 8
    //   10630: istore 6
    //   10632: aload_0
    //   10633: iconst_0
    //   10634: aaload
    //   10635: ldc_w 946
    //   10638: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10641: ifeq +42 -> 10683
    //   10644: iload 11
    //   10646: istore 4
    //   10648: iload 12
    //   10650: istore 5
    //   10652: iload 13
    //   10654: istore 17
    //   10656: iload 8
    //   10658: istore 9
    //   10660: iload 11
    //   10662: istore_2
    //   10663: iload 12
    //   10665: istore_3
    //   10666: iload 13
    //   10668: istore 7
    //   10670: iload 8
    //   10672: istore 6
    //   10674: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   10677: ldc_w 1268
    //   10680: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   10683: iload 11
    //   10685: istore 4
    //   10687: iload 12
    //   10689: istore 5
    //   10691: iload 13
    //   10693: istore 17
    //   10695: iload 8
    //   10697: istore 9
    //   10699: iload 11
    //   10701: istore_2
    //   10702: iload 12
    //   10704: istore_3
    //   10705: iload 13
    //   10707: istore 7
    //   10709: iload 8
    //   10711: istore 6
    //   10713: aload_0
    //   10714: iconst_0
    //   10715: aaload
    //   10716: ldc_w 963
    //   10719: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10722: ifeq +14664 -> 25386
    //   10725: iload 11
    //   10727: istore 4
    //   10729: iload 12
    //   10731: istore 5
    //   10733: iload 13
    //   10735: istore 17
    //   10737: iload 8
    //   10739: istore 9
    //   10741: iload 11
    //   10743: istore_2
    //   10744: iload 12
    //   10746: istore_3
    //   10747: iload 13
    //   10749: istore 7
    //   10751: iload 8
    //   10753: istore 6
    //   10755: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   10758: ldc_w 1270
    //   10761: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   10764: goto +14622 -> 25386
    //   10767: iload 14
    //   10769: istore 10
    //   10771: iload 11
    //   10773: istore 4
    //   10775: iload 14
    //   10777: istore 5
    //   10779: iload 13
    //   10781: istore 17
    //   10783: iload 8
    //   10785: istore 9
    //   10787: iload 11
    //   10789: istore_2
    //   10790: iload 14
    //   10792: istore_3
    //   10793: iload 13
    //   10795: istore 7
    //   10797: iload 8
    //   10799: istore 6
    //   10801: iload 15
    //   10803: iload_1
    //   10804: getstatic 481	com/chelpus/root/utils/corepatch:byteOrigSOat6_3	[B
    //   10807: getstatic 483	com/chelpus/root/utils/corepatch:maskSOat6_3	[B
    //   10810: getstatic 485	com/chelpus/root/utils/corepatch:byteReplaceSOat6_3	[B
    //   10813: getstatic 487	com/chelpus/root/utils/corepatch:rep_maskSOat6_3	[B
    //   10816: iload 25
    //   10818: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   10821: ifeq +168 -> 10989
    //   10824: iload 11
    //   10826: istore 4
    //   10828: iload 14
    //   10830: istore 5
    //   10832: iload 13
    //   10834: istore 17
    //   10836: iload 8
    //   10838: istore 9
    //   10840: iload 11
    //   10842: istore_2
    //   10843: iload 14
    //   10845: istore_3
    //   10846: iload 13
    //   10848: istore 7
    //   10850: iload 8
    //   10852: istore 6
    //   10854: aload_0
    //   10855: iconst_0
    //   10856: aaload
    //   10857: ldc_w 946
    //   10860: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10863: ifeq +42 -> 10905
    //   10866: iload 11
    //   10868: istore 4
    //   10870: iload 14
    //   10872: istore 5
    //   10874: iload 13
    //   10876: istore 17
    //   10878: iload 8
    //   10880: istore 9
    //   10882: iload 11
    //   10884: istore_2
    //   10885: iload 14
    //   10887: istore_3
    //   10888: iload 13
    //   10890: istore 7
    //   10892: iload 8
    //   10894: istore 6
    //   10896: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   10899: ldc_w 1268
    //   10902: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   10905: iload 11
    //   10907: istore 4
    //   10909: iload 14
    //   10911: istore 5
    //   10913: iload 13
    //   10915: istore 17
    //   10917: iload 8
    //   10919: istore 9
    //   10921: iload 11
    //   10923: istore_2
    //   10924: iload 14
    //   10926: istore_3
    //   10927: iload 13
    //   10929: istore 7
    //   10931: iload 8
    //   10933: istore 6
    //   10935: aload_0
    //   10936: iconst_0
    //   10937: aaload
    //   10938: ldc_w 963
    //   10941: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10944: ifeq +14448 -> 25392
    //   10947: iload 11
    //   10949: istore 4
    //   10951: iload 14
    //   10953: istore 5
    //   10955: iload 13
    //   10957: istore 17
    //   10959: iload 8
    //   10961: istore 9
    //   10963: iload 11
    //   10965: istore_2
    //   10966: iload 14
    //   10968: istore_3
    //   10969: iload 13
    //   10971: istore 7
    //   10973: iload 8
    //   10975: istore 6
    //   10977: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   10980: ldc_w 1270
    //   10983: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   10986: goto +14406 -> 25392
    //   10989: iload 13
    //   10991: istore 12
    //   10993: iload 11
    //   10995: istore 4
    //   10997: iload 10
    //   10999: istore 5
    //   11001: iload 13
    //   11003: istore 17
    //   11005: iload 8
    //   11007: istore 9
    //   11009: iload 11
    //   11011: istore_2
    //   11012: iload 10
    //   11014: istore_3
    //   11015: iload 13
    //   11017: istore 7
    //   11019: iload 8
    //   11021: istore 6
    //   11023: iload 15
    //   11025: iload_1
    //   11026: getstatic 489	com/chelpus/root/utils/corepatch:byteOrigSOat3	[B
    //   11029: getstatic 491	com/chelpus/root/utils/corepatch:maskSOat3	[B
    //   11032: getstatic 493	com/chelpus/root/utils/corepatch:byteReplaceSOat3	[B
    //   11035: getstatic 495	com/chelpus/root/utils/corepatch:rep_maskSOat3	[B
    //   11038: iload 25
    //   11040: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   11043: ifeq +168 -> 11211
    //   11046: iload 11
    //   11048: istore 4
    //   11050: iload 10
    //   11052: istore 5
    //   11054: iload 13
    //   11056: istore 17
    //   11058: iload 8
    //   11060: istore 9
    //   11062: iload 11
    //   11064: istore_2
    //   11065: iload 10
    //   11067: istore_3
    //   11068: iload 13
    //   11070: istore 7
    //   11072: iload 8
    //   11074: istore 6
    //   11076: aload_0
    //   11077: iconst_0
    //   11078: aaload
    //   11079: ldc_w 946
    //   11082: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11085: ifeq +42 -> 11127
    //   11088: iload 11
    //   11090: istore 4
    //   11092: iload 10
    //   11094: istore 5
    //   11096: iload 13
    //   11098: istore 17
    //   11100: iload 8
    //   11102: istore 9
    //   11104: iload 11
    //   11106: istore_2
    //   11107: iload 10
    //   11109: istore_3
    //   11110: iload 13
    //   11112: istore 7
    //   11114: iload 8
    //   11116: istore 6
    //   11118: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   11121: ldc_w 1272
    //   11124: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   11127: iload 11
    //   11129: istore 4
    //   11131: iload 10
    //   11133: istore 5
    //   11135: iload 13
    //   11137: istore 17
    //   11139: iload 8
    //   11141: istore 9
    //   11143: iload 11
    //   11145: istore_2
    //   11146: iload 10
    //   11148: istore_3
    //   11149: iload 13
    //   11151: istore 7
    //   11153: iload 8
    //   11155: istore 6
    //   11157: aload_0
    //   11158: iconst_0
    //   11159: aaload
    //   11160: ldc_w 963
    //   11163: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11166: ifeq +14232 -> 25398
    //   11169: iload 11
    //   11171: istore 4
    //   11173: iload 10
    //   11175: istore 5
    //   11177: iload 13
    //   11179: istore 17
    //   11181: iload 8
    //   11183: istore 9
    //   11185: iload 11
    //   11187: istore_2
    //   11188: iload 10
    //   11190: istore_3
    //   11191: iload 13
    //   11193: istore 7
    //   11195: iload 8
    //   11197: istore 6
    //   11199: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   11202: ldc_w 1274
    //   11205: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   11208: goto +14190 -> 25398
    //   11211: iload 8
    //   11213: istore 13
    //   11215: iload 11
    //   11217: istore 4
    //   11219: iload 10
    //   11221: istore 5
    //   11223: iload 12
    //   11225: istore 17
    //   11227: iload 8
    //   11229: istore 9
    //   11231: iload 11
    //   11233: istore_2
    //   11234: iload 10
    //   11236: istore_3
    //   11237: iload 12
    //   11239: istore 7
    //   11241: iload 8
    //   11243: istore 6
    //   11245: iload 15
    //   11247: iload_1
    //   11248: getstatic 497	com/chelpus/root/utils/corepatch:byteOrigSOat6	[B
    //   11251: getstatic 499	com/chelpus/root/utils/corepatch:maskSOat6	[B
    //   11254: getstatic 501	com/chelpus/root/utils/corepatch:byteReplaceSOat6	[B
    //   11257: getstatic 503	com/chelpus/root/utils/corepatch:rep_maskSOat6	[B
    //   11260: iload 25
    //   11262: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   11265: ifeq +168 -> 11433
    //   11268: iload 11
    //   11270: istore 4
    //   11272: iload 10
    //   11274: istore 5
    //   11276: iload 12
    //   11278: istore 17
    //   11280: iload 8
    //   11282: istore 9
    //   11284: iload 11
    //   11286: istore_2
    //   11287: iload 10
    //   11289: istore_3
    //   11290: iload 12
    //   11292: istore 7
    //   11294: iload 8
    //   11296: istore 6
    //   11298: aload_0
    //   11299: iconst_0
    //   11300: aaload
    //   11301: ldc_w 946
    //   11304: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11307: ifeq +42 -> 11349
    //   11310: iload 11
    //   11312: istore 4
    //   11314: iload 10
    //   11316: istore 5
    //   11318: iload 12
    //   11320: istore 17
    //   11322: iload 8
    //   11324: istore 9
    //   11326: iload 11
    //   11328: istore_2
    //   11329: iload 10
    //   11331: istore_3
    //   11332: iload 12
    //   11334: istore 7
    //   11336: iload 8
    //   11338: istore 6
    //   11340: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   11343: ldc_w 1276
    //   11346: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   11349: iload 11
    //   11351: istore 4
    //   11353: iload 10
    //   11355: istore 5
    //   11357: iload 12
    //   11359: istore 17
    //   11361: iload 8
    //   11363: istore 9
    //   11365: iload 11
    //   11367: istore_2
    //   11368: iload 10
    //   11370: istore_3
    //   11371: iload 12
    //   11373: istore 7
    //   11375: iload 8
    //   11377: istore 6
    //   11379: aload_0
    //   11380: iconst_0
    //   11381: aaload
    //   11382: ldc_w 963
    //   11385: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11388: ifeq +14016 -> 25404
    //   11391: iload 11
    //   11393: istore 4
    //   11395: iload 10
    //   11397: istore 5
    //   11399: iload 12
    //   11401: istore 17
    //   11403: iload 8
    //   11405: istore 9
    //   11407: iload 11
    //   11409: istore_2
    //   11410: iload 10
    //   11412: istore_3
    //   11413: iload 12
    //   11415: istore 7
    //   11417: iload 8
    //   11419: istore 6
    //   11421: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   11424: ldc_w 1278
    //   11427: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   11430: goto +13974 -> 25404
    //   11433: iload 13
    //   11435: istore 14
    //   11437: iload 11
    //   11439: istore 4
    //   11441: iload 10
    //   11443: istore 5
    //   11445: iload 12
    //   11447: istore 17
    //   11449: iload 13
    //   11451: istore 9
    //   11453: iload 11
    //   11455: istore_2
    //   11456: iload 10
    //   11458: istore_3
    //   11459: iload 12
    //   11461: istore 7
    //   11463: iload 13
    //   11465: istore 6
    //   11467: iload 15
    //   11469: iload_1
    //   11470: getstatic 505	com/chelpus/root/utils/corepatch:byteOrigSOat7	[B
    //   11473: getstatic 507	com/chelpus/root/utils/corepatch:maskSOat7	[B
    //   11476: getstatic 509	com/chelpus/root/utils/corepatch:byteReplaceSOat7	[B
    //   11479: getstatic 511	com/chelpus/root/utils/corepatch:rep_maskSOat7	[B
    //   11482: iload 25
    //   11484: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   11487: ifeq +168 -> 11655
    //   11490: iload 11
    //   11492: istore 4
    //   11494: iload 10
    //   11496: istore 5
    //   11498: iload 12
    //   11500: istore 17
    //   11502: iload 13
    //   11504: istore 9
    //   11506: iload 11
    //   11508: istore_2
    //   11509: iload 10
    //   11511: istore_3
    //   11512: iload 12
    //   11514: istore 7
    //   11516: iload 13
    //   11518: istore 6
    //   11520: aload_0
    //   11521: iconst_0
    //   11522: aaload
    //   11523: ldc_w 946
    //   11526: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11529: ifeq +42 -> 11571
    //   11532: iload 11
    //   11534: istore 4
    //   11536: iload 10
    //   11538: istore 5
    //   11540: iload 12
    //   11542: istore 17
    //   11544: iload 13
    //   11546: istore 9
    //   11548: iload 11
    //   11550: istore_2
    //   11551: iload 10
    //   11553: istore_3
    //   11554: iload 12
    //   11556: istore 7
    //   11558: iload 13
    //   11560: istore 6
    //   11562: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   11565: ldc_w 1276
    //   11568: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   11571: iload 11
    //   11573: istore 4
    //   11575: iload 10
    //   11577: istore 5
    //   11579: iload 12
    //   11581: istore 17
    //   11583: iload 13
    //   11585: istore 9
    //   11587: iload 11
    //   11589: istore_2
    //   11590: iload 10
    //   11592: istore_3
    //   11593: iload 12
    //   11595: istore 7
    //   11597: iload 13
    //   11599: istore 6
    //   11601: aload_0
    //   11602: iconst_0
    //   11603: aaload
    //   11604: ldc_w 963
    //   11607: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11610: ifeq +13800 -> 25410
    //   11613: iload 11
    //   11615: istore 4
    //   11617: iload 10
    //   11619: istore 5
    //   11621: iload 12
    //   11623: istore 17
    //   11625: iload 13
    //   11627: istore 9
    //   11629: iload 11
    //   11631: istore_2
    //   11632: iload 10
    //   11634: istore_3
    //   11635: iload 12
    //   11637: istore 7
    //   11639: iload 13
    //   11641: istore 6
    //   11643: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   11646: ldc_w 1278
    //   11649: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   11652: goto +13758 -> 25410
    //   11655: iload 14
    //   11657: istore 8
    //   11659: iload 11
    //   11661: istore 4
    //   11663: iload 10
    //   11665: istore 5
    //   11667: iload 12
    //   11669: istore 17
    //   11671: iload 14
    //   11673: istore 9
    //   11675: iload 11
    //   11677: istore_2
    //   11678: iload 10
    //   11680: istore_3
    //   11681: iload 12
    //   11683: istore 7
    //   11685: iload 14
    //   11687: istore 6
    //   11689: iload 15
    //   11691: iload_1
    //   11692: getstatic 513	com/chelpus/root/utils/corepatch:byteOrigSOat7_2	[B
    //   11695: getstatic 515	com/chelpus/root/utils/corepatch:maskSOat7_2	[B
    //   11698: getstatic 517	com/chelpus/root/utils/corepatch:byteReplaceSOat7_2	[B
    //   11701: getstatic 519	com/chelpus/root/utils/corepatch:rep_maskSOat7_2	[B
    //   11704: iload 25
    //   11706: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   11709: ifeq +168 -> 11877
    //   11712: iload 11
    //   11714: istore 4
    //   11716: iload 10
    //   11718: istore 5
    //   11720: iload 12
    //   11722: istore 17
    //   11724: iload 14
    //   11726: istore 9
    //   11728: iload 11
    //   11730: istore_2
    //   11731: iload 10
    //   11733: istore_3
    //   11734: iload 12
    //   11736: istore 7
    //   11738: iload 14
    //   11740: istore 6
    //   11742: aload_0
    //   11743: iconst_0
    //   11744: aaload
    //   11745: ldc_w 946
    //   11748: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11751: ifeq +42 -> 11793
    //   11754: iload 11
    //   11756: istore 4
    //   11758: iload 10
    //   11760: istore 5
    //   11762: iload 12
    //   11764: istore 17
    //   11766: iload 14
    //   11768: istore 9
    //   11770: iload 11
    //   11772: istore_2
    //   11773: iload 10
    //   11775: istore_3
    //   11776: iload 12
    //   11778: istore 7
    //   11780: iload 14
    //   11782: istore 6
    //   11784: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   11787: ldc_w 1276
    //   11790: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   11793: iload 11
    //   11795: istore 4
    //   11797: iload 10
    //   11799: istore 5
    //   11801: iload 12
    //   11803: istore 17
    //   11805: iload 14
    //   11807: istore 9
    //   11809: iload 11
    //   11811: istore_2
    //   11812: iload 10
    //   11814: istore_3
    //   11815: iload 12
    //   11817: istore 7
    //   11819: iload 14
    //   11821: istore 6
    //   11823: aload_0
    //   11824: iconst_0
    //   11825: aaload
    //   11826: ldc_w 963
    //   11829: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11832: ifeq +13584 -> 25416
    //   11835: iload 11
    //   11837: istore 4
    //   11839: iload 10
    //   11841: istore 5
    //   11843: iload 12
    //   11845: istore 17
    //   11847: iload 14
    //   11849: istore 9
    //   11851: iload 11
    //   11853: istore_2
    //   11854: iload 10
    //   11856: istore_3
    //   11857: iload 12
    //   11859: istore 7
    //   11861: iload 14
    //   11863: istore 6
    //   11865: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   11868: ldc_w 1278
    //   11871: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   11874: goto +13542 -> 25416
    //   11877: iload 11
    //   11879: istore 13
    //   11881: iload 11
    //   11883: istore 4
    //   11885: iload 10
    //   11887: istore 5
    //   11889: iload 12
    //   11891: istore 17
    //   11893: iload 8
    //   11895: istore 9
    //   11897: iload 11
    //   11899: istore_2
    //   11900: iload 10
    //   11902: istore_3
    //   11903: iload 12
    //   11905: istore 7
    //   11907: iload 8
    //   11909: istore 6
    //   11911: iload 15
    //   11913: iload_1
    //   11914: getstatic 521	com/chelpus/root/utils/corepatch:byteOrigSOat8	[B
    //   11917: getstatic 523	com/chelpus/root/utils/corepatch:maskSOat8	[B
    //   11920: getstatic 525	com/chelpus/root/utils/corepatch:byteReplaceSOat8	[B
    //   11923: getstatic 527	com/chelpus/root/utils/corepatch:rep_maskSOat8	[B
    //   11926: iload 25
    //   11928: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   11931: ifeq +168 -> 12099
    //   11934: iload 11
    //   11936: istore 4
    //   11938: iload 10
    //   11940: istore 5
    //   11942: iload 12
    //   11944: istore 17
    //   11946: iload 8
    //   11948: istore 9
    //   11950: iload 11
    //   11952: istore_2
    //   11953: iload 10
    //   11955: istore_3
    //   11956: iload 12
    //   11958: istore 7
    //   11960: iload 8
    //   11962: istore 6
    //   11964: aload_0
    //   11965: iconst_0
    //   11966: aaload
    //   11967: ldc_w 946
    //   11970: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11973: ifeq +42 -> 12015
    //   11976: iload 11
    //   11978: istore 4
    //   11980: iload 10
    //   11982: istore 5
    //   11984: iload 12
    //   11986: istore 17
    //   11988: iload 8
    //   11990: istore 9
    //   11992: iload 11
    //   11994: istore_2
    //   11995: iload 10
    //   11997: istore_3
    //   11998: iload 12
    //   12000: istore 7
    //   12002: iload 8
    //   12004: istore 6
    //   12006: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   12009: ldc_w 1264
    //   12012: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   12015: iload 11
    //   12017: istore 4
    //   12019: iload 10
    //   12021: istore 5
    //   12023: iload 12
    //   12025: istore 17
    //   12027: iload 8
    //   12029: istore 9
    //   12031: iload 11
    //   12033: istore_2
    //   12034: iload 10
    //   12036: istore_3
    //   12037: iload 12
    //   12039: istore 7
    //   12041: iload 8
    //   12043: istore 6
    //   12045: aload_0
    //   12046: iconst_0
    //   12047: aaload
    //   12048: ldc_w 963
    //   12051: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12054: ifeq +13368 -> 25422
    //   12057: iload 11
    //   12059: istore 4
    //   12061: iload 10
    //   12063: istore 5
    //   12065: iload 12
    //   12067: istore 17
    //   12069: iload 8
    //   12071: istore 9
    //   12073: iload 11
    //   12075: istore_2
    //   12076: iload 10
    //   12078: istore_3
    //   12079: iload 12
    //   12081: istore 7
    //   12083: iload 8
    //   12085: istore 6
    //   12087: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   12090: ldc_w 1266
    //   12093: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   12096: goto +13326 -> 25422
    //   12099: iload 13
    //   12101: istore 11
    //   12103: iload 13
    //   12105: istore 4
    //   12107: iload 10
    //   12109: istore 5
    //   12111: iload 12
    //   12113: istore 17
    //   12115: iload 8
    //   12117: istore 9
    //   12119: iload 13
    //   12121: istore_2
    //   12122: iload 10
    //   12124: istore_3
    //   12125: iload 12
    //   12127: istore 7
    //   12129: iload 8
    //   12131: istore 6
    //   12133: iload 15
    //   12135: iload_1
    //   12136: getstatic 529	com/chelpus/root/utils/corepatch:byteOrigSOat8_1	[B
    //   12139: getstatic 531	com/chelpus/root/utils/corepatch:maskSOat8_1	[B
    //   12142: getstatic 533	com/chelpus/root/utils/corepatch:byteReplaceSOat8_1	[B
    //   12145: getstatic 535	com/chelpus/root/utils/corepatch:rep_maskSOat8_1	[B
    //   12148: iload 25
    //   12150: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   12153: ifeq +168 -> 12321
    //   12156: iload 13
    //   12158: istore 4
    //   12160: iload 10
    //   12162: istore 5
    //   12164: iload 12
    //   12166: istore 17
    //   12168: iload 8
    //   12170: istore 9
    //   12172: iload 13
    //   12174: istore_2
    //   12175: iload 10
    //   12177: istore_3
    //   12178: iload 12
    //   12180: istore 7
    //   12182: iload 8
    //   12184: istore 6
    //   12186: aload_0
    //   12187: iconst_0
    //   12188: aaload
    //   12189: ldc_w 946
    //   12192: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12195: ifeq +42 -> 12237
    //   12198: iload 13
    //   12200: istore 4
    //   12202: iload 10
    //   12204: istore 5
    //   12206: iload 12
    //   12208: istore 17
    //   12210: iload 8
    //   12212: istore 9
    //   12214: iload 13
    //   12216: istore_2
    //   12217: iload 10
    //   12219: istore_3
    //   12220: iload 12
    //   12222: istore 7
    //   12224: iload 8
    //   12226: istore 6
    //   12228: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   12231: ldc_w 1264
    //   12234: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   12237: iload 13
    //   12239: istore 4
    //   12241: iload 10
    //   12243: istore 5
    //   12245: iload 12
    //   12247: istore 17
    //   12249: iload 8
    //   12251: istore 9
    //   12253: iload 13
    //   12255: istore_2
    //   12256: iload 10
    //   12258: istore_3
    //   12259: iload 12
    //   12261: istore 7
    //   12263: iload 8
    //   12265: istore 6
    //   12267: aload_0
    //   12268: iconst_0
    //   12269: aaload
    //   12270: ldc_w 963
    //   12273: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12276: ifeq +13152 -> 25428
    //   12279: iload 13
    //   12281: istore 4
    //   12283: iload 10
    //   12285: istore 5
    //   12287: iload 12
    //   12289: istore 17
    //   12291: iload 8
    //   12293: istore 9
    //   12295: iload 13
    //   12297: istore_2
    //   12298: iload 10
    //   12300: istore_3
    //   12301: iload 12
    //   12303: istore 7
    //   12305: iload 8
    //   12307: istore 6
    //   12309: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   12312: ldc_w 1266
    //   12315: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   12318: goto +13110 -> 25428
    //   12321: iload 10
    //   12323: istore 13
    //   12325: iload 11
    //   12327: istore 4
    //   12329: iload 10
    //   12331: istore 5
    //   12333: iload 12
    //   12335: istore 17
    //   12337: iload 8
    //   12339: istore 9
    //   12341: iload 11
    //   12343: istore_2
    //   12344: iload 10
    //   12346: istore_3
    //   12347: iload 12
    //   12349: istore 7
    //   12351: iload 8
    //   12353: istore 6
    //   12355: iload 15
    //   12357: iload_1
    //   12358: getstatic 537	com/chelpus/root/utils/corepatch:byteOrigSOat9	[B
    //   12361: getstatic 539	com/chelpus/root/utils/corepatch:maskSOat9	[B
    //   12364: getstatic 541	com/chelpus/root/utils/corepatch:byteReplaceSOat9	[B
    //   12367: getstatic 543	com/chelpus/root/utils/corepatch:rep_maskSOat9	[B
    //   12370: iload 25
    //   12372: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   12375: ifeq +168 -> 12543
    //   12378: iload 11
    //   12380: istore 4
    //   12382: iload 10
    //   12384: istore 5
    //   12386: iload 12
    //   12388: istore 17
    //   12390: iload 8
    //   12392: istore 9
    //   12394: iload 11
    //   12396: istore_2
    //   12397: iload 10
    //   12399: istore_3
    //   12400: iload 12
    //   12402: istore 7
    //   12404: iload 8
    //   12406: istore 6
    //   12408: aload_0
    //   12409: iconst_0
    //   12410: aaload
    //   12411: ldc_w 946
    //   12414: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12417: ifeq +42 -> 12459
    //   12420: iload 11
    //   12422: istore 4
    //   12424: iload 10
    //   12426: istore 5
    //   12428: iload 12
    //   12430: istore 17
    //   12432: iload 8
    //   12434: istore 9
    //   12436: iload 11
    //   12438: istore_2
    //   12439: iload 10
    //   12441: istore_3
    //   12442: iload 12
    //   12444: istore 7
    //   12446: iload 8
    //   12448: istore 6
    //   12450: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   12453: ldc_w 1268
    //   12456: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   12459: iload 11
    //   12461: istore 4
    //   12463: iload 10
    //   12465: istore 5
    //   12467: iload 12
    //   12469: istore 17
    //   12471: iload 8
    //   12473: istore 9
    //   12475: iload 11
    //   12477: istore_2
    //   12478: iload 10
    //   12480: istore_3
    //   12481: iload 12
    //   12483: istore 7
    //   12485: iload 8
    //   12487: istore 6
    //   12489: aload_0
    //   12490: iconst_0
    //   12491: aaload
    //   12492: ldc_w 963
    //   12495: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12498: ifeq +12936 -> 25434
    //   12501: iload 11
    //   12503: istore 4
    //   12505: iload 10
    //   12507: istore 5
    //   12509: iload 12
    //   12511: istore 17
    //   12513: iload 8
    //   12515: istore 9
    //   12517: iload 11
    //   12519: istore_2
    //   12520: iload 10
    //   12522: istore_3
    //   12523: iload 12
    //   12525: istore 7
    //   12527: iload 8
    //   12529: istore 6
    //   12531: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   12534: ldc_w 1270
    //   12537: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   12540: goto +12894 -> 25434
    //   12543: iload 13
    //   12545: istore 10
    //   12547: iload 11
    //   12549: istore 4
    //   12551: iload 13
    //   12553: istore 5
    //   12555: iload 12
    //   12557: istore 17
    //   12559: iload 8
    //   12561: istore 9
    //   12563: iload 11
    //   12565: istore_2
    //   12566: iload 13
    //   12568: istore_3
    //   12569: iload 12
    //   12571: istore 7
    //   12573: iload 8
    //   12575: istore 6
    //   12577: iload 15
    //   12579: iload_1
    //   12580: getstatic 545	com/chelpus/root/utils/corepatch:byteOrigSOat9_1	[B
    //   12583: getstatic 547	com/chelpus/root/utils/corepatch:maskSOat9_1	[B
    //   12586: getstatic 549	com/chelpus/root/utils/corepatch:byteReplaceSOat9_1	[B
    //   12589: getstatic 551	com/chelpus/root/utils/corepatch:rep_maskSOat9_1	[B
    //   12592: iload 25
    //   12594: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   12597: ifeq +168 -> 12765
    //   12600: iload 11
    //   12602: istore 4
    //   12604: iload 13
    //   12606: istore 5
    //   12608: iload 12
    //   12610: istore 17
    //   12612: iload 8
    //   12614: istore 9
    //   12616: iload 11
    //   12618: istore_2
    //   12619: iload 13
    //   12621: istore_3
    //   12622: iload 12
    //   12624: istore 7
    //   12626: iload 8
    //   12628: istore 6
    //   12630: aload_0
    //   12631: iconst_0
    //   12632: aaload
    //   12633: ldc_w 946
    //   12636: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12639: ifeq +42 -> 12681
    //   12642: iload 11
    //   12644: istore 4
    //   12646: iload 13
    //   12648: istore 5
    //   12650: iload 12
    //   12652: istore 17
    //   12654: iload 8
    //   12656: istore 9
    //   12658: iload 11
    //   12660: istore_2
    //   12661: iload 13
    //   12663: istore_3
    //   12664: iload 12
    //   12666: istore 7
    //   12668: iload 8
    //   12670: istore 6
    //   12672: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   12675: ldc_w 1268
    //   12678: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   12681: iload 11
    //   12683: istore 4
    //   12685: iload 13
    //   12687: istore 5
    //   12689: iload 12
    //   12691: istore 17
    //   12693: iload 8
    //   12695: istore 9
    //   12697: iload 11
    //   12699: istore_2
    //   12700: iload 13
    //   12702: istore_3
    //   12703: iload 12
    //   12705: istore 7
    //   12707: iload 8
    //   12709: istore 6
    //   12711: aload_0
    //   12712: iconst_0
    //   12713: aaload
    //   12714: ldc_w 963
    //   12717: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12720: ifeq +12720 -> 25440
    //   12723: iload 11
    //   12725: istore 4
    //   12727: iload 13
    //   12729: istore 5
    //   12731: iload 12
    //   12733: istore 17
    //   12735: iload 8
    //   12737: istore 9
    //   12739: iload 11
    //   12741: istore_2
    //   12742: iload 13
    //   12744: istore_3
    //   12745: iload 12
    //   12747: istore 7
    //   12749: iload 8
    //   12751: istore 6
    //   12753: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   12756: ldc_w 1270
    //   12759: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   12762: goto +12678 -> 25440
    //   12765: iload 10
    //   12767: istore 13
    //   12769: iload 11
    //   12771: istore 4
    //   12773: iload 10
    //   12775: istore 5
    //   12777: iload 12
    //   12779: istore 17
    //   12781: iload 8
    //   12783: istore 9
    //   12785: iload 11
    //   12787: istore_2
    //   12788: iload 10
    //   12790: istore_3
    //   12791: iload 12
    //   12793: istore 7
    //   12795: iload 8
    //   12797: istore 6
    //   12799: iload 15
    //   12801: iload_1
    //   12802: getstatic 553	com/chelpus/root/utils/corepatch:byteOrigSOat9_2	[B
    //   12805: getstatic 555	com/chelpus/root/utils/corepatch:maskSOat9_2	[B
    //   12808: getstatic 557	com/chelpus/root/utils/corepatch:byteReplaceSOat9_2	[B
    //   12811: getstatic 559	com/chelpus/root/utils/corepatch:rep_maskSOat9_2	[B
    //   12814: iload 25
    //   12816: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   12819: ifeq +168 -> 12987
    //   12822: iload 11
    //   12824: istore 4
    //   12826: iload 10
    //   12828: istore 5
    //   12830: iload 12
    //   12832: istore 17
    //   12834: iload 8
    //   12836: istore 9
    //   12838: iload 11
    //   12840: istore_2
    //   12841: iload 10
    //   12843: istore_3
    //   12844: iload 12
    //   12846: istore 7
    //   12848: iload 8
    //   12850: istore 6
    //   12852: aload_0
    //   12853: iconst_0
    //   12854: aaload
    //   12855: ldc_w 946
    //   12858: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12861: ifeq +42 -> 12903
    //   12864: iload 11
    //   12866: istore 4
    //   12868: iload 10
    //   12870: istore 5
    //   12872: iload 12
    //   12874: istore 17
    //   12876: iload 8
    //   12878: istore 9
    //   12880: iload 11
    //   12882: istore_2
    //   12883: iload 10
    //   12885: istore_3
    //   12886: iload 12
    //   12888: istore 7
    //   12890: iload 8
    //   12892: istore 6
    //   12894: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   12897: ldc_w 1268
    //   12900: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   12903: iload 11
    //   12905: istore 4
    //   12907: iload 10
    //   12909: istore 5
    //   12911: iload 12
    //   12913: istore 17
    //   12915: iload 8
    //   12917: istore 9
    //   12919: iload 11
    //   12921: istore_2
    //   12922: iload 10
    //   12924: istore_3
    //   12925: iload 12
    //   12927: istore 7
    //   12929: iload 8
    //   12931: istore 6
    //   12933: aload_0
    //   12934: iconst_0
    //   12935: aaload
    //   12936: ldc_w 963
    //   12939: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12942: ifeq +12504 -> 25446
    //   12945: iload 11
    //   12947: istore 4
    //   12949: iload 10
    //   12951: istore 5
    //   12953: iload 12
    //   12955: istore 17
    //   12957: iload 8
    //   12959: istore 9
    //   12961: iload 11
    //   12963: istore_2
    //   12964: iload 10
    //   12966: istore_3
    //   12967: iload 12
    //   12969: istore 7
    //   12971: iload 8
    //   12973: istore 6
    //   12975: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   12978: ldc_w 1270
    //   12981: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   12984: goto +12462 -> 25446
    //   12987: iload 13
    //   12989: istore 14
    //   12991: iload 11
    //   12993: istore 4
    //   12995: iload 13
    //   12997: istore 5
    //   12999: iload 12
    //   13001: istore 17
    //   13003: iload 8
    //   13005: istore 9
    //   13007: iload 11
    //   13009: istore_2
    //   13010: iload 13
    //   13012: istore_3
    //   13013: iload 12
    //   13015: istore 7
    //   13017: iload 8
    //   13019: istore 6
    //   13021: iload 15
    //   13023: iload_1
    //   13024: getstatic 601	com/chelpus/root/utils/corepatch:byteOrigSOat12	[B
    //   13027: getstatic 603	com/chelpus/root/utils/corepatch:maskSOat12	[B
    //   13030: getstatic 605	com/chelpus/root/utils/corepatch:byteReplaceSOat12	[B
    //   13033: getstatic 607	com/chelpus/root/utils/corepatch:rep_maskSOat12	[B
    //   13036: iload 25
    //   13038: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   13041: ifeq +168 -> 13209
    //   13044: iload 11
    //   13046: istore 4
    //   13048: iload 13
    //   13050: istore 5
    //   13052: iload 12
    //   13054: istore 17
    //   13056: iload 8
    //   13058: istore 9
    //   13060: iload 11
    //   13062: istore_2
    //   13063: iload 13
    //   13065: istore_3
    //   13066: iload 12
    //   13068: istore 7
    //   13070: iload 8
    //   13072: istore 6
    //   13074: aload_0
    //   13075: iconst_0
    //   13076: aaload
    //   13077: ldc_w 946
    //   13080: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   13083: ifeq +42 -> 13125
    //   13086: iload 11
    //   13088: istore 4
    //   13090: iload 13
    //   13092: istore 5
    //   13094: iload 12
    //   13096: istore 17
    //   13098: iload 8
    //   13100: istore 9
    //   13102: iload 11
    //   13104: istore_2
    //   13105: iload 13
    //   13107: istore_3
    //   13108: iload 12
    //   13110: istore 7
    //   13112: iload 8
    //   13114: istore 6
    //   13116: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   13119: ldc_w 1268
    //   13122: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   13125: iload 11
    //   13127: istore 4
    //   13129: iload 13
    //   13131: istore 5
    //   13133: iload 12
    //   13135: istore 17
    //   13137: iload 8
    //   13139: istore 9
    //   13141: iload 11
    //   13143: istore_2
    //   13144: iload 13
    //   13146: istore_3
    //   13147: iload 12
    //   13149: istore 7
    //   13151: iload 8
    //   13153: istore 6
    //   13155: aload_0
    //   13156: iconst_0
    //   13157: aaload
    //   13158: ldc_w 963
    //   13161: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   13164: ifeq +12288 -> 25452
    //   13167: iload 11
    //   13169: istore 4
    //   13171: iload 13
    //   13173: istore 5
    //   13175: iload 12
    //   13177: istore 17
    //   13179: iload 8
    //   13181: istore 9
    //   13183: iload 11
    //   13185: istore_2
    //   13186: iload 13
    //   13188: istore_3
    //   13189: iload 12
    //   13191: istore 7
    //   13193: iload 8
    //   13195: istore 6
    //   13197: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   13200: ldc_w 1270
    //   13203: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   13206: goto +12246 -> 25452
    //   13209: iload 14
    //   13211: istore 10
    //   13213: iload 11
    //   13215: istore 4
    //   13217: iload 14
    //   13219: istore 5
    //   13221: iload 12
    //   13223: istore 17
    //   13225: iload 8
    //   13227: istore 9
    //   13229: iload 11
    //   13231: istore_2
    //   13232: iload 14
    //   13234: istore_3
    //   13235: iload 12
    //   13237: istore 7
    //   13239: iload 8
    //   13241: istore 6
    //   13243: iload 15
    //   13245: iload_1
    //   13246: getstatic 609	com/chelpus/root/utils/corepatch:byteOrigSOat12_1	[B
    //   13249: getstatic 611	com/chelpus/root/utils/corepatch:maskSOat12_1	[B
    //   13252: getstatic 613	com/chelpus/root/utils/corepatch:byteReplaceSOat12_1	[B
    //   13255: getstatic 615	com/chelpus/root/utils/corepatch:rep_maskSOat12_1	[B
    //   13258: iload 25
    //   13260: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   13263: ifeq +168 -> 13431
    //   13266: iload 11
    //   13268: istore 4
    //   13270: iload 14
    //   13272: istore 5
    //   13274: iload 12
    //   13276: istore 17
    //   13278: iload 8
    //   13280: istore 9
    //   13282: iload 11
    //   13284: istore_2
    //   13285: iload 14
    //   13287: istore_3
    //   13288: iload 12
    //   13290: istore 7
    //   13292: iload 8
    //   13294: istore 6
    //   13296: aload_0
    //   13297: iconst_0
    //   13298: aaload
    //   13299: ldc_w 946
    //   13302: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   13305: ifeq +42 -> 13347
    //   13308: iload 11
    //   13310: istore 4
    //   13312: iload 14
    //   13314: istore 5
    //   13316: iload 12
    //   13318: istore 17
    //   13320: iload 8
    //   13322: istore 9
    //   13324: iload 11
    //   13326: istore_2
    //   13327: iload 14
    //   13329: istore_3
    //   13330: iload 12
    //   13332: istore 7
    //   13334: iload 8
    //   13336: istore 6
    //   13338: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   13341: ldc_w 1268
    //   13344: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   13347: iload 11
    //   13349: istore 4
    //   13351: iload 14
    //   13353: istore 5
    //   13355: iload 12
    //   13357: istore 17
    //   13359: iload 8
    //   13361: istore 9
    //   13363: iload 11
    //   13365: istore_2
    //   13366: iload 14
    //   13368: istore_3
    //   13369: iload 12
    //   13371: istore 7
    //   13373: iload 8
    //   13375: istore 6
    //   13377: aload_0
    //   13378: iconst_0
    //   13379: aaload
    //   13380: ldc_w 963
    //   13383: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   13386: ifeq +12072 -> 25458
    //   13389: iload 11
    //   13391: istore 4
    //   13393: iload 14
    //   13395: istore 5
    //   13397: iload 12
    //   13399: istore 17
    //   13401: iload 8
    //   13403: istore 9
    //   13405: iload 11
    //   13407: istore_2
    //   13408: iload 14
    //   13410: istore_3
    //   13411: iload 12
    //   13413: istore 7
    //   13415: iload 8
    //   13417: istore 6
    //   13419: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   13422: ldc_w 1270
    //   13425: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   13428: goto +12030 -> 25458
    //   13431: iload 11
    //   13433: istore 13
    //   13435: iload 11
    //   13437: istore 4
    //   13439: iload 10
    //   13441: istore 5
    //   13443: iload 12
    //   13445: istore 17
    //   13447: iload 8
    //   13449: istore 9
    //   13451: iload 11
    //   13453: istore_2
    //   13454: iload 10
    //   13456: istore_3
    //   13457: iload 12
    //   13459: istore 7
    //   13461: iload 8
    //   13463: istore 6
    //   13465: iload 15
    //   13467: iload_1
    //   13468: getstatic 561	com/chelpus/root/utils/corepatch:byteOrigSOat10	[B
    //   13471: getstatic 563	com/chelpus/root/utils/corepatch:maskSOat10	[B
    //   13474: getstatic 565	com/chelpus/root/utils/corepatch:byteReplaceSOat10	[B
    //   13477: getstatic 567	com/chelpus/root/utils/corepatch:rep_maskSOat10	[B
    //   13480: iload 25
    //   13482: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   13485: ifeq +168 -> 13653
    //   13488: iload 11
    //   13490: istore 4
    //   13492: iload 10
    //   13494: istore 5
    //   13496: iload 12
    //   13498: istore 17
    //   13500: iload 8
    //   13502: istore 9
    //   13504: iload 11
    //   13506: istore_2
    //   13507: iload 10
    //   13509: istore_3
    //   13510: iload 12
    //   13512: istore 7
    //   13514: iload 8
    //   13516: istore 6
    //   13518: aload_0
    //   13519: iconst_0
    //   13520: aaload
    //   13521: ldc_w 946
    //   13524: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   13527: ifeq +42 -> 13569
    //   13530: iload 11
    //   13532: istore 4
    //   13534: iload 10
    //   13536: istore 5
    //   13538: iload 12
    //   13540: istore 17
    //   13542: iload 8
    //   13544: istore 9
    //   13546: iload 11
    //   13548: istore_2
    //   13549: iload 10
    //   13551: istore_3
    //   13552: iload 12
    //   13554: istore 7
    //   13556: iload 8
    //   13558: istore 6
    //   13560: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   13563: ldc_w 1264
    //   13566: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   13569: iload 11
    //   13571: istore 4
    //   13573: iload 10
    //   13575: istore 5
    //   13577: iload 12
    //   13579: istore 17
    //   13581: iload 8
    //   13583: istore 9
    //   13585: iload 11
    //   13587: istore_2
    //   13588: iload 10
    //   13590: istore_3
    //   13591: iload 12
    //   13593: istore 7
    //   13595: iload 8
    //   13597: istore 6
    //   13599: aload_0
    //   13600: iconst_0
    //   13601: aaload
    //   13602: ldc_w 963
    //   13605: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   13608: ifeq +11856 -> 25464
    //   13611: iload 11
    //   13613: istore 4
    //   13615: iload 10
    //   13617: istore 5
    //   13619: iload 12
    //   13621: istore 17
    //   13623: iload 8
    //   13625: istore 9
    //   13627: iload 11
    //   13629: istore_2
    //   13630: iload 10
    //   13632: istore_3
    //   13633: iload 12
    //   13635: istore 7
    //   13637: iload 8
    //   13639: istore 6
    //   13641: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   13644: ldc_w 1266
    //   13647: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   13650: goto +11814 -> 25464
    //   13653: iload 13
    //   13655: istore 11
    //   13657: iload 13
    //   13659: istore 4
    //   13661: iload 10
    //   13663: istore 5
    //   13665: iload 12
    //   13667: istore 17
    //   13669: iload 8
    //   13671: istore 9
    //   13673: iload 13
    //   13675: istore_2
    //   13676: iload 10
    //   13678: istore_3
    //   13679: iload 12
    //   13681: istore 7
    //   13683: iload 8
    //   13685: istore 6
    //   13687: iload 15
    //   13689: iload_1
    //   13690: getstatic 569	com/chelpus/root/utils/corepatch:byteOrigSOat10_1	[B
    //   13693: getstatic 571	com/chelpus/root/utils/corepatch:maskSOat10_1	[B
    //   13696: getstatic 573	com/chelpus/root/utils/corepatch:byteReplaceSOat10_1	[B
    //   13699: getstatic 575	com/chelpus/root/utils/corepatch:rep_maskSOat10_1	[B
    //   13702: iload 25
    //   13704: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   13707: ifeq +168 -> 13875
    //   13710: iload 13
    //   13712: istore 4
    //   13714: iload 10
    //   13716: istore 5
    //   13718: iload 12
    //   13720: istore 17
    //   13722: iload 8
    //   13724: istore 9
    //   13726: iload 13
    //   13728: istore_2
    //   13729: iload 10
    //   13731: istore_3
    //   13732: iload 12
    //   13734: istore 7
    //   13736: iload 8
    //   13738: istore 6
    //   13740: aload_0
    //   13741: iconst_0
    //   13742: aaload
    //   13743: ldc_w 946
    //   13746: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   13749: ifeq +42 -> 13791
    //   13752: iload 13
    //   13754: istore 4
    //   13756: iload 10
    //   13758: istore 5
    //   13760: iload 12
    //   13762: istore 17
    //   13764: iload 8
    //   13766: istore 9
    //   13768: iload 13
    //   13770: istore_2
    //   13771: iload 10
    //   13773: istore_3
    //   13774: iload 12
    //   13776: istore 7
    //   13778: iload 8
    //   13780: istore 6
    //   13782: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   13785: ldc_w 1264
    //   13788: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   13791: iload 13
    //   13793: istore 4
    //   13795: iload 10
    //   13797: istore 5
    //   13799: iload 12
    //   13801: istore 17
    //   13803: iload 8
    //   13805: istore 9
    //   13807: iload 13
    //   13809: istore_2
    //   13810: iload 10
    //   13812: istore_3
    //   13813: iload 12
    //   13815: istore 7
    //   13817: iload 8
    //   13819: istore 6
    //   13821: aload_0
    //   13822: iconst_0
    //   13823: aaload
    //   13824: ldc_w 963
    //   13827: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   13830: ifeq +11640 -> 25470
    //   13833: iload 13
    //   13835: istore 4
    //   13837: iload 10
    //   13839: istore 5
    //   13841: iload 12
    //   13843: istore 17
    //   13845: iload 8
    //   13847: istore 9
    //   13849: iload 13
    //   13851: istore_2
    //   13852: iload 10
    //   13854: istore_3
    //   13855: iload 12
    //   13857: istore 7
    //   13859: iload 8
    //   13861: istore 6
    //   13863: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   13866: ldc_w 1266
    //   13869: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   13872: goto +11598 -> 25470
    //   13875: iload 11
    //   13877: istore 13
    //   13879: iload 11
    //   13881: istore 4
    //   13883: iload 10
    //   13885: istore 5
    //   13887: iload 12
    //   13889: istore 17
    //   13891: iload 8
    //   13893: istore 9
    //   13895: iload 11
    //   13897: istore_2
    //   13898: iload 10
    //   13900: istore_3
    //   13901: iload 12
    //   13903: istore 7
    //   13905: iload 8
    //   13907: istore 6
    //   13909: iload 15
    //   13911: iload_1
    //   13912: getstatic 577	com/chelpus/root/utils/corepatch:byteOrigSOat11	[B
    //   13915: getstatic 579	com/chelpus/root/utils/corepatch:maskSOat11	[B
    //   13918: getstatic 581	com/chelpus/root/utils/corepatch:byteReplaceSOat11	[B
    //   13921: getstatic 583	com/chelpus/root/utils/corepatch:rep_maskSOat11	[B
    //   13924: iload 25
    //   13926: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   13929: ifeq +168 -> 14097
    //   13932: iload 11
    //   13934: istore 4
    //   13936: iload 10
    //   13938: istore 5
    //   13940: iload 12
    //   13942: istore 17
    //   13944: iload 8
    //   13946: istore 9
    //   13948: iload 11
    //   13950: istore_2
    //   13951: iload 10
    //   13953: istore_3
    //   13954: iload 12
    //   13956: istore 7
    //   13958: iload 8
    //   13960: istore 6
    //   13962: aload_0
    //   13963: iconst_0
    //   13964: aaload
    //   13965: ldc_w 946
    //   13968: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   13971: ifeq +42 -> 14013
    //   13974: iload 11
    //   13976: istore 4
    //   13978: iload 10
    //   13980: istore 5
    //   13982: iload 12
    //   13984: istore 17
    //   13986: iload 8
    //   13988: istore 9
    //   13990: iload 11
    //   13992: istore_2
    //   13993: iload 10
    //   13995: istore_3
    //   13996: iload 12
    //   13998: istore 7
    //   14000: iload 8
    //   14002: istore 6
    //   14004: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   14007: ldc_w 1264
    //   14010: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   14013: iload 11
    //   14015: istore 4
    //   14017: iload 10
    //   14019: istore 5
    //   14021: iload 12
    //   14023: istore 17
    //   14025: iload 8
    //   14027: istore 9
    //   14029: iload 11
    //   14031: istore_2
    //   14032: iload 10
    //   14034: istore_3
    //   14035: iload 12
    //   14037: istore 7
    //   14039: iload 8
    //   14041: istore 6
    //   14043: aload_0
    //   14044: iconst_0
    //   14045: aaload
    //   14046: ldc_w 963
    //   14049: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14052: ifeq +11424 -> 25476
    //   14055: iload 11
    //   14057: istore 4
    //   14059: iload 10
    //   14061: istore 5
    //   14063: iload 12
    //   14065: istore 17
    //   14067: iload 8
    //   14069: istore 9
    //   14071: iload 11
    //   14073: istore_2
    //   14074: iload 10
    //   14076: istore_3
    //   14077: iload 12
    //   14079: istore 7
    //   14081: iload 8
    //   14083: istore 6
    //   14085: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   14088: ldc_w 1266
    //   14091: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   14094: goto +11382 -> 25476
    //   14097: iload 13
    //   14099: istore 14
    //   14101: iload 13
    //   14103: istore 4
    //   14105: iload 10
    //   14107: istore 5
    //   14109: iload 12
    //   14111: istore 17
    //   14113: iload 8
    //   14115: istore 9
    //   14117: iload 13
    //   14119: istore_2
    //   14120: iload 10
    //   14122: istore_3
    //   14123: iload 12
    //   14125: istore 7
    //   14127: iload 8
    //   14129: istore 6
    //   14131: iload 15
    //   14133: iload_1
    //   14134: getstatic 585	com/chelpus/root/utils/corepatch:byteOrigSOat11_1	[B
    //   14137: getstatic 587	com/chelpus/root/utils/corepatch:maskSOat11_1	[B
    //   14140: getstatic 589	com/chelpus/root/utils/corepatch:byteReplaceSOat11_1	[B
    //   14143: getstatic 591	com/chelpus/root/utils/corepatch:rep_maskSOat11_1	[B
    //   14146: iload 25
    //   14148: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   14151: ifeq +168 -> 14319
    //   14154: iload 13
    //   14156: istore 4
    //   14158: iload 10
    //   14160: istore 5
    //   14162: iload 12
    //   14164: istore 17
    //   14166: iload 8
    //   14168: istore 9
    //   14170: iload 13
    //   14172: istore_2
    //   14173: iload 10
    //   14175: istore_3
    //   14176: iload 12
    //   14178: istore 7
    //   14180: iload 8
    //   14182: istore 6
    //   14184: aload_0
    //   14185: iconst_0
    //   14186: aaload
    //   14187: ldc_w 946
    //   14190: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14193: ifeq +42 -> 14235
    //   14196: iload 13
    //   14198: istore 4
    //   14200: iload 10
    //   14202: istore 5
    //   14204: iload 12
    //   14206: istore 17
    //   14208: iload 8
    //   14210: istore 9
    //   14212: iload 13
    //   14214: istore_2
    //   14215: iload 10
    //   14217: istore_3
    //   14218: iload 12
    //   14220: istore 7
    //   14222: iload 8
    //   14224: istore 6
    //   14226: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   14229: ldc_w 1264
    //   14232: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   14235: iload 13
    //   14237: istore 4
    //   14239: iload 10
    //   14241: istore 5
    //   14243: iload 12
    //   14245: istore 17
    //   14247: iload 8
    //   14249: istore 9
    //   14251: iload 13
    //   14253: istore_2
    //   14254: iload 10
    //   14256: istore_3
    //   14257: iload 12
    //   14259: istore 7
    //   14261: iload 8
    //   14263: istore 6
    //   14265: aload_0
    //   14266: iconst_0
    //   14267: aaload
    //   14268: ldc_w 963
    //   14271: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14274: ifeq +11208 -> 25482
    //   14277: iload 13
    //   14279: istore 4
    //   14281: iload 10
    //   14283: istore 5
    //   14285: iload 12
    //   14287: istore 17
    //   14289: iload 8
    //   14291: istore 9
    //   14293: iload 13
    //   14295: istore_2
    //   14296: iload 10
    //   14298: istore_3
    //   14299: iload 12
    //   14301: istore 7
    //   14303: iload 8
    //   14305: istore 6
    //   14307: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   14310: ldc_w 1266
    //   14313: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   14316: goto +11166 -> 25482
    //   14319: iload 14
    //   14321: istore 11
    //   14323: iload 14
    //   14325: istore 4
    //   14327: iload 10
    //   14329: istore 5
    //   14331: iload 12
    //   14333: istore 17
    //   14335: iload 8
    //   14337: istore 9
    //   14339: iload 14
    //   14341: istore_2
    //   14342: iload 10
    //   14344: istore_3
    //   14345: iload 12
    //   14347: istore 7
    //   14349: iload 8
    //   14351: istore 6
    //   14353: iload 15
    //   14355: iload_1
    //   14356: getstatic 593	com/chelpus/root/utils/corepatch:byteOrigSOat11_2	[B
    //   14359: getstatic 595	com/chelpus/root/utils/corepatch:maskSOat11_2	[B
    //   14362: getstatic 597	com/chelpus/root/utils/corepatch:byteReplaceSOat11_2	[B
    //   14365: getstatic 599	com/chelpus/root/utils/corepatch:rep_maskSOat11_2	[B
    //   14368: iload 25
    //   14370: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   14373: ifeq +168 -> 14541
    //   14376: iload 14
    //   14378: istore 4
    //   14380: iload 10
    //   14382: istore 5
    //   14384: iload 12
    //   14386: istore 17
    //   14388: iload 8
    //   14390: istore 9
    //   14392: iload 14
    //   14394: istore_2
    //   14395: iload 10
    //   14397: istore_3
    //   14398: iload 12
    //   14400: istore 7
    //   14402: iload 8
    //   14404: istore 6
    //   14406: aload_0
    //   14407: iconst_0
    //   14408: aaload
    //   14409: ldc_w 946
    //   14412: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14415: ifeq +42 -> 14457
    //   14418: iload 14
    //   14420: istore 4
    //   14422: iload 10
    //   14424: istore 5
    //   14426: iload 12
    //   14428: istore 17
    //   14430: iload 8
    //   14432: istore 9
    //   14434: iload 14
    //   14436: istore_2
    //   14437: iload 10
    //   14439: istore_3
    //   14440: iload 12
    //   14442: istore 7
    //   14444: iload 8
    //   14446: istore 6
    //   14448: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   14451: ldc_w 1264
    //   14454: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   14457: iload 14
    //   14459: istore 4
    //   14461: iload 10
    //   14463: istore 5
    //   14465: iload 12
    //   14467: istore 17
    //   14469: iload 8
    //   14471: istore 9
    //   14473: iload 14
    //   14475: istore_2
    //   14476: iload 10
    //   14478: istore_3
    //   14479: iload 12
    //   14481: istore 7
    //   14483: iload 8
    //   14485: istore 6
    //   14487: aload_0
    //   14488: iconst_0
    //   14489: aaload
    //   14490: ldc_w 963
    //   14493: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14496: ifeq +10992 -> 25488
    //   14499: iload 14
    //   14501: istore 4
    //   14503: iload 10
    //   14505: istore 5
    //   14507: iload 12
    //   14509: istore 17
    //   14511: iload 8
    //   14513: istore 9
    //   14515: iload 14
    //   14517: istore_2
    //   14518: iload 10
    //   14520: istore_3
    //   14521: iload 12
    //   14523: istore 7
    //   14525: iload 8
    //   14527: istore 6
    //   14529: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   14532: ldc_w 1266
    //   14535: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   14538: goto +10950 -> 25488
    //   14541: iload 25
    //   14543: ifeq +5754 -> 20297
    //   14546: iload 11
    //   14548: ifeq +5749 -> 20297
    //   14551: iload 10
    //   14553: ifeq +5744 -> 20297
    //   14556: iload 12
    //   14558: ifeq +5739 -> 20297
    //   14561: iconst_0
    //   14562: ifeq +5735 -> 20297
    //   14565: iconst_0
    //   14566: ifeq +5731 -> 20297
    //   14569: iload 8
    //   14571: ifeq +5726 -> 20297
    //   14574: iload 11
    //   14576: istore 4
    //   14578: iload 10
    //   14580: istore 5
    //   14582: iload 12
    //   14584: istore 17
    //   14586: iload 8
    //   14588: istore 9
    //   14590: iload 11
    //   14592: istore_2
    //   14593: iload 10
    //   14595: istore_3
    //   14596: iload 12
    //   14598: istore 7
    //   14600: iload 8
    //   14602: istore 6
    //   14604: getstatic 303	com/chelpus/root/utils/corepatch:onlyDalvik	Z
    //   14607: ifne +355 -> 14962
    //   14610: iload 11
    //   14612: istore 4
    //   14614: iload 10
    //   14616: istore 5
    //   14618: iload 12
    //   14620: istore 17
    //   14622: iload 8
    //   14624: istore 9
    //   14626: iload 11
    //   14628: istore_2
    //   14629: iload 10
    //   14631: istore_3
    //   14632: iload 12
    //   14634: istore 7
    //   14636: iload 8
    //   14638: istore 6
    //   14640: new 980	java/io/File
    //   14643: dup
    //   14644: ldc_w 1280
    //   14647: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   14650: invokevirtual 1132	java/io/File:delete	()Z
    //   14653: pop
    //   14654: iload 11
    //   14656: istore 4
    //   14658: iload 10
    //   14660: istore 5
    //   14662: iload 12
    //   14664: istore 17
    //   14666: iload 8
    //   14668: istore 9
    //   14670: iload 11
    //   14672: istore_2
    //   14673: iload 10
    //   14675: istore_3
    //   14676: iload 12
    //   14678: istore 7
    //   14680: iload 8
    //   14682: istore 6
    //   14684: new 980	java/io/File
    //   14687: dup
    //   14688: ldc_w 1282
    //   14691: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   14694: invokevirtual 1132	java/io/File:delete	()Z
    //   14697: pop
    //   14698: iload 11
    //   14700: istore 4
    //   14702: iload 10
    //   14704: istore 5
    //   14706: iload 12
    //   14708: istore 17
    //   14710: iload 8
    //   14712: istore 9
    //   14714: iload 11
    //   14716: istore_2
    //   14717: iload 10
    //   14719: istore_3
    //   14720: iload 12
    //   14722: istore 7
    //   14724: iload 8
    //   14726: istore 6
    //   14728: new 980	java/io/File
    //   14731: dup
    //   14732: ldc_w 1284
    //   14735: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   14738: invokevirtual 1132	java/io/File:delete	()Z
    //   14741: pop
    //   14742: iload 11
    //   14744: istore 4
    //   14746: iload 10
    //   14748: istore 5
    //   14750: iload 12
    //   14752: istore 17
    //   14754: iload 8
    //   14756: istore 9
    //   14758: iload 11
    //   14760: istore_2
    //   14761: iload 10
    //   14763: istore_3
    //   14764: iload 12
    //   14766: istore 7
    //   14768: iload 8
    //   14770: istore 6
    //   14772: new 980	java/io/File
    //   14775: dup
    //   14776: ldc_w 1286
    //   14779: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   14782: invokevirtual 1132	java/io/File:delete	()Z
    //   14785: pop
    //   14786: iload 11
    //   14788: istore 4
    //   14790: iload 10
    //   14792: istore 5
    //   14794: iload 12
    //   14796: istore 17
    //   14798: iload 8
    //   14800: istore 9
    //   14802: iload 11
    //   14804: istore_2
    //   14805: iload 10
    //   14807: istore_3
    //   14808: iload 12
    //   14810: istore 7
    //   14812: iload 8
    //   14814: istore 6
    //   14816: new 980	java/io/File
    //   14819: dup
    //   14820: ldc_w 1288
    //   14823: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   14826: invokevirtual 1132	java/io/File:delete	()Z
    //   14829: pop
    //   14830: iload 11
    //   14832: istore 4
    //   14834: iload 10
    //   14836: istore 5
    //   14838: iload 12
    //   14840: istore 17
    //   14842: iload 8
    //   14844: istore 9
    //   14846: iload 11
    //   14848: istore_2
    //   14849: iload 10
    //   14851: istore_3
    //   14852: iload 12
    //   14854: istore 7
    //   14856: iload 8
    //   14858: istore 6
    //   14860: new 980	java/io/File
    //   14863: dup
    //   14864: ldc_w 1290
    //   14867: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   14870: invokevirtual 1132	java/io/File:delete	()Z
    //   14873: pop
    //   14874: iload 11
    //   14876: istore 4
    //   14878: iload 10
    //   14880: istore 5
    //   14882: iload 12
    //   14884: istore 17
    //   14886: iload 8
    //   14888: istore 9
    //   14890: iload 11
    //   14892: istore_2
    //   14893: iload 10
    //   14895: istore_3
    //   14896: iload 12
    //   14898: istore 7
    //   14900: iload 8
    //   14902: istore 6
    //   14904: new 980	java/io/File
    //   14907: dup
    //   14908: ldc_w 1292
    //   14911: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   14914: invokevirtual 1132	java/io/File:delete	()Z
    //   14917: pop
    //   14918: iload 11
    //   14920: istore 4
    //   14922: iload 10
    //   14924: istore 5
    //   14926: iload 12
    //   14928: istore 17
    //   14930: iload 8
    //   14932: istore 9
    //   14934: iload 11
    //   14936: istore_2
    //   14937: iload 10
    //   14939: istore_3
    //   14940: iload 12
    //   14942: istore 7
    //   14944: iload 8
    //   14946: istore 6
    //   14948: new 980	java/io/File
    //   14951: dup
    //   14952: ldc_w 1294
    //   14955: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   14958: invokevirtual 1132	java/io/File:delete	()Z
    //   14961: pop
    //   14962: iload 11
    //   14964: istore 4
    //   14966: iload 10
    //   14968: istore 5
    //   14970: iload 12
    //   14972: istore 17
    //   14974: iload 8
    //   14976: istore 9
    //   14978: iload 11
    //   14980: istore_2
    //   14981: iload 10
    //   14983: istore_3
    //   14984: iload 12
    //   14986: istore 7
    //   14988: iload 8
    //   14990: istore 6
    //   14992: invokestatic 1148	com/chelpus/Utils:reboot	()V
    //   14995: iload 8
    //   14997: istore 16
    //   14999: iload 12
    //   15001: istore 15
    //   15003: iload 10
    //   15005: istore 14
    //   15007: iload 11
    //   15009: istore 12
    //   15011: iload 12
    //   15013: istore_2
    //   15014: iload 14
    //   15016: istore_3
    //   15017: iload 15
    //   15019: istore 7
    //   15021: iload 16
    //   15023: istore 6
    //   15025: aload 32
    //   15027: invokevirtual 1106	java/nio/channels/FileChannel:close	()V
    //   15030: iload 16
    //   15032: istore 6
    //   15034: iload 15
    //   15036: istore 7
    //   15038: iload 14
    //   15040: istore_3
    //   15041: iload 12
    //   15043: istore_2
    //   15044: iload_2
    //   15045: ifne +25 -> 15070
    //   15048: iload_3
    //   15049: ifne +21 -> 15070
    //   15052: iload 7
    //   15054: ifne +16 -> 15070
    //   15057: iconst_0
    //   15058: ifne +12 -> 15070
    //   15061: iconst_0
    //   15062: ifne +8 -> 15070
    //   15065: iload 6
    //   15067: ifeq +124 -> 15191
    //   15070: getstatic 303	com/chelpus/root/utils/corepatch:onlyDalvik	Z
    //   15073: ifne +115 -> 15188
    //   15076: new 980	java/io/File
    //   15079: dup
    //   15080: ldc_w 1280
    //   15083: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15086: invokevirtual 1132	java/io/File:delete	()Z
    //   15089: pop
    //   15090: new 980	java/io/File
    //   15093: dup
    //   15094: ldc_w 1282
    //   15097: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15100: invokevirtual 1132	java/io/File:delete	()Z
    //   15103: pop
    //   15104: new 980	java/io/File
    //   15107: dup
    //   15108: ldc_w 1284
    //   15111: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15114: invokevirtual 1132	java/io/File:delete	()Z
    //   15117: pop
    //   15118: new 980	java/io/File
    //   15121: dup
    //   15122: ldc_w 1286
    //   15125: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15128: invokevirtual 1132	java/io/File:delete	()Z
    //   15131: pop
    //   15132: new 980	java/io/File
    //   15135: dup
    //   15136: ldc_w 1288
    //   15139: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15142: invokevirtual 1132	java/io/File:delete	()Z
    //   15145: pop
    //   15146: new 980	java/io/File
    //   15149: dup
    //   15150: ldc_w 1290
    //   15153: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15156: invokevirtual 1132	java/io/File:delete	()Z
    //   15159: pop
    //   15160: new 980	java/io/File
    //   15163: dup
    //   15164: ldc_w 1292
    //   15167: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15170: invokevirtual 1132	java/io/File:delete	()Z
    //   15173: pop
    //   15174: new 980	java/io/File
    //   15177: dup
    //   15178: ldc_w 1294
    //   15181: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15184: invokevirtual 1132	java/io/File:delete	()Z
    //   15187: pop
    //   15188: invokestatic 1148	com/chelpus/Utils:reboot	()V
    //   15191: aload_0
    //   15192: iconst_4
    //   15193: aaload
    //   15194: ldc_w 910
    //   15197: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15200: ifeq +5232 -> 20432
    //   15203: aload_0
    //   15204: iconst_1
    //   15205: aaload
    //   15206: ldc_w 948
    //   15209: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15212: ifeq +96 -> 15308
    //   15215: new 980	java/io/File
    //   15218: dup
    //   15219: aload_0
    //   15220: iconst_1
    //   15221: aaload
    //   15222: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15225: invokestatic 1152	com/chelpus/Utils:classes_test	(Ljava/io/File;)Z
    //   15228: ifeq +80 -> 15308
    //   15231: new 980	java/io/File
    //   15234: dup
    //   15235: aload_0
    //   15236: iconst_1
    //   15237: aaload
    //   15238: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15241: astore 32
    //   15243: aload 32
    //   15245: aload 32
    //   15247: invokestatic 1156	com/chelpus/Utils:getDirs	(Ljava/io/File;)Ljava/io/File;
    //   15250: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   15253: invokestatic 1159	com/chelpus/root/utils/corepatch:unzip	(Ljava/io/File;Ljava/lang/String;)V
    //   15256: new 980	java/io/File
    //   15259: dup
    //   15260: new 1031	java/lang/StringBuilder
    //   15263: dup
    //   15264: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   15267: aload 32
    //   15269: invokestatic 1156	com/chelpus/Utils:getDirs	(Ljava/io/File;)Ljava/io/File;
    //   15272: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   15275: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15278: ldc_w 1161
    //   15281: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15284: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15287: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15290: astore 32
    //   15292: aload 32
    //   15294: invokevirtual 988	java/io/File:exists	()Z
    //   15297: ifeq +11 -> 15308
    //   15300: aload 37
    //   15302: aload 32
    //   15304: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   15307: pop
    //   15308: aload_0
    //   15309: iconst_1
    //   15310: aaload
    //   15311: ldc_w 950
    //   15314: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15317: ifeq +19 -> 15336
    //   15320: aload 37
    //   15322: new 980	java/io/File
    //   15325: dup
    //   15326: aload_0
    //   15327: iconst_1
    //   15328: aaload
    //   15329: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   15332: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   15335: pop
    //   15336: aload 37
    //   15338: invokevirtual 1020	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   15341: astore 34
    //   15343: aload 34
    //   15345: invokeinterface 1025 1 0
    //   15350: ifeq +5244 -> 20594
    //   15353: aload 34
    //   15355: invokeinterface 1029 1 0
    //   15360: checkcast 980	java/io/File
    //   15363: astore 32
    //   15365: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15368: new 1031	java/lang/StringBuilder
    //   15371: dup
    //   15372: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   15375: ldc_w 1296
    //   15378: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15381: aload 32
    //   15383: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   15386: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15389: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15392: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15395: iconst_0
    //   15396: istore_2
    //   15397: aload 32
    //   15399: invokestatic 1300	com/chelpus/Utils:isELFfiles	(Ljava/io/File;)Z
    //   15402: ifeq +5 -> 15407
    //   15405: iconst_1
    //   15406: istore_2
    //   15407: new 1047	java/io/RandomAccessFile
    //   15410: dup
    //   15411: aload 32
    //   15413: ldc_w 914
    //   15416: invokespecial 1050	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15419: invokevirtual 1054	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   15422: astore 33
    //   15424: aload 33
    //   15426: getstatic 1060	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   15429: lconst_0
    //   15430: aload 33
    //   15432: invokevirtual 1065	java/nio/channels/FileChannel:size	()J
    //   15435: l2i
    //   15436: i2l
    //   15437: invokevirtual 1069	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   15440: putstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   15443: iconst_0
    //   15444: istore_3
    //   15445: iconst_0
    //   15446: istore 4
    //   15448: iload_2
    //   15449: ifne +5869 -> 21318
    //   15452: aconst_null
    //   15453: putstatic 311	com/chelpus/root/utils/corepatch:lastByteReplace	[B
    //   15456: iconst_0
    //   15457: putstatic 309	com/chelpus/root/utils/corepatch:lastPatchPosition	I
    //   15460: lconst_0
    //   15461: lstore 30
    //   15463: iload 4
    //   15465: istore_3
    //   15466: iload_3
    //   15467: istore_2
    //   15468: iload_3
    //   15469: istore 5
    //   15471: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   15474: invokevirtual 1081	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   15477: ifeq +5547 -> 21024
    //   15480: iload_3
    //   15481: istore_2
    //   15482: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   15485: invokevirtual 1083	java/nio/MappedByteBuffer:position	()I
    //   15488: istore 5
    //   15490: iload_3
    //   15491: istore_2
    //   15492: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   15495: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   15498: istore_1
    //   15499: iload_3
    //   15500: istore 4
    //   15502: iload_3
    //   15503: istore_2
    //   15504: iload 5
    //   15506: iload_1
    //   15507: getstatic 617	com/chelpus/root/utils/corepatch:byteOrigS2	[B
    //   15510: getstatic 619	com/chelpus/root/utils/corepatch:maskS2	[B
    //   15513: getstatic 621	com/chelpus/root/utils/corepatch:byteReplaceS2	[B
    //   15516: getstatic 623	com/chelpus/root/utils/corepatch:rep_maskS2	[B
    //   15519: iload 25
    //   15521: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   15524: ifeq +56 -> 15580
    //   15527: iload_3
    //   15528: istore_2
    //   15529: aload_0
    //   15530: iconst_0
    //   15531: aaload
    //   15532: ldc_w 946
    //   15535: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15538: ifeq +14 -> 15552
    //   15541: iload_3
    //   15542: istore_2
    //   15543: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15546: ldc_w 1264
    //   15549: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15552: iload_3
    //   15553: istore_2
    //   15554: aload_0
    //   15555: iconst_0
    //   15556: aaload
    //   15557: ldc_w 963
    //   15560: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15563: ifeq +9931 -> 25494
    //   15566: iload_3
    //   15567: istore_2
    //   15568: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15571: ldc_w 1266
    //   15574: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15577: goto +9917 -> 25494
    //   15580: iload 4
    //   15582: istore_3
    //   15583: iload 4
    //   15585: istore_2
    //   15586: iload 5
    //   15588: iload_1
    //   15589: getstatic 641	com/chelpus/root/utils/corepatch:byteOrigS5	[B
    //   15592: getstatic 643	com/chelpus/root/utils/corepatch:maskS5	[B
    //   15595: getstatic 645	com/chelpus/root/utils/corepatch:byteReplaceS5	[B
    //   15598: getstatic 647	com/chelpus/root/utils/corepatch:rep_maskS5	[B
    //   15601: iload 25
    //   15603: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   15606: ifeq +60 -> 15666
    //   15609: iload 4
    //   15611: istore_2
    //   15612: aload_0
    //   15613: iconst_0
    //   15614: aaload
    //   15615: ldc_w 946
    //   15618: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15621: ifeq +15 -> 15636
    //   15624: iload 4
    //   15626: istore_2
    //   15627: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15630: ldc_w 1264
    //   15633: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15636: iload 4
    //   15638: istore_2
    //   15639: aload_0
    //   15640: iconst_0
    //   15641: aaload
    //   15642: ldc_w 963
    //   15645: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15648: ifeq +9852 -> 25500
    //   15651: iload 4
    //   15653: istore_2
    //   15654: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15657: ldc_w 1266
    //   15660: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15663: goto +9837 -> 25500
    //   15666: iload_3
    //   15667: istore 4
    //   15669: iload_3
    //   15670: istore_2
    //   15671: iload 5
    //   15673: iload_1
    //   15674: getstatic 673	com/chelpus/root/utils/corepatch:byteOrigS14	[B
    //   15677: getstatic 675	com/chelpus/root/utils/corepatch:maskS14	[B
    //   15680: getstatic 677	com/chelpus/root/utils/corepatch:byteReplaceS14	[B
    //   15683: getstatic 679	com/chelpus/root/utils/corepatch:rep_maskS14	[B
    //   15686: iload 25
    //   15688: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   15691: ifeq +56 -> 15747
    //   15694: iload_3
    //   15695: istore_2
    //   15696: aload_0
    //   15697: iconst_0
    //   15698: aaload
    //   15699: ldc_w 946
    //   15702: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15705: ifeq +14 -> 15719
    //   15708: iload_3
    //   15709: istore_2
    //   15710: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15713: ldc_w 1264
    //   15716: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15719: iload_3
    //   15720: istore_2
    //   15721: aload_0
    //   15722: iconst_0
    //   15723: aaload
    //   15724: ldc_w 963
    //   15727: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15730: ifeq +9775 -> 25505
    //   15733: iload_3
    //   15734: istore_2
    //   15735: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15738: ldc_w 1266
    //   15741: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15744: goto +9761 -> 25505
    //   15747: iload 4
    //   15749: istore_3
    //   15750: iload 4
    //   15752: istore_2
    //   15753: iload 5
    //   15755: iload_1
    //   15756: getstatic 649	com/chelpus/root/utils/corepatch:byteOrigS6	[B
    //   15759: getstatic 651	com/chelpus/root/utils/corepatch:maskS6	[B
    //   15762: getstatic 653	com/chelpus/root/utils/corepatch:byteReplaceS6	[B
    //   15765: getstatic 655	com/chelpus/root/utils/corepatch:rep_maskS6	[B
    //   15768: iload 25
    //   15770: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   15773: ifeq +60 -> 15833
    //   15776: iload 4
    //   15778: istore_2
    //   15779: aload_0
    //   15780: iconst_0
    //   15781: aaload
    //   15782: ldc_w 946
    //   15785: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15788: ifeq +15 -> 15803
    //   15791: iload 4
    //   15793: istore_2
    //   15794: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15797: ldc_w 1272
    //   15800: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15803: iload 4
    //   15805: istore_2
    //   15806: aload_0
    //   15807: iconst_0
    //   15808: aaload
    //   15809: ldc_w 963
    //   15812: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15815: ifeq +9696 -> 25511
    //   15818: iload 4
    //   15820: istore_2
    //   15821: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15824: ldc_w 1274
    //   15827: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15830: goto +9681 -> 25511
    //   15833: iload_3
    //   15834: istore 4
    //   15836: iload_3
    //   15837: istore_2
    //   15838: iload 5
    //   15840: iload_1
    //   15841: getstatic 657	com/chelpus/root/utils/corepatch:byteOrigS7	[B
    //   15844: getstatic 659	com/chelpus/root/utils/corepatch:maskS7	[B
    //   15847: getstatic 661	com/chelpus/root/utils/corepatch:byteReplaceS7	[B
    //   15850: getstatic 663	com/chelpus/root/utils/corepatch:rep_maskS7	[B
    //   15853: iload 25
    //   15855: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   15858: ifeq +56 -> 15914
    //   15861: iload_3
    //   15862: istore_2
    //   15863: aload_0
    //   15864: iconst_0
    //   15865: aaload
    //   15866: ldc_w 946
    //   15869: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15872: ifeq +14 -> 15886
    //   15875: iload_3
    //   15876: istore_2
    //   15877: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15880: ldc_w 1302
    //   15883: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15886: iload_3
    //   15887: istore_2
    //   15888: aload_0
    //   15889: iconst_0
    //   15890: aaload
    //   15891: ldc_w 963
    //   15894: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15897: ifeq +9619 -> 25516
    //   15900: iload_3
    //   15901: istore_2
    //   15902: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15905: ldc_w 1304
    //   15908: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15911: goto +9605 -> 25516
    //   15914: iload 4
    //   15916: istore_3
    //   15917: iload 4
    //   15919: istore_2
    //   15920: iload 5
    //   15922: iload_1
    //   15923: getstatic 625	com/chelpus/root/utils/corepatch:byteOrigS3	[B
    //   15926: getstatic 627	com/chelpus/root/utils/corepatch:maskS3	[B
    //   15929: getstatic 629	com/chelpus/root/utils/corepatch:byteReplaceS3	[B
    //   15932: getstatic 631	com/chelpus/root/utils/corepatch:rep_maskS3	[B
    //   15935: iload 25
    //   15937: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   15940: ifeq +60 -> 16000
    //   15943: iload 4
    //   15945: istore_2
    //   15946: aload_0
    //   15947: iconst_0
    //   15948: aaload
    //   15949: ldc_w 946
    //   15952: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15955: ifeq +15 -> 15970
    //   15958: iload 4
    //   15960: istore_2
    //   15961: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15964: ldc_w 1306
    //   15967: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15970: iload 4
    //   15972: istore_2
    //   15973: aload_0
    //   15974: iconst_0
    //   15975: aaload
    //   15976: ldc_w 963
    //   15979: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15982: ifeq +9540 -> 25522
    //   15985: iload 4
    //   15987: istore_2
    //   15988: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   15991: ldc_w 1308
    //   15994: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   15997: goto +9525 -> 25522
    //   16000: iload_3
    //   16001: istore 4
    //   16003: iload_3
    //   16004: istore_2
    //   16005: iload 5
    //   16007: iload_1
    //   16008: getstatic 633	com/chelpus/root/utils/corepatch:byteOrigS4	[B
    //   16011: getstatic 635	com/chelpus/root/utils/corepatch:maskS4	[B
    //   16014: getstatic 637	com/chelpus/root/utils/corepatch:byteReplaceS4	[B
    //   16017: getstatic 639	com/chelpus/root/utils/corepatch:rep_maskS4	[B
    //   16020: iload 25
    //   16022: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   16025: ifeq +56 -> 16081
    //   16028: iload_3
    //   16029: istore_2
    //   16030: aload_0
    //   16031: iconst_0
    //   16032: aaload
    //   16033: ldc_w 946
    //   16036: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   16039: ifeq +14 -> 16053
    //   16042: iload_3
    //   16043: istore_2
    //   16044: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   16047: ldc_w 1310
    //   16050: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   16053: iload_3
    //   16054: istore_2
    //   16055: aload_0
    //   16056: iconst_0
    //   16057: aaload
    //   16058: ldc_w 963
    //   16061: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   16064: ifeq +9463 -> 25527
    //   16067: iload_3
    //   16068: istore_2
    //   16069: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   16072: ldc_w 1312
    //   16075: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   16078: goto +9449 -> 25527
    //   16081: iload 4
    //   16083: istore_3
    //   16084: iload 4
    //   16086: istore_2
    //   16087: iload 5
    //   16089: iload_1
    //   16090: getstatic 665	com/chelpus/root/utils/corepatch:byteOrigS13	[B
    //   16093: getstatic 667	com/chelpus/root/utils/corepatch:maskS13	[B
    //   16096: getstatic 669	com/chelpus/root/utils/corepatch:byteReplaceS13	[B
    //   16099: getstatic 671	com/chelpus/root/utils/corepatch:rep_maskS13	[B
    //   16102: iload 25
    //   16104: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   16107: ifeq +60 -> 16167
    //   16110: iload 4
    //   16112: istore_2
    //   16113: aload_0
    //   16114: iconst_0
    //   16115: aaload
    //   16116: ldc_w 946
    //   16119: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   16122: ifeq +15 -> 16137
    //   16125: iload 4
    //   16127: istore_2
    //   16128: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   16131: ldc_w 1310
    //   16134: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   16137: iload 4
    //   16139: istore_2
    //   16140: aload_0
    //   16141: iconst_0
    //   16142: aaload
    //   16143: ldc_w 963
    //   16146: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   16149: ifeq +9384 -> 25533
    //   16152: iload 4
    //   16154: istore_2
    //   16155: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   16158: ldc_w 1312
    //   16161: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   16164: goto +9369 -> 25533
    //   16167: iload_3
    //   16168: istore_2
    //   16169: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   16172: iload 5
    //   16174: iconst_1
    //   16175: iadd
    //   16176: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   16179: pop
    //   16180: lload 30
    //   16182: lconst_1
    //   16183: ladd
    //   16184: lstore 30
    //   16186: goto -720 -> 15466
    //   16189: getstatic 303	com/chelpus/root/utils/corepatch:onlyDalvik	Z
    //   16192: ifeq +94 -> 16286
    //   16195: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   16198: new 1031	java/lang/StringBuilder
    //   16201: dup
    //   16202: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   16205: ldc_w 1314
    //   16208: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16211: aload_0
    //   16212: iconst_1
    //   16213: aaload
    //   16214: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16217: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16220: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   16223: new 980	java/io/File
    //   16226: dup
    //   16227: aload_0
    //   16228: iconst_1
    //   16229: aaload
    //   16230: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   16233: astore 32
    //   16235: aload 32
    //   16237: astore 33
    //   16239: aload 32
    //   16241: astore 33
    //   16243: aload 32
    //   16245: invokevirtual 988	java/io/File:exists	()Z
    //   16248: ifne +19 -> 16267
    //   16251: aload 32
    //   16253: astore 33
    //   16255: aload 32
    //   16257: astore 33
    //   16259: new 883	java/io/FileNotFoundException
    //   16262: dup
    //   16263: invokespecial 1315	java/io/FileNotFoundException:<init>	()V
    //   16266: athrow
    //   16267: aload 32
    //   16269: astore 33
    //   16271: aload 32
    //   16273: astore 33
    //   16275: aload 37
    //   16277: aload 32
    //   16279: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   16282: pop
    //   16283: goto -9548 -> 6735
    //   16286: new 980	java/io/File
    //   16289: dup
    //   16290: aload_0
    //   16291: iconst_1
    //   16292: aaload
    //   16293: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   16296: astore 32
    //   16298: aload 32
    //   16300: astore 33
    //   16302: aload 32
    //   16304: astore 33
    //   16306: aload 32
    //   16308: invokevirtual 988	java/io/File:exists	()Z
    //   16311: ifne +54 -> 16365
    //   16314: aload 32
    //   16316: astore 33
    //   16318: aload 32
    //   16320: astore 33
    //   16322: new 883	java/io/FileNotFoundException
    //   16325: dup
    //   16326: invokespecial 1315	java/io/FileNotFoundException:<init>	()V
    //   16329: athrow
    //   16330: astore 32
    //   16332: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   16335: new 1031	java/lang/StringBuilder
    //   16338: dup
    //   16339: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   16342: ldc_w 1317
    //   16345: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16348: aload 32
    //   16350: invokevirtual 1318	java/lang/Exception:toString	()Ljava/lang/String;
    //   16353: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16356: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16359: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   16362: goto -7463 -> 8899
    //   16365: aload 32
    //   16367: astore 33
    //   16369: aload 32
    //   16371: astore 33
    //   16373: aload 32
    //   16375: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   16378: ldc_w 1320
    //   16381: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   16384: ifeq +71 -> 16455
    //   16387: aload 32
    //   16389: astore 33
    //   16391: aload 32
    //   16393: astore 33
    //   16395: new 980	java/io/File
    //   16398: dup
    //   16399: ldc_w 1322
    //   16402: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   16405: astore 34
    //   16407: aload 32
    //   16409: astore 33
    //   16411: aload 32
    //   16413: astore 33
    //   16415: aload 34
    //   16417: invokevirtual 988	java/io/File:exists	()Z
    //   16420: ifeq +35 -> 16455
    //   16423: aload 32
    //   16425: astore 33
    //   16427: aload 32
    //   16429: astore 33
    //   16431: aload 34
    //   16433: invokevirtual 1168	java/io/File:length	()J
    //   16436: lconst_0
    //   16437: lcmp
    //   16438: ifne +17 -> 16455
    //   16441: aload 32
    //   16443: astore 33
    //   16445: aload 32
    //   16447: astore 33
    //   16449: aload 34
    //   16451: invokevirtual 1132	java/io/File:delete	()Z
    //   16454: pop
    //   16455: aload 32
    //   16457: astore 33
    //   16459: aload 32
    //   16461: astore 33
    //   16463: aload 37
    //   16465: aload 32
    //   16467: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   16470: pop
    //   16471: aload 32
    //   16473: astore 33
    //   16475: aload 32
    //   16477: astore 33
    //   16479: aload 32
    //   16481: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   16484: ldc_w 1322
    //   16487: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   16490: ifeq +126 -> 16616
    //   16493: aload 32
    //   16495: astore 33
    //   16497: aload 32
    //   16499: astore 33
    //   16501: getstatic 1014	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:api	I
    //   16504: bipush 20
    //   16506: if_icmpge +110 -> 16616
    //   16509: aload 32
    //   16511: astore 33
    //   16513: aload 32
    //   16515: astore 33
    //   16517: getstatic 1325	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:runtime	Ljava/lang/String;
    //   16520: ldc_w 1188
    //   16523: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   16526: ifne +90 -> 16616
    //   16529: aload 32
    //   16531: astore 33
    //   16533: aload 32
    //   16535: astore 33
    //   16537: new 980	java/io/File
    //   16540: dup
    //   16541: ldc_w 1190
    //   16544: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   16547: astore 34
    //   16549: aload 32
    //   16551: astore 33
    //   16553: aload 32
    //   16555: astore 33
    //   16557: aload 34
    //   16559: invokevirtual 988	java/io/File:exists	()Z
    //   16562: ifeq +54 -> 16616
    //   16565: aload 32
    //   16567: astore 33
    //   16569: aload 32
    //   16571: astore 33
    //   16573: aload 34
    //   16575: invokevirtual 1168	java/io/File:length	()J
    //   16578: lconst_0
    //   16579: lcmp
    //   16580: ifne +20 -> 16600
    //   16583: aload 32
    //   16585: astore 33
    //   16587: aload 32
    //   16589: astore 33
    //   16591: aload 34
    //   16593: invokevirtual 1132	java/io/File:delete	()Z
    //   16596: pop
    //   16597: goto -9862 -> 6735
    //   16600: aload 32
    //   16602: astore 33
    //   16604: aload 32
    //   16606: astore 33
    //   16608: aload 37
    //   16610: aload 34
    //   16612: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   16615: pop
    //   16616: goto -9881 -> 6735
    //   16619: astore 35
    //   16621: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   16624: new 1031	java/lang/StringBuilder
    //   16627: dup
    //   16628: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   16631: ldc_w 299
    //   16634: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16637: aload 35
    //   16639: invokevirtual 1129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16642: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16645: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   16648: iload_2
    //   16649: istore 4
    //   16651: aload 34
    //   16653: invokevirtual 1106	java/nio/channels/FileChannel:close	()V
    //   16656: aload_0
    //   16657: iconst_4
    //   16658: aaload
    //   16659: ldc_w 910
    //   16662: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   16665: ifeq +2330 -> 18995
    //   16668: aload 33
    //   16670: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   16673: ldc_w 1161
    //   16676: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   16679: ifeq +143 -> 16822
    //   16682: iconst_0
    //   16683: putstatic 305	com/chelpus/root/utils/corepatch:not_found_bytes_for_patch	Z
    //   16686: aload 33
    //   16688: invokestatic 1333	com/chelpus/Utils:fixadler	(Ljava/io/File;)V
    //   16691: iload 4
    //   16693: ifeq +2295 -> 18988
    //   16696: aload_0
    //   16697: iconst_1
    //   16698: aaload
    //   16699: ldc_w 1335
    //   16702: ldc_w 1337
    //   16705: invokevirtual 1341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   16708: astore 34
    //   16710: aload_0
    //   16711: iconst_1
    //   16712: aaload
    //   16713: astore 35
    //   16715: new 980	java/io/File
    //   16718: dup
    //   16719: aload 34
    //   16721: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   16724: invokevirtual 1132	java/io/File:delete	()Z
    //   16727: pop
    //   16728: new 974	java/util/ArrayList
    //   16731: dup
    //   16732: invokespecial 975	java/util/ArrayList:<init>	()V
    //   16735: astore 36
    //   16737: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   16740: ldc_w 1343
    //   16743: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   16746: aload 36
    //   16748: new 1345	com/android/vending/billing/InAppBillingService/LACK/AddFilesItem
    //   16751: dup
    //   16752: aload 33
    //   16754: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16757: new 1031	java/lang/StringBuilder
    //   16760: dup
    //   16761: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   16764: aload 33
    //   16766: invokestatic 1156	com/chelpus/Utils:getDirs	(Ljava/io/File;)Ljava/io/File;
    //   16769: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16772: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16775: ldc_w 1347
    //   16778: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16781: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16784: invokespecial 1350	com/android/vending/billing/InAppBillingService/LACK/AddFilesItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   16787: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   16790: pop
    //   16791: aload 35
    //   16793: aload 34
    //   16795: aload 36
    //   16797: invokestatic 1354	com/chelpus/Utils:addFilesToZip	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   16800: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   16803: ldc_w 1356
    //   16806: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   16809: new 980	java/io/File
    //   16812: dup
    //   16813: aload 35
    //   16815: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   16818: invokevirtual 1132	java/io/File:delete	()Z
    //   16821: pop
    //   16822: aload 33
    //   16824: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   16827: ldc_w 1358
    //   16830: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   16833: ifne +17 -> 16850
    //   16836: aload 33
    //   16838: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   16841: ldc_w 1360
    //   16844: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   16847: ifeq +96 -> 16943
    //   16850: aload 33
    //   16852: aconst_null
    //   16853: invokestatic 1363	com/chelpus/Utils:fixadlerOdex	(Ljava/io/File;Ljava/lang/String;)V
    //   16856: iload 4
    //   16858: ifeq +85 -> 16943
    //   16861: aload 33
    //   16863: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   16866: ldc_w 1358
    //   16869: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   16872: ifeq +30 -> 16902
    //   16875: aload 33
    //   16877: new 980	java/io/File
    //   16880: dup
    //   16881: aload 33
    //   16883: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16886: ldc_w 1358
    //   16889: ldc_w 1365
    //   16892: invokevirtual 1341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   16895: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   16898: invokevirtual 1368	java/io/File:renameTo	(Ljava/io/File;)Z
    //   16901: pop
    //   16902: aload 33
    //   16904: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   16907: ldc_w 1360
    //   16910: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   16913: ifeq +30 -> 16943
    //   16916: aload 33
    //   16918: new 980	java/io/File
    //   16921: dup
    //   16922: aload 33
    //   16924: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16927: ldc_w 1360
    //   16930: ldc_w 1370
    //   16933: invokevirtual 1341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   16936: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   16939: invokevirtual 1368	java/io/File:renameTo	(Ljava/io/File;)Z
    //   16942: pop
    //   16943: aload 33
    //   16945: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   16948: ldc_w 1372
    //   16951: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   16954: ifeq -10212 -> 6742
    //   16957: iload 4
    //   16959: ifeq -10217 -> 6742
    //   16962: aload 33
    //   16964: new 980	java/io/File
    //   16967: dup
    //   16968: aload 33
    //   16970: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16973: ldc_w 1372
    //   16976: ldc_w 1374
    //   16979: invokevirtual 1341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   16982: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   16985: invokevirtual 1368	java/io/File:renameTo	(Ljava/io/File;)Z
    //   16988: pop
    //   16989: goto -10247 -> 6742
    //   16992: iconst_0
    //   16993: istore 7
    //   16995: iconst_0
    //   16996: istore 6
    //   16998: iconst_0
    //   16999: istore 5
    //   17001: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   17004: sipush 4120
    //   17007: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   17010: pop
    //   17011: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   17014: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   17017: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   17020: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   17023: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   17026: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   17029: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   17032: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   17035: invokestatic 1073	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   17038: istore_2
    //   17039: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17042: new 1031	java/lang/StringBuilder
    //   17045: dup
    //   17046: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   17049: ldc_w 1075
    //   17052: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17055: iload_2
    //   17056: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17059: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17062: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17065: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   17068: iload_2
    //   17069: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   17072: pop
    //   17073: iload_3
    //   17074: istore 4
    //   17076: iload_3
    //   17077: istore_2
    //   17078: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   17081: invokevirtual 1081	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   17084: ifeq -433 -> 16651
    //   17087: iload_3
    //   17088: istore_2
    //   17089: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   17092: invokevirtual 1083	java/nio/MappedByteBuffer:position	()I
    //   17095: istore 8
    //   17097: iload_3
    //   17098: istore_2
    //   17099: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   17102: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   17105: istore_1
    //   17106: iload_3
    //   17107: istore 4
    //   17109: iload_3
    //   17110: istore_2
    //   17111: iload 8
    //   17113: iload_1
    //   17114: getstatic 321	com/chelpus/root/utils/corepatch:byteOrigOatUpd1	[B
    //   17117: getstatic 323	com/chelpus/root/utils/corepatch:maskOatUpd1	[B
    //   17120: getstatic 325	com/chelpus/root/utils/corepatch:byteReplaceOatUpd1	[B
    //   17123: getstatic 327	com/chelpus/root/utils/corepatch:rep_maskOatUpd1	[B
    //   17126: iload 28
    //   17128: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   17131: ifeq +85 -> 17216
    //   17134: iload_3
    //   17135: istore_2
    //   17136: aload_0
    //   17137: iconst_0
    //   17138: aaload
    //   17139: ldc_w 946
    //   17142: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17145: ifeq +43 -> 17188
    //   17148: iload_3
    //   17149: istore_2
    //   17150: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17153: new 1031	java/lang/StringBuilder
    //   17156: dup
    //   17157: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   17160: ldc_w 1087
    //   17163: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17166: iload 8
    //   17168: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17171: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17174: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17177: iload_3
    //   17178: istore_2
    //   17179: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17182: ldc_w 1089
    //   17185: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17188: iload_3
    //   17189: istore_2
    //   17190: aload_0
    //   17191: iconst_0
    //   17192: aaload
    //   17193: ldc_w 963
    //   17196: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17199: ifeq +8349 -> 25548
    //   17202: iload_3
    //   17203: istore_2
    //   17204: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17207: ldc_w 1091
    //   17210: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17213: goto +8335 -> 25548
    //   17216: iload 4
    //   17218: istore_3
    //   17219: iload 4
    //   17221: istore_2
    //   17222: iload 8
    //   17224: iload_1
    //   17225: getstatic 329	com/chelpus/root/utils/corepatch:byteOrigOatUpd2	[B
    //   17228: getstatic 331	com/chelpus/root/utils/corepatch:maskOatUpd2	[B
    //   17231: getstatic 333	com/chelpus/root/utils/corepatch:byteReplaceOatUpd2	[B
    //   17234: getstatic 335	com/chelpus/root/utils/corepatch:rep_maskOatUpd2	[B
    //   17237: iload 28
    //   17239: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   17242: ifeq +90 -> 17332
    //   17245: iload 4
    //   17247: istore_2
    //   17248: aload_0
    //   17249: iconst_0
    //   17250: aaload
    //   17251: ldc_w 946
    //   17254: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17257: ifeq +45 -> 17302
    //   17260: iload 4
    //   17262: istore_2
    //   17263: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17266: new 1031	java/lang/StringBuilder
    //   17269: dup
    //   17270: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   17273: ldc_w 1087
    //   17276: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17279: iload 8
    //   17281: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17284: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17287: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17290: iload 4
    //   17292: istore_2
    //   17293: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17296: ldc_w 1089
    //   17299: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17302: iload 4
    //   17304: istore_2
    //   17305: aload_0
    //   17306: iconst_0
    //   17307: aaload
    //   17308: ldc_w 963
    //   17311: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17314: ifeq +8243 -> 25557
    //   17317: iload 4
    //   17319: istore_2
    //   17320: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17323: ldc_w 1091
    //   17326: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17329: goto +8228 -> 25557
    //   17332: iload_3
    //   17333: istore 4
    //   17335: iload_3
    //   17336: istore_2
    //   17337: iload 8
    //   17339: iload_1
    //   17340: getstatic 337	com/chelpus/root/utils/corepatch:byteOrigOat1	[B
    //   17343: getstatic 339	com/chelpus/root/utils/corepatch:maskOat1	[B
    //   17346: getstatic 341	com/chelpus/root/utils/corepatch:byteReplaceOat1	[B
    //   17349: getstatic 343	com/chelpus/root/utils/corepatch:rep_maskOat1	[B
    //   17352: iload 28
    //   17354: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   17357: ifeq +85 -> 17442
    //   17360: iload_3
    //   17361: istore_2
    //   17362: aload_0
    //   17363: iconst_0
    //   17364: aaload
    //   17365: ldc_w 946
    //   17368: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17371: ifeq +43 -> 17414
    //   17374: iload_3
    //   17375: istore_2
    //   17376: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17379: new 1031	java/lang/StringBuilder
    //   17382: dup
    //   17383: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   17386: ldc_w 1087
    //   17389: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17392: iload 8
    //   17394: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17397: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17400: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17403: iload_3
    //   17404: istore_2
    //   17405: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17408: ldc_w 1093
    //   17411: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17414: iload_3
    //   17415: istore_2
    //   17416: aload_0
    //   17417: iconst_0
    //   17418: aaload
    //   17419: ldc_w 963
    //   17422: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17425: ifeq +8140 -> 25565
    //   17428: iload_3
    //   17429: istore_2
    //   17430: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17433: ldc_w 1095
    //   17436: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17439: goto +8126 -> 25565
    //   17442: iload 4
    //   17444: istore_3
    //   17445: iload 4
    //   17447: istore_2
    //   17448: iload 8
    //   17450: iload_1
    //   17451: getstatic 369	com/chelpus/root/utils/corepatch:byteOrigOatUpd4	[B
    //   17454: getstatic 371	com/chelpus/root/utils/corepatch:maskOatUpd4	[B
    //   17457: getstatic 373	com/chelpus/root/utils/corepatch:byteReplaceOatUpd4	[B
    //   17460: getstatic 375	com/chelpus/root/utils/corepatch:rep_maskOatUpd4	[B
    //   17463: iload 28
    //   17465: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   17468: ifeq +90 -> 17558
    //   17471: iload 4
    //   17473: istore_2
    //   17474: aload_0
    //   17475: iconst_0
    //   17476: aaload
    //   17477: ldc_w 946
    //   17480: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17483: ifeq +45 -> 17528
    //   17486: iload 4
    //   17488: istore_2
    //   17489: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17492: new 1031	java/lang/StringBuilder
    //   17495: dup
    //   17496: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   17499: ldc_w 1087
    //   17502: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17505: iload 8
    //   17507: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17510: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17513: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17516: iload 4
    //   17518: istore_2
    //   17519: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17522: ldc_w 1089
    //   17525: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17528: iload 4
    //   17530: istore_2
    //   17531: aload_0
    //   17532: iconst_0
    //   17533: aaload
    //   17534: ldc_w 963
    //   17537: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17540: ifeq +8034 -> 25574
    //   17543: iload 4
    //   17545: istore_2
    //   17546: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17549: ldc_w 1091
    //   17552: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17555: goto +8019 -> 25574
    //   17558: iload_3
    //   17559: istore 4
    //   17561: iload_3
    //   17562: istore_2
    //   17563: iload 8
    //   17565: iload_1
    //   17566: getstatic 377	com/chelpus/root/utils/corepatch:byteOrigOatUpd4_1	[B
    //   17569: getstatic 379	com/chelpus/root/utils/corepatch:maskOatUpd4_1	[B
    //   17572: getstatic 381	com/chelpus/root/utils/corepatch:byteReplaceOatUpd4_1	[B
    //   17575: getstatic 383	com/chelpus/root/utils/corepatch:rep_maskOatUpd4_1	[B
    //   17578: iload 28
    //   17580: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   17583: ifeq +85 -> 17668
    //   17586: iload_3
    //   17587: istore_2
    //   17588: aload_0
    //   17589: iconst_0
    //   17590: aaload
    //   17591: ldc_w 946
    //   17594: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17597: ifeq +43 -> 17640
    //   17600: iload_3
    //   17601: istore_2
    //   17602: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17605: new 1031	java/lang/StringBuilder
    //   17608: dup
    //   17609: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   17612: ldc_w 1087
    //   17615: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17618: iload 8
    //   17620: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17623: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17626: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17629: iload_3
    //   17630: istore_2
    //   17631: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17634: ldc_w 1089
    //   17637: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17640: iload_3
    //   17641: istore_2
    //   17642: aload_0
    //   17643: iconst_0
    //   17644: aaload
    //   17645: ldc_w 963
    //   17648: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17651: ifeq +7931 -> 25582
    //   17654: iload_3
    //   17655: istore_2
    //   17656: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17659: ldc_w 1091
    //   17662: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17665: goto +7917 -> 25582
    //   17668: iload 4
    //   17670: istore_3
    //   17671: iload 4
    //   17673: istore_2
    //   17674: iload 8
    //   17676: iload_1
    //   17677: getstatic 385	com/chelpus/root/utils/corepatch:byteOrigOatUpd5	[B
    //   17680: getstatic 387	com/chelpus/root/utils/corepatch:maskOatUpd5	[B
    //   17683: getstatic 389	com/chelpus/root/utils/corepatch:byteReplaceOatUpd5	[B
    //   17686: getstatic 391	com/chelpus/root/utils/corepatch:rep_maskOatUpd5	[B
    //   17689: iload 28
    //   17691: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   17694: ifeq +90 -> 17784
    //   17697: iload 4
    //   17699: istore_2
    //   17700: aload_0
    //   17701: iconst_0
    //   17702: aaload
    //   17703: ldc_w 946
    //   17706: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17709: ifeq +45 -> 17754
    //   17712: iload 4
    //   17714: istore_2
    //   17715: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17718: new 1031	java/lang/StringBuilder
    //   17721: dup
    //   17722: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   17725: ldc_w 1087
    //   17728: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17731: iload 8
    //   17733: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17736: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17739: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17742: iload 4
    //   17744: istore_2
    //   17745: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17748: ldc_w 1089
    //   17751: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17754: iload 4
    //   17756: istore_2
    //   17757: aload_0
    //   17758: iconst_0
    //   17759: aaload
    //   17760: ldc_w 963
    //   17763: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17766: ifeq +7825 -> 25591
    //   17769: iload 4
    //   17771: istore_2
    //   17772: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17775: ldc_w 1091
    //   17778: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17781: goto +7810 -> 25591
    //   17784: iload_3
    //   17785: istore 4
    //   17787: iload_3
    //   17788: istore_2
    //   17789: iload 8
    //   17791: iload_1
    //   17792: getstatic 393	com/chelpus/root/utils/corepatch:byteOrigOatUpd5_1	[B
    //   17795: getstatic 395	com/chelpus/root/utils/corepatch:maskOatUpd5_1	[B
    //   17798: getstatic 397	com/chelpus/root/utils/corepatch:byteReplaceOatUpd5_1	[B
    //   17801: getstatic 399	com/chelpus/root/utils/corepatch:rep_maskOatUpd5_1	[B
    //   17804: iload 28
    //   17806: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   17809: ifeq +85 -> 17894
    //   17812: iload_3
    //   17813: istore_2
    //   17814: aload_0
    //   17815: iconst_0
    //   17816: aaload
    //   17817: ldc_w 946
    //   17820: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17823: ifeq +43 -> 17866
    //   17826: iload_3
    //   17827: istore_2
    //   17828: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17831: new 1031	java/lang/StringBuilder
    //   17834: dup
    //   17835: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   17838: ldc_w 1087
    //   17841: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17844: iload 8
    //   17846: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17849: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17852: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17855: iload_3
    //   17856: istore_2
    //   17857: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17860: ldc_w 1089
    //   17863: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17866: iload_3
    //   17867: istore_2
    //   17868: aload_0
    //   17869: iconst_0
    //   17870: aaload
    //   17871: ldc_w 963
    //   17874: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17877: ifeq +7722 -> 25599
    //   17880: iload_3
    //   17881: istore_2
    //   17882: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17885: ldc_w 1091
    //   17888: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17891: goto +7708 -> 25599
    //   17894: iload 4
    //   17896: istore_3
    //   17897: iload 4
    //   17899: istore_2
    //   17900: iload 8
    //   17902: iload_1
    //   17903: getstatic 401	com/chelpus/root/utils/corepatch:byteOrigOat4	[B
    //   17906: getstatic 403	com/chelpus/root/utils/corepatch:maskOat4	[B
    //   17909: getstatic 405	com/chelpus/root/utils/corepatch:byteReplaceOat4	[B
    //   17912: getstatic 407	com/chelpus/root/utils/corepatch:rep_maskOat4	[B
    //   17915: iload 28
    //   17917: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   17920: ifeq +90 -> 18010
    //   17923: iload 4
    //   17925: istore_2
    //   17926: aload_0
    //   17927: iconst_0
    //   17928: aaload
    //   17929: ldc_w 946
    //   17932: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17935: ifeq +45 -> 17980
    //   17938: iload 4
    //   17940: istore_2
    //   17941: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17944: new 1031	java/lang/StringBuilder
    //   17947: dup
    //   17948: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   17951: ldc_w 1087
    //   17954: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17957: iload 8
    //   17959: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17962: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17965: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17968: iload 4
    //   17970: istore_2
    //   17971: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   17974: ldc_w 1093
    //   17977: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   17980: iload 4
    //   17982: istore_2
    //   17983: aload_0
    //   17984: iconst_0
    //   17985: aaload
    //   17986: ldc_w 963
    //   17989: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17992: ifeq +7616 -> 25608
    //   17995: iload 4
    //   17997: istore_2
    //   17998: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18001: ldc_w 1095
    //   18004: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18007: goto +7601 -> 25608
    //   18010: iload_3
    //   18011: istore 4
    //   18013: iload_3
    //   18014: istore_2
    //   18015: iload 8
    //   18017: iload_1
    //   18018: getstatic 345	com/chelpus/root/utils/corepatch:byteOrigOat2	[B
    //   18021: getstatic 347	com/chelpus/root/utils/corepatch:maskOat2	[B
    //   18024: getstatic 349	com/chelpus/root/utils/corepatch:byteReplaceOat2	[B
    //   18027: getstatic 351	com/chelpus/root/utils/corepatch:rep_maskOat2	[B
    //   18030: iload 28
    //   18032: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   18035: ifeq +85 -> 18120
    //   18038: iload_3
    //   18039: istore_2
    //   18040: aload_0
    //   18041: iconst_0
    //   18042: aaload
    //   18043: ldc_w 946
    //   18046: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18049: ifeq +43 -> 18092
    //   18052: iload_3
    //   18053: istore_2
    //   18054: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18057: ldc_w 1097
    //   18060: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18063: iload_3
    //   18064: istore_2
    //   18065: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18068: new 1031	java/lang/StringBuilder
    //   18071: dup
    //   18072: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   18075: ldc_w 1087
    //   18078: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18081: iload 8
    //   18083: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18086: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18089: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18092: iload_3
    //   18093: istore_2
    //   18094: aload_0
    //   18095: iconst_0
    //   18096: aaload
    //   18097: ldc_w 963
    //   18100: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18103: ifeq +7513 -> 25616
    //   18106: iload_3
    //   18107: istore_2
    //   18108: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18111: ldc_w 1099
    //   18114: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18117: goto +7499 -> 25616
    //   18120: iload 4
    //   18122: istore_3
    //   18123: iload 4
    //   18125: istore_2
    //   18126: iload 8
    //   18128: iload_1
    //   18129: getstatic 409	com/chelpus/root/utils/corepatch:byteOrigOat5	[B
    //   18132: getstatic 411	com/chelpus/root/utils/corepatch:maskOat5	[B
    //   18135: getstatic 413	com/chelpus/root/utils/corepatch:byteReplaceOat5	[B
    //   18138: getstatic 415	com/chelpus/root/utils/corepatch:rep_maskOat5	[B
    //   18141: iload 28
    //   18143: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   18146: ifeq +90 -> 18236
    //   18149: iload 4
    //   18151: istore_2
    //   18152: aload_0
    //   18153: iconst_0
    //   18154: aaload
    //   18155: ldc_w 946
    //   18158: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18161: ifeq +45 -> 18206
    //   18164: iload 4
    //   18166: istore_2
    //   18167: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18170: ldc_w 1097
    //   18173: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18176: iload 4
    //   18178: istore_2
    //   18179: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18182: new 1031	java/lang/StringBuilder
    //   18185: dup
    //   18186: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   18189: ldc_w 1087
    //   18192: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18195: iload 8
    //   18197: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18200: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18203: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18206: iload 4
    //   18208: istore_2
    //   18209: aload_0
    //   18210: iconst_0
    //   18211: aaload
    //   18212: ldc_w 963
    //   18215: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18218: ifeq +7407 -> 25625
    //   18221: iload 4
    //   18223: istore_2
    //   18224: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18227: ldc_w 1099
    //   18230: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18233: goto +7392 -> 25625
    //   18236: iload_3
    //   18237: istore 4
    //   18239: iload_3
    //   18240: istore_2
    //   18241: iload 8
    //   18243: iload_1
    //   18244: getstatic 353	com/chelpus/root/utils/corepatch:byteOrigOat3	[B
    //   18247: getstatic 355	com/chelpus/root/utils/corepatch:maskOat3	[B
    //   18250: getstatic 357	com/chelpus/root/utils/corepatch:byteReplaceOat3	[B
    //   18253: getstatic 359	com/chelpus/root/utils/corepatch:rep_maskOat3	[B
    //   18256: iload 26
    //   18258: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   18261: ifeq +85 -> 18346
    //   18264: iload_3
    //   18265: istore_2
    //   18266: aload_0
    //   18267: iconst_0
    //   18268: aaload
    //   18269: ldc_w 946
    //   18272: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18275: ifeq +43 -> 18318
    //   18278: iload_3
    //   18279: istore_2
    //   18280: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18283: ldc_w 1101
    //   18286: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18289: iload_3
    //   18290: istore_2
    //   18291: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18294: new 1031	java/lang/StringBuilder
    //   18297: dup
    //   18298: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   18301: ldc_w 1087
    //   18304: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18307: iload 8
    //   18309: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18312: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18315: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18318: iload_3
    //   18319: istore_2
    //   18320: aload_0
    //   18321: iconst_0
    //   18322: aaload
    //   18323: ldc_w 963
    //   18326: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18329: ifeq +7304 -> 25633
    //   18332: iload_3
    //   18333: istore_2
    //   18334: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18337: ldc_w 1103
    //   18340: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18343: goto +7290 -> 25633
    //   18346: iload 4
    //   18348: istore_3
    //   18349: iload 4
    //   18351: istore_2
    //   18352: iload 8
    //   18354: iload_1
    //   18355: getstatic 361	com/chelpus/root/utils/corepatch:byteOrigOat6_3	[B
    //   18358: getstatic 363	com/chelpus/root/utils/corepatch:maskOat6_3	[B
    //   18361: getstatic 365	com/chelpus/root/utils/corepatch:byteReplaceOat6_3	[B
    //   18364: getstatic 367	com/chelpus/root/utils/corepatch:rep_maskOat6_3	[B
    //   18367: iload 26
    //   18369: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   18372: ifeq +90 -> 18462
    //   18375: iload 4
    //   18377: istore_2
    //   18378: aload_0
    //   18379: iconst_0
    //   18380: aaload
    //   18381: ldc_w 946
    //   18384: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18387: ifeq +45 -> 18432
    //   18390: iload 4
    //   18392: istore_2
    //   18393: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18396: ldc_w 1101
    //   18399: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18402: iload 4
    //   18404: istore_2
    //   18405: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18408: new 1031	java/lang/StringBuilder
    //   18411: dup
    //   18412: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   18415: ldc_w 1087
    //   18418: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18421: iload 8
    //   18423: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18426: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18429: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18432: iload 4
    //   18434: istore_2
    //   18435: aload_0
    //   18436: iconst_0
    //   18437: aaload
    //   18438: ldc_w 963
    //   18441: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18444: ifeq +7198 -> 25642
    //   18447: iload 4
    //   18449: istore_2
    //   18450: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18453: ldc_w 1103
    //   18456: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18459: goto +7183 -> 25642
    //   18462: iload_3
    //   18463: istore 4
    //   18465: iload_3
    //   18466: istore_2
    //   18467: iload 8
    //   18469: iload_1
    //   18470: getstatic 417	com/chelpus/root/utils/corepatch:byteOrigOat6	[B
    //   18473: getstatic 419	com/chelpus/root/utils/corepatch:maskOat6	[B
    //   18476: getstatic 421	com/chelpus/root/utils/corepatch:byteReplaceOat6	[B
    //   18479: getstatic 423	com/chelpus/root/utils/corepatch:rep_maskOat6	[B
    //   18482: iload 26
    //   18484: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   18487: ifeq +85 -> 18572
    //   18490: iload_3
    //   18491: istore_2
    //   18492: aload_0
    //   18493: iconst_0
    //   18494: aaload
    //   18495: ldc_w 946
    //   18498: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18501: ifeq +43 -> 18544
    //   18504: iload_3
    //   18505: istore_2
    //   18506: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18509: ldc_w 1101
    //   18512: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18515: iload_3
    //   18516: istore_2
    //   18517: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18520: new 1031	java/lang/StringBuilder
    //   18523: dup
    //   18524: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   18527: ldc_w 1087
    //   18530: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18533: iload 8
    //   18535: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18538: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18541: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18544: iload_3
    //   18545: istore_2
    //   18546: aload_0
    //   18547: iconst_0
    //   18548: aaload
    //   18549: ldc_w 963
    //   18552: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18555: ifeq +7095 -> 25650
    //   18558: iload_3
    //   18559: istore_2
    //   18560: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18563: ldc_w 1103
    //   18566: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18569: goto +7081 -> 25650
    //   18572: iload 4
    //   18574: istore_3
    //   18575: iload 4
    //   18577: istore_2
    //   18578: iload 8
    //   18580: iload_1
    //   18581: getstatic 425	com/chelpus/root/utils/corepatch:byteOrigOat6_1	[B
    //   18584: getstatic 427	com/chelpus/root/utils/corepatch:maskOat6_1	[B
    //   18587: getstatic 429	com/chelpus/root/utils/corepatch:byteReplaceOat6_1	[B
    //   18590: getstatic 431	com/chelpus/root/utils/corepatch:rep_maskOat6_1	[B
    //   18593: iload 26
    //   18595: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   18598: ifeq +90 -> 18688
    //   18601: iload 4
    //   18603: istore_2
    //   18604: aload_0
    //   18605: iconst_0
    //   18606: aaload
    //   18607: ldc_w 946
    //   18610: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18613: ifeq +45 -> 18658
    //   18616: iload 4
    //   18618: istore_2
    //   18619: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18622: ldc_w 1101
    //   18625: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18628: iload 4
    //   18630: istore_2
    //   18631: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18634: new 1031	java/lang/StringBuilder
    //   18637: dup
    //   18638: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   18641: ldc_w 1087
    //   18644: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18647: iload 8
    //   18649: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18652: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18655: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18658: iload 4
    //   18660: istore_2
    //   18661: aload_0
    //   18662: iconst_0
    //   18663: aaload
    //   18664: ldc_w 963
    //   18667: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18670: ifeq +6989 -> 25659
    //   18673: iload 4
    //   18675: istore_2
    //   18676: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18679: ldc_w 1103
    //   18682: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18685: goto +6974 -> 25659
    //   18688: iload_3
    //   18689: istore 4
    //   18691: iload_3
    //   18692: istore_2
    //   18693: iload 8
    //   18695: iload_1
    //   18696: getstatic 433	com/chelpus/root/utils/corepatch:byteOrigOat7	[B
    //   18699: getstatic 435	com/chelpus/root/utils/corepatch:maskOat7	[B
    //   18702: getstatic 437	com/chelpus/root/utils/corepatch:byteReplaceOat7	[B
    //   18705: getstatic 439	com/chelpus/root/utils/corepatch:rep_maskOat7	[B
    //   18708: iload 26
    //   18710: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   18713: ifeq +85 -> 18798
    //   18716: iload_3
    //   18717: istore_2
    //   18718: aload_0
    //   18719: iconst_0
    //   18720: aaload
    //   18721: ldc_w 946
    //   18724: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18727: ifeq +43 -> 18770
    //   18730: iload_3
    //   18731: istore_2
    //   18732: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18735: ldc_w 1101
    //   18738: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18741: iload_3
    //   18742: istore_2
    //   18743: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18746: new 1031	java/lang/StringBuilder
    //   18749: dup
    //   18750: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   18753: ldc_w 1087
    //   18756: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18759: iload 8
    //   18761: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18764: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18767: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18770: iload_3
    //   18771: istore_2
    //   18772: aload_0
    //   18773: iconst_0
    //   18774: aaload
    //   18775: ldc_w 963
    //   18778: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18781: ifeq +6886 -> 25667
    //   18784: iload_3
    //   18785: istore_2
    //   18786: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18789: ldc_w 1103
    //   18792: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18795: goto +6872 -> 25667
    //   18798: iload 4
    //   18800: istore_2
    //   18801: iload 4
    //   18803: istore_3
    //   18804: iload 8
    //   18806: iload_1
    //   18807: getstatic 441	com/chelpus/root/utils/corepatch:byteOrigOat7_1	[B
    //   18810: getstatic 443	com/chelpus/root/utils/corepatch:maskOat7_1	[B
    //   18813: getstatic 445	com/chelpus/root/utils/corepatch:byteReplaceOat7_1	[B
    //   18816: getstatic 447	com/chelpus/root/utils/corepatch:rep_maskOat7_1	[B
    //   18819: iload 26
    //   18821: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   18824: ifeq +6857 -> 25681
    //   18827: iload 4
    //   18829: istore_2
    //   18830: aload_0
    //   18831: iconst_0
    //   18832: aaload
    //   18833: ldc_w 946
    //   18836: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18839: ifeq +45 -> 18884
    //   18842: iload 4
    //   18844: istore_2
    //   18845: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18848: ldc_w 1101
    //   18851: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18854: iload 4
    //   18856: istore_2
    //   18857: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18860: new 1031	java/lang/StringBuilder
    //   18863: dup
    //   18864: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   18867: ldc_w 1087
    //   18870: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18873: iload 8
    //   18875: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18878: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18881: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18884: iload 4
    //   18886: istore_2
    //   18887: aload_0
    //   18888: iconst_0
    //   18889: aaload
    //   18890: ldc_w 963
    //   18893: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18896: ifeq +6780 -> 25676
    //   18899: iload 4
    //   18901: istore_2
    //   18902: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18905: ldc_w 1103
    //   18908: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18911: goto +6765 -> 25676
    //   18914: iload_3
    //   18915: istore_2
    //   18916: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   18919: iload 8
    //   18921: iconst_1
    //   18922: iadd
    //   18923: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   18926: pop
    //   18927: goto -1854 -> 17073
    //   18930: astore 35
    //   18932: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   18935: new 1031	java/lang/StringBuilder
    //   18938: dup
    //   18939: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   18942: ldc_w 299
    //   18945: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18948: aload 35
    //   18950: invokevirtual 1129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18953: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18956: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18959: iload_2
    //   18960: istore 4
    //   18962: goto -2311 -> 16651
    //   18965: astore 35
    //   18967: aload 35
    //   18969: invokevirtual 1110	java/lang/Exception:printStackTrace	()V
    //   18972: new 980	java/io/File
    //   18975: dup
    //   18976: aload 34
    //   18978: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   18981: invokevirtual 1132	java/io/File:delete	()Z
    //   18984: pop
    //   18985: goto -2163 -> 16822
    //   18988: iconst_1
    //   18989: putstatic 305	com/chelpus/root/utils/corepatch:not_found_bytes_for_patch	Z
    //   18992: goto -2170 -> 16822
    //   18995: aload 33
    //   18997: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   19000: ldc_w 1161
    //   19003: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   19006: ifeq +578 -> 19584
    //   19009: aload 33
    //   19011: invokestatic 1333	com/chelpus/Utils:fixadler	(Ljava/io/File;)V
    //   19014: aload_0
    //   19015: iconst_4
    //   19016: aaload
    //   19017: ldc_w 1188
    //   19020: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   19023: ifeq +631 -> 19654
    //   19026: aload 33
    //   19028: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   19031: ldc_w 1161
    //   19034: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   19037: ifeq -12295 -> 6742
    //   19040: iload 4
    //   19042: ifeq -12300 -> 6742
    //   19045: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19048: ldc_w 1376
    //   19051: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19054: ldc_w 1192
    //   19057: ldc_w 1378
    //   19060: iconst_1
    //   19061: iconst_0
    //   19062: invokestatic 1382	com/chelpus/Utils:copyFile	(Ljava/lang/String;Ljava/lang/String;ZZ)Z
    //   19065: ifeq +563 -> 19628
    //   19068: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19071: ldc_w 1384
    //   19074: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19077: new 980	java/io/File
    //   19080: dup
    //   19081: ldc_w 1378
    //   19084: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19087: invokevirtual 1132	java/io/File:delete	()Z
    //   19090: pop
    //   19091: new 974	java/util/ArrayList
    //   19094: dup
    //   19095: invokespecial 975	java/util/ArrayList:<init>	()V
    //   19098: astore 33
    //   19100: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19103: ldc_w 1343
    //   19106: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19109: aload 33
    //   19111: new 1345	com/android/vending/billing/InAppBillingService/LACK/AddFilesItem
    //   19114: dup
    //   19115: ldc_w 1196
    //   19118: ldc_w 1386
    //   19121: invokespecial 1350	com/android/vending/billing/InAppBillingService/LACK/AddFilesItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19124: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   19127: pop
    //   19128: ldc_w 1192
    //   19131: ldc_w 1378
    //   19134: aload 33
    //   19136: invokestatic 1354	com/chelpus/Utils:addFilesToZip	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   19139: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19142: ldc_w 1356
    //   19145: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19148: iconst_3
    //   19149: anewarray 904	java/lang/String
    //   19152: dup
    //   19153: iconst_0
    //   19154: ldc_w 1388
    //   19157: aastore
    //   19158: dup
    //   19159: iconst_1
    //   19160: ldc_w 1390
    //   19163: aastore
    //   19164: dup
    //   19165: iconst_2
    //   19166: ldc_w 1378
    //   19169: aastore
    //   19170: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19173: iconst_3
    //   19174: anewarray 904	java/lang/String
    //   19177: dup
    //   19178: iconst_0
    //   19179: ldc_w 1395
    //   19182: aastore
    //   19183: dup
    //   19184: iconst_1
    //   19185: ldc_w 1397
    //   19188: aastore
    //   19189: dup
    //   19190: iconst_2
    //   19191: ldc_w 1378
    //   19194: aastore
    //   19195: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19198: iconst_3
    //   19199: anewarray 904	java/lang/String
    //   19202: dup
    //   19203: iconst_0
    //   19204: ldc_w 1388
    //   19207: aastore
    //   19208: dup
    //   19209: iconst_1
    //   19210: ldc_w 1399
    //   19213: aastore
    //   19214: dup
    //   19215: iconst_2
    //   19216: ldc_w 1378
    //   19219: aastore
    //   19220: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19223: iconst_2
    //   19224: anewarray 904	java/lang/String
    //   19227: dup
    //   19228: iconst_0
    //   19229: ldc_w 1401
    //   19232: aastore
    //   19233: dup
    //   19234: iconst_1
    //   19235: ldc_w 1192
    //   19238: aastore
    //   19239: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19242: new 980	java/io/File
    //   19245: dup
    //   19246: ldc_w 1192
    //   19249: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19252: invokevirtual 988	java/io/File:exists	()Z
    //   19255: ifeq +17 -> 19272
    //   19258: new 980	java/io/File
    //   19261: dup
    //   19262: ldc_w 1192
    //   19265: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19268: invokevirtual 1132	java/io/File:delete	()Z
    //   19271: pop
    //   19272: iconst_3
    //   19273: anewarray 904	java/lang/String
    //   19276: dup
    //   19277: iconst_0
    //   19278: ldc_w 1403
    //   19281: aastore
    //   19282: dup
    //   19283: iconst_1
    //   19284: ldc_w 1405
    //   19287: aastore
    //   19288: dup
    //   19289: iconst_2
    //   19290: ldc_w 1192
    //   19293: aastore
    //   19294: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19297: new 980	java/io/File
    //   19300: dup
    //   19301: ldc_w 1192
    //   19304: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19307: invokevirtual 988	java/io/File:exists	()Z
    //   19310: ifne +27 -> 19337
    //   19313: new 980	java/io/File
    //   19316: dup
    //   19317: ldc_w 1378
    //   19320: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19323: new 980	java/io/File
    //   19326: dup
    //   19327: ldc_w 1192
    //   19330: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19333: invokevirtual 1368	java/io/File:renameTo	(Ljava/io/File;)Z
    //   19336: pop
    //   19337: iconst_3
    //   19338: anewarray 904	java/lang/String
    //   19341: dup
    //   19342: iconst_0
    //   19343: ldc_w 1388
    //   19346: aastore
    //   19347: dup
    //   19348: iconst_1
    //   19349: ldc_w 1390
    //   19352: aastore
    //   19353: dup
    //   19354: iconst_2
    //   19355: ldc_w 1192
    //   19358: aastore
    //   19359: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19362: iconst_3
    //   19363: anewarray 904	java/lang/String
    //   19366: dup
    //   19367: iconst_0
    //   19368: ldc_w 1395
    //   19371: aastore
    //   19372: dup
    //   19373: iconst_1
    //   19374: ldc_w 1397
    //   19377: aastore
    //   19378: dup
    //   19379: iconst_2
    //   19380: ldc_w 1192
    //   19383: aastore
    //   19384: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19387: iconst_3
    //   19388: anewarray 904	java/lang/String
    //   19391: dup
    //   19392: iconst_0
    //   19393: ldc_w 1388
    //   19396: aastore
    //   19397: dup
    //   19398: iconst_1
    //   19399: ldc_w 1399
    //   19402: aastore
    //   19403: dup
    //   19404: iconst_2
    //   19405: ldc_w 1192
    //   19408: aastore
    //   19409: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19412: ldc_w 1192
    //   19415: invokestatic 1409	com/chelpus/Utils:getFileDalvikCache	(Ljava/lang/String;)Ljava/io/File;
    //   19418: astore 33
    //   19420: aload 33
    //   19422: ifnull +38 -> 19460
    //   19425: iconst_2
    //   19426: anewarray 904	java/lang/String
    //   19429: dup
    //   19430: iconst_0
    //   19431: ldc_w 1401
    //   19434: aastore
    //   19435: dup
    //   19436: iconst_1
    //   19437: aload 33
    //   19439: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   19442: aastore
    //   19443: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19446: aload 33
    //   19448: invokevirtual 988	java/io/File:exists	()Z
    //   19451: ifeq +9 -> 19460
    //   19454: aload 33
    //   19456: invokevirtual 1132	java/io/File:delete	()Z
    //   19459: pop
    //   19460: new 980	java/io/File
    //   19463: dup
    //   19464: ldc_w 1411
    //   19467: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19470: invokevirtual 1132	java/io/File:delete	()Z
    //   19473: pop
    //   19474: new 980	java/io/File
    //   19477: dup
    //   19478: ldc_w 1413
    //   19481: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19484: invokevirtual 1132	java/io/File:delete	()Z
    //   19487: pop
    //   19488: new 980	java/io/File
    //   19491: dup
    //   19492: ldc_w 1415
    //   19495: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19498: invokevirtual 1132	java/io/File:delete	()Z
    //   19501: pop
    //   19502: new 980	java/io/File
    //   19505: dup
    //   19506: ldc_w 1417
    //   19509: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19512: invokevirtual 1132	java/io/File:delete	()Z
    //   19515: pop
    //   19516: new 980	java/io/File
    //   19519: dup
    //   19520: ldc_w 1419
    //   19523: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19526: invokevirtual 1132	java/io/File:delete	()Z
    //   19529: pop
    //   19530: new 980	java/io/File
    //   19533: dup
    //   19534: ldc_w 1421
    //   19537: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19540: invokevirtual 1132	java/io/File:delete	()Z
    //   19543: pop
    //   19544: new 980	java/io/File
    //   19547: dup
    //   19548: ldc_w 1423
    //   19551: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19554: invokevirtual 1132	java/io/File:delete	()Z
    //   19557: pop
    //   19558: new 980	java/io/File
    //   19561: dup
    //   19562: ldc_w 1425
    //   19565: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19568: invokevirtual 1132	java/io/File:delete	()Z
    //   19571: pop
    //   19572: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19575: ldc_w 1427
    //   19578: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19581: goto -12839 -> 6742
    //   19584: aload 33
    //   19586: ldc_w 1429
    //   19589: invokestatic 1363	com/chelpus/Utils:fixadlerOdex	(Ljava/io/File;Ljava/lang/String;)V
    //   19592: goto -578 -> 19014
    //   19595: astore 33
    //   19597: aload 33
    //   19599: invokevirtual 1110	java/lang/Exception:printStackTrace	()V
    //   19602: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19605: ldc_w 1431
    //   19608: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19611: new 980	java/io/File
    //   19614: dup
    //   19615: ldc_w 1405
    //   19618: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19621: invokevirtual 1132	java/io/File:delete	()Z
    //   19624: pop
    //   19625: goto -53 -> 19572
    //   19628: new 980	java/io/File
    //   19631: dup
    //   19632: ldc_w 1378
    //   19635: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19638: invokevirtual 1132	java/io/File:delete	()Z
    //   19641: pop
    //   19642: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19645: ldc_w 1431
    //   19648: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19651: goto -12909 -> 6742
    //   19654: getstatic 303	com/chelpus/root/utils/corepatch:onlyDalvik	Z
    //   19657: ifne -12915 -> 6742
    //   19660: aload 33
    //   19662: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   19665: ldc_w 1320
    //   19668: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   19671: ifeq +120 -> 19791
    //   19674: iload 4
    //   19676: ifeq +115 -> 19791
    //   19679: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19682: ldc_w 1433
    //   19685: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19688: new 980	java/io/File
    //   19691: dup
    //   19692: ldc_w 1435
    //   19695: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19698: astore 34
    //   19700: aload 33
    //   19702: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   19705: ldc_w 1435
    //   19708: iconst_1
    //   19709: iconst_0
    //   19710: invokestatic 1382	com/chelpus/Utils:copyFile	(Ljava/lang/String;Ljava/lang/String;ZZ)Z
    //   19713: ifeq +131 -> 19844
    //   19716: iconst_3
    //   19717: anewarray 904	java/lang/String
    //   19720: dup
    //   19721: iconst_0
    //   19722: ldc_w 1388
    //   19725: aastore
    //   19726: dup
    //   19727: iconst_1
    //   19728: ldc_w 1390
    //   19731: aastore
    //   19732: dup
    //   19733: iconst_2
    //   19734: ldc_w 1435
    //   19737: aastore
    //   19738: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19741: iconst_3
    //   19742: anewarray 904	java/lang/String
    //   19745: dup
    //   19746: iconst_0
    //   19747: ldc_w 1395
    //   19750: aastore
    //   19751: dup
    //   19752: iconst_1
    //   19753: ldc_w 1399
    //   19756: aastore
    //   19757: dup
    //   19758: iconst_2
    //   19759: ldc_w 1435
    //   19762: aastore
    //   19763: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19766: iconst_3
    //   19767: anewarray 904	java/lang/String
    //   19770: dup
    //   19771: iconst_0
    //   19772: ldc_w 1395
    //   19775: aastore
    //   19776: dup
    //   19777: iconst_1
    //   19778: ldc_w 1397
    //   19781: aastore
    //   19782: dup
    //   19783: iconst_2
    //   19784: ldc_w 1435
    //   19787: aastore
    //   19788: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   19791: new 980	java/io/File
    //   19794: dup
    //   19795: ldc_w 1435
    //   19798: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19801: invokevirtual 988	java/io/File:exists	()Z
    //   19804: ifeq +12 -> 19816
    //   19807: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19810: ldc_w 1437
    //   19813: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19816: new 980	java/io/File
    //   19819: dup
    //   19820: ldc_w 1322
    //   19823: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19826: invokevirtual 988	java/io/File:exists	()Z
    //   19829: ifeq -13087 -> 6742
    //   19832: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19835: ldc_w 1439
    //   19838: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19841: goto -13099 -> 6742
    //   19844: aload 34
    //   19846: invokevirtual 1132	java/io/File:delete	()Z
    //   19849: pop
    //   19850: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19853: ldc_w 1441
    //   19856: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19859: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   19862: ldc_w 1431
    //   19865: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   19868: goto -77 -> 19791
    //   19871: aload 32
    //   19873: astore 33
    //   19875: aload 35
    //   19877: astore 32
    //   19879: new 980	java/io/File
    //   19882: dup
    //   19883: ldc_w 1280
    //   19886: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19889: invokevirtual 988	java/io/File:exists	()Z
    //   19892: ifeq +18 -> 19910
    //   19895: ldc_w 1443
    //   19898: astore 32
    //   19900: ldc_w 1208
    //   19903: astore 33
    //   19905: ldc_w 1445
    //   19908: astore 34
    //   19910: new 980	java/io/File
    //   19913: dup
    //   19914: ldc_w 1284
    //   19917: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19920: invokevirtual 988	java/io/File:exists	()Z
    //   19923: ifeq +18 -> 19941
    //   19926: ldc_w 1443
    //   19929: astore 32
    //   19931: ldc_w 1212
    //   19934: astore 33
    //   19936: ldc_w 1445
    //   19939: astore 34
    //   19941: new 980	java/io/File
    //   19944: dup
    //   19945: ldc_w 1288
    //   19948: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19951: invokevirtual 988	java/io/File:exists	()Z
    //   19954: ifeq +18 -> 19972
    //   19957: ldc_w 1443
    //   19960: astore 32
    //   19962: ldc_w 1216
    //   19965: astore 33
    //   19967: ldc_w 1445
    //   19970: astore 34
    //   19972: new 980	java/io/File
    //   19975: dup
    //   19976: ldc_w 1292
    //   19979: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   19982: invokevirtual 988	java/io/File:exists	()Z
    //   19985: ifeq +18 -> 20003
    //   19988: ldc_w 1443
    //   19991: astore 32
    //   19993: ldc_w 1220
    //   19996: astore 33
    //   19998: ldc_w 1445
    //   20001: astore 34
    //   20003: new 980	java/io/File
    //   20006: dup
    //   20007: ldc_w 1447
    //   20010: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20013: invokevirtual 988	java/io/File:exists	()Z
    //   20016: ifeq +18 -> 20034
    //   20019: ldc_w 1449
    //   20022: astore 32
    //   20024: ldc_w 1208
    //   20027: astore 33
    //   20029: ldc_w 1445
    //   20032: astore 34
    //   20034: new 980	java/io/File
    //   20037: dup
    //   20038: ldc_w 1451
    //   20041: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20044: invokevirtual 988	java/io/File:exists	()Z
    //   20047: ifeq +18 -> 20065
    //   20050: ldc_w 1449
    //   20053: astore 32
    //   20055: ldc_w 1212
    //   20058: astore 33
    //   20060: ldc_w 1445
    //   20063: astore 34
    //   20065: aload 34
    //   20067: astore 36
    //   20069: aload 33
    //   20071: astore 35
    //   20073: aload 32
    //   20075: astore 34
    //   20077: new 980	java/io/File
    //   20080: dup
    //   20081: ldc_w 1453
    //   20084: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20087: invokevirtual 988	java/io/File:exists	()Z
    //   20090: ifeq +18 -> 20108
    //   20093: ldc_w 1449
    //   20096: astore 34
    //   20098: ldc_w 1216
    //   20101: astore 35
    //   20103: ldc_w 1445
    //   20106: astore 36
    //   20108: aload 36
    //   20110: astore 33
    //   20112: aload 35
    //   20114: astore 32
    //   20116: new 980	java/io/File
    //   20119: dup
    //   20120: ldc_w 1455
    //   20123: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20126: invokevirtual 988	java/io/File:exists	()Z
    //   20129: ifeq -10828 -> 9301
    //   20132: ldc_w 1449
    //   20135: astore 34
    //   20137: ldc_w 1220
    //   20140: astore 32
    //   20142: ldc_w 1445
    //   20145: astore 33
    //   20147: goto -10846 -> 9301
    //   20150: iconst_3
    //   20151: anewarray 904	java/lang/String
    //   20154: dup
    //   20155: iconst_0
    //   20156: ldc_w 1388
    //   20159: aastore
    //   20160: dup
    //   20161: iconst_1
    //   20162: ldc_w 1457
    //   20165: aastore
    //   20166: dup
    //   20167: iconst_2
    //   20168: new 1031	java/lang/StringBuilder
    //   20171: dup
    //   20172: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   20175: aload 34
    //   20177: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20180: aload 32
    //   20182: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20185: aload 33
    //   20187: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20190: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20193: aastore
    //   20194: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   20197: iconst_3
    //   20198: anewarray 904	java/lang/String
    //   20201: dup
    //   20202: iconst_0
    //   20203: ldc_w 1395
    //   20206: aastore
    //   20207: dup
    //   20208: iconst_1
    //   20209: ldc_w 1397
    //   20212: aastore
    //   20213: dup
    //   20214: iconst_2
    //   20215: new 1031	java/lang/StringBuilder
    //   20218: dup
    //   20219: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   20222: aload 34
    //   20224: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20227: aload 32
    //   20229: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20232: aload 33
    //   20234: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20237: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20240: aastore
    //   20241: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   20244: iconst_3
    //   20245: anewarray 904	java/lang/String
    //   20248: dup
    //   20249: iconst_0
    //   20250: ldc_w 1395
    //   20253: aastore
    //   20254: dup
    //   20255: iconst_1
    //   20256: ldc_w 1399
    //   20259: aastore
    //   20260: dup
    //   20261: iconst_2
    //   20262: new 1031	java/lang/StringBuilder
    //   20265: dup
    //   20266: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   20269: aload 34
    //   20271: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20274: aload 32
    //   20276: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20279: aload 33
    //   20281: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20284: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20287: aastore
    //   20288: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   20291: iload 15
    //   20293: istore_2
    //   20294: goto -10744 -> 9550
    //   20297: iload 11
    //   20299: istore 4
    //   20301: iload 10
    //   20303: istore 5
    //   20305: iload 12
    //   20307: istore 17
    //   20309: iload 8
    //   20311: istore 9
    //   20313: iload 11
    //   20315: istore_2
    //   20316: iload 10
    //   20318: istore_3
    //   20319: iload 12
    //   20321: istore 7
    //   20323: iload 8
    //   20325: istore 6
    //   20327: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   20330: iload 15
    //   20332: iconst_1
    //   20333: iadd
    //   20334: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   20337: pop
    //   20338: iload 12
    //   20340: istore 13
    //   20342: goto -10593 -> 9749
    //   20345: astore 33
    //   20347: iload 4
    //   20349: istore_2
    //   20350: iload 5
    //   20352: istore_3
    //   20353: iload 17
    //   20355: istore 7
    //   20357: iload 9
    //   20359: istore 6
    //   20361: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20364: new 1031	java/lang/StringBuilder
    //   20367: dup
    //   20368: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   20371: ldc_w 299
    //   20374: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20377: aload 33
    //   20379: invokevirtual 1129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20382: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20385: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   20388: iload 4
    //   20390: istore 12
    //   20392: iload 5
    //   20394: istore 14
    //   20396: iload 17
    //   20398: istore 15
    //   20400: iload 9
    //   20402: istore 16
    //   20404: goto -5393 -> 15011
    //   20407: astore 32
    //   20409: aload 32
    //   20411: invokevirtual 1109	java/io/IOException:printStackTrace	()V
    //   20414: goto -5370 -> 15044
    //   20417: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20420: ldc_w 1431
    //   20423: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   20426: iload 14
    //   20428: istore_2
    //   20429: goto -5385 -> 15044
    //   20432: aload_0
    //   20433: iconst_4
    //   20434: aaload
    //   20435: ldc_w 1188
    //   20438: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   20441: ifeq +157 -> 20598
    //   20444: new 980	java/io/File
    //   20447: dup
    //   20448: ldc_w 1459
    //   20451: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20454: invokevirtual 988	java/io/File:exists	()Z
    //   20457: ifeq +46 -> 20503
    //   20460: new 980	java/io/File
    //   20463: dup
    //   20464: ldc_w 1459
    //   20467: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20470: invokevirtual 1168	java/io/File:length	()J
    //   20473: lconst_0
    //   20474: lcmp
    //   20475: ifeq +28 -> 20503
    //   20478: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20481: ldc_w 1461
    //   20484: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   20487: aload 37
    //   20489: new 980	java/io/File
    //   20492: dup
    //   20493: ldc_w 1459
    //   20496: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20499: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   20502: pop
    //   20503: new 980	java/io/File
    //   20506: dup
    //   20507: ldc_w 1463
    //   20510: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20513: invokestatic 1152	com/chelpus/Utils:classes_test	(Ljava/io/File;)Z
    //   20516: ifeq -5180 -> 15336
    //   20519: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20522: ldc_w 1465
    //   20525: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   20528: new 980	java/io/File
    //   20531: dup
    //   20532: ldc_w 1463
    //   20535: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20538: ldc_w 1194
    //   20541: invokestatic 1159	com/chelpus/root/utils/corepatch:unzip	(Ljava/io/File;Ljava/lang/String;)V
    //   20544: new 980	java/io/File
    //   20547: dup
    //   20548: ldc_w 1196
    //   20551: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20554: astore 32
    //   20556: aload 32
    //   20558: invokevirtual 988	java/io/File:exists	()Z
    //   20561: ifeq -5225 -> 15336
    //   20564: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20567: ldc_w 1467
    //   20570: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   20573: aload 37
    //   20575: aload 32
    //   20577: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   20580: pop
    //   20581: goto -5245 -> 15336
    //   20584: astore_0
    //   20585: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20588: ldc_w 1469
    //   20591: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   20594: invokestatic 1472	com/chelpus/Utils:exitFromRootJava	()V
    //   20597: return
    //   20598: getstatic 303	com/chelpus/root/utils/corepatch:onlyDalvik	Z
    //   20601: ifeq +66 -> 20667
    //   20604: new 980	java/io/File
    //   20607: dup
    //   20608: aload_0
    //   20609: iconst_2
    //   20610: aaload
    //   20611: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20614: astore 32
    //   20616: aload 32
    //   20618: astore 33
    //   20620: aload 32
    //   20622: astore 33
    //   20624: aload 32
    //   20626: invokevirtual 988	java/io/File:exists	()Z
    //   20629: ifne +19 -> 20648
    //   20632: aload 32
    //   20634: astore 33
    //   20636: aload 32
    //   20638: astore 33
    //   20640: new 883	java/io/FileNotFoundException
    //   20643: dup
    //   20644: invokespecial 1315	java/io/FileNotFoundException:<init>	()V
    //   20647: athrow
    //   20648: aload 32
    //   20650: astore 33
    //   20652: aload 32
    //   20654: astore 33
    //   20656: aload 37
    //   20658: aload 32
    //   20660: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   20663: pop
    //   20664: goto -5328 -> 15336
    //   20667: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20670: new 1031	java/lang/StringBuilder
    //   20673: dup
    //   20674: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   20677: ldc_w 1474
    //   20680: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20683: aload_0
    //   20684: iconst_2
    //   20685: aaload
    //   20686: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20689: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20692: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   20695: new 980	java/io/File
    //   20698: dup
    //   20699: aload_0
    //   20700: iconst_2
    //   20701: aaload
    //   20702: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20705: astore 32
    //   20707: aload 32
    //   20709: astore 33
    //   20711: aload 32
    //   20713: astore 33
    //   20715: aload 32
    //   20717: invokevirtual 988	java/io/File:exists	()Z
    //   20720: ifne +52 -> 20772
    //   20723: aload 32
    //   20725: astore 33
    //   20727: aload 32
    //   20729: astore 33
    //   20731: new 883	java/io/FileNotFoundException
    //   20734: dup
    //   20735: invokespecial 1315	java/io/FileNotFoundException:<init>	()V
    //   20738: athrow
    //   20739: astore_0
    //   20740: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20743: new 1031	java/lang/StringBuilder
    //   20746: dup
    //   20747: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   20750: ldc_w 1317
    //   20753: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20756: aload_0
    //   20757: invokevirtual 1318	java/lang/Exception:toString	()Ljava/lang/String;
    //   20760: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20763: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20766: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   20769: goto -175 -> 20594
    //   20772: aload 32
    //   20774: astore 33
    //   20776: aload 32
    //   20778: astore 33
    //   20780: aload 32
    //   20782: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   20785: ldc_w 1476
    //   20788: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   20791: ifeq +4278 -> 25069
    //   20794: aload 32
    //   20796: astore 33
    //   20798: aload 32
    //   20800: astore 33
    //   20802: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20805: new 1031	java/lang/StringBuilder
    //   20808: dup
    //   20809: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   20812: ldc_w 1478
    //   20815: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20818: aload_0
    //   20819: iconst_2
    //   20820: aaload
    //   20821: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20824: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20827: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   20830: aload 32
    //   20832: astore 33
    //   20834: aload 32
    //   20836: astore 33
    //   20838: new 980	java/io/File
    //   20841: dup
    //   20842: ldc_w 1463
    //   20845: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20848: ldc_w 1194
    //   20851: invokestatic 1159	com/chelpus/root/utils/corepatch:unzip	(Ljava/io/File;Ljava/lang/String;)V
    //   20854: aload 32
    //   20856: astore 33
    //   20858: aload 32
    //   20860: astore 33
    //   20862: new 980	java/io/File
    //   20865: dup
    //   20866: ldc_w 1196
    //   20869: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20872: astore 34
    //   20874: aload 32
    //   20876: astore 33
    //   20878: aload 32
    //   20880: astore 33
    //   20882: aload 34
    //   20884: invokevirtual 988	java/io/File:exists	()Z
    //   20887: istore 24
    //   20889: iload 24
    //   20891: ifeq +4175 -> 25066
    //   20894: aload 34
    //   20896: astore 32
    //   20898: new 980	java/io/File
    //   20901: dup
    //   20902: ldc_w 1459
    //   20905: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   20908: astore 34
    //   20910: aload 32
    //   20912: astore 33
    //   20914: aload 34
    //   20916: invokevirtual 988	java/io/File:exists	()Z
    //   20919: ifeq +27 -> 20946
    //   20922: aload 32
    //   20924: astore 33
    //   20926: aload 34
    //   20928: invokevirtual 1168	java/io/File:length	()J
    //   20931: lconst_0
    //   20932: lcmp
    //   20933: ifne +13 -> 20946
    //   20936: aload 34
    //   20938: invokevirtual 1132	java/io/File:delete	()Z
    //   20941: pop
    //   20942: aload 32
    //   20944: astore 33
    //   20946: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20949: new 1031	java/lang/StringBuilder
    //   20952: dup
    //   20953: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   20956: ldc_w 1480
    //   20959: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20962: aload 33
    //   20964: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   20967: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20970: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20973: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   20976: aload 37
    //   20978: aload 33
    //   20980: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   20983: pop
    //   20984: goto -5648 -> 15336
    //   20987: astore 35
    //   20989: aload 35
    //   20991: invokevirtual 1110	java/lang/Exception:printStackTrace	()V
    //   20994: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   20997: new 1031	java/lang/StringBuilder
    //   21000: dup
    //   21001: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   21004: ldc_w 299
    //   21007: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21010: aload 35
    //   21012: invokevirtual 1129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21015: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21018: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21021: iload_2
    //   21022: istore 5
    //   21024: iload 5
    //   21026: istore 4
    //   21028: getstatic 309	com/chelpus/root/utils/corepatch:lastPatchPosition	I
    //   21031: ifle +44 -> 21075
    //   21034: iload 5
    //   21036: istore 4
    //   21038: getstatic 311	com/chelpus/root/utils/corepatch:lastByteReplace	[B
    //   21041: ifnull +34 -> 21075
    //   21044: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21047: getstatic 309	com/chelpus/root/utils/corepatch:lastPatchPosition	I
    //   21050: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   21053: pop
    //   21054: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21057: getstatic 311	com/chelpus/root/utils/corepatch:lastByteReplace	[B
    //   21060: invokevirtual 863	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   21063: pop
    //   21064: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21067: invokevirtual 867	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   21070: pop
    //   21071: iload 5
    //   21073: istore 4
    //   21075: aload 33
    //   21077: invokevirtual 1106	java/nio/channels/FileChannel:close	()V
    //   21080: aload_0
    //   21081: iconst_4
    //   21082: aaload
    //   21083: ldc_w 910
    //   21086: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21089: ifeq +2192 -> 23281
    //   21092: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21095: ldc_w 1482
    //   21098: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21101: aload 32
    //   21103: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   21106: ldc_w 1161
    //   21109: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   21112: ifeq +143 -> 21255
    //   21115: aload 32
    //   21117: invokestatic 1333	com/chelpus/Utils:fixadler	(Ljava/io/File;)V
    //   21120: iload 4
    //   21122: ifeq +2152 -> 23274
    //   21125: iconst_0
    //   21126: putstatic 305	com/chelpus/root/utils/corepatch:not_found_bytes_for_patch	Z
    //   21129: aload_0
    //   21130: iconst_1
    //   21131: aaload
    //   21132: ldc_w 1484
    //   21135: ldc_w 1486
    //   21138: invokevirtual 1341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   21141: astore 33
    //   21143: aload_0
    //   21144: iconst_1
    //   21145: aaload
    //   21146: astore 35
    //   21148: new 980	java/io/File
    //   21151: dup
    //   21152: aload 33
    //   21154: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   21157: invokevirtual 1132	java/io/File:delete	()Z
    //   21160: pop
    //   21161: new 974	java/util/ArrayList
    //   21164: dup
    //   21165: invokespecial 975	java/util/ArrayList:<init>	()V
    //   21168: astore 36
    //   21170: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21173: ldc_w 1343
    //   21176: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21179: aload 36
    //   21181: new 1345	com/android/vending/billing/InAppBillingService/LACK/AddFilesItem
    //   21184: dup
    //   21185: aload 32
    //   21187: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21190: new 1031	java/lang/StringBuilder
    //   21193: dup
    //   21194: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   21197: aload 32
    //   21199: invokestatic 1156	com/chelpus/Utils:getDirs	(Ljava/io/File;)Ljava/io/File;
    //   21202: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21205: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21208: ldc_w 1347
    //   21211: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21214: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21217: invokespecial 1350	com/android/vending/billing/InAppBillingService/LACK/AddFilesItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21220: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   21223: pop
    //   21224: aload 35
    //   21226: aload 33
    //   21228: aload 36
    //   21230: invokestatic 1354	com/chelpus/Utils:addFilesToZip	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   21233: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21236: ldc_w 1356
    //   21239: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21242: new 980	java/io/File
    //   21245: dup
    //   21246: aload 35
    //   21248: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   21251: invokevirtual 1132	java/io/File:delete	()Z
    //   21254: pop
    //   21255: aload 32
    //   21257: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   21260: ldc_w 1204
    //   21263: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   21266: ifeq -5923 -> 15343
    //   21269: aload 32
    //   21271: invokestatic 1300	com/chelpus/Utils:isELFfiles	(Ljava/io/File;)Z
    //   21274: ifne +9 -> 21283
    //   21277: aload 32
    //   21279: aconst_null
    //   21280: invokestatic 1363	com/chelpus/Utils:fixadlerOdex	(Ljava/io/File;Ljava/lang/String;)V
    //   21283: iload 4
    //   21285: ifeq -5942 -> 15343
    //   21288: aload 32
    //   21290: new 980	java/io/File
    //   21293: dup
    //   21294: aload 32
    //   21296: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21299: ldc_w 1204
    //   21302: ldc_w 1488
    //   21305: invokevirtual 1341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   21308: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   21311: invokevirtual 1368	java/io/File:renameTo	(Ljava/io/File;)Z
    //   21314: pop
    //   21315: goto -5972 -> 15343
    //   21318: iconst_0
    //   21319: istore 7
    //   21321: iconst_0
    //   21322: istore 5
    //   21324: iconst_0
    //   21325: istore 9
    //   21327: iconst_0
    //   21328: istore 6
    //   21330: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21333: sipush 4120
    //   21336: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   21339: pop
    //   21340: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21343: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   21346: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21349: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   21352: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21355: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   21358: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21361: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   21364: invokestatic 1073	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   21367: istore_2
    //   21368: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21371: new 1031	java/lang/StringBuilder
    //   21374: dup
    //   21375: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   21378: ldc_w 1075
    //   21381: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21384: iload_2
    //   21385: invokevirtual 1078	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21388: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21391: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21394: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21397: iload_2
    //   21398: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   21401: pop
    //   21402: iload_3
    //   21403: istore 4
    //   21405: iload_3
    //   21406: istore_2
    //   21407: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21410: invokevirtual 1081	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   21413: ifeq -338 -> 21075
    //   21416: iload_3
    //   21417: istore_2
    //   21418: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21421: invokevirtual 1083	java/nio/MappedByteBuffer:position	()I
    //   21424: istore 10
    //   21426: iload_3
    //   21427: istore_2
    //   21428: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   21431: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   21434: istore_1
    //   21435: iload_3
    //   21436: istore 4
    //   21438: iload_3
    //   21439: istore_2
    //   21440: iload 10
    //   21442: iload_1
    //   21443: getstatic 449	com/chelpus/root/utils/corepatch:byteOrigSOat1	[B
    //   21446: getstatic 451	com/chelpus/root/utils/corepatch:maskSOat1	[B
    //   21449: getstatic 453	com/chelpus/root/utils/corepatch:byteReplaceSOat1	[B
    //   21452: getstatic 455	com/chelpus/root/utils/corepatch:rep_maskSOat1	[B
    //   21455: iload 25
    //   21457: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   21460: ifeq +56 -> 21516
    //   21463: iload_3
    //   21464: istore_2
    //   21465: aload_0
    //   21466: iconst_0
    //   21467: aaload
    //   21468: ldc_w 946
    //   21471: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21474: ifeq +14 -> 21488
    //   21477: iload_3
    //   21478: istore_2
    //   21479: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21482: ldc_w 1264
    //   21485: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21488: iload_3
    //   21489: istore_2
    //   21490: aload_0
    //   21491: iconst_0
    //   21492: aaload
    //   21493: ldc_w 963
    //   21496: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21499: ifeq +4262 -> 25761
    //   21502: iload_3
    //   21503: istore_2
    //   21504: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21507: ldc_w 1266
    //   21510: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21513: goto +4248 -> 25761
    //   21516: iload 4
    //   21518: istore_3
    //   21519: iload 4
    //   21521: istore_2
    //   21522: iload 10
    //   21524: iload_1
    //   21525: getstatic 457	com/chelpus/root/utils/corepatch:byteOrigSOat6_1	[B
    //   21528: getstatic 459	com/chelpus/root/utils/corepatch:maskSOat6_1	[B
    //   21531: getstatic 461	com/chelpus/root/utils/corepatch:byteReplaceSOat6_1	[B
    //   21534: getstatic 463	com/chelpus/root/utils/corepatch:rep_maskSOat6_1	[B
    //   21537: iload 25
    //   21539: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   21542: ifeq +60 -> 21602
    //   21545: iload 4
    //   21547: istore_2
    //   21548: aload_0
    //   21549: iconst_0
    //   21550: aaload
    //   21551: ldc_w 946
    //   21554: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21557: ifeq +15 -> 21572
    //   21560: iload 4
    //   21562: istore_2
    //   21563: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21566: ldc_w 1264
    //   21569: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21572: iload 4
    //   21574: istore_2
    //   21575: aload_0
    //   21576: iconst_0
    //   21577: aaload
    //   21578: ldc_w 963
    //   21581: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21584: ifeq +4186 -> 25770
    //   21587: iload 4
    //   21589: istore_2
    //   21590: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21593: ldc_w 1266
    //   21596: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21599: goto +4171 -> 25770
    //   21602: iload_3
    //   21603: istore 4
    //   21605: iload_3
    //   21606: istore_2
    //   21607: iload 10
    //   21609: iload_1
    //   21610: getstatic 465	com/chelpus/root/utils/corepatch:byteOrigSOat2	[B
    //   21613: getstatic 467	com/chelpus/root/utils/corepatch:maskSOat2	[B
    //   21616: getstatic 469	com/chelpus/root/utils/corepatch:byteReplaceSOat2	[B
    //   21619: getstatic 471	com/chelpus/root/utils/corepatch:rep_maskSOat2	[B
    //   21622: iload 25
    //   21624: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   21627: ifeq +56 -> 21683
    //   21630: iload_3
    //   21631: istore_2
    //   21632: aload_0
    //   21633: iconst_0
    //   21634: aaload
    //   21635: ldc_w 946
    //   21638: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21641: ifeq +14 -> 21655
    //   21644: iload_3
    //   21645: istore_2
    //   21646: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21649: ldc_w 1268
    //   21652: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21655: iload_3
    //   21656: istore_2
    //   21657: aload_0
    //   21658: iconst_0
    //   21659: aaload
    //   21660: ldc_w 963
    //   21663: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21666: ifeq +4112 -> 25778
    //   21669: iload_3
    //   21670: istore_2
    //   21671: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21674: ldc_w 1270
    //   21677: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21680: goto +4098 -> 25778
    //   21683: iload 4
    //   21685: istore_3
    //   21686: iload 4
    //   21688: istore_2
    //   21689: iload 10
    //   21691: iload_1
    //   21692: getstatic 473	com/chelpus/root/utils/corepatch:byteOrigSOat6_2	[B
    //   21695: getstatic 475	com/chelpus/root/utils/corepatch:maskSOat6_2	[B
    //   21698: getstatic 477	com/chelpus/root/utils/corepatch:byteReplaceSOat6_2	[B
    //   21701: getstatic 479	com/chelpus/root/utils/corepatch:rep_maskSOat6_2	[B
    //   21704: iload 25
    //   21706: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   21709: ifeq +60 -> 21769
    //   21712: iload 4
    //   21714: istore_2
    //   21715: aload_0
    //   21716: iconst_0
    //   21717: aaload
    //   21718: ldc_w 946
    //   21721: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21724: ifeq +15 -> 21739
    //   21727: iload 4
    //   21729: istore_2
    //   21730: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21733: ldc_w 1268
    //   21736: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21739: iload 4
    //   21741: istore_2
    //   21742: aload_0
    //   21743: iconst_0
    //   21744: aaload
    //   21745: ldc_w 963
    //   21748: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21751: ifeq +4036 -> 25787
    //   21754: iload 4
    //   21756: istore_2
    //   21757: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21760: ldc_w 1270
    //   21763: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21766: goto +4021 -> 25787
    //   21769: iload_3
    //   21770: istore 4
    //   21772: iload_3
    //   21773: istore_2
    //   21774: iload 10
    //   21776: iload_1
    //   21777: getstatic 481	com/chelpus/root/utils/corepatch:byteOrigSOat6_3	[B
    //   21780: getstatic 483	com/chelpus/root/utils/corepatch:maskSOat6_3	[B
    //   21783: getstatic 485	com/chelpus/root/utils/corepatch:byteReplaceSOat6_3	[B
    //   21786: getstatic 487	com/chelpus/root/utils/corepatch:rep_maskSOat6_3	[B
    //   21789: iload 25
    //   21791: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   21794: ifeq +56 -> 21850
    //   21797: iload_3
    //   21798: istore_2
    //   21799: aload_0
    //   21800: iconst_0
    //   21801: aaload
    //   21802: ldc_w 946
    //   21805: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21808: ifeq +14 -> 21822
    //   21811: iload_3
    //   21812: istore_2
    //   21813: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21816: ldc_w 1268
    //   21819: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21822: iload_3
    //   21823: istore_2
    //   21824: aload_0
    //   21825: iconst_0
    //   21826: aaload
    //   21827: ldc_w 963
    //   21830: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21833: ifeq +3962 -> 25795
    //   21836: iload_3
    //   21837: istore_2
    //   21838: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21841: ldc_w 1270
    //   21844: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21847: goto +3948 -> 25795
    //   21850: iload 4
    //   21852: istore_3
    //   21853: iload 4
    //   21855: istore_2
    //   21856: iload 10
    //   21858: iload_1
    //   21859: getstatic 489	com/chelpus/root/utils/corepatch:byteOrigSOat3	[B
    //   21862: getstatic 491	com/chelpus/root/utils/corepatch:maskSOat3	[B
    //   21865: getstatic 493	com/chelpus/root/utils/corepatch:byteReplaceSOat3	[B
    //   21868: getstatic 495	com/chelpus/root/utils/corepatch:rep_maskSOat3	[B
    //   21871: iload 25
    //   21873: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   21876: ifeq +60 -> 21936
    //   21879: iload 4
    //   21881: istore_2
    //   21882: aload_0
    //   21883: iconst_0
    //   21884: aaload
    //   21885: ldc_w 946
    //   21888: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21891: ifeq +15 -> 21906
    //   21894: iload 4
    //   21896: istore_2
    //   21897: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21900: ldc_w 1272
    //   21903: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21906: iload 4
    //   21908: istore_2
    //   21909: aload_0
    //   21910: iconst_0
    //   21911: aaload
    //   21912: ldc_w 963
    //   21915: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21918: ifeq +3886 -> 25804
    //   21921: iload 4
    //   21923: istore_2
    //   21924: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21927: ldc_w 1274
    //   21930: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21933: goto +3871 -> 25804
    //   21936: iload_3
    //   21937: istore 4
    //   21939: iload_3
    //   21940: istore_2
    //   21941: iload 10
    //   21943: iload_1
    //   21944: getstatic 497	com/chelpus/root/utils/corepatch:byteOrigSOat6	[B
    //   21947: getstatic 499	com/chelpus/root/utils/corepatch:maskSOat6	[B
    //   21950: getstatic 501	com/chelpus/root/utils/corepatch:byteReplaceSOat6	[B
    //   21953: getstatic 503	com/chelpus/root/utils/corepatch:rep_maskSOat6	[B
    //   21956: iload 25
    //   21958: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   21961: ifeq +56 -> 22017
    //   21964: iload_3
    //   21965: istore_2
    //   21966: aload_0
    //   21967: iconst_0
    //   21968: aaload
    //   21969: ldc_w 946
    //   21972: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21975: ifeq +14 -> 21989
    //   21978: iload_3
    //   21979: istore_2
    //   21980: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   21983: ldc_w 1276
    //   21986: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   21989: iload_3
    //   21990: istore_2
    //   21991: aload_0
    //   21992: iconst_0
    //   21993: aaload
    //   21994: ldc_w 963
    //   21997: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22000: ifeq +3812 -> 25812
    //   22003: iload_3
    //   22004: istore_2
    //   22005: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22008: ldc_w 1278
    //   22011: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22014: goto +3798 -> 25812
    //   22017: iload 4
    //   22019: istore_3
    //   22020: iload 4
    //   22022: istore_2
    //   22023: iload 10
    //   22025: iload_1
    //   22026: getstatic 505	com/chelpus/root/utils/corepatch:byteOrigSOat7	[B
    //   22029: getstatic 507	com/chelpus/root/utils/corepatch:maskSOat7	[B
    //   22032: getstatic 509	com/chelpus/root/utils/corepatch:byteReplaceSOat7	[B
    //   22035: getstatic 511	com/chelpus/root/utils/corepatch:rep_maskSOat7	[B
    //   22038: iload 25
    //   22040: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22043: ifeq +60 -> 22103
    //   22046: iload 4
    //   22048: istore_2
    //   22049: aload_0
    //   22050: iconst_0
    //   22051: aaload
    //   22052: ldc_w 946
    //   22055: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22058: ifeq +15 -> 22073
    //   22061: iload 4
    //   22063: istore_2
    //   22064: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22067: ldc_w 1276
    //   22070: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22073: iload 4
    //   22075: istore_2
    //   22076: aload_0
    //   22077: iconst_0
    //   22078: aaload
    //   22079: ldc_w 963
    //   22082: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22085: ifeq +3736 -> 25821
    //   22088: iload 4
    //   22090: istore_2
    //   22091: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22094: ldc_w 1278
    //   22097: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22100: goto +3721 -> 25821
    //   22103: iload_3
    //   22104: istore 4
    //   22106: iload_3
    //   22107: istore_2
    //   22108: iload 10
    //   22110: iload_1
    //   22111: getstatic 513	com/chelpus/root/utils/corepatch:byteOrigSOat7_2	[B
    //   22114: getstatic 515	com/chelpus/root/utils/corepatch:maskSOat7_2	[B
    //   22117: getstatic 517	com/chelpus/root/utils/corepatch:byteReplaceSOat7_2	[B
    //   22120: getstatic 519	com/chelpus/root/utils/corepatch:rep_maskSOat7_2	[B
    //   22123: iload 25
    //   22125: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22128: ifeq +56 -> 22184
    //   22131: iload_3
    //   22132: istore_2
    //   22133: aload_0
    //   22134: iconst_0
    //   22135: aaload
    //   22136: ldc_w 946
    //   22139: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22142: ifeq +14 -> 22156
    //   22145: iload_3
    //   22146: istore_2
    //   22147: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22150: ldc_w 1276
    //   22153: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22156: iload_3
    //   22157: istore_2
    //   22158: aload_0
    //   22159: iconst_0
    //   22160: aaload
    //   22161: ldc_w 963
    //   22164: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22167: ifeq +3662 -> 25829
    //   22170: iload_3
    //   22171: istore_2
    //   22172: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22175: ldc_w 1278
    //   22178: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22181: goto +3648 -> 25829
    //   22184: iload 4
    //   22186: istore_3
    //   22187: iload 4
    //   22189: istore_2
    //   22190: iload 10
    //   22192: iload_1
    //   22193: getstatic 521	com/chelpus/root/utils/corepatch:byteOrigSOat8	[B
    //   22196: getstatic 523	com/chelpus/root/utils/corepatch:maskSOat8	[B
    //   22199: getstatic 525	com/chelpus/root/utils/corepatch:byteReplaceSOat8	[B
    //   22202: getstatic 527	com/chelpus/root/utils/corepatch:rep_maskSOat8	[B
    //   22205: iload 25
    //   22207: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22210: ifeq +60 -> 22270
    //   22213: iload 4
    //   22215: istore_2
    //   22216: aload_0
    //   22217: iconst_0
    //   22218: aaload
    //   22219: ldc_w 946
    //   22222: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22225: ifeq +15 -> 22240
    //   22228: iload 4
    //   22230: istore_2
    //   22231: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22234: ldc_w 1264
    //   22237: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22240: iload 4
    //   22242: istore_2
    //   22243: aload_0
    //   22244: iconst_0
    //   22245: aaload
    //   22246: ldc_w 963
    //   22249: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22252: ifeq +3586 -> 25838
    //   22255: iload 4
    //   22257: istore_2
    //   22258: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22261: ldc_w 1266
    //   22264: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22267: goto +3571 -> 25838
    //   22270: iload_3
    //   22271: istore 4
    //   22273: iload_3
    //   22274: istore_2
    //   22275: iload 10
    //   22277: iload_1
    //   22278: getstatic 529	com/chelpus/root/utils/corepatch:byteOrigSOat8_1	[B
    //   22281: getstatic 531	com/chelpus/root/utils/corepatch:maskSOat8_1	[B
    //   22284: getstatic 533	com/chelpus/root/utils/corepatch:byteReplaceSOat8_1	[B
    //   22287: getstatic 535	com/chelpus/root/utils/corepatch:rep_maskSOat8_1	[B
    //   22290: iload 25
    //   22292: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22295: ifeq +56 -> 22351
    //   22298: iload_3
    //   22299: istore_2
    //   22300: aload_0
    //   22301: iconst_0
    //   22302: aaload
    //   22303: ldc_w 946
    //   22306: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22309: ifeq +14 -> 22323
    //   22312: iload_3
    //   22313: istore_2
    //   22314: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22317: ldc_w 1264
    //   22320: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22323: iload_3
    //   22324: istore_2
    //   22325: aload_0
    //   22326: iconst_0
    //   22327: aaload
    //   22328: ldc_w 963
    //   22331: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22334: ifeq +3512 -> 25846
    //   22337: iload_3
    //   22338: istore_2
    //   22339: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22342: ldc_w 1266
    //   22345: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22348: goto +3498 -> 25846
    //   22351: iload 4
    //   22353: istore_3
    //   22354: iload 4
    //   22356: istore_2
    //   22357: iload 10
    //   22359: iload_1
    //   22360: getstatic 561	com/chelpus/root/utils/corepatch:byteOrigSOat10	[B
    //   22363: getstatic 563	com/chelpus/root/utils/corepatch:maskSOat10	[B
    //   22366: getstatic 565	com/chelpus/root/utils/corepatch:byteReplaceSOat10	[B
    //   22369: getstatic 567	com/chelpus/root/utils/corepatch:rep_maskSOat10	[B
    //   22372: iload 25
    //   22374: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22377: ifeq +60 -> 22437
    //   22380: iload 4
    //   22382: istore_2
    //   22383: aload_0
    //   22384: iconst_0
    //   22385: aaload
    //   22386: ldc_w 946
    //   22389: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22392: ifeq +15 -> 22407
    //   22395: iload 4
    //   22397: istore_2
    //   22398: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22401: ldc_w 1264
    //   22404: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22407: iload 4
    //   22409: istore_2
    //   22410: aload_0
    //   22411: iconst_0
    //   22412: aaload
    //   22413: ldc_w 963
    //   22416: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22419: ifeq +3436 -> 25855
    //   22422: iload 4
    //   22424: istore_2
    //   22425: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22428: ldc_w 1266
    //   22431: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22434: goto +3421 -> 25855
    //   22437: iload_3
    //   22438: istore 4
    //   22440: iload_3
    //   22441: istore_2
    //   22442: iload 10
    //   22444: iload_1
    //   22445: getstatic 569	com/chelpus/root/utils/corepatch:byteOrigSOat10_1	[B
    //   22448: getstatic 571	com/chelpus/root/utils/corepatch:maskSOat10_1	[B
    //   22451: getstatic 573	com/chelpus/root/utils/corepatch:byteReplaceSOat10_1	[B
    //   22454: getstatic 575	com/chelpus/root/utils/corepatch:rep_maskSOat10_1	[B
    //   22457: iload 25
    //   22459: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22462: ifeq +56 -> 22518
    //   22465: iload_3
    //   22466: istore_2
    //   22467: aload_0
    //   22468: iconst_0
    //   22469: aaload
    //   22470: ldc_w 946
    //   22473: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22476: ifeq +14 -> 22490
    //   22479: iload_3
    //   22480: istore_2
    //   22481: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22484: ldc_w 1264
    //   22487: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22490: iload_3
    //   22491: istore_2
    //   22492: aload_0
    //   22493: iconst_0
    //   22494: aaload
    //   22495: ldc_w 963
    //   22498: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22501: ifeq +3362 -> 25863
    //   22504: iload_3
    //   22505: istore_2
    //   22506: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22509: ldc_w 1266
    //   22512: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22515: goto +3348 -> 25863
    //   22518: iload 4
    //   22520: istore_3
    //   22521: iload 4
    //   22523: istore_2
    //   22524: iload 10
    //   22526: iload_1
    //   22527: getstatic 577	com/chelpus/root/utils/corepatch:byteOrigSOat11	[B
    //   22530: getstatic 579	com/chelpus/root/utils/corepatch:maskSOat11	[B
    //   22533: getstatic 581	com/chelpus/root/utils/corepatch:byteReplaceSOat11	[B
    //   22536: getstatic 583	com/chelpus/root/utils/corepatch:rep_maskSOat11	[B
    //   22539: iload 25
    //   22541: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22544: ifeq +60 -> 22604
    //   22547: iload 4
    //   22549: istore_2
    //   22550: aload_0
    //   22551: iconst_0
    //   22552: aaload
    //   22553: ldc_w 946
    //   22556: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22559: ifeq +15 -> 22574
    //   22562: iload 4
    //   22564: istore_2
    //   22565: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22568: ldc_w 1264
    //   22571: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22574: iload 4
    //   22576: istore_2
    //   22577: aload_0
    //   22578: iconst_0
    //   22579: aaload
    //   22580: ldc_w 963
    //   22583: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22586: ifeq +3286 -> 25872
    //   22589: iload 4
    //   22591: istore_2
    //   22592: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22595: ldc_w 1266
    //   22598: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22601: goto +3271 -> 25872
    //   22604: iload_3
    //   22605: istore 4
    //   22607: iload_3
    //   22608: istore_2
    //   22609: iload 10
    //   22611: iload_1
    //   22612: getstatic 585	com/chelpus/root/utils/corepatch:byteOrigSOat11_1	[B
    //   22615: getstatic 587	com/chelpus/root/utils/corepatch:maskSOat11_1	[B
    //   22618: getstatic 589	com/chelpus/root/utils/corepatch:byteReplaceSOat11_1	[B
    //   22621: getstatic 591	com/chelpus/root/utils/corepatch:rep_maskSOat11_1	[B
    //   22624: iload 25
    //   22626: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22629: ifeq +56 -> 22685
    //   22632: iload_3
    //   22633: istore_2
    //   22634: aload_0
    //   22635: iconst_0
    //   22636: aaload
    //   22637: ldc_w 946
    //   22640: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22643: ifeq +14 -> 22657
    //   22646: iload_3
    //   22647: istore_2
    //   22648: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22651: ldc_w 1264
    //   22654: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22657: iload_3
    //   22658: istore_2
    //   22659: aload_0
    //   22660: iconst_0
    //   22661: aaload
    //   22662: ldc_w 963
    //   22665: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22668: ifeq +3212 -> 25880
    //   22671: iload_3
    //   22672: istore_2
    //   22673: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22676: ldc_w 1266
    //   22679: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22682: goto +3198 -> 25880
    //   22685: iload 4
    //   22687: istore_3
    //   22688: iload 4
    //   22690: istore_2
    //   22691: iload 10
    //   22693: iload_1
    //   22694: getstatic 593	com/chelpus/root/utils/corepatch:byteOrigSOat11_2	[B
    //   22697: getstatic 595	com/chelpus/root/utils/corepatch:maskSOat11_2	[B
    //   22700: getstatic 597	com/chelpus/root/utils/corepatch:byteReplaceSOat11_2	[B
    //   22703: getstatic 599	com/chelpus/root/utils/corepatch:rep_maskSOat11_2	[B
    //   22706: iload 25
    //   22708: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22711: ifeq +60 -> 22771
    //   22714: iload 4
    //   22716: istore_2
    //   22717: aload_0
    //   22718: iconst_0
    //   22719: aaload
    //   22720: ldc_w 946
    //   22723: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22726: ifeq +15 -> 22741
    //   22729: iload 4
    //   22731: istore_2
    //   22732: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22735: ldc_w 1264
    //   22738: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22741: iload 4
    //   22743: istore_2
    //   22744: aload_0
    //   22745: iconst_0
    //   22746: aaload
    //   22747: ldc_w 963
    //   22750: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22753: ifeq +3136 -> 25889
    //   22756: iload 4
    //   22758: istore_2
    //   22759: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22762: ldc_w 1266
    //   22765: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22768: goto +3121 -> 25889
    //   22771: iload_3
    //   22772: istore 4
    //   22774: iload_3
    //   22775: istore_2
    //   22776: iload 10
    //   22778: iload_1
    //   22779: getstatic 537	com/chelpus/root/utils/corepatch:byteOrigSOat9	[B
    //   22782: getstatic 539	com/chelpus/root/utils/corepatch:maskSOat9	[B
    //   22785: getstatic 541	com/chelpus/root/utils/corepatch:byteReplaceSOat9	[B
    //   22788: getstatic 543	com/chelpus/root/utils/corepatch:rep_maskSOat9	[B
    //   22791: iload 25
    //   22793: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22796: ifeq +56 -> 22852
    //   22799: iload_3
    //   22800: istore_2
    //   22801: aload_0
    //   22802: iconst_0
    //   22803: aaload
    //   22804: ldc_w 946
    //   22807: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22810: ifeq +14 -> 22824
    //   22813: iload_3
    //   22814: istore_2
    //   22815: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22818: ldc_w 1268
    //   22821: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22824: iload_3
    //   22825: istore_2
    //   22826: aload_0
    //   22827: iconst_0
    //   22828: aaload
    //   22829: ldc_w 963
    //   22832: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22835: ifeq +3062 -> 25897
    //   22838: iload_3
    //   22839: istore_2
    //   22840: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22843: ldc_w 1270
    //   22846: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22849: goto +3048 -> 25897
    //   22852: iload 4
    //   22854: istore_3
    //   22855: iload 4
    //   22857: istore_2
    //   22858: iload 10
    //   22860: iload_1
    //   22861: getstatic 545	com/chelpus/root/utils/corepatch:byteOrigSOat9_1	[B
    //   22864: getstatic 547	com/chelpus/root/utils/corepatch:maskSOat9_1	[B
    //   22867: getstatic 549	com/chelpus/root/utils/corepatch:byteReplaceSOat9_1	[B
    //   22870: getstatic 551	com/chelpus/root/utils/corepatch:rep_maskSOat9_1	[B
    //   22873: iload 25
    //   22875: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22878: ifeq +60 -> 22938
    //   22881: iload 4
    //   22883: istore_2
    //   22884: aload_0
    //   22885: iconst_0
    //   22886: aaload
    //   22887: ldc_w 946
    //   22890: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22893: ifeq +15 -> 22908
    //   22896: iload 4
    //   22898: istore_2
    //   22899: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22902: ldc_w 1268
    //   22905: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22908: iload 4
    //   22910: istore_2
    //   22911: aload_0
    //   22912: iconst_0
    //   22913: aaload
    //   22914: ldc_w 963
    //   22917: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22920: ifeq +2986 -> 25906
    //   22923: iload 4
    //   22925: istore_2
    //   22926: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22929: ldc_w 1270
    //   22932: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22935: goto +2971 -> 25906
    //   22938: iload_3
    //   22939: istore 4
    //   22941: iload 5
    //   22943: istore 8
    //   22945: iload_3
    //   22946: istore_2
    //   22947: iload 10
    //   22949: iload_1
    //   22950: getstatic 553	com/chelpus/root/utils/corepatch:byteOrigSOat9_2	[B
    //   22953: getstatic 555	com/chelpus/root/utils/corepatch:maskSOat9_2	[B
    //   22956: getstatic 557	com/chelpus/root/utils/corepatch:byteReplaceSOat9_2	[B
    //   22959: getstatic 559	com/chelpus/root/utils/corepatch:rep_maskSOat9_2	[B
    //   22962: iload 25
    //   22964: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   22967: ifeq +56 -> 23023
    //   22970: iload_3
    //   22971: istore_2
    //   22972: aload_0
    //   22973: iconst_0
    //   22974: aaload
    //   22975: ldc_w 946
    //   22978: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22981: ifeq +14 -> 22995
    //   22984: iload_3
    //   22985: istore_2
    //   22986: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   22989: ldc_w 1268
    //   22992: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   22995: iload_3
    //   22996: istore_2
    //   22997: aload_0
    //   22998: iconst_0
    //   22999: aaload
    //   23000: ldc_w 963
    //   23003: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23006: ifeq +2908 -> 25914
    //   23009: iload_3
    //   23010: istore_2
    //   23011: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23014: ldc_w 1270
    //   23017: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23020: goto +2894 -> 25914
    //   23023: iload 4
    //   23025: istore 5
    //   23027: iload 4
    //   23029: istore_2
    //   23030: iload 10
    //   23032: iload_1
    //   23033: getstatic 601	com/chelpus/root/utils/corepatch:byteOrigSOat12	[B
    //   23036: getstatic 603	com/chelpus/root/utils/corepatch:maskSOat12	[B
    //   23039: getstatic 605	com/chelpus/root/utils/corepatch:byteReplaceSOat12	[B
    //   23042: getstatic 607	com/chelpus/root/utils/corepatch:rep_maskSOat12	[B
    //   23045: iload 25
    //   23047: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   23050: ifeq +60 -> 23110
    //   23053: iload 4
    //   23055: istore_2
    //   23056: aload_0
    //   23057: iconst_0
    //   23058: aaload
    //   23059: ldc_w 946
    //   23062: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23065: ifeq +15 -> 23080
    //   23068: iload 4
    //   23070: istore_2
    //   23071: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23074: ldc_w 1268
    //   23077: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23080: iload 4
    //   23082: istore_2
    //   23083: aload_0
    //   23084: iconst_0
    //   23085: aaload
    //   23086: ldc_w 963
    //   23089: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23092: ifeq +2831 -> 25923
    //   23095: iload 4
    //   23097: istore_2
    //   23098: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23101: ldc_w 1270
    //   23104: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23107: goto +2816 -> 25923
    //   23110: iload 5
    //   23112: istore_2
    //   23113: iload 5
    //   23115: istore_3
    //   23116: iload 10
    //   23118: iload_1
    //   23119: getstatic 609	com/chelpus/root/utils/corepatch:byteOrigSOat12_1	[B
    //   23122: getstatic 611	com/chelpus/root/utils/corepatch:maskSOat12_1	[B
    //   23125: getstatic 613	com/chelpus/root/utils/corepatch:byteReplaceSOat12_1	[B
    //   23128: getstatic 615	com/chelpus/root/utils/corepatch:rep_maskSOat12_1	[B
    //   23131: iload 25
    //   23133: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   23136: ifeq +2801 -> 25937
    //   23139: iload 5
    //   23141: istore_2
    //   23142: aload_0
    //   23143: iconst_0
    //   23144: aaload
    //   23145: ldc_w 946
    //   23148: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23151: ifeq +15 -> 23166
    //   23154: iload 5
    //   23156: istore_2
    //   23157: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23160: ldc_w 1268
    //   23163: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23166: iload 5
    //   23168: istore_2
    //   23169: aload_0
    //   23170: iconst_0
    //   23171: aaload
    //   23172: ldc_w 963
    //   23175: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23178: ifeq +2754 -> 25932
    //   23181: iload 5
    //   23183: istore_2
    //   23184: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23187: ldc_w 1270
    //   23190: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23193: goto +2739 -> 25932
    //   23196: iload_3
    //   23197: istore_2
    //   23198: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   23201: iload 10
    //   23203: iconst_1
    //   23204: iadd
    //   23205: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   23208: pop
    //   23209: iload 8
    //   23211: istore 5
    //   23213: goto -1811 -> 21402
    //   23216: astore 35
    //   23218: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23221: new 1031	java/lang/StringBuilder
    //   23224: dup
    //   23225: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   23228: ldc_w 299
    //   23231: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23234: aload 35
    //   23236: invokevirtual 1129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23239: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23242: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23245: iload_2
    //   23246: istore 4
    //   23248: goto -2173 -> 21075
    //   23251: astore 35
    //   23253: aload 35
    //   23255: invokevirtual 1110	java/lang/Exception:printStackTrace	()V
    //   23258: new 980	java/io/File
    //   23261: dup
    //   23262: aload 33
    //   23264: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23267: invokevirtual 1132	java/io/File:delete	()Z
    //   23270: pop
    //   23271: goto -2016 -> 21255
    //   23274: iconst_1
    //   23275: putstatic 305	com/chelpus/root/utils/corepatch:not_found_bytes_for_patch	Z
    //   23278: goto -2023 -> 21255
    //   23281: aload 32
    //   23283: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   23286: ldc_w 1161
    //   23289: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   23292: ifeq +658 -> 23950
    //   23295: aload 32
    //   23297: invokestatic 1333	com/chelpus/Utils:fixadler	(Ljava/io/File;)V
    //   23300: aload 32
    //   23302: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   23305: ldc_w 1476
    //   23308: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23311: ifeq +17 -> 23328
    //   23314: iload 4
    //   23316: ifeq +12 -> 23328
    //   23319: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23322: ldc_w 1433
    //   23325: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23328: aload 32
    //   23330: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   23333: ldc_w 1161
    //   23336: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23339: ifeq +526 -> 23865
    //   23342: iload 4
    //   23344: ifeq +521 -> 23865
    //   23347: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23350: ldc_w 1376
    //   23353: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23356: ldc_w 1463
    //   23359: ldc_w 1490
    //   23362: iconst_1
    //   23363: iconst_0
    //   23364: invokestatic 1382	com/chelpus/Utils:copyFile	(Ljava/lang/String;Ljava/lang/String;ZZ)Z
    //   23367: ifeq +637 -> 24004
    //   23370: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23373: ldc_w 1384
    //   23376: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23379: new 980	java/io/File
    //   23382: dup
    //   23383: ldc_w 1490
    //   23386: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23389: invokevirtual 1132	java/io/File:delete	()Z
    //   23392: pop
    //   23393: new 974	java/util/ArrayList
    //   23396: dup
    //   23397: invokespecial 975	java/util/ArrayList:<init>	()V
    //   23400: astore 32
    //   23402: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23405: ldc_w 1343
    //   23408: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23411: aload 32
    //   23413: new 1345	com/android/vending/billing/InAppBillingService/LACK/AddFilesItem
    //   23416: dup
    //   23417: ldc_w 1196
    //   23420: ldc_w 1386
    //   23423: invokespecial 1350	com/android/vending/billing/InAppBillingService/LACK/AddFilesItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   23426: invokevirtual 991	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   23429: pop
    //   23430: ldc_w 1463
    //   23433: ldc_w 1490
    //   23436: aload 32
    //   23438: invokestatic 1354	com/chelpus/Utils:addFilesToZip	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   23441: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23444: ldc_w 1356
    //   23447: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23450: iconst_3
    //   23451: anewarray 904	java/lang/String
    //   23454: dup
    //   23455: iconst_0
    //   23456: ldc_w 1388
    //   23459: aastore
    //   23460: dup
    //   23461: iconst_1
    //   23462: ldc_w 1390
    //   23465: aastore
    //   23466: dup
    //   23467: iconst_2
    //   23468: ldc_w 1490
    //   23471: aastore
    //   23472: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   23475: iconst_3
    //   23476: anewarray 904	java/lang/String
    //   23479: dup
    //   23480: iconst_0
    //   23481: ldc_w 1395
    //   23484: aastore
    //   23485: dup
    //   23486: iconst_1
    //   23487: ldc_w 1397
    //   23490: aastore
    //   23491: dup
    //   23492: iconst_2
    //   23493: ldc_w 1490
    //   23496: aastore
    //   23497: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   23500: iconst_3
    //   23501: anewarray 904	java/lang/String
    //   23504: dup
    //   23505: iconst_0
    //   23506: ldc_w 1388
    //   23509: aastore
    //   23510: dup
    //   23511: iconst_1
    //   23512: ldc_w 1399
    //   23515: aastore
    //   23516: dup
    //   23517: iconst_2
    //   23518: ldc_w 1490
    //   23521: aastore
    //   23522: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   23525: new 980	java/io/File
    //   23528: dup
    //   23529: ldc_w 1459
    //   23532: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23535: astore 32
    //   23537: ldc_w 1463
    //   23540: invokestatic 1409	com/chelpus/Utils:getFileDalvikCache	(Ljava/lang/String;)Ljava/io/File;
    //   23543: astore 33
    //   23545: aload 32
    //   23547: invokevirtual 988	java/io/File:exists	()Z
    //   23550: ifeq +20 -> 23570
    //   23553: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23556: ldc_w 1492
    //   23559: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23562: aload 32
    //   23564: ldc_w 1490
    //   23567: invokestatic 1363	com/chelpus/Utils:fixadlerOdex	(Ljava/io/File;Ljava/lang/String;)V
    //   23570: new 980	java/io/File
    //   23573: dup
    //   23574: new 1031	java/lang/StringBuilder
    //   23577: dup
    //   23578: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   23581: getstatic 1143	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
    //   23584: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23587: ldc_w 1494
    //   23590: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23593: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23596: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23599: invokevirtual 1497	java/io/File:createNewFile	()Z
    //   23602: pop
    //   23603: new 980	java/io/File
    //   23606: dup
    //   23607: ldc_w 1463
    //   23610: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23613: invokevirtual 1132	java/io/File:delete	()Z
    //   23616: pop
    //   23617: iconst_2
    //   23618: anewarray 904	java/lang/String
    //   23621: dup
    //   23622: iconst_0
    //   23623: ldc_w 1401
    //   23626: aastore
    //   23627: dup
    //   23628: iconst_1
    //   23629: ldc_w 1463
    //   23632: aastore
    //   23633: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   23636: new 980	java/io/File
    //   23639: dup
    //   23640: ldc_w 1490
    //   23643: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23646: new 980	java/io/File
    //   23649: dup
    //   23650: ldc_w 1463
    //   23653: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23656: invokevirtual 1368	java/io/File:renameTo	(Ljava/io/File;)Z
    //   23659: pop
    //   23660: new 980	java/io/File
    //   23663: dup
    //   23664: ldc_w 1463
    //   23667: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23670: invokevirtual 988	java/io/File:exists	()Z
    //   23673: ifne +28 -> 23701
    //   23676: iconst_3
    //   23677: anewarray 904	java/lang/String
    //   23680: dup
    //   23681: iconst_0
    //   23682: ldc_w 1403
    //   23685: aastore
    //   23686: dup
    //   23687: iconst_1
    //   23688: ldc_w 1490
    //   23691: aastore
    //   23692: dup
    //   23693: iconst_2
    //   23694: ldc_w 1463
    //   23697: aastore
    //   23698: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   23701: aload 33
    //   23703: ifnull +38 -> 23741
    //   23706: iconst_2
    //   23707: anewarray 904	java/lang/String
    //   23710: dup
    //   23711: iconst_0
    //   23712: ldc_w 1401
    //   23715: aastore
    //   23716: dup
    //   23717: iconst_1
    //   23718: aload 33
    //   23720: invokevirtual 1042	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   23723: aastore
    //   23724: invokestatic 1393	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   23727: aload 33
    //   23729: invokevirtual 988	java/io/File:exists	()Z
    //   23732: ifeq +9 -> 23741
    //   23735: aload 33
    //   23737: invokevirtual 1132	java/io/File:delete	()Z
    //   23740: pop
    //   23741: new 980	java/io/File
    //   23744: dup
    //   23745: ldc_w 1411
    //   23748: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23751: invokevirtual 1132	java/io/File:delete	()Z
    //   23754: pop
    //   23755: new 980	java/io/File
    //   23758: dup
    //   23759: ldc_w 1413
    //   23762: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23765: invokevirtual 1132	java/io/File:delete	()Z
    //   23768: pop
    //   23769: new 980	java/io/File
    //   23772: dup
    //   23773: ldc_w 1415
    //   23776: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23779: invokevirtual 1132	java/io/File:delete	()Z
    //   23782: pop
    //   23783: new 980	java/io/File
    //   23786: dup
    //   23787: ldc_w 1417
    //   23790: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23793: invokevirtual 1132	java/io/File:delete	()Z
    //   23796: pop
    //   23797: new 980	java/io/File
    //   23800: dup
    //   23801: ldc_w 1419
    //   23804: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23807: invokevirtual 1132	java/io/File:delete	()Z
    //   23810: pop
    //   23811: new 980	java/io/File
    //   23814: dup
    //   23815: ldc_w 1421
    //   23818: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23821: invokevirtual 1132	java/io/File:delete	()Z
    //   23824: pop
    //   23825: new 980	java/io/File
    //   23828: dup
    //   23829: ldc_w 1423
    //   23832: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23835: invokevirtual 1132	java/io/File:delete	()Z
    //   23838: pop
    //   23839: new 980	java/io/File
    //   23842: dup
    //   23843: ldc_w 1425
    //   23846: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23849: invokevirtual 1132	java/io/File:delete	()Z
    //   23852: pop
    //   23853: invokestatic 1500	com/chelpus/Utils:clear_dalvik_cache	()V
    //   23856: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23859: ldc_w 1427
    //   23862: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23865: getstatic 303	com/chelpus/root/utils/corepatch:onlyDalvik	Z
    //   23868: ifne -8525 -> 15343
    //   23871: new 980	java/io/File
    //   23874: dup
    //   23875: ldc_w 1502
    //   23878: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23881: invokevirtual 988	java/io/File:exists	()Z
    //   23884: ifeq +12 -> 23896
    //   23887: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23890: ldc_w 1504
    //   23893: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23896: new 980	java/io/File
    //   23899: dup
    //   23900: ldc_w 1459
    //   23903: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23906: invokevirtual 988	java/io/File:exists	()Z
    //   23909: ifeq +12 -> 23921
    //   23912: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23915: ldc_w 1506
    //   23918: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23921: aload_0
    //   23922: iconst_0
    //   23923: aaload
    //   23924: ldc_w 963
    //   23927: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23930: ifeq -8587 -> 15343
    //   23933: new 980	java/io/File
    //   23936: dup
    //   23937: ldc_w 1508
    //   23940: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23943: invokevirtual 1132	java/io/File:delete	()Z
    //   23946: pop
    //   23947: goto -8604 -> 15343
    //   23950: aload 32
    //   23952: ldc_w 1463
    //   23955: invokestatic 1363	com/chelpus/Utils:fixadlerOdex	(Ljava/io/File;Ljava/lang/String;)V
    //   23958: goto -658 -> 23300
    //   23961: astore 32
    //   23963: aload 32
    //   23965: invokevirtual 1110	java/lang/Exception:printStackTrace	()V
    //   23968: goto -115 -> 23853
    //   23971: astore 32
    //   23973: aload 32
    //   23975: invokevirtual 1110	java/lang/Exception:printStackTrace	()V
    //   23978: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   23981: ldc_w 1431
    //   23984: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23987: new 980	java/io/File
    //   23990: dup
    //   23991: ldc_w 1490
    //   23994: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   23997: invokevirtual 1132	java/io/File:delete	()Z
    //   24000: pop
    //   24001: goto -145 -> 23856
    //   24004: new 980	java/io/File
    //   24007: dup
    //   24008: ldc_w 1490
    //   24011: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   24014: invokevirtual 1132	java/io/File:delete	()Z
    //   24017: pop
    //   24018: new 980	java/io/File
    //   24021: dup
    //   24022: aload_0
    //   24023: iconst_2
    //   24024: aaload
    //   24025: invokespecial 984	java/io/File:<init>	(Ljava/lang/String;)V
    //   24028: astore 32
    //   24030: aload 32
    //   24032: astore 33
    //   24034: aload 32
    //   24036: astore 33
    //   24038: new 1047	java/io/RandomAccessFile
    //   24041: dup
    //   24042: aload 32
    //   24044: ldc_w 914
    //   24047: invokespecial 1050	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24050: invokevirtual 1054	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   24053: astore 35
    //   24055: aload 32
    //   24057: astore 33
    //   24059: aload 32
    //   24061: astore 33
    //   24063: aload 35
    //   24065: getstatic 1060	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   24068: lconst_0
    //   24069: aload 35
    //   24071: invokevirtual 1065	java/nio/channels/FileChannel:size	()J
    //   24074: l2i
    //   24075: i2l
    //   24076: invokevirtual 1069	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   24079: putstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   24082: aload 32
    //   24084: astore 33
    //   24086: aload 32
    //   24088: astore 33
    //   24090: aconst_null
    //   24091: putstatic 311	com/chelpus/root/utils/corepatch:lastByteReplace	[B
    //   24094: aload 32
    //   24096: astore 33
    //   24098: aload 32
    //   24100: astore 33
    //   24102: iconst_0
    //   24103: putstatic 309	com/chelpus/root/utils/corepatch:lastPatchPosition	I
    //   24106: lconst_0
    //   24107: lstore 30
    //   24109: aload 32
    //   24111: astore 33
    //   24113: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   24116: invokevirtual 1081	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   24119: ifeq +781 -> 24900
    //   24122: aload 32
    //   24124: astore 33
    //   24126: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   24129: invokevirtual 1083	java/nio/MappedByteBuffer:position	()I
    //   24132: istore_2
    //   24133: aload 32
    //   24135: astore 33
    //   24137: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   24140: invokevirtual 859	java/nio/MappedByteBuffer:get	()B
    //   24143: istore_1
    //   24144: aload 32
    //   24146: astore 33
    //   24148: iload_2
    //   24149: iload_1
    //   24150: getstatic 617	com/chelpus/root/utils/corepatch:byteOrigS2	[B
    //   24153: getstatic 619	com/chelpus/root/utils/corepatch:maskS2	[B
    //   24156: getstatic 621	com/chelpus/root/utils/corepatch:byteReplaceS2	[B
    //   24159: getstatic 623	com/chelpus/root/utils/corepatch:rep_maskS2	[B
    //   24162: iload 25
    //   24164: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   24167: ifeq +64 -> 24231
    //   24170: aload 32
    //   24172: astore 33
    //   24174: aload_0
    //   24175: iconst_0
    //   24176: aaload
    //   24177: ldc_w 946
    //   24180: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24183: ifeq +16 -> 24199
    //   24186: aload 32
    //   24188: astore 33
    //   24190: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24193: ldc_w 1264
    //   24196: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24199: aload 32
    //   24201: astore 33
    //   24203: aload_0
    //   24204: iconst_0
    //   24205: aaload
    //   24206: ldc_w 963
    //   24209: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24212: ifeq +1764 -> 25976
    //   24215: aload 32
    //   24217: astore 33
    //   24219: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24222: ldc_w 1266
    //   24225: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24228: goto +1748 -> 25976
    //   24231: aload 32
    //   24233: astore 33
    //   24235: iload_2
    //   24236: iload_1
    //   24237: getstatic 641	com/chelpus/root/utils/corepatch:byteOrigS5	[B
    //   24240: getstatic 643	com/chelpus/root/utils/corepatch:maskS5	[B
    //   24243: getstatic 645	com/chelpus/root/utils/corepatch:byteReplaceS5	[B
    //   24246: getstatic 647	com/chelpus/root/utils/corepatch:rep_maskS5	[B
    //   24249: iload 25
    //   24251: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   24254: ifeq +64 -> 24318
    //   24257: aload 32
    //   24259: astore 33
    //   24261: aload_0
    //   24262: iconst_0
    //   24263: aaload
    //   24264: ldc_w 946
    //   24267: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24270: ifeq +16 -> 24286
    //   24273: aload 32
    //   24275: astore 33
    //   24277: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24280: ldc_w 1264
    //   24283: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24286: aload 32
    //   24288: astore 33
    //   24290: aload_0
    //   24291: iconst_0
    //   24292: aaload
    //   24293: ldc_w 963
    //   24296: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24299: ifeq +1680 -> 25979
    //   24302: aload 32
    //   24304: astore 33
    //   24306: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24309: ldc_w 1266
    //   24312: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24315: goto +1664 -> 25979
    //   24318: aload 32
    //   24320: astore 33
    //   24322: iload_2
    //   24323: iload_1
    //   24324: getstatic 673	com/chelpus/root/utils/corepatch:byteOrigS14	[B
    //   24327: getstatic 675	com/chelpus/root/utils/corepatch:maskS14	[B
    //   24330: getstatic 677	com/chelpus/root/utils/corepatch:byteReplaceS14	[B
    //   24333: getstatic 679	com/chelpus/root/utils/corepatch:rep_maskS14	[B
    //   24336: iload 25
    //   24338: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   24341: ifeq +64 -> 24405
    //   24344: aload 32
    //   24346: astore 33
    //   24348: aload_0
    //   24349: iconst_0
    //   24350: aaload
    //   24351: ldc_w 946
    //   24354: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24357: ifeq +16 -> 24373
    //   24360: aload 32
    //   24362: astore 33
    //   24364: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24367: ldc_w 1264
    //   24370: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24373: aload 32
    //   24375: astore 33
    //   24377: aload_0
    //   24378: iconst_0
    //   24379: aaload
    //   24380: ldc_w 963
    //   24383: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24386: ifeq +1596 -> 25982
    //   24389: aload 32
    //   24391: astore 33
    //   24393: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24396: ldc_w 1266
    //   24399: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24402: goto +1580 -> 25982
    //   24405: aload 32
    //   24407: astore 33
    //   24409: iload_2
    //   24410: iload_1
    //   24411: getstatic 649	com/chelpus/root/utils/corepatch:byteOrigS6	[B
    //   24414: getstatic 651	com/chelpus/root/utils/corepatch:maskS6	[B
    //   24417: getstatic 653	com/chelpus/root/utils/corepatch:byteReplaceS6	[B
    //   24420: getstatic 655	com/chelpus/root/utils/corepatch:rep_maskS6	[B
    //   24423: iload 25
    //   24425: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   24428: ifeq +64 -> 24492
    //   24431: aload 32
    //   24433: astore 33
    //   24435: aload_0
    //   24436: iconst_0
    //   24437: aaload
    //   24438: ldc_w 946
    //   24441: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24444: ifeq +16 -> 24460
    //   24447: aload 32
    //   24449: astore 33
    //   24451: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24454: ldc_w 1272
    //   24457: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24460: aload 32
    //   24462: astore 33
    //   24464: aload_0
    //   24465: iconst_0
    //   24466: aaload
    //   24467: ldc_w 963
    //   24470: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24473: ifeq +1512 -> 25985
    //   24476: aload 32
    //   24478: astore 33
    //   24480: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24483: ldc_w 1274
    //   24486: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24489: goto +1496 -> 25985
    //   24492: aload 32
    //   24494: astore 33
    //   24496: iload_2
    //   24497: iload_1
    //   24498: getstatic 657	com/chelpus/root/utils/corepatch:byteOrigS7	[B
    //   24501: getstatic 659	com/chelpus/root/utils/corepatch:maskS7	[B
    //   24504: getstatic 661	com/chelpus/root/utils/corepatch:byteReplaceS7	[B
    //   24507: getstatic 663	com/chelpus/root/utils/corepatch:rep_maskS7	[B
    //   24510: iload 25
    //   24512: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   24515: ifeq +64 -> 24579
    //   24518: aload 32
    //   24520: astore 33
    //   24522: aload_0
    //   24523: iconst_0
    //   24524: aaload
    //   24525: ldc_w 946
    //   24528: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24531: ifeq +16 -> 24547
    //   24534: aload 32
    //   24536: astore 33
    //   24538: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24541: ldc_w 1302
    //   24544: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24547: aload 32
    //   24549: astore 33
    //   24551: aload_0
    //   24552: iconst_0
    //   24553: aaload
    //   24554: ldc_w 963
    //   24557: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24560: ifeq +1428 -> 25988
    //   24563: aload 32
    //   24565: astore 33
    //   24567: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24570: ldc_w 1304
    //   24573: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24576: goto +1412 -> 25988
    //   24579: aload 32
    //   24581: astore 33
    //   24583: iload_2
    //   24584: iload_1
    //   24585: getstatic 625	com/chelpus/root/utils/corepatch:byteOrigS3	[B
    //   24588: getstatic 627	com/chelpus/root/utils/corepatch:maskS3	[B
    //   24591: getstatic 629	com/chelpus/root/utils/corepatch:byteReplaceS3	[B
    //   24594: getstatic 631	com/chelpus/root/utils/corepatch:rep_maskS3	[B
    //   24597: iload 25
    //   24599: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   24602: ifeq +64 -> 24666
    //   24605: aload 32
    //   24607: astore 33
    //   24609: aload_0
    //   24610: iconst_0
    //   24611: aaload
    //   24612: ldc_w 946
    //   24615: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24618: ifeq +16 -> 24634
    //   24621: aload 32
    //   24623: astore 33
    //   24625: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24628: ldc_w 1306
    //   24631: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24634: aload 32
    //   24636: astore 33
    //   24638: aload_0
    //   24639: iconst_0
    //   24640: aaload
    //   24641: ldc_w 963
    //   24644: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24647: ifeq +1344 -> 25991
    //   24650: aload 32
    //   24652: astore 33
    //   24654: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24657: ldc_w 1308
    //   24660: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24663: goto +1328 -> 25991
    //   24666: aload 32
    //   24668: astore 33
    //   24670: iload_2
    //   24671: iload_1
    //   24672: getstatic 633	com/chelpus/root/utils/corepatch:byteOrigS4	[B
    //   24675: getstatic 635	com/chelpus/root/utils/corepatch:maskS4	[B
    //   24678: getstatic 637	com/chelpus/root/utils/corepatch:byteReplaceS4	[B
    //   24681: getstatic 639	com/chelpus/root/utils/corepatch:rep_maskS4	[B
    //   24684: iload 25
    //   24686: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   24689: ifeq +64 -> 24753
    //   24692: aload 32
    //   24694: astore 33
    //   24696: aload_0
    //   24697: iconst_0
    //   24698: aaload
    //   24699: ldc_w 946
    //   24702: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24705: ifeq +16 -> 24721
    //   24708: aload 32
    //   24710: astore 33
    //   24712: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24715: ldc_w 1310
    //   24718: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24721: aload 32
    //   24723: astore 33
    //   24725: aload_0
    //   24726: iconst_0
    //   24727: aaload
    //   24728: ldc_w 963
    //   24731: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24734: ifeq +1260 -> 25994
    //   24737: aload 32
    //   24739: astore 33
    //   24741: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24744: ldc_w 1312
    //   24747: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24750: goto +1244 -> 25994
    //   24753: aload 32
    //   24755: astore 33
    //   24757: iload_2
    //   24758: iload_1
    //   24759: getstatic 665	com/chelpus/root/utils/corepatch:byteOrigS13	[B
    //   24762: getstatic 667	com/chelpus/root/utils/corepatch:maskS13	[B
    //   24765: getstatic 669	com/chelpus/root/utils/corepatch:byteReplaceS13	[B
    //   24768: getstatic 671	com/chelpus/root/utils/corepatch:rep_maskS13	[B
    //   24771: iload 25
    //   24773: invokestatic 1085	com/chelpus/root/utils/corepatch:applyPatch	(IB[B[B[B[BZ)Z
    //   24776: ifeq +64 -> 24840
    //   24779: aload 32
    //   24781: astore 33
    //   24783: aload_0
    //   24784: iconst_0
    //   24785: aaload
    //   24786: ldc_w 946
    //   24789: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24792: ifeq +16 -> 24808
    //   24795: aload 32
    //   24797: astore 33
    //   24799: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24802: ldc_w 1310
    //   24805: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24808: aload 32
    //   24810: astore 33
    //   24812: aload_0
    //   24813: iconst_0
    //   24814: aaload
    //   24815: ldc_w 963
    //   24818: invokevirtual 924	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   24821: ifeq +1176 -> 25997
    //   24824: aload 32
    //   24826: astore 33
    //   24828: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24831: ldc_w 1312
    //   24834: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24837: goto +1160 -> 25997
    //   24840: aload 32
    //   24842: astore 33
    //   24844: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   24847: iload_2
    //   24848: iconst_1
    //   24849: iadd
    //   24850: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   24853: pop
    //   24854: lload 30
    //   24856: lconst_1
    //   24857: ladd
    //   24858: lstore 30
    //   24860: goto -751 -> 24109
    //   24863: astore 36
    //   24865: aload 32
    //   24867: astore 33
    //   24869: aload 32
    //   24871: astore 33
    //   24873: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   24876: new 1031	java/lang/StringBuilder
    //   24879: dup
    //   24880: invokespecial 1032	java/lang/StringBuilder:<init>	()V
    //   24883: ldc_w 299
    //   24886: invokevirtual 1038	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24889: aload 36
    //   24891: invokevirtual 1129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24894: invokevirtual 1045	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24897: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24900: aload 32
    //   24902: astore 33
    //   24904: aload 32
    //   24906: astore 33
    //   24908: getstatic 309	com/chelpus/root/utils/corepatch:lastPatchPosition	I
    //   24911: ifle +68 -> 24979
    //   24914: aload 32
    //   24916: astore 33
    //   24918: aload 32
    //   24920: astore 33
    //   24922: getstatic 311	com/chelpus/root/utils/corepatch:lastByteReplace	[B
    //   24925: ifnull +54 -> 24979
    //   24928: aload 32
    //   24930: astore 33
    //   24932: aload 32
    //   24934: astore 33
    //   24936: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   24939: getstatic 309	com/chelpus/root/utils/corepatch:lastPatchPosition	I
    //   24942: invokevirtual 855	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   24945: pop
    //   24946: aload 32
    //   24948: astore 33
    //   24950: aload 32
    //   24952: astore 33
    //   24954: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   24957: getstatic 311	com/chelpus/root/utils/corepatch:lastByteReplace	[B
    //   24960: invokevirtual 863	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   24963: pop
    //   24964: aload 32
    //   24966: astore 33
    //   24968: aload 32
    //   24970: astore 33
    //   24972: getstatic 307	com/chelpus/root/utils/corepatch:fileBytes	Ljava/nio/MappedByteBuffer;
    //   24975: invokevirtual 867	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   24978: pop
    //   24979: aload 32
    //   24981: astore 33
    //   24983: aload 32
    //   24985: astore 33
    //   24987: aload 35
    //   24989: invokevirtual 1106	java/nio/channels/FileChannel:close	()V
    //   24992: aload 32
    //   24994: astore 33
    //   24996: aload 32
    //   24998: astore 33
    //   25000: aload 32
    //   25002: invokevirtual 1297	java/io/File:toString	()Ljava/lang/String;
    //   25005: ldc_w 1161
    //   25008: invokevirtual 1329	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   25011: ifeq +36 -> 25047
    //   25014: aload 32
    //   25016: astore 33
    //   25018: aload 32
    //   25020: astore 33
    //   25022: aload 32
    //   25024: invokestatic 1333	com/chelpus/Utils:fixadler	(Ljava/io/File;)V
    //   25027: aload 32
    //   25029: astore 33
    //   25031: aload 32
    //   25033: astore 33
    //   25035: getstatic 894	java/lang/System:out	Ljava/io/PrintStream;
    //   25038: ldc_w 1431
    //   25041: invokevirtual 900	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   25044: goto -1179 -> 23865
    //   25047: aload 32
    //   25049: astore 33
    //   25051: aload 32
    //   25053: astore 33
    //   25055: aload 32
    //   25057: ldc_w 1463
    //   25060: invokestatic 1363	com/chelpus/Utils:fixadlerOdex	(Ljava/io/File;Ljava/lang/String;)V
    //   25063: goto -36 -> 25027
    //   25066: goto -4168 -> 20898
    //   25069: aload 32
    //   25071: astore 33
    //   25073: goto -4127 -> 20946
    //   25076: iconst_1
    //   25077: istore 14
    //   25079: iconst_1
    //   25080: istore 16
    //   25082: iconst_1
    //   25083: istore 20
    //   25085: iconst_1
    //   25086: istore 15
    //   25088: goto -23535 -> 1553
    //   25091: iconst_1
    //   25092: istore 6
    //   25094: iconst_1
    //   25095: istore 16
    //   25097: iconst_1
    //   25098: istore 20
    //   25100: iconst_1
    //   25101: istore 15
    //   25103: goto -23271 -> 1832
    //   25106: iconst_1
    //   25107: istore 14
    //   25109: iconst_1
    //   25110: istore 17
    //   25112: goto -22997 -> 2115
    //   25115: iconst_1
    //   25116: istore 11
    //   25118: iconst_1
    //   25119: istore 17
    //   25121: iconst_1
    //   25122: istore 15
    //   25124: iconst_1
    //   25125: istore 16
    //   25127: goto -22733 -> 2394
    //   25130: iconst_1
    //   25131: istore 14
    //   25133: iconst_1
    //   25134: istore 17
    //   25136: iconst_1
    //   25137: istore 15
    //   25139: iconst_1
    //   25140: istore 16
    //   25142: goto -22469 -> 2673
    //   25145: iconst_1
    //   25146: istore 11
    //   25148: iconst_1
    //   25149: istore 16
    //   25151: iconst_1
    //   25152: istore 17
    //   25154: iconst_1
    //   25155: istore 15
    //   25157: goto -22205 -> 2952
    //   25160: iconst_1
    //   25161: istore 14
    //   25163: iconst_1
    //   25164: istore 19
    //   25166: iconst_1
    //   25167: istore 17
    //   25169: iconst_1
    //   25170: istore 15
    //   25172: goto -21937 -> 3235
    //   25175: iconst_1
    //   25176: istore 11
    //   25178: iconst_1
    //   25179: istore 20
    //   25181: goto -21663 -> 3518
    //   25184: iconst_1
    //   25185: istore 14
    //   25187: iconst_1
    //   25188: istore 15
    //   25190: goto -21393 -> 3797
    //   25193: iconst_1
    //   25194: istore 8
    //   25196: iconst_1
    //   25197: istore 21
    //   25199: goto -21119 -> 4080
    //   25202: iconst_1
    //   25203: istore 14
    //   25205: iconst_1
    //   25206: istore 18
    //   25208: goto -20849 -> 4359
    //   25211: iconst_1
    //   25212: istore 7
    //   25214: iconst_1
    //   25215: istore 18
    //   25217: goto -20579 -> 4638
    //   25220: iconst_1
    //   25221: istore 14
    //   25223: iconst_1
    //   25224: istore 18
    //   25226: goto -20309 -> 4917
    //   25229: iconst_1
    //   25230: istore 7
    //   25232: iconst_1
    //   25233: istore 18
    //   25235: goto -20039 -> 5196
    //   25238: iconst_1
    //   25239: istore 14
    //   25241: iconst_1
    //   25242: istore 18
    //   25244: goto -19769 -> 5475
    //   25247: iconst_1
    //   25248: istore 4
    //   25250: goto -18265 -> 6985
    //   25253: iconst_1
    //   25254: istore_3
    //   25255: goto -18184 -> 7071
    //   25258: iconst_1
    //   25259: istore 4
    //   25261: goto -18109 -> 7152
    //   25264: iconst_1
    //   25265: istore_3
    //   25266: goto -18028 -> 7238
    //   25269: iconst_1
    //   25270: istore 4
    //   25272: goto -17953 -> 7319
    //   25275: iconst_1
    //   25276: istore_3
    //   25277: goto -17872 -> 7405
    //   25280: iconst_1
    //   25281: istore 4
    //   25283: goto -17797 -> 7486
    //   25286: iconst_1
    //   25287: istore_3
    //   25288: goto -17716 -> 7572
    //   25291: iconst_1
    //   25292: istore 4
    //   25294: goto -17641 -> 7653
    //   25297: iconst_1
    //   25298: istore_3
    //   25299: goto -17560 -> 7739
    //   25302: iconst_1
    //   25303: istore 4
    //   25305: goto -17485 -> 7820
    //   25308: iconst_1
    //   25309: istore_3
    //   25310: goto -17404 -> 7906
    //   25313: iconst_1
    //   25314: istore 4
    //   25316: goto -17329 -> 7987
    //   25319: iconst_1
    //   25320: istore_3
    //   25321: goto -17248 -> 8073
    //   25324: iconst_1
    //   25325: istore 4
    //   25327: goto -17173 -> 8154
    //   25330: iconst_1
    //   25331: istore_3
    //   25332: goto -17092 -> 8240
    //   25335: iconst_1
    //   25336: istore 4
    //   25338: goto -17017 -> 8321
    //   25341: iconst_1
    //   25342: istore_3
    //   25343: goto -16936 -> 8407
    //   25346: iconst_1
    //   25347: istore 4
    //   25349: goto -16861 -> 8488
    //   25352: iconst_1
    //   25353: istore_3
    //   25354: goto -16780 -> 8574
    //   25357: iconst_1
    //   25358: istore 4
    //   25360: goto -16705 -> 8655
    //   25363: iconst_1
    //   25364: istore_3
    //   25365: goto -16624 -> 8741
    //   25368: iconst_1
    //   25369: istore 12
    //   25371: goto -15270 -> 10101
    //   25374: iconst_1
    //   25375: istore 11
    //   25377: goto -15054 -> 10323
    //   25380: iconst_1
    //   25381: istore 12
    //   25383: goto -14838 -> 10545
    //   25386: iconst_1
    //   25387: istore 14
    //   25389: goto -14622 -> 10767
    //   25392: iconst_1
    //   25393: istore 10
    //   25395: goto -14406 -> 10989
    //   25398: iconst_1
    //   25399: istore 12
    //   25401: goto -14190 -> 11211
    //   25404: iconst_1
    //   25405: istore 13
    //   25407: goto -13974 -> 11433
    //   25410: iconst_1
    //   25411: istore 14
    //   25413: goto -13758 -> 11655
    //   25416: iconst_1
    //   25417: istore 8
    //   25419: goto -13542 -> 11877
    //   25422: iconst_1
    //   25423: istore 13
    //   25425: goto -13326 -> 12099
    //   25428: iconst_1
    //   25429: istore 11
    //   25431: goto -13110 -> 12321
    //   25434: iconst_1
    //   25435: istore 13
    //   25437: goto -12894 -> 12543
    //   25440: iconst_1
    //   25441: istore 10
    //   25443: goto -12678 -> 12765
    //   25446: iconst_1
    //   25447: istore 13
    //   25449: goto -12462 -> 12987
    //   25452: iconst_1
    //   25453: istore 14
    //   25455: goto -12246 -> 13209
    //   25458: iconst_1
    //   25459: istore 10
    //   25461: goto -12030 -> 13431
    //   25464: iconst_1
    //   25465: istore 13
    //   25467: goto -11814 -> 13653
    //   25470: iconst_1
    //   25471: istore 11
    //   25473: goto -11598 -> 13875
    //   25476: iconst_1
    //   25477: istore 13
    //   25479: goto -11382 -> 14097
    //   25482: iconst_1
    //   25483: istore 14
    //   25485: goto -11166 -> 14319
    //   25488: iconst_1
    //   25489: istore 11
    //   25491: goto -10950 -> 14541
    //   25494: iconst_1
    //   25495: istore 4
    //   25497: goto -9917 -> 15580
    //   25500: iconst_1
    //   25501: istore_3
    //   25502: goto -9836 -> 15666
    //   25505: iconst_1
    //   25506: istore 4
    //   25508: goto -9761 -> 15747
    //   25511: iconst_1
    //   25512: istore_3
    //   25513: goto -9680 -> 15833
    //   25516: iconst_1
    //   25517: istore 4
    //   25519: goto -9605 -> 15914
    //   25522: iconst_1
    //   25523: istore_3
    //   25524: goto -9524 -> 16000
    //   25527: iconst_1
    //   25528: istore 4
    //   25530: goto -9449 -> 16081
    //   25533: iconst_1
    //   25534: istore_3
    //   25535: goto -9368 -> 16167
    //   25538: astore 32
    //   25540: goto -16650 -> 8890
    //   25543: astore 32
    //   25545: goto -9213 -> 16332
    //   25548: iconst_1
    //   25549: istore 7
    //   25551: iconst_1
    //   25552: istore 4
    //   25554: goto -8338 -> 17216
    //   25557: iconst_1
    //   25558: istore 7
    //   25560: iconst_1
    //   25561: istore_3
    //   25562: goto -8230 -> 17332
    //   25565: iconst_1
    //   25566: istore 7
    //   25568: iconst_1
    //   25569: istore 4
    //   25571: goto -8129 -> 17442
    //   25574: iconst_1
    //   25575: istore 7
    //   25577: iconst_1
    //   25578: istore_3
    //   25579: goto -8021 -> 17558
    //   25582: iconst_1
    //   25583: istore 7
    //   25585: iconst_1
    //   25586: istore 4
    //   25588: goto -7920 -> 17668
    //   25591: iconst_1
    //   25592: istore 7
    //   25594: iconst_1
    //   25595: istore_3
    //   25596: goto -7812 -> 17784
    //   25599: iconst_1
    //   25600: istore 7
    //   25602: iconst_1
    //   25603: istore 4
    //   25605: goto -7711 -> 17894
    //   25608: iconst_1
    //   25609: istore 7
    //   25611: iconst_1
    //   25612: istore_3
    //   25613: goto -7603 -> 18010
    //   25616: iconst_1
    //   25617: istore 6
    //   25619: iconst_1
    //   25620: istore 4
    //   25622: goto -7502 -> 18120
    //   25625: iconst_1
    //   25626: istore 6
    //   25628: iconst_1
    //   25629: istore_3
    //   25630: goto -7394 -> 18236
    //   25633: iconst_1
    //   25634: istore 5
    //   25636: iconst_1
    //   25637: istore 4
    //   25639: goto -7293 -> 18346
    //   25642: iconst_1
    //   25643: istore 5
    //   25645: iconst_1
    //   25646: istore_3
    //   25647: goto -7185 -> 18462
    //   25650: iconst_1
    //   25651: istore 5
    //   25653: iconst_1
    //   25654: istore 4
    //   25656: goto -7084 -> 18572
    //   25659: iconst_1
    //   25660: istore 5
    //   25662: iconst_1
    //   25663: istore_3
    //   25664: goto -6976 -> 18688
    //   25667: iconst_1
    //   25668: istore 5
    //   25670: iconst_1
    //   25671: istore 4
    //   25673: goto -6875 -> 18798
    //   25676: iconst_1
    //   25677: istore 5
    //   25679: iconst_1
    //   25680: istore_3
    //   25681: iload 28
    //   25683: ifeq +25 -> 25708
    //   25686: iload 26
    //   25688: iconst_0
    //   25689: iand
    //   25690: ifeq +18 -> 25708
    //   25693: iload 7
    //   25695: ifeq +13 -> 25708
    //   25698: iload 6
    //   25700: ifeq +8 -> 25708
    //   25703: iload 5
    //   25705: ifne +42 -> 25747
    //   25708: iload 28
    //   25710: ifeq +22 -> 25732
    //   25713: iload 26
    //   25715: ifne +17 -> 25732
    //   25718: iconst_0
    //   25719: ifeq +13 -> 25732
    //   25722: iload 7
    //   25724: ifeq +8 -> 25732
    //   25727: iload 6
    //   25729: ifne +18 -> 25747
    //   25732: iload 28
    //   25734: ifne -6820 -> 18914
    //   25737: iload 26
    //   25739: ifeq -6825 -> 18914
    //   25742: iload 5
    //   25744: ifeq -6830 -> 18914
    //   25747: iconst_1
    //   25748: istore 4
    //   25750: goto -9099 -> 16651
    //   25753: astore_0
    //   25754: goto -5169 -> 20585
    //   25757: astore_0
    //   25758: goto -5018 -> 20740
    //   25761: iconst_1
    //   25762: istore 7
    //   25764: iconst_1
    //   25765: istore 4
    //   25767: goto -4251 -> 21516
    //   25770: iconst_1
    //   25771: istore 7
    //   25773: iconst_1
    //   25774: istore_3
    //   25775: goto -4173 -> 21602
    //   25778: iconst_1
    //   25779: istore 5
    //   25781: iconst_1
    //   25782: istore 4
    //   25784: goto -4101 -> 21683
    //   25787: iconst_1
    //   25788: istore 5
    //   25790: iconst_1
    //   25791: istore_3
    //   25792: goto -4023 -> 21769
    //   25795: iconst_1
    //   25796: istore 5
    //   25798: iconst_1
    //   25799: istore 4
    //   25801: goto -3951 -> 21850
    //   25804: iconst_1
    //   25805: istore 9
    //   25807: iconst_1
    //   25808: istore_3
    //   25809: goto -3873 -> 21936
    //   25812: iconst_1
    //   25813: istore 6
    //   25815: iconst_1
    //   25816: istore 4
    //   25818: goto -3801 -> 22017
    //   25821: iconst_1
    //   25822: istore 6
    //   25824: iconst_1
    //   25825: istore_3
    //   25826: goto -3723 -> 22103
    //   25829: iconst_1
    //   25830: istore 6
    //   25832: iconst_1
    //   25833: istore 4
    //   25835: goto -3651 -> 22184
    //   25838: iconst_1
    //   25839: istore 7
    //   25841: iconst_1
    //   25842: istore_3
    //   25843: goto -3573 -> 22270
    //   25846: iconst_1
    //   25847: istore 7
    //   25849: iconst_1
    //   25850: istore 4
    //   25852: goto -3501 -> 22351
    //   25855: iconst_1
    //   25856: istore 7
    //   25858: iconst_1
    //   25859: istore_3
    //   25860: goto -3423 -> 22437
    //   25863: iconst_1
    //   25864: istore 7
    //   25866: iconst_1
    //   25867: istore 4
    //   25869: goto -3351 -> 22518
    //   25872: iconst_1
    //   25873: istore 7
    //   25875: iconst_1
    //   25876: istore_3
    //   25877: goto -3273 -> 22604
    //   25880: iconst_1
    //   25881: istore 7
    //   25883: iconst_1
    //   25884: istore 4
    //   25886: goto -3201 -> 22685
    //   25889: iconst_1
    //   25890: istore 7
    //   25892: iconst_1
    //   25893: istore_3
    //   25894: goto -3123 -> 22771
    //   25897: iconst_1
    //   25898: istore 5
    //   25900: iconst_1
    //   25901: istore 4
    //   25903: goto -3051 -> 22852
    //   25906: iconst_1
    //   25907: istore 5
    //   25909: iconst_1
    //   25910: istore_3
    //   25911: goto -2973 -> 22938
    //   25914: iconst_1
    //   25915: istore 8
    //   25917: iconst_1
    //   25918: istore 4
    //   25920: goto -2897 -> 23023
    //   25923: iconst_1
    //   25924: istore 8
    //   25926: iconst_1
    //   25927: istore 5
    //   25929: goto -2819 -> 23110
    //   25932: iconst_1
    //   25933: istore 8
    //   25935: iconst_1
    //   25936: istore_3
    //   25937: iload 25
    //   25939: ifeq -2743 -> 23196
    //   25942: iload 7
    //   25944: ifeq -2748 -> 23196
    //   25947: iload 8
    //   25949: ifeq -2753 -> 23196
    //   25952: iload 9
    //   25954: ifeq -2758 -> 23196
    //   25957: iconst_0
    //   25958: ifeq -2762 -> 23196
    //   25961: iconst_0
    //   25962: ifeq -2766 -> 23196
    //   25965: iload_3
    //   25966: istore 4
    //   25968: iload 6
    //   25970: ifne -4895 -> 21075
    //   25973: goto -2777 -> 23196
    //   25976: goto -1745 -> 24231
    //   25979: goto -1661 -> 24318
    //   25982: goto -1577 -> 24405
    //   25985: goto -1493 -> 24492
    //   25988: goto -1409 -> 24579
    //   25991: goto -1325 -> 24666
    //   25994: goto -1241 -> 24753
    //   25997: goto -1157 -> 24840
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	26000	0	paramArrayOfString	String[]
    //   1265	23494	1	b	byte
    //   300	24550	2	i	int
    //   302	25664	3	j	int
    //   1070	24897	4	k	int
    //   1176	24752	5	m	int
    //   859	25110	6	n	int
    //   868	25075	7	i1	int
    //   865	25083	8	i2	int
    //   946	25007	9	i3	int
    //   953	24507	10	i4	int
    //   862	24628	11	i5	int
    //   1172	24228	12	i6	int
    //   1180	24298	13	i7	int
    //   1150	24334	14	i8	int
    //   1146	24043	15	i9	int
    //   1142	24008	16	i10	int
    //   1138	24030	17	i11	int
    //   939	24304	18	i12	int
    //   930	24235	19	i13	int
    //   933	24247	20	i14	int
    //   936	24262	21	i15	int
    //   421	8484	22	i16	int
    //   1227	5083	23	i17	int
    //   17	20873	24	bool1	boolean
    //   186	25752	25	bool2	boolean
    //   11	25727	26	bool3	boolean
    //   14	472	27	bool4	boolean
    //   182	25551	28	bool5	boolean
    //   305	185	29	bool6	boolean
    //   6867	17992	30	l	long
    //   560	328	32	localObject1	Object
    //   6004	251	32	localException1	Exception
    //   6616	2264	32	localObject2	Object
    //   8888	1	32	localFileNotFoundException1	java.io.FileNotFoundException
    //   8921	7398	32	localObject3	Object
    //   16330	3542	32	localException2	Exception
    //   19877	398	32	localObject4	Object
    //   20407	3	32	localIOException1	java.io.IOException
    //   20554	3397	32	localObject5	Object
    //   23961	3	32	localException3	Exception
    //   23971	3	32	localException4	Exception
    //   24028	1042	32	localFile	File
    //   25538	1	32	localFileNotFoundException2	java.io.FileNotFoundException
    //   25543	1	32	localException5	Exception
    //   897	5060	33	localObject6	Object
    //   5980	3	33	localIOException2	java.io.IOException
    //   6762	12823	33	localObject7	Object
    //   19595	106	33	localException6	Exception
    //   19873	407	33	localObject8	Object
    //   20345	33	33	localException7	Exception
    //   20618	4454	33	localObject9	Object
    //   6317	33	34	localException8	Exception
    //   6823	14114	34	localObject10	Object
    //   8926	647	35	localObject11	Object
    //   16619	19	35	localException9	Exception
    //   16713	101	35	str1	String
    //   18930	19	35	localException10	Exception
    //   18965	911	35	localException11	Exception
    //   20071	42	35	localObject12	Object
    //   20987	24	35	localException12	Exception
    //   21146	101	35	str2	String
    //   23216	19	35	localException13	Exception
    //   23251	3	35	localException14	Exception
    //   24053	935	35	localFileChannel	java.nio.channels.FileChannel
    //   8947	12282	36	localObject13	Object
    //   24863	27	36	localException15	Exception
    //   536	20441	37	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   955	972	5980	java/io/IOException
    //   986	1005	5980	java/io/IOException
    //   1019	1029	5980	java/io/IOException
    //   1043	1072	5980	java/io/IOException
    //   1086	1113	5980	java/io/IOException
    //   1127	1136	5980	java/io/IOException
    //   1182	1191	5980	java/io/IOException
    //   1221	1229	5980	java/io/IOException
    //   1259	1266	5980	java/io/IOException
    //   1308	1331	5980	java/io/IOException
    //   1361	1373	5980	java/io/IOException
    //   1403	1430	5980	java/io/IOException
    //   1460	1469	5980	java/io/IOException
    //   1499	1511	5980	java/io/IOException
    //   1541	1550	5980	java/io/IOException
    //   1587	1610	5980	java/io/IOException
    //   1640	1652	5980	java/io/IOException
    //   1682	1709	5980	java/io/IOException
    //   1739	1748	5980	java/io/IOException
    //   1778	1790	5980	java/io/IOException
    //   1820	1829	5980	java/io/IOException
    //   1870	1893	5980	java/io/IOException
    //   1923	1935	5980	java/io/IOException
    //   1965	1992	5980	java/io/IOException
    //   2022	2031	5980	java/io/IOException
    //   2061	2073	5980	java/io/IOException
    //   2103	2112	5980	java/io/IOException
    //   2149	2172	5980	java/io/IOException
    //   2202	2214	5980	java/io/IOException
    //   2244	2271	5980	java/io/IOException
    //   2301	2310	5980	java/io/IOException
    //   2340	2352	5980	java/io/IOException
    //   2382	2391	5980	java/io/IOException
    //   2428	2451	5980	java/io/IOException
    //   2481	2493	5980	java/io/IOException
    //   2523	2550	5980	java/io/IOException
    //   2580	2589	5980	java/io/IOException
    //   2619	2631	5980	java/io/IOException
    //   2661	2670	5980	java/io/IOException
    //   2707	2730	5980	java/io/IOException
    //   2760	2772	5980	java/io/IOException
    //   2802	2829	5980	java/io/IOException
    //   2859	2868	5980	java/io/IOException
    //   2898	2910	5980	java/io/IOException
    //   2940	2949	5980	java/io/IOException
    //   2990	3013	5980	java/io/IOException
    //   3043	3055	5980	java/io/IOException
    //   3085	3112	5980	java/io/IOException
    //   3142	3151	5980	java/io/IOException
    //   3181	3193	5980	java/io/IOException
    //   3223	3232	5980	java/io/IOException
    //   3273	3296	5980	java/io/IOException
    //   3326	3338	5980	java/io/IOException
    //   3368	3395	5980	java/io/IOException
    //   3425	3434	5980	java/io/IOException
    //   3464	3476	5980	java/io/IOException
    //   3506	3515	5980	java/io/IOException
    //   3552	3575	5980	java/io/IOException
    //   3605	3617	5980	java/io/IOException
    //   3647	3656	5980	java/io/IOException
    //   3686	3713	5980	java/io/IOException
    //   3743	3755	5980	java/io/IOException
    //   3785	3794	5980	java/io/IOException
    //   3835	3858	5980	java/io/IOException
    //   3888	3900	5980	java/io/IOException
    //   3930	3939	5980	java/io/IOException
    //   3969	3996	5980	java/io/IOException
    //   4026	4038	5980	java/io/IOException
    //   4068	4077	5980	java/io/IOException
    //   4114	4137	5980	java/io/IOException
    //   4167	4179	5980	java/io/IOException
    //   4209	4218	5980	java/io/IOException
    //   4248	4275	5980	java/io/IOException
    //   4305	4317	5980	java/io/IOException
    //   4347	4356	5980	java/io/IOException
    //   4393	4416	5980	java/io/IOException
    //   4446	4458	5980	java/io/IOException
    //   4488	4497	5980	java/io/IOException
    //   4527	4554	5980	java/io/IOException
    //   4584	4596	5980	java/io/IOException
    //   4626	4635	5980	java/io/IOException
    //   4672	4695	5980	java/io/IOException
    //   4725	4737	5980	java/io/IOException
    //   4767	4776	5980	java/io/IOException
    //   4806	4833	5980	java/io/IOException
    //   4863	4875	5980	java/io/IOException
    //   4905	4914	5980	java/io/IOException
    //   4951	4974	5980	java/io/IOException
    //   5004	5016	5980	java/io/IOException
    //   5046	5055	5980	java/io/IOException
    //   5085	5112	5980	java/io/IOException
    //   5142	5154	5980	java/io/IOException
    //   5184	5193	5980	java/io/IOException
    //   5230	5253	5980	java/io/IOException
    //   5283	5295	5980	java/io/IOException
    //   5325	5334	5980	java/io/IOException
    //   5364	5391	5980	java/io/IOException
    //   5421	5433	5980	java/io/IOException
    //   5463	5472	5980	java/io/IOException
    //   5509	5532	5980	java/io/IOException
    //   5562	5574	5980	java/io/IOException
    //   5604	5613	5980	java/io/IOException
    //   5643	5670	5980	java/io/IOException
    //   5700	5712	5980	java/io/IOException
    //   5742	5751	5980	java/io/IOException
    //   5956	5961	5980	java/io/IOException
    //   6303	6314	5980	java/io/IOException
    //   6333	6360	5980	java/io/IOException
    //   19	64	6004	java/lang/Exception
    //   70	86	6004	java/lang/Exception
    //   1182	1191	6317	java/lang/Exception
    //   1221	1229	6317	java/lang/Exception
    //   1259	1266	6317	java/lang/Exception
    //   1308	1331	6317	java/lang/Exception
    //   1361	1373	6317	java/lang/Exception
    //   1403	1430	6317	java/lang/Exception
    //   1460	1469	6317	java/lang/Exception
    //   1499	1511	6317	java/lang/Exception
    //   1541	1550	6317	java/lang/Exception
    //   1587	1610	6317	java/lang/Exception
    //   1640	1652	6317	java/lang/Exception
    //   1682	1709	6317	java/lang/Exception
    //   1739	1748	6317	java/lang/Exception
    //   1778	1790	6317	java/lang/Exception
    //   1820	1829	6317	java/lang/Exception
    //   1870	1893	6317	java/lang/Exception
    //   1923	1935	6317	java/lang/Exception
    //   1965	1992	6317	java/lang/Exception
    //   2022	2031	6317	java/lang/Exception
    //   2061	2073	6317	java/lang/Exception
    //   2103	2112	6317	java/lang/Exception
    //   2149	2172	6317	java/lang/Exception
    //   2202	2214	6317	java/lang/Exception
    //   2244	2271	6317	java/lang/Exception
    //   2301	2310	6317	java/lang/Exception
    //   2340	2352	6317	java/lang/Exception
    //   2382	2391	6317	java/lang/Exception
    //   2428	2451	6317	java/lang/Exception
    //   2481	2493	6317	java/lang/Exception
    //   2523	2550	6317	java/lang/Exception
    //   2580	2589	6317	java/lang/Exception
    //   2619	2631	6317	java/lang/Exception
    //   2661	2670	6317	java/lang/Exception
    //   2707	2730	6317	java/lang/Exception
    //   2760	2772	6317	java/lang/Exception
    //   2802	2829	6317	java/lang/Exception
    //   2859	2868	6317	java/lang/Exception
    //   2898	2910	6317	java/lang/Exception
    //   2940	2949	6317	java/lang/Exception
    //   2990	3013	6317	java/lang/Exception
    //   3043	3055	6317	java/lang/Exception
    //   3085	3112	6317	java/lang/Exception
    //   3142	3151	6317	java/lang/Exception
    //   3181	3193	6317	java/lang/Exception
    //   3223	3232	6317	java/lang/Exception
    //   3273	3296	6317	java/lang/Exception
    //   3326	3338	6317	java/lang/Exception
    //   3368	3395	6317	java/lang/Exception
    //   3425	3434	6317	java/lang/Exception
    //   3464	3476	6317	java/lang/Exception
    //   3506	3515	6317	java/lang/Exception
    //   3552	3575	6317	java/lang/Exception
    //   3605	3617	6317	java/lang/Exception
    //   3647	3656	6317	java/lang/Exception
    //   3686	3713	6317	java/lang/Exception
    //   3743	3755	6317	java/lang/Exception
    //   3785	3794	6317	java/lang/Exception
    //   3835	3858	6317	java/lang/Exception
    //   3888	3900	6317	java/lang/Exception
    //   3930	3939	6317	java/lang/Exception
    //   3969	3996	6317	java/lang/Exception
    //   4026	4038	6317	java/lang/Exception
    //   4068	4077	6317	java/lang/Exception
    //   4114	4137	6317	java/lang/Exception
    //   4167	4179	6317	java/lang/Exception
    //   4209	4218	6317	java/lang/Exception
    //   4248	4275	6317	java/lang/Exception
    //   4305	4317	6317	java/lang/Exception
    //   4347	4356	6317	java/lang/Exception
    //   4393	4416	6317	java/lang/Exception
    //   4446	4458	6317	java/lang/Exception
    //   4488	4497	6317	java/lang/Exception
    //   4527	4554	6317	java/lang/Exception
    //   4584	4596	6317	java/lang/Exception
    //   4626	4635	6317	java/lang/Exception
    //   4672	4695	6317	java/lang/Exception
    //   4725	4737	6317	java/lang/Exception
    //   4767	4776	6317	java/lang/Exception
    //   4806	4833	6317	java/lang/Exception
    //   4863	4875	6317	java/lang/Exception
    //   4905	4914	6317	java/lang/Exception
    //   4951	4974	6317	java/lang/Exception
    //   5004	5016	6317	java/lang/Exception
    //   5046	5055	6317	java/lang/Exception
    //   5085	5112	6317	java/lang/Exception
    //   5142	5154	6317	java/lang/Exception
    //   5184	5193	6317	java/lang/Exception
    //   5230	5253	6317	java/lang/Exception
    //   5283	5295	6317	java/lang/Exception
    //   5325	5334	6317	java/lang/Exception
    //   5364	5391	6317	java/lang/Exception
    //   5421	5433	6317	java/lang/Exception
    //   5463	5472	6317	java/lang/Exception
    //   5509	5532	6317	java/lang/Exception
    //   5562	5574	6317	java/lang/Exception
    //   5604	5613	6317	java/lang/Exception
    //   5643	5670	6317	java/lang/Exception
    //   5700	5712	6317	java/lang/Exception
    //   5742	5751	6317	java/lang/Exception
    //   6303	6314	6317	java/lang/Exception
    //   6554	6590	8888	java/io/FileNotFoundException
    //   6590	6683	8888	java/io/FileNotFoundException
    //   6683	6719	8888	java/io/FileNotFoundException
    //   6719	6735	8888	java/io/FileNotFoundException
    //   6735	6742	8888	java/io/FileNotFoundException
    //   6742	6844	8888	java/io/FileNotFoundException
    //   6848	6861	8888	java/io/FileNotFoundException
    //   6876	6885	8888	java/io/FileNotFoundException
    //   6887	6895	8888	java/io/FileNotFoundException
    //   6897	6904	8888	java/io/FileNotFoundException
    //   6909	6932	8888	java/io/FileNotFoundException
    //   6934	6946	8888	java/io/FileNotFoundException
    //   6948	6957	8888	java/io/FileNotFoundException
    //   6959	6971	8888	java/io/FileNotFoundException
    //   6973	6982	8888	java/io/FileNotFoundException
    //   6991	7014	8888	java/io/FileNotFoundException
    //   7017	7029	8888	java/io/FileNotFoundException
    //   7032	7041	8888	java/io/FileNotFoundException
    //   7044	7056	8888	java/io/FileNotFoundException
    //   7059	7068	8888	java/io/FileNotFoundException
    //   7076	7099	8888	java/io/FileNotFoundException
    //   7101	7113	8888	java/io/FileNotFoundException
    //   7115	7124	8888	java/io/FileNotFoundException
    //   7126	7138	8888	java/io/FileNotFoundException
    //   7140	7149	8888	java/io/FileNotFoundException
    //   7158	7181	8888	java/io/FileNotFoundException
    //   7184	7196	8888	java/io/FileNotFoundException
    //   7199	7208	8888	java/io/FileNotFoundException
    //   7211	7223	8888	java/io/FileNotFoundException
    //   7226	7235	8888	java/io/FileNotFoundException
    //   7243	7266	8888	java/io/FileNotFoundException
    //   7268	7280	8888	java/io/FileNotFoundException
    //   7282	7291	8888	java/io/FileNotFoundException
    //   7293	7305	8888	java/io/FileNotFoundException
    //   7307	7316	8888	java/io/FileNotFoundException
    //   7325	7348	8888	java/io/FileNotFoundException
    //   7351	7363	8888	java/io/FileNotFoundException
    //   7366	7375	8888	java/io/FileNotFoundException
    //   7378	7390	8888	java/io/FileNotFoundException
    //   7393	7402	8888	java/io/FileNotFoundException
    //   7410	7433	8888	java/io/FileNotFoundException
    //   7435	7447	8888	java/io/FileNotFoundException
    //   7449	7458	8888	java/io/FileNotFoundException
    //   7460	7472	8888	java/io/FileNotFoundException
    //   7474	7483	8888	java/io/FileNotFoundException
    //   7492	7515	8888	java/io/FileNotFoundException
    //   7518	7530	8888	java/io/FileNotFoundException
    //   7533	7542	8888	java/io/FileNotFoundException
    //   7545	7557	8888	java/io/FileNotFoundException
    //   7560	7569	8888	java/io/FileNotFoundException
    //   7577	7600	8888	java/io/FileNotFoundException
    //   7602	7614	8888	java/io/FileNotFoundException
    //   7616	7625	8888	java/io/FileNotFoundException
    //   7627	7639	8888	java/io/FileNotFoundException
    //   7641	7650	8888	java/io/FileNotFoundException
    //   7659	7682	8888	java/io/FileNotFoundException
    //   7685	7697	8888	java/io/FileNotFoundException
    //   7700	7709	8888	java/io/FileNotFoundException
    //   7712	7724	8888	java/io/FileNotFoundException
    //   7727	7736	8888	java/io/FileNotFoundException
    //   7744	7767	8888	java/io/FileNotFoundException
    //   7769	7781	8888	java/io/FileNotFoundException
    //   7783	7792	8888	java/io/FileNotFoundException
    //   7794	7806	8888	java/io/FileNotFoundException
    //   7808	7817	8888	java/io/FileNotFoundException
    //   7826	7849	8888	java/io/FileNotFoundException
    //   7852	7864	8888	java/io/FileNotFoundException
    //   7867	7876	8888	java/io/FileNotFoundException
    //   7879	7891	8888	java/io/FileNotFoundException
    //   7894	7903	8888	java/io/FileNotFoundException
    //   7911	7934	8888	java/io/FileNotFoundException
    //   7936	7948	8888	java/io/FileNotFoundException
    //   7950	7959	8888	java/io/FileNotFoundException
    //   7961	7973	8888	java/io/FileNotFoundException
    //   7975	7984	8888	java/io/FileNotFoundException
    //   7993	8016	8888	java/io/FileNotFoundException
    //   8019	8031	8888	java/io/FileNotFoundException
    //   8034	8043	8888	java/io/FileNotFoundException
    //   8046	8058	8888	java/io/FileNotFoundException
    //   8061	8070	8888	java/io/FileNotFoundException
    //   8078	8101	8888	java/io/FileNotFoundException
    //   8103	8115	8888	java/io/FileNotFoundException
    //   8117	8126	8888	java/io/FileNotFoundException
    //   8128	8140	8888	java/io/FileNotFoundException
    //   8142	8151	8888	java/io/FileNotFoundException
    //   8160	8183	8888	java/io/FileNotFoundException
    //   8186	8198	8888	java/io/FileNotFoundException
    //   8201	8210	8888	java/io/FileNotFoundException
    //   8213	8225	8888	java/io/FileNotFoundException
    //   8228	8237	8888	java/io/FileNotFoundException
    //   8245	8268	8888	java/io/FileNotFoundException
    //   8270	8282	8888	java/io/FileNotFoundException
    //   8284	8293	8888	java/io/FileNotFoundException
    //   8295	8307	8888	java/io/FileNotFoundException
    //   8309	8318	8888	java/io/FileNotFoundException
    //   8327	8350	8888	java/io/FileNotFoundException
    //   8353	8365	8888	java/io/FileNotFoundException
    //   8368	8377	8888	java/io/FileNotFoundException
    //   8380	8392	8888	java/io/FileNotFoundException
    //   8395	8404	8888	java/io/FileNotFoundException
    //   8412	8435	8888	java/io/FileNotFoundException
    //   8437	8449	8888	java/io/FileNotFoundException
    //   8451	8460	8888	java/io/FileNotFoundException
    //   8462	8474	8888	java/io/FileNotFoundException
    //   8476	8485	8888	java/io/FileNotFoundException
    //   8494	8517	8888	java/io/FileNotFoundException
    //   8520	8532	8888	java/io/FileNotFoundException
    //   8535	8544	8888	java/io/FileNotFoundException
    //   8547	8559	8888	java/io/FileNotFoundException
    //   8562	8571	8888	java/io/FileNotFoundException
    //   8579	8602	8888	java/io/FileNotFoundException
    //   8604	8616	8888	java/io/FileNotFoundException
    //   8618	8627	8888	java/io/FileNotFoundException
    //   8629	8641	8888	java/io/FileNotFoundException
    //   8643	8652	8888	java/io/FileNotFoundException
    //   8661	8684	8888	java/io/FileNotFoundException
    //   8687	8699	8888	java/io/FileNotFoundException
    //   8702	8711	8888	java/io/FileNotFoundException
    //   8714	8726	8888	java/io/FileNotFoundException
    //   8729	8738	8888	java/io/FileNotFoundException
    //   8743	8754	8888	java/io/FileNotFoundException
    //   8763	8825	8888	java/io/FileNotFoundException
    //   8825	8885	8888	java/io/FileNotFoundException
    //   16189	16235	8888	java/io/FileNotFoundException
    //   16286	16298	8888	java/io/FileNotFoundException
    //   16621	16648	8888	java/io/FileNotFoundException
    //   16651	16691	8888	java/io/FileNotFoundException
    //   16696	16710	8888	java/io/FileNotFoundException
    //   16715	16791	8888	java/io/FileNotFoundException
    //   16791	16822	8888	java/io/FileNotFoundException
    //   16822	16850	8888	java/io/FileNotFoundException
    //   16850	16856	8888	java/io/FileNotFoundException
    //   16861	16902	8888	java/io/FileNotFoundException
    //   16902	16943	8888	java/io/FileNotFoundException
    //   16943	16957	8888	java/io/FileNotFoundException
    //   16962	16989	8888	java/io/FileNotFoundException
    //   17001	17073	8888	java/io/FileNotFoundException
    //   17078	17087	8888	java/io/FileNotFoundException
    //   17089	17097	8888	java/io/FileNotFoundException
    //   17099	17106	8888	java/io/FileNotFoundException
    //   17111	17134	8888	java/io/FileNotFoundException
    //   17136	17148	8888	java/io/FileNotFoundException
    //   17150	17177	8888	java/io/FileNotFoundException
    //   17179	17188	8888	java/io/FileNotFoundException
    //   17190	17202	8888	java/io/FileNotFoundException
    //   17204	17213	8888	java/io/FileNotFoundException
    //   17222	17245	8888	java/io/FileNotFoundException
    //   17248	17260	8888	java/io/FileNotFoundException
    //   17263	17290	8888	java/io/FileNotFoundException
    //   17293	17302	8888	java/io/FileNotFoundException
    //   17305	17317	8888	java/io/FileNotFoundException
    //   17320	17329	8888	java/io/FileNotFoundException
    //   17337	17360	8888	java/io/FileNotFoundException
    //   17362	17374	8888	java/io/FileNotFoundException
    //   17376	17403	8888	java/io/FileNotFoundException
    //   17405	17414	8888	java/io/FileNotFoundException
    //   17416	17428	8888	java/io/FileNotFoundException
    //   17430	17439	8888	java/io/FileNotFoundException
    //   17448	17471	8888	java/io/FileNotFoundException
    //   17474	17486	8888	java/io/FileNotFoundException
    //   17489	17516	8888	java/io/FileNotFoundException
    //   17519	17528	8888	java/io/FileNotFoundException
    //   17531	17543	8888	java/io/FileNotFoundException
    //   17546	17555	8888	java/io/FileNotFoundException
    //   17563	17586	8888	java/io/FileNotFoundException
    //   17588	17600	8888	java/io/FileNotFoundException
    //   17602	17629	8888	java/io/FileNotFoundException
    //   17631	17640	8888	java/io/FileNotFoundException
    //   17642	17654	8888	java/io/FileNotFoundException
    //   17656	17665	8888	java/io/FileNotFoundException
    //   17674	17697	8888	java/io/FileNotFoundException
    //   17700	17712	8888	java/io/FileNotFoundException
    //   17715	17742	8888	java/io/FileNotFoundException
    //   17745	17754	8888	java/io/FileNotFoundException
    //   17757	17769	8888	java/io/FileNotFoundException
    //   17772	17781	8888	java/io/FileNotFoundException
    //   17789	17812	8888	java/io/FileNotFoundException
    //   17814	17826	8888	java/io/FileNotFoundException
    //   17828	17855	8888	java/io/FileNotFoundException
    //   17857	17866	8888	java/io/FileNotFoundException
    //   17868	17880	8888	java/io/FileNotFoundException
    //   17882	17891	8888	java/io/FileNotFoundException
    //   17900	17923	8888	java/io/FileNotFoundException
    //   17926	17938	8888	java/io/FileNotFoundException
    //   17941	17968	8888	java/io/FileNotFoundException
    //   17971	17980	8888	java/io/FileNotFoundException
    //   17983	17995	8888	java/io/FileNotFoundException
    //   17998	18007	8888	java/io/FileNotFoundException
    //   18015	18038	8888	java/io/FileNotFoundException
    //   18040	18052	8888	java/io/FileNotFoundException
    //   18054	18063	8888	java/io/FileNotFoundException
    //   18065	18092	8888	java/io/FileNotFoundException
    //   18094	18106	8888	java/io/FileNotFoundException
    //   18108	18117	8888	java/io/FileNotFoundException
    //   18126	18149	8888	java/io/FileNotFoundException
    //   18152	18164	8888	java/io/FileNotFoundException
    //   18167	18176	8888	java/io/FileNotFoundException
    //   18179	18206	8888	java/io/FileNotFoundException
    //   18209	18221	8888	java/io/FileNotFoundException
    //   18224	18233	8888	java/io/FileNotFoundException
    //   18241	18264	8888	java/io/FileNotFoundException
    //   18266	18278	8888	java/io/FileNotFoundException
    //   18280	18289	8888	java/io/FileNotFoundException
    //   18291	18318	8888	java/io/FileNotFoundException
    //   18320	18332	8888	java/io/FileNotFoundException
    //   18334	18343	8888	java/io/FileNotFoundException
    //   18352	18375	8888	java/io/FileNotFoundException
    //   18378	18390	8888	java/io/FileNotFoundException
    //   18393	18402	8888	java/io/FileNotFoundException
    //   18405	18432	8888	java/io/FileNotFoundException
    //   18435	18447	8888	java/io/FileNotFoundException
    //   18450	18459	8888	java/io/FileNotFoundException
    //   18467	18490	8888	java/io/FileNotFoundException
    //   18492	18504	8888	java/io/FileNotFoundException
    //   18506	18515	8888	java/io/FileNotFoundException
    //   18517	18544	8888	java/io/FileNotFoundException
    //   18546	18558	8888	java/io/FileNotFoundException
    //   18560	18569	8888	java/io/FileNotFoundException
    //   18578	18601	8888	java/io/FileNotFoundException
    //   18604	18616	8888	java/io/FileNotFoundException
    //   18619	18628	8888	java/io/FileNotFoundException
    //   18631	18658	8888	java/io/FileNotFoundException
    //   18661	18673	8888	java/io/FileNotFoundException
    //   18676	18685	8888	java/io/FileNotFoundException
    //   18693	18716	8888	java/io/FileNotFoundException
    //   18718	18730	8888	java/io/FileNotFoundException
    //   18732	18741	8888	java/io/FileNotFoundException
    //   18743	18770	8888	java/io/FileNotFoundException
    //   18772	18784	8888	java/io/FileNotFoundException
    //   18786	18795	8888	java/io/FileNotFoundException
    //   18804	18827	8888	java/io/FileNotFoundException
    //   18830	18842	8888	java/io/FileNotFoundException
    //   18845	18854	8888	java/io/FileNotFoundException
    //   18857	18884	8888	java/io/FileNotFoundException
    //   18887	18899	8888	java/io/FileNotFoundException
    //   18902	18911	8888	java/io/FileNotFoundException
    //   18916	18927	8888	java/io/FileNotFoundException
    //   18932	18959	8888	java/io/FileNotFoundException
    //   18967	18985	8888	java/io/FileNotFoundException
    //   18988	18992	8888	java/io/FileNotFoundException
    //   18995	19014	8888	java/io/FileNotFoundException
    //   19014	19040	8888	java/io/FileNotFoundException
    //   19045	19128	8888	java/io/FileNotFoundException
    //   19128	19272	8888	java/io/FileNotFoundException
    //   19272	19337	8888	java/io/FileNotFoundException
    //   19337	19420	8888	java/io/FileNotFoundException
    //   19425	19460	8888	java/io/FileNotFoundException
    //   19460	19572	8888	java/io/FileNotFoundException
    //   19572	19581	8888	java/io/FileNotFoundException
    //   19584	19592	8888	java/io/FileNotFoundException
    //   19597	19625	8888	java/io/FileNotFoundException
    //   19628	19651	8888	java/io/FileNotFoundException
    //   19654	19674	8888	java/io/FileNotFoundException
    //   19679	19791	8888	java/io/FileNotFoundException
    //   19791	19816	8888	java/io/FileNotFoundException
    //   19816	19841	8888	java/io/FileNotFoundException
    //   19844	19868	8888	java/io/FileNotFoundException
    //   16243	16251	16330	java/lang/Exception
    //   16259	16267	16330	java/lang/Exception
    //   16275	16283	16330	java/lang/Exception
    //   16306	16314	16330	java/lang/Exception
    //   16322	16330	16330	java/lang/Exception
    //   16373	16387	16330	java/lang/Exception
    //   16395	16407	16330	java/lang/Exception
    //   16415	16423	16330	java/lang/Exception
    //   16431	16441	16330	java/lang/Exception
    //   16449	16455	16330	java/lang/Exception
    //   16463	16471	16330	java/lang/Exception
    //   16479	16493	16330	java/lang/Exception
    //   16501	16509	16330	java/lang/Exception
    //   16517	16529	16330	java/lang/Exception
    //   16537	16549	16330	java/lang/Exception
    //   16557	16565	16330	java/lang/Exception
    //   16573	16583	16330	java/lang/Exception
    //   16591	16597	16330	java/lang/Exception
    //   16608	16616	16330	java/lang/Exception
    //   6876	6885	16619	java/lang/Exception
    //   6887	6895	16619	java/lang/Exception
    //   6897	6904	16619	java/lang/Exception
    //   6909	6932	16619	java/lang/Exception
    //   6934	6946	16619	java/lang/Exception
    //   6948	6957	16619	java/lang/Exception
    //   6959	6971	16619	java/lang/Exception
    //   6973	6982	16619	java/lang/Exception
    //   6991	7014	16619	java/lang/Exception
    //   7017	7029	16619	java/lang/Exception
    //   7032	7041	16619	java/lang/Exception
    //   7044	7056	16619	java/lang/Exception
    //   7059	7068	16619	java/lang/Exception
    //   7076	7099	16619	java/lang/Exception
    //   7101	7113	16619	java/lang/Exception
    //   7115	7124	16619	java/lang/Exception
    //   7126	7138	16619	java/lang/Exception
    //   7140	7149	16619	java/lang/Exception
    //   7158	7181	16619	java/lang/Exception
    //   7184	7196	16619	java/lang/Exception
    //   7199	7208	16619	java/lang/Exception
    //   7211	7223	16619	java/lang/Exception
    //   7226	7235	16619	java/lang/Exception
    //   7243	7266	16619	java/lang/Exception
    //   7268	7280	16619	java/lang/Exception
    //   7282	7291	16619	java/lang/Exception
    //   7293	7305	16619	java/lang/Exception
    //   7307	7316	16619	java/lang/Exception
    //   7325	7348	16619	java/lang/Exception
    //   7351	7363	16619	java/lang/Exception
    //   7366	7375	16619	java/lang/Exception
    //   7378	7390	16619	java/lang/Exception
    //   7393	7402	16619	java/lang/Exception
    //   7410	7433	16619	java/lang/Exception
    //   7435	7447	16619	java/lang/Exception
    //   7449	7458	16619	java/lang/Exception
    //   7460	7472	16619	java/lang/Exception
    //   7474	7483	16619	java/lang/Exception
    //   7492	7515	16619	java/lang/Exception
    //   7518	7530	16619	java/lang/Exception
    //   7533	7542	16619	java/lang/Exception
    //   7545	7557	16619	java/lang/Exception
    //   7560	7569	16619	java/lang/Exception
    //   7577	7600	16619	java/lang/Exception
    //   7602	7614	16619	java/lang/Exception
    //   7616	7625	16619	java/lang/Exception
    //   7627	7639	16619	java/lang/Exception
    //   7641	7650	16619	java/lang/Exception
    //   7659	7682	16619	java/lang/Exception
    //   7685	7697	16619	java/lang/Exception
    //   7700	7709	16619	java/lang/Exception
    //   7712	7724	16619	java/lang/Exception
    //   7727	7736	16619	java/lang/Exception
    //   7744	7767	16619	java/lang/Exception
    //   7769	7781	16619	java/lang/Exception
    //   7783	7792	16619	java/lang/Exception
    //   7794	7806	16619	java/lang/Exception
    //   7808	7817	16619	java/lang/Exception
    //   7826	7849	16619	java/lang/Exception
    //   7852	7864	16619	java/lang/Exception
    //   7867	7876	16619	java/lang/Exception
    //   7879	7891	16619	java/lang/Exception
    //   7894	7903	16619	java/lang/Exception
    //   7911	7934	16619	java/lang/Exception
    //   7936	7948	16619	java/lang/Exception
    //   7950	7959	16619	java/lang/Exception
    //   7961	7973	16619	java/lang/Exception
    //   7975	7984	16619	java/lang/Exception
    //   7993	8016	16619	java/lang/Exception
    //   8019	8031	16619	java/lang/Exception
    //   8034	8043	16619	java/lang/Exception
    //   8046	8058	16619	java/lang/Exception
    //   8061	8070	16619	java/lang/Exception
    //   8078	8101	16619	java/lang/Exception
    //   8103	8115	16619	java/lang/Exception
    //   8117	8126	16619	java/lang/Exception
    //   8128	8140	16619	java/lang/Exception
    //   8142	8151	16619	java/lang/Exception
    //   8160	8183	16619	java/lang/Exception
    //   8186	8198	16619	java/lang/Exception
    //   8201	8210	16619	java/lang/Exception
    //   8213	8225	16619	java/lang/Exception
    //   8228	8237	16619	java/lang/Exception
    //   8245	8268	16619	java/lang/Exception
    //   8270	8282	16619	java/lang/Exception
    //   8284	8293	16619	java/lang/Exception
    //   8295	8307	16619	java/lang/Exception
    //   8309	8318	16619	java/lang/Exception
    //   8327	8350	16619	java/lang/Exception
    //   8353	8365	16619	java/lang/Exception
    //   8368	8377	16619	java/lang/Exception
    //   8380	8392	16619	java/lang/Exception
    //   8395	8404	16619	java/lang/Exception
    //   8412	8435	16619	java/lang/Exception
    //   8437	8449	16619	java/lang/Exception
    //   8451	8460	16619	java/lang/Exception
    //   8462	8474	16619	java/lang/Exception
    //   8476	8485	16619	java/lang/Exception
    //   8494	8517	16619	java/lang/Exception
    //   8520	8532	16619	java/lang/Exception
    //   8535	8544	16619	java/lang/Exception
    //   8547	8559	16619	java/lang/Exception
    //   8562	8571	16619	java/lang/Exception
    //   8579	8602	16619	java/lang/Exception
    //   8604	8616	16619	java/lang/Exception
    //   8618	8627	16619	java/lang/Exception
    //   8629	8641	16619	java/lang/Exception
    //   8643	8652	16619	java/lang/Exception
    //   8661	8684	16619	java/lang/Exception
    //   8687	8699	16619	java/lang/Exception
    //   8702	8711	16619	java/lang/Exception
    //   8714	8726	16619	java/lang/Exception
    //   8729	8738	16619	java/lang/Exception
    //   8743	8754	16619	java/lang/Exception
    //   17078	17087	18930	java/lang/Exception
    //   17089	17097	18930	java/lang/Exception
    //   17099	17106	18930	java/lang/Exception
    //   17111	17134	18930	java/lang/Exception
    //   17136	17148	18930	java/lang/Exception
    //   17150	17177	18930	java/lang/Exception
    //   17179	17188	18930	java/lang/Exception
    //   17190	17202	18930	java/lang/Exception
    //   17204	17213	18930	java/lang/Exception
    //   17222	17245	18930	java/lang/Exception
    //   17248	17260	18930	java/lang/Exception
    //   17263	17290	18930	java/lang/Exception
    //   17293	17302	18930	java/lang/Exception
    //   17305	17317	18930	java/lang/Exception
    //   17320	17329	18930	java/lang/Exception
    //   17337	17360	18930	java/lang/Exception
    //   17362	17374	18930	java/lang/Exception
    //   17376	17403	18930	java/lang/Exception
    //   17405	17414	18930	java/lang/Exception
    //   17416	17428	18930	java/lang/Exception
    //   17430	17439	18930	java/lang/Exception
    //   17448	17471	18930	java/lang/Exception
    //   17474	17486	18930	java/lang/Exception
    //   17489	17516	18930	java/lang/Exception
    //   17519	17528	18930	java/lang/Exception
    //   17531	17543	18930	java/lang/Exception
    //   17546	17555	18930	java/lang/Exception
    //   17563	17586	18930	java/lang/Exception
    //   17588	17600	18930	java/lang/Exception
    //   17602	17629	18930	java/lang/Exception
    //   17631	17640	18930	java/lang/Exception
    //   17642	17654	18930	java/lang/Exception
    //   17656	17665	18930	java/lang/Exception
    //   17674	17697	18930	java/lang/Exception
    //   17700	17712	18930	java/lang/Exception
    //   17715	17742	18930	java/lang/Exception
    //   17745	17754	18930	java/lang/Exception
    //   17757	17769	18930	java/lang/Exception
    //   17772	17781	18930	java/lang/Exception
    //   17789	17812	18930	java/lang/Exception
    //   17814	17826	18930	java/lang/Exception
    //   17828	17855	18930	java/lang/Exception
    //   17857	17866	18930	java/lang/Exception
    //   17868	17880	18930	java/lang/Exception
    //   17882	17891	18930	java/lang/Exception
    //   17900	17923	18930	java/lang/Exception
    //   17926	17938	18930	java/lang/Exception
    //   17941	17968	18930	java/lang/Exception
    //   17971	17980	18930	java/lang/Exception
    //   17983	17995	18930	java/lang/Exception
    //   17998	18007	18930	java/lang/Exception
    //   18015	18038	18930	java/lang/Exception
    //   18040	18052	18930	java/lang/Exception
    //   18054	18063	18930	java/lang/Exception
    //   18065	18092	18930	java/lang/Exception
    //   18094	18106	18930	java/lang/Exception
    //   18108	18117	18930	java/lang/Exception
    //   18126	18149	18930	java/lang/Exception
    //   18152	18164	18930	java/lang/Exception
    //   18167	18176	18930	java/lang/Exception
    //   18179	18206	18930	java/lang/Exception
    //   18209	18221	18930	java/lang/Exception
    //   18224	18233	18930	java/lang/Exception
    //   18241	18264	18930	java/lang/Exception
    //   18266	18278	18930	java/lang/Exception
    //   18280	18289	18930	java/lang/Exception
    //   18291	18318	18930	java/lang/Exception
    //   18320	18332	18930	java/lang/Exception
    //   18334	18343	18930	java/lang/Exception
    //   18352	18375	18930	java/lang/Exception
    //   18378	18390	18930	java/lang/Exception
    //   18393	18402	18930	java/lang/Exception
    //   18405	18432	18930	java/lang/Exception
    //   18435	18447	18930	java/lang/Exception
    //   18450	18459	18930	java/lang/Exception
    //   18467	18490	18930	java/lang/Exception
    //   18492	18504	18930	java/lang/Exception
    //   18506	18515	18930	java/lang/Exception
    //   18517	18544	18930	java/lang/Exception
    //   18546	18558	18930	java/lang/Exception
    //   18560	18569	18930	java/lang/Exception
    //   18578	18601	18930	java/lang/Exception
    //   18604	18616	18930	java/lang/Exception
    //   18619	18628	18930	java/lang/Exception
    //   18631	18658	18930	java/lang/Exception
    //   18661	18673	18930	java/lang/Exception
    //   18676	18685	18930	java/lang/Exception
    //   18693	18716	18930	java/lang/Exception
    //   18718	18730	18930	java/lang/Exception
    //   18732	18741	18930	java/lang/Exception
    //   18743	18770	18930	java/lang/Exception
    //   18772	18784	18930	java/lang/Exception
    //   18786	18795	18930	java/lang/Exception
    //   18804	18827	18930	java/lang/Exception
    //   18830	18842	18930	java/lang/Exception
    //   18845	18854	18930	java/lang/Exception
    //   18857	18884	18930	java/lang/Exception
    //   18887	18899	18930	java/lang/Exception
    //   18902	18911	18930	java/lang/Exception
    //   18916	18927	18930	java/lang/Exception
    //   16791	16822	18965	java/lang/Exception
    //   19128	19272	19595	java/lang/Exception
    //   19272	19337	19595	java/lang/Exception
    //   19337	19420	19595	java/lang/Exception
    //   19425	19460	19595	java/lang/Exception
    //   19460	19572	19595	java/lang/Exception
    //   9795	9804	20345	java/lang/Exception
    //   9834	9842	20345	java/lang/Exception
    //   9872	9879	20345	java/lang/Exception
    //   9913	9936	20345	java/lang/Exception
    //   9966	9978	20345	java/lang/Exception
    //   10008	10017	20345	java/lang/Exception
    //   10047	10059	20345	java/lang/Exception
    //   10089	10098	20345	java/lang/Exception
    //   10135	10158	20345	java/lang/Exception
    //   10188	10200	20345	java/lang/Exception
    //   10230	10239	20345	java/lang/Exception
    //   10269	10281	20345	java/lang/Exception
    //   10311	10320	20345	java/lang/Exception
    //   10357	10380	20345	java/lang/Exception
    //   10410	10422	20345	java/lang/Exception
    //   10452	10461	20345	java/lang/Exception
    //   10491	10503	20345	java/lang/Exception
    //   10533	10542	20345	java/lang/Exception
    //   10579	10602	20345	java/lang/Exception
    //   10632	10644	20345	java/lang/Exception
    //   10674	10683	20345	java/lang/Exception
    //   10713	10725	20345	java/lang/Exception
    //   10755	10764	20345	java/lang/Exception
    //   10801	10824	20345	java/lang/Exception
    //   10854	10866	20345	java/lang/Exception
    //   10896	10905	20345	java/lang/Exception
    //   10935	10947	20345	java/lang/Exception
    //   10977	10986	20345	java/lang/Exception
    //   11023	11046	20345	java/lang/Exception
    //   11076	11088	20345	java/lang/Exception
    //   11118	11127	20345	java/lang/Exception
    //   11157	11169	20345	java/lang/Exception
    //   11199	11208	20345	java/lang/Exception
    //   11245	11268	20345	java/lang/Exception
    //   11298	11310	20345	java/lang/Exception
    //   11340	11349	20345	java/lang/Exception
    //   11379	11391	20345	java/lang/Exception
    //   11421	11430	20345	java/lang/Exception
    //   11467	11490	20345	java/lang/Exception
    //   11520	11532	20345	java/lang/Exception
    //   11562	11571	20345	java/lang/Exception
    //   11601	11613	20345	java/lang/Exception
    //   11643	11652	20345	java/lang/Exception
    //   11689	11712	20345	java/lang/Exception
    //   11742	11754	20345	java/lang/Exception
    //   11784	11793	20345	java/lang/Exception
    //   11823	11835	20345	java/lang/Exception
    //   11865	11874	20345	java/lang/Exception
    //   11911	11934	20345	java/lang/Exception
    //   11964	11976	20345	java/lang/Exception
    //   12006	12015	20345	java/lang/Exception
    //   12045	12057	20345	java/lang/Exception
    //   12087	12096	20345	java/lang/Exception
    //   12133	12156	20345	java/lang/Exception
    //   12186	12198	20345	java/lang/Exception
    //   12228	12237	20345	java/lang/Exception
    //   12267	12279	20345	java/lang/Exception
    //   12309	12318	20345	java/lang/Exception
    //   12355	12378	20345	java/lang/Exception
    //   12408	12420	20345	java/lang/Exception
    //   12450	12459	20345	java/lang/Exception
    //   12489	12501	20345	java/lang/Exception
    //   12531	12540	20345	java/lang/Exception
    //   12577	12600	20345	java/lang/Exception
    //   12630	12642	20345	java/lang/Exception
    //   12672	12681	20345	java/lang/Exception
    //   12711	12723	20345	java/lang/Exception
    //   12753	12762	20345	java/lang/Exception
    //   12799	12822	20345	java/lang/Exception
    //   12852	12864	20345	java/lang/Exception
    //   12894	12903	20345	java/lang/Exception
    //   12933	12945	20345	java/lang/Exception
    //   12975	12984	20345	java/lang/Exception
    //   13021	13044	20345	java/lang/Exception
    //   13074	13086	20345	java/lang/Exception
    //   13116	13125	20345	java/lang/Exception
    //   13155	13167	20345	java/lang/Exception
    //   13197	13206	20345	java/lang/Exception
    //   13243	13266	20345	java/lang/Exception
    //   13296	13308	20345	java/lang/Exception
    //   13338	13347	20345	java/lang/Exception
    //   13377	13389	20345	java/lang/Exception
    //   13419	13428	20345	java/lang/Exception
    //   13465	13488	20345	java/lang/Exception
    //   13518	13530	20345	java/lang/Exception
    //   13560	13569	20345	java/lang/Exception
    //   13599	13611	20345	java/lang/Exception
    //   13641	13650	20345	java/lang/Exception
    //   13687	13710	20345	java/lang/Exception
    //   13740	13752	20345	java/lang/Exception
    //   13782	13791	20345	java/lang/Exception
    //   13821	13833	20345	java/lang/Exception
    //   13863	13872	20345	java/lang/Exception
    //   13909	13932	20345	java/lang/Exception
    //   13962	13974	20345	java/lang/Exception
    //   14004	14013	20345	java/lang/Exception
    //   14043	14055	20345	java/lang/Exception
    //   14085	14094	20345	java/lang/Exception
    //   14131	14154	20345	java/lang/Exception
    //   14184	14196	20345	java/lang/Exception
    //   14226	14235	20345	java/lang/Exception
    //   14265	14277	20345	java/lang/Exception
    //   14307	14316	20345	java/lang/Exception
    //   14353	14376	20345	java/lang/Exception
    //   14406	14418	20345	java/lang/Exception
    //   14448	14457	20345	java/lang/Exception
    //   14487	14499	20345	java/lang/Exception
    //   14529	14538	20345	java/lang/Exception
    //   14604	14610	20345	java/lang/Exception
    //   14640	14654	20345	java/lang/Exception
    //   14684	14698	20345	java/lang/Exception
    //   14728	14742	20345	java/lang/Exception
    //   14772	14786	20345	java/lang/Exception
    //   14816	14830	20345	java/lang/Exception
    //   14860	14874	20345	java/lang/Exception
    //   14904	14918	20345	java/lang/Exception
    //   14948	14962	20345	java/lang/Exception
    //   14992	14995	20345	java/lang/Exception
    //   20327	20338	20345	java/lang/Exception
    //   9568	9585	20407	java/io/IOException
    //   9599	9618	20407	java/io/IOException
    //   9632	9642	20407	java/io/IOException
    //   9656	9685	20407	java/io/IOException
    //   9699	9726	20407	java/io/IOException
    //   9740	9749	20407	java/io/IOException
    //   9795	9804	20407	java/io/IOException
    //   9834	9842	20407	java/io/IOException
    //   9872	9879	20407	java/io/IOException
    //   9913	9936	20407	java/io/IOException
    //   9966	9978	20407	java/io/IOException
    //   10008	10017	20407	java/io/IOException
    //   10047	10059	20407	java/io/IOException
    //   10089	10098	20407	java/io/IOException
    //   10135	10158	20407	java/io/IOException
    //   10188	10200	20407	java/io/IOException
    //   10230	10239	20407	java/io/IOException
    //   10269	10281	20407	java/io/IOException
    //   10311	10320	20407	java/io/IOException
    //   10357	10380	20407	java/io/IOException
    //   10410	10422	20407	java/io/IOException
    //   10452	10461	20407	java/io/IOException
    //   10491	10503	20407	java/io/IOException
    //   10533	10542	20407	java/io/IOException
    //   10579	10602	20407	java/io/IOException
    //   10632	10644	20407	java/io/IOException
    //   10674	10683	20407	java/io/IOException
    //   10713	10725	20407	java/io/IOException
    //   10755	10764	20407	java/io/IOException
    //   10801	10824	20407	java/io/IOException
    //   10854	10866	20407	java/io/IOException
    //   10896	10905	20407	java/io/IOException
    //   10935	10947	20407	java/io/IOException
    //   10977	10986	20407	java/io/IOException
    //   11023	11046	20407	java/io/IOException
    //   11076	11088	20407	java/io/IOException
    //   11118	11127	20407	java/io/IOException
    //   11157	11169	20407	java/io/IOException
    //   11199	11208	20407	java/io/IOException
    //   11245	11268	20407	java/io/IOException
    //   11298	11310	20407	java/io/IOException
    //   11340	11349	20407	java/io/IOException
    //   11379	11391	20407	java/io/IOException
    //   11421	11430	20407	java/io/IOException
    //   11467	11490	20407	java/io/IOException
    //   11520	11532	20407	java/io/IOException
    //   11562	11571	20407	java/io/IOException
    //   11601	11613	20407	java/io/IOException
    //   11643	11652	20407	java/io/IOException
    //   11689	11712	20407	java/io/IOException
    //   11742	11754	20407	java/io/IOException
    //   11784	11793	20407	java/io/IOException
    //   11823	11835	20407	java/io/IOException
    //   11865	11874	20407	java/io/IOException
    //   11911	11934	20407	java/io/IOException
    //   11964	11976	20407	java/io/IOException
    //   12006	12015	20407	java/io/IOException
    //   12045	12057	20407	java/io/IOException
    //   12087	12096	20407	java/io/IOException
    //   12133	12156	20407	java/io/IOException
    //   12186	12198	20407	java/io/IOException
    //   12228	12237	20407	java/io/IOException
    //   12267	12279	20407	java/io/IOException
    //   12309	12318	20407	java/io/IOException
    //   12355	12378	20407	java/io/IOException
    //   12408	12420	20407	java/io/IOException
    //   12450	12459	20407	java/io/IOException
    //   12489	12501	20407	java/io/IOException
    //   12531	12540	20407	java/io/IOException
    //   12577	12600	20407	java/io/IOException
    //   12630	12642	20407	java/io/IOException
    //   12672	12681	20407	java/io/IOException
    //   12711	12723	20407	java/io/IOException
    //   12753	12762	20407	java/io/IOException
    //   12799	12822	20407	java/io/IOException
    //   12852	12864	20407	java/io/IOException
    //   12894	12903	20407	java/io/IOException
    //   12933	12945	20407	java/io/IOException
    //   12975	12984	20407	java/io/IOException
    //   13021	13044	20407	java/io/IOException
    //   13074	13086	20407	java/io/IOException
    //   13116	13125	20407	java/io/IOException
    //   13155	13167	20407	java/io/IOException
    //   13197	13206	20407	java/io/IOException
    //   13243	13266	20407	java/io/IOException
    //   13296	13308	20407	java/io/IOException
    //   13338	13347	20407	java/io/IOException
    //   13377	13389	20407	java/io/IOException
    //   13419	13428	20407	java/io/IOException
    //   13465	13488	20407	java/io/IOException
    //   13518	13530	20407	java/io/IOException
    //   13560	13569	20407	java/io/IOException
    //   13599	13611	20407	java/io/IOException
    //   13641	13650	20407	java/io/IOException
    //   13687	13710	20407	java/io/IOException
    //   13740	13752	20407	java/io/IOException
    //   13782	13791	20407	java/io/IOException
    //   13821	13833	20407	java/io/IOException
    //   13863	13872	20407	java/io/IOException
    //   13909	13932	20407	java/io/IOException
    //   13962	13974	20407	java/io/IOException
    //   14004	14013	20407	java/io/IOException
    //   14043	14055	20407	java/io/IOException
    //   14085	14094	20407	java/io/IOException
    //   14131	14154	20407	java/io/IOException
    //   14184	14196	20407	java/io/IOException
    //   14226	14235	20407	java/io/IOException
    //   14265	14277	20407	java/io/IOException
    //   14307	14316	20407	java/io/IOException
    //   14353	14376	20407	java/io/IOException
    //   14406	14418	20407	java/io/IOException
    //   14448	14457	20407	java/io/IOException
    //   14487	14499	20407	java/io/IOException
    //   14529	14538	20407	java/io/IOException
    //   14604	14610	20407	java/io/IOException
    //   14640	14654	20407	java/io/IOException
    //   14684	14698	20407	java/io/IOException
    //   14728	14742	20407	java/io/IOException
    //   14772	14786	20407	java/io/IOException
    //   14816	14830	20407	java/io/IOException
    //   14860	14874	20407	java/io/IOException
    //   14904	14918	20407	java/io/IOException
    //   14948	14962	20407	java/io/IOException
    //   14992	14995	20407	java/io/IOException
    //   15025	15030	20407	java/io/IOException
    //   20327	20338	20407	java/io/IOException
    //   20361	20388	20407	java/io/IOException
    //   15191	15308	20584	java/io/FileNotFoundException
    //   15308	15336	20584	java/io/FileNotFoundException
    //   15336	15343	20584	java/io/FileNotFoundException
    //   15343	15395	20584	java/io/FileNotFoundException
    //   15397	15405	20584	java/io/FileNotFoundException
    //   15407	15443	20584	java/io/FileNotFoundException
    //   15452	15460	20584	java/io/FileNotFoundException
    //   15471	15480	20584	java/io/FileNotFoundException
    //   15482	15490	20584	java/io/FileNotFoundException
    //   15492	15499	20584	java/io/FileNotFoundException
    //   15504	15527	20584	java/io/FileNotFoundException
    //   15529	15541	20584	java/io/FileNotFoundException
    //   15543	15552	20584	java/io/FileNotFoundException
    //   15554	15566	20584	java/io/FileNotFoundException
    //   15568	15577	20584	java/io/FileNotFoundException
    //   15586	15609	20584	java/io/FileNotFoundException
    //   15612	15624	20584	java/io/FileNotFoundException
    //   15627	15636	20584	java/io/FileNotFoundException
    //   15639	15651	20584	java/io/FileNotFoundException
    //   15654	15663	20584	java/io/FileNotFoundException
    //   15671	15694	20584	java/io/FileNotFoundException
    //   15696	15708	20584	java/io/FileNotFoundException
    //   15710	15719	20584	java/io/FileNotFoundException
    //   15721	15733	20584	java/io/FileNotFoundException
    //   15735	15744	20584	java/io/FileNotFoundException
    //   15753	15776	20584	java/io/FileNotFoundException
    //   15779	15791	20584	java/io/FileNotFoundException
    //   15794	15803	20584	java/io/FileNotFoundException
    //   15806	15818	20584	java/io/FileNotFoundException
    //   15821	15830	20584	java/io/FileNotFoundException
    //   15838	15861	20584	java/io/FileNotFoundException
    //   15863	15875	20584	java/io/FileNotFoundException
    //   15877	15886	20584	java/io/FileNotFoundException
    //   15888	15900	20584	java/io/FileNotFoundException
    //   15902	15911	20584	java/io/FileNotFoundException
    //   15920	15943	20584	java/io/FileNotFoundException
    //   15946	15958	20584	java/io/FileNotFoundException
    //   15961	15970	20584	java/io/FileNotFoundException
    //   15973	15985	20584	java/io/FileNotFoundException
    //   15988	15997	20584	java/io/FileNotFoundException
    //   16005	16028	20584	java/io/FileNotFoundException
    //   16030	16042	20584	java/io/FileNotFoundException
    //   16044	16053	20584	java/io/FileNotFoundException
    //   16055	16067	20584	java/io/FileNotFoundException
    //   16069	16078	20584	java/io/FileNotFoundException
    //   16087	16110	20584	java/io/FileNotFoundException
    //   16113	16125	20584	java/io/FileNotFoundException
    //   16128	16137	20584	java/io/FileNotFoundException
    //   16140	16152	20584	java/io/FileNotFoundException
    //   16155	16164	20584	java/io/FileNotFoundException
    //   16169	16180	20584	java/io/FileNotFoundException
    //   20432	20503	20584	java/io/FileNotFoundException
    //   20503	20581	20584	java/io/FileNotFoundException
    //   20598	20616	20584	java/io/FileNotFoundException
    //   20667	20707	20584	java/io/FileNotFoundException
    //   20898	20910	20584	java/io/FileNotFoundException
    //   20914	20922	20584	java/io/FileNotFoundException
    //   20926	20942	20584	java/io/FileNotFoundException
    //   20946	20984	20584	java/io/FileNotFoundException
    //   20989	21021	20584	java/io/FileNotFoundException
    //   21028	21034	20584	java/io/FileNotFoundException
    //   21038	21071	20584	java/io/FileNotFoundException
    //   21075	21120	20584	java/io/FileNotFoundException
    //   21125	21143	20584	java/io/FileNotFoundException
    //   21148	21224	20584	java/io/FileNotFoundException
    //   21224	21255	20584	java/io/FileNotFoundException
    //   21255	21283	20584	java/io/FileNotFoundException
    //   21288	21315	20584	java/io/FileNotFoundException
    //   21330	21402	20584	java/io/FileNotFoundException
    //   21407	21416	20584	java/io/FileNotFoundException
    //   21418	21426	20584	java/io/FileNotFoundException
    //   21428	21435	20584	java/io/FileNotFoundException
    //   21440	21463	20584	java/io/FileNotFoundException
    //   21465	21477	20584	java/io/FileNotFoundException
    //   21479	21488	20584	java/io/FileNotFoundException
    //   21490	21502	20584	java/io/FileNotFoundException
    //   21504	21513	20584	java/io/FileNotFoundException
    //   21522	21545	20584	java/io/FileNotFoundException
    //   21548	21560	20584	java/io/FileNotFoundException
    //   21563	21572	20584	java/io/FileNotFoundException
    //   21575	21587	20584	java/io/FileNotFoundException
    //   21590	21599	20584	java/io/FileNotFoundException
    //   21607	21630	20584	java/io/FileNotFoundException
    //   21632	21644	20584	java/io/FileNotFoundException
    //   21646	21655	20584	java/io/FileNotFoundException
    //   21657	21669	20584	java/io/FileNotFoundException
    //   21671	21680	20584	java/io/FileNotFoundException
    //   21689	21712	20584	java/io/FileNotFoundException
    //   21715	21727	20584	java/io/FileNotFoundException
    //   21730	21739	20584	java/io/FileNotFoundException
    //   21742	21754	20584	java/io/FileNotFoundException
    //   21757	21766	20584	java/io/FileNotFoundException
    //   21774	21797	20584	java/io/FileNotFoundException
    //   21799	21811	20584	java/io/FileNotFoundException
    //   21813	21822	20584	java/io/FileNotFoundException
    //   21824	21836	20584	java/io/FileNotFoundException
    //   21838	21847	20584	java/io/FileNotFoundException
    //   21856	21879	20584	java/io/FileNotFoundException
    //   21882	21894	20584	java/io/FileNotFoundException
    //   21897	21906	20584	java/io/FileNotFoundException
    //   21909	21921	20584	java/io/FileNotFoundException
    //   21924	21933	20584	java/io/FileNotFoundException
    //   21941	21964	20584	java/io/FileNotFoundException
    //   21966	21978	20584	java/io/FileNotFoundException
    //   21980	21989	20584	java/io/FileNotFoundException
    //   21991	22003	20584	java/io/FileNotFoundException
    //   22005	22014	20584	java/io/FileNotFoundException
    //   22023	22046	20584	java/io/FileNotFoundException
    //   22049	22061	20584	java/io/FileNotFoundException
    //   22064	22073	20584	java/io/FileNotFoundException
    //   22076	22088	20584	java/io/FileNotFoundException
    //   22091	22100	20584	java/io/FileNotFoundException
    //   22108	22131	20584	java/io/FileNotFoundException
    //   22133	22145	20584	java/io/FileNotFoundException
    //   22147	22156	20584	java/io/FileNotFoundException
    //   22158	22170	20584	java/io/FileNotFoundException
    //   22172	22181	20584	java/io/FileNotFoundException
    //   22190	22213	20584	java/io/FileNotFoundException
    //   22216	22228	20584	java/io/FileNotFoundException
    //   22231	22240	20584	java/io/FileNotFoundException
    //   22243	22255	20584	java/io/FileNotFoundException
    //   22258	22267	20584	java/io/FileNotFoundException
    //   22275	22298	20584	java/io/FileNotFoundException
    //   22300	22312	20584	java/io/FileNotFoundException
    //   22314	22323	20584	java/io/FileNotFoundException
    //   22325	22337	20584	java/io/FileNotFoundException
    //   22339	22348	20584	java/io/FileNotFoundException
    //   22357	22380	20584	java/io/FileNotFoundException
    //   22383	22395	20584	java/io/FileNotFoundException
    //   22398	22407	20584	java/io/FileNotFoundException
    //   22410	22422	20584	java/io/FileNotFoundException
    //   22425	22434	20584	java/io/FileNotFoundException
    //   22442	22465	20584	java/io/FileNotFoundException
    //   22467	22479	20584	java/io/FileNotFoundException
    //   22481	22490	20584	java/io/FileNotFoundException
    //   22492	22504	20584	java/io/FileNotFoundException
    //   22506	22515	20584	java/io/FileNotFoundException
    //   22524	22547	20584	java/io/FileNotFoundException
    //   22550	22562	20584	java/io/FileNotFoundException
    //   22565	22574	20584	java/io/FileNotFoundException
    //   22577	22589	20584	java/io/FileNotFoundException
    //   22592	22601	20584	java/io/FileNotFoundException
    //   22609	22632	20584	java/io/FileNotFoundException
    //   22634	22646	20584	java/io/FileNotFoundException
    //   22648	22657	20584	java/io/FileNotFoundException
    //   22659	22671	20584	java/io/FileNotFoundException
    //   22673	22682	20584	java/io/FileNotFoundException
    //   22691	22714	20584	java/io/FileNotFoundException
    //   22717	22729	20584	java/io/FileNotFoundException
    //   22732	22741	20584	java/io/FileNotFoundException
    //   22744	22756	20584	java/io/FileNotFoundException
    //   22759	22768	20584	java/io/FileNotFoundException
    //   22776	22799	20584	java/io/FileNotFoundException
    //   22801	22813	20584	java/io/FileNotFoundException
    //   22815	22824	20584	java/io/FileNotFoundException
    //   22826	22838	20584	java/io/FileNotFoundException
    //   22840	22849	20584	java/io/FileNotFoundException
    //   22858	22881	20584	java/io/FileNotFoundException
    //   22884	22896	20584	java/io/FileNotFoundException
    //   22899	22908	20584	java/io/FileNotFoundException
    //   22911	22923	20584	java/io/FileNotFoundException
    //   22926	22935	20584	java/io/FileNotFoundException
    //   22947	22970	20584	java/io/FileNotFoundException
    //   22972	22984	20584	java/io/FileNotFoundException
    //   22986	22995	20584	java/io/FileNotFoundException
    //   22997	23009	20584	java/io/FileNotFoundException
    //   23011	23020	20584	java/io/FileNotFoundException
    //   23030	23053	20584	java/io/FileNotFoundException
    //   23056	23068	20584	java/io/FileNotFoundException
    //   23071	23080	20584	java/io/FileNotFoundException
    //   23083	23095	20584	java/io/FileNotFoundException
    //   23098	23107	20584	java/io/FileNotFoundException
    //   23116	23139	20584	java/io/FileNotFoundException
    //   23142	23154	20584	java/io/FileNotFoundException
    //   23157	23166	20584	java/io/FileNotFoundException
    //   23169	23181	20584	java/io/FileNotFoundException
    //   23184	23193	20584	java/io/FileNotFoundException
    //   23198	23209	20584	java/io/FileNotFoundException
    //   23218	23245	20584	java/io/FileNotFoundException
    //   23253	23271	20584	java/io/FileNotFoundException
    //   23274	23278	20584	java/io/FileNotFoundException
    //   23281	23300	20584	java/io/FileNotFoundException
    //   23300	23314	20584	java/io/FileNotFoundException
    //   23319	23328	20584	java/io/FileNotFoundException
    //   23328	23342	20584	java/io/FileNotFoundException
    //   23347	23430	20584	java/io/FileNotFoundException
    //   23430	23570	20584	java/io/FileNotFoundException
    //   23570	23701	20584	java/io/FileNotFoundException
    //   23706	23741	20584	java/io/FileNotFoundException
    //   23741	23853	20584	java/io/FileNotFoundException
    //   23853	23856	20584	java/io/FileNotFoundException
    //   23856	23865	20584	java/io/FileNotFoundException
    //   23865	23896	20584	java/io/FileNotFoundException
    //   23896	23921	20584	java/io/FileNotFoundException
    //   23921	23947	20584	java/io/FileNotFoundException
    //   23950	23958	20584	java/io/FileNotFoundException
    //   23963	23968	20584	java/io/FileNotFoundException
    //   23973	24001	20584	java/io/FileNotFoundException
    //   24004	24030	20584	java/io/FileNotFoundException
    //   20624	20632	20739	java/lang/Exception
    //   20640	20648	20739	java/lang/Exception
    //   20656	20664	20739	java/lang/Exception
    //   20715	20723	20739	java/lang/Exception
    //   20731	20739	20739	java/lang/Exception
    //   20780	20794	20739	java/lang/Exception
    //   20802	20830	20739	java/lang/Exception
    //   20838	20854	20739	java/lang/Exception
    //   20862	20874	20739	java/lang/Exception
    //   20882	20889	20739	java/lang/Exception
    //   24038	24055	20739	java/lang/Exception
    //   24063	24082	20739	java/lang/Exception
    //   24090	24094	20739	java/lang/Exception
    //   24102	24106	20739	java/lang/Exception
    //   24873	24900	20739	java/lang/Exception
    //   24908	24914	20739	java/lang/Exception
    //   24922	24928	20739	java/lang/Exception
    //   24936	24946	20739	java/lang/Exception
    //   24954	24964	20739	java/lang/Exception
    //   24972	24979	20739	java/lang/Exception
    //   24987	24992	20739	java/lang/Exception
    //   25000	25014	20739	java/lang/Exception
    //   25022	25027	20739	java/lang/Exception
    //   25035	25044	20739	java/lang/Exception
    //   25055	25063	20739	java/lang/Exception
    //   15471	15480	20987	java/lang/Exception
    //   15482	15490	20987	java/lang/Exception
    //   15492	15499	20987	java/lang/Exception
    //   15504	15527	20987	java/lang/Exception
    //   15529	15541	20987	java/lang/Exception
    //   15543	15552	20987	java/lang/Exception
    //   15554	15566	20987	java/lang/Exception
    //   15568	15577	20987	java/lang/Exception
    //   15586	15609	20987	java/lang/Exception
    //   15612	15624	20987	java/lang/Exception
    //   15627	15636	20987	java/lang/Exception
    //   15639	15651	20987	java/lang/Exception
    //   15654	15663	20987	java/lang/Exception
    //   15671	15694	20987	java/lang/Exception
    //   15696	15708	20987	java/lang/Exception
    //   15710	15719	20987	java/lang/Exception
    //   15721	15733	20987	java/lang/Exception
    //   15735	15744	20987	java/lang/Exception
    //   15753	15776	20987	java/lang/Exception
    //   15779	15791	20987	java/lang/Exception
    //   15794	15803	20987	java/lang/Exception
    //   15806	15818	20987	java/lang/Exception
    //   15821	15830	20987	java/lang/Exception
    //   15838	15861	20987	java/lang/Exception
    //   15863	15875	20987	java/lang/Exception
    //   15877	15886	20987	java/lang/Exception
    //   15888	15900	20987	java/lang/Exception
    //   15902	15911	20987	java/lang/Exception
    //   15920	15943	20987	java/lang/Exception
    //   15946	15958	20987	java/lang/Exception
    //   15961	15970	20987	java/lang/Exception
    //   15973	15985	20987	java/lang/Exception
    //   15988	15997	20987	java/lang/Exception
    //   16005	16028	20987	java/lang/Exception
    //   16030	16042	20987	java/lang/Exception
    //   16044	16053	20987	java/lang/Exception
    //   16055	16067	20987	java/lang/Exception
    //   16069	16078	20987	java/lang/Exception
    //   16087	16110	20987	java/lang/Exception
    //   16113	16125	20987	java/lang/Exception
    //   16128	16137	20987	java/lang/Exception
    //   16140	16152	20987	java/lang/Exception
    //   16155	16164	20987	java/lang/Exception
    //   16169	16180	20987	java/lang/Exception
    //   21407	21416	23216	java/lang/Exception
    //   21418	21426	23216	java/lang/Exception
    //   21428	21435	23216	java/lang/Exception
    //   21440	21463	23216	java/lang/Exception
    //   21465	21477	23216	java/lang/Exception
    //   21479	21488	23216	java/lang/Exception
    //   21490	21502	23216	java/lang/Exception
    //   21504	21513	23216	java/lang/Exception
    //   21522	21545	23216	java/lang/Exception
    //   21548	21560	23216	java/lang/Exception
    //   21563	21572	23216	java/lang/Exception
    //   21575	21587	23216	java/lang/Exception
    //   21590	21599	23216	java/lang/Exception
    //   21607	21630	23216	java/lang/Exception
    //   21632	21644	23216	java/lang/Exception
    //   21646	21655	23216	java/lang/Exception
    //   21657	21669	23216	java/lang/Exception
    //   21671	21680	23216	java/lang/Exception
    //   21689	21712	23216	java/lang/Exception
    //   21715	21727	23216	java/lang/Exception
    //   21730	21739	23216	java/lang/Exception
    //   21742	21754	23216	java/lang/Exception
    //   21757	21766	23216	java/lang/Exception
    //   21774	21797	23216	java/lang/Exception
    //   21799	21811	23216	java/lang/Exception
    //   21813	21822	23216	java/lang/Exception
    //   21824	21836	23216	java/lang/Exception
    //   21838	21847	23216	java/lang/Exception
    //   21856	21879	23216	java/lang/Exception
    //   21882	21894	23216	java/lang/Exception
    //   21897	21906	23216	java/lang/Exception
    //   21909	21921	23216	java/lang/Exception
    //   21924	21933	23216	java/lang/Exception
    //   21941	21964	23216	java/lang/Exception
    //   21966	21978	23216	java/lang/Exception
    //   21980	21989	23216	java/lang/Exception
    //   21991	22003	23216	java/lang/Exception
    //   22005	22014	23216	java/lang/Exception
    //   22023	22046	23216	java/lang/Exception
    //   22049	22061	23216	java/lang/Exception
    //   22064	22073	23216	java/lang/Exception
    //   22076	22088	23216	java/lang/Exception
    //   22091	22100	23216	java/lang/Exception
    //   22108	22131	23216	java/lang/Exception
    //   22133	22145	23216	java/lang/Exception
    //   22147	22156	23216	java/lang/Exception
    //   22158	22170	23216	java/lang/Exception
    //   22172	22181	23216	java/lang/Exception
    //   22190	22213	23216	java/lang/Exception
    //   22216	22228	23216	java/lang/Exception
    //   22231	22240	23216	java/lang/Exception
    //   22243	22255	23216	java/lang/Exception
    //   22258	22267	23216	java/lang/Exception
    //   22275	22298	23216	java/lang/Exception
    //   22300	22312	23216	java/lang/Exception
    //   22314	22323	23216	java/lang/Exception
    //   22325	22337	23216	java/lang/Exception
    //   22339	22348	23216	java/lang/Exception
    //   22357	22380	23216	java/lang/Exception
    //   22383	22395	23216	java/lang/Exception
    //   22398	22407	23216	java/lang/Exception
    //   22410	22422	23216	java/lang/Exception
    //   22425	22434	23216	java/lang/Exception
    //   22442	22465	23216	java/lang/Exception
    //   22467	22479	23216	java/lang/Exception
    //   22481	22490	23216	java/lang/Exception
    //   22492	22504	23216	java/lang/Exception
    //   22506	22515	23216	java/lang/Exception
    //   22524	22547	23216	java/lang/Exception
    //   22550	22562	23216	java/lang/Exception
    //   22565	22574	23216	java/lang/Exception
    //   22577	22589	23216	java/lang/Exception
    //   22592	22601	23216	java/lang/Exception
    //   22609	22632	23216	java/lang/Exception
    //   22634	22646	23216	java/lang/Exception
    //   22648	22657	23216	java/lang/Exception
    //   22659	22671	23216	java/lang/Exception
    //   22673	22682	23216	java/lang/Exception
    //   22691	22714	23216	java/lang/Exception
    //   22717	22729	23216	java/lang/Exception
    //   22732	22741	23216	java/lang/Exception
    //   22744	22756	23216	java/lang/Exception
    //   22759	22768	23216	java/lang/Exception
    //   22776	22799	23216	java/lang/Exception
    //   22801	22813	23216	java/lang/Exception
    //   22815	22824	23216	java/lang/Exception
    //   22826	22838	23216	java/lang/Exception
    //   22840	22849	23216	java/lang/Exception
    //   22858	22881	23216	java/lang/Exception
    //   22884	22896	23216	java/lang/Exception
    //   22899	22908	23216	java/lang/Exception
    //   22911	22923	23216	java/lang/Exception
    //   22926	22935	23216	java/lang/Exception
    //   22947	22970	23216	java/lang/Exception
    //   22972	22984	23216	java/lang/Exception
    //   22986	22995	23216	java/lang/Exception
    //   22997	23009	23216	java/lang/Exception
    //   23011	23020	23216	java/lang/Exception
    //   23030	23053	23216	java/lang/Exception
    //   23056	23068	23216	java/lang/Exception
    //   23071	23080	23216	java/lang/Exception
    //   23083	23095	23216	java/lang/Exception
    //   23098	23107	23216	java/lang/Exception
    //   23116	23139	23216	java/lang/Exception
    //   23142	23154	23216	java/lang/Exception
    //   23157	23166	23216	java/lang/Exception
    //   23169	23181	23216	java/lang/Exception
    //   23184	23193	23216	java/lang/Exception
    //   23198	23209	23216	java/lang/Exception
    //   21224	21255	23251	java/lang/Exception
    //   23706	23741	23961	java/lang/Exception
    //   23741	23853	23961	java/lang/Exception
    //   23430	23570	23971	java/lang/Exception
    //   23570	23701	23971	java/lang/Exception
    //   23853	23856	23971	java/lang/Exception
    //   23963	23968	23971	java/lang/Exception
    //   24113	24122	24863	java/lang/Exception
    //   24126	24133	24863	java/lang/Exception
    //   24137	24144	24863	java/lang/Exception
    //   24148	24170	24863	java/lang/Exception
    //   24174	24186	24863	java/lang/Exception
    //   24190	24199	24863	java/lang/Exception
    //   24203	24215	24863	java/lang/Exception
    //   24219	24228	24863	java/lang/Exception
    //   24235	24257	24863	java/lang/Exception
    //   24261	24273	24863	java/lang/Exception
    //   24277	24286	24863	java/lang/Exception
    //   24290	24302	24863	java/lang/Exception
    //   24306	24315	24863	java/lang/Exception
    //   24322	24344	24863	java/lang/Exception
    //   24348	24360	24863	java/lang/Exception
    //   24364	24373	24863	java/lang/Exception
    //   24377	24389	24863	java/lang/Exception
    //   24393	24402	24863	java/lang/Exception
    //   24409	24431	24863	java/lang/Exception
    //   24435	24447	24863	java/lang/Exception
    //   24451	24460	24863	java/lang/Exception
    //   24464	24476	24863	java/lang/Exception
    //   24480	24489	24863	java/lang/Exception
    //   24496	24518	24863	java/lang/Exception
    //   24522	24534	24863	java/lang/Exception
    //   24538	24547	24863	java/lang/Exception
    //   24551	24563	24863	java/lang/Exception
    //   24567	24576	24863	java/lang/Exception
    //   24583	24605	24863	java/lang/Exception
    //   24609	24621	24863	java/lang/Exception
    //   24625	24634	24863	java/lang/Exception
    //   24638	24650	24863	java/lang/Exception
    //   24654	24663	24863	java/lang/Exception
    //   24670	24692	24863	java/lang/Exception
    //   24696	24708	24863	java/lang/Exception
    //   24712	24721	24863	java/lang/Exception
    //   24725	24737	24863	java/lang/Exception
    //   24741	24750	24863	java/lang/Exception
    //   24757	24779	24863	java/lang/Exception
    //   24783	24795	24863	java/lang/Exception
    //   24799	24808	24863	java/lang/Exception
    //   24812	24824	24863	java/lang/Exception
    //   24828	24837	24863	java/lang/Exception
    //   24844	24854	24863	java/lang/Exception
    //   16243	16251	25538	java/io/FileNotFoundException
    //   16259	16267	25538	java/io/FileNotFoundException
    //   16275	16283	25538	java/io/FileNotFoundException
    //   16306	16314	25538	java/io/FileNotFoundException
    //   16322	16330	25538	java/io/FileNotFoundException
    //   16373	16387	25538	java/io/FileNotFoundException
    //   16395	16407	25538	java/io/FileNotFoundException
    //   16415	16423	25538	java/io/FileNotFoundException
    //   16431	16441	25538	java/io/FileNotFoundException
    //   16449	16455	25538	java/io/FileNotFoundException
    //   16463	16471	25538	java/io/FileNotFoundException
    //   16479	16493	25538	java/io/FileNotFoundException
    //   16501	16509	25538	java/io/FileNotFoundException
    //   16517	16529	25538	java/io/FileNotFoundException
    //   16537	16549	25538	java/io/FileNotFoundException
    //   16557	16565	25538	java/io/FileNotFoundException
    //   16573	16583	25538	java/io/FileNotFoundException
    //   16591	16597	25538	java/io/FileNotFoundException
    //   16608	16616	25538	java/io/FileNotFoundException
    //   6554	6590	25543	java/lang/Exception
    //   6590	6683	25543	java/lang/Exception
    //   6683	6719	25543	java/lang/Exception
    //   6719	6735	25543	java/lang/Exception
    //   6735	6742	25543	java/lang/Exception
    //   6742	6844	25543	java/lang/Exception
    //   6848	6861	25543	java/lang/Exception
    //   8763	8825	25543	java/lang/Exception
    //   8825	8885	25543	java/lang/Exception
    //   16189	16235	25543	java/lang/Exception
    //   16286	16298	25543	java/lang/Exception
    //   16621	16648	25543	java/lang/Exception
    //   16651	16691	25543	java/lang/Exception
    //   16696	16710	25543	java/lang/Exception
    //   16715	16791	25543	java/lang/Exception
    //   16822	16850	25543	java/lang/Exception
    //   16850	16856	25543	java/lang/Exception
    //   16861	16902	25543	java/lang/Exception
    //   16902	16943	25543	java/lang/Exception
    //   16943	16957	25543	java/lang/Exception
    //   16962	16989	25543	java/lang/Exception
    //   17001	17073	25543	java/lang/Exception
    //   18932	18959	25543	java/lang/Exception
    //   18967	18985	25543	java/lang/Exception
    //   18988	18992	25543	java/lang/Exception
    //   18995	19014	25543	java/lang/Exception
    //   19014	19040	25543	java/lang/Exception
    //   19045	19128	25543	java/lang/Exception
    //   19572	19581	25543	java/lang/Exception
    //   19584	19592	25543	java/lang/Exception
    //   19597	19625	25543	java/lang/Exception
    //   19628	19651	25543	java/lang/Exception
    //   19654	19674	25543	java/lang/Exception
    //   19679	19791	25543	java/lang/Exception
    //   19791	19816	25543	java/lang/Exception
    //   19816	19841	25543	java/lang/Exception
    //   19844	19868	25543	java/lang/Exception
    //   20624	20632	25753	java/io/FileNotFoundException
    //   20640	20648	25753	java/io/FileNotFoundException
    //   20656	20664	25753	java/io/FileNotFoundException
    //   20715	20723	25753	java/io/FileNotFoundException
    //   20731	20739	25753	java/io/FileNotFoundException
    //   20780	20794	25753	java/io/FileNotFoundException
    //   20802	20830	25753	java/io/FileNotFoundException
    //   20838	20854	25753	java/io/FileNotFoundException
    //   20862	20874	25753	java/io/FileNotFoundException
    //   20882	20889	25753	java/io/FileNotFoundException
    //   24038	24055	25753	java/io/FileNotFoundException
    //   24063	24082	25753	java/io/FileNotFoundException
    //   24090	24094	25753	java/io/FileNotFoundException
    //   24102	24106	25753	java/io/FileNotFoundException
    //   24113	24122	25753	java/io/FileNotFoundException
    //   24126	24133	25753	java/io/FileNotFoundException
    //   24137	24144	25753	java/io/FileNotFoundException
    //   24148	24170	25753	java/io/FileNotFoundException
    //   24174	24186	25753	java/io/FileNotFoundException
    //   24190	24199	25753	java/io/FileNotFoundException
    //   24203	24215	25753	java/io/FileNotFoundException
    //   24219	24228	25753	java/io/FileNotFoundException
    //   24235	24257	25753	java/io/FileNotFoundException
    //   24261	24273	25753	java/io/FileNotFoundException
    //   24277	24286	25753	java/io/FileNotFoundException
    //   24290	24302	25753	java/io/FileNotFoundException
    //   24306	24315	25753	java/io/FileNotFoundException
    //   24322	24344	25753	java/io/FileNotFoundException
    //   24348	24360	25753	java/io/FileNotFoundException
    //   24364	24373	25753	java/io/FileNotFoundException
    //   24377	24389	25753	java/io/FileNotFoundException
    //   24393	24402	25753	java/io/FileNotFoundException
    //   24409	24431	25753	java/io/FileNotFoundException
    //   24435	24447	25753	java/io/FileNotFoundException
    //   24451	24460	25753	java/io/FileNotFoundException
    //   24464	24476	25753	java/io/FileNotFoundException
    //   24480	24489	25753	java/io/FileNotFoundException
    //   24496	24518	25753	java/io/FileNotFoundException
    //   24522	24534	25753	java/io/FileNotFoundException
    //   24538	24547	25753	java/io/FileNotFoundException
    //   24551	24563	25753	java/io/FileNotFoundException
    //   24567	24576	25753	java/io/FileNotFoundException
    //   24583	24605	25753	java/io/FileNotFoundException
    //   24609	24621	25753	java/io/FileNotFoundException
    //   24625	24634	25753	java/io/FileNotFoundException
    //   24638	24650	25753	java/io/FileNotFoundException
    //   24654	24663	25753	java/io/FileNotFoundException
    //   24670	24692	25753	java/io/FileNotFoundException
    //   24696	24708	25753	java/io/FileNotFoundException
    //   24712	24721	25753	java/io/FileNotFoundException
    //   24725	24737	25753	java/io/FileNotFoundException
    //   24741	24750	25753	java/io/FileNotFoundException
    //   24757	24779	25753	java/io/FileNotFoundException
    //   24783	24795	25753	java/io/FileNotFoundException
    //   24799	24808	25753	java/io/FileNotFoundException
    //   24812	24824	25753	java/io/FileNotFoundException
    //   24828	24837	25753	java/io/FileNotFoundException
    //   24844	24854	25753	java/io/FileNotFoundException
    //   24873	24900	25753	java/io/FileNotFoundException
    //   24908	24914	25753	java/io/FileNotFoundException
    //   24922	24928	25753	java/io/FileNotFoundException
    //   24936	24946	25753	java/io/FileNotFoundException
    //   24954	24964	25753	java/io/FileNotFoundException
    //   24972	24979	25753	java/io/FileNotFoundException
    //   24987	24992	25753	java/io/FileNotFoundException
    //   25000	25014	25753	java/io/FileNotFoundException
    //   25022	25027	25753	java/io/FileNotFoundException
    //   25035	25044	25753	java/io/FileNotFoundException
    //   25055	25063	25753	java/io/FileNotFoundException
    //   15191	15308	25757	java/lang/Exception
    //   15308	15336	25757	java/lang/Exception
    //   15336	15343	25757	java/lang/Exception
    //   15343	15395	25757	java/lang/Exception
    //   15397	15405	25757	java/lang/Exception
    //   15407	15443	25757	java/lang/Exception
    //   15452	15460	25757	java/lang/Exception
    //   20432	20503	25757	java/lang/Exception
    //   20503	20581	25757	java/lang/Exception
    //   20598	20616	25757	java/lang/Exception
    //   20667	20707	25757	java/lang/Exception
    //   20898	20910	25757	java/lang/Exception
    //   20914	20922	25757	java/lang/Exception
    //   20926	20942	25757	java/lang/Exception
    //   20946	20984	25757	java/lang/Exception
    //   20989	21021	25757	java/lang/Exception
    //   21028	21034	25757	java/lang/Exception
    //   21038	21071	25757	java/lang/Exception
    //   21075	21120	25757	java/lang/Exception
    //   21125	21143	25757	java/lang/Exception
    //   21148	21224	25757	java/lang/Exception
    //   21255	21283	25757	java/lang/Exception
    //   21288	21315	25757	java/lang/Exception
    //   21330	21402	25757	java/lang/Exception
    //   23218	23245	25757	java/lang/Exception
    //   23253	23271	25757	java/lang/Exception
    //   23274	23278	25757	java/lang/Exception
    //   23281	23300	25757	java/lang/Exception
    //   23300	23314	25757	java/lang/Exception
    //   23319	23328	25757	java/lang/Exception
    //   23328	23342	25757	java/lang/Exception
    //   23347	23430	25757	java/lang/Exception
    //   23856	23865	25757	java/lang/Exception
    //   23865	23896	25757	java/lang/Exception
    //   23896	23921	25757	java/lang/Exception
    //   23921	23947	25757	java/lang/Exception
    //   23950	23958	25757	java/lang/Exception
    //   23973	24001	25757	java/lang/Exception
    //   24004	24030	25757	java/lang/Exception
  }
  
  public static void unzip(File paramFile, String paramString)
  {
    int i = 0;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      ZipInputStream localZipInputStream = new ZipInputStream(localFileInputStream);
      Object localObject = localZipInputStream.getNextEntry();
      for (;;)
      {
        if ((localObject != null) && (1 != 0))
        {
          if (((ZipEntry)localObject).getName().equals("classes.dex"))
          {
            localObject = new FileOutputStream(paramString + "/" + "classes.dex");
            byte[] arrayOfByte = new byte['ࠀ'];
            for (;;)
            {
              i = localZipInputStream.read(arrayOfByte);
              if (i == -1) {
                break;
              }
              ((FileOutputStream)localObject).write(arrayOfByte, 0, i);
            }
          }
        }
        else {
          try
          {
            new ZipFile(paramFile).extractFile("classes.dex", paramString);
            System.out.println("Exception e" + localException.toString());
            return;
            Utils.run_all_no_root(new String[] { "chmod", "777", paramString + "/" + "classes.dex" });
            Utils.run_all_no_root(new String[] { "chown", "0.0", paramString + "/" + "classes.dex" });
            Utils.run_all_no_root(new String[] { "chown", "0:0", paramString + "/" + "classes.dex" });
            localZipInputStream.closeEntry();
            localException.close();
            i = 1;
            break label457;
            localZipInputStream.close();
            localFileInputStream.close();
            return;
            localZipEntry = localZipInputStream.getNextEntry();
          }
          catch (ZipException paramFile)
          {
            for (;;)
            {
              System.out.println("Error classes.dex decompress! " + paramFile);
              System.out.println("Exception e1" + localZipEntry.toString());
            }
          }
          catch (Exception paramFile)
          {
            for (;;)
            {
              System.out.println("Error classes.dex decompress! " + paramFile);
              System.out.println("Exception e1" + localZipEntry.toString());
            }
          }
        }
      }
    }
    catch (Exception localException) {}
    for (;;)
    {
      ZipEntry localZipEntry;
      label457:
      if (i != 0) {}
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/corepatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */