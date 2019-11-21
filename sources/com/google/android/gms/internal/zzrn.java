package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzrp.zza;

public class zzrn extends zzk<zzrp> {
    public zzrn(Context context, Looper looper, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, zzg, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdy */
    public zzrp zzbb(IBinder iBinder) {
        return zza.zzea(iBinder);
    }

    public String zzra() {
        return "com.google.android.gms.common.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzrb() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
