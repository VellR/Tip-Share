package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean wc = false;
    private ArrayList<Integer> wd;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void zzarh() {
        synchronized (this) {
            if (!this.wc) {
                int count = this.tk.getCount();
                this.wd = new ArrayList<>();
                if (count > 0) {
                    this.wd.add(Integer.valueOf(0));
                    String zzarg = zzarg();
                    String zzd = this.tk.zzd(zzarg, 0, this.tk.zzfo(0));
                    int i = 1;
                    while (i < count) {
                        int zzfo = this.tk.zzfo(i);
                        String zzd2 = this.tk.zzd(zzarg, i, zzfo);
                        if (zzd2 == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(zzarg).length() + 78).append("Missing value for markerColumn: ").append(zzarg).append(", at row: ").append(i).append(", for window: ").append(zzfo).toString());
                        }
                        if (!zzd2.equals(zzd)) {
                            this.wd.add(Integer.valueOf(i));
                        } else {
                            zzd2 = zzd;
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.wc = true;
            }
        }
    }

    public final T get(int i) {
        zzarh();
        return zzl(zzfs(i), zzft(i));
    }

    public int getCount() {
        zzarh();
        return this.wd.size();
    }

    /* access modifiers changed from: protected */
    public abstract String zzarg();

    /* access modifiers changed from: protected */
    public String zzari() {
        return null;
    }

    /* access modifiers changed from: 0000 */
    public int zzfs(int i) {
        if (i >= 0 && i < this.wd.size()) {
            return ((Integer) this.wd.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    /* access modifiers changed from: protected */
    public int zzft(int i) {
        if (i < 0 || i == this.wd.size()) {
            return 0;
        }
        int intValue = i == this.wd.size() + -1 ? this.tk.getCount() - ((Integer) this.wd.get(i)).intValue() : ((Integer) this.wd.get(i + 1)).intValue() - ((Integer) this.wd.get(i)).intValue();
        if (intValue != 1) {
            return intValue;
        }
        int zzfs = zzfs(i);
        int zzfo = this.tk.zzfo(zzfs);
        String zzari = zzari();
        if (zzari == null || this.tk.zzd(zzari, zzfs, zzfo) != null) {
            return intValue;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract T zzl(int i, int i2);
}
