package com.google.android.gms.auth.api.signin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult implements Result {
    private Status cc;
    private GoogleSignInAccount dZ;

    public GoogleSignInResult(@Nullable GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.dZ = googleSignInAccount;
        this.cc = status;
    }

    @Nullable
    public GoogleSignInAccount getSignInAccount() {
        return this.dZ;
    }

    @NonNull
    public Status getStatus() {
        return this.cc;
    }

    public boolean isSuccess() {
        return this.cc.isSuccess();
    }
}
