package com.google.android.gms.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public class zzaib {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaib.class.desiredAssertionStatus());
    /* access modifiers changed from: private */
    public final zzajx aPY;
    /* access modifiers changed from: private */
    public final zzaiv aVm;
    /* access modifiers changed from: private */
    public zzaja<zzaia> aVn = zzaja.zzcsw();
    /* access modifiers changed from: private */
    public final zzaii aVo = new zzaii();
    /* access modifiers changed from: private */
    public final Map<zzaic, zzajm> aVp = new HashMap();
    /* access modifiers changed from: private */
    public final Map<zzajm, zzaic> aVq = new HashMap();
    private final Set<zzajm> aVr = new HashSet();
    /* access modifiers changed from: private */
    public final zzd aVs;
    private long aVt = 1;

    public interface zza {
        List<? extends zzaji> zzb(DatabaseError databaseError);
    }

    private static class zzb extends zzahm {
        private zzajm aTf;

        public zzb(zzajm zzajm) {
            this.aTf = zzajm;
        }

        public boolean equals(Object obj) {
            return (obj instanceof zzb) && ((zzb) obj).aTf.equals(this.aTf);
        }

        public int hashCode() {
            return this.aTf.hashCode();
        }

        public zzahm zza(zzajm zzajm) {
            return new zzb(zzajm);
        }

        public zzajh zza(zzajg zzajg, zzajm zzajm) {
            return null;
        }

        public void zza(zzajh zzajh) {
        }

        public void zza(DatabaseError databaseError) {
        }

        public boolean zza(com.google.android.gms.internal.zzaji.zza zza) {
            return false;
        }

        public boolean zzc(zzahm zzahm) {
            return zzahm instanceof zzb;
        }

        public zzajm zzcpu() {
            return this.aTf;
        }
    }

    private class zzc implements zzagy, zza {
        private final zzajn aVL;
        /* access modifiers changed from: private */
        public final zzaic aVM;

        public zzc(zzajn zzajn) {
            this.aVL = zzajn;
            this.aVM = zzaib.this.zze(zzajn.zzcua());
        }

        public List<? extends zzaji> zzb(DatabaseError databaseError) {
            if (databaseError == null) {
                return this.aVM != null ? zzaib.this.zza(this.aVM) : zzaib.this.zzt(this.aVL.zzcua().zzcmu());
            }
            zzajx zza = zzaib.this.aPY;
            String valueOf = String.valueOf(this.aVL.zzcua().zzcmu());
            String valueOf2 = String.valueOf(databaseError.toString());
            zza.warn(new StringBuilder(String.valueOf(valueOf).length() + 19 + String.valueOf(valueOf2).length()).append("Listen at ").append(valueOf).append(" failed: ").append(valueOf2).toString());
            return zzaib.this.zza(this.aVL.zzcua(), databaseError);
        }

        public String zzcof() {
            return this.aVL.zzcub().zzcuv();
        }

        public boolean zzcog() {
            return zzalj.zzs(this.aVL.zzcub()) > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }

        public zzags zzcoh() {
            zzakc zzh = zzakc.zzh(this.aVL.zzcub());
            List<zzahr> zzcny = zzh.zzcny();
            ArrayList arrayList = new ArrayList(zzcny.size());
            for (zzahr zzcra : zzcny) {
                arrayList.add(zzcra.zzcra());
            }
            return new zzags(arrayList, zzh.zzcnz());
        }
    }

    public interface zzd {
        void zza(zzajm zzajm, zzaic zzaic);

        void zza(zzajm zzajm, zzaic zzaic, zzagy zzagy, zza zza);
    }

    public zzaib(zzahk zzahk, zzaiv zzaiv, zzd zzd2) {
        this.aVs = zzd2;
        this.aVm = zzaiv;
        this.aPY = zzahk.zzrh("SyncTree");
    }

    /* access modifiers changed from: private */
    public List<zzaji> zza(zzaio zzaio) {
        return zza(zzaio, this.aVn, (zzakm) null, this.aVo.zzu(zzahr.zzcqy()));
    }

    private List<zzaji> zza(zzaio zzaio, zzaja<zzaia> zzaja, zzakm zzakm, zzaij zzaij) {
        if (zzaio.zzcmu().isEmpty()) {
            return zzb(zzaio, zzaja, zzakm, zzaij);
        }
        zzaia zzaia = (zzaia) zzaja.getValue();
        if (zzakm == null && zzaia != null) {
            zzakm = zzaia.zzs(zzahr.zzcqy());
        }
        ArrayList arrayList = new ArrayList();
        zzaka zzcrb = zzaio.zzcmu().zzcrb();
        zzaio zzc2 = zzaio.zzc(zzcrb);
        zzaja zzaja2 = (zzaja) zzaja.zzcsx().get(zzcrb);
        if (!(zzaja2 == null || zzc2 == null)) {
            arrayList.addAll(zza(zzc2, zzaja2, zzakm != null ? zzakm.zzm(zzcrb) : null, zzaij.zzb(zzcrb)));
        }
        if (zzaia != null) {
            arrayList.addAll(zzaia.zza(zzaio, zzaij, zzakm));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public List<zzajn> zza(zzaja<zzaia> zzaja) {
        ArrayList arrayList = new ArrayList();
        zza(zzaja, (List<zzajn>) arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public List<? extends zzaji> zza(zzajm zzajm, zzaio zzaio) {
        zzahr zzcmu = zzajm.zzcmu();
        zzaia zzaia = (zzaia) this.aVn.zzak(zzcmu);
        if ($assertionsDisabled || zzaia != null) {
            return zzaia.zza(zzaio, this.aVo.zzu(zzcmu), (zzakm) null);
        }
        throw new AssertionError("Missing sync point for query tag that we're tracking");
    }

    private void zza(zzaja<zzaia> zzaja, List<zzajn> list) {
        zzaia zzaia = (zzaia) zzaja.getValue();
        if (zzaia == null || !zzaia.zzcrq()) {
            if (zzaia != null) {
                list.addAll(zzaia.zzcrp());
            }
            Iterator it = zzaja.zzcsx().iterator();
            while (it.hasNext()) {
                zza((zzaja) ((Entry) it.next()).getValue(), list);
            }
            return;
        }
        list.add(zzaia.zzcrr());
    }

    /* access modifiers changed from: private */
    public void zza(zzajm zzajm, zzajn zzajn) {
        zzahr zzcmu = zzajm.zzcmu();
        zzaic zze = zze(zzajm);
        zzc zzc2 = new zzc(zzajn);
        this.aVs.zza(zzd(zzajm), zze, zzc2, zzc2);
        zzaja zzai = this.aVn.zzai(zzcmu);
        if (zze == null) {
            zzai.zza(new com.google.android.gms.internal.zzaja.zza<zzaia, Void>() {
                public Void zza(zzahr zzahr, zzaia zzaia, Void voidR) {
                    if (zzahr.isEmpty() || !zzaia.zzcrq()) {
                        for (zzajn zzcua : zzaia.zzcrp()) {
                            zzajm zzcua2 = zzcua.zzcua();
                            zzaib.this.aVs.zza(zzaib.this.zzd(zzcua2), zzaib.this.zze(zzcua2));
                        }
                    } else {
                        zzajm zzcua3 = zzaia.zzcrr().zzcua();
                        zzaib.this.aVs.zza(zzaib.this.zzd(zzcua3), zzaib.this.zze(zzcua3));
                    }
                    return null;
                }
            });
        } else if (!$assertionsDisabled && ((zzaia) zzai.getValue()).zzcrq()) {
            throw new AssertionError("If we're adding a query, it shouldn't be shadowed");
        }
    }

    /* access modifiers changed from: private */
    public void zzat(List<zzajm> list) {
        for (zzajm zzajm : list) {
            if (!zzajm.zzctw()) {
                zzaic zze = zze(zzajm);
                if ($assertionsDisabled || zze != null) {
                    this.aVq.remove(zzajm);
                    this.aVp.remove(zze);
                } else {
                    throw new AssertionError();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public zzajm zzb(zzaic zzaic) {
        return (zzajm) this.aVp.get(zzaic);
    }

    /* access modifiers changed from: private */
    public List<zzaji> zzb(zzaio zzaio, zzaja<zzaia> zzaja, zzakm zzakm, zzaij zzaij) {
        zzaia zzaia = (zzaia) zzaja.getValue();
        final zzakm zzakm2 = (zzakm != null || zzaia == null) ? zzakm : zzaia.zzs(zzahr.zzcqy());
        final ArrayList arrayList = new ArrayList();
        final zzaij zzaij2 = zzaij;
        final zzaio zzaio2 = zzaio;
        zzaja.zzcsx().zza(new com.google.android.gms.internal.zzagn.zzb<zzaka, zzaja<zzaia>>() {
            /* renamed from: zza */
            public void zzk(zzaka zzaka, zzaja<zzaia> zzaja) {
                zzakm zzakm = null;
                if (zzakm2 != null) {
                    zzakm = zzakm2.zzm(zzaka);
                }
                zzaij zzb = zzaij2.zzb(zzaka);
                zzaio zzc = zzaio2.zzc(zzaka);
                if (zzc != null) {
                    arrayList.addAll(zzaib.this.zzb(zzc, zzaja, zzakm, zzb));
                }
            }
        });
        if (zzaia != null) {
            arrayList.addAll(zzaia.zza(zzaio, zzaij, zzakm2));
        }
        return arrayList;
    }

    private List<zzaji> zzb(final zzajm zzajm, final zzahm zzahm, final DatabaseError databaseError) {
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<zzaji>>() {
            static final /* synthetic */ boolean $assertionsDisabled = (!zzaib.class.desiredAssertionStatus());

            /* renamed from: zzbvg */
            public List<zzaji> call() {
                boolean z;
                zzahr zzcmu = zzajm.zzcmu();
                zzaia zzaia = (zzaia) zzaib.this.aVn.zzak(zzcmu);
                List<zzaji> arrayList = new ArrayList<>();
                if (zzaia != null && (zzajm.isDefault() || zzaia.zzc(zzajm))) {
                    zzall zza = zzaia.zza(zzajm, zzahm, databaseError);
                    if (zzaia.isEmpty()) {
                        zzaib.this.aVn = zzaib.this.aVn.zzaj(zzcmu);
                    }
                    List<zzajm> list = (List) zza.getFirst();
                    arrayList = (List) zza.zzcwr();
                    boolean z2 = false;
                    for (zzajm zzajm : list) {
                        zzaib.this.aVm.zzh(zzajm);
                        z2 = z2 || zzajm.zzctw();
                    }
                    zzaja zzd = zzaib.this.aVn;
                    boolean z3 = zzd.getValue() != null && ((zzaia) zzd.getValue()).zzcrq();
                    Iterator it = zzcmu.iterator();
                    zzaja zzaja = zzd;
                    while (true) {
                        z = z3;
                        if (!it.hasNext()) {
                            break;
                        }
                        zzaja = zzaja.zze((zzaka) it.next());
                        z3 = z || (zzaja.getValue() != null && ((zzaia) zzaja.getValue()).zzcrq());
                        if (z3) {
                            z = z3;
                            break;
                        } else if (zzaja.isEmpty()) {
                            z = z3;
                            break;
                        }
                    }
                    if (z2 && !z) {
                        zzaja zzai = zzaib.this.aVn.zzai(zzcmu);
                        if (!zzai.isEmpty()) {
                            for (zzajn zzajn : zzaib.this.zza(zzai)) {
                                zzc zzc = new zzc(zzajn);
                                zzaib.this.aVs.zza(zzaib.this.zzd(zzajn.zzcua()), zzc.aVM, zzc, zzc);
                            }
                        }
                    }
                    if (!z && !list.isEmpty() && databaseError == null) {
                        if (z2) {
                            zzaib.this.aVs.zza(zzaib.this.zzd(zzajm), null);
                        } else {
                            for (zzajm zzajm2 : list) {
                                zzaic zza2 = zzaib.this.zze(zzajm2);
                                if ($assertionsDisabled || zza2 != null) {
                                    zzaib.this.aVs.zza(zzaib.this.zzd(zzajm2), zza2);
                                } else {
                                    throw new AssertionError();
                                }
                            }
                        }
                    }
                    zzaib.this.zzat(list);
                }
                return arrayList;
            }
        });
    }

    /* access modifiers changed from: private */
    public zzaic zzcrt() {
        long j = this.aVt;
        this.aVt = 1 + j;
        return new zzaic(j);
    }

    /* access modifiers changed from: private */
    public zzajm zzd(zzajm zzajm) {
        return (!zzajm.zzctw() || zzajm.isDefault()) ? zzajm : zzajm.zzan(zzajm.zzcmu());
    }

    /* access modifiers changed from: private */
    public zzaic zze(zzajm zzajm) {
        return (zzaic) this.aVq.get(zzajm);
    }

    public boolean isEmpty() {
        return this.aVn.isEmpty();
    }

    public List<? extends zzaji> zza(long j, boolean z, boolean z2, zzalg zzalg) {
        final boolean z3 = z2;
        final long j2 = j;
        final boolean z4 = z;
        final zzalg zzalg2 = zzalg;
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            /* renamed from: zzbvg */
            public List<? extends zzaji> call() {
                zzaja zzaja;
                if (z3) {
                    zzaib.this.aVm.zzbv(j2);
                }
                zzaif zzcg = zzaib.this.aVo.zzcg(j2);
                boolean zzch = zzaib.this.aVo.zzch(j2);
                if (zzcg.isVisible() && !z4) {
                    Map zza = zzahx.zza(zzalg2);
                    if (zzcg.zzcry()) {
                        zzaib.this.aVm.zzk(zzcg.zzcmu(), zzahx.zza(zzcg.zzcrw(), zza));
                    } else {
                        zzaib.this.aVm.zzc(zzcg.zzcmu(), zzahx.zza(zzcg.zzcrx(), zza));
                    }
                }
                if (!zzch) {
                    return Collections.emptyList();
                }
                zzaja zzcsw = zzaja.zzcsw();
                if (!zzcg.zzcry()) {
                    Iterator it = zzcg.zzcrx().iterator();
                    while (true) {
                        zzaja = zzcsw;
                        if (!it.hasNext()) {
                            break;
                        }
                        zzcsw = zzaja.zzb((zzahr) ((Entry) it.next()).getKey(), Boolean.valueOf(true));
                    }
                } else {
                    zzaja = zzcsw.zzb(zzahr.zzcqy(), Boolean.valueOf(true));
                }
                return zzaib.this.zza((zzaio) new zzail(zzcg.zzcmu(), zzaja, z4));
            }
        });
    }

    public List<? extends zzaji> zza(zzahr zzahr, zzahi zzahi, zzahi zzahi2, long j, boolean z) {
        final boolean z2 = z;
        final zzahr zzahr2 = zzahr;
        final zzahi zzahi3 = zzahi;
        final long j2 = j;
        final zzahi zzahi4 = zzahi2;
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            /* renamed from: zzbvg */
            public List<? extends zzaji> call() throws Exception {
                if (z2) {
                    zzaib.this.aVm.zza(zzahr2, zzahi3, j2);
                }
                zzaib.this.aVo.zza(zzahr2, zzahi4, Long.valueOf(j2));
                return zzaib.this.zza((zzaio) new zzain(zzaip.aWw, zzahr2, zzahi4));
            }
        });
    }

    public List<? extends zzaji> zza(final zzahr zzahr, final zzakm zzakm, final zzaic zzaic) {
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            /* renamed from: zzbvg */
            public List<? extends zzaji> call() {
                zzajm zza = zzaib.this.zzb(zzaic);
                if (zza == null) {
                    return Collections.emptyList();
                }
                zzahr zza2 = zzahr.zza(zza.zzcmu(), zzahr);
                zzaib.this.aVm.zza(zza2.isEmpty() ? zza : zzajm.zzan(zzahr), zzakm);
                return zzaib.this.zza(zza, (zzaio) new zzaiq(zzaip.zzc(zza.zzctz()), zza2, zzakm));
            }
        });
    }

    public List<? extends zzaji> zza(zzahr zzahr, zzakm zzakm, zzakm zzakm2, long j, boolean z, boolean z2) {
        zzalo.zzb(z || !z2, "We shouldn't be persisting non-visible writes.");
        final boolean z3 = z2;
        final zzahr zzahr2 = zzahr;
        final zzakm zzakm3 = zzakm;
        final long j2 = j;
        final zzakm zzakm4 = zzakm2;
        final boolean z4 = z;
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            /* renamed from: zzbvg */
            public List<? extends zzaji> call() {
                if (z3) {
                    zzaib.this.aVm.zza(zzahr2, zzakm3, j2);
                }
                zzaib.this.aVo.zza(zzahr2, zzakm4, Long.valueOf(j2), z4);
                return !z4 ? Collections.emptyList() : zzaib.this.zza((zzaio) new zzaiq(zzaip.aWw, zzahr2, zzakm4));
            }
        });
    }

    public List<? extends zzaji> zza(zzahr zzahr, List<zzakr> list, zzaic zzaic) {
        zzajm zzb2 = zzb(zzaic);
        if (zzb2 == null) {
            return Collections.emptyList();
        }
        if ($assertionsDisabled || zzahr.equals(zzb2.zzcmu())) {
            zzaia zzaia = (zzaia) this.aVn.zzak(zzb2.zzcmu());
            if ($assertionsDisabled || zzaia != null) {
                zzajn zzb3 = zzaia.zzb(zzb2);
                if ($assertionsDisabled || zzb3 != null) {
                    zzakm zzcub = zzb3.zzcub();
                    Iterator it = list.iterator();
                    while (true) {
                        zzakm zzakm = zzcub;
                        if (!it.hasNext()) {
                            return zza(zzahr, zzakm, zzaic);
                        }
                        zzcub = ((zzakr) it.next()).zzq(zzakm);
                    }
                } else {
                    throw new AssertionError("Missing view for query tag that we're tracking");
                }
            } else {
                throw new AssertionError("Missing sync point for query tag that we're tracking");
            }
        } else {
            throw new AssertionError();
        }
    }

    public List<? extends zzaji> zza(final zzahr zzahr, final Map<zzahr, zzakm> map) {
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            /* renamed from: zzbvg */
            public List<? extends zzaji> call() {
                zzahi zzby = zzahi.zzby(map);
                zzaib.this.aVm.zzd(zzahr, zzby);
                return zzaib.this.zza((zzaio) new zzain(zzaip.aWx, zzahr, zzby));
            }
        });
    }

    public List<? extends zzaji> zza(final zzahr zzahr, final Map<zzahr, zzakm> map, final zzaic zzaic) {
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            /* renamed from: zzbvg */
            public List<? extends zzaji> call() {
                zzajm zza = zzaib.this.zzb(zzaic);
                if (zza == null) {
                    return Collections.emptyList();
                }
                zzahr zza2 = zzahr.zza(zza.zzcmu(), zzahr);
                zzahi zzby = zzahi.zzby(map);
                zzaib.this.aVm.zzd(zzahr, zzby);
                return zzaib.this.zza(zza, (zzaio) new zzain(zzaip.zzc(zza.zzctz()), zza2, zzby));
            }
        });
    }

    public List<? extends zzaji> zza(final zzaic zzaic) {
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            /* renamed from: zzbvg */
            public List<? extends zzaji> call() {
                zzajm zza = zzaib.this.zzb(zzaic);
                if (zza == null) {
                    return Collections.emptyList();
                }
                zzaib.this.aVm.zzi(zza);
                return zzaib.this.zza(zza, (zzaio) new zzaim(zzaip.zzc(zza.zzctz()), zzahr.zzcqy()));
            }
        });
    }

    public List<zzaji> zza(zzajm zzajm, DatabaseError databaseError) {
        return zzb(zzajm, null, databaseError);
    }

    public void zza(zzajm zzajm, boolean z) {
        if (z && !this.aVr.contains(zzajm)) {
            zzg((zzahm) new zzb(zzajm));
            this.aVr.add(zzajm);
        } else if (!z && this.aVr.contains(zzajm)) {
            zzh((zzahm) new zzb(zzajm));
            this.aVr.remove(zzajm);
        }
    }

    public List<? extends zzaji> zzb(zzahr zzahr, List<zzakr> list) {
        zzaia zzaia = (zzaia) this.aVn.zzak(zzahr);
        if (zzaia == null) {
            return Collections.emptyList();
        }
        zzajn zzcrr = zzaia.zzcrr();
        if (zzcrr == null) {
            return Collections.emptyList();
        }
        zzakm zzcub = zzcrr.zzcub();
        Iterator it = list.iterator();
        while (true) {
            zzakm zzakm = zzcub;
            if (!it.hasNext()) {
                return zzi(zzahr, zzakm);
            }
            zzcub = ((zzakr) it.next()).zzq(zzakm);
        }
    }

    public zzakm zzc(zzahr zzahr, List<Long> list) {
        zzakm zzakm;
        zzaja<zzaia> zzaja = this.aVn;
        zzaia zzaia = (zzaia) zzaja.getValue();
        zzakm zzakm2 = null;
        zzahr zzcqy = zzahr.zzcqy();
        zzaja<zzaia> zzaja2 = zzaja;
        zzahr zzahr2 = zzahr;
        while (true) {
            zzaka zzcrb = zzahr2.zzcrb();
            zzahr zzcrc = zzahr2.zzcrc();
            zzahr zza2 = zzcqy.zza(zzcrb);
            zzahr zza3 = zzahr.zza(zza2, zzahr);
            zzaja2 = zzcrb != null ? zzaja2.zze(zzcrb) : zzaja.zzcsw();
            zzaia zzaia2 = (zzaia) zzaja2.getValue();
            zzakm = zzaia2 != null ? zzaia2.zzs(zza3) : zzakm2;
            if (!zzcrc.isEmpty() && zzakm == null) {
                zzakm2 = zzakm;
                zzcqy = zza2;
                zzahr2 = zzcrc;
            }
        }
        return this.aVo.zza(zzahr, zzakm, list, true);
    }

    public List<? extends zzaji> zzcrs() {
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            /* renamed from: zzbvg */
            public List<? extends zzaji> call() throws Exception {
                zzaib.this.aVm.zzcmz();
                if (zzaib.this.aVo.zzcsb().isEmpty()) {
                    return Collections.emptyList();
                }
                return zzaib.this.zza((zzaio) new zzail(zzahr.zzcqy(), new zzaja(Boolean.valueOf(true)), true));
            }
        });
    }

    public List<? extends zzaji> zzg(final zzahm zzahm) {
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            static final /* synthetic */ boolean $assertionsDisabled = (!zzaib.class.desiredAssertionStatus());

            /* renamed from: zzbvg */
            public List<? extends zzaji> call() {
                zzakm zzakm;
                boolean z;
                zzaia zzaia;
                zzaje zzaje;
                zzakm zzakm2;
                boolean z2;
                zzakm zzakm3;
                zzajm zzcpu = zzahm.zzcpu();
                zzahr zzcmu = zzcpu.zzcmu();
                zzakm zzakm4 = null;
                zzahr zzahr = zzcmu;
                zzaja zzd = zzaib.this.aVn;
                boolean z3 = false;
                while (!zzd.isEmpty()) {
                    zzaia zzaia2 = (zzaia) zzd.getValue();
                    if (zzaia2 != null) {
                        if (zzakm4 == null) {
                            zzakm4 = zzaia2.zzs(zzahr);
                        }
                        z2 = z3 || zzaia2.zzcrq();
                        zzakm3 = zzakm4;
                    } else {
                        z2 = z3;
                        zzakm3 = zzakm4;
                    }
                    zzd = zzd.zze(zzahr.isEmpty() ? zzaka.zzrm("") : zzahr.zzcrb());
                    zzahr = zzahr.zzcrc();
                    zzakm4 = zzakm3;
                    z3 = z2;
                }
                zzaia zzaia3 = (zzaia) zzaib.this.aVn.zzak(zzcmu);
                if (zzaia3 == null) {
                    zzaia zzaia4 = new zzaia(zzaib.this.aVm);
                    zzaib.this.aVn = zzaib.this.aVn.zzb(zzcmu, zzaia4);
                    zzaia zzaia5 = zzaia4;
                    zzakm = zzakm4;
                    z = z3;
                    zzaia = zzaia5;
                } else {
                    boolean z4 = z3 || zzaia3.zzcrq();
                    if (zzakm4 == null) {
                        zzakm4 = zzaia3.zzs(zzahr.zzcqy());
                    }
                    zzaia zzaia6 = zzaia3;
                    zzakm = zzakm4;
                    z = z4;
                    zzaia = zzaia6;
                }
                zzaib.this.aVm.zzg(zzcpu);
                if (zzakm != null) {
                    zzaje = new zzaje(zzakh.zza(zzakm, zzcpu.zzcts()), true, false);
                } else {
                    zzaje zzf = zzaib.this.aVm.zzf(zzcpu);
                    if (zzf.zzcsz()) {
                        zzaje = zzf;
                    } else {
                        zzakm zzcvi = zzakf.zzcvi();
                        Iterator it = zzaib.this.aVn.zzai(zzcmu).zzcsx().iterator();
                        while (it.hasNext()) {
                            Entry entry = (Entry) it.next();
                            zzaia zzaia7 = (zzaia) ((zzaja) entry.getValue()).getValue();
                            if (zzaia7 != null) {
                                zzakm zzs = zzaia7.zzs(zzahr.zzcqy());
                                if (zzs != null) {
                                    zzakm2 = zzcvi.zze((zzaka) entry.getKey(), zzs);
                                    zzcvi = zzakm2;
                                }
                            }
                            zzakm2 = zzcvi;
                            zzcvi = zzakm2;
                        }
                        for (zzakl zzakl : zzf.zzcmq()) {
                            if (!zzcvi.zzk(zzakl.zzcvs())) {
                                zzcvi = zzcvi.zze(zzakl.zzcvs(), zzakl.zzcmq());
                            }
                        }
                        zzaje = new zzaje(zzakh.zza(zzcvi, zzcpu.zzcts()), false, false);
                    }
                }
                boolean zzc = zzaia.zzc(zzcpu);
                if (!zzc && !zzcpu.zzctw()) {
                    if ($assertionsDisabled || !zzaib.this.aVq.containsKey(zzcpu)) {
                        zzaic zzf2 = zzaib.this.zzcrt();
                        zzaib.this.aVq.put(zzcpu, zzf2);
                        zzaib.this.aVp.put(zzf2, zzcpu);
                    } else {
                        throw new AssertionError("View does not exist but we have a tag");
                    }
                }
                List<? extends zzaji> zza = zzaia.zza(zzahm, zzaib.this.aVo.zzu(zzcmu), zzaje);
                if (!zzc && !z) {
                    zzaib.this.zza(zzcpu, zzaia.zzb(zzcpu));
                }
                return zza;
            }
        });
    }

    public List<zzaji> zzh(zzahm zzahm) {
        return zzb(zzahm.zzcpu(), zzahm, null);
    }

    public List<? extends zzaji> zzi(final zzahr zzahr, final zzakm zzakm) {
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            /* renamed from: zzbvg */
            public List<? extends zzaji> call() {
                zzaib.this.aVm.zza(zzajm.zzan(zzahr), zzakm);
                return zzaib.this.zza((zzaio) new zzaiq(zzaip.aWx, zzahr, zzakm));
            }
        });
    }

    public List<? extends zzaji> zzt(final zzahr zzahr) {
        return (List) this.aVm.zzf((Callable<T>) new Callable<List<? extends zzaji>>() {
            /* renamed from: zzbvg */
            public List<? extends zzaji> call() {
                zzaib.this.aVm.zzi(zzajm.zzan(zzahr));
                return zzaib.this.zza((zzaio) new zzaim(zzaip.aWx, zzahr));
            }
        });
    }
}
