package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProxyRequest extends AbstractSafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new zzb();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    public final byte[] body;
    Bundle dv;
    public final int httpMethod;
    public final long timeoutMillis;
    public final String url;
    final int versionCode;

    public static class Builder {
        private Bundle dA = new Bundle();
        private String dw;
        private int dx = ProxyRequest.HTTP_METHOD_GET;
        private long dy = 3000;
        private byte[] dz = null;

        public Builder(String str) {
            zzab.zzhs(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.dw = str;
                return;
            }
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 51).append("The supplied url [ ").append(str).append("] is not match Patterns.WEB_URL!").toString());
        }

        public ProxyRequest build() {
            if (this.dz == null) {
                this.dz = new byte[0];
            }
            return new ProxyRequest(2, this.dw, this.dx, this.dy, this.dz, this.dA);
        }

        public Builder putHeader(String str, String str2) {
            zzab.zzh(str, "Header name cannot be null or empty!");
            Bundle bundle = this.dA;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.dz = bArr;
            return this;
        }

        public Builder setHttpMethod(int i) {
            zzab.zzb(i >= 0 && i <= ProxyRequest.LAST_CODE, (Object) "Unrecognized http method code.");
            this.dx = i;
            return this;
        }

        public Builder setTimeoutMillis(long j) {
            zzab.zzb(j >= 0, (Object) "The specified timeout must be non-negative.");
            this.dy = j;
            return this;
        }
    }

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.dv = bundle;
    }

    public Map<String, String> getHeaderMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.dv.size());
        for (String str : this.dv.keySet()) {
            linkedHashMap.put(str, this.dv.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = this.url;
        return new StringBuilder(String.valueOf(str).length() + 42).append("ProxyRequest[ url: ").append(str).append(", method: ").append(this.httpMethod).append(" ]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
