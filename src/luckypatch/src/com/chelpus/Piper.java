package com.chelpus;

import java.io.InputStream;
import java.io.OutputStream;

class Piper
  implements Runnable
{
  private InputStream input;
  private OutputStream output;
  
  public Piper(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this.input = paramInputStream;
    this.output = paramOutputStream;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: sipush 512
    //   3: newarray <illegal type>
    //   5: astore_3
    //   6: iconst_1
    //   7: istore_1
    //   8: iload_1
    //   9: iconst_m1
    //   10: if_icmple +57 -> 67
    //   13: aload_0
    //   14: getfield 17	com/chelpus/Piper:input	Ljava/io/InputStream;
    //   17: aload_3
    //   18: iconst_0
    //   19: aload_3
    //   20: arraylength
    //   21: invokevirtual 29	java/io/InputStream:read	([BII)I
    //   24: istore_2
    //   25: iload_2
    //   26: istore_1
    //   27: iload_2
    //   28: iconst_m1
    //   29: if_icmple -21 -> 8
    //   32: aload_0
    //   33: getfield 19	com/chelpus/Piper:output	Ljava/io/OutputStream;
    //   36: aload_3
    //   37: iconst_0
    //   38: iload_2
    //   39: invokevirtual 35	java/io/OutputStream:write	([BII)V
    //   42: iload_2
    //   43: istore_1
    //   44: goto -36 -> 8
    //   47: astore_3
    //   48: aload_3
    //   49: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   52: aload_0
    //   53: getfield 17	com/chelpus/Piper:input	Ljava/io/InputStream;
    //   56: invokevirtual 41	java/io/InputStream:close	()V
    //   59: aload_0
    //   60: getfield 19	com/chelpus/Piper:output	Ljava/io/OutputStream;
    //   63: invokevirtual 42	java/io/OutputStream:close	()V
    //   66: return
    //   67: aload_0
    //   68: getfield 17	com/chelpus/Piper:input	Ljava/io/InputStream;
    //   71: invokevirtual 41	java/io/InputStream:close	()V
    //   74: aload_0
    //   75: getfield 19	com/chelpus/Piper:output	Ljava/io/OutputStream;
    //   78: invokevirtual 42	java/io/OutputStream:close	()V
    //   81: return
    //   82: astore_3
    //   83: return
    //   84: astore_3
    //   85: aload_0
    //   86: getfield 17	com/chelpus/Piper:input	Ljava/io/InputStream;
    //   89: invokevirtual 41	java/io/InputStream:close	()V
    //   92: aload_0
    //   93: getfield 19	com/chelpus/Piper:output	Ljava/io/OutputStream;
    //   96: invokevirtual 42	java/io/OutputStream:close	()V
    //   99: aload_3
    //   100: athrow
    //   101: astore 4
    //   103: goto -4 -> 99
    //   106: astore 4
    //   108: goto -16 -> 92
    //   111: astore_3
    //   112: return
    //   113: astore_3
    //   114: goto -55 -> 59
    //   117: astore_3
    //   118: goto -44 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	Piper
    //   7	37	1	i	int
    //   24	19	2	j	int
    //   5	32	3	arrayOfByte	byte[]
    //   47	2	3	localException1	Exception
    //   82	1	3	localException2	Exception
    //   84	16	3	localObject	Object
    //   111	1	3	localException3	Exception
    //   113	1	3	localException4	Exception
    //   117	1	3	localException5	Exception
    //   101	1	4	localException6	Exception
    //   106	1	4	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   0	6	47	java/lang/Exception
    //   13	25	47	java/lang/Exception
    //   32	42	47	java/lang/Exception
    //   74	81	82	java/lang/Exception
    //   0	6	84	finally
    //   13	25	84	finally
    //   32	42	84	finally
    //   48	52	84	finally
    //   92	99	101	java/lang/Exception
    //   85	92	106	java/lang/Exception
    //   59	66	111	java/lang/Exception
    //   52	59	113	java/lang/Exception
    //   67	74	117	java/lang/Exception
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/Piper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */