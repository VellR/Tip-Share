package com.google.android.gms.internal;

import com.google.android.gms.internal.zzagi.zza.C0028zza;
import com.google.android.gms.internal.zzagn.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzagq<K, V> extends zzagi<K, V> {
    private zzagn<K, V> aQA;
    private Comparator<K> aQi;

    private static class zza<A, B, C> {
        private final List<A> aQB;
        private final C0028zza<A, B> aQC;
        private zzagp<A, C> aQD;
        private zzagp<A, C> aQE;
        private final Map<B, C> values;

        /* renamed from: com.google.android.gms.internal.zzagq$zza$zza reason: collision with other inner class name */
        static class C0029zza implements Iterable<zzb> {
            /* access modifiers changed from: private */
            public final int length;
            /* access modifiers changed from: private */
            public long value;

            public C0029zza(int i) {
                int i2 = i + 1;
                this.length = (int) Math.floor(Math.log((double) i2) / Math.log(2.0d));
                this.value = ((long) i2) & (((long) Math.pow(2.0d, (double) this.length)) - 1);
            }

            public Iterator<zzb> iterator() {
                return new Iterator<zzb>() {
                    private int aQF = (C0029zza.this.length - 1);

                    public boolean hasNext() {
                        return this.aQF >= 0;
                    }

                    public void remove() {
                    }

                    /* renamed from: zzcnx */
                    public zzb next() {
                        boolean z = true;
                        long zzb = C0029zza.this.value & ((long) (1 << this.aQF));
                        zzb zzb2 = new zzb();
                        if (zzb != 0) {
                            z = false;
                        }
                        zzb2.aQH = z;
                        zzb2.aQI = (int) Math.pow(2.0d, (double) this.aQF);
                        this.aQF--;
                        return zzb2;
                    }
                };
            }
        }

        static class zzb {
            public boolean aQH;
            public int aQI;

            zzb() {
            }
        }

        private zza(List<A> list, Map<B, C> map, C0028zza<A, B> zza) {
            this.aQB = list;
            this.values = map;
            this.aQC = zza;
        }

        private void zza(com.google.android.gms.internal.zzagn.zza zza, int i, int i2) {
            zzagn zzaa = zzaa(i2 + 1, i - 1);
            Object obj = this.aQB.get(i2);
            zzagp<A, C> zzagl = zza == com.google.android.gms.internal.zzagn.zza.RED ? new zzago<>(obj, zzbo(obj), null, zzaa) : new zzagl<>(obj, zzbo(obj), null, zzaa);
            if (this.aQD == null) {
                this.aQD = zzagl;
                this.aQE = zzagl;
                return;
            }
            this.aQE.zzb(zzagl);
            this.aQE = zzagl;
        }

        private zzagn<A, C> zzaa(int i, int i2) {
            if (i2 == 0) {
                return zzagm.zzcnk();
            }
            if (i2 == 1) {
                Object obj = this.aQB.get(i);
                return new zzagl(obj, zzbo(obj), null, null);
            }
            int i3 = i2 / 2;
            int i4 = i + i3;
            zzagn zzaa = zzaa(i, i3);
            zzagn zzaa2 = zzaa(i4 + 1, i3);
            Object obj2 = this.aQB.get(i4);
            return new zzagl(obj2, zzbo(obj2), zzaa, zzaa2);
        }

        private C zzbo(A a) {
            return this.values.get(this.aQC.zzbj(a));
        }

        public static <A, B, C> zzagq<A, C> zzc(List<A> list, Map<B, C> map, C0028zza<A, B> zza, Comparator<A> comparator) {
            zza zza2 = new zza(list, map, zza);
            Collections.sort(list, comparator);
            Iterator it = new C0029zza(list.size()).iterator();
            int size = list.size();
            while (true) {
                int i = size;
                if (!it.hasNext()) {
                    break;
                }
                zzb zzb2 = (zzb) it.next();
                int i2 = i - zzb2.aQI;
                if (zzb2.aQH) {
                    zza2.zza(com.google.android.gms.internal.zzagn.zza.BLACK, zzb2.aQI, i2);
                } else {
                    zza2.zza(com.google.android.gms.internal.zzagn.zza.BLACK, zzb2.aQI, i2);
                    i2 -= zzb2.aQI;
                    zza2.zza(com.google.android.gms.internal.zzagn.zza.RED, zzb2.aQI, i2);
                }
                size = i2;
            }
            return new zzagq<>(zza2.aQD == null ? zzagm.zzcnk() : zza2.aQD, comparator);
        }
    }

    private zzagq(zzagn<K, V> zzagn, Comparator<K> comparator) {
        this.aQA = zzagn;
        this.aQi = comparator;
    }

    private zzagn<K, V> zzbn(K k) {
        zzagn<K, V> zzagn = this.aQA;
        while (!zzagn.isEmpty()) {
            int compare = this.aQi.compare(k, zzagn.getKey());
            if (compare < 0) {
                zzagn = zzagn.zzcnl();
            } else if (compare == 0) {
                return zzagn;
            } else {
                zzagn = zzagn.zzcnm();
            }
        }
        return null;
    }

    public static <A, B, C> zzagq<A, C> zzc(List<A> list, Map<B, C> map, C0028zza<A, B> zza2, Comparator<A> comparator) {
        return zza.zzc(list, map, zza2, comparator);
    }

    public static <A, B> zzagq<A, B> zzc(Map<A, B> map, Comparator<A> comparator) {
        return zza.zzc(new ArrayList(map.keySet()), map, com.google.android.gms.internal.zzagi.zza.zzcnf(), comparator);
    }

    public boolean containsKey(K k) {
        return zzbn(k) != null;
    }

    public V get(K k) {
        zzagn zzbn = zzbn(k);
        if (zzbn != null) {
            return zzbn.getValue();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.aQA.isEmpty();
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzagj(this.aQA, null, this.aQi, false);
    }

    public int size() {
        return this.aQA.zzcnp();
    }

    public void zza(zzb<K, V> zzb) {
        this.aQA.zza(zzb);
    }

    public zzagi<K, V> zzbf(K k) {
        return !containsKey(k) ? this : new zzagq(this.aQA.zza(k, this.aQi).zza(null, null, com.google.android.gms.internal.zzagn.zza.BLACK, null, null), this.aQi);
    }

    public K zzbg(K k) {
        zzagn<K, V> zzagn = this.aQA;
        zzagn<K, V> zzagn2 = null;
        while (!zzagn.isEmpty()) {
            int compare = this.aQi.compare(k, zzagn.getKey());
            if (compare == 0) {
                if (!zzagn.zzcnl().isEmpty()) {
                    zzagn zzcnl = zzagn.zzcnl();
                    while (!zzcnl.zzcnm().isEmpty()) {
                        zzcnl = zzcnl.zzcnm();
                    }
                    return zzcnl.getKey();
                } else if (zzagn2 != null) {
                    return zzagn2.getKey();
                } else {
                    return null;
                }
            } else if (compare < 0) {
                zzagn = zzagn.zzcnl();
            } else {
                zzagn<K, V> zzagn3 = zzagn;
                zzagn = zzagn.zzcnm();
                zzagn2 = zzagn3;
            }
        }
        String valueOf = String.valueOf(k);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Couldn't find predecessor key of non-present key: ").append(valueOf).toString());
    }

    public K zzcnb() {
        return this.aQA.zzcnn().getKey();
    }

    public K zzcnc() {
        return this.aQA.zzcno().getKey();
    }

    public Iterator<Entry<K, V>> zzcnd() {
        return new zzagj(this.aQA, null, this.aQi, true);
    }

    public Comparator<K> zzcne() {
        return this.aQi;
    }

    public zzagi<K, V> zzj(K k, V v) {
        return new zzagq(this.aQA.zza(k, v, this.aQi).zza(null, null, com.google.android.gms.internal.zzagn.zza.BLACK, null, null), this.aQi);
    }
}
