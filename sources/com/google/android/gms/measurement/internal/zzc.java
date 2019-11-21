package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzun.zza;
import com.google.android.gms.internal.zzun.zzb;
import com.google.android.gms.internal.zzun.zze;
import com.google.android.gms.internal.zzup;
import com.google.android.gms.internal.zzup.zzf;
import com.google.android.gms.internal.zzup.zzg;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.zzd;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

class zzc extends zzaa {
    zzc(zzx zzx) {
        super(zzx);
    }

    private Boolean zza(zzb zzb, zzup.zzb zzb2, long j) {
        com.google.android.gms.internal.zzun.zzc[] zzcArr;
        com.google.android.gms.internal.zzup.zzc[] zzcArr2;
        com.google.android.gms.internal.zzun.zzc[] zzcArr3;
        if (zzb.aoe != null) {
            Boolean zzbj = new zzs(zzb.aoe).zzbj(j);
            if (zzbj == null) {
                return null;
            }
            if (!zzbj.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        HashSet hashSet = new HashSet();
        for (com.google.android.gms.internal.zzun.zzc zzc : zzb.aoc) {
            if (TextUtils.isEmpty(zzc.aoj)) {
                zzbsz().zzbtt().zzj("null or empty param name in filter. event", zzb2.name);
                return null;
            }
            hashSet.add(zzc.aoj);
        }
        ArrayMap arrayMap = new ArrayMap();
        for (com.google.android.gms.internal.zzup.zzc zzc2 : zzb2.aoK) {
            if (hashSet.contains(zzc2.name)) {
                if (zzc2.aoO != null) {
                    arrayMap.put(zzc2.name, zzc2.aoO);
                } else if (zzc2.anT != null) {
                    arrayMap.put(zzc2.name, zzc2.anT);
                } else if (zzc2.zr != null) {
                    arrayMap.put(zzc2.name, zzc2.zr);
                } else {
                    zzbsz().zzbtt().zze("Unknown value for param. event, param", zzb2.name, zzc2.name);
                    return null;
                }
            }
        }
        for (com.google.android.gms.internal.zzun.zzc zzc3 : zzb.aoc) {
            boolean equals = Boolean.TRUE.equals(zzc3.aoi);
            String str = zzc3.aoj;
            if (TextUtils.isEmpty(str)) {
                zzbsz().zzbtt().zzj("Event has empty param name. event", zzb2.name);
                return null;
            }
            Object obj = arrayMap.get(str);
            if (obj instanceof Long) {
                if (zzc3.aoh == null) {
                    zzbsz().zzbtt().zze("No number filter for long param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean zzbj2 = new zzs(zzc3.aoh).zzbj(((Long) obj).longValue());
                if (zzbj2 == null) {
                    return null;
                }
                if ((!zzbj2.booleanValue()) ^ equals) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (zzc3.aoh == null) {
                    zzbsz().zzbtt().zze("No number filter for double param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean zzj = new zzs(zzc3.aoh).zzj(((Double) obj).doubleValue());
                if (zzj == null) {
                    return null;
                }
                if ((!zzj.booleanValue()) ^ equals) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (zzc3.aog == null) {
                    zzbsz().zzbtt().zze("No string filter for String param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean zzmj = new zzag(zzc3.aog).zzmj((String) obj);
                if (zzmj == null) {
                    return null;
                }
                if ((!zzmj.booleanValue()) ^ equals) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                zzbsz().zzbty().zze("Missing param for filter. event, param", zzb2.name, str);
                return Boolean.valueOf(false);
            } else {
                zzbsz().zzbtt().zze("Unknown param type. event, param", zzb2.name, str);
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private Boolean zza(zze zze, zzg zzg) {
        Boolean bool = null;
        com.google.android.gms.internal.zzun.zzc zzc = zze.aor;
        if (zzc == null) {
            zzbsz().zzbtt().zzj("Missing property filter. property", zzg.name);
            return bool;
        }
        boolean equals = Boolean.TRUE.equals(zzc.aoi);
        if (zzg.aoO != null) {
            if (zzc.aoh != null) {
                return zza(new zzs(zzc.aoh).zzbj(zzg.aoO.longValue()), equals);
            }
            zzbsz().zzbtt().zzj("No number filter for long property. property", zzg.name);
            return bool;
        } else if (zzg.anT != null) {
            if (zzc.aoh != null) {
                return zza(new zzs(zzc.aoh).zzj(zzg.anT.doubleValue()), equals);
            }
            zzbsz().zzbtt().zzj("No number filter for double property. property", zzg.name);
            return bool;
        } else if (zzg.zr == null) {
            zzbsz().zzbtt().zzj("User property has no value, property", zzg.name);
            return bool;
        } else if (zzc.aog != null) {
            return zza(new zzag(zzc.aog).zzmj(zzg.zr), equals);
        } else {
            if (zzc.aoh == null) {
                zzbsz().zzbtt().zzj("No string or number filter defined. property", zzg.name);
                return bool;
            }
            zzs zzs = new zzs(zzc.aoh);
            if (zzc.aoh.aol == null || !zzc.aoh.aol.booleanValue()) {
                if (zzle(zzg.zr)) {
                    try {
                        return zza(zzs.zzbj(Long.parseLong(zzg.zr)), equals);
                    } catch (NumberFormatException e) {
                        zzbsz().zzbtt().zze("User property value exceeded Long value range. property, value", zzg.name, zzg.zr);
                        return bool;
                    }
                } else {
                    zzbsz().zzbtt().zze("Invalid user property value for Long number filter. property, value", zzg.name, zzg.zr);
                    return bool;
                }
            } else if (zzlf(zzg.zr)) {
                try {
                    double parseDouble = Double.parseDouble(zzg.zr);
                    if (!Double.isInfinite(parseDouble)) {
                        return zza(zzs.zzj(parseDouble), equals);
                    }
                    zzbsz().zzbtt().zze("User property value exceeded Double value range. property, value", zzg.name, zzg.zr);
                    return bool;
                } catch (NumberFormatException e2) {
                    zzbsz().zzbtt().zze("User property value exceeded Double value range. property, value", zzg.name, zzg.zr);
                    return bool;
                }
            } else {
                zzbsz().zzbtt().zze("Invalid user property value for Double number filter. property, value", zzg.name, zzg.zr);
                return bool;
            }
        }
    }

    static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zza(String str, zza[] zzaArr) {
        zzb[] zzbArr;
        zze[] zzeArr;
        com.google.android.gms.internal.zzun.zzc[] zzcArr;
        zzab.zzaa(zzaArr);
        for (zza zza : zzaArr) {
            for (zzb zzb : zza.anY) {
                String str2 = (String) AppMeasurement.zza.ajb.get(zzb.aob);
                if (str2 != null) {
                    zzb.aob = str2;
                }
                for (com.google.android.gms.internal.zzun.zzc zzc : zzb.aoc) {
                    String str3 = (String) zzd.ajc.get(zzc.aoj);
                    if (str3 != null) {
                        zzc.aoj = str3;
                    }
                }
            }
            for (zze zze : zza.anX) {
                String str4 = (String) AppMeasurement.zze.ajd.get(zze.aoq);
                if (str4 != null) {
                    zze.aoq = str4;
                }
            }
        }
        zzbsu().zzb(str, zzaArr);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public zzup.zza[] zza(String str, zzup.zzb[] zzbArr, zzg[] zzgArr) {
        Map map;
        zze zze;
        zzi zzbtn;
        Map map2;
        zzab.zzhs(str);
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Map zzls = zzbsu().zzls(str);
        if (zzls != null) {
            for (Integer intValue : zzls.keySet()) {
                int intValue2 = intValue.intValue();
                zzf zzf = (zzf) zzls.get(Integer.valueOf(intValue2));
                BitSet bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue2));
                BitSet bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue2));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    arrayMap2.put(Integer.valueOf(intValue2), bitSet);
                    bitSet2 = new BitSet();
                    arrayMap3.put(Integer.valueOf(intValue2), bitSet2);
                }
                for (int i = 0; i < zzf.apq.length * 64; i++) {
                    if (zzal.zza(zzf.apq, i)) {
                        zzbsz().zzbty().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (zzal.zza(zzf.apr, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                zzup.zza zza = new zzup.zza();
                arrayMap.put(Integer.valueOf(intValue2), zza);
                zza.aoI = Boolean.valueOf(false);
                zza.aoH = zzf;
                zza.aoG = new zzf();
                zza.aoG.apr = zzal.zza(bitSet);
                zza.aoG.apq = zzal.zza(bitSet2);
            }
        }
        if (zzbArr != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            int length = zzbArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                zzup.zzb zzb = zzbArr[i3];
                zzi zzaq = zzbsu().zzaq(str, zzb.name);
                if (zzaq == null) {
                    zzbsz().zzbtt().zzj("Event aggregate wasn't created during raw event logging. event", zzb.name);
                    zzbtn = new zzi(str, zzb.name, 1, 1, zzb.aoL.longValue());
                } else {
                    zzbtn = zzaq.zzbtn();
                }
                zzbsu().zza(zzbtn);
                long j = zzbtn.ajZ;
                Map map3 = (Map) arrayMap4.get(zzb.name);
                if (map3 == null) {
                    Map zzat = zzbsu().zzat(str, zzb.name);
                    if (zzat == null) {
                        zzat = new ArrayMap();
                    }
                    arrayMap4.put(zzb.name, zzat);
                    map2 = zzat;
                } else {
                    map2 = map3;
                }
                zzbsz().zzbty().zze("event, affected audience count", zzb.name, Integer.valueOf(map2.size()));
                for (Integer intValue3 : map2.keySet()) {
                    int intValue4 = intValue3.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        zzbsz().zzbty().zzj("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        BitSet bitSet3 = (BitSet) arrayMap2.get(Integer.valueOf(intValue4));
                        BitSet bitSet4 = (BitSet) arrayMap3.get(Integer.valueOf(intValue4));
                        if (((zzup.zza) arrayMap.get(Integer.valueOf(intValue4))) == null) {
                            zzup.zza zza2 = new zzup.zza();
                            arrayMap.put(Integer.valueOf(intValue4), zza2);
                            zza2.aoI = Boolean.valueOf(true);
                            bitSet3 = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue4), bitSet3);
                            bitSet4 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue4), bitSet4);
                        }
                        for (zzb zzb2 : (List) map2.get(Integer.valueOf(intValue4))) {
                            if (zzbsz().zzaz(2)) {
                                zzbsz().zzbty().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue4), zzb2.aoa, zzb2.aob);
                                zzbsz().zzbty().zzj("Filter definition", zzal.zza(zzb2));
                            }
                            if (zzb2.aoa == null || zzb2.aoa.intValue() > 256) {
                                zzbsz().zzbtt().zzj("Invalid event filter ID. id", String.valueOf(zzb2.aoa));
                            } else if (bitSet3.get(zzb2.aoa.intValue())) {
                                zzbsz().zzbty().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), zzb2.aoa);
                            } else {
                                Boolean zza3 = zza(zzb2, zzb, j);
                                zzbsz().zzbty().zzj("Event filter result", zza3 == 0 ? "null" : zza3);
                                if (zza3 == 0) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet4.set(zzb2.aoa.intValue());
                                    if (zza3.booleanValue()) {
                                        bitSet3.set(zzb2.aoa.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        if (zzgArr != null) {
            ArrayMap arrayMap5 = new ArrayMap();
            for (zzg zzg : zzgArr) {
                Map map4 = (Map) arrayMap5.get(zzg.name);
                if (map4 == null) {
                    Map zzau = zzbsu().zzau(str, zzg.name);
                    if (zzau == null) {
                        zzau = new ArrayMap();
                    }
                    arrayMap5.put(zzg.name, zzau);
                    map = zzau;
                } else {
                    map = map4;
                }
                zzbsz().zzbty().zze("property, affected audience count", zzg.name, Integer.valueOf(map.size()));
                for (Integer intValue5 : map.keySet()) {
                    int intValue6 = intValue5.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue6))) {
                        zzbsz().zzbty().zzj("Skipping failed audience ID", Integer.valueOf(intValue6));
                    } else {
                        BitSet bitSet5 = (BitSet) arrayMap2.get(Integer.valueOf(intValue6));
                        BitSet bitSet6 = (BitSet) arrayMap3.get(Integer.valueOf(intValue6));
                        if (((zzup.zza) arrayMap.get(Integer.valueOf(intValue6))) == null) {
                            zzup.zza zza4 = new zzup.zza();
                            arrayMap.put(Integer.valueOf(intValue6), zza4);
                            zza4.aoI = Boolean.valueOf(true);
                            bitSet5 = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue6), bitSet5);
                            bitSet6 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue6), bitSet6);
                        }
                        Iterator it = ((List) map.get(Integer.valueOf(intValue6))).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            zze = (zze) it.next();
                            if (zzbsz().zzaz(2)) {
                                zzbsz().zzbty().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue6), zze.aoa, zze.aoq);
                                zzbsz().zzbty().zzj("Filter definition", zzal.zza(zze));
                            }
                            if (zze.aoa == null || zze.aoa.intValue() > 256) {
                                zzbsz().zzbtt().zzj("Invalid property filter ID. id", String.valueOf(zze.aoa));
                                hashSet.add(Integer.valueOf(intValue6));
                            } else if (bitSet5.get(zze.aoa.intValue())) {
                                zzbsz().zzbty().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue6), zze.aoa);
                            } else {
                                Boolean zza5 = zza(zze, zzg);
                                zzbsz().zzbty().zzj("Property filter result", zza5 == 0 ? "null" : zza5);
                                if (zza5 == 0) {
                                    hashSet.add(Integer.valueOf(intValue6));
                                } else {
                                    bitSet6.set(zze.aoa.intValue());
                                    if (zza5.booleanValue()) {
                                        bitSet5.set(zze.aoa.intValue());
                                    }
                                }
                            }
                        }
                        zzbsz().zzbtt().zzj("Invalid property filter ID. id", String.valueOf(zze.aoa));
                        hashSet.add(Integer.valueOf(intValue6));
                    }
                }
            }
        }
        zzup.zza[] zzaArr = new zzup.zza[arrayMap2.size()];
        int i4 = 0;
        for (Integer intValue7 : arrayMap2.keySet()) {
            int intValue8 = intValue7.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue8))) {
                zzup.zza zza6 = (zzup.zza) arrayMap.get(Integer.valueOf(intValue8));
                if (zza6 == null) {
                    zza6 = new zzup.zza();
                }
                zzup.zza zza7 = zza6;
                int i5 = i4 + 1;
                zzaArr[i4] = zza7;
                zza7.anW = Integer.valueOf(intValue8);
                zza7.aoG = new zzf();
                zza7.aoG.apr = zzal.zza((BitSet) arrayMap2.get(Integer.valueOf(intValue8)));
                zza7.aoG.apq = zzal.zza((BitSet) arrayMap3.get(Integer.valueOf(intValue8)));
                zzbsu().zza(str, intValue8, zza7.aoG);
                i4 = i5;
            }
        }
        return (zzup.zza[]) Arrays.copyOf(zzaArr, i4);
    }

    /* access modifiers changed from: 0000 */
    public boolean zzle(String str) {
        return Pattern.matches("[+-]?[0-9]+", str);
    }

    /* access modifiers changed from: 0000 */
    public boolean zzlf(String str) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", str);
    }

    /* access modifiers changed from: protected */
    public void zzwv() {
    }
}
