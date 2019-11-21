package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

public class Flag extends AbstractSafeParcelable implements Comparable<Flag> {
    public static final Creator<Flag> CREATOR = new zzb();
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zza asg = new zza();
    final boolean abu;
    final double abw;
    final long asc;
    final byte[] asd;
    public final int ase;
    public final int asf;
    final int mVersionCode;
    public final String name;
    final String zr;

    public static class zza implements Comparator<Flag> {
        /* renamed from: zza */
        public int compare(Flag flag, Flag flag2) {
            return flag.asf == flag2.asf ? flag.name.compareTo(flag2.name) : flag.asf - flag2.asf;
        }
    }

    Flag(int i, String str, long j, boolean z, double d, String str2, byte[] bArr, int i2, int i3) {
        this.mVersionCode = i;
        this.name = str;
        this.asc = j;
        this.abu = z;
        this.abw = d;
        this.zr = str2;
        this.asd = bArr;
        this.ase = i2;
        this.asf = i3;
    }

    private static int compare(byte b, byte b2) {
        return b - b2;
    }

    private static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private static int compare(String str, String str2) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    private static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Flag)) {
            return false;
        }
        Flag flag = (Flag) obj;
        if (this.mVersionCode != flag.mVersionCode || !zzaa.equal(this.name, flag.name) || this.ase != flag.ase || this.asf != flag.asf) {
            return false;
        }
        switch (this.ase) {
            case 1:
                return this.asc == flag.asc;
            case 2:
                return this.abu == flag.abu;
            case 3:
                return this.abw == flag.abw;
            case 4:
                return zzaa.equal(this.zr, flag.zr);
            case 5:
                return Arrays.equals(this.asd, flag.asd);
            default:
                throw new AssertionError("Invalid enum value: " + this.ase);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Flag(");
        sb.append(this.mVersionCode);
        sb.append(", ");
        sb.append(this.name);
        sb.append(", ");
        switch (this.ase) {
            case 1:
                sb.append(this.asc);
                break;
            case 2:
                sb.append(this.abu);
                break;
            case 3:
                sb.append(this.abw);
                break;
            case 4:
                sb.append("'");
                sb.append(this.zr);
                sb.append("'");
                break;
            case 5:
                if (this.asd != null) {
                    sb.append("'");
                    sb.append(new String(this.asd, UTF_8));
                    sb.append("'");
                    break;
                } else {
                    sb.append("null");
                    break;
                }
            default:
                throw new AssertionError("Invalid enum value: " + this.ase);
        }
        sb.append(", ");
        sb.append(this.ase);
        sb.append(", ");
        sb.append(this.asf);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    /* renamed from: zza */
    public int compareTo(Flag flag) {
        int compareTo = this.name.compareTo(flag.name);
        if (compareTo != 0) {
            return compareTo;
        }
        int compare = compare(this.ase, flag.ase);
        if (compare != 0) {
            return compare;
        }
        switch (this.ase) {
            case 1:
                return compare(this.asc, flag.asc);
            case 2:
                return compare(this.abu, flag.abu);
            case 3:
                return Double.compare(this.abw, flag.abw);
            case 4:
                return compare(this.zr, flag.zr);
            case 5:
                if (this.asd == flag.asd) {
                    return 0;
                }
                if (this.asd == null) {
                    return -1;
                }
                if (flag.asd == null) {
                    return 1;
                }
                for (int i = 0; i < Math.min(this.asd.length, flag.asd.length); i++) {
                    int compare2 = compare(this.asd[i], flag.asd[i]);
                    if (compare2 != 0) {
                        return compare2;
                    }
                }
                return compare(this.asd.length, flag.asd.length);
            default:
                throw new AssertionError("Invalid enum value: " + this.ase);
        }
    }
}
