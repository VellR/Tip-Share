package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;

public class ConverterWrapper extends AbstractSafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private final StringToIntConverter zn;

    ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.mVersionCode = i;
        this.zn = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.mVersionCode = 1;
        this.zn = stringToIntConverter;
    }

    public static ConverterWrapper zza(zza<?, ?> zza) {
        if (zza instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) zza);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza zza = CREATOR;
        zza.zza(this, parcel, i);
    }

    /* access modifiers changed from: 0000 */
    public StringToIntConverter zzatm() {
        return this.zn;
    }

    public zza<?, ?> zzatn() {
        if (this.zn != null) {
            return this.zn;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
