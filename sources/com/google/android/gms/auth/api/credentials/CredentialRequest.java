package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Creator<CredentialRequest> CREATOR = new zzc();
    private final boolean cW;
    private final String[] cX;
    private final CredentialPickerConfig cY;
    private final CredentialPickerConfig cZ;
    final int mVersionCode;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean cW;
        /* access modifiers changed from: private */
        public String[] cX;
        /* access modifiers changed from: private */
        public CredentialPickerConfig cY;
        /* access modifiers changed from: private */
        public CredentialPickerConfig cZ;

        public CredentialRequest build() {
            if (this.cX == null) {
                this.cX = new String[0];
            }
            if (this.cW || this.cX.length != 0) {
                return new CredentialRequest(this);
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

        public Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.cZ = credentialPickerConfig;
            return this;
        }

        public Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.cY = credentialPickerConfig;
            return this;
        }

        public Builder setPasswordLoginSupported(boolean z) {
            this.cW = z;
            return this;
        }

        @Deprecated
        public Builder setSupportsPasswordLogin(boolean z) {
            return setPasswordLoginSupported(z);
        }
    }

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.mVersionCode = i;
        this.cW = z;
        this.cX = (String[]) zzab.zzaa(strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.cY = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.cZ = credentialPickerConfig2;
    }

    private CredentialRequest(Builder builder) {
        this(2, builder.cW, builder.cX, builder.cY, builder.cZ);
    }

    @NonNull
    public String[] getAccountTypes() {
        return this.cX;
    }

    @NonNull
    public CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.cZ;
    }

    @NonNull
    public CredentialPickerConfig getCredentialPickerConfig() {
        return this.cY;
    }

    @Deprecated
    public boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public boolean isPasswordLoginSupported() {
        return this.cW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
