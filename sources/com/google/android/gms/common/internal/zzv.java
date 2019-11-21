package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzv extends IInterface {

    public static abstract class zza extends Binder implements zzv {

        /* renamed from: com.google.android.gms.common.internal.zzv$zza$zza reason: collision with other inner class name */
        private static class C0015zza implements zzv {
            private IBinder zzahn;

            C0015zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public zzd zzasy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    this.zzahn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzasz() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    this.zzahn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzv zzdu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzv)) ? new C0015zza(iBinder) : (zzv) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    zzd zzasy = zzasy();
                    parcel2.writeNoException();
                    if (zzasy != null) {
                        iBinder = zzasy.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    zzd zzasz = zzasz();
                    parcel2.writeNoException();
                    if (zzasz != null) {
                        iBinder = zzasz.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzd zzasy() throws RemoteException;

    zzd zzasz() throws RemoteException;
}
