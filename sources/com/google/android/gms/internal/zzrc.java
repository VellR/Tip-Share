package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzab;
import java.lang.ref.WeakReference;

public class zzrc<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    /* access modifiers changed from: private */
    public final Object sJ = new Object();
    /* access modifiers changed from: private */
    public final WeakReference<GoogleApiClient> sL;
    /* access modifiers changed from: private */
    public ResultTransform<? super R, ? extends Result> vk = null;
    /* access modifiers changed from: private */
    public zzrc<? extends Result> vl = null;
    private volatile ResultCallbacks<? super R> vm = null;
    private PendingResult<R> vn = null;
    private Status vo = null;
    /* access modifiers changed from: private */
    public final zza vp;
    private boolean vq = false;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    PendingResult pendingResult = (PendingResult) message.obj;
                    synchronized (zzrc.this.sJ) {
                        if (pendingResult == null) {
                            zzrc.this.vl.zzac(new Status(13, "Transform returned null"));
                        } else if (pendingResult instanceof zzqx) {
                            zzrc.this.vl.zzac(((zzqx) pendingResult).getStatus());
                        } else {
                            zzrc.this.vl.zza(pendingResult);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String str = "TransformedResultImpl";
                    String str2 = "Runtime exception on the transformation worker thread: ";
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                    return;
            }
        }
    }

    public zzrc(WeakReference<GoogleApiClient> weakReference) {
        zzab.zzb(weakReference, (Object) "GoogleApiClient reference must not be null");
        this.sL = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.sL.get();
        this.vp = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public void zzac(Status status) {
        synchronized (this.sJ) {
            this.vo = status;
            zzad(this.vo);
        }
    }

    private void zzad(Status status) {
        synchronized (this.sJ) {
            if (this.vk != null) {
                Status onFailure = this.vk.onFailure(status);
                zzab.zzb(onFailure, (Object) "onFailure must not return null");
                this.vl.zzac(onFailure);
            } else if (zzaqu()) {
                this.vm.onFailure(status);
            }
        }
    }

    private void zzaqs() {
        if (this.vk != null || this.vm != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.sL.get();
            if (!(this.vq || this.vk == null || googleApiClient == null)) {
                googleApiClient.zza(this);
                this.vq = true;
            }
            if (this.vo != null) {
                zzad(this.vo);
            } else if (this.vn != null) {
                this.vn.setResultCallback(this);
            }
        }
    }

    private boolean zzaqu() {
        return (this.vm == null || ((GoogleApiClient) this.sL.get()) == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        boolean z = true;
        synchronized (this.sJ) {
            zzab.zza(this.vm == null, (Object) "Cannot call andFinally() twice.");
            if (this.vk != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.vm = resultCallbacks;
            zzaqs();
        }
    }

    public void onResult(final R r) {
        synchronized (this.sJ) {
            if (!r.getStatus().isSuccess()) {
                zzac(r.getStatus());
                zze((Result) r);
            } else if (this.vk != null) {
                zzqw.zzapz().submit(new Runnable() {
                    @WorkerThread
                    public void run() {
                        try {
                            zzpt.sI.set(Boolean.valueOf(true));
                            zzrc.this.vp.sendMessage(zzrc.this.vp.obtainMessage(0, zzrc.this.vk.onSuccess(r)));
                            zzpt.sI.set(Boolean.valueOf(false));
                            zzrc.this.zze(r);
                            GoogleApiClient googleApiClient = (GoogleApiClient) zzrc.this.sL.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(zzrc.this);
                            }
                        } catch (RuntimeException e) {
                            zzrc.this.vp.sendMessage(zzrc.this.vp.obtainMessage(1, e));
                            zzpt.sI.set(Boolean.valueOf(false));
                            zzrc.this.zze(r);
                            GoogleApiClient googleApiClient2 = (GoogleApiClient) zzrc.this.sL.get();
                            if (googleApiClient2 != null) {
                                googleApiClient2.zzb(zzrc.this);
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            zzpt.sI.set(Boolean.valueOf(false));
                            zzrc.this.zze(r);
                            GoogleApiClient googleApiClient3 = (GoogleApiClient) zzrc.this.sL.get();
                            if (googleApiClient3 != null) {
                                googleApiClient3.zzb(zzrc.this);
                            }
                            throw th2;
                        }
                    }
                });
            } else if (zzaqu()) {
                this.vm.onSuccess(r);
            }
        }
    }

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zzrc<? extends Result> zzrc;
        boolean z = true;
        synchronized (this.sJ) {
            zzab.zza(this.vk == null, (Object) "Cannot call then() twice.");
            if (this.vm != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.vk = resultTransform;
            zzrc = new zzrc<>(this.sL);
            this.vl = zzrc;
            zzaqs();
        }
        return zzrc;
    }

    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.sJ) {
            this.vn = pendingResult;
            zzaqs();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzaqt() {
        this.vm = null;
    }
}
