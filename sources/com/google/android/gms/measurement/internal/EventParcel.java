package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class EventParcel extends AbstractSafeParcelable {
    public static final zzk CREATOR = new zzk();
    public final EventParams akf;
    public final String akg;
    public final long akh;
    public final String name;
    public final int versionCode;

    EventParcel(int i, String str, EventParams eventParams, String str2, long j) {
        this.versionCode = i;
        this.name = str;
        this.akf = eventParams;
        this.akg = str2;
        this.akh = j;
    }

    public EventParcel(String str, EventParams eventParams, String str2, long j) {
        this.versionCode = 1;
        this.name = str;
        this.akf = eventParams;
        this.akg = str2;
        this.akh = j;
    }

    public String toString() {
        String str = this.akg;
        String str2 = this.name;
        String valueOf = String.valueOf(this.akf);
        return new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(valueOf).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
