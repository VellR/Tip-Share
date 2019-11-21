package com.google.android.gms.internal;

import com.google.android.gms.internal.zzakm.zza;

public class zzake extends zzakj<zzake> {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzake.class.desiredAssertionStatus());
    private final Double aYW;

    public zzake(Double d, zzakm zzakm) {
        super(zzakm);
        this.aYW = d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzake)) {
            return false;
        }
        zzake zzake = (zzake) obj;
        return this.aYW.equals(zzake.aYW) && this.aYG.equals(zzake.aYG);
    }

    public Object getValue() {
        return this.aYW;
    }

    public int hashCode() {
        return this.aYW.hashCode() + this.aYG.hashCode();
    }

    /* access modifiers changed from: protected */
    public int zza(zzake zzake) {
        return this.aYW.compareTo(zzake.aYW);
    }

    public String zza(zza zza) {
        String valueOf = String.valueOf(String.valueOf(zzb(zza)).concat("number:"));
        String valueOf2 = String.valueOf(zzalo.zzm(this.aYW.doubleValue()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* access modifiers changed from: protected */
    public zza zzcuo() {
        return zza.Number;
    }

    /* renamed from: zzj */
    public zzake zzf(zzakm zzakm) {
        if ($assertionsDisabled || zzakq.zzp(zzakm)) {
            return new zzake(this.aYW, zzakm);
        }
        throw new AssertionError();
    }
}
