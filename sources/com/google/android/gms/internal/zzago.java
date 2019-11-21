package com.google.android.gms.internal;

import com.google.android.gms.internal.zzagn.zza;

public class zzago<K, V> extends zzagp<K, V> {
    zzago(K k, V v) {
        super(k, v, zzagm.zzcnk(), zzagm.zzcnk());
    }

    zzago(K k, V v, zzagn<K, V> zzagn, zzagn<K, V> zzagn2) {
        super(k, v, zzagn, zzagn2);
    }

    /* access modifiers changed from: protected */
    public zzagp<K, V> zza(K k, V v, zzagn<K, V> zzagn, zzagn<K, V> zzagn2) {
        if (k == null) {
            k = getKey();
        }
        if (v == null) {
            v = getValue();
        }
        if (zzagn == null) {
            zzagn = zzcnl();
        }
        if (zzagn2 == null) {
            zzagn2 = zzcnm();
        }
        return new zzago(k, v, zzagn, zzagn2);
    }

    /* access modifiers changed from: protected */
    public zza zzcni() {
        return zza.RED;
    }

    public boolean zzcnj() {
        return true;
    }
}
