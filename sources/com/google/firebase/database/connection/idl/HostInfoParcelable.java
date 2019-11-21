package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzagx;

class HostInfoParcelable extends AbstractSafeParcelable {
    public static final zzd CREATOR = new zzd();
    final String aRd;
    final boolean aRe;
    final int versionCode;
    final String zl;

    public HostInfoParcelable(int i, String str, String str2, boolean z) {
        this.versionCode = i;
        this.aRd = str;
        this.zl = str2;
        this.aRe = z;
    }

    public static zzagx zza(HostInfoParcelable hostInfoParcelable) {
        return new zzagx(hostInfoParcelable.aRd, hostInfoParcelable.zl, hostInfoParcelable.aRe);
    }

    public static HostInfoParcelable zza(zzagx zzagx) {
        return new HostInfoParcelable(1, zzagx.getHost(), zzagx.getNamespace(), zzagx.isSecure());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
