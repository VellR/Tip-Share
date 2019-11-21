package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzb<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult> {
    /* access modifiers changed from: private */
    public final Continuation<TResult, Task<TContinuationResult>> aDA;
    /* access modifiers changed from: private */
    public final zzh<TContinuationResult> aDB;
    private final Executor avP;

    public zzb(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation, @NonNull zzh<TContinuationResult> zzh) {
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
                    Task task = (Task) zzb.this.aDA.then(task);
                    if (task == null) {
                        zzb.this.onFailure(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    task.addOnSuccessListener(TaskExecutors.aDO, (OnSuccessListener<? super TResult>) zzb.this);
                    task.addOnFailureListener(TaskExecutors.aDO, (OnFailureListener) zzb.this);
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zzb.this.aDB.setException((Exception) e.getCause());
                    } else {
                        zzb.this.aDB.setException(e);
                    }
                } catch (Exception e2) {
                    zzb.this.aDB.setException(e2);
                }
            }
        });
    }

    public void onFailure(@NonNull Exception exc) {
        this.aDB.setException(exc);
    }

    public void onSuccess(TContinuationResult tcontinuationresult) {
        this.aDB.setResult(tcontinuationresult);
    }
}
