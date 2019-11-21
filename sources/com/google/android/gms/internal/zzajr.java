package com.google.android.gms.internal;

import com.google.android.gms.internal.zzajt.zza;

public class zzajr implements zzajt {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzajr.class.desiredAssertionStatus());
    private final zzakg aXI;

    public zzajr(zzakg zzakg) {
        this.aXI = zzakg;
    }

    public zzakh zza(zzakh zzakh, zzaka zzaka, zzakm zzakm, zzahr zzahr, zza zza, zzajq zzajq) {
        if ($assertionsDisabled || zzakh.zzb(this.aXI)) {
            zzakm zzcmq = zzakh.zzcmq();
            zzakm zzm = zzcmq.zzm(zzaka);
            if (zzm.zzao(zzahr).equals(zzakm.zzao(zzahr)) && zzm.isEmpty() == zzakm.isEmpty()) {
                return zzakh;
            }
            if (zzajq != null) {
                if (zzakm.isEmpty()) {
                    if (zzcmq.zzk(zzaka)) {
                        zzajq.zza(zzajg.zzd(zzaka, zzm));
                    } else if (!$assertionsDisabled && !zzcmq.zzcuw()) {
                        throw new AssertionError("A child remove without an old child only makes sense on a leaf node");
                    }
                } else if (zzm.isEmpty()) {
                    zzajq.zza(zzajg.zzc(zzaka, zzakm));
                } else {
                    zzajq.zza(zzajg.zza(zzaka, zzakm, zzm));
                }
            }
            return (!zzcmq.zzcuw() || !zzakm.isEmpty()) ? zzakh.zzh(zzaka, zzakm) : zzakh;
        }
        throw new AssertionError("The index must match the filter");
    }

    public zzakh zza(zzakh zzakh, zzakh zzakh2, zzajq zzajq) {
        if ($assertionsDisabled || zzakh2.zzb(this.aXI)) {
            if (zzajq != null) {
                for (zzakl zzakl : zzakh.zzcmq()) {
                    if (!zzakh2.zzcmq().zzk(zzakl.zzcvs())) {
                        zzajq.zza(zzajg.zzd(zzakl.zzcvs(), zzakl.zzcmq()));
                    }
                }
                if (!zzakh2.zzcmq().zzcuw()) {
                    for (zzakl zzakl2 : zzakh2.zzcmq()) {
                        if (zzakh.zzcmq().zzk(zzakl2.zzcvs())) {
                            zzakm zzm = zzakh.zzcmq().zzm(zzakl2.zzcvs());
                            if (!zzm.equals(zzakl2.zzcmq())) {
                                zzajq.zza(zzajg.zza(zzakl2.zzcvs(), zzakl2.zzcmq(), zzm));
                            }
                        } else {
                            zzajq.zza(zzajg.zzc(zzakl2.zzcvs(), zzakl2.zzcmq()));
                        }
                    }
                }
            }
            return zzakh2;
        }
        throw new AssertionError("Can't use IndexedNode that doesn't have filter's index");
    }

    public zzakh zza(zzakh zzakh, zzakm zzakm) {
        return zzakh.zzcmq().isEmpty() ? zzakh : zzakh.zzn(zzakm);
    }

    public zzakg zzcts() {
        return this.aXI;
    }

    public zzajt zzcui() {
        return this;
    }

    public boolean zzcuj() {
        return false;
    }
}
