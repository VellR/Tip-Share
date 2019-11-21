package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaib.zzd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.Transaction.Handler;
import com.google.firebase.database.Transaction.Result;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzaht implements com.google.android.gms.internal.zzagz.zza {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaht.class.desiredAssertionStatus());
    private final zzahu aPp;
    /* access modifiers changed from: private */
    public final zzagz aSA;
    /* access modifiers changed from: private */
    public final zzalk aTP = new zzalk(new zzalh(), 0);
    /* access modifiers changed from: private */
    public zzahy aTQ;
    /* access modifiers changed from: private */
    public zzahz aTR;
    /* access modifiers changed from: private */
    public zzajc<List<zza>> aTS;
    private boolean aTT = false;
    private final zzajk aTU;
    private final zzahk aTV;
    /* access modifiers changed from: private */
    public final zzajx aTW;
    private final zzajx aTX;
    private final zzajx aTY;
    public long aTZ = 0;
    private long aUa = 1;
    /* access modifiers changed from: private */
    public zzaib aUb;
    /* access modifiers changed from: private */
    public zzaib aUc;
    private FirebaseDatabase aUd;
    private boolean aUe = false;
    private long aUf = 0;

    private static class zza implements Comparable<zza> {
        /* access modifiers changed from: private */
        public zzahr aPz;
        /* access modifiers changed from: private */
        public Handler aUG;
        /* access modifiers changed from: private */
        public ValueEventListener aUH;
        /* access modifiers changed from: private */
        public zzb aUI;
        private long aUJ;
        /* access modifiers changed from: private */
        public boolean aUK;
        /* access modifiers changed from: private */
        public DatabaseError aUL;
        /* access modifiers changed from: private */
        public long aUM;
        /* access modifiers changed from: private */
        public zzakm aUN;
        /* access modifiers changed from: private */
        public zzakm aUO;
        /* access modifiers changed from: private */
        public zzakm aUP;
        /* access modifiers changed from: private */
        public int retryCount;

        private zza(zzahr zzahr, Handler handler, ValueEventListener valueEventListener, zzb zzb, boolean z, long j) {
            this.aPz = zzahr;
            this.aUG = handler;
            this.aUH = valueEventListener;
            this.aUI = zzb;
            this.retryCount = 0;
            this.aUK = z;
            this.aUJ = j;
            this.aUL = null;
            this.aUN = null;
            this.aUO = null;
            this.aUP = null;
        }

        /* renamed from: zza */
        public int compareTo(zza zza) {
            if (this.aUJ < zza.aUJ) {
                return -1;
            }
            return this.aUJ == zza.aUJ ? 0 : 1;
        }
    }

    private enum zzb {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    zzaht(zzahu zzahu, zzahk zzahk, FirebaseDatabase firebaseDatabase) {
        this.aPp = zzahu;
        this.aTV = zzahk;
        this.aUd = firebaseDatabase;
        this.aTW = this.aTV.zzrh("RepoOperation");
        this.aTX = this.aTV.zzrh("Transaction");
        this.aTY = this.aTV.zzrh("DataOperation");
        this.aTU = new zzajk(this.aTV);
        this.aSA = zzahk.zza(new zzagx(zzahu.aRd, zzahu.zl, zzahu.aRe), this);
        zzr(new Runnable() {
            public void run() {
                zzaht.this.zzcrg();
            }
        });
    }

    private zzakm zza(zzahr zzahr, List<Long> list) {
        zzakm zzc = this.aUc.zzc(zzahr, list);
        return zzc == null ? zzakf.zzcvi() : zzc;
    }

    /* access modifiers changed from: private */
    public void zza(long j, zzahr zzahr, DatabaseError databaseError) {
        if (databaseError == null || databaseError.getCode() != -25) {
            List zza2 = this.aUc.zza(j, !(databaseError == null), true, (zzalg) this.aTP);
            if (zza2.size() > 0) {
                zzo(zzahr);
            }
            zzas(zza2);
        }
    }

    private void zza(zzaiv zzaiv) {
        List<zzaif> zzcmw = zzaiv.zzcmw();
        Map zza2 = zzahx.zza(this.aTP);
        long j = Long.MIN_VALUE;
        for (final zzaif zzaif : zzcmw) {
            AnonymousClass19 r0 = new zzahc() {
                public void zzbm(String str, String str2) {
                    DatabaseError zzbo = zzaht.zzbn(str, str2);
                    zzaht.this.zza("Persisted write", zzaif.zzcmu(), zzbo);
                    zzaht.this.zza(zzaif.zzcrv(), zzaif.zzcmu(), zzbo);
                }
            };
            if (j >= zzaif.zzcrv()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            long zzcrv = zzaif.zzcrv();
            this.aUa = zzaif.zzcrv() + 1;
            if (zzaif.zzcry()) {
                if (this.aTW.zzcum()) {
                    this.aTW.zzh("Restoring overwrite with id " + zzaif.zzcrv(), new Object[0]);
                }
                this.aSA.zza(zzaif.zzcmu().zzcra(), zzaif.zzcrw().getValue(true), (zzahc) r0);
                this.aUc.zza(zzaif.zzcmu(), zzaif.zzcrw(), zzahx.zza(zzaif.zzcrw(), zza2), zzaif.zzcrv(), true, false);
            } else {
                if (this.aTW.zzcum()) {
                    this.aTW.zzh("Restoring merge with id " + zzaif.zzcrv(), new Object[0]);
                }
                this.aSA.zza(zzaif.zzcmu().zzcra(), zzaif.zzcrx().zzcs(true), (zzahc) r0);
                this.aUc.zza(zzaif.zzcmu(), zzaif.zzcrx(), zzahx.zza(zzaif.zzcrx(), zza2), zzaif.zzcrv(), false);
            }
            j = zzcrv;
        }
    }

    /* access modifiers changed from: private */
    public void zza(zzajc<List<zza>> zzajc) {
        Boolean bool;
        if (((List) zzajc.getValue()) != null) {
            List zzc = zzc(zzajc);
            if ($assertionsDisabled || zzc.size() > 0) {
                Boolean valueOf = Boolean.valueOf(true);
                Iterator it = zzc.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((zza) it.next()).aUI != zzb.RUN) {
                            bool = Boolean.valueOf(false);
                            break;
                        }
                    } else {
                        bool = valueOf;
                        break;
                    }
                }
                if (bool.booleanValue()) {
                    zza(zzc, zzajc.zzcmu());
                    return;
                }
                return;
            }
            throw new AssertionError();
        } else if (zzajc.hasChildren()) {
            zzajc.zzb(new com.google.android.gms.internal.zzajc.zzb<List<zza>>() {
                public void zzd(zzajc<List<zza>> zzajc) {
                    zzaht.this.zza(zzajc);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void zza(zzajc<List<zza>> zzajc, int i) {
        final DatabaseError zzadi;
        List list = (List) zzajc.getValue();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            ArrayList<Runnable> arrayList2 = new ArrayList<>();
            if (i == -9) {
                zzadi = DatabaseError.zzqq("overriddenBySet");
            } else {
                zzalo.zzb(i == -25, "Unknown transaction abort reason: " + i);
                zzadi = DatabaseError.zzadi(-25);
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                int i5 = i2;
                if (i4 < list.size()) {
                    final zza zza2 = (zza) list.get(i4);
                    if (zza2.aUI == zzb.SENT_NEEDS_ABORT) {
                        i2 = i5;
                    } else if (zza2.aUI == zzb.SENT) {
                        if ($assertionsDisabled || i5 == i4 - 1) {
                            zza2.aUI = zzb.SENT_NEEDS_ABORT;
                            zza2.aUL = zzadi;
                            i2 = i4;
                        } else {
                            throw new AssertionError();
                        }
                    } else if ($assertionsDisabled || zza2.aUI == zzb.RUN) {
                        zze((zzahm) new zzaih(this, zza2.aUH, zzajm.zzan(zza2.aPz)));
                        if (i == -9) {
                            arrayList.addAll(this.aUc.zza(zza2.aUM, true, false, (zzalg) this.aTP));
                        } else {
                            zzalo.zzb(i == -25, "Unknown transaction abort reason: " + i);
                        }
                        arrayList2.add(new Runnable() {
                            public void run() {
                                zza2.aUG.onComplete(zzadi, false, null);
                            }
                        });
                        i2 = i5;
                    } else {
                        throw new AssertionError();
                    }
                    i3 = i4 + 1;
                } else {
                    if (i5 == -1) {
                        zzajc.setValue(null);
                    } else {
                        zzajc.setValue(list.subList(0, i5 + 1));
                    }
                    zzas(arrayList);
                    for (Runnable zzp : arrayList2) {
                        zzp(zzp);
                    }
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void zza(String str, zzahr zzahr, DatabaseError databaseError) {
        if (databaseError != null && databaseError.getCode() != -1 && databaseError.getCode() != -25) {
            zzajx zzajx = this.aTW;
            String valueOf = String.valueOf(zzahr.toString());
            String valueOf2 = String.valueOf(databaseError.toString());
            zzajx.warn(new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length()).append(str).append(" at ").append(valueOf).append(" failed: ").append(valueOf2).toString());
        }
    }

    private void zza(final List<zza> list, final zzahr zzahr) {
        ArrayList arrayList = new ArrayList();
        for (zza zzc : list) {
            arrayList.add(Long.valueOf(zzc.aUM));
        }
        zzakm zza2 = zza(zzahr, (List<Long>) arrayList);
        String str = "badhash";
        String zzcuv = zza2.zzcuv();
        for (zza zza3 : list) {
            if ($assertionsDisabled || zza3.aUI == zzb.RUN) {
                zza3.aUI = zzb.SENT;
                zza3.retryCount = zza3.retryCount + 1;
                zza2 = zza2.zzl(zzahr.zza(zzahr, zza3.aPz), zza3.aUO);
            } else {
                throw new AssertionError();
            }
        }
        Object value = zza2.getValue(true);
        zzcrk();
        this.aSA.zza(zzahr.zzcra(), value, zzcuv, new zzahc() {
            public void zzbm(String str, String str2) {
                DatabaseError zzbo = zzaht.zzbn(str, str2);
                zzaht.this.zza("Transaction", zzahr, zzbo);
                ArrayList arrayList = new ArrayList();
                if (zzbo == null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (final zza zza : list) {
                        zza.aUI = zzb.COMPLETED;
                        arrayList.addAll(zzaht.this.aUc.zza(zza.aUM, false, false, (zzalg) zzaht.this.aTP));
                        final DataSnapshot zza2 = com.google.firebase.database.zza.zza(com.google.firebase.database.zza.zza(this, zza.aPz), zzakh.zzm(zza.aUP));
                        arrayList2.add(new Runnable() {
                            public void run() {
                                zza.aUG.onComplete(null, true, zza2);
                            }
                        });
                        zzaht.this.zze((zzahm) new zzaih(zzaht.this, zza.aUH, zzajm.zzan(zza.aPz)));
                    }
                    zzaht.this.zzb(zzaht.this.aTS.zzal(zzahr));
                    zzaht.this.zzcrm();
                    this.zzas(arrayList);
                    for (int i = 0; i < arrayList2.size(); i++) {
                        zzaht.this.zzp((Runnable) arrayList2.get(i));
                    }
                    return;
                }
                if (zzbo.getCode() == -1) {
                    for (zza zza3 : list) {
                        if (zza3.aUI == zzb.SENT_NEEDS_ABORT) {
                            zza3.aUI = zzb.NEEDS_ABORT;
                        } else {
                            zza3.aUI = zzb.RUN;
                        }
                    }
                } else {
                    for (zza zza4 : list) {
                        zza4.aUI = zzb.NEEDS_ABORT;
                        zza4.aUL = zzbo;
                    }
                }
                zzaht.this.zzo(zzahr);
            }
        });
    }

    /* access modifiers changed from: private */
    public void zza(final List<zza> list, zzajc<List<zza>> zzajc) {
        List list2 = (List) zzajc.getValue();
        if (list2 != null) {
            list.addAll(list2);
        }
        zzajc.zzb(new com.google.android.gms.internal.zzajc.zzb<List<zza>>() {
            public void zzd(zzajc<List<zza>> zzajc) {
                zzaht.this.zza(list, zzajc);
            }
        });
    }

    /* access modifiers changed from: private */
    public void zzas(List<? extends zzaji> list) {
        if (!list.isEmpty()) {
            this.aTU.zzau(list);
        }
    }

    /* access modifiers changed from: private */
    public zzahr zzb(zzahr zzahr, final int i) {
        zzahr zzcmu = zzp(zzahr).zzcmu();
        if (this.aTX.zzcum()) {
            zzajx zzajx = this.aTW;
            String valueOf = String.valueOf(zzahr);
            String valueOf2 = String.valueOf(zzcmu);
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 44 + String.valueOf(valueOf2).length()).append("Aborting transactions for path: ").append(valueOf).append(". Affected: ").append(valueOf2).toString(), new Object[0]);
        }
        zzajc zzal = this.aTS.zzal(zzahr);
        zzal.zza((com.google.android.gms.internal.zzajc.zza<T>) new com.google.android.gms.internal.zzajc.zza<List<zza>>() {
            public boolean zze(zzajc<List<zza>> zzajc) {
                zzaht.this.zza(zzajc, i);
                return false;
            }
        });
        zza(zzal, i);
        zzal.zza((com.google.android.gms.internal.zzajc.zzb<T>) new com.google.android.gms.internal.zzajc.zzb<List<zza>>() {
            public void zzd(zzajc<List<zza>> zzajc) {
                zzaht.this.zza(zzajc, i);
            }
        });
        return zzcmu;
    }

    /* access modifiers changed from: private */
    public void zzb(zzajc<List<zza>> zzajc) {
        List list = (List) zzajc.getValue();
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                } else if (((zza) list.get(i2)).aUI == zzb.COMPLETED) {
                    list.remove(i2);
                    i = i2;
                } else {
                    i = i2 + 1;
                }
            }
            if (list.size() > 0) {
                zzajc.setValue(list);
            } else {
                zzajc.setValue(null);
            }
        }
        zzajc.zzb(new com.google.android.gms.internal.zzajc.zzb<List<zza>>() {
            public void zzd(zzajc<List<zza>> zzajc) {
                zzaht.this.zzb(zzajc);
            }
        });
    }

    private void zzb(zzaka zzaka, Object obj) {
        if (zzaka.equals(zzahj.aTo)) {
            this.aTP.zzck(((Long) obj).longValue());
        }
        zzahr zzahr = new zzahr(zzahj.aTn, zzaka);
        try {
            zzakm zzbs = zzakn.zzbs(obj);
            this.aTQ.zzg(zzahr, zzbs);
            zzas(this.aUb.zzi(zzahr, zzbs));
        } catch (DatabaseException e) {
            this.aTW.zze("Failed to parse info update", e);
        }
    }

    private void zzb(List<zza> list, zzahr zzahr) {
        final DatabaseError databaseError;
        boolean z;
        Result abort;
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (zza zzc : list) {
                arrayList2.add(Long.valueOf(zzc.aUM));
            }
            for (final zza zza2 : list) {
                zzahr zza3 = zzahr.zza(zzahr, zza2.aPz);
                ArrayList arrayList3 = new ArrayList();
                if ($assertionsDisabled || zza3 != null) {
                    if (zza2.aUI == zzb.NEEDS_ABORT) {
                        z = true;
                        databaseError = zza2.aUL;
                        if (databaseError.getCode() != -25) {
                            arrayList3.addAll(this.aUc.zza(zza2.aUM, true, false, (zzalg) this.aTP));
                        }
                    } else if (zza2.aUI != zzb.RUN) {
                        databaseError = null;
                        z = false;
                    } else if (zza2.retryCount >= 25) {
                        z = true;
                        databaseError = DatabaseError.zzqq("maxretries");
                        arrayList3.addAll(this.aUc.zza(zza2.aUM, true, false, (zzalg) this.aTP));
                    } else {
                        zzakm zza4 = zza(zza2.aPz, (List<Long>) arrayList2);
                        zza2.aUN = zza4;
                        try {
                            abort = zza2.aUG.doTransaction(com.google.firebase.database.zza.zza(zza4));
                            databaseError = null;
                        } catch (Throwable th) {
                            DatabaseError fromException = DatabaseError.fromException(th);
                            abort = Transaction.abort();
                            databaseError = fromException;
                        }
                        if (abort.isSuccess()) {
                            Long valueOf = Long.valueOf(zza2.aUM);
                            Map zza5 = zzahx.zza(this.aTP);
                            zzakm zzcmq = abort.zzcmq();
                            zzakm zza6 = zzahx.zza(zzcmq, zza5);
                            zza2.aUO = zzcmq;
                            zza2.aUP = zza6;
                            zza2.aUM = zzcrk();
                            arrayList2.remove(valueOf);
                            arrayList3.addAll(this.aUc.zza(zza2.aPz, zzcmq, zza6, zza2.aUM, zza2.aUK, false));
                            arrayList3.addAll(this.aUc.zza(valueOf.longValue(), true, false, (zzalg) this.aTP));
                            databaseError = null;
                            z = false;
                        } else {
                            z = true;
                            arrayList3.addAll(this.aUc.zza(zza2.aUM, true, false, (zzalg) this.aTP));
                        }
                    }
                    zzas(arrayList3);
                    if (z) {
                        zza2.aUI = zzb.COMPLETED;
                        final DataSnapshot zza7 = com.google.firebase.database.zza.zza(com.google.firebase.database.zza.zza(this, zza2.aPz), zzakh.zzm(zza2.aUN));
                        zzr(new Runnable() {
                            public void run() {
                                zzaht.this.zze((zzahm) new zzaih(zzaht.this, zza2.aUH, zzajm.zzan(zza2.aPz)));
                            }
                        });
                        arrayList.add(new Runnable() {
                            public void run() {
                                zza2.aUG.onComplete(databaseError, false, zza7);
                            }
                        });
                    }
                } else {
                    throw new AssertionError();
                }
            }
            zzb(this.aTS);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    zzp((Runnable) arrayList.get(i2));
                    i = i2 + 1;
                } else {
                    zzcrm();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static DatabaseError zzbn(String str, String str2) {
        if (str != null) {
            return DatabaseError.zzbk(str, str2);
        }
        return null;
    }

    private List<zza> zzc(zzajc<List<zza>> zzajc) {
        ArrayList arrayList = new ArrayList();
        zza((List<zza>) arrayList, zzajc);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void zzcrg() {
        this.aTV.zzcqm().zza(new com.google.android.gms.internal.zzahg.zzb() {
            public void zzcpt() {
                zzaht.this.aTW.zzh("Auth token changed, triggering auth token refresh", new Object[0]);
                zzaht.this.aSA.refreshAuthToken();
            }
        });
        this.aSA.initialize();
        zzaiv zzri = this.aTV.zzri(this.aPp.aRd);
        this.aTQ = new zzahy();
        this.aTR = new zzahz();
        this.aTS = new zzajc<>();
        this.aUb = new zzaib(this.aTV, new zzaiu(), new zzd() {
            public void zza(zzajm zzajm, zzaic zzaic) {
            }

            public void zza(final zzajm zzajm, zzaic zzaic, zzagy zzagy, final com.google.android.gms.internal.zzaib.zza zza) {
                zzaht.this.zzr(new Runnable() {
                    public void run() {
                        zzakm zzq = zzaht.this.aTQ.zzq(zzajm.zzcmu());
                        if (!zzq.isEmpty()) {
                            zzaht.this.zzas(zzaht.this.aUb.zzi(zzajm.zzcmu(), zzq));
                            zza.zzb(null);
                        }
                    }
                });
            }
        });
        this.aUc = new zzaib(this.aTV, zzri, new zzd() {
            public void zza(zzajm zzajm, zzaic zzaic) {
                zzaht.this.aSA.zza(zzajm.zzcmu().zzcra(), zzajm.zzctz().zzctv());
            }

            public void zza(zzajm zzajm, zzaic zzaic, zzagy zzagy, final com.google.android.gms.internal.zzaib.zza zza) {
                zzaht.this.aSA.zza(zzajm.zzcmu().zzcra(), zzajm.zzctz().zzctv(), zzagy, zzaic != null ? Long.valueOf(zzaic.zzcru()) : null, new zzahc() {
                    public void zzbm(String str, String str2) {
                        zzaht.this.zzas(zza.zzb(zzaht.zzbn(str, str2)));
                    }
                });
            }
        });
        zza(zzri);
        zzb(zzahj.aTp, (Object) Boolean.valueOf(false));
        zzb(zzahj.aTq, (Object) Boolean.valueOf(false));
    }

    private long zzcrk() {
        long j = this.aUa;
        this.aUa = 1 + j;
        return j;
    }

    private void zzcrl() {
        zzahz zza2 = zzahx.zza(this.aTR, zzahx.zza(this.aTP));
        final ArrayList arrayList = new ArrayList();
        zza2.zza(zzahr.zzcqy(), new com.google.android.gms.internal.zzahz.zzb() {
            public void zzf(zzahr zzahr, zzakm zzakm) {
                arrayList.addAll(zzaht.this.aUc.zzi(zzahr, zzakm));
                zzaht.this.zzo(zzaht.this.zzb(zzahr, -9));
            }
        });
        this.aTR = new zzahz();
        zzas(arrayList);
    }

    /* access modifiers changed from: private */
    public void zzcrm() {
        zzajc<List<zza>> zzajc = this.aTS;
        zzb(zzajc);
        zza(zzajc);
    }

    private long zzcrn() {
        long j = this.aUf;
        this.aUf = 1 + j;
        return j;
    }

    private zzakm zzn(zzahr zzahr) {
        return zza(zzahr, (List<Long>) new ArrayList<Long>());
    }

    /* access modifiers changed from: private */
    public zzahr zzo(zzahr zzahr) {
        zzajc zzp = zzp(zzahr);
        zzahr zzcmu = zzp.zzcmu();
        zzb(zzc(zzp), zzcmu);
        return zzcmu;
    }

    private zzajc<List<zza>> zzp(zzahr zzahr) {
        zzajc<List<zza>> zzajc = this.aTS;
        while (!zzahr.isEmpty() && zzajc.getValue() == null) {
            zzajc = zzajc.zzal(new zzahr(zzahr.zzcrb()));
            zzahr = zzahr.zzcrc();
        }
        return zzajc;
    }

    public FirebaseDatabase getDatabase() {
        return this.aUd;
    }

    /* access modifiers changed from: 0000 */
    public void interrupt() {
        this.aSA.interrupt("repo_interrupt");
    }

    public void onDisconnect() {
        zza(zzahj.aTq, (Object) Boolean.valueOf(false));
        zzcrl();
    }

    public void purgeOutstandingWrites() {
        if (this.aTW.zzcum()) {
            this.aTW.zzh("Purging writes", new Object[0]);
        }
        zzas(this.aUc.zzcrs());
        zzb(zzahr.zzcqy(), -25);
        this.aSA.purgeOutstandingWrites();
    }

    /* access modifiers changed from: 0000 */
    public void resume() {
        this.aSA.resume("repo_interrupt");
    }

    public String toString() {
        return this.aPp.toString();
    }

    public void zza(zzahr zzahr, zzahi zzahi, CompletionListener completionListener, Map<String, Object> map) {
        if (this.aTW.zzcum()) {
            zzajx zzajx = this.aTW;
            String valueOf = String.valueOf(zzahr);
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 8).append("update: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.aTY.zzcum()) {
            zzajx zzajx2 = this.aTY;
            String valueOf2 = String.valueOf(zzahr);
            String valueOf3 = String.valueOf(map);
            zzajx2.zzh(new StringBuilder(String.valueOf(valueOf2).length() + 9 + String.valueOf(valueOf3).length()).append("update: ").append(valueOf2).append(" ").append(valueOf3).toString(), new Object[0]);
        }
        if (zzahi.isEmpty()) {
            if (this.aTW.zzcum()) {
                this.aTW.zzh("update called with no changes. No-op", new Object[0]);
            }
            zza(completionListener, (DatabaseError) null, zzahr);
            return;
        }
        zzahi zza2 = zzahx.zza(zzahi, zzahx.zza(this.aTP));
        final long zzcrk = zzcrk();
        zzas(this.aUc.zza(zzahr, zzahi, zza2, zzcrk, true));
        final zzahr zzahr2 = zzahr;
        final CompletionListener completionListener2 = completionListener;
        this.aSA.zza(zzahr.zzcra(), map, (zzahc) new zzahc() {
            public void zzbm(String str, String str2) {
                DatabaseError zzbo = zzaht.zzbn(str, str2);
                zzaht.this.zza("updateChildren", zzahr2, zzbo);
                zzaht.this.zza(zzcrk, zzahr2, zzbo);
                zzaht.this.zza(completionListener2, zzbo, zzahr2);
            }
        });
        zzo(zzb(zzahr, -9));
    }

    public void zza(zzahr zzahr, zzakm zzakm, CompletionListener completionListener) {
        if (this.aTW.zzcum()) {
            zzajx zzajx = this.aTW;
            String valueOf = String.valueOf(zzahr);
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 5).append("set: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.aTY.zzcum()) {
            zzajx zzajx2 = this.aTY;
            String valueOf2 = String.valueOf(zzahr);
            String valueOf3 = String.valueOf(zzakm);
            zzajx2.zzh(new StringBuilder(String.valueOf(valueOf2).length() + 6 + String.valueOf(valueOf3).length()).append("set: ").append(valueOf2).append(" ").append(valueOf3).toString(), new Object[0]);
        }
        zzakm zza2 = zzahx.zza(zzakm, zzahx.zza(this.aTP));
        final long zzcrk = zzcrk();
        zzas(this.aUc.zza(zzahr, zzakm, zza2, zzcrk, true, true));
        final zzahr zzahr2 = zzahr;
        final CompletionListener completionListener2 = completionListener;
        this.aSA.zza(zzahr.zzcra(), zzakm.getValue(true), (zzahc) new zzahc() {
            public void zzbm(String str, String str2) {
                DatabaseError zzbo = zzaht.zzbn(str, str2);
                zzaht.this.zza("setValue", zzahr2, zzbo);
                zzaht.this.zza(zzcrk, zzahr2, zzbo);
                zzaht.this.zza(completionListener2, zzbo, zzahr2);
            }
        });
        zzo(zzb(zzahr, -9));
    }

    public void zza(final zzahr zzahr, final CompletionListener completionListener) {
        this.aSA.zza(zzahr.zzcra(), (zzahc) new zzahc() {
            public void zzbm(String str, String str2) {
                DatabaseError zzbo = zzaht.zzbn(str, str2);
                if (zzbo == null) {
                    zzaht.this.aTR.zzr(zzahr);
                }
                zzaht.this.zza(completionListener, zzbo, zzahr);
            }
        });
    }

    public void zza(zzahr zzahr, final Handler handler, boolean z) {
        Result result;
        final DatabaseError databaseError;
        if (this.aTW.zzcum()) {
            zzajx zzajx = this.aTW;
            String valueOf = String.valueOf(zzahr);
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 13).append("transaction: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.aTY.zzcum()) {
            zzajx zzajx2 = this.aTW;
            String valueOf2 = String.valueOf(zzahr);
            zzajx2.zzh(new StringBuilder(String.valueOf(valueOf2).length() + 13).append("transaction: ").append(valueOf2).toString(), new Object[0]);
        }
        if (this.aTV.zzcod() && !this.aUe) {
            this.aUe = true;
            this.aTX.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        DatabaseReference zza2 = com.google.firebase.database.zza.zza(this, zzahr);
        AnonymousClass5 r3 = new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
            }
        };
        zzf((zzahm) new zzaih(this, r3, zza2.zzcmv()));
        zza zza3 = new zza(zzahr, handler, r3, zzb.INITIALIZING, z, zzcrn());
        zzakm zzn = zzn(zzahr);
        zza3.aUN = zzn;
        try {
            Result doTransaction = handler.doTransaction(com.google.firebase.database.zza.zza(zzn));
            if (doTransaction == null) {
                throw new NullPointerException("Transaction returned null as result");
            }
            result = doTransaction;
            databaseError = null;
            if (!result.isSuccess()) {
                zza3.aUO = null;
                zza3.aUP = null;
                final DataSnapshot zza4 = com.google.firebase.database.zza.zza(zza2, zzakh.zzm(zza3.aUN));
                zzp((Runnable) new Runnable() {
                    public void run() {
                        handler.onComplete(databaseError, false, zza4);
                    }
                });
                return;
            }
            zza3.aUI = zzb.RUN;
            zzajc zzal = this.aTS.zzal(zzahr);
            List list = (List) zzal.getValue();
            if (list == null) {
                list = new ArrayList();
            }
            list.add(zza3);
            zzal.setValue(list);
            Map zza5 = zzahx.zza(this.aTP);
            zzakm zzcmq = result.zzcmq();
            zzakm zza6 = zzahx.zza(zzcmq, zza5);
            zza3.aUO = zzcmq;
            zza3.aUP = zza6;
            zza3.aUM = zzcrk();
            zzas(this.aUc.zza(zzahr, zzcmq, zza6, zza3.aUM, z, false));
            zzcrm();
        } catch (Throwable th) {
            DatabaseError fromException = DatabaseError.fromException(th);
            databaseError = fromException;
            result = Transaction.abort();
        }
    }

    public void zza(final zzahr zzahr, final Map<zzahr, zzakm> map, final CompletionListener completionListener, Map<String, Object> map2) {
        this.aSA.zzb(zzahr.zzcra(), map2, (zzahc) new zzahc() {
            public void zzbm(String str, String str2) {
                DatabaseError zzbo = zzaht.zzbn(str, str2);
                zzaht.this.zza("onDisconnect().updateChildren", zzahr, zzbo);
                if (zzbo == null) {
                    for (Entry entry : map.entrySet()) {
                        zzaht.this.aTR.zzh(zzahr.zzh((zzahr) entry.getKey()), (zzakm) entry.getValue());
                    }
                }
                zzaht.this.zza(completionListener, zzbo, zzahr);
            }
        });
    }

    public void zza(zzajm zzajm, boolean z) {
        if ($assertionsDisabled || zzajm.zzcmu().isEmpty() || !zzajm.zzcmu().zzcrb().equals(zzahj.aTn)) {
            this.aUc.zza(zzajm, z);
            return;
        }
        throw new AssertionError();
    }

    public void zza(zzaka zzaka, Object obj) {
        zzb(zzaka, obj);
    }

    /* access modifiers changed from: 0000 */
    public void zza(final CompletionListener completionListener, final DatabaseError databaseError, zzahr zzahr) {
        if (completionListener != null) {
            zzaka zzcre = zzahr.zzcre();
            final DatabaseReference zza2 = (zzcre == null || !zzcre.zzcut()) ? com.google.firebase.database.zza.zza(this, zzahr) : com.google.firebase.database.zza.zza(this, zzahr.zzcrd());
            zzp((Runnable) new Runnable() {
                public void run() {
                    completionListener.onComplete(databaseError, zza2);
                }
            });
        }
    }

    public void zza(List<String> list, Object obj, boolean z, Long l) {
        List zzi;
        zzahr zzahr = new zzahr(list);
        if (this.aTW.zzcum()) {
            zzajx zzajx = this.aTW;
            String valueOf = String.valueOf(zzahr);
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 14).append("onDataUpdate: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.aTY.zzcum()) {
            zzajx zzajx2 = this.aTW;
            String valueOf2 = String.valueOf(zzahr);
            String valueOf3 = String.valueOf(obj);
            zzajx2.zzh(new StringBuilder(String.valueOf(valueOf2).length() + 15 + String.valueOf(valueOf3).length()).append("onDataUpdate: ").append(valueOf2).append(" ").append(valueOf3).toString(), new Object[0]);
        }
        this.aTZ++;
        if (l != null) {
            try {
                zzaic zzaic = new zzaic(l.longValue());
                if (z) {
                    HashMap hashMap = new HashMap();
                    for (Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new zzahr((String) entry.getKey()), zzakn.zzbs(entry.getValue()));
                    }
                    zzi = this.aUc.zza(zzahr, (Map<zzahr, zzakm>) hashMap, zzaic);
                } else {
                    zzi = this.aUc.zza(zzahr, zzakn.zzbs(obj), zzaic);
                }
            } catch (DatabaseException e) {
                this.aTW.zze("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (z) {
            HashMap hashMap2 = new HashMap();
            for (Entry entry2 : ((Map) obj).entrySet()) {
                hashMap2.put(new zzahr((String) entry2.getKey()), zzakn.zzbs(entry2.getValue()));
            }
            zzi = this.aUc.zza(zzahr, (Map<zzahr, zzakm>) hashMap2);
        } else {
            zzi = this.aUc.zzi(zzahr, zzakn.zzbs(obj));
        }
        if (zzi.size() > 0) {
            zzo(zzahr);
        }
        zzas(zzi);
    }

    public void zza(List<String> list, List<zzahb> list2, Long l) {
        zzahr zzahr = new zzahr(list);
        if (this.aTW.zzcum()) {
            zzajx zzajx = this.aTW;
            String valueOf = String.valueOf(zzahr);
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 20).append("onRangeMergeUpdate: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.aTY.zzcum()) {
            zzajx zzajx2 = this.aTW;
            String valueOf2 = String.valueOf(zzahr);
            String valueOf3 = String.valueOf(list2);
            zzajx2.zzh(new StringBuilder(String.valueOf(valueOf2).length() + 21 + String.valueOf(valueOf3).length()).append("onRangeMergeUpdate: ").append(valueOf2).append(" ").append(valueOf3).toString(), new Object[0]);
        }
        this.aTZ++;
        ArrayList arrayList = new ArrayList(list2.size());
        for (zzahb zzakr : list2) {
            arrayList.add(new zzakr(zzakr));
        }
        List zzb2 = l != null ? this.aUc.zza(zzahr, (List<zzakr>) arrayList, new zzaic(l.longValue())) : this.aUc.zzb(zzahr, (List<zzakr>) arrayList);
        if (zzb2.size() > 0) {
            zzo(zzahr);
        }
        zzas(zzb2);
    }

    public void zzb(final zzahr zzahr, final zzakm zzakm, final CompletionListener completionListener) {
        this.aSA.zzb(zzahr.zzcra(), zzakm.getValue(true), (zzahc) new zzahc() {
            public void zzbm(String str, String str2) {
                DatabaseError zzbo = zzaht.zzbn(str, str2);
                zzaht.this.zza("onDisconnect().setValue", zzahr, zzbo);
                if (zzbo == null) {
                    zzaht.this.aTR.zzh(zzahr, zzakm);
                }
                zzaht.this.zza(completionListener, zzbo, zzahr);
            }
        });
    }

    public void zzbt(Map<String, Object> map) {
        for (Entry entry : map.entrySet()) {
            zzb(zzaka.zzrm((String) entry.getKey()), entry.getValue());
        }
    }

    public void zzcoi() {
        zza(zzahj.aTq, (Object) Boolean.valueOf(true));
    }

    public void zzcq(boolean z) {
        zza(zzahj.aTp, (Object) Boolean.valueOf(z));
    }

    public zzahu zzcrh() {
        return this.aPp;
    }

    public long zzcri() {
        return this.aTP.zzcwq();
    }

    /* access modifiers changed from: 0000 */
    public boolean zzcrj() {
        return !this.aUb.isEmpty() || !this.aUc.isEmpty();
    }

    public void zze(zzahm zzahm) {
        zzas(zzahj.aTn.equals(zzahm.zzcpu().zzcmu().zzcrb()) ? this.aUb.zzh(zzahm) : this.aUc.zzh(zzahm));
    }

    public void zzf(zzahm zzahm) {
        zzaka zzcrb = zzahm.zzcpu().zzcmu().zzcrb();
        zzas((zzcrb == null || !zzcrb.equals(zzahj.aTn)) ? this.aUc.zzg(zzahm) : this.aUb.zzg(zzahm));
    }

    public void zzp(Runnable runnable) {
        this.aTV.zzcqc();
        this.aTV.zzcqj().zzp(runnable);
    }

    public void zzr(Runnable runnable) {
        this.aTV.zzcqc();
        this.aTV.zzcqk().zzr(runnable);
    }
}
