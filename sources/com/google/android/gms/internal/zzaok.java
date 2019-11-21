package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class zzaok extends zzank<Date> {
    public static final zzanl bfE = new zzanl() {
        public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
            if (zzaoo.s() == Date.class) {
                return new zzaok();
            }
            return null;
        }
    };
    private final DateFormat bge = new SimpleDateFormat("MMM d, yyyy");

    public synchronized void zza(zzaor zzaor, Date date) throws IOException {
        zzaor.zztb(date == null ? null : this.bge.format(date));
    }

    /* renamed from: zzm */
    public synchronized Date zzb(zzaop zzaop) throws IOException {
        Date date;
        if (zzaop.h() == zzaoq.NULL) {
            zzaop.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.bge.parse(zzaop.nextString()).getTime());
            } catch (ParseException e) {
                throw new zzanh((Throwable) e);
            }
        }
        return date;
    }
}
