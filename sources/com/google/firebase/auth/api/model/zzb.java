package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;

public class zzb implements Creator<GetAccountInfoUser> {
    static void zza(GetAccountInfoUser getAccountInfoUser, Parcel parcel, int i) {
        int zzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getAccountInfoUser.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getAccountInfoUser.getLocalId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, getAccountInfoUser.getEmail(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, getAccountInfoUser.zzclj());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, getAccountInfoUser.getDisplayName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, getAccountInfoUser.zzckv(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) getAccountInfoUser.zzcll(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, getAccountInfoUser.getPassword(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzada */
    public GetAccountInfoUser[] newArray(int i) {
        return new GetAccountInfoUser[i];
    }

    /* renamed from: zzur */
    public GetAccountInfoUser createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzcl = zza.zzcl(parcel);
        ProviderUserInfoList providerUserInfoList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    str5 = zza.zzq(parcel, zzck);
                    break;
                case 3:
                    str4 = zza.zzq(parcel, zzck);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzck);
                    break;
                case 5:
                    str3 = zza.zzq(parcel, zzck);
                    break;
                case 6:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case 7:
                    providerUserInfoList = (ProviderUserInfoList) zza.zza(parcel, zzck, ProviderUserInfoList.CREATOR);
                    break;
                case 8:
                    str = zza.zzq(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new GetAccountInfoUser(i, str5, str4, z, str3, str2, providerUserInfoList, str);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
