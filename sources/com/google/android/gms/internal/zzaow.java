package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaow;
import java.io.IOException;

public abstract class zzaow<M extends zzaow<M>> extends zzapc {
    protected zzaoy bib;

    /* renamed from: ac */
    public M clone() throws CloneNotSupportedException {
        M m = (zzaow) super.clone();
        zzapa.zza(this, (zzaow) m);
        return m;
    }

    public /* synthetic */ zzapc ad() throws CloneNotSupportedException {
        return (zzaow) clone();
    }

    public final <T> T zza(zzaox<M, T> zzaox) {
        if (this.bib == null) {
            return null;
        }
        zzaoz zzaew = this.bib.zzaew(zzapf.zzafa(zzaox.tag));
        if (zzaew != null) {
            return zzaew.zzb(zzaox);
        }
        return null;
    }

    public void zza(zzaov zzaov) throws IOException {
        if (this.bib != null) {
            for (int i = 0; i < this.bib.size(); i++) {
                this.bib.zzaex(i).zza(zzaov);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzaou zzaou, int i) throws IOException {
        int position = zzaou.getPosition();
        if (!zzaou.zzaeg(i)) {
            return false;
        }
        int zzafa = zzapf.zzafa(i);
        zzape zzape = new zzape(i, zzaou.zzad(position, zzaou.getPosition() - position));
        zzaoz zzaoz = null;
        if (this.bib == null) {
            this.bib = new zzaoy();
        } else {
            zzaoz = this.bib.zzaew(zzafa);
        }
        if (zzaoz == null) {
            zzaoz = new zzaoz();
            this.bib.zza(zzafa, zzaoz);
        }
        zzaoz.zza(zzape);
        return true;
    }

    /* access modifiers changed from: protected */
    public int zzy() {
        if (this.bib == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.bib.size(); i2++) {
            i += this.bib.zzaex(i2).zzy();
        }
        return i;
    }
}
