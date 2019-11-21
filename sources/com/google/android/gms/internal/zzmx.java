package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.account.zzb;
import com.google.android.gms.auth.account.zzb.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;

public class zzmx extends zzk<zzb> {
    public zzmx(Context context, Looper looper, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 120, zzg, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzby */
    public zzb zzbb(IBinder iBinder) {
        return zza.zzbx(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzra() {
        return "com.google.android.gms.auth.account.workaccount.START";
    }

    /* access modifiers changed from: protected */
    public String zzrb() {
        return "com.google.android.gms.auth.account.IWorkAccountService";
    }
}
