package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzab;

public class PlaceReport extends AbstractSafeParcelable {
    public static final Creator<PlaceReport> CREATOR = new zzj();
    private final String aeL;
    private final String mTag;
    final int mVersionCode;
    private final String zzcus;

    PlaceReport(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.aeL = str;
        this.mTag = str2;
        this.zzcus = str3;
    }

    public static PlaceReport create(String str, String str2) {
        return zzk(str, str2, EnvironmentCompat.MEDIA_UNKNOWN);
    }

    public static PlaceReport zzk(String str, String str2, String str3) {
        zzab.zzaa(str);
        zzab.zzhs(str2);
        zzab.zzhs(str3);
        zzab.zzb(zzkq(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    private static boolean zzkq(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    c = 2;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    c = 1;
                    break;
                }
                break;
            case -284840886:
                if (str.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
                    c = 0;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    c = 4;
                    break;
                }
                break;
            case 1164924125:
                if (str.equals("inferredSnappedToRoad")) {
                    c = 5;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzaa.equal(this.aeL, placeReport.aeL) && zzaa.equal(this.mTag, placeReport.mTag) && zzaa.equal(this.zzcus, placeReport.zzcus);
    }

    public String getPlaceId() {
        return this.aeL;
    }

    public String getSource() {
        return this.zzcus;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzaa.hashCode(this.aeL, this.mTag, this.zzcus);
    }

    public String toString() {
        zza zzz = zzaa.zzz(this);
        zzz.zzg("placeId", this.aeL);
        zzz.zzg("tag", this.mTag);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.zzcus)) {
            zzz.zzg("source", this.zzcus);
        }
        return zzz.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
