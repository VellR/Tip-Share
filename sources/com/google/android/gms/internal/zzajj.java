package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaji.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class zzajj {
    private final zzajm aXH;
    /* access modifiers changed from: private */
    public final zzakg aXI;

    public zzajj(zzajm zzajm) {
        this.aXH = zzajm;
        this.aXI = zzajm.zzcts();
    }

    private zzajh zza(zzajg zzajg, zzahm zzahm, zzakh zzakh) {
        if (!zzajg.zzcte().equals(zza.VALUE) && !zzajg.zzcte().equals(zza.CHILD_REMOVED)) {
            zzajg = zzajg.zzg(zzakh.zza(zzajg.zzctd(), zzajg.zzctb().zzcmq(), this.aXI));
        }
        return zzahm.zza(zzajg, this.aXH);
    }

    private void zza(List<zzajh> list, zza zza, List<zzajg> list2, List<zzahm> list3, zzakh zzakh) {
        ArrayList<zzajg> arrayList = new ArrayList<>();
        for (zzajg zzajg : list2) {
            if (zzajg.zzcte().equals(zza)) {
                arrayList.add(zzajg);
            }
        }
        Collections.sort(arrayList, zzctj());
        for (zzajg zzajg2 : arrayList) {
            for (zzahm zzahm : list3) {
                if (zzahm.zza(zza)) {
                    list.add(zza(zzajg2, zzahm, zzakh));
                }
            }
        }
    }

    private Comparator<zzajg> zzctj() {
        return new Comparator<zzajg>() {
            static final /* synthetic */ boolean $assertionsDisabled = (!zzajj.class.desiredAssertionStatus());

            /* renamed from: zza */
            public int compare(zzajg zzajg, zzajg zzajg2) {
                if ($assertionsDisabled || !(zzajg.zzctd() == null || zzajg2.zzctd() == null)) {
                    return zzajj.this.aXI.compare(new zzakl(zzajg.zzctd(), zzajg.zzctb().zzcmq()), new zzakl(zzajg2.zzctd(), zzajg2.zzctb().zzcmq()));
                }
                throw new AssertionError();
            }
        };
    }

    public List<zzajh> zza(List<zzajg> list, zzakh zzakh, List<zzahm> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (zzajg zzajg : list) {
            if (zzajg.zzcte().equals(zza.CHILD_CHANGED) && this.aXI.zza(zzajg.zzctg().zzcmq(), zzajg.zzctb().zzcmq())) {
                arrayList2.add(zzajg.zzc(zzajg.zzctd(), zzajg.zzctb()));
            }
        }
        zza(arrayList, zza.CHILD_REMOVED, list, list2, zzakh);
        zza(arrayList, zza.CHILD_ADDED, list, list2, zzakh);
        zza(arrayList, zza.CHILD_MOVED, arrayList2, list2, zzakh);
        zza(arrayList, zza.CHILD_CHANGED, list, list2, zzakh);
        zza(arrayList, zza.VALUE, list, list2, zzakh);
        return arrayList;
    }
}
