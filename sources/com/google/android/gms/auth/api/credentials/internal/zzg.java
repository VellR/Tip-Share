package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.internal.zzk.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzk;

public final class zzg extends zzk<zzk> {
    @Nullable
    private final AuthCredentialsOptions dt;

    public zzg(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, zzg, connectionCallbacks, onConnectionFailedListener);
        this.dt = authCredentialsOptions;
    }

    /* access modifiers changed from: protected */
    public Bundle zzaeu() {
        return this.dt == null ? new Bundle() : this.dt.zzaeu();
    }

    /* access modifiers changed from: 0000 */
    public AuthCredentialsOptions zzafj() {
        return this.dt;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzcc */
    public zzk zzbb(IBinder iBinder) {
        return zza.zzce(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzra() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzrb() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }
}
