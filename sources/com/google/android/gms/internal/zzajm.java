package com.google.android.gms.internal;

import java.util.Map;

public class zzajm {
    private final zzajl aPC;
    private final zzahr aPz;

    public zzajm(zzahr zzahr, zzajl zzajl) {
        this.aPz = zzahr;
        this.aPC = zzajl;
    }

    public static zzajm zzan(zzahr zzahr) {
        return new zzajm(zzahr, zzajl.aXM);
    }

    public static zzajm zzb(zzahr zzahr, Map<String, Object> map) {
        return new zzajm(zzahr, zzajl.zzca(map));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzajm zzajm = (zzajm) obj;
        if (!this.aPz.equals(zzajm.aPz)) {
            return false;
        }
        return this.aPC.equals(zzajm.aPC);
    }

    public int hashCode() {
        return (this.aPz.hashCode() * 31) + this.aPC.hashCode();
    }

    public boolean isDefault() {
        return this.aPC.isDefault();
    }

    public String toString() {
        String valueOf = String.valueOf(this.aPz);
        String valueOf2 = String.valueOf(this.aPC);
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append(":").append(valueOf2).toString();
    }

    public zzahr zzcmu() {
        return this.aPz;
    }

    public zzakg zzcts() {
        return this.aPC.zzcts();
    }

    public boolean zzctw() {
        return this.aPC.zzctw();
    }

    public zzajl zzctz() {
        return this.aPC;
    }
}
