package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzpt<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> sI = new ThreadLocal<Boolean>() {
        /* access modifiers changed from: protected */
        /* renamed from: zzaov */
        public Boolean initialValue() {
            return Boolean.valueOf(false);
        }
    };
    private final Object sJ;
    protected final zza<R> sK;
    protected final WeakReference<GoogleApiClient> sL;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> sM;
    private ResultCallback<? super R> sN;
    private zzb sO;
    private volatile boolean sP;
    private boolean sQ;
    private zzr sR;
    private volatile zzrc<R> sS;
    private boolean sT;
    /* access modifiers changed from: private */
    public R sc;
    private boolean zzak;
    private final CountDownLatch zzalc;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzpt) message.obj).zzaa(Status.sj);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                    return;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzpt<R> zzpt, long j) {
            sendMessageDelayed(obtainMessage(2, zzpt), j);
        }

        public void zzaow() {
            removeMessages(2);
        }

        /* access modifiers changed from: protected */
        public void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzpt.zze(r);
                throw e;
            }
        }
    }

    private final class zzb {
        private zzb() {
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            zzpt.zze(zzpt.this.sc);
            super.finalize();
        }
    }

    @Deprecated
    zzpt() {
        this.sJ = new Object();
        this.zzalc = new CountDownLatch(1);
        this.sM = new ArrayList<>();
        this.sT = false;
        this.sK = new zza<>(Looper.getMainLooper());
        this.sL = new WeakReference<>(null);
    }

    @Deprecated
    protected zzpt(Looper looper) {
        this.sJ = new Object();
        this.zzalc = new CountDownLatch(1);
        this.sM = new ArrayList<>();
        this.sT = false;
        this.sK = new zza<>(looper);
        this.sL = new WeakReference<>(null);
    }

    protected zzpt(GoogleApiClient googleApiClient) {
        this.sJ = new Object();
        this.zzalc = new CountDownLatch(1);
        this.sM = new ArrayList<>();
        this.sT = false;
        this.sK = new zza<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.sL = new WeakReference<>(googleApiClient);
    }

    private R get() {
        R r;
        boolean z = true;
        synchronized (this.sJ) {
            if (this.sP) {
                z = false;
            }
            zzab.zza(z, (Object) "Result has already been consumed.");
            zzab.zza(isReady(), (Object) "Result is not ready.");
            r = this.sc;
            this.sc = null;
            this.sN = null;
            this.sP = true;
        }
        zzaop();
        return r;
    }

    private void zzd(R r) {
        this.sc = r;
        this.sR = null;
        this.zzalc.countDown();
        Status status = this.sc.getStatus();
        if (this.zzak) {
            this.sN = null;
        } else if (this.sN != null) {
            this.sK.zzaow();
            this.sK.zza(this.sN, get());
        } else if (this.sc instanceof Releasable) {
            this.sO = new zzb();
        }
        Iterator it = this.sM.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.PendingResult.zza) it.next()).zzv(status);
        }
        this.sM.clear();
    }

    public static void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public final R await() {
        boolean z = true;
        zzab.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzab.zza(!this.sP, (Object) "Result has already been consumed");
        if (this.sS != null) {
            z = false;
        }
        zzab.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.zzalc.await();
        } catch (InterruptedException e) {
            zzaa(Status.sh);
        }
        zzab.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long j, TimeUnit timeUnit) {
        boolean z = true;
        zzab.zza(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzab.zza(!this.sP, (Object) "Result has already been consumed.");
        if (this.sS != null) {
            z = false;
        }
        zzab.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.zzalc.await(j, timeUnit)) {
                zzaa(Status.sj);
            }
        } catch (InterruptedException e) {
            zzaa(Status.sh);
        }
        zzab.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    public void cancel() {
        synchronized (this.sJ) {
            if (!this.zzak && !this.sP) {
                if (this.sR != null) {
                    try {
                        this.sR.cancel();
                    } catch (RemoteException e) {
                    }
                }
                zze(this.sc);
                this.zzak = true;
                zzd(zzc(Status.sk));
            }
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.sJ) {
            z = this.zzak;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzalc.getCount() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        boolean z = true;
        synchronized (this.sJ) {
            if (resultCallback == null) {
                this.sN = null;
                return;
            }
            zzab.zza(!this.sP, (Object) "Result has already been consumed.");
            if (this.sS != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.sK.zza(resultCallback, get());
                } else {
                    this.sN = resultCallback;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        boolean z = true;
        synchronized (this.sJ) {
            if (resultCallback == null) {
                this.sN = null;
                return;
            }
            zzab.zza(!this.sP, (Object) "Result has already been consumed.");
            if (this.sS != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.sK.zza(resultCallback, get());
                } else {
                    this.sN = resultCallback;
                    this.sK.zza(this, timeUnit.toMillis(j));
                }
            }
        }
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        boolean z = true;
        zzab.zza(!this.sP, (Object) "Result has already been consumed.");
        synchronized (this.sJ) {
            zzab.zza(this.sS == null, (Object) "Cannot call then() twice.");
            if (this.sN != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() if callbacks are set.");
            this.sT = true;
            this.sS = new zzrc<>(this.sL);
            then = this.sS.then(resultTransform);
            if (isReady()) {
                this.sK.zza((ResultCallback<? super R>) this.sS, get());
            } else {
                this.sN = this.sS;
            }
        }
        return then;
    }

    public final void zza(com.google.android.gms.common.api.PendingResult.zza zza2) {
        boolean z = true;
        zzab.zza(!this.sP, (Object) "Result has already been consumed.");
        if (zza2 == null) {
            z = false;
        }
        zzab.zzb(z, (Object) "Callback cannot be null.");
        synchronized (this.sJ) {
            if (isReady()) {
                zza2.zzv(this.sc.getStatus());
            } else {
                this.sM.add(zza2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzr zzr) {
        synchronized (this.sJ) {
            this.sR = zzr;
        }
    }

    public final void zzaa(Status status) {
        synchronized (this.sJ) {
            if (!isReady()) {
                zzc((R) zzc(status));
                this.sQ = true;
            }
        }
    }

    public Integer zzaog() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void zzaop() {
    }

    public boolean zzaos() {
        boolean isCanceled;
        synchronized (this.sJ) {
            if (((GoogleApiClient) this.sL.get()) == null || !this.sT) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public void zzaot() {
        this.sT = this.sT || ((Boolean) sI.get()).booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public boolean zzaou() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract R zzc(Status status);

    public final void zzc(R r) {
        boolean z = true;
        synchronized (this.sJ) {
            if (this.sQ || this.zzak || (isReady() && zzaou())) {
                zze(r);
                return;
            }
            zzab.zza(!isReady(), (Object) "Results have already been set");
            if (this.sP) {
                z = false;
            }
            zzab.zza(z, (Object) "Result has already been consumed");
            zzd(r);
        }
    }
}
