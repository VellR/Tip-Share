package com.google.firebase.database;

import com.google.android.gms.internal.zzahl;
import com.google.android.gms.internal.zzahr;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzahu;
import com.google.android.gms.internal.zzahv;
import com.google.android.gms.internal.zzalm;
import com.google.android.gms.internal.zzalo;
import com.google.android.gms.internal.zzalp;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.Logger.Level;
import java.util.HashMap;
import java.util.Map;

public class FirebaseDatabase {
    private static final Map<String, FirebaseDatabase> aPn = new HashMap();
    private final FirebaseApp aPo;
    private final zzahu aPp;
    private final zzahl aPq;
    /* access modifiers changed from: private */
    public zzaht aPr;

    private FirebaseDatabase(FirebaseApp firebaseApp, zzahu zzahu, zzahl zzahl) {
        this.aPo = firebaseApp;
        this.aPp = zzahu;
        this.aPq = zzahl;
    }

    public static FirebaseDatabase getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static synchronized FirebaseDatabase getInstance(FirebaseApp firebaseApp) {
        FirebaseDatabase firebaseDatabase;
        synchronized (FirebaseDatabase.class) {
            if (!aPn.containsKey(firebaseApp.getName())) {
                String databaseUrl = firebaseApp.getOptions().getDatabaseUrl();
                if (databaseUrl == null) {
                    throw new DatabaseException("Failed to get FirebaseDatabase instance: FirebaseApp object has no DatabaseURL in its FirebaseOptions object.");
                }
                zzalm zzrs = zzalo.zzrs(databaseUrl);
                if (!zzrs.aPz.isEmpty()) {
                    String valueOf = String.valueOf(zzrs.aPz.toString());
                    throw new DatabaseException(new StringBuilder(String.valueOf(databaseUrl).length() + 114 + String.valueOf(valueOf).length()).append("Configured Database URL '").append(databaseUrl).append("' is invalid. It should point to the root of a Firebase Database but it includes a path: ").append(valueOf).toString());
                }
                zzahl zzahl = new zzahl();
                if (!firebaseApp.zzckb()) {
                    zzahl.zzrk(firebaseApp.getName());
                }
                zzahl.zze(firebaseApp);
                aPn.put(firebaseApp.getName(), new FirebaseDatabase(firebaseApp, zzrs.aPp, zzahl));
            }
            firebaseDatabase = (FirebaseDatabase) aPn.get(firebaseApp.getName());
        }
        return firebaseDatabase;
    }

    public static String getSdkVersion() {
        return "3.0.0";
    }

    private synchronized void zzcmp() {
        if (this.aPr == null) {
            this.aPr = zzahv.zza(this.aPq, this.aPp, this);
        }
    }

    private void zzqr(String str) {
        if (this.aPr != null) {
            throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 77).append("Calls to ").append(str).append("() must be made before any other usage of FirebaseDatabase instance.").toString());
        }
    }

    public FirebaseApp getApp() {
        return this.aPo;
    }

    public DatabaseReference getReference() {
        zzcmp();
        return new DatabaseReference(this.aPr, zzahr.zzcqy());
    }

    public DatabaseReference getReference(String str) {
        zzcmp();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
        }
        zzalp.zzry(str);
        return new DatabaseReference(this.aPr, new zzahr(str));
    }

    public DatabaseReference getReferenceFromUrl(String str) {
        zzcmp();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'url' in FirebaseDatabase.getReferenceFromUrl()");
        }
        zzalm zzrs = zzalo.zzrs(str);
        if (zzrs.aPp.aRd.equals(this.aPr.zzcrh().aRd)) {
            return new DatabaseReference(this.aPr, zzrs.aPz);
        }
        String valueOf = String.valueOf(getReference().toString());
        throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 93 + String.valueOf(valueOf).length()).append("Invalid URL (").append(str).append(") passed to getReference().  URL was expected to match configured Database URL: ").append(valueOf).toString());
    }

    public void goOffline() {
        zzcmp();
        zzahv.zzk(this.aPr);
    }

    public void goOnline() {
        zzcmp();
        zzahv.zzl(this.aPr);
    }

    public void purgeOutstandingWrites() {
        zzcmp();
        this.aPr.zzr(new Runnable() {
            public void run() {
                FirebaseDatabase.this.aPr.purgeOutstandingWrites();
            }
        });
    }

    public synchronized void setLogLevel(Level level) {
        zzqr("setLogLevel");
        this.aPq.setLogLevel(level);
    }

    public synchronized void setPersistenceEnabled(boolean z) {
        zzqr("setPersistenceEnabled");
        this.aPq.setPersistenceEnabled(z);
    }
}
