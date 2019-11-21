package com.google.firebase.storage;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzamd;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageMetadata.Builder;
import org.json.JSONException;

class zzb implements Runnable {
    private StorageReference bbS;
    private TaskCompletionSource<StorageMetadata> bbT;
    private zzamd bbU = new zzamd(this.bbS.getApp(), this.bbS.getStorage().getMaxOperationRetryTimeMillis());
    private StorageMetadata bce;

    public zzb(@NonNull StorageReference storageReference, @NonNull TaskCompletionSource<StorageMetadata> taskCompletionSource) {
        zzab.zzaa(storageReference);
        zzab.zzaa(taskCompletionSource);
        this.bbS = storageReference;
        this.bbT = taskCompletionSource;
    }

    public void run() {
        try {
            zzamm zzab = this.bbS.zzcyb().zzab(this.bbS.zzcyc());
            this.bbU.zzd(zzab);
            if (zzab.zzcza()) {
                try {
                    this.bce = new Builder(zzab.zzczd(), this.bbS).build();
                } catch (RemoteException | JSONException e) {
                    String str = "GetMetadataTask";
                    String str2 = "Unable to parse resulting metadata. ";
                    String valueOf = String.valueOf(zzab.zzcyx());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
                    this.bbT.setException(StorageException.fromException(e));
                    return;
                }
            }
            if (this.bbT != null) {
                zzab.zza(this.bbT, this.bce);
            }
        } catch (RemoteException e2) {
            Log.e("GetMetadataTask", "Unable to create firebase storage network request.", e2);
            this.bbT.setException(StorageException.fromException(e2));
        }
    }
}
