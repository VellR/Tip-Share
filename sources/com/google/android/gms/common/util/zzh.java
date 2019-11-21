package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class zzh implements zze {
    private static zzh AK;

    public static synchronized zze zzavi() {
        zzh zzh;
        synchronized (zzh.class) {
            if (AK == null) {
                AK = new zzh();
            }
            zzh = AK;
        }
        return zzh;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
