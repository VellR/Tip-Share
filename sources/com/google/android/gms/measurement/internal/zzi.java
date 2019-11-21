package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;

class zzi {
    final long ajZ;
    final long aka;
    final long akb;
    final String mName;
    final String zzcjj;

    zzi(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzab.zzbn(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        zzab.zzbn(z);
        this.zzcjj = str;
        this.mName = str2;
        this.ajZ = j;
        this.aka = j2;
        this.akb = j3;
    }

    /* access modifiers changed from: 0000 */
    public zzi zzbi(long j) {
        return new zzi(this.zzcjj, this.mName, this.ajZ, this.aka, j);
    }

    /* access modifiers changed from: 0000 */
    public zzi zzbtn() {
        return new zzi(this.zzcjj, this.mName, this.ajZ + 1, this.aka + 1, this.akb);
    }
}
