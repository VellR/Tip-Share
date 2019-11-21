package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaow;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzaox<M extends zzaow<M>, T> {
    protected final Class<T> bau;
    protected final boolean bic;
    public final int tag;
    protected final int type;

    private zzaox(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.bau = cls;
        this.tag = i2;
        this.bic = z;
    }

    public static <M extends zzaow<M>, T extends zzapc> zzaox<M, T> zza(int i, Class<T> cls, long j) {
        return new zzaox<>(i, cls, (int) j, false);
    }

    private T zzaw(List<zzape> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzape zzape = (zzape) list.get(i);
            if (zzape.bil.length != 0) {
                zza(zzape, (List<Object>) arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T cast = this.bau.cast(Array.newInstance(this.bau.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private T zzax(List<zzape> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.bau.cast(zzcf(zzaou.zzaz(((zzape) list.get(list.size() - 1)).bil)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaox)) {
            return false;
        }
        zzaox zzaox = (zzaox) obj;
        return this.type == zzaox.type && this.bau == zzaox.bau && this.tag == zzaox.tag && this.bic == zzaox.bic;
    }

    public int hashCode() {
        return (this.bic ? 1 : 0) + ((((((this.type + 1147) * 31) + this.bau.hashCode()) * 31) + this.tag) * 31);
    }

    /* access modifiers changed from: protected */
    public void zza(zzape zzape, List<Object> list) {
        list.add(zzcf(zzaou.zzaz(zzape.bil)));
    }

    /* access modifiers changed from: 0000 */
    public void zza(Object obj, zzaov zzaov) throws IOException {
        if (this.bic) {
            zzc(obj, zzaov);
        } else {
            zzb(obj, zzaov);
        }
    }

    /* access modifiers changed from: 0000 */
    public final T zzav(List<zzape> list) {
        if (list == null) {
            return null;
        }
        return this.bic ? zzaw(list) : zzax(list);
    }

    /* access modifiers changed from: protected */
    public void zzb(Object obj, zzaov zzaov) {
        try {
            zzaov.zzaes(this.tag);
            switch (this.type) {
                case 10:
                    zzapc zzapc = (zzapc) obj;
                    int zzafa = zzapf.zzafa(this.tag);
                    zzaov.zzb(zzapc);
                    zzaov.zzai(zzafa, 4);
                    return;
                case 11:
                    zzaov.zzc((zzapc) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* access modifiers changed from: protected */
    public void zzc(Object obj, zzaov zzaov) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzaov);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object zzcf(zzaou zzaou) {
        Class<T> cls = this.bic ? this.bau.getComponentType() : this.bau;
        try {
            switch (this.type) {
                case 10:
                    zzapc zzapc = (zzapc) cls.newInstance();
                    zzaou.zza(zzapc, zzapf.zzafa(this.tag));
                    return zzapc;
                case 11:
                    zzapc zzapc2 = (zzapc) cls.newInstance();
                    zzaou.zza(zzapc2);
                    return zzapc2;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(cls);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(cls);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 33).append("Error creating instance of class ").append(valueOf2).toString(), e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    /* access modifiers changed from: 0000 */
    public int zzcr(Object obj) {
        return this.bic ? zzcs(obj) : zzct(obj);
    }

    /* access modifiers changed from: protected */
    public int zzcs(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzct(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int zzct(Object obj) {
        int zzafa = zzapf.zzafa(this.tag);
        switch (this.type) {
            case 10:
                return zzaov.zzb(zzafa, (zzapc) obj);
            case 11:
                return zzaov.zzc(zzafa, (zzapc) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }
}
