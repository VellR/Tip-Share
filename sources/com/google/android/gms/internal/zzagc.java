package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public class zzagc implements Executor {
    private static zzagc aOy = new zzagc();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private zzagc() {
    }

    public static zzagc zzcmc() {
        return aOy;
    }

    public void execute(@NonNull Runnable runnable) {
        this.mHandler.post(runnable);
    }
}
