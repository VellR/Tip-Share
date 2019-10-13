package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<HintRequest> {
    static void zza(HintRequest hintRequest, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zza(parcel, 1, (Parcelable) hintRequest.getHintPickerConfig(), i, false);
        zzb.zza(parcel, 2, hintRequest.isEmailAddressIdentifierSupported());
        zzb.zza(parcel, 3, hintRequest.zzafe());
        zzb.zza(parcel, 4, hintRequest.getAccountTypes(), false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, hintRequest.mVersionCode);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzaj */
    public HintRequest createFromParcel(Parcel parcel) {
        String[] strArr = null;
        boolean z = false;
        int zzcl = zza.zzcl(parcel);
        boolean z2 = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int i = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    credentialPickerConfig = (CredentialPickerConfig) zza.zza(parcel, zzck, CredentialPickerConfig.CREATOR);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzck);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzck);
                    break;
                case 4:
                    strArr = zza.zzac(parcel, zzck);
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new HintRequest(i, credentialPickerConfig, z2, z, strArr);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzcr */
    public HintRequest[] newArray(int i) {
        return new HintRequest[i];
    }
}
