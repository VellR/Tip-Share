package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<ProviderUserInfo> {
    static void zza(ProviderUserInfo providerUserInfo, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, providerUserInfo.mVersionCode);
        zzb.zza(parcel, 2, providerUserInfo.zzclr(), false);
        zzb.zza(parcel, 3, providerUserInfo.getDisplayName(), false);
        zzb.zza(parcel, 4, providerUserInfo.zzckv(), false);
        zzb.zza(parcel, 5, providerUserInfo.getProviderId(), false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzadd */
    public ProviderUserInfo[] newArray(int i) {
        return new ProviderUserInfo[i];
    }

    /* renamed from: zzuu */
    public ProviderUserInfo createFromParcel(Parcel parcel) {
        String str = null;
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    str4 = zza.zzq(parcel, zzck);
                    break;
                case 3:
                    str3 = zza.zzq(parcel, zzck);
                    break;
                case 4:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case 5:
                    str = zza.zzq(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new ProviderUserInfo(i, str4, str3, str2, str);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
