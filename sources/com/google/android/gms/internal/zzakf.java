package com.google.android.gms.internal;

import com.google.android.gms.internal.zzakm.zza;
import java.util.Collections;
import java.util.Iterator;

public class zzakf extends zzakb implements zzakm {
    private static final zzakf aYX = new zzakf();

    private zzakf() {
    }

    public static zzakf zzcvi() {
        return aYX;
    }

    public boolean equals(Object obj) {
        if (obj instanceof zzakf) {
            return true;
        }
        return (obj instanceof zzakm) && ((zzakm) obj).isEmpty() && zzcux().equals(((zzakm) obj).zzcux());
    }

    public int getChildCount() {
        return 0;
    }

    public Object getValue() {
        return null;
    }

    public Object getValue(boolean z) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator<zzakl> iterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        return "<Empty Node>";
    }

    public String zza(zza zza) {
        return "";
    }

    public zzakm zzao(zzahr zzahr) {
        return this;
    }

    public Iterator<zzakl> zzcnd() {
        return Collections.emptyList().iterator();
    }

    public String zzcuv() {
        return "";
    }

    public boolean zzcuw() {
        return false;
    }

    public zzakm zzcux() {
        return this;
    }

    public zzakm zze(zzaka zzaka, zzakm zzakm) {
        return (!zzakm.isEmpty() && !zzaka.zzcut()) ? new zzakb().zze(zzaka, zzakm) : this;
    }

    /* renamed from: zzg */
    public int compareTo(zzakm zzakm) {
        return zzakm.isEmpty() ? 0 : -1;
    }

    /* renamed from: zzk */
    public zzakf zzf(zzakm zzakm) {
        return this;
    }

    public boolean zzk(zzaka zzaka) {
        return false;
    }

    public zzaka zzl(zzaka zzaka) {
        return null;
    }

    public zzakm zzl(zzahr zzahr, zzakm zzakm) {
        if (zzahr.isEmpty()) {
            return zzakm;
        }
        zzaka zzcrb = zzahr.zzcrb();
        return zze(zzcrb, zzm(zzcrb).zzl(zzahr.zzcrc(), zzakm));
    }

    public zzakm zzm(zzaka zzaka) {
        return this;
    }
}
