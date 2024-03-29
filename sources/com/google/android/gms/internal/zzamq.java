package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.util.Locale;

public enum zzamq implements zzamr {
    IDENTITY {
        public String zzc(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String zzc(Field field) {
            return zzamq.zzsv(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String zzc(Field field) {
            return zzamq.zzsv(zzamq.zzbw(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String zzc(Field field) {
            return zzamq.zzbw(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String zzc(Field field) {
            return zzamq.zzbw(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };

    private static String zza(char c, String str, int i) {
        if (i >= str.length()) {
            return String.valueOf(c);
        }
        String valueOf = String.valueOf(str.substring(i));
        return new StringBuilder(String.valueOf(valueOf).length() + 1).append(c).append(valueOf).toString();
    }

    /* access modifiers changed from: private */
    public static String zzbw(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static String zzsv(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        while (i < str.length() - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i++;
            charAt = str.charAt(i);
        }
        return i == str.length() ? sb.toString() : !Character.isUpperCase(charAt) ? sb.append(zza(Character.toUpperCase(charAt), str, i + 1)).toString() : str;
    }
}
