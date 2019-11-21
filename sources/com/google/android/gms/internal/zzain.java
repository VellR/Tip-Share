package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaio.zza;

public class zzain extends zzaio {
    private final zzahi aWo;

    public zzain(zzaip zzaip, zzahr zzahr, zzahi zzahi) {
        super(zza.Merge, zzaip, zzahr);
        this.aWo = zzahi;
    }

    public String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", new Object[]{zzcmu(), zzcsh(), this.aWo});
    }

    public zzaio zzc(zzaka zzaka) {
        if (this.aPz.isEmpty()) {
            zzahi zzg = this.aWo.zzg(new zzahr(zzaka));
            if (zzg.isEmpty()) {
                return null;
            }
            return zzg.zzcpw() != null ? new zzaiq(this.aWq, zzahr.zzcqy(), zzg.zzcpw()) : new zzain(this.aWq, zzahr.zzcqy(), zzg);
        } else if (this.aPz.zzcrb().equals(zzaka)) {
            return new zzain(this.aWq, this.aPz.zzcrc(), this.aWo);
        } else {
            return null;
        }
    }

    public zzahi zzcsg() {
        return this.aWo;
    }
}
