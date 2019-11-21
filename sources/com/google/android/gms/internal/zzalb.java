package com.google.android.gms.internal;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

class zzalb {
    private zzakx aZD = null;
    private DataInputStream aZY = null;
    private zzakw aZZ = null;
    private byte[] baa = new byte[112];
    private zzb bab;
    private volatile boolean bac = false;

    zzalb(zzakw zzakw) {
        this.aZZ = zzakw;
    }

    private int read(byte[] bArr, int i, int i2) throws IOException {
        this.aZY.readFully(bArr, i, i2);
        return i2;
    }

    private void zza(boolean z, byte b, byte[] bArr) {
        if (b == 9) {
            if (z) {
                zzax(bArr);
                return;
            }
            throw new zzaky("PING must not fragment across frames");
        } else if (this.bab != null && b != 0) {
            throw new zzaky("Failed to continue outstanding frame");
        } else if (this.bab == null && b == 0) {
            throw new zzaky("Received continuing frame, but there's nothing to continue");
        } else {
            if (this.bab == null) {
                this.bab = zzaku.zzb(b);
            }
            if (!this.bab.zzau(bArr)) {
                throw new zzaky("Failed to decode frame");
            } else if (z) {
                zzala zzcvw = this.bab.zzcvw();
                this.bab = null;
                if (zzcvw == null) {
                    throw new zzaky("Failed to decode whole message");
                }
                this.aZD.zza(zzcvw);
            }
        }
    }

    private void zzax(byte[] bArr) {
        if (bArr.length <= 125) {
            this.aZZ.zzaw(bArr);
            return;
        }
        throw new zzaky("PING frame too long");
    }

    private void zzc(zzaky zzaky) {
        zzcwj();
        this.aZZ.zzb(zzaky);
    }

    private long zzd(byte[] bArr, int i) {
        return (((long) bArr[i + 0]) << 56) + (((long) (bArr[i + 1] & 255)) << 48) + (((long) (bArr[i + 2] & 255)) << 40) + (((long) (bArr[i + 3] & 255)) << 32) + (((long) (bArr[i + 4] & 255)) << 24) + ((long) ((bArr[i + 5] & 255) << 16)) + ((long) ((bArr[i + 6] & 255) << 8)) + ((long) ((bArr[i + 7] & 255) << 0));
    }

    /* access modifiers changed from: 0000 */
    public void run() {
        this.aZD = this.aZZ.zzcwa();
        while (!this.bac) {
            try {
                int read = read(this.baa, 0, 1) + 0;
                boolean z = (this.baa[0] & 128) != 0;
                if ((this.baa[0] & 112) != 0) {
                    throw new zzaky("Invalid frame received");
                }
                byte b = (byte) (this.baa[0] & 15);
                int read2 = read + read(this.baa, read, 1);
                byte b2 = this.baa[1];
                long j = 0;
                if (b2 < 126) {
                    j = (long) b2;
                } else if (b2 == 126) {
                    int read3 = read(this.baa, read2, 2) + read2;
                    j = (long) (((this.baa[2] & 255) << 8) | (this.baa[3] & 255));
                } else if (b2 == Byte.MAX_VALUE) {
                    j = zzd(this.baa, (read(this.baa, read2, 8) + read2) - 8);
                }
                byte[] bArr = new byte[((int) j)];
                read(bArr, 0, (int) j);
                if (b == 8) {
                    this.aZZ.zzcwb();
                } else if (b == 10) {
                    continue;
                } else if (b == 1 || b == 2 || b == 9 || b == 0) {
                    zza(z, b, bArr);
                } else {
                    throw new zzaky("Unsupported opcode: " + b);
                }
            } catch (SocketTimeoutException e) {
            } catch (IOException e2) {
                zzc(new zzaky("IO Error", e2));
            } catch (zzaky e3) {
                zzc(e3);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(DataInputStream dataInputStream) {
        this.aZY = dataInputStream;
    }

    /* access modifiers changed from: 0000 */
    public void zzcwj() {
        this.bac = true;
    }
}
