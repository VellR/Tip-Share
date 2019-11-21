package com.google.android.gms.internal;

import com.google.android.gms.internal.zzagz.zza;
import com.google.firebase.database.FirebaseDatabase;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

enum zzahq implements zzahs {
    INSTANCE;

    public zzagz zza(zzahk zzahk, zzagv zzagv, zzagx zzagx, zza zza) {
        return new zzaha(zzahk.zzcqh(), zzagx, zza);
    }

    public zzahg zza(ScheduledExecutorService scheduledExecutorService) {
        throw new RuntimeException("Authentication is not implemented yet");
    }

    public zzaho zza(zzahk zzahk) {
        return new zzaie(Executors.defaultThreadFactory(), zzaid.aVO);
    }

    public zzaiv zza(zzahk zzahk, String str) {
        return null;
    }

    public zzajy zza(zzahk zzahk, zzajy.zza zza, List<String> list) {
        return new zzajw(zza, list);
    }

    public zzahw zzb(zzahk zzahk) {
        final zzajx zzrh = zzahk.zzrh("RunLoop");
        return new zzali() {
            public void zzh(Throwable th) {
                zzajx zzajx = zzrh;
                String valueOf = String.valueOf(FirebaseDatabase.getSdkVersion());
                zzajx.zze(new StringBuilder(String.valueOf(valueOf).length() + 89).append("Uncaught exception in Firebase Database runloop (").append(valueOf).append("). Please report to support@firebase.com").toString(), th);
            }
        };
    }

    public String zzc(zzahk zzahk) {
        String property = System.getProperty("java.vm.name", "Unknown JVM");
        String property2 = System.getProperty("java.specification.version", "Unknown");
        return new StringBuilder(String.valueOf(property2).length() + 1 + String.valueOf(property).length()).append(property2).append("/").append(property).toString();
    }
}
