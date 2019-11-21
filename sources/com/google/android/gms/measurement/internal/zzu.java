package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvz;

public final class zzu {
    static final Object zzamp = new Object();
    static zzvz zzcrz;
    static Boolean zzcsa;

    public static boolean zzav(Context context) {
        zzab.zzaa(context);
        if (zzcsa != null) {
            return zzcsa.booleanValue();
        }
        boolean zzb = zzal.zzb(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
        zzcsa = Boolean.valueOf(zzb);
        return zzb;
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        zzx zzdo = zzx.zzdo(context);
        zzp zzbsz = zzdo.zzbsz();
        if (intent == null) {
            zzbsz.zzbtt().log("AppMeasurementReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (zzdo.zzbtb().zzabc()) {
            zzbsz.zzbty().zzj("Device AppMeasurementReceiver got", action);
        } else {
            zzbsz.zzbty().zzj("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean zzaw = zzae.zzaw(context);
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (zzamp) {
                context.startService(className);
                if (zzaw) {
                    try {
                        if (zzcrz == null) {
                            zzcrz = new zzvz(context, 1, "AppMeasurement WakeLock");
                            zzcrz.setReferenceCounted(false);
                        }
                        zzcrz.acquire(1000);
                    } catch (SecurityException e) {
                        zzbsz.zzbtt().log("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                }
            }
        }
    }
}
