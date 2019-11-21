package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzun.zzf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class zzag {
    final boolean als;
    final int anL;
    final boolean anM;
    final String anN;
    final List<String> anO;
    final String anP;

    public zzag(zzf zzf) {
        boolean z;
        boolean z2 = false;
        zzab.zzaa(zzf);
        if (zzf.aos == null || zzf.aos.intValue() == 0) {
            z = false;
        } else {
            if (zzf.aos.intValue() == 6) {
                if (zzf.aov == null || zzf.aov.length == 0) {
                    z = false;
                }
            } else if (zzf.aot == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.anL = zzf.aos.intValue();
            if (zzf.aou != null && zzf.aou.booleanValue()) {
                z2 = true;
            }
            this.anM = z2;
            if (this.anM || this.anL == 1 || this.anL == 6) {
                this.anN = zzf.aot;
            } else {
                this.anN = zzf.aot.toUpperCase(Locale.ENGLISH);
            }
            this.anO = zzf.aov == null ? null : zza(zzf.aov, this.anM);
            if (this.anL == 1) {
                this.anP = this.anN;
            } else {
                this.anP = null;
            }
        } else {
            this.anL = 0;
            this.anM = false;
            this.anN = null;
            this.anO = null;
            this.anP = null;
        }
        this.als = z;
    }

    private List<String> zza(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        ArrayList arrayList = new ArrayList();
        for (String upperCase : strArr) {
            arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean zzmj(String str) {
        if (!this.als || str == null) {
            return null;
        }
        if (!this.anM && this.anL != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.anL) {
            case 1:
                return Boolean.valueOf(Pattern.compile(this.anP, this.anM ? 0 : 66).matcher(str).matches());
            case 2:
                return Boolean.valueOf(str.startsWith(this.anN));
            case 3:
                return Boolean.valueOf(str.endsWith(this.anN));
            case 4:
                return Boolean.valueOf(str.contains(this.anN));
            case 5:
                return Boolean.valueOf(str.equals(this.anN));
            case 6:
                return Boolean.valueOf(this.anO.contains(str));
            default:
                return null;
        }
    }
}
