package com.google.android.gms.internal;

import android.util.Base64;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

class zzakz {
    private URI aZE = null;
    private String aZT = null;
    private Map<String, String> aZU = null;
    private String protocol = null;

    public zzakz(URI uri, String str, Map<String, String> map) {
        this.aZE = uri;
        this.protocol = str;
        this.aZU = map;
        this.aZT = zzcwi();
    }

    private String zza(LinkedHashMap<String, String> linkedHashMap) {
        String str = new String();
        Iterator it = linkedHashMap.keySet().iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            String str3 = (String) it.next();
            String valueOf = String.valueOf(str2);
            String str4 = (String) linkedHashMap.get(str3);
            str = new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(str3).length() + String.valueOf(str4).length()).append(valueOf).append(str3).append(": ").append(str4).append("\r\n").toString();
        }
    }

    private int zzab(int i, int i2) {
        return (int) ((Math.random() * ((double) i2)) + ((double) i));
    }

    private String zzcwi() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) zzab(0, 255);
        }
        return Base64.encodeToString(bArr, 2);
    }

    public void zzc(HashMap<String, String> hashMap) {
        if (!((String) hashMap.get("Upgrade")).toLowerCase(Locale.US).equals("websocket")) {
            throw new zzaky("connection failed: missing header field in server handshake: Upgrade");
        } else if (!((String) hashMap.get("Connection")).toLowerCase(Locale.US).equals("upgrade")) {
            throw new zzaky("connection failed: missing header field in server handshake: Connection");
        }
    }

    public byte[] zzcwh() {
        String str;
        String path = this.aZE.getPath();
        String query = this.aZE.getQuery();
        String valueOf = String.valueOf(path);
        if (query == null) {
            str = "";
        } else {
            String str2 = "?";
            String valueOf2 = String.valueOf(query);
            str = valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2);
        }
        String valueOf3 = String.valueOf(str);
        String str3 = valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf);
        String host = this.aZE.getHost();
        if (this.aZE.getPort() != -1) {
            String valueOf4 = String.valueOf(host);
            host = new StringBuilder(String.valueOf(valueOf4).length() + 12).append(valueOf4).append(":").append(this.aZE.getPort()).toString();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Host", host);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.aZT);
        if (this.protocol != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", this.protocol);
        }
        if (this.aZU != null) {
            for (String str4 : this.aZU.keySet()) {
                if (!linkedHashMap.containsKey(str4)) {
                    linkedHashMap.put(str4, (String) this.aZU.get(str4));
                }
            }
        }
        String valueOf5 = String.valueOf(new StringBuilder(String.valueOf(str3).length() + 15).append("GET ").append(str3).append(" HTTP/1.1\r\n").toString());
        String valueOf6 = String.valueOf(zza(linkedHashMap));
        String concat = String.valueOf(valueOf6.length() != 0 ? valueOf5.concat(valueOf6) : new String(valueOf5)).concat("\r\n");
        byte[] bArr = new byte[concat.getBytes().length];
        System.arraycopy(concat.getBytes(), 0, bArr, 0, concat.getBytes().length);
        return bArr;
    }

    public void zzro(String str) {
        int intValue = Integer.valueOf(str.substring(9, 12)).intValue();
        if (intValue == 407) {
            throw new zzaky("connection failed: proxy authentication not supported");
        } else if (intValue == 404) {
            throw new zzaky("connection failed: 404 not found");
        } else if (intValue != 101) {
            throw new zzaky("connection failed: unknown status code " + intValue);
        }
    }
}
