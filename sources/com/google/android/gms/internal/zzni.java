package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzab;

public class zzni implements ProxyApi {
    public PendingResult<ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, final ProxyRequest proxyRequest) {
        zzab.zzaa(googleApiClient);
        zzab.zzaa(proxyRequest);
        return googleApiClient.zzd(new zznh(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzng zzng) throws RemoteException {
                zzng.zza((zznf) new zznd() {
                    public void zza(ProxyResponse proxyResponse) {
                        AnonymousClass1.this.zzc(new zznj(proxyResponse));
                    }
                }, proxyRequest);
            }
        });
    }
}
