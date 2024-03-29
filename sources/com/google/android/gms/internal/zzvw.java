package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.zzg;

public final class zzvw {
    public static final Api<zzvy> API = new Api<>("SignIn.API", bO, bN);
    public static final Api<zza> EX = new Api<>("SignIn.INTERNAL_API", auk, auj);
    public static final zzf<zzg> auj = new zzf<>();
    static final com.google.android.gms.common.api.Api.zza<zzg, zza> auk = new com.google.android.gms.common.api.Api.zza<zzg, zza>() {
        public zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, zza zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzg(context, looper, false, zzg, zza.zzbzj(), connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final zzf<zzg> bN = new zzf<>();
    public static final com.google.android.gms.common.api.Api.zza<zzg, zzvy> bO = new com.google.android.gms.common.api.Api.zza<zzg, zzvy>() {
        public zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, zzvy zzvy, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzg(context, looper, true, zzg, zzvy == null ? zzvy.aul : zzvy, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Scope dP = new Scope(Scopes.PROFILE);
    public static final Scope dQ = new Scope("email");

    public static class zza implements HasOptions {
        public Bundle zzbzj() {
            return null;
        }
    }
}
