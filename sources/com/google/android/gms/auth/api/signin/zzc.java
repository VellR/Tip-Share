package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<SignInAccount> {
    static void zza(SignInAccount signInAccount, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, signInAccount.versionCode);
        zzb.zza(parcel, 4, signInAccount.dG, false);
        zzb.zza(parcel, 7, (Parcelable) signInAccount.zzafw(), i, false);
        zzb.zza(parcel, 8, signInAccount.zzcvm, false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzau */
    public SignInAccount createFromParcel(Parcel parcel) {
        String zzq;
        GoogleSignInAccount googleSignInAccount;
        String str;
        int i;
        int zzcl = zza.zzcl(parcel);
        int i2 = 0;
        String str2 = "";
        GoogleSignInAccount googleSignInAccount2 = null;
        String str3 = "";
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    String str4 = str3;
                    googleSignInAccount = googleSignInAccount2;
                    str = str2;
                    i = zza.zzg(parcel, zzck);
                    zzq = str4;
                    break;
                case 4:
                    i = i2;
                    GoogleSignInAccount googleSignInAccount3 = googleSignInAccount2;
                    str = zza.zzq(parcel, zzck);
                    zzq = str3;
                    googleSignInAccount = googleSignInAccount3;
                    break;
                case 7:
                    str = str2;
                    i = i2;
                    String str5 = str3;
                    googleSignInAccount = (GoogleSignInAccount) zza.zza(parcel, zzck, GoogleSignInAccount.CREATOR);
                    zzq = str5;
                    break;
                case 8:
                    zzq = zza.zzq(parcel, zzck);
                    googleSignInAccount = googleSignInAccount2;
                    str = str2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    zzq = str3;
                    googleSignInAccount = googleSignInAccount2;
                    str = str2;
                    i = i2;
                    break;
            }
            i2 = i;
            str2 = str;
            googleSignInAccount2 = googleSignInAccount;
            str3 = zzq;
        }
        if (parcel.dataPosition() == zzcl) {
            return new SignInAccount(i2, str2, googleSignInAccount2, str3);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzdc */
    public SignInAccount[] newArray(int i) {
        return new SignInAccount[i];
    }
}
