package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<SafeParcelResponse> {
    static void zza(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, safeParcelResponse.getVersionCode());
        zzb.zza(parcel, 2, safeParcelResponse.zzauh(), false);
        zzb.zza(parcel, 3, (Parcelable) safeParcelResponse.zzaui(), i, false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzcv */
    public SafeParcelResponse createFromParcel(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    parcel2 = zza.zzaf(parcel, zzck);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) zza.zza(parcel, zzck, (Creator<T>) FieldMappingDictionary.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzgs */
    public SafeParcelResponse[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
