package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaji.zza;

public class zzajg {
    private final zzakh aXq;
    private final zza aXv;
    private final zzakh aXw;
    private final zzaka aXx;
    private final zzaka aXy;

    private zzajg(zza zza, zzakh zzakh, zzaka zzaka, zzaka zzaka2, zzakh zzakh2) {
        this.aXv = zza;
        this.aXq = zzakh;
        this.aXx = zzaka;
        this.aXy = zzaka2;
        this.aXw = zzakh2;
    }

    public static zzajg zza(zzaka zzaka, zzakh zzakh) {
        return new zzajg(zza.CHILD_ADDED, zzakh, zzaka, null, null);
    }

    public static zzajg zza(zzaka zzaka, zzakh zzakh, zzakh zzakh2) {
        return new zzajg(zza.CHILD_CHANGED, zzakh, zzaka, null, zzakh2);
    }

    public static zzajg zza(zzaka zzaka, zzakm zzakm, zzakm zzakm2) {
        return zza(zzaka, zzakh.zzm(zzakm), zzakh.zzm(zzakm2));
    }

    public static zzajg zza(zzakh zzakh) {
        return new zzajg(zza.VALUE, zzakh, null, null, null);
    }

    public static zzajg zzb(zzaka zzaka, zzakh zzakh) {
        return new zzajg(zza.CHILD_REMOVED, zzakh, zzaka, null, null);
    }

    public static zzajg zzc(zzaka zzaka, zzakh zzakh) {
        return new zzajg(zza.CHILD_MOVED, zzakh, zzaka, null, null);
    }

    public static zzajg zzc(zzaka zzaka, zzakm zzakm) {
        return zza(zzaka, zzakh.zzm(zzakm));
    }

    public static zzajg zzd(zzaka zzaka, zzakm zzakm) {
        return zzb(zzaka, zzakh.zzm(zzakm));
    }

    public String toString() {
        String valueOf = String.valueOf(this.aXv);
        String valueOf2 = String.valueOf(this.aXx);
        return new StringBuilder(String.valueOf(valueOf).length() + 9 + String.valueOf(valueOf2).length()).append("Change: ").append(valueOf).append(" ").append(valueOf2).toString();
    }

    public zzakh zzctb() {
        return this.aXq;
    }

    public zzaka zzctd() {
        return this.aXx;
    }

    public zza zzcte() {
        return this.aXv;
    }

    public zzaka zzctf() {
        return this.aXy;
    }

    public zzakh zzctg() {
        return this.aXw;
    }

    public zzajg zzg(zzaka zzaka) {
        return new zzajg(this.aXv, this.aXq, this.aXx, zzaka, this.aXw);
    }
}
