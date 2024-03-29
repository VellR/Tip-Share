package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {

    public interface zza {
        void zzv(Status status);
    }

    @NonNull
    public abstract R await();

    @NonNull
    public abstract R await(long j, @NonNull TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(@NonNull ResultCallback<? super R> resultCallback);

    public abstract void setResultCallback(@NonNull ResultCallback<? super R> resultCallback, long j, @NonNull TimeUnit timeUnit);

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        throw new UnsupportedOperationException();
    }

    public void zza(@NonNull zza zza2) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public Integer zzaog() {
        throw new UnsupportedOperationException();
    }
}
