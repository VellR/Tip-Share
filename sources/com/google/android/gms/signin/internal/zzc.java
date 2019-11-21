package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Creator<CheckServerAuthResult> {
    static void zza(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, checkServerAuthResult.mVersionCode);
        zzb.zza(parcel, 2, checkServerAuthResult.aus);
        zzb.zzc(parcel, 3, checkServerAuthResult.aut, false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzqn */
    public CheckServerAuthResult createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzcl = zza.zzcl(parcel);
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzck);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzck, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new CheckServerAuthResult(i, z, arrayList);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzxr */
    public CheckServerAuthResult[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }
}
