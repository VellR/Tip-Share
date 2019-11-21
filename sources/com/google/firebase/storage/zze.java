package com.google.firebase.storage;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.internal.zzamh;
import com.google.firebase.storage.StorageTask.ProvideError;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

class zze<TListenerType, TResult extends ProvideError> {
    private final Queue<TListenerType> bdi = new ConcurrentLinkedQueue();
    private final HashMap<TListenerType, zzamh> bdj = new HashMap<>();
    private StorageTask<TResult> bdk;
    private int bdl;
    /* access modifiers changed from: private */
    public zza<TListenerType, TResult> bdm;

    public interface zza<TListenerType, TResult> {
        void zzl(@NonNull TListenerType tlistenertype, @NonNull TResult tresult);
    }

    public zze(@NonNull StorageTask<TResult> storageTask, int i, @NonNull zza<TListenerType, TResult> zza2) {
        this.bdk = storageTask;
        this.bdl = i;
        this.bdm = zza2;
    }

    public void zza(@Nullable Activity activity, @Nullable Executor executor, @NonNull final TListenerType tlistenertype) {
        boolean z;
        boolean z2 = true;
        zzab.zzaa(tlistenertype);
        synchronized (this.bdk.zzcyf()) {
            z = (this.bdk.zzcye() & this.bdl) != 0;
            this.bdi.add(tlistenertype);
            this.bdj.put(tlistenertype, new zzamh(executor));
            if (activity != null) {
                if (VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed()) {
                        z2 = false;
                    }
                    zzab.zzb(z2, (Object) "Activity is already destroyed!");
                }
                zzamc.zzcys().zza(activity, tlistenertype, new Runnable() {
                    public void run() {
                        zze.this.zzch(tlistenertype);
                    }
                });
            }
        }
        if (z) {
            this.bdm.zzl(tlistenertype, this.bdk.zzcyg());
        }
    }

    public void zzch(@NonNull TListenerType tlistenertype) {
        zzab.zzaa(tlistenertype);
        synchronized (this.bdk.zzcyf()) {
            this.bdj.remove(tlistenertype);
            this.bdi.remove(tlistenertype);
            zzamc.zzcys().zzci(tlistenertype);
        }
    }

    public void zzcym() {
        if ((this.bdk.zzcye() & this.bdl) != 0) {
            final ProvideError zzcyg = this.bdk.zzcyg();
            for (final Object next : this.bdi) {
                zzamh zzamh = (zzamh) this.bdj.get(next);
                if (zzamh != null) {
                    zzamh.zzw(new Runnable() {
                        public void run() {
                            zze.this.bdm.zzl(next, zzcyg);
                        }
                    });
                }
            }
        }
    }
}
