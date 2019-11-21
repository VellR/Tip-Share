package com.google.android.gms.internal;

import java.math.BigInteger;

public final class zzane extends zzamy {
    private static final Class<?>[] beu = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object aQx;

    public zzane(Boolean bool) {
        setValue(bool);
    }

    public zzane(Number number) {
        setValue(number);
    }

    public zzane(String str) {
        setValue(str);
    }

    private static boolean zza(zzane zzane) {
        if (!(zzane.aQx instanceof Number)) {
            return false;
        }
        Number number = (Number) zzane.aQx;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean zzck(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class<?> isAssignableFrom : beu) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzane zzane = (zzane) obj;
        if (this.aQx == null) {
            return zzane.aQx == null;
        }
        if (zza(this) && zza(zzane)) {
            return zzczg().longValue() == zzane.zzczg().longValue();
        }
        if (!(this.aQx instanceof Number) || !(zzane.aQx instanceof Number)) {
            return this.aQx.equals(zzane.aQx);
        }
        double doubleValue = zzczg().doubleValue();
        double doubleValue2 = zzane.zzczg().doubleValue();
        if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        if (this.aQx == null) {
            return 31;
        }
        if (zza(this)) {
            long longValue = zzczg().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.aQx instanceof Number)) {
            return this.aQx.hashCode();
        } else {
            long doubleToLongBits = Double.doubleToLongBits(zzczg().doubleValue());
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }
    }

    /* access modifiers changed from: 0000 */
    public void setValue(Object obj) {
        if (obj instanceof Character) {
            this.aQx = String.valueOf(((Character) obj).charValue());
            return;
        }
        zzanq.zzbn((obj instanceof Number) || zzck(obj));
        this.aQx = obj;
    }

    public Number zzczg() {
        return this.aQx instanceof String ? new zzanv((String) this.aQx) : (Number) this.aQx;
    }

    public String zzczh() {
        return zzczv() ? zzczg().toString() : zzczu() ? zzczt().toString() : (String) this.aQx;
    }

    public double zzczi() {
        return zzczv() ? zzczg().doubleValue() : Double.parseDouble(zzczh());
    }

    public long zzczj() {
        return zzczv() ? zzczg().longValue() : Long.parseLong(zzczh());
    }

    public int zzczk() {
        return zzczv() ? zzczg().intValue() : Integer.parseInt(zzczh());
    }

    public boolean zzczl() {
        return zzczu() ? zzczt().booleanValue() : Boolean.parseBoolean(zzczh());
    }

    /* access modifiers changed from: 0000 */
    public Boolean zzczt() {
        return (Boolean) this.aQx;
    }

    public boolean zzczu() {
        return this.aQx instanceof Boolean;
    }

    public boolean zzczv() {
        return this.aQx instanceof Number;
    }

    public boolean zzczw() {
        return this.aQx instanceof String;
    }
}
