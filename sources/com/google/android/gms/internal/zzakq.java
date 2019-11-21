package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;

public class zzakq {
    public static zzakm zzbt(Object obj) {
        zzakm zzbs = zzakn.zzbs(obj);
        if (zzbs instanceof zzakk) {
            zzbs = new zzake(Double.valueOf((double) ((Long) zzbs.getValue()).longValue()), zzcvu());
        }
        if (zzp(zzbs)) {
            return zzbs;
        }
        throw new DatabaseException("Invalid Firebase Database priority (must be a string, double, ServerValue, or null)");
    }

    public static zzakm zzcvu() {
        return zzakf.zzcvi();
    }

    public static boolean zzp(zzakm zzakm) {
        return zzakm.zzcux().isEmpty() && (zzakm.isEmpty() || (zzakm instanceof zzake) || (zzakm instanceof zzaks) || (zzakm instanceof zzakd));
    }
}
