package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public final class SignInConfiguration extends AbstractSafeParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new zzj();
    private final String em;
    private GoogleSignInOptions en;
    final int versionCode;

    SignInConfiguration(int i, String str, GoogleSignInOptions googleSignInOptions) {
        this.versionCode = i;
        this.em = zzab.zzhs(str);
        this.en = googleSignInOptions;
    }

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this(3, str, googleSignInOptions);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.em.equals(signInConfiguration.zzagg())) {
                return false;
            }
            if (this.en == null) {
                if (signInConfiguration.zzagh() != null) {
                    return false;
                }
            } else if (!this.en.equals(signInConfiguration.zzagh())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new zze().zzr(this.em).zzr(this.en).zzagc();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public String zzagg() {
        return this.em;
    }

    public GoogleSignInOptions zzagh() {
        return this.en;
    }
}
