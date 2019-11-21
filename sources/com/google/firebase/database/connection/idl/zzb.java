package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import java.util.List;

public class zzb implements Creator<ConnectionConfig> {
    static void zza(ConnectionConfig connectionConfig, Parcel parcel, int i) {
        int zzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, connectionConfig.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) connectionConfig.aSr, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, connectionConfig.aSs);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 4, connectionConfig.aSt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, connectionConfig.aRa);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, connectionConfig.aSu, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, connectionConfig.aRc, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzadl */
    public ConnectionConfig[] newArray(int i) {
        return new ConnectionConfig[i];
    }

    /* renamed from: zzva */
    public ConnectionConfig createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzcl = zza.zzcl(parcel);
        String str2 = null;
        List list = null;
        int i = 0;
        HostInfoParcelable hostInfoParcelable = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i2 = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    hostInfoParcelable = (HostInfoParcelable) zza.zza(parcel, zzck, (Creator<T>) HostInfoParcelable.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 4:
                    list = zza.zzae(parcel, zzck);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzck);
                    break;
                case 6:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case 7:
                    str = zza.zzq(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new ConnectionConfig(i2, hostInfoParcelable, i, list, z, str2, str);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
