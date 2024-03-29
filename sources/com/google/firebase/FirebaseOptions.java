package com.google.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.util.zzw;

public final class FirebaseOptions {
    /* access modifiers changed from: private */
    public final String aMW;
    /* access modifiers changed from: private */
    public final String aMX;
    /* access modifiers changed from: private */
    public final String gs;
    /* access modifiers changed from: private */
    public final String uS;
    /* access modifiers changed from: private */
    public final String uV;
    /* access modifiers changed from: private */
    public final String uW;

    public static final class Builder {
        private String aMW;
        private String aMX;
        private String gs;
        private String uS;
        private String uV;
        private String uW;

        public Builder() {
        }

        public Builder(FirebaseOptions firebaseOptions) {
            this.gs = firebaseOptions.gs;
            this.uS = firebaseOptions.uS;
            this.aMW = firebaseOptions.aMW;
            this.aMX = firebaseOptions.aMX;
            this.uV = firebaseOptions.uV;
            this.uW = firebaseOptions.uW;
        }

        public FirebaseOptions build() {
            return new FirebaseOptions(this.gs, this.uS, this.aMW, this.aMX, this.uV, this.uW);
        }

        public Builder setApiKey(@NonNull String str) {
            this.uS = zzab.zzh(str, "ApiKey must be set.");
            return this;
        }

        public Builder setApplicationId(@NonNull String str) {
            this.gs = zzab.zzh(str, "ApplicationId must be set.");
            return this;
        }

        public Builder setDatabaseUrl(@Nullable String str) {
            this.aMW = str;
            return this;
        }

        public Builder setGcmSenderId(@Nullable String str) {
            this.uV = str;
            return this;
        }

        public Builder setStorageBucket(@Nullable String str) {
            this.uW = str;
            return this;
        }
    }

    private FirebaseOptions(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        zzab.zza(!zzw.zzic(str), (Object) "ApplicationId must be set.");
        this.gs = str;
        this.uS = str2;
        this.aMW = str3;
        this.aMX = str4;
        this.uV = str5;
        this.uW = str6;
    }

    public static FirebaseOptions fromResource(Context context) {
        zzai zzai = new zzai(context);
        String string = zzai.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, zzai.getString("google_api_key"), zzai.getString("firebase_database_url"), zzai.getString("ga_trackingId"), zzai.getString("gcm_defaultSenderId"), zzai.getString("google_storage_bucket"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return zzaa.equal(this.gs, firebaseOptions.gs) && zzaa.equal(this.uS, firebaseOptions.uS) && zzaa.equal(this.aMW, firebaseOptions.aMW) && zzaa.equal(this.aMX, firebaseOptions.aMX) && zzaa.equal(this.uV, firebaseOptions.uV) && zzaa.equal(this.uW, firebaseOptions.uW);
    }

    public String getApiKey() {
        return this.uS;
    }

    public String getApplicationId() {
        return this.gs;
    }

    public String getDatabaseUrl() {
        return this.aMW;
    }

    public String getGcmSenderId() {
        return this.uV;
    }

    public String getStorageBucket() {
        return this.uW;
    }

    public int hashCode() {
        return zzaa.hashCode(this.gs, this.uS, this.aMW, this.aMX, this.uV, this.uW);
    }

    public String toString() {
        return zzaa.zzz(this).zzg("applicationId", this.gs).zzg("apiKey", this.uS).zzg("databaseUrl", this.aMW).zzg("gcmSenderId", this.uV).zzg("storageBucket", this.uW).toString();
    }
}
