package com.google.android.gms.internal;

public class zzakp extends zzakg {
    private static final zzakp aZp = new zzakp();

    private zzakp() {
    }

    public static zzakp zzcvt() {
        return aZp;
    }

    public boolean equals(Object obj) {
        return obj instanceof zzakp;
    }

    public int hashCode() {
        return 3155577;
    }

    public String toString() {
        return "PriorityIndex";
    }

    /* renamed from: zza */
    public int compare(zzakl zzakl, zzakl zzakl2) {
        return zzakn.zza(zzakl.zzcvs(), zzakl.zzcmq().zzcux(), zzakl2.zzcvs(), zzakl2.zzcmq().zzcux());
    }

    public zzakl zzcvk() {
        return zzg(zzaka.zzcuq(), zzakm.aZk);
    }

    public String zzcvl() {
        throw new IllegalArgumentException("Can't get query definition on priority index!");
    }

    public zzakl zzg(zzaka zzaka, zzakm zzakm) {
        return new zzakl(zzaka, new zzaks("[PRIORITY-POST]", zzakm));
    }

    public boolean zzl(zzakm zzakm) {
        return !zzakm.zzcux().isEmpty();
    }
}
