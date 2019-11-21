package com.google.android.gms.internal;

import java.io.IOException;

public final class zzaou {
    private int bhR;
    private int bhS;
    private int bhT;
    private int bhU;
    private int bhV;
    private int bhW = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int bhX;
    private int bhY = 64;
    private int bhZ = 67108864;
    private final byte[] buffer;

    private zzaou(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.bhR = i;
        this.bhS = i + i2;
        this.bhU = i;
    }

    private void W() {
        this.bhS += this.bhT;
        int i = this.bhS;
        if (i > this.bhW) {
            this.bhT = i - this.bhW;
            this.bhS -= this.bhT;
            return;
        }
        this.bhT = 0;
    }

    public static int zzaeh(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static zzaou zzaz(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static zzaou zzb(byte[] bArr, int i, int i2) {
        return new zzaou(bArr, i, i2);
    }

    public static long zzcq(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public int J() throws IOException {
        if (Y()) {
            this.bhV = 0;
            return 0;
        }
        this.bhV = S();
        if (this.bhV != 0) {
            return this.bhV;
        }
        throw zzapb.aj();
    }

    public void K() throws IOException {
        int J;
        do {
            J = J();
            if (J == 0) {
                return;
            }
        } while (zzaeg(J));
    }

    public long L() throws IOException {
        return T();
    }

    public long M() throws IOException {
        return T();
    }

    public int N() throws IOException {
        return S();
    }

    public long O() throws IOException {
        return V();
    }

    public boolean P() throws IOException {
        return S() != 0;
    }

    public int Q() throws IOException {
        return zzaeh(S());
    }

    public long R() throws IOException {
        return zzcq(T());
    }

    public int S() throws IOException {
        byte Z = Z();
        if (Z >= 0) {
            return Z;
        }
        byte b = Z & Byte.MAX_VALUE;
        byte Z2 = Z();
        if (Z2 >= 0) {
            return b | (Z2 << 7);
        }
        byte b2 = b | ((Z2 & Byte.MAX_VALUE) << 7);
        byte Z3 = Z();
        if (Z3 >= 0) {
            return b2 | (Z3 << 14);
        }
        byte b3 = b2 | ((Z3 & Byte.MAX_VALUE) << 14);
        byte Z4 = Z();
        if (Z4 >= 0) {
            return b3 | (Z4 << 21);
        }
        byte b4 = b3 | ((Z4 & Byte.MAX_VALUE) << 21);
        byte Z5 = Z();
        byte b5 = b4 | (Z5 << 28);
        if (Z5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (Z() >= 0) {
                return b5;
            }
        }
        throw zzapb.ai();
    }

    public long T() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte Z = Z();
            j |= ((long) (Z & Byte.MAX_VALUE)) << i;
            if ((Z & 128) == 0) {
                return j;
            }
        }
        throw zzapb.ai();
    }

    public int U() throws IOException {
        return (Z() & 255) | ((Z() & 255) << 8) | ((Z() & 255) << 16) | ((Z() & 255) << 24);
    }

    public long V() throws IOException {
        byte Z = Z();
        byte Z2 = Z();
        return ((((long) Z2) & 255) << 8) | (((long) Z) & 255) | ((((long) Z()) & 255) << 16) | ((((long) Z()) & 255) << 24) | ((((long) Z()) & 255) << 32) | ((((long) Z()) & 255) << 40) | ((((long) Z()) & 255) << 48) | ((((long) Z()) & 255) << 56);
    }

    public int X() {
        if (this.bhW == Integer.MAX_VALUE) {
            return -1;
        }
        return this.bhW - this.bhU;
    }

    public boolean Y() {
        return this.bhU == this.bhS;
    }

    public byte Z() throws IOException {
        if (this.bhU == this.bhS) {
            throw zzapb.ag();
        }
        byte[] bArr = this.buffer;
        int i = this.bhU;
        this.bhU = i + 1;
        return bArr[i];
    }

    public int getPosition() {
        return this.bhU - this.bhR;
    }

    public byte[] readBytes() throws IOException {
        int S = S();
        if (S < 0) {
            throw zzapb.ah();
        } else if (S == 0) {
            return zzapf.bit;
        } else {
            if (S > this.bhS - this.bhU) {
                throw zzapb.ag();
            }
            byte[] bArr = new byte[S];
            System.arraycopy(this.buffer, this.bhU, bArr, 0, S);
            this.bhU = S + this.bhU;
            return bArr;
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(V());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(U());
    }

    public String readString() throws IOException {
        int S = S();
        if (S < 0) {
            throw zzapb.ah();
        } else if (S > this.bhS - this.bhU) {
            throw zzapb.ag();
        } else {
            String str = new String(this.buffer, this.bhU, S, zzapa.UTF_8);
            this.bhU = S + this.bhU;
            return str;
        }
    }

    public void zza(zzapc zzapc) throws IOException {
        int S = S();
        if (this.bhX >= this.bhY) {
            throw zzapb.am();
        }
        int zzaei = zzaei(S);
        this.bhX++;
        zzapc.zzb(this);
        zzaef(0);
        this.bhX--;
        zzaej(zzaei);
    }

    public void zza(zzapc zzapc, int i) throws IOException {
        if (this.bhX >= this.bhY) {
            throw zzapb.am();
        }
        this.bhX++;
        zzapc.zzb(this);
        zzaef(zzapf.zzaj(i, 4));
        this.bhX--;
    }

    public byte[] zzad(int i, int i2) {
        if (i2 == 0) {
            return zzapf.bit;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.bhR + i, bArr, 0, i2);
        return bArr;
    }

    public void zzaef(int i) throws zzapb {
        if (this.bhV != i) {
            throw zzapb.ak();
        }
    }

    public boolean zzaeg(int i) throws IOException {
        switch (zzapf.zzaez(i)) {
            case 0:
                N();
                return true;
            case 1:
                V();
                return true;
            case 2:
                zzael(S());
                return true;
            case 3:
                K();
                zzaef(zzapf.zzaj(zzapf.zzafa(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                U();
                return true;
            default:
                throw zzapb.al();
        }
    }

    public int zzaei(int i) throws zzapb {
        if (i < 0) {
            throw zzapb.ah();
        }
        int i2 = this.bhU + i;
        int i3 = this.bhW;
        if (i2 > i3) {
            throw zzapb.ag();
        }
        this.bhW = i2;
        W();
        return i3;
    }

    public void zzaej(int i) {
        this.bhW = i;
        W();
    }

    public void zzaek(int i) {
        if (i > this.bhU - this.bhR) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.bhU - this.bhR));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.bhU = this.bhR + i;
        }
    }

    public void zzael(int i) throws IOException {
        if (i < 0) {
            throw zzapb.ah();
        } else if (this.bhU + i > this.bhW) {
            zzael(this.bhW - this.bhU);
            throw zzapb.ag();
        } else if (i <= this.bhS - this.bhU) {
            this.bhU += i;
        } else {
            throw zzapb.ag();
        }
    }
}
