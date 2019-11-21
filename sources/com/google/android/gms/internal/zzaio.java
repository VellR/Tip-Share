package com.google.android.gms.internal;

public abstract class zzaio {
    protected final zzahr aPz;
    protected final zza aWp;
    protected final zzaip aWq;

    public enum zza {
        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete
    }

    protected zzaio(zza zza2, zzaip zzaip, zzahr zzahr) {
        this.aWp = zza2;
        this.aWq = zzaip;
        this.aPz = zzahr;
    }

    public abstract zzaio zzc(zzaka zzaka);

    public zzahr zzcmu() {
        return this.aPz;
    }

    public zzaip zzcsh() {
        return this.aWq;
    }

    public zza zzcsi() {
        return this.aWp;
    }
}
