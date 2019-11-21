package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.api.model.CreateAuthUriResponse;
import java.util.List;

public class zzafy implements ProviderQueryResult {
    private List<String> aOt;

    public zzafy(@NonNull CreateAuthUriResponse createAuthUriResponse) {
        zzab.zzaa(createAuthUriResponse);
        this.aOt = createAuthUriResponse.getAllProviders();
    }

    @Nullable
    public List<String> getProviders() {
        return this.aOt;
    }
}
