package com.android.vending.billing.InAppBillingService.LACK;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.DigestOutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.TreeMap;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.security.zipsigner.Base64;
import kellinwood.security.zipsigner.KeySet;
import kellinwood.security.zipsigner.ProgressHelper;
import kellinwood.security.zipsigner.ProgressListener;
import kellinwood.zipio.ZioEntry;
import kellinwood.zipio.ZipInput;
import kellinwood.zipio.ZipOutput;

public class ZipSignerLP
{
  private static final String CERT_RSA_NAME = "META-INF/CERT.RSA";
  private static final String CERT_SF_NAME = "META-INF/CERT.SF";
  public static final String KEY_NONE = "none";
  public static final String KEY_TESTKEY = "testkey";
  public static final String MODE_AUTO = "auto";
  public static final String MODE_AUTO_NONE = "auto-none";
  public static final String MODE_AUTO_TESTKEY = "auto-testkey";
  public static final String[] SUPPORTED_KEY_MODES = { "auto-testkey", "auto", "auto-none", "media", "platform", "shared", "testkey", "none" };
  static LoggerInterface log = null;
  private static Pattern stripPattern = Pattern.compile("^META-INF/(.*)[.](SF|RSA|DSA)$");
  Map<String, String> autoKeyDetect = new HashMap();
  AutoKeyObservable autoKeyObservable = new AutoKeyObservable();
  private boolean canceled = false;
  KeySet keySet = null;
  String keymode = "testkey";
  Map<String, KeySet> loadedKeys = new HashMap();
  private ProgressHelper progressHelper = new ProgressHelper();
  
  public ZipSignerLP()
  {
    this.autoKeyDetect.put("aa9852bc5a53272ac8031d49b65e4b0e", "media");
    this.autoKeyDetect.put("e60418c4b638f20d0721e115674ca11f", "platform");
    this.autoKeyDetect.put("3e24e49741b60c215c010dc6048fca7d", "shared");
    this.autoKeyDetect.put("dab2cead827ef5313f28e22b6fa8479f", "testkey");
  }
  
  private Manifest addDigestsToManifest(Map<String, ZioEntry> paramMap, ArrayList<AddFilesItem> paramArrayList)
    throws IOException, GeneralSecurityException
  {
    Manifest localManifest1 = null;
    Object localObject1 = (ZioEntry)paramMap.get("META-INF/MANIFEST.MF");
    if (localObject1 != null)
    {
      localManifest1 = new Manifest();
      localManifest1.read(((ZioEntry)localObject1).getInputStream());
    }
    Manifest localManifest2 = new Manifest();
    localObject1 = localManifest2.getMainAttributes();
    MessageDigest localMessageDigest;
    byte[] arrayOfByte;
    boolean bool;
    Iterator localIterator1;
    if (localManifest1 != null)
    {
      ((Attributes)localObject1).putAll(localManifest1.getMainAttributes());
      localMessageDigest = MessageDigest.getInstance("SHA1");
      arrayOfByte = new byte['Ȁ'];
      localObject1 = new TreeMap();
      ((TreeMap)localObject1).putAll(paramMap);
      bool = getLogger().isDebugEnabled();
      if (bool) {
        getLogger().debug("Manifest entries:");
      }
      localIterator1 = ((TreeMap)localObject1).values().iterator();
    }
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        paramMap = (ZioEntry)localIterator1.next();
        if (!this.canceled) {}
      }
      else
      {
        return localManifest2;
        ((Attributes)localObject1).putValue("Manifest-Version", "1.0");
        ((Attributes)localObject1).putValue("Created-By", "1.0 (Android SignApk)");
        break;
      }
      String str = paramMap.getName();
      if (bool) {
        getLogger().debug(str);
      }
      if ((!paramMap.isDirectory()) && (!str.equals("META-INF/MANIFEST.MF")) && (!str.equals("META-INF/CERT.SF")) && (!str.equals("META-INF/CERT.RSA")) && ((stripPattern == null) || (!stripPattern.matcher(str).matches())))
      {
        this.progressHelper.progress(0, "Generating manifest");
        paramMap = paramMap.getInputStream();
        Iterator localIterator2 = paramArrayList.iterator();
        Object localObject3;
        while (localIterator2.hasNext())
        {
          localObject3 = (AddFilesItem)localIterator2.next();
          if (str.equals(((AddFilesItem)localObject3).fileName.replace(((AddFilesItem)localObject3).basePath, "")))
          {
            try
            {
              localObject1 = new FileInputStream(((AddFilesItem)localObject3).fileName);
            }
            catch (Exception localException1)
            {
              try
              {
                System.out.println("LuckyPatcher (signer): Additional files to manifest added! " + localObject3);
                paramMap = (Map<String, ZioEntry>)localObject1;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  paramMap = (Map<String, ZioEntry>)localObject2;
                  Object localObject2 = localException2;
                }
              }
              localException1 = localException1;
            }
            System.out.println(localException1);
          }
        }
        for (;;)
        {
          int i = paramMap.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localMessageDigest.update(arrayOfByte, 0, i);
        }
        paramMap.close();
        localObject2 = null;
        paramMap = (Map<String, ZioEntry>)localObject2;
        if (localManifest1 != null)
        {
          localObject3 = localManifest1.getAttributes(str);
          paramMap = (Map<String, ZioEntry>)localObject2;
          if (localObject3 != null) {
            paramMap = new Attributes((Attributes)localObject3);
          }
        }
        localObject2 = paramMap;
        if (paramMap == null) {
          localObject2 = new Attributes();
        }
        ((Attributes)localObject2).putValue("SHA1-Digest", Base64.encode(localMessageDigest.digest()));
        localManifest2.getEntries().put(str, localObject2);
      }
    }
  }
  
  private void copyFiles(Map<String, ZioEntry> paramMap, ZipOutput paramZipOutput, ArrayList<AddFilesItem> paramArrayList)
    throws IOException
  {
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      ZioEntry localZioEntry1 = (ZioEntry)paramMap.next();
      String str = localZioEntry1.getName();
      int i = 0;
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        AddFilesItem localAddFilesItem = (AddFilesItem)localIterator.next();
        if (str.equals(localAddFilesItem.fileName.replace(localAddFilesItem.basePath, "")))
        {
          int j = i;
          File localFile;
          FileInputStream localFileInputStream;
          ZioEntry localZioEntry2;
          OutputStream localOutputStream;
          try
          {
            localFile = new File(localAddFilesItem.fileName);
            j = i;
            byte[] arrayOfByte = new byte[' '];
            j = i;
            localFileInputStream = new FileInputStream(localAddFilesItem.fileName);
            j = i;
            localZioEntry2 = new ZioEntry(str);
            j = i;
            localZioEntry2.setCompression(localZioEntry1.getCompression());
            j = i;
            localZioEntry2.setTime(localZioEntry1.getTime());
            j = i;
            localOutputStream = localZioEntry2.getOutputStream();
            j = i;
            CRC32 localCRC32 = new CRC32();
            j = i;
            localCRC32.reset();
            for (;;)
            {
              j = i;
              k = localFileInputStream.read(arrayOfByte);
              if (k <= 0) {
                break;
              }
              j = i;
              localOutputStream.write(arrayOfByte, 0, k);
              j = i;
              localCRC32.update(arrayOfByte, 0, k);
            }
          }
          catch (Exception localException)
          {
            System.out.println(localException);
            i = j;
          }
          j = i;
          localOutputStream.flush();
          j = i;
          localFileInputStream.close();
          j = i;
          paramZipOutput.write(localZioEntry2);
          int k = 1;
          i = 1;
          j = k;
          localFile.delete();
          j = k;
          System.out.println("LuckyPatcher (signer): Additional files added! " + localException);
        }
      }
      if (i == 0) {
        paramZipOutput.write(localZioEntry1);
      }
    }
  }
  
  private void copyFiles(Manifest paramManifest, Map<String, ZioEntry> paramMap, JarOutputStream paramJarOutputStream, long paramLong, ArrayList<AddFilesItem> paramArrayList)
    throws IOException
  {
    paramManifest = new ArrayList(paramManifest.getEntries().keySet());
    Collections.sort(paramManifest);
    Iterator localIterator = paramManifest.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ZioEntry localZioEntry = (ZioEntry)paramMap.get(str);
      try
      {
        if (((ZioEntry)paramMap.get(str)).getCompression() != 0) {
          break label604;
        }
        paramManifest = new JarEntry(((ZioEntry)paramMap.get(str)).getName());
        localObject1 = paramManifest;
        try
        {
          paramManifest.setMethod(0);
          i = 0;
          localObject1 = paramManifest;
          localObject2 = paramArrayList.iterator();
          for (;;)
          {
            localObject1 = paramManifest;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = paramManifest;
            Object localObject3 = (AddFilesItem)((Iterator)localObject2).next();
            localObject1 = paramManifest;
            bool = str.equals(((AddFilesItem)localObject3).fileName.replace(((AddFilesItem)localObject3).basePath, ""));
            if (bool) {
              try
              {
                localObject4 = new File(((AddFilesItem)localObject3).fileName);
                localObject1 = new byte[(int)((File)localObject4).length()];
                localObject3 = new FileInputStream(((AddFilesItem)localObject3).fileName);
                ((FileInputStream)localObject3).read((byte[])localObject1);
                ((FileInputStream)localObject3).close();
                paramManifest.setCompressedSize(((File)localObject4).length());
                paramManifest.setSize(((File)localObject4).length());
                localObject3 = new CRC32();
                ((CRC32)localObject3).update((byte[])localObject1);
                paramManifest.setCrc(((CRC32)localObject3).getValue());
                paramManifest.setTime(((ZioEntry)paramMap.get(str)).getTime());
                i = 1;
              }
              catch (Exception localException2)
              {
                localObject1 = paramManifest;
                System.out.println(localException2);
              }
            }
          }
          System.out.println(paramManifest);
        }
        catch (Exception paramManifest) {}
      }
      catch (Exception paramManifest)
      {
        Object localObject1;
        int i;
        Object localObject2;
        boolean bool;
        Object localObject4;
        for (;;) {}
      }
      paramManifest.printStackTrace();
      continue;
      if (i == 0)
      {
        localObject1 = paramManifest;
        paramManifest.setCompressedSize(((ZioEntry)paramMap.get(str)).getSize());
        localObject1 = paramManifest;
        paramManifest.setSize(((ZioEntry)paramMap.get(str)).getSize());
        localObject1 = paramManifest;
        localObject2 = new CRC32();
        localObject1 = paramManifest;
        ((CRC32)localObject2).update(localZioEntry.getData());
        localObject1 = paramManifest;
        paramManifest.setCrc(((CRC32)localObject2).getValue());
        localObject1 = paramManifest;
        paramManifest.setTime(((ZioEntry)paramMap.get(str)).getTime());
      }
      i = 0;
      localObject1 = paramArrayList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label717;
        }
        localObject2 = (AddFilesItem)((Iterator)localObject1).next();
        bool = str.equals(((AddFilesItem)localObject2).fileName.replace(((AddFilesItem)localObject2).basePath, ""));
        if (bool)
        {
          int j = i;
          File localFile;
          FileInputStream localFileInputStream;
          try
          {
            localFile = new File(((AddFilesItem)localObject2).fileName);
            j = i;
            localObject4 = new byte[' '];
            j = i;
            localFileInputStream = new FileInputStream(((AddFilesItem)localObject2).fileName);
            j = i;
            paramJarOutputStream.putNextEntry(paramManifest);
            for (;;)
            {
              j = i;
              k = localFileInputStream.read((byte[])localObject4);
              if (k <= 0) {
                break;
              }
              j = i;
              paramJarOutputStream.write((byte[])localObject4, 0, k);
            }
          }
          catch (Exception localException1)
          {
            System.out.println(localException1);
            i = j;
          }
          label604:
          paramManifest = new JarEntry(str);
          localObject1 = paramManifest;
          paramManifest.setTime(((ZioEntry)paramMap.get(str)).getTime());
          localObject1 = paramManifest;
          paramManifest.setMethod(localZioEntry.getCompression());
          break;
          j = i;
          paramJarOutputStream.flush();
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
      label717:
      if (i == 0)
      {
        paramJarOutputStream.putNextEntry(paramManifest);
        paramManifest = localZioEntry.getInputStream();
        localObject1 = new byte[' '];
        for (;;)
        {
          i = paramManifest.read((byte[])localObject1);
          if (i <= 0) {
            break;
          }
          paramJarOutputStream.write((byte[])localObject1, 0, i);
        }
        paramJarOutputStream.flush();
      }
    }
  }
  
  /* Error */
  private java.security.spec.KeySpec decryptPrivateKey(byte[] paramArrayOfByte, String paramString)
    throws GeneralSecurityException
  {
    // Byte code:
    //   0: new 444	javax/crypto/EncryptedPrivateKeyInfo
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 446	javax/crypto/EncryptedPrivateKeyInfo:<init>	([B)V
    //   8: astore_1
    //   9: aload_2
    //   10: invokevirtual 450	java/lang/String:toCharArray	()[C
    //   13: astore_2
    //   14: aload_1
    //   15: invokevirtual 453	javax/crypto/EncryptedPrivateKeyInfo:getAlgName	()Ljava/lang/String;
    //   18: invokestatic 458	javax/crypto/SecretKeyFactory:getInstance	(Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;
    //   21: new 460	javax/crypto/spec/PBEKeySpec
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 463	javax/crypto/spec/PBEKeySpec:<init>	([C)V
    //   29: invokevirtual 467	javax/crypto/SecretKeyFactory:generateSecret	(Ljava/security/spec/KeySpec;)Ljavax/crypto/SecretKey;
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 453	javax/crypto/EncryptedPrivateKeyInfo:getAlgName	()Ljava/lang/String;
    //   37: invokestatic 472	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   40: astore_3
    //   41: aload_3
    //   42: iconst_2
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 476	javax/crypto/EncryptedPrivateKeyInfo:getAlgParameters	()Ljava/security/AlgorithmParameters;
    //   48: invokevirtual 480	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/AlgorithmParameters;)V
    //   51: aload_1
    //   52: aload_3
    //   53: invokevirtual 484	javax/crypto/EncryptedPrivateKeyInfo:getKeySpec	(Ljavax/crypto/Cipher;)Ljava/security/spec/PKCS8EncodedKeySpec;
    //   56: astore_1
    //   57: aload_1
    //   58: areturn
    //   59: astore_1
    //   60: aconst_null
    //   61: areturn
    //   62: astore_1
    //   63: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   66: ldc_w 486
    //   69: invokeinterface 489 2 0
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ZipSignerLP
    //   0	76	1	paramArrayOfByte	byte[]
    //   0	76	2	paramString	String
    //   40	13	3	localCipher	javax.crypto.Cipher
    // Exception table:
    //   from	to	target	type
    //   0	9	59	java/io/IOException
    //   51	57	62	java/security/spec/InvalidKeySpecException
  }
  
  private void generateSignatureFile(Manifest paramManifest, OutputStream paramOutputStream)
    throws IOException, GeneralSecurityException
  {
    paramOutputStream.write("Signature-Version: 1.0\r\n".getBytes());
    paramOutputStream.write("Created-By: 1.0 (Android SignApk)\r\n".getBytes());
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
    PrintStream localPrintStream = new PrintStream(new DigestOutputStream(new ByteArrayOutputStream(), localMessageDigest), true, "UTF-8");
    paramManifest.write(localPrintStream);
    localPrintStream.flush();
    paramOutputStream.write(("SHA1-Digest-Manifest: " + Base64.encode(localMessageDigest.digest()) + "\r\n\r\n").getBytes());
    paramManifest = paramManifest.getEntries().entrySet().iterator();
    for (;;)
    {
      if (paramManifest.hasNext())
      {
        localObject = (Map.Entry)paramManifest.next();
        if (!this.canceled) {}
      }
      else
      {
        return;
      }
      this.progressHelper.progress(0, "Generating signature file");
      String str = "Name: " + (String)((Map.Entry)localObject).getKey() + "\r\n";
      localPrintStream.print(str);
      Object localObject = ((Attributes)((Map.Entry)localObject).getValue()).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localPrintStream.print(localEntry.getKey() + ": " + localEntry.getValue() + "\r\n");
      }
      localPrintStream.print("\r\n");
      localPrintStream.flush();
      paramOutputStream.write(str.getBytes());
      paramOutputStream.write(("SHA1-Digest: " + Base64.encode(localMessageDigest.digest()) + "\r\n\r\n").getBytes());
    }
  }
  
  public static LoggerInterface getLogger()
  {
    if (log == null) {
      log = LoggerManager.getLogger(ZipSignerLP.class.getName());
    }
    return log;
  }
  
  public static String[] getSupportedKeyModes()
  {
    return SUPPORTED_KEY_MODES;
  }
  
  private void writeSignatureBlock(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, X509Certificate paramX509Certificate, OutputStream paramOutputStream)
    throws IOException, GeneralSecurityException
  {
    if (paramArrayOfByte1 != null)
    {
      paramOutputStream.write(paramArrayOfByte1);
      paramOutputStream.write(paramArrayOfByte2);
      return;
    }
    try
    {
      paramArrayOfByte1 = Class.forName("kellinwood.sigblock.SignatureBlockWriter").getMethod("writeSignatureBlock", new Class[] { new byte[1].getClass(), X509Certificate.class, OutputStream.class });
      if (paramArrayOfByte1 == null) {
        throw new IllegalStateException("writeSignatureBlock() method not found.");
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      getLogger().error(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
      throw new IllegalStateException("Failed to invoke writeSignatureBlock(): " + paramArrayOfByte1.getClass().getName() + ": " + paramArrayOfByte1.getMessage());
    }
    paramArrayOfByte1.invoke(null, new Object[] { paramArrayOfByte2, paramX509Certificate, paramOutputStream });
  }
  
  public void addAutoKeyObserver(Observer paramObserver)
  {
    this.autoKeyObservable.addObserver(paramObserver);
  }
  
  public void addProgressListener(ProgressListener paramProgressListener)
  {
    this.progressHelper.addProgressListener(paramProgressListener);
  }
  
  protected String autoDetectKey(String paramString, Map<String, ZioEntry> paramMap)
    throws NoSuchAlgorithmException, IOException
  {
    boolean bool = getLogger().isDebugEnabled();
    if (!paramString.startsWith("auto")) {
      return paramString;
    }
    Object localObject1 = null;
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = (Map<String, ZioEntry>)localObject1;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      if ((((String)localObject2).startsWith("META-INF/")) && (((String)localObject2).endsWith(".RSA")))
      {
        localObject2 = MessageDigest.getInstance("MD5");
        localObject1 = ((ZioEntry)((Map.Entry)localObject1).getValue()).getData();
        if (localObject1.length >= 1458) {
          break label173;
        }
      }
    }
    if (paramString.equals("auto-testkey"))
    {
      if (bool) {
        getLogger().debug("Falling back to key=" + paramMap);
      }
      return "testkey";
      label173:
      ((MessageDigest)localObject2).update((byte[])localObject1, 0, 1458);
      paramMap = ((MessageDigest)localObject2).digest();
      localObject1 = new StringBuilder();
      int j = paramMap.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject1).append(String.format("%02x", new Object[] { Byte.valueOf(paramMap[i]) }));
        i += 1;
      }
      paramMap = ((StringBuilder)localObject1).toString();
      localObject1 = (String)this.autoKeyDetect.get(paramMap);
      if (bool)
      {
        if (localObject1 == null) {
          break label312;
        }
        getLogger().debug(String.format("Auto-determined key=%s using md5=%s", new Object[] { localObject1, paramMap }));
      }
      for (;;)
      {
        paramMap = (Map<String, ZioEntry>)localObject1;
        if (localObject1 == null) {
          break;
        }
        return (String)localObject1;
        label312:
        getLogger().debug(String.format("Auto key determination failed for md5=%s", new Object[] { paramMap }));
      }
    }
    if (paramString.equals("auto-none"))
    {
      if (bool) {
        getLogger().debug("Unable to determine key, returning: none");
      }
      return "none";
    }
    return null;
  }
  
  public void cancel()
  {
    this.canceled = true;
  }
  
  public KeySet getKeySet()
  {
    return this.keySet;
  }
  
  public String getKeymode()
  {
    return this.keymode;
  }
  
  public boolean isCanceled()
  {
    return this.canceled;
  }
  
  public void loadKeys(String paramString)
    throws IOException, GeneralSecurityException
  {
    this.keySet = ((KeySet)this.loadedKeys.get(paramString));
    if (this.keySet != null) {}
    do
    {
      do
      {
        return;
        this.keySet = new KeySet();
        this.keySet.setName(paramString);
        this.loadedKeys.put(paramString, this.keySet);
      } while ("none".equals(paramString));
      this.progressHelper.progress(1, "Loading certificate and private key");
      URL localURL = getClass().getResource("/keys/" + paramString + ".pk8");
      this.keySet.setPrivateKey(readPrivateKey(localURL, null));
      localURL = getClass().getResource("/keys/" + paramString + ".x509.pem");
      this.keySet.setPublicKey(readPublicKey(localURL));
      paramString = getClass().getResource("/keys/" + paramString + ".sbt");
    } while (paramString == null);
    this.keySet.setSigBlockTemplate(readContentAsBytes(paramString));
  }
  
  public void loadProvider(String paramString)
    throws ClassNotFoundException, IllegalAccessException, InstantiationException
  {
    Security.insertProviderAt((Provider)Class.forName(paramString).newInstance(), 1);
  }
  
  public byte[] readContentAsBytes(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['ࠀ'];
    for (int i = paramInputStream.read(arrayOfByte); i != -1; i = paramInputStream.read(arrayOfByte)) {
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public byte[] readContentAsBytes(URL paramURL)
    throws IOException
  {
    return readContentAsBytes(paramURL.openStream());
  }
  
  /* Error */
  public PrivateKey readPrivateKey(URL paramURL, String paramString)
    throws IOException, GeneralSecurityException
  {
    // Byte code:
    //   0: new 724	java/io/DataInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 720	java/net/URL:openStream	()Ljava/io/InputStream;
    //   8: invokespecial 726	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   11: astore_3
    //   12: aload_0
    //   13: aload_3
    //   14: invokevirtual 722	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:readContentAsBytes	(Ljava/io/InputStream;)[B
    //   17: astore 4
    //   19: aload_0
    //   20: aload 4
    //   22: aload_2
    //   23: invokespecial 728	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:decryptPrivateKey	([BLjava/lang/String;)Ljava/security/spec/KeySpec;
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_2
    //   30: ifnonnull +13 -> 43
    //   33: new 730	java/security/spec/PKCS8EncodedKeySpec
    //   36: dup
    //   37: aload 4
    //   39: invokespecial 731	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   42: astore_1
    //   43: ldc_w 733
    //   46: invokestatic 738	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   49: aload_1
    //   50: invokevirtual 742	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   53: astore_2
    //   54: aload_3
    //   55: invokevirtual 743	java/io/DataInputStream:close	()V
    //   58: aload_2
    //   59: areturn
    //   60: astore_2
    //   61: ldc_w 745
    //   64: invokestatic 738	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   67: aload_1
    //   68: invokevirtual 742	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   71: astore_1
    //   72: aload_3
    //   73: invokevirtual 743	java/io/DataInputStream:close	()V
    //   76: aload_1
    //   77: areturn
    //   78: astore_1
    //   79: aload_3
    //   80: invokevirtual 743	java/io/DataInputStream:close	()V
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	ZipSignerLP
    //   0	85	1	paramURL	URL
    //   0	85	2	paramString	String
    //   11	69	3	localDataInputStream	java.io.DataInputStream
    //   17	21	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   43	54	60	java/security/spec/InvalidKeySpecException
    //   12	27	78	finally
    //   33	43	78	finally
    //   43	54	78	finally
    //   61	72	78	finally
  }
  
  public X509Certificate readPublicKey(URL paramURL)
    throws IOException, GeneralSecurityException
  {
    paramURL = paramURL.openStream();
    try
    {
      X509Certificate localX509Certificate = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(paramURL);
      return localX509Certificate;
    }
    finally
    {
      paramURL.close();
    }
  }
  
  public void removeProgressListener(ProgressListener paramProgressListener)
  {
    try
    {
      this.progressHelper.removeProgressListener(paramProgressListener);
      return;
    }
    finally
    {
      paramProgressListener = finally;
      throw paramProgressListener;
    }
  }
  
  public void resetCanceled()
  {
    this.canceled = false;
  }
  
  public void setKeymode(String paramString)
    throws IOException, GeneralSecurityException
  {
    if (getLogger().isDebugEnabled()) {
      getLogger().debug("setKeymode: " + paramString);
    }
    this.keymode = paramString;
    if (this.keymode.startsWith("auto"))
    {
      this.keySet = null;
      return;
    }
    this.progressHelper.initProgress();
    loadKeys(this.keymode);
  }
  
  public void setKeys(String paramString, X509Certificate paramX509Certificate, PrivateKey paramPrivateKey, byte[] paramArrayOfByte)
  {
    this.keySet = new KeySet(paramString, paramX509Certificate, paramPrivateKey, paramArrayOfByte);
  }
  
  public void signZip(String paramString1, String paramString2, ArrayList<AddFilesItem> paramArrayList)
    throws IOException, GeneralSecurityException
  {
    if (new File(paramString1).getCanonicalFile().equals(new File(paramString2).getCanonicalFile())) {
      throw new IllegalArgumentException("Input and output files are the same.  Specify a different name for the output.");
    }
    this.progressHelper.initProgress();
    this.progressHelper.progress(1, "Parsing the input's central directory");
    signZip(ZipInput.read(paramString1).getEntries(), new FileOutputStream(paramString2), paramString2, paramArrayList);
  }
  
  public void signZip(URL paramURL, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ArrayList<AddFilesItem> paramArrayList)
    throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, GeneralSecurityException
  {
    Object localObject2 = null;
    Object localObject1 = paramString1;
    if (paramString1 == null) {
      paramString1 = (String)localObject2;
    }
    try
    {
      localObject1 = KeyStore.getDefaultType();
      paramString1 = (String)localObject2;
      localObject1 = KeyStore.getInstance((String)localObject1);
      paramString1 = (String)localObject2;
      paramURL = paramURL.openStream();
      paramString1 = paramURL;
      ((KeyStore)localObject1).load(paramURL, paramString2.toCharArray());
      paramString1 = paramURL;
      setKeys("custom", (X509Certificate)((KeyStore)localObject1).getCertificate(paramString3), (PrivateKey)((KeyStore)localObject1).getKey(paramString3, paramString4.toCharArray()), null);
      paramString1 = paramURL;
      signZip(paramString5, paramString6, paramArrayList);
      return;
    }
    finally
    {
      if (paramString1 != null) {
        paramString1.close();
      }
    }
  }
  
  /* Error */
  public void signZip(Map<String, ZioEntry> paramMap, OutputStream paramOutputStream, String paramString, ArrayList<AddFilesItem> paramArrayList)
    throws IOException, GeneralSecurityException
  {
    // Byte code:
    //   0: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   3: invokeinterface 171 1 0
    //   8: istore 6
    //   10: aload_0
    //   11: getfield 84	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:progressHelper	Lkellinwood/security/zipsigner/ProgressHelper;
    //   14: invokevirtual 766	kellinwood/security/zipsigner/ProgressHelper:initProgress	()V
    //   17: aload_0
    //   18: getfield 91	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keySet	Lkellinwood/security/zipsigner/KeySet;
    //   21: ifnonnull +95 -> 116
    //   24: aload_0
    //   25: getfield 93	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keymode	Ljava/lang/String;
    //   28: ldc 23
    //   30: invokevirtual 613	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   33: ifne +14 -> 47
    //   36: new 579	java/lang/IllegalStateException
    //   39: dup
    //   40: ldc_w 832
    //   43: invokespecial 582	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   46: athrow
    //   47: aload_0
    //   48: aload_0
    //   49: getfield 93	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keymode	Ljava/lang/String;
    //   52: aload_1
    //   53: invokevirtual 834	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:autoDetectKey	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   56: astore 10
    //   58: aload 10
    //   60: ifnonnull +41 -> 101
    //   63: new 836	kellinwood/security/zipsigner/AutoKeyException
    //   66: dup
    //   67: new 263	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 838
    //   77: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: new 328	java/io/File
    //   83: dup
    //   84: aload_3
    //   85: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokevirtual 839	java/io/File:getName	()Ljava/lang/String;
    //   91: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 840	kellinwood/security/zipsigner/AutoKeyException:<init>	(Ljava/lang/String;)V
    //   100: athrow
    //   101: aload_0
    //   102: getfield 98	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:autoKeyObservable	Lcom/android/vending/billing/InAppBillingService/LACK/ZipSignerLP$AutoKeyObservable;
    //   105: aload 10
    //   107: invokevirtual 843	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP$AutoKeyObservable:notifyObservers	(Ljava/lang/Object;)V
    //   110: aload_0
    //   111: aload 10
    //   113: invokevirtual 768	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:loadKeys	(Ljava/lang/String;)V
    //   116: new 369	kellinwood/zipio/ZipOutput
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 845	kellinwood/zipio/ZipOutput:<init>	(Ljava/io/OutputStream;)V
    //   124: astore 10
    //   126: new 431	java/util/jar/JarOutputStream
    //   129: dup
    //   130: new 794	java/io/FileOutputStream
    //   133: dup
    //   134: aload_3
    //   135: invokespecial 795	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   138: invokespecial 846	java/util/jar/JarOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   141: astore_2
    //   142: ldc 17
    //   144: aload_0
    //   145: getfield 91	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keySet	Lkellinwood/security/zipsigner/KeySet;
    //   148: invokevirtual 847	kellinwood/security/zipsigner/KeySet:getName	()Ljava/lang/String;
    //   151: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifeq +125 -> 279
    //   157: aload_0
    //   158: getfield 84	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:progressHelper	Lkellinwood/security/zipsigner/ProgressHelper;
    //   161: aload_1
    //   162: invokeinterface 850 1 0
    //   167: invokevirtual 853	kellinwood/security/zipsigner/ProgressHelper:setProgressTotalItems	(I)V
    //   170: aload_0
    //   171: getfield 84	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:progressHelper	Lkellinwood/security/zipsigner/ProgressHelper;
    //   174: iconst_0
    //   175: invokevirtual 856	kellinwood/security/zipsigner/ProgressHelper:setProgressCurrentItem	(I)V
    //   178: aload_0
    //   179: aload_1
    //   180: aload 10
    //   182: aload 4
    //   184: invokespecial 858	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:copyFiles	(Ljava/util/Map;Lkellinwood/zipio/ZipOutput;Ljava/util/ArrayList;)V
    //   187: aload 10
    //   189: invokevirtual 859	kellinwood/zipio/ZipOutput:close	()V
    //   192: aload_2
    //   193: ifnull +19 -> 212
    //   196: aload_0
    //   197: getfield 93	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keymode	Ljava/lang/String;
    //   200: ldc 17
    //   202: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifne +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 860	java/util/jar/JarOutputStream:close	()V
    //   212: aload_0
    //   213: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   216: ifeq +19 -> 235
    //   219: aload_3
    //   220: ifnull +15 -> 235
    //   223: new 328	java/io/File
    //   226: dup
    //   227: aload_3
    //   228: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   231: invokevirtual 375	java/io/File:delete	()Z
    //   234: pop
    //   235: return
    //   236: astore_1
    //   237: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   240: new 263	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   247: aload_1
    //   248: invokevirtual 571	java/lang/Object:getClass	()Ljava/lang/Class;
    //   251: invokevirtual 551	java/lang/Class:getName	()Ljava/lang/String;
    //   254: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 862
    //   260: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_1
    //   264: invokevirtual 863	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   267: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokeinterface 866 2 0
    //   278: return
    //   279: iconst_0
    //   280: istore 5
    //   282: aload_1
    //   283: invokeinterface 326 1 0
    //   288: invokeinterface 187 1 0
    //   293: astore 10
    //   295: aload 10
    //   297: invokeinterface 192 1 0
    //   302: ifeq +83 -> 385
    //   305: aload 10
    //   307: invokeinterface 196 1 0
    //   312: checkcast 128	kellinwood/zipio/ZioEntry
    //   315: astore 11
    //   317: aload 11
    //   319: invokevirtual 212	kellinwood/zipio/ZioEntry:getName	()Ljava/lang/String;
    //   322: astore 12
    //   324: aload 11
    //   326: invokevirtual 215	kellinwood/zipio/ZioEntry:isDirectory	()Z
    //   329: ifne -34 -> 295
    //   332: aload 12
    //   334: ldc 122
    //   336: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   339: ifne -44 -> 295
    //   342: aload 12
    //   344: ldc 14
    //   346: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   349: ifne -54 -> 295
    //   352: aload 12
    //   354: ldc 11
    //   356: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   359: ifne -64 -> 295
    //   362: getstatic 63	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:stripPattern	Ljava/util/regex/Pattern;
    //   365: ifnull +1043 -> 1408
    //   368: getstatic 63	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:stripPattern	Ljava/util/regex/Pattern;
    //   371: aload 12
    //   373: invokevirtual 223	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   376: invokevirtual 228	java/util/regex/Matcher:matches	()Z
    //   379: ifne -84 -> 295
    //   382: goto +1026 -> 1408
    //   385: aload_0
    //   386: getfield 84	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:progressHelper	Lkellinwood/security/zipsigner/ProgressHelper;
    //   389: iload 5
    //   391: iconst_1
    //   392: iadd
    //   393: invokevirtual 853	kellinwood/security/zipsigner/ProgressHelper:setProgressTotalItems	(I)V
    //   396: aload_0
    //   397: getfield 84	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:progressHelper	Lkellinwood/security/zipsigner/ProgressHelper;
    //   400: iconst_0
    //   401: invokevirtual 856	kellinwood/security/zipsigner/ProgressHelper:setProgressCurrentItem	(I)V
    //   404: aload_0
    //   405: getfield 91	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keySet	Lkellinwood/security/zipsigner/KeySet;
    //   408: invokevirtual 870	kellinwood/security/zipsigner/KeySet:getPublicKey	()Ljava/security/cert/X509Certificate;
    //   411: invokevirtual 874	java/security/cert/X509Certificate:getNotBefore	()Ljava/util/Date;
    //   414: invokevirtual 877	java/util/Date:getTime	()J
    //   417: ldc2_w 878
    //   420: ladd
    //   421: lstore 8
    //   423: aload_0
    //   424: aload_1
    //   425: aload 4
    //   427: invokespecial 881	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:addDigestsToManifest	(Ljava/util/Map;Ljava/util/ArrayList;)Ljava/util/jar/Manifest;
    //   430: astore 10
    //   432: aload_0
    //   433: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   436: istore 7
    //   438: iload 7
    //   440: ifeq +90 -> 530
    //   443: aload_2
    //   444: ifnull +19 -> 463
    //   447: aload_0
    //   448: getfield 93	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keymode	Ljava/lang/String;
    //   451: ldc 17
    //   453: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   456: ifne +7 -> 463
    //   459: aload_2
    //   460: invokevirtual 860	java/util/jar/JarOutputStream:close	()V
    //   463: aload_0
    //   464: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   467: ifeq -232 -> 235
    //   470: aload_3
    //   471: ifnull -236 -> 235
    //   474: new 328	java/io/File
    //   477: dup
    //   478: aload_3
    //   479: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   482: invokevirtual 375	java/io/File:delete	()Z
    //   485: pop
    //   486: return
    //   487: astore_1
    //   488: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   491: new 263	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   498: aload_1
    //   499: invokevirtual 571	java/lang/Object:getClass	()Ljava/lang/Class;
    //   502: invokevirtual 551	java/lang/Class:getName	()Ljava/lang/String;
    //   505: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc_w 862
    //   511: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload_1
    //   515: invokevirtual 863	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   518: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokeinterface 866 2 0
    //   529: return
    //   530: new 396	java/util/jar/JarEntry
    //   533: dup
    //   534: ldc 122
    //   536: invokespecial 397	java/util/jar/JarEntry:<init>	(Ljava/lang/String;)V
    //   539: astore 11
    //   541: aload 11
    //   543: lload 8
    //   545: invokevirtual 419	java/util/jar/JarEntry:setTime	(J)V
    //   548: aload_2
    //   549: aload 11
    //   551: invokevirtual 435	java/util/jar/JarOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   554: aload 10
    //   556: aload_2
    //   557: invokevirtual 516	java/util/jar/Manifest:write	(Ljava/io/OutputStream;)V
    //   560: new 883	kellinwood/security/zipsigner/ZipSignature
    //   563: dup
    //   564: invokespecial 884	kellinwood/security/zipsigner/ZipSignature:<init>	()V
    //   567: astore 11
    //   569: aload 11
    //   571: aload_0
    //   572: getfield 91	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keySet	Lkellinwood/security/zipsigner/KeySet;
    //   575: invokevirtual 888	kellinwood/security/zipsigner/KeySet:getPrivateKey	()Ljava/security/PrivateKey;
    //   578: invokevirtual 891	kellinwood/security/zipsigner/ZipSignature:initSign	(Ljava/security/PrivateKey;)V
    //   581: new 504	java/io/ByteArrayOutputStream
    //   584: dup
    //   585: invokespecial 505	java/io/ByteArrayOutputStream:<init>	()V
    //   588: astore 12
    //   590: aload_0
    //   591: aload 10
    //   593: aload 12
    //   595: invokespecial 893	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:generateSignatureFile	(Ljava/util/jar/Manifest;Ljava/io/OutputStream;)V
    //   598: aload_0
    //   599: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   602: istore 7
    //   604: iload 7
    //   606: ifeq +90 -> 696
    //   609: aload_2
    //   610: ifnull +19 -> 629
    //   613: aload_0
    //   614: getfield 93	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keymode	Ljava/lang/String;
    //   617: ldc 17
    //   619: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   622: ifne +7 -> 629
    //   625: aload_2
    //   626: invokevirtual 860	java/util/jar/JarOutputStream:close	()V
    //   629: aload_0
    //   630: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   633: ifeq -398 -> 235
    //   636: aload_3
    //   637: ifnull -402 -> 235
    //   640: new 328	java/io/File
    //   643: dup
    //   644: aload_3
    //   645: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   648: invokevirtual 375	java/io/File:delete	()Z
    //   651: pop
    //   652: return
    //   653: astore_1
    //   654: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   657: new 263	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   664: aload_1
    //   665: invokevirtual 571	java/lang/Object:getClass	()Ljava/lang/Class;
    //   668: invokevirtual 551	java/lang/Class:getName	()Ljava/lang/String;
    //   671: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: ldc_w 862
    //   677: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload_1
    //   681: invokevirtual 863	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   684: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokeinterface 866 2 0
    //   695: return
    //   696: aload 12
    //   698: invokevirtual 715	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   701: astore 12
    //   703: iload 6
    //   705: ifeq +53 -> 758
    //   708: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   711: new 263	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   718: ldc_w 895
    //   721: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: new 65	java/lang/String
    //   727: dup
    //   728: aload 12
    //   730: invokespecial 896	java/lang/String:<init>	([B)V
    //   733: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: ldc_w 898
    //   739: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload 12
    //   744: invokestatic 901	kellinwood/security/zipsigner/HexDumpEncoder:encode	([B)Ljava/lang/String;
    //   747: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokeinterface 177 2 0
    //   758: new 396	java/util/jar/JarEntry
    //   761: dup
    //   762: ldc 14
    //   764: invokespecial 397	java/util/jar/JarEntry:<init>	(Ljava/lang/String;)V
    //   767: astore 13
    //   769: aload 13
    //   771: lload 8
    //   773: invokevirtual 419	java/util/jar/JarEntry:setTime	(J)V
    //   776: aload_2
    //   777: aload 13
    //   779: invokevirtual 435	java/util/jar/JarOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   782: aload_2
    //   783: aload 12
    //   785: invokevirtual 902	java/util/jar/JarOutputStream:write	([B)V
    //   788: aload 11
    //   790: aload 12
    //   792: invokevirtual 903	kellinwood/security/zipsigner/ZipSignature:update	([B)V
    //   795: aload 11
    //   797: invokevirtual 906	kellinwood/security/zipsigner/ZipSignature:sign	()[B
    //   800: astore 11
    //   802: iload 6
    //   804: ifeq +150 -> 954
    //   807: ldc -105
    //   809: invokestatic 157	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   812: astore 13
    //   814: aload 13
    //   816: aload 12
    //   818: invokevirtual 907	java/security/MessageDigest:update	([B)V
    //   821: aload 13
    //   823: invokevirtual 310	java/security/MessageDigest:digest	()[B
    //   826: astore 12
    //   828: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   831: new 263	java/lang/StringBuilder
    //   834: dup
    //   835: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   838: ldc_w 909
    //   841: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: aload 12
    //   846: invokestatic 901	kellinwood/security/zipsigner/HexDumpEncoder:encode	([B)Ljava/lang/String;
    //   849: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokeinterface 177 2 0
    //   860: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   863: new 263	java/lang/StringBuilder
    //   866: dup
    //   867: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   870: ldc_w 911
    //   873: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: aload 11
    //   878: invokestatic 901	kellinwood/security/zipsigner/HexDumpEncoder:encode	([B)Ljava/lang/String;
    //   881: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokeinterface 177 2 0
    //   892: ldc_w 913
    //   895: invokestatic 472	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   898: astore 12
    //   900: aload 12
    //   902: iconst_2
    //   903: aload_0
    //   904: getfield 91	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keySet	Lkellinwood/security/zipsigner/KeySet;
    //   907: invokevirtual 870	kellinwood/security/zipsigner/KeySet:getPublicKey	()Ljava/security/cert/X509Certificate;
    //   910: invokevirtual 916	javax/crypto/Cipher:init	(ILjava/security/cert/Certificate;)V
    //   913: aload 12
    //   915: aload 11
    //   917: invokevirtual 920	javax/crypto/Cipher:doFinal	([B)[B
    //   920: astore 12
    //   922: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   925: new 263	java/lang/StringBuilder
    //   928: dup
    //   929: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   932: ldc_w 922
    //   935: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload 12
    //   940: invokestatic 901	kellinwood/security/zipsigner/HexDumpEncoder:encode	([B)Ljava/lang/String;
    //   943: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   949: invokeinterface 177 2 0
    //   954: aload_0
    //   955: getfield 84	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:progressHelper	Lkellinwood/security/zipsigner/ProgressHelper;
    //   958: iconst_0
    //   959: ldc_w 924
    //   962: invokevirtual 234	kellinwood/security/zipsigner/ProgressHelper:progress	(ILjava/lang/String;)V
    //   965: new 396	java/util/jar/JarEntry
    //   968: dup
    //   969: ldc 11
    //   971: invokespecial 397	java/util/jar/JarEntry:<init>	(Ljava/lang/String;)V
    //   974: astore 12
    //   976: aload 12
    //   978: lload 8
    //   980: invokevirtual 419	java/util/jar/JarEntry:setTime	(J)V
    //   983: aload_2
    //   984: aload 12
    //   986: invokevirtual 435	java/util/jar/JarOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   989: aload_0
    //   990: aload_0
    //   991: getfield 91	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keySet	Lkellinwood/security/zipsigner/KeySet;
    //   994: invokevirtual 927	kellinwood/security/zipsigner/KeySet:getSigBlockTemplate	()[B
    //   997: aload 11
    //   999: aload_0
    //   1000: getfield 91	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keySet	Lkellinwood/security/zipsigner/KeySet;
    //   1003: invokevirtual 870	kellinwood/security/zipsigner/KeySet:getPublicKey	()Ljava/security/cert/X509Certificate;
    //   1006: aload_2
    //   1007: invokespecial 929	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:writeSignatureBlock	([B[BLjava/security/cert/X509Certificate;Ljava/io/OutputStream;)V
    //   1010: aload_0
    //   1011: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   1014: istore 6
    //   1016: iload 6
    //   1018: ifeq +90 -> 1108
    //   1021: aload_2
    //   1022: ifnull +19 -> 1041
    //   1025: aload_0
    //   1026: getfield 93	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keymode	Ljava/lang/String;
    //   1029: ldc 17
    //   1031: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1034: ifne +7 -> 1041
    //   1037: aload_2
    //   1038: invokevirtual 860	java/util/jar/JarOutputStream:close	()V
    //   1041: aload_0
    //   1042: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   1045: ifeq -810 -> 235
    //   1048: aload_3
    //   1049: ifnull -814 -> 235
    //   1052: new 328	java/io/File
    //   1055: dup
    //   1056: aload_3
    //   1057: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   1060: invokevirtual 375	java/io/File:delete	()Z
    //   1063: pop
    //   1064: return
    //   1065: astore_1
    //   1066: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   1069: new 263	java/lang/StringBuilder
    //   1072: dup
    //   1073: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1076: aload_1
    //   1077: invokevirtual 571	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1080: invokevirtual 551	java/lang/Class:getName	()Ljava/lang/String;
    //   1083: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: ldc_w 862
    //   1089: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: aload_1
    //   1093: invokevirtual 863	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1096: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokeinterface 866 2 0
    //   1107: return
    //   1108: aload_0
    //   1109: aload 10
    //   1111: aload_1
    //   1112: aload_2
    //   1113: lload 8
    //   1115: aload 4
    //   1117: invokespecial 931	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:copyFiles	(Ljava/util/jar/Manifest;Ljava/util/Map;Ljava/util/jar/JarOutputStream;JLjava/util/ArrayList;)V
    //   1120: aload_0
    //   1121: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   1124: istore 6
    //   1126: iload 6
    //   1128: ifeq +90 -> 1218
    //   1131: aload_2
    //   1132: ifnull +19 -> 1151
    //   1135: aload_0
    //   1136: getfield 93	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keymode	Ljava/lang/String;
    //   1139: ldc 17
    //   1141: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1144: ifne +7 -> 1151
    //   1147: aload_2
    //   1148: invokevirtual 860	java/util/jar/JarOutputStream:close	()V
    //   1151: aload_0
    //   1152: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   1155: ifeq -920 -> 235
    //   1158: aload_3
    //   1159: ifnull -924 -> 235
    //   1162: new 328	java/io/File
    //   1165: dup
    //   1166: aload_3
    //   1167: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   1170: invokevirtual 375	java/io/File:delete	()Z
    //   1173: pop
    //   1174: return
    //   1175: astore_1
    //   1176: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   1179: new 263	java/lang/StringBuilder
    //   1182: dup
    //   1183: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1186: aload_1
    //   1187: invokevirtual 571	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1190: invokevirtual 551	java/lang/Class:getName	()Ljava/lang/String;
    //   1193: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: ldc_w 862
    //   1199: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: aload_1
    //   1203: invokevirtual 863	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1206: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1212: invokeinterface 866 2 0
    //   1217: return
    //   1218: aload_2
    //   1219: ifnull +19 -> 1238
    //   1222: aload_0
    //   1223: getfield 93	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keymode	Ljava/lang/String;
    //   1226: ldc 17
    //   1228: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1231: ifne +7 -> 1238
    //   1234: aload_2
    //   1235: invokevirtual 860	java/util/jar/JarOutputStream:close	()V
    //   1238: aload_0
    //   1239: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   1242: ifeq -1007 -> 235
    //   1245: aload_3
    //   1246: ifnull -1011 -> 235
    //   1249: new 328	java/io/File
    //   1252: dup
    //   1253: aload_3
    //   1254: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   1257: invokevirtual 375	java/io/File:delete	()Z
    //   1260: pop
    //   1261: return
    //   1262: astore_1
    //   1263: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   1266: new 263	java/lang/StringBuilder
    //   1269: dup
    //   1270: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1273: aload_1
    //   1274: invokevirtual 571	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1277: invokevirtual 551	java/lang/Class:getName	()Ljava/lang/String;
    //   1280: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: ldc_w 862
    //   1286: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: aload_1
    //   1290: invokevirtual 863	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1293: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1299: invokeinterface 866 2 0
    //   1304: return
    //   1305: astore_1
    //   1306: aconst_null
    //   1307: astore_2
    //   1308: aload_2
    //   1309: ifnull +19 -> 1328
    //   1312: aload_0
    //   1313: getfield 93	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:keymode	Ljava/lang/String;
    //   1316: ldc 17
    //   1318: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1321: ifne +7 -> 1328
    //   1324: aload_2
    //   1325: invokevirtual 860	java/util/jar/JarOutputStream:close	()V
    //   1328: aload_0
    //   1329: getfield 79	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:canceled	Z
    //   1332: ifeq +19 -> 1351
    //   1335: aload_3
    //   1336: ifnull +15 -> 1351
    //   1339: new 328	java/io/File
    //   1342: dup
    //   1343: aload_3
    //   1344: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   1347: invokevirtual 375	java/io/File:delete	()Z
    //   1350: pop
    //   1351: aload_1
    //   1352: athrow
    //   1353: astore_2
    //   1354: invokestatic 165	com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP:getLogger	()Lkellinwood/logging/LoggerInterface;
    //   1357: new 263	java/lang/StringBuilder
    //   1360: dup
    //   1361: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1364: aload_2
    //   1365: invokevirtual 571	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1368: invokevirtual 551	java/lang/Class:getName	()Ljava/lang/String;
    //   1371: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: ldc_w 862
    //   1377: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: aload_2
    //   1381: invokevirtual 863	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1384: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1390: invokeinterface 866 2 0
    //   1395: goto -44 -> 1351
    //   1398: astore_1
    //   1399: aconst_null
    //   1400: astore_2
    //   1401: goto -93 -> 1308
    //   1404: astore_1
    //   1405: goto -97 -> 1308
    //   1408: iload 5
    //   1410: iconst_3
    //   1411: iadd
    //   1412: istore 5
    //   1414: goto -1119 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1417	0	this	ZipSignerLP
    //   0	1417	1	paramMap	Map<String, ZioEntry>
    //   0	1417	2	paramOutputStream	OutputStream
    //   0	1417	3	paramString	String
    //   0	1417	4	paramArrayList	ArrayList<AddFilesItem>
    //   280	1133	5	i	int
    //   8	1119	6	bool1	boolean
    //   436	169	7	bool2	boolean
    //   421	693	8	l	long
    //   56	1054	10	localObject1	Object
    //   315	683	11	localObject2	Object
    //   322	663	12	localObject3	Object
    //   767	55	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   223	235	236	java/lang/Throwable
    //   474	486	487	java/lang/Throwable
    //   640	652	653	java/lang/Throwable
    //   1052	1064	1065	java/lang/Throwable
    //   1162	1174	1175	java/lang/Throwable
    //   1249	1261	1262	java/lang/Throwable
    //   116	126	1305	finally
    //   1339	1351	1353	java/lang/Throwable
    //   126	142	1398	finally
    //   142	192	1404	finally
    //   282	295	1404	finally
    //   295	382	1404	finally
    //   385	438	1404	finally
    //   530	604	1404	finally
    //   696	703	1404	finally
    //   708	758	1404	finally
    //   758	802	1404	finally
    //   807	954	1404	finally
    //   954	1016	1404	finally
    //   1108	1126	1404	finally
  }
  
  public void signZip(Map<String, ZioEntry> paramMap, String paramString, ArrayList<AddFilesItem> paramArrayList)
    throws IOException, GeneralSecurityException
  {
    this.progressHelper.initProgress();
    signZip(paramMap, new FileOutputStream(paramString), paramString, paramArrayList);
  }
  
  public static class AutoKeyObservable
    extends Observable
  {
    public void notifyObservers(Object paramObject)
    {
      super.setChanged();
      super.notifyObservers(paramObject);
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/ZipSignerLP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */