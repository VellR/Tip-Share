package com.google.android.gms.internal;

import com.google.android.gms.internal.zzajy.zza;
import java.io.PrintWriter;
import java.io.StringWriter;

public class zzajx {
    private final zzajy aQZ;
    private final String aYu;
    private final String prefix;

    public zzajx(zzajy zzajy, String str) {
        this(zzajy, str, null);
    }

    public zzajx(zzajy zzajy, String str, String str2) {
        this.aQZ = zzajy;
        this.aYu = str;
        this.prefix = str2;
    }

    private long zzcun() {
        return System.currentTimeMillis();
    }

    private String zzi(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (this.prefix == null) {
            return str;
        }
        String str2 = this.prefix;
        return new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(str).length()).append(str2).append(" - ").append(str).toString();
    }

    private static String zzi(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void info(String str) {
        this.aQZ.zzb(zza.INFO, this.aYu, zzi(str, new Object[0]), zzcun());
    }

    public void warn(String str) {
        zzf(str, null);
    }

    public void zza(String str, Throwable th, Object... objArr) {
        if (zzcum()) {
            String zzi = zzi(str, objArr);
            if (th != null) {
                String valueOf = String.valueOf(zzi(th));
                zzi = new StringBuilder(String.valueOf(zzi).length() + 1 + String.valueOf(valueOf).length()).append(zzi).append("\n").append(valueOf).toString();
            }
            this.aQZ.zzb(zza.DEBUG, this.aYu, zzi, zzcun());
        }
    }

    public boolean zzcum() {
        return this.aQZ.zzcpl().ordinal() <= zza.DEBUG.ordinal();
    }

    public void zze(String str, Throwable th) {
        String valueOf = String.valueOf(zzi(str, new Object[0]));
        String valueOf2 = String.valueOf(zzi(th));
        this.aQZ.zzb(zza.ERROR, this.aYu, new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("\n").append(valueOf2).toString(), zzcun());
    }

    public void zzf(String str, Throwable th) {
        String zzi = zzi(str, new Object[0]);
        if (th != null) {
            String valueOf = String.valueOf(zzi(th));
            zzi = new StringBuilder(String.valueOf(zzi).length() + 1 + String.valueOf(valueOf).length()).append(zzi).append("\n").append(valueOf).toString();
        }
        this.aQZ.zzb(zza.WARN, this.aYu, zzi, zzcun());
    }

    public void zzh(String str, Object... objArr) {
        zza(str, null, objArr);
    }
}
