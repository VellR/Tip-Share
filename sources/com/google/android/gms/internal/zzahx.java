package com.google.android.gms.internal;

import com.google.android.gms.internal.zzahz.zzb;
import com.google.android.gms.internal.zzakb.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class zzahx {
    public static zzahi zza(zzahi zzahi, Map<String, Object> map) {
        zzahi zzcpv = zzahi.zzcpv();
        Iterator it = zzahi.iterator();
        while (true) {
            zzahi zzahi2 = zzcpv;
            if (!it.hasNext()) {
                return zzahi2;
            }
            Entry entry = (Entry) it.next();
            zzcpv = zzahi2.zze((zzahr) entry.getKey(), zza((zzakm) entry.getValue(), map));
        }
    }

    public static zzahz zza(zzahz zzahz, final Map<String, Object> map) {
        final zzahz zzahz2 = new zzahz();
        zzahz.zza(new zzahr(""), new zzb() {
            public void zzf(zzahr zzahr, zzakm zzakm) {
                zzahz.this.zzh(zzahr, zzahx.zza(zzakm, map));
            }
        });
        return zzahz2;
    }

    public static zzakm zza(zzakm zzakm, final Map<String, Object> map) {
        Object value = zzakm.zzcux().getValue();
        if (value instanceof Map) {
            Map map2 = (Map) value;
            if (map2.containsKey(".sv")) {
                value = map.get((String) map2.get(".sv"));
            }
        }
        zzakm zzbt = zzakq.zzbt(value);
        if (zzakm.zzcuw()) {
            Object zza = zza(zzakm.getValue(), map);
            return (!zza.equals(zzakm.getValue()) || !zzbt.equals(zzakm.zzcux())) ? zzakn.zza(zza, zzbt) : zzakm;
        } else if (zzakm.isEmpty()) {
            return zzakm;
        } else {
            zzakb zzakb = (zzakb) zzakm;
            final zzahy zzahy = new zzahy(zzakb);
            zzakb.zza((zza) new zza() {
                public void zzb(zzaka zzaka, zzakm zzakm) {
                    zzakm zza = zzahx.zza(zzakm, map);
                    if (zza != zzakm) {
                        zzahy.zzg(new zzahr(zzaka.asString()), zza);
                    }
                }
            });
            return !zzahy.zzcro().zzcux().equals(zzbt) ? zzahy.zzcro().zzf(zzbt) : zzahy.zzcro();
        }
    }

    public static Object zza(Object obj, Map<String, Object> map) {
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map2 = (Map) obj;
        if (!map2.containsKey(".sv")) {
            return obj;
        }
        String str = (String) map2.get(".sv");
        return map.containsKey(str) ? map.get(str) : obj;
    }

    public static Map<String, Object> zza(zzalg zzalg) {
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(zzalg.zzcwq()));
        return hashMap;
    }
}
