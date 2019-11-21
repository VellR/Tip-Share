package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zzajn {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzajn.class.desiredAssertionStatus());
    private final zzajm aXH;
    private final zzajp aXY;
    private zzajo aXZ;
    private final List<zzahm> aYa = new ArrayList();
    private final zzajj aYb;

    public static class zza {
        public final List<zzajh> aYc;
        public final List<zzajg> aYd;

        public zza(List<zzajh> list, List<zzajg> list2) {
            this.aYc = list;
            this.aYd = list2;
        }
    }

    public zzajn(zzajm zzajm, zzajo zzajo) {
        this.aXH = zzajm;
        zzajr zzajr = new zzajr(zzajm.zzcts());
        zzajt zzcty = zzajm.zzctz().zzcty();
        this.aXY = new zzajp(zzcty);
        zzaje zzcuf = zzajo.zzcuf();
        zzaje zzcud = zzajo.zzcud();
        zzakh zza2 = zzakh.zza(zzakf.zzcvi(), zzajm.zzcts());
        zzakh zza3 = zzajr.zza(zza2, zzcuf.zzctb(), null);
        zzakh zza4 = zzcty.zza(zza2, zzcud.zzctb(), null);
        this.aXZ = new zzajo(new zzaje(zza4, zzcud.zzcsz(), zzcty.zzcuj()), new zzaje(zza3, zzcuf.zzcsz(), zzajr.zzcuj()));
        this.aYb = new zzajj(zzajm);
    }

    private List<zzajh> zza(List<zzajg> list, zzakh zzakh, zzahm zzahm) {
        List<zzahm> asList;
        if (zzahm == null) {
            asList = this.aYa;
        } else {
            asList = Arrays.asList(new zzahm[]{zzahm});
        }
        return this.aYb.zza(list, zzakh, asList);
    }

    public boolean isEmpty() {
        return this.aYa.isEmpty();
    }

    public List<zzaji> zza(zzahm zzahm, DatabaseError databaseError) {
        List emptyList;
        if (databaseError != null) {
            ArrayList arrayList = new ArrayList();
            if ($assertionsDisabled || zzahm == null) {
                zzahr zzcmu = this.aXH.zzcmu();
                for (zzahm zzajf : this.aYa) {
                    arrayList.add(new zzajf(zzajf, databaseError, zzcmu));
                }
                emptyList = arrayList;
            } else {
                throw new AssertionError("A cancel should cancel all event registrations");
            }
        } else {
            emptyList = Collections.emptyList();
        }
        if (zzahm != null) {
            int i = 0;
            int i2 = -1;
            while (true) {
                if (i >= this.aYa.size()) {
                    i = i2;
                    break;
                }
                zzahm zzahm2 = (zzahm) this.aYa.get(i);
                if (zzahm2.zzc(zzahm)) {
                    if (zzahm2.zzcqu()) {
                        break;
                    }
                    i2 = i;
                }
                i++;
            }
            if (i != -1) {
                zzahm zzahm3 = (zzahm) this.aYa.get(i);
                this.aYa.remove(i);
                zzahm3.zzcqt();
            }
        } else {
            for (zzahm zzcqt : this.aYa) {
                zzcqt.zzcqt();
            }
            this.aYa.clear();
        }
        return emptyList;
    }

    public zza zzb(zzaio zzaio, zzaij zzaij, zzakm zzakm) {
        if (zzaio.zzcsi() == com.google.android.gms.internal.zzaio.zza.Merge && zzaio.zzcsh().zzcsm() != null) {
            if (!$assertionsDisabled && this.aXZ.zzcug() == null) {
                throw new AssertionError("We should always have a full cache before handling merges");
            } else if (!$assertionsDisabled && this.aXZ.zzcue() == null) {
                throw new AssertionError("Missing event cache, even though we have a server cache");
            }
        }
        zzajo zzajo = this.aXZ;
        com.google.android.gms.internal.zzajp.zza zza2 = this.aXY.zza(zzajo, zzaio, zzaij, zzakm);
        if ($assertionsDisabled || zza2.aXZ.zzcuf().zzcsz() || !zzajo.zzcuf().zzcsz()) {
            this.aXZ = zza2.aXZ;
            return new zza(zza(zza2.aYd, zza2.aXZ.zzcud().zzctb(), null), zza2.aYd);
        }
        throw new AssertionError("Once a server snap is complete, it should never go back");
    }

    public void zzb(zzahm zzahm) {
        this.aYa.add(zzahm);
    }

    public zzajm zzcua() {
        return this.aXH;
    }

    public zzakm zzcub() {
        return this.aXZ.zzcuf().zzcmq();
    }

    public zzakm zzcuc() {
        return this.aXZ.zzcud().zzcmq();
    }

    public List<zzajh> zzl(zzahm zzahm) {
        zzaje zzcud = this.aXZ.zzcud();
        ArrayList arrayList = new ArrayList();
        for (zzakl zzakl : zzcud.zzcmq()) {
            arrayList.add(zzajg.zzc(zzakl.zzcvs(), zzakl.zzcmq()));
        }
        if (zzcud.zzcsz()) {
            arrayList.add(zzajg.zza(zzcud.zzctb()));
        }
        return zza(arrayList, zzcud.zzctb(), zzahm);
    }

    public zzakm zzs(zzahr zzahr) {
        zzakm zzcug = this.aXZ.zzcug();
        if (zzcug == null || (!this.aXH.zzctw() && (zzahr.isEmpty() || zzcug.zzm(zzahr.zzcrb()).isEmpty()))) {
            return null;
        }
        return zzcug.zzao(zzahr);
    }
}
