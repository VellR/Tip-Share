package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzant implements zzanl, Cloneable {
    public static final zzant beU = new zzant();
    private double beV = -1.0d;
    private int beW = 136;
    private boolean beX = true;
    private List<zzamo> beY = Collections.emptyList();
    private List<zzamo> beZ = Collections.emptyList();

    private boolean zza(zzano zzano) {
        return zzano == null || zzano.zzczz() <= this.beV;
    }

    private boolean zza(zzano zzano, zzanp zzanp) {
        return zza(zzano) && zza(zzanp);
    }

    private boolean zza(zzanp zzanp) {
        return zzanp == null || zzanp.zzczz() > this.beV;
    }

    private boolean zzm(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean zzn(Class<?> cls) {
        return cls.isMemberClass() && !zzo(cls);
    }

    private boolean zzo(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public zzant clone() {
        try {
            return (zzant) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
        Class s = zzaoo.s();
        final boolean zza = zza(s, true);
        final boolean zza2 = zza(s, false);
        if (!zza && !zza2) {
            return null;
        }
        final zzams zzams2 = zzams;
        final zzaoo<T> zzaoo2 = zzaoo;
        return new zzank<T>() {
            private zzank<T> bej;

            private zzank<T> zzczx() {
                zzank<T> zzank = this.bej;
                if (zzank != null) {
                    return zzank;
                }
                zzank<T> zza = zzams2.zza((zzanl) zzant.this, zzaoo2);
                this.bej = zza;
                return zza;
            }

            public void zza(zzaor zzaor, T t) throws IOException {
                if (zza) {
                    zzaor.r();
                } else {
                    zzczx().zza(zzaor, t);
                }
            }

            public T zzb(zzaop zzaop) throws IOException {
                if (!zza2) {
                    return zzczx().zzb(zzaop);
                }
                zzaop.skipValue();
                return null;
            }
        };
    }

    public zzant zza(zzamo zzamo, boolean z, boolean z2) {
        zzant b = clone();
        if (z) {
            b.beY = new ArrayList(this.beY);
            b.beY.add(zzamo);
        }
        if (z2) {
            b.beZ = new ArrayList(this.beZ);
            b.beZ.add(zzamo);
        }
        return b;
    }

    public boolean zza(Class<?> cls, boolean z) {
        if (this.beV != -1.0d && !zza((zzano) cls.getAnnotation(zzano.class), (zzanp) cls.getAnnotation(zzanp.class))) {
            return true;
        }
        if (!this.beX && zzn(cls)) {
            return true;
        }
        if (zzm(cls)) {
            return true;
        }
        for (zzamo zzh : z ? this.beY : this.beZ) {
            if (zzh.zzh(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(Field field, boolean z) {
        if ((this.beW & field.getModifiers()) != 0) {
            return true;
        }
        if (this.beV != -1.0d && !zza((zzano) field.getAnnotation(zzano.class), (zzanp) field.getAnnotation(zzanp.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (!this.beX && zzn(field.getType())) {
            return true;
        }
        if (zzm(field.getType())) {
            return true;
        }
        List<zzamo> list = z ? this.beY : this.beZ;
        if (!list.isEmpty()) {
            zzamp zzamp = new zzamp(field);
            for (zzamo zza : list) {
                if (zza.zza(zzamp)) {
                    return true;
                }
            }
        }
        return false;
    }

    public zzant zze(int... iArr) {
        zzant b = clone();
        b.beW = 0;
        for (int i : iArr) {
            b.beW = i | b.beW;
        }
        return b;
    }
}
