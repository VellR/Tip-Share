package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzl implements Callback {
    private final Handler mHandler;
    private final zza ys;
    private final ArrayList<ConnectionCallbacks> yt = new ArrayList<>();
    final ArrayList<ConnectionCallbacks> yu = new ArrayList<>();
    private final ArrayList<OnConnectionFailedListener> yv = new ArrayList<>();
    private volatile boolean yw = false;
    private final AtomicInteger yx = new AtomicInteger(0);
    private boolean yy = false;
    private final Object zzail = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzamc();
    }

    public zzl(Looper looper, zza zza2) {
        this.ys = zza2;
        this.mHandler = new Handler(looper, this);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message.obj;
            synchronized (this.zzail) {
                if (this.yw && this.ys.isConnected() && this.yt.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.ys.zzamc());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzab.zzaa(connectionCallbacks);
        synchronized (this.zzail) {
            contains = this.yt.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzab.zzaa(onConnectionFailedListener);
        synchronized (this.zzail) {
            contains = this.yv.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        zzab.zzaa(connectionCallbacks);
        synchronized (this.zzail) {
            if (this.yt.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.yt.add(connectionCallbacks);
            }
        }
        if (this.ys.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzaa(onConnectionFailedListener);
        synchronized (this.zzail) {
            if (this.yv.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.yv.add(onConnectionFailedListener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        zzab.zzaa(connectionCallbacks);
        synchronized (this.zzail) {
            if (!this.yt.remove(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(valueOf).append(" not found").toString());
            } else if (this.yy) {
                this.yu.add(connectionCallbacks);
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzaa(onConnectionFailedListener);
        synchronized (this.zzail) {
            if (!this.yv.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public void zzass() {
        this.yw = false;
        this.yx.incrementAndGet();
    }

    public void zzast() {
        this.yw = true;
    }

    public void zzgb(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            z = true;
        }
        zzab.zza(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzail) {
            this.yy = true;
            ArrayList arrayList = new ArrayList(this.yt);
            int i2 = this.yx.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.yw || this.yx.get() != i2) {
                    break;
                } else if (this.yt.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.yu.clear();
            this.yy = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    public void zzm(ConnectionResult connectionResult) {
        zzab.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onConnectionFailure must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzail) {
            ArrayList arrayList = new ArrayList(this.yv);
            int i = this.yx.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) it.next();
                if (this.yw && this.yx.get() == i) {
                    if (this.yv.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.onConnectionFailed(connectionResult);
                    }
                }
            }
        }
    }

    public void zzo(Bundle bundle) {
        boolean z = true;
        zzab.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zzail) {
            zzab.zzbm(!this.yy);
            this.mHandler.removeMessages(1);
            this.yy = true;
            if (this.yu.size() != 0) {
                z = false;
            }
            zzab.zzbm(z);
            ArrayList arrayList = new ArrayList(this.yt);
            int i = this.yx.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.yw || !this.ys.isConnected() || this.yx.get() != i) {
                    break;
                } else if (!this.yu.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.yu.clear();
            this.yy = false;
        }
    }
}
