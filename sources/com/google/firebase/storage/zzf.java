package com.google.firebase.storage;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.internal.zzamd;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageMetadata.Builder;
import org.json.JSONException;

class zzf implements Runnable {
    private final StorageReference bbS;
    private final TaskCompletionSource<StorageMetadata> bbT;
    private zzamd bbU;
    private StorageMetadata bce = null;
    private final StorageMetadata bdr;

    public zzf(@NonNull StorageReference storageReference, @NonNull TaskCompletionSource<StorageMetadata> taskCompletionSource, @NonNull StorageMetadata storageMetadata) {
        this.bbS = storageReference;
        this.bbT = taskCompletionSource;
        this.bdr = storageMetadata;
        this.bbU = new zzamd(this.bbS.getApp(), this.bbS.getStorage().getMaxOperationRetryTimeMillis());
    }

    public void run() {
        try {
            zzamm zza = this.bbS.zzcyb().zza(this.bbS.zzcyc(), this.bdr.zzcya());
            this.bbU.zzd(zza);
            if (zza.zzcza()) {
                try {
                    this.bce = new Builder(zza.zzczd(), this.bbS).build();
                } catch (RemoteException | JSONException e) {
                    String str = "UpdateMetadataTask";
                    String str2 = "Unable to parse a valid JSON object from resulting metadata:";
                    String valueOf = String.valueOf(zza.zzcyx());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
                    this.bbT.setException(StorageException.fromException(e));
                    return;
                }
            }
            if (this.bbT != null) {
                zza.zza(this.bbT, this.bce);
            }
        } catch (RemoteException | JSONException e2) {
            Log.e("UpdateMetadataTask", "Unable to create the request from metadata.", e2);
            this.bbT.setException(StorageException.fromException(e2));
        }
    }
}
