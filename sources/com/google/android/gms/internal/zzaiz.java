package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaja.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzaiz {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaiz.class.desiredAssertionStatus());
    private static final zzajb<Map<zzajl, zzaiy>> aWW = new zzajb<Map<zzajl, zzaiy>>() {
        /* renamed from: zzbz */
        public boolean zzbr(Map<zzajl, zzaiy> map) {
            zzaiy zzaiy = (zzaiy) map.get(zzajl.aXM);
            return zzaiy != null && zzaiy.aWU;
        }
    };
    private static final zzajb<Map<zzajl, zzaiy>> aWX = new zzajb<Map<zzajl, zzaiy>>() {
        /* renamed from: zzbz */
        public boolean zzbr(Map<zzajl, zzaiy> map) {
            zzaiy zzaiy = (zzaiy) map.get(zzajl.aXM);
            return zzaiy != null && zzaiy.aWV;
        }
    };
    /* access modifiers changed from: private */
    public static final zzajb<zzaiy> aWY = new zzajb<zzaiy>() {
        /* renamed from: zzc */
        public boolean zzbr(zzaiy zzaiy) {
            return !zzaiy.aWV;
        }
    };
    private static final zzajb<zzaiy> aWZ = new zzajb<zzaiy>() {
        /* renamed from: zzc */
        public boolean zzbr(zzaiy zzaiy) {
            return !zzaiz.aWY.zzbr(zzaiy);
        }
    };
    private final zzajx aPY;
    private final zzaiw aWG;
    private zzaja<Map<zzajl, zzaiy>> aXa;
    private final zzalg aXb;
    private long aXc = 0;

    public zzaiz(zzaiw zzaiw, zzajx zzajx, zzalg zzalg) {
        this.aWG = zzaiw;
        this.aPY = zzajx;
        this.aXb = zzalg;
        this.aXa = new zzaja<>(null);
        zzcst();
        for (zzaiy zzaiy : this.aWG.zzcmy()) {
            this.aXc = Math.max(zzaiy.id + 1, this.aXc);
            zzb(zzaiy);
        }
    }

    private static long zza(zzair zzair, long j) {
        return j - Math.min((long) Math.floor((double) ((1.0f - zzair.zzcso()) * ((float) j))), zzair.zzcsp());
    }

    private List<zzaiy> zza(zzajb<zzaiy> zzajb) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.aXa.iterator();
        while (it.hasNext()) {
            for (zzaiy zzaiy : ((Map) ((Entry) it.next()).getValue()).values()) {
                if (zzajb.zzbr(zzaiy)) {
                    arrayList.add(zzaiy);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void zza(zzaiy zzaiy) {
        zzb(zzaiy);
        this.aWG.zza(zzaiy);
    }

    private boolean zzae(zzahr zzahr) {
        return this.aXa.zza(zzahr, aWW) != null;
    }

    private Set<Long> zzaf(zzahr zzahr) {
        HashSet hashSet = new HashSet();
        Map map = (Map) this.aXa.zzak(zzahr);
        if (map != null) {
            for (zzaiy zzaiy : map.values()) {
                if (!zzaiy.aWS.zzctw()) {
                    hashSet.add(Long.valueOf(zzaiy.id));
                }
            }
        }
        return hashSet;
    }

    private void zzb(zzaiy zzaiy) {
        Map map;
        zzj(zzaiy.aWS);
        Map map2 = (Map) this.aXa.zzak(zzaiy.aWS.zzcmu());
        if (map2 == null) {
            HashMap hashMap = new HashMap();
            this.aXa = this.aXa.zzb(zzaiy.aWS.zzcmu(), hashMap);
            map = hashMap;
        } else {
            map = map2;
        }
        zzaiy zzaiy2 = (zzaiy) map.get(zzaiy.aWS.zzctz());
        zzalo.zzcp(zzaiy2 == null || zzaiy2.id == zzaiy.id);
        map.put(zzaiy.aWS.zzctz(), zzaiy);
    }

    private void zzb(zzajm zzajm, boolean z) {
        zzaiy zzaiy;
        zzajm zzk = zzk(zzajm);
        zzaiy zzl = zzl(zzk);
        long zzcwq = this.aXb.zzcwq();
        if (zzl != null) {
            zzaiy = zzl.zzcj(zzcwq).zzcu(z);
        } else if ($assertionsDisabled || z) {
            long j = this.aXc;
            this.aXc = 1 + j;
            zzaiy = new zzaiy(j, zzk, zzcwq, false, z);
        } else {
            throw new AssertionError("If we're setting the query to inactive, we should already be tracking it!");
        }
        zza(zzaiy);
    }

    private void zzcst() {
        try {
            this.aWG.beginTransaction();
            this.aWG.zzbx(this.aXb.zzcwq());
            this.aWG.setTransactionSuccessful();
        } finally {
            this.aWG.endTransaction();
        }
    }

    private static void zzj(zzajm zzajm) {
        zzalo.zzb(!zzajm.zzctw() || zzajm.isDefault(), "Can't have tracked non-default query that loads all data");
    }

    private static zzajm zzk(zzajm zzajm) {
        return zzajm.zzctw() ? zzajm.zzan(zzajm.zzcmu()) : zzajm;
    }

    public zzaix zza(zzair zzair) {
        List zza = zza(aWY);
        long zza2 = zza(zzair, (long) zza.size());
        zzaix zzaix = new zzaix();
        if (this.aPY.zzcum()) {
            this.aPY.zzh("Pruning old queries.  Prunable: " + zza.size() + " Count to prune: " + zza2, new Object[0]);
        }
        Collections.sort(zza, new Comparator<zzaiy>() {
            /* renamed from: zza */
            public int compare(zzaiy zzaiy, zzaiy zzaiy2) {
                return zzalo.zzk(zzaiy.aWT, zzaiy2.aWT);
            }
        });
        for (int i = 0; ((long) i) < zza2; i++) {
            zzaiy zzaiy = (zzaiy) zza.get(i);
            zzaix = zzaix.zzy(zzaiy.aWS.zzcmu());
            zzm(zzaiy.aWS);
        }
        int i2 = (int) zza2;
        zzaix zzaix2 = zzaix;
        while (true) {
            int i3 = i2;
            if (i3 >= zza.size()) {
                break;
            }
            zzaix2 = zzaix2.zzz(((zzaiy) zza.get(i3)).aWS.zzcmu());
            i2 = i3 + 1;
        }
        List<zzaiy> zza3 = zza(aWZ);
        if (this.aPY.zzcum()) {
            this.aPY.zzh("Unprunable queries: " + zza3.size(), new Object[0]);
        }
        for (zzaiy zzaiy2 : zza3) {
            zzaix2 = zzaix2.zzz(zzaiy2.aWS.zzcmu());
        }
        return zzaix2;
    }

    public void zzaa(zzahr zzahr) {
        this.aXa.zzai(zzahr).zza(new zza<Map<zzajl, zzaiy>, Void>() {
            public Void zza(zzahr zzahr, Map<zzajl, zzaiy> map, Void voidR) {
                for (Entry value : map.entrySet()) {
                    zzaiy zzaiy = (zzaiy) value.getValue();
                    if (!zzaiy.aWU) {
                        zzaiz.this.zza(zzaiy.zzcss());
                    }
                }
                return null;
            }
        });
    }

    public Set<zzaka> zzab(zzahr zzahr) {
        if ($assertionsDisabled || !zzo(zzajm.zzan(zzahr))) {
            HashSet hashSet = new HashSet();
            Set zzaf = zzaf(zzahr);
            if (!zzaf.isEmpty()) {
                hashSet.addAll(this.aWG.zzh(zzaf));
            }
            Iterator it = this.aXa.zzai(zzahr).zzcsx().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                zzaka zzaka = (zzaka) entry.getKey();
                zzaja zzaja = (zzaja) entry.getValue();
                if (zzaja.getValue() != null && aWW.zzbr((Map) zzaja.getValue())) {
                    hashSet.add(zzaka);
                }
            }
            return hashSet;
        }
        throw new AssertionError("Path is fully complete.");
    }

    public void zzac(zzahr zzahr) {
        zzaiy zzcss;
        if (!zzae(zzahr)) {
            zzajm zzan = zzajm.zzan(zzahr);
            zzaiy zzl = zzl(zzan);
            if (zzl == null) {
                long j = this.aXc;
                this.aXc = 1 + j;
                zzcss = new zzaiy(j, zzan, this.aXb.zzcwq(), true, false);
            } else if ($assertionsDisabled || !zzl.aWU) {
                zzcss = zzl.zzcss();
            } else {
                throw new AssertionError("This should have been handled above!");
            }
            zza(zzcss);
        }
    }

    public boolean zzad(zzahr zzahr) {
        return this.aXa.zzb(zzahr, aWX) != null;
    }

    public long zzcsu() {
        return (long) zza(aWY).size();
    }

    public void zzg(zzajm zzajm) {
        zzb(zzajm, true);
    }

    public void zzh(zzajm zzajm) {
        zzb(zzajm, false);
    }

    public zzaiy zzl(zzajm zzajm) {
        zzajm zzk = zzk(zzajm);
        Map map = (Map) this.aXa.zzak(zzk.zzcmu());
        if (map != null) {
            return (zzaiy) map.get(zzk.zzctz());
        }
        return null;
    }

    public void zzm(zzajm zzajm) {
        zzajm zzk = zzk(zzajm);
        zzaiy zzl = zzl(zzk);
        if ($assertionsDisabled || zzl != null) {
            this.aWG.zzbw(zzl.id);
            Map map = (Map) this.aXa.zzak(zzk.zzcmu());
            map.remove(zzk.zzctz());
            if (map.isEmpty()) {
                this.aXa = this.aXa.zzaj(zzk.zzcmu());
                return;
            }
            return;
        }
        throw new AssertionError("Query must exist to be removed.");
    }

    public void zzn(zzajm zzajm) {
        zzaiy zzl = zzl(zzk(zzajm));
        if (zzl != null && !zzl.aWU) {
            zza(zzl.zzcss());
        }
    }

    public boolean zzo(zzajm zzajm) {
        if (zzae(zzajm.zzcmu())) {
            return true;
        }
        if (zzajm.zzctw()) {
            return false;
        }
        Map map = (Map) this.aXa.zzak(zzajm.zzcmu());
        return map != null && map.containsKey(zzajm.zzctz()) && ((zzaiy) map.get(zzajm.zzctz())).aWU;
    }
}
