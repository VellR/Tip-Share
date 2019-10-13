package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.auth.account.zza$zza reason: collision with other inner class name */
    public static abstract class C0000zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.auth.account.zza$zza$zza reason: collision with other inner class name */
        private static class C0001zza implements zza {
            private IBinder zzahn;

            C0001zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public void zzay(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.account.IWorkAccountCallback");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzahn.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzc(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.account.IWorkAccountCallback");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0000zza() {
            attachInterface(this, "com.google.android.gms.auth.account.IWorkAccountCallback");
        }

        public static zza zzbw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.account.IWorkAccountCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C0001zza(iBinder) : (zza) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.account.IWorkAccountCallback");
                    zzc(parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.auth.account.IWorkAccountCallback");
                    zzay(parcel.readInt() != 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.account.IWorkAccountCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzay(boolean z) throws RemoteException;

    void zzc(Account account) throws RemoteException;
}
