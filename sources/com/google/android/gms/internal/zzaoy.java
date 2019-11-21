package com.google.android.gms.internal;

public final class zzaoy implements Cloneable {
    private static final zzaoz bid = new zzaoz();
    private boolean bie;
    private int[] bif;
    private zzaoz[] big;
    private int mSize;

    zzaoy() {
        this(10);
    }

    zzaoy(int i) {
        this.bie = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.bif = new int[idealIntArraySize];
        this.big = new zzaoz[idealIntArraySize];
        this.mSize = 0;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzaoz[] zzaozArr, zzaoz[] zzaozArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzaozArr[i2].equals(zzaozArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzaey(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.bif[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    /* renamed from: ae */
    public final zzaoy clone() {
        int size = size();
        zzaoy zzaoy = new zzaoy(size);
        System.arraycopy(this.bif, 0, zzaoy.bif, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.big[i] != null) {
                zzaoy.big[i] = (zzaoz) this.big[i].clone();
            }
        }
        zzaoy.mSize = size;
        return zzaoy;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaoy)) {
            return false;
        }
        zzaoy zzaoy = (zzaoy) obj;
        if (size() != zzaoy.size()) {
            return false;
        }
        return zza(this.bif, zzaoy.bif, this.mSize) && zza(this.big, zzaoy.big, this.mSize);
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.bif[i2]) * 31) + this.big[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: 0000 */
    public int size() {
        return this.mSize;
    }

    /* access modifiers changed from: 0000 */
    public void zza(int i, zzaoz zzaoz) {
        int zzaey = zzaey(i);
        if (zzaey >= 0) {
            this.big[zzaey] = zzaoz;
            return;
        }
        int i2 = zzaey ^ -1;
        if (i2 >= this.mSize || this.big[i2] != bid) {
            if (this.mSize >= this.bif.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzaoz[] zzaozArr = new zzaoz[idealIntArraySize];
                System.arraycopy(this.bif, 0, iArr, 0, this.bif.length);
                System.arraycopy(this.big, 0, zzaozArr, 0, this.big.length);
                this.bif = iArr;
                this.big = zzaozArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.bif, i2, this.bif, i2 + 1, this.mSize - i2);
                System.arraycopy(this.big, i2, this.big, i2 + 1, this.mSize - i2);
            }
            this.bif[i2] = i;
            this.big[i2] = zzaoz;
            this.mSize++;
            return;
        }
        this.bif[i2] = i;
        this.big[i2] = zzaoz;
    }

    /* access modifiers changed from: 0000 */
    public zzaoz zzaew(int i) {
        int zzaey = zzaey(i);
        if (zzaey < 0 || this.big[zzaey] == bid) {
            return null;
        }
        return this.big[zzaey];
    }

    /* access modifiers changed from: 0000 */
    public zzaoz zzaex(int i) {
        return this.big[i];
    }
}
