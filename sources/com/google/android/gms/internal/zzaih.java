package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaji.zza;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class zzaih extends zzahm {
    private final zzaht aPr;
    private final zzajm aTf;
    private final ValueEventListener aVZ;

    public zzaih(zzaht zzaht, ValueEventListener valueEventListener, zzajm zzajm) {
        this.aPr = zzaht;
        this.aVZ = valueEventListener;
        this.aTf = zzajm;
    }

    public boolean equals(Object obj) {
        return (obj instanceof zzaih) && ((zzaih) obj).aVZ.equals(this.aVZ) && ((zzaih) obj).aPr.equals(this.aPr) && ((zzaih) obj).aTf.equals(this.aTf);
    }

    public int hashCode() {
        return (((this.aVZ.hashCode() * 31) + this.aPr.hashCode()) * 31) + this.aTf.hashCode();
    }

    public String toString() {
        return "ValueEventRegistration";
    }

    public zzahm zza(zzajm zzajm) {
        return new zzaih(this.aPr, this.aVZ, zzajm);
    }

    public zzajh zza(zzajg zzajg, zzajm zzajm) {
        return new zzajh(zza.VALUE, this, com.google.firebase.database.zza.zza(com.google.firebase.database.zza.zza(this.aPr, zzajm.zzcmu()), zzajg.zzctb()), null);
    }

    public void zza(zzajh zzajh) {
        if (!zzcqu()) {
            this.aVZ.onDataChange(zzajh.zzcth());
        }
    }

    public void zza(DatabaseError databaseError) {
        this.aVZ.onCancelled(databaseError);
    }

    public boolean zza(zza zza) {
        return zza == zza.VALUE;
    }

    public boolean zzc(zzahm zzahm) {
        return (zzahm instanceof zzaih) && ((zzaih) zzahm).aVZ.equals(this.aVZ);
    }

    public zzajm zzcpu() {
        return this.aTf;
    }
}
