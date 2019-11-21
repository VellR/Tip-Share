package com.google.android.gms.internal;

import com.google.android.gms.internal.zzagz.zza;
import com.google.firebase.database.FirebaseDatabase;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

enum zzahp implements zzahs {
    INSTANCE;
    
    static ThreadFactory aTF;
    static final zzaid aTG = null;

    static {
        aTG = new zzaid() {
            public void zza(Thread thread, String str) {
            }

            public void zza(Thread thread, UncaughtExceptionHandler uncaughtExceptionHandler) {
                thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }

            public void zza(Thread thread, boolean z) {
            }
        };
    }

    public static boolean isActive() {
        return zzcqw() != null;
    }

    private static ThreadFactory zzcqw() {
        if (aTF == null) {
            try {
                Class cls = Class.forName("com.google.appengine.api.ThreadManager");
                if (cls != null) {
                    aTF = (ThreadFactory) cls.getMethod("backgroundThreadFactory", new Class[0]).invoke(null, new Object[0]);
                }
            } catch (ClassNotFoundException e) {
                return null;
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException(e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4);
            }
        }
        return aTF;
    }

    public void initialize() {
        zzakw.zza(aTF, (zzakv) new zzakv() {
            public void zza(Thread thread, String str) {
                zzahp.aTG.zza(thread, str);
            }
        });
    }

    public zzagz zza(zzahk zzahk, zzagv zzagv, zzagx zzagx, zza zza) {
        return new zzaha(zzahk.zzcqh(), zzagx, zza);
    }

    public zzahg zza(ScheduledExecutorService scheduledExecutorService) {
        throw new RuntimeException("Authentication is not implemented yet");
    }

    public zzaho zza(zzahk zzahk) {
        return new zzaie(zzcqw(), aTG);
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
            /* access modifiers changed from: protected */
            public ThreadFactory getThreadFactory() {
                return zzahp.aTF;
            }

            /* access modifiers changed from: protected */
            public zzaid zzcqx() {
                return zzahp.aTG;
            }

            public void zzh(Throwable th) {
                zzajx zzajx = zzrh;
                String valueOf = String.valueOf(FirebaseDatabase.getSdkVersion());
                zzajx.zze(new StringBuilder(String.valueOf(valueOf).length() + 89).append("Uncaught exception in Firebase Database runloop (").append(valueOf).append("). Please report to support@firebase.com").toString(), th);
            }
        };
    }

    public String zzc(zzahk zzahk) {
        String str = "AppEngine";
        String property = System.getProperty("java.specification.version", "Unknown");
        return new StringBuilder(String.valueOf(property).length() + 1 + String.valueOf(str).length()).append(property).append("/").append(str).toString();
    }
}
