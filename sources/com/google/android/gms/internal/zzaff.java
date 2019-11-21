package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzafl.zza;

public class zzaff extends zzk<zzafk> implements zzafe {
    private static zzrq aNE = new zzrq("FirebaseAuth", "FirebaseAuth:");
    private final zza aNF;
    private final Context mContext;

    public zzaff(Context context, Looper looper, zzg zzg, zza zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 112, zzg, connectionCallbacks, onConnectionFailedListener);
        this.mContext = (Context) zzab.zzaa(context);
        this.aNF = zza;
    }

    /* access modifiers changed from: protected */
    public Bundle zzaeu() {
        Bundle zzaeu = super.zzaeu();
        if (zzaeu == null) {
            zzaeu = new Bundle();
        }
        if (this.aNF != null) {
            zzaeu.putString("com.google.firebase.auth.API_KEY", this.aNF.getApiKey());
        }
        return zzaeu;
    }

    public boolean zzanr() {
        return zzsj.zzt(this.mContext, "com.google.firebase.auth") == 0;
    }

    /* access modifiers changed from: protected */
    public String zzarp() {
        boolean z;
        boolean z2;
        String property = zzafr.getProperty("firebear.preference");
        if (TextUtils.isEmpty(property)) {
            property = "default";
        }
        switch (property.hashCode()) {
            case 103145323:
                if (property.equals("local")) {
                    z = false;
                    break;
                }
            case 1544803905:
                if (property.equals("default")) {
                    z = true;
                    break;
                }
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
            case true:
                break;
            default:
                property = "default";
                break;
        }
        switch (property.hashCode()) {
            case 103145323:
                if (property.equals("local")) {
                    z2 = false;
                    break;
                }
            default:
                z2 = true;
                break;
        }
        switch (z2) {
            case false:
                aNE.zza("Loading fallback module override.", new Object[0]);
                return this.mContext.getPackageName();
            default:
                aNE.zza("Loading module via default loading order.", new Object[0]);
                if (zzsj.zzu(this.mContext, "com.google.android.gms.firebase_auth") >= zzsj.zzt(this.mContext, "com.google.firebase.auth")) {
                    aNE.zza("Loading remote module.", new Object[0]);
                    return "com.google.android.gms";
                }
                aNE.zza("Loading fallback module.", new Object[0]);
                return this.mContext.getPackageName();
        }
    }

    public /* synthetic */ zzafk zzckz() throws DeadObjectException {
        return (zzafk) super.zzarw();
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzlk */
    public zzafk zzbb(IBinder iBinder) {
        return zzafk.zza.zzlm(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzra() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzrb() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }
}
