package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg implements Creator<StringList> {
    static void zza(StringList stringList, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, stringList.mVersionCode);
        zzb.zzb(parcel, 2, stringList.zzclt(), false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzadf */
    public StringList[] newArray(int i) {
        return new StringList[i];
    }

    /* renamed from: zzuw */
    public StringList createFromParcel(Parcel parcel) {
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    arrayList = zza.zzae(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new StringList(i, arrayList);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
