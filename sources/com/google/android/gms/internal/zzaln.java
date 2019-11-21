package com.google.android.gms.internal;

import java.util.Random;

public class zzaln {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaln.class.desiredAssertionStatus());
    private static final Random ban = new Random();
    private static long bao = 0;
    private static final int[] bap = new int[12];

    public static synchronized String zzcl(long j) {
        String sb;
        synchronized (zzaln.class) {
            boolean z = j == bao;
            bao = j;
            char[] cArr = new char[8];
            StringBuilder sb2 = new StringBuilder(20);
            for (int i = 7; i >= 0; i--) {
                cArr[i] = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt((int) (j % 64));
                j /= 64;
            }
            if ($assertionsDisabled || j == 0) {
                sb2.append(cArr);
                if (!z) {
                    for (int i2 = 0; i2 < 12; i2++) {
                        bap[i2] = ban.nextInt(64);
                    }
                } else {
                    zzcws();
                }
                for (int i3 = 0; i3 < 12; i3++) {
                    sb2.append("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt(bap[i3]));
                }
                if ($assertionsDisabled || sb2.length() == 20) {
                    sb = sb2.toString();
                } else {
                    throw new AssertionError();
                }
            } else {
                throw new AssertionError();
            }
        }
        return sb;
    }

    private static void zzcws() {
        int i = 11;
        while (i >= 0) {
            if (bap[i] != 63) {
                bap[i] = bap[i] + 1;
                return;
            } else {
                bap[i] = 0;
                i--;
            }
        }
    }
}
