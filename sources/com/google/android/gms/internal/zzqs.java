package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzab;

public final class zzqs<L> {
    private volatile L mListener;
    private final zza vg;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            zzab.zzbn(z);
            zzqs.this.zzb((zzb) message.obj);
        }
    }

    public interface zzb<L> {
        void zzapg();

        void zzu(L l);
    }

    zzqs(Looper looper, L l) {
        this.vg = new zza(looper);
        this.mListener = zzab.zzb(l, (Object) "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzb2) {
        zzab.zzb(zzb2, (Object) "Notifier must not be null");
        this.vg.sendMessage(this.vg.obtainMessage(1, zzb2));
    }

    /* access modifiers changed from: 0000 */
    public void zzb(zzb<? super L> zzb2) {
        L l = this.mListener;
        if (l == null) {
            zzb2.zzapg();
            return;
        }
        try {
            zzb2.zzu(l);
        } catch (RuntimeException e) {
            zzb2.zzapg();
            throw e;
        }
    }
}
