package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.api.model.ProviderUserInfo;
import com.google.firebase.auth.api.model.ProviderUserInfoList;
import java.io.IOException;
import java.util.List;

public class zzafp extends zzank<ProviderUserInfoList> {
    private zzams aNm;

    public void zza(@NonNull zzams zzams) {
        this.aNm = (zzams) zzab.zzaa(zzams);
    }

    public void zza(zzaor zzaor, ProviderUserInfoList providerUserInfoList) throws IOException {
        if (providerUserInfoList == null) {
            zzaor.r();
            return;
        }
        zzank zzk = this.aNm.zzk(ProviderUserInfo.class);
        zzaor.n();
        List zzclk = providerUserInfoList.zzclk();
        int size = zzclk != null ? zzclk.size() : 0;
        for (int i = 0; i < size; i++) {
            zzk.zza(zzaor, (ProviderUserInfo) zzclk.get(i));
        }
        zzaor.o();
    }

    /* renamed from: zzc */
    public ProviderUserInfoList zzb(zzaop zzaop) throws IOException {
        if (zzaop.h() == zzaoq.NULL) {
            zzaop.nextNull();
            return null;
        }
        ProviderUserInfoList providerUserInfoList = new ProviderUserInfoList();
        zzank zzk = this.aNm.zzk(ProviderUserInfo.class);
        zzaop.beginArray();
        while (zzaop.hasNext()) {
            providerUserInfoList.zzclk().add((ProviderUserInfo) zzk.zzb(zzaop));
        }
        zzaop.endArray();
        return providerUserInfoList;
    }
}
