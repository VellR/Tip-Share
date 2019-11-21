package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;
import java.util.ArrayList;

public class zzb implements Creator<StringToIntConverter> {
    static void zza(StringToIntConverter stringToIntConverter, Parcel parcel, int i) {
        int zzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, stringToIntConverter.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, stringToIntConverter.zzato(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzcp */
    public StringToIntConverter createFromParcel(Parcel parcel) {
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzck, Entry.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new StringToIntConverter(i, arrayList);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzgm */
    public StringToIntConverter[] newArray(int i) {
        return new StringToIntConverter[i];
    }
}
