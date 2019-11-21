package com.google.firebase.auth.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzafm;
import com.google.android.gms.internal.zzann;
import java.util.List;

public class GetAccountInfoUser implements SafeParcelable {
    public static final Creator<GetAccountInfoUser> CREATOR = new zzb();
    @zzann("localId")
    private String Im;
    @zzann("photoUrl")
    private String Ld;
    @zzann("emailVerified")
    private boolean aOa;
    @zzann("providerUserInfo")
    private ProviderUserInfoList aOb;
    @zzann("passwordHash")
    private String cQ;
    @zzann("email")
    private String dG;
    @zzann("displayName")
    private String dH;
    @zzafm
    public final int mVersionCode;

    public GetAccountInfoUser() {
        this.mVersionCode = 1;
        this.aOb = new ProviderUserInfoList();
    }

    GetAccountInfoUser(int i, String str, String str2, boolean z, String str3, String str4, ProviderUserInfoList providerUserInfoList, String str5) {
        this.mVersionCode = i;
        this.Im = str;
        this.dG = str2;
        this.aOa = z;
        this.dH = str3;
        this.Ld = str4;
        this.aOb = providerUserInfoList == null ? ProviderUserInfoList.zzcls() : ProviderUserInfoList.zza(providerUserInfoList);
        this.cQ = str5;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getDisplayName() {
        return this.dH;
    }

    @Nullable
    public String getEmail() {
        return this.dG;
    }

    @NonNull
    public String getLocalId() {
        return this.Im;
    }

    @Nullable
    public String getPassword() {
        return this.cQ;
    }

    @Nullable
    public Uri getPhotoUri() {
        if (!TextUtils.isEmpty(this.Ld)) {
            return Uri.parse(this.Ld);
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    @Nullable
    public String zzckv() {
        return this.Ld;
    }

    public boolean zzclj() {
        return this.aOa;
    }

    @NonNull
    public List<ProviderUserInfo> zzclk() {
        return this.aOb.zzclk();
    }

    public ProviderUserInfoList zzcll() {
        return this.aOb;
    }
}
