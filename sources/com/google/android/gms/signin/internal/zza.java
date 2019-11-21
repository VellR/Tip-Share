package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<AuthAccountResult> {
    static void zza(AuthAccountResult authAccountResult, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, authAccountResult.mVersionCode);
        zzb.zzc(parcel, 2, authAccountResult.zzbzq());
        zzb.zza(parcel, 3, (Parcelable) authAccountResult.zzbzr(), i, false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzqm */
    public AuthAccountResult createFromParcel(Parcel parcel) {
        int i = 0;
        int zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(zzck)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzck);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzck);
                    break;
                case 3:
                    intent = (Intent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzck, Intent.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new AuthAccountResult(i2, i, intent);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzxq */
    public AuthAccountResult[] newArray(int i) {
        return new AuthAccountResult[i];
    }
}
