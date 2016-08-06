package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class liverunpatchlib
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    Object localObject1 = paramArrayOfString[1].split(" ");
    Object localObject2 = paramArrayOfString[2].split(" ");
    byte[] arrayOfByte1 = new byte[localObject1.length];
    byte[] arrayOfByte2 = new byte[localObject2.length];
    byte[] arrayOfByte3 = new byte[localObject1.length];
    byte[] arrayOfByte4 = new byte[localObject2.length];
    int j = 0;
    int m;
    int k;
    if ((arrayOfByte4.length == arrayOfByte3.length) && (arrayOfByte1.length == arrayOfByte2.length) && (arrayOfByte2.length > 3) && (arrayOfByte1.length > 3))
    {
      m = 0;
      if (m < localObject1.length)
      {
        k = j;
        if (localObject1[m].contains("*"))
        {
          k = j;
          if (!localObject1[m].contains("**"))
          {
            k = 1;
            localObject1[m] = "00";
          }
        }
        j = k;
        if (localObject2[m].contains("*"))
        {
          j = k;
          if (!localObject2[m].contains("**"))
          {
            j = 1;
            localObject2[m] = "00";
          }
        }
        if (localObject1[m].contains("**"))
        {
          localObject1[m] = "00";
          arrayOfByte3[m] = 1;
          label207:
          arrayOfByte1[m] = Integer.valueOf(localObject1[m], 16).byteValue();
          if (!localObject2[m].contains("**")) {
            break label287;
          }
          localObject2[m] = "00";
          arrayOfByte4[m] = 0;
        }
        for (;;)
        {
          arrayOfByte2[m] = Integer.valueOf(localObject2[m], 16).byteValue();
          m += 1;
          break;
          arrayOfByte3[m] = 0;
          break label207;
          label287:
          arrayOfByte4[m] = 1;
        }
      }
      if (j == 0) {
        localObject2 = paramArrayOfString[0];
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new File((String)localObject2);
        paramArrayOfString = new File(((String)localObject2).replace("/data/data/", "/mnt/asec/"));
        if (((File)localObject1).exists()) {
          paramArrayOfString = (String[])localObject1;
        }
        localObject1 = paramArrayOfString;
        if (!paramArrayOfString.exists()) {
          localObject1 = new File((String)localObject2 + "-1");
        }
        paramArrayOfString = (String[])localObject1;
        if (!((File)localObject1).exists()) {
          paramArrayOfString = new File(((String)localObject2).replace("-1", "-2"));
        }
        if (!paramArrayOfString.exists()) {
          throw new FileNotFoundException();
        }
      }
      catch (FileNotFoundException paramArrayOfString)
      {
        System.out.println("Error: Program files are not found!\n\nMove Program to internal storage.");
        Utils.exitFromRootJava();
        return;
        paramArrayOfString = new RandomAccessFile(paramArrayOfString, "rw").getChannel();
        localObject1 = paramArrayOfString.map(FileChannel.MapMode.READ_WRITE, 0L, (int)paramArrayOfString.size());
        j = 0;
        long l = 0L;
        k = j;
        m = j;
        try
        {
          if (((MappedByteBuffer)localObject1).hasRemaining())
          {
            k = j;
            int n = ((MappedByteBuffer)localObject1).position();
            k = j;
            i = ((MappedByteBuffer)localObject1).get();
            m = j;
            if (i == arrayOfByte1[0])
            {
              if (arrayOfByte4[0] == 0) {
                arrayOfByte2[0] = i;
              }
              m = 1;
              k = j;
              ((MappedByteBuffer)localObject1).position(n + 1);
              k = j;
              i = ((MappedByteBuffer)localObject1).get();
              k = m;
              break label754;
              m = k + 1;
              k = j;
              if (m == arrayOfByte1.length)
              {
                k = j;
                ((MappedByteBuffer)localObject1).position(n);
                k = j;
                ((MappedByteBuffer)localObject1).put(arrayOfByte2);
                k = j;
                ((MappedByteBuffer)localObject1).force();
                k = j;
                System.out.println("Offset in file:" + Integer.toHexString(n) + " - Patch done!\n");
                m = 1;
              }
            }
            else
            {
              k = m;
              ((MappedByteBuffer)localObject1).position(n + 1);
              l += 1L;
              j = m;
              continue;
            }
            k = j;
            i = ((MappedByteBuffer)localObject1).get();
            k = m;
          }
        }
        catch (Exception localException)
        {
          System.out.println("" + localException);
          m = k;
          paramArrayOfString.close();
        }
        if (m != 0) {
          continue;
        }
        System.out.println("Error: Pattern not found!\nor patch is already applied?!\n");
        continue;
      }
      catch (Exception paramArrayOfString)
      {
        continue;
      }
      System.out.println("Error: Pattern not valid!\n\nPattern can not be \"*4\" or \"A*\", etc.\n\n It can only be ** ");
      continue;
      System.out.println("Error: Original & Replace hex-string not valid!\n\nOriginal.hex.length != Replacmant.hex.length.\nOR\nLength of hex-string < 4");
      continue;
      label754:
      if (i != arrayOfByte1[k])
      {
        m = j;
        if (arrayOfByte3[k] != 1) {}
      }
      else if (arrayOfByte4[k] == 0)
      {
        arrayOfByte2[k] = i;
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/liverunpatchlib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */