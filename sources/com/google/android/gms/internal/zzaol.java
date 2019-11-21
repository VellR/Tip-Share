package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class zzaol extends zzank<Time> {
    public static final zzanl bfE = new zzanl() {
        public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
            if (zzaoo.s() == Time.class) {
                return new zzaol();
            }
            return null;
        }
    };
    private final DateFormat bge = new SimpleDateFormat("hh:mm:ss a");

    public synchronized void zza(zzaor zzaor, Time time) throws IOException {
        zzaor.zztb(time == null ? null : this.bge.format(time));
    }

    /* renamed from: zzn */
    public synchronized Time zzb(zzaop zzaop) throws IOException {
        Time time;
        if (zzaop.h() == zzaoq.NULL) {
            zzaop.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.bge.parse(zzaop.nextString()).getTime());
            } catch (ParseException e) {
                throw new zzanh((Throwable) e);
            }
        }
        return time;
    }
}
