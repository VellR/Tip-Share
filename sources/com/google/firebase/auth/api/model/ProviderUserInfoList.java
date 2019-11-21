package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProviderUserInfoList extends AbstractSafeParcelable {
    public static final Creator<ProviderUserInfoList> CREATOR = new zzf();
    private List<ProviderUserInfo> aOh;
    public final int mVersionCode;

    public ProviderUserInfoList() {
        this.mVersionCode = 1;
        this.aOh = new ArrayList();
    }

    ProviderUserInfoList(int i, List<ProviderUserInfo> list) {
        this.mVersionCode = i;
        if (list == null || list.isEmpty()) {
            this.aOh = Collections.emptyList();
        } else {
            this.aOh = Collections.unmodifiableList(list);
        }
    }

    public static ProviderUserInfoList zza(ProviderUserInfoList providerUserInfoList) {
        List zzclk = providerUserInfoList.zzclk();
        ProviderUserInfoList providerUserInfoList2 = new ProviderUserInfoList();
        if (zzclk != null) {
            providerUserInfoList2.zzclk().addAll(zzclk);
        }
        return providerUserInfoList2;
    }

    public static ProviderUserInfoList zzcls() {
        return new ProviderUserInfoList();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public List<ProviderUserInfo> zzclk() {
        return this.aOh;
    }
}
