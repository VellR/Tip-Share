package com.google.android.gms.internal;

import com.google.firebase.auth.api.model.GetAccountInfoUserList;
import com.google.firebase.auth.api.model.ProviderUserInfoList;
import com.google.firebase.auth.api.model.StringList;

public class zzafi {
    public static zzams zzcla() {
        zzafh zzafh = new zzafh();
        zzafq zzafq = new zzafq();
        zzafp zzafp = new zzafp();
        zzams zzczf = new zzamt().zzd(8, 128, 64).zzcze().zza(new zzafc()).zza(GetAccountInfoUserList.class, zzafh).zza(StringList.class, zzafq).zza(ProviderUserInfoList.class, zzafp).zzczf();
        zzafh.zza(zzczf);
        zzafq.zza(zzczf);
        zzafp.zza(zzczf);
        return zzczf;
    }
}
