package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.zzab;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;

class zzt extends zzaa {
    static final Pair<String, Long> alt = new Pair<>("", Long.valueOf(0));
    /* access modifiers changed from: private */
    public SharedPreferences al;
    private String alA;
    private boolean alB;
    private long alC;
    private SecureRandom alD;
    public final zzb alE = new zzb("time_before_start", 10000);
    public final zzb alF = new zzb("session_timeout", 1800000);
    public final zza alG = new zza("start_new_session", true);
    public final zzb alH = new zzb("last_pause_time", 0);
    public final zzb alI = new zzb("time_active", 0);
    public boolean alJ;
    public final zzc alu = new zzc("health_monitor", zzbtb().zzaci());
    public final zzb alv = new zzb("last_upload", 0);
    public final zzb alw = new zzb("last_upload_attempt", 0);
    public final zzb alx = new zzb("backoff", 0);
    public final zzb aly = new zzb("last_delete_stale", 0);
    public final zzb alz = new zzb("midnight_offset", 0);

    public final class zza {
        private final boolean alK;
        private boolean alL;
        private boolean rD;
        private final String zzaxn;

        public zza(String str, boolean z) {
            zzab.zzhs(str);
            this.zzaxn = str;
            this.alK = z;
        }

        @WorkerThread
        private void zzbui() {
            if (!this.alL) {
                this.alL = true;
                this.rD = zzt.this.al.getBoolean(this.zzaxn, this.alK);
            }
        }

        @WorkerThread
        public boolean get() {
            zzbui();
            return this.rD;
        }

        @WorkerThread
        public void set(boolean z) {
            Editor edit = zzt.this.al.edit();
            edit.putBoolean(this.zzaxn, z);
            edit.apply();
            this.rD = z;
        }
    }

    public final class zzb {
        private boolean alL;
        private final long alN;
        private final String zzaxn;
        private long zzcvh;

        public zzb(String str, long j) {
            zzab.zzhs(str);
            this.zzaxn = str;
            this.alN = j;
        }

        @WorkerThread
        private void zzbui() {
            if (!this.alL) {
                this.alL = true;
                this.zzcvh = zzt.this.al.getLong(this.zzaxn, this.alN);
            }
        }

        @WorkerThread
        public long get() {
            zzbui();
            return this.zzcvh;
        }

        @WorkerThread
        public void set(long j) {
            Editor edit = zzt.this.al.edit();
            edit.putLong(this.zzaxn, j);
            edit.apply();
            this.zzcvh = j;
        }
    }

    public final class zzc {
        final String alO;
        private final String alP;
        private final String alQ;
        private final long ap;

        private zzc(String str, long j) {
            zzab.zzhs(str);
            zzab.zzbn(j > 0);
            this.alO = String.valueOf(str).concat(":start");
            this.alP = String.valueOf(str).concat(":count");
            this.alQ = String.valueOf(str).concat(":value");
            this.ap = j;
        }

        @WorkerThread
        private void zzadt() {
            zzt.this.zzwu();
            long currentTimeMillis = zzt.this.zzyw().currentTimeMillis();
            Editor edit = zzt.this.al.edit();
            edit.remove(this.alP);
            edit.remove(this.alQ);
            edit.putLong(this.alO, currentTimeMillis);
            edit.apply();
        }

        @WorkerThread
        private long zzadu() {
            zzt.this.zzwu();
            long zzadw = zzadw();
            if (zzadw != 0) {
                return Math.abs(zzadw - zzt.this.zzyw().currentTimeMillis());
            }
            zzadt();
            return 0;
        }

        @WorkerThread
        private long zzadw() {
            return zzt.this.zzbud().getLong(this.alO, 0);
        }

        @WorkerThread
        public Pair<String, Long> zzadv() {
            zzt.this.zzwu();
            long zzadu = zzadu();
            if (zzadu < this.ap) {
                return null;
            }
            if (zzadu > this.ap * 2) {
                zzadt();
                return null;
            }
            String string = zzt.this.zzbud().getString(this.alQ, null);
            long j = zzt.this.zzbud().getLong(this.alP, 0);
            zzadt();
            return (string == null || j <= 0) ? zzt.alt : new Pair<>(string, Long.valueOf(j));
        }

        @WorkerThread
        public void zzew(String str) {
            zzg(str, 1);
        }

        @WorkerThread
        public void zzg(String str, long j) {
            zzt.this.zzwu();
            if (zzadw() == 0) {
                zzadt();
            }
            if (str == null) {
                str = "";
            }
            long j2 = zzt.this.al.getLong(this.alP, 0);
            if (j2 <= 0) {
                Editor edit = zzt.this.al.edit();
                edit.putString(this.alQ, str);
                edit.putLong(this.alP, j);
                edit.apply();
                return;
            }
            boolean z = (zzt.this.zzbua().nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j;
            Editor edit2 = zzt.this.al.edit();
            if (z) {
                edit2.putString(this.alQ, str);
            }
            edit2.putLong(this.alP, j2 + j);
            edit2.apply();
        }
    }

    zzt(zzx zzx) {
        super(zzx);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public SecureRandom zzbua() {
        zzwu();
        if (this.alD == null) {
            this.alD = new SecureRandom();
        }
        return this.alD;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public SharedPreferences zzbud() {
        zzwu();
        zzzg();
        return this.al;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void setMeasurementEnabled(boolean z) {
        zzwu();
        zzbsz().zzbty().zzj("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = zzbud().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public String zzbqq() {
        zzwu();
        return com.google.firebase.iid.zzc.zzcwt().getId();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public String zzbub() {
        byte[] bArr = new byte[16];
        zzbua().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public long zzbuc() {
        zzzg();
        zzwu();
        long j = this.alz.get();
        if (j != 0) {
            return j;
        }
        long nextInt = (long) (zzbua().nextInt(86400000) + 1);
        this.alz.set(nextInt);
        return nextInt;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public String zzbue() {
        zzwu();
        return zzbud().getString("gmp_app_id", null);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public Boolean zzbuf() {
        zzwu();
        if (!zzbud().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzbud().getBoolean("use_service", false));
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzbug() {
        boolean z = true;
        zzwu();
        zzbsz().zzbty().log("Clearing collection preferences.");
        boolean contains = zzbud().contains("measurement_enabled");
        if (contains) {
            z = zzcb(true);
        }
        Editor edit = zzbud().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public String zzbuh() {
        zzwu();
        String string = zzbud().getString("previous_os_version", null);
        String zzbtk = zzbss().zzbtk();
        if (!TextUtils.isEmpty(zzbtk) && !zzbtk.equals(string)) {
            Editor edit = zzbud().edit();
            edit.putString("previous_os_version", zzbtk);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzca(boolean z) {
        zzwu();
        zzbsz().zzbty().zzj("Setting useService", Boolean.valueOf(z));
        Editor edit = zzbud().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public boolean zzcb(boolean z) {
        zzwu();
        return zzbud().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    @NonNull
    public Pair<String, Boolean> zzly(String str) {
        zzwu();
        long elapsedRealtime = zzyw().elapsedRealtime();
        if (this.alA != null && elapsedRealtime < this.alC) {
            return new Pair<>(this.alA, Boolean.valueOf(this.alB));
        }
        this.alC = elapsedRealtime + zzbtb().zzlh(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            this.alA = advertisingIdInfo.getId();
            if (this.alA == null) {
                this.alA = "";
            }
            this.alB = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            zzbsz().zzbtx().zzj("Unable to get advertising id", th);
            this.alA = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.alA, Boolean.valueOf(this.alB));
    }

    /* access modifiers changed from: 0000 */
    public String zzlz(String str) {
        String str2 = (String) zzly(str).first;
        MessageDigest zzfb = zzal.zzfb("MD5");
        if (zzfb == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzfb.digest(str2.getBytes()))});
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzma(String str) {
        zzwu();
        Editor edit = zzbud().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public void zzwv() {
        this.al = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.alJ = this.al.getBoolean("has_been_opened", false);
        if (!this.alJ) {
            Editor edit = this.al.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }
}
