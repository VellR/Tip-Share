package com.google.android.gms.internal;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzahd {
    private static long aSc = 0;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService aPL;
    /* access modifiers changed from: private */
    public final zzajx aPY;
    /* access modifiers changed from: private */
    public zzb aSd;
    /* access modifiers changed from: private */
    public boolean aSe = false;
    private boolean aSf = false;
    private long aSg = 0;
    private zzahf aSh;
    private zza aSi;
    private ScheduledFuture<?> aSj;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> aSk;
    private final zzagv aSl;

    public interface zza {
        void zzbp(Map<String, Object> map);

        void zzco(boolean z);
    }

    private interface zzb {
        void close();

        void connect();

        void zzrf(String str);
    }

    private class zzc implements zzb, zzakx {
        private zzakw aSn;

        private zzc(zzakw zzakw) {
            this.aSn = zzakw;
            this.aSn.zza((zzakx) this);
        }

        private void shutdown() {
            this.aSn.close();
            try {
                this.aSn.zzcwe();
            } catch (InterruptedException e) {
                zzahd.this.aPY.zze("Interrupted while shutting down websocket threads", e);
            }
        }

        public void close() {
            this.aSn.close();
        }

        public void connect() {
            try {
                this.aSn.connect();
            } catch (zzaky e) {
                if (zzahd.this.aPY.zzcum()) {
                    zzahd.this.aPY.zza("Error connecting", e, new Object[0]);
                }
                shutdown();
            }
        }

        public void onClose() {
            String str = "closed";
            zzahd.this.aPL.execute(new Runnable() {
                public void run() {
                    if (zzahd.this.aPY.zzcum()) {
                        zzahd.this.aPY.zzh("closed", new Object[0]);
                    }
                    zzahd.this.zzcpi();
                }
            });
        }

        public void zza(final zzaky zzaky) {
            zzahd.this.aPL.execute(new Runnable() {
                public void run() {
                    String str = "had an error";
                    if (zzahd.this.aPY.zzcum()) {
                        zzahd.this.aPY.zza(str, zzaky, new Object[0]);
                    }
                    if (zzaky.getMessage().startsWith("unknown host")) {
                        if (zzahd.this.aPY.zzcum()) {
                            zzahd.this.aPY.zzh("If you are running on Android, have you added <uses-permission android:name=\"android.permission.INTERNET\" /> under <manifest> in AndroidManifest.xml?", new Object[0]);
                        }
                    } else if (zzahd.this.aPY.zzcum()) {
                        zzajx zzb = zzahd.this.aPY;
                        String valueOf = String.valueOf(zzaky.getMessage());
                        zzb.zzh(new StringBuilder(String.valueOf(valueOf).length() + 2).append("|").append(valueOf).append("|").toString(), new Object[0]);
                    }
                    zzahd.this.zzcpi();
                }
            });
        }

        public void zza(zzala zzala) {
            final String text = zzala.getText();
            if (zzahd.this.aPY.zzcum()) {
                zzajx zzb = zzahd.this.aPY;
                String str = "ws message: ";
                String valueOf = String.valueOf(text);
                zzb.zzh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
            }
            zzahd.this.aPL.execute(new Runnable() {
                public void run() {
                    zzahd.this.zzre(text);
                }
            });
        }

        public void zzcpk() {
            zzahd.this.aPL.execute(new Runnable() {
                public void run() {
                    zzahd.this.aSk.cancel(false);
                    zzahd.this.aSe = true;
                    if (zzahd.this.aPY.zzcum()) {
                        zzahd.this.aPY.zzh("websocket opened", new Object[0]);
                    }
                    zzahd.this.zzcpg();
                }
            });
        }

        public void zzrf(String str) {
            this.aSn.zzrf(str);
        }
    }

    public zzahd(zzagv zzagv, zzagx zzagx, String str, zza zza2, String str2) {
        this.aSl = zzagv;
        this.aPL = zzagv.zzcoc();
        this.aSi = zza2;
        long j = aSc;
        aSc = 1 + j;
        this.aPY = new zzajx(zzagv.zzcoa(), "WebSocket", "ws_" + j);
        this.aSd = zza(zzagx, str, str2);
    }

    private boolean isBuffering() {
        return this.aSh != null;
    }

    private void shutdown() {
        this.aSf = true;
        this.aSi.zzco(this.aSe);
    }

    private zzb zza(zzagx zzagx, String str, String str2) {
        if (str == null) {
            str = zzagx.getHost();
        }
        URI zza2 = zzagx.zza(str, zzagx.isSecure(), zzagx.getNamespace(), str2);
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.aSl.zzsp());
        return new zzc(new zzakw(zza2, null, hashMap));
    }

    private static String[] zzad(String str, int i) {
        int i2 = 0;
        if (str.length() <= i) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            arrayList.add(str.substring(i2, Math.min(i2 + i, str.length())));
            i2 += i;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private void zzadj(int i) {
        this.aSg = (long) i;
        this.aSh = new zzahf();
        if (this.aPY.zzcum()) {
            this.aPY.zzh("HandleNewFrameCount: " + this.aSg, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void zzcpg() {
        if (!this.aSf) {
            if (this.aSj != null) {
                this.aSj.cancel(false);
                if (this.aPY.zzcum()) {
                    this.aPY.zzh("Reset keepAlive. Remaining: " + this.aSj.getDelay(TimeUnit.MILLISECONDS), new Object[0]);
                }
            } else if (this.aPY.zzcum()) {
                this.aPY.zzh("Reset keepAlive", new Object[0]);
            }
            this.aSj = this.aPL.schedule(zzcph(), 45000, TimeUnit.MILLISECONDS);
        }
    }

    private Runnable zzcph() {
        return new Runnable() {
            public void run() {
                if (zzahd.this.aSd != null) {
                    zzahd.this.aSd.zzrf("0");
                    zzahd.this.zzcpg();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void zzcpi() {
        if (!this.aSf) {
            if (this.aPY.zzcum()) {
                this.aPY.zzh("closing itself", new Object[0]);
            }
            shutdown();
        }
        this.aSd = null;
        if (this.aSj != null) {
            this.aSj.cancel(false);
        }
    }

    /* access modifiers changed from: private */
    public void zzcpj() {
        if (!this.aSe && !this.aSf) {
            if (this.aPY.zzcum()) {
                this.aPY.zzh("timed out on connect", new Object[0]);
            }
            this.aSd.close();
        }
    }

    private void zzrc(String str) {
        this.aSh.zzrg(str);
        this.aSg--;
        if (this.aSg == 0) {
            try {
                this.aSh.zzcpp();
                Map zzrq = zzalf.zzrq(this.aSh.toString());
                this.aSh = null;
                if (this.aPY.zzcum()) {
                    zzajx zzajx = this.aPY;
                    String valueOf = String.valueOf(zzrq);
                    zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 36).append("handleIncomingFrame complete frame: ").append(valueOf).toString(), new Object[0]);
                }
                this.aSi.zzbp(zzrq);
            } catch (IOException e) {
                IOException iOException = e;
                zzajx zzajx2 = this.aPY;
                String str2 = "Error parsing frame: ";
                String valueOf2 = String.valueOf(this.aSh.toString());
                zzajx2.zze(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), iOException);
                close();
                shutdown();
            } catch (ClassCastException e2) {
                ClassCastException classCastException = e2;
                zzajx zzajx3 = this.aPY;
                String str3 = "Error parsing frame (cast error): ";
                String valueOf3 = String.valueOf(this.aSh.toString());
                zzajx3.zze(valueOf3.length() != 0 ? str3.concat(valueOf3) : new String(str3), classCastException);
                close();
                shutdown();
            }
        }
    }

    private String zzrd(String str) {
        if (str.length() <= 6) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt > 0) {
                    zzadj(parseInt);
                }
                return null;
            } catch (NumberFormatException e) {
            }
        }
        zzadj(1);
        return str;
    }

    /* access modifiers changed from: private */
    public void zzre(String str) {
        if (!this.aSf) {
            zzcpg();
            if (isBuffering()) {
                zzrc(str);
                return;
            }
            String zzrd = zzrd(str);
            if (zzrd != null) {
                zzrc(zzrd);
            }
        }
    }

    public void close() {
        if (this.aPY.zzcum()) {
            this.aPY.zzh("websocket is being closed", new Object[0]);
        }
        this.aSf = true;
        this.aSd.close();
        if (this.aSk != null) {
            this.aSk.cancel(true);
        }
        if (this.aSj != null) {
            this.aSj.cancel(true);
        }
    }

    public void open() {
        this.aSd.connect();
        this.aSk = this.aPL.schedule(new Runnable() {
            public void run() {
                zzahd.this.zzcpj();
            }
        }, 30000, TimeUnit.MILLISECONDS);
    }

    public void send(Map<String, Object> map) {
        zzcpg();
        try {
            String[] zzad = zzad(zzalf.zzcb(map), 16384);
            if (zzad.length > 1) {
                this.aSd.zzrf(zzad.length);
            }
            for (String zzrf : zzad) {
                this.aSd.zzrf(zzrf);
            }
        } catch (IOException e) {
            IOException iOException = e;
            zzajx zzajx = this.aPY;
            String str = "Failed to serialize message: ";
            String valueOf = String.valueOf(map.toString());
            zzajx.zze(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), iOException);
            shutdown();
        }
    }

    public void start() {
    }
}
