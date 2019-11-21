package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class zzaik implements zzahn {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaik.class.desiredAssertionStatus());
    private static zzaik aWl = new zzaik();
    final HashMap<zzahm, List<zzahm>> aWk = new HashMap<>();

    private zzaik() {
    }

    public static zzaik zzcsd() {
        return aWl;
    }

    private void zzj(zzahm zzahm) {
        boolean z;
        boolean z2;
        int i = 0;
        synchronized (this.aWk) {
            List list = (List) this.aWk.get(zzahm);
            if (list != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z2 = false;
                        break;
                    } else if (list.get(i2) == zzahm) {
                        z2 = true;
                        list.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (list.isEmpty()) {
                    this.aWk.remove(zzahm);
                }
                z = z2;
            } else {
                z = false;
            }
            if (!$assertionsDisabled && !z && zzahm.zzcqv()) {
                throw new AssertionError();
            } else if (!zzahm.zzcpu().isDefault()) {
                zzahm zza = zzahm.zza(zzajm.zzan(zzahm.zzcpu().zzcmu()));
                List list2 = (List) this.aWk.get(zza);
                if (list2 != null) {
                    while (true) {
                        if (i >= list2.size()) {
                            break;
                        } else if (list2.get(i) == zzahm) {
                            list2.remove(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (list2.isEmpty()) {
                        this.aWk.remove(zza);
                    }
                }
            }
        }
    }

    public void zzd(zzahm zzahm) {
        zzj(zzahm);
    }

    public void zzi(zzahm zzahm) {
        synchronized (this.aWk) {
            List list = (List) this.aWk.get(zzahm);
            if (list == null) {
                list = new ArrayList();
                this.aWk.put(zzahm, list);
            }
            list.add(zzahm);
            if (!zzahm.zzcpu().isDefault()) {
                zzahm zza = zzahm.zza(zzajm.zzan(zzahm.zzcpu().zzcmu()));
                List list2 = (List) this.aWk.get(zza);
                if (list2 == null) {
                    list2 = new ArrayList();
                    this.aWk.put(zza, list2);
                }
                list2.add(zzahm);
            }
            zzahm.zzct(true);
            zzahm.zza((zzahn) this);
        }
    }

    public void zzk(zzahm zzahm) {
        synchronized (this.aWk) {
            List list = (List) this.aWk.get(zzahm);
            if (list != null && !list.isEmpty()) {
                if (zzahm.zzcpu().isDefault()) {
                    HashSet hashSet = new HashSet();
                    for (int size = list.size() - 1; size >= 0; size--) {
                        zzahm zzahm2 = (zzahm) list.get(size);
                        if (!hashSet.contains(zzahm2.zzcpu())) {
                            hashSet.add(zzahm2.zzcpu());
                            zzahm2.zzcqt();
                        }
                    }
                } else {
                    ((zzahm) list.get(0)).zzcqt();
                }
            }
        }
    }
}
