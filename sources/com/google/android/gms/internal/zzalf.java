package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class zzalf {
    private static void zza(Object obj, JSONStringer jSONStringer) throws IOException, JSONException {
        if (obj instanceof Map) {
            jSONStringer.object();
            for (Entry entry : ((Map) obj).entrySet()) {
                jSONStringer.key((String) entry.getKey());
                zza(entry.getValue(), jSONStringer);
            }
            jSONStringer.endObject();
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            jSONStringer.array();
            for (Object zza : collection) {
                zza(zza, jSONStringer);
            }
            jSONStringer.endArray();
        } else {
            jSONStringer.value(obj);
        }
    }

    public static String zzbu(Object obj) throws IOException {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return JSONObject.quote((String) obj);
        }
        if (obj instanceof Number) {
            try {
                return JSONObject.numberToString((Number) obj);
            } catch (JSONException e) {
                throw new IOException("Could not serialize number", e);
            }
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? "true" : "false";
        } else {
            try {
                JSONStringer jSONStringer = new JSONStringer();
                zza(obj, jSONStringer);
                return jSONStringer.toString();
            } catch (JSONException e2) {
                throw new IOException("Failed to serialize JSON", e2);
            }
        }
    }

    private static Object zzbv(Object obj) throws JSONException {
        if (obj instanceof JSONObject) {
            return zzo((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return zze((JSONArray) obj);
        }
        if (obj.equals(JSONObject.NULL)) {
            return null;
        }
        return obj;
    }

    public static String zzcb(Map<String, Object> map) throws IOException {
        return zzbu(map);
    }

    private static List<Object> zze(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zzbv(jSONArray.get(i)));
        }
        return arrayList;
    }

    private static Map<String, Object> zzo(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap(jSONObject.length());
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, zzbv(jSONObject.get(str)));
        }
        return hashMap;
    }

    public static Map<String, Object> zzrq(String str) throws IOException {
        try {
            return zzo(new JSONObject(str));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public static Object zzrr(String str) throws IOException {
        try {
            return zzbv(new JSONTokener(str).nextValue());
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }
}
