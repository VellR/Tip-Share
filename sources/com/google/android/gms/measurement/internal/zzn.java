package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzqk;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class zzn extends zzaa {
    private static final X500Principal akJ = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String ajg;
    private String ajn;
    private int akK;
    private long akL;
    private String zzcjj;
    private String zzcup;
    private String zzcuq;

    zzn(zzx zzx) {
        super(zzx);
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: 0000 */
    public String zzbqo() {
        zzzg();
        return this.ajg;
    }

    /* access modifiers changed from: 0000 */
    public String zzbqu() {
        zzzg();
        return this.ajn;
    }

    /* access modifiers changed from: 0000 */
    public long zzbqv() {
        return zzbtb().zzbqv();
    }

    /* access modifiers changed from: 0000 */
    public long zzbqw() {
        zzzg();
        return this.akL;
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

    /* access modifiers changed from: 0000 */
    public int zzbtp() {
        zzzg();
        return this.akK;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzbtq() {
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(akJ);
            }
        } catch (CertificateException e) {
            zzbsz().zzbtr().zzj("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            zzbsz().zzbtr().zzj("Package name not found", e2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void zzdq(Status status) {
        if (status == null) {
            zzbsz().zzbtr().log("GoogleService failed to initialize (no status)");
        } else {
            zzbsz().zzbtr().zze("GoogleService failed to initialize, status", Integer.valueOf(status.getStatusCode()), status.getStatusMessage());
        }
    }

    /* access modifiers changed from: 0000 */
    public AppMetadata zzlw(String str) {
        return new AppMetadata(zzsi(), zzbqo(), zzxc(), (long) zzbtp(), zzbqu(), zzbqv(), zzbqw(), str, this.aja.isEnabled(), !zzbta().alJ, zzbta().zzbqq());
    }

    /* access modifiers changed from: 0000 */
    public String zzsi() {
        zzzg();
        return this.zzcjj;
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    /* access modifiers changed from: protected */
    public void zzwv() {
        boolean z;
        String str = "Unknown";
        int i = Integer.MIN_VALUE;
        String str2 = "Unknown";
        PackageManager packageManager = getContext().getPackageManager();
        String packageName = getContext().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
                i = packageInfo.versionCode;
            }
        } catch (NameNotFoundException e) {
            zzbsz().zzbtr().zzj("Error retrieving package info: appName", str2);
        }
        this.zzcjj = packageName;
        this.ajn = installerPackageName;
        this.zzcuq = str;
        this.akK = i;
        this.zzcup = str2;
        MessageDigest zzfb = zzal.zzfb("MD5");
        if (zzfb == null) {
            zzbsz().zzbtr().log("Could not get MD5 instance");
            this.akL = -1;
        } else {
            this.akL = 0;
            try {
                if (!zzbtq()) {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo2.signatures != null && packageInfo2.signatures.length > 0) {
                        this.akL = zzal.zzac(zzfb.digest(packageInfo2.signatures[0].toByteArray()));
                    }
                }
            } catch (NameNotFoundException e2) {
                zzbsz().zzbtr().zzj("Package name not found", e2);
            }
        }
        Status zzcb = zzbtb().zzabc() ? zzqk.zzc(getContext(), "-", true) : zzqk.zzcb(getContext());
        boolean z2 = zzcb != null && zzcb.isSuccess();
        if (!z2) {
            zzdq(zzcb);
        }
        if (z2) {
            Boolean zzbsa = zzbtb().zzbsa();
            if (zzbtb().zzbrz()) {
                zzbsz().zzbtw().log("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (zzbsa != null && !zzbsa.booleanValue()) {
                zzbsz().zzbtw().log("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (zzbsa != null || !zzbtb().zzaql()) {
                zzbsz().zzbty().log("Collection enabled");
                z = true;
            } else {
                zzbsz().zzbtw().log("Collection disabled with google_app_measurement_enable=0");
                z = false;
            }
        } else {
            z = false;
        }
        this.ajg = "";
        if (!zzbtb().zzabc()) {
            try {
                String zzaqk = zzqk.zzaqk();
                if (TextUtils.isEmpty(zzaqk)) {
                    zzaqk = "";
                }
                this.ajg = zzaqk;
                if (z) {
                    zzbsz().zzbty().zze("App package, google app id", this.zzcjj, this.ajg);
                }
            } catch (IllegalStateException e3) {
                zzbsz().zzbtr().zzj("getGoogleAppId or isMeasurementEnabled failed with exception", e3);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public String zzxc() {
        zzzg();
        return this.zzcuq;
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
