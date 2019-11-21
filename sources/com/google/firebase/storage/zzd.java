package com.google.firebase.storage;

import android.support.annotation.NonNull;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class zzd {
    public static zzd bcQ = new zzd();
    private static BlockingQueue<Runnable> bcR = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor bcS = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, bcR, new zza("Command-"));
    private static BlockingQueue<Runnable> bcT = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor bcU = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, bcT, new zza("Upload-"));
    private static BlockingQueue<Runnable> bcV = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor bcW = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, bcV, new zza("Download-"));
    private static BlockingQueue<Runnable> bcX = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor bcY = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, bcX, new zza("Callbacks-"));

    static class zza implements ThreadFactory {
        private final AtomicInteger bcZ = new AtomicInteger(1);
        private final String bda;

        zza(@NonNull String str) {
            this.bda = str;
        }

        public Thread newThread(@NonNull Runnable runnable) {
            String str = this.bda;
            Thread thread = new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 27).append("FirebaseStorage-").append(str).append(this.bcZ.getAndIncrement()).toString());
            thread.setDaemon(false);
            thread.setPriority(9);
            return thread;
        }
    }

    static {
        bcS.allowCoreThreadTimeOut(true);
        bcU.allowCoreThreadTimeOut(true);
        bcW.allowCoreThreadTimeOut(true);
        bcY.allowCoreThreadTimeOut(true);
    }

    public static zzd zzcyj() {
        return bcQ;
    }

    public void zzs(Runnable runnable) {
        bcS.execute(runnable);
    }

    public void zzt(Runnable runnable) {
        bcU.execute(runnable);
    }

    public void zzu(Runnable runnable) {
        bcW.execute(runnable);
    }

    public void zzv(Runnable runnable) {
        bcY.execute(runnable);
    }
}
