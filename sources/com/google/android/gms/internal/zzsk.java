package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzsk extends IInterface {

    public static abstract class zza extends Binder implements zzsk {

        /* renamed from: com.google.android.gms.internal.zzsk$zza$zza reason: collision with other inner class name */
        private static class C0045zza implements zzsk {
            private IBinder zzahn;

            C0045zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public int zza(zzd zzd, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzahn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zza(zzd zzd, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzahn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzd(zzd zzd, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    this.zzahn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzsk zzfd(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzsk)) ? new C0045zza(iBinder) : (zzsk) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    int zzd = zzd(com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zzd);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzd zza = zza(com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza != null ? zza.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    int zza2 = zza(com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(zza2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.dynamite.IDynamiteLoader");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int zza(zzd zzd, String str, boolean z) throws RemoteException;

    zzd zza(zzd zzd, String str, int i) throws RemoteException;

    int zzd(zzd zzd, String str) throws RemoteException;
}
