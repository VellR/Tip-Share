package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaio.zza;

public class zzaim extends zzaio {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaim.class.desiredAssertionStatus());

    public zzaim(zzaip zzaip, zzahr zzahr) {
        super(zza.ListenComplete, zzaip, zzahr);
        if (!$assertionsDisabled && zzaip.zzcsj()) {
            throw new AssertionError("Can't have a listen complete from a user source");
        }
    }

    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", new Object[]{zzcmu(), zzcsh()});
    }

    public zzaio zzc(zzaka zzaka) {
        return this.aPz.isEmpty() ? new zzaim(this.aWq, zzahr.zzcqy()) : new zzaim(this.aWq, this.aPz.zzcrc());
    }
}
