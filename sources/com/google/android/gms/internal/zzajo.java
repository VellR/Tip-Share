package com.google.android.gms.internal;

public class zzajo {
    private final zzaje aYe;
    private final zzaje aYf;

    public zzajo(zzaje zzaje, zzaje zzaje2) {
        this.aYe = zzaje;
        this.aYf = zzaje2;
    }

    public zzajo zza(zzakh zzakh, boolean z, boolean z2) {
        return new zzajo(new zzaje(zzakh, z, z2), this.aYf);
    }

    public zzajo zzb(zzakh zzakh, boolean z, boolean z2) {
        return new zzajo(this.aYe, new zzaje(zzakh, z, z2));
    }

    public zzaje zzcud() {
        return this.aYe;
    }

    public zzakm zzcue() {
        if (this.aYe.zzcsz()) {
            return this.aYe.zzcmq();
        }
        return null;
    }

    public zzaje zzcuf() {
        return this.aYf;
    }

    public zzakm zzcug() {
        if (this.aYf.zzcsz()) {
            return this.aYf.zzcmq();
        }
        return null;
    }
}
