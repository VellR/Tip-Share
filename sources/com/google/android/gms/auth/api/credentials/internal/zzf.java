package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzpr.zza;

abstract class zzf<R extends Result> extends zza<R, zzg> {
    zzf(GoogleApiClient googleApiClient) {
        super(Auth.CREDENTIALS_API, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, zzk zzk) throws DeadObjectException, RemoteException;

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg) throws DeadObjectException, RemoteException {
        zza(zzg.getContext(), (zzk) zzg.zzarw());
    }
}
