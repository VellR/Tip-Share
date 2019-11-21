package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzamk.zza;
import com.google.firebase.FirebaseApp;
import org.json.JSONObject;

public class zzaml {
    private static final Object bdI = new Object();
    private static volatile zzaml bdJ;
    private zzamk bdK;
    private Context mContext;

    private zzaml(@NonNull Context context) throws RemoteException {
        this.mContext = context;
        try {
            this.bdK = zza.zzlw(zzsj.zza(context, zzsj.Mg, "com.google.android.gms.firebasestorage").zziv("com.google.firebase.storage.network.NetworkRequestFactoryImpl"));
            if (this.bdK == null) {
                Log.e("NetworkRqFactoryProxy", "Unable to load Firebase Storage Network layer.");
                throw new RemoteException();
            }
        } catch (zzsj.zza e) {
            Log.e("NetworkRqFactoryProxy", "NetworkRequestFactoryProxy failed with a RemoteException:", e);
            throw new RemoteException();
        }
    }

    public static zzaml zzi(@NonNull FirebaseApp firebaseApp) throws RemoteException {
        if (bdJ == null) {
            synchronized (bdI) {
                if (bdJ == null) {
                    bdJ = new zzaml(firebaseApp.getApplicationContext());
                }
            }
        }
        return bdJ;
    }

    @NonNull
    public zzamm zza(Uri uri, long j) throws RemoteException {
        return new zzamm(this.bdK.zza(uri, zze.zzae(this.mContext), j));
    }

    @NonNull
    public zzamm zza(Uri uri, String str) throws RemoteException {
        return new zzamm(this.bdK.zzb(uri, zze.zzae(this.mContext), str));
    }

    @NonNull
    public zzamm zza(Uri uri, String str, byte[] bArr, long j, int i, boolean z) throws RemoteException {
        return new zzamm(this.bdK.zza(uri, zze.zzae(this.mContext), str, zze.zzae(bArr), j, i, z));
    }

    @NonNull
    public zzamm zza(Uri uri, JSONObject jSONObject) throws RemoteException {
        return new zzamm(this.bdK.zza(uri, zze.zzae(this.mContext), zze.zzae(jSONObject)));
    }

    @NonNull
    public zzamm zza(Uri uri, JSONObject jSONObject, String str) throws RemoteException {
        return new zzamm(this.bdK.zza(uri, zze.zzae(this.mContext), zze.zzae(jSONObject), str));
    }

    @NonNull
    public zzamm zzaa(Uri uri) throws RemoteException {
        return new zzamm(this.bdK.zza(uri, zze.zzae(this.mContext)));
    }

    @NonNull
    public zzamm zzab(Uri uri) throws RemoteException {
        return new zzamm(this.bdK.zzb(uri, zze.zzae(this.mContext)));
    }

    @NonNull
    public zzamm zzb(Uri uri, String str) throws RemoteException {
        return new zzamm(this.bdK.zzc(uri, zze.zzae(this.mContext), str));
    }

    @Nullable
    public String zzczc() {
        try {
            return this.bdK.zzczc();
        } catch (RemoteException e) {
            Log.e("NetworkRqFactoryProxy", "getBackendAuthority failed with a RemoteException:", e);
            return null;
        }
    }

    @Nullable
    public String zzy(Uri uri) {
        try {
            return this.bdK.zzy(uri);
        } catch (RemoteException e) {
            Log.e("NetworkRqFactoryProxy", "getDefaultURL failed with a RemoteException:", e);
            return null;
        }
    }
}
