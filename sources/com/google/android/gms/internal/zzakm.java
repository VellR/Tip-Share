package com.google.android.gms.internal;

import java.util.Iterator;

public interface zzakm extends Comparable<zzakm>, Iterable<zzakl> {
    public static final zzakb aZk = new zzakb() {
        public boolean equals(Object obj) {
            return obj == this;
        }

        public boolean isEmpty() {
            return false;
        }

        public String toString() {
            return "<Max Node>";
        }

        public zzakm zzcux() {
            return this;
        }

        /* renamed from: zzg */
        public int compareTo(zzakm zzakm) {
            return zzakm == this ? 0 : 1;
        }

        public boolean zzk(zzaka zzaka) {
            return false;
        }

        public zzakm zzm(zzaka zzaka) {
            return zzaka.zzcut() ? zzcux() : zzakf.zzcvi();
        }
    };

    public enum zza {
        V1,
        V2
    }

    int getChildCount();

    Object getValue();

    Object getValue(boolean z);

    boolean isEmpty();

    String zza(zza zza2);

    zzakm zzao(zzahr zzahr);

    Iterator<zzakl> zzcnd();

    String zzcuv();

    boolean zzcuw();

    zzakm zzcux();

    zzakm zze(zzaka zzaka, zzakm zzakm);

    zzakm zzf(zzakm zzakm);

    boolean zzk(zzaka zzaka);

    zzaka zzl(zzaka zzaka);

    zzakm zzl(zzahr zzahr, zzakm zzakm);

    zzakm zzm(zzaka zzaka);
}
