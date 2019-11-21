package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzd<TResult> implements zzf<TResult> {
    /* access modifiers changed from: private */
    public OnFailureListener aDH;
    private final Executor avP;
    /* access modifiers changed from: private */
    public final Object zzail = new Object();

    public zzd(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.avP = executor;
        this.aDH = onFailureListener;
    }

    public void cancel() {
        synchronized (this.zzail) {
            this.aDH = null;
        }
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        if (!task.isSuccessful()) {
            synchronized (this.zzail) {
                if (this.aDH != null) {
                    this.avP.execute(new Runnable() {
                        public void run() {
                            synchronized (zzd.this.zzail) {
                                if (zzd.this.aDH != null) {
                                    zzd.this.aDH.onFailure(task.getException());
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
