package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;

public class zzajf implements zzaji {
    private final zzahr aPz;
    private final zzahm aXt;
    private final DatabaseError aXu;

    public zzajf(zzahm zzahm, DatabaseError databaseError, zzahr zzahr) {
        this.aXt = zzahm;
        this.aPz = zzahr;
        this.aXu = databaseError;
    }

    public String toString() {
        String valueOf = String.valueOf(zzcmu());
        return new StringBuilder(String.valueOf(valueOf).length() + 7).append(valueOf).append(":CANCEL").toString();
    }

    public zzahr zzcmu() {
        return this.aPz;
    }

    public void zzctc() {
        this.aXt.zza(this.aXu);
    }
}
