package com.google.android.gms.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class zzaie implements zzaho {
    private final ThreadPoolExecutor aVP;

    public zzaie(final ThreadFactory threadFactory, final zzaid zzaid) {
        this.aVP = new ThreadPoolExecutor(1, 1, 3, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread newThread = threadFactory.newThread(runnable);
                zzaid.zza(newThread, "FirebaseDatabaseEventTarget");
                zzaid.zza(newThread, true);
                return newThread;
            }
        });
    }

    public void restart() {
        this.aVP.setCorePoolSize(1);
    }

    public void shutdown() {
        this.aVP.setCorePoolSize(0);
    }

    public void zzp(Runnable runnable) {
        this.aVP.execute(runnable);
    }
}
