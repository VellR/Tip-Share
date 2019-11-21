package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Creator<GetAccountInfoUserList> {
    static void zza(GetAccountInfoUserList getAccountInfoUserList, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, getAccountInfoUserList.mVersionCode);
        zzb.zzc(parcel, 2, getAccountInfoUserList.zzclm(), false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzadb */
    public GetAccountInfoUserList[] newArray(int i) {
        return new GetAccountInfoUserList[i];
    }

    /* renamed from: zzus */
    public GetAccountInfoUserList createFromParcel(Parcel parcel) {
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
                    arrayList = zza.zzc(parcel, zzck, GetAccountInfoUser.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new GetAccountInfoUserList(i, arrayList);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
