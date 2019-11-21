package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaji.zza;
import com.google.firebase.database.DataSnapshot;

public class zzajh implements zzaji {
    private final String aXA;
    private final zzahm aXt;
    private final zza aXv;
    private final DataSnapshot aXz;

    public zzajh(zza zza, zzahm zzahm, DataSnapshot dataSnapshot, String str) {
        this.aXv = zza;
        this.aXt = zzahm;
        this.aXz = dataSnapshot;
        this.aXA = str;
    }

    public String toString() {
        if (this.aXv == zza.VALUE) {
            String valueOf = String.valueOf(zzcmu());
            String valueOf2 = String.valueOf(this.aXv);
            String valueOf3 = String.valueOf(this.aXz.getValue(true));
            return new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append(valueOf).append(": ").append(valueOf2).append(": ").append(valueOf3).toString();
        }
        String valueOf4 = String.valueOf(zzcmu());
        String valueOf5 = String.valueOf(this.aXv);
        String valueOf6 = String.valueOf(this.aXz.getKey());
        String valueOf7 = String.valueOf(this.aXz.getValue(true));
        return new StringBuilder(String.valueOf(valueOf4).length() + 10 + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length()).append(valueOf4).append(": ").append(valueOf5).append(": { ").append(valueOf6).append(": ").append(valueOf7).append(" }").toString();
    }

    public zzahr zzcmu() {
        zzahr zzcmu = this.aXz.getRef().zzcmu();
        return this.aXv == zza.VALUE ? zzcmu : zzcmu.zzcrd();
    }

    public void zzctc() {
        this.aXt.zza(this);
    }

    public zza zzcte() {
        return this.aXv;
    }

    public DataSnapshot zzcth() {
        return this.aXz;
    }

    public String zzcti() {
        return this.aXA;
    }
}
