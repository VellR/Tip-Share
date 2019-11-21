package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zza implements Creator<CompoundHashParcelable> {
    static void zza(CompoundHashParcelable compoundHashParcelable, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, compoundHashParcelable.versionCode);
        zzb.zzb(parcel, 2, compoundHashParcelable.aQK, false);
        zzb.zzb(parcel, 3, compoundHashParcelable.aQL, false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzadk */
    public CompoundHashParcelable[] newArray(int i) {
        return new CompoundHashParcelable[i];
    }

    /* renamed from: zzuz */
    public CompoundHashParcelable createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(zzck)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzck);
                    break;
                case 2:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, zzck);
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, zzck);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new CompoundHashParcelable(i, list, arrayList);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }
}
