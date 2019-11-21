package com.google.android.gms.internal;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public abstract class zzali implements zzahw {
    private ScheduledThreadPoolExecutor bai = new ScheduledThreadPoolExecutor(1, new zza()) {
        /* access modifiers changed from: protected */
        public void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (th == null && (runnable instanceof Future)) {
                Future future = (Future) runnable;
                try {
                    if (future.isDone()) {
                        future.get();
                    }
                } catch (CancellationException e) {
                } catch (ExecutionException e2) {
                    th = e2.getCause();
                } catch (InterruptedException e3) {
                    Thread.currentThread().interrupt();
                }
            }
            if (th != null) {
                zzali.this.zzh(th);
            }
        }
    };

    private class zza implements ThreadFactory {
        private zza() {
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = zzali.this.getThreadFactory().newThread(runnable);
            zzaid zzcqx = zzali.this.zzcqx();
            zzcqx.zza(newThread, "FirebaseDatabaseWorker");
            zzcqx.zza(newThread, true);
            zzcqx.zza(newThread, (UncaughtExceptionHandler) new UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    zzali.this.zzh(th);
                }
            });
            return newThread;
        }
    }

    public zzali() {
        this.bai.setKeepAliveTime(3, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: protected */
    public ThreadFactory getThreadFactory() {
        return Executors.defaultThreadFactory();
    }

    public void restart() {
        this.bai.setCorePoolSize(1);
    }

    public void shutdown() {
        this.bai.setCorePoolSize(0);
    }

    public ScheduledExecutorService zzcoc() {
        return this.bai;
    }

    /* access modifiers changed from: protected */
    public zzaid zzcqx() {
        return zzaid.aVO;
    }

    public abstract void zzh(Throwable th);

    public void zzr(Runnable runnable) {
        this.bai.execute(runnable);
    }
}
