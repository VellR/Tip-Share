package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0008zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<RecordConsentRequest> {
    static void zza(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, recordConsentRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) recordConsentRequest.getAccount(), i, false);
        zzb.zza(parcel, 3, (T[]) recordConsentRequest.zzbzs(), i, false);
        zzb.zza(parcel, 4, recordConsentRequest.zzafu(), false);
        zzb.zzaj(parcel, zzcm);
    }

    /* renamed from: zzqo */
    public RecordConsentRequest createFromParcel(Parcel parcel) {
        String zzq;
        Scope[] scopeArr;
        Account account;
        int i;
        String str = null;
        int zzcl = zza.zzcl(parcel);
        int i2 = 0;
        Scope[] scopeArr2 = null;
        Account account2 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case 1:
                    String str2 = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = zza.zzg(parcel, zzck);
                    zzq = str2;
                    break;
                case 2:
                    i = i2;
                    Scope[] scopeArr3 = scopeArr2;
                    account = (Account) zza.zza(parcel, zzck, Account.CREATOR);
                    zzq = str;
                    scopeArr = scopeArr3;
                    break;
                case 3:
                    account = account2;
                    i = i2;
                    String str3 = str;
                    scopeArr = (Scope[]) zza.zzb(parcel, zzck, Scope.CREATOR);
                    zzq = str3;
                    break;
                case 4:
                    zzq = zza.zzq(parcel, zzck);
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    zzq = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
            }
            i2 = i;
            account2 = account;
            scopeArr2 = scopeArr;
            str = zzq;
        }
        if (parcel.dataPosition() == zzcl) {
            return new RecordConsentRequest(i2, account2, scopeArr2, str);
        }
        throw new C0008zza("Overread allowed size end=" + zzcl, parcel);
    }

    /* renamed from: zzxt */
    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
