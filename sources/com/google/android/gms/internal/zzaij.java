package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public class zzaij {
    private final zzahr aWi;
    private final zzaii aWj;

    public zzaij(zzahr zzahr, zzaii zzaii) {
        this.aWi = zzahr;
        this.aWj = zzaii;
    }

    public zzakl zza(zzakm zzakm, zzakl zzakl, boolean z, zzakg zzakg) {
        return this.aWj.zza(this.aWi, zzakm, zzakl, z, zzakg);
    }

    public zzakm zza(zzahr zzahr, zzakm zzakm, zzakm zzakm2) {
        return this.aWj.zza(this.aWi, zzahr, zzakm, zzakm2);
    }

    public zzakm zza(zzaka zzaka, zzaje zzaje) {
        return this.aWj.zza(this.aWi, zzaka, zzaje);
    }

    public zzakm zza(zzakm zzakm, List<Long> list) {
        return zza(zzakm, list, false);
    }

    public zzakm zza(zzakm zzakm, List<Long> list, boolean z) {
        return this.aWj.zza(this.aWi, zzakm, list, z);
    }

    public zzaij zzb(zzaka zzaka) {
        return new zzaij(this.aWi.zza(zzaka), this.aWj);
    }

    public zzakm zzc(zzakm zzakm) {
        return zza(zzakm, Collections.emptyList());
    }

    public zzakm zzd(zzakm zzakm) {
        return this.aWj.zzj(this.aWi, zzakm);
    }

    public zzakm zzv(zzahr zzahr) {
        return this.aWj.zzv(this.aWi.zzh(zzahr));
    }
}
