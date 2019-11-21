package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class zzs {
    public static boolean DEBUG = Log.isLoggable(TAG, 2);
    public static String TAG = "Volley";

    static class zza {
        public static final boolean zzbj = zzs.DEBUG;
        private final List<C0043zza> zzbk = new ArrayList();
        private boolean zzbl = false;

        /* renamed from: com.google.android.gms.internal.zzs$zza$zza reason: collision with other inner class name */
        private static class C0043zza {
            public final String name;
            public final long time;
            public final long zzbm;

            public C0043zza(String str, long j, long j2) {
                this.name = str;
                this.zzbm = j;
                this.time = j2;
            }
        }

        zza() {
        }

        private long zzw() {
            if (this.zzbk.size() == 0) {
                return 0;
            }
            return ((C0043zza) this.zzbk.get(this.zzbk.size() - 1)).time - ((C0043zza) this.zzbk.get(0)).time;
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.zzbl) {
                zzd("Request on the loose");
                zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        public synchronized void zza(String str, long j) {
            if (this.zzbl) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.zzbk.add(new C0043zza(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void zzd(String str) {
            this.zzbl = true;
            long zzw = zzw();
            if (zzw > 0) {
                long j = ((C0043zza) this.zzbk.get(0)).time;
                zzs.zzb("(%-4d ms) %s", Long.valueOf(zzw), str);
                long j2 = j;
                for (C0043zza zza : this.zzbk) {
                    long j3 = zza.time;
                    zzs.zzb("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(zza.zzbm), zza.name);
                    j2 = j3;
                }
            }
        }
    }

    public static void zza(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zzd(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr), th);
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(TAG, zzd(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr));
    }

    private static String zzd(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str3 = "<unknown>";
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = str3;
                break;
            } else if (!stackTrace[i].getClass().equals(zzs.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String valueOf = String.valueOf(stackTrace[i].getMethodName());
                str2 = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(valueOf).length()).append(substring2).append(".").append(valueOf).toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
