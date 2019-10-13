package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    Account aP;
    @Deprecated
    String cf;
    int ch;
    final int mVersion;

    public AccountChangeEventsRequest() {
        this.mVersion = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.mVersion = i;
        this.ch = i2;
        this.cf = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.aP = account;
        } else {
            this.aP = new Account(str, "com.google");
        }
    }

    public Account getAccount() {
        return this.aP;
    }

    @Deprecated
    public String getAccountName() {
        return this.cf;
    }

    public int getEventIndex() {
        return this.ch;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.aP = account;
        return this;
    }

    @Deprecated
    public AccountChangeEventsRequest setAccountName(String str) {
        this.cf = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.ch = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
