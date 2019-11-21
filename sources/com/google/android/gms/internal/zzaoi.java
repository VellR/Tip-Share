package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;

public final class zzaoi extends zzank<Object> {
    public static final zzanl bfE = new zzanl() {
        public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
            if (zzaoo.s() == Object.class) {
                return new zzaoi(zzams);
            }
            return null;
        }
    };
    private final zzams beA;

    private zzaoi(zzams zzams) {
        this.beA = zzams;
    }

    public void zza(zzaor zzaor, Object obj) throws IOException {
        if (obj == null) {
            zzaor.r();
            return;
        }
        zzank zzk = this.beA.zzk(obj.getClass());
        if (zzk instanceof zzaoi) {
            zzaor.p();
            zzaor.q();
            return;
        }
        zzk.zza(zzaor, obj);
    }

    public Object zzb(zzaop zzaop) throws IOException {
        switch (zzaop.h()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                zzaop.beginArray();
                while (zzaop.hasNext()) {
                    arrayList.add(zzb(zzaop));
                }
                zzaop.endArray();
                return arrayList;
            case BEGIN_OBJECT:
                zzanw zzanw = new zzanw();
                zzaop.beginObject();
                while (zzaop.hasNext()) {
                    zzanw.put(zzaop.nextName(), zzb(zzaop));
                }
                zzaop.endObject();
                return zzanw;
            case STRING:
                return zzaop.nextString();
            case NUMBER:
                return Double.valueOf(zzaop.nextDouble());
            case BOOLEAN:
                return Boolean.valueOf(zzaop.nextBoolean());
            case NULL:
                zzaop.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
