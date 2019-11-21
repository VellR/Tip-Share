package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzab;

public class EmailAuthCredential extends AuthCredential {
    private String cQ;
    private String dG;

    EmailAuthCredential(@NonNull String str, @NonNull String str2) {
        this.dG = zzab.zzhs(str);
        this.cQ = zzab.zzhs(str2);
    }

    @NonNull
    public String getEmail() {
        return this.dG;
    }

    @NonNull
    public String getPassword() {
        return this.cQ;
    }

    @NonNull
    public String getProvider() {
        return EmailAuthProvider.PROVIDER_ID;
    }
}
