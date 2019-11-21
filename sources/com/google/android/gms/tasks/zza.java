package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zza<TResult, TContinuationResult> implements zzf<TResult> {
    /* access modifiers changed from: private */
    public final Continuation<TResult, TContinuationResult> aDA;
    /* access modifiers changed from: private */
    public final zzh<TContinuationResult> aDB;
    private final Executor avP;

    public zza(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzh<TContinuationResult> zzh) {
        this.avP = executor;
        this.aDA = continuation;
        this.aDB = zzh;
    }

    public void cancel() {
        throw new UnsupportedOperationException();
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        this.avP.execute(new Runnable() {
            public void run() {
                try {
                    zza.this.aDB.setResult(zza.this.aDA.then(task));
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zza.this.aDB.setException((Exception) e.getCause());
                    } else {
                        zza.this.aDB.setException(e);
                    }
                } catch (Exception e2) {
                    zza.this.aDB.setException(e2);
                }
            }
        });
    }
}
