package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

class zzagt implements com.google.android.gms.internal.zzahd.zza {
    private static long aQM = 0;
    private final zzajx aPY;
    private zzagx aQN;
    private zzahd aQO;
    private zza aQP;
    private zzc aQQ = zzc.REALTIME_CONNECTING;

    public interface zza {
        void zzb(zzb zzb);

        void zzbq(Map<String, Object> map);

        void zzj(long j, String str);

        void zzqw(String str);

        void zzqx(String str);
    }

    public enum zzb {
        SERVER_RESET,
        OTHER
    }

    private enum zzc {
        REALTIME_CONNECTING,
        REALTIME_CONNECTED,
        REALTIME_DISCONNECTED
    }

    public zzagt(zzagv zzagv, zzagx zzagx, String str, zza zza2, String str2) {
        long j = aQM;
        aQM = 1 + j;
        this.aQN = zzagx;
        this.aQP = zza2;
        this.aPY = new zzajx(zzagv.zzcoa(), "Connection", "conn_" + j);
        this.aQO = new zzahd(zzagv, zzagx, str, this, str2);
    }

    private void zzb(Map<String, Object> map, boolean z) {
        if (this.aQQ != zzc.REALTIME_CONNECTED) {
            this.aPY.zzh("Tried to send on an unconnected connection", new Object[0]);
            return;
        }
        if (z) {
            this.aPY.zzh("Sending data (contents hidden)", new Object[0]);
        } else {
            this.aPY.zzh("Sending data: %s", map);
        }
        this.aQO.send(map);
    }

    private void zzbq(Map<String, Object> map) {
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String str = "received data message: ";
            String valueOf = String.valueOf(map.toString());
            zzajx.zzh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
        }
        this.aQP.zzbq(map);
    }

    private void zzbr(Map<String, Object> map) {
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String str = "Got control message: ";
            String valueOf = String.valueOf(map.toString());
            zzajx.zzh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
        }
        try {
            String str2 = (String) map.get("t");
            if (str2 == null) {
                if (this.aPY.zzcum()) {
                    zzajx zzajx2 = this.aPY;
                    String str3 = "Got invalid control message: ";
                    String valueOf2 = String.valueOf(map.toString());
                    zzajx2.zzh(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3), new Object[0]);
                }
                close();
            } else if (str2.equals("s")) {
                zzqu((String) map.get("d"));
            } else if (str2.equals("r")) {
                zzqv((String) map.get("d"));
            } else if (str2.equals("h")) {
                zzbs((Map) map.get("d"));
            } else if (this.aPY.zzcum()) {
                zzajx zzajx3 = this.aPY;
                String str4 = "Ignoring unknown control message: ";
                String valueOf3 = String.valueOf(str2);
                zzajx3.zzh(valueOf3.length() != 0 ? str4.concat(valueOf3) : new String(str4), new Object[0]);
            }
        } catch (ClassCastException e) {
            if (this.aPY.zzcum()) {
                zzajx zzajx4 = this.aPY;
                String str5 = "Failed to parse control message: ";
                String valueOf4 = String.valueOf(e.toString());
                zzajx4.zzh(valueOf4.length() != 0 ? str5.concat(valueOf4) : new String(str5), new Object[0]);
            }
            close();
        }
    }

    private void zzbs(Map<String, Object> map) {
        long longValue = ((Long) map.get("ts")).longValue();
        this.aQP.zzqw((String) map.get("h"));
        String str = (String) map.get("s");
        if (this.aQQ == zzc.REALTIME_CONNECTING) {
            this.aQO.start();
            zzi(longValue, str);
        }
    }

    private void zzi(long j, String str) {
        if (this.aPY.zzcum()) {
            this.aPY.zzh("realtime connection established", new Object[0]);
        }
        this.aQQ = zzc.REALTIME_CONNECTED;
        this.aQP.zzj(j, str);
    }

    private void zzqu(String str) {
        if (this.aPY.zzcum()) {
            this.aPY.zzh("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.aQP.zzqx(str);
        close();
    }

    private void zzqv(String str) {
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String valueOf = String.valueOf(this.aQN.getHost());
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 62 + String.valueOf(str).length()).append("Got a reset; killing connection to ").append(valueOf).append("; Updating internalHost to ").append(str).toString(), new Object[0]);
        }
        this.aQP.zzqw(str);
        zza(zzb.SERVER_RESET);
    }

    public void close() {
        zza(zzb.OTHER);
    }

    public void open() {
        if (this.aPY.zzcum()) {
            this.aPY.zzh("Opening a connection", new Object[0]);
        }
        this.aQO.open();
    }

    public void zza(zzb zzb2) {
        if (this.aQQ != zzc.REALTIME_DISCONNECTED) {
            if (this.aPY.zzcum()) {
                this.aPY.zzh("closing realtime connection", new Object[0]);
            }
            this.aQQ = zzc.REALTIME_DISCONNECTED;
            if (this.aQO != null) {
                this.aQO.close();
                this.aQO = null;
            }
            this.aQP.zzb(zzb2);
        }
    }

    public void zza(Map<String, Object> map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("t", "d");
        hashMap.put("d", map);
        zzb(hashMap, z);
    }

    public void zzbp(Map<String, Object> map) {
        try {
            String str = (String) map.get("t");
            if (str == null) {
                if (this.aPY.zzcum()) {
                    zzajx zzajx = this.aPY;
                    String str2 = "Failed to parse server message: missing message type:";
                    String valueOf = String.valueOf(map.toString());
                    zzajx.zzh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
                }
                close();
            } else if (str.equals("d")) {
                zzbq((Map) map.get("d"));
            } else if (str.equals("c")) {
                zzbr((Map) map.get("d"));
            } else if (this.aPY.zzcum()) {
                zzajx zzajx2 = this.aPY;
                String str3 = "Ignoring unknown server message type: ";
                String valueOf2 = String.valueOf(str);
                zzajx2.zzh(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3), new Object[0]);
            }
        } catch (ClassCastException e) {
            if (this.aPY.zzcum()) {
                zzajx zzajx3 = this.aPY;
                String str4 = "Failed to parse server message: ";
                String valueOf3 = String.valueOf(e.toString());
                zzajx3.zzh(valueOf3.length() != 0 ? str4.concat(valueOf3) : new String(str4), new Object[0]);
            }
            close();
        }
    }

    public void zzco(boolean z) {
        this.aQO = null;
        if (z || this.aQQ != zzc.REALTIME_CONNECTING) {
            if (this.aPY.zzcum()) {
                this.aPY.zzh("Realtime connection lost", new Object[0]);
            }
        } else if (this.aPY.zzcum()) {
            this.aPY.zzh("Realtime connection failed", new Object[0]);
        }
        close();
    }
}
