package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzg;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzah<T extends IInterface> extends zzk<T> {
    private final zzg<T> zb;

    public zzah(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzg zzg, zzg<T> zzg2) {
        super(context, looper, i, zzg, connectionCallbacks, onConnectionFailedListener);
        this.zb = zzg2;
    }

    public zzg<T> zzatj() {
        return this.zb;
    }

    /* access modifiers changed from: protected */
    public T zzbb(IBinder iBinder) {
        return this.zb.zzbb(iBinder);
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, T t) {
        this.zb.zza(i, t);
    }

    /* access modifiers changed from: protected */
    public String zzra() {
        return this.zb.zzra();
    }

    /* access modifiers changed from: protected */
    public String zzrb() {
        return this.zb.zzrb();
    }
}
