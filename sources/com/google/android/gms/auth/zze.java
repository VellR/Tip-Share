package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zze implements Creator<TokenData> {
    static void zza(TokenData tokenData, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, tokenData.mVersionCode);
        zzb.zza(parcel, 2, tokenData.getToken(), false);
        zzb.zza(parcel, 3, tokenData.zzaew(), false);
        zzb.zza(parcel, 4, tokenData.zzaex());
        zzb.zza(parcel, 5, tokenData.zzaey());
        zzb.zzb(parcel, 6, tokenData.zzaez(), false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzaf */
    public TokenData createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        boolean z = false;
        int zzcl = zza.zzcl(parcel);
        boolean z2 = false;
        Long l = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzck);
                    break;
                case 3:
                    l = zza.zzj(parcel, zzck);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzck);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzck);
                    break;
                case 6:
                    arrayList = zza.zzae(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new TokenData(i, str, l, z2, z, arrayList);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzcn */
    public TokenData[] newArray(int i) {
        return new TokenData[i];
    }
}
