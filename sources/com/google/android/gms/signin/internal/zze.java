package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzw;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        /* renamed from: com.google.android.gms.signin.internal.zze$zza$zza reason: collision with other inner class name */
        private static class C0049zza implements zze {
            private IBinder zzahn;

            C0049zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public void zza(int i, Account account, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzahn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AuthAccountRequest authAccountRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (authAccountRequest != null) {
                        obtain.writeInt(1);
                        authAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzahn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ResolveAccountRequest resolveAccountRequest, zzw zzw) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (resolveAccountRequest != null) {
                        obtain.writeInt(1);
                        resolveAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzw != null ? zzw.asBinder() : null);
                    this.zzahn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzq zzq, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzq != null ? zzq.asBinder() : null);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzahn.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (checkServerAuthResult != null) {
                        obtain.writeInt(1);
                        checkServerAuthResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RecordConsentRequest recordConsentRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (recordConsentRequest != null) {
                        obtain.writeInt(1);
                        recordConsentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzahn.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SignInRequest signInRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (signInRequest != null) {
                        obtain.writeInt(1);
                        signInRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzahn.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzahn.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzce(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzahn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzxs(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.zzahn.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zze zzki(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new C0049zza(iBinder) : (zze) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.signin.internal.SignInRequest] */
        /* JADX WARNING: type inference failed for: r0v4, types: [com.google.android.gms.signin.internal.SignInRequest] */
        /* JADX WARNING: type inference failed for: r0v8, types: [com.google.android.gms.signin.internal.RecordConsentRequest] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.signin.internal.RecordConsentRequest] */
        /* JADX WARNING: type inference failed for: r0v15, types: [android.accounts.Account] */
        /* JADX WARNING: type inference failed for: r0v18, types: [android.accounts.Account] */
        /* JADX WARNING: type inference failed for: r0v21, types: [com.google.android.gms.common.internal.ResolveAccountRequest] */
        /* JADX WARNING: type inference failed for: r0v24, types: [com.google.android.gms.common.internal.ResolveAccountRequest] */
        /* JADX WARNING: type inference failed for: r0v30, types: [com.google.android.gms.signin.internal.CheckServerAuthResult] */
        /* JADX WARNING: type inference failed for: r0v33, types: [com.google.android.gms.signin.internal.CheckServerAuthResult] */
        /* JADX WARNING: type inference failed for: r0v34, types: [com.google.android.gms.common.internal.AuthAccountRequest] */
        /* JADX WARNING: type inference failed for: r0v37, types: [com.google.android.gms.common.internal.AuthAccountRequest] */
        /* JADX WARNING: type inference failed for: r0v39 */
        /* JADX WARNING: type inference failed for: r0v40 */
        /* JADX WARNING: type inference failed for: r0v41 */
        /* JADX WARNING: type inference failed for: r0v42 */
        /* JADX WARNING: type inference failed for: r0v43 */
        /* JADX WARNING: type inference failed for: r0v44 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.signin.internal.RecordConsentRequest, com.google.android.gms.signin.internal.SignInRequest, android.accounts.Account, com.google.android.gms.common.internal.ResolveAccountRequest, com.google.android.gms.signin.internal.CheckServerAuthResult, com.google.android.gms.common.internal.AuthAccountRequest]
  uses: [com.google.android.gms.signin.internal.SignInRequest, com.google.android.gms.signin.internal.RecordConsentRequest, android.accounts.Account, com.google.android.gms.common.internal.ResolveAccountRequest, com.google.android.gms.signin.internal.CheckServerAuthResult, com.google.android.gms.common.internal.AuthAccountRequest]
  mth insns count: 118
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
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 7 */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z = false;
            ? r0 = 0;
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        r0 = (AuthAccountRequest) AuthAccountRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza((AuthAccountRequest) r0, com.google.android.gms.signin.internal.zzd.zza.zzkh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        r0 = (CheckServerAuthResult) CheckServerAuthResult.CREATOR.createFromParcel(parcel);
                    }
                    zza(r0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzce(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        r0 = (ResolveAccountRequest) ResolveAccountRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza((ResolveAccountRequest) r0, com.google.android.gms.common.internal.zzw.zza.zzdv(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzxs(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        r0 = (Account) Account.CREATOR.createFromParcel(parcel);
                    }
                    zza(readInt, (Account) r0, com.google.android.gms.signin.internal.zzd.zza.zzkh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzq zzdp = com.google.android.gms.common.internal.zzq.zza.zzdp(parcel.readStrongBinder());
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zza(zzdp, readInt2, z);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        r0 = (RecordConsentRequest) RecordConsentRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza((RecordConsentRequest) r0, com.google.android.gms.signin.internal.zzd.zza.zzkh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzb(com.google.android.gms.signin.internal.zzd.zza.zzkh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        r0 = (SignInRequest) SignInRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza((SignInRequest) r0, com.google.android.gms.signin.internal.zzd.zza.zzkh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(int i, Account account, zzd zzd) throws RemoteException;

    void zza(AuthAccountRequest authAccountRequest, zzd zzd) throws RemoteException;

    void zza(ResolveAccountRequest resolveAccountRequest, zzw zzw) throws RemoteException;

    void zza(zzq zzq, int i, boolean z) throws RemoteException;

    void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException;

    void zza(RecordConsentRequest recordConsentRequest, zzd zzd) throws RemoteException;

    void zza(SignInRequest signInRequest, zzd zzd) throws RemoteException;

    void zzb(zzd zzd) throws RemoteException;

    void zzce(boolean z) throws RemoteException;

    void zzxs(int i) throws RemoteException;
}
