package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class CredentialPickerConfig extends AbstractSafeParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new zzb();
    private final boolean cU;
    private final boolean cV;
    private final boolean mShowCancelButton;
    final int mVersionCode;

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean cU = false;
        /* access modifiers changed from: private */
        public boolean cV = false;
        /* access modifiers changed from: private */
        public boolean mShowCancelButton = true;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }

        public Builder setForNewAccount(boolean z) {
            this.cV = z;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.cU = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3) {
        this.mVersionCode = i;
        this.cU = z;
        this.mShowCancelButton = z2;
        this.cV = z3;
    }

    private CredentialPickerConfig(Builder builder) {
        this(1, builder.cU, builder.mShowCancelButton, builder.cV);
    }

    public boolean isForNewAccount() {
        return this.cV;
    }

    public boolean shouldShowAddAccountButton() {
        return this.cU;
    }

    public boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
