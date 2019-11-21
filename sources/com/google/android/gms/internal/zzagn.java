package com.google.android.gms.internal;

import java.util.Comparator;

public interface zzagn<K, V> {

    public enum zza {
        RED,
        BLACK
    }

    public static abstract class zzb<K, V> {
        public abstract void zzk(K k, V v);
    }

    K getKey();

    V getValue();

    boolean isEmpty();

    zzagn<K, V> zza(K k, V v, zza zza2, zzagn<K, V> zzagn, zzagn<K, V> zzagn2);

    zzagn<K, V> zza(K k, V v, Comparator<K> comparator);

    zzagn<K, V> zza(K k, Comparator<K> comparator);

    void zza(zzb<K, V> zzb2);

    boolean zzcnj();

    zzagn<K, V> zzcnl();

    zzagn<K, V> zzcnm();

    zzagn<K, V> zzcnn();

    zzagn<K, V> zzcno();

    int zzcnp();
}
