package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public interface zzk extends IInterface {

    public static abstract class zza extends Binder implements zzk {

        /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzk$zza$zza reason: collision with other inner class name */
        private static class C0004zza implements zzk {
            private IBinder zzahn;

            C0004zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public void zza(zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzahn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzj zzj, CredentialRequest credentialRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    if (credentialRequest != null) {
                        obtain.writeInt(1);
                        credentialRequest.writeToParcel(obtain, 0);
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

            public void zza(zzj zzj, DeleteRequest deleteRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    if (deleteRequest != null) {
                        obtain.writeInt(1);
                        deleteRequest.writeToParcel(obtain, 0);
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

            public void zza(zzj zzj, GeneratePasswordRequest generatePasswordRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    if (generatePasswordRequest != null) {
                        obtain.writeInt(1);
                        generatePasswordRequest.writeToParcel(obtain, 0);
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

            public void zza(zzj zzj, SaveRequest saveRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    if (saveRequest != null) {
                        obtain.writeInt(1);
                        saveRequest.writeToParcel(obtain, 0);
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
        }

        public static zzk zzce(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzk)) ? new C0004zza(iBinder) : (zzk) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.auth.api.credentials.internal.DeleteRequest] */
        /* JADX WARNING: type inference failed for: r0v14, types: [com.google.android.gms.auth.api.credentials.internal.DeleteRequest] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.auth.api.credentials.internal.SaveRequest] */
        /* JADX WARNING: type inference failed for: r0v19, types: [com.google.android.gms.auth.api.credentials.internal.SaveRequest] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.auth.api.credentials.CredentialRequest] */
        /* JADX WARNING: type inference failed for: r0v24, types: [com.google.android.gms.auth.api.credentials.CredentialRequest] */
        /* JADX WARNING: type inference failed for: r0v28 */
        /* JADX WARNING: type inference failed for: r0v29 */
        /* JADX WARNING: type inference failed for: r0v30 */
        /* JADX WARNING: type inference failed for: r0v31 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.auth.api.credentials.internal.DeleteRequest, com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest, com.google.android.gms.auth.api.credentials.internal.SaveRequest, com.google.android.gms.auth.api.credentials.CredentialRequest]
  uses: [com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest, com.google.android.gms.auth.api.credentials.internal.DeleteRequest, com.google.android.gms.auth.api.credentials.internal.SaveRequest, com.google.android.gms.auth.api.credentials.CredentialRequest]
  mth insns count: 66
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
        /* JADX WARNING: Unknown variable types count: 5 */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ? r0 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    zzj zzcd = com.google.android.gms.auth.api.credentials.internal.zzj.zza.zzcd(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        r0 = (CredentialRequest) CredentialRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcd, (CredentialRequest) r0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    zzj zzcd2 = com.google.android.gms.auth.api.credentials.internal.zzj.zza.zzcd(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        r0 = (SaveRequest) SaveRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcd2, (SaveRequest) r0);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    zzj zzcd3 = com.google.android.gms.auth.api.credentials.internal.zzj.zza.zzcd(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        r0 = (DeleteRequest) DeleteRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcd3, (DeleteRequest) r0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    zza(com.google.android.gms.auth.api.credentials.internal.zzj.zza.zzcd(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    zzj zzcd4 = com.google.android.gms.auth.api.credentials.internal.zzj.zza.zzcd(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        r0 = (GeneratePasswordRequest) GeneratePasswordRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcd4, (GeneratePasswordRequest) r0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzj zzj) throws RemoteException;

    void zza(zzj zzj, CredentialRequest credentialRequest) throws RemoteException;

    void zza(zzj zzj, DeleteRequest deleteRequest) throws RemoteException;

    void zza(zzj zzj, GeneratePasswordRequest generatePasswordRequest) throws RemoteException;

    void zza(zzj zzj, SaveRequest saveRequest) throws RemoteException;
}
