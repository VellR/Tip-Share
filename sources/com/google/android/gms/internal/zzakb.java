package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class zzakb implements zzakm {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzakb.class.desiredAssertionStatus());
    public static Comparator<zzaka> aYF = new Comparator<zzaka>() {
        /* renamed from: zza */
        public int compare(zzaka zzaka, zzaka zzaka2) {
            return zzaka.compareTo(zzaka2);
        }
    };
    private final zzagi<zzaka, zzakm> aXe;
    private final zzakm aYG;
    private String aYH;

    public static abstract class zza extends com.google.android.gms.internal.zzagn.zzb<zzaka, zzakm> {
        public abstract void zzb(zzaka zzaka, zzakm zzakm);

        /* renamed from: zzf */
        public void zzk(zzaka zzaka, zzakm zzakm) {
            zzb(zzaka, zzakm);
        }
    }

    private static class zzb implements Iterator<zzakl> {
        private final Iterator<Entry<zzaka, zzakm>> aQr;

        public zzb(Iterator<Entry<zzaka, zzakm>> it) {
            this.aQr = it;
        }

        public boolean hasNext() {
            return this.aQr.hasNext();
        }

        public void remove() {
            this.aQr.remove();
        }

        /* renamed from: zzcva */
        public zzakl next() {
            Entry entry = (Entry) this.aQr.next();
            return new zzakl((zzaka) entry.getKey(), (zzakm) entry.getValue());
        }
    }

    protected zzakb() {
        this.aYH = null;
        this.aXe = com.google.android.gms.internal.zzagi.zza.zza(aYF);
        this.aYG = zzakq.zzcvu();
    }

    protected zzakb(zzagi<zzaka, zzakm> zzagi, zzakm zzakm) {
        this.aYH = null;
        if (!zzagi.isEmpty() || zzakm.isEmpty()) {
            this.aYG = zzakm;
            this.aXe = zzagi;
            return;
        }
        throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
    }

    private static void zzb(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(" ");
        }
    }

    private void zzc(StringBuilder sb, int i) {
        if (!this.aXe.isEmpty() || !this.aYG.isEmpty()) {
            sb.append("{\n");
            Iterator it = this.aXe.iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                zzb(sb, i + 2);
                sb.append(((zzaka) entry.getKey()).asString());
                sb.append("=");
                if (entry.getValue() instanceof zzakb) {
                    ((zzakb) entry.getValue()).zzc(sb, i + 2);
                } else {
                    sb.append(((zzakm) entry.getValue()).toString());
                }
                sb.append("\n");
            }
            if (!this.aYG.isEmpty()) {
                zzb(sb, i + 2);
                sb.append(".priority=");
                sb.append(this.aYG.toString());
                sb.append("\n");
            }
            zzb(sb, i);
            sb.append("}");
            return;
        }
        sb.append("{ }");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzakb)) {
            return false;
        }
        zzakb zzakb = (zzakb) obj;
        if (!zzcux().equals(zzakb.zzcux())) {
            return false;
        }
        if (this.aXe.size() != zzakb.aXe.size()) {
            return false;
        }
        Iterator it = this.aXe.iterator();
        Iterator it2 = zzakb.aXe.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Entry entry2 = (Entry) it2.next();
            if (((zzaka) entry.getKey()).equals(entry2.getKey())) {
                if (!((zzakm) entry.getValue()).equals(entry2.getValue())) {
                }
            }
            return false;
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        throw new IllegalStateException("Something went wrong internally.");
    }

    public int getChildCount() {
        return this.aXe.size();
    }

    public Object getValue() {
        return getValue(false);
    }

    public Object getValue(boolean z) {
        boolean z2;
        if (isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator it = this.aXe.iterator();
        boolean z3 = true;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String asString = ((zzaka) entry.getKey()).asString();
            hashMap.put(asString, ((zzakm) entry.getValue()).getValue(z));
            i2++;
            if (z3) {
                if (asString.length() <= 1 || asString.charAt(0) != '0') {
                    Integer zzrv = zzalo.zzrv(asString);
                    if (zzrv == null || zzrv.intValue() < 0) {
                        z2 = false;
                        z3 = z2;
                        i = i;
                    } else if (zzrv.intValue() > i) {
                        i = zzrv.intValue();
                        z2 = z3;
                        z3 = z2;
                        i = i;
                    }
                } else {
                    z2 = false;
                    z3 = z2;
                    i = i;
                }
            }
            z2 = z3;
            z3 = z2;
            i = i;
        }
        if (z || !z3 || i >= i2 * 2) {
            if (z && !this.aYG.isEmpty()) {
                hashMap.put(".priority", this.aYG.getValue());
            }
            return hashMap;
        }
        ArrayList arrayList = new ArrayList(i + 1);
        for (int i3 = 0; i3 <= i; i3++) {
            arrayList.add(hashMap.get(i3));
        }
        return arrayList;
    }

    public int hashCode() {
        int i = 0;
        Iterator it = iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            zzakl zzakl = (zzakl) it.next();
            i = zzakl.zzcmq().hashCode() + (((i2 * 31) + zzakl.zzcvs().hashCode()) * 17);
        }
    }

    public boolean isEmpty() {
        return this.aXe.isEmpty();
    }

    public Iterator<zzakl> iterator() {
        return new zzb(this.aXe.iterator());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        zzc(sb, 0);
        return sb.toString();
    }

    public String zza(com.google.android.gms.internal.zzakm.zza zza2) {
        if (zza2 != com.google.android.gms.internal.zzakm.zza.V1) {
            throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
        }
        StringBuilder sb = new StringBuilder();
        if (!this.aYG.isEmpty()) {
            sb.append("priority:");
            sb.append(this.aYG.zza(com.google.android.gms.internal.zzakm.zza.V1));
            sb.append(":");
        }
        ArrayList<zzakl> arrayList = new ArrayList<>();
        Iterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            zzakl zzakl = (zzakl) it.next();
            arrayList.add(zzakl);
            z = z || !zzakl.zzcmq().zzcux().isEmpty();
        }
        if (z) {
            Collections.sort(arrayList, zzakp.zzcvt());
        }
        for (zzakl zzakl2 : arrayList) {
            String zzcuv = zzakl2.zzcmq().zzcuv();
            if (!zzcuv.equals("")) {
                sb.append(":");
                sb.append(zzakl2.zzcvs().asString());
                sb.append(":");
                sb.append(zzcuv);
            }
        }
        return sb.toString();
    }

    public void zza(zza zza2) {
        zza(zza2, false);
    }

    public void zza(final zza zza2, boolean z) {
        if (!z || zzcux().isEmpty()) {
            this.aXe.zza(zza2);
        } else {
            this.aXe.zza(new com.google.android.gms.internal.zzagn.zzb<zzaka, zzakm>() {
                boolean aYI = false;

                /* renamed from: zzf */
                public void zzk(zzaka zzaka, zzakm zzakm) {
                    if (!this.aYI && zzaka.compareTo(zzaka.zzcur()) > 0) {
                        this.aYI = true;
                        zza2.zzb(zzaka.zzcur(), zzakb.this.zzcux());
                    }
                    zza2.zzb(zzaka, zzakm);
                }
            });
        }
    }

    public zzakm zzao(zzahr zzahr) {
        zzaka zzcrb = zzahr.zzcrb();
        return zzcrb == null ? this : zzm(zzcrb).zzao(zzahr.zzcrc());
    }

    public Iterator<zzakl> zzcnd() {
        return new zzb(this.aXe.zzcnd());
    }

    public String zzcuv() {
        if (this.aYH == null) {
            String zza2 = zza(com.google.android.gms.internal.zzakm.zza.V1);
            this.aYH = zza2.isEmpty() ? "" : zzalo.zzrt(zza2);
        }
        return this.aYH;
    }

    public boolean zzcuw() {
        return false;
    }

    public zzakm zzcux() {
        return this.aYG;
    }

    public zzaka zzcuy() {
        return (zzaka) this.aXe.zzcnb();
    }

    public zzaka zzcuz() {
        return (zzaka) this.aXe.zzcnc();
    }

    public zzakm zze(zzaka zzaka, zzakm zzakm) {
        if (zzaka.zzcut()) {
            return zzf(zzakm);
        }
        zzagi<zzaka, zzakm> zzagi = this.aXe;
        if (zzagi.containsKey(zzaka)) {
            zzagi = zzagi.zzbf(zzaka);
        }
        if (!zzakm.isEmpty()) {
            zzagi = zzagi.zzj(zzaka, zzakm);
        }
        return zzagi.isEmpty() ? zzakf.zzcvi() : new zzakb(zzagi, this.aYG);
    }

    public zzakm zzf(zzakm zzakm) {
        return this.aXe.isEmpty() ? zzakf.zzcvi() : new zzakb(this.aXe, zzakm);
    }

    /* renamed from: zzg */
    public int compareTo(zzakm zzakm) {
        if (isEmpty()) {
            return zzakm.isEmpty() ? 0 : -1;
        }
        if (zzakm.zzcuw()) {
            return 1;
        }
        if (zzakm.isEmpty()) {
            return 1;
        }
        return zzakm == zzakm.aZk ? -1 : 0;
    }

    public boolean zzk(zzaka zzaka) {
        return !zzm(zzaka).isEmpty();
    }

    public zzaka zzl(zzaka zzaka) {
        return (zzaka) this.aXe.zzbg(zzaka);
    }

    public zzakm zzl(zzahr zzahr, zzakm zzakm) {
        zzaka zzcrb = zzahr.zzcrb();
        if (zzcrb == null) {
            return zzakm;
        }
        if (!zzcrb.zzcut()) {
            return zze(zzcrb, zzm(zzcrb).zzl(zzahr.zzcrc(), zzakm));
        }
        if ($assertionsDisabled || zzakq.zzp(zzakm)) {
            return zzf(zzakm);
        }
        throw new AssertionError();
    }

    public zzakm zzm(zzaka zzaka) {
        return (!zzaka.zzcut() || this.aYG.isEmpty()) ? this.aXe.containsKey(zzaka) ? (zzakm) this.aXe.get(zzaka) : zzakf.zzcvi() : this.aYG;
    }
}
