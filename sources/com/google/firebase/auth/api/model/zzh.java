package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<VerifyAssertionRequest> {
    static void zza(VerifyAssertionRequest verifyAssertionRequest, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, verifyAssertionRequest.mVersionCode);
        zzb.zza(parcel, 2, verifyAssertionRequest.zzclv(), false);
        zzb.zza(parcel, 3, verifyAssertionRequest.zzclw(), false);
        zzb.zza(parcel, 4, verifyAssertionRequest.getIdToken(), false);
        zzb.zza(parcel, 5, verifyAssertionRequest.getAccessToken(), false);
        zzb.zza(parcel, 6, verifyAssertionRequest.getProviderId(), false);
        zzb.zza(parcel, 7, verifyAssertionRequest.getEmail(), false);
        zzb.zza(parcel, 8, verifyAssertionRequest.zzlj(), false);
        zzb.zza(parcel, 9, verifyAssertionRequest.zzclx(), false);
        zzb.zza(parcel, 10, verifyAssertionRequest.zzcly());
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzadg */
    public VerifyAssertionRequest[] newArray(int i) {
        return new VerifyAssertionRequest[i];
    }

    /* renamed from: zzux */
    public VerifyAssertionRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzcl = zza.zzcl(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    str8 = zza.zzq(parcel, zzck);
                    break;
                case 3:
                    str7 = zza.zzq(parcel, zzck);
                    break;
                case 4:
                    str6 = zza.zzq(parcel, zzck);
                    break;
                case 5:
                    str5 = zza.zzq(parcel, zzck);
                    break;
                case 6:
                    str4 = zza.zzq(parcel, zzck);
                    break;
                case 7:
                    str3 = zza.zzq(parcel, zzck);
                    break;
                case 8:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case 9:
                    str = zza.zzq(parcel, zzck);
                    break;
                case 10:
                    z = zza.zzc(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new VerifyAssertionRequest(i, str8, str7, str6, str5, str4, str3, str2, str, z);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
