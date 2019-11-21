package com.google.android.gms.internal;

public class zzakl {
    private static final zzakl aZi = new zzakl(zzaka.zzcup(), zzakf.zzcvi());
    private static final zzakl aZj = new zzakl(zzaka.zzcuq(), zzakm.aZk);
    private final zzaka aXk;
    private final zzakm aYZ;

    public zzakl(zzaka zzaka, zzakm zzakm) {
        this.aXk = zzaka;
        this.aYZ = zzakm;
    }

    public static zzakl zzcvq() {
        return aZi;
    }

    public static zzakl zzcvr() {
        return aZj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzakl zzakl = (zzakl) obj;
        if (!this.aXk.equals(zzakl.aXk)) {
            return false;
        }
        return this.aYZ.equals(zzakl.aYZ);
    }

    public int hashCode() {
        return (this.aXk.hashCode() * 31) + this.aYZ.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.aXk);
        String valueOf2 = String.valueOf(this.aYZ);
        return new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append("NamedNode{name=").append(valueOf).append(", node=").append(valueOf2).append("}").toString();
    }

    public zzakm zzcmq() {
        return this.aYZ;
    }

    public zzaka zzcvs() {
        return this.aXk;
    }
}
