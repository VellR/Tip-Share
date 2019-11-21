package com.google.firebase.database.connection.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzg extends IInterface {

    public static abstract class zza extends Binder implements zzg {

        /* renamed from: com.google.firebase.database.connection.idl.zzg$zza$zza reason: collision with other inner class name */
        private static class C0052zza implements zzg {
            private IBinder zzahn;

            C0052zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public String zzcof() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IListenHashProvider");
                    this.zzahn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzcog() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IListenHashProvider");
                    this.zzahn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public CompoundHashParcelable zzcpn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IListenHashProvider");
                    this.zzahn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (CompoundHashParcelable) CompoundHashParcelable.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.firebase.database.connection.idl.IListenHashProvider");
        }

        public static zzg zzls(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IListenHashProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzg)) ? new C0052zza(iBinder) : (zzg) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.firebase.database.connection.idl.IListenHashProvider");
                    String zzcof = zzcof();
                    parcel2.writeNoException();
                    parcel2.writeString(zzcof);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.firebase.database.connection.idl.IListenHashProvider");
                    boolean zzcog = zzcog();
                    parcel2.writeNoException();
                    if (zzcog) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.firebase.database.connection.idl.IListenHashProvider");
                    CompoundHashParcelable zzcpn = zzcpn();
                    parcel2.writeNoException();
                    if (zzcpn != null) {
                        parcel2.writeInt(1);
                        zzcpn.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.firebase.database.connection.idl.IListenHashProvider");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String zzcof() throws RemoteException;

    boolean zzcog() throws RemoteException;

    CompoundHashParcelable zzcpn() throws RemoteException;
}
