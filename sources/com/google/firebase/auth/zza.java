package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<UserProfileChangeRequest> {
    static void zza(UserProfileChangeRequest userProfileChangeRequest, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, userProfileChangeRequest.mVersionCode);
        zzb.zza(parcel, 2, userProfileChangeRequest.getDisplayName(), false);
        zzb.zza(parcel, 3, userProfileChangeRequest.zzckv(), false);
        zzb.zza(parcel, 4, userProfileChangeRequest.zzckw());
        zzb.zza(parcel, 5, userProfileChangeRequest.zzckx());
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzacw */
    public UserProfileChangeRequest[] newArray(int i) {
        return new UserProfileChangeRequest[i];
    }

    /* renamed from: zzup */
    public UserProfileChangeRequest createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
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
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzck);
                    break;
                case 4:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzck);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzck);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new UserProfileChangeRequest(i, str2, str, z2, z);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
