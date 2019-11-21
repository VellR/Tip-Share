package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<GetTokenResponse> {
    static void zza(GetTokenResponse getTokenResponse, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, getTokenResponse.mVersionCode);
        zzb.zza(parcel, 2, getTokenResponse.zzcln(), false);
        zzb.zza(parcel, 3, getTokenResponse.getAccessToken(), false);
        zzb.zza(parcel, 4, Long.valueOf(getTokenResponse.zzclo()), false);
        zzb.zza(parcel, 5, getTokenResponse.zzclp(), false);
        zzb.zza(parcel, 6, Long.valueOf(getTokenResponse.zzclq()), false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzadc */
    public GetTokenResponse[] newArray(int i) {
        return new GetTokenResponse[i];
    }

    /* renamed from: zzut */
    public GetTokenResponse createFromParcel(Parcel parcel) {
        Long l = null;
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        String str = null;
        Long l2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    str3 = zza.zzq(parcel, zzck);
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case 4:
                    l2 = zza.zzj(parcel, zzck);
                    break;
                case 5:
                    str = zza.zzq(parcel, zzck);
                    break;
                case 6:
                    l = zza.zzj(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new GetTokenResponse(i, str3, str2, l2, str, l);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
