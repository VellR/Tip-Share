package com.google.android.gms.internal;

import com.google.android.gms.internal.zzakm.zza;

public class zzakk extends zzakj<zzakk> {
    private final long value;

    public zzakk(Long l, zzakm zzakm) {
        super(zzakm);
        this.value = l.longValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzakk)) {
            return false;
        }
        zzakk zzakk = (zzakk) obj;
        return this.value == zzakk.value && this.aYG.equals(zzakk.aYG);
    }

    public Object getValue() {
        return Long.valueOf(this.value);
    }

    public int hashCode() {
        return ((int) (this.value ^ (this.value >>> 32))) + this.aYG.hashCode();
    }

    /* access modifiers changed from: protected */
    public int zza(zzakk zzakk) {
        return zzalo.zzk(this.value, zzakk.value);
    }

    public String zza(zza zza) {
        String valueOf = String.valueOf(String.valueOf(zzb(zza)).concat("number:"));
        String valueOf2 = String.valueOf(zzalo.zzm((double) this.value));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* access modifiers changed from: protected */
    public zza zzcuo() {
        return zza.Number;
    }

    /* renamed from: zzo */
    public zzakk zzf(zzakm zzakm) {
        return new zzakk(Long.valueOf(this.value), zzakm);
    }
}
