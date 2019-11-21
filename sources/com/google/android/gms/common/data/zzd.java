package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] vM = {"data"};
    private final Creator<T> vN;

    public zzd(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.vN = creator;
    }

    public static <T extends SafeParcelable> void zza(zza zza, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        zza.zza(contentValues);
        obtain.recycle();
    }

    public static zza zzarc() {
        return DataHolder.zzb(vM);
    }

    /* renamed from: zzfn */
    public T get(int i) {
        byte[] zzg = this.tk.zzg("data", i, this.tk.zzfo(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.vN.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
