package com.google.android.gms.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageException;
import java.io.InputStream;
import java.net.SocketException;
import org.json.JSONObject;

public class zzamm {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzamm.class.desiredAssertionStatus());
    private Exception aDS;
    private zzamj bdL;
    private int bdM;
    private Exception bdN;

    public zzamm(@NonNull zzamj zzamj) {
        this.bdL = zzamj;
    }

    private boolean zzet(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        this.bdM = -2;
        this.bdN = new SocketException("Network subsystem is unavailable");
        return false;
    }

    @Nullable
    public Exception getException() {
        try {
            return this.bdN != null ? this.bdN : this.aDS != null ? this.aDS : (Exception) zze.zzad(this.bdL.zzcyz());
        } catch (RemoteException e) {
            this.aDS = e;
            Log.e("NetworkRequestProxy", "getException failed with a RemoteException:", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.bdM != 0 ? this.bdM : this.bdL.getResultCode();
        } catch (RemoteException e) {
            this.aDS = e;
            Log.e("NetworkRequestProxy", "getResultCode failed with a RemoteException:", e);
            return 0;
        }
    }

    @Nullable
    public InputStream getStream() {
        try {
            return (InputStream) zze.zzad(this.bdL.zzcyv());
        } catch (RemoteException e) {
            this.aDS = e;
            Log.e("NetworkRequestProxy", "getStream failed with a RemoteException:", e);
            return null;
        }
    }

    public void reset() {
        try {
            this.bdM = 0;
            this.bdN = null;
            this.bdL.reset();
        } catch (RemoteException e) {
            this.aDS = e;
            Log.e("NetworkRequestProxy", "reset failed with a RemoteException:", e);
        }
    }

    public <TResult> void zza(TaskCompletionSource<TResult> taskCompletionSource, TResult tresult) {
        Exception exception = getException();
        if (!zzcza() || exception != null) {
            StorageException fromExceptionAndHttpCode = StorageException.fromExceptionAndHttpCode(exception, getResultCode());
            if ($assertionsDisabled || fromExceptionAndHttpCode != null) {
                taskCompletionSource.setException(fromExceptionAndHttpCode);
                return;
            }
            throw new AssertionError();
        }
        taskCompletionSource.setResult(tresult);
    }

    public void zza(@Nullable String str, @NonNull Context context) {
        try {
            if (zzet(context)) {
                this.bdL.zzss(str);
            }
        } catch (RemoteException e) {
            this.aDS = e;
            Log.e("NetworkRequestProxy", "performRequest failed with a RemoteException:", e);
        }
    }

    public void zzcyu() {
        try {
            this.bdL.zzcyu();
        } catch (RemoteException e) {
            this.aDS = e;
            Log.e("NetworkRequestProxy", "performRequestEnd failed with a RemoteException:", e);
        }
    }

    @Nullable
    public String zzcyx() {
        try {
            this.bdL.zzcyx();
        } catch (RemoteException e) {
            this.aDS = e;
            Log.e("NetworkRequestProxy", "getRawResult failed with a RemoteException:", e);
        }
        return null;
    }

    public boolean zzcza() {
        try {
            if (this.bdM == -2 || this.bdN != null) {
                return false;
            }
            return this.bdL.zzcza();
        } catch (RemoteException e) {
            this.aDS = e;
            Log.e("NetworkRequestProxy", "isResultSuccess failed with a RemoteException:", e);
            return false;
        }
    }

    public int zzczb() {
        try {
            return this.bdL.zzczb();
        } catch (RemoteException e) {
            this.aDS = e;
            Log.e("NetworkRequestProxy", "getResultingContentLength failed with a RemoteException:", e);
            return 0;
        }
    }

    @NonNull
    public JSONObject zzczd() throws RemoteException {
        return (JSONObject) zze.zzad(this.bdL.zzcyw());
    }

    public void zzst(@Nullable String str) {
        try {
            this.bdL.zzst(str);
        } catch (RemoteException e) {
            this.aDS = e;
            Log.e("NetworkRequestProxy", "performRequestStart failed with a RemoteException:", e);
        }
    }

    @Nullable
    public String zzsu(String str) {
        try {
            return this.bdL.zzsu(str);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            String str2 = "NetworkRequestProxy";
            String str3 = "getResultString failed with a RemoteException:";
            String valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), remoteException);
            return null;
        }
    }
}
