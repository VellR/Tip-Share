package com.google.firebase.storage;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzami;
import com.google.firebase.FirebaseApp;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class FirebaseStorage {
    static final /* synthetic */ boolean $assertionsDisabled = (!FirebaseStorage.class.desiredAssertionStatus());
    private static final Map<FirebaseApp, FirebaseStorage> bca = new HashMap();
    private final FirebaseApp baF;
    private long bcb = 600000;
    private long bcc = 600000;
    private long bcd = 120000;

    private FirebaseStorage(@NonNull FirebaseApp firebaseApp) {
        this.baF = firebaseApp;
    }

    @NonNull
    public static FirebaseStorage getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        zzab.zzb(instance != null, (Object) "You must call FirebaseApp.initialize() first.");
        if ($assertionsDisabled || instance != null) {
            return getInstance(instance);
        }
        throw new AssertionError();
    }

    @NonNull
    public static FirebaseStorage getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseStorage firebaseStorage;
        zzab.zzb(firebaseApp != null, (Object) "Null is not a valid value for the FirebaseApp.");
        synchronized (bca) {
            firebaseStorage = (FirebaseStorage) bca.get(firebaseApp);
            if (firebaseStorage == null) {
                firebaseStorage = new FirebaseStorage(firebaseApp);
                bca.put(firebaseApp, firebaseStorage);
            }
        }
        return firebaseStorage;
    }

    @Nullable
    private String zzcxz() {
        return this.baF.getOptions().getStorageBucket();
    }

    @NonNull
    private StorageReference zzx(@NonNull Uri uri) {
        zzab.zzb(uri, (Object) "uri must not be null");
        String zzcxz = zzcxz();
        zzab.zzb(TextUtils.isEmpty(zzcxz) || uri.getAuthority().equalsIgnoreCase(zzcxz), (Object) "The supplied bucketname is not available to this project.");
        return new StorageReference(uri, this);
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.baF;
    }

    public long getMaxDownloadRetryTimeMillis() {
        return this.bcc;
    }

    public long getMaxOperationRetryTimeMillis() {
        return this.bcd;
    }

    public long getMaxUploadRetryTimeMillis() {
        return this.bcb;
    }

    @NonNull
    public StorageReference getReference() {
        if (!TextUtils.isEmpty(zzcxz())) {
            return zzx(new Builder().scheme("gs").authority(zzcxz()).path("/").build());
        }
        throw new IllegalStateException("FirebaseApp was not initialized with a bucket name.");
    }

    @NonNull
    public StorageReference getReference(@NonNull String str) {
        zzab.zzb(!TextUtils.isEmpty(str), (Object) "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("gs://") && !lowerCase.startsWith("https://") && !lowerCase.startsWith("http://")) {
            return getReference().child(str);
        }
        throw new IllegalArgumentException("location should not be a full URL.");
    }

    @NonNull
    public StorageReference getReferenceFromUrl(@NonNull String str) {
        zzab.zzb(!TextUtils.isEmpty(str), (Object) "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("gs://") || lowerCase.startsWith("https://") || lowerCase.startsWith("http://")) {
            try {
                Uri zzc = zzami.zzc(this.baF, str);
                if (zzc != null) {
                    return zzx(zzc);
                }
                throw new IllegalArgumentException("The storage Uri could not be parsed.");
            } catch (UnsupportedEncodingException e) {
                UnsupportedEncodingException unsupportedEncodingException = e;
                String str2 = "FirebaseStorage";
                String str3 = "Unable to parse location:";
                String valueOf = String.valueOf(str);
                Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), unsupportedEncodingException);
                throw new IllegalArgumentException("The storage Uri could not be parsed.");
            }
        } else {
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    public void setMaxDownloadRetryTimeMillis(long j) {
        this.bcc = j;
    }

    public void setMaxOperationRetryTimeMillis(long j) {
        this.bcd = j;
    }

    public void setMaxUploadRetryTimeMillis(long j) {
        this.bcb = j;
    }
}
