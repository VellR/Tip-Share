package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new Creator<BinderWrapper>() {
        /* renamed from: zzce */
        public BinderWrapper createFromParcel(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        /* renamed from: zzfz */
        public BinderWrapper[] newArray(int i) {
            return new BinderWrapper[i];
        }
    };
    private IBinder xA;

    public BinderWrapper() {
        this.xA = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.xA = null;
        this.xA = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.xA = null;
        this.xA = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.xA);
    }
}
