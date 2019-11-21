package com.google.android.gms.internal;

import java.util.Map.Entry;

public class zzajc<T> {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzajc.class.desiredAssertionStatus());
    private zzaka aXk;
    private zzajc<T> aXl;
    private zzajd<T> aXm;

    public interface zza<T> {
        boolean zze(zzajc<T> zzajc);
    }

    public interface zzb<T> {
        void zzd(zzajc<T> zzajc);
    }

    public zzajc() {
        this(null, null, new zzajd());
    }

    public zzajc(zzaka zzaka, zzajc<T> zzajc, zzajd<T> zzajd) {
        this.aXk = zzaka;
        this.aXl = zzajc;
        this.aXm = zzajd;
    }

    private void zza(zzaka zzaka, zzajc<T> zzajc) {
        boolean isEmpty = zzajc.isEmpty();
        boolean containsKey = this.aXm.aVh.containsKey(zzaka);
        if (isEmpty && containsKey) {
            this.aXm.aVh.remove(zzaka);
            zzcsy();
        } else if (!isEmpty && !containsKey) {
            this.aXm.aVh.put(zzaka, zzajc.aXm);
            zzcsy();
        }
    }

    private void zzcsy() {
        if (this.aXl != null) {
            this.aXl.zza(this.aXk, this);
        }
    }

    public T getValue() {
        return this.aXm.aQx;
    }

    public boolean hasChildren() {
        return !this.aXm.aVh.isEmpty();
    }

    public boolean isEmpty() {
        return this.aXm.aQx == null && this.aXm.aVh.isEmpty();
    }

    public void setValue(T t) {
        this.aXm.aQx = t;
        zzcsy();
    }

    public String toString() {
        return toString("");
    }

    /* access modifiers changed from: 0000 */
    public String toString(String str) {
        String asString = this.aXk == null ? "<anon>" : this.aXk.asString();
        String valueOf = String.valueOf(this.aXm.toString(String.valueOf(str).concat("\t")));
        return new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(asString).length() + String.valueOf(valueOf).length()).append(str).append(asString).append("\n").append(valueOf).toString();
    }

    public void zza(zzb<T> zzb2) {
        zza(zzb2, false, false);
    }

    public void zza(final zzb<T> zzb2, boolean z, final boolean z2) {
        if (z && !z2) {
            zzb2.zzd(this);
        }
        zzb(new zzb<T>() {
            public void zzd(zzajc<T> zzajc) {
                zzajc.zza(zzb2, true, z2);
            }
        });
        if (z && z2) {
            zzb2.zzd(this);
        }
    }

    public boolean zza(zza<T> zza2) {
        return zza(zza2, false);
    }

    public boolean zza(zza<T> zza2, boolean z) {
        if (!z) {
            this = this.aXl;
        }
        while (this != null) {
            if (zza2.zze(this)) {
                return true;
            }
            this = this.aXl;
        }
        return false;
    }

    public zzajc<T> zzal(zzahr zzahr) {
        zzaka zzcrb = zzahr.zzcrb();
        while (zzcrb != null) {
            zzajc zzajc = new zzajc(zzcrb, this, this.aXm.aVh.containsKey(zzcrb) ? (zzajd) this.aXm.aVh.get(zzcrb) : new zzajd());
            zzahr = zzahr.zzcrc();
            zzcrb = zzahr.zzcrb();
            this = zzajc;
        }
        return this;
    }

    public void zzb(zzb<T> zzb2) {
        Object[] array = this.aXm.aVh.entrySet().toArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < array.length) {
                Entry entry = (Entry) array[i2];
                zzb2.zzd(new zzajc((zzaka) entry.getKey(), this, (zzajd) entry.getValue()));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public zzahr zzcmu() {
        if (this.aXl != null) {
            if ($assertionsDisabled || this.aXk != null) {
                return this.aXl.zzcmu().zza(this.aXk);
            }
            throw new AssertionError();
        } else if (this.aXk == null) {
            return zzahr.zzcqy();
        } else {
            return new zzahr(this.aXk);
        }
    }
}
