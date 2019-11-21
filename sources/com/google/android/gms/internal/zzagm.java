package com.google.android.gms.internal;

import com.google.android.gms.internal.zzagn.zza;
import com.google.android.gms.internal.zzagn.zzb;
import java.util.Comparator;

public class zzagm<K, V> implements zzagn<K, V> {
    private static final zzagm aQs = new zzagm();

    private zzagm() {
    }

    public static <K, V> zzagm<K, V> zzcnk() {
        return aQs;
    }

    public K getKey() {
        return null;
    }

    public V getValue() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public zzagn<K, V> zza(K k, V v, zza zza, zzagn<K, V> zzagn, zzagn<K, V> zzagn2) {
        return this;
    }

    public zzagn<K, V> zza(K k, V v, Comparator<K> comparator) {
        return new zzago(k, v);
    }

    public zzagn<K, V> zza(K k, Comparator<K> comparator) {
        return this;
    }

    public void zza(zzb<K, V> zzb) {
    }

    public boolean zzcnj() {
        return false;
    }

    public zzagn<K, V> zzcnl() {
        return this;
    }

    public zzagn<K, V> zzcnm() {
        return this;
    }

    public zzagn<K, V> zzcnn() {
        return this;
    }

    public zzagn<K, V> zzcno() {
        return this;
    }

    public int zzcnp() {
        return 0;
    }
}
