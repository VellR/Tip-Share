package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification extends AbstractSafeParcelable {
    public static final zzf CREATOR = new zzf();
    public static final PasswordSpecification de = new zza().zzj(12, 16).zzfm("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zze("abcdefghijkmnopqrstxyz", 1).zze("ABCDEFGHJKLMNPQRSTXY", 1).zze("3456789", 1).zzafg();
    public static final PasswordSpecification df = new zza().zzj(12, 16).zzfm("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zze("abcdefghijklmnopqrstuvwxyz", 1).zze("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zze("1234567890", 1).zzafg();
    final String dg;
    final List<String> dh;
    final List<Integer> di;
    final int dj;
    final int dk;
    private final int[] dl = zzaff();
    final int mVersionCode;
    private final Random zzavn = new SecureRandom();

    public static class zza {
        private final List<String> dh = new ArrayList();
        private final List<Integer> di = new ArrayList();
        private int dj = 12;
        private int dk = 16;
        private final TreeSet<Character> dm = new TreeSet<>();

        private void zzafh() {
            int i;
            int i2 = 0;
            Iterator it = this.di.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = ((Integer) it.next()).intValue() + i;
            }
            if (i > this.dk) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
        }

        private void zzafi() {
            boolean[] zArr = new boolean[95];
            for (String charArray : this.dh) {
                char[] charArray2 = charArray.toCharArray();
                int length = charArray2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        char c = charArray2[i];
                        if (zArr[c - ' ']) {
                            throw new zzb("character " + c + " occurs in more than one required character set");
                        }
                        zArr[c - ' '] = true;
                        i++;
                    }
                }
            }
        }

        private TreeSet<Character> zzw(String str, String str2) {
            char[] charArray;
            if (TextUtils.isEmpty(str)) {
                throw new zzb(String.valueOf(str2).concat(" cannot be null or empty"));
            }
            TreeSet<Character> treeSet = new TreeSet<>();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.zzb(c, 32, TransportMediator.KEYCODE_MEDIA_PLAY)) {
                    throw new zzb(String.valueOf(str2).concat(" must only contain ASCII printable characters"));
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public PasswordSpecification zzafg() {
            if (this.dm.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            zzafh();
            zzafi();
            return new PasswordSpecification(1, PasswordSpecification.zzb(this.dm), this.dh, this.di, this.dj, this.dk);
        }

        public zza zze(@NonNull String str, int i) {
            if (i < 1) {
                throw new zzb("count must be at least 1");
            }
            this.dh.add(PasswordSpecification.zzb(zzw(str, "requiredChars")));
            this.di.add(Integer.valueOf(i));
            return this;
        }

        public zza zzfm(@NonNull String str) {
            this.dm.addAll(zzw(str, "allowedChars"));
            return this;
        }

        public zza zzj(int i, int i2) {
            if (i < 1) {
                throw new zzb("minimumSize must be at least 1");
            } else if (i > i2) {
                throw new zzb("maximumSize must be greater than or equal to minimumSize");
            } else {
                this.dj = i;
                this.dk = i2;
                return this;
            }
        }
    }

    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    PasswordSpecification(int i, String str, List<String> list, List<Integer> list2, int i2, int i3) {
        this.mVersionCode = i;
        this.dg = str;
        this.dh = Collections.unmodifiableList(list);
        this.di = Collections.unmodifiableList(list2);
        this.dj = i2;
        this.dk = i3;
    }

    private int zza(char c) {
        return c - ' ';
    }

    private int[] zzaff() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i = 0;
        for (String charArray : this.dh) {
            for (char zza2 : charArray.toCharArray()) {
                iArr[zza(zza2)] = i;
            }
            i++;
        }
        return iArr;
    }

    /* access modifiers changed from: private */
    public static String zzb(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        Iterator it = collection.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return new String(cArr);
            }
            i = i2 + 1;
            cArr[i2] = ((Character) it.next()).charValue();
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzb(int i, int i2, int i3) {
        return i < i2 || i > i3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
