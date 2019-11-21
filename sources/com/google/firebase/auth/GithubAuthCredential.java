package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class GithubAuthCredential extends AuthCredential {
    private String ct;

    GithubAuthCredential(@NonNull String str) {
        this.ct = zzab.zzhs(str);
    }

    public static VerifyAssertionRequest zza(@NonNull GithubAuthCredential githubAuthCredential) {
        zzab.zzaa(githubAuthCredential);
        return new VerifyAssertionRequest(null, githubAuthCredential.getToken(), githubAuthCredential.getProvider(), null, null);
    }

    public String getProvider() {
        return GithubAuthProvider.PROVIDER_ID;
    }

    public String getToken() {
        return this.ct;
    }
}
