package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzc<TResult> implements zzf<TResult> {
    /* access modifiers changed from: private */
    public OnCompleteListener<TResult> aDF;
    private final Executor avP;
    /* access modifiers changed from: private */
    public final Object zzail = new Object();

    public zzc(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.avP = executor;
        this.aDF = onCompleteListener;
    }

    public void cancel() {
        synchronized (this.zzail) {
            this.aDF = null;
        }
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        synchronized (this.zzail) {
            if (this.aDF != null) {
                this.avP.execute(new Runnable() {
                    public void run() {
                        synchronized (zzc.this.zzail) {
                            if (zzc.this.aDF != null) {
                                zzc.this.aDF.onComplete(task);
                            }
                        }
                    }
                });
            }
        }
    }
}
