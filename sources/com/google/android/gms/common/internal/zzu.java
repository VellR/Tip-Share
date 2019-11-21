package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzu extends IInterface {

    public static abstract class zza extends Binder implements zzu {

        /* renamed from: com.google.android.gms.common.internal.zzu$zza$zza reason: collision with other inner class name */
        private static class C0014zza implements zzu {
            private IBinder zzahn;

            C0014zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public void zza(zzt zzt, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzahn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, int i, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzahn.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, int i, String str, String str2, String str3, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringArray(strArr);
                    this.zzahn.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, int i, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.zzahn.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, int i, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, int i, String str, String str2, String[] strArr, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, int i, String str, String[] strArr, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, GetServiceRequest getServiceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt zzt, ValidateAccountRequest validateAccountRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    if (validateAccountRequest != null) {
                        obtain.writeInt(1);
                        validateAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzasx() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.zzahn.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(zzt zzt, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzahn.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzq(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzr(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzs(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzt(zzt zzt, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzu zzdt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzu)) ? new C0014zza(iBinder) : (zzu) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.common.internal.ValidateAccountRequest] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.common.internal.ValidateAccountRequest] */
        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.common.internal.GetServiceRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.common.internal.GetServiceRequest] */
        /* JADX WARNING: type inference failed for: r0v19, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v23, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v28, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v32, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v37, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v41, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v42, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v46, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v78, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v82, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v87, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v91, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v96, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v100, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v119, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v123, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v124, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v128, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v129, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v133, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v134, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v138, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v139, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v143, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v144, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v148, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v149, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v153, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v154, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v158, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v168, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v172, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v173, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v177, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v178, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v182, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v183, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v187, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v196, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v200, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v209 */
        /* JADX WARNING: type inference failed for: r0v210 */
        /* JADX WARNING: type inference failed for: r0v211 */
        /* JADX WARNING: type inference failed for: r0v212 */
        /* JADX WARNING: type inference failed for: r0v213 */
        /* JADX WARNING: type inference failed for: r0v214 */
        /* JADX WARNING: type inference failed for: r0v215 */
        /* JADX WARNING: type inference failed for: r0v216 */
        /* JADX WARNING: type inference failed for: r0v217 */
        /* JADX WARNING: type inference failed for: r0v218 */
        /* JADX WARNING: type inference failed for: r0v219 */
        /* JADX WARNING: type inference failed for: r0v220 */
        /* JADX WARNING: type inference failed for: r0v221 */
        /* JADX WARNING: type inference failed for: r0v222 */
        /* JADX WARNING: type inference failed for: r0v223 */
        /* JADX WARNING: type inference failed for: r0v224 */
        /* JADX WARNING: type inference failed for: r0v225 */
        /* JADX WARNING: type inference failed for: r0v226 */
        /* JADX WARNING: type inference failed for: r0v227 */
        /* JADX WARNING: type inference failed for: r0v228 */
        /* JADX WARNING: type inference failed for: r0v229 */
        /* JADX WARNING: type inference failed for: r0v230 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.common.internal.GetServiceRequest, com.google.android.gms.common.internal.ValidateAccountRequest, android.os.Bundle]
  uses: [com.google.android.gms.common.internal.ValidateAccountRequest, com.google.android.gms.common.internal.GetServiceRequest, android.os.Bundle]
  mth insns count: 596
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 23 */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ? r0 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zza(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt = parcel.readInt();
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzds, readInt, readString, (Bundle) r0);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zza(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zza(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds2 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt2 = parcel.readInt();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzb(zzds2, readInt2, readString2, r0);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds3 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt3 = parcel.readInt();
                    String readString3 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzc(zzds3, readInt3, readString3, r0);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds4 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt4 = parcel.readInt();
                    String readString4 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzd(zzds4, readInt4, readString4, r0);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds5 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt5 = parcel.readInt();
                    String readString5 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zze(zzds5, readInt5, readString5, r0);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zza(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zza(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds6 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt6 = parcel.readInt();
                    String readString6 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzf(zzds6, readInt6, readString6, r0);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds7 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt7 = parcel.readInt();
                    String readString7 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzg(zzds7, readInt7, readString7, r0);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds8 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt8 = parcel.readInt();
                    String readString8 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzh(zzds8, readInt8, readString8, r0);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds9 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt9 = parcel.readInt();
                    String readString9 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzi(zzds9, readInt9, readString9, r0);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds10 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt10 = parcel.readInt();
                    String readString10 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzj(zzds10, readInt10, readString10, r0);
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds11 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt11 = parcel.readInt();
                    String readString11 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzk(zzds11, readInt11, readString11, r0);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds12 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt12 = parcel.readInt();
                    String readString12 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzl(zzds12, readInt12, readString12, r0);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds13 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt13 = parcel.readInt();
                    String readString13 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzm(zzds13, readInt13, readString13, r0);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zza(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zza(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzb(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzc(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds14 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt14 = parcel.readInt();
                    String readString14 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzn(zzds14, readInt14, readString14, r0);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzd(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds15 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt15 = parcel.readInt();
                    String readString15 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzo(zzds15, readInt15, readString15, r0);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zze(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds16 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt16 = parcel.readInt();
                    String readString16 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzp(zzds16, readInt16, readString16, r0);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzasx();
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zza(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzf(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzg(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zza(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zza(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzh(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzi(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds17 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt17 = parcel.readInt();
                    String readString17 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzq(zzds17, readInt17, readString17, r0);
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds18 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt18 = parcel.readInt();
                    String readString18 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzr(zzds18, readInt18, readString18, r0);
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzj(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds19 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt19 = parcel.readInt();
                    String readString19 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzs(zzds19, readInt19, readString19, r0);
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzk(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds20 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    int readInt20 = parcel.readInt();
                    String readString20 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    zzt(zzds20, readInt20, readString20, r0);
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzl(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzm(com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds21 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        r0 = (GetServiceRequest) GetServiceRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzds21, (GetServiceRequest) r0);
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzt zzds22 = com.google.android.gms.common.internal.zzt.zza.zzds(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        r0 = (ValidateAccountRequest) ValidateAccountRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzds22, (ValidateAccountRequest) r0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzt zzt, int i) throws RemoteException;

    void zza(zzt zzt, int i, String str) throws RemoteException;

    void zza(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zza(zzt zzt, int i, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zza(zzt zzt, int i, String str, String str2) throws RemoteException;

    void zza(zzt zzt, int i, String str, String str2, String str3, String[] strArr) throws RemoteException;

    void zza(zzt zzt, int i, String str, String str2, String[] strArr) throws RemoteException;

    void zza(zzt zzt, int i, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException;

    void zza(zzt zzt, int i, String str, String str2, String[] strArr, String str3, Bundle bundle) throws RemoteException;

    void zza(zzt zzt, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle) throws RemoteException;

    void zza(zzt zzt, int i, String str, String[] strArr, String str2, Bundle bundle) throws RemoteException;

    void zza(zzt zzt, GetServiceRequest getServiceRequest) throws RemoteException;

    void zza(zzt zzt, ValidateAccountRequest validateAccountRequest) throws RemoteException;

    void zzasx() throws RemoteException;

    void zzb(zzt zzt, int i, String str) throws RemoteException;

    void zzb(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzc(zzt zzt, int i, String str) throws RemoteException;

    void zzc(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzd(zzt zzt, int i, String str) throws RemoteException;

    void zzd(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zze(zzt zzt, int i, String str) throws RemoteException;

    void zze(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzf(zzt zzt, int i, String str) throws RemoteException;

    void zzf(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzg(zzt zzt, int i, String str) throws RemoteException;

    void zzg(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzh(zzt zzt, int i, String str) throws RemoteException;

    void zzh(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzi(zzt zzt, int i, String str) throws RemoteException;

    void zzi(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzj(zzt zzt, int i, String str) throws RemoteException;

    void zzj(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzk(zzt zzt, int i, String str) throws RemoteException;

    void zzk(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzl(zzt zzt, int i, String str) throws RemoteException;

    void zzl(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzm(zzt zzt, int i, String str) throws RemoteException;

    void zzm(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzn(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzo(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzp(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzq(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzr(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzs(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;

    void zzt(zzt zzt, int i, String str, Bundle bundle) throws RemoteException;
}
