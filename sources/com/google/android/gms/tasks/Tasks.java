package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzab;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {

    private static final class zza implements zzb {
        private final CountDownLatch zzalc;

        private zza() {
            this.zzalc = new CountDownLatch(1);
        }

        public void await() throws InterruptedException {
            this.zzalc.await();
        }

        public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.zzalc.await(j, timeUnit);
        }

        public void onFailure(@NonNull Exception exc) {
            this.zzalc.countDown();
        }

        public void onSuccess(Object obj) {
            this.zzalc.countDown();
        }
    }

    interface zzb extends OnFailureListener, OnSuccessListener<Object> {
    }

    private static final class zzc implements zzb {
        private final zzh<Void> aDN;
        private Exception aDS;
        private final int aDU;
        private int aDV;
        private int aDW;
        private final Object zzail = new Object();

        public zzc(int i, zzh<Void> zzh) {
            this.aDU = i;
            this.aDN = zzh;
        }

        private void zzchl() {
            if (this.aDV + this.aDW != this.aDU) {
                return;
            }
            if (this.aDS == null) {
                this.aDN.setResult(null);
                return;
            }
            zzh<Void> zzh = this.aDN;
            int i = this.aDW;
            zzh.setException(new ExecutionException(i + " out of " + this.aDU + " underlying tasks failed", this.aDS));
        }

        public void onFailure(@NonNull Exception exc) {
            synchronized (this.zzail) {
                this.aDW++;
                this.aDS = exc;
                zzchl();
            }
        }

        public void onSuccess(Object obj) {
            synchronized (this.zzail) {
                this.aDV++;
                zzchl();
            }
        }
    }

    private Tasks() {
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        zzab.zzata();
        zzab.zzb(task, (Object) "Task must not be null");
        if (task.isComplete()) {
            return zzb(task);
        }
        zza zza2 = new zza();
        zza(task, zza2);
        zza2.await();
        return zzb(task);
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        zzab.zzata();
        zzab.zzb(task, (Object) "Task must not be null");
        zzab.zzb(timeUnit, (Object) "TimeUnit must not be null");
        if (task.isComplete()) {
            return zzb(task);
        }
        zza zza2 = new zza();
        zza(task, zza2);
        if (zza2.await(j, timeUnit)) {
            return zzb(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull final Callable<TResult> callable) {
        zzab.zzb(executor, (Object) "Executor must not be null");
        zzab.zzb(callable, (Object) "Callback must not be null");
        final zzh zzh = new zzh();
        executor.execute(new Runnable() {
            public void run() {
                try {
                    zzh.this.setResult(callable.call());
                } catch (Exception e) {
                    zzh.this.setException(e);
                }
            }
        });
        return zzh;
    }

    public static <TResult> Task<TResult> forException(@NonNull Exception exc) {
        zzh zzh = new zzh();
        zzh.setException(exc);
        return zzh;
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzh zzh = new zzh();
        zzh.setResult(tresult);
        return zzh;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return forResult(null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzh zzh = new zzh();
        zzc zzc2 = new zzc(collection.size(), zzh);
        for (Task zza2 : collection) {
            zza(zza2, zzc2);
        }
        return zzh;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        return taskArr.length == 0 ? forResult(null) : whenAll((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    private static void zza(Task<?> task, zzb zzb2) {
        task.addOnSuccessListener(TaskExecutors.aDO, (OnSuccessListener<? super TResult>) zzb2);
        task.addOnFailureListener(TaskExecutors.aDO, (OnFailureListener) zzb2);
    }

    private static <TResult> TResult zzb(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }
}
