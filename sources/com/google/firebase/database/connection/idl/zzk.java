package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzk implements Creator<RangeParcelable> {
    static void zza(RangeParcelable rangeParcelable, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, rangeParcelable.versionCode);
        zzb.zzb(parcel, 2, rangeParcelable.aRZ, false);
        zzb.zzb(parcel, 3, rangeParcelable.aSa, false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzadn */
    public RangeParcelable[] newArray(int i) {
        return new RangeParcelable[i];
    }

    /* renamed from: zzvc */
    public RangeParcelable createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    list = zza.zzae(parcel, zzck);
                    break;
                case 3:
                    arrayList = zza.zzae(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new RangeParcelable(i, list, arrayList);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
