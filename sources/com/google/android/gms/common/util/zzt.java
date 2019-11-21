package com.google.android.gms.common.util;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class zzt {
    private static String AY = null;

    public static String zzavu() {
        return zzgy(Binder.getCallingPid());
    }

    public static String zzavv() {
        if (AY == null) {
            AY = zzgy(Process.myPid());
        }
        return AY;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060 A[SYNTHETIC, Splitter:B:24:0x0060] */
    /* JADX WARNING: Unknown variable types count: 2 */
    private static String zzgy(int i) {
        ? r2;
        Throwable th;
        ? r22;
        String str = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                str = bufferedReader.readLine().trim();
                if (bufferedReader != 0) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e) {
                        Log.w("ProcessUtils", e.getMessage(), e);
                    }
                }
            } catch (IOException e2) {
                e = e2;
                r22 = bufferedReader;
            }
        } catch (IOException e3) {
            e = e3;
            r22 = str;
            try {
                Log.e("ProcessUtils", e.getMessage(), e);
                if (r22 != 0) {
                    try {
                        r22.close();
                    } catch (Exception e4) {
                        Log.w("ProcessUtils", e4.getMessage(), e4);
                    }
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                r2 = r22;
                if (r2 != 0) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            r2 = str;
            th = th3;
            if (r2 != 0) {
                try {
                    r2.close();
                } catch (Exception e5) {
                    Log.w("ProcessUtils", e5.getMessage(), e5);
                }
            }
            throw th;
        }
        return str;
    }
}
