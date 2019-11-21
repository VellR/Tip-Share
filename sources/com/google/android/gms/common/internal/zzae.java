package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae implements Creator<SignInButtonConfig> {
    static void zza(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, signInButtonConfig.mVersionCode);
        zzb.zzc(parcel, 2, signInButtonConfig.zzatg());
        zzb.zzc(parcel, 3, signInButtonConfig.zzath());
        zzb.zza(parcel, 4, (T[]) signInButtonConfig.zzati(), i, false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzci */
    public SignInButtonConfig createFromParcel(Parcel parcel) {
        int i = 0;
        int zzcl = zza.zzcl(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i3 = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzck);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 4:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzck, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new SignInButtonConfig(i3, i2, i, scopeArr);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzgg */
    public SignInButtonConfig[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
