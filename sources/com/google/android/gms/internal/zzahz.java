package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class zzahz {
    private zzakm aVg = null;
    private Map<zzaka, zzahz> aVh = null;

    public interface zza {
        void zza(zzaka zzaka, zzahz zzahz);
    }

    public interface zzb {
        void zzf(zzahr zzahr, zzakm zzakm);
    }

    public void zza(final zzahr zzahr, final zzb zzb2) {
        if (this.aVg != null) {
            zzb2.zzf(zzahr, this.aVg);
        } else {
            zza(new zza() {
                public void zza(zzaka zzaka, zzahz zzahz) {
                    zzahz.zza(zzahr.zza(zzaka), zzb2);
                }
            });
        }
    }

    public void zza(zza zza2) {
        if (this.aVh != null) {
            for (Entry entry : this.aVh.entrySet()) {
                zza2.zza((zzaka) entry.getKey(), (zzahz) entry.getValue());
            }
        }
    }

    public void zzh(zzahr zzahr, zzakm zzakm) {
        if (zzahr.isEmpty()) {
            this.aVg = zzakm;
            this.aVh = null;
        } else if (this.aVg != null) {
            this.aVg = this.aVg.zzl(zzahr, zzakm);
        } else {
            if (this.aVh == null) {
                this.aVh = new HashMap();
            }
            zzaka zzcrb = zzahr.zzcrb();
            if (!this.aVh.containsKey(zzcrb)) {
                this.aVh.put(zzcrb, new zzahz());
            }
            ((zzahz) this.aVh.get(zzcrb)).zzh(zzahr.zzcrc(), zzakm);
        }
    }

    public boolean zzr(final zzahr zzahr) {
        if (zzahr.isEmpty()) {
            this.aVg = null;
            this.aVh = null;
            return true;
        } else if (this.aVg != null) {
            if (this.aVg.zzcuw()) {
                return false;
            }
            zzakb zzakb = (zzakb) this.aVg;
            this.aVg = null;
            zzakb.zza((com.google.android.gms.internal.zzakb.zza) new com.google.android.gms.internal.zzakb.zza() {
                public void zzb(zzaka zzaka, zzakm zzakm) {
                    zzahz.this.zzh(zzahr.zza(zzaka), zzakm);
                }
            });
            return zzr(zzahr);
        } else if (this.aVh == null) {
            return true;
        } else {
            zzaka zzcrb = zzahr.zzcrb();
            zzahr zzcrc = zzahr.zzcrc();
            if (this.aVh.containsKey(zzcrb) && ((zzahz) this.aVh.get(zzcrb)).zzr(zzcrc)) {
                this.aVh.remove(zzcrb);
            }
            if (!this.aVh.isEmpty()) {
                return false;
            }
            this.aVh = null;
            return true;
        }
    }
}
