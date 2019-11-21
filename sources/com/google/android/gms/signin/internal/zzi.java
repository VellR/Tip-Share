package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<SignInResponse> {
    static void zza(SignInResponse signInResponse, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, signInResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) signInResponse.zzatd(), i, false);
        zzb.zza(parcel, 3, (Parcelable) signInResponse.zzbzv(), i, false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzqq */
    public SignInResponse createFromParcel(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse;
        ConnectionResult connectionResult;
        int i;
        ResolveAccountResponse resolveAccountResponse2 = null;
        int zzcl = zza.zzcl(parcel);
        int i2 = 0;
        ConnectionResult connectionResult2 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse2;
                    connectionResult = connectionResult2;
                    i = zza.zzg(parcel, zzck);
                    resolveAccountResponse = resolveAccountResponse3;
                    break;
                case 2:
                    i = i2;
                    ConnectionResult connectionResult3 = (ConnectionResult) zza.zza(parcel, zzck, ConnectionResult.CREATOR);
                    resolveAccountResponse = resolveAccountResponse2;
                    connectionResult = connectionResult3;
                    break;
                case 3:
                    resolveAccountResponse = (ResolveAccountResponse) zza.zza(parcel, zzck, ResolveAccountResponse.CREATOR);
                    connectionResult = connectionResult2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    resolveAccountResponse = resolveAccountResponse2;
                    connectionResult = connectionResult2;
                    i = i2;
                    break;
            }
            i2 = i;
            connectionResult2 = connectionResult;
            resolveAccountResponse2 = resolveAccountResponse;
        }
        if (parcel.dataPosition() == zzcl) {
            return new SignInResponse(i2, connectionResult2, resolveAccountResponse2);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzxv */
    public SignInResponse[] newArray(int i) {
        return new SignInResponse[i];
    }
}
