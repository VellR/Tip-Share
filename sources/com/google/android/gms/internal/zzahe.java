package com.google.android.gms.internal;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzahe {
    private final ScheduledExecutorService aPL;
    private final zzajx aPY;
    private final long aSM;
    private final long aSN;
    private final double aSO;
    private final double aSP;
    private final Random aSQ;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> aSR;
    private long aSS;
    private boolean aST;

    public static class zza {
        private final zzajx aPY;
        private long aSM = 1000;
        private double aSO = 0.5d;
        private double aSP = 1.3d;
        private final ScheduledExecutorService aSV;
        private long aSW = 30000;

        public zza(ScheduledExecutorService scheduledExecutorService, zzajy zzajy, String str) {
            this.aSV = scheduledExecutorService;
            this.aPY = new zzajx(zzajy, str);
        }

        public zza zzcd(long j) {
            this.aSM = j;
            return this;
        }

        public zza zzce(long j) {
            this.aSW = j;
            return this;
        }

        public zzahe zzcpo() {
            return new zzahe(this.aSV, this.aPY, this.aSM, this.aSW, this.aSP, this.aSO);
        }

        public zza zzk(double d) {
            this.aSP = d;
            return this;
        }

        public zza zzl(double d) {
            if (d < 0.0d || d > 1.0d) {
                throw new IllegalArgumentException("Argument out of range: " + d);
            }
            this.aSO = d;
            return this;
        }
    }

    private zzahe(ScheduledExecutorService scheduledExecutorService, zzajx zzajx, long j, long j2, double d, double d2) {
        this.aSQ = new Random();
        this.aST = true;
        this.aPL = scheduledExecutorService;
        this.aPY = zzajx;
        this.aSM = j;
        this.aSN = j2;
        this.aSP = d;
        this.aSO = d2;
    }

    public void cancel() {
        if (this.aSR != null) {
            this.aPY.zzh("Cancelling existing retry attempt", new Object[0]);
            this.aSR.cancel(false);
            this.aSR = null;
        } else {
            this.aPY.zzh("No existing retry attempt to cancel", new Object[0]);
        }
        this.aSS = 0;
    }

    public void zzcle() {
        this.aST = true;
        this.aSS = 0;
    }

    public void zzq(final Runnable runnable) {
        long j = 0;
        AnonymousClass1 r2 = new Runnable() {
            public void run() {
                zzahe.this.aSR = null;
                runnable.run();
            }
        };
        if (this.aSR != null) {
            this.aPY.zzh("Cancelling previous scheduled retry", new Object[0]);
            this.aSR.cancel(false);
            this.aSR = null;
        }
        if (!this.aST) {
            if (this.aSS == 0) {
                this.aSS = this.aSM;
            } else {
                this.aSS = Math.min((long) (((double) this.aSS) * this.aSP), this.aSN);
            }
            j = (long) (((1.0d - this.aSO) * ((double) this.aSS)) + (this.aSO * ((double) this.aSS) * this.aSQ.nextDouble()));
        }
        this.aST = false;
        this.aPY.zzh("Scheduling retry in %dms", Long.valueOf(j));
        this.aSR = this.aPL.schedule(r2, j, TimeUnit.MILLISECONDS);
    }
}
