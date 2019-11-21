package com.google.firebase.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class GoogleAuthCredential extends AuthCredential {
    private final String atX;
    private final String dd;

    GoogleAuthCredential(@Nullable String str, @Nullable String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        this.dd = zzbj(str, "idToken");
        this.atX = zzbj(str2, "accessToken");
    }

    public static VerifyAssertionRequest zza(@NonNull GoogleAuthCredential googleAuthCredential) {
        zzab.zzaa(googleAuthCredential);
        return new VerifyAssertionRequest(googleAuthCredential.getIdToken(), googleAuthCredential.getAccessToken(), googleAuthCredential.getProvider(), null, null);
    }

    private static String zzbj(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2).concat(" must not be empty"));
    }

    @Nullable
    public String getAccessToken() {
        return this.atX;
    }

    @Nullable
    public String getIdToken() {
        return this.dd;
    }

    public String getProvider() {
        return GoogleAuthProvider.PROVIDER_ID;
    }
}
