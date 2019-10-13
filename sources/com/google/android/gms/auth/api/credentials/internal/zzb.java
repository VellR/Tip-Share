package com.google.android.gms.auth.api.credentials.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;

public class zzb {
    public static String zzfn(String str) {
        boolean z = false;
        zzab.zzb(!TextUtils.isEmpty(str), (Object) "account type cannot be empty");
        String scheme = Uri.parse(str).getScheme();
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            z = true;
        }
        zzab.zzb(z, (Object) "Account type must be an http or https URI");
        return str;
    }
}
