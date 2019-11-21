package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;

public class zzb implements Creator<ConnectionResult> {
    static void zza(ConnectionResult connectionResult, Parcel parcel, int i) {
        int zzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, connectionResult.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, connectionResult.getErrorCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) connectionResult.getResolution(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, connectionResult.getErrorMessage(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzbx */
    public ConnectionResult createFromParcel(Parcel parcel) {
        String zzq;
        PendingIntent pendingIntent;
        int i;
        int i2;
        String str = null;
        int i3 = 0;
        int zzcl = zza.zzcl(parcel);
        PendingIntent pendingIntent2 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    String str2 = str;
                    pendingIntent = pendingIntent2;
                    i = i3;
                    i2 = zza.zzg(parcel, zzck);
                    zzq = str2;
                    break;
                case 2:
                    i2 = i4;
                    PendingIntent pendingIntent3 = pendingIntent2;
                    i = zza.zzg(parcel, zzck);
                    zzq = str;
                    pendingIntent = pendingIntent3;
                    break;
                case 3:
                    i = i3;
                    i2 = i4;
                    String str3 = str;
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzck, PendingIntent.CREATOR);
                    zzq = str3;
                    break;
                case 4:
                    zzq = zza.zzq(parcel, zzck);
                    pendingIntent = pendingIntent2;
                    i = i3;
                    i2 = i4;
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    zzq = str;
                    pendingIntent = pendingIntent2;
                    i = i3;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            i3 = i;
            pendingIntent2 = pendingIntent;
            str = zzq;
        }
        if (parcel.dataPosition() == zzcl) {
            return new ConnectionResult(i4, i3, pendingIntent2, str);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzez */
    public ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
