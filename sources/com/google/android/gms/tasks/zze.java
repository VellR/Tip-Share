package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zze<TResult> implements zzf<TResult> {
    /* access modifiers changed from: private */
    public OnSuccessListener<? super TResult> aDJ;
    private final Executor avP;
    /* access modifiers changed from: private */
    public final Object zzail = new Object();

    public zze(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.avP = executor;
        this.aDJ = onSuccessListener;
    }

    public void cancel() {
        synchronized (this.zzail) {
            this.aDJ = null;
        }
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.zzail) {
                if (this.aDJ != null) {
                    this.avP.execute(new Runnable() {
                        public void run() {
                            synchronized (zze.this.zzail) {
                                if (zze.this.aDJ != null) {
                                    zze.this.aDJ.onSuccess(task.getResult());
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
