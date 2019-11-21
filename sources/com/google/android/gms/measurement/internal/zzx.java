package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzuo;
import com.google.android.gms.internal.zzup;
import com.google.android.gms.internal.zzup.zzb;
import com.google.android.gms.internal.zzup.zzc;
import com.google.android.gms.internal.zzup.zzd;
import com.google.android.gms.internal.zzup.zzg;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class zzx {
    private static volatile zzx amm;
    private final zzn amA;
    private final zzr amB;
    private final zzai amC;
    private final zzc amD;
    public final FirebaseAnalytics amE = new FirebaseAnalytics(this);
    private boolean amF;
    private Boolean amG;
    private FileLock amH;
    private FileChannel amI;
    private List<Long> amJ;
    private int amK;
    private int amL;
    private final zzd amn;
    private final zzt amo;
    private final zzp amp;
    private final zzw amq;
    private final zzaf amr;
    private final zzv ams;
    private final AppMeasurement amt;
    private final zzal amu;
    private final zze amv;
    private final zzq amw;
    private final zzad amx;
    private final zzg amy;
    private final zzac amz;
    private final Context mContext;
    private final zze zzaoa;
    private final boolean zzcwt;

    private class zza implements zzb {
        zzup.zze amN;
        List<Long> amO;
        long amP;
        List<zzb> zzala;

        private zza() {
        }

        private long zza(zzb zzb) {
            return ((zzb.aoL.longValue() / 1000) / 60) / 60;
        }

        /* access modifiers changed from: 0000 */
        public boolean isEmpty() {
            return this.zzala == null || this.zzala.isEmpty();
        }

        public boolean zza(long j, zzb zzb) {
            zzab.zzaa(zzb);
            if (this.zzala == null) {
                this.zzala = new ArrayList();
            }
            if (this.amO == null) {
                this.amO = new ArrayList();
            }
            if (this.zzala.size() > 0 && zza((zzb) this.zzala.get(0)) != zza(zzb)) {
                return false;
            }
            long ao = this.amP + ((long) zzb.ao());
            if (ao >= ((long) zzx.this.zzbtb().zzbse())) {
                return false;
            }
            this.amP = ao;
            this.zzala.add(zzb);
            this.amO.add(Long.valueOf(j));
            return this.zzala.size() < zzx.this.zzbtb().zzbsf();
        }

        public void zzc(zzup.zze zze) {
            zzab.zzaa(zze);
            this.amN = zze;
        }
    }

    zzx(zzab zzab) {
        zzab.zzaa(zzab);
        this.mContext = zzab.mContext;
        this.zzaoa = zzab.zzl(this);
        this.amn = zzab.zza(this);
        zzt zzb = zzab.zzb(this);
        zzb.initialize();
        this.amo = zzb;
        zzp zzc = zzab.zzc(this);
        zzc.initialize();
        this.amp = zzc;
        zzbsz().zzbtw().zzj("App measurement is starting up, version", Long.valueOf(zzbtb().zzbqv()));
        zzbsz().zzbtw().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzbsz().zzbtx().log("Debug logging enabled");
        zzbsz().zzbtx().zzj("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
        this.amu = zzab.zzi(this);
        zzg zzn = zzab.zzn(this);
        zzn.initialize();
        this.amy = zzn;
        zzn zzo = zzab.zzo(this);
        zzo.initialize();
        this.amA = zzo;
        zze zzj = zzab.zzj(this);
        zzj.initialize();
        this.amv = zzj;
        zzc zzr = zzab.zzr(this);
        zzr.initialize();
        this.amD = zzr;
        zzq zzk = zzab.zzk(this);
        zzk.initialize();
        this.amw = zzk;
        zzad zzm = zzab.zzm(this);
        zzm.initialize();
        this.amx = zzm;
        zzac zzh = zzab.zzh(this);
        zzh.initialize();
        this.amz = zzh;
        zzai zzq = zzab.zzq(this);
        zzq.initialize();
        this.amC = zzq;
        this.amB = zzab.zzp(this);
        this.amt = zzab.zzg(this);
        zzaf zze = zzab.zze(this);
        zze.initialize();
        this.amr = zze;
        zzv zzf = zzab.zzf(this);
        zzf.initialize();
        this.ams = zzf;
        zzw zzd = zzab.zzd(this);
        zzd.initialize();
        this.amq = zzd;
        if (this.amK != this.amL) {
            zzbsz().zzbtr().zze("Not all components initialized", Integer.valueOf(this.amK), Integer.valueOf(this.amL));
        }
        this.zzcwt = true;
        if (!this.amn.zzabc() && !zzbuu()) {
            if (!(this.mContext.getApplicationContext() instanceof Application)) {
                zzbsz().zzbtt().log("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                zzbsq().zzbvj();
            } else {
                zzbsz().zzbtx().log("Not tracking deep linking pre-ICS");
            }
        }
        this.amq.zzl(new Runnable() {
            public void run() {
                zzx.this.start();
            }
        });
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    @WorkerThread
    public void zza(int i, Throwable th, byte[] bArr) {
        boolean z = false;
        zzwu();
        zzzg();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.amJ;
        this.amJ = null;
        if ((i == 200 || i == 204) && th == null) {
            zzbta().alv.set(zzyw().currentTimeMillis());
            zzbta().alw.set(0);
            zzbva();
            zzbsz().zzbty().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            zzbsu().beginTransaction();
            try {
                for (Long longValue : list) {
                    zzbsu().zzbg(longValue.longValue());
                }
                zzbsu().setTransactionSuccessful();
                zzbsu().endTransaction();
                if (!zzbuo().zzadj() || !zzbuz()) {
                    zzbva();
                } else {
                    zzbuy();
                }
            } catch (Throwable th2) {
                zzbsu().endTransaction();
                throw th2;
            }
        } else {
            zzbsz().zzbty().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzbta().alw.set(zzyw().currentTimeMillis());
            if (i == 503 || i == 429) {
                z = true;
            }
            if (z) {
                zzbta().alx.set(zzyw().currentTimeMillis());
            }
            zzbva();
        }
    }

    private void zza(zzaa zzaa) {
        if (zzaa == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzaa.isInitialized()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void zza(zzz zzz) {
        if (zzz == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private com.google.android.gms.internal.zzup.zza[] zza(String str, zzg[] zzgArr, zzb[] zzbArr) {
        zzab.zzhs(str);
        return zzbsp().zza(str, zzbArr, zzgArr);
    }

    private void zzad(List<Long> list) {
        zzab.zzbn(!list.isEmpty());
        if (this.amJ != null) {
            zzbsz().zzbtr().log("Set uploading progress before finishing the previous upload");
        } else {
            this.amJ = new ArrayList(list);
        }
    }

    @WorkerThread
    private boolean zzbux() {
        zzwu();
        return this.amJ != null;
    }

    private boolean zzbuz() {
        zzwu();
        zzzg();
        return zzbsu().zzbth() || !TextUtils.isEmpty(zzbsu().zzbtc());
    }

    @WorkerThread
    private void zzbva() {
        zzwu();
        zzzg();
        if (zzbve()) {
            if (!zzbuk() || !zzbuz()) {
                zzbup().unregister();
                zzbuq().cancel();
                return;
            }
            long zzbvb = zzbvb();
            if (zzbvb == 0) {
                zzbup().unregister();
                zzbuq().cancel();
            } else if (!zzbuo().zzadj()) {
                zzbup().zzadg();
                zzbuq().cancel();
            } else {
                long j = zzbta().alx.get();
                long zzbsi = zzbtb().zzbsi();
                if (!zzbsv().zzg(j, zzbsi)) {
                    zzbvb = Math.max(zzbvb, j + zzbsi);
                }
                zzbup().unregister();
                long currentTimeMillis = zzbvb - zzyw().currentTimeMillis();
                if (currentTimeMillis <= 0) {
                    zzbuq().zzv(1);
                    return;
                }
                zzbsz().zzbty().zzj("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis));
                zzbuq().zzv(currentTimeMillis);
            }
        }
    }

    private long zzbvb() {
        long currentTimeMillis = zzyw().currentTimeMillis();
        long zzbsl = zzbtb().zzbsl();
        long zzbsj = zzbtb().zzbsj();
        long j = zzbta().alv.get();
        long j2 = zzbta().alw.get();
        long max = Math.max(zzbsu().zzbtf(), zzbsu().zzbtg());
        if (max == 0) {
            return 0;
        }
        long abs = currentTimeMillis - Math.abs(max - currentTimeMillis);
        long abs2 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
        long max2 = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), abs2);
        long j3 = zzbsl + abs;
        if (!zzbsv().zzg(max2, zzbsj)) {
            j3 = max2 + zzbsj;
        }
        if (abs2 == 0 || abs2 < abs) {
            return j3;
        }
        for (int i = 0; i < zzbtb().zzbsn(); i++) {
            j3 += ((long) (1 << i)) * zzbtb().zzbsm();
            if (j3 > abs2) {
                return j3;
            }
        }
        return 0;
    }

    public static zzx zzdo(Context context) {
        zzab.zzaa(context);
        zzab.zzaa(context.getApplicationContext());
        if (amm == null) {
            synchronized (zzx.class) {
                if (amm == null) {
                    amm = new zzab(context).zzbvi();
                }
            }
        }
        return amm;
    }

    @WorkerThread
    private void zze(AppMetadata appMetadata) {
        boolean z = true;
        zzwu();
        zzzg();
        zzab.zzaa(appMetadata);
        zzab.zzhs(appMetadata.packageName);
        zza zzlo = zzbsu().zzlo(appMetadata.packageName);
        String zzlz = zzbta().zzlz(appMetadata.packageName);
        boolean z2 = false;
        if (zzlo == null) {
            zza zza2 = new zza(this, appMetadata.packageName);
            zza2.zzkz(zzbta().zzbub());
            zza2.zzlb(zzlz);
            zzlo = zza2;
            z2 = true;
        } else if (!zzlz.equals(zzlo.zzbqp())) {
            zzlo.zzlb(zzlz);
            zzlo.zzkz(zzbta().zzbub());
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.ajz) && !appMetadata.ajz.equals(zzlo.zzbqo())) {
            zzlo.zzla(appMetadata.ajz);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.ajH) && !appMetadata.ajH.equals(zzlo.zzbqq())) {
            zzlo.zzlc(appMetadata.ajH);
            z2 = true;
        }
        if (!(appMetadata.ajB == 0 || appMetadata.ajB == zzlo.zzbqv())) {
            zzlo.zzaw(appMetadata.ajB);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.abU) && !appMetadata.abU.equals(zzlo.zzxc())) {
            zzlo.setAppVersion(appMetadata.abU);
            z2 = true;
        }
        if (appMetadata.ajG != zzlo.zzbqt()) {
            zzlo.zzav(appMetadata.ajG);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.ajA) && !appMetadata.ajA.equals(zzlo.zzbqu())) {
            zzlo.zzld(appMetadata.ajA);
            z2 = true;
        }
        if (appMetadata.ajC != zzlo.zzbqw()) {
            zzlo.zzax(appMetadata.ajC);
            z2 = true;
        }
        if (appMetadata.ajE != zzlo.zzbqx()) {
            zzlo.setMeasurementEnabled(appMetadata.ajE);
        } else {
            z = z2;
        }
        if (z) {
            zzbsu().zza(zzlo);
        }
    }

    /* JADX INFO: finally extract failed */
    private boolean zzh(String str, long j) {
        int i;
        boolean z;
        int i2;
        boolean z2;
        zzbsu().beginTransaction();
        try {
            zza zza2 = new zza();
            zzbsu().zza(str, j, (zzb) zza2);
            if (!zza2.isEmpty()) {
                zzup.zze zze = zza2.amN;
                zze.aoS = new zzb[zza2.zzala.size()];
                int i3 = 0;
                int i4 = 0;
                while (i4 < zza2.zzala.size()) {
                    if (zzbsw().zzax(zza2.amN.zzck, ((zzb) zza2.zzala.get(i4)).name)) {
                        zzbsz().zzbtt().zzj("Dropping blacklisted raw event", ((zzb) zza2.zzala.get(i4)).name);
                        zzbsv().zze(11, "_ev", ((zzb) zza2.zzala.get(i4)).name);
                        i = i3;
                    } else {
                        if (zzbsw().zzay(zza2.amN.zzck, ((zzb) zza2.zzala.get(i4)).name)) {
                            if (((zzb) zza2.zzala.get(i4)).aoK == null) {
                                ((zzb) zza2.zzala.get(i4)).aoK = new zzc[0];
                            }
                            zzc[] zzcArr = ((zzb) zza2.zzala.get(i4)).aoK;
                            int length = zzcArr.length;
                            int i5 = 0;
                            while (true) {
                                if (i5 >= length) {
                                    z = false;
                                    break;
                                }
                                zzc zzc = zzcArr[i5];
                                if ("_c".equals(zzc.name)) {
                                    zzc.aoO = Long.valueOf(1);
                                    z = true;
                                    break;
                                }
                                i5++;
                            }
                            if (!z) {
                                zzbsz().zzbty().zzj("Marking event as conversion", ((zzb) zza2.zzala.get(i4)).name);
                                zzc[] zzcArr2 = (zzc[]) Arrays.copyOf(((zzb) zza2.zzala.get(i4)).aoK, ((zzb) zza2.zzala.get(i4)).aoK.length + 1);
                                zzc zzc2 = new zzc();
                                zzc2.name = "_c";
                                zzc2.aoO = Long.valueOf(1);
                                zzcArr2[zzcArr2.length - 1] = zzc2;
                                ((zzb) zza2.zzala.get(i4)).aoK = zzcArr2;
                            }
                            boolean zzmk = zzal.zzmk(((zzb) zza2.zzala.get(i4)).name);
                            if (zzmk && zzbsu().zza(zzbuv(), zza2.amN.zzck, false, zzmk, false).ajO - ((long) zzbtb().zzlg(zza2.amN.zzck)) > 0) {
                                zzbsz().zzbtt().log("Too many conversions. Not logging as conversion.");
                                zzb zzb = (zzb) zza2.zzala.get(i4);
                                boolean z3 = false;
                                zzc zzc3 = null;
                                zzc[] zzcArr3 = ((zzb) zza2.zzala.get(i4)).aoK;
                                int length2 = zzcArr3.length;
                                int i6 = 0;
                                while (i6 < length2) {
                                    zzc zzc4 = zzcArr3[i6];
                                    if ("_c".equals(zzc4.name)) {
                                        z2 = z3;
                                    } else if ("_err".equals(zzc4.name)) {
                                        zzc zzc5 = zzc3;
                                        z2 = true;
                                        zzc4 = zzc5;
                                    } else {
                                        zzc4 = zzc3;
                                        z2 = z3;
                                    }
                                    i6++;
                                    z3 = z2;
                                    zzc3 = zzc4;
                                }
                                if (z3 && zzc3 != null) {
                                    zzc[] zzcArr4 = new zzc[(zzb.aoK.length - 1)];
                                    int i7 = 0;
                                    zzc[] zzcArr5 = zzb.aoK;
                                    int length3 = zzcArr5.length;
                                    int i8 = 0;
                                    while (i8 < length3) {
                                        zzc zzc6 = zzcArr5[i8];
                                        if (zzc6 != zzc3) {
                                            i2 = i7 + 1;
                                            zzcArr4[i7] = zzc6;
                                        } else {
                                            i2 = i7;
                                        }
                                        i8++;
                                        i7 = i2;
                                    }
                                    ((zzb) zza2.zzala.get(i4)).aoK = zzcArr4;
                                } else if (zzc3 != null) {
                                    zzc3.name = "_err";
                                    zzc3.aoO = Long.valueOf(10);
                                } else {
                                    zzbsz().zzbtr().log("Did not find conversion parameter. Error not tracked");
                                }
                            }
                        }
                        int i9 = i3 + 1;
                        zze.aoS[i3] = (zzb) zza2.zzala.get(i4);
                        i = i9;
                    }
                    i4++;
                    i3 = i;
                }
                if (i3 < zza2.zzala.size()) {
                    zze.aoS = (zzb[]) Arrays.copyOf(zze.aoS, i3);
                }
                zze.apl = zza(zza2.amN.zzck, zza2.amN.aoT, zze.aoS);
                zze.aoV = zze.aoS[0].aoL;
                zze.aoW = zze.aoS[0].aoL;
                for (int i10 = 1; i10 < zze.aoS.length; i10++) {
                    zzb zzb2 = zze.aoS[i10];
                    if (zzb2.aoL.longValue() < zze.aoV.longValue()) {
                        zze.aoV = zzb2.aoL;
                    }
                    if (zzb2.aoL.longValue() > zze.aoW.longValue()) {
                        zze.aoW = zzb2.aoL;
                    }
                }
                String str2 = zza2.amN.zzck;
                zza zzlo = zzbsu().zzlo(str2);
                if (zzlo == null) {
                    zzbsz().zzbtr().log("Bundling raw events w/o app info");
                } else {
                    long zzbqs = zzlo.zzbqs();
                    zze.aoY = zzbqs != 0 ? Long.valueOf(zzbqs) : null;
                    long zzbqr = zzlo.zzbqr();
                    if (zzbqr != 0) {
                        zzbqs = zzbqr;
                    }
                    zze.aoX = zzbqs != 0 ? Long.valueOf(zzbqs) : null;
                    zzlo.zzbrb();
                    zze.apj = Integer.valueOf((int) zzlo.zzbqy());
                    zzlo.zzat(zze.aoV.longValue());
                    zzlo.zzau(zze.aoW.longValue());
                    zzbsu().zza(zzlo);
                }
                zze.ajD = zzbsz().zzbtz();
                zzbsu().zza(zze);
                zzbsu().zzac(zza2.amO);
                zzbsu().zzlu(str2);
                zzbsu().setTransactionSuccessful();
                zzbsu().endTransaction();
                return true;
            }
            zzbsu().setTransactionSuccessful();
            zzbsu().endTransaction();
            return false;
        } catch (Throwable th) {
            zzbsu().endTransaction();
            throw th;
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @WorkerThread
    public boolean isEnabled() {
        boolean z = false;
        zzwu();
        zzzg();
        if (zzbtb().zzbrz()) {
            return false;
        }
        Boolean zzbsa = zzbtb().zzbsa();
        if (zzbsa != null) {
            z = zzbsa.booleanValue();
        } else if (!zzbtb().zzaql()) {
            z = true;
        }
        return zzbta().zzcb(z);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void start() {
        zzwu();
        if (!zzbuu() || (this.amq.isInitialized() && !this.amq.zzbvh())) {
            zzbsu().zzbtd();
            if (zzbuk()) {
                if (!zzbtb().zzabc() && !TextUtils.isEmpty(zzbsr().zzbqo())) {
                    String zzbue = zzbta().zzbue();
                    if (zzbue == null) {
                        zzbta().zzma(zzbsr().zzbqo());
                    } else if (!zzbue.equals(zzbsr().zzbqo())) {
                        zzbsz().zzbtw().log("Rechecking which service to use due to a GMP App Id change");
                        zzbta().zzbug();
                        this.amx.disconnect();
                        this.amx.zzaai();
                        zzbta().zzma(zzbsr().zzbqo());
                    }
                }
                if (!zzbtb().zzabc() && !zzbuu() && !TextUtils.isEmpty(zzbsr().zzbqo())) {
                    zzbsq().zzbvk();
                }
            } else if (isEnabled()) {
                if (!zzbsv().zzep("android.permission.INTERNET")) {
                    zzbsz().zzbtr().log("App is missing INTERNET permission");
                }
                if (!zzbsv().zzep("android.permission.ACCESS_NETWORK_STATE")) {
                    zzbsz().zzbtr().log("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!zzu.zzav(getContext())) {
                    zzbsz().zzbtr().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzae.zzaw(getContext())) {
                    zzbsz().zzbtr().log("AppMeasurementService not registered/enabled");
                }
                zzbsz().zzbtr().log("Uploading is not possible. App measurement disabled");
            }
            zzbva();
            return;
        }
        zzbsz().zzbtr().log("Scheduler shutting down before Scion.start() called");
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public int zza(FileChannel fileChannel) {
        int i = 0;
        zzwu();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzbsz().zzbtr().log("Bad chanel to read from");
            return i;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                zzbsz().zzbtt().zzj("Unexpected data length or empty data in channel. Bytes read", Integer.valueOf(read));
                return i;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            zzbsz().zzbtr().zzj("Failed to read from channel", e);
            return i;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zza(AppMetadata appMetadata, long j) {
        zza zzlo = zzbsu().zzlo(appMetadata.packageName);
        if (!(zzlo == null || zzlo.zzbqo() == null || zzlo.zzbqo().equals(appMetadata.ajz))) {
            zzbsz().zzbtt().log("New GMP App Id passed in. Removing cached database data.");
            zzbsu().zzlt(zzlo.zzsi());
            zzlo = null;
        }
        if (zzlo != null && zzlo.zzxc() != null && !zzlo.zzxc().equals(appMetadata.abU)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", zzlo.zzxc());
            zzb(new EventParcel("_au", new EventParams(bundle), "auto", j), appMetadata);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzh zzh, AppMetadata appMetadata) {
        zzwu();
        zzzg();
        zzab.zzaa(zzh);
        zzab.zzaa(appMetadata);
        zzab.zzhs(zzh.zzcjj);
        zzab.zzbn(zzh.zzcjj.equals(appMetadata.packageName));
        zzup.zze zze = new zzup.zze();
        zze.aoR = Integer.valueOf(1);
        zze.aoZ = "android";
        zze.zzck = appMetadata.packageName;
        zze.ajA = appMetadata.ajA;
        zze.abU = appMetadata.abU;
        zze.apm = Integer.valueOf((int) appMetadata.ajG);
        zze.apd = Long.valueOf(appMetadata.ajB);
        zze.ajz = appMetadata.ajz;
        zze.api = appMetadata.ajC == 0 ? null : Long.valueOf(appMetadata.ajC);
        Pair zzly = zzbta().zzly(appMetadata.packageName);
        if (zzly != null && !TextUtils.isEmpty((CharSequence) zzly.first)) {
            zze.apf = (String) zzly.first;
            zze.apg = (Boolean) zzly.second;
        } else if (!zzbss().zzdn(this.mContext)) {
            String string = Secure.getString(this.mContext.getContentResolver(), "android_id");
            if (string == null) {
                zzbsz().zzbtt().log("null secure ID");
                string = "null";
            } else if (string.isEmpty()) {
                zzbsz().zzbtt().log("empty secure ID");
            }
            zze.app = string;
        }
        zze.apa = zzbss().zzth();
        zze.zzct = zzbss().zzbtk();
        zze.apc = Integer.valueOf((int) zzbss().zzbtl());
        zze.apb = zzbss().zzbtm();
        zze.ape = null;
        zze.aoU = null;
        zze.aoV = null;
        zze.aoW = null;
        zza zzlo = zzbsu().zzlo(appMetadata.packageName);
        if (zzlo == null) {
            zzlo = new zza(this, appMetadata.packageName);
            zzlo.zzkz(zzbta().zzbub());
            zzlo.zzlc(appMetadata.ajH);
            zzlo.zzla(appMetadata.ajz);
            zzlo.zzlb(zzbta().zzlz(appMetadata.packageName));
            zzlo.zzay(0);
            zzlo.zzat(0);
            zzlo.zzau(0);
            zzlo.setAppVersion(appMetadata.abU);
            zzlo.zzav(appMetadata.ajG);
            zzlo.zzld(appMetadata.ajA);
            zzlo.zzaw(appMetadata.ajB);
            zzlo.zzax(appMetadata.ajC);
            zzlo.setMeasurementEnabled(appMetadata.ajE);
            zzbsu().zza(zzlo);
        }
        zze.aph = zzlo.zzawj();
        zze.ajH = zzlo.zzbqq();
        List zzln = zzbsu().zzln(appMetadata.packageName);
        zze.aoT = new zzg[zzln.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < zzln.size()) {
                zzg zzg = new zzg();
                zze.aoT[i2] = zzg;
                zzg.name = ((zzak) zzln.get(i2)).mName;
                zzg.apt = Long.valueOf(((zzak) zzln.get(i2)).anU);
                zzbsv().zza(zzg, ((zzak) zzln.get(i2)).zzcnr);
                i = i2 + 1;
            } else {
                try {
                    zzbsu().zza(zzh, zzbsu().zzb(zze));
                    return;
                } catch (IOException e) {
                    zzbsz().zzbtr().zzj("Data loss. Failed to insert raw event metadata", e);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public boolean zza(int i, FileChannel fileChannel) {
        zzwu();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzbsz().zzbtr().log("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            zzbsz().zzbtr().zzj("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            zzbsz().zzbtr().zzj("Failed to write to channel", e);
            return false;
        }
    }

    @WorkerThread
    public byte[] zza(@NonNull EventParcel eventParcel, @Size(min = 1) String str) {
        long j;
        zzzg();
        zzwu();
        zzbuw();
        zzab.zzaa(eventParcel);
        zzab.zzhs(str);
        zzd zzd = new zzd();
        zzbsu().beginTransaction();
        try {
            zza zzlo = zzbsu().zzlo(str);
            if (zzlo == null) {
                zzbsz().zzbtx().zzj("Log and bundle not available. package_name", str);
                return new byte[0];
            } else if (!zzlo.zzbqx()) {
                zzbsz().zzbtx().zzj("Log and bundle disabled. package_name", str);
                byte[] bArr = new byte[0];
                zzbsu().endTransaction();
                return bArr;
            } else {
                zzup.zze zze = new zzup.zze();
                zzd.aoP = new zzup.zze[]{zze};
                zze.aoR = Integer.valueOf(1);
                zze.aoZ = "android";
                zze.zzck = zzlo.zzsi();
                zze.ajA = zzlo.zzbqu();
                zze.abU = zzlo.zzxc();
                zze.apm = Integer.valueOf((int) zzlo.zzbqt());
                zze.apd = Long.valueOf(zzlo.zzbqv());
                zze.ajz = zzlo.zzbqo();
                zze.api = Long.valueOf(zzlo.zzbqw());
                Pair zzly = zzbta().zzly(zzlo.zzsi());
                if (zzly != null && !TextUtils.isEmpty((CharSequence) zzly.first)) {
                    zze.apf = (String) zzly.first;
                    zze.apg = (Boolean) zzly.second;
                }
                zze.apa = zzbss().zzth();
                zze.zzct = zzbss().zzbtk();
                zze.apc = Integer.valueOf((int) zzbss().zzbtl());
                zze.apb = zzbss().zzbtm();
                zze.aph = zzlo.zzawj();
                zze.ajH = zzlo.zzbqq();
                List zzln = zzbsu().zzln(zzlo.zzsi());
                zze.aoT = new zzg[zzln.size()];
                for (int i = 0; i < zzln.size(); i++) {
                    zzg zzg = new zzg();
                    zze.aoT[i] = zzg;
                    zzg.name = ((zzak) zzln.get(i)).mName;
                    zzg.apt = Long.valueOf(((zzak) zzln.get(i)).anU);
                    zzbsv().zza(zzg, ((zzak) zzln.get(i)).zzcnr);
                }
                Bundle zzbto = eventParcel.akf.zzbto();
                if ("_iap".equals(eventParcel.name)) {
                    zzbto.putLong("_c", 1);
                }
                zzbto.putString("_o", eventParcel.akg);
                zzi zzaq = zzbsu().zzaq(str, eventParcel.name);
                if (zzaq == null) {
                    zzbsu().zza(new zzi(str, eventParcel.name, 1, 0, eventParcel.akh));
                    j = 0;
                } else {
                    j = zzaq.akb;
                    zzbsu().zza(zzaq.zzbi(eventParcel.akh).zzbtn());
                }
                zzh zzh = new zzh(this, eventParcel.akg, str, eventParcel.name, eventParcel.akh, j, zzbto);
                zzb zzb = new zzb();
                zze.aoS = new zzb[]{zzb};
                zzb.aoL = Long.valueOf(zzh.pz);
                zzb.name = zzh.mName;
                zzb.aoM = Long.valueOf(zzh.ajX);
                zzb.aoK = new zzc[zzh.ajY.size()];
                Iterator it = zzh.ajY.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    zzc zzc = new zzc();
                    int i3 = i2 + 1;
                    zzb.aoK[i2] = zzc;
                    zzc.name = str2;
                    zzbsv().zza(zzc, zzh.ajY.get(str2));
                    i2 = i3;
                }
                zze.apl = zza(zzlo.zzsi(), zze.aoT, zze.aoS);
                zze.aoV = zzb.aoL;
                zze.aoW = zzb.aoL;
                long zzbqs = zzlo.zzbqs();
                zze.aoY = zzbqs != 0 ? Long.valueOf(zzbqs) : null;
                long zzbqr = zzlo.zzbqr();
                if (zzbqr != 0) {
                    zzbqs = zzbqr;
                }
                zze.aoX = zzbqs != 0 ? Long.valueOf(zzbqs) : null;
                zzlo.zzbrb();
                zze.apj = Integer.valueOf((int) zzlo.zzbqy());
                zze.ape = Long.valueOf(zzbtb().zzbqv());
                zze.aoU = Long.valueOf(zzyw().currentTimeMillis());
                zze.apk = Boolean.TRUE;
                zzlo.zzat(zze.aoV.longValue());
                zzlo.zzau(zze.aoW.longValue());
                zzbsu().zza(zzlo);
                zzbsu().setTransactionSuccessful();
                zzbsu().endTransaction();
                try {
                    byte[] bArr2 = new byte[zzd.ao()];
                    zzaov zzba = zzaov.zzba(bArr2);
                    zzd.zza(zzba);
                    zzba.ab();
                    return zzbsv().zzj(bArr2);
                } catch (IOException e) {
                    zzbsz().zzbtr().zzj("Data loss. Failed to bundle and serialize", e);
                    return null;
                }
            }
        } finally {
            zzbsu().endTransaction();
        }
    }

    public void zzas(boolean z) {
        zzbva();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzb(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        zzb(new EventParcel("_f", new EventParams(bundle), "auto", j), appMetadata);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x01d3=Splitter:B:49:0x01d3, B:78:0x02b4=Splitter:B:78:0x02b4} */
    @WorkerThread
    public void zzb(EventParcel eventParcel, AppMetadata appMetadata) {
        zzi zzbi;
        long j;
        zzak zzak;
        long nanoTime = System.nanoTime();
        zzwu();
        zzzg();
        String str = appMetadata.packageName;
        zzab.zzhs(str);
        if (!TextUtils.isEmpty(appMetadata.ajz)) {
            if (!appMetadata.ajE) {
                zze(appMetadata);
            } else if (zzbsw().zzax(str, eventParcel.name)) {
                zzbsz().zzbtt().zzj("Dropping blacklisted event", eventParcel.name);
                zzbsv().zze(11, "_ev", eventParcel.name);
            } else {
                if (zzbsz().zzaz(2)) {
                    zzbsz().zzbty().zzj("Logging event", eventParcel);
                }
                zzbsu().beginTransaction();
                try {
                    Bundle zzbto = eventParcel.akf.zzbto();
                    zze(appMetadata);
                    if ("_iap".equals(eventParcel.name) || Event.ECOMMERCE_PURCHASE.equals(eventParcel.name)) {
                        String string = zzbto.getString(Param.CURRENCY);
                        if (Event.ECOMMERCE_PURCHASE.equals(eventParcel.name)) {
                            double d = zzbto.getDouble(Param.VALUE) * 1000000.0d;
                            if (d == 0.0d) {
                                d = ((double) zzbto.getLong(Param.VALUE)) * 1000000.0d;
                            }
                            if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
                                zzbsz().zzbtt().zzj("Data lost. Currency value is too big", Double.valueOf(d));
                                zzbsu().setTransactionSuccessful();
                                zzbsu().endTransaction();
                                return;
                            }
                            j = Math.round(d);
                        } else {
                            j = zzbto.getLong(Param.VALUE);
                        }
                        if (!TextUtils.isEmpty(string)) {
                            String upperCase = string.toUpperCase(Locale.US);
                            if (upperCase.matches("[A-Z]{3}")) {
                                String valueOf = String.valueOf("_ltv_");
                                String valueOf2 = String.valueOf(upperCase);
                                String str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                                zzak zzas = zzbsu().zzas(str, str2);
                                if (zzas == null || !(zzas.zzcnr instanceof Long)) {
                                    zzbsu().zzy(str, zzbtb().zzli(str) - 1);
                                    zzak = new zzak(str, str2, zzyw().currentTimeMillis(), Long.valueOf(j));
                                } else {
                                    zzak = new zzak(str, str2, zzyw().currentTimeMillis(), Long.valueOf(j + ((Long) zzas.zzcnr).longValue()));
                                }
                                if (!zzbsu().zza(zzak)) {
                                    zzbsz().zzbtr().zze("Too many unique user properties are set. Ignoring user property.", zzak.mName, zzak.zzcnr);
                                    zzbsv().zze(9, null, null);
                                }
                            }
                        }
                    }
                    boolean zzmk = zzal.zzmk(eventParcel.name);
                    zzal.zzam(zzbto);
                    boolean equals = "_err".equals(eventParcel.name);
                    com.google.android.gms.measurement.internal.zze.zza zza2 = zzbsu().zza(zzbuv(), str, zzmk, false, equals);
                    long zzbrr = zza2.ajN - zzbtb().zzbrr();
                    if (zzbrr > 0) {
                        if (zzbrr % 1000 == 1) {
                            zzbsz().zzbtr().zzj("Data loss. Too many events logged. count", Long.valueOf(zza2.ajN));
                        }
                        zzbsv().zze(16, "_ev", eventParcel.name);
                        zzbsu().setTransactionSuccessful();
                        return;
                    }
                    if (zzmk) {
                        long zzbrs = zza2.ajM - zzbtb().zzbrs();
                        if (zzbrs > 0) {
                            if (zzbrs % 1000 == 1) {
                                zzbsz().zzbtr().zzj("Data loss. Too many public events logged. count", Long.valueOf(zza2.ajM));
                            }
                            zzbsv().zze(16, "_ev", eventParcel.name);
                            zzbsu().setTransactionSuccessful();
                            zzbsu().endTransaction();
                            return;
                        }
                    }
                    if (equals) {
                        long zzbrt = zza2.ajP - zzbtb().zzbrt();
                        if (zzbrt > 0) {
                            if (zzbrt == 1) {
                                zzbsz().zzbtr().zzj("Too many error events logged. count", Long.valueOf(zza2.ajP));
                            }
                            zzbsu().setTransactionSuccessful();
                            zzbsu().endTransaction();
                            return;
                        }
                    }
                    zzbsv().zza(zzbto, "_o", (Object) eventParcel.akg);
                    long zzlp = zzbsu().zzlp(str);
                    if (zzlp > 0) {
                        zzbsz().zzbtt().zzj("Data lost. Too many events stored on disk, deleted", Long.valueOf(zzlp));
                    }
                    zzh zzh = new zzh(this, eventParcel.akg, str, eventParcel.name, eventParcel.akh, 0, zzbto);
                    zzi zzaq = zzbsu().zzaq(str, zzh.mName);
                    if (zzaq != null) {
                        zzh = zzh.zza(this, zzaq.akb);
                        zzbi = zzaq.zzbi(zzh.pz);
                    } else if (zzbsu().zzlv(str) >= ((long) zzbtb().zzbrq())) {
                        zzbsz().zzbtr().zze("Too many event names used, ignoring event. name, supported count", zzh.mName, Integer.valueOf(zzbtb().zzbrq()));
                        zzbsv().zze(8, null, null);
                        zzbsu().endTransaction();
                        return;
                    } else {
                        zzbi = new zzi(str, zzh.mName, 0, 0, zzh.pz);
                    }
                    zzbsu().zza(zzbi);
                    zza(zzh, appMetadata);
                    zzbsu().setTransactionSuccessful();
                    if (zzbsz().zzaz(2)) {
                        zzbsz().zzbty().zzj("Event recorded", zzh);
                    }
                    zzbsu().endTransaction();
                    zzbva();
                    zzbsz().zzbty().zzj("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } finally {
                    zzbsu().endTransaction();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzb(EventParcel eventParcel, String str) {
        zza zzlo = zzbsu().zzlo(str);
        if (zzlo == null || TextUtils.isEmpty(zzlo.zzxc())) {
            zzbsz().zzbtx().zzj("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = getContext().getPackageManager().getPackageInfo(str, 0).versionName;
            if (zzlo.zzxc() != null && !zzlo.zzxc().equals(str2)) {
                zzbsz().zzbtt().zzj("App version does not match; dropping event", str);
                return;
            }
        } catch (NameNotFoundException e) {
            if (!"_ui".equals(eventParcel.name)) {
                zzbsz().zzbtt().zzj("Could not find package", str);
            }
        }
        EventParcel eventParcel2 = eventParcel;
        zzb(eventParcel2, new AppMetadata(str, zzlo.zzbqo(), zzlo.zzxc(), zzlo.zzbqt(), zzlo.zzbqu(), zzlo.zzbqv(), zzlo.zzbqw(), null, zzlo.zzbqx(), false, zzlo.zzbqq()));
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzb(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzwu();
        zzzg();
        if (!TextUtils.isEmpty(appMetadata.ajz)) {
            if (!appMetadata.ajE) {
                zze(appMetadata);
                return;
            }
            int zzmo = zzbsv().zzmo(userAttributeParcel.name);
            if (zzmo != 0) {
                zzbsv().zze(zzmo, "_ev", zzbsv().zza(userAttributeParcel.name, zzbtb().zzbrk(), true));
                return;
            }
            int zzm = zzbsv().zzm(userAttributeParcel.name, userAttributeParcel.getValue());
            if (zzm != 0) {
                zzbsv().zze(zzm, "_ev", zzbsv().zza(userAttributeParcel.name, zzbtb().zzbrk(), true));
                return;
            }
            Object zzn = zzbsv().zzn(userAttributeParcel.name, userAttributeParcel.getValue());
            if (zzn != null) {
                zzak zzak = new zzak(appMetadata.packageName, userAttributeParcel.name, userAttributeParcel.anQ, zzn);
                zzbsz().zzbtx().zze("Setting user property", zzak.mName, zzn);
                zzbsu().beginTransaction();
                try {
                    zze(appMetadata);
                    boolean zza2 = zzbsu().zza(zzak);
                    zzbsu().setTransactionSuccessful();
                    if (zza2) {
                        zzbsz().zzbtx().zze("User property set", zzak.mName, zzak.zzcnr);
                    } else {
                        zzbsz().zzbtr().zze("Too many unique user properties are set. Ignoring user property.", zzak.mName, zzak.zzcnr);
                        zzbsv().zze(9, null, null);
                    }
                } finally {
                    zzbsu().endTransaction();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzb(zzaa zzaa) {
        this.amK++;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = false;
        zzwu();
        zzzg();
        zzab.zzhs(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        zzbsu().beginTransaction();
        try {
            zza zzlo = zzbsu().zzlo(str);
            boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
            if (zzlo == null) {
                zzbsz().zzbtt().zzj("App does not exist in onConfigFetched", str);
            } else if (z2 || i == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (zzbsw().zzmc(str) == null && !zzbsw().zzb(str, null, null)) {
                        zzbsu().endTransaction();
                        return;
                    }
                } else if (!zzbsw().zzb(str, bArr, str2)) {
                    zzbsu().endTransaction();
                    return;
                }
                zzlo.zzaz(zzyw().currentTimeMillis());
                zzbsu().zza(zzlo);
                if (i == 404) {
                    zzbsz().zzbtt().log("Config not found. Using empty config");
                } else {
                    zzbsz().zzbty().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (!zzbuo().zzadj() || !zzbuz()) {
                    zzbva();
                } else {
                    zzbuy();
                }
            } else {
                zzlo.zzba(zzyw().currentTimeMillis());
                zzbsu().zza(zzlo);
                zzbsz().zzbty().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzbsw().zzme(str);
                zzbta().alw.set(zzyw().currentTimeMillis());
                if (i == 503 || i == 429) {
                    z = true;
                }
                if (z) {
                    zzbta().alx.set(zzyw().currentTimeMillis());
                }
                zzbva();
            }
            zzbsu().setTransactionSuccessful();
        } finally {
            zzbsu().endTransaction();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzbk(long j) {
        return zzh(null, j);
    }

    public zzc zzbsp() {
        zza((zzaa) this.amD);
        return this.amD;
    }

    public zzac zzbsq() {
        zza((zzaa) this.amz);
        return this.amz;
    }

    public zzn zzbsr() {
        zza((zzaa) this.amA);
        return this.amA;
    }

    public zzg zzbss() {
        zza((zzaa) this.amy);
        return this.amy;
    }

    public zzad zzbst() {
        zza((zzaa) this.amx);
        return this.amx;
    }

    public zze zzbsu() {
        zza((zzaa) this.amv);
        return this.amv;
    }

    public zzal zzbsv() {
        zza((zzz) this.amu);
        return this.amu;
    }

    public zzv zzbsw() {
        zza((zzaa) this.ams);
        return this.ams;
    }

    public zzaf zzbsx() {
        zza((zzaa) this.amr);
        return this.amr;
    }

    public zzw zzbsy() {
        zza((zzaa) this.amq);
        return this.amq;
    }

    public zzp zzbsz() {
        zza((zzaa) this.amp);
        return this.amp;
    }

    public zzt zzbta() {
        zza((zzz) this.amo);
        return this.amo;
    }

    public zzd zzbtb() {
        return this.amn;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public boolean zzbuk() {
        zzzg();
        zzwu();
        if (this.amG == null) {
            this.amG = Boolean.valueOf(zzbsv().zzep("android.permission.INTERNET") && zzbsv().zzep("android.permission.ACCESS_NETWORK_STATE") && zzu.zzav(getContext()) && zzae.zzaw(getContext()));
            if (this.amG.booleanValue() && !zzbtb().zzabc()) {
                this.amG = Boolean.valueOf(zzbsv().zzmr(zzbsr().zzbqo()));
            }
        }
        return this.amG.booleanValue();
    }

    public zzp zzbul() {
        if (this.amp == null || !this.amp.isInitialized()) {
            return null;
        }
        return this.amp;
    }

    /* access modifiers changed from: 0000 */
    public zzw zzbum() {
        return this.amq;
    }

    public AppMeasurement zzbun() {
        return this.amt;
    }

    public zzq zzbuo() {
        zza((zzaa) this.amw);
        return this.amw;
    }

    public zzr zzbup() {
        if (this.amB != null) {
            return this.amB;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public zzai zzbuq() {
        zza((zzaa) this.amC);
        return this.amC;
    }

    /* access modifiers changed from: 0000 */
    public FileChannel zzbur() {
        return this.amI;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzbus() {
        zzwu();
        zzzg();
        if (zzbve() && zzbut()) {
            zzu(zza(zzbur()), zzbsr().zzbtp());
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public boolean zzbut() {
        zzwu();
        try {
            this.amI = new RandomAccessFile(new File(getContext().getFilesDir(), this.amv.zzaab()), "rw").getChannel();
            this.amH = this.amI.tryLock();
            if (this.amH != null) {
                zzbsz().zzbty().log("Storage concurrent access okay");
                return true;
            }
            zzbsz().zzbtr().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzbsz().zzbtr().zzj("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Failed to access storage lock file", e2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzbuu() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public long zzbuv() {
        return ((((zzyw().currentTimeMillis() + zzbta().zzbuc()) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: 0000 */
    public void zzbuw() {
        if (!zzbtb().zzabc()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    @WorkerThread
    public void zzbuy() {
        Object obj;
        List list;
        ArrayMap arrayMap = null;
        zzwu();
        zzzg();
        if (!zzbtb().zzabc()) {
            Boolean zzbuf = zzbta().zzbuf();
            if (zzbuf == null) {
                zzbsz().zzbtt().log("Upload data called on the client side before use of service was decided");
                return;
            } else if (zzbuf.booleanValue()) {
                zzbsz().zzbtr().log("Upload called in the client side when service should be used");
                return;
            }
        }
        if (zzbux()) {
            zzbsz().zzbtt().log("Uploading requested multiple times");
        } else if (!zzbuo().zzadj()) {
            zzbsz().zzbtt().log("Network not connected, ignoring upload request");
            zzbva();
        } else {
            long currentTimeMillis = zzyw().currentTimeMillis();
            zzbk(currentTimeMillis - zzbtb().zzbsh());
            long j = zzbta().alv.get();
            if (j != 0) {
                zzbsz().zzbtx().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
            }
            String zzbtc = zzbsu().zzbtc();
            if (!TextUtils.isEmpty(zzbtc)) {
                List zzn = zzbsu().zzn(zzbtc, zzbtb().zzlk(zzbtc), zzbtb().zzll(zzbtc));
                if (!zzn.isEmpty()) {
                    Iterator it = zzn.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        zzup.zze zze = (zzup.zze) ((Pair) it.next()).first;
                        if (!TextUtils.isEmpty(zze.apf)) {
                            obj = zze.apf;
                            break;
                        }
                    }
                    if (obj != null) {
                        int i = 0;
                        while (true) {
                            if (i >= zzn.size()) {
                                break;
                            }
                            zzup.zze zze2 = (zzup.zze) ((Pair) zzn.get(i)).first;
                            if (!TextUtils.isEmpty(zze2.apf) && !zze2.apf.equals(obj)) {
                                list = zzn.subList(0, i);
                                break;
                            }
                            i++;
                        }
                    }
                    list = zzn;
                    zzd zzd = new zzd();
                    zzd.aoP = new zzup.zze[list.size()];
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int i2 = 0; i2 < zzd.aoP.length; i2++) {
                        zzd.aoP[i2] = (zzup.zze) ((Pair) list.get(i2)).first;
                        arrayList.add((Long) ((Pair) list.get(i2)).second);
                        zzd.aoP[i2].ape = Long.valueOf(zzbtb().zzbqv());
                        zzd.aoP[i2].aoU = Long.valueOf(currentTimeMillis);
                        zzd.aoP[i2].apk = Boolean.valueOf(zzbtb().zzabc());
                    }
                    String str = zzbsz().zzaz(2) ? zzal.zzb(zzd) : null;
                    byte[] zza2 = zzbsv().zza(zzd);
                    String zzbsg = zzbtb().zzbsg();
                    try {
                        URL url = new URL(zzbsg);
                        zzad(arrayList);
                        zzbta().alw.set(currentTimeMillis);
                        String str2 = "?";
                        if (zzd.aoP.length > 0) {
                            str2 = zzd.aoP[0].zzck;
                        }
                        zzbsz().zzbty().zzd("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(zza2.length), str);
                        zzbuo().zza(zzbtc, url, zza2, null, new zza() {
                            public void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
                                zzx.this.zza(i, th, bArr);
                            }
                        });
                    } catch (MalformedURLException e) {
                        zzbsz().zzbtr().zzj("Failed to parse upload URL. Not uploading", zzbsg);
                    }
                }
            } else {
                String zzbh = zzbsu().zzbh(currentTimeMillis - zzbtb().zzbsh());
                if (!TextUtils.isEmpty(zzbh)) {
                    zza zzlo = zzbsu().zzlo(zzbh);
                    if (zzlo != null) {
                        String zzap = zzbtb().zzap(zzlo.zzbqo(), zzlo.zzawj());
                        try {
                            URL url2 = new URL(zzap);
                            zzbsz().zzbty().zzj("Fetching remote configuration", zzlo.zzsi());
                            zzuo.zzb zzmc = zzbsw().zzmc(zzlo.zzsi());
                            String zzmd = zzbsw().zzmd(zzlo.zzsi());
                            if (zzmc != null && !TextUtils.isEmpty(zzmd)) {
                                arrayMap = new ArrayMap();
                                arrayMap.put("If-Modified-Since", zzmd);
                            }
                            zzbuo().zza(zzbh, url2, arrayMap, new zza() {
                                public void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
                                    zzx.this.zzb(str, i, th, bArr, map);
                                }
                            });
                        } catch (MalformedURLException e2) {
                            zzbsz().zzbtr().zzj("Failed to parse config URL. Not fetching", zzap);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzbvc() {
        this.amL++;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzbvd() {
        zzwu();
        zzzg();
        if (!this.amF) {
            zzbsz().zzbtw().log("This instance being marked as an uploader");
            zzbus();
        }
        this.amF = true;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public boolean zzbve() {
        zzwu();
        zzzg();
        return this.amF || zzbuu();
    }

    /* access modifiers changed from: 0000 */
    public void zzc(AppMetadata appMetadata) {
        zzwu();
        zzzg();
        zzab.zzhs(appMetadata.packageName);
        zze(appMetadata);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzc(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        zzb(new EventParcel("_e", new EventParams(bundle), "auto", j), appMetadata);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzc(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzwu();
        zzzg();
        if (!TextUtils.isEmpty(appMetadata.ajz)) {
            if (!appMetadata.ajE) {
                zze(appMetadata);
                return;
            }
            zzbsz().zzbtx().zzj("Removing user property", userAttributeParcel.name);
            zzbsu().beginTransaction();
            try {
                zze(appMetadata);
                zzbsu().zzar(appMetadata.packageName, userAttributeParcel.name);
                zzbsu().setTransactionSuccessful();
                zzbsz().zzbtx().zzj("User property removed", userAttributeParcel.name);
            } finally {
                zzbsu().endTransaction();
            }
        }
    }

    @WorkerThread
    public void zzd(AppMetadata appMetadata) {
        zzwu();
        zzzg();
        zzab.zzaa(appMetadata);
        zzab.zzhs(appMetadata.packageName);
        if (!TextUtils.isEmpty(appMetadata.ajz)) {
            if (!appMetadata.ajE) {
                zze(appMetadata);
                return;
            }
            long currentTimeMillis = zzyw().currentTimeMillis();
            zzbsu().beginTransaction();
            try {
                zza(appMetadata, currentTimeMillis);
                zze(appMetadata);
                if (zzbsu().zzaq(appMetadata.packageName, "_f") == null) {
                    zzb(new UserAttributeParcel("_fot", currentTimeMillis, Long.valueOf((1 + (currentTimeMillis / 3600000)) * 3600000), "auto"), appMetadata);
                    zzb(appMetadata, currentTimeMillis);
                    zzc(appMetadata, currentTimeMillis);
                } else if (appMetadata.ajF) {
                    zzd(appMetadata, currentTimeMillis);
                }
                zzbsu().setTransactionSuccessful();
            } finally {
                zzbsu().endTransaction();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzd(AppMetadata appMetadata, long j) {
        zzb(new EventParcel("_cd", new EventParams(new Bundle()), "auto", j), appMetadata);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public boolean zzu(int i, int i2) {
        zzwu();
        if (i > i2) {
            zzbsz().zzbtr().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (zza(i2, zzbur())) {
                zzbsz().zzbty().zze("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                zzbsz().zzbtr().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }

    @WorkerThread
    public void zzwu() {
        zzbsy().zzwu();
    }

    /* access modifiers changed from: 0000 */
    public void zzyv() {
        if (zzbtb().zzabc()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public zze zzyw() {
        return this.zzaoa;
    }

    /* access modifiers changed from: 0000 */
    public void zzzg() {
        if (!this.zzcwt) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }
}
