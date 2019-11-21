package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class zzame {
    @NonNull
    public static String zzso(@Nullable String str) throws UnsupportedEncodingException {
        return TextUtils.isEmpty(str) ? "" : zzsp(URLEncoder.encode(str, "UTF8"));
    }

    @NonNull
    public static String zzsp(@NonNull String str) {
        zzab.zzaa(str);
        return str.replace("%2F", "/");
    }

    @NonNull
    public static String zzsq(@NonNull String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("/") && !str.endsWith("/") && !str.contains("//")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("/")) {
            if (!TextUtils.isEmpty(str2)) {
                if (sb.length() > 0) {
                    sb.append("/").append(str2);
                } else {
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }
}
