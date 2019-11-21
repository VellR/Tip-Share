package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class zzakh implements Iterable<zzakl> {
    private static final zzagk<zzakl> aYY = new zzagk<>(Collections.emptyList(), null);
    private final zzakg aXI;
    private final zzakm aYZ;
    private zzagk<zzakl> aZa;

    private zzakh(zzakm zzakm, zzakg zzakg) {
        this.aXI = zzakg;
        this.aYZ = zzakm;
        this.aZa = null;
    }

    private zzakh(zzakm zzakm, zzakg zzakg, zzagk<zzakl> zzagk) {
        this.aXI = zzakg;
        this.aYZ = zzakm;
        this.aZa = zzagk;
    }

    public static zzakh zza(zzakm zzakm, zzakg zzakg) {
        return new zzakh(zzakm, zzakg);
    }

    private void zzcvm() {
        if (this.aZa != null) {
            return;
        }
        if (this.aXI.equals(zzaki.zzcvp())) {
            this.aZa = aYY;
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (zzakl zzakl : this.aYZ) {
            z = z || this.aXI.zzl(zzakl.zzcmq());
            arrayList.add(new zzakl(zzakl.zzcvs(), zzakl.zzcmq()));
        }
        if (z) {
            this.aZa = new zzagk<>(arrayList, this.aXI);
        } else {
            this.aZa = aYY;
        }
    }

    public static zzakh zzm(zzakm zzakm) {
        return new zzakh(zzakm, zzakp.zzcvt());
    }

    public Iterator<zzakl> iterator() {
        zzcvm();
        return this.aZa == aYY ? this.aYZ.iterator() : this.aZa.iterator();
    }

    public zzaka zza(zzaka zzaka, zzakm zzakm, zzakg zzakg) {
        if (this.aXI.equals(zzaki.zzcvp()) || this.aXI.equals(zzakg)) {
            zzcvm();
            if (this.aZa == aYY) {
                return this.aYZ.zzl(zzaka);
            }
            zzakl zzakl = (zzakl) this.aZa.zzbm(new zzakl(zzaka, zzakm));
            if (zzakl != null) {
                return zzakl.zzcvs();
            }
            return null;
        }
        throw new IllegalArgumentException("Index not available in IndexedNode!");
    }

    public boolean zzb(zzakg zzakg) {
        return this.aXI.equals(zzakg);
    }

    public zzakm zzcmq() {
        return this.aYZ;
    }

    public Iterator<zzakl> zzcnd() {
        zzcvm();
        return this.aZa == aYY ? this.aYZ.zzcnd() : this.aZa.zzcnd();
    }

    public zzakl zzcvn() {
        if (!(this.aYZ instanceof zzakb)) {
            return null;
        }
        zzcvm();
        if (this.aZa != aYY) {
            return (zzakl) this.aZa.zzcng();
        }
        zzaka zzcuy = ((zzakb) this.aYZ).zzcuy();
        return new zzakl(zzcuy, this.aYZ.zzm(zzcuy));
    }

    public zzakl zzcvo() {
        if (!(this.aYZ instanceof zzakb)) {
            return null;
        }
        zzcvm();
        if (this.aZa != aYY) {
            return (zzakl) this.aZa.zzcnh();
        }
        zzaka zzcuz = ((zzakb) this.aYZ).zzcuz();
        return new zzakl(zzcuz, this.aYZ.zzm(zzcuz));
    }

    public zzakh zzh(zzaka zzaka, zzakm zzakm) {
        zzakm zze = this.aYZ.zze(zzaka, zzakm);
        if (this.aZa == aYY && !this.aXI.zzl(zzakm)) {
            return new zzakh(zze, this.aXI, aYY);
        }
        if (this.aZa == null || this.aZa == aYY) {
            return new zzakh(zze, this.aXI, null);
        }
        zzagk zzbk = this.aZa.zzbk(new zzakl(zzaka, this.aYZ.zzm(zzaka)));
        if (!zzakm.isEmpty()) {
            zzbk = zzbk.zzbl(new zzakl(zzaka, zzakm));
        }
        return new zzakh(zze, this.aXI, zzbk);
    }

    public zzakh zzn(zzakm zzakm) {
        return new zzakh(this.aYZ.zzf(zzakm), this.aXI, this.aZa);
    }
}
