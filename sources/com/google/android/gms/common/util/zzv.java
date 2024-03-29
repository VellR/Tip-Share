package com.google.android.gms.common.util;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzab;
import java.util.Set;

public final class zzv {
    public static String[] zzb(Scope[] scopeArr) {
        zzab.zzb(scopeArr, (Object) "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i = 0; i < scopeArr.length; i++) {
            strArr[i] = scopeArr[i].zzaoh();
        }
        return strArr;
    }

    public static String[] zzd(Set<Scope> set) {
        zzab.zzb(set, (Object) "scopes can't be null.");
        return zzb((Scope[]) set.toArray(new Scope[set.size()]));
    }
}
