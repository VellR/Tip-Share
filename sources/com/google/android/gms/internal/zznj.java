package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

class zznj implements ProxyResult {
    private Status cc;
    private ProxyResponse dE;

    public zznj(ProxyResponse proxyResponse) {
        this.dE = proxyResponse;
        this.cc = Status.sg;
    }

    public zznj(Status status) {
        this.cc = status;
    }

    public ProxyResponse getResponse() {
        return this.dE;
    }

    public Status getStatus() {
        return this.cc;
    }
}
