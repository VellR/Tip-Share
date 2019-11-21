package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.stats.zzf;
import com.google.android.gms.common.stats.zzh;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzw;
import com.google.android.gms.common.util.zzz;

public class zzvz {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String auz = "*gcore*:";
    private final String AA;
    private final String Ay;
    private WorkSource acv;
    private final WakeLock auA;
    private final int auB;
    private final String auC;
    private boolean auD;
    private int auE;
    private int auF;
    private final Context mContext;

    public zzvz(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzvz(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzvz(Context context, int i, String str, String str2, String str3, String str4) {
        this.auD = true;
        zzab.zzh(str, "Wake lock name can NOT be empty");
        this.auB = i;
        this.auC = str2;
        this.AA = str4;
        this.mContext = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(auz);
            String valueOf2 = String.valueOf(str);
            this.Ay = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.Ay = str;
        }
        this.auA = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzz.zzco(this.mContext)) {
            if (zzw.zzic(str3)) {
                str3 = context.getPackageName();
            }
            this.acv = zzz.zzr(context, str3);
            zzc(this.acv);
        }
    }

    private void zzd(WorkSource workSource) {
        try {
            this.auA.setWorkSource(workSource);
        } catch (IllegalArgumentException e) {
            Log.wtf(TAG, e.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r12.auF == 0) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0 == false) goto L_0x0017;
     */
    private void zzk(String str, long j) {
        boolean zznj = zznj(str);
        String zzp = zzp(str, zznj);
        synchronized (this) {
            if (this.auD) {
                int i = this.auE;
                this.auE = i + 1;
                if (i != 0) {
                }
                zzh.zzave().zza(this.mContext, zzf.zza(this.auA, zzp), 7, this.Ay, zzp, this.AA, this.auB, zzz.zzb(this.acv), j);
                this.auF++;
            }
            if (!this.auD) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r9.auF == 1) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0 == false) goto L_0x0017;
     */
    private void zzni(String str) {
        boolean zznj = zznj(str);
        String zzp = zzp(str, zznj);
        synchronized (this) {
            if (this.auD) {
                int i = this.auE - 1;
                this.auE = i;
                if (i != 0) {
                }
                zzh.zzave().zza(this.mContext, zzf.zza(this.auA, zzp), 8, this.Ay, zzp, this.AA, this.auB, zzz.zzb(this.acv));
                this.auF--;
            }
            if (!this.auD) {
            }
        }
    }

    private boolean zznj(String str) {
        return !TextUtils.isEmpty(str) && !str.equals(this.auC);
    }

    private String zzp(String str, boolean z) {
        return this.auD ? z ? str : this.auC : this.auC;
    }

    public void acquire(long j) {
        if (!zzs.zzavm() && this.auD) {
            String str = TAG;
            String str2 = "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ";
            String valueOf = String.valueOf(this.Ay);
            Log.wtf(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        zzk(null, j);
        this.auA.acquire(j);
    }

    public boolean isHeld() {
        return this.auA.isHeld();
    }

    public void release() {
        zzni(null);
        this.auA.release();
    }

    public void setReferenceCounted(boolean z) {
        this.auA.setReferenceCounted(z);
        this.auD = z;
    }

    public void zzc(WorkSource workSource) {
        if (workSource != null && zzz.zzco(this.mContext)) {
            if (this.acv != null) {
                this.acv.add(workSource);
            } else {
                this.acv = workSource;
            }
            zzd(this.acv);
        }
    }
}
