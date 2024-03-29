package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzi {
    private static Boolean AL;
    private static Boolean AM;
    private static Boolean AN;
    private static Boolean AO;

    public static boolean zzb(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (AL == null) {
            boolean z2 = (resources.getConfiguration().screenLayout & 15) > 3;
            if ((zzs.zzavj() && z2) || zzc(resources)) {
                z = true;
            }
            AL = Boolean.valueOf(z);
        }
        return AL.booleanValue();
    }

    @TargetApi(13)
    private static boolean zzc(Resources resources) {
        if (AM == null) {
            Configuration configuration = resources.getConfiguration();
            AM = Boolean.valueOf(zzs.zzavl() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600);
        }
        return AM.booleanValue();
    }

    @TargetApi(20)
    public static boolean zzck(Context context) {
        if (AN == null) {
            AN = Boolean.valueOf(zzs.zzavr() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return AN.booleanValue();
    }

    @TargetApi(21)
    public static boolean zzcl(Context context) {
        if (AO == null) {
            AO = Boolean.valueOf(zzs.zzavs() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return AO.booleanValue();
    }
}
