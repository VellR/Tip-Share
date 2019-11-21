package com.google.android.gms.internal;

public class zzaka implements Comparable<zzaka> {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaka.class.desiredAssertionStatus());
    private static final zzaka aYB = new zzaka("[MIN_KEY]");
    private static final zzaka aYC = new zzaka("[MAX_KEY]");
    private static final zzaka aYD = new zzaka(".priority");
    private static final zzaka aYE = new zzaka(".info");
    /* access modifiers changed from: private */
    public final String zzcb;

    private static class zza extends zzaka {
        private final int zs;

        zza(String str, int i) {
            super(str);
            this.zs = i;
        }

        public /* synthetic */ int compareTo(Object obj) {
            return zzaka.super.compareTo((zzaka) obj);
        }

        /* access modifiers changed from: protected */
        public int intValue() {
            return this.zs;
        }

        public String toString() {
            String zzj = this.zzcb;
            return new StringBuilder(String.valueOf(zzj).length() + 20).append("IntegerChildName(\"").append(zzj).append("\")").toString();
        }

        /* access modifiers changed from: protected */
        public boolean zzcuu() {
            return true;
        }
    }

    private zzaka(String str) {
        this.zzcb = str;
    }

    public static zzaka zzcup() {
        return aYB;
    }

    public static zzaka zzcuq() {
        return aYC;
    }

    public static zzaka zzcur() {
        return aYD;
    }

    public static zzaka zzcus() {
        return aYE;
    }

    public static zzaka zzrm(String str) {
        Integer zzrv = zzalo.zzrv(str);
        if (zzrv != null) {
            return new zza(str, zzrv.intValue());
        }
        if (str.equals(".priority")) {
            return aYD;
        }
        if ($assertionsDisabled || !str.contains("/")) {
            return new zzaka(str);
        }
        throw new AssertionError();
    }

    public String asString() {
        return this.zzcb;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzaka)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.zzcb.equals(((zzaka) obj).zzcb);
    }

    public int hashCode() {
        return this.zzcb.hashCode();
    }

    /* access modifiers changed from: protected */
    public int intValue() {
        return 0;
    }

    public String toString() {
        String str = this.zzcb;
        return new StringBuilder(String.valueOf(str).length() + 12).append("ChildKey(\"").append(str).append("\")").toString();
    }

    public boolean zzcut() {
        return this == aYD;
    }

    /* access modifiers changed from: protected */
    public boolean zzcuu() {
        return false;
    }

    /* renamed from: zzi */
    public int compareTo(zzaka zzaka) {
        if (this == zzaka) {
            return 0;
        }
        if (this == aYB || zzaka == aYC) {
            return -1;
        }
        if (zzaka == aYB || this == aYC) {
            return 1;
        }
        if (zzcuu()) {
            if (!zzaka.zzcuu()) {
                return -1;
            }
            int zzac = zzalo.zzac(intValue(), zzaka.intValue());
            return zzac == 0 ? zzalo.zzac(this.zzcb.length(), zzaka.zzcb.length()) : zzac;
        } else if (zzaka.zzcuu()) {
            return 1;
        } else {
            return this.zzcb.compareTo(zzaka.zzcb);
        }
    }
}
