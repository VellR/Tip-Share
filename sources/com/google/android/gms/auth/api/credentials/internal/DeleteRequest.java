package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class DeleteRequest extends AbstractSafeParcelable {
    public static final Creator<DeleteRequest> CREATOR = new zzh();
    private final Credential dn;
    final int mVersionCode;

    DeleteRequest(int i, Credential credential) {
        this.mVersionCode = i;
        this.dn = credential;
    }

    public DeleteRequest(Credential credential) {
        this(1, credential);
    }

    public Credential getCredential() {
        return this.dn;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
