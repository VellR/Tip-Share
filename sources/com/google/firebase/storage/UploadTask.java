package com.google.firebase.storage;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzamd;
import com.google.android.gms.internal.zzami;
import com.google.android.gms.internal.zzaml;
import com.google.android.gms.internal.zzamm;
import com.google.firebase.storage.StorageMetadata.Builder;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadTask extends StorageTask<TaskSnapshot> {
    private volatile Exception aDS = null;
    private final byte[] aqV;
    /* access modifiers changed from: private */
    public final StorageReference bbS;
    private zzamd bbU;
    private volatile StorageMetadata bcx;
    private final byte[] bds = new byte[262144];
    private final long bdt;
    private final AtomicLong bdu = new AtomicLong(0);
    private InputStream bdv;
    private volatile Uri bdw = null;
    private volatile Exception bdx = null;
    private volatile String bdy;
    private volatile int mResultCode = 0;
    private final Uri mUri;

    public class TaskSnapshot extends SnapshotBase {
        private final StorageMetadata bcx;
        private final long bdB;
        private final Uri bdw;

        TaskSnapshot(Exception exc, long j, Uri uri, StorageMetadata storageMetadata) {
            super(exc);
            this.bdB = j;
            this.bdw = uri;
            this.bcx = storageMetadata;
        }

        public long getBytesTransferred() {
            return this.bdB;
        }

        @Nullable
        public Uri getDownloadUrl() {
            StorageMetadata metadata = getMetadata();
            if (metadata != null) {
                return metadata.getDownloadUrl();
            }
            return null;
        }

        @Nullable
        public /* bridge */ /* synthetic */ Exception getError() {
            return super.getError();
        }

        @Nullable
        public StorageMetadata getMetadata() {
            return this.bcx;
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
            return UploadTask.this.getTotalByteCount();
        }

        @Nullable
        public Uri getUploadSessionUri() {
            return this.bdw;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006f A[SYNTHETIC, Splitter:B:13:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c2 A[Catch:{ FileNotFoundException -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ce A[Catch:{ FileNotFoundException -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ea  */
    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, Uri uri, Uri uri2) {
        FileNotFoundException fileNotFoundException;
        InputStream inputStream;
        InputStream inputStream2;
        long j;
        long j2;
        InputStream inputStream3;
        long j3;
        long j4 = -1;
        zzab.zzaa(storageReference);
        zzab.zzaa(uri);
        this.aqV = null;
        this.bbS = storageReference;
        this.bcx = storageMetadata;
        this.mUri = uri;
        this.bbU = new zzamd(this.bbS.getApp(), this.bbS.getStorage().getMaxUploadRetryTimeMillis());
        try {
            ContentResolver contentResolver = this.bbS.getStorage().getApp().getApplicationContext().getContentResolver();
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(this.mUri, "r");
                if (openFileDescriptor != null) {
                    j3 = openFileDescriptor.getStatSize();
                    try {
                        openFileDescriptor.close();
                    } catch (NullPointerException e) {
                        Throwable th = e;
                        j2 = j3;
                        e = th;
                        try {
                            Log.w("UploadTask", "NullPointerException during file size calculation.", e);
                            inputStream = contentResolver.openInputStream(this.mUri);
                            if (inputStream != null) {
                            }
                            long j5 = j4;
                            inputStream2 = inputStream3;
                            j = j5;
                        } catch (FileNotFoundException e2) {
                            j4 = j2;
                            inputStream = null;
                            fileNotFoundException = e2;
                        }
                        this.bdt = j;
                        this.bdv = inputStream2;
                        this.bdw = uri2;
                    } catch (IOException e3) {
                        j4 = j3;
                        String str = "UploadTask";
                        String str2 = "could not retrieve file size for upload ";
                        String valueOf = String.valueOf(this.mUri.toString());
                        Log.w(str, valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                        inputStream = contentResolver.openInputStream(this.mUri);
                        if (inputStream != null) {
                        }
                        long j52 = j4;
                        inputStream2 = inputStream3;
                        j = j52;
                        this.bdt = j;
                        this.bdv = inputStream2;
                        this.bdw = uri2;
                    } catch (FileNotFoundException e4) {
                        fileNotFoundException = e4;
                        j4 = j3;
                        inputStream = null;
                        String str3 = "UploadTask";
                        String str4 = "could not locate file for uploading:";
                        String valueOf2 = String.valueOf(this.mUri.toString());
                        Log.e(str3, valueOf2.length() == 0 ? str4.concat(valueOf2) : new String(str4));
                        this.aDS = fileNotFoundException;
                        long j6 = j4;
                        inputStream2 = inputStream;
                        j = j6;
                        this.bdt = j;
                        this.bdv = inputStream2;
                        this.bdw = uri2;
                    }
                } else {
                    j3 = -1;
                }
                j4 = j3;
            } catch (NullPointerException e5) {
                e = e5;
                j2 = -1;
                Log.w("UploadTask", "NullPointerException during file size calculation.", e);
                inputStream = contentResolver.openInputStream(this.mUri);
                if (inputStream != null) {
                }
                long j522 = j4;
                inputStream2 = inputStream3;
                j = j522;
                this.bdt = j;
                this.bdv = inputStream2;
                this.bdw = uri2;
            } catch (IOException e6) {
                String str5 = "UploadTask";
                String str22 = "could not retrieve file size for upload ";
                String valueOf3 = String.valueOf(this.mUri.toString());
                Log.w(str5, valueOf3.length() == 0 ? str22.concat(valueOf3) : new String(str22));
                inputStream = contentResolver.openInputStream(this.mUri);
                if (inputStream != null) {
                }
                long j5222 = j4;
                inputStream2 = inputStream3;
                j = j5222;
                this.bdt = j;
                this.bdv = inputStream2;
                this.bdw = uri2;
            }
            inputStream = contentResolver.openInputStream(this.mUri);
            if (inputStream != null) {
                try {
                    inputStream3 = new BufferedInputStream(inputStream);
                } catch (FileNotFoundException e7) {
                    fileNotFoundException = e7;
                    String str32 = "UploadTask";
                    String str42 = "could not locate file for uploading:";
                    String valueOf22 = String.valueOf(this.mUri.toString());
                    Log.e(str32, valueOf22.length() == 0 ? str42.concat(valueOf22) : new String(str42));
                    this.aDS = fileNotFoundException;
                    long j62 = j4;
                    inputStream2 = inputStream;
                    j = j62;
                    this.bdt = j;
                    this.bdv = inputStream2;
                    this.bdw = uri2;
                }
            } else {
                inputStream3 = inputStream;
            }
            long j52222 = j4;
            inputStream2 = inputStream3;
            j = j52222;
        } catch (FileNotFoundException e8) {
            fileNotFoundException = e8;
            inputStream = null;
        }
        this.bdt = j;
        this.bdv = inputStream2;
        this.bdw = uri2;
    }

    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, InputStream inputStream) {
        zzab.zzaa(storageReference);
        zzab.zzaa(inputStream);
        this.bdt = -1;
        this.aqV = null;
        this.bbS = storageReference;
        this.bcx = storageMetadata;
        this.bdv = new BufferedInputStream(inputStream, 262144);
        this.mUri = null;
        this.bbU = new zzamd(this.bbS.getApp(), this.bbS.getStorage().getMaxUploadRetryTimeMillis());
    }

    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, byte[] bArr) {
        zzab.zzaa(storageReference);
        zzab.zzaa(bArr);
        this.aqV = bArr;
        this.bdt = (long) this.aqV.length;
        this.bbS = storageReference;
        this.bcx = storageMetadata;
        this.mUri = null;
        this.bdv = new BufferedInputStream(new ByteArrayInputStream(this.aqV), 262144);
        this.bbU = new zzamd(this.bbS.getApp(), this.bbS.getStorage().getMaxUploadRetryTimeMillis());
    }

    private boolean zza(zzamm zzamm) {
        zzamm.zza(zzami.zzh(this.bbS.getApp()), this.bbS.getApp().getApplicationContext());
        return zzc(zzamm);
    }

    private boolean zzadw(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    private boolean zzb(zzamm zzamm) {
        this.bbU.zzd(zzamm);
        return zzc(zzamm);
    }

    private boolean zzc(zzamm zzamm) {
        int resultCode = zzamm.getResultCode();
        if (this.bbU.zzaea(resultCode)) {
            resultCode = -2;
        }
        this.mResultCode = resultCode;
        this.bdx = zzamm.getException();
        this.bdy = zzamm.zzsu("X-Goog-Upload-Status");
        return zzadw(this.mResultCode) && this.bdx == null;
    }

    private boolean zzcw(boolean z) {
        try {
            zzamm zzb = this.bbS.zzcyb().zzb(this.bbS.zzcyc(), this.bdw.toString());
            if ("final".equals(this.bdy)) {
                return false;
            }
            if (z) {
                if (!zzb(zzb)) {
                    return false;
                }
            } else if (!zza(zzb)) {
                return false;
            }
            if ("final".equals(zzb.zzsu("X-Goog-Upload-Status"))) {
                this.aDS = new IOException("The server has terminated the upload session");
                return false;
            }
            String zzsu = zzb.zzsu("X-Goog-Upload-Size-Received");
            long j = !TextUtils.isEmpty(zzsu) ? Long.parseLong(zzsu) : 0;
            long j2 = this.bdu.get();
            if (j2 > j) {
                this.aDS = new IOException("Unexpected error. The server lost a chunk update.");
                return false;
            }
            if (j2 < j) {
                try {
                    if (this.bdv.skip(j - j2) != j - j2) {
                        this.aDS = new IOException("Unexpected end of stream encountered.");
                        return false;
                    } else if (!this.bdu.compareAndSet(j2, j)) {
                        Log.e("UploadTask", "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
                        this.aDS = new IllegalStateException("uploaded bytes changed unexpectedly.");
                        return false;
                    }
                } catch (IOException e) {
                    Log.e("UploadTask", "Unable to recover position in Stream during resumable upload", e);
                    this.aDS = e;
                    return false;
                }
            }
            return true;
        } catch (RemoteException e2) {
            Log.e("UploadTask", "Unable to recover status during resumable upload", e2);
            this.aDS = e2;
            return false;
        }
    }

    private void zzcyn() {
        JSONObject jSONObject = null;
        String str = this.bcx != null ? this.bcx.getContentType() : null;
        if (this.mUri != null && TextUtils.isEmpty(str)) {
            str = this.bbS.getStorage().getApp().getApplicationContext().getContentResolver().getType(this.mUri);
        }
        if (TextUtils.isEmpty(str)) {
            str = "application/octet-stream";
        }
        try {
            zzaml zzcyb = this.bbS.zzcyb();
            Uri zzcyc = this.bbS.zzcyc();
            if (this.bcx != null) {
                jSONObject = this.bcx.zzcya();
            }
            zzamm zza = zzcyb.zza(zzcyc, jSONObject, str);
            if (zzb(zza)) {
                String zzsu = zza.zzsu("X-Goog-Upload-URL");
                if (!TextUtils.isEmpty(zzsu)) {
                    this.bdw = Uri.parse(zzsu);
                }
            }
        } catch (RemoteException | JSONException e) {
            Log.e("UploadTask", "Unable to create a network request from metadata", e);
            this.aDS = e;
        }
    }

    private boolean zzcyo() {
        if (zzcye() == 128) {
            return false;
        }
        if (Thread.interrupted()) {
            this.aDS = new InterruptedException();
            zzi(64, false);
            return false;
        } else if (zzcye() == 32) {
            zzi(256, false);
            return false;
        } else if (zzcye() == 8) {
            zzi(16, false);
            return false;
        } else if (!zzcyp()) {
            return false;
        } else {
            if (this.bdw == null) {
                if (this.aDS == null) {
                    this.aDS = new IllegalStateException("Unable to obtain an upload URL.");
                }
                zzi(64, false);
                return false;
            } else if (this.aDS != null) {
                zzi(64, false);
                return false;
            } else {
                if (!(this.bdx != null || this.mResultCode < 200 || this.mResultCode >= 300) || zzcw(true)) {
                    return true;
                }
                if (!zzcyp()) {
                    return false;
                }
                zzi(64, false);
                return false;
            }
        }
    }

    private boolean zzcyp() {
        if (!"final".equals(this.bdy)) {
            return true;
        }
        if (this.aDS == null) {
            this.aDS = new IOException("The server has terminated the upload session");
        }
        zzi(64, false);
        return false;
    }

    private void zzcyq() {
        this.bdv.mark(this.bds.length + 1);
        try {
            int read = this.bdv.read(this.bds);
            try {
                zzamm zza = this.bbS.zzcyb().zza(this.bbS.zzcyc(), this.bdw.toString(), this.bds, this.bdu.get(), read, ((long) read) != 262144);
                if (!zza(zza)) {
                    try {
                        this.bdv.reset();
                    } catch (IOException e) {
                        Log.w("UploadTask", "Unable to reset the stream for error recovery.", e);
                        this.aDS = e;
                    }
                } else {
                    if (read != -1) {
                        this.bdu.getAndAdd((long) read);
                    }
                    if (((long) read) != 262144) {
                        try {
                            this.bcx = new Builder(zza.zzczd(), this.bbS).build();
                            zzi(4, false);
                            zzi(128, false);
                        } catch (RemoteException | JSONException e2) {
                            String str = "UploadTask";
                            String str2 = "Unable to parse resulting metadata from upload:";
                            String valueOf = String.valueOf(zza.zzcyx());
                            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e2);
                            this.aDS = e2;
                        }
                    }
                }
            } catch (RemoteException e3) {
                Log.e("UploadTask", "Unable to create chunk upload request", e3);
                this.aDS = e3;
            }
        } catch (IOException e4) {
            Log.e("UploadTask", "Unable to read bytes for uploading", e4);
            this.aDS = e4;
        }
    }

    /* access modifiers changed from: 0000 */
    public StorageReference getStorage() {
        return this.bbS;
    }

    /* access modifiers changed from: 0000 */
    public long getTotalByteCount() {
        return this.bdt;
    }

    /* access modifiers changed from: protected */
    public void onCanceled() {
        final zzamm zzamm;
        this.bbU.cancel();
        try {
            zzamm = this.bbS.zzcyb().zza(this.bbS.zzcyc(), this.bdw.toString());
        } catch (RemoteException e) {
            Log.e("UploadTask", "Unable to create chunk upload request", e);
            zzamm = null;
        }
        if (zzamm != null) {
            zzd.zzcyj().zzs(new Runnable() {
                public void run() {
                    zzamm.zza(zzami.zzh(UploadTask.this.bbS.getApp()), UploadTask.this.bbS.getApp().getApplicationContext());
                }
            });
        }
        this.aDS = StorageException.fromErrorStatus(Status.sk);
        super.onCanceled();
    }

    /* access modifiers changed from: protected */
    public void resetState() {
        this.aDS = null;
        this.bdx = null;
        this.mResultCode = 0;
        this.bdy = null;
    }

    /* access modifiers changed from: 0000 */
    public void run() {
        this.bbU.reset();
        if (this.bbS.getParent() == null) {
            this.aDS = new IllegalArgumentException("Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile...");
        }
        if (this.aDS != null) {
            zzi(64, false);
            return;
        }
        if (this.bdw == null) {
            zzcyn();
        } else {
            zzcw(false);
        }
        while (zzcyo()) {
            zzi(4, false);
            zzcyq();
        }
    }

    /* access modifiers changed from: protected */
    public void schedule() {
        zzd.zzcyj().zzt(zzcjq());
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    /* renamed from: zzcyr */
    public TaskSnapshot zzcxy() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.aDS != null ? this.aDS : this.bdx, this.mResultCode), this.bdu.get(), this.bdw, this.bcx);
    }
}
