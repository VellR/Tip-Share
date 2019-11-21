package com.google.android.gms.internal;

public class zzakt extends zzakg {
    private static final zzakt aZt = new zzakt();

    private zzakt() {
    }

    public static zzakt zzcvv() {
        return aZt;
    }

    public boolean equals(Object obj) {
        return obj instanceof zzakt;
    }

    public int hashCode() {
        return 4;
    }

    public String toString() {
        return "ValueIndex";
    }

    /* renamed from: zza */
    public int compare(zzakl zzakl, zzakl zzakl2) {
        int compareTo = zzakl.zzcmq().compareTo(zzakl2.zzcmq());
        return compareTo == 0 ? zzakl.zzcvs().compareTo(zzakl2.zzcvs()) : compareTo;
    }

    public zzakl zzcvk() {
        return new zzakl(zzaka.zzcuq(), zzakm.aZk);
    }

    public String zzcvl() {
        return ".value";
    }

    public zzakl zzg(zzaka zzaka, zzakm zzakm) {
        return new zzakl(zzaka, zzakm);
    }

    public boolean zzl(zzakm zzakm) {
        return true;
    }
}
