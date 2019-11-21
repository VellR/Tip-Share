package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzafm;
import com.google.android.gms.internal.zzann;
import java.util.List;

public class CreateAuthUriResponse extends AbstractSafeParcelable {
    public static final Creator<CreateAuthUriResponse> CREATOR = new zza();
    @zzann("authUri")
    private String aNW;
    @zzann("providerId")
    private String aNX;
    @zzann("forExistingProvider")
    private boolean aNY;
    @zzann("allProviders")
    private StringList aNZ;
    @zzann("registered")
    private boolean ae;
    @zzafm
    public final int mVersionCode;

    public CreateAuthUriResponse() {
        this.mVersionCode = 1;
        this.aNZ = StringList.zzclu();
    }

    CreateAuthUriResponse(int i, String str, boolean z, String str2, boolean z2, StringList stringList) {
        this.mVersionCode = i;
        this.aNW = str;
        this.ae = z;
        this.aNX = str2;
        this.aNY = z2;
        this.aNZ = stringList == null ? StringList.zzclu() : StringList.zza(stringList);
    }

    @Nullable
    public List<String> getAllProviders() {
        return this.aNZ.zzclt();
    }

    @Nullable
    public String getProviderId() {
        return this.aNX;
    }

    public boolean isRegistered() {
        return this.ae;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    @Nullable
    public String zzclg() {
        return this.aNW;
    }

    public boolean zzclh() {
        return this.aNY;
    }

    public StringList zzcli() {
        return this.aNZ;
    }
}
