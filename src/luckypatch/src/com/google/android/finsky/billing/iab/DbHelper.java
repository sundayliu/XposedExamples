package com.google.android.finsky.billing.iab;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.vending.billing.InAppBillingService.LACK.PkgListItem;
import com.android.vending.billing.InAppBillingService.LACK.listAppsFragment;
import com.chelpus.Utils;
import java.io.PrintStream;
import java.util.List;

public class DbHelper
  extends SQLiteOpenHelper
{
  static final String autobuy = "autobuy";
  public static Context contextdb = null;
  static final String dbName = "BillingRestoreTransactions";
  public static boolean getPackage = false;
  static final String itemID = "itemID";
  static final String pData = "Data";
  static final String pSignature = "Signature";
  static String packageTable = "Packages";
  public static boolean savePackage = false;
  static final String save_purschase = "savePurchase";
  
  public DbHelper(Context paramContext)
  {
    super(paramContext, "BillingRestoreTransactions", null, 48);
    contextdb = paramContext;
    packageTable = packageTable;
    try
    {
      if (listAppsFragment.billing_db == null) {}
      for (listAppsFragment.billing_db = getWritableDatabase();; listAppsFragment.billing_db = getWritableDatabase())
      {
        onCreate(listAppsFragment.billing_db);
        return;
        listAppsFragment.billing_db.close();
      }
      return;
    }
    catch (SQLiteException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public DbHelper(Context paramContext, String paramString)
  {
    super(paramContext, "BillingRestoreTransactions", null, 48);
    contextdb = paramContext;
    packageTable = paramString;
    try
    {
      if (listAppsFragment.billing_db == null) {}
      for (listAppsFragment.billing_db = getWritableDatabase();; listAppsFragment.billing_db = getWritableDatabase())
      {
        listAppsFragment.billing_db = listAppsFragment.billing_db;
        onCreate(listAppsFragment.billing_db);
        return;
        listAppsFragment.billing_db.close();
      }
      return;
    }
    catch (SQLiteException paramContext)
    {
      paramContext.printStackTrace();
      if (((paramContext.toString().contains("Could not open the database")) || (paramContext.toString().contains("readonly"))) && (listAppsFragment.su))
      {
        System.out.println("LP: Delete bad database.");
        new Utils("").cmdRoot(new String[] { "rm -r /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases/" + getDatabaseName() });
        new Utils("").cmdRoot(new String[] { "rm /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases/" + getDatabaseName() });
      }
    }
  }
  
  public void deleteAll() {}
  
  public void deleteItem(ItemsListItem paramItemsListItem)
  {
    try
    {
      listAppsFragment.billing_db.delete("'" + packageTable + "'", "itemID = '" + paramItemsListItem.itemID + "'", null);
      return;
    }
    catch (Exception paramItemsListItem)
    {
      System.out.println("LuckyPatcher-Error: deletePackage " + paramItemsListItem);
    }
  }
  
  public void deleteItem(String paramString)
  {
    try
    {
      listAppsFragment.billing_db.delete("'" + packageTable + "'", "itemID = '" + paramString + "'", null);
      return;
    }
    catch (Exception paramString)
    {
      System.out.println("LuckyPatcher-Error: deletePackage " + paramString);
    }
  }
  
  /* Error */
  public java.util.ArrayList<ItemsListItem> getItems()
  {
    // Byte code:
    //   0: new 167	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 168	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 171	java/util/ArrayList:clear	()V
    //   12: getstatic 54	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:billing_db	Landroid/database/sqlite/SQLiteDatabase;
    //   15: new 110	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   22: ldc -110
    //   24: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: getstatic 34	com/google/android/finsky/billing/iab/DbHelper:packageTable	Ljava/lang/String;
    //   30: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc -110
    //   35: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: iconst_5
    //   42: anewarray 79	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: ldc 17
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: ldc 20
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: ldc 23
    //   59: aastore
    //   60: dup
    //   61: iconst_3
    //   62: ldc 28
    //   64: aastore
    //   65: dup
    //   66: iconst_4
    //   67: ldc 7
    //   69: aastore
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: invokevirtual 175	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore_2
    //   79: aload_2
    //   80: invokeinterface 181 1 0
    //   85: pop
    //   86: aload_2
    //   87: aload_2
    //   88: ldc 17
    //   90: invokeinterface 185 2 0
    //   95: invokeinterface 189 2 0
    //   100: astore_3
    //   101: aload_1
    //   102: new 150	com/google/android/finsky/billing/iab/ItemsListItem
    //   105: dup
    //   106: aload_3
    //   107: aload_2
    //   108: aload_2
    //   109: ldc 20
    //   111: invokeinterface 192 2 0
    //   116: invokeinterface 189 2 0
    //   121: aload_2
    //   122: aload_2
    //   123: ldc 23
    //   125: invokeinterface 192 2 0
    //   130: invokeinterface 189 2 0
    //   135: aload_2
    //   136: aload_2
    //   137: ldc 28
    //   139: invokeinterface 192 2 0
    //   144: invokeinterface 196 2 0
    //   149: aload_2
    //   150: aload_2
    //   151: ldc 7
    //   153: invokeinterface 192 2 0
    //   158: invokeinterface 196 2 0
    //   163: invokespecial 199	com/google/android/finsky/billing/iab/ItemsListItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    //   166: invokevirtual 203	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   169: pop
    //   170: aload_2
    //   171: invokeinterface 206 1 0
    //   176: ifne -90 -> 86
    //   179: aload_2
    //   180: invokeinterface 207 1 0
    //   185: iconst_0
    //   186: putstatic 38	com/google/android/finsky/billing/iab/DbHelper:getPackage	Z
    //   189: aload_1
    //   190: areturn
    //   191: astore_3
    //   192: aload_2
    //   193: invokeinterface 207 1 0
    //   198: goto -13 -> 185
    //   201: astore_2
    //   202: iconst_0
    //   203: putstatic 38	com/google/android/finsky/billing/iab/DbHelper:getPackage	Z
    //   206: getstatic 94	java/lang/System:out	Ljava/io/PrintStream;
    //   209: new 110	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   216: ldc -47
    //   218: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_2
    //   222: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   231: aload_1
    //   232: areturn
    //   233: astore_3
    //   234: goto -64 -> 170
    //   237: astore_3
    //   238: goto -68 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	DbHelper
    //   7	225	1	localArrayList	java.util.ArrayList
    //   78	115	2	localCursor	android.database.Cursor
    //   201	21	2	localException1	Exception
    //   100	7	3	str	String
    //   191	1	3	localException2	Exception
    //   233	1	3	localException3	Exception
    //   237	1	3	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   170	185	191	java/lang/Exception
    //   12	86	201	java/lang/Exception
    //   185	189	201	java/lang/Exception
    //   192	198	201	java/lang/Exception
    //   86	101	233	java/lang/Exception
    //   101	170	233	java/lang/Exception
    //   101	170	237	java/lang/IllegalArgumentException
  }
  
  public boolean isOpen()
  {
    return listAppsFragment.billing_db.isOpen();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS '" + packageTable + "' (" + "itemID" + " TEXT PRIMARY KEY, " + "Data" + " TEXT, " + "Signature" + " TEXT, " + "savePurchase" + " INTEGER, " + "autobuy" + " INTEGER" + ");");
  }
  
  /* Error */
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: getstatic 94	java/lang/System:out	Ljava/io/PrintStream;
    //   3: new 110	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   10: ldc -22
    //   12: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_2
    //   16: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc -17
    //   21: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_3
    //   25: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   34: getstatic 94	java/lang/System:out	Ljava/io/PrintStream;
    //   37: new 110	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   44: ldc -15
    //   46: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 245	android/database/sqlite/SQLiteDatabase:getVersion	()I
    //   53: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   62: aload_1
    //   63: ldc -9
    //   65: aconst_null
    //   66: invokevirtual 251	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   69: astore 4
    //   71: aload 4
    //   73: invokeinterface 181 1 0
    //   78: ifeq +224 -> 302
    //   81: aload 4
    //   83: invokeinterface 254 1 0
    //   88: ifne +214 -> 302
    //   91: getstatic 94	java/lang/System:out	Ljava/io/PrintStream;
    //   94: ldc_w 256
    //   97: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   100: aload_1
    //   101: new 110	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 258
    //   111: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 4
    //   116: iconst_0
    //   117: invokeinterface 189 2 0
    //   122: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 260
    //   128: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokevirtual 230	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   137: aload 4
    //   139: invokeinterface 206 1 0
    //   144: pop
    //   145: goto -64 -> 81
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 70	android/database/sqlite/SQLiteException:printStackTrace	()V
    //   153: aload_1
    //   154: invokevirtual 75	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   157: ldc 77
    //   159: invokevirtual 83	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   162: ifeq +129 -> 291
    //   165: getstatic 88	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:su	Z
    //   168: ifeq +123 -> 291
    //   171: getstatic 94	java/lang/System:out	Ljava/io/PrintStream;
    //   174: ldc 96
    //   176: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   179: new 104	com/chelpus/Utils
    //   182: dup
    //   183: ldc 106
    //   185: invokespecial 108	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   188: iconst_1
    //   189: anewarray 79	java/lang/String
    //   192: dup
    //   193: iconst_0
    //   194: new 110	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   201: ldc 114
    //   203: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokestatic 122	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   209: invokevirtual 127	android/content/Context:getPackageName	()Ljava/lang/String;
    //   212: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc -127
    //   217: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: invokevirtual 132	com/google/android/finsky/billing/iab/DbHelper:getDatabaseName	()Ljava/lang/String;
    //   224: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: aastore
    //   231: invokevirtual 137	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
    //   234: pop
    //   235: new 104	com/chelpus/Utils
    //   238: dup
    //   239: ldc 106
    //   241: invokespecial 108	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   244: iconst_1
    //   245: anewarray 79	java/lang/String
    //   248: dup
    //   249: iconst_0
    //   250: new 110	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   257: ldc -117
    //   259: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokestatic 122	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   265: invokevirtual 127	android/content/Context:getPackageName	()Ljava/lang/String;
    //   268: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc -127
    //   273: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: invokevirtual 132	com/google/android/finsky/billing/iab/DbHelper:getDatabaseName	()Ljava/lang/String;
    //   280: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: aastore
    //   287: invokevirtual 137	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
    //   290: pop
    //   291: return
    //   292: astore 5
    //   294: aload 5
    //   296: invokevirtual 70	android/database/sqlite/SQLiteException:printStackTrace	()V
    //   299: goto -162 -> 137
    //   302: aload_0
    //   303: aload_1
    //   304: invokevirtual 62	com/google/android/finsky/billing/iab/DbHelper:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   307: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	DbHelper
    //   0	308	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	308	2	paramInt1	int
    //   0	308	3	paramInt2	int
    //   69	69	4	localCursor	android.database.Cursor
    //   292	3	5	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   34	81	148	android/database/sqlite/SQLiteException
    //   81	100	148	android/database/sqlite/SQLiteException
    //   137	145	148	android/database/sqlite/SQLiteException
    //   294	299	148	android/database/sqlite/SQLiteException
    //   302	307	148	android/database/sqlite/SQLiteException
    //   100	137	292	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: getstatic 94	java/lang/System:out	Ljava/io/PrintStream;
    //   3: new 110	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   10: ldc -22
    //   12: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_2
    //   16: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc -17
    //   21: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_3
    //   25: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   34: getstatic 94	java/lang/System:out	Ljava/io/PrintStream;
    //   37: new 110	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   44: ldc -15
    //   46: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 245	android/database/sqlite/SQLiteDatabase:getVersion	()I
    //   53: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   62: iload_3
    //   63: iload_2
    //   64: if_icmple +419 -> 483
    //   67: aload_1
    //   68: ldc -9
    //   70: aconst_null
    //   71: invokevirtual 251	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore 4
    //   76: aload 4
    //   78: invokeinterface 181 1 0
    //   83: ifeq +389 -> 472
    //   86: aload 4
    //   88: invokeinterface 254 1 0
    //   93: ifne +379 -> 472
    //   96: getstatic 94	java/lang/System:out	Ljava/io/PrintStream;
    //   99: ldc_w 263
    //   102: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   105: aload_1
    //   106: new 110	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 265
    //   116: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 4
    //   121: iconst_0
    //   122: invokeinterface 189 2 0
    //   127: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 267
    //   133: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 28
    //   138: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc_w 269
    //   144: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 230	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   153: aload_1
    //   154: new 110	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 271
    //   164: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 4
    //   169: iconst_0
    //   170: invokeinterface 189 2 0
    //   175: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 273
    //   181: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc 28
    //   186: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 275
    //   192: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokevirtual 230	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   201: aload_1
    //   202: new 110	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 265
    //   212: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 4
    //   217: iconst_0
    //   218: invokeinterface 189 2 0
    //   223: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 267
    //   229: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 7
    //   234: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc_w 269
    //   240: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokevirtual 230	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   249: aload_1
    //   250: new 110	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   257: ldc_w 271
    //   260: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload 4
    //   265: iconst_0
    //   266: invokeinterface 189 2 0
    //   271: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 273
    //   277: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc 7
    //   282: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 277
    //   288: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokevirtual 230	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   297: aload 4
    //   299: invokeinterface 206 1 0
    //   304: pop
    //   305: goto -219 -> 86
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 70	android/database/sqlite/SQLiteException:printStackTrace	()V
    //   313: aload_1
    //   314: invokevirtual 75	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   317: ldc 77
    //   319: invokevirtual 83	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   322: ifeq +129 -> 451
    //   325: getstatic 88	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:su	Z
    //   328: ifeq +123 -> 451
    //   331: getstatic 94	java/lang/System:out	Ljava/io/PrintStream;
    //   334: ldc 96
    //   336: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   339: new 104	com/chelpus/Utils
    //   342: dup
    //   343: ldc 106
    //   345: invokespecial 108	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   348: iconst_1
    //   349: anewarray 79	java/lang/String
    //   352: dup
    //   353: iconst_0
    //   354: new 110	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   361: ldc 114
    //   363: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokestatic 122	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   369: invokevirtual 127	android/content/Context:getPackageName	()Ljava/lang/String;
    //   372: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc -127
    //   377: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_0
    //   381: invokevirtual 132	com/google/android/finsky/billing/iab/DbHelper:getDatabaseName	()Ljava/lang/String;
    //   384: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: aastore
    //   391: invokevirtual 137	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
    //   394: pop
    //   395: new 104	com/chelpus/Utils
    //   398: dup
    //   399: ldc 106
    //   401: invokespecial 108	com/chelpus/Utils:<init>	(Ljava/lang/String;)V
    //   404: iconst_1
    //   405: anewarray 79	java/lang/String
    //   408: dup
    //   409: iconst_0
    //   410: new 110	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   417: ldc -117
    //   419: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokestatic 122	com/android/vending/billing/InAppBillingService/LACK/listAppsFragment:getInstance	()Landroid/content/Context;
    //   425: invokevirtual 127	android/content/Context:getPackageName	()Ljava/lang/String;
    //   428: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc -127
    //   433: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload_0
    //   437: invokevirtual 132	com/google/android/finsky/billing/iab/DbHelper:getDatabaseName	()Ljava/lang/String;
    //   440: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: aastore
    //   447: invokevirtual 137	com/chelpus/Utils:cmdRoot	([Ljava/lang/String;)Ljava/lang/String;
    //   450: pop
    //   451: return
    //   452: astore 5
    //   454: aload 5
    //   456: invokevirtual 70	android/database/sqlite/SQLiteException:printStackTrace	()V
    //   459: goto -258 -> 201
    //   462: astore 5
    //   464: aload 5
    //   466: invokevirtual 70	android/database/sqlite/SQLiteException:printStackTrace	()V
    //   469: goto -172 -> 297
    //   472: aload_0
    //   473: aload_1
    //   474: invokevirtual 62	com/google/android/finsky/billing/iab/DbHelper:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   477: aload_0
    //   478: aload_1
    //   479: invokevirtual 62	com/google/android/finsky/billing/iab/DbHelper:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   482: return
    //   483: aload_1
    //   484: ldc -9
    //   486: aconst_null
    //   487: invokevirtual 251	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   490: astore 4
    //   492: aload 4
    //   494: invokeinterface 181 1 0
    //   499: ifeq -22 -> 477
    //   502: aload 4
    //   504: invokeinterface 254 1 0
    //   509: ifne -32 -> 477
    //   512: getstatic 94	java/lang/System:out	Ljava/io/PrintStream;
    //   515: ldc_w 256
    //   518: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   521: aload_1
    //   522: new 110	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   529: ldc_w 258
    //   532: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload 4
    //   537: iconst_0
    //   538: invokeinterface 189 2 0
    //   543: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: ldc_w 260
    //   549: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokevirtual 230	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   558: aload 4
    //   560: invokeinterface 206 1 0
    //   565: pop
    //   566: goto -64 -> 502
    //   569: astore 5
    //   571: aload 5
    //   573: invokevirtual 70	android/database/sqlite/SQLiteException:printStackTrace	()V
    //   576: goto -18 -> 558
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	DbHelper
    //   0	579	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	579	2	paramInt1	int
    //   0	579	3	paramInt2	int
    //   74	485	4	localCursor	android.database.Cursor
    //   452	3	5	localSQLiteException1	SQLiteException
    //   462	3	5	localSQLiteException2	SQLiteException
    //   569	3	5	localSQLiteException3	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   34	62	308	android/database/sqlite/SQLiteException
    //   67	86	308	android/database/sqlite/SQLiteException
    //   86	105	308	android/database/sqlite/SQLiteException
    //   297	305	308	android/database/sqlite/SQLiteException
    //   454	459	308	android/database/sqlite/SQLiteException
    //   464	469	308	android/database/sqlite/SQLiteException
    //   472	477	308	android/database/sqlite/SQLiteException
    //   477	482	308	android/database/sqlite/SQLiteException
    //   483	502	308	android/database/sqlite/SQLiteException
    //   502	521	308	android/database/sqlite/SQLiteException
    //   558	566	308	android/database/sqlite/SQLiteException
    //   571	576	308	android/database/sqlite/SQLiteException
    //   105	201	452	android/database/sqlite/SQLiteException
    //   201	297	462	android/database/sqlite/SQLiteException
    //   521	558	569	android/database/sqlite/SQLiteException
  }
  
  public void saveItem(ItemsListItem paramItemsListItem)
    throws SQLiteException
  {
    try
    {
      savePackage = true;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("itemID", paramItemsListItem.itemID);
      localContentValues.put("Data", paramItemsListItem.pData);
      localContentValues.put("Signature", paramItemsListItem.pSignature);
      localContentValues.put("savePurchase", Integer.valueOf(paramItemsListItem.savePurchase));
      localContentValues.put("autobuy", Integer.valueOf(paramItemsListItem.autobuy));
      try
      {
        listAppsFragment.billing_db.insertOrThrow("'" + packageTable + "'", "itemID", localContentValues);
        savePackage = false;
        savePackage = false;
        return;
      }
      catch (Exception paramItemsListItem)
      {
        for (;;)
        {
          listAppsFragment.billing_db.replace("'" + packageTable + "'", null, localContentValues);
        }
      }
      return;
    }
    catch (Exception paramItemsListItem)
    {
      savePackage = false;
      System.out.println("LuckyPatcher-Error: savePackage " + paramItemsListItem);
    }
  }
  
  public void updatePackage(List<PkgListItem> paramList) {}
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/google/android/finsky/billing/iab/DbHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */