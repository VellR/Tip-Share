package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class zzalc {
    private final Random aSQ = new Random();
    private final Thread aZI = zzakw.getThreadFactory().newThread(new Runnable() {
        public void run() {
            zzalc.this.zzcwn();
        }
    });
    private zzakw aZZ;
    private volatile boolean bac = false;
    private BlockingQueue<ByteBuffer> bad;
    private boolean bae = false;
    private WritableByteChannel baf;

    zzalc(zzakw zzakw, String str, int i) {
        zzakw.zzcvz().zza(zzcwg(), new StringBuilder(String.valueOf(str).length() + 18).append(str).append("Writer-").append(i).toString());
        this.aZZ = zzakw;
        this.bad = new LinkedBlockingQueue();
    }

    private ByteBuffer zza(byte b, boolean z, byte[] bArr) throws IOException {
        int i = 2;
        if (z) {
            i = 6;
        }
        int length = bArr.length;
        if (length >= 126) {
            i = length <= 65535 ? i + 2 : i + 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i + bArr.length);
        allocate.put((byte) (b | Byte.MIN_VALUE));
        if (length < 126) {
            allocate.put((byte) (z ? length | 128 : length));
        } else if (length <= 65535) {
            allocate.put((byte) (z ? 254 : 126));
            allocate.putShort((short) length);
        } else {
            int i2 = TransportMediator.KEYCODE_MEDIA_PAUSE;
            if (z) {
                i2 = 255;
            }
            allocate.put((byte) i2);
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z) {
            byte[] zzcwk = zzcwk();
            allocate.put(zzcwk);
            for (int i3 = 0; i3 < bArr.length; i3++) {
                allocate.put((byte) (bArr[i3] ^ zzcwk[i3 % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }

    private void zzc(zzaky zzaky) {
        this.aZZ.zzb(zzaky);
    }

    private byte[] zzcwk() {
        byte[] bArr = new byte[4];
        this.aSQ.nextBytes(bArr);
        return bArr;
    }

    private void zzcwl() throws InterruptedException, IOException {
        this.baf.write((ByteBuffer) this.bad.take());
    }

    /* access modifiers changed from: private */
    public void zzcwn() {
        while (!this.bac && !Thread.interrupted()) {
            try {
                zzcwl();
            } catch (IOException e) {
                zzc(new zzaky("IO Exception", e));
                return;
            } catch (InterruptedException e2) {
                return;
            }
        }
        for (int i = 0; i < this.bad.size(); i++) {
            zzcwl();
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzb(byte b, boolean z, byte[] bArr) throws IOException {
        ByteBuffer zza = zza(b, z, bArr);
        if (!this.bac || (!this.bae && b == 8)) {
            if (b == 8) {
                this.bae = true;
            }
            this.bad.add(zza);
        } else {
            throw new zzaky("Shouldn't be sending");
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzb(OutputStream outputStream) {
        this.baf = Channels.newChannel(outputStream);
    }

    /* access modifiers changed from: 0000 */
    public Thread zzcwg() {
        return this.aZI;
    }

    /* access modifiers changed from: 0000 */
    public void zzcwm() {
        this.bac = true;
    }
}
