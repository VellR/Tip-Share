package com.google.android.gms.internal;

public class zzaip {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaip.class.desiredAssertionStatus());
    public static final zzaip aWw = new zzaip(zza.User, null, false);
    public static final zzaip aWx = new zzaip(zza.Server, null, false);
    private final boolean aWA;
    private final zza aWy;
    private final zzajl aWz;

    private enum zza {
        User,
        Server
    }

    public zzaip(zza zza2, zzajl zzajl, boolean z) {
        this.aWy = zza2;
        this.aWz = zzajl;
        this.aWA = z;
        if (!$assertionsDisabled && z && !zzcsk()) {
            throw new AssertionError();
        }
    }

    public static zzaip zzc(zzajl zzajl) {
        return new zzaip(zza.Server, zzajl, true);
    }

    public String toString() {
        String valueOf = String.valueOf(this.aWy);
        String valueOf2 = String.valueOf(this.aWz);
        return new StringBuilder(String.valueOf(valueOf).length() + 52 + String.valueOf(valueOf2).length()).append("OperationSource{source=").append(valueOf).append(", queryParams=").append(valueOf2).append(", tagged=").append(this.aWA).append("}").toString();
    }

    public boolean zzcsj() {
        return this.aWy == zza.User;
    }

    public boolean zzcsk() {
        return this.aWy == zza.Server;
    }

    public boolean zzcsl() {
        return this.aWA;
    }

    public zzajl zzcsm() {
        return this.aWz;
    }
}
