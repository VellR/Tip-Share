package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaji.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzajq {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzajq.class.desiredAssertionStatus());
    private final Map<zzaka, zzajg> aYl = new HashMap();

    public void zza(zzajg zzajg) {
        zza zzcte = zzajg.zzcte();
        zzaka zzctd = zzajg.zzctd();
        if (!$assertionsDisabled && zzcte != zza.CHILD_ADDED && zzcte != zza.CHILD_CHANGED && zzcte != zza.CHILD_REMOVED) {
            throw new AssertionError("Only child changes supported for tracking");
        } else if (!$assertionsDisabled && zzajg.zzctd().zzcut()) {
            throw new AssertionError();
        } else if (this.aYl.containsKey(zzctd)) {
            zzajg zzajg2 = (zzajg) this.aYl.get(zzctd);
            zza zzcte2 = zzajg2.zzcte();
            if (zzcte == zza.CHILD_ADDED && zzcte2 == zza.CHILD_REMOVED) {
                this.aYl.put(zzajg.zzctd(), zzajg.zza(zzctd, zzajg.zzctb(), zzajg2.zzctb()));
            } else if (zzcte == zza.CHILD_REMOVED && zzcte2 == zza.CHILD_ADDED) {
                this.aYl.remove(zzctd);
            } else if (zzcte == zza.CHILD_REMOVED && zzcte2 == zza.CHILD_CHANGED) {
                this.aYl.put(zzctd, zzajg.zzb(zzctd, zzajg2.zzctg()));
            } else if (zzcte == zza.CHILD_CHANGED && zzcte2 == zza.CHILD_ADDED) {
                this.aYl.put(zzctd, zzajg.zza(zzctd, zzajg.zzctb()));
            } else if (zzcte == zza.CHILD_CHANGED && zzcte2 == zza.CHILD_CHANGED) {
                this.aYl.put(zzctd, zzajg.zza(zzctd, zzajg.zzctb(), zzajg2.zzctg()));
            } else {
                String valueOf = String.valueOf(zzajg);
                String valueOf2 = String.valueOf(zzajg2);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 48 + String.valueOf(valueOf2).length()).append("Illegal combination of changes: ").append(valueOf).append(" occurred after ").append(valueOf2).toString());
            }
        } else {
            this.aYl.put(zzajg.zzctd(), zzajg);
        }
    }

    public List<zzajg> zzcuh() {
        return new ArrayList(this.aYl.values());
    }
}
