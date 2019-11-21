package com.google.android.gms.internal;

public class zzaif {
    private final zzahr aPz;
    private final long aVT;
    private final zzakm aVU;
    private final zzahi aVV;
    private final boolean aVW;

    public zzaif(long j, zzahr zzahr, zzahi zzahi) {
        this.aVT = j;
        this.aPz = zzahr;
        this.aVU = null;
        this.aVV = zzahi;
        this.aVW = true;
    }

    public zzaif(long j, zzahr zzahr, zzakm zzakm, boolean z) {
        this.aVT = j;
        this.aPz = zzahr;
        this.aVU = zzakm;
        this.aVV = null;
        this.aVW = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzaif zzaif = (zzaif) obj;
        if (this.aVT != zzaif.aVT) {
            return false;
        }
        if (!this.aPz.equals(zzaif.aPz)) {
            return false;
        }
        if (this.aVW != zzaif.aVW) {
            return false;
        }
        if (this.aVU == null ? zzaif.aVU != null : !this.aVU.equals(zzaif.aVU)) {
            return false;
        }
        if (this.aVV != null) {
            if (this.aVV.equals(zzaif.aVV)) {
                return true;
            }
        } else if (zzaif.aVV == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.aVU != null ? this.aVU.hashCode() : 0) + (((((Long.valueOf(this.aVT).hashCode() * 31) + Boolean.valueOf(this.aVW).hashCode()) * 31) + this.aPz.hashCode()) * 31)) * 31;
        if (this.aVV != null) {
            i = this.aVV.hashCode();
        }
        return hashCode + i;
    }

    public boolean isVisible() {
        return this.aVW;
    }

    public String toString() {
        long j = this.aVT;
        String valueOf = String.valueOf(this.aPz);
        boolean z = this.aVW;
        String valueOf2 = String.valueOf(this.aVU);
        String valueOf3 = String.valueOf(this.aVV);
        return new StringBuilder(String.valueOf(valueOf).length() + 78 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("UserWriteRecord{id=").append(j).append(" path=").append(valueOf).append(" visible=").append(z).append(" overwrite=").append(valueOf2).append(" merge=").append(valueOf3).append("}").toString();
    }

    public zzahr zzcmu() {
        return this.aPz;
    }

    public long zzcrv() {
        return this.aVT;
    }

    public zzakm zzcrw() {
        if (this.aVU != null) {
            return this.aVU;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public zzahi zzcrx() {
        if (this.aVV != null) {
            return this.aVV;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public boolean zzcry() {
        return this.aVU != null;
    }
}
