package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class zzaii {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaii.class.desiredAssertionStatus());
    private static final zzajb<zzaif> aWd = new zzajb<zzaif>() {
        /* renamed from: zza */
        public boolean zzbr(zzaif zzaif) {
            return zzaif.isVisible();
        }
    };
    private zzahi aWa = zzahi.zzcpv();
    private List<zzaif> aWb = new ArrayList();
    private Long aWc = Long.valueOf(-1);

    private static zzahi zza(List<zzaif> list, zzajb<zzaif> zzajb, zzahr zzahr) {
        zzahi zzcpv = zzahi.zzcpv();
        Iterator it = list.iterator();
        while (true) {
            zzahi zzahi = zzcpv;
            if (!it.hasNext()) {
                return zzahi;
            }
            zzaif zzaif = (zzaif) it.next();
            if (zzajb.zzbr(zzaif)) {
                zzahr zzcmu = zzaif.zzcmu();
                if (zzaif.zzcry()) {
                    if (zzahr.zzi(zzcmu)) {
                        zzahi = zzahi.zze(zzahr.zza(zzahr, zzcmu), zzaif.zzcrw());
                    } else if (zzcmu.zzi(zzahr)) {
                        zzahi = zzahi.zze(zzahr.zzcqy(), zzaif.zzcrw().zzao(zzahr.zza(zzcmu, zzahr)));
                    }
                } else if (zzahr.zzi(zzcmu)) {
                    zzahi = zzahi.zzb(zzahr.zza(zzahr, zzcmu), zzaif.zzcrx());
                } else if (zzcmu.zzi(zzahr)) {
                    zzahr zza = zzahr.zza(zzcmu, zzahr);
                    if (zza.isEmpty()) {
                        zzahi = zzahi.zzb(zzahr.zzcqy(), zzaif.zzcrx());
                    } else {
                        zzakm zzf = zzaif.zzcrx().zzf(zza);
                        if (zzf != null) {
                            zzahi = zzahi.zze(zzahr.zzcqy(), zzf);
                        }
                    }
                }
            }
            zzcpv = zzahi;
        }
    }

    private boolean zza(zzaif zzaif, zzahr zzahr) {
        if (zzaif.zzcry()) {
            return zzaif.zzcmu().zzi(zzahr);
        }
        Iterator it = zzaif.zzcrx().iterator();
        while (it.hasNext()) {
            if (zzaif.zzcmu().zzh((zzahr) ((Entry) it.next()).getKey()).zzi(zzahr)) {
                return true;
            }
        }
        return false;
    }

    private void zzcsc() {
        this.aWa = zza(this.aWb, aWd, zzahr.zzcqy());
        if (this.aWb.size() > 0) {
            this.aWc = Long.valueOf(((zzaif) this.aWb.get(this.aWb.size() - 1)).zzcrv());
        } else {
            this.aWc = Long.valueOf(-1);
        }
    }

    public zzakl zza(zzahr zzahr, zzakm zzakm, zzakl zzakl, boolean z, zzakg zzakg) {
        zzakl zzakl2 = null;
        zzahi zzg = this.aWa.zzg(zzahr);
        zzakm<zzakl> zzf = zzg.zzf(zzahr.zzcqy());
        if (zzf == null) {
            if (zzakm != null) {
                zzf = zzg.zzb(zzakm);
            }
            return zzakl2;
        }
        for (zzakl zzakl3 : zzf) {
            if (zzakg.zza(zzakl3, zzakl, z) <= 0 || (zzakl2 != null && zzakg.zza(zzakl3, zzakl2, z) >= 0)) {
                zzakl3 = zzakl2;
            }
            zzakl2 = zzakl3;
        }
        return zzakl2;
    }

    public zzakm zza(zzahr zzahr, zzahr zzahr2, zzakm zzakm, zzakm zzakm2) {
        if (!$assertionsDisabled && zzakm == null && zzakm2 == null) {
            throw new AssertionError("Either existingEventSnap or existingServerSnap must exist");
        }
        zzahr zzh = zzahr.zzh(zzahr2);
        if (this.aWa.zze(zzh)) {
            return null;
        }
        zzahi zzg = this.aWa.zzg(zzh);
        return zzg.isEmpty() ? zzakm2.zzao(zzahr2) : zzg.zzb(zzakm2.zzao(zzahr2));
    }

    public zzakm zza(zzahr zzahr, zzaka zzaka, zzaje zzaje) {
        zzahr zza = zzahr.zza(zzaka);
        zzakm zzf = this.aWa.zzf(zza);
        if (zzf != null) {
            return zzf;
        }
        if (zzaje.zzf(zzaka)) {
            return this.aWa.zzg(zza).zzb(zzaje.zzcmq().zzm(zzaka));
        }
        return null;
    }

    public zzakm zza(final zzahr zzahr, zzakm zzakm, final List<Long> list, final boolean z) {
        if (!list.isEmpty() || z) {
            zzahi zzg = this.aWa.zzg(zzahr);
            if (!z && zzg.isEmpty()) {
                return zzakm;
            }
            if (!z && zzakm == null && !zzg.zze(zzahr.zzcqy())) {
                return null;
            }
            zzahi zza = zza(this.aWb, (zzajb<zzaif>) new zzajb<zzaif>() {
                /* renamed from: zza */
                public boolean zzbr(zzaif zzaif) {
                    return (zzaif.isVisible() || z) && !list.contains(Long.valueOf(zzaif.zzcrv())) && (zzaif.zzcmu().zzi(zzahr) || zzahr.zzi(zzaif.zzcmu()));
                }
            }, zzahr);
            if (zzakm == null) {
                zzakm = zzakf.zzcvi();
            }
            return zza.zzb(zzakm);
        }
        zzakm zzf = this.aWa.zzf(zzahr);
        if (zzf != null) {
            return zzf;
        }
        zzahi zzg2 = this.aWa.zzg(zzahr);
        if (zzg2.isEmpty()) {
            return zzakm;
        }
        if (zzakm == null && !zzg2.zze(zzahr.zzcqy())) {
            return null;
        }
        if (zzakm == null) {
            zzakm = zzakf.zzcvi();
        }
        return zzg2.zzb(zzakm);
    }

    public void zza(zzahr zzahr, zzahi zzahi, Long l) {
        if ($assertionsDisabled || l.longValue() > this.aWc.longValue()) {
            this.aWb.add(new zzaif(l.longValue(), zzahr, zzahi));
            this.aWa = this.aWa.zzb(zzahr, zzahi);
            this.aWc = l;
            return;
        }
        throw new AssertionError();
    }

    public void zza(zzahr zzahr, zzakm zzakm, Long l, boolean z) {
        if ($assertionsDisabled || l.longValue() > this.aWc.longValue()) {
            this.aWb.add(new zzaif(l.longValue(), zzahr, zzakm, z));
            if (z) {
                this.aWa = this.aWa.zze(zzahr, zzakm);
            }
            this.aWc = l;
            return;
        }
        throw new AssertionError();
    }

    public zzaif zzcg(long j) {
        for (zzaif zzaif : this.aWb) {
            if (zzaif.zzcrv() == j) {
                return zzaif;
            }
        }
        return null;
    }

    public boolean zzch(long j) {
        boolean z;
        boolean z2;
        zzaif zzaif = null;
        Iterator it = this.aWb.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzaif zzaif2 = (zzaif) it.next();
            if (zzaif2.zzcrv() == j) {
                zzaif = zzaif2;
                break;
            }
            i++;
        }
        if ($assertionsDisabled || zzaif != null) {
            this.aWb.remove(zzaif);
            boolean isVisible = zzaif.isVisible();
            int size = this.aWb.size() - 1;
            boolean z3 = false;
            while (isVisible && size >= 0) {
                zzaif zzaif3 = (zzaif) this.aWb.get(size);
                if (zzaif3.isVisible()) {
                    if (size >= i && zza(zzaif3, zzaif.zzcmu())) {
                        z = z3;
                        z2 = false;
                        size--;
                        isVisible = z2;
                        z3 = z;
                    } else if (zzaif.zzcmu().zzi(zzaif3.zzcmu())) {
                        z = true;
                        z2 = isVisible;
                        size--;
                        isVisible = z2;
                        z3 = z;
                    }
                }
                z = z3;
                z2 = isVisible;
                size--;
                isVisible = z2;
                z3 = z;
            }
            if (!isVisible) {
                return false;
            }
            if (z3) {
                zzcsc();
                return true;
            } else if (zzaif.zzcry()) {
                this.aWa = this.aWa.zzd(zzaif.zzcmu());
                return true;
            } else {
                Iterator it2 = zzaif.zzcrx().iterator();
                while (it2.hasNext()) {
                    this.aWa = this.aWa.zzd(zzaif.zzcmu().zzh((zzahr) ((Entry) it2.next()).getKey()));
                }
                return true;
            }
        } else {
            throw new AssertionError("removeWrite called with nonexistent writeId");
        }
    }

    public List<zzaif> zzcsb() {
        ArrayList arrayList = new ArrayList(this.aWb);
        this.aWa = zzahi.zzcpv();
        this.aWb = new ArrayList();
        return arrayList;
    }

    public zzakm zzj(zzahr zzahr, zzakm zzakm) {
        zzakm zzakm2;
        zzakm zzcvi = zzakf.zzcvi();
        zzakm zzf = this.aWa.zzf(zzahr);
        if (zzf == null) {
            zzahi zzg = this.aWa.zzg(zzahr);
            Iterator it = zzakm.iterator();
            while (true) {
                zzakm2 = zzcvi;
                if (!it.hasNext()) {
                    break;
                }
                zzakl zzakl = (zzakl) it.next();
                zzcvi = zzakm2.zze(zzakl.zzcvs(), zzg.zzg(new zzahr(zzakl.zzcvs())).zzb(zzakl.zzcmq()));
            }
            for (zzakl zzakl2 : zzg.zzcpx()) {
                zzakm2 = zzakm2.zze(zzakl2.zzcvs(), zzakl2.zzcmq());
            }
            return zzakm2;
        } else if (zzf.zzcuw()) {
            return zzcvi;
        } else {
            Iterator it2 = zzf.iterator();
            while (true) {
                zzakm zzakm3 = zzcvi;
                if (!it2.hasNext()) {
                    return zzakm3;
                }
                zzakl zzakl3 = (zzakl) it2.next();
                zzcvi = zzakm3.zze(zzakl3.zzcvs(), zzakl3.zzcmq());
            }
        }
    }

    public zzaij zzu(zzahr zzahr) {
        return new zzaij(zzahr, this);
    }

    public zzakm zzv(zzahr zzahr) {
        return this.aWa.zzf(zzahr);
    }
}
