package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;

public class zzh {
    final String ajW;
    final long ajX;
    final EventParams ajY;
    final String mName;
    final long pz;
    final String zzcjj;

    zzh(zzx zzx, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzab.zzhs(str2);
        zzab.zzhs(str3);
        this.zzcjj = str2;
        this.mName = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.ajW = str;
        this.pz = j;
        this.ajX = j2;
        if (this.ajX != 0 && this.ajX > this.pz) {
            zzx.zzbsz().zzbtt().log("Event created with reverse previous/current timestamps");
        }
        this.ajY = zza(zzx, bundle);
    }

    private zzh(zzx zzx, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        zzab.zzhs(str2);
        zzab.zzhs(str3);
        zzab.zzaa(eventParams);
        this.zzcjj = str2;
        this.mName = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.ajW = str;
        this.pz = j;
        this.ajX = j2;
        if (this.ajX != 0 && this.ajX > this.pz) {
            zzx.zzbsz().zzbtt().log("Event created with reverse previous/current timestamps");
        }
        this.ajY = eventParams;
    }

    public String toString() {
        String str = this.zzcjj;
        String str2 = this.mName;
        String valueOf = String.valueOf(this.ajY);
        return new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("'").append(", name='").append(str2).append("'").append(", params=").append(valueOf).append("}").toString();
    }

    /* access modifiers changed from: 0000 */
    public EventParams zza(zzx zzx, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                zzx.zzbsz().zzbtr().log("Param name can't be null");
                it.remove();
            } else {
                Object zzl = zzx.zzbsv().zzl(str, bundle2.get(str));
                if (zzl == null) {
                    zzx.zzbsz().zzbtt().zzj("Param value can't be null", str);
                    it.remove();
                } else {
                    zzx.zzbsv().zza(bundle2, str, zzl);
                }
            }
        }
        return new EventParams(bundle2);
    }

    /* access modifiers changed from: 0000 */
    public zzh zza(zzx zzx, long j) {
        return new zzh(zzx, this.ajW, this.zzcjj, this.mName, this.pz, j, this.ajY);
    }
}
