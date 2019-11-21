package com.google.android.gms.internal;

import com.google.android.gms.internal.zzajt.zza;
import java.util.Iterator;

public class zzajs implements zzajt {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzajs.class.desiredAssertionStatus());
    private final zzakg aXI;
    private final zzaju aYm;
    private final int aYn;
    private final boolean aYo;

    public zzajs(zzajl zzajl) {
        this.aYm = new zzaju(zzajl);
        this.aXI = zzajl.zzcts();
        this.aYn = zzajl.getLimit();
        this.aYo = !zzajl.zzctu();
    }

    private zzakh zza(zzakh zzakh, zzaka zzaka, zzakm zzakm, zza zza, zzajq zzajq) {
        if ($assertionsDisabled || zzakh.zzcmq().getChildCount() == this.aYn) {
            zzakl zzakl = new zzakl(zzaka, zzakm);
            zzakl zzcvo = this.aYo ? zzakh.zzcvn() : zzakh.zzcvo();
            boolean zza2 = this.aYm.zza(zzakl);
            if (zzakh.zzcmq().zzk(zzaka)) {
                zzakm zzm = zzakh.zzcmq().zzm(zzaka);
                zzakl zza3 = zza.zza(this.aXI, zzcvo, this.aYo);
                while (zza3 != null && (zza3.zzcvs().equals(zzaka) || zzakh.zzcmq().zzk(zza3.zzcvs()))) {
                    zza3 = zza.zza(this.aXI, zza3, this.aYo);
                }
                if (zza2 && !zzakm.isEmpty() && (zza3 == null ? 1 : this.aXI.zza(zza3, zzakl, this.aYo)) >= 0) {
                    if (zzajq != null) {
                        zzajq.zza(zzajg.zza(zzaka, zzakm, zzm));
                    }
                    return zzakh.zzh(zzaka, zzakm);
                }
                if (zzajq != null) {
                    zzajq.zza(zzajg.zzd(zzaka, zzm));
                }
                zzakh zzh = zzakh.zzh(zzaka, zzakf.zzcvi());
                if (!(zza3 != null && this.aYm.zza(zza3))) {
                    return zzh;
                }
                if (zzajq != null) {
                    zzajq.zza(zzajg.zzc(zza3.zzcvs(), zza3.zzcmq()));
                }
                return zzh.zzh(zza3.zzcvs(), zza3.zzcmq());
            } else if (zzakm.isEmpty() || !zza2 || this.aXI.zza(zzcvo, zzakl, this.aYo) < 0) {
                return zzakh;
            } else {
                if (zzajq != null) {
                    zzajq.zza(zzajg.zzd(zzcvo.zzcvs(), zzcvo.zzcmq()));
                    zzajq.zza(zzajg.zzc(zzaka, zzakm));
                }
                return zzakh.zzh(zzaka, zzakm).zzh(zzcvo.zzcvs(), zzakf.zzcvi());
            }
        } else {
            throw new AssertionError();
        }
    }

    public zzakh zza(zzakh zzakh, zzaka zzaka, zzakm zzakm, zzahr zzahr, zza zza, zzajq zzajq) {
        zzakm zzakm2 = !this.aYm.zza(new zzakl(zzaka, zzakm)) ? zzakf.zzcvi() : zzakm;
        return zzakh.zzcmq().zzm(zzaka).equals(zzakm2) ? zzakh : zzakh.zzcmq().getChildCount() < this.aYn ? this.aYm.zzcui().zza(zzakh, zzaka, zzakm2, zzahr, zza, zzajq) : zza(zzakh, zzaka, zzakm2, zza, zzajq);
    }

    public zzakh zza(zzakh zzakh, zzakh zzakh2, zzajq zzajq) {
        zzakh zzakh3;
        zzakl zzcul;
        zzakl zzakl;
        int i;
        Iterator it;
        int i2;
        if (zzakh2.zzcmq().zzcuw() || zzakh2.zzcmq().isEmpty()) {
            zzakh3 = zzakh.zza(zzakf.zzcvi(), this.aXI);
        } else {
            zzakh zzn = zzakh2.zzn(zzakq.zzcvu());
            if (this.aYo) {
                Iterator zzcnd = zzakh2.zzcnd();
                zzakl = this.aYm.zzcul();
                zzcul = this.aYm.zzcuk();
                it = zzcnd;
                i = -1;
            } else {
                Iterator it2 = zzakh2.iterator();
                zzakl zzcuk = this.aYm.zzcuk();
                zzcul = this.aYm.zzcul();
                zzakl = zzcuk;
                i = 1;
                it = it2;
            }
            int i3 = 0;
            zzakh3 = zzn;
            boolean z = false;
            while (it.hasNext()) {
                zzakl zzakl2 = (zzakl) it.next();
                if (!z && this.aXI.compare(zzakl, zzakl2) * i <= 0) {
                    z = true;
                }
                if (z && i3 < this.aYn && this.aXI.compare(zzakl2, zzcul) * i <= 0) {
                    i2 = i3 + 1;
                } else {
                    zzakh3 = zzakh3.zzh(zzakl2.zzcvs(), zzakf.zzcvi());
                    i2 = i3;
                }
                zzakh3 = zzakh3;
                i3 = i2;
            }
        }
        return this.aYm.zzcui().zza(zzakh, zzakh3, zzajq);
    }

    public zzakh zza(zzakh zzakh, zzakm zzakm) {
        return zzakh;
    }

    public zzakg zzcts() {
        return this.aXI;
    }

    public zzajt zzcui() {
        return this.aYm.zzcui();
    }

    public boolean zzcuj() {
        return true;
    }
}
