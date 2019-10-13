package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzf implements Creator<PasswordSpecification> {
    static void zza(PasswordSpecification passwordSpecification, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zza(parcel, 1, passwordSpecification.dg, false);
        zzb.zzb(parcel, 2, passwordSpecification.dh, false);
        zzb.zza(parcel, 3, passwordSpecification.di, false);
        zzb.zzc(parcel, 4, passwordSpecification.dj);
        zzb.zzc(parcel, 5, passwordSpecification.dk);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, passwordSpecification.mVersionCode);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzal */
    public PasswordSpecification createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int zzcl = zza.zzcl(parcel);
        int i2 = 0;
        List list = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    str = zza.zzq(parcel, zzck);
                    break;
                case 2:
                    list = zza.zzae(parcel, zzck);
                    break;
                case 3:
                    arrayList = zza.zzad(parcel, zzck);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzck);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzck);
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    i3 = zza.zzg(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new PasswordSpecification(i3, str, list, arrayList, i2, i);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzct */
    public PasswordSpecification[] newArray(int i) {
        return new PasswordSpecification[i];
    }
}
