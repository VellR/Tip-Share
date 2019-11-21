package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<CreateAuthUriResponse> {
    static void zza(CreateAuthUriResponse createAuthUriResponse, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, createAuthUriResponse.mVersionCode);
        zzb.zza(parcel, 2, createAuthUriResponse.zzclg(), false);
        zzb.zza(parcel, 3, createAuthUriResponse.isRegistered());
        zzb.zza(parcel, 4, createAuthUriResponse.getProviderId(), false);
        zzb.zza(parcel, 5, createAuthUriResponse.zzclh());
        zzb.zza(parcel, 6, (Parcelable) createAuthUriResponse.zzcli(), i, false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzacz */
    public CreateAuthUriResponse[] newArray(int i) {
        return new CreateAuthUriResponse[i];
    }

    /* renamed from: zzuq */
    public CreateAuthUriResponse createFromParcel(Parcel parcel) {
        StringList stringList = null;
        boolean z = false;
        int zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        String str = null;
        boolean z2 = false;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(zzck)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzck);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzck);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzck);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzck);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzck);
                    break;
                case 6:
                    stringList = (StringList) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzck, StringList.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new CreateAuthUriResponse(i, str2, z2, str, z, stringList);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
