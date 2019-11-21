package com.google.android.gms.internal;

import java.lang.Comparable;
import java.util.Comparator;

public class zzagr<A extends Comparable<A>> implements Comparator<A> {
    private static zzagr aQJ = new zzagr();

    private zzagr() {
    }

    public static <T extends Comparable<T>> zzagr<T> zzi(Class<T> cls) {
        return aQJ;
    }

    /* renamed from: zza */
    public int compare(A a, A a2) {
        return a.compareTo(a2);
    }
}
