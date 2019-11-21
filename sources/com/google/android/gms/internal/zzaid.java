package com.google.android.gms.internal;

import java.lang.Thread.UncaughtExceptionHandler;

public interface zzaid {
    public static final zzaid aVO = new zzaid() {
        public void zza(Thread thread, String str) {
            thread.setName(str);
        }

        public void zza(Thread thread, UncaughtExceptionHandler uncaughtExceptionHandler) {
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }

        public void zza(Thread thread, boolean z) {
            thread.setDaemon(z);
        }
    };

    void zza(Thread thread, String str);

    void zza(Thread thread, UncaughtExceptionHandler uncaughtExceptionHandler);

    void zza(Thread thread, boolean z);
}
