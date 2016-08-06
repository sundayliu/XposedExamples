package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ILicenseResultListener
  extends IInterface
{
  public abstract void verifyLicense(int paramInt, String paramString1, String paramString2)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ILicenseResultListener
  {
    private static final String DESCRIPTOR = "com.android.vending.licensing.ILicenseResultListener";
    static final int TRANSACTION_verifyLicense = 1;
    
    public Stub()
    {
      attachInterface(this, "com.android.vending.licensing.ILicenseResultListener");
    }
    
    public static ILicenseResultListener asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.vending.licensing.ILicenseResultListener");
      if ((localIInterface != null) && ((localIInterface instanceof ILicenseResultListener))) {
        return (ILicenseResultListener)localIInterface;
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
        paramParcel2.writeString("com.android.vending.licensing.ILicenseResultListener");
        return true;
      }
      paramParcel1.enforceInterface("com.android.vending.licensing.ILicenseResultListener");
      verifyLicense(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      return true;
    }
    
    private static class Proxy
      implements ILicenseResultListener
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
      
      public String getInterfaceDescriptor()
      {
        return "com.android.vending.licensing.ILicenseResultListener";
      }
      
      public void verifyLicense(int paramInt, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.android.vending.licensing.ILicenseResultListener");
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/android/vending/licensing/ILicenseResultListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */