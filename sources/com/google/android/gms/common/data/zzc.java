package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

public abstract class zzc {
    protected final DataHolder tk;
    protected int vK;
    private int vL;

    public zzc(DataHolder dataHolder, int i) {
        this.tk = (DataHolder) zzab.zzaa(dataHolder);
        zzfm(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzc = (zzc) obj;
        return zzaa.equal(Integer.valueOf(zzc.vK), Integer.valueOf(this.vK)) && zzaa.equal(Integer.valueOf(zzc.vL), Integer.valueOf(this.vL)) && zzc.tk == this.tk;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String str) {
        return this.tk.zze(str, this.vK, this.vL);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String str) {
        return this.tk.zzg(str, this.vK, this.vL);
    }

    /* access modifiers changed from: protected */
    public float getFloat(String str) {
        return this.tk.zzf(str, this.vK, this.vL);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String str) {
        return this.tk.zzc(str, this.vK, this.vL);
    }

    /* access modifiers changed from: protected */
    public long getLong(String str) {
        return this.tk.zzb(str, this.vK, this.vL);
    }

    /* access modifiers changed from: protected */
    public String getString(String str) {
        return this.tk.zzd(str, this.vK, this.vL);
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.vK), Integer.valueOf(this.vL), this.tk);
    }

    public boolean isDataValid() {
        return !this.tk.isClosed();
    }

    /* access modifiers changed from: protected */
    public void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.tk.zza(str, this.vK, this.vL, charArrayBuffer);
    }

    /* access modifiers changed from: protected */
    public int zzarb() {
        return this.vK;
    }

    /* access modifiers changed from: protected */
    public void zzfm(int i) {
        zzab.zzbm(i >= 0 && i < this.tk.getCount());
        this.vK = i;
        this.vL = this.tk.zzfo(this.vK);
    }

    public boolean zzhf(String str) {
        return this.tk.zzhf(str);
    }

    /* access modifiers changed from: protected */
    public Uri zzhg(String str) {
        return this.tk.zzh(str, this.vK, this.vL);
    }

    /* access modifiers changed from: protected */
    public boolean zzhh(String str) {
        return this.tk.zzi(str, this.vK, this.vL);
    }
}
