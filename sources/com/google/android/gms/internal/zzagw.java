package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public class zzagw {
    public static String zzap(List<String> list) {
        if (list.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : list) {
            if (!z) {
                sb.append("/");
            }
            z = false;
            sb.append(str);
        }
        return sb.toString();
    }

    public static Long zzbp(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static void zzc(boolean z, String str, Object... objArr) {
        if (!z) {
            String str2 = "hardAssert failed: ";
            String valueOf = String.valueOf(String.format(str, objArr));
            throw new AssertionError(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    public static void zzcp(boolean z) {
        zzc(z, "", new Object[0]);
    }

    public static List<String> zzqz(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("/");
        for (int i = 0; i < split.length; i++) {
            if (!split[i].isEmpty()) {
                arrayList.add(split[i]);
            }
        }
        return arrayList;
    }
}
