package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class zzahf extends Reader {
    private List<String> aSX;
    private boolean aSY;
    private int aSZ;
    private int aTa;
    private int aTb;
    private int aTc;
    private boolean aTd;

    public zzahf() {
        this.aSX = null;
        this.aSY = false;
        this.aTb = this.aSZ;
        this.aTc = this.aTa;
        this.aTd = false;
        this.aSX = new ArrayList();
    }

    private long zzcf(long j) {
        long j2 = 0;
        while (this.aTa < this.aSX.size() && j2 < j) {
            int zzcpr = zzcpr();
            long j3 = j - j2;
            if (j3 < ((long) zzcpr)) {
                this.aSZ = (int) (((long) this.aSZ) + j3);
                j2 += j3;
            } else {
                j2 += (long) zzcpr;
                this.aSZ = 0;
                this.aTa++;
            }
        }
        return j2;
    }

    private String zzcpq() {
        if (this.aTa < this.aSX.size()) {
            return (String) this.aSX.get(this.aTa);
        }
        return null;
    }

    private int zzcpr() {
        String zzcpq = zzcpq();
        if (zzcpq == null) {
            return 0;
        }
        return zzcpq.length() - this.aSZ;
    }

    private void zzcps() throws IOException {
        if (this.aSY) {
            throw new IOException("Stream already closed");
        } else if (!this.aTd) {
            throw new IOException("Reader needs to be frozen before read operations can be called");
        }
    }

    public void close() throws IOException {
        zzcps();
        this.aSY = true;
    }

    public void mark(int i) throws IOException {
        zzcps();
        this.aTb = this.aSZ;
        this.aTc = this.aTa;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        zzcps();
        String zzcpq = zzcpq();
        if (zzcpq == null) {
            return -1;
        }
        char charAt = zzcpq.charAt(this.aSZ);
        zzcf(1);
        return charAt;
    }

    public int read(CharBuffer charBuffer) throws IOException {
        zzcps();
        int remaining = charBuffer.remaining();
        int i = 0;
        String zzcpq = zzcpq();
        while (remaining > 0 && zzcpq != null) {
            int min = Math.min(zzcpq.length() - this.aSZ, remaining);
            charBuffer.put((String) this.aSX.get(this.aTa), this.aSZ, this.aSZ + min);
            remaining -= min;
            i += min;
            zzcf((long) min);
            zzcpq = zzcpq();
        }
        if (i > 0 || zzcpq != null) {
            return i;
        }
        return -1;
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        zzcps();
        int i3 = 0;
        String zzcpq = zzcpq();
        while (zzcpq != null && i3 < i2) {
            int min = Math.min(zzcpr(), i2 - i3);
            zzcpq.getChars(this.aSZ, this.aSZ + min, cArr, i + i3);
            int i4 = i3 + min;
            zzcf((long) min);
            i3 = i4;
            zzcpq = zzcpq();
        }
        if (i3 > 0 || zzcpq != null) {
            return i3;
        }
        return -1;
    }

    public boolean ready() throws IOException {
        zzcps();
        return true;
    }

    public void reset() throws IOException {
        this.aSZ = this.aTb;
        this.aTa = this.aTc;
    }

    public long skip(long j) throws IOException {
        zzcps();
        return zzcf(j);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String append : this.aSX) {
            sb.append(append);
        }
        return sb.toString();
    }

    public void zzcpp() {
        if (this.aTd) {
            throw new IllegalStateException("Trying to freeze frozen StringListReader");
        }
        this.aTd = true;
    }

    public void zzrg(String str) {
        if (this.aTd) {
            throw new IllegalStateException("Trying to add string after reading");
        } else if (str.length() > 0) {
            this.aSX.add(str);
        }
    }
}
