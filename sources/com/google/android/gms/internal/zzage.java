package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;

public class zzage implements zzaho {
    private final Handler handler = new Handler(Looper.getMainLooper());

    public void restart() {
    }

    public void shutdown() {
    }

    public void zzp(Runnable runnable) {
        this.handler.post(runnable);
    }
}
