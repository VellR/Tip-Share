package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.api.model.StringList;
import java.io.IOException;
import java.util.List;

public class zzafq extends zzank<StringList> {
    private zzams aNm;

    public void zza(@NonNull zzams zzams) {
        this.aNm = (zzams) zzab.zzaa(zzams);
    }

    public void zza(zzaor zzaor, StringList stringList) throws IOException {
        if (stringList == null) {
            zzaor.r();
            return;
        }
        zzank zzk = this.aNm.zzk(String.class);
        zzaor.n();
        List zzclt = stringList.zzclt();
        int size = zzclt != null ? zzclt.size() : 0;
        for (int i = 0; i < size; i++) {
            zzk.zza(zzaor, (String) zzclt.get(i));
        }
        zzaor.o();
    }

    /* renamed from: zzd */
    public StringList zzb(zzaop zzaop) throws IOException {
        if (zzaop.h() == zzaoq.NULL) {
            zzaop.nextNull();
            return null;
        }
        StringList stringList = new StringList();
        zzank zzk = this.aNm.zzk(String.class);
        zzaop.beginArray();
        while (zzaop.hasNext()) {
            stringList.zzclt().add((String) zzk.zzb(zzaop));
        }
        zzaop.endArray();
        return stringList;
    }
}
