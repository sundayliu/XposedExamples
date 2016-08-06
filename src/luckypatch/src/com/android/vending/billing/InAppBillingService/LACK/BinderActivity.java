package com.android.vending.billing.InAppBillingService.LACK;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.android.vending.billing.InAppBillingService.LACK.widgets.BinderWidget;
import com.chelpus.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BinderActivity
  extends Activity
{
  public ArrayList<BindItem> bindes = null;
  public Context context;
  private ItemFile current;
  private ListView filebrowser;
  public ListView lv = null;
  private TextView myPath;
  public Dialog pp4 = null;
  private String root;
  public int sizeText = 0;
  
  public static ArrayList<BindItem> getBindes(Context paramContext)
  {
    localArrayList = new ArrayList();
    paramContext = new File(paramContext.getDir("binder", 0) + "/bind.txt");
    try
    {
      if (!paramContext.exists()) {
        paramContext.createNewFile();
      }
      paramContext = new FileInputStream(paramContext);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramContext, "UTF-8"));
      for (;;)
      {
        Object localObject = localBufferedReader.readLine();
        if (localObject == null) {
          break;
        }
        localObject = ((String)localObject).split(";");
        if (localObject.length == 2)
        {
          System.out.println(localObject[0] + " ; " + localObject[1]);
          localArrayList.add(new BindItem(localObject[0], localObject[1]));
        }
      }
      return localArrayList;
    }
    catch (FileNotFoundException paramContext)
    {
      System.out.println("Not found bind.txt");
      return localArrayList;
      paramContext.close();
      return localArrayList;
    }
    catch (IOException paramContext)
    {
      System.out.println("" + paramContext);
    }
  }
  
  private void getDir(String paramString, ListView paramListView)
  {
    this.myPath.setText(Utils.getText(2131165240) + " " + paramString);
    this.current = new ItemFile("/", paramString);
    ArrayList localArrayList = new ArrayList();
    File localFile = new File(paramString);
    File[] arrayOfFile = localFile.listFiles();
    if ((arrayOfFile != null) || (!paramString.equals(this.root)))
    {
      localArrayList.add(new ItemFile(this.root));
      localArrayList.add(new ItemFile("../", localFile.getParent()));
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      paramString = arrayOfFile[i];
      if ((paramString.canRead()) && ((paramString.isDirectory()) || (paramString.toString().toLowerCase().endsWith(".apk")))) {
        localArrayList.add(new ItemFile(paramString.toString()));
      }
      i += 1;
    }
    paramString = new ArrayAdapter(this, 2130968615, localArrayList)
    {
      public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        BinderActivity.ItemFile localItemFile = (BinderActivity.ItemFile)getItem(paramAnonymousInt);
        View localView = paramAnonymousView;
        paramAnonymousView = localView;
        if (localView == null) {
          paramAnonymousView = BinderActivity.this.getLayoutInflater().inflate(2130968615, paramAnonymousViewGroup, false);
        }
        paramAnonymousViewGroup = (TextView)paramAnonymousView.findViewById(2131558562);
        paramAnonymousViewGroup.setTextAppearance(BinderActivity.this.context, listAppsFragment.getSizeText());
        paramAnonymousViewGroup.setText(localItemFile.file);
        paramAnonymousViewGroup = (ImageView)paramAnonymousView.findViewById(2131558561);
        if ((paramAnonymousInt == 0) || (paramAnonymousInt == 1)) {}
        try
        {
          if (((BinderActivity.ItemFile)getItem(1)).file.equals("../"))
          {
            paramAnonymousViewGroup.setImageDrawable(BinderActivity.this.getResources().getDrawable(2130837545));
            return paramAnonymousView;
          }
          if (new File(localItemFile.full).isDirectory())
          {
            paramAnonymousViewGroup.setImageDrawable(BinderActivity.this.getResources().getDrawable(2130837546));
            return paramAnonymousView;
          }
        }
        catch (Exception paramAnonymousViewGroup)
        {
          paramAnonymousViewGroup.printStackTrace();
          return paramAnonymousView;
          paramAnonymousViewGroup.setImageDrawable(BinderActivity.this.getResources().getDrawable(2130837547));
          return paramAnonymousView;
        }
        catch (OutOfMemoryError paramAnonymousViewGroup)
        {
          paramAnonymousViewGroup.printStackTrace();
          System.gc();
        }
        return paramAnonymousView;
      }
    };
    paramString.sort(new byNameFile(null));
    paramListView.setAdapter(paramString);
    paramString.notifyDataSetChanged();
  }
  
  public static void savetoFile(ArrayList<BindItem> paramArrayList, Context paramContext)
  {
    File localFile = new File(paramContext.getDir("binder", 0) + "/bind.txt");
    try
    {
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      paramContext = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        BindItem localBindItem = (BindItem)paramArrayList.next();
        paramContext.append(localBindItem.SourceDir + ";" + localBindItem.TargetDir + "\n");
      }
      paramArrayList = new FileOutputStream(localFile);
    }
    catch (IOException paramArrayList)
    {
      paramArrayList.printStackTrace();
      return;
    }
    paramArrayList.write(paramContext.toString().getBytes());
    paramArrayList.close();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.context = this;
    paramBundle = new File(getDir("binder", 0) + "/bind.txt");
    if (!paramBundle.exists()) {}
    try
    {
      paramBundle.createNewFile();
      this.bindes = getBindes(this.context);
      setContentView(2130968586);
      paramBundle = (Button)findViewById(2131558464);
      this.lv = ((ListView)findViewById(2131558465));
      listAppsFragment.adaptBind = new ArrayAdapter(this, 2130968592, this.bindes)
      {
        public View getView(final int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
        {
          Object localObject = paramAnonymousView;
          paramAnonymousView = (View)localObject;
          if (localObject == null) {
            paramAnonymousView = ((Activity)BinderActivity.this.context).getLayoutInflater().inflate(2130968592, paramAnonymousViewGroup, false);
          }
          paramAnonymousViewGroup = (TextView)paramAnonymousView.findViewById(2131558480);
          localObject = (TextView)paramAnonymousView.findViewById(2131558481);
          paramAnonymousViewGroup.setTextAppearance(getContext(), listAppsFragment.getSizeText());
          ((TextView)localObject).setTextAppearance(getContext(), listAppsFragment.getSizeText());
          Button localButton = (Button)paramAnonymousView.findViewById(2131558482);
          final ToggleButton localToggleButton = (ToggleButton)paramAnonymousView.findViewById(2131558448);
          localToggleButton.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              paramAnonymous2View = (RelativeLayout)View.inflate(BinderActivity.this.context, 2130968591, null);
              localToggleButton.setEnabled(false);
              this.val$progress.setVisibility(0);
              paramAnonymous2View = new Thread(new Runnable()
              {
                public void run()
                {
                  if (!((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).TargetDir.startsWith("~chelpus_disabled~")) {
                    if (listAppsFragment.su)
                    {
                      Utils.run_all("umount -f '" + ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).TargetDir + "'");
                      Utils.run_all("umount -l '" + ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).TargetDir + "'");
                      ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).TargetDir = ("~chelpus_disabled~" + ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).TargetDir);
                    }
                  }
                  for (;;)
                  {
                    BinderActivity.savetoFile(BinderActivity.this.bindes, BinderActivity.this.context);
                    BinderActivity.this.runOnUiThread(new Runnable()
                    {
                      public void run()
                      {
                        listAppsFragment.adaptBind.notifyDataSetChanged();
                        BinderActivity.this.lv.setAdapter(listAppsFragment.adaptBind);
                        BinderActivity.1.1.this.val$progress.setVisibility(8);
                        Intent localIntent = new Intent(BinderActivity.this.context, BinderWidget.class);
                        localIntent.setAction(BinderWidget.ACTION_WIDGET_RECEIVER_Updater);
                        BinderActivity.this.context.sendBroadcast(localIntent);
                      }
                    });
                    return;
                    Utils.cmd(new String[] { "umount '" + ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).TargetDir + "'" });
                    break;
                    ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).TargetDir = ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).TargetDir.replace("~chelpus_disabled~", "");
                    Utils.verify_bind_and_run("mount", "-o bind '" + ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).SourceDir + "' '" + ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).TargetDir + "'", ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).SourceDir, ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.1.this.val$pos1)).TargetDir);
                  }
                }
              });
              paramAnonymous2View.setPriority(10);
              paramAnonymous2View.start();
            }
          });
          localToggleButton.setChecked(Utils.checkBind((BindItem)getItem(paramAnonymousInt)));
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              paramAnonymous2View = new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  try
                  {
                    if (listAppsFragment.su)
                    {
                      Utils.run_all("umount -f " + ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.2.this.val$pos1)).TargetDir);
                      Utils.run_all("umount -l " + ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.2.this.val$pos1)).TargetDir);
                    }
                    for (;;)
                    {
                      listAppsFragment.adaptBind.remove(listAppsFragment.adaptBind.getItem(BinderActivity.1.2.this.val$pos1));
                      BinderActivity.savetoFile(BinderActivity.this.bindes, BinderActivity.this.context);
                      listAppsFragment.adaptBind.notifyDataSetChanged();
                      BinderActivity.this.lv.setAdapter(listAppsFragment.adaptBind);
                      paramAnonymous3DialogInterface = new Intent(BinderActivity.this.context, BinderWidget.class);
                      paramAnonymous3DialogInterface.setAction(BinderWidget.ACTION_WIDGET_RECEIVER_Updater);
                      BinderActivity.this.context.sendBroadcast(paramAnonymous3DialogInterface);
                      return;
                      Utils.cmd(new String[] { "umount " + ((BindItem)listAppsFragment.adaptBind.getItem(BinderActivity.1.2.this.val$pos1)).TargetDir });
                    }
                    return;
                  }
                  catch (Exception paramAnonymous3DialogInterface)
                  {
                    paramAnonymous3DialogInterface.printStackTrace();
                  }
                }
              };
              Utils.showDialog(new AlertDialog.Builder(BinderActivity.this.context).setCancelable(false).setTitle(Utils.getText(2131165748)).setMessage(Utils.getText(2131165231)).setPositiveButton(Utils.getText(2131165587), paramAnonymous2View).setNegativeButton(Utils.getText(2131165563), null).create());
            }
          });
          paramAnonymousViewGroup.setTextAppearance(BinderActivity.this.context, BinderActivity.this.sizeText);
          ((TextView)localObject).setTextAppearance(BinderActivity.this.context, BinderActivity.this.sizeText);
          paramAnonymousViewGroup.setText(Utils.getColoredText(Utils.getText(2131165236) + "\n", "#ff00ff00", "bold"));
          paramAnonymousViewGroup.append(Utils.getColoredText(((BindItem)getItem(paramAnonymousInt)).SourceDir, "#ffffffff", "italic"));
          ((TextView)localObject).setText(Utils.getColoredText(Utils.getText(2131165237) + "\n", "#ffffff00", "bold"));
          ((TextView)localObject).append(Utils.getColoredText(((BindItem)getItem(paramAnonymousInt)).TargetDir.replace("~chelpus_disabled~", ""), "#ffffffff", "italic"));
          return paramAnonymousView;
        }
      };
      this.lv.setAdapter(listAppsFragment.adaptBind);
      this.lv.invalidateViews();
      this.lv.setBackgroundColor(-16777216);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(final View paramAnonymousView)
        {
          paramAnonymousView = (RelativeLayout)View.inflate(BinderActivity.this.context, 2130968591, null);
          final EditText localEditText1 = (EditText)paramAnonymousView.findViewById(2131558474);
          final EditText localEditText2 = (EditText)paramAnonymousView.findViewById(2131558477);
          Button localButton1 = (Button)paramAnonymousView.findViewById(2131558475);
          Button localButton2 = (Button)paramAnonymousView.findViewById(2131558478);
          View.OnClickListener local1 = new View.OnClickListener()
          {
            public void onClick(final View paramAnonymous2View)
            {
              paramAnonymous2View = localEditText1.getText().toString();
              final String str = localEditText2.getText().toString();
              if (!paramAnonymous2View.endsWith("/"))
              {
                paramAnonymous2View = paramAnonymous2View.trim() + "/";
                if (str.endsWith("/")) {
                  break label155;
                }
                str = str.trim() + "/";
                label86:
                if ((new File(paramAnonymous2View.trim()).exists()) && (!str.equals("/")) && (!paramAnonymous2View.equals("/"))) {
                  break label163;
                }
                Toast.makeText(BinderActivity.this.getApplication().getApplicationContext(), Utils.getText(2131165235), 1).show();
              }
              label155:
              label163:
              do
              {
                return;
                paramAnonymous2View = paramAnonymous2View.trim();
                break;
                str = str.trim();
                break label86;
                if (listAppsFragment.su) {
                  new Thread(new Runnable()
                  {
                    public void run()
                    {
                      Utils.verify_bind_and_run("mount", "-o bind '" + paramAnonymous2View + "' '" + str + "'", paramAnonymous2View, str);
                    }
                  }).start();
                }
                int i;
                for (;;)
                {
                  i = 0;
                  Iterator localIterator = BinderActivity.this.bindes.iterator();
                  while (localIterator.hasNext())
                  {
                    BindItem localBindItem = (BindItem)localIterator.next();
                    if (localBindItem.TargetDir.equals(str))
                    {
                      localBindItem.SourceDir = paramAnonymous2View;
                      localBindItem.TargetDir = str;
                      i = 1;
                    }
                  }
                  Utils.cmd(new String[] { "umount '" + str + "'" });
                  Utils.cmd(new String[] { "mount -o bind '" + paramAnonymous2View + "' '" + str + "'" });
                }
                if (i == 0) {
                  BinderActivity.this.bindes.add(new BindItem(paramAnonymous2View, str));
                }
                BinderActivity.savetoFile(BinderActivity.this.bindes, BinderActivity.this.context);
                listAppsFragment.adaptBind.notifyDataSetChanged();
                BinderActivity.this.lv.setAdapter(listAppsFragment.adaptBind);
              } while (!BinderActivity.this.pp4.isShowing());
              BinderActivity.this.pp4.dismiss();
            }
          };
          View.OnClickListener local2 = new View.OnClickListener()
          {
            public void onClick(final View paramAnonymous2View)
            {
              paramAnonymous2View = (LinearLayout)View.inflate(BinderActivity.this.context, 2130968588, null);
              final Object localObject = new AlertDlg(BinderActivity.this.context, true);
              ((AlertDlg)localObject).setView(paramAnonymous2View);
              ((AlertDlg)localObject).setCancelable(false);
              localObject = ((AlertDlg)localObject).create();
              ((Dialog)localObject).setOnKeyListener(new DialogInterface.OnKeyListener()
              {
                public boolean onKey(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int, KeyEvent paramAnonymous3KeyEvent)
                {
                  System.out.println(paramAnonymous3KeyEvent);
                  if ((paramAnonymous3Int == 4) && (paramAnonymous3KeyEvent.getAction() == 1)) {
                    try
                    {
                      if (((BinderActivity.ItemFile)BinderActivity.this.filebrowser.getAdapter().getItem(1)).file.equals("../"))
                      {
                        BinderActivity.this.getDir(((BinderActivity.ItemFile)BinderActivity.this.filebrowser.getAdapter().getItem(1)).path, BinderActivity.this.filebrowser);
                        return true;
                      }
                      paramAnonymous3DialogInterface.dismiss();
                      return true;
                    }
                    catch (IndexOutOfBoundsException paramAnonymous3KeyEvent)
                    {
                      paramAnonymous3DialogInterface.dismiss();
                      return true;
                    }
                    catch (Exception paramAnonymous3KeyEvent)
                    {
                      paramAnonymous3DialogInterface.dismiss();
                    }
                  }
                  return true;
                }
              });
              Utils.showDialog((Dialog)localObject);
              BinderActivity.access$202(BinderActivity.this, (TextView)((Dialog)localObject).findViewById(2131558469));
              Button localButton1 = (Button)((Dialog)localObject).findViewById(2131558470);
              Button localButton2 = (Button)((Dialog)localObject).findViewById(2131558471);
              BinderActivity.this.myPath.setTextAppearance(BinderActivity.this.context, listAppsFragment.getSizeText());
              localButton2.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(final View paramAnonymous3View)
                {
                  paramAnonymous3View = new Dialog(BinderActivity.this.context);
                  paramAnonymous3View.setTitle(Utils.getText(2131165427));
                  final Object localObject = (RelativeLayout)View.inflate(BinderActivity.this.context, 2130968587, null);
                  paramAnonymous3View.setContentView((View)localObject);
                  localObject = (EditText)((View)localObject).findViewById(2131558467);
                  ((Button)paramAnonymous3View.findViewById(2131558468)).setOnClickListener(new View.OnClickListener()
                  {
                    public void onClick(View paramAnonymous4View)
                    {
                      paramAnonymous4View = localObject.getText().toString().trim().replaceAll("/", "") + "/";
                      if (paramAnonymous4View.replaceAll(" ", "").equals(""))
                      {
                        Toast.makeText(listAppsFragment.getInstance(), Utils.getText(2131165379), 1).show();
                        return;
                      }
                      if (BinderActivity.this.current.path.endsWith("/")) {}
                      for (paramAnonymous4View = BinderActivity.this.current.path + paramAnonymous4View;; paramAnonymous4View = BinderActivity.this.current.path + "/" + paramAnonymous4View)
                      {
                        new File(paramAnonymous4View).mkdirs();
                        if ((!Utils.exists(paramAnonymous4View)) && (!new File(paramAnonymous4View).exists())) {
                          break;
                        }
                        paramAnonymous3View.cancel();
                        BinderActivity.this.getDir(paramAnonymous4View, (ListView)BinderActivity.2.2.2.this.val$dListView.findViewById(2131558472));
                        return;
                      }
                      Toast.makeText(listAppsFragment.getInstance(), Utils.getText(2131165380), 1).show();
                    }
                  });
                  Utils.showDialog(paramAnonymous3View);
                }
              });
              localButton1.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymous3View)
                {
                  if (BinderActivity.this.current.path.endsWith("/")) {
                    BinderActivity.2.2.this.val$ed1.setText(BinderActivity.this.current.path);
                  }
                  for (;;)
                  {
                    if (localObject.isShowing()) {
                      localObject.dismiss();
                    }
                    return;
                    BinderActivity.2.2.this.val$ed1.setText(BinderActivity.this.current.path + "/");
                  }
                }
              });
              BinderActivity.access$402(BinderActivity.this, "/");
              ((ListView)paramAnonymous2View.findViewById(2131558472)).setOnItemClickListener(new AdapterView.OnItemClickListener()
              {
                public void onItemClick(AdapterView<?> paramAnonymous3AdapterView, View paramAnonymous3View, int paramAnonymous3Int, long paramAnonymous3Long)
                {
                  paramAnonymous3View = (BinderActivity.ItemFile)paramAnonymous3AdapterView.getAdapter().getItem(paramAnonymous3Int);
                  File localFile = new File(paramAnonymous3View.full);
                  if (localFile.isDirectory())
                  {
                    BinderActivity.access$302(BinderActivity.this, paramAnonymous3View);
                    if ((localFile.canRead()) && (localFile.listFiles() != null))
                    {
                      BinderActivity.access$002(BinderActivity.this, (ListView)paramAnonymous3AdapterView);
                      BinderActivity.this.getDir(new File(paramAnonymous3View.full).getPath(), (ListView)paramAnonymous3AdapterView);
                    }
                  }
                  else
                  {
                    return;
                  }
                  Utils.showDialog(new AlertDialog.Builder(BinderActivity.this.context).setIcon(17301659).setTitle("[" + localFile.getName() + "] folder can't be read!").setPositiveButton("OK", null).create());
                }
              });
              BinderActivity.access$002(BinderActivity.this, (ListView)paramAnonymous2View.findViewById(2131558472));
              try
              {
                BinderActivity.this.getDir(BinderActivity.this.root, (ListView)paramAnonymous2View.findViewById(2131558472));
                return;
              }
              catch (Exception paramAnonymous2View)
              {
                try
                {
                  BinderActivity.access$402(BinderActivity.this, new File(listAppsFragment.basepath).getParent());
                  BinderActivity.this.getDir(BinderActivity.this.root, (ListView)paramAnonymousView.findViewById(2131558472));
                  return;
                }
                catch (Exception paramAnonymous2View)
                {
                  BinderActivity.access$402(BinderActivity.this, listAppsFragment.basepath);
                  BinderActivity.this.getDir(BinderActivity.this.root, (ListView)paramAnonymousView.findViewById(2131558472));
                }
              }
            }
          };
          View.OnClickListener local3 = new View.OnClickListener()
          {
            public void onClick(final View paramAnonymous2View)
            {
              paramAnonymous2View = (LinearLayout)View.inflate(BinderActivity.this.context, 2130968588, null);
              final Dialog localDialog = new AlertDlg(BinderActivity.this.context, true).setView(paramAnonymous2View).create();
              localDialog.setCancelable(false);
              localDialog.setOnKeyListener(new DialogInterface.OnKeyListener()
              {
                public boolean onKey(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int, KeyEvent paramAnonymous3KeyEvent)
                {
                  System.out.println(paramAnonymous3KeyEvent);
                  if ((paramAnonymous3Int == 4) && (paramAnonymous3KeyEvent.getAction() == 1)) {
                    try
                    {
                      if (((BinderActivity.ItemFile)BinderActivity.this.filebrowser.getAdapter().getItem(1)).file.equals("../"))
                      {
                        BinderActivity.this.getDir(((BinderActivity.ItemFile)BinderActivity.this.filebrowser.getAdapter().getItem(1)).path, BinderActivity.this.filebrowser);
                        return true;
                      }
                      paramAnonymous3DialogInterface.dismiss();
                      return true;
                    }
                    catch (IndexOutOfBoundsException paramAnonymous3KeyEvent)
                    {
                      paramAnonymous3DialogInterface.dismiss();
                      return true;
                    }
                    catch (Exception paramAnonymous3KeyEvent)
                    {
                      paramAnonymous3DialogInterface.dismiss();
                    }
                  }
                  return true;
                }
              });
              Utils.showDialog(localDialog);
              BinderActivity.access$202(BinderActivity.this, (TextView)localDialog.findViewById(2131558469));
              Button localButton = (Button)localDialog.findViewById(2131558470);
              ((Button)localDialog.findViewById(2131558471)).setOnClickListener(new View.OnClickListener()
              {
                public void onClick(final View paramAnonymous3View)
                {
                  paramAnonymous3View = new Dialog(BinderActivity.this.context);
                  paramAnonymous3View.setTitle(Utils.getText(2131165427));
                  final Object localObject = (RelativeLayout)View.inflate(BinderActivity.this.context, 2130968587, null);
                  paramAnonymous3View.setContentView((View)localObject);
                  localObject = (EditText)((View)localObject).findViewById(2131558467);
                  ((Button)paramAnonymous3View.findViewById(2131558468)).setOnClickListener(new View.OnClickListener()
                  {
                    public void onClick(View paramAnonymous4View)
                    {
                      paramAnonymous4View = localObject.getText().toString().trim().replaceAll("/", "") + "/";
                      if (paramAnonymous4View.replaceAll(" ", "").equals(""))
                      {
                        Toast.makeText(listAppsFragment.getInstance(), Utils.getText(2131165379), 1).show();
                        return;
                      }
                      if (BinderActivity.this.current.path.endsWith("/")) {}
                      for (paramAnonymous4View = BinderActivity.this.current.path + paramAnonymous4View;; paramAnonymous4View = BinderActivity.this.current.path + "/" + paramAnonymous4View)
                      {
                        new File(paramAnonymous4View).mkdirs();
                        if ((!Utils.exists(paramAnonymous4View)) && (!new File(paramAnonymous4View).exists())) {
                          break;
                        }
                        paramAnonymous3View.dismiss();
                        try
                        {
                          BinderActivity.this.getDir(paramAnonymous4View, (ListView)BinderActivity.2.3.2.this.val$dListView.findViewById(2131558472));
                          return;
                        }
                        catch (Exception paramAnonymous4View)
                        {
                          paramAnonymous4View.printStackTrace();
                          return;
                        }
                      }
                      Toast.makeText(listAppsFragment.getInstance(), Utils.getText(2131165380), 1).show();
                    }
                  });
                  Utils.showDialog(paramAnonymous3View);
                }
              });
              localButton.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymous3View)
                {
                  if (BinderActivity.this.current.path.endsWith("/")) {
                    BinderActivity.2.3.this.val$ed2.setText(BinderActivity.this.current.path);
                  }
                  for (;;)
                  {
                    if (localDialog.isShowing()) {
                      localDialog.dismiss();
                    }
                    return;
                    BinderActivity.2.3.this.val$ed2.setText(BinderActivity.this.current.path + "/");
                  }
                }
              });
              BinderActivity.access$402(BinderActivity.this, "/");
              ((ListView)paramAnonymous2View.findViewById(2131558472)).setOnItemClickListener(new AdapterView.OnItemClickListener()
              {
                public void onItemClick(AdapterView<?> paramAnonymous3AdapterView, View paramAnonymous3View, int paramAnonymous3Int, long paramAnonymous3Long)
                {
                  paramAnonymous3View = (BinderActivity.ItemFile)paramAnonymous3AdapterView.getAdapter().getItem(paramAnonymous3Int);
                  File localFile = new File(paramAnonymous3View.full);
                  if (localFile.isDirectory())
                  {
                    BinderActivity.access$302(BinderActivity.this, paramAnonymous3View);
                    if ((localFile.canRead()) && (localFile.listFiles() != null))
                    {
                      BinderActivity.access$002(BinderActivity.this, (ListView)paramAnonymous3AdapterView);
                      BinderActivity.this.getDir(new File(paramAnonymous3View.full).getPath(), (ListView)paramAnonymous3AdapterView);
                    }
                  }
                  else
                  {
                    return;
                  }
                  Utils.showDialog(new AlertDialog.Builder(BinderActivity.this.context).setIcon(17301659).setTitle("[" + localFile.getName() + "] folder can't be read!").setPositiveButton("OK", null).create());
                }
              });
              BinderActivity.access$002(BinderActivity.this, (ListView)paramAnonymous2View.findViewById(2131558472));
              try
              {
                BinderActivity.this.getDir(BinderActivity.this.root, (ListView)paramAnonymous2View.findViewById(2131558472));
                return;
              }
              catch (Exception paramAnonymous2View)
              {
                try
                {
                  BinderActivity.access$402(BinderActivity.this, new File(listAppsFragment.basepath).getParent());
                  BinderActivity.this.getDir(BinderActivity.this.root, (ListView)paramAnonymousView.findViewById(2131558472));
                  return;
                }
                catch (Exception paramAnonymous2View)
                {
                  BinderActivity.access$402(BinderActivity.this, listAppsFragment.basepath);
                  BinderActivity.this.getDir(BinderActivity.this.root, (ListView)paramAnonymousView.findViewById(2131558472));
                }
              }
            }
          };
          Button localButton3 = (Button)paramAnonymousView.findViewById(2131558479);
          localButton1.setOnClickListener(local2);
          localButton2.setOnClickListener(local3);
          localButton3.setOnClickListener(local1);
          localEditText1.setText("/mnt/sdcard/external_sd/Android/");
          localEditText2.setText("/mnt/sdcard/Android/");
          BinderActivity.this.pp4 = new AlertDlg(BinderActivity.this.context).setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
          }).setCancelable(true).setIcon(17301659).setView(paramAnonymousView).create();
          Utils.showDialog(BinderActivity.this.pp4);
        }
      });
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public class ItemFile
  {
    public String file = "";
    public String full = "";
    public String path = "";
    
    public ItemFile(String paramString)
    {
      this.full = paramString;
      this.path = new File(paramString).getPath();
      this.file = new File(paramString).getName();
    }
    
    public ItemFile(String paramString1, String paramString2)
    {
      this.full = paramString2;
      this.path = paramString2;
      this.file = paramString1;
    }
  }
  
  private final class byNameFile
    implements Comparator<BinderActivity.ItemFile>
  {
    private byNameFile() {}
    
    public int compare(BinderActivity.ItemFile paramItemFile1, BinderActivity.ItemFile paramItemFile2)
    {
      if ((paramItemFile1 == null) || (paramItemFile2 == null)) {}
      try
      {
        throw new ClassCastException();
      }
      catch (Exception paramItemFile1) {}
      if ((new File(paramItemFile1.full).isDirectory()) && (new File(paramItemFile2.full).isDirectory())) {
        return paramItemFile1.full.compareToIgnoreCase(paramItemFile2.full);
      }
      if ((new File(paramItemFile1.full).isDirectory()) && (!new File(paramItemFile2.full).isDirectory())) {
        return -1;
      }
      if ((!new File(paramItemFile1.full).isDirectory()) && (!new File(paramItemFile2.full).isDirectory())) {
        return paramItemFile1.full.compareToIgnoreCase(paramItemFile2.full);
      }
      if (!new File(paramItemFile1.full).isDirectory())
      {
        boolean bool = new File(paramItemFile2.full).isDirectory();
        if (bool) {
          return 1;
        }
      }
      return paramItemFile1.full.compareToIgnoreCase(paramItemFile2.full);
      return 0;
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/BinderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */