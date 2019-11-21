package com.google.android.gms.internal;

import com.google.android.gms.internal.zzajy.zza;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.Logger.Level;

public class zzahl extends zzahk {
    public synchronized void setLogLevel(Level level) {
        zzcqf();
        switch (level) {
            case DEBUG:
                this.aTv = zza.DEBUG;
                break;
            case INFO:
                this.aTv = zza.INFO;
                break;
            case WARN:
                this.aTv = zza.WARN;
                break;
            case ERROR:
                this.aTv = zza.ERROR;
                break;
            case NONE:
                this.aTv = zza.NONE;
                break;
            default:
                String valueOf = String.valueOf(level);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Unknown log level: ").append(valueOf).toString());
        }
    }

    public synchronized void setPersistenceEnabled(boolean z) {
        zzcqf();
        this.aRa = z;
    }

    public synchronized void zze(FirebaseApp firebaseApp) {
        this.aPM = firebaseApp;
    }

    public synchronized void zzrk(String str) {
        zzcqf();
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
        this.aTu = str;
    }
}
