package com.google.android.gms.internal;

import com.google.android.gms.internal.zzagi.zza;
import com.google.android.gms.internal.zzagi.zza.C0028zza;
import com.google.android.gms.internal.zzagn.zzb;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzagh<K, V> extends zzagi<K, V> {
    /* access modifiers changed from: private */
    public final K[] aQg;
    /* access modifiers changed from: private */
    public final V[] aQh;
    private final Comparator<K> aQi;

    public zzagh(Comparator<K> comparator) {
        this.aQg = new Object[0];
        this.aQh = new Object[0];
        this.aQi = comparator;
    }

    private zzagh(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.aQg = kArr;
        this.aQh = vArr;
        this.aQi = comparator;
    }

    public static <A, B, C> zzagh<A, C> zza(List<A> list, Map<B, C> map, C0028zza<A, B> zza, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i = 0;
        for (Object next : list) {
            objArr[i] = next;
            objArr2[i] = map.get(zza.zzbj(next));
            i++;
        }
        return new zzagh<>(comparator, objArr, objArr2);
    }

    public static <K, V> zzagh<K, V> zza(Map<K, V> map, Comparator<K> comparator) {
        return zza(new ArrayList(map.keySet()), map, zza.zzcnf(), comparator);
    }

    private static <T> T[] zza(T[] tArr, int i) {
        int length = tArr.length - 1;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        System.arraycopy(tArr, i + 1, tArr2, i, length - i);
        return tArr2;
    }

    private static <T> T[] zza(T[] tArr, int i, T t) {
        int length = tArr.length + 1;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        tArr2[i] = t;
        System.arraycopy(tArr, i, tArr2, i + 1, (length - i) - 1);
        return tArr2;
    }

    private static <T> T[] zzb(T[] tArr, int i, T t) {
        int length = tArr.length;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i] = t;
        return tArr2;
    }

    private int zzbh(K k) {
        int i = 0;
        while (i < this.aQg.length && this.aQi.compare(this.aQg[i], k) < 0) {
            i++;
        }
        return i;
    }

    private int zzbi(K k) {
        int i = 0;
        K[] kArr = this.aQg;
        int length = kArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (this.aQi.compare(k, kArr[i2]) == 0) {
                return i;
            }
            i2++;
            i++;
        }
        return -1;
    }

    private Iterator<Entry<K, V>> zzh(final int i, final boolean z) {
        return new Iterator<Entry<K, V>>() {
            int aQj = i;

            public boolean hasNext() {
                return z ? this.aQj >= 0 : this.aQj < zzagh.this.aQg.length;
            }

            public Entry<K, V> next() {
                Object obj = zzagh.this.aQg[this.aQj];
                Object obj2 = zzagh.this.aQh[this.aQj];
                this.aQj = z ? this.aQj - 1 : this.aQj + 1;
                return new SimpleImmutableEntry(obj, obj2);
            }

            public void remove() {
                throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
            }
        };
    }

    public boolean containsKey(K k) {
        return zzbi(k) != -1;
    }

    public V get(K k) {
        int zzbi = zzbi(k);
        if (zzbi != -1) {
            return this.aQh[zzbi];
        }
        return null;
    }

    public boolean isEmpty() {
        return this.aQg.length == 0;
    }

    public Iterator<Entry<K, V>> iterator() {
        return zzh(0, false);
    }

    public int size() {
        return this.aQg.length;
    }

    public void zza(zzb<K, V> zzb) {
        for (int i = 0; i < this.aQg.length; i++) {
            zzb.zzk(this.aQg[i], this.aQh[i]);
        }
    }

    public zzagi<K, V> zzbf(K k) {
        int zzbi = zzbi(k);
        if (zzbi == -1) {
            return this;
        }
        return new zzagh(this.aQi, zza((T[]) this.aQg, zzbi), zza((T[]) this.aQh, zzbi));
    }

    public K zzbg(K k) {
        int zzbi = zzbi(k);
        if (zzbi == -1) {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        } else if (zzbi > 0) {
            return this.aQg[zzbi - 1];
        } else {
            return null;
        }
    }

    public K zzcnb() {
        if (this.aQg.length > 0) {
            return this.aQg[0];
        }
        return null;
    }

    public K zzcnc() {
        if (this.aQg.length > 0) {
            return this.aQg[this.aQg.length - 1];
        }
        return null;
    }

    public Iterator<Entry<K, V>> zzcnd() {
        return zzh(this.aQg.length - 1, true);
    }

    public Comparator<K> zzcne() {
        return this.aQi;
    }

    public zzagi<K, V> zzj(K k, V v) {
        int zzbi = zzbi(k);
        if (zzbi != -1) {
            if (this.aQg[zzbi] == k && this.aQh[zzbi] == v) {
                return this;
            }
            return new zzagh(this.aQi, zzb(this.aQg, zzbi, k), zzb(this.aQh, zzbi, v));
        } else if (this.aQg.length > 25) {
            HashMap hashMap = new HashMap(this.aQg.length + 1);
            for (int i = 0; i < this.aQg.length; i++) {
                hashMap.put(this.aQg[i], this.aQh[i]);
            }
            hashMap.put(k, v);
            return zzagq.zzc(hashMap, this.aQi);
        } else {
            int zzbh = zzbh(k);
            return new zzagh(this.aQi, zza(this.aQg, zzbh, k), zza(this.aQh, zzbh, v));
        }
    }
}
