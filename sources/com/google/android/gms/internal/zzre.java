package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzre<T> {
    private static zza vA = null;
    private static int vB = 0;
    private static String vC = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static final Object zzamp = new Object();
    private T vD = null;
    protected final String zzaxn;
    protected final T zzaxo;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzre(String str, T t) {
        this.zzaxn = str;
        this.zzaxo = t;
    }

    public static zzre<Float> zza(String str, Float f) {
        return new zzre<Float>(str, f) {
            /* access modifiers changed from: protected */
            /* renamed from: zzhd */
            public Float zzgz(String str) {
                return zzre.zzaqx().zzb(this.zzaxn, (Float) this.zzaxo);
            }
        };
    }

    public static zzre<Integer> zza(String str, Integer num) {
        return new zzre<Integer>(str, num) {
            /* access modifiers changed from: protected */
            /* renamed from: zzhc */
            public Integer zzgz(String str) {
                return zzre.zzaqx().zzb(this.zzaxn, (Integer) this.zzaxo);
            }
        };
    }

    public static zzre<Long> zza(String str, Long l) {
        return new zzre<Long>(str, l) {
            /* access modifiers changed from: protected */
            /* renamed from: zzhb */
            public Long zzgz(String str) {
                return zzre.zzaqx().getLong(this.zzaxn, (Long) this.zzaxo);
            }
        };
    }

    public static zzre<String> zzab(String str, String str2) {
        return new zzre<String>(str, str2) {
            /* access modifiers changed from: protected */
            /* renamed from: zzhe */
            public String zzgz(String str) {
                return zzre.zzaqx().getString(this.zzaxn, (String) this.zzaxo);
            }
        };
    }

    static /* synthetic */ zza zzaqx() {
        return null;
    }

    public static zzre<Boolean> zzm(String str, boolean z) {
        return new zzre<Boolean>(str, Boolean.valueOf(z)) {
            /* access modifiers changed from: protected */
            /* renamed from: zzha */
            public Boolean zzgz(String str) {
                return zzre.zzaqx().zza(this.zzaxn, (Boolean) this.zzaxo);
            }
        };
    }

    public final T get() {
        long clearCallingIdentity;
        try {
            return zzgz(this.zzaxn);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            T zzgz = zzgz(this.zzaxn);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzgz;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public abstract T zzgz(String str);
}
