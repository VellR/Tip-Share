package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzaig {
    private final List<String> aVX = new ArrayList();
    private int aVY = 0;

    private zzaig(zzahr zzahr) throws DatabaseException {
        Iterator it = zzahr.iterator();
        while (it.hasNext()) {
            this.aVX.add(((zzaka) it.next()).asString());
        }
        this.aVY = Math.max(1, this.aVX.size());
        for (int i = 0; i < this.aVX.size(); i++) {
            this.aVY = zzc((CharSequence) this.aVX.get(i)) + this.aVY;
        }
        zzciw();
    }

    public static void zza(zzahr zzahr, Object obj) throws DatabaseException {
        new zzaig(zzahr).zzbq(obj);
    }

    private void zzbq(Object obj) throws DatabaseException {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                if (!str.startsWith(".")) {
                    zzrl(str);
                    zzbq(map.get(str));
                    zzcrz();
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                zzrl(Integer.toString(i));
                zzbq(list.get(i));
                zzcrz();
            }
        }
    }

    private static int zzc(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else if (charAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    private void zzciw() throws DatabaseException {
        if (this.aVY > 768) {
            String valueOf = String.valueOf("Data has a key path longer than 768 bytes (");
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 13).append(valueOf).append(this.aVY).append(").").toString());
        } else if (this.aVX.size() > 32) {
            String valueOf2 = String.valueOf("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle ");
            String valueOf3 = String.valueOf(zzcsa());
            throw new DatabaseException(valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
        }
    }

    private String zzcrz() {
        String str = (String) this.aVX.remove(this.aVX.size() - 1);
        this.aVY -= zzc(str);
        if (this.aVX.size() > 0) {
            this.aVY--;
        }
        return str;
    }

    private String zzcsa() {
        if (this.aVX.size() == 0) {
            return "";
        }
        String valueOf = String.valueOf(zzd("/", this.aVX));
        return new StringBuilder(String.valueOf(valueOf).length() + 10).append("in path '").append(valueOf).append("'").toString();
    }

    private static String zzd(String str, List<String> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return sb.toString();
            }
            if (i2 > 0) {
                sb.append(str);
            }
            sb.append((String) list.get(i2));
            i = i2 + 1;
        }
    }

    private void zzrl(String str) throws DatabaseException {
        if (this.aVX.size() > 0) {
            this.aVY++;
        }
        this.aVX.add(str);
        this.aVY += zzc(str);
        zzciw();
    }
}
