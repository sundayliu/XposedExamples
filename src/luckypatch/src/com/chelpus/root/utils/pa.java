package com.chelpus.root.utils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class pa
{
  public static void main(String[] paramArrayOfString)
  {
    Utils.startRootJava(new Object() {});
    str1 = paramArrayOfString[0];
    paramArrayOfString = paramArrayOfString[1];
    localSQLiteDatabase = null;
    Object localObject1 = null;
    paramArrayOfString = localSQLiteDatabase;
    try
    {
      str2 = new Utils("asd").findFile(new File("/data/data/com.maxmpz.audioplayer/"), "folders.db");
      paramArrayOfString = localSQLiteDatabase;
      if (str2.equals("")) {
        break label489;
      }
      paramArrayOfString = localSQLiteDatabase;
      Utils.run_all_no_root(new String[] { "chmod", "777", str2 });
      paramArrayOfString = localSQLiteDatabase;
      localSQLiteDatabase = SQLiteDatabase.openDatabase(str2, null, 0);
      paramArrayOfString = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase.query("storages", new String[] { "_id", "path", "path_hash", "updated_at" }, null, null, null, null, null);
      paramArrayOfString = localSQLiteDatabase;
      ((Cursor)localObject3).moveToFirst();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2;
        Object localObject3;
        paramArrayOfString.close();
        localException.printStackTrace();
        continue;
        paramArrayOfString = localException;
        try
        {
          if (localException.length() < 4) {
            paramArrayOfString = Environment.getExternalStorageDirectory().getAbsolutePath();
          }
          System.out.println("2 " + paramArrayOfString);
        }
        catch (Exception paramArrayOfString)
        {
          for (;;)
          {
            paramArrayOfString = localSQLiteDatabase;
            Object localObject2 = Environment.getExternalStorageDirectory().getAbsolutePath();
            paramArrayOfString = localSQLiteDatabase;
            System.out.println("3 " + (String)localObject2);
            paramArrayOfString = (String[])localObject2;
          }
        }
        localObject2 = paramArrayOfString;
        if (paramArrayOfString == null) {
          localObject2 = "/mnt/sdcard";
        }
        paramArrayOfString = localSQLiteDatabase;
        localSQLiteDatabase.execSQL("UPDATE storages SET path='" + (String)localObject2 + "',path_hash='" + str1 + "',updated_at='" + System.currentTimeMillis() + "'");
        paramArrayOfString = localSQLiteDatabase;
        System.out.println("Add info");
        continue;
        paramArrayOfString = localSQLiteDatabase;
        System.out.println("SU Java-Code Running!\nYou must run Poweramp before patch!\nRun Poweramp and apply custom patch again!\n\nGood Luck!\nSaNX@forpda.ru");
      }
    }
    paramArrayOfString = localSQLiteDatabase;
    localObject1 = ((Cursor)localObject3).getString(((Cursor)localObject3).getColumnIndex("path"));
    try
    {
      if (!((Cursor)localObject3).moveToNext())
      {
        ((Cursor)localObject3).close();
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "/mnt/sdcard";
        }
        paramArrayOfString = localSQLiteDatabase;
        System.out.println("4 " + (String)localObject3);
        paramArrayOfString = localSQLiteDatabase;
        localSQLiteDatabase.execSQL("UPDATE storages SET path='" + (String)localObject3 + "',path_hash='" + str1 + "',updated_at='" + System.currentTimeMillis() + "'");
        paramArrayOfString = localSQLiteDatabase;
        System.out.println("Add info");
        localObject1 = localSQLiteDatabase;
        paramArrayOfString = (String[])localObject1;
        ((SQLiteDatabase)localObject1).close();
        paramArrayOfString = (String[])localObject1;
        Utils.run_all_no_root(new String[] { "chmod", "644", str2 });
        Utils.exitFromRootJava();
        return;
      }
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString = localSQLiteDatabase;
        ((Cursor)localObject3).close();
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/root/utils/pa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */