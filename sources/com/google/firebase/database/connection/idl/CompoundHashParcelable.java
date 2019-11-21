package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzags;
import com.google.android.gms.internal.zzagw;
import java.util.ArrayList;
import java.util.List;

class CompoundHashParcelable extends AbstractSafeParcelable {
    public static final zza CREATOR = new zza();
    final List<String> aQK;
    final List<String> aQL;
    final int versionCode;

    public CompoundHashParcelable(int i, List<String> list, List<String> list2) {
        this.versionCode = i;
        this.aQK = list;
        this.aQL = list2;
    }

    public static zzags zza(CompoundHashParcelable compoundHashParcelable) {
        ArrayList arrayList = new ArrayList(compoundHashParcelable.aQK.size());
        for (String zzqz : compoundHashParcelable.aQK) {
            arrayList.add(zzagw.zzqz(zzqz));
        }
        return new zzags(arrayList, compoundHashParcelable.aQL);
    }

    public static CompoundHashParcelable zza(zzags zzags) {
        List<List> zzcny = zzags.zzcny();
        ArrayList arrayList = new ArrayList(zzcny.size());
        for (List zzap : zzcny) {
            arrayList.add(zzagw.zzap(zzap));
        }
        return new CompoundHashParcelable(1, arrayList, zzags.zzcnz());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
