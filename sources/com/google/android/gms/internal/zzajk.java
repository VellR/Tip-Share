package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzajk {
    /* access modifiers changed from: private */
    public final zzajx aPY;
    private final zzaho aTr;

    public zzajk(zzahk zzahk) {
        this.aTr = zzahk.zzcqj();
        this.aPY = zzahk.zzrh("EventRaiser");
    }

    public void zzau(List<? extends zzaji> list) {
        if (this.aPY.zzcum()) {
            this.aPY.zzh("Raising " + list.size() + " event(s)", new Object[0]);
        }
        final ArrayList arrayList = new ArrayList(list);
        this.aTr.zzp(new Runnable() {
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzaji zzaji = (zzaji) it.next();
                    if (zzajk.this.aPY.zzcum()) {
                        zzajx zza = zzajk.this.aPY;
                        String str = "Raising ";
                        String valueOf = String.valueOf(zzaji.toString());
                        zza.zzh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
                    }
                    zzaji.zzctc();
                }
            }
        });
    }
}
