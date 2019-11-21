package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.api.model.CreateAuthUriResponse;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetTokenResponse;

public interface zzafj extends IInterface {

    public static abstract class zza extends Binder implements zzafj {

        /* renamed from: com.google.android.gms.internal.zzafj$zza$zza reason: collision with other inner class name */
        private static class C0025zza implements zzafj {
            private IBinder zzahn;

            C0025zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public void onFailure(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(CreateAuthUriResponse createAuthUriResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (createAuthUriResponse != null) {
                        obtain.writeInt(1);
                        createAuthUriResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(GetTokenResponse getTokenResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (getTokenResponse != null) {
                        obtain.writeInt(1);
                        getTokenResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(GetTokenResponse getTokenResponse, GetAccountInfoUser getAccountInfoUser) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (getTokenResponse != null) {
                        obtain.writeInt(1);
                        getTokenResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (getAccountInfoUser != null) {
                        obtain.writeInt(1);
                        getAccountInfoUser.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzahn.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzclb() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    this.zzahn.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzclc() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    this.zzahn.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
        }

        public static zzafj zzll(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzafj)) ? new C0025zza(iBinder) : (zzafj) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zza(parcel.readInt() != 0 ? (GetTokenResponse) GetTokenResponse.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zza(parcel.readInt() != 0 ? (GetTokenResponse) GetTokenResponse.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (GetAccountInfoUser) GetAccountInfoUser.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zza(parcel.readInt() != 0 ? (CreateAuthUriResponse) CreateAuthUriResponse.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzclb();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    onFailure(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzclc();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onFailure(Status status) throws RemoteException;

    void zza(CreateAuthUriResponse createAuthUriResponse) throws RemoteException;

    void zza(GetTokenResponse getTokenResponse) throws RemoteException;

    void zza(GetTokenResponse getTokenResponse, GetAccountInfoUser getAccountInfoUser) throws RemoteException;

    void zzclb() throws RemoteException;

    void zzclc() throws RemoteException;
}
