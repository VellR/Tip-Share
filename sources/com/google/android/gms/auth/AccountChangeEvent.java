package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new zza();
    final long ce;
    final String cf;
    final int cg;
    final int ch;
    final String ci;
    final int mVersion;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.mVersion = i;
        this.ce = j;
        this.cf = (String) zzab.zzaa(str);
        this.cg = i2;
        this.ch = i3;
        this.ci = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.mVersion = 1;
        this.ce = j;
        this.cf = (String) zzab.zzaa(str);
        this.cg = i;
        this.ch = i2;
        this.ci = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.mVersion == accountChangeEvent.mVersion && this.ce == accountChangeEvent.ce && zzaa.equal(this.cf, accountChangeEvent.cf) && this.cg == accountChangeEvent.cg && this.ch == accountChangeEvent.ch && zzaa.equal(this.ci, accountChangeEvent.ci);
    }

    public String getAccountName() {
        return this.cf;
    }

    public String getChangeData() {
        return this.ci;
    }

    public int getChangeType() {
        return this.cg;
    }

    public int getEventIndex() {
        return this.ch;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.mVersion), Long.valueOf(this.ce), this.cf, Integer.valueOf(this.cg), Integer.valueOf(this.ch), this.ci);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.cg) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        String str2 = this.cf;
        String str3 = this.ci;
        return new StringBuilder(String.valueOf(str2).length() + 91 + String.valueOf(str).length() + String.valueOf(str3).length()).append("AccountChangeEvent {accountName = ").append(str2).append(", changeType = ").append(str).append(", changeData = ").append(str3).append(", eventIndex = ").append(this.ch).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
