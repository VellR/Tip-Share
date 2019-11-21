package com.google.firebase.storage;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzamd;
import com.google.android.gms.internal.zzamm;
import java.io.IOException;
import java.io.InputStream;

public class StreamDownloadTask extends StorageTask<TaskSnapshot> {
    private long Go;
    private volatile Exception aDS = null;
    /* access modifiers changed from: private */
    public InputStream aKk;
    private StorageReference bbS;
    private zzamd bbU;
    private long bbW;
    private StreamProcessor bdb;
    private long bdc;
    /* access modifiers changed from: private */
    public zzamm bdd;
    private volatile int mResultCode = 0;

    public interface StreamProcessor {
        void doInBackground(TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException;
    }

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

        public InputStream getStream() {
            return StreamDownloadTask.this.aKk;
        }

        @NonNull
        public /* bridge */ /* synthetic */ StorageTask getTask() {
            return super.getTask();
        }

        public long getTotalByteCount() {
            return StreamDownloadTask.this.getTotalBytes();
        }
    }

    private static class zza extends InputStream {
        private StreamDownloadTask bde;
        private InputStream bdf;
        private int bdg;

        public zza(@NonNull StreamDownloadTask streamDownloadTask, @NonNull InputStream inputStream) {
            this.bde = streamDownloadTask;
            this.bdf = inputStream;
        }

        private void zzcyl() throws IOException {
            if (this.bde.zzcye() == 32) {
                throw StorageException.bcf;
            }
        }

        public int available() throws IOException {
            zzcyl();
            return this.bdf.available();
        }

        public void close() throws IOException {
            this.bdf.close();
            if (this.bde.bdd != null) {
                this.bde.bdd.zzcyu();
            }
            zzcyl();
        }

        public void mark(int i) {
            this.bdg = i;
            this.bdf.mark(i);
        }

        public boolean markSupported() {
            return this.bdf.markSupported();
        }

        public int read() throws IOException {
            zzcyl();
            int read = this.bdf.read();
            if (read != -1) {
                this.bde.zzco(1);
            }
            return read;
        }

        public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
            zzcyl();
            int i3 = 0;
            int i4 = i2;
            int i5 = i;
            while (((long) i4) > 262144) {
                int read = this.bdf.read(bArr, i5, 262144);
                if (read != -1) {
                    i3 += read;
                    i5 += read;
                    i4 -= read;
                    this.bde.zzco((long) read);
                    zzcyl();
                    if (((long) read) < 262144) {
                        break;
                    }
                } else if (i3 == 0) {
                    return -1;
                } else {
                    return i3;
                }
            }
            if (i4 > 0) {
                int read2 = this.bdf.read(bArr, i5, i4);
                if (read2 != -1) {
                    i3 += read2;
                    this.bde.zzco((long) read2);
                } else if (i3 != 0) {
                    return i3;
                } else {
                    return -1;
                }
            }
            return i3;
        }

        public synchronized void reset() throws IOException {
            zzcyl();
            this.bde.zzco((long) (-this.bdg));
            this.bdf.reset();
        }

        public long skip(long j) throws IOException {
            zzcyl();
            int i = 0;
            while (j > 262144) {
                long skip = this.bdf.skip(262144);
                i = (int) (((long) i) + skip);
                if (skip < 262144) {
                    this.bde.zzco(skip);
                    return (long) i;
                }
                this.bde.zzco(262144);
                j -= 262144;
                zzcyl();
            }
            long skip2 = this.bdf.skip(j);
            int i2 = (int) (((long) i) + skip2);
            this.bde.zzco(skip2);
            return (long) i2;
        }
    }

    StreamDownloadTask(@NonNull StorageReference storageReference) {
        this.bbS = storageReference;
        this.bbU = new zzamd(this.bbS.getApp(), this.bbS.getStorage().getMaxDownloadRetryTimeMillis());
    }

    private boolean zzadw(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    /* access modifiers changed from: private */
    public void zzco(long j) {
        this.bbW += j;
        if (this.bdc + 262144 <= this.bbW) {
            zzi(4, false);
        }
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

    /* access modifiers changed from: protected */
    public void onProgress() {
        this.bdc = this.bbW;
    }

    public boolean pause() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    public boolean resume() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    /* access modifiers changed from: 0000 */
    public void run() {
        this.bbU.reset();
        if (this.aDS != null) {
            zzi(64, false);
        } else if (zzi(4, false)) {
            try {
                this.bdd = this.bbS.zzcyb().zza(this.bbS.zzcyc(), 0);
                this.bbU.zza(this.bdd, false);
                this.mResultCode = this.bdd.getResultCode();
                this.aDS = this.bdd.getException() != null ? this.bdd.getException() : this.aDS;
                boolean z = zzadw(this.mResultCode) && this.aDS == null && zzcye() == 4;
                if (z) {
                    this.Go = (long) this.bdd.zzczb();
                    InputStream stream = this.bdd.getStream();
                    if (stream != null) {
                        this.aKk = new zza(this, stream);
                        if (this.bdb != null) {
                            try {
                                this.bdb.doInBackground((TaskSnapshot) zzcyg(), this.aKk);
                            } catch (Exception e) {
                                Log.w("StreamDownloadTask", "Exception occurred calling doInBackground.", e);
                                this.aDS = e;
                            }
                        }
                    } else {
                        this.aDS = new IOException("Could not open resulting stream.");
                    }
                }
                if (this.aKk == null) {
                    this.bdd.zzcyu();
                }
                if (z && this.aDS == null && zzcye() == 4) {
                    zzi(4, false);
                    zzi(128, false);
                    return;
                }
                if (!zzi(zzcye() == 32 ? 256 : 64, false)) {
                    Log.w("StreamDownloadTask", "Unable to change download task to final state from " + zzcye());
                }
            } catch (RemoteException e2) {
                Log.e("StreamDownloadTask", "Unable to create firebase storage network request.", e2);
                this.aDS = e2;
                zzi(64, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void schedule() {
        zzd.zzcyj().zzu(zzcjq());
    }

    /* access modifiers changed from: 0000 */
    public StreamDownloadTask zza(@NonNull StreamProcessor streamProcessor) {
        zzab.zzaa(streamProcessor);
        zzab.zzbm(this.bdb == null);
        this.bdb = streamProcessor;
        return this;
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    /* renamed from: zzcyk */
    public TaskSnapshot zzcxy() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.aDS, this.mResultCode), this.bdc);
    }
}
