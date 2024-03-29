package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class zzaor implements Closeable, Flushable {
    private static final String[] bhK = new String[128];
    private static final String[] bhL = ((String[]) bhK.clone());
    private boolean bec;
    private boolean bed;
    private String bhM;
    private String bhN;
    private boolean bhn;
    private int[] bhv = new int[32];
    private int bhw = 0;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            bhK[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        bhK[34] = "\\\"";
        bhK[92] = "\\\\";
        bhK[9] = "\\t";
        bhK[8] = "\\b";
        bhK[10] = "\\n";
        bhK[13] = "\\r";
        bhK[12] = "\\f";
        bhL[60] = "\\u003c";
        bhL[62] = "\\u003e";
        bhL[38] = "\\u0026";
        bhL[61] = "\\u003d";
        bhL[39] = "\\u0027";
    }

    public zzaor(Writer writer) {
        zzaec(6);
        this.separator = ":";
        this.bec = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    private int F() {
        if (this.bhw != 0) {
            return this.bhv[this.bhw - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void G() throws IOException {
        if (this.bhN != null) {
            I();
            zzte(this.bhN);
            this.bhN = null;
        }
    }

    private void H() throws IOException {
        if (this.bhM != null) {
            this.out.write("\n");
            int i = this.bhw;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.bhM);
            }
        }
    }

    private void I() throws IOException {
        int F = F();
        if (F == 5) {
            this.out.write(44);
        } else if (F != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        H();
        zzaee(4);
    }

    private void zzaec(int i) {
        if (this.bhw == this.bhv.length) {
            int[] iArr = new int[(this.bhw * 2)];
            System.arraycopy(this.bhv, 0, iArr, 0, this.bhw);
            this.bhv = iArr;
        }
        int[] iArr2 = this.bhv;
        int i2 = this.bhw;
        this.bhw = i2 + 1;
        iArr2[i2] = i;
    }

    private void zzaee(int i) {
        this.bhv[this.bhw - 1] = i;
    }

    private zzaor zzc(int i, int i2, String str) throws IOException {
        int F = F();
        if (F != i2 && F != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.bhN != null) {
            String str2 = "Dangling name: ";
            String valueOf = String.valueOf(this.bhN);
            throw new IllegalStateException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            this.bhw--;
            if (F == i2) {
                H();
            }
            this.out.write(str);
            return this;
        }
    }

    private void zzdd(boolean z) throws IOException {
        switch (F()) {
            case 1:
                zzaee(2);
                H();
                return;
            case 2:
                this.out.append(',');
                H();
                return;
            case 4:
                this.out.append(this.separator);
                zzaee(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.bhn) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.bhn || z) {
            zzaee(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }

    private zzaor zzq(int i, String str) throws IOException {
        zzdd(true);
        zzaec(i);
        this.out.write(str);
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    private void zzte(String str) throws IOException {
        String str2;
        int i = 0;
        String[] strArr = this.bed ? bhL : bhK;
        this.out.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i < i2) {
                    this.out.write(str, i, i2 - i);
                }
                this.out.write(str2);
                i = i2 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                }
                this.out.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.out.write(str, i, length - i);
        }
        this.out.write("\"");
    }

    public final boolean D() {
        return this.bed;
    }

    public final boolean E() {
        return this.bec;
    }

    public void close() throws IOException {
        this.out.close();
        int i = this.bhw;
        if (i > 1 || (i == 1 && this.bhv[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.bhw = 0;
    }

    public void flush() throws IOException {
        if (this.bhw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public boolean isLenient() {
        return this.bhn;
    }

    public zzaor n() throws IOException {
        G();
        return zzq(1, "[");
    }

    public zzaor o() throws IOException {
        return zzc(1, 2, "]");
    }

    public zzaor p() throws IOException {
        G();
        return zzq(3, "{");
    }

    public zzaor q() throws IOException {
        return zzc(3, 5, "}");
    }

    public zzaor r() throws IOException {
        if (this.bhN != null) {
            if (this.bec) {
                G();
            } else {
                this.bhN = null;
                return this;
            }
        }
        zzdd(false);
        this.out.write("null");
        return this;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.bhM = null;
            this.separator = ":";
            return;
        }
        this.bhM = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.bhn = z;
    }

    public zzaor zza(Number number) throws IOException {
        if (number == null) {
            return r();
        }
        G();
        String obj = number.toString();
        if (this.bhn || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            zzdd(false);
            this.out.append(obj);
            return this;
        }
        String valueOf = String.valueOf(number);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 39).append("Numeric values must be finite, but was ").append(valueOf).toString());
    }

    public zzaor zzcp(long j) throws IOException {
        G();
        zzdd(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public zzaor zzcz(boolean z) throws IOException {
        G();
        zzdd(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public final void zzdb(boolean z) {
        this.bed = z;
    }

    public final void zzdc(boolean z) {
        this.bec = z;
    }

    public zzaor zzta(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.bhN != null) {
            throw new IllegalStateException();
        } else if (this.bhw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.bhN = str;
            return this;
        }
    }

    public zzaor zztb(String str) throws IOException {
        if (str == null) {
            return r();
        }
        G();
        zzdd(false);
        zzte(str);
        return this;
    }
}
