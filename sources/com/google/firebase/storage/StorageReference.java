package com.google.firebase.storage;

import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzame;
import com.google.android.gms.internal.zzaml;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.StreamDownloadTask.StreamProcessor;
import com.google.firebase.storage.StreamDownloadTask.TaskSnapshot;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class StorageReference {
    static final /* synthetic */ boolean $assertionsDisabled = (!StorageReference.class.desiredAssertionStatus());
    private final FirebaseStorage bcA;
    private final Uri bcz;

    StorageReference(@NonNull Uri uri, @NonNull FirebaseStorage firebaseStorage) {
        boolean z = true;
        zzab.zzb(uri != null, (Object) "storageUri cannot be null");
        if (firebaseStorage == null) {
            z = false;
        }
        zzab.zzb(z, (Object) "FirebaseApp cannot be null");
        this.bcz = uri;
        this.bcA = firebaseStorage;
    }

    @NonNull
    public StorageReference child(@NonNull String str) {
        zzab.zzb(!TextUtils.isEmpty(str), (Object) "childName cannot be null or empty");
        String zzsq = zzame.zzsq(str);
        try {
            return new StorageReference(this.bcz.buildUpon().appendEncodedPath(zzame.zzso(zzsq)).build(), this.bcA);
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            String str2 = "StorageReference";
            String str3 = "Unable to create a valid default Uri. ";
            String valueOf = String.valueOf(zzsq);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), unsupportedEncodingException);
            throw new IllegalArgumentException("childName");
        }
    }

    public Task<Void> delete() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzd.zzcyj().zzs(new zza(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StorageReference)) {
            return false;
        }
        return ((StorageReference) obj).toString().equals(toString());
    }

    @NonNull
    public List<FileDownloadTask> getActiveDownloadTasks() {
        return zzc.zzcyi().zzb(this);
    }

    @NonNull
    public List<UploadTask> getActiveUploadTasks() {
        return zzc.zzcyi().zza(this);
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public FirebaseApp getApp() {
        return getStorage().getApp();
    }

    @NonNull
    public String getBucket() {
        return this.bcz.getAuthority();
    }

    @NonNull
    public Task<byte[]> getBytes(final long j) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        StorageTask storageTask = (StorageTask) ((StorageTask) streamDownloadTask.zza((StreamProcessor) new StreamProcessor() {
            public void doInBackground(TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException {
                int i = 0;
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 16384);
                        if (read != -1) {
                            i += read;
                            if (((long) i) > j) {
                                Log.e("StorageReference", "the maximum allowed buffer size was exceeded.");
                                throw new IndexOutOfBoundsException("the maximum allowed buffer size was exceeded.");
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byteArrayOutputStream.flush();
                            taskCompletionSource.setResult(byteArrayOutputStream.toByteArray());
                            return;
                        }
                    }
                } finally {
                    inputStream.close();
                }
            }
        }).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<TaskSnapshot>() {
            /* renamed from: zza */
            public void onSuccess(TaskSnapshot taskSnapshot) {
                if (!taskCompletionSource.getTask().isComplete()) {
                    Log.e("StorageReference", "getBytes 'succeeded', but failed to set a Result.");
                    taskCompletionSource.setException(StorageException.fromErrorStatus(Status.si));
                }
            }
        })).addOnFailureListener((OnFailureListener) new OnFailureListener() {
            static final /* synthetic */ boolean $assertionsDisabled = (!StorageReference.class.desiredAssertionStatus());

            public void onFailure(@NonNull Exception exc) {
                StorageException fromExceptionAndHttpCode = StorageException.fromExceptionAndHttpCode(exc, 0);
                if ($assertionsDisabled || fromExceptionAndHttpCode != null) {
                    taskCompletionSource.setException(fromExceptionAndHttpCode);
                    return;
                }
                throw new AssertionError();
            }
        });
        streamDownloadTask.zzcyd();
        return taskCompletionSource.getTask();
    }

    @NonNull
    public Task<Uri> getDownloadUrl() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task metadata = getMetadata();
        metadata.addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
            /* renamed from: zzb */
            public void onSuccess(StorageMetadata storageMetadata) {
                taskCompletionSource.setResult(storageMetadata.getDownloadUrl());
            }
        });
        metadata.addOnFailureListener(new OnFailureListener() {
            public void onFailure(@NonNull Exception exc) {
                taskCompletionSource.setException(exc);
            }
        });
        return taskCompletionSource.getTask();
    }

    @NonNull
    public FileDownloadTask getFile(@NonNull Uri uri) {
        FileDownloadTask fileDownloadTask = new FileDownloadTask(this, uri);
        fileDownloadTask.zzcyd();
        return fileDownloadTask;
    }

    @NonNull
    public FileDownloadTask getFile(@NonNull File file) {
        return getFile(Uri.fromFile(file));
    }

    @NonNull
    public Task<StorageMetadata> getMetadata() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzd.zzcyj().zzs(new zzb(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public String getName() {
        String path = this.bcz.getPath();
        if ($assertionsDisabled || path != null) {
            int lastIndexOf = path.lastIndexOf(47);
            return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
        }
        throw new AssertionError();
    }

    @Nullable
    public StorageReference getParent() {
        String path = this.bcz.getPath();
        if (path == null || path.equals("/")) {
            return null;
        }
        int lastIndexOf = path.lastIndexOf(47);
        return new StorageReference(this.bcz.buildUpon().path(lastIndexOf == -1 ? "/" : path.substring(0, lastIndexOf)).build(), this.bcA);
    }

    @NonNull
    public String getPath() {
        String path = this.bcz.getPath();
        if ($assertionsDisabled || path != null) {
            return path;
        }
        throw new AssertionError();
    }

    @NonNull
    public StorageReference getRoot() {
        return new StorageReference(this.bcz.buildUpon().path("").build(), this.bcA);
    }

    @NonNull
    public FirebaseStorage getStorage() {
        return this.bcA;
    }

    @NonNull
    public StreamDownloadTask getStream() {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.zzcyd();
        return streamDownloadTask;
    }

    @NonNull
    public StreamDownloadTask getStream(@NonNull StreamProcessor streamProcessor) {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.zza(streamProcessor);
        streamDownloadTask.zzcyd();
        return streamDownloadTask;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @NonNull
    public UploadTask putBytes(@NonNull byte[] bArr) {
        zzab.zzb(bArr != null, (Object) "bytes cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, bArr);
        uploadTask.zzcyd();
        return uploadTask;
    }

    @NonNull
    public UploadTask putBytes(@NonNull byte[] bArr, @NonNull StorageMetadata storageMetadata) {
        boolean z = true;
        zzab.zzb(bArr != null, (Object) "bytes cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        zzab.zzb(z, (Object) "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, bArr);
        uploadTask.zzcyd();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri) {
        zzab.zzb(uri != null, (Object) "uri cannot be null");
        UploadTask uploadTask = new UploadTask(this, null, uri, null);
        uploadTask.zzcyd();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri, @NonNull StorageMetadata storageMetadata) {
        boolean z = true;
        zzab.zzb(uri != null, (Object) "uri cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        zzab.zzb(z, (Object) "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, uri, null);
        uploadTask.zzcyd();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri, @Nullable StorageMetadata storageMetadata, @Nullable Uri uri2) {
        boolean z = true;
        zzab.zzb(uri != null, (Object) "uri cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        zzab.zzb(z, (Object) "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, uri, uri2);
        uploadTask.zzcyd();
        return uploadTask;
    }

    @NonNull
    public UploadTask putStream(@NonNull InputStream inputStream) {
        zzab.zzb(inputStream != null, (Object) "stream cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, inputStream);
        uploadTask.zzcyd();
        return uploadTask;
    }

    @NonNull
    public UploadTask putStream(@NonNull InputStream inputStream, @NonNull StorageMetadata storageMetadata) {
        boolean z = true;
        zzab.zzb(inputStream != null, (Object) "stream cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        zzab.zzb(z, (Object) "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, inputStream);
        uploadTask.zzcyd();
        return uploadTask;
    }

    public String toString() {
        String valueOf = String.valueOf(this.bcz.getAuthority());
        String valueOf2 = String.valueOf(this.bcz.getPath());
        return new StringBuilder(String.valueOf(valueOf).length() + 5 + String.valueOf(valueOf2).length()).append("gs://").append(valueOf).append(valueOf2).toString();
    }

    @NonNull
    public Task<StorageMetadata> updateMetadata(@NonNull StorageMetadata storageMetadata) {
        zzab.zzaa(storageMetadata);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzd.zzcyj().zzs(new zzf(this, taskCompletionSource, storageMetadata));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public zzaml zzcyb() throws RemoteException {
        return zzaml.zzi(getApp());
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public Uri zzcyc() {
        return this.bcz;
    }
}
