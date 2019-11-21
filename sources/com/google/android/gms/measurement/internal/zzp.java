package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.measurement.AppMeasurement;

public class zzp extends zzaa {
    private final long ajo = zzbtb().zzbqv();
    private final char akM;
    private final zza akN;
    private final zza akO;
    private final zza akP;
    private final zza akQ;
    private final zza akR;
    private final zza akS;
    private final zza akT;
    private final zza akU;
    private final zza akV;
    private final String yQ = zzbtb().zzbrh();

    public class zza {
        private final boolean akY;
        private final boolean akZ;
        private final int mPriority;

        zza(int i, boolean z, boolean z2) {
            this.mPriority = i;
            this.akY = z;
            this.akZ = z2;
        }

        public void log(String str) {
            zzp.this.zza(this.mPriority, this.akY, this.akZ, str, null, null, null);
        }

        public void zzd(String str, Object obj, Object obj2, Object obj3) {
            zzp.this.zza(this.mPriority, this.akY, this.akZ, str, obj, obj2, obj3);
        }

        public void zze(String str, Object obj, Object obj2) {
            zzp.this.zza(this.mPriority, this.akY, this.akZ, str, obj, obj2, null);
        }

        public void zzj(String str, Object obj) {
            zzp.this.zza(this.mPriority, this.akY, this.akZ, str, obj, null, null);
        }
    }

    zzp(zzx zzx) {
        super(zzx);
        if (zzbtb().zzabd()) {
            this.akM = zzbtb().zzabc() ? 'P' : 'C';
        } else {
            this.akM = zzbtb().zzabc() ? 'p' : 'c';
        }
        this.akN = new zza(6, false, false);
        this.akO = new zza(6, true, false);
        this.akP = new zza(6, false, true);
        this.akQ = new zza(5, false, false);
        this.akR = new zza(5, true, false);
        this.akS = new zza(5, false, true);
        this.akT = new zza(4, false, false);
        this.akU = new zza(3, false, false);
        this.akV = new zza(2, false, false);
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String zzc = zzc(z, obj);
        String zzc2 = zzc(z, obj2);
        String zzc3 = zzc(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzc)) {
            sb.append(str2);
            sb.append(zzc);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzc2)) {
            sb.append(str2);
            sb.append(zzc2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzc3)) {
            sb.append(str2);
            sb.append(zzc3);
        }
        return sb.toString();
    }

    static String zzc(boolean z, Object obj) {
        StackTraceElement stackTraceElement;
        if (obj == null) {
            return "";
        }
        Object obj2 = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (obj2 instanceof Long) {
            if (!z) {
                return String.valueOf(obj2);
            }
            if (Math.abs(((Long) obj2).longValue()) < 100) {
                return String.valueOf(obj2);
            }
            String str = String.valueOf(obj2).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(((Long) obj2).longValue()));
            return new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d)).toString();
        } else if (obj2 instanceof Boolean) {
            return String.valueOf(obj2);
        } else {
            if (!(obj2 instanceof Throwable)) {
                return z ? "-" : String.valueOf(obj2);
            }
            Throwable th = (Throwable) obj2;
            StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String zzlx = zzlx(AppMeasurement.class.getCanonicalName());
            String zzlx2 = zzlx(zzx.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                stackTraceElement = stackTrace[i];
                if (!stackTraceElement.isNativeMethod()) {
                    String className = stackTraceElement.getClassName();
                    if (className != null) {
                        String zzlx3 = zzlx(className);
                        if (zzlx3.equals(zzlx) || zzlx3.equals(zzlx2)) {
                            sb.append(": ");
                            sb.append(stackTraceElement);
                        }
                    } else {
                        continue;
                    }
                }
                i++;
            }
            sb.append(": ");
            sb.append(stackTraceElement);
            return sb.toString();
        }
    }

    private static String zzlx(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    public void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zzaz(i)) {
            zzo(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzaz(int i) {
        return Log.isLoggable(this.yQ, i);
    }

    public void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        zzab.zzaa(str);
        zzw zzbum = this.aja.zzbum();
        if (zzbum == null) {
            zzo(6, "Scheduler not set. Not logging error/warn.");
        } else if (!zzbum.isInitialized()) {
            zzo(6, "Scheduler not initialized. Not logging error/warn.");
        } else if (zzbum.zzbvh()) {
            zzo(6, "Scheduler shutdown. Not logging error/warn.");
        } else {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String valueOf = String.valueOf("1");
            char charAt = "01VDIWEA?".charAt(i);
            char c = this.akM;
            long j = this.ajo;
            String valueOf2 = String.valueOf(zza(true, str, obj, obj2, obj3));
            final String sb = new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
            if (sb.length() > 1024) {
                sb = str.substring(0, 1024);
            }
            zzbum.zzl(new Runnable() {
                public void run() {
                    zzt zzbta = zzp.this.aja.zzbta();
                    if (!zzbta.isInitialized() || zzbta.zzbvh()) {
                        zzp.this.zzo(6, "Persisted config not initialized . Not logging error/warn.");
                    } else {
                        zzbta.alu.zzew(sb);
                    }
                }
            });
        }
    }

    public /* bridge */ /* synthetic */ void zzbso() {
        super.zzbso();
    }

    public /* bridge */ /* synthetic */ zzc zzbsp() {
        return super.zzbsp();
    }

    public /* bridge */ /* synthetic */ zzac zzbsq() {
        return super.zzbsq();
    }

    public /* bridge */ /* synthetic */ zzn zzbsr() {
        return super.zzbsr();
    }

    public /* bridge */ /* synthetic */ zzg zzbss() {
        return super.zzbss();
    }

    public /* bridge */ /* synthetic */ zzad zzbst() {
        return super.zzbst();
    }

    public /* bridge */ /* synthetic */ zze zzbsu() {
        return super.zzbsu();
    }

    public /* bridge */ /* synthetic */ zzal zzbsv() {
        return super.zzbsv();
    }

    public /* bridge */ /* synthetic */ zzv zzbsw() {
        return super.zzbsw();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsx() {
        return super.zzbsx();
    }

    public /* bridge */ /* synthetic */ zzw zzbsy() {
        return super.zzbsy();
    }

    public /* bridge */ /* synthetic */ zzp zzbsz() {
        return super.zzbsz();
    }

    public /* bridge */ /* synthetic */ zzt zzbta() {
        return super.zzbta();
    }

    public /* bridge */ /* synthetic */ zzd zzbtb() {
        return super.zzbtb();
    }

    public zza zzbtr() {
        return this.akN;
    }

    public zza zzbts() {
        return this.akO;
    }

    public zza zzbtt() {
        return this.akQ;
    }

    public zza zzbtu() {
        return this.akR;
    }

    public zza zzbtv() {
        return this.akS;
    }

    public zza zzbtw() {
        return this.akT;
    }

    public zza zzbtx() {
        return this.akU;
    }

    public zza zzbty() {
        return this.akV;
    }

    public String zzbtz() {
        Pair<String, Long> zzadv = zzbta().alu.zzadv();
        if (zzadv == null || zzadv == zzt.alt) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(zzadv.second));
        String str = (String) zzadv.first;
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    /* access modifiers changed from: protected */
    public void zzo(int i, String str) {
        Log.println(i, this.yQ, str);
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    /* access modifiers changed from: protected */
    public void zzwv() {
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
