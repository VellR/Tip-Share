package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class zzaja<T> implements Iterable<Entry<zzahr, T>> {
    private static final zzagi aXf = com.google.android.gms.internal.zzagi.zza.zza(zzagr.zzi(zzaka.class));
    private static final zzaja aXg = new zzaja(null, aXf);
    private final T aQx;
    private final zzagi<zzaka, zzaja<T>> aXe;

    public interface zza<T, R> {
        R zza(zzahr zzahr, T t, R r);
    }

    public zzaja(T t) {
        this(t, aXf);
    }

    public zzaja(T t, zzagi<zzaka, zzaja<T>> zzagi) {
        this.aQx = t;
        this.aXe = zzagi;
    }

    private <R> R zza(zzahr zzahr, zza<? super T, R> zza2, R r) {
        Iterator it = this.aXe.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            r = ((zzaja) entry.getValue()).zza(zzahr.zza((zzaka) entry.getKey()), zza2, r);
        }
        return this.aQx != null ? zza2.zza(zzahr, this.aQx, r) : r;
    }

    public static <V> zzaja<V> zzcsw() {
        return aXg;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzaja zzaja = (zzaja) obj;
        if (this.aXe == null ? zzaja.aXe != null : !this.aXe.equals(zzaja.aXe)) {
            return false;
        }
        if (this.aQx != null) {
            if (this.aQx.equals(zzaja.aQx)) {
                return true;
            }
        } else if (zzaja.aQx == null) {
            return true;
        }
        return false;
    }

    public T getValue() {
        return this.aQx;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.aQx != null ? this.aQx.hashCode() : 0) * 31;
        if (this.aXe != null) {
            i = this.aXe.hashCode();
        }
        return hashCode + i;
    }

    public boolean isEmpty() {
        return this.aQx == null && this.aXe.isEmpty();
    }

    public Iterator<Entry<zzahr, T>> iterator() {
        final ArrayList arrayList = new ArrayList();
        zza(new zza<T, Void>() {
            public Void zza(zzahr zzahr, T t, Void voidR) {
                arrayList.add(new SimpleImmutableEntry(zzahr, t));
                return null;
            }
        });
        return arrayList.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableTree { value=");
        sb.append(getValue());
        sb.append(", children={");
        Iterator it = this.aXe.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            sb.append(((zzaka) entry.getKey()).asString());
            sb.append("=");
            sb.append(entry.getValue());
        }
        sb.append("} }");
        return sb.toString();
    }

    public Collection<T> values() {
        final ArrayList arrayList = new ArrayList();
        zza(new zza<T, Void>() {
            public Void zza(zzahr zzahr, T t, Void voidR) {
                arrayList.add(t);
                return null;
            }
        });
        return arrayList;
    }

    public zzahr zza(zzahr zzahr, zzajb<? super T> zzajb) {
        if (this.aQx != null && zzajb.zzbr(this.aQx)) {
            return zzahr.zzcqy();
        }
        if (zzahr.isEmpty()) {
            return null;
        }
        zzaka zzcrb = zzahr.zzcrb();
        zzaja zzaja = (zzaja) this.aXe.get(zzcrb);
        if (zzaja == null) {
            return null;
        }
        zzahr zza2 = zzaja.zza(zzahr.zzcrc(), zzajb);
        if (zza2 == null) {
            return null;
        }
        return new zzahr(zzcrb).zzh(zza2);
    }

    public zzaja<T> zza(zzahr zzahr, zzaja<T> zzaja) {
        if (zzahr.isEmpty()) {
            return zzaja;
        }
        zzaka zzcrb = zzahr.zzcrb();
        zzaja zzaja2 = (zzaja) this.aXe.get(zzcrb);
        if (zzaja2 == null) {
            zzaja2 = zzcsw();
        }
        zzaja zza2 = zzaja2.zza(zzahr.zzcrc(), zzaja);
        return new zzaja<>(this.aQx, zza2.isEmpty() ? this.aXe.zzbf(zzcrb) : this.aXe.zzj(zzcrb, zza2));
    }

    public void zza(zza<T, Void> zza2) {
        zza(zzahr.zzcqy(), zza2, null);
    }

    public zzahr zzag(zzahr zzahr) {
        return zza(zzahr, zzajb.aXj);
    }

    public T zzah(zzahr zzahr) {
        return zzc(zzahr, zzajb.aXj);
    }

    public zzaja<T> zzai(zzahr zzahr) {
        if (zzahr.isEmpty()) {
            return this;
        }
        zzaja zzaja = (zzaja) this.aXe.get(zzahr.zzcrb());
        return zzaja != null ? zzaja.zzai(zzahr.zzcrc()) : zzcsw();
    }

    public zzaja<T> zzaj(zzahr zzahr) {
        if (zzahr.isEmpty()) {
            return this.aXe.isEmpty() ? zzcsw() : new zzaja(null, this.aXe);
        }
        zzaka zzcrb = zzahr.zzcrb();
        zzaja zzaja = (zzaja) this.aXe.get(zzcrb);
        if (zzaja == null) {
            return this;
        }
        zzaja zzaj = zzaja.zzaj(zzahr.zzcrc());
        zzagi zzj = zzaj.isEmpty() ? this.aXe.zzbf(zzcrb) : this.aXe.zzj(zzcrb, zzaj);
        return (this.aQx != null || !zzj.isEmpty()) ? new zzaja(this.aQx, zzj) : zzcsw();
    }

    public T zzak(zzahr zzahr) {
        if (zzahr.isEmpty()) {
            return this.aQx;
        }
        zzaja zzaja = (zzaja) this.aXe.get(zzahr.zzcrb());
        if (zzaja != null) {
            return zzaja.zzak(zzahr.zzcrc());
        }
        return null;
    }

    public zzaja<T> zzb(zzahr zzahr, T t) {
        if (zzahr.isEmpty()) {
            return new zzaja<>(t, this.aXe);
        }
        zzaka zzcrb = zzahr.zzcrb();
        zzaja zzaja = (zzaja) this.aXe.get(zzcrb);
        if (zzaja == null) {
            zzaja = zzcsw();
        }
        return new zzaja<>(this.aQx, this.aXe.zzj(zzcrb, zzaja.zzb(zzahr.zzcrc(), t)));
    }

    public T zzb(zzahr zzahr, zzajb<? super T> zzajb) {
        if (this.aQx != null && zzajb.zzbr(this.aQx)) {
            return this.aQx;
        }
        Iterator it = zzahr.iterator();
        while (it.hasNext()) {
            zzaja zzaja = (zzaja) this.aXe.get((zzaka) it.next());
            if (zzaja == null) {
                return null;
            }
            if (zzaja.aQx != null && zzajb.zzbr(zzaja.aQx)) {
                return zzaja.aQx;
            }
            this = zzaja;
        }
        return null;
    }

    public <R> R zzb(R r, zza<? super T, R> zza2) {
        return zza(zzahr.zzcqy(), zza2, r);
    }

    public boolean zzb(zzajb<? super T> zzajb) {
        if (this.aQx != null && zzajb.zzbr(this.aQx)) {
            return true;
        }
        Iterator it = this.aXe.iterator();
        while (it.hasNext()) {
            if (((zzaja) ((Entry) it.next()).getValue()).zzb(zzajb)) {
                return true;
            }
        }
        return false;
    }

    public T zzc(zzahr zzahr, zzajb<? super T> zzajb) {
        T t = (this.aQx == null || !zzajb.zzbr(this.aQx)) ? null : this.aQx;
        Iterator it = zzahr.iterator();
        T t2 = t;
        while (it.hasNext()) {
            zzaja zzaja = (zzaja) this.aXe.get((zzaka) it.next());
            if (zzaja == null) {
                break;
            }
            if (zzaja.aQx != null && zzajb.zzbr(zzaja.aQx)) {
                t2 = zzaja.aQx;
            }
            this = zzaja;
        }
        return t2;
    }

    public zzagi<zzaka, zzaja<T>> zzcsx() {
        return this.aXe;
    }

    public zzaja<T> zze(zzaka zzaka) {
        zzaja<T> zzaja = (zzaja) this.aXe.get(zzaka);
        return zzaja != null ? zzaja : zzcsw();
    }
}
