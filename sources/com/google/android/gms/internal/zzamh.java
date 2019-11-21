package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.storage.zzd;
import java.util.concurrent.Executor;

public class zzamh {
    private final Executor avP;
    private final Handler mHandler;

    public zzamh(@Nullable Executor executor) {
        this.avP = executor;
        if (this.avP != null) {
            this.mHandler = null;
        } else if (Looper.myLooper() != null) {
            this.mHandler = new Handler();
        } else {
            this.mHandler = null;
        }
    }

    public void zzw(@NonNull Runnable runnable) {
        zzab.zzaa(runnable);
        if (this.mHandler != null) {
            this.mHandler.post(runnable);
        } else if (this.avP != null) {
            this.avP.execute(runnable);
        } else {
            zzd.zzcyj().zzv(runnable);
        }
    }
}
