package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.atomic.AtomicReference;

public class zzpr {

    public static abstract class zza<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends zzpt<R> implements zzb<R> {
        private final Api<?> pD;
        private AtomicReference<zzb> sA = new AtomicReference<>();
        private final zzc<A> sz;

        @Deprecated
        protected zza(zzc<A> zzc, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzab.zzb(googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.sz = (zzc) zzab.zzaa(zzc);
            this.pD = null;
        }

        protected zza(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzab.zzb(googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.sz = api.zzanp();
            this.pD = api;
        }

        private void zza(RemoteException remoteException) {
            zzz(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public /* synthetic */ void setResult(Object obj) {
            super.zzc((Result) obj);
        }

        /* access modifiers changed from: protected */
        public abstract void zza(A a) throws RemoteException;

        public void zza(zzb zzb) {
            this.sA.set(zzb);
        }

        public final zzc<A> zzanp() {
            return this.sz;
        }

        public final Api<?> zzanw() {
            return this.pD;
        }

        public void zzaoo() {
            setResultCallback(null);
        }

        /* access modifiers changed from: protected */
        public void zzaop() {
            zzb zzb = (zzb) this.sA.getAndSet(null);
            if (zzb != null) {
                zzb.zzh(this);
            }
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza(a);
            } catch (DeadObjectException e) {
                zza((RemoteException) e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        /* access modifiers changed from: protected */
        public void zzb(R r) {
        }

        public final void zzz(Status status) {
            zzab.zzb(!status.isSuccess(), (Object) "Failed result must not be success");
            Result zzc = zzc(status);
            zzc(zzc);
            zzb((R) zzc);
        }
    }

    public interface zzb<R> {
        void setResult(R r);

        void zzz(Status status);
    }
}
