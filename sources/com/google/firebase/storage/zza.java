package com.google.firebase.storage;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzamd;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.tasks.TaskCompletionSource;

class zza implements Runnable {
    private StorageReference bbS;
    private TaskCompletionSource<Void> bbT;
    private zzamd bbU = new zzamd(this.bbS.getStorage().getApp(), this.bbS.getStorage().getMaxOperationRetryTimeMillis());

    public zza(@NonNull StorageReference storageReference, @NonNull TaskCompletionSource<Void> taskCompletionSource) {
        zzab.zzaa(storageReference);
        zzab.zzaa(taskCompletionSource);
        this.bbS = storageReference;
        this.bbT = taskCompletionSource;
    }

    public void run() {
        try {
            zzamm zzaa = this.bbS.zzcyb().zzaa(this.bbS.zzcyc());
            this.bbU.zzd(zzaa);
            zzaa.zza(this.bbT, null);
        } catch (RemoteException e) {
            Log.e("DeleteStorageTask", "Unable to create Firebase Storage network request.", e);
            this.bbT.setException(StorageException.fromException(e));
        }
    }
}
