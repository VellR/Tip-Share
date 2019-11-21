package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzaov {
    private final ByteBuffer bia;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zzaov(ByteBuffer byteBuffer) {
        this.bia = byteBuffer;
        this.bia.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzaov(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int length = charSequence.length();
        int i4 = 0;
        int i5 = i + i2;
        while (i4 < length && i4 + i < i5) {
            char charAt = charSequence.charAt(i4);
            if (charAt >= 128) {
                break;
            }
            bArr[i + i4] = (byte) charAt;
            i4++;
        }
        if (i4 == length) {
            return i + length;
        }
        int i6 = i + i4;
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 < 128 && i6 < i5) {
                i3 = i6 + 1;
                bArr[i6] = (byte) charAt2;
            } else if (charAt2 < 2048 && i6 <= i5 - 2) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 6) | 960);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i6 <= i5 - 3) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 12) | 480);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i3 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
            } else if (i6 <= i5 - 4) {
                if (i4 + 1 != charSequence.length()) {
                    i4++;
                    char charAt3 = charSequence.charAt(i4);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i10 = i6 + 1;
                        bArr[i6] = (byte) ((codePoint >>> 18) | 240);
                        int i11 = i10 + 1;
                        bArr[i10] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i12 = i11 + 1;
                        bArr[i11] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i3 = i12 + 1;
                        bArr[i12] = (byte) ((codePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i4 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i6);
            }
            i4++;
            i6 = i3;
        }
        return i6;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            zzb(charSequence, byteBuffer);
        }
    }

    public static int zzaeo(int i) {
        if (i >= 0) {
            return zzaet(i);
        }
        return 10;
    }

    public static int zzaep(int i) {
        return zzaet(zzaev(i));
    }

    public static int zzaer(int i) {
        return zzaet(zzapf.zzaj(i, 0));
    }

    public static int zzaet(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zzaev(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int zzag(int i, int i2) {
        return zzaer(i) + zzaeo(i2);
    }

    public static int zzah(int i, int i2) {
        return zzaer(i) + zzaep(i2);
    }

    public static int zzb(int i, double d) {
        return zzaer(i) + zzp(d);
    }

    public static int zzb(int i, zzapc zzapc) {
        return (zzaer(i) * 2) + zzd(zzapc);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzaer(i) + zzbc(bArr);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 128) {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 2048) {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else if (charAt < 55296 || 57343 < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static zzaov zzba(byte[] bArr) {
        return zzc(bArr, 0, bArr.length);
    }

    public static int zzbc(byte[] bArr) {
        return zzaet(bArr.length) + bArr.length;
    }

    public static int zzc(int i, zzapc zzapc) {
        return zzaer(i) + zze(zzapc);
    }

    public static zzaov zzc(byte[] bArr, int i, int i2) {
        return new zzaov(bArr, i, i2);
    }

    public static int zzcv(long j) {
        return zzda(j);
    }

    public static int zzcw(long j) {
        return zzda(j);
    }

    public static int zzcx(long j) {
        return 8;
    }

    public static int zzcy(long j) {
        return zzda(zzdc(j));
    }

    public static int zzd(int i, float f) {
        return zzaer(i) + zzl(f);
    }

    public static int zzd(zzapc zzapc) {
        return zzapc.ao();
    }

    private static int zzd(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = i;
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt >= 2048) {
                i3 += zza(charSequence, i2);
                break;
            }
            i2++;
            i3 = ((127 - charAt) >>> 31) + i3;
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    public static int zzda(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long zzdc(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzdf(boolean z) {
        return 1;
    }

    public static int zze(int i, long j) {
        return zzaer(i) + zzcw(j);
    }

    public static int zze(zzapc zzapc) {
        int ao = zzapc.ao();
        return ao + zzaet(ao);
    }

    public static int zzf(int i, long j) {
        return zzaer(i) + zzcx(j);
    }

    public static int zzg(int i, long j) {
        return zzaer(i) + zzcy(j);
    }

    public static int zzk(int i, boolean z) {
        return zzaer(i) + zzdf(z);
    }

    public static int zzl(float f) {
        return 4;
    }

    public static int zzp(double d) {
        return 8;
    }

    public static int zzs(int i, String str) {
        return zzaer(i) + zztg(str);
    }

    public static int zztg(String str) {
        int zzd = zzd((CharSequence) str);
        return zzd + zzaet(zzd);
    }

    public int aa() {
        return this.bia.remaining();
    }

    public void ab() {
        if (aa() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zza(int i, double d) throws IOException {
        zzai(i, 1);
        zzo(d);
    }

    public void zza(int i, long j) throws IOException {
        zzai(i, 0);
        zzcr(j);
    }

    public void zza(int i, zzapc zzapc) throws IOException {
        zzai(i, 2);
        zzc(zzapc);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzai(i, 2);
        zzbb(bArr);
    }

    public void zzae(int i, int i2) throws IOException {
        zzai(i, 0);
        zzaem(i2);
    }

    public void zzaem(int i) throws IOException {
        if (i >= 0) {
            zzaes(i);
        } else {
            zzcz((long) i);
        }
    }

    public void zzaen(int i) throws IOException {
        zzaes(zzaev(i));
    }

    public void zzaeq(int i) throws IOException {
        zzc((byte) i);
    }

    public void zzaes(int i) throws IOException {
        while ((i & -128) != 0) {
            zzaeq((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        zzaeq(i);
    }

    public void zzaeu(int i) throws IOException {
        if (this.bia.remaining() < 4) {
            throw new zza(this.bia.position(), this.bia.limit());
        }
        this.bia.putInt(i);
    }

    public void zzaf(int i, int i2) throws IOException {
        zzai(i, 0);
        zzaen(i2);
    }

    public void zzai(int i, int i2) throws IOException {
        zzaes(zzapf.zzaj(i, i2));
    }

    public void zzb(int i, long j) throws IOException {
        zzai(i, 0);
        zzcs(j);
    }

    public void zzb(zzapc zzapc) throws IOException {
        zzapc.zza(this);
    }

    public void zzbb(byte[] bArr) throws IOException {
        zzaes(bArr.length);
        zzbd(bArr);
    }

    public void zzbd(byte[] bArr) throws IOException {
        zzd(bArr, 0, bArr.length);
    }

    public void zzc(byte b) throws IOException {
        if (!this.bia.hasRemaining()) {
            throw new zza(this.bia.position(), this.bia.limit());
        }
        this.bia.put(b);
    }

    public void zzc(int i, float f) throws IOException {
        zzai(i, 5);
        zzk(f);
    }

    public void zzc(int i, long j) throws IOException {
        zzai(i, 1);
        zzct(j);
    }

    public void zzc(zzapc zzapc) throws IOException {
        zzaes(zzapc.an());
        zzapc.zza(this);
    }

    public void zzcr(long j) throws IOException {
        zzcz(j);
    }

    public void zzcs(long j) throws IOException {
        zzcz(j);
    }

    public void zzct(long j) throws IOException {
        zzdb(j);
    }

    public void zzcu(long j) throws IOException {
        zzcz(zzdc(j));
    }

    public void zzcz(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzaeq((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        zzaeq((int) j);
    }

    public void zzd(int i, long j) throws IOException {
        zzai(i, 0);
        zzcu(j);
    }

    public void zzd(byte[] bArr, int i, int i2) throws IOException {
        if (this.bia.remaining() >= i2) {
            this.bia.put(bArr, i, i2);
            return;
        }
        throw new zza(this.bia.position(), this.bia.limit());
    }

    public void zzdb(long j) throws IOException {
        if (this.bia.remaining() < 8) {
            throw new zza(this.bia.position(), this.bia.limit());
        }
        this.bia.putLong(j);
    }

    public void zzde(boolean z) throws IOException {
        zzaeq(z ? 1 : 0);
    }

    public void zzj(int i, boolean z) throws IOException {
        zzai(i, 0);
        zzde(z);
    }

    public void zzk(float f) throws IOException {
        zzaeu(Float.floatToIntBits(f));
    }

    public void zzo(double d) throws IOException {
        zzdb(Double.doubleToLongBits(d));
    }

    public void zzr(int i, String str) throws IOException {
        zzai(i, 2);
        zztf(str);
    }

    public void zztf(String str) throws IOException {
        try {
            int zzaet = zzaet(str.length());
            if (zzaet == zzaet(str.length() * 3)) {
                int position = this.bia.position();
                if (this.bia.remaining() < zzaet) {
                    throw new zza(zzaet + position, this.bia.limit());
                }
                this.bia.position(position + zzaet);
                zza((CharSequence) str, this.bia);
                int position2 = this.bia.position();
                this.bia.position(position);
                zzaes((position2 - position) - zzaet);
                this.bia.position(position2);
                return;
            }
            zzaes(zzd((CharSequence) str));
            zza((CharSequence) str, this.bia);
        } catch (BufferOverflowException e) {
            zza zza2 = new zza(this.bia.position(), this.bia.limit());
            zza2.initCause(e);
            throw zza2;
        }
    }
}
