package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public final class zzaoh implements zzanl {
    private final zzans beb;
    /* access modifiers changed from: private */
    public final boolean bfQ;

    private final class zza<K, V> extends zzank<Map<K, V>> {
        private final zzanx<? extends Map<K, V>> bfI;
        private final zzank<K> bfR;
        private final zzank<V> bfS;

        public zza(zzams zzams, Type type, zzank<K> zzank, Type type2, zzank<V> zzank2, zzanx<? extends Map<K, V>> zzanx) {
            this.bfR = new zzaom(zzams, zzank, type);
            this.bfS = new zzaom(zzams, zzank2, type2);
            this.bfI = zzanx;
        }

        private String zze(zzamy zzamy) {
            if (zzamy.zzczo()) {
                zzane zzczs = zzamy.zzczs();
                if (zzczs.zzczv()) {
                    return String.valueOf(zzczs.zzczg());
                }
                if (zzczs.zzczu()) {
                    return Boolean.toString(zzczs.zzczl());
                }
                if (zzczs.zzczw()) {
                    return zzczs.zzczh();
                }
                throw new AssertionError();
            } else if (zzamy.zzczp()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        public void zza(zzaor zzaor, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                zzaor.r();
            } else if (!zzaoh.this.bfQ) {
                zzaor.p();
                for (Entry entry : map.entrySet()) {
                    zzaor.zzta(String.valueOf(entry.getKey()));
                    this.bfS.zza(zzaor, entry.getValue());
                }
                zzaor.q();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Entry entry2 : map.entrySet()) {
                    zzamy zzcl = this.bfR.zzcl(entry2.getKey());
                    arrayList.add(zzcl);
                    arrayList2.add(entry2.getValue());
                    z = (zzcl.zzczm() || zzcl.zzczn()) | z;
                }
                if (z) {
                    zzaor.n();
                    while (i < arrayList.size()) {
                        zzaor.n();
                        zzanz.zzb((zzamy) arrayList.get(i), zzaor);
                        this.bfS.zza(zzaor, arrayList2.get(i));
                        zzaor.o();
                        i++;
                    }
                    zzaor.o();
                    return;
                }
                zzaor.p();
                while (i < arrayList.size()) {
                    zzaor.zzta(zze((zzamy) arrayList.get(i)));
                    this.bfS.zza(zzaor, arrayList2.get(i));
                    i++;
                }
                zzaor.q();
            }
        }

        /* renamed from: zzl */
        public Map<K, V> zzb(zzaop zzaop) throws IOException {
            zzaoq h = zzaop.h();
            if (h == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.bfI.a();
            if (h == zzaoq.BEGIN_ARRAY) {
                zzaop.beginArray();
                while (zzaop.hasNext()) {
                    zzaop.beginArray();
                    Object zzb = this.bfR.zzb(zzaop);
                    if (map.put(zzb, this.bfS.zzb(zzaop)) != null) {
                        String valueOf = String.valueOf(zzb);
                        throw new zzanh(new StringBuilder(String.valueOf(valueOf).length() + 15).append("duplicate key: ").append(valueOf).toString());
                    }
                    zzaop.endArray();
                }
                zzaop.endArray();
                return map;
            }
            zzaop.beginObject();
            while (zzaop.hasNext()) {
                zzanu.bff.zzi(zzaop);
                Object zzb2 = this.bfR.zzb(zzaop);
                if (map.put(zzb2, this.bfS.zzb(zzaop)) != null) {
                    String valueOf2 = String.valueOf(zzb2);
                    throw new zzanh(new StringBuilder(String.valueOf(valueOf2).length() + 15).append("duplicate key: ").append(valueOf2).toString());
                }
            }
            zzaop.endObject();
            return map;
        }
    }

    public zzaoh(zzans zzans, boolean z) {
        this.beb = zzans;
        this.bfQ = z;
    }

    private zzank<?> zza(zzams zzams, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? zzaon.bgm : zzams.zza(zzaoo.zzl(type));
    }

    public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
        Type t = zzaoo.t();
        if (!Map.class.isAssignableFrom(zzaoo.s())) {
            return null;
        }
        Type[] zzb = zzanr.zzb(t, zzanr.zzf(t));
        zzank zza2 = zza(zzams, zzb[0]);
        zzank zza3 = zzams.zza(zzaoo.zzl(zzb[1]));
        zzanx zzb2 = this.beb.zzb(zzaoo);
        return new zza(zzams, zzb[0], zza2, zzb[1], zza3, zzb2);
    }
}
