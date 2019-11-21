package com.google.firebase.storage;

import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzamd;
import com.google.android.gms.internal.zzamm;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileDownloadTask extends StorageTask<TaskSnapshot> {
    private long Go = -1;
    private volatile Exception aDS = null;
    private StorageReference bbS;
    private zzamd bbU;
    private final Uri bbV;
    private long bbW;
    private String bbX = null;
    private long bbY = 0;
    private int mResultCode;

    public class TaskSnapshot extends SnapshotBase {
        private final long bbW;

        TaskSnapshot(Exception exc, long j) {
            super(exc);
            this.bbW = j;
        }

        public long getBytesTransferred() {
            return this.bbW;
        }

        @Nullable
        public /* bridge */ /* synthetic */ Exception getError() {
            return super.getError();
        }

        @NonNull
        public /* bridge */ /* synthetic */ StorageReference getStorage() {
            return super.getStorage();
        }

        @NonNull
        public /* bridge */ /* synthetic */ StorageTask getTask() {
            return super.getTask();
        }

        public long getTotalByteCount() {
            return FileDownloadTask.this.getTotalBytes();
        }
    }

    FileDownloadTask(@NonNull StorageReference storageReference, @NonNull Uri uri) {
        this.bbS = storageReference;
        this.bbV = uri;
        this.bbU = new zzamd(this.bbS.getStorage().getApp(), this.bbS.getStorage().getMaxDownloadRetryTimeMillis());
    }

    private boolean zzadw(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public StorageReference getStorage() {
        return this.bbS;
    }

    /* access modifiers changed from: 0000 */
    public long getTotalBytes() {
        return this.Go;
    }

    /* access modifiers changed from: protected */
    public void onCanceled() {
        this.bbU.cancel();
    }

    /* access modifiers changed from: 0000 */
    public void run() {
        FileOutputStream fileOutputStream;
        zzi(4, false);
        this.bbU.reset();
        try {
            zzamm zza = this.bbS.zzcyb().zza(this.bbS.zzcyc(), this.bbY);
            this.bbU.zza(zza, false);
            this.mResultCode = zza.getResultCode();
            this.aDS = zza.getException() != null ? zza.getException() : this.aDS;
            boolean z = zzadw(this.mResultCode) && this.aDS == null && zzcye() == 4;
            if (z) {
                this.Go = (long) zza.zzczb();
                String zzsu = zza.zzsu("ETag");
                if (TextUtils.isEmpty(zzsu) || this.bbX == null || this.bbX.equals(zzsu)) {
                    this.bbX = zzsu;
                    InputStream stream = zza.getStream();
                    if (stream != null) {
                        try {
                            File file = new File(this.bbV.getPath());
                            if (!file.exists()) {
                                if (this.bbY > 0) {
                                    String str = "FileDownloadTask";
                                    String str2 = "The file downloading to has been deleted:";
                                    String valueOf = String.valueOf(file.getAbsolutePath());
                                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                                    throw new IllegalStateException("expected a file to resume from.");
                                } else if (!file.createNewFile()) {
                                    String str3 = "FileDownloadTask";
                                    String str4 = "unable to create file:";
                                    String valueOf2 = String.valueOf(file.getAbsolutePath());
                                    Log.w(str3, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4));
                                }
                            }
                            if (this.bbY > 0) {
                                String str5 = "FileDownloadTask";
                                String str6 = "Resuming download file ";
                                String valueOf3 = String.valueOf(file.getAbsolutePath());
                                Log.d(str5, valueOf3.length() != 0 ? str6.concat(valueOf3) : new String(str6));
                                fileOutputStream = new FileOutputStream(file, true);
                            } else {
                                fileOutputStream = new FileOutputStream(file);
                            }
                            byte[] bArr = new byte[262144];
                            do {
                                int read = stream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                this.bbW += (long) read;
                            } while (zzi(4, false));
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            stream.close();
                        } catch (Exception e) {
                            Log.e("FileDownloadTask", "Exception occurred during file download", e);
                            this.aDS = e;
                        }
                    } else {
                        this.aDS = new IllegalStateException("Unable to open Firebase Storage stream.");
                    }
                } else {
                    Log.w("FileDownloadTask", "The file at the server has changed.  Restarting from the beginning.");
                    this.bbY = 0;
                    this.bbX = null;
                    zza.zzcyu();
                    schedule();
                    return;
                }
            }
            zza.zzcyu();
            if (z && this.aDS == null && zzcye() == 4) {
                zzi(128, false);
                return;
            }
            File file2 = new File(this.bbV.getPath());
            if (file2.exists()) {
                this.bbY = file2.length();
            } else {
                this.bbY = 0;
            }
            if (zzcye() == 8) {
                zzi(16, false);
                return;
            }
            if (!zzi(zzcye() == 32 ? 256 : 64, false)) {
                Log.w("FileDownloadTask", "Unable to change download task to final state from " + zzcye());
            }
        } catch (RemoteException e2) {
            Log.e("FileDownloadTask", "Unable to create firebase storage network request.", e2);
            this.aDS = e2;
            zzi(64, false);
        }
    }

    /* access modifiers changed from: protected */
    public void schedule() {
        zzd.zzcyj().zzu(zzcjq());
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    /* renamed from: zzcxx */
    public TaskSnapshot zzcxy() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.aDS, this.mResultCode), this.bbW);
    }
}
