package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.internal.zzqp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

final class zzh<TResult> extends Task<TResult> {
    private final zzg<TResult> aDP = new zzg<>();
    private boolean aDQ;
    private TResult aDR;
    private Exception aDS;
    private final Object zzail = new Object();

    private static class zza extends zzqo {
        private final List<WeakReference<zzf<?>>> mListeners = new ArrayList();

        private zza(zzqp zzqp) {
            super(zzqp);
            this.va.zza("TaskOnStopCallback", (zzqo) this);
        }

        public static zza zzv(Activity activity) {
            zzqp zzs = zzs(activity);
            zza zza = (zza) zzs.zza("TaskOnStopCallback", zza.class);
            return zza == null ? new zza(zzs) : zza;
        }

        @MainThread
        public void onStop() {
            synchronized (this.mListeners) {
                for (WeakReference weakReference : this.mListeners) {
                    zzf zzf = (zzf) weakReference.get();
                    if (zzf != null) {
                        zzf.cancel();
                    }
                }
                this.mListeners.clear();
            }
        }

        public <T> void zzb(zzf<T> zzf) {
            synchronized (this.mListeners) {
                this.mListeners.add(new WeakReference(zzf));
            }
        }
    }

    zzh() {
    }

    private void zzchi() {
        zzab.zza(this.aDQ, (Object) "Task is not yet complete");
    }

    private void zzchj() {
        zzab.zza(!this.aDQ, (Object) "Task is already complete");
    }

    private void zzchk() {
        synchronized (this.zzail) {
            if (this.aDQ) {
                this.aDP.zza((Task<TResult>) this);
            }
        }
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzc zzc = new zzc(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.aDP.zza((zzf<TResult>) zzc);
        zza.zzv(activity).zzb(zzc);
        zzchk();
        return this;
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.aDP.zza((zzf<TResult>) new zzc<TResult>(executor, onCompleteListener));
        zzchk();
        return this;
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzd zzd = new zzd(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.aDP.zza((zzf<TResult>) zzd);
        zza.zzv(activity).zzb(zzd);
        zzchk();
        return this;
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.aDP.zza((zzf<TResult>) new zzd<TResult>(executor, onFailureListener));
        zzchk();
        return this;
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zze zze = new zze(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.aDP.zza((zzf<TResult>) zze);
        zza.zzv(activity).zzb(zze);
        zzchk();
        return this;
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.aDP.zza((zzf<TResult>) new zze<TResult>(executor, onSuccessListener));
        zzchk();
        return this;
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzh zzh = new zzh();
        this.aDP.zza((zzf<TResult>) new zza<TResult>(executor, continuation, zzh));
        zzchk();
        return zzh;
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzh zzh = new zzh();
        this.aDP.zza((zzf<TResult>) new zzb<TResult>(executor, continuation, zzh));
        zzchk();
        return zzh;
    }

    @Nullable
    public Exception getException() {
        Exception exc;
        synchronized (this.zzail) {
            exc = this.aDS;
        }
        return exc;
    }

    public TResult getResult() {
        TResult tresult;
        synchronized (this.zzail) {
            zzchi();
            if (this.aDS != null) {
                throw new RuntimeExecutionException(this.aDS);
            }
            tresult = this.aDR;
        }
        return tresult;
    }

    public <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.zzail) {
            zzchi();
            if (cls.isInstance(this.aDS)) {
                throw ((Throwable) cls.cast(this.aDS));
            } else if (this.aDS != null) {
                throw new RuntimeExecutionException(this.aDS);
            } else {
                tresult = this.aDR;
            }
        }
        return tresult;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.zzail) {
            z = this.aDQ;
        }
        return z;
    }

    public boolean isSuccessful() {
        boolean z;
        synchronized (this.zzail) {
            z = this.aDQ && this.aDS == null;
        }
        return z;
    }

    public void setException(@NonNull Exception exc) {
        zzab.zzb(exc, (Object) "Exception must not be null");
        synchronized (this.zzail) {
            zzchj();
            this.aDQ = true;
            this.aDS = exc;
        }
        this.aDP.zza((Task<TResult>) this);
    }

    public void setResult(TResult tresult) {
        synchronized (this.zzail) {
            zzchj();
            this.aDQ = true;
            this.aDR = tresult;
        }
        this.aDP.zza((Task<TResult>) this);
    }
}
