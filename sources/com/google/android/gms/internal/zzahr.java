package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzahr implements Comparable<zzahr>, Iterable<zzaka> {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzahr.class.desiredAssertionStatus());
    private static final zzahr aTN = new zzahr("");
    /* access modifiers changed from: private */
    public final zzaka[] aTM;
    /* access modifiers changed from: private */
    public final int end;
    /* access modifiers changed from: private */
    public final int start;

    public zzahr(String str) {
        int i;
        String[] split = str.split("/");
        int i2 = 0;
        for (String length : split) {
            if (length.length() > 0) {
                i2++;
            }
        }
        this.aTM = new zzaka[i2];
        int length2 = split.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length2) {
            String str2 = split[i3];
            if (str2.length() > 0) {
                i = i4 + 1;
                this.aTM[i4] = zzaka.zzrm(str2);
            } else {
                i = i4;
            }
            i3++;
            i4 = i;
        }
        this.start = 0;
        this.end = this.aTM.length;
    }

    public zzahr(List<String> list) {
        this.aTM = new zzaka[list.size()];
        int i = 0;
        for (String zzrm : list) {
            int i2 = i + 1;
            this.aTM[i] = zzaka.zzrm(zzrm);
            i = i2;
        }
        this.start = 0;
        this.end = list.size();
    }

    public zzahr(zzaka... zzakaArr) {
        this.aTM = (zzaka[]) Arrays.copyOf(zzakaArr, zzakaArr.length);
        this.start = 0;
        this.end = zzakaArr.length;
        int length = zzakaArr.length;
        int i = 0;
        while (i < length) {
            zzaka zzaka = zzakaArr[i];
            if ($assertionsDisabled || zzaka != null) {
                i++;
            } else {
                throw new AssertionError("Can't construct a path with a null value!");
            }
        }
    }

    private zzahr(zzaka[] zzakaArr, int i, int i2) {
        this.aTM = zzakaArr;
        this.start = i;
        this.end = i2;
    }

    public static zzahr zza(zzahr zzahr, zzahr zzahr2) {
        zzaka zzcrb = zzahr.zzcrb();
        zzaka zzcrb2 = zzahr2.zzcrb();
        if (zzcrb == null) {
            return zzahr2;
        }
        if (zzcrb.equals(zzcrb2)) {
            return zza(zzahr.zzcrc(), zzahr2.zzcrc());
        }
        String valueOf = String.valueOf(zzahr2);
        String valueOf2 = String.valueOf(zzahr);
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 37 + String.valueOf(valueOf2).length()).append("INTERNAL ERROR: ").append(valueOf).append(" is not contained in ").append(valueOf2).toString());
    }

    public static zzahr zzcqy() {
        return aTN;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzahr)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzahr zzahr = (zzahr) obj;
        if (size() != zzahr.size()) {
            return false;
        }
        int i = this.start;
        int i2 = zzahr.start;
        while (i < this.end && i2 < zzahr.end) {
            if (!this.aTM[i].equals(zzahr.aTM[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 37) + this.aTM[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.start >= this.end;
    }

    public Iterator<zzaka> iterator() {
        return new Iterator<zzaka>() {
            int offset = zzahr.this.start;

            public boolean hasNext() {
                return this.offset < zzahr.this.end;
            }

            public void remove() {
                throw new UnsupportedOperationException("Can't remove component from immutable Path!");
            }

            /* renamed from: zzcrf */
            public zzaka next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements.");
                }
                zzaka zzaka = zzahr.this.aTM[this.offset];
                this.offset++;
                return zzaka;
            }
        };
    }

    public int size() {
        return this.end - this.start;
    }

    public String toString() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            sb.append("/");
            sb.append(this.aTM[i].asString());
        }
        return sb.toString();
    }

    public zzahr zza(zzaka zzaka) {
        int size = size();
        zzaka[] zzakaArr = new zzaka[(size + 1)];
        System.arraycopy(this.aTM, this.start, zzakaArr, 0, size);
        zzakaArr[size] = zzaka;
        return new zzahr(zzakaArr, 0, size + 1);
    }

    public String zzcqz() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            if (i > this.start) {
                sb.append("/");
            }
            sb.append(this.aTM[i].asString());
        }
        return sb.toString();
    }

    public List<String> zzcra() {
        ArrayList arrayList = new ArrayList(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(((zzaka) it.next()).asString());
        }
        return arrayList;
    }

    public zzaka zzcrb() {
        if (isEmpty()) {
            return null;
        }
        return this.aTM[this.start];
    }

    public zzahr zzcrc() {
        int i = this.start;
        if (!isEmpty()) {
            i++;
        }
        return new zzahr(this.aTM, i, this.end);
    }

    public zzahr zzcrd() {
        if (isEmpty()) {
            return null;
        }
        return new zzahr(this.aTM, this.start, this.end - 1);
    }

    public zzaka zzcre() {
        if (!isEmpty()) {
            return this.aTM[this.end - 1];
        }
        return null;
    }

    public zzahr zzh(zzahr zzahr) {
        int size = size() + zzahr.size();
        zzaka[] zzakaArr = new zzaka[size];
        System.arraycopy(this.aTM, this.start, zzakaArr, 0, size());
        System.arraycopy(zzahr.aTM, zzahr.start, zzakaArr, size(), zzahr.size());
        return new zzahr(zzakaArr, 0, size);
    }

    public boolean zzi(zzahr zzahr) {
        if (size() > zzahr.size()) {
            return false;
        }
        int i = this.start;
        int i2 = zzahr.start;
        while (i < this.end) {
            if (!this.aTM[i].equals(zzahr.aTM[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    /* renamed from: zzj */
    public int compareTo(zzahr zzahr) {
        int i = this.start;
        int i2 = zzahr.start;
        while (i < this.end && i2 < zzahr.end) {
            int zzi = this.aTM[i].compareTo(zzahr.aTM[i2]);
            if (zzi != 0) {
                return zzi;
            }
            i++;
            i2++;
        }
        if (i == this.end && i2 == zzahr.end) {
            return 0;
        }
        return i == this.end ? -1 : 1;
    }
}
