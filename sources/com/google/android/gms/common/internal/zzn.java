package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzn extends zzm implements Callback {
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final HashMap<zza, zzb> yB = new HashMap<>();
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.stats.zzb yC;
    private final long yD;
    /* access modifiers changed from: private */
    public final Context zzaqj;

    private static final class zza {
        private final String yE;
        private final ComponentName yF;
        private final String zzcvf;

        public zza(ComponentName componentName) {
            this.zzcvf = null;
            this.yE = null;
            this.yF = (ComponentName) zzab.zzaa(componentName);
        }

        public zza(String str, String str2) {
            this.zzcvf = zzab.zzhs(str);
            this.yE = zzab.zzhs(str2);
            this.yF = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return zzaa.equal(this.zzcvf, zza.zzcvf) && zzaa.equal(this.yF, zza.yF);
        }

        public int hashCode() {
            return zzaa.hashCode(this.zzcvf, this.yF);
        }

        public String toString() {
            return this.zzcvf == null ? this.yF.flattenToString() : this.zzcvf;
        }

        public Intent zzasu() {
            return this.zzcvf != null ? new Intent(this.zzcvf).setPackage(this.yE) : new Intent().setComponent(this.yF);
        }
    }

    private final class zzb {
        /* access modifiers changed from: private */
        public int mState = 2;
        /* access modifiers changed from: private */
        public IBinder xA;
        /* access modifiers changed from: private */
        public ComponentName yF;
        private final zza yG = new zza();
        /* access modifiers changed from: private */
        public final Set<ServiceConnection> yH = new HashSet();
        private boolean yI;
        /* access modifiers changed from: private */
        public final zza yJ;

        public class zza implements ServiceConnection {
            public zza() {
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (zzn.this.yB) {
                    zzb.this.xA = iBinder;
                    zzb.this.yF = componentName;
                    for (ServiceConnection onServiceConnected : zzb.this.yH) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    zzb.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (zzn.this.yB) {
                    zzb.this.xA = null;
                    zzb.this.yF = componentName;
                    for (ServiceConnection onServiceDisconnected : zzb.this.yH) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zza2) {
            this.yJ = zza2;
        }

        public IBinder getBinder() {
            return this.xA;
        }

        public ComponentName getComponentName() {
            return this.yF;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.yI;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            zzn.this.yC.zza(zzn.this.zzaqj, serviceConnection, str, this.yJ.zzasu());
            this.yH.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.yH.contains(serviceConnection);
        }

        public boolean zzasv() {
            return this.yH.isEmpty();
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            zzn.this.yC.zzb(zzn.this.zzaqj, serviceConnection);
            this.yH.remove(serviceConnection);
        }

        @TargetApi(14)
        public void zzhn(String str) {
            this.mState = 3;
            this.yI = zzn.this.yC.zza(zzn.this.zzaqj, str, this.yJ.zzasu(), (ServiceConnection) this.yG, 129);
            if (!this.yI) {
                this.mState = 2;
                try {
                    zzn.this.yC.zza(zzn.this.zzaqj, (ServiceConnection) this.yG);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public void zzho(String str) {
            zzn.this.yC.zza(zzn.this.zzaqj, (ServiceConnection) this.yG);
            this.yI = false;
            this.mState = 2;
        }
    }

    zzn(Context context) {
        this.zzaqj = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.yC = com.google.android.gms.common.stats.zzb.zzaut();
        this.yD = 5000;
    }

    private boolean zza(zza zza2, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzab.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.yB) {
            zzb zzb2 = (zzb) this.yB.get(zza2);
            if (zzb2 != null) {
                this.mHandler.removeMessages(0, zzb2);
                if (!zzb2.zza(serviceConnection)) {
                    zzb2.zza(serviceConnection, str);
                    switch (zzb2.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzb2.getComponentName(), zzb2.getBinder());
                            break;
                        case 2:
                            zzb2.zzhn(str);
                            break;
                    }
                } else {
                    String valueOf = String.valueOf(zza2);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
                }
            } else {
                zzb2 = new zzb(zza2);
                zzb2.zza(serviceConnection, str);
                zzb2.zzhn(str);
                this.yB.put(zza2, zzb2);
            }
            isBound = zzb2.isBound();
        }
        return isBound;
    }

    private void zzb(zza zza2, ServiceConnection serviceConnection, String str) {
        zzab.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.yB) {
            zzb zzb2 = (zzb) this.yB.get(zza2);
            if (zzb2 == null) {
                String valueOf = String.valueOf(zza2);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (!zzb2.zza(serviceConnection)) {
                String valueOf2 = String.valueOf(zza2);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf2).toString());
            } else {
                zzb2.zzb(serviceConnection, str);
                if (zzb2.zzasv()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzb2), this.yD);
                }
            }
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                zzb zzb2 = (zzb) message.obj;
                synchronized (this.yB) {
                    if (zzb2.zzasv()) {
                        if (zzb2.isBound()) {
                            zzb2.zzho("GmsClientSupervisor");
                        }
                        this.yB.remove(zzb2.yJ);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    public boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return zza(new zza(str, str2), serviceConnection, str3);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    public void zzb(String str, String str2, ServiceConnection serviceConnection, String str3) {
        zzb(new zza(str, str2), serviceConnection, str3);
    }
}
