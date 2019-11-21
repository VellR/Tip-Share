package com.google.android.gms.internal;

public class zzaic {
    private final long aVN;

    public zzaic(long j) {
        this.aVN = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aVN == ((zzaic) obj).aVN;
    }

    public int hashCode() {
        return (int) (this.aVN ^ (this.aVN >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.aVN + "}";
    }

    public long zzcru() {
        return this.aVN;
    }
}
