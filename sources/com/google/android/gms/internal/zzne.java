package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;

public final class zzne extends zzk<zzng> {
    private final Bundle du;

    public zzne(Context context, Looper looper, zzg zzg, zza zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, zzg, connectionCallbacks, onConnectionFailedListener);
        this.du = zza == null ? new Bundle() : zza.zzafc();
    }

    /* access modifiers changed from: protected */
    public Bundle zzaeu() {
        return this.du;
    }

    public boolean zzafk() {
        zzg zzasr = zzasr();
        return !TextUtils.isEmpty(zzasr.getAccountName()) && !zzasr.zzb(Auth.PROXY_API).isEmpty();
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzcf */
    public zzng zzbb(IBinder iBinder) {
        return zzng.zza.zzch(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzra() {
        return "com.google.android.gms.auth.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzrb() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }
}
