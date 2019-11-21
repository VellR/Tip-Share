package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class TwitterAuthCredential extends AuthCredential {
    private String aNt;
    private String ct;

    TwitterAuthCredential(@NonNull String str, @NonNull String str2) {
        this.ct = zzab.zzhs(str);
        this.aNt = zzab.zzhs(str2);
    }

    public static VerifyAssertionRequest zza(@NonNull TwitterAuthCredential twitterAuthCredential) {
        zzab.zzaa(twitterAuthCredential);
        return new VerifyAssertionRequest(null, twitterAuthCredential.getToken(), twitterAuthCredential.getProvider(), null, twitterAuthCredential.zzcku());
    }

    public String getProvider() {
        return TwitterAuthProvider.PROVIDER_ID;
    }

    @NonNull
    public String getToken() {
        return this.ct;
    }

    @NonNull
    public String zzcku() {
        return this.aNt;
    }
}
