package com.android.vending.billing.InAppBillingService.LACK;

import java.util.List;

public class MenuItem
{
  public String booleanPref = null;
  public boolean booleanPrefDef = false;
  public List<Integer> childs;
  public boolean icon = false;
  public int punkt_menu;
  public int punkt_menu_descr = 0;
  public Runnable runCode = null;
  public int type = 0;
  public int typeChild = 0;
  
  public MenuItem(int paramInt1, int paramInt2, List<Integer> paramList, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.punkt_menu = paramInt1;
    this.childs = paramList;
    this.icon = paramBoolean;
    this.type = paramInt3;
    this.typeChild = paramInt4;
    this.punkt_menu_descr = paramInt2;
  }
  
  public MenuItem(int paramInt1, int paramInt2, List<Integer> paramList, int paramInt3, boolean paramBoolean)
  {
    this.punkt_menu = paramInt1;
    this.childs = paramList;
    this.icon = paramBoolean;
    this.type = paramInt3;
    this.punkt_menu_descr = paramInt2;
  }
  
  public MenuItem(int paramInt1, int paramInt2, List<Integer> paramList, int paramInt3, boolean paramBoolean1, String paramString, boolean paramBoolean2, Runnable paramRunnable)
  {
    this.punkt_menu = paramInt1;
    this.childs = paramList;
    this.icon = paramBoolean1;
    this.type = paramInt3;
    this.punkt_menu_descr = paramInt2;
    this.runCode = paramRunnable;
    this.booleanPref = paramString;
    this.booleanPrefDef = paramBoolean2;
  }
  
  public MenuItem(int paramInt1, List<Integer> paramList, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.punkt_menu = paramInt1;
    this.childs = paramList;
    this.icon = paramBoolean;
    this.type = paramInt2;
    this.typeChild = paramInt3;
  }
  
  public MenuItem(int paramInt1, List<Integer> paramList, int paramInt2, boolean paramBoolean)
  {
    this.punkt_menu = paramInt1;
    this.childs = paramList;
    this.icon = paramBoolean;
    this.type = paramInt2;
  }
  
  public MenuItem(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    this.punkt_menu = paramInt;
    this.childs = paramList;
    this.icon = paramBoolean;
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/MenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */