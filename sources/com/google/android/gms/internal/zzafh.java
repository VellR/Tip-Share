package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetAccountInfoUserList;
import java.io.IOException;
import java.util.List;

public class zzafh extends zzank<GetAccountInfoUserList> {
    private zzams aNm;

    /* renamed from: zza */
    public GetAccountInfoUserList zzb(zzaop zzaop) throws IOException {
        if (zzaop.h() == zzaoq.NULL) {
            zzaop.nextNull();
            return null;
        }
        GetAccountInfoUserList getAccountInfoUserList = new GetAccountInfoUserList();
        zzank zzk = this.aNm.zzk(GetAccountInfoUser.class);
        zzaop.beginArray();
        while (zzaop.hasNext()) {
            getAccountInfoUserList.zzclm().add((GetAccountInfoUser) zzk.zzb(zzaop));
        }
        zzaop.endArray();
        return getAccountInfoUserList;
    }

    public void zza(@NonNull zzams zzams) {
        this.aNm = (zzams) zzab.zzaa(zzams);
    }

    public void zza(zzaor zzaor, GetAccountInfoUserList getAccountInfoUserList) throws IOException {
        if (getAccountInfoUserList == null) {
            zzaor.r();
            return;
        }
        zzank zzk = this.aNm.zzk(GetAccountInfoUser.class);
        zzaor.n();
        List zzclm = getAccountInfoUserList.zzclm();
        int size = zzclm != null ? zzclm.size() : 0;
        for (int i = 0; i < size; i++) {
            zzk.zza(zzaor, (GetAccountInfoUser) zzclm.get(i));
        }
        zzaor.o();
    }
}
