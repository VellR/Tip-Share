package com.google.android.gms.internal;

public class zzaki extends zzakg {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaki.class.desiredAssertionStatus());
    private static final zzaki aZb = new zzaki();

    private zzaki() {
    }

    public static zzaki zzcvp() {
        return aZb;
    }

    public boolean equals(Object obj) {
        return obj instanceof zzaki;
    }

    public int hashCode() {
        return 37;
    }

    public String toString() {
        return "KeyIndex";
    }

    /* renamed from: zza */
    public int compare(zzakl zzakl, zzakl zzakl2) {
        return zzakl.zzcvs().compareTo(zzakl2.zzcvs());
    }

    public zzakl zzcvk() {
        return zzakl.zzcvr();
    }

    public String zzcvl() {
        return ".key";
    }

    public zzakl zzg(zzaka zzaka, zzakm zzakm) {
        if ($assertionsDisabled || (zzakm instanceof zzaks)) {
            return new zzakl(zzaka.zzrm((String) zzakm.getValue()), zzakf.zzcvi());
        }
        throw new AssertionError();
    }

    public boolean zzl(zzakm zzakm) {
        return true;
    }
}
