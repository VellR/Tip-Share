package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.Thread.State;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class zzakw {
    private static final Charset aZA = Charset.forName("UTF-8");
    private static ThreadFactory aZJ = Executors.defaultThreadFactory();
    private static zzakv aZK = new zzakv() {
        public void zza(Thread thread, String str) {
            thread.setName(str);
        }
    };
    private static final AtomicInteger aZz = new AtomicInteger(0);
    private volatile zza aZB = zza.NONE;
    private volatile Socket aZC = null;
    private zzakx aZD = null;
    private final URI aZE;
    private final zzalb aZF;
    private final zzalc aZG;
    private final zzakz aZH;
    private final Thread aZI = getThreadFactory().newThread(new Runnable() {
        public void run() {
            zzakw.this.zzcwf();
        }
    });
    private final int st = aZz.incrementAndGet();

    private enum zza {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    public zzakw(URI uri, String str, Map<String, String> map) {
        this.aZE = uri;
        this.aZH = new zzakz(uri, str, map);
        this.aZF = new zzalb(this);
        this.aZG = new zzalc(this, "TubeSock", this.st);
    }

    private Socket createSocket() {
        String scheme = this.aZE.getScheme();
        String host = this.aZE.getHost();
        int port = this.aZE.getPort();
        if (scheme != null && scheme.equals("ws")) {
            try {
                return new Socket(host, port == -1 ? 80 : port);
            } catch (UnknownHostException e) {
                UnknownHostException unknownHostException = e;
                String str = "unknown host: ";
                String valueOf = String.valueOf(host);
                throw new zzaky(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), unknownHostException);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(this.aZE);
                throw new zzaky(new StringBuilder(String.valueOf(valueOf2).length() + 31).append("error while creating socket to ").append(valueOf2).toString(), e2);
            }
        } else if (scheme == null || !scheme.equals("wss")) {
            String str2 = "unsupported protocol: ";
            String valueOf3 = String.valueOf(scheme);
            throw new zzaky(valueOf3.length() != 0 ? str2.concat(valueOf3) : new String(str2));
        } else {
            if (port == -1) {
                port = 443;
            }
            try {
                SSLSocket sSLSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(host, port);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                    return sSLSocket;
                }
                String valueOf4 = String.valueOf(this.aZE);
                throw new zzaky(new StringBuilder(String.valueOf(valueOf4).length() + 39).append("Error while verifying secure socket to ").append(valueOf4).toString());
            } catch (UnknownHostException e3) {
                UnknownHostException unknownHostException2 = e3;
                String str3 = "unknown host: ";
                String valueOf5 = String.valueOf(host);
                throw new zzaky(valueOf5.length() != 0 ? str3.concat(valueOf5) : new String(str3), unknownHostException2);
            } catch (IOException e4) {
                String valueOf6 = String.valueOf(this.aZE);
                throw new zzaky(new StringBuilder(String.valueOf(valueOf6).length() + 38).append("error while creating secure socket to ").append(valueOf6).toString(), e4);
            }
        }
    }

    static ThreadFactory getThreadFactory() {
        return aZJ;
    }

    private synchronized void zza(byte b, byte[] bArr) {
        if (this.aZB != zza.CONNECTED) {
            this.aZD.zza(new zzaky("error while sending data: not connected"));
        } else {
            try {
                this.aZG.zzb(b, true, bArr);
            } catch (IOException e) {
                this.aZD.zza(new zzaky("Failed to send frame", e));
                close();
            }
        }
        return;
    }

    public static void zza(ThreadFactory threadFactory, zzakv zzakv) {
        aZJ = threadFactory;
        aZK = zzakv;
    }

    static zzakv zzcvz() {
        return aZK;
    }

    private synchronized void zzcwc() {
        if (this.aZB != zza.DISCONNECTED) {
            this.aZF.zzcwj();
            this.aZG.zzcwm();
            if (this.aZC != null) {
                try {
                    this.aZC.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            this.aZB = zza.DISCONNECTED;
            this.aZD.onClose();
        }
    }

    private void zzcwd() {
        try {
            this.aZB = zza.DISCONNECTING;
            this.aZG.zzcwm();
            this.aZG.zzb(8, true, new byte[0]);
        } catch (IOException e) {
            this.aZD.zza(new zzaky("Failed to send close frame", e));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r5 = new java.io.DataInputStream(r0.getInputStream());
        r6 = r0.getOutputStream();
        r6.write(r11.aZH.zzcwh());
        r2 = new byte[com.google.android.gms.auth.api.credentials.CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT];
        r7 = new java.util.ArrayList();
        r0 = 0;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        if (r3 != false) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        r8 = r5.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        if (r8 != -1) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0064, code lost:
        throw new com.google.android.gms.internal.zzaky("Connection closed before handshake was complete");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r2[r0] = (byte) r8;
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0093, code lost:
        if (r2[r0 - 1] != 10) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009b, code lost:
        if (r2[r0 - 2] != 13) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009d, code lost:
        r0 = new java.lang.String(r2, aZA);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ae, code lost:
        if (r0.trim().equals("") == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b0, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b1, code lost:
        r3 = r2;
        r2 = new byte[com.google.android.gms.auth.api.credentials.CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT];
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b9, code lost:
        r7.add(r0.trim());
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c2, code lost:
        if (r0 != 1000) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c4, code lost:
        r0 = new java.lang.String(r2, aZA);
        r2 = "Unexpected long line in handshake: ";
        r0 = java.lang.String.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d7, code lost:
        if (r0.length() == 0) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d9, code lost:
        r0 = r2.concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e0, code lost:
        throw new com.google.android.gms.internal.zzaky(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r0 = new java.lang.String(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ec, code lost:
        r11.aZH.zzro((java.lang.String) r7.get(0));
        r7.remove(0);
        r1 = new java.util.HashMap();
        r2 = r7.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0109, code lost:
        if (r2.hasNext() == false) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x010b, code lost:
        r0 = ((java.lang.String) r2.next()).split(": ", 2);
        r1.put(r0[0], r0[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0122, code lost:
        r11.aZH.zzc(r1);
        r11.aZG.zzb(r6);
        r11.aZF.zza(r5);
        r11.aZB = com.google.android.gms.internal.zzakw.zza.aZP;
        r11.aZG.zzcwg().start();
        r11.aZD.zzcpk();
        r11.aZF.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0148, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    public void zzcwf() {
        try {
            Socket createSocket = createSocket();
            synchronized (this) {
                this.aZC = createSocket;
                if (this.aZB == zza.DISCONNECTED) {
                    try {
                        this.aZC.close();
                        this.aZC = null;
                        close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (zzaky e2) {
            try {
                this.aZD.zza(e2);
            } finally {
                close();
            }
        } catch (IOException e3) {
            zzakx zzakx = this.aZD;
            String str = "error while connecting: ";
            String valueOf = String.valueOf(e3.getMessage());
            zzakx.zza(new zzaky(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e3));
            close();
        }
    }

    public synchronized void close() {
        switch (this.aZB) {
            case NONE:
                this.aZB = zza.DISCONNECTED;
                break;
            case CONNECTING:
                zzcwc();
                break;
            case CONNECTED:
                zzcwd();
                break;
        }
    }

    public synchronized void connect() {
        if (this.aZB != zza.NONE) {
            this.aZD.zza(new zzaky("connect() already called"));
            close();
        } else {
            zzakv zzcvz = zzcvz();
            Thread zzcwg = zzcwg();
            String valueOf = String.valueOf("TubeSockReader-");
            zzcvz.zza(zzcwg, new StringBuilder(String.valueOf(valueOf).length() + 11).append(valueOf).append(this.st).toString());
            this.aZB = zza.CONNECTING;
            zzcwg().start();
        }
    }

    public void zza(zzakx zzakx) {
        this.aZD = zzakx;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzaw(byte[] bArr) {
        zza(10, bArr);
    }

    /* access modifiers changed from: 0000 */
    public void zzb(zzaky zzaky) {
        this.aZD.zza(zzaky);
        if (this.aZB == zza.CONNECTED) {
            close();
        }
        zzcwc();
    }

    /* access modifiers changed from: 0000 */
    public zzakx zzcwa() {
        return this.aZD;
    }

    /* access modifiers changed from: 0000 */
    public void zzcwb() {
        zzcwc();
    }

    public void zzcwe() throws InterruptedException {
        if (this.aZG.zzcwg().getState() != State.NEW) {
            this.aZG.zzcwg().join();
        }
        zzcwg().join();
    }

    /* access modifiers changed from: 0000 */
    public Thread zzcwg() {
        return this.aZI;
    }

    public synchronized void zzrf(String str) {
        zza(1, str.getBytes(aZA));
    }
}
