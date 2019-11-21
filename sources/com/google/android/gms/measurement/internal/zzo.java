package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;
import com.google.android.gms.measurement.internal.zzm.zza;

public class zzo extends zzd<zzm> {
    public zzo(Context context, Looper looper, zzb zzb, zzc zzc) {
        super(context, looper, 93, zzb, zzc, null);
    }

    /* renamed from: zzjc */
    public zzm zzbb(IBinder iBinder) {
        return zza.zzjb(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzra() {
        return "com.google.android.gms.measurement.START";
    }

    /* access modifiers changed from: protected */
    public String zzrb() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
