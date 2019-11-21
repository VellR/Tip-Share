package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzq extends zzaa {

    @WorkerThread
    interface zza {
        void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map);
    }

    @WorkerThread
    private static class zzb implements Runnable {
        private final String aQ;
        private final zza ala;
        private final Throwable alb;
        private final byte[] alc;
        private final Map<String, List<String>> ald;
        private final int zzblz;

        private zzb(String str, zza zza, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            zzab.zzaa(zza);
            this.ala = zza;
            this.zzblz = i;
            this.alb = th;
            this.alc = bArr;
            this.aQ = str;
            this.ald = map;
        }

        public void run() {
            this.ala.zza(this.aQ, this.zzblz, this.alb, this.alc, this.ald);
        }
    }

    @WorkerThread
    private class zzc implements Runnable {
        private final String aQ;
        private final byte[] ale;
        private final zza alf;
        private final Map<String, String> alg;
        private final URL zzbin;

        public zzc(String str, URL url, byte[] bArr, Map<String, String> map, zza zza) {
            zzab.zzhs(str);
            zzab.zzaa(url);
            zzab.zzaa(zza);
            this.zzbin = url;
            this.ale = bArr;
            this.alf = zza;
            this.aQ = str;
            this.alg = map;
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ee A[SYNTHETIC, Splitter:B:36:0x00ee] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00f3  */
        public void run() {
            Map map;
            int i;
            OutputStream outputStream;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Map map2;
            HttpURLConnection httpURLConnection2;
            zzq.this.zzbso();
            int i2 = 0;
            try {
                zzq.this.zzeu(this.aQ);
                httpURLConnection2 = zzq.this.zzc(this.zzbin);
                try {
                    if (this.alg != null) {
                        for (Entry entry : this.alg.entrySet()) {
                            httpURLConnection2.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    if (this.ale != null) {
                        byte[] zzj = zzq.this.zzbsv().zzj(this.ale);
                        zzq.this.zzbsz().zzbty().zzj("Uploading data. size", Integer.valueOf(zzj.length));
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.addRequestProperty("Content-Encoding", "gzip");
                        httpURLConnection2.setFixedLengthStreamingMode(zzj.length);
                        httpURLConnection2.connect();
                        outputStream = httpURLConnection2.getOutputStream();
                        try {
                            outputStream.write(zzj);
                            outputStream.close();
                        } catch (IOException e) {
                            e = e;
                            map = null;
                            i = 0;
                            httpURLConnection = httpURLConnection2;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e2) {
                                    zzq.this.zzbsz().zzbtr().zzj("Error closing HTTP compressed POST connection output stream", e2);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzq.this.zzrq();
                            zzq.this.zzbsy().zzl(new zzb(this.aQ, this.alf, i, e, null, map));
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            map2 = null;
                            if (outputStream != null) {
                            }
                            if (httpURLConnection2 != null) {
                            }
                            zzq.this.zzrq();
                            zzq.this.zzbsy().zzl(new zzb(this.aQ, this.alf, i2, null, null, map2));
                            throw th;
                        }
                    }
                    i2 = httpURLConnection2.getResponseCode();
                    map2 = httpURLConnection2.getHeaderFields();
                } catch (IOException e3) {
                    e = e3;
                    map = null;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th3) {
                    th = th3;
                    map2 = null;
                    outputStream = null;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                    zzq.this.zzrq();
                    zzq.this.zzbsy().zzl(new zzb(this.aQ, this.alf, i2, null, null, map2));
                    throw th;
                }
                try {
                    byte[] zza = zzq.this.zzc(httpURLConnection2);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    zzq.this.zzrq();
                    zzq.this.zzbsy().zzl(new zzb(this.aQ, this.alf, i2, null, zza, map2));
                } catch (IOException e4) {
                    e = e4;
                    map = map2;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = null;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                    zzq.this.zzrq();
                    zzq.this.zzbsy().zzl(new zzb(this.aQ, this.alf, i2, null, null, map2));
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                map = null;
                i = 0;
                outputStream = null;
                httpURLConnection = null;
            } catch (Throwable th5) {
                th = th5;
                map2 = null;
                httpURLConnection2 = null;
                outputStream = null;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e6) {
                        zzq.this.zzbsz().zzbtr().zzj("Error closing HTTP compressed POST connection output stream", e6);
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                zzq.this.zzrq();
                zzq.this.zzbsy().zzl(new zzb(this.aQ, this.alf, i2, null, null, map2));
                throw th;
            }
        }
    }

    public zzq(zzx zzx) {
        super(zzx);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public byte[] zzc(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public void zza(String str, URL url, Map<String, String> map, zza zza2) {
        zzwu();
        zzzg();
        zzab.zzaa(url);
        zzab.zzaa(zza2);
        zzbsy().zzm(new zzc(str, url, null, map, zza2));
    }

    @WorkerThread
    public void zza(String str, URL url, byte[] bArr, Map<String, String> map, zza zza2) {
        zzwu();
        zzzg();
        zzab.zzaa(url);
        zzab.zzaa(bArr);
        zzab.zzaa(zza2);
        zzbsy().zzm(new zzc(str, url, bArr, map, zza2));
    }

    public boolean zzadj() {
        NetworkInfo networkInfo;
        zzzg();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public /* bridge */ /* synthetic */ void zzbso() {
        super.zzbso();
    }

    public /* bridge */ /* synthetic */ zzc zzbsp() {
        return super.zzbsp();
    }

    public /* bridge */ /* synthetic */ zzac zzbsq() {
        return super.zzbsq();
    }

    public /* bridge */ /* synthetic */ zzn zzbsr() {
        return super.zzbsr();
    }

    public /* bridge */ /* synthetic */ zzg zzbss() {
        return super.zzbss();
    }

    public /* bridge */ /* synthetic */ zzad zzbst() {
        return super.zzbst();
    }

    public /* bridge */ /* synthetic */ zze zzbsu() {
        return super.zzbsu();
    }

    public /* bridge */ /* synthetic */ zzal zzbsv() {
        return super.zzbsv();
    }

    public /* bridge */ /* synthetic */ zzv zzbsw() {
        return super.zzbsw();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsx() {
        return super.zzbsx();
    }

    public /* bridge */ /* synthetic */ zzw zzbsy() {
        return super.zzbsy();
    }

    public /* bridge */ /* synthetic */ zzp zzbsz() {
        return super.zzbsz();
    }

    public /* bridge */ /* synthetic */ zzt zzbta() {
        return super.zzbta();
    }

    public /* bridge */ /* synthetic */ zzd zzbtb() {
        return super.zzbtb();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public HttpURLConnection zzc(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout((int) zzbtb().zzbrx());
        httpURLConnection.setReadTimeout((int) zzbtb().zzbry());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* access modifiers changed from: protected */
    public void zzeu(String str) {
    }

    /* access modifiers changed from: protected */
    public void zzrq() {
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    /* access modifiers changed from: protected */
    public void zzwv() {
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
