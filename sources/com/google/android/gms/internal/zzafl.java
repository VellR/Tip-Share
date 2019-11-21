package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;

public final class zzafl {
    private static final com.google.android.gms.common.api.Api.zza<zzafe, zza> aNH = new com.google.android.gms.common.api.Api.zza<zzafe, zza>() {
        public zzafe zza(Context context, Looper looper, zzg zzg, zza zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzaff(context, looper, zzg, zza, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<zza> aNI = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", aNH, bN);
    public static final zzf<zzafe> bN = new zzf<>();

    public static final class zza implements HasOptions {
        private final String uS;

        /* renamed from: com.google.android.gms.internal.zzafl$zza$zza reason: collision with other inner class name */
        public static final class C0027zza {
            private String uS;

            public C0027zza(@NonNull String str) {
                this.uS = zzab.zzhs(str);
            }

            public zza zzcld() {
                return new zza(this.uS);
            }
        }

        private zza(@NonNull String str) {
            this.uS = zzab.zzh(str, "A valid API key must be provided");
        }

        public String getApiKey() {
            return this.uS;
        }
    }

    public static zzafd zza(Context context, zza zza2) {
        return new zzafd(context, zza2);
    }
}
