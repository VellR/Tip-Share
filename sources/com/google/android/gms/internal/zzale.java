package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Map;

public class zzale {
    private final String Nl;
    private final String apC;

    public zzale(String str, String str2) {
        this.apC = str;
        this.Nl = str2;
    }

    public static zzale zzrp(String str) {
        if (!str.startsWith("gauth|")) {
            return null;
        }
        try {
            Map zzrq = zzalf.zzrq(str.substring("gauth|".length()));
            return new zzale((String) zzrq.get("token"), (String) zzrq.get("uid"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse gauth token", e);
        }
    }

    public String getToken() {
        return this.apC;
    }

    public String getUid() {
        return this.Nl;
    }
}
