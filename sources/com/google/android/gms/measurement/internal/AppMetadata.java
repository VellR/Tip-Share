package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public class AppMetadata extends AbstractSafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final String abU;
    public final String ajA;
    public final long ajB;
    public final long ajC;
    public final String ajD;
    public final boolean ajE;
    public final boolean ajF;
    public final long ajG;
    public final String ajH;
    public final String ajz;
    public final String packageName;
    public final int versionCode;

    AppMetadata(int i, String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6) {
        this.versionCode = i;
        this.packageName = str;
        this.ajz = str2;
        this.abU = str3;
        if (i < 5) {
            j3 = -2147483648L;
        }
        this.ajG = j3;
        this.ajA = str4;
        this.ajB = j;
        this.ajC = j2;
        this.ajD = str5;
        if (i >= 3) {
            this.ajE = z;
        } else {
            this.ajE = true;
        }
        this.ajF = z2;
        this.ajH = str6;
    }

    AppMetadata(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6) {
        zzab.zzhs(str);
        this.versionCode = 6;
        this.packageName = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        this.ajz = str2;
        this.abU = str3;
        this.ajG = j;
        this.ajA = str4;
        this.ajB = j2;
        this.ajC = j3;
        this.ajD = str5;
        this.ajE = z;
        this.ajF = z2;
        this.ajH = str6;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
