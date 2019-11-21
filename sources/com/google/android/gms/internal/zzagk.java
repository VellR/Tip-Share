package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class zzagk<T> implements Iterable<T> {
    private final zzagi<T, Void> aQq;

    private static class zza<T> implements Iterator<T> {
        final Iterator<Entry<T, Void>> aQr;

        public zza(Iterator<Entry<T, Void>> it) {
            this.aQr = it;
        }

        public boolean hasNext() {
            return this.aQr.hasNext();
        }

        public T next() {
            return ((Entry) this.aQr.next()).getKey();
        }

        public void remove() {
            this.aQr.remove();
        }
    }

    private zzagk(zzagi<T, Void> zzagi) {
        this.aQq = zzagi;
    }

    public zzagk(List<T> list, Comparator<T> comparator) {
        this.aQq = com.google.android.gms.internal.zzagi.zza.zzb(list, Collections.emptyMap(), com.google.android.gms.internal.zzagi.zza.zzcnf(), comparator);
    }

    public Iterator<T> iterator() {
        return new zza(this.aQq.iterator());
    }

    public zzagk<T> zzbk(T t) {
        zzagi<T, Void> zzbf = this.aQq.zzbf(t);
        return zzbf == this.aQq ? this : new zzagk<>(zzbf);
    }

    public zzagk<T> zzbl(T t) {
        return new zzagk<>(this.aQq.zzj(t, null));
    }

    public T zzbm(T t) {
        return this.aQq.zzbg(t);
    }

    public Iterator<T> zzcnd() {
        return new zza(this.aQq.zzcnd());
    }

    public T zzcng() {
        return this.aQq.zzcnb();
    }

    public T zzcnh() {
        return this.aQq.zzcnc();
    }
}
