package com.google.android.gms.internal;

public class zzaje {
    private final zzakh aXq;
    private final boolean aXr;
    private final boolean aXs;

    public zzaje(zzakh zzakh, boolean z, boolean z2) {
        this.aXq = zzakh;
        this.aXr = z;
        this.aXs = z2;
    }

    public boolean zzam(zzahr zzahr) {
        return zzahr.isEmpty() ? zzcsz() && !this.aXs : zzf(zzahr.zzcrb());
    }

    public zzakm zzcmq() {
        return this.aXq.zzcmq();
    }

    public boolean zzcsz() {
        return this.aXr;
    }

    public boolean zzcta() {
        return this.aXs;
    }

    public zzakh zzctb() {
        return this.aXq;
    }

    public boolean zzf(zzaka zzaka) {
        return (zzcsz() && !this.aXs) || this.aXq.zzcmq().zzk(zzaka);
    }
}
