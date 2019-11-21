package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzafm;
import com.google.android.gms.internal.zzann;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringList extends AbstractSafeParcelable {
    public static final Creator<StringList> CREATOR = new zzg();
    @zzann("values")
    private List<String> aOi;
    @zzafm
    public final int mVersionCode;

    public StringList() {
        this(null);
    }

    StringList(int i, List<String> list) {
        this.mVersionCode = i;
        if (list == null || list.isEmpty()) {
            this.aOi = Collections.emptyList();
        } else {
            this.aOi = Collections.unmodifiableList(list);
        }
    }

    public StringList(@Nullable List<String> list) {
        this.mVersionCode = 1;
        this.aOi = new ArrayList();
        if (list != null && !list.isEmpty()) {
            this.aOi.addAll(list);
        }
    }

    public static StringList zza(StringList stringList) {
        return new StringList(stringList != null ? stringList.zzclt() : null);
    }

    public static StringList zzclu() {
        return new StringList(null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public List<String> zzclt() {
        return this.aOi;
    }
}
