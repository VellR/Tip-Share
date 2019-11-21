package com.google.android.gms.internal;

import com.google.android.gms.internal.zzakm.zza;

public class zzaks extends zzakj<zzaks> {
    private final String value;

    public zzaks(String str, zzakm zzakm) {
        super(zzakm);
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzaks)) {
            return false;
        }
        zzaks zzaks = (zzaks) obj;
        return this.value.equals(zzaks.value) && this.aYG.equals(zzaks.aYG);
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() + this.aYG.hashCode();
    }

    /* access modifiers changed from: protected */
    public int zza(zzaks zzaks) {
        return this.value.compareTo(zzaks.value);
    }

    public String zza(zza zza) {
        switch (zza) {
            case V1:
                String valueOf = String.valueOf(zzb(zza));
                String str = this.value;
                return new StringBuilder(String.valueOf(valueOf).length() + 7 + String.valueOf(str).length()).append(valueOf).append("string:").append(str).toString();
            case V2:
                String valueOf2 = String.valueOf(zzb(zza));
                String valueOf3 = String.valueOf(zzalo.zzru(this.value));
                return new StringBuilder(String.valueOf(valueOf2).length() + 7 + String.valueOf(valueOf3).length()).append(valueOf2).append("string:").append(valueOf3).toString();
            default:
                String valueOf4 = String.valueOf(zza);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf4).length() + 38).append("Invalid hash version for string node: ").append(valueOf4).toString());
        }
    }

    /* access modifiers changed from: protected */
    public zza zzcuo() {
        return zza.String;
    }

    /* renamed from: zzr */
    public zzaks zzf(zzakm zzakm) {
        return new zzaks(this.value, zzakm);
    }
}
