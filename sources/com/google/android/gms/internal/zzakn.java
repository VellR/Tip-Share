package com.google.android.gms.internal;

import com.google.android.gms.internal.zzagi.zza;
import com.google.firebase.database.DatabaseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzakn {
    public static int zza(zzaka zzaka, zzakm zzakm, zzaka zzaka2, zzakm zzakm2) {
        int compareTo = zzakm.compareTo(zzakm2);
        return compareTo != 0 ? compareTo : zzaka.compareTo(zzaka2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b A[Catch:{ ClassCastException -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030 A[Catch:{ ClassCastException -> 0x00d2 }] */
    public static zzakm zza(Object obj, zzakm zzakm) throws DatabaseException {
        Object obj2;
        HashMap hashMap;
        try {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.containsKey(".priority")) {
                    zzakm = zzakq.zzbt(map.get(".priority"));
                }
                if (map.containsKey(".value")) {
                    obj2 = map.get(".value");
                    if (obj2 != null) {
                        return zzakf.zzcvi();
                    }
                    if (obj2 instanceof String) {
                        return new zzaks((String) obj2, zzakm);
                    }
                    if (obj2 instanceof Long) {
                        return new zzakk((Long) obj2, zzakm);
                    }
                    if (obj2 instanceof Integer) {
                        return new zzakk(Long.valueOf((long) ((Integer) obj2).intValue()), zzakm);
                    }
                    if (obj2 instanceof Double) {
                        return new zzake((Double) obj2, zzakm);
                    }
                    if (obj2 instanceof Boolean) {
                        return new zzajz((Boolean) obj2, zzakm);
                    }
                    if ((obj2 instanceof Map) || (obj2 instanceof List)) {
                        if (obj2 instanceof Map) {
                            Map map2 = (Map) obj2;
                            if (map2.containsKey(".sv")) {
                                return new zzakd(map2, zzakm);
                            }
                            HashMap hashMap2 = new HashMap(map2.size());
                            for (String str : map2.keySet()) {
                                if (!str.startsWith(".")) {
                                    zzakm zzbs = zzbs(map2.get(str));
                                    if (!zzbs.isEmpty()) {
                                        hashMap2.put(zzaka.zzrm(str), zzbs);
                                    }
                                }
                            }
                            hashMap = hashMap2;
                        } else {
                            List list = (List) obj2;
                            HashMap hashMap3 = new HashMap(list.size());
                            for (int i = 0; i < list.size(); i++) {
                                String str2 = i;
                                zzakm zzbs2 = zzbs(list.get(i));
                                if (!zzbs2.isEmpty()) {
                                    hashMap3.put(zzaka.zzrm(str2), zzbs2);
                                }
                            }
                            hashMap = hashMap3;
                        }
                        return hashMap.isEmpty() ? zzakf.zzcvi() : new zzakb(zza.zzb(hashMap, zzakb.aYF), zzakm);
                    }
                    String str3 = "Failed to parse node with class ";
                    String valueOf = String.valueOf(obj2.getClass().toString());
                    throw new DatabaseException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                }
            }
            obj2 = obj;
            if (obj2 != null) {
            }
        } catch (ClassCastException e) {
            throw new DatabaseException("Failed to parse node", e);
        }
    }

    public static zzakm zzbs(Object obj) throws DatabaseException {
        return zza(obj, zzakq.zzcvu());
    }
}
