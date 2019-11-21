package com.google.android.gms.internal;

import com.google.android.gms.internal.zzajn.zza;
import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzaia {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaia.class.desiredAssertionStatus());
    private final Map<zzajl, zzajn> aVl = new HashMap();
    private final zzaiv aVm;

    public zzaia(zzaiv zzaiv) {
        this.aVm = zzaiv;
    }

    private List<zzajh> zza(zzajn zzajn, zzaio zzaio, zzaij zzaij, zzakm zzakm) {
        zza zzb = zzajn.zzb(zzaio, zzaij, zzakm);
        if (!zzajn.zzcua().zzctw()) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (zzajg zzajg : zzb.aYd) {
                zzaji.zza zzcte = zzajg.zzcte();
                if (zzcte == zzaji.zza.CHILD_ADDED) {
                    hashSet2.add(zzajg.zzctd());
                } else if (zzcte == zzaji.zza.CHILD_REMOVED) {
                    hashSet.add(zzajg.zzctd());
                }
            }
            if (!hashSet2.isEmpty() || !hashSet.isEmpty()) {
                this.aVm.zza(zzajn.zzcua(), (Set<zzaka>) hashSet2, (Set<zzaka>) hashSet);
            }
        }
        return zzb.aYc;
    }

    public boolean isEmpty() {
        return this.aVl.isEmpty();
    }

    public zzall<List<zzajm>, List<zzaji>> zza(zzajm zzajm, zzahm zzahm, DatabaseError databaseError) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean zzcrq = zzcrq();
        if (zzajm.isDefault()) {
            Iterator it = this.aVl.entrySet().iterator();
            while (it.hasNext()) {
                zzajn zzajn = (zzajn) ((Entry) it.next()).getValue();
                arrayList2.addAll(zzajn.zza(zzahm, databaseError));
                if (zzajn.isEmpty()) {
                    it.remove();
                    if (!zzajn.zzcua().zzctw()) {
                        arrayList.add(zzajn.zzcua());
                    }
                }
            }
        } else {
            zzajn zzajn2 = (zzajn) this.aVl.get(zzajm.zzctz());
            if (zzajn2 != null) {
                arrayList2.addAll(zzajn2.zza(zzahm, databaseError));
                if (zzajn2.isEmpty()) {
                    this.aVl.remove(zzajm.zzctz());
                    if (!zzajn2.zzcua().zzctw()) {
                        arrayList.add(zzajn2.zzcua());
                    }
                }
            }
        }
        if (zzcrq && !zzcrq()) {
            arrayList.add(zzajm.zzan(zzajm.zzcmu()));
        }
        return new zzall<>(arrayList, arrayList2);
    }

    public List<zzajh> zza(zzahm zzahm, zzaij zzaij, zzaje zzaje) {
        boolean z;
        zzajm zzcpu = zzahm.zzcpu();
        zzajn zzajn = (zzajn) this.aVl.get(zzcpu.zzctz());
        if (zzajn == null) {
            zzakm zzc = zzaij.zzc(zzaje.zzcsz() ? zzaje.zzcmq() : null);
            if (zzc != null) {
                z = true;
            } else {
                zzc = zzaij.zzd(zzaje.zzcmq());
                z = false;
            }
            zzajn zzajn2 = new zzajn(zzcpu, new zzajo(new zzaje(zzakh.zza(zzc, zzcpu.zzcts()), z, false), zzaje));
            if (!zzcpu.zzctw()) {
                HashSet hashSet = new HashSet();
                for (zzakl zzcvs : zzajn2.zzcuc()) {
                    hashSet.add(zzcvs.zzcvs());
                }
                this.aVm.zza(zzcpu, (Set<zzaka>) hashSet);
            }
            this.aVl.put(zzcpu.zzctz(), zzajn2);
            zzajn = zzajn2;
        }
        zzajn.zzb(zzahm);
        return zzajn.zzl(zzahm);
    }

    public List<zzajh> zza(zzaio zzaio, zzaij zzaij, zzakm zzakm) {
        zzajl zzcsm = zzaio.zzcsh().zzcsm();
        if (zzcsm != null) {
            zzajn zzajn = (zzajn) this.aVl.get(zzcsm);
            if ($assertionsDisabled || zzajn != null) {
                return zza(zzajn, zzaio, zzaij, zzakm);
            }
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        for (Entry value : this.aVl.entrySet()) {
            arrayList.addAll(zza((zzajn) value.getValue(), zzaio, zzaij, zzakm));
        }
        return arrayList;
    }

    public zzajn zzb(zzajm zzajm) {
        return zzajm.zzctw() ? zzcrr() : (zzajn) this.aVl.get(zzajm.zzctz());
    }

    public boolean zzc(zzajm zzajm) {
        return zzb(zzajm) != null;
    }

    public List<zzajn> zzcrp() {
        ArrayList arrayList = new ArrayList();
        for (Entry value : this.aVl.entrySet()) {
            zzajn zzajn = (zzajn) value.getValue();
            if (!zzajn.zzcua().zzctw()) {
                arrayList.add(zzajn);
            }
        }
        return arrayList;
    }

    public boolean zzcrq() {
        return zzcrr() != null;
    }

    public zzajn zzcrr() {
        for (Entry value : this.aVl.entrySet()) {
            zzajn zzajn = (zzajn) value.getValue();
            if (zzajn.zzcua().zzctw()) {
                return zzajn;
            }
        }
        return null;
    }

    public zzakm zzs(zzahr zzahr) {
        for (zzajn zzajn : this.aVl.values()) {
            if (zzajn.zzs(zzahr) != null) {
                return zzajn.zzs(zzahr);
            }
        }
        return null;
    }
}
