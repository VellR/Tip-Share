package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.AppMeasurement.zzb;
import com.google.android.gms.measurement.AppMeasurement.zzc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzac extends zzaa {
    private zza amW;
    private zzb amX;
    private final Set<zzc> amY = new HashSet();
    private boolean amZ;

    @MainThread
    @TargetApi(14)
    private class zza implements ActivityLifecycleCallbacks {
        private zza() {
        }

        private boolean zzmi(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            zzac.this.zzd("auto", "_ldl", str);
            return true;
        }

        private boolean zzs(Uri uri) {
            String queryParameter = uri.getQueryParameter("utm_campaign");
            String queryParameter2 = uri.getQueryParameter("utm_source");
            String queryParameter3 = uri.getQueryParameter("utm_medium");
            String queryParameter4 = uri.getQueryParameter("gclid");
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                return false;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("term", queryParameter5);
            }
            String queryParameter6 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("content", queryParameter6);
            }
            String queryParameter7 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("aclid", queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("cp1", queryParameter8);
            }
            String queryParameter9 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString("anid", queryParameter9);
            }
            zzac.this.zze("auto", "_cmp", bundle);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                zzac.this.zzbsz().zzbty().log("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        if (bundle == null) {
                            zzs(data);
                        }
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (!queryParameter.contains("gclid")) {
                                zzac.this.zzbsz().zzbtx().log("Activity created with data 'referrer' param without gclid");
                                return;
                            }
                            zzac.this.zzbsz().zzbtx().zzj("Activity created with referrer", queryParameter);
                            zzmi(queryParameter);
                        }
                    }
                }
            } catch (Throwable th) {
                zzac.this.zzbsz().zzbtr().zzj("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        @MainThread
        public void onActivityPaused(Activity activity) {
            zzac.this.zzbsx().zzbvv();
        }

        @MainThread
        public void onActivityResumed(Activity activity) {
            zzac.this.zzbsx().zzbvt();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzac(zzx zzx) {
        super(zzx);
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzyw().currentTimeMillis(), bundle, z, z2, z3, str3);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zza(String str, String str2, Object obj, long j) {
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzwu();
        zzyv();
        zzzg();
        if (!this.aja.isEnabled()) {
            zzbsz().zzbtx().log("User property not set since app measurement is disabled");
        } else if (this.aja.zzbuk()) {
            zzbsz().zzbtx().zze("Setting user property (FE)", str2, obj);
            zzbst().zza(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzab.zzaa(bundle);
        zzwu();
        zzzg();
        if (!this.aja.isEnabled()) {
            zzbsz().zzbtx().log("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.amZ) {
            this.amZ = true;
            zzbvl();
        }
        boolean zzmu = zzal.zzmu(str2);
        if (z && this.amX != null && !zzmu) {
            zzbsz().zzbtx().zze("Passing event to registered event handler (FE)", str2, bundle);
            this.amX.zzb(str, str2, bundle, j);
        } else if (this.aja.zzbuk()) {
            int zzmm = zzbsv().zzmm(str2);
            if (zzmm != 0) {
                this.aja.zzbsv().zze(zzmm, "_ev", zzbsv().zza(str2, zzbtb().zzbrj(), true));
                return;
            }
            bundle.putString("_o", str);
            Bundle zza2 = zzbsv().zza(str2, bundle, zzf.zzab("_o"), z3);
            Bundle bundle2 = z2 ? zzal(zza2) : zza2;
            zzbsz().zzbtx().zze("Logging event (FE)", str2, bundle2);
            zzbst().zzc(new EventParcel(str2, new EventParams(bundle2), str, j), str3);
            for (zzc zzc : this.amY) {
                zzc.zzc(str, str2, bundle2, j);
            }
        }
    }

    @WorkerThread
    private void zzbvl() {
        try {
            zzg(Class.forName(zzbvm()));
        } catch (ClassNotFoundException e) {
            zzbsz().zzbtw().log("Tag Manager is not found and thus will not be used");
        }
    }

    private String zzbvm() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzcc(boolean z) {
        zzwu();
        zzyv();
        zzzg();
        zzbsz().zzbtx().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzbta().setMeasurementEnabled(z);
        zzbst().zzbvn();
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void setMeasurementEnabled(final boolean z) {
        zzzg();
        zzyv();
        zzbsy().zzl(new Runnable() {
            public void run() {
                zzac.this.zzcc(z);
            }
        });
    }

    public void setMinimumSessionDuration(final long j) {
        zzyv();
        zzbsy().zzl(new Runnable() {
            public void run() {
                zzac.this.zzbta().alE.set(j);
                zzac.this.zzbsz().zzbtx().zzj("Minimum session duration set", Long.valueOf(j));
            }
        });
    }

    public void setSessionTimeoutDuration(final long j) {
        zzyv();
        zzbsy().zzl(new Runnable() {
            public void run() {
                zzac.this.zzbta().alF.set(j);
                zzac.this.zzbsz().zzbtx().zzj("Session timeout duration set", Long.valueOf(j));
            }
        });
    }

    @WorkerThread
    public void zza(zzb zzb) {
        zzwu();
        zzyv();
        zzzg();
        if (!(zzb == null || zzb == this.amX)) {
            zzab.zza(this.amX == null, (Object) "EventInterceptor already set.");
        }
        this.amX = zzb;
    }

    @WorkerThread
    public void zza(zzc zzc) {
        zzwu();
        zzyv();
        zzzg();
        zzab.zzaa(zzc);
        if (this.amY.contains(zzc)) {
            throw new IllegalStateException("OnEventListener already registered.");
        }
        this.amY.add(zzc);
    }

    /* access modifiers changed from: protected */
    public void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        final Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        final boolean z4 = z;
        final boolean z5 = z2;
        final boolean z6 = z3;
        final String str6 = str3;
        zzbsy().zzl(new Runnable() {
            public void run() {
                zzac.this.zzb(str4, str5, j2, bundle2, z4, z5, z6, str6);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void zza(String str, String str2, long j, Object obj) {
        final String str3 = str;
        final String str4 = str2;
        final Object obj2 = obj;
        final long j2 = j;
        zzbsy().zzl(new Runnable() {
            public void run() {
                zzac.this.zza(str3, str4, obj2, j2);
            }
        });
    }

    public void zza(String str, String str2, Bundle bundle, boolean z) {
        zzyv();
        zza(str, str2, bundle, true, this.amX == null || zzal.zzmu(str2), z, null);
    }

    /* access modifiers changed from: 0000 */
    public Bundle zzal(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzl = zzbsv().zzl(str, bundle.get(str));
                if (zzl == null) {
                    zzbsz().zzbtt().zzj("Param value can't be null", str);
                } else if ((!(zzl instanceof String) && !(zzl instanceof Character) && !(zzl instanceof CharSequence)) || !TextUtils.isEmpty(String.valueOf(zzl))) {
                    zzbsv().zza(bundle2, str, zzl);
                }
            }
        }
        return bundle2;
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

    @TargetApi(14)
    public void zzbvj() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.amW == null) {
                this.amW = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.amW);
            application.registerActivityLifecycleCallbacks(this.amW);
            zzbsz().zzbty().log("Registered activity lifecycle callback");
        }
    }

    @WorkerThread
    public void zzbvk() {
        zzwu();
        zzyv();
        zzzg();
        if (this.aja.zzbuk()) {
            zzbst().zzbvk();
            String zzbuh = zzbta().zzbuh();
            if (!TextUtils.isEmpty(zzbuh) && !zzbuh.equals(zzbss().zzbtk())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", zzbuh);
                zze("auto", "_ou", bundle);
            }
        }
    }

    @Nullable
    @WorkerThread
    public List<UserAttributeParcel> zzcd(final boolean z) {
        zzyv();
        zzzg();
        zzbsz().zzbtx().log("Fetching user attributes (FE)");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzbsz().zzbtt().log("getUserProperties called from main thread.");
            return null;
        }
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.aja.zzbsy().zzl(new Runnable() {
                public void run() {
                    zzac.this.zzbst().zza(atomicReference, z);
                }
            });
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzbsz().zzbtt().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<UserAttributeParcel> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzbsz().zzbtt().log("Timed out waiting for get user properties");
        return null;
    }

    public void zzd(String str, String str2, Bundle bundle, long j) {
        zzyv();
        zza(str, str2, j, bundle, false, true, true, null);
    }

    public void zzd(String str, String str2, Object obj) {
        zzab.zzhs(str);
        long currentTimeMillis = zzyw().currentTimeMillis();
        int zzmo = zzbsv().zzmo(str2);
        if (zzmo != 0) {
            this.aja.zzbsv().zze(zzmo, "_ev", zzbsv().zza(str2, zzbtb().zzbrk(), true));
        } else if (obj != null) {
            int zzm = zzbsv().zzm(str2, obj);
            if (zzm != 0) {
                this.aja.zzbsv().zze(zzm, "_ev", zzbsv().zza(str2, zzbtb().zzbrk(), true));
                return;
            }
            Object zzn = zzbsv().zzn(str2, obj);
            if (zzn != null) {
                zza(str, str2, currentTimeMillis, zzn);
            }
        } else {
            zza(str, str2, currentTimeMillis, (Object) null);
        }
    }

    public void zze(String str, String str2, Bundle bundle) {
        zzyv();
        zza(str, str2, bundle, true, this.amX == null || zzal.zzmu(str2), false, null);
    }

    @WorkerThread
    public void zzg(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
        } catch (Exception e) {
            zzbsz().zzbtt().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
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
