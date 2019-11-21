package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzafm;
import com.google.android.gms.internal.zzann;

public class GetTokenResponse extends AbstractSafeParcelable {
    public static final Creator<GetTokenResponse> CREATOR = new zzd();
    @zzann("refresh_token")
    private String aNx;
    @zzann("expires_in")
    private Long aOd;
    @zzann("token_type")
    private String aOe;
    @zzann("issued_at")
    private Long aOf;
    @zzann("access_token")
    private String atX;
    @zzafm
    public final int mVersionCode;

    public GetTokenResponse() {
        this.mVersionCode = 1;
        this.aOf = Long.valueOf(System.currentTimeMillis());
    }

    GetTokenResponse(int i, String str, String str2, Long l, String str3, Long l2) {
        this.mVersionCode = i;
        this.aNx = str;
        this.atX = str2;
        this.aOd = l;
        this.aOe = str3;
        this.aOf = l2;
    }

    public String getAccessToken() {
        return this.atX;
    }

    public boolean isValid() {
        return zzh.zzavi().currentTimeMillis() + 300000 < this.aOf.longValue() + (this.aOd.longValue() * 1000);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public String zzcln() {
        return this.aNx;
    }

    public long zzclo() {
        if (this.aOd == null) {
            return 0;
        }
        return this.aOd.longValue();
    }

    @Nullable
    public String zzclp() {
        return this.aOe;
    }

    public long zzclq() {
        return this.aOf.longValue();
    }

    public void zzqm(@NonNull String str) {
        this.aNx = zzab.zzhs(str);
    }
}
