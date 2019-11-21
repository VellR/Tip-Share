package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;
import com.google.android.gms.common.internal.zzl.zza;
import java.util.Set;

public abstract class zzk<T extends IInterface> extends zzd<T> implements zze, zza {
    private final Account aP;
    private final Set<Scope> dY;
    private final zzg tD;

    protected zzk(Context context, Looper looper, int i, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzm.zzce(context), GoogleApiAvailability.getInstance(), i, zzg, (ConnectionCallbacks) zzab.zzaa(connectionCallbacks), (OnConnectionFailedListener) zzab.zzaa(onConnectionFailedListener));
    }

    protected zzk(Context context, Looper looper, zzm zzm, GoogleApiAvailability googleApiAvailability, int i, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzm, googleApiAvailability, i, zza(connectionCallbacks), zza(onConnectionFailedListener), zzg.zzasj());
        this.tD = zzg;
        this.aP = zzg.getAccount();
        this.dY = zzb(zzg.zzasg());
    }

    @Nullable
    private static zzb zza(final ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new zzb() {
            public void onConnected(@Nullable Bundle bundle) {
                ConnectionCallbacks.this.onConnected(bundle);
            }

            public void onConnectionSuspended(int i) {
                ConnectionCallbacks.this.onConnectionSuspended(i);
            }
        };
    }

    @Nullable
    private static zzc zza(final OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new zzc() {
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                OnConnectionFailedListener.this.onConnectionFailed(connectionResult);
            }
        };
    }

    private Set<Scope> zzb(@NonNull Set<Scope> set) {
        Set<Scope> zzc = zzc(set);
        for (Scope contains : zzc) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzc;
    }

    public final Account getAccount() {
        return this.aP;
    }

    /* access modifiers changed from: protected */
    public final Set<Scope> zzary() {
        return this.dY;
    }

    /* access modifiers changed from: protected */
    public final zzg zzasr() {
        return this.tD;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Set<Scope> zzc(@NonNull Set<Scope> set) {
        return set;
    }
}
