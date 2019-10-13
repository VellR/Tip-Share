package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class GeneratePasswordRequest extends AbstractSafeParcelable {
    public static final Creator<GeneratePasswordRequest> CREATOR = new zzi();
    private final PasswordSpecification cN;
    final int mVersionCode;

    GeneratePasswordRequest(int i, PasswordSpecification passwordSpecification) {
        this.mVersionCode = i;
        this.cN = passwordSpecification;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public PasswordSpecification zzafb() {
        return this.cN;
    }
}
