package com.google.android.gms.internal;

import com.google.android.gms.internal.zzakj;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public abstract class zzakj<T extends zzakj> implements zzakm {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzakj.class.desiredAssertionStatus());
    protected final zzakm aYG;
    private String aYH;

    protected enum zza {
        DeferredValue,
        Boolean,
        Number,
        String
    }

    zzakj(zzakm zzakm) {
        this.aYG = zzakm;
    }

    private static int zza(zzakk zzakk, zzake zzake) {
        return Double.valueOf((double) ((Long) zzakk.getValue()).longValue()).compareTo((Double) zzake.getValue());
    }

    public int getChildCount() {
        return 0;
    }

    public Object getValue(boolean z) {
        if (!z || this.aYG.isEmpty()) {
            return getValue();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(".value", getValue());
        hashMap.put(".priority", this.aYG.getValue());
        return hashMap;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<zzakl> iterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        String obj = getValue(true).toString();
        return obj.length() <= 100 ? obj : String.valueOf(obj.substring(0, 100)).concat("...");
    }

    /* access modifiers changed from: protected */
    public abstract int zza(T t);

    public zzakm zzao(zzahr zzahr) {
        return zzahr.isEmpty() ? this : zzahr.zzcrb().zzcut() ? this.aYG : zzakf.zzcvi();
    }

    /* access modifiers changed from: protected */
    public String zzb(com.google.android.gms.internal.zzakm.zza zza2) {
        switch (zza2) {
            case V1:
            case V2:
                if (this.aYG.isEmpty()) {
                    return "";
                }
                String valueOf = String.valueOf(this.aYG.zza(zza2));
                return new StringBuilder(String.valueOf(valueOf).length() + 10).append("priority:").append(valueOf).append(":").toString();
            default:
                String valueOf2 = String.valueOf(zza2);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 22).append("Unknown hash version: ").append(valueOf2).toString());
        }
    }

    /* access modifiers changed from: protected */
    public int zzc(zzakj<?> zzakj) {
        zza zzcuo = zzcuo();
        zza zzcuo2 = zzakj.zzcuo();
        return zzcuo.equals(zzcuo2) ? zza(zzakj) : zzcuo.compareTo(zzcuo2);
    }

    public Iterator<zzakl> zzcnd() {
        return Collections.emptyList().iterator();
    }

    /* access modifiers changed from: protected */
    public abstract zza zzcuo();

    public String zzcuv() {
        if (this.aYH == null) {
            this.aYH = zzalo.zzrt(zza(com.google.android.gms.internal.zzakm.zza.V1));
        }
        return this.aYH;
    }

    public boolean zzcuw() {
        return true;
    }

    public zzakm zzcux() {
        return this.aYG;
    }

    public zzakm zze(zzaka zzaka, zzakm zzakm) {
        return zzaka.zzcut() ? zzf(zzakm) : !zzakm.isEmpty() ? zzakf.zzcvi().zze(zzaka, zzakm).zzf(this.aYG) : this;
    }

    /* renamed from: zzg */
    public int compareTo(zzakm zzakm) {
        if (zzakm.isEmpty()) {
            return 1;
        }
        if (zzakm instanceof zzakb) {
            return -1;
        }
        if ($assertionsDisabled || zzakm.zzcuw()) {
            return (!(this instanceof zzakk) || !(zzakm instanceof zzake)) ? (!(this instanceof zzake) || !(zzakm instanceof zzakk)) ? zzc((zzakj) zzakm) : zza((zzakk) zzakm, (zzake) this) * -1 : zza((zzakk) this, (zzake) zzakm);
        }
        throw new AssertionError("Node is not leaf node!");
    }

    public boolean zzk(zzaka zzaka) {
        return false;
    }

    public zzaka zzl(zzaka zzaka) {
        return null;
    }

    public zzakm zzl(zzahr zzahr, zzakm zzakm) {
        zzaka zzcrb = zzahr.zzcrb();
        if (zzcrb == null) {
            return zzakm;
        }
        if (zzakm.isEmpty() && !zzcrb.zzcut()) {
            return this;
        }
        if ($assertionsDisabled || !zzahr.zzcrb().zzcut() || zzahr.size() == 1) {
            return zze(zzcrb, zzakf.zzcvi().zzl(zzahr.zzcrc(), zzakm));
        }
        throw new AssertionError();
    }

    public zzakm zzm(zzaka zzaka) {
        return zzaka.zzcut() ? this.aYG : zzakf.zzcvi();
    }
}
