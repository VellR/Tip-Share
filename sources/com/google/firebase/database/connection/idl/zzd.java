package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<HostInfoParcelable> {
    static void zza(HostInfoParcelable hostInfoParcelable, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, hostInfoParcelable.versionCode);
        zzb.zza(parcel, 2, hostInfoParcelable.aRd, false);
        zzb.zza(parcel, 3, hostInfoParcelable.zl, false);
        zzb.zza(parcel, 4, hostInfoParcelable.aRe);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzadm */
    public HostInfoParcelable[] newArray(int i) {
        return new HostInfoParcelable[i];
    }

    /* renamed from: zzvb */
    public HostInfoParcelable createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzcl = zza.zzcl(parcel);
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzck);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new HostInfoParcelable(i, str2, str, z);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
