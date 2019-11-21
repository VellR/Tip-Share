package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzy {
    private final String separator;

    private zzy(String str) {
        this.separator = str;
    }

    public static zzy zzhr(String str) {
        return new zzy(str);
    }

    public final String zza(Iterable<?> iterable) {
        return zza(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder zza(StringBuilder sb, Iterable<?> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(zzy(it.next()));
            while (it.hasNext()) {
                sb.append(this.separator);
                sb.append(zzy(it.next()));
            }
        }
        return sb;
    }

    /* access modifiers changed from: 0000 */
    public CharSequence zzy(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
