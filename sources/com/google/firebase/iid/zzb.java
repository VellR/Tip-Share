package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb extends Service {
    private int aay;
    private int aaz = 0;
    MessengerCompat abV = new MessengerCompat((Handler) new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int zzc = MessengerCompat.zzc(message);
            zzf.zzdi(zzb.this);
            zzb.this.getPackageManager();
            if (zzc == zzf.ach || zzc == zzf.acg) {
                zzb.this.zzm((Intent) message.obj);
                return;
            }
            int i = zzf.acg;
            Log.w("FirebaseInstanceId", "Message from unexpected caller " + zzc + " mine=" + i + " appid=" + zzf.ach);
        }
    });
    final ExecutorService axF = Executors.newSingleThreadExecutor();
    private final Object zzail = new Object();

    public final IBinder onBind(Intent intent) {
        if (intent == null || !"com.google.firebase.INSTANCE_ID_EVENT".equals(intent.getAction())) {
            return null;
        }
        return this.abV.getBinder();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.zzail) {
            this.aay = i2;
            this.aaz++;
        }
        Intent zzz = zzz(intent);
        if (zzz == null) {
            zzbmb();
            return 2;
        }
        try {
            int zzaa = zzaa(zzz);
        } finally {
            if (zzz.getStringExtra("from") != null) {
                WakefulBroadcastReceiver.completeWakefulIntent(zzz);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int zzaa(final Intent intent) {
        this.axF.execute(new Runnable() {
            public void run() {
                zzb.this.zzm(intent);
                zzb.this.zzbmb();
            }
        });
        return 3;
    }

    /* access modifiers changed from: protected */
    public void zzbmb() {
        synchronized (this.zzail) {
            this.aaz--;
            if (this.aaz == 0) {
                zzsh(this.aay);
            }
        }
    }

    public abstract void zzm(Intent intent);

    /* access modifiers changed from: 0000 */
    public boolean zzsh(int i) {
        return stopSelfResult(i);
    }

    /* access modifiers changed from: protected */
    public abstract Intent zzz(Intent intent);
}
