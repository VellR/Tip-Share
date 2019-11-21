package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class zzakr {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzakr.class.desiredAssertionStatus());
    private final zzahr aZq;
    private final zzahr aZr;
    private final zzakm aZs;

    public zzakr(zzahb zzahb) {
        zzahr zzahr = null;
        List zzcpd = zzahb.zzcpd();
        this.aZq = zzcpd != null ? new zzahr(zzcpd) : null;
        List zzcpe = zzahb.zzcpe();
        if (zzcpe != null) {
            zzahr = new zzahr(zzcpe);
        }
        this.aZr = zzahr;
        this.aZs = zzakn.zzbs(zzahb.zzcpf());
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.android.gms.internal.zzakm, code=com.google.android.gms.internal.zzakm<com.google.android.gms.internal.zzakl>, for r10v0, types: [com.google.android.gms.internal.zzakm, com.google.android.gms.internal.zzakm<com.google.android.gms.internal.zzakl>] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.android.gms.internal.zzakm, code=com.google.android.gms.internal.zzakm<com.google.android.gms.internal.zzakl>, for r9v0, types: [com.google.android.gms.internal.zzakm, com.google.android.gms.internal.zzakm<com.google.android.gms.internal.zzakl>] */
    private zzakm zzb(zzahr zzahr, zzakm<zzakl> zzakm, zzakm<zzakl> zzakm2) {
        boolean z = true;
        int zzj = this.aZq == null ? 1 : zzahr.compareTo(this.aZq);
        int zzj2 = this.aZr == null ? -1 : zzahr.compareTo(this.aZr);
        boolean z2 = this.aZq != null && zzahr.zzi(this.aZq);
        if (this.aZr == null || !zzahr.zzi(this.aZr)) {
            z = false;
        }
        if (zzj > 0 && zzj2 < 0 && !z) {
            return zzakm2;
        }
        if (zzj > 0 && z && zzakm2.zzcuw()) {
            return zzakm2;
        }
        if (zzj <= 0 || zzj2 != 0) {
            if (z2 || z) {
                HashSet hashSet = new HashSet();
                for (zzakl zzcvs : zzakm) {
                    hashSet.add(zzcvs.zzcvs());
                }
                for (zzakl zzcvs2 : zzakm2) {
                    hashSet.add(zzcvs2.zzcvs());
                }
                ArrayList<zzaka> arrayList = new ArrayList<>(hashSet.size() + 1);
                arrayList.addAll(hashSet);
                if (!zzakm2.zzcux().isEmpty() || !zzakm.zzcux().isEmpty()) {
                    arrayList.add(zzaka.zzcur());
                }
                zzakm zzakm3 = zzakm;
                for (zzaka zzaka : arrayList) {
                    zzakm zzm = zzakm.zzm(zzaka);
                    zzakm zzb = zzb(zzahr.zza(zzaka), zzakm.zzm(zzaka), zzakm2.zzm(zzaka));
                    zzakm3 = zzb != zzm ? zzakm3.zze(zzaka, zzb) : zzakm3;
                }
                return zzakm3;
            } else if ($assertionsDisabled || zzj2 > 0 || zzj <= 0) {
                return zzakm;
            } else {
                throw new AssertionError();
            }
        } else if (!$assertionsDisabled && !z) {
            throw new AssertionError();
        } else if ($assertionsDisabled || !zzakm2.zzcuw()) {
            return zzakm.zzcuw() ? zzakf.zzcvi() : zzakm;
        } else {
            throw new AssertionError();
        }
    }

    public String toString() {
        String valueOf = String.valueOf(this.aZq);
        String valueOf2 = String.valueOf(this.aZr);
        String valueOf3 = String.valueOf(this.aZs);
        return new StringBuilder(String.valueOf(valueOf).length() + 55 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("RangeMerge{optExclusiveStart=").append(valueOf).append(", optInclusiveEnd=").append(valueOf2).append(", snap=").append(valueOf3).append("}").toString();
    }

    public zzakm zzq(zzakm zzakm) {
        return zzb(zzahr.zzcqy(), zzakm, this.aZs);
    }
}
