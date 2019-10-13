package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.internal.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import java.util.Collections;
import java.util.List;

public class Credential extends AbstractSafeParcelable {
    public static final Creator<Credential> CREATOR = new zza();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    /* access modifiers changed from: private */
    @Nullable
    public final Uri cO;
    /* access modifiers changed from: private */
    public final List<IdToken> cP;
    /* access modifiers changed from: private */
    @Nullable
    public final String cQ;
    /* access modifiers changed from: private */
    @Nullable
    public final String cR;
    /* access modifiers changed from: private */
    @Nullable
    public final String cS;
    /* access modifiers changed from: private */
    @Nullable
    public final String cT;
    /* access modifiers changed from: private */
    @Nullable
    public final String mName;
    final int mVersionCode;
    /* access modifiers changed from: private */
    public final String zzbgk;

    public static class Builder {
        private Uri cO;
        private List<IdToken> cP;
        private String cQ;
        private String cR;
        private String cS;
        private String cT;
        private String mName;
        private final String zzbgk;

        public Builder(Credential credential) {
            this.zzbgk = credential.zzbgk;
            this.mName = credential.mName;
            this.cO = credential.cO;
            this.cP = credential.cP;
            this.cQ = credential.cQ;
            this.cR = credential.cR;
            this.cS = credential.cS;
            this.cT = credential.cT;
        }

        public Builder(String str) {
            this.zzbgk = str;
        }

        public Credential build() {
            return new Credential(3, this.zzbgk, this.mName, this.cO, this.cP, this.cQ, this.cR, this.cS, this.cT);
        }

        public Builder setAccountType(String str) {
            this.cR = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.cQ = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.cO = uri;
            return this;
        }
    }

    Credential(int i, String str, String str2, Uri uri, List<IdToken> list, String str3, String str4, String str5, String str6) {
        this.mVersionCode = i;
        String trim = ((String) zzab.zzb(str, (Object) "credential identifier cannot be null")).trim();
        zzab.zzh(trim, "credential identifier cannot be empty");
        this.zzbgk = trim;
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.mName = str2;
        this.cO = uri;
        this.cP = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.cQ = str3;
        if (str3 == null || !str3.isEmpty()) {
            if (!TextUtils.isEmpty(str4)) {
                zzb.zzfn(str4);
            }
            this.cR = str4;
            this.cS = str5;
            this.cT = str6;
            if (!TextUtils.isEmpty(this.cQ) && !TextUtils.isEmpty(this.cR)) {
                throw new IllegalStateException("password and accountType cannot both be set");
            }
            return;
        }
        throw new IllegalArgumentException("password cannot be empty");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.zzbgk, credential.zzbgk) && TextUtils.equals(this.mName, credential.mName) && zzaa.equal(this.cO, credential.cO) && TextUtils.equals(this.cQ, credential.cQ) && TextUtils.equals(this.cR, credential.cR) && TextUtils.equals(this.cS, credential.cS);
    }

    @Nullable
    public String getAccountType() {
        return this.cR;
    }

    @Nullable
    public String getGeneratedPassword() {
        return this.cS;
    }

    public String getId() {
        return this.zzbgk;
    }

    public List<IdToken> getIdTokens() {
        return this.cP;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    @Nullable
    public String getPassword() {
        return this.cQ;
    }

    @Nullable
    public Uri getProfilePictureUri() {
        return this.cO;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbgk, this.mName, this.cO, this.cQ, this.cR, this.cS);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzafd() {
        return this.cT;
    }
}
