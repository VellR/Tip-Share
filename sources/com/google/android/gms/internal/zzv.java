package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzv implements zzb {
    private final Map<String, zza> zzbw;
    private long zzbx;
    private final File zzby;
    private final int zzbz;

    static class zza {
        public String zza;
        public long zzb;
        public long zzc;
        public long zzca;
        public String zzcb;
        public long zzd;
        public long zze;
        public Map<String, String> zzf;

        private zza() {
        }

        public zza(String str, com.google.android.gms.internal.zzb.zza zza2) {
            this.zzcb = str;
            this.zzca = (long) zza2.data.length;
            this.zza = zza2.zza;
            this.zzb = zza2.zzb;
            this.zzc = zza2.zzc;
            this.zzd = zza2.zzd;
            this.zze = zza2.zze;
            this.zzf = zza2.zzf;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zza2 = new zza();
            if (zzv.zzb(inputStream) != 538247942) {
                throw new IOException();
            }
            zza2.zzcb = zzv.zzd(inputStream);
            zza2.zza = zzv.zzd(inputStream);
            if (zza2.zza.equals("")) {
                zza2.zza = null;
            }
            zza2.zzb = zzv.zzc(inputStream);
            zza2.zzc = zzv.zzc(inputStream);
            zza2.zzd = zzv.zzc(inputStream);
            zza2.zze = zzv.zzc(inputStream);
            zza2.zzf = zzv.zze(inputStream);
            return zza2;
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.zzcb);
                zzv.zza(outputStream, this.zza == null ? "" : this.zza);
                zzv.zza(outputStream, this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(this.zzf, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public com.google.android.gms.internal.zzb.zza zzb(byte[] bArr) {
            com.google.android.gms.internal.zzb.zza zza2 = new com.google.android.gms.internal.zzb.zza();
            zza2.data = bArr;
            zza2.zza = this.zza;
            zza2.zzb = this.zzb;
            zza2.zzc = this.zzc;
            zza2.zzd = this.zzd;
            zza2.zze = this.zze;
            zza2.zzf = this.zzf;
            return zza2;
        }
    }

    private static class zzb extends FilterInputStream {
        /* access modifiers changed from: private */
        public int zzcc;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzcc = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.zzcc++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.zzcc += read;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzbw = new LinkedHashMap(16, 0.75f, true);
        this.zzbx = 0;
        this.zzby = file;
        this.zzbz = i;
    }

    private void removeEntry(String str) {
        zza zza2 = (zza) this.zzbw.get(str);
        if (zza2 != null) {
            this.zzbx -= zza2.zzca;
            this.zzbw.remove(str);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zza2) {
        if (!this.zzbw.containsKey(str)) {
            this.zzbx += zza2.zzca;
        } else {
            zza zza3 = (zza) this.zzbw.get(str);
            this.zzbx = (zza2.zzca - zza3.zzca) + this.zzbx;
        }
        this.zzbw.put(str, zza2);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            zza(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                zza(outputStream, (String) entry.getKey());
                zza(outputStream, (String) entry.getValue());
            }
            return;
        }
        zza(outputStream, 0);
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 0) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16) | (zza(inputStream) << 24);
    }

    static long zzc(InputStream inputStream) throws IOException {
        return 0 | ((((long) zza(inputStream)) & 255) << 0) | ((((long) zza(inputStream)) & 255) << 8) | ((((long) zza(inputStream)) & 255) << 16) | ((((long) zza(inputStream)) & 255) << 24) | ((((long) zza(inputStream)) & 255) << 32) | ((((long) zza(inputStream)) & 255) << 40) | ((((long) zza(inputStream)) & 255) << 48) | ((((long) zza(inputStream)) & 255) << 56);
    }

    private void zzc(int i) {
        int i2;
        if (this.zzbx + ((long) i) >= ((long) this.zzbz)) {
            if (zzs.DEBUG) {
                zzs.zza("Pruning old cache entries.", new Object[0]);
            }
            long j = this.zzbx;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.zzbw.entrySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = i3;
                    break;
                }
                zza zza2 = (zza) ((Entry) it.next()).getValue();
                if (zzf(zza2.zzcb).delete()) {
                    this.zzbx -= zza2.zzca;
                } else {
                    zzs.zzb("Could not delete cache entry for key=%s, filename=%s", zza2.zzcb, zze(zza2.zzcb));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.zzbx + ((long) i))) < ((float) this.zzbz) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            if (zzs.DEBUG) {
                zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzbx - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), "UTF-8");
    }

    private String zze(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static Map<String, String> zze(InputStream inputStream) throws IOException {
        int zzb2 = zzb(inputStream);
        Map<String, String> hashMap = zzb2 == 0 ? Collections.emptyMap() : new HashMap<>(zzb2);
        for (int i = 0; i < zzb2; i++) {
            hashMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a A[SYNTHETIC, Splitter:B:28:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005f A[SYNTHETIC, Splitter:B:31:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068 A[SYNTHETIC, Splitter:B:36:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0052 A[SYNTHETIC] */
    public synchronized void initialize() {
        BufferedInputStream bufferedInputStream;
        if (this.zzby.exists()) {
            File[] listFiles = this.zzby.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            zza zzf = zza.zzf(bufferedInputStream);
                            zzf.zzca = file.length();
                            zza(zzf.zzcb, zzf);
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e) {
                                }
                            }
                        } catch (IOException e2) {
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    bufferedInputStream2 = bufferedInputStream;
                                    th = th2;
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (bufferedInputStream == null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                        }
                    } catch (IOException e5) {
                        bufferedInputStream = null;
                        if (file != null) {
                        }
                        if (bufferedInputStream == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedInputStream2 != null) {
                        }
                        throw th;
                    }
                }
            }
        } else if (!this.zzby.mkdirs()) {
            zzs.zzc("Unable to create cache dir %s", this.zzby.getAbsolutePath());
        }
        return;
    }

    public synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        removeEntry(str);
        if (!delete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066 A[SYNTHETIC, Splitter:B:33:0x0066] */
    public synchronized com.google.android.gms.internal.zzb.zza zza(String str) {
        zzb zzb2;
        com.google.android.gms.internal.zzb.zza zza2;
        zza zza3 = (zza) this.zzbw.get(str);
        if (zza3 == null) {
            zza2 = null;
        } else {
            File zzf = zzf(str);
            try {
                zzb2 = new zzb(new FileInputStream(zzf));
                try {
                    zza.zzf(zzb2);
                    zza2 = zza3.zzb(zza((InputStream) zzb2, (int) (zzf.length() - ((long) zzb2.zzcc))));
                    if (zzb2 != null) {
                        try {
                            zzb2.close();
                        } catch (IOException e) {
                            zza2 = null;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
                zzb2 = null;
                try {
                    zzs.zzb("%s: %s", zzf.getAbsolutePath(), e.toString());
                    remove(str);
                    if (zzb2 != null) {
                        try {
                            zzb2.close();
                        } catch (IOException e4) {
                            zza2 = null;
                        }
                    }
                    zza2 = null;
                    return zza2;
                } catch (Throwable th) {
                    th = th;
                    if (zzb2 != null) {
                        try {
                            zzb2.close();
                        } catch (IOException e5) {
                            zza2 = null;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zzb2 = null;
                if (zzb2 != null) {
                }
                throw th;
            }
        }
        return zza2;
    }

    public synchronized void zza(String str, com.google.android.gms.internal.zzb.zza zza2) {
        zzc(zza2.data.length);
        File zzf = zzf(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzf);
            zza zza3 = new zza(str, zza2);
            if (!zza3.zza(fileOutputStream)) {
                fileOutputStream.close();
                zzs.zzb("Failed to write header for %s", zzf.getAbsolutePath());
                throw new IOException();
            }
            fileOutputStream.write(zza2.data);
            fileOutputStream.close();
            zza(str, zza3);
        } catch (IOException e) {
            if (!zzf.delete()) {
                zzs.zzb("Could not clean up file %s", zzf.getAbsolutePath());
            }
        }
    }

    public File zzf(String str) {
        return new File(this.zzby, zze(str));
    }
}
