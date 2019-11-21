package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public interface zzafk extends IInterface {

    public static abstract class zza extends Binder implements zzafk {

        /* renamed from: com.google.android.gms.internal.zzafk$zza$zza reason: collision with other inner class name */
        private static class C0026zza implements zzafk {
            private IBinder zzahn;

            C0026zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public void zza(zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(VerifyAssertionRequest verifyAssertionRequest, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    if (verifyAssertionRequest != null) {
                        obtain.writeInt(1);
                        verifyAssertionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    if (userProfileChangeRequest != null) {
                        obtain.writeInt(1);
                        userProfileChangeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, VerifyAssertionRequest verifyAssertionRequest, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    if (verifyAssertionRequest != null) {
                        obtain.writeInt(1);
                        verifyAssertionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, String str3, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, String str2, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(String str, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(String str, String str2, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(String str, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(String str, String str2, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(String str, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(String str, String str2, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(String str, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(String str, zzafj zzafj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzafj != null ? zzafj.asBinder() : null);
                    this.zzahn.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzafk zzlm(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzafk)) ? new C0026zza(iBinder) : (zzafk) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v17, types: [com.google.firebase.auth.api.model.VerifyAssertionRequest] */
        /* JADX WARNING: type inference failed for: r0v21, types: [com.google.firebase.auth.api.model.VerifyAssertionRequest] */
        /* JADX WARNING: type inference failed for: r0v43, types: [com.google.firebase.auth.UserProfileChangeRequest] */
        /* JADX WARNING: type inference failed for: r0v47, types: [com.google.firebase.auth.UserProfileChangeRequest] */
        /* JADX WARNING: type inference failed for: r0v48, types: [com.google.firebase.auth.api.model.VerifyAssertionRequest] */
        /* JADX WARNING: type inference failed for: r0v52, types: [com.google.firebase.auth.api.model.VerifyAssertionRequest] */
        /* JADX WARNING: type inference failed for: r0v62 */
        /* JADX WARNING: type inference failed for: r0v63 */
        /* JADX WARNING: type inference failed for: r0v64 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.firebase.auth.UserProfileChangeRequest, com.google.firebase.auth.api.model.VerifyAssertionRequest]
  uses: [com.google.firebase.auth.api.model.VerifyAssertionRequest, com.google.firebase.auth.UserProfileChangeRequest]
  mth insns count: 166
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
        /* JADX WARNING: Unknown variable types count: 4 */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ? r0 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zza(parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zzb(parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    if (parcel.readInt() != 0) {
                        r0 = (VerifyAssertionRequest) VerifyAssertionRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza((VerifyAssertionRequest) r0, com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (UserProfileChangeRequest) UserProfileChangeRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(readString, (UserProfileChangeRequest) r0, com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zza(parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zzb(parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zzc(parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zzd(parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zzc(parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zzd(parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zza(parcel.readString(), parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (VerifyAssertionRequest) VerifyAssertionRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(readString2, (VerifyAssertionRequest) r0, com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zze(parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zze(parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zzf(parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zza(com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    zzg(parcel.readString(), com.google.android.gms.internal.zzafj.zza.zzll(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzafj zzafj) throws RemoteException;

    void zza(VerifyAssertionRequest verifyAssertionRequest, zzafj zzafj) throws RemoteException;

    void zza(String str, zzafj zzafj) throws RemoteException;

    void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzafj zzafj) throws RemoteException;

    void zza(String str, VerifyAssertionRequest verifyAssertionRequest, zzafj zzafj) throws RemoteException;

    void zza(String str, String str2, zzafj zzafj) throws RemoteException;

    void zza(String str, String str2, String str3, zzafj zzafj) throws RemoteException;

    void zzb(String str, zzafj zzafj) throws RemoteException;

    void zzb(String str, String str2, zzafj zzafj) throws RemoteException;

    void zzc(String str, zzafj zzafj) throws RemoteException;

    void zzc(String str, String str2, zzafj zzafj) throws RemoteException;

    void zzd(String str, zzafj zzafj) throws RemoteException;

    void zzd(String str, String str2, zzafj zzafj) throws RemoteException;

    void zze(String str, zzafj zzafj) throws RemoteException;

    void zze(String str, String str2, zzafj zzafj) throws RemoteException;

    void zzf(String str, zzafj zzafj) throws RemoteException;

    void zzg(String str, zzafj zzafj) throws RemoteException;
}
