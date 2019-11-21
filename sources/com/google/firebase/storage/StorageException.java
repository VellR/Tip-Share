package com.google.firebase.storage;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.FirebaseException;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class StorageException extends FirebaseException {
    static final /* synthetic */ boolean $assertionsDisabled = (!StorageException.class.desiredAssertionStatus());
    public static final int ERROR_BUCKET_NOT_FOUND = -13011;
    public static final int ERROR_CANCELED = -13040;
    public static final int ERROR_INVALID_CHECKSUM = -13031;
    public static final int ERROR_NOT_AUTHENTICATED = -13020;
    public static final int ERROR_NOT_AUTHORIZED = -13021;
    public static final int ERROR_OBJECT_NOT_FOUND = -13010;
    public static final int ERROR_PROJECT_NOT_FOUND = -13012;
    public static final int ERROR_QUOTA_EXCEEDED = -13013;
    public static final int ERROR_RETRY_LIMIT_EXCEEDED = -13030;
    public static final int ERROR_UNKNOWN = -13000;
    static IOException bcf = new IOException("The operation was canceled.");
    private final int bcg;
    private String bch;
    private Throwable bci;
    private final int zzbym;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    StorageException(int i, Throwable th, int i2) {
        this.bch = zzady(i);
        this.bci = th;
        this.zzbym = i;
        this.bcg = i2;
        String str = this.bch;
        String valueOf = String.valueOf(Integer.toString(this.zzbym));
        String valueOf2 = String.valueOf(Integer.toString(this.bcg));
        Log.e("StorageException", new StringBuilder(String.valueOf(str).length() + 52 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length()).append("StorageException has occurred.\n").append(str).append("\n Code: ").append(valueOf).append(" HttpResult: ").append(valueOf2).toString());
        if (this.bci != null) {
            Log.e("StorageException", this.bci.getMessage(), this.bci);
        }
    }

    StorageException(Status status) {
        this(zzeu(status), null, 0);
    }

    StorageException(@Nullable Throwable th, int i) {
        this(zza(th, i), th, i);
    }

    @NonNull
    public static StorageException fromErrorStatus(@NonNull Status status) {
        zzab.zzaa(status);
        zzab.zzbn(!status.isSuccess());
        return new StorageException(status);
    }

    @NonNull
    public static StorageException fromException(@NonNull Throwable th) {
        StorageException fromExceptionAndHttpCode = fromExceptionAndHttpCode(th, 0);
        if ($assertionsDisabled || fromExceptionAndHttpCode != null) {
            return fromExceptionAndHttpCode;
        }
        throw new AssertionError();
    }

    @Nullable
    public static StorageException fromExceptionAndHttpCode(@Nullable Throwable th, int i) {
        if (th instanceof StorageException) {
            return (StorageException) th;
        }
        if (!zzadx(i) || th != null) {
            return new StorageException(th, i);
        }
        return null;
    }

    private static int zza(@Nullable Throwable th, int i) {
        if (th == bcf) {
            return ERROR_CANCELED;
        }
        switch (i) {
            case -2:
                return ERROR_RETRY_LIMIT_EXCEEDED;
            case 401:
                return ERROR_NOT_AUTHENTICATED;
            case 403:
                return ERROR_NOT_AUTHORIZED;
            case 404:
                return ERROR_OBJECT_NOT_FOUND;
            default:
                return ERROR_UNKNOWN;
        }
    }

    private static boolean zzadx(int i) {
        return i == 0 || (i >= 200 && i < 300);
    }

    static String zzady(int i) {
        switch (i) {
            case ERROR_CANCELED /*-13040*/:
                return "The operation was cancelled.";
            case ERROR_INVALID_CHECKSUM /*-13031*/:
                return "Object has a checksum which does not match. Please retry the operation.";
            case ERROR_RETRY_LIMIT_EXCEEDED /*-13030*/:
                return "The operation retry limit has been exceeded.";
            case ERROR_NOT_AUTHORIZED /*-13021*/:
                return "User does not have permission to access this object.";
            case ERROR_NOT_AUTHENTICATED /*-13020*/:
                return "User is not authenticated, please authenticate using Firebase Authentication and try again.";
            case ERROR_QUOTA_EXCEEDED /*-13013*/:
                return "Quota for bucket exceeded, please view quota on www.firebase.google.com/storage.";
            case ERROR_PROJECT_NOT_FOUND /*-13012*/:
                return "Project does not exist.";
            case ERROR_BUCKET_NOT_FOUND /*-13011*/:
                return "Bucket does not exist.";
            case ERROR_OBJECT_NOT_FOUND /*-13010*/:
                return "Object does not exist at location.";
            case ERROR_UNKNOWN /*-13000*/:
                return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
            default:
                return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
        }
    }

    private static int zzeu(Status status) {
        return status.isCanceled() ? ERROR_CANCELED : status == Status.sj ? ERROR_RETRY_LIMIT_EXCEEDED : ERROR_UNKNOWN;
    }

    public Throwable getCause() {
        if (this.bci == this) {
            return null;
        }
        return this.bci;
    }

    public int getErrorCode() {
        return this.zzbym;
    }

    public int getHttpResultCode() {
        return this.bcg;
    }

    public boolean getIsRecoverableException() {
        return getErrorCode() == -13030;
    }

    public String getMessage() {
        return this.bch;
    }
}
