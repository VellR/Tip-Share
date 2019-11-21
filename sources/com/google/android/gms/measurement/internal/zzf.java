package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzab;

abstract class zzf {
    private static volatile Handler zzczj;
    /* access modifiers changed from: private */
    public boolean ajR = true;
    /* access modifiers changed from: private */
    public final zzx aja;
    /* access modifiers changed from: private */
    public volatile long zzczk;
    private final Runnable zzw = new Runnable() {
        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                zzf.this.aja.zzbsy().zzl(this);
                return;
            }
            boolean zzfc = zzf.this.zzfc();
            zzf.this.zzczk = 0;
            if (zzfc && zzf.this.ajR) {
                zzf.this.run();
            }
        }
    };

    zzf(zzx zzx) {
        zzab.zzaa(zzx);
        this.aja = zzx;
    }

    private Handler getHandler() {
        Handler handler;
        if (zzczj != null) {
            return zzczj;
        }
        synchronized (zzf.class) {
            if (zzczj == null) {
                zzczj = new Handler(this.aja.getContext().getMainLooper());
            }
            handler = zzczj;
        }
        return handler;
    }

    public void cancel() {
        this.zzczk = 0;
        getHandler().removeCallbacks(this.zzw);
    }

    public abstract void run();

    public boolean zzfc() {
        return this.zzczk != 0;
    }

    public void zzv(long j) {
        cancel();
        if (j >= 0) {
            this.zzczk = this.aja.zzyw().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzw, j)) {
                this.aja.zzbsz().zzbtr().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
