package com.google.android.gms.internal;

public final class zzaoe implements zzanl {
    private final zzans beb;

    public zzaoe(zzans zzans) {
        this.beb = zzans;
    }

    static zzank<?> zza(zzans zzans, zzams zzams, zzaoo<?> zzaoo, zzanm zzanm) {
        Class value = zzanm.value();
        if (zzank.class.isAssignableFrom(value)) {
            return (zzank) zzans.zzb(zzaoo.zzr(value)).a();
        }
        if (zzanl.class.isAssignableFrom(value)) {
            return ((zzanl) zzans.zzb(zzaoo.zzr(value)).a()).zza(zzams, zzaoo);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
        zzanm zzanm = (zzanm) zzaoo.s().getAnnotation(zzanm.class);
        if (zzanm == null) {
            return null;
        }
        return zza(this.beb, zzams, zzaoo, zzanm);
    }
}
