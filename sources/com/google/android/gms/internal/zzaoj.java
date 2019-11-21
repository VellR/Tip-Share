package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzaoj implements zzanl {
    private final zzans beb;
    private final zzant bek;
    private final zzamr bem;

    public static final class zza<T> extends zzank<T> {
        private final zzanx<T> bfI;
        private final Map<String, zzb> bgb;

        private zza(zzanx<T> zzanx, Map<String, zzb> map) {
            this.bfI = zzanx;
            this.bgb = map;
        }

        public void zza(zzaor zzaor, T t) throws IOException {
            if (t == null) {
                zzaor.r();
                return;
            }
            zzaor.p();
            try {
                for (zzb zzb : this.bgb.values()) {
                    if (zzb.zzcq(t)) {
                        zzaor.zzta(zzb.name);
                        zzb.zza(zzaor, (Object) t);
                    }
                }
                zzaor.q();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }

        public T zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            Object a = this.bfI.a();
            try {
                zzaop.beginObject();
                while (zzaop.hasNext()) {
                    zzb zzb = (zzb) this.bgb.get(zzaop.nextName());
                    if (zzb == null || !zzb.bgd) {
                        zzaop.skipValue();
                    } else {
                        zzb.zza(zzaop, a);
                    }
                }
                zzaop.endObject();
                return a;
            } catch (IllegalStateException e) {
                throw new zzanh((Throwable) e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    static abstract class zzb {
        final boolean bgc;
        final boolean bgd;
        final String name;

        protected zzb(String str, boolean z, boolean z2) {
            this.name = str;
            this.bgc = z;
            this.bgd = z2;
        }

        /* access modifiers changed from: 0000 */
        public abstract void zza(zzaop zzaop, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: 0000 */
        public abstract void zza(zzaor zzaor, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: 0000 */
        public abstract boolean zzcq(Object obj) throws IOException, IllegalAccessException;
    }

    public zzaoj(zzans zzans, zzamr zzamr, zzant zzant) {
        this.beb = zzans;
        this.bem = zzamr;
        this.bek = zzant;
    }

    /* access modifiers changed from: private */
    public zzank<?> zza(zzams zzams, Field field, zzaoo<?> zzaoo) {
        zzanm zzanm = (zzanm) field.getAnnotation(zzanm.class);
        if (zzanm != null) {
            zzank<?> zza2 = zzaoe.zza(this.beb, zzams, zzaoo, zzanm);
            if (zza2 != null) {
                return zza2;
            }
        }
        return zzams.zza(zzaoo);
    }

    private zzb zza(zzams zzams, Field field, String str, zzaoo<?> zzaoo, boolean z, boolean z2) {
        final boolean zzk = zzany.zzk(zzaoo.s());
        final zzams zzams2 = zzams;
        final Field field2 = field;
        final zzaoo<?> zzaoo2 = zzaoo;
        return new zzb(str, z, z2) {
            final zzank<?> bfV = zzaoj.this.zza(zzams2, field2, zzaoo2);

            /* access modifiers changed from: 0000 */
            public void zza(zzaop zzaop, Object obj) throws IOException, IllegalAccessException {
                Object zzb = this.bfV.zzb(zzaop);
                if (zzb != null || !zzk) {
                    field2.set(obj, zzb);
                }
            }

            /* access modifiers changed from: 0000 */
            public void zza(zzaor zzaor, Object obj) throws IOException, IllegalAccessException {
                new zzaom(zzams2, this.bfV, zzaoo2.t()).zza(zzaor, field2.get(obj));
            }

            public boolean zzcq(Object obj) throws IOException, IllegalAccessException {
                return this.bgc && field2.get(obj) != obj;
            }
        };
    }

    static List<String> zza(zzamr zzamr, Field field) {
        zzann zzann = (zzann) field.getAnnotation(zzann.class);
        LinkedList linkedList = new LinkedList();
        if (zzann == null) {
            linkedList.add(zzamr.zzc(field));
        } else {
            linkedList.add(zzann.value());
            for (String add : zzann.zzczy()) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    private Map<String, zzb> zza(zzams zzams, zzaoo<?> zzaoo, Class<?> cls) {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type t = zzaoo.t();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean zza2 = zza(field, true);
                boolean zza3 = zza(field, false);
                if (zza2 || zza3) {
                    field.setAccessible(true);
                    Type zza4 = zzanr.zza(zzaoo.t(), cls, field.getGenericType());
                    List zzd = zzd(field);
                    zzb zzb2 = null;
                    int i = 0;
                    while (i < zzd.size()) {
                        String str = (String) zzd.get(i);
                        if (i != 0) {
                            zza2 = false;
                        }
                        zzb zzb3 = (zzb) linkedHashMap.put(str, zza(zzams, field, str, zzaoo.zzl(zza4), zza2, zza3));
                        if (zzb2 != null) {
                            zzb3 = zzb2;
                        }
                        i++;
                        zzb2 = zzb3;
                    }
                    if (zzb2 != null) {
                        String valueOf = String.valueOf(t);
                        String str2 = zzb2.name;
                        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 37 + String.valueOf(str2).length()).append(valueOf).append(" declares multiple JSON fields named ").append(str2).toString());
                    }
                }
            }
            zzaoo = zzaoo.zzl(zzanr.zza(zzaoo.t(), cls, cls.getGenericSuperclass()));
            cls = zzaoo.s();
        }
        return linkedHashMap;
    }

    static boolean zza(Field field, boolean z, zzant zzant) {
        return !zzant.zza(field.getType(), z) && !zzant.zza(field, z);
    }

    private List<String> zzd(Field field) {
        return zza(this.bem, field);
    }

    public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
        Class s = zzaoo.s();
        if (!Object.class.isAssignableFrom(s)) {
            return null;
        }
        return new zza(this.beb.zzb(zzaoo), zza(zzams, zzaoo, s));
    }

    public boolean zza(Field field, boolean z) {
        return zza(field, z, this.bek);
    }
}
