package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import java.util.List;

public class TokenData extends AbstractSafeParcelable {
    public static final zze CREATOR = new zze();
    private final String ct;
    private final Long cu;
    private final boolean cv;
    private final boolean cw;
    private final List<String> cx;
    final int mVersionCode;

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        this.mVersionCode = i;
        this.ct = zzab.zzhs(str);
        this.cu = l;
        this.cv = z;
        this.cw = z2;
        this.cx = list;
    }

    @Nullable
    public static TokenData zzd(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.ct, tokenData.ct) && zzaa.equal(this.cu, tokenData.cu) && this.cv == tokenData.cv && this.cw == tokenData.cw && zzaa.equal(this.cx, tokenData.cx);
    }

    public String getToken() {
        return this.ct;
    }

    public int hashCode() {
        return zzaa.hashCode(this.ct, this.cu, Boolean.valueOf(this.cv), Boolean.valueOf(this.cw), this.cx);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    @Nullable
    public Long zzaew() {
        return this.cu;
    }

    public boolean zzaex() {
        return this.cv;
    }

    public boolean zzaey() {
        return this.cw;
    }

    @Nullable
    public List<String> zzaez() {
        return this.cx;
    }
}
