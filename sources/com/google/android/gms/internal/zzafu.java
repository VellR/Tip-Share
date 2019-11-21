package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class zzafu implements AuthResult {
    private zzafx aOn;

    public zzafu(@NonNull zzafx zzafx) {
        this.aOn = (zzafx) zzab.zzaa(zzafx);
    }

    @Nullable
    public FirebaseUser getUser() {
        return this.aOn;
    }
}
