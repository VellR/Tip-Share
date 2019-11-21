package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzafm;
import com.google.android.gms.internal.zzann;

public class VerifyAssertionRequest extends AbstractSafeParcelable {
    public static final Creator<VerifyAssertionRequest> CREATOR = new zzh();
    @zzafm
    private String aNX;
    @zzann("requestUri")
    private String aOj;
    @zzann("idToken")
    private String aOk;
    @zzann("oauthTokenSecret")
    private String aOl;
    @zzann("returnSecureToken")
    private boolean aOm;
    @zzafm
    private String atX;
    @Nullable
    @zzafm
    private String dG;
    @zzafm
    private String dd;
    @zzafm
    public final int mVersionCode;
    @zzann("postBody")
    private String zzbip;

    public VerifyAssertionRequest() {
        this.mVersionCode = 2;
        this.aOm = true;
    }

    VerifyAssertionRequest(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z) {
        this.mVersionCode = i;
        this.aOj = str;
        this.aOk = str2;
        this.dd = str3;
        this.atX = str4;
        this.aNX = str5;
        this.dG = str6;
        this.zzbip = str7;
        this.aOl = str8;
        this.aOm = z;
    }

    public VerifyAssertionRequest(@Nullable String str, @Nullable String str2, String str3, @Nullable String str4, @Nullable String str5) {
        this.mVersionCode = 2;
        this.aOj = "http://localhost";
        this.dd = str;
        this.atX = str2;
        this.aOl = str5;
        this.aOm = true;
        if (!TextUtils.isEmpty(this.dd) || !TextUtils.isEmpty(this.atX)) {
            this.aNX = zzab.zzhs(str3);
            this.dG = str4;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.dd)) {
                sb.append("id_token").append("=").append(this.dd).append("&");
            }
            if (!TextUtils.isEmpty(this.atX)) {
                sb.append("access_token").append("=").append(this.atX).append("&");
            }
            if (!TextUtils.isEmpty(this.dG)) {
                sb.append("identifier").append("=").append(this.dG).append("&");
            }
            if (!TextUtils.isEmpty(this.aOl)) {
                sb.append("oauth_token_secret").append("=").append(this.aOl).append("&");
            }
            sb.append("providerId").append("=").append(this.aNX);
            this.zzbip = sb.toString();
            return;
        }
        throw new IllegalArgumentException("Both idToken, and accessToken cannot be null");
    }

    public String getAccessToken() {
        return this.atX;
    }

    @Nullable
    public String getEmail() {
        return this.dG;
    }

    public String getIdToken() {
        return this.dd;
    }

    public String getProviderId() {
        return this.aNX;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public String zzclv() {
        return this.aOj;
    }

    public String zzclw() {
        return this.aOk;
    }

    public String zzclx() {
        return this.aOl;
    }

    public boolean zzcly() {
        return this.aOm;
    }

    public String zzlj() {
        return this.zzbip;
    }
}
