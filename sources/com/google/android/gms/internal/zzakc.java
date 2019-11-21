package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class zzakc {
    private final List<zzahr> aQK;
    private final List<String> aQL;

    static class zza {
        private StringBuilder aYM = null;
        private Stack<zzaka> aYN = new Stack<>();
        private int aYO = -1;
        private int aYP;
        private boolean aYQ = true;
        /* access modifiers changed from: private */
        public final List<zzahr> aYR = new ArrayList();
        /* access modifiers changed from: private */
        public final List<String> aYS = new ArrayList();
        private final zzc aYT;

        public zza(zzc zzc) {
            this.aYT = zzc;
        }

        private void zza(StringBuilder sb, zzaka zzaka) {
            sb.append(zzalo.zzru(zzaka.asString()));
        }

        private zzahr zzadq(int i) {
            zzaka[] zzakaArr = new zzaka[i];
            for (int i2 = 0; i2 < i; i2++) {
                zzakaArr[i2] = (zzaka) this.aYN.get(i2);
            }
            return new zzahr(zzakaArr);
        }

        /* access modifiers changed from: private */
        public void zzb(zzakj<?> zzakj) {
            zzcve();
            this.aYO = this.aYP;
            this.aYM.append(zzakj.zza(com.google.android.gms.internal.zzakm.zza.V2));
            this.aYQ = true;
            if (this.aYT.zze(this)) {
                zzcvh();
            }
        }

        private void zzcve() {
            if (!zzcvb()) {
                this.aYM = new StringBuilder();
                this.aYM.append("(");
                Iterator it = zzadq(this.aYP).iterator();
                while (it.hasNext()) {
                    zza(this.aYM, (zzaka) it.next());
                    this.aYM.append(":(");
                }
                this.aYQ = false;
            }
        }

        /* access modifiers changed from: private */
        public void zzcvf() {
            this.aYP--;
            if (zzcvb()) {
                this.aYM.append(")");
            }
            this.aYQ = true;
        }

        /* access modifiers changed from: private */
        public void zzcvg() {
            zzalo.zzb(this.aYP == 0, "Can't finish hashing in the middle processing a child");
            if (zzcvb()) {
                zzcvh();
            }
            this.aYS.add("");
        }

        private void zzcvh() {
            zzalo.zzb(zzcvb(), "Can't end range without starting a range!");
            for (int i = 0; i < this.aYP; i++) {
                this.aYM.append(")");
            }
            this.aYM.append(")");
            zzahr zzadq = zzadq(this.aYO);
            this.aYS.add(zzalo.zzrt(this.aYM.toString()));
            this.aYR.add(zzadq);
            this.aYM = null;
        }

        /* access modifiers changed from: private */
        public void zzn(zzaka zzaka) {
            zzcve();
            if (this.aYQ) {
                this.aYM.append(",");
            }
            zza(this.aYM, zzaka);
            this.aYM.append(":(");
            if (this.aYP == this.aYN.size()) {
                this.aYN.add(zzaka);
            } else {
                this.aYN.set(this.aYP, zzaka);
            }
            this.aYP++;
            this.aYQ = false;
        }

        public boolean zzcvb() {
            return this.aYM != null;
        }

        public int zzcvc() {
            return this.aYM.length();
        }

        public zzahr zzcvd() {
            return zzadq(this.aYP);
        }
    }

    private static class zzb implements zzc {
        private final long aYU;

        public zzb(zzakm zzakm) {
            this.aYU = Math.max(512, (long) Math.sqrt((double) (zzalj.zzs(zzakm) * 100)));
        }

        public boolean zze(zza zza) {
            return ((long) zza.zzcvc()) > this.aYU && (zza.zzcvd().isEmpty() || !zza.zzcvd().zzcre().equals(zzaka.zzcur()));
        }
    }

    public interface zzc {
        boolean zze(zza zza);
    }

    private zzakc(List<zzahr> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.aQK = list;
        this.aQL = list2;
    }

    public static zzakc zza(zzakm zzakm, zzc zzc2) {
        if (zzakm.isEmpty()) {
            return new zzakc(Collections.emptyList(), Collections.singletonList(""));
        }
        zza zza2 = new zza(zzc2);
        zza(zzakm, zza2);
        zza2.zzcvg();
        return new zzakc(zza2.aYR, zza2.aYS);
    }

    /* access modifiers changed from: private */
    public static void zza(zzakm zzakm, final zza zza2) {
        if (zzakm.zzcuw()) {
            zza2.zzb((zzakj) zzakm);
        } else if (zzakm.isEmpty()) {
            throw new IllegalArgumentException("Can't calculate hash on empty node!");
        } else if (!(zzakm instanceof zzakb)) {
            String valueOf = String.valueOf(zzakm);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Expected children node, but got: ").append(valueOf).toString());
        } else {
            ((zzakb) zzakm).zza(new com.google.android.gms.internal.zzakb.zza() {
                public void zzb(zzaka zzaka, zzakm zzakm) {
                    zza.this.zzn(zzaka);
                    zzakc.zza(zzakm, zza.this);
                    zza.this.zzcvf();
                }
            }, true);
        }
    }

    public static zzakc zzh(zzakm zzakm) {
        return zza(zzakm, (zzc) new zzb(zzakm));
    }

    public List<zzahr> zzcny() {
        return Collections.unmodifiableList(this.aQK);
    }

    public List<String> zzcnz() {
        return Collections.unmodifiableList(this.aQL);
    }
}
