package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public final class HintRequest extends AbstractSafeParcelable {
    public static final Creator<HintRequest> CREATOR = new zzd();
    private final String[] cX;
    private final CredentialPickerConfig da;
    private final boolean db;
    private final boolean dc;
    final int mVersionCode;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String[] cX;
        /* access modifiers changed from: private */
        public CredentialPickerConfig da = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        /* access modifiers changed from: private */
        public boolean db;
        /* access modifiers changed from: private */
        public boolean dc;

        public HintRequest build() {
            if (this.cX == null) {
                this.cX = new String[0];
            }
            if (this.db || this.dc || this.cX.length != 0) {
                return new HintRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.cX = strArr;
            return this;
        }

        public Builder setEmailAddressIdentifierSupported(boolean z) {
            this.db = z;
            return this;
        }

        public Builder setHintPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.da = (CredentialPickerConfig) zzab.zzaa(credentialPickerConfig);
            return this;
        }

        public Builder setPhoneNumberIdentifierSupported(boolean z) {
            this.dc = z;
            return this;
        }
    }

    HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr) {
        this.mVersionCode = i;
        this.da = (CredentialPickerConfig) zzab.zzaa(credentialPickerConfig);
        this.db = z;
        this.dc = z2;
        this.cX = (String[]) zzab.zzaa(strArr);
    }

    private HintRequest(Builder builder) {
        this(1, builder.da, builder.db, builder.dc, builder.cX);
    }

    @NonNull
    public String[] getAccountTypes() {
        return this.cX;
    }

    @NonNull
    public CredentialPickerConfig getHintPickerConfig() {
        return this.da;
    }

    public boolean isEmailAddressIdentifierSupported() {
        return this.db;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public boolean zzafe() {
        return this.dc;
    }
}
