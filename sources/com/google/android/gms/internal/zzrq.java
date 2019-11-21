package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzp;

public class zzrq {
    private final String mTag;
    private final String yR;
    private final zzp zk;
    private final int zzczi;

    private zzrq(String str, String str2) {
        this.yR = str2;
        this.mTag = str;
        this.zk = new zzp(str);
        this.zzczi = getLogLevel();
    }

    public zzrq(String str, String... strArr) {
        this(str, zzc(strArr));
    }

    private int getLogLevel() {
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        return i;
    }

    private static String zzc(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String str : strArr) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(str);
        }
        sb.append(']').append(' ');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.yR.concat(str);
    }

    public void zza(String str, Object... objArr) {
        if (zzaz(2)) {
            Log.v(this.mTag, format(str, objArr));
        }
    }

    public boolean zzaz(int i) {
        return this.zzczi <= i;
    }
}
