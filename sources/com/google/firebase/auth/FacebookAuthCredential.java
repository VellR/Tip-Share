package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class FacebookAuthCredential extends AuthCredential {
    private final String atX;

    FacebookAuthCredential(@NonNull String str) {
        this.atX = zzab.zzhs(str);
    }

    public static VerifyAssertionRequest zza(@NonNull FacebookAuthCredential facebookAuthCredential) {
        zzab.zzaa(facebookAuthCredential);
        return new VerifyAssertionRequest(null, facebookAuthCredential.getAccessToken(), facebookAuthCredential.getProvider(), null, null);
    }

    public String getAccessToken() {
        return this.atX;
    }

    public String getProvider() {
        return FacebookAuthProvider.PROVIDER_ID;
    }
}
