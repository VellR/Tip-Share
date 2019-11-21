package com.google.android.gms.internal;

import com.google.android.gms.internal.zzakm.zza;
import java.util.Map;

public class zzakd extends zzakj<zzakd> {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzakd.class.desiredAssertionStatus());
    private Map<Object, Object> aYV;

    public zzakd(Map<Object, Object> map, zzakm zzakm) {
        super(zzakm);
        this.aYV = map;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzakd)) {
            return false;
        }
        zzakd zzakd = (zzakd) obj;
        return this.aYV.equals(zzakd.aYV) && this.aYG.equals(zzakd.aYG);
    }

    public Object getValue() {
        return this.aYV;
    }

    public int hashCode() {
        return this.aYV.hashCode() + this.aYG.hashCode();
    }

    /* access modifiers changed from: protected */
    public int zza(zzakd zzakd) {
        return 0;
    }

    public String zza(zza zza) {
        String valueOf = String.valueOf(zzb(zza));
        String valueOf2 = String.valueOf(this.aYV);
        return new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length()).append(valueOf).append("deferredValue:").append(valueOf2).toString();
    }

    /* access modifiers changed from: protected */
    public zza zzcuo() {
        return zza.DeferredValue;
    }

    /* renamed from: zzi */
    public zzakd zzf(zzakm zzakm) {
        if ($assertionsDisabled || zzakq.zzp(zzakm)) {
            return new zzakd(this.aYV, zzakm);
        }
        throw new AssertionError();
    }
}
