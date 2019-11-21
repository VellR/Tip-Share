package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaji.zza;
import com.google.firebase.database.DatabaseError;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class zzahm {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzahm.class.desiredAssertionStatus());
    private AtomicBoolean aTB = new AtomicBoolean(false);
    private zzahn aTC;
    private boolean aTD = false;

    public abstract zzahm zza(zzajm zzajm);

    public abstract zzajh zza(zzajg zzajg, zzajm zzajm);

    public void zza(zzahn zzahn) {
        if (!$assertionsDisabled && zzcqu()) {
            throw new AssertionError();
        } else if ($assertionsDisabled || this.aTC == null) {
            this.aTC = zzahn;
        } else {
            throw new AssertionError();
        }
    }

    public abstract void zza(zzajh zzajh);

    public abstract void zza(DatabaseError databaseError);

    public abstract boolean zza(zza zza);

    public abstract boolean zzc(zzahm zzahm);

    public abstract zzajm zzcpu();

    public void zzcqt() {
        if (this.aTB.compareAndSet(false, true) && this.aTC != null) {
            this.aTC.zzd(this);
            this.aTC = null;
        }
    }

    public boolean zzcqu() {
        return this.aTB.get();
    }

    public boolean zzcqv() {
        return this.aTD;
    }

    public void zzct(boolean z) {
        this.aTD = z;
    }
}
