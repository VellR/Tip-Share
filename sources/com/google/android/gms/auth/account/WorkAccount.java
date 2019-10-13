package com.google.android.gms.auth.account;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzmw;
import com.google.android.gms.internal.zzmx;

public class WorkAccount {
    public static final Api<NoOptions> API = new Api<>("WorkAccount.API", bO, bN);
    public static final WorkAccountApi WorkAccountApi = new zzmw();
    private static final zzf<zzmx> bN = new zzf<>();
    private static final zza<zzmx, NoOptions> bO = new zza<zzmx, NoOptions>() {
        /* renamed from: zzc */
        public zzmx zza(Context context, Looper looper, zzg zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmx(context, looper, zzg, connectionCallbacks, onConnectionFailedListener);
        }
    };

    private WorkAccount() {
    }
}
