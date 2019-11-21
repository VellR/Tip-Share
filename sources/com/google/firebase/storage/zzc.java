package com.google.firebase.storage;

import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class zzc {
    private static final zzc bcO = new zzc();
    private final Map<String, WeakReference<StorageTask>> bcP = new HashMap();
    private final Object mSyncObject = new Object();

    zzc() {
    }

    static zzc zzcyi() {
        return bcO;
    }

    public List<UploadTask> zza(@NonNull StorageReference storageReference) {
        List<UploadTask> unmodifiableList;
        synchronized (this.mSyncObject) {
            ArrayList arrayList = new ArrayList();
            String storageReference2 = storageReference.toString();
            for (Entry entry : this.bcP.entrySet()) {
                if (((String) entry.getKey()).startsWith(storageReference2)) {
                    StorageTask storageTask = (StorageTask) ((WeakReference) entry.getValue()).get();
                    if (storageTask instanceof UploadTask) {
                        arrayList.add((UploadTask) storageTask);
                    }
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public void zza(StorageTask storageTask) {
        synchronized (this.mSyncObject) {
            this.bcP.put(storageTask.getStorage().toString(), new WeakReference(storageTask));
        }
    }

    public List<FileDownloadTask> zzb(@NonNull StorageReference storageReference) {
        List<FileDownloadTask> unmodifiableList;
        synchronized (this.mSyncObject) {
            ArrayList arrayList = new ArrayList();
            String storageReference2 = storageReference.toString();
            for (Entry entry : this.bcP.entrySet()) {
                if (((String) entry.getKey()).startsWith(storageReference2)) {
                    StorageTask storageTask = (StorageTask) ((WeakReference) entry.getValue()).get();
                    if (storageTask instanceof FileDownloadTask) {
                        arrayList.add((FileDownloadTask) storageTask);
                    }
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public void zzb(StorageTask storageTask) {
        synchronized (this.mSyncObject) {
            String storageReference = storageTask.getStorage().toString();
            WeakReference weakReference = (WeakReference) this.bcP.get(storageReference);
            StorageTask storageTask2 = weakReference != null ? (StorageTask) weakReference.get() : null;
            if (storageTask2 == null || storageTask2 == storageTask) {
                this.bcP.remove(storageReference);
            }
        }
    }
}
