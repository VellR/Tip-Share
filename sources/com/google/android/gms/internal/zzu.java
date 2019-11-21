package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class zzu {
    protected static final Comparator<byte[]> zzbv = new Comparator<byte[]>() {
        /* renamed from: zza */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private List<byte[]> zzbr = new LinkedList();
    private List<byte[]> zzbs = new ArrayList(64);
    private int zzbt = 0;
    private final int zzbu;

    public zzu(int i) {
        this.zzbu = i;
    }

    private synchronized void zzx() {
        while (this.zzbt > this.zzbu) {
            byte[] bArr = (byte[]) this.zzbr.remove(0);
            this.zzbs.remove(bArr);
            this.zzbt -= bArr.length;
        }
    }

    public synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.zzbu) {
                this.zzbr.add(bArr);
                int binarySearch = Collections.binarySearch(this.zzbs, bArr, zzbv);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.zzbs.add(binarySearch, bArr);
                this.zzbt += bArr.length;
                zzx();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = new byte[r5];
     */
    public synchronized byte[] zzb(int i) {
        byte[] bArr;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.zzbs.size()) {
                break;
            }
            bArr = (byte[]) this.zzbs.get(i3);
            if (bArr.length >= i) {
                this.zzbt -= bArr.length;
                this.zzbs.remove(i3);
                this.zzbr.remove(bArr);
                break;
            }
            i2 = i3 + 1;
        }
        return bArr;
    }
}
