package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class zzaoc implements zzanl {
    private final zzans beb;

    private static final class zza<E> extends zzank<Collection<E>> {
        private final zzank<E> bfH;
        private final zzanx<? extends Collection<E>> bfI;

        public zza(zzams zzams, Type type, zzank<E> zzank, zzanx<? extends Collection<E>> zzanx) {
            this.bfH = new zzaom(zzams, zzank, type);
            this.bfI = zzanx;
        }

        public void zza(zzaor zzaor, Collection<E> collection) throws IOException {
            if (collection == null) {
                zzaor.r();
                return;
            }
            zzaor.n();
            for (E zza : collection) {
                this.bfH.zza(zzaor, zza);
            }
            zzaor.o();
        }

        /* renamed from: zzj */
        public Collection<E> zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            Collection<E> collection = (Collection) this.bfI.a();
            zzaop.beginArray();
            while (zzaop.hasNext()) {
                collection.add(this.bfH.zzb(zzaop));
            }
            zzaop.endArray();
            return collection;
        }
    }

    public zzaoc(zzans zzans) {
        this.beb = zzans;
    }

    public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
        Type t = zzaoo.t();
        Class s = zzaoo.s();
        if (!Collection.class.isAssignableFrom(s)) {
            return null;
        }
        Type zza2 = zzanr.zza(t, s);
        return new zza(zzams, zza2, zzams.zza(zzaoo.zzl(zza2)), this.beb.zzb(zzaoo));
    }
}
