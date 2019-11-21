package com.google.android.gms.internal;

import com.google.android.gms.internal.zzakm.zza;

public class zzajz extends zzakj<zzajz> {
    private final boolean value;

    public zzajz(Boolean bool, zzakm zzakm) {
        super(zzakm);
        this.value = bool.booleanValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzajz)) {
            return false;
        }
        zzajz zzajz = (zzajz) obj;
        return this.value == zzajz.value && this.aYG.equals(zzajz.aYG);
    }

    public Object getValue() {
        return Boolean.valueOf(this.value);
    }

    public int hashCode() {
        return (this.value ? 1 : 0) + this.aYG.hashCode();
    }

    /* access modifiers changed from: protected */
    public int zza(zzajz zzajz) {
        if (this.value == zzajz.value) {
            return 0;
        }
        return this.value ? 1 : -1;
    }

    public String zza(zza zza) {
        String valueOf = String.valueOf(zzb(zza));
        return new StringBuilder(String.valueOf(valueOf).length() + 13).append(valueOf).append("boolean:").append(this.value).toString();
    }

    /* access modifiers changed from: protected */
    public zza zzcuo() {
        return zza.Boolean;
    }

    /* renamed from: zze */
    public zzajz zzf(zzakm zzakm) {
        return new zzajz(Boolean.valueOf(this.value), zzakm);
    }
}
