package com.google.firebase.iid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.firebase.FirebaseApp;
import java.io.IOException;

public class FirebaseInstanceIdService extends zzb {
    private static BroadcastReceiver baK;
    private static final Object baL = new Object();
    private static boolean baM = false;
    /* access modifiers changed from: private */
    public boolean baN = false;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r3.zzcwx().zzcxc() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        zzek(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r3.zzcwv() == null) goto L_0x001a;
     */
    static void zza(Context context, FirebaseInstanceId firebaseInstanceId) {
        synchronized (baL) {
            if (baM) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0087 A[Catch:{ IOException -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a3 A[SYNTHETIC, Splitter:B:49:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x006a A[SYNTHETIC] */
    private void zza(Intent intent, boolean z) {
        synchronized (baL) {
            baM = false;
        }
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        zze zzcwx = instance.zzcwx();
        if (instance.zzcwv() == null) {
            try {
                if (instance.zzcww() != null) {
                    if (this.baN) {
                        Log.d("FirebaseInstanceId", "get master token succeeded");
                    }
                    zza((Context) this, instance);
                    onTokenRefresh();
                    return;
                }
                zzd(intent, "returned token is null");
            } catch (IOException e) {
                zzd(intent, e.getMessage());
            } catch (SecurityException e2) {
                Log.e("FirebaseInstanceId", "Unable to get master token", e2);
            }
        } else {
            for (String zzcxc = zzcwx.zzcxc(); zzcxc != null; zzcxc = zzcwx.zzcxc()) {
                String[] split = zzcxc.split("!");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    char c = 65535;
                    try {
                        switch (str.hashCode()) {
                            case 83:
                                if (str.equals("S")) {
                                    c = 0;
                                }
                            case 85:
                                if (str.equals("U")) {
                                    c = 1;
                                }
                                switch (c) {
                                    case 0:
                                        FirebaseInstanceId.getInstance().zzsg(str2);
                                        if (!this.baN) {
                                            break;
                                        } else {
                                            Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                                            break;
                                        }
                                    case 1:
                                        FirebaseInstanceId.getInstance().zzsh(str2);
                                        if (!this.baN) {
                                            break;
                                        } else {
                                            Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                                            break;
                                        }
                                }
                        }
                        switch (c) {
                            case 0:
                                break;
                            case 1:
                                break;
                        }
                    } catch (IOException e3) {
                        zzd(intent, e3.getMessage());
                        return;
                    }
                }
                zzcwx.zzsj(zzcxc);
            }
            Log.d("FirebaseInstanceId", "topic sync succeeded");
        }
    }

    private String zzac(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    /* access modifiers changed from: private */
    public static Intent zzadr(int i) {
        Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return FirebaseInstanceIdInternalReceiver.zzh(applicationContext, intent);
    }

    private void zzads(int i) {
        ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (i * CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT)), PendingIntent.getBroadcast(this, 0, zzadr(i * 2), 268435456));
    }

    private int zzb(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        if (intExtra < 10 && !z) {
            return 30;
        }
        if (intExtra < 10) {
            return 10;
        }
        if (intExtra > 28800) {
            return 28800;
        }
        return intExtra;
    }

    private void zzd(Intent intent, String str) {
        boolean zzel = zzel(this);
        final int zzb = zzb(intent, zzel);
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(zzb).append("s").toString());
        synchronized (baL) {
            zzads(zzb);
            baM = true;
        }
        if (!zzel) {
            if (this.baN) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            if (baK == null) {
                baK = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        if (FirebaseInstanceIdService.zzel(context)) {
                            if (FirebaseInstanceIdService.this.baN) {
                                Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                            }
                            FirebaseInstanceIdService.this.getApplicationContext().unregisterReceiver(this);
                            context.sendBroadcast(FirebaseInstanceIdService.zzadr(zzb));
                        }
                    }
                };
            }
            getApplicationContext().registerReceiver(baK, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    static void zzek(Context context) {
        synchronized (baL) {
            if (!baM) {
                context.sendBroadcast(zzadr(0));
                baM = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzel(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private zzd zzsi(String str) {
        if (str == null) {
            return zzd.zzb(this, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return zzd.zzb(this, bundle);
    }

    @WorkerThread
    public void onTokenRefresh() {
    }

    /* access modifiers changed from: protected */
    public int zzaa(Intent intent) {
        this.baN = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return super.zzaa(intent);
        }
        String zzac = zzac(intent);
        if (this.baN) {
            String str = "FirebaseInstanceId";
            String str2 = "Register result in service ";
            String valueOf = String.valueOf(zzac);
            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        zzsi(zzac).zzcxb().zzu(intent);
        zzbmb();
        return 2;
    }

    public void zzab(Intent intent) {
        String zzac = zzac(intent);
        zzd zzsi = zzsi(zzac);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.baN) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(zzac).length() + 18 + String.valueOf(stringExtra).length() + String.valueOf(valueOf).length()).append("Service command ").append(zzac).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            zzg zzcxa = zzsi.zzcxa();
            if (zzac == null) {
                zzac = "";
            }
            zzcxa.zzkk(zzac);
            zzsi.zzcxb().zzu(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            zzsi.zzcxa().zzkk(zzac);
            zza(intent, false);
        } else if ("RST".equals(stringExtra)) {
            zzsi.zzbmu();
            zza(intent, true);
        } else if ("RST_FULL".equals(stringExtra)) {
            if (!zzsi.zzcxa().isEmpty()) {
                zzsi.zzcxa().zzbna();
                zza(intent, true);
            }
        } else if ("SYNC".equals(stringExtra)) {
            zzsi.zzcxa().zzkk(zzac);
            zza(intent, false);
        } else {
            if ("PING".equals(stringExtra)) {
            }
        }
    }

    public void zzm(Intent intent) {
        boolean z;
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        switch (action.hashCode()) {
            case -1737547627:
                if (action.equals("ACTION_TOKEN_REFRESH_RETRY")) {
                    z = false;
                    break;
                }
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                zza(intent, false);
                return;
            default:
                zzab(intent);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public Intent zzz(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.zzcwy();
    }
}
