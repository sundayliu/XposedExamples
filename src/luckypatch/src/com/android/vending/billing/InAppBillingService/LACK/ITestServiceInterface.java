package com.android.vending.billing.InAppBillingService.LACK;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ITestServiceInterface
  extends IInterface
{
  public abstract boolean checkService()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITestServiceInterface
  {
    private static final String DESCRIPTOR = "com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface";
    static final int TRANSACTION_checkService = 1;
    
    public Stub()
    {
      attachInterface(this, "com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface");
    }
    
    public static ITestServiceInterface asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface");
      if ((localIInterface != null) && ((localIInterface instanceof ITestServiceInterface))) {
        return (ITestServiceInterface)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface");
        return true;
      }
      paramParcel1.enforceInterface("com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface");
      boolean bool = checkService();
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
    
    private static class Proxy
      implements ITestServiceInterface
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public boolean checkService()
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_0
        //   18: getfield 19	com/android/vending/billing/InAppBillingService/LACK/ITestServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   21: iconst_1
        //   22: aload_3
        //   23: aload 4
        //   25: iconst_0
        //   26: invokeinterface 44 5 0
        //   31: pop
        //   32: aload 4
        //   34: invokevirtual 47	android/os/Parcel:readException	()V
        //   37: aload 4
        //   39: invokevirtual 51	android/os/Parcel:readInt	()I
        //   42: istore_1
        //   43: iload_1
        //   44: ifeq +14 -> 58
        //   47: aload 4
        //   49: invokevirtual 54	android/os/Parcel:recycle	()V
        //   52: aload_3
        //   53: invokevirtual 54	android/os/Parcel:recycle	()V
        //   56: iload_2
        //   57: ireturn
        //   58: iconst_0
        //   59: istore_2
        //   60: goto -13 -> 47
        //   63: astore 5
        //   65: aload 4
        //   67: invokevirtual 54	android/os/Parcel:recycle	()V
        //   70: aload_3
        //   71: invokevirtual 54	android/os/Parcel:recycle	()V
        //   74: aload 5
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	Proxy
        //   42	2	1	i	int
        //   1	59	2	bool	boolean
        //   5	66	3	localParcel1	Parcel
        //   9	57	4	localParcel2	Parcel
        //   63	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	43	63	finally
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.android.vending.billing.InAppBillingService.LACK.ITestServiceInterface";
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/billing/InAppBillingService/LACK/ITestServiceInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */