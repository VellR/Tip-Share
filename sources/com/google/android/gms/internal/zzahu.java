package com.google.android.gms.internal;

public class zzahu {
    public String aRd;
    public boolean aRe;
    public String aUX;
    public String zl;

    public String toString() {
        String str = this.aRe ? "s" : "";
        String str2 = this.aRd;
        return new StringBuilder(String.valueOf(str).length() + 7 + String.valueOf(str2).length()).append("http").append(str).append("://").append(str2).toString();
    }
}
