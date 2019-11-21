package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<T extends IInterface> {
    public static final String[] xt = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final com.google.android.gms.common.zzc tp;
    private int xb;
    private long xc;
    private long xd;
    private int xe;
    private long xf;
    private final zzm xg;
    /* access modifiers changed from: private */
    public final Object xh;
    /* access modifiers changed from: private */
    public zzu xi;
    /* access modifiers changed from: private */
    public zzf xj;
    private T xk;
    /* access modifiers changed from: private */
    public final ArrayList<zze<?>> xl;
    private zzh xm;
    private int xn;
    /* access modifiers changed from: private */
    public final zzb xo;
    /* access modifiers changed from: private */
    public final zzc xp;
    private final int xq;
    private final String xr;
    protected AtomicInteger xs;
    private final Looper zzahv;
    private final Object zzail;

    private abstract class zza extends zze<Boolean> {
        public final int statusCode;
        public final Bundle xu;

        @BinderThread
        protected zza(int i, Bundle bundle) {
            super(Boolean.valueOf(true));
            this.statusCode = i;
            this.xu = bundle;
        }

        /* access modifiers changed from: protected */
        public abstract boolean zzarz();

        /* access modifiers changed from: protected */
        public void zzasa() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzc */
        public void zzx(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                zzd.this.zzb(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!zzarz()) {
                        zzd.this.zzb(1, null);
                        zzl(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    zzd.this.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    zzd.this.zzb(1, null);
                    if (this.xu != null) {
                        pendingIntent = (PendingIntent) this.xu.getParcelable("pendingIntent");
                    }
                    zzl(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzl(ConnectionResult connectionResult);
    }

    public interface zzb {
        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface zzc {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.zzd$zzd reason: collision with other inner class name */
    final class C0009zzd extends Handler {
        public C0009zzd(Looper looper) {
            super(looper);
        }

        private void zza(Message message) {
            zze zze = (zze) message.obj;
            zze.zzasa();
            zze.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (zzd.this.xs.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !zzd.this.isConnecting()) {
                zza(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                zzd.this.xj.zzh(connectionResult);
                zzd.this.onConnectionFailed(connectionResult);
            } else if (message.what == 4) {
                zzd.this.zzb(4, null);
                if (zzd.this.xo != null) {
                    zzd.this.xo.onConnectionSuspended(message.arg2);
                }
                zzd.this.onConnectionSuspended(message.arg2);
                zzd.this.zza(4, 1, null);
            } else if (message.what == 2 && !zzd.this.isConnected()) {
                zza(message);
            } else if (zzb(message)) {
                ((zze) message.obj).zzasb();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    protected abstract class zze<TListener> {
        private TListener mListener;
        private boolean xw = false;

        public zze(TListener tlistener) {
            this.mListener = tlistener;
        }

        public void unregister() {
            zzasc();
            synchronized (zzd.this.xl) {
                zzd.this.xl.remove(this);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzasa();

        public void zzasb() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.xw) {
                    String valueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (tlistener != null) {
                try {
                    zzx(tlistener);
                } catch (RuntimeException e) {
                    zzasa();
                    throw e;
                }
            } else {
                zzasa();
            }
            synchronized (this) {
                this.xw = true;
            }
            unregister();
        }

        public void zzasc() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzx(TListener tlistener);
    }

    public interface zzf {
        void zzh(@NonNull ConnectionResult connectionResult);
    }

    public static final class zzg extends com.google.android.gms.common.internal.zzt.zza {
        private zzd xx;
        private final int xy;

        public zzg(@NonNull zzd zzd, int i) {
            this.xx = zzd;
            this.xy = i;
        }

        private void zzasd() {
            this.xx = null;
        }

        @BinderThread
        public void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            zzab.zzb(this.xx, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.xx.zza(i, iBinder, bundle, this.xy);
            zzasd();
        }

        @BinderThread
        public void zzb(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    public final class zzh implements ServiceConnection {
        private final int xy;

        public zzh(int i) {
            this.xy = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzab.zzb(iBinder, (Object) "Expecting a valid IBinder");
            synchronized (zzd.this.xh) {
                zzd.this.xi = com.google.android.gms.common.internal.zzu.zza.zzdt(iBinder);
            }
            zzd.this.zza(0, (Bundle) null, this.xy);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (zzd.this.xh) {
                zzd.this.xi = null;
            }
            zzd.this.mHandler.sendMessage(zzd.this.mHandler.obtainMessage(4, this.xy, 1));
        }
    }

    protected class zzi implements zzf {
        public zzi() {
        }

        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zzd.this.zza((zzq) null, zzd.this.zzary());
            } else if (zzd.this.xp != null) {
                zzd.this.xp.onConnectionFailed(connectionResult);
            }
        }
    }

    protected final class zzj extends zza {
        public final IBinder xz;

        @BinderThread
        public zzj(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.xz = iBinder;
        }

        /* access modifiers changed from: protected */
        public boolean zzarz() {
            try {
                String interfaceDescriptor = this.xz.getInterfaceDescriptor();
                if (!zzd.this.zzrb().equals(interfaceDescriptor)) {
                    String valueOf = String.valueOf(zzd.this.zzrb());
                    Log.e("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 34 + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
                    return false;
                }
                IInterface zzbb = zzd.this.zzbb(this.xz);
                if (zzbb == null || !zzd.this.zza(2, 3, zzbb)) {
                    return false;
                }
                Bundle zzamc = zzd.this.zzamc();
                if (zzd.this.xo != null) {
                    zzd.this.xo.onConnected(zzamc);
                }
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public void zzl(ConnectionResult connectionResult) {
            if (zzd.this.xp != null) {
                zzd.this.xp.onConnectionFailed(connectionResult);
            }
            zzd.this.onConnectionFailed(connectionResult);
        }
    }

    protected final class zzk extends zza {
        @BinderThread
        public zzk(int i, Bundle bundle) {
            super(i, bundle);
        }

        /* access modifiers changed from: protected */
        public boolean zzarz() {
            zzd.this.xj.zzh(ConnectionResult.qR);
            return true;
        }

        /* access modifiers changed from: protected */
        public void zzl(ConnectionResult connectionResult) {
            zzd.this.xj.zzh(connectionResult);
            zzd.this.onConnectionFailed(connectionResult);
        }
    }

    protected zzd(Context context, Looper looper, int i, zzb zzb2, zzc zzc2, String str) {
        this(context, looper, zzm.zzce(context), com.google.android.gms.common.zzc.zzand(), i, (zzb) zzab.zzaa(zzb2), (zzc) zzab.zzaa(zzc2), str);
    }

    protected zzd(Context context, Looper looper, zzm zzm, com.google.android.gms.common.zzc zzc2, int i, zzb zzb2, zzc zzc3, String str) {
        this.zzail = new Object();
        this.xh = new Object();
        this.xl = new ArrayList<>();
        this.xn = 1;
        this.xs = new AtomicInteger(0);
        this.mContext = (Context) zzab.zzb(context, (Object) "Context must not be null");
        this.zzahv = (Looper) zzab.zzb(looper, (Object) "Looper must not be null");
        this.xg = (zzm) zzab.zzb(zzm, (Object) "Supervisor must not be null");
        this.tp = (com.google.android.gms.common.zzc) zzab.zzb(zzc2, (Object) "API availability must not be null");
        this.mHandler = new C0009zzd(looper);
        this.xq = i;
        this.xo = zzb2;
        this.xp = zzc3;
        this.xr = str;
    }

    /* access modifiers changed from: private */
    public boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zzail) {
            if (this.xn != i) {
                z = false;
            } else {
                zzb(i2, t);
                z = true;
            }
        }
        return z;
    }

    private void zzarr() {
        if (this.xm != null) {
            String valueOf = String.valueOf(zzra());
            String valueOf2 = String.valueOf(zzarp());
            Log.e("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.xg.zzb(zzra(), zzarp(), this.xm, zzarq());
            this.xs.incrementAndGet();
        }
        this.xm = new zzh(this.xs.get());
        if (!this.xg.zza(zzra(), zzarp(), this.xm, zzarq())) {
            String valueOf3 = String.valueOf(zzra());
            String valueOf4 = String.valueOf(zzarp());
            Log.e("GmsClient", new StringBuilder(String.valueOf(valueOf3).length() + 34 + String.valueOf(valueOf4).length()).append("unable to connect to service: ").append(valueOf3).append(" on ").append(valueOf4).toString());
            zza(16, (Bundle) null, this.xs.get());
        }
    }

    private void zzars() {
        if (this.xm != null) {
            this.xg.zzb(zzra(), zzarp(), this.xm, zzarq());
            this.xm = null;
        }
    }

    /* access modifiers changed from: private */
    public void zzb(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        zzab.zzbn(z);
        synchronized (this.zzail) {
            this.xn = i;
            this.xk = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzars();
                    break;
                case 2:
                    zzarr();
                    break;
                case 3:
                    zza(t);
                    break;
            }
        }
    }

    public void disconnect() {
        this.xs.incrementAndGet();
        synchronized (this.xl) {
            int size = this.xl.size();
            for (int i = 0; i < size; i++) {
                ((zze) this.xl.get(i)).zzasc();
            }
            this.xl.clear();
        }
        synchronized (this.xh) {
            this.xi = null;
        }
        zzb(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        synchronized (this.zzail) {
            i = this.xn;
            t = this.xk;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.println("null");
        } else {
            printWriter.append(zzrb()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.xd > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.xd;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.xd)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.xc > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.xb) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.xb));
                    break;
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.xc;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.xc)));
            append2.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j2).append(" ").append(valueOf2).toString());
        }
        if (this.xf > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.xe));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.xf;
            String valueOf3 = String.valueOf(simpleDateFormat.format(new Date(this.xf)));
            append3.println(new StringBuilder(String.valueOf(valueOf3).length() + 21).append(j3).append(" ").append(valueOf3).toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzahv;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzail) {
            z = this.xn == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzail) {
            z = this.xn == 2;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.xe = connectionResult.getErrorCode();
        this.xf = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionSuspended(int i) {
        this.xb = i;
        this.xc = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void zza(int i, @Nullable Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i2, -1, new zzk(i, bundle)));
    }

    /* access modifiers changed from: protected */
    @BinderThread
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzj(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zza(@NonNull T t) {
        this.xd = System.currentTimeMillis();
    }

    public void zza(@NonNull zzf zzf2) {
        this.xj = (zzf) zzab.zzb(zzf2, (Object) "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    public void zza(zzf zzf2, ConnectionResult connectionResult) {
        this.xj = (zzf) zzab.zzb(zzf2, (Object) "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.xs.get(), connectionResult.getErrorCode(), connectionResult.getResolution()));
    }

    @WorkerThread
    public void zza(zzq zzq, Set<Scope> set) {
        try {
            GetServiceRequest zzn = new GetServiceRequest(this.xq).zzhm(this.mContext.getPackageName()).zzn(zzaeu());
            if (set != null) {
                zzn.zzf(set);
            }
            if (zzafk()) {
                zzn.zzd(zzaru()).zzb(zzq);
            } else if (zzarx()) {
                zzn.zzd(getAccount());
            }
            synchronized (this.xh) {
                if (this.xi != null) {
                    this.xi.zza((zzt) new zzg(this, this.xs.get()), zzn);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzfy(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    /* access modifiers changed from: protected */
    public Bundle zzaeu() {
        return new Bundle();
    }

    public boolean zzafk() {
        return false;
    }

    public boolean zzafz() {
        return false;
    }

    public Intent zzaga() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public Bundle zzamc() {
        return null;
    }

    public boolean zzanr() {
        return true;
    }

    @Nullable
    public IBinder zzans() {
        IBinder asBinder;
        synchronized (this.xh) {
            asBinder = this.xi == null ? null : this.xi.asBinder();
        }
        return asBinder;
    }

    /* access modifiers changed from: protected */
    public String zzarp() {
        return "com.google.android.gms";
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzarq() {
        return this.xr == null ? this.mContext.getClass().getName() : this.xr;
    }

    public void zzart() {
        int isGooglePlayServicesAvailable = this.tp.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zzb(1, null);
            this.xj = new zzi();
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.xs.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza((zzf) new zzi());
    }

    public final Account zzaru() {
        return getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
    }

    /* access modifiers changed from: protected */
    public final void zzarv() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzarw() throws DeadObjectException {
        T t;
        synchronized (this.zzail) {
            if (this.xn == 4) {
                throw new DeadObjectException();
            }
            zzarv();
            zzab.zza(this.xk != null, (Object) "Client is connected but service is null");
            t = this.xk;
        }
        return t;
    }

    public boolean zzarx() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> zzary() {
        return Collections.EMPTY_SET;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zzbb(IBinder iBinder);

    /* access modifiers changed from: 0000 */
    public void zzc(int i, T t) {
    }

    public void zzfy(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.xs.get(), i));
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzra();

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzrb();
}
