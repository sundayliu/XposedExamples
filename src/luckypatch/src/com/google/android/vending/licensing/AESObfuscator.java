package com.google.android.vending.licensing;

import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESObfuscator
  implements Obfuscator
{
  private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
  public static byte[] IV = { 16, 74, 71, -80, 32, 101, -47, 72, 117, -14, 0, -29, 70, 65, -12, 74 };
  private static final String KEYGEN_ALGORITHM = "PBEWITHSHAAND256BITAES-CBC-BC";
  private static final String UTF8 = "UTF-8";
  public static String header = "com.android.vending.licensing.AESObfuscator-1|";
  private Cipher mDecryptor;
  private Cipher mEncryptor;
  
  public AESObfuscator(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    try
    {
      paramArrayOfByte = new SecretKeySpec(SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC").generateSecret(new PBEKeySpec((paramString1 + paramString2).toCharArray(), paramArrayOfByte, 1024, 256)).getEncoded(), "AES");
      this.mEncryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
      this.mEncryptor.init(1, paramArrayOfByte, new IvParameterSpec(IV));
      this.mDecryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
      this.mDecryptor.init(2, paramArrayOfByte, new IvParameterSpec(IV));
      return;
    }
    catch (GeneralSecurityException paramArrayOfByte)
    {
      throw new RuntimeException("Invalid environment", paramArrayOfByte);
    }
  }
  
  public String obfuscate(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString1 = Base64.encode(this.mEncryptor.doFinal((header + paramString2 + paramString1).getBytes("UTF-8")));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new RuntimeException("Invalid environment", paramString1);
    }
    catch (GeneralSecurityException paramString1)
    {
      throw new RuntimeException("Invalid environment", paramString1);
    }
  }
  
  public String unobfuscate(String paramString1, String paramString2)
    throws ValidationException
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      str = new String(this.mDecryptor.doFinal(Base64.decode(paramString1)), "UTF-8");
      if (str.indexOf(header + paramString2) != 0) {
        throw new ValidationException("Header not found (invalid data or key):" + paramString1);
      }
    }
    catch (Base64DecoderException paramString2)
    {
      String str;
      throw new ValidationException(paramString2.getMessage() + ":" + paramString1);
      paramString2 = str.substring(header.length() + paramString2.length(), str.length());
      return paramString2;
    }
    catch (IllegalBlockSizeException paramString2)
    {
      throw new ValidationException(paramString2.getMessage() + ":" + paramString1);
    }
    catch (BadPaddingException paramString2)
    {
      throw new ValidationException(paramString2.getMessage() + ":" + paramString1);
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new RuntimeException("Invalid environment", paramString1);
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/vending/licensing/AESObfuscator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */