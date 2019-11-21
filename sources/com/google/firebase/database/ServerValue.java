package com.google.firebase.database;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ServerValue {
    public static final Map<String, String> TIMESTAMP = zzqs("timestamp");

    private static Map<String, String> zzqs(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(".sv", str);
        return Collections.unmodifiableMap(hashMap);
    }
}
