package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzru;

public class zzz {
    private static String yS;
    private static int yT;
    private static Object zzamp = new Object();
    private static boolean zzbyy;

    public static String zzcf(Context context) {
        zzch(context);
        return yS;
    }

    public static int zzcg(Context context) {
        zzch(context);
        return yT;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private static void zzch(Context context) {
        synchronized (zzamp) {
            if (!zzbyy) {
                zzbyy = true;
                try {
                    Bundle bundle = zzru.zzcq(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        yS = bundle.getString("com.google.app.id");
                        yT = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }
}
