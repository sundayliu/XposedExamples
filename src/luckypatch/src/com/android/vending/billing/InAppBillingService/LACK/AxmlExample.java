package com.android.vending.billing.InAppBillingService.LACK;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import pxb.android.axml.AxmlReader;
import pxb.android.axml.AxmlVisitor;
import pxb.android.axml.AxmlWriter;
import pxb.android.axml.NodeVisitor;

public class AxmlExample
{
  public static boolean result = false;
  ArrayList<String> activities = new ArrayList();
  boolean found1 = false;
  boolean found2 = false;
  ArrayList<String> permissions = new ArrayList();
  
  public boolean changePackageName(File paramFile, final String paramString1, final String paramString2)
    throws IOException
  {
    result = false;
    Object localObject = new byte[(int)paramFile.length()];
    try
    {
      new FileInputStream(paramFile).read((byte[])localObject);
      localObject = new AxmlReader((byte[])localObject);
      AxmlWriter localAxmlWriter = new AxmlWriter();
      ((AxmlReader)localObject).accept(new AxmlVisitor(localAxmlWriter)
      {
        public NodeVisitor child(String paramAnonymousString1, String paramAnonymousString2)
        {
          new NodeVisitor(super.child(paramAnonymousString1, paramAnonymousString2))
          {
            public void attr(String paramAnonymous2String1, String paramAnonymous2String2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object)
            {
              System.out.println(paramAnonymous2String1 + " " + paramAnonymous2String2 + " " + paramAnonymous2Int1 + " " + paramAnonymous2Int2 + " " + paramAnonymous2Object);
              if (paramAnonymous2String2.equals("package"))
              {
                paramAnonymous2Object = paramAnonymous2Object.toString().replaceAll(AxmlExample.3.this.val$oldPackageName, AxmlExample.3.this.val$newPackageName);
                System.out.println("Replace package name to:" + (String)paramAnonymous2Object);
                super.attr(paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Object);
                AxmlExample.result = true;
                return;
              }
              super.attr(paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Object);
            }
            
            public NodeVisitor child(String paramAnonymous2String1, String paramAnonymous2String2)
            {
              System.out.println(paramAnonymous2String1 + " " + paramAnonymous2String2);
              new NodeVisitor(super.child(paramAnonymous2String1, paramAnonymous2String2))
              {
                public void attr(String paramAnonymous3String1, String paramAnonymous3String2, int paramAnonymous3Int1, int paramAnonymous3Int2, Object paramAnonymous3Object)
                {
                  System.out.println(paramAnonymous3String1 + " " + paramAnonymous3String2 + " " + paramAnonymous3Int1 + " " + paramAnonymous3Int2 + " " + paramAnonymous3Object);
                  if (paramAnonymous3Int2 == 3)
                  {
                    int j = 0;
                    int i = j;
                    String str;
                    if (paramAnonymous3Object.toString().contains("permission.C2D_MESSAGE"))
                    {
                      i = j;
                      if (paramAnonymous3Object.toString().startsWith(AxmlExample.3.this.val$oldPackageName))
                      {
                        str = paramAnonymous3Object.toString().replaceAll(AxmlExample.3.this.val$oldPackageName, AxmlExample.3.this.val$newPackageName);
                        System.out.println("Replace package name to:" + str);
                        super.attr(paramAnonymous3String1, paramAnonymous3String2, paramAnonymous3Int1, paramAnonymous3Int2, str);
                        AxmlExample.result = true;
                        i = 1;
                      }
                    }
                    if (paramAnonymous3Object.toString().startsWith("."))
                    {
                      str = AxmlExample.3.this.val$oldPackageName + paramAnonymous3Object.toString();
                      System.out.println("Replace package name to:" + str);
                      super.attr(paramAnonymous3String1, paramAnonymous3String2, paramAnonymous3Int1, paramAnonymous3Int2, str);
                      AxmlExample.result = true;
                      i = 1;
                    }
                    if (i == 0) {
                      super.attr(paramAnonymous3String1, paramAnonymous3String2, paramAnonymous3Int1, paramAnonymous3Int2, paramAnonymous3Object);
                    }
                    return;
                  }
                  super.attr(paramAnonymous3String1, paramAnonymous3String2, paramAnonymous3Int1, paramAnonymous3Int2, paramAnonymous3Object);
                }
                
                public NodeVisitor child(String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  System.out.println(paramAnonymous3String1 + " " + paramAnonymous3String2);
                  new NodeVisitor(super.child(paramAnonymous3String1, paramAnonymous3String2))
                  {
                    public void attr(String paramAnonymous4String1, String paramAnonymous4String2, int paramAnonymous4Int1, int paramAnonymous4Int2, Object paramAnonymous4Object)
                    {
                      System.out.println(paramAnonymous4String1 + " " + paramAnonymous4String2 + " " + paramAnonymous4Int1 + " " + paramAnonymous4Int2 + " " + paramAnonymous4Object);
                      if ((paramAnonymous4Int2 == 3) && (paramAnonymous4Object.toString().startsWith(".")))
                      {
                        paramAnonymous4Object = AxmlExample.3.this.val$oldPackageName + paramAnonymous4Object.toString();
                        System.out.println("Replace package name to:" + (String)paramAnonymous4Object);
                        super.attr(paramAnonymous4String1, paramAnonymous4String2, paramAnonymous4Int1, paramAnonymous4Int2, paramAnonymous4Object);
                        AxmlExample.result = true;
                        return;
                      }
                      super.attr(paramAnonymous4String1, paramAnonymous4String2, paramAnonymous4Int1, paramAnonymous4Int2, paramAnonymous4Object);
                    }
                    
                    public NodeVisitor child(String paramAnonymous4String1, String paramAnonymous4String2)
                    {
                      System.out.println(paramAnonymous4String1 + " " + paramAnonymous4String2);
                      new NodeVisitor(super.child(paramAnonymous4String1, paramAnonymous4String2))
                      {
                        public void attr(String paramAnonymous5String1, String paramAnonymous5String2, int paramAnonymous5Int1, int paramAnonymous5Int2, Object paramAnonymous5Object)
                        {
                          System.out.println(paramAnonymous5String1 + " " + paramAnonymous5String2 + " " + paramAnonymous5Int1 + " " + paramAnonymous5Int2 + " " + paramAnonymous5Object);
                          if ((paramAnonymous5Int2 == 3) && (paramAnonymous5Object.toString().startsWith(".")))
                          {
                            paramAnonymous5Object = AxmlExample.3.this.val$oldPackageName + paramAnonymous5Object.toString();
                            System.out.println("Replace package name to:" + (String)paramAnonymous5Object);
                            super.attr(paramAnonymous5String1, paramAnonymous5String2, paramAnonymous5Int1, paramAnonymous5Int2, paramAnonymous5Object);
                            AxmlExample.result = true;
                            return;
                          }
                          super.attr(paramAnonymous5String1, paramAnonymous5String2, paramAnonymous5Int1, paramAnonymous5Int2, paramAnonymous5Object);
                        }
                      };
                    }
                  };
                }
              };
            }
          };
        }
      });
      paramString1 = localAxmlWriter.toByteArray();
    }
    catch (Exception localException)
    {
      try
      {
        paramFile.delete();
        paramFile.createNewFile();
        paramFile = new FileOutputStream(paramFile);
        paramFile.write(paramString1);
        paramFile.close();
        return result;
        localException = localException;
        localException.printStackTrace();
      }
      catch (IOException paramFile)
      {
        for (;;)
        {
          paramFile.printStackTrace();
        }
      }
    }
  }
  
  public boolean changeTargetApi(File paramFile, String paramString)
    throws IOException
  {
    result = false;
    paramString = new byte[(int)paramFile.length()];
    try
    {
      new FileInputStream(paramFile).read(paramString);
      paramString = new AxmlReader(paramString);
      AxmlWriter localAxmlWriter = new AxmlWriter();
      paramString.accept(new AxmlVisitor(localAxmlWriter)
      {
        public NodeVisitor child(String paramAnonymousString1, String paramAnonymousString2)
        {
          new NodeVisitor(super.child(paramAnonymousString1, paramAnonymousString2))
          {
            public NodeVisitor child(String paramAnonymous2String1, String paramAnonymous2String2)
            {
              if (paramAnonymous2String2.equals("uses-sdk")) {
                new NodeVisitor(super.child(paramAnonymous2String1, paramAnonymous2String2))
                {
                  public void attr(String paramAnonymous3String1, String paramAnonymous3String2, int paramAnonymous3Int1, int paramAnonymous3Int2, Object paramAnonymous3Object)
                  {
                    System.out.println(paramAnonymous3String1 + " " + paramAnonymous3String2 + " " + paramAnonymous3Int1 + " " + paramAnonymous3Int2 + " " + paramAnonymous3Object);
                    if (("http://schemas.android.com/apk/res/android".equals(paramAnonymous3String1)) && (paramAnonymous3String2.equals("targetSdkVersion")))
                    {
                      Integer localInteger = (Integer)paramAnonymous3Object;
                      System.out.println(paramAnonymous3String2 + ":" + paramAnonymous3Object + " " + localInteger);
                      AxmlExample.this.found1 = false;
                      if (localInteger.intValue() >= 21)
                      {
                        System.out.println("Found " + paramAnonymous3Object);
                        super.attr(paramAnonymous3String1, paramAnonymous3String2, paramAnonymous3Int1, paramAnonymous3Int2, Integer.valueOf(20));
                        AxmlExample.result = true;
                      }
                      return;
                    }
                    super.attr(paramAnonymous3String1, paramAnonymous3String2, paramAnonymous3Int1, paramAnonymous3Int2, paramAnonymous3Object);
                  }
                };
              }
              new NodeVisitor(super.child(paramAnonymous2String1, paramAnonymous2String2))
              {
                public NodeVisitor child(String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  return super.child(paramAnonymous3String1, paramAnonymous3String2);
                }
                
                public void end()
                {
                  super.end();
                }
              };
            }
          };
        }
      });
      paramString = localAxmlWriter.toByteArray();
    }
    catch (Exception localException)
    {
      try
      {
        paramFile.delete();
        paramFile.createNewFile();
        paramFile = new FileOutputStream(paramFile);
        paramFile.write(paramString);
        paramFile.close();
        return result;
        localException = localException;
        localException.printStackTrace();
      }
      catch (IOException paramFile)
      {
        for (;;)
        {
          paramFile.printStackTrace();
        }
      }
    }
  }
  
  public void disablePermisson(File paramFile, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
    throws IOException
  {
    this.permissions = paramArrayList1;
    this.activities = paramArrayList2;
    paramArrayList1 = new byte[(int)paramFile.length()];
    try
    {
      new FileInputStream(paramFile).read(paramArrayList1);
      paramArrayList1 = new AxmlReader(paramArrayList1);
      paramArrayList2 = new AxmlWriter();
      paramArrayList1.accept(new AxmlVisitor(paramArrayList2)
      {
        public NodeVisitor child(String paramAnonymousString1, String paramAnonymousString2)
        {
          new NodeVisitor(super.child(paramAnonymousString1, paramAnonymousString2))
          {
            public NodeVisitor child(String paramAnonymous2String1, String paramAnonymous2String2)
            {
              if (paramAnonymous2String2.equals("uses-permission")) {
                new NodeVisitor(super.child(paramAnonymous2String1, paramAnonymous2String2))
                {
                  public void attr(String paramAnonymous3String1, String paramAnonymous3String2, int paramAnonymous3Int1, int paramAnonymous3Int2, Object paramAnonymous3Object)
                  {
                    if (("http://schemas.android.com/apk/res/android".equals(paramAnonymous3String1)) && (paramAnonymous3String2.equals("name")))
                    {
                      String str1 = (String)paramAnonymous3Object;
                      System.out.println("name " + paramAnonymous3String2 + " " + "obj " + paramAnonymous3Object);
                      AxmlExample.this.found1 = false;
                      Iterator localIterator = AxmlExample.this.permissions.iterator();
                      while (localIterator.hasNext())
                      {
                        String str2 = (String)localIterator.next();
                        if (str1.contains(str2))
                        {
                          System.out.println("Found " + paramAnonymous3Object);
                          if (!str1.startsWith("disabled_")) {}
                          for (paramAnonymous3Object = str1.replace(str2, "disabled_" + str2);; paramAnonymous3Object = str1.replace("disabled_", ""))
                          {
                            AxmlExample.this.found1 = true;
                            super.attr(paramAnonymous3String1, paramAnonymous3String2, paramAnonymous3Int1, paramAnonymous3Int2, paramAnonymous3Object);
                            break;
                          }
                        }
                      }
                      if (!AxmlExample.this.found1) {
                        super.attr(paramAnonymous3String1, paramAnonymous3String2, paramAnonymous3Int1, paramAnonymous3Int2, paramAnonymous3Object);
                      }
                      return;
                    }
                    super.attr(paramAnonymous3String1, paramAnonymous3String2, paramAnonymous3Int1, paramAnonymous3Int2, paramAnonymous3Object);
                  }
                };
              }
              new NodeVisitor(super.child(paramAnonymous2String1, paramAnonymous2String2))
              {
                public NodeVisitor child(String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  if (paramAnonymous3String2.equals("activity")) {
                    new NodeVisitor(super.child(paramAnonymous3String1, paramAnonymous3String2))
                    {
                      public void attr(String paramAnonymous4String1, String paramAnonymous4String2, int paramAnonymous4Int1, int paramAnonymous4Int2, Object paramAnonymous4Object)
                      {
                        if (("http://schemas.android.com/apk/res/android".equals(paramAnonymous4String1)) && (paramAnonymous4String2.equals("name")))
                        {
                          String str = (String)paramAnonymous4Object;
                          System.out.println("name " + paramAnonymous4String2 + " " + "obj " + paramAnonymous4Object);
                          AxmlExample.this.found2 = false;
                          Iterator localIterator = AxmlExample.this.activities.iterator();
                          while (localIterator.hasNext()) {
                            if (((String)localIterator.next()).replace("chelpus_", "").contains(str))
                            {
                              System.out.println("Found " + paramAnonymous4Object);
                              if (str.replace("chelpus_", "").startsWith("disabled_")) {}
                              for (paramAnonymous4Object = str.replace("disabled_", "");; paramAnonymous4Object = str.replace(str, "disabled_" + str))
                              {
                                AxmlExample.this.found2 = true;
                                super.attr(paramAnonymous4String1, paramAnonymous4String2, paramAnonymous4Int1, paramAnonymous4Int2, paramAnonymous4Object);
                                break;
                              }
                            }
                          }
                          super.attr(paramAnonymous4String1, paramAnonymous4String2, paramAnonymous4Int1, paramAnonymous4Int2, paramAnonymous4Object);
                          return;
                        }
                        super.attr(paramAnonymous4String1, paramAnonymous4String2, paramAnonymous4Int1, paramAnonymous4Int2, paramAnonymous4Object);
                      }
                    };
                  }
                  return super.child(paramAnonymous3String1, paramAnonymous3String2);
                }
                
                public void end()
                {
                  System.out.println("End");
                  super.end();
                }
              };
            }
          };
        }
      });
      paramArrayList1 = paramArrayList2.toByteArray();
    }
    catch (Exception paramArrayList2)
    {
      for (;;)
      {
        try
        {
          paramFile.delete();
          paramFile.createNewFile();
          paramFile = new FileOutputStream(paramFile);
          paramFile.write(paramArrayList1);
          paramFile.close();
          return;
        }
        catch (IOException paramFile)
        {
          paramFile.printStackTrace();
        }
        paramArrayList2 = paramArrayList2;
        paramArrayList2.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/AxmlExample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */