package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<ConverterWrapper> {
    static void zza(ConverterWrapper converterWrapper, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, converterWrapper.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) converterWrapper.zzatm(), i, false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzco */
    public ConverterWrapper createFromParcel(Parcel parcel) {
        int zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(zzck)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzck);
                    break;
                case 2:
                    stringToIntConverter = (StringToIntConverter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzck, (Creator<T>) StringToIntConverter.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new ConverterWrapper(i, stringToIntConverter);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzgl */
    public ConverterWrapper[] newArray(int i) {
        return new ConverterWrapper[i];
    }
}
