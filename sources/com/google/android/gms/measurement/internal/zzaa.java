package com.google.android.gms.measurement.internal;

abstract class zzaa extends zzz {
    private boolean zzcwt;

    zzaa(zzx zzx) {
        super(zzx);
        this.aja.zzb(this);
    }

    public final void initialize() {
        if (this.zzcwt) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzwv();
        this.aja.zzbvc();
        this.zzcwt = true;
    }

    /* access modifiers changed from: 0000 */
    public boolean isInitialized() {
        return this.zzcwt;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzbvh() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void zzwv();

    /* access modifiers changed from: protected */
    public void zzzg() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
