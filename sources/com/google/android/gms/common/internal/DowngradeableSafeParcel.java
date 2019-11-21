package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable {
    private static final Object ye = new Object();
    private static ClassLoader yf = null;
    private static Integer yg = null;
    private boolean yh = false;

    protected static ClassLoader zzaso() {
        synchronized (ye) {
        }
        return null;
    }

    protected static Integer zzasp() {
        synchronized (ye) {
        }
        return null;
    }

    private static boolean zzd(Class<?> cls) {
        boolean z = false;
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return z;
        }
    }

    protected static boolean zzhl(String str) {
        ClassLoader zzaso = zzaso();
        if (zzaso == null) {
            return true;
        }
        try {
            return zzd(zzaso.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzasq() {
        return false;
    }
}
