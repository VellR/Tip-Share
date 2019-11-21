package com.google.android.gms.internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.ProviderUserInfo;

public class zzafv implements UserInfo {
    @Nullable
    @zzann("photoUrl")
    private String Ld;
    @NonNull
    @zzann("providerId")
    private String aNX;
    @Nullable
    @zzafm
    private Uri aNw;
    @Nullable
    @zzann("email")
    private String dG;
    @Nullable
    @zzann("displayName")
    private String dH;
    @NonNull
    @zzann("userId")
    private String zzcvm;

    public zzafv(@NonNull UserInfo userInfo) {
        zzab.zzaa(userInfo);
        this.zzcvm = zzab.zzhs(userInfo.getUid());
        this.aNX = zzab.zzhs(userInfo.getProviderId());
        this.dH = userInfo.getDisplayName();
        if (userInfo.getPhotoUrl() != null) {
            this.aNw = userInfo.getPhotoUrl();
            this.Ld = userInfo.getPhotoUrl().toString();
        }
        this.dG = userInfo.getEmail();
    }

    public zzafv(@NonNull GetAccountInfoUser getAccountInfoUser, @NonNull String str) {
        zzab.zzaa(getAccountInfoUser);
        zzab.zzhs(str);
        this.zzcvm = zzab.zzhs(getAccountInfoUser.getLocalId());
        this.aNX = str;
        this.dG = getAccountInfoUser.getEmail();
        this.dH = getAccountInfoUser.getDisplayName();
        Uri photoUri = getAccountInfoUser.getPhotoUri();
        if (photoUri != null) {
            this.Ld = photoUri.toString();
            this.aNw = photoUri;
        }
    }

    public zzafv(@NonNull ProviderUserInfo providerUserInfo) {
        zzab.zzaa(providerUserInfo);
        this.zzcvm = zzab.zzhs(providerUserInfo.zzclr());
        this.aNX = zzab.zzhs(providerUserInfo.getProviderId());
        this.dH = providerUserInfo.getDisplayName();
        Uri photoUri = providerUserInfo.getPhotoUri();
        if (photoUri != null) {
            this.Ld = photoUri.toString();
            this.aNw = photoUri;
        }
        this.dG = null;
    }

    @Nullable
    public String getDisplayName() {
        return this.dH;
    }

    @Nullable
    public String getEmail() {
        return this.dG;
    }

    @Nullable
    public Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.Ld) && this.aNw == null) {
            this.aNw = Uri.parse(this.Ld);
        }
        return this.aNw;
    }

    @NonNull
    public String getProviderId() {
        return this.aNX;
    }

    @NonNull
    public String getUid() {
        return this.zzcvm;
    }
}
