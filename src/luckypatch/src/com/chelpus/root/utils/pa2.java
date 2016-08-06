package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class pa2
{
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new byte[9];
    paramArrayOfString[0] = 112;
    paramArrayOfString[1] = 97;
    paramArrayOfString[2] = 116;
    paramArrayOfString[3] = 104;
    paramArrayOfString[4] = 95;
    paramArrayOfString[5] = 104;
    paramArrayOfString[6] = 97;
    paramArrayOfString[7] = 115;
    paramArrayOfString[8] = 104;
    paramArrayOfString;
    byte[] arrayOfByte1 = new byte[9];
    byte[] tmp63_61 = arrayOfByte1;
    tmp63_61[0] = 112;
    byte[] tmp68_63 = tmp63_61;
    tmp68_63[1] = 97;
    byte[] tmp73_68 = tmp68_63;
    tmp73_68[2] = 108;
    byte[] tmp78_73 = tmp73_68;
    tmp78_73[3] = 104;
    byte[] tmp83_78 = tmp78_73;
    tmp83_78[4] = 95;
    byte[] tmp88_83 = tmp83_78;
    tmp88_83[5] = 104;
    byte[] tmp93_88 = tmp88_83;
    tmp93_88[6] = 97;
    byte[] tmp99_93 = tmp93_88;
    tmp99_93[7] = 115;
    byte[] tmp105_99 = tmp99_93;
    tmp105_99[8] = 104;
    tmp105_99;
    byte[] arrayOfByte2 = new byte[9];
    byte[] tmp120_118 = arrayOfByte2;
    tmp120_118[0] = 0;
    byte[] tmp125_120 = tmp120_118;
    tmp125_120[1] = 0;
    byte[] tmp130_125 = tmp125_120;
    tmp130_125[2] = 1;
    byte[] tmp135_130 = tmp130_125;
    tmp135_130[3] = 0;
    byte[] tmp140_135 = tmp135_130;
    tmp140_135[4] = 0;
    byte[] tmp145_140 = tmp140_135;
    tmp145_140[5] = 0;
    byte[] tmp150_145 = tmp145_140;
    tmp150_145[6] = 0;
    byte[] tmp156_150 = tmp150_145;
    tmp156_150[7] = 0;
    byte[] tmp162_156 = tmp156_150;
    tmp162_156[8] = 0;
    tmp162_156;
    try
    {
      Utils.startRootJava(new Object() {});
      localObject = new File("/data/data/com.maxmpz.audioplayer/databases/folders.db");
      if (((File)localObject).exists()) {
        break label215;
      }
      throw new FileNotFoundException();
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    Utils.exitFromRootJava();
    return;
    label215:
    Object localObject = new RandomAccessFile((File)localObject, "rw").getChannel();
    MappedByteBuffer localMappedByteBuffer = ((FileChannel)localObject).map(FileChannel.MapMode.READ_WRITE, 0L, (int)((FileChannel)localObject).size());
    long l = 0L;
    for (;;)
    {
      int i;
      int j;
      try
      {
        if (localMappedByteBuffer.hasRemaining())
        {
          int k = localMappedByteBuffer.position();
          i = localMappedByteBuffer.get();
          if (i == paramArrayOfString[0])
          {
            if (arrayOfByte2[0] == 0) {
              arrayOfByte1[0] = i;
            }
            j = 1;
            localMappedByteBuffer.position(k + 1);
            i = localMappedByteBuffer.get();
            break label412;
            j += 1;
            if (j == paramArrayOfString.length)
            {
              localMappedByteBuffer.position(k);
              localMappedByteBuffer.put(arrayOfByte1);
              localMappedByteBuffer.force();
              localMappedByteBuffer.position(k + 1);
            }
          }
          else
          {
            localMappedByteBuffer.position(k + 1);
            l += 1L;
            continue;
          }
          i = localMappedByteBuffer.get();
        }
      }
      catch (Exception paramArrayOfString)
      {
        System.out.println("" + paramArrayOfString);
        ((FileChannel)localObject).close();
      }
      break;
      label412:
      if (i != paramArrayOfString[j])
      {
        if (new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 }[j] != 1) {}
      }
      else if (arrayOfByte2[j] == 0) {
        arrayOfByte1[j] = i;
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/pa2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */