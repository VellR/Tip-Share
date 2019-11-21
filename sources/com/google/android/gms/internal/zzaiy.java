package com.google.android.gms.internal;

public class zzaiy {
    public final zzajm aWS;
    public final long aWT;
    public final boolean aWU;
    public final boolean aWV;
    public final long id;

    public zzaiy(long j, zzajm zzajm, long j2, boolean z, boolean z2) {
        this.id = j;
        if (!zzajm.zzctw() || zzajm.isDefault()) {
            this.aWS = zzajm;
            this.aWT = j2;
            this.aWU = z;
            this.aWV = z2;
            return;
        }
        throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        zzaiy zzaiy = (zzaiy) obj;
        return this.id == zzaiy.id && this.aWS.equals(zzaiy.aWS) && this.aWT == zzaiy.aWT && this.aWU == zzaiy.aWU && this.aWV == zzaiy.aWV;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.id).hashCode() * 31) + this.aWS.hashCode()) * 31) + Long.valueOf(this.aWT).hashCode()) * 31) + Boolean.valueOf(this.aWU).hashCode()) * 31) + Boolean.valueOf(this.aWV).hashCode();
    }

    public String toString() {
        long j = this.id;
        String valueOf = String.valueOf(this.aWS);
        long j2 = this.aWT;
        boolean z = this.aWU;
        return new StringBuilder(String.valueOf(valueOf).length() + 109).append("TrackedQuery{id=").append(j).append(", querySpec=").append(valueOf).append(", lastUse=").append(j2).append(", complete=").append(z).append(", active=").append(this.aWV).append("}").toString();
    }

    public zzaiy zzcj(long j) {
        return new zzaiy(this.id, this.aWS, j, this.aWU, this.aWV);
    }

    public zzaiy zzcss() {
        return new zzaiy(this.id, this.aWS, this.aWT, true, this.aWV);
    }

    public zzaiy zzcu(boolean z) {
        return new zzaiy(this.id, this.aWS, this.aWT, this.aWU, z);
    }
}
