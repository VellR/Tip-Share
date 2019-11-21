package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqz;

public final class PendingResults {

    private static final class zza<R extends Result> extends zzpt<R> {
        private final R sb;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.sb = r;
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            if (status.getStatusCode() == this.sb.getStatus().getStatusCode()) {
                return this.sb;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends zzpt<R> {
        private final R sc;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.sc = r;
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            return this.sc;
        }
    }

    private static final class zzc<R extends Result> extends zzpt<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzqz zzqz = new zzqz(Looper.getMainLooper());
        zzqz.cancel();
        return zzqz;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzab.zzb(r, (Object) "Result must not be null");
        zzab.zzb(r.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        zza zza2 = new zza(r);
        zza2.cancel();
        return zza2;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzab.zzb(r, (Object) "Result must not be null");
        zzc zzc2 = new zzc(null);
        zzc2.zzc(r);
        return new zzqv(zzc2);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzab.zzb(status, (Object) "Result must not be null");
        zzqz zzqz = new zzqz(Looper.getMainLooper());
        zzqz.zzc(status);
        return zzqz;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzab.zzb(r, (Object) "Result must not be null");
        zzab.zzb(!r.getStatus().isSuccess(), (Object) "Status code must not be SUCCESS");
        zzb zzb2 = new zzb(googleApiClient, r);
        zzb2.zzc(r);
        return zzb2;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzab.zzb(status, (Object) "Result must not be null");
        zzqz zzqz = new zzqz(googleApiClient);
        zzqz.zzc(status);
        return zzqz;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzab.zzb(r, (Object) "Result must not be null");
        zzc zzc2 = new zzc(googleApiClient);
        zzc2.zzc(r);
        return new zzqv(zzc2);
    }
}
