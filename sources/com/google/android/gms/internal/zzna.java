package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zznc.zza;

public class zzna extends zzk<zznc> {
    public zzna(Context context, Looper looper, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 74, zzg, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbz */
    public zznc zzbb(IBinder iBinder) {
        return zza.zzcb(iBinder);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String zzra() {
        return "com.google.android.gms.auth.api.accountactivationstate.START";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String zzrb() {
        return "com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService";
    }
}
