package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<EventParcel> {
    static void zza(EventParcel eventParcel, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, eventParcel.versionCode);
        zzb.zza(parcel, 2, eventParcel.name, false);
        zzb.zza(parcel, 3, (Parcelable) eventParcel.akf, i, false);
        zzb.zza(parcel, 4, eventParcel.akg, false);
        zzb.zza(parcel, 5, eventParcel.akh);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzoo */
    public EventParcel createFromParcel(Parcel parcel) {
        String str = null;
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
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
                    eventParams = (EventParams) zza.zza(parcel, zzck, (Creator<T>) EventParams.CREATOR);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzck);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new EventParcel(i, str2, eventParams, str, j);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzvg */
    public EventParcel[] newArray(int i) {
        return new EventParcel[i];
    }
}
