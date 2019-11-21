package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaja.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzahi implements Iterable<Entry<zzahr, zzakm>> {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzahi.class.desiredAssertionStatus());
    private static final zzahi aTh = new zzahi(new zzaja(null));
    private final zzaja<zzakm> aTi;

    private zzahi(zzaja<zzakm> zzaja) {
        this.aTi = zzaja;
    }

    private zzakm zza(zzahr zzahr, zzaja<zzakm> zzaja, zzakm zzakm) {
        zzakm zza;
        zzakm zzakm2;
        if (zzaja.getValue() != null) {
            return zzakm.zzl(zzahr, (zzakm) zzaja.getValue());
        }
        zzakm zzakm3 = null;
        Iterator it = zzaja.zzcsx().iterator();
        zzakm zzakm4 = zzakm;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzaja zzaja2 = (zzaja) entry.getValue();
            zzaka zzaka = (zzaka) entry.getKey();
            if (!zzaka.zzcut()) {
                zza = zza(zzahr.zza(zzaka), zzaja2, zzakm4);
                zzakm2 = zzakm3;
            } else if ($assertionsDisabled || zzaja2.getValue() != null) {
                zzakm2 = (zzakm) zzaja2.getValue();
                zza = zzakm4;
            } else {
                throw new AssertionError("Priority writes must always be leaf nodes");
            }
            zzakm3 = zzakm2;
            zzakm4 = zza;
        }
        return (zzakm4.zzao(zzahr).isEmpty() || zzakm3 == null) ? zzakm4 : zzakm4.zzl(zzahr.zza(zzaka.zzcur()), zzakm3);
    }

    public static zzahi zzbx(Map<String, Object> map) {
        zzaja zzcsw = zzaja.zzcsw();
        Iterator it = map.entrySet().iterator();
        while (true) {
            zzaja zzaja = zzcsw;
            if (!it.hasNext()) {
                return new zzahi(zzaja);
            }
            Entry entry = (Entry) it.next();
            zzcsw = zzaja.zza(new zzahr((String) entry.getKey()), new zzaja<>(zzakn.zzbs(entry.getValue())));
        }
    }

    public static zzahi zzby(Map<zzahr, zzakm> map) {
        zzaja zzcsw = zzaja.zzcsw();
        Iterator it = map.entrySet().iterator();
        while (true) {
            zzaja zzaja = zzcsw;
            if (!it.hasNext()) {
                return new zzahi(zzaja);
            }
            Entry entry = (Entry) it.next();
            zzcsw = zzaja.zza((zzahr) entry.getKey(), new zzaja<>((zzakm) entry.getValue()));
        }
    }

    public static zzahi zzcpv() {
        return aTh;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return ((zzahi) obj).zzcs(true).equals(zzcs(true));
    }

    public int hashCode() {
        return zzcs(true).hashCode();
    }

    public boolean isEmpty() {
        return this.aTi.isEmpty();
    }

    public Iterator<Entry<zzahr, zzakm>> iterator() {
        return this.aTi.iterator();
    }

    public String toString() {
        String valueOf = String.valueOf(zzcs(true).toString());
        return new StringBuilder(String.valueOf(valueOf).length() + 15).append("CompoundWrite{").append(valueOf).append("}").toString();
    }

    public zzahi zza(zzaka zzaka, zzakm zzakm) {
        return zze(new zzahr(zzaka), zzakm);
    }

    public zzahi zzb(final zzahr zzahr, zzahi zzahi) {
        return (zzahi) zzahi.aTi.zzb(this, (zza<? super T, R>) new zza<zzakm, zzahi>() {
            public zzahi zza(zzahr zzahr, zzakm zzakm, zzahi zzahi) {
                return zzahi.zze(zzahr.zzh(zzahr), zzakm);
            }
        });
    }

    public zzakm zzb(zzakm zzakm) {
        return zza(zzahr.zzcqy(), this.aTi, zzakm);
    }

    public zzakm zzcpw() {
        return (zzakm) this.aTi.getValue();
    }

    public List<zzakl> zzcpx() {
        ArrayList arrayList = new ArrayList();
        if (this.aTi.getValue() != null) {
            for (zzakl zzakl : (zzakm) this.aTi.getValue()) {
                arrayList.add(new zzakl(zzakl.zzcvs(), zzakl.zzcmq()));
            }
        } else {
            Iterator it = this.aTi.zzcsx().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                zzaja zzaja = (zzaja) entry.getValue();
                if (zzaja.getValue() != null) {
                    arrayList.add(new zzakl((zzaka) entry.getKey(), (zzakm) zzaja.getValue()));
                }
            }
        }
        return arrayList;
    }

    public Map<zzaka, zzahi> zzcpy() {
        HashMap hashMap = new HashMap();
        Iterator it = this.aTi.zzcsx().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            hashMap.put((zzaka) entry.getKey(), new zzahi((zzaja) entry.getValue()));
        }
        return hashMap;
    }

    public Map<String, Object> zzcs(final boolean z) {
        final HashMap hashMap = new HashMap();
        this.aTi.zza(new zza<zzakm, Void>() {
            public Void zza(zzahr zzahr, zzakm zzakm, Void voidR) {
                hashMap.put(zzahr.zzcqz(), zzakm.getValue(z));
                return null;
            }
        });
        return hashMap;
    }

    public zzahi zzd(zzahr zzahr) {
        return zzahr.isEmpty() ? aTh : new zzahi(this.aTi.zza(zzahr, zzaja.zzcsw()));
    }

    public zzahi zze(zzahr zzahr, zzakm zzakm) {
        if (zzahr.isEmpty()) {
            return new zzahi(new zzaja(zzakm));
        }
        zzahr zzag = this.aTi.zzag(zzahr);
        if (zzag != null) {
            zzahr zza = zzahr.zza(zzag, zzahr);
            zzakm zzakm2 = (zzakm) this.aTi.zzak(zzag);
            zzaka zzcre = zza.zzcre();
            if (zzcre != null && zzcre.zzcut() && zzakm2.zzao(zza.zzcrd()).isEmpty()) {
                return this;
            }
            return new zzahi(this.aTi.zzb(zzag, zzakm2.zzl(zza, zzakm)));
        }
        return new zzahi(this.aTi.zza(zzahr, new zzaja<>(zzakm)));
    }

    public boolean zze(zzahr zzahr) {
        return zzf(zzahr) != null;
    }

    public zzakm zzf(zzahr zzahr) {
        zzahr zzag = this.aTi.zzag(zzahr);
        if (zzag != null) {
            return ((zzakm) this.aTi.zzak(zzag)).zzao(zzahr.zza(zzag, zzahr));
        }
        return null;
    }

    public zzahi zzg(zzahr zzahr) {
        if (zzahr.isEmpty()) {
            return this;
        }
        zzakm zzf = zzf(zzahr);
        return zzf != null ? new zzahi(new zzaja(zzf)) : new zzahi(this.aTi.zzai(zzahr));
    }
}
