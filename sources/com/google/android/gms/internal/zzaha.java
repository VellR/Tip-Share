package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzaha implements com.google.android.gms.internal.zzagt.zza, zzagz {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzaha.class.desiredAssertionStatus());
    private static long aQM = 0;
    private final ScheduledExecutorService aPL;
    /* access modifiers changed from: private */
    public final zzajx aPY;
    private final zzagx aQN;
    /* access modifiers changed from: private */
    public final zzagu aQY;
    private boolean aRA;
    /* access modifiers changed from: private */
    public final com.google.android.gms.internal.zzagz.zza aRf;
    private String aRg;
    private HashSet<String> aRh = new HashSet<>();
    private boolean aRi = true;
    private long aRj;
    /* access modifiers changed from: private */
    public zzagt aRk;
    /* access modifiers changed from: private */
    public zzb aRl = zzb.Disconnected;
    private long aRm = 0;
    private long aRn = 0;
    private Map<Long, zza> aRo;
    private List<zzd> aRp;
    /* access modifiers changed from: private */
    public Map<Long, zzf> aRq;
    /* access modifiers changed from: private */
    public Map<zzc, zze> aRr;
    /* access modifiers changed from: private */
    public String aRs;
    private boolean aRt;
    private final zzagv aRu;
    private final zzahe aRv;
    private String aRw;
    /* access modifiers changed from: private */
    public long aRx = 0;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> aRy = null;
    private long aRz;

    private interface zza {
        void zzbw(Map<String, Object> map);
    }

    private enum zzb {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    private static class zzc {
        /* access modifiers changed from: private */
        public final List<String> aRQ;
        /* access modifiers changed from: private */
        public final Map<String, Object> aRR;

        public zzc(List<String> list, Map<String, Object> map) {
            this.aRQ = list;
            this.aRR = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.aRQ.equals(zzc.aRQ)) {
                return this.aRR.equals(zzc.aRR);
            }
            return false;
        }

        public int hashCode() {
            return (this.aRQ.hashCode() * 31) + this.aRR.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(zzagw.zzap(this.aRQ));
            String valueOf2 = String.valueOf(this.aRR);
            return new StringBuilder(String.valueOf(valueOf).length() + 11 + String.valueOf(valueOf2).length()).append(valueOf).append(" (params: ").append(valueOf2).append(")").toString();
        }
    }

    private static class zzd {
        private final List<String> aRQ;
        private final String aRS;
        /* access modifiers changed from: private */
        public final zzahc aRT;
        private final Object data;

        private zzd(String str, List<String> list, Object obj, zzahc zzahc) {
            this.aRS = str;
            this.aRQ = list;
            this.data = obj;
            this.aRT = zzahc;
        }

        public String getAction() {
            return this.aRS;
        }

        public Object getData() {
            return this.data;
        }

        public List<String> zzcox() {
            return this.aRQ;
        }

        public zzahc zzcoy() {
            return this.aRT;
        }
    }

    private static class zze {
        /* access modifiers changed from: private */
        public final zzahc aRU;
        /* access modifiers changed from: private */
        public final zzc aRV;
        private final zzagy aRW;
        private final Long aRX;

        private zze(zzahc zzahc, zzc zzc, Long l, zzagy zzagy) {
            this.aRU = zzahc;
            this.aRV = zzc;
            this.aRW = zzagy;
            this.aRX = l;
        }

        public String toString() {
            String valueOf = String.valueOf(this.aRV.toString());
            String valueOf2 = String.valueOf(this.aRX);
            return new StringBuilder(String.valueOf(valueOf).length() + 8 + String.valueOf(valueOf2).length()).append(valueOf).append(" (Tag: ").append(valueOf2).append(")").toString();
        }

        public zzc zzcoz() {
            return this.aRV;
        }

        public Long zzcpa() {
            return this.aRX;
        }

        public zzagy zzcpb() {
            return this.aRW;
        }
    }

    private static class zzf {
        private String aRS;
        /* access modifiers changed from: private */
        public zzahc aRT;
        private Map<String, Object> aRY;

        private zzf(String str, Map<String, Object> map, zzahc zzahc) {
            this.aRS = str;
            this.aRY = map;
            this.aRT = zzahc;
        }

        public String getAction() {
            return this.aRS;
        }

        public zzahc zzcoy() {
            return this.aRT;
        }

        public Map<String, Object> zzcpc() {
            return this.aRY;
        }
    }

    public zzaha(zzagv zzagv, zzagx zzagx, com.google.android.gms.internal.zzagz.zza zza2) {
        this.aRf = zza2;
        this.aRu = zzagv;
        this.aPL = zzagv.zzcoc();
        this.aQY = zzagv.zzcob();
        this.aQN = zzagx;
        this.aRr = new HashMap();
        this.aRo = new HashMap();
        this.aRq = new HashMap();
        this.aRp = new ArrayList();
        this.aRv = new com.google.android.gms.internal.zzahe.zza(this.aPL, zzagv.zzcoa(), "ConnectionRetryHelper").zzcd(1000).zzk(1.3d).zzce(30000).zzl(0.7d).zzcpo();
        long j = aQM;
        aQM = 1 + j;
        this.aPY = new zzajx(zzagv.zzcoa(), "PersistentConnection", "pc_" + j);
        this.aRw = null;
        zzcov();
    }

    private boolean isIdle() {
        return this.aRr.isEmpty() && this.aRo.isEmpty() && !this.aRA && this.aRq.isEmpty();
    }

    /* access modifiers changed from: private */
    public zze zza(zzc zzc2) {
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String valueOf = String.valueOf(zzc2);
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 15).append("removing query ").append(valueOf).toString(), new Object[0]);
        }
        if (!this.aRr.containsKey(zzc2)) {
            if (this.aPY.zzcum()) {
                zzajx zzajx2 = this.aPY;
                String valueOf2 = String.valueOf(zzc2);
                zzajx2.zzh(new StringBuilder(String.valueOf(valueOf2).length() + 64).append("Trying to remove listener for QuerySpec ").append(valueOf2).append(" but no listener exists.").toString(), new Object[0]);
            }
            return null;
        }
        zze zze2 = (zze) this.aRr.get(zzc2);
        this.aRr.remove(zzc2);
        zzcov();
        return zze2;
    }

    private Map<String, Object> zza(List<String> list, Object obj, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", zzagw.zzap(list));
        hashMap.put("d", obj);
        if (str != null) {
            hashMap.put("h", str);
        }
        return hashMap;
    }

    private void zza(zze zze2) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", zzagw.zzap(zze2.aRV.aRQ));
        Long zzcpa = zze2.zzcpa();
        if (zzcpa != null) {
            hashMap.put("q", zze2.zzcoz().aRR);
            hashMap.put("t", zzcpa);
        }
        zza("n", (Map<String, Object>) hashMap, (zza) null);
    }

    private void zza(String str, List<String> list, Object obj, final zzahc zzahc) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", zzagw.zzap(list));
        hashMap.put("d", obj);
        zza(str, (Map<String, Object>) hashMap, (zza) new zza() {
            public void zzbw(Map<String, Object> map) {
                String str = null;
                String str2 = (String) map.get("s");
                if (!str2.equals("ok")) {
                    str = (String) map.get("d");
                } else {
                    str2 = null;
                }
                if (zzahc != null) {
                    zzahc.zzbm(str2, str);
                }
            }
        });
    }

    private void zza(String str, List<String> list, Object obj, String str2, zzahc zzahc) {
        Map zza2 = zza(list, obj, str2);
        long j = this.aRm;
        this.aRm = 1 + j;
        this.aRq.put(Long.valueOf(j), new zzf(str, zza2, zzahc));
        if (zzcok()) {
            zzca(j);
        }
        this.aRz = System.currentTimeMillis();
        zzcov();
    }

    private void zza(String str, Map<String, Object> map, zza zza2) {
        zza(str, false, map, zza2);
    }

    private void zza(String str, boolean z, Map<String, Object> map, zza zza2) {
        long zzcou = zzcou();
        HashMap hashMap = new HashMap();
        hashMap.put("r", Long.valueOf(zzcou));
        hashMap.put("a", str);
        hashMap.put("b", map);
        this.aRk.zza(hashMap, z);
        this.aRo.put(Long.valueOf(zzcou), zza2);
    }

    /* access modifiers changed from: private */
    public void zza(List<String> list, zzc zzc2) {
        if (list.contains("no_index")) {
            String valueOf = String.valueOf(zzc2.aRR.get("i"));
            String sb = new StringBuilder(String.valueOf(valueOf).length() + 14).append("\".indexOn\": \"").append(valueOf).append("\"").toString();
            zzajx zzajx = this.aPY;
            String valueOf2 = String.valueOf(zzagw.zzap(zzc2.aRQ));
            zzajx.warn(new StringBuilder(String.valueOf(sb).length() + 118 + String.valueOf(valueOf2).length()).append("Using an unspecified index. Consider adding '").append(sb).append("' at ").append(valueOf2).append(" to your security and Firebase Database rules for better performance").toString());
        }
    }

    private Collection<zze> zzaq(List<String> list) {
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String valueOf = String.valueOf(list);
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 29).append("removing all listens at path ").append(valueOf).toString(), new Object[0]);
        }
        ArrayList<zze> arrayList = new ArrayList<>();
        for (Entry entry : this.aRr.entrySet()) {
            zzc zzc2 = (zzc) entry.getKey();
            zze zze2 = (zze) entry.getValue();
            if (zzc2.aRQ.equals(list)) {
                arrayList.add(zze2);
            }
        }
        for (zze zzcoz : arrayList) {
            this.aRr.remove(zzcoz.zzcoz());
        }
        zzcov();
        return arrayList;
    }

    private void zzar(List<String> list) {
        Collection<zze> zzaq = zzaq(list);
        if (zzaq != null) {
            for (zze zzd2 : zzaq) {
                zzd2.aRU.zzbm("permission_denied", null);
            }
        }
    }

    private void zzb(final zze zze2) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", zzagw.zzap(zze2.zzcoz().aRQ));
        Long zzcpa = zze2.zzcpa();
        if (zzcpa != null) {
            hashMap.put("q", zze2.aRV.aRR);
            hashMap.put("t", zzcpa);
        }
        zzagy zzcpb = zze2.zzcpb();
        hashMap.put("h", zzcpb.zzcof());
        if (zzcpb.zzcog()) {
            zzags zzcoh = zzcpb.zzcoh();
            ArrayList arrayList = new ArrayList();
            for (List zzap : zzcoh.zzcny()) {
                arrayList.add(zzagw.zzap(zzap));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("hs", zzcoh.zzcnz());
            hashMap2.put("ps", arrayList);
            hashMap.put("ch", hashMap2);
        }
        zza("q", (Map<String, Object>) hashMap, (zza) new zza() {
            public void zzbw(Map<String, Object> map) {
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    Map map2 = (Map) map.get("d");
                    if (map2.containsKey("w")) {
                        zzaha.this.zza((List) map2.get("w"), zze2.aRV);
                    }
                }
                if (((zze) zzaha.this.aRr.get(zze2.zzcoz())) != zze2) {
                    return;
                }
                if (!str.equals("ok")) {
                    zzaha.this.zza(zze2.zzcoz());
                    zze2.aRU.zzbm(str, (String) map.get("d"));
                    return;
                }
                zze2.aRU.zzbm(null, null);
            }
        });
    }

    private void zzbl(String str, String str2) {
        this.aPY.warn(new StringBuilder(String.valueOf(str).length() + 23 + String.valueOf(str2).length()).append("Auth token revoked: ").append(str).append(" (").append(str2).append(")").toString());
        this.aRs = null;
        this.aRt = true;
        this.aRf.zzcq(false);
        this.aRk.close();
    }

    private void zzbu(Map<String, Object> map) {
        this.aPY.info((String) map.get("msg"));
    }

    private void zzbv(Map<String, Integer> map) {
        if (!map.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("c", map);
            zza("s", (Map<String, Object>) hashMap, (zza) new zza() {
                public void zzbw(Map<String, Object> map) {
                    String str = (String) map.get("s");
                    if (!str.equals("ok")) {
                        String str2 = (String) map.get("d");
                        if (zzaha.this.aPY.zzcum()) {
                            zzaha.this.aPY.zzh(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length()).append("Failed to send stats: ").append(str).append(" (message: ").append(str2).append(")").toString(), new Object[0]);
                        }
                    }
                }
            });
        } else if (this.aPY.zzcum()) {
            this.aPY.zzh("Not sending stats because stats are empty", new Object[0]);
        }
    }

    private void zzbz(long j) {
        if (this.aPY.zzcum()) {
            this.aPY.zzh("handling timestamp", new Object[0]);
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("serverTimeOffset", Long.valueOf(currentTimeMillis));
        this.aRf.zzbt(hashMap);
    }

    private void zzca(long j) {
        if ($assertionsDisabled || zzcok()) {
            final zzf zzf2 = (zzf) this.aRq.get(Long.valueOf(j));
            final zzahc zzcoy = zzf2.zzcoy();
            final String action = zzf2.getAction();
            final long j2 = j;
            zza(action, zzf2.zzcpc(), (zza) new zza() {
                public void zzbw(Map<String, Object> map) {
                    if (zzaha.this.aPY.zzcum()) {
                        zzajx zza = zzaha.this.aPY;
                        String str = action;
                        String valueOf = String.valueOf(map);
                        zza.zzh(new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf).length()).append(str).append(" response: ").append(valueOf).toString(), new Object[0]);
                    }
                    if (((zzf) zzaha.this.aRq.get(Long.valueOf(j2))) == zzf2) {
                        zzaha.this.aRq.remove(Long.valueOf(j2));
                        if (zzcoy != null) {
                            String str2 = (String) map.get("s");
                            if (str2.equals("ok")) {
                                zzcoy.zzbm(null, null);
                            } else {
                                zzcoy.zzbm(str2, (String) map.get("d"));
                            }
                        }
                    } else if (zzaha.this.aPY.zzcum()) {
                        zzaha.this.aPY.zzh("Ignoring on complete for put " + j2 + " because it was removed already.", new Object[0]);
                    }
                    zzaha.this.zzcov();
                }
            });
            return;
        }
        throw new AssertionError("sendPut called when we can't send writes (we're disconnected or writes are paused).");
    }

    private boolean zzcoj() {
        return this.aRl == zzb.Authenticating || this.aRl == zzb.Connected;
    }

    private boolean zzcok() {
        return this.aRl == zzb.Connected;
    }

    /* access modifiers changed from: private */
    public void zzcom() {
        if (zzcol()) {
            zzagw.zzc(this.aRl == zzb.Disconnected, "Not in disconnected state: %s", this.aRl);
            final boolean z = this.aRt;
            this.aPY.zzh("Scheduling connection attempt", new Object[0]);
            this.aRt = false;
            this.aRv.zzq(new Runnable() {
                public void run() {
                    zzaha.this.aPY.zzh("Trying to fetch auth token", new Object[0]);
                    zzagw.zzc(zzaha.this.aRl == zzb.Disconnected, "Not in disconnected state: %s", zzaha.this.aRl);
                    zzaha.this.aRl = zzb.GettingToken;
                    zzaha.this.aRx = 1 + zzaha.this.aRx;
                    final long zzd = zzaha.this.aRx;
                    zzaha.this.aQY.zza(z, new com.google.android.gms.internal.zzagu.zza() {
                        public void onError(String str) {
                            if (zzd == zzaha.this.aRx) {
                                zzaha.this.aRl = zzb.Disconnected;
                                zzajx zza = zzaha.this.aPY;
                                String str2 = "Error fetching token: ";
                                String valueOf = String.valueOf(str);
                                zza.zzh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
                                zzaha.this.zzcom();
                                return;
                            }
                            zzaha.this.aPY.zzh("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
                        }

                        public void zzqy(String str) {
                            if (zzd != zzaha.this.aRx) {
                                zzaha.this.aPY.zzh("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
                            } else if (zzaha.this.aRl == zzb.GettingToken) {
                                zzaha.this.aPY.zzh("Successfully fetched token, opening connection", new Object[0]);
                                zzaha.this.zzrb(str);
                            } else {
                                zzagw.zzc(zzaha.this.aRl == zzb.Disconnected, "Expected connection state disconnected, but was %s", zzaha.this.aRl);
                                zzaha.this.aPY.zzh("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
                            }
                        }
                    });
                }
            });
        }
    }

    private void zzcon() {
        Iterator it = this.aRq.entrySet().iterator();
        while (it.hasNext()) {
            zzf zzf2 = (zzf) ((Entry) it.next()).getValue();
            if (zzf2.zzcpc().containsKey("h")) {
                zzf2.zzcoy().zzbm("disconnected", null);
                it.remove();
            }
        }
    }

    private void zzcoo() {
        zzcr(false);
    }

    private void zzcop() {
        zzcr(true);
    }

    private void zzcoq() {
        zzagw.zzc(zzcoj(), "Must be connected to send unauth.", new Object[0]);
        zzagw.zzc(this.aRs == null, "Auth token must not be set.", new Object[0]);
        zza("unauth", Collections.emptyMap(), (zza) null);
    }

    private void zzcor() {
        if (this.aPY.zzcum()) {
            this.aPY.zzh("calling restore state", new Object[0]);
        }
        zzagw.zzc(this.aRl == zzb.Connecting, "Wanted to restore auth, but was in wrong state: %s", this.aRl);
        if (this.aRs == null) {
            if (this.aPY.zzcum()) {
                this.aPY.zzh("Not restoring auth because token is null.", new Object[0]);
            }
            this.aRl = zzb.Connected;
            zzcos();
            return;
        }
        if (this.aPY.zzcum()) {
            this.aPY.zzh("Restoring auth.", new Object[0]);
        }
        this.aRl = zzb.Authenticating;
        zzcop();
    }

    /* access modifiers changed from: private */
    public void zzcos() {
        zzagw.zzc(this.aRl == zzb.Connected, "Should be connected if we're restoring state, but we are: %s", this.aRl);
        if (this.aPY.zzcum()) {
            this.aPY.zzh("Restoring outstanding listens", new Object[0]);
        }
        for (zze zze2 : this.aRr.values()) {
            if (this.aPY.zzcum()) {
                zzajx zzajx = this.aPY;
                String valueOf = String.valueOf(zze2.zzcoz());
                zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 17).append("Restoring listen ").append(valueOf).toString(), new Object[0]);
            }
            zzb(zze2);
        }
        if (this.aPY.zzcum()) {
            this.aPY.zzh("Restoring writes.", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.aRq.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzca(((Long) it.next()).longValue());
        }
        for (zzd zzd2 : this.aRp) {
            zza(zzd2.getAction(), zzd2.zzcox(), zzd2.getData(), zzd2.zzcoy());
        }
        this.aRp.clear();
    }

    private void zzcot() {
        HashMap hashMap = new HashMap();
        if (zzald.zzcwp()) {
            if (this.aRu.zzcod()) {
                hashMap.put("persistence.android.enabled", Integer.valueOf(1));
            }
            String str = "sdk.android.";
            String valueOf = String.valueOf(this.aRu.zzcoe().replace('.', '-'));
            hashMap.put(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), Integer.valueOf(1));
        } else if ($assertionsDisabled || !this.aRu.zzcod()) {
            String str2 = "sdk.java.";
            String valueOf2 = String.valueOf(this.aRu.zzcoe().replace('.', '-'));
            hashMap.put(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), Integer.valueOf(1));
        } else {
            throw new AssertionError("Stats for persistence on JVM missing (persistence not yet supported)");
        }
        if (this.aPY.zzcum()) {
            this.aPY.zzh("Sending first connection stats", new Object[0]);
        }
        zzbv(hashMap);
    }

    private long zzcou() {
        long j = this.aRn;
        this.aRn = 1 + j;
        return j;
    }

    /* access modifiers changed from: private */
    public void zzcov() {
        boolean z = false;
        if (isIdle()) {
            if (this.aRy != null) {
                this.aRy.cancel(false);
            }
            this.aRy = this.aPL.schedule(new Runnable() {
                public void run() {
                    zzaha.this.aRy = null;
                    if (zzaha.this.zzcow()) {
                        zzaha.this.interrupt("connection_idle");
                    } else {
                        zzaha.this.zzcov();
                    }
                }
            }, 60000, TimeUnit.MILLISECONDS);
        } else if (isInterrupted("connection_idle")) {
            if (!isIdle()) {
                z = true;
            }
            zzagw.zzcp(z);
            resume("connection_idle");
        }
    }

    /* access modifiers changed from: private */
    public boolean zzcow() {
        return isIdle() && System.currentTimeMillis() > this.aRz + 60000;
    }

    private void zzcr(final boolean z) {
        zzagw.zzc(zzcoj(), "Must be connected to send auth, but was: %s", this.aRl);
        zzagw.zzc(this.aRs != null, "Auth token must be set to authenticate!", new Object[0]);
        AnonymousClass3 r0 = new zza() {
            public void zzbw(Map<String, Object> map) {
                zzaha.this.aRl = zzb.Connected;
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    zzaha.this.aRf.zzcq(true);
                    if (z) {
                        zzaha.this.zzcos();
                        return;
                    }
                    return;
                }
                zzaha.this.aRs = null;
                zzaha.this.aRf.zzcq(false);
                String str2 = (String) map.get("d");
                zzaha.this.aPY.warn(new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(str2).length()).append("Authentication failed: ").append(str).append(" (").append(str2).append(")").toString());
                zzaha.this.aRk.close();
            }
        };
        HashMap hashMap = new HashMap();
        zzale zzrp = zzale.zzrp(this.aRs);
        if (zzrp != null) {
            hashMap.put("cred", zzrp.getToken());
            if (zzrp.getUid() != null) {
                hashMap.put("uid", zzrp.getUid());
            }
            zza("gauth", true, (Map<String, Object>) hashMap, (zza) r0);
            return;
        }
        hashMap.put("cred", this.aRs);
        zza("auth", true, (Map<String, Object>) hashMap, (zza) r0);
    }

    private void zzj(String str, Map<String, Object> map) {
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String valueOf = String.valueOf(map);
            zzajx.zzh(new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(valueOf).length()).append("handleServerMessage: ").append(str).append(" ").append(valueOf).toString(), new Object[0]);
        }
        if (str.equals("d") || str.equals("m")) {
            boolean equals = str.equals("m");
            String str2 = (String) map.get("p");
            Object obj = map.get("d");
            Long zzbp = zzagw.zzbp(map.get("t"));
            if (!equals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                this.aRf.zza(zzagw.zzqz(str2), obj, equals, zzbp);
            } else if (this.aPY.zzcum()) {
                zzajx zzajx2 = this.aPY;
                String str3 = "ignoring empty merge for path ";
                String valueOf2 = String.valueOf(str2);
                zzajx2.zzh(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3), new Object[0]);
            }
        } else if (str.equals("rm")) {
            String str4 = (String) map.get("p");
            List zzqz = zzagw.zzqz(str4);
            Object obj2 = map.get("d");
            Long zzbp2 = zzagw.zzbp(map.get("t"));
            List<Map> list = (List) obj2;
            ArrayList arrayList = new ArrayList();
            for (Map map2 : list) {
                String str5 = (String) map2.get("s");
                String str6 = (String) map2.get("e");
                arrayList.add(new zzahb(str5 != null ? zzagw.zzqz(str5) : null, str6 != null ? zzagw.zzqz(str6) : null, map2.get("m")));
            }
            if (!arrayList.isEmpty()) {
                this.aRf.zza(zzqz, arrayList, zzbp2);
            } else if (this.aPY.zzcum()) {
                zzajx zzajx3 = this.aPY;
                String str7 = "Ignoring empty range merge for path ";
                String valueOf3 = String.valueOf(str4);
                zzajx3.zzh(valueOf3.length() != 0 ? str7.concat(valueOf3) : new String(str7), new Object[0]);
            }
        } else if (str.equals("c")) {
            zzar(zzagw.zzqz((String) map.get("p")));
        } else if (str.equals("ac")) {
            zzbl((String) map.get("s"), (String) map.get("d"));
        } else if (str.equals("sd")) {
            zzbu(map);
        } else if (this.aPY.zzcum()) {
            zzajx zzajx4 = this.aPY;
            String str8 = "Unrecognized action from server: ";
            String valueOf4 = String.valueOf(str);
            zzajx4.zzh(valueOf4.length() != 0 ? str8.concat(valueOf4) : new String(str8), new Object[0]);
        }
    }

    public void initialize() {
        zzcom();
    }

    public void interrupt(String str) {
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String str2 = "Connection interrupted for: ";
            String valueOf = String.valueOf(str);
            zzajx.zzh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
        }
        this.aRh.add(str);
        if (this.aRk != null) {
            this.aRk.close();
            this.aRk = null;
        } else {
            this.aRv.cancel();
            this.aRl = zzb.Disconnected;
        }
        this.aRv.zzcle();
    }

    public boolean isInterrupted(String str) {
        return this.aRh.contains(str);
    }

    public void purgeOutstandingWrites() {
        for (zzf zzf2 : this.aRq.values()) {
            if (zzf2.aRT != null) {
                zzf2.aRT.zzbm("write_canceled", null);
            }
        }
        for (zzd zzd2 : this.aRp) {
            if (zzd2.aRT != null) {
                zzd2.aRT.zzbm("write_canceled", null);
            }
        }
        this.aRq.clear();
        this.aRp.clear();
        if (!zzcoj()) {
            this.aRA = false;
        }
        zzcov();
    }

    public void refreshAuthToken() {
        this.aPY.zzh("Auth token refresh requested", new Object[0]);
        interrupt("token_refresh");
        resume("token_refresh");
    }

    public void resume(String str) {
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String str2 = "Connection no longer interrupted for: ";
            String valueOf = String.valueOf(str);
            zzajx.zzh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
        }
        this.aRh.remove(str);
        if (zzcol() && this.aRl == zzb.Disconnected) {
            zzcom();
        }
    }

    public void shutdown() {
        interrupt("shutdown");
    }

    public void zza(List<String> list, zzahc zzahc) {
        if (zzcok()) {
            zza("oc", list, (Object) null, zzahc);
        } else {
            this.aRp.add(new zzd("oc", list, null, zzahc));
        }
        zzcov();
    }

    public void zza(List<String> list, Object obj, zzahc zzahc) {
        zza("p", list, obj, (String) null, zzahc);
    }

    public void zza(List<String> list, Object obj, String str, zzahc zzahc) {
        zza("p", list, obj, str, zzahc);
    }

    public void zza(List<String> list, Map<String, Object> map) {
        zzc zzc2 = new zzc(list, map);
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String valueOf = String.valueOf(zzc2);
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 15).append("unlistening on ").append(valueOf).toString(), new Object[0]);
        }
        zze zza2 = zza(zzc2);
        if (zza2 != null && zzcoj()) {
            zza(zza2);
        }
        zzcov();
    }

    public void zza(List<String> list, Map<String, Object> map, zzagy zzagy, Long l, zzahc zzahc) {
        zzc zzc2 = new zzc(list, map);
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String valueOf = String.valueOf(zzc2);
            zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 13).append("Listening on ").append(valueOf).toString(), new Object[0]);
        }
        zzagw.zzc(!this.aRr.containsKey(zzc2), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.aPY.zzcum()) {
            zzajx zzajx2 = this.aPY;
            String valueOf2 = String.valueOf(zzc2);
            zzajx2.zzh(new StringBuilder(String.valueOf(valueOf2).length() + 21).append("Adding listen query: ").append(valueOf2).toString(), new Object[0]);
        }
        zze zze2 = new zze(zzahc, zzc2, l, zzagy);
        this.aRr.put(zzc2, zze2);
        if (zzcoj()) {
            zzb(zze2);
        }
        zzcov();
    }

    public void zza(List<String> list, Map<String, Object> map, zzahc zzahc) {
        zza("m", list, (Object) map, (String) null, zzahc);
    }

    public void zzb(com.google.android.gms.internal.zzagt.zzb zzb2) {
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String str = "Got on disconnect due to ";
            String valueOf = String.valueOf(zzb2.name());
            zzajx.zzh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
        }
        this.aRl = zzb.Disconnected;
        this.aRk = null;
        this.aRA = false;
        this.aRo.clear();
        zzcon();
        if (zzcol()) {
            boolean z = this.aRj > 0 ? System.currentTimeMillis() - this.aRj > 30000 : false;
            if (zzb2 == com.google.android.gms.internal.zzagt.zzb.SERVER_RESET || z) {
                this.aRv.zzcle();
            }
            zzcom();
        }
        this.aRj = 0;
        this.aRf.onDisconnect();
    }

    public void zzb(List<String> list, Object obj, zzahc zzahc) {
        this.aRA = true;
        if (zzcok()) {
            zza("o", list, obj, zzahc);
        } else {
            this.aRp.add(new zzd("o", list, obj, zzahc));
        }
        zzcov();
    }

    public void zzb(List<String> list, Map<String, Object> map, zzahc zzahc) {
        this.aRA = true;
        if (zzcok()) {
            zza("om", list, (Object) map, zzahc);
        } else {
            this.aRp.add(new zzd("om", list, map, zzahc));
        }
        zzcov();
    }

    public void zzbq(Map<String, Object> map) {
        if (map.containsKey("r")) {
            zza zza2 = (zza) this.aRo.remove(Long.valueOf((long) ((Integer) map.get("r")).intValue()));
            if (zza2 != null) {
                zza2.zzbw((Map) map.get("b"));
            }
        } else if (map.containsKey("error")) {
        } else {
            if (map.containsKey("a")) {
                zzj((String) map.get("a"), (Map) map.get("b"));
            } else if (this.aPY.zzcum()) {
                zzajx zzajx = this.aPY;
                String valueOf = String.valueOf(map);
                zzajx.zzh(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Ignoring unknown message: ").append(valueOf).toString(), new Object[0]);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzcol() {
        return this.aRh.size() == 0;
    }

    public void zzj(long j, String str) {
        if (this.aPY.zzcum()) {
            this.aPY.zzh("onReady", new Object[0]);
        }
        this.aRj = System.currentTimeMillis();
        zzbz(j);
        if (this.aRi) {
            zzcot();
        }
        zzcor();
        this.aRi = false;
        this.aRw = str;
        this.aRf.zzcoi();
    }

    public void zzqw(String str) {
        this.aRg = str;
    }

    public void zzqx(String str) {
        if (this.aPY.zzcum()) {
            zzajx zzajx = this.aPY;
            String str2 = "Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: ";
            String valueOf = String.valueOf(str);
            zzajx.zzh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
        }
        interrupt("server_kill");
    }

    public void zzra(String str) {
        this.aPY.zzh("Auth token refreshed.", new Object[0]);
        this.aRs = str;
        if (!zzcoj()) {
            return;
        }
        if (str != null) {
            zzcoo();
        } else {
            zzcoq();
        }
    }

    public void zzrb(String str) {
        zzagw.zzc(this.aRl == zzb.GettingToken, "Trying to open network connection while in the wrong state: %s", this.aRl);
        if (str == null) {
            this.aRf.zzcq(false);
        }
        this.aRs = str;
        this.aRl = zzb.Connecting;
        this.aRk = new zzagt(this.aRu, this.aQN, this.aRg, this, this.aRw);
        this.aRk.open();
    }
}
