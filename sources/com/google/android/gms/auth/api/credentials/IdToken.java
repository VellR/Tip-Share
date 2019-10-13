package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.internal.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public final class IdToken extends AbstractSafeParcelable {
    public static final Creator<IdToken> CREATOR = new zze();
    @NonNull
    private final String cR;
    @NonNull
    private final String dd;
    final int mVersionCode;

    IdToken(int i, @NonNull String str, @NonNull String str2) {
        zzb.zzfn(str);
        zzab.zzb(!TextUtils.isEmpty(str2), (Object) "id token string cannot be null or empty");
        this.mVersionCode = i;
        this.cR = str;
        this.dd = str2;
    }

    public IdToken(@NonNull String str, @NonNull String str2) {
        this(1, str, str2);
    }

    @NonNull
    public String getAccountType() {
        return this.cR;
    }

    @NonNull
    public String getIdToken() {
        return this.dd;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
