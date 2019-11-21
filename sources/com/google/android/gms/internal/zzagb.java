package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.api.model.GetTokenResponse;

public class zzagb {
    private zzams aNm;
    private String aOw;
    private zzand aOx = new zzand();
    private Context mContext;
    private SharedPreferences zzaxs;

    public zzagb(@NonNull Context context, @NonNull String str, @NonNull zzams zzams) {
        zzab.zzaa(context);
        this.aOw = zzab.zzhs(str);
        this.mContext = context.getApplicationContext();
        String format = String.format("com.google.firebase.auth.api.Store.%s", new Object[]{this.aOw});
        this.aNm = (zzams) zzab.zzaa(zzams);
        this.zzaxs = this.mContext.getSharedPreferences(format, 0);
    }

    public void clear(String str) {
        this.zzaxs.edit().remove(str).apply();
    }

    @Nullable
    public String get(String str) {
        return this.zzaxs.getString(str, null);
    }

    public void zza(@NonNull FirebaseUser firebaseUser, @NonNull GetTokenResponse getTokenResponse) {
        zzab.zzaa(firebaseUser);
        zzab.zzaa(getTokenResponse);
        zzp(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), getTokenResponse);
    }

    @Nullable
    public FirebaseUser zzcma() {
        String str = get("com.google.firebase.auth.FIREBASE_USER");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            zzanb zzczq = this.aOx.zzsy(str).zzczq();
            if (zzczq.has("type")) {
                if ("com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(zzczq.zzsx("type").zzczh())) {
                    return (FirebaseUser) this.aNm.zza((zzamy) zzczq, zzafx.class);
                }
            }
        } catch (zzanh e) {
        }
        return null;
    }

    public void zzcmb() {
        clear("com.google.firebase.auth.FIREBASE_USER");
    }

    @Nullable
    public <T> T zze(String str, Class<T> cls) {
        String str2 = get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return this.aNm.zzf(str2, cls);
    }

    public void zze(@NonNull FirebaseUser firebaseUser) {
        zzab.zzaa(firebaseUser);
        zzp("com.google.firebase.auth.FIREBASE_USER", firebaseUser);
    }

    public GetTokenResponse zzf(@NonNull FirebaseUser firebaseUser) {
        zzab.zzaa(firebaseUser);
        return (GetTokenResponse) zze(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), GetTokenResponse.class);
    }

    public void zzg(@NonNull FirebaseUser firebaseUser) {
        zzab.zzaa(firebaseUser);
        clear(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
    }

    public void zzp(String str, Object obj) {
        this.zzaxs.edit().putString(str, this.aNm.zzcj(obj)).apply();
    }
}
