package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.internal.zzagz.zza;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.connection.idl.ConnectionConfig;
import com.google.firebase.database.connection.idl.zzc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class zzagf implements zzahs {
    private final FirebaseApp aPM;
    /* access modifiers changed from: private */
    public final Context aPR;
    private final Set<String> aPS = new HashSet();

    public zzagf(FirebaseApp firebaseApp) {
        this.aPM = firebaseApp;
        if (this.aPM == null) {
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
        }
        this.aPR = this.aPM.getApplicationContext();
    }

    public zzagz zza(zzahk zzahk, zzagv zzagv, zzagx zzagx, zza zza) {
        return zzc.zza(this.aPR, new ConnectionConfig(zzagx, zzahk.zzcpl(), zzahk.zzcqg(), zzahk.zzcod(), FirebaseDatabase.getSdkVersion(), zzahk.zzsp()), zzagv, zza);
    }

    public zzahg zza(ScheduledExecutorService scheduledExecutorService) {
        return new zzagd(this.aPM, scheduledExecutorService);
    }

    public zzaho zza(zzahk zzahk) {
        return new zzage();
    }

    public zzaiv zza(zzahk zzahk, String str) {
        String zzcql = zzahk.zzcql();
        String sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(zzcql).length()).append(str).append("_").append(zzcql).toString();
        if (this.aPS.contains(sb)) {
            throw new DatabaseException(new StringBuilder(String.valueOf(zzcql).length() + 47).append("SessionPersistenceKey '").append(zzcql).append("' has already been used.").toString());
        }
        this.aPS.add(sb);
        return new zzais(zzahk, new zzagg(this.aPR, zzahk, sb), new zzait(zzahk.zzcqi()));
    }

    public zzajy zza(zzahk zzahk, zzajy.zza zza, List<String> list) {
        return new zzajv(zza, list);
    }

    public zzahw zzb(zzahk zzahk) {
        final zzajx zzrh = zzahk.zzrh("RunLoop");
        return new zzali() {
            public void zzh(final Throwable th) {
                String valueOf = String.valueOf(FirebaseDatabase.getSdkVersion());
                final String sb = new StringBuilder(String.valueOf(valueOf).length() + 80).append("Uncaught exception in Firebase runloop (").append(valueOf).append("). Please report to support@firebase.com").toString();
                zzrh.zze(sb, th);
                new Handler(zzagf.this.aPR.getMainLooper()).post(new Runnable() {
                    public void run() {
                        throw new RuntimeException(sb, th);
                    }
                });
            }
        };
    }

    public String zzc(zzahk zzahk) {
        return VERSION.SDK_INT + "/Android";
    }
}
