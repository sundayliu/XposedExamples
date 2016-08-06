package com.chelpus;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.vending.billing.InAppBillingService.LACK.AddFilesItem;
import com.android.vending.billing.InAppBillingService.LACK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LACK.BindItem;
import com.android.vending.billing.InAppBillingService.LACK.CommandItem;
import com.android.vending.billing.InAppBillingService.LACK.FileApkListItem;
import com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface;
import com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface.Stub;
import com.android.vending.billing.InAppBillingService.LACK.Mount;
import com.android.vending.billing.InAppBillingService.LACK.PatchesItemAuto;
import com.android.vending.billing.InAppBillingService.LACK.ShellOnMainThreadException;
import com.android.vending.billing.InAppBillingService.LACK.StringItem;
import com.android.vending.billing.InAppBillingService.LACK.TypesItem;
import com.android.vending.billing.InAppBillingService.LACK.dialogs.Progress_Dialog_Loading;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.android.vending.billing.InAppBillingService.LACK.patchActivity;
import com.google.android.finsky.billing.iab.google.util.Base64;
import dalvik.system.DexFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import kellinwood.zipio.ZioEntry;
import kellinwood.zipio.ZipInput;
import org.json.JSONException;
import org.json.JSONObject;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZInputStream;
import org.tukaani.xz.XZOutputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Utils
{
  static final String AB = "abcdefghijklmnopqrstuvwxyz";
  static final String AB2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  private static final String LIB_ART = "libart.so";
  private static final String LIB_ART_D = "libartd.so";
  private static final String LIB_DALVIK = "libdvm.so";
  public static final String ROOT_NOT_FOUND = "lucky patcher root not found!";
  private static final String SELECT_RUNTIME_PROPERTY = "persist.sys.dalvik.vm.lib";
  protected static final char[] hexArray;
  private static String internalBusybox;
  static ITestServiceInterface mService = null;
  static ServiceConnection mServiceConn;
  public static String pattern_check = "297451286";
  static Random rnd = new Random();
  float folder_size = 0.0F;
  
  static
  {
    internalBusybox = "";
    hexArray = "0123456789ABCDEF".toCharArray();
    mServiceConn = null;
  }
  
  public Utils(String paramString) {}
  
  public static boolean XZCompress(File paramFile1, File paramFile2)
    throws OutOfMemoryError
  {
    try
    {
      paramFile1 = new FileInputStream(paramFile1);
      XZOutputStream localXZOutputStream = new XZOutputStream(new FileOutputStream(paramFile2), new LZMA2Options());
      byte[] arrayOfByte = new byte['ࠀ'];
      for (;;)
      {
        int i = paramFile1.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localXZOutputStream.write(arrayOfByte, 0, i);
      }
      return false;
    }
    catch (FileNotFoundException paramFile1)
    {
      System.out.println("File not found for xz compress.");
      paramFile1.printStackTrace();
      do
      {
        return false;
        localXZOutputStream.finish();
      } while (!paramFile2.exists());
      return true;
    }
    catch (UnsupportedOptionsException paramFile1)
    {
      System.out.println("Unsupported options for xz compress.");
      paramFile1.printStackTrace();
      return false;
    }
    catch (IOException paramFile1)
    {
      System.out.println("IO Error for xz compress.");
      paramFile1.printStackTrace();
      return false;
    }
    catch (Exception paramFile1)
    {
      paramFile1.printStackTrace();
    }
  }
  
  public static boolean XZDecompress(File paramFile, String paramString)
  {
    byte[] arrayOfByte = new byte['ࠀ'];
    String str2 = null;
    String str3 = null;
    String str1 = null;
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (localFile.isFile()))
    {
      if (localFile.isFile()) {
        localFile.delete();
      }
      localFile.mkdirs();
    }
    if (!localFile.exists())
    {
      System.out.println("not found dir for ectract xz.");
      return false;
    }
    if (paramString.endsWith("/")) {
      localFile = new File(paramString + removeExtension(paramFile.getName()));
    }
    try
    {
      paramString = paramFile.getAbsolutePath();
      str1 = paramString;
      str2 = paramString;
      str3 = paramString;
      paramFile = new XZInputStream(new FileInputStream(paramFile));
      str1 = paramString;
      str2 = paramString;
      str3 = paramString;
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      for (;;)
      {
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        int i = paramFile.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (FileNotFoundException paramFile)
    {
      for (;;)
      {
        System.err.println("XZDec: Cannot open " + str1 + ": " + paramFile.getMessage());
        localFile.delete();
        return false;
        localFile = new File(paramString + "/" + removeExtension(paramFile.getName()));
      }
    }
    catch (EOFException paramFile)
    {
      System.err.println("XZDec: Unexpected end of input on " + str2);
      localFile.delete();
      return false;
    }
    catch (IOException paramFile)
    {
      System.err.println("XZDec: Error decompressing from " + str3 + ": " + paramFile.getMessage());
      localFile.delete();
      return false;
    }
    if (localFile.exists()) {
      return true;
    }
    localFile.delete();
    return false;
  }
  
  public static final void activityToFront()
  {
    Intent localIntent = new Intent(listAppsFragment.frag.getContext(), listAppsFragment.frag.getActivity().getClass());
    localIntent.setFlags(131072);
    listAppsFragment.frag.getContext().startActivity(localIntent);
  }
  
  public static void addFileToList(File paramFile, ArrayList<File> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      i = 0;
      localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((File)localIterator.next()).length() == paramFile.length()) {
          i = 1;
        }
      }
      if (i == 0) {
        paramArrayList.add(paramFile);
      }
    }
    while (paramArrayList == null)
    {
      int i;
      Iterator localIterator;
      return;
    }
    paramArrayList.add(paramFile);
  }
  
  public static void addFilesToZip(String paramString1, String paramString2, ArrayList<AddFilesItem> paramArrayList)
    throws IOException
  {
    paramString1 = ZipInput.read(paramString1);
    JarOutputStream localJarOutputStream = new JarOutputStream(new FileOutputStream(paramString2));
    Iterator localIterator = paramString1.getEntries().values().iterator();
    while (localIterator.hasNext())
    {
      ZioEntry localZioEntry = (ZioEntry)localIterator.next();
      try
      {
        if (localZioEntry.getCompression() != 0) {
          break label523;
        }
        paramString1 = new JarEntry(localZioEntry.getName());
        paramString2 = paramString1;
        try
        {
          paramString1.setMethod(0);
          i = 0;
          paramString2 = paramString1;
          localObject1 = paramArrayList.iterator();
          for (;;)
          {
            paramString2 = paramString1;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramString2 = paramString1;
            Object localObject2 = (AddFilesItem)((Iterator)localObject1).next();
            paramString2 = paramString1;
            bool = localZioEntry.getName().equals(((AddFilesItem)localObject2).fileName.replace(((AddFilesItem)localObject2).basePath, ""));
            if (bool) {
              try
              {
                localObject3 = new File(((AddFilesItem)localObject2).fileName);
                paramString2 = new byte[(int)((File)localObject3).length()];
                localObject2 = new FileInputStream(((AddFilesItem)localObject2).fileName);
                ((FileInputStream)localObject2).read(paramString2);
                ((FileInputStream)localObject2).close();
                paramString1.setCompressedSize(((File)localObject3).length());
                paramString1.setSize(((File)localObject3).length());
                localObject2 = new CRC32();
                ((CRC32)localObject2).update(paramString2);
                paramString1.setCrc(((CRC32)localObject2).getValue());
                paramString1.setTime(localZioEntry.getTime());
                i = 1;
              }
              catch (Exception localException2)
              {
                paramString2 = paramString1;
                System.out.println(localException2);
              }
            }
          }
          System.out.println(paramString1);
        }
        catch (Exception paramString1) {}
      }
      catch (Exception paramString1)
      {
        int i;
        Object localObject1;
        boolean bool;
        Object localObject3;
        for (;;) {}
      }
      paramString1.printStackTrace();
      continue;
      if (i == 0)
      {
        paramString2 = paramString1;
        paramString1.setCompressedSize(localZioEntry.getSize());
        paramString2 = paramString1;
        paramString1.setSize(localZioEntry.getSize());
        paramString2 = paramString1;
        localObject1 = new CRC32();
        paramString2 = paramString1;
        ((CRC32)localObject1).update(localZioEntry.getData());
        paramString2 = paramString1;
        paramString1.setCrc(((CRC32)localObject1).getValue());
        paramString2 = paramString1;
        paramString1.setTime(localZioEntry.getTime());
      }
      i = 0;
      paramString2 = paramArrayList.iterator();
      for (;;)
      {
        if (!paramString2.hasNext()) {
          break label626;
        }
        localObject1 = (AddFilesItem)paramString2.next();
        bool = localZioEntry.getName().equals(((AddFilesItem)localObject1).fileName.replace(((AddFilesItem)localObject1).basePath, ""));
        if (bool)
        {
          int j = i;
          File localFile;
          FileInputStream localFileInputStream;
          try
          {
            localFile = new File(((AddFilesItem)localObject1).fileName);
            j = i;
            localObject3 = new byte[' '];
            j = i;
            localFileInputStream = new FileInputStream(((AddFilesItem)localObject1).fileName);
            j = i;
            localJarOutputStream.putNextEntry(paramString1);
            for (;;)
            {
              j = i;
              k = localFileInputStream.read((byte[])localObject3);
              if (k <= 0) {
                break;
              }
              j = i;
              localJarOutputStream.write((byte[])localObject3, 0, k);
            }
          }
          catch (Exception localException1)
          {
            System.out.println(localException1);
            i = j;
          }
          label523:
          paramString1 = new JarEntry(localZioEntry.getName());
          paramString2 = paramString1;
          paramString1.setTime(localZioEntry.getTime());
          paramString2 = paramString1;
          paramString1.setMethod(localZioEntry.getCompression());
          break;
          j = i;
          localJarOutputStream.flush();
          j = i;
          localFileInputStream.close();
          int k = 1;
          i = 1;
          j = k;
          localFile.delete();
          j = k;
          System.out.println("LuckyPatcher (signer): Additional files added! " + localException1);
        }
      }
      label626:
      if (i == 0)
      {
        localJarOutputStream.putNextEntry(paramString1);
        paramString1 = localZioEntry.getInputStream();
        paramString2 = new byte[' '];
        for (;;)
        {
          i = paramString1.read(paramString2);
          if (i <= 0) {
            break;
          }
          localJarOutputStream.write(paramString2, 0, i);
        }
        localJarOutputStream.flush();
      }
    }
    localJarOutputStream.close();
  }
  
  public static void afterPatch(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    System.out.println("uid:" + paramString4);
    if ((paramString1.contains("copyDC")) || (paramString1.contains("deleteDC")))
    {
      paramString5 = getFileDalvikCache(paramString2);
      if (paramString5 == null) {
        break label242;
      }
      paramString5.delete();
      if (paramString1.contains("copyDC"))
      {
        copyFile(new File(paramString3), paramString5);
        if ((paramString5.exists()) && (paramString5.length() == new File(paramString3).length()))
        {
          new File(paramString3).delete();
          run_all_no_root(new String[] { "chmod", "644", paramString5.getAbsolutePath() });
          run_all_no_root(new String[] { "chown", "1000:" + paramString4, paramString5.getAbsolutePath() });
          run_all_no_root(new String[] { "chown", "1000." + paramString4, paramString5.getAbsolutePath() });
        }
      }
    }
    label242:
    do
    {
      do
      {
        return;
      } while (!paramString1.contains("copyDC"));
      paramString1 = getFileDalvikCacheName(paramString2);
      copyFile(new File(paramString3), paramString1);
    } while ((!paramString1.exists()) || (paramString1.length() != new File(paramString3).length()));
    new File(paramString3).delete();
    run_all_no_root(new String[] { "chmod", "644", paramString1.getAbsolutePath() });
    run_all_no_root(new String[] { "chown", "1000:" + paramString4, paramString1.getAbsolutePath() });
    run_all_no_root(new String[] { "chown", "1000." + paramString4, paramString1.getAbsolutePath() });
  }
  
  public static String apply_TAGS(String paramString1, String paramString2)
  {
    return paramString1.replaceAll("%PACKAGE_NAME%", paramString2);
  }
  
  public static String bytesToHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = hexArray[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = hexArray[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static final void calcChecksum(File paramFile)
  {
    File localFile2 = null;
    localObject = null;
    File localFile1 = null;
    try
    {
      paramFile = new RandomAccessFile(paramFile, "rw").getChannel();
      localFile1 = paramFile;
      localFile2 = paramFile;
      localObject = paramFile;
      MappedByteBuffer localMappedByteBuffer = paramFile.map(FileChannel.MapMode.READ_WRITE, 0L, (int)paramFile.size());
      localFile1 = paramFile;
      localFile2 = paramFile;
      localObject = paramFile;
      Adler32 localAdler32 = new Adler32();
      localFile1 = paramFile;
      localFile2 = paramFile;
      localObject = paramFile;
      localMappedByteBuffer.position(12);
      for (;;)
      {
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        if (!localMappedByteBuffer.hasRemaining()) {
          break;
        }
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localAdler32.update(localMappedByteBuffer.get());
      }
      try
      {
        int i;
        ((FileChannel)localObject).close();
        throw paramFile;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    catch (FileNotFoundException paramFile)
    {
      localObject = localFile1;
      paramFile.printStackTrace();
      if (localFile1 != null) {}
      do
      {
        try
        {
          localFile1.close();
          return;
        }
        catch (IOException paramFile)
        {
          paramFile.printStackTrace();
          return;
        }
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        i = (int)localAdler32.getValue();
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.position(8);
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.put((byte)i);
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.force();
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.position(9);
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.put((byte)(i >> 8));
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.force();
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.position(10);
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.put((byte)(i >> 16));
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.force();
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.position(11);
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.put((byte)(i >> 24));
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        localMappedByteBuffer.force();
        localFile1 = paramFile;
        localFile2 = paramFile;
        localObject = paramFile;
        paramFile.close();
      } while (paramFile == null);
      try
      {
        paramFile.close();
        return;
      }
      catch (IOException paramFile)
      {
        paramFile.printStackTrace();
        return;
      }
    }
    catch (IOException paramFile)
    {
      do
      {
        localObject = localFile2;
        paramFile.printStackTrace();
      } while (localFile2 == null);
      try
      {
        localFile2.close();
        return;
      }
      catch (IOException paramFile)
      {
        paramFile.printStackTrace();
        return;
      }
    }
    finally
    {
      if (localObject == null) {}
    }
  }
  
  private static void calcChecksumOdexFly(int paramInt1, int paramInt2, File paramFile)
  {
    try
    {
      paramFile = new RandomAccessFile(paramFile, "rw").getChannel();
      MappedByteBuffer localMappedByteBuffer = paramFile.map(FileChannel.MapMode.READ_WRITE, 0L, (int)paramFile.size());
      Adler32 localAdler32 = new Adler32();
      localMappedByteBuffer.position(paramInt1 + 12);
      while (paramInt2 > 0)
      {
        localAdler32.update(localMappedByteBuffer.get());
        paramInt2 -= 1;
      }
      paramInt2 = (int)localAdler32.getValue();
      localMappedByteBuffer.position(paramInt1 + 8);
      localMappedByteBuffer.put((byte)paramInt2);
      localMappedByteBuffer.force();
      localMappedByteBuffer.position(paramInt1 + 9);
      localMappedByteBuffer.put((byte)(paramInt2 >> 8));
      localMappedByteBuffer.force();
      localMappedByteBuffer.position(paramInt1 + 10);
      localMappedByteBuffer.put((byte)(paramInt2 >> 16));
      localMappedByteBuffer.force();
      localMappedByteBuffer.position(paramInt1 + 11);
      localMappedByteBuffer.put((byte)(paramInt2 >> 24));
      localMappedByteBuffer.force();
      paramFile.close();
      return;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
      return;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  private static final void calcSignature(File paramFile)
  {
    MappedByteBuffer localMappedByteBuffer;
    byte[] arrayOfByte;
    try
    {
      paramFile = new RandomAccessFile(paramFile, "rw").getChannel();
      localMappedByteBuffer = paramFile.map(FileChannel.MapMode.READ_WRITE, 0L, (int)paramFile.size());
      try
      {
        MessageDigest localMessageDigest;
        int i = localMessageDigest.digest(arrayOfByte, 0, 20);
        if (i != 20) {
          throw new RuntimeException("unexpected digest write:" + i + "bytes");
        }
      }
      catch (DigestException paramFile)
      {
        throw new RuntimeException(paramFile);
      }
    }
    catch (FileNotFoundException paramFile)
    {
      try
      {
        localMessageDigest = MessageDigest.getInstance("SHA-1");
        arrayOfByte = new byte[20];
        localMappedByteBuffer.position(32);
        while (localMappedByteBuffer.hasRemaining())
        {
          localMessageDigest.update(localMappedByteBuffer.get());
          continue;
          paramFile = paramFile;
          paramFile.printStackTrace();
          return;
        }
      }
      catch (NoSuchAlgorithmException paramFile)
      {
        throw new RuntimeException(paramFile);
      }
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
      return;
    }
    localMappedByteBuffer.position(12);
    localMappedByteBuffer.put(arrayOfByte);
    localMappedByteBuffer.force();
    paramFile.close();
  }
  
  public static String changeExtension(String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString1 != null)
    {
      String[] arrayOfString = paramString1.split("\\.");
      int i = 0;
      paramString1 = str2;
      str1 = paramString1;
      if (i < arrayOfString.length)
      {
        if (i < arrayOfString.length - 1) {}
        for (paramString1 = paramString1 + arrayOfString[i] + ".";; paramString1 = paramString1 + paramString2)
        {
          i += 1;
          break;
        }
      }
    }
    return str1;
  }
  
  /* Error */
  public static int changePackageNameIds(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 208	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 585
    //   10: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: aload_1
    //   14: ldc_w 575
    //   17: ldc -54
    //   19: invokevirtual 475	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 14
    //   30: new 208	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 585
    //   40: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_2
    //   44: ldc_w 575
    //   47: ldc -54
    //   49: invokevirtual 475	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 15
    //   60: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   63: new 208	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   70: aload 14
    //   72: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 587
    //   78: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 15
    //   83: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   92: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   95: new 208	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   102: ldc_w 589
    //   105: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   118: iconst_0
    //   119: istore 7
    //   121: iconst_0
    //   122: istore 6
    //   124: iconst_0
    //   125: istore 8
    //   127: iconst_0
    //   128: istore 9
    //   130: iconst_0
    //   131: istore 5
    //   133: iconst_3
    //   134: anewarray 92	java/lang/String
    //   137: dup
    //   138: iconst_0
    //   139: ldc_w 453
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: ldc_w 591
    //   148: aastore
    //   149: dup
    //   150: iconst_2
    //   151: aload_0
    //   152: aastore
    //   153: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   156: new 290	java/util/ArrayList
    //   159: dup
    //   160: invokespecial 592	java/util/ArrayList:<init>	()V
    //   163: pop
    //   164: iload 7
    //   166: istore_3
    //   167: aload_0
    //   168: ifnull +753 -> 921
    //   171: iload 7
    //   173: istore_3
    //   174: iload 9
    //   176: istore 4
    //   178: new 171	java/io/File
    //   181: dup
    //   182: aload_0
    //   183: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   186: invokevirtual 175	java/io/File:exists	()Z
    //   189: ifeq +732 -> 921
    //   192: iload 9
    //   194: istore 4
    //   196: new 171	java/io/File
    //   199: dup
    //   200: aload_0
    //   201: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: invokevirtual 311	java/io/File:length	()J
    //   207: lstore 11
    //   209: iload 7
    //   211: istore_3
    //   212: lload 11
    //   214: lconst_0
    //   215: lcmp
    //   216: ifeq +705 -> 921
    //   219: iload 8
    //   221: istore_3
    //   222: new 171	java/io/File
    //   225: dup
    //   226: aload_0
    //   227: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   230: invokevirtual 175	java/io/File:exists	()Z
    //   233: istore 13
    //   235: iload 7
    //   237: istore_3
    //   238: iload 13
    //   240: ifeq +681 -> 921
    //   243: iload 6
    //   245: istore 4
    //   247: new 483	java/io/RandomAccessFile
    //   250: dup
    //   251: aload_0
    //   252: ldc_w 485
    //   255: invokespecial 595	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: invokevirtual 492	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   261: astore_0
    //   262: iload 6
    //   264: istore 4
    //   266: aload_0
    //   267: getstatic 498	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   270: lconst_0
    //   271: aload_0
    //   272: invokevirtual 502	java/nio/channels/FileChannel:size	()J
    //   275: l2i
    //   276: i2l
    //   277: invokevirtual 506	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   280: astore 16
    //   282: iload 6
    //   284: istore 4
    //   286: aload 16
    //   288: bipush 56
    //   290: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   293: pop
    //   294: iload 6
    //   296: istore 4
    //   298: aload 16
    //   300: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   303: aload 16
    //   305: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   308: aload 16
    //   310: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   313: aload 16
    //   315: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   318: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   321: istore 7
    //   323: iload 6
    //   325: istore 4
    //   327: aload 16
    //   329: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   332: aload 16
    //   334: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   337: aload 16
    //   339: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   342: aload 16
    //   344: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   347: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   350: istore_3
    //   351: iload 6
    //   353: istore 4
    //   355: iload 7
    //   357: iconst_4
    //   358: idiv
    //   359: newarray <illegal type>
    //   361: astore 17
    //   363: iload 6
    //   365: istore 4
    //   367: aload 16
    //   369: iload_3
    //   370: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   373: pop
    //   374: iload 6
    //   376: istore 4
    //   378: iload 7
    //   380: newarray <illegal type>
    //   382: astore 17
    //   384: iconst_0
    //   385: istore_3
    //   386: iload_3
    //   387: iload 7
    //   389: if_icmpge +41 -> 430
    //   392: iload 6
    //   394: istore 4
    //   396: aload 17
    //   398: iload_3
    //   399: aload 16
    //   401: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   404: aload 16
    //   406: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   409: aload 16
    //   411: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   414: aload 16
    //   416: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   419: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   422: iastore
    //   423: iload_3
    //   424: iconst_1
    //   425: iadd
    //   426: istore_3
    //   427: goto -41 -> 386
    //   430: iload 6
    //   432: istore 4
    //   434: aload 17
    //   436: arraylength
    //   437: istore 7
    //   439: iconst_0
    //   440: istore 6
    //   442: iload 5
    //   444: istore_3
    //   445: iload 6
    //   447: iload 7
    //   449: if_icmpge +465 -> 914
    //   452: aload 17
    //   454: iload 6
    //   456: iaload
    //   457: istore 8
    //   459: iload_3
    //   460: istore 4
    //   462: aload 16
    //   464: iload 8
    //   466: invokevirtual 602	java/nio/MappedByteBuffer:get	(I)B
    //   469: invokestatic 606	com/chelpus/Utils:convertByteToInt	(B)I
    //   472: istore 9
    //   474: iload_3
    //   475: istore 4
    //   477: iload 9
    //   479: newarray <illegal type>
    //   481: astore 18
    //   483: iload 8
    //   485: iconst_1
    //   486: iadd
    //   487: istore 10
    //   489: iload_3
    //   490: istore 4
    //   492: aload 16
    //   494: iload 10
    //   496: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   499: pop
    //   500: iconst_0
    //   501: istore 5
    //   503: iload_3
    //   504: istore 4
    //   506: iload 5
    //   508: aload 18
    //   510: arraylength
    //   511: if_icmpge +25 -> 536
    //   514: iload_3
    //   515: istore 4
    //   517: aload 18
    //   519: iload 5
    //   521: aload 16
    //   523: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   526: bastore
    //   527: iload 5
    //   529: iconst_1
    //   530: iadd
    //   531: istore 5
    //   533: goto -30 -> 503
    //   536: iload_3
    //   537: istore 5
    //   539: iload_3
    //   540: istore 4
    //   542: iload 9
    //   544: aload_2
    //   545: invokevirtual 608	java/lang/String:length	()I
    //   548: if_icmplt +168 -> 716
    //   551: iload_3
    //   552: istore 5
    //   554: iload_3
    //   555: istore 4
    //   557: new 92	java/lang/String
    //   560: dup
    //   561: aload 18
    //   563: invokespecial 610	java/lang/String:<init>	([B)V
    //   566: aload_1
    //   567: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   570: ifeq +146 -> 716
    //   573: iload_3
    //   574: istore 4
    //   576: new 92	java/lang/String
    //   579: dup
    //   580: aload 18
    //   582: invokespecial 610	java/lang/String:<init>	([B)V
    //   585: aload_1
    //   586: aload_2
    //   587: invokevirtual 475	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   590: invokevirtual 613	java/lang/String:getBytes	()[B
    //   593: astore 19
    //   595: iload_3
    //   596: istore 5
    //   598: iload_3
    //   599: istore 4
    //   601: aload 19
    //   603: arraylength
    //   604: iload 9
    //   606: if_icmpgt +110 -> 716
    //   609: iload_3
    //   610: istore 4
    //   612: aload 16
    //   614: iload 8
    //   616: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   619: pop
    //   620: iload_3
    //   621: istore 4
    //   623: aload 16
    //   625: aload 19
    //   627: arraylength
    //   628: i2b
    //   629: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   632: pop
    //   633: iload_3
    //   634: istore 4
    //   636: aload 16
    //   638: iload 10
    //   640: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   643: pop
    //   644: iload_3
    //   645: istore 4
    //   647: aload 16
    //   649: aload 19
    //   651: invokevirtual 572	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   654: pop
    //   655: iload_3
    //   656: istore 4
    //   658: aload 16
    //   660: iconst_0
    //   661: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   664: pop
    //   665: iload_3
    //   666: istore 4
    //   668: aload 16
    //   670: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   673: pop
    //   674: iload_3
    //   675: istore 4
    //   677: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   680: new 208	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   687: ldc_w 615
    //   690: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: new 92	java/lang/String
    //   696: dup
    //   697: aload 18
    //   699: invokespecial 610	java/lang/String:<init>	([B)V
    //   702: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   711: iload_3
    //   712: iconst_1
    //   713: iadd
    //   714: istore 5
    //   716: iload 5
    //   718: istore 4
    //   720: iload 5
    //   722: istore_3
    //   723: iload 9
    //   725: aload 14
    //   727: invokevirtual 608	java/lang/String:length	()I
    //   730: if_icmplt +225 -> 955
    //   733: iload 5
    //   735: istore 4
    //   737: iload 5
    //   739: istore_3
    //   740: new 92	java/lang/String
    //   743: dup
    //   744: aload 18
    //   746: invokespecial 610	java/lang/String:<init>	([B)V
    //   749: aload 14
    //   751: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   754: ifeq +201 -> 955
    //   757: iload 5
    //   759: istore 4
    //   761: new 92	java/lang/String
    //   764: dup
    //   765: aload 18
    //   767: invokespecial 610	java/lang/String:<init>	([B)V
    //   770: aload 14
    //   772: aload 15
    //   774: invokevirtual 475	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   777: invokevirtual 613	java/lang/String:getBytes	()[B
    //   780: astore 19
    //   782: iload 5
    //   784: istore 4
    //   786: iload 5
    //   788: istore_3
    //   789: aload 19
    //   791: arraylength
    //   792: iload 9
    //   794: if_icmpgt +161 -> 955
    //   797: iload 5
    //   799: istore 4
    //   801: aload 16
    //   803: iload 8
    //   805: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   808: pop
    //   809: iload 5
    //   811: istore 4
    //   813: aload 16
    //   815: aload 19
    //   817: arraylength
    //   818: i2b
    //   819: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   822: pop
    //   823: iload 5
    //   825: istore 4
    //   827: aload 16
    //   829: iload 10
    //   831: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   834: pop
    //   835: iload 5
    //   837: istore 4
    //   839: aload 16
    //   841: aload 19
    //   843: invokevirtual 572	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   846: pop
    //   847: iload 5
    //   849: istore 4
    //   851: aload 16
    //   853: iconst_0
    //   854: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   857: pop
    //   858: iload 5
    //   860: istore 4
    //   862: aload 16
    //   864: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   867: pop
    //   868: iload 5
    //   870: istore 4
    //   872: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   875: new 208	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   882: ldc_w 615
    //   885: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: new 92	java/lang/String
    //   891: dup
    //   892: aload 18
    //   894: invokespecial 610	java/lang/String:<init>	([B)V
    //   897: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   906: iload 5
    //   908: iconst_1
    //   909: iadd
    //   910: istore_3
    //   911: goto +44 -> 955
    //   914: iload_3
    //   915: istore 4
    //   917: aload_0
    //   918: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   921: iload_3
    //   922: ireturn
    //   923: astore_0
    //   924: iload 4
    //   926: istore_3
    //   927: aload_0
    //   928: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   931: iload 4
    //   933: ireturn
    //   934: astore_0
    //   935: iload_3
    //   936: istore 4
    //   938: aload_0
    //   939: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   942: iload_3
    //   943: ireturn
    //   944: astore_0
    //   945: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   948: aload_0
    //   949: invokevirtual 405	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   952: iload 4
    //   954: ireturn
    //   955: iload 6
    //   957: iconst_1
    //   958: iadd
    //   959: istore 6
    //   961: goto -516 -> 445
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	964	0	paramString1	String
    //   0	964	1	paramString2	String
    //   0	964	2	paramString3	String
    //   166	777	3	i	int
    //   176	777	4	j	int
    //   131	779	5	k	int
    //   122	838	6	m	int
    //   119	331	7	n	int
    //   125	679	8	i1	int
    //   128	667	9	i2	int
    //   487	343	10	i3	int
    //   207	6	11	l	long
    //   233	6	13	bool	boolean
    //   28	743	14	str1	String
    //   58	715	15	str2	String
    //   280	583	16	localMappedByteBuffer	MappedByteBuffer
    //   361	92	17	localObject	Object
    //   481	412	18	arrayOfByte1	byte[]
    //   593	249	19	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   247	262	923	java/lang/Exception
    //   266	282	923	java/lang/Exception
    //   286	294	923	java/lang/Exception
    //   298	323	923	java/lang/Exception
    //   327	351	923	java/lang/Exception
    //   355	363	923	java/lang/Exception
    //   367	374	923	java/lang/Exception
    //   378	384	923	java/lang/Exception
    //   396	423	923	java/lang/Exception
    //   434	439	923	java/lang/Exception
    //   462	474	923	java/lang/Exception
    //   477	483	923	java/lang/Exception
    //   492	500	923	java/lang/Exception
    //   506	514	923	java/lang/Exception
    //   517	527	923	java/lang/Exception
    //   542	551	923	java/lang/Exception
    //   557	573	923	java/lang/Exception
    //   576	595	923	java/lang/Exception
    //   601	609	923	java/lang/Exception
    //   612	620	923	java/lang/Exception
    //   623	633	923	java/lang/Exception
    //   636	644	923	java/lang/Exception
    //   647	655	923	java/lang/Exception
    //   658	665	923	java/lang/Exception
    //   668	674	923	java/lang/Exception
    //   677	711	923	java/lang/Exception
    //   723	733	923	java/lang/Exception
    //   740	757	923	java/lang/Exception
    //   761	782	923	java/lang/Exception
    //   789	797	923	java/lang/Exception
    //   801	809	923	java/lang/Exception
    //   813	823	923	java/lang/Exception
    //   827	835	923	java/lang/Exception
    //   839	847	923	java/lang/Exception
    //   851	858	923	java/lang/Exception
    //   862	868	923	java/lang/Exception
    //   872	906	923	java/lang/Exception
    //   917	921	923	java/lang/Exception
    //   222	235	934	java/lang/Exception
    //   927	931	934	java/lang/Exception
    //   178	192	944	java/lang/Exception
    //   196	209	944	java/lang/Exception
    //   938	942	944	java/lang/Exception
  }
  
  public static boolean checkBind(BindItem paramBindItem)
  {
    if (paramBindItem.TargetDir.trim().startsWith("~chelpus_disabled~")) {}
    for (;;)
    {
      return false;
      String str2 = paramBindItem.SourceDir.trim();
      String str3 = paramBindItem.TargetDir.trim();
      label66:
      String str1;
      if (!str2.endsWith("/"))
      {
        paramBindItem = str2.trim() + "/";
        if (str3.endsWith("/")) {
          break label393;
        }
        str1 = str3.trim() + "/";
        new File(str3).mkdirs();
        new File(str2).mkdirs();
        if (!new File(str3).exists()) {
          verify_and_run("mkdir", "-p '" + str3 + "'");
        }
        if (!new File(str2).exists()) {
          verify_and_run("mkdir", "-p '" + str2 + "'");
        }
      }
      try
      {
        new File(paramBindItem + "test.txt").createNewFile();
        run_all("echo '' >'" + paramBindItem + "test.txt'");
        if (!exists(str1 + "test.txt"))
        {
          new File(paramBindItem + "test.txt").delete();
          if (!exists(paramBindItem + "test.txt")) {
            continue;
          }
          run_all("rm '" + paramBindItem + "test.txt'");
          return false;
          paramBindItem = str2;
          break label66;
          label393:
          str1 = str3;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
        new File(paramBindItem + "test.txt").delete();
        if (exists(paramBindItem + "test.txt")) {
          run_all("rm '" + paramBindItem + "test.txt'");
        }
      }
    }
    return true;
  }
  
  public static boolean checkCoreJarPatch11()
  {
    try
    {
      java.security.Signature localSignature = java.security.Signature.getInstance("SHA1withRSA");
      RSAPublicKeySpec localRSAPublicKeySpec = new RSAPublicKeySpec(new BigInteger("12345678", 16), new BigInteger("11", 16));
      localSignature.initVerify(KeyFactory.getInstance("RSA").generatePublic(localRSAPublicKeySpec));
      localSignature.update("367".getBytes());
      boolean bool = localSignature.verify("123098".getBytes());
      return bool;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return false;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      return false;
    }
    catch (SignatureException localSignatureException)
    {
      return false;
    }
    catch (InvalidKeySpecException localInvalidKeySpecException)
    {
      localInvalidKeySpecException.printStackTrace();
    }
    return false;
  }
  
  public static boolean checkCoreJarPatch12()
  {
    try
    {
      java.security.Signature localSignature = java.security.Signature.getInstance("SHA1withRSA");
      RSAPublicKeySpec localRSAPublicKeySpec = new RSAPublicKeySpec(new BigInteger("12345678", 16), new BigInteger("11", 16));
      localSignature.initVerify(KeyFactory.getInstance("RSA").generatePublic(localRSAPublicKeySpec));
      localSignature.update("367".getBytes());
      boolean bool = localSignature.verify("123098".getBytes(), 1, 5);
      return bool;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return false;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      return false;
    }
    catch (SignatureException localSignatureException)
    {
      return false;
    }
    catch (InvalidKeySpecException localInvalidKeySpecException)
    {
      localInvalidKeySpecException.printStackTrace();
    }
    return false;
  }
  
  public static boolean checkCoreJarPatch20()
  {
    return MessageDigest.isEqual("12".getBytes(), "45".getBytes());
  }
  
  /* Error */
  public static boolean checkCoreJarPatch30(PackageManager paramPackageManager)
  {
    // Byte code:
    //   0: invokestatic 732	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   3: ldc_w 734
    //   6: bipush 64
    //   8: invokevirtual 740	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   11: getfield 746	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   14: iconst_0
    //   15: aaload
    //   16: invokevirtual 751	android/content/pm/Signature:toByteArray	()[B
    //   19: invokestatic 756	com/google/android/finsky/billing/iab/google/util/Base64:encode	([B)Ljava/lang/String;
    //   22: ldc_w 758
    //   25: ldc 86
    //   27: invokevirtual 475	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 5
    //   32: invokestatic 732	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   35: ldc_w 257
    //   38: invokevirtual 764	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   41: invokevirtual 767	java/lang/Package:getName	()Ljava/lang/String;
    //   44: bipush 64
    //   46: invokevirtual 740	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   49: getfield 746	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   52: iconst_0
    //   53: aaload
    //   54: invokevirtual 751	android/content/pm/Signature:toByteArray	()[B
    //   57: invokestatic 756	com/google/android/finsky/billing/iab/google/util/Base64:encode	([B)Ljava/lang/String;
    //   60: pop
    //   61: aload 5
    //   63: ldc_w 758
    //   66: ldc 86
    //   68: invokevirtual 475	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 6
    //   73: invokestatic 771	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPackages	()[Ljava/lang/String;
    //   76: astore 7
    //   78: aload 7
    //   80: ifnull +205 -> 285
    //   83: aload 7
    //   85: arraylength
    //   86: ifle +199 -> 285
    //   89: aload 7
    //   91: arraylength
    //   92: istore_3
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: iload_3
    //   97: if_icmpge +188 -> 285
    //   100: aload 7
    //   102: iload_1
    //   103: aaload
    //   104: astore 8
    //   106: aload 8
    //   108: ldc_w 734
    //   111: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: ifne +164 -> 278
    //   117: aload 8
    //   119: ldc_w 257
    //   122: invokevirtual 764	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   125: invokevirtual 767	java/lang/Package:getName	()Ljava/lang/String;
    //   128: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifne +147 -> 278
    //   134: invokestatic 732	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getPkgMng	()Landroid/content/pm/PackageManager;
    //   137: aload 8
    //   139: bipush 64
    //   141: invokevirtual 740	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   144: getfield 746	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   147: astore 9
    //   149: aload 9
    //   151: ifnull +127 -> 278
    //   154: aload 9
    //   156: arraylength
    //   157: iconst_1
    //   158: if_icmpne +120 -> 278
    //   161: aload 9
    //   163: arraylength
    //   164: istore 4
    //   166: iconst_0
    //   167: istore_2
    //   168: iload_2
    //   169: iload 4
    //   171: if_icmpge +107 -> 278
    //   174: aload 9
    //   176: iload_2
    //   177: aaload
    //   178: invokevirtual 751	android/content/pm/Signature:toByteArray	()[B
    //   181: invokestatic 756	com/google/android/finsky/billing/iab/google/util/Base64:encode	([B)Ljava/lang/String;
    //   184: ldc_w 758
    //   187: ldc 86
    //   189: invokevirtual 475	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore 10
    //   194: aload 10
    //   196: aload 5
    //   198: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +54 -> 255
    //   204: aload 10
    //   206: aload 6
    //   208: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifne +44 -> 255
    //   214: aload_0
    //   215: aload 8
    //   217: invokestatic 774	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   220: invokevirtual 779	android/content/Context:getPackageName	()Ljava/lang/String;
    //   223: invokevirtual 783	android/content/pm/PackageManager:checkSignatures	(Ljava/lang/String;Ljava/lang/String;)I
    //   226: istore_2
    //   227: iload_2
    //   228: ifne +25 -> 253
    //   231: iconst_1
    //   232: ireturn
    //   233: astore 5
    //   235: ldc_w 785
    //   238: astore 5
    //   240: goto -208 -> 32
    //   243: astore 6
    //   245: ldc_w 785
    //   248: astore 6
    //   250: goto -177 -> 73
    //   253: iconst_0
    //   254: ireturn
    //   255: iload_2
    //   256: iconst_1
    //   257: iadd
    //   258: istore_2
    //   259: goto -91 -> 168
    //   262: astore 8
    //   264: aload 8
    //   266: invokevirtual 786	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   269: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   272: ldc_w 788
    //   275: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   278: iload_1
    //   279: iconst_1
    //   280: iadd
    //   281: istore_1
    //   282: goto -187 -> 95
    //   285: iconst_0
    //   286: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramPackageManager	PackageManager
    //   94	188	1	i	int
    //   167	92	2	j	int
    //   92	6	3	k	int
    //   164	8	4	m	int
    //   30	167	5	str1	String
    //   233	1	5	localException1	Exception
    //   238	1	5	str2	String
    //   71	136	6	str3	String
    //   243	1	6	localException2	Exception
    //   248	1	6	str4	String
    //   76	25	7	arrayOfString	String[]
    //   104	112	8	str5	String
    //   262	3	8	localNameNotFoundException	PackageManager.NameNotFoundException
    //   147	28	9	arrayOfSignature	android.content.pm.Signature[]
    //   192	13	10	str6	String
    // Exception table:
    //   from	to	target	type
    //   0	32	233	java/lang/Exception
    //   32	73	243	java/lang/Exception
    //   134	149	262	android/content/pm/PackageManager$NameNotFoundException
    //   154	166	262	android/content/pm/PackageManager$NameNotFoundException
    //   174	227	262	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public static boolean checkCoreJarPatch40()
  {
    boolean bool2 = false;
    mServiceConn = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        boolean bool1 = false;
        Utils.mService = ITestServiceInterface.Stub.asInterface(paramAnonymousIBinder);
        try
        {
          boolean bool2 = Utils.mService.checkService();
          bool1 = bool2;
          System.out.println("TestService:" + bool2);
          bool1 = bool2;
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          for (;;)
          {
            paramAnonymousComponentName.printStackTrace();
          }
        }
        System.out.println("TestService:" + bool1);
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        System.out.println("Licensing service disconnected.");
        Utils.mService = null;
      }
    };
    boolean bool1 = bool2;
    if (mService == null) {}
    try
    {
      Object localObject = new Intent("com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface.BIND");
      ((Intent)localObject).setPackage("com.android.vending");
      bool1 = bool2;
      if (!listAppsFragment.getPkgMng().queryIntentServices((Intent)localObject, 0).isEmpty())
      {
        localObject = listAppsFragment.getPkgMng().queryIntentServices((Intent)localObject, 0).iterator();
        do
        {
          ResolveInfo localResolveInfo;
          do
          {
            bool1 = bool2;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
          } while (localResolveInfo.serviceInfo.packageName == null);
          bool1 = localResolveInfo.serviceInfo.packageName.equals(listAppsFragment.getInstance().getPackageName());
        } while (!bool1);
        bool1 = true;
      }
      return bool1;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean checkRoot(Boolean paramBoolean, String paramString)
  {
    internalBusybox = paramString;
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          if (!Utils.exists("/system/bin/su")) {
            break label253;
          }
          if (listAppsFragment.su)
          {
            System.out.println("LuckyPatcher: skip root test.");
            return;
          }
          String str1 = new Utils("").cmdRoot(new String[] { "stat -c %a /system/bin/su", Utils.internalBusybox + " stat -c %a /system/bin/su", "busybox stat -c %a /system/bin/su" });
          System.out.println("LuckyPatcher (chek root): get permissions " + str1 + " /system/bin/su");
          if ((!str1.contains("6755")) && (str1.matches("[0-9]")))
          {
            System.out.println("LuckyPatcher (chek root): Permissions /system/bin/su not correct.");
            Utils.remount("/system", "rw");
            new Utils("").cmdRoot(new String[] { "chmod 06755 /system/bin/su" });
            Utils.remount("/system", "ro");
            str1 = new Utils("").cmdRoot(new String[] { "stat -c %a /system/bin/su" });
            System.out.println("LuckyPatcher (chek root): " + str1 + " /system/bin/su");
            if (!str1.contains("6755")) {
              return;
            }
            System.out.println("LuckyPatcher (chek root): permission /system/bin/su set 06755");
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        System.out.println("LuckyPatcher (chek root): Permissions is true.(/system/bin/su)");
        return;
        label253:
        if (Utils.exists("/system/xbin/su"))
        {
          new Utils("").cmdRoot(new String[] { "chmod 06777 internalBusybox" });
          if (listAppsFragment.su)
          {
            System.out.println("LuckyPatcher: skip root test.");
            return;
          }
          String str2 = new Utils("").cmdRoot(new String[] { "stat -c %a /system/xbin/su", Utils.internalBusybox + " stat -c %a /system/xbin/su", "busybox stat -c %a /system/xbin/su" });
          System.out.println("LuckyPatcher (chek root): get permissions " + str2 + " /system/xbin/su");
          if ((!str2.contains("6755")) && (str2.matches("[0-9]")))
          {
            System.out.println("LuckyPatcher (chek root): Permissions /system/xbin/su not correct.");
            Utils.remount("/system", "rw");
            new Utils("").cmdRoot(new String[] { "chmod 06755 /system/xbin/su" });
            Utils.remount("/system", "ro");
            str2 = new Utils("").cmdRoot(new String[] { "stat -c %a /system/xbin/su" });
            System.out.println("LuckyPatcher (chek root): " + str2 + " /system/xbin/su");
            if (str2.contains("6755")) {
              System.out.println("LuckyPatcher (chek root): permission /system/xbin/su set 06755");
            }
          }
          else
          {
            System.out.println("LuckyPatcher (chek root): Permissions is true.(/system/xbin/su)");
          }
        }
      }
    }).run();
    return true;
  }
  
  public static String checkRuntimeFromCache(String paramString)
  {
    if (listAppsFragment.api >= 19) {}
    for (;;)
    {
      int i;
      try
      {
        paramString = new FileInputStream(getFileDalvikCache(paramString));
        byte[] arrayOfByte = new byte[7];
        paramString.read(arrayOfByte);
        paramString.close();
        i = 0;
        if (i < 3)
        {
          if (arrayOfByte[i] == new byte[] { 100, 101, 120 }[i]) {
            break label242;
          }
          if (arrayOfByte[i] == new byte[] { 100, 101, 121 }[i]) {
            break label242;
          }
          System.out.println("The magic value is not the expected value " + new String(arrayOfByte));
          return "ART";
        }
        return "DALVIK";
      }
      catch (FileNotFoundException paramString)
      {
        paramString.printStackTrace();
        return "UNKNOWN";
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        try
        {
          System.out.println("Althernative runtime check with java.vm.version");
          paramString = System.getProperty("java.vm.version");
          if (Integer.parseInt("" + paramString.charAt(0)) > 1) {
            return "ART";
          }
          return "DALVIK";
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          if (listAppsFragment.api >= 21) {
            return "ART";
          }
          return "DALVIK";
        }
      }
      return "DALVIK";
      label242:
      i += 1;
    }
  }
  
  public static int chmod(File paramFile, int paramInt)
    throws Exception
  {
    return ((Integer)Class.forName("android.os.FileUtils").getMethod("setPermissions", new Class[] { String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE }).invoke(null, new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt), Integer.valueOf(-1), Integer.valueOf(-1) })).intValue();
  }
  
  public static boolean classes_test(File paramFile)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      ZipInputStream localZipInputStream = new ZipInputStream(localFileInputStream);
      for (ZipEntry localZipEntry = localZipInputStream.getNextEntry(); localZipEntry != null; localZipEntry = localZipInputStream.getNextEntry()) {
        if (localZipEntry.getName().toLowerCase().equals("classes.dex"))
        {
          localZipInputStream.closeEntry();
          localZipInputStream.close();
          localFileInputStream.close();
          return true;
        }
      }
      localZipInputStream.close();
      localFileInputStream.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramFile = ZipInput.read(paramFile.getAbsolutePath()).getEntries().values().iterator();
          if (paramFile.hasNext())
          {
            boolean bool = ((ZioEntry)paramFile.next()).getName().toLowerCase().equals("classes.dex");
            if (bool) {
              return true;
            }
          }
        }
        catch (IOException paramFile)
        {
          paramFile.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public static void clear_dalvik_cache()
  {
    if (listAppsFragment.startUnderRoot.booleanValue())
    {
      if (listAppsFragment.api >= 23) {
        try
        {
          if (new File("/data/app").exists())
          {
            File[] arrayOfFile = new File("/data/app").listFiles();
            int k = arrayOfFile.length;
            int i = 0;
            while (i < k)
            {
              Object localObject = arrayOfFile[i];
              if (((File)localObject).isDirectory())
              {
                localObject = ((File)localObject).listFiles();
                if ((localObject != null) && (localObject.length > 0))
                {
                  int m = localObject.length;
                  int j = 0;
                  while (j < m)
                  {
                    File localFile = localObject[j];
                    if ((localFile.isDirectory()) && (localFile.getName().equals("oat")))
                    {
                      System.out.println("delete folder:" + localFile.getAbsolutePath());
                      new Utils("").deleteFolder(localFile);
                    }
                    j += 1;
                  }
                }
              }
              i += 1;
            }
          }
        }
        catch (Exception localException) {}
      }
      tmp194_191[0] = "rm";
      String[] tmp200_194 = tmp194_191;
      tmp200_194[1] = "/data/dalvik-cache/*.dex";
      run_all_no_root(tmp200_194);
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/*.oat" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/*.art" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/arm/*.dex" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/arm/*.art" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/arm/*.oat" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/arm64/*.dex" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/arm64/*.art" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/arm64/*.oat" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/x86/*.dex" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/x86/*.art" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/x86/*.oat" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/x86_64/*.dex" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/x86_64/*.art" });
      run_all_no_root(new String[] { "rm", "/data/dalvik-cache/x86_64/*.oat" });
      return;
    }
    run_all("rm /data/dalvik-cache/*.dex");
    run_all("rm /data/dalvik-cache/*.oat");
    run_all("rm /data/dalvik-cache/*.art");
    run_all("rm /data/dalvik-cache/arm/*.dex");
    run_all("rm /data/dalvik-cache/arm/*.art");
    run_all("rm /data/dalvik-cache/arm/*.oat");
    run_all("rm /data/dalvik-cache/arm64/*.dex");
    run_all("rm /data/dalvik-cache/arm64/*.art");
    run_all("rm /data/dalvik-cache/arm64/*.oat");
    run_all("rm /data/dalvik-cache/x86/*.dex");
    run_all("rm /data/dalvik-cache/x86/*.art");
    run_all("rm /data/dalvik-cache/x86/*.oat");
    run_all("rm /data/dalvik-cache/x86_64/*.dex");
    run_all("rm /data/dalvik-cache/x86_64/*.art");
    run_all("rm /data/dalvik-cache/x86_64/*.oat");
  }
  
  public static String cmd(String... paramVarArgs)
  {
    int k = 0;
    String str1 = "";
    Object localObject3 = null;
    int i = 0;
    int m = paramVarArgs.length;
    int j = 0;
    while (j < m)
    {
      if (paramVarArgs[j].equals("skipOut")) {
        i = 1;
      }
      j += 1;
    }
    m = paramVarArgs.length;
    j = k;
    for (;;)
    {
      Object localObject2;
      if (j < m)
      {
        Object localObject8 = paramVarArgs[j];
        Object localObject6 = localObject3;
        Object localObject4 = str1;
        Object localObject7 = localObject3;
        Object localObject5 = str1;
        try
        {
          if (((String)localObject8).equals("skipOut")) {
            break label350;
          }
          localObject6 = localObject3;
          localObject4 = str1;
          localObject7 = localObject3;
          localObject5 = str1;
          localObject3 = Runtime.getRuntime().exec(new String(((String)localObject8).getBytes(), "ISO-8859-1"));
          localObject6 = localObject3;
          localObject4 = str1;
          localObject7 = localObject3;
          localObject5 = str1;
          localObject8 = new BufferedReader(new InputStreamReader(((Process)localObject3).getInputStream()));
          if (i == 0)
          {
            for (;;)
            {
              localObject6 = localObject3;
              localObject4 = str1;
              localObject7 = localObject3;
              localObject5 = str1;
              String str2 = ((BufferedReader)localObject8).readLine();
              if (str2 == null) {
                break;
              }
              localObject6 = localObject3;
              localObject4 = str1;
              localObject7 = localObject3;
              localObject5 = str1;
              str1 = str1 + str2 + "\n";
            }
            localObject6 = localObject3;
            localObject4 = str1;
            localObject7 = localObject3;
            localObject5 = str1;
            ((Process)localObject3).waitFor();
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          localObject3 = localObject6;
          Object localObject1 = localObject4;
          break label350;
          localObject6 = localObject3;
          localObject4 = localObject1;
          localObject7 = localObject3;
          localObject5 = localObject1;
          new Utils("w").waitLP(2000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          localObject3 = localObject7;
          localObject2 = localObject5;
        }
      }
      ((Process)localObject3).destroy();
      return (String)localObject2;
      label350:
      j += 1;
    }
  }
  
  public static String cmdParam(String... paramVarArgs)
  {
    Object localObject1 = "";
    BufferedReader localBufferedReader = null;
    Object localObject8 = null;
    Process localProcess = null;
    Object localObject10 = new ArrayList();
    Object localObject9 = new ArrayList();
    int j = 0;
    Object localObject5 = localProcess;
    Object localObject2 = localObject1;
    Object localObject6 = localBufferedReader;
    Object localObject3 = localObject1;
    Object localObject7 = localObject8;
    Object localObject4 = localObject1;
    for (;;)
    {
      int i;
      try
      {
        int k = paramVarArgs.length;
        i = 0;
        if (i < k)
        {
          String str = paramVarArgs[i];
          localObject5 = localProcess;
          localObject2 = localObject1;
          localObject6 = localBufferedReader;
          localObject3 = localObject1;
          localObject7 = localObject8;
          localObject4 = localObject1;
          if (str.equals("grep")) {
            j = 1;
          }
          if (j != 0)
          {
            localObject5 = localProcess;
            localObject2 = localObject1;
            localObject6 = localBufferedReader;
            localObject3 = localObject1;
            localObject7 = localObject8;
            localObject4 = localObject1;
            ((ArrayList)localObject9).add(str);
          }
          else
          {
            localObject5 = localProcess;
            localObject2 = localObject1;
            localObject6 = localBufferedReader;
            localObject3 = localObject1;
            localObject7 = localObject8;
            localObject4 = localObject1;
            ((ArrayList)localObject10).add(str);
          }
        }
      }
      catch (IOException paramVarArgs)
      {
        listAppsFragment.errorOutput = paramVarArgs.toString();
        System.out.println(paramVarArgs.toString());
        localObject4 = localObject2;
        localObject7 = localObject5;
        if (localObject7 != null) {
          ((Process)localObject7).destroy();
        }
        return (String)localObject4;
        if (j == 0)
        {
          localObject5 = localProcess;
          localObject2 = localObject1;
          localObject6 = localBufferedReader;
          localObject3 = localObject1;
          localObject7 = localObject8;
          localObject4 = localObject1;
          localProcess = Runtime.getRuntime().exec(paramVarArgs);
          localObject5 = localProcess;
          localObject2 = localObject1;
          localObject6 = localProcess;
          localObject3 = localObject1;
          localObject7 = localProcess;
          localObject4 = localObject1;
          localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
          paramVarArgs = (String[])localObject1;
          localObject5 = localProcess;
          localObject2 = paramVarArgs;
          localObject6 = localProcess;
          localObject3 = paramVarArgs;
          localObject7 = localProcess;
          localObject4 = paramVarArgs;
          localObject1 = localBufferedReader.readLine();
          if (localObject1 != null)
          {
            localObject5 = localProcess;
            localObject2 = paramVarArgs;
            localObject6 = localProcess;
            localObject3 = paramVarArgs;
            localObject7 = localProcess;
            localObject4 = paramVarArgs;
            paramVarArgs = paramVarArgs + (String)localObject1 + "\n";
            continue;
          }
          localObject5 = localProcess;
          localObject2 = paramVarArgs;
          localObject6 = localProcess;
          localObject3 = paramVarArgs;
          localObject7 = localProcess;
          localObject4 = paramVarArgs;
          localProcess.waitFor();
          localObject1 = localProcess;
          localObject5 = localObject1;
          localObject2 = paramVarArgs;
          localObject6 = localObject1;
          localObject3 = paramVarArgs;
          try
          {
            listAppsFragment.suErrorInputStream = new DataInputStream(((Process)localObject1).getErrorStream());
            localObject5 = localObject1;
            localObject2 = paramVarArgs;
            localObject7 = localObject1;
            localObject4 = paramVarArgs;
            localObject6 = localObject1;
            localObject3 = paramVarArgs;
            if (listAppsFragment.suErrorInputStream == null) {
              continue;
            }
            localObject5 = localObject1;
            localObject2 = paramVarArgs;
            localObject6 = localObject1;
            localObject3 = paramVarArgs;
            localObject4 = new byte[listAppsFragment.suErrorInputStream.available()];
            localObject5 = localObject1;
            localObject2 = paramVarArgs;
            localObject6 = localObject1;
            localObject3 = paramVarArgs;
            listAppsFragment.suErrorInputStream.read((byte[])localObject4);
            localObject5 = localObject1;
            localObject2 = paramVarArgs;
            localObject6 = localObject1;
            localObject3 = paramVarArgs;
            listAppsFragment.errorOutput = new String((byte[])localObject4);
            localObject5 = localObject1;
            localObject2 = paramVarArgs;
            localObject6 = localObject1;
            localObject3 = paramVarArgs;
            if (new String((byte[])localObject4).trim().equals("")) {
              continue;
            }
            localObject5 = localObject1;
            localObject2 = paramVarArgs;
            localObject6 = localObject1;
            localObject3 = paramVarArgs;
            listAppsFragment.errorOutput = new String((byte[])localObject4);
            localObject7 = localObject1;
            localObject4 = paramVarArgs;
          }
          catch (Exception localException)
          {
            localObject5 = localObject1;
            localObject2 = paramVarArgs;
            localObject6 = localObject1;
            localObject3 = paramVarArgs;
            localObject7 = localObject1;
            localObject4 = paramVarArgs;
            localException.printStackTrace();
            localObject7 = localObject1;
            localObject4 = paramVarArgs;
          }
          continue;
        }
      }
      catch (InterruptedException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        localObject7 = localObject6;
        localObject4 = localObject3;
        continue;
        localObject5 = localException;
        localObject2 = localObject1;
        localObject6 = localBufferedReader;
        localObject3 = localObject1;
        localObject7 = localObject8;
        localObject4 = localObject1;
        paramVarArgs = Runtime.getRuntime().exec((String[])((ArrayList)localObject10).toArray(new String[((ArrayList)localObject10).size()]));
        localObject5 = localException;
        localObject2 = localObject1;
        localObject6 = localBufferedReader;
        localObject3 = localObject1;
        localObject7 = localObject8;
        localObject4 = localObject1;
        localObject9 = Runtime.getRuntime().exec((String[])((ArrayList)localObject9).toArray(new String[((ArrayList)localObject9).size()]));
        localObject5 = localException;
        localObject2 = localObject1;
        localObject6 = localBufferedReader;
        localObject3 = localObject1;
        localObject7 = localObject8;
        localObject4 = localObject1;
        new Thread(new Piper(paramVarArgs.getInputStream(), ((Process)localObject9).getOutputStream())).start();
        localObject5 = localException;
        localObject2 = localObject1;
        localObject6 = localBufferedReader;
        localObject3 = localObject1;
        localObject7 = localObject8;
        localObject4 = localObject1;
        localObject10 = new BufferedReader(new InputStreamReader(((Process)localObject9).getInputStream()));
        paramVarArgs = (String[])localObject1;
        localObject5 = localException;
        localObject2 = paramVarArgs;
        localObject6 = localBufferedReader;
        localObject3 = paramVarArgs;
        localObject7 = localObject8;
        localObject4 = paramVarArgs;
        localObject1 = ((BufferedReader)localObject10).readLine();
        if (localObject1 != null)
        {
          localObject5 = localException;
          localObject2 = paramVarArgs;
          localObject6 = localBufferedReader;
          localObject3 = paramVarArgs;
          localObject7 = localObject8;
          localObject4 = paramVarArgs;
          paramVarArgs = paramVarArgs + (String)localObject1 + "\n";
          continue;
        }
        localObject5 = localException;
        localObject2 = paramVarArgs;
        localObject6 = localBufferedReader;
        localObject3 = paramVarArgs;
        localObject7 = localObject8;
        localObject4 = paramVarArgs;
        ((Process)localObject9).waitFor();
        localObject1 = localObject9;
        continue;
        localObject5 = localObject1;
        localObject2 = paramVarArgs;
        localObject6 = localObject1;
        localObject3 = paramVarArgs;
        listAppsFragment.errorOutput = "";
        localObject7 = localObject1;
        localObject4 = paramVarArgs;
        continue;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        continue;
      }
      i += 1;
    }
  }
  
  public static int convertByteToInt(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  public static int convertFourBytesToInt(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return paramByte4 << 24 | (paramByte3 & 0xFF) << 16 | (paramByte2 & 0xFF) << 8 | paramByte1 & 0xFF;
  }
  
  public static void convertStringToArraysPatch(String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    int j = 0;
    paramString1 = paramString1.trim();
    String[] arrayOfString = new String[paramString1.split("[ \t]+").length];
    paramString1 = paramString1.split("[ \t]+");
    int i = 0;
    try
    {
      if (i < paramString1.length)
      {
        if (paramString1[i].matches("\\?+"))
        {
          paramString1[i] = "60";
          paramArrayOfByte2[i] = 1;
        }
        for (;;)
        {
          if (!paramString1[i].toUpperCase().contains("R")) {
            paramArrayOfByte1[i] = Integer.valueOf(paramString1[i], 16).byteValue();
          }
          if (!paramString1[i].toUpperCase().contains("R")) {
            break;
          }
          paramArrayOfByte1[i] = Integer.valueOf(paramString1[i].toUpperCase().replace("R", ""), 16).byteValue();
          paramArrayOfByte2[i] = 23;
          break;
          paramArrayOfByte2[i] = 0;
        }
      }
      try
      {
        if (i < paramString1.length)
        {
          if (paramString1[i].matches("\\?+"))
          {
            paramString1[i] = "60";
            paramArrayOfByte4[i] = 0;
          }
          for (;;)
          {
            if (paramString1[i].toUpperCase().contains("S1"))
            {
              paramString1[i] = "60";
              paramArrayOfByte4[i] = 21;
            }
            if (paramString1[i].toUpperCase().contains("S0"))
            {
              paramString1[i] = "60";
              paramArrayOfByte4[i] = 20;
            }
            if (!paramString1[i].toUpperCase().contains("W")) {
              paramArrayOfByte3[i] = Integer.valueOf(paramString1[i], 16).byteValue();
            }
            if (!paramString1[i].toUpperCase().contains("W")) {
              break;
            }
            paramArrayOfByte3[i] = Integer.valueOf(paramString1[i].toUpperCase().replace("W", ""), 16).byteValue();
            paramArrayOfByte4[i] = 23;
            break;
            paramArrayOfByte4[i] = 1;
          }
        }
        i += 1;
      }
      catch (Exception paramString1)
      {
        System.out.println(" " + paramString1);
        if ((paramArrayOfByte4.length == paramArrayOfByte2.length) && (paramArrayOfByte1.length == paramArrayOfByte3.length) && (paramArrayOfByte3.length >= 4))
        {
          i = j;
          if (paramArrayOfByte1.length >= 4) {}
        }
        else
        {
          i = 1;
        }
        if (i != 0) {
          System.out.println("Error: Patterns original and replaced not valid!\n- Dimensions of the original hex-string and repleced must be >3.\n- Dimensions of the original hex-string and repleced must be equal.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!");
        }
        return;
      }
    }
    catch (Exception paramString1)
    {
      System.out.println(" " + paramString1);
      paramString1 = paramString2.trim();
      paramString2 = new String[paramString1.split("[ \t]+").length];
      paramString1 = paramString1.split("[ \t]+");
      i = 0;
    }
    for (;;)
    {
      break;
      i += 1;
    }
  }
  
  public static void convertToPatchItemAuto(ArrayList<PatchesItemAuto> paramArrayList, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Boolean> paramArrayList3, ArrayList<String> paramArrayList4, ArrayList<String> paramArrayList5, ArrayList<Boolean> paramArrayList6, Boolean paramBoolean)
  {
    int i = 0;
    Object localObject3;
    String str;
    Object localObject2;
    Object localObject1;
    int k;
    Object localObject4;
    int j;
    for (;;)
    {
      if (i < paramArrayList1.size())
      {
        localObject3 = (String)paramArrayList1.get(i);
        str = (String)paramArrayList2.get(i);
        localObject2 = localObject3;
        localObject1 = str;
        if (!((Boolean)paramArrayList6.get(i)).booleanValue())
        {
          localObject2 = localObject3;
          localObject1 = str;
          if (paramBoolean.booleanValue())
          {
            localObject2 = rework((String)paramArrayList1.get(i));
            localObject1 = rework((String)paramArrayList2.get(i));
          }
        }
        localObject3 = (Boolean)paramArrayList3.get(i);
        str = (String)paramArrayList4.get(i);
        k = 0;
        localObject2 = ((String)localObject2).trim();
        localObject4 = new String[((String)localObject2).split("[ \t]+").length];
        String[] arrayOfString1 = ((String)localObject2).split("[ \t]+");
        localObject2 = new int[arrayOfString1.length];
        localObject4 = new byte[arrayOfString1.length];
        j = 0;
        try
        {
          if (j < arrayOfString1.length)
          {
            if (arrayOfString1[j].matches("\\?+"))
            {
              arrayOfString1[j] = "60";
              localObject2[j] = 1;
            }
            for (;;)
            {
              if (!arrayOfString1[j].toUpperCase().contains("R")) {
                localObject4[j] = Integer.valueOf(arrayOfString1[j], 16).byteValue();
              }
              if (!arrayOfString1[j].toUpperCase().contains("R")) {
                break;
              }
              localObject4[j] = Integer.valueOf(arrayOfString1[j].toUpperCase().replace("R", ""), 16).byteValue();
              localObject2[j] = 23;
              break;
              localObject2[j] = 0;
            }
          }
          try
          {
            String[] arrayOfString2;
            if (j < arrayOfString2.length)
            {
              if (arrayOfString2[j].matches("\\?+"))
              {
                arrayOfString2[j] = "60";
                localObject1[j] = 0;
              }
              for (;;)
              {
                if (arrayOfString2[j].toUpperCase().contains("S1"))
                {
                  arrayOfString2[j] = "60";
                  localObject1[j] = 21;
                }
                if (arrayOfString2[j].toUpperCase().contains("S0"))
                {
                  arrayOfString2[j] = "60";
                  localObject1[j] = 20;
                }
                if (!arrayOfString2[j].toUpperCase().contains("W")) {
                  localObject5[j] = Integer.valueOf(arrayOfString2[j], 16).byteValue();
                }
                if (!arrayOfString2[j].toUpperCase().contains("W")) {
                  break;
                }
                localObject5[j] = Integer.valueOf(arrayOfString2[j].toUpperCase().replace("W", ""), 16).byteValue();
                localObject1[j] = 23;
                break;
                localObject1[j] = 1;
              }
            }
          }
          catch (Exception localException2)
          {
            Object localObject5;
            System.out.println(" " + localException2);
            if ((localObject1.length == localObject2.length) && (localObject4.length == localObject5.length) && (localObject5.length >= 4))
            {
              j = k;
              if (localObject4.length >= 4) {}
            }
            else
            {
              j = 1;
            }
            if (j != 0) {
              System.out.println("Error: Patterns original and replaced not valid!\n- Dimensions of the original hex-string and repleced must be >3.\n- Dimensions of the original hex-string and repleced must be equal.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!");
            }
            if (j == 0) {
              paramArrayList.add(new PatchesItemAuto((byte[])localObject4, (int[])localObject2, (byte[])localObject5, (int[])localObject1, ((Boolean)localObject3).booleanValue(), str, (String)paramArrayList5.get(i)));
            }
            i += 1;
          }
        }
        catch (Exception localException1)
        {
          System.out.println(" " + localException1);
          localObject1 = ((String)localObject1).trim();
          localObject5 = new String[((String)localObject1).split("[ \t]+").length];
          arrayOfString2 = ((String)localObject1).split("[ \t]+");
          localObject1 = new int[arrayOfString2.length];
          localObject5 = new byte[arrayOfString2.length];
          j = 0;
        }
      }
    }
    for (;;)
    {
      return;
      j += 1;
      break;
      j += 1;
    }
  }
  
  public static int convertTwoBytesToInt(byte paramByte1, byte paramByte2)
  {
    return (paramByte2 & 0xFF) << 8 | paramByte1 & 0xFF;
  }
  
  public static void copyArchFiles(ZipInputStream paramZipInputStream, JarOutputStream paramJarOutputStream, ArrayList<AddFilesItem> paramArrayList)
    throws IOException
  {
    int i = 0;
    AddFilesItem[] arrayOfAddFilesItem = (AddFilesItem[])paramArrayList.toArray(new AddFilesItem[paramArrayList.size()]);
    byte[] arrayOfByte1 = new byte[' '];
    CRC32 localCRC32 = new CRC32();
    localCRC32.reset();
    paramArrayList = null;
    ZipEntry localZipEntry = paramZipInputStream.getNextEntry();
    int k;
    int j;
    Object localObject2;
    if (localZipEntry != null)
    {
      k = arrayOfAddFilesItem.length;
      j = 0;
      if (j < k)
      {
        localObject2 = arrayOfAddFilesItem[j];
        if (!localZipEntry.getName().equals(((AddFilesItem)localObject2).fileName.replace(((AddFilesItem)localObject2).basePath, ""))) {
          break label553;
        }
      }
    }
    label311:
    label477:
    label482:
    label550:
    label553:
    for (;;)
    {
      try
      {
        localObject1 = new ZipEntry(localZipEntry.getName());
      }
      catch (Exception localException2)
      {
        try
        {
          ((ZipEntry)localObject1).setTime(localZipEntry.getTime());
          paramArrayList = new File(((AddFilesItem)localObject2).fileName);
          localObject2 = new FileInputStream(((AddFilesItem)localObject2).fileName);
          byte[] arrayOfByte2 = new byte[(int)paramArrayList.length()];
          ((FileInputStream)localObject2).read(arrayOfByte2);
          ((ZipEntry)localObject1).setSize(paramArrayList.length());
          localCRC32.update(arrayOfByte2);
          ((ZipEntry)localObject1).setCrc(localCRC32.getValue());
          ((ZipEntry)localObject1).setMethod(localZipEntry.getMethod());
          ((FileInputStream)localObject2).close();
          i = 1;
          paramArrayList = (ArrayList<AddFilesItem>)localObject1;
          j += 1;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Object localObject1;
            Object localObject3;
            paramArrayList = localException1;
          }
        }
        localException2 = localException2;
      }
      System.out.println(localException2);
      continue;
      if (localZipEntry.getMethod() == 0)
      {
        if (i != 0) {
          break label550;
        }
        paramArrayList = new ZipEntry(localZipEntry);
        paramArrayList.setMethod(0);
        paramArrayList.setTime(localZipEntry.getTime());
        paramArrayList.setCompressedSize(localZipEntry.getSize());
        paramArrayList.setSize(localZipEntry.getSize());
        paramJarOutputStream.putNextEntry(paramArrayList);
        localCRC32.reset();
        if (i == 0) {
          break label482;
        }
        j = arrayOfAddFilesItem.length;
        i = 0;
        if (i >= j) {
          break label477;
        }
        localObject3 = arrayOfAddFilesItem[i];
        if (localZipEntry.getName().equals(((AddFilesItem)localObject3).fileName.replace(((AddFilesItem)localObject3).basePath, ""))) {
          try
          {
            localObject1 = new File(((AddFilesItem)localObject3).fileName);
            localObject3 = new FileInputStream(((AddFilesItem)localObject3).fileName);
            paramJarOutputStream.putNextEntry(paramArrayList);
            for (;;)
            {
              k = ((FileInputStream)localObject3).read(arrayOfByte1);
              if (k <= 0) {
                break;
              }
              paramJarOutputStream.write(arrayOfByte1, 0, k);
            }
            i += 1;
          }
          catch (Exception localException1)
          {
            System.out.println(localException1);
          }
        }
      }
      for (;;)
      {
        break label311;
        if (i != 0) {
          break label550;
        }
        paramArrayList = new JarEntry(localZipEntry.getName());
        paramJarOutputStream.putNextEntry(paramArrayList);
        paramArrayList.setTime(localZipEntry.getTime());
        break;
        paramJarOutputStream.flush();
        localException1.delete();
        ((FileInputStream)localObject3).close();
      }
      i = 0;
      break;
      for (;;)
      {
        j = paramZipInputStream.read(arrayOfByte1);
        if (j <= 0) {
          break;
        }
        paramJarOutputStream.write(arrayOfByte1, 0, j);
        localCRC32.update(arrayOfByte1, 0, j);
      }
      paramJarOutputStream.flush();
      paramArrayList.setCrc(localCRC32.getValue());
      break;
      paramJarOutputStream.finish();
      paramJarOutputStream.close();
      return;
    }
  }
  
  /* Error */
  public static void copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: new 128	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokevirtual 1174	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: astore 10
    //   17: new 135	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: invokevirtual 1175	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   28: astore 11
    //   30: aload 10
    //   32: invokevirtual 502	java/nio/channels/FileChannel:size	()J
    //   35: lstore 6
    //   37: lconst_0
    //   38: lstore 4
    //   40: lload 4
    //   42: lload 6
    //   44: lcmp
    //   45: ifge +28 -> 73
    //   48: aload 10
    //   50: lload 4
    //   52: ldc_w 1176
    //   55: i2l
    //   56: aload 11
    //   58: invokevirtual 1180	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   61: lstore 8
    //   63: lload 4
    //   65: lload 8
    //   67: ladd
    //   68: lstore 4
    //   70: goto -30 -> 40
    //   73: aload 10
    //   75: ifnull +8 -> 83
    //   78: aload 10
    //   80: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   83: iload_2
    //   84: istore_3
    //   85: aload 11
    //   87: ifnull +10 -> 97
    //   90: aload 11
    //   92: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   95: iload_2
    //   96: istore_3
    //   97: aload_0
    //   98: invokevirtual 311	java/io/File:length	()J
    //   101: aload_1
    //   102: invokevirtual 311	java/io/File:length	()J
    //   105: lcmp
    //   106: ifeq +317 -> 423
    //   109: aload_1
    //   110: invokevirtual 195	java/io/File:delete	()Z
    //   113: pop
    //   114: getstatic 1184	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:su	Z
    //   117: ifeq +306 -> 423
    //   120: iload_3
    //   121: ifne +302 -> 423
    //   124: getstatic 927	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   127: invokevirtual 932	java/lang/Boolean:booleanValue	()Z
    //   130: ifeq +674 -> 804
    //   133: aload_0
    //   134: invokevirtual 1188	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   137: invokevirtual 1189	java/io/File:toString	()Ljava/lang/String;
    //   140: astore 10
    //   142: aload_1
    //   143: invokevirtual 1188	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   146: invokevirtual 1189	java/io/File:toString	()Ljava/lang/String;
    //   149: astore 11
    //   151: iconst_3
    //   152: anewarray 92	java/lang/String
    //   155: dup
    //   156: iconst_0
    //   157: ldc_w 1191
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: new 208	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 1193
    //   173: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 10
    //   178: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: aastore
    //   185: dup
    //   186: iconst_2
    //   187: new 208	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 1195
    //   197: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 11
    //   202: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: aastore
    //   209: invokestatic 1197	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   212: pop
    //   213: new 171	java/io/File
    //   216: dup
    //   217: aload 11
    //   219: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: invokevirtual 175	java/io/File:exists	()Z
    //   225: ifeq +15 -> 240
    //   228: aload_0
    //   229: invokevirtual 311	java/io/File:length	()J
    //   232: aload_1
    //   233: invokevirtual 311	java/io/File:length	()J
    //   236: lcmp
    //   237: ifeq +71 -> 308
    //   240: iconst_4
    //   241: anewarray 92	java/lang/String
    //   244: dup
    //   245: iconst_0
    //   246: ldc_w 1199
    //   249: aastore
    //   250: dup
    //   251: iconst_1
    //   252: ldc_w 1191
    //   255: aastore
    //   256: dup
    //   257: iconst_2
    //   258: new 208	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 1193
    //   268: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 10
    //   273: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: aastore
    //   280: dup
    //   281: iconst_3
    //   282: new 208	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 1195
    //   292: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 11
    //   297: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: aastore
    //   304: invokestatic 1197	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   307: pop
    //   308: new 171	java/io/File
    //   311: dup
    //   312: aload 11
    //   314: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   317: invokevirtual 175	java/io/File:exists	()Z
    //   320: ifeq +15 -> 335
    //   323: aload_0
    //   324: invokevirtual 311	java/io/File:length	()J
    //   327: aload_1
    //   328: invokevirtual 311	java/io/File:length	()J
    //   331: lcmp
    //   332: ifeq +71 -> 403
    //   335: iconst_4
    //   336: anewarray 92	java/lang/String
    //   339: dup
    //   340: iconst_0
    //   341: ldc_w 1201
    //   344: aastore
    //   345: dup
    //   346: iconst_1
    //   347: ldc_w 1191
    //   350: aastore
    //   351: dup
    //   352: iconst_2
    //   353: new 208	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 1193
    //   363: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 10
    //   368: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: aastore
    //   375: dup
    //   376: iconst_3
    //   377: new 208	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 1195
    //   387: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 11
    //   392: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: aastore
    //   399: invokestatic 1197	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   402: pop
    //   403: aload_0
    //   404: invokevirtual 311	java/io/File:length	()J
    //   407: lstore 4
    //   409: aload_1
    //   410: invokevirtual 311	java/io/File:length	()J
    //   413: lstore 6
    //   415: lload 4
    //   417: lload 6
    //   419: lcmp
    //   420: ifne +378 -> 798
    //   423: return
    //   424: astore 12
    //   426: aload 12
    //   428: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   431: iload_3
    //   432: istore_2
    //   433: aload 12
    //   435: invokevirtual 1064	java/io/IOException:toString	()Ljava/lang/String;
    //   438: invokevirtual 916	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   441: ldc_w 1203
    //   444: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   447: ifeq +5 -> 452
    //   450: iconst_1
    //   451: istore_2
    //   452: aload 12
    //   454: invokevirtual 1064	java/io/IOException:toString	()Ljava/lang/String;
    //   457: invokevirtual 916	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   460: ldc_w 1203
    //   463: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   466: ifne +245 -> 711
    //   469: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   472: ldc_w 1205
    //   475: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   478: getstatic 1184	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:su	Z
    //   481: ifeq +230 -> 711
    //   484: invokestatic 1208	com/chelpus/Utils:getRootUid	()Z
    //   487: ifeq +288 -> 775
    //   490: aload_0
    //   491: invokevirtual 1188	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   494: invokevirtual 1189	java/io/File:toString	()Ljava/lang/String;
    //   497: astore 12
    //   499: aload_1
    //   500: invokevirtual 1188	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   503: invokevirtual 1189	java/io/File:toString	()Ljava/lang/String;
    //   506: astore 13
    //   508: iconst_1
    //   509: anewarray 92	java/lang/String
    //   512: dup
    //   513: iconst_0
    //   514: new 208	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 1210
    //   524: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload 12
    //   529: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc_w 1212
    //   535: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 13
    //   540: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: aastore
    //   547: invokestatic 1214	com/chelpus/Utils:cmd	([Ljava/lang/String;)Ljava/lang/String;
    //   550: pop
    //   551: new 171	java/io/File
    //   554: dup
    //   555: aload 13
    //   557: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   560: invokevirtual 175	java/io/File:exists	()Z
    //   563: ifeq +15 -> 578
    //   566: aload_0
    //   567: invokevirtual 311	java/io/File:length	()J
    //   570: aload_1
    //   571: invokevirtual 311	java/io/File:length	()J
    //   574: lcmp
    //   575: ifeq +46 -> 621
    //   578: iconst_1
    //   579: anewarray 92	java/lang/String
    //   582: dup
    //   583: iconst_0
    //   584: new 208	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 1216
    //   594: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 12
    //   599: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: ldc_w 1212
    //   605: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 13
    //   610: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: aastore
    //   617: invokestatic 1214	com/chelpus/Utils:cmd	([Ljava/lang/String;)Ljava/lang/String;
    //   620: pop
    //   621: new 171	java/io/File
    //   624: dup
    //   625: aload 13
    //   627: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   630: invokevirtual 175	java/io/File:exists	()Z
    //   633: ifeq +15 -> 648
    //   636: aload_0
    //   637: invokevirtual 311	java/io/File:length	()J
    //   640: aload_1
    //   641: invokevirtual 311	java/io/File:length	()J
    //   644: lcmp
    //   645: ifeq +46 -> 691
    //   648: iconst_1
    //   649: anewarray 92	java/lang/String
    //   652: dup
    //   653: iconst_0
    //   654: new 208	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   661: ldc_w 1218
    //   664: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload 12
    //   669: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: ldc_w 1212
    //   675: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload 13
    //   680: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: aastore
    //   687: invokestatic 1214	com/chelpus/Utils:cmd	([Ljava/lang/String;)Ljava/lang/String;
    //   690: pop
    //   691: aload_0
    //   692: invokevirtual 311	java/io/File:length	()J
    //   695: lstore 4
    //   697: aload_1
    //   698: invokevirtual 311	java/io/File:length	()J
    //   701: lstore 6
    //   703: lload 4
    //   705: lload 6
    //   707: lcmp
    //   708: ifne +36 -> 744
    //   711: aload 10
    //   713: ifnull +8 -> 721
    //   716: aload 10
    //   718: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   721: iload_2
    //   722: istore_3
    //   723: aload 11
    //   725: ifnull -628 -> 97
    //   728: aload 11
    //   730: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   733: iload_2
    //   734: istore_3
    //   735: goto -638 -> 97
    //   738: astore_0
    //   739: aload_0
    //   740: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   743: return
    //   744: aload_1
    //   745: invokevirtual 195	java/io/File:delete	()Z
    //   748: pop
    //   749: goto -38 -> 711
    //   752: astore_0
    //   753: aload 10
    //   755: ifnull +8 -> 763
    //   758: aload 10
    //   760: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   763: aload 11
    //   765: ifnull +8 -> 773
    //   768: aload 11
    //   770: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   773: aload_0
    //   774: athrow
    //   775: aload_0
    //   776: invokevirtual 1188	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   779: invokevirtual 1189	java/io/File:toString	()Ljava/lang/String;
    //   782: aload_1
    //   783: invokevirtual 1188	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   786: invokevirtual 1189	java/io/File:toString	()Ljava/lang/String;
    //   789: iconst_1
    //   790: iconst_1
    //   791: invokestatic 1221	com/chelpus/Utils:copyFile	(Ljava/lang/String;Ljava/lang/String;ZZ)Z
    //   794: pop
    //   795: goto -84 -> 711
    //   798: aload_1
    //   799: invokevirtual 195	java/io/File:delete	()Z
    //   802: pop
    //   803: return
    //   804: aload_0
    //   805: invokevirtual 1188	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   808: invokevirtual 1189	java/io/File:toString	()Ljava/lang/String;
    //   811: aload_1
    //   812: invokevirtual 1188	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   815: invokevirtual 1189	java/io/File:toString	()Ljava/lang/String;
    //   818: iconst_1
    //   819: iconst_1
    //   820: invokestatic 1221	com/chelpus/Utils:copyFile	(Ljava/lang/String;Ljava/lang/String;ZZ)Z
    //   823: pop
    //   824: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	825	0	paramFile1	File
    //   0	825	1	paramFile2	File
    //   3	731	2	i	int
    //   1	734	3	j	int
    //   38	666	4	l1	long
    //   35	671	6	l2	long
    //   61	5	8	l3	long
    //   15	744	10	localObject1	Object
    //   28	741	11	localObject2	Object
    //   424	29	12	localIOException	IOException
    //   497	171	12	str1	String
    //   506	173	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   30	37	424	java/io/IOException
    //   48	63	424	java/io/IOException
    //   4	30	738	java/lang/Exception
    //   78	83	738	java/lang/Exception
    //   90	95	738	java/lang/Exception
    //   97	120	738	java/lang/Exception
    //   124	240	738	java/lang/Exception
    //   240	308	738	java/lang/Exception
    //   308	335	738	java/lang/Exception
    //   335	403	738	java/lang/Exception
    //   403	415	738	java/lang/Exception
    //   716	721	738	java/lang/Exception
    //   728	733	738	java/lang/Exception
    //   758	763	738	java/lang/Exception
    //   768	773	738	java/lang/Exception
    //   773	775	738	java/lang/Exception
    //   798	803	738	java/lang/Exception
    //   804	824	738	java/lang/Exception
    //   30	37	752	finally
    //   48	63	752	finally
    //   426	431	752	finally
    //   433	450	752	finally
    //   452	578	752	finally
    //   578	621	752	finally
    //   621	648	752	finally
    //   648	691	752	finally
    //   691	703	752	finally
    //   744	749	752	finally
    //   775	795	752	finally
  }
  
  public static boolean copyFile(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!listAppsFragment.startUnderRoot.booleanValue()) {
      bool1 = bool2;
    }
    label966:
    label969:
    for (;;)
    {
      try
      {
        if (!exists(paramString1)) {
          break label966;
        }
        if (paramBoolean1) {
          remount(paramString2, "RW");
        }
        String str1 = "";
        if (paramBoolean2)
        {
          str1 = getPermissions(paramString1);
          if (str1 == null) {}
        }
        try
        {
          if (!str1.equals("")) {
            break label969;
          }
          str1 = "777";
          exitRoot();
        }
        catch (Exception localException1)
        {
          str2 = "777";
          continue;
        }
        new Utils("").cmdRoot(new String[] { "dd if=" + paramString1 + " of=" + paramString2 });
        if (!exists(paramString2)) {
          new Utils("").cmdRoot(new String[] { "toolbox dd if=" + paramString1 + " of=" + paramString2 });
        }
        if (!exists(paramString2)) {
          new Utils("").cmdRoot(new String[] { "busybox dd if=" + paramString1 + " of=" + paramString2 });
        }
        if (!exists(paramString2)) {
          new Utils("").cmdRoot(new String[] { listAppsFragment.toolfilesdir + "/busybox dd if=" + paramString1 + " of=" + paramString2 });
        }
        if (!exists(paramString2)) {
          new Utils("").cmdRoot(new String[] { listAppsFragment.toolfilesdir + "/busybox cp -fp " + paramString1 + " " + paramString2 });
        }
        bool1 = bool2;
        if (!paramBoolean2) {
          break label966;
        }
        run_all("chmod " + str1 + " " + paramString2);
        bool1 = bool2;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        bool1 = false;
      }
      File localFile1 = new File(paramString1);
      File localFile2 = new File(paramString2);
      if (paramBoolean1) {
        remount(paramString2, "RW");
      }
      String str2 = "";
      if (paramBoolean2)
      {
        str2 = getPermissions(paramString1);
        if (str2 == null) {}
      }
      for (;;)
      {
        try
        {
          if (!str2.equals("")) {
            continue;
          }
          str2 = "777";
        }
        catch (Exception localException2)
        {
          String str3 = "777";
          continue;
          localFile2.delete();
          System.out.println("LuckyPatcher (cmdCopy): error copy... not enougth space to destination.");
          return false;
        }
        cmdParam(new String[] { "dd", "if=" + paramString1, "of=" + paramString2 });
        if ((!new File(paramString2).exists()) || (localFile1.length() != localFile2.length())) {
          cmdParam(new String[] { "toolbox", "dd", "if=" + paramString1, "of=" + paramString2 });
        }
        if ((!new File(paramString2).exists()) || (localFile1.length() != localFile2.length())) {
          cmdParam(new String[] { "busybox", "dd", "if=" + paramString1, "of=" + paramString2 });
        }
        if ((!new File(paramString2).exists()) || (localFile1.length() != localFile2.length())) {
          cmdParam(new String[] { listAppsFragment.toolfilesdir + "/busybox", "dd", "if=" + paramString1, "of=" + paramString2 });
        }
        if ((!new File(paramString2).exists()) || (localFile1.length() != localFile2.length())) {
          copyFile(localFile1, localFile2);
        }
        if (localFile1.length() != localFile2.length()) {
          continue;
        }
        if (paramBoolean2) {
          run_all_no_root(new String[] { "chmod", str2, paramString2 });
        }
        return true;
      }
      return bool1;
    }
  }
  
  public static void copyFolder(File paramFile1, File paramFile2)
    throws Exception
  {
    if (paramFile1.isDirectory())
    {
      if (!paramFile2.exists())
      {
        paramFile2.mkdir();
        System.out.println("Directory copied from " + paramFile1 + "  to " + paramFile2);
      }
      String[] arrayOfString = paramFile1.list();
      if (arrayOfString.length > 0)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          copyFolder(new File(paramFile1, str), new File(paramFile2, str));
          i += 1;
        }
      }
    }
    else
    {
      copyFile(paramFile1, paramFile2);
    }
  }
  
  /* Error */
  public static int create_DC_root(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_3
    //   4: anewarray 92	java/lang/String
    //   7: dup
    //   8: iconst_0
    //   9: ldc_w 453
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: ldc_w 591
    //   18: aastore
    //   19: dup
    //   20: iconst_2
    //   21: aload_0
    //   22: aastore
    //   23: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   26: iconst_3
    //   27: anewarray 92	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc_w 461
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc_w 1266
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: aload_0
    //   45: aastore
    //   46: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   49: iconst_3
    //   50: anewarray 92	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: ldc_w 461
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: ldc_w 1268
    //   64: aastore
    //   65: dup
    //   66: iconst_2
    //   67: aload_0
    //   68: aastore
    //   69: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   72: aconst_null
    //   73: astore 12
    //   75: aload_1
    //   76: invokestatic 468	com/chelpus/Utils:getFileDalvikCacheName	(Ljava/lang/String;)Ljava/io/File;
    //   79: astore 11
    //   81: aload 11
    //   83: astore 12
    //   85: aload_3
    //   86: astore 11
    //   88: aload_3
    //   89: ifnonnull +10 -> 99
    //   92: aload_1
    //   93: aload_2
    //   94: invokestatic 1271	com/chelpus/Utils:getOdexForCreate	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 11
    //   99: aload 11
    //   101: ifnull +40 -> 141
    //   104: new 171	java/io/File
    //   107: dup
    //   108: aload 11
    //   110: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 175	java/io/File:exists	()Z
    //   116: ifeq +25 -> 141
    //   119: aload 11
    //   121: ldc_w 1223
    //   124: invokestatic 1227	com/chelpus/Utils:remount	(Ljava/lang/String;Ljava/lang/String;)Z
    //   127: pop
    //   128: new 171	java/io/File
    //   131: dup
    //   132: aload 11
    //   134: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: invokevirtual 195	java/io/File:delete	()Z
    //   140: pop
    //   141: iconst_0
    //   142: istore 10
    //   144: iconst_0
    //   145: istore 6
    //   147: iconst_0
    //   148: istore 7
    //   150: new 171	java/io/File
    //   153: dup
    //   154: aload_1
    //   155: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   161: pop
    //   162: aload_1
    //   163: aload_2
    //   164: invokestatic 1271	com/chelpus/Utils:getOdexForCreate	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   167: pop
    //   168: aload_1
    //   169: invokestatic 468	com/chelpus/Utils:getFileDalvikCacheName	(Ljava/lang/String;)Ljava/io/File;
    //   172: pop
    //   173: new 171	java/io/File
    //   176: dup
    //   177: aload_1
    //   178: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   181: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   184: ldc_w 1273
    //   187: invokestatic 1275	com/chelpus/Utils:changeExtension	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   190: pop
    //   191: aconst_null
    //   192: astore 11
    //   194: aconst_null
    //   195: astore 14
    //   197: aconst_null
    //   198: astore 13
    //   200: iconst_0
    //   201: istore 8
    //   203: aload 11
    //   205: astore_3
    //   206: iload 10
    //   208: istore 5
    //   210: invokestatic 1278	com/chelpus/Utils:getCurrentRuntimeValue	()Ljava/lang/String;
    //   213: ldc_w 847
    //   216: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   219: ifeq +514 -> 733
    //   222: iconst_1
    //   223: istore 4
    //   225: iload 4
    //   227: istore 8
    //   229: aload 11
    //   231: astore_3
    //   232: iload 10
    //   234: istore 5
    //   236: aload 12
    //   238: invokevirtual 175	java/io/File:exists	()Z
    //   241: ifeq +20 -> 261
    //   244: iload 4
    //   246: istore 8
    //   248: aload 11
    //   250: astore_3
    //   251: iload 10
    //   253: istore 5
    //   255: aload 12
    //   257: invokevirtual 195	java/io/File:delete	()Z
    //   260: pop
    //   261: iload 4
    //   263: ifeq +568 -> 831
    //   266: iload 4
    //   268: istore 8
    //   270: aload 11
    //   272: astore_3
    //   273: iload 10
    //   275: istore 5
    //   277: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   280: ldc_w 1280
    //   283: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   286: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   289: ldc_w 1282
    //   292: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   295: ldc 86
    //   297: astore_0
    //   298: aload 12
    //   300: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   303: ldc_w 1284
    //   306: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   309: ifeq +7 -> 316
    //   312: ldc_w 1286
    //   315: astore_0
    //   316: aload 12
    //   318: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   321: ldc_w 1288
    //   324: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   327: ifeq +7 -> 334
    //   330: ldc_w 1290
    //   333: astore_0
    //   334: aload 12
    //   336: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   339: ldc_w 1292
    //   342: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   345: ifeq +7 -> 352
    //   348: ldc_w 1294
    //   351: astore_0
    //   352: aload 12
    //   354: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   357: ldc_w 1296
    //   360: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   363: ifeq +7 -> 370
    //   366: ldc_w 1298
    //   369: astore_0
    //   370: aload 12
    //   372: invokevirtual 195	java/io/File:delete	()Z
    //   375: pop
    //   376: aload 12
    //   378: invokevirtual 175	java/io/File:exists	()Z
    //   381: ifeq +24 -> 405
    //   384: iconst_2
    //   385: anewarray 92	java/lang/String
    //   388: dup
    //   389: iconst_0
    //   390: ldc_w 951
    //   393: aastore
    //   394: dup
    //   395: iconst_1
    //   396: aload 12
    //   398: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   401: aastore
    //   402: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   405: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   408: ldc_w 1300
    //   411: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   414: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   417: iconst_4
    //   418: anewarray 92	java/lang/String
    //   421: dup
    //   422: iconst_0
    //   423: ldc_w 1302
    //   426: aastore
    //   427: dup
    //   428: iconst_1
    //   429: new 208	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 1304
    //   439: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_1
    //   443: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: aastore
    //   450: dup
    //   451: iconst_2
    //   452: new 208	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   459: ldc_w 1306
    //   462: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload 12
    //   467: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   470: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: aastore
    //   477: dup
    //   478: iconst_3
    //   479: new 208	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   486: ldc_w 1308
    //   489: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_0
    //   493: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: aastore
    //   500: invokestatic 1197	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   503: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   506: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   509: ldc_w 1310
    //   512: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   515: aload 12
    //   517: invokevirtual 175	java/io/File:exists	()Z
    //   520: ifeq +219 -> 739
    //   523: aload 12
    //   525: invokevirtual 311	java/io/File:length	()J
    //   528: lconst_0
    //   529: lcmp
    //   530: ifeq +209 -> 739
    //   533: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   536: new 208	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   543: ldc_w 1312
    //   546: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload 12
    //   551: invokevirtual 311	java/io/File:length	()J
    //   554: invokevirtual 1315	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   557: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   563: iload 7
    //   565: istore 6
    //   567: aload 13
    //   569: astore_0
    //   570: iload 4
    //   572: istore 8
    //   574: aload_0
    //   575: astore_3
    //   576: iload 6
    //   578: istore 5
    //   580: aload_1
    //   581: ldc_w 1317
    //   584: invokevirtual 630	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   587: ifeq +524 -> 1111
    //   590: iload 4
    //   592: istore 8
    //   594: aload_0
    //   595: astore_3
    //   596: iload 6
    //   598: istore 5
    //   600: iconst_3
    //   601: anewarray 92	java/lang/String
    //   604: dup
    //   605: iconst_0
    //   606: ldc_w 453
    //   609: aastore
    //   610: dup
    //   611: iconst_1
    //   612: ldc_w 1319
    //   615: aastore
    //   616: dup
    //   617: iconst_2
    //   618: aload 12
    //   620: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   623: aastore
    //   624: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   627: iload 4
    //   629: istore 8
    //   631: aload_0
    //   632: astore_3
    //   633: iload 6
    //   635: istore 5
    //   637: iconst_3
    //   638: anewarray 92	java/lang/String
    //   641: dup
    //   642: iconst_0
    //   643: ldc_w 461
    //   646: aastore
    //   647: dup
    //   648: iconst_1
    //   649: ldc_w 1268
    //   652: aastore
    //   653: dup
    //   654: iconst_2
    //   655: aload 12
    //   657: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   660: aastore
    //   661: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   664: iload 4
    //   666: istore 8
    //   668: aload_0
    //   669: astore_3
    //   670: iload 6
    //   672: istore 5
    //   674: iconst_3
    //   675: anewarray 92	java/lang/String
    //   678: dup
    //   679: iconst_0
    //   680: ldc_w 461
    //   683: aastore
    //   684: dup
    //   685: iconst_1
    //   686: ldc_w 1266
    //   689: aastore
    //   690: dup
    //   691: iconst_2
    //   692: aload 12
    //   694: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   697: aastore
    //   698: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   701: iload 6
    //   703: istore 5
    //   705: aload_0
    //   706: ifnull +7 -> 713
    //   709: aload_0
    //   710: invokevirtual 1322	dalvik/system/DexFile:close	()V
    //   713: iconst_1
    //   714: ifne +557 -> 1271
    //   717: iconst_3
    //   718: istore 6
    //   720: iload 6
    //   722: ireturn
    //   723: astore 11
    //   725: aload 11
    //   727: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   730: goto -645 -> 85
    //   733: iconst_0
    //   734: istore 4
    //   736: goto -511 -> 225
    //   739: aload 12
    //   741: invokevirtual 195	java/io/File:delete	()Z
    //   744: pop
    //   745: aload 13
    //   747: astore_0
    //   748: iload 7
    //   750: istore 6
    //   752: aload 12
    //   754: invokevirtual 175	java/io/File:exists	()Z
    //   757: ifeq -187 -> 570
    //   760: iconst_2
    //   761: anewarray 92	java/lang/String
    //   764: dup
    //   765: iconst_0
    //   766: ldc_w 951
    //   769: aastore
    //   770: dup
    //   771: iconst_1
    //   772: aload 12
    //   774: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   777: aastore
    //   778: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   781: aload 13
    //   783: astore_0
    //   784: iload 7
    //   786: istore 6
    //   788: goto -218 -> 570
    //   791: astore_0
    //   792: iload 4
    //   794: istore 8
    //   796: aload 11
    //   798: astore_3
    //   799: iload 10
    //   801: istore 5
    //   803: aload_0
    //   804: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   807: aload 13
    //   809: astore_0
    //   810: iload 7
    //   812: istore 6
    //   814: goto -244 -> 570
    //   817: astore_0
    //   818: aload_0
    //   819: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   822: iload 8
    //   824: istore 4
    //   826: aload_3
    //   827: astore_0
    //   828: goto -123 -> 705
    //   831: aload 12
    //   833: invokevirtual 195	java/io/File:delete	()Z
    //   836: pop
    //   837: aload_1
    //   838: new 208	java/lang/StringBuilder
    //   841: dup
    //   842: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   845: aload_0
    //   846: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: ldc_w 1324
    //   852: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: iconst_0
    //   859: invokestatic 1328	dalvik/system/DexFile:loadDex	(Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;
    //   862: astore_3
    //   863: aload_3
    //   864: astore 11
    //   866: iload 4
    //   868: istore 8
    //   870: aload 11
    //   872: astore_3
    //   873: iload 10
    //   875: istore 5
    //   877: iload 6
    //   879: istore 7
    //   881: getstatic 1239	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
    //   884: new 208	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   891: aload_0
    //   892: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: ldc_w 1324
    //   898: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: aload 12
    //   906: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   909: invokestatic 1332	com/chelpus/Utils:dalvikvm_copyFile	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   912: ifeq +26 -> 938
    //   915: iload 4
    //   917: istore 8
    //   919: aload 11
    //   921: astore_3
    //   922: iload 10
    //   924: istore 5
    //   926: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   929: ldc_w 1334
    //   932: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   935: iconst_1
    //   936: istore 7
    //   938: iload 4
    //   940: istore 8
    //   942: aload 11
    //   944: astore_3
    //   945: iload 7
    //   947: istore 5
    //   949: new 171	java/io/File
    //   952: dup
    //   953: new 208	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   960: aload_0
    //   961: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: ldc_w 1324
    //   967: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   976: invokevirtual 195	java/io/File:delete	()Z
    //   979: pop
    //   980: aload 11
    //   982: astore_0
    //   983: iload 7
    //   985: istore 6
    //   987: iload 4
    //   989: istore 8
    //   991: aload 11
    //   993: astore_3
    //   994: iload 7
    //   996: istore 5
    //   998: aload 12
    //   1000: invokevirtual 175	java/io/File:exists	()Z
    //   1003: ifeq -433 -> 570
    //   1006: aload 11
    //   1008: astore_0
    //   1009: iload 7
    //   1011: istore 6
    //   1013: iload 4
    //   1015: istore 8
    //   1017: aload 11
    //   1019: astore_3
    //   1020: iload 7
    //   1022: istore 5
    //   1024: aload 12
    //   1026: invokevirtual 311	java/io/File:length	()J
    //   1029: lconst_0
    //   1030: lcmp
    //   1031: ifne -461 -> 570
    //   1034: iload 4
    //   1036: istore 8
    //   1038: aload 11
    //   1040: astore_3
    //   1041: iload 7
    //   1043: istore 5
    //   1045: aload 12
    //   1047: invokevirtual 195	java/io/File:delete	()Z
    //   1050: pop
    //   1051: aload 11
    //   1053: astore_0
    //   1054: iload 7
    //   1056: istore 6
    //   1058: goto -488 -> 570
    //   1061: astore 13
    //   1063: iload 4
    //   1065: istore 8
    //   1067: aload 11
    //   1069: astore_3
    //   1070: iload 10
    //   1072: istore 5
    //   1074: aload 13
    //   1076: invokevirtual 1335	java/lang/RuntimeException:printStackTrace	()V
    //   1079: aload 14
    //   1081: astore 11
    //   1083: goto -217 -> 866
    //   1086: astore 13
    //   1088: iload 4
    //   1090: istore 8
    //   1092: aload 11
    //   1094: astore_3
    //   1095: iload 10
    //   1097: istore 5
    //   1099: aload 13
    //   1101: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1104: aload 14
    //   1106: astore 11
    //   1108: goto -242 -> 866
    //   1111: iload 4
    //   1113: istore 8
    //   1115: aload_0
    //   1116: astore_3
    //   1117: iload 6
    //   1119: istore 5
    //   1121: iconst_3
    //   1122: anewarray 92	java/lang/String
    //   1125: dup
    //   1126: iconst_0
    //   1127: ldc_w 453
    //   1130: aastore
    //   1131: dup
    //   1132: iconst_1
    //   1133: ldc_w 1319
    //   1136: aastore
    //   1137: dup
    //   1138: iconst_2
    //   1139: aload 12
    //   1141: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1144: aastore
    //   1145: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1148: iload 4
    //   1150: istore 8
    //   1152: aload_0
    //   1153: astore_3
    //   1154: iload 6
    //   1156: istore 5
    //   1158: iconst_3
    //   1159: anewarray 92	java/lang/String
    //   1162: dup
    //   1163: iconst_0
    //   1164: ldc_w 461
    //   1167: aastore
    //   1168: dup
    //   1169: iconst_1
    //   1170: new 208	java/lang/StringBuilder
    //   1173: dup
    //   1174: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1177: ldc_w 465
    //   1180: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: aload_2
    //   1184: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1190: aastore
    //   1191: dup
    //   1192: iconst_2
    //   1193: aload 12
    //   1195: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1198: aastore
    //   1199: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1202: iload 4
    //   1204: istore 8
    //   1206: aload_0
    //   1207: astore_3
    //   1208: iload 6
    //   1210: istore 5
    //   1212: iconst_3
    //   1213: anewarray 92	java/lang/String
    //   1216: dup
    //   1217: iconst_0
    //   1218: ldc_w 461
    //   1221: aastore
    //   1222: dup
    //   1223: iconst_1
    //   1224: new 208	java/lang/StringBuilder
    //   1227: dup
    //   1228: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1231: ldc_w 463
    //   1234: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: aload_2
    //   1238: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1244: aastore
    //   1245: dup
    //   1246: iconst_2
    //   1247: aload 12
    //   1249: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1252: aastore
    //   1253: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   1256: iload 6
    //   1258: istore 5
    //   1260: goto -555 -> 705
    //   1263: astore_0
    //   1264: aload_0
    //   1265: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   1268: goto -555 -> 713
    //   1271: iload 4
    //   1273: ifeq +9 -> 1282
    //   1276: iconst_0
    //   1277: ifeq +5 -> 1282
    //   1280: iconst_2
    //   1281: ireturn
    //   1282: iload 4
    //   1284: ifeq +10 -> 1294
    //   1287: iload 5
    //   1289: ifne +5 -> 1294
    //   1292: iconst_1
    //   1293: ireturn
    //   1294: iload 4
    //   1296: ifeq +10 -> 1306
    //   1299: iload 5
    //   1301: ifeq +5 -> 1306
    //   1304: iconst_0
    //   1305: ireturn
    //   1306: iload 4
    //   1308: ifne +10 -> 1318
    //   1311: iload 5
    //   1313: ifne +5 -> 1318
    //   1316: iconst_1
    //   1317: ireturn
    //   1318: iload 9
    //   1320: istore 6
    //   1322: iload 4
    //   1324: ifne -604 -> 720
    //   1327: iload 9
    //   1329: istore 6
    //   1331: iload 5
    //   1333: ifeq -613 -> 720
    //   1336: iconst_0
    //   1337: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1338	0	paramString1	String
    //   0	1338	1	paramString2	String
    //   0	1338	2	paramString3	String
    //   0	1338	3	paramString4	String
    //   223	1100	4	i	int
    //   208	1124	5	j	int
    //   145	1185	6	k	int
    //   148	907	7	m	int
    //   201	1004	8	n	int
    //   1	1327	9	i1	int
    //   142	954	10	i2	int
    //   79	192	11	localObject1	Object
    //   723	74	11	localException1	Exception
    //   864	243	11	localObject2	Object
    //   73	1175	12	localObject3	Object
    //   198	610	13	localObject4	Object
    //   1061	14	13	localRuntimeException	RuntimeException
    //   1086	14	13	localException2	Exception
    //   195	910	14	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   75	81	723	java/lang/Exception
    //   286	295	791	java/lang/Exception
    //   298	312	791	java/lang/Exception
    //   316	330	791	java/lang/Exception
    //   334	348	791	java/lang/Exception
    //   352	366	791	java/lang/Exception
    //   370	405	791	java/lang/Exception
    //   405	563	791	java/lang/Exception
    //   739	745	791	java/lang/Exception
    //   752	781	791	java/lang/Exception
    //   210	222	817	java/lang/Exception
    //   236	244	817	java/lang/Exception
    //   255	261	817	java/lang/Exception
    //   277	286	817	java/lang/Exception
    //   580	590	817	java/lang/Exception
    //   600	627	817	java/lang/Exception
    //   637	664	817	java/lang/Exception
    //   674	701	817	java/lang/Exception
    //   803	807	817	java/lang/Exception
    //   881	915	817	java/lang/Exception
    //   926	935	817	java/lang/Exception
    //   949	980	817	java/lang/Exception
    //   998	1006	817	java/lang/Exception
    //   1024	1034	817	java/lang/Exception
    //   1045	1051	817	java/lang/Exception
    //   1074	1079	817	java/lang/Exception
    //   1099	1104	817	java/lang/Exception
    //   1121	1148	817	java/lang/Exception
    //   1158	1202	817	java/lang/Exception
    //   1212	1256	817	java/lang/Exception
    //   831	863	1061	java/lang/RuntimeException
    //   831	863	1086	java/lang/Exception
    //   709	713	1263	java/io/IOException
  }
  
  public static int create_ODEX_root(String paramString1, ArrayList<File> paramArrayList, String paramString2, String paramString3, String paramString4)
  {
    int i8 = 0;
    run_all_no_root(new String[] { "chmod", "777", paramString1 });
    run_all_no_root(new String[] { "chown", "0:0", paramString1 });
    run_all_no_root(new String[] { "chown", "0.0", paramString1 });
    Object localObject1 = paramString4;
    if (paramString4 == null) {
      localObject1 = getOdexForCreate(paramString2, paramString3);
    }
    int i = 0;
    int i10 = 0;
    int i5 = 0;
    int i4 = 1;
    int m = 1;
    int i9 = 1;
    int i3 = 0;
    int k = 0;
    int i7 = 0;
    String str2 = new File(paramString2).getName();
    String str3 = getOdexForCreate(paramString2, paramString3);
    File localFile = getFileDalvikCacheName(paramString2);
    paramString4 = new File(paramString2).getName();
    Object localObject3 = changeExtension(paramString4, "odex");
    changeExtension(paramString4, "dex");
    String str4 = paramString1 + "/" + (String)localObject3;
    String str1 = null;
    localObject3 = null;
    Object localObject5 = null;
    int i6 = 0;
    paramString4 = (String)localObject5;
    int j = i5;
    int i2 = i9;
    int i1 = i7;
    int n;
    Object localObject6;
    Object localObject7;
    try
    {
      if (getCurrentRuntimeValue().contains("ART")) {
        n = 1;
      }
      for (;;)
      {
        i6 = n;
        paramString4 = (String)localObject5;
        j = i5;
        i2 = i9;
        i1 = i7;
        localObject6 = paramArrayList.iterator();
        i6 = n;
        paramString4 = (String)localObject5;
        j = i5;
        i2 = i9;
        i1 = i7;
        if (!((Iterator)localObject6).hasNext()) {
          break label700;
        }
        i6 = n;
        paramString4 = (String)localObject5;
        j = i5;
        i2 = i9;
        i1 = i7;
        localObject7 = (File)((Iterator)localObject6).next();
        i6 = n;
        paramString4 = (String)localObject5;
        j = i5;
        i2 = i9;
        i1 = i7;
        run_all_no_root(new String[] { "chmod", "777", paramString1 + "/" + ((File)localObject7).getName() });
        i6 = n;
        paramString4 = (String)localObject5;
        j = i5;
        i2 = i9;
        i1 = i7;
        boolean bool = ((File)localObject7).exists();
        if (bool) {
          break label542;
        }
        if (0 != 0)
        {
          i6 = n;
          paramString4 = (String)localObject5;
          j = i5;
          i2 = i9;
          i1 = i7;
        }
        try
        {
          throw new NullPointerException();
          j = 4;
          label466:
          return j;
          n = 0;
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            paramString1.printStackTrace();
          }
        }
      }
      if (paramArrayList == null) {}
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      m = i1;
      i7 = i2;
      i = j;
      paramArrayList = paramString4;
      k = i6;
    }
    for (;;)
    {
      label542:
      label700:
      Object localObject4;
      Object localObject2;
      try
      {
        paramArrayList.close();
        if (i7 == 0)
        {
          return 3;
          i6 = n;
          paramString4 = (String)localObject5;
          j = i5;
          i2 = i9;
          i1 = i7;
          run_all_no_root(new String[] { "chmod", "777", paramString1 + "/" + ((File)localObject7).getName() });
          i6 = n;
          paramString4 = (String)localObject5;
          j = i5;
          i2 = i9;
          i1 = i7;
          run_all_no_root(new String[] { "chown", "1000." + paramString3, paramString1 + "/" + ((File)localObject7).getName() });
          break;
          i6 = n;
          paramString4 = (String)localObject5;
          j = i5;
          i2 = i9;
          i1 = i7;
          run_all_no_root(new String[] { "chmod", "777", paramString1 + "/AndroidManifest.xml" });
          i6 = n;
          paramString4 = (String)localObject5;
          j = i5;
          i2 = i9;
          i1 = i7;
          run_all_no_root(new String[] { "chown", "1000." + paramString3, paramString1 + "/AndroidManifest.xml" });
          i6 = n;
          paramString4 = (String)localObject5;
          j = i5;
          i2 = i9;
          i1 = i7;
          new File(paramString1 + "/" + str2).delete();
          i6 = n;
          paramString4 = (String)localObject5;
          j = i5;
          i2 = i9;
          i1 = i7;
          if (new File(paramString1 + "/" + str2).exists())
          {
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "rm", paramString1 + "/" + str2 });
          }
          i6 = n;
          paramString4 = (String)localObject5;
          j = i5;
          i2 = i9;
          i1 = i7;
          localObject6 = getFileDalvikCacheName(paramString2);
          i6 = n;
          paramString4 = (String)localObject5;
          j = i5;
          i2 = i9;
          i1 = i7;
          ((File)localObject6).getName();
          if (n != 0)
          {
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            System.out.println("dex-opt-art");
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            localObject7 = zipART(str2, paramString1, paramArrayList, paramString2);
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (!((String)localObject7).equals(""))
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (new File((String)localObject7).exists()) {}
            }
            else
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println("Error: dont create rebuild apk to /data/tmp/");
              paramString4 = "";
            }
            try
            {
              if (((File)localObject6).getAbsolutePath().contains("/arm/")) {
                paramString4 = "arm";
              }
              if (((File)localObject6).getAbsolutePath().contains("/arm64/")) {
                paramString4 = "arm64";
              }
              if (((File)localObject6).getAbsolutePath().contains("/x86/")) {
                paramString4 = "x86";
              }
              if (((File)localObject6).getAbsolutePath().contains("/x86_64/")) {
                paramString4 = "x86_64";
              }
              new File(str4).delete();
              if (new File(str4).exists()) {
                run_all_no_root(new String[] { "rm", str4 });
              }
              System.out.println("try create oat with dex2oat:");
              System.out.println(cmdParam(new String[] { "dex2oat", "--dex-file=" + (String)localObject7, "--oat-file=" + str4, "--instruction-set=" + paramString4 }));
              System.out.println("end");
              if ((!new File(str4).exists()) || (new File(str4).length() == 0L)) {
                continue;
              }
              System.out.println("oat created with dex2oat - length=" + new File(str4).length());
              fixCRCart(new File(str4), paramArrayList, paramString2, (String)localObject7);
            }
            catch (Exception localException2)
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              localException2.printStackTrace();
              continue;
              i6 = n;
              paramString4 = (String)localObject5;
              j = k;
              i2 = i9;
              i1 = i7;
              run_all_no_root(new String[] { "chmod", "0644", paramArrayList });
              i6 = n;
              paramString4 = (String)localObject5;
              j = k;
              i2 = i9;
              i1 = i7;
              run_all_no_root(new String[] { "chown", "1000." + paramString3, paramArrayList });
              i6 = n;
              paramString4 = (String)localObject5;
              j = k;
              i2 = i9;
              i1 = i7;
              run_all_no_root(new String[] { "chown", "1000:" + paramString3, paramArrayList });
              continue;
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              new File(str3).delete();
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (!new File(str3).exists()) {
                break label7896;
              }
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            localObject3 = new File(str4);
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (((File)localObject3).exists())
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (((File)localObject3).length() == 0L)
              {
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                ((File)localObject3).delete();
              }
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (!new File(((File)localObject3).getAbsolutePath()).exists()) {
              break label7941;
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            System.out.println("oat file found. try copy and permission apply.");
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            new File(str3).delete();
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (new File(str3).exists())
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              run_all_no_root(new String[] { "rm", str3 });
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, ((File)localObject3).getAbsolutePath(), (String)localObject1))
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println("Free space for odex enougth.");
              i = 1;
              i5 = 1;
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (listAppsFragment.api >= 23)
              {
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                k = i4;
                m = i3;
                paramArrayList = (ArrayList<File>)localObject1;
                if (!localFile.exists()) {}
              }
              else
              {
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                if (!dalvikvm_copyFile(listAppsFragment.toolfilesdir, str4, localFile.getAbsolutePath())) {
                  continue;
                }
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                paramArrayList = localFile.getAbsolutePath();
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                if (new File(paramArrayList + ".art").exists())
                {
                  i6 = n;
                  paramString4 = (String)localObject5;
                  j = i5;
                  i2 = i9;
                  i1 = i7;
                  new File(paramArrayList + ".art").delete();
                }
                i = 1;
                k = 1;
                i6 = n;
                paramString4 = (String)localObject5;
                j = k;
                i2 = i9;
                i1 = i7;
                if (!paramString2.startsWith("/system")) {
                  continue;
                }
                i6 = n;
                paramString4 = (String)localObject5;
                j = k;
                i2 = i9;
                i1 = i7;
                run_all_no_root(new String[] { "chmod", "0644", paramArrayList });
                i6 = n;
                paramString4 = (String)localObject5;
                j = k;
                i2 = i9;
                i1 = i7;
                run_all_no_root(new String[] { "chown", "0.0", paramArrayList });
                i6 = n;
                paramString4 = (String)localObject5;
                j = k;
                i2 = i9;
                i1 = i7;
                run_all_no_root(new String[] { "chown", "0:0", paramArrayList });
                i6 = n;
                paramString4 = (String)localObject5;
                j = k;
                i2 = i9;
                i1 = i7;
                paramArrayList = getOdexForCreate(paramString2, paramString3);
                m = i3;
                k = i4;
              }
              i6 = n;
              paramString4 = (String)localObject5;
              j = i;
              i2 = k;
              i1 = m;
              run_all_no_root(new String[] { "chmod", "777", "/data/tmp" });
            }
            try
            {
              paramString4 = new File("/data/tmp").listFiles();
              localObject1 = str1;
              i4 = i;
              i5 = k;
              i3 = m;
              localObject3 = paramArrayList;
              if (paramString4 == null) {
                continue;
              }
              i1 = paramString4.length;
              j = 0;
              localObject1 = str1;
              i4 = i;
              i5 = k;
              i3 = m;
              localObject3 = paramArrayList;
              if (j >= i1) {
                continue;
              }
              localObject3 = paramString4[j];
              localObject1 = new Utils("1");
              ((File)localObject3).delete();
              if (((File)localObject3).exists()) {
                ((Utils)localObject1).deleteFolder((File)localObject3);
              }
              j += 1;
              continue;
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println("apk found and copy created apk size " + new File((String)localObject7).length());
            }
            catch (Exception localException1)
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i;
              i2 = k;
              i1 = m;
              localException1.printStackTrace();
              localObject4 = paramArrayList;
              i3 = m;
              i5 = k;
              i4 = i;
              localObject2 = str1;
            }
            new File(str4).delete();
            if (!new File(str4).exists()) {
              continue;
            }
            run_all_no_root(new String[] { "rm", str4 });
            continue;
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "rm", str3 });
            break label7896;
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            System.out.println("Error:Free space for odex not enougth.");
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (localException2.exists())
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              localException2.delete();
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (localException2.exists())
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              run_all_no_root(new String[] { "rm", localException2.getAbsolutePath() });
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            new File(str3).delete();
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (new File(str3).exists())
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              run_all_no_root(new String[] { "rm", str3 });
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (new File(getOdexForCreate(paramString2, paramString3)).exists())
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println("Error:dont delete corrupt odex.");
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            localObject4 = localFile.getAbsolutePath();
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (!((String)localObject7).equals(""))
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (new File((String)localObject7).exists()) {}
            }
            else
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println("Error: dont create rebuild apk to /data/tmp/");
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println("try create oat with DexFile2:");
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              str4 = paramString1 + "/" + localFile.getName();
              localObject1 = "";
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (((File)localObject6).getAbsolutePath().contains("/arm/")) {
                localObject1 = "arm";
              }
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (((File)localObject6).getAbsolutePath().contains("/arm64/")) {
                localObject1 = "arm64";
              }
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (((File)localObject6).getAbsolutePath().contains("/x86/")) {
                localObject1 = "x86";
              }
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (((File)localObject6).getAbsolutePath().contains("/x86_64/")) {
                localObject1 = "x86_64";
              }
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              new File(str4).delete();
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (new File(str4).exists())
              {
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                run_all_no_root(new String[] { "rm", str4 });
              }
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println("try create oat with dex2oat:");
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println(cmdParam(new String[] { "dex2oat", "--dex-file=" + (String)localObject7, "--oat-file=" + str4, "--instruction-set=" + (String)localObject1 }));
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println("end");
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (new File(str4).exists())
              {
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                System.out.println("oat2 created with dex2oat - length=" + new File(str4).length());
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                fixCRCart(new File(str4), paramArrayList, paramString2, (String)localObject7);
              }
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              paramArrayList = new File(str4);
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (paramArrayList.exists())
              {
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                if (paramArrayList.length() == 0L)
                {
                  i6 = n;
                  paramString4 = (String)localObject5;
                  j = i5;
                  i2 = i9;
                  i1 = i7;
                  paramArrayList.delete();
                }
              }
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (!new File(paramArrayList.getAbsolutePath()).exists()) {
                break label7928;
              }
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println("oat file found. try copy and permission apply.");
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (!dalvikvm_copyFile(listAppsFragment.toolfilesdir, str4, localFile.getAbsolutePath())) {
                continue;
              }
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              paramArrayList = localFile.getAbsolutePath();
              i = 0;
              k = i4;
              m = i3;
              continue;
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            System.out.println("apk found and copy created apk2");
            continue;
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            new File(str3).delete();
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (!new File(str3).exists()) {
              break label7912;
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "rm", str3 });
            break label7912;
            i6 = n;
            paramString4 = (String)localObject2;
            j = i4;
            i2 = i5;
            i1 = i3;
            if (paramString2.startsWith("/system"))
            {
              i6 = n;
              paramString4 = (String)localObject2;
              j = i4;
              i2 = i5;
              i1 = i3;
              run_all_no_root(new String[] { "chmod", "0644", localObject4 });
              i6 = n;
              paramString4 = (String)localObject2;
              j = i4;
              i2 = i5;
              i1 = i3;
              run_all_no_root(new String[] { "chown", "0.0", localObject4 });
              i6 = n;
              paramString4 = (String)localObject2;
              j = i4;
              i2 = i5;
              i1 = i3;
              run_all_no_root(new String[] { "chown", "0:0", localObject4 });
              i6 = n;
              paramString4 = (String)localObject2;
              j = i4;
              i2 = i5;
              i1 = i3;
              new File(paramString1 + "/" + localFile.getName()).delete();
              i6 = n;
              paramString4 = (String)localObject2;
              j = i4;
              i2 = i5;
              i1 = i3;
              new File(paramString1 + "/" + localFile.getName()).delete();
              i6 = n;
              paramString4 = (String)localObject2;
              j = i4;
              i2 = i5;
              i1 = i3;
              new File(paramString1 + "/" + str2).delete();
              i6 = n;
              paramString4 = (String)localObject2;
              j = i4;
              i2 = i5;
              i1 = i3;
              k = n;
              paramArrayList = (ArrayList<File>)localObject2;
              i = i4;
              i7 = i5;
              m = i3;
              if (!new File(paramString1 + "/" + str2).exists()) {
                continue;
              }
              i6 = n;
              paramString4 = (String)localObject2;
              j = i4;
              i2 = i5;
              i1 = i3;
              run_all_no_root(new String[] { "rm", paramString1 + "/" + str2 });
              k = n;
              paramArrayList = (ArrayList<File>)localObject2;
              i = i4;
              i7 = i5;
              m = i3;
            }
          }
          else
          {
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            zip(str2, paramString1, paramArrayList, paramString1 + "/" + str2);
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "chmod", "777", paramString1 + "/" + str2 });
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "chown", "1000." + paramString3, paramString1 + "/" + str2 });
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "chown", "1000:" + paramString3, paramString1 + "/" + str2 });
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (new File(paramString1 + "/" + str2).exists())
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (new File(paramString1 + "/" + str2).length() != 0L)
              {
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                System.out.println("LuckyPatcher (CustomPatch): foundreworked apk " + paramString1 + "/" + str2);
              }
            }
            i6 = n;
            paramString4 = (String)localObject5;
            j = i5;
            i2 = i9;
            i1 = i7;
            if (new File(paramString1 + "/" + str2).exists())
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (new File(paramString1 + "/" + str2).length() == 0L)
              {
                i6 = n;
                paramString4 = (String)localObject5;
                j = i5;
                i2 = i9;
                i1 = i7;
                new File(paramString1 + "/" + str2).delete();
              }
            }
            try
            {
              new File(paramString1 + "/" + localFile.getName()).delete();
              paramArrayList = DexFile.loadDex(paramString1 + "/" + str2, paramString1 + "/" + localFile.getName(), 0);
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              str1 = localFile.getName();
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println(str1);
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              System.out.println(paramString1 + "/" + str1);
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              localObject4 = new File(paramString1 + "/" + str1);
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (((File)localObject4).exists())
              {
                i6 = n;
                paramString4 = paramArrayList;
                j = i5;
                i2 = i9;
                i1 = i7;
                if (((File)localObject4).length() == 0L)
                {
                  i6 = n;
                  paramString4 = paramArrayList;
                  j = i5;
                  i2 = i9;
                  i1 = i7;
                  ((File)localObject4).delete();
                }
              }
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              i = i10;
              localObject5 = localObject2;
              if (new File(((File)localObject4).getAbsolutePath()).exists())
              {
                i6 = n;
                paramString4 = paramArrayList;
                j = i5;
                i2 = i9;
                i1 = i7;
                fixadlerOdex((File)localObject4, paramString2);
                i6 = n;
                paramString4 = paramArrayList;
                j = i5;
                i2 = i9;
                i1 = i7;
                if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, paramString1 + "/" + str1, (String)localObject2))
                {
                  i6 = n;
                  paramString4 = paramArrayList;
                  j = i5;
                  i2 = i9;
                  i1 = i7;
                  System.out.println("Free space for odex enougth.");
                  i = 1;
                  localObject5 = localObject2;
                }
              }
              else
              {
                localObject2 = paramArrayList;
                i4 = i;
                i5 = m;
                i3 = k;
                localObject4 = localObject5;
                if (i == 0) {
                  continue;
                }
                localObject2 = paramArrayList;
                i4 = i;
                i5 = m;
                i3 = k;
                localObject4 = localObject5;
                if (n != 0) {
                  continue;
                }
                i6 = n;
                paramString4 = paramArrayList;
                j = i;
                i2 = i9;
                i1 = i7;
                localObject2 = paramArrayList;
                i4 = i;
                i5 = m;
                i3 = k;
                localObject4 = localObject5;
                if (new File(str3).exists()) {
                  continue;
                }
                i6 = n;
                paramString4 = paramArrayList;
                j = i;
                i2 = i9;
                i1 = i7;
                System.out.println("lackypatch: dexopt-wrapper used!");
                i6 = n;
                paramString4 = paramArrayList;
                j = i;
                i2 = i9;
                i1 = i7;
                run_all_no_root(new String[] { "chown", "0.0", paramString1 + "/dexopt-wrapper" });
                i6 = n;
                paramString4 = paramArrayList;
                j = i;
                i2 = i9;
                i1 = i7;
                run_all_no_root(new String[] { "chown", "0:0", paramString1 + "/dexopt-wrapper" });
                i6 = n;
                paramString4 = paramArrayList;
                j = i;
                i2 = i9;
                i1 = i7;
                run_all_no_root(new String[] { "chmod", "777", paramString1 + "/dexopt-wrapper" });
                i6 = n;
                paramString4 = paramArrayList;
                j = i;
                i2 = i9;
                i1 = i7;
                localObject2 = cmdParam(new String[] { listAppsFragment.toolfilesdir + "/dexopt-wrapper", paramString1 + "/" + str2, str3 });
                i6 = n;
                paramString4 = paramArrayList;
                j = i;
                i2 = i9;
                i1 = i7;
                System.out.println((String)localObject2);
                i6 = n;
                paramString4 = paramArrayList;
                j = i;
                i2 = i9;
                i1 = i7;
                if (!((String)localObject2).contains("succes")) {
                  continue;
                }
                i6 = n;
                paramString4 = paramArrayList;
                j = i;
                i2 = i9;
                i1 = i7;
                if (((String)localObject2).contains("failed")) {
                  continue;
                }
                i6 = n;
                paramString4 = paramArrayList;
                j = i;
                i2 = i9;
                i1 = i7;
                fixadlerOdex(new File(str3), paramString2);
                localObject2 = paramArrayList;
                i4 = i;
                i5 = m;
                i3 = k;
                localObject4 = localObject5;
              }
            }
            catch (RuntimeException paramArrayList)
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              paramArrayList.printStackTrace();
              paramArrayList = (ArrayList<File>)localObject4;
              continue;
            }
            catch (Exception paramArrayList)
            {
              i6 = n;
              paramString4 = (String)localObject5;
              j = i5;
              i2 = i9;
              i1 = i7;
              paramArrayList.printStackTrace();
              paramArrayList = (ArrayList<File>)localObject4;
              continue;
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              new File(str3).delete();
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (new File(str3).exists())
              {
                i6 = n;
                paramString4 = paramArrayList;
                j = i5;
                i2 = i9;
                i1 = i7;
                run_all_no_root(new String[] { "rm", str3 });
              }
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              fixadlerOdex(new File(listAppsFragment.toolfilesdir, paramString1 + "/" + str1), paramString2);
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, paramString1 + "/" + str1, localFile.getAbsolutePath()))
              {
                i6 = n;
                paramString4 = paramArrayList;
                j = i5;
                i2 = i9;
                i1 = i7;
                localObject5 = localFile.getAbsolutePath();
                i = 0;
                continue;
              }
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              new File(str3).delete();
              i6 = n;
              paramString4 = paramArrayList;
              j = i5;
              i2 = i9;
              i1 = i7;
              if (!new File(str3).exists()) {
                break label7954;
              }
            }
            i6 = n;
            paramString4 = paramArrayList;
            j = i5;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "rm", str3 });
            break label7954;
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            new File(str3).delete();
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "rm", str3 });
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            localObject4 = localFile.getAbsolutePath();
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            if (new File(str3).exists())
            {
              i6 = n;
              paramString4 = paramArrayList;
              j = i;
              i2 = i9;
              i1 = i7;
              run_all_no_root(new String[] { "rm", localObject4 });
            }
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "rm", paramString1 + "/" + str1 });
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            cmdParam(new String[] { listAppsFragment.toolfilesdir + "/dexopt-wrapper", paramString1 + "/" + str2, paramString1 + "/" + str1 });
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "chmod", "777", paramString1 + "/" + str1 });
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "chown", "0.0", paramString1 + "/" + str1 });
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            run_all_no_root(new String[] { "chown", "0:0", paramString1 + "/" + str1 });
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            fixadlerOdex(new File(paramString1 + "/" + str1), paramString2);
            i6 = n;
            paramString4 = paramArrayList;
            j = i;
            i2 = i9;
            i1 = i7;
            copyFile(paramString1 + "/" + str1, (String)localObject4, false, true);
            localObject2 = paramArrayList;
            i4 = i;
            i5 = m;
            i3 = k;
            continue;
          }
          i6 = n;
          paramString4 = (String)localObject2;
          j = i4;
          i2 = i5;
          i1 = i3;
          run_all_no_root(new String[] { "chmod", "0644", localObject4 });
          i6 = n;
          paramString4 = (String)localObject2;
          j = i4;
          i2 = i5;
          i1 = i3;
          run_all_no_root(new String[] { "chown", "1000." + paramString3, localObject4 });
          i6 = n;
          paramString4 = (String)localObject2;
          j = i4;
          i2 = i5;
          i1 = i3;
          run_all_no_root(new String[] { "chown", "1000:" + paramString3, localObject4 });
          continue;
        }
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        continue;
        if ((k != 0) && (m != 0)) {
          return 2;
        }
        if ((k != 0) && (i == 0)) {
          return 1;
        }
        if ((k != 0) && (i != 0)) {
          return 0;
        }
        if ((k == 0) && (i == 0)) {
          return 1;
        }
        j = i8;
      }
      if (k != 0) {
        break label466;
      }
      j = i8;
      if (i == 0) {
        break label466;
      }
      return 0;
      label7896:
      i = 0;
      k = 0;
      m = i3;
      paramArrayList = (ArrayList<File>)localObject2;
      continue;
      label7912:
      i = 0;
      k = 0;
      m = i3;
      paramArrayList = (ArrayList<File>)localObject4;
      continue;
      label7928:
      m = 1;
      k = i4;
      paramArrayList = (ArrayList<File>)localObject4;
      continue;
      label7941:
      m = 1;
      k = i4;
      paramArrayList = (ArrayList<File>)localObject2;
      continue;
      label7954:
      i = 0;
      localObject5 = localObject2;
    }
  }
  
  public static boolean dalvikvm_copyFile(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new File(paramString2);
    File localFile = new File(paramString3);
    if (paramString1.exists())
    {
      remount(paramString3, "RW");
      cmdParam(new String[] { "dd", "if=" + paramString2, "of=" + paramString3 });
      if ((!new File(paramString3).exists()) || (paramString1.length() != localFile.length())) {
        cmdParam(new String[] { "busybox", "dd", "if=" + paramString2, "of=" + paramString3 });
      }
      if ((!new File(paramString3).exists()) || (paramString1.length() != localFile.length())) {
        cmdParam(new String[] { listAppsFragment.toolfilesdir + "/busybox", "dd", "if=" + paramString2, "of=" + paramString3 });
      }
      if ((paramString1.length() != localFile.length()) && (paramString1.length() != 0L))
      {
        localFile.delete();
        System.out.println("Length of Files not equals. Destination deleted!");
        return false;
      }
      System.out.println(localFile.length());
      System.out.println("File copied!");
      return true;
    }
    System.out.println("Source File not Found!");
    return false;
  }
  
  public static int dexopt(String paramString1, String paramString2, String paramString3, String paramString4, Boolean paramBoolean)
  {
    int m = 0;
    System.out.println(paramString2);
    new File(paramString2).mkdirs();
    run_all_no_root(new String[] { "chmod", "777", paramString1 });
    run_all_no_root(new String[] { "chmod", "777", getDirs(new File(paramString2)).getAbsolutePath() });
    run_all_no_root(new String[] { "chown", "0:0", getDirs(new File(paramString2)).getAbsolutePath() });
    run_all_no_root(new String[] { "chown", "0.0", getDirs(new File(paramString2)).getAbsolutePath() });
    run_all_no_root(new String[] { "chmod", "777", paramString2 });
    run_all_no_root(new String[] { "chown", "0:0", paramString2 });
    run_all_no_root(new String[] { "chown", "0.0", paramString2 });
    String str1 = paramString3;
    if (paramString3 == null) {
      str1 = getOdexForCreate(paramString1, paramString4);
    }
    if (str1 != null) {
      remount(str1, "rw");
    }
    int n = 0;
    int j = 0;
    String str2 = getOdexForCreate(paramString1, paramString4);
    paramString3 = new File(paramString1).getName();
    changeExtension(paramString3, "odex");
    paramString3 = changeExtension(paramString3, "dex");
    String str3 = paramString2 + "/" + paramString3;
    int i = n;
    for (;;)
    {
      try
      {
        localFile = getFileDalvikCacheName(paramString1);
        i = n;
        localFile.getName();
        i = n;
        System.out.println("dex-opt-art");
        i = n;
        if (new File(str3).exists())
        {
          i = n;
          new File(str3).delete();
        }
      }
      catch (Exception paramString3)
      {
        File localFile;
        int k;
        paramString3.printStackTrace();
        m = 4;
        j = i;
        continue;
        i = j;
        run_all_no_root(new String[] { "chmod", "0644", str1 });
        i = j;
        run_all_no_root(new String[] { "chown", "1000." + paramString4, str1 });
        i = j;
        run_all_no_root(new String[] { "chown", "1000:" + paramString4, str1 });
        m = k;
        continue;
        if (!new File(paramString2).exists()) {
          continue;
        }
        new File(paramString2).delete();
        run_all_no_root(new String[] { "chmod", "644", paramString1 });
        if (j != 0) {
          break label1816;
        }
        m = 1;
      }
      try
      {
        if (!paramBoolean.booleanValue()) {
          continue;
        }
        paramString3 = "";
        if (localFile.getAbsolutePath().contains("/arm/")) {
          paramString3 = "arm";
        }
        if (localFile.getAbsolutePath().contains("/arm64/")) {
          paramString3 = "arm64";
        }
        if (localFile.getAbsolutePath().contains("/x86/")) {
          paramString3 = "x86";
        }
        if (localFile.getAbsolutePath().contains("/x86_64/")) {
          paramString3 = "x86_64";
        }
        System.out.println("try create oat with dex2oat:");
        System.out.println(cmdParam(new String[] { "dex2oat", "--dex-file=" + paramString1, "--oat-file=" + str3, "--instruction-set=" + paramString3 }));
        System.out.println("end");
        if ((new File(str3).exists()) && (new File(str3).length() != 0L)) {
          continue;
        }
        new File(str3).delete();
        k = m;
        if (new File(str3).exists())
        {
          run_all_no_root(new String[] { "rm", str3 });
          k = m;
        }
      }
      catch (Exception paramString3)
      {
        i = n;
        paramString3.printStackTrace();
        k = 4;
        continue;
        System.out.println("try create oat with DexFile.");
        try
        {
          new File(str3).delete();
          DexFile.loadDex(paramString1, str3, 0).close();
          System.out.println("end. check file. ");
          if (new File(str3).exists()) {
            System.out.println("found file " + str3 + " " + new File(str3).length());
          }
          if (new File(str1).exists()) {
            System.out.println("found file " + str1 + " " + new File(str1).length());
          }
          if ((!new File(str3).exists()) || (new File(str3).length() == 0L))
          {
            new File(str3).delete();
            if (new File(str3).exists()) {
              run_all_no_root(new String[] { "rm", str3 });
            }
            if (new File(str3).exists())
            {
              k = m;
              if (new File(str3).length() != 0L) {
                continue;
              }
            }
            new File(str3).delete();
            k = m;
            if (!new File(str3).exists()) {
              continue;
            }
            run_all_no_root(new String[] { "rm", str3 });
            k = m;
          }
        }
        catch (Exception paramString3)
        {
          paramString3.printStackTrace();
          continue;
        }
        catch (UnsatisfiedLinkError paramString3)
        {
          System.out.println("withoutFramework");
          continue;
          System.out.println("odex file create to tmp dir.");
          k = m;
        }
        continue;
        n = 0;
        m = 0;
        i = n;
        System.out.println("Error:Free space for odex not enougth.");
        i = n;
        if (!paramString3.exists()) {
          continue;
        }
        i = n;
        paramString3.delete();
        i = n;
        if (!paramString3.exists()) {
          continue;
        }
        i = n;
        run_all_no_root(new String[] { "rm", paramString3.getAbsolutePath() });
        i = n;
        new File(str2).delete();
        i = n;
        if (!new File(str2).exists()) {
          continue;
        }
        i = n;
        run_all_no_root(new String[] { "rm", str2 });
        j = m;
        i = n;
        if (!new File(getOdexForCreate(paramString1, paramString4)).exists()) {
          continue;
        }
        i = n;
        System.out.println("Error:dont delete corrupt odex.");
        j = m;
        continue;
      }
      i = n;
      paramString3 = new File(str3);
      i = n;
      System.out.println(str3);
      i = n;
      System.out.println(str1);
      i = n;
      if (paramString3.exists())
      {
        i = n;
        if (paramString3.length() == 0L)
        {
          i = n;
          paramString3.delete();
        }
      }
      m = k;
      i = n;
      if (paramString3.exists())
      {
        i = n;
        System.out.println("oat file found. try copy and permission apply.");
        i = n;
        new File(str2).delete();
        i = n;
        if (new File(str2).exists())
        {
          i = n;
          run_all_no_root(new String[] { "rm", str2 });
        }
        i = n;
        if (!dalvikvm_copyFile(listAppsFragment.toolfilesdir, paramString3.getAbsolutePath(), str1)) {
          continue;
        }
        i = n;
        System.out.println("Free space for odex enougth.");
        j = 1;
        i = j;
        if (!paramString1.startsWith("/system")) {
          continue;
        }
        i = j;
        run_all_no_root(new String[] { "chmod", "0644", str1 });
        i = j;
        run_all_no_root(new String[] { "chown", "0.0", str1 });
        i = j;
        run_all_no_root(new String[] { "chown", "0:0", str1 });
        m = k;
      }
      if (new File(str3).exists()) {
        new File(str3).delete();
      }
      paramString3 = new File(paramString2).listFiles();
      if ((paramString3 == null) || (paramString3.length <= 0)) {
        continue;
      }
      k = paramString3.length;
      i = 0;
      if (i >= k) {
        continue;
      }
      paramString3[i].delete();
      i += 1;
      continue;
      System.out.println("odex file create to tmp dir.");
      k = m;
    }
    label1816:
    return m;
  }
  
  public static void dexoptcopy()
  {
    File localFile = new File(listAppsFragment.toolfilesdir + "/" + "dexopt-wrapper");
    int i;
    if (Build.CPU_ABI.toLowerCase().trim().equals("x86")) {
      i = 2131099657;
    }
    for (;;)
    {
      if ((!localFile.exists()) || (localFile.length() != getRawLength(i))) {}
      try
      {
        getRawToFile(i, new File(listAppsFragment.toolfilesdir + "/dexopt-wrapper"));
        try
        {
          chmod(new File(listAppsFragment.toolfilesdir + "/" + "dexopt-wrapper"), 777);
          run_all("chmod 777 " + listAppsFragment.toolfilesdir + "/" + "dexopt-wrapper");
          run_all("chown 0.0 " + listAppsFragment.toolfilesdir + "/" + "dexopt-wrapper");
          run_all("chmod 0:0 " + listAppsFragment.toolfilesdir + "/" + "dexopt-wrapper");
          return;
          if (Build.CPU_ABI.toUpperCase().trim().equals("MIPS"))
          {
            i = 2131099656;
            continue;
          }
          i = 2131099655;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            System.out.println(localException1);
            localException1.printStackTrace();
          }
        }
        run_all("chmod 777 " + listAppsFragment.toolfilesdir + "/" + "dexopt-wrapper");
        run_all("chown 0.0 " + listAppsFragment.toolfilesdir + "/" + "dexopt-wrapper");
        run_all("chmod 0:0 " + listAppsFragment.toolfilesdir + "/" + "dexopt-wrapper");
        return;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public static boolean exists(String paramString)
  {
    if (new File(paramString).exists()) {
      return true;
    }
    if (!listAppsFragment.su) {
      return false;
    }
    if (!listAppsFragment.startUnderRoot.booleanValue())
    {
      String str = new Utils("").cmdRoot(new String[] { "ls " + paramString });
      System.out.println(str);
      if (str.equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public static void exit()
  {
    if ((!listAppsFragment.getConfig().getBoolean("OnBootService", false)) && (!listAppsFragment.patchOnBoot) && (!listAppsFragment.desktop_launch) && (!listAppsFragment.appDisabler) && (!listAppsFragment.binderWidget))
    {
      System.out.println("Enf: " + getSELinux());
      if (!getSELinux().equals("enforce")) {}
    }
    try
    {
      new Utils("").cmdRoot(new String[] { "setenforce 1" });
      System.out.println("LP - exit.");
      System.exit(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static void exitFromRootJava()
  {
    boolean bool = listAppsFragment.startUnderRoot.booleanValue();
    listAppsFragment.startUnderRoot = Boolean.valueOf(false);
    if (bool) {
      System.exit(0);
    }
  }
  
  public static void exitRoot()
  {
    if (!listAppsFragment.startUnderRoot.booleanValue()) {
      System.out.println("LuckyPatcher: exit root.");
    }
    try
    {
      if (listAppsFragment.suOutputStream != null) {
        listAppsFragment.suOutputStream.writeBytes("exit\n");
      }
      try
      {
        if (listAppsFragment.suProcess != null) {
          listAppsFragment.suProcess.destroy();
        }
        if (listAppsFragment.suOutputStream != null) {
          listAppsFragment.suOutputStream.close();
        }
        if (listAppsFragment.suInputStream != null) {
          listAppsFragment.suInputStream.close();
        }
        if (listAppsFragment.suErrorInputStream != null) {
          listAppsFragment.suErrorInputStream.close();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
      listAppsFragment.suProcess = null;
      listAppsFragment.suOutputStream = null;
      listAppsFragment.suInputStream = null;
      listAppsFragment.suErrorInputStream = null;
      listAppsFragment.semaphoreRoot.release();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
      }
    }
  }
  
  private static Mount findMountPointRecursive(String paramString)
  {
    Object localObject1;
    Object localObject2;
    try
    {
      localObject1 = getMounts();
      localObject2 = new File(paramString);
      if (localObject2 == null) {
        break label221;
      }
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Mount localMount = (Mount)((Iterator)localObject3).next();
        if (localMount.getMountPoint().equals(localObject2)) {
          return localMount;
        }
      }
      localObject2 = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Mount)((Iterator)localObject1).next();
        if (paramString.startsWith(((Mount)localObject3).getMountPoint().getAbsolutePath())) {
          ((ArrayList)localObject2).add(localObject3);
        }
      }
      paramString = null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    Object localObject3 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Mount)((Iterator)localObject3).next();
      localObject2 = paramString;
      if (paramString == null) {
        localObject2 = localObject1;
      }
      paramString = (String)localObject2;
      if (((Mount)localObject2).getMountPoint().getAbsolutePath().length() < ((Mount)localObject1).getMountPoint().getAbsolutePath().length()) {
        paramString = (String)localObject1;
      }
    }
    if (paramString != null) {
      System.out.println("recursive mount " + paramString.getMountPoint().getAbsolutePath());
    }
    return paramString;
    label221:
    return null;
  }
  
  /* Error */
  public static void fixCRCart(File paramFile, ArrayList<File> paramArrayList, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 290	java/util/ArrayList
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 294	java/util/ArrayList:size	()I
    //   8: invokespecial 1541	java/util/ArrayList:<init>	(I)V
    //   11: astore 16
    //   13: iconst_3
    //   14: anewarray 92	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 453
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: ldc_w 591
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: aload_0
    //   32: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: aastore
    //   36: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   39: aload_2
    //   40: ifnull +1168 -> 1208
    //   43: new 171	java/io/File
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: invokevirtual 175	java/io/File:exists	()Z
    //   54: ifeq +1154 -> 1208
    //   57: new 171	java/io/File
    //   60: dup
    //   61: aload_2
    //   62: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: invokevirtual 311	java/io/File:length	()J
    //   68: lstore 12
    //   70: lload 12
    //   72: lconst_0
    //   73: lcmp
    //   74: ifeq +1134 -> 1208
    //   77: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   80: aload_2
    //   81: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   84: iconst_3
    //   85: anewarray 92	java/lang/String
    //   88: dup
    //   89: iconst_0
    //   90: ldc_w 453
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: ldc_w 455
    //   99: aastore
    //   100: dup
    //   101: iconst_2
    //   102: aload_2
    //   103: aastore
    //   104: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   107: new 128	java/io/FileInputStream
    //   110: dup
    //   111: aload_2
    //   112: invokespecial 373	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   115: astore 17
    //   117: new 905	java/util/zip/ZipInputStream
    //   120: dup
    //   121: aload 17
    //   123: invokespecial 906	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   126: astore 18
    //   128: aload 18
    //   130: invokevirtual 910	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   133: astore 15
    //   135: aload 15
    //   137: ifnull +196 -> 333
    //   140: aload 15
    //   142: invokevirtual 913	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   145: astore 19
    //   147: aload 19
    //   149: ldc_w 1543
    //   152: invokevirtual 630	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   155: ifeq +144 -> 299
    //   158: aload 19
    //   160: ldc_w 1545
    //   163: invokevirtual 206	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   166: ifeq +133 -> 299
    //   169: iconst_0
    //   170: istore 5
    //   172: iload 5
    //   174: aload_1
    //   175: invokevirtual 294	java/util/ArrayList:size	()I
    //   178: if_icmpge +121 -> 299
    //   181: aload_1
    //   182: iload 5
    //   184: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   187: checkcast 171	java/io/File
    //   190: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   193: aload 19
    //   195: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   198: istore 14
    //   200: iload 14
    //   202: ifeq +122 -> 324
    //   205: aload 15
    //   207: invokevirtual 1548	java/util/zip/ZipEntry:getCrc	()J
    //   210: l2i
    //   211: istore 6
    //   213: iload 6
    //   215: istore 4
    //   217: iload 6
    //   219: iconst_m1
    //   220: if_icmpne +62 -> 282
    //   223: new 385	java/util/zip/CRC32
    //   226: dup
    //   227: invokespecial 386	java/util/zip/CRC32:<init>	()V
    //   230: astore 15
    //   232: aload 15
    //   234: invokevirtual 1155	java/util/zip/CRC32:reset	()V
    //   237: sipush 4096
    //   240: newarray <illegal type>
    //   242: astore 19
    //   244: aload 18
    //   246: aload 19
    //   248: invokevirtual 1169	java/util/zip/ZipInputStream:read	([B)I
    //   251: istore 4
    //   253: iload 4
    //   255: iconst_m1
    //   256: if_icmpeq +53 -> 309
    //   259: aload 15
    //   261: aload 19
    //   263: iconst_0
    //   264: iload 4
    //   266: invokevirtual 1171	java/util/zip/CRC32:update	([BII)V
    //   269: goto -25 -> 244
    //   272: astore 15
    //   274: aload 15
    //   276: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   279: iconst_0
    //   280: istore 4
    //   282: aload 16
    //   284: iload 5
    //   286: iload 4
    //   288: invokestatic 892	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   291: invokevirtual 1551	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   294: aload 18
    //   296: invokevirtual 921	java/util/zip/ZipInputStream:closeEntry	()V
    //   299: aload 18
    //   301: invokevirtual 910	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   304: astore 15
    //   306: goto -171 -> 135
    //   309: aload 15
    //   311: invokevirtual 393	java/util/zip/CRC32:getValue	()J
    //   314: lstore 12
    //   316: lload 12
    //   318: l2i
    //   319: istore 4
    //   321: goto -39 -> 282
    //   324: iload 5
    //   326: iconst_1
    //   327: iadd
    //   328: istore 5
    //   330: goto -158 -> 172
    //   333: aload 18
    //   335: invokevirtual 922	java/util/zip/ZipInputStream:close	()V
    //   338: aload 17
    //   340: invokevirtual 376	java/io/FileInputStream:close	()V
    //   343: new 483	java/io/RandomAccessFile
    //   346: dup
    //   347: aload_0
    //   348: ldc_w 485
    //   351: invokespecial 488	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   354: invokevirtual 492	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   357: astore 15
    //   359: aload 15
    //   361: getstatic 498	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   364: lconst_0
    //   365: aload 15
    //   367: invokevirtual 502	java/nio/channels/FileChannel:size	()J
    //   370: l2i
    //   371: i2l
    //   372: invokevirtual 506	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   375: astore 17
    //   377: aload 17
    //   379: sipush 4096
    //   382: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   385: pop
    //   386: iconst_m1
    //   387: istore 5
    //   389: aload_3
    //   390: invokevirtual 613	java/lang/String:getBytes	()[B
    //   393: astore 18
    //   395: new 208	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   402: aload_3
    //   403: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: ldc_w 1553
    //   409: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokevirtual 613	java/lang/String:getBytes	()[B
    //   418: astore_3
    //   419: aload_2
    //   420: invokevirtual 613	java/lang/String:getBytes	()[B
    //   423: astore 19
    //   425: aload 17
    //   427: invokevirtual 518	java/nio/MappedByteBuffer:hasRemaining	()Z
    //   430: ifeq +1161 -> 1591
    //   433: aload 17
    //   435: iload 5
    //   437: iconst_1
    //   438: iadd
    //   439: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   442: pop
    //   443: aload 17
    //   445: invokevirtual 1555	java/nio/MappedByteBuffer:position	()I
    //   448: istore 5
    //   450: aload 17
    //   452: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   455: istore 6
    //   457: iload 6
    //   459: istore 7
    //   461: iload 5
    //   463: istore 4
    //   465: iload 6
    //   467: aload_3
    //   468: iconst_0
    //   469: baload
    //   470: if_icmpne +780 -> 1250
    //   473: iconst_1
    //   474: istore 8
    //   476: aload 17
    //   478: iload 5
    //   480: iconst_1
    //   481: iadd
    //   482: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   485: pop
    //   486: aload 17
    //   488: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   491: istore 9
    //   493: iload 6
    //   495: istore 7
    //   497: iload 5
    //   499: istore 4
    //   501: iload 9
    //   503: aload_3
    //   504: iload 8
    //   506: baload
    //   507: if_icmpne +743 -> 1250
    //   510: iload 8
    //   512: iconst_1
    //   513: iadd
    //   514: istore 8
    //   516: iload 8
    //   518: aload_3
    //   519: arraylength
    //   520: if_icmpne +720 -> 1240
    //   523: iconst_0
    //   524: istore 8
    //   526: ldc_w 1545
    //   529: invokevirtual 613	java/lang/String:getBytes	()[B
    //   532: astore 20
    //   534: ldc_w 1543
    //   537: astore_0
    //   538: iload 6
    //   540: istore 7
    //   542: iload 5
    //   544: istore 4
    //   546: iload 8
    //   548: bipush 7
    //   550: if_icmpge +700 -> 1250
    //   553: iload 8
    //   555: iconst_1
    //   556: iadd
    //   557: istore 11
    //   559: aload 17
    //   561: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   564: istore 4
    //   566: new 208	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   573: aload_0
    //   574: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: iload 4
    //   579: i2c
    //   580: invokevirtual 865	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   583: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: astore_2
    //   587: aload_2
    //   588: astore_0
    //   589: iload 11
    //   591: istore 8
    //   593: iload 4
    //   595: aload 20
    //   597: iconst_0
    //   598: baload
    //   599: if_icmpne -61 -> 538
    //   602: iconst_1
    //   603: istore 10
    //   605: aload 17
    //   607: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   610: istore 9
    //   612: iload 5
    //   614: istore 7
    //   616: iload 6
    //   618: istore 4
    //   620: aload_2
    //   621: astore_0
    //   622: iload 4
    //   624: istore 6
    //   626: iload 7
    //   628: istore 5
    //   630: iload 11
    //   632: istore 8
    //   634: iload 10
    //   636: aload 20
    //   638: arraylength
    //   639: if_icmpge -101 -> 538
    //   642: aload_2
    //   643: astore_0
    //   644: iload 4
    //   646: istore 6
    //   648: iload 7
    //   650: istore 5
    //   652: iload 11
    //   654: istore 8
    //   656: iload 9
    //   658: aload 20
    //   660: iload 10
    //   662: baload
    //   663: if_icmpne -125 -> 538
    //   666: new 208	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   673: aload_2
    //   674: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: iload 9
    //   679: i2c
    //   680: invokevirtual 865	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   683: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: astore_2
    //   687: iload 10
    //   689: iconst_1
    //   690: iadd
    //   691: istore 10
    //   693: iload 4
    //   695: istore 6
    //   697: iload 7
    //   699: istore 5
    //   701: iload 10
    //   703: aload 20
    //   705: arraylength
    //   706: if_icmpne +206 -> 912
    //   709: iconst_0
    //   710: istore 8
    //   712: iload 4
    //   714: istore 6
    //   716: iload 7
    //   718: istore 5
    //   720: iload 8
    //   722: aload_1
    //   723: invokevirtual 294	java/util/ArrayList:size	()I
    //   726: if_icmpge +186 -> 912
    //   729: aload_1
    //   730: iload 8
    //   732: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   735: checkcast 171	java/io/File
    //   738: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   741: aload_2
    //   742: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   745: ifeq +486 -> 1231
    //   748: aload 16
    //   750: iload 8
    //   752: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   755: checkcast 867	java/lang/Integer
    //   758: invokevirtual 901	java/lang/Integer:intValue	()I
    //   761: ifeq +115 -> 876
    //   764: aload 17
    //   766: aload 16
    //   768: iload 8
    //   770: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   773: checkcast 867	java/lang/Integer
    //   776: invokevirtual 1124	java/lang/Integer:byteValue	()B
    //   779: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   782: pop
    //   783: aload 17
    //   785: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   788: pop
    //   789: aload 17
    //   791: aload 16
    //   793: iload 8
    //   795: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   798: checkcast 867	java/lang/Integer
    //   801: invokevirtual 901	java/lang/Integer:intValue	()I
    //   804: bipush 8
    //   806: ishr
    //   807: i2b
    //   808: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   811: pop
    //   812: aload 17
    //   814: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   817: pop
    //   818: aload 17
    //   820: aload 16
    //   822: iload 8
    //   824: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   827: checkcast 867	java/lang/Integer
    //   830: invokevirtual 901	java/lang/Integer:intValue	()I
    //   833: bipush 16
    //   835: ishr
    //   836: i2b
    //   837: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   840: pop
    //   841: aload 17
    //   843: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   846: pop
    //   847: aload 17
    //   849: aload 16
    //   851: iload 8
    //   853: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   856: checkcast 867	java/lang/Integer
    //   859: invokevirtual 901	java/lang/Integer:intValue	()I
    //   862: bipush 24
    //   864: ishr
    //   865: i2b
    //   866: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   869: pop
    //   870: aload 17
    //   872: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   875: pop
    //   876: aload 17
    //   878: iload 7
    //   880: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   883: pop
    //   884: aload 17
    //   886: aload 19
    //   888: invokevirtual 572	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   891: pop
    //   892: aload 17
    //   894: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   897: pop
    //   898: aload 17
    //   900: invokevirtual 1555	java/nio/MappedByteBuffer:position	()I
    //   903: istore 5
    //   905: aload 17
    //   907: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   910: istore 6
    //   912: aload 17
    //   914: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   917: istore 9
    //   919: iload 6
    //   921: istore 4
    //   923: iload 5
    //   925: istore 7
    //   927: goto -307 -> 620
    //   930: astore 15
    //   932: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   935: ldc_w 1557
    //   938: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   941: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   944: ldc_w 1558
    //   947: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   950: aload_2
    //   951: invokestatic 324	kellinwood/zipio/ZipInput:read	(Ljava/lang/String;)Lkellinwood/zipio/ZipInput;
    //   954: astore 15
    //   956: aload 15
    //   958: invokevirtual 334	kellinwood/zipio/ZipInput:getEntries	()Ljava/util/Map;
    //   961: invokeinterface 340 1 0
    //   966: invokeinterface 343 1 0
    //   971: astore 17
    //   973: aload 17
    //   975: invokeinterface 303 1 0
    //   980: ifeq -637 -> 343
    //   983: aload 17
    //   985: invokeinterface 307 1 0
    //   990: checkcast 345	kellinwood/zipio/ZioEntry
    //   993: astore 19
    //   995: aload 19
    //   997: invokevirtual 352	kellinwood/zipio/ZioEntry:getName	()Ljava/lang/String;
    //   1000: ldc_w 1543
    //   1003: invokevirtual 630	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1006: ifeq -33 -> 973
    //   1009: aload 19
    //   1011: invokevirtual 352	kellinwood/zipio/ZioEntry:getName	()Ljava/lang/String;
    //   1014: ldc_w 1545
    //   1017: invokevirtual 206	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1020: ifeq -47 -> 973
    //   1023: iconst_0
    //   1024: istore 5
    //   1026: iload 5
    //   1028: aload_1
    //   1029: invokevirtual 294	java/util/ArrayList:size	()I
    //   1032: if_icmpge -59 -> 973
    //   1035: aload_1
    //   1036: iload 5
    //   1038: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1041: checkcast 171	java/io/File
    //   1044: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   1047: aload 19
    //   1049: invokevirtual 352	kellinwood/zipio/ZioEntry:getName	()Ljava/lang/String;
    //   1052: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1055: istore 14
    //   1057: iload 14
    //   1059: ifeq +163 -> 1222
    //   1062: aload 19
    //   1064: invokevirtual 1561	kellinwood/zipio/ZioEntry:getCrc32	()I
    //   1067: istore 6
    //   1069: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   1072: new 208	java/lang/StringBuilder
    //   1075: dup
    //   1076: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1079: ldc_w 1563
    //   1082: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: iload 6
    //   1087: invokevirtual 566	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1096: iload 6
    //   1098: istore 4
    //   1100: iload 6
    //   1102: iconst_m1
    //   1103: if_icmpne +70 -> 1173
    //   1106: new 385	java/util/zip/CRC32
    //   1109: dup
    //   1110: invokespecial 386	java/util/zip/CRC32:<init>	()V
    //   1113: astore 18
    //   1115: aload 18
    //   1117: invokevirtual 1155	java/util/zip/CRC32:reset	()V
    //   1120: aload 19
    //   1122: invokevirtual 412	kellinwood/zipio/ZioEntry:getData	()[B
    //   1125: astore 19
    //   1127: aload 18
    //   1129: aload 19
    //   1131: iconst_0
    //   1132: aload 19
    //   1134: arraylength
    //   1135: invokevirtual 1171	java/util/zip/CRC32:update	([BII)V
    //   1138: aload 18
    //   1140: invokevirtual 393	java/util/zip/CRC32:getValue	()J
    //   1143: l2i
    //   1144: istore 4
    //   1146: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   1149: new 208	java/lang/StringBuilder
    //   1152: dup
    //   1153: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1156: ldc_w 1563
    //   1159: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: iload 4
    //   1164: invokevirtual 566	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1167: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1170: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1173: aload 16
    //   1175: iload 5
    //   1177: iload 4
    //   1179: invokestatic 892	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1182: invokevirtual 1551	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   1185: aload 15
    //   1187: invokevirtual 1564	kellinwood/zipio/ZipInput:close	()V
    //   1190: goto -217 -> 973
    //   1193: astore 15
    //   1195: aload 15
    //   1197: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1200: goto -857 -> 343
    //   1203: astore_0
    //   1204: aload_0
    //   1205: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1208: return
    //   1209: astore 18
    //   1211: aload 18
    //   1213: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1216: iconst_0
    //   1217: istore 4
    //   1219: goto -46 -> 1173
    //   1222: iload 5
    //   1224: iconst_1
    //   1225: iadd
    //   1226: istore 5
    //   1228: goto -202 -> 1026
    //   1231: iload 8
    //   1233: iconst_1
    //   1234: iadd
    //   1235: istore 8
    //   1237: goto -525 -> 712
    //   1240: aload 17
    //   1242: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   1245: istore 9
    //   1247: goto -754 -> 493
    //   1250: iload 4
    //   1252: istore 5
    //   1254: iload 7
    //   1256: aload 18
    //   1258: iconst_0
    //   1259: baload
    //   1260: if_icmpne -835 -> 425
    //   1263: iconst_1
    //   1264: istore 6
    //   1266: aload 17
    //   1268: iload 4
    //   1270: iconst_1
    //   1271: iadd
    //   1272: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1275: pop
    //   1276: aload 17
    //   1278: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   1281: istore 7
    //   1283: iload 4
    //   1285: istore 5
    //   1287: iload 7
    //   1289: aload 18
    //   1291: iload 6
    //   1293: baload
    //   1294: if_icmpne -869 -> 425
    //   1297: iload 6
    //   1299: iconst_1
    //   1300: iadd
    //   1301: istore 6
    //   1303: iload 6
    //   1305: aload 18
    //   1307: arraylength
    //   1308: if_icmpne +295 -> 1603
    //   1311: sipush 255
    //   1314: istore 6
    //   1316: iconst_0
    //   1317: istore 5
    //   1319: iload 5
    //   1321: aload_1
    //   1322: invokevirtual 294	java/util/ArrayList:size	()I
    //   1325: if_icmpge +31 -> 1356
    //   1328: aload_1
    //   1329: iload 5
    //   1331: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1334: checkcast 171	java/io/File
    //   1337: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   1340: ldc_w 918
    //   1343: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1346: ifeq +276 -> 1622
    //   1349: iload 5
    //   1351: istore 6
    //   1353: goto +269 -> 1622
    //   1356: iload 4
    //   1358: istore 5
    //   1360: iload 6
    //   1362: sipush 255
    //   1365: if_icmpeq -940 -> 425
    //   1368: iload 4
    //   1370: istore 5
    //   1372: aload 17
    //   1374: aload 17
    //   1376: invokevirtual 1555	java/nio/MappedByteBuffer:position	()I
    //   1379: invokevirtual 602	java/nio/MappedByteBuffer:get	(I)B
    //   1382: bipush 32
    //   1384: if_icmpeq -959 -> 425
    //   1387: iload 4
    //   1389: istore 5
    //   1391: aload 17
    //   1393: aload 17
    //   1395: invokevirtual 1555	java/nio/MappedByteBuffer:position	()I
    //   1398: iconst_1
    //   1399: iadd
    //   1400: invokevirtual 602	java/nio/MappedByteBuffer:get	(I)B
    //   1403: bipush 45
    //   1405: if_icmpeq -980 -> 425
    //   1408: iload 4
    //   1410: istore 5
    //   1412: aload 17
    //   1414: aload 17
    //   1416: invokevirtual 1555	java/nio/MappedByteBuffer:position	()I
    //   1419: iconst_2
    //   1420: iadd
    //   1421: invokevirtual 602	java/nio/MappedByteBuffer:get	(I)B
    //   1424: bipush 45
    //   1426: if_icmpeq -1001 -> 425
    //   1429: aload 16
    //   1431: iload 6
    //   1433: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1436: checkcast 867	java/lang/Integer
    //   1439: invokevirtual 901	java/lang/Integer:intValue	()I
    //   1442: ifeq +115 -> 1557
    //   1445: aload 17
    //   1447: aload 16
    //   1449: iload 6
    //   1451: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1454: checkcast 867	java/lang/Integer
    //   1457: invokevirtual 1124	java/lang/Integer:byteValue	()B
    //   1460: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1463: pop
    //   1464: aload 17
    //   1466: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1469: pop
    //   1470: aload 17
    //   1472: aload 16
    //   1474: iload 6
    //   1476: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1479: checkcast 867	java/lang/Integer
    //   1482: invokevirtual 901	java/lang/Integer:intValue	()I
    //   1485: bipush 8
    //   1487: ishr
    //   1488: i2b
    //   1489: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1492: pop
    //   1493: aload 17
    //   1495: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1498: pop
    //   1499: aload 17
    //   1501: aload 16
    //   1503: iload 6
    //   1505: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1508: checkcast 867	java/lang/Integer
    //   1511: invokevirtual 901	java/lang/Integer:intValue	()I
    //   1514: bipush 16
    //   1516: ishr
    //   1517: i2b
    //   1518: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1521: pop
    //   1522: aload 17
    //   1524: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1527: pop
    //   1528: aload 17
    //   1530: aload 16
    //   1532: iload 6
    //   1534: invokevirtual 1137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1537: checkcast 867	java/lang/Integer
    //   1540: invokevirtual 901	java/lang/Integer:intValue	()I
    //   1543: bipush 24
    //   1545: ishr
    //   1546: i2b
    //   1547: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1550: pop
    //   1551: aload 17
    //   1553: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1556: pop
    //   1557: aload 17
    //   1559: iload 4
    //   1561: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1564: pop
    //   1565: aload 17
    //   1567: aload 19
    //   1569: invokevirtual 572	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   1572: pop
    //   1573: aload 17
    //   1575: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1578: pop
    //   1579: iload 4
    //   1581: istore 5
    //   1583: goto -1158 -> 425
    //   1586: astore_0
    //   1587: aload_0
    //   1588: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1591: aload 15
    //   1593: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   1596: return
    //   1597: astore_0
    //   1598: aload_0
    //   1599: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1602: return
    //   1603: aload 17
    //   1605: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   1608: istore 7
    //   1610: goto -327 -> 1283
    //   1613: astore_0
    //   1614: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   1617: aload_0
    //   1618: invokevirtual 405	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   1621: return
    //   1622: iload 5
    //   1624: iconst_1
    //   1625: iadd
    //   1626: istore 5
    //   1628: goto -309 -> 1319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1631	0	paramFile	File
    //   0	1631	1	paramArrayList	ArrayList<File>
    //   0	1631	2	paramString1	String
    //   0	1631	3	paramString2	String
    //   215	1365	4	i	int
    //   170	1457	5	j	int
    //   211	1322	6	k	int
    //   459	1150	7	m	int
    //   474	762	8	n	int
    //   491	755	9	i1	int
    //   603	104	10	i2	int
    //   557	96	11	i3	int
    //   68	249	12	l	long
    //   198	860	14	bool	boolean
    //   133	127	15	localObject1	Object
    //   272	3	15	localException1	Exception
    //   304	62	15	localObject2	Object
    //   930	1	15	localException2	Exception
    //   954	232	15	localZipInput	ZipInput
    //   1193	399	15	localException3	Exception
    //   11	1520	16	localArrayList	ArrayList
    //   115	1489	17	localObject3	Object
    //   126	1013	18	localObject4	Object
    //   1209	97	18	localException4	Exception
    //   145	1423	19	localObject5	Object
    //   532	172	20	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   205	213	272	java/lang/Exception
    //   223	244	272	java/lang/Exception
    //   244	253	272	java/lang/Exception
    //   259	269	272	java/lang/Exception
    //   309	316	272	java/lang/Exception
    //   107	135	930	java/lang/Exception
    //   140	169	930	java/lang/Exception
    //   172	200	930	java/lang/Exception
    //   274	279	930	java/lang/Exception
    //   282	299	930	java/lang/Exception
    //   299	306	930	java/lang/Exception
    //   333	343	930	java/lang/Exception
    //   941	973	1193	java/lang/Exception
    //   973	1023	1193	java/lang/Exception
    //   1026	1057	1193	java/lang/Exception
    //   1173	1190	1193	java/lang/Exception
    //   1211	1216	1193	java/lang/Exception
    //   77	107	1203	java/lang/Exception
    //   932	941	1203	java/lang/Exception
    //   1195	1200	1203	java/lang/Exception
    //   1598	1602	1203	java/lang/Exception
    //   1062	1096	1209	java/lang/Exception
    //   1106	1173	1209	java/lang/Exception
    //   425	457	1586	java/lang/Exception
    //   476	493	1586	java/lang/Exception
    //   516	523	1586	java/lang/Exception
    //   526	534	1586	java/lang/Exception
    //   559	587	1586	java/lang/Exception
    //   605	612	1586	java/lang/Exception
    //   634	642	1586	java/lang/Exception
    //   666	687	1586	java/lang/Exception
    //   701	709	1586	java/lang/Exception
    //   720	876	1586	java/lang/Exception
    //   876	912	1586	java/lang/Exception
    //   912	919	1586	java/lang/Exception
    //   1240	1247	1586	java/lang/Exception
    //   1266	1283	1586	java/lang/Exception
    //   1303	1311	1586	java/lang/Exception
    //   1319	1328	1586	java/lang/Exception
    //   1328	1349	1586	java/lang/Exception
    //   1372	1387	1586	java/lang/Exception
    //   1391	1408	1586	java/lang/Exception
    //   1412	1557	1586	java/lang/Exception
    //   1557	1579	1586	java/lang/Exception
    //   1603	1610	1586	java/lang/Exception
    //   343	386	1597	java/lang/Exception
    //   389	425	1597	java/lang/Exception
    //   1587	1591	1597	java/lang/Exception
    //   1591	1596	1597	java/lang/Exception
    //   43	70	1613	java/lang/Exception
    //   1204	1208	1613	java/lang/Exception
  }
  
  public static void fixadler(File paramFile)
  {
    try
    {
      cmdParam(new String[] { "chmod", "777", paramFile.getAbsolutePath() });
      calcSignature(paramFile);
      calcChecksum(paramFile);
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  /* Error */
  public static void fixadlerOdex(File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 128	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 9
    //   10: bipush 40
    //   12: newarray <illegal type>
    //   14: astore 10
    //   16: aload 9
    //   18: aload 10
    //   20: invokevirtual 146	java/io/FileInputStream:read	([B)I
    //   23: pop
    //   24: aload 9
    //   26: invokevirtual 376	java/io/FileInputStream:close	()V
    //   29: iconst_0
    //   30: istore_2
    //   31: iload_2
    //   32: iconst_4
    //   33: if_icmpge +108 -> 141
    //   36: aload 10
    //   38: iload_2
    //   39: baload
    //   40: bipush 8
    //   42: newarray <illegal type>
    //   44: dup
    //   45: iconst_0
    //   46: ldc_w 840
    //   49: bastore
    //   50: dup
    //   51: iconst_1
    //   52: ldc_w 841
    //   55: bastore
    //   56: dup
    //   57: iconst_2
    //   58: ldc_w 843
    //   61: bastore
    //   62: dup
    //   63: iconst_3
    //   64: ldc_w 1571
    //   67: bastore
    //   68: dup
    //   69: iconst_4
    //   70: ldc_w 1572
    //   73: bastore
    //   74: dup
    //   75: iconst_5
    //   76: ldc_w 1573
    //   79: bastore
    //   80: dup
    //   81: bipush 6
    //   83: ldc_w 1574
    //   86: bastore
    //   87: dup
    //   88: bipush 7
    //   90: ldc_w 1575
    //   93: bastore
    //   94: iload_2
    //   95: baload
    //   96: if_icmpeq +38 -> 134
    //   99: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   102: new 208	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 845
    //   112: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: new 92	java/lang/String
    //   118: dup
    //   119: aload 10
    //   121: invokespecial 610	java/lang/String:<init>	([B)V
    //   124: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   133: return
    //   134: iload_2
    //   135: iconst_1
    //   136: iadd
    //   137: istore_2
    //   138: goto -107 -> 31
    //   141: aload 10
    //   143: invokestatic 1580	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   146: astore 9
    //   148: aload 9
    //   150: getstatic 1586	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   153: invokevirtual 1590	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   156: pop
    //   157: aload 9
    //   159: bipush 8
    //   161: invokevirtual 1591	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   164: pop
    //   165: aload 9
    //   167: invokevirtual 1594	java/nio/ByteBuffer:getInt	()I
    //   170: istore_2
    //   171: aload 9
    //   173: bipush 12
    //   175: invokevirtual 1591	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   178: pop
    //   179: aload 9
    //   181: invokevirtual 1594	java/nio/ByteBuffer:getInt	()I
    //   184: istore_3
    //   185: aload 9
    //   187: bipush 16
    //   189: invokevirtual 1591	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   192: pop
    //   193: aload 9
    //   195: invokevirtual 1594	java/nio/ByteBuffer:getInt	()I
    //   198: istore 5
    //   200: aload 9
    //   202: bipush 20
    //   204: invokevirtual 1591	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   207: pop
    //   208: aload 9
    //   210: invokevirtual 1594	java/nio/ByteBuffer:getInt	()I
    //   213: pop
    //   214: aload 9
    //   216: bipush 24
    //   218: invokevirtual 1591	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   221: pop
    //   222: aload 9
    //   224: invokevirtual 1594	java/nio/ByteBuffer:getInt	()I
    //   227: pop
    //   228: aload 9
    //   230: bipush 28
    //   232: invokevirtual 1591	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   235: pop
    //   236: aload 9
    //   238: invokevirtual 1594	java/nio/ByteBuffer:getInt	()I
    //   241: pop
    //   242: aload 9
    //   244: bipush 32
    //   246: invokevirtual 1591	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   249: pop
    //   250: aload 9
    //   252: invokevirtual 1594	java/nio/ByteBuffer:getInt	()I
    //   255: pop
    //   256: iload_2
    //   257: iload_3
    //   258: aload_0
    //   259: invokestatic 1596	com/chelpus/Utils:calcChecksumOdexFly	(IILjava/io/File;)V
    //   262: getstatic 927	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   265: invokevirtual 932	java/lang/Boolean:booleanValue	()Z
    //   268: ifeq +990 -> 1258
    //   271: iconst_3
    //   272: anewarray 92	java/lang/String
    //   275: dup
    //   276: iconst_0
    //   277: ldc_w 453
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: ldc_w 455
    //   286: aastore
    //   287: dup
    //   288: iconst_2
    //   289: aload_1
    //   290: aastore
    //   291: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   294: aload_1
    //   295: ifnull -162 -> 133
    //   298: new 171	java/io/File
    //   301: dup
    //   302: aload_1
    //   303: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   306: invokevirtual 175	java/io/File:exists	()Z
    //   309: ifeq -176 -> 133
    //   312: new 171	java/io/File
    //   315: dup
    //   316: aload_1
    //   317: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   320: invokevirtual 311	java/io/File:length	()J
    //   323: lstore 6
    //   325: lload 6
    //   327: lconst_0
    //   328: lcmp
    //   329: ifeq -196 -> 133
    //   332: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   335: aload_1
    //   336: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   339: new 128	java/io/FileInputStream
    //   342: dup
    //   343: aload_1
    //   344: invokespecial 373	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   347: astore 10
    //   349: new 905	java/util/zip/ZipInputStream
    //   352: dup
    //   353: aload 10
    //   355: invokespecial 906	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   358: astore 11
    //   360: aload 11
    //   362: invokevirtual 910	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   365: astore 9
    //   367: aload 9
    //   369: ifnull +369 -> 738
    //   372: aload 9
    //   374: invokevirtual 913	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   377: ldc_w 918
    //   380: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   383: istore 8
    //   385: iload 8
    //   387: ifeq +943 -> 1330
    //   390: aload 9
    //   392: invokevirtual 1157	java/util/zip/ZipEntry:getTime	()J
    //   395: invokestatic 1600	com/chelpus/Utils:javaToDosTime	(J)J
    //   398: lstore 6
    //   400: lload 6
    //   402: l2i
    //   403: istore_3
    //   404: aload 9
    //   406: invokevirtual 1548	java/util/zip/ZipEntry:getCrc	()J
    //   409: l2i
    //   410: istore 4
    //   412: iload 4
    //   414: istore_2
    //   415: iload 4
    //   417: iconst_m1
    //   418: if_icmpne +58 -> 476
    //   421: new 385	java/util/zip/CRC32
    //   424: dup
    //   425: invokespecial 386	java/util/zip/CRC32:<init>	()V
    //   428: astore 9
    //   430: aload 9
    //   432: invokevirtual 1155	java/util/zip/CRC32:reset	()V
    //   435: sipush 4096
    //   438: newarray <illegal type>
    //   440: astore 12
    //   442: aload 11
    //   444: aload 12
    //   446: invokevirtual 1169	java/util/zip/ZipInputStream:read	([B)I
    //   449: istore_2
    //   450: iload_2
    //   451: iconst_m1
    //   452: if_icmpeq +844 -> 1296
    //   455: aload 9
    //   457: aload 12
    //   459: iconst_0
    //   460: iload_2
    //   461: invokevirtual 1171	java/util/zip/CRC32:update	([BII)V
    //   464: goto -22 -> 442
    //   467: astore 9
    //   469: aload 9
    //   471: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   474: iconst_0
    //   475: istore_2
    //   476: new 483	java/io/RandomAccessFile
    //   479: dup
    //   480: aload_0
    //   481: ldc_w 485
    //   484: invokespecial 488	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   487: invokevirtual 492	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   490: astore 9
    //   492: aload 9
    //   494: getstatic 498	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   497: lconst_0
    //   498: aload 9
    //   500: invokevirtual 502	java/nio/channels/FileChannel:size	()J
    //   503: l2i
    //   504: i2l
    //   505: invokevirtual 506	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   508: astore 12
    //   510: iload_3
    //   511: ifeq +106 -> 617
    //   514: aload 12
    //   516: iload 5
    //   518: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   521: pop
    //   522: aload 12
    //   524: iload_3
    //   525: i2b
    //   526: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   529: pop
    //   530: aload 12
    //   532: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   535: pop
    //   536: aload 12
    //   538: iload 5
    //   540: iconst_1
    //   541: iadd
    //   542: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   545: pop
    //   546: aload 12
    //   548: iload_3
    //   549: bipush 8
    //   551: ishr
    //   552: i2b
    //   553: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   556: pop
    //   557: aload 12
    //   559: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   562: pop
    //   563: aload 12
    //   565: iload 5
    //   567: iconst_2
    //   568: iadd
    //   569: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   572: pop
    //   573: aload 12
    //   575: iload_3
    //   576: bipush 16
    //   578: ishr
    //   579: i2b
    //   580: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   583: pop
    //   584: aload 12
    //   586: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   589: pop
    //   590: aload 12
    //   592: iload 5
    //   594: iconst_3
    //   595: iadd
    //   596: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   599: pop
    //   600: aload 12
    //   602: iload_3
    //   603: bipush 24
    //   605: ishr
    //   606: i2b
    //   607: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   610: pop
    //   611: aload 12
    //   613: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   616: pop
    //   617: iload_2
    //   618: ifeq +110 -> 728
    //   621: aload 12
    //   623: iload 5
    //   625: iconst_4
    //   626: iadd
    //   627: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   630: pop
    //   631: aload 12
    //   633: iload_2
    //   634: i2b
    //   635: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   638: pop
    //   639: aload 12
    //   641: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   644: pop
    //   645: aload 12
    //   647: iload 5
    //   649: iconst_5
    //   650: iadd
    //   651: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   654: pop
    //   655: aload 12
    //   657: iload_2
    //   658: bipush 8
    //   660: ishr
    //   661: i2b
    //   662: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   665: pop
    //   666: aload 12
    //   668: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   671: pop
    //   672: aload 12
    //   674: iload 5
    //   676: bipush 6
    //   678: iadd
    //   679: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   682: pop
    //   683: aload 12
    //   685: iload_2
    //   686: bipush 16
    //   688: ishr
    //   689: i2b
    //   690: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   693: pop
    //   694: aload 12
    //   696: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   699: pop
    //   700: aload 12
    //   702: iload 5
    //   704: bipush 7
    //   706: iadd
    //   707: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   710: pop
    //   711: aload 12
    //   713: iload_2
    //   714: bipush 24
    //   716: ishr
    //   717: i2b
    //   718: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   721: pop
    //   722: aload 12
    //   724: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   727: pop
    //   728: aload 9
    //   730: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   733: aload 11
    //   735: invokevirtual 921	java/util/zip/ZipInputStream:closeEntry	()V
    //   738: aload 11
    //   740: invokevirtual 922	java/util/zip/ZipInputStream:close	()V
    //   743: aload 10
    //   745: invokevirtual 376	java/io/FileInputStream:close	()V
    //   748: return
    //   749: astore 9
    //   751: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   754: ldc_w 1602
    //   757: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   760: aload 9
    //   762: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   765: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   768: ldc_w 1558
    //   771: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   774: aload_1
    //   775: invokestatic 324	kellinwood/zipio/ZipInput:read	(Ljava/lang/String;)Lkellinwood/zipio/ZipInput;
    //   778: astore_1
    //   779: aload_1
    //   780: invokevirtual 334	kellinwood/zipio/ZipInput:getEntries	()Ljava/util/Map;
    //   783: invokeinterface 340 1 0
    //   788: invokeinterface 343 1 0
    //   793: astore 11
    //   795: aload 11
    //   797: invokeinterface 303 1 0
    //   802: ifeq -669 -> 133
    //   805: aload 11
    //   807: invokeinterface 307 1 0
    //   812: checkcast 345	kellinwood/zipio/ZioEntry
    //   815: astore 10
    //   817: aload 10
    //   819: invokevirtual 352	kellinwood/zipio/ZioEntry:getName	()Ljava/lang/String;
    //   822: ldc_w 918
    //   825: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   828: istore 8
    //   830: iload 8
    //   832: ifeq -37 -> 795
    //   835: aload 10
    //   837: invokevirtual 399	kellinwood/zipio/ZioEntry:getTime	()J
    //   840: invokestatic 1600	com/chelpus/Utils:javaToDosTime	(J)J
    //   843: l2i
    //   844: istore_3
    //   845: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   848: new 208	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   855: ldc_w 1604
    //   858: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: iload_3
    //   862: invokevirtual 566	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   865: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   871: aload 10
    //   873: invokevirtual 1561	kellinwood/zipio/ZioEntry:getCrc32	()I
    //   876: istore 4
    //   878: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   881: new 208	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   888: ldc_w 1563
    //   891: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: iload 4
    //   896: invokevirtual 566	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   899: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   905: iload 4
    //   907: istore_2
    //   908: iload 4
    //   910: iconst_m1
    //   911: if_icmpne +68 -> 979
    //   914: new 385	java/util/zip/CRC32
    //   917: dup
    //   918: invokespecial 386	java/util/zip/CRC32:<init>	()V
    //   921: astore 11
    //   923: aload 11
    //   925: invokevirtual 1155	java/util/zip/CRC32:reset	()V
    //   928: aload 10
    //   930: invokevirtual 412	kellinwood/zipio/ZioEntry:getData	()[B
    //   933: astore 10
    //   935: aload 11
    //   937: aload 10
    //   939: iconst_0
    //   940: aload 10
    //   942: arraylength
    //   943: invokevirtual 1171	java/util/zip/CRC32:update	([BII)V
    //   946: aload 11
    //   948: invokevirtual 393	java/util/zip/CRC32:getValue	()J
    //   951: l2i
    //   952: istore_2
    //   953: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   956: new 208	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   963: ldc_w 1563
    //   966: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: iload_2
    //   970: invokevirtual 566	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   973: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   979: new 483	java/io/RandomAccessFile
    //   982: dup
    //   983: aload_0
    //   984: ldc_w 485
    //   987: invokespecial 488	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   990: invokevirtual 492	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   993: astore_0
    //   994: aload_0
    //   995: getstatic 498	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   998: lconst_0
    //   999: aload_0
    //   1000: invokevirtual 502	java/nio/channels/FileChannel:size	()J
    //   1003: l2i
    //   1004: i2l
    //   1005: invokevirtual 506	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   1008: astore 10
    //   1010: iload_3
    //   1011: ifeq +106 -> 1117
    //   1014: aload 10
    //   1016: iload 5
    //   1018: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1021: pop
    //   1022: aload 10
    //   1024: iload_3
    //   1025: i2b
    //   1026: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1029: pop
    //   1030: aload 10
    //   1032: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1035: pop
    //   1036: aload 10
    //   1038: iload 5
    //   1040: iconst_1
    //   1041: iadd
    //   1042: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1045: pop
    //   1046: aload 10
    //   1048: iload_3
    //   1049: bipush 8
    //   1051: ishr
    //   1052: i2b
    //   1053: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1056: pop
    //   1057: aload 10
    //   1059: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1062: pop
    //   1063: aload 10
    //   1065: iload 5
    //   1067: iconst_2
    //   1068: iadd
    //   1069: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1072: pop
    //   1073: aload 10
    //   1075: iload_3
    //   1076: bipush 16
    //   1078: ishr
    //   1079: i2b
    //   1080: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1083: pop
    //   1084: aload 10
    //   1086: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1089: pop
    //   1090: aload 10
    //   1092: iload 5
    //   1094: iconst_3
    //   1095: iadd
    //   1096: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1099: pop
    //   1100: aload 10
    //   1102: iload_3
    //   1103: bipush 24
    //   1105: ishr
    //   1106: i2b
    //   1107: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1110: pop
    //   1111: aload 10
    //   1113: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1116: pop
    //   1117: iload_2
    //   1118: ifeq +110 -> 1228
    //   1121: aload 10
    //   1123: iload 5
    //   1125: iconst_4
    //   1126: iadd
    //   1127: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1130: pop
    //   1131: aload 10
    //   1133: iload_2
    //   1134: i2b
    //   1135: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1138: pop
    //   1139: aload 10
    //   1141: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1144: pop
    //   1145: aload 10
    //   1147: iload 5
    //   1149: iconst_5
    //   1150: iadd
    //   1151: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1154: pop
    //   1155: aload 10
    //   1157: iload_2
    //   1158: bipush 8
    //   1160: ishr
    //   1161: i2b
    //   1162: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1165: pop
    //   1166: aload 10
    //   1168: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1171: pop
    //   1172: aload 10
    //   1174: iload 5
    //   1176: bipush 6
    //   1178: iadd
    //   1179: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1182: pop
    //   1183: aload 10
    //   1185: iload_2
    //   1186: bipush 16
    //   1188: ishr
    //   1189: i2b
    //   1190: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1193: pop
    //   1194: aload 10
    //   1196: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1199: pop
    //   1200: aload 10
    //   1202: iload 5
    //   1204: bipush 7
    //   1206: iadd
    //   1207: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1210: pop
    //   1211: aload 10
    //   1213: iload_2
    //   1214: bipush 24
    //   1216: ishr
    //   1217: i2b
    //   1218: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1221: pop
    //   1222: aload 10
    //   1224: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1227: pop
    //   1228: aload_0
    //   1229: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   1232: aload_1
    //   1233: invokevirtual 1564	kellinwood/zipio/ZipInput:close	()V
    //   1236: return
    //   1237: astore_0
    //   1238: aload_0
    //   1239: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1242: return
    //   1243: astore_0
    //   1244: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   1247: aload_0
    //   1248: invokevirtual 405	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   1251: return
    //   1252: astore_0
    //   1253: aload_0
    //   1254: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1257: return
    //   1258: new 208	java/lang/StringBuilder
    //   1261: dup
    //   1262: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1265: ldc_w 1606
    //   1268: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: aload_1
    //   1272: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1278: invokestatic 654	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   1281: goto -987 -> 294
    //   1284: astore 12
    //   1286: aload 12
    //   1288: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1291: iconst_0
    //   1292: istore_3
    //   1293: goto -889 -> 404
    //   1296: aload 9
    //   1298: invokevirtual 393	java/util/zip/CRC32:getValue	()J
    //   1301: lstore 6
    //   1303: lload 6
    //   1305: l2i
    //   1306: istore_2
    //   1307: goto -831 -> 476
    //   1310: astore 9
    //   1312: aload 9
    //   1314: invokevirtual 166	java/io/FileNotFoundException:printStackTrace	()V
    //   1317: goto -584 -> 733
    //   1320: astore 9
    //   1322: aload 9
    //   1324: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   1327: goto -594 -> 733
    //   1330: aload 11
    //   1332: invokevirtual 910	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   1335: astore 9
    //   1337: goto -970 -> 367
    //   1340: astore 11
    //   1342: aload 11
    //   1344: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1347: iconst_0
    //   1348: istore_3
    //   1349: goto -478 -> 871
    //   1352: astore 10
    //   1354: aload 10
    //   1356: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1359: iconst_0
    //   1360: istore_2
    //   1361: goto -382 -> 979
    //   1364: astore_0
    //   1365: aload 9
    //   1367: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1370: goto -138 -> 1232
    //   1373: astore_0
    //   1374: aload 9
    //   1376: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1379: goto -147 -> 1232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1382	0	paramFile	File
    //   0	1382	1	paramString	String
    //   30	1331	2	i	int
    //   184	1165	3	j	int
    //   410	502	4	k	int
    //   198	1009	5	m	int
    //   323	981	6	l	long
    //   383	448	8	bool	boolean
    //   8	448	9	localObject1	Object
    //   467	3	9	localException1	Exception
    //   490	239	9	localFileChannel	FileChannel
    //   749	548	9	localException2	Exception
    //   1310	3	9	localFileNotFoundException	FileNotFoundException
    //   1320	3	9	localIOException	IOException
    //   1335	40	9	localZipEntry	ZipEntry
    //   14	1209	10	localObject2	Object
    //   1352	3	10	localException3	Exception
    //   358	973	11	localObject3	Object
    //   1340	3	11	localException4	Exception
    //   440	283	12	localObject4	Object
    //   1284	3	12	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   404	412	467	java/lang/Exception
    //   421	442	467	java/lang/Exception
    //   442	450	467	java/lang/Exception
    //   455	464	467	java/lang/Exception
    //   1296	1303	467	java/lang/Exception
    //   332	367	749	java/lang/Exception
    //   372	385	749	java/lang/Exception
    //   469	474	749	java/lang/Exception
    //   476	510	749	java/lang/Exception
    //   514	617	749	java/lang/Exception
    //   621	728	749	java/lang/Exception
    //   728	733	749	java/lang/Exception
    //   733	738	749	java/lang/Exception
    //   738	748	749	java/lang/Exception
    //   1286	1291	749	java/lang/Exception
    //   1312	1317	749	java/lang/Exception
    //   1322	1327	749	java/lang/Exception
    //   1330	1337	749	java/lang/Exception
    //   765	795	1237	java/lang/Exception
    //   795	830	1237	java/lang/Exception
    //   979	1010	1237	java/lang/Exception
    //   1014	1117	1237	java/lang/Exception
    //   1121	1228	1237	java/lang/Exception
    //   1228	1232	1237	java/lang/Exception
    //   1232	1236	1237	java/lang/Exception
    //   1342	1347	1237	java/lang/Exception
    //   1354	1359	1237	java/lang/Exception
    //   1365	1370	1237	java/lang/Exception
    //   1374	1379	1237	java/lang/Exception
    //   141	294	1243	java/lang/Exception
    //   298	325	1243	java/lang/Exception
    //   751	765	1243	java/lang/Exception
    //   1238	1242	1243	java/lang/Exception
    //   1258	1281	1243	java/lang/Exception
    //   0	29	1252	java/lang/Exception
    //   36	133	1252	java/lang/Exception
    //   1244	1251	1252	java/lang/Exception
    //   390	400	1284	java/lang/Exception
    //   476	510	1310	java/io/FileNotFoundException
    //   514	617	1310	java/io/FileNotFoundException
    //   621	728	1310	java/io/FileNotFoundException
    //   728	733	1310	java/io/FileNotFoundException
    //   476	510	1320	java/io/IOException
    //   514	617	1320	java/io/IOException
    //   621	728	1320	java/io/IOException
    //   728	733	1320	java/io/IOException
    //   835	871	1340	java/lang/Exception
    //   871	905	1352	java/lang/Exception
    //   914	979	1352	java/lang/Exception
    //   979	1010	1364	java/io/FileNotFoundException
    //   1014	1117	1364	java/io/FileNotFoundException
    //   1121	1228	1364	java/io/FileNotFoundException
    //   1228	1232	1364	java/io/FileNotFoundException
    //   979	1010	1373	java/io/IOException
    //   1014	1117	1373	java/io/IOException
    //   1121	1228	1373	java/io/IOException
    //   1228	1232	1373	java/io/IOException
  }
  
  public static String gen_sha1withrsa(String paramString)
  {
    paramString = new byte[paramString.length()];
    rnd.nextBytes(paramString);
    return Base64.encode(paramString);
  }
  
  public static Drawable getApkIcon(String paramString)
  {
    PackageManager localPackageManager = listAppsFragment.getPkgMng();
    Object localObject = localPackageManager.getPackageArchiveInfo(paramString, 1);
    if (localObject != null)
    {
      localObject = ((PackageInfo)localObject).applicationInfo;
      if (Build.VERSION.SDK_INT >= 8)
      {
        ((ApplicationInfo)localObject).sourceDir = paramString;
        ((ApplicationInfo)localObject).publicSourceDir = paramString;
      }
      return ((ApplicationInfo)localObject).loadIcon(localPackageManager);
    }
    return null;
  }
  
  public static ApplicationInfo getApkInfo(String paramString)
  {
    Object localObject = listAppsFragment.getPkgMng().getPackageArchiveInfo(paramString, 1);
    if (localObject != null)
    {
      localObject = ((PackageInfo)localObject).applicationInfo;
      if (Build.VERSION.SDK_INT >= 8)
      {
        ((ApplicationInfo)localObject).sourceDir = paramString;
        ((ApplicationInfo)localObject).publicSourceDir = paramString;
      }
      return (ApplicationInfo)localObject;
    }
    return null;
  }
  
  public static String getApkLabelName(String paramString)
  {
    PackageManager localPackageManager = listAppsFragment.getPkgMng();
    Object localObject = localPackageManager.getPackageArchiveInfo(paramString, 1);
    if (localObject != null)
    {
      localObject = ((PackageInfo)localObject).applicationInfo;
      if (Build.VERSION.SDK_INT >= 8)
      {
        ((ApplicationInfo)localObject).sourceDir = paramString;
        ((ApplicationInfo)localObject).publicSourceDir = paramString;
      }
      return ((ApplicationInfo)localObject).loadLabel(localPackageManager).toString();
    }
    return null;
  }
  
  public static PackageInfo getApkPackageInfo(String paramString)
  {
    paramString = listAppsFragment.getPkgMng().getPackageArchiveInfo(paramString, 1);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public static void getAssets(String paramString1, String paramString2)
    throws IOException
  {
    new File(paramString2).mkdirs();
    InputStream localInputStream = listAppsFragment.getRes().getAssets().open(paramString1);
    paramString1 = new FileOutputStream(paramString2 + "/" + paramString1);
    paramString2 = new byte[' '];
    for (;;)
    {
      int i = localInputStream.read(paramString2);
      if (i == -1) {
        break;
      }
      paramString1.write(paramString2, 0, i);
    }
    localInputStream.close();
    paramString1.flush();
    paramString1.close();
  }
  
  public static SpannableString getColoredText(String paramString1, int paramInt, String paramString2)
  {
    SpannableString localSpannableString = new SpannableString(paramString1);
    int i = 0;
    try
    {
      if (paramString2.toLowerCase().contains("bold")) {
        i = 1;
      }
      if (paramString2.toLowerCase().contains("bold_italic")) {
        i = 3;
      }
      if (paramString2.toLowerCase().contains("italic")) {
        i = 2;
      }
      localSpannableString.setSpan(new ForegroundColorSpan(paramInt), 0, paramString1.length(), 0);
      localSpannableString.setSpan(new StyleSpan(i), 0, paramString1.length(), 0);
      return localSpannableString;
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      paramString2 = paramString1;
      if (paramString1.length() == 0) {
        paramString2 = " ";
      }
    }
    return new SpannableString(paramString2);
  }
  
  public static SpannableString getColoredText(String paramString1, String paramString2, String paramString3)
  {
    SpannableString localSpannableString = new SpannableString(paramString1);
    int i = 0;
    try
    {
      if (paramString3.toLowerCase().contains("bold")) {
        i = 1;
      }
      if (paramString3.toLowerCase().contains("bold_italic")) {
        i = 3;
      }
      if (paramString3.toLowerCase().contains("italic")) {
        i = 2;
      }
      if (!paramString2.equals("")) {
        localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor(paramString2)), 0, paramString1.length(), 0);
      }
      localSpannableString.setSpan(new StyleSpan(i), 0, paramString1.length(), 0);
      return localSpannableString;
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      paramString2 = paramString1;
      if (paramString1.length() == 0) {
        paramString2 = " ";
      }
    }
    return new SpannableString(paramString2);
  }
  
  /* Error */
  public static String getCurrentRuntimeValue()
  {
    // Byte code:
    //   0: getstatic 1712	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:runtime	Ljava/lang/String;
    //   3: ldc_w 847
    //   6: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +7 -> 16
    //   12: ldc_w 847
    //   15: areturn
    //   16: getstatic 1712	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:runtime	Ljava/lang/String;
    //   19: ldc_w 849
    //   22: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +7 -> 32
    //   28: ldc_w 1714
    //   31: areturn
    //   32: ldc_w 847
    //   35: areturn
    //   36: astore_0
    //   37: aload_0
    //   38: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   41: ldc_w 1716
    //   44: invokestatic 878	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   47: astore_0
    //   48: aload_0
    //   49: ldc_w 1717
    //   52: iconst_2
    //   53: anewarray 760	java/lang/Class
    //   56: dup
    //   57: iconst_0
    //   58: ldc 92
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: ldc 92
    //   65: aastore
    //   66: invokevirtual 888	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnonnull +7 -> 78
    //   74: ldc_w 1719
    //   77: areturn
    //   78: aload_1
    //   79: aload_0
    //   80: iconst_2
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: ldc 66
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: ldc_w 1714
    //   94: aastore
    //   95: invokevirtual 898	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 92	java/lang/String
    //   101: astore_1
    //   102: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   105: aload_1
    //   106: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   109: ldc 60
    //   111: aload_1
    //   112: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifeq +7 -> 122
    //   118: ldc_w 1714
    //   121: areturn
    //   122: ldc 54
    //   124: aload_1
    //   125: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifeq +7 -> 135
    //   131: ldc_w 847
    //   134: areturn
    //   135: aload_1
    //   136: astore_0
    //   137: ldc 57
    //   139: aload_1
    //   140: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +40 -> 183
    //   146: ldc_w 1721
    //   149: areturn
    //   150: astore_0
    //   151: ldc_w 1723
    //   154: areturn
    //   155: astore_0
    //   156: ldc_w 1725
    //   159: areturn
    //   160: astore_0
    //   161: ldc_w 1727
    //   164: areturn
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 1728	java/lang/ClassNotFoundException:printStackTrace	()V
    //   170: ldc_w 1714
    //   173: areturn
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   179: ldc_w 1714
    //   182: astore_0
    //   183: aload_0
    //   184: areturn
    //   185: astore_0
    //   186: ldc_w 1730
    //   189: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	2	0	localException1	Exception
    //   47	90	0	localObject1	Object
    //   150	1	0	localIllegalAccessException	IllegalAccessException
    //   155	1	0	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   160	1	0	localNoSuchMethodException	NoSuchMethodException
    //   165	2	0	localClassNotFoundException	ClassNotFoundException
    //   174	2	0	localException2	Exception
    //   182	2	0	str	String
    //   185	1	0	localIllegalArgumentException	IllegalArgumentException
    //   69	71	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	36	java/lang/Exception
    //   16	28	36	java/lang/Exception
    //   78	118	150	java/lang/IllegalAccessException
    //   122	131	150	java/lang/IllegalAccessException
    //   137	146	150	java/lang/IllegalAccessException
    //   78	118	155	java/lang/reflect/InvocationTargetException
    //   122	131	155	java/lang/reflect/InvocationTargetException
    //   137	146	155	java/lang/reflect/InvocationTargetException
    //   48	70	160	java/lang/NoSuchMethodException
    //   78	118	160	java/lang/NoSuchMethodException
    //   122	131	160	java/lang/NoSuchMethodException
    //   137	146	160	java/lang/NoSuchMethodException
    //   41	48	165	java/lang/ClassNotFoundException
    //   48	70	165	java/lang/ClassNotFoundException
    //   78	118	165	java/lang/ClassNotFoundException
    //   122	131	165	java/lang/ClassNotFoundException
    //   137	146	165	java/lang/ClassNotFoundException
    //   41	48	174	java/lang/Exception
    //   48	70	174	java/lang/Exception
    //   78	118	174	java/lang/Exception
    //   122	131	174	java/lang/Exception
    //   137	146	174	java/lang/Exception
    //   78	118	185	java/lang/IllegalArgumentException
    //   122	131	185	java/lang/IllegalArgumentException
    //   137	146	185	java/lang/IllegalArgumentException
  }
  
  public static ArrayList<File> getCustomPatchesForPkg(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        if ((listAppsFragment.customlist == null) || (listAppsFragment.customlist.length == 0)) {
          listAppsFragment.init();
        }
        try
        {
          listAppsFragment.basepath = listAppsFragment.getConfig().getString("basepath", listAppsFragment.basepath);
          listAppsFragment.customlist = new File[new File(listAppsFragment.basepath).listFiles().length];
          listAppsFragment.customlist = new File(listAppsFragment.basepath).listFiles();
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.clear();
          i = 0;
          if (i < listAppsFragment.customlist.length)
          {
            if ((!listAppsFragment.customlist[i].isFile()) || (!listAppsFragment.customlist[i].getName().endsWith(".txt"))) {
              break label380;
            }
            localArrayList2.add(listAppsFragment.customlist[i]);
            break label380;
          }
          if (localArrayList2.size() > 0)
          {
            listAppsFragment.customlist = new File[localArrayList2.size()];
            listAppsFragment.customlist = (File[])localArrayList2.toArray(listAppsFragment.customlist);
          }
        }
        catch (Exception localException)
        {
          System.out.println("Not found dir by Lucky Patcher. Custom patch not found.");
          continue;
        }
        if ((listAppsFragment.customlist != null) && (listAppsFragment.customlist.length > 0))
        {
          i = 0;
          if (i < listAppsFragment.customlist.length)
          {
            if (listAppsFragment.customlist[i].getName().contains("_%ALL%.txt"))
            {
              if (!paramString.contains(listAppsFragment.customlist[i].getName().replace("_%ALL%.txt", ""))) {
                break label302;
              }
              localArrayList1.add(listAppsFragment.customlist[i]);
            }
            if (!listAppsFragment.customlist[i].getName().replace(".txt", "").endsWith(paramString)) {
              break label387;
            }
            localArrayList1.add(listAppsFragment.customlist[i]);
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return localArrayList1;
      label302:
      if ((listAppsFragment.customlist[i].getName().contains("_%ALL%.txt")) && (listAppsFragment.customlist[i].getName().contains("%ALL%_")) && (paramString.contains(listAppsFragment.customlist[i].getName().split("%ALL%_")[1].replace("_%ALL%.txt", ""))))
      {
        localArrayList1.add(listAppsFragment.customlist[i]);
        continue;
        label380:
        i += 1;
        continue;
        label387:
        i += 1;
      }
    }
  }
  
  public static File getDirs(File paramFile)
  {
    String[] arrayOfString = paramFile.toString().split(File.separator);
    paramFile = "";
    int i = 0;
    while (i < arrayOfString.length)
    {
      Object localObject = paramFile;
      if (i != arrayOfString.length - 1) {
        localObject = paramFile + arrayOfString[i] + File.separator;
      }
      i += 1;
      paramFile = (File)localObject;
    }
    return new File(paramFile);
  }
  
  public static File getFileDalvikCache(String paramString)
  {
    Object localObject1;
    Object localObject3;
    if ((listAppsFragment.api >= 23) && (!paramString.startsWith("/system/")))
    {
      localObject2 = "";
      localObject4 = new File(paramString);
      localObject1 = localObject2;
      if (new File("/data/dalvik-cache/arm").exists())
      {
        localObject1 = localObject2;
        if (new File("/data/dalvik-cache/arm").isDirectory()) {
          localObject1 = "/arm";
        }
      }
      localObject2 = localObject1;
      if (new File("/data/dalvik-cache/arm64").exists())
      {
        localObject2 = localObject1;
        if (new File("/data/dalvik-cache/arm64").isDirectory()) {
          localObject2 = "/arm64";
        }
      }
      localObject3 = localObject2;
      if (new File("/data/dalvik-cache/x86").exists())
      {
        localObject3 = localObject2;
        if (new File("/data/dalvik-cache/x86").isDirectory()) {
          localObject3 = "/x86";
        }
      }
      localObject1 = localObject3;
      if (new File("/data/dalvik-cache/x86_64").exists())
      {
        localObject1 = localObject3;
        if (new File("/data/dalvik-cache/x86_64").isDirectory()) {
          localObject1 = "/x86_64";
        }
      }
      localObject2 = changeExtension(((File)localObject4).getName(), "odex");
      if (!paramString.startsWith("/system"))
      {
        paramString = (String)localObject1;
        if (((String)localObject1).equals("/arm64"))
        {
          localObject3 = new File(getDirs((File)localObject4) + "/oat/arm/" + (String)localObject2);
          paramString = (String)localObject1;
          if (((File)localObject3).exists())
          {
            paramString = (String)localObject1;
            if (((File)localObject3).length() != 0L) {
              paramString = "/arm";
            }
          }
        }
        return new File(getDirs((File)localObject4) + "/oat" + paramString + "/" + (String)localObject2);
      }
    }
    for (paramString = paramString.replaceAll("/", "@"); paramString.startsWith("@"); paramString = paramString.replaceFirst("@", "")) {}
    Object localObject4 = paramString + "@classes.dex";
    Object localObject2 = "";
    if (listAppsFragment.startUnderRoot.booleanValue())
    {
      localObject1 = localObject2;
      try
      {
        localObject3 = new Utils("").findFileContainText(new File("/data/dalvik-cache"), (String)localObject4);
        paramString = (String)localObject3;
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (((String)localObject3).startsWith("\"/data/dalvik-cache/arm/\""))
        {
          paramString = (String)localObject3;
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (new File("/data/dalvik-cache/arm64/" + (String)localObject4).exists())
          {
            localObject1 = localObject3;
            localObject2 = localObject3;
            paramString = "/data/dalvik-cache/arm64/" + (String)localObject4;
          }
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = (String)localObject1;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = (String)localObject2;
        }
      }
      if (!paramString.equals(""))
      {
        System.out.println("" + paramString);
        if (new File(paramString).exists()) {
          return new File(paramString);
        }
      }
    }
    else
    {
      if (new File("/data/dalvik-cache/x86/" + (String)localObject4).exists()) {
        return new File("/data/dalvik-cache/x86/" + (String)localObject4);
      }
      if (new File("/data/dalvik-cache/x86_64/" + (String)localObject4).exists()) {
        return new File("/data/dalvik-cache/x86_64/" + (String)localObject4);
      }
      if (new File("/data/dalvik-cache/arm64/" + (String)localObject4).exists()) {
        return new File("/data/dalvik-cache/arm64/" + (String)localObject4);
      }
      if (new File("/data/dalvik-cache/arm/" + (String)localObject4).exists()) {
        return new File("/data/dalvik-cache/arm/" + (String)localObject4);
      }
      if (new File("/data/dalvik-cache/" + (String)localObject4).exists()) {
        return new File("/data/dalvik-cache/" + (String)localObject4);
      }
    }
    return null;
  }
  
  public static File getFileDalvikCacheName(String paramString)
  {
    int i = 0;
    Object localObject1;
    if (new File("/data/art-cache/").exists())
    {
      for (localObject1 = paramString.replaceAll("/", "@"); ((String)localObject1).startsWith("@"); localObject1 = ((String)localObject1).replaceFirst("@", "")) {}
      localObject1 = (String)localObject1 + ".oat";
      if (new File("/data/art-cache/" + (String)localObject1).exists())
      {
        System.out.println("\nLuckyPatcher: found dalvik-cache! " + "/data/art-cache/" + (String)localObject1);
        localObject3 = new File("/data/art-cache/" + (String)localObject1);
      }
    }
    Object localObject4;
    Object localObject2;
    label640:
    do
    {
      do
      {
        return (File)localObject3;
        localObject4 = new String[9];
        localObject4[0] = "/data/dalvik-cache/";
        localObject4[1] = "/data/dalvik-cache/arm64/";
        localObject4[2] = "/data/dalvik-cache/arm/";
        localObject4[3] = "/data/dalvik-cache/x86/";
        localObject4[4] = "/data/dalvik-cache/x86_64/";
        localObject4[5] = "/sd-ext/data/dalvik-cache/";
        localObject4[6] = "/cache/dalvik-cache/";
        localObject4[7] = "/sd-ext/data/cache/dalvik-cache/";
        localObject4[8] = "/data/cache/dalvik-cache/";
        for (localObject1 = paramString.replaceAll("/", "@"); ((String)localObject1).startsWith("@"); localObject1 = ((String)localObject1).replaceFirst("@", "")) {}
        localObject3 = (String)localObject1 + "@classes.dex";
        System.out.println("dalvikfile: " + (String)localObject3);
        localObject2 = null;
        int j = localObject4.length;
        while (i < j)
        {
          localObject1 = localObject4[i];
          if (new File((String)localObject1 + (String)localObject3).exists())
          {
            System.out.println("\nLuckyPatcher: found dalvik-cache! " + (String)localObject1 + (String)localObject3);
            localObject2 = new File((String)localObject1 + (String)localObject3);
          }
          i += 1;
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if ((!exists("/data/dalvik-cache/arm")) && (!exists("/data/dalvik-cache/arm64")) && (!exists("/data/dalvik-cache/x86")) && (!exists("/data/dalvik-cache/x86_64"))) {
            break;
          }
          if (exists("/data/dalvik-cache/arm")) {
            localObject2 = new File("/data/dalvik-cache/arm/" + (String)localObject3);
          }
          if (exists("/data/dalvik-cache/arm64")) {
            localObject2 = new File("/data/dalvik-cache/arm64/" + (String)localObject3);
          }
          localObject1 = localObject2;
          if (exists("/data/dalvik-cache/x86")) {
            localObject1 = new File("/data/dalvik-cache/x86/" + (String)localObject3);
          }
          if (exists("/data/dalvik-cache/x86_64")) {
            localObject1 = new File("/data/dalvik-cache/x86_64/" + (String)localObject3);
          }
        }
        localObject3 = localObject1;
      } while (listAppsFragment.api < 23);
      localObject3 = localObject1;
    } while (paramString.startsWith("/system/"));
    Object localObject3 = "";
    File localFile = new File(paramString);
    if (listAppsFragment.startUnderRoot.booleanValue())
    {
      localObject2 = localObject3;
      if (new File("/data/dalvik-cache/arm").exists())
      {
        localObject2 = localObject3;
        if (new File("/data/dalvik-cache/arm").isDirectory()) {
          localObject2 = "/arm";
        }
      }
      localObject3 = localObject2;
      if (new File("/data/dalvik-cache/arm64").exists())
      {
        localObject3 = localObject2;
        if (new File("/data/dalvik-cache/arm64").isDirectory()) {
          localObject3 = "/arm64";
        }
      }
      localObject4 = localObject3;
      if (new File("/data/dalvik-cache/x86").exists())
      {
        localObject4 = localObject3;
        if (new File("/data/dalvik-cache/x86").isDirectory()) {
          localObject4 = "/x86";
        }
      }
      localObject2 = localObject4;
      if (new File("/data/dalvik-cache/x86_64").exists())
      {
        localObject2 = localObject4;
        if (new File("/data/dalvik-cache/x86_64").isDirectory()) {
          localObject2 = "/x86_64";
        }
      }
    }
    for (;;)
    {
      localObject4 = changeExtension(localFile.getName(), "odex");
      localObject3 = localObject1;
      if (paramString.startsWith("/system")) {
        break;
      }
      paramString = (String)localObject2;
      if (((String)localObject2).equals("/arm64"))
      {
        localObject1 = new File(getDirs(localFile) + "/oat/arm/" + (String)localObject4);
        paramString = (String)localObject2;
        if (((File)localObject1).exists())
        {
          paramString = (String)localObject2;
          if (((File)localObject1).length() != 0L) {
            paramString = "/arm";
          }
        }
      }
      return new File(getDirs(localFile) + "/oat" + paramString + "/" + (String)localObject4);
      localObject1 = new File("/data/dalvik-cache/" + (String)localObject3);
      break label640;
      localObject2 = localObject3;
      if (exists("/data/dalvik-cache/arm")) {
        localObject2 = "/arm";
      }
      if (exists("/data/dalvik-cache/arm64")) {
        localObject2 = "/arm64";
      }
      if (exists("/data/dalvik-cache/x86")) {
        localObject2 = "/x86";
      }
      if (exists("/data/dalvik-cache/x86_64")) {
        localObject2 = "/x86_64";
      }
    }
  }
  
  public static void getFilesWithPkgName(String paramString, File paramFile, ArrayList<File> paramArrayList)
  {
    remount("/system", "rw");
    File[] arrayOfFile = paramFile.listFiles();
    int j;
    int i;
    int k;
    if ((arrayOfFile != null) && (arrayOfFile.length != 0))
    {
      j = arrayOfFile.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramFile = arrayOfFile[i];
          if (paramFile.getAbsolutePath().endsWith(".apk")) {}
          try
          {
            if (paramString.equals(new FileApkListItem(listAppsFragment.getInstance(), paramFile, false).pkgName)) {
              paramArrayList.add(paramFile);
            }
            i += 1;
          }
          catch (Exception paramFile)
          {
            for (;;)
            {
              paramFile.printStackTrace();
            }
          }
        }
      }
      k = arrayOfFile.length;
      i = 0;
    }
    while (i < k)
    {
      paramFile = arrayOfFile[i];
      if (paramFile.isDirectory()) {
        try
        {
          paramFile = paramFile.listFiles();
          if ((paramFile != null) && (paramFile.length != 0))
          {
            int m = paramFile.length;
            j = 0;
            for (;;)
            {
              if (j < m)
              {
                File localFile = paramFile[j];
                boolean bool = localFile.getAbsolutePath().endsWith(".apk");
                if (bool) {}
                try
                {
                  if (paramString.equals(new FileApkListItem(listAppsFragment.getInstance(), localFile, false).pkgName)) {
                    paramArrayList.add(localFile);
                  }
                  j += 1;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    localException.printStackTrace();
                  }
                }
              }
            }
          }
          i += 1;
        }
        catch (Exception paramFile)
        {
          paramFile.printStackTrace();
        }
      }
      continue;
      System.out.println("LuckyPatcher: 0 packages found in " + paramFile.getAbsolutePath());
    }
  }
  
  public static boolean getMethodsIds(String paramString, ArrayList<CommandItem> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    System.out.println("scan: " + paramString);
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool3 = false;
    run_all_no_root(new String[] { "chmod", "777", paramString });
    new ArrayList();
    boolean bool1 = bool5;
    if (!paramBoolean1)
    {
      bool1 = bool5;
      if (paramString != null)
      {
        bool1 = bool5;
        paramBoolean1 = bool7;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (new File(paramString).exists())
        {
          paramBoolean1 = bool7;
          long l = new File(paramString).length();
          bool1 = bool5;
          if (l != 0L) {
            bool1 = bool6;
          }
        }
        int j;
        try
        {
          paramBoolean1 = new File(paramString).exists();
          bool1 = bool5;
          MappedByteBuffer localMappedByteBuffer;
          Object localObject2;
          Object localObject3;
          if (paramBoolean1)
          {
            paramBoolean1 = bool3;
            try
            {
              paramString = new RandomAccessFile(paramString, "r").getChannel();
              paramBoolean1 = bool3;
              localMappedByteBuffer = paramString.map(FileChannel.MapMode.READ_ONLY, 0L, (int)paramString.size());
              paramBoolean1 = bool3;
              localMappedByteBuffer.position(64);
              paramBoolean1 = bool3;
              int k = convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get());
              paramBoolean1 = bool3;
              i = convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get());
              paramBoolean1 = bool3;
              System.out.println("LuckyPatcher offset_to_data=" + Integer.toHexString(i));
              paramBoolean1 = bool3;
              localMappedByteBuffer.position(i);
              j = 0;
              i = 0;
              if (i >= k) {
                continue;
              }
              paramBoolean1 = bool3;
              localObject1 = new byte[4];
              paramBoolean1 = bool3;
              localObject1[0] = localMappedByteBuffer.get();
              paramBoolean1 = bool3;
              localObject1[1] = localMappedByteBuffer.get();
              paramBoolean1 = bool3;
              localObject1[2] = localMappedByteBuffer.get();
              paramBoolean1 = bool3;
              localObject1[3] = localMappedByteBuffer.get();
              paramBoolean1 = bool3;
              localObject2 = paramArrayList.iterator();
              paramBoolean1 = bool3;
              if (((Iterator)localObject2).hasNext())
              {
                paramBoolean1 = bool3;
                localObject3 = (CommandItem)((Iterator)localObject2).next();
                paramBoolean1 = bool3;
                if (localObject1[0] != localObject3.Object[0]) {
                  continue;
                }
                paramBoolean1 = bool3;
                if (localObject1[1] != localObject3.Object[1]) {
                  continue;
                }
                paramBoolean1 = bool3;
                if (localObject1[2] != localObject3.Object[2]) {
                  continue;
                }
                paramBoolean1 = bool3;
                if (localObject1[3] != localObject3.Object[3]) {
                  continue;
                }
                paramBoolean1 = bool3;
                ((CommandItem)localObject3).id_object[0] = ((byte)j);
                paramBoolean1 = bool3;
                ((CommandItem)localObject3).id_object[1] = ((byte)(j >> 8));
                paramBoolean1 = bool3;
                ((CommandItem)localObject3).found_id_object = true;
                continue;
                return bool1;
              }
            }
            catch (Exception paramString)
            {
              bool1 = paramBoolean1;
              paramString.printStackTrace();
              bool1 = paramBoolean1;
            }
          }
          j += 1;
          i += 1;
          continue;
          i = 0;
          paramBoolean1 = bool3;
          Object localObject1 = paramArrayList.iterator();
          paramBoolean1 = bool3;
          if (((Iterator)localObject1).hasNext())
          {
            paramBoolean1 = bool3;
            if (!((CommandItem)((Iterator)localObject1).next()).found_id_object) {
              continue;
            }
            i = 1;
            continue;
          }
          if (i != 0)
          {
            paramBoolean1 = bool3;
            localMappedByteBuffer.position(88);
            paramBoolean1 = bool3;
            i = convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get());
            paramBoolean1 = bool3;
            localMappedByteBuffer.position(convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get()));
            paramBoolean1 = bool3;
            localObject1 = new byte[i];
            j = 0;
            i = 0;
            bool1 = bool4;
            paramBoolean1 = bool1;
            bool2 = bool1;
            if (i < localObject1.length)
            {
              paramBoolean1 = bool1;
              localObject2 = new byte[8];
              paramBoolean1 = bool1;
              localObject2[0] = localMappedByteBuffer.get();
              paramBoolean1 = bool1;
              localObject2[1] = localMappedByteBuffer.get();
              paramBoolean1 = bool1;
              localObject2[2] = localMappedByteBuffer.get();
              paramBoolean1 = bool1;
              localObject2[3] = localMappedByteBuffer.get();
              paramBoolean1 = bool1;
              localObject2[4] = localMappedByteBuffer.get();
              paramBoolean1 = bool1;
              localObject2[5] = localMappedByteBuffer.get();
              paramBoolean1 = bool1;
              localObject2[6] = localMappedByteBuffer.get();
              paramBoolean1 = bool1;
              localObject2[7] = localMappedByteBuffer.get();
              paramBoolean1 = bool1;
              localObject3 = paramArrayList.iterator();
              paramBoolean1 = bool1;
              if (!((Iterator)localObject3).hasNext()) {
                break label1053;
              }
              paramBoolean1 = bool1;
              CommandItem localCommandItem = (CommandItem)((Iterator)localObject3).next();
              paramBoolean1 = bool1;
              if (localObject2[0] != localCommandItem.id_object[0]) {
                continue;
              }
              paramBoolean1 = bool1;
              if (localObject2[1] != localCommandItem.id_object[1]) {
                continue;
              }
              paramBoolean1 = bool1;
              if (localObject2[4] != localCommandItem.Method[0]) {
                continue;
              }
              paramBoolean1 = bool1;
              if (localObject2[5] != localCommandItem.Method[1]) {
                continue;
              }
              paramBoolean1 = bool1;
              if (localObject2[6] != localCommandItem.Method[2]) {
                continue;
              }
              paramBoolean1 = bool1;
              if (localObject2[7] != localCommandItem.Method[3]) {
                continue;
              }
              if (paramBoolean2)
              {
                paramBoolean1 = bool1;
                if (localCommandItem.found_index_command) {
                  continue;
                }
              }
              paramBoolean1 = bool1;
              localCommandItem.index_command[0] = ((byte)j);
              paramBoolean1 = bool1;
              localCommandItem.index_command[1] = ((byte)(j >> 8));
              paramBoolean1 = bool1;
              localCommandItem.found_index_command = true;
              bool1 = true;
              continue;
            }
          }
          paramBoolean1 = bool2;
          paramString.close();
          return bool2;
        }
        catch (Exception paramString)
        {
          paramBoolean1 = bool1;
          paramString.printStackTrace();
          return bool1;
        }
        j += 1;
      }
      catch (Exception paramString)
      {
        System.out.println(paramString);
        return paramBoolean1;
      }
      label1053:
      i += 1;
    }
  }
  
  /* Error */
  public static ArrayList<Mount> getMounts()
  {
    // Byte code:
    //   0: getstatic 927	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   3: invokevirtual 932	java/lang/Boolean:booleanValue	()Z
    //   6: ifne +323 -> 329
    //   9: new 2	com/chelpus/Utils
    //   12: dup
    //   13: ldc 86
    //   15: invokespecial 946	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   18: iconst_1
    //   19: anewarray 92	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: new 208	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   31: getstatic 1239	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
    //   34: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 1877
    //   40: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: aastore
    //   47: invokevirtual 1236	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 6
    //   52: aload 6
    //   54: astore 5
    //   56: aload 6
    //   58: ldc_w 1879
    //   61: invokevirtual 630	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifeq +112 -> 176
    //   67: invokestatic 1233	com/chelpus/Utils:exitRoot	()V
    //   70: invokestatic 1883	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getSu	()Ljava/lang/Process;
    //   73: pop
    //   74: new 2	com/chelpus/Utils
    //   77: dup
    //   78: ldc 86
    //   80: invokespecial 946	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   83: iconst_1
    //   84: anewarray 92	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: ldc_w 1885
    //   92: aastore
    //   93: invokevirtual 1236	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 5
    //   98: aload 5
    //   100: astore 6
    //   102: aload 5
    //   104: ldc_w 1879
    //   107: invokevirtual 630	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   110: ifeq +27 -> 137
    //   113: new 2	com/chelpus/Utils
    //   116: dup
    //   117: ldc 86
    //   119: invokespecial 946	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   122: iconst_1
    //   123: anewarray 92	java/lang/String
    //   126: dup
    //   127: iconst_0
    //   128: ldc_w 1887
    //   131: aastore
    //   132: invokevirtual 1236	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 6
    //   137: aload 6
    //   139: astore 5
    //   141: aload 6
    //   143: ldc_w 1879
    //   146: invokevirtual 630	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   149: ifeq +27 -> 176
    //   152: new 2	com/chelpus/Utils
    //   155: dup
    //   156: ldc 86
    //   158: invokespecial 946	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   161: iconst_1
    //   162: anewarray 92	java/lang/String
    //   165: dup
    //   166: iconst_0
    //   167: ldc_w 1889
    //   170: aastore
    //   171: invokevirtual 1236	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 5
    //   176: aload 5
    //   178: ldc_w 758
    //   181: invokevirtual 579	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   184: astore 5
    //   186: new 290	java/util/ArrayList
    //   189: dup
    //   190: invokespecial 592	java/util/ArrayList:<init>	()V
    //   193: astore 6
    //   195: iconst_0
    //   196: istore_1
    //   197: iconst_0
    //   198: istore_0
    //   199: aload 5
    //   201: arraylength
    //   202: istore 4
    //   204: iconst_0
    //   205: istore_3
    //   206: iload_0
    //   207: istore_1
    //   208: iload_3
    //   209: iload 4
    //   211: if_icmpge +270 -> 481
    //   214: iload_0
    //   215: istore_1
    //   216: aload 5
    //   218: iload_3
    //   219: aaload
    //   220: ldc_w 1891
    //   223: ldc_w 587
    //   226: invokevirtual 369	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   229: ldc_w 1893
    //   232: ldc_w 587
    //   235: invokevirtual 369	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   238: ldc_w 1895
    //   241: invokevirtual 579	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   244: astore 7
    //   246: iload_0
    //   247: istore_2
    //   248: iload_0
    //   249: istore_1
    //   250: aload 7
    //   252: iconst_1
    //   253: aaload
    //   254: ldc_w 1317
    //   257: invokevirtual 630	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   260: ifeq +5 -> 265
    //   263: iconst_1
    //   264: istore_2
    //   265: iload_2
    //   266: istore_1
    //   267: aload 6
    //   269: new 1533	com/android/vending/billing/InAppBillingService/LACK/Mount
    //   272: dup
    //   273: new 171	java/io/File
    //   276: dup
    //   277: aload 7
    //   279: iconst_0
    //   280: aaload
    //   281: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   284: new 171	java/io/File
    //   287: dup
    //   288: aload 7
    //   290: iconst_1
    //   291: aaload
    //   292: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   295: aload 7
    //   297: iconst_2
    //   298: aaload
    //   299: aload 7
    //   301: iconst_3
    //   302: aaload
    //   303: invokespecial 1898	com/android/vending/billing/InAppBillingService/LACK/Mount:<init>	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V
    //   306: invokevirtual 315	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   309: pop
    //   310: iload_3
    //   311: iconst_1
    //   312: iadd
    //   313: istore_3
    //   314: iload_2
    //   315: istore_0
    //   316: goto -110 -> 206
    //   319: astore 5
    //   321: aload 5
    //   323: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   326: goto -252 -> 74
    //   329: iconst_2
    //   330: anewarray 92	java/lang/String
    //   333: dup
    //   334: iconst_0
    //   335: new 208	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   342: getstatic 1239	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:toolfilesdir	Ljava/lang/String;
    //   345: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: ldc_w 1247
    //   351: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: ldc_w 1885
    //   363: aastore
    //   364: invokestatic 1197	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   367: astore 6
    //   369: aload 6
    //   371: astore 5
    //   373: aload 6
    //   375: ldc_w 1879
    //   378: invokevirtual 630	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   381: ifeq -205 -> 176
    //   384: iconst_1
    //   385: anewarray 92	java/lang/String
    //   388: dup
    //   389: iconst_0
    //   390: ldc_w 1885
    //   393: aastore
    //   394: invokestatic 1197	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   397: astore 5
    //   399: aload 5
    //   401: astore 6
    //   403: aload 5
    //   405: ldc_w 1879
    //   408: invokevirtual 630	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   411: ifeq +24 -> 435
    //   414: iconst_2
    //   415: anewarray 92	java/lang/String
    //   418: dup
    //   419: iconst_0
    //   420: ldc_w 1201
    //   423: aastore
    //   424: dup
    //   425: iconst_1
    //   426: ldc_w 1885
    //   429: aastore
    //   430: invokestatic 1197	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   433: astore 6
    //   435: aload 6
    //   437: astore 5
    //   439: aload 6
    //   441: ldc_w 1879
    //   444: invokevirtual 630	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   447: ifeq -271 -> 176
    //   450: iconst_2
    //   451: anewarray 92	java/lang/String
    //   454: dup
    //   455: iconst_0
    //   456: ldc_w 1199
    //   459: aastore
    //   460: dup
    //   461: iconst_1
    //   462: ldc_w 1885
    //   465: aastore
    //   466: invokestatic 1197	com/chelpus/Utils:cmdParam	([Ljava/lang/String;)Ljava/lang/String;
    //   469: astore 5
    //   471: goto -295 -> 176
    //   474: astore 5
    //   476: aload 5
    //   478: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   481: aload 6
    //   483: astore 5
    //   485: iload_1
    //   486: ifne +159 -> 645
    //   489: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   492: ldc_w 1900
    //   495: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   498: getstatic 927	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   501: invokevirtual 932	java/lang/Boolean:booleanValue	()Z
    //   504: ifne +144 -> 648
    //   507: ldc_w 1902
    //   510: ldc_w 1904
    //   513: iconst_0
    //   514: iconst_1
    //   515: invokestatic 1221	com/chelpus/Utils:copyFile	(Ljava/lang/String;Ljava/lang/String;ZZ)Z
    //   518: pop
    //   519: ldc_w 1906
    //   522: invokestatic 654	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   525: aload 6
    //   527: invokevirtual 1749	java/util/ArrayList:clear	()V
    //   530: new 1908	java/io/LineNumberReader
    //   533: dup
    //   534: new 1910	java/io/FileReader
    //   537: dup
    //   538: ldc_w 1904
    //   541: invokespecial 1911	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   544: invokespecial 1912	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   547: astore 7
    //   549: new 290	java/util/ArrayList
    //   552: dup
    //   553: invokespecial 592	java/util/ArrayList:<init>	()V
    //   556: astore 5
    //   558: aload 7
    //   560: invokevirtual 1913	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   563: astore 6
    //   565: aload 6
    //   567: ifnull +121 -> 688
    //   570: aload 6
    //   572: ldc_w 587
    //   575: invokevirtual 579	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   578: astore 6
    //   580: aload 5
    //   582: new 1533	com/android/vending/billing/InAppBillingService/LACK/Mount
    //   585: dup
    //   586: new 171	java/io/File
    //   589: dup
    //   590: aload 6
    //   592: iconst_0
    //   593: aaload
    //   594: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   597: new 171	java/io/File
    //   600: dup
    //   601: aload 6
    //   603: iconst_1
    //   604: aaload
    //   605: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   608: aload 6
    //   610: iconst_2
    //   611: aaload
    //   612: aload 6
    //   614: iconst_3
    //   615: aaload
    //   616: invokespecial 1898	com/android/vending/billing/InAppBillingService/LACK/Mount:<init>	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V
    //   619: invokevirtual 315	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   622: pop
    //   623: goto -65 -> 558
    //   626: astore 7
    //   628: aload 5
    //   630: astore 6
    //   632: aload 7
    //   634: astore 5
    //   636: aload 5
    //   638: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   641: aload 6
    //   643: astore 5
    //   645: aload 5
    //   647: areturn
    //   648: ldc_w 1902
    //   651: ldc_w 1904
    //   654: iconst_0
    //   655: iconst_1
    //   656: invokestatic 1221	com/chelpus/Utils:copyFile	(Ljava/lang/String;Ljava/lang/String;ZZ)Z
    //   659: pop
    //   660: iconst_3
    //   661: anewarray 92	java/lang/String
    //   664: dup
    //   665: iconst_0
    //   666: ldc_w 453
    //   669: aastore
    //   670: dup
    //   671: iconst_1
    //   672: ldc_w 591
    //   675: aastore
    //   676: dup
    //   677: iconst_2
    //   678: ldc_w 1904
    //   681: aastore
    //   682: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   685: goto -160 -> 525
    //   688: aload 7
    //   690: invokevirtual 1914	java/io/LineNumberReader:close	()V
    //   693: aload 5
    //   695: areturn
    //   696: astore 5
    //   698: goto -62 -> 636
    //   701: astore 5
    //   703: goto -67 -> 636
    // Local variable table:
    //   start	length	slot	name	signature
    //   198	118	0	i	int
    //   196	290	1	j	int
    //   247	68	2	k	int
    //   205	109	3	m	int
    //   202	10	4	n	int
    //   54	163	5	localObject1	Object
    //   319	3	5	localIOException	IOException
    //   371	99	5	localObject2	Object
    //   474	3	5	localException1	Exception
    //   483	211	5	localObject3	Object
    //   696	1	5	localException2	Exception
    //   701	1	5	localException3	Exception
    //   50	592	6	localObject4	Object
    //   244	315	7	localObject5	Object
    //   626	63	7	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   70	74	319	java/io/IOException
    //   199	204	474	java/lang/Exception
    //   216	246	474	java/lang/Exception
    //   250	263	474	java/lang/Exception
    //   267	310	474	java/lang/Exception
    //   558	565	626	java/lang/Exception
    //   570	623	626	java/lang/Exception
    //   688	693	626	java/lang/Exception
    //   530	549	696	java/lang/Exception
    //   549	558	701	java/lang/Exception
  }
  
  public static String getOdexForCreate(String paramString1, String paramString2)
  {
    File localFile;
    int j;
    Object localObject1;
    Object localObject2;
    if ((listAppsFragment.startUnderRoot != null) && (listAppsFragment.startUnderRoot.booleanValue()))
    {
      System.out.println("Start under Root");
      localFile = new File(paramString1);
      j = 0;
      localObject1 = "";
      if (listAppsFragment.api < 23) {
        break label2202;
      }
      localObject2 = changeExtension(localFile.getName(), "odex");
      if (!listAppsFragment.startUnderRoot.booleanValue()) {
        break label1464;
      }
      paramString1 = (String)localObject1;
      if (new File("/data/dalvik-cache/arm").exists())
      {
        paramString1 = (String)localObject1;
        if (new File("/data/dalvik-cache/arm").isDirectory()) {
          paramString1 = "/arm";
        }
      }
      localObject1 = paramString1;
      if (new File("/data/dalvik-cache/arm64").exists())
      {
        localObject1 = paramString1;
        if (new File("/data/dalvik-cache/arm64").isDirectory()) {
          localObject1 = "/arm64";
        }
      }
      paramString1 = (String)localObject1;
      if (new File("/data/dalvik-cache/x86").exists())
      {
        paramString1 = (String)localObject1;
        if (new File("/data/dalvik-cache/x86").isDirectory()) {
          paramString1 = "/x86";
        }
      }
      localObject1 = paramString1;
      if (new File("/data/dalvik-cache/x86_64").exists())
      {
        localObject1 = paramString1;
        if (new File("/data/dalvik-cache/x86_64").isDirectory()) {
          localObject1 = "/x86_64";
        }
      }
      paramString1 = (String)localObject1;
      if (!((String)localObject1).equals(""))
      {
        paramString1 = (String)localObject1;
        if (new File("/data/dalvik-cache" + (String)localObject1).exists())
        {
          paramString1 = (String)localObject1;
          if (new File("/data/dalvik-cache" + (String)localObject1).isDirectory())
          {
            System.out.println((String)localObject1 + " to dalvik cache found");
            System.out.println("check " + getDirs(localFile) + "/oat" + (String)localObject1);
            if ((!new File(getDirs(localFile) + "/oat" + (String)localObject1).exists()) || (!new File(getDirs(localFile) + "/oat" + (String)localObject1).isDirectory()))
            {
              new File(getDirs(localFile) + "/oat" + (String)localObject1).mkdirs();
              System.out.println("try make dirs");
              if (new File(getDirs(localFile) + "/oat" + (String)localObject1).exists())
              {
                System.out.println("dirs created");
                if (paramString2.equals("0")) {
                  break label1102;
                }
                run_all_no_root(new String[] { "chmod", "755", getDirs(localFile) + "/oat" });
                run_all_no_root(new String[] { "chown", "1000." + paramString2, getDirs(localFile) + "/oat" });
                run_all_no_root(new String[] { "chown", "1000:" + paramString2, getDirs(localFile) + "/oat" });
                run_all_no_root(new String[] { "chmod", "755", getDirs(localFile) + "/oat" + (String)localObject1 });
                run_all_no_root(new String[] { "chown", "1000." + paramString2, getDirs(localFile) + "/oat" + (String)localObject1 });
                run_all_no_root(new String[] { "chown", "1000:" + paramString2, getDirs(localFile) + "/oat" + (String)localObject1 });
              }
            }
            label948:
            paramString1 = (String)localObject1;
          }
        }
      }
    }
    label1102:
    label1464:
    do
    {
      do
      {
        paramString2 = paramString1;
        if (paramString1.equals("/arm64"))
        {
          localObject1 = new File(getDirs(localFile) + "/oat/arm/" + (String)localObject2);
          paramString2 = paramString1;
          if (((File)localObject1).exists())
          {
            paramString2 = paramString1;
            if (((File)localObject1).length() != 0L) {
              paramString2 = "/arm";
            }
          }
        }
        return getDirs(localFile) + "/oat" + paramString2 + "/" + (String)localObject2;
        if (listAppsFragment.startUnderRoot == null) {
          System.out.println("uderRoot not defined");
        }
        if (listAppsFragment.startUnderRoot.booleanValue()) {
          break;
        }
        System.out.println("uderRoot false");
        break;
        run_all_no_root(new String[] { "chmod", "755", getDirs(localFile) + "/oat" });
        run_all_no_root(new String[] { "chown", "0." + paramString2, getDirs(localFile) + "/oat" });
        run_all_no_root(new String[] { "chown", "0:" + paramString2, getDirs(localFile) + "/oat" });
        run_all_no_root(new String[] { "chmod", "755", getDirs(localFile) + "/oat" + (String)localObject1 });
        run_all_no_root(new String[] { "chown", "0." + paramString2, getDirs(localFile) + "/oat" + (String)localObject1 });
        run_all_no_root(new String[] { "chown", "0:" + paramString2, getDirs(localFile) + "/oat" + (String)localObject1 });
        break label948;
        if (exists("/data/dalvik-cache/arm")) {
          localObject1 = "/arm";
        }
        if (exists("/data/dalvik-cache/arm64")) {
          localObject1 = "/arm64";
        }
        if (exists("/data/dalvik-cache/x86")) {
          localObject1 = "/x86";
        }
        if (exists("/data/dalvik-cache/x86_64")) {
          localObject1 = "/x86_64";
        }
        paramString1 = (String)localObject1;
      } while (((String)localObject1).equals(""));
      paramString1 = (String)localObject1;
    } while (!exists("/data/dalvik-cache" + (String)localObject1));
    if (!exists(getDirs(localFile) + "/oat" + (String)localObject1))
    {
      run_all("mkdir -p '" + getDirs(localFile) + "/oat" + (String)localObject1 + "'");
      if (exists(getDirs(localFile) + "/oat" + (String)localObject1))
      {
        if (paramString2.equals("0")) {
          break label1946;
        }
        run_all("chmod 755 " + getDirs(localFile) + "/oat");
        run_all("chown 1000." + paramString2 + " " + getDirs(localFile) + "/oat");
        run_all("chown 1000:" + paramString2 + " " + getDirs(localFile) + "/oat");
        run_all("chmod 755 " + getDirs(localFile) + "/oat" + (String)localObject1);
        run_all("chown 1000." + paramString2 + " " + getDirs(localFile) + "/oat" + (String)localObject1);
        run_all("chown 1000:" + paramString2 + " " + getDirs(localFile) + "/oat" + (String)localObject1);
      }
    }
    for (;;)
    {
      paramString1 = (String)localObject1;
      break;
      label1946:
      run_all("chmod 755 " + getDirs(localFile) + "/oat");
      run_all("chown 0." + paramString2 + " " + getDirs(localFile) + "/oat");
      run_all("chown 0:" + paramString2 + " " + getDirs(localFile) + "/oat");
      run_all("chmod 755 " + getDirs(localFile) + "/oat" + (String)localObject1);
      run_all("chown 0." + paramString2 + " " + getDirs(localFile) + "/oat" + (String)localObject1);
      run_all("chown 0:" + paramString2 + " " + getDirs(localFile) + "/oat" + (String)localObject1);
    }
    label2202:
    int i;
    if (listAppsFragment.startUnderRoot.booleanValue())
    {
      localObject2 = localObject1;
      if (new File("/data/dalvik-cache/arm").exists())
      {
        localObject2 = localObject1;
        if (new File("/data/dalvik-cache/arm").isDirectory()) {
          localObject2 = "/arm";
        }
      }
      localObject1 = localObject2;
      if (new File("/data/dalvik-cache/arm64").exists())
      {
        localObject1 = localObject2;
        if (new File("/data/dalvik-cache/arm64").isDirectory()) {
          localObject1 = "/arm64";
        }
      }
      localObject2 = localObject1;
      if (new File("/data/dalvik-cache/x86").exists())
      {
        localObject2 = localObject1;
        if (new File("/data/dalvik-cache/x86").isDirectory()) {
          localObject2 = "/x86";
        }
      }
      localObject1 = localObject2;
      if (new File("/data/dalvik-cache/x86_64").exists())
      {
        localObject1 = localObject2;
        if (new File("/data/dalvik-cache/x86_64").isDirectory()) {
          localObject1 = "/x86_64";
        }
      }
      localObject2 = localObject1;
      i = j;
      if (!((String)localObject1).equals(""))
      {
        localObject2 = localObject1;
        i = j;
        if (new File("/data/dalvik-cache" + (String)localObject1).exists())
        {
          localObject2 = localObject1;
          i = j;
          if (new File("/data/dalvik-cache" + (String)localObject1).isDirectory())
          {
            System.out.println((String)localObject1 + " to dalvik cache found");
            System.out.println("check " + getDirs(localFile) + (String)localObject1);
            if ((!new File(getDirs(localFile) + (String)localObject1).exists()) || (!new File(getDirs(localFile) + (String)localObject1).isDirectory()))
            {
              new File(getDirs(localFile) + (String)localObject1).mkdirs();
              System.out.println("try make dirs");
              if (new File(getDirs(localFile) + (String)localObject1).exists())
              {
                System.out.println("dirs created");
                if (paramString2.equals("0")) {
                  break label2941;
                }
                run_all_no_root(new String[] { "chmod", "755", getDirs(localFile) + (String)localObject1 });
                run_all_no_root(new String[] { "chown", "1000." + paramString2, getDirs(localFile) + (String)localObject1 });
                run_all_no_root(new String[] { "chown", "1000:" + paramString2, getDirs(localFile) + (String)localObject1 });
              }
            }
            i = 1;
            localObject2 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return getDirs(localFile) + (String)localObject2 + "/" + changeExtension(localFile.getName(), "odex");
        label2941:
        run_all_no_root(new String[] { "chmod", "755", getDirs(localFile) + (String)localObject1 });
        run_all_no_root(new String[] { "chown", "0." + paramString2, getDirs(localFile) + (String)localObject1 });
        run_all_no_root(new String[] { "chown", "0:" + paramString2, getDirs(localFile) + (String)localObject1 });
        break;
        if (exists("/data/dalvik-cache/arm")) {
          localObject1 = "/arm";
        }
        if (exists("/data/dalvik-cache/arm64")) {
          localObject1 = "/arm64";
        }
        if (exists("/data/dalvik-cache/x86")) {
          localObject1 = "/x86";
        }
        if (exists("/data/dalvik-cache/x86_64")) {
          localObject1 = "/x86_64";
        }
        localObject2 = localObject1;
        i = j;
        if (!((String)localObject1).equals(""))
        {
          localObject2 = localObject1;
          i = j;
          if (exists("/data/dalvik-cache" + (String)localObject1))
          {
            if (!exists(getDirs(localFile) + (String)localObject1))
            {
              run_all("mkdir -p '" + getDirs(localFile) + (String)localObject1 + "'");
              if (exists(getDirs(localFile) + (String)localObject1))
              {
                if (paramString2.equals("0")) {
                  break label3449;
                }
                run_all("chmod 755 " + getDirs(localFile) + (String)localObject1);
                run_all("chown 1000." + paramString2 + " " + getDirs(localFile) + (String)localObject1);
                run_all("chown 1000:" + paramString2 + " " + getDirs(localFile) + (String)localObject1);
              }
            }
            for (;;)
            {
              i = 1;
              localObject2 = localObject1;
              break;
              label3449:
              run_all("chmod 755 " + getDirs(localFile) + (String)localObject1);
              run_all("chown 0." + paramString2 + " " + getDirs(localFile) + (String)localObject1);
              run_all("chown 0:" + paramString2 + " " + getDirs(localFile) + (String)localObject1);
            }
          }
        }
      }
    }
    return changeExtension(paramString1, "odex");
  }
  
  public static String getPermissions(String paramString)
  {
    if (!listAppsFragment.startUnderRoot.booleanValue())
    {
      str2 = cmdParam(new String[] { listAppsFragment.toolfilesdir + "/busybox", "stat", "-c", "%a", paramString }).replaceAll("\n", "").replaceAll("\r", "").trim();
      System.out.println(str2);
      str1 = str2;
      if (!str2.matches("(\\d+)"))
      {
        System.out.println("try get permission again");
        str1 = cmdParam(new String[] { "busybox", "stat", "-c", "%a", paramString }).replaceAll("\n", "").replaceAll("\r", "").trim();
      }
      if (!str1.matches("(\\d+)")) {
        return "";
      }
      return str1;
    }
    String str2 = cmdParam(new String[] { listAppsFragment.toolfilesdir + "/busybox", "stat", "-c", "%a", paramString }).replaceAll("\n", "").replaceAll("\r", "").trim();
    System.out.println("'" + str2 + "'");
    String str1 = str2;
    if (!str2.matches("(\\d+)"))
    {
      System.out.println("try get permission again");
      str1 = cmdParam(new String[] { "busybox", "stat", "-c", "%a", paramString }).replaceAll("\n", "").replaceAll("\r", "").trim();
    }
    if (!str1.matches("(\\d+)")) {
      return "";
    }
    return str1;
  }
  
  public static PackageInfo getPkgInfo(String paramString, int paramInt)
  {
    try
    {
      paramString = listAppsFragment.getPkgMng().getPackageInfo(paramString, paramInt);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String getPlaceForOdex(String paramString, boolean paramBoolean)
  {
    File localFile = new File(paramString);
    int j = 0;
    Object localObject1 = "";
    Object localObject2;
    if (listAppsFragment.api >= 23)
    {
      String str = changeExtension(localFile.getName(), "odex");
      if (paramBoolean)
      {
        paramString = (String)localObject1;
        if (new File("/data/dalvik-cache/arm").exists())
        {
          paramString = (String)localObject1;
          if (new File("/data/dalvik-cache/arm").isDirectory()) {
            paramString = "/arm";
          }
        }
        localObject1 = paramString;
        if (new File("/data/dalvik-cache/arm64").exists())
        {
          localObject1 = paramString;
          if (new File("/data/dalvik-cache/arm64").isDirectory()) {
            localObject1 = "/arm64";
          }
        }
        paramString = (String)localObject1;
        if (new File("/data/dalvik-cache/x86").exists())
        {
          paramString = (String)localObject1;
          if (new File("/data/dalvik-cache/x86").isDirectory()) {
            paramString = "/x86";
          }
        }
        localObject1 = paramString;
        if (new File("/data/dalvik-cache/x86_64").exists())
        {
          localObject1 = paramString;
          if (new File("/data/dalvik-cache/x86_64").isDirectory()) {
            localObject1 = "/x86_64";
          }
        }
        localObject2 = localObject1;
        if (!((String)localObject1).equals(""))
        {
          localObject2 = localObject1;
          if (new File("/data/dalvik-cache" + (String)localObject1).exists())
          {
            localObject2 = localObject1;
            if (!new File("/data/dalvik-cache" + (String)localObject1).isDirectory()) {}
          }
        }
      }
      for (;;)
      {
        return getDirs(localFile) + "/oat" + (String)localObject2 + "/" + str;
        if (exists("/data/dalvik-cache/arm")) {
          localObject1 = "/arm";
        }
        if (exists("/data/dalvik-cache/arm64")) {
          localObject1 = "/arm64";
        }
        paramString = (String)localObject1;
        if (exists("/data/dalvik-cache/x86")) {
          paramString = "/x86";
        }
        if (exists("/data/dalvik-cache/x86_64")) {
          paramString = "/x86_64";
        }
        localObject2 = paramString;
        if (!paramString.equals(""))
        {
          localObject2 = paramString;
          if (exists("/data/dalvik-cache" + paramString)) {
            localObject2 = paramString;
          }
        }
      }
    }
    int i;
    if (paramBoolean)
    {
      localObject2 = localObject1;
      if (new File("/data/dalvik-cache/arm").exists())
      {
        localObject2 = localObject1;
        if (new File("/data/dalvik-cache/arm").isDirectory()) {
          localObject2 = "/arm";
        }
      }
      localObject1 = localObject2;
      if (new File("/data/dalvik-cache/arm64").exists())
      {
        localObject1 = localObject2;
        if (new File("/data/dalvik-cache/arm64").isDirectory()) {
          localObject1 = "/arm64";
        }
      }
      localObject2 = localObject1;
      if (new File("/data/dalvik-cache/x86").exists())
      {
        localObject2 = localObject1;
        if (new File("/data/dalvik-cache/x86").isDirectory()) {
          localObject2 = "/x86";
        }
      }
      localObject1 = localObject2;
      if (new File("/data/dalvik-cache/x86_64").exists())
      {
        localObject1 = localObject2;
        if (new File("/data/dalvik-cache/x86_64").isDirectory()) {
          localObject1 = "/x86_64";
        }
      }
      localObject2 = localObject1;
      i = j;
      if (!((String)localObject1).equals(""))
      {
        localObject2 = localObject1;
        i = j;
        if (new File("/data/dalvik-cache" + (String)localObject1).exists())
        {
          localObject2 = localObject1;
          i = j;
          if (new File("/data/dalvik-cache" + (String)localObject1).isDirectory())
          {
            i = 1;
            localObject2 = localObject1;
          }
        }
      }
    }
    while (i != 0)
    {
      return getDirs(localFile) + (String)localObject2 + "/" + changeExtension(localFile.getName(), "odex");
      if (exists("/data/dalvik-cache/arm")) {
        localObject1 = "/arm";
      }
      if (exists("/data/dalvik-cache/arm64")) {
        localObject1 = "/arm64";
      }
      if (exists("/data/dalvik-cache/x86")) {
        localObject1 = "/x86";
      }
      if (exists("/data/dalvik-cache/x86_64")) {
        localObject1 = "/x86_64";
      }
      localObject2 = localObject1;
      i = j;
      if (!((String)localObject1).equals(""))
      {
        localObject2 = localObject1;
        i = j;
        if (exists("/data/dalvik-cache" + (String)localObject1))
        {
          i = 1;
          localObject2 = localObject1;
        }
      }
    }
    return changeExtension(paramString, "odex");
  }
  
  public static long getRandom(long paramLong1, long paramLong2)
  {
    Random localRandom = new Random();
    long l1;
    long l2;
    do
    {
      l1 = localRandom.nextLong() << 1 >>> 1;
      l2 = l1 % (paramLong2 - paramLong1 + 1L);
    } while (l1 - l2 + (paramLong2 - paramLong1) < 0L);
    return l2 + paramLong1;
  }
  
  public static String getRandomStringLowerCase(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append("abcdefghijklmnopqrstuvwxyz".charAt(rnd.nextInt("abcdefghijklmnopqrstuvwxyz".length())));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String getRandomStringUpperLowerCase(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(rnd.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".length())));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static long getRawLength(int paramInt)
  {
    try
    {
      InputStream localInputStream = listAppsFragment.getRes().openRawResource(paramInt);
      long l = 0L;
      byte[] arrayOfByte = new byte[' '];
      for (;;)
      {
        paramInt = localInputStream.read(arrayOfByte);
        if (paramInt == -1) {
          break;
        }
        l += paramInt;
      }
      System.out.println("LuckyPatcher (RAW): length = " + l);
      return l;
    }
    catch (IOException localIOException) {}
    return 0L;
  }
  
  public static boolean getRawToFile(int paramInt, File paramFile)
  {
    if (paramFile.exists()) {
      paramFile.delete();
    }
    for (;;)
    {
      System.out.println("try get file from raw");
      try
      {
        byte[] arrayOfByte = new byte[' '];
        InputStream localInputStream = listAppsFragment.getRes().openRawResource(paramInt);
        paramFile = new FileOutputStream(paramFile);
        paramInt = localInputStream.read(arrayOfByte);
        for (;;)
        {
          if (paramInt > 0)
          {
            paramFile.write(arrayOfByte, 0, paramInt);
            paramInt = localInputStream.read(arrayOfByte);
            continue;
            getDirs(paramFile).mkdirs();
            break;
          }
        }
        paramFile.flush();
        paramFile.close();
        localInputStream.close();
        System.out.println("get file from raw");
        return true;
      }
      catch (IOException paramFile) {}
    }
    return false;
  }
  
  public static String getRawToString(int paramInt)
  {
    String str = "";
    try
    {
      byte[] arrayOfByte = new byte['ࠀ'];
      InputStream localInputStream = listAppsFragment.getRes().openRawResource(paramInt);
      paramInt = 0;
      while (paramInt != -1)
      {
        paramInt = localInputStream.read(arrayOfByte);
        str = str + new String(arrayOfByte, "UTF-8");
      }
      localInputStream.close();
      return str;
    }
    catch (IOException localIOException) {}
    return "";
  }
  
  public static void getRoot()
  {
    if (!listAppsFragment.startUnderRoot.booleanValue()) {}
    try
    {
      if (listAppsFragment.suProcess == null)
      {
        System.out.println("LuckyPatcher: GET ROOT.");
        listAppsFragment.suProcess = Runtime.getRuntime().exec("su");
        listAppsFragment.suOutputStream = new DataOutputStream(listAppsFragment.suProcess.getOutputStream());
        listAppsFragment.suInputStream = new DataInputStream(listAppsFragment.suProcess.getInputStream());
        listAppsFragment.suErrorInputStream = new DataInputStream(listAppsFragment.suProcess.getErrorStream());
        return;
      }
      try
      {
        listAppsFragment.suOutputStream.writeBytes("echo chelpusstart!\n");
        return;
      }
      catch (Exception localException1)
      {
        exitRoot();
        listAppsFragment.suProcess = Runtime.getRuntime().exec("su");
        listAppsFragment.suOutputStream = new DataOutputStream(listAppsFragment.suProcess.getOutputStream());
        listAppsFragment.suInputStream = new DataInputStream(listAppsFragment.suProcess.getInputStream());
        listAppsFragment.suErrorInputStream = new DataInputStream(listAppsFragment.suProcess.getErrorStream());
        return;
      }
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
  
  public static boolean getRootUid()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = System.getProperty("user.name").contains("root");
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static String getSELinux()
  {
    new File("/data/lp");
    Object localObject = new File("/data/lp/lp_utils");
    if (!((File)localObject).exists()) {
      System.out.println("Lucky Patcher not found utils.");
    }
    do
    {
      return "";
      localObject = read_from_file((File)localObject).split("%chelpus%");
    } while ((localObject == null) || (localObject.length <= 0));
    int i = 0;
    while (i < localObject.length) {
      switch (i)
      {
      default: 
        i += 1;
      }
    }
    return localObject[i];
  }
  
  private static void getSignatureKeys()
  {
    try
    {
      if ((!new File(listAppsFragment.toolfilesdir + "/" + "zipalign").exists()) || (new File(listAppsFragment.toolfilesdir + "/" + "zipalign").length() != getRawLength(2131099666)))
      {
        getRawToFile(2131099666, new File(listAppsFragment.toolfilesdir + "/zipalign"));
        chmod(new File(listAppsFragment.getInstance().getFilesDir() + "/" + "zipalign"), 777);
        run_all("chmod 777 " + listAppsFragment.getInstance().getFilesDir() + "/" + "zipalign");
      }
      for (;;)
      {
        getAssets("testkey.pk8", listAppsFragment.basepath + "/Modified/Keys");
        getAssets("testkey.sbt", listAppsFragment.basepath + "/Modified/Keys");
        getAssets("testkey.x509.pem", listAppsFragment.basepath + "/Modified/Keys");
        return;
        chmod(new File(listAppsFragment.toolfilesdir + "/" + "zipalign"), 777);
        run_all("chmod 777 " + listAppsFragment.toolfilesdir + "/" + "zipalign");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static String getSimulink(String paramString)
  {
    if (listAppsFragment.startUnderRoot.booleanValue())
    {
      localObject = cmdParam(new String[] { "ls", "-l", paramString });
      localObject = Pattern.compile("^.*?\\-\\>\\s+(.*)$").matcher((CharSequence)localObject);
      if (((Matcher)localObject).find())
      {
        paramString = ((Matcher)localObject).group(1);
        System.out.println("Symlink found: " + paramString);
        return paramString;
      }
      paramString = cmdParam(new String[] { listAppsFragment.toolfilesdir + "/busybox", "ls", "-l", paramString });
      System.out.println(paramString);
      paramString = Pattern.compile("^.*?\\-\\>\\s+(.*)$").matcher(paramString);
      if (paramString.find())
      {
        paramString = paramString.group(1);
        System.out.println("Symlink found: " + paramString);
        return paramString;
      }
      System.out.println("No symlink found!");
      return "";
    }
    Object localObject = new Utils("").cmdRoot(new String[] { "ls -l " + paramString });
    localObject = Pattern.compile("^.*?\\-\\>\\s+(.*)$").matcher((CharSequence)localObject);
    if (((Matcher)localObject).find())
    {
      paramString = ((Matcher)localObject).group(1);
      System.out.println("Symlink found: " + paramString);
      return paramString;
    }
    paramString = new Utils("").cmdRoot(new String[] { listAppsFragment.toolfilesdir + "/busybox ls -l " + paramString });
    paramString = Pattern.compile("^.*?\\-\\>\\s+(.*)$").matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      System.out.println("Symlink found: " + paramString);
      return paramString;
    }
    System.out.println("No symlink found!");
    return "";
  }
  
  public static ArrayList<StringItem> getStringIds(String paramString, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    System.out.println("scan: " + paramString);
    run_all_no_root(new String[] { "chmod", "777", paramString });
    ArrayList localArrayList = new ArrayList();
    if (!paramBoolean) {
      if (paramString == null) {}
    }
    MappedByteBuffer localMappedByteBuffer;
    int i1;
    int[] arrayOfInt1;
    int n;
    int[] arrayOfInt2;
    String[] arrayOfString;
    int i4;
    int i2;
    int i5;
    int i3;
    int i;
    int j;
    int k;
    int m;
    label521:
    while (!paramBoolean) {
      try
      {
        if (new File(paramString).exists())
        {
          long l = new File(paramString).length();
          if (l == 0L) {}
        }
        try
        {
          paramBoolean = new File(paramString).exists();
          if (paramBoolean) {}
          try
          {
            paramString = new RandomAccessFile(paramString, "r").getChannel();
            localMappedByteBuffer = paramString.map(FileChannel.MapMode.READ_ONLY, 0L, (int)paramString.size());
            localMappedByteBuffer.position(56);
            i1 = convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get());
            localMappedByteBuffer.position(convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get()));
            arrayOfInt1 = new int[i1];
            n = 0;
            while (n < i1)
            {
              arrayOfInt1[n] = convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get());
              n += 1;
            }
            i1 = 0;
            arrayOfInt2 = new int[paramArrayList.size()];
            arrayOfString = new String[paramArrayList.size()];
            n = 0;
            while (n < arrayOfInt2.length)
            {
              arrayOfInt2[n] = ((String)paramArrayList.get(n)).length();
              arrayOfString[n] = ((String)paramArrayList.get(n));
              n += 1;
            }
            i4 = arrayOfInt1.length;
            n = 0;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return localArrayList;
          }
          if (i2 >= arrayOfInt2.length) {
            break label1062;
          }
          i3 = convertByteToInt(localMappedByteBuffer.get(i5));
          if (i3 != arrayOfInt2[i2]) {
            break;
          }
          paramArrayList = new byte[i3];
          localMappedByteBuffer.position(i5 + 1);
          i3 = 0;
          while (i3 < paramArrayList.length)
          {
            paramArrayList[i3] = localMappedByteBuffer.get();
            i3 += 1;
          }
          if (!arrayOfString[i2].equals(new String(paramArrayList))) {
            break;
          }
          i = (byte)i1;
          j = (byte)(i1 >> 8);
          k = (byte)(i1 >> 16);
          m = (byte)(i1 >> 24);
          paramBoolean = false;
          if (arrayOfInt1.length > 65535) {
            paramBoolean = true;
          }
          localArrayList.add(new StringItem(arrayOfString[i2], new byte[] { i, j, k, m }, paramBoolean));
          break;
          paramString.close();
          return localArrayList;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return localArrayList;
        }
        paramBoolean = new File(paramString).exists();
      }
      catch (Exception paramString)
      {
        System.out.println(paramString);
        return localArrayList;
      }
    }
    try
    {
      paramString = new RandomAccessFile(paramString, "r").getChannel();
      localMappedByteBuffer = paramString.map(FileChannel.MapMode.READ_ONLY, 0L, (int)paramString.size());
      localMappedByteBuffer.position(8);
      i1 = convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get());
      localMappedByteBuffer.position(i1 + 56);
      i2 = convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get());
      localMappedByteBuffer.position(convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get()) + i1);
      arrayOfInt1 = new int[i2];
      n = 0;
      while (n < i2)
      {
        arrayOfInt1[n] = (convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get()) + i1);
        n += 1;
      }
      i1 = 0;
      arrayOfInt2 = new int[paramArrayList.size()];
      arrayOfString = new String[paramArrayList.size()];
      n = 0;
      while (n < arrayOfInt2.length)
      {
        arrayOfInt2[n] = ((String)paramArrayList.get(n)).length();
        arrayOfString[n] = ((String)paramArrayList.get(n));
        n += 1;
      }
      i4 = arrayOfInt1.length;
      n = 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return localArrayList;
    }
    if (i2 < arrayOfInt2.length)
    {
      i3 = convertByteToInt(localMappedByteBuffer.get(i5));
      if (i3 == arrayOfInt2[i2])
      {
        paramArrayList = new byte[i3];
        localMappedByteBuffer.position(i5 + 1);
        i3 = 0;
        while (i3 < paramArrayList.length)
        {
          paramArrayList[i3] = localMappedByteBuffer.get();
          i3 += 1;
        }
        if (arrayOfString[i2].equals(new String(paramArrayList)))
        {
          i = (byte)i1;
          j = (byte)(i1 >> 8);
          k = (byte)(i1 >> 16);
          m = (byte)(i1 >> 24);
          paramBoolean = false;
          if (arrayOfInt1.length > 65535) {
            paramBoolean = true;
          }
          localArrayList.add(new StringItem(arrayOfString[i2], new byte[] { i, j, k, m }, paramBoolean));
        }
      }
    }
    label1062:
    label1075:
    label1119:
    for (;;)
    {
      paramString.close();
      return localArrayList;
      for (;;)
      {
        if (n >= i4) {
          break label1075;
        }
        i5 = arrayOfInt1[n];
        i2 = 0;
        break;
        i2 += 1;
        break;
        i1 += 1;
        n += 1;
      }
      break label521;
      for (;;)
      {
        if (n >= i4) {
          break label1119;
        }
        i5 = arrayOfInt1[n];
        i2 = 0;
        break;
        i2 += 1;
        break;
        i1 += 1;
        n += 1;
      }
    }
  }
  
  public static String getText(int paramInt)
  {
    if (listAppsFragment.resources == null) {
      listAppsFragment.resources = listAppsFragment.getRes();
    }
    return listAppsFragment.resources.getString(paramInt);
  }
  
  public static boolean getTypesIds(String paramString, ArrayList<TypesItem> paramArrayList, boolean paramBoolean)
  {
    System.out.println("scan: " + paramString);
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    run_all_no_root(new String[] { "chmod", "777", paramString });
    new ArrayList();
    boolean bool1 = bool4;
    if (!paramBoolean)
    {
      bool1 = bool4;
      if (paramString != null)
      {
        bool1 = bool4;
        paramBoolean = bool6;
      }
    }
    try
    {
      if (new File(paramString).exists())
      {
        paramBoolean = bool6;
        long l = new File(paramString).length();
        bool1 = bool4;
        if (l != 0L) {
          bool1 = bool5;
        }
      }
      try
      {
        paramBoolean = new File(paramString).exists();
        bool1 = bool4;
        if (paramBoolean) {
          paramBoolean = bool2;
        }
        for (;;)
        {
          int i;
          int j;
          try
          {
            paramString = new RandomAccessFile(paramString, "r").getChannel();
            paramBoolean = bool2;
            MappedByteBuffer localMappedByteBuffer = paramString.map(FileChannel.MapMode.READ_ONLY, 0L, (int)paramString.size());
            paramBoolean = bool2;
            localMappedByteBuffer.position(64);
            paramBoolean = bool2;
            int k = convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get());
            paramBoolean = bool2;
            i = convertFourBytesToInt(localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get(), localMappedByteBuffer.get());
            paramBoolean = bool2;
            System.out.println("LuckyPatcher offset_to_data=" + Integer.toHexString(i));
            paramBoolean = bool2;
            localMappedByteBuffer.position(i);
            j = 0;
            i = 0;
            if (i >= k) {
              break;
            }
            paramBoolean = bool2;
            byte[] arrayOfByte = new byte[4];
            paramBoolean = bool2;
            arrayOfByte[0] = localMappedByteBuffer.get();
            paramBoolean = bool2;
            arrayOfByte[1] = localMappedByteBuffer.get();
            paramBoolean = bool2;
            arrayOfByte[2] = localMappedByteBuffer.get();
            paramBoolean = bool2;
            arrayOfByte[3] = localMappedByteBuffer.get();
            paramBoolean = bool2;
            Iterator localIterator = paramArrayList.iterator();
            paramBoolean = bool2;
            if (localIterator.hasNext())
            {
              paramBoolean = bool2;
              TypesItem localTypesItem = (TypesItem)localIterator.next();
              paramBoolean = bool2;
              if (arrayOfByte[0] != localTypesItem.Type[0]) {
                continue;
              }
              paramBoolean = bool2;
              if (arrayOfByte[1] != localTypesItem.Type[1]) {
                continue;
              }
              paramBoolean = bool2;
              if (arrayOfByte[2] != localTypesItem.Type[2]) {
                continue;
              }
              paramBoolean = bool2;
              if (arrayOfByte[3] != localTypesItem.Type[3]) {
                continue;
              }
              paramBoolean = bool2;
              localTypesItem.id_type[0] = ((byte)j);
              paramBoolean = bool2;
              localTypesItem.id_type[1] = ((byte)(j >> 8));
              paramBoolean = bool2;
              localTypesItem.found_id_type = true;
              continue;
              return bool1;
            }
          }
          catch (Exception paramString)
          {
            bool1 = paramBoolean;
            paramString.printStackTrace();
            bool1 = paramBoolean;
          }
          j += 1;
          i += 1;
        }
        paramBoolean = bool2;
        paramArrayList = paramArrayList.iterator();
        bool1 = bool3;
        for (;;)
        {
          paramBoolean = bool1;
          if (!paramArrayList.hasNext()) {
            break;
          }
          paramBoolean = bool1;
          if (((TypesItem)paramArrayList.next()).found_id_type) {
            bool1 = true;
          }
        }
        paramBoolean = bool1;
        paramString.close();
        return bool1;
      }
      catch (Exception paramString)
      {
        paramBoolean = bool1;
        paramString.printStackTrace();
        return bool1;
      }
      return paramBoolean;
    }
    catch (Exception paramString)
    {
      System.out.println(paramString);
    }
  }
  
  public static String getXmlAttribute(String paramString1, String paramString2, String paramString3)
  {
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    try
    {
      paramString1 = localDocumentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(paramString1))).getElementsByTagName(paramString2);
      if (paramString1.getLength() < 0)
      {
        paramString1 = ((Element)paramString1.item(0)).getAttribute(paramString3);
        return paramString1;
      }
    }
    catch (ParserConfigurationException paramString1)
    {
      paramString1.printStackTrace();
      return "";
    }
    catch (SAXException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static long getfirstInstallTime(String paramString, boolean paramBoolean)
  {
    long l;
    if ((listAppsFragment.api > 8) && (!paramBoolean)) {
      try
      {
        l = listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).lastUpdateTime;
        return l;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
        return 0L;
      }
    }
    try
    {
      l = new File(listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).applicationInfo.sourceDir).lastModified();
      return l;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static boolean hasXposed()
  {
    return (System.getenv("CLASSPATH") != null) && (System.getenv("CLASSPATH").contains("Xposed"));
  }
  
  /* Error */
  public static boolean initXposedParam()
  {
    // Byte code:
    //   0: new 171	java/io/File
    //   3: dup
    //   4: ldc_w 2171
    //   7: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 175	java/io/File:exists	()Z
    //   13: ifne +354 -> 367
    //   16: new 171	java/io/File
    //   19: dup
    //   20: ldc_w 2005
    //   23: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokevirtual 175	java/io/File:exists	()Z
    //   29: ifne +67 -> 96
    //   32: getstatic 927	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   35: invokevirtual 932	java/lang/Boolean:booleanValue	()Z
    //   38: ifeq +248 -> 286
    //   41: new 171	java/io/File
    //   44: dup
    //   45: ldc_w 2005
    //   48: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: invokevirtual 198	java/io/File:mkdirs	()Z
    //   54: pop
    //   55: new 171	java/io/File
    //   58: dup
    //   59: ldc_w 2005
    //   62: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: iconst_1
    //   66: iconst_0
    //   67: invokevirtual 2175	java/io/File:setWritable	(ZZ)Z
    //   70: pop
    //   71: iconst_3
    //   72: anewarray 92	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: ldc_w 453
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: ldc_w 591
    //   86: aastore
    //   87: dup
    //   88: iconst_2
    //   89: ldc_w 2005
    //   92: aastore
    //   93: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   96: new 2177	org/json/JSONObject
    //   99: dup
    //   100: invokespecial 2178	org/json/JSONObject:<init>	()V
    //   103: astore_0
    //   104: aload_0
    //   105: ldc_w 2180
    //   108: iconst_1
    //   109: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload_0
    //   114: ldc_w 2185
    //   117: iconst_1
    //   118: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   121: pop
    //   122: aload_0
    //   123: ldc_w 2187
    //   126: iconst_1
    //   127: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload_0
    //   132: ldc_w 2189
    //   135: iconst_1
    //   136: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload_0
    //   141: ldc_w 2191
    //   144: iconst_0
    //   145: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload_0
    //   150: ldc_w 2193
    //   153: iconst_1
    //   154: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   157: pop
    //   158: getstatic 927	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   161: invokevirtual 932	java/lang/Boolean:booleanValue	()Z
    //   164: ifeq +152 -> 316
    //   167: new 171	java/io/File
    //   170: dup
    //   171: ldc_w 2171
    //   174: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   177: aload_0
    //   178: invokevirtual 2194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   181: invokestatic 2197	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   184: pop
    //   185: new 171	java/io/File
    //   188: dup
    //   189: ldc_w 2171
    //   192: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: iconst_1
    //   196: iconst_0
    //   197: invokevirtual 2175	java/io/File:setWritable	(ZZ)Z
    //   200: pop
    //   201: iconst_3
    //   202: anewarray 92	java/lang/String
    //   205: dup
    //   206: iconst_0
    //   207: ldc_w 453
    //   210: aastore
    //   211: dup
    //   212: iconst_1
    //   213: ldc_w 591
    //   216: aastore
    //   217: dup
    //   218: iconst_2
    //   219: ldc_w 2171
    //   222: aastore
    //   223: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   226: new 2177	org/json/JSONObject
    //   229: dup
    //   230: new 171	java/io/File
    //   233: dup
    //   234: ldc_w 2171
    //   237: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: invokestatic 2013	com/chelpus/Utils:read_from_file	(Ljava/io/File;)Ljava/lang/String;
    //   243: invokespecial 2198	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   246: pop
    //   247: new 2177	org/json/JSONObject
    //   250: dup
    //   251: new 171	java/io/File
    //   254: dup
    //   255: ldc_w 2171
    //   258: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   261: invokestatic 2013	com/chelpus/Utils:read_from_file	(Ljava/io/File;)Ljava/lang/String;
    //   264: invokespecial 2198	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   267: astore_0
    //   268: aload_0
    //   269: ldc_w 2193
    //   272: invokevirtual 2200	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   275: pop
    //   276: iconst_1
    //   277: ireturn
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual 2201	java/lang/NoSuchMethodError:printStackTrace	()V
    //   283: goto -212 -> 71
    //   286: ldc_w 2203
    //   289: invokestatic 654	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   292: ldc_w 2205
    //   295: invokestatic 654	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   298: goto -202 -> 96
    //   301: astore_0
    //   302: aload_0
    //   303: invokevirtual 2206	org/json/JSONException:printStackTrace	()V
    //   306: iconst_0
    //   307: ireturn
    //   308: astore_0
    //   309: aload_0
    //   310: invokevirtual 2201	java/lang/NoSuchMethodError:printStackTrace	()V
    //   313: goto -112 -> 201
    //   316: new 171	java/io/File
    //   319: dup
    //   320: ldc_w 2171
    //   323: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   326: aload_0
    //   327: invokevirtual 2194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   330: invokestatic 2197	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   333: pop
    //   334: new 171	java/io/File
    //   337: dup
    //   338: ldc_w 2171
    //   341: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   344: iconst_1
    //   345: iconst_0
    //   346: invokevirtual 2175	java/io/File:setWritable	(ZZ)Z
    //   349: pop
    //   350: ldc_w 2208
    //   353: invokestatic 654	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   356: goto -130 -> 226
    //   359: astore_0
    //   360: aload_0
    //   361: invokevirtual 2201	java/lang/NoSuchMethodError:printStackTrace	()V
    //   364: goto -14 -> 350
    //   367: getstatic 927	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   370: invokevirtual 932	java/lang/Boolean:booleanValue	()Z
    //   373: ifeq +55 -> 428
    //   376: new 171	java/io/File
    //   379: dup
    //   380: ldc_w 2171
    //   383: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   386: iconst_1
    //   387: iconst_0
    //   388: invokevirtual 2175	java/io/File:setWritable	(ZZ)Z
    //   391: pop
    //   392: iconst_3
    //   393: anewarray 92	java/lang/String
    //   396: dup
    //   397: iconst_0
    //   398: ldc_w 453
    //   401: aastore
    //   402: dup
    //   403: iconst_1
    //   404: ldc_w 591
    //   407: aastore
    //   408: dup
    //   409: iconst_2
    //   410: ldc_w 2171
    //   413: aastore
    //   414: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   417: goto -191 -> 226
    //   420: astore_0
    //   421: aload_0
    //   422: invokevirtual 2201	java/lang/NoSuchMethodError:printStackTrace	()V
    //   425: goto -33 -> 392
    //   428: new 171	java/io/File
    //   431: dup
    //   432: ldc_w 2171
    //   435: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   438: iconst_1
    //   439: iconst_0
    //   440: invokevirtual 2175	java/io/File:setWritable	(ZZ)Z
    //   443: pop
    //   444: ldc_w 2208
    //   447: invokestatic 654	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   450: goto -224 -> 226
    //   453: astore_0
    //   454: aload_0
    //   455: invokevirtual 2201	java/lang/NoSuchMethodError:printStackTrace	()V
    //   458: goto -14 -> 444
    //   461: astore_0
    //   462: getstatic 927	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   465: invokevirtual 932	java/lang/Boolean:booleanValue	()Z
    //   468: ifeq +31 -> 499
    //   471: iconst_3
    //   472: anewarray 92	java/lang/String
    //   475: dup
    //   476: iconst_0
    //   477: ldc_w 453
    //   480: aastore
    //   481: dup
    //   482: iconst_1
    //   483: ldc_w 591
    //   486: aastore
    //   487: dup
    //   488: iconst_2
    //   489: ldc_w 2171
    //   492: aastore
    //   493: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   496: goto -249 -> 247
    //   499: ldc_w 2208
    //   502: invokestatic 654	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   505: goto -258 -> 247
    //   508: astore_0
    //   509: aload_0
    //   510: invokevirtual 2206	org/json/JSONException:printStackTrace	()V
    //   513: new 2177	org/json/JSONObject
    //   516: dup
    //   517: invokespecial 2178	org/json/JSONObject:<init>	()V
    //   520: astore_0
    //   521: aload_0
    //   522: ldc_w 2180
    //   525: iconst_1
    //   526: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   529: pop
    //   530: aload_0
    //   531: ldc_w 2185
    //   534: iconst_1
    //   535: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   538: pop
    //   539: aload_0
    //   540: ldc_w 2187
    //   543: iconst_1
    //   544: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   547: pop
    //   548: aload_0
    //   549: ldc_w 2189
    //   552: iconst_1
    //   553: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   556: pop
    //   557: aload_0
    //   558: ldc_w 2191
    //   561: iconst_0
    //   562: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   565: pop
    //   566: aload_0
    //   567: ldc_w 2193
    //   570: iconst_1
    //   571: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   574: pop
    //   575: getstatic 927	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   578: invokevirtual 932	java/lang/Boolean:booleanValue	()Z
    //   581: ifeq +77 -> 658
    //   584: new 171	java/io/File
    //   587: dup
    //   588: ldc_w 2171
    //   591: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   594: aload_0
    //   595: invokevirtual 2194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   598: invokestatic 2197	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   601: pop
    //   602: iconst_3
    //   603: anewarray 92	java/lang/String
    //   606: dup
    //   607: iconst_0
    //   608: ldc_w 453
    //   611: aastore
    //   612: dup
    //   613: iconst_1
    //   614: ldc_w 591
    //   617: aastore
    //   618: dup
    //   619: iconst_2
    //   620: ldc_w 2171
    //   623: aastore
    //   624: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   627: new 2177	org/json/JSONObject
    //   630: dup
    //   631: new 171	java/io/File
    //   634: dup
    //   635: ldc_w 2171
    //   638: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   641: invokestatic 2013	com/chelpus/Utils:read_from_file	(Ljava/io/File;)Ljava/lang/String;
    //   644: invokespecial 2198	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   647: astore_0
    //   648: goto -380 -> 268
    //   651: astore_0
    //   652: aload_0
    //   653: invokevirtual 2206	org/json/JSONException:printStackTrace	()V
    //   656: iconst_0
    //   657: ireturn
    //   658: new 171	java/io/File
    //   661: dup
    //   662: ldc_w 2171
    //   665: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   668: aload_0
    //   669: invokevirtual 2194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   672: invokestatic 2197	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   675: pop
    //   676: ldc_w 2208
    //   679: invokestatic 654	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   682: goto -55 -> 627
    //   685: astore_0
    //   686: aload_0
    //   687: invokevirtual 2206	org/json/JSONException:printStackTrace	()V
    //   690: iconst_0
    //   691: ireturn
    //   692: astore_0
    //   693: aload_0
    //   694: invokevirtual 2206	org/json/JSONException:printStackTrace	()V
    //   697: iconst_0
    //   698: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   103	166	0	localJSONObject1	JSONObject
    //   278	2	0	localNoSuchMethodError1	NoSuchMethodError
    //   301	2	0	localJSONException1	JSONException
    //   308	19	0	localNoSuchMethodError2	NoSuchMethodError
    //   359	2	0	localNoSuchMethodError3	NoSuchMethodError
    //   420	2	0	localNoSuchMethodError4	NoSuchMethodError
    //   453	2	0	localNoSuchMethodError5	NoSuchMethodError
    //   461	1	0	localJSONException2	JSONException
    //   508	2	0	localJSONException3	JSONException
    //   520	128	0	localJSONObject2	JSONObject
    //   651	18	0	localJSONException4	JSONException
    //   685	2	0	localJSONException5	JSONException
    //   692	2	0	localJSONException6	JSONException
    // Exception table:
    //   from	to	target	type
    //   55	71	278	java/lang/NoSuchMethodError
    //   104	158	301	org/json/JSONException
    //   185	201	308	java/lang/NoSuchMethodError
    //   334	350	359	java/lang/NoSuchMethodError
    //   376	392	420	java/lang/NoSuchMethodError
    //   428	444	453	java/lang/NoSuchMethodError
    //   226	247	461	org/json/JSONException
    //   247	268	508	org/json/JSONException
    //   521	575	651	org/json/JSONException
    //   627	648	685	org/json/JSONException
    //   268	276	692	org/json/JSONException
  }
  
  public static final boolean isAds(String paramString)
  {
    return (paramString.contains(".ads.")) || (paramString.contains("adwhirl")) || (paramString.contains("amobee")) || (paramString.contains("burstly")) || (paramString.contains("com.adknowledge.")) || (paramString.contains("cauly.android.ad.")) || (paramString.contains(".greystripe.")) || (paramString.contains("inmobi.")) || (paramString.contains("inneractive.api.ads.")) || (paramString.contains(".jumptap.adtag.")) || (paramString.contains(".mdotm.android.ads.")) || (paramString.contains("medialets.advertising.")) || (paramString.contains(".millennialmedia.android.")) || (paramString.contains(".mobclix.android.sdk.")) || (paramString.contains(".mobfox.sdk.")) || (paramString.contains(".adserver.adview.")) || (paramString.contains(".mopub.mobileads.")) || (paramString.contains("com.oneriot.")) || (paramString.contains(".papaya.offer.")) || (paramString.contains("pontiflex.mobile.webview.sdk.activities")) || (paramString.contains(".qwapi.adclient.android.view.")) || (paramString.contains(".smaato.SOMA.")) || (paramString.contains(".vdopia.client.android.")) || (paramString.contains(".zestadz.android.")) || (paramString.contains("com.appenda.")) || (paramString.contains("com.airpush.android.")) || (paramString.contains("com.Leadbolt.")) || (paramString.contains("com.moolah.")) || (paramString.contains("com.tapit.adview.notif.")) || (paramString.contains("com.urbanairship.push.")) || (paramString.contains("com.xtify.android.sdk.")) || (paramString.contains("MediaPlayerWrapper")) || (paramString.contains(".vungle.")) || (paramString.contains(".tapjoy.")) || (paramString.contains(".nbpcorp.")) || (paramString.contains("com.appenda.")) || (paramString.contains(".plus1.sdk.")) || (paramString.contains(".adsdk.")) || (paramString.contains(".mdotm.")) || (paramString.contains("AdView")) || (paramString.contains("mad.ad."));
  }
  
  public static boolean isBootOatCache()
  {
    if (new File("/data/dalvik-cache/arm/system@framework@boot.oat").exists()) {}
    while ((new File("/data/dalvik-cache/arm64/system@framework@boot.oat").exists()) || (new File("/data/dalvik-cache/x86/system@framework@boot.oat").exists()) || (new File("/data/dalvik-cache/x86_64/system@framework@boot.oat").exists()) || (new File("/data/dalvik-cache/oat/arm/system@framework@boot.oat").exists()) || (new File("/data/dalvik-cache/oat/arm64/system@framework@boot.oat").exists()) || (new File("/data/dalvik-cache/oat/x86/system@framework@boot.oat").exists()) || (new File("/data/dalvik-cache/oat/x86_64/system@framework@boot.oat").exists())) {
      return true;
    }
    return false;
  }
  
  public static boolean isCustomPatchesForPkg(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((listAppsFragment.customlist == null) || (listAppsFragment.customlist.length == 0)) {
          listAppsFragment.init();
        }
        try
        {
          listAppsFragment.basepath = listAppsFragment.getConfig().getString("basepath", listAppsFragment.basepath);
          listAppsFragment.customlist = new File[new File(listAppsFragment.basepath).listFiles().length];
          listAppsFragment.customlist = new File(listAppsFragment.basepath).listFiles();
          ArrayList localArrayList = new ArrayList();
          localArrayList.clear();
          i = 0;
          if (i < listAppsFragment.customlist.length)
          {
            if ((!listAppsFragment.customlist[i].isFile()) || (!listAppsFragment.customlist[i].getName().endsWith(".txt"))) {
              break label356;
            }
            localArrayList.add(listAppsFragment.customlist[i]);
            break label356;
          }
          if (localArrayList.size() > 0)
          {
            listAppsFragment.customlist = new File[localArrayList.size()];
            listAppsFragment.customlist = (File[])localArrayList.toArray(listAppsFragment.customlist);
          }
        }
        catch (Exception localException)
        {
          System.out.println("Not found dir by Lucky Patcher. Custom patch not found.");
          continue;
        }
        if ((listAppsFragment.customlist == null) || (listAppsFragment.customlist.length <= 0)) {
          break label354;
        }
        i = 0;
        if (i < listAppsFragment.customlist.length)
        {
          if (!listAppsFragment.customlist[i].getName().contains("_%ALL%.txt")) {
            break label320;
          }
          if (!paramString.contains(listAppsFragment.customlist[i].getName().replace("_%ALL%.txt", ""))) {
            break label250;
          }
          return true;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return false;
      label250:
      if ((listAppsFragment.customlist[i].getName().contains("_%ALL%.txt")) && (listAppsFragment.customlist[i].getName().contains("%ALL%_")) && (paramString.contains(((String[])listAppsFragment.customlist[i].getName().split("%ALL%_"))[1].replace("_%ALL%.txt", "")))) {
        return true;
      }
      label320:
      boolean bool = listAppsFragment.customlist[i].getName().replace(".txt", "").endsWith(paramString);
      if (bool) {
        return true;
      }
      i += 1;
      continue;
      label354:
      return false;
      label356:
      i += 1;
    }
  }
  
  public static boolean isELFfiles(File paramFile)
  {
    try
    {
      paramFile = new RandomAccessFile(paramFile, "r").getChannel();
      MappedByteBuffer localMappedByteBuffer = paramFile.map(FileChannel.MapMode.READ_ONLY, 0L, (int)paramFile.size());
      localMappedByteBuffer.position(0);
      if ((localMappedByteBuffer.get() == Byte.MAX_VALUE) && (localMappedByteBuffer.get() == 69) && (localMappedByteBuffer.get() == 76) && (localMappedByteBuffer.get() == 70))
      {
        paramFile.close();
        System.out.println("Check file: is ELF.");
        return true;
      }
      paramFile.close();
    }
    catch (FileNotFoundException paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
      }
    }
    catch (IOException paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
      }
    }
    System.out.println("Check file: is not ELF.");
    return false;
  }
  
  public static boolean isInstalledOnSdCard(String paramString)
  {
    PackageManager localPackageManager;
    if (listAppsFragment.api > 7) {
      localPackageManager = listAppsFragment.getPkgMng();
    }
    for (;;)
    {
      try
      {
        int i = localPackageManager.getPackageInfo(paramString, 0).applicationInfo.flags;
        return (i & 0x40000) == 262144;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      try
      {
        paramString = listAppsFragment.getPkgMng().getPackageInfo(paramString, 0).applicationInfo.sourceDir;
        if (paramString.startsWith("/data/")) {
          return false;
        }
        if (!paramString.contains("/mnt/"))
        {
          boolean bool = paramString.contains("/sdcard/");
          if (bool) {}
        }
      }
      catch (Throwable paramString)
      {
        for (;;) {}
      }
    }
    return false;
  }
  
  public static boolean isMarketIntent(String paramString)
  {
    return (paramString.toLowerCase().equals("com.android.vending.billing.inappbillingservice.bind")) || (paramString.toLowerCase().equals("ir.cafebazaar.pardakht.inappbillingservice.bind")) || (paramString.toLowerCase().equals("com.nokia.payment.iapenabler.inappbillingservice.bind")) || (paramString.toLowerCase().equals("net.jhoobin.jhub.inappbillingservice.bind")) || (paramString.toLowerCase().equals("net.jhoobin.jhub.billing.iinappbillingservice")) || (paramString.toLowerCase().equals(listAppsFragment.class.getPackage().getName().toLowerCase()));
  }
  
  public static boolean isModified(String paramString, Context paramContext)
  {
    paramContext = null;
    try
    {
      byte[] arrayOfByte = listAppsFragment.getPkgMng().getPackageInfo(paramString, 64).signatures[0].toByteArray();
      paramContext = arrayOfByte;
      boolean bool = listAppsFragment.getConfig().getBoolean(paramString, false);
      paramContext = arrayOfByte;
      if (!bool) {
        break label46;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label46:
      do
      {
        paramString.printStackTrace();
      } while (Base64.encode(paramContext).replaceAll("\n", "").equals("MIIEqDCCA5CgAwIBAgIJAJNurL4H8gHfMA0GCSqGSIb3DQEBBQUAMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTAeFw0wODAyMjkwMTMzNDZaFw0zNTA3MTcwMTMzNDZaMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBANaTGQTexgskse3HYuDZ2CU+Ps1s6x3i/waMqOi8qM1r03hupwqnbOYOuw+ZNVn/2T53qUPn6D1LZLjk/qLT5lbx4meoG7+yMLV4wgRDvkxyGLhG9SEVhvA4oU6Jwr44f46+z4/Kw9oe4zDJ6pPQp8PcSvNQIg1QCAcy4ICXF+5qBTNZ5qaU7Cyz8oSgpGbIepTYOzEJOmc3Li9kEsBubULxWBjf/gOBzAzURNps3cO4JFgZSAGzJWQTT7/emMkod0jb9WdqVA2BVMi7yge54kdVMxHEa5r3b97szI5p58ii0I54JiCUP5lyfTwE/nKZHZnfm644oLIXf6MdW2r+6R8CAQOjgfwwgfkwHQYDVR0OBBYEFEhZAFY9JyxGrhGGBaR0GawJyowRMIHJBgNVHSMEgcEwgb6AFEhZAFY9JyxGrhGGBaR0GawJyowRoYGapIGXMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbYIJAJNurL4H8gHfMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADggEBAHqvlozrUMRBBVEY0NqrrwFbinZaJ6cVosK0TyIUFf/azgMJWr+kLfcHCHJsIGnlw27drgQAvilFLAhLwn62oX6snb4YLCBOsVMR9FXYJLZW2+TcIkCRLXWG/oiVHQGo/rWuWkJgU134NDEFJCJGjDbiLCpe+ZTWHdcwauTJ9pUbo8EvHRkU3cYfGmLaLfgn9gP+pWA7LFQNvXwBnDa6sppCccEX31I828XzgXpJ4O+mDL1/dBd+ek8ZPUP0IgdyZm5MTYPhvVqGCHzzTy3sIeJFymwrsBbmg2OAUNLEMO6nwmocSdN2ClirfxqCzJOLSDE4QyS9BAH6EhY6UFcOaE0="));
    }
    return true;
    return false;
  }
  
  public static final boolean isNetworkAvailable()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)listAppsFragment.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
  
  public static boolean isOdex(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      String str = changeExtension(localFile.getName(), "odex");
      if (listAppsFragment.api >= 23)
      {
        if (new File(getDirs(localFile) + "/oat/arm/" + str).exists()) {
          return true;
        }
        if ((!new File(getDirs(localFile) + "/oat/arm64/" + str).exists()) && (!new File(getDirs(localFile) + "/oat/x86/" + str).exists()) && (!new File(getDirs(localFile) + "/oat/x86_64/" + str).exists())) {
          break label423;
        }
      }
      else if ((!new File(changeExtension(paramString, "odex")).exists()) && (!new File(getDirs(localFile) + "/arm/" + changeExtension(localFile.getName(), "odex")).exists()) && (!new File(getDirs(localFile) + "/arm64/" + changeExtension(localFile.getName(), "odex")).exists()) && (!new File(getDirs(localFile) + "/x86/" + changeExtension(localFile.getName(), "odex")).exists()))
      {
        boolean bool = new File(getDirs(localFile) + "/x86_64/" + changeExtension(localFile.getName(), "odex")).exists();
        if (!bool) {
          break label423;
        }
        return true;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      break label423;
      return true;
    }
    label423:
    return false;
  }
  
  public static boolean isRebuildedOrOdex(String paramString, Context paramContext)
  {
    boolean bool2 = true;
    Object localObject = null;
    paramContext = (Context)localObject;
    boolean bool1;
    try
    {
      PackageInfo localPackageInfo = listAppsFragment.getPkgMng().getPackageInfo(paramString, 64);
      paramContext = (Context)localObject;
      try
      {
        byte[] arrayOfByte = localPackageInfo.signatures[0].toByteArray();
        localObject = arrayOfByte;
        paramContext = (Context)localObject;
        if (isOdex(localPackageInfo.applicationInfo.sourceDir)) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        paramContext = (Context)localObject;
        paramString.printStackTrace();
        return false;
      }
      paramContext = (Context)localObject;
      boolean bool3 = listAppsFragment.getConfig().getBoolean(paramString, false);
      bool1 = bool2;
      if (bool3) {
        return bool1;
      }
      paramContext = (Context)localObject;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      bool1 = bool2;
      if (Base64.encode(paramContext).replaceAll("\n", "").equals("MIIEqDCCA5CgAwIBAgIJAJNurL4H8gHfMA0GCSqGSIb3DQEBBQUAMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTAeFw0wODAyMjkwMTMzNDZaFw0zNTA3MTcwMTMzNDZaMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBANaTGQTexgskse3HYuDZ2CU+Ps1s6x3i/waMqOi8qM1r03hupwqnbOYOuw+ZNVn/2T53qUPn6D1LZLjk/qLT5lbx4meoG7+yMLV4wgRDvkxyGLhG9SEVhvA4oU6Jwr44f46+z4/Kw9oe4zDJ6pPQp8PcSvNQIg1QCAcy4ICXF+5qBTNZ5qaU7Cyz8oSgpGbIepTYOzEJOmc3Li9kEsBubULxWBjf/gOBzAzURNps3cO4JFgZSAGzJWQTT7/emMkod0jb9WdqVA2BVMi7yge54kdVMxHEa5r3b97szI5p58ii0I54JiCUP5lyfTwE/nKZHZnfm644oLIXf6MdW2r+6R8CAQOjgfwwgfkwHQYDVR0OBBYEFEhZAFY9JyxGrhGGBaR0GawJyowRMIHJBgNVHSMEgcEwgb6AFEhZAFY9JyxGrhGGBaR0GawJyowRoYGapIGXMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbYIJAJNurL4H8gHfMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADggEBAHqvlozrUMRBBVEY0NqrrwFbinZaJ6cVosK0TyIUFf/azgMJWr+kLfcHCHJsIGnlw27drgQAvilFLAhLwn62oX6snb4YLCBOsVMR9FXYJLZW2+TcIkCRLXWG/oiVHQGo/rWuWkJgU134NDEFJCJGjDbiLCpe+ZTWHdcwauTJ9pUbo8EvHRkU3cYfGmLaLfgn9gP+pWA7LFQNvXwBnDa6sppCccEX31I828XzgXpJ4O+mDL1/dBd+ek8ZPUP0IgdyZm5MTYPhvVqGCHzzTy3sIeJFymwrsBbmg2OAUNLEMO6nwmocSdN2ClirfxqCzJOLSDE4QyS9BAH6EhY6UFcOaE0=")) {
        return bool1;
      }
      bool1 = false;
    }
    if (paramContext == null) {
      return false;
    }
    return bool1;
  }
  
  public static boolean isServiceRunning(String paramString)
  {
    Iterator localIterator = ((ActivityManager)listAppsFragment.getInstance().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
    while (localIterator.hasNext()) {
      if (((ActivityManager.RunningServiceInfo)localIterator.next()).service.getClassName().equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isServicesCache()
  {
    if (new File("/data/dalvik-cache/arm/system@framework@services.jar@classes.dex").exists()) {}
    while ((new File("/data/dalvik-cache/arm64/system@framework@services.jar@classes.dex").exists()) || (new File("/data/dalvik-cache/x86/system@framework@services.jar@classes.dex").exists()) || (new File("/data/dalvik-cache/x86_64/system@framework@services.jar@classes.dex").exists()) || (new File("/data/dalvik-cache/oat/arm/system@framework@services.jar@classes.dex").exists()) || (new File("/data/dalvik-cache/oat/arm64/system@framework@services.jar@classes.dex").exists()) || (new File("/data/dalvik-cache/oat/x86/system@framework@services.jar@classes.dex").exists()) || (new File("/data/dalvik-cache/oat/x86_64/system@framework@services.jar@classes.dex").exists())) {
      return true;
    }
    return false;
  }
  
  public static boolean isWithFramework()
  {
    if (listAppsFragment.api >= 23) {}
    String str;
    do
    {
      return false;
      str = new Utils("").cmdRoot(new String[] { listAppsFragment.dalvikruncommandWithFramework + ".checkWithFramework 123" });
      listAppsFragment.startUnderRoot = Boolean.valueOf(false);
    } while ((str.contains("withoutFramework")) || (listAppsFragment.errorOutput.contains("java.lang.ClassNotFoundException:")));
    System.out.println("WithFramework support");
    return true;
  }
  
  public static boolean isXposedEnabled()
  {
    return false;
  }
  
  public static long javaToDosTime(long paramLong)
  {
    Date localDate = new Date(paramLong);
    int i = localDate.getYear() + 1900;
    if (i < 1980) {
      return 2162688L;
    }
    return i - 1980 << 25 | localDate.getMonth() + 1 << 21 | localDate.getDate() << 16 | localDate.getHours() << 11 | localDate.getMinutes() << 5 | localDate.getSeconds() >> 1;
  }
  
  public static void kill(String paramString)
  {
    if (!listAppsFragment.startUnderRoot.booleanValue())
    {
      killAll(paramString);
      return;
    }
    killAll(paramString);
  }
  
  public static boolean killAll(String paramString)
  {
    int j;
    int i;
    if (!listAppsFragment.startUnderRoot.booleanValue())
    {
      Object localObject1 = new Utils("").cmdRoot(new String[] { listAppsFragment.toolfilesdir + "/busybox ps |grep '" + paramString + "'" });
      localObject3 = localObject1;
      if (((String)localObject1).startsWith("~")) {
        exitRoot();
      }
      try
      {
        listAppsFragment.getSu();
        localObject3 = new Utils("").cmdRoot(new String[] { listAppsFragment.toolfilesdir + "/busybox ps" });
        localObject1 = localObject3;
        if (((String)localObject3).startsWith("~")) {
          localObject1 = new Utils("").cmdRoot(new String[] { "busybox ps" });
        }
        localObject3 = localObject1;
        if (((String)localObject1).startsWith("~")) {
          localObject3 = new Utils("").cmdRoot(new String[] { "ps" });
        }
        if ((!((String)localObject3).equals("~")) && (!((String)localObject3).equals("")))
        {
          localObject1 = ((String)localObject3).split("\n");
          localObject3 = new ArrayList();
          if (localObject1.length > 1)
          {
            j = localObject1.length;
            i = 0;
            if (i < j)
            {
              localObject4 = localObject1[i];
              if ((((String)localObject4).contains(paramString)) && (!((String)localObject4).contains(paramString + ".")))
              {
                localObject4 = ((String)localObject4 + "\n").trim().split("\\s+");
                localObject4 = localObject4[0];
              }
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        try
        {
          for (;;)
          {
            Object localObject4;
            ((ArrayList)localObject3).add(localObject4);
            System.out.println("Found pid: " + (String)localObject4 + " for " + paramString);
            i += 1;
          }
          localIOException = localIOException;
          localIOException.printStackTrace();
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            System.out.println("Error with regex! " + localException1);
          }
        }
        if (((ArrayList)localObject3).size() > 0)
        {
          localObject2 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            System.out.println("Kill: " + (String)localObject3 + " for " + paramString);
            if (!((String)localObject3).equals("0")) {
              new Utils("").cmdRoot(new String[] { "kill -9 " + (String)localObject3 });
            }
          }
          return true;
        }
      }
      return false;
    }
    Object localObject3 = cmdParam(new String[] { listAppsFragment.toolfilesdir + "/busybox", "ps", "grep", paramString });
    Object localObject2 = localObject3;
    if (((String)localObject3).startsWith("~"))
    {
      localObject2 = localObject3;
      if (((String)localObject3).startsWith("~")) {
        localObject2 = cmdParam(new String[] { listAppsFragment.toolfilesdir + "/busybox", "ps" });
      }
      localObject3 = localObject2;
      if (((String)localObject2).startsWith("~")) {
        localObject3 = cmdParam(new String[] { "busybox", "ps" });
      }
      localObject2 = localObject3;
      if (((String)localObject3).startsWith("~")) {
        localObject2 = cmdParam(new String[] { "toolbox", "ps" });
      }
    }
    if ((!((String)localObject2).equals("~")) && (!((String)localObject2).equals("")))
    {
      localObject2 = ((String)localObject2).split("\n");
      localObject3 = new ArrayList();
      if (localObject2.length > 1)
      {
        j = localObject2.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            Object localObject5 = localObject2[i];
            if ((((String)localObject5).contains(paramString)) && (!((String)localObject5).contains(paramString + ".")))
            {
              localObject5 = ((String)localObject5 + "\n").trim().split("\\s+");
              localObject5 = localObject5[0];
            }
            try
            {
              ((ArrayList)localObject3).add(localObject5);
              System.out.println("Found pid: " + (String)localObject5 + " for " + paramString);
              i += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                System.out.println("Error with regex! " + localException2);
              }
            }
          }
        }
        if (((ArrayList)localObject3).size() > 0)
        {
          localObject2 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            System.out.println("Kill: " + (String)localObject3 + " for " + paramString);
            if (!((String)localObject3).equals("0")) {
              cmdParam(new String[] { "kill", "-9", localObject3 });
            }
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public static void market_billing_services(boolean paramBoolean)
  {
    if (listAppsFragment.su) {
      new Thread(new Runnable()
      {
        public void run()
        {
          new ArrayList();
          PackageInfo localPackageInfo = Utils.getPkgInfo("com.android.vending", 4);
          int i;
          if ((localPackageInfo != null) && (localPackageInfo.services != null) && (localPackageInfo.services.length != 0)) {
            i = 0;
          }
          for (;;)
          {
            if (i < localPackageInfo.services.length) {
              try
              {
                if (!this.val$enable)
                {
                  if (((localPackageInfo.services[i].name.endsWith("InAppBillingService")) || (localPackageInfo.services[i].name.endsWith("MarketBillingService"))) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", localPackageInfo.services[i].name)) != 2)) {
                    new Utils("").cmdRoot(new String[] { "pm disable 'com.android.vending/" + localPackageInfo.services[i].name + "'", "skipOut" });
                  }
                }
                else if (((localPackageInfo.services[i].name.endsWith("InAppBillingService")) || (localPackageInfo.services[i].name.endsWith("MarketBillingService"))) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", localPackageInfo.services[i].name)) != 1)) {
                  new Utils("").cmdRoot(new String[] { "pm enable 'com.android.vending/" + localPackageInfo.services[i].name + "'", "skipOut" });
                }
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
            return;
            i += 1;
          }
        }
      }).start();
    }
  }
  
  public static void market_billing_services_to_main_stream(boolean paramBoolean)
  {
    Object localObject;
    if (listAppsFragment.su)
    {
      new ArrayList();
      localObject = null;
      try
      {
        PackageInfo localPackageInfo = listAppsFragment.getPkgMng().getPackageInfo("com.android.vending", 4);
        localObject = localPackageInfo;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          int i;
          localNameNotFoundException.printStackTrace();
          continue;
          if (((localObject.services[i].name.endsWith("InAppBillingService")) || (localObject.services[i].name.endsWith("MarketBillingService"))) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", localObject.services[i].name)) != 1)) {
            new Utils("").cmdRoot(new String[] { "pm enable 'com.android.vending/" + localObject.services[i].name + "'", "skipOut" });
          }
        }
      }
      if ((localObject != null) && (((PackageInfo)localObject).services != null) && (((PackageInfo)localObject).services.length != 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((PackageInfo)localObject).services.length) {
            return;
          }
          if (paramBoolean) {
            break;
          }
          try
          {
            if (((localObject.services[i].name.endsWith("InAppBillingService")) || (localObject.services[i].name.endsWith("MarketBillingService"))) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", localObject.services[i].name)) != 2)) {
              new Utils("").cmdRoot(new String[] { "pm disable 'com.android.vending/" + localObject.services[i].name + "'", "skipOut" });
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public static void market_licensing_services(boolean paramBoolean)
  {
    if (listAppsFragment.su) {
      new Thread(new Runnable()
      {
        public void run()
        {
          new ArrayList();
          PackageInfo localPackageInfo = Utils.getPkgInfo("com.android.vending", 4);
          int i;
          if ((localPackageInfo != null) && (localPackageInfo.services != null) && (localPackageInfo.services.length != 0)) {
            i = 0;
          }
          for (;;)
          {
            if (i < localPackageInfo.services.length) {
              try
              {
                if (!this.val$enable)
                {
                  if ((localPackageInfo.services[i].name.endsWith("LicensingService")) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", localPackageInfo.services[i].name)) != 2)) {
                    new Utils("").cmdRoot(new String[] { "pm disable 'com.android.vending/" + localPackageInfo.services[i].name + "'", "skipOut" });
                  }
                }
                else if ((localPackageInfo.services[i].name.endsWith("LicensingService")) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", localPackageInfo.services[i].name)) != 1)) {
                  new Utils("").cmdRoot(new String[] { "pm enable 'com.android.vending/" + localPackageInfo.services[i].name + "'", "skipOut" });
                }
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
            return;
            i += 1;
          }
        }
      }).start();
    }
  }
  
  public static void market_licensing_services_to_main_stream(boolean paramBoolean)
  {
    PackageInfo localPackageInfo;
    int i;
    if (listAppsFragment.su)
    {
      new ArrayList();
      localPackageInfo = getPkgInfo("com.android.vending", 4);
      if ((localPackageInfo != null) && (localPackageInfo.services != null) && (localPackageInfo.services.length != 0)) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < localPackageInfo.services.length)
      {
        if (!paramBoolean) {}
        try
        {
          if ((!localPackageInfo.services[i].name.endsWith("LicensingService")) || (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", localPackageInfo.services[i].name)) == 2)) {
            break label285;
          }
          new Utils("").cmdRoot(new String[] { "pm disable 'com.android.vending/" + localPackageInfo.services[i].name + "'", "skipOut" });
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if ((localPackageInfo.services[i].name.endsWith("LicensingService")) && (listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", localPackageInfo.services[i].name)) != 1)) {
          new Utils("").cmdRoot(new String[] { "pm enable 'com.android.vending/" + localPackageInfo.services[i].name + "'", "skipOut" });
        }
      }
      else
      {
        return;
      }
      label285:
      i += 1;
    }
  }
  
  public static boolean onMainThread()
  {
    return (Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper());
  }
  
  public static boolean pattern_checker(Activity paramActivity)
  {
    boolean bool = false;
    localObject = paramActivity.getApplicationInfo().sourceDir;
    System.out.println((String)localObject);
    localObject = null;
    try
    {
      paramActivity = paramActivity.getPackageManager().getPackageInfo(paramActivity.getPackageName(), 64).signatures[0].toByteArray();
      localObject = paramActivity;
      System.out.println();
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
        paramActivity = (Activity)localObject;
      }
    }
    if (Base64.encode(paramActivity).replaceAll("\n", "").equals("MIIDDTCCAfWgAwIBAgIEeR8eUDANBgkqhkiG9w0BAQsFADA3MQswCQYDVQQGEwJVUzEQMA4GA1UEChMHQW5kcm9pZDEWMBQGA1UEAxMNQW5kcm9pZCBEZWJ1ZzAeFw0xMTEyMDgwNjA1MTBaFw00MTExMzAwNjA1MTBaMDcxCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdBbmRyb2lkMRYwFAYDVQQDEw1BbmRyb2lkIERlYnVnMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhENqFp22Dq9M/CEU4on3/xGfoWggUk4tahTdC/okxdVO/nB27odddvB+zDiMSq+mGFprWxk31pzu+W31pbdq4tnBF6aqzhLanAjxVoeuqNUDzXfqNhxjQDJjZ9Q9zntEHNllIkfJclYyADf1GHjQs9vpgo58EXQ4Wt8REG9P+8My5ENmVkfTA3L7yryyTnplRn7d+jVtIcJEKY0s/kCFfRMNJnM2vYYWGpXrmEJFMNPtjvPGvnNgMojHLgWqY7z7foplBjGfEItX/huYZqp7+ZaGWyrksXHStEUXUa7TJJiW++R4e4VL6jIDwTHGOAgYaVA/ZarfLquQhXP28vBNhwIDAQABoyEwHzAdBgNVHQ4EFgQUNrZ//EPQx9WdAor2L5dvsy6i9eYwDQYJKoZIhvcNAQELBQADggEBAH09ZytGQmSrbGNjbCMnuZ+UuKOP+nN5j0U0hbMisC+2rcox36S23hVDPEc7rcBMo/Aep4kY/CZCO9UnRVP5NG3YugQU2mwimM2po4pZZbOBCDx4dEjA4ymJpKlS4fEPQ1qp5p9um8wmMVg5Yl5y9dGpxNF/USDW5jq+H8SBhfcrro+m4V+G/jPGWSN/0QwJpb0dmsD2MLgw7/HyJPnymvSEzom6e7Oe4aJDzOKuRM5hrfvsNyH+WTq+f+IElEVMg1zwo0JHhFTppxEFROPHTYO2FjMdrA26KdPcLTS07pzpP00/0n+4R7SPoAHzMBptlvNZws9KvaQEiOc0ObXhjL0=")) {
      bool = true;
    }
    return bool;
  }
  
  public static String readLine(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i < 0) {
        return null;
      }
      if (i == 10) {
        return new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
      }
      localByteArrayOutputStream.write(i);
    }
  }
  
  public static JSONObject readXposedParamBoolean()
    throws JSONException
  {
    return new JSONObject(read_from_file(new File("/data/lp/xposed")));
  }
  
  /* Error */
  public static String read_from_file(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 311	java/io/File:length	()J
    //   4: l2i
    //   5: newarray <illegal type>
    //   7: astore_1
    //   8: new 483	java/io/RandomAccessFile
    //   11: dup
    //   12: aload_0
    //   13: ldc_w 1844
    //   16: invokespecial 488	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: lconst_0
    //   22: invokevirtual 2538	java/io/RandomAccessFile:seek	(J)V
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 2539	java/io/RandomAccessFile:read	([B)I
    //   30: pop
    //   31: aload_0
    //   32: invokevirtual 2540	java/io/RandomAccessFile:close	()V
    //   35: new 92	java/lang/String
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 610	java/lang/String:<init>	([B)V
    //   43: areturn
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   49: goto -14 -> 35
    //   52: astore_0
    //   53: goto -8 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramFile	File
    //   7	33	1	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	20	44	java/lang/Exception
    //   20	35	52	java/lang/Exception
  }
  
  public static void reboot()
  {
    if (!listAppsFragment.startUnderRoot.booleanValue()) {
      try
      {
        new Utils("").cmdRoot(new String[] { "reboot" });
      }
      catch (Exception localException6)
      {
        try
        {
          new Utils("").cmdRoot(new String[] { "/system/bin/reboot" });
        }
        catch (Exception localException6)
        {
          try
          {
            new Utils("").cmdRoot(new String[] { "/system/xbin/reboot" });
          }
          catch (Exception localException6)
          {
            try
            {
              new Utils("").cmdRoot(new String[] { "busybox reboot" });
            }
            catch (Exception localException6)
            {
              try
              {
                cmd(new String[] { "reboot" });
              }
              catch (Exception localException6)
              {
                try
                {
                  run_all("reboot");
                }
                catch (Exception localException6)
                {
                  try
                  {
                    for (;;)
                    {
                      listAppsFragment.patchAct.runOnUiThread(new Runnable()
                      {
                        public void run()
                        {
                          Toast.makeText(listAppsFragment.getInstance(), Utils.getText(2131165631), 1).show();
                        }
                      });
                      new Utils("w").waitLP(5000L);
                      try
                      {
                        run_all(listAppsFragment.getInstance().getFilesDir() + "/reboot");
                        return;
                      }
                      catch (Exception localException8)
                      {
                        localException8.printStackTrace();
                        return;
                      }
                      localException1 = localException1;
                      localException1.printStackTrace();
                      continue;
                      localException2 = localException2;
                      localException2.printStackTrace();
                      continue;
                      localException3 = localException3;
                      localException3.printStackTrace();
                      continue;
                      localException4 = localException4;
                      localException4.printStackTrace();
                      continue;
                      localException5 = localException5;
                      localException5.printStackTrace();
                      continue;
                      localException6 = localException6;
                      localException6.printStackTrace();
                    }
                  }
                  catch (Exception localException7)
                  {
                    for (;;)
                    {
                      localException7.printStackTrace();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      cmdParam(new String[] { "reboot" });
    }
    catch (Exception localException14)
    {
      try
      {
        cmdParam(new String[] { "/system/bin/reboot" });
      }
      catch (Exception localException14)
      {
        try
        {
          cmdParam(new String[] { "/system/xbin/reboot" });
        }
        catch (Exception localException14)
        {
          try
          {
            cmdParam(new String[] { "busybox reboot" });
          }
          catch (Exception localException14)
          {
            try
            {
              cmd(new String[] { "reboot" });
            }
            catch (Exception localException14)
            {
              try
              {
                for (;;)
                {
                  run_all_no_root(new String[] { "reboot" });
                  try
                  {
                    run_all_no_root(new String[] { listAppsFragment.toolfilesdir + "/reboot" });
                    return;
                  }
                  catch (Exception localException9)
                  {
                    localException9.printStackTrace();
                    return;
                  }
                  localException10 = localException10;
                  localException10.printStackTrace();
                  continue;
                  localException11 = localException11;
                  localException11.printStackTrace();
                  continue;
                  localException12 = localException12;
                  localException12.printStackTrace();
                  continue;
                  localException13 = localException13;
                  localException13.printStackTrace();
                  continue;
                  localException14 = localException14;
                  localException14.printStackTrace();
                }
              }
              catch (Exception localException15)
              {
                for (;;)
                {
                  localException15.printStackTrace();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean remount(String paramString1, String paramString2)
  {
    String str;
    Mount localMount;
    if (!listAppsFragment.startUnderRoot.booleanValue())
    {
      if (paramString1.toLowerCase().startsWith("/system"))
      {
        new Utils("").cmdRoot(new String[] { "stop ric" });
        if ((exists("/sbin/ric")) || (exists("/system/bin/ric")))
        {
          new Utils("").cmdRoot(new String[] { "stop ric" });
          run_all("pkill -f /sbin/ric");
          run_all("pkill -f /system/bin/ric");
        }
      }
      str = paramString1;
      if (paramString1.endsWith("/"))
      {
        str = paramString1;
        if (!paramString1.equals("/")) {
          str = paramString1.substring(0, paramString1.lastIndexOf("/"));
        }
      }
      localMount = findMountPointRecursive(str);
      if (localMount != null)
      {
        paramString1 = localMount;
        if (localMount.getFlags().contains(paramString2.toLowerCase(Locale.US))) {}
      }
    }
    try
    {
      System.out.println("Run command remount:mount -o remount," + paramString2.toLowerCase(Locale.US) + " " + localMount.getDevice().getAbsolutePath() + " " + localMount.getMountPoint().getAbsolutePath());
      run_all("blockdev --setrw " + localMount.getDevice().getAbsolutePath());
      run_all("mount -o remount," + paramString2.toLowerCase(Locale.US) + " " + localMount.getDevice().getAbsolutePath() + " " + localMount.getMountPoint().getAbsolutePath());
      paramString1 = findMountPointRecursive(str);
      if (!paramString1.getFlags().contains(paramString2.toLowerCase(Locale.US))) {
        run_all("mount -o remount " + paramString2.toLowerCase(Locale.US) + " " + paramString1.getDevice().getAbsolutePath() + " " + paramString1.getMountPoint().getAbsolutePath());
      }
      paramString1 = findMountPointRecursive(str);
      if (paramString1 != null)
      {
        System.out.println(paramString1.getFlags() + " AND " + paramString2.toLowerCase(Locale.US));
        if (paramString1.getFlags().toString().contains(paramString2.toLowerCase(Locale.US)))
        {
          System.out.println("Lucky Patcher: remount " + str + " to " + paramString2);
          return true;
        }
      }
      System.out.println("LuckyPatcher:not remount " + str + " to " + paramString2);
      return false;
      if (paramString1.toLowerCase().startsWith("/system"))
      {
        cmdParam(new String[] { "stop", "ric" });
        if ((new File("/sbin/ric").exists()) || (new File("/system/bin/ric").exists()))
        {
          cmdParam(new String[] { "stop", "ric" });
          run_all_no_root(new String[] { "pkill", "-f", "/sbin/ric" });
          run_all_no_root(new String[] { "pkill", "-f", "/system/bin/ric" });
        }
      }
      str = paramString1;
      if (paramString1.endsWith("/"))
      {
        str = paramString1;
        if (!paramString1.equals("/")) {
          str = paramString1.substring(0, paramString1.lastIndexOf("/"));
        }
      }
      localMount = findMountPointRecursive(str);
      if (localMount != null)
      {
        paramString1 = localMount;
        if (localMount.getFlags().contains(paramString2.toLowerCase(Locale.US))) {}
      }
      try
      {
        System.out.println("Run command remount:mount -o remount," + paramString2.toLowerCase(Locale.US) + " " + localMount.getDevice().getAbsolutePath() + " " + localMount.getMountPoint().getAbsolutePath());
        run_all_no_root(new String[] { "blockdev", "--setrw", localMount.getDevice().getAbsolutePath() });
        run_all_no_root(new String[] { "mount", "-o", "remount," + paramString2.toLowerCase(Locale.US), localMount.getDevice().getAbsolutePath(), localMount.getMountPoint().getAbsolutePath() });
        paramString1 = findMountPointRecursive(str);
        if (!paramString1.getFlags().contains(paramString2.toLowerCase(Locale.US))) {
          run_all_no_root(new String[] { "mount", "-o", "remount", paramString2.toLowerCase(Locale.US), paramString1.getDevice().getAbsolutePath(), paramString1.getMountPoint().getAbsolutePath() });
        }
        paramString1 = findMountPointRecursive(str);
        if (paramString1 != null)
        {
          System.out.println(paramString1.getFlags() + " AND " + paramString2.toLowerCase(Locale.US));
          if (paramString1.getFlags().toString().contains(paramString2.toLowerCase(Locale.US)))
          {
            System.out.println("Lucky Patcher: remount " + str + " to " + paramString2);
            return true;
          }
        }
        System.out.println("LuckyPatcher:not remount " + str + " to " + paramString2);
        return false;
      }
      catch (Exception paramString1)
      {
        for (;;) {}
      }
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
  }
  
  public static String removeExtension(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString != null)
    {
      String[] arrayOfString = paramString.split("\\.");
      int i = 0;
      paramString = str2;
      for (;;)
      {
        str1 = paramString;
        if (i >= arrayOfString.length) {
          return str1;
        }
        if (i >= arrayOfString.length - 2) {
          break;
        }
        paramString = paramString + arrayOfString[i] + ".";
        i += 1;
      }
      str1 = paramString + arrayOfString[i];
    }
    return str1;
  }
  
  public static void removePkgFromSystem(String paramString)
  {
    remount("/system", "rw");
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new File("/system/app"));
    ((ArrayList)localObject1).add(new File("/system/priv-app"));
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      File localFile1 = (File)((Iterator)localObject1).next();
      File[] arrayOfFile1 = localFile1.listFiles();
      if ((arrayOfFile1 != null) && (arrayOfFile1.length != 0))
      {
        int j = arrayOfFile1.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            localFile1 = arrayOfFile1[i];
            if (localFile1.getAbsolutePath().endsWith(".apk")) {}
            try
            {
              if (paramString.equals(new FileApkListItem(listAppsFragment.getInstance(), localFile1, false).pkgName))
              {
                run_all("chmod 777 '" + localFile1.getAbsolutePath() + "'");
                run_all("rm '" + localFile1.getAbsolutePath() + "'");
                run_all("rm '" + getPlaceForOdex(localFile1.getAbsolutePath(), false) + "'");
              }
              i += 1;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                localException1.printStackTrace();
              }
            }
          }
        }
        int k = arrayOfFile1.length;
        i = 0;
        while (i < k)
        {
          Object localObject2 = arrayOfFile1[i];
          if (((File)localObject2).isDirectory()) {
            try
            {
              File[] arrayOfFile2 = ((File)localObject2).listFiles();
              if ((arrayOfFile2 != null) && (arrayOfFile2.length != 0))
              {
                int m = arrayOfFile2.length;
                j = 0;
                for (;;)
                {
                  if (j < m)
                  {
                    File localFile2 = arrayOfFile2[j];
                    boolean bool = localFile2.getAbsolutePath().endsWith(".apk");
                    if (bool) {}
                    try
                    {
                      if (paramString.equals(new FileApkListItem(listAppsFragment.getInstance(), localFile2, false).pkgName))
                      {
                        run_all("chmod 777 '" + localFile2.getAbsolutePath() + "'");
                        run_all("rm '" + localFile2.getAbsolutePath() + "'");
                        run_all("rm '" + getPlaceForOdex(localFile2.getAbsolutePath(), false) + "'");
                        run_all("rm -rf '" + ((File)localObject2).getAbsolutePath() + "'");
                      }
                      j += 1;
                    }
                    catch (Exception localException3)
                    {
                      for (;;)
                      {
                        localException3.printStackTrace();
                      }
                    }
                  }
                }
              }
              i += 1;
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
          }
        }
      }
      else
      {
        System.out.println("LuckyPatcher: 0 packages found in " + localException2.getAbsolutePath());
      }
    }
  }
  
  /* Error */
  public static int replaceStringIds(String paramString, String[] paramArrayOfString1, boolean paramBoolean, String[] paramArrayOfString2)
  {
    // Byte code:
    //   0: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   3: new 208	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 589
    //   13: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   26: iconst_0
    //   27: istore 10
    //   29: iconst_0
    //   30: istore 8
    //   32: iconst_0
    //   33: istore 11
    //   35: iconst_0
    //   36: istore 12
    //   38: iconst_0
    //   39: istore 6
    //   41: iconst_0
    //   42: istore 9
    //   44: iconst_0
    //   45: istore 7
    //   47: iconst_3
    //   48: anewarray 92	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: ldc_w 453
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: ldc_w 591
    //   62: aastore
    //   63: dup
    //   64: iconst_2
    //   65: aload_0
    //   66: aastore
    //   67: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   70: new 290	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 592	java/util/ArrayList:<init>	()V
    //   77: pop
    //   78: iload_2
    //   79: ifne +621 -> 700
    //   82: iload 10
    //   84: istore 4
    //   86: aload_0
    //   87: ifnull +575 -> 662
    //   90: iload 10
    //   92: istore 4
    //   94: iload 12
    //   96: istore 5
    //   98: new 171	java/io/File
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: invokevirtual 175	java/io/File:exists	()Z
    //   109: ifeq +553 -> 662
    //   112: iload 12
    //   114: istore 5
    //   116: new 171	java/io/File
    //   119: dup
    //   120: aload_0
    //   121: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: invokevirtual 311	java/io/File:length	()J
    //   127: lstore 13
    //   129: iload 10
    //   131: istore 4
    //   133: lload 13
    //   135: lconst_0
    //   136: lcmp
    //   137: ifeq +525 -> 662
    //   140: iload 11
    //   142: istore 6
    //   144: new 171	java/io/File
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: invokevirtual 175	java/io/File:exists	()Z
    //   155: istore_2
    //   156: iload 10
    //   158: istore 4
    //   160: iload_2
    //   161: ifeq +501 -> 662
    //   164: iload 8
    //   166: istore 4
    //   168: new 483	java/io/RandomAccessFile
    //   171: dup
    //   172: aload_0
    //   173: ldc_w 485
    //   176: invokespecial 595	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: invokevirtual 492	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   182: astore_0
    //   183: iload 8
    //   185: istore 4
    //   187: aload_0
    //   188: getstatic 498	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   191: lconst_0
    //   192: aload_0
    //   193: invokevirtual 502	java/nio/channels/FileChannel:size	()J
    //   196: l2i
    //   197: i2l
    //   198: invokevirtual 506	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   201: astore 15
    //   203: iload 8
    //   205: istore 4
    //   207: aload 15
    //   209: bipush 56
    //   211: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   214: pop
    //   215: iload 8
    //   217: istore 4
    //   219: aload 15
    //   221: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   224: aload 15
    //   226: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   229: aload 15
    //   231: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   234: aload 15
    //   236: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   239: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   242: istore 6
    //   244: iload 8
    //   246: istore 4
    //   248: aload 15
    //   250: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   253: aload 15
    //   255: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   258: aload 15
    //   260: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   263: aload 15
    //   265: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   268: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   271: istore 5
    //   273: iload 8
    //   275: istore 4
    //   277: iload 6
    //   279: iconst_4
    //   280: idiv
    //   281: newarray <illegal type>
    //   283: astore 16
    //   285: iload 8
    //   287: istore 4
    //   289: aload 15
    //   291: iload 5
    //   293: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   296: pop
    //   297: iload 8
    //   299: istore 4
    //   301: iload 6
    //   303: newarray <illegal type>
    //   305: astore 16
    //   307: iconst_0
    //   308: istore 5
    //   310: iload 5
    //   312: iload 6
    //   314: if_icmpge +44 -> 358
    //   317: iload 8
    //   319: istore 4
    //   321: aload 16
    //   323: iload 5
    //   325: aload 15
    //   327: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   330: aload 15
    //   332: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   335: aload 15
    //   337: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   340: aload 15
    //   342: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   345: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   348: iastore
    //   349: iload 5
    //   351: iconst_1
    //   352: iadd
    //   353: istore 5
    //   355: goto -45 -> 310
    //   358: iload 8
    //   360: istore 4
    //   362: aload 16
    //   364: arraylength
    //   365: istore 9
    //   367: iconst_0
    //   368: istore 6
    //   370: iload 7
    //   372: istore 5
    //   374: iload 6
    //   376: iload 9
    //   378: if_icmpge +272 -> 650
    //   381: aload 16
    //   383: iload 6
    //   385: iaload
    //   386: istore 10
    //   388: iload 5
    //   390: istore 4
    //   392: aload 15
    //   394: iload 10
    //   396: invokevirtual 602	java/nio/MappedByteBuffer:get	(I)B
    //   399: invokestatic 606	com/chelpus/Utils:convertByteToInt	(B)I
    //   402: istore 11
    //   404: iload 5
    //   406: istore 4
    //   408: iload 11
    //   410: newarray <illegal type>
    //   412: astore 17
    //   414: iload 10
    //   416: iconst_1
    //   417: iadd
    //   418: istore 12
    //   420: iload 5
    //   422: istore 4
    //   424: aload 15
    //   426: iload 12
    //   428: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   431: pop
    //   432: iconst_0
    //   433: istore 7
    //   435: iload 5
    //   437: istore 4
    //   439: iload 7
    //   441: aload 17
    //   443: arraylength
    //   444: if_icmpge +865 -> 1309
    //   447: iload 5
    //   449: istore 4
    //   451: aload 17
    //   453: iload 7
    //   455: aload 15
    //   457: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   460: bastore
    //   461: iload 7
    //   463: iconst_1
    //   464: iadd
    //   465: istore 7
    //   467: goto -32 -> 435
    //   470: iload 5
    //   472: istore 4
    //   474: iload 7
    //   476: aload_1
    //   477: arraylength
    //   478: if_icmpge +850 -> 1328
    //   481: iload 5
    //   483: istore 4
    //   485: iload 5
    //   487: istore 8
    //   489: new 92	java/lang/String
    //   492: dup
    //   493: aload 17
    //   495: invokespecial 610	java/lang/String:<init>	([B)V
    //   498: aload_1
    //   499: iload 7
    //   501: aaload
    //   502: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   505: ifeq +810 -> 1315
    //   508: iload 5
    //   510: istore 4
    //   512: aload_3
    //   513: iload 7
    //   515: aaload
    //   516: invokevirtual 613	java/lang/String:getBytes	()[B
    //   519: astore 18
    //   521: iload 5
    //   523: istore 4
    //   525: iload 5
    //   527: istore 8
    //   529: aload 18
    //   531: arraylength
    //   532: iload 11
    //   534: if_icmpgt +781 -> 1315
    //   537: iload 5
    //   539: istore 4
    //   541: aload 15
    //   543: iload 10
    //   545: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   548: pop
    //   549: iload 5
    //   551: istore 4
    //   553: aload 15
    //   555: aload 18
    //   557: arraylength
    //   558: i2b
    //   559: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   562: pop
    //   563: iload 5
    //   565: istore 4
    //   567: aload 15
    //   569: iload 12
    //   571: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   574: pop
    //   575: iload 5
    //   577: istore 4
    //   579: aload 15
    //   581: aload 18
    //   583: invokevirtual 572	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   586: pop
    //   587: iload 5
    //   589: istore 4
    //   591: aload 15
    //   593: iconst_0
    //   594: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   597: pop
    //   598: iload 5
    //   600: istore 4
    //   602: aload 15
    //   604: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   607: pop
    //   608: iload 5
    //   610: istore 4
    //   612: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   615: new 208	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   622: ldc_w 615
    //   625: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: aload_1
    //   629: iload 7
    //   631: aaload
    //   632: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   641: iload 5
    //   643: iconst_1
    //   644: iadd
    //   645: istore 8
    //   647: goto +668 -> 1315
    //   650: iload 5
    //   652: istore 4
    //   654: aload_0
    //   655: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   658: iload 5
    //   660: istore 4
    //   662: iload 4
    //   664: ireturn
    //   665: astore_0
    //   666: iload 4
    //   668: istore 6
    //   670: aload_0
    //   671: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   674: iload 4
    //   676: ireturn
    //   677: astore_0
    //   678: iload 6
    //   680: istore 5
    //   682: aload_0
    //   683: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   686: iload 6
    //   688: ireturn
    //   689: astore_0
    //   690: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   693: aload_0
    //   694: invokevirtual 405	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   697: iload 5
    //   699: ireturn
    //   700: iload 12
    //   702: istore 5
    //   704: new 171	java/io/File
    //   707: dup
    //   708: aload_0
    //   709: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   712: invokevirtual 175	java/io/File:exists	()Z
    //   715: istore_2
    //   716: iload 10
    //   718: istore 4
    //   720: iload_2
    //   721: ifeq -59 -> 662
    //   724: iload 9
    //   726: istore 4
    //   728: new 483	java/io/RandomAccessFile
    //   731: dup
    //   732: aload_0
    //   733: ldc_w 485
    //   736: invokespecial 595	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   739: invokevirtual 492	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   742: astore_0
    //   743: iload 9
    //   745: istore 4
    //   747: aload_0
    //   748: getstatic 498	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   751: lconst_0
    //   752: aload_0
    //   753: invokevirtual 502	java/nio/channels/FileChannel:size	()J
    //   756: l2i
    //   757: i2l
    //   758: invokevirtual 506	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   761: astore 15
    //   763: iload 9
    //   765: istore 4
    //   767: aload 15
    //   769: bipush 8
    //   771: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   774: pop
    //   775: iload 9
    //   777: istore 4
    //   779: aload 15
    //   781: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   784: aload 15
    //   786: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   789: aload 15
    //   791: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   794: aload 15
    //   796: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   799: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   802: istore 7
    //   804: iload 9
    //   806: istore 4
    //   808: aload 15
    //   810: iload 7
    //   812: bipush 56
    //   814: iadd
    //   815: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   818: pop
    //   819: iload 9
    //   821: istore 4
    //   823: aload 15
    //   825: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   828: aload 15
    //   830: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   833: aload 15
    //   835: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   838: aload 15
    //   840: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   843: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   846: istore 8
    //   848: iload 9
    //   850: istore 4
    //   852: aload 15
    //   854: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   857: aload 15
    //   859: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   862: aload 15
    //   864: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   867: aload 15
    //   869: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   872: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   875: iload 7
    //   877: iadd
    //   878: istore 5
    //   880: iload 9
    //   882: istore 4
    //   884: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   887: new 208	java/lang/StringBuilder
    //   890: dup
    //   891: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   894: ldc_w 1849
    //   897: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: iload 5
    //   902: invokestatic 1853	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   905: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   914: iload 9
    //   916: istore 4
    //   918: aload 15
    //   920: iload 5
    //   922: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   925: pop
    //   926: iload 9
    //   928: istore 4
    //   930: iload 8
    //   932: newarray <illegal type>
    //   934: astore 16
    //   936: iconst_0
    //   937: istore 5
    //   939: iload 5
    //   941: iload 8
    //   943: if_icmpge +47 -> 990
    //   946: iload 9
    //   948: istore 4
    //   950: aload 16
    //   952: iload 5
    //   954: aload 15
    //   956: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   959: aload 15
    //   961: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   964: aload 15
    //   966: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   969: aload 15
    //   971: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   974: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   977: iload 7
    //   979: iadd
    //   980: iastore
    //   981: iload 5
    //   983: iconst_1
    //   984: iadd
    //   985: istore 5
    //   987: goto -48 -> 939
    //   990: iload 9
    //   992: istore 4
    //   994: aload 16
    //   996: arraylength
    //   997: istore 9
    //   999: iconst_0
    //   1000: istore 4
    //   1002: iload 6
    //   1004: istore 5
    //   1006: iload 4
    //   1008: istore 6
    //   1010: iload 6
    //   1012: iload 9
    //   1014: if_icmpge +272 -> 1286
    //   1017: aload 16
    //   1019: iload 6
    //   1021: iaload
    //   1022: istore 10
    //   1024: iload 5
    //   1026: istore 4
    //   1028: aload 15
    //   1030: iload 10
    //   1032: invokevirtual 602	java/nio/MappedByteBuffer:get	(I)B
    //   1035: invokestatic 606	com/chelpus/Utils:convertByteToInt	(B)I
    //   1038: istore 11
    //   1040: iload 5
    //   1042: istore 4
    //   1044: iload 11
    //   1046: newarray <illegal type>
    //   1048: astore 17
    //   1050: iload 10
    //   1052: iconst_1
    //   1053: iadd
    //   1054: istore 12
    //   1056: iload 5
    //   1058: istore 4
    //   1060: aload 15
    //   1062: iload 12
    //   1064: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1067: pop
    //   1068: iconst_0
    //   1069: istore 7
    //   1071: iload 5
    //   1073: istore 4
    //   1075: iload 7
    //   1077: aload 17
    //   1079: arraylength
    //   1080: if_icmpge +257 -> 1337
    //   1083: iload 5
    //   1085: istore 4
    //   1087: aload 17
    //   1089: iload 7
    //   1091: aload 15
    //   1093: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   1096: bastore
    //   1097: iload 7
    //   1099: iconst_1
    //   1100: iadd
    //   1101: istore 7
    //   1103: goto -32 -> 1071
    //   1106: iload 5
    //   1108: istore 4
    //   1110: iload 7
    //   1112: aload_1
    //   1113: arraylength
    //   1114: if_icmpge +242 -> 1356
    //   1117: iload 5
    //   1119: istore 4
    //   1121: iload 5
    //   1123: istore 8
    //   1125: new 92	java/lang/String
    //   1128: dup
    //   1129: aload 17
    //   1131: invokespecial 610	java/lang/String:<init>	([B)V
    //   1134: aload_1
    //   1135: iload 7
    //   1137: aaload
    //   1138: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1141: ifeq +202 -> 1343
    //   1144: iload 5
    //   1146: istore 4
    //   1148: aload_3
    //   1149: iload 7
    //   1151: aaload
    //   1152: invokevirtual 613	java/lang/String:getBytes	()[B
    //   1155: astore 18
    //   1157: iload 5
    //   1159: istore 4
    //   1161: iload 5
    //   1163: istore 8
    //   1165: aload 18
    //   1167: arraylength
    //   1168: iload 11
    //   1170: if_icmpgt +173 -> 1343
    //   1173: iload 5
    //   1175: istore 4
    //   1177: aload 15
    //   1179: iload 10
    //   1181: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1184: pop
    //   1185: iload 5
    //   1187: istore 4
    //   1189: aload 15
    //   1191: aload 18
    //   1193: arraylength
    //   1194: i2b
    //   1195: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1198: pop
    //   1199: iload 5
    //   1201: istore 4
    //   1203: aload 15
    //   1205: iload 12
    //   1207: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1210: pop
    //   1211: iload 5
    //   1213: istore 4
    //   1215: aload 15
    //   1217: aload 18
    //   1219: invokevirtual 572	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   1222: pop
    //   1223: iload 5
    //   1225: istore 4
    //   1227: aload 15
    //   1229: iconst_0
    //   1230: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1233: pop
    //   1234: iload 5
    //   1236: istore 4
    //   1238: aload 15
    //   1240: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1243: pop
    //   1244: iload 5
    //   1246: istore 4
    //   1248: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   1251: new 208	java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1258: ldc_w 615
    //   1261: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: aload_1
    //   1265: iload 7
    //   1267: aaload
    //   1268: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1274: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1277: iload 5
    //   1279: iconst_1
    //   1280: iadd
    //   1281: istore 8
    //   1283: goto +60 -> 1343
    //   1286: iload 5
    //   1288: istore 4
    //   1290: aload_0
    //   1291: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   1294: iload 5
    //   1296: ireturn
    //   1297: astore_0
    //   1298: iload 4
    //   1300: istore 5
    //   1302: aload_0
    //   1303: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1306: iload 4
    //   1308: ireturn
    //   1309: iconst_0
    //   1310: istore 7
    //   1312: goto -842 -> 470
    //   1315: iload 7
    //   1317: iconst_1
    //   1318: iadd
    //   1319: istore 7
    //   1321: iload 8
    //   1323: istore 5
    //   1325: goto -855 -> 470
    //   1328: iload 6
    //   1330: iconst_1
    //   1331: iadd
    //   1332: istore 6
    //   1334: goto -960 -> 374
    //   1337: iconst_0
    //   1338: istore 7
    //   1340: goto -234 -> 1106
    //   1343: iload 7
    //   1345: iconst_1
    //   1346: iadd
    //   1347: istore 7
    //   1349: iload 8
    //   1351: istore 5
    //   1353: goto -247 -> 1106
    //   1356: iload 6
    //   1358: iconst_1
    //   1359: iadd
    //   1360: istore 6
    //   1362: goto -352 -> 1010
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1365	0	paramString	String
    //   0	1365	1	paramArrayOfString1	String[]
    //   0	1365	2	paramBoolean	boolean
    //   0	1365	3	paramArrayOfString2	String[]
    //   84	1223	4	i	int
    //   96	1256	5	j	int
    //   39	1322	6	k	int
    //   45	1303	7	m	int
    //   30	1320	8	n	int
    //   42	973	9	i1	int
    //   27	1153	10	i2	int
    //   33	1138	11	i3	int
    //   36	1170	12	i4	int
    //   127	7	13	l	long
    //   201	1038	15	localMappedByteBuffer	MappedByteBuffer
    //   283	735	16	localObject	Object
    //   412	718	17	arrayOfByte1	byte[]
    //   519	699	18	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   168	183	665	java/lang/Exception
    //   187	203	665	java/lang/Exception
    //   207	215	665	java/lang/Exception
    //   219	244	665	java/lang/Exception
    //   248	273	665	java/lang/Exception
    //   277	285	665	java/lang/Exception
    //   289	297	665	java/lang/Exception
    //   301	307	665	java/lang/Exception
    //   321	349	665	java/lang/Exception
    //   362	367	665	java/lang/Exception
    //   392	404	665	java/lang/Exception
    //   408	414	665	java/lang/Exception
    //   424	432	665	java/lang/Exception
    //   439	447	665	java/lang/Exception
    //   451	461	665	java/lang/Exception
    //   474	481	665	java/lang/Exception
    //   489	508	665	java/lang/Exception
    //   512	521	665	java/lang/Exception
    //   529	537	665	java/lang/Exception
    //   541	549	665	java/lang/Exception
    //   553	563	665	java/lang/Exception
    //   567	575	665	java/lang/Exception
    //   579	587	665	java/lang/Exception
    //   591	598	665	java/lang/Exception
    //   602	608	665	java/lang/Exception
    //   612	641	665	java/lang/Exception
    //   654	658	665	java/lang/Exception
    //   144	156	677	java/lang/Exception
    //   670	674	677	java/lang/Exception
    //   98	112	689	java/lang/Exception
    //   116	129	689	java/lang/Exception
    //   682	686	689	java/lang/Exception
    //   704	716	689	java/lang/Exception
    //   1302	1306	689	java/lang/Exception
    //   728	743	1297	java/lang/Exception
    //   747	763	1297	java/lang/Exception
    //   767	775	1297	java/lang/Exception
    //   779	804	1297	java/lang/Exception
    //   808	819	1297	java/lang/Exception
    //   823	848	1297	java/lang/Exception
    //   852	880	1297	java/lang/Exception
    //   884	914	1297	java/lang/Exception
    //   918	926	1297	java/lang/Exception
    //   930	936	1297	java/lang/Exception
    //   950	981	1297	java/lang/Exception
    //   994	999	1297	java/lang/Exception
    //   1028	1040	1297	java/lang/Exception
    //   1044	1050	1297	java/lang/Exception
    //   1060	1068	1297	java/lang/Exception
    //   1075	1083	1297	java/lang/Exception
    //   1087	1097	1297	java/lang/Exception
    //   1110	1117	1297	java/lang/Exception
    //   1125	1144	1297	java/lang/Exception
    //   1148	1157	1297	java/lang/Exception
    //   1165	1173	1297	java/lang/Exception
    //   1177	1185	1297	java/lang/Exception
    //   1189	1199	1297	java/lang/Exception
    //   1203	1211	1297	java/lang/Exception
    //   1215	1223	1297	java/lang/Exception
    //   1227	1234	1297	java/lang/Exception
    //   1238	1244	1297	java/lang/Exception
    //   1248	1277	1297	java/lang/Exception
    //   1290	1294	1297	java/lang/Exception
  }
  
  public static String rework(String paramString)
  {
    String str = paramString;
    if (paramString.contains("52")) {
      str = paramString.replaceAll("52", "f2");
    }
    paramString = str;
    if (str.contains("53")) {
      paramString = str.replaceAll("53", "f3");
    }
    str = paramString;
    if (paramString.contains("54")) {
      str = paramString.replaceAll("54", "f4");
    }
    paramString = str;
    if (str.contains("55")) {
      paramString = str.replaceAll("55", "f2");
    }
    str = paramString;
    if (paramString.contains("59")) {
      str = paramString.replaceAll("59", "f5");
    }
    paramString = str;
    if (str.toUpperCase().contains("5A")) {
      paramString = str.toUpperCase().replaceAll("5A", "F6");
    }
    str = paramString;
    if (paramString.toUpperCase().contains("5B")) {
      str = paramString.toUpperCase().replaceAll("5B", "F7");
    }
    paramString = str;
    if (str.toUpperCase().contains("5C")) {
      paramString = str.toUpperCase().replaceAll("5C", "F5");
    }
    str = paramString;
    if (paramString.toUpperCase().contains("5D")) {
      str = paramString.toUpperCase().replaceAll("5D", "F5");
    }
    paramString = str;
    if (str.contains("74")) {
      paramString = str.replaceAll("74", "f9");
    }
    str = paramString;
    if (paramString.toUpperCase().contains("6E")) {
      str = paramString.toUpperCase().replaceAll("6E", "F8");
    }
    return str;
  }
  
  public static void run_all(String paramString)
  {
    Object localObject;
    try
    {
      if ((listAppsFragment.su) && (!listAppsFragment.checktools))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).clear();
        ((ArrayList)localObject).add(listAppsFragment.toolfilesdir + "/busybox");
        if (exists("/system/bin/failsafe/toolbox")) {
          ((ArrayList)localObject).add("/system/bin/failsafe/toolbox");
        }
        listAppsFragment.errorOutput = "";
        new Utils("").cmdRoot(new String[] { "busybox chmod 777 " + listAppsFragment.toolfilesdir + "/busybox" });
        if (listAppsFragment.errorOutput.equals("")) {
          ((ArrayList)localObject).add("busybox");
        }
        listAppsFragment.errorOutput = "";
        new Utils("").cmdRoot(new String[] { "toolbox chmod 777 " + listAppsFragment.toolfilesdir + "/busybox" });
        if (!listAppsFragment.errorOutput.equals("")) {
          break label336;
        }
        ((ArrayList)localObject).add("toolbox");
      }
      for (;;)
      {
        listAppsFragment.tools = new String[((ArrayList)localObject).size()];
        listAppsFragment.tools = (String[])((ArrayList)localObject).toArray(listAppsFragment.tools);
        listAppsFragment.checktools = true;
        if (!listAppsFragment.su) {
          break;
        }
        localObject = new String[listAppsFragment.tools.length + 1];
        int j = 1;
        localObject[0] = paramString;
        String[] arrayOfString = listAppsFragment.tools;
        int k = arrayOfString.length;
        int i = 0;
        while (i < k)
        {
          String str = arrayOfString[i];
          localObject[j] = (str + " " + paramString);
          j += 1;
          i += 1;
        }
        label336:
        System.out.println("skip toolbox in tools");
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    new Utils("").cmdRoot((String[])localObject);
  }
  
  public static void run_all_no_root(String... paramVarArgs)
  {
    Object localObject;
    int i;
    int k;
    int j;
    for (;;)
    {
      try
      {
        if (!listAppsFragment.checktools)
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).clear();
          ((ArrayList)localObject).add(listAppsFragment.toolfilesdir + "/busybox");
          if (exists("/system/bin/failsafe/toolbox")) {
            ((ArrayList)localObject).add("/system/bin/failsafe/toolbox");
          }
          listAppsFragment.errorOutput = "";
          cmdParam(new String[] { "busybox", "chmod", "777", listAppsFragment.toolfilesdir + "/busybox" });
          if (listAppsFragment.errorOutput.equals(""))
          {
            ((ArrayList)localObject).add("busybox");
            listAppsFragment.errorOutput = "";
            cmdParam(new String[] { "toolbox", "chmod", "777", listAppsFragment.toolfilesdir + "/busybox" });
            if (!listAppsFragment.errorOutput.equals("")) {
              break label305;
            }
            ((ArrayList)localObject).add("toolbox");
            listAppsFragment.tools = new String[((ArrayList)localObject).size()];
            listAppsFragment.tools = (String[])((ArrayList)localObject).toArray(listAppsFragment.tools);
            listAppsFragment.checktools = true;
          }
        }
        else
        {
          cmdParam(paramVarArgs);
          if ((listAppsFragment.tools == null) || (listAppsFragment.tools.length <= 0)) {
            break label304;
          }
          localObject = new String[paramVarArgs.length + 1];
          i = 1;
          k = paramVarArgs.length;
          j = 0;
          break;
        }
        System.out.println("skip busybox in tools");
        continue;
        return;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      label304:
      label305:
      System.out.println("skip toolbox in tools");
    }
    for (;;)
    {
      paramVarArgs = listAppsFragment.tools;
      j = paramVarArgs.length;
      i = 0;
      while (i < j)
      {
        localObject[0] = paramVarArgs[i];
        cmdParam((String[])localObject);
        i += 1;
      }
      break;
      while (j < k)
      {
        localObject[i] = paramVarArgs[j];
        i += 1;
        j += 1;
      }
    }
  }
  
  /* Error */
  public static boolean saveXposedParamBoolean(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 2177	org/json/JSONObject
    //   3: dup
    //   4: new 171	java/io/File
    //   7: dup
    //   8: ldc_w 2171
    //   11: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokestatic 2013	com/chelpus/Utils:read_from_file	(Ljava/io/File;)Ljava/lang/String;
    //   17: invokespecial 2198	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: astore_3
    //   21: aload_3
    //   22: aload_0
    //   23: iload_1
    //   24: invokevirtual 2183	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   27: pop
    //   28: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   31: aload_3
    //   32: invokevirtual 2194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   35: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   38: new 171	java/io/File
    //   41: dup
    //   42: ldc_w 2171
    //   45: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: aload_3
    //   49: invokevirtual 2194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   52: invokestatic 2197	com/chelpus/Utils:save_text_to_file	(Ljava/io/File;Ljava/lang/String;)Z
    //   55: pop
    //   56: iload_2
    //   57: ifeq +97 -> 154
    //   60: getstatic 927	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:startUnderRoot	Ljava/lang/Boolean;
    //   63: invokevirtual 932	java/lang/Boolean:booleanValue	()Z
    //   66: ifeq +129 -> 195
    //   69: iconst_3
    //   70: anewarray 92	java/lang/String
    //   73: dup
    //   74: iconst_0
    //   75: ldc_w 453
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: ldc_w 591
    //   84: aastore
    //   85: dup
    //   86: iconst_2
    //   87: ldc_w 2171
    //   90: aastore
    //   91: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   94: new 171	java/io/File
    //   97: dup
    //   98: ldc_w 2708
    //   101: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: invokevirtual 647	java/io/File:createNewFile	()Z
    //   107: pop
    //   108: new 171	java/io/File
    //   111: dup
    //   112: ldc_w 2708
    //   115: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: iconst_1
    //   119: iconst_0
    //   120: invokevirtual 2175	java/io/File:setWritable	(ZZ)Z
    //   123: pop
    //   124: new 171	java/io/File
    //   127: dup
    //   128: ldc_w 2710
    //   131: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 647	java/io/File:createNewFile	()Z
    //   137: pop
    //   138: new 171	java/io/File
    //   141: dup
    //   142: ldc_w 2710
    //   145: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: iconst_1
    //   149: iconst_0
    //   150: invokevirtual 2175	java/io/File:setWritable	(ZZ)Z
    //   153: pop
    //   154: iconst_1
    //   155: ireturn
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 2206	org/json/JSONException:printStackTrace	()V
    //   161: iconst_0
    //   162: ireturn
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 2206	org/json/JSONException:printStackTrace	()V
    //   168: goto -140 -> 28
    //   171: astore_0
    //   172: aload_0
    //   173: invokevirtual 2201	java/lang/NoSuchMethodError:printStackTrace	()V
    //   176: goto -52 -> 124
    //   179: astore_0
    //   180: aload_0
    //   181: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   184: goto -30 -> 154
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 2201	java/lang/NoSuchMethodError:printStackTrace	()V
    //   192: goto -38 -> 154
    //   195: ldc_w 2208
    //   198: invokestatic 654	com/chelpus/Utils:run_all	(Ljava/lang/String;)V
    //   201: new 171	java/io/File
    //   204: dup
    //   205: ldc_w 2708
    //   208: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   211: invokevirtual 647	java/io/File:createNewFile	()Z
    //   214: pop
    //   215: new 171	java/io/File
    //   218: dup
    //   219: ldc_w 2708
    //   222: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   225: iconst_1
    //   226: iconst_0
    //   227: invokevirtual 2175	java/io/File:setWritable	(ZZ)Z
    //   230: pop
    //   231: new 171	java/io/File
    //   234: dup
    //   235: ldc_w 2710
    //   238: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   241: invokevirtual 647	java/io/File:createNewFile	()Z
    //   244: pop
    //   245: new 171	java/io/File
    //   248: dup
    //   249: ldc_w 2710
    //   252: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: iconst_1
    //   256: iconst_0
    //   257: invokevirtual 2175	java/io/File:setWritable	(ZZ)Z
    //   260: pop
    //   261: goto -107 -> 154
    //   264: astore_0
    //   265: aload_0
    //   266: invokevirtual 2201	java/lang/NoSuchMethodError:printStackTrace	()V
    //   269: goto -115 -> 154
    //   272: astore_0
    //   273: aload_0
    //   274: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   277: goto -123 -> 154
    //   280: astore_0
    //   281: aload_0
    //   282: invokevirtual 2201	java/lang/NoSuchMethodError:printStackTrace	()V
    //   285: goto -54 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	paramString	String
    //   0	288	1	paramBoolean1	boolean
    //   0	288	2	paramBoolean2	boolean
    //   20	29	3	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	21	156	org/json/JSONException
    //   21	28	163	org/json/JSONException
    //   108	124	171	java/lang/NoSuchMethodError
    //   94	108	179	java/io/IOException
    //   108	124	179	java/io/IOException
    //   124	138	179	java/io/IOException
    //   138	154	179	java/io/IOException
    //   172	176	179	java/io/IOException
    //   188	192	179	java/io/IOException
    //   138	154	187	java/lang/NoSuchMethodError
    //   245	261	264	java/lang/NoSuchMethodError
    //   201	215	272	java/io/IOException
    //   215	231	272	java/io/IOException
    //   231	245	272	java/io/IOException
    //   245	261	272	java/io/IOException
    //   265	269	272	java/io/IOException
    //   281	285	272	java/io/IOException
    //   215	231	280	java/lang/NoSuchMethodError
  }
  
  public static boolean save_text_to_end_file(File paramFile, String paramString)
  {
    try
    {
      if (!paramFile.exists())
      {
        getDirs(paramFile).mkdirs();
        paramFile.createNewFile();
      }
      System.out.println("...rrunning my app...");
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
      long l1;
      long l2;
      int i;
      paramFile.printStackTrace();
    }
    catch (Exception paramFile)
    {
      try
      {
        l1 = paramFile.length();
        localRandomAccessFile.seek(paramFile.length());
        localRandomAccessFile.write(paramString.getBytes());
        System.out.println("...file length..." + localRandomAccessFile.length());
        localRandomAccessFile.close();
        l2 = paramFile.length();
        i = paramString.length();
        return l2 == i + l1;
      }
      catch (Exception paramFile)
      {
        for (;;) {}
      }
      paramFile = paramFile;
    }
    return false;
  }
  
  /* Error */
  public static boolean save_text_to_end_file_from_file(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   3: ldc_w 2713
    //   6: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   9: new 483	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc_w 485
    //   17: invokespecial 488	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_3
    //   21: new 483	java/io/RandomAccessFile
    //   24: dup
    //   25: aload_1
    //   26: ldc_w 1844
    //   29: invokespecial 488	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_0
    //   34: invokevirtual 311	java/io/File:length	()J
    //   37: pop2
    //   38: aload_3
    //   39: aload_0
    //   40: invokevirtual 311	java/io/File:length	()J
    //   43: invokevirtual 2538	java/io/RandomAccessFile:seek	(J)V
    //   46: aload_3
    //   47: ldc_w 2721
    //   50: invokevirtual 613	java/lang/String:getBytes	()[B
    //   53: invokevirtual 2715	java/io/RandomAccessFile:write	([B)V
    //   56: sipush 4096
    //   59: newarray <illegal type>
    //   61: astore_0
    //   62: aload_1
    //   63: aload_0
    //   64: invokevirtual 2539	java/io/RandomAccessFile:read	([B)I
    //   67: istore_2
    //   68: iload_2
    //   69: ifle +20 -> 89
    //   72: aload_3
    //   73: aload_0
    //   74: iconst_0
    //   75: iload_2
    //   76: invokevirtual 2722	java/io/RandomAccessFile:write	([BII)V
    //   79: goto -17 -> 62
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   87: iconst_0
    //   88: ireturn
    //   89: aload_3
    //   90: ldc_w 2724
    //   93: invokevirtual 613	java/lang/String:getBytes	()[B
    //   96: invokevirtual 2715	java/io/RandomAccessFile:write	([B)V
    //   99: aload_1
    //   100: invokevirtual 2540	java/io/RandomAccessFile:close	()V
    //   103: aload_3
    //   104: invokevirtual 2540	java/io/RandomAccessFile:close	()V
    //   107: iconst_1
    //   108: ireturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_0
    //   117: goto -7 -> 110
    //   120: astore_0
    //   121: goto -11 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramFile1	File
    //   0	124	1	paramFile2	File
    //   67	9	2	i	int
    //   20	84	3	localRandomAccessFile	RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   46	62	82	java/io/IOException
    //   62	68	82	java/io/IOException
    //   72	79	82	java/io/IOException
    //   89	103	82	java/io/IOException
    //   0	21	109	java/lang/Exception
    //   21	33	116	java/lang/Exception
    //   33	46	120	java/lang/Exception
    //   46	62	120	java/lang/Exception
    //   62	68	120	java/lang/Exception
    //   72	79	120	java/lang/Exception
    //   83	87	120	java/lang/Exception
    //   89	103	120	java/lang/Exception
    //   103	107	120	java/lang/Exception
  }
  
  public static boolean save_text_to_file(File paramFile, String paramString)
  {
    try
    {
      if (!paramFile.exists())
      {
        getDirs(paramFile).mkdirs();
        paramFile.createNewFile();
      }
      System.out.println("...rrunning my app...");
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
      long l;
      int i;
      paramFile.printStackTrace();
    }
    catch (Exception paramFile)
    {
      try
      {
        localRandomAccessFile.setLength(0L);
        localRandomAccessFile.seek(0L);
        localRandomAccessFile.write(paramString.getBytes());
        localRandomAccessFile.close();
        l = paramFile.length();
        i = paramString.length();
        return l == i;
      }
      catch (Exception paramFile)
      {
        for (;;) {}
      }
      paramFile = paramFile;
    }
    return false;
  }
  
  public static boolean sendFromRoot(String paramString)
  {
    System.out.println(paramString);
    return false;
  }
  
  public static boolean sendFromRootCP(String paramString)
  {
    System.out.println(paramString);
    return false;
  }
  
  public static final void setIcon(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Original"), 1, 1);
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Flint"), 2, 1);
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-2"), 2, 1);
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-3"), 2, 1);
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-4"), 2, 1);
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-5"), 2, 1);
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-6"), 2, 1);
      listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-7"), 2, 1);
      try
      {
        if ((listAppsFragment.frag != null) && (listAppsFragment.api > 10))
        {
          listAppsFragment.frag.getActivity().getActionBar().setIcon(2130837551);
          return;
        }
      }
      catch (Exception localException1)
      {
        return;
        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Original"), 2, 1);
        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Flint"), 1, 1);
        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-2"), 2, 1);
        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-3"), 2, 1);
        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-4"), 2, 1);
        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-5"), 2, 1);
        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-6"), 2, 1);
        listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-7"), 2, 1);
        try
        {
          if ((listAppsFragment.frag != null) && (listAppsFragment.api > 10))
          {
            listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903046);
            return;
          }
        }
        catch (Exception localException2)
        {
          return;
          listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Original"), 2, 1);
          listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Flint"), 2, 1);
          listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-2"), 1, 1);
          listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-3"), 2, 1);
          listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-4"), 2, 1);
          listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-5"), 2, 1);
          listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-6"), 2, 1);
          listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-7"), 2, 1);
          try
          {
            if ((listAppsFragment.frag != null) && (listAppsFragment.api > 10))
            {
              listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903047);
              return;
            }
          }
          catch (Exception localException3)
          {
            return;
            listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Original"), 2, 1);
            listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Flint"), 2, 1);
            listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-2"), 2, 1);
            listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-3"), 1, 1);
            listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-4"), 2, 1);
            listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-5"), 2, 1);
            listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-6"), 2, 1);
            listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-7"), 2, 1);
            try
            {
              if ((listAppsFragment.frag != null) && (listAppsFragment.api > 10))
              {
                listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903048);
                return;
              }
            }
            catch (Exception localException4)
            {
              return;
              listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Original"), 2, 1);
              listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Flint"), 2, 1);
              listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-2"), 2, 1);
              listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-3"), 2, 1);
              listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-4"), 1, 1);
              listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-5"), 2, 1);
              listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-6"), 2, 1);
              listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-7"), 2, 1);
              try
              {
                if ((listAppsFragment.frag != null) && (listAppsFragment.api > 10))
                {
                  listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903049);
                  return;
                }
              }
              catch (Exception localException5)
              {
                return;
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Original"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Flint"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-2"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-3"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-4"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-5"), 1, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-6"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-7"), 2, 1);
                try
                {
                  if ((listAppsFragment.frag != null) && (listAppsFragment.api > 10))
                  {
                    listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903050);
                    return;
                  }
                }
                catch (Exception localException6)
                {
                  return;
                  listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Original"), 2, 1);
                  listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Flint"), 2, 1);
                  listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-2"), 2, 1);
                  listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-3"), 2, 1);
                  listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-4"), 2, 1);
                  listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-5"), 2, 1);
                  listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-6"), 1, 1);
                  listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-7"), 2, 1);
                  try
                  {
                    if ((listAppsFragment.frag != null) && (listAppsFragment.api > 10))
                    {
                      listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903050);
                      return;
                    }
                  }
                  catch (Exception localException7)
                  {
                    return;
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Original"), 2, 1);
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-Flint"), 2, 1);
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-2"), 2, 1);
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-3"), 2, 1);
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-4"), 2, 1);
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-5"), 2, 1);
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-6"), 2, 1);
                    listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LACK.MainActivity-7"), 1, 1);
                    try
                    {
                      if ((listAppsFragment.frag != null) && (listAppsFragment.api > 10))
                      {
                        listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903050);
                        return;
                      }
                    }
                    catch (Exception localException8) {}catch (NoSuchMethodError localNoSuchMethodError1) {}
                  }
                  catch (NoSuchMethodError localNoSuchMethodError2) {}
                }
                catch (NoSuchMethodError localNoSuchMethodError3) {}
              }
              catch (NoSuchMethodError localNoSuchMethodError4) {}
            }
            catch (NoSuchMethodError localNoSuchMethodError5) {}
          }
          catch (NoSuchMethodError localNoSuchMethodError6) {}
        }
        catch (NoSuchMethodError localNoSuchMethodError7) {}
      }
      catch (NoSuchMethodError localNoSuchMethodError8) {}
    }
  }
  
  public static void setPermissionDir(String paramString1, String paramString2, String paramString3)
  {
    if (new File(paramString2).exists())
    {
      String[] arrayOfString = paramString2.split(File.separator);
      String str = "/";
      int i = 0;
      while (i < arrayOfString.length)
      {
        paramString2 = str;
        if (!arrayOfString[i].equals("")) {
          paramString2 = str + arrayOfString[i];
        }
        if ((paramString2.startsWith(paramString1)) || ((paramString2 + "/").startsWith(paramString1))) {
          cmdParam(new String[] { "chmod", paramString3, paramString2 });
        }
        str = paramString2;
        if (!arrayOfString[i].equals("")) {
          str = paramString2 + "/";
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static int setStringIds(String paramString, byte[][] paramArrayOfByte, boolean paramBoolean, byte paramByte)
  {
    // Byte code:
    //   0: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   3: new 208	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 589
    //   13: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   26: iconst_0
    //   27: istore 10
    //   29: iconst_0
    //   30: istore 8
    //   32: iconst_0
    //   33: istore 11
    //   35: iconst_0
    //   36: istore 12
    //   38: iconst_0
    //   39: istore 6
    //   41: iconst_0
    //   42: istore 9
    //   44: iconst_0
    //   45: istore 7
    //   47: iconst_3
    //   48: anewarray 92	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: ldc_w 453
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: ldc_w 591
    //   62: aastore
    //   63: dup
    //   64: iconst_2
    //   65: aload_0
    //   66: aastore
    //   67: invokestatic 459	com/chelpus/Utils:run_all_no_root	([Ljava/lang/String;)V
    //   70: new 290	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 592	java/util/ArrayList:<init>	()V
    //   77: pop
    //   78: iload_2
    //   79: ifne +682 -> 761
    //   82: iload 10
    //   84: istore 4
    //   86: aload_0
    //   87: ifnull +636 -> 723
    //   90: iload 10
    //   92: istore 4
    //   94: iload 12
    //   96: istore 5
    //   98: new 171	java/io/File
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: invokevirtual 175	java/io/File:exists	()Z
    //   109: ifeq +614 -> 723
    //   112: iload 12
    //   114: istore 5
    //   116: new 171	java/io/File
    //   119: dup
    //   120: aload_0
    //   121: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: invokevirtual 311	java/io/File:length	()J
    //   127: lstore 14
    //   129: iload 10
    //   131: istore 4
    //   133: lload 14
    //   135: lconst_0
    //   136: lcmp
    //   137: ifeq +586 -> 723
    //   140: iload 11
    //   142: istore 6
    //   144: new 171	java/io/File
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: invokevirtual 175	java/io/File:exists	()Z
    //   155: istore_2
    //   156: iload 10
    //   158: istore 4
    //   160: iload_2
    //   161: ifeq +562 -> 723
    //   164: iload 8
    //   166: istore 4
    //   168: new 483	java/io/RandomAccessFile
    //   171: dup
    //   172: aload_0
    //   173: ldc_w 485
    //   176: invokespecial 595	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: invokevirtual 492	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   182: astore_0
    //   183: iload 8
    //   185: istore 4
    //   187: aload_0
    //   188: getstatic 498	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   191: lconst_0
    //   192: aload_0
    //   193: invokevirtual 502	java/nio/channels/FileChannel:size	()J
    //   196: l2i
    //   197: i2l
    //   198: invokevirtual 506	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   201: astore 16
    //   203: iload 8
    //   205: istore 4
    //   207: aload 16
    //   209: bipush 56
    //   211: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   214: pop
    //   215: iload 8
    //   217: istore 4
    //   219: aload 16
    //   221: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   224: aload 16
    //   226: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   229: aload 16
    //   231: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   234: aload 16
    //   236: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   239: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   242: istore 6
    //   244: iload 8
    //   246: istore 4
    //   248: aload 16
    //   250: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   253: aload 16
    //   255: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   258: aload 16
    //   260: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   263: aload 16
    //   265: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   268: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   271: istore 5
    //   273: iload 8
    //   275: istore 4
    //   277: iload 6
    //   279: iconst_4
    //   280: idiv
    //   281: newarray <illegal type>
    //   283: astore 17
    //   285: iload 8
    //   287: istore 4
    //   289: aload 16
    //   291: iload 5
    //   293: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   296: pop
    //   297: iload 8
    //   299: istore 4
    //   301: iload 6
    //   303: newarray <illegal type>
    //   305: astore 17
    //   307: iconst_0
    //   308: istore 5
    //   310: iload 5
    //   312: iload 6
    //   314: if_icmpge +44 -> 358
    //   317: iload 8
    //   319: istore 4
    //   321: aload 17
    //   323: iload 5
    //   325: aload 16
    //   327: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   330: aload 16
    //   332: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   335: aload 16
    //   337: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   340: aload 16
    //   342: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   345: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   348: iastore
    //   349: iload 5
    //   351: iconst_1
    //   352: iadd
    //   353: istore 5
    //   355: goto -45 -> 310
    //   358: iload 8
    //   360: istore 4
    //   362: aload 17
    //   364: arraylength
    //   365: istore 11
    //   367: iconst_0
    //   368: istore 6
    //   370: iload 7
    //   372: istore 5
    //   374: iload 6
    //   376: iload 11
    //   378: if_icmpge +333 -> 711
    //   381: aload 17
    //   383: iload 6
    //   385: iaload
    //   386: istore 7
    //   388: iload 5
    //   390: istore 4
    //   392: aload 16
    //   394: iload 7
    //   396: invokevirtual 602	java/nio/MappedByteBuffer:get	(I)B
    //   399: invokestatic 606	com/chelpus/Utils:convertByteToInt	(B)I
    //   402: istore 12
    //   404: iload 5
    //   406: istore 4
    //   408: iload 12
    //   410: newarray <illegal type>
    //   412: astore 18
    //   414: iload 7
    //   416: iconst_1
    //   417: iadd
    //   418: istore 13
    //   420: iload 5
    //   422: istore 4
    //   424: aload 16
    //   426: iload 13
    //   428: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   431: pop
    //   432: iconst_0
    //   433: istore 7
    //   435: iload 5
    //   437: istore 4
    //   439: iload 7
    //   441: aload 18
    //   443: arraylength
    //   444: if_icmpge +987 -> 1431
    //   447: iload 5
    //   449: istore 4
    //   451: aload 18
    //   453: iload 7
    //   455: aload 16
    //   457: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   460: bastore
    //   461: iload 7
    //   463: iconst_1
    //   464: iadd
    //   465: istore 7
    //   467: goto -32 -> 435
    //   470: iload 5
    //   472: istore 4
    //   474: iload 7
    //   476: aload_1
    //   477: arraylength
    //   478: if_icmpge +985 -> 1463
    //   481: iload 5
    //   483: istore 4
    //   485: aload_1
    //   486: iload 7
    //   488: invokestatic 2776	java/lang/reflect/Array:get	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   491: checkcast 2777	[B
    //   494: checkcast 2777	[B
    //   497: astore 19
    //   499: iload 5
    //   501: istore 4
    //   503: iload 5
    //   505: istore 9
    //   507: aload 19
    //   509: arraylength
    //   510: iload 12
    //   512: if_icmpgt +938 -> 1450
    //   515: iload 5
    //   517: istore 4
    //   519: iload 5
    //   521: istore 9
    //   523: aload 19
    //   525: arraylength
    //   526: iconst_2
    //   527: if_icmple +923 -> 1450
    //   530: iconst_0
    //   531: istore 8
    //   533: iload 5
    //   535: istore 4
    //   537: iload 5
    //   539: istore 9
    //   541: iload 8
    //   543: aload 18
    //   545: arraylength
    //   546: if_icmpge +904 -> 1450
    //   549: iload 5
    //   551: istore 10
    //   553: aload 18
    //   555: iload 8
    //   557: baload
    //   558: aload 19
    //   560: iconst_0
    //   561: baload
    //   562: if_icmpne +875 -> 1437
    //   565: iconst_1
    //   566: istore 9
    //   568: iload 5
    //   570: istore 4
    //   572: iload 5
    //   574: istore 10
    //   576: iload 9
    //   578: aload 19
    //   580: arraylength
    //   581: if_icmpge +856 -> 1437
    //   584: iload 5
    //   586: istore 4
    //   588: iload 5
    //   590: istore 10
    //   592: iload 8
    //   594: iload 9
    //   596: iadd
    //   597: aload 18
    //   599: arraylength
    //   600: if_icmpge +837 -> 1437
    //   603: iload 5
    //   605: istore 10
    //   607: aload 18
    //   609: iload 8
    //   611: iload 9
    //   613: iadd
    //   614: baload
    //   615: aload 19
    //   617: iload 9
    //   619: baload
    //   620: if_icmpne +817 -> 1437
    //   623: iload 9
    //   625: iconst_1
    //   626: iadd
    //   627: istore 10
    //   629: iload 10
    //   631: istore 9
    //   633: iload 5
    //   635: istore 4
    //   637: iload 10
    //   639: aload 19
    //   641: arraylength
    //   642: if_icmpne -74 -> 568
    //   645: iload 5
    //   647: istore 4
    //   649: aload 19
    //   651: arraylength
    //   652: iconst_2
    //   653: if_icmple +35 -> 688
    //   656: iload 5
    //   658: istore 4
    //   660: aload 16
    //   662: iload 13
    //   664: iload 8
    //   666: iadd
    //   667: aload 19
    //   669: arraylength
    //   670: iconst_1
    //   671: isub
    //   672: iadd
    //   673: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   676: pop
    //   677: iload 5
    //   679: istore 4
    //   681: aload 16
    //   683: iload_3
    //   684: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   687: pop
    //   688: iload 5
    //   690: istore 4
    //   692: aload 16
    //   694: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   697: pop
    //   698: iload 5
    //   700: iconst_1
    //   701: iadd
    //   702: istore 5
    //   704: iload 10
    //   706: istore 9
    //   708: goto -140 -> 568
    //   711: iload 5
    //   713: istore 4
    //   715: aload_0
    //   716: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   719: iload 5
    //   721: istore 4
    //   723: iload 4
    //   725: ireturn
    //   726: astore_0
    //   727: iload 4
    //   729: istore 6
    //   731: aload_0
    //   732: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   735: iload 4
    //   737: ireturn
    //   738: astore_0
    //   739: iload 6
    //   741: istore 5
    //   743: aload_0
    //   744: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   747: iload 6
    //   749: ireturn
    //   750: astore_0
    //   751: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   754: aload_0
    //   755: invokevirtual 405	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   758: iload 5
    //   760: ireturn
    //   761: iload 12
    //   763: istore 5
    //   765: new 171	java/io/File
    //   768: dup
    //   769: aload_0
    //   770: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   773: invokevirtual 175	java/io/File:exists	()Z
    //   776: istore_2
    //   777: iload 10
    //   779: istore 4
    //   781: iload_2
    //   782: ifeq -59 -> 723
    //   785: iload 9
    //   787: istore 4
    //   789: new 483	java/io/RandomAccessFile
    //   792: dup
    //   793: aload_0
    //   794: ldc_w 485
    //   797: invokespecial 595	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   800: invokevirtual 492	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   803: astore_0
    //   804: iload 9
    //   806: istore 4
    //   808: aload_0
    //   809: getstatic 498	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   812: lconst_0
    //   813: aload_0
    //   814: invokevirtual 502	java/nio/channels/FileChannel:size	()J
    //   817: l2i
    //   818: i2l
    //   819: invokevirtual 506	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   822: astore 16
    //   824: iload 9
    //   826: istore 4
    //   828: aload 16
    //   830: bipush 8
    //   832: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   835: pop
    //   836: iload 9
    //   838: istore 4
    //   840: aload 16
    //   842: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   845: aload 16
    //   847: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   850: aload 16
    //   852: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   855: aload 16
    //   857: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   860: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   863: istore 7
    //   865: iload 9
    //   867: istore 4
    //   869: aload 16
    //   871: iload 7
    //   873: bipush 56
    //   875: iadd
    //   876: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   879: pop
    //   880: iload 9
    //   882: istore 4
    //   884: aload 16
    //   886: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   889: aload 16
    //   891: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   894: aload 16
    //   896: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   899: aload 16
    //   901: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   904: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   907: istore 8
    //   909: iload 9
    //   911: istore 4
    //   913: aload 16
    //   915: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   918: aload 16
    //   920: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   923: aload 16
    //   925: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   928: aload 16
    //   930: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   933: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   936: iload 7
    //   938: iadd
    //   939: istore 5
    //   941: iload 9
    //   943: istore 4
    //   945: getstatic 156	java/lang/System:out	Ljava/io/PrintStream;
    //   948: new 208	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   955: ldc_w 1849
    //   958: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: iload 5
    //   963: invokestatic 1853	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   966: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokevirtual 163	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   975: iload 9
    //   977: istore 4
    //   979: aload 16
    //   981: iload 5
    //   983: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   986: pop
    //   987: iload 9
    //   989: istore 4
    //   991: iload 8
    //   993: newarray <illegal type>
    //   995: astore 17
    //   997: iconst_0
    //   998: istore 5
    //   1000: iload 5
    //   1002: iload 8
    //   1004: if_icmpge +47 -> 1051
    //   1007: iload 9
    //   1009: istore 4
    //   1011: aload 17
    //   1013: iload 5
    //   1015: aload 16
    //   1017: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   1020: aload 16
    //   1022: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   1025: aload 16
    //   1027: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   1030: aload 16
    //   1032: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   1035: invokestatic 599	com/chelpus/Utils:convertFourBytesToInt	(BBBB)I
    //   1038: iload 7
    //   1040: iadd
    //   1041: iastore
    //   1042: iload 5
    //   1044: iconst_1
    //   1045: iadd
    //   1046: istore 5
    //   1048: goto -48 -> 1000
    //   1051: iload 9
    //   1053: istore 4
    //   1055: aload 17
    //   1057: arraylength
    //   1058: istore 11
    //   1060: iconst_0
    //   1061: istore 4
    //   1063: iload 6
    //   1065: istore 5
    //   1067: iload 4
    //   1069: istore 6
    //   1071: iload 6
    //   1073: iload 11
    //   1075: if_icmpge +333 -> 1408
    //   1078: aload 17
    //   1080: iload 6
    //   1082: iaload
    //   1083: istore 7
    //   1085: iload 5
    //   1087: istore 4
    //   1089: aload 16
    //   1091: iload 7
    //   1093: invokevirtual 602	java/nio/MappedByteBuffer:get	(I)B
    //   1096: invokestatic 606	com/chelpus/Utils:convertByteToInt	(B)I
    //   1099: istore 12
    //   1101: iload 5
    //   1103: istore 4
    //   1105: iload 12
    //   1107: newarray <illegal type>
    //   1109: astore 18
    //   1111: iload 7
    //   1113: iconst_1
    //   1114: iadd
    //   1115: istore 13
    //   1117: iload 5
    //   1119: istore 4
    //   1121: aload 16
    //   1123: iload 13
    //   1125: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1128: pop
    //   1129: iconst_0
    //   1130: istore 7
    //   1132: iload 5
    //   1134: istore 4
    //   1136: iload 7
    //   1138: aload 18
    //   1140: arraylength
    //   1141: if_icmpge +331 -> 1472
    //   1144: iload 5
    //   1146: istore 4
    //   1148: aload 18
    //   1150: iload 7
    //   1152: aload 16
    //   1154: invokevirtual 522	java/nio/MappedByteBuffer:get	()B
    //   1157: bastore
    //   1158: iload 7
    //   1160: iconst_1
    //   1161: iadd
    //   1162: istore 7
    //   1164: goto -32 -> 1132
    //   1167: iload 5
    //   1169: istore 4
    //   1171: iload 7
    //   1173: aload_1
    //   1174: arraylength
    //   1175: if_icmpge +329 -> 1504
    //   1178: iload 5
    //   1180: istore 4
    //   1182: aload_1
    //   1183: iload 7
    //   1185: invokestatic 2776	java/lang/reflect/Array:get	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   1188: checkcast 2777	[B
    //   1191: checkcast 2777	[B
    //   1194: astore 19
    //   1196: iload 5
    //   1198: istore 4
    //   1200: iload 5
    //   1202: istore 9
    //   1204: aload 19
    //   1206: arraylength
    //   1207: iload 12
    //   1209: if_icmpge +282 -> 1491
    //   1212: iload 5
    //   1214: istore 4
    //   1216: iload 5
    //   1218: istore 9
    //   1220: aload 19
    //   1222: arraylength
    //   1223: iconst_2
    //   1224: if_icmple +267 -> 1491
    //   1227: iconst_0
    //   1228: istore 8
    //   1230: iload 5
    //   1232: istore 4
    //   1234: iload 5
    //   1236: istore 9
    //   1238: iload 8
    //   1240: aload 18
    //   1242: arraylength
    //   1243: if_icmpge +248 -> 1491
    //   1246: iload 5
    //   1248: istore 10
    //   1250: aload 18
    //   1252: iload 8
    //   1254: baload
    //   1255: aload 19
    //   1257: iconst_0
    //   1258: baload
    //   1259: if_icmpne +219 -> 1478
    //   1262: iconst_1
    //   1263: istore 9
    //   1265: iload 5
    //   1267: istore 4
    //   1269: iload 5
    //   1271: istore 10
    //   1273: iload 9
    //   1275: aload 19
    //   1277: arraylength
    //   1278: if_icmpge +200 -> 1478
    //   1281: iload 5
    //   1283: istore 4
    //   1285: iload 5
    //   1287: istore 10
    //   1289: iload 8
    //   1291: iload 9
    //   1293: iadd
    //   1294: aload 18
    //   1296: arraylength
    //   1297: if_icmpge +181 -> 1478
    //   1300: iload 5
    //   1302: istore 10
    //   1304: aload 18
    //   1306: iload 8
    //   1308: iload 9
    //   1310: iadd
    //   1311: baload
    //   1312: aload 19
    //   1314: iload 9
    //   1316: baload
    //   1317: if_icmpne +161 -> 1478
    //   1320: iload 9
    //   1322: iconst_1
    //   1323: iadd
    //   1324: istore 10
    //   1326: iload 10
    //   1328: istore 9
    //   1330: iload 5
    //   1332: istore 4
    //   1334: iload 10
    //   1336: aload 19
    //   1338: arraylength
    //   1339: if_icmpne -74 -> 1265
    //   1342: iload 5
    //   1344: istore 4
    //   1346: aload 19
    //   1348: arraylength
    //   1349: iconst_2
    //   1350: if_icmple +35 -> 1385
    //   1353: iload 5
    //   1355: istore 4
    //   1357: aload 16
    //   1359: iload 13
    //   1361: iload 8
    //   1363: iadd
    //   1364: aload 19
    //   1366: arraylength
    //   1367: iconst_1
    //   1368: isub
    //   1369: iadd
    //   1370: invokevirtual 515	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1373: pop
    //   1374: iload 5
    //   1376: istore 4
    //   1378: aload 16
    //   1380: iload_3
    //   1381: invokevirtual 530	java/nio/MappedByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1384: pop
    //   1385: iload 5
    //   1387: istore 4
    //   1389: aload 16
    //   1391: invokevirtual 534	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   1394: pop
    //   1395: iload 5
    //   1397: iconst_1
    //   1398: iadd
    //   1399: istore 5
    //   1401: iload 10
    //   1403: istore 9
    //   1405: goto -140 -> 1265
    //   1408: iload 5
    //   1410: istore 4
    //   1412: aload_0
    //   1413: invokevirtual 525	java/nio/channels/FileChannel:close	()V
    //   1416: iload 5
    //   1418: ireturn
    //   1419: astore_0
    //   1420: iload 4
    //   1422: istore 5
    //   1424: aload_0
    //   1425: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   1428: iload 4
    //   1430: ireturn
    //   1431: iconst_0
    //   1432: istore 7
    //   1434: goto -964 -> 470
    //   1437: iload 8
    //   1439: iconst_1
    //   1440: iadd
    //   1441: istore 8
    //   1443: iload 10
    //   1445: istore 5
    //   1447: goto -914 -> 533
    //   1450: iload 7
    //   1452: iconst_1
    //   1453: iadd
    //   1454: istore 7
    //   1456: iload 9
    //   1458: istore 5
    //   1460: goto -990 -> 470
    //   1463: iload 6
    //   1465: iconst_1
    //   1466: iadd
    //   1467: istore 6
    //   1469: goto -1095 -> 374
    //   1472: iconst_0
    //   1473: istore 7
    //   1475: goto -308 -> 1167
    //   1478: iload 8
    //   1480: iconst_1
    //   1481: iadd
    //   1482: istore 8
    //   1484: iload 10
    //   1486: istore 5
    //   1488: goto -258 -> 1230
    //   1491: iload 7
    //   1493: iconst_1
    //   1494: iadd
    //   1495: istore 7
    //   1497: iload 9
    //   1499: istore 5
    //   1501: goto -334 -> 1167
    //   1504: iload 6
    //   1506: iconst_1
    //   1507: iadd
    //   1508: istore 6
    //   1510: goto -439 -> 1071
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1513	0	paramString	String
    //   0	1513	1	paramArrayOfByte	byte[][]
    //   0	1513	2	paramBoolean	boolean
    //   0	1513	3	paramByte	byte
    //   84	1345	4	i	int
    //   96	1404	5	j	int
    //   39	1470	6	k	int
    //   45	1451	7	m	int
    //   30	1453	8	n	int
    //   42	1456	9	i1	int
    //   27	1458	10	i2	int
    //   33	1043	11	i3	int
    //   36	1174	12	i4	int
    //   418	946	13	i5	int
    //   127	7	14	l	long
    //   201	1189	16	localMappedByteBuffer	MappedByteBuffer
    //   283	796	17	localObject	Object
    //   412	893	18	arrayOfByte1	byte[]
    //   497	868	19	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   168	183	726	java/lang/Exception
    //   187	203	726	java/lang/Exception
    //   207	215	726	java/lang/Exception
    //   219	244	726	java/lang/Exception
    //   248	273	726	java/lang/Exception
    //   277	285	726	java/lang/Exception
    //   289	297	726	java/lang/Exception
    //   301	307	726	java/lang/Exception
    //   321	349	726	java/lang/Exception
    //   362	367	726	java/lang/Exception
    //   392	404	726	java/lang/Exception
    //   408	414	726	java/lang/Exception
    //   424	432	726	java/lang/Exception
    //   439	447	726	java/lang/Exception
    //   451	461	726	java/lang/Exception
    //   474	481	726	java/lang/Exception
    //   485	499	726	java/lang/Exception
    //   507	515	726	java/lang/Exception
    //   523	530	726	java/lang/Exception
    //   541	549	726	java/lang/Exception
    //   576	584	726	java/lang/Exception
    //   592	603	726	java/lang/Exception
    //   637	645	726	java/lang/Exception
    //   649	656	726	java/lang/Exception
    //   660	677	726	java/lang/Exception
    //   681	688	726	java/lang/Exception
    //   692	698	726	java/lang/Exception
    //   715	719	726	java/lang/Exception
    //   144	156	738	java/lang/Exception
    //   731	735	738	java/lang/Exception
    //   98	112	750	java/lang/Exception
    //   116	129	750	java/lang/Exception
    //   743	747	750	java/lang/Exception
    //   765	777	750	java/lang/Exception
    //   1424	1428	750	java/lang/Exception
    //   789	804	1419	java/lang/Exception
    //   808	824	1419	java/lang/Exception
    //   828	836	1419	java/lang/Exception
    //   840	865	1419	java/lang/Exception
    //   869	880	1419	java/lang/Exception
    //   884	909	1419	java/lang/Exception
    //   913	941	1419	java/lang/Exception
    //   945	975	1419	java/lang/Exception
    //   979	987	1419	java/lang/Exception
    //   991	997	1419	java/lang/Exception
    //   1011	1042	1419	java/lang/Exception
    //   1055	1060	1419	java/lang/Exception
    //   1089	1101	1419	java/lang/Exception
    //   1105	1111	1419	java/lang/Exception
    //   1121	1129	1419	java/lang/Exception
    //   1136	1144	1419	java/lang/Exception
    //   1148	1158	1419	java/lang/Exception
    //   1171	1178	1419	java/lang/Exception
    //   1182	1196	1419	java/lang/Exception
    //   1204	1212	1419	java/lang/Exception
    //   1220	1227	1419	java/lang/Exception
    //   1238	1246	1419	java/lang/Exception
    //   1273	1281	1419	java/lang/Exception
    //   1289	1300	1419	java/lang/Exception
    //   1334	1342	1419	java/lang/Exception
    //   1346	1353	1419	java/lang/Exception
    //   1357	1374	1419	java/lang/Exception
    //   1378	1385	1419	java/lang/Exception
    //   1389	1395	1419	java/lang/Exception
    //   1412	1416	1419	java/lang/Exception
  }
  
  public static void setTitle(AlertDialog.Builder paramBuilder, int paramInt, String paramString)
  {
    LinearLayout localLinearLayout = (LinearLayout)View.inflate(listAppsFragment.frag.getContext(), 2130968610, null);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131558434);
    ((ImageView)localLinearLayout.findViewById(2131558433)).setImageDrawable(listAppsFragment.getRes().getDrawable(paramInt));
    localTextView.setText(paramString);
    paramBuilder.setCustomTitle(localLinearLayout);
  }
  
  public static String sha1withrsa_sign(String paramString)
  {
    String str1 = "";
    String str2 = str1;
    String str3 = str1;
    String str4 = str1;
    try
    {
      Object localObject = KeyPairGenerator.getInstance("RSA").generateKeyPair().getPrivate();
      str2 = str1;
      str3 = str1;
      str4 = str1;
      java.security.Signature localSignature = java.security.Signature.getInstance("SHA1withRSA");
      str2 = str1;
      str3 = str1;
      str4 = str1;
      localSignature.initSign((PrivateKey)localObject);
      str2 = str1;
      str3 = str1;
      str4 = str1;
      localSignature.update(paramString.getBytes());
      str2 = str1;
      str3 = str1;
      str4 = str1;
      localObject = localSignature.sign();
      str2 = str1;
      str3 = str1;
      str4 = str1;
      paramString = Base64.encode((byte[])localObject);
      str2 = paramString;
      str3 = paramString;
      str4 = paramString;
      System.out.println("b64: " + Base64.encode((byte[])localObject));
      str2 = paramString;
      str3 = paramString;
      str4 = paramString;
      System.out.println("Signature: " + new String((byte[])localObject));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return str2;
    }
    catch (SignatureException paramString)
    {
      paramString.printStackTrace();
      return str3;
    }
    catch (InvalidKeyException paramString)
    {
      paramString.printStackTrace();
    }
    return str4;
  }
  
  public static void showDialog(Dialog paramDialog)
  {
    try
    {
      if ((listAppsFragment.patchAct != null) && (!listAppsFragment.patchAct.isFinishing())) {
        paramDialog.show();
      }
      return;
    }
    catch (Exception paramDialog)
    {
      paramDialog.printStackTrace();
    }
  }
  
  public static void showDialogCustomYes(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    try
    {
      if ((listAppsFragment.patchAct != null) && (!listAppsFragment.patchAct.isFinishing()))
      {
        paramString1 = new AlertDlg(listAppsFragment.frag.getContext()).setTitle(paramString1).setMessage(paramString2).setIcon(2130837554).setPositiveButton(paramString3, paramOnClickListener1).setNegativeButton(getText(2131165563), paramOnClickListener2).setOnCancelListener(paramOnCancelListener).create();
        showDialog(paramString1);
        paramString1.findViewById(16908299);
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void showDialogCustomYesNo(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    try
    {
      if ((listAppsFragment.patchAct != null) && (!listAppsFragment.patchAct.isFinishing()))
      {
        paramString1 = new AlertDlg(listAppsFragment.frag.getContext()).setTitle(paramString1).setMessage(paramString2).setIcon(2130837554).setPositiveButton(paramString3, paramOnClickListener1).setNegativeButton(paramString4, paramOnClickListener2).setOnCancelListener(paramOnCancelListener).create();
        showDialog(paramString1);
        paramString1.findViewById(16908299);
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void showDialogYesNo(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    try
    {
      if ((listAppsFragment.patchAct != null) && (!listAppsFragment.patchAct.isFinishing()))
      {
        paramString1 = new AlertDlg(listAppsFragment.frag.getContext()).setTitle(paramString1).setMessage(paramString2).setIcon(2130837554).setPositiveButton(getText(2131165187), paramOnClickListener1).setNegativeButton(getText(2131165563), paramOnClickListener2).setOnCancelListener(paramOnCancelListener).create();
        showDialog(paramString1);
        paramString1.findViewById(16908299);
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void showDialogYesNoAndCheckBox(String paramString1, String paramString2, String paramString3, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    try
    {
      if ((listAppsFragment.patchAct != null) && (!listAppsFragment.patchAct.isFinishing()))
      {
        paramString1 = new AlertDlg(listAppsFragment.frag.getContext()).setTitle(paramString1).setMessage(paramString2).setIcon(2130837554).setPositiveButton(getText(2131165187), paramOnClickListener1).setNegativeButton(getText(2131165563), paramOnClickListener2).setOnCancelListener(paramOnCancelListener).setCheckBox(paramString3, paramOnCheckedChangeListener, paramBoolean).create();
        showDialog(paramString1);
        paramString1.findViewById(16908299);
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void showMessage(Activity paramActivity, final String paramString1, final String paramString2)
  {
    paramActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        AlertDlg localAlertDlg = new AlertDlg(this.val$context);
        localAlertDlg.setTitle(paramString1);
        localAlertDlg.setMessage(paramString2);
        localAlertDlg.setPositiveButton(2131165587, null);
        try
        {
          Utils.showDialog(localAlertDlg.create());
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
  }
  
  public static void showSystemWindow(String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    WindowManager localWindowManager = (WindowManager)listAppsFragment.getInstance().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.gravity = 17;
    localLayoutParams.type = 2003;
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.alpha = 1.0F;
    localLayoutParams.packageName = listAppsFragment.getInstance().getPackageName();
    localLayoutParams.buttonBrightness = 1.0F;
    localLayoutParams.windowAnimations = 16973826;
    View localView = View.inflate(listAppsFragment.getInstance(), 2130968635, null);
    Button localButton1 = (Button)localView.findViewById(2131558407);
    Button localButton2 = (Button)localView.findViewById(2131558408);
    TextView localTextView = (TextView)localView.findViewById(2131558631);
    ((TextView)localView.findViewById(2131558486)).setText(paramString1);
    localTextView.setText(paramString2);
    localButton1.setOnClickListener(paramOnClickListener1);
    localButton2.setOnClickListener(paramOnClickListener2);
    localButton1.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        System.out.println("keyCode " + paramAnonymousInt);
        if (paramAnonymousInt == 4) {
          this.val$manager.removeView(paramAnonymousView.getRootView());
        }
        return false;
      }
    });
    localWindowManager.addView(localView, localLayoutParams);
  }
  
  public static void showSystemWindowOk(String paramString1, String paramString2)
  {
    WindowManager localWindowManager = (WindowManager)listAppsFragment.getInstance().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.gravity = 17;
    localLayoutParams.type = 2003;
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.alpha = 1.0F;
    localLayoutParams.packageName = listAppsFragment.getInstance().getPackageName();
    localLayoutParams.buttonBrightness = 1.0F;
    localLayoutParams.windowAnimations = 2131230725;
    View localView = View.inflate(listAppsFragment.getInstance(), 2130968636, null);
    Button localButton = (Button)localView.findViewById(2131558632);
    TextView localTextView = (TextView)localView.findViewById(2131558631);
    ((TextView)localView.findViewById(2131558486)).setText(paramString1);
    localTextView.setText(paramString2);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$manager.removeView(paramAnonymousView.getRootView());
      }
    });
    localButton.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        System.out.println("keyCode " + paramAnonymousInt);
        if (paramAnonymousInt == 4) {
          this.val$manager.removeView(paramAnonymousView.getRootView());
        }
        return false;
      }
    });
    localWindowManager.addView(localView, localLayoutParams);
  }
  
  public static void startApp(String paramString)
  {
    Object localObject2 = listAppsFragment.getPkgMng().getLaunchIntentForPackage(paramString);
    if (paramString == null) {
      System.out.println("Error LP: pkgname is null");
    }
    if (localObject2 == null) {
      System.out.println("Error LP: launch intent is null");
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new Intent("android.intent.action.MAIN", null);
      ((Intent)localObject1).addCategory("android.intent.category.LAUNCHER");
      Object localObject3 = listAppsFragment.getPkgMng().queryIntentActivities((Intent)localObject1, 0);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (ResolveInfo)((Iterator)localObject3).next();
        } while (!((ResolveInfo)localObject1).activityInfo.packageName.equals(paramString));
        localObject1 = ((ResolveInfo)localObject1).activityInfo;
        localObject2 = new ComponentName(((ActivityInfo)localObject1).applicationInfo.packageName, ((ActivityInfo)localObject1).name);
        localObject1 = new Intent("android.intent.action.MAIN");
        ((Intent)localObject1).addCategory("android.intent.category.LAUNCHER");
        ((Intent)localObject1).setComponent((ComponentName)localObject2);
      }
    }
    if (listAppsFragment.su) {
      if (localObject1 != null) {
        new Utils("").cmdRoot(new String[] { "am start -n " + paramString + "/" + ((Intent)localObject1).getComponent().getClassName() });
      }
    }
    while ((listAppsFragment.patchAct == null) || (localObject1 == null)) {
      return;
    }
    listAppsFragment.patchAct.startActivity((Intent)localObject1);
  }
  
  public static void startRootJava()
  {
    System.out.println("SU Java-Code Running!");
    listAppsFragment.startUnderRoot = Boolean.valueOf(true);
    listAppsFragment.toolfilesdir = "";
    new File("/data/lp");
    Object localObject = new File("/data/lp/lp_utils");
    if (!((File)localObject).exists()) {}
    int i;
    do
    {
      do
      {
        return;
        localObject = read_from_file((File)localObject).split("%chelpus%");
      } while ((localObject == null) || (localObject.length <= 0));
      i = 0;
    } while (i >= localObject.length);
    switch (i)
    {
    }
    for (;;)
    {
      i += 1;
      break;
      listAppsFragment.toolfilesdir = localObject[i];
      continue;
      listAppsFragment.api = Integer.parseInt(localObject[i]);
      listAppsFragment.runtime = localObject[i];
      listAppsFragment.selinux = localObject[i];
    }
  }
  
  public static void startRootJava(Object paramObject)
  {
    if (paramObject != null) {
      System.out.println("SU Java-Code Running! " + paramObject.getClass().getEnclosingClass().getName());
    }
    listAppsFragment.startUnderRoot = Boolean.valueOf(true);
    listAppsFragment.toolfilesdir = "";
    new File("/data/lp");
    Object localObject = new File("/data/lp/lp_utils");
    if (!((File)localObject).exists()) {
      if (paramObject != null) {
        System.out.println("Lucky Patcher not found utils.");
      }
    }
    do
    {
      do
      {
        return;
        localObject = read_from_file((File)localObject).split("%chelpus%");
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          if (i < localObject.length)
          {
            switch (i)
            {
            }
            for (;;)
            {
              i += 1;
              break;
              listAppsFragment.toolfilesdir = localObject[i];
              continue;
              listAppsFragment.api = Integer.parseInt(localObject[i]);
              listAppsFragment.runtime = localObject[i];
              listAppsFragment.selinux = localObject[i];
            }
          }
        }
        if (paramObject != null) {
          System.out.println("tools read:" + listAppsFragment.toolfilesdir + "/busybox");
        }
      } while (!new File(listAppsFragment.toolfilesdir + "/busybox").exists());
      if (paramObject != null)
      {
        System.out.println("Lucky Patcher found utils.");
        return;
      }
    } while (paramObject == null);
    System.out.println("Lucky Patcher not found busybox util.");
  }
  
  public static final void turn_off_patch_on_boot(String paramString)
  {
    String str = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
    if (paramString.contains("patch1")) {
      listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", str.replaceAll("patch1", "")).commit();
    }
    str = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
    if (paramString.contains("patch2")) {
      listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", str.replaceAll("patch2", "")).commit();
    }
    str = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
    if (paramString.contains("patch3")) {
      listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", str.replaceAll("patch3", "")).commit();
    }
  }
  
  public static final void turn_off_patch_on_boot_all()
  {
    listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", "").commit();
  }
  
  public static final void turn_on_patch_on_boot(String paramString)
  {
    String str = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
    if (paramString.contains("patch1")) {
      listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", str.replaceAll("patch1", "") + "patch1").commit();
    }
    str = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
    if (paramString.contains("patch2")) {
      listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", str.replaceAll("patch2", "") + "patch2").commit();
    }
    str = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
    if (paramString.contains("patch3")) {
      listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", str.replaceAll("patch3", "") + "patch3").commit();
    }
  }
  
  public static void verify_and_run(String paramString1, String paramString2)
  {
    listAppsFragment.errorOutput = "";
    new Utils("").cmdRoot(new String[] { paramString1 + " " + paramString2 });
    if (!listAppsFragment.errorOutput.equals("")) {
      new Utils("").cmdRoot(new String[] { "busybox " + paramString1 + " " + paramString2 });
    }
    if (!listAppsFragment.errorOutput.equals("")) {
      new Utils("").cmdRoot(new String[] { listAppsFragment.toolfilesdir + "/busybox " + paramString1 + " " + paramString2 });
    }
  }
  
  public static void verify_bind_and_run(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString4.trim().startsWith("~chelpus_disabled~")) {}
    for (;;)
    {
      return;
      String str2 = paramString3.trim();
      String str1 = paramString4.trim();
      if (!str2.endsWith("/"))
      {
        paramString3 = str2.trim() + "/";
        label60:
        if (str1.endsWith("/")) {
          break label997;
        }
        paramString4 = str1.trim() + "/";
        label94:
        new File(str1).mkdirs();
        new File(str2).mkdirs();
        if (!new File(str1).exists()) {
          verify_and_run("mkdir", "-p '" + str1 + "'");
        }
        if (!new File(str2).exists()) {
          verify_and_run("mkdir", "-p '" + str2 + "'");
        }
      }
      try
      {
        new File(paramString3 + "test.txt").createNewFile();
        run_all("echo '' >'" + paramString3 + "test.txt'");
        if (!exists(paramString4 + "test.txt"))
        {
          run_all("umount '" + str1 + "'");
          System.out.println("data: " + paramString3 + "test.txt");
          System.out.println("target: " + paramString4 + "test.txt");
        }
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          try
          {
            new File(paramString3 + "test.txt").createNewFile();
            run_all("echo '' >'" + paramString3 + "test.txt'");
            if (!exists(paramString4 + "test.txt")) {
              new Utils("").cmdRoot(new String[] { "busybox " + paramString1 + " " + paramString2 });
            }
          }
          catch (IOException localIOException3)
          {
            try
            {
              new File(paramString3 + "test.txt").createNewFile();
              run_all("echo '' >'" + paramString3 + "test.txt'");
              if (!exists(paramString4 + "test.txt"))
              {
                new Utils("").cmdRoot(new String[] { listAppsFragment.toolfilesdir + "/busybox " + paramString1 + " " + paramString2 });
                new Utils("").cmdRoot(new String[] { "busybox " + paramString1 + " " + paramString2 });
              }
            }
            catch (IOException localIOException3)
            {
              try
              {
                new File(paramString3 + "test.txt").createNewFile();
                run_all("echo '' >'" + paramString3 + "test.txt'");
                if (!exists(paramString4 + "test.txt")) {
                  System.out.println("LuckyPatcher(Binder error): bind not created!");
                }
                if (!exists(paramString3 + "test.txt")) {
                  break;
                }
                if (!exists(paramString4 + "test.txt")) {
                  break label1077;
                }
                System.out.println("LuckyPatcher(Binder): " + str1 + " binded!");
                new File(paramString3 + "test.txt").delete();
                if (!exists(paramString3 + "test.txt")) {
                  break;
                }
                run_all("rm '" + paramString3 + "test.txt'");
                return;
                paramString3 = str2;
                break label60;
                label997:
                paramString4 = str1;
                break label94;
                localIOException1 = localIOException1;
                localIOException1.printStackTrace();
                continue;
                localIOException2 = localIOException2;
                localIOException2.printStackTrace();
                continue;
                localIOException3 = localIOException3;
                localIOException3.printStackTrace();
              }
              catch (IOException paramString1)
              {
                paramString1.printStackTrace();
                continue;
              }
            }
          }
          System.out.println("LuckyPatcher(Binder): " + str1 + " exists!");
          continue;
          label1077:
          System.out.println("LuckyPatcher(Binder error): " + str1 + " not binded!");
        }
      }
    }
  }
  
  /* Error */
  public static void zip(String paramString1, String paramString2, ArrayList<File> paramArrayList, String paramString3)
  {
    // Byte code:
    //   0: new 3075	java/util/zip/ZipOutputStream
    //   3: dup
    //   4: new 3077	java/io/BufferedOutputStream
    //   7: dup
    //   8: new 135	java/io/FileOutputStream
    //   11: dup
    //   12: aload_3
    //   13: iconst_0
    //   14: invokespecial 3080	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   17: invokespecial 3081	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: invokespecial 3082	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore_3
    //   24: sipush 4096
    //   27: newarray <illegal type>
    //   29: astore 5
    //   31: aload_2
    //   32: invokevirtual 298	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   35: astore 6
    //   37: aconst_null
    //   38: astore_0
    //   39: aload 6
    //   41: invokeinterface 303 1 0
    //   46: ifeq +226 -> 272
    //   49: aload 6
    //   51: invokeinterface 307 1 0
    //   56: checkcast 171	java/io/File
    //   59: astore 7
    //   61: new 128	java/io/FileInputStream
    //   64: dup
    //   65: new 208	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   72: aload_1
    //   73: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc -54
    //   78: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 7
    //   83: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   86: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokespecial 373	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   95: astore 8
    //   97: new 3084	java/io/BufferedInputStream
    //   100: dup
    //   101: aload 8
    //   103: sipush 4096
    //   106: invokespecial 3087	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   109: astore_0
    //   110: aload_3
    //   111: new 912	java/util/zip/ZipEntry
    //   114: dup
    //   115: aload 7
    //   117: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   120: invokespecial 1156	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   123: invokevirtual 3088	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   126: aload_0
    //   127: aload 5
    //   129: iconst_0
    //   130: sipush 4096
    //   133: invokevirtual 3090	java/io/BufferedInputStream:read	([BII)I
    //   136: istore 4
    //   138: iload 4
    //   140: iconst_m1
    //   141: if_icmpeq +115 -> 256
    //   144: aload_3
    //   145: aload 5
    //   147: iconst_0
    //   148: iload 4
    //   150: invokevirtual 3091	java/util/zip/ZipOutputStream:write	([BII)V
    //   153: goto -27 -> 126
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   161: new 171	java/io/File
    //   164: dup
    //   165: new 208	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   172: aload_1
    //   173: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 1344
    //   179: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   188: invokevirtual 195	java/io/File:delete	()Z
    //   191: pop
    //   192: aload_2
    //   193: invokevirtual 298	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   196: astore_0
    //   197: aload_0
    //   198: invokeinterface 303 1 0
    //   203: ifeq +175 -> 378
    //   206: aload_0
    //   207: invokeinterface 307 1 0
    //   212: checkcast 171	java/io/File
    //   215: astore_2
    //   216: new 171	java/io/File
    //   219: dup
    //   220: new 208	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   227: aload_1
    //   228: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc -54
    //   233: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_2
    //   237: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   240: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   249: invokevirtual 195	java/io/File:delete	()Z
    //   252: pop
    //   253: goto -56 -> 197
    //   256: aload_0
    //   257: invokevirtual 3092	java/io/BufferedInputStream:close	()V
    //   260: aload_3
    //   261: invokevirtual 3093	java/util/zip/ZipOutputStream:closeEntry	()V
    //   264: aload 8
    //   266: invokevirtual 376	java/io/FileInputStream:close	()V
    //   269: goto -230 -> 39
    //   272: new 128	java/io/FileInputStream
    //   275: dup
    //   276: new 208	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   283: aload_1
    //   284: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 1344
    //   290: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokespecial 373	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   299: astore_0
    //   300: new 3084	java/io/BufferedInputStream
    //   303: dup
    //   304: aload_0
    //   305: sipush 4096
    //   308: invokespecial 3087	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   311: astore 6
    //   313: aload_3
    //   314: new 912	java/util/zip/ZipEntry
    //   317: dup
    //   318: ldc_w 3095
    //   321: invokespecial 1156	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   324: invokevirtual 3088	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   327: aload 6
    //   329: aload 5
    //   331: iconst_0
    //   332: sipush 4096
    //   335: invokevirtual 3090	java/io/BufferedInputStream:read	([BII)I
    //   338: istore 4
    //   340: iload 4
    //   342: iconst_m1
    //   343: if_icmpeq +15 -> 358
    //   346: aload_3
    //   347: aload 5
    //   349: iconst_0
    //   350: iload 4
    //   352: invokevirtual 3091	java/util/zip/ZipOutputStream:write	([BII)V
    //   355: goto -28 -> 327
    //   358: aload 6
    //   360: invokevirtual 3092	java/io/BufferedInputStream:close	()V
    //   363: aload_3
    //   364: invokevirtual 3093	java/util/zip/ZipOutputStream:closeEntry	()V
    //   367: aload_3
    //   368: invokevirtual 3096	java/util/zip/ZipOutputStream:close	()V
    //   371: aload_0
    //   372: invokevirtual 376	java/io/FileInputStream:close	()V
    //   375: goto -214 -> 161
    //   378: return
    //   379: astore_0
    //   380: goto -223 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramString1	String
    //   0	383	1	paramString2	String
    //   0	383	2	paramArrayList	ArrayList<File>
    //   0	383	3	paramString3	String
    //   136	215	4	i	int
    //   29	319	5	arrayOfByte	byte[]
    //   35	324	6	localObject	Object
    //   59	57	7	localFile	File
    //   95	170	8	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   0	37	156	java/lang/Exception
    //   110	126	156	java/lang/Exception
    //   126	138	156	java/lang/Exception
    //   144	153	156	java/lang/Exception
    //   256	269	156	java/lang/Exception
    //   313	327	156	java/lang/Exception
    //   327	340	156	java/lang/Exception
    //   346	355	156	java/lang/Exception
    //   358	375	156	java/lang/Exception
    //   39	110	379	java/lang/Exception
    //   272	313	379	java/lang/Exception
  }
  
  public static String zipART(String paramString1, String paramString2, ArrayList<File> paramArrayList, String paramString3)
  {
    Object localObject4 = "";
    Object localObject3 = "";
    run_all_no_root(new String[] { "chmod", "777", "/data/tmp" });
    Object localObject1 = localObject4;
    Object localObject2 = localObject3;
    for (;;)
    {
      try
      {
        System.out.println("Try create tmp.");
        localObject1 = localObject4;
        localObject2 = localObject3;
        new File("/data/tmp").mkdir();
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (new File("/data/tmp").exists()) {
          continue;
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        System.out.println("tmp dir not found. Try create with root.");
        localObject1 = localObject4;
        localObject2 = localObject3;
        new File("/data/tmp").mkdirs();
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (!new File("/data/tmp").exists())
        {
          localObject1 = localObject4;
          localObject2 = localObject3;
          run_all_no_root(new String[] { "mkdir", "/data/tmp" });
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (new File("/data/tmp").exists()) {
          continue;
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        System.out.println("tmp dir not created.");
      }
      catch (Exception paramString1)
      {
        Object localObject5;
        paramString1.printStackTrace();
        localObject4 = localObject1;
        localObject3 = localObject2;
        if (!new File((String)localObject1).exists()) {
          continue;
        }
        new File((String)localObject1).delete();
        localObject3 = localObject2;
        localObject4 = localObject1;
        new File(paramString2 + "/AndroidManifest.xml").delete();
        paramString1 = paramArrayList.iterator();
        if (!paramString1.hasNext()) {
          continue;
        }
        paramArrayList = (File)paramString1.next();
        new File(paramString2 + "/" + paramArrayList.getName()).delete();
        continue;
        localObject1 = localObject4;
        localObject2 = localObject3;
        run_all_no_root(new String[] { "chmod", "777", "/data/tmp" });
        try
        {
          localObject1 = new File("/data/tmp").listFiles();
          if (localObject1 == null) {
            continue;
          }
          int j = localObject1.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject2 = localObject1[i];
          localObject5 = new Utils("1");
          ((File)localObject2).delete();
          if (((File)localObject2).exists()) {
            ((Utils)localObject5).deleteFolder((File)localObject2);
          }
          i += 1;
          continue;
        }
        catch (Exception localException)
        {
          localObject1 = localObject4;
          localObject2 = localObject3;
          localException.printStackTrace();
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        Object localObject7 = "/data/tmp/" + new String((char[])localObject8) + "/" + paramString1;
        localObject1 = localObject7;
        localObject2 = localObject3;
        Object localObject6 = "/data/tmp/" + new String((char[])localObject8);
        localObject1 = localObject7;
        localObject2 = localObject6;
        new File("/data/tmp/" + new String((char[])localObject8)).mkdirs();
        localObject1 = localObject7;
        localObject2 = localObject6;
        if (!new File("/data/tmp/" + new String((char[])localObject8)).exists()) {
          continue;
        }
        localObject1 = localObject7;
        localObject2 = localObject6;
        System.out.println("Dir delta created.");
        localObject1 = localObject7;
        localObject2 = localObject6;
        System.out.println("Path to create zip: " + (String)localObject7);
        localObject1 = localObject7;
        localObject2 = localObject6;
        System.out.println("Path to origin zip: " + paramString3);
        localObject1 = localObject7;
        localObject2 = localObject6;
        localObject4 = localObject7;
        localObject3 = localObject6;
        if (paramString3.length() != ("/data/tmp/" + paramString1).length()) {
          continue;
        }
        localObject1 = localObject7;
        localObject2 = localObject6;
        localObject4 = "/data/tmp/" + paramString1;
        localObject3 = "";
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (!new File((String)localObject4).exists()) {
          continue;
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        new File((String)localObject4).delete();
        localObject1 = localObject4;
        localObject2 = localObject3;
        paramString1 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream((String)localObject4, false)));
        localObject1 = localObject4;
        localObject2 = localObject3;
        paramString3 = new byte['က'];
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject6 = paramArrayList.iterator();
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (!((Iterator)localObject6).hasNext()) {
          continue;
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject7 = (File)((Iterator)localObject6).next();
        localObject1 = localObject4;
        localObject2 = localObject3;
        Object localObject8 = new FileInputStream(paramString2 + "/" + ((File)localObject7).getName());
        localObject1 = localObject4;
        localObject2 = localObject3;
        BufferedInputStream localBufferedInputStream = new BufferedInputStream((InputStream)localObject8, 4096);
        localObject1 = localObject4;
        localObject2 = localObject3;
        paramString1.putNextEntry(new ZipEntry(((File)localObject7).getName()));
        localObject1 = localObject4;
        localObject2 = localObject3;
        int i = localBufferedInputStream.read(paramString3, 0, 4096);
        if (i == -1) {
          continue;
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        paramString1.write(paramString3, 0, i);
        continue;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localBufferedInputStream.close();
        localObject1 = localObject4;
        localObject2 = localObject3;
        paramString1.closeEntry();
        localObject1 = localObject4;
        localObject2 = localObject3;
        ((FileInputStream)localObject8).close();
        continue;
        localObject1 = localObject4;
        localObject2 = localObject3;
        paramString1.close();
        continue;
        if (!new File((String)localObject4).exists()) {
          continue;
        }
        paramString1 = (String)localObject4;
        if (new File((String)localObject4).length() != 0L) {
          return paramString1;
        }
        if (!new File((String)localObject4).exists()) {
          continue;
        }
        new File((String)localObject4).delete();
        if ((!new File((String)localObject3).exists()) || (!((String)localObject3).contains("1"))) {
          continue;
        }
        new File((String)localObject3).delete();
        paramString1 = "";
      }
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject7 = localObject4;
      localObject5 = localObject3;
      if (paramString3.length() <= ("/data/tmp/" + paramString1).length()) {
        continue;
      }
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject7 = localObject4;
      localObject5 = localObject3;
      if (paramString3.length() - ("/data/tmp/" + paramString1).length() <= 1) {
        continue;
      }
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject8 = new char[paramString3.length() - ("/data/tmp/" + paramString1).length() - 1];
      i = 0;
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (i >= localObject8.length) {
        continue;
      }
      localObject8[i] = 49;
      i += 1;
      continue;
      localObject1 = localObject4;
      localObject2 = localObject3;
      run_all_no_root(new String[] { "chmod", "777", "/data/tmp" });
    }
    return paramString1;
  }
  
  public String cmdRoot(String... paramVarArgs)
  {
    int i = 0;
    Worker localWorker;
    int j;
    try
    {
      if (onMainThread()) {
        throw new ShellOnMainThreadException("Application attempted to run a shell command from the main thread");
      }
    }
    catch (ShellOnMainThreadException localShellOnMainThreadException1)
    {
      localShellOnMainThreadException1.printStackTrace();
      try
      {
        if (listAppsFragment.startUnderRoot.booleanValue()) {
          throw new ShellOnMainThreadException("Application attempted to run a shell command from the main thread");
        }
      }
      catch (ShellOnMainThreadException localShellOnMainThreadException2)
      {
        localShellOnMainThreadException2.printStackTrace();
        if ((!listAppsFragment.su) && (!paramVarArgs[0].equals("checkRoot"))) {
          return "lucky patcher root not found!";
        }
        localWorker = new Worker(null);
        Worker.access$102(localWorker, paramVarArgs);
        localWorker.start();
        j = 0;
      }
    }
    for (;;)
    {
      try
      {
        int k = paramVarArgs.length;
        if (i < k)
        {
          String str = paramVarArgs[i];
          if ((str.contains("-Xbootclasspath:")) || (str.contains("dd ")) || (str.contains("cp ")) || (str.contains("cat "))) {
            break label230;
          }
          if (!str.contains("pm ")) {
            break label232;
          }
          break label230;
        }
        if (j == 0) {
          continue;
        }
        localWorker.join();
      }
      catch (InterruptedException paramVarArgs)
      {
        paramVarArgs = paramVarArgs;
        paramVarArgs.printStackTrace();
        localWorker.interrupt();
        Thread.currentThread().interrupt();
        exitRoot();
        continue;
      }
      finally {}
      return localWorker.result;
      localWorker.join();
      paramVarArgs = localWorker.exitCode;
      if (paramVarArgs == null)
      {
        continue;
        label230:
        j = 1;
        label232:
        i += 1;
      }
    }
  }
  
  public void deleteFolder(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        deleteFolder(arrayOfFile[i]);
        i += 1;
      }
    }
    new File(paramFile.toString()).delete();
  }
  
  public String findFile(File paramFile, String paramString)
    throws IOException
  {
    Object localObject;
    if (!paramFile.exists())
    {
      localObject = "";
      return (String)localObject;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label72;
        }
        String str = findFile(arrayOfFile[i], paramString);
        localObject = str;
        if (!str.equals("")) {
          break;
        }
        i += 1;
      }
    }
    label72:
    if (paramFile.getName().equals(paramString)) {
      return paramFile.getAbsolutePath();
    }
    return "";
  }
  
  public String findFileContainText(File paramFile, String paramString)
    throws IOException
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        String str = findFileContainText(arrayOfFile[i], paramString);
        if (!str.equals("")) {
          return str;
        }
        i += 1;
      }
    }
    if (paramFile.getName().contains(paramString)) {
      return paramFile.getAbsolutePath();
    }
    return "";
  }
  
  public String findFileEndText(File paramFile, String paramString, ArrayList<File> paramArrayList)
    throws IOException
  {
    if (!paramFile.exists()) {
      return "";
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        String str = findFileEndText(arrayOfFile[i], paramString, paramArrayList);
        if (!str.equals("")) {
          addFileToList(new File(str), paramArrayList);
        }
        i += 1;
      }
    }
    if (paramFile.getName().endsWith(paramString))
    {
      addFileToList(paramFile, paramArrayList);
      return paramFile.getAbsolutePath();
    }
    return "";
  }
  
  public void fixOwners(File paramFile, String paramString)
    throws IOException
  {
    run_all_no_root(new String[] { "chown", paramString, paramFile.getAbsolutePath() });
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        run_all_no_root(new String[] { "chown", paramString, paramFile.getAbsolutePath() });
        fixOwners(localFile, paramString);
        i += 1;
      }
    }
  }
  
  public void fixPermissions(File paramFile, String paramString)
    throws IOException
  {
    run_all_no_root(new String[] { "chmod", paramString, paramFile.getAbsolutePath() });
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        run_all_no_root(new String[] { "chmod", paramString, paramFile.getAbsolutePath() });
        fixPermissions(localFile, paramString);
        i += 1;
      }
    }
  }
  
  public String getInput(boolean paramBoolean, Worker paramWorker)
    throws Exception
  {
    Timer localTimer = new Timer();
    Object localObject1 = new RootTimerTask(paramWorker);
    if (!paramWorker.commands[0].contains(".corepatch "))
    {
      localTimer.schedule((TimerTask)localObject1, 600000L);
      System.out.println("Input a string within 3 minuten: ");
    }
    localObject1 = "";
    Object localObject2 = localObject1;
    for (;;)
    {
      try
      {
        paramWorker.input = listAppsFragment.suInputStream;
        localObject2 = localObject1;
        str = readLine(paramWorker.input);
        localObject2 = localObject1;
        if (str != null)
        {
          if (paramBoolean)
          {
            localObject2 = localObject1;
            if (listAppsFragment.progress_loading != null)
            {
              localObject2 = localObject1;
              if (listAppsFragment.progress_loading.isShowing())
              {
                localObject2 = localObject1;
                if (str.contains("Get classes.dex."))
                {
                  localObject2 = localObject1;
                  listAppsFragment.frag.runToMain(new Runnable()
                  {
                    public void run()
                    {
                      if ((listAppsFragment.progress_loading != null) && (listAppsFragment.progress_loading.isShowing()))
                      {
                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131165594));
                        listAppsFragment.progress_loading.setIndeterminate(false, listAppsFragment.frag.getContext());
                      }
                    }
                  });
                }
                localObject2 = localObject1;
                if (str.equals("String analysis."))
                {
                  localObject2 = localObject1;
                  listAppsFragment.frag.runToMain(new Runnable()
                  {
                    public void run()
                    {
                      if ((listAppsFragment.progress_loading != null) && (listAppsFragment.progress_loading.isShowing()))
                      {
                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131165595));
                        listAppsFragment.progress_loading.setIndeterminate(false, listAppsFragment.frag.getContext());
                      }
                    }
                  });
                }
                localObject2 = localObject1;
                if (str.equals("Parse data for patch."))
                {
                  localObject2 = localObject1;
                  listAppsFragment.frag.runToMain(new Runnable()
                  {
                    public void run()
                    {
                      if ((listAppsFragment.progress_loading != null) && (listAppsFragment.progress_loading.isShowing()))
                      {
                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131165593));
                        listAppsFragment.progress_loading.setIndeterminate(false, listAppsFragment.frag.getContext());
                      }
                    }
                  });
                }
                localObject2 = localObject1;
                if (str.startsWith("Progress size:"))
                {
                  localObject2 = localObject1;
                  listAppsFragment.frag.runToMain(new Runnable()
                  {
                    public void run()
                    {
                      if ((listAppsFragment.progress_loading != null) && (listAppsFragment.progress_loading.isShowing())) {
                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131165597));
                      }
                      try
                      {
                        listAppsFragment.progress_loading.setProgress(Integer.valueOf(str.replace("Progress size:", "")).intValue());
                        return;
                      }
                      catch (NumberFormatException localNumberFormatException)
                      {
                        localNumberFormatException.printStackTrace();
                      }
                    }
                  });
                }
                localObject2 = localObject1;
                if (str.startsWith("Size file:"))
                {
                  localObject2 = localObject1;
                  listAppsFragment.frag.runToMain(new Runnable()
                  {
                    public void run()
                    {
                      if ((listAppsFragment.progress_loading != null) && (listAppsFragment.progress_loading.isShowing())) {
                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131165597));
                      }
                      try
                      {
                        listAppsFragment.progress_loading.setMax(Integer.valueOf(str.replace("Size file:", "")).intValue());
                        listAppsFragment.progress_loading.setProgressNumberFormat("%1d/%2d bytes");
                        return;
                      }
                      catch (NumberFormatException localNumberFormatException)
                      {
                        for (;;)
                        {
                          localNumberFormatException.printStackTrace();
                        }
                      }
                    }
                  });
                }
                localObject2 = localObject1;
                if (str.startsWith("Analise Results:"))
                {
                  localObject2 = localObject1;
                  listAppsFragment.frag.runToMain(new Runnable()
                  {
                    public void run()
                    {
                      if ((listAppsFragment.progress_loading != null) && (listAppsFragment.progress_loading.isShowing()))
                      {
                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131165598));
                        listAppsFragment.progress_loading.setMax(6);
                        listAppsFragment.progress_loading.setProgress(3);
                        listAppsFragment.progress_loading.setProgressNumberFormat("%1d/%2d");
                      }
                    }
                  });
                }
                localObject2 = localObject1;
                if (str.startsWith("Create ODEX:"))
                {
                  localObject2 = localObject1;
                  listAppsFragment.frag.runToMain(new Runnable()
                  {
                    public void run()
                    {
                      if ((listAppsFragment.progress_loading != null) && (listAppsFragment.progress_loading.isShowing()))
                      {
                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131165599));
                        listAppsFragment.progress_loading.setProgress(4);
                      }
                    }
                  });
                }
                localObject2 = localObject1;
                if (str.startsWith("Optional Steps After Patch:"))
                {
                  localObject2 = localObject1;
                  listAppsFragment.frag.runToMain(new Runnable()
                  {
                    public void run()
                    {
                      if ((listAppsFragment.progress_loading != null) && (listAppsFragment.progress_loading.isShowing()))
                      {
                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131165600));
                        listAppsFragment.progress_loading.setProgress(6);
                      }
                    }
                  });
                }
              }
            }
          }
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (str.contains("com.chelpus.root.utils.custompatch"))
          {
            localObject2 = localObject1;
            System.out.println((String)localObject1);
            localObject3 = "";
          }
          localObject2 = localObject3;
          boolean bool = str.contains("chelpus done!");
          if (!bool) {
            continue;
          }
          localObject2 = localObject3;
        }
      }
      catch (Exception paramWorker)
      {
        final String str;
        Object localObject3;
        paramWorker = paramWorker;
        paramWorker.printStackTrace();
        continue;
      }
      finally {}
      localTimer.cancel();
      System.out.println("you have entered: " + (String)localObject2);
      return (String)localObject2;
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (!str.contains("chelpusstart!"))
      {
        localObject2 = localObject3;
        localObject1 = (String)localObject3 + str + "\n";
      }
    }
  }
  
  public void setAllReadable(File paramFile)
  {
    try
    {
      paramFile.setReadable(true);
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          paramFile.setReadable(true);
          setAllReadable(localFile);
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return;
    }
    catch (NoSuchMethodError paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  public void setAllWritable(File paramFile)
  {
    try
    {
      paramFile.setWritable(true);
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          paramFile.setWritable(true);
          setAllWritable(localFile);
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return;
    }
    catch (NoSuchMethodError paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  public float sizeFolder(File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      this.folder_size = 0.0F;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        sizeFolder(arrayOfFile[i], false);
        i += 1;
      }
    }
    this.folder_size += (float)new File(paramFile.toString()).length();
    return this.folder_size / 1048576.0F;
  }
  
  /* Error */
  public void waitLP(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 3272	java/lang/System:currentTimeMillis	()J
    //   3: lload_1
    //   4: ladd
    //   5: lstore_1
    //   6: invokestatic 3272	java/lang/System:currentTimeMillis	()J
    //   9: lload_1
    //   10: lcmp
    //   11: ifge +24 -> 35
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: lload_1
    //   18: invokestatic 3272	java/lang/System:currentTimeMillis	()J
    //   21: lsub
    //   22: invokevirtual 3275	java/lang/Object:wait	(J)V
    //   25: aload_0
    //   26: monitorexit
    //   27: goto -21 -> 6
    //   30: astore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_3
    //   34: athrow
    //   35: return
    //   36: astore_3
    //   37: goto -12 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	Utils
    //   0	40	1	paramLong	long
    //   30	4	3	localObject	Object
    //   36	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   16	25	30	finally
    //   25	27	30	finally
    //   31	33	30	finally
    //   16	25	36	java/lang/Exception
  }
  
  class RootTimerTask
    extends TimerTask
  {
    Utils.Worker work = null;
    
    public RootTimerTask(Utils.Worker paramWorker)
    {
      this.work = paramWorker;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: getstatic 32	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:result	Ljava/lang/String;
      //   5: ldc 34
      //   7: invokevirtual 40	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   10: ifeq +262 -> 272
      //   13: getstatic 46	java/lang/System:out	Ljava/io/PrintStream;
      //   16: ldc 48
      //   18: invokevirtual 54	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   21: aload_0
      //   22: getfield 20	com/chelpus/Utils$RootTimerTask:work	Lcom/chelpus/Utils$Worker;
      //   25: invokevirtual 59	com/chelpus/Utils$Worker:interrupt	()V
      //   28: aload_0
      //   29: getfield 20	com/chelpus/Utils$RootTimerTask:work	Lcom/chelpus/Utils$Worker;
      //   32: getfield 63	com/chelpus/Utils$Worker:input	Ljava/io/DataInputStream;
      //   35: invokevirtual 68	java/io/DataInputStream:close	()V
      //   38: getstatic 72	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
      //   41: ifnull +13 -> 54
      //   44: getstatic 72	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
      //   47: astore 4
      //   49: bipush 23
      //   51: invokestatic 76	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:removeDialogLP	(I)V
      //   54: getstatic 72	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
      //   57: astore 4
      //   59: iconst_1
      //   60: invokestatic 76	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:removeDialogLP	(I)V
      //   63: getstatic 72	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
      //   66: astore 4
      //   68: bipush 11
      //   70: invokestatic 76	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:removeDialogLP	(I)V
      //   73: ldc 34
      //   75: astore 5
      //   77: aload 5
      //   79: astore 4
      //   81: aload_0
      //   82: getfield 20	com/chelpus/Utils$RootTimerTask:work	Lcom/chelpus/Utils$Worker;
      //   85: invokestatic 80	com/chelpus/Utils$Worker:access$100	(Lcom/chelpus/Utils$Worker;)[Ljava/lang/String;
      //   88: astore 6
      //   90: aload 5
      //   92: astore 4
      //   94: aload 6
      //   96: arraylength
      //   97: istore_3
      //   98: iconst_0
      //   99: istore_1
      //   100: aload 5
      //   102: astore 4
      //   104: aload 4
      //   106: astore 5
      //   108: iload_1
      //   109: iload_3
      //   110: if_icmpge +53 -> 163
      //   113: aload 6
      //   115: iload_1
      //   116: aaload
      //   117: astore 5
      //   119: new 82	java/lang/StringBuilder
      //   122: dup
      //   123: invokespecial 83	java/lang/StringBuilder:<init>	()V
      //   126: ldc 85
      //   128: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   131: aload 5
      //   133: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   136: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   139: astore 5
      //   141: aload 5
      //   143: astore 4
      //   145: iload_1
      //   146: iconst_1
      //   147: iadd
      //   148: istore_1
      //   149: goto -45 -> 104
      //   152: astore 5
      //   154: aload 5
      //   156: invokevirtual 96	java/lang/Exception:printStackTrace	()V
      //   159: aload 4
      //   161: astore 5
      //   163: getstatic 72	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:frag	Lcom/android/vending/billing/InAppBillingService/LACK/listAppsFragment;
      //   166: ldc 98
      //   168: new 82	java/lang/StringBuilder
      //   171: dup
      //   172: invokespecial 83	java/lang/StringBuilder:<init>	()V
      //   175: ldc 100
      //   177: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   180: aload 5
      //   182: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   185: ldc 102
      //   187: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   190: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   193: invokevirtual 106	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:showMessage	(Ljava/lang/String;Ljava/lang/String;)V
      //   196: aload_0
      //   197: getfield 20	com/chelpus/Utils$RootTimerTask:work	Lcom/chelpus/Utils$Worker;
      //   200: invokestatic 80	com/chelpus/Utils$Worker:access$100	(Lcom/chelpus/Utils$Worker;)[Ljava/lang/String;
      //   203: astore 4
      //   205: aload 4
      //   207: arraylength
      //   208: istore_3
      //   209: iload_2
      //   210: istore_1
      //   211: iload_1
      //   212: iload_3
      //   213: if_icmpge +67 -> 280
      //   216: aload 4
      //   218: iload_1
      //   219: aaload
      //   220: astore 5
      //   222: getstatic 46	java/lang/System:out	Ljava/io/PrintStream;
      //   225: new 82	java/lang/StringBuilder
      //   228: dup
      //   229: invokespecial 83	java/lang/StringBuilder:<init>	()V
      //   232: ldc 108
      //   234: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: aload 5
      //   239: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   242: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   245: invokevirtual 54	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   248: iload_1
      //   249: iconst_1
      //   250: iadd
      //   251: istore_1
      //   252: goto -41 -> 211
      //   255: astore 4
      //   257: aload 4
      //   259: invokevirtual 96	java/lang/Exception:printStackTrace	()V
      //   262: goto -66 -> 196
      //   265: astore 4
      //   267: aload 4
      //   269: invokevirtual 109	java/io/IOException:printStackTrace	()V
      //   272: return
      //   273: astore 4
      //   275: aload 4
      //   277: invokevirtual 96	java/lang/Exception:printStackTrace	()V
      //   280: invokestatic 112	com/chelpus/Utils:exitRoot	()V
      //   283: getstatic 116	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:semaphoreRoot	Ljava/util/concurrent/Semaphore;
      //   286: invokevirtual 121	java/util/concurrent/Semaphore:release	()V
      //   289: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	290	0	this	RootTimerTask
      //   99	153	1	i	int
      //   1	209	2	j	int
      //   97	117	3	k	int
      //   47	170	4	localObject1	Object
      //   255	3	4	localException1	Exception
      //   265	3	4	localIOException	IOException
      //   273	3	4	localException2	Exception
      //   75	67	5	localObject2	Object
      //   152	3	5	localException3	Exception
      //   161	77	5	localObject3	Object
      //   88	26	6	arrayOfString	String[]
      // Exception table:
      //   from	to	target	type
      //   81	90	152	java/lang/Exception
      //   94	98	152	java/lang/Exception
      //   119	141	152	java/lang/Exception
      //   38	54	255	java/lang/Exception
      //   54	73	255	java/lang/Exception
      //   154	159	255	java/lang/Exception
      //   163	196	255	java/lang/Exception
      //   21	38	265	java/io/IOException
      //   38	54	265	java/io/IOException
      //   54	73	265	java/io/IOException
      //   81	90	265	java/io/IOException
      //   94	98	265	java/io/IOException
      //   119	141	265	java/io/IOException
      //   154	159	265	java/io/IOException
      //   163	196	265	java/io/IOException
      //   196	209	265	java/io/IOException
      //   222	248	265	java/io/IOException
      //   257	262	265	java/io/IOException
      //   275	280	265	java/io/IOException
      //   280	289	265	java/io/IOException
      //   196	209	273	java/lang/Exception
      //   222	248	273	java/lang/Exception
    }
  }
  
  private class Worker
    extends Thread
  {
    private String[] commands = null;
    private Integer exitCode = null;
    public DataInputStream input = null;
    private String result = "";
    
    private Worker() {}
    
    public void run()
    {
      int n = 0;
      int m = 0;
      int i2 = 0;
      int i1 = 0;
      boolean bool1 = false;
      Object localObject = this.commands;
      int i3 = localObject.length;
      int j = 0;
      int k;
      int i;
      boolean bool2;
      String str2;
      for (;;)
      {
        k = i2;
        i = m;
        bool2 = bool1;
        if (j >= i3) {
          break;
        }
        str2 = localObject[j];
        if (str2.equals("skipOut")) {
          i1 = 1;
        }
        if (str2.contains("-Xbootclasspath:")) {
          n = 1;
        }
        if ((str2.contains(".runpatchsupport ")) || (str2.contains(".runpatchsupportOld ")) || (str2.contains(".runpatchads ")) || (str2.contains(".odexrunpatch ")) || (str2.contains(".custompatch "))) {
          bool1 = true;
        }
        if (str2.contains(".custompatch ")) {}
        j += 1;
      }
      try
      {
        listAppsFragment.suOutputStream.writeBytes("echo 'chelpus done!'\n");
        listAppsFragment.suOutputStream.flush();
        if (i1 != 0) {
          break label870;
        }
        this.result = Utils.this.getInput(bool2, this);
        bool1 = bool2;
        if (bool2) {
          bool1 = false;
        }
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        System.out.println("LuckyPatcher (result root): root not found.");
        listAppsFragment.semaphoreRoot.release();
        return;
        listAppsFragment.suOutputStream.writeBytes(new String((str2 + "\n").getBytes(), "ISO-8859-1"));
      }
      catch (Exception localException1)
      {
        label301:
        label402:
        localException1.printStackTrace();
        listAppsFragment.semaphoreRoot.release();
        return;
      }
      try
      {
        if (listAppsFragment.suErrorInputStream == null) {
          break label797;
        }
        localObject = new byte[listAppsFragment.suErrorInputStream.available()];
        listAppsFragment.suErrorInputStream.read((byte[])localObject);
        listAppsFragment.errorOutput = new String((byte[])localObject);
        if (listAppsFragment.errorOutput.contains("env: not found")) {
          Utils.exitRoot();
        }
        if (new String((byte[])localObject).trim().equals("")) {
          break label776;
        }
        System.out.println("LuckyApcther root errors: " + listAppsFragment.errorOutput);
        listAppsFragment.errorOutput = new String((byte[])localObject);
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
        Utils.exitRoot();
        break label301;
        if (j == 0) {
          break label829;
        }
        System.out.println("LuckyPatcher (result root): " + this.result);
        if ((!this.result.equals("")) || (j == 0)) {
          break label1000;
        }
        if (n == 0) {
          break label991;
        }
        Utils.exitRoot();
        this.result = "lucky patcher root not found!";
        return;
      }
      catch (Exception localException2)
      {
        label776:
        label797:
        label829:
        localException2.printStackTrace();
        break label301;
      }
      if (n != 0)
      {
        i2 = 0;
        m = i;
        k = j;
        i = m;
        bool2 = bool1;
        if (i2 < this.commands.length)
        {
          i = m;
          if (!this.commands[i2].contains("-Xbootclasspath:")) {
            break label954;
          }
          if ((this.commands[i2].contains("env LD_LIBRARY_PATH=")) || (this.commands[i2].contains(".checkDataSize ")) || (this.commands[i2].contains(".custompatch ")))
          {
            i = 1;
            bool2 = bool1;
            k = j;
          }
        }
        else
        {
          j = k;
          if (!this.result.contains("SU Java-Code Running!"))
          {
            j = k;
            if (i == 0)
            {
              if (this.commands[0].contains("env LD_LIBRARY_PATH=")) {
                System.out.println("re-run Dalvik on root with environment " + this.commands[0]);
              }
              j = k;
              if (this.commands[0].equals("checkRoot"))
              {
                System.out.println("LuckyPatcher: test root.");
                this.commands[0] = "ps init";
                j = 1;
              }
              listAppsFragment.countRoot += 1;
              k = listAppsFragment.countRoot;
              System.out.println("Block root thread" + listAppsFragment.countRoot);
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          if (!listAppsFragment.semaphoreRoot.tryAcquire(300L, TimeUnit.SECONDS))
          {
            System.out.println("Root command timeout. Bad root.");
            Utils.exitRoot();
            listAppsFragment.semaphoreRoot.release();
          }
          listAppsFragment.countRoot -= 1;
          Utils.getRoot();
          System.out.println("UNBlock root thread N" + k);
          localObject = this.commands;
          m = localObject.length;
          k = 0;
          if (k >= m) {
            break;
          }
          str2 = localObject[k];
          if (n != 0) {
            listAppsFragment.suOutputStream.writeBytes(new String((listAppsFragment.toolfilesdir + "/busybox killall dalvikvm\n").getBytes(), "ISO-8859-1"));
          }
          if (!str2.equals("skipOut")) {}
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          continue;
        }
        listAppsFragment.errorOutput = "";
        break label301;
        for (;;)
        {
          label870:
          continue;
          String str1 = System.getenv("LD_LIBRARY_PATH");
          str2 = this.commands[i2];
          if (listAppsFragment.errorOutput.contains("env: not found"))
          {
            this.commands[i2] = ("env LD_LIBRARY_PATH=" + str1 + " " + str2);
            i = m;
            label940:
            if (!this.result.contains("SU Java-Code Running!")) {
              break label971;
            }
            i = 1;
          }
          for (;;)
          {
            label954:
            i2 += 1;
            m = i;
            break;
            i = 1;
            break label940;
            label971:
            this.result = "";
          }
          i = 1;
          k = j;
          bool2 = bool1;
          break label402;
          label991:
          listAppsFragment.semaphoreRoot.release();
        }
        label1000:
        if (this.result.equals("")) {
          this.result = "~";
        }
        if (n != 0)
        {
          Utils.exitRoot();
          return;
        }
        listAppsFragment.semaphoreRoot.release();
        return;
        k += 1;
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */