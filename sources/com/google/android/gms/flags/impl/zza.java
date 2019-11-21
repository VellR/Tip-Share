package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

public abstract class zza<T> {

    /* renamed from: com.google.android.gms.flags.impl.zza$zza reason: collision with other inner class name */
    public static class C0022zza extends zza<Boolean> {
        public static Boolean zza(final SharedPreferences sharedPreferences, final String str, final Boolean bool) {
            return (Boolean) zzui.zzb(new Callable<Boolean>() {
                /* renamed from: zzto */
                public Boolean call() {
                    return Boolean.valueOf(sharedPreferences.getBoolean(str, bool.booleanValue()));
                }
            });
        }
    }

    public static class zzb extends zza<Integer> {
        public static Integer zza(final SharedPreferences sharedPreferences, final String str, final Integer num) {
            return (Integer) zzui.zzb(new Callable<Integer>() {
                /* renamed from: zzbft */
                public Integer call() {
                    return Integer.valueOf(sharedPreferences.getInt(str, num.intValue()));
                }
            });
        }
    }

    public static class zzc extends zza<Long> {
        public static Long zza(final SharedPreferences sharedPreferences, final String str, final Long l) {
            return (Long) zzui.zzb(new Callable<Long>() {
                /* renamed from: zzbfu */
                public Long call() {
                    return Long.valueOf(sharedPreferences.getLong(str, l.longValue()));
                }
            });
        }
    }

    public static class zzd extends zza<String> {
        public static String zza(final SharedPreferences sharedPreferences, final String str, final String str2) {
            return (String) zzui.zzb(new Callable<String>() {
                /* renamed from: zzaba */
                public String call() {
                    return sharedPreferences.getString(str, str2);
                }
            });
        }
    }
}