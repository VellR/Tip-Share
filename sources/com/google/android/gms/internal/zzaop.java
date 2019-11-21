package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class zzaop implements Closeable {
    private static final char[] bhm = ")]}'\n".toCharArray();
    private int aYn = 0;
    private boolean bhn = false;
    private final char[] bho = new char[1024];
    private int bhp = 0;
    private int bhq = 0;
    /* access modifiers changed from: private */
    public int bhr = 0;
    private long bhs;
    private int bht;
    private String bhu;
    private int[] bhv = new int[32];
    private int bhw = 0;
    private String[] bhx;
    private int[] bhy;
    private final Reader in;
    private int pos = 0;

    static {
        zzanu.bff = new zzanu() {
            public void zzi(zzaop zzaop) throws IOException {
                if (zzaop instanceof zzaof) {
                    ((zzaof) zzaop).k();
                    return;
                }
                int zzag = zzaop.bhr;
                if (zzag == 0) {
                    zzag = zzaop.u();
                }
                if (zzag == 13) {
                    zzaop.bhr = 9;
                } else if (zzag == 12) {
                    zzaop.bhr = 8;
                } else if (zzag == 14) {
                    zzaop.bhr = 10;
                } else {
                    String valueOf = String.valueOf(zzaop.h());
                    int zzai = zzaop.getLineNumber();
                    int zzaj = zzaop.getColumnNumber();
                    String path = zzaop.getPath();
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" ").append(" at line ").append(zzai).append(" column ").append(zzaj).append(" path ").append(path).toString());
                }
            }
        };
    }

    public zzaop(Reader reader) {
        int[] iArr = this.bhv;
        int i = this.bhw;
        this.bhw = i + 1;
        iArr[i] = 6;
        this.bhx = new String[32];
        this.bhy = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    private void A() throws IOException {
        char c;
        do {
            if (this.pos < this.aYn || zzaed(1)) {
                char[] cArr = this.bho;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == 10) {
                    this.bhp++;
                    this.bhq = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    private char B() throws IOException {
        int i;
        if (this.pos != this.aYn || zzaed(1)) {
            char[] cArr = this.bho;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char c = cArr[i2];
            switch (c) {
                case 10:
                    this.bhp++;
                    this.bhq = this.pos;
                    return c;
                case 'b':
                    return 8;
                case 'f':
                    return 12;
                case 'n':
                    return 10;
                case 'r':
                    return 13;
                case 't':
                    return 9;
                case 'u':
                    if (this.pos + 4 <= this.aYn || zzaed(4)) {
                        int i3 = this.pos;
                        int i4 = i3 + 4;
                        int i5 = i3;
                        char c2 = 0;
                        for (int i6 = i5; i6 < i4; i6++) {
                            char c3 = this.bho[i6];
                            char c4 = (char) (c2 << 4);
                            if (c3 >= '0' && c3 <= '9') {
                                i = c3 - '0';
                            } else if (c3 >= 'a' && c3 <= 'f') {
                                i = (c3 - 'a') + 10;
                            } else if (c3 < 'A' || c3 > 'F') {
                                String str = "\\u";
                                String valueOf = String.valueOf(new String(this.bho, this.pos, 4));
                                throw new NumberFormatException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                            } else {
                                i = (c3 - 'A') + 10;
                            }
                            c2 = (char) (c4 + i);
                        }
                        this.pos += 4;
                        return c2;
                    }
                    throw zztd("Unterminated escape sequence");
                default:
                    return c;
            }
        } else {
            throw zztd("Unterminated escape sequence");
        }
    }

    private void C() throws IOException {
        zzda(true);
        this.pos--;
        if (this.pos + bhm.length <= this.aYn || zzaed(bhm.length)) {
            int i = 0;
            while (i < bhm.length) {
                if (this.bho[this.pos + i] == bhm[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.pos += bhm.length;
        }
    }

    /* access modifiers changed from: private */
    public int getColumnNumber() {
        return (this.pos - this.bhq) + 1;
    }

    /* access modifiers changed from: private */
    public int getLineNumber() {
        return this.bhp + 1;
    }

    /* access modifiers changed from: private */
    public int u() throws IOException {
        int i = this.bhv[this.bhw - 1];
        if (i == 1) {
            this.bhv[this.bhw - 1] = 2;
        } else if (i == 2) {
            switch (zzda(true)) {
                case 44:
                    break;
                case 59:
                    z();
                    break;
                case 93:
                    this.bhr = 4;
                    return 4;
                default:
                    throw zztd("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.bhv[this.bhw - 1] = 4;
            if (i == 5) {
                switch (zzda(true)) {
                    case 44:
                        break;
                    case 59:
                        z();
                        break;
                    case 125:
                        this.bhr = 2;
                        return 2;
                    default:
                        throw zztd("Unterminated object");
                }
            }
            int zzda = zzda(true);
            switch (zzda) {
                case 34:
                    this.bhr = 13;
                    return 13;
                case 39:
                    z();
                    this.bhr = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.bhr = 2;
                        return 2;
                    }
                    throw zztd("Expected name");
                default:
                    z();
                    this.pos--;
                    if (zze((char) zzda)) {
                        this.bhr = 14;
                        return 14;
                    }
                    throw zztd("Expected name");
            }
        } else if (i == 4) {
            this.bhv[this.bhw - 1] = 5;
            switch (zzda(true)) {
                case 58:
                    break;
                case 61:
                    z();
                    if ((this.pos < this.aYn || zzaed(1)) && this.bho[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                default:
                    throw zztd("Expected ':'");
            }
        } else if (i == 6) {
            if (this.bhn) {
                C();
            }
            this.bhv[this.bhw - 1] = 7;
        } else if (i == 7) {
            if (zzda(false) == -1) {
                this.bhr = 17;
                return 17;
            }
            z();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (zzda(true)) {
            case 34:
                if (this.bhw == 1) {
                    z();
                }
                this.bhr = 9;
                return 9;
            case 39:
                z();
                this.bhr = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.bhr = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.bhr = 4;
                    return 4;
                }
                break;
            case 123:
                this.bhr = 1;
                return 1;
            default:
                this.pos--;
                if (this.bhw == 1) {
                    z();
                }
                int v = v();
                if (v != 0) {
                    return v;
                }
                int w = w();
                if (w != 0) {
                    return w;
                }
                if (!zze(this.bho[this.pos])) {
                    throw zztd("Expected value");
                }
                z();
                this.bhr = 10;
                return 10;
        }
        if (i == 1 || i == 2) {
            z();
            this.pos--;
            this.bhr = 7;
            return 7;
        }
        throw zztd("Unexpected value");
    }

    private int v() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.bho[this.pos];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.aYn && !zzaed(i2 + 1)) {
                return 0;
            }
            char c2 = this.bho[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.aYn || zzaed(length + 1)) && zze(this.bho[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.bhr = i;
        return i;
    }

    private int w() throws IOException {
        char c;
        char c2;
        boolean z;
        boolean z2;
        char[] cArr = this.bho;
        int i = this.pos;
        long j = 0;
        boolean z3 = false;
        boolean z4 = true;
        char c3 = 0;
        int i2 = 0;
        int i3 = this.aYn;
        int i4 = i;
        while (true) {
            if (i4 + i2 == i3) {
                if (i2 == cArr.length) {
                    return 0;
                }
                if (zzaed(i2 + 1)) {
                    i4 = this.pos;
                    i3 = this.aYn;
                }
            }
            c = cArr[i4 + i2];
            switch (c) {
                case '+':
                    if (c3 != 5) {
                        return 0;
                    }
                    c2 = 6;
                    z = z4;
                    z2 = z3;
                    continue;
                case '-':
                    if (c3 == 0) {
                        c2 = 1;
                        boolean z5 = z4;
                        z2 = true;
                        z = z5;
                        continue;
                    } else if (c3 == 5) {
                        c2 = 6;
                        z = z4;
                        z2 = z3;
                        break;
                    } else {
                        return 0;
                    }
                case '.':
                    if (c3 != 2) {
                        return 0;
                    }
                    c2 = 3;
                    z = z4;
                    z2 = z3;
                    continue;
                case 'E':
                case 'e':
                    if (c3 != 2 && c3 != 4) {
                        return 0;
                    }
                    c2 = 5;
                    z = z4;
                    z2 = z3;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (c3 != 1 && c3 != 0) {
                            if (c3 != 2) {
                                if (c3 != 3) {
                                    if (c3 != 5 && c3 != 6) {
                                        c2 = c3;
                                        z = z4;
                                        z2 = z3;
                                        break;
                                    } else {
                                        c2 = 7;
                                        z = z4;
                                        z2 = z3;
                                        break;
                                    }
                                } else {
                                    c2 = 4;
                                    z = z4;
                                    z2 = z3;
                                    break;
                                }
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - '0'));
                                boolean z6 = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) & z4;
                                z2 = z3;
                                j = j2;
                                char c4 = c3;
                                z = z6;
                                c2 = c4;
                                break;
                            } else {
                                return 0;
                            }
                        } else {
                            j = (long) (-(c - '0'));
                            c2 = 2;
                            z = z4;
                            z2 = z3;
                            continue;
                        }
                    } else {
                        break;
                    }
                    break;
            }
            i2++;
            z3 = z2;
            z4 = z;
            c3 = c2;
        }
        if (zze(c)) {
            return 0;
        }
        if (c3 == 2 && z4 && (j != Long.MIN_VALUE || z3)) {
            if (!z3) {
                j = -j;
            }
            this.bhs = j;
            this.pos += i2;
            this.bhr = 15;
            return 15;
        } else if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        } else {
            this.bht = i2;
            this.bhr = 16;
            return 16;
        }
    }

    private String x() throws IOException {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.aYn) {
                switch (this.bho[this.pos + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        z();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.bho.length) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.bho, this.pos, i);
                this.pos = i + this.pos;
                if (!zzaed(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (zzaed(i + 1)) {
            }
        }
        if (sb2 == null) {
            sb = new String(this.bho, this.pos, i);
        } else {
            sb2.append(this.bho, this.pos, i);
            sb = sb2.toString();
        }
        this.pos = i + this.pos;
        return sb;
    }

    private void y() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.aYn) {
                switch (this.bho[this.pos + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        z();
                        break;
                    default:
                        i++;
                }
                this.pos = i + this.pos;
                return;
            }
            this.pos = i + this.pos;
        } while (zzaed(1));
    }

    private void z() throws IOException {
        if (!this.bhn) {
            throw zztd("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void zzaec(int i) {
        if (this.bhw == this.bhv.length) {
            int[] iArr = new int[(this.bhw * 2)];
            int[] iArr2 = new int[(this.bhw * 2)];
            String[] strArr = new String[(this.bhw * 2)];
            System.arraycopy(this.bhv, 0, iArr, 0, this.bhw);
            System.arraycopy(this.bhy, 0, iArr2, 0, this.bhw);
            System.arraycopy(this.bhx, 0, strArr, 0, this.bhw);
            this.bhv = iArr;
            this.bhy = iArr2;
            this.bhx = strArr;
        }
        int[] iArr3 = this.bhv;
        int i2 = this.bhw;
        this.bhw = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean zzaed(int i) throws IOException {
        char[] cArr = this.bho;
        this.bhq -= this.pos;
        if (this.aYn != this.pos) {
            this.aYn -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.aYn);
        } else {
            this.aYn = 0;
        }
        this.pos = 0;
        do {
            int read = this.in.read(cArr, this.aYn, cArr.length - this.aYn);
            if (read == -1) {
                return false;
            }
            this.aYn = read + this.aYn;
            if (this.bhp == 0 && this.bhq == 0 && this.aYn > 0 && cArr[0] == 65279) {
                this.pos++;
                this.bhq++;
                i++;
            }
        } while (this.aYn < i);
        return true;
    }

    private int zzda(boolean z) throws IOException {
        char[] cArr = this.bho;
        int i = this.pos;
        int i2 = this.aYn;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (zzaed(1)) {
                    i = this.pos;
                    i2 = this.aYn;
                } else if (!z) {
                    return -1;
                } else {
                    String valueOf = String.valueOf("End of input at line ");
                    int lineNumber = getLineNumber();
                    throw new EOFException(new StringBuilder(String.valueOf(valueOf).length() + 30).append(valueOf).append(lineNumber).append(" column ").append(getColumnNumber()).toString());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.bhp++;
                this.bhq = i3;
                i = i3;
            } else if (c == ' ' || c == 13) {
                i = i3;
            } else if (c == 9) {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean zzaed = zzaed(2);
                    this.pos++;
                    if (!zzaed) {
                        return c;
                    }
                }
                z();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (zztc("*/")) {
                            i = this.pos + 2;
                            i2 = this.aYn;
                            break;
                        } else {
                            throw zztd("Unterminated comment");
                        }
                    case '/':
                        this.pos++;
                        A();
                        i = this.pos;
                        i2 = this.aYn;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = i3;
                z();
                A();
                i = this.pos;
                i2 = this.aYn;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private boolean zze(char c) throws IOException {
        switch (c) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                z();
                break;
            default:
                return true;
        }
        return false;
    }

    private String zzf(char c) throws IOException {
        char[] cArr = this.bho;
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.pos;
            int i2 = this.aYn;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    sb.append(B());
                    i = this.pos;
                    i2 = this.aYn;
                    i4 = i;
                } else if (c2 == 10) {
                    this.bhp++;
                    this.bhq = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (zzaed(1));
        throw zztd("Unterminated string");
    }

    private void zzg(char c) throws IOException {
        char[] cArr = this.bho;
        do {
            int i = this.pos;
            int i2 = this.aYn;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    B();
                    i4 = this.pos;
                    i2 = this.aYn;
                } else if (c2 == 10) {
                    this.bhp++;
                    this.bhq = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (zzaed(1));
        throw zztd("Unterminated string");
    }

    private boolean zztc(String str) throws IOException {
        while (true) {
            if (this.pos + str.length() > this.aYn && !zzaed(str.length())) {
                return false;
            }
            if (this.bho[this.pos] == 10) {
                this.bhp++;
                this.bhq = this.pos + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.bho[this.pos + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private IOException zztd(String str) throws IOException {
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new zzaos(new StringBuilder(String.valueOf(str).length() + 45 + String.valueOf(path).length()).append(str).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void beginArray() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 3) {
            zzaec(1);
            this.bhy[this.bhw - 1] = 0;
            this.bhr = 0;
            return;
        }
        String valueOf = String.valueOf(h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 74 + String.valueOf(path).length()).append("Expected BEGIN_ARRAY but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void beginObject() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 1) {
            zzaec(3);
            this.bhr = 0;
            return;
        }
        String valueOf = String.valueOf(h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 75 + String.valueOf(path).length()).append("Expected BEGIN_OBJECT but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void close() throws IOException {
        this.bhr = 0;
        this.bhv[0] = 8;
        this.bhw = 1;
        this.in.close();
    }

    public void endArray() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 4) {
            this.bhw--;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            this.bhr = 0;
            return;
        }
        String valueOf = String.valueOf(h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length()).append("Expected END_ARRAY but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void endObject() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 2) {
            this.bhw--;
            this.bhx[this.bhw] = null;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            this.bhr = 0;
            return;
        }
        String valueOf = String.valueOf(h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 73 + String.valueOf(path).length()).append("Expected END_OBJECT but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.bhw;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.bhv[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.bhy[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.bhx[i2] == null) {
                        break;
                    } else {
                        append.append(this.bhx[i2]);
                        break;
                    }
            }
        }
        return append.toString();
    }

    public zzaoq h() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        switch (i) {
            case 1:
                return zzaoq.BEGIN_OBJECT;
            case 2:
                return zzaoq.END_OBJECT;
            case 3:
                return zzaoq.BEGIN_ARRAY;
            case 4:
                return zzaoq.END_ARRAY;
            case 5:
            case 6:
                return zzaoq.BOOLEAN;
            case 7:
                return zzaoq.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzaoq.STRING;
            case 12:
            case 13:
            case 14:
                return zzaoq.NAME;
            case 15:
            case 16:
                return zzaoq.NUMBER;
            case 17:
                return zzaoq.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public boolean hasNext() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.bhn;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 5) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.bhr = 0;
            int[] iArr2 = this.bhy;
            int i3 = this.bhw - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            String valueOf = String.valueOf(h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length()).append("Expected a boolean but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
    }

    public double nextDouble() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 15) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.bhs;
        }
        if (i == 16) {
            this.bhu = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        } else if (i == 8 || i == 9) {
            this.bhu = zzf(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.bhu = x();
        } else if (i != 11) {
            String valueOf = String.valueOf(h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length()).append("Expected a double but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.bhr = 11;
        double parseDouble = Double.parseDouble(this.bhu);
        if (this.bhn || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.bhu = null;
            this.bhr = 0;
            int[] iArr2 = this.bhy;
            int i3 = this.bhw - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        int lineNumber2 = getLineNumber();
        int columnNumber2 = getColumnNumber();
        String path2 = getPath();
        throw new zzaos(new StringBuilder(String.valueOf(path2).length() + 102).append("JSON forbids NaN and infinities: ").append(parseDouble).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
    }

    public int nextInt() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 15) {
            int i2 = (int) this.bhs;
            if (this.bhs != ((long) i2)) {
                long j = this.bhs;
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                throw new NumberFormatException(new StringBuilder(String.valueOf(path).length() + 89).append("Expected an int but was ").append(j).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
            }
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i3 = this.bhw - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.bhu = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        } else if (i == 8 || i == 9) {
            this.bhu = zzf(i == 8 ? '\'' : '\"');
            try {
                int parseInt = Integer.parseInt(this.bhu);
                this.bhr = 0;
                int[] iArr2 = this.bhy;
                int i4 = this.bhw - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(h());
            int lineNumber2 = getLineNumber();
            int columnNumber2 = getColumnNumber();
            String path2 = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
        }
        this.bhr = 11;
        double parseDouble = Double.parseDouble(this.bhu);
        int i5 = (int) parseDouble;
        if (((double) i5) != parseDouble) {
            String str = this.bhu;
            int lineNumber3 = getLineNumber();
            int columnNumber3 = getColumnNumber();
            String path3 = getPath();
            throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path3).length()).append("Expected an int but was ").append(str).append(" at line ").append(lineNumber3).append(" column ").append(columnNumber3).append(" path ").append(path3).toString());
        }
        this.bhu = null;
        this.bhr = 0;
        int[] iArr3 = this.bhy;
        int i6 = this.bhw - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public long nextLong() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 15) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.bhs;
        }
        if (i == 16) {
            this.bhu = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        } else if (i == 8 || i == 9) {
            this.bhu = zzf(i == 8 ? '\'' : '\"');
            try {
                long parseLong = Long.parseLong(this.bhu);
                this.bhr = 0;
                int[] iArr2 = this.bhy;
                int i3 = this.bhw - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.bhr = 11;
        double parseDouble = Double.parseDouble(this.bhu);
        long j = (long) parseDouble;
        if (((double) j) != parseDouble) {
            String str = this.bhu;
            int lineNumber2 = getLineNumber();
            int columnNumber2 = getColumnNumber();
            String path2 = getPath();
            throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path2).length()).append("Expected a long but was ").append(str).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
        }
        this.bhu = null;
        this.bhr = 0;
        int[] iArr3 = this.bhy;
        int i4 = this.bhw - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    public String nextName() throws IOException {
        String zzf;
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 14) {
            zzf = x();
        } else if (i == 12) {
            zzf = zzf('\'');
        } else if (i == 13) {
            zzf = zzf('\"');
        } else {
            String valueOf = String.valueOf(h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.bhr = 0;
        this.bhx[this.bhw - 1] = zzf;
        return zzf;
    }

    public void nextNull() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 7) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String valueOf = String.valueOf(h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 67 + String.valueOf(path).length()).append("Expected null but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String nextString() throws IOException {
        String str;
        int i = this.bhr;
        if (i == 0) {
            i = u();
        }
        if (i == 10) {
            str = x();
        } else if (i == 8) {
            str = zzf('\'');
        } else if (i == 9) {
            str = zzf('\"');
        } else if (i == 11) {
            str = this.bhu;
            this.bhu = null;
        } else if (i == 15) {
            str = Long.toString(this.bhs);
        } else if (i == 16) {
            str = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        } else {
            String valueOf = String.valueOf(h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length()).append("Expected a string but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.bhr = 0;
        int[] iArr = this.bhy;
        int i2 = this.bhw - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final void setLenient(boolean z) {
        this.bhn = z;
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.bhr;
            if (i2 == 0) {
                i2 = u();
            }
            if (i2 == 3) {
                zzaec(1);
                i++;
            } else if (i2 == 1) {
                zzaec(3);
                i++;
            } else if (i2 == 4) {
                this.bhw--;
                i--;
            } else if (i2 == 2) {
                this.bhw--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                y();
            } else if (i2 == 8 || i2 == 12) {
                zzg('\'');
            } else if (i2 == 9 || i2 == 13) {
                zzg('\"');
            } else if (i2 == 16) {
                this.pos += this.bht;
            }
            this.bhr = 0;
        } while (i != 0);
        int[] iArr = this.bhy;
        int i3 = this.bhw - 1;
        iArr[i3] = iArr[i3] + 1;
        this.bhx[this.bhw - 1] = "null";
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        int lineNumber = getLineNumber();
        return new StringBuilder(String.valueOf(valueOf).length() + 39).append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(getColumnNumber()).toString();
    }
}
