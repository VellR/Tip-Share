package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg implements Creator<WakeLockEvent> {
    static void zza(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, wakeLockEvent.mVersionCode);
        zzb.zza(parcel, 2, wakeLockEvent.getTimeMillis());
        zzb.zza(parcel, 4, wakeLockEvent.zzauv(), false);
        zzb.zzc(parcel, 5, wakeLockEvent.zzauy());
        zzb.zzb(parcel, 6, wakeLockEvent.zzauz(), false);
        zzb.zza(parcel, 8, wakeLockEvent.zzaur());
        zzb.zza(parcel, 10, wakeLockEvent.zzauw(), false);
        zzb.zzc(parcel, 11, wakeLockEvent.getEventType());
        zzb.zza(parcel, 12, wakeLockEvent.zzauo(), false);
        zzb.zza(parcel, 13, wakeLockEvent.zzavb(), false);
        zzb.zzc(parcel, 14, wakeLockEvent.zzava());
        zzb.zza(parcel, 15, wakeLockEvent.zzavc());
        zzb.zza(parcel, 16, wakeLockEvent.zzavd());
        zzb.zza(parcel, 17, wakeLockEvent.zzaux(), false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzcx */
    public WakeLockEvent createFromParcel(Parcel parcel) {
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        ArrayList arrayList = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    i = zza.zzg(parcel, zzck);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzck);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzck);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzck);
                    break;
                case 6:
                    arrayList = zza.zzae(parcel, zzck);
                    break;
                case 8:
                    j2 = zza.zzi(parcel, zzck);
                    break;
                case 10:
                    str3 = zza.zzq(parcel, zzck);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzck);
                    break;
                case 12:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case 13:
                    str4 = zza.zzq(parcel, zzck);
                    break;
                case 14:
                    i4 = zza.zzg(parcel, zzck);
                    break;
                case 15:
                    f = zza.zzl(parcel, zzck);
                    break;
                case 16:
                    j3 = zza.zzi(parcel, zzck);
                    break;
                case 17:
                    str5 = zza.zzq(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3, str5);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzgu */
    public WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
