package com.google.android.gms.internal;

import java.util.Comparator;

public abstract class zzakg implements Comparator<zzakl> {
    public static zzakg zzrn(String str) {
        if (str.equals(".value")) {
            return zzakt.zzcvv();
        }
        if (str.equals(".key")) {
            return zzaki.zzcvp();
        }
        if (!str.equals(".priority")) {
            return new zzako(new zzahr(str));
        }
        throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
    }

    public int zza(zzakl zzakl, zzakl zzakl2, boolean z) {
        return z ? compare(zzakl2, zzakl) : compare(zzakl, zzakl2);
    }

    public boolean zza(zzakm zzakm, zzakm zzakm2) {
        return compare(new zzakl(zzaka.zzcup(), zzakm), new zzakl(zzaka.zzcup(), zzakm2)) != 0;
    }

    public zzakl zzcvj() {
        return zzakl.zzcvq();
    }

    public abstract zzakl zzcvk();

    public abstract String zzcvl();

    public abstract zzakl zzg(zzaka zzaka, zzakm zzakm);

    public abstract boolean zzl(zzakm zzakm);
}
