package com.google.android.gms.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class zzaod extends zzank<Date> {
    public static final zzanl bfE = new zzanl() {
        public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
            if (zzaoo.s() == Date.class) {
                return new zzaod();
            }
            return null;
        }
    };
    private final DateFormat bdO = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat bdP = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat bdQ = g();

    private static DateFormat g() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date zzsz(String str) {
        Date parse;
        try {
            parse = this.bdP.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.bdO.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.bdQ.parse(str);
                } catch (ParseException e3) {
                    throw new zzanh(str, e3);
                }
            }
        }
        return parse;
    }

    public synchronized void zza(zzaor zzaor, Date date) throws IOException {
        if (date == null) {
            zzaor.r();
        } else {
            zzaor.zztb(this.bdO.format(date));
        }
    }

    /* renamed from: zzk */
    public Date zzb(zzaop zzaop) throws IOException {
        if (zzaop.h() != zzaoq.NULL) {
            return zzsz(zzaop.nextString());
        }
        zzaop.nextNull();
        return null;
    }
}
