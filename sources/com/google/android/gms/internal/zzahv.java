package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

public class zzahv {
    private static final zzahv aUY = new zzahv();
    /* access modifiers changed from: private */
    public final Map<zzahk, Map<String, zzaht>> aUZ = new HashMap();

    public static zzaht zza(zzahk zzahk, zzahu zzahu, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        return aUY.zzb(zzahk, zzahu, firebaseDatabase);
    }

    private zzaht zzb(zzahk zzahk, zzahu zzahu, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        zzaht zzaht;
        zzahk.zzcpp();
        String str = zzahu.aRd;
        String str2 = zzahu.zl;
        String sb = new StringBuilder(String.valueOf(str).length() + 9 + String.valueOf(str2).length()).append("https://").append(str).append("/").append(str2).toString();
        synchronized (this.aUZ) {
            if (!this.aUZ.containsKey(zzahk)) {
                this.aUZ.put(zzahk, new HashMap());
            }
            Map map = (Map) this.aUZ.get(zzahk);
            if (!map.containsKey(sb)) {
                zzaht = new zzaht(zzahu, zzahk, firebaseDatabase);
                map.put(sb, zzaht);
            } else {
                throw new IllegalStateException("createLocalRepo() called for existing repo.");
            }
        }
        return zzaht;
    }

    public static void zzd(zzahk zzahk) {
        aUY.zzf(zzahk);
    }

    public static void zze(zzahk zzahk) {
        aUY.zzg(zzahk);
    }

    private void zzf(final zzahk zzahk) {
        zzahw zzcqk = zzahk.zzcqk();
        if (zzcqk != null) {
            zzcqk.zzr(new Runnable() {
                public void run() {
                    synchronized (zzahv.this.aUZ) {
                        if (zzahv.this.aUZ.containsKey(zzahk)) {
                            boolean z = true;
                            for (zzaht zzaht : ((Map) zzahv.this.aUZ.get(zzahk)).values()) {
                                zzaht.interrupt();
                                z = z && !zzaht.zzcrj();
                            }
                            if (z) {
                                zzahk.stop();
                            }
                        }
                    }
                }
            });
        }
    }

    private void zzg(final zzahk zzahk) {
        zzahw zzcqk = zzahk.zzcqk();
        if (zzcqk != null) {
            zzcqk.zzr(new Runnable() {
                public void run() {
                    synchronized (zzahv.this.aUZ) {
                        if (zzahv.this.aUZ.containsKey(zzahk)) {
                            for (zzaht resume : ((Map) zzahv.this.aUZ.get(zzahk)).values()) {
                                resume.resume();
                            }
                        }
                    }
                }
            });
        }
    }

    public static void zzk(final zzaht zzaht) {
        zzaht.zzr(new Runnable() {
            public void run() {
                zzaht.this.interrupt();
            }
        });
    }

    public static void zzl(final zzaht zzaht) {
        zzaht.zzr(new Runnable() {
            public void run() {
                zzaht.this.resume();
            }
        });
    }
}
