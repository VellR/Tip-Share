package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class zzamn implements zzamx<Date>, zzang<Date> {
    private final DateFormat bdO;
    private final DateFormat bdP;
    private final DateFormat bdQ;

    zzamn() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public zzamn(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    zzamn(String str) {
        this((DateFormat) new SimpleDateFormat(str, Locale.US), (DateFormat) new SimpleDateFormat(str));
    }

    zzamn(DateFormat dateFormat, DateFormat dateFormat2) {
        this.bdO = dateFormat;
        this.bdP = dateFormat2;
        this.bdQ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.bdQ.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date zza(zzamy zzamy) {
        Date parse;
        synchronized (this.bdP) {
            try {
                parse = this.bdP.parse(zzamy.zzczh());
            } catch (ParseException e) {
                throw new zzanh(zzamy.zzczh(), e);
            } catch (ParseException e2) {
                try {
                    parse = this.bdO.parse(zzamy.zzczh());
                } catch (ParseException e3) {
                    parse = this.bdQ.parse(zzamy.zzczh());
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(zzamn.class.getSimpleName());
        sb.append('(').append(this.bdP.getClass().getSimpleName()).append(')');
        return sb.toString();
    }

    public zzamy zza(Date date, Type type, zzanf zzanf) {
        zzane zzane;
        synchronized (this.bdP) {
            zzane = new zzane(this.bdO.format(date));
        }
        return zzane;
    }

    /* renamed from: zza */
    public Date zzb(zzamy zzamy, Type type, zzamw zzamw) throws zzanc {
        if (!(zzamy instanceof zzane)) {
            throw new zzanc("The date should be a string value");
        }
        Date zza = zza(zzamy);
        if (type == Date.class) {
            return zza;
        }
        if (type == Timestamp.class) {
            return new Timestamp(zza.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(zza.getTime());
        }
        String valueOf = String.valueOf(getClass());
        String valueOf2 = String.valueOf(type);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot deserialize to ").append(valueOf2).toString());
    }
}
