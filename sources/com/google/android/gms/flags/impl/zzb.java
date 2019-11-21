package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

public class zzb {
    private static SharedPreferences QA = null;

    public static SharedPreferences zzn(final Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (QA == null) {
                QA = (SharedPreferences) zzui.zzb(new Callable<SharedPreferences>() {
                    /* renamed from: zzbfv */
                    public SharedPreferences call() {
                        return context.getSharedPreferences("google_sdk_flags", 1);
                    }
                });
            }
            sharedPreferences = QA;
        }
        return sharedPreferences;
    }
}
