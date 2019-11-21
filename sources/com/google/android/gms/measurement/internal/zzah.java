package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;

class zzah {
    private final zze zzaoa;
    private long zzboy;

    public zzah(zze zze) {
        zzab.zzaa(zze);
        this.zzaoa = zze;
    }

    public void clear() {
        this.zzboy = 0;
    }

    public void start() {
        this.zzboy = this.zzaoa.elapsedRealtime();
    }

    public boolean zzx(long j) {
        return this.zzboy == 0 || this.zzaoa.elapsedRealtime() - this.zzboy >= j;
    }
}
