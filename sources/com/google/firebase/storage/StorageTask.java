package com.google.firebase.storage;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.firebase.storage.StorageTask.ProvideError;
import com.google.firebase.storage.zze.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executor;

public abstract class StorageTask<TResult extends ProvideError> extends ControllableTask<TResult> {
    private static final HashMap<Integer, HashSet<Integer>> bcF = new HashMap<>();
    private static final HashMap<Integer, HashSet<Integer>> bcG = new HashMap<>();
    private final zze<OnSuccessListener<? super TResult>, TResult> bcH = new zze<>(this, 128, new zza<OnSuccessListener<? super TResult>, TResult>() {
        /* renamed from: zza */
        public void zzl(@NonNull OnSuccessListener<? super TResult> onSuccessListener, @NonNull TResult tresult) {
            zzc.zzcyi().zzb(StorageTask.this);
            onSuccessListener.onSuccess(tresult);
        }
    });
    private final zze<OnFailureListener, TResult> bcI = new zze<>(this, 320, new zza<OnFailureListener, TResult>() {
        /* renamed from: zza */
        public void zzl(@NonNull OnFailureListener onFailureListener, @NonNull TResult tresult) {
            zzc.zzcyi().zzb(StorageTask.this);
            onFailureListener.onFailure(tresult.getError());
        }
    });
    private final zze<OnProgressListener<? super TResult>, TResult> bcJ = new zze<>(this, -465, new zza<OnProgressListener<? super TResult>, TResult>() {
        /* renamed from: zza */
        public void zzl(@NonNull OnProgressListener<? super TResult> onProgressListener, @NonNull TResult tresult) {
            onProgressListener.onProgress(tresult);
        }
    });
    private final zze<OnPausedListener<? super TResult>, TResult> bcK = new zze<>(this, 16, new zza<OnPausedListener<? super TResult>, TResult>() {
        /* renamed from: zza */
        public void zzl(@NonNull OnPausedListener<? super TResult> onPausedListener, @NonNull TResult tresult) {
            onPausedListener.onPaused(tresult);
        }
    });
    private TResult bcL;
    protected final Object mSyncObject = new Object();
    private int zzbry = 1;

    protected interface ProvideError {
        Exception getError();
    }

    class SnapshotBase implements ProvideError {
        private final Exception bcN;

        public SnapshotBase(Exception exc) {
            this.bcN = exc;
        }

        @Nullable
        public Exception getError() {
            return this.bcN;
        }

        @NonNull
        public StorageReference getStorage() {
            return getTask().getStorage();
        }

        @NonNull
        public StorageTask<TResult> getTask() {
            return StorageTask.this;
        }
    }

    static {
        bcF.put(Integer.valueOf(1), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(16), Integer.valueOf(256)})));
        bcF.put(Integer.valueOf(2), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(8), Integer.valueOf(32)})));
        bcF.put(Integer.valueOf(4), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(8), Integer.valueOf(32)})));
        bcF.put(Integer.valueOf(16), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(256)})));
        bcF.put(Integer.valueOf(64), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(256)})));
        bcG.put(Integer.valueOf(1), new HashSet(Collections.singletonList(Integer.valueOf(2))));
        bcG.put(Integer.valueOf(2), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(4), Integer.valueOf(64), Integer.valueOf(128)})));
        bcG.put(Integer.valueOf(4), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(4), Integer.valueOf(64), Integer.valueOf(128)})));
        bcG.put(Integer.valueOf(8), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(16), Integer.valueOf(64), Integer.valueOf(128)})));
        bcG.put(Integer.valueOf(32), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(256), Integer.valueOf(64), Integer.valueOf(128)})));
    }

    protected StorageTask() {
    }

    private String zzadz(int i) {
        switch (i) {
            case 1:
                return "INTERNAL_STATE_NOT_STARTED";
            case 2:
                return "INTERNAL_STATE_QUEUED";
            case 4:
                return "INTERNAL_STATE_IN_PROGRESS";
            case 8:
                return "INTERNAL_STATE_PAUSING";
            case 16:
                return "INTERNAL_STATE_PAUSED";
            case 32:
                return "INTERNAL_STATE_CANCELING";
            case 64:
                return "INTERNAL_STATE_FAILURE";
            case 128:
                return "INTERNAL_STATE_SUCCESS";
            case 256:
                return "INTERNAL_STATE_CANCELED";
            default:
                return "Unknown Internal State!";
        }
    }

    private TResult zzcyh() {
        if (this.bcL != null) {
            return this.bcL;
        }
        if (!isComplete()) {
            return null;
        }
        if (this.bcL == null) {
            this.bcL = zzcyg();
        }
        return this.bcL;
    }

    @NonNull
    public StorageTask<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzab.zzaa(onFailureListener);
        zzab.zzaa(activity);
        this.bcI.zza(activity, null, onFailureListener);
        return this;
    }

    @NonNull
    public StorageTask<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        zzab.zzaa(onFailureListener);
        this.bcI.zza(null, null, onFailureListener);
        return this;
    }

    @NonNull
    public StorageTask<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        zzab.zzaa(onFailureListener);
        zzab.zzaa(executor);
        this.bcI.zza(null, executor, onFailureListener);
        return this;
    }

    public StorageTask<TResult> addOnPausedListener(@NonNull Activity activity, @NonNull OnPausedListener<? super TResult> onPausedListener) {
        zzab.zzaa(onPausedListener);
        zzab.zzaa(activity);
        this.bcK.zza(activity, null, onPausedListener);
        return this;
    }

    public StorageTask<TResult> addOnPausedListener(@NonNull OnPausedListener<? super TResult> onPausedListener) {
        zzab.zzaa(onPausedListener);
        this.bcK.zza(null, null, onPausedListener);
        return this;
    }

    public StorageTask<TResult> addOnPausedListener(@NonNull Executor executor, @NonNull OnPausedListener<? super TResult> onPausedListener) {
        zzab.zzaa(onPausedListener);
        zzab.zzaa(executor);
        this.bcK.zza(null, executor, onPausedListener);
        return this;
    }

    public StorageTask<TResult> addOnProgressListener(@NonNull Activity activity, @NonNull OnProgressListener<? super TResult> onProgressListener) {
        zzab.zzaa(onProgressListener);
        zzab.zzaa(activity);
        this.bcJ.zza(activity, null, onProgressListener);
        return this;
    }

    public StorageTask<TResult> addOnProgressListener(@NonNull OnProgressListener<? super TResult> onProgressListener) {
        zzab.zzaa(onProgressListener);
        this.bcJ.zza(null, null, onProgressListener);
        return this;
    }

    public StorageTask<TResult> addOnProgressListener(@NonNull Executor executor, @NonNull OnProgressListener<? super TResult> onProgressListener) {
        zzab.zzaa(onProgressListener);
        zzab.zzaa(executor);
        this.bcJ.zza(null, executor, onProgressListener);
        return this;
    }

    @NonNull
    public StorageTask<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzab.zzaa(activity);
        zzab.zzaa(onSuccessListener);
        this.bcH.zza(activity, null, onSuccessListener);
        return this;
    }

    @NonNull
    public StorageTask<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzab.zzaa(onSuccessListener);
        this.bcH.zza(null, null, onSuccessListener);
        return this;
    }

    @NonNull
    public StorageTask<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzab.zzaa(executor);
        zzab.zzaa(onSuccessListener);
        this.bcH.zza(null, executor, onSuccessListener);
        return this;
    }

    public boolean cancel() {
        return zzi(256, true) || zzi(32, true);
    }

    @Nullable
    public Exception getException() {
        if (zzcyh() == null) {
            return null;
        }
        return zzcyh().getError();
    }

    public TResult getResult() {
        if (zzcyh() == null) {
            throw new IllegalStateException();
        }
        Exception error = zzcyh().getError();
        if (error == null) {
            return zzcyh();
        }
        throw new RuntimeExecutionException(error);
    }

    public <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        if (zzcyh() == null) {
            throw new IllegalStateException();
        } else if (cls.isInstance(zzcyh().getError())) {
            throw ((Throwable) cls.cast(zzcyh().getError()));
        } else {
            Exception error = zzcyh().getError();
            if (error == null) {
                return zzcyh();
            }
            throw new RuntimeExecutionException(error);
        }
    }

    public TResult getSnapshot() {
        return zzcyg();
    }

    /* access modifiers changed from: 0000 */
    public abstract StorageReference getStorage();

    public boolean isCanceled() {
        return zzcye() == 256;
    }

    public boolean isComplete() {
        return ((zzcye() & 128) == 0 && (zzcye() & 320) == 0) ? false : true;
    }

    public boolean isInProgress() {
        return (zzcye() & -465) != 0;
    }

    public boolean isPaused() {
        return (zzcye() & 16) != 0;
    }

    public boolean isSuccessful() {
        return (zzcye() & 128) != 0;
    }

    /* access modifiers changed from: protected */
    public void onCanceled() {
    }

    /* access modifiers changed from: protected */
    public void onFailure() {
    }

    /* access modifiers changed from: protected */
    public void onPaused() {
    }

    /* access modifiers changed from: protected */
    public void onProgress() {
    }

    /* access modifiers changed from: protected */
    public void onQueued() {
    }

    /* access modifiers changed from: protected */
    public void onSuccess() {
    }

    public boolean pause() {
        return zzi(16, true) || zzi(8, true);
    }

    public StorageTask<TResult> removeOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        zzab.zzaa(onFailureListener);
        this.bcI.zzch(onFailureListener);
        return this;
    }

    public StorageTask<TResult> removeOnPausedListener(@NonNull OnPausedListener<? super TResult> onPausedListener) {
        zzab.zzaa(onPausedListener);
        this.bcK.zzch(onPausedListener);
        return this;
    }

    public StorageTask<TResult> removeOnProgressListener(@NonNull OnProgressListener<? super TResult> onProgressListener) {
        zzab.zzaa(onProgressListener);
        this.bcJ.zzch(onProgressListener);
        return this;
    }

    public StorageTask<TResult> removeOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzab.zzaa(onSuccessListener);
        this.bcH.zzch(onSuccessListener);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void resetState() {
    }

    public boolean resume() {
        if (!zzi(2, true)) {
            return false;
        }
        resetState();
        schedule();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public abstract void run();

    /* access modifiers changed from: 0000 */
    public abstract void schedule();

    /* access modifiers changed from: 0000 */
    public Runnable zzcjq() {
        return new Runnable() {
            public void run() {
                StorageTask.this.run();
            }
        };
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public abstract TResult zzcxy();

    /* access modifiers changed from: 0000 */
    public boolean zzcyd() {
        if (!zzi(2, false)) {
            return false;
        }
        schedule();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public int zzcye() {
        return this.zzbry;
    }

    /* access modifiers changed from: 0000 */
    public Object zzcyf() {
        return this.mSyncObject;
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public TResult zzcyg() {
        TResult zzcxy;
        synchronized (this.mSyncObject) {
            zzcxy = zzcxy();
        }
        return zzcxy;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzi(int i, boolean z) {
        boolean z2;
        if (Log.isLoggable("StorageTask", 3)) {
            String valueOf = String.valueOf(zzadz(i));
            String valueOf2 = String.valueOf(zzadz(this.zzbry));
            Log.d("StorageTask", new StringBuilder(String.valueOf(valueOf).length() + 54 + String.valueOf(valueOf2).length()).append("changing internal state to: ").append(valueOf).append(" isUser: ").append(z).append(" from state:").append(valueOf2).toString());
        }
        synchronized (this.mSyncObject) {
            HashSet hashSet = (HashSet) (z ? bcF : bcG).get(Integer.valueOf(zzcye()));
            if (hashSet == null || !hashSet.contains(Integer.valueOf(i))) {
                String valueOf3 = String.valueOf(zzadz(i));
                String valueOf4 = String.valueOf(zzadz(this.zzbry));
                Log.w("StorageTask", new StringBuilder(String.valueOf(valueOf3).length() + 62 + String.valueOf(valueOf4).length()).append("unable to change internal state to: ").append(valueOf3).append(" isUser: ").append(z).append(" from state:").append(valueOf4).toString());
                z2 = false;
            } else {
                this.zzbry = i;
                switch (this.zzbry) {
                    case 2:
                        zzc.zzcyi().zza(this);
                        onQueued();
                        break;
                    case 4:
                        onProgress();
                        break;
                    case 16:
                        onPaused();
                        break;
                    case 64:
                        onFailure();
                        break;
                    case 128:
                        onSuccess();
                        break;
                    case 256:
                        onCanceled();
                        break;
                }
                this.bcH.zzcym();
                this.bcI.zzcym();
                this.bcK.zzcym();
                this.bcJ.zzcym();
                z2 = true;
            }
        }
        return z2;
    }
}
