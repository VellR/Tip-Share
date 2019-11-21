package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzahb;
import java.util.List;

class RangeParcelable extends AbstractSafeParcelable {
    public static final zzk CREATOR = new zzk();
    final List<String> aRZ;
    final List<String> aSa;
    final int versionCode;

    public RangeParcelable(int i, List<String> list, List<String> list2) {
        this.versionCode = i;
        this.aRZ = list;
        this.aSa = list2;
    }

    public static zzahb zza(RangeParcelable rangeParcelable, Object obj) {
        return new zzahb(rangeParcelable.aRZ, rangeParcelable.aSa, obj);
    }

    public static RangeParcelable zza(zzahb zzahb) {
        return new RangeParcelable(1, zzahb.zzcpd(), zzahb.zzcpe());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
