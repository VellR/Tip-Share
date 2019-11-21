package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzank<T> {
    public abstract void zza(zzaor zzaor, T t) throws IOException;

    public abstract T zzb(zzaop zzaop) throws IOException;

    public final zzamy zzcl(T t) {
        try {
            zzaog zzaog = new zzaog();
            zza(zzaog, t);
            return zzaog.l();
        } catch (IOException e) {
            throw new zzamz((Throwable) e);
        }
    }
}
