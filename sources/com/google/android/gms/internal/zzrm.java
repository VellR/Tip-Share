package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzrm<R extends Result> extends com.google.android.gms.internal.zzpr.zza<R, zzrn> {

    static abstract class zza extends zzrm<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    public zzrm(GoogleApiClient googleApiClient) {
        super(zzrj.API, googleApiClient);
    }
}
