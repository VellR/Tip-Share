package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zze;
import com.google.android.gms.auth.api.credentials.internal.zzg;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzmy;
import com.google.android.gms.internal.zzmz;
import com.google.android.gms.internal.zzna;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zzni;
import java.util.Collections;
import java.util.List;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", cI, cE);
    public static final CredentialsApi CredentialsApi = new zze();
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", cK, cG);
    public static final GoogleSignInApi GoogleSignInApi = new zzc();
    public static final Api<zza> PROXY_API = new Api<>("Auth.PROXY_API", cH, cD);
    public static final ProxyApi ProxyApi = new zzni();
    public static final zzf<zzne> cD = new zzf<>();
    public static final zzf<zzg> cE = new zzf<>();
    public static final zzf<zzna> cF = new zzf<>();
    public static final zzf<zzd> cG = new zzf<>();
    private static final com.google.android.gms.common.api.Api.zza<zzne, zza> cH = new com.google.android.gms.common.api.Api.zza<zzne, zza>() {
        public zzne zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, zza zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzne(context, looper, zzg, zza, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final com.google.android.gms.common.api.Api.zza<zzg, AuthCredentialsOptions> cI = new com.google.android.gms.common.api.Api.zza<zzg, AuthCredentialsOptions>() {
        public zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzg(context, looper, zzg, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final com.google.android.gms.common.api.Api.zza<zzna, NoOptions> cJ = new com.google.android.gms.common.api.Api.zza<zzna, NoOptions>() {
        /* renamed from: zzd */
        public zzna zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzna(context, looper, zzg, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final com.google.android.gms.common.api.Api.zza<zzd, GoogleSignInOptions> cK = new com.google.android.gms.common.api.Api.zza<zzd, GoogleSignInOptions>() {
        public zzd zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, @Nullable GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, zzg, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: zza */
        public List<Scope> zzq(@Nullable GoogleSignInOptions googleSignInOptions) {
            return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.zzafq();
        }
    };
    public static final Api<NoOptions> cL = new Api<>("Auth.ACCOUNT_STATUS_API", cJ, cF);
    public static final zzmy cM = new zzmz();

    public static final class AuthCredentialsOptions implements Optional {

        public static class Builder {
            @NonNull
            private PasswordSpecification cN = PasswordSpecification.de;
        }

        public Bundle zzaeu() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putParcelable("password_specification", null);
            return bundle;
        }

        public PasswordSpecification zzafb() {
            return null;
        }
    }

    public static final class zza implements Optional {
        public Bundle zzafc() {
            return new Bundle(null);
        }
    }

    private Auth() {
    }
}
