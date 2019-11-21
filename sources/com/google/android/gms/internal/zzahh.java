package com.google.android.gms.internal;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.zza;

public class zzahh extends zzahm {
    private final zzaht aPr;
    private final ChildEventListener aTe;
    private final zzajm aTf;

    public zzahh(zzaht zzaht, ChildEventListener childEventListener, zzajm zzajm) {
        this.aPr = zzaht;
        this.aTe = childEventListener;
        this.aTf = zzajm;
    }

    public boolean equals(Object obj) {
        return (obj instanceof zzahh) && ((zzahh) obj).aTe.equals(this.aTe) && ((zzahh) obj).aPr.equals(this.aPr) && ((zzahh) obj).aTf.equals(this.aTf);
    }

    public int hashCode() {
        return (((this.aTe.hashCode() * 31) + this.aPr.hashCode()) * 31) + this.aTf.hashCode();
    }

    public String toString() {
        return "ChildEventRegistration";
    }

    public zzahm zza(zzajm zzajm) {
        return new zzahh(this.aPr, this.aTe, zzajm);
    }

    public zzajh zza(zzajg zzajg, zzajm zzajm) {
        return new zzajh(zzajg.zzcte(), this, zza.zza(zza.zza(this.aPr, zzajm.zzcmu().zza(zzajg.zzctd())), zzajg.zzctb()), zzajg.zzctf() != null ? zzajg.zzctf().asString() : null);
    }

    public void zza(zzajh zzajh) {
        if (!zzcqu()) {
            switch (zzajh.zzcte()) {
                case CHILD_ADDED:
                    this.aTe.onChildAdded(zzajh.zzcth(), zzajh.zzcti());
                    return;
                case CHILD_CHANGED:
                    this.aTe.onChildChanged(zzajh.zzcth(), zzajh.zzcti());
                    return;
                case CHILD_MOVED:
                    this.aTe.onChildMoved(zzajh.zzcth(), zzajh.zzcti());
                    return;
                case CHILD_REMOVED:
                    this.aTe.onChildRemoved(zzajh.zzcth());
                    return;
                default:
                    return;
            }
        }
    }

    public void zza(DatabaseError databaseError) {
        this.aTe.onCancelled(databaseError);
    }

    public boolean zza(zzaji.zza zza) {
        return zza != zzaji.zza.VALUE;
    }

    public boolean zzc(zzahm zzahm) {
        return (zzahm instanceof zzahh) && ((zzahh) zzahm).aTe.equals(this.aTe);
    }

    public zzajm zzcpu() {
        return this.aTf;
    }
}
