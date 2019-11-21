package com.google.android.gms.internal;

import java.net.URI;

public class zzagx {
    private final String aRd;
    private final boolean aRe;
    private final String zl;

    public zzagx(String str, String str2, boolean z) {
        this.aRd = str;
        this.zl = str2;
        this.aRe = z;
    }

    public static URI zza(String str, boolean z, String str2, String str3) {
        String str4 = z ? "wss" : "ws";
        String valueOf = String.valueOf("v");
        String valueOf2 = String.valueOf("5");
        String sb = new StringBuilder(String.valueOf(str4).length() + 13 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length()).append(str4).append("://").append(str).append("/.ws?ns=").append(str2).append("&").append(valueOf).append("=").append(valueOf2).toString();
        if (str3 != null) {
            String valueOf3 = String.valueOf(sb);
            String valueOf4 = String.valueOf("&ls=");
            sb = new StringBuilder(String.valueOf(valueOf3).length() + 0 + String.valueOf(valueOf4).length() + String.valueOf(str3).length()).append(valueOf3).append(valueOf4).append(str3).toString();
        }
        return URI.create(sb);
    }

    public String getHost() {
        return this.aRd;
    }

    public String getNamespace() {
        return this.zl;
    }

    public boolean isSecure() {
        return this.aRe;
    }

    public String toString() {
        String str = this.aRe ? "s" : "";
        String str2 = this.aRd;
        return new StringBuilder(String.valueOf(str).length() + 7 + String.valueOf(str2).length()).append("http").append(str).append("://").append(str2).toString();
    }
}
