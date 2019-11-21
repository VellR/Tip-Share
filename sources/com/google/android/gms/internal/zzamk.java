package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzamk extends IInterface {

    public static abstract class zza extends Binder implements zzamk {

        /* renamed from: com.google.android.gms.internal.zzamk$zza$zza reason: collision with other inner class name */
        private static class C0031zza implements zzamk {
            private IBinder zzahn;

            C0031zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public zzamj zza(Uri uri, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzahn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzamj.zza.zzlv(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzamj zza(Uri uri, zzd zzd, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeLong(j);
                    this.zzahn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzamj.zza.zzlv(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzamj zza(Uri uri, zzd zzd, zzd zzd2) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (zzd2 != null) {
                        iBinder = zzd2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzahn.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzamj.zza.zzlv(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzamj zza(Uri uri, zzd zzd, zzd zzd2, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (zzd2 != null) {
                        iBinder = zzd2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zzahn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzamj.zza.zzlv(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzamj zza(Uri uri, zzd zzd, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    this.zzahn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzamj.zza.zzlv(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzamj zza(Uri uri, zzd zzd, String str, zzd zzd2, long j, int i, boolean z) throws RemoteException {
                IBinder iBinder = null;
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    if (zzd2 != null) {
                        iBinder = zzd2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    if (!z) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzahn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzamj.zza.zzlv(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzamj zzb(Uri uri, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzahn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzamj.zza.zzlv(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzamj zzb(Uri uri, zzd zzd, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    this.zzahn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzamj.zza.zzlv(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzamj zzc(Uri uri, zzd zzd, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    this.zzahn.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzamj.zza.zzlv(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzczc() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    this.zzahn.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzy(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzz(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzamk zzlw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.storage.network.INetworkRequestFactory");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzamk)) ? new C0031zza(iBinder) : (zzamk) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    zzamj zza = zza(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza != null ? zza.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    zzamj zzb = zzb(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    zzamj zza2 = zza(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza2 != null ? zza2.asBinder() : null);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    zzamj zza3 = zza(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza3 != null ? zza3.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    zzamj zza4 = zza(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readString(), com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readLong(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza4 != null ? zza4.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    zzamj zzb2 = zzb(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzb2 != null ? zzb2.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    zzamj zzc = zzc(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    zzamj zza5 = zza(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza5 != null ? zza5.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    zzamj zza6 = zza(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()), com.google.android.gms.dynamic.zzd.zza.zzfc(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza6 != null ? zza6.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    String zzczc = zzczc();
                    parcel2.writeNoException();
                    parcel2.writeString(zzczc);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    String zzy = zzy(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeString(zzy);
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                    String zzz = zzz(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeString(zzz);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.firebase.storage.network.INetworkRequestFactory");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzamj zza(Uri uri, zzd zzd) throws RemoteException;

    zzamj zza(Uri uri, zzd zzd, long j) throws RemoteException;

    zzamj zza(Uri uri, zzd zzd, zzd zzd2) throws RemoteException;

    zzamj zza(Uri uri, zzd zzd, zzd zzd2, String str) throws RemoteException;

    zzamj zza(Uri uri, zzd zzd, String str) throws RemoteException;

    zzamj zza(Uri uri, zzd zzd, String str, zzd zzd2, long j, int i, boolean z) throws RemoteException;

    zzamj zzb(Uri uri, zzd zzd) throws RemoteException;

    zzamj zzb(Uri uri, zzd zzd, String str) throws RemoteException;

    zzamj zzc(Uri uri, zzd zzd, String str) throws RemoteException;

    String zzczc() throws RemoteException;

    String zzy(Uri uri) throws RemoteException;

    String zzz(Uri uri) throws RemoteException;
}
