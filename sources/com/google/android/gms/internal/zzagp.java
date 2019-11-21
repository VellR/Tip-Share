package com.google.android.gms.internal;

import com.google.android.gms.internal.zzagn.zza;
import com.google.android.gms.internal.zzagn.zzb;
import java.util.Comparator;

public abstract class zzagp<K, V> implements zzagn<K, V> {
    private final K aQw;
    private final V aQx;
    private zzagn<K, V> aQy;
    private final zzagn<K, V> aQz;

    zzagp(K k, V v, zzagn<K, V> zzagn, zzagn<K, V> zzagn2) {
        this.aQw = k;
        this.aQx = v;
        if (zzagn == null) {
            zzagn = zzagm.zzcnk();
        }
        this.aQy = zzagn;
        if (zzagn2 == null) {
            zzagn2 = zzagm.zzcnk();
        }
        this.aQz = zzagn2;
    }

    private static zza zza(zzagn zzagn) {
        return zzagn.zzcnj() ? zza.BLACK : zza.RED;
    }

    private zzagn<K, V> zzcnq() {
        if (this.aQy.isEmpty()) {
            return zzagm.zzcnk();
        }
        if (!zzcnl().zzcnj() && !zzcnl().zzcnl().zzcnj()) {
            this = zzcnr();
        }
        return this.zza(null, null, ((zzagp) this.aQy).zzcnq(), null).zzcnt();
    }

    private zzagp<K, V> zzcnr() {
        zzagp zzcnw = zzcnw();
        return zzcnw.zzcnm().zzcnl().zzcnj() ? zzcnw.zza(null, null, null, ((zzagp) zzcnw.zzcnm()).zzcnv()).zzcnu().zzcnw() : zzcnw;
    }

    private zzagp<K, V> zzcns() {
        zzagp<K, V> zzcnw = zzcnw();
        return zzcnw.zzcnl().zzcnl().zzcnj() ? zzcnw.zzcnv().zzcnw() : zzcnw;
    }

    private zzagp<K, V> zzcnt() {
        if (this.aQz.zzcnj() && !this.aQy.zzcnj()) {
            this = zzcnu();
        }
        if (this.aQy.zzcnj() && ((zzagp) this.aQy).aQy.zzcnj()) {
            this = this.zzcnv();
        }
        return (!this.aQy.zzcnj() || !this.aQz.zzcnj()) ? this : this.zzcnw();
    }

    private zzagp<K, V> zzcnu() {
        return (zzagp) this.aQz.zza(null, null, zzcni(), (zzagp) zza(null, null, zza.RED, null, ((zzagp) this.aQz).aQy), null);
    }

    private zzagp<K, V> zzcnv() {
        return (zzagp) this.aQy.zza(null, null, zzcni(), null, (zzagp) zza(null, null, zza.RED, ((zzagp) this.aQy).aQz, null));
    }

    private zzagp<K, V> zzcnw() {
        return (zzagp) zza(null, null, zza((zzagn) this), this.aQy.zza(null, null, zza((zzagn) this.aQy), null, null), this.aQz.zza(null, null, zza((zzagn) this.aQz), null, null));
    }

    public K getKey() {
        return this.aQw;
    }

    public V getValue() {
        return this.aQx;
    }

    public boolean isEmpty() {
        return false;
    }

    public zzagn<K, V> zza(K k, V v, Comparator<K> comparator) {
        int compare = comparator.compare(k, this.aQw);
        zzagp zza = compare < 0 ? zza(null, null, this.aQy.zza(k, v, comparator), null) : compare == 0 ? zza(k, v, null, null) : zza(null, null, null, this.aQz.zza(k, v, comparator));
        return zza.zzcnt();
    }

    public zzagn<K, V> zza(K k, Comparator<K> comparator) {
        zzagp zza;
        if (comparator.compare(k, this.aQw) < 0) {
            if (!this.aQy.isEmpty() && !this.aQy.zzcnj() && !((zzagp) this.aQy).aQy.zzcnj()) {
                this = zzcnr();
            }
            zza = this.zza(null, null, this.aQy.zza(k, comparator), null);
        } else {
            if (this.aQy.zzcnj()) {
                this = zzcnv();
            }
            if (!this.aQz.isEmpty() && !this.aQz.zzcnj() && !((zzagp) this.aQz).aQy.zzcnj()) {
                this = this.zzcns();
            }
            if (comparator.compare(k, this.aQw) == 0) {
                if (this.aQz.isEmpty()) {
                    return zzagm.zzcnk();
                }
                zzagn zzcnn = this.aQz.zzcnn();
                this = this.zza(zzcnn.getKey(), zzcnn.getValue(), null, ((zzagp) this.aQz).zzcnq());
            }
            zza = this.zza(null, null, null, this.aQz.zza(k, comparator));
        }
        return zza.zzcnt();
    }

    /* access modifiers changed from: protected */
    public abstract zzagp<K, V> zza(K k, V v, zzagn<K, V> zzagn, zzagn<K, V> zzagn2);

    public void zza(zzb<K, V> zzb) {
        this.aQy.zza(zzb);
        zzb.zzk(this.aQw, this.aQx);
        this.aQz.zza(zzb);
    }

    /* renamed from: zzb */
    public zzagp<K, V> zza(K k, V v, zza zza, zzagn<K, V> zzagn, zzagn<K, V> zzagn2) {
        if (k == null) {
            k = this.aQw;
        }
        if (v == null) {
            v = this.aQx;
        }
        if (zzagn == null) {
            zzagn = this.aQy;
        }
        if (zzagn2 == null) {
            zzagn2 = this.aQz;
        }
        return zza == zza.RED ? new zzago(k, v, zzagn, zzagn2) : new zzagl(k, v, zzagn, zzagn2);
    }

    /* access modifiers changed from: 0000 */
    public void zzb(zzagn<K, V> zzagn) {
        this.aQy = zzagn;
    }

    /* access modifiers changed from: protected */
    public abstract zza zzcni();

    public zzagn<K, V> zzcnl() {
        return this.aQy;
    }

    public zzagn<K, V> zzcnm() {
        return this.aQz;
    }

    public zzagn<K, V> zzcnn() {
        return this.aQy.isEmpty() ? this : this.aQy.zzcnn();
    }

    public zzagn<K, V> zzcno() {
        return this.aQz.isEmpty() ? this : this.aQz.zzcno();
    }

    public int zzcnp() {
        return this.aQy.zzcnp() + 1 + this.aQz.zzcnp();
    }
}
