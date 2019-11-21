package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvz;

public final class zzae {
    private static Boolean zzcsb;
    /* access modifiers changed from: private */
    public final zza anz;
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler();

    public interface zza {
        boolean callServiceStopSelfResult(int i);

        Context getContext();
    }

    public zzae(zza zza2) {
        this.mContext = zza2.getContext();
        zzab.zzaa(this.mContext);
        this.anz = zza2;
    }

    public static boolean zzaw(Context context) {
        zzab.zzaa(context);
        if (zzcsb != null) {
            return zzcsb.booleanValue();
        }
        boolean zzk = zzal.zzk(context, "com.google.android.gms.measurement.AppMeasurementService");
        zzcsb = Boolean.valueOf(zzk);
        return zzk;
    }

    private zzp zzbsz() {
        return zzx.zzdo(this.mContext).zzbsz();
    }

    private void zzvw() {
        try {
            synchronized (zzu.zzamp) {
                zzvz zzvz = zzu.zzcrz;
                if (zzvz != null && zzvz.isHeld()) {
                    zzvz.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    @MainThread
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            zzbsz().zzbtr().log("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzy(zzx.zzdo(this.mContext));
        }
        zzbsz().zzbtt().zzj("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public void onCreate() {
        zzx zzdo = zzx.zzdo(this.mContext);
        zzp zzbsz = zzdo.zzbsz();
        if (zzdo.zzbtb().zzabc()) {
            zzbsz.zzbty().log("Device AppMeasurementService is starting up");
        } else {
            zzbsz.zzbty().log("Local AppMeasurementService is starting up");
        }
    }

    @MainThread
    public void onDestroy() {
        zzx zzdo = zzx.zzdo(this.mContext);
        zzp zzbsz = zzdo.zzbsz();
        if (zzdo.zzbtb().zzabc()) {
            zzbsz.zzbty().log("Device AppMeasurementService is shutting down");
        } else {
            zzbsz.zzbty().log("Local AppMeasurementService is shutting down");
        }
    }

    @MainThread
    public void onRebind(Intent intent) {
        if (intent == null) {
            zzbsz().zzbtr().log("onRebind called with null intent");
            return;
        }
        zzbsz().zzbty().zzj("onRebind called. action", intent.getAction());
    }

    @MainThread
    public int onStartCommand(Intent intent, int i, final int i2) {
        zzvw();
        final zzx zzdo = zzx.zzdo(this.mContext);
        final zzp zzbsz = zzdo.zzbsz();
        if (intent == null) {
            zzbsz.zzbtt().log("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            if (zzdo.zzbtb().zzabc()) {
                zzbsz.zzbty().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            } else {
                zzbsz.zzbty().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            }
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzdo.zzbsy().zzl(new Runnable() {
                    public void run() {
                        zzdo.zzbvd();
                        zzdo.zzbuy();
                        zzae.this.mHandler.post(new Runnable() {
                            public void run() {
                                if (!zzae.this.anz.callServiceStopSelfResult(i2)) {
                                    return;
                                }
                                if (zzdo.zzbtb().zzabc()) {
                                    zzbsz.zzbty().log("Device AppMeasurementService processed last upload request");
                                } else {
                                    zzbsz.zzbty().log("Local AppMeasurementService processed last upload request");
                                }
                            }
                        });
                    }
                });
            }
        }
        return 2;
    }

    @MainThread
    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzbsz().zzbtr().log("onUnbind called with null intent");
        } else {
            zzbsz().zzbty().zzj("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
