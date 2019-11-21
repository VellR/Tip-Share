package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzagx;
import com.google.android.gms.internal.zzajy.zza;
import java.util.List;

public class ConnectionConfig extends AbstractSafeParcelable {
    public static final zzb CREATOR = new zzb();
    final boolean aRa;
    final String aRc;
    final HostInfoParcelable aSr;
    final int aSs;
    final List<String> aSt;
    final String aSu;
    final int versionCode;

    public ConnectionConfig(int i, HostInfoParcelable hostInfoParcelable, int i2, List<String> list, boolean z, String str, String str2) {
        this.versionCode = i;
        this.aSr = hostInfoParcelable;
        this.aSs = i2;
        this.aSt = list;
        this.aRa = z;
        this.aSu = str;
        this.aRc = str2;
    }

    public ConnectionConfig(zzagx zzagx, zza zza, List<String> list, boolean z, String str, String str2) {
        int i;
        switch (zza) {
            case DEBUG:
                i = 1;
                break;
            case INFO:
                i = 2;
                break;
            case WARN:
                i = 3;
                break;
            case ERROR:
                i = 4;
                break;
            default:
                i = 0;
                break;
        }
        this.versionCode = 1;
        this.aSr = HostInfoParcelable.zza(zzagx);
        this.aSs = i;
        this.aSt = list;
        this.aRa = z;
        this.aSu = str;
        this.aRc = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public zza zzcpl() {
        switch (this.aSs) {
            case 0:
                return zza.NONE;
            case 1:
                return zza.DEBUG;
            case 2:
                return zza.INFO;
            case 3:
                return zza.WARN;
            case 4:
                return zza.ERROR;
            default:
                return zza.NONE;
        }
    }

    public List<String> zzcpm() {
        return this.aSt;
    }
}
