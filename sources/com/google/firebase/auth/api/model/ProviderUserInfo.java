package com.google.firebase.auth.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzafm;
import com.google.android.gms.internal.zzann;

public class ProviderUserInfo extends AbstractSafeParcelable {
    public static final Creator<ProviderUserInfo> CREATOR = new zze();
    @zzann("photoUrl")
    private String Ld;
    @zzann("providerId")
    private String aNX;
    @zzann("federatedId")
    private String aOg;
    @zzann("displayName")
    private String dH;
    @zzafm
    public final int mVersionCode;

    public ProviderUserInfo() {
        this.mVersionCode = 1;
    }

    ProviderUserInfo(int i, String str, String str2, String str3, String str4) {
        this.mVersionCode = i;
        this.aOg = str;
        this.dH = str2;
        this.Ld = str3;
        this.aNX = str4;
    }

    @Nullable
    public String getDisplayName() {
        return this.dH;
    }

    @Nullable
    public Uri getPhotoUri() {
        if (!TextUtils.isEmpty(this.Ld)) {
            return Uri.parse(this.Ld);
        }
        return null;
    }

    public String getProviderId() {
        return this.aNX;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    @Nullable
    public String zzckv() {
        return this.Ld;
    }

    public String zzclr() {
        return this.aOg;
    }
}
