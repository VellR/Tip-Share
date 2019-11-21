package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaio.zza;

public class zzaiq extends zzaio {
    private final zzakm aWE;

    public zzaiq(zzaip zzaip, zzahr zzahr, zzakm zzakm) {
        super(zza.Overwrite, zzaip, zzahr);
        this.aWE = zzakm;
    }

    public String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", new Object[]{zzcmu(), zzcsh(), this.aWE});
    }

    public zzaio zzc(zzaka zzaka) {
        return this.aPz.isEmpty() ? new zzaiq(this.aWq, zzahr.zzcqy(), this.aWE.zzm(zzaka)) : new zzaiq(this.aWq, this.aPz.zzcrc(), this.aWE);
    }

    public zzakm zzcsn() {
        return this.aWE;
    }
}
