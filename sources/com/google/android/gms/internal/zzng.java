package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public interface zzng extends IInterface {

    public static abstract class zza extends Binder implements zzng {

        /* renamed from: com.google.android.gms.internal.zzng$zza$zza reason: collision with other inner class name */
        private static class C0038zza implements zzng {
            private IBinder zzahn;

            C0038zza(IBinder iBinder) {
                this.zzahn = iBinder;
            }

            public IBinder asBinder() {
                return this.zzahn;
            }

            public void zza(zznf zznf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(zznf != null ? zznf.asBinder() : null);
                    this.zzahn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zznf zznf, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(zznf != null ? zznf.asBinder() : null);
                    if (proxyGrpcRequest != null) {
                        obtain.writeInt(1);
                        proxyGrpcRequest.writeToParcel(obtain, 0);
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

            public void zza(zznf zznf, ProxyRequest proxyRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(zznf != null ? zznf.asBinder() : null);
                    if (proxyRequest != null) {
                        obtain.writeInt(1);
                        proxyRequest.writeToParcel(obtain, 0);
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
        }

        public static zzng zzch(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzng)) ? new C0038zza(iBinder) : (zzng) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.auth.api.proxy.ProxyGrpcRequest] */
        /* JADX WARNING: type inference failed for: r0v9, types: [com.google.android.gms.auth.api.proxy.ProxyGrpcRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.auth.api.proxy.ProxyRequest] */
        /* JADX WARNING: type inference failed for: r0v14, types: [com.google.android.gms.auth.api.proxy.ProxyRequest] */
        /* JADX WARNING: type inference failed for: r0v18 */
        /* JADX WARNING: type inference failed for: r0v19 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.auth.api.proxy.ProxyRequest, com.google.android.gms.auth.api.proxy.ProxyGrpcRequest]
  uses: [com.google.android.gms.auth.api.proxy.ProxyGrpcRequest, com.google.android.gms.auth.api.proxy.ProxyRequest]
  mth insns count: 40
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
        /* JADX WARNING: Unknown variable types count: 3 */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ? r0 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zznf zzcg = com.google.android.gms.internal.zznf.zza.zzcg(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        r0 = (ProxyRequest) ProxyRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcg, (ProxyRequest) r0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zznf zzcg2 = com.google.android.gms.internal.zznf.zza.zzcg(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        r0 = (ProxyGrpcRequest) ProxyGrpcRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcg2, (ProxyGrpcRequest) r0);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zza(com.google.android.gms.internal.zznf.zza.zzcg(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.internal.IAuthService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zznf zznf) throws RemoteException;

    void zza(zznf zznf, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException;

    void zza(zznf zznf, ProxyRequest proxyRequest) throws RemoteException;
}
