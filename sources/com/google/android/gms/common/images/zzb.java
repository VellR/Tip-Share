package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;

public class zzb implements Creator<WebImage> {
    static void zza(WebImage webImage, Parcel parcel, int i) {
        int zzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, webImage.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) webImage.getUrl(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, webImage.getWidth());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, webImage.getHeight());
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzcc */
    public WebImage createFromParcel(Parcel parcel) {
        int zzg;
        int i;
        Uri uri;
        int i2;
        int i3 = 0;
        int zzcl = zza.zzcl(parcel);
        Uri uri2 = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    int i6 = i3;
                    i = i4;
                    uri = uri2;
                    i2 = zza.zzg(parcel, zzck);
                    zzg = i6;
                    break;
                case 2:
                    i2 = i5;
                    int i7 = i4;
                    uri = (Uri) zza.zza(parcel, zzck, Uri.CREATOR);
                    zzg = i3;
                    i = i7;
                    break;
                case 3:
                    uri = uri2;
                    i2 = i5;
                    int i8 = i3;
                    i = zza.zzg(parcel, zzck);
                    zzg = i8;
                    break;
                case 4:
                    zzg = zza.zzg(parcel, zzck);
                    i = i4;
                    uri = uri2;
                    i2 = i5;
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    zzg = i3;
                    i = i4;
                    uri = uri2;
                    i2 = i5;
                    break;
            }
            i5 = i2;
            uri2 = uri;
            i4 = i;
            i3 = zzg;
        }
        if (parcel.dataPosition() == zzcl) {
            return new WebImage(i5, uri2, i4, i3);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzfv */
    public WebImage[] newArray(int i) {
        return new WebImage[i];
    }
}
