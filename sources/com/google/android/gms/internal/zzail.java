package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaio.zza;

public class zzail extends zzaio {
    private final boolean aWm;
    private final zzaja<Boolean> aWn;

    public zzail(zzahr zzahr, zzaja<Boolean> zzaja, boolean z) {
        super(zza.AckUserWrite, zzaip.aWw, zzahr);
        this.aWn = zzaja;
        this.aWm = z;
    }

    public String toString() {
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", new Object[]{zzcmu(), Boolean.valueOf(this.aWm), this.aWn});
    }

    public zzaio zzc(zzaka zzaka) {
        if (!this.aPz.isEmpty()) {
            zzalo.zzb(this.aPz.zzcrb().equals(zzaka), "operationForChild called for unrelated child.");
            return new zzail(this.aPz.zzcrc(), this.aWn, this.aWm);
        } else if (this.aWn.getValue() != null) {
            zzalo.zzb(this.aWn.zzcsx().isEmpty(), "affectedTree should not have overlapping affected paths.");
            return this;
        } else {
            return new zzail(zzahr.zzcqy(), this.aWn.zzai(new zzahr(zzaka)), this.aWm);
        }
    }

    public zzaja<Boolean> zzcse() {
        return this.aWn;
    }

    public boolean zzcsf() {
        return this.aWm;
    }
}
