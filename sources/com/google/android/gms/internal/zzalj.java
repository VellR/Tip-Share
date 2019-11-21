package com.google.android.gms.internal;

import java.util.Iterator;

public class zzalj {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzalj.class.desiredAssertionStatus());

    private static long zzd(zzakj<?> zzakj) {
        long j = 8;
        if (!(zzakj instanceof zzake) && !(zzakj instanceof zzakk)) {
            if (zzakj instanceof zzajz) {
                j = 4;
            } else if (zzakj instanceof zzaks) {
                j = (long) (((String) zzakj.getValue()).length() + 2);
            } else {
                String valueOf = String.valueOf(zzakj.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown leaf node type: ").append(valueOf).toString());
            }
        }
        if (zzakj.zzcux().isEmpty()) {
            return j;
        }
        return zzd((zzakj) zzakj.zzcux()) + 24 + j;
    }

    public static long zzs(zzakm zzakm) {
        long j;
        if (zzakm.isEmpty()) {
            return 4;
        }
        if (zzakm.zzcuw()) {
            return zzd((zzakj) zzakm);
        }
        if ($assertionsDisabled || (zzakm instanceof zzakb)) {
            long j2 = 1;
            Iterator it = zzakm.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                zzakl zzakl = (zzakl) it.next();
                j2 = zzs(zzakl.zzcmq()) + j + ((long) zzakl.zzcvs().asString().length()) + 4;
            }
            return !zzakm.zzcux().isEmpty() ? j + 12 + zzd((zzakj) zzakm.zzcux()) : j;
        }
        String valueOf = String.valueOf(zzakm.getClass());
        throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Unexpected node type: ").append(valueOf).toString());
    }

    public static int zzt(zzakm zzakm) {
        int i = 0;
        if (zzakm.isEmpty()) {
            return 0;
        }
        if (zzakm.zzcuw()) {
            return 1;
        }
        if ($assertionsDisabled || (zzakm instanceof zzakb)) {
            Iterator it = zzakm.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                i = zzt(((zzakl) it.next()).zzcmq()) + i2;
            }
        } else {
            String valueOf = String.valueOf(zzakm.getClass());
            throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Unexpected node type: ").append(valueOf).toString());
        }
    }
}
