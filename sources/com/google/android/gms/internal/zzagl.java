package com.google.android.gms.internal;

import com.google.android.gms.internal.zzagn.zza;

public class zzagl<K, V> extends zzagp<K, V> {
    zzagl(K k, V v, zzagn<K, V> zzagn, zzagn<K, V> zzagn2) {
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
        return new zzagl(k, v, zzagn, zzagn2);
    }

    /* access modifiers changed from: protected */
    public zza zzcni() {
        return zza.BLACK;
    }

    public boolean zzcnj() {
        return false;
    }
}
