package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.zze;

public class zzaf extends zzaa {
    private long anE;
    private final Runnable anF = new Runnable() {
        @MainThread
        public void run() {
            zzaf.this.zzbsy().zzl(new Runnable() {
                public void run() {
                    zzaf.this.zzbvw();
                }
            });
        }
    };
    private final zzf anG = new zzf(this.aja) {
        @WorkerThread
        public void run() {
            zzaf.this.zzbvx();
        }
    };
    private final zzf anH = new zzf(this.aja) {
        @WorkerThread
        public void run() {
            zzaf.this.zzbvy();
        }
    };
    private Handler mHandler;

    zzaf(zzx zzx) {
        super(zzx);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzbl(long j) {
        zzwu();
        zzbvu();
        this.anG.cancel();
        this.anH.cancel();
        zzbsz().zzbty().zzj("Activity resumed, time", Long.valueOf(j));
        this.anE = j;
        if (zzyw().currentTimeMillis() - zzbta().alF.get() > zzbta().alH.get()) {
            zzbta().alG.set(true);
            zzbta().alI.set(0);
        }
        if (zzbta().alG.get()) {
            this.anG.zzv(Math.max(0, zzbta().alE.get() - zzbta().alI.get()));
        } else {
            this.anH.zzv(Math.max(0, 3600000 - zzbta().alI.get()));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzbm(long j) {
        zzwu();
        zzbvu();
        this.anG.cancel();
        this.anH.cancel();
        zzbsz().zzbty().zzj("Activity paused, time", Long.valueOf(j));
        if (this.anE != 0) {
            zzbta().alI.set(zzbta().alI.get() + (j - this.anE));
        }
        zzbta().alH.set(zzyw().currentTimeMillis());
        synchronized (this) {
            if (!zzbta().alG.get()) {
                this.mHandler.postDelayed(this.anF, 1000);
            }
        }
    }

    private void zzbvu() {
        synchronized (this) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzbvx() {
        zzwu();
        zzbsz().zzbty().zzj("Session started, time", Long.valueOf(zzyw().elapsedRealtime()));
        zzbta().alG.set(false);
        zzbsq().zze("auto", "_s", new Bundle());
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzbvy() {
        zzwu();
        long elapsedRealtime = zzyw().elapsedRealtime();
        if (this.anE == 0) {
            this.anE = elapsedRealtime - 3600000;
        }
        long j = zzbta().alI.get() + (elapsedRealtime - this.anE);
        zzbta().alI.set(j);
        zzbsz().zzbty().zzj("Recording user engagement, ms", Long.valueOf(j));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j);
        zzbsq().zze("auto", "_e", bundle);
        zzbta().alI.set(0);
        this.anE = elapsedRealtime;
        this.anH.zzv(Math.max(0, 3600000 - zzbta().alI.get()));
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzbso() {
        super.zzbso();
    }

    public /* bridge */ /* synthetic */ zzc zzbsp() {
        return super.zzbsp();
    }

    public /* bridge */ /* synthetic */ zzac zzbsq() {
        return super.zzbsq();
    }

    public /* bridge */ /* synthetic */ zzn zzbsr() {
        return super.zzbsr();
    }

    public /* bridge */ /* synthetic */ zzg zzbss() {
        return super.zzbss();
    }

    public /* bridge */ /* synthetic */ zzad zzbst() {
        return super.zzbst();
    }

    public /* bridge */ /* synthetic */ zze zzbsu() {
        return super.zzbsu();
    }

    public /* bridge */ /* synthetic */ zzal zzbsv() {
        return super.zzbsv();
    }

    public /* bridge */ /* synthetic */ zzv zzbsw() {
        return super.zzbsw();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsx() {
        return super.zzbsx();
    }

    public /* bridge */ /* synthetic */ zzw zzbsy() {
        return super.zzbsy();
    }

    public /* bridge */ /* synthetic */ zzp zzbsz() {
        return super.zzbsz();
    }

    public /* bridge */ /* synthetic */ zzt zzbta() {
        return super.zzbta();
    }

    public /* bridge */ /* synthetic */ zzd zzbtb() {
        return super.zzbtb();
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void zzbvt() {
        synchronized (this) {
            zzbvu();
            this.mHandler.removeCallbacks(this.anF);
        }
        final long elapsedRealtime = zzyw().elapsedRealtime();
        zzbsy().zzl(new Runnable() {
            public void run() {
                zzaf.this.zzbl(elapsedRealtime);
            }
        });
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void zzbvv() {
        final long elapsedRealtime = zzyw().elapsedRealtime();
        zzbsy().zzl(new Runnable() {
            public void run() {
                zzaf.this.zzbm(elapsedRealtime);
            }
        });
    }

    @WorkerThread
    public void zzbvw() {
        zzwu();
        zzbsz().zzbtx().log("Application backgrounded. Logging engagement");
        long j = zzbta().alI.get();
        if (j > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzbsq().zze("auto", "_e", bundle);
            zzbta().alI.set(0);
            return;
        }
        zzbsz().zzbtt().zzj("Not logging non-positive engagement time", Long.valueOf(j));
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    /* access modifiers changed from: protected */
    public void zzwv() {
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
