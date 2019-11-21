package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzpr.zza;

abstract class zznh extends zza<ProxyResult, zzne> {
    public zznh(GoogleApiClient googleApiClient) {
        super(Auth.PROXY_API, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, zzng zzng) throws RemoteException;

    /* access modifiers changed from: protected */
    public final void zza(zzne zzne) throws RemoteException {
        zza(zzne.getContext(), (zzng) zzne.zzarw());
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzk */
    public ProxyResult zzc(Status status) {
        return new zznj(status);
    }
}
