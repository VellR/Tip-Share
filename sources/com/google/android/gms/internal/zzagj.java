package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Stack;

public class zzagj<K, V> implements Iterator<Entry<K, V>> {
    private final Stack<zzagp<K, V>> aQo = new Stack<>();
    private final boolean aQp;

    zzagj(zzagn<K, V> zzagn, K k, Comparator<K> comparator, boolean z) {
        this.aQp = z;
        zzagn<K, V> zzagn2 = zzagn;
        while (!zzagn2.isEmpty()) {
            int i = k != null ? z ? comparator.compare(k, zzagn2.getKey()) : comparator.compare(zzagn2.getKey(), k) : 1;
            if (i < 0) {
                zzagn2 = z ? zzagn2.zzcnl() : zzagn2.zzcnm();
            } else if (i == 0) {
                this.aQo.push((zzagp) zzagn2);
                return;
            } else {
                this.aQo.push((zzagp) zzagn2);
                zzagn2 = z ? zzagn2.zzcnm() : zzagn2.zzcnl();
            }
        }
    }

    public boolean hasNext() {
        return this.aQo.size() > 0;
    }

    public Entry<K, V> next() {
        try {
            zzagp zzagp = (zzagp) this.aQo.pop();
            SimpleEntry simpleEntry = new SimpleEntry(zzagp.getKey(), zzagp.getValue());
            if (this.aQp) {
                for (zzagn zzcnl = zzagp.zzcnl(); !zzcnl.isEmpty(); zzcnl = zzcnl.zzcnm()) {
                    this.aQo.push((zzagp) zzcnl);
                }
            } else {
                for (zzagn zzcnm = zzagp.zzcnm(); !zzcnm.isEmpty(); zzcnm = zzcnm.zzcnl()) {
                    this.aQo.push((zzagp) zzcnm);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
