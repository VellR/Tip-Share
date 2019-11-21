package com.google.android.gms.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class zzanw<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzanw.class.desiredAssertionStatus());
    private static final Comparator<Comparable> bfg = new Comparator<Comparable>() {
        /* renamed from: zza */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> aQi;
    zzd<K, V> bfh;
    final zzd<K, V> bfi;
    private zza bfj;
    private zzb bfk;
    int modCount;
    int size;

    class zza extends AbstractSet<Entry<K, V>> {
        zza() {
        }

        public void clear() {
            zzanw.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Entry) && zzanw.this.zzc((Entry) obj) != null;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new zzc<Entry<K, V>>() {
                {
                    zzanw zzanw = zzanw.this;
                }

                public Entry<K, V> next() {
                    return c();
                }
            };
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            zzd zzc = zzanw.this.zzc((Entry) obj);
            if (zzc == null) {
                return false;
            }
            zzanw.this.zza(zzc, true);
            return true;
        }

        public int size() {
            return zzanw.this.size;
        }
    }

    final class zzb extends AbstractSet<K> {
        zzb() {
        }

        public void clear() {
            zzanw.this.clear();
        }

        public boolean contains(Object obj) {
            return zzanw.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new zzc<K>() {
                {
                    zzanw zzanw = zzanw.this;
                }

                public K next() {
                    return c().aQw;
                }
            };
        }

        public boolean remove(Object obj) {
            return zzanw.this.zzcp(obj) != null;
        }

        public int size() {
            return zzanw.this.size;
        }
    }

    private abstract class zzc<T> implements Iterator<T> {
        zzd<K, V> bfo;
        zzd<K, V> bfp;
        int bfq;

        private zzc() {
            this.bfo = zzanw.this.bfi.bfo;
            this.bfp = null;
            this.bfq = zzanw.this.modCount;
        }

        /* access modifiers changed from: 0000 */
        public final zzd<K, V> c() {
            zzd<K, V> zzd = this.bfo;
            if (zzd == zzanw.this.bfi) {
                throw new NoSuchElementException();
            } else if (zzanw.this.modCount != this.bfq) {
                throw new ConcurrentModificationException();
            } else {
                this.bfo = zzd.bfo;
                this.bfp = zzd;
                return zzd;
            }
        }

        public final boolean hasNext() {
            return this.bfo != zzanw.this.bfi;
        }

        public final void remove() {
            if (this.bfp == null) {
                throw new IllegalStateException();
            }
            zzanw.this.zza(this.bfp, true);
            this.bfp = null;
            this.bfq = zzanw.this.modCount;
        }
    }

    static final class zzd<K, V> implements Entry<K, V> {
        final K aQw;
        V aQx;
        zzd<K, V> bfo;
        zzd<K, V> bfr;
        zzd<K, V> bfs;
        zzd<K, V> bft;
        zzd<K, V> bfu;
        int height;

        zzd() {
            this.aQw = null;
            this.bfu = this;
            this.bfo = this;
        }

        zzd(zzd<K, V> zzd, K k, zzd<K, V> zzd2, zzd<K, V> zzd3) {
            this.bfr = zzd;
            this.aQw = k;
            this.height = 1;
            this.bfo = zzd2;
            this.bfu = zzd3;
            zzd3.bfo = this;
            zzd2.bfu = this;
        }

        public zzd<K, V> d() {
            for (zzd<K, V> zzd = this.bfs; zzd != null; zzd = zzd.bfs) {
                this = zzd;
            }
            return this;
        }

        public zzd<K, V> e() {
            for (zzd<K, V> zzd = this.bft; zzd != null; zzd = zzd.bft) {
                this = zzd;
            }
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.aQw == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.aQw.equals(entry.getKey())) {
                return false;
            }
            if (this.aQx == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.aQx.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.aQw;
        }

        public V getValue() {
            return this.aQx;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.aQw == null ? 0 : this.aQw.hashCode();
            if (this.aQx != null) {
                i = this.aQx.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            V v2 = this.aQx;
            this.aQx = v;
            return v2;
        }

        public String toString() {
            String valueOf = String.valueOf(this.aQw);
            String valueOf2 = String.valueOf(this.aQx);
            return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
        }
    }

    public zzanw() {
        this(bfg);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Comparator<? super K>, code=java.util.Comparator, for r2v0, types: [java.util.Comparator<? super K>, java.util.Comparator] */
    public zzanw(Comparator comparator) {
        this.size = 0;
        this.modCount = 0;
        this.bfi = new zzd<>();
        if (comparator == null) {
            comparator = bfg;
        }
        this.aQi = comparator;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void zza(zzd<K, V> zzd2) {
        int i = 0;
        zzd<K, V> zzd3 = zzd2.bfs;
        zzd<K, V> zzd4 = zzd2.bft;
        zzd<K, V> zzd5 = zzd4.bfs;
        zzd<K, V> zzd6 = zzd4.bft;
        zzd2.bft = zzd5;
        if (zzd5 != null) {
            zzd5.bfr = zzd2;
        }
        zza(zzd2, zzd4);
        zzd4.bfs = zzd2;
        zzd2.bfr = zzd4;
        zzd2.height = Math.max(zzd3 != null ? zzd3.height : 0, zzd5 != null ? zzd5.height : 0) + 1;
        int i2 = zzd2.height;
        if (zzd6 != null) {
            i = zzd6.height;
        }
        zzd4.height = Math.max(i2, i) + 1;
    }

    private void zza(zzd<K, V> zzd2, zzd<K, V> zzd3) {
        zzd<K, V> zzd4 = zzd2.bfr;
        zzd2.bfr = null;
        if (zzd3 != null) {
            zzd3.bfr = zzd4;
        }
        if (zzd4 == null) {
            this.bfh = zzd3;
        } else if (zzd4.bfs == zzd2) {
            zzd4.bfs = zzd3;
        } else if ($assertionsDisabled || zzd4.bft == zzd2) {
            zzd4.bft = zzd3;
        } else {
            throw new AssertionError();
        }
    }

    private void zzb(zzd<K, V> zzd2) {
        int i = 0;
        zzd<K, V> zzd3 = zzd2.bfs;
        zzd<K, V> zzd4 = zzd2.bft;
        zzd<K, V> zzd5 = zzd3.bfs;
        zzd<K, V> zzd6 = zzd3.bft;
        zzd2.bfs = zzd6;
        if (zzd6 != null) {
            zzd6.bfr = zzd2;
        }
        zza(zzd2, zzd3);
        zzd3.bft = zzd2;
        zzd2.bfr = zzd3;
        zzd2.height = Math.max(zzd4 != null ? zzd4.height : 0, zzd6 != null ? zzd6.height : 0) + 1;
        int i2 = zzd2.height;
        if (zzd5 != null) {
            i = zzd5.height;
        }
        zzd3.height = Math.max(i2, i) + 1;
    }

    private void zzb(zzd<K, V> zzd2, boolean z) {
        while (zzd2 != null) {
            zzd<K, V> zzd3 = zzd2.bfs;
            zzd<K, V> zzd4 = zzd2.bft;
            int i = zzd3 != null ? zzd3.height : 0;
            int i2 = zzd4 != null ? zzd4.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                zzd<K, V> zzd5 = zzd4.bfs;
                zzd<K, V> zzd6 = zzd4.bft;
                int i4 = (zzd5 != null ? zzd5.height : 0) - (zzd6 != null ? zzd6.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    zza(zzd2);
                } else if ($assertionsDisabled || i4 == 1) {
                    zzb(zzd4);
                    zza(zzd2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                zzd<K, V> zzd7 = zzd3.bfs;
                zzd<K, V> zzd8 = zzd3.bft;
                int i5 = (zzd7 != null ? zzd7.height : 0) - (zzd8 != null ? zzd8.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    zzb(zzd2);
                } else if ($assertionsDisabled || i5 == -1) {
                    zza(zzd3);
                    zzb(zzd2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                zzd2.height = i + 1;
                if (z) {
                    return;
                }
            } else if ($assertionsDisabled || i3 == -1 || i3 == 1) {
                zzd2.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            zzd2 = zzd2.bfr;
        }
    }

    public void clear() {
        this.bfh = null;
        this.size = 0;
        this.modCount++;
        zzd<K, V> zzd2 = this.bfi;
        zzd2.bfu = zzd2;
        zzd2.bfo = zzd2;
    }

    public boolean containsKey(Object obj) {
        return zzco(obj) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        zza zza2 = this.bfj;
        if (zza2 != null) {
            return zza2;
        }
        zza zza3 = new zza();
        this.bfj = zza3;
        return zza3;
    }

    public V get(Object obj) {
        zzd zzco = zzco(obj);
        if (zzco != null) {
            return zzco.aQx;
        }
        return null;
    }

    public Set<K> keySet() {
        zzb zzb2 = this.bfk;
        if (zzb2 != null) {
            return zzb2;
        }
        zzb zzb3 = new zzb();
        this.bfk = zzb3;
        return zzb3;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        zzd zza2 = zza(k, true);
        V v2 = zza2.aQx;
        zza2.aQx = v;
        return v2;
    }

    public V remove(Object obj) {
        zzd zzcp = zzcp(obj);
        if (zzcp != null) {
            return zzcp.aQx;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    /* access modifiers changed from: 0000 */
    public zzd<K, V> zza(K k, boolean z) {
        zzd<K, V> zzd2;
        int i;
        zzd<K, V> zzd3;
        Comparator<? super K> comparator = this.aQi;
        zzd<K, V> zzd4 = this.bfh;
        if (zzd4 != null) {
            Comparable comparable = comparator == bfg ? (Comparable) k : null;
            while (true) {
                int compare = comparable != null ? comparable.compareTo(zzd4.aQw) : comparator.compare(k, zzd4.aQw);
                if (compare == 0) {
                    return zzd4;
                }
                zzd<K, V> zzd5 = compare < 0 ? zzd4.bfs : zzd4.bft;
                if (zzd5 == null) {
                    int i2 = compare;
                    zzd2 = zzd4;
                    i = i2;
                    break;
                }
                zzd4 = zzd5;
            }
        } else {
            zzd2 = zzd4;
            i = 0;
        }
        if (!z) {
            return null;
        }
        zzd<K, V> zzd6 = this.bfi;
        if (zzd2 != null) {
            zzd3 = new zzd<>(zzd2, k, zzd6, zzd6.bfu);
            if (i < 0) {
                zzd2.bfs = zzd3;
            } else {
                zzd2.bft = zzd3;
            }
            zzb(zzd2, true);
        } else if (comparator != bfg || (k instanceof Comparable)) {
            zzd3 = new zzd<>(zzd2, k, zzd6, zzd6.bfu);
            this.bfh = zzd3;
        } else {
            throw new ClassCastException(String.valueOf(k.getClass().getName()).concat(" is not Comparable"));
        }
        this.size++;
        this.modCount++;
        return zzd3;
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzd<K, V> zzd2, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            zzd2.bfu.bfo = zzd2.bfo;
            zzd2.bfo.bfu = zzd2.bfu;
        }
        zzd<K, V> zzd3 = zzd2.bfs;
        zzd<K, V> zzd4 = zzd2.bft;
        zzd<K, V> zzd5 = zzd2.bfr;
        if (zzd3 == null || zzd4 == null) {
            if (zzd3 != null) {
                zza(zzd2, zzd3);
                zzd2.bfs = null;
            } else if (zzd4 != null) {
                zza(zzd2, zzd4);
                zzd2.bft = null;
            } else {
                zza(zzd2, null);
            }
            zzb(zzd5, false);
            this.size--;
            this.modCount++;
            return;
        }
        zzd<K, V> d = zzd3.height > zzd4.height ? zzd3.e() : zzd4.d();
        zza(d, false);
        zzd<K, V> zzd6 = zzd2.bfs;
        if (zzd6 != null) {
            i = zzd6.height;
            d.bfs = zzd6;
            zzd6.bfr = d;
            zzd2.bfs = null;
        } else {
            i = 0;
        }
        zzd<K, V> zzd7 = zzd2.bft;
        if (zzd7 != null) {
            i2 = zzd7.height;
            d.bft = zzd7;
            zzd7.bfr = d;
            zzd2.bft = null;
        }
        d.height = Math.max(i, i2) + 1;
        zza(zzd2, d);
    }

    /* access modifiers changed from: 0000 */
    public zzd<K, V> zzc(Entry<?, ?> entry) {
        zzd<K, V> zzco = zzco(entry.getKey());
        if (zzco != null && equal(zzco.aQx, entry.getValue())) {
            return zzco;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public zzd<K, V> zzco(Object obj) {
        zzd<K, V> zzd2 = null;
        if (obj == null) {
            return zzd2;
        }
        try {
            return zza((K) obj, false);
        } catch (ClassCastException e) {
            return zzd2;
        }
    }

    /* access modifiers changed from: 0000 */
    public zzd<K, V> zzcp(Object obj) {
        zzd<K, V> zzco = zzco(obj);
        if (zzco != null) {
            zza(zzco, true);
        }
        return zzco;
    }
}
