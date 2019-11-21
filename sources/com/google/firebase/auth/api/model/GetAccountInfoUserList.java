package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzafm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetAccountInfoUserList extends AbstractSafeParcelable {
    public static final Creator<GetAccountInfoUserList> CREATOR = new zzc();
    private List<GetAccountInfoUser> aOc;
    @zzafm
    public final int mVersionCode;

    public GetAccountInfoUserList() {
        this.mVersionCode = 1;
        this.aOc = new ArrayList();
    }

    GetAccountInfoUserList(int i, List<GetAccountInfoUser> list) {
        this.mVersionCode = i;
        this.aOc = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public List<GetAccountInfoUser> zzclm() {
        return this.aOc;
    }
}
