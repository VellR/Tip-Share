package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri.Builder;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.measurement.internal.zzl.zza;

public class zzd extends zzz {
    static final String ajI = String.valueOf(zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean zzczf;

    zzd(zzx zzx) {
        super(zzx);
    }

    @Nullable
    private Boolean zzlj(@Size(min = 1) String str) {
        zzab.zzhs(str);
        try {
            PackageManager packageManager = getContext().getPackageManager();
            if (packageManager == null) {
                zzbsz().zzbtr().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzbsz().zzbtr().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzbsz().zzbtr().log("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (applicationInfo.metaData.containsKey(str)) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            } else {
                return null;
            }
        } catch (NameNotFoundException e) {
            zzbsz().zzbtr().zzj("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public long zza(String str, zza<Long> zza) {
        if (str == null) {
            return ((Long) zza.get()).longValue();
        }
        String zzaw = zzbsw().zzaw(str, zza.getKey());
        if (TextUtils.isEmpty(zzaw)) {
            return ((Long) zza.get()).longValue();
        }
        try {
            return ((Long) zza.get(Long.valueOf(Long.valueOf(zzaw).longValue()))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) zza.get()).longValue();
        }
    }

    public boolean zzabc() {
        return false;
    }

    public boolean zzabd() {
        if (this.zzczf == null) {
            synchronized (this) {
                if (this.zzczf == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String zzavv = zzt.zzavv();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzczf = Boolean.valueOf(str != null && str.equals(zzavv));
                    }
                    if (this.zzczf == null) {
                        this.zzczf = Boolean.TRUE;
                        zzbsz().zzbtr().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzczf.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public long zzabx() {
        return ((Long) zzl.akI.get()).longValue();
    }

    public String zzacc() {
        return "google_app_measurement.db";
    }

    public String zzacd() {
        return "google_app_measurement2.db";
    }

    public long zzaci() {
        return Math.max(0, ((Long) zzl.akm.get()).longValue());
    }

    public String zzap(String str, String str2) {
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) zzl.ako.get()).encodedAuthority((String) zzl.akp.get());
        String str3 = "config/app/";
        String valueOf = String.valueOf(str);
        encodedAuthority.path(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3)).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzbqv()));
        return builder.build().toString();
    }

    public boolean zzaql() {
        return zzqk.zzaql();
    }

    public int zzb(String str, zza<Integer> zza) {
        if (str == null) {
            return ((Integer) zza.get()).intValue();
        }
        String zzaw = zzbsw().zzaw(str, zza.getKey());
        if (TextUtils.isEmpty(zzaw)) {
            return ((Integer) zza.get()).intValue();
        }
        try {
            return ((Integer) zza.get(Integer.valueOf(Integer.valueOf(zzaw).intValue()))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) zza.get()).intValue();
        }
    }

    public long zzbqv() {
        return 9256;
    }

    /* access modifiers changed from: 0000 */
    public String zzbrh() {
        return (String) zzl.akk.get();
    }

    public int zzbri() {
        return 25;
    }

    public int zzbrj() {
        return 32;
    }

    public int zzbrk() {
        return 24;
    }

    /* access modifiers changed from: 0000 */
    public int zzbrl() {
        return 24;
    }

    /* access modifiers changed from: 0000 */
    public int zzbrm() {
        return 36;
    }

    /* access modifiers changed from: 0000 */
    public int zzbrn() {
        return 256;
    }

    public int zzbro() {
        return 36;
    }

    public int zzbrp() {
        return 2048;
    }

    /* access modifiers changed from: 0000 */
    public int zzbrq() {
        return 500;
    }

    public long zzbrr() {
        return (long) ((Integer) zzl.aku.get()).intValue();
    }

    public long zzbrs() {
        return (long) ((Integer) zzl.akv.get()).intValue();
    }

    public long zzbrt() {
        return 1000;
    }

    /* access modifiers changed from: 0000 */
    public int zzbru() {
        return 25;
    }

    /* access modifiers changed from: 0000 */
    public int zzbrv() {
        return 50;
    }

    /* access modifiers changed from: 0000 */
    public long zzbrw() {
        return 3600000;
    }

    /* access modifiers changed from: 0000 */
    public long zzbrx() {
        return 60000;
    }

    /* access modifiers changed from: 0000 */
    public long zzbry() {
        return 61000;
    }

    public boolean zzbrz() {
        if (zzabc()) {
            return false;
        }
        Boolean zzlj = zzlj("firebase_analytics_collection_deactivated");
        return zzlj != null && !zzlj.booleanValue();
    }

    public Boolean zzbsa() {
        if (zzabc()) {
            return null;
        }
        return zzlj("firebase_analytics_collection_enabled");
    }

    public long zzbsb() {
        return ((Long) zzl.akG.get()).longValue();
    }

    public long zzbsc() {
        return ((Long) zzl.akC.get()).longValue();
    }

    public long zzbsd() {
        return 1000;
    }

    public int zzbse() {
        return Math.max(0, ((Integer) zzl.aks.get()).intValue());
    }

    public int zzbsf() {
        return Math.max(1, ((Integer) zzl.akt.get()).intValue());
    }

    public String zzbsg() {
        return (String) zzl.aky.get();
    }

    public long zzbsh() {
        return ((Long) zzl.akn.get()).longValue();
    }

    public long zzbsi() {
        return Math.max(0, ((Long) zzl.akz.get()).longValue());
    }

    public long zzbsj() {
        return Math.max(0, ((Long) zzl.akB.get()).longValue());
    }

    public long zzbsk() {
        return ((Long) zzl.akA.get()).longValue();
    }

    public long zzbsl() {
        return Math.max(0, ((Long) zzl.akD.get()).longValue());
    }

    public long zzbsm() {
        return Math.max(0, ((Long) zzl.akE.get()).longValue());
    }

    public int zzbsn() {
        return Math.min(20, Math.max(0, ((Integer) zzl.akF.get()).intValue()));
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

    public int zzlg(@Size(min = 1) String str) {
        return zzb(str, zzl.akw);
    }

    /* access modifiers changed from: 0000 */
    public long zzlh(String str) {
        return zza(str, zzl.akl);
    }

    /* access modifiers changed from: 0000 */
    public int zzli(String str) {
        return zzb(str, zzl.akH);
    }

    public int zzlk(String str) {
        return zzb(str, zzl.akq);
    }

    public int zzll(String str) {
        return Math.max(0, zzb(str, zzl.akr));
    }

    public int zzlm(String str) {
        return Math.max(0, Math.min(1000000, zzb(str, zzl.akx)));
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
