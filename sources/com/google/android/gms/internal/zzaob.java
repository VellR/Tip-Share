package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class zzaob<E> extends zzank<Object> {
    public static final zzanl bfE = new zzanl() {
        public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
            Type t = zzaoo.t();
            if (!(t instanceof GenericArrayType) && (!(t instanceof Class) || !((Class) t).isArray())) {
                return null;
            }
            Type zzh = zzanr.zzh(t);
            return new zzaob(zzams, zzams.zza(zzaoo.zzl(zzh)), zzanr.zzf(zzh));
        }
    };
    private final Class<E> bfF;
    private final zzank<E> bfG;

    public zzaob(zzams zzams, zzank<E> zzank, Class<E> cls) {
        this.bfG = new zzaom(zzams, zzank, cls);
        this.bfF = cls;
    }

    public void zza(zzaor zzaor, Object obj) throws IOException {
        if (obj == null) {
            zzaor.r();
            return;
        }
        zzaor.n();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.bfG.zza(zzaor, Array.get(obj, i));
        }
        zzaor.o();
    }

    public Object zzb(zzaop zzaop) throws IOException {
        if (zzaop.h() == zzaoq.NULL) {
            zzaop.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        zzaop.beginArray();
        while (zzaop.hasNext()) {
            arrayList.add(this.bfG.zzb(zzaop));
        }
        zzaop.endArray();
        Object newInstance = Array.newInstance(this.bfF, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
