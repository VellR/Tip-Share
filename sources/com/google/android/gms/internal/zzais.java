package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public class zzais implements zzaiv {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzais.class.desiredAssertionStatus());
    private final zzajx aPY;
    private final zzaiw aWG;
    private final zzaiz aWH;
    private final zzair aWI;
    private long aWJ;

    public zzais(zzahk zzahk, zzaiw zzaiw, zzair zzair) {
        this(zzahk, zzaiw, zzair, new zzalh());
    }

    public zzais(zzahk zzahk, zzaiw zzaiw, zzair zzair, zzalg zzalg) {
        this.aWJ = 0;
        this.aWG = zzaiw;
        this.aPY = zzahk.zzrh("Persistence");
        this.aWH = new zzaiz(this.aWG, this.aPY, zzalg);
        this.aWI = zzair;
    }

    private void zzcsq() {
        this.aWJ++;
        if (this.aWI.zzci(this.aWJ)) {
            if (this.aPY.zzcum()) {
                this.aPY.zzh("Reached prune check threshold.", new Object[0]);
            }
            this.aWJ = 0;
            boolean z = true;
            long zzcmx = this.aWG.zzcmx();
            if (this.aPY.zzcum()) {
                this.aPY.zzh("Cache size: " + zzcmx, new Object[0]);
            }
            while (z && this.aWI.zzj(zzcmx, this.aWH.zzcsu())) {
                zzaix zza = this.aWH.zza(this.aWI);
                if (zza.zzcsr()) {
                    this.aWG.zza(zzahr.zzcqy(), zza);
                } else {
                    z = false;
                }
                zzcmx = this.aWG.zzcmx();
                if (this.aPY.zzcum()) {
                    this.aPY.zzh("Cache size after prune: " + zzcmx, new Object[0]);
                }
            }
        }
    }

    public void zza(zzahr zzahr, zzahi zzahi, long j) {
        this.aWG.zza(zzahr, zzahi, j);
    }

    public void zza(zzahr zzahr, zzakm zzakm, long j) {
        this.aWG.zza(zzahr, zzakm, j);
    }

    public void zza(zzajm zzajm, zzakm zzakm) {
        if (zzajm.zzctw()) {
            this.aWG.zza(zzajm.zzcmu(), zzakm);
        } else {
            this.aWG.zzb(zzajm.zzcmu(), zzakm);
        }
        zzi(zzajm);
        zzcsq();
    }

    public void zza(zzajm zzajm, Set<zzaka> set) {
        if ($assertionsDisabled || !zzajm.zzctw()) {
            zzaiy zzl = this.aWH.zzl(zzajm);
            if ($assertionsDisabled || (zzl != null && zzl.aWV)) {
                this.aWG.zza(zzl.id, set);
                return;
            }
            throw new AssertionError("We only expect tracked keys for currently-active queries.");
        }
        throw new AssertionError("We should only track keys for filtered queries.");
    }

    public void zza(zzajm zzajm, Set<zzaka> set, Set<zzaka> set2) {
        if ($assertionsDisabled || !zzajm.zzctw()) {
            zzaiy zzl = this.aWH.zzl(zzajm);
            if ($assertionsDisabled || (zzl != null && zzl.aWV)) {
                this.aWG.zza(zzl.id, set, set2);
                return;
            }
            throw new AssertionError("We only expect tracked keys for currently-active queries.");
        }
        throw new AssertionError("We should only track keys for filtered queries.");
    }

    public void zzbv(long j) {
        this.aWG.zzbv(j);
    }

    public void zzc(zzahr zzahr, zzahi zzahi) {
        Iterator it = zzahi.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzk(zzahr.zzh((zzahr) entry.getKey()), (zzakm) entry.getValue());
        }
    }

    public List<zzaif> zzcmw() {
        return this.aWG.zzcmw();
    }

    public void zzcmz() {
        this.aWG.zzcmz();
    }

    public void zzd(zzahr zzahr, zzahi zzahi) {
        this.aWG.zza(zzahr, zzahi);
        zzcsq();
    }

    public zzaje zzf(zzajm zzajm) {
        Set<zzaka> zzab;
        boolean z;
        if (this.aWH.zzo(zzajm)) {
            zzaiy zzl = this.aWH.zzl(zzajm);
            zzab = (zzajm.zzctw() || zzl == null || !zzl.aWU) ? null : this.aWG.zzby(zzl.id);
            z = true;
        } else {
            zzab = this.aWH.zzab(zzajm.zzcmu());
            z = false;
        }
        zzakm zza = this.aWG.zza(zzajm.zzcmu());
        if (zzab == null) {
            return new zzaje(zzakh.zza(zza, zzajm.zzcts()), z, false);
        }
        zzakm zzcvi = zzakf.zzcvi();
        for (zzaka zzaka : zzab) {
            zzcvi = zzcvi.zze(zzaka, zza.zzm(zzaka));
        }
        return new zzaje(zzakh.zza(zzcvi, zzajm.zzcts()), z, true);
    }

    public <T> T zzf(Callable<T> callable) {
        this.aWG.beginTransaction();
        try {
            T call = callable.call();
            this.aWG.setTransactionSuccessful();
            this.aWG.endTransaction();
            return call;
        } catch (Throwable th) {
            this.aWG.endTransaction();
            throw th;
        }
    }

    public void zzg(zzajm zzajm) {
        this.aWH.zzg(zzajm);
    }

    public void zzh(zzajm zzajm) {
        this.aWH.zzh(zzajm);
    }

    public void zzi(zzajm zzajm) {
        if (zzajm.zzctw()) {
            this.aWH.zzaa(zzajm.zzcmu());
        } else {
            this.aWH.zzn(zzajm);
        }
    }

    public void zzk(zzahr zzahr, zzakm zzakm) {
        if (!this.aWH.zzad(zzahr)) {
            this.aWG.zza(zzahr, zzakm);
            this.aWH.zzac(zzahr);
        }
    }
}
