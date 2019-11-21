package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class zzajd<T> {
    public T aQx;
    public Map<zzaka, zzajd<T>> aVh = new HashMap();

    /* access modifiers changed from: 0000 */
    public String toString(String str) {
        String valueOf = String.valueOf(this.aQx);
        String sb = new StringBuilder(String.valueOf(str).length() + 10 + String.valueOf(valueOf).length()).append(str).append("<value>: ").append(valueOf).append("\n").toString();
        if (this.aVh.isEmpty()) {
            return new StringBuilder(String.valueOf(sb).length() + 7 + String.valueOf(str).length()).append(sb).append(str).append("<empty>").toString();
        }
        Iterator it = this.aVh.entrySet().iterator();
        while (true) {
            String str2 = sb;
            if (!it.hasNext()) {
                return str2;
            }
            Entry entry = (Entry) it.next();
            String valueOf2 = String.valueOf(str2);
            String valueOf3 = String.valueOf(entry.getKey());
            String valueOf4 = String.valueOf(((zzajd) entry.getValue()).toString(String.valueOf(str).concat("\t")));
            sb = new StringBuilder(String.valueOf(valueOf2).length() + 3 + String.valueOf(str).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length()).append(valueOf2).append(str).append(valueOf3).append(":\n").append(valueOf4).append("\n").toString();
        }
    }
}
