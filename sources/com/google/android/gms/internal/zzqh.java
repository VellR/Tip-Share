package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzh;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzd.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class zzqh implements Callback {
    private static zzqh uw;
    /* access modifiers changed from: private */
    public static final Object zzamp = new Object();
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */
    public final GoogleApiAvailability rX;
    /* access modifiers changed from: private */
    public long tU;
    /* access modifiers changed from: private */
    public long tV;
    /* access modifiers changed from: private */
    public final Map<zzpo<?>, zzc<?>> uA;
    private zzpw uB;
    /* access modifiers changed from: private */
    public final Set<zzpo<?>> uC;
    private final ReferenceQueue<com.google.android.gms.common.api.zzc<?>> uD;
    /* access modifiers changed from: private */
    public final SparseArray<zza> uE;
    private zzb uF;
    /* access modifiers changed from: private */
    public long uv;
    /* access modifiers changed from: private */
    public int ux;
    private final AtomicInteger uy;
    private final SparseArray<zzc<?>> uz;

    private final class zza extends PhantomReference<com.google.android.gms.common.api.zzc<?>> {
        /* access modifiers changed from: private */
        public final int sn;

        public zza(com.google.android.gms.common.api.zzc zzc, int i, ReferenceQueue<com.google.android.gms.common.api.zzc<?>> referenceQueue) {
            super(zzc, referenceQueue);
            this.sn = i;
        }

        public void zzaqd() {
            zzqh.this.mHandler.sendMessage(zzqh.this.mHandler.obtainMessage(2, this.sn, 2));
        }
    }

    private static final class zzb extends Thread {
        private final ReferenceQueue<com.google.android.gms.common.api.zzc<?>> uD;
        private final SparseArray<zza> uE;
        /* access modifiers changed from: private */
        public final AtomicBoolean uH = new AtomicBoolean();

        public zzb(ReferenceQueue<com.google.android.gms.common.api.zzc<?>> referenceQueue, SparseArray<zza> sparseArray) {
            super("GoogleApiCleanup");
            this.uD = referenceQueue;
            this.uE = sparseArray;
        }

        public void run() {
            this.uH.set(true);
            Process.setThreadPriority(10);
            while (this.uH.get()) {
                try {
                    zza zza = (zza) this.uD.remove();
                    this.uE.remove(zza.sn);
                    zza.zzaqd();
                } catch (InterruptedException e) {
                    return;
                } finally {
                    this.uH.set(false);
                }
            }
        }
    }

    private class zzc<O extends ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener {
        private final zzpo<O> rG;
        private boolean tT;
        private final Queue<zzpn> uI = new LinkedList();
        private final zze uJ;
        private final com.google.android.gms.common.api.Api.zzb uK;
        private final SparseArray<zzrd> uL = new SparseArray<>();
        private final Set<zzpq> uM = new HashSet();
        private final SparseArray<Map<Object, com.google.android.gms.internal.zzpr.zza>> uN = new SparseArray<>();
        private ConnectionResult uO = null;

        @WorkerThread
        public zzc(com.google.android.gms.common.api.zzc<O> zzc) {
            this.uJ = zzb((com.google.android.gms.common.api.zzc) zzc);
            if (this.uJ instanceof zzah) {
                this.uK = ((zzah) this.uJ).zzatj();
            } else {
                this.uK = this.uJ;
            }
            this.rG = zzc.zzany();
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void connect() {
            if (!this.uJ.isConnected() && !this.uJ.isConnecting()) {
                if (this.uJ.zzanr() && zzqh.this.ux != 0) {
                    zzqh.this.ux = zzqh.this.rX.isGooglePlayServicesAvailable(zzqh.this.mContext);
                    if (zzqh.this.ux != 0) {
                        onConnectionFailed(new ConnectionResult(zzqh.this.ux, null));
                        return;
                    }
                }
                this.uJ.zza(new zzd(this.uJ, this.rG));
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void resume() {
            if (this.tT) {
                connect();
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void zzab(Status status) {
            for (zzpn zzx : this.uI) {
                zzx.zzx(status);
            }
            this.uI.clear();
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void zzapr() {
            if (this.tT) {
                zzaqh();
                zzab(zzqh.this.rX.isGooglePlayServicesAvailable(zzqh.this.mContext) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.uJ.disconnect();
            }
        }

        @WorkerThread
        private void zzaqh() {
            if (this.tT) {
                zzqh.this.mHandler.removeMessages(9, this.rG);
                zzqh.this.mHandler.removeMessages(8, this.rG);
                this.tT = false;
            }
        }

        private void zzaqi() {
            zzqh.this.mHandler.removeMessages(10, this.rG);
            zzqh.this.mHandler.sendMessageDelayed(zzqh.this.mHandler.obtainMessage(10, this.rG), zzqh.this.uv);
        }

        /* access modifiers changed from: private */
        public void zzaqj() {
            if (this.uJ.isConnected() && this.uN.size() == 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.uL.size()) {
                        this.uJ.disconnect();
                        return;
                    } else if (((zzrd) this.uL.get(this.uL.keyAt(i2))).zzaqw()) {
                        zzaqi();
                        return;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
        }

        @WorkerThread
        private zze zzb(com.google.android.gms.common.api.zzc zzc) {
            Api zzanw = zzc.zzanw();
            if (!zzanw.zzanq()) {
                return zzc.zzanw().zzann().zza(zzc.getApplicationContext(), zzqh.this.mHandler.getLooper(), zzg.zzcd(zzc.getApplicationContext()), zzc.zzanx(), this, this);
            }
            zzh zzano = zzanw.zzano();
            return new zzah(zzc.getApplicationContext(), zzqh.this.mHandler.getLooper(), zzano.zzant(), this, this, zzg.zzcd(zzc.getApplicationContext()), zzano.zzs(zzc.zzanx()));
        }

        @WorkerThread
        private void zzc(zzpn zzpn) {
            Map map;
            zzpn.zza(this.uL);
            if (zzpn.it == 3) {
                try {
                    Map map2 = (Map) this.uN.get(zzpn.sn);
                    if (map2 == null) {
                        ArrayMap arrayMap = new ArrayMap(1);
                        this.uN.put(zzpn.sn, arrayMap);
                        map = arrayMap;
                    } else {
                        map = map2;
                    }
                    com.google.android.gms.internal.zzpr.zza<? extends Result, com.google.android.gms.common.api.Api.zzb> zza = ((com.google.android.gms.internal.zzpn.zza) zzpn).so;
                    map.put(((zzqr) zza).zzaqq(), zza);
                } catch (ClassCastException e) {
                    throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
                }
            } else if (zzpn.it == 4) {
                try {
                    Map map3 = (Map) this.uN.get(zzpn.sn);
                    zzqr zzqr = (zzqr) ((com.google.android.gms.internal.zzpn.zza) zzpn).so;
                    if (map3 != null) {
                        map3.remove(zzqr.zzaqq());
                    } else {
                        Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
                    }
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
                }
            }
            try {
                zzpn.zzb(this.uK);
            } catch (DeadObjectException e3) {
                this.uJ.disconnect();
                onConnectionSuspended(1);
            }
        }

        @WorkerThread
        private void zzj(ConnectionResult connectionResult) {
            for (zzpq zza : this.uM) {
                zza.zza(this.rG, connectionResult);
            }
            this.uM.clear();
        }

        /* access modifiers changed from: 0000 */
        public boolean isConnected() {
            return this.uJ.isConnected();
        }

        @WorkerThread
        public void onConnected(@Nullable Bundle bundle) {
            zzaqf();
            zzj(ConnectionResult.qR);
            zzaqh();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.uN.size()) {
                    for (com.google.android.gms.internal.zzpr.zza zzb : ((Map) this.uN.get(this.uN.keyAt(i2))).values()) {
                        try {
                            zzb.zzb(this.uK);
                        } catch (DeadObjectException e) {
                            this.uJ.disconnect();
                            onConnectionSuspended(1);
                        }
                    }
                    i = i2 + 1;
                } else {
                    zzaqe();
                    zzaqi();
                    return;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
            if (r5.uG.zzc(r6, r0) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
            if (r6.getErrorCode() != 18) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
            r5.tT = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
            if (r5.tT == false) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
            com.google.android.gms.internal.zzqh.zza(r5.uG).sendMessageDelayed(android.os.Message.obtain(com.google.android.gms.internal.zzqh.zza(r5.uG), 8, r5.rG), com.google.android.gms.internal.zzqh.zzb(r5.uG));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
            r2 = java.lang.String.valueOf(r5.rG.zzaok());
            zzab(new com.google.android.gms.common.api.Status(17, new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 38).append("API: ").append(r2).append(" is not available on this device.").toString()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        @WorkerThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzaqf();
            zzqh.this.ux = -1;
            zzj(connectionResult);
            int keyAt = this.uL.keyAt(0);
            if (this.uI.isEmpty()) {
                this.uO = connectionResult;
                return;
            }
            synchronized (zzqh.zzamp) {
                if (zzqh.zzd(zzqh.this) != null && zzqh.this.uC.contains(this.rG)) {
                    zzqh.zzd(zzqh.this).zzb(connectionResult, keyAt);
                }
            }
        }

        @WorkerThread
        public void onConnectionSuspended(int i) {
            zzaqf();
            this.tT = true;
            zzqh.this.mHandler.sendMessageDelayed(Message.obtain(zzqh.this.mHandler, 8, this.rG), zzqh.this.tV);
            zzqh.this.mHandler.sendMessageDelayed(Message.obtain(zzqh.this.mHandler, 9, this.rG), zzqh.this.tU);
            zzqh.this.ux = -1;
        }

        @WorkerThread
        public void zzaqe() {
            while (this.uJ.isConnected() && !this.uI.isEmpty()) {
                zzc((zzpn) this.uI.remove());
            }
        }

        @WorkerThread
        public void zzaqf() {
            this.uO = null;
        }

        /* access modifiers changed from: 0000 */
        public ConnectionResult zzaqg() {
            return this.uO;
        }

        @WorkerThread
        public void zzb(zzpn zzpn) {
            if (this.uJ.isConnected()) {
                zzc(zzpn);
                zzaqi();
                return;
            }
            this.uI.add(zzpn);
            if (this.uO == null || !this.uO.hasResolution()) {
                connect();
            } else {
                onConnectionFailed(this.uO);
            }
        }

        @WorkerThread
        public void zzb(zzpq zzpq) {
            this.uM.add(zzpq);
        }

        @WorkerThread
        public void zzf(int i, boolean z) {
            Iterator it = this.uI.iterator();
            while (it.hasNext()) {
                zzpn zzpn = (zzpn) it.next();
                if (zzpn.sn == i && zzpn.it != 1 && zzpn.cancel()) {
                    it.remove();
                }
            }
            ((zzrd) this.uL.get(i)).release();
            this.uN.delete(i);
            if (!z) {
                this.uL.remove(i);
                zzqh.this.uE.remove(i);
                if (this.uL.size() == 0 && this.uI.isEmpty()) {
                    zzaqh();
                    this.uJ.disconnect();
                    zzqh.this.uA.remove(this.rG);
                    synchronized (zzqh.zzamp) {
                        zzqh.this.uC.remove(this.rG);
                    }
                }
            }
        }

        @WorkerThread
        public void zzfk(int i) {
            this.uL.put(i, new zzrd(this.rG.zzanp(), this.uJ));
        }
    }

    private class zzd implements zzf {
        private final zzpo<?> rG;
        private final zze uJ;

        public zzd(zze zze, zzpo<?> zzpo) {
            this.uJ = zze;
            this.rG = zzpo;
        }

        @WorkerThread
        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.uJ.zza(null, Collections.emptySet());
            } else {
                ((zzc) zzqh.this.uA.get(this.rG)).onConnectionFailed(connectionResult);
            }
        }
    }

    private zzqh(Context context) {
        this(context, GoogleApiAvailability.getInstance());
    }

    private zzqh(Context context, GoogleApiAvailability googleApiAvailability) {
        this.tV = 5000;
        this.tU = 120000;
        this.uv = 10000;
        this.ux = -1;
        this.uy = new AtomicInteger(1);
        this.uz = new SparseArray<>();
        this.uA = new ConcurrentHashMap(5, 0.75f, 1);
        this.uB = null;
        this.uC = new com.google.android.gms.common.util.zza();
        this.uD = new ReferenceQueue<>();
        this.uE = new SparseArray<>();
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        this.rX = googleApiAvailability;
    }

    private int zza(com.google.android.gms.common.api.zzc<?> zzc2) {
        int andIncrement = this.uy.getAndIncrement();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, andIncrement, 0, zzc2));
        return andIncrement;
    }

    public static Pair<zzqh, Integer> zza(Context context, com.google.android.gms.common.api.zzc<?> zzc2) {
        Pair<zzqh, Integer> create;
        synchronized (zzamp) {
            if (uw == null) {
                uw = new zzqh(context.getApplicationContext());
            }
            create = Pair.create(uw, Integer.valueOf(uw.zza(zzc2)));
        }
        return create;
    }

    @WorkerThread
    private void zza(com.google.android.gms.common.api.zzc<?> zzc2, int i) {
        zzpo zzany = zzc2.zzany();
        if (!this.uA.containsKey(zzany)) {
            this.uA.put(zzany, new zzc(zzc2));
        }
        zzc zzc3 = (zzc) this.uA.get(zzany);
        zzc3.zzfk(i);
        this.uz.put(i, zzc3);
        zzc3.connect();
        this.uE.put(i, new zza(zzc2, i, this.uD));
        if (this.uF == null || !this.uF.uH.get()) {
            this.uF = new zzb(this.uD, this.uE);
            this.uF.start();
        }
    }

    @WorkerThread
    private void zza(zzpn zzpn) {
        ((zzc) this.uz.get(zzpn.sn)).zzb(zzpn);
    }

    public static zzqh zzaqa() {
        zzqh zzqh;
        synchronized (zzamp) {
            zzqh = uw;
        }
        return zzqh;
    }

    @WorkerThread
    private void zzaqb() {
        for (zzc zzc2 : this.uA.values()) {
            zzc2.zzaqf();
            zzc2.connect();
        }
    }

    static /* synthetic */ zzpw zzd(zzqh zzqh) {
        return null;
    }

    @WorkerThread
    private void zze(int i, boolean z) {
        zzc zzc2 = (zzc) this.uz.get(i);
        if (zzc2 != null) {
            if (!z) {
                this.uz.delete(i);
            }
            zzc2.zzf(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", "onRelease received for unknown instance: " + i, new Exception());
    }

    @WorkerThread
    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case 1:
                zza((zzpq) message.obj);
                break;
            case 2:
            case 7:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                zze(i, z);
                break;
            case 3:
                zzaqb();
                break;
            case 4:
                zza((zzpn) message.obj);
                break;
            case 5:
                if (this.uz.get(message.arg1) != null) {
                    ((zzc) this.uz.get(message.arg1)).zzab(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case 6:
                zza((com.google.android.gms.common.api.zzc) message.obj, message.arg1);
                break;
            case 8:
                if (this.uA.containsKey(message.obj)) {
                    ((zzc) this.uA.get(message.obj)).resume();
                    break;
                }
                break;
            case 9:
                if (this.uA.containsKey(message.obj)) {
                    ((zzc) this.uA.get(message.obj)).zzapr();
                    break;
                }
                break;
            case 10:
                if (this.uA.containsKey(message.obj)) {
                    ((zzc) this.uA.get(message.obj)).zzaqj();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }

    public void zza(ConnectionResult connectionResult, int i) {
        if (!zzc(connectionResult, i)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i, 0));
        }
    }

    public <O extends ApiOptions> void zza(com.google.android.gms.common.api.zzc<O> zzc2, int i, com.google.android.gms.internal.zzpr.zza<? extends Result, com.google.android.gms.common.api.Api.zzb> zza2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new com.google.android.gms.internal.zzpn.zza(zzc2.getInstanceId(), i, zza2)));
    }

    public <O extends ApiOptions, TResult> void zza(com.google.android.gms.common.api.zzc<O> zzc2, int i, zzrb<com.google.android.gms.common.api.Api.zzb, TResult> zzrb, TaskCompletionSource<TResult> taskCompletionSource) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new com.google.android.gms.internal.zzpn.zzb(zzc2.getInstanceId(), i, zzrb, taskCompletionSource)));
    }

    @WorkerThread
    public void zza(zzpq zzpq) {
        for (zzpo zzpo : zzpq.zzaon()) {
            zzc zzc2 = (zzc) this.uA.get(zzpo);
            if (zzc2 == null) {
                zzpq.cancel();
                return;
            } else if (zzc2.isConnected()) {
                zzpq.zza(zzpo, ConnectionResult.qR);
            } else if (zzc2.zzaqg() != null) {
                zzpq.zza(zzpo, zzc2.zzaqg());
            } else {
                zzc2.zzb(zzpq);
            }
        }
    }

    public void zza(zzpw zzpw) {
        synchronized (zzamp) {
            if (zzpw == null) {
                this.uB = null;
                this.uC.clear();
            }
        }
    }

    public void zzaol() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    /* access modifiers changed from: 0000 */
    public boolean zzc(ConnectionResult connectionResult, int i) {
        if (!connectionResult.hasResolution() && !this.rX.isUserResolvableError(connectionResult.getErrorCode())) {
            return false;
        }
        this.rX.zza(this.mContext, connectionResult, i);
        return true;
    }

    public void zzd(int i, boolean z) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i, z ? 1 : 2));
    }
}
