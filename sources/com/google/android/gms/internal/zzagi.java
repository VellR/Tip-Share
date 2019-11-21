package com.google.android.gms.internal;

import com.google.android.gms.internal.zzagn.zzb;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class zzagi<K, V> implements Iterable<Entry<K, V>> {

    public static class zza {
        private static final C0028zza aQn = new C0028zza() {
            public Object zzbj(Object obj) {
                return obj;
            }
        };

        /* renamed from: com.google.android.gms.internal.zzagi$zza$zza reason: collision with other inner class name */
        public interface C0028zza<C, D> {
            D zzbj(C c);
        }

        public static <K, V> zzagi<K, V> zza(Comparator<K> comparator) {
            return new zzagh(comparator);
        }

        public static <A, B, C> zzagi<A, C> zzb(List<A> list, Map<B, C> map, C0028zza<A, B> zza, Comparator<A> comparator) {
            return list.size() < 25 ? zzagh.zza(list, map, zza, comparator) : zzagq.zzc(list, map, zza, comparator);
        }

        public static <A, B> zzagi<A, B> zzb(Map<A, B> map, Comparator<A> comparator) {
            return map.size() < 25 ? zzagh.zza(map, comparator) : zzagq.zzc(map, comparator);
        }

        public static <A> C0028zza<A, A> zzcnf() {
            return aQn;
        }
    }

    public abstract boolean containsKey(K k);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzagi)) {
            return false;
        }
        zzagi zzagi = (zzagi) obj;
        if (!zzcne().equals(zzagi.zzcne())) {
            return false;
        }
        if (size() != zzagi.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = zzagi.iterator();
        while (it.hasNext()) {
            if (!((Entry) it.next()).equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract V get(K k);

    public int hashCode() {
        int hashCode = zzcne().hashCode();
        Iterator it = iterator();
        while (true) {
            int i = hashCode;
            if (!it.hasNext()) {
                return i;
            }
            hashCode = ((Entry) it.next()).hashCode() + (i * 31);
        }
    }

    public abstract boolean isEmpty();

    public abstract Iterator<Entry<K, V>> iterator();

    public abstract int size();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        Iterator it = iterator();
        boolean z = true;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append("(");
            sb.append(entry.getKey());
            sb.append("=>");
            sb.append(entry.getValue());
            sb.append(")");
        }
        sb.append("};");
        return sb.toString();
    }

    public abstract void zza(zzb<K, V> zzb);

    public abstract zzagi<K, V> zzbf(K k);

    public abstract K zzbg(K k);

    public abstract K zzcnb();

    public abstract K zzcnc();

    public abstract Iterator<Entry<K, V>> zzcnd();

    public abstract Comparator<K> zzcne();

    public abstract zzagi<K, V> zzj(K k, V v);
}
