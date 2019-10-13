package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.internal.zzh.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;

public class zzd extends zzk<zzh> {
    private final GoogleSignInOptions ej;

    public zzd(Context context, Looper looper, zzg zzg, GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, zzg, connectionCallbacks, onConnectionFailedListener);
        if (googleSignInOptions == null) {
            googleSignInOptions = new Builder().build();
        }
        if (!zzg.zzasg().isEmpty()) {
            Builder builder = new Builder(googleSignInOptions);
            for (Scope requestScopes : zzg.zzasg()) {
                builder.requestScopes(requestScopes, new Scope[0]);
            }
            googleSignInOptions = builder.build();
        }
        this.ej = googleSignInOptions;
    }

    public boolean zzafz() {
        return true;
    }

    public Intent zzaga() {
        SignInConfiguration signInConfiguration = new SignInConfiguration(getContext().getPackageName(), this.ej);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(getContext(), SignInHubActivity.class);
        intent.putExtra("config", signInConfiguration);
        return intent;
    }

    public GoogleSignInOptions zzagb() {
        return this.ej;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzci */
    public zzh zzbb(IBinder iBinder) {
        return zza.zzck(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzra() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzrb() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
