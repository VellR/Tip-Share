package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;
import com.google.android.gms.common.util.zze;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class zzad extends zzaa {
    /* access modifiers changed from: private */
    public final zza anl;
    /* access modifiers changed from: private */
    public zzm anm;
    private Boolean ann;
    private final zzf ano;
    private final zzah anp;
    private final List<Runnable> anq = new ArrayList();
    private final zzf anr;

    protected class zza implements ServiceConnection, zzb, zzc {
        /* access modifiers changed from: private */
        public volatile boolean anu;
        private volatile zzo anv;

        protected zza() {
        }

        @MainThread
        public void onConnected(@Nullable Bundle bundle) {
            zzab.zzhj("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    final zzm zzm = (zzm) this.anv.zzarw();
                    this.anv = null;
                    zzad.this.zzbsy().zzl(new Runnable() {
                        public void run() {
                            synchronized (zza.this) {
                                zza.this.anu = false;
                                if (!zzad.this.isConnected()) {
                                    zzad.this.zzbsz().zzbtx().log("Connected to remote service");
                                    zzad.this.zza(zzm);
                                }
                            }
                        }
                    });
                } catch (DeadObjectException | IllegalStateException e) {
                    this.anv = null;
                    this.anu = false;
                }
            }
        }

        @MainThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzab.zzhj("MeasurementServiceConnection.onConnectionFailed");
            zzp zzbul = zzad.this.aja.zzbul();
            if (zzbul != null) {
                zzbul.zzbtt().zzj("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.anu = false;
                this.anv = null;
            }
        }

        @MainThread
        public void onConnectionSuspended(int i) {
            zzab.zzhj("MeasurementServiceConnection.onConnectionSuspended");
            zzad.this.zzbsz().zzbtx().log("Service connection suspended");
            zzad.this.zzbsy().zzl(new Runnable() {
                public void run() {
                    zzad.this.onServiceDisconnected(new ComponentName(zzad.this.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                }
            });
        }

        @MainThread
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzab.zzhj("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.anu = false;
                    zzad.this.zzbsz().zzbtr().log("Service connected with null binder");
                    return;
                }
                final zzm zzm = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        zzm = com.google.android.gms.measurement.internal.zzm.zza.zzjb(iBinder);
                        zzad.this.zzbsz().zzbty().log("Bound to IMeasurementService interface");
                    } else {
                        zzad.this.zzbsz().zzbtr().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    zzad.this.zzbsz().zzbtr().log("Service connect failed to get IMeasurementService");
                }
                if (zzm == null) {
                    this.anu = false;
                    try {
                        com.google.android.gms.common.stats.zzb.zzaut().zza(zzad.this.getContext(), (ServiceConnection) zzad.this.anl);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    zzad.this.zzbsy().zzl(new Runnable() {
                        public void run() {
                            synchronized (zza.this) {
                                zza.this.anu = false;
                                if (!zzad.this.isConnected()) {
                                    zzad.this.zzbsz().zzbty().log("Connected to service");
                                    zzad.this.zza(zzm);
                                }
                            }
                        }
                    });
                }
            }
        }

        @MainThread
        public void onServiceDisconnected(final ComponentName componentName) {
            zzab.zzhj("MeasurementServiceConnection.onServiceDisconnected");
            zzad.this.zzbsz().zzbtx().log("Service disconnected");
            zzad.this.zzbsy().zzl(new Runnable() {
                public void run() {
                    zzad.this.onServiceDisconnected(componentName);
                }
            });
        }

        @WorkerThread
        public void zzbvs() {
            zzad.this.zzwu();
            Context context = zzad.this.getContext();
            synchronized (this) {
                if (this.anu) {
                    zzad.this.zzbsz().zzbty().log("Connection attempt already in progress");
                } else if (this.anv != null) {
                    zzad.this.zzbsz().zzbty().log("Already awaiting connection attempt");
                } else {
                    this.anv = new zzo(context, Looper.getMainLooper(), this, this);
                    zzad.this.zzbsz().zzbty().log("Connecting to remote service");
                    this.anu = true;
                    this.anv.zzart();
                }
            }
        }

        @WorkerThread
        public void zzx(Intent intent) {
            zzad.this.zzwu();
            Context context = zzad.this.getContext();
            com.google.android.gms.common.stats.zzb zzaut = com.google.android.gms.common.stats.zzb.zzaut();
            synchronized (this) {
                if (this.anu) {
                    zzad.this.zzbsz().zzbty().log("Connection attempt already in progress");
                    return;
                }
                this.anu = true;
                zzaut.zza(context, intent, (ServiceConnection) zzad.this.anl, 129);
            }
        }
    }

    protected zzad(zzx zzx) {
        super(zzx);
        this.anp = new zzah(zzx.zzyw());
        this.anl = new zza();
        this.ano = new zzf(zzx) {
            public void run() {
                zzad.this.zzzu();
            }
        };
        this.anr = new zzf(zzx) {
            public void run() {
                zzad.this.zzbsz().zzbtt().log("Tasks have been queued for a long time");
            }
        };
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void onServiceDisconnected(ComponentName componentName) {
        zzwu();
        if (this.anm != null) {
            this.anm = null;
            zzbsz().zzbty().zzj("Disconnected from device MeasurementService", componentName);
            zzbvq();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zza(zzm zzm) {
        zzwu();
        zzab.zzaa(zzm);
        this.anm = zzm;
        zzzt();
        zzbvr();
    }

    private boolean zzbvo() {
        List queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    @WorkerThread
    private void zzbvq() {
        zzwu();
        zzaai();
    }

    @WorkerThread
    private void zzbvr() {
        zzwu();
        zzbsz().zzbty().zzj("Processing queued up service tasks", Integer.valueOf(this.anq.size()));
        for (Runnable zzl : this.anq) {
            zzbsy().zzl(zzl);
        }
        this.anq.clear();
        this.anr.cancel();
    }

    @WorkerThread
    private void zzn(Runnable runnable) throws IllegalStateException {
        zzwu();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.anq.size()) >= zzbtb().zzbsd()) {
            zzbsz().zzbtr().log("Discarding data. Max runnable queue size reached");
        } else {
            this.anq.add(runnable);
            if (!this.aja.zzbuu()) {
                this.anr.zzv(60000);
            }
            zzaai();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzzt() {
        zzwu();
        this.anp.start();
        if (!this.aja.zzbuu()) {
            this.ano.zzv(zzbtb().zzabx());
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzzu() {
        zzwu();
        if (isConnected()) {
            zzbsz().zzbty().log("Inactivity, disconnecting from AppMeasurementService");
            disconnect();
        }
    }

    @WorkerThread
    public void disconnect() {
        zzwu();
        zzzg();
        try {
            com.google.android.gms.common.stats.zzb.zzaut().zza(getContext(), (ServiceConnection) this.anl);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        this.anm = null;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public boolean isConnected() {
        zzwu();
        zzzg();
        return this.anm != null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zza(final UserAttributeParcel userAttributeParcel) {
        zzwu();
        zzzg();
        zzn(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.anm;
                if (zzc == null) {
                    zzad.this.zzbsz().zzbtr().log("Discarding data. Failed to set user attribute");
                    return;
                }
                try {
                    zzc.zza(userAttributeParcel, zzad.this.zzbsr().zzlw(zzad.this.zzbsz().zzbtz()));
                    zzad.this.zzzt();
                } catch (RemoteException e) {
                    zzad.this.zzbsz().zzbtr().zzj("Failed to send attribute to AppMeasurementService", e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zza(final AtomicReference<List<UserAttributeParcel>> atomicReference, final boolean z) {
        zzwu();
        zzzg();
        zzn(new Runnable() {
            /* JADX INFO: finally extract failed */
            public void run() {
                synchronized (atomicReference) {
                    try {
                        zzm zzc = zzad.this.anm;
                        if (zzc == null) {
                            zzad.this.zzbsz().zzbtr().log("Failed to get user properties");
                            atomicReference.notify();
                            return;
                        }
                        atomicReference.set(zzc.zza(zzad.this.zzbsr().zzlw(null), z));
                        zzad.this.zzzt();
                        atomicReference.notify();
                    } catch (RemoteException e) {
                        zzad.this.zzbsz().zzbtr().zzj("Failed to get user properties", e);
                        atomicReference.notify();
                    } catch (Throwable th) {
                        atomicReference.notify();
                        throw th;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzaai() {
        zzwu();
        zzzg();
        if (!isConnected()) {
            if (this.ann == null) {
                this.ann = zzbta().zzbuf();
                if (this.ann == null) {
                    zzbsz().zzbty().log("State of service unknown");
                    this.ann = Boolean.valueOf(zzbvp());
                    zzbta().zzca(this.ann.booleanValue());
                }
            }
            if (this.ann.booleanValue()) {
                zzbsz().zzbty().log("Using measurement service");
                this.anl.zzbvs();
            } else if (!this.aja.zzbuu() && zzbvo()) {
                zzbsz().zzbty().log("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.anl.zzx(intent);
            } else if (zzbtb().zzabd()) {
                zzbsz().zzbty().log("Using direct local measurement implementation");
                zza((zzm) new zzy(this.aja, true));
            } else {
                zzbsz().zzbtr().log("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    public /* bridge */ /* synthetic */ void zzbso() {
        super.zzbso();
    }

    public /* bridge */ /* synthetic */ zzc zzbsp() {
        return super.zzbsp();
    }

    public /* bridge */ /* synthetic */ zzac zzbsq() {
        return super.zzbsq();
    }

    public /* bridge */ /* synthetic */ zzn zzbsr() {
        return super.zzbsr();
    }

    public /* bridge */ /* synthetic */ zzg zzbss() {
        return super.zzbss();
    }

    public /* bridge */ /* synthetic */ zzad zzbst() {
        return super.zzbst();
    }

    public /* bridge */ /* synthetic */ zze zzbsu() {
        return super.zzbsu();
    }

    public /* bridge */ /* synthetic */ zzal zzbsv() {
        return super.zzbsv();
    }

    public /* bridge */ /* synthetic */ zzv zzbsw() {
        return super.zzbsw();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsx() {
        return super.zzbsx();
    }

    public /* bridge */ /* synthetic */ zzw zzbsy() {
        return super.zzbsy();
    }

    public /* bridge */ /* synthetic */ zzp zzbsz() {
        return super.zzbsz();
    }

    public /* bridge */ /* synthetic */ zzt zzbta() {
        return super.zzbta();
    }

    public /* bridge */ /* synthetic */ zzd zzbtb() {
        return super.zzbtb();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzbvk() {
        zzwu();
        zzzg();
        zzn(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.anm;
                if (zzc == null) {
                    zzad.this.zzbsz().zzbtr().log("Discarding data. Failed to send app launch");
                    return;
                }
                try {
                    zzc.zza(zzad.this.zzbsr().zzlw(zzad.this.zzbsz().zzbtz()));
                    zzad.this.zzzt();
                } catch (RemoteException e) {
                    zzad.this.zzbsz().zzbtr().zzj("Failed to send app launch to AppMeasurementService", e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzbvn() {
        zzwu();
        zzzg();
        zzn(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.anm;
                if (zzc == null) {
                    zzad.this.zzbsz().zzbtr().log("Failed to send measurementEnabled to service");
                    return;
                }
                try {
                    zzc.zzb(zzad.this.zzbsr().zzlw(zzad.this.zzbsz().zzbtz()));
                    zzad.this.zzzt();
                } catch (RemoteException e) {
                    zzad.this.zzbsz().zzbtr().zzj("Failed to send measurementEnabled to AppMeasurementService", e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public boolean zzbvp() {
        zzwu();
        zzzg();
        if (zzbtb().zzabc()) {
            return true;
        }
        zzbsz().zzbty().log("Checking service availability");
        switch (com.google.android.gms.common.zzc.zzand().isGooglePlayServicesAvailable(getContext())) {
            case 0:
                zzbsz().zzbty().log("Service available");
                return true;
            case 1:
                zzbsz().zzbty().log("Service missing");
                return false;
            case 2:
                zzbsz().zzbtx().log("Service container out of date");
                return true;
            case 3:
                zzbsz().zzbtt().log("Service disabled");
                return false;
            case 9:
                zzbsz().zzbtt().log("Service invalid");
                return false;
            case 18:
                zzbsz().zzbtt().log("Service updating");
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzc(final EventParcel eventParcel, final String str) {
        zzab.zzaa(eventParcel);
        zzwu();
        zzzg();
        zzn(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.anm;
                if (zzc == null) {
                    zzad.this.zzbsz().zzbtr().log("Discarding data. Failed to send event to service");
                    return;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        zzc.zza(eventParcel, zzad.this.zzbsr().zzlw(zzad.this.zzbsz().zzbtz()));
                    } else {
                        zzc.zza(eventParcel, str, zzad.this.zzbsz().zzbtz());
                    }
                    zzad.this.zzzt();
                } catch (RemoteException e) {
                    zzad.this.zzbsz().zzbtr().zzj("Failed to send event to AppMeasurementService", e);
                }
            }
        });
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    /* access modifiers changed from: protected */
    public void zzwv() {
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
