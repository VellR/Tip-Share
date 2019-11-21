package com.google.android.gms.internal;

public class zzako extends zzakg {
    private final zzahr aZo;

    public zzako(zzahr zzahr) {
        if (zzahr.size() != 1 || !zzahr.zzcrb().zzcut()) {
            this.aZo = zzahr;
            return;
        }
        throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aZo.equals(((zzako) obj).aZo);
    }

    public int hashCode() {
        return this.aZo.hashCode();
    }

    /* renamed from: zza */
    public int compare(zzakl zzakl, zzakl zzakl2) {
        int compareTo = zzakl.zzcmq().zzao(this.aZo).compareTo(zzakl2.zzcmq().zzao(this.aZo));
        return compareTo == 0 ? zzakl.zzcvs().compareTo(zzakl2.zzcvs()) : compareTo;
    }

    public zzakl zzcvk() {
        return new zzakl(zzaka.zzcuq(), zzakf.zzcvi().zzl(this.aZo, zzakm.aZk));
    }

    public String zzcvl() {
        return this.aZo.zzcqz();
    }

    public zzakl zzg(zzaka zzaka, zzakm zzakm) {
        return new zzakl(zzaka, zzakf.zzcvi().zzl(this.aZo, zzakm));
    }

    public boolean zzl(zzakm zzakm) {
        return !zzakm.zzao(this.aZo).isEmpty();
    }
}
