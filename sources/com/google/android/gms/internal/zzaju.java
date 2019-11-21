package com.google.android.gms.internal;

import com.google.android.gms.internal.zzajt.zza;
import java.util.Iterator;

public class zzaju implements zzajt {
    private final zzakg aXI;
    private final zzajr aYp;
    private final zzakl aYq;
    private final zzakl aYr;

    public zzaju(zzajl zzajl) {
        this.aYp = new zzajr(zzajl.zzcts());
        this.aXI = zzajl.zzcts();
        this.aYq = zzd(zzajl);
        this.aYr = zze(zzajl);
    }

    private static zzakl zzd(zzajl zzajl) {
        if (!zzajl.zzctk()) {
            return zzajl.zzcts().zzcvj();
        }
        return zzajl.zzcts().zzg(zzajl.zzctm(), zzajl.zzctl());
    }

    private static zzakl zze(zzajl zzajl) {
        if (!zzajl.zzctn()) {
            return zzajl.zzcts().zzcvk();
        }
        return zzajl.zzcts().zzg(zzajl.zzctp(), zzajl.zzcto());
    }

    public zzakh zza(zzakh zzakh, zzaka zzaka, zzakm zzakm, zzahr zzahr, zza zza, zzajq zzajq) {
        return this.aYp.zza(zzakh, zzaka, !zza(new zzakl(zzaka, zzakm)) ? zzakf.zzcvi() : zzakm, zzahr, zza, zzajq);
    }

    public zzakh zza(zzakh zzakh, zzakh zzakh2, zzajq zzajq) {
        zzakh zzakh3;
        if (!zzakh2.zzcmq().zzcuw()) {
            zzakh zzn = zzakh2.zzn(zzakq.zzcvu());
            Iterator it = zzakh2.iterator();
            while (true) {
                zzakh3 = zzn;
                if (!it.hasNext()) {
                    break;
                }
                zzakl zzakl = (zzakl) it.next();
                zzn = !zza(zzakl) ? zzakh3.zzh(zzakl.zzcvs(), zzakf.zzcvi()) : zzakh3;
            }
        } else {
            zzakh3 = zzakh.zza(zzakf.zzcvi(), this.aXI);
        }
        return this.aYp.zza(zzakh, zzakh3, zzajq);
    }

    public zzakh zza(zzakh zzakh, zzakm zzakm) {
        return zzakh;
    }

    public boolean zza(zzakl zzakl) {
        return this.aXI.compare(zzcuk(), zzakl) <= 0 && this.aXI.compare(zzakl, zzcul()) <= 0;
    }

    public zzakg zzcts() {
        return this.aXI;
    }

    public zzajt zzcui() {
        return this.aYp;
    }

    public boolean zzcuj() {
        return true;
    }

    public zzakl zzcuk() {
        return this.aYq;
    }

    public zzakl zzcul() {
        return this.aYr;
    }
}
